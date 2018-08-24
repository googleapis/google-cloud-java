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
import com.google.bigtable.admin.v2.TableName;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nonnull;

/** Wrapper for {@link Table} protocol buffer object */
public final class Table {
  private final TableName tableName;
  //  TODO(igorbernstein2): avoid duplication of id as keys and embedded in the models
  private final Map<String, ClusterState> clusterStates;
  private final Map<String, ColumnFamily> columnFamilies;

  @InternalApi
  public static Table fromProto(@Nonnull com.google.bigtable.admin.v2.Table proto) {
    ImmutableMap.Builder<String, ClusterState> clusterStates = ImmutableMap.builder();

    for (Entry<String, com.google.bigtable.admin.v2.Table.ClusterState> entry : proto.getClusterStatesMap().entrySet()) {
      clusterStates.put(entry.getKey(), ClusterState.fromProto(entry.getKey(), entry.getValue()));
    }

    ImmutableMap.Builder<String, ColumnFamily> columnFamilies = ImmutableMap.builder();

    for (Entry<String, com.google.bigtable.admin.v2.ColumnFamily> entry : proto.getColumnFamiliesMap().entrySet()) {
      columnFamilies.put(entry.getKey(), ColumnFamily.fromProto(entry.getKey(), entry.getValue()));
    }

    return new Table(
        TableName.parse(proto.getName()),
        clusterStates.build(),
        columnFamilies.build());
  }

  private Table(TableName tableName,
      Map<String, ClusterState> clusterStates,
      Map<String, ColumnFamily> columnFamilies) {
    this.tableName = tableName;
    this.clusterStates = clusterStates;
    this.columnFamilies = columnFamilies;
  }

  /**
   * Gets the unique name of the table in the format:
   * projects/{project}/instances/{instance}/tables/{tableId}
   */
  public TableName getTableName() {
    return tableName;
  }

  // TODO(igorbernstein2): don't expose the objects as both maps & lists
  /**
   * Returns state of the table by clusters in the instance as map of clusterId and {@link
   * ClusterState}
   */
  public Map<String, ClusterState> getClusterStatesMap() {
    return clusterStates;
  }

  /**
   * Returns a map of columfamilies in the table keyed by columnfamily and name
   */
  public Map<String, ColumnFamily> getColumnFamiliesMap() {
    return columnFamilies;
  }

  /**
   * Returns state of the table by clusters in the instance as a Collection
   */
  public Collection<ClusterState> getClusterStates() {
    return clusterStates.values();
  }

  /**
   * Returns all columnfamilies in the table as a Collection
   */
  public Collection<ColumnFamily> getColumnFamiles() {
    return columnFamilies.values();
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
    return Objects.equal(tableName, table.tableName) &&
        Objects.equal(clusterStates, table.clusterStates) &&
        Objects.equal(columnFamilies, table.columnFamilies);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(tableName, clusterStates, columnFamilies);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("tableName", tableName)
        .add("clusterStates", getClusterStates())
        .add("columnFamiles", getColumnFamiles())
        .toString();
  }
}
