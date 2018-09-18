/*
 * Copyright 2018 Google LLC
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

import com.google.api.core.InternalApi;
import com.google.common.base.Preconditions;

/** Storage media types for persisting Bigtable data. */
public enum StorageType {
  /** Flash (SSD) storage should be used. */
  HDD(com.google.bigtable.admin.v2.StorageType.HDD),
  /** Magnetic drive (HDD) storage should be used. */
  SSD(com.google.bigtable.admin.v2.StorageType.SSD),
  /** The storage type is not known by this client. Please upgrade your client. */
  UNRECOGNIZED(com.google.bigtable.admin.v2.StorageType.UNRECOGNIZED);

  private final com.google.bigtable.admin.v2.StorageType proto;

  /**
   * Wraps the protobuf. This method is considered an internal implementation detail and not meant
   * to be used by applications.
   */
  @InternalApi
  public static StorageType fromProto(com.google.bigtable.admin.v2.StorageType proto) {
    Preconditions.checkNotNull(proto);
    Preconditions.checkArgument(proto != com.google.bigtable.admin.v2.StorageType.STORAGE_TYPE_UNSPECIFIED,
        "Storage type must be specified");

    for (StorageType type : values()) {
      if (type.proto.equals(proto)) {
        return type;
      }
    }
    return UNRECOGNIZED;
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  StorageType(com.google.bigtable.admin.v2.StorageType proto) {
    this.proto = proto;
  }

  public com.google.bigtable.admin.v2.StorageType toProto() {
    return proto;
  }
}
