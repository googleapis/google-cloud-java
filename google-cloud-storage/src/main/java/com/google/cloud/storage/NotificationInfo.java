/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.transform;

import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.services.storage.model.Notification;
import com.google.cloud.storage.Acl.Entity;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Google Storage bucket metadata;
 *
 * @see <a href="https://cloud.google.com/storage/docs/concepts-techniques#concepts">Concepts and
 *      Terminology</a>
 */
public class NotificationInfo implements Serializable {
  public enum PayloadFormat {
    JSON_API_V1,
    NONE
  }

  static final Function<com.google.api.services.storage.model.Notification, NotificationInfo> FROM_PB_FUNCTION =
      new Function<com.google.api.services.storage.model.Notification, NotificationInfo>() {
        @Override
        public NotificationInfo apply(com.google.api.services.storage.model.Notification pb) {
          return NotificationInfo.fromPb(pb);
        }
      };
  static final Function<NotificationInfo, com.google.api.services.storage.model.Notification> TO_PB_FUNCTION =
      new Function<NotificationInfo, com.google.api.services.storage.model.Notification>() {
        @Override
        public com.google.api.services.storage.model.Notification apply(NotificationInfo NotificationInfo) {
          return NotificationInfo.toPb();
        }
      };
  // private static final long serialVersionUID = -4712013629621638459L;
  private final String generatedId;
  private final String topic;
  private final List<String> eventTypes;
  private final Map<String, String> customAttributes;
  private final PayloadFormat payloadFormat;
  private final String objectNamePrefix;
  private final String etag;
  private final String selfLink;

  /**
   * Builder for {@code NotificationInfo}.
   */
  public abstract static class Builder {
    Builder() {
    }

    abstract Builder setGeneratedId(String generatedId);

    abstract Builder setSelfLink(String selfLink);

    /**
     * Sets the Cloud PubSub topic to which this subscription publishes.
     * Formatted as: '//pubsub.googleapis.com/projects/{project-identifier}/topics/{my-topic}'
     */
    public abstract Builder setTopic(String topic);

    /**
     * Sets the event types for which notifications will be sent. If empty, send notifications for
     * all event types.
     */
    public abstract Builder setEventTypes(Iterable<String> eventTypes);

    /**
     * Sets the desired content of the Payload
     */
    public abstract Builder setPayloadFormat(PayloadFormat payloadFormat);

    /**
     * Sets the prefix that names of objects must match in order to have this notification
     * configuration apply.
     */
    public abstract Builder setObjectNamePrefix(String objectNamePrefix);

    /**
     * Sets the list of additional attributes to attach to each Cloud PubSub message published for
     * this notification subscription.
     */
    public abstract Builder setCustomAttributes(Map<String, String> customAttributes);

    abstract Builder setEtag(String etag);

    /**
     * Creates a {@code NotificationInfo} object.
     */
    public abstract NotificationInfo build();
  }

  static final class BuilderImpl extends Builder {

    private String generatedId;
    private String topic;
    private List<String> eventTypes;
    private Map<String, String> customAttributes;
    private PayloadFormat payloadFormat;
    private String objectNamePrefix;
    private String etag;
    private String selfLink;

    BuilderImpl(String generatedId) {
      this.generatedId = generatedId;
    }

    BuilderImpl(NotificationInfo NotificationInfo) {
      generatedId = NotificationInfo.generatedId;
      etag = NotificationInfo.etag;
      selfLink = NotificationInfo.selfLink;
      topic = NotificationInfo.topic;
      eventTypes = NotificationInfo.eventTypes;
      customAttributes = NotificationInfo.customAttributes;
      payloadFormat = NotificationInfo.payloadFormat;
      objectNamePrefix = NotificationInfo.objectNamePrefix;
    }

    @Override
    Builder setGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    @Override
    Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    @Override
    public Builder setTopic(String topic) {
      this.topic = topic;
      return this;
    }

