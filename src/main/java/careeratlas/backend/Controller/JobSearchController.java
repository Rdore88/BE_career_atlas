package careeratlas.backend.Controller;

import careeratlas.backend.Domain.IndeedResponse;
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
    public IndeedResponse getJobsFromIndeed(@RequestParam String jobTitle, @RequestParam String jobType, @RequestParam String distance, @RequestParam String location) {
        return jobSearchService.searchJobs(jobTitle, jobType, distance, location);
    }
}