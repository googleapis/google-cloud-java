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
public final class AutoscalerStatusDetails implements ApiMessage {
  private final String message;
  private final String type;

  private AutoscalerStatusDetails() {
    this.message = null;
    this.type = null;
  }

  private AutoscalerStatusDetails(String message, String type) {
    this.message = message;
    this.type = type;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("message".equals(fieldName)) {
      return message;
    }
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

  /** The status message. */
  public String getMessage() {
    return message;
  }

  /** The type of error returned. */
  public String getType() {
    return type;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AutoscalerStatusDetails prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AutoscalerStatusDetails getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AutoscalerStatusDetails DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AutoscalerStatusDetails();
  }

  public static class Builder {
    private String message;
    private String type;

    Builder() {}

    public Builder mergeFrom(AutoscalerStatusDetails other) {
      if (other == AutoscalerStatusDetails.getDefaultInstance()) return this;
      if (other.getMessage() != null) {
        this.message = other.message;
      }
      if (other.getType() != null) {
        this.type = other.type;
      }
      return this;
    }

    Builder(AutoscalerStatusDetails source) {
      this.message = source.message;
      this.type = source.type;
    }

    /** The status message. */
    public String getMessage() {
      return message;
    }

    /** The status message. */
    public Builder setMessage(String message) {
      this.message = message;
      return this;
    }

    /** The type of error returned. */
    public String getType() {
      return type;
    }

    /** The type of error returned. */
    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    public AutoscalerStatusDetails build() {

      return new AutoscalerStatusDetails(message, type);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setMessage(this.message);
      newBuilder.setType(this.type);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AutoscalerStatusDetails{" + "message=" + message + ", " + "type=" + type + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AutoscalerStatusDetails) {
      AutoscalerStatusDetails that = (AutoscalerStatusDetails) o;
      return Objects.equals(this.message, that.getMessage())
          && Objects.equals(this.type, that.getType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, type);
  }
}
