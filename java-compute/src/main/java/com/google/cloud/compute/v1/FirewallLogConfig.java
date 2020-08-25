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
/** The available logging options for a firewall rule. */
public final class FirewallLogConfig implements ApiMessage {
  private final Boolean enable;
  private final String metadata;

  private FirewallLogConfig() {
    this.enable = null;
    this.metadata = null;
  }

  private FirewallLogConfig(Boolean enable, String metadata) {
    this.enable = enable;
    this.metadata = metadata;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("enable".equals(fieldName)) {
      return enable;
    }
    if ("metadata".equals(fieldName)) {
      return metadata;
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

  /** This field denotes whether to enable logging for a particular firewall rule. */
  public Boolean getEnable() {
    return enable;
  }

  /**
   * This field can only be specified for a particular firewall rule if logging is enabled for that
   * rule. This field denotes whether to include or exclude metadata for firewall logs.
   */
  public String getMetadata() {
    return metadata;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(FirewallLogConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static FirewallLogConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final FirewallLogConfig DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new FirewallLogConfig();
  }

  public static class Builder {
    private Boolean enable;
    private String metadata;

    Builder() {}

    public Builder mergeFrom(FirewallLogConfig other) {
      if (other == FirewallLogConfig.getDefaultInstance()) return this;
      if (other.getEnable() != null) {
        this.enable = other.enable;
      }
      if (other.getMetadata() != null) {
        this.metadata = other.metadata;
      }
      return this;
    }

    Builder(FirewallLogConfig source) {
      this.enable = source.enable;
      this.metadata = source.metadata;
    }

    /** This field denotes whether to enable logging for a particular firewall rule. */
    public Boolean getEnable() {
      return enable;
    }

    /** This field denotes whether to enable logging for a particular firewall rule. */
    public Builder setEnable(Boolean enable) {
      this.enable = enable;
      return this;
    }

    /**
     * This field can only be specified for a particular firewall rule if logging is enabled for
     * that rule. This field denotes whether to include or exclude metadata for firewall logs.
     */
    public String getMetadata() {
      return metadata;
    }

    /**
     * This field can only be specified for a particular firewall rule if logging is enabled for
     * that rule. This field denotes whether to include or exclude metadata for firewall logs.
     */
    public Builder setMetadata(String metadata) {
      this.metadata = metadata;
      return this;
    }

    public FirewallLogConfig build() {

      return new FirewallLogConfig(enable, metadata);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setEnable(this.enable);
      newBuilder.setMetadata(this.metadata);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "FirewallLogConfig{" + "enable=" + enable + ", " + "metadata=" + metadata + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof FirewallLogConfig) {
      FirewallLogConfig that = (FirewallLogConfig) o;
      return Objects.equals(this.enable, that.getEnable())
          && Objects.equals(this.metadata, that.getMetadata());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(enable, metadata);
  }
}
