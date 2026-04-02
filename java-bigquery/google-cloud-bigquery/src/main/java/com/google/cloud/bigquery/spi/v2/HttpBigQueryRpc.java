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

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
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
import com.google.cloud.bigquery.telemetry.BigQueryTelemetryTracer;
import com.google.cloud.bigquery.telemetry.HttpTracingRequestInitializer;
import com.google.cloud.http.HttpTransportOptions;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.context.Scope;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@InternalExtensionOnly
public class HttpBigQueryRpc implements BigQueryRpc {

  public static final String DEFAULT_PROJECTION = "full";
  private static final String BASE_RESUMABLE_URI = "upload/bigquery/v2/projects/";
  static final String HTTP_TRACING_DEV_GATE_PROPERTY =
      "com.google.cloud.bigquery.http.tracing.dev.enabled";
  static final String RESOURCE_PROJECT_PREFIX = "//bigquery.googleapis.com/projects/";
  // see:
  // https://cloud.google.com/bigquery/loading-data-post-request#resume-upload
  private static final int HTTP_RESUME_INCOMPLETE = 308;
  private final BigQueryOptions options;
  private final Bigquery bigquery;
  private final String urlDomain;

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
    this.urlDomain = new GenericUrl(options.getResolvedApiaryHost("bigquery")).getHost();

