package io.github.chermehdi.slackspringbootstarter.core.impl;

import io.github.chermehdi.slackspringbootstarter.core.SlackNotifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mehdithe
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-async.properties")
public class AsyncSlackNotifierTest {

  @MockBean
  SlackNotifier notifier;

  @Test
  public void send() {
    System.out.println(notifier);
  }
}