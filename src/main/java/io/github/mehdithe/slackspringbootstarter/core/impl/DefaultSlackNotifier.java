package io.github.mehdithe.slackspringbootstarter.core.impl;

import io.github.mehdithe.slackspringbootstarter.core.SlackMessage;
import io.github.mehdithe.slackspringbootstarter.core.SlackNotifier;
import io.github.mehdithe.slackspringbootstarter.core.SlackProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author mehdithe
 */
public class DefaultSlackNotifier implements SlackNotifier {

  final SlackProperties configuration;

  final RestTemplate restClient;

  Logger logger = LoggerFactory.getLogger(getClass());

  public DefaultSlackNotifier(SlackProperties configuration,
      RestTemplate restClient) {
    this.configuration = configuration;
    this.restClient = restClient;
  }

  @Override
  public void send(SlackMessage message) {
    MessageWrapper wrappedMessage = MessageWrapper.from(message);
    ResponseEntity<MessageWrapper> response = restClient
        .postForEntity(configuration.getWebHookUrl(), wrappedMessage, MessageWrapper.class);
    if (response.getStatusCode() != HttpStatus.OK) {
      logger.error("Could not send the message to the given channel, received status " + response
          .getStatusCode());
    }
  }
}
