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

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ReceivedMessage extends Message {

  private static final long serialVersionUID = -4178477763916251733L;

  private final String subscription;
  private final String ackId;
  private transient PubSub pubsub;
  private final PubSubOptions options;

  public static final class Builder extends Message.Builder {

    private final String subscription;
    private final String ackId;
    private final PubSub pubsub;
    private final BuilderImpl delegate;

    private Builder(String subscription, String ackId, PubSub pubsub, BuilderImpl delegate) {
      this.subscription = subscription;
      this.ackId = ackId;
      this.pubsub = pubsub;
      this.delegate = delegate;
    }

    @Override
    Builder id(String id) {
      delegate.id(id);
      return this;
    }

    @Override
    public Builder payload(byte[] payload) {
      delegate.payload(payload);
      return this;
    }

    @Override
    public Builder attributes(Map<String, String> attributes) {
      delegate.attributes(attributes);
      return this;
    }

    @Override
    public Builder addAttribute(String name, String value) {
      delegate.addAttribute(name, value);
      return this;
    }

    @Override
    public Builder removeAttribute(String name) {
      delegate.removeAttribute(name);
      return this;
    }

    @Override
    public Builder clearAttributes() {
      delegate.clearAttributes();
      return this;
    }

    @Override
    Builder publishTime(Long publishTime) {
      delegate.publishTime(publishTime);
      return this;
    }

    @Override
    public ReceivedMessage build() {
      return new ReceivedMessage(this);
    }
  }

  ReceivedMessage(Builder builder) {
    super(builder.delegate);
    subscription = checkNotNull(builder.subscription);
    ackId = checkNotNull(builder.ackId);
    pubsub = checkNotNull(builder.pubsub);
    options = pubsub.options();
  }

  @Override
  public Builder toBuilder() {
    return new Builder(subscription, ackId, pubsub, new BuilderImpl(this));
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
    ReceivedMessage other = (ReceivedMessage) obj;
    return Objects.equals(toPb(), other.toPb()) && Objects.equals(options, other.options);
  }

  public PubSub pubSub() {
    return pubsub;
  }

  public String subscription() {
    return subscription;
  }

  public String ackId() {
    return ackId;
  }

  public void acknowledge() {
    pubsub.acknowledge(subscription, ackId);
  }

  public Future<Void> acknowledgeAsync() {
    return pubsub.acknowledgeAsync(subscription, ackId);
  }

  public void modifyAckDeadline(int deadline, TimeUnit unit) {
    pubsub.modifyAckDeadline(subscription, deadline, unit, ackId);
  }

  public Future<Void> modifyAckDeadlineAsync(int deadline, TimeUnit unit) {
    return pubsub.modifyAckDeadlineAsync(subscription, deadline, unit, ackId);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.pubsub = options.service();
  }

  static ReceivedMessage fromPb(PubSub storage, String subscription,
      com.google.pubsub.v1.ReceivedMessage msgPb) {
    Message message = fromPb(msgPb.getMessage());
    String ackId = msgPb.getAckId();
    return new Builder(subscription, ackId, storage, new BuilderImpl(message)).build();
  }
}
