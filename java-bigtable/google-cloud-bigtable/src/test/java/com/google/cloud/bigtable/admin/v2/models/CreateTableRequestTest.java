/*
 * Copyright 2019 Google LLC
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

import static com.google.cloud.bigtable.admin.v2.models.GCRules.GCRULES;
import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.admin.v2.ChangeStreamConfig;
import com.google.bigtable.admin.v2.ColumnFamily;
import com.google.bigtable.admin.v2.GcRule;
import com.google.bigtable.admin.v2.Table;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.protobuf.ByteString;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class CreateTableRequestTest {

  private static final String TABLE_ID = "my-table";
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final ByteString splitKey = ByteString.copyFromUtf8("first-split");

  @Test
  public void testToProto() {
    ByteString secondSplitKey = ByteString.copyFromUtf8("second-split");

    CreateTableRequest request =
        CreateTableRequest.of(TABLE_ID)
            .addFamily("family-id")
            .addFamily("another-family", GCRULES.maxAge(100, TimeUnit.HOURS))
            .addSplit(splitKey)
            .addSplit(secondSplitKey)
            .addChangeStreamRetention(Duration.ofHours(24))
            .setDeletionProtection(true)
            .setAutomatedBackup(Duration.ofHours(24), Duration.ofHours(24));

    com.google.bigtable.admin.v2.CreateTableRequest requestProto =
        com.google.bigtable.admin.v2.CreateTableRequest.newBuilder()
            .setTableId(TABLE_ID)
            .setTable(
                Table.newBuilder()
                    .putColumnFamilies("family-id", ColumnFamily.getDefaultInstance())
                    .putColumnFamilies(
                        "another-family",
                        ColumnFamily.newBuilder()
                            .setGcRule(
                                GcRule.newBuilder()
                                    .setMaxAge(
                                        com.google.protobuf.Duration.newBuilder()
                                            .setSeconds(100 * 60 * 60))
                                    .build())
                            .build())
                    .setChangeStreamConfig(
                        ChangeStreamConfig.newBuilder()
                            .setRetentionPeriod(
                                com.google.protobuf.Duration.newBuilder().setSeconds(86400))
                            .build())
                    .setAutomatedBackupPolicy(
                        com.google.bigtable.admin.v2.Table.AutomatedBackupPolicy.newBuilder()
                            .setRetentionPeriod(
                                com.google.protobuf.Duration.newBuilder()
                                    .setSeconds(86400)
                                    .setNanos(0))
                            .setFrequency(
                                com.google.protobuf.Duration.newBuilder()
                                    .setSeconds(86400)
                                    .setNanos(0))
                            .build())
                    .setDeletionProtection(true))
            .setParent(NameUtil.formatInstanceName(PROJECT_ID, INSTANCE_ID))
            .addInitialSplits(
                com.google.bigtable.admin.v2.CreateTableRequest.Split.newBuilder().setKey(splitKey))
            .addInitialSplits(
                com.google.bigtable.admin.v2.CreateTableRequest.Split.newBuilder()
                    .setKey(secondSplitKey))
            .build();
    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testToProtoWithTypes() {
    CreateTableRequest request =
        CreateTableRequest.of(TABLE_ID)
            .addFamily("family-id")
            .addFamily("another-family", GCRULES.maxAge(100, TimeUnit.HOURS))
            .addFamily("int-sum-family", Type.int64Sum())
            .addFamily("int-sum-family-2", GCRULES.maxAge(100, TimeUnit.HOURS), Type.int64Sum());

    com.google.bigtable.admin.v2.CreateTableRequest requestProto =
        com.google.bigtable.admin.v2.CreateTableRequest.newBuilder()
            .setTableId(TABLE_ID)
            .setTable(
                Table.newBuilder()
                    .putColumnFamilies("family-id", ColumnFamily.getDefaultInstance())
                    .putColumnFamilies(
                        "another-family",
                        ColumnFamily.newBuilder()
                            .setGcRule(
                                GcRule.newBuilder()
                                    .setMaxAge(
                                        com.google.protobuf.Duration.newBuilder()
                                            .setSeconds(100 * 60 * 60))
                                    .build())
                            .build())
                    .putColumnFamilies(
                        "int-sum-family",
                        ColumnFamily.newBuilder()
                            .setGcRule(GcRule.getDefaultInstance())
                            .setValueType(Type.int64Sum().toProto())
                            .build())
                    .putColumnFamilies(
                        "int-sum-family-2",
                        ColumnFamily.newBuilder()
                            .setGcRule(
                                GcRule.newBuilder()
                                    .setMaxAge(
                                        com.google.protobuf.Duration.newBuilder()
                                            .setSeconds(100 * 60 * 60))
                                    .build())
                            .setValueType(Type.int64Sum().toProto())
                            .build()))
            .setParent(NameUtil.formatInstanceName(PROJECT_ID, INSTANCE_ID))
            .build();
    assertThat(request.toProto(PROJECT_ID, INSTANCE_ID)).isEqualTo(requestProto);
  }

  @Test
  public void testEquality() {
    CreateTableRequest request =
        CreateTableRequest.of(TABLE_ID)
            .addFamily("family-id")
            .addFamily("another-family", GCRULES.maxAge(100, TimeUnit.HOURS))
            .setAutomatedBackup(Duration.ofHours(100), Duration.ofHours(100))
            .addSplit(splitKey);

    assertThat(request)
        .isEqualTo(
            CreateTableRequest.of(TABLE_ID)
                .addFamily("family-id")
                .addFamily("another-family", GCRULES.maxAge(Duration.ofHours(100)))
                .setAutomatedBackup(Duration.ofHours(100), Duration.ofHours(100))
                .addSplit(splitKey));

    assertThat(request)
        .isNotEqualTo(
            CreateTableRequest.of(TABLE_ID)
                .addFamily("family-id")
                .addFamily("another-family")
                .setAutomatedBackup(Duration.ofHours(100), Duration.ofHours(10))
                .addSplit(splitKey));
  }

  @Test
  public void testHashCode() {
    CreateTableRequest request =
        CreateTableRequest.of(TABLE_ID).addFamily("family-id").addSplit(splitKey);

    assertThat(request.hashCode())
        .isEqualTo(
            CreateTableRequest.of(TABLE_ID).addFamily("family-id").addSplit(splitKey).hashCode());

    assertThat(request.hashCode())
        .isNotEqualTo(CreateTableRequest.of(TABLE_ID).addFamily("other-family").hashCode());
  }
}
