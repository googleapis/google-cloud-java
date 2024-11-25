/*
 * Copyright 2023 Google LLC
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

import com.google.bigtable.admin.v2.ChangeStreamConfig;
import com.google.bigtable.admin.v2.Table;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.protobuf.FieldMask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class UpdateTableRequestTest {
  private static final String TABLE_ID = "my-table";
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";

  @Test
  public void testEnableChangeStreamToProto() {
    UpdateTableRequest request =
        UpdateTableRequest.of(TABLE_ID).addChangeStreamRetention(Duration.ofHours(24));

    com.google.bigtable.admin.v2.UpdateTableRequest requestProto =
        com.google.bigtable.admin.v2.UpdateTableRequest.newBuilder()
            .setTable(
                Table.newBuilder()
                    .setName(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
                    .setChangeStreamConfig(
                        ChangeStreamConfig.newBuilder()
                            .setRetentionPeriod(
                                com.google.protobuf.Duration.newBuilder().setSeconds(86400))
                            .build()))
            .setUpdateMask(
                FieldMask.newBuilder().addPaths("change_stream_config.retention_period").build())
            .build();
    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testDisableChangeStreamToProto() {
    UpdateTableRequest request =
        UpdateTableRequest.of(TABLE_ID).addChangeStreamRetention(Duration.ofHours(0));

    com.google.bigtable.admin.v2.UpdateTableRequest requestProto =
        com.google.bigtable.admin.v2.UpdateTableRequest.newBuilder()
            .setTable(
                Table.newBuilder()
                    .setName(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID)))
            .setUpdateMask(FieldMask.newBuilder().addPaths("change_stream_config").build())
            .build();
    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testNoChangeChangeStreamToProto() {
    UpdateTableRequest request = UpdateTableRequest.of(TABLE_ID);

    com.google.bigtable.admin.v2.UpdateTableRequest requestProto =
        com.google.bigtable.admin.v2.UpdateTableRequest.newBuilder()
            .setTable(
                Table.newBuilder()
                    .setName(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID)))
            .build();
    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testEnableDeletionProtection() {
    UpdateTableRequest request = UpdateTableRequest.of(TABLE_ID).setDeletionProtection(true);

    com.google.bigtable.admin.v2.UpdateTableRequest requestProto =
        com.google.bigtable.admin.v2.UpdateTableRequest.newBuilder()
            .setTable(
                Table.newBuilder()
                    .setName(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
                    .setDeletionProtection(true))
            .setUpdateMask(FieldMask.newBuilder().addPaths("deletion_protection").build())
            .build();

    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testDisableDeletionProtection() {
    UpdateTableRequest request = UpdateTableRequest.of(TABLE_ID).setDeletionProtection(false);

    com.google.bigtable.admin.v2.UpdateTableRequest requestProto =
        com.google.bigtable.admin.v2.UpdateTableRequest.newBuilder()
            .setTable(
                Table.newBuilder()
                    .setName(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
                    .setDeletionProtection(false))
            .setUpdateMask(FieldMask.newBuilder().addPaths("deletion_protection").build())
            .build();

    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }
}
