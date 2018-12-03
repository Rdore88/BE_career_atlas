package careeratlas.backend.Service;

import careeratlas.backend.Domain.JobResponse;
import careeratlas.backend.Domain.JobSearch;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

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

}
