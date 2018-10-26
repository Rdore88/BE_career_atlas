package careeratlas.backend.DomainTest;

import careeratlas.backend.Domain.JobResponse;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class JobResponsePOJOtest {

    @Test
    public void shouldConstruct() {
        JobResponse jobResponse = new JobResponse("The Home Depot", "Software Developer", "12345abcde", "-84.4986169",
                "33.9176691", "www.homedepot.com/careers");

        Assertions.assertThat(jobResponse)
                .as("not a null reference")
                .isNotNull();

        Assert.assertThat(jobResponse.getCompany(), Matchers.equalToIgnoringCase("The Home Depot"));
        Assert.assertThat(jobResponse.getUrl(), Matchers.equalToIgnoringCase("www.homedepot.com/careers"));
    }
}
