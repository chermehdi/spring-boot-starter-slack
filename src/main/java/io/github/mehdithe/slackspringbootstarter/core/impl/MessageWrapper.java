package io.github.mehdithe.slackspringbootstarter.core.impl;

import io.github.mehdithe.slackspringbootstarter.core.SlackMessage;

/**
 * @author mehdithe
 */
public class MessageWrapper implements SlackMessage {

  private String username;

  private String icon;

  private String text;

  private String channel;

  private boolean markdown;

  public MessageWrapper() {
  }

  public static MessageWrapper from(SlackMessage message) {
    MessageWrapper wrapper = new MessageWrapper();
    wrapper.setIcon(message.getIconUrl());
    wrapper.setMarkdown(message.isMarkdown());
    wrapper.setChannel(message.getChannel());
    wrapper.setText(message.getMessage());
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
