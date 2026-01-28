/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigquery.jdbc;

import com.google.api.core.InternalApi;
import com.google.api.gax.paging.Page;
import com.google.cloud.Tuple;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.JobListOption;
import com.google.cloud.bigquery.BigQuery.QueryResultsOption;
import com.google.cloud.bigquery.BigQuery.TableDataListOption;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.EncryptionConfiguration;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobConfiguration;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobStatistics;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics.StatementType;
import com.google.cloud.bigquery.JobStatistics.ScriptStatistics;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlFeatureNotSupportedException;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlSyntaxErrorException;
import com.google.cloud.bigquery.storage.v1.ArrowRecordBatch;
import com.google.cloud.bigquery.storage.v1.ArrowSchema;
import com.google.cloud.bigquery.storage.v1.BigQueryReadClient;
import com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1.DataFormat;
import com.google.cloud.bigquery.storage.v1.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1.ReadSession;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import java.lang.ref.ReferenceQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;

/**
 * An implementation of {@link java.sql.Statement} for executing BigQuery SQL statement and
 * returning the results it produces.
 *
 * @see BigQueryConnection#createStatement
 * @see ResultSet
 */
public class BigQueryStatement extends BigQueryNoOpsStatement {

  // TODO (obada): Update this after benchmarking
  private static final int MAX_PROCESS_QUERY_THREADS_CNT = 50;
  protected static ExecutorService queryTaskExecutor =
      Executors.newFixedThreadPool(MAX_PROCESS_QUERY_THREADS_CNT);
  private final BigQueryJdbcCustomLogger LOG = new BigQueryJdbcCustomLogger(this.toString());
  private static final String DEFAULT_DATASET_NAME = "_google_jdbc";
  private static final String DEFAULT_TABLE_NAME = "temp_table_";
  private static final String JDBC_JOB_PREFIX = "google-jdbc-";
  protected ResultSet currentResultSet;
  protected long currentUpdateCount = -1;
  protected List<JobId> jobIds = new ArrayList<>();
  protected JobIdWrapper parentJobId = null;
  protected int currentJobIdIndex = -1;
  protected List<String> batchQueries = new ArrayList<>();
  protected BigQueryConnection connection;
  protected int maxFieldSize = 0;
  protected int maxRows = 0;
  protected boolean isClosed = false;
  protected boolean closeOnCompletion = false;
  protected Object cancelLock = new Object();
  protected boolean isCanceled = false;
  protected boolean poolable;
  protected int queryTimeout = 0;
  protected SQLWarning warning;
  private int fetchDirection = ResultSet.FETCH_FORWARD;
  private int fetchSize;
  private String scriptQuery;
  private Map<String, String> extraLabels = new HashMap<>();

  private BigQueryReadClient bigQueryReadClient = null;
  private final BigQuery bigQuery;

  final BigQuerySettings querySettings;

  private BlockingQueue<BigQueryFieldValueListWrapper> bigQueryFieldValueListWrapperBlockingQueue;

  private BlockingQueue<BigQueryArrowBatchWrapper> arrowBatchWrapperBlockingQueue;

  // Variables Required for the ReferenceQueue implementation
  static ReferenceQueue<BigQueryArrowResultSet> referenceQueueArrowRs = new ReferenceQueue<>();
  static ReferenceQueue<BigQueryJsonResultSet> referenceQueueJsonRs = new ReferenceQueue<>();
  static List<BigQueryResultSetFinalizers.ArrowResultSetFinalizer> arrowResultSetFinalizers =
      new ArrayList<>();
  static List<BigQueryResultSetFinalizers.JsonResultSetFinalizer> jsonResultSetFinalizers =
      new ArrayList<>();

  private static final ThreadFactory JDBC_THREAD_FACTORY =
      new BigQueryThreadFactory("BigQuery-Thread-");

  static {
    BigQueryDaemonPollingTask.startGcDaemonTask(
        referenceQueueArrowRs,
        referenceQueueJsonRs,
        arrowResultSetFinalizers,
        jsonResultSetFinalizers);
  }

  @VisibleForTesting
  public BigQueryStatement(BigQueryConnection connection) {
    this.connection = connection;
    this.bigQuery = connection.getBigQuery();
    this.querySettings = generateBigQuerySettings();
  }

  private void resetStatementFields() {
    this.isCanceled = false;
    this.scriptQuery = null;
    this.parentJobId = null;
    this.currentJobIdIndex = -1;
    this.currentUpdateCount = -1;
  }

  private BigQuerySettings generateBigQuerySettings() {
    LOG.finest("++enter++");

    BigQuerySettings.Builder querySettings = BigQuerySettings.newBuilder();
    DatasetId defaultDataset = this.connection.getDefaultDataset();
    if (defaultDataset != null) {
      querySettings.setDefaultDataset(this.connection.defaultDataset);
    }
    Long maxBytesBilled = this.connection.getMaxBytesBilled();
    if (maxBytesBilled > 0) {
      querySettings.setMaxBytesBilled(maxBytesBilled);
    }
    if (this.connection.getLabels() != null && !this.connection.getLabels().isEmpty()) {
      querySettings.setLabels(this.connection.getLabels());
    }
    querySettings.setMaxResultPerPage(this.connection.getMaxResults());
    querySettings.setUseReadAPI(this.connection.isEnableHighThroughputAPI());
    querySettings.setHighThroughputMinTableSize(this.connection.getHighThroughputMinTableSize());
    querySettings.setHighThroughputActivationRatio(
        this.connection.getHighThroughputActivationRatio());
    querySettings.setUnsupportedHTAPIFallback(this.connection.isUnsupportedHTAPIFallback());
    querySettings.setUseQueryCache(this.connection.isUseQueryCache());
    querySettings.setQueryDialect(this.connection.getQueryDialect());
    querySettings.setKmsKeyName(this.connection.getKmsKeyName());
    querySettings.setQueryProperties(this.connection.getQueryProperties());
    querySettings.setAllowLargeResults(this.connection.isAllowLargeResults());
    if (this.connection.getJobTimeoutInSeconds() > 0) {
      querySettings.setJobTimeoutMs(this.connection.getJobTimeoutInSeconds() * 1000L);
    }
    if (this.connection.getDestinationTable() != null) {
      querySettings.setDestinationTable(this.connection.getDestinationTable());
    }
    if (this.connection.getDestinationDataset() != null) {
      querySettings.setDestinationDataset(this.connection.getDestinationDataset());
      querySettings.setDestinationDatasetExpirationTime(
          this.connection.getDestinationDatasetExpirationTime());
    }
    // only create session if enable session and session info is null
    if (this.connection.enableSession) {
      if (this.connection.sessionInfoConnectionProperty == null) {
        querySettings.setEnableSession(this.connection.isSessionEnabled());
      } else {
        querySettings.setSessionInfoConnectionProperty(
            this.connection.getSessionInfoConnectionProperty());
      }
    }
    querySettings.setUseWriteAPI(this.connection.isEnableWriteAPI());
    querySettings.setWriteAPIActivationRowCount(this.connection.getWriteAPIActivationRowCount());
    querySettings.setWriteAPIAppendRowCount(this.connection.getWriteAPIAppendRowCount());

    return querySettings.build();
  }

