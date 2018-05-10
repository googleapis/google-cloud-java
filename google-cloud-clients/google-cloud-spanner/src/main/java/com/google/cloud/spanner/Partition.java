/*
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import com.google.protobuf.ByteString;

import java.io.Serializable;
import java.util.Objects;

/**
 * Defines the segments of data to be read in a batch read/query context. They can be serialized and
 * processed across several different machines or proccesses.
 */
public class Partition implements Serializable {
  private static final long serialVersionUID = 8067099123096783937L;

  private final ByteString partitionToken;
  private final String table;
  private final KeySet keys;
  private final Iterable<String> columns;
  private final String index;
  private final Options readOptions;
  private final Statement statement;
  private final Options queryOptions;
  private final PartitionOptions partitionOptions;

  private Partition(
      ByteString partitionToken,
      PartitionOptions partitionOptions,
      Statement statement,
      Options queryOption) {
    this.partitionToken = partitionToken;
    this.partitionOptions = partitionOptions;
    this.statement = statement;
    this.queryOptions = queryOption;
    this.table = null;
    this.keys = null;
    this.columns = null;
    this.index = null;
    this.readOptions = null;
  }

  private Partition(
      ByteString partitionToken,
      PartitionOptions partitionOptions,
      String table,
      String index,
      KeySet keys,
      Iterable<String> columns,
      Options readOptions) {
    this.partitionToken = partitionToken;
    this.partitionOptions = partitionOptions;
    this.table = table;
    this.index = index;
    this.keys = keys;
    this.columns = columns;
    this.readOptions = readOptions;
    this.statement = null;
    this.queryOptions = null;
  }

  static Partition createReadPartition(
      ByteString partitionToken,
      PartitionOptions partitionOptions,
      String table,
      String index,
      KeySet keys,
      Iterable<String> columns,
      Options readOptions) {
    return new Partition(
        partitionToken, partitionOptions, table, index, keys, columns, readOptions);
  }

  static Partition createQueryPartition(
      ByteString partitionToken,
      PartitionOptions partitionOptions,
      Statement statement,
      Options queryOption) {
    return new Partition(partitionToken, partitionOptions, statement, queryOption);
  }

  ByteString getPartitionToken() {
    return partitionToken;
  }

  String getTable() {
    return table;
  }

  KeySet getKeys() {
    return keys;
  }

  Iterable<String> getColumns() {
    return columns;
  }

  String getIndex() {
    return index;
  }

  Options getReadOptions() {
    return readOptions;
  }

  Statement getStatement() {
    return statement;
  }

  Options getQueryOptions() {
    return queryOptions;
  }

  PartitionOptions getPartitionOptions() {
    return partitionOptions;
  }

  @Override
  public String toString() {
    StringBuilder b = new StringBuilder();
    b.append("partitionToken: ")
        .append(partitionToken.toStringUtf8())
        .append(" partitionOptions: ")
        .append(partitionOptions).append(' ');
    if (table != null) {
      b.append("table: ").append(table).append(' ');
    }
    if (index != null) {
      b.append("index: ").append(index).append(' ');
    }
    if (keys != null) {
      b.append("keys: ").append(keys).append(' ');
    }
    if (columns != null) {
      b.append("columns: ").append(columns).append(' ');
    }
    if (readOptions != null) {
      b.append("readOptions: ").append(readOptions).append(' ');
    }
    if (statement != null) {
      b.append("statement: ").append(statement).append(' ');
    }
    if (queryOptions != null) {
      b.append("queryOptions: ").append(queryOptions).append(' ');
    }
    return b.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Partition that = (Partition) o;
    return Objects.equals(getPartitionToken(), that.getPartitionToken())
        && Objects.equals(getPartitionOptions(), that.getPartitionOptions())
        && Objects.equals(getTable(), that.getTable())
        && Objects.equals(getKeys(), that.getKeys())
        && Objects.equals(getColumns(), that.getColumns())
        && Objects.equals(getIndex(), that.getIndex())
        && Objects.equals(getReadOptions(), that.getReadOptions())
        && Objects.equals(getStatement(), that.getStatement())
        && Objects.equals(getQueryOptions(), that.getQueryOptions());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getPartitionToken(),
        getPartitionOptions(),
        getTable(),
        getKeys(),
        getColumns(),
        getIndex(),
        getReadOptions(),
        getStatement(),
        getQueryOptions());
  }
}
