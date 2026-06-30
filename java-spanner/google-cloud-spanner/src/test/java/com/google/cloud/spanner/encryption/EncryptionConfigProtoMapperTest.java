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

import com.google.spanner.admin.database.v1.CreateBackupEncryptionConfig;
import com.google.spanner.admin.database.v1.EncryptionConfig;
import com.google.spanner.admin.database.v1.RestoreDatabaseEncryptionConfig;
import org.junit.Test;

/** Unit tests for {@link com.google.cloud.spanner.encryption.EncryptionConfigProtoMapper} */
public class EncryptionConfigProtoMapperTest {

  public static final String KMS_KEY_NAME = "kms-key-name";

  @Test
  public void testEncryptionConfig() {
    final EncryptionConfig expected =
        EncryptionConfig.newBuilder().setKmsKeyName(KMS_KEY_NAME).build();

    final EncryptionConfig actual =
        EncryptionConfigProtoMapper.encryptionConfig(new CustomerManagedEncryption(KMS_KEY_NAME));

    assertEquals(expected, actual);
  }

  @Test
  public void testCreateBackupConfigCustomerManagedEncryption() {
    final CreateBackupEncryptionConfig expected =
        CreateBackupEncryptionConfig.newBuilder()
            .setEncryptionType(
                CreateBackupEncryptionConfig.EncryptionType.CUSTOMER_MANAGED_ENCRYPTION)
            .setKmsKeyName(KMS_KEY_NAME)
            .build();

    final CreateBackupEncryptionConfig actual =
        EncryptionConfigProtoMapper.createBackupEncryptionConfig(
            new CustomerManagedEncryption(KMS_KEY_NAME));

    assertEquals(expected, actual);
  }

  @Test
  public void testCreateBackupConfigGoogleDefaultEncryption() {
    final CreateBackupEncryptionConfig expected =
        CreateBackupEncryptionConfig.newBuilder()
            .setEncryptionType(
                CreateBackupEncryptionConfig.EncryptionType.GOOGLE_DEFAULT_ENCRYPTION)
            .build();

    final CreateBackupEncryptionConfig actual =
        EncryptionConfigProtoMapper.createBackupEncryptionConfig(GoogleDefaultEncryption.INSTANCE);

    assertEquals(expected, actual);
  }

  @Test
  public void testCreateBackupConfigUseDatabaseEncryption() {
    final CreateBackupEncryptionConfig expected =
        CreateBackupEncryptionConfig.newBuilder()
            .setEncryptionType(CreateBackupEncryptionConfig.EncryptionType.USE_DATABASE_ENCRYPTION)
            .build();

    final CreateBackupEncryptionConfig actual =
        EncryptionConfigProtoMapper.createBackupEncryptionConfig(UseDatabaseEncryption.INSTANCE);

    assertEquals(expected, actual);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateBackupInvalidEncryption() {
    EncryptionConfigProtoMapper.createBackupEncryptionConfig(null);
  }

  @Test
  public void testRestoreDatabaseConfigCustomerManagedEncryption() {
    final RestoreDatabaseEncryptionConfig expected =
        RestoreDatabaseEncryptionConfig.newBuilder()
            .setEncryptionType(
                RestoreDatabaseEncryptionConfig.EncryptionType.CUSTOMER_MANAGED_ENCRYPTION)
            .setKmsKeyName(KMS_KEY_NAME)
            .build();

    final RestoreDatabaseEncryptionConfig actual =
        EncryptionConfigProtoMapper.restoreDatabaseEncryptionConfig(
            new CustomerManagedEncryption(KMS_KEY_NAME));

    assertEquals(expected, actual);
  }

  @Test
  public void testRestoreDatabaseConfigGoogleDefaultEncryption() {
    final RestoreDatabaseEncryptionConfig expected =
        RestoreDatabaseEncryptionConfig.newBuilder()
            .setEncryptionType(
                RestoreDatabaseEncryptionConfig.EncryptionType.GOOGLE_DEFAULT_ENCRYPTION)
            .build();

    final RestoreDatabaseEncryptionConfig actual =
        EncryptionConfigProtoMapper.restoreDatabaseEncryptionConfig(
            GoogleDefaultEncryption.INSTANCE);

    assertEquals(expected, actual);
  }

  @Test
  public void testRestoreDatabaseConfigUseBackupEncryption() {
    final RestoreDatabaseEncryptionConfig expected =
        RestoreDatabaseEncryptionConfig.newBuilder()
            .setEncryptionType(
                RestoreDatabaseEncryptionConfig.EncryptionType
                    .USE_CONFIG_DEFAULT_OR_BACKUP_ENCRYPTION)
            .build();

    final RestoreDatabaseEncryptionConfig actual =
        EncryptionConfigProtoMapper.restoreDatabaseEncryptionConfig(UseBackupEncryption.INSTANCE);

    assertEquals(expected, actual);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRestoreDatabaseConfigInvalidEncryption() {
    EncryptionConfigProtoMapper.restoreDatabaseEncryptionConfig(null);
  }
}
