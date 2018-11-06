package io.github.chermehdi.slackspringbootstarter.core;

/**
 * Contract to be implemented by every extension of the SlackNotifier, it has a single method that
 * sends an instance of @{Message} based on your configuration
 *
 * @author chermehdi
 */
public interface SlackNotifier {

  void send(Message message);
}
