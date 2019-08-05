package careeratlas.backend.Domain;

//This class comes from the Indeed api docs which explains the weird variables. The properties are all of the potential variables you can change.
//In my getUrl method I only messed with the variables which I either didn't like the defaults from indeed or needed user input. Depending on your need you might need to change a variable(s) and put it into the url using the string formatter
public class JobSearch {

    private String location;
    private String jobTitle;
    private String distance;
    private String jobType;
    private String format = "json";
    private String jobSite = "jobsite";
    private String limit = "30";
    private String fromage = "any";
    private String latlong = "1";
    private String v = "2";

    public String getLocation() {
        return location;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getDistance() {
        return distance;
    }

    public String getJobType() {
        return jobType;
    }

    public String getFormat() {
        return format;
    }

    public String getJobSite() {
        return jobSite;
    }

    public String getLimit() {
        return limit;
    }

    public String getFromage() {
        return fromage;
    }

    public String getLatlong() {
        return latlong;
    }

    public String getV() {
        return v;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getUrl() {
        String url = String.format("http://api.indeed.com/ads/apisearch?publisher=%s&q=%s&l=%s&sort=&radius=%s&st=&jt=%s&start=&limit=%s&fromage=&filter=&latlong=%s&co=us&format=json&highlight=0&v=%s", System.getenv("INDEED_API_KEY"), this.getJobTitle(), this.getLocation(), this.getDistance(), this.getJobType(), this.getLimit(), this.getLatlong(), this.getV());
        return url;
    }
}
