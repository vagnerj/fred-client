package fred.client.data.create.contact;

import fred.client.data.EppResponse;
import fred.client.data.create.CreateResponse;
import fred.client.eppClient.objectStrategy.ServerObjectType;

import java.io.Serializable;
import java.util.Date;

/**
 * Response for contact create command.
 *
 * <ul>
 * <li>{@link ContactCreateResponse#id} - the contact handle</li>
 * <li>{@link ContactCreateResponse#crDate} - the timestamp of creation</li>
 * </ul>
 *
 *
 * @see <a href="https://fred.nic.cz/documentation/html/EPPReference/CommandStructure/Create/CreateContact.html">FRED documentation</a>
 */
public class ContactCreateResponse extends EppResponse implements Serializable, CreateResponse {

    private String id;

    private Date crDate;

    public ContactCreateResponse() {
        setServerObjectType(ServerObjectType.CONTACT);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCrDate() {
        return crDate;
    }

    public void setCrDate(Date crDate) {
        this.crDate = crDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ContactCreateResponse{");
        sb.append("id='").append(id).append('\'');
        sb.append(", crDate=").append(crDate);
        sb.append(", clientTransactionId='").append(getClientTransactionId()).append('\'');
        sb.append(", serverTransactionId='").append(getServerTransactionId()).append('\'');
        sb.append(", result=").append(getResult());
        sb.append(", serverObjectType=").append(getServerObjectType());
        sb.append('}');
        return sb.toString();
    }
}
