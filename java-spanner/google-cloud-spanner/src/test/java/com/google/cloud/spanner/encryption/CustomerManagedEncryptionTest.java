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

import static org.junit.Assert.*;

import com.google.spanner.admin.database.v1.EncryptionConfig;
import org.junit.Test;

/** Unit tests for {@link CustomerManagedEncryption}. */
public class CustomerManagedEncryptionTest {

  @Test
  public void testFromProtoWithDefaultInstance() {
    final CustomerManagedEncryption actual =
        CustomerManagedEncryption.fromProtoOrNull(EncryptionConfig.getDefaultInstance());

    assertNull(actual);
  }

  @Test
  public void testFromProto() {
    final CustomerManagedEncryption expected = new CustomerManagedEncryption("kms-key-name");
    final EncryptionConfig encryptionConfig =
        EncryptionConfig.newBuilder().setKmsKeyName("kms-key-name").build();

    final CustomerManagedEncryption actual =
        CustomerManagedEncryption.fromProtoOrNull(encryptionConfig);

    assertEquals(expected, actual);
  }

  @Test
  public void testEqualsAndHashCode() {
    final CustomerManagedEncryption customerManagedEncryption1 =
        new CustomerManagedEncryption("kms-key-name");
    final CustomerManagedEncryption customerManagedEncryption2 =
        new CustomerManagedEncryption("kms-key-name");

    assertEquals(customerManagedEncryption1, customerManagedEncryption2);
    assertEquals(customerManagedEncryption1.hashCode(), customerManagedEncryption2.hashCode());
  }
}
