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
public final class InstanceManagedByIgmErrorManagedInstanceError implements ApiMessage {
  private final String code;
  private final String message;

  private InstanceManagedByIgmErrorManagedInstanceError() {
    this.code = null;
    this.message = null;
  }

  private InstanceManagedByIgmErrorManagedInstanceError(String code, String message) {
    this.code = code;
    this.message = message;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("code".equals(fieldName)) {
      return code;
    }
    if ("message".equals(fieldName)) {
      return message;
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

  /** [Output Only] Error code. */
  public String getCode() {
    return code;
  }

  /** [Output Only] Error message. */
  public String getMessage() {
    return message;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceManagedByIgmErrorManagedInstanceError prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceManagedByIgmErrorManagedInstanceError getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceManagedByIgmErrorManagedInstanceError DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceManagedByIgmErrorManagedInstanceError();
  }

  public static class Builder {
    private String code;
    private String message;

    Builder() {}

    public Builder mergeFrom(InstanceManagedByIgmErrorManagedInstanceError other) {
      if (other == InstanceManagedByIgmErrorManagedInstanceError.getDefaultInstance()) return this;
      if (other.getCode() != null) {
        this.code = other.code;
      }
      if (other.getMessage() != null) {
        this.message = other.message;
      }
      return this;
    }

    Builder(InstanceManagedByIgmErrorManagedInstanceError source) {
      this.code = source.code;
      this.message = source.message;
    }

    /** [Output Only] Error code. */
    public String getCode() {
      return code;
    }

    /** [Output Only] Error code. */
    public Builder setCode(String code) {
      this.code = code;
      return this;
    }

    /** [Output Only] Error message. */
    public String getMessage() {
      return message;
    }

    /** [Output Only] Error message. */
    public Builder setMessage(String message) {
      this.message = message;
      return this;
    }

    public InstanceManagedByIgmErrorManagedInstanceError build() {

      return new InstanceManagedByIgmErrorManagedInstanceError(code, message);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCode(this.code);
      newBuilder.setMessage(this.message);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceManagedByIgmErrorManagedInstanceError{"
        + "code="
        + code
        + ", "
        + "message="
        + message
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceManagedByIgmErrorManagedInstanceError) {
      InstanceManagedByIgmErrorManagedInstanceError that =
          (InstanceManagedByIgmErrorManagedInstanceError) o;
      return Objects.equals(this.code, that.getCode())
          && Objects.equals(this.message, that.getMessage());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }
}
