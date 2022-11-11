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

import static com.google.cloud.RetryHelper.runWithRetries;
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
import com.google.cloud.RetryHelper;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.Tuple;
import com.google.cloud.bigquery.InsertAllRequest.RowToInsert;
import com.google.cloud.bigquery.spi.v2.BigQueryRpc;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
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

  private final BigQueryRpc bigQueryRpc;
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
    try {
      return Dataset.fromPb(
          this,
          runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Dataset>() {
                @Override
                public com.google.api.services.bigquery.model.Dataset call() {
                  return bigQueryRpc.create(datasetPb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
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
    try {
      return Table.fromPb(
          this,
          runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Table>() {
                @Override
                public com.google.api.services.bigquery.model.Table call() {
                  return bigQueryRpc.create(tablePb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
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
    try {
      return Routine.fromPb(
          this,
          runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Routine>() {
                @Override
                public com.google.api.services.bigquery.model.Routine call() {
                  return bigQueryRpc.create(routinePb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
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
    BigQueryException createException;
    // NOTE(pongad): This double-try structure is admittedly odd.
    // translateAndThrow itself throws, and pretends to return an exception only
    // so users can pretend to throw.
    // This makes it difficult to translate without throwing.
    // Fixing this entails some work on BaseServiceException.translate.
    // Since that affects a bunch of APIs, we should fix this as a separate change.
    final JobId[] finalJobId = new JobId[1];
    try {
      try {
        return Job.fromPb(
            this,
            BigQueryRetryHelper.runWithRetries(
                new Callable<com.google.api.services.bigquery.model.Job>() {
                  @Override
                  public com.google.api.services.bigquery.model.Job call() {
                    if (idRandom) {
                      // re-generate a new random job with the same jobInfo when jobId is not
                      // provided by the user
                      JobInfo recreatedJobInfo =
                          jobInfo.toBuilder().setJobId(idProvider.get()).build();
                      com.google.api.services.bigquery.model.Job newJobPb =
                          recreatedJobInfo.setProjectId(getOptions().getProjectId()).toPb();
                      finalJobId[0] = recreatedJobInfo.getJobId();
                      return bigQueryRpc.create(newJobPb, optionsMap);
                    } else {
                      com.google.api.services.bigquery.model.Job jobPb =
                          jobInfo.setProjectId(getOptions().getProjectId()).toPb();
                      return bigQueryRpc.create(jobPb, optionsMap);
                    }
                  }
                },
                getOptions().getRetrySettings(),
                EXCEPTION_HANDLER,
                getOptions().getClock(),
                DEFAULT_RETRY_CONFIG));
      } catch (BigQueryRetryHelper.BigQueryRetryHelperException e) {
        throw BigQueryException.translateAndThrow(e);
      }
    } catch (BigQueryException e) {
      createException = e;
    }

    if (!idRandom) {
      throw createException;
    }

    // If create RPC fails, it's still possible that the job has been successfully
    // created,
    // and get might work.
    // We can only do this if we randomly generated the ID. Otherwise we might
    // mistakenly
    // fetch a job created by someone else.
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
  }

  @Override
  public Dataset getDataset(String datasetId, DatasetOption... options) {
    return getDataset(DatasetId.of(datasetId), options);
  }

  @Override
  public Dataset getDataset(final DatasetId datasetId, DatasetOption... options) {
    final DatasetId completeDatasetId = datasetId.setProjectId(getOptions().getProjectId());
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.bigquery.model.Dataset answer =
          runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Dataset>() {
                @Override
                public com.google.api.services.bigquery.model.Dataset call() {
                  return bigQueryRpc.getDataset(
                      completeDatasetId.getProject(), completeDatasetId.getDataset(), optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock());
      if (getOptions().getThrowNotFound() && answer == null) {
        throw new BigQueryException(HTTP_NOT_FOUND, "Dataset not found");
      }
      return answer == null ? null : Dataset.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public Page<Dataset> listDatasets(DatasetListOption... options) {
    return listDatasets(getOptions().getProjectId(), options);
  }

  @Override
  public Page<Dataset> listDatasets(String projectId, DatasetListOption... options) {
    return listDatasets(projectId, getOptions(), optionMap(options));
  }

  private static Page<Dataset> listDatasets(
      final String projectId,
      final BigQueryOptions serviceOptions,
      final Map<BigQueryRpc.Option, ?> optionsMap) {
    try {
      Tuple<String, Iterable<com.google.api.services.bigquery.model.Dataset>> result =
          runWithRetries(
              new Callable<
                  Tuple<String, Iterable<com.google.api.services.bigquery.model.Dataset>>>() {
                @Override
                public Tuple<String, Iterable<com.google.api.services.bigquery.model.Dataset>>
                    call() {
                  return serviceOptions.getBigQueryRpcV2().listDatasets(projectId, optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              serviceOptions.getClock());
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
    } catch (RetryHelper.RetryHelperException e) {
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
    try {
      return runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() {
              return bigQueryRpc.deleteDataset(
                  completeDatasetId.getProject(), completeDatasetId.getDataset(), optionsMap);
            }
          },
          getOptions().getRetrySettings(),
          BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
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
    try {
      return runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() {
              return bigQueryRpc.deleteTable(
                  completeTableId.getProject(),
                  completeTableId.getDataset(),
                  completeTableId.getTable());
            }
          },
          getOptions().getRetrySettings(),
          BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public boolean delete(ModelId modelId) {
    final ModelId completeModelId =
        modelId.setProjectId(
            Strings.isNullOrEmpty(modelId.getProject())
                ? getOptions().getProjectId()
                : modelId.getProject());
    try {
      return runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() {
              return bigQueryRpc.deleteModel(
                  completeModelId.getProject(),
                  completeModelId.getDataset(),
                  completeModelId.getModel());
            }
          },
          getOptions().getRetrySettings(),
          BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public boolean delete(RoutineId routineId) {
    final RoutineId completeRoutineId =
        routineId.setProjectId(
            Strings.isNullOrEmpty(routineId.getProject())
                ? getOptions().getProjectId()
                : routineId.getProject());
    try {
      return runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() {
              return bigQueryRpc.deleteRoutine(
                  completeRoutineId.getProject(),
                  completeRoutineId.getDataset(),
                  completeRoutineId.getRoutine());
            }
          },
          getOptions().getRetrySettings(),
          BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public boolean delete(JobId jobId) {
    final JobId completeJobId =
        jobId.setProjectId(
            Strings.isNullOrEmpty(jobId.getProject())
                ? getOptions().getProjectId()
                : jobId.getProject());
    try {
      return runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() {
              return bigQueryRpc.deleteJob(
                  completeJobId.getProject(), completeJobId.getJob(), completeJobId.getLocation());
            }
          },
          getOptions().getRetrySettings(),
          BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public Dataset update(DatasetInfo datasetInfo, DatasetOption... options) {
    final com.google.api.services.bigquery.model.Dataset datasetPb =
        datasetInfo.setProjectId(getOptions().getProjectId()).toPb();
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    try {
      return Dataset.fromPb(
          this,
          runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Dataset>() {
                @Override
                public com.google.api.services.bigquery.model.Dataset call() {
                  return bigQueryRpc.patch(datasetPb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
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
    try {
      return Table.fromPb(
          this,
          runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Table>() {
                @Override
                public com.google.api.services.bigquery.model.Table call() {
                  return bigQueryRpc.patch(tablePb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
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
    try {
      return Model.fromPb(
          this,
          runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Model>() {
                @Override
                public com.google.api.services.bigquery.model.Model call() {
                  return bigQueryRpc.patch(modelPb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
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
    try {
      return Routine.fromPb(
          this,
          runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Routine>() {
                @Override
                public com.google.api.services.bigquery.model.Routine call() {
                  return bigQueryRpc.update(routinePb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
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
    try {
      com.google.api.services.bigquery.model.Table answer =
          runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Table>() {
                @Override
                public com.google.api.services.bigquery.model.Table call() {
                  return bigQueryRpc.getTable(
                      completeTableId.getProject(),
                      completeTableId.getDataset(),
                      completeTableId.getTable(),
                      optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock());
      if (getOptions().getThrowNotFound() && answer == null) {
        throw new BigQueryException(HTTP_NOT_FOUND, "Table not found");
      }
      return answer == null ? null : Table.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
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
    try {
      com.google.api.services.bigquery.model.Model answer =
          runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Model>() {
                @Override
                public com.google.api.services.bigquery.model.Model call() {
                  return bigQueryRpc.getModel(
                      completeModelId.getProject(),
                      completeModelId.getDataset(),
                      completeModelId.getModel(),
                      optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock());
      if (getOptions().getThrowNotFound() && answer == null) {
        throw new BigQueryException(HTTP_NOT_FOUND, "Model not found");
      }
      return answer == null ? null : Model.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
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
    try {
      com.google.api.services.bigquery.model.Routine answer =
          runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Routine>() {
                @Override
                public com.google.api.services.bigquery.model.Routine call() {
                  return bigQueryRpc.getRoutine(
                      completeRoutineId.getProject(),
                      completeRoutineId.getDataset(),
                      completeRoutineId.getRoutine(),
                      optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock());
      if (getOptions().getThrowNotFound() && answer == null) {
        throw new BigQueryException(HTTP_NOT_FOUND, "Routine not found");
      }
      return answer == null ? null : Routine.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public Page<Table> listTables(String datasetId, TableListOption... options) {
    return listTables(
        DatasetId.of(getOptions().getProjectId(), datasetId), getOptions(), optionMap(options));
  }

  @Override
  public Page<Table> listTables(DatasetId datasetId, TableListOption... options) {
    DatasetId completeDatasetId = datasetId.setProjectId(getOptions().getProjectId());
    return listTables(completeDatasetId, getOptions(), optionMap(options));
  }

  @Override
  public Page<Model> listModels(String datasetId, ModelListOption... options) {
    return listModels(
        DatasetId.of(getOptions().getProjectId(), datasetId), getOptions(), optionMap(options));
  }

  @Override
  public Page<Model> listModels(DatasetId datasetId, ModelListOption... options) {
    DatasetId completeDatasetId = datasetId.setProjectId(getOptions().getProjectId());
    return listModels(completeDatasetId, getOptions(), optionMap(options));
  }

  @Override
  public Page<Routine> listRoutines(String datasetId, RoutineListOption... options) {
    return listRoutines(
        DatasetId.of(getOptions().getProjectId(), datasetId), getOptions(), optionMap(options));
  }

  @Override
  public Page<Routine> listRoutines(DatasetId datasetId, RoutineListOption... options) {
    DatasetId completeDatasetId = datasetId.setProjectId(getOptions().getProjectId());
    return listRoutines(completeDatasetId, getOptions(), optionMap(options));
  }

  @Override
  public List<String> listPartitions(TableId tableId) {
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
  }

  private static Page<Table> listTables(
      final DatasetId datasetId,
      final BigQueryOptions serviceOptions,
      final Map<BigQueryRpc.Option, ?> optionsMap) {
    try {
      Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>> result =
          runWithRetries(
              new Callable<
                  Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>>>() {
                @Override
                public Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>>
                    call() {
                  return serviceOptions
                      .getBigQueryRpcV2()
                      .listTables(datasetId.getProject(), datasetId.getDataset(), optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              serviceOptions.getClock());
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
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  private static Page<Model> listModels(
      final DatasetId datasetId,
      final BigQueryOptions serviceOptions,
      final Map<BigQueryRpc.Option, ?> optionsMap) {
    try {
      Tuple<String, Iterable<com.google.api.services.bigquery.model.Model>> result =
          runWithRetries(
              new Callable<
                  Tuple<String, Iterable<com.google.api.services.bigquery.model.Model>>>() {
                @Override
                public Tuple<String, Iterable<com.google.api.services.bigquery.model.Model>>
                    call() {
                  return serviceOptions
                      .getBigQueryRpcV2()
                      .listModels(datasetId.getProject(), datasetId.getDataset(), optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              serviceOptions.getClock());
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
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  private static Page<Routine> listRoutines(
      final DatasetId datasetId,
      final BigQueryOptions serviceOptions,
      final Map<BigQueryRpc.Option, ?> optionsMap) {
    try {
      Tuple<String, Iterable<com.google.api.services.bigquery.model.Routine>> result =
          runWithRetries(
              new Callable<
                  Tuple<String, Iterable<com.google.api.services.bigquery.model.Routine>>>() {
                @Override
                public Tuple<String, Iterable<com.google.api.services.bigquery.model.Routine>>
                    call() {
                  return serviceOptions
                      .getBigQueryRpcV2()
                      .listRoutines(datasetId.getProject(), datasetId.getDataset(), optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              serviceOptions.getClock());
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
    } catch (RetryHelper.RetryHelperException e) {
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
    if (allInsertIdsSet[0]) {
      // allowing retries only if all row insertIds are set (used for deduplication)
      try {
        responsePb =
            runWithRetries(
                new Callable<TableDataInsertAllResponse>() {
                  @Override
                  public TableDataInsertAllResponse call() throws Exception {
                    return bigQueryRpc.insertAll(
                        tableId.getProject(), tableId.getDataset(), tableId.getTable(), requestPb);
                  }
                },
                getOptions().getRetrySettings(),
                BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
                getOptions().getClock());
      } catch (RetryHelperException e) {
        throw BigQueryException.translateAndThrow(e);
      }
    } else {
      responsePb =
          bigQueryRpc.insertAll(
              tableId.getProject(), tableId.getDataset(), tableId.getTable(), requestPb);
    }

    return InsertAllResponse.fromPb(responsePb);
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
    return new TableResult(schema, data.y(), data.x());
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
          runWithRetries(
              new Callable<TableDataList>() {
                @Override
                public TableDataList call() {
                  return serviceOptions
                      .getBigQueryRpcV2()
                      .listTableData(
                          completeTableId.getProject(),
                          completeTableId.getDataset(),
                          completeTableId.getTable(),
                          optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              serviceOptions.getClock());
      String cursor = result.getPageToken();
      Map<BigQueryRpc.Option, ?> pageOptionMap =
          Strings.isNullOrEmpty(cursor) ? optionsMap : optionMap(TableDataListOption.startIndex(0));
      return Tuple.of(
          new PageImpl<>(
              new TableDataPageFetcher(tableId, schema, serviceOptions, cursor, pageOptionMap),
              cursor,
              transformTableData(result.getRows(), schema)),
          result.getTotalRows());
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  private static Iterable<FieldValueList> transformTableData(
      Iterable<TableRow> tableDataPb, final Schema schema) {
    return ImmutableList.copyOf(
        Iterables.transform(
            tableDataPb != null ? tableDataPb : ImmutableList.<TableRow>of(),
            new Function<TableRow, FieldValueList>() {
              FieldList fields = schema != null ? schema.getFields() : null;

              @Override
              public FieldValueList apply(TableRow rowPb) {
                return FieldValueList.fromPb(rowPb.getF(), fields);
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
    try {
      com.google.api.services.bigquery.model.Job answer =
          runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Job>() {
                @Override
                public com.google.api.services.bigquery.model.Job call() {
                  return bigQueryRpc.getJob(
                      completeJobId.getProject(),
                      completeJobId.getJob(),
                      completeJobId.getLocation(),
                      optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock());
      if (getOptions().getThrowNotFound() && answer == null) {
        throw new BigQueryException(HTTP_NOT_FOUND, "Job not found");
      }
      return answer == null ? null : Job.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public Page<Job> listJobs(JobListOption... options) {
    return listJobs(getOptions(), optionMap(options));
  }

  private static Page<Job> listJobs(
      final BigQueryOptions serviceOptions, final Map<BigQueryRpc.Option, ?> optionsMap) {
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Job>> result =
        runWithRetries(
            new Callable<Tuple<String, Iterable<com.google.api.services.bigquery.model.Job>>>() {
              @Override
              public Tuple<String, Iterable<com.google.api.services.bigquery.model.Job>> call() {
                return serviceOptions
                    .getBigQueryRpcV2()
                    .listJobs(serviceOptions.getProjectId(), optionsMap);
              }
            },
            serviceOptions.getRetrySettings(),
            BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
            serviceOptions.getClock());
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
    try {
      return runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() {
              return bigQueryRpc.cancel(
                  completeJobId.getProject(), completeJobId.getJob(), completeJobId.getLocation());
            }
          },
          getOptions().getRetrySettings(),
          BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public TableResult query(QueryJobConfiguration configuration, JobOption... options)
      throws InterruptedException, JobException {
    Job.checkNotDryRun(configuration, "query");

    // If all parameters passed in configuration are supported by the query() method on the backend,
    // put on fast path
    QueryRequestInfo requestInfo = new QueryRequestInfo(configuration);
    if (requestInfo.isFastQuerySupported(null)) {
      String projectId = getOptions().getProjectId();
      QueryRequest content = requestInfo.toPb();
      return queryRpc(projectId, content, options);
    }
    // Otherwise, fall back to the existing create query job logic
    return create(JobInfo.of(configuration), options).getQueryResults();
  }

  private TableResult queryRpc(
      final String projectId, final QueryRequest content, JobOption... options)
      throws InterruptedException {
    com.google.api.services.bigquery.model.QueryResponse results;
    try {
      results =
          BigQueryRetryHelper.runWithRetries(
              new Callable<com.google.api.services.bigquery.model.QueryResponse>() {
                @Override
                public com.google.api.services.bigquery.model.QueryResponse call() {
                  return bigQueryRpc.queryRpc(projectId, content);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock(),
              DEFAULT_RETRY_CONFIG);
    } catch (BigQueryRetryHelper.BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }

    if (results.getErrors() != null) {
      List<BigQueryError> bigQueryErrors =
          Lists.transform(results.getErrors(), BigQueryError.FROM_PB_FUNCTION);
      // Throwing BigQueryException since there may be no JobId and we want to stay consistent
      // with the case where there there is a HTTP error
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
      return new TableResult(
          schema,
          numRows,
          new PageImpl<>(
              // fetch next pages of results
              new QueryPageFetcher(jobId, schema, getOptions(), cursor, optionMap(options)),
              cursor,
              // cache first page of result
              transformTableData(results.getRows(), schema)));
    }
    // only 1 page of result
    return new TableResult(
        schema,
        numRows,
        new PageImpl<>(
            new TableDataPageFetcher(null, schema, getOptions(), null, optionMap(options)),
            null,
            transformTableData(results.getRows(), schema)));
  }

  @Override
  public TableResult query(QueryJobConfiguration configuration, JobId jobId, JobOption... options)
      throws InterruptedException, JobException {
    Job.checkNotDryRun(configuration, "query");
    // If all parameters passed in configuration are supported by the query() method on the backend,
    // put on fast path
    QueryRequestInfo requestInfo = new QueryRequestInfo(configuration);
    if (requestInfo.isFastQuerySupported(jobId)) {
      // Be careful when setting the projectID in JobId, if a projectID is specified in the JobId,
      // the job created by the query method will use that project. This may cause the query to
      // fail with "Access denied" if the project do not have enough permissions to run the job.

      String projectId =
          jobId.getProject() != null ? jobId.getProject() : getOptions().getProjectId();
      QueryRequest content = requestInfo.toPb();
      // Be careful when setting the location in JobId, if a location is specified in the JobId,
      // the job created by the query method will be in that location, even if the table to be
      // queried is in a different location. This may cause the query to fail with
      // "BigQueryException: Not found"
      if (jobId.getLocation() != null) {
        content.setLocation(jobId.getLocation());
      }

      return queryRpc(projectId, content, options);
    }
    return create(JobInfo.of(jobId, configuration), options).getQueryResults();
  }

  @Override
  public QueryResponse getQueryResults(JobId jobId, QueryResultsOption... options) {
    Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    return getQueryResults(jobId, getOptions(), optionsMap);
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
                public GetQueryResultsResponse call() {
                  return serviceOptions
                      .getBigQueryRpcV2()
                      .getQueryResults(
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
    } catch (BigQueryRetryHelper.BigQueryRetryHelperException e) {
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

    try {
      final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
      return convertFromApiPolicy(
          runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Policy>() {
                @Override
                public com.google.api.services.bigquery.model.Policy call() {
                  return bigQueryRpc.getIamPolicy(completeTableId.getIAMResourceName(), optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public Policy setIamPolicy(TableId tableId, final Policy policy, IAMOption... options) {
    final TableId completeTableId =
        tableId.setProjectId(
            Strings.isNullOrEmpty(tableId.getProject())
                ? getOptions().getProjectId()
                : tableId.getProject());
    try {
      final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
      return convertFromApiPolicy(
          runWithRetries(
              new Callable<com.google.api.services.bigquery.model.Policy>() {
                @Override
                public com.google.api.services.bigquery.model.Policy call() {
                  return bigQueryRpc.setIamPolicy(
                      completeTableId.getIAMResourceName(), convertToApiPolicy(policy), optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
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
    try {
      final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
      com.google.api.services.bigquery.model.TestIamPermissionsResponse response =
          runWithRetries(
              new Callable<com.google.api.services.bigquery.model.TestIamPermissionsResponse>() {
                @Override
                public com.google.api.services.bigquery.model.TestIamPermissionsResponse call() {
                  return bigQueryRpc.testIamPermissions(
                      completeTableId.getIAMResourceName(), permissions, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              getOptions().getClock());
      return response.getPermissions() == null
          ? ImmutableList.of()
          : ImmutableList.copyOf(response.getPermissions());
    } catch (RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
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
}
