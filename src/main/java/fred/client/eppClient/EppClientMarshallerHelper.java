package fred.client.eppClient;

import fred.client.exception.SchemaValidationException;
import fred.client.exception.SystemException;
import ietf.params.xml.ns.epp_1.EppType;
import ietf.params.xml.ns.epp_1.ObjectFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.util.Arrays;
import java.util.Properties;

/**
 * Helper class to marshal and unmarshal requests and responses.
 */
public class EppClientMarshallerHelper {

    private static final Log log = LogFactory.getLog(EppClientMarshallerHelper.class);

    private JAXBContext jaxbContext;

    private Schema schema;

    private Properties properties;

    public EppClientMarshallerHelper(Properties properties) {
        this.properties = properties;
    }

    public Object unmarshal(Node node) throws SystemException, SchemaValidationException {

        Unmarshaller jaxbUnmarshaller = this.getUnmarshaller();

        try {
            return JAXBIntrospector.getValue(jaxbUnmarshaller.unmarshal(node));
        } catch (JAXBException e) {
            if (e.getLinkedException() instanceof SAXParseException) {
                String message = "Provided data are wrong, validation against schema failed!";
                log.error(message, e);
                throw new SchemaValidationException(message, e.getMessage(), e);
            }
            log.error("Something happen when unmarshalling data from xml!", e);
            throw new SystemException(e.getMessage(), e);
        }

    }

    EppType unmarshal(String xml) throws SystemException, SchemaValidationException {
        Unmarshaller jaxbUnmarshaller = this.getUnmarshaller();

        try {
            return (EppType) JAXBIntrospector.getValue(jaxbUnmarshaller.unmarshal(new StringReader(xml)));
        } catch (JAXBException e) {
            if (e.getLinkedException() instanceof SAXParseException) {
                String message = "Response data are wrong, validation against schema failed!";
                log.error(message, e);
                throw new SchemaValidationException(message, e.getMessage(), e);
            }
            log.error("Something happen when unmarshalling data from xml!", e);
            throw new SystemException(e.getMessage(), e);
        }
    }

    String marshal(Object command) throws SystemException, SchemaValidationException {
        try {
            StringWriter result = new StringWriter();
            JAXBContext jaxbContext = getJaxbContext();
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            if (validateSchema()) {
                jaxbMarshaller.setSchema(getSchema());
            }

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(command, result);
            return result.toString();
        } catch (JAXBException e) {
            if (e.getLinkedException() instanceof SAXParseException) {
                String message = "Provided data are wrong, validation against schema failed!";
                log.error(message, e);
                throw new SchemaValidationException(message, e.getMessage(), e);
            }
            log.error("Something happen when marshalling data into xml!", e);
            throw new SystemException(e.getMessage(), e);
        } catch (SAXException e) {
            String message = "Schema loading failed!";
            log.error(message, e);
            throw new SystemException(e.getMessage(), e);
        }
    }

    private boolean validateSchema() {
        return properties.getProperty("schema.validation").equalsIgnoreCase("true");
    }

    private Unmarshaller getUnmarshaller() throws SystemException {
        try {
            JAXBContext jaxbContext = getJaxbContext();
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            if (validateSchema()) {
                jaxbUnmarshaller.setSchema(getSchema());
            }

            return jaxbUnmarshaller;
        } catch (JAXBException e) {
            log.error("Something happen when creating unmarshaller", e);
            throw new SystemException(e.getMessage(), e);
        } catch (SAXException e) {
            String message = "Schema loading failed!";
            log.error(message, e);
            throw new SystemException(e.getMessage(), e);
        }
    }

    private JAXBContext getJaxbContext() throws JAXBException {
        if (jaxbContext == null) {
            jaxbContext = JAXBContext.newInstance(getObjectFactories());
        }
        return jaxbContext;
    }

    Schema getSchema() throws SAXException {
        if (schema == null) {

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            this.schema = schemaFactory.newSchema(new Source[]{
                    new StreamSource(new File(properties.getProperty("schema.location")))
            });
        }

        return schema;
    }

    private Class[] getObjectFactories() {
        return (Class[]) Arrays.asList(
                ObjectFactory.class,
                cz.nic.xml.epp.domain_1.ObjectFactory.class,
                cz.nic.xml.epp.nsset_1.ObjectFactory.class,
                cz.nic.xml.epp.contact_1.ObjectFactory.class,
                cz.nic.xml.epp.keyset_1.ObjectFactory.class,
                cz.nic.xml.epp.enumval_1.ObjectFactory.class,
                cz.nic.xml.epp.fred_1.ObjectFactory.class,
                cz.nic.xml.epp.extra_addr_1.ObjectFactory.class,
                cz.nic.xml.epp.fredcom_1.ObjectFactory.class,
                ietf.params.xml.ns.eppcom_1.ObjectFactory.class
        ).toArray();
    }

    public static void main(String[] args) throws SAXException, IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("/home/radekn/IdeaProjects/fred-client-github/src/main/resources/fred-client.properties"));

        EppClientMarshallerHelper helper = new EppClientMarshallerHelper(properties);
        Schema schema = helper.getSchema();

        Validator val = schema.newValidator();
        System.out.println(val.toString());
    }

}
