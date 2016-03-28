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

import com.google.cloud.pubsub.PubSub.PullOption;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;

/**
 * PubSub subscription.
 */
public class Subscription extends SubscriptionInfo {

  private static final long serialVersionUID = -4153366055659552230L;

  private final PubSubOptions options;
  private transient PubSub pubsub;

  public static final class Builder extends SubscriptionInfo.Builder {

    private final PubSub pubsub;
    private final BuilderImpl delegate;

    private Builder(Subscription subscription) {
      pubsub = subscription.pubsub;
      delegate = new BuilderImpl(subscription);
    }

    @Override
    public Builder topic(String name) {
      delegate.topic(name);
      return this;
    }

    @Override
    public Builder name(String name) {
      delegate.name(name);
      return this;
    }

    @Override
    public Builder pushConfig(PushConfig pushConfig) {
      delegate.pushConfig(pushConfig);
      return this;
    }

    @Override
    public Builder ackDeadLineSeconds(int ackDeadLineSeconds) {
      delegate.ackDeadLineSeconds(ackDeadLineSeconds);
      return this;
    }

    @Override
    public Subscription build() {
      return new Subscription(this.pubsub, this.delegate);
    }
  }

  Subscription(PubSub pubsub, BuilderImpl builder) {
    super(builder);
    this.pubsub = checkNotNull(pubsub);
    options = pubsub.options();
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(options, super.hashCode());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Subscription other = (Subscription) obj;
    return Objects.equals(toPb(), other.toPb()) && Objects.equals(options, other.options);
  }

  public PubSub pubSub() {
    return pubsub;
  }

  public boolean delete() {
    return pubsub.deleteSubscription(name());
  }

  public Future<Boolean> deleteAsync() {
    return pubsub.deleteSubscriptionAsync(name());
  }

  public Subscription reload() {
    return pubsub.getSubscription(name());
  }

  public Future<Subscription> reloadAsync() {
    return pubsub.getSubscriptionAsync(name());
  }

  public void replacePushConfig(PushConfig pushConfig) {
    pubsub.replacePushConfig(name(), pushConfig);
  }

  public Future<Void> replacePushConfigAsync(PushConfig pushConfig) {
    return pubsub.replacePushConfigAsync(name(), pushConfig);
  }

  public List<ReceivedMessage> pull(PullOption... options) {
    return pubsub.pull(name(), options);
  }

  public Future<List<Message>> pullAsync(PullOption... options) {
    return pubsub.pullAsync(name(), options);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    this.pubsub = options.service();
  }

  static Subscription fromPb(PubSub storage, com.google.pubsub.v1.Subscription subscriptionPb) {
    SubscriptionInfo subscriptionInfo = SubscriptionInfo.fromPb(subscriptionPb);
    return new Subscription(storage, new BuilderImpl(subscriptionInfo));
  }
}
