/*
 * Copyright 2016 Google LLC
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
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

import com.google.api.services.bigquery.model.JobConfigurationQuery;
import com.google.api.services.bigquery.model.QueryParameter;
import com.google.cloud.bigquery.JobInfo.CreateDisposition;
import com.google.cloud.bigquery.JobInfo.SchemaUpdateOption;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Google BigQuery Query Job configuration. A Query Job runs a query against BigQuery data. Query
 * job configurations have {@link JobConfiguration.Type#QUERY} type.
 */
public final class QueryJobConfiguration extends JobConfiguration {

  private static final long serialVersionUID = -1108948249081804890L;

  private final String query;
  private final ImmutableList<QueryParameterValue> positionalParameters;
  private final ImmutableMap<String, QueryParameterValue> namedParameters;
  private final TableId destinationTable;
  private final Map<String, ExternalTableDefinition> tableDefinitions;
  private final List<UserDefinedFunction> userDefinedFunctions;
  private final CreateDisposition createDisposition;
  private final WriteDisposition writeDisposition;
  private final DatasetId defaultDataset;
  private final Priority priority;
  private final Boolean allowLargeResults;
  private final Boolean useQueryCache;
  private final Boolean flattenResults;
  private final Boolean dryRun;
  private final Boolean useLegacySql;
  private final Integer maximumBillingTier;
  private final Long maximumBytesBilled;
  private final List<SchemaUpdateOption> schemaUpdateOptions;
  private final EncryptionConfiguration destinationEncryptionConfiguration;
  private final TimePartitioning timePartitioning;
  private final Clustering clustering;
  private final Long jobTimeoutMs;
  private final Map<String, String> labels;
  private final RangePartitioning rangePartitioning;
  private final List<ConnectionProperty> connectionProperties;
  // maxResults is only used for fast query path
  private final Long maxResults;

  /**
   * Priority levels for a query. If not specified the priority is assumed to be {@link
   * Priority#INTERACTIVE}.
   */
  public enum Priority {
    /**
     * Query is executed as soon as possible and count towards the <a
     * href="https://cloud.google.com/bigquery/quota-policy">concurrent rate limit and the daily
     * rate limit</a>.
     */
    INTERACTIVE,

    /**
     * Query is queued and started as soon as idle resources are available, usually within a few
     * minutes. If the query hasn't started within 3 hours, its priority is changed to {@link
     * Priority#INTERACTIVE}.
     */
    BATCH
  }

