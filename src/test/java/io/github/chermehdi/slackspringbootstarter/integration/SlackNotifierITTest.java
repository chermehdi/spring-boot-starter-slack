package io.github.chermehdi.slackspringbootstarter.integration;

import io.github.chermehdi.slackspringbootstarter.core.MarkdownMessageBuilder;
import io.github.chermehdi.slackspringbootstarter.core.SlackNotifier;
import io.github.chermehdi.slackspringbootstarter.core.SlackProperties;
import io.github.chermehdi.slackspringbootstarter.core.impl.TextMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chermehdi
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.properties")
public class SlackNotifierITTest {

  @Autowired
  SlackNotifier notifier;

  @Autowired
  SlackProperties props;

  @Test
  public void messageIsSentTest() {
    notifier.send(new TextMessage("hello world !"));
    notifier.send(new MarkdownMessageBuilder().code("System.out.println").build());
  }
}
