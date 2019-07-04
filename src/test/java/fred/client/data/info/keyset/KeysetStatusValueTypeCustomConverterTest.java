package fred.client.data.info.keyset;

import cz.nic.xml.epp.keyset_1.StatusType;
import cz.nic.xml.epp.keyset_1.StatusValueType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test for KeysetStatusValueTypeCustomConverter.
 */
public class KeysetStatusValueTypeCustomConverterTest {

    public KeysetStatusValueTypeCustomConverter target = new KeysetStatusValueTypeCustomConverter();

    @Test
    public void convertContactStatusValueTypeToStatusType() {

        List<KeysetStatusValueType> source = new ArrayList<KeysetStatusValueType>(Arrays.asList(KeysetStatusValueType.values()));

        List<StatusType> destination = (List<StatusType>) target.convert(null, source, List.class, List.class);

        Assert.assertEquals(6, destination.size());
        Assert.assertEquals(source.size(), destination.size());
    }

    @Test
    public void convertStatusTypeToContactStatusValueType() {

        List<StatusType> source = new ArrayList<StatusType>();

        for (StatusValueType value : StatusValueType.values()) {
            StatusType statusType = new StatusType();
            statusType.setLang("en");
            statusType.setS(value);
            source.add(statusType);
        }

        List<KeysetStatusValueType> destination = (List<KeysetStatusValueType>) target.convert(null, source, List.class, List.class);

        Assert.assertEquals(6, destination.size());
        Assert.assertEquals(source.size(), destination.size());
    }
}