  public static final class Builder
      extends JobConfiguration.Builder<QueryJobConfiguration, Builder> {

    private String query;
    private List<QueryParameterValue> positionalParameters = Lists.newArrayList();
    private Map<String, QueryParameterValue> namedParameters = Maps.newHashMap();
    private TableId destinationTable;
    private Map<String, ExternalTableDefinition> tableDefinitions;
    private List<UserDefinedFunction> userDefinedFunctions;
    private CreateDisposition createDisposition;
    private WriteDisposition writeDisposition;
    private DatasetId defaultDataset;
    private Priority priority;
    private Boolean allowLargeResults;
    private Boolean useQueryCache;
    private Boolean flattenResults;
    private Boolean dryRun;
    private Boolean useLegacySql = false;
    private Integer maximumBillingTier;
    private Long maximumBytesBilled;
    private List<SchemaUpdateOption> schemaUpdateOptions;
    private EncryptionConfiguration destinationEncryptionConfiguration;
    private TimePartitioning timePartitioning;
    private Clustering clustering;
    private Long jobTimeoutMs;
    private Map<String, String> labels;
    private RangePartitioning rangePartitioning;
    private List<ConnectionProperty> connectionProperties;
    private Long maxResults;

    private Builder() {
      super(Type.QUERY);
    }

    private Builder(QueryJobConfiguration jobConfiguration) {
      this();
      this.query = jobConfiguration.query;
      this.namedParameters = jobConfiguration.namedParameters;
      this.positionalParameters = jobConfiguration.positionalParameters;
      this.destinationTable = jobConfiguration.destinationTable;
      this.tableDefinitions = jobConfiguration.tableDefinitions;
      this.userDefinedFunctions = jobConfiguration.userDefinedFunctions;
      this.createDisposition = jobConfiguration.createDisposition;
      this.writeDisposition = jobConfiguration.writeDisposition;
      this.defaultDataset = jobConfiguration.defaultDataset;
      this.priority = jobConfiguration.priority;
      this.allowLargeResults = jobConfiguration.allowLargeResults;
      this.useQueryCache = jobConfiguration.useQueryCache;
      this.flattenResults = jobConfiguration.flattenResults;
      this.dryRun = jobConfiguration.dryRun;
      this.useLegacySql = jobConfiguration.useLegacySql;
      this.maximumBillingTier = jobConfiguration.maximumBillingTier;
      this.maximumBytesBilled = jobConfiguration.maximumBytesBilled;
      this.schemaUpdateOptions = jobConfiguration.schemaUpdateOptions;
      this.destinationEncryptionConfiguration = jobConfiguration.destinationEncryptionConfiguration;
      this.timePartitioning = jobConfiguration.timePartitioning;
      this.clustering = jobConfiguration.clustering;
      this.jobTimeoutMs = jobConfiguration.jobTimeoutMs;
      this.labels = jobConfiguration.labels;
      this.rangePartitioning = jobConfiguration.rangePartitioning;
      this.connectionProperties = jobConfiguration.connectionProperties;
      this.maxResults = jobConfiguration.maxResults;
    }

    private Builder(com.google.api.services.bigquery.model.JobConfiguration configurationPb) {
      this();
      JobConfigurationQuery queryConfigurationPb = configurationPb.getQuery();
      this.query = queryConfigurationPb.getQuery();
      if (queryConfigurationPb.getQueryParameters() != null
          && !queryConfigurationPb.getQueryParameters().isEmpty()) {
        if (queryConfigurationPb.getQueryParameters().get(0).getName() == null) {
          setPositionalParameters(
              Lists.transform(
                  queryConfigurationPb.getQueryParameters(),
                  POSITIONAL_PARAMETER_FROM_PB_FUNCTION));
        } else {
          Map<String, QueryParameterValue> values = Maps.newHashMap();
          for (QueryParameter queryParameterPb : queryConfigurationPb.getQueryParameters()) {
            checkNotNull(queryParameterPb.getName());
            QueryParameterValue value =
                QueryParameterValue.fromPb(
                    queryParameterPb.getParameterValue(), queryParameterPb.getParameterType());
            values.put(queryParameterPb.getName(), value);
          }
          setNamedParameters(values);
        }
      }
      allowLargeResults = queryConfigurationPb.getAllowLargeResults();
      useQueryCache = queryConfigurationPb.getUseQueryCache();
      flattenResults = queryConfigurationPb.getFlattenResults();
      useLegacySql = queryConfigurationPb.getUseLegacySql();
      if (queryConfigurationPb.getMaximumBillingTier() != null) {
        maximumBillingTier = queryConfigurationPb.getMaximumBillingTier();
      }
      if (queryConfigurationPb.getMaximumBytesBilled() != null) {
        maximumBytesBilled = queryConfigurationPb.getMaximumBytesBilled();
      }
      dryRun = configurationPb.getDryRun();
      if (queryConfigurationPb.getDestinationTable() != null) {
        destinationTable = TableId.fromPb(queryConfigurationPb.getDestinationTable());
      }
      if (queryConfigurationPb.getDefaultDataset() != null) {
        defaultDataset = DatasetId.fromPb(queryConfigurationPb.getDefaultDataset());
      }
      if (queryConfigurationPb.getPriority() != null) {
        priority = Priority.valueOf(queryConfigurationPb.getPriority());
      }
      if (queryConfigurationPb.getTableDefinitions() != null) {
        tableDefinitions =
            Maps.transformValues(
                queryConfigurationPb.getTableDefinitions(),
                ExternalTableDefinition.FROM_EXTERNAL_DATA_FUNCTION);
      }
      if (queryConfigurationPb.getUserDefinedFunctionResources() != null) {
        userDefinedFunctions =
            Lists.transform(
                queryConfigurationPb.getUserDefinedFunctionResources(),
                UserDefinedFunction.FROM_PB_FUNCTION);
      }
      if (queryConfigurationPb.getCreateDisposition() != null) {
        createDisposition = CreateDisposition.valueOf(queryConfigurationPb.getCreateDisposition());
      }
      if (queryConfigurationPb.getWriteDisposition() != null) {
        writeDisposition = WriteDisposition.valueOf(queryConfigurationPb.getWriteDisposition());
      }
      if (queryConfigurationPb.getSchemaUpdateOptions() != null) {
        ImmutableList.Builder<JobInfo.SchemaUpdateOption> schemaUpdateOptionsBuilder =
            new ImmutableList.Builder<>();
        for (String rawSchemaUpdateOption : queryConfigurationPb.getSchemaUpdateOptions()) {
          schemaUpdateOptionsBuilder.add(JobInfo.SchemaUpdateOption.valueOf(rawSchemaUpdateOption));
        }
        this.schemaUpdateOptions = schemaUpdateOptionsBuilder.build();
      }
      if (queryConfigurationPb.getDestinationEncryptionConfiguration() != null) {
        this.destinationEncryptionConfiguration =
            new EncryptionConfiguration.Builder(
                    queryConfigurationPb.getDestinationEncryptionConfiguration())
                .build();
      }
      if (queryConfigurationPb.getTimePartitioning() != null) {
        this.timePartitioning = TimePartitioning.fromPb(queryConfigurationPb.getTimePartitioning());
      }
      if (queryConfigurationPb.getClustering() != null) {
        this.clustering = Clustering.fromPb(queryConfigurationPb.getClustering());
      }
      if (configurationPb.getJobTimeoutMs() != null) {
        this.jobTimeoutMs = configurationPb.getJobTimeoutMs();
      }
      if (configurationPb.getLabels() != null) {
        this.labels = configurationPb.getLabels();
      }
      if (queryConfigurationPb.getRangePartitioning() != null) {
        this.rangePartitioning =
            RangePartitioning.fromPb(queryConfigurationPb.getRangePartitioning());
      }
      if (queryConfigurationPb.getConnectionProperties() != null) {
        this.connectionProperties =
            Lists.transform(
                queryConfigurationPb.getConnectionProperties(),
                ConnectionProperty.FROM_PB_FUNCTION);
      }
    }

    /** Sets the BigQuery SQL query to execute. */
    public Builder setQuery(String query) {
      this.query = query;
      return this;
    }

    /**
     * Adds a positional query parameter to the list of query parameters. See {@link
     * #setPositionalParameters(Iterable)} for more details on the input requirements.
     *
     * <p>A positional parameter cannot be added after named parameters have been added.
     */
    public Builder addPositionalParameter(QueryParameterValue value) {
      checkNotNull(value);
      if (!namedParameters.isEmpty()) {
        throw new IllegalStateException(
            "Positional parameters can't be combined with named parameters");
      }
      positionalParameters.add(value);
      return this;
    }

    /**
     * Sets the query parameters to a list of positional query parameters to use in the query.
     *
     * <p>The set of query parameters must either be all positional or all named parameters.
     * Positional parameters are denoted in the query with a question mark (?).
     *
     * <p>Additionally, useLegacySql must be set to false; query parameters cannot be used with
     * legacy SQL.
     *
     * <p>The values parameter can be set to null to clear out the positional parameters so that
     * named parameters can be used instead.
     */
    public Builder setPositionalParameters(Iterable<QueryParameterValue> values) {
      if (values == null || Iterables.isEmpty(values)) {
        positionalParameters = Lists.newArrayList();
      } else {
        if (!this.namedParameters.isEmpty()) {
          throw new IllegalStateException(
              "Positional parameters can't be combined with named parameters");
        }
        this.positionalParameters = Lists.newArrayList(values);
      }
      return this;
    }

    /**
     * Adds a named query parameter to the set of query parameters. See {@link
     * #setNamedParameters(Map)} for more details on the input requirements.
     *
     * <p>A named parameter cannot be added after positional parameters have been added.
     */
    public Builder addNamedParameter(String name, QueryParameterValue value) {
      checkNotNull(value);
      if (!this.positionalParameters.isEmpty()) {
        throw new IllegalStateException(
            "Named parameters can't be combined with positional parameters");
      }
      namedParameters.put(name, value);
      return this;
    }

    /**
     * Sets the query parameters to a set of named query parameters to use in the query.
     *
     * <p>The set of query parameters must either be all positional or all named parameters. Named
     * parameters are denoted using an @ prefix, e.g. @myParam for a parameter named "myParam".
     *
     * <p>Additionally, useLegacySql must be set to false; query parameters cannot be used with
     * legacy SQL.
     *
     * <p>The values parameter can be set to null to clear out the named parameters so that
     * positional parameters can be used instead.
     */
    public Builder setNamedParameters(Map<String, QueryParameterValue> values) {
      if (values == null || values.isEmpty()) {
        namedParameters = Maps.newHashMap();
      } else {
        if (!this.positionalParameters.isEmpty()) {
          throw new IllegalStateException(
              "Named parameters can't be combined with positional parameters");
        }
        this.namedParameters = Maps.newHashMap(values);
      }
      return this;
    }

    /**
     * Sets the table where to put query results. If not provided a new table is created. This value
     * is required if {@link Builder#setAllowLargeResults(Boolean)} is set to {@code true}.
     */
    public Builder setDestinationTable(TableId destinationTable) {
      this.destinationTable = destinationTable;
      return this;
    }

    public Builder setDestinationEncryptionConfiguration(
        EncryptionConfiguration encryptionConfiguration) {
      this.destinationEncryptionConfiguration = encryptionConfiguration;
      return this;
    }

    /**
     * Sets the external tables definitions. If querying external data sources outside of BigQuery,
     * this value describes the data format, location and other properties of the data sources. By
     * defining these properties, the data sources can be queried as if they were standard BigQuery
     * tables.
     */
    public Builder setTableDefinitions(Map<String, ExternalTableDefinition> tableDefinitions) {
      this.tableDefinitions = tableDefinitions != null ? Maps.newHashMap(tableDefinitions) : null;
      return this;
    }

    /**
     * Adds a new external table definition. If a definition already exists for {@code tableName} it
     * is updated.
     *
     * @param tableName name of the table
     * @param tableDefinition external data configuration for the table used by this query
     */
    public Builder addTableDefinition(String tableName, ExternalTableDefinition tableDefinition) {
      if (this.tableDefinitions == null) {
        this.tableDefinitions = Maps.newHashMap();
      }
      this.tableDefinitions.put(checkNotNull(tableName), checkNotNull(tableDefinition));
      return this;
    }

    /**
     * Sets user defined function resources that can be used by this query. Function resources can
     * either be defined inline ({@link UserDefinedFunction#inline(String)}) or loaded from a Google
     * Cloud Storage URI ({@link UserDefinedFunction#fromUri(String)}.
     */
    public Builder setUserDefinedFunctions(List<UserDefinedFunction> userDefinedFunctions) {
      this.userDefinedFunctions =
          userDefinedFunctions != null ? ImmutableList.copyOf(userDefinedFunctions) : null;
      return this;
    }

    /**
     * Sets whether the job is allowed to create tables.
     *
     * @see <a
     *     href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.query.createDisposition">
     *     Create Disposition</a>
     */
    public Builder setCreateDisposition(CreateDisposition createDisposition) {
      this.createDisposition = createDisposition;
      return this;
    }

    /**
     * Sets the action that should occur if the destination table already exists.
     *
     * @see <a
     *     href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.query.writeDisposition">
     *     Write Disposition</a>
     */
    public Builder setWriteDisposition(WriteDisposition writeDisposition) {
      this.writeDisposition = writeDisposition;
      return this;
    }

    /**
     * Sets the default dataset. This dataset is used for all unqualified table names used in the
     * query.
     */
    public Builder setDefaultDataset(DatasetId defaultDataset) {
      this.defaultDataset = defaultDataset;
      return this;
    }

    /**
     * Sets the default dataset. This dataset is used for all unqualified table names used in the
     * query.
     */
    public Builder setDefaultDataset(String defaultDataset) {
      return setDefaultDataset(DatasetId.of(defaultDataset));
    }

    /**
     * Sets a priority for the query. If not specified the priority is assumed to be {@link
     * Priority#INTERACTIVE}.
     */
    public Builder setPriority(Priority priority) {
      this.priority = priority;
      return this;
    }

    /**
     * Sets whether the job is enabled to create arbitrarily large results. If {@code true} the
     * query is allowed to create large results at a slight cost in performance. If {@code true}
     * {@link Builder#setDestinationTable(TableId)} must be provided.
     *
     * @see <a href="https://cloud.google.com/bigquery/querying-data#largequeryresults">Returning
     *     Large Query Results</a>
     */
    public Builder setAllowLargeResults(Boolean allowLargeResults) {
      this.allowLargeResults = allowLargeResults;
      return this;
    }

    /**
     * Sets whether to look for the result in the query cache. The query cache is a best-effort
     * cache that will be flushed whenever tables in the query are modified. Moreover, the query
     * cache is only available when {@link Builder#setDestinationTable(TableId)} is not set.
     *
     * @see <a href="https://cloud.google.com/bigquery/querying-data#querycaching">Query Caching</a>
     */
    public Builder setUseQueryCache(Boolean useQueryCache) {
      this.useQueryCache = useQueryCache;
      return this;
    }

    /**
     * Sets whether nested and repeated fields should be flattened. If set to {@code false} {@link
     * Builder#setAllowLargeResults(Boolean)} must be {@code true}. By default results are
     * flattened.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/data#flatten">Flatten</a>
     */
    public Builder setFlattenResults(Boolean flattenResults) {
      this.flattenResults = flattenResults;
      return this;
    }

    /**
     * Sets whether the job has to be dry run or not. If set, the job is not executed. A valid query
     * will return a mostly empty response with some processing statistics, while an invalid query
     * will return the same error it would if it wasn't a dry run.
     */
    public Builder setDryRun(Boolean dryRun) {
      this.dryRun = dryRun;
      return this;
    }

    /**
     * Sets whether to use BigQuery's legacy SQL dialect for this query. By default this property is
     * set to {@code false}. If set to {@code false}, the query will use BigQuery's <a
     * href="https://cloud.google.com/bigquery/sql-reference/">Standard SQL</a>. When set to {@code
     * false}, the values of {@link #setAllowLargeResults(Boolean)} and {@link
     * #setFlattenResults(Boolean)} are ignored; query will be run as if {@link
     * #setAllowLargeResults(Boolean)} is {@code true} and {@link #setFlattenResults(Boolean)} is
     * {@code false}.
     *
     * <p>If set to {@code null} or {@code true}, legacy SQL dialect is used. This property is
     * experimental and might be subject to change.
     */
    public Builder setUseLegacySql(Boolean useLegacySql) {
      this.useLegacySql = useLegacySql;
      return this;
    }

    /**
     * Limits the billing tier for this job. Queries that have resource usage beyond this tier will
     * fail (without incurring a charge). If unspecified, this will be set to your project default.
     *
     * @param maximumBillingTier maximum billing tier for this job
     */
    public Builder setMaximumBillingTier(Integer maximumBillingTier) {
      this.maximumBillingTier = maximumBillingTier;
      return this;
    }

    /**
     * Limits the bytes billed for this job. Queries that will have bytes billed beyond this limit
     * will fail (without incurring a charge). If unspecified, this will be set to your project
     * default.
     *
     * @param maximumBytesBilled maximum bytes billed for this job
     */
    public Builder setMaximumBytesBilled(Long maximumBytesBilled) {
      this.maximumBytesBilled = maximumBytesBilled;
      return this;
    }

    /**
     * [Experimental] Sets options allowing the schema of the destination table to be updated as a
     * side effect of the query job. Schema update options are supported in two cases: when
     * writeDisposition is WRITE_APPEND; when writeDisposition is WRITE_TRUNCATE and the destination
     * table is a partition of a table, specified by partition decorators. For normal tables,
     * WRITE_TRUNCATE will always overwrite the schema.
     */
    public Builder setSchemaUpdateOptions(List<SchemaUpdateOption> schemaUpdateOptions) {
      this.schemaUpdateOptions = schemaUpdateOptions;
      return this;
    }

    /** Sets the time partitioning specification for the destination table. */
    public Builder setTimePartitioning(TimePartitioning timePartitioning) {
      this.timePartitioning = timePartitioning;
      return this;
    }

    /** Sets the clustering specification for the destination table. */
    public Builder setClustering(Clustering clustering) {
      this.clustering = clustering;
      return this;
    }

    /**
     * [Optional] Job timeout in milliseconds. If this time limit is exceeded, BigQuery may attempt
     * to terminate the job.
     *
     * @param jobTimeoutMs jobTimeoutMs or {@code null} for none
     */
    public Builder setJobTimeoutMs(Long jobTimeoutMs) {
      this.jobTimeoutMs = jobTimeoutMs;
      return this;
    }

    /**
     * The labels associated with this job. You can use these to organize and group your jobs. Label
     * keys and values can be no longer than 63 characters, can only contain lowercase letters,
     * numeric characters, underscores and dashes. International characters are allowed. Label
     * values are optional. Label keys must start with a letter and each label in the list must have
     * a different key.
     *
     * @param labels labels or {@code null} for none
     */
    public Builder setLabels(Map<String, String> labels) {
      this.labels = labels;
      return this;
    }

    /**
     * Range partitioning specification for this table. Only one of timePartitioning and
     * rangePartitioning should be specified.
     *
     * @param rangePartitioning rangePartitioning or {@code null} for none
     */
    public Builder setRangePartitioning(RangePartitioning rangePartitioning) {
      this.rangePartitioning = rangePartitioning;
      return this;
    }

    /**
     * A connection-level property to customize query behavior. Under JDBC, these correspond
     * directly to connection properties passed to the DriverManager. Under ODBC, these correspond
     * to properties in the connection string. Currently, the only supported connection property is
     * "time_zone", whose value represents the default timezone used to run the query. Additional
     * properties are allowed, but ignored. Specifying multiple connection properties with the same
     * key is an error.
     *
     * @param connectionProperties connectionProperties or {@code null} for none
     */
    public Builder setConnectionProperties(List<ConnectionProperty> connectionProperties) {
      this.connectionProperties = ImmutableList.copyOf(connectionProperties);
      return this;
    }

    /**
     * This is only supported in the fast query path [Optional] The maximum number of rows of data
     * to return per page of results. Setting this flag to a small value such as 1000 and then
     * paging through results might improve reliability when the query result set is large. In
     * addition to this limit, responses are also limited to 10 MB. By default, there is no maximum
     * row count, and only the byte limit applies.
     *
     * @param maxResults maxResults or {@code null} for none
     */
    public Builder setMaxResults(Long maxResults) {
      this.maxResults = maxResults;
      return this;
    }

    public QueryJobConfiguration build() {
      return new QueryJobConfiguration(this);
    }
  }

