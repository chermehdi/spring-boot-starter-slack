package io.github.mehdithe.slackspringbootstarter.core;

/**
 * @author mehdithe
 */
public interface SlackNotifier {

  void send(SlackMessage mes);
}
