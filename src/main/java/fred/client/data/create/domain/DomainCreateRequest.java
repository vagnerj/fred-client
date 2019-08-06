package fred.client.data.create.domain;

import fred.client.data.EppRequest;
import fred.client.data.common.domain.EnumValData;
import fred.client.data.common.domain.PeriodType;
import fred.client.data.create.CreateRequest;
import fred.client.eppClient.objectStrategy.ServerObjectType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A domain create command is used to register a new domain.
 *
 * <ul>
 * <li>{@link DomainCreateRequest#name} - domain name</li>
 * <li>{@link DomainCreateRequest#period} - the registration period; if omitted, the domain expiration is set to the minimum (FRED’s default: 1 year)</li>
 * <li>{@link DomainCreateRequest#nsset} - an nsset handle to associate/li>
 * <li>{@link DomainCreateRequest#keyset} - the keyset handle to associate</li>
 * <li>{@link DomainCreateRequest#registrant} - the domain owner handle</li>
 * <li>{@link DomainCreateRequest#admin} - an administrative contact handle</li>
 * <li>{@link DomainCreateRequest#authInfo} - authorization information (transfer password); if omitted, the password will be generated by the server</li>
 * </ul>
 *
 * @see <a href="https://fred.nic.cz/documentation/html/EPPReference/CommandStructure/Create/CreateDomain.html">FRED documentation</a>
 */
public class DomainCreateRequest extends EppRequest implements Serializable, CreateRequest {

    private String name;

    private PeriodType period;

    private String nsset;

    private String keyset;

    private String registrant;

    private List<String> admin;

    private String authInfo;

    private EnumValData enumValData;

    public DomainCreateRequest(String domainName, String registrant) {
        setServerObjectType(ServerObjectType.DOMAIN);
        this.name = domainName;
        this.registrant = registrant;

        this.admin = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public PeriodType getPeriod() {
        return period;
    }

    public void setPeriod(PeriodType period) {
        this.period = period;
    }

    public String getNsset() {
        return nsset;
    }

    public void setNsset(String nsset) {
        this.nsset = nsset;
    }

    public String getKeyset() {
        return keyset;
    }

    public void setKeyset(String keyset) {
        this.keyset = keyset;
    }

    public String getRegistrant() {
        return registrant;
    }

    protected void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public List<String> getAdmin() {
        return admin;
    }

    public void setAdmin(List<String> admin) {
        this.admin = admin;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    public EnumValData getEnumValData() {
        return enumValData;
    }

    public void setEnumValData(EnumValData enumValData) {
        this.enumValData = enumValData;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DomainCreateRequest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", period=").append(period);
        sb.append(", nsset='").append(nsset).append('\'');
        sb.append(", keyset='").append(keyset).append('\'');
        sb.append(", registrant='").append(registrant).append('\'');
        sb.append(", admin=").append(admin);
        sb.append(", authInfo='").append(authInfo).append('\'');
        sb.append(", enumValData=").append(enumValData);
        sb.append('}');
        return sb.toString();
    }
}