  /**
   * This method executes a BigQuery SQL query, return a single {@code ResultSet} object.
   *
   * <p>Example of running a query:
   *
   * <pre>
   *  Connection connection = DriverManager.getConnection(CONNECTION_URL);
   *  Statement bigQueryStatement = bigQueryConnection.createStatement();
   *  ResultSet result = bigQueryStatement.executeQuery(QUERY);
   * </pre>
   *
   * @param sql BigQuery SQL query
   * @return {@code ResultSet} containing the output of the query
   * @throws SQLException if a BigQuery access error occurs, this method is called on a closed
   *     {@code Statement}, the given SQL statement produces multiple or no result sets.
   * @see java.sql.Statement#executeQuery(String)
   */
  @Override
  public ResultSet executeQuery(String sql) throws SQLException {
    // TODO: write method to return state variables to original state.
    LOG.finest("++enter++");
    logQueryExecutionStart(sql);
    try {
      QueryJobConfiguration jobConfiguration =
          setDestinationDatasetAndTableInJobConfig(getJobConfig(sql).build());
      runQuery(sql, jobConfiguration);
    } catch (InterruptedException ex) {
      throw new BigQueryJdbcException(ex);
    }

    if (!isSingularResultSet()) {
      throw new BigQueryJdbcException(
          "Query returned more than one or didn't return any ResultSet.");
    }
    // This contains all the other assertions spec required on this method
    return getCurrentResultSet();
  }

  @Override
  public long executeLargeUpdate(String sql) throws SQLException {
    LOG.finest("++enter++");
    logQueryExecutionStart(sql);
    try {
      QueryJobConfiguration.Builder jobConfiguration = getJobConfig(sql);
      runQuery(sql, jobConfiguration.build());
    } catch (InterruptedException ex) {
      throw new BigQueryJdbcRuntimeException(ex);
    }
    if (this.currentUpdateCount == -1) {
      throw new BigQueryJdbcException(
          "Update query expected to return affected row count. Double check query type.");
    }
    return this.currentUpdateCount;
  }

  @Override
  public int executeUpdate(String sql) throws SQLException {
    LOG.finest("++enter++");
    return checkUpdateCount(executeLargeUpdate(sql));
  }

  int checkUpdateCount(long updateCount) {
    LOG.finest("++enter++");
    if (updateCount > Integer.MAX_VALUE) {
      LOG.warning("Warning: Table update exceeded maximum limit!");
      // Update count is -2 if update is successful but the update count exceeds Integer.MAX_VALUE
      return -2;
    }
    return (int) updateCount;
  }

  @Override
  public boolean execute(String sql) throws SQLException {
    LOG.finest("++enter++");
    logQueryExecutionStart(sql);
    try {
      QueryJobConfiguration jobConfiguration = getJobConfig(sql).build();
      // If Large Results are enabled, ensure query type is SELECT
      if (isLargeResultsEnabled() && getQueryType(jobConfiguration, null) == SqlType.SELECT) {
        jobConfiguration = setDestinationDatasetAndTableInJobConfig(jobConfiguration);
      }
      runQuery(sql, jobConfiguration);
    } catch (InterruptedException ex) {
      throw new BigQueryJdbcRuntimeException(ex);
    }
    return getCurrentResultSet() != null;
  }

  StatementType getStatementType(QueryJobConfiguration queryJobConfiguration) throws SQLException {
    LOG.finest("++enter++");
    QueryJobConfiguration dryRunJobConfiguration =
        queryJobConfiguration.toBuilder().setDryRun(true).build();
    Job job;
    try {
      job = bigQuery.create(JobInfo.of(dryRunJobConfiguration));
    } catch (BigQueryException ex) {
      if (ex.getMessage().contains("Syntax error")) {
        throw new BigQueryJdbcSqlSyntaxErrorException(ex);
      }
      throw new BigQueryJdbcException(ex);
    }
    QueryStatistics statistics = job.getStatistics();
    return statistics.getStatementType();
  }

  SqlType getQueryType(QueryJobConfiguration jobConfiguration, StatementType statementType)
      throws SQLException {
    LOG.finest("++enter++");
    if (statementType == null) {
      statementType = getStatementType(jobConfiguration);
    }

    SqlType sqlType = BigQuerySqlTypeConverter.getSqlTypeFromStatementType(statementType);
    LOG.fine(
        String.format(
            "Query: %s, Statement Type: %s, SQL Type: %s",
            jobConfiguration.getQuery(), statementType, sqlType));
    return sqlType;
  }

  QueryStatistics getQueryStatistics(QueryJobConfiguration queryJobConfiguration)
      throws BigQueryJdbcSqlSyntaxErrorException, BigQueryJdbcException {
    LOG.finest("++enter++");
    QueryJobConfiguration dryRunJobConfiguration =
        queryJobConfiguration.toBuilder().setDryRun(true).build();
    Job job;
    try {
      job = this.bigQuery.create(JobInfo.of(dryRunJobConfiguration));
      return job.getStatistics();
    } catch (BigQueryException ex) {
      if (ex.getMessage().contains("Syntax error")) {
        throw new BigQueryJdbcSqlSyntaxErrorException(ex);
      }
      throw new BigQueryJdbcException(ex);
    }
  }

