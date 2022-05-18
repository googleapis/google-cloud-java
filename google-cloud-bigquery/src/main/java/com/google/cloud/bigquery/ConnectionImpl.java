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

import static com.google.cloud.RetryHelper.runWithRetries;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.google.api.services.bigquery.model.JobConfigurationQuery;
import com.google.api.services.bigquery.model.QueryParameter;
import com.google.api.services.bigquery.model.QueryRequest;
import com.google.api.services.bigquery.model.TableDataList;
import com.google.api.services.bigquery.model.TableRow;
import com.google.cloud.RetryHelper;
import com.google.cloud.Tuple;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.JobStatistics.SessionInfo;
import com.google.cloud.bigquery.spi.v2.BigQueryRpc;
import com.google.cloud.bigquery.storage.v1.ArrowRecordBatch;
import com.google.cloud.bigquery.storage.v1.ArrowSchema;
import com.google.cloud.bigquery.storage.v1.BigQueryReadClient;
import com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1.DataFormat;
import com.google.cloud.bigquery.storage.v1.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1.ReadSession;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.VectorLoader;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.ipc.ReadChannel;
import org.apache.arrow.vector.ipc.message.MessageSerializer;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.util.ByteArrayReadableSeekableByteChannel;

/** Implementation for {@link Connection}, the generic BigQuery connection API (not JDBC). */
class ConnectionImpl implements Connection {

  private final ConnectionSettings connectionSettings;
  private final BigQueryOptions bigQueryOptions;
  private final BigQueryRpc bigQueryRpc;
  private final BigQueryRetryConfig retryConfig;
  private final int bufferSize; // buffer size in Producer Thread
  private final int MAX_PROCESS_QUERY_THREADS_CNT = 5;
  private final ExecutorService queryTaskExecutor =
      Executors.newFixedThreadPool(MAX_PROCESS_QUERY_THREADS_CNT);
  private final Logger logger = Logger.getLogger(this.getClass().getName());
  private BigQueryReadClient bqReadClient;
  private static final long EXECUTOR_TIMEOUT_SEC = 5;

  ConnectionImpl(
      ConnectionSettings connectionSettings,
      BigQueryOptions bigQueryOptions,
      BigQueryRpc bigQueryRpc,
      BigQueryRetryConfig retryConfig) {
    this.connectionSettings = connectionSettings;
    this.bigQueryOptions = bigQueryOptions;
    this.bigQueryRpc = bigQueryRpc;
    this.retryConfig = retryConfig;
    // Sets a reasonable buffer size (a blocking queue) if user input is suboptimal
    this.bufferSize =
        (connectionSettings == null
                || connectionSettings.getNumBufferedRows() == null
                || connectionSettings.getNumBufferedRows() < 10000
            ? 20000
            : Math.min(connectionSettings.getNumBufferedRows() * 2, 100000));
  }

  /**
   * Cancel method shutdowns the pageFetcher and producerWorker threads gracefully using interrupt.
   * The pageFetcher threat will not request for any subsequent threads after interrupting and
   * shutdown as soon as any ongoing RPC call returns. The producerWorker will not populate the
   * buffer with any further records and clear the buffer, put a EoF marker and shutdown.
   *
   * @return Boolean value true if the threads were interrupted
   * @throws BigQuerySQLException
   */
  @BetaApi
  @Override
  public synchronized boolean close() throws BigQuerySQLException {
    queryTaskExecutor.shutdownNow();
    try {
      queryTaskExecutor.awaitTermination(
          EXECUTOR_TIMEOUT_SEC, TimeUnit.SECONDS); // wait for the executor shutdown
    } catch (InterruptedException e) {
      e.printStackTrace();
      logger.log(
          Level.WARNING,
          "\n" + Thread.currentThread().getName() + " Exception while awaitTermination",
          e); // Logging InterruptedException instead of throwing the exception back, close method
      // will return queryTaskExecutor.isShutdown()
    }
    return queryTaskExecutor.isShutdown(); // check if the executor has been shutdown
  }

  /**
   * This method runs a dry run query
   *
   * @param sql SQL SELECT statement
   * @return BigQueryDryRunResult containing List<Parameter> and Schema
   * @throws BigQuerySQLException
   */
  @BetaApi
  @Override
  public BigQueryDryRunResult dryRun(String sql) throws BigQuerySQLException {
    com.google.api.services.bigquery.model.Job dryRunJob = createDryRunJob(sql);
    Schema schema = Schema.fromPb(dryRunJob.getStatistics().getQuery().getSchema());
    List<QueryParameter> queryParametersPb =
        dryRunJob.getStatistics().getQuery().getUndeclaredQueryParameters();
    List<Parameter> queryParameters =
        Lists.transform(queryParametersPb, QUERY_PARAMETER_FROM_PB_FUNCTION);
    QueryStatistics queryStatistics = JobStatistics.fromPb(dryRunJob);
    SessionInfo sessionInfo =
        queryStatistics.getSessionInfo() == null ? null : queryStatistics.getSessionInfo();
    BigQueryResultStats bigQueryResultStats =
        new BigQueryResultStatsImpl(queryStatistics, sessionInfo);
    return new BigQueryDryRunResultImpl(schema, queryParameters, bigQueryResultStats);
  }

  /**
   * This method executes a SQL SELECT query
   *
   * @param sql SQL SELECT statement
   * @return BigQueryResult containing the output of the query
   * @throws BigQuerySQLException
   */
  @BetaApi
  @Override
  public BigQueryResult executeSelect(String sql) throws BigQuerySQLException {
    try {
      // use jobs.query if all the properties of connectionSettings are supported
      if (isFastQuerySupported()) {
        String projectId = bigQueryOptions.getProjectId();
        QueryRequest queryRequest = createQueryRequest(connectionSettings, sql, null, null);
        return queryRpc(projectId, queryRequest, false);
      }
      // use jobs.insert otherwise
      com.google.api.services.bigquery.model.Job queryJob =
          createQueryJob(sql, connectionSettings, null, null);
      JobId jobId = JobId.fromPb(queryJob.getJobReference());
      GetQueryResultsResponse firstPage = getQueryResultsFirstPage(jobId);
      return getResultSet(firstPage, jobId, sql, false);
    } catch (BigQueryException e) {
      throw new BigQuerySQLException(e.getMessage(), e, e.getErrors());
    }
  }

