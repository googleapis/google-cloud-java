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

import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.PartitionOptions;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This interface is implemented by {@link Statement}s that are created on Cloud Spanner JDBC
 * connections.
 */
public interface CloudSpannerJdbcStatement extends Statement {

  /**
   * Partitions the given query, so it can be executed in parallel. This method returns a {@link
   * ResultSet} with a string-representation of the partitions that were created. These strings can
   * be used to execute a partition either on this connection or an any other connection (on this
   * host or an any other host) by calling the method {@link #runPartition(String)}. This method
   * will automatically enable data boost for the query if {@link
   * CloudSpannerJdbcConnection#isDataBoostEnabled()} returns true.
   */
  ResultSet partitionQuery(String query, PartitionOptions partitionOptions, QueryOption... options)
      throws SQLException;

  /**
   * Executes the given partition of a query. The encodedPartitionId should be a string that was
   * returned by {@link #partitionQuery(String, PartitionOptions, QueryOption...)}.
   */
  ResultSet runPartition(String encodedPartitionId) throws SQLException;

  /**
   * Executes the given query as a partitioned query. The query will first be partitioned using the
   * {@link #partitionQuery(String, PartitionOptions, QueryOption...)} method. Each of the
   * partitions will then be executed in the background, and the results will be merged into a
   * single result set.
   *
   * <p>This method will use {@link CloudSpannerJdbcConnection#getMaxPartitionedParallelism()}
   * threads to execute the partitioned query. Set this variable to a higher/lower value to
   * increase/decrease the degree of parallelism used for execution.
   */
  CloudSpannerJdbcPartitionedQueryResultSet runPartitionedQuery(
      String query, PartitionOptions partitionOptions, QueryOption... options) throws SQLException;
}
