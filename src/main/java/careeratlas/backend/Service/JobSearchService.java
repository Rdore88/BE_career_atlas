package careeratlas.backend.Service;

import careeratlas.backend.Domain.JobResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public interface JobSearchService {

    ArrayList<JobResponse> searchJobs(String jobTitle, String jobType, String distance, String location);

    void searchCompanyOnGlassdoor(String company);

}
