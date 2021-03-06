package io.github.chermehdi.slackspringbootstarter.configuration;

import io.github.chermehdi.slackspringbootstarter.core.SlackNotifier;
import io.github.chermehdi.slackspringbootstarter.core.SlackProperties;
import io.github.chermehdi.slackspringbootstarter.core.impl.AsyncSlackNotifier;
import io.github.chermehdi.slackspringbootstarter.core.impl.DefaultSlackNotifier;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

/**
 * General configuration for beans needed by the slack notifier library
 *
 * @author chermehdi
 */
@Configuration
@ConditionalOnProperty(prefix = "slack", name = "web-hook-url")
@EnableConfigurationProperties(SlackProperties.class)
public class SlackConfiguration {

  /**
   * Configures the thread pool that executes the tasks of submitting the request to slack
   * workspace, this bean is available only if the slack.async property is set to true
   */
  @Bean
  @ConditionalOnMissingBean(Executor.class)
  @ConditionalOnProperty(name = "async", prefix = "slack", havingValue = "true")
  public Executor threadPool() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(5);
    executor.setMaxPoolSize(30);
    executor.setQueueCapacity(20);
    executor.setThreadNamePrefix("slack-thread");
    return executor;
  }

  /**
   * Creates a RestTemplate for injection, only if not available in the context already configured
   * by the end user
   */
  @Bean
  @ConditionalOnMissingBean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  /**
   * Creates a SlackNotifier based on the configuration found on the application.properties file if
   * the async flag is set ot true this method will be invoked and an @{AsyncSlackNotifier} will be
   * created for you
   *
   * @param configuration the @{SlackProperties} configuration parsed from the
   * application.properties
   * @return the created SlackNotifier
   */
  @Bean
  @ConditionalOnMissingBean
  @ConditionalOnProperty(name = "async", prefix = "slack", havingValue = "true")
  public SlackNotifier asyncSlackNotifier(SlackProperties configuration) {
    Objects.requireNonNull(configuration);
    return new AsyncSlackNotifier(threadPool(), restTemplate(), configuration);
  }

  /**
   * Creates a SlackNotifier based on the configuration found on the application.properties file if
   * the async flag is set ot false or not set at all this method will be invoked and an
   *
   * @param configuration the @{SlackProperties} configuration parsed from the
   * application.properties
   * @return the created SlackNotifier
   * @{DefaultSlackNotifier} will be created for you
   */
  @Bean
  @ConditionalOnMissingBean
  public SlackNotifier syncSlackNotifier(SlackProperties configuration) {
    return new DefaultSlackNotifier(configuration, restTemplate());
  }
}
