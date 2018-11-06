package io.github.chermehdi.slackspringbootstarter.core.impl;

import io.github.chermehdi.slackspringbootstarter.core.Message;

/**
 * @author chermehdi
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

  @Override
  public boolean isMarkdown() {
    return false;
  }

}
