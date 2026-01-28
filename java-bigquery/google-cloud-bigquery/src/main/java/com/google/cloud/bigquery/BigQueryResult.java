/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import java.sql.ResultSet;

public interface BigQueryResult<T> {

  /** Returns the schema of the results. */
  Schema getSchema();

  /**
   * Returns the total number of rows in the complete result set, which can be more than the number
   * of rows in the first page of results. This might return -1 if the query is long running and the
   * job is not complete at the time this object is returned.
   */
  long getTotalRows();

  /* Returns the underlying ResultSet Implementation */
  ResultSet getResultSet();

  /* Returns the query statistics associated with this query. */
  BigQueryResultStats getBigQueryResultStats();
}
