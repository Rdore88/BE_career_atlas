package careeratlas.backend.Domain;


//This class comes from the Indeed api docs which explains the weird variables
public class JobSearch {

    private String l;
    private String q;
    private String radius;
    private String jt;
    private String format = "json";
    private String st = "jobsite";
    private String limit = "30";
    private String fromage = "any";
    private String latlong = "1";
    private String v = "2";
    private String publisher = System.getenv("INDEED_API_KEY");

    public JobSearch(String location, String jobTitle, String radius, String jobType){
        this.l = location;
        this.jt = jobType;
        this.q = jobTitle;
        this.radius = radius;
    }

    public String getL() {
        return l;
    }

    public String getQ() {
        return q;
    }

    public String getRadius() {
        return radius;
    }

    public String getJt() {
        return jt;
    }

    public String getFormat() {
        return format;
    }

    public String getSt() {
        return st;
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

    public String getPublisher() {
        return publisher;
    }

}