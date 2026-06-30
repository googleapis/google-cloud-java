/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** The class representing Pub/Sub Notification metadata for the Storage. */
public class NotificationInfo implements Serializable {

  private static final long serialVersionUID = -996243512290027661L;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/topics/{topic}");

  public enum PayloadFormat {
    JSON_API_V1,
    NONE
  }

  public enum EventType {
    OBJECT_FINALIZE,
    OBJECT_METADATA_UPDATE,
    OBJECT_DELETE,
    OBJECT_ARCHIVE
  }

  private final String notificationId;
  private final String topic;
  private final List<EventType> eventTypes;
  private final Map<String, String> customAttributes;
  private final PayloadFormat payloadFormat;
  private final String objectNamePrefix;
  private final String etag;
  private final String selfLink;

  /** Builder for {@code NotificationInfo}. */
  public abstract static class Builder {
    Builder() {}

    abstract Builder setNotificationId(String notificationId);

    public abstract Builder setSelfLink(String selfLink);

    public abstract Builder setTopic(String topic);

    public abstract Builder setPayloadFormat(PayloadFormat payloadFormat);

    public abstract Builder setObjectNamePrefix(String objectNamePrefix);

    public abstract Builder setEventTypes(EventType... eventTypes);

    public abstract Builder setEtag(String etag);

    public abstract Builder setCustomAttributes(Map<String, String> customAttributes);

    /** Creates a {@code NotificationInfo} object. */
    public abstract NotificationInfo build();
  }

  /** Builder for {@code NotificationInfo}. */
  public static class BuilderImpl extends Builder {

    private String notificationId;
    private String topic;
    private List<EventType> eventTypes;
    private Map<String, String> customAttributes;
    private PayloadFormat payloadFormat;
    private String objectNamePrefix;
    private String etag;
    private String selfLink;

    BuilderImpl(String topic) {
      this.topic = topic;
    }

    BuilderImpl(NotificationInfo notificationInfo) {
      notificationId = notificationInfo.notificationId;
      etag = notificationInfo.etag;
      selfLink = notificationInfo.selfLink;
      topic = notificationInfo.topic;
      eventTypes = notificationInfo.eventTypes;
      customAttributes = notificationInfo.customAttributes;
      payloadFormat = notificationInfo.payloadFormat;
      objectNamePrefix = notificationInfo.objectNamePrefix;
    }

    @Override
    Builder setNotificationId(String notificationId) {
      this.notificationId = notificationId;
      return this;
    }

    @Override
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /** Sets a topic in the format of "projects/{project}/topics/{topic}". */
    @Override
    public Builder setTopic(String topic) {
      this.topic = topic;
      return this;
    }

    @Override
    public Builder setPayloadFormat(PayloadFormat payloadFormat) {
      this.payloadFormat = payloadFormat;
      return this;
    }

    @Override
    public Builder setObjectNamePrefix(String objectNamePrefix) {
      this.objectNamePrefix = objectNamePrefix;
      return this;
    }

    @Override
    public Builder setEventTypes(EventType... eventTypes) {
      this.eventTypes = eventTypes != null ? Arrays.asList(eventTypes) : null;
      return this;
    }

    @Override
    public Builder setEtag(String etag) {
      this.etag = etag;
      return this;
    }

    @Override
    public Builder setCustomAttributes(Map<String, String> customAttributes) {
      this.customAttributes =
          customAttributes != null ? ImmutableMap.copyOf(customAttributes) : null;
      return this;
    }

    public NotificationInfo build() {
      checkNotNull(topic);
      checkTopicFormat(topic);
      return new NotificationInfo(this);
    }
  }

  NotificationInfo(BuilderImpl builder) {
    notificationId = builder.notificationId;
    etag = builder.etag;
    selfLink = builder.selfLink;
    topic = builder.topic;
    eventTypes = builder.eventTypes;
    customAttributes = builder.customAttributes;
    payloadFormat = builder.payloadFormat;
    objectNamePrefix = builder.objectNamePrefix;
  }

  /** Returns the service-generated id for the notification. */
  public String getNotificationId() {
    return notificationId;
  }

  /** Returns the topic in Pub/Sub that receives notifications. */
  public String getTopic() {
    return topic;
  }

  /** Returns the canonical URI of this topic as a string. */
  public String getSelfLink() {
    return selfLink;
  }

  /** Returns the desired content of the Payload. */
  public NotificationInfo.PayloadFormat getPayloadFormat() {
    return payloadFormat;
  }

  /** Returns the object name prefix for which this notification configuration applies. */
  public String getObjectNamePrefix() {
    return objectNamePrefix;
  }

  /**
   * Returns HTTP 1.1 Entity tag for the notification. See <a
   * href="http://tools.ietf.org/html/rfc2616#section-3.11">Entity Tags</a>
   */
  public String getEtag() {
    return etag;
  }

  /**
   * Returns the events that trigger a notification to be sent. If empty, notifications are
   * triggered by any event. See <a
   * href="https://cloud.google.com/storage/docs/pubsub-notifications#events">Event types</a> to get
   * list of available events.
   */
  public List<NotificationInfo.EventType> getEventTypes() {
    return eventTypes;
  }

  /**
   * Returns the list of additional attributes to attach to each Cloud PubSub message published for
   * this notification subscription.
   */
  public Map<String, String> getCustomAttributes() {
    return customAttributes;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        notificationId,
        topic,
        eventTypes,
        customAttributes,
        payloadFormat,
        objectNamePrefix,
        etag,
        selfLink);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NotificationInfo)) {
      return false;
    }
    NotificationInfo that = (NotificationInfo) o;
    return Objects.equals(notificationId, that.notificationId)
        && Objects.equals(topic, that.topic)
        && Objects.equals(eventTypes, that.eventTypes)
        && Objects.equals(customAttributes, that.customAttributes)
        && payloadFormat == that.payloadFormat
        && Objects.equals(objectNamePrefix, that.objectNamePrefix)
        && Objects.equals(etag, that.etag)
        && Objects.equals(selfLink, that.selfLink);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("topic", topic).toString();
  }

  /**
   * Creates a {@code NotificationInfo} object for the provided topic.
   *
   * <p>Example of creating the NotificationInfo object:
   *
   * <pre>{@code
   * String topic = "projects/myProject/topics/myTopic"
   * NotificationInfo notificationInfo = NotificationInfo.of(topic)
   * }</pre>
   *
   * @param topic a string in the format "projects/{project}/topics/{topic}"
   */
  public static NotificationInfo of(String topic) {
    checkTopicFormat(topic);
    return newBuilder(topic).build();
  }

  /**
   * Creates a {@code NotificationInfo} object for the provided topic.
   *
   * @param topic a string in the format "projects/{project}/topics/{topic}"
   */
  public static Builder newBuilder(String topic) {
    checkTopicFormat(topic);
    return new BuilderImpl(topic);
  }

  /** Returns a builder for the current notification. */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  Notification asNotification(Storage storage) {
    return new Notification(storage, new BuilderImpl(this));
  }

  private static void checkTopicFormat(String topic) { // todo: why does this exist?
    PATH_TEMPLATE.validatedMatch(topic, "topic name must be in valid format");
  }
}
