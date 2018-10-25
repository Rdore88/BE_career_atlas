package careeratlas.backend.Domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

@JsonAutoDetect
public class Job {

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

    public Job(String company, String positionTitle, String jobKey, String longitude, String latitude, String url) {
        this.company = company;
        this.positionTitle = positionTitle;
        this.jobKey = jobKey;
        this.longitude = longitude;
        this.latitude = latitude;
        this.url = url;
    }

    public String getJobKey() {
        return jobKey;
    }

    public void setJobKey(String jobKey) {
        this.jobKey = jobKey;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
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

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }
}
