/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.bigtable.admin.v2.models;

import com.google.bigtable.admin.v2.ColumnFamily;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.Table.TimestampGranularity;
import com.google.bigtable.admin.v2.CreateTableRequest.Split;
import com.google.bigtable.admin.v2.GcRule;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.Modification;
import com.google.cloud.bigtable.admin.v2.models.GCRules.GCRule;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;

/** Idiomatic models to build Bigtable admin requests */
public final class TableAdminRequests {
  private TableAdminRequests() {}

  public static CreateTable createTable(String tableId) {
    return new CreateTable(tableId);
  }

  public static ModifyFamilies modifyFamilies(String tableId) {
    return new ModifyFamilies(tableId);
  }

  public static final class CreateTable {
    private final CreateTableRequest.Builder createTableRequest = CreateTableRequest.newBuilder();
    private final Table.Builder tableRequest = Table.newBuilder();

    private CreateTable(String tableId) {
      createTableRequest.setTableId(tableId);
    }

    public CreateTable withGranularity(TimestampGranularity granularity) {
      Preconditions.checkNotNull(granularity);
      tableRequest.setGranularity(granularity);
      return this;
    }

    public CreateTable addColumnFamily(String familyId) {
      Preconditions.checkNotNull(familyId);
      tableRequest.putColumnFamilies(familyId, ColumnFamily.newBuilder().build());
      return this;
    }

    public CreateTable addColumnFamily(String familyId, GCRule gcRule) {
      Preconditions.checkNotNull(familyId);
      tableRequest.putColumnFamilies(
          familyId, ColumnFamily.newBuilder().setGcRule(gcRule.toProto()).build());
      return this;
    }

    public CreateTable addSplit(ByteString key) {
      Preconditions.checkNotNull(key);
      createTableRequest.addInitialSplits(Split.newBuilder().setKey(key).build());
      return this;
    }

    public CreateTable addUniformSplits(ByteString key, int numSplits) {
      Preconditions.checkNotNull(key);
      // TODO: add implementation
      throw new UnsupportedOperationException();
    }

    public CreateTableRequest toProto(InstanceName instanceName) {
      Preconditions.checkNotNull(instanceName);
      return createTableRequest
          .setParent(instanceName.toString())
          .setTable(tableRequest.build())
          .build();
    }
  }

  public static final class ModifyFamilies {
    private final ModifyColumnFamiliesRequest.Builder modFamilyRequest =
        ModifyColumnFamiliesRequest.newBuilder();
    private String tableId;

    private ModifyFamilies(String tableId) {
      Preconditions.checkNotNull(tableId);
      this.tableId = tableId;
    }

    public String getTableId() {
      return this.tableId;
    }

    public ModifyFamilies create(String familyId) {
      return createWithGCRule(familyId, null);
    }

    public ModifyFamilies createWithGCRule(String familyId, GCRule gcRule) {
      Modification.Builder modification = Modification.newBuilder().setId(familyId);
      GcRule grule = (gcRule == null) ? GcRule.getDefaultInstance() : gcRule.toProto();
      modification.setCreate(ColumnFamily.newBuilder().setGcRule(grule));
      modFamilyRequest.addModifications(modification.build());
      return this;
    }

    public ModifyFamilies updateWithGCRule(String familyId, GCRule gcRule) {
      Modification.Builder modification = Modification.newBuilder().setId(familyId);
      Preconditions.checkNotNull(gcRule);
      modification.setUpdate(ColumnFamily.newBuilder().setGcRule(gcRule.toProto()));
      modFamilyRequest.addModifications(modification.build());
      return this;
    }

    public ModifyFamilies drop(String familyId) {
      Modification.Builder modification = Modification.newBuilder().setId(familyId);
      modification.setId(familyId).setDrop(true);
      modFamilyRequest.addModifications(modification.build());
      return this;
    }

    public ModifyColumnFamiliesRequest toProto(String tableName) {
      Preconditions.checkNotNull(tableName);
      return modFamilyRequest.setName(tableName).build();
    }
  }
}
