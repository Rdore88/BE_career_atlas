package careeratlas.backend.Domain;


//This class comes from the Indeed api docs which explains the weird variables
public class JobSearch {

    private String location;
    private String jobTitle;
    private String distance;
    private String jobType;
    private String format = "json";
    private String st = "jobsite";
    private String limit = "30";
    private String fromage = "any";
    private String latlong = "1";
    private String v = "2";
    private String publisher = System.getenv("INDEED_API_KEY");

    public JobSearch(String location, String jobTitle, String distance, String jobType){
        this.location = location;
        this.jobType = jobType;
        this.jobTitle = jobTitle;
        this.distance = distance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String l) {
        this.location = l;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String q) {
        this.jobTitle = jobTitle;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jt) {
        this.jobType = jobType;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getFromage() {
        return fromage;
    }

    public void setFromage(String fromage) {
        this.fromage = fromage;
    }

    public String getLatlong() {
        return latlong;
    }

    public void setLatlong(String latlong) {
        this.latlong = latlong;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getUrl() {
        String url = String.format("http://api.indeed.com/ads/apisearch?publisher=%s&q=%s&l=%s&sort=&radius=%s&st=&jt=%s&start=&limit=&fromage=&filter=&latlong=1&co=us&format=json&v=2", System.getenv("INDEED_API_KEY"), this.getJobTitle(), this.getLocation(), this.getDistance(), this.getJobType());
        return url;
    }
}
