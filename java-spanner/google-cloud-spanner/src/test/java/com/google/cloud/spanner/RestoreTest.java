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
package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;

import com.google.cloud.spanner.encryption.EncryptionConfigs;
import com.google.cloud.spanner.encryption.RestoreEncryptionConfig;
import org.junit.Test;

/** Unit tests for {@link com.google.cloud.spanner.Restore} */
public class RestoreTest {

  private static final BackupId BACKUP_ID =
      BackupId.of("test-project", "test-instance", "test-backup");
  private static final DatabaseId DATABASE_ID =
      DatabaseId.of("test-project", "test-instance", "test-database");
  private static final String KMS_KEY_NAME = "kms-key-name";
  private static final RestoreEncryptionConfig ENCRYPTION_CONFIG_INFO =
      EncryptionConfigs.customerManagedEncryption(KMS_KEY_NAME);

  @Test
  public void testRestore() {
    final Restore actualRestore =
        new Restore.Builder(BACKUP_ID, DATABASE_ID)
            .setEncryptionConfig(ENCRYPTION_CONFIG_INFO)
            .build();
    final Restore expectedRestore = new Restore(BACKUP_ID, DATABASE_ID, ENCRYPTION_CONFIG_INFO);

    assertEquals(expectedRestore, actualRestore);
  }

  @Test
  public void testEqualsAndHashCode() {
    final Restore restore1 = new Restore(BACKUP_ID, DATABASE_ID, ENCRYPTION_CONFIG_INFO);
    final Restore restore2 = new Restore(BACKUP_ID, DATABASE_ID, ENCRYPTION_CONFIG_INFO);

    assertEquals(restore1, restore2);
    assertEquals(restore1.hashCode(), restore2.hashCode());
  }
}
