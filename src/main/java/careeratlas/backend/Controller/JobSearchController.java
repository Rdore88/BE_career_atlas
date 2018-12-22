package careeratlas.backend.Controller;

import careeratlas.backend.Domain.GlassDoorResponse;
import careeratlas.backend.Domain.GlassDoorSearch;
import careeratlas.backend.Domain.JobResponse;
import careeratlas.backend.Service.JobSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;


@RestController
@RequestMapping("/api/jobSearch")
public class JobSearchController {

    JobSearchService jobSearchService;

    @Autowired
    public JobSearchController(final JobSearchService jobSearchService) {
        this.jobSearchService = jobSearchService;
    }

    @CrossOrigin
    @RequestMapping(path = "/indeed", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<JobResponse> getJobsFromIndeed(@RequestParam String jobTitle, @RequestParam String jobType, @RequestParam String distance, @RequestParam String location) {
        return jobSearchService.searchJobs(jobTitle, jobType, distance, location);
    }

    @CrossOrigin
    @GetMapping(path = "/glassdoor")
    @ResponseStatus(HttpStatus.OK)
    public Object getGlassdoorInfo(@RequestParam String company) {
        GlassDoorSearch glassDoorSearch = new GlassDoorSearch(company)
        GlassDoorResponse glassDoorResponse = jobSearchService.searchCompanyOnGlassdoor(glassDoorSearch);
        if (glassDoorResponse != null ){
            glassDoorResponse.setStatus("200");
            return glassDoorResponse;
        } else {
            HashMap<String, String> nullResponse = new HashMap<String, String>();
            nullResponse.put("Status", "500");
            nullResponse.put("Message", "Could not find company");
            return nullResponse;
        }
    }
}