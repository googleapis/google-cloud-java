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

import com.google.cloud.bigquery.Clustering;
import com.google.cloud.bigquery.ConnectionProperty;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.EncryptionConfiguration;
import com.google.cloud.bigquery.ExternalTableDefinition;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryJobConfiguration.Priority;
import com.google.cloud.bigquery.RangePartitioning;
import com.google.cloud.bigquery.TimePartitioning;
import com.google.cloud.bigquery.UserDefinedFunction;
import java.util.List;
import java.util.Map;

/** This class is used to pass user defined settings for execution of Queries. */
// TODO: Expose this class as public once we decide on how to expose the slow
// query path to the end users. IMP: revisit the set of params to be exposed via BigQuerySettings
class BigQuerySettings {

  private final boolean useReadAPI;
  private final int highThroughputActivationRatio;
  private final int highThroughputMinTableSize;
  private final boolean unsupportedHTAPIFallback;

  private final boolean enableSession;

  private final ConnectionProperty sessionInfoConnectionProperty;

  private final boolean useQueryCache;
  private final String queryDialect;
  private final List<ConnectionProperty> queryProperties;
  private final Boolean allowLargeResults;
  private final String kmsKeyName;
  private final Clustering clustering;

  private final JobInfo.CreateDisposition createDisposition;

  private final EncryptionConfiguration destinationEncryptionConfiguration;

  private final String destinationTable;
  private final String destinationDataset;
  private final long destinationDatasetExpirationTime;

  private final long jobTimeoutMs;

  private final int maximumBillingTier;

  private final QueryJobConfiguration.Priority priority;

  private final RangePartitioning rangePartitioning;

  private final List<JobInfo.SchemaUpdateOption> schemaUpdateOptions;

  private final Map<String, ExternalTableDefinition> tableDefinitions;

  private final TimePartitioning timePartitioning;

  private final List<UserDefinedFunction> userDefinedFunctions;

  private final JobInfo.WriteDisposition writeDisposition;

  private final int numBufferedRows;

  private final long maxResultPerPage;

  private final DatasetId defaultDataset;

  private final boolean useWriteAPI;
  private final int writeAPIActivationRowCount;
  private final int writeAPIAppendRowCount;

  private final long maxBytesBilled;
  private final Map<String, String> labels;

  private BigQuerySettings(Builder builder) {
    this.useReadAPI = builder.useReadAPI;
    this.highThroughputActivationRatio = builder.highThroughputActivationRatio;
    this.highThroughputMinTableSize = builder.highThroughputMinTableSize;
    this.useQueryCache = builder.useQueryCache;
    this.queryDialect = builder.queryDialect;
    this.queryProperties = builder.queryProperties;
    this.allowLargeResults = builder.allowLargeResults;
    this.kmsKeyName = builder.kmsKeyName;
    this.clustering = builder.clustering;
    this.createDisposition = builder.createDisposition;
    this.destinationEncryptionConfiguration = builder.destinationEncryptionConfiguration;
    this.destinationTable = builder.destinationTable;
    this.destinationDataset = builder.destinationDataset;
    this.destinationDatasetExpirationTime = builder.destinationDatasetExpirationTime;
    this.jobTimeoutMs = builder.jobTimeoutMs;
    this.maximumBillingTier = builder.maximumBillingTier;
    this.priority = builder.priority;
    this.rangePartitioning = builder.rangePartitioning;
    this.schemaUpdateOptions = builder.schemaUpdateOptions;
    this.tableDefinitions = builder.tableDefinitions;
    this.timePartitioning = builder.timePartitioning;
    this.userDefinedFunctions = builder.userDefinedFunctions;
    this.writeDisposition = builder.writeDisposition;
    this.numBufferedRows = builder.numBufferedRows;
    this.maxResultPerPage = builder.maxResultPerPage;
    this.defaultDataset = builder.defaultDataset;
    this.enableSession = builder.enableSession;
    this.unsupportedHTAPIFallback = builder.unsupportedHTAPIFallback;
    this.sessionInfoConnectionProperty = builder.sessionInfoConnectionProperty;
    this.useWriteAPI = builder.useWriteAPI;
    this.writeAPIActivationRowCount = builder.writeAPIActivationRowCount;
    this.writeAPIAppendRowCount = builder.writeAPIAppendRowCount;
    this.maxBytesBilled = builder.maxBytesBilled;
    this.labels = builder.labels;
  }

