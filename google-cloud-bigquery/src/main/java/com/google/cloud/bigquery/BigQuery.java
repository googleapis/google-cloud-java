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

import com.google.api.core.InternalApi;
import com.google.api.gax.paging.Page;
import com.google.cloud.FieldSelector;
import com.google.cloud.FieldSelector.Helper;
import com.google.cloud.RetryOption;
import com.google.cloud.Service;
import com.google.cloud.bigquery.spi.v2.BigQueryRpc;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.ArrayList;
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
    LABELS("labels"),
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
    public String getSelector() {
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
    TIME_PARTITIONING("timePartitioning"),
    TYPE("type"),
    VIEW("view");

    static final List<? extends FieldSelector> REQUIRED_FIELDS =
        ImmutableList.of(TABLE_REFERENCE, TYPE);

    private final String selector;

    TableField(String selector) {
      this.selector = selector;
    }


    @Override
    public String getSelector() {
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
    public String getSelector() {
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
     * be used to specify only the fields of interest. {@link Dataset#getDatasetId()} is always
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
     * used to specify only the fields of interest. {@link Table#getTableId()} and type (which is part
     * of {@link Table#getDefinition()}) are always returned, even if not specified.
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
     * specify only the fields of interest. {@link Job#getJobId()}, {@link JobStatus#getState()},
     * {@link JobStatus#getError()} as well as type-specific configuration (e.g.
     * {@link QueryJobConfiguration#getQuery()} for Query Jobs) are always returned, even if not
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
     * specify only the fields of interest. {@link Job#getJobId()} as well as type-specific
     * configuration (e.g. {@link QueryJobConfiguration#getQuery()} for Query Jobs) are always
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
     * before returning. Default is 10 seconds.
     */
    public static QueryResultsOption maxWaitTime(long maxWaitTime) {
      checkArgument(maxWaitTime >= 0);
      return new QueryResultsOption(BigQueryRpc.Option.TIMEOUT, maxWaitTime);
    }
  }

  class QueryOption implements Serializable {
    private static final long serialVersionUID = 6206193419355824689L;

    private final Object option;

    private QueryOption(Object option) {
      this.option = option;
    }

    public QueryResultsOption getQueryResultsOption() {
      return option instanceof QueryResultsOption ? (QueryResultsOption) option : null;
    }

    public RetryOption getRetryOption() {
      return option instanceof RetryOption ? (RetryOption) option : null;
    }

    static QueryResultsOption[] filterQueryResultsOptions(QueryOption... options) {
      List<QueryResultsOption> queryResultOptions = new ArrayList<>(options.length);
      for (QueryOption opt : options) {
        if (opt.getQueryResultsOption() != null) {
          queryResultOptions.add(opt.getQueryResultsOption());
        }
      }
      return queryResultOptions.toArray(new QueryResultsOption[queryResultOptions.size()]);
    }

    static RetryOption[] filterRetryOptions(QueryOption... options) {
      List<RetryOption> retryOptions = new ArrayList<>(options.length);
      for (QueryOption opt : options) {
        if (opt.getRetryOption() != null) {
          retryOptions.add(opt.getRetryOption());
        }
      }
      return retryOptions.toArray(new RetryOption[retryOptions.size()]);
    }

    public static QueryOption of(QueryResultsOption resultsOption) {
      return new QueryOption(resultsOption);
    }

    public static QueryOption of(RetryOption waitOption) {
      return new QueryOption(waitOption);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      QueryOption that = (QueryOption) o;

      return option != null ? option.equals(that.option) : that.option == null;
    }

    @Override
    public int hashCode() {
      return option != null ? option.hashCode() : 0;
    }
  }


  /**
   * Creates a new dataset.
   *
   * <p>Example of creating a dataset.
   * <pre> {@code
   * String datasetName = "my_dataset_name";
   * Dataset dataset = null;
   * DatasetInfo datasetInfo = DatasetInfo.newBuilder(datasetName).build();
   * try {
   *   // the dataset was created
   *   dataset = bigquery.create(datasetInfo);
   * } catch (BigQueryException e) {
   *   // the dataset was not created
   * }
   * } </pre>
   *
   * @throws BigQueryException upon failure
   */
  Dataset create(DatasetInfo datasetInfo, DatasetOption... options);

  /**
   * Creates a new table.
   *
   * <p>Example of creating a table.
   * <pre> {@code
   * String datasetName = "my_dataset_name";
   * String tableName = "my_table_name";
   * String fieldName = "string_field";
   * TableId tableId = TableId.of(datasetName, tableName);
   * // Table field definition
   * Field field = Field.of(fieldName, Field.Type.string());
   * // Table schema definition
   * Schema schema = Schema.of(field);
   * TableDefinition tableDefinition = StandardTableDefinition.of(schema);
   * TableInfo tableInfo = TableInfo.newBuilder(tableId, tableDefinition).build();
   * Table table = bigquery.create(tableInfo);
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  Table create(TableInfo tableInfo, TableOption... options);

  /**
   * Creates a new job.
   *
   * <p>Example of creating a query job.
   * <pre> {@code
   * String query = "SELECT field FROM my_dataset_name.my_table_name";
   * Job job = null;
   * JobConfiguration jobConfiguration = QueryJobConfiguration.of(query);
   * JobInfo jobInfo = JobInfo.of(jobConfiguration);
   * try {
   *   job = bigquery.create(jobInfo);
   * } catch (BigQueryException e) {
   *   // the job was not created
   * }
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  Job create(JobInfo jobInfo, JobOption... options);

  /**
   * Returns the requested dataset or {@code null} if not found.
   *
   * <p>Example of getting a dataset.
   * <pre> {@code
   * String datasetName = "my_dataset";
   * Dataset dataset = bigquery.getDataset(datasetName);
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  Dataset getDataset(String datasetId, DatasetOption... options);

  /**
   * Returns the requested dataset or {@code null} if not found.
   *
   * <p>Example of getting a dataset.
   * <pre> {@code
   * String projectId = "my_project_id";
   * String datasetName = "my_dataset_name";
   * DatasetId datasetId = DatasetId.of(projectId, datasetName);
   * Dataset dataset = bigquery.getDataset(datasetId);
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  Dataset getDataset(DatasetId datasetId, DatasetOption... options);

  /**
   * Lists the project's datasets. This method returns partial information on each dataset:
   * ({@link Dataset#getDatasetId()}, {@link Dataset#getFriendlyName()} and
   * {@link Dataset#getGeneratedId()}). To get complete information use either
   * {@link #getDataset(String, DatasetOption...)} or
   * {@link #getDataset(DatasetId, DatasetOption...)}.
   *
   * <p>Example of listing datasets, specifying the page size.
   * <pre> {@code
   * Page<Dataset> datasets = bigquery.listDatasets(DatasetListOption.pageSize(100));
   * for (Dataset dataset : datasets.iterateAll()) {
   *   // do something with the dataset
   * }
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  Page<Dataset> listDatasets(DatasetListOption... options);

  /**
   * Lists the datasets in the provided project. This method returns partial information on each
   * dataset: ({@link Dataset#getDatasetId()}, {@link Dataset#getFriendlyName()} and
   * {@link Dataset#getGeneratedId()}). To get complete information use either
   * {@link #getDataset(String, DatasetOption...)} or
   * {@link #getDataset(DatasetId, DatasetOption...)}.
   *
   * <p>Example of listing datasets in a project, specifying the page size.
   * <pre> {@code
   * String projectId = "my_project_id";
   * Page<Dataset> datasets = bigquery.listDatasets(projectId, DatasetListOption.pageSize(100));
   * for (Dataset dataset : datasets.iterateAll()) {
   *   // do something with the dataset
   * }
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  Page<Dataset> listDatasets(String projectId, DatasetListOption... options);

  /**
   * Deletes the requested dataset.
   *
   * <p>Example of deleting a dataset from its id, even if non-empty.
   * <pre> {@code
   * String datasetName = "my_dataset_name";
   * Boolean deleted = bigquery.delete(datasetName, DatasetDeleteOption.deleteContents());
   * if (deleted) {
   *   // the dataset was deleted
   * } else {
   *   // the dataset was not found
   * }
   * }</pre>
   *
   * @return {@code true} if dataset was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean delete(String datasetId, DatasetDeleteOption... options);

  /**
   * Deletes the requested dataset.
   *
   * <p>Example of deleting a dataset, even if non-empty.
   * <pre> {@code
   * String projectId = "my_project_id";
   * String datasetName = "my_dataset_name";
   * DatasetId datasetId = DatasetId.of(projectId, datasetName);
   * Boolean deleted = bigquery.delete(datasetId, DatasetDeleteOption.deleteContents());
   * if (deleted) {
   *   // the dataset was deleted
   * } else {
   *   // the dataset was not found
   * }
   * }</pre>
   *
   * @return {@code true} if dataset was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean delete(DatasetId datasetId, DatasetDeleteOption... options);

  /**
   * Deletes the requested table.
   *
   * <p>Example of deleting a table.
   * <pre> {@code
   * String datasetName = "my_dataset_name";
   * String tableName = "my_table_name";
   * Boolean deleted = bigquery.delete(datasetName, tableName);
   * if (deleted) {
   *   // the table was deleted
   * } else {
   *   // the table was not found
   * }
   * }</pre>
   *
   * @return {@code true} if table was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean delete(String datasetId, String tableId);

  /**
   * Deletes the requested table.
   *
   * <p>Example of deleting a table.
   * <pre> {@code
   * String projectId = "my_project_id";
   * String datasetName = "my_dataset_name";
   * String tableName = "my_table_name";
   * TableId tableId = TableId.of(projectId, datasetName, tableName);
   * Boolean deleted = bigquery.delete(tableId);
   * if (deleted) {
   *   // the table was deleted
   * } else {
   *   // the table was not found
   * }
   * }</pre>
   *
   * @return {@code true} if table was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  boolean delete(TableId tableId);

  /**
   * Updates dataset information.
   *
   * <p>Example of updating a dataset by changing its friendly name.
   * <pre> {@code
   * String datasetName = "my_dataset_name";
   * String newFriendlyName = "some_new_friendly_name";
   * Dataset oldDataset = bigquery.getDataset(datasetName);
   * DatasetInfo datasetInfo = oldDataset.toBuilder().setFriendlyName(newFriendlyName).build();
   * Dataset newDataset = bigquery.update(datasetInfo);
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  Dataset update(DatasetInfo datasetInfo, DatasetOption... options);

  /**
   * Updates table information.
   *
   * <p>Example of updating a table by changing its friendly name.
   * <pre> {@code
   * String datasetName = "my_dataset_name";
   * String tableName = "my_table_name";
   * String newFriendlyName = "new_friendly_name";
   * Table oldTable = bigquery.getTable(datasetName, tableName);
   * TableInfo tableInfo = oldTable.toBuilder().setFriendlyName(newFriendlyName).build();
   * Table newTable = bigquery.update(tableInfo);
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  Table update(TableInfo tableInfo, TableOption... options);

  /**
   * Returns the requested table or {@code null} if not found.
   *
   * <p>Example of getting a table.
   * <pre> {@code
   * String datasetName = "my_dataset_name";
   * String tableName = "my_table_name";
   * Table table = bigquery.getTable(datasetName, tableName);
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  Table getTable(String datasetId, String tableId, TableOption... options);

  /**
   * Returns the requested table or {@code null} if not found.
   *
   * <p>Example of getting a table.
   * <pre> {@code
   * String projectId = "my_project_id";
   * String datasetName = "my_dataset_name";
   * String tableName = "my_table_name";
   * TableId tableId = TableId.of(projectId, datasetName, tableName);
   * Table table = bigquery.getTable(tableId);
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  Table getTable(TableId tableId, TableOption... options);

  /**
   * Lists the tables in the dataset. This method returns partial information on each table:
   * ({@link Table#getTableId()}, {@link Table#getFriendlyName()}, {@link Table#getGeneratedId()} and type,
   * which is part of {@link Table#getDefinition()}). To get complete information use either
   * {@link #getTable(TableId, TableOption...)} or
   * {@link #getTable(String, String, TableOption...)}.
   *
   * <p>Example of listing the tables in a dataset, specifying the page size.
   * <pre> {@code
   * String datasetName = "my_dataset_name";
   * Page<Table> tables = bigquery.listTables(datasetName, TableListOption.pageSize(100));
   * for (Table table : tables.iterateAll()) {
   *   // do something with the table
   * }
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  Page<Table> listTables(String datasetId, TableListOption... options);

  /**
   * Lists the tables in the dataset. This method returns partial information on each table:
   * ({@link Table#getTableId()}, {@link Table#getFriendlyName()}, {@link Table#getGeneratedId()}
   * and type, which is part of {@link Table#getDefinition()}). To get complete information use either
   * {@link #getTable(TableId, TableOption...)} or
   * {@link #getTable(String, String, TableOption...)}.
   *
   * <p>Example of listing the tables in a dataset.
   * <pre> {@code
   * String projectId = "my_project_id";
   * String datasetName = "my_dataset_name";
   * DatasetId datasetId = DatasetId.of(projectId, datasetName);
   * Page<Table> tables = bigquery.listTables(datasetId, TableListOption.pageSize(100));
   * for (Table table : tables.iterateAll()) {
   *   // do something with the table
   * }
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  Page<Table> listTables(DatasetId datasetId, TableListOption... options);

  /**
   * Sends an insert all request.
   *
   * <p>Example of inserting rows into a table without running a load job.
   * <pre> {@code
   * String datasetName = "my_dataset_name";
   * String tableName = "my_table_name";
   * TableId tableId = TableId.of(datasetName, tableName);
   * // Values of the row to insert
   * Map<String, Object> rowContent = new HashMap<>();
   * rowContent.put("booleanField", true);
   * // Bytes are passed in base64
   * rowContent.put("bytesField", "Cg0NDg0="); // 0xA, 0xD, 0xD, 0xE, 0xD in base64
   * // Records are passed as a map
   * Map<String, Object> recordsContent = new HashMap<>();
   * recordsContent.put("stringField", "Hello, World!");
   * rowContent.put("recordField", recordsContent);
   * InsertAllResponse response = bigquery.insertAll(InsertAllRequest.newBuilder(tableId)
   *     .addRow("rowId", rowContent)
   *     // More rows can be added in the same RPC by invoking .addRow() on the builder
   *     .build());
   * if (response.hasErrors()) {
   *   // If any of the insertions failed, this lets you inspect the errors
   *   for (Entry<Long, List<BigQueryError>> entry : response.getInsertErrors().entrySet()) {
   *     // inspect row error
   *   }
   * }
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  InsertAllResponse insertAll(InsertAllRequest request);

  /**
   * Lists the table's rows.
   *
   * <p>Example of listing table rows, specifying the page size.
   *
   * <pre>{@code
   * String datasetName = "my_dataset_name";
   * String tableName = "my_table_name";
   * // This example reads the result 100 rows per RPC call. If there's no need to limit the number,
   * // simply omit the option.
   * TableResult tableData =
   *     bigquery.listTableData(datasetName, tableName, TableDataListOption.pageSize(100));
   * for (FieldValueList row : tableData.iterateAll()) {
   *   // do something with the row
   * }
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  TableResult listTableData(String datasetId, String tableId, TableDataListOption... options);

  /**
   * Lists the table's rows.
   *
   * <p>Example of listing table rows, specifying the page size.
   *
   * <pre>{@code
   * String datasetName = "my_dataset_name";
   * String tableName = "my_table_name";
   * TableId tableIdObject = TableId.of(datasetName, tableName);
   * // This example reads the result 100 rows per RPC call. If there's no need to limit the number,
   * // simply omit the option.
   * TableResult tableData =
   *     bigquery.listTableData(tableIdObject, TableDataListOption.pageSize(100));
   * for (FieldValueList row : rowIterator.hasNext()) {
   *   // do something with the row
   * }
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  TableResult listTableData(TableId tableId, TableDataListOption... options);

  /**
   * Lists the table's rows. If the {@code schema} is not {@code null}, it is available to the
   * {@link FieldValueList} iterated over.
   *
   * <p>Example of listing table rows.
   *
   * <pre>{@code
   * String datasetName = "my_dataset_name";
   * String tableName = "my_table_name";
   * Schema schema = ...;
   * String field = "my_field";
   * Page<FieldValueList> tableData =
   *     bigquery.listTableData(datasetName, tableName, schema);
   * for (FieldValueList row : tableData.iterateAll()) {
   *   row.get(field)
   * }
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  TableResult listTableData(
      String datasetId, String tableId, Schema schema, TableDataListOption... options);

  /**
   * Lists the table's rows. If the {@code schema} is not {@code null}, it is available to the
   * {@link FieldValueList} iterated over.
   *
   * <p>Example of listing table rows.
   *
   * <pre>{@code
   * Schema schema =
   *     Schema.of(
   *         Field.of("word", LegacySQLTypeName.STRING),
   *         Field.of("word_count", LegacySQLTypeName.STRING),
   *         Field.of("corpus", LegacySQLTypeName.STRING),
   *         Field.of("corpus_date", LegacySQLTypeName.STRING));
   * Page<FieldValueList> page =
   *     bigquery.listTableData(
   *         TableId.of("bigquery-public-data", "samples", "shakespeare"), schema);
   * FieldValueList row = page.getValues().iterator().next();
   * System.out.println(row.get("word").getStringValue());
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  TableResult listTableData(TableId tableId, Schema schema, TableDataListOption... options);

  /**
   * Returns the requested job or {@code null} if not found.
   *
   * <p>Example of getting a job.
   * <pre> {@code
   * String jobName = "my_job_name";
   * Job job = bigquery.getJob(jobName);
   * if (job == null) {
   *   // job was not found
   * }
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  Job getJob(String jobId, JobOption... options);

  /**
   * Returns the requested job or {@code null} if not found.
   *
   * <p>Example of getting a job.
   * <pre> {@code
   * String jobName = "my_job_name";
   * JobId jobIdObject = JobId.of(jobName);
   * Job job = bigquery.getJob(jobIdObject);
   * if (job == null) {
   *   // job was not found
   * }
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  Job getJob(JobId jobId, JobOption... options);

  /**
   * Lists the jobs.
   *
   * <p>Example of listing jobs, specifying the page size.
   * <pre> {@code
   * Page<Job> jobs = bigquery.listJobs(JobListOption.pageSize(100));
   * for (Job job : jobs.iterateAll()) {
   *   // do something with the job
   * }
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  Page<Job> listJobs(JobListOption... options);

  /**
   * Sends a job cancel request. This call will return immediately. The job status can then be
   * checked using either {@link #getJob(JobId, JobOption...)} or
   * {@link #getJob(String, JobOption...)}).
   *
   * <p>Example of cancelling a job.
   * <pre> {@code
   * String jobName = "my_job_name";
   * boolean success = bigquery.cancel(jobName);
   * if (success) {
   *   // job was cancelled
   * } else {
   *   // job was not found
   * }
   * }</pre>
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
   * <p>Example of cancelling a job.
   * <pre> {@code
   * String jobName = "my_job_name";
   * JobId jobId = JobId.of(jobName);
   * boolean success = bigquery.cancel(jobId);
   * if (success) {
   *   // job was cancelled
   * } else {
   *   // job was not found
   * }
   * }</pre>
   *
   * @return {@code true} if cancel was requested successfully, {@code false} if the job was not
   *     found
   * @throws BigQueryException upon failure
   */
  boolean cancel(JobId jobId);

  /**
   * Runs the query associated with the request, using an internally-generated random JobId.
   *
   * <p>Example of running a query.
   *
   * <pre>{@code
   * String query = "SELECT distinct(corpus) FROM `bigquery-public-data.samples.shakespeare`";
   * QueryJobConfiguration queryConfig = QueryJobConfiguration.of(query);
   *
   * // To run the legacy syntax queries use the following code instead:
   * //   String query = "SELECT unique(corpus) FROM [bigquery-public-data:samples.shakespeare]"
   * //   QueryJobConfiguration queryConfig =
   * //       QueryJobConfiguration.newBuilder(query).setUseLegacySql(true).build();
   *
   * for (FieldValueList row : bigquery.query(queryConfig).iterateAll()) {
   *   // do something with the data
   * }
   * }</pre>
   *
   * <p>Example of running a query with query parameters.
   *
   * <pre>{@code
   * String query =
   *     "SELECT distinct(corpus) FROM `bigquery-public-data.samples.shakespeare` where word_count > ?";
   * QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query)
   *     .addPositionalParameter(QueryParameterValue.int64(5))
   *     .build();
   * for (FieldValueList row : bigquery.query(queryConfig).iterateAll()) {
   *   // do something with the data
   * }
   * }</pre>
   *
   * @throws BigQueryException upon failure
   * @throws InterruptedException if the current thread gets interrupted while waiting for the query
   *     to complete
   * @throws JobException if the job completes unsuccessfully
   */
  TableResult query(QueryJobConfiguration configuration, JobOption... options)
      throws InterruptedException, JobException;

  /**
   * Runs the query associated with the request, using the given JobId.
   *
   * <p>See {@link #query(QueryJobConfiguration, JobOption...)} for examples on populating a {@link
   * QueryJobConfiguration}.
   *
   * <p>The recommended way to create a randomly generated JobId is the following:
   *
   * <pre>{@code
   * JobId jobId = JobId.of();
   * }</pre>
   *
   * For a user specified job id with an optional prefix use the following:
   *
   * <pre>{@code
   * JobId jobId = JobId.of("my_prefix-my_unique_job_id");
   * }</pre>
   *
   * @throws BigQueryException upon failure
   * @throws InterruptedException if the current thread gets interrupted while waiting for the query
   *     to complete
   * @throws JobException if the job completes unsuccessfully
   */
  TableResult query(QueryJobConfiguration configuration, JobId jobId, JobOption... options)
      throws InterruptedException, JobException;

  /**
   * Returns results of the query associated with the provided job.
   *
   * <p>Users are encouraged to use {@link Job#getQueryResults(QueryResultsOption...)} instead.
   */
  @InternalApi
  QueryResponse getQueryResults(JobId jobId, QueryResultsOption... options);

  /**
   * Returns a channel to write data to be inserted into a BigQuery table. Data format and other
   * options can be configured using the {@link WriteChannelConfiguration} parameter.
   *
   * <p>Example of creating a channel with which to write to a table.
   * <pre> {@code
   * String datasetName = "my_dataset_name";
   * String tableName = "my_table_name";
   * String csvData = "StringValue1\nStringValue2\n";
   * TableId tableId = TableId.of(datasetName, tableName);
   * WriteChannelConfiguration writeChannelConfiguration =
   *     WriteChannelConfiguration.newBuilder(tableId)
   *         .setFormatOptions(FormatOptions.csv())
   *         .build();
   * TableDataWriteChannel writer = bigquery.writer(writeChannelConfiguration);
   *   // Write data to writer
   *  try {
   *     writer.write(ByteBuffer.wrap(csvData.getBytes(Charsets.UTF_8)));
   *   } finally {
   *     writer.close();
   *   }
   *   // Get load job
   *   Job job = writer.getJob();
   *   job = job.waitFor();
   *   LoadStatistics stats = job.getStatistics();
   *   return stats.getOutputRows();
   * }</pre>
   *
   * <p>Example of writing a local file to a table.
   * <pre> {@code
   * String datasetName = "my_dataset_name";
   * String tableName = "my_table_name";
   * Path csvPath = FileSystems.getDefault().getPath(".", "my-data.csv");
   * TableId tableId = TableId.of(datasetName, tableName);
   * WriteChannelConfiguration writeChannelConfiguration =
   *     WriteChannelConfiguration.newBuilder(tableId)
   *         .setFormatOptions(FormatOptions.csv())
   *         .build();
   * TableDataWriteChannel writer = bigquery.writer(writeChannelConfiguration);
   * // Write data to writer
   * try (OutputStream stream = Channels.newOutputStream(writer)) {
   *   Files.copy(csvPath, stream);
   * }
   * // Get load job
   * Job job = writer.getJob();
   * job = job.waitFor();
   * LoadStatistics stats = job.getStatistics();
   * return stats.getOutputRows();
   * }</pre>
   *
   * @throws BigQueryException upon failure
   */
  TableDataWriteChannel writer(WriteChannelConfiguration writeChannelConfiguration);
}
