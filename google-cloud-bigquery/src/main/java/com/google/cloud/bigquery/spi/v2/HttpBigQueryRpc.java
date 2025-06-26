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

import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.core.InternalApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.api.services.bigquery.Bigquery;
import com.google.api.services.bigquery.model.Dataset;
import com.google.api.services.bigquery.model.DatasetList;
import com.google.api.services.bigquery.model.DatasetReference;
import com.google.api.services.bigquery.model.GetIamPolicyRequest;
import com.google.api.services.bigquery.model.GetPolicyOptions;
import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.google.api.services.bigquery.model.Job;
import com.google.api.services.bigquery.model.JobList;
import com.google.api.services.bigquery.model.JobStatus;
import com.google.api.services.bigquery.model.ListModelsResponse;
import com.google.api.services.bigquery.model.ListRoutinesResponse;
import com.google.api.services.bigquery.model.Model;
import com.google.api.services.bigquery.model.ModelReference;
import com.google.api.services.bigquery.model.Policy;
import com.google.api.services.bigquery.model.QueryRequest;
import com.google.api.services.bigquery.model.QueryResponse;
import com.google.api.services.bigquery.model.Routine;
import com.google.api.services.bigquery.model.RoutineReference;
import com.google.api.services.bigquery.model.SetIamPolicyRequest;
import com.google.api.services.bigquery.model.Table;
import com.google.api.services.bigquery.model.TableDataInsertAllRequest;
import com.google.api.services.bigquery.model.TableDataInsertAllResponse;
import com.google.api.services.bigquery.model.TableDataList;
import com.google.api.services.bigquery.model.TableList;
import com.google.api.services.bigquery.model.TableReference;
import com.google.api.services.bigquery.model.TestIamPermissionsRequest;
import com.google.api.services.bigquery.model.TestIamPermissionsResponse;
import com.google.cloud.Tuple;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.http.HttpTransportOptions;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanKind;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@InternalExtensionOnly
public class HttpBigQueryRpc implements BigQueryRpc {

  public static final String DEFAULT_PROJECTION = "full";
  private static final String BASE_RESUMABLE_URI = "upload/bigquery/v2/projects/";
  // see:
  // https://cloud.google.com/bigquery/loading-data-post-request#resume-upload
  private static final int HTTP_RESUME_INCOMPLETE = 308;
  private final BigQueryOptions options;
  private final Bigquery bigquery;

  @InternalApi("Visible for testing")
  static final Function<DatasetList.Datasets, Dataset> LIST_TO_DATASET =
      new Function<DatasetList.Datasets, Dataset>() {
        @Override
        public Dataset apply(DatasetList.Datasets datasetPb) {
          return new Dataset()
              .setDatasetReference(datasetPb.getDatasetReference())
              .setFriendlyName(datasetPb.getFriendlyName())
              .setId(datasetPb.getId())
              .setKind(datasetPb.getKind())
              .setLocation(datasetPb.getLocation())
              .setLabels(datasetPb.getLabels());
        }
      };

  public HttpBigQueryRpc(BigQueryOptions options) {
    HttpTransportOptions transportOptions = (HttpTransportOptions) options.getTransportOptions();
    HttpTransport transport = transportOptions.getHttpTransportFactory().create();
    HttpRequestInitializer initializer = transportOptions.getHttpRequestInitializer(options);
    this.options = options;
    bigquery =
        new Bigquery.Builder(transport, new GsonFactory(), initializer)
            .setRootUrl(options.getResolvedApiaryHost("bigquery"))
            .setApplicationName(options.getApplicationName())
            .build();
  }

  private static BigQueryException translate(IOException exception) {
    return new BigQueryException(exception);
  }

  private void validateRPC() throws BigQueryException, IOException {
    if (!this.options.hasValidUniverseDomain()) {
      String errorMessage =
          String.format(
              "The configured universe domain %s does not match the universe domain found in the credentials %s. If you haven't configured the universe domain explicitly, `googleapis.com` is the default.",
              this.options.getUniverseDomain(), this.options.getCredentials().getUniverseDomain());
      throw new BigQueryException(HTTP_UNAUTHORIZED, errorMessage);
    }
  }

