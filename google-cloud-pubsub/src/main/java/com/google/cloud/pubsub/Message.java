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
 * <p>To be published, a message must have a non-empty payload, or at least one attribute.
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

    InternalByteArray(ByteString byteString) {
      super(byteString);
    }

    InternalByteArray(ByteArray byteArray) {
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

    abstract Builder setId(String id);

    /**
     * Sets the message payload to the provided string. The string is enconded {@code UTF-8}.
     */
    @Deprecated
    public abstract Builder payload(String payload);

    /**
     * Sets the message payload to the provided string. The string is enconded {@code UTF-8}.
     */
    public abstract Builder setPayload(String payload);

    /**
     * Sets the message payload to the provided {@link ByteArray}.
     */
    @Deprecated
    public abstract Builder payload(ByteArray payload);

    /**
     * Sets the message payload to the provided {@link ByteArray}.
     */
    public abstract Builder setPayload(ByteArray payload);

    /**
     * Sets the message attributes to the provided map. Message attributes are key-value pairs that
     * a publisher can define for a message. For example, a key {@code iana.org/language_tag} and
     * value {@code en} could be added to messages to mark them as readable by an English-speaking
     * subscriber.
     */
    @Deprecated
    public abstract Builder attributes(Map<String, String> attributes);

    /**
     * Sets the message attributes to the provided map. Message attributes are key-value pairs that
     * a publisher can define for a message. For example, a key {@code iana.org/language_tag} and
     * value {@code en} could be added to messages to mark them as readable by an English-speaking
     * subscriber.
     */
    public abstract Builder setAttributes(Map<String, String> attributes);

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

    abstract Builder setPublishTime(long publishTime);

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
    BuilderImpl setId(String id) {
      this.id = checkNotNull(id);
      return this;
    }

    @Override
    @Deprecated
    public Builder payload(String payload) {
      return setPayload(payload);
    }

    @Override
    public Builder setPayload(String payload) {
      return setPayload(ByteArray.copyFrom(payload));
    }

    @Override
    @Deprecated
    public Builder payload(ByteArray payload) {
      return setPayload(payload);
    }

    @Override
    public Builder setPayload(ByteArray payload) {
      this.payload = payload;
      return this;
    }

    @Override
    public Builder addAttribute(String name, String value) {
      attributes.put(name, value);
      return this;
    }

    @Override
    @Deprecated
    public Builder attributes(Map<String, String> attributes) {
      return setAttributes(attributes);
    }

    @Override
    public Builder setAttributes(Map<String, String> attributes) {
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
    Builder setPublishTime(long publishTime) {
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
  @Deprecated
  public Long publishTime() {
    return getPublishTime();
  }

  /**
   * Returns the time in milliseconds at which the message was published. This value is set by the
   * server when it receives the publish call. If not set, this method returns {@code null}.
   */
  public Long getPublishTime() {
    return publishTime;
  }

  /**
   * Returns the message attributes. Message attributes are key-value pairs that a publisher can
   * define for a message. For example, a key {@code iana.org/language_tag} and value {@code en}
   * could be added to messages to mark them as readable by an English-speaking subscriber.
   */
  @Deprecated
  public Map<String, String> attributes() {
    return getAttributes();
  }

  /**
   * Returns the message attributes. Message attributes are key-value pairs that a publisher can
   * define for a message. For example, a key {@code iana.org/language_tag} and value {@code en}
   * could be added to messages to mark them as readable by an English-speaking subscriber.
   */
  public Map<String, String> getAttributes() {
    return attributes;
  }

  /**
   * Returns the id of this message, set by the server when the message is published. The id is
   * guaranteed to be unique within the topic. This value may be read by a subscriber that receives
   * a Pub/Sub message via a pull call or a push delivery. If not set, this method returns
   * {@code null}.
   */
  @Deprecated
  public String id() {
    return getId();
  }

  /**
   * Returns the id of this message, set by the server when the message is published. The id is
   * guaranteed to be unique within the topic. This value may be read by a subscriber that receives
   * a Pub/Sub message via a pull call or a push delivery. If not set, this method returns
   * {@code null}.
   */
  public String getId() {
    return id;
  }

  /**
   * Returns the message payload as a string, decoded using {@code UTF-8}.
   */
  @Deprecated
  public String payloadAsString() {
    return getPayloadAsString();
  }

  /**
   * Returns the message payload as a string, decoded using {@code UTF-8}.
   */
  public String getPayloadAsString() {
    return payload.toStringUtf8();
  }

  /**
   * Returns the message payload.
   */
  @Deprecated
  public ByteArray payload() {
    return getPayload();
  }

  /**
   * Returns the message payload.
   */
  public ByteArray getPayload() {
    return payload;
  }

  final boolean baseEquals(Message message) {
    return Objects.equals(id, message.id)
        && Objects.equals(payload, message.payload)
        && Objects.equals(attributes, message.attributes)
        && Objects.equals(publishTime, message.publishTime);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
        && obj.getClass().equals(Message.class)
        && baseEquals((Message) obj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, payload, attributes, publishTime);
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
    Builder builder = newBuilder(new InternalByteArray(messagePb.getData()));
    if (messagePb.hasPublishTime()) {
      Timestamp ts = messagePb.getPublishTime();
      Long millis = ts.getSeconds() * MILLIS_PER_SECOND + ts.getNanos() / NANOS_PER_MILLISECOND;
      if (millis != 0) {
        builder.setPublishTime(millis);
      }
    }
    if (!Objects.equals(messagePb.getMessageId(), "")) {
      builder.setId(messagePb.getMessageId());
    }
    for (Map.Entry<String, String> entry : messagePb.getAttributesMap().entrySet()) {
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
    return newBuilder(payload).build();
  }

  /**
   * Creates a {@code Message} object given the payload as a {@link ByteArray}. To be published a
   * message must have a non-empty payload.
   */
  public static Message of(ByteArray payload) {
    return newBuilder(payload).build();
  }

  /**
   * Creates a builder for {@code Message} objects given the payload as a string. The string is
   * enconded using {@code UTF-8}. To be published a message must have a non-empty payload.
   */
  @Deprecated
  public static Builder builder(String payload) {
    return newBuilder(payload);
  }

  /**
   * Creates a builder for {@code Message} objects given the payload as a string. The string is
   * enconded using {@code UTF-8}. To be published a message must have a non-empty payload.
   */
  public static Builder newBuilder(String payload) {
    return new BuilderImpl().setPayload(payload);
  }

  /**
   * Creates a builder for {@code Message} objects given the payload as a {@link ByteArray}. To be
   * published a message must have a non-empty payload, or at least one attribute.
   */
  @Deprecated
  public static Builder builder(ByteArray payload) {
    return newBuilder(payload);
  }

  /**
   * Creates a builder for {@code Message} objects given the payload as a {@link ByteArray}. To be
   * published a message must have a non-empty payload, or at least one attribute.
   */
  public static Builder newBuilder(ByteArray payload) {
    return new BuilderImpl().setPayload(payload);
  }
}
