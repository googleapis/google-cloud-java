/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.notification;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.storage.model.Notification;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.pubsub.v1.ProjectTopicName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Google Storage Notification metadata;
 *
 * @see <a href="https://cloud.google.com/storage/docs/concepts-techniques#concepts">Concepts and
 *     Terminology</a>
 */
public class NotificationInfo implements Serializable {
  // TODO: Consider making this an AutoValue class.

  private static final long serialVersionUID = 5725883368559753810L;

  public enum PayloadFormat {
    JSON_API_V1,
    NONE
  }

  static final Function<Notification, NotificationInfo> FROM_PB_FUNCTION =
      new Function<Notification, NotificationInfo>() {
        @Override
        public NotificationInfo apply(Notification pb) {
          return NotificationInfo.fromPb(pb);
        }
      };
  static final Function<NotificationInfo, Notification> TO_PB_FUNCTION =
      new Function<NotificationInfo, Notification>() {
        @Override
        public Notification apply(NotificationInfo NotificationInfo) {
          return NotificationInfo.toPb();
        }
      };
  private final String generatedId;
  private final ProjectTopicName topic;
  private final List<String> eventTypes;
  private final Map<String, String> customAttributes;
  private final PayloadFormat payloadFormat;
  private final String objectNamePrefix;
  private final String etag;
  private final String selfLink;

  public static final class Builder {

    private String generatedId;
    private ProjectTopicName topic;
    private List<String> eventTypes;
    private Map<String, String> customAttributes;
    private PayloadFormat payloadFormat;
    private String objectNamePrefix;
    private String etag;
    private String selfLink;

    Builder(ProjectTopicName topic) {
      this.topic = topic;
    }

    Builder(NotificationInfo NotificationInfo) {
      generatedId = NotificationInfo.generatedId;
      etag = NotificationInfo.etag;
      selfLink = NotificationInfo.selfLink;
      topic = NotificationInfo.topic;
      eventTypes = NotificationInfo.eventTypes;
      customAttributes = NotificationInfo.customAttributes;
      payloadFormat = NotificationInfo.payloadFormat;
      objectNamePrefix = NotificationInfo.objectNamePrefix;
    }

    Builder setGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public Builder setTopic(ProjectTopicName topic) {
      this.topic = topic;
      return this;
    }

    public Builder setPayloadFormat(PayloadFormat payloadFormat) {
      this.payloadFormat = payloadFormat;
      return this;
    }

    /** GcpLaunchStage.Alpha */
    public Builder setObjectNamePrefix(String objectNamePrefix) {
      this.objectNamePrefix = objectNamePrefix;
      return this;
    }

    public Builder setEventTypes(Iterable<String> eventTypes) {
      this.eventTypes = eventTypes != null ? ImmutableList.copyOf(eventTypes) : null;
      return this;
    }

    Builder setEtag(String etag) {
      this.etag = etag;
      return this;
    }

    public Builder setCustomAttributes(Map<String, String> customAttributes) {
      this.customAttributes =
          customAttributes != null ? ImmutableMap.copyOf(customAttributes) : null;
      return this;
    }

    public NotificationInfo build() {
      checkNotNull(topic);
      return new NotificationInfo(this);
    }
  }

  NotificationInfo(Builder builder) {
    generatedId = builder.generatedId;
    etag = builder.etag;
    selfLink = builder.selfLink;
    topic = builder.topic;
    eventTypes = builder.eventTypes;
    customAttributes = builder.customAttributes;
    payloadFormat = builder.payloadFormat;
    objectNamePrefix = builder.objectNamePrefix;
  }

  /** Returns the service-generated id for the notification. */
  public String getGeneratedId() {
    return generatedId;
  }

  /** Returns the Cloud PubSub topic to which this subscription publishes. */
  public ProjectTopicName getTopic() {
    return topic;
  }

  /** Returns the canonical URI of this topic as a string. */
  public String getSelfLink() {
    return selfLink;
  }

  /** Returns the desired content of the Payload. */
  public PayloadFormat getPayloadFormat() {
    return payloadFormat;
  }

  /** Returns the object name prefix for which this notification configuration applies. */
  public String getObjectNamePrefix() {
    return objectNamePrefix;
  }

  /**
   * Returns HTTP 1.1 Entity tag for the notification.
   *
   * @see <a href="http://tools.ietf.org/html/rfc2616#section-3.11">Entity Tags</a>
   */
  public String getEtag() {
    return etag;
  }

  /**
   * Returns the list of event types that this notification will apply to. If empty, notifications
   * will be sent on all event types.
   *
   * @see <a href="https://cloud.google.com/storage/docs/cross-origin">Cross-Origin Resource Sharing
   *     (CORS)</a>
   */
  public List<String> getEventTypes() {
    return eventTypes;
  }

  /**
   * Returns the list of additional attributes to attach to each Cloud PubSub message published for\
   * this notification subscription.
   *
   * @see <a href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
   *     About Access Control Lists</a>
   */
  public Map<String, String> getCustomAttributes() {
    return customAttributes;
  }

  /** Returns a builder for the current notification. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTopic());
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(NotificationInfo.class)
            && Objects.equals(toPb(), ((NotificationInfo) obj).toPb());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("topic", getTopic()).toString();
  }

  Notification toPb() {
    Notification notificationPb = new Notification();
    notificationPb.setId(generatedId);
    notificationPb.setEtag(etag);
    if (customAttributes != null) {
      notificationPb.setCustomAttributes(customAttributes);
    }
    if (eventTypes != null) {
      notificationPb.setEventTypes(eventTypes);
    }
    if (objectNamePrefix != null) {
      notificationPb.setObjectNamePrefix(objectNamePrefix);
    }
    if (payloadFormat != null) {
      notificationPb.setPayloadFormat(payloadFormat.toString());
    } else {
      notificationPb.setPayloadFormat(PayloadFormat.NONE.toString());
    }
    notificationPb.setSelfLink(selfLink);
    notificationPb.setTopic(topic.toString());

    return notificationPb;
  }

  /** Creates a {@code NotificationInfo} object for the provided topic name. */
  public static NotificationInfo of(ProjectTopicName topic) {
    return newBuilder(topic).build();
  }

  /**
   * Returns a {@code NotificationInfo} builder where the topic's name is set to the provided name.
   */
  public static Builder newBuilder(ProjectTopicName topic) {
    return new Builder(topic);
  }

  static NotificationInfo fromPb(Notification notificationPb) {
    Builder builder = newBuilder(ProjectTopicName.parse(notificationPb.getTopic()));
    if (notificationPb.getId() != null) {
      builder.setGeneratedId(notificationPb.getId());
    }
    if (notificationPb.getEtag() != null) {
      builder.setEtag(notificationPb.getEtag());
    }
    if (notificationPb.getCustomAttributes() != null) {
      builder.setCustomAttributes(notificationPb.getCustomAttributes());
    }
    if (notificationPb.getSelfLink() != null) {
      builder.setSelfLink(notificationPb.getSelfLink());
    }
    if (notificationPb.getObjectNamePrefix() != null) {
      builder.setObjectNamePrefix(notificationPb.getObjectNamePrefix());
    }
    if (notificationPb.getTopic() != null) {
      builder.setTopic(ProjectTopicName.parse(notificationPb.getTopic()));
    }
    if (notificationPb.getEventTypes() != null) {
      builder.setEventTypes(notificationPb.getEventTypes());
    }
    if (notificationPb.getPayloadFormat() != null) {
      builder.setPayloadFormat(PayloadFormat.valueOf(notificationPb.getPayloadFormat()));
    }
    return builder.build();
  }
}