  /**
   * This method executes a SQL SELECT query
   *
   * @param sql SQL SELECT query
   * @param parameters named or positional parameters. The set of query parameters must either be
   *     all positional or all named parameters.
   * @param labels the labels associated with this query. You can use these to organize and group
   *     your query jobs. Label keys and values can be no longer than 63 characters, can only
   *     contain lowercase letters, numeric characters, underscores and dashes. International
   *     characters are allowed. Label values are optional and Label is a Varargs. You should pass
   *     all the Labels in a single Map .Label keys must start with a letter and each label in the
   *     list must have a different key.
   * @return BigQueryResult containing the output of the query
   * @throws BigQuerySQLException
   */
  @BetaApi
  @Override
  public BigQueryResult executeSelect(
      String sql, List<Parameter> parameters, Map<String, String>... labels)
      throws BigQuerySQLException {
    Map<String, String> labelMap = null;
    if (labels != null
        && labels.length == 1) { // We expect label as a key value pair in a single Map
      labelMap = labels[0];
    }
    try {
      // use jobs.query if possible
      if (isFastQuerySupported()) {
        final String projectId = bigQueryOptions.getProjectId();
        final QueryRequest queryRequest =
            createQueryRequest(connectionSettings, sql, parameters, labelMap);
        return queryRpc(projectId, queryRequest, parameters != null);
      }
      // use jobs.insert otherwise
      com.google.api.services.bigquery.model.Job queryJob =
          createQueryJob(sql, connectionSettings, parameters, labelMap);
      JobId jobId = JobId.fromPb(queryJob.getJobReference());
      GetQueryResultsResponse firstPage = getQueryResultsFirstPage(jobId);
      return getResultSet(firstPage, jobId, sql, parameters != null);
    } catch (BigQueryException e) {
      throw new BigQuerySQLException(e.getMessage(), e, e.getErrors());
    }
  }

  @VisibleForTesting
  BigQueryResult getResultSet(
      GetQueryResultsResponse firstPage, JobId jobId, String sql, Boolean hasQueryParameters) {
    if (firstPage.getJobComplete()
        && firstPage.getTotalRows() != null
        && firstPage.getSchema()
            != null) { // firstPage.getTotalRows() is null if job is not complete. We need to make
      // sure that the schema is not null, as it is required for the ResultSet
      return getSubsequentQueryResultsWithJob(
          firstPage.getTotalRows().longValue(),
          (long) firstPage.getRows().size(),
          jobId,
          firstPage,
          hasQueryParameters);
    } else { // job is still running, use dryrun to get Schema
      com.google.api.services.bigquery.model.Job dryRunJob = createDryRunJob(sql);
      Schema schema = Schema.fromPb(dryRunJob.getStatistics().getQuery().getSchema());
      // TODO: check how can we get totalRows and pageRows while the job is still running.
      // `firstPage.getTotalRows()` returns null
      return getSubsequentQueryResultsWithJob(
          null, null, jobId, firstPage, schema, hasQueryParameters);
    }
  }

  static class EndOfFieldValueList
      extends AbstractList<
          FieldValue> { // A reference of this class is used as a token to inform the thread
    // consuming `buffer` BigQueryResultImpl that we have run out of records
    @Override
    public FieldValue get(int index) {
      return null;
    }

    @Override
    public int size() {
      return 0;
    }
  }

  private BigQueryResult queryRpc(
      final String projectId, final QueryRequest queryRequest, Boolean hasQueryParameters) {
    com.google.api.services.bigquery.model.QueryResponse results;
    try {
      results =
          BigQueryRetryHelper.runWithRetries(
              () -> bigQueryRpc.queryRpc(projectId, queryRequest),
              bigQueryOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              bigQueryOptions.getClock(),
              retryConfig);
    } catch (BigQueryRetryHelper.BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }

    if (results.getErrors() != null) {
      List<BigQueryError> bigQueryErrors =
          results.getErrors().stream()
              .map(BigQueryError.FROM_PB_FUNCTION)
              .collect(Collectors.toList());
      // Throwing BigQueryException since there may be no JobId, and we want to stay consistent
      // with the case where there is an HTTP error
      throw new BigQueryException(bigQueryErrors);
    }

    // Query finished running and we can paginate all the results
    if (results.getJobComplete() && results.getSchema() != null) {
      return processQueryResponseResults(results);
    } else {
      // Query is long-running (> 10s) and hasn't completed yet, or query completed but didn't
      // return the schema, fallback to jobs.insert path. Some operations don't return the schema
      // and can be optimized here, but this is left as future work.
      Long totalRows = results.getTotalRows() == null ? null : results.getTotalRows().longValue();
      Long pageRows = results.getRows() == null ? null : (long) (results.getRows().size());
      JobId jobId = JobId.fromPb(results.getJobReference());
      GetQueryResultsResponse firstPage = getQueryResultsFirstPage(jobId);
      return getSubsequentQueryResultsWithJob(
          totalRows, pageRows, jobId, firstPage, hasQueryParameters);
    }
  }

  @VisibleForTesting
  BigQueryResultStats getBigQueryResultSetStats(JobId jobId) {
    // Create GetQueryResultsResponse query statistics
    Job queryJob = getQueryJobRpc(jobId);
    QueryStatistics queryStatistics = queryJob.getStatistics();
    SessionInfo sessionInfo =
        queryStatistics.getSessionInfo() == null ? null : queryStatistics.getSessionInfo();
    return new BigQueryResultStatsImpl(queryStatistics, sessionInfo);
  }
  /* This method processed the first page of GetQueryResultsResponse and then it uses tabledata.list */
  @VisibleForTesting
  BigQueryResult tableDataList(GetQueryResultsResponse firstPage, JobId jobId) {
    Schema schema;
    long numRows;
    schema = Schema.fromPb(firstPage.getSchema());
    numRows = firstPage.getTotalRows().longValue();

    BigQueryResultStats bigQueryResultStats = getBigQueryResultSetStats(jobId);

    // Keeps the deserialized records at the row level, which is consumed by BigQueryResult
    BlockingQueue<AbstractList<FieldValue>> buffer = new LinkedBlockingDeque<>(bufferSize);

    // Keeps the parsed FieldValueLists
    BlockingQueue<Tuple<Iterable<FieldValueList>, Boolean>> pageCache =
        new LinkedBlockingDeque<>(
            getPageCacheSize(connectionSettings.getNumBufferedRows(), schema));

    // Keeps the raw RPC responses
    BlockingQueue<Tuple<TableDataList, Boolean>> rpcResponseQueue =
        new LinkedBlockingDeque<>(
            getPageCacheSize(connectionSettings.getNumBufferedRows(), schema));

    runNextPageTaskAsync(firstPage.getPageToken(), getDestinationTable(jobId), rpcResponseQueue);

    parseRpcDataAsync(
        firstPage.getRows(),
        schema,
        pageCache,
        rpcResponseQueue); // parses data on a separate thread, thus maximising processing
    // throughput

    populateBufferAsync(
        rpcResponseQueue, pageCache, buffer); // spawns a thread to populate the buffer

    // This will work for pagination as well, as buffer is getting updated asynchronously
    return new BigQueryResultImpl<AbstractList<FieldValue>>(
        schema, numRows, buffer, bigQueryResultStats);
  }

