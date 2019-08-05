package careeratlas.backend.DomainTest;

import careeratlas.backend.Domain.JobSearch;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class JobSearchPOJOTest {

    @Test
    public void shouldConstruct() {
        JobSearch jobSearch = new JobSearch();
        jobSearch.setLocation("30308");
        jobSearch.setDistance("25");
        jobSearch.setJobTitle("Software Developer");
        jobSearch.setJobType("fulltime");

        Assertions.assertThat(jobSearch)
                .as("not null references")
                .isNotNull();

        Assert.assertThat(jobSearch.getJobTitle(), Matchers.equalToIgnoringCase("software developer"));
        Assert.assertThat(jobSearch.getJobSite(), Matchers.equalToIgnoringCase("jobsite"));
    }
}
