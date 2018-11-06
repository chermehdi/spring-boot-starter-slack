package io.github.chermehdi.slackspringbootstarter.core;

import io.github.chermehdi.slackspringbootstarter.core.impl.MarkdownMessage;

/**
 * a simple utitity builder to build a MarkdownMessage easily without knowing markdown syntax
 *
 * @author chermehdi
 */
public class MarkdownMessageBuilder {

  private StringBuffer internalBuffer;

  public MarkdownMessageBuilder() {
    internalBuffer = new StringBuffer();
  }

  public MarkdownMessageBuilder text(String text) {
    this.internalBuffer.append(text);
    return this;
  }

  public MarkdownMessageBuilder code(String text) {
    this.internalBuffer.append("`" + text + "`");
    return this;
  }

  public MarkdownMessageBuilder bold(String text) {
    this.internalBuffer.append("*" + text + "*");
    return this;
  }

  public MarkdownMessageBuilder italic(String text) {
    this.internalBuffer.append("**" + text + "**");
    return this;
  }

  public MarkdownMessageBuilder h1(String text) {
    this.internalBuffer.append("#" + text + "\n");
    return this;
  }

  public MarkdownMessageBuilder h2(String text) {
    this.internalBuffer.append("##" + text + "\n");
    return this;
  }

  public MarkdownMessageBuilder h3(String text) {
    this.internalBuffer.append("###" + text + "\n");
    return this;
  }

  public MarkdownMessageBuilder h4(String text) {
    this.internalBuffer.append("####" + text + "\n");
    return this;
  }

  public MarkdownMessageBuilder h5(String text) {
    this.internalBuffer.append("#####" + text + "\n");
    return this;
  }

  public MarkdownMessageBuilder h6(String text) {
    this.internalBuffer.append("######" + text + "\n");
    return this;
  }


  public MarkdownMessage build() {
    return new MarkdownMessage(this.internalBuffer.toString());
  }
}
