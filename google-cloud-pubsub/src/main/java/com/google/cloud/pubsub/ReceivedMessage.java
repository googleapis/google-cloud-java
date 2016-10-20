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

import com.google.cloud.ByteArray;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * A Google Cloud Pub/Sub received message. A received message has all the information in
 * {@link Message} as well as the acknowledge id. The ack id can be used to acknowledge the received
 * message.
 *
 * <p>{@code ReceivedMessage} also adds a layer of service-related functionality over
 * {@link Message} that help manage received messages (see {@link #ack()}, {@link #nack()} and
 * {@link #modifyAckDeadline(int, TimeUnit)}).
 */
public final class ReceivedMessage extends Message {

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
    Builder setId(String id) {
      delegate.setId(id);
      return this;
    }

    @Override
    @Deprecated
    public Builder payload(String payload) {
      return setPayload(payload);
    }

    @Override
    public Builder setPayload(String payload) {
      delegate.setPayload(payload);
      return this;
    }

    @Override
    @Deprecated
    public Builder payload(ByteArray payload) {
      return setPayload(payload);
    }

    @Override
    public Builder setPayload(ByteArray payload) {
      delegate.setPayload(payload);
      return this;
    }

    @Override
    @Deprecated
    public Builder attributes(Map<String, String> attributes) {
      return setAttributes(attributes);
    }

    @Override
    public Builder setAttributes(Map<String, String> attributes) {
      delegate.setAttributes(attributes);
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
    Builder setPublishTime(long publishTime) {
      delegate.setPublishTime(publishTime);
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
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(ReceivedMessage.class)) {
      return false;
    }
    ReceivedMessage other = (ReceivedMessage) obj;
    return baseEquals(other) && Objects.equals(options, other.options);
  }

  /**
   * Returns the received message's {@code PubSub} object used to issue requests.
   */
  @Deprecated
  public PubSub pubsub() {
    return getPubsub();
  }

  /**
   * Returns the received message's {@code PubSub} object used to issue requests.
   */
  public PubSub getPubsub() {
    return pubsub;
  }

  /**
   * Returns the name of the subscription this message was received from.
   */
  @Deprecated
  public String subscription() {
    return getSubscription();
  }

  /**
   * Returns the name of the subscription this message was received from.
   */
  public String getSubscription() {
    return subscription;
  }

  /**
   * Returns the acknowledge id of the message. The ack id can be used to acknowledge the received
   * message.
   */
  @Deprecated
  public String ackId() {
    return getAckId();
  }

  /**
   * Returns the acknowledge id of the message. The ack id can be used to acknowledge the received
   * message.
   */
  public String getAckId() {
    return ackId;
  }

  /**
   * Acknowledges the current message.
   *
   * @throws PubSubException upon failure, or if the subscription was not found
   */
  public void ack() {
    pubsub.ack(subscription, ackId);
  }

  /**
   * Sends a request to acknowledge the current message. The method returns a {@code Future} object
   * that can be used to wait for the acknowledge operation to be completed.
   *
   * @throws PubSubException upon failure, or if the subscription was not found
   */
  public Future<Void> ackAsync() {
    return pubsub.ackAsync(subscription, ackId);
  }

  /**
   * "Nacks" the current message. This method corresponds to calling
   * {@link #modifyAckDeadline(int, TimeUnit)} with a deadline of 0.
   *
   * @throws PubSubException upon failure, or if the subscription was not found
   */
  public void nack() {
    pubsub.nack(subscription, ackId);
  }

  /**
   * Sends a request to "nack" the current message. This method corresponds to calling
   * {@link #modifyAckDeadlineAsync(int, TimeUnit)} with a deadline of 0. The method returns a
   * {@code Future} object that can be used to wait for the "nack" operation to be completed.
   *
   * @throws PubSubException upon failure, or if the subscription was not found
   */
  public Future<Void> nackAsync() {
    return pubsub.nackAsync(subscription, ackId);
  }

  /**
   * Modifies the acknowledge deadline of the current message. {@code deadline} must be &gt;= 0 and
   * is the new deadline with respect to the time the modify request was received by the Pub/Sub
   * service. For example, if {@code deadline} is 10 and {@code unit} is {@link TimeUnit#SECONDS},
   * the new ack deadline will expire 10 seconds after the modify request was received by the
   * service. Specifying 0 may be used to make the message available for another pull request
   * (corresponds to calling {@link #nack()}.
   *
   * @param deadline the new deadline, relative to the time the modify request is received by the
   *     Pub/Sub service
   * @param unit {@code deadline} time unit
   * @throws PubSubException upon failure, or if the subscription was not found
   */
  public void modifyAckDeadline(int deadline, TimeUnit unit) {
    pubsub.modifyAckDeadline(subscription, deadline, unit, ackId);
  }

  /**
   * Sends a request to modify the acknowledge deadline of the given messages. {@code deadline}
   * must be &gt;= 0 and is the new deadline with respect to the time the modify request was
   * received by the Pub/Sub service. For example, if {@code deadline} is 10 and {@code unit} is
   * {@link TimeUnit#SECONDS}, the new ack deadline will expire 10 seconds after the modify request
   * was received by the service. Specifying 0 may be used to make the message available for another
   * pull request (corresponds to calling {@link #nackAsync()}. The method returns a {@code Future}
   * object that can be used to wait for the modify operation to be completed.
   *
   * @param deadline the new deadline, relative to the time the modify request is received by the
   *     Pub/Sub service
   * @param unit {@code deadline} time unit
   * @throws PubSubException upon failure, or if the subscription was not found
   */
  public Future<Void> modifyAckDeadlineAsync(int deadline, TimeUnit unit) {
    return pubsub.modifyAckDeadlineAsync(subscription, deadline, unit, ackId);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    this.pubsub = options.service();
  }

  static ReceivedMessage fromPb(PubSub pubsub, String subscription,
      com.google.pubsub.v1.ReceivedMessage msgPb) {
    Message message = fromPb(msgPb.getMessage());
    String ackId = msgPb.getAckId();
    return new Builder(subscription, ackId, pubsub, new BuilderImpl(message)).build();
  }
}
