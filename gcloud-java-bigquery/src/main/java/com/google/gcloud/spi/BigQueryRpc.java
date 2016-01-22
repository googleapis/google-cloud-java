/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.spi;

import com.google.api.services.bigquery.model.Dataset;
import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.google.api.services.bigquery.model.Job;
import com.google.api.services.bigquery.model.JobConfigurationLoad;
import com.google.api.services.bigquery.model.QueryRequest;
import com.google.api.services.bigquery.model.QueryResponse;
import com.google.api.services.bigquery.model.Table;
import com.google.api.services.bigquery.model.TableDataInsertAllRequest;
import com.google.api.services.bigquery.model.TableDataInsertAllResponse;
import com.google.api.services.bigquery.model.TableRow;
import com.google.gcloud.bigquery.BigQueryException;

import java.util.Map;

public interface BigQueryRpc {

  // These options are part of the Google Cloud BigQuery query parameters
  enum Option {
    FIELDS("fields"),
    DELETE_CONTENTS("deleteContents"),
    ALL_DATASETS("all"),
    ALL_USERS("allUsers"),
    MAX_RESULTS("maxResults"),
    PAGE_TOKEN("pageToken"),
    START_INDEX("startIndex"),
    STATE_FILTER("stateFilter"),
    TIMEOUT("timeoutMs");

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

  class Tuple<X, Y> {

    private final X x;
    private final Y y;

    private Tuple(X x, Y y) {
      this.x = x;
      this.y = y;
    }

    public static <X, Y> Tuple<X, Y> of(X x, Y y) {
      return new Tuple<>(x, y);
    }

    public X x() {
      return x;
    }

    public Y y() {
      return y;
    }
  }

  /**
   * Returns the requested dataset or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  Dataset getDataset(String datasetId, Map<Option, ?> options) throws BigQueryException;

  /**
   * Lists the project's datasets. Partial information is returned on a dataset (datasetReference,
   * friendlyName and id). To get full information use {@link #getDataset(String, Map)}.
   *
   * @throws BigQueryException upon failure
   */
  Tuple<String, Iterable<Dataset>> listDatasets(Map<Option, ?> options) throws BigQueryException;

  Dataset create(Dataset dataset, Map<Option, ?> options) throws BigQueryException;

  Table create(Table table, Map<Option, ?> options) throws BigQueryException;

  Job create(Job job, Map<Option, ?> options) throws BigQueryException;

  /**
   * Delete the requested dataset.
   *
   * @return {@code true} if dataset was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean deleteDataset(String datasetId, Map<Option, ?> options) throws BigQueryException;

  Dataset patch(Dataset dataset, Map<Option, ?> options) throws BigQueryException;

  Table patch(Table table, Map<Option, ?> options) throws BigQueryException;

  /**
   * Returns the requested table or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  Table getTable(String datasetId, String tableId, Map<Option, ?> options) throws BigQueryException;

  /**
   * Lists the dataset's tables. Partial information is returned on a table (tableReference,
   * friendlyName, id and type). To get full information use {@link #getTable(String, String, Map)}.
   *
   * @throws BigQueryException upon failure
   */
  Tuple<String, Iterable<Table>> listTables(String dataset, Map<Option, ?> options)
      throws BigQueryException;

  /**
   * Delete the requested table.
   *
   * @return {@code true} if table was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean deleteTable(String datasetId, String tableId) throws BigQueryException;

  TableDataInsertAllResponse insertAll(String datasetId, String tableId,
      TableDataInsertAllRequest request) throws BigQueryException;

  Tuple<String, Iterable<TableRow>> listTableData(String datasetId, String tableId,
      Map<Option, ?> options) throws BigQueryException;

  /**
   * Returns the requested job or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  Job getJob(String jobId, Map<Option, ?> options) throws BigQueryException;

  /**
   * Lists the project's jobs.
   *
   * @throws BigQueryException upon failure
   */
  Tuple<String, Iterable<Job>> listJobs(Map<Option, ?> options) throws BigQueryException;

  /**
   * Sends a job cancel request. This call will return immediately, and the client will need to poll
   * for the job status to see if the cancel completed successfully.
   *
   * @return {@code true} if cancel was requested successfully, {@code false} if the job was not
   *     found
   * @throws BigQueryException upon failure
   */
  boolean cancel(String jobId) throws BigQueryException;

  GetQueryResultsResponse getQueryResults(String jobId, Map<Option, ?> options)
      throws BigQueryException;

  QueryResponse query(QueryRequest request) throws BigQueryException;

  /**
   * Opens a resumable upload session to load data into a BigQuery table and returns an upload URI.
   *
   * @param configuration load configuration
   * @throws BigQueryException upon failure
   */
  String open(JobConfigurationLoad configuration) throws BigQueryException;

  /**
   * Uploads the provided data to the resumable upload session at the specified position.
   *
   * @param uploadId the resumable upload session URI
   * @param toWrite a byte array of data to upload
   * @param toWriteOffset offset in the {@code toWrite} param to start writing from
   * @param destOffset offset in the destination where to upload data to
   * @param length the number of bytes to upload
   * @param last {@code true} indicates that the last chunk is being uploaded
   * @throws BigQueryException upon failure
   */
  void write(String uploadId, byte[] toWrite, int toWriteOffset, long destOffset, int length,
      boolean last) throws BigQueryException;
}