  /**
   * Releases this Statement's BigQuery and JDBC resources immediately instead of waiting for this
   * to happen when it is automatically closed. These resources include the {@code ResultSet}
   * object, batch queries, job IDs, and BigQuery connection <br>
   *
   * <p>Calling the method close on a Statement object that is already closed has no effect.
   *
   * @throws SQLException if a BigQuery access error occurs
   */
  @Override
  public void close() throws SQLException {
    LOG.fine(String.format("Closing Statement %s.", this));
    if (isClosed()) {
      return;
    }

    boolean cancelSucceeded = false;
    try {
      cancel(); // This attempts to cancel jobs and calls closeStatementResources()
      cancelSucceeded = true;
    } catch (SQLException e) {
      LOG.warning(String.format("Failed to cancel statement during close().", e));
    } finally {
      if (!cancelSucceeded) {
        closeStatementResources();
      }
      this.connection = null;
      this.isClosed = true;
    }
  }

  @Override
  public int getMaxFieldSize() {
    return this.maxFieldSize;
  }

  @Override
  public void setMaxFieldSize(int max) {
    this.maxFieldSize = max;
  }

  @Override
  public int getMaxRows() {
    return this.maxRows;
  }

  @Override
  public void setMaxRows(int max) {
    this.maxRows = max;
  }

  @Override
  public void setEscapeProcessing(boolean enable) {
    // TODO: verify how to implement this method
  }

  @Override
  public int getQueryTimeout() {
    return this.queryTimeout;
  }

  @Override
  public void setQueryTimeout(int seconds) {
    if (seconds < 0) {
      throw new IllegalArgumentException("Query Timeout should be >= 0.");
    }
    this.queryTimeout = seconds;
  }

  /**
   * Cancels this {@code Statement} object, the running threads, and BigQuery jobs.
   *
   * @throws SQLException if a BigQuery access error occurs or this method is called on a closed
   *     {@code Statement}
   */
  @Override
  public void cancel() throws SQLException {
    LOG.finest(String.format("Statement %s cancelled", this));
    synchronized (cancelLock) {
      this.isCanceled = true;
      for (JobId jobId : this.jobIds) {
        try {
          this.bigQuery.cancel(jobId);
          LOG.info("Job " + jobId + "cancelled.");
        } catch (BigQueryException e) {
          if (e.getMessage() != null
              && (e.getMessage().contains("Job is already in state DONE")
                  || e.getMessage().contains("Error: 3848323"))) {
            LOG.warning("Attempted to cancel a job that was already done: " + jobId);
          } else {
            throw new BigQueryJdbcException(e);
          }
        }
      }
      jobIds.clear();
    }
    // If a ResultSet exists, then it will be closed as well, closing the
    // ownedThreads
    closeStatementResources();
  }

  @Override
  public SQLWarning getWarnings() {
    return this.warning;
  }

  @Override
  public void clearWarnings() {
    this.warning = null;
  }

  @Override
  public ResultSet getResultSet() {
    return this.currentResultSet;
  }

  @VisibleForTesting
  void setUpdateCount(long count) {
    this.currentUpdateCount = count;
  }

  @Override
  public int getUpdateCount() {
    return (int) this.currentUpdateCount;
  }

  @Override
  public long getLargeUpdateCount() {
    return this.currentUpdateCount;
  }

  @Override
  public boolean getMoreResults() throws SQLException {
    return getMoreResults(CLOSE_CURRENT_RESULT);
  }

  private void closeStatementResources() throws SQLException {
    LOG.finest("++enter++");
    if (this.currentResultSet != null) {
      // If Statement has 'CloseOnCompletion' set, resultset might
      // call into the same function; In order to avoid stack overflow
      // we will cleanup resultset before calling into 'close'.
      ResultSet tmp = this.currentResultSet;
      this.currentResultSet = null;
      tmp.close();
    }
    this.batchQueries.clear();
    this.currentUpdateCount = -1;
    this.currentJobIdIndex = -1;
    if (this.connection != null) {
      if (this.connection.isTransactionStarted()) {
        this.connection.rollback();
      }
      this.connection.removeStatement(this);
    }
  }

  private boolean isSingularResultSet() {
    return this.currentResultSet != null
        && (this.parentJobId == null || this.parentJobId.getJobs().size() == 1);
  }

  private String generateJobId() {
    return JDBC_JOB_PREFIX + UUID.randomUUID().toString();
  }

  private class ExecuteResult {
    public final TableResult tableResult;
    public final Job job;

    ExecuteResult(TableResult tableResult, Job job) {
      this.tableResult = tableResult;
      this.job = job;
    }
  }

  @InternalApi
  ExecuteResult executeJob(QueryJobConfiguration jobConfiguration)
      throws InterruptedException, BigQueryException, BigQueryJdbcException {
    LOG.finest("++enter++");
    Job job = null;
    // Location is not properly passed from the connection,
    // so we need to explicitly set it;
    // Do not set custom JobId here or it will disable jobless queries.
    JobId jobId = JobId.newBuilder().setLocation(connection.getLocation()).build();
    if (connection.getUseStatelessQueryMode()) {
      Object result = bigQuery.queryWithTimeout(jobConfiguration, jobId, null);
      if (result instanceof TableResult) {
        TableResult tableResult = (TableResult) result;
        if (tableResult.getJobId() != null) {
          return new ExecuteResult(tableResult, bigQuery.getJob(tableResult.getJobId()));
        }
        return new ExecuteResult((TableResult) result, null);
      }

      if (result instanceof Job) {
        job = (Job) result;
      } else {
        throw new BigQueryJdbcException("Unexpected result type from queryWithTimeout");
      }
    } else {
      // Update jobId with custom JobId if jobless query is disabled.
      jobId = jobId.toBuilder().setJob(generateJobId()).build();
      JobInfo jobInfo = JobInfo.newBuilder(jobConfiguration).setJobId(jobId).build();
      job = bigQuery.create(jobInfo);
    }

    if (job == null) {
      throw new BigQueryJdbcException("Failed to create BQ Job.");
    }
    synchronized (cancelLock) {
      if (isCanceled) {
        job.cancel();
        throw new BigQueryJdbcException("Query was cancelled.");
      }
      jobId = job.getJobId();
      jobIds.add(jobId);
    }
    LOG.info("Query submitted with Job ID: " + job.getJobId().getJob());
    TableResult result =
        job.getQueryResults(QueryResultsOption.pageSize(querySettings.getMaxResultPerPage()));
    synchronized (cancelLock) {
      jobIds.remove(jobId);
    }
    return new ExecuteResult(result, job);
  }