  /** Returns a builder for a BigQuerySettings object. */
  static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Returns useReadAPI flag, enabled by default. Read API will be used if the underlying conditions
   * are satisfied and this flag is enabled
   */
  Boolean getUseReadAPI() {
    return useReadAPI;
  }

  /**
   * Returns integer value for when the connector switches to BigQuery Storage API when the number
   * of pages and rows in query results exceed this value and HighThroughPutMinTableSize,
   * respectively.
   */
  int getHighThroughputActivationRatio() {
    return highThroughputActivationRatio;
  }

  /**
   * Returns integer value for when query results are large, exceeding both row and page limits, the
   * connector switches to the BigQuery Storage API for faster processing.
   */
  int getHighThroughputMinTableSize() {
    return highThroughputMinTableSize;
  }

  /**
   * Determines if session features are enabled.
   *
   * <p>Enabling session-level features allows for capturing SQL activities or enabling
   * multi-statement transactions. Session tracking is disabled by default.
   *
   * @return true if session is enabled, false otherwise.
   */
  boolean isEnableSession() {
    return enableSession;
  }

  /**
   * When the connector uses fetch workflows not supported on the High-Throughput API, this option
   * specifies whether the connector falls back to the REST API or returns an error. By default it
   * falls back to standard API.
   *
   * @return true if falls back to standard, false to error.
   */
  boolean isUnsupportedHTAPIFallback() {
    return unsupportedHTAPIFallback;
  }

  /**
   * Returns information about the BigQuery session ConnectionProperty associated with this job.
   *
   * <p>BigQuery's sessions provide a way to link multiple jobs and maintain temporary data, such as
   * temporary tables, between them. They are needed for using multi-statement transactions that
   * span across multiple queries.
   *
   * @return An instance of {@link ConnectionProperty} containing session details, or {@code null}
   *     if this job is not part of a session.
   */
  ConnectionProperty getSessionInfoConnectionProperty() {
    return sessionInfoConnectionProperty;
  }

  Boolean getUseQueryCache() {
    return useQueryCache;
  }

  String getQueryDialect() {
    return queryDialect;
  }

  List<ConnectionProperty> getQueryProperties() {
    return this.queryProperties;
  }

  /**
   * Returns the KMS resource name which is the unique identifier you give to your encryption key in
   * Google Cloud's Key Management Service (KMS). Tells BigQuery which key to use when encrypting or
   * decrypting your data.
   */
  String getKmsKeyName() {
    return kmsKeyName;
  }

  Boolean getAllowLargeResults() {
    return allowLargeResults;
  }

  /** Returns the clustering specification for the destination table. */
  Clustering getClustering() {
    return clustering;
  }

  /**
   * Returns whether the job is allowed to create new tables.
   *
   * @see <a
   *     href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.query.createDisposition">
   *     Create Disposition</a>
   */
  JobInfo.CreateDisposition getCreateDisposition() {
    return createDisposition;
  }

  /** Returns the custom encryption configuration (e.g., Cloud KMS keys) */
  EncryptionConfiguration getDestinationEncryptionConfiguration() {
    return destinationEncryptionConfiguration;
  }

  /**
   * Returns the table where you want to store query results. If not provided a default temp table
   * is created when needed.
   */
  String getDestinationTable() {
    return destinationTable;
  }

  /**
   * Returns the dataset where you want to store query results. If not provided a default dataset is
   * created when needed.
   */
  String getDestinationDataset() {
    return destinationDataset;
  }

  long getDestinationDatasetExpirationTime() {
    return destinationDatasetExpirationTime;
  }

