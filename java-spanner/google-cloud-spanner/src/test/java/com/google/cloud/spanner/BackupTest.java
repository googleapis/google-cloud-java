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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Backup.Builder;
import com.google.cloud.spanner.BackupInfo.State;
import com.google.cloud.spanner.encryption.EncryptionInfo;
import com.google.rpc.Code;
import com.google.rpc.Status;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;

@RunWith(JUnit4.class)
public class BackupTest {

  private static final String NAME =
      "projects/test-project/instances/test-instance/backups/backup-1";
  private static final String REFERENCING_BACKUP_NAME =
      "projects/test-project/instances/test-instance/backups/backup-2";
  private static final String DB = "projects/test-project/instances/test-instance/databases/db-1";
  private static final Timestamp EXP_TIME = Timestamp.ofTimeSecondsAndNanos(1000L, 1000);
  private static final Timestamp VERSION_TIME = Timestamp.ofTimeSecondsAndNanos(2000L, 2000);
  public static final String KMS_KEY_VERSION = "key-version";
  private static final com.google.spanner.admin.database.v1.EncryptionInfo ENCRYPTION_INFO =
      com.google.spanner.admin.database.v1.EncryptionInfo.newBuilder()
          .setEncryptionType(
              com.google.spanner.admin.database.v1.EncryptionInfo.Type.CUSTOMER_MANAGED_ENCRYPTION)
          .setEncryptionStatus(Status.newBuilder().setCode(Code.OK.getNumber()))
          .setKmsKeyVersion(KMS_KEY_VERSION)
          .build();

  @Mock DatabaseAdminClient dbClient;

  @Before
  public void setUp() {
    initMocks(this);
    when(dbClient.newBackupBuilder(Mockito.any(BackupId.class)))
        .thenAnswer(invocation -> new Builder(dbClient, (BackupId) invocation.getArguments()[0]));
  }

  @Test
  public void build() {
    Timestamp expireTime = Timestamp.now();
    Timestamp versionTime = Timestamp.ofTimeMicroseconds(10L);
    Backup backup =
        dbClient
            .newBackupBuilder(BackupId.of("test-project", "instance-id", "backup-id"))
            .setDatabase(DatabaseId.of("test-project", "instance-id", "src-database"))
            .setExpireTime(expireTime)
            .setVersionTime(versionTime)
            .setSize(100L)
            .setState(State.CREATING)
            .build();
    Backup copy = backup.toBuilder().build();
    assertThat(copy.getId()).isEqualTo(backup.getId());
    assertThat(copy.getDatabase()).isEqualTo(backup.getDatabase());
    assertThat(copy.getExpireTime()).isEqualTo(backup.getExpireTime());
    assertThat(copy.getVersionTime()).isEqualTo(backup.getVersionTime());
    assertThat(copy.getSize()).isEqualTo(backup.getSize());
    assertThat(copy.getState()).isEqualTo(backup.getState());
  }

  @Test
  public void create() {
    Timestamp expireTime = Timestamp.now();
    Timestamp versionTime = Timestamp.ofTimeMicroseconds(10L);
    Backup backup =
        dbClient
            .newBackupBuilder(BackupId.of("test-project", "instance-id", "backup-id"))
            .setDatabase(DatabaseId.of("test-project", "instance-id", "src-database"))
            .setExpireTime(expireTime)
            .setVersionTime(versionTime)
            .build();
    backup.create();
    verify(dbClient).createBackup(backup);
  }

  @Test
  public void createWithoutVersionTimeShouldSucceed() {
    final Timestamp expireTime = Timestamp.now();
    Backup backup =
        dbClient
            .newBackupBuilder(BackupId.of("test-project", "instance-id", "backup-id"))
            .setDatabase(DatabaseId.of("test-project", "instance-id", "src-database"))
            .setExpireTime(expireTime)
            .build();
    backup.create();
    verify(dbClient).createBackup(backup);
  }

