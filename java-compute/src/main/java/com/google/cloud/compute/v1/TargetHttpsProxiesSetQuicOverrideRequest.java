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
public final class TargetHttpsProxiesSetQuicOverrideRequest implements ApiMessage {
  private final String quicOverride;

  private TargetHttpsProxiesSetQuicOverrideRequest() {
    this.quicOverride = null;
  }

  private TargetHttpsProxiesSetQuicOverrideRequest(String quicOverride) {
    this.quicOverride = quicOverride;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("quicOverride".equals(fieldName)) {
      return quicOverride;
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

  /** QUIC policy for the TargetHttpsProxy resource. */
  public String getQuicOverride() {
    return quicOverride;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TargetHttpsProxiesSetQuicOverrideRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetHttpsProxiesSetQuicOverrideRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetHttpsProxiesSetQuicOverrideRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetHttpsProxiesSetQuicOverrideRequest();
  }

  public static class Builder {
    private String quicOverride;

    Builder() {}

    public Builder mergeFrom(TargetHttpsProxiesSetQuicOverrideRequest other) {
      if (other == TargetHttpsProxiesSetQuicOverrideRequest.getDefaultInstance()) return this;
      if (other.getQuicOverride() != null) {
        this.quicOverride = other.quicOverride;
      }
      return this;
    }

    Builder(TargetHttpsProxiesSetQuicOverrideRequest source) {
      this.quicOverride = source.quicOverride;
    }

    /** QUIC policy for the TargetHttpsProxy resource. */
    public String getQuicOverride() {
      return quicOverride;
    }

    /** QUIC policy for the TargetHttpsProxy resource. */
    public Builder setQuicOverride(String quicOverride) {
      this.quicOverride = quicOverride;
      return this;
    }

    public TargetHttpsProxiesSetQuicOverrideRequest build() {
      return new TargetHttpsProxiesSetQuicOverrideRequest(quicOverride);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setQuicOverride(this.quicOverride);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetHttpsProxiesSetQuicOverrideRequest{" + "quicOverride=" + quicOverride + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TargetHttpsProxiesSetQuicOverrideRequest) {
      TargetHttpsProxiesSetQuicOverrideRequest that = (TargetHttpsProxiesSetQuicOverrideRequest) o;
      return Objects.equals(this.quicOverride, that.getQuicOverride());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(quicOverride);
  }
}
