/*
 * Copyright 2018 Google LLC
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

import com.google.bigtable.admin.v2.CreateTableRequest.Split;
import com.google.bigtable.admin.v2.GcRule;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.Table;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.protobuf.ByteString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TableAdminRequestsTest {
  private final String PROJECT_ID = "project";
  private final String INSTANCE_ID = "instance";

  @Test
  public void createTable() {
    com.google.bigtable.admin.v2.CreateTableRequest actual =
        CreateTableRequest.of("tableId")
            .addFamily("cf1")
            .addFamily("cf2", GCRules.GCRULES.maxVersions(1))
            .addSplit(ByteString.copyFromUtf8("c"))
            .toProto(PROJECT_ID, INSTANCE_ID);

    com.google.bigtable.admin.v2.CreateTableRequest expected =
        com.google.bigtable.admin.v2.CreateTableRequest.newBuilder()
            .setTableId("tableId")
            .setParent(InstanceName.of("project", "instance").toString())
            .addInitialSplits(Split.newBuilder().setKey(ByteString.copyFromUtf8("c")))
            .setTable(
                Table.newBuilder()
                    .putColumnFamilies(
                        "cf1", com.google.bigtable.admin.v2.ColumnFamily.newBuilder().build())
                    .putColumnFamilies(
                        "cf2",
                        com.google.bigtable.admin.v2.ColumnFamily.newBuilder()
                            .setGcRule(GCRules.GCRULES.maxVersions(1).toProto())
                            .build()))
            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test(expected = NullPointerException.class)
  public void createTableRequiredTableId() {
    CreateTableRequest.of(null);
  }

  @SuppressWarnings("ConstantConditions")
  @Test(expected = NullPointerException.class)
  public void createTableRequiredParent() {
    CreateTableRequest.of("tableId").toProto(null, null);
  }

  @Test
  public void modifyFamilies() {
    com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest actual =
        ModifyColumnFamiliesRequest.of("tableId")
            .addFamily("cf1")
            .addFamily("cf2", GCRules.GCRULES.maxVersions(1))
            .addFamily("cf3")
            .updateFamily("cf1", GCRules.GCRULES.maxVersions(5))
            .dropFamily("cf3")
            .toProto(PROJECT_ID, INSTANCE_ID);

    com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest expected =
        com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.newBuilder()
            .setName(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, "tableId"))
            .addModifications(
                com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.Modification.newBuilder()
                    .setId("cf1")
                    .setCreate(
                        com.google.bigtable.admin.v2.ColumnFamily.newBuilder()
                            .setGcRule(GcRule.getDefaultInstance())))
            .addModifications(
                com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.Modification.newBuilder()
                    .setId("cf2")
                    .setCreate(
                        com.google.bigtable.admin.v2.ColumnFamily.newBuilder()
                            .setGcRule(GCRules.GCRULES.maxVersions(1).toProto())))
            .addModifications(
                com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.Modification.newBuilder()
                    .setId("cf3")
                    .setCreate(
                        com.google.bigtable.admin.v2.ColumnFamily.newBuilder()
                            .setGcRule(GcRule.getDefaultInstance())))
            .addModifications(
                com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.Modification.newBuilder()
                    .setId("cf1")
                    .setUpdate(
                        com.google.bigtable.admin.v2.ColumnFamily.newBuilder()
                            .setGcRule(GCRules.GCRULES.maxVersions(5).toProto())))
            .addModifications(
                com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.Modification.newBuilder()
                    .setId("cf3")
                    .setDrop(true))
            .build();
    assertThat(actual).isEqualTo(expected);
  }

  @Test(expected = NullPointerException.class)
  public void modifyFamiliesRequiredTableId() {
    ModifyColumnFamiliesRequest.of(null).toProto(PROJECT_ID, INSTANCE_ID);
  }

  @Test(expected = NullPointerException.class)
  public void modifyFamiliesRequiredParent() {
    ModifyColumnFamiliesRequest.of("tableId").toProto(null, null);
  }
}
