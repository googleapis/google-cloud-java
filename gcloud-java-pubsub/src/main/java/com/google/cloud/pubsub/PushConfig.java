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
import com.google.common.collect.ImmutableMap;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * PubSub subscription push configuration.
 */
public final class PushConfig implements Serializable {

  private static final long serialVersionUID = 4408885787064092231L;

  private final String endpoint;
  private final ImmutableMap<String, String> attributes;

  public static final class Builder {

    private String endpoint;
    private final Map<String, String> attributes = new HashMap<>();

    private Builder() {
    }

    public Builder endPoint(String endpoint) {
      this.endpoint = checkNotNull(endpoint);
      return this;
    }

    public Builder addAttribute(String name, String value) {
      attributes.put(name, value);
      return this;
    }

    public Builder removeAttribute(String name) {
      attributes.remove(name);
      return this;
    }

    public Builder clearAttributes() {
      attributes.clear();
      return this;
    }

    public PushConfig build() {
      return new PushConfig(this);
    }
  }

  private PushConfig(Builder builder) {
    endpoint = builder.endpoint;
    attributes = ImmutableMap.copyOf(builder.attributes);
  }

  public String endpoint() {
    return endpoint;
  }

  public Map<String, String> attributes() {
    return attributes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PushConfig that = (PushConfig) o;
    return Objects.equals(endpoint, that.endpoint) && Objects.equals(attributes, that.attributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endpoint, attributes);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("attributes", attributes)
        .add("endpoint", endpoint)
        .toString();
  }

  public Builder toBuilder() {
    return builder(endpoint, attributes);
  }

  public static PushConfig of(String endpoint) {
    return builder(endpoint).build();
  }

  public static PushConfig of(String endpoint, Map<String, String> attributes) {
    return builder(endpoint, attributes).build();
  }

  public static Builder builder(String endPoint) {
    return new Builder().endPoint(endPoint);
  }

  public static Builder builder(String endpoint, Map<String, String> attributes) {
    Builder builder = builder(endpoint);
    for (Map.Entry<String, String> entry : attributes.entrySet()) {
      builder.addAttribute(entry.getKey(), entry.getValue());
    }
    return builder;
  }

  com.google.pubsub.v1.PushConfig toPb() {
    return com.google.pubsub.v1.PushConfig.newBuilder().setPushEndpoint(endpoint)
        .putAllAttributes(attributes).build();
  }

  static PushConfig fromPb(com.google.pubsub.v1.PushConfig pushConfigPb) {
    return builder(pushConfigPb.getPushEndpoint(), pushConfigPb.getAttributes()).build();
  }
}
