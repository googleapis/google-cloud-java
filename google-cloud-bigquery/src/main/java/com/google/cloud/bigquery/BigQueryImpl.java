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
package com.google.cloud.bigquery;

import static com.google.cloud.bigquery.PolicyHelper.convertFromApiPolicy;
import static com.google.cloud.bigquery.PolicyHelper.convertToApiPolicy;
import static com.google.common.base.Preconditions.checkArgument;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.paging.Page;
import com.google.api.services.bigquery.model.ErrorProto;
import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.google.api.services.bigquery.model.QueryRequest;
import com.google.api.services.bigquery.model.TableDataInsertAllRequest;
import com.google.api.services.bigquery.model.TableDataInsertAllRequest.Rows;
import com.google.api.services.bigquery.model.TableDataInsertAllResponse;
import com.google.api.services.bigquery.model.TableDataList;
import com.google.api.services.bigquery.model.TableRow;
import com.google.api.services.bigquery.model.TableSchema;
import com.google.cloud.BaseService;
import com.google.cloud.PageImpl;
import com.google.cloud.PageImpl.NextPageFetcher;
import com.google.cloud.Policy;
import com.google.cloud.RetryOption;
import com.google.cloud.Tuple;
import com.google.cloud.bigquery.BigQueryRetryHelper.BigQueryRetryHelperException;
import com.google.cloud.bigquery.InsertAllRequest.RowToInsert;
import com.google.cloud.bigquery.spi.v2.BigQueryRpc;
import com.google.cloud.bigquery.spi.v2.HttpBigQueryRpc;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Scope;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.NonNull;

final class BigQueryImpl extends BaseService<BigQueryOptions> implements BigQuery {

  private static class DatasetPageFetcher implements NextPageFetcher<Dataset> {

    private static final long serialVersionUID = -3057564042439021278L;
    private final Map<BigQueryRpc.Option, ?> requestOptions;
    private final BigQueryOptions serviceOptions;
    private final String projectId;

