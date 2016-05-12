/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.pubsub;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.ByteArray;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.pubsub.v1.PubsubMessage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A Google Cloud Pub/Sub message. A message is the combination of data and (optional) attributes
 * that a publisher sends to a topic and is eventually delivered to subscribers.
 *
 * <p>Message attributes are key-value pairs that a publisher can define for a message. For example,
 * a key {@code iana.org/language_tag} and value {@code en} could be added to messages to mark them
 * as readable by an English-speaking subscriber.
 *
 * <p>To be published a message must have a non-empty payload, or at least one attribute.
 *
 * @see <a href="https://cloud.google.com/pubsub/overview#data_model">Pub/Sub Data Model</a>
 */
public class Message implements Serializable {

  static final Function<Message, PubsubMessage> TO_PB_FUNCTION =
      new Function<Message, PubsubMessage>() {
        @Override
        public PubsubMessage apply(Message message) {
          return message.toPb();
        }
      };

  private static final long serialVersionUID = -1436515787233340634L;
  private static final long NANOS_PER_MILLISECOND = 1000000;
  private static final long MILLIS_PER_SECOND = 1000;

  private final String id;
  private final InternalByteArray payload;
  private final ImmutableMap<String, String> attributes;
  private final Long publishTime;

  private static final class InternalByteArray extends ByteArray {

    private static final long serialVersionUID = -3330181485911805428L;

    protected InternalByteArray(ByteString byteString) {
      super(byteString);
    }

    protected InternalByteArray(ByteArray byteArray) {
      super(byteArray);
    }

    @Override
    protected ByteString byteString() {
      return super.byteString();
    }
  }

  /**
   * Builder for {@code Message} objects.
   */
  public abstract static class Builder {

    abstract Builder id(String id);

    /**
     * Sets the message payload to the provided string. The string is enconded {@code UTF-8}.
     */
    public abstract Builder payload(String payload);

    /**
     * Sets the message payload to the provided {@link ByteArray}.
     */
    public abstract Builder payload(ByteArray payload);

    /**
     * Sets the message attributes to the provided map. Message attributes are key-value pairs that
     * a publisher can define for a message. For example, a key {@code iana.org/language_tag} and
     * value {@code en} could be added to messages to mark them as readable by an English-speaking
     * subscriber.
     */
    public abstract Builder attributes(Map<String, String> attributes);

    /**
     * Adds a new attribute to the message attributes. If an attribute with name {@code name} was
     * already set, its value is updated.
     */
    public abstract Builder addAttribute(String name, String value);

    /**
     * Removes an attribute give its name from the message attributes.
     */
    public abstract Builder removeAttribute(String name);

    /**
     * Clears all message attributes.
     */
    public abstract Builder clearAttributes();

    abstract Builder publishTime(long publishTime);

    /**
     * Creates a message object.
     */
    public abstract Message build();
  }

  static final class BuilderImpl extends Builder {

    private String id;
    private ByteArray payload;
    private Map<String, String> attributes = new HashMap<>();
    private Long publishTime;

    private BuilderImpl() {}

    BuilderImpl(Message message) {
      id = message.id;
      payload = message.payload;
      attributes = new HashMap<>(message.attributes);
      publishTime = message.publishTime;
    }

    @Override
    BuilderImpl id(String id) {
      this.id = checkNotNull(id);
      return this;
    }

    @Override
    public Builder payload(String payload) {
      return payload(ByteArray.copyFrom(payload));
    }

    @Override
    public Builder payload(ByteArray payload) {
      this.payload = payload;
      return this;
    }

    @Override
    public Builder addAttribute(String name, String value) {
      attributes.put(name, value);
      return this;
    }

    @Override
    public Builder attributes(Map<String, String> attributes) {
      this.attributes = new HashMap<>(attributes);
      return this;
    }

    @Override
    public Builder removeAttribute(String name) {
      attributes.remove(name);
      return this;
    }

    @Override
    public Builder clearAttributes() {
      attributes.clear();
      return this;
    }

    @Override
    Builder publishTime(long publishTime) {
      this.publishTime = publishTime;
      return this;
    }

