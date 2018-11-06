package io.github.chermehdi.slackspringbootstarter.core;

/**
 * @author chermehdi
 */
public interface Message {

  boolean hasAttachment();

  String getContent();

  boolean isMarkdown();
}
