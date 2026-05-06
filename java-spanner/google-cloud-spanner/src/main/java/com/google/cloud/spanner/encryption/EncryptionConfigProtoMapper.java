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

import com.google.spanner.admin.database.v1.CopyBackupEncryptionConfig;
import com.google.spanner.admin.database.v1.CreateBackupEncryptionConfig;
import com.google.spanner.admin.database.v1.EncryptionConfig;
import com.google.spanner.admin.database.v1.RestoreDatabaseEncryptionConfig;

/** Maps encryption config domain classes to their protobuf counterpart. */
public class EncryptionConfigProtoMapper {

  /** Returns an encryption config to be used for a database. */
  public static EncryptionConfig encryptionConfig(CustomerManagedEncryption config) {
    return EncryptionConfig.newBuilder().setKmsKeyName(config.getKmsKeyName()).build();
  }

  /** Returns an encryption config to be used for a backup. */
  public static CreateBackupEncryptionConfig createBackupEncryptionConfig(
      BackupEncryptionConfig config) {
    if (config instanceof CustomerManagedEncryption) {
      return CreateBackupEncryptionConfig.newBuilder()
          .setEncryptionType(
              CreateBackupEncryptionConfig.EncryptionType.CUSTOMER_MANAGED_ENCRYPTION)
          .setKmsKeyName(((CustomerManagedEncryption) config).getKmsKeyName())
          .build();
    } else if (config instanceof GoogleDefaultEncryption) {
      return CreateBackupEncryptionConfig.newBuilder()
          .setEncryptionType(CreateBackupEncryptionConfig.EncryptionType.GOOGLE_DEFAULT_ENCRYPTION)
          .build();
    } else if (config instanceof UseDatabaseEncryption) {
      return CreateBackupEncryptionConfig.newBuilder()
          .setEncryptionType(CreateBackupEncryptionConfig.EncryptionType.USE_DATABASE_ENCRYPTION)
          .build();
    } else {
      throw new IllegalArgumentException("Unknown backup encryption configuration " + config);
    }
  }

  /** Returns an encryption config to be used for a copy backup. */
  public static CopyBackupEncryptionConfig copyBackupEncryptionConfig(
      BackupEncryptionConfig config) {
    if (config instanceof CustomerManagedEncryption) {
      return CopyBackupEncryptionConfig.newBuilder()
          .setEncryptionType(CopyBackupEncryptionConfig.EncryptionType.CUSTOMER_MANAGED_ENCRYPTION)
          .setKmsKeyName(((CustomerManagedEncryption) config).getKmsKeyName())
          .build();
    } else if (config instanceof GoogleDefaultEncryption) {
      return CopyBackupEncryptionConfig.newBuilder()
          .setEncryptionType(CopyBackupEncryptionConfig.EncryptionType.GOOGLE_DEFAULT_ENCRYPTION)
          .build();
    } else if (config instanceof UseBackupEncryption) {
      return CopyBackupEncryptionConfig.newBuilder()
          .setEncryptionType(
              CopyBackupEncryptionConfig.EncryptionType.USE_CONFIG_DEFAULT_OR_BACKUP_ENCRYPTION)
          .build();
    } else {
      throw new IllegalArgumentException("Unknown backup encryption configuration " + config);
    }
  }

  /** Returns an encryption config to be used for a database restore. */
  public static RestoreDatabaseEncryptionConfig restoreDatabaseEncryptionConfig(
      RestoreEncryptionConfig config) {
    if (config instanceof CustomerManagedEncryption) {
      return RestoreDatabaseEncryptionConfig.newBuilder()
          .setEncryptionType(
              RestoreDatabaseEncryptionConfig.EncryptionType.CUSTOMER_MANAGED_ENCRYPTION)
          .setKmsKeyName(((CustomerManagedEncryption) config).getKmsKeyName())
          .build();
    } else if (config instanceof GoogleDefaultEncryption) {
      return RestoreDatabaseEncryptionConfig.newBuilder()
          .setEncryptionType(
              RestoreDatabaseEncryptionConfig.EncryptionType.GOOGLE_DEFAULT_ENCRYPTION)
          .build();
    } else if (config instanceof UseBackupEncryption) {
      return RestoreDatabaseEncryptionConfig.newBuilder()
          .setEncryptionType(
              RestoreDatabaseEncryptionConfig.EncryptionType
                  .USE_CONFIG_DEFAULT_OR_BACKUP_ENCRYPTION)
          .build();
    } else {
      throw new IllegalArgumentException("Unknown restore encryption configuration " + config);
    }
  }
}
