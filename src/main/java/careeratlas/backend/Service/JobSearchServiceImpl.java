package careeratlas.backend.Service;

import careeratlas.backend.Domain.GlassDoorResponse;
import careeratlas.backend.Domain.GlassDoorSearch;
import careeratlas.backend.Domain.JobResponse;
import careeratlas.backend.Domain.JobSearch;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Optional;

@Service
public class JobSearchServiceImpl implements JobSearchService {

    @Override
    public ArrayList<JobResponse> searchJobs(String jobTitle, String jobType, String distance, String location){
        JobSearch jobSearch = new JobSearch(location, jobTitle, distance, jobType);
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(jobSearch.getUrl());
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        ArrayList<HashMap> indeedSearchResults = ((ArrayList<HashMap>) response.readEntity(HashMap.class).get("results"));
        ArrayList<JobResponse> parsedSearchResults = new ArrayList<JobResponse>();
        for (HashMap var : indeedSearchResults)
        {
            JobResponse job = new JobResponse(var.get("company").toString(), var.get("jobtitle").toString(), var.get("jobkey").toString(), var.get("longitude").toString(), var.get("latitude").toString(), var.get("url").toString(), var.get("snippet").toString());
            parsedSearchResults.add(job);
        }
        return parsedSearchResults;
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
            return glassDoorResponse;
        } else {
            JsonObject searchCompany = ( (JsonObject) employers.get(0));
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            try {
                glassDoorResponse = mapper.readValue(searchCompany.toString(), GlassDoorResponse.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return glassDoorResponse;
        }
    }

}
