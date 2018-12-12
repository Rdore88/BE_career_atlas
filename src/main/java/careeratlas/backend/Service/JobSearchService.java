package careeratlas.backend.Service;

import careeratlas.backend.Domain.IndeedResponse;
import careeratlas.backend.Domain.JobResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface JobSearchService {

    IndeedResponse searchJobs(String jobTitle, String jobType, String distance, String location);

}