    if (options.isOpenTelemetryTracingEnabled()
        && options.getOpenTelemetryTracer() != null
        && isHttpTracingEnabled()) {
      initializer =
          new HttpTracingRequestInitializer(initializer, options.getOpenTelemetryTracer());
    }

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
    bqGetRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/datasets/")
            .append(datasetId)
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.getDataset",
            "DatasetService",
            "GetDataset",
            gcpResourceDestinationId,
            bqGetRequest.getUriTemplate(),
            options),
        span -> {
          Dataset dataset = bqGetRequest.execute();
          if (span != null) {
            span.setAttribute("bq.rpc.response.dataset.id", dataset.getId());
          }
          return dataset;
        });
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

    datasetsListRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/datasets")
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.listDatasets",
            "DatasetService",
            "ListDatasets",
            gcpResourceDestinationId,
            datasetsListRequest.getUriTemplate(),
            options),
        span -> {
          if (span != null) {
            span.setAttribute("bq.rpc.page_token", datasetsListRequest.getPageToken());
          }
          DatasetList datasetsList = datasetsListRequest.execute();
          Iterable<DatasetList.Datasets> datasets = datasetsList.getDatasets();
          if (span != null) {
            span.setAttribute("bq.rpc.next_page_token", datasetsList.getNextPageToken());
          }
          return Tuple.of(
              datasetsList.getNextPageToken(),
              Iterables.transform(
                  datasets != null ? datasets : ImmutableList.<DatasetList.Datasets>of(),
                  LIST_TO_DATASET));
        });
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
    bqCreateRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(dataset.getDatasetReference().getProjectId())
            .append("/datasets/")
            .append(dataset.getDatasetReference().getDatasetId())
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.createDataset",
            "DatasetService",
            "InsertDataset",
            gcpResourceDestinationId,
            bqCreateRequest.getUriTemplate(),
            options),
        span -> {
          Dataset datasetResponse = bqCreateRequest.execute();
          if (span != null) {
            span.setAttribute("bq.rpc.response.dataset.id", datasetResponse.getId());
          }
          return datasetResponse;
        });
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

    bqCreateRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(reference.getProjectId())
            .append("/datasets/")
            .append(reference.getDatasetId())
            .append("/tables/")
            .append(reference.getTableId())
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.createTable",
            "TableService",
            "InsertTable",
            gcpResourceDestinationId,
            bqCreateRequest.getUriTemplate(),
            options),
        span -> {
          Table tableResponse = bqCreateRequest.execute();
          if (span != null) {
            span.setAttribute("bq.rpc.response.table.id", tableResponse.getId());
          }
          return tableResponse;
        });
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

    bqCreateRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(reference.getProjectId())
            .append("/datasets/")
            .append(reference.getDatasetId())
            .append("/routines/")
            .append(reference.getRoutineId())
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.createRoutine",
            "RoutineService",
            "InsertRoutine",
            gcpResourceDestinationId,
            bqCreateRequest.getUriTemplate(),
            options),
        span -> {
          Routine routineResponse = bqCreateRequest.execute();
          if (span != null) {
            span.setAttribute(
                "bq.rpc.response.routine.id", routineResponse.getRoutineReference().getRoutineId());
          }
          return routineResponse;
        });
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

    bqCreateRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/jobs")
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.createJob",
            "JobService",
            "InsertJob",
            gcpResourceDestinationId,
            bqCreateRequest.getUriTemplate(),
            options),
        span -> {
          Job jobResponse = bqCreateRequest.execute();
          if (span != null) {
            span.setAttribute("bq.rpc.response.job.id", jobResponse.getId());
            span.setAttribute(
                "bq.rpc.response.job.status.state", jobResponse.getStatus().getState());
          }
          return jobResponse;
        });
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

    bqCreateRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/jobs")
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.createJobForQuery",
            "JobService",
            "InsertJob",
            gcpResourceDestinationId,
            bqCreateRequest.getUriTemplate(),
            null),
        span -> {
          Job jobResponse = bqCreateRequest.execute();
          if (span != null) {
            span.setAttribute("bq.rpc.response.job.id", jobResponse.getId());
            span.setAttribute(
                "bq.rpc.response.job.status.state", jobResponse.getStatus().getState());
          }
          return jobResponse;
        });
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

    bqDeleteRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/datasets/")
            .append(datasetId)
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.deleteDataset",
            "DatasetService",
            "DeleteDataset",
            gcpResourceDestinationId,
            bqDeleteRequest.getUriTemplate(),
            options),
        span -> {
          bqDeleteRequest.execute();
          return true;
        });
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
    bqPatchRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(reference.getProjectId())
            .append("/datasets/")
            .append(reference.getDatasetId())
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.patchDataset",
            "DatasetService",
            "PatchDataset",
            gcpResourceDestinationId,
            bqPatchRequest.getUriTemplate(),
            options),
        span -> {
          Dataset datasetResponse = bqPatchRequest.execute();
          if (span != null) {
            span.setAttribute("bq.rpc.response.dataset.id", datasetResponse.getId());
          }
          return datasetResponse;
        });
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

    bqPatchRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(reference.getProjectId())
            .append("/datasets/")
            .append(reference.getDatasetId())
            .append("/tables/")
            .append(reference.getTableId())
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.patchTable",
            "TableService",
            "PatchTable",
            gcpResourceDestinationId,
            bqPatchRequest.getUriTemplate(),
            options),
        span -> {
          Table tableResponse = bqPatchRequest.execute();
          if (span != null) {
            span.setAttribute("bq.rpc.response.table.id", tableResponse.getId());
          }
          return tableResponse;
        });
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

    bqGetRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/datasets/")
            .append(datasetId)
            .append("/tables/")
            .append(tableId)
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.getTable",
            "TableService",
            "GetTable",
            gcpResourceDestinationId,
            bqGetRequest.getUriTemplate(),
            options),
        span -> {
          Table tableResponse = bqGetRequest.execute();
          if (span != null) {
            span.setAttribute("bq.rpc.response.table.id", tableResponse.getId());
          }
          return tableResponse;
        });
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

    tableListRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/datasets/")
            .append(datasetId)
            .append("/tables")
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.listTables",
            "TableService",
            "ListTables",
            gcpResourceDestinationId,
            tableListRequest.getUriTemplate(),
            options),
        span -> {
          if (span != null) {
            span.setAttribute("bq.rpc.page_token", tableListRequest.getPageToken());
          }
          TableList tableResponse = tableListRequest.execute();
          if (span != null) {
            span.setAttribute("bq.rpc.next_page_token", tableResponse.getNextPageToken());
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
        });
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

    bqDeleteRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/datasets/")
            .append(datasetId)
            .append("/tables/")
            .append(tableId)
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.deleteTable",
            "TableService",
            "DeleteTable",
            gcpResourceDestinationId,
            bqDeleteRequest.getUriTemplate(),
            null),
        span -> {
          bqDeleteRequest.execute();
          return true;
        });
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

    bqPatchRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(reference.getProjectId())
            .append("/datasets/")
            .append(reference.getDatasetId())
            .append("/models/")
            .append(reference.getModelId())
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.patchModel",
            "ModelService",
            "PatchModel",
            gcpResourceDestinationId,
            bqPatchRequest.getUriTemplate(),
            options),
        span -> {
          Model modelResponse = bqPatchRequest.execute();
          if (span != null) {
            span.setAttribute(
                "bq.rpc.response.model.id", modelResponse.getModelReference().getModelId());
          }
          return modelResponse;
        });
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

    bqGetRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/datasets/")
            .append(datasetId)
            .append("/models/")
            .append(modelId)
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.getModel",
            "ModelService",
            "GetModel",
            gcpResourceDestinationId,
            bqGetRequest.getUriTemplate(),
            options),
        span -> {
          Model modelResponse = bqGetRequest.execute();
          if (span != null) {
            span.setAttribute(
                "bq.rpc.response.model.id", modelResponse.getModelReference().getModelId());
          }
          return modelResponse;
        });
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

    modelListRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/datasets/")
            .append(datasetId)
            .append("/models")
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.listModels",
            "ModelService",
            "ListModels",
            gcpResourceDestinationId,
            modelListRequest.getUriTemplate(),
            options),
        span -> {
          if (span != null) {
            span.setAttribute("bq.rpc.page_token", modelListRequest.getPageToken());
          }
          ListModelsResponse modelResponse = modelListRequest.execute();
          if (span != null) {
            span.setAttribute("bq.rpc.next_page_token", modelResponse.getNextPageToken());
          }

          Iterable<Model> models =
              modelResponse.getModels() != null
                  ? modelResponse.getModels()
                  : ImmutableList.<Model>of();
          return Tuple.of(modelResponse.getNextPageToken(), models);
        });
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

    bqDeleteRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/datasets/")
            .append(datasetId)
            .append("/models/")
            .append(modelId)
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.deleteModel",
            "ModelService",
            "DeleteModel",
            gcpResourceDestinationId,
            bqDeleteRequest.getUriTemplate(),
            null),
        span -> {
          bqDeleteRequest.execute();
          return true;
        });
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

    bqUpdateRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(reference.getProjectId())
            .append("/datasets/")
            .append(reference.getDatasetId())
            .append("/routines/")
            .append(reference.getRoutineId())
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.updateRoutine",
            "RoutineService",
            "UpdateRoutine",
            gcpResourceDestinationId,
            bqUpdateRequest.getUriTemplate(),
            options),
        span -> {
          Routine routineResponse = bqUpdateRequest.execute();
          if (span != null) {
            span.setAttribute(
                "bq.rpc.response.routine.id", routineResponse.getRoutineReference().getRoutineId());
          }
          return routineResponse;
        });
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

    bqGetRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/datasets/")
            .append(datasetId)
            .append("/routines/")
            .append(routineId)
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.getRoutine",
            "RoutineService",
            "GetRoutine",
            gcpResourceDestinationId,
            bqGetRequest.getUriTemplate(),
            options),
        span -> {
          Routine routineResponse = bqGetRequest.execute();
          if (span != null) {
            span.setAttribute(
                "bq.rpc.response.routine.id", routineResponse.getRoutineReference().getRoutineId());
          }
          return routineResponse;
        });
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

    routineListRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/datasets/")
            .append(datasetId)
            .append("/routines")
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.listRoutines",
            "RoutineService",
            "ListRoutines",
            gcpResourceDestinationId,
            routineListRequest.getUriTemplate(),
            options),
        span -> {
          if (span != null) {
            span.setAttribute("bq.rpc.page_token", routineListRequest.getPageToken());
          }
          ListRoutinesResponse routineResponse = routineListRequest.execute();
          if (span != null) {
            span.setAttribute("bq.rpc.next_page_token", routineResponse.getNextPageToken());
          }
          Iterable<Routine> routines =
              routineResponse.getRoutines() != null
                  ? routineResponse.getRoutines()
                  : ImmutableList.<Routine>of();
          return Tuple.of(routineResponse.getNextPageToken(), routines);
        });
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

    bqDeleteRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/datasets/")
            .append(datasetId)
            .append("/routines/")
            .append(routineId)
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.deleteRoutine",
            "RoutineService",
            "DeleteRoutine",
            gcpResourceDestinationId,
            bqDeleteRequest.getUriTemplate(),
            null),
        span -> {
          bqDeleteRequest.execute();
          return true;
        });
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

    insertAllRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/datasets/")
            .append(datasetId)
            .append("/tables/")
            .append(tableId)
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.insertAll",
            "TableDataService",
            "InsertAll",
            gcpResourceDestinationId,
            insertAllRequest.getUriTemplate(),
            null),
        span -> insertAllRequest.execute());
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

    bqListRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/datasets/")
            .append(datasetId)
            .append("/tables/")
            .append(tableId)
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.listTableData",
            "TableDataService",
            "List",
            gcpResourceDestinationId,
            bqListRequest.getUriTemplate(),
            options),
        span -> {
          if (span != null) {
            span.setAttribute("bq.rpc.page_token", bqListRequest.getPageToken());
          }
          return bqListRequest.execute();
        });
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

    bqListRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/datasets/")
            .append(datasetId)
            .append("/tables/")
            .append(tableId)
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.listTableDataWithRowLimit",
            "TableDataService",
            "List",
            gcpResourceDestinationId,
            bqListRequest.getUriTemplate(),
            null),
        span -> {
          if (span != null) {
            span.setAttribute("bq.rpc.page_token", bqListRequest.getPageToken());
          }
          return bqListRequest.execute();
        });
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

    bqGetRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/jobs/")
            .append(jobId)
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.getJob",
            "JobService",
            "GetJob",
            gcpResourceDestinationId,
            bqGetRequest.getUriTemplate(),
            options),
        span -> {
          Job jobResponse = bqGetRequest.execute();
          if (span != null) {
            span.setAttribute("bq.rpc.response.job.id", jobResponse.getId());
            span.setAttribute(
                "bq.rpc.response.job.status.state", jobResponse.getStatus().getState());
          }
          return jobResponse;
        });
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

    bqGetRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/jobs/")
            .append(jobId)
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.getQueryJob",
            "JobService",
            "GetJob",
            gcpResourceDestinationId,
            bqGetRequest.getUriTemplate(),
            null),
        span -> {
          Job jobResponse = bqGetRequest.execute();
          if (span != null) {
            span.setAttribute("bq.rpc.response.job.id", jobResponse.getId());
            span.setAttribute(
                "bq.rpc.response.job.status.state", jobResponse.getStatus().getState());
          }
          return jobResponse;
        });
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
    Bigquery.Jobs.List listJobsRequest =
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
      listJobsRequest.setMinCreationTime(
          BigInteger.valueOf(Option.MIN_CREATION_TIME.getLong(options)));
    }
    if (Option.MAX_CREATION_TIME.getLong(options) != null) {
      listJobsRequest.setMaxCreationTime(
          BigInteger.valueOf(Option.MAX_CREATION_TIME.getLong(options)));
    }
    listJobsRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/jobs")
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.listJobs",
            "JobService",
            "ListJobs",
            gcpResourceDestinationId,
            listJobsRequest.getUriTemplate(),
            options),
        span -> {
          if (span != null) {
            span.setAttribute("bq.rpc.page_token", listJobsRequest.getPageToken());
          }
          JobList jobsList = listJobsRequest.execute();
          if (span != null) {
            span.setAttribute("bq.rpc.next_page_token", jobsList.getNextPageToken());
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
        });
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

    bqCancelRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/jobs/")
            .append(jobId)
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.cancelJob",
            "JobService",
            "CancelJob",
            gcpResourceDestinationId,
            bqCancelRequest.getUriTemplate(),
            null),
        span -> {
          bqCancelRequest.execute();
          return true;
        });
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

    bqDeleteRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/jobs/")
            .append(jobName)
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.deleteJob",
            "JobService",
            "DeleteJob",
            gcpResourceDestinationId,
            bqDeleteRequest.getUriTemplate(),
            null),
        span -> {
          bqDeleteRequest.execute();
          return true;
        });
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

    queryRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/jobs/")
            .append(jobId)
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.getQueryResults",
            "JobService",
            "GetQueryResults",
            gcpResourceDestinationId,
            queryRequest.getUriTemplate(),
            options),
        span -> {
          if (span != null) {
            span.setAttribute("bq.rpc.page_token", queryRequest.getPageToken());
          }
          return queryRequest.execute();
        });
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

    queryRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/jobs/")
            .append(jobId)
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.getQueryResultsWithRowLimit",
            "JobService",
            "GetQueryResults",
            gcpResourceDestinationId,
            queryRequest.getUriTemplate(),
            null),
        span -> {
          if (span != null) {
            span.setAttribute("bq.rpc.page_token", queryRequest.getPageToken());
          }
          return queryRequest.execute();
        });
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
    queryRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder()
            .append(RESOURCE_PROJECT_PREFIX)
            .append(projectId)
            .append("/jobs")
            .toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.queryRpc",
            "JobService",
            "Query",
            gcpResourceDestinationId,
            queryRequest.getUriTemplate(),
            null),
        span -> {
          return queryRequest.execute();
        });
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

    bqGetRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder().append("//bigquery.googleapis.com/").append(resourceId).toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.getIamPolicy",
            "TableService",
            "GetIamPolicy",
            gcpResourceDestinationId,
            bqGetRequest.getUriTemplate(),
            options),
        span -> {
          return bqGetRequest.execute();
        });
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

    bqSetRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder().append("//bigquery.googleapis.com/").append(resourceId).toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.setIamPolicy",
            "TableService",
            "SetIamPolicy",
            gcpResourceDestinationId,
            bqSetRequest.getUriTemplate(),
            options),
        span -> {
          return bqSetRequest.execute();
        });
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

    bqTestRequest
        .getRequestHeaders()
        .set("x-goog-otel-enabled", this.options.isOpenTelemetryTracingEnabled());

    String gcpResourceDestinationId =
        new StringBuilder().append("//bigquery.googleapis.com/").append(resourceId).toString();

    return executeWithSpan(
        createRpcTracingSpan(
            "com.google.cloud.bigquery.BigQueryRpc.testIamPermissions",
            "TableService",
            "TestIamPermissions",
            gcpResourceDestinationId,
            bqTestRequest.getUriTemplate(),
            options),
        span -> {
          return bqTestRequest.execute();
        });
  }

  /**
   * Helper method to create an OpenTelemetry tracer span with common rpc trace attributes.
   *
   * <p>If isOpenTelemetryTracingEnabled == true creates and returns span, otherwise returns null.
   */
  private Span createRpcTracingSpan(
      String spanName,
      String service,
      String method,
      String gcpResourceDestinationId,
      String urlTemplate,
      Map<Option, ?> options) {
    if (!this.options.isOpenTelemetryTracingEnabled()
        || this.options.getOpenTelemetryTracer() == null) {
      return null;
    }

    SpanBuilder builder =
        this.options
            .getOpenTelemetryTracer()
            .spanBuilder(spanName)
            .setSpanKind(SpanKind.CLIENT)
            .setAttribute("bq.rpc.service", service)
            .setAttribute("bq.rpc.method", method)
            .setAttribute("bq.rpc.system", "http");
    if (isHttpTracingEnabled()) {
      builder
          .setAttribute(
              BigQueryTelemetryTracer.GCP_RESOURCE_DESTINATION_ID, gcpResourceDestinationId)
          .setAttribute(BigQueryTelemetryTracer.URL_TEMPLATE, urlTemplate)
          .setAttribute(BigQueryTelemetryTracer.URL_DOMAIN, this.urlDomain);
    }

    if (options != null) {
      builder.setAllAttributes(otelAttributesFromOptions(options));
    }

    return builder.startSpan();
  }

  /**
   * Helper method to execute an operation with OpenTelemetry tracer span wrapping the execute
   * command if span is not NULL.
   *
   * <p>This function manages scope lifecycle.
   */
  private <T> T executeWithSpan(Span span, SpanOperation<T> operation) throws IOException {
    if (span == null) {
      return operation.execute(null);
    }
    try (Scope scope = span.makeCurrent()) {
      return operation.execute(span);
    } catch (Exception e) {
      if (isHttpTracingEnabled()) {
        if (e instanceof GoogleJsonResponseException) {
          BigQueryTelemetryTracer.addServerErrorResponseToSpan(
              ((GoogleJsonResponseException) e), span);
        } else {
          BigQueryTelemetryTracer.addExceptionToSpan(e, span);
        }
      }
      throw e;
    } finally {
      span.end();
    }
  }

  /** Functional interface for span operations that can throw IOException. */
  @FunctionalInterface
  private interface SpanOperation<T> {
    T execute(Span span) throws IOException;
  }

  private static Attributes otelAttributesFromOptions(Map<Option, ?> options) {
    AttributesBuilder builder = Attributes.builder();
    for (Map.Entry<Option, ?> entry : options.entrySet()) {
      builder.put(entry.getKey().toString(), entry.getValue().toString());
    }
    return builder.build();
  }

  /**
   * Temporary development gate for HttpTracingRequestInitializer rollout: must be explicitly
   * enabled with the system property. tracking ticket for removal:
   * https://github.com/googleapis/google-cloud-java/issues/12100
   */
  static boolean isHttpTracingEnabled() {
    return Boolean.parseBoolean(System.getProperty(HTTP_TRACING_DEV_GATE_PROPERTY));
  }
}
