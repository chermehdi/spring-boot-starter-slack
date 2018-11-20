# Spring boot Starter Slack Logger

## Usage

- configure your `Slack` workspace with a WEBHOOK and add it to your `application.properties` file
```
slack.web-hook-url=YOUR_WEB_HOOK_URL
slack.channel-name=CHANNEL_NAME
slack.async=false
```
- add a dependency to `slack-spring-boot-start`

```xml
<dependencies>
  <!--- other dependencies -->
  <dependency>
    <groupId>io.github.chermehdi</groupId>
    <artifactId>slack-spring-boot-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
  </dependency>
</dependencies>
```

- and you can use it in your code as

```java
@Autowired
SlackNotifier notifier;
```

- if you want the notifications to be sent async, you can set the async flag in your properties to true

## Contribution

- any bug reports, fixes, pull requests are much welcomed