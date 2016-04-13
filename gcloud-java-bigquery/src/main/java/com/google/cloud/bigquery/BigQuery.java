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

package com.google.cloud.bigquery;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.cloud.FieldSelector;
import com.google.cloud.FieldSelector.Helper;
import com.google.cloud.Page;
import com.google.cloud.Service;
import com.google.cloud.bigquery.spi.BigQueryRpc;

import java.util.List;

/**
 * An interface for Google Cloud BigQuery.
 *
 * @see <a href="https://cloud.google.com/bigquery/what-is-bigquery">Google Cloud BigQuery</a>
 */
public interface BigQuery extends Service<BigQueryOptions> {

  /**
   * Fields of a BigQuery Dataset resource.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/datasets#resource">Dataset
   *     Resource</a>
   */
  enum DatasetField implements FieldSelector {
    ACCESS("access"),
    CREATION_TIME("creationTime"),
    DATASET_REFERENCE("datasetReference"),
    DEFAULT_TABLE_EXPIRATION_MS("defaultTableExpirationMsS"),
    DESCRIPTION("description"),
    ETAG("etag"),
    FRIENDLY_NAME("friendlyName"),
    ID("id"),
    LAST_MODIFIED_TIME("lastModifiedTime"),
    LOCATION("location"),
    SELF_LINK("selfLink");

    static final List<? extends FieldSelector> REQUIRED_FIELDS =
        ImmutableList.of(DATASET_REFERENCE);

    private final String selector;

    DatasetField(String selector) {
      this.selector = selector;
    }

    @Override
    public String selector() {
      return selector;
    }
  }

  /**
   * Fields of a BigQuery Table resource.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#resource">Table
   *     Resource</a>
   */
  enum TableField implements FieldSelector {
    CREATION_TIME("creationTime"),
    DESCRIPTION("description"),
    ETAG("etag"),
    EXPIRATION_TIME("expirationTime"),
    EXTERNAL_DATA_CONFIGURATION("externalDataConfiguration"),
    FRIENDLY_NAME("friendlyName"),
    ID("id"),
    LAST_MODIFIED_TIME("lastModifiedTime"),
    LOCATION("location"),
    NUM_BYTES("numBytes"),
    NUM_ROWS("numRows"),
    SCHEMA("schema"),
    SELF_LINK("selfLink"),
    STREAMING_BUFFER("streamingBuffer"),
    TABLE_REFERENCE("tableReference"),
    TYPE("type"),
    VIEW("view");

    static final List<? extends FieldSelector> REQUIRED_FIELDS =
        ImmutableList.of(TABLE_REFERENCE, TYPE);

    private final String selector;

    TableField(String selector) {
      this.selector = selector;
    }

    @Override
    public String selector() {
      return selector;
    }
  }

  /**
   * Fields of a BigQuery Job resource.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#resource">Job Resource
   *     </a>
   */
  enum JobField implements FieldSelector {
    CONFIGURATION("configuration"),
    ETAG("etag"),
    ID("id"),
    JOB_REFERENCE("jobReference"),
    SELF_LINK("selfLink"),
    STATISTICS("statistics"),
    STATUS("status"),
    USER_EMAIL("user_email");

    static final List<? extends FieldSelector> REQUIRED_FIELDS =
        ImmutableList.of(JOB_REFERENCE, CONFIGURATION);

    private final String selector;

    JobField(String selector) {
      this.selector = selector;
    }

    @Override
    public String selector() {
      return selector;
    }
  }

  /**
   * Class for specifying dataset list options.
   */
  class DatasetListOption extends Option {

    private static final long serialVersionUID = 8660294969063340498L;

