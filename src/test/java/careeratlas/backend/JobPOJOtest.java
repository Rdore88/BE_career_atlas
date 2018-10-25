package careeratlas.backend;

import careeratlas.backend.Job.Job;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import java.time.ZonedDateTime;

public class JobPOJOtest {

    @Test
    public void shouldConstruct() {
        Job job = new Job("The Home Depot", "Software Developer", "12345abcde", "-84.4986169",
                "33.9176691", "www.homedepot.com/careers");

        Assertions.assertThat(job)
                .as("not a null reference")
                .isNotNull();

        Assert.assertThat(job.getCompany(), Matchers.equalToIgnoringCase("The Home Depot"));
        Assert.assertThat(job.getUrl(), Matchers.equalToIgnoringCase("www.homedepot.com/careers"));
    }
}
