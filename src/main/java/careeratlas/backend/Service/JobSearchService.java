package careeratlas.backend.Service;

import careeratlas.backend.Domain.IndeedResponse;
import careeratlas.backend.Domain.JobSearch;
import org.springframework.stereotype.Service;
@Service
public interface JobSearchService {

    IndeedResponse searchJobs(JobSearch jobSearch);

}
