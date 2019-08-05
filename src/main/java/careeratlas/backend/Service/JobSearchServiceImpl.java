package careeratlas.backend.Service;

import careeratlas.backend.Domain.GlassDoorResponse;
import careeratlas.backend.Domain.GlassDoorSearch;
import careeratlas.backend.Domain.IndeedResponse;
import careeratlas.backend.Domain.JobSearch;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public class JobSearchServiceImpl implements JobSearchService {

    final static private Client client = ClientBuilder.newClient();

    @Override
    public IndeedResponse searchJobs(JobSearch jobSearch){
        try {
            return getJobsFromIneed(jobSearch);
//            future state more will be done here ie save jobSearch, search other sites etc
        } catch (Error e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not fetch Jobs from this request");
        }
    };


    private IndeedResponse getJobsFromIneed(JobSearch jobSearch) {
        WebTarget webTarget = client.target(jobSearch.getUrl());
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        String indeedSearchResults = response.readEntity(String.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        IndeedResponse indeedResponse = null;
        try {
            indeedResponse = mapper.readValue(indeedSearchResults, IndeedResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Could not map jobs to IndeedResponse object");
        }
        return indeedResponse;
    }

    @Override
    public GlassDoorResponse  searchCompanyOnGlassdoor(GlassDoorSearch glassDoorSearch){
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(glassDoorSearch.getUrl());
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        JsonObject glassdoorSearchResults = response.readEntity(JsonObject.class);
        JsonObject glassdoorResults = ( (JsonObject) glassdoorSearchResults.get("response"));
        JsonArray employers = ((JsonArray) glassdoorResults.get("employers"));
        GlassDoorResponse glassDoorResponse = null;
        if (employers.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No companies found for company name: " + glassDoorSearch.getCompany());
        } else {
            JsonObject searchCompany = ( (JsonObject) employers.get(0));
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            try {
                glassDoorResponse = mapper.readValue(searchCompany.toString(), GlassDoorResponse.class);
            } catch (IOException e) {
                e.printStackTrace();
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Could not map jobs to GlassDoorResponse object");
            }
            return glassDoorResponse;
        }
    }
}
