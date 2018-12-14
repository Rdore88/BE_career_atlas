package careeratlas.backend.Domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import javax.validation.constraints.NotEmpty;

@JsonAutoDetect
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndeedResponse {

    private String location;
    private String radius;
    private String totalResults;
    private List<JobResponse> results;

    @JsonCreator
    public IndeedResponse(@JsonProperty("location") String location, @JsonProperty("radius") String radius, @JsonProperty("totalResults") String totalResults,  @JsonProperty("results") List<JobResponse> results) {
        this.location = location;
        this.radius = radius;
        this.totalResults = totalResults;
        this.results = results;
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
}