  private QueryJobConfiguration(Builder builder) {
    super(builder);
    this.query = checkNotNull(builder.query);
    checkNotNull(builder.positionalParameters);
    checkNotNull(builder.namedParameters);
    if (!builder.positionalParameters.isEmpty()) {
      checkArgument(builder.namedParameters.isEmpty());
    }
    if (!builder.namedParameters.isEmpty()) {
      checkArgument(builder.positionalParameters.isEmpty());
    }
    positionalParameters = ImmutableList.copyOf(builder.positionalParameters);
    namedParameters = ImmutableMap.copyOf(builder.namedParameters);
    this.allowLargeResults = builder.allowLargeResults;
    this.createDisposition = builder.createDisposition;
    this.defaultDataset = builder.defaultDataset;
    this.destinationTable = builder.destinationTable;
    this.flattenResults = builder.flattenResults;
    this.priority = builder.priority;
    this.useQueryCache = builder.useQueryCache;
    this.userDefinedFunctions = builder.userDefinedFunctions;
    this.writeDisposition = builder.writeDisposition;
    this.tableDefinitions =
        builder.tableDefinitions != null ? ImmutableMap.copyOf(builder.tableDefinitions) : null;
    this.dryRun = builder.dryRun;
    this.useLegacySql = builder.useLegacySql;
    this.maximumBillingTier = builder.maximumBillingTier;
    this.maximumBytesBilled = builder.maximumBytesBilled;
    this.schemaUpdateOptions = builder.schemaUpdateOptions;
    this.destinationEncryptionConfiguration = builder.destinationEncryptionConfiguration;
    this.timePartitioning = builder.timePartitioning;
    this.clustering = builder.clustering;
    this.jobTimeoutMs = builder.jobTimeoutMs;
    this.labels = builder.labels;
    this.rangePartitioning = builder.rangePartitioning;
    this.connectionProperties = builder.connectionProperties;
    this.maxResults = builder.maxResults;
  }

