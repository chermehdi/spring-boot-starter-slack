package io.github.chermehdi.slackspringbootstarter;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.chermehdi.slackspringbootstarter.configuration.SlackConfiguration;
import io.github.chermehdi.slackspringbootstarter.core.SlackNotifier;
import io.github.chermehdi.slackspringbootstarter.core.impl.AsyncSlackNotifier;
import io.github.chermehdi.slackspringbootstarter.core.impl.DefaultSlackNotifier;
import java.util.concurrent.Executor;
import org.junit.Assert;
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
        .withPropertyValues("slack.web-hook-url=url", "slack.async=true")
        .withUserConfiguration(SlackConfiguration.class)
        .run((context) -> {
          assertThat(context).hasSingleBean(Executor.class);
          assertThat(context).hasSingleBean(SlackNotifier.class);
          SlackNotifier notifier = context.getBean(SlackNotifier.class);
          Assert.assertTrue(notifier instanceof AsyncSlackNotifier);
        });

    this.runner
        .withPropertyValues("slack.web-hook-url=url")
        .withPropertyValues("slack.async=false")
        .withUserConfiguration(SlackConfiguration.class)
        .run((context) -> {
          assertThat(context).doesNotHaveBean(Executor.class);
          assertThat(context).hasSingleBean(SlackNotifier.class);
          Assert.assertTrue(context.getBean(SlackNotifier.class) instanceof DefaultSlackNotifier);
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
