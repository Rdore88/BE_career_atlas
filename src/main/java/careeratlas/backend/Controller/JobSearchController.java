package careeratlas.backend.Controller;


import careeratlas.backend.Domain.GlassDoorResponse;
import careeratlas.backend.Domain.GlassDoorSearch;
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
    @RequestMapping(path="/indeed", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public IndeedResponse getJobSearchFromIndeed(@RequestBody JobSearch jobSearch) {
        return jobSearchService.searchJobs(jobSearch);
    }

    @CrossOrigin
    @RequestMapping(path = "/glassdoor", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public GlassDoorResponse getGlassdoorInfo(@RequestBody GlassDoorSearch glassDoorSearch) {
        return jobSearchService.searchCompanyOnGlassdoor(glassDoorSearch);
    }
}