  /**
   * Returns whether the job is enabled to create arbitrarily large results. If {@code true} the
   * query is allowed to create large results at a slight cost in performance. the query is allowed
   * to create large results at a slight cost in performance.
   *
   * @see <a href="https://cloud.google.com/bigquery/querying-data#largequeryresults">Returning
   *     Large Query Results</a>
   */
  public Boolean allowLargeResults() {
    return allowLargeResults;
  }

  /**
   * Returns whether the job is allowed to create new tables.
   *
   * @see <a
   *     href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.query.createDisposition">
   *     Create Disposition</a>
   */
  public CreateDisposition getCreateDisposition() {
    return createDisposition;
  }

  /**
   * Returns the default dataset. This dataset is used for all unqualified table names used in the
   * query.
   */
  public DatasetId getDefaultDataset() {
    return defaultDataset;
  }

  /**
   * Returns the table where to put query results. If not provided a new table is created. This
   * value is required if {@link #allowLargeResults()} is {@code true}.
   */
  public TableId getDestinationTable() {
    return destinationTable;
  }

  public EncryptionConfiguration getDestinationEncryptionConfiguration() {
    return destinationEncryptionConfiguration;
  }

  /**
   * Returns whether nested and repeated fields should be flattened. If set to {@code false} {@link
   * Builder#setAllowLargeResults(Boolean)} must be {@code true}.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/data#flatten">Flatten</a>
   */
  public Boolean flattenResults() {
    return flattenResults;
  }

