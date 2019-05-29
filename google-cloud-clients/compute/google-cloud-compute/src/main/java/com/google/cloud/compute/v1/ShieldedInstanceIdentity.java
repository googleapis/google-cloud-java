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
/** A shielded Instance identity entry. */
public final class ShieldedInstanceIdentity implements ApiMessage {
  private final ShieldedInstanceIdentityEntry encryptionKey;
  private final String kind;
  private final ShieldedInstanceIdentityEntry signingKey;

  private ShieldedInstanceIdentity() {
    this.encryptionKey = null;
    this.kind = null;
    this.signingKey = null;
  }

  private ShieldedInstanceIdentity(
      ShieldedInstanceIdentityEntry encryptionKey,
      String kind,
      ShieldedInstanceIdentityEntry signingKey) {
    this.encryptionKey = encryptionKey;
    this.kind = kind;
    this.signingKey = signingKey;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("encryptionKey".equals(fieldName)) {
      return encryptionKey;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("signingKey".equals(fieldName)) {
      return signingKey;
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

  /** An Endorsement Key (EK) issued to the Shielded Instance's vTPM. */
  public ShieldedInstanceIdentityEntry getEncryptionKey() {
    return encryptionKey;
  }

  /**
   * [Output Only] Type of the resource. Always compute#shieldedInstanceIdentity for shielded
   * Instance identity entry.
   */
  public String getKind() {
    return kind;
  }

  /** An Attestation Key (AK) issued to the Shielded Instance's vTPM. */
  public ShieldedInstanceIdentityEntry getSigningKey() {
    return signingKey;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ShieldedInstanceIdentity prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ShieldedInstanceIdentity getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ShieldedInstanceIdentity DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ShieldedInstanceIdentity();
  }

  public static class Builder {
    private ShieldedInstanceIdentityEntry encryptionKey;
    private String kind;
    private ShieldedInstanceIdentityEntry signingKey;

    Builder() {}

    public Builder mergeFrom(ShieldedInstanceIdentity other) {
      if (other == ShieldedInstanceIdentity.getDefaultInstance()) return this;
      if (other.getEncryptionKey() != null) {
        this.encryptionKey = other.encryptionKey;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getSigningKey() != null) {
        this.signingKey = other.signingKey;
      }
      return this;
    }

    Builder(ShieldedInstanceIdentity source) {
      this.encryptionKey = source.encryptionKey;
      this.kind = source.kind;
      this.signingKey = source.signingKey;
    }

    /** An Endorsement Key (EK) issued to the Shielded Instance's vTPM. */
    public ShieldedInstanceIdentityEntry getEncryptionKey() {
      return encryptionKey;
    }

    /** An Endorsement Key (EK) issued to the Shielded Instance's vTPM. */
    public Builder setEncryptionKey(ShieldedInstanceIdentityEntry encryptionKey) {
      this.encryptionKey = encryptionKey;
      return this;
    }

    /**
     * [Output Only] Type of the resource. Always compute#shieldedInstanceIdentity for shielded
     * Instance identity entry.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] Type of the resource. Always compute#shieldedInstanceIdentity for shielded
     * Instance identity entry.
     */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /** An Attestation Key (AK) issued to the Shielded Instance's vTPM. */
    public ShieldedInstanceIdentityEntry getSigningKey() {
      return signingKey;
    }

    /** An Attestation Key (AK) issued to the Shielded Instance's vTPM. */
    public Builder setSigningKey(ShieldedInstanceIdentityEntry signingKey) {
      this.signingKey = signingKey;
      return this;
    }

    public ShieldedInstanceIdentity build() {

      return new ShieldedInstanceIdentity(encryptionKey, kind, signingKey);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setEncryptionKey(this.encryptionKey);
      newBuilder.setKind(this.kind);
      newBuilder.setSigningKey(this.signingKey);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ShieldedInstanceIdentity{"
        + "encryptionKey="
        + encryptionKey
        + ", "
        + "kind="
        + kind
        + ", "
        + "signingKey="
        + signingKey
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ShieldedInstanceIdentity) {
      ShieldedInstanceIdentity that = (ShieldedInstanceIdentity) o;
      return Objects.equals(this.encryptionKey, that.getEncryptionKey())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.signingKey, that.getSigningKey());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(encryptionKey, kind, signingKey);
  }
}
