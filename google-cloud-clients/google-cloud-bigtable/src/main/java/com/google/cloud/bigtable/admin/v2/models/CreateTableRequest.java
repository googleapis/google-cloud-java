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
import com.google.bigtable.admin.v2.ColumnFamily;
import com.google.bigtable.admin.v2.Table;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.cloud.bigtable.admin.v2.models.GCRules.GCRule;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import javax.annotation.Nonnull;

/**
 * Fluent wrapper for {@link com.google.bigtable.admin.v2.CreateTableRequest}
 *
 * <p>Allows for creating table with:
 *
 * <ul>
 *   <li>optional columnFamilies, including optional {@link GCRule}
 *   <li>optional granularity
 *   <li>and optional split points
 * </ul>
 */
public final class CreateTableRequest {
  // TODO(igorbernstein): rename to requestBuilder
  private final com.google.bigtable.admin.v2.CreateTableRequest.Builder createTableRequest =
      com.google.bigtable.admin.v2.CreateTableRequest.newBuilder();
  // TODO(igorbernstein): use the embedded TableBuilder in createTableRequest
  private final Table.Builder tableRequest = Table.newBuilder();

  public static CreateTableRequest of(String tableId) {
    return new CreateTableRequest(tableId);
  }

  /**
   * Configures table with the specified id
   *
   * @param tableId
   */
  private CreateTableRequest(String tableId) {
    createTableRequest.setTableId(tableId);
  }

  /**
   * Adds a new columnFamily to the configuration
   *
   * @param familyId
   */
  public CreateTableRequest addFamily(String familyId) {
    Preconditions.checkNotNull(familyId);
    tableRequest.putColumnFamilies(familyId, ColumnFamily.getDefaultInstance());
    return this;
  }

  /**
   * Adds a new columnFamily with {@link GCRule} to the configuration. Please note that calling this
   * method with the same familyId will overwrite the previous family.
   *
   * @param familyId
   * @param gcRule
   */
  public CreateTableRequest addFamily(String familyId, GCRule gcRule) {
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
  public CreateTableRequest addSplit(ByteString key) {
    Preconditions.checkNotNull(key);
    createTableRequest.addInitialSplitsBuilder().setKey(key);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateTableRequest that = (CreateTableRequest) o;
    return Objects.equal(createTableRequest, that.createTableRequest)
        && Objects.equal(tableRequest, that.tableRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(createTableRequest, tableRequest);
  }

  @InternalApi
  public com.google.bigtable.admin.v2.CreateTableRequest toProto(
      @Nonnull String projectId, @Nonnull String instanceId) {
    Preconditions.checkNotNull(projectId);
    Preconditions.checkNotNull(instanceId);

    return createTableRequest
        .setParent(NameUtil.formatInstanceName(projectId, instanceId))
        .setTable(tableRequest.build())
        .build();
  }
}
