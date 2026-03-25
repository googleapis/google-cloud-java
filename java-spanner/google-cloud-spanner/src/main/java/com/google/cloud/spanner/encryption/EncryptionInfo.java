/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.encryption;

import com.google.common.annotations.VisibleForTesting;
import com.google.rpc.Status;
import java.util.Objects;

/** Represents the encryption information for a Cloud Spanner backup. */
public class EncryptionInfo {

  private final String kmsKeyVersion;
  private final com.google.spanner.admin.database.v1.EncryptionInfo.Type encryptionType;
  private final Status encryptionStatus;

  public EncryptionInfo(com.google.spanner.admin.database.v1.EncryptionInfo proto) {
    this(proto.getKmsKeyVersion(), proto.getEncryptionType(), proto.getEncryptionStatus());
  }

  @VisibleForTesting
  public EncryptionInfo(
      String kmsKeyVersion,
      com.google.spanner.admin.database.v1.EncryptionInfo.Type encryptionType,
      Status encryptionStatus) {
    this.kmsKeyVersion = kmsKeyVersion;
    this.encryptionType = encryptionType;
    this.encryptionStatus = encryptionStatus;
  }

  /**
   * Returns a {@link EncryptionInfo} instance from the given proto, or <code>null</code> if the
   * given proto is the default proto instance (i.e. there is no encryption info).
   */
  public static EncryptionInfo fromProtoOrNull(
      com.google.spanner.admin.database.v1.EncryptionInfo proto) {
    return proto.equals(com.google.spanner.admin.database.v1.EncryptionInfo.getDefaultInstance())
        ? null
        : new EncryptionInfo(proto);
  }

  public String getKmsKeyVersion() {
    return kmsKeyVersion;
  }

  public com.google.spanner.admin.database.v1.EncryptionInfo.Type getEncryptionType() {
    return encryptionType;
  }

  public Status getEncryptionStatus() {
    return encryptionStatus;
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
    return Objects.equals(kmsKeyVersion, that.kmsKeyVersion)
        && encryptionType == that.encryptionType
        && Objects.equals(encryptionStatus, that.encryptionStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kmsKeyVersion, encryptionType, encryptionStatus);
  }

  @Override
  public String toString() {
    return String.format(
        "EncryptionInfo[kmsKeyVersion=%s,encryptionType=%s,encryptionStatus=%s]",
        kmsKeyVersion, encryptionType, encryptionStatus);
  }
}
