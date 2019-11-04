/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * The information about the HTTP Cookie on which the hash function is based for load balancing
 * policies that use a consistent hash.
 */
public final class ConsistentHashLoadBalancerSettingsHttpCookie implements ApiMessage {
  private final String name;
  private final String path;
  private final Duration ttl;

  private ConsistentHashLoadBalancerSettingsHttpCookie() {
    this.name = null;
    this.path = null;
    this.ttl = null;
  }

  private ConsistentHashLoadBalancerSettingsHttpCookie(String name, String path, Duration ttl) {
    this.name = name;
    this.path = path;
    this.ttl = ttl;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("path".equals(fieldName)) {
      return path;
    }
    if ("ttl".equals(fieldName)) {
      return ttl;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** Name of the cookie. */
  public String getName() {
    return name;
  }

  /** Path to set for the cookie. */
  public String getPath() {
    return path;
  }

  /** Lifetime of the cookie. */
  public Duration getTtl() {
    return ttl;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ConsistentHashLoadBalancerSettingsHttpCookie prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ConsistentHashLoadBalancerSettingsHttpCookie getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ConsistentHashLoadBalancerSettingsHttpCookie DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ConsistentHashLoadBalancerSettingsHttpCookie();
  }

  public static class Builder {
    private String name;
    private String path;
    private Duration ttl;

    Builder() {}

    public Builder mergeFrom(ConsistentHashLoadBalancerSettingsHttpCookie other) {
      if (other == ConsistentHashLoadBalancerSettingsHttpCookie.getDefaultInstance()) return this;
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getPath() != null) {
        this.path = other.path;
      }
      if (other.getTtl() != null) {
        this.ttl = other.ttl;
      }
      return this;
    }

    Builder(ConsistentHashLoadBalancerSettingsHttpCookie source) {
      this.name = source.name;
      this.path = source.path;
      this.ttl = source.ttl;
    }

    /** Name of the cookie. */
    public String getName() {
      return name;
    }

    /** Name of the cookie. */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /** Path to set for the cookie. */
    public String getPath() {
      return path;
    }

    /** Path to set for the cookie. */
    public Builder setPath(String path) {
      this.path = path;
      return this;
    }

    /** Lifetime of the cookie. */
    public Duration getTtl() {
      return ttl;
    }

    /** Lifetime of the cookie. */
    public Builder setTtl(Duration ttl) {
      this.ttl = ttl;
      return this;
    }

    public ConsistentHashLoadBalancerSettingsHttpCookie build() {

      return new ConsistentHashLoadBalancerSettingsHttpCookie(name, path, ttl);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setName(this.name);
      newBuilder.setPath(this.path);
      newBuilder.setTtl(this.ttl);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ConsistentHashLoadBalancerSettingsHttpCookie{"
        + "name="
        + name
        + ", "
        + "path="
        + path
        + ", "
        + "ttl="
        + ttl
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ConsistentHashLoadBalancerSettingsHttpCookie) {
      ConsistentHashLoadBalancerSettingsHttpCookie that =
          (ConsistentHashLoadBalancerSettingsHttpCookie) o;
      return Objects.equals(this.name, that.getName())
          && Objects.equals(this.path, that.getPath())
          && Objects.equals(this.ttl, that.getTtl());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, path, ttl);
  }
}
