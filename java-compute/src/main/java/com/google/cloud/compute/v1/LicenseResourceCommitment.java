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
/** Commitment for a particular license resource. */
public final class LicenseResourceCommitment implements ApiMessage {
  private final String amount;
  private final String coresPerLicense;
  private final String license;

  private LicenseResourceCommitment() {
    this.amount = null;
    this.coresPerLicense = null;
    this.license = null;
  }

  private LicenseResourceCommitment(String amount, String coresPerLicense, String license) {
    this.amount = amount;
    this.coresPerLicense = coresPerLicense;
    this.license = license;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("amount".equals(fieldName)) {
      return amount;
    }
    if ("coresPerLicense".equals(fieldName)) {
      return coresPerLicense;
    }
    if ("license".equals(fieldName)) {
      return license;
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

  /** The number of licenses purchased. */
  public String getAmount() {
    return amount;
  }

  /** Specifies the core range of the instance for which this license applies. */
  public String getCoresPerLicense() {
    return coresPerLicense;
  }

  /** Any applicable license URI. */
  public String getLicense() {
    return license;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(LicenseResourceCommitment prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static LicenseResourceCommitment getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final LicenseResourceCommitment DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new LicenseResourceCommitment();
  }

  public static class Builder {
    private String amount;
    private String coresPerLicense;
    private String license;

    Builder() {}

    public Builder mergeFrom(LicenseResourceCommitment other) {
      if (other == LicenseResourceCommitment.getDefaultInstance()) return this;
      if (other.getAmount() != null) {
        this.amount = other.amount;
      }
      if (other.getCoresPerLicense() != null) {
        this.coresPerLicense = other.coresPerLicense;
      }
      if (other.getLicense() != null) {
        this.license = other.license;
      }
      return this;
    }

    Builder(LicenseResourceCommitment source) {
      this.amount = source.amount;
      this.coresPerLicense = source.coresPerLicense;
      this.license = source.license;
    }

    /** The number of licenses purchased. */
    public String getAmount() {
      return amount;
    }

    /** The number of licenses purchased. */
    public Builder setAmount(String amount) {
      this.amount = amount;
      return this;
    }

    /** Specifies the core range of the instance for which this license applies. */
    public String getCoresPerLicense() {
      return coresPerLicense;
    }

    /** Specifies the core range of the instance for which this license applies. */
    public Builder setCoresPerLicense(String coresPerLicense) {
      this.coresPerLicense = coresPerLicense;
      return this;
    }

    /** Any applicable license URI. */
    public String getLicense() {
      return license;
    }

    /** Any applicable license URI. */
    public Builder setLicense(String license) {
      this.license = license;
      return this;
    }

    public LicenseResourceCommitment build() {

      return new LicenseResourceCommitment(amount, coresPerLicense, license);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAmount(this.amount);
      newBuilder.setCoresPerLicense(this.coresPerLicense);
      newBuilder.setLicense(this.license);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "LicenseResourceCommitment{"
        + "amount="
        + amount
        + ", "
        + "coresPerLicense="
        + coresPerLicense
        + ", "
        + "license="
        + license
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof LicenseResourceCommitment) {
      LicenseResourceCommitment that = (LicenseResourceCommitment) o;
      return Objects.equals(this.amount, that.getAmount())
          && Objects.equals(this.coresPerLicense, that.getCoresPerLicense())
          && Objects.equals(this.license, that.getLicense());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, coresPerLicense, license);
  }
}
