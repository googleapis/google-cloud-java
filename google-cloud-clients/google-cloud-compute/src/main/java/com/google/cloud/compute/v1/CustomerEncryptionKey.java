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
/** Represents a customer-supplied encryption key */
public final class CustomerEncryptionKey implements ApiMessage {
  private final String kmsKeyName;
  private final String rawKey;
  private final String sha256;

  private CustomerEncryptionKey() {
    this.kmsKeyName = null;
    this.rawKey = null;
    this.sha256 = null;
  }

  private CustomerEncryptionKey(String kmsKeyName, String rawKey, String sha256) {
    this.kmsKeyName = kmsKeyName;
    this.rawKey = rawKey;
    this.sha256 = sha256;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("kmsKeyName".equals(fieldName)) {
      return kmsKeyName;
    }
    if ("rawKey".equals(fieldName)) {
      return rawKey;
    }
    if ("sha256".equals(fieldName)) {
      return sha256;
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

  /** The name of the encryption key that is stored in Google Cloud KMS. */
  public String getKmsKeyName() {
    return kmsKeyName;
  }

  /**
   * Specifies a 256-bit customer-supplied encryption key, encoded in RFC 4648 base64 to either
   * encrypt or decrypt this resource.
   */
  public String getRawKey() {
    return rawKey;
  }

  /**
   * [Output only] The RFC 4648 base64 encoded SHA-256 hash of the customer-supplied encryption key
   * that protects this resource.
   */
  public String getSha256() {
    return sha256;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(CustomerEncryptionKey prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static CustomerEncryptionKey getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final CustomerEncryptionKey DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new CustomerEncryptionKey();
  }

  public static class Builder {
    private String kmsKeyName;
    private String rawKey;
    private String sha256;

    Builder() {}

    public Builder mergeFrom(CustomerEncryptionKey other) {
      if (other == CustomerEncryptionKey.getDefaultInstance()) return this;
      if (other.getKmsKeyName() != null) {
        this.kmsKeyName = other.kmsKeyName;
      }
      if (other.getRawKey() != null) {
        this.rawKey = other.rawKey;
      }
      if (other.getSha256() != null) {
        this.sha256 = other.sha256;
      }
      return this;
    }

    Builder(CustomerEncryptionKey source) {
      this.kmsKeyName = source.kmsKeyName;
      this.rawKey = source.rawKey;
      this.sha256 = source.sha256;
    }

    /** The name of the encryption key that is stored in Google Cloud KMS. */
    public String getKmsKeyName() {
      return kmsKeyName;
    }

    /** The name of the encryption key that is stored in Google Cloud KMS. */
    public Builder setKmsKeyName(String kmsKeyName) {
      this.kmsKeyName = kmsKeyName;
      return this;
    }

    /**
     * Specifies a 256-bit customer-supplied encryption key, encoded in RFC 4648 base64 to either
     * encrypt or decrypt this resource.
     */
    public String getRawKey() {
      return rawKey;
    }

    /**
     * Specifies a 256-bit customer-supplied encryption key, encoded in RFC 4648 base64 to either
     * encrypt or decrypt this resource.
     */
    public Builder setRawKey(String rawKey) {
      this.rawKey = rawKey;
      return this;
    }

    /**
     * [Output only] The RFC 4648 base64 encoded SHA-256 hash of the customer-supplied encryption
     * key that protects this resource.
     */
    public String getSha256() {
      return sha256;
    }

    /**
     * [Output only] The RFC 4648 base64 encoded SHA-256 hash of the customer-supplied encryption
     * key that protects this resource.
     */
    public Builder setSha256(String sha256) {
      this.sha256 = sha256;
      return this;
    }

    public CustomerEncryptionKey build() {

      return new CustomerEncryptionKey(kmsKeyName, rawKey, sha256);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setKmsKeyName(this.kmsKeyName);
      newBuilder.setRawKey(this.rawKey);
      newBuilder.setSha256(this.sha256);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "CustomerEncryptionKey{"
        + "kmsKeyName="
        + kmsKeyName
        + ", "
        + "rawKey="
        + rawKey
        + ", "
        + "sha256="
        + sha256
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CustomerEncryptionKey) {
      CustomerEncryptionKey that = (CustomerEncryptionKey) o;
      return Objects.equals(this.kmsKeyName, that.getKmsKeyName())
          && Objects.equals(this.rawKey, that.getRawKey())
          && Objects.equals(this.sha256, that.getSha256());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(kmsKeyName, rawKey, sha256);
  }
}
