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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.bigtable.admin.v2.ColumnFamily;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.CreateTableRequest.Split;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.Modification;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.admin.v2.models.GCRules.GCRule;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;

/** Fluent DSL models to build Bigtable Table admin requests */
@BetaApi
public final class TableAdminRequests {
  private TableAdminRequests() {}

  /**
   * Factory method to get an instance of CreateTable
   *
   * @param tableId - the id of the table to create
   * @return CreateTable
   */
  public static CreateTable createTable(String tableId) {
    return new CreateTable(tableId);
  }

  /**
   * Factory method to get an instance of ModifyFamilies
   *
   * @param tableId - the id of the table to create
   * @return ModifyFamilies
   */
  public static ModifyFamilies modifyFamilies(String tableId) {
    return new ModifyFamilies(tableId);
  }

  /**
   * Fluent wrapper for {@link CreateTableRequest}
   *
   * <p>Allows for creating table with:
   *
   * <ul>
   *   <li>optional columnFamilies, including optional {@link GCRule}
   *   <li>optional granularity
   *   <li>and optional split points
   * </ul>
   */
  public static final class CreateTable {
    private final CreateTableRequest.Builder createTableRequest = CreateTableRequest.newBuilder();
    private final Table.Builder tableRequest = Table.newBuilder();

    /**
     * Configures table with the specified id
     *
     * @param tableId
     */
    private CreateTable(String tableId) {
      createTableRequest.setTableId(tableId);
    }

    /**
     * Adds a new columnFamily to the configuration
     *
     * @param familyId
     */
    public CreateTable addFamily(String familyId) {
      Preconditions.checkNotNull(familyId);
      tableRequest.putColumnFamilies(familyId, ColumnFamily.newBuilder().build());
      return this;
    }

    /**
     * Adds a new columnFamily with {@link GCRule} to the configuration
     *
     * @param familyId
     * @param gcRule
     */
    public CreateTable addFamily(String familyId, GCRule gcRule) {
      Preconditions.checkNotNull(familyId);
      tableRequest.putColumnFamilies(
          familyId, ColumnFamily.newBuilder().setGcRule(gcRule.toProto()).build());
      return this;
    }

    /**
     * Adds split at the specified key to the configuration
     *
     * @param key
     */
    public CreateTable addSplit(ByteString key) {
      Preconditions.checkNotNull(key);
      createTableRequest.addInitialSplits(Split.newBuilder().setKey(key).build());
      return this;
    }

    @InternalApi
    public CreateTableRequest toProto(InstanceName instanceName) {
      Preconditions.checkNotNull(instanceName);
      return createTableRequest
          .setParent(instanceName.toString())
          .setTable(tableRequest.build())
          .build();
    }
  }

  /**
   * Fluent wrapper for {@link ModifyColumnFamiliesRequest}
   *
   * <p>Allows for the following ColumnFamily modifications:
   *
   * <ul>
   *   <li>create family, optionally with {@link GCRule}
   *   <li>update existing family {@link GCRule}
   *   <li>drop an existing family
   * </ul>
   */
  public static final class ModifyFamilies {
    private final ModifyColumnFamiliesRequest.Builder modFamilyRequest =
        ModifyColumnFamiliesRequest.newBuilder();
    private final String tableId;

    /**
     * Configures the tableId to execute the modifications
     *
     * @param tableId
     */
    private ModifyFamilies(String tableId) {
      Preconditions.checkNotNull(tableId);
      this.tableId = tableId;
    }

    /**
     * Configures the name of the new ColumnFamily to be created
     *
     * @param familyId
     * @return
     */
    public ModifyFamilies addFamily(String familyId) {
      return addFamily(familyId, GCRules.GCRULES.defaultRule());
    }

    /**
     * Configures the name and GcRule of the new ColumnFamily to be created
     *
     * @param familyId
     * @param gcRule
     * @return
     */
    public ModifyFamilies addFamily(String familyId, GCRule gcRule) {
      Modification.Builder modification = Modification.newBuilder().setId(familyId);
      Preconditions.checkNotNull(gcRule);
      modification.setCreate(ColumnFamily.newBuilder().setGcRule(gcRule.toProto()));
      modFamilyRequest.addModifications(modification.build());
      return this;
    }

    /**
     * Updates the GCRule of existing ColumnFamily
     *
     * @param familyId
     * @param gcRule
     * @return
     */
    public ModifyFamilies updateFamily(String familyId, GCRule gcRule) {
      Modification.Builder modification = Modification.newBuilder().setId(familyId);
      Preconditions.checkNotNull(gcRule);
      modification.setUpdate(ColumnFamily.newBuilder().setGcRule(gcRule.toProto()));
      modFamilyRequest.addModifications(modification.build());
      return this;
    }

    /**
     * Drops the specified ColumnFamily
     *
     * @param familyId
     * @return
     */
    public ModifyFamilies dropFamily(String familyId) {
      Modification.Builder modification = Modification.newBuilder().setId(familyId);
      modification.setId(familyId).setDrop(true);
      modFamilyRequest.addModifications(modification.build());
      return this;
    }

    @InternalApi
    public ModifyColumnFamiliesRequest toProto(InstanceName instanceName) {
      Preconditions.checkNotNull(instanceName);
      String tableName =
          TableName.of(instanceName.getProject(), instanceName.getInstance(), tableId).toString();
      return modFamilyRequest.setName(tableName).build();
    }
  }
}