  /**
   * Execute the SQL script and sets the reference of the underlying job, passing null querySettings
   * will result in the FastQueryPath
   */
  @InternalApi
  void runQuery(String query, QueryJobConfiguration jobConfiguration)
      throws SQLException, InterruptedException {
    LOG.finest("++enter++");
    LOG.fine("Run Query started");

    if (queryTimeout > 0) {
      jobConfiguration =
          jobConfiguration.toBuilder().setJobTimeoutMs(Long.valueOf(queryTimeout) * 1000).build();
    }

    try {
      resetStatementFields();
      ExecuteResult executeResult = executeJob(jobConfiguration);
      StatementType statementType =
          executeResult.job == null
              ? getStatementType(jobConfiguration)
              : ((QueryStatistics) executeResult.job.getStatistics()).getStatementType();
      SqlType queryType = getQueryType(jobConfiguration, statementType);
      handleQueryResult(query, executeResult.tableResult, queryType);
    } catch (InterruptedException ex) {
      throw new BigQueryJdbcRuntimeException(ex);
    } catch (BigQueryException ex) {
      if (ex.getMessage().contains("Syntax error")) {
        throw new BigQueryJdbcSqlSyntaxErrorException(ex);
      }
      throw new BigQueryJdbcException(ex);
    }
  }

  private boolean isLargeResultsEnabled() {
    String destinationTable = this.querySettings.getDestinationTable();
    String destinationDataset = this.querySettings.getDestinationDataset();
    return destinationDataset != null || destinationTable != null;
  }

  private QueryJobConfiguration setDestinationDatasetAndTableInJobConfig(
      QueryJobConfiguration jobConfiguration) {
    String destinationTable = this.querySettings.getDestinationTable();
    String destinationDataset = this.querySettings.getDestinationDataset();
    if (destinationDataset != null || destinationTable != null) {
      if (destinationDataset != null) {
        checkIfDatasetExistElseCreate(destinationDataset);
      }
      if (jobConfiguration.useLegacySql() && destinationDataset == null) {
        checkIfDatasetExistElseCreate(DEFAULT_DATASET_NAME);
        destinationDataset = DEFAULT_DATASET_NAME;
      }
      if (destinationTable == null) {
        destinationTable = getDefaultDestinationTable();
      }
      return jobConfiguration.toBuilder()
          .setAllowLargeResults(this.querySettings.getAllowLargeResults())
          .setDestinationTable(TableId.of(destinationDataset, destinationTable))
          .setCreateDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
          .setWriteDisposition(JobInfo.WriteDisposition.WRITE_TRUNCATE)
          .build();
    }
    return jobConfiguration;
  }

  Job getNextJob() {
    while (this.currentJobIdIndex + 1 < this.parentJobId.getJobs().size()) {
      this.currentJobIdIndex += 1;
      Job currentJob = this.parentJobId.getJobs().get(this.currentJobIdIndex);
      QueryStatistics queryStatistics = currentJob.getStatistics();
      ScriptStatistics scriptStatistics = queryStatistics.getScriptStatistics();
      // EXPRESSION jobs are not relevant for customer query and can be
      // created by BQ depending on various conditions. We will just ignore
      // them when presenting results.
      if (!"expression".equalsIgnoreCase(scriptStatistics.getEvaluationKind())) {
        return currentJob;
      }
    }
    return null;
  }

  void handleQueryResult(String query, TableResult results, SqlType queryType)
      throws SQLException, InterruptedException {
    LOG.finest("++enter++");
    switch (queryType) {
      case SELECT:
        processQueryResponse(query, results);
        break;
      case DML:
      case DML_EXTRA:
        try {
          Job completedJob = this.bigQuery.getJob(results.getJobId()).waitFor();
          JobStatistics.QueryStatistics statistics = completedJob.getStatistics();
          updateAffectedRowCount(statistics.getNumDmlAffectedRows());
        } catch (InterruptedException ex) {
          throw new BigQueryJdbcRuntimeException(ex);
        } catch (NullPointerException ex) {
          throw new BigQueryJdbcException(ex);
        }
        break;
      case TCL:
      case DDL:
        updateAffectedRowCount(results.getTotalRows());
        break;
      case SCRIPT:
        try {
          Page<Job> childJobs =
              this.bigQuery.listJobs(JobListOption.parentJobId(results.getJobId().getJob()));

          ArrayList<Job> childJobList = new ArrayList<>();
          Iterator<Job> iterableJobs = childJobs.iterateAll().iterator();
          iterableJobs.forEachRemaining(childJobList::add);
          Collections.reverse(childJobList);

          this.scriptQuery = query;
          this.parentJobId = new JobIdWrapper(results.getJobId(), results, childJobList);
          this.currentJobIdIndex = -1;

          Job currentJob = getNextJob();
          if (currentJob == null) {
            return;
          }
          StatementType statementType =
              ((QueryStatistics) (currentJob.getStatistics())).getStatementType();
          SqlType sqlType = getQueryType(currentJob.getConfiguration(), statementType);
          handleQueryResult(query, currentJob.getQueryResults(), sqlType);
        } catch (NullPointerException ex) {
          throw new BigQueryJdbcException(ex);
        }
        break;
      case OTHER:
        throw new BigQueryJdbcException(String.format("Unexpected value: " + queryType));
    }
  }

  private void updateAffectedRowCount(Long count) throws SQLException {
    // TODO(neenu): check if this need to be closed vs removed)
    if (this.currentResultSet != null) {
      try {
        this.currentResultSet.close();
        this.currentResultSet = null;
      } catch (SQLException ex) {
        throw new BigQueryJdbcException(ex);
      }
    }
    this.currentUpdateCount = count;
  }

  @InternalApi
  BigQueryReadClient getBigQueryReadClient() {
    if (this.bigQueryReadClient == null) {
      this.bigQueryReadClient = this.connection.getBigQueryReadClient();
    }
    return this.bigQueryReadClient;
  }

  @InternalApi
  ReadSession getReadSession(CreateReadSessionRequest readSessionRequest) {
    LOG.finest("++enter++");
    return getBigQueryReadClient().createReadSession(readSessionRequest);
  }

  @InternalApi
  ArrowSchema getArrowSchema(ReadSession readSession) {
    return readSession.getArrowSchema();
  }

