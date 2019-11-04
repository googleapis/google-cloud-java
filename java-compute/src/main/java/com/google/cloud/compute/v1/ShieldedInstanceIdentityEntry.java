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
/** A Shielded Instance Identity Entry. */
public final class ShieldedInstanceIdentityEntry implements ApiMessage {
  private final String ekCert;
  private final String ekPub;

  private ShieldedInstanceIdentityEntry() {
    this.ekCert = null;
    this.ekPub = null;
  }

  private ShieldedInstanceIdentityEntry(String ekCert, String ekPub) {
    this.ekCert = ekCert;
    this.ekPub = ekPub;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("ekCert".equals(fieldName)) {
      return ekCert;
    }
    if ("ekPub".equals(fieldName)) {
      return ekPub;
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

  /** A PEM-encoded X.509 certificate. This field can be empty. */
  public String getEkCert() {
    return ekCert;
  }

  /** A PEM-encoded public key. */
  public String getEkPub() {
    return ekPub;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ShieldedInstanceIdentityEntry prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ShieldedInstanceIdentityEntry getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ShieldedInstanceIdentityEntry DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ShieldedInstanceIdentityEntry();
  }

  public static class Builder {
    private String ekCert;
    private String ekPub;

    Builder() {}

    public Builder mergeFrom(ShieldedInstanceIdentityEntry other) {
      if (other == ShieldedInstanceIdentityEntry.getDefaultInstance()) return this;
      if (other.getEkCert() != null) {
        this.ekCert = other.ekCert;
      }
      if (other.getEkPub() != null) {
        this.ekPub = other.ekPub;
      }
      return this;
    }

    Builder(ShieldedInstanceIdentityEntry source) {
      this.ekCert = source.ekCert;
      this.ekPub = source.ekPub;
    }

    /** A PEM-encoded X.509 certificate. This field can be empty. */
    public String getEkCert() {
      return ekCert;
    }

    /** A PEM-encoded X.509 certificate. This field can be empty. */
    public Builder setEkCert(String ekCert) {
      this.ekCert = ekCert;
      return this;
    }

    /** A PEM-encoded public key. */
    public String getEkPub() {
      return ekPub;
    }

    /** A PEM-encoded public key. */
    public Builder setEkPub(String ekPub) {
      this.ekPub = ekPub;
      return this;
    }

    public ShieldedInstanceIdentityEntry build() {

      return new ShieldedInstanceIdentityEntry(ekCert, ekPub);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setEkCert(this.ekCert);
      newBuilder.setEkPub(this.ekPub);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ShieldedInstanceIdentityEntry{" + "ekCert=" + ekCert + ", " + "ekPub=" + ekPub + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ShieldedInstanceIdentityEntry) {
      ShieldedInstanceIdentityEntry that = (ShieldedInstanceIdentityEntry) o;
      return Objects.equals(this.ekCert, that.getEkCert())
          && Objects.equals(this.ekPub, that.getEkPub());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(ekCert, ekPub);
  }
}
