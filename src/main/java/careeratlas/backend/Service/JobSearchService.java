package careeratlas.backend.Service;

import careeratlas.backend.Domain.GlassDoorResponse;
import careeratlas.backend.Domain.GlassDoorSearch;
import careeratlas.backend.Domain.JobResponse;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public interface JobSearchService {

    ArrayList<JobResponse> searchJobs(String jobTitle, String jobType, String distance, String location);

    GlassDoorResponse searchCompanyOnGlassdoor(GlassDoorSearch glassDoorSearch);

}
