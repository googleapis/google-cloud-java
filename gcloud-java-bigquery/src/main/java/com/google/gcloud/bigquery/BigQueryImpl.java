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

package com.google.gcloud.bigquery;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.gcloud.RetryHelper.runWithRetries;
import static java.util.concurrent.Executors.callable;

import com.google.api.services.bigquery.model.Dataset;
import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.google.api.services.bigquery.model.Job;
import com.google.api.services.bigquery.model.Table;
import com.google.api.services.bigquery.model.TableDataInsertAllRequest;
import com.google.api.services.bigquery.model.TableDataInsertAllRequest.Rows;
import com.google.api.services.bigquery.model.TableReference;
import com.google.api.services.bigquery.model.TableRow;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gcloud.BaseService;
import com.google.gcloud.ExceptionHandler;
import com.google.gcloud.ExceptionHandler.Interceptor;
import com.google.gcloud.Page;
import com.google.gcloud.PageImpl;
import com.google.gcloud.PageImpl.NextPageFetcher;
import com.google.gcloud.RetryHelper;
import com.google.gcloud.bigquery.InsertAllRequest.RowToInsert;
import com.google.gcloud.spi.BigQueryRpc;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

final class BigQueryImpl extends BaseService<BigQueryOptions> implements BigQuery {

  private static final Interceptor EXCEPTION_HANDLER_INTERCEPTOR = new Interceptor() {

    private static final long serialVersionUID = -7478333733015750774L;

    @Override
    public RetryResult afterEval(Exception exception, RetryResult retryResult) {
      return Interceptor.RetryResult.CONTINUE_EVALUATION;
    }

    @Override
    public RetryResult beforeEval(Exception exception) {
      if (exception instanceof BigQueryException) {
        boolean retriable = ((BigQueryException) exception).retryable();
        return retriable ? Interceptor.RetryResult.RETRY : Interceptor.RetryResult.NO_RETRY;
      }
      return Interceptor.RetryResult.CONTINUE_EVALUATION;
    }
  };
  static final ExceptionHandler EXCEPTION_HANDLER = ExceptionHandler.builder()
      .abortOn(RuntimeException.class).interceptor(EXCEPTION_HANDLER_INTERCEPTOR).build();

  private static class DatasetPageFetcher implements NextPageFetcher<DatasetInfo> {

    private static final long serialVersionUID = -3057564042439021278L;
    private final Map<BigQueryRpc.Option, ?> requestOptions;
    private final BigQueryOptions serviceOptions;

