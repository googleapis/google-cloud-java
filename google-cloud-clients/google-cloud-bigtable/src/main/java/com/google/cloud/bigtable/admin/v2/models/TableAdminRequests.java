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
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.TableName;
import com.google.bigtable.admin.v2.Table.TimestampGranularity;
import com.google.bigtable.admin.v2.CreateTableRequest.Split;
import com.google.bigtable.admin.v2.GcRule;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.Modification;
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
   * <pre>
   * Allows for creating table with
   *    - optional columnFamilies, including optional {@link GCRule}
   *    - optional granularity
   *    - and optional split points
   * </pre>
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
     * Configures table with the specified granularity
     *
     * @param granularity
     */
    public CreateTable withGranularity(TimestampGranularity granularity) {
      Preconditions.checkNotNull(granularity);
      tableRequest.setGranularity(granularity);
      return this;
    }

    /**
     * Adds a new columnFamily to the configuration
     *
     * @param familyId
     */
    public CreateTable addColumnFamily(String familyId) {
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
    public CreateTable addColumnFamily(String familyId, GCRule gcRule) {
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

    /**
     * Adds the specified number of uniform splits to the configuration
     *
     * @param key
     * @param numSplits
     */
    public CreateTable addUniformSplits(ByteString key, int numSplits) {
      Preconditions.checkNotNull(key);
      // TODO: add implementation
      throw new UnsupportedOperationException();
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
   * <pre>
   * Allows the following ColumnFamily modifications
   *    - create family, optionally with {@link GCRule}
   *    - update existing family {@link GCRule}
   *    - drop an existing family
   * </pre>
   */
  public static final class ModifyFamilies {
    private final ModifyColumnFamiliesRequest.Builder modFamilyRequest =
        ModifyColumnFamiliesRequest.newBuilder();
    private String tableId;

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
    public ModifyFamilies create(String familyId) {
      return createWithGCRule(familyId, null);
    }

    /**
     * Configures the name and GcRule of the new ColumnFamily to be created
     *
     * @param familyId
     * @param gcRule
     * @return
     */
    public ModifyFamilies createWithGCRule(String familyId, GCRule gcRule) {
      Modification.Builder modification = Modification.newBuilder().setId(familyId);
      GcRule grule = (gcRule == null) ? GcRule.getDefaultInstance() : gcRule.toProto();
      modification.setCreate(ColumnFamily.newBuilder().setGcRule(grule));
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
    public ModifyFamilies updateWithGCRule(String familyId, GCRule gcRule) {
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
    public ModifyFamilies drop(String familyId) {
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
