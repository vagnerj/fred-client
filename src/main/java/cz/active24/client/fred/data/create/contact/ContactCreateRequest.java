package cz.active24.client.fred.data.create.contact;

import cz.active24.client.fred.data.EppRequest;
import cz.active24.client.fred.data.common.contact.AddressData;
import cz.active24.client.fred.data.common.contact.DiscloseData;
import cz.active24.client.fred.data.common.contact.IdentificationData;
import cz.active24.client.fred.data.common.contact.PostalInfoData;
import cz.active24.client.fred.data.create.CreateRequest;
import cz.active24.client.fred.eppclient.objectstrategy.ServerObjectType;

import java.io.Serializable;

/**
 * A contact create command is used to register a new contact.
 *
 * <ul>
 * <li>{@link ContactCreateRequest#contactId} - the contact handle</li>
 * <li>{@link ContactCreateRequest#postalInfoData} - contact’s postal information, see {@link PostalInfoData}</li>
 * <li>{@link ContactCreateRequest#voice} - telephone number</li>
 * <li>{@link ContactCreateRequest#fax} - fax number</li>
 * <li>{@link ContactCreateRequest#email} - a comma-separated list of email addresses</li>
 * <li>{@link ContactCreateRequest#authInfo} - authorization information (transfer password); if omitted, the password will be generated by the server</li>
 * <li>{@link ContactCreateRequest#disclose} - contact information disclosure settings, see {@link DiscloseData}</li>
 * <li>{@link ContactCreateRequest#vat} - VAT-payer identifier</li>
 * <li>{@link ContactCreateRequest#ident} - identity-document identification, see {@link IdentificationData}</li>
 * <li>{@link ContactCreateRequest#notifyEmail} - a comma-separated list of notification email address(es)</li>
 * <li>{@link ContactCreateRequest#mailingAddress} - mailing address extension</li>
 * </ul>
 *
 * @see <a href="https://fred.nic.cz/documentation/html/EPPReference/CommandStructure/Create/CreateContact.html">FRED documentation</a>
 */
public class ContactCreateRequest extends EppRequest implements Serializable, CreateRequest {

    private String contactId;

    private PostalInfoData postalInfoData;

    private String voice;

    private String fax;

    private String email;

    private String authInfo;

    private DiscloseData disclose;

    private String vat;

    private IdentificationData ident;

    private String notifyEmail;

    private AddressData mailingAddress;

    public ContactCreateRequest(String contactId, PostalInfoData postalInfoData, String email) {
        setServerObjectType(ServerObjectType.CONTACT);

        this.setContactId(contactId);
        this.setPostalInfoData(postalInfoData);
        this.setEmail(email);
    }

    public String getContactId() {
        return contactId;
    }

    protected void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public PostalInfoData getPostalInfoData() {
        return postalInfoData;
    }

    protected void setPostalInfoData(PostalInfoData postalInfoData) {
        this.postalInfoData = postalInfoData;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    public DiscloseData getDisclose() {
        return disclose;
    }

    public void setDisclose(DiscloseData disclose) {
        this.disclose = disclose;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public IdentificationData getIdent() {
        return ident;
    }

    public void setIdent(IdentificationData ident) {
        this.ident = ident;
    }

    public String getNotifyEmail() {
        return notifyEmail;
    }

    public void setNotifyEmail(String notifyEmail) {
        this.notifyEmail = notifyEmail;
    }

    public AddressData getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(AddressData mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ContactCreateRequest{");
        sb.append("contactId='").append(contactId).append('\'');
        sb.append(", postalInfo=").append(postalInfoData);
        sb.append(", voice='").append(voice).append('\'');
        sb.append(", fax='").append(fax).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", authInfo='").append(authInfo).append('\'');
        sb.append(", disclose=").append(disclose);
        sb.append(", vat='").append(vat).append('\'');
        sb.append(", ident=").append(ident);
        sb.append(", notifyEmail='").append(notifyEmail).append('\'');
        sb.append(", mailingAddress=").append(mailingAddress);
        sb.append('}');
        return sb.toString();
    }
}
