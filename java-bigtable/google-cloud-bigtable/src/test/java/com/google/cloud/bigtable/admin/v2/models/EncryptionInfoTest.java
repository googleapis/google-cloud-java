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

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.bigtable.admin.v2.EncryptionInfo.EncryptionType;
import com.google.cloud.bigtable.common.Status;
import com.google.common.base.Objects;
import com.google.rpc.Code;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EncryptionInfoTest {

  @Test
  public void testAllTypes() {
    for (EncryptionType protoValue :
        com.google.bigtable.admin.v2.EncryptionInfo.EncryptionType.values()) {
      EncryptionInfo.Type modelValue = EncryptionInfo.Type.fromProto(protoValue);

      assertWithMessage("proto enum value %s should be wrapped", protoValue.toString())
          .that(modelValue.toString())
          .isEqualTo(protoValue.toString());
    }

    com.google.bigtable.admin.v2.EncryptionInfo randomEncryptionInfo =
        com.google.bigtable.admin.v2.EncryptionInfo.newBuilder().setEncryptionTypeValue(14).build();
    assertWithMessage("Unrecognized proto enum value should be wrapped")
        .that(EncryptionInfo.Type.fromProto(randomEncryptionInfo.getEncryptionType()))
        .isEqualTo(EncryptionInfo.Type.UNRECOGNIZED);
  }

  @Test
  public void testFromProto() {
    com.google.rpc.Status protoStatus =
        com.google.rpc.Status.newBuilder()
            .setCode(Code.UNAVAILABLE.getNumber())
            .setMessage("kms is unavailable")
            .build();

    com.google.bigtable.admin.v2.EncryptionInfo proto =
        com.google.bigtable.admin.v2.EncryptionInfo.newBuilder()
            .setEncryptionType(EncryptionType.CUSTOMER_MANAGED_ENCRYPTION)
            .setKmsKeyVersion("some version")
            .setEncryptionStatus(protoStatus)
            .build();
    EncryptionInfo encryptionInfo = EncryptionInfo.fromProto(proto);

    assertThat(encryptionInfo.getStatus()).isEqualTo(Status.fromProto(protoStatus));
    assertThat(encryptionInfo.getType()).isEqualTo(EncryptionInfo.Type.CUSTOMER_MANAGED_ENCRYPTION);
    assertThat(encryptionInfo.getKmsKeyVersion()).isEqualTo("some version");
    assertThat(encryptionInfo.toString()).isEqualTo(proto.toString());
    assertThat(encryptionInfo.hashCode()).isEqualTo(Objects.hashCode(proto));
  }
}
