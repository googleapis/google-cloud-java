/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.spanner.jdbc;

import com.google.cloud.spanner.connection.PartitionedQueryResultSet;
import com.google.common.base.Preconditions;
import java.sql.Statement;

/**
 * {@link java.sql.ResultSet} implementation that is returned for queries that are executed with
 * `RUN PARTITIONED QUERY ...`.
 */
class JdbcPartitionedQueryResultSet extends JdbcResultSet
    implements CloudSpannerJdbcPartitionedQueryResultSet {
  static JdbcPartitionedQueryResultSet of(
      Statement statement, PartitionedQueryResultSet resultSet) {
    return new JdbcPartitionedQueryResultSet(
        Preconditions.checkNotNull(statement), Preconditions.checkNotNull(resultSet));
  }

  private final PartitionedQueryResultSet partitionedQueryResultSet;

  private JdbcPartitionedQueryResultSet(Statement statement, PartitionedQueryResultSet resultSet) {
    super(statement, resultSet);
    this.partitionedQueryResultSet = resultSet;
  }

  @Override
  public int getNumPartitions() {
    return partitionedQueryResultSet.getNumPartitions();
  }

  @Override
  public int getParallelism() {
    return partitionedQueryResultSet.getParallelism();
  }
}
