/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigquery.jdbc;

import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;

public interface BigQueryResultSet {
  /*
   * This function returns Job Id for the corresponding BQ Job that generated result.
   * Note that it is not available for certain queries (low-latency queries) and for metadata results.
   *
   * @return JobId object or null.
   */
  public JobId getJobId();

  /*
   * This function returns Query Id for the corresponding low-latency query produced results.
   * It is null for regular (non-low latency) jobs and metadata results.
   *
   * @return Query Id string or null.
   */
  public String getQueryId();

  /*
   * Returns com.google.cloud.bigquery.JobStatistics.QueryStatistics object with statistics for the
   * completed Job for non-low latency queries.
   *
   * @return QueryStatistics object or null.
   */
  public QueryStatistics getQueryStatistics();
}
