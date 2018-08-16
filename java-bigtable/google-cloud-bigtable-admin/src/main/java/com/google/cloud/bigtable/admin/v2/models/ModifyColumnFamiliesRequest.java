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

import com.google.api.core.InternalApi;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.Modification;
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.admin.v2.models.GCRules.GCRule;
import com.google.common.base.Preconditions;

/**
 * Fluent wrapper for {@link com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest}
 *
 * <p>Allows for the following ColumnFamily modifications:
 *
 * <ul>
 *   <li>create family, optionally with {@link GCRule}
 *   <li>update existing family {@link GCRule}
 *   <li>drop an existing family
 * </ul>
 */
public final class ModifyColumnFamiliesRequest {
  private final com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.Builder modFamilyRequest =
      com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.newBuilder();
  private final String tableId;


  public static ModifyColumnFamiliesRequest of(String tableId) {
    return new ModifyColumnFamiliesRequest(tableId);
  }

  /**
   * Configures the tableId to execute the modifications
   *
   * @param tableId
   */
  ModifyColumnFamiliesRequest(String tableId) {
    Preconditions.checkNotNull(tableId);
    this.tableId = tableId;
  }

  /**
   * Configures the name of the new ColumnFamily to be created
   *
   * @param familyId
   * @return
   */
  public ModifyColumnFamiliesRequest addFamily(String familyId) {
    return addFamily(familyId, GCRules.GCRULES.defaultRule());
  }

  /**
   * Configures the name and GcRule of the new ColumnFamily to be created
   *
   * @param familyId
   * @param gcRule
   * @return
   */
  public ModifyColumnFamiliesRequest addFamily(String familyId, GCRule gcRule) {
    Preconditions.checkNotNull(gcRule);
    Modification.Builder modification = Modification.newBuilder().setId(familyId);
    modification.getCreateBuilder().setGcRule(gcRule.toProto());
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
  public ModifyColumnFamiliesRequest updateFamily(String familyId, GCRule gcRule) {
    Preconditions.checkNotNull(gcRule);
    Modification.Builder modification = Modification.newBuilder().setId(familyId);
    modification.getUpdateBuilder().setGcRule(gcRule.toProto());
    modFamilyRequest.addModifications(modification.build());
    return this;
  }

  /**
   * Drops the specified ColumnFamily
   *
   * @param familyId
   * @return
   */
  public ModifyColumnFamiliesRequest dropFamily(String familyId) {
    Modification.Builder modification = Modification.newBuilder()
        .setId(familyId)
        .setDrop(true);
    modFamilyRequest.addModifications(modification.build());
    return this;
  }

  @InternalApi
  public com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest toProto(InstanceName instanceName) {
    Preconditions.checkNotNull(instanceName);
    String tableName =
        TableName.of(instanceName.getProject(), instanceName.getInstance(), tableId).toString();
    return modFamilyRequest.setName(tableName).build();
  }
}
