package careeratlas.backend.Domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class JobResponse {

    @JsonProperty
    private String company;
    @JsonProperty
    private String jobtitle;
    @JsonProperty
    private String jobkey;
    @JsonProperty
    private String longitude;
    @JsonProperty
    private String latitude;
    @JsonProperty
    private String url;
    @JsonProperty
    private String snippet;

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public JobResponse(String company, String jobtitle, String jobkey, String longitude, String latitude, String url, String snippet) {
        this.company = company;
        this.jobtitle = jobtitle;
        this.jobkey = jobkey;
        this.longitude = longitude;
        this.latitude = latitude;
        this.url = url;
        this.snippet = snippet;
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

    public String getSnippet() {
        return snippet;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getJobkey() {
        return jobkey;
    }

    public void setJobkey(String jobkey) {
        this.jobkey = jobkey;
    }
}
