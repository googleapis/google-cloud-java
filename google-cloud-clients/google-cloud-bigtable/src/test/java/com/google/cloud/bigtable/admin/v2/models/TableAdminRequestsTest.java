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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.google.bigtable.admin.v2.ColumnFamily;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.GcRule;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.TableName;
import com.google.bigtable.admin.v2.CreateTableRequest.Split;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.Modification;
import com.google.protobuf.ByteString;

@RunWith(JUnit4.class)
public class TableAdminRequestsTest {
  private final InstanceName instanceName = InstanceName.of("project", "instance");

  @Test
  public void createTable() {
    CreateTableRequest actual =
        TableAdminRequests.createTable("tableId")
            .addFamily("cf1")
            .addFamily("cf2", GCRules.GCRULES.maxVersions(1))
            .addSplit(ByteString.copyFromUtf8("c"))
            .toProto(instanceName);

    CreateTableRequest expected =
        CreateTableRequest.newBuilder()
            .setTableId("tableId")
            .setParent(InstanceName.of("project", "instance").toString())
            .addInitialSplits(Split.newBuilder().setKey(ByteString.copyFromUtf8("c")))
            .setTable(
                Table.newBuilder()
                    .putColumnFamilies("cf1", ColumnFamily.newBuilder().build())
                    .putColumnFamilies(
                        "cf2",
                        ColumnFamily.newBuilder()
                            .setGcRule(GCRules.GCRULES.maxVersions(1).toProto())
                            .build()))
            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test(expected = NullPointerException.class)
  public void createTableRequiredTableId() {
    TableAdminRequests.createTable(null).toProto(instanceName);
  }

  @Test(expected = NullPointerException.class)
  public void createTableRequiredParent() {
    TableAdminRequests.createTable("tableId").toProto(null);
  }

  @Test
  public void modifyFamilies() {
    ModifyColumnFamiliesRequest actual =
        TableAdminRequests.modifyFamilies("tableId")
            .addFamily("cf1")
            .addFamily("cf2", GCRules.GCRULES.maxVersions(1))
            .addFamily("cf3")
            .updateFamily("cf1", GCRules.GCRULES.maxVersions(5))
            .dropFamily("cf3")
            .toProto(instanceName);

    ModifyColumnFamiliesRequest expected =
        ModifyColumnFamiliesRequest.newBuilder()
            .setName(
                TableName.of(instanceName.getProject(), instanceName.getInstance(), "tableId")
                    .toString())
            .addModifications(
                Modification.newBuilder()
                    .setId("cf1")
                    .setCreate(ColumnFamily.newBuilder().setGcRule(GcRule.getDefaultInstance())))
            .addModifications(
                Modification.newBuilder()
                    .setId("cf2")
                    .setCreate(
                        ColumnFamily.newBuilder()
                            .setGcRule(GCRules.GCRULES.maxVersions(1).toProto())))
            .addModifications(
                Modification.newBuilder()
                    .setId("cf3")
                    .setCreate(ColumnFamily.newBuilder().setGcRule(GcRule.getDefaultInstance())))
            .addModifications(
                Modification.newBuilder()
                    .setId("cf1")
                    .setUpdate(
                        ColumnFamily.newBuilder()
                            .setGcRule(GCRules.GCRULES.maxVersions(5).toProto())))
            .addModifications(Modification.newBuilder().setId("cf3").setDrop(true))
            .build();
    assertThat(actual).isEqualTo(expected);
  }

  @Test(expected = NullPointerException.class)
  public void modifyFamiliesRequiredTableId() {
    TableAdminRequests.modifyFamilies(null).toProto(instanceName);
  }

  @Test(expected = NullPointerException.class)
  public void modifyFamiliesRequiredParent() {
    TableAdminRequests.modifyFamilies("tableId").toProto(null);
  }
}
