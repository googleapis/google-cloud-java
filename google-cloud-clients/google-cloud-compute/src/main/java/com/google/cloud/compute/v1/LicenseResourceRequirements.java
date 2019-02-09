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
public final class LicenseResourceRequirements implements ApiMessage {
  private final Integer minGuestCpuCount;
  private final Integer minMemoryMb;

  private LicenseResourceRequirements() {
    this.minGuestCpuCount = null;
    this.minMemoryMb = null;
  }

  private LicenseResourceRequirements(Integer minGuestCpuCount, Integer minMemoryMb) {
    this.minGuestCpuCount = minGuestCpuCount;
    this.minMemoryMb = minMemoryMb;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("minGuestCpuCount".equals(fieldName)) {
      return minGuestCpuCount;
    }
    if ("minMemoryMb".equals(fieldName)) {
      return minMemoryMb;
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
   * Minimum number of guest cpus required to use the Instance. Enforced at Instance creation and
   * Instance start.
   */
  public Integer getMinGuestCpuCount() {
    return minGuestCpuCount;
  }

  /**
   * Minimum memory required to use the Instance. Enforced at Instance creation and Instance start.
   */
  public Integer getMinMemoryMb() {
    return minMemoryMb;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(LicenseResourceRequirements prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static LicenseResourceRequirements getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final LicenseResourceRequirements DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new LicenseResourceRequirements();
  }

  public static class Builder {
    private Integer minGuestCpuCount;
    private Integer minMemoryMb;

    Builder() {}

    public Builder mergeFrom(LicenseResourceRequirements other) {
      if (other == LicenseResourceRequirements.getDefaultInstance()) return this;
      if (other.getMinGuestCpuCount() != null) {
        this.minGuestCpuCount = other.minGuestCpuCount;
      }
      if (other.getMinMemoryMb() != null) {
        this.minMemoryMb = other.minMemoryMb;
      }
      return this;
    }

    Builder(LicenseResourceRequirements source) {
      this.minGuestCpuCount = source.minGuestCpuCount;
      this.minMemoryMb = source.minMemoryMb;
    }

    /**
     * Minimum number of guest cpus required to use the Instance. Enforced at Instance creation and
     * Instance start.
     */
    public Integer getMinGuestCpuCount() {
      return minGuestCpuCount;
    }

    /**
     * Minimum number of guest cpus required to use the Instance. Enforced at Instance creation and
     * Instance start.
     */
    public Builder setMinGuestCpuCount(Integer minGuestCpuCount) {
      this.minGuestCpuCount = minGuestCpuCount;
      return this;
    }

    /**
     * Minimum memory required to use the Instance. Enforced at Instance creation and Instance
     * start.
     */
    public Integer getMinMemoryMb() {
      return minMemoryMb;
    }

    /**
     * Minimum memory required to use the Instance. Enforced at Instance creation and Instance
     * start.
     */
    public Builder setMinMemoryMb(Integer minMemoryMb) {
      this.minMemoryMb = minMemoryMb;
      return this;
    }

    public LicenseResourceRequirements build() {

      return new LicenseResourceRequirements(minGuestCpuCount, minMemoryMb);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setMinGuestCpuCount(this.minGuestCpuCount);
      newBuilder.setMinMemoryMb(this.minMemoryMb);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "LicenseResourceRequirements{"
        + "minGuestCpuCount="
        + minGuestCpuCount
        + ", "
        + "minMemoryMb="
        + minMemoryMb
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof LicenseResourceRequirements) {
      LicenseResourceRequirements that = (LicenseResourceRequirements) o;
      return Objects.equals(this.minGuestCpuCount, that.getMinGuestCpuCount())
          && Objects.equals(this.minMemoryMb, that.getMinMemoryMb());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(minGuestCpuCount, minMemoryMb);
  }
}