  /** Returns the timeout associated with this job */
  Long getJobTimeoutMs() {
    return jobTimeoutMs;
  }

  /** Returns the optional billing tier limit for this job. */
  Integer getMaximumBillingTier() {
    return maximumBillingTier;
  }

  /** Returns the query priority. */
  QueryJobConfiguration.Priority getPriority() {
    return priority;
  }

  /** Returns the range partitioning specification for the table */
  RangePartitioning getRangePartitioning() {
    return rangePartitioning;
  }

  /**
   * Returns options allowing the schema of the destination table to be updated as a side effect of
   * the query job. Schema update options are supported in two cases: when writeDisposition is
   * WRITE_APPEND; when writeDisposition is WRITE_TRUNCATE and the destination table is a partition
   * of a table, specified by partition decorators. For normal tables, WRITE_TRUNCATE will always
   * overwrite the schema.
   */
  List<JobInfo.SchemaUpdateOption> getSchemaUpdateOptions() {
    return schemaUpdateOptions;
  }

  /**
   * Returns the external tables definitions. If querying external data sources outside BigQuery,
   * this value describes the data format, location and other properties of the data sources. By
   * defining these properties, the data sources can be queried as if they were standard BigQuery
   * tables.
   */
  Map<String, ExternalTableDefinition> getTableDefinitions() {
    return tableDefinitions;
  }

  /** Returns the time partitioning specification for the destination table. */
  TimePartitioning getTimePartitioning() {
    return timePartitioning;
  }

  /**
   * Returns user defined function resources that can be used by this query. Function resources can
   * either be defined inline ({@link UserDefinedFunction.Type#INLINE}) or loaded from a Google
   * Cloud Storage URI ({@link UserDefinedFunction.Type#FROM_URI}.
   */
  List<UserDefinedFunction> getUserDefinedFunctions() {
    return userDefinedFunctions;
  }

  /**
   * Returns the action that should occur if the destination table already exists.
   *
   * @see <a
   *     href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.query.writeDisposition">
   *     Write Disposition</a>
   */
  JobInfo.WriteDisposition getWriteDisposition() {
    return writeDisposition;
  }

  /** Returns the number of rows of data to pre-fetch */
  Integer getNumBufferedRows() {
    return numBufferedRows;
  }

  Long getMaxResultPerPage() {
    return maxResultPerPage;
  }

  DatasetId getDefaultDataset() {
    return defaultDataset;
  }

  boolean isUseWriteAPI() {
    return useWriteAPI;
  }

  int getWriteAPIActivationRowCount() {
    return writeAPIActivationRowCount;
  }

  int getWriteAPIAppendRowCount() {
    return writeAPIAppendRowCount;
  }

  long getMaxBytesBilled() {
    return maxBytesBilled;
  }

  Map<String, String> getLabels() {
    return labels;
  }

