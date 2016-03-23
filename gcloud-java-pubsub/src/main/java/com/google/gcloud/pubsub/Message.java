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

package com.google.gcloud.pubsub;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.util.Strings;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;

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
  private final ByteString payload;
  private final ImmutableMap<String, String> attributes;
  private final Long publishTime;

  abstract static class Builder {

    abstract Builder id(String id);

    public abstract Builder payload(byte[] payload);

    public abstract Builder addAttribute(String name, String value);

    public abstract Builder removeAttribute(String name);

    public abstract Builder clearAttributes();

    abstract Builder publishTime(Long publishTime);

    public abstract Message build();
  }

  /**
   * Builder for Message.
   */
  public static final class BuilderImpl extends Builder {

    private String id;
    private byte[] payload;
    private Map<String, String> attributes = new HashMap<>();
    private Long publishTime;

    private BuilderImpl() {}

    BuilderImpl(Message message) {
      id = message.id;
      payload = message.payload.toByteArray();
      attributes = new HashMap<>(message.attributes);
      publishTime = message.publishTime;
    }

    @Override
    BuilderImpl id(String id) {
      this.id = id;
      return this;
    }

    @Override
    public Builder payload(byte[] payload) {
      this.payload = checkNotNull(payload);
      return this;
    }

    @Override
    public Builder addAttribute(String name, String value) {
      attributes.put(name, value);
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
    Builder publishTime(Long publishTime) {
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
    payload = ByteString.copyFrom(checkNotNull(builder.payload));
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

  public byte[] payload() {
    return payload.toByteArray();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return Objects.equals(toPb(), ((Message)o).toPb());
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

  com.google.pubsub.v1.PubsubMessage toPb() {
    com.google.pubsub.v1.PubsubMessage.Builder builder =
        com.google.pubsub.v1.PubsubMessage.newBuilder();
    if (id != null) {
      builder.setMessageId(id);
    }
    builder.setData(payload);
    builder.getAttributes().putAll(attributes);
    if (publishTime != null) {
      Timestamp.Builder tsBuilder = Timestamp.newBuilder();
      tsBuilder.setSeconds(publishTime / MILLIS_PER_SECOND);
      tsBuilder.setNanos((int) (publishTime % MILLIS_PER_SECOND * NANOS_PER_MILLISECOND));
      builder.setPublishTime(tsBuilder);
    }
    return builder.build();
  }

  static Message fromPb(com.google.pubsub.v1.PubsubMessage messagePb) {
    Builder builder = builder();
    if (messagePb.hasPublishTime()) {
      Timestamp ts = messagePb.getPublishTime();
      builder.publishTime(
          ts.getSeconds() * MILLIS_PER_SECOND + ts.getNanos() / NANOS_PER_MILLISECOND);
    }
    if (Strings.isNullOrEmpty(messagePb.getMessageId())) {
      builder.id(messagePb.getMessageId());
    }
    for (Map.Entry<String, String> entry : messagePb.getAttributes().entrySet()) {
      builder.addAttribute(entry.getKey(), entry.getValue());
    }
    builder.payload(messagePb.getData().toByteArray());
    return builder.build();
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Message of(byte[] payload) {
    return builder().payload(payload).build();
  }

  public static Builder builder() {
    return new BuilderImpl();
  }
}
