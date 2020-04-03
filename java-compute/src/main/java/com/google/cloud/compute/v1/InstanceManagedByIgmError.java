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
public final class InstanceManagedByIgmError implements ApiMessage {
  private final InstanceManagedByIgmErrorManagedInstanceError error;
  private final InstanceManagedByIgmErrorInstanceActionDetails instanceActionDetails;
  private final String timestamp;

  private InstanceManagedByIgmError() {
    this.error = null;
    this.instanceActionDetails = null;
    this.timestamp = null;
  }

  private InstanceManagedByIgmError(
      InstanceManagedByIgmErrorManagedInstanceError error,
      InstanceManagedByIgmErrorInstanceActionDetails instanceActionDetails,
      String timestamp) {
    this.error = error;
    this.instanceActionDetails = instanceActionDetails;
    this.timestamp = timestamp;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("error".equals(fieldName)) {
      return error;
    }
    if ("instanceActionDetails".equals(fieldName)) {
      return instanceActionDetails;
    }
    if ("timestamp".equals(fieldName)) {
      return timestamp;
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

  /** [Output Only] Contents of the error. */
  public InstanceManagedByIgmErrorManagedInstanceError getError() {
    return error;
  }

  /**
   * [Output Only] Details of the instance action that triggered this error. May be null, if the
   * error was not caused by an action on an instance. This field is optional.
   */
  public InstanceManagedByIgmErrorInstanceActionDetails getInstanceActionDetails() {
    return instanceActionDetails;
  }

  /** [Output Only] The time that this error occurred. This value is in RFC3339 text format. */
  public String getTimestamp() {
    return timestamp;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceManagedByIgmError prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceManagedByIgmError getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceManagedByIgmError DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceManagedByIgmError();
  }

  public static class Builder {
    private InstanceManagedByIgmErrorManagedInstanceError error;
    private InstanceManagedByIgmErrorInstanceActionDetails instanceActionDetails;
    private String timestamp;

    Builder() {}

    public Builder mergeFrom(InstanceManagedByIgmError other) {
      if (other == InstanceManagedByIgmError.getDefaultInstance()) return this;
      if (other.getError() != null) {
        this.error = other.error;
      }
      if (other.getInstanceActionDetails() != null) {
        this.instanceActionDetails = other.instanceActionDetails;
      }
      if (other.getTimestamp() != null) {
        this.timestamp = other.timestamp;
      }
      return this;
    }

    Builder(InstanceManagedByIgmError source) {
      this.error = source.error;
      this.instanceActionDetails = source.instanceActionDetails;
      this.timestamp = source.timestamp;
    }

    /** [Output Only] Contents of the error. */
    public InstanceManagedByIgmErrorManagedInstanceError getError() {
      return error;
    }

    /** [Output Only] Contents of the error. */
    public Builder setError(InstanceManagedByIgmErrorManagedInstanceError error) {
      this.error = error;
      return this;
    }

    /**
     * [Output Only] Details of the instance action that triggered this error. May be null, if the
     * error was not caused by an action on an instance. This field is optional.
     */
    public InstanceManagedByIgmErrorInstanceActionDetails getInstanceActionDetails() {
      return instanceActionDetails;
    }

    /**
     * [Output Only] Details of the instance action that triggered this error. May be null, if the
     * error was not caused by an action on an instance. This field is optional.
     */
    public Builder setInstanceActionDetails(
        InstanceManagedByIgmErrorInstanceActionDetails instanceActionDetails) {
      this.instanceActionDetails = instanceActionDetails;
      return this;
    }

    /** [Output Only] The time that this error occurred. This value is in RFC3339 text format. */
    public String getTimestamp() {
      return timestamp;
    }

    /** [Output Only] The time that this error occurred. This value is in RFC3339 text format. */
    public Builder setTimestamp(String timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    public InstanceManagedByIgmError build() {

      return new InstanceManagedByIgmError(error, instanceActionDetails, timestamp);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setError(this.error);
      newBuilder.setInstanceActionDetails(this.instanceActionDetails);
      newBuilder.setTimestamp(this.timestamp);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceManagedByIgmError{"
        + "error="
        + error
        + ", "
        + "instanceActionDetails="
        + instanceActionDetails
        + ", "
        + "timestamp="
        + timestamp
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceManagedByIgmError) {
      InstanceManagedByIgmError that = (InstanceManagedByIgmError) o;
      return Objects.equals(this.error, that.getError())
          && Objects.equals(this.instanceActionDetails, that.getInstanceActionDetails())
          && Objects.equals(this.timestamp, that.getTimestamp());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, instanceActionDetails, timestamp);
  }
}
