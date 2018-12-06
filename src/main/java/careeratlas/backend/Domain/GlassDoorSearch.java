package careeratlas.backend.Domain;

//I have left everything in the url hard coded except for what I want to change, all of the properties are to show what can be done with this call
public class GlassDoorSearch {

    private String version = "1";
    private String format = "json";
    private String action = "employers";
    private String company;

    public GlassDoorSearch(String company){
        this.company = company;
    }

    public String getVersion() {
        return version;
    }

    public String getFormat() {
        return format;
    }

    public String getAction() {
        return action;
    }

    public String getCompany() {
        return company;
    }

    public String getUrl() {
        String url = String.format("http://api.glassdoor.com/api/api.htm?v=1&format=json&t.p=%s&t.k=%s&action=employers&q=%s&userip=192.168.43.42", System.getenv("GLASSDOOR_API_ID"), System.getenv("GLASSDOOR_API_KEY"), this.getCompany());
        return url;
    }
}
