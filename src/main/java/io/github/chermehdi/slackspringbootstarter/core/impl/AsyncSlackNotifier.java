package io.github.chermehdi.slackspringbootstarter.core.impl;

import io.github.chermehdi.slackspringbootstarter.core.Message;
import io.github.chermehdi.slackspringbootstarter.core.SlackNotifier;
import io.github.chermehdi.slackspringbootstarter.core.SlackProperties;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Sends messages to the Slack configured workspace asynchronously, via the configured ThreadPool
 *
 * @author chermehdi
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
  public void send(Message message) {
    threadPool.execute(() -> sendAsync(MessageWrapper.from(message, configuration)));
  }

  private void sendAsync(MessageWrapper message) {
    ResponseEntity<String> response = restClient
        .postForEntity(configuration.getWebHookUrl(), message, String.class);
    if (response.getStatusCode() != HttpStatus.OK) {
      logger.error("Could not send the message to the given channel, received status {}",
          response.getStatusCode());
    }
  }

}
