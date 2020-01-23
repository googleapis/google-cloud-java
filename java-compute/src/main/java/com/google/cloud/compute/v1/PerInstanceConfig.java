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

  private PerInstanceConfig() {
    this.fingerprint = null;
    this.name = null;
  }

  private PerInstanceConfig(String fingerprint, String name) {
    this.fingerprint = fingerprint;
    this.name = name;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("fingerprint".equals(fieldName)) {
      return fingerprint;
    }
    if ("name".equals(fieldName)) {
      return name;
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
   * Fingerprint of this per-instance config. This field may be used in optimistic locking. It will
   * be ignored when inserting a per-instance config. An up-to-date fingerprint must be provided in
   * order to update an existing per-instance config or the field needs to be unset.
   */
  public String getFingerprint() {
    return fingerprint;
  }

  /**
   * The name of the per-instance config and the corresponding instance. Serves as a merge key
   * during UpdatePerInstanceConfigs operation, i.e. if per-instance config with the same name
   * exists then it will be updated, otherwise a new one will be created for the VM instance with
   * the same name. An attempt to create a per-instance config for a VM instance that either doesn't
   * exist or is not part of the group will result in a failure.
   */
  public String getName() {
    return name;
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

    Builder() {}

    public Builder mergeFrom(PerInstanceConfig other) {
      if (other == PerInstanceConfig.getDefaultInstance()) return this;
      if (other.getFingerprint() != null) {
        this.fingerprint = other.fingerprint;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      return this;
    }

    Builder(PerInstanceConfig source) {
      this.fingerprint = source.fingerprint;
      this.name = source.name;
    }

    /**
     * Fingerprint of this per-instance config. This field may be used in optimistic locking. It
     * will be ignored when inserting a per-instance config. An up-to-date fingerprint must be
     * provided in order to update an existing per-instance config or the field needs to be unset.
     */
    public String getFingerprint() {
      return fingerprint;
    }

    /**
     * Fingerprint of this per-instance config. This field may be used in optimistic locking. It
     * will be ignored when inserting a per-instance config. An up-to-date fingerprint must be
     * provided in order to update an existing per-instance config or the field needs to be unset.
     */
    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    /**
     * The name of the per-instance config and the corresponding instance. Serves as a merge key
     * during UpdatePerInstanceConfigs operation, i.e. if per-instance config with the same name
     * exists then it will be updated, otherwise a new one will be created for the VM instance with
     * the same name. An attempt to create a per-instance config for a VM instance that either
     * doesn't exist or is not part of the group will result in a failure.
     */
    public String getName() {
      return name;
    }

    /**
     * The name of the per-instance config and the corresponding instance. Serves as a merge key
     * during UpdatePerInstanceConfigs operation, i.e. if per-instance config with the same name
     * exists then it will be updated, otherwise a new one will be created for the VM instance with
     * the same name. An attempt to create a per-instance config for a VM instance that either
     * doesn't exist or is not part of the group will result in a failure.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public PerInstanceConfig build() {

      return new PerInstanceConfig(fingerprint, name);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setFingerprint(this.fingerprint);
      newBuilder.setName(this.name);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "PerInstanceConfig{" + "fingerprint=" + fingerprint + ", " + "name=" + name + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PerInstanceConfig) {
      PerInstanceConfig that = (PerInstanceConfig) o;
      return Objects.equals(this.fingerprint, that.getFingerprint())
          && Objects.equals(this.name, that.getName());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(fingerprint, name);
  }
}
