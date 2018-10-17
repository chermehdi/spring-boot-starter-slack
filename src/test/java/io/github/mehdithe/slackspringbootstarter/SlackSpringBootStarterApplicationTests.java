package io.github.mehdithe.slackspringbootstarter;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.mehdithe.slackspringbootstarter.configuration.SlackConfiguration;
import io.github.mehdithe.slackspringbootstarter.core.SlackNotifier;
import java.util.concurrent.Executor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SlackSpringBootStarterApplicationTests {

  ApplicationContextRunner runner;

  @Before
  public void setup() {
    runner = new ApplicationContextRunner();
  }

  @Test
  public void mustHaveWebHookUrl() {
    this.runner
        .withPropertyValues("slack.web-hook-url=url")
        .withUserConfiguration(SlackConfiguration.class)
        .run((context) -> {
          assertThat(context).hasSingleBean(SlackNotifier.class);
        });
    this.runner
        .withUserConfiguration(SlackConfiguration.class)
        .run((context) -> {
          assertThat(context).doesNotHaveBean(SlackNotifier.class);
        });

  }

  @Test
  public void hasThreadPoolConfigurationTest() {

    this.runner
        .withPropertyValues("slack.web-hook-url=url")
        .withPropertyValues("slack.async=true")
        .withUserConfiguration(SlackConfiguration.class)
        .run((context) -> {
          assertThat(context).hasSingleBean(Executor.class);
        });

    this.runner
        .withPropertyValues("slack.web-hook-url=url")
        .withPropertyValues("slack.async=false")
        .withUserConfiguration(SlackConfiguration.class)
        .run((context) -> {
          assertThat(context).doesNotHaveBean(Executor.class);
        });
  }

  @Test
  public void hasRestTemplateTest() {

    this.runner
        .withPropertyValues("slack.web-hook-url=url")
        .withUserConfiguration(SlackConfiguration.class)
        .run((context) -> {
          assertThat(context).hasSingleBean(RestTemplate.class);
        });

  }
}
