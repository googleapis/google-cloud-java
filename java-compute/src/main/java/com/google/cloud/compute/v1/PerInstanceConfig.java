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
public final class PerInstanceConfig implements ApiMessage {
  private final String fingerprint;
  private final String name;
  private final PreservedState preservedState;
  private final String status;

  private PerInstanceConfig() {
    this.fingerprint = null;
    this.name = null;
    this.preservedState = null;
    this.status = null;
  }

  private PerInstanceConfig(
      String fingerprint, String name, PreservedState preservedState, String status) {
    this.fingerprint = fingerprint;
    this.name = name;
    this.preservedState = preservedState;
    this.status = status;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("fingerprint".equals(fieldName)) {
      return fingerprint;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("preservedState".equals(fieldName)) {
      return preservedState;
    }
    if ("status".equals(fieldName)) {
      return status;
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

  /**
   * Fingerprint of this per-instance config. This field can be used in optimistic locking. It is
   * ignored when inserting a per-instance config. An up-to-date fingerprint must be provided in
   * order to update an existing per-instance config or the field needs to be unset.
   */
  public String getFingerprint() {
    return fingerprint;
  }

  /**
   * The name of a per-instance config and its corresponding instance. Serves as a merge key during
   * UpdatePerInstanceConfigs operations, that is, if a per-instance config with the same name
   * exists then it will be updated, otherwise a new one will be created for the VM instance with
   * the same name. An attempt to create a per-instance config for a VM instance that either doesn't
   * exist or is not part of the group will result in an error.
   */
  public String getName() {
    return name;
  }

  /**
   * The intended preserved state for the given instance. Does not contain preserved state generated
   * from a stateful policy.
   */
  public PreservedState getPreservedState() {
    return preservedState;
  }

  /** The status of applying this per-instance config on the corresponding managed instance. */
  public String getStatus() {
    return status;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(PerInstanceConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static PerInstanceConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final PerInstanceConfig DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new PerInstanceConfig();
  }

  public static class Builder {
    private String fingerprint;
    private String name;
    private PreservedState preservedState;
    private String status;

    Builder() {}

    public Builder mergeFrom(PerInstanceConfig other) {
      if (other == PerInstanceConfig.getDefaultInstance()) return this;
      if (other.getFingerprint() != null) {
        this.fingerprint = other.fingerprint;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getPreservedState() != null) {
        this.preservedState = other.preservedState;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      return this;
    }

    Builder(PerInstanceConfig source) {
      this.fingerprint = source.fingerprint;
      this.name = source.name;
      this.preservedState = source.preservedState;
      this.status = source.status;
    }

    /**
     * Fingerprint of this per-instance config. This field can be used in optimistic locking. It is
     * ignored when inserting a per-instance config. An up-to-date fingerprint must be provided in
     * order to update an existing per-instance config or the field needs to be unset.
     */
    public String getFingerprint() {
      return fingerprint;
    }

    /**
     * Fingerprint of this per-instance config. This field can be used in optimistic locking. It is
     * ignored when inserting a per-instance config. An up-to-date fingerprint must be provided in
     * order to update an existing per-instance config or the field needs to be unset.
     */
    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    /**
     * The name of a per-instance config and its corresponding instance. Serves as a merge key
     * during UpdatePerInstanceConfigs operations, that is, if a per-instance config with the same
     * name exists then it will be updated, otherwise a new one will be created for the VM instance
     * with the same name. An attempt to create a per-instance config for a VM instance that either
     * doesn't exist or is not part of the group will result in an error.
     */
    public String getName() {
      return name;
    }

    /**
     * The name of a per-instance config and its corresponding instance. Serves as a merge key
     * during UpdatePerInstanceConfigs operations, that is, if a per-instance config with the same
     * name exists then it will be updated, otherwise a new one will be created for the VM instance
     * with the same name. An attempt to create a per-instance config for a VM instance that either
     * doesn't exist or is not part of the group will result in an error.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * The intended preserved state for the given instance. Does not contain preserved state
     * generated from a stateful policy.
     */
    public PreservedState getPreservedState() {
      return preservedState;
    }

    /**
     * The intended preserved state for the given instance. Does not contain preserved state
     * generated from a stateful policy.
     */
    public Builder setPreservedState(PreservedState preservedState) {
      this.preservedState = preservedState;
      return this;
    }

    /** The status of applying this per-instance config on the corresponding managed instance. */
    public String getStatus() {
      return status;
    }

    /** The status of applying this per-instance config on the corresponding managed instance. */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public PerInstanceConfig build() {

      return new PerInstanceConfig(fingerprint, name, preservedState, status);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setFingerprint(this.fingerprint);
      newBuilder.setName(this.name);
      newBuilder.setPreservedState(this.preservedState);
      newBuilder.setStatus(this.status);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "PerInstanceConfig{"
        + "fingerprint="
        + fingerprint
        + ", "
        + "name="
        + name
        + ", "
        + "preservedState="
        + preservedState
        + ", "
        + "status="
        + status
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PerInstanceConfig) {
      PerInstanceConfig that = (PerInstanceConfig) o;
      return Objects.equals(this.fingerprint, that.getFingerprint())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.preservedState, that.getPreservedState())
          && Objects.equals(this.status, that.getStatus());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(fingerprint, name, preservedState, status);
  }
}