  @VisibleForTesting
  BigQueryResult processQueryResponseResults(
      com.google.api.services.bigquery.model.QueryResponse results) {
    Schema schema;
    long numRows;
    schema = Schema.fromPb(results.getSchema());
    numRows =
        results.getTotalRows() == null
            ? 0
            : results.getTotalRows().longValue(); // in case of DML or DDL
    // QueryResponse only provides cache hits, dmlStats, and sessionInfo as query processing
    // statistics
    DmlStats dmlStats =
        results.getDmlStats() == null ? null : DmlStats.fromPb(results.getDmlStats());
    Boolean cacheHit = results.getCacheHit();
    QueryStatistics queryStatistics =
        QueryStatistics.newBuilder().setDmlStats(dmlStats).setCacheHit(cacheHit).build();
    // We cannot directly set sessionInfo in QueryStatistics
    SessionInfo sessionInfo =
        results.getSessionInfo() == null
            ? null
            : JobStatistics.SessionInfo.fromPb(results.getSessionInfo());
    BigQueryResultStats bigQueryResultStats =
        new BigQueryResultStatsImpl(queryStatistics, sessionInfo);

    BlockingQueue<AbstractList<FieldValue>> buffer = new LinkedBlockingDeque<>(bufferSize);
    BlockingQueue<Tuple<Iterable<FieldValueList>, Boolean>> pageCache =
        new LinkedBlockingDeque<>(
            getPageCacheSize(connectionSettings.getNumBufferedRows(), schema));
    BlockingQueue<Tuple<TableDataList, Boolean>> rpcResponseQueue =
        new LinkedBlockingDeque<>(
            getPageCacheSize(connectionSettings.getNumBufferedRows(), schema));

    JobId jobId = JobId.fromPb(results.getJobReference());

    // Thread to make rpc calls to fetch data from the server
    runNextPageTaskAsync(results.getPageToken(), getDestinationTable(jobId), rpcResponseQueue);

    // Thread to parse data received from the server to client library objects
    parseRpcDataAsync(results.getRows(), schema, pageCache, rpcResponseQueue);

    // Thread to populate the buffer (a blocking queue) shared with the consumer
    populateBufferAsync(rpcResponseQueue, pageCache, buffer);

    return new BigQueryResultImpl<AbstractList<FieldValue>>(
        schema, numRows, buffer, bigQueryResultStats);
  }

  @VisibleForTesting
  void runNextPageTaskAsync(
      String firstPageToken,
      TableId destinationTable,
      BlockingQueue<Tuple<TableDataList, Boolean>> rpcResponseQueue) {
    // This thread makes the RPC calls and paginates
    Runnable nextPageTask =
        () -> {
          String pageToken = firstPageToken; // results.getPageToken();
          try {
            while (pageToken != null) { // paginate for non null token
              if (Thread.currentThread().isInterrupted()
                  || queryTaskExecutor.isShutdown()) { // do not process further pages and shutdown
                break;
              }
              TableDataList tabledataList = tableDataListRpc(destinationTable, pageToken);
              pageToken = tabledataList.getPageToken();
              rpcResponseQueue.put(
                  Tuple.of(
                      tabledataList,
                      true)); // this will be parsed asynchronously without blocking the current
              // thread
            }
            rpcResponseQueue.put(
                Tuple.of(
                    null,
                    false)); // this will stop the parseDataTask as well in case of interrupt or
            // when the pagination completes
          } catch (Exception e) {
            throw new BigQueryException(0, e.getMessage(), e);
          }
        };
    queryTaskExecutor.execute(nextPageTask);
  }

  /*
  This method takes TableDataList from rpcResponseQueue and populates pageCache with FieldValueList
   */
  @VisibleForTesting
  void parseRpcDataAsync(
      // com.google.api.services.bigquery.model.QueryResponse results,
      List<TableRow> tableRows,
      Schema schema,
      BlockingQueue<Tuple<Iterable<FieldValueList>, Boolean>> pageCache,
      BlockingQueue<Tuple<TableDataList, Boolean>> rpcResponseQueue) {

    // parse and put the first page in the pageCache before the other pages are parsed from the RPC
    // calls
    Iterable<FieldValueList> firstFieldValueLists = getIterableFieldValueList(tableRows, schema);
    try {
      pageCache.put(
          Tuple.of(firstFieldValueLists, true)); // this is the first page which we have received.
    } catch (InterruptedException e) {
      throw new BigQueryException(0, e.getMessage(), e);
    }

    // rpcResponseQueue will get null tuple if Cancel method is called, so no need to explicitly use
    // thread interrupt here
    Runnable parseDataTask =
        () -> {
          try {
            boolean hasMorePages = true;
            while (hasMorePages) {
              Tuple<TableDataList, Boolean> rpcResponse = rpcResponseQueue.take();
              TableDataList tabledataList = rpcResponse.x();
              hasMorePages = rpcResponse.y();
              if (tabledataList != null) {
                Iterable<FieldValueList> fieldValueLists =
                    getIterableFieldValueList(tabledataList.getRows(), schema); // Parse
                pageCache.put(Tuple.of(fieldValueLists, true));
              }
            }
          } catch (InterruptedException e) {
            logger.log(
                Level.WARNING,
                "\n" + Thread.currentThread().getName() + " Interrupted",
                e); // Thread might get interrupted while calling the Cancel method, which is
            // expected, so logging this instead of throwing the exception back
          }
          try {
            pageCache.put(Tuple.of(null, false)); // no further pages
          } catch (InterruptedException e) {
            logger.log(
                Level.WARNING,
                "\n" + Thread.currentThread().getName() + " Interrupted",
                e); // Thread might get interrupted while calling the Cancel method, which is
            // expected, so logging this instead of throwing the exception back
          }
        };
    queryTaskExecutor.execute(parseDataTask);
  }

