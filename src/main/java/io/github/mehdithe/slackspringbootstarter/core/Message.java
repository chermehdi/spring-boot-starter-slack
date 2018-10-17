package io.github.mehdithe.slackspringbootstarter.core;

/**
 * @author mehdithe
 */
public interface Message {

  boolean hasAttachment();

  String getContent();
}
