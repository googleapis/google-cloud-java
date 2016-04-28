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
 * Pub/Sub message.
 */
public class Message implements Serializable {

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
   * Builder for Message.
   */
  public abstract static class Builder {

    abstract Builder id(String id);

    public abstract Builder payload(String payload);

    public abstract Builder payload(ByteArray payload);

    public abstract Builder attributes(Map<String, String> attributes);

    public abstract Builder addAttribute(String name, String value);

    public abstract Builder removeAttribute(String name);

    public abstract Builder clearAttributes();

    abstract Builder publishTime(long publishTime);

    public abstract Message build();
  }

  static final class BuilderImpl extends Builder {

    private String id = "";
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

  public Long publishTime() {
    return publishTime;
  }

  public Map<String, String> attributes() {
    return attributes;
  }

  public String id() {
    return id;
  }

  public String payloadAsString() {
    return payload.toStringUtf8();
  }

  public ByteArray payload() {
    return payload;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return Objects.equals(toPb(), ((Message) o).toPb());
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
    builder.getAttributes().putAll(attributes);
    Timestamp.Builder tsBuilder = Timestamp.newBuilder();
    tsBuilder.setSeconds(publishTime / MILLIS_PER_SECOND);
    tsBuilder.setNanos((int) (publishTime % MILLIS_PER_SECOND * NANOS_PER_MILLISECOND));
    builder.setPublishTime(tsBuilder);
    return builder.build();
  }

  static Message fromPb(PubsubMessage messagePb) {
    Builder builder = builder(new InternalByteArray(messagePb.getData()));
    if (messagePb.hasPublishTime()) {
      Timestamp ts = messagePb.getPublishTime();
      builder.publishTime(
          ts.getSeconds() * MILLIS_PER_SECOND + ts.getNanos() / NANOS_PER_MILLISECOND);
    }
    builder.id(messagePb.getMessageId());
    for (Map.Entry<String, String> entry : messagePb.getAttributes().entrySet()) {
      builder.addAttribute(entry.getKey(), entry.getValue());
    }
    return builder.build();
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Message of(String payload) {
    return builder(payload).build();
  }

  public static Builder builder(String payload) {
    return new BuilderImpl().payload(payload);
  }

  public static Builder builder(ByteArray payload) {
    return new BuilderImpl().payload(payload);
  }
}
