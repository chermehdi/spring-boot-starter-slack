package io.github.mehdithe.slackspringbootstarter.configuration;

import io.github.mehdithe.slackspringbootstarter.core.SlackProperties;
import java.util.concurrent.Executor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * General configuration for beans needed by the slack notifier library
 *
 * @author mehdithe
 */
@Configuration
@EnableConfigurationProperties(SlackProperties.class)
public class SlackConfiguration {

  /**
   * Configures the thread pool that executes the tasks of submitting the request to slack
   * workspace, this bean is available only if the slack.async property is set to true
   */
  @Bean
  @ConditionalOnProperty(name = "async", prefix = "slack", havingValue = "true")
  public Executor threadPool() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(5);
    executor.setMaxPoolSize(30);
    executor.setQueueCapacity(20);
    executor.setThreadNamePrefix("slack-thread");
    return executor;
  }
}
