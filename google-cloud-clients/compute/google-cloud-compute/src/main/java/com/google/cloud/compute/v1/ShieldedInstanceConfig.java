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
/** A set of Shielded Instance options. */
public final class ShieldedInstanceConfig implements ApiMessage {
  private final Boolean enableIntegrityMonitoring;
  private final Boolean enableSecureBoot;
  private final Boolean enableVtpm;

  private ShieldedInstanceConfig() {
    this.enableIntegrityMonitoring = null;
    this.enableSecureBoot = null;
    this.enableVtpm = null;
  }

  private ShieldedInstanceConfig(
      Boolean enableIntegrityMonitoring, Boolean enableSecureBoot, Boolean enableVtpm) {
    this.enableIntegrityMonitoring = enableIntegrityMonitoring;
    this.enableSecureBoot = enableSecureBoot;
    this.enableVtpm = enableVtpm;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("enableIntegrityMonitoring".equals(fieldName)) {
      return enableIntegrityMonitoring;
    }
    if ("enableSecureBoot".equals(fieldName)) {
      return enableSecureBoot;
    }
    if ("enableVtpm".equals(fieldName)) {
      return enableVtpm;
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

  /** Defines whether the instance has integrity monitoring enabled. */
  public Boolean getEnableIntegrityMonitoring() {
    return enableIntegrityMonitoring;
  }

  /** Defines whether the instance has Secure Boot enabled. */
  public Boolean getEnableSecureBoot() {
    return enableSecureBoot;
  }

  /** Defines whether the instance has the vTPM enabled. */
  public Boolean getEnableVtpm() {
    return enableVtpm;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ShieldedInstanceConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ShieldedInstanceConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ShieldedInstanceConfig DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ShieldedInstanceConfig();
  }

  public static class Builder {
    private Boolean enableIntegrityMonitoring;
    private Boolean enableSecureBoot;
    private Boolean enableVtpm;

    Builder() {}

    public Builder mergeFrom(ShieldedInstanceConfig other) {
      if (other == ShieldedInstanceConfig.getDefaultInstance()) return this;
      if (other.getEnableIntegrityMonitoring() != null) {
        this.enableIntegrityMonitoring = other.enableIntegrityMonitoring;
      }
      if (other.getEnableSecureBoot() != null) {
        this.enableSecureBoot = other.enableSecureBoot;
      }
      if (other.getEnableVtpm() != null) {
        this.enableVtpm = other.enableVtpm;
      }
      return this;
    }

    Builder(ShieldedInstanceConfig source) {
      this.enableIntegrityMonitoring = source.enableIntegrityMonitoring;
      this.enableSecureBoot = source.enableSecureBoot;
      this.enableVtpm = source.enableVtpm;
    }

    /** Defines whether the instance has integrity monitoring enabled. */
    public Boolean getEnableIntegrityMonitoring() {
      return enableIntegrityMonitoring;
    }

    /** Defines whether the instance has integrity monitoring enabled. */
    public Builder setEnableIntegrityMonitoring(Boolean enableIntegrityMonitoring) {
      this.enableIntegrityMonitoring = enableIntegrityMonitoring;
      return this;
    }

    /** Defines whether the instance has Secure Boot enabled. */
    public Boolean getEnableSecureBoot() {
      return enableSecureBoot;
    }

    /** Defines whether the instance has Secure Boot enabled. */
    public Builder setEnableSecureBoot(Boolean enableSecureBoot) {
      this.enableSecureBoot = enableSecureBoot;
      return this;
    }

    /** Defines whether the instance has the vTPM enabled. */
    public Boolean getEnableVtpm() {
      return enableVtpm;
    }

    /** Defines whether the instance has the vTPM enabled. */
    public Builder setEnableVtpm(Boolean enableVtpm) {
      this.enableVtpm = enableVtpm;
      return this;
    }

    public ShieldedInstanceConfig build() {

      return new ShieldedInstanceConfig(enableIntegrityMonitoring, enableSecureBoot, enableVtpm);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setEnableIntegrityMonitoring(this.enableIntegrityMonitoring);
      newBuilder.setEnableSecureBoot(this.enableSecureBoot);
      newBuilder.setEnableVtpm(this.enableVtpm);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ShieldedInstanceConfig{"
        + "enableIntegrityMonitoring="
        + enableIntegrityMonitoring
        + ", "
        + "enableSecureBoot="
        + enableSecureBoot
        + ", "
        + "enableVtpm="
        + enableVtpm
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ShieldedInstanceConfig) {
      ShieldedInstanceConfig that = (ShieldedInstanceConfig) o;
      return Objects.equals(this.enableIntegrityMonitoring, that.getEnableIntegrityMonitoring())
          && Objects.equals(this.enableSecureBoot, that.getEnableSecureBoot())
          && Objects.equals(this.enableVtpm, that.getEnableVtpm());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(enableIntegrityMonitoring, enableSecureBoot, enableVtpm);
  }
}
