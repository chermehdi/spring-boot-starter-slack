package io.github.chermehdi.slackspringbootstarter.core;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * encapsulates a single attachment
 *
 * @author chermehdi
 */
public class Attachment {

  private String text;

  private String fallback;

  private String color = "good";

  private String pretext;

  @JsonProperty("author_name")
  private String authorName;

  @JsonProperty("author_icon")
  private String authorIcon;

  private String title;

  @JsonProperty("title_link")
  private String titleLink;

  @JsonProperty("image_url")
  private String imageUrl;

  @JsonProperty("thumb_url")
  private String thumbUrl;

  private String footer;

  @JsonProperty("footer_icon")
  private String footerIcon;

  private long ts;

  public Attachment(String fallback, String text) {
    this.text = text;
    this.fallback = fallback;
  }

  private static AttachmentBuilder builder(String fallback, String text) {
    return new AttachmentBuilder(fallback, text);
  }

  static class AttachmentBuilder {

    private Attachment attachment;

    public AttachmentBuilder(String fallback, String text) {
      attachment = new Attachment(fallback, text);
    }

    public AttachmentBuilder color(String color) {
      if (color.startsWith("#")) {
        color = "#" + color;
      }
      attachment.color = color;
      return this;
    }

    public AttachmentBuilder authorName(String authName) {
      attachment.authorName = authName;
      return this;
    }

    public AttachmentBuilder authorIcon(String authIcon) {
      attachment.authorIcon = authIcon;
      return this;
    }

    public AttachmentBuilder title(String title) {
      attachment.title = title;
      return this;
    }

    public AttachmentBuilder titleLink(String titleLink) {
      attachment.titleLink = titleLink;
      return this;
    }

    public AttachmentBuilder imageUrl(String imgUrl) {
      attachment.imageUrl = imgUrl;
      return this;
    }

    public AttachmentBuilder thumbUrl(String thumbUrl) {
      attachment.thumbUrl = thumbUrl;
      return this;
    }

    public AttachmentBuilder timestamp(long timestamp) {
      attachment.ts = timestamp;
      return this;
    }

    public AttachmentBuilder pretext(String pretext) {
      attachment.pretext = pretext;
      return this;
    }

    public AttachmentBuilder footer(String footer) {
      attachment.footer = footer;
      return this;
    }

    public Attachment build() {
      return attachment;
    }
  }
}