  /** Returns the query priority. */
  public Priority getPriority() {
    return priority;
  }

  /** Returns the Google BigQuery SQL query. */
  public String getQuery() {
    return query;
  }

  /** Returns the positional query parameters to use for the query. */
  public List<QueryParameterValue> getPositionalParameters() {
    return positionalParameters;
  }

  /** Returns the named query parameters to use for the query. */
  public Map<String, QueryParameterValue> getNamedParameters() {
    return namedParameters;
  }

  /**
   * Returns the external tables definitions. If querying external data sources outside of BigQuery,
   * this value describes the data format, location and other properties of the data sources. By
   * defining these properties, the data sources can be queried as if they were standard BigQuery
   * tables.
   */
  public Map<String, ExternalTableDefinition> getTableDefinitions() {
    return tableDefinitions;
  }

  /**
   * Returns whether to look for the result in the query cache. The query cache is a best-effort
   * cache that will be flushed whenever tables in the query are modified. Moreover, the query cache
   * is only available when {@link Builder#setDestinationTable(TableId)} is not set.
   *
   * @see <a href="https://cloud.google.com/bigquery/querying-data#querycaching">Query Caching</a>
   */
  public Boolean useQueryCache() {
    return useQueryCache;
  }

  /**
   * Returns user defined function resources that can be used by this query. Function resources can
   * either be defined inline ({@link UserDefinedFunction.Type#INLINE}) or loaded from a Google
   * Cloud Storage URI ({@link UserDefinedFunction.Type#FROM_URI}.
   */
  public List<UserDefinedFunction> getUserDefinedFunctions() {
    return userDefinedFunctions;
  }

