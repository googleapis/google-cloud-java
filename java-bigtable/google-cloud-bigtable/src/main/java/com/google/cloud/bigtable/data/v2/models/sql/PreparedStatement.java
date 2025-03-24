/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.bigtable.data.v2.models.sql;

/**
 * The results of query preparation that can be used to create {@link BoundStatement}s to execute
 * queries.
 *
 * <p>Whenever possible this should be shared across different instances of the same query, in order
 * to amortize query preparation costs.
 */
public interface PreparedStatement {

  /**
   * @return {@link BoundStatement.Builder} to bind query params to and pass to {@link
   *     com.google.cloud.bigtable.data.v2.BigtableDataClient#executeQuery(BoundStatement)}
   */
  BoundStatement.Builder bind();
}
