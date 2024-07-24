/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.bigquery.spi.v2;

import com.google.api.core.InternalExtensionOnly;
import com.google.api.services.bigquery.Bigquery.Jobs.Query;
import com.google.api.services.bigquery.model.Dataset;
import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.google.api.services.bigquery.model.Job;
import com.google.api.services.bigquery.model.Model;
import com.google.api.services.bigquery.model.Policy;
import com.google.api.services.bigquery.model.QueryRequest;
import com.google.api.services.bigquery.model.QueryResponse;
import com.google.api.services.bigquery.model.Routine;
import com.google.api.services.bigquery.model.Table;
import com.google.api.services.bigquery.model.TableDataInsertAllRequest;
import com.google.api.services.bigquery.model.TableDataInsertAllResponse;
import com.google.api.services.bigquery.model.TableDataList;
import com.google.api.services.bigquery.model.TestIamPermissionsResponse;
import com.google.cloud.ServiceRpc;
import com.google.cloud.Tuple;
import com.google.cloud.bigquery.BigQueryException;
import java.util.List;
import java.util.Map;

@InternalExtensionOnly
public interface BigQueryRpc extends ServiceRpc {

  // These options are part of the Google Cloud BigQuery query parameters.
  enum Option {
    FIELDS("fields"),
    DELETE_CONTENTS("deleteContents"),
    ALL_DATASETS("all"),
    ALL_USERS("allUsers"),
    AUTODETECT_SCHEMA("autodetectSchema"),
    LABEL_FILTER("filter"),
    MIN_CREATION_TIME("minCreationTime"),
    MAX_CREATION_TIME("maxCreationTime"),
    MAX_RESULTS("maxResults"),
    PAGE_TOKEN("pageToken"),
    PARENT_JOB_ID("parentJobId"),
    START_INDEX("startIndex"),
    STATE_FILTER("stateFilter"),
    TIMEOUT("timeoutMs"),
    REQUESTED_POLICY_VERSION("requestedPolicyVersion"),
    TABLE_METADATA_VIEW("view"),
    RETRY_OPTIONS("retryOptions"),
    BIGQUERY_RETRY_CONFIG("bigQueryRetryConfig");

    private final String value;

    Option(String value) {
      this.value = value;
    }

    public String value() {
      return value;
    }

    @SuppressWarnings("unchecked")
    <T> T get(Map<Option, ?> options) {
      return (T) options.get(this);
    }

    String getString(Map<Option, ?> options) {
      return get(options);
    }

    Long getLong(Map<Option, ?> options) {
      return get(options);
    }

    Boolean getBoolean(Map<Option, ?> options) {
      return get(options);
    }
  }

  /**
   * Returns the requested dataset or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  Dataset getDataset(String projectId, String datasetId, Map<Option, ?> options);

  /**
   * Lists the provided project's datasets, keyed by page token. Partial information is returned on
   * a dataset (datasetReference, friendlyName and id). To get full information use {@link
   * #getDataset(String, String, Map)}.
   *
   * @throws BigQueryException upon failure
   */
  Tuple<String, Iterable<Dataset>> listDatasets(String projectId, Map<Option, ?> options);

  /**
   * Creates a new dataset.
   *
   * @throws BigQueryException upon failure
   */
  Dataset create(Dataset dataset, Map<Option, ?> options);

  /**
   * Creates a new table.
   *
   * @throws BigQueryException upon failure
   */
  Table create(Table table, Map<Option, ?> options);

  /**
   * Creates a new job.
   *
   * @throws BigQueryException upon failure
   */
  Job create(Job job, Map<Option, ?> options);

  /**
   * Creates a new query job.
   *
   * @throws BigQueryException upon failure
   */
  Job createJobForQuery(Job job);

  /**
   * Delete the requested dataset.
   *
   * @return {@code true} if dataset was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean deleteDataset(String projectId, String datasetId, Map<Option, ?> options);

  /**
   * Updates dataset information.
   *
   * @throws BigQueryException upon failure
   */
  Dataset patch(Dataset dataset, Map<Option, ?> options);

  /**
   * Updates table information.
   *
   * @throws BigQueryException upon failure
   */
  Table patch(Table table, Map<Option, ?> options);

  /**
   * Returns the requested table or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  Table getTable(String projectId, String datasetId, String tableId, Map<Option, ?> options);

  /**
   * Lists the dataset's tables, keyed by page token. Partial information is returned on a table
   * (tableReference, friendlyName, id and type). To get full information use {@link
   * #getTable(String, String, String, Map)}.
   *
   * @throws BigQueryException upon failure
   */
  Tuple<String, Iterable<Table>> listTables(
      String projectId, String dataset, Map<Option, ?> options);

  /**
   * Delete the requested table.
   *
   * @return {@code true} if table was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean deleteTable(String projectId, String datasetId, String tableId);

  /**
   * Updates model information.
   *
   * @throws BigQueryException upon failure
   */
  Model patch(Model model, Map<Option, ?> options);

  /**
   * Returns the requested model or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  Model getModel(String projectId, String datasetId, String modelId, Map<Option, ?> options);

  /**
   * Lists the dataset's models, keyed by page token.
   *
   * @throws BigQueryException upon failure
   */
  Tuple<String, Iterable<Model>> listModels(
      String projectId, String dataset, Map<Option, ?> options);