  /** Uses Bigquery Storage Read API and returns the stream as ResultSet */
  @InternalApi
  ResultSet processArrowResultSet(TableResult results) throws SQLException {
    LOG.finest("++enter++");

    // set the resultset
    long totalRows = (getMaxRows() > 0) ? getMaxRows() : results.getTotalRows();
    JobId currentJobId = results.getJobId();
    TableId destinationTable = getDestinationTable(currentJobId);
    Schema schema = results.getSchema();
    try {
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
              .setMaxStreamCount(1);

      ReadSession readSession = getReadSession(builder.build());
      this.arrowBatchWrapperBlockingQueue = new LinkedBlockingDeque<>(getBufferSize());
      // deserialize and populate the buffer async, so that the client isn't blocked
      Thread populateBufferWorker =
          populateArrowBufferedQueue(
              readSession, this.arrowBatchWrapperBlockingQueue, this.bigQueryReadClient);

      BigQueryArrowResultSet arrowResultSet =
          BigQueryArrowResultSet.of(
              schema,
              getArrowSchema(readSession),
              totalRows,
              this,
              this.arrowBatchWrapperBlockingQueue,
              populateBufferWorker,
              this.bigQuery);
      arrowResultSetFinalizers.add(
          new BigQueryResultSetFinalizers.ArrowResultSetFinalizer(
              arrowResultSet, referenceQueueArrowRs, populateBufferWorker));
      arrowResultSet.setJobId(currentJobId);
      return arrowResultSet;

    } catch (Exception ex) {
      throw new BigQueryJdbcException(ex.getMessage(), ex);
    }
  }

