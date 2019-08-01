package careeratlas.backend.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobResponse {

    private String company;
    private String jobtitle;
    private String jobkey;
    private String longitude;
    private String latitude;
    private String url;
    private String snippet;

    public JobResponse(@JsonProperty("company") String company, @JsonProperty("jobtitle") String jobtitle, @JsonProperty("jobkey") String jobkey, @JsonProperty("longitude") String longitude, @JsonProperty("latitude") String latitude,@JsonProperty("url") String url, @JsonProperty("snippet") String snippet) {
        this.company = company;
        this.jobtitle = jobtitle;
        this.jobkey = jobkey;
        this.longitude = longitude;
        this.latitude = latitude;
        this.url = url;
        this.snippet = snippet;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }
}
