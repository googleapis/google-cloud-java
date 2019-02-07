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
/** The available logging options for a firewall rule. */
public final class FirewallLogConfig implements ApiMessage {
  private final Boolean enable;

  private FirewallLogConfig() {
    this.enable = null;
  }

  private FirewallLogConfig(Boolean enable) {
    this.enable = enable;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("enable".equals(fieldName)) {
      return enable;
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
  public List<String> getFieldMask() {
    return null;
  }

  /** This field denotes whether to enable logging for a particular firewall rule. */
  public Boolean getEnable() {
    return enable;
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

    Builder() {}

    public Builder mergeFrom(FirewallLogConfig other) {
      if (other == FirewallLogConfig.getDefaultInstance()) return this;
      if (other.getEnable() != null) {
        this.enable = other.enable;
      }
      return this;
    }

    Builder(FirewallLogConfig source) {
      this.enable = source.enable;
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

    public FirewallLogConfig build() {
      return new FirewallLogConfig(enable);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setEnable(this.enable);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "FirewallLogConfig{" + "enable=" + enable + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof FirewallLogConfig) {
      FirewallLogConfig that = (FirewallLogConfig) o;
      return Objects.equals(this.enable, that.getEnable());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(enable);
  }
}