  /**
   * Returns the action that should occur if the destination table already exists.
   *
   * @see <a
   *     href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.query.writeDisposition">
   *     Write Disposition</a>
   */
  public WriteDisposition getWriteDisposition() {
    return writeDisposition;
  }

  /**
   * Returns whether the job has to be dry run or not. If set, the job is not executed. A valid
   * query will return a mostly empty response with some processing statistics, while an invalid
   * query will return the same error it would if it wasn't a dry run.
   */
  public Boolean dryRun() {
    return dryRun;
  }

  /**
   * Returns whether to use BigQuery's legacy SQL dialect for this query. By default this property
   * is set to {@code false}. If set to {@code false}, the query will use BigQuery's <a
   * href="https://cloud.google.com/bigquery/sql-reference/">Standard SQL</a>. When set to {@code
   * false}, the values of {@link #allowLargeResults()} and {@link #flattenResults()} are ignored;
   * query will be run as if {@link #allowLargeResults()} is {@code true} and {@link
   * #flattenResults()} is {@code false}. If set to {@code null} or {@code true}, legacy SQL dialect
   * is used. This property is experimental and might be subject to change.
   */
  public Boolean useLegacySql() {
    return useLegacySql;
  }

  /** Returns the optional billing tier limit for this job. */
  public Integer getMaximumBillingTier() {
    return maximumBillingTier;
  }

  /** Returns the optional bytes billed limit for this job. */
  public Long getMaximumBytesBilled() {
    return maximumBytesBilled;
  }

  /**
   * [Experimental] Returns options allowing the schema of the destination table to be updated as a
   * side effect of the query job. Schema update options are supported in two cases: when
   * writeDisposition is WRITE_APPEND; when writeDisposition is WRITE_TRUNCATE and the destination
   * table is a partition of a table, specified by partition decorators. For normal tables,
   * WRITE_TRUNCATE will always overwrite the schema.
   */
  public List<SchemaUpdateOption> getSchemaUpdateOptions() {
    return schemaUpdateOptions;
  }

