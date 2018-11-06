package io.github.chermehdi.slackspringbootstarter.core.impl;

import io.github.chermehdi.slackspringbootstarter.core.Message;
import io.github.chermehdi.slackspringbootstarter.core.SlackNotifier;
import io.github.chermehdi.slackspringbootstarter.core.SlackProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * this is the default implementation of the SlackNotifier, it sends messages synchronously to the
 * slack workspace
 *
 * @author chermehdi
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
  public void send(Message message) {
    MessageWrapper wrappedMessage = MessageWrapper.from(message, configuration);
    sendSync(wrappedMessage);
  }

  private void sendSync(MessageWrapper message) {
    ResponseEntity<String> response = restClient
        .postForEntity(configuration.getWebHookUrl(), message, String.class);
    if (response.getStatusCode() != HttpStatus.OK) {
      logger.error("Could not send the message to the given channel, received status {}",
          response.getStatusCode());
    }
  }
}