  /** Asynchronously reads results and populates an arrow record queue */
  @InternalApi
  Thread populateArrowBufferedQueue(
      ReadSession readSession,
      BlockingQueue<BigQueryArrowBatchWrapper> arrowBatchWrapperBlockingQueue,
      BigQueryReadClient bqReadClient) {
    LOG.finest("++enter++");

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

              ArrowRecordBatch currentBatch = response.getArrowRecordBatch();
              arrowBatchWrapperBlockingQueue.put(BigQueryArrowBatchWrapper.of(currentBatch));
            }

          } catch (RuntimeException | InterruptedException e) {
            LOG.log(
                Level.WARNING,
                "\n" + Thread.currentThread().getName() + " Interrupted @ arrowStreamProcessor",
                e);
          } finally { // logic needed for graceful shutdown
            // marking end of stream
            try {
              arrowBatchWrapperBlockingQueue.put(
                  BigQueryArrowBatchWrapper.of(null, true)); // mark the end of the stream
            } catch (InterruptedException e) {
              LOG.log(
                  Level.WARNING,
                  "\n" + Thread.currentThread().getName() + " Interrupted @ markLast",
                  e);
            }
          }
        };

    Thread populateBufferWorker = JDBC_THREAD_FACTORY.newThread(arrowStreamProcessor);
    populateBufferWorker.start();
    return populateBufferWorker;
  }

  /** Executes SQL query using either fast query path or read API */
  void processQueryResponse(String query, TableResult results) throws SQLException {
    LOG.finest(
        String.format(
            "API call completed{Query=%s, Parent Job ID=%s, Total rows=%s} ",
            query, results.getJobId(), results.getTotalRows()));
    JobId currentJobId = results.getJobId();
    if (currentJobId == null) {
      LOG.fine("Standard API with Stateless query used.");
      this.currentResultSet = processJsonResultSet(results);
    } else if (useReadAPI(results)) {
      LOG.fine("HighThroughputAPI used.");
      LOG.info("HTAPI job ID: " + currentJobId.getJob());
      this.currentResultSet = processArrowResultSet(results);
    } else {
      // read API cannot be used.
      LOG.fine("Standard API used.");
      this.currentResultSet = processJsonResultSet(results);
    }
    this.currentUpdateCount = -1;
  }

  // The read Ratio should be met
  // AND the User must not have disabled the Read API
  @VisibleForTesting
  boolean useReadAPI(TableResult results) throws BigQueryJdbcSqlFeatureNotSupportedException {
    LOG.finest("++enter++");
    if (!meetsReadRatio(results)) {
      return false;
    }
    LOG.fine("Read API threshold is met.");
    return querySettings.getUseReadAPI();
  }

  private boolean meetsReadRatio(TableResult results) {
    LOG.finest("++enter++");
    long totalRows = results.getTotalRows();

    if (totalRows == 0 || totalRows < querySettings.getHighThroughputMinTableSize()) {
      return false;
    }

    // TODO(BQ Team): TableResult doesnt expose the number of records in the current page, hence the
    // below log iterates and counts. This is inefficient and we may eventually want to expose
    // PageSize with TableResults
    // TODO(Obada): Scope for performance optimization.
    int pageSize = Iterators.size(results.getValues().iterator());
    return totalRows / pageSize > querySettings.getHighThroughputActivationRatio();
  }

  BigQueryJsonResultSet processJsonResultSet(TableResult results) {
    String jobIdOrQueryId =
        results.getJobId() == null ? results.getQueryId() : results.getJobId().getJob();
    LOG.info(String.format("BigQuery Job %s completed. Fetching results.", jobIdOrQueryId));
    List<Thread> threadList = new ArrayList<Thread>();

    Schema schema = results.getSchema();
    long totalRows = (getMaxRows() > 0) ? getMaxRows() : results.getTotalRows();
    this.bigQueryFieldValueListWrapperBlockingQueue = new LinkedBlockingDeque<>(getBufferSize());
    BlockingQueue<Tuple<TableResult, Boolean>> rpcResponseQueue =
        new LinkedBlockingDeque<>(getPageCacheSize(getBufferSize(), schema));

    JobId jobId = results.getJobId();
    if (jobId != null) {
      // Thread to make rpc calls to fetch data from the server
      Thread nextPageWorker =
          runNextPageTaskAsync(results, results.getNextPageToken(), jobId, rpcResponseQueue);
      threadList.add(nextPageWorker);
    } else {
      try {
        populateFirstPage(results, rpcResponseQueue);
        rpcResponseQueue.put(Tuple.of(null, false));
      } catch (InterruptedException e) {
        LOG.log(
            Level.WARNING,
            "\n"
                + Thread.currentThread().getName()
                + " Interrupted @ processJsonQueryResponseResults");
      }
    }

    // Thread to parse data received from the server to client library objects
    Thread populateBufferWorker =
        parseAndPopulateRpcDataAsync(
            schema, this.bigQueryFieldValueListWrapperBlockingQueue, rpcResponseQueue);
    threadList.add(populateBufferWorker);

    Thread[] jsonWorkers = threadList.toArray(new Thread[0]);

    BigQueryJsonResultSet jsonResultSet =
        BigQueryJsonResultSet.of(
            schema,
            totalRows,
            this.bigQueryFieldValueListWrapperBlockingQueue,
            this,
            jsonWorkers,
            this.bigQuery);
    jsonResultSet.setJobId(jobId);
    jsonResultSet.setQueryId(results.getQueryId());
    jsonResultSetFinalizers.add(
        new BigQueryResultSetFinalizers.JsonResultSetFinalizer(
            jsonResultSet, referenceQueueJsonRs, jsonWorkers));
    return jsonResultSet;
  }

  void populateFirstPage(
      TableResult result, BlockingQueue<Tuple<TableResult, Boolean>> rpcResponseQueue) {
    LOG.finest("++enter++");
    // parse and put the first page in the pageCache before the other pages are parsed from the RPC
    // calls
    try {
      // this is the first page which we have received.
      rpcResponseQueue.put(Tuple.of(result, true));
    } catch (InterruptedException e) {
      LOG.log(
          Level.WARNING,
          "\n" + Thread.currentThread().getName() + " Interrupted @ populateFirstPage");
    }
  }

  @Override
  public void setFetchDirection(int direction) throws SQLException {
    if (direction != ResultSet.FETCH_FORWARD) {
      throw new BigQueryJdbcSqlFeatureNotSupportedException("Only FETCH_FORWARD is supported.");
    }
    this.fetchDirection = direction;
  }

  @VisibleForTesting
  Thread runNextPageTaskAsync(
      TableResult result,
      String firstPageToken,
      JobId jobId,
      BlockingQueue<Tuple<TableResult, Boolean>> rpcResponseQueue) {
    LOG.finest("++enter++");
    // parse and put the first page in the pageCache before the other pages are parsed from the RPC
    // calls
    populateFirstPage(result, rpcResponseQueue);

    // This thread makes the RPC calls and paginates
    Runnable nextPageTask =
        () -> {
          // results.getPageToken();
          String pageToken = firstPageToken;
          TableId destinationTable = null;
          if (firstPageToken != null) {
            destinationTable = getDestinationTable(jobId);
          }
          try {
            // paginate for non null token
            while (pageToken != null) {
              // do not process further pages and shutdown
              if (Thread.currentThread().isInterrupted() || queryTaskExecutor.isShutdown()) {
                LOG.log(
                    Level.WARNING,
                    "\n"
                        + Thread.currentThread().getName()
                        + " Interrupted @ runNextPageTaskAsync");
                break;
              }
              long startTime = System.nanoTime();
              TableResult results =
                  this.bigQuery.listTableData(
                      destinationTable,
                      TableDataListOption.pageSize(querySettings.getMaxResultPerPage()),
                      TableDataListOption.pageToken(pageToken));

              pageToken = results.getNextPageToken();
              // this will be parsed asynchronously without blocking the current
              // thread
              rpcResponseQueue.put(Tuple.of(results, true));
              LOG.fine(
                  String.format(
                      "Fetched %d results from the server in %d ms.",
                      querySettings.getMaxResultPerPage(),
                      (int) ((System.nanoTime() - startTime) / 1000000)));
            }
            // this will stop the parseDataTask as well when the pagination
            // completes
            rpcResponseQueue.put(Tuple.of(null, false));
          } catch (Exception ex) {
            throw new BigQueryJdbcRuntimeException(ex);
          }
          // We cannot do queryTaskExecutor.shutdownNow() here as populate buffer method may not
          // have finished processing the records and even that will be interrupted
        };

    Thread nextPageWorker = JDBC_THREAD_FACTORY.newThread(nextPageTask);
    nextPageWorker.start();
    return nextPageWorker;
  }

  /**
   * Takes TableResult from rpcResponseQueue and populates
   * bigQueryFieldValueListWrapperBlockingQueue with FieldValueList
   */
  @VisibleForTesting
  Thread parseAndPopulateRpcDataAsync(
      Schema schema,
      BlockingQueue<BigQueryFieldValueListWrapper> bigQueryFieldValueListWrapperBlockingQueue,
      BlockingQueue<Tuple<TableResult, Boolean>> rpcResponseQueue) {
    LOG.finest("++enter++");

    Runnable populateBufferRunnable =
        () -> { // producer thread populating the buffer
          Iterable<FieldValueList> fieldValueLists;
          // as we have to process the first page
          boolean hasRows = true;
          while (hasRows) {
            try {
              Tuple<TableResult, Boolean> nextPageTuple = rpcResponseQueue.take();
              if (nextPageTuple.x() != null) {
                fieldValueLists = nextPageTuple.x().getValues();
              } else {
                fieldValueLists = null;
              }
              hasRows = nextPageTuple.y();

            } catch (InterruptedException e) {
              LOG.log(Level.WARNING, "\n" + Thread.currentThread().getName() + " Interrupted", e);
              // Thread might get interrupted while calling the Cancel method, which is
              // expected, so logging this instead of throwing the exception back
              break;
            }

            if (Thread.currentThread().isInterrupted()
                || queryTaskExecutor.isShutdown()
                || fieldValueLists == null) {
              // do not process further pages and shutdown (outerloop)
              break;
            }

            long startTime = System.nanoTime();
            long results = 0;
            for (FieldValueList fieldValueList : fieldValueLists) {
              try {
                if (Thread.currentThread().isInterrupted() || queryTaskExecutor.isShutdown()) {
                  // do not process further pages and shutdown (inner loop)
                  break;
                }
                bigQueryFieldValueListWrapperBlockingQueue.put(
                    BigQueryFieldValueListWrapper.of(schema.getFields(), fieldValueList));
                results += 1;
              } catch (InterruptedException ex) {
                throw new BigQueryJdbcRuntimeException(ex);
              }
            }
            LOG.fine(
                String.format(
                    "Processed %d results in %d ms.",
                    results, (int) ((System.nanoTime() - startTime) / 1000000)));
          }
          try {
            // All the pages has been processed, put this marker
            bigQueryFieldValueListWrapperBlockingQueue.put(
                BigQueryFieldValueListWrapper.of(null, null, true));
          } catch (InterruptedException e) {
            LOG.log(
                Level.WARNING,
                "\n" + Thread.currentThread().getName() + " Interrupted @ populateBufferAsync",
                e);
          }
        };

    Thread populateBufferWorker = JDBC_THREAD_FACTORY.newThread(populateBufferRunnable);
    populateBufferWorker.start();
    return populateBufferWorker;
  }

  /**
   * Helper method that determines the optimal number of caches pages to improve read performance
   */
  @VisibleForTesting
  int getPageCacheSize(Integer numBufferedRows, Schema schema) {
    LOG.finest("++enter++");
    // Min number of pages to cache
    final int MIN_CACHE_SIZE = 3;
    // Min number of pages to cache
    final int MAX_CACHE_SIZE = 20;
    int numColumns = schema.getFields().size();
    int numCachedPages;
    long numCachedRows = numBufferedRows == null ? 0 : numBufferedRows.longValue();

    // TODO: Further enhance this logic depending on customer feedback on memory consumption
    if (numCachedRows > 10000) {
      // the size of numBufferedRows is quite large and as per our tests we should be able to
      // do enough even with low
      numCachedPages = 2;
    }
    // too many fields are being read, setting the page size on the lower end
    else if (numColumns > 15 && numCachedRows > 5000) {
      numCachedPages = 3;
    }
    // low pagesize with fewer number of columns, we can cache more pages
    else if (numCachedRows < 2000 && numColumns < 15) {
      numCachedPages = 20;
    }
    // default - under 10K numCachedRows with any number of columns
    else {
      numCachedPages = 5;
    }
    return numCachedPages < MIN_CACHE_SIZE
        ? MIN_CACHE_SIZE
        : (Math.min(numCachedPages, MAX_CACHE_SIZE));
  }

  @Override
  public int getFetchDirection() {
    return this.fetchDirection;
  }

  // TODO(neenu): Fix this value
  // getNumBufferedRows in querySettings is always the same withDefaultValues - 20000 buffer size
  // So, getBufferSize is also 20000.
  private int getBufferSize() {
    return (this.querySettings == null
            || this.querySettings.getNumBufferedRows() == null
            || this.querySettings.getNumBufferedRows() < 10000
        ? 20000
        : Math.min(this.querySettings.getNumBufferedRows() * 2, 100000));
  }

  /** Returns the destinationTable from jobId by calling `jobs.get` API */
  TableId getDestinationTable(JobId jobId) {
    Job job = this.bigQuery.getJob(jobId);
    LOG.finest(String.format("Destination Table retrieved from %s", job.getJobId()));
    return ((QueryJobConfiguration) job.getConfiguration()).getDestinationTable();
  }

  QueryJobConfiguration.Builder getJobConfig(String query) {
    LOG.finest("++enter++");
    QueryJobConfiguration.Builder queryConfigBuilder = QueryJobConfiguration.newBuilder(query);
    if (this.querySettings.getJobTimeoutMs() > 0) {
      queryConfigBuilder.setJobTimeoutMs(this.querySettings.getJobTimeoutMs());
    }
    if (this.querySettings.getMaxBytesBilled() > 0) {
      queryConfigBuilder.setMaximumBytesBilled(this.querySettings.getMaxBytesBilled());
    }
    if (this.querySettings.getDefaultDataset() != null) {
      queryConfigBuilder.setDefaultDataset(this.querySettings.getDefaultDataset());
    }
    Map<String, String> mergedLabels = new HashMap<>();
    if (this.querySettings.getLabels() != null) {
      mergedLabels.putAll(this.querySettings.getLabels());
    }
    if (this.extraLabels != null) {
      mergedLabels.putAll(this.extraLabels);
    }
    queryConfigBuilder.setLabels(mergedLabels);
    queryConfigBuilder.setUseQueryCache(this.querySettings.getUseQueryCache());
    queryConfigBuilder.setMaxResults(this.querySettings.getMaxResultPerPage());
    if (this.querySettings.getSessionInfoConnectionProperty() != null) {
      queryConfigBuilder.setConnectionProperties(
          ImmutableList.of(this.querySettings.getSessionInfoConnectionProperty()));
    } else {
      queryConfigBuilder.setCreateSession(querySettings.isEnableSession());
    }
    if (this.querySettings.getKmsKeyName() != null) {
      EncryptionConfiguration encryption =
          EncryptionConfiguration.newBuilder()
              .setKmsKeyName(this.querySettings.getKmsKeyName())
              .build();
      queryConfigBuilder.setDestinationEncryptionConfiguration(encryption);
    }
    if (this.querySettings.getQueryProperties() != null) {
      queryConfigBuilder.setConnectionProperties(this.querySettings.getQueryProperties());
    }
    boolean useLegacy =
        QueryDialectType.BIG_QUERY.equals(
            QueryDialectType.valueOf(this.querySettings.getQueryDialect()));
    queryConfigBuilder.setUseLegacySql(useLegacy);

    return queryConfigBuilder;
  }

  private void checkIfDatasetExistElseCreate(String datasetName) {
    Dataset dataset = bigQuery.getDataset(DatasetId.of(datasetName));
    if (dataset == null) {
      LOG.info(String.format("Creating a hidden dataset: %s ", datasetName));
      DatasetInfo datasetInfo =
          DatasetInfo.newBuilder(datasetName)
              .setDefaultTableLifetime(this.querySettings.getDestinationDatasetExpirationTime())
              .build();
      bigQuery.create(datasetInfo);
    }
  }

  private String getDefaultDestinationTable() {
    String timeOfCreation = String.valueOf(Instant.now().toEpochMilli());
    String randomizedId = String.valueOf(new Random().nextInt(9999));
    return DEFAULT_TABLE_NAME + timeOfCreation + randomizedId;
  }

  @InternalApi
  JobIdWrapper insertJob(JobConfiguration jobConfiguration) throws SQLException {
    Job job;
    JobInfo jobInfo = JobInfo.of(jobConfiguration);
    LOG.finest("++enter++");
    try {
      job = this.bigQuery.create(jobInfo);
    } catch (BigQueryException ex) {
      throw new BigQueryJdbcException(ex);
    }
    return new JobIdWrapper(job.getJobId(), null, null);
  }

  @Override
  public void setFetchSize(int rows) {
    this.fetchSize = rows;
  }

  @Override
  public int getFetchSize() {
    return this.fetchSize;
  }

  /**
   * Gets the extra labels for this statement.
   *
   * @return A map of the extra labels.
   */
  public Map<String, String> getExtraLabels() {
    return this.extraLabels;
  }

  /**
   * Sets the extra labels for this statement.
   *
   * @param extraLabels A map of the extra labels.
   */
  public void setExtraLabels(Map<String, String> extraLabels) {
    this.extraLabels = extraLabels;
  }

  @Override
  public int getResultSetConcurrency() {
    return ResultSet.CONCUR_READ_ONLY;
  }

  ResultSet getCurrentResultSet() {
    return this.currentResultSet;
  }

  @Override
  public int getResultSetType() {
    return ResultSet.TYPE_FORWARD_ONLY;
  }

  /**
   * Wraps jobId and the firstPage of QueryResponse, so that we can avoid RPC to fetch the first
   * page again
   */
  static class JobIdWrapper {

    private JobId jobId;
    private TableResult firstPage;
    private ArrayList<Job> jobs;

    public JobIdWrapper(JobId jobId, TableResult firstPage, ArrayList<Job> jobs) {
      this.jobId = jobId;
      this.firstPage = firstPage;
      this.jobs = jobs;
    }

    JobId getJobId() {
      return this.jobId;
    }

    void setJobId(JobId jobId) {
      this.jobId = jobId;
    }

    TableResult getResults() {
      return this.firstPage;
    }

    void setResults(TableResult firstPage) {
      this.firstPage = firstPage;
    }

    ArrayList<Job> getJobs() {
      return jobs;
    }

    void setJobs(ArrayList<Job> jobs) {
      this.jobs = jobs;
    }
  }

  @Override
  public void addBatch(String sql) throws SQLException {
    if (sql == null || sql.isEmpty()) {
      return;
    }
    LOG.finest("++enter++");
    sql = sql.trim();
    if (!sql.endsWith(";")) {
      sql += "; ";
    }
    SqlType sqlType = getQueryType(QueryJobConfiguration.newBuilder(sql).build(), null);
    if (!SqlType.DML.equals(sqlType)) {
      throw new IllegalArgumentException("addBatch currently supports DML operations.");
    }
    this.batchQueries.add(sql);
  }

  @Override
  public void clearBatch() {
    this.batchQueries.clear();
  }

  @Override
  public int[] executeBatch() throws SQLException {
    LOG.finest("++enter++");
    int[] result = new int[this.batchQueries.size()];
    if (this.batchQueries.isEmpty()) {
      return result;
    }

    try {
      String combinedQueries = String.join("", this.batchQueries);
      QueryJobConfiguration.Builder jobConfiguration = getJobConfig(combinedQueries);
      jobConfiguration.setPriority(QueryJobConfiguration.Priority.BATCH);
      runQuery(combinedQueries, jobConfiguration.build());
    } catch (InterruptedException ex) {
      throw new BigQueryJdbcRuntimeException(ex);
    }

    int i = 0;
    while (getUpdateCount() != -1 && i < this.batchQueries.size()) {
      result[i] = getUpdateCount();
      getMoreResults();
      i++;
    }

    clearBatch();
    return result;
  }

  @Override
  public Connection getConnection() {
    return this.connection;
  }

  public boolean hasMoreResults() {
    if (this.parentJobId == null) {
      return false;
    }
    return this.currentJobIdIndex + 1 < this.parentJobId.getJobs().size();
  }

  @Override
  public boolean getMoreResults(int current) throws SQLException {
    LOG.finest("++enter++");
    checkClosed();
    if (current != CLOSE_CURRENT_RESULT) {
      throw new BigQueryJdbcSqlFeatureNotSupportedException(
          "The JDBC driver only supports Statement.CLOSE_CURRENT_RESULT.");
    }

    if (this.parentJobId == null) {
      return false;
    }

    try {
      if (this.currentResultSet != null) {
        this.currentResultSet.close();
        this.currentResultSet = null;
        // Statement can be closed if it was the last result
        if (isClosed) {
          return false;
        }
      }

      Job currentJob = getNextJob();
      if (currentJob != null) {
        StatementType statementType =
            ((QueryStatistics) (currentJob.getStatistics())).getStatementType();
        SqlType sqlType = getQueryType(currentJob.getConfiguration(), statementType);
        handleQueryResult(this.scriptQuery, currentJob.getQueryResults(), sqlType);

        return sqlType == SqlType.SELECT;
      } else {
        resetStatementFields();
        return false;
      }
    } catch (InterruptedException | SQLException ex) {
      throw new BigQueryJdbcRuntimeException(ex);
    }
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) {
    return iface.isInstance(this);
  }

  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    if (!isWrapperFor(iface)) {
      throw new BigQueryJdbcException(
          String.format("Unable to cast Statement to %s class.", iface.getName()));
    }
    return (T) this;
  }

  @Override
  public int getResultSetHoldability() {
    return ResultSet.CLOSE_CURSORS_AT_COMMIT;
  }

  @Override
  public boolean isClosed() {
    return this.isClosed;
  }

  @Override
  public void setPoolable(boolean poolable) {
    this.poolable = poolable;
  }

  @Override
  public boolean isPoolable() {
    return this.poolable;
  }

  @Override
  public void closeOnCompletion() {
    this.closeOnCompletion = true;
  }

  @Override
  public boolean isCloseOnCompletion() {
    return this.closeOnCompletion;
  }

  protected void logQueryExecutionStart(String sql) {
    if (sql == null) {
      return;
    }
    String sanitizedSql = sql.trim().replaceAll("\\s+", " ");
    String truncatedSql =
        sanitizedSql.length() > 256 ? sanitizedSql.substring(0, 256) + "..." : sanitizedSql;
    LOG.info("Executing query: " + truncatedSql);
    LOG.info("Using query settings: " + this.querySettings.toString());
  }

  /** Throws a {@link BigQueryJdbcException} if this object is closed */
  void checkClosed() throws SQLException {
    if (isClosed()) {
      throw new BigQueryJdbcException("This " + getClass().getName() + " has been closed");
    }
  }

  enum SqlType {
    SELECT,
    DML,
    DML_EXTRA,
    DDL,
    SCRIPT,
    TCL,
    OTHER
  }

  enum QueryDialectType {
    SQL,
    BIG_QUERY
  }
}
