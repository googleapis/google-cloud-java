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
import com.google.api.services.bigquery.model.JobReference;
import com.google.api.services.bigquery.model.QueryRequest;
import com.google.api.services.bigquery.model.QueryResponse;
import com.google.api.services.bigquery.model.Table;
import com.google.api.services.bigquery.model.TableDataInsertAllRequest;
import com.google.api.services.bigquery.model.TableDataInsertAllResponse;
import com.google.api.services.bigquery.model.TableReference;
import com.google.api.services.bigquery.model.TableRow;
import com.google.gcloud.bigquery.BigQueryException;

import java.util.Map;

public interface BigQueryRpc {

  // These options are part of the Google Cloud BigQuery query parameters
  enum Option {
    QUOTA_USER("quotaUser"),
    USER_IP("userIp"),
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

  Dataset getDataset(String datasetId, Map<Option, ?> options) throws BigQueryException;

  Tuple<String, Iterable<Dataset>> listDatasets(Map<Option, ?> options) throws BigQueryException;

  Dataset create(Dataset dataset, Map<Option, ?> options) throws BigQueryException;

  boolean deleteDataset(String datasetId, Map<Option, ?> options) throws BigQueryException;

  Dataset patch(Dataset dataset, Map<Option, ?> options) throws BigQueryException;

  Table getTable(String datasetId, String tableId, Map<Option, ?> options) throws BigQueryException;

  Tuple<String, Iterable<Table>> listTables(String dataset, Map<Option, ?> options)
      throws BigQueryException;

  Table create(Table table, Map<Option, ?> options) throws BigQueryException;

  boolean deleteTable(String datasetId, String tableId, Map<Option, ?> options)
      throws BigQueryException;

  Table patch(Table table, Map<Option, ?> options) throws BigQueryException;

  TableDataInsertAllResponse insertAll(TableReference table, TableDataInsertAllRequest request,
      Map<Option, ?> options) throws BigQueryException;

  Tuple<String, Iterable<TableRow>> listTableData(String datasetId, String tableId,
      Map<Option, ?> options) throws BigQueryException;

  Job getJob(String jobId, Map<Option, ?> options) throws BigQueryException;

  Tuple<String, Iterable<Job>> listJobs(Map<Option, ?> options) throws BigQueryException;

  Job create(Job job, Map<Option, ?> options) throws BigQueryException;

  boolean cancel(String jobId, Map<Option, ?> options) throws BigQueryException;

  GetQueryResultsResponse getQueryResults(JobReference job, Map<Option, ?> options)
      throws BigQueryException;

  QueryResponse query(QueryRequest request, Map<Option, ?> options) throws BigQueryException;
}
