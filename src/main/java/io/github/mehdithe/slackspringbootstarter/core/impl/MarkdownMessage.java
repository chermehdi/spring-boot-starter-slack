package io.github.mehdithe.slackspringbootstarter.core.impl;

import io.github.mehdithe.slackspringbootstarter.core.Message;

/**
 * @author mehdithe
 */
public class MarkdownMessage implements Message {

  private String content;

  public MarkdownMessage(String content) {
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