  @Override
  public String toString() {
    return "BigQuerySettings{"
        + "enableSession="
        + enableSession
        + ", "
        + "unsupportedHTAPIFallback="
        + unsupportedHTAPIFallback
        + ", "
        + "sessionInfo="
        + sessionInfoConnectionProperty
        + ", "
        + "useReadAPI="
        + useReadAPI
        + ", "
        + "kmsKeyName="
        + kmsKeyName
        + ", "
        + "highThroughputMinTableSize="
        + highThroughputMinTableSize
        + ", "
        + "highThroughputActivationRatio="
        + highThroughputActivationRatio
        + ", "
        + "useQueryCache="
        + useQueryCache
        + ", "
        + "queryDialect="
        + queryDialect
        + ", "
        + "queryProperties="
        + queryProperties
        + ", "
        + "allowLargeResults="
        + allowLargeResults
        + ", "
        + "clustering="
        + clustering
        + ", "
        + "createDisposition="
        + createDisposition
        + ", "
        + "destinationEncryptionConfiguration="
        + destinationEncryptionConfiguration
        + ", "
        + "destinationTable="
        + destinationTable
        + ", "
        + "destinationDataset="
        + destinationDataset
        + ", "
        + "destinationDatasetExpirationTime="
        + destinationDatasetExpirationTime
        + ", "
        + "jobTimeoutMs="
        + jobTimeoutMs
        + ", "
        + "maximumBillingTier="
        + maximumBillingTier
        + ", "
        + "priority="
        + priority
        + ", "
        + "rangePartitioning="
        + rangePartitioning
        + ", "
        + "schemaUpdateOptions="
        + schemaUpdateOptions
        + ", "
        + "tableDefinitions="
        + tableDefinitions
        + ", "
        + "timePartitioning="
        + timePartitioning
        + ", "
        + "userDefinedFunctions="
        + userDefinedFunctions
        + ", "
        + "writeDisposition="
        + writeDisposition
        + ", "
        + "numBufferedRows="
        + numBufferedRows
        + ", "
        + "maxResultPerPage="
        + maxResultPerPage
        + ", "
        + "defaultDataset="
        + defaultDataset
        + ", "
        + "useWriteAPI="
        + useWriteAPI
        + ", "
        + "writeAPIActivationRowCount="
        + writeAPIActivationRowCount
        + ", "
        + "writeAPIAppendRowCount="
        + writeAPIAppendRowCount
        + ", "
        + "maxBytesBilled="
        + maxBytesBilled
        + "}";
  }

  /** Returns a builder pre-populated using the current values of this field. */
  Builder toBuilder() {
    return new Builder(this);
  }

  static final class Builder {

    private boolean useReadAPI;
    private int highThroughputMinTableSize;
    private int highThroughputActivationRatio;
    private boolean enableSession;
    private boolean unsupportedHTAPIFallback;
    private ConnectionProperty sessionInfoConnectionProperty;
    private boolean useQueryCache;
    private String queryDialect;
    private List<ConnectionProperty> queryProperties;
    private Boolean allowLargeResults;
    private String kmsKeyName;
    private Clustering clustering;
    private JobInfo.CreateDisposition createDisposition;
    private EncryptionConfiguration destinationEncryptionConfiguration;
    private String destinationTable;
    private String destinationDataset;
    private long destinationDatasetExpirationTime;
    private long jobTimeoutMs;
    private int maximumBillingTier;
    private QueryJobConfiguration.Priority priority;
    private RangePartitioning rangePartitioning;
    private List<JobInfo.SchemaUpdateOption> schemaUpdateOptions;
    private Map<String, ExternalTableDefinition> tableDefinitions;
    private TimePartitioning timePartitioning;
    private List<UserDefinedFunction> userDefinedFunctions;
    private JobInfo.WriteDisposition writeDisposition;
    private int numBufferedRows;
    private long maxResultPerPage;
    private DatasetId defaultDataset;
    private boolean useWriteAPI;
    private int writeAPIActivationRowCount;
    private int writeAPIAppendRowCount;
    private long maxBytesBilled;
    private Map<String, String> labels;

    Builder() {
      this.withDefaultValues();
    }