    DatasetPageFetcher(BigQueryOptions serviceOptions, String cursor,
        Map<BigQueryRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(BigQueryRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<DatasetInfo> nextPage() {
      return listDatasets(serviceOptions, requestOptions);
    }
  }

  private static class TablePageFetcher implements NextPageFetcher<BaseTableInfo> {

    private static final long serialVersionUID = 8611248840504201187L;
    private final Map<BigQueryRpc.Option, ?> requestOptions;
    private final BigQueryOptions serviceOptions;
    private final String dataset;

    TablePageFetcher(String dataset, BigQueryOptions serviceOptions, String cursor,
        Map<BigQueryRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(BigQueryRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.dataset = dataset;
    }

    @Override
    public Page<BaseTableInfo> nextPage() {
      return listTables(dataset, serviceOptions, requestOptions);
    }
  }

  private static class JobPageFetcher implements NextPageFetcher<JobInfo> {

    private static final long serialVersionUID = 8536533282558245472L;
    private final Map<BigQueryRpc.Option, ?> requestOptions;
    private final BigQueryOptions serviceOptions;

    JobPageFetcher(BigQueryOptions serviceOptions, String cursor,
        Map<BigQueryRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(BigQueryRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<JobInfo> nextPage() {
      return listJobs(serviceOptions, requestOptions);
    }
  }

  private static class TableDataPageFetcher implements NextPageFetcher<List<FieldValue>> {

    private static final long serialVersionUID = -8501991114794410114L;
    private final Map<BigQueryRpc.Option, ?> requestOptions;
    private final BigQueryOptions serviceOptions;
    private final TableId table;

    TableDataPageFetcher(TableId table, BigQueryOptions serviceOptions, String cursor,
        Map<BigQueryRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(BigQueryRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.table = table;
    }

    @Override
    public Page<List<FieldValue>> nextPage() {
      return listTableData(table, serviceOptions, requestOptions);
    }
  }

  private static class QueryResultsPageFetcherImpl
      implements NextPageFetcher<List<FieldValue>>, QueryResult.QueryResultsPageFetcher {

    private static final long serialVersionUID = -9198905840550459803L;
    private final Map<BigQueryRpc.Option, ?> requestOptions;
    private final BigQueryOptions serviceOptions;
    private final JobId job;

    QueryResultsPageFetcherImpl(JobId job, BigQueryOptions serviceOptions, String cursor,
        Map<BigQueryRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(BigQueryRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.job = job;
    }

    @Override
    public QueryResult nextPage() {
      return getQueryResults(job, serviceOptions, requestOptions).result();
    }
  }

  private final BigQueryRpc bigQueryRpc;

  BigQueryImpl(BigQueryOptions options) {
    super(options);
    bigQueryRpc = options.rpc();
  }

  @Override
  public DatasetInfo create(DatasetInfo dataset, DatasetOption... options)
      throws BigQueryException {
    final Dataset datasetPb = setProjectId(dataset).toPb();
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    try {
      return DatasetInfo.fromPb(runWithRetries(new Callable<Dataset>() {
        @Override
        public Dataset call() {
          return bigQueryRpc.create(datasetPb, optionsMap);
        }
      }, options().retryParams(), EXCEPTION_HANDLER));
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public <T extends BaseTableInfo> T create(T table, TableOption... options)
      throws BigQueryException {
    final Table tablePb = setProjectId(table).toPb();
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    try {
      return BaseTableInfo.fromPb(runWithRetries(new Callable<Table>() {
        @Override
        public Table call() {
          return bigQueryRpc.create(tablePb, optionsMap);
        }
      }, options().retryParams(), EXCEPTION_HANDLER));
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public <T extends JobInfo> T create(T job, JobOption... options) throws BigQueryException {
    final Job jobPb = setProjectId(job).toPb();
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    try {
      return JobInfo.fromPb(runWithRetries(new Callable<Job>() {
        @Override
        public Job call() {
          return bigQueryRpc.create(jobPb, optionsMap);
        }
      }, options().retryParams(), EXCEPTION_HANDLER));
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public DatasetInfo getDataset(String datasetId, DatasetOption... options)
      throws BigQueryException {
    return getDataset(DatasetId.of(datasetId), options);
  }

  @Override
  public DatasetInfo getDataset(final DatasetId datasetId, DatasetOption... options)
      throws BigQueryException {
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    try {
      Dataset answer = runWithRetries(new Callable<Dataset>() {
        @Override
        public Dataset call() {
          return bigQueryRpc.getDataset(datasetId.dataset(), optionsMap);
        }
      }, options().retryParams(), EXCEPTION_HANDLER);
      return answer == null ? null : DatasetInfo.fromPb(answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public Page<DatasetInfo> listDatasets(DatasetListOption... options) throws BigQueryException {
    return listDatasets(options(), optionMap(options));
  }

  private static Page<DatasetInfo> listDatasets(final BigQueryOptions serviceOptions,
      final Map<BigQueryRpc.Option, ?> optionsMap) {
    try {
      BigQueryRpc.Tuple<String, Iterable<Dataset>> result =
          runWithRetries(new Callable<BigQueryRpc.Tuple<String, Iterable<Dataset>>>() {
            @Override
            public BigQueryRpc.Tuple<String, Iterable<Dataset>> call() {
              return serviceOptions.rpc().listDatasets(optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER);
      String cursor = result.x();
      return new PageImpl<>(new DatasetPageFetcher(serviceOptions, cursor, optionsMap), cursor,
          Iterables.transform(result.y(), DatasetInfo.FROM_PB_FUNCTION));
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public boolean delete(String datasetId, DatasetDeleteOption... options) throws BigQueryException {
    return delete(DatasetId.of(datasetId), options);
  }

  @Override
  public boolean delete(final DatasetId datasetId, DatasetDeleteOption... options)
      throws BigQueryException {
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    try {
      return runWithRetries(new Callable<Boolean>() {
        @Override
        public Boolean call() {
          return bigQueryRpc.deleteDataset(datasetId.dataset(), optionsMap);
        }
      }, options().retryParams(), EXCEPTION_HANDLER);
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public boolean delete(String datasetId, String tableId) throws BigQueryException {
    return delete(TableId.of(datasetId, tableId));
  }

  @Override
  public boolean delete(final TableId tableId) throws BigQueryException {
    try {
      return runWithRetries(new Callable<Boolean>() {
        @Override
        public Boolean call() {
          return bigQueryRpc.deleteTable(tableId.dataset(), tableId.table());
        }
      }, options().retryParams(), EXCEPTION_HANDLER);
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public DatasetInfo update(DatasetInfo dataset, DatasetOption... options)
      throws BigQueryException {
    final Dataset datasetPb = setProjectId(dataset).toPb();
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    try {
      return DatasetInfo.fromPb(runWithRetries(new Callable<Dataset>() {
        @Override
        public Dataset call() {
          return bigQueryRpc.patch(datasetPb, optionsMap);
        }
      }, options().retryParams(), EXCEPTION_HANDLER));
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public <T extends BaseTableInfo> T update(T table, TableOption... options)
      throws BigQueryException {
    final Table tablePb = setProjectId(table).toPb();
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    try {
      return BaseTableInfo.fromPb(runWithRetries(new Callable<Table>() {
        @Override
        public Table call() {
          return bigQueryRpc.patch(tablePb, optionsMap);
        }
      }, options().retryParams(), EXCEPTION_HANDLER));
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public <T extends BaseTableInfo> T getTable(final String datasetId, final String tableId,
      TableOption... options) throws BigQueryException {
    return getTable(TableId.of(datasetId, tableId), options);
  }

  @Override
  public <T extends BaseTableInfo> T getTable(final TableId tableId, TableOption... options)
      throws BigQueryException {
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    try {
      Table answer = runWithRetries(new Callable<Table>() {
        @Override
        public Table call() {
          return bigQueryRpc.getTable(tableId.dataset(), tableId.table(), optionsMap);
        }
      }, options().retryParams(), EXCEPTION_HANDLER);
      return answer == null ? null : BaseTableInfo.<T>fromPb(answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public Page<BaseTableInfo> listTables(String datasetId, TableListOption... options)
      throws BigQueryException {
    return listTables(datasetId, options(), optionMap(options));
  }

  @Override
  public Page<BaseTableInfo> listTables(DatasetId datasetId, TableListOption... options)
      throws BigQueryException {
    return listTables(datasetId.dataset(), options(), optionMap(options));
  }

  private static Page<BaseTableInfo> listTables(final String datasetId, final BigQueryOptions
      serviceOptions, final Map<BigQueryRpc.Option, ?> optionsMap) {
    try {
      BigQueryRpc.Tuple<String, Iterable<Table>> result =
          runWithRetries(new Callable<BigQueryRpc.Tuple<String, Iterable<Table>>>() {
            @Override
            public BigQueryRpc.Tuple<String, Iterable<Table>> call() {
              return serviceOptions.rpc().listTables(datasetId, optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER);
      String cursor = result.x();
      Iterable<BaseTableInfo> tables = Iterables.transform(result.y(),
          BaseTableInfo.FROM_PB_FUNCTION);
      return new PageImpl<>(new TablePageFetcher(datasetId, serviceOptions, cursor, optionsMap),
          cursor, tables);
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public InsertAllResponse insertAll(InsertAllRequest request) throws BigQueryException {
    final TableId tableId = request.table();
    final TableDataInsertAllRequest requestPb = new TableDataInsertAllRequest();
    requestPb.setIgnoreUnknownValues(request.ignoreUnknownValues());
    requestPb.setSkipInvalidRows(request.skipInvalidRows());
    requestPb.setTemplateSuffix(request.templateSuffix());
    List<Rows> rowsPb = Lists.transform(request.rows(), new Function<RowToInsert, Rows>() {
      @Override
      public Rows apply(RowToInsert rowToInsert) {
        return new Rows().setInsertId(rowToInsert.id()).setJson(rowToInsert.content());
      }
    });
    requestPb.setRows(rowsPb);
    return InsertAllResponse.fromPb(
        bigQueryRpc.insertAll(tableId.dataset(), tableId.table(), requestPb));
  }

  @Override
  public void insertAll(LoadConfiguration configuration, final byte[] content) {
    Function<Long, InputStream> nextStream = new Function<Long, InputStream>() {
      @Override
      public InputStream apply(Long startPos) {
        return new ByteArrayInputStream(content, startPos.intValue(), content.length);
      }
    };
    insertAll(configuration, nextStream);
  }

  @Override
  public void insertAll(LoadConfiguration configuration, final SeekableByteChannel channel) {
    Function<Long, InputStream> nextStream = new Function<Long, InputStream>() {
      @Override
      public InputStream apply(Long startPos) {
        try {
          channel.position(startPos);
          return Channels.newInputStream(channel);
        } catch (IOException e) {
          BigQueryException exception = new BigQueryException(0, e.getMessage(), false);
          exception.initCause(e);
          throw exception;
        }
      }
    };
    insertAll(configuration, nextStream);
  }

  private void insertAll(LoadConfiguration configuration,
      final Function<Long, InputStream> nextStream) throws BigQueryException {
    try {
      final String uploadId = open(configuration);
      final AtomicLong startPos = new AtomicLong(0L);
      runWithRetries(callable(new Runnable() {
        @Override
        public void run() {
          try {
            bigQueryRpc.write(uploadId, nextStream.apply(startPos.get()), startPos.get());
          } catch (BigQueryException ex) {
            BigQueryRpc.Tuple<Boolean, Long> uploadStatus = runWithRetries(
                new Callable<BigQueryRpc.Tuple<Boolean, Long>>() {
                  @Override
                  public BigQueryRpc.Tuple<Boolean, Long> call() {
                    return bigQueryRpc.status(uploadId);
                  }
                }, options().retryParams(), EXCEPTION_HANDLER);
            if (!uploadStatus.x()) {
              startPos.set(uploadStatus.y() != null ? uploadStatus.y() + 1 : 0);
              throw new BigQueryException(0, "Resume Incomplete", true);
            }
          }
        }
      }), options().retryParams(), EXCEPTION_HANDLER);
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  private String open(final LoadConfiguration configuration) {
    return runWithRetries(new Callable<String>() {
      @Override
      public String call() {
        return bigQueryRpc.open(setProjectId(configuration).toPb());
      }
    }, options().retryParams(), EXCEPTION_HANDLER);
  }

  @Override
  public Page<List<FieldValue>> listTableData(String datasetId, String tableId,
      TableDataListOption... options) throws BigQueryException {
    return listTableData(TableId.of(datasetId, tableId), options(), optionMap(options));
  }

  @Override
  public Page<List<FieldValue>> listTableData(TableId tableId, TableDataListOption... options)
      throws BigQueryException {
    return listTableData(tableId, options(), optionMap(options));
  }

  private static Page<List<FieldValue>> listTableData(final TableId tableId,
      final BigQueryOptions serviceOptions, final Map<BigQueryRpc.Option, ?> optionsMap) {
    try {
      BigQueryRpc.Tuple<String, Iterable<TableRow>> result =
          runWithRetries(new Callable<BigQueryRpc.Tuple<String, Iterable<TableRow>>>() {
            @Override
            public BigQueryRpc.Tuple<String, Iterable<TableRow>> call() {
              return serviceOptions.rpc()
                  .listTableData(tableId.dataset(), tableId.table(), optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER);
      String cursor = result.x();
      return new PageImpl<>(new TableDataPageFetcher(tableId, serviceOptions, cursor, optionsMap),
          cursor, transformTableData(result.y()));
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  private static List<List<FieldValue>> transformTableData(Iterable<TableRow> tableDataPb) {
    return ImmutableList.copyOf(
        Iterables.transform(tableDataPb != null ? tableDataPb : ImmutableList.<TableRow>of(),
            new Function<TableRow, List<FieldValue>>() {
              @Override
              public List<FieldValue> apply(TableRow rowPb) {
                return Lists.transform(rowPb.getF(), FieldValue.FROM_PB_FUNCTION);
              }
            }));
  }

  @Override
  public <T extends JobInfo> T getJob(String jobId, JobOption... options) throws BigQueryException {
    return getJob(JobId.of(jobId), options);
  }

  @Override
  public <T extends JobInfo> T getJob(final JobId jobId, JobOption... options)
      throws BigQueryException {
    final Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    try {
      Job answer = runWithRetries(new Callable<Job>() {
        @Override
        public Job call() {
          return bigQueryRpc.getJob(jobId.job(), optionsMap);
        }
      }, options().retryParams(), EXCEPTION_HANDLER);
      return answer == null ? null : JobInfo.<T>fromPb(answer);
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public Page<JobInfo> listJobs(JobListOption... options) throws BigQueryException {
    return listJobs(options(), optionMap(options));
  }

  private static Page<JobInfo> listJobs(final BigQueryOptions serviceOptions,
      final Map<BigQueryRpc.Option, ?> optionsMap) {
    BigQueryRpc.Tuple<String, Iterable<Job>> result =
        runWithRetries(new Callable<BigQueryRpc.Tuple<String, Iterable<Job>>>() {
          @Override
          public BigQueryRpc.Tuple<String, Iterable<Job>> call() {
            return serviceOptions.rpc().listJobs(optionsMap);
          }
        }, serviceOptions.retryParams(), EXCEPTION_HANDLER);
    String cursor = result.x();
    Iterable<JobInfo> jobs = Iterables.transform(result.y(), JobInfo.FROM_PB_FUNCTION);
    return new PageImpl<>(new JobPageFetcher(serviceOptions, cursor, optionsMap), cursor, jobs);
  }

  @Override
  public boolean cancel(String jobId) throws BigQueryException {
    return cancel(JobId.of(jobId));
  }

  @Override
  public boolean cancel(final JobId jobId) throws BigQueryException {
    try {
      return runWithRetries(new Callable<Boolean>() {
        @Override
        public Boolean call() {
          return bigQueryRpc.cancel(jobId.job());
        }
      }, options().retryParams(), EXCEPTION_HANDLER);
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public QueryResponse query(final QueryRequest request) throws BigQueryException {
    try {
      com.google.api.services.bigquery.model.QueryResponse results =
          runWithRetries(new Callable<com.google.api.services.bigquery.model.QueryResponse>() {
            @Override
            public com.google.api.services.bigquery.model.QueryResponse call() {
              return bigQueryRpc.query(setProjectId(request).toPb());
            }
          }, options().retryParams(), EXCEPTION_HANDLER);
      QueryResponse.Builder builder = QueryResponse.builder();
      JobId completeJobId = JobId.fromPb(results.getJobReference());
      builder.jobId(completeJobId);
      builder.jobComplete(results.getJobComplete());
      List<TableRow> rowsPb = results.getRows();
      if (results.getJobComplete()) {
        builder.jobComplete(true);
        QueryResult.Builder resultBuilder = transformQueryResults(completeJobId, rowsPb,
            results.getPageToken(), options(), ImmutableMap.<BigQueryRpc.Option, Object>of());
        resultBuilder.totalBytesProcessed(results.getTotalBytesProcessed());
        resultBuilder.cacheHit(results.getCacheHit());
        if (results.getSchema() != null) {
          resultBuilder.schema(Schema.fromPb(results.getSchema()));
        }
        if (results.getTotalRows() != null) {
          resultBuilder.totalRows(results.getTotalRows().longValue());
        }
        builder.result(resultBuilder.build());
      }
      if (results.getErrors() != null) {
        builder.executionErrors(
            Lists.transform(results.getErrors(), BigQueryError.FROM_PB_FUNCTION));
      }
      return builder.build();
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @Override
  public QueryResponse getQueryResults(JobId job, QueryResultsOption... options)
      throws BigQueryException {
    Map<BigQueryRpc.Option, ?> optionsMap = optionMap(options);
    return getQueryResults(job, options(), optionsMap);
  }

  private static QueryResponse getQueryResults(final JobId jobId,
      final BigQueryOptions serviceOptions, final Map<BigQueryRpc.Option, ?> optionsMap) {
    try {
      GetQueryResultsResponse results =
          runWithRetries(new Callable<GetQueryResultsResponse>() {
            @Override
            public GetQueryResultsResponse call() {
              return serviceOptions.rpc().getQueryResults(jobId.job(), optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER);
      QueryResponse.Builder builder = QueryResponse.builder();
      JobId completeJobId = JobId.fromPb(results.getJobReference());
      builder.jobId(completeJobId);
      builder.etag(results.getEtag());
      builder.jobComplete(results.getJobComplete());
      List<TableRow> rowsPb = results.getRows();
      if (results.getJobComplete()) {
        QueryResult.Builder resultBuilder = transformQueryResults(completeJobId, rowsPb,
            results.getPageToken(), serviceOptions, ImmutableMap.<BigQueryRpc.Option, Object>of());
        resultBuilder.totalBytesProcessed(results.getTotalBytesProcessed());
        resultBuilder.cacheHit(results.getCacheHit());
        if (results.getSchema() != null) {
          resultBuilder.schema(Schema.fromPb(results.getSchema()));
        }
        if (results.getTotalRows() != null) {
          resultBuilder.totalRows(results.getTotalRows().longValue());
        }
        builder.result(resultBuilder.build());
      }
      if (results.getErrors() != null) {
        builder.executionErrors(
            Lists.transform(results.getErrors(), BigQueryError.FROM_PB_FUNCTION));
      }
      return builder.build();
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  private static QueryResult.Builder transformQueryResults(JobId jobId, List<TableRow> rowsPb,
      String cursor, BigQueryOptions serviceOptions, Map<BigQueryRpc.Option, ?> optionsMap) {
    QueryResultsPageFetcherImpl nextPageFetcher =
        new QueryResultsPageFetcherImpl(jobId, serviceOptions, cursor, optionsMap);
    return QueryResult.builder()
        .pageFetcher(nextPageFetcher)
        .cursor(cursor)
        .results(transformTableData(rowsPb));
  }

  private Map<BigQueryRpc.Option, ?> optionMap(Option... options) {
    Map<BigQueryRpc.Option, Object> optionMap = Maps.newEnumMap(BigQueryRpc.Option.class);
    for (Option option : options) {
      Object prev = optionMap.put(option.rpcOption(), option.value());
      checkArgument(prev == null, "Duplicate option %s", option);
    }
    return optionMap;
  }

  private DatasetInfo setProjectId(DatasetInfo dataset) {
    DatasetInfo.Builder datasetBuilder = dataset.toBuilder();
    datasetBuilder.datasetId(setProjectId(dataset.datasetId()));
    if (dataset.acl() != null) {
      List<Acl> acls = Lists.newArrayListWithCapacity(dataset.acl().size());
      for (Acl acl : dataset.acl()) {
        if (acl.entity().type() == Acl.Entity.Type.VIEW) {
          Dataset.Access accessPb = acl.toPb();
          TableReference viewReferencePb = accessPb.getView();
          if (viewReferencePb.getProjectId() == null) {
            viewReferencePb.setProjectId(options().projectId());
          }
          acls.add(new Acl(new Acl.View(TableId.fromPb(viewReferencePb))));
        } else {
          acls.add(acl);
        }
      }
      datasetBuilder.acl(acls);
    }
    return datasetBuilder.build();
  }

  private DatasetId setProjectId(DatasetId dataset) {
    return dataset.project() != null ? dataset
        : DatasetId.of(options().projectId(), dataset.dataset());
  }

  private BaseTableInfo setProjectId(BaseTableInfo table) {
    return table.toBuilder().tableId(setProjectId(table.tableId())).build();
  }

  private TableId setProjectId(TableId table) {
    return table.project() != null ? table
        : TableId.of(options().projectId(), table.dataset(), table.table());
  }

  private JobInfo setProjectId(JobInfo job) {
    if (job instanceof CopyJobInfo) {
      CopyJobInfo copyJob = (CopyJobInfo) job;
      CopyJobInfo.Builder copyBuilder = copyJob.toBuilder();
      copyBuilder.destinationTable(setProjectId(copyJob.destinationTable()));
      copyBuilder.sourceTables(
          Lists.transform(copyJob.sourceTables(), new Function<TableId, TableId>() {
            @Override
            public TableId apply(TableId tableId) {
              return setProjectId(tableId);
            }
          }));
      return copyBuilder.build();
    }
    if (job instanceof QueryJobInfo) {
      QueryJobInfo queryJob = (QueryJobInfo) job;
      QueryJobInfo.Builder queryBuilder = queryJob.toBuilder();
      if (queryJob.destinationTable() != null) {
        queryBuilder.destinationTable(setProjectId(queryJob.destinationTable()));
      }
      if (queryJob.defaultDataset() != null) {
        queryBuilder.defaultDataset(setProjectId(queryJob.defaultDataset()));
      }
      return queryBuilder.build();
    }
    if (job instanceof ExtractJobInfo) {
      ExtractJobInfo extractJob = (ExtractJobInfo) job;
      ExtractJobInfo.Builder extractBuilder = extractJob.toBuilder();
      extractBuilder.sourceTable(setProjectId(extractJob.sourceTable()));
      return extractBuilder.build();
    }
    if (job instanceof LoadJobInfo) {
      LoadJobInfo loadJob = (LoadJobInfo) job;
      LoadJobInfo.Builder loadBuilder = loadJob.toBuilder();
      return loadBuilder.configuration(setProjectId(loadJob.configuration())).build();
    }
    return job;
  }

  private QueryRequest setProjectId(QueryRequest request) {
    QueryRequest.Builder builder = request.toBuilder();
    if (request.defaultDataset() != null) {
      builder.defaultDataset(setProjectId(request.defaultDataset()));
    }
    return builder.build();
  }

  private LoadConfiguration setProjectId(LoadConfiguration configuration) {
    LoadConfiguration.Builder builder = configuration.toBuilder();
    builder.destinationTable(setProjectId(configuration.destinationTable()));
    return builder.build();
  }
}
