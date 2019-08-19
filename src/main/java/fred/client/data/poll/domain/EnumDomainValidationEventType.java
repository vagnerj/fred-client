package fred.client.data.poll.domain;

/**
 * Messages concerning the validation of ENUM domains for events:
 *
 * <p>
 * <ul>
 * <li>{@link EnumDomainValidationEventType#IMPENDING_VAL_EXP_DATA} - domain’s validation is going to expire</li>
 * <li>{@link EnumDomainValidationEventType#VAL_EXP_DATA} - domain’s validation has expired</li>
 * </ul>
 * </p>
 *
 * @see <a href="https://fred.nic.cz/documentation/html/EPPReference/CommandStructure/Poll/MessageTypes.html#enum-domain-validation">FRED documentation</a>
 */
public enum EnumDomainValidationEventType {

    IMPENDING_VAL_EXP_DATA,

    VAL_EXP_DATA
}