  @Override
  public Dataset getDataset(String projectId, String datasetId, Map<Option, ?> options) {
    try {
      return getDatasetSkipExceptionTranslation(projectId, datasetId, options);
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  @InternalApi("internal to java-bigquery")
  public Dataset getDatasetSkipExceptionTranslation(
      String projectId, String datasetId, Map<Option, ?> options) throws IOException {
    validateRPC();
    Bigquery.Datasets.Get bqGetRequest =
        bigquery
            .datasets()
            .get(projectId, datasetId)
            .setFields(Option.FIELDS.getString(options))
            .setPrettyPrint(false);
    if (options.containsKey(Option.ACCESS_POLICY_VERSION)) {
      bqGetRequest.setAccessPolicyVersion((Integer) options.get(Option.ACCESS_POLICY_VERSION));
    }
    if (options.containsKey(Option.DATASET_VIEW)) {
      bqGetRequest.setDatasetView(options.get(Option.DATASET_VIEW).toString());
    }

    Span getDataset = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      getDataset =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.getDataset")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "DatasetService")
              .setAttribute("bq.rpc.method", "GetDataset")
              .setAttribute("bq.rpc.system", "http")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }

    Dataset dataset = bqGetRequest.execute();
    if (getDataset != null) {
      getDataset.setAttribute("bq.rpc.response.dataset.id", dataset.getId());
      getDataset.end();
    }
    return dataset;
  }

  @Override
  public Tuple<String, Iterable<Dataset>> listDatasets(String projectId, Map<Option, ?> options) {
    try {
      return listDatasetsSkipExceptionTranslation(projectId, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public Tuple<String, Iterable<Dataset>> listDatasetsSkipExceptionTranslation(
      String projectId, Map<Option, ?> options) throws IOException {
    validateRPC();
    Bigquery.Datasets.List datasetsListRequest =
        bigquery
            .datasets()
            .list(projectId)
            .setPrettyPrint(false)
            .setAll(Option.ALL_DATASETS.getBoolean(options))
            .setFilter(Option.LABEL_FILTER.getString(options))
            .setMaxResults(Option.MAX_RESULTS.getLong(options))
            .setPageToken(Option.PAGE_TOKEN.getString(options));

    Span listDatasets = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      listDatasets =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.listDatasets")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "DatasetService")
              .setAttribute("bq.rpc.method", "ListDatasets")
              .setAttribute("bq.rpc.system", "http")
              .setAttribute("bq.rpc.page_token", datasetsListRequest.getPageToken())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }

    DatasetList datasetsList = datasetsListRequest.execute();
    Iterable<DatasetList.Datasets> datasets = datasetsList.getDatasets();
    if (listDatasets != null) {
      listDatasets.setAttribute("bq.rpc.next_page_token", datasetsList.getNextPageToken());
      listDatasets.end();
    }
    return Tuple.of(
        datasetsList.getNextPageToken(),
        Iterables.transform(
            datasets != null ? datasets : ImmutableList.<DatasetList.Datasets>of(),
            LIST_TO_DATASET));
  }

  @Override
  public Dataset create(Dataset dataset, Map<Option, ?> options) {
    try {
      return createSkipExceptionTranslation(dataset, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public Dataset createSkipExceptionTranslation(Dataset dataset, Map<Option, ?> options)
      throws IOException {
    validateRPC();
    Bigquery.Datasets.Insert bqCreateRequest =
        bigquery
            .datasets()
            .insert(dataset.getDatasetReference().getProjectId(), dataset)
            .setPrettyPrint(false)
            .setFields(Option.FIELDS.getString(options));
    if (options.containsKey(Option.ACCESS_POLICY_VERSION)) {
      bqCreateRequest.setAccessPolicyVersion((Integer) options.get(Option.ACCESS_POLICY_VERSION));
    }

    Span createDataset = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      createDataset =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.createDataset")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "DatasetService")
              .setAttribute("bq.rpc.method", "InsertDataset")
              .setAttribute("bq.rpc.system", "http")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    Dataset datasetResponse = bqCreateRequest.execute();
    if (createDataset != null) {
      createDataset.setAttribute("bq.rpc.response.dataset.id", datasetResponse.getId());
      createDataset.end();
    }
    return datasetResponse;
  }

  @Override
  public Table create(Table table, Map<Option, ?> options) {
    try {
      return createSkipExceptionTranslation(table, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public Table createSkipExceptionTranslation(Table table, Map<Option, ?> options)
      throws IOException {
    validateRPC();
    // unset the type, as it is output only
    table.setType(null);
    TableReference reference = table.getTableReference();
    Bigquery.Tables.Insert bqCreateRequest =
        bigquery
            .tables()
            .insert(reference.getProjectId(), reference.getDatasetId(), table)
            .setPrettyPrint(false)
            .setFields(Option.FIELDS.getString(options));

    Span createTable = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      createTable =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.createTable")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "TableService")
              .setAttribute("bq.rpc.method", "InsertTable")
              .setAttribute("bq.rpc.system", "http")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    Table tableResponse = bqCreateRequest.execute();
    if (createTable != null) {
      createTable.setAttribute("bq.rpc.response.table.id", tableResponse.getId());
      createTable.end();
    }
    return tableResponse;
  }

  @Override
  public Routine create(Routine routine, Map<Option, ?> options) {
    try {
      return createSkipExceptionTranslation(routine, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public Routine createSkipExceptionTranslation(Routine routine, Map<Option, ?> options)
      throws IOException {
    validateRPC();
    RoutineReference reference = routine.getRoutineReference();
    Bigquery.Routines.Insert bqCreateRequest =
        bigquery
            .routines()
            .insert(reference.getProjectId(), reference.getDatasetId(), routine)
            .setPrettyPrint(false)
            .setFields(Option.FIELDS.getString(options));

    Span createRoutine = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      createRoutine =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.createRoutine")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "RoutineService")
              .setAttribute("bq.rpc.method", "InsertRoutine")
              .setAttribute("bq.rpc.system", "http")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    Routine routineResponse = bqCreateRequest.execute();
    if (createRoutine != null) {
      createRoutine.setAttribute(
          "bq.rpc.response.routine.id", routineResponse.getRoutineReference().getRoutineId());
      createRoutine.end();
    }
    return routineResponse;
  }

  @Override
  public Job create(Job job, Map<Option, ?> options) {
    try {
      return createSkipExceptionTranslation(job, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public Job createSkipExceptionTranslation(Job job, Map<Option, ?> options) throws IOException {
    validateRPC();
    String projectId =
        job.getJobReference() != null
            ? job.getJobReference().getProjectId()
            : this.options.getProjectId();
    Bigquery.Jobs.Insert bqCreateRequest =
        bigquery
            .jobs()
            .insert(projectId, job)
            .setPrettyPrint(false)
            .setFields(Option.FIELDS.getString(options));

    Span createJob = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      createJob =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.createJob")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "JobService")
              .setAttribute("bq.rpc.method", "InsertJob")
              .setAttribute("bq.rpc.system", "http")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    Job jobResponse = bqCreateRequest.execute();
    if (createJob != null) {
      createJob.setAttribute("bq.rpc.response.job.id", jobResponse.getId());
      createJob.setAttribute(
          "bq.rpc.response.job.status.state", jobResponse.getStatus().getState());
      createJob.end();
    }
    return jobResponse;
  }

  @Override
  public Job createJobForQuery(Job job) {
    try {
      return createJobForQuerySkipExceptionTranslation(job);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public Job createJobForQuerySkipExceptionTranslation(Job job) throws IOException {
    validateRPC();
    String projectId =
        job.getJobReference() != null
            ? job.getJobReference().getProjectId()
            : this.options.getProjectId();
    Bigquery.Jobs.Insert bqCreateRequest =
        bigquery.jobs().insert(projectId, job).setPrettyPrint(false);

    Span createJob = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      createJob =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.createJobForQuery")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "JobService")
              .setAttribute("bq.rpc.method", "InsertJob")
              .setAttribute("bq.rpc.system", "http")
              .startSpan();
    }
    Job jobResponse = bqCreateRequest.execute();
    if (createJob != null) {
      createJob.setAttribute("bq.rpc.response.job.id", jobResponse.getId());
      createJob.setAttribute(
          "bq.rpc.response.job.status.state", jobResponse.getStatus().getState());
      createJob.end();
    }
    return jobResponse;
  }

  @Override
  public boolean deleteDataset(String projectId, String datasetId, Map<Option, ?> options) {
    try {
      return deleteDatasetSkipExceptionTranslation(projectId, datasetId, options);
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  @InternalApi("internal to java-bigquery")
  public boolean deleteDatasetSkipExceptionTranslation(
      String projectId, String datasetId, Map<Option, ?> options) throws IOException {
    validateRPC();
    Bigquery.Datasets.Delete bqDeleteRequest =
        bigquery
            .datasets()
            .delete(projectId, datasetId)
            .setPrettyPrint(false)
            .setDeleteContents(Option.DELETE_CONTENTS.getBoolean(options));

    Span deleteDataset = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      deleteDataset =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.deleteDataset")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "DatasetService")
              .setAttribute("bq.rpc.method", "DeleteDataset")
              .setAttribute("bq.rpc.system", "http")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    bqDeleteRequest.execute();
    if (deleteDataset != null) {
      deleteDataset.end();
    }
    return true;
  }

  @Override
  public Dataset patch(Dataset dataset, Map<Option, ?> options) {
    try {
      return patchSkipExceptionTranslation(dataset, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public Dataset patchSkipExceptionTranslation(Dataset dataset, Map<Option, ?> options)
      throws IOException {
    validateRPC();
    DatasetReference reference = dataset.getDatasetReference();
    Bigquery.Datasets.Patch bqPatchRequest =
        bigquery
            .datasets()
            .patch(reference.getProjectId(), reference.getDatasetId(), dataset)
            .setPrettyPrint(false)
            .setFields(Option.FIELDS.getString(options));
    if (options.containsKey(Option.ACCESS_POLICY_VERSION)) {
      bqPatchRequest.setAccessPolicyVersion((Integer) options.get(Option.ACCESS_POLICY_VERSION));
    }
    if (options.containsKey(Option.DATASET_UPDATE_MODE)) {
      bqPatchRequest.setUpdateMode(options.get(Option.DATASET_UPDATE_MODE).toString());
    }

    Span patchDataset = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      patchDataset =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.patchDataset")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "DatasetService")
              .setAttribute("bq.rpc.method", "PatchDataset")
              .setAttribute("bq.rpc.system", "http")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    Dataset datasetResponse = bqPatchRequest.execute();
    if (patchDataset != null) {
      patchDataset.setAttribute("bq.rpc.response.dataset.id", datasetResponse.getId());
      patchDataset.end();
    }
    return datasetResponse;
  }

  @Override
  public Table patch(Table table, Map<Option, ?> options) {
    try {
      return patchSkipExceptionTranslation(table, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public Table patchSkipExceptionTranslation(Table table, Map<Option, ?> options)
      throws IOException {
    validateRPC();
    // unset the type, as it is output only
    table.setType(null);
    TableReference reference = table.getTableReference();
    Bigquery.Tables.Patch bqPatchRequest =
        bigquery
            .tables()
            .patch(
                reference.getProjectId(), reference.getDatasetId(), reference.getTableId(), table)
            .setPrettyPrint(false)
            .setFields(Option.FIELDS.getString(options))
            .setAutodetectSchema(BigQueryRpc.Option.AUTODETECT_SCHEMA.getBoolean(options));

    Span patchTable = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      patchTable =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.patchTable")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "TableService")
              .setAttribute("bq.rpc.method", "PatchTable")
              .setAttribute("bq.rpc.system", "http")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    Table tableResponse = bqPatchRequest.execute();
    if (patchTable != null) {
      patchTable.setAttribute("bq.rpc.response.table.id", tableResponse.getId());
      patchTable.end();
    }
    return tableResponse;
  }

  @Override
  public Table getTable(
      String projectId, String datasetId, String tableId, Map<Option, ?> options) {
    try {
      return getTableSkipExceptionTranslation(projectId, datasetId, tableId, options);
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  @InternalApi("internal to java-bigquery")
  public Table getTableSkipExceptionTranslation(
      String projectId, String datasetId, String tableId, Map<Option, ?> options)
      throws IOException {
    validateRPC();
    Bigquery.Tables.Get bqGetRequest =
        bigquery
            .tables()
            .get(projectId, datasetId, tableId)
            .setPrettyPrint(false)
            .setFields(Option.FIELDS.getString(options))
            .setView(getTableMetadataOption(options));

    Span getTable = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      getTable =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.getTable")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "TableService")
              .setAttribute("bq.rpc.method", "GetTable")
              .setAttribute("bq.rpc.system", "http")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    Table tableResponse = bqGetRequest.execute();
    if (getTable != null) {
      getTable.setAttribute("bq.rpc.response.table.id", tableResponse.getId());
      getTable.end();
    }
    return tableResponse;
  }

  private String getTableMetadataOption(Map<Option, ?> options) {
    if (options.containsKey(Option.TABLE_METADATA_VIEW)) {
      return options.get(Option.TABLE_METADATA_VIEW).toString();
    }
    return "STORAGE_STATS";
  }

  @Override
  public Tuple<String, Iterable<Table>> listTables(
      String projectId, String datasetId, Map<Option, ?> options) {
    try {
      return listTablesSkipExceptionTranslation(projectId, datasetId, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public Tuple<String, Iterable<Table>> listTablesSkipExceptionTranslation(
      String projectId, String datasetId, Map<Option, ?> options) throws IOException {
    validateRPC();
    Bigquery.Tables.List tableListRequest =
        bigquery
            .tables()
            .list(projectId, datasetId)
            .setPrettyPrint(false)
            .setMaxResults(Option.MAX_RESULTS.getLong(options))
            .setPageToken(Option.PAGE_TOKEN.getString(options));

    Span listTables = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      listTables =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.listTables")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "TableService")
              .setAttribute("bq.rpc.method", "ListTables")
              .setAttribute("bq.rpc.system", "http")
              .setAttribute("bq.rpc.page_token", tableListRequest.getPageToken())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    TableList tableResponse = tableListRequest.execute();
    if (listTables != null) {
      listTables.setAttribute("bq.rpc.next_page_token", tableResponse.getNextPageToken());
      listTables.end();
    }

    Iterable<TableList.Tables> tables = tableResponse.getTables();
    return Tuple.of(
        tableResponse.getNextPageToken(),
        Iterables.transform(
            tables != null ? tables : ImmutableList.<TableList.Tables>of(),
            new Function<TableList.Tables, Table>() {
              @Override
              public Table apply(TableList.Tables tablePb) {
                return new Table()
                    .setFriendlyName(tablePb.getFriendlyName())
                    .setId(tablePb.getId())
                    .setKind(tablePb.getKind())
                    .setTableReference(tablePb.getTableReference())
                    .setType(tablePb.getType())
                    .setCreationTime(tablePb.getCreationTime())
                    .setTimePartitioning(tablePb.getTimePartitioning())
                    .setRangePartitioning(tablePb.getRangePartitioning())
                    .setClustering(tablePb.getClustering())
                    .setLabels(tablePb.getLabels());
              }
            }));
  }

  @Override
  public boolean deleteTable(String projectId, String datasetId, String tableId) {
    try {
      return deleteTableSkipExceptionTranslation(projectId, datasetId, tableId);
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  @InternalApi("internal to java-bigquery")
  public boolean deleteTableSkipExceptionTranslation(
      String projectId, String datasetId, String tableId) throws IOException {
    validateRPC();
    Bigquery.Tables.Delete bqDeleteRequest =
        bigquery.tables().delete(projectId, datasetId, tableId);

    Span deleteTable = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      deleteTable =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.deleteTable")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "TableService")
              .setAttribute("bq.rpc.method", "DeleteTable")
              .setAttribute("bq.rpc.system", "http")
              .startSpan();
    }
    bqDeleteRequest.execute();
    if (deleteTable != null) {
      deleteTable.end();
    }
    return true;
  }

  @Override
  public Model patch(Model model, Map<Option, ?> options) {
    try {
      return patchSkipExceptionTranslation(model, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public Model patchSkipExceptionTranslation(Model model, Map<Option, ?> options)
      throws IOException {
    validateRPC();
    // unset the type, as it is output only
    ModelReference reference = model.getModelReference();
    Bigquery.Models.Patch bqPatchRequest =
        bigquery
            .models()
            .patch(
                reference.getProjectId(), reference.getDatasetId(), reference.getModelId(), model)
            .setPrettyPrint(false)
            .setFields(Option.FIELDS.getString(options));

    Span patchModel = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      patchModel =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.patchModel")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "ModelService")
              .setAttribute("bq.rpc.method", "PatchModel")
              .setAttribute("bq.rpc.system", "http")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    Model modelResponse = bqPatchRequest.execute();
    if (patchModel != null) {
      patchModel.setAttribute(
          "bq.rpc.response.model.id", modelResponse.getModelReference().getModelId());
      patchModel.end();
    }
    return modelResponse;
  }

  @Override
  public Model getModel(
      String projectId, String datasetId, String modelId, Map<Option, ?> options) {
    try {
      return getModelSkipExceptionTranslation(projectId, datasetId, modelId, options);
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  @InternalApi("internal to java-bigquery")
  public Model getModelSkipExceptionTranslation(
      String projectId, String datasetId, String modelId, Map<Option, ?> options)
      throws IOException {
    validateRPC();
    Bigquery.Models.Get bqGetRequest =
        bigquery
            .models()
            .get(projectId, datasetId, modelId)
            .setPrettyPrint(false)
            .setFields(Option.FIELDS.getString(options));

    Span getModel = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      getModel =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.getModel")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "ModelService")
              .setAttribute("bq.rpc.method", "GetModel")
              .setAttribute("bq.rpc.system", "http")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    Model modelResponse = bqGetRequest.execute();
    if (getModel != null) {
      getModel.setAttribute(
          "bq.rpc.response.model.id", modelResponse.getModelReference().getModelId());
      getModel.end();
    }
    return modelResponse;
  }

  @Override
  public Tuple<String, Iterable<Model>> listModels(
      String projectId, String datasetId, Map<Option, ?> options) {
    try {
      return listModelsSkipExceptionTranslation(projectId, datasetId, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public Tuple<String, Iterable<Model>> listModelsSkipExceptionTranslation(
      String projectId, String datasetId, Map<Option, ?> options) throws IOException {
    validateRPC();
    Bigquery.Models.List modelListRequest =
        bigquery
            .models()
            .list(projectId, datasetId)
            .setPrettyPrint(false)
            .setMaxResults(Option.MAX_RESULTS.getLong(options))
            .setPageToken(Option.PAGE_TOKEN.getString(options));

    Span listModels = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      listModels =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.listModels")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "ModelService")
              .setAttribute("bq.rpc.method", "ListModels")
              .setAttribute("bq.rpc.system", "http")
              .setAttribute("bq.rpc.page_token", modelListRequest.getPageToken())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    ListModelsResponse modelResponse = modelListRequest.execute();
    if (listModels != null) {
      listModels.setAttribute("bq.rpc.next_page_token", modelResponse.getNextPageToken());
      listModels.end();
    }

    Iterable<Model> models =
        modelResponse.getModels() != null ? modelResponse.getModels() : ImmutableList.<Model>of();
    return Tuple.of(modelResponse.getNextPageToken(), models);
  }

  @Override
  public boolean deleteModel(String projectId, String datasetId, String modelId) {
    try {
      return deleteModelSkipExceptionTranslation(projectId, datasetId, modelId);
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  @InternalApi("internal to java-bigquery")
  public boolean deleteModelSkipExceptionTranslation(
      String projectId, String datasetId, String modelId) throws IOException {
    validateRPC();
    Bigquery.Models.Delete bqDeleteRequest =
        bigquery.models().delete(projectId, datasetId, modelId);

    Span deleteModels = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      deleteModels =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.deleteModel")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "ModelService")
              .setAttribute("bq.rpc.method", "DeleteModel")
              .setAttribute("bq.rpc.system", "http")
              .startSpan();
    }
    bqDeleteRequest.execute();
    if (deleteModels != null) {
      deleteModels.end();
    }
    return true;
  }

  @Override
  public Routine update(Routine routine, Map<Option, ?> options) {
    try {
      return updateSkipExceptionTranslation(routine, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public Routine updateSkipExceptionTranslation(Routine routine, Map<Option, ?> options)
      throws IOException {
    validateRPC();
    RoutineReference reference = routine.getRoutineReference();
    Bigquery.Routines.Update bqUpdateRequest =
        bigquery
            .routines()
            .update(
                reference.getProjectId(),
                reference.getDatasetId(),
                reference.getRoutineId(),
                routine)
            .setPrettyPrint(false)
            .setFields(Option.FIELDS.getString(options));

    Span updateRoutine = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      updateRoutine =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.updateRoutine")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "RoutineService")
              .setAttribute("bq.rpc.method", "UpdateRoutine")
              .setAttribute("bq.rpc.system", "http")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    Routine routineResponse = bqUpdateRequest.execute();
    if (updateRoutine != null) {
      updateRoutine.setAttribute(
          "bq.rpc.response.routine.id", routineResponse.getRoutineReference().getRoutineId());
      updateRoutine.end();
    }
    return routineResponse;
  }

  @Override
  public Routine getRoutine(
      String projectId, String datasetId, String routineId, Map<Option, ?> options) {
    try {
      return getRoutineSkipExceptionTranslation(projectId, datasetId, routineId, options);
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  @InternalApi("internal to java-bigquery")
  public Routine getRoutineSkipExceptionTranslation(
      String projectId, String datasetId, String routineId, Map<Option, ?> options)
      throws IOException {
    validateRPC();
    Bigquery.Routines.Get bqGetRequest =
        bigquery
            .routines()
            .get(projectId, datasetId, routineId)
            .setPrettyPrint(false)
            .setFields(Option.FIELDS.getString(options));

    Span getRoutine = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      getRoutine =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.getRoutine")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "RoutineService")
              .setAttribute("bq.rpc.method", "GetRoutine")
              .setAttribute("bq.rpc.system", "http")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    Routine routineResponse = bqGetRequest.execute();
    if (getRoutine != null) {
      getRoutine.setAttribute(
          "bq.rpc.response.routine.id", routineResponse.getRoutineReference().getRoutineId());
      getRoutine.end();
    }
    return routineResponse;
  }

  @Override
  public Tuple<String, Iterable<Routine>> listRoutines(
      String projectId, String datasetId, Map<Option, ?> options) {
    try {
      return listRoutinesSkipExceptionTranslation(projectId, datasetId, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public Tuple<String, Iterable<Routine>> listRoutinesSkipExceptionTranslation(
      String projectId, String datasetId, Map<Option, ?> options) throws IOException {
    validateRPC();
    Bigquery.Routines.List routineListRequest =
        bigquery
            .routines()
            .list(projectId, datasetId)
            .setPrettyPrint(false)
            .setMaxResults(Option.MAX_RESULTS.getLong(options))
            .setPageToken(Option.PAGE_TOKEN.getString(options));

    Span listRoutines = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      listRoutines =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.listRoutines")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "RoutineService")
              .setAttribute("bq.rpc.method", "ListRoutines")
              .setAttribute("bq.rpc.system", "http")
              .setAttribute("bq.rpc.page_token", routineListRequest.getPageToken())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    ListRoutinesResponse routineResponse = routineListRequest.execute();
    if (listRoutines != null) {
      listRoutines.setAttribute("bq.rpc.next_page_token", routineResponse.getNextPageToken());
      listRoutines.end();
    }
    Iterable<Routine> routines =
        routineResponse.getRoutines() != null
            ? routineResponse.getRoutines()
            : ImmutableList.<Routine>of();
    return Tuple.of(routineResponse.getNextPageToken(), routines);
  }

  @Override
  public boolean deleteRoutine(String projectId, String datasetId, String routineId) {
    try {
      return deleteRoutineSkipExceptionTranslation(projectId, datasetId, routineId);
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  @InternalApi("internal to java-bigquery")
  public boolean deleteRoutineSkipExceptionTranslation(
      String projectId, String datasetId, String routineId) throws IOException {
    validateRPC();
    Bigquery.Routines.Delete bqDeleteRequest =
        bigquery.routines().delete(projectId, datasetId, routineId);

    Span deleteRoutine = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      deleteRoutine =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.listRoutines")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "RoutineService")
              .setAttribute("bq.rpc.method", "ListRoutines")
              .setAttribute("bq.rpc.system", "http")
              .startSpan();
    }
    bqDeleteRequest.execute();
    if (deleteRoutine != null) {
      deleteRoutine.end();
    }
    return true;
  }

  @Override
  public TableDataInsertAllResponse insertAll(
      String projectId, String datasetId, String tableId, TableDataInsertAllRequest request) {
    try {
      return insertAllSkipExceptionTranslation(projectId, datasetId, tableId, request);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public TableDataInsertAllResponse insertAllSkipExceptionTranslation(
      String projectId, String datasetId, String tableId, TableDataInsertAllRequest request)
      throws IOException {
    validateRPC();
    Bigquery.Tabledata.InsertAll insertAllRequest =
        bigquery
            .tabledata()
            .insertAll(projectId, datasetId, tableId, request)
            .setPrettyPrint(false);

    Span insertAll = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      insertAll =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.insertAll")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "TableDataService")
              .setAttribute("bq.rpc.method", "InsertAll")
              .setAttribute("bq.rpc.system", "http")
              .startSpan();
    }
    TableDataInsertAllResponse insertAllResponse = insertAllRequest.execute();
    if (insertAll != null) {
      insertAll.end();
    }
    return insertAllResponse;
  }

  @Override
  public TableDataList listTableData(
      String projectId, String datasetId, String tableId, Map<Option, ?> options) {
    try {
      return listTableDataSkipExceptionTranslation(projectId, datasetId, tableId, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public TableDataList listTableDataSkipExceptionTranslation(
      String projectId, String datasetId, String tableId, Map<Option, ?> options)
      throws IOException {
    validateRPC();
    Bigquery.Tabledata.List bqListRequest =
        bigquery
            .tabledata()
            .list(projectId, datasetId, tableId)
            .setPrettyPrint(false)
            .setMaxResults(Option.MAX_RESULTS.getLong(options))
            .setPageToken(Option.PAGE_TOKEN.getString(options))
            .setStartIndex(
                Option.START_INDEX.getLong(options) != null
                    ? BigInteger.valueOf(Option.START_INDEX.getLong(options))
                    : null);

    Span listTableData = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      listTableData =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.listTableData")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "TableDataService")
              .setAttribute("bq.rpc.method", "List")
              .setAttribute("bq.rpc.system", "http")
              .setAttribute("bq.rpc.page_token", bqListRequest.getPageToken())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    TableDataList bqListResponse = bqListRequest.execute();
    if (listTableData != null) {
      listTableData.end();
    }
    return bqListResponse;
  }

  @Override
  public TableDataList listTableDataWithRowLimit(
      String projectId,
      String datasetId,
      String tableId,
      Integer maxResultPerPage,
      String pageToken) {
    try {
      return listTableDataWithRowLimitSkipExceptionTranslation(
          projectId, datasetId, tableId, maxResultPerPage, pageToken);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public TableDataList listTableDataWithRowLimitSkipExceptionTranslation(
      String projectId,
      String datasetId,
      String tableId,
      Integer maxResultPerPage,
      String pageToken)
      throws IOException {
    validateRPC();
    Bigquery.Tabledata.List bqListRequest =
        bigquery
            .tabledata()
            .list(projectId, datasetId, tableId)
            .setPrettyPrint(false)
            .setMaxResults(Long.valueOf(maxResultPerPage))
            .setPageToken(pageToken);

    Span listTableData = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      listTableData =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.listTableDataWithRowLimit")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "TableDataService")
              .setAttribute("bq.rpc.method", "List")
              .setAttribute("bq.rpc.system", "http")
              .setAttribute("bq.rpc.page_token", bqListRequest.getPageToken())
              .startSpan();
    }
    TableDataList bqListResponse = bqListRequest.execute();
    if (listTableData != null) {
      listTableData.end();
    }
    return bqListResponse;
  }

  @Override
  public Job getJob(String projectId, String jobId, String location, Map<Option, ?> options) {
    try {
      return getJobSkipExceptionTranslation(projectId, jobId, location, options);
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  @InternalApi("internal to java-bigquery")
  public Job getJobSkipExceptionTranslation(
      String projectId, String jobId, String location, Map<Option, ?> options) throws IOException {
    validateRPC();
    Bigquery.Jobs.Get bqGetRequest =
        bigquery
            .jobs()
            .get(projectId, jobId)
            .setPrettyPrint(false)
            .setLocation(location)
            .setFields(Option.FIELDS.getString(options));

    Span getJob = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      getJob =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.getJob")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "JobService")
              .setAttribute("bq.rpc.method", "GetJob")
              .setAttribute("bq.rpc.system", "http")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    Job jobResponse = bqGetRequest.execute();
    if (getJob != null) {
      getJob.setAttribute("bq.rpc.response.job.id", jobResponse.getId());
      getJob.setAttribute("bq.rpc.response.job.status.state", jobResponse.getStatus().getState());
      getJob.end();
    }
    return jobResponse;
  }

  @Override
  public Job getQueryJob(String projectId, String jobId, String location) {
    try {
      return getQueryJobSkipExceptionTranslation(projectId, jobId, location);
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  @InternalApi("internal to java-bigquery")
  public Job getQueryJobSkipExceptionTranslation(String projectId, String jobId, String location)
      throws IOException {
    validateRPC();
    Bigquery.Jobs.Get bqGetRequest =
        bigquery.jobs().get(projectId, jobId).setPrettyPrint(false).setLocation(location);

    Span getJob = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      getJob =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.getQueryJob")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "JobService")
              .setAttribute("bq.rpc.method", "GetJob")
              .setAttribute("bq.rpc.system", "http")
              .startSpan();
    }
    Job jobResponse = bqGetRequest.execute();
    if (getJob != null) {
      getJob.setAttribute("bq.rpc.response.job.id", jobResponse.getId());
      getJob.setAttribute("bq.rpc.response.job.status.state", jobResponse.getStatus().getState());
      getJob.end();
    }
    return jobResponse;
  }

  @Override
  public Tuple<String, Iterable<Job>> listJobs(String projectId, Map<Option, ?> options) {
    try {
      return listJobsSkipExceptionTranslation(projectId, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public Tuple<String, Iterable<Job>> listJobsSkipExceptionTranslation(
      String projectId, Map<Option, ?> options) throws IOException {
    validateRPC();
    Bigquery.Jobs.List request =
        bigquery
            .jobs()
            .list(projectId)
            .setPrettyPrint(false)
            .setAllUsers(Option.ALL_USERS.getBoolean(options))
            .setFields(Option.FIELDS.getString(options))
            .setStateFilter(Option.STATE_FILTER.<List<String>>get(options))
            .setMaxResults(Option.MAX_RESULTS.getLong(options))
            .setPageToken(Option.PAGE_TOKEN.getString(options))
            .setProjection(DEFAULT_PROJECTION)
            .setParentJobId(Option.PARENT_JOB_ID.getString(options));
    if (Option.MIN_CREATION_TIME.getLong(options) != null) {
      request.setMinCreationTime(BigInteger.valueOf(Option.MIN_CREATION_TIME.getLong(options)));
    }
    if (Option.MAX_CREATION_TIME.getLong(options) != null) {
      request.setMaxCreationTime(BigInteger.valueOf(Option.MAX_CREATION_TIME.getLong(options)));
    }

    Span listJobs = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      listJobs =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.listJobs")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "JobService")
              .setAttribute("bq.rpc.method", "ListJobs")
              .setAttribute("bq.rpc.system", "http")
              .setAttribute("bq.rpc.page_token", request.getPageToken())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    JobList jobsList = request.execute();
    if (listJobs != null) {
      listJobs.setAttribute("bq.rpc.next_page_token", jobsList.getNextPageToken());
      listJobs.end();
    }

    Iterable<JobList.Jobs> jobs = jobsList.getJobs();
    return Tuple.of(
        jobsList.getNextPageToken(),
        Iterables.transform(
            jobs != null ? jobs : ImmutableList.<JobList.Jobs>of(),
            new Function<JobList.Jobs, Job>() {
              @Override
              public Job apply(JobList.Jobs jobPb) {
                JobStatus statusPb =
                    jobPb.getStatus() != null ? jobPb.getStatus() : new JobStatus();
                if (statusPb.getState() == null) {
                  statusPb.setState(jobPb.getState());
                }
                if (statusPb.getErrorResult() == null) {
                  statusPb.setErrorResult(jobPb.getErrorResult());
                }
                return new Job()
                    .setConfiguration(jobPb.getConfiguration())
                    .setId(jobPb.getId())
                    .setJobReference(jobPb.getJobReference())
                    .setKind(jobPb.getKind())
                    .setStatistics(jobPb.getStatistics())
                    .setStatus(statusPb)
                    .setUserEmail(jobPb.getUserEmail());
              }
            }));
  }

  @Override
  public boolean cancel(String projectId, String jobId, String location) {
    try {
      return cancelSkipExceptionTranslation(projectId, jobId, location);
    } catch (IOException ex) {
      BigQueryException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  @InternalApi("internal to java-bigquery")
  public boolean cancelSkipExceptionTranslation(String projectId, String jobId, String location)
      throws IOException {
    validateRPC();
    Bigquery.Jobs.Cancel bqCancelRequest =
        bigquery.jobs().cancel(projectId, jobId).setLocation(location).setPrettyPrint(false);

    Span cancelJob = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      cancelJob =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.cancelJob")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "JobService")
              .setAttribute("bq.rpc.method", "CancelJob")
              .setAttribute("bq.rpc.system", "http")
              .startSpan();
    }
    bqCancelRequest.execute();
    if (cancelJob != null) {
      cancelJob.end();
    }
    return true;
  }

  @Override
  public boolean deleteJob(String projectId, String jobName, String location) {
    try {
      return deleteJobSkipExceptionTranslation(projectId, jobName, location);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public boolean deleteJobSkipExceptionTranslation(
      String projectId, String jobName, String location) throws IOException {
    validateRPC();
    Bigquery.Jobs.Delete bqDeleteRequest =
        bigquery.jobs().delete(projectId, jobName).setLocation(location).setPrettyPrint(false);

    Span deleteJob = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      deleteJob =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.deleteJob")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "JobService")
              .setAttribute("bq.rpc.method", "DeleteJob")
              .setAttribute("bq.rpc.system", "http")
              .startSpan();
    }
    bqDeleteRequest.execute();
    if (deleteJob != null) {
      deleteJob.end();
    }
    return true;
  }

  @Override
  public GetQueryResultsResponse getQueryResults(
      String projectId, String jobId, String location, Map<Option, ?> options) {
    try {
      return getQueryResultsSkipExceptionTranslation(projectId, jobId, location, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public GetQueryResultsResponse getQueryResultsSkipExceptionTranslation(
      String projectId, String jobId, String location, Map<Option, ?> options) throws IOException {
    validateRPC();
    Bigquery.Jobs.GetQueryResults queryRequest =
        bigquery
            .jobs()
            .getQueryResults(projectId, jobId)
            .setPrettyPrint(false)
            .setLocation(location)
            .setMaxResults(Option.MAX_RESULTS.getLong(options))
            .setPageToken(Option.PAGE_TOKEN.getString(options))
            .setStartIndex(
                Option.START_INDEX.getLong(options) != null
                    ? BigInteger.valueOf(Option.START_INDEX.getLong(options))
                    : null)
            .setTimeoutMs(Option.TIMEOUT.getLong(options));

    Span getQueryResults = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      getQueryResults =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.getQueryResults")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "JobService")
              .setAttribute("bq.rpc.method", "GetQueryResults")
              .setAttribute("bq.rpc.system", "http")
              .setAttribute("bq.rpc.page_token", queryRequest.getPageToken())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }

    GetQueryResultsResponse queryResponse = queryRequest.execute();
    if (getQueryResults != null) {
      getQueryResults.end();
    }
    return queryResponse;
  }

  @Override
  public GetQueryResultsResponse getQueryResultsWithRowLimit(
      String projectId, String jobId, String location, Integer maxResultPerPage, Long timeoutMs) {
    try {
      return getQueryResultsWithRowLimitSkipExceptionTranslation(
          projectId, jobId, location, maxResultPerPage, timeoutMs);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public GetQueryResultsResponse getQueryResultsWithRowLimitSkipExceptionTranslation(
      String projectId, String jobId, String location, Integer maxResultPerPage, Long timeoutMs)
      throws IOException {
    validateRPC();
    Bigquery.Jobs.GetQueryResults queryRequest =
        bigquery
            .jobs()
            .getQueryResults(projectId, jobId)
            .setPrettyPrint(false)
            .setLocation(location)
            .setMaxResults(Long.valueOf(maxResultPerPage))
            .setTimeoutMs(timeoutMs);

    Span getQueryResults = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      getQueryResults =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.getQueryResultsWithRowLimit")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "JobService")
              .setAttribute("bq.rpc.method", "GetQueryResults")
              .setAttribute("bq.rpc.system", "http")
              .setAttribute("bq.rpc.page_token", queryRequest.getPageToken())
              .startSpan();
    }

    GetQueryResultsResponse queryResponse = queryRequest.execute();
    if (getQueryResults != null) {
      getQueryResults.end();
    }
    return queryResponse;
  }

  @Override
  public QueryResponse queryRpc(String projectId, QueryRequest content) {
    try {
      return queryRpcSkipExceptionTranslation(projectId, content);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public QueryResponse queryRpcSkipExceptionTranslation(String projectId, QueryRequest content)
      throws IOException {
    validateRPC();
    Bigquery.Jobs.Query queryRequest = bigquery.jobs().query(projectId, content);

    Span getQueryResults = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      getQueryResults =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.queryRpc")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "JobService")
              .setAttribute("bq.rpc.method", "Query")
              .setAttribute("bq.rpc.system", "http")
              .startSpan();
    }

    QueryResponse queryResponse = queryRequest.execute();
    if (getQueryResults != null) {
      getQueryResults.end();
    }
    return queryResponse;
  }

  @Override
  public String open(Job loadJob) {
    try {
      return openSkipExceptionTranslation(loadJob);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public String openSkipExceptionTranslation(Job loadJob) throws IOException {
    String builder = options.getResolvedApiaryHost("bigquery");
    if (!builder.endsWith("/")) {
      builder += "/";
    }
    builder += BASE_RESUMABLE_URI + options.getProjectId() + "/jobs";
    GenericUrl url = new GenericUrl(builder);
    url.set("uploadType", "resumable");
    JsonFactory jsonFactory = bigquery.getJsonFactory();
    HttpRequestFactory requestFactory = bigquery.getRequestFactory();
    HttpRequest httpRequest =
        requestFactory.buildPostRequest(url, new JsonHttpContent(jsonFactory, loadJob));
    httpRequest.getHeaders().set("X-Upload-Content-Value", "application/octet-stream");
    HttpResponse response = httpRequest.execute();
    return response.getHeaders().getLocation();
  }

  @Override
  public Job write(
      String uploadId,
      byte[] toWrite,
      int toWriteOffset,
      long destOffset,
      int length,
      boolean last) {
    try {
      return writeSkipExceptionTranslation(
          uploadId, toWrite, toWriteOffset, destOffset, length, last);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public Job writeSkipExceptionTranslation(
      String uploadId, byte[] toWrite, int toWriteOffset, long destOffset, int length, boolean last)
      throws IOException {
    if (length == 0) {
      return null;
    }
    GenericUrl url = new GenericUrl(uploadId);
    HttpRequest httpRequest =
        bigquery
            .getRequestFactory()
            .buildPutRequest(url, new ByteArrayContent(null, toWrite, toWriteOffset, length));
    httpRequest.setParser(bigquery.getObjectParser());
    long limit = destOffset + length;
    StringBuilder range = new StringBuilder("bytes ");
    range.append(destOffset).append('-').append(limit - 1).append('/');
    if (last) {
      range.append(limit);
    } else {
      range.append('*');
    }
    httpRequest.getHeaders().setContentRange(range.toString());
    int code;
    String message;
    IOException exception = null;
    HttpResponse response = null;
    try {
      response = httpRequest.execute();
      code = response.getStatusCode();
      message = response.getStatusMessage();
    } catch (HttpResponseException ex) {
      exception = ex;
      code = ex.getStatusCode();
      message = ex.getStatusMessage();
    }
    if (!last && code != HTTP_RESUME_INCOMPLETE
        || last && !(code == HTTP_OK || code == HTTP_CREATED)) {
      if (exception != null) {
        throw exception;
      }
      throw new BigQueryException(code, message);
    }
    return last && response != null ? response.parseAs(Job.class) : null;
  }

  @Override
  public Policy getIamPolicy(String resourceId, Map<Option, ?> options) {
    try {
      return getIamPolicySkipExceptionTranslation(resourceId, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public Policy getIamPolicySkipExceptionTranslation(String resourceId, Map<Option, ?> options)
      throws IOException {
    validateRPC();
    GetIamPolicyRequest policyRequest = new GetIamPolicyRequest();
    if (null != Option.REQUESTED_POLICY_VERSION.getLong(options)) {
      policyRequest =
          policyRequest.setOptions(
              new GetPolicyOptions()
                  .setRequestedPolicyVersion(
                      Option.REQUESTED_POLICY_VERSION.getLong(options).intValue()));
    }
    Bigquery.Tables.GetIamPolicy bqGetRequest =
        bigquery.tables().getIamPolicy(resourceId, policyRequest).setPrettyPrint(false);

    Span getIamPolicy = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      getIamPolicy =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.getIamPolicy")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "TableService")
              .setAttribute("bq.rpc.method", "GetIamPolicy")
              .setAttribute("bq.rpc.system", "http")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }

    Policy bqGetResponse = bqGetRequest.execute();
    if (getIamPolicy != null) {
      getIamPolicy.end();
    }
    return bqGetResponse;
  }

  @Override
  public Policy setIamPolicy(String resourceId, Policy policy, Map<Option, ?> options) {
    try {
      return setIamPolicySkipExceptionTranslation(resourceId, policy, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @InternalApi("internal to java-bigquery")
  public Policy setIamPolicySkipExceptionTranslation(
      String resourceId, Policy policy, Map<Option, ?> options) throws IOException {
    validateRPC();
    SetIamPolicyRequest policyRequest = new SetIamPolicyRequest().setPolicy(policy);
    Bigquery.Tables.SetIamPolicy bqSetRequest =
        bigquery.tables().setIamPolicy(resourceId, policyRequest).setPrettyPrint(false);

    Span setIamPolicy = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      setIamPolicy =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.setIamPolicy")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "TableService")
              .setAttribute("bq.rpc.method", "SetIamPolicy")
              .setAttribute("bq.rpc.system", "http")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }

    Policy bqSetResponse = bqSetRequest.execute();
    if (setIamPolicy != null) {
      setIamPolicy.end();
    }
    return bqSetResponse;
  }

  @Override
  public TestIamPermissionsResponse testIamPermissions(
      String resourceId, List<String> permissions, Map<Option, ?> options) {
    try {
      return testIamPermissionsSkipExceptionTranslation(resourceId, permissions, options);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  public TestIamPermissionsResponse testIamPermissionsSkipExceptionTranslation(
      String resourceId, List<String> permissions, Map<Option, ?> options) throws IOException {
    validateRPC();
    TestIamPermissionsRequest permissionsRequest =
        new TestIamPermissionsRequest().setPermissions(permissions);
    Bigquery.Tables.TestIamPermissions bqTestRequest =
        bigquery.tables().testIamPermissions(resourceId, permissionsRequest).setPrettyPrint(false);

    Span testIamPermissions = null;
    if (this.options.isOpenTelemetryTracingEnabled()
        && this.options.getOpenTelemetryTracer() != null) {
      testIamPermissions =
          this.options
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQueryRpc.setIamPolicy")
              .setSpanKind(SpanKind.CLIENT)
              .setAttribute("bq.rpc.service", "TableService")
              .setAttribute("bq.rpc.method", "SetIamPolicy")
              .setAttribute("bq.rpc.system", "http")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }

    TestIamPermissionsResponse bqTestResponse = bqTestRequest.execute();
    if (testIamPermissions != null) {
      testIamPermissions.end();
    }
    return bqTestResponse;
  }

  private static Attributes otelAttributesFromOptions(Map<Option, ?> options) {
    Attributes attributes = Attributes.builder().build();
    for (Map.Entry<Option, ?> entry : options.entrySet()) {
      attributes.toBuilder().put(entry.getKey().toString(), entry.getValue().toString());
    }
    return attributes;
  }
}