    private DatasetListOption(BigQueryRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the maximum number of datasets returned per page.
     */
    public static DatasetListOption pageSize(long pageSize) {
      return new DatasetListOption(BigQueryRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing datasets.
     */
    public static DatasetListOption pageToken(String pageToken) {
      return new DatasetListOption(BigQueryRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an options to list all datasets, even hidden ones.
     */
    public static DatasetListOption all() {
      return new DatasetListOption(BigQueryRpc.Option.ALL_DATASETS, true);
    }
  }

  /**
   * Class for specifying dataset get, create and update options.
   */
  class DatasetOption extends Option {

    private static final long serialVersionUID = 1674133909259913250L;

    private DatasetOption(BigQueryRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the dataset's fields to be returned by the RPC call. If this
     * option is not provided all dataset's fields are returned. {@code DatasetOption.fields} can
     * be used to specify only the fields of interest. {@link Dataset#datasetId()} is always
     * returned, even if not specified.
     */
    public static DatasetOption fields(DatasetField... fields) {
      return new DatasetOption(BigQueryRpc.Option.FIELDS,
          Helper.selector(DatasetField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying dataset delete options.
   */
  class DatasetDeleteOption extends Option {

    private static final long serialVersionUID = -7166083569900951337L;

    private DatasetDeleteOption(BigQueryRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to delete a dataset even if non-empty. If not provided, attempting to
     * delete a non-empty dataset will result in a {@link BigQueryException} being thrown.
     */
    public static DatasetDeleteOption deleteContents() {
      return new DatasetDeleteOption(BigQueryRpc.Option.DELETE_CONTENTS, true);
    }
  }

  /**
   * Class for specifying table list options.
   */
  class TableListOption extends Option {

    private static final long serialVersionUID = 8660294969063340498L;

    private TableListOption(BigQueryRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the maximum number of tables returned per page.
     */
    public static TableListOption pageSize(long pageSize) {
      checkArgument(pageSize >= 0);
      return new TableListOption(BigQueryRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing tables.
     */
    public static TableListOption pageToken(String pageToken) {
      return new TableListOption(BigQueryRpc.Option.PAGE_TOKEN, pageToken);
    }
  }

  /**
   * Class for specifying table get, create and update options.
   */
  class TableOption extends Option {

    private static final long serialVersionUID = -1723870134095936772L;

    private TableOption(BigQueryRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the table's fields to be returned by the RPC call. If this
     * option is not provided all table's fields are returned. {@code TableOption.fields} can be
     * used to specify only the fields of interest. {@link Table#tableId()} and type (which is part
     * of {@link Table#definition()}) are always returned, even if not specified.
     */
    public static TableOption fields(TableField... fields) {
      return new TableOption(BigQueryRpc.Option.FIELDS,
          Helper.selector(TableField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying table data list options.
   */
  class TableDataListOption extends Option {

    private static final long serialVersionUID = 8488823381738864434L;

    private TableDataListOption(BigQueryRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the maximum number of rows returned per page.
     */
    public static TableDataListOption pageSize(long pageSize) {
      checkArgument(pageSize >= 0);
      return new TableDataListOption(BigQueryRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing table data.
     */
    public static TableDataListOption pageToken(String pageToken) {
      return new TableDataListOption(BigQueryRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option that sets the zero-based index of the row from which to start listing table
     * data.
     */
    public static TableDataListOption startIndex(long index) {
      checkArgument(index >= 0);
      return new TableDataListOption(BigQueryRpc.Option.START_INDEX, index);
    }
  }

  /**
   * Class for specifying job list options.
   */
  class JobListOption extends Option {

    private static final long serialVersionUID = -8207122131226481423L;

    private JobListOption(BigQueryRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to list all jobs, even the ones issued by other users.
     */
    public static JobListOption allUsers() {
      return new JobListOption(BigQueryRpc.Option.ALL_USERS, true);
    }

    /**
     * Returns an option to list only jobs that match the provided state filters.
     */
    public static JobListOption stateFilter(JobStatus.State... stateFilters) {
      List<String> stringFilters = Lists.transform(ImmutableList.copyOf(stateFilters),
          new Function<JobStatus.State, String>() {
            @Override
            public String apply(JobStatus.State state) {
              return state.name().toLowerCase();
            }
          });
      return new JobListOption(BigQueryRpc.Option.STATE_FILTER, stringFilters);
    }

    /**
     * Returns an option to specify the maximum number of jobs returned per page.
     */
    public static JobListOption pageSize(long pageSize) {
      checkArgument(pageSize >= 0);
      return new JobListOption(BigQueryRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing jobs.
     */
    public static JobListOption pageToken(String pageToken) {
      return new JobListOption(BigQueryRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the job's fields to be returned by the RPC call. If this option
     * is not provided all job's fields are returned. {@code JobOption.fields()} can be used to
     * specify only the fields of interest. {@link Job#jobId()}, {@link JobStatus#state()},
     * {@link JobStatus#error()} as well as type-specific configuration (e.g.
     * {@link QueryJobConfiguration#query()} for Query Jobs) are always returned, even if not
     * specified. {@link JobField#SELF_LINK} and {@link JobField#ETAG} can not be selected when
     * listing jobs.
     */
    public static JobListOption fields(JobField... fields) {
      return new JobListOption(BigQueryRpc.Option.FIELDS,
          Helper.listSelector("jobs", JobField.REQUIRED_FIELDS, fields, "state", "errorResult"));
    }
  }

  /**
   * Class for specifying table get and create options.
   */
  class JobOption extends Option {

    private static final long serialVersionUID = -3111736712316353665L;

    private JobOption(BigQueryRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the job's fields to be returned by the RPC call. If this option
     * is not provided all job's fields are returned. {@code JobOption.fields()} can be used to
     * specify only the fields of interest. {@link Job#jobId()} as well as type-specific
     * configuration (e.g. {@link QueryJobConfiguration#query()} for Query Jobs) are always
     * returned, even if not specified.
     */
    public static JobOption fields(JobField... fields) {
      return new JobOption(BigQueryRpc.Option.FIELDS,
          Helper.selector(JobField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying query results options.
   */
  class QueryResultsOption extends Option {

    private static final long serialVersionUID = 3788898503226985525L;

    private QueryResultsOption(BigQueryRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the maximum number of rows returned per page.
     */
    public static QueryResultsOption pageSize(long pageSize) {
      checkArgument(pageSize >= 0);
      return new QueryResultsOption(BigQueryRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start getting query results.
     */
    public static QueryResultsOption pageToken(String pageToken) {
      return new QueryResultsOption(BigQueryRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option that sets the zero-based index of the row from which to start getting query
     * results.
     */
    public static QueryResultsOption startIndex(long startIndex) {
      checkArgument(startIndex >= 0);
      return new QueryResultsOption(BigQueryRpc.Option.START_INDEX, startIndex);
    }

    /**
     * Returns an option that sets how long to wait for the query to complete, in milliseconds,
     * before returning. Default is 10 seconds. If the timeout passes before the job completes,
     * {@link QueryResponse#jobCompleted()} will be {@code false}.
     */
    public static QueryResultsOption maxWaitTime(long maxWaitTime) {
      checkArgument(maxWaitTime >= 0);
      return new QueryResultsOption(BigQueryRpc.Option.TIMEOUT, maxWaitTime);
    }
  }

  /**
   * Creates a new dataset.
   *
   * @throws BigQueryException upon failure
   */
  Dataset create(DatasetInfo dataset, DatasetOption... options);

  /**
   * Creates a new table.
   *
   * @throws BigQueryException upon failure
   */
  Table create(TableInfo table, TableOption... options);

  /**
   * Creates a new job.
   *
   * @throws BigQueryException upon failure
   */
  Job create(JobInfo job, JobOption... options);

  /**
   * Returns the requested dataset or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  Dataset getDataset(String datasetId, DatasetOption... options);

  /**
   * Returns the requested dataset or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  Dataset getDataset(DatasetId datasetId, DatasetOption... options);

  /**
   * Lists the project's datasets. This method returns partial information on each dataset:
   * ({@link Dataset#datasetId()}, {@link Dataset#friendlyName()} and
   * {@link Dataset#generatedId()}). To get complete information use either
   * {@link #getDataset(String, DatasetOption...)} or
   * {@link #getDataset(DatasetId, DatasetOption...)}.
   *
   * @throws BigQueryException upon failure
   */
  Page<Dataset> listDatasets(DatasetListOption... options);

  /**
   * Deletes the requested dataset.
   *
   * @return {@code true} if dataset was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean delete(String datasetId, DatasetDeleteOption... options);

  /**
   * Deletes the requested dataset.
   *
   * @return {@code true} if dataset was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean delete(DatasetId datasetId, DatasetDeleteOption... options);

  /**
   * Deletes the requested table.
   *
   * @return {@code true} if table was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean delete(String datasetId, String tableId);

  /**
   * Deletes the requested table.
   *
   * @return {@code true} if table was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean delete(TableId tableId);

  /**
   * Updates dataset information.
   *
   * @throws BigQueryException upon failure
   */
  Dataset update(DatasetInfo dataset, DatasetOption... options);

  /**
   * Updates table information.
   *
   * @throws BigQueryException upon failure
   */
  Table update(TableInfo table, TableOption... options);

  /**
   * Returns the requested table or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  Table getTable(String datasetId, String tableId, TableOption... options);

  /**
   * Returns the requested table or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  Table getTable(TableId tableId, TableOption... options);

  /**
   * Lists the tables in the dataset. This method returns partial information on each table:
   * ({@link Table#tableId()}, {@link Table#friendlyName()}, {@link Table#generatedId()} and type,
   * which is part of {@link Table#definition()}). To get complete information use either
   * {@link #getTable(TableId, TableOption...)} or
   * {@link #getTable(String, String, TableOption...)}.
   *
   * @throws BigQueryException upon failure
   */
  Page<Table> listTables(String datasetId, TableListOption... options);

  /**
   * Lists the tables in the dataset. This method returns partial information on each table:
   * ({@link Table#tableId()}, {@link Table#friendlyName()}, {@link Table#generatedId()} and type,
   * which is part of {@link Table#definition()}). To get complete information use either
   * {@link #getTable(TableId, TableOption...)} or
   * {@link #getTable(String, String, TableOption...)}.
   *
   * @throws BigQueryException upon failure
   */
  Page<Table> listTables(DatasetId datasetId, TableListOption... options);

  /**
   * Sends an insert all request.
   *
   * @throws BigQueryException upon failure
   */
  InsertAllResponse insertAll(InsertAllRequest request);

  /**
   * Lists the table's rows.
   *
   * @throws BigQueryException upon failure
   */
  Page<List<FieldValue>> listTableData(String datasetId, String tableId,
      TableDataListOption... options);

  /**
   * Lists the table's rows.
   *
   * @throws BigQueryException upon failure
   */
  Page<List<FieldValue>> listTableData(TableId tableId, TableDataListOption... options);

  /**
   * Returns the requested job or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  Job getJob(String jobId, JobOption... options);

  /**
   * Returns the requested job or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  Job getJob(JobId jobId, JobOption... options);

  /**
   * Lists the jobs.
   *
   * @throws BigQueryException upon failure
   */
  Page<Job> listJobs(JobListOption... options);

  /**
   * Sends a job cancel request. This call will return immediately. The job status can then be
   * checked using either {@link #getJob(JobId, JobOption...)} or
   * {@link #getJob(String, JobOption...)}).
   *
   * @return {@code true} if cancel was requested successfully, {@code false} if the job was not
   *     found
   * @throws BigQueryException upon failure
   */
  boolean cancel(String jobId);

  /**
   * Sends a job cancel request. This call will return immediately. The job status can then be
   * checked using either {@link #getJob(JobId, JobOption...)} or
   * {@link #getJob(String, JobOption...)}).
   *
   * @return {@code true} if cancel was requested successfully, {@code false} if the job was not
   *     found
   * @throws BigQueryException upon failure
   */
  boolean cancel(JobId tableId);

  /**
   * Runs the query associated with the request.
   *
   * @throws BigQueryException upon failure
   */
  QueryResponse query(QueryRequest request);

  /**
   * Returns results of the query associated with the provided job.
   *
   * @throws BigQueryException upon failure
   */
  QueryResponse getQueryResults(JobId job, QueryResultsOption... options);

  /**
   * Returns a channel to write data to be inserted into a BigQuery table. Data format and other
   * options can be configured using the {@link WriteChannelConfiguration} parameter.
   *
   * @throws BigQueryException upon failure
   */
  TableDataWriteChannel writer(WriteChannelConfiguration writeChannelConfiguration);
}
