package fred.client.eppclient.objectstrategy;

import fred.client.data.check.CheckRequest;
import fred.client.data.check.CheckResponse;
import fred.client.data.create.CreateRequest;
import fred.client.data.create.CreateResponse;
import fred.client.data.creditinfo.other.CreditInfoRequest;
import fred.client.data.creditinfo.other.CreditInfoResponse;
import fred.client.data.delete.DeleteRequest;
import fred.client.data.delete.DeleteResponse;
import fred.client.data.info.InfoRequest;
import fred.client.data.info.InfoResponse;
import fred.client.data.list.ListRequest;
import fred.client.data.list.ListResponse;
import fred.client.data.login.other.LoginRequest;
import fred.client.data.login.other.LoginResponse;
import fred.client.data.logout.other.LogoutRequest;
import fred.client.data.logout.other.LogoutResponse;
import fred.client.data.poll.PollAcknowledgementRequest;
import fred.client.data.poll.PollAcknowledgementResponse;
import fred.client.data.poll.PollRequest;
import fred.client.data.poll.PollResponse;
import fred.client.data.renew.domain.DomainRenewRequest;
import fred.client.data.renew.domain.DomainRenewResponse;
import fred.client.data.sendauthinfo.SendAuthInfoRequest;
import fred.client.data.sendauthinfo.SendAuthInfoResponse;
import fred.client.data.testnsset.nsset.TestNssetRequest;
import fred.client.data.testnsset.nsset.TestNssetResponse;
import fred.client.data.transfer.TransferRequest;
import fred.client.data.transfer.TransferResponse;
import fred.client.data.update.UpdateRequest;
import fred.client.data.update.UpdateResponse;
import fred.client.exception.FredClientException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Default strategy.
 */
public class NotImplementedStrategy implements ServerObjectStrategy {

    private final static Log log = LogFactory.getLog(NotImplementedStrategy.class);

    @Override
    public InfoResponse callInfo(InfoRequest request) throws FredClientException {
        log.error("No strategy found for type " + request.getServerObjectType());
        throw new FredClientException("No strategy found for type " + request.getServerObjectType());
    }

    @Override
    public SendAuthInfoResponse callSendAuthInfo(SendAuthInfoRequest request) throws FredClientException {
        log.error("No strategy found for type " + request.getServerObjectType());
        throw new FredClientException("No strategy found for type " + request.getServerObjectType());
    }

    @Override
    public ListResponse callList(ListRequest request) throws FredClientException {
        log.error("No strategy found for type " + request.getServerObjectType());
        throw new FredClientException("No strategy found for type " + request.getServerObjectType());
    }

    @Override
    public CheckResponse callCheck(CheckRequest request) throws FredClientException {
        log.error("No strategy found for type " + request.getServerObjectType());
        throw new FredClientException("No strategy found for type " + request.getServerObjectType());
    }

    @Override
    public CreateResponse callCreate(CreateRequest request) throws FredClientException {
        log.error("No strategy found for type " + request.getServerObjectType());
        throw new FredClientException("No strategy found for type " + request.getServerObjectType());
    }

    @Override
    public DomainRenewResponse callRenew(DomainRenewRequest request) throws FredClientException {
        log.error("No strategy found for type " + request.getServerObjectType());
        throw new FredClientException("No strategy found for type " + request.getServerObjectType());
    }

    @Override
    public TransferResponse callTransfer(TransferRequest request) throws FredClientException {
        log.error("No strategy found for type " + request.getServerObjectType());
        throw new FredClientException("No strategy found for type " + request.getServerObjectType());
    }

    @Override
    public DeleteResponse callDelete(DeleteRequest request) throws FredClientException {
        log.error("No strategy found for type " + request.getServerObjectType());
        throw new FredClientException("No strategy found for type " + request.getServerObjectType());
    }

    @Override
    public CreditInfoResponse callCreditInfo(CreditInfoRequest request) throws FredClientException {
        log.error("No strategy found for type " + request.getServerObjectType());
        throw new FredClientException("No strategy found for type " + request.getServerObjectType());
    }

    @Override
    public TestNssetResponse callTestNsset(TestNssetRequest request) throws FredClientException {
        log.error("No strategy found for type " + request.getServerObjectType());
        throw new FredClientException("No strategy found for type " + request.getServerObjectType());
    }

    @Override
    public PollResponse callPollRequest(PollRequest request) throws FredClientException {
        log.error("No strategy found for type " + request.getServerObjectType());
        throw new FredClientException("No strategy found for type " + request.getServerObjectType());
    }

    @Override
    public PollAcknowledgementResponse callPollAcknowledgement(PollAcknowledgementRequest request) throws FredClientException {
        log.error("No strategy found for type " + request.getServerObjectType());
        throw new FredClientException("No strategy found for type " + request.getServerObjectType());
    }

    @Override
    public UpdateResponse callUpdate(UpdateRequest request) throws FredClientException {
        log.error("No strategy found for type " + request.getServerObjectType());
        throw new FredClientException("No strategy found for type " + request.getServerObjectType());
    }

    @Override
    public LoginResponse callLogin(LoginRequest request) throws FredClientException {
        log.error("No strategy found for type " + request.getServerObjectType());
        throw new FredClientException("No strategy found for type " + request.getServerObjectType());
    }

    @Override
    public LogoutResponse callLogout(LogoutRequest request) throws FredClientException {
        log.error("No strategy found for type " + request.getServerObjectType());
        throw new FredClientException("No strategy found for type " + request.getServerObjectType());
    }
}