  /** Returns the time partitioning specification for the destination table. */
  public TimePartitioning getTimePartitioning() {
    return timePartitioning;
  }

  /** Returns the clustering specification for the destination table. */
  public Clustering getClustering() {
    return clustering;
  }

  /** Returns the timeout associated with this job */
  public Long getJobTimeoutMs() {
    return jobTimeoutMs;
  }

  /** Returns the labels associated with this job */
  public Map<String, String> getLabels() {
    return labels;
  }

  /** Returns the range partitioning specification for the table */
  public RangePartitioning getRangePartitioning() {
    return rangePartitioning;
  }

  /** Returns the connection properties for connection string with this job */
  public List<ConnectionProperty> getConnectionProperties() {
    return connectionProperties;
  }

  /**
   * This is only supported in the fast query path [Optional] The maximum number of rows of data to
   * return per page of results. Setting this flag to a small value such as 1000 and then paging
   * through results might improve reliability when the query result set is large. In addition to
   * this limit, responses are also limited to 10 MB. By default, there is no maximum row count, and
   * only the byte limit applies.
   *
   * @return value or {@code null} for none
   */
  public Long getMaxResults() {
    return maxResults;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("query", query)
        .add("positionalParameters", positionalParameters)
        .add("namedParameters", namedParameters)
        .add("destinationTable", destinationTable)
        .add("destinationEncryptionConfiguration", destinationEncryptionConfiguration)
        .add("defaultDataset", defaultDataset)
        .add("allowLargeResults", allowLargeResults)
        .add("flattenResults", flattenResults)
        .add("priority", priority)
        .add("tableDefinitions", tableDefinitions)
        .add("useQueryCache", useQueryCache)
        .add("userDefinedFunctions", userDefinedFunctions)
        .add("createDisposition", createDisposition)
        .add("writeDisposition", writeDisposition)
        .add("dryRun", dryRun)
        .add("useLegacySql", useLegacySql)
        .add("maximumBillingTier", maximumBillingTier)
        .add("maximumBytesBilled", maximumBytesBilled)
        .add("schemaUpdateOptions", schemaUpdateOptions)
        .add("timePartitioning", timePartitioning)
        .add("clustering", clustering)
        .add("jobTimeoutMs", jobTimeoutMs)
        .add("labels", labels)
        .add("rangePartitioning", rangePartitioning)
        .add("connectionProperties", connectionProperties);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof QueryJobConfiguration && baseEquals((QueryJobConfiguration) obj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        baseHashCode(),
        allowLargeResults,
        createDisposition,
        destinationTable,
        defaultDataset,
        flattenResults,
        priority,
        query,
        positionalParameters,
        namedParameters,
        tableDefinitions,
        useQueryCache,
        userDefinedFunctions,
        writeDisposition,
        dryRun,
        useLegacySql,
        maximumBillingTier,
        maximumBytesBilled,
        schemaUpdateOptions,
        timePartitioning,
        clustering,
        jobTimeoutMs,
        labels,
        rangePartitioning,
        connectionProperties);
  }

  @Override
  QueryJobConfiguration setProjectId(String projectId) {
    Builder builder = toBuilder();
    if (getDestinationTable() != null && isNullOrEmpty(getDestinationTable().getProject())) {
      builder.setDestinationTable(getDestinationTable().setProjectId(projectId));
    }
    if (getDefaultDataset() != null) {
      builder.setDefaultDataset(getDefaultDataset().setProjectId(projectId));
    }
    return builder.build();
  }

