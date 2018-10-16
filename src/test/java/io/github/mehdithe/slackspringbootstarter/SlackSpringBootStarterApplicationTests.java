package io.github.mehdithe.slackspringbootstarter;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.mehdithe.slackspringbootstarter.configuration.SlackConfiguration;
import io.github.mehdithe.slackspringbootstarter.core.SlackProperties;
import java.util.concurrent.Executor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SlackSpringBootStarterApplicationTests {

  ApplicationContextRunner runner;

  SlackProperties props;

  @Before
  public void setup() {
    runner = new ApplicationContextRunner().withConfiguration(AutoConfigurations.of(
        SlackConfiguration.class));
    props = new SlackProperties();
    props.setAsync(true);
  }

  @Test
  public void defaultServiceBacksOff() {
    this.runner.withUserConfiguration(SlackConfiguration.class)
        .run((context) -> {
          assertThat(context).hasSingleBean(Executor.class);
        });
  }

}
