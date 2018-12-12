package careeratlas.backend.Domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import javax.validation.constraints.NotEmpty;

@JsonAutoDetect
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndeedResponse {

    @JsonProperty
    private String location;
    @JsonProperty
    private String radius;
    @JsonProperty
    private String totalResults;
    @JsonProperty
    @NotEmpty
    private List<JobResponse> results;

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
