package io.github.chermehdi.slackspringbootstarter.core;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author chermehdi
 */
@ConfigurationProperties(prefix = "slack")
public class SlackProperties {

  private boolean async = false;

  private String webHookUrl;

  private String username;

  private String channelName;

  private String icon;

  public SlackProperties() {}

  public boolean isAsync() {
    return async;
  }

  public void setAsync(boolean async) {
    this.async = async;
  }

  public String getWebHookUrl() {
    return webHookUrl;
  }

  public void setWebHookUrl(String webHookUrl) {
    this.webHookUrl = webHookUrl;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getChannelName() {
    return channelName;
  }

  public void setChannelName(String channelName) {
    this.channelName = channelName;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }
}
