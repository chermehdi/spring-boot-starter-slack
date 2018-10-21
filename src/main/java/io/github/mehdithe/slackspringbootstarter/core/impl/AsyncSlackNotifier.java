package io.github.mehdithe.slackspringbootstarter.core.impl;

import io.github.mehdithe.slackspringbootstarter.core.SlackMessage;
import io.github.mehdithe.slackspringbootstarter.core.SlackNotifier;
import io.github.mehdithe.slackspringbootstarter.core.SlackProperties;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author mehdithe
 */
public class AsyncSlackNotifier implements SlackNotifier {

  final Executor threadPool;

  final RestTemplate restClient;

  final SlackProperties configuration;

  Logger logger = LoggerFactory.getLogger(getClass());

  public AsyncSlackNotifier(Executor threadPool,
      RestTemplate restTemplate,
      SlackProperties configuration) {
    this.threadPool = threadPool;
    this.restClient = restTemplate;
    this.configuration = configuration;
  }

  @Override
  public void send(SlackMessage message) {
    threadPool.execute(() -> sendAsync(MessageWrapper.from(message)));
  }

  private void sendAsync(MessageWrapper message) {
    ResponseEntity<MessageWrapper> response = restClient
        .postForEntity(configuration.getWebHookUrl(), message, MessageWrapper.class);
    if (response.getStatusCode() != HttpStatus.OK) {
      logger.error("Could not send the message to the given channel, received status {}",
          response.getStatusCode());
    }
  }
}
