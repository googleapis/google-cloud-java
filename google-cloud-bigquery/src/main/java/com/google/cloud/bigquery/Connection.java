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
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Map;

/**
 * A Connection is a session between a Java application and BigQuery. SQL statements are executed
 * and results are returned within the context of a connection.
 */
public interface Connection {

  /** Sends a query cancel request. This call will return immediately */
  @BetaApi
  boolean close() throws BigQuerySQLException;

  /**
   * Execute a query dry run that returns information on the schema and query parameters of the
   * query results.
   *
   * @param sql typically a static SQL SELECT statement
   * @exception BigQuerySQLException if a database access error occurs
   */
  @BetaApi
  BigQueryDryRunResult dryRun(String sql) throws BigQuerySQLException;

  /**
   * Execute a SQL statement that returns a single ResultSet.
   *
   * <p>Example of running a query.
   *
   * <pre>
   * {
   *   &#64;code
   *   ConnectionSettings connectionSettings =
   *        ConnectionSettings.newBuilder()
   *            .setRequestTimeout(10L)
   *            .setMaxResults(100L)
   *            .setUseQueryCache(true)
   *            .build();
   *   Connection connection = bigquery.createConnection(connectionSettings);
   *   String selectQuery = "SELECT corpus FROM `bigquery-public-data.samples.shakespeare` GROUP BY corpus;";
   *   BigQueryResult bqResultSet = connection.executeSelect(selectQuery)
   *   ResultSet rs = bqResultSet.getResultSet();
   *   while (rs.next()) {
   *       System.out.printf("%s,", rs.getString("corpus"));
   *   }
   * </pre>
   *
   * @param sql a static SQL SELECT statement
   * @return a ResultSet that contains the data produced by the query
   * @exception BigQuerySQLException if a database access error occurs
   */
  @BetaApi
  BigQueryResult executeSelect(String sql) throws BigQuerySQLException;

  /**
   * This method executes a SQL SELECT query
   *
   * @param sql SQL SELECT query
   * @param parameters named or positional parameters. The set of query parameters must either be
   *     all positional or all named parameters.
   * @param labels (optional) the labels associated with this query. You can use these to organize
   *     and group your query jobs. Label keys and values can be no longer than 63 characters, can
   *     only contain lowercase letters, numeric characters, underscores and dashes. International
   *     characters are allowed. Label values are optional and Label is a Varargs. You should pass
   *     all the Labels in a single Map .Label keys must start with a letter and each label in the
   *     list must have a different key.
   * @return BigQueryResult containing the output of the query
   * @throws BigQuerySQLException
   */
  @BetaApi
  BigQueryResult executeSelect(
      String sql, List<Parameter> parameters, Map<String, String>... labels)
      throws BigQuerySQLException;

  /**
   * Execute a SQL statement that returns a single ResultSet and returns a ListenableFuture to
   * process the response asynchronously.
   *
   * <p>Example of running a query.
   *
   * <pre>
   * {
   *   &#64;code
   *  ConnectionSettings connectionSettings =
   *        ConnectionSettings.newBuilder()
   *            .setUseReadAPI(true)
   *            .build();
   *   Connection connection = bigquery.createConnection(connectionSettings);
   *   String selectQuery = "SELECT corpus FROM `bigquery-public-data.samples.shakespeare` GROUP BY corpus;";
   * ListenableFuture<ExecuteSelectResponse> executeSelectFuture = connection.executeSelectAsync(selectQuery);
   * ExecuteSelectResponse executeSelectRes = executeSelectFuture.get();
   *
   *  if(!executeSelectRes.getIsSuccessful()){
   * throw executeSelectRes.getBigQuerySQLException();
   * }
   *
   *  BigQueryResult bigQueryResult = executeSelectRes.getBigQueryResult();
   * ResultSet rs = bigQueryResult.getResultSet();
   * while (rs.next()) {
   * System.out.println(rs.getString(1));
   * }
   *
   * </pre>
   *
   * @param sql a static SQL SELECT statement
   * @return a ListenableFuture that is used to get the data produced by the query
   * @throws BigQuerySQLException upon failure
   */
  @BetaApi
  ListenableFuture<ExecuteSelectResponse> executeSelectAsync(String sql)
      throws BigQuerySQLException;

  /**
   * Execute a SQL statement that returns a single ResultSet and returns a ListenableFuture to
   * process the response asynchronously.
   *
   * <p>Example of running a query.
   *
   * <pre>
   * {
   *   &#64;code
   *  ConnectionSettings connectionSettings =
   *        ConnectionSettings.newBuilder()
   *            ..setUseReadAPI(true)
   *            .build();
   *   Connection connection = bigquery.createConnection(connectionSettings);
   *     String selectQuery =
   *         "SELECT TimestampField, StringField, BooleanField FROM "
   *             + MY_TABLE
   *             + " WHERE StringField = @stringParam"
   *             + " AND IntegerField IN UNNEST(@integerList)";
   *     QueryParameterValue stringParameter = QueryParameterValue.string("stringValue");
   *     QueryParameterValue intArrayParameter =
   *         QueryParameterValue.array(new Integer[] {3, 4}, Integer.class);
   *     Parameter stringParam =
   *         Parameter.newBuilder().setName("stringParam").setValue(stringParameter).build();
   *     Parameter intArrayParam =
   *         Parameter.newBuilder().setName("integerList").setValue(intArrayParameter).build();
   *     List<Parameter> parameters = ImmutableList.of(stringParam, intArrayParam);
   *
   *     ListenableFuture<ExecuteSelectResponse> executeSelectFut =
   *         connection.executeSelectAsync(selectQuery, parameters);
   * ExecuteSelectResponse executeSelectRes = executeSelectFuture.get();
   *
   *  if(!executeSelectRes.getIsSuccessful()){
   * throw executeSelectRes.getBigQuerySQLException();
   * }
   *
   *  BigQueryResult bigQueryResult = executeSelectRes.getBigQueryResult();
   * ResultSet rs = bigQueryResult.getResultSet();
   * while (rs.next()) {
   * System.out.println(rs.getString(1));
   * }
   *
   * </pre>
   *
   * @param sql SQL SELECT query
   * @param parameters named or positional parameters. The set of query parameters must either be
   *     all positional or all named parameters.
   * @param labels (optional) the labels associated with this query. You can use these to organize
   *     and group your query jobs. Label keys and values can be no longer than 63 characters, can
   *     only contain lowercase letters, numeric characters, underscores and dashes. International
   *     characters are allowed. Label values are optional and Label is a Varargs. You should pass
   *     all the Labels in a single Map .Label keys must start with a letter and each label in the
   *     list must have a different key.
   * @return a ListenableFuture that is used to get the data produced by the query
   * @throws BigQuerySQLException upon failure
   */
  @BetaApi
  ListenableFuture<ExecuteSelectResponse> executeSelectAsync(
      String sql, List<Parameter> parameters, Map<String, String>... labels)
      throws BigQuerySQLException;
}
