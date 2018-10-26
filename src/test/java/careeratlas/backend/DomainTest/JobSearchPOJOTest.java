package careeratlas.backend.DomainTest;

import careeratlas.backend.Domain.JobSearch;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class JobSearchPOJOTest {

    @Test
    public void shouldConstruct() {
        JobSearch jobSearch = new JobSearch("30308", "Software Developer", "25", "fulltime");

        Assertions.assertThat(jobSearch)
                .as("not null references")
                .isNotNull();

        Assert.assertThat(jobSearch.getQ(), Matchers.equalToIgnoringCase("software developer"));
        Assert.assertThat(jobSearch.getSt(), Matchers.equalToIgnoringCase("jobsite"));
    }
}
