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
/** Guest OS features. */
public final class GuestOsFeature implements ApiMessage {
  private final String type;

  private GuestOsFeature() {
    this.type = null;
  }

  private GuestOsFeature(String type) {
    this.type = type;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("type".equals(fieldName)) {
      return type;
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

  /**
   * The ID of a supported feature. Read Enabling guest operating system features to see a list of
   * available options.
   */
  public String getType() {
    return type;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(GuestOsFeature prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static GuestOsFeature getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final GuestOsFeature DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new GuestOsFeature();
  }

  public static class Builder {
    private String type;

    Builder() {}

    public Builder mergeFrom(GuestOsFeature other) {
      if (other == GuestOsFeature.getDefaultInstance()) return this;
      if (other.getType() != null) {
        this.type = other.type;
      }
      return this;
    }

    Builder(GuestOsFeature source) {
      this.type = source.type;
    }

    /**
     * The ID of a supported feature. Read Enabling guest operating system features to see a list of
     * available options.
     */
    public String getType() {
      return type;
    }

    /**
     * The ID of a supported feature. Read Enabling guest operating system features to see a list of
     * available options.
     */
    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    public GuestOsFeature build() {
      return new GuestOsFeature(type);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setType(this.type);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "GuestOsFeature{" + "type=" + type + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof GuestOsFeature) {
      GuestOsFeature that = (GuestOsFeature) o;
      return Objects.equals(this.type, that.getType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(type);
  }
}
