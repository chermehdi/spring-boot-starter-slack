package io.github.chermehdi.slackspringbootstarter.core.impl;

import io.github.chermehdi.slackspringbootstarter.core.Message;
import io.github.chermehdi.slackspringbootstarter.core.SlackMessage;
import io.github.chermehdi.slackspringbootstarter.core.SlackProperties;

/**
 * @author chermehdi
 */
public class MessageWrapper implements SlackMessage {

  private String username;

  private String icon;

  private String text;

  private String channel;

  private boolean markdown;

  public MessageWrapper() {
  }


  public static MessageWrapper from(Message message, SlackProperties configuration) {
    MessageWrapper wrapper = new MessageWrapper();
    wrapper.setIcon(configuration.getIcon());
    wrapper.setMarkdown(message.isMarkdown());
    wrapper.setChannel(configuration.getChannelName());
    wrapper.setText(message.getContent());
    wrapper.setUsername(configuration.getUsername());
    return wrapper;
  }

  @Override
  public String getUserName() {
    return username;
  }

  @Override
  public String getIconUrl() {
    return icon;
  }

  @Override
  public String getMessage() {
    return text;
  }

  @Override
  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean isMarkdown() {
    return markdown;
  }

  public void setMarkdown(boolean markdown) {
    this.markdown = markdown;
  }
}
