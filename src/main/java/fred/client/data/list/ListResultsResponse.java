package fred.client.data.list;

import fred.client.data.EppRequest;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

/**
 * Response contains loaded data prepared by specific request.
 * <p>
 * <ul>
 * <li>
 * {@link ListResultsResponse#results} - loaded data.
 * </li>
 * </ul>
 *
 * @see <a href="https://fred.nic.cz/documentation/html/EPPReference/CommandStructure/List/GetResults.html#response-element-structure">FRED documentation</a>
 */
public class ListResultsResponse extends EppRequest implements Serializable, ListResponse {

    private Collection<String> results;

    public ListResultsResponse() {
        results = new HashSet<String>();
    }

    public Collection<String> getResults() {
        return results;
    }

    public void setResults(Collection<String> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ListResultsResponse{");
        sb.append("results=").append(results);
        sb.append(", clientTransactionId='").append(getClientTransactionId()).append('\'');
        sb.append(", serverObjectType=").append(getServerObjectType());
        sb.append('}');
        return sb.toString();
    }
}