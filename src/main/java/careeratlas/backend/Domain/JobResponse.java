package careeratlas.backend.Domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class JobResponse {

    @JsonProperty
    private String company;
    @JsonProperty
    private String positionTitle;
    @JsonProperty
    private String jobKey;
    @JsonProperty
    private String longitude;
    @JsonProperty
    private String latitude;
    @JsonProperty
    private String url;
    @JsonProperty
    private String snippet;

    public JobResponse(String company, String positionTitle, String jobKey, String longitude, String latitude, String url, String snippet) {
        this.company = company;
        this.positionTitle = positionTitle;
        this.jobKey = jobKey;
        this.longitude = longitude;
        this.latitude = latitude;
        this.url = url;
        this.snippet = snippet;
    }

    public String getJobKey() {
        return jobKey;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCompany() {
        return company;
    }

    public String getPositionTitle() {
        return positionTitle;
    }
}
