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

import java.util.Map;
import java.util.Objects;

/**
 * The class representing Pub/Sub notifications for the Storage. See <a
 * href="https://cloud.google.com/storage/docs/pubsub-notifications">pubsub-notifications</a> for
 * details.
 */
public class Notification extends NotificationInfo {
  private static final long serialVersionUID = 3150928330690874200L;

  private final StorageOptions options;
  private transient Storage storage;

  /** Builder for {@code Notification}. */
  public static class Builder extends NotificationInfo.Builder {
    private final Storage storage;
    private final NotificationInfo.BuilderImpl infoBuilder;

    Builder(Notification notification) {
      this.storage = notification.storage;
      this.infoBuilder = new NotificationInfo.BuilderImpl(notification);
    }

    @Override
    Builder setNotificationId(String notificationId) {
      infoBuilder.setNotificationId(notificationId);
      return this;
    }

    @Override
    public Builder setSelfLink(String selfLink) {
      infoBuilder.setSelfLink(selfLink);
      return this;
    }

    @Override
    public Builder setTopic(String topic) {
      infoBuilder.setTopic(topic);
      return this;
    }

    @Override
    public Builder setPayloadFormat(PayloadFormat payloadFormat) {
      infoBuilder.setPayloadFormat(payloadFormat);
      return this;
    }

    @Override
    public Builder setObjectNamePrefix(String objectNamePrefix) {
      infoBuilder.setObjectNamePrefix(objectNamePrefix);
      return this;
    }

    @Override
    public Builder setEventTypes(EventType... eventTypes) {
      infoBuilder.setEventTypes(eventTypes);
      return this;
    }

    @Override
    public Builder setEtag(String etag) {
      infoBuilder.setEtag(etag);
      return this;
    }

    @Override
    public Builder setCustomAttributes(Map<String, String> customAttributes) {
      infoBuilder.setCustomAttributes(customAttributes);
      return this;
    }

    @Override
    public Notification build() {
      return new Notification(storage, infoBuilder);
    }
  }

  Notification(Storage storage, NotificationInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.storage = checkNotNull(storage);
    this.options = storage.getOptions();
  }

  /** Returns the notification's {@code Storage} object used to issue requests. */
  public Storage getStorage() {
    return storage;
  }

  @Override
  public Builder toBuilder() {
    return new Notification.Builder(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Notification)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Notification that = (Notification) o;
    return Objects.equals(options, that.options) && Objects.equals(storage, that.storage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), options, storage);
  }
}
