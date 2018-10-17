package io.github.mehdithe.slackspringbootstarter.core.impl;

import io.github.mehdithe.slackspringbootstarter.core.Message;

/**
 * @author mehdithe
 */
public class TextMessage implements Message {

  private String content;

  public TextMessage(String content) {
    this.content = content;
  }

  @Override
  public boolean hasAttachment() {
    return false;
  }

  @Override
  public String getContent() {
    return content;
  }
}
