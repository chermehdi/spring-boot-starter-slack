package io.github.chermehdi.slackspringbootstarter.core;

/**
 * The slack message that is going to be sent to the workspace,
 *
 * @author chermehdi
 */
public interface SlackMessage {

  /**
   * the username to be displayed in the workspace channel
   */
  String getUserName();

  /**
   * the icon to be displayed along the message
   */
  String getIconUrl();

  /**
   * the actual message, this can be a simple text message or a complex one (containing attachments,
   * markdown ..)
   */
  String getMessage();

  /**
   * the channel the messages are going to be sent to
   */
  String getChannel();

  /**
   * if set to true than it should notify the Slack API that this message contains markdown content
   * to displayed accordingly
   */
  boolean isMarkdown();
}