  /**
   * Delete the requested model.
   *
   * @return {@code true} if model was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean deleteModel(String projectId, String datasetId, String modelId);

  /**
   * Creates the requested routine.
   *
   * @throws BigQueryException upon failure
   */
  Routine create(Routine routine, Map<Option, ?> options);

  /**
   * Updates the requested routine.
   *
   * @throws BigQueryException upon failure
   */
  Routine update(Routine routine, Map<Option, ?> options);

  /**
   * Returns the requested routine or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  Routine getRoutine(String projectId, String datasetId, String routineId, Map<Option, ?> options);

  Tuple<String, Iterable<Routine>> listRoutines(
      String projectId, String datasetId, Map<Option, ?> options);
  /**
   * Deletes the requested routine.
   *
   * @return {@code true} if routine was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean deleteRoutine(String projectId, String datasetId, String routineId);

  /**
   * Sends an insert all request.
   *
   * @throws BigQueryException upon failure
   */
  TableDataInsertAllResponse insertAll(
      String projectId, String datasetId, String tableId, TableDataInsertAllRequest request);

  /**
   * Lists the table's rows.
   *
   * @throws BigQueryException upon failure
   */
  TableDataList listTableData(
      String projectId, String datasetId, String tableId, Map<Option, ?> options);

  /**
   * Lists the table's rows with a limit on how many rows of data to pre-fetch.
   *
   * @throws BigQueryException upon failure
   */
  TableDataList listTableDataWithRowLimit(
      String projectId, String datasetId, String tableId, Integer rowLimit, String pageToken);

  /**
   * Returns the requested job or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  Job getJob(String projectId, String jobId, String location, Map<Option, ?> options);

  /**
   * Returns the requested query job or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  Job getQueryJob(String projectId, String jobId, String location);

  /**
   * Lists the project's jobs.
   *
   * @throws BigQueryException upon failure
   */
  Tuple<String, Iterable<Job>> listJobs(String projectId, Map<Option, ?> options);

  /**
   * Sends a job cancel request. This call will return immediately, and the client will need to poll
   * for the job status to see if the cancel completed successfully.
   *
   * @return {@code true} if cancel was requested successfully, {@code false} if the job was not
   *     found
   * @throws BigQueryException upon failure
   */
  boolean cancel(String projectId, String jobId, String location);

  /**
   * Sends a job delete request.
   *
   * @return {@code true} if delete was successful, {@code false} if the job was not found
   * @throws BigQueryException upon failure
   */
  boolean deleteJob(String projectId, String jobName, String location);

  /**
   * Returns results of the query associated with the provided job.
   *
   * @throws BigQueryException upon failure
   */
  GetQueryResultsResponse getQueryResults(
      String projectId, String jobId, String location, Map<Option, ?> options);

  /**
   * Returns results of the query with a limit on how many rows of data to pre-fetch associated with
   * the provided job.
   *
   * @throws BigQueryException upon failure
   */
  GetQueryResultsResponse getQueryResultsWithRowLimit(
      String projectId, String jobId, String location, Integer preFetchedRowLimit, Long timeoutMs);

  /**
   * Runs a BigQuery SQL query synchronously and returns query results if the query completes within
   * a specified timeout.
   *
   * <p>Create a request for the method "jobs.query".
   *
   * <p>This request holds the parameters needed by the bigquery server. After setting any optional
   * parameters, call the {@link Query#execute()} method to invoke the remote operation.
   *
   * @param projectId Project ID of the project billed for the query
   * @param content the {@link com.google.api.services.bigquery.model.QueryRequest}
   * @return the request
   */
  QueryResponse queryRpc(String projectId, QueryRequest content);

  /**
   * Opens a resumable upload session to load data into a BigQuery table and returns an upload URI.
   *
   * @param job load job
   * @throws BigQueryException upon failure
   */
  String open(Job job);

  /**
   * Uploads the provided data to the resumable upload session at the specified position. This
   * method returns the job created to insert the rows, only when {@code last} is {@code true}.
   *
   * @param uploadId the resumable upload session URI
   * @param toWrite a byte array of data to upload
   * @param toWriteOffset offset in the {@code toWrite} param to start writing from
   * @param destOffset offset in the destination where to upload data to
   * @param length the number of bytes to upload
   * @param last {@code true} indicates that the last chunk is being uploaded
   * @return returns the job created to insert the rows, only when {@code last} is {@code true}.
   *     Returns {@code null} otherwise
   * @throws BigQueryException upon failure
   */
  Job write(
      String uploadId,
      byte[] toWrite,
      int toWriteOffset,
      long destOffset,
      int length,
      boolean last);

  /**
   * Returns the IAM Policy for the specified resource, using Policy V1.
   *
   * @throws BigQueryException upon failure
   */
  Policy getIamPolicy(String resourceId, Map<Option, ?> options);

  /**
   * Updates the IAM policy for the specified resource.
   *
   * @throws BigQueryException upon failure
   */
  Policy setIamPolicy(String resourceId, Policy policy, Map<Option, ?> options);

  /**
   * Tests whether the caller holds the provided permissions for the specified resource. Returns the
   * subset of permissions the caller actually holds.
   *
   * @throws BigQueryException upon failure
   */
  TestIamPermissionsResponse testIamPermissions(
      String resourceId, List<String> permissions, Map<Option, ?> options);
}