    @Override
    public Builder setPayloadFormat(PayloadFormat enable) {
      this.payloadFormat = payloadFormat;
      return this;
    }

    /** GcpLaunchStage.Alpha */
    @Override
    public Builder setObjectNamePrefix(String objectNamePrefix) {
      this.objectNamePrefix = objectNamePrefix;
      return this;
    }

    @Override
    public Builder setEventTypes(Iterable<String> eventTypes) {
      this.eventTypes = eventTypes != null ? ImmutableList.copyOf(eventTypes) : null;
      return this;
    }

    @Override
    Builder setEtag(String etag) {
      this.etag = etag;
      return this;
    }

    @Override
    public Builder setCustomAttributes(Map<String, String> customAttributes) {
      this.customAttributes = customAttributes != null ? ImmutableMap.copyOf(customAttributes) : null;
      return this;
    }

    @Override
    public NotificationInfo build() {
      checkNotNull(generatedId);
      return new NotificationInfo(this);
    }
  }

  NotificationInfo(BuilderImpl builder) {
    generatedId = builder.generatedId;
    etag = builder.etag;
    selfLink = builder.selfLink;
    topic = builder.topic;
    eventTypes = builder.eventTypes;
    customAttributes = builder.customAttributes;
    payloadFormat = builder.payloadFormat;
    objectNamePrefix = builder.objectNamePrefix;
  }

  // TODO(andrealin): method comments for the getters.
  /**
   * Returns the service-generated id for the bucket.
   */
  public String getGeneratedId() {
    return generatedId;
  }

  /**
   * Returns the bucket's owner. This is always the project team's owner group.
   */
  public String getTopic() {
    return topic;
  }

  /**
   * Returns the URI of this bucket as a string.
   */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * Returns {@code true} if versioning is fully enabled for this bucket, {@code false} otherwise.
   */
  public PayloadFormat getPayloadFormat() {
    return payloadFormat;
  }

  /**
   * Returns bucket's website index page. Behaves as the bucket's directory index where missing
   * blobs are treated as potential directories.
   */
  public String getObjectNamePrefix() {
    return objectNamePrefix;
  }

  /**
   * Returns HTTP 1.1 Entity tag for the bucket.
   *
   * @see <a href="http://tools.ietf.org/html/rfc2616#section-3.11">Entity Tags</a>
   */
  public String getEtag() {
    return etag;
  }

  /**
   * Returns the bucket's Cross-Origin Resource Sharing (CORS) configuration.
   *
   * @see <a href="https://cloud.google.com/storage/docs/cross-origin">
   *     Cross-Origin Resource Sharing (CORS)</a>
   */
  public List<String> getEventTypes() {
    return eventTypes;
  }

  /**
   * Returns the bucket's access control configuration.
   *
   * @see <a href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
   *     About Access Control Lists</a>
   */
  public Map<String, String> getCustomAttributes() {
    return customAttributes;
  }

  /**
   * Returns a builder for the current bucket.
   */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getGeneratedId());
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
    return MoreObjects.toStringHelper(this)
        .add("id", getGeneratedId())
        .toString();
  }

  com.google.api.services.storage.model.Notification toPb() {
    com.google.api.services.storage.model.Notification notificationPb =
        new com.google.api.services.storage.model.Notification();
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
    }
    notificationPb.setSelfLink(selfLink);
    notificationPb.setTopic(topic);

    return notificationPb;
  }

  /**
   * Creates a {@code NotificationInfo} object for the provided bucket name.
   */
  public static NotificationInfo of(String name) {
    return newBuilder(name).build();
  }

  /**
   * Returns a {@code NotificationInfo} builder where the bucket's name is set to the provided name.
   */
  public static Builder newBuilder(String name) {
    return new BuilderImpl(name);
  }

  static NotificationInfo fromPb(com.google.api.services.storage.model.Notification notificationPb) {
    Builder builder = new BuilderImpl(notificationPb.getId());
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
      builder.setTopic(notificationPb.getTopic());
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