  @Override
  com.google.api.services.bigquery.model.JobConfiguration toPb() {
    com.google.api.services.bigquery.model.JobConfiguration configurationPb =
        new com.google.api.services.bigquery.model.JobConfiguration();
    JobConfigurationQuery queryConfigurationPb = new JobConfigurationQuery();
    queryConfigurationPb.setQuery(query);
    if (!positionalParameters.isEmpty()) {
      List<QueryParameter> queryParametersPb =
          Lists.transform(positionalParameters, POSITIONAL_PARAMETER_TO_PB_FUNCTION);
      queryConfigurationPb.setQueryParameters(queryParametersPb);
    } else if (!namedParameters.isEmpty()) {
      List<QueryParameter> queryParametersPb =
          Lists.transform(namedParameters.entrySet().asList(), NAMED_PARAMETER_TO_PB_FUNCTION);
      queryConfigurationPb.setQueryParameters(queryParametersPb);
    }
    configurationPb.setDryRun(dryRun());
    if (allowLargeResults != null) {
      queryConfigurationPb.setAllowLargeResults(allowLargeResults);
    }
    if (createDisposition != null) {
      queryConfigurationPb.setCreateDisposition(createDisposition.toString());
    }
    if (destinationTable != null) {
      queryConfigurationPb.setDestinationTable(destinationTable.toPb());
    }
    if (defaultDataset != null) {
      queryConfigurationPb.setDefaultDataset(defaultDataset.toPb());
    }
    if (flattenResults != null) {
      queryConfigurationPb.setFlattenResults(flattenResults);
    }
    if (priority != null) {
      queryConfigurationPb.setPriority(priority.toString());
    }
    if (tableDefinitions != null) {
      queryConfigurationPb.setTableDefinitions(
          Maps.transformValues(
              tableDefinitions, ExternalTableDefinition.TO_EXTERNAL_DATA_FUNCTION));
    }
    if (useQueryCache != null) {
      queryConfigurationPb.setUseQueryCache(useQueryCache);
    }
    if (userDefinedFunctions != null) {
      queryConfigurationPb.setUserDefinedFunctionResources(
          Lists.transform(userDefinedFunctions, UserDefinedFunction.TO_PB_FUNCTION));
    }
    if (writeDisposition != null) {
      queryConfigurationPb.setWriteDisposition(writeDisposition.toString());
    }
    if (useLegacySql != null) {
      queryConfigurationPb.setUseLegacySql(useLegacySql);
    }
    if (maximumBillingTier != null) {
      queryConfigurationPb.setMaximumBillingTier(maximumBillingTier);
    }
    if (maximumBytesBilled != null) {
      queryConfigurationPb.setMaximumBytesBilled(maximumBytesBilled);
    }
    if (schemaUpdateOptions != null) {
      ImmutableList.Builder<String> schemaUpdateOptionsBuilder = new ImmutableList.Builder<>();
      for (JobInfo.SchemaUpdateOption schemaUpdateOption : schemaUpdateOptions) {
        schemaUpdateOptionsBuilder.add(schemaUpdateOption.name());
      }
      queryConfigurationPb.setSchemaUpdateOptions(schemaUpdateOptionsBuilder.build());
    }
    if (destinationEncryptionConfiguration != null) {
      queryConfigurationPb.setDestinationEncryptionConfiguration(
          destinationEncryptionConfiguration.toPb());
    }
    if (timePartitioning != null) {
      queryConfigurationPb.setTimePartitioning(timePartitioning.toPb());
    }
    if (clustering != null) {
      queryConfigurationPb.setClustering(clustering.toPb());
    }
    if (jobTimeoutMs != null) {
      configurationPb.setJobTimeoutMs(jobTimeoutMs);
    }
    if (labels != null) {
      configurationPb.setLabels(labels);
    }
    if (rangePartitioning != null) {
      queryConfigurationPb.setRangePartitioning(rangePartitioning.toPb());
    }
    if (connectionProperties != null) {
      queryConfigurationPb.setConnectionProperties(
          Lists.transform(connectionProperties, ConnectionProperty.TO_PB_FUNCTION));
    }
    configurationPb.setQuery(queryConfigurationPb);
    return configurationPb;
  }

  /** Creates a builder for a BigQuery Query Job given the query to be run. */
  public static Builder newBuilder(String query) {
    checkArgument(!isNullOrEmpty(query), "Provided query is null or empty");
    return new Builder().setQuery(query);
  }

  /**
   * Returns a BigQuery Copy Job for the given the query to be run. Job's id is chosen by the
   * service.
   */
  public static QueryJobConfiguration of(String query) {
    return newBuilder(query).build();
  }

  @SuppressWarnings("unchecked")
  static QueryJobConfiguration fromPb(
      com.google.api.services.bigquery.model.JobConfiguration jobPb) {
    return new Builder(jobPb).build();
  }

  private static final Function<QueryParameter, QueryParameterValue>
      POSITIONAL_PARAMETER_FROM_PB_FUNCTION =
          new Function<QueryParameter, QueryParameterValue>() {
            @Override
            public QueryParameterValue apply(QueryParameter pb) {
              checkArgument(pb.getName() == null);
              return QueryParameterValue.fromPb(pb.getParameterValue(), pb.getParameterType());
            }
          };

  private static final Function<QueryParameterValue, QueryParameter>
      POSITIONAL_PARAMETER_TO_PB_FUNCTION =
          new Function<QueryParameterValue, QueryParameter>() {
            @Override
            public QueryParameter apply(QueryParameterValue value) {
              QueryParameter queryParameterPb = new QueryParameter();
              queryParameterPb.setParameterValue(value.toValuePb());
              queryParameterPb.setParameterType(value.toTypePb());
              return queryParameterPb;
            }
          };

  private static final Function<Map.Entry<String, QueryParameterValue>, QueryParameter>
      NAMED_PARAMETER_TO_PB_FUNCTION =
          new Function<Map.Entry<String, QueryParameterValue>, QueryParameter>() {
            @Override
            public QueryParameter apply(Map.Entry<String, QueryParameterValue> entry) {
              QueryParameter queryParameterPb = new QueryParameter();
              queryParameterPb.setName(entry.getKey());
              queryParameterPb.setParameterValue(entry.getValue().toValuePb());
              queryParameterPb.setParameterType(entry.getValue().toTypePb());
              return queryParameterPb;
            }
          };
}
