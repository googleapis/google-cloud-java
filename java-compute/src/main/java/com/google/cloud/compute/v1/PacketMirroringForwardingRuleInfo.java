/*
 * Copyright 2020 Google LLC
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
public final class PacketMirroringForwardingRuleInfo implements ApiMessage {
  private final String canonicalUrl;
  private final String url;

  private PacketMirroringForwardingRuleInfo() {
    this.canonicalUrl = null;
    this.url = null;
  }

  private PacketMirroringForwardingRuleInfo(String canonicalUrl, String url) {
    this.canonicalUrl = canonicalUrl;
    this.url = url;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("canonicalUrl".equals(fieldName)) {
      return canonicalUrl;
    }
    if ("url".equals(fieldName)) {
      return url;
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

  /** [Output Only] Unique identifier for the forwarding rule; defined by the server. */
  public String getCanonicalUrl() {
    return canonicalUrl;
  }

  /**
   * Resource URL to the forwarding rule representing the ILB configured as destination of the
   * mirrored traffic.
   */
  public String getUrl() {
    return url;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(PacketMirroringForwardingRuleInfo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static PacketMirroringForwardingRuleInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final PacketMirroringForwardingRuleInfo DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new PacketMirroringForwardingRuleInfo();
  }

  public static class Builder {
    private String canonicalUrl;
    private String url;

    Builder() {}

    public Builder mergeFrom(PacketMirroringForwardingRuleInfo other) {
      if (other == PacketMirroringForwardingRuleInfo.getDefaultInstance()) return this;
      if (other.getCanonicalUrl() != null) {
        this.canonicalUrl = other.canonicalUrl;
      }
      if (other.getUrl() != null) {
        this.url = other.url;
      }
      return this;
    }

    Builder(PacketMirroringForwardingRuleInfo source) {
      this.canonicalUrl = source.canonicalUrl;
      this.url = source.url;
    }

    /** [Output Only] Unique identifier for the forwarding rule; defined by the server. */
    public String getCanonicalUrl() {
      return canonicalUrl;
    }

    /** [Output Only] Unique identifier for the forwarding rule; defined by the server. */
    public Builder setCanonicalUrl(String canonicalUrl) {
      this.canonicalUrl = canonicalUrl;
      return this;
    }

    /**
     * Resource URL to the forwarding rule representing the ILB configured as destination of the
     * mirrored traffic.
     */
    public String getUrl() {
      return url;
    }

    /**
     * Resource URL to the forwarding rule representing the ILB configured as destination of the
     * mirrored traffic.
     */
    public Builder setUrl(String url) {
      this.url = url;
      return this;
    }

    public PacketMirroringForwardingRuleInfo build() {

      return new PacketMirroringForwardingRuleInfo(canonicalUrl, url);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCanonicalUrl(this.canonicalUrl);
      newBuilder.setUrl(this.url);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "PacketMirroringForwardingRuleInfo{"
        + "canonicalUrl="
        + canonicalUrl
        + ", "
        + "url="
        + url
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PacketMirroringForwardingRuleInfo) {
      PacketMirroringForwardingRuleInfo that = (PacketMirroringForwardingRuleInfo) o;
      return Objects.equals(this.canonicalUrl, that.getCanonicalUrl())
          && Objects.equals(this.url, that.getUrl());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(canonicalUrl, url);
  }
}
