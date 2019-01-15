package careeratlas.backend.Controller;

import careeratlas.backend.Domain.IndeedResponse;
import careeratlas.backend.Domain.JobSearch;
import careeratlas.backend.Service.JobSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/jobSearch")
public class JobSearchController {

    private JobSearchService jobSearchService;

    @Autowired
    public JobSearchController(final JobSearchService jobSearchService) {
        this.jobSearchService = jobSearchService;
    }

    @CrossOrigin
    @GetMapping(path = "/indeed")
    @ResponseStatus(HttpStatus.OK)
    public IndeedResponse getJobsFromIndeed(@RequestParam String jobTitle, @RequestParam String jobType, @RequestParam String distance, @RequestParam String location) {
        JobSearch jobSearch = new JobSearch(location, jobTitle, distance, jobType);
        return jobSearchService.searchJobs(jobSearch);
    }
}