    DatasetPageFetcher(
        String projectId,
        BigQueryOptions serviceOptions,
        String cursor,
        Map<BigQueryRpc.Option, ?> optionMap) {
      this.projectId = projectId;
      this.requestOptions =
          PageImpl.nextRequestOptions(BigQueryRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Dataset> getNextPage() {
      return listDatasets(projectId, serviceOptions, requestOptions);
    }
  }

  private static class TablePageFetcher implements NextPageFetcher<Table> {

    private static final long serialVersionUID = 8611248840504201187L;
    private final Map<BigQueryRpc.Option, ?> requestOptions;
    private final BigQueryOptions serviceOptions;
    private final DatasetId datasetId;

    TablePageFetcher(
        DatasetId datasetId,
        BigQueryOptions serviceOptions,
        String cursor,
        Map<BigQueryRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(BigQueryRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.datasetId = datasetId;
    }

    @Override
    public Page<Table> getNextPage() {
      return listTables(datasetId, serviceOptions, requestOptions);
    }
  }

  private static class ModelPageFetcher implements NextPageFetcher<Model> {

    private static final long serialVersionUID = 8611248811504201187L;
    private final Map<BigQueryRpc.Option, ?> requestOptions;
    private final BigQueryOptions serviceOptions;
    private final DatasetId datasetId;

    ModelPageFetcher(
        DatasetId datasetId,
        BigQueryOptions serviceOptions,
        String cursor,
        Map<BigQueryRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(BigQueryRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.datasetId = datasetId;
    }

    @Override
    public Page<Model> getNextPage() {
      return listModels(datasetId, serviceOptions, requestOptions);
    }
  }

  private static class RoutinePageFetcher implements NextPageFetcher<Routine> {

    private static final long serialVersionUID = 8611242311504201187L;
    private final Map<BigQueryRpc.Option, ?> requestOptions;
    private final BigQueryOptions serviceOptions;
    private final DatasetId datasetId;

    RoutinePageFetcher(
        DatasetId datasetId,
        BigQueryOptions serviceOptions,
        String cursor,
        Map<BigQueryRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(BigQueryRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.datasetId = datasetId;
    }

    @Override
    public Page<Routine> getNextPage() {
      return listRoutines(datasetId, serviceOptions, requestOptions);
    }
  }

  private static class JobPageFetcher implements NextPageFetcher<Job> {

    private static final long serialVersionUID = 8536533282558245472L;
    private final Map<BigQueryRpc.Option, ?> requestOptions;
    private final BigQueryOptions serviceOptions;

    JobPageFetcher(
        BigQueryOptions serviceOptions, String cursor, Map<BigQueryRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(BigQueryRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Job> getNextPage() {
      return listJobs(serviceOptions, requestOptions);
    }
  }

  private static class TableDataPageFetcher implements NextPageFetcher<FieldValueList> {

    private static final long serialVersionUID = -8501991114794410114L;
    private final Map<BigQueryRpc.Option, ?> requestOptions;
    private final BigQueryOptions serviceOptions;
    private final TableId table;
    private final Schema schema;

    TableDataPageFetcher(
        TableId table,
        Schema schema,
        BigQueryOptions serviceOptions,
        String cursor,
        Map<BigQueryRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(BigQueryRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.table = table;
      this.schema = schema;
    }

    @Override
    public Page<FieldValueList> getNextPage() {
      return listTableData(table, schema, serviceOptions, requestOptions).x();
    }
  }

  private class QueryPageFetcher extends Thread implements NextPageFetcher<FieldValueList> {

    private static final long serialVersionUID = -8501991114794410114L;
    private final Map<BigQueryRpc.Option, ?> requestOptions;
    private final BigQueryOptions serviceOptions;
    private Job job;
    private final TableId table;
    private final Schema schema;

    QueryPageFetcher(
        JobId jobId,
        Schema schema,
        BigQueryOptions serviceOptions,
        String cursor,
        Map<BigQueryRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(BigQueryRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.job = getJob(jobId);
      this.table = ((QueryJobConfiguration) job.getConfiguration()).getDestinationTable();
      this.schema = schema;
    }

    @Override
    public Page<FieldValueList> getNextPage() {
      while (!JobStatus.State.DONE.equals(job.getStatus().getState())) {
        try {
          sleep(5000);
        } catch (InterruptedException ex) {
          throw new RuntimeException(ex.getMessage());
        }
        job = job.reload();
      }
      return listTableData(table, schema, serviceOptions, requestOptions).x();
    }
  }

  private final HttpBigQueryRpc bigQueryRpc;

  private static final BigQueryRetryConfig EMPTY_RETRY_CONFIG =
      BigQueryRetryConfig.newBuilder().build();

  private static final BigQueryRetryConfig DEFAULT_RETRY_CONFIG =
      BigQueryRetryConfig.newBuilder()
          .retryOnMessage(BigQueryErrorMessages.RATE_LIMIT_EXCEEDED_MSG)
          .retryOnMessage(BigQueryErrorMessages.JOB_RATE_LIMIT_EXCEEDED_MSG)
          .retryOnRegEx(BigQueryErrorMessages.RetryRegExPatterns.RATE_LIMIT_EXCEEDED_REGEX)
          .build(); // retry config with Error Messages and RegEx for RateLimitExceeded Error

  BigQueryImpl(BigQueryOptions options) {
    super(options);
    bigQueryRpc = options.getBigQueryRpcV2();
  }

  @Override
  public Dataset create(DatasetInfo datasetInfo, DatasetOption... options) {
    final com.google.api.services.bigquery.model.Dataset datasetPb =
        datasetInfo
            .setProjectId(
                Strings.isNullOrEmpty(datasetInfo.getDatasetId().getProject())
                    ? getOptions().getProjectId()
                    : datasetInfo.getDatasetId().getProject())
            .toPb();
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    Span datasetCreate = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      datasetCreate =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.createDataset")
              .setAllAttributes(datasetInfo.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope datasetCreateScope = datasetCreate != null ? datasetCreate.makeCurrent() : null) {
      return Dataset.fromPb(
          this,
          BigQueryRetryHelper.runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Dataset>() {
                @Override
                public com.google.api.services.bigquery.model.Dataset call() throws IOException {
                  return bigQueryRpc.createSkipExceptionTranslation(datasetPb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock(),
              EMPTY_RETRY_CONFIG));
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (datasetCreate != null) {
        datasetCreate.end();
      }
    }
  }

  @Override
  public Table create(TableInfo tableInfo, TableOption... options) {
    final com.google.api.services.bigquery.model.Table tablePb =
        tableInfo
            .setProjectId(
                Strings.isNullOrEmpty(tableInfo.getTableId().getProject())
                    ? getOptions().getProjectId()
                    : tableInfo.getTableId().getProject())
            .toPb();
    handleExternalTableSchema(tablePb);
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    Span tableCreate = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      tableCreate =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.createTable")
              .setAllAttributes(tableInfo.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope tableCreateScope = tableCreate != null ? tableCreate.makeCurrent() : null) {
      return Table.fromPb(
          this,
          BigQueryRetryHelper.runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Table>() {
                @Override
                public com.google.api.services.bigquery.model.Table call() throws IOException {
                  return bigQueryRpc.createSkipExceptionTranslation(tablePb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock(),
              EMPTY_RETRY_CONFIG));
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (tableCreate != null) {
        tableCreate.end();
      }
    }
  }

  private void handleExternalTableSchema(
      final com.google.api.services.bigquery.model.Table tablePb) {
    // Set schema on the Table for permanent external table
    if (tablePb.getExternalDataConfiguration() != null) {
      tablePb.setSchema(tablePb.getExternalDataConfiguration().getSchema());
      // clear table schema on ExternalDataConfiguration
      tablePb.getExternalDataConfiguration().setSchema(null);
    }
  }

  @Override
  public Routine create(RoutineInfo routineInfo, RoutineOption... options) {
    final com.google.api.services.bigquery.model.Routine routinePb =
        routineInfo
            .setProjectId(
                Strings.isNullOrEmpty(routineInfo.getRoutineId().getProject())
                    ? getOptions().getProjectId()
                    : routineInfo.getRoutineId().getProject())
            .toPb();
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    Span routineCreate = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      routineCreate =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.createRoutine")
              .setAllAttributes(routineInfo.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope createRoutineScope = routineCreate != null ? routineCreate.makeCurrent() : null) {
      return Routine.fromPb(
          this,
          BigQueryRetryHelper.runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Routine>() {
                @Override
                public com.google.api.services.bigquery.model.Routine call() throws IOException {
                  return bigQueryRpc.createSkipExceptionTranslation(routinePb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock(),
              EMPTY_RETRY_CONFIG));
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (routineCreate != null) {
        routineCreate.end();
      }
    }
  }

  @Override
  public Job create(JobInfo jobInfo, JobOption... options) {
    Supplier<JobId> idProvider =
        new Supplier<JobId>() {
          @Override
          public JobId get() {
            return JobId.of();
          }
        };
    return create(jobInfo, idProvider, options);
  }

  @Override
  @BetaApi
  public Connection createConnection(@NonNull ConnectionSettings connectionSettings)
      throws BigQueryException {
    return new ConnectionImpl(connectionSettings, getOptions(), bigQueryRpc, DEFAULT_RETRY_CONFIG);
  }

  @Override
  @BetaApi
  public Connection createConnection() throws BigQueryException {
    ConnectionSettings defaultConnectionSettings = ConnectionSettings.newBuilder().build();
    return new ConnectionImpl(
        defaultConnectionSettings, getOptions(), bigQueryRpc, DEFAULT_RETRY_CONFIG);
  }

  @InternalApi("visible for testing")
  Job create(JobInfo jobInfo, Supplier<JobId> idProvider, JobOption... options) {
    final boolean idRandom = (jobInfo.getJobId() == null);

    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    Span jobCreate = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      jobCreate =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.createJob")
              .setAllAttributes(jobInfo.getJobId().getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    BigQueryException createException;
    // NOTE(pongad): This double-try structure is admittedly odd.
    // translateAndThrow itself throws, and pretends to return an exception only
    // so users can pretend to throw.
    // This makes it difficult to translate without throwing.
    // Fixing this entails some work on BaseServiceException.translate.
    // Since that affects a bunch of APIs, we should fix this as a separate change.
    final JobId[] finalJobId = new JobId[1];
    try (Scope jobCreateScope = jobCreate != null ? jobCreate.makeCurrent() : null) {
      try {
        try {
          return Job.fromPb(
              this,
              BigQueryRetryHelper.runWithRetries(
                  new Callable<com.google.api.services.bigquery.model.Job>() {
                    @Override
                    public com.google.api.services.bigquery.model.Job call() throws IOException {
                      if (idRandom) {
                        // re-generate a new random job with the same jobInfo when jobId is not
                        // provided by the user
                        JobInfo recreatedJobInfo =
                            jobInfo.toBuilder().setJobId(idProvider.get()).build();
                        com.google.api.services.bigquery.model.Job newJobPb =
                            recreatedJobInfo.setProjectId(getOptions().getProjectId()).toPb();
                        finalJobId[0] = recreatedJobInfo.getJobId();
                        return bigQueryRpc.createSkipExceptionTranslation(newJobPb, optionsMap);
                      } else {
                        com.google.api.services.bigquery.model.Job jobPb =
                            jobInfo.setProjectId(getOptions().getProjectId()).toPb();
                        return bigQueryRpc.createSkipExceptionTranslation(jobPb, optionsMap);
                      }
                    }
                  },
                  getRetryOptions(optionsMap) != null
                      ? RetryOption.mergeToSettings(
                          getOptions().getRetrySettings(), getRetryOptions(optionsMap))
                      : getOptions().getRetrySettings(),
                  BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
                  getOptions().getClock(),
                  getBigQueryRetryConfig(optionsMap) != null
                      ? getBigQueryRetryConfig(optionsMap)
                      : DEFAULT_RETRY_CONFIG));
        } catch (BigQueryRetryHelperException e) {
          throw BigQueryException.translateAndThrow(e);
        }
      } catch (BigQueryException e) {
        createException = e;
      }

      if (!idRandom) {
        if (createException instanceof BigQueryException
            && createException.getCause() != null
            && createException.getCause().getMessage() != null) {

          Pattern pattern = Pattern.compile(".*Already.*Exists:.*Job.*", Pattern.CASE_INSENSITIVE);
          Matcher matcher = pattern.matcher(createException.getCause().getMessage());

          if (matcher.find()) {
            // If the Job ALREADY EXISTS, retrieve it.
            Job job = this.getJob(jobInfo.getJobId(), JobOption.fields(JobField.STATISTICS));

            long jobCreationTime = job.getStatistics().getCreationTime();
            long jobMinStaleTime = System.currentTimeMillis();
            long jobMaxStaleTime =
                java.time.Instant.ofEpochMilli(jobMinStaleTime)
                    .minus(1, java.time.temporal.ChronoUnit.DAYS)
                    .toEpochMilli();

            // Only return the job if it has been created in the past 24 hours.
            // This is assuming any job older than 24 hours is a valid duplicate JobID
            // and not a false positive like b/290419183
            if (jobCreationTime >= jobMaxStaleTime && jobCreationTime <= jobMinStaleTime) {
              return job;
            }
          }
        }
        throw createException;
      }

      // If create RPC fails, it's still possible that the job has been successfully
      // created, and get might work.
      // We can only do this if we randomly generated the ID. Otherwise we might
      // mistakenly fetch a job created by someone else.
      Job job;
      try {
        job = getJob(finalJobId[0]);
      } catch (BigQueryException e) {
        throw createException;
      }
      if (job == null) {
        throw createException;
      }
      return job;
    } finally {
      if (jobCreate != null) {
        jobCreate.end();
      }
    }
  }

  @Override
  public Dataset getDataset(String datasetId, DatasetOption... options) {
    return getDataset(DatasetId.of(datasetId), options);
  }

  @Override
  public Dataset getDataset(final DatasetId datasetId, DatasetOption... options) {
    final DatasetId completeDatasetId = datasetId.setProjectId(getOptions().getProjectId());
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    Span datasetGet = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      datasetGet =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.getDataset")
              .setAllAttributes(completeDatasetId.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope datasetGetScope = datasetGet != null ? datasetGet.makeCurrent() : null) {
      com.google.api.services.bigquery.model.Dataset answer =
          BigQueryRetryHelper.runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Dataset>() {
                @Override
                public com.google.api.services.bigquery.model.Dataset call() throws IOException {
                  return bigQueryRpc.getDatasetSkipExceptionTranslation(
                      completeDatasetId.getProject(), completeDatasetId.getDataset(), optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock(),
              EMPTY_RETRY_CONFIG);
      return Dataset.fromPb(this, answer);
    } catch (BigQueryRetryHelperException e) {
      if (isRetryErrorCodeHttpNotFound(e)) {
        if (getOptions().getThrowNotFound()) {
          throw new BigQueryException(HTTP_NOT_FOUND, "Dataset not found");
        }
        return null;
      }
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (datasetGet != null) {
        datasetGet.end();
      }
    }
  }

  @Override
  public Page<Dataset> listDatasets(DatasetListOption... options) {
    return listDatasets(getOptions().getProjectId(), options);
  }

  @Override
  public Page<Dataset> listDatasets(String projectId, DatasetListOption... options) {
    Span datasetsList = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      datasetsList =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.listDatasets")
              .setAttribute("bq.dataset.project_id", projectId)
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope datasetsListScope = datasetsList != null ? datasetsList.makeCurrent() : null) {
      return listDatasets(projectId, getOptions(), optionMap(options));
    } finally {
      if (datasetsList != null) {
        datasetsList.end();
      }
    }
  }

  private static Page<Dataset> listDatasets(
      final String projectId,
      final BigQueryOptions serviceOptions,
      final Map<BigQueryRpc.Option, ?> optionsMap) {
    try {
      Tuple<String, Iterable<com.google.api.services.bigquery.model.Dataset>> result =
          BigQueryRetryHelper.runWithRetries(
              new Callable<
                  Tuple<String, Iterable<com.google.api.services.bigquery.model.Dataset>>>() {
                @Override
                public Tuple<String, Iterable<com.google.api.services.bigquery.model.Dataset>>
                    call() throws IOException {
                  return serviceOptions
                      .getBigQueryRpcV2()
                      .listDatasetsSkipExceptionTranslation(projectId, optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              serviceOptions.getClock(),
              EMPTY_RETRY_CONFIG);
      String cursor = result.x();
      return new PageImpl<>(
          new DatasetPageFetcher(projectId, serviceOptions, cursor, optionsMap),
          cursor,
          Iterables.transform(
              result.y(),
              new Function<com.google.api.services.bigquery.model.Dataset, Dataset>() {
                @Override
                public Dataset apply(com.google.api.services.bigquery.model.Dataset dataset) {
                  return Dataset.fromPb(serviceOptions.getService(), dataset);
                }
              }));
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public boolean delete(String datasetId, DatasetDeleteOption... options) {
    return delete(DatasetId.of(datasetId), options);
  }

  @Override
  public boolean delete(DatasetId datasetId, DatasetDeleteOption... options) {
    final DatasetId completeDatasetId = datasetId.setProjectId(getOptions().getProjectId());
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    Span datasetDelete = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      datasetDelete =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.deleteDataset")
              .setAllAttributes(datasetId.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope datasetDeleteScope = datasetDelete != null ? datasetDelete.makeCurrent() : null) {
      return BigQueryRetryHelper.runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() throws IOException {
              return bigQueryRpc.deleteDatasetSkipExceptionTranslation(
                  completeDatasetId.getProject(), completeDatasetId.getDataset(), optionsMap);
            }
          },
          getOptions().getRetrySettings(),
          BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
          getOptions().getClock(),
          EMPTY_RETRY_CONFIG);
    } catch (BigQueryRetryHelperException e) {
      if (isRetryErrorCodeHttpNotFound(e)) {
        return false;
      }
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (datasetDelete != null) {
        datasetDelete.end();
      }
    }
  }

  @Override
  public boolean delete(String datasetId, String tableId) {
    return delete(TableId.of(datasetId, tableId));
  }

  @Override
  public boolean delete(TableId tableId) {
    final TableId completeTableId =
        tableId.setProjectId(
            Strings.isNullOrEmpty(tableId.getProject())
                ? getOptions().getProjectId()
                : tableId.getProject());
    Span tableDelete = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      tableDelete =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.deleteTable")
              .setAllAttributes(tableId.getOtelAttributes())
              .startSpan();
    }
    try (Scope tableDeleteScope = tableDelete != null ? tableDelete.makeCurrent() : null) {
      return BigQueryRetryHelper.runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() throws IOException {
              return bigQueryRpc.deleteTableSkipExceptionTranslation(
                  completeTableId.getProject(),
                  completeTableId.getDataset(),
                  completeTableId.getTable());
            }
          },
          getOptions().getRetrySettings(),
          BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
          getOptions().getClock(),
          EMPTY_RETRY_CONFIG);
    } catch (BigQueryRetryHelperException e) {
      if (isRetryErrorCodeHttpNotFound(e)) {
        return false;
      }
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (tableDelete != null) {
        tableDelete.end();
      }
    }
  }

  @Override
  public boolean delete(ModelId modelId) {
    final ModelId completeModelId =
        modelId.setProjectId(
            Strings.isNullOrEmpty(modelId.getProject())
                ? getOptions().getProjectId()
                : modelId.getProject());
    Span modelDelete = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      modelDelete =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.deleteModel")
              .setAllAttributes(modelId.getOtelAttributes())
              .startSpan();
    }
    try (Scope modelDeleteScope = modelDelete != null ? modelDelete.makeCurrent() : null) {
      return BigQueryRetryHelper.runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() throws IOException {
              return bigQueryRpc.deleteModelSkipExceptionTranslation(
                  completeModelId.getProject(),
                  completeModelId.getDataset(),
                  completeModelId.getModel());
            }
          },
          getOptions().getRetrySettings(),
          BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
          getOptions().getClock(),
          EMPTY_RETRY_CONFIG);
    } catch (BigQueryRetryHelperException e) {
      if (isRetryErrorCodeHttpNotFound(e)) {
        return false;
      }
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (modelDelete != null) {
        modelDelete.end();
      }
    }
  }

  @Override
  public boolean delete(RoutineId routineId) {
    final RoutineId completeRoutineId =
        routineId.setProjectId(
            Strings.isNullOrEmpty(routineId.getProject())
                ? getOptions().getProjectId()
                : routineId.getProject());
    Span routineDelete = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      routineDelete =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.deleteRoutine")
              .setAllAttributes(routineId.getOtelAttributes())
              .startSpan();
    }
    try (Scope routineDeleteScope = routineDelete != null ? routineDelete.makeCurrent() : null) {
      return BigQueryRetryHelper.runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() throws IOException {
              return bigQueryRpc.deleteRoutineSkipExceptionTranslation(
                  completeRoutineId.getProject(),
                  completeRoutineId.getDataset(),
                  completeRoutineId.getRoutine());
            }
          },
          getOptions().getRetrySettings(),
          BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
          getOptions().getClock(),
          EMPTY_RETRY_CONFIG);
    } catch (BigQueryRetryHelperException e) {
      if (isRetryErrorCodeHttpNotFound(e)) {
        return false;
      }
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (routineDelete != null) {
        routineDelete.end();
      }
    }
  }

  @Override
  public boolean delete(JobId jobId) {
    final JobId completeJobId =
        jobId.setProjectId(
            Strings.isNullOrEmpty(jobId.getProject())
                ? getOptions().getProjectId()
                : jobId.getProject());
    Span jobDelete = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      jobDelete =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.deleteJob")
              .setAllAttributes(completeJobId.getOtelAttributes())
              .startSpan();
    }
    try {
      return BigQueryRetryHelper.runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() throws IOException {
              return bigQueryRpc.deleteJobSkipExceptionTranslation(
                  completeJobId.getProject(), completeJobId.getJob(), completeJobId.getLocation());
            }
          },
          getOptions().getRetrySettings(),
          BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
          getOptions().getClock(),
          EMPTY_RETRY_CONFIG);
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (jobDelete != null) {
        jobDelete.end();
      }
    }
  }

  @Override
  public Dataset update(DatasetInfo datasetInfo, DatasetOption... options) {
    final com.google.api.services.bigquery.model.Dataset datasetPb =
        datasetInfo.setProjectId(getOptions().getProjectId()).toPb();
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    Span datasetUpdate = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      datasetUpdate =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.updateDataset")
              .setAllAttributes(datasetInfo.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope datasetUpdateScope = datasetUpdate != null ? datasetUpdate.makeCurrent() : null) {
      return Dataset.fromPb(
          this,
          BigQueryRetryHelper.runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Dataset>() {
                @Override
                public com.google.api.services.bigquery.model.Dataset call() throws IOException {
                  return bigQueryRpc.patchSkipExceptionTranslation(datasetPb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock(),
              EMPTY_RETRY_CONFIG));
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (datasetUpdate != null) {
        datasetUpdate.end();
      }
    }
  }

  @Override
  public Table update(TableInfo tableInfo, TableOption... options) {
    final com.google.api.services.bigquery.model.Table tablePb =
        tableInfo
            .setProjectId(
                Strings.isNullOrEmpty(tableInfo.getTableId().getProject())
                    ? getOptions().getProjectId()
                    : tableInfo.getTableId().getProject())
            .toPb();
    handleExternalTableSchema(tablePb);
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    Span tableUpdate = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      tableUpdate =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.updateTable")
              .setAllAttributes(tableInfo.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope tableUpdateScope = tableUpdate != null ? tableUpdate.makeCurrent() : null) {
      return Table.fromPb(
          this,
          BigQueryRetryHelper.runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Table>() {
                @Override
                public com.google.api.services.bigquery.model.Table call() throws IOException {
                  return bigQueryRpc.patchSkipExceptionTranslation(tablePb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock(),
              EMPTY_RETRY_CONFIG));
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (tableUpdate != null) {
        tableUpdate.end();
      }
    }
  }

  @Override
  public Model update(ModelInfo modelInfo, ModelOption... options) {
    final com.google.api.services.bigquery.model.Model modelPb =
        modelInfo
            .setProjectId(
                Strings.isNullOrEmpty(modelInfo.getModelId().getProject())
                    ? getOptions().getProjectId()
                    : modelInfo.getModelId().getProject())
            .toPb();
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    Span modelUpdate = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      modelUpdate =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.updateModel")
              .setAllAttributes(modelInfo.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope modelUpdateScope = modelUpdate != null ? modelUpdate.makeCurrent() : null) {
      return Model.fromPb(
          this,
          BigQueryRetryHelper.runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Model>() {
                @Override
                public com.google.api.services.bigquery.model.Model call() throws IOException {
                  return bigQueryRpc.patchSkipExceptionTranslation(modelPb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock(),
              EMPTY_RETRY_CONFIG));
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (modelUpdate != null) {
        modelUpdate.end();
      }
    }
  }

  @Override
  public Routine update(RoutineInfo routineInfo, RoutineOption... options) {
    final com.google.api.services.bigquery.model.Routine routinePb =
        routineInfo
            .setProjectId(
                Strings.isNullOrEmpty(routineInfo.getRoutineId().getProject())
                    ? getOptions().getProjectId()
                    : routineInfo.getRoutineId().getProject())
            .toPb();
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    Span routineUpdate = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      routineUpdate =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.updateRoutine")
              .setAllAttributes(routineInfo.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope routineUpdateScope = routineUpdate != null ? routineUpdate.makeCurrent() : null) {
      return Routine.fromPb(
          this,
          BigQueryRetryHelper.runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Routine>() {
                @Override
                public com.google.api.services.bigquery.model.Routine call() throws IOException {
                  return bigQueryRpc.updateSkipExceptionTranslation(routinePb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock(),
              EMPTY_RETRY_CONFIG));
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (routineUpdate != null) {
        routineUpdate.end();
      }
    }
  }

  @Override
  public Table getTable(final String datasetId, final String tableId, TableOption... options) {
    return getTable(TableId.of(datasetId, tableId), options);
  }

  @Override
  public Table getTable(TableId tableId, TableOption... options) {
    // More context about why this:
    // https://github.com/googleapis/google-cloud-java/issues/3808
    final TableId completeTableId =
        tableId.setProjectId(
            Strings.isNullOrEmpty(tableId.getProject())
                ? getOptions().getProjectId()
                : tableId.getProject());
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    Span tableGet = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      tableGet =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.getTable")
              .setAllAttributes(tableId.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope tableGetScope = tableGet != null ? tableGet.makeCurrent() : null) {
      com.google.api.services.bigquery.model.Table answer =
          BigQueryRetryHelper.runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Table>() {
                @Override
                public com.google.api.services.bigquery.model.Table call() throws IOException {
                  return bigQueryRpc.getTableSkipExceptionTranslation(
                      completeTableId.getProject(),
                      completeTableId.getDataset(),
                      completeTableId.getTable(),
                      optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock(),
              EMPTY_RETRY_CONFIG);
      return Table.fromPb(this, answer);
    } catch (BigQueryRetryHelperException e) {
      if (isRetryErrorCodeHttpNotFound(e)) {
        if (getOptions().getThrowNotFound()) {
          throw new BigQueryException(HTTP_NOT_FOUND, "Table not found");
        }
        return null;
      }
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (tableGet != null) {
        tableGet.end();
      }
    }
  }

  @Override
  public Model getModel(String datasetId, String modelId, ModelOption... options) {
    return getModel(ModelId.of(datasetId, modelId), options);
  }

  @Override
  public Model getModel(ModelId modelId, ModelOption... options) {
    final ModelId completeModelId =
        modelId.setProjectId(
            Strings.isNullOrEmpty(modelId.getProject())
                ? getOptions().getProjectId()
                : modelId.getProject());
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    Span modelGet = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      modelGet =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.getModel")
              .setAllAttributes(modelId.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope modelGetScope = modelGet != null ? modelGet.makeCurrent() : null) {
      com.google.api.services.bigquery.model.Model answer =
          BigQueryRetryHelper.runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Model>() {
                @Override
                public com.google.api.services.bigquery.model.Model call() throws IOException {
                  return bigQueryRpc.getModelSkipExceptionTranslation(
                      completeModelId.getProject(),
                      completeModelId.getDataset(),
                      completeModelId.getModel(),
                      optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock(),
              EMPTY_RETRY_CONFIG);
      return Model.fromPb(this, answer);
    } catch (BigQueryRetryHelperException e) {
      if (isRetryErrorCodeHttpNotFound(e)) {
        if (getOptions().getThrowNotFound()) {
          throw new BigQueryException(HTTP_NOT_FOUND, "Model not found");
        }
        return null;
      }
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (modelGet != null) {
        modelGet.end();
      }
    }
  }

  @Override
  public Routine getRoutine(String datasetId, String routineId, RoutineOption... options) {
    return getRoutine(RoutineId.of(datasetId, routineId), options);
  }

  @Override
  public Routine getRoutine(RoutineId routineId, RoutineOption... options) {
    final RoutineId completeRoutineId =
        routineId.setProjectId(
            Strings.isNullOrEmpty(routineId.getProject())
                ? getOptions().getProjectId()
                : routineId.getProject());
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    Span routineGet = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      routineGet =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.getRoutine")
              .setAllAttributes(routineId.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope routineGetScope = routineGet != null ? routineGet.makeCurrent() : null) {
      com.google.api.services.bigquery.model.Routine answer =
          BigQueryRetryHelper.runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Routine>() {
                @Override
                public com.google.api.services.bigquery.model.Routine call() throws IOException {
                  return bigQueryRpc.getRoutineSkipExceptionTranslation(
                      completeRoutineId.getProject(),
                      completeRoutineId.getDataset(),
                      completeRoutineId.getRoutine(),
                      optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock(),
              EMPTY_RETRY_CONFIG);
      return Routine.fromPb(this, answer);
    } catch (BigQueryRetryHelperException e) {
      if (isRetryErrorCodeHttpNotFound(e)) {
        if (getOptions().getThrowNotFound()) {
          throw new BigQueryException(HTTP_NOT_FOUND, "Routine not found");
        }
        return null;
      }
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (routineGet != null) {
        routineGet.end();
      }
    }
  }

  @Override
  public Page<Table> listTables(String datasetId, TableListOption... options) {
    Span tablesList = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      tablesList =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.listTables")
              .setAllAttributes(DatasetId.of(datasetId).getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope tablesListScope = tablesList != null ? tablesList.makeCurrent() : null) {
      return listTables(
          DatasetId.of(getOptions().getProjectId(), datasetId), getOptions(), optionMap(options));
    } finally {
      if (tablesList != null) {
        tablesList.end();
      }
    }
  }

  @Override
  public Page<Table> listTables(DatasetId datasetId, TableListOption... options) {
    DatasetId completeDatasetId = datasetId.setProjectId(getOptions().getProjectId());
    Span tablesList = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      tablesList =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.listTables")
              .setAllAttributes(completeDatasetId.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope tablesListScope = tablesList != null ? tablesList.makeCurrent() : null) {
      return listTables(completeDatasetId, getOptions(), optionMap(options));
    } finally {
      if (tablesList != null) {
        tablesList.end();
      }
    }
  }

  @Override
  public Page<Model> listModels(String datasetId, ModelListOption... options) {
    Span modelsList = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      modelsList =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.listModels")
              .setAllAttributes(DatasetId.of(datasetId).getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope modelsListScope = modelsList != null ? modelsList.makeCurrent() : null) {
      return listModels(
          DatasetId.of(getOptions().getProjectId(), datasetId), getOptions(), optionMap(options));
    } finally {
      if (modelsList != null) {
        modelsList.end();
      }
    }
  }

  @Override
  public Page<Model> listModels(DatasetId datasetId, ModelListOption... options) {
    DatasetId completeDatasetId = datasetId.setProjectId(getOptions().getProjectId());
    Span modelsList = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      modelsList =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.listModels")
              .setAllAttributes(datasetId.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope modelsListScope = modelsList != null ? modelsList.makeCurrent() : null) {
      return listModels(completeDatasetId, getOptions(), optionMap(options));
    } finally {
      if (modelsList != null) {
        modelsList.end();
      }
    }
  }

  @Override
  public Page<Routine> listRoutines(String datasetId, RoutineListOption... options) {
    Span routinesList = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      routinesList =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.listRoutines")
              .setAllAttributes(DatasetId.of(datasetId).getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope routinesListScope = routinesList != null ? routinesList.makeCurrent() : null) {
      return listRoutines(
          DatasetId.of(getOptions().getProjectId(), datasetId), getOptions(), optionMap(options));
    } finally {
      if (routinesList != null) {
        routinesList.end();
      }
    }
  }

  @Override
  public Page<Routine> listRoutines(DatasetId datasetId, RoutineListOption... options) {
    DatasetId completeDatasetId = datasetId.setProjectId(getOptions().getProjectId());
    Span routinesList = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      routinesList =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.listRoutines")
              .setAllAttributes(datasetId.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope routinesListScope = routinesList != null ? routinesList.makeCurrent() : null) {
      return listRoutines(completeDatasetId, getOptions(), optionMap(options));
    } finally {
      if (routinesList != null) {
        routinesList.end();
      }
    }
  }

  @Override
  public List<String> listPartitions(TableId tableId) {
    Span listPartitions = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      listPartitions =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.listPartitions")
              .setAllAttributes(tableId.getOtelAttributes())
              .startSpan();
    }
    try (Scope listPartitionsScope = listPartitions != null ? listPartitions.makeCurrent() : null) {
      List<String> partitions = new ArrayList<String>();
      String partitionsTable = tableId.getTable() + "$__PARTITIONS_SUMMARY__";
      TableId metaTableId =
          tableId.getProject() == null
              ? TableId.of(tableId.getDataset(), partitionsTable)
              : TableId.of(tableId.getProject(), tableId.getDataset(), partitionsTable);
      Table metaTable = getTable(metaTableId);
      Schema metaSchema = metaTable.getDefinition().getSchema();
      String partition_id = null;
      for (Field field : metaSchema.getFields()) {
        if (field.getName().equals("partition_id")) {
          partition_id = field.getName();
          break;
        }
      }
      TableResult result = metaTable.list(metaSchema);
      for (FieldValueList list : result.iterateAll()) {
        partitions.add(list.get(partition_id).getStringValue());
      }
      return partitions;
    } finally {
      if (listPartitions != null) {
        listPartitions.end();
      }
    }
  }

  private static Page<Table> listTables(
      final DatasetId datasetId,
      final BigQueryOptions serviceOptions,
      final Map<BigQueryRpc.Option, ?> optionsMap) {
    try {
      Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>> result =
          BigQueryRetryHelper.runWithRetries(
              new Callable<
                  Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>>>() {
                @Override
                public Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>> call()
                    throws IOException {
                  return serviceOptions
                      .getBigQueryRpcV2()
                      .listTablesSkipExceptionTranslation(
                          datasetId.getProject(), datasetId.getDataset(), optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              serviceOptions.getClock(),
              EMPTY_RETRY_CONFIG);
      String cursor = result.x();
      Iterable<Table> tables =
          Iterables.transform(
              result.y(),
              new Function<com.google.api.services.bigquery.model.Table, Table>() {
                @Override
                public Table apply(com.google.api.services.bigquery.model.Table table) {
                  return Table.fromPb(serviceOptions.getService(), table);
                }
              });
      return new PageImpl<>(
          new TablePageFetcher(datasetId, serviceOptions, cursor, optionsMap), cursor, tables);
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  private static Page<Model> listModels(
      final DatasetId datasetId,
      final BigQueryOptions serviceOptions,
      final Map<BigQueryRpc.Option, ?> optionsMap) {
    try {
      Tuple<String, Iterable<com.google.api.services.bigquery.model.Model>> result =
          BigQueryRetryHelper.runWithRetries(
              new Callable<
                  Tuple<String, Iterable<com.google.api.services.bigquery.model.Model>>>() {
                @Override
                public Tuple<String, Iterable<com.google.api.services.bigquery.model.Model>> call()
                    throws IOException {
                  return serviceOptions
                      .getBigQueryRpcV2()
                      .listModelsSkipExceptionTranslation(
                          datasetId.getProject(), datasetId.getDataset(), optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              serviceOptions.getClock(),
              EMPTY_RETRY_CONFIG);
      String cursor = result.x();
      Iterable<Model> models =
          Iterables.transform(
              result.y(),
              new Function<com.google.api.services.bigquery.model.Model, Model>() {
                @Override
                public Model apply(com.google.api.services.bigquery.model.Model model) {
                  return Model.fromPb(serviceOptions.getService(), model);
                }
              });
      return new PageImpl<>(
          new ModelPageFetcher(datasetId, serviceOptions, cursor, optionsMap), cursor, models);
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  private static Page<Routine> listRoutines(
      final DatasetId datasetId,
      final BigQueryOptions serviceOptions,
      final Map<BigQueryRpc.Option, ?> optionsMap) {
    try {
      Tuple<String, Iterable<com.google.api.services.bigquery.model.Routine>> result =
          BigQueryRetryHelper.runWithRetries(
              new Callable<
                  Tuple<String, Iterable<com.google.api.services.bigquery.model.Routine>>>() {
                @Override
                public Tuple<String, Iterable<com.google.api.services.bigquery.model.Routine>>
                    call() throws IOException {
                  return serviceOptions
                      .getBigQueryRpcV2()
                      .listRoutinesSkipExceptionTranslation(
                          datasetId.getProject(), datasetId.getDataset(), optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              serviceOptions.getClock(),
              EMPTY_RETRY_CONFIG);
      String cursor = result.x();
      Iterable<Routine> routines =
          Iterables.transform(
              result.y(),
              new Function<com.google.api.services.bigquery.model.Routine, Routine>() {
                @Override
                public Routine apply(com.google.api.services.bigquery.model.Routine routinePb) {
                  return Routine.fromPb(serviceOptions.getService(), routinePb);
                }
              });
      return new PageImpl<>(
          new RoutinePageFetcher(datasetId, serviceOptions, cursor, optionsMap), cursor, routines);
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public InsertAllResponse insertAll(InsertAllRequest request) {
    final TableId tableId =
        request
            .getTable()
            .setProjectId(
                Strings.isNullOrEmpty(request.getTable().getProject())
                    ? getOptions().getProjectId()
                    : request.getTable().getProject());
    final TableDataInsertAllRequest requestPb = new TableDataInsertAllRequest();
    requestPb.setIgnoreUnknownValues(request.ignoreUnknownValues());
    requestPb.setSkipInvalidRows(request.skipInvalidRows());
    requestPb.setTemplateSuffix(request.getTemplateSuffix());
    // Using an array of size 1 here to have a mutable boolean variable, which can
    // be modified in
    // an anonymous inner class.
    final boolean[] allInsertIdsSet = {true};
    List<Rows> rowsPb =
        FluentIterable.from(request.getRows())
            .transform(
                new Function<RowToInsert, Rows>() {
                  @Override
                  public Rows apply(RowToInsert rowToInsert) {
                    allInsertIdsSet[0] &= rowToInsert.getId() != null;
                    return new Rows()
                        .setInsertId(rowToInsert.getId())
                        .setJson(rowToInsert.getContent());
                  }
                })
            .toList();
    requestPb.setRows(rowsPb);

    TableDataInsertAllResponse responsePb;
    Span insertAll = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      insertAll =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.insertAll")
              .setAllAttributes(request.getOtelAttributes())
              .startSpan();
    }
    try (Scope insertAllScope = insertAll != null ? insertAll.makeCurrent() : null) {
      if (allInsertIdsSet[0]) {
        // allowing retries only if all row insertIds are set (used for deduplication)
        try {
          responsePb =
              BigQueryRetryHelper.runWithRetries(
                  new Callable<TableDataInsertAllResponse>() {
                    @Override
                    public TableDataInsertAllResponse call() throws Exception {
                      return bigQueryRpc.insertAllSkipExceptionTranslation(
                          tableId.getProject(),
                          tableId.getDataset(),
                          tableId.getTable(),
                          requestPb);
                    }
                  },
                  getOptions().getRetrySettings(),
                  BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
                  getOptions().getClock(),
                  EMPTY_RETRY_CONFIG);
        } catch (BigQueryRetryHelperException e) {
          throw BigQueryException.translateAndThrow(e);
        }
      } else {
        // Use insertAll that translate the exception as we are not retrying.
        responsePb =
            bigQueryRpc.insertAll(
                tableId.getProject(), tableId.getDataset(), tableId.getTable(), requestPb);
      }

      return InsertAllResponse.fromPb(responsePb);
    } finally {
      if (insertAll != null) {
        insertAll.end();
      }
    }
  }

  @Override
  public TableResult listTableData(
      String datasetId, String tableId, TableDataListOption... options) {
    return listTableData(TableId.of(datasetId, tableId), options);
  }

  @Override
  public TableResult listTableData(TableId tableId, TableDataListOption... options) {
    return listTableData(tableId, null, options);
  }

  @Override
  public TableResult listTableData(
      String datasetId, String tableId, Schema schema, TableDataListOption... options) {
    return listTableData(TableId.of(datasetId, tableId), schema, options);
  }

  @Override
  public TableResult listTableData(TableId tableId, Schema schema, TableDataListOption... options) {
    Tuple<? extends Page<FieldValueList>, Long> data =
        listTableData(tableId, schema, getOptions(), optionMap(options));
    Span tableDataList = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      tableDataList =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.listTableData")
              .setAllAttributes(tableId.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope tableDataListScope = tableDataList != null ? tableDataList.makeCurrent() : null) {
      return TableResult.newBuilder()
          .setSchema(schema)
          .setTotalRows(data.y())
          .setPageNoSchema(data.x())
          .build();
    } finally {
      if (tableDataList != null) {
        tableDataList.end();
      }
    }
  }

  private static Tuple<? extends Page<FieldValueList>, Long> listTableData(
      final TableId tableId,
      final Schema schema,
      final BigQueryOptions serviceOptions,
      final Map<BigQueryRpc.Option, ?> optionsMap) {
    try {
      final TableId completeTableId =
          tableId.setProjectId(
              Strings.isNullOrEmpty(tableId.getProject())
                  ? serviceOptions.getProjectId()
                  : tableId.getProject());
      TableDataList result =
          BigQueryRetryHelper.runWithRetries(
              new Callable<TableDataList>() {
                @Override
                public TableDataList call() throws IOException {
                  return serviceOptions
                      .getBigQueryRpcV2()
                      .listTableDataSkipExceptionTranslation(
                          completeTableId.getProject(),
                          completeTableId.getDataset(),
                          completeTableId.getTable(),
                          optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              serviceOptions.getClock(),
              EMPTY_RETRY_CONFIG);
      String cursor = result.getPageToken();
      Map<BigQueryRpc.Option, ?> pageOptionMap =
          Strings.isNullOrEmpty(cursor) ? optionsMap : optionMap(TableDataListOption.startIndex(0));
      return Tuple.of(
          new PageImpl<>(
              new TableDataPageFetcher(tableId, schema, serviceOptions, cursor, pageOptionMap),
              cursor,
              transformTableData(result.getRows(), schema, serviceOptions.getUseInt64Timestamps())),
          result.getTotalRows());
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  private static Iterable<FieldValueList> transformTableData(
      Iterable<TableRow> tableDataPb, final Schema schema, boolean useInt64Timestamps) {
    return ImmutableList.copyOf(
        Iterables.transform(
            tableDataPb != null ? tableDataPb : ImmutableList.<TableRow>of(),
            new Function<TableRow, FieldValueList>() {
              FieldList fields = schema != null ? schema.getFields() : null;

              @Override
              public FieldValueList apply(TableRow rowPb) {
                return FieldValueList.fromPb(rowPb.getF(), fields, useInt64Timestamps);
              }
            }));
  }

  @Override
  public Job getJob(String jobId, JobOption... options) {
    return getJob(JobId.of(jobId), options);
  }

  @Override
  public Job getJob(JobId jobId, JobOption... options) {
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    final JobId completeJobId =
        jobId
            .setProjectId(getOptions().getProjectId())
            .setLocation(
                jobId.getLocation() == null && getOptions().getLocation() != null
                    ? getOptions().getLocation()
                    : jobId.getLocation());
    Span jobGet = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      jobGet =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.getJob")
              .setAllAttributes(completeJobId.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope jobGetScope = jobGet != null ? jobGet.makeCurrent() : null) {
      com.google.api.services.bigquery.model.Job answer =
          BigQueryRetryHelper.runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Job>() {
                @Override
                public com.google.api.services.bigquery.model.Job call() throws IOException {
                  return bigQueryRpc.getJobSkipExceptionTranslation(
                      completeJobId.getProject(),
                      completeJobId.getJob(),
                      completeJobId.getLocation(),
                      optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock(),
              EMPTY_RETRY_CONFIG);
      return Job.fromPb(this, answer);
    } catch (BigQueryRetryHelperException e) {
      if (isRetryErrorCodeHttpNotFound(e)) {
        if (getOptions().getThrowNotFound()) {
          throw new BigQueryException(HTTP_NOT_FOUND, "Job not found");
        }
        return null;
      }
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (jobGet != null) {
        jobGet.end();
      }
    }
  }

  @Override
  public Page<Job> listJobs(JobListOption... options) {
    Span jobsList = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      jobsList =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.listJobs")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope jobsListScope = jobsList != null ? jobsList.makeCurrent() : null) {
      return listJobs(getOptions(), optionMap(options));
    } finally {
      if (jobsList != null) {
        jobsList.end();
      }
    }
  }

  private static Page<Job> listJobs(
      final BigQueryOptions serviceOptions, final Map<BigQueryRpc.Option, ?> optionsMap) {
    try {
      Tuple<String, Iterable<com.google.api.services.bigquery.model.Job>> result =
          BigQueryRetryHelper.runWithRetries(
              new Callable<Tuple<String, Iterable<com.google.api.services.bigquery.model.Job>>>() {
                @Override
                public Tuple<String, Iterable<com.google.api.services.bigquery.model.Job>> call()
                    throws IOException {
                  return serviceOptions
                      .getBigQueryRpcV2()
                      .listJobsSkipExceptionTranslation(serviceOptions.getProjectId(), optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              serviceOptions.getClock(),
              EMPTY_RETRY_CONFIG);
      String cursor = result.x();
      Iterable<Job> jobs =
          Iterables.transform(
              result.y(),
              new Function<com.google.api.services.bigquery.model.Job, Job>() {
                @Override
                public Job apply(com.google.api.services.bigquery.model.Job job) {
                  return Job.fromPb(serviceOptions.getService(), job);
                }
              });
      return new PageImpl<>(new JobPageFetcher(serviceOptions, cursor, optionsMap), cursor, jobs);
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public boolean cancel(String jobId) {
    return cancel(JobId.of(jobId));
  }

  @Override
  public boolean cancel(JobId jobId) {
    final JobId completeJobId =
        jobId
            .setProjectId(getOptions().getProjectId())
            .setLocation(
                jobId.getLocation() == null && getOptions().getLocation() != null
                    ? getOptions().getLocation()
                    : jobId.getLocation());
    Span jobCancel = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      jobCancel =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.cancelJob")
              .setAllAttributes(completeJobId.getOtelAttributes())
              .startSpan();
    }
    try (Scope jobCancelScope = jobCancel != null ? jobCancel.makeCurrent() : null) {
      return BigQueryRetryHelper.runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() throws IOException {
              return bigQueryRpc.cancelSkipExceptionTranslation(
                  completeJobId.getProject(), completeJobId.getJob(), completeJobId.getLocation());
            }
          },
          getOptions().getRetrySettings(),
          BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
          getOptions().getClock(),
          EMPTY_RETRY_CONFIG);
    } catch (BigQueryRetryHelperException e) {
      if (isRetryErrorCodeHttpNotFound(e)) {
        return false;
      }
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (jobCancel != null) {
        jobCancel.end();
      }
    }
  }

  @Override
  public TableResult query(QueryJobConfiguration configuration, JobOption... options)
      throws InterruptedException, JobException {
    Job.checkNotDryRun(configuration, "query");

    configuration =
        configuration.toBuilder()
            .setJobCreationMode(getOptions().getDefaultJobCreationMode())
            .build();

    Span querySpan = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      querySpan =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.query")
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope queryScope = querySpan != null ? querySpan.makeCurrent() : null) {
      // If all parameters passed in configuration are supported by the query() method on the
      // backend,
      // put on fast path
      QueryRequestInfo requestInfo =
          new QueryRequestInfo(configuration, getOptions().getUseInt64Timestamps());
      if (requestInfo.isFastQuerySupported(null)) {
        String projectId = getOptions().getProjectId();
        QueryRequest content = requestInfo.toPb();
        if (getOptions().getLocation() != null) {
          content.setLocation(getOptions().getLocation());
        }
        return queryRpc(projectId, content, options);
      }
      // Otherwise, fall back to the existing create query job logic
      return create(JobInfo.of(configuration), options).getQueryResults();
    } finally {
      if (querySpan != null) {
        querySpan.end();
      }
    }
  }

  private TableResult queryRpc(
      final String projectId, final QueryRequest content, JobOption... options)
      throws InterruptedException {
    com.google.api.services.bigquery.model.QueryResponse results;
    Span queryRpc = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      queryRpc =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.queryRpc")
              .setAttribute("bq.query.project_id", projectId)
              .setAllAttributes(otelAttributesFromQueryRequest(content))
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope queryRpcScope = queryRpc != null ? queryRpc.makeCurrent() : null) {
      results =
          BigQueryRetryHelper.runWithRetries(
              new Callable<com.google.api.services.bigquery.model.QueryResponse>() {
                @Override
                public com.google.api.services.bigquery.model.QueryResponse call()
                    throws IOException {
                  return bigQueryRpc.queryRpcSkipExceptionTranslation(projectId, content);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock(),
              DEFAULT_RETRY_CONFIG);
    } catch (BigQueryRetryHelper.BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (queryRpc != null) {
        queryRpc.end();
      }
    }

    if (results.getErrors() != null) {
      List<BigQueryError> bigQueryErrors =
          Lists.transform(results.getErrors(), BigQueryError.FROM_PB_FUNCTION);
      // Throwing BigQueryException since there may be no JobId and we want to stay consistent
      // with the case where there is an HTTP error
      throw new BigQueryException(bigQueryErrors);
    }

    long numRows;
    Schema schema;
    if (results.getJobComplete() && results.getSchema() != null) {
      schema = Schema.fromPb(results.getSchema());
      if (results.getNumDmlAffectedRows() == null && results.getTotalRows() == null) {
        numRows = 0L;
      } else if (results.getNumDmlAffectedRows() != null) {
        numRows = results.getNumDmlAffectedRows();
      } else {
        numRows = results.getTotalRows().longValue();
      }
    } else {
      // Query is long running (> 10s) and hasn't completed yet, or query completed but didn't
      // return the schema, fallback. Some operations don't return the schema and can be optimized
      // here, but this is left as future work.
      JobId jobId = JobId.fromPb(results.getJobReference());
      Job job = getJob(jobId, options);
      return job.getQueryResults();
    }

    if (results.getPageToken() != null) {
      JobId jobId = JobId.fromPb(results.getJobReference());
      String cursor = results.getPageToken();
      return TableResult.newBuilder()
          .setSchema(schema)
          .setTotalRows(numRows)
          .setPageNoSchema(
              new PageImpl<>(
                  // fetch next pages of results
                  new QueryPageFetcher(jobId, schema, getOptions(), cursor, optionMap(options)),
                  cursor,
                  transformTableData(
                      results.getRows(), schema, getOptions().getUseInt64Timestamps())))
          .setJobId(jobId)
          .setQueryId(results.getQueryId())
          .build();
    }
    // only 1 page of result
    return TableResult.newBuilder()
        .setSchema(schema)
        .setTotalRows(numRows)
        .setPageNoSchema(
            new PageImpl<>(
                new TableDataPageFetcher(null, schema, getOptions(), null, optionMap(options)),
                null,
                transformTableData(
                    results.getRows(), schema, getOptions().getUseInt64Timestamps())))
        // Return the JobID of the successful job
        .setJobId(
            results.getJobReference() != null ? JobId.fromPb(results.getJobReference()) : null)
        .setQueryId(results.getQueryId())
        .build();
  }

  @Override
  public TableResult query(QueryJobConfiguration configuration, JobId jobId, JobOption... options)
      throws InterruptedException, JobException {
    Job.checkNotDryRun(configuration, "query");

    Span querySpan = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      querySpan =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.query")
              .setAllAttributes(jobId.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope queryScope = querySpan != null ? querySpan.makeCurrent() : null) {
      // If all parameters passed in configuration are supported by the query() method on the
      // backend,
      // put on fast path
      QueryRequestInfo requestInfo =
          new QueryRequestInfo(configuration, getOptions().getUseInt64Timestamps());
      if (requestInfo.isFastQuerySupported(jobId)) {
        // Be careful when setting the projectID in JobId, if a projectID is specified in the JobId,
        // the job created by the query method will use that project. This may cause the query to
        // fail with "Access denied" if the project do not have enough permissions to run the job.

        String projectId =
            jobId.getProject() != null ? jobId.getProject() : getOptions().getProjectId();
        QueryRequest content = requestInfo.toPb();
        // Be careful when setting the location, if a location is specified in the BigQueryOption or
        // JobId the job created by the query method will be in that location, even if the table to
        // be
        // queried is in a different location. This may cause the query to fail with
        // "BigQueryException: Not found"
        if (jobId.getLocation() != null) {
          content.setLocation(jobId.getLocation());
        } else if (getOptions().getLocation() != null) {
          content.setLocation(getOptions().getLocation());
        }

        return queryRpc(projectId, content, options);
      }
      return create(JobInfo.of(jobId, configuration), options).getQueryResults();
    } finally {
      if (querySpan != null) {
        querySpan.end();
      }
    }
  }

  @Override
  public QueryResponse getQueryResults(JobId jobId, QueryResultsOption... options) {
    Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    Span getQueryResults = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      getQueryResults =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.getQueryResults")
              .setAllAttributes(jobId.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope getQueryResultsScope =
        getQueryResults != null ? getQueryResults.makeCurrent() : null) {
      return getQueryResults(jobId, getOptions(), optionsMap);
    } finally {
      if (getQueryResults != null) {
        getQueryResults.end();
      }
    }
  }

  private static QueryResponse getQueryResults(
      JobId jobId,
      final BigQueryOptions serviceOptions,
      final Map<BigQueryRpc.Option, ?> optionsMap) {
    final JobId completeJobId =
        jobId
            .setProjectId(serviceOptions.getProjectId())
            .setLocation(
                jobId.getLocation() == null && serviceOptions.getLocation() != null
                    ? serviceOptions.getLocation()
                    : jobId.getLocation());
    try {
      GetQueryResultsResponse results =
          BigQueryRetryHelper.runWithRetries(
              new Callable<GetQueryResultsResponse>() {
                @Override
                public GetQueryResultsResponse call() throws IOException {
                  return serviceOptions
                      .getBigQueryRpcV2()
                      .getQueryResultsSkipExceptionTranslation(
                          completeJobId.getProject(),
                          completeJobId.getJob(),
                          completeJobId.getLocation(),
                          optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              serviceOptions.getClock(),
              DEFAULT_RETRY_CONFIG);

      TableSchema schemaPb = results.getSchema();

      ImmutableList.Builder<BigQueryError> errors = ImmutableList.builder();
      if (results.getErrors() != null) {
        for (ErrorProto error : results.getErrors()) {
          errors.add(BigQueryError.fromPb(error));
        }
      }

      return QueryResponse.newBuilder()
          .setCompleted(results.getJobComplete())
          .setSchema(schemaPb == null ? null : Schema.fromPb(schemaPb))
          .setTotalRows(results.getTotalRows() == null ? 0 : results.getTotalRows().longValue())
          .setErrors(errors.build())
          .build();
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public TableDataWriteChannel writer(WriteChannelConfiguration writeChannelConfiguration) {
    return writer(JobId.of(), writeChannelConfiguration);
  }

  @Override
  public TableDataWriteChannel writer(
      JobId jobId, WriteChannelConfiguration writeChannelConfiguration) {
    return new TableDataWriteChannel(
        getOptions(),
        jobId.setProjectId(getOptions().getProjectId()),
        writeChannelConfiguration.setProjectId(getOptions().getProjectId()));
  }

  @Override
  public Policy getIamPolicy(TableId tableId, IAMOption... options) {
    final TableId completeTableId =
        tableId.setProjectId(
            Strings.isNullOrEmpty(tableId.getProject())
                ? getOptions().getProjectId()
                : tableId.getProject());

    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    Span iamPolicyGet = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      iamPolicyGet =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.getIamPolicy")
              .setAllAttributes(tableId.getOtelAttributes())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope iamPolicyGetScope = iamPolicyGet != null ? iamPolicyGet.makeCurrent() : null) {
      return convertFromApiPolicy(
          BigQueryRetryHelper.runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Policy>() {
                @Override
                public com.google.api.services.bigquery.model.Policy call() throws IOException {
                  return bigQueryRpc.getIamPolicySkipExceptionTranslation(
                      completeTableId.getIAMResourceName(), optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock(),
              EMPTY_RETRY_CONFIG));
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (iamPolicyGet != null) {
        iamPolicyGet.end();
      }
    }
  }

  @Override
  public Policy setIamPolicy(TableId tableId, final Policy policy, IAMOption... options) {
    final TableId completeTableId =
        tableId.setProjectId(
            Strings.isNullOrEmpty(tableId.getProject())
                ? getOptions().getProjectId()
                : tableId.getProject());

    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    Span iamPolicySet = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      iamPolicySet =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.setIamPolicy")
              .setAllAttributes(tableId.getOtelAttributes())
              .setAllAttributes(otelAttributesFromPolicy(policy))
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope iamPolicySetScope = iamPolicySet != null ? iamPolicySet.makeCurrent() : null) {
      return convertFromApiPolicy(
          BigQueryRetryHelper.runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Policy>() {
                @Override
                public com.google.api.services.bigquery.model.Policy call() throws IOException {
                  return bigQueryRpc.setIamPolicySkipExceptionTranslation(
                      completeTableId.getIAMResourceName(), convertToApiPolicy(policy), optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock(),
              EMPTY_RETRY_CONFIG));
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (iamPolicySet != null) {
        iamPolicySet.end();
      }
    }
  }

  @Override
  public List<String> testIamPermissions(
      TableId tableId, final List<String> permissions, IAMOption... options) {
    final TableId completeTableId =
        tableId.setProjectId(
            Strings.isNullOrEmpty(tableId.getProject())
                ? getOptions().getProjectId()
                : tableId.getProject());
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    Span testIamPermissions = null;
    if (getOptions().isOpenTelemetryTracingEnabled()
        && getOptions().getOpenTelemetryTracer() != null) {
      testIamPermissions =
          getOptions()
              .getOpenTelemetryTracer()
              .spanBuilder("com.google.cloud.bigquery.BigQuery.testIamPermissions")
              .setAllAttributes(tableId.getOtelAttributes())
              .setAttribute("bq.iam.permissions", permissions.toString())
              .setAllAttributes(otelAttributesFromOptions(options))
              .startSpan();
    }
    try (Scope testIamPermissionsScope =
        testIamPermissions != null ? testIamPermissions.makeCurrent() : null) {
      com.google.api.services.bigquery.model.TestIamPermissionsResponse response =
          BigQueryRetryHelper.runWithRetries(
              new Callable<com.google.api.services.bigquery.model.TestIamPermissionsResponse>() {
                @Override
                public com.google.api.services.bigquery.model.TestIamPermissionsResponse call()
                    throws IOException {
                  return bigQueryRpc.testIamPermissionsSkipExceptionTranslation(
                      completeTableId.getIAMResourceName(), permissions, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock(),
              EMPTY_RETRY_CONFIG);
      return response.getPermissions() == null
          ? ImmutableList.of()
          : ImmutableList.copyOf(response.getPermissions());
    } catch (BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    } finally {
      if (testIamPermissions != null) {
        testIamPermissions.end();
      }
    }
  }

  @VisibleForTesting
  static Map<BigQueryRpc.Option, ?> optionMap(Option... options) {
    Map<BigQueryRpc.Option, Object> optionMap = Maps.newEnumMap(BigQueryRpc.Option.class);
    for (Option option : options) {
      Object prev = optionMap.put(option.getRpcOption(), option.getValue());
      checkArgument(prev == null, "Duplicate option %s", option);
    }
    return optionMap;
  }

  private static String getFieldAsString(Object field) {
    return field == null ? "null" : field.toString();
  }

  private static Attributes otelAttributesFromOptions(Option... options) {
    Attributes attributes = Attributes.builder().build();
    for (Option option : options) {
      attributes =
          attributes.toBuilder()
              .put("bq.option." + option.getRpcOption().toString(), option.getValue().toString())
              .build();
    }
    return attributes;
  }

  private static Attributes otelAttributesFromQueryRequest(QueryRequest request) {
    return Attributes.builder()
        .put("bq.query.dry_run", getFieldAsString(request.getDryRun()))
        .put("bq.query.job_creation_mode", getFieldAsString(request.getJobCreationMode()))
        .put("bq.query.kind", getFieldAsString(request.getKind()))
        .put("bq.query.location", getFieldAsString(request.getLocation()))
        .put("bq.query.request_id", getFieldAsString(request.getRequestId()))
        .put("bq.query.use_query_cache", getFieldAsString(request.getUseQueryCache()))
        .build();
  }

  private static Attributes otelAttributesFromPolicy(Policy policy) {
    return Attributes.builder()
        .put("bq.policy.version", getFieldAsString(policy.getVersion()))
        .put("bq.policy.bindings", getFieldAsString(policy.getBindings()))
        .build();
  }

  static BigQueryRetryConfig getBigQueryRetryConfig(Map<BigQueryRpc.Option, ?> options) {
    return (BigQueryRetryConfig)
        options.getOrDefault(BigQueryRpc.Option.BIGQUERY_RETRY_CONFIG, null);
  }

  static RetryOption[] getRetryOptions(Map<BigQueryRpc.Option, ?> options) {
    return (RetryOption[]) options.getOrDefault(BigQueryRpc.Option.RETRY_OPTIONS, null);
  }

  private static boolean isRetryErrorCodeHttpNotFound(BigQueryRetryHelperException e) {
    if (e.getCause() instanceof BigQueryException) {
      if (((BigQueryException) e.getCause()).getCode() == HTTP_NOT_FOUND) {
        return true;
      }
    }
    return false;
  }
}