  /**
   * This method is called when the current thread is interrupted, this communicates to ResultSet by
   * adding a EoS
   *
   * @param buffer
   */
  @InternalApi
  void markEoS(BlockingQueue<AbstractList<FieldValue>> buffer) { // package-private
    try {
      buffer.put(new EndOfFieldValueList()); // All the pages has been processed, put this marker
    } catch (InterruptedException e) {
      logger.log(Level.WARNING, "\n" + Thread.currentThread().getName() + " Interrupted", e);
    }
  }

  /**
   * This method is called when the current thread is interrupted, this communicates to ResultSet by
   * adding a isLast Row
   *
   * @param buffer
   */
  @InternalApi
  void markLast(BlockingQueue<BigQueryResultImpl.Row> buffer) { // package-private
    try {
      buffer.put(
          new BigQueryResultImpl.Row(
              null, true)); // All the pages has been processed, put this marker
    } catch (InterruptedException e) {
      logger.log(Level.WARNING, "\n" + Thread.currentThread().getName() + " Interrupted", e);
    }
  }

  @VisibleForTesting
  void populateBufferAsync(
      BlockingQueue<Tuple<TableDataList, Boolean>> rpcResponseQueue,
      BlockingQueue<Tuple<Iterable<FieldValueList>, Boolean>> pageCache,
      BlockingQueue<AbstractList<FieldValue>> buffer) {
    Runnable populateBufferRunnable =
        () -> { // producer thread populating the buffer
          Iterable<FieldValueList> fieldValueLists = null;
          boolean hasRows = true; // as we have to process the first page
          while (hasRows) {
            try {
              Tuple<Iterable<FieldValueList>, Boolean> nextPageTuple = pageCache.take();
              hasRows = nextPageTuple.y();
              fieldValueLists = nextPageTuple.x();
            } catch (InterruptedException e) {
              logger.log(
                  Level.WARNING,
                  "\n" + Thread.currentThread().getName() + " Interrupted",
                  e); // Thread might get interrupted while calling the Cancel method, which is
              // expected, so logging this instead of throwing the exception back
              markEoS(
                  buffer); // Thread has been interrupted, communicate to ResultSet by adding EoS
            }

            if (Thread.currentThread().isInterrupted()
                || fieldValueLists
                    == null) { // do not process further pages and shutdown (outerloop)
              markEoS(
                  buffer); // Thread has been interrupted, communicate to ResultSet by adding EoS
              break;
            }

            for (FieldValueList fieldValueList : fieldValueLists) {
              try {
                if (Thread.currentThread()
                    .isInterrupted()) { // do not process further pages and shutdown (inner loop)
                  markEoS(
                      buffer); // Thread has been interrupted, communicate to ResultSet by adding
                  // EoS
                  break;
                }
                buffer.put(fieldValueList);
              } catch (InterruptedException e) {
                throw new BigQueryException(0, e.getMessage(), e);
              }
            }
          }

          try {
            if (Thread.currentThread()
                .isInterrupted()) { // clear the buffer for any outstanding records
              rpcResponseQueue
                  .clear(); // IMP - so that if it's full then it unblocks and the interrupt logic
              // could trigger
              buffer.clear();
            }
            markEoS(buffer); // All the pages has been processed, put this marker
          } finally {
            queryTaskExecutor.shutdownNow(); // Shutdown the thread pool
          }
        };

    queryTaskExecutor.execute(populateBufferRunnable);
  }

  /* Helper method that parse and populate a page with TableRows */
  private static Iterable<FieldValueList> getIterableFieldValueList(
      Iterable<TableRow> tableDataPb, final Schema schema) {
    return ImmutableList.copyOf(
        Iterables.transform(
            tableDataPb != null ? tableDataPb : ImmutableList.of(),
            new Function<TableRow, FieldValueList>() {
              final FieldList fields = schema != null ? schema.getFields() : null;

              @Override
              public FieldValueList apply(TableRow rowPb) {
                return FieldValueList.fromPb(rowPb.getF(), fields);
              }
            }));
  }

  /* Helper method that determines the optimal number of caches pages to improve read performance */
  @VisibleForTesting
  int getPageCacheSize(Integer numBufferedRows, Schema schema) {
    final int MIN_CACHE_SIZE = 3; // Min number of pages to cache
    final int MAX_CACHE_SIZE = 20; // //Min number of pages to cache
    int numColumns = schema.getFields().size();
    int numCachedPages;
    long numCachedRows = numBufferedRows == null ? 0 : numBufferedRows.longValue();

    // TODO: Further enhance this logic depending on customer feedback on memory consumption
    if (numCachedRows > 10000) {
      numCachedPages =
          2; // the size of numBufferedRows is quite large and as per our tests we should be able to
      // do enough even with low
    } else if (numColumns > 15
        && numCachedRows
            > 5000) { // too many fields are being read, setting the page size on the lower end
      numCachedPages = 3;
    } else if (numCachedRows < 2000
        && numColumns < 15) { // low pagesize with fewer number of columns, we can cache more pages
      numCachedPages = 20;
    } else { // default - under 10K numCachedRows with any number of columns
      numCachedPages = 5;
    }
    return numCachedPages < MIN_CACHE_SIZE
        ? MIN_CACHE_SIZE
        : (Math.min(
            numCachedPages,
            MAX_CACHE_SIZE)); // numCachedPages should be between the defined min and max
  }

