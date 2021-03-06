package careeratlas.backend.Domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class IndeedResponse {

    private String location;
    private String radius;
    private String totalResults;
    private String query;
    private List<JobResponse> results;

    public IndeedResponse(@JsonProperty("location") String location, @JsonProperty("radius") String radius,
                          @JsonProperty("totalResults") String totalResults,  @JsonProperty("results") List<JobResponse> results,
                          @JsonProperty("query") String query
    ) {
        this.location = location;
        this.radius = radius;
        this.totalResults = totalResults;
        this.results = results;
        this.query = query;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<JobResponse> getResults() {
        return results;
    }

    public void setResults(List<JobResponse> results) {
        this.results = results;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
