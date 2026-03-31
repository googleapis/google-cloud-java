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

/**
 * Result set that is returned for partitioned queries, e.g. for 'run partitioned query select ...'
 * or for {@link CloudSpannerJdbcPreparedStatement#runPartitionedQuery(PartitionOptions,
 * QueryOption...)}.
 */
public interface CloudSpannerJdbcPartitionedQueryResultSet extends ResultSet {
  /** Returns the number of partitions that this result set contains. */
  int getNumPartitions();

  /** Returns the degree of parallelism that this result set uses. */
  int getParallelism();
}