  /* Returns query results using either tabledata.list or the high throughput Read API */
  @VisibleForTesting
  BigQueryResult getSubsequentQueryResultsWithJob(
      Long totalRows,
      Long pageRows,
      JobId jobId,
      GetQueryResultsResponse firstPage,
      Boolean hasQueryParameters) {
    TableId destinationTable = getDestinationTable(jobId);
    return useReadAPI(totalRows, pageRows, Schema.fromPb(firstPage.getSchema()), hasQueryParameters)
        ? highThroughPutRead(
            destinationTable,
            firstPage.getTotalRows().longValue(),
            Schema.fromPb(firstPage.getSchema()),
            getBigQueryResultSetStats(
                jobId)) // discord first page and stream the entire BigQueryResult using
        // the Read API
        : tableDataList(firstPage, jobId);
  }

  /* Returns query results using either tabledata.list or the high throughput Read API */
  @VisibleForTesting
  BigQueryResult getSubsequentQueryResultsWithJob(
      Long totalRows,
      Long pageRows,
      JobId jobId,
      GetQueryResultsResponse firstPage,
      Schema schema,
      Boolean hasQueryParameters) {
    TableId destinationTable = getDestinationTable(jobId);
    return useReadAPI(totalRows, pageRows, schema, hasQueryParameters)
        ? highThroughPutRead(
            destinationTable,
            totalRows == null
                ? -1L
                : totalRows, // totalRows is null when the job is still running. TODO: Check if
            // any workaround is possible
            schema,
            getBigQueryResultSetStats(
                jobId)) // discord first page and stream the entire BigQueryResult using
        // the Read API
        : tableDataList(firstPage, jobId);
  }

