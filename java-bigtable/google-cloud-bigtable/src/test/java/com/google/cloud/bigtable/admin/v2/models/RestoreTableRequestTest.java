/*
 * Copyright 2020 Google LLC
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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RestoreTableRequestTest {

  private static final String TABLE_ID = "my-table";
  private static final String BACKUP_ID = "my-backup";
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String CLUSTER_ID = "my-cluster";
  private static final String SOURCE_INSTANCE_ID = "source-instance-id";
  private static final String SOURCE_PROJECT_ID = "source-project-id";

  @Test
  public void testToProto() {
    RestoreTableRequest request =
        RestoreTableRequest.of(CLUSTER_ID, BACKUP_ID).setTableId(TABLE_ID);

    com.google.bigtable.admin.v2.RestoreTableRequest requestProto =
        com.google.bigtable.admin.v2.RestoreTableRequest.newBuilder()
            .setParent(NameUtil.formatInstanceName(PROJECT_ID, INSTANCE_ID))
            .setBackup(NameUtil.formatBackupName(PROJECT_ID, INSTANCE_ID, CLUSTER_ID, BACKUP_ID))
            .setTableId(TABLE_ID)
            .build();
    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testToProtoCrossInstance() {
    RestoreTableRequest request =
        RestoreTableRequest.of(SOURCE_INSTANCE_ID, CLUSTER_ID, BACKUP_ID).setTableId(TABLE_ID);

    com.google.bigtable.admin.v2.RestoreTableRequest requestProto =
        com.google.bigtable.admin.v2.RestoreTableRequest.newBuilder()
            .setParent(NameUtil.formatInstanceName(PROJECT_ID, INSTANCE_ID))
            .setBackup(
                NameUtil.formatBackupName(PROJECT_ID, SOURCE_INSTANCE_ID, CLUSTER_ID, BACKUP_ID))
            .setTableId(TABLE_ID)
            .build();
    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testToProtoCrossProject() {
    RestoreTableRequest request =
        RestoreTableRequest.of(SOURCE_INSTANCE_ID, CLUSTER_ID, BACKUP_ID, SOURCE_PROJECT_ID)
            .setTableId(TABLE_ID);

    com.google.bigtable.admin.v2.RestoreTableRequest requestProto =
        com.google.bigtable.admin.v2.RestoreTableRequest.newBuilder()
            .setParent(NameUtil.formatInstanceName(PROJECT_ID, INSTANCE_ID))
            .setBackup(
                NameUtil.formatBackupName(
                    SOURCE_PROJECT_ID, SOURCE_INSTANCE_ID, CLUSTER_ID, BACKUP_ID))
            .setTableId(TABLE_ID)
            .build();
    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testEquality() {
    RestoreTableRequest request =
        RestoreTableRequest.of(CLUSTER_ID, BACKUP_ID).setTableId(TABLE_ID);

    assertThat(request)
        .isEqualTo(RestoreTableRequest.of(CLUSTER_ID, BACKUP_ID).setTableId(TABLE_ID));
    assertThat(request)
        .isNotEqualTo(RestoreTableRequest.of(CLUSTER_ID, BACKUP_ID).setTableId("another-table"));
  }

  @Test
  public void testEqualityCrossInstance() {
    RestoreTableRequest request =
        RestoreTableRequest.of(SOURCE_INSTANCE_ID, CLUSTER_ID, BACKUP_ID).setTableId(TABLE_ID);

    assertThat(request)
        .isEqualTo(
            RestoreTableRequest.of(SOURCE_INSTANCE_ID, CLUSTER_ID, BACKUP_ID).setTableId(TABLE_ID));
    assertThat(request)
        .isNotEqualTo(RestoreTableRequest.of(CLUSTER_ID, BACKUP_ID).setTableId(TABLE_ID));
    assertThat(request)
        .isNotEqualTo(
            RestoreTableRequest.of(SOURCE_INSTANCE_ID, CLUSTER_ID, BACKUP_ID)
                .setTableId("another-table"));
  }

  @Test
  public void testEqualityCrossProject() {
    RestoreTableRequest request =
        RestoreTableRequest.of(SOURCE_INSTANCE_ID, CLUSTER_ID, BACKUP_ID, SOURCE_PROJECT_ID)
            .setTableId(TABLE_ID);

    assertThat(request)
        .isEqualTo(
            RestoreTableRequest.of(SOURCE_INSTANCE_ID, CLUSTER_ID, BACKUP_ID, SOURCE_PROJECT_ID)
                .setTableId(TABLE_ID));
    assertThat(request)
        .isNotEqualTo(RestoreTableRequest.of(CLUSTER_ID, BACKUP_ID).setTableId(TABLE_ID));
    assertThat(request)
        .isNotEqualTo(
            RestoreTableRequest.of(SOURCE_INSTANCE_ID, CLUSTER_ID, BACKUP_ID, SOURCE_PROJECT_ID)
                .setTableId("another-table"));
  }

  @Test
  public void testHashCode() {
    RestoreTableRequest request =
        RestoreTableRequest.of(CLUSTER_ID, BACKUP_ID).setTableId(TABLE_ID);
    assertThat(request.hashCode())
        .isEqualTo(RestoreTableRequest.of(CLUSTER_ID, BACKUP_ID).setTableId(TABLE_ID).hashCode());
    assertThat(request.hashCode())
        .isNotEqualTo(
            RestoreTableRequest.of(CLUSTER_ID, BACKUP_ID).setTableId("another-table").hashCode());
  }

  @Test
  public void testHashCodeCrossInstance() {
    RestoreTableRequest request =
        RestoreTableRequest.of(SOURCE_INSTANCE_ID, CLUSTER_ID, BACKUP_ID).setTableId(TABLE_ID);
    assertThat(request.hashCode())
        .isEqualTo(
            RestoreTableRequest.of(SOURCE_INSTANCE_ID, CLUSTER_ID, BACKUP_ID)
                .setTableId(TABLE_ID)
                .hashCode());
    assertThat(request.hashCode())
        .isNotEqualTo(
            RestoreTableRequest.of(CLUSTER_ID, BACKUP_ID).setTableId(TABLE_ID).hashCode());
    assertThat(request.hashCode())
        .isNotEqualTo(
            RestoreTableRequest.of(SOURCE_INSTANCE_ID, CLUSTER_ID, BACKUP_ID)
                .setTableId("another-table")
                .hashCode());
  }

  @Test
  public void testHashCodeCrossProject() {
    RestoreTableRequest request =
        RestoreTableRequest.of(SOURCE_INSTANCE_ID, CLUSTER_ID, BACKUP_ID, SOURCE_PROJECT_ID)
            .setTableId(TABLE_ID);
    assertThat(request.hashCode())
        .isEqualTo(
            RestoreTableRequest.of(SOURCE_INSTANCE_ID, CLUSTER_ID, BACKUP_ID, SOURCE_PROJECT_ID)
                .setTableId(TABLE_ID)
                .hashCode());
    assertThat(request.hashCode())
        .isNotEqualTo(
            RestoreTableRequest.of(CLUSTER_ID, BACKUP_ID).setTableId(TABLE_ID).hashCode());
    assertThat(request.hashCode())
        .isNotEqualTo(
            RestoreTableRequest.of(SOURCE_INSTANCE_ID, CLUSTER_ID, BACKUP_ID, SOURCE_PROJECT_ID)
                .setTableId("another-table")
                .hashCode());
  }
}
