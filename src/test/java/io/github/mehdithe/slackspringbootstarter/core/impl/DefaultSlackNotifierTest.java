package io.github.mehdithe.slackspringbootstarter.core.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mehdithe
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultSlackNotifierTest {

  @Test
  public void send() {
    assertTrue(true);
  }
}