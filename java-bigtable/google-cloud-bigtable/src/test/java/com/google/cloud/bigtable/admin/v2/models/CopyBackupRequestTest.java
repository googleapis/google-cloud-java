/*
 * Copyright 2022 Google LLC
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

import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.protobuf.util.Timestamps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;

@RunWith(JUnit4.class)
public class CopyBackupRequestTest {

  private static final String BACKUP_ID = "my-backup";
  private static final String CLUSTER_ID = "my-cluster";
  private static final String INSTANCE_ID = "my-instance";
  private static final String PROJECT_ID = "my-project";
  private static final String SOURCE_BACKUP_ID = "source-backup-id";
  private static final String SOURCE_CLUSTER_ID = "source-cluster-id";
  private static final String SOURCE_INSTANCE_ID = "source-instance-id";
  private static final String SOURCE_PROJECT_ID = "source-project-id";
  private static final Instant EXPIRE_TIME = Instant.now().plus(Duration.ofDays(15));

  @Test
  public void testToProto() {
    CopyBackupRequest request =
        CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
            .setDestination(CLUSTER_ID, BACKUP_ID)
            .setExpireTime(EXPIRE_TIME);

    com.google.bigtable.admin.v2.CopyBackupRequest requestProto =
        com.google.bigtable.admin.v2.CopyBackupRequest.newBuilder()
            .setParent(NameUtil.formatClusterName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID))
            .setSourceBackup(
                NameUtil.formatBackupName(
                    PROJECT_ID, INSTANCE_ID, SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID))
            .setExpireTime(Timestamps.fromMillis(EXPIRE_TIME.toEpochMilli()))
            .setBackupId(BACKUP_ID)
            .build();
    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testToProtoCrossInstance() {
    CopyBackupRequest request =
        CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
            .setSourceInstance(SOURCE_INSTANCE_ID)
            .setDestination(CLUSTER_ID, BACKUP_ID)
            .setExpireTime(EXPIRE_TIME);

    com.google.bigtable.admin.v2.CopyBackupRequest requestProto =
        com.google.bigtable.admin.v2.CopyBackupRequest.newBuilder()
            .setParent(NameUtil.formatClusterName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID))
            .setSourceBackup(
                NameUtil.formatBackupName(
                    PROJECT_ID, SOURCE_INSTANCE_ID, SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID))
            .setExpireTime(Timestamps.fromMillis(EXPIRE_TIME.toEpochMilli()))
            .setBackupId(BACKUP_ID)
            .build();
    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testToProtoCrossProject() {
    CopyBackupRequest request =
        CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
            .setSourceInstance(SOURCE_PROJECT_ID, SOURCE_INSTANCE_ID)
            .setDestination(CLUSTER_ID, BACKUP_ID)
            .setExpireTime(EXPIRE_TIME);

    com.google.bigtable.admin.v2.CopyBackupRequest requestProto =
        com.google.bigtable.admin.v2.CopyBackupRequest.newBuilder()
            .setParent(NameUtil.formatClusterName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID))
            .setSourceBackup(
                NameUtil.formatBackupName(
                    SOURCE_PROJECT_ID, SOURCE_INSTANCE_ID, SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID))
            .setExpireTime(Timestamps.fromMillis(EXPIRE_TIME.toEpochMilli()))
            .setBackupId(BACKUP_ID)
            .build();
    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testEquality() {
    CopyBackupRequest request =
        CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
            .setDestination(CLUSTER_ID, BACKUP_ID)
            .setExpireTime(EXPIRE_TIME);

    assertThat(request)
        .isEqualTo(
            CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
                .setDestination(CLUSTER_ID, BACKUP_ID)
                .setExpireTime(EXPIRE_TIME));
    assertThat(request)
        .isNotEqualTo(
            CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
                .setDestination(CLUSTER_ID, "another-backup")
                .setExpireTime(EXPIRE_TIME));
  }

  @Test
  public void testEqualityCrossInstance() {
    CopyBackupRequest request =
        CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
            .setSourceInstance(SOURCE_INSTANCE_ID)
            .setDestination(CLUSTER_ID, BACKUP_ID)
            .setExpireTime(EXPIRE_TIME);

    assertThat(request)
        .isEqualTo(
            CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
                .setSourceInstance(SOURCE_INSTANCE_ID)
                .setDestination(CLUSTER_ID, BACKUP_ID)
                .setExpireTime(EXPIRE_TIME));
    assertThat(request)
        .isNotEqualTo(
            CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
                .setSourceInstance(SOURCE_INSTANCE_ID)
                .setDestination(CLUSTER_ID, "another-backup")
                .setExpireTime(EXPIRE_TIME));
  }

  @Test
  public void testEqualityCrossProject() {
    CopyBackupRequest request =
        CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
            .setSourceInstance(SOURCE_PROJECT_ID, SOURCE_INSTANCE_ID)
            .setDestination(CLUSTER_ID, BACKUP_ID)
            .setExpireTime(EXPIRE_TIME);

    assertThat(request)
        .isEqualTo(
            CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
                .setSourceInstance(SOURCE_PROJECT_ID, SOURCE_INSTANCE_ID)
                .setDestination(CLUSTER_ID, BACKUP_ID)
                .setExpireTime(EXPIRE_TIME));
    assertThat(request)
        .isNotEqualTo(
            CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
                .setSourceInstance(SOURCE_PROJECT_ID, SOURCE_INSTANCE_ID)
                .setDestination(CLUSTER_ID, "another-backup")
                .setExpireTime(EXPIRE_TIME));
  }

  @Test
  public void testHashCode() {
    CopyBackupRequest request =
        CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
            .setDestination(CLUSTER_ID, BACKUP_ID)
            .setExpireTime(EXPIRE_TIME);

    assertThat(request.hashCode())
        .isEqualTo(
            CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
                .setDestination(CLUSTER_ID, BACKUP_ID)
                .setExpireTime(EXPIRE_TIME)
                .hashCode());
    assertThat(request.hashCode())
        .isNotEqualTo(
            CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
                .setDestination(CLUSTER_ID, "another-backup")
                .setExpireTime(EXPIRE_TIME)
                .hashCode());
  }

  @Test
  public void testHashCodeCrossInstance() {
    CopyBackupRequest request =
        CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
            .setSourceInstance(SOURCE_INSTANCE_ID)
            .setDestination(CLUSTER_ID, BACKUP_ID)
            .setExpireTime(EXPIRE_TIME);

    assertThat(request.hashCode())
        .isEqualTo(
            CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
                .setSourceInstance(SOURCE_INSTANCE_ID)
                .setDestination(CLUSTER_ID, BACKUP_ID)
                .setExpireTime(EXPIRE_TIME)
                .hashCode());
    assertThat(request.hashCode())
        .isNotEqualTo(
            CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
                .setSourceInstance(SOURCE_INSTANCE_ID)
                .setDestination(CLUSTER_ID, "another-backup")
                .setExpireTime(EXPIRE_TIME)
                .hashCode());
  }

  @Test
  public void testHashCodeCrossProject() {
    CopyBackupRequest request =
        CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
            .setSourceInstance(SOURCE_PROJECT_ID, SOURCE_INSTANCE_ID)
            .setDestination(CLUSTER_ID, BACKUP_ID)
            .setExpireTime(EXPIRE_TIME);

    assertThat(request.hashCode())
        .isEqualTo(
            CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
                .setSourceInstance(SOURCE_PROJECT_ID, SOURCE_INSTANCE_ID)
                .setDestination(CLUSTER_ID, BACKUP_ID)
                .setExpireTime(EXPIRE_TIME)
                .hashCode());
    assertThat(request.hashCode())
        .isNotEqualTo(
            CopyBackupRequest.of(SOURCE_CLUSTER_ID, SOURCE_BACKUP_ID)
                .setSourceInstance(SOURCE_PROJECT_ID, SOURCE_INSTANCE_ID)
                .setDestination(CLUSTER_ID, "another-backup")
                .setExpireTime(EXPIRE_TIME)
                .hashCode());
  }
}