    private Builder(BigQuerySettings querySettings) {
      this.useReadAPI = querySettings.getUseReadAPI();
      this.highThroughputMinTableSize = querySettings.getHighThroughputMinTableSize();
      this.highThroughputActivationRatio = querySettings.getHighThroughputActivationRatio();
      this.enableSession = querySettings.isEnableSession();
      this.unsupportedHTAPIFallback = querySettings.isUnsupportedHTAPIFallback();
      this.sessionInfoConnectionProperty = querySettings.getSessionInfoConnectionProperty();
      this.useQueryCache = querySettings.getUseQueryCache();
      this.queryDialect = querySettings.getQueryDialect();
      this.queryProperties = querySettings.getQueryProperties();
      this.allowLargeResults = querySettings.getAllowLargeResults();
      this.kmsKeyName = querySettings.getKmsKeyName();
      this.clustering = querySettings.getClustering();
      this.createDisposition = querySettings.getCreateDisposition();
      this.destinationEncryptionConfiguration =
          querySettings.getDestinationEncryptionConfiguration();
      this.destinationTable = querySettings.getDestinationTable();
      this.destinationDataset = querySettings.getDestinationDataset();
      this.destinationDatasetExpirationTime = querySettings.destinationDatasetExpirationTime;
      this.jobTimeoutMs = querySettings.getJobTimeoutMs();
      this.maximumBillingTier = querySettings.getMaximumBillingTier();
      this.priority = querySettings.getPriority();
      this.rangePartitioning = querySettings.getRangePartitioning();
      this.schemaUpdateOptions = querySettings.getSchemaUpdateOptions();
      this.tableDefinitions = querySettings.getTableDefinitions();
      this.timePartitioning = querySettings.getTimePartitioning();
      this.userDefinedFunctions = querySettings.getUserDefinedFunctions();
      this.writeDisposition = querySettings.getWriteDisposition();
      this.numBufferedRows = querySettings.getNumBufferedRows();
      this.maxResultPerPage = querySettings.getMaxResultPerPage();
      this.defaultDataset = querySettings.getDefaultDataset();
      this.useWriteAPI = querySettings.isUseWriteAPI();
      this.writeAPIActivationRowCount = querySettings.getWriteAPIActivationRowCount();
      this.writeAPIAppendRowCount = querySettings.getWriteAPIAppendRowCount();
      this.maxBytesBilled = querySettings.getMaxBytesBilled();
      this.labels = querySettings.getLabels();
    }

    Builder withDefaultValues() {
      return setUseReadAPI(false) // Read API is disabled by default;
          .setQueryDialect(BigQueryJdbcUrlUtility.DEFAULT_QUERY_DIALECT_VALUE)
          .setNumBufferedRows(10000) // 10K records will be kept in the buffer (Blocking Queue);
          .setMaxResultPerPage(BigQueryJdbcUrlUtility.DEFAULT_MAX_RESULTS_VALUE);
    }

    /**
     * Sets useReadAPI flag, enabled by default. Read API will be used if the underlying conditions
     * are satisfied and this flag is enabled
     *
     * @param useReadAPI or {@code true} for none
     */
    Builder setUseReadAPI(boolean useReadAPI) {
      this.useReadAPI = useReadAPI;
      return this;
    }

    /**
     * Sets the minimum table size for which the BigQuery Storage API will be used.
     *
     * <p>When query results are large, exceeding both the row and page limits, the connector
     * automatically switches to the BigQuery Storage API for faster processing. This method allows
     * you to configure a threshold for table size, enabling the use of the BigQuery Storage API
     * when the limit is exceeded, provided the table size exceeds the specified value.
     *
     * @param highThroughputMinTableSize the minimum table size to trigger the use of the BigQuery
     *     Storage API
     */
    Builder setHighThroughputMinTableSize(int highThroughputMinTableSize) {
      this.highThroughputMinTableSize = highThroughputMinTableSize;
      return this;
    }

    /**
     * Sets the activation ratio for switching to the BigQuery Storage API.
     *
     * <p>The connector switches to the BigQuery Storage API when the number of pages in the query
     * results exceeds this value AND the table size is greater than or equal to the value set or
     * default value of {@link #setHighThroughputMinTableSize(int)}.
     *
     * @param highThroughputActivationRatio the activation ratio for switching to BigQuery Storage
     *     API
     */
    Builder setHighThroughputActivationRatio(int highThroughputActivationRatio) {
      this.highThroughputActivationRatio = highThroughputActivationRatio;
      return this;
    }

    /**
     * setting true, enables session-level features such as capturing SQL activities or enabling
     * multi-statement transactions. Session tracking is disabled by default.
     */
    Builder setEnableSession(boolean enableSession) {
      this.enableSession = enableSession;
      return this;
    }

