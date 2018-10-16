package io.github.mehdithe.slackspringbootstarter.core;

/**
 * The slack message that is going to be sent to the workspace
 *
 * @author mehdithe
 */
public interface SlackMessage {

  String getUserName();

  String getIconUrl();

  String getMessage();

  String getChannel();
}
