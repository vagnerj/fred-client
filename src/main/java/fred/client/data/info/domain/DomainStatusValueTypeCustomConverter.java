package fred.client.data.info.domain;

import cz.nic.xml.epp.domain_1.StatusType;
import cz.nic.xml.epp.domain_1.StatusValueType;
import org.dozer.CustomConverter;
import org.dozer.MappingException;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter between {@link cz.nic.xml.epp.domain_1.StatusType} and {@link DomainStatusValueType}.
 */
public class DomainStatusValueTypeCustomConverter implements CustomConverter {

    public Object convert(Object destination, Object source, Class<?> destClass, Class<?> sourceClass) {
        if (source != null && source instanceof List) {
            List sourceList = (List) source;
            if (sourceList.get(0) != null && sourceList.get(0) instanceof StatusType) {
                List<DomainStatusValueType> domainStatuses = new ArrayList<DomainStatusValueType>();
                for (Object statusType : sourceList) {
                    StatusType statusType1 = (StatusType) statusType;
                    domainStatuses.add(DomainStatusValueType.fromValue(statusType1.getS().value()));
                }
                return domainStatuses;
            } else if (sourceList.get(0) != null && sourceList.get(0) instanceof DomainStatusValueType) {
                List<StatusType> statusTypes = new ArrayList<StatusType>();
                for (Object statusType : sourceList) {
                    DomainStatusValueType domainStatus = (DomainStatusValueType) statusType;
                    StatusType statusType2 = new StatusType();
                    statusType2.setS(StatusValueType.fromValue(domainStatus.value()));
                    statusType2.setLang("en");
                    statusTypes.add(statusType2);
                }
                return statusTypes;
            }
        }
        throw new MappingException("Converter " + this.getClass().getSimpleName() + " used incorrectly!");
    }
}