    /**
     * When the connector uses fetch workflows not supported on the High-Throughput API, this option
     * specifies whether the connector falls back to the REST API or returns an error. By default it
     * falls back to standard API.
     *
     * @param unsupportedHTAPIFallback true if falls back to standard, false to error.
     */
    Builder setUnsupportedHTAPIFallback(boolean unsupportedHTAPIFallback) {
      this.unsupportedHTAPIFallback = unsupportedHTAPIFallback;
      return this;
    }

    /**
     * Setting session information associated with the job.
     *
     * <p>BigQuery's sessions provide a way to link multiple jobs and maintain temporary data, such
     * as temporary tables, between them. They are needed for using multi-statement transactions
     * that span across multiple queries.
     */
    Builder setSessionInfoConnectionProperty(ConnectionProperty sessionInfoConnectionProperty) {
      this.sessionInfoConnectionProperty = sessionInfoConnectionProperty;
      return this;
    }

    Builder setUseQueryCache(boolean useQueryCache) {
      this.useQueryCache = useQueryCache;
      return this;
    }

    Builder setAllowLargeResults(Boolean allowLargeResults) {
      this.allowLargeResults = allowLargeResults;
      return this;
    }

    /**
     * Set the KMS resource key name which is the unique identifier you give to your encryption key
     * in Google Cloud's Key Management Service (KMS). Tells BigQuery which key to use when
     * encrypting or decrypting your data.
     */
    Builder setKmsKeyName(String kmsKeyName) {
      this.kmsKeyName = kmsKeyName;
      return this;
    }

    Builder setQueryDialect(String queryDialect) {
      this.queryDialect = queryDialect;
      return this;
    }

    Builder setQueryProperties(List<ConnectionProperty> queryProperties) {
      this.queryProperties = queryProperties;
      return this;
    }

    /** Sets the clustering specification for the destination table. */
    Builder setClustering(Clustering clustering) {
      this.clustering = clustering;
      return this;
    }

    /**
     * Sets whether the job is allowed to create tables.
     *
     * @see <a
     *     href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.query.createDisposition">
     *     Create Disposition</a>
     */
    Builder setCreateDisposition(JobInfo.CreateDisposition createDisposition) {
      this.createDisposition = createDisposition;
      return this;
    }

    /**
     * Sets the custom encryption configuration (e.g., Cloud KMS keys).
     *
     * @param destinationEncryptionConfiguration destinationEncryptionConfiguration or {@code null}
     *     for none
     */
    Builder setDestinationEncryptionConfiguration(
        EncryptionConfiguration destinationEncryptionConfiguration) {
      this.destinationEncryptionConfiguration = destinationEncryptionConfiguration;
      return this;
    }

    Builder setDestinationTable(String destinationTable) {
      this.destinationTable = destinationTable;
      return this;
    }

    Builder setDestinationDataset(String destinationDataset) {
      this.destinationDataset = destinationDataset;
      return this;
    }

    Builder setDestinationDatasetExpirationTime(long destinationDatasetExpirationTime) {
      this.destinationDatasetExpirationTime = destinationDatasetExpirationTime;
      return this;
    }

    /**
     * [Optional] Job timeout in milliseconds. If this time limit is exceeded, BigQuery may attempt
     * to terminate the job.
     *
     * @param jobTimeoutMs jobTimeoutMs or {@code null} for none
     */
    Builder setJobTimeoutMs(long jobTimeoutMs) {
      this.jobTimeoutMs = jobTimeoutMs;
      return this;
    }

    /**
     * Limits the billing tier for this job. Queries that have resource usage beyond this tier will
     * fail (without incurring a charge). If unspecified, this will be set to your project default.
     *
     * @param maximumBillingTier maximum billing tier for this job
     */
    Builder setMaximumBillingTier(int maximumBillingTier) {
      this.maximumBillingTier = maximumBillingTier;
      return this;
    }

    /**
     * Sets a priority for the query. If not specified the priority is assumed to be {@link
     * Priority#INTERACTIVE}.
     */
    Builder setPriority(QueryJobConfiguration.Priority priority) {
      this.priority = priority;
      return this;
    }

