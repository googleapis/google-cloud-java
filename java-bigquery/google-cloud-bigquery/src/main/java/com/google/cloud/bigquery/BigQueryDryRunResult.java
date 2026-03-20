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

import com.google.api.core.BetaApi;
import java.util.List;

public interface BigQueryDryRunResult {

  /** Returns the schema of the results. Null if the schema is not supplied. */
  @BetaApi
  Schema getSchema() throws BigQuerySQLException;

  /**
   * Returns query parameters for standard SQL queries by extracting undeclare query parameters from
   * the dry run job. See more information:
   * https://developers.google.com/resources/api-libraries/documentation/bigquery/v2/java/latest/com/google/api/services/bigquery/model/JobStatistics2.html#getUndeclaredQueryParameters--
   */
  @BetaApi
  List<Parameter> getQueryParameters() throws BigQuerySQLException;

  /** Returns some processing statistics */
  @BetaApi
  BigQueryResultStats getStatistics() throws BigQuerySQLException;
}
