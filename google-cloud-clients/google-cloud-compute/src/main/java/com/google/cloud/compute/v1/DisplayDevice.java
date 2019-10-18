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
/** A set of Display Device options */
public final class DisplayDevice implements ApiMessage {
  private final Boolean enableDisplay;

  private DisplayDevice() {
    this.enableDisplay = null;
  }

  private DisplayDevice(Boolean enableDisplay) {
    this.enableDisplay = enableDisplay;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("enableDisplay".equals(fieldName)) {
      return enableDisplay;
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

  /** Defines whether the instance has Display enabled. */
  public Boolean getEnableDisplay() {
    return enableDisplay;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(DisplayDevice prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static DisplayDevice getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final DisplayDevice DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new DisplayDevice();
  }

  public static class Builder {
    private Boolean enableDisplay;

    Builder() {}

    public Builder mergeFrom(DisplayDevice other) {
      if (other == DisplayDevice.getDefaultInstance()) return this;
      if (other.getEnableDisplay() != null) {
        this.enableDisplay = other.enableDisplay;
      }
      return this;
    }

    Builder(DisplayDevice source) {
      this.enableDisplay = source.enableDisplay;
    }

    /** Defines whether the instance has Display enabled. */
    public Boolean getEnableDisplay() {
      return enableDisplay;
    }

    /** Defines whether the instance has Display enabled. */
    public Builder setEnableDisplay(Boolean enableDisplay) {
      this.enableDisplay = enableDisplay;
      return this;
    }

    public DisplayDevice build() {
      return new DisplayDevice(enableDisplay);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setEnableDisplay(this.enableDisplay);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "DisplayDevice{" + "enableDisplay=" + enableDisplay + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DisplayDevice) {
      DisplayDevice that = (DisplayDevice) o;
      return Objects.equals(this.enableDisplay, that.getEnableDisplay());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(enableDisplay);
  }
}
