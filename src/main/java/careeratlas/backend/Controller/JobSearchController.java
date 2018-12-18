package careeratlas.backend.Controller;

import careeratlas.backend.Domain.GlassDoorResponse;
import careeratlas.backend.Domain.JobResponse;
import careeratlas.backend.Service.JobSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


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
    public GlassDoorResponse getGlassdoorInfo(@RequestParam String company) {
        return jobSearchService.searchCompanyOnGlassdoor(company);
    }
}