    @Override
    public Message build() {
      return new Message(this);
    }
  }

  Message(BuilderImpl builder) {
    id = builder.id;
    payload = new InternalByteArray(checkNotNull(builder.payload));
    attributes = ImmutableMap.copyOf(builder.attributes);
    publishTime = builder.publishTime;
  }

  /**
   * Returns the time in milliseconds at which the message was published. This value is set by the
   * server when it receives the publish call. If not set, this method returns {@code null}.
   */
  public Long publishTime() {
    return publishTime;
  }

  /**
   * Returns the message attributes. Message attributes are key-value pairs that a publisher can
   * define for a message. For example, a key {@code iana.org/language_tag} and value {@code en}
   * could be added to messages to mark them as readable by an English-speaking subscriber.
   */
  public Map<String, String> attributes() {
    return attributes;
  }

  /**
   * Returns the id of this message, set by the server when the message is published. The id is
   * guaranteed to be unique within the topic. This value may be read by a subscriber that receives
   * a Pub/Sub message via a pull call or a push delivery. If not set, this method returns
   * {@code null}.
   */
  public String id() {
    return id;
  }

  /**
   * Returns the message payload as a string, decoded using {@code UTF-8}.
   */
  public String payloadAsString() {
    return payload.toStringUtf8();
  }

  /**
   * Returns the message payload.
   */
  public ByteArray payload() {
    return payload;
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
        && obj.getClass().equals(Message.class)
        && Objects.equals(toPb(), ((Message) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(serialVersionUID, id, payload, attributes, publishTime);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("payload", payload)
        .add("attributes", attributes)
        .add("publishTime", publishTime)
        .toString();
  }

  PubsubMessage toPb() {
    PubsubMessage.Builder builder = PubsubMessage.newBuilder();
    if (id != null) {
      builder.setMessageId(id);
    }
    builder.setData(payload.byteString());
    builder.putAllAttributes(attributes);
    Timestamp.Builder tsBuilder = Timestamp.newBuilder();
    if (publishTime != null) {
      tsBuilder.setSeconds(publishTime / MILLIS_PER_SECOND);
      tsBuilder.setNanos((int) (publishTime % MILLIS_PER_SECOND * NANOS_PER_MILLISECOND));
    }
    builder.setPublishTime(tsBuilder);
    return builder.build();
  }

  static Message fromPb(PubsubMessage messagePb) {
    Builder builder = builder(new InternalByteArray(messagePb.getData()));
    if (messagePb.hasPublishTime()) {
      Timestamp ts = messagePb.getPublishTime();
      Long millis = ts.getSeconds() * MILLIS_PER_SECOND + ts.getNanos() / NANOS_PER_MILLISECOND;
      if (millis != 0) {
        builder.publishTime(millis);
      }
    }
    if (!Objects.equals(messagePb.getMessageId(), "")) {
      builder.id(messagePb.getMessageId());
    }
    for (Map.Entry<String, String> entry : messagePb.getAttributes().entrySet()) {
      builder.addAttribute(entry.getKey(), entry.getValue());
    }
    return builder.build();
  }

  /**
   * Returns a builder for the message object.
   */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  /**
   * Creates a {@code Message} object given the payload as a string. The string is enconded using
   * {@code UTF-8}.
   */
  public static Message of(String payload) {
    return builder(payload).build();
  }

  /**
   * Creates a {@code Message} object given the payload as a {@link ByteArray}. To be published a
   * message must have a non-empty payload.
   */
  public static Message of(ByteArray payload) {
    return builder(payload).build();
  }

  /**
   * Creates a builder for {@code Message} objects given the payload as a string. The string is
   * enconded using {@code UTF-8}. To be published a message must have a non-empty payload.
   */
  public static Builder builder(String payload) {
    return new BuilderImpl().payload(payload);
  }

  /**
   * Creates a builder for {@code Message} objects given the payload as a {@link ByteArray}. To be
   * published a message must have a non-empty payload, or at least one attribute.
   */
  public static Builder builder(ByteArray payload) {
    return new BuilderImpl().payload(payload);
  }
}
