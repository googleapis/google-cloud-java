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
/** Configuration of logging on a NAT. */
public final class RouterNatLogConfig implements ApiMessage {
  private final Boolean enable;
  private final String filter;

  private RouterNatLogConfig() {
    this.enable = null;
    this.filter = null;
  }

  private RouterNatLogConfig(Boolean enable, String filter) {
    this.enable = enable;
    this.filter = filter;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("enable".equals(fieldName)) {
      return enable;
    }
    if ("filter".equals(fieldName)) {
      return filter;
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

  /** Indicates whether or not to export logs. This is false by default. */
  public Boolean getEnable() {
    return enable;
  }

  /**
   * Specifies the desired filtering of logs on this NAT. If unspecified, logs are exported for all
   * connections handled by this NAT.
   */
  public String getFilter() {
    return filter;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RouterNatLogConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RouterNatLogConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RouterNatLogConfig DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RouterNatLogConfig();
  }

  public static class Builder {
    private Boolean enable;
    private String filter;

    Builder() {}

    public Builder mergeFrom(RouterNatLogConfig other) {
      if (other == RouterNatLogConfig.getDefaultInstance()) return this;
      if (other.getEnable() != null) {
        this.enable = other.enable;
      }
      if (other.getFilter() != null) {
        this.filter = other.filter;
      }
      return this;
    }

    Builder(RouterNatLogConfig source) {
      this.enable = source.enable;
      this.filter = source.filter;
    }

    /** Indicates whether or not to export logs. This is false by default. */
    public Boolean getEnable() {
      return enable;
    }

    /** Indicates whether or not to export logs. This is false by default. */
    public Builder setEnable(Boolean enable) {
      this.enable = enable;
      return this;
    }

    /**
     * Specifies the desired filtering of logs on this NAT. If unspecified, logs are exported for
     * all connections handled by this NAT.
     */
    public String getFilter() {
      return filter;
    }

    /**
     * Specifies the desired filtering of logs on this NAT. If unspecified, logs are exported for
     * all connections handled by this NAT.
     */
    public Builder setFilter(String filter) {
      this.filter = filter;
      return this;
    }

    public RouterNatLogConfig build() {

      return new RouterNatLogConfig(enable, filter);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setEnable(this.enable);
      newBuilder.setFilter(this.filter);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RouterNatLogConfig{" + "enable=" + enable + ", " + "filter=" + filter + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RouterNatLogConfig) {
      RouterNatLogConfig that = (RouterNatLogConfig) o;
      return Objects.equals(this.enable, that.getEnable())
          && Objects.equals(this.filter, that.getFilter());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(enable, filter);
  }
}