    /**
     * Range partitioning specification for this table. Only one of timePartitioning and
     * rangePartitioning should be specified.
     *
     * @param rangePartitioning rangePartitioning or {@code null} for none
     */
    Builder setRangePartitioning(RangePartitioning rangePartitioning) {
      this.rangePartitioning = rangePartitioning;
      return this;
    }

    /**
     * Sets options allowing the schema of the destination table to be updated as a side effect of
     * the query job. Schema update options are supported in two cases: when writeDisposition is
     * WRITE_APPEND; when writeDisposition is WRITE_TRUNCATE and the destination table is a
     * partition of a table, specified by partition decorators. For normal tables, WRITE_TRUNCATE
     * will always overwrite the schema.
     */
    Builder setSchemaUpdateOptions(List<JobInfo.SchemaUpdateOption> schemaUpdateOptions) {
      this.schemaUpdateOptions = schemaUpdateOptions;
      return this;
    }

    /**
     * Sets the external tables definitions. If querying external data sources outside BigQuery,
     * this value describes the data format, location and other properties of the data sources. By
     * defining these properties, the data sources can be queried as if they were standard BigQuery
     * tables.
     */
    Builder setTableDefinitions(Map<String, ExternalTableDefinition> tableDefinitions) {
      this.tableDefinitions = tableDefinitions;
      return this;
    }

    /** Sets the time partitioning specification for the destination table. */
    Builder setTimePartitioning(TimePartitioning timePartitioning) {
      this.timePartitioning = timePartitioning;
      return this;
    }

    /**
     * Sets user defined function resources that can be used by this query. Function resources can
     * either be defined inline ({@link UserDefinedFunction#inline(String)}) or loaded from a Google
     * Cloud Storage URI ({@link UserDefinedFunction#fromUri(String)}.
     */
    Builder setUserDefinedFunctions(List<UserDefinedFunction> userDefinedFunctions) {
      this.userDefinedFunctions = userDefinedFunctions;
      return this;
    }

    /**
     * Sets the action that should occur if the destination table already exists.
     *
     * @see <a
     *     href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.query.writeDisposition">
     *     Write Disposition</a>
     */
    Builder setWriteDisposition(JobInfo.WriteDisposition writeDisposition) {
      this.writeDisposition = writeDisposition;
      return this;
    }

    /**
     * Sets the number of rows in the buffer (a blocking queue) that query results are consumed
     * from.
     *
     * @param numBufferedRows numBufferedRows or {@code null} for none
     */
    Builder setNumBufferedRows(int numBufferedRows) {
      this.numBufferedRows = numBufferedRows;
      return this;
    }

    /**
     * Sets the maximum records per page to be used for pagination. This is used as an input for the
     * tabledata.list and jobs.getQueryResults RPC calls
     *
     * @param maxResultPerPage
     */
    Builder setMaxResultPerPage(long maxResultPerPage) {
      this.maxResultPerPage = maxResultPerPage;
      return this;
    }

    Builder setDefaultDataset(DatasetId defaultDataset) {
      this.defaultDataset = defaultDataset;
      return this;
    }

    Builder setUseWriteAPI(boolean useWriteAPI) {
      this.useWriteAPI = useWriteAPI;
      return this;
    }

    Builder setWriteAPIActivationRowCount(int writeAPIActivationRowCount) {
      this.writeAPIActivationRowCount = writeAPIActivationRowCount;
      return this;
    }

    Builder setWriteAPIAppendRowCount(int writeAPIAppendRowCount) {
      this.writeAPIAppendRowCount = writeAPIAppendRowCount;
      return this;
    }

    Builder setMaxBytesBilled(long maxBytesBilled) {
      this.maxBytesBilled = maxBytesBilled;
      return this;
    }

    Builder setLabels(Map<String, String> labels) {
      this.labels = labels;
      return this;
    }

    /** Creates a {@code BigQuerySettings} object. */
    BigQuerySettings build() {
      return new BigQuerySettings(this);
    }
  }
}