  @Test
  public void exists() {
    when(dbClient.getBackup("test-instance", "test-backup"))
        .thenReturn(
            new Backup.Builder(
                    dbClient, BackupId.of("test-project", "test-instance", "test-backup"))
                .build());
    when(dbClient.getBackup("other-instance", "other-backup"))
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(ErrorCode.NOT_FOUND, "backup not found"));
    Backup backup =
        dbClient
            .newBackupBuilder(BackupId.of("test-project", "test-instance", "test-backup"))
            .build();
    assertThat(backup.exists()).isTrue();
    Backup otherBackup =
        dbClient
            .newBackupBuilder(BackupId.of("test-project", "other-instance", "other-backup"))
            .build();
    assertThat(otherBackup.exists()).isFalse();
  }

  @Test
  public void isReady() {
    when(dbClient.getBackup("test-instance", "test-backup"))
        .thenReturn(
            new Backup.Builder(
                    dbClient, BackupId.of("test-project", "test-instance", "test-backup"))
                .setState(State.READY)
                .build());
    when(dbClient.getBackup("other-instance", "other-backup"))
        .thenReturn(
            new Backup.Builder(
                    dbClient, BackupId.of("test-project", "other-instance", "other-backup"))
                .setState(State.CREATING)
                .build());
    Backup backup =
        dbClient
            .newBackupBuilder(BackupId.of("test-project", "test-instance", "test-backup"))
            .setState(State.UNSPECIFIED)
            .build();
    assertThat(backup.isReady()).isTrue();
    assertThat(backup.getState()).isEqualTo(State.UNSPECIFIED);
    Backup otherBackup =
        dbClient
            .newBackupBuilder(BackupId.of("test-project", "other-instance", "other-backup"))
            .setState(State.READY)
            .build();
    assertThat(otherBackup.isReady()).isFalse();
    assertThat(otherBackup.getState()).isEqualTo(State.READY);
  }

  @Test
  public void reload() {
    Backup backup =
        dbClient
            .newBackupBuilder(BackupId.of("test-project", "test-instance", "test-backup"))
            .build();
    backup.reload();
    verify(dbClient).getBackup("test-instance", "test-backup");
  }

  @Test
  public void delete() {
    Backup backup =
        dbClient
            .newBackupBuilder(BackupId.of("test-project", "test-instance", "test-backup"))
            .build();
    backup.delete();
    verify(dbClient).deleteBackup("test-instance", "test-backup");
  }

  @Test
  public void updateExpireTime() {
    Timestamp expireTime = Timestamp.now();
    Backup backup =
        dbClient
            .newBackupBuilder(BackupId.of("test-project", "test-instance", "test-backup"))
            .setExpireTime(expireTime)
            .build();
    backup.updateExpireTime();
    verify(dbClient).updateBackup("test-instance", "test-backup", expireTime);
  }

  @Test
  public void updateExpireTimeWithoutExpireTime() {
    Backup backup =
        dbClient
            .newBackupBuilder(BackupId.of("test-project", "test-instance", "test-backup"))
            .build();
    IllegalStateException e =
        assertThrows(IllegalStateException.class, () -> backup.updateExpireTime());
    assertNotNull(e.getMessage());
  }

  @Test
  public void restore() {
    Backup backup =
        dbClient
            .newBackupBuilder(BackupId.of("test-project", "backup-instance", "test-backup"))
            .build();
    backup.restore(DatabaseId.of("test-project", "db-instance", "test-database"));
    verify(dbClient)
        .restoreDatabase("backup-instance", "test-backup", "db-instance", "test-database");
  }

  @Test
  public void restoreWithoutDestination() {
    Backup backup =
        dbClient
            .newBackupBuilder(BackupId.of("test-project", "test-instance", "test-backup"))
            .build();
    NullPointerException e = assertThrows(NullPointerException.class, () -> backup.restore(null));
    assertNull(e.getMessage());
  }

  @Test
  public void listBackupOperations() {
    Backup backup =
        dbClient
            .newBackupBuilder(BackupId.of("test-project", "test-instance", "backup-id"))
            .build();
    backup.listBackupOperations();
    verify(dbClient)
        .listBackupOperations("test-instance", Options.filter("name:backups/backup-id"));
  }

  @Test
  public void getIAMPolicy() {
    Backup backup =
        dbClient
            .newBackupBuilder(BackupId.of("test-project", "test-instance", "test-backup"))
            .build();
    backup.getIAMPolicy();
    verify(dbClient).getBackupIAMPolicy("test-instance", "test-backup");
  }

  @Test
  public void setIAMPolicy() {
    Backup backup =
        dbClient
            .newBackupBuilder(BackupId.of("test-project", "test-instance", "test-backup"))
            .build();
    Policy policy =
        Policy.newBuilder().addIdentity(Role.editor(), Identity.user("joe@example.com")).build();
    backup.setIAMPolicy(policy);
    verify(dbClient).setBackupIAMPolicy("test-instance", "test-backup", policy);
  }

  @Test
  public void testIAMPermissions() {
    Backup backup =
        dbClient
            .newBackupBuilder(BackupId.of("test-project", "test-instance", "test-backup"))
            .build();
    Iterable<String> permissions = Collections.singletonList("read");
    backup.testIAMPermissions(permissions);
    verify(dbClient).testBackupIAMPermissions("test-instance", "test-backup", permissions);
  }

  @Test
  public void fromProto() {
    Backup backup = createBackup();
    assertThat(backup.getId().getName()).isEqualTo(NAME);
    assertThat(backup.getState()).isEqualTo(BackupInfo.State.CREATING);
    assertThat(backup.getExpireTime()).isEqualTo(EXP_TIME);
    assertThat(backup.getVersionTime()).isEqualTo(VERSION_TIME);
    assertThat(backup.getEncryptionInfo())
        .isEqualTo(EncryptionInfo.fromProtoOrNull(ENCRYPTION_INFO));
  }

  @Test
  public void testEqualsAndHashCode() {
    final Backup backup1 = createBackup();
    final Backup backup2 = createBackup();
    final Backup copyBackup1 = copyBackup();

    assertEquals(backup1, backup2);
    assertEquals(backup1.hashCode(), backup2.hashCode());
    assertEquals(backup1.hashCode(), copyBackup1.hashCode());
  }

  private Backup createBackup() {
    com.google.spanner.admin.database.v1.Backup proto =
        com.google.spanner.admin.database.v1.Backup.newBuilder()
            .setName(NAME)
            .setDatabase(DB)
            .setExpireTime(
                com.google.protobuf.Timestamp.newBuilder().setSeconds(1000L).setNanos(1000).build())
            .setVersionTime(
                com.google.protobuf.Timestamp.newBuilder().setSeconds(2000L).setNanos(2000).build())
            .setEncryptionInfo(ENCRYPTION_INFO)
            .setState(com.google.spanner.admin.database.v1.Backup.State.CREATING)
            .setMaxExpireTime(
                com.google.protobuf.Timestamp.newBuilder().setSeconds(3000L).setNanos(3000).build())
            .addAllReferencingBackups(Collections.singletonList(REFERENCING_BACKUP_NAME))
            .build();
    return Backup.fromProto(proto, dbClient);
  }

  private Backup copyBackup() {
    com.google.spanner.admin.database.v1.Backup proto =
        com.google.spanner.admin.database.v1.Backup.newBuilder()
            .setName(NAME)
            .setDatabase(DB)
            .setExpireTime(
                com.google.protobuf.Timestamp.newBuilder().setSeconds(1000L).setNanos(1000).build())
            .setVersionTime(
                com.google.protobuf.Timestamp.newBuilder().setSeconds(2000L).setNanos(2000).build())
            .setEncryptionInfo(ENCRYPTION_INFO)
            .setState(com.google.spanner.admin.database.v1.Backup.State.CREATING)
            .setMaxExpireTime(
                com.google.protobuf.Timestamp.newBuilder().setSeconds(3000L).setNanos(3000).build())
            .addAllReferencingBackups(Collections.singletonList(REFERENCING_BACKUP_NAME))
            .build();
    return Backup.fromProto(proto, dbClient);
  }
}
