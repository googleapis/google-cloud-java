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
import com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState;
import com.google.bigtable.admin.v2.TableName;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nonnull;

/** Wrapper for {@link Table} protocol buffer object */
public final class Table {
  private final String id;
  private final String instanceId;
  private final Map<String, ReplicationState> replicationStatesByClusterId;
  private final List<ColumnFamily> columnFamilies;

  @InternalApi
  public static Table fromProto(@Nonnull com.google.bigtable.admin.v2.Table proto) {
    ImmutableMap.Builder<String, ReplicationState> replicationStates = ImmutableMap.builder();

    for (Entry<String, com.google.bigtable.admin.v2.Table.ClusterState> entry : proto.getClusterStatesMap().entrySet()) {
      replicationStates.put(entry.getKey(), entry.getValue().getReplicationState());
    }

    ImmutableList.Builder<ColumnFamily> columnFamilies = ImmutableList.builder();

    for (Entry<String, com.google.bigtable.admin.v2.ColumnFamily> entry : proto.getColumnFamiliesMap().entrySet()) {
      columnFamilies.add(ColumnFamily.fromProto(entry.getKey(), entry.getValue()));
    }

    return new Table(
        TableName.parse(proto.getName()),
        replicationStates.build(),
        columnFamilies.build());
  }

  private Table(TableName tableName,
      Map<String, ReplicationState> replicationStatesByClusterId,
      List<ColumnFamily> columnFamilies) {
    this.instanceId = tableName.getInstance();
    this.id = tableName.getTable();
    this.replicationStatesByClusterId = replicationStatesByClusterId;
    this.columnFamilies = columnFamilies;
  }

  /** Gets the table's id. */
  public String getId() {
    return id;
  }

  /** Gets the id of the instance that owns this Table. */
  public String getInstanceId() {
    return instanceId;
  }

  public Map<String, ReplicationState> getReplicationStatesByClusterId() {
    return replicationStatesByClusterId;
  }

  public List<ColumnFamily> getColumnFamilies() {
    return columnFamilies;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Table table = (Table) o;
    return Objects.equal(id, table.id) &&
        Objects.equal(instanceId, table.instanceId) &&
        Objects
            .equal(replicationStatesByClusterId, table.replicationStatesByClusterId) &&
        Objects.equal(columnFamilies, table.columnFamilies);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id, instanceId, replicationStatesByClusterId, columnFamilies);
  }
}
