/*
 * Copyright 2021 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.rpc.Code;
import com.google.rpc.Status;
import org.junit.Test;

/** Unit tests for {@link com.google.cloud.spanner.encryption.EncryptionInfo} */
public class EncryptionInfoTest {

  private static final String KMS_KEY_VERSION = "kms-key-version";
  private static final com.google.spanner.admin.database.v1.EncryptionInfo.Type
      CUSTOMER_MANAGED_ENCRYPTION =
          com.google.spanner.admin.database.v1.EncryptionInfo.Type.CUSTOMER_MANAGED_ENCRYPTION;
  private static final Status OK_STATUS = Status.newBuilder().setCode(Code.OK_VALUE).build();

  @Test
  public void testEncryptionInfoFromProtoDefaultInstance() {
    final EncryptionInfo encryptionInfo =
        EncryptionInfo.fromProtoOrNull(
            com.google.spanner.admin.database.v1.EncryptionInfo.getDefaultInstance());

    assertNull(encryptionInfo);
  }

  @Test
  public void testEncryptionInfoFromProto() {
    final EncryptionInfo actualEncryptionInfo =
        EncryptionInfo.fromProtoOrNull(
            com.google.spanner.admin.database.v1.EncryptionInfo.newBuilder()
                .setEncryptionStatus(OK_STATUS)
                .setEncryptionTypeValue(CUSTOMER_MANAGED_ENCRYPTION.getNumber())
                .setKmsKeyVersion(KMS_KEY_VERSION)
                .build());

    final EncryptionInfo expectedEncryptionInfo =
        new EncryptionInfo(KMS_KEY_VERSION, CUSTOMER_MANAGED_ENCRYPTION, OK_STATUS);

    assertEquals(expectedEncryptionInfo, actualEncryptionInfo);
  }

  @Test
  public void testEqualsAndHashCode() {
    final EncryptionInfo encryptionInfo1 =
        EncryptionInfo.fromProtoOrNull(
            com.google.spanner.admin.database.v1.EncryptionInfo.newBuilder()
                .setEncryptionStatus(OK_STATUS)
                .setEncryptionTypeValue(CUSTOMER_MANAGED_ENCRYPTION.getNumber())
                .setKmsKeyVersion(KMS_KEY_VERSION)
                .build());
    final EncryptionInfo encryptionInfo2 =
        EncryptionInfo.fromProtoOrNull(
            com.google.spanner.admin.database.v1.EncryptionInfo.newBuilder()
                .setEncryptionStatus(OK_STATUS)
                .setEncryptionTypeValue(CUSTOMER_MANAGED_ENCRYPTION.getNumber())
                .setKmsKeyVersion(KMS_KEY_VERSION)
                .build());

    assertEquals(encryptionInfo1, encryptionInfo2);
    assertEquals(encryptionInfo1.hashCode(), encryptionInfo2.hashCode());
  }
}
