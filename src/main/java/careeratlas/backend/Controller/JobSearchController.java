package careeratlas.backend.Controller;

import careeratlas.backend.Domain.JobResponse;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;


@RestController
@RequestMapping("api/jobs/searchAll")
public class JobSearchController {

    @CrossOrigin
    @GetMapping
    Object searchJobs(@RequestParam String jobTitle, @RequestParam String jobType, @RequestParam String distance, @RequestParam String location) {

        String url = String.format("http://api.indeed.com/ads/apisearch?publisher=%s&q=%s&l=%s&sort=&radius=%s&st=&jt=%s&start=&limit=&fromage=&filter=&latlong=1&co=us&format=json&v=2", System.getenv("INDEED_API_KEY"), jobTitle, location, distance, jobType);
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(url);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        HashMap output = response.readEntity(HashMap.class);
        ArrayList<HashMap> newOutput = ((ArrayList<HashMap>) output.get("results"));
        ArrayList<JobResponse> finalOutput = new ArrayList<JobResponse>();
        for (HashMap var : newOutput)
        {
            JobResponse job = new JobResponse(var.get("company").toString(), var.get("jobtitle").toString(), var.get("jobkey").toString(), var.get("longitude").toString(), var.get("latitude").toString(), var.get("url").toString());
            finalOutput.add(job);
        }
        return finalOutput;

    }
}