/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.bigtable.admin.v2.models;

import com.google.bigtable.admin.v2.EncryptionInfo.EncryptionType;
import com.google.cloud.bigtable.common.Status;
import com.google.common.base.Objects;

/**
 * Encryption information for a given resource.
 *
 * <p>If this resource is protected with customer managed encryption, the in-use Google Cloud Key
 * Management Service (KMS) key versions will be specified along with their status.
 */
public final class EncryptionInfo {
  public enum Type {
    /** Encryption type was not specified, though data at rest remains encrypted. */
    ENCRYPTION_TYPE_UNSPECIFIED(
        com.google.bigtable.admin.v2.EncryptionInfo.EncryptionType.ENCRYPTION_TYPE_UNSPECIFIED),
    /**
     * The data backing this resource is encrypted at rest with a key that is fully managed by
     * Google. No key version or status will be populated.
     */
    GOOGLE_DEFAULT_ENCRYPTION(
        com.google.bigtable.admin.v2.EncryptionInfo.EncryptionType.GOOGLE_DEFAULT_ENCRYPTION),
    /**
     * The data backing this resource is encrypted at rest with a key that is fully managed by
     * Google. No key version or status will be populated. This is the default state.
     */
    CUSTOMER_MANAGED_ENCRYPTION(
        com.google.bigtable.admin.v2.EncryptionInfo.EncryptionType.CUSTOMER_MANAGED_ENCRYPTION),
    /** Type not known by the client, please upgrade your client */
    UNRECOGNIZED(com.google.bigtable.admin.v2.EncryptionInfo.EncryptionType.UNRECOGNIZED);

    private final com.google.bigtable.admin.v2.EncryptionInfo.EncryptionType proto;

    Type(EncryptionType proto) {
      this.proto = proto;
    }

    /** Wraps the EncryptionInfo protobuf. */
    public static Type fromProto(com.google.bigtable.admin.v2.EncryptionInfo.EncryptionType proto) {
      for (Type type : values()) {
        if (Objects.equal(type.proto, proto)) {
          return type;
        }
      }
      return UNRECOGNIZED;
    }
  }

  private com.google.bigtable.admin.v2.EncryptionInfo proto;

  public static EncryptionInfo fromProto(com.google.bigtable.admin.v2.EncryptionInfo proto) {
    return new EncryptionInfo(proto);
  }

  private EncryptionInfo(com.google.bigtable.admin.v2.EncryptionInfo proto) {
    this.proto = proto;
  }

  public Type getType() {
    return EncryptionInfo.Type.fromProto(proto.getEncryptionType());
  }

  public String getKmsKeyVersion() {
    return proto.getKmsKeyVersion();
  }

  public Status getStatus() {
    return Status.fromProto(proto.getEncryptionStatus());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncryptionInfo that = (EncryptionInfo) o;
    return Objects.equal(proto, that.proto);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(proto);
  }

  @Override
  public String toString() {
    return proto.toString();
  }
}
