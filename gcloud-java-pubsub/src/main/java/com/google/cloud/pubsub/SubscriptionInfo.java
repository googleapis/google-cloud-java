/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.pubsub;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * Pub/Sub subscription information.
 */
public class SubscriptionInfo implements Serializable {

  private static final long serialVersionUID = 1860057426574127128L;

  private final String name;
  private final String topic;
  private final PushConfig pushConfig;
  private final int ackDeadlineSeconds;


  /**
   * Builder for Subscription.
   */
  public abstract static class Builder {

    public abstract Builder name(String name);

    public abstract Builder topic(String name);

    public abstract Builder pushConfig(PushConfig pushConfig);

    public abstract Builder ackDeadLineSeconds(int ackDeadLineSeconds);

    public abstract SubscriptionInfo build();
  }

  static final class BuilderImpl extends Builder {

    private String name;
    private String topic;
    private PushConfig pushConfig;
    private int ackDeadlineSeconds;

    private BuilderImpl(String topic, String name) {
      this.topic = checkNotNull(topic);
      this.name = checkNotNull(name);
    }

    BuilderImpl(SubscriptionInfo subscription) {
      name = subscription.name;
      topic = subscription.topic;
      pushConfig = subscription.pushConfig;
      ackDeadlineSeconds = subscription.ackDeadlineSeconds;
    }

    @Override
    public Builder name(String name) {
      this.name = checkNotNull(name);
      return this;
    }

    @Override
    public Builder topic(String topic) {
      this.topic = checkNotNull(topic);
      return this;
    }

    @Override
    public Builder pushConfig(PushConfig pushConfig) {
      this.pushConfig = pushConfig;
      return this;
    }

    @Override
    public Builder ackDeadLineSeconds(int ackDeadlineSeconds) {
      this.ackDeadlineSeconds = ackDeadlineSeconds;
      return this;
    }

    @Override
    public SubscriptionInfo build() {
      return new SubscriptionInfo(this);
    }
  }

  SubscriptionInfo(BuilderImpl builder) {
    topic = builder.topic;
    name = builder.name;
    pushConfig = builder.pushConfig;
    ackDeadlineSeconds = builder.ackDeadlineSeconds;
  }

  public String topic() {
    return topic;
  }

  public String name() {
    return name;
  }

  public PushConfig pushConfig() {
    return pushConfig;
  }

  public long ackDeadlineSeconds() {
    return ackDeadlineSeconds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return Objects.equals(toPb(), ((SubscriptionInfo) o).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(topic, name, pushConfig, ackDeadlineSeconds);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("topic", topic)
        .add("name", name)
        .add("pushConfig", pushConfig)
        .add("ackDeadlineSeconds", ackDeadlineSeconds)
        .toString();
  }

  com.google.pubsub.v1.Subscription toPb() {
    com.google.pubsub.v1.Subscription.Builder builder =
        com.google.pubsub.v1.Subscription.newBuilder();
    builder.setTopic(topic);
    builder.setName(name);
    builder.setAckDeadlineSeconds(ackDeadlineSeconds);
    if (pushConfig != null) {
      builder.setPushConfig(pushConfig.toPb());
    }
    return builder.build();
  }

  static SubscriptionInfo fromPb(com.google.pubsub.v1.Subscription subscription) {
    Builder builder = builder(subscription.getTopic(), subscription.getName());
    builder.ackDeadLineSeconds(subscription.getAckDeadlineSeconds());
    if (subscription.hasPushConfig()) {
      builder.pushConfig(PushConfig.fromPb(subscription.getPushConfig()));
    }
    return builder.build();
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static SubscriptionInfo of(String topic, String name) {
    return builder(topic, name).build();
  }

  public static SubscriptionInfo of(String topic, String name, String endpoint) {
    return builder(topic, name).pushConfig(PushConfig.of(endpoint)).build();
  }

  public static Builder builder(String topic, String name) {
    return new BuilderImpl(topic, name);
  }
}