  /* Returns Job from jobId by calling the jobs.get API */
  private Job getQueryJobRpc(JobId jobId) {
    final JobId completeJobId =
        jobId
            .setProjectId(bigQueryOptions.getProjectId())
            .setLocation(
                jobId.getLocation() == null && bigQueryOptions.getLocation() != null
                    ? bigQueryOptions.getLocation()
                    : jobId.getLocation());
    com.google.api.services.bigquery.model.Job jobPb;
    try {
      jobPb =
          runWithRetries(
              () ->
                  bigQueryRpc.getQueryJob(
                      completeJobId.getProject(),
                      completeJobId.getJob(),
                      completeJobId.getLocation()),
              bigQueryOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              bigQueryOptions.getClock());
      if (bigQueryOptions.getThrowNotFound() && jobPb == null) {
        throw new BigQueryException(HTTP_NOT_FOUND, "Query job not found");
      }
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
    return Job.fromPb(bigQueryOptions.getService(), jobPb);
  }

  /* Returns the destinationTable from jobId by calling jobs.get API */
  @VisibleForTesting
  TableId getDestinationTable(JobId jobId) {
    Job job = getQueryJobRpc(jobId);
    return ((QueryJobConfiguration) job.getConfiguration()).getDestinationTable();
  }

  @VisibleForTesting
  TableDataList tableDataListRpc(TableId destinationTable, String pageToken) {
    try {
      final TableId completeTableId =
          destinationTable.setProjectId(
              Strings.isNullOrEmpty(destinationTable.getProject())
                  ? bigQueryOptions.getProjectId()
                  : destinationTable.getProject());
      TableDataList results =
          runWithRetries(
              () ->
                  bigQueryOptions
                      .getBigQueryRpcV2()
                      .listTableDataWithRowLimit(
                          completeTableId.getProject(),
                          completeTableId.getDataset(),
                          completeTableId.getTable(),
                          connectionSettings.getMaxResultPerPage(),
                          pageToken),
              bigQueryOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              bigQueryOptions.getClock());

      return results;
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @VisibleForTesting
  BigQueryResult highThroughPutRead(
      TableId destinationTable, long totalRows, Schema schema, BigQueryResultStats stats) {

    try {
      if (bqReadClient == null) { // if the read client isn't already initialized. Not thread safe.
        bqReadClient = BigQueryReadClient.create();
      }
      String parent = String.format("projects/%s", destinationTable.getProject());
      String srcTable =
          String.format(
              "projects/%s/datasets/%s/tables/%s",
              destinationTable.getProject(),
              destinationTable.getDataset(),
              destinationTable.getTable());

      // Read all the columns if the source table (temp table) and stream the data back in Arrow
      // format
      ReadSession.Builder sessionBuilder =
          ReadSession.newBuilder().setTable(srcTable).setDataFormat(DataFormat.ARROW);

      CreateReadSessionRequest.Builder builder =
          CreateReadSessionRequest.newBuilder()
              .setParent(parent)
              .setReadSession(sessionBuilder)
              .setMaxStreamCount(1) // Currently just one stream is allowed
          // DO a regex check using order by and use multiple streams
          ;

      ReadSession readSession = bqReadClient.createReadSession(builder.build());
      BlockingQueue<BigQueryResultImpl.Row> buffer = new LinkedBlockingDeque<>(bufferSize);
      Map<String, Integer> arrowNameToIndex = new HashMap<>();
      // deserialize and populate the buffer async, so that the client isn't blocked
      processArrowStreamAsync(
          readSession,
          buffer,
          new ArrowRowReader(readSession.getArrowSchema(), arrowNameToIndex),
          schema);

      logger.log(Level.INFO, "\n Using BigQuery Read API");
      return new BigQueryResultImpl<BigQueryResultImpl.Row>(schema, totalRows, buffer, stats);

    } catch (IOException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  private void processArrowStreamAsync(
      ReadSession readSession,
      BlockingQueue<BigQueryResultImpl.Row> buffer,
      ArrowRowReader reader,
      Schema schema) {

    Runnable arrowStreamProcessor =
        () -> {
          try {
            // Use the first stream to perform reading.
            String streamName = readSession.getStreams(0).getName();
            ReadRowsRequest readRowsRequest =
                ReadRowsRequest.newBuilder().setReadStream(streamName).build();

            // Process each block of rows as they arrive and decode using our simple row reader.
            com.google.api.gax.rpc.ServerStream<ReadRowsResponse> stream =
                bqReadClient.readRowsCallable().call(readRowsRequest);
            for (ReadRowsResponse response : stream) {
              if (Thread.currentThread().isInterrupted()
                  || queryTaskExecutor.isShutdown()) { // do not process and shutdown
                break;
              }
              reader.processRows(response.getArrowRecordBatch(), buffer, schema);
            }

          } catch (Exception e) {
            throw BigQueryException.translateAndThrow(e);
          } finally {
            markLast(buffer); // marking end of stream
            queryTaskExecutor.shutdownNow(); // Shutdown the thread pool
          }
        };

    queryTaskExecutor.execute(arrowStreamProcessor);
  }

  private class ArrowRowReader
      implements AutoCloseable { // TODO: Update to recent version of Arrow to avoid memoryleak

    BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE);

    // Decoder object will be reused to avoid re-allocation and too much garbage collection.
    private final VectorSchemaRoot root;
    private final VectorLoader loader;

    private ArrowRowReader(ArrowSchema arrowSchema, Map<String, Integer> arrowNameToIndex)
        throws IOException {
      org.apache.arrow.vector.types.pojo.Schema schema =
          MessageSerializer.deserializeSchema(
              new org.apache.arrow.vector.ipc.ReadChannel(
                  new ByteArrayReadableSeekableByteChannel(
                      arrowSchema.getSerializedSchema().toByteArray())));
      List<FieldVector> vectors = new ArrayList<>();
      List<Field> fields = schema.getFields();
      for (int i = 0; i < fields.size(); i++) {
        vectors.add(fields.get(i).createVector(allocator));
        arrowNameToIndex.put(
            fields.get(i).getName(),
            i); // mapping for getting against the field name in the result set
      }
      root = new VectorSchemaRoot(vectors);
      loader = new VectorLoader(root);
    }

    /** @param batch object returned from the ReadRowsResponse. */
    private void processRows(
        ArrowRecordBatch batch, BlockingQueue<BigQueryResultImpl.Row> buffer, Schema schema)
        throws IOException { // deserialize the values and consume the hash of the values
      try {
        org.apache.arrow.vector.ipc.message.ArrowRecordBatch deserializedBatch =
            MessageSerializer.deserializeRecordBatch(
                new ReadChannel(
                    new ByteArrayReadableSeekableByteChannel(
                        batch.getSerializedRecordBatch().toByteArray())),
                allocator);

        loader.load(deserializedBatch);
        // Release buffers from batch (they are still held in the vectors in root).
        deserializedBatch.close();

        // Parse the vectors using BQ Schema. Deserialize the data at the row level and add it to
        // the
        // buffer
        FieldList fields = schema.getFields();
        for (int rowNum = 0;
            rowNum < root.getRowCount();
            rowNum++) { // for the given number of rows in the batch

          if (Thread.currentThread().isInterrupted()
              || queryTaskExecutor.isShutdown()) { // do not process and shutdown
            markLast(buffer); // puts an isLast Row in the buffer for ResultSet to process
            break; // exit the loop, root will be cleared in the finally block
          }

          Map<String, Object> curRow = new HashMap<>();
          for (int col = 0; col < fields.size(); col++) { // iterate all the vectors for a given row
            com.google.cloud.bigquery.Field field = fields.get(col);
            FieldVector curFieldVec =
                root.getVector(
                    field.getName()); // can be accessed using the index or Vector/column name
            curRow.put(field.getName(), curFieldVec.getObject(rowNum)); // Added the raw value
          }
          buffer.put(new BigQueryResultImpl.Row(curRow));
        }
        root.clear();
      } catch (RuntimeException | InterruptedException e) {
        throw BigQueryException.translateAndThrow(e);
      } finally {
        try {
          root.clear();
        } catch (RuntimeException e) {
          logger.log(Level.WARNING, "\n Error while clearing VectorSchemaRoot ", e);
        }
      }
    }

    @Override
    public void close() {
      root.close();
      allocator.close();
    }
  }
  /*Returns just the first page of GetQueryResultsResponse using the jobId*/
  @VisibleForTesting
  GetQueryResultsResponse getQueryResultsFirstPage(JobId jobId) {
    JobId completeJobId =
        jobId
            .setProjectId(bigQueryOptions.getProjectId())
            .setLocation(
                jobId.getLocation() == null && bigQueryOptions.getLocation() != null
                    ? bigQueryOptions.getLocation()
                    : jobId.getLocation());
    try {
      GetQueryResultsResponse results =
          BigQueryRetryHelper.runWithRetries(
              () ->
                  bigQueryRpc.getQueryResultsWithRowLimit(
                      completeJobId.getProject(),
                      completeJobId.getJob(),
                      completeJobId.getLocation(),
                      connectionSettings.getMaxResultPerPage()),
              bigQueryOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              bigQueryOptions.getClock(),
              retryConfig);

      if (results.getErrors() != null) {
        List<BigQueryError> bigQueryErrors =
            results.getErrors().stream()
                .map(BigQueryError.FROM_PB_FUNCTION)
                .collect(Collectors.toList());
        // Throwing BigQueryException since there may be no JobId and we want to stay consistent
        // with the case where there there is a HTTP error
        throw new BigQueryException(bigQueryErrors);
      }
      return results;
    } catch (BigQueryRetryHelper.BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  @VisibleForTesting
  boolean isFastQuerySupported() {
    // TODO: add regex logic to check for scripting
    return connectionSettings.getClustering() == null
        && connectionSettings.getCreateDisposition() == null
        && connectionSettings.getDestinationEncryptionConfiguration() == null
        && connectionSettings.getDestinationTable() == null
        && connectionSettings.getJobTimeoutMs() == null
        && connectionSettings.getMaximumBillingTier() == null
        && connectionSettings.getPriority() == null
        && connectionSettings.getRangePartitioning() == null
        && connectionSettings.getSchemaUpdateOptions() == null
        && connectionSettings.getTableDefinitions() == null
        && connectionSettings.getTimePartitioning() == null
        && connectionSettings.getUserDefinedFunctions() == null
        && connectionSettings.getWriteDisposition() == null;
  }

  @VisibleForTesting
  boolean useReadAPI(Long totalRows, Long pageRows, Schema schema, Boolean hasQueryParameters) {

    // TODO(prasmish) get this logic review - totalRows and pageRows are returned null when the job
    // is not complete
    if ((totalRows == null || pageRows == null)
        && Boolean.TRUE.equals(
            connectionSettings
                .getUseReadAPI())) { // totalRows and pageRows are returned null when the job is not
      // complete
      return true;
    }

    // Schema schema = Schema.fromPb(tableSchema);
    // Read API does not yet support Interval Type or QueryParameters
    if (containsIntervalType(schema) || hasQueryParameters) {
      logger.log(Level.INFO, "\n Schema has IntervalType, or QueryParameters. Disabling ReadAPI");
      return false;
    }

    long resultRatio = totalRows / pageRows;
    if (Boolean.TRUE.equals(connectionSettings.getUseReadAPI())) {
      return resultRatio >= connectionSettings.getTotalToPageRowCountRatio()
          && totalRows > connectionSettings.getMinResultSize();
    } else {
      return false;
    }
  }

  // Does a BFS iteration to find out if there's an interval type in the schema. Implementation to
  // be used until ReadAPI supports IntervalType
  private boolean containsIntervalType(Schema schema) {
    Queue<com.google.cloud.bigquery.Field> fields =
        new LinkedList<com.google.cloud.bigquery.Field>(schema.getFields());
    while (!fields.isEmpty()) {
      com.google.cloud.bigquery.Field curField = fields.poll();
      if (curField.getType().getStandardType() == StandardSQLTypeName.INTERVAL) {
        return true;
      } else if (curField.getType().getStandardType() == StandardSQLTypeName.STRUCT
          || curField.getType().getStandardType() == StandardSQLTypeName.ARRAY) {
        fields.addAll(curField.getSubFields());
      }
    }
    return false;
  }

  // Used for job.query API endpoint
  @VisibleForTesting
  QueryRequest createQueryRequest(
      ConnectionSettings connectionSettings,
      String sql,
      List<Parameter> queryParameters,
      Map<String, String> labels) {
    QueryRequest content = new QueryRequest();
    String requestId = UUID.randomUUID().toString();

    if (connectionSettings.getConnectionProperties() != null) {
      content.setConnectionProperties(
          connectionSettings.getConnectionProperties().stream()
              .map(ConnectionProperty.TO_PB_FUNCTION)
              .collect(Collectors.toList()));
    }
    if (connectionSettings.getDefaultDataset() != null) {
      content.setDefaultDataset(connectionSettings.getDefaultDataset().toPb());
    }
    if (connectionSettings.getMaximumBytesBilled() != null) {
      content.setMaximumBytesBilled(connectionSettings.getMaximumBytesBilled());
    }
    if (connectionSettings.getMaxResults() != null) {
      content.setMaxResults(connectionSettings.getMaxResults());
    }
    if (queryParameters != null) {
      // content.setQueryParameters(queryParameters);
      if (queryParameters.get(0).getName() == null) {
        // If query parameter name is unset, then assume mode is positional
        content.setParameterMode("POSITIONAL");
        // pass query parameters
        List<QueryParameter> queryParametersPb =
            Lists.transform(queryParameters, POSITIONAL_PARAMETER_TO_PB_FUNCTION);
        content.setQueryParameters(queryParametersPb);
      } else {
        content.setParameterMode("NAMED");
        // pass query parameters
        List<QueryParameter> queryParametersPb =
            Lists.transform(queryParameters, NAMED_PARAMETER_TO_PB_FUNCTION);
        content.setQueryParameters(queryParametersPb);
      }
    }
    if (connectionSettings.getCreateSession() != null) {
      content.setCreateSession(connectionSettings.getCreateSession());
    }
    if (labels != null) {
      content.setLabels(labels);
    }
    content.setQuery(sql);
    content.setRequestId(requestId);
    // The new Connection interface only supports StandardSQL dialect
    content.setUseLegacySql(false);
    return content;
  }

  // Used by jobs.getQueryResults API endpoint
  @VisibleForTesting
  com.google.api.services.bigquery.model.Job createQueryJob(
      String sql,
      ConnectionSettings connectionSettings,
      List<Parameter> queryParameters,
      Map<String, String> labels) {
    com.google.api.services.bigquery.model.JobConfiguration configurationPb =
        new com.google.api.services.bigquery.model.JobConfiguration();
    JobConfigurationQuery queryConfigurationPb = new JobConfigurationQuery();
    queryConfigurationPb.setQuery(sql);
    if (queryParameters != null) {
      if (queryParameters.get(0).getName() == null) {
        // If query parameter name is unset, then assume mode is positional
        queryConfigurationPb.setParameterMode("POSITIONAL");
        // pass query parameters
        List<QueryParameter> queryParametersPb =
            Lists.transform(queryParameters, POSITIONAL_PARAMETER_TO_PB_FUNCTION);
        queryConfigurationPb.setQueryParameters(queryParametersPb);
      } else {
        queryConfigurationPb.setParameterMode("NAMED");
        // pass query parameters
        List<QueryParameter> queryParametersPb =
            Lists.transform(queryParameters, NAMED_PARAMETER_TO_PB_FUNCTION);
        queryConfigurationPb.setQueryParameters(queryParametersPb);
      }
    }
    if (connectionSettings.getDestinationTable() != null) {
      queryConfigurationPb.setDestinationTable(connectionSettings.getDestinationTable().toPb());
    }
    if (connectionSettings.getTableDefinitions() != null) {
      queryConfigurationPb.setTableDefinitions(
          Maps.transformValues(
              connectionSettings.getTableDefinitions(),
              ExternalTableDefinition.TO_EXTERNAL_DATA_FUNCTION));
    }
    if (connectionSettings.getUserDefinedFunctions() != null) {
      queryConfigurationPb.setUserDefinedFunctionResources(
          connectionSettings.getUserDefinedFunctions().stream()
              .map(UserDefinedFunction.TO_PB_FUNCTION)
              .collect(Collectors.toList()));
    }
    if (connectionSettings.getCreateDisposition() != null) {
      queryConfigurationPb.setCreateDisposition(
          connectionSettings.getCreateDisposition().toString());
    }
    if (connectionSettings.getWriteDisposition() != null) {
      queryConfigurationPb.setWriteDisposition(connectionSettings.getWriteDisposition().toString());
    }
    if (connectionSettings.getDefaultDataset() != null) {
      queryConfigurationPb.setDefaultDataset(connectionSettings.getDefaultDataset().toPb());
    }
    if (connectionSettings.getPriority() != null) {
      queryConfigurationPb.setPriority(connectionSettings.getPriority().toString());
    }
    if (connectionSettings.getAllowLargeResults() != null) {
      queryConfigurationPb.setAllowLargeResults(connectionSettings.getAllowLargeResults());
    }
    if (connectionSettings.getUseQueryCache() != null) {
      queryConfigurationPb.setUseQueryCache(connectionSettings.getUseQueryCache());
    }
    if (connectionSettings.getFlattenResults() != null) {
      queryConfigurationPb.setFlattenResults(connectionSettings.getFlattenResults());
    }
    if (connectionSettings.getMaximumBillingTier() != null) {
      queryConfigurationPb.setMaximumBillingTier(connectionSettings.getMaximumBillingTier());
    }
    if (connectionSettings.getMaximumBytesBilled() != null) {
      queryConfigurationPb.setMaximumBytesBilled(connectionSettings.getMaximumBytesBilled());
    }
    if (connectionSettings.getSchemaUpdateOptions() != null) {
      ImmutableList.Builder<String> schemaUpdateOptionsBuilder = new ImmutableList.Builder<>();
      for (JobInfo.SchemaUpdateOption schemaUpdateOption :
          connectionSettings.getSchemaUpdateOptions()) {
        schemaUpdateOptionsBuilder.add(schemaUpdateOption.name());
      }
      queryConfigurationPb.setSchemaUpdateOptions(schemaUpdateOptionsBuilder.build());
    }
    if (connectionSettings.getDestinationEncryptionConfiguration() != null) {
      queryConfigurationPb.setDestinationEncryptionConfiguration(
          connectionSettings.getDestinationEncryptionConfiguration().toPb());
    }
    if (connectionSettings.getTimePartitioning() != null) {
      queryConfigurationPb.setTimePartitioning(connectionSettings.getTimePartitioning().toPb());
    }
    if (connectionSettings.getClustering() != null) {
      queryConfigurationPb.setClustering(connectionSettings.getClustering().toPb());
    }
    if (connectionSettings.getRangePartitioning() != null) {
      queryConfigurationPb.setRangePartitioning(connectionSettings.getRangePartitioning().toPb());
    }
    if (connectionSettings.getConnectionProperties() != null) {
      queryConfigurationPb.setConnectionProperties(
          connectionSettings.getConnectionProperties().stream()
              .map(ConnectionProperty.TO_PB_FUNCTION)
              .collect(Collectors.toList()));
    }
    if (connectionSettings.getCreateSession() != null) {
      queryConfigurationPb.setCreateSession(connectionSettings.getCreateSession());
    }
    if (connectionSettings.getJobTimeoutMs() != null) {
      configurationPb.setJobTimeoutMs(connectionSettings.getJobTimeoutMs());
    }
    if (labels != null) {
      configurationPb.setLabels(labels);
    }
    // The new Connection interface only supports StandardSQL dialect
    queryConfigurationPb.setUseLegacySql(false);
    configurationPb.setQuery(queryConfigurationPb);

    com.google.api.services.bigquery.model.Job jobPb =
        JobInfo.of(QueryJobConfiguration.fromPb(configurationPb)).toPb();
    com.google.api.services.bigquery.model.Job queryJob;
    try {
      queryJob =
          BigQueryRetryHelper.runWithRetries(
              () -> bigQueryRpc.createJobForQuery(jobPb),
              bigQueryOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              bigQueryOptions.getClock(),
              retryConfig);
    } catch (BigQueryRetryHelper.BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
    return queryJob;
  }

  // Used by dryRun
  private com.google.api.services.bigquery.model.Job createDryRunJob(String sql) {
    com.google.api.services.bigquery.model.JobConfiguration configurationPb =
        new com.google.api.services.bigquery.model.JobConfiguration();
    configurationPb.setDryRun(true);
    JobConfigurationQuery queryConfigurationPb = new JobConfigurationQuery();
    String parameterMode = sql.contains("?") ? "POSITIONAL" : "NAMED";
    queryConfigurationPb.setParameterMode(parameterMode);
    queryConfigurationPb.setQuery(sql);
    // UndeclaredQueryParameter is only supported in StandardSQL
    queryConfigurationPb.setUseLegacySql(false);
    if (connectionSettings.getDefaultDataset() != null) {
      queryConfigurationPb.setDefaultDataset(connectionSettings.getDefaultDataset().toPb());
    }
    if (connectionSettings.getCreateSession() != null) {
      queryConfigurationPb.setCreateSession(connectionSettings.getCreateSession());
    }
    configurationPb.setQuery(queryConfigurationPb);

    com.google.api.services.bigquery.model.Job jobPb =
        JobInfo.of(QueryJobConfiguration.fromPb(configurationPb)).toPb();

    com.google.api.services.bigquery.model.Job dryRunJob;
    try {
      dryRunJob =
          BigQueryRetryHelper.runWithRetries(
              () -> bigQueryRpc.createJobForQuery(jobPb),
              bigQueryOptions.getRetrySettings(),
              BigQueryBaseService.BIGQUERY_EXCEPTION_HANDLER,
              bigQueryOptions.getClock(),
              retryConfig);
    } catch (BigQueryRetryHelper.BigQueryRetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
    return dryRunJob;
  }

  // Convert from Parameter wrapper class to positional QueryParameter generated class
  private static final Function<Parameter, QueryParameter> POSITIONAL_PARAMETER_TO_PB_FUNCTION =
      value -> {
        QueryParameter queryParameterPb = new QueryParameter();
        queryParameterPb.setParameterValue(value.getValue().toValuePb());
        queryParameterPb.setParameterType(value.getValue().toTypePb());
        return queryParameterPb;
      };

  // Convert from Parameter wrapper class to name QueryParameter generated class
  private static final Function<Parameter, QueryParameter> NAMED_PARAMETER_TO_PB_FUNCTION =
      value -> {
        QueryParameter queryParameterPb = new QueryParameter();
        queryParameterPb.setName(value.getName());
        queryParameterPb.setParameterValue(value.getValue().toValuePb());
        queryParameterPb.setParameterType(value.getValue().toTypePb());
        return queryParameterPb;
      };

  // Convert from QueryParameter class to the Parameter wrapper class
  private static final Function<QueryParameter, Parameter> QUERY_PARAMETER_FROM_PB_FUNCTION =
      pb ->
          Parameter.newBuilder()
              .setName(pb.getName() == null ? "" : pb.getName())
              .setValue(QueryParameterValue.fromPb(pb.getParameterValue(), pb.getParameterType()))
              .build();
}
