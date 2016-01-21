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

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.gcloud.Page;
import com.google.gcloud.Service;
import com.google.gcloud.spi.BigQueryRpc;

import java.util.List;
import java.util.Set;

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
  enum DatasetField {
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

    private final String selector;

    DatasetField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(DatasetField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 1);
      fieldStrings.add(DATASET_REFERENCE.selector());
      for (DatasetField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
    }
  }

  /**
   * Fields of a BigQuery Table resource.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#resource">Table
   *     Resource</a>
   */
  enum TableField {
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

    private final String selector;

    TableField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(TableField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 2);
      fieldStrings.add(TABLE_REFERENCE.selector());
      fieldStrings.add(TYPE.selector());
      for (TableField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
    }
  }

  /**
   * Fields of a BigQuery Job resource.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#resource">Job Resource
   *     </a>
   */
  enum JobField {
    CONFIGURATION("configuration"),
    ETAG("etag"),
    ID("id"),
    JOB_REFERENCE("jobReference"),
    SELF_LINK("selfLink"),
    STATISTICS("statistics"),
    STATUS("status"),
    USER_EMAIL("user_email");

    private final String selector;

    JobField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(JobField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 2);
      fieldStrings.add(JOB_REFERENCE.selector());
      fieldStrings.add(CONFIGURATION.selector());
      for (JobField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
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
     * Returns an option to specify the maximum number of datasets to be returned.
     */
    public static DatasetListOption maxResults(long maxResults) {
      return new DatasetListOption(BigQueryRpc.Option.MAX_RESULTS, maxResults);
    }

    /**
     * Returns an option to specify the page token from which to start listing datasets.
     */
    public static DatasetListOption startPageToken(String pageToken) {
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
     * be used to specify only the fields of interest. {@link DatasetInfo#datasetId()} is always
     * returned, even if not specified.
     */
    public static DatasetOption fields(DatasetField... fields) {
      return new DatasetOption(BigQueryRpc.Option.FIELDS, DatasetField.selector(fields));
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
     * Returns an option to specify the maximum number of tables to be returned.
     */
    public static TableListOption maxResults(long maxResults) {
      checkArgument(maxResults >= 0);
      return new TableListOption(BigQueryRpc.Option.MAX_RESULTS, maxResults);
    }

    /**
     * Returns an option to specify the page token from which to start listing tables.
     */
    public static TableListOption startPageToken(String pageToken) {
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
     * used to specify only the fields of interest. {@link BaseTableInfo#tableId()} and
     * {@link BaseTableInfo#type()} are always returned, even if not specified.
     */
    public static TableOption fields(TableField... fields) {
      return new TableOption(BigQueryRpc.Option.FIELDS, TableField.selector(fields));
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
     * Returns an option to specify the maximum number of rows to be returned.
     */
    public static TableDataListOption maxResults(long maxResults) {
      checkArgument(maxResults >= 0);
      return new TableDataListOption(BigQueryRpc.Option.MAX_RESULTS, maxResults);
    }

    /**
     * Returns an option to specify the page token from which to start listing table data.
     */
    public static TableDataListOption startPageToken(String pageToken) {
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
     * Returns an option to specify the maximum number of jobs to be returned.
     */
    public static JobListOption maxResults(long maxResults) {
      checkArgument(maxResults >= 0);
      return new JobListOption(BigQueryRpc.Option.MAX_RESULTS, maxResults);
    }

    /**
     * Returns an option to specify the page token from which to start listing jobs.
     */
    public static JobListOption startPageToken(String pageToken) {
      return new JobListOption(BigQueryRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to specify the job's fields to be returned by the RPC call. If this option
     * is not provided all job's fields are returned. {@code JobOption.fields()} can be used to
     * specify only the fields of interest. {@link JobInfo#jobId()}, {@link JobStatus#state()},
     * {@link JobStatus#error()} as well as type-specific configuration (e.g.
     * {@link QueryJobInfo#query()} for Query Jobs) are always returned, even if not specified.
     * {@link JobField#SELF_LINK} and {@link JobField#ETAG} can not be selected when listing jobs.
     */
    public static JobListOption fields(JobField... fields) {
      String selector = JobField.selector(fields);
      StringBuilder builder = new StringBuilder();
      builder.append("etag,jobs(").append(selector).append(",state,errorResult),nextPageToken");
      return new JobListOption(BigQueryRpc.Option.FIELDS, builder.toString());
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
     * specify only the fields of interest. {@link JobInfo#jobId()} as well as type-specific
     * configuration (e.g. {@link QueryJobInfo#query()} for Query Jobs) are always returned, even if
     * not specified.
     */
    public static JobOption fields(JobField... fields) {
      return new JobOption(BigQueryRpc.Option.FIELDS, JobField.selector(fields));
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
     * Returns an option to specify the maximum number of rows to be returned.
     */
    public static QueryResultsOption maxResults(long maxResults) {
      checkArgument(maxResults >= 0);
      return new QueryResultsOption(BigQueryRpc.Option.MAX_RESULTS, maxResults);
    }

    /**
     * Returns an option to specify the page token from which to start getting query results.
     */
    public static QueryResultsOption startPageToken(String pageToken) {
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
  DatasetInfo create(DatasetInfo dataset, DatasetOption... options) throws BigQueryException;

  /**
   * Creates a new table.
   *
   * @throws BigQueryException upon failure
   */
  <T extends BaseTableInfo> T create(T table, TableOption... options) throws BigQueryException;

  /**
   * Creates a new job.
   *
   * @throws BigQueryException upon failure
   */
  <T extends JobInfo> T create(T job, JobOption... options) throws BigQueryException;

  /**
   * Returns the requested dataset or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  DatasetInfo getDataset(String datasetId, DatasetOption... options) throws BigQueryException;

  /**
   * Returns the requested dataset or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  DatasetInfo getDataset(DatasetId datasetId, DatasetOption... options) throws BigQueryException;

  /**
   * Lists the project's datasets. This method returns partial information on each dataset
   * ({@link DatasetInfo#datasetId()}, {@link DatasetInfo#friendlyName()} and
   * {@link DatasetInfo#id()}). To get complete information use either
   * {@link #getDataset(String, DatasetOption...)} or
   * {@link #getDataset(DatasetId, DatasetOption...)}.
   *
   * @throws BigQueryException upon failure
   */
  Page<DatasetInfo> listDatasets(DatasetListOption... options) throws BigQueryException;

  /**
   * Deletes the requested dataset.
   *
   * @return {@code true} if dataset was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean delete(String datasetId, DatasetDeleteOption... options) throws BigQueryException;

  /**
   * Deletes the requested dataset.
   *
   * @return {@code true} if dataset was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean delete(DatasetId datasetId, DatasetDeleteOption... options) throws BigQueryException;

  /**
   * Deletes the requested table.
   *
   * @return {@code true} if table was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean delete(String datasetId, String tableId) throws BigQueryException;

  /**
   * Deletes the requested table.
   *
   * @return {@code true} if table was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean delete(TableId tableId) throws BigQueryException;

  /**
   * Updates dataset information.
   *
   * @throws BigQueryException upon failure
   */
  DatasetInfo update(DatasetInfo dataset, DatasetOption... options) throws BigQueryException;

  /**
   * Updates table information.
   *
   * @throws BigQueryException upon failure
   */
  <T extends BaseTableInfo> T update(T table, TableOption... options) throws BigQueryException;

  /**
   * Returns the requested table or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  <T extends BaseTableInfo> T getTable(String datasetId, String tableId, TableOption... options)
      throws BigQueryException;

  /**
   * Returns the requested table or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  <T extends BaseTableInfo> T getTable(TableId tableId, TableOption... options)
      throws BigQueryException;

  /**
   * Lists the tables in the dataset. This method returns partial information on each table
   * ({@link BaseTableInfo#tableId()}, {@link BaseTableInfo#friendlyName()},
   * {@link BaseTableInfo#id()} and {@link BaseTableInfo#type()}). To get complete information use
   * either {@link #getTable(TableId, TableOption...)} or
   * {@link #getTable(String, String, TableOption...)}.
   *
   * @throws BigQueryException upon failure
   */
  Page<BaseTableInfo> listTables(String datasetId, TableListOption... options)
      throws BigQueryException;

  /**
   * Lists the tables in the dataset. This method returns partial information on each table
   * ({@link BaseTableInfo#tableId()}, {@link BaseTableInfo#friendlyName()},
   * {@link BaseTableInfo#id()} and {@link BaseTableInfo#type()}). To get complete information use
   * either {@link #getTable(TableId, TableOption...)} or
   * {@link #getTable(String, String, TableOption...)}.
   *
   * @throws BigQueryException upon failure
   */
  Page<BaseTableInfo> listTables(DatasetId datasetId, TableListOption... options)
      throws BigQueryException;

  /**
   * Sends an insert all request.
   *
   * @throws BigQueryException upon failure
   */
  InsertAllResponse insertAll(InsertAllRequest request) throws BigQueryException;

  /**
   * Lists the table's rows.
   *
   * @throws BigQueryException upon failure
   */
  Page<List<FieldValue>> listTableData(String datasetId, String tableId,
      TableDataListOption... options) throws BigQueryException;

  /**
   * Lists the table's rows.
   *
   * @throws BigQueryException upon failure
   */
  Page<List<FieldValue>> listTableData(TableId tableId, TableDataListOption... options)
      throws BigQueryException;

  /**
   * Returns the requested job or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  <T extends JobInfo> T getJob(String jobId, JobOption... options) throws BigQueryException;

  /**
   * Returns the requested job or {@code null} if not found.
   *
   * @throws BigQueryException upon failure
   */
  <T extends JobInfo> T getJob(JobId jobId, JobOption... options) throws BigQueryException;

  /**
   * Lists the jobs.
   *
   * @throws BigQueryException upon failure
   */
  Page<JobInfo> listJobs(JobListOption... options) throws BigQueryException;

  /**
   * Sends a job cancel request. This call will return immediately. The job status can then be
   * checked using either {@link #getJob(JobId, JobOption...)} or
   * {@link #getJob(String, JobOption...)}).
   *
   * @return {@code true} if cancel was requested successfully, {@code false} if the job was not
   *     found
   * @throws BigQueryException upon failure
   */
  boolean cancel(String jobId) throws BigQueryException;

  /**
   * Sends a job cancel request. This call will return immediately. The job status can then be
   * checked using either {@link #getJob(JobId, JobOption...)} or
   * {@link #getJob(String, JobOption...)}).
   *
   * @return {@code true} if cancel was requested successfully, {@code false} if the job was not
   *     found
   * @throws BigQueryException upon failure
   */
  boolean cancel(JobId tableId) throws BigQueryException;

  /**
   * Runs the query associated with the request.
   *
   * @throws BigQueryException upon failure
   */
  QueryResponse query(QueryRequest request) throws BigQueryException;

  /**
   * Returns results of the query associated with the provided job.
   *
   * @throws BigQueryException upon failure
   */
  QueryResponse getQueryResults(JobId job, QueryResultsOption... options) throws BigQueryException;

  /**
   * Returns a channel to write data to be inserted into a BigQuery table. Data format and other
   * options can be configured using the {@link LoadConfiguration} parameter.
   *
   * @throws BigQueryException upon failure
   */
  TableDataWriteChannel writer(LoadConfiguration loadConfiguration);
}
