package io.github.mehdithe.slackspringbootstarter.core;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author mehdithe
 */
public class MarkdownMessageBuilderTest {

  @Test
  public void text() {
    Message message = new MarkdownMessageBuilder()
        .text("mehdi").build();
    assertThat(message.getContent(), is("mehdi"));
  }

  @Test
  public void code() {
    Message message = new MarkdownMessageBuilder()
        .code("code").build();
    assertThat(message.getContent(), is("`code`"));
  }

  @Test
  public void h1() {
    Message message = new MarkdownMessageBuilder()
        .h1("some header").build();
    assertThat(message.getContent(), is("#some header\n"));
  }
}