package careeratlas.backend.Service;

import careeratlas.backend.Domain.GlassDoorResponse;
import careeratlas.backend.Domain.GlassDoorSearch;
import careeratlas.backend.Domain.JobResponse;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import careeratlas.backend.Domain.IndeedResponse;
import careeratlas.backend.Domain.JobSearch;
import org.springframework.stereotype.Service;
@Service
public interface JobSearchService {

    IndeedResponse searchJobs(JobSearch jobSearch);

    GlassDoorResponse searchCompanyOnGlassdoor(GlassDoorSearch glassDoorSearch);

}
