package careeratlas.backend.Service;

import careeratlas.backend.Domain.IndeedResponse;
import careeratlas.backend.Domain.JobSearch;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.IOException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public class JobSearchServiceImpl implements JobSearchService {

    @Override
    public IndeedResponse searchJobs(String jobTitle, String jobType, String distance, String location){
        JobSearch jobSearch = new JobSearch(location, jobTitle, distance, jobType);
        Client client = ClientBuilder.newClient();
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
        }

        if (indeedResponse == null) {
            indeedResponse.setStatus("500");
            return indeedResponse;
        } else {
            indeedResponse.setStatus("200");
            return indeedResponse;
        }
    }
}
