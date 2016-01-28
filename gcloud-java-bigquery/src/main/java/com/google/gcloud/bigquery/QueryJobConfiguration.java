/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.bigquery.model.JobConfigurationQuery;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gcloud.bigquery.JobInfo.CreateDisposition;
import com.google.gcloud.bigquery.JobInfo.WriteDisposition;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Google BigQuery Query Job configuration. A Query Job runs a query against BigQuery data. Query
 * job configurations have {@link JobConfiguration.Type#QUERY} type.
 */
public final class QueryJobConfiguration extends JobConfiguration {

  private static final long serialVersionUID = -1108948249081804890L;

  /**
   * Priority levels for a query. If not specified the priority is assumed to be
   * {@link Priority#INTERACTIVE}.
   */
  public enum Priority {
    /**
     * Query is executed as soon as possible and count towards the
     * <a href="https://cloud.google.com/bigquery/quota-policy">concurrent rate limit and the daily
     * rate limit</a>.
     */
    INTERACTIVE,

    /**
     * Query is queued and started as soon as idle resources are available, usually within a few
     * minutes. If the query hasn't started within 3 hours, its priority is changed to
     * {@link Priority#INTERACTIVE}.
     */
    BATCH
  }

  private final String query;
  private final TableId destinationTable;
  private final Map<String, ExternalDataConfiguration> tableDefinitions;
  private final List<UserDefinedFunction> userDefinedFunctions;
  private final CreateDisposition createDisposition;
  private final WriteDisposition writeDisposition;
  private final DatasetId defaultDataset;
  private final Priority priority;
  private final Boolean allowLargeResults;
  private final Boolean useQueryCache;
  private final Boolean flattenResults;
  private final Boolean dryRun;

  public static final class Builder extends JobConfiguration.Builder<QueryJobConfiguration, Builder> {

    private String query;
    private TableId destinationTable;
    private Map<String, ExternalDataConfiguration> tableDefinitions;
    private List<UserDefinedFunction> userDefinedFunctions;
    private CreateDisposition createDisposition;
    private WriteDisposition writeDisposition;
    private DatasetId defaultDataset;
    private Priority priority;
    private Boolean allowLargeResults;
    private Boolean useQueryCache;
    private Boolean flattenResults;
    private Boolean dryRun;

    private Builder() {
      super(Type.QUERY);
    }

    private Builder(QueryJobConfiguration jobConfiguration) {
      super(Type.QUERY);
      this.query = jobConfiguration.query;
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
    }

    private Builder(com.google.api.services.bigquery.model.JobConfiguration configurationPb) {
      super(Type.QUERY);
      JobConfigurationQuery queryConfigurationPb = configurationPb.getQuery();
      this.query = queryConfigurationPb.getQuery();
      allowLargeResults = queryConfigurationPb.getAllowLargeResults();
      useQueryCache = queryConfigurationPb.getUseQueryCache();
      flattenResults = queryConfigurationPb.getFlattenResults();
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
        tableDefinitions = Maps.transformValues(queryConfigurationPb.getTableDefinitions(),
            ExternalDataConfiguration.FROM_PB_FUNCTION);
      }
      if (queryConfigurationPb.getUserDefinedFunctionResources() != null) {
        userDefinedFunctions = Lists.transform(
            queryConfigurationPb.getUserDefinedFunctionResources(),
            UserDefinedFunction.FROM_PB_FUNCTION);
      }
      if (queryConfigurationPb.getCreateDisposition() != null) {
        createDisposition =
            CreateDisposition.valueOf(queryConfigurationPb.getCreateDisposition());
      }
      if (queryConfigurationPb.getWriteDisposition() != null) {
        writeDisposition =
            WriteDisposition.valueOf(queryConfigurationPb.getWriteDisposition());
      }
    }

    /**
     * Sets the BigQuery SQL query to execute.
     */
    public Builder query(String query) {
      this.query = query;
      return this;
    }

    /**
     * Sets the table where to put query results. If not provided a new table is created. This value
     * is required if {@link Builder#allowLargeResults(Boolean)} is set to {@code true}.
     */
    public Builder destinationTable(TableId destinationTable) {
      this.destinationTable = destinationTable;
      return this;
    }

    /**
     * Sets the external tables definitions. If querying external data sources outside of BigQuery,
     * this value describes the data format, location and other properties of the data
     * sources. By defining these properties, the data sources can be queried as if they were
     * standard BigQuery tables.
     */
    public Builder tableDefinitions(Map<String, ExternalDataConfiguration> tableDefinitions) {
      this.tableDefinitions = tableDefinitions != null ? Maps.newHashMap(tableDefinitions) : null;
      return this;
    }

    /**
     * Adds a new external table definition. If a definition already exists for {@code tableName}
     * it is updated.
     *
     * @param tableName name of the table
     * @param tableDefinition external data configuration for the table used by this query
     */
    public Builder addTableDefinition(String tableName, ExternalDataConfiguration tableDefinition) {
      if (this.tableDefinitions == null) {
        this.tableDefinitions = Maps.newHashMap();
      }
      this.tableDefinitions.put(checkNotNull(tableName), checkNotNull(tableDefinition));
      return this;
    }

    /**
     * Sets user defined function resources that can be used by this query. Function resources
     * can either be defined inline ({@link UserDefinedFunction#inline(String)}) or loaded from
     * a Google Cloud Storage URI ({@link UserDefinedFunction#fromUri(String)}.
     */
    public Builder userDefinedFunctions(List<UserDefinedFunction> userDefinedFunctions) {
      this.userDefinedFunctions =
          userDefinedFunctions != null ? ImmutableList.copyOf(userDefinedFunctions) : null;
      return this;
    }

    /**
     * Sets whether the job is allowed to create tables.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.query.createDisposition">
     *     Create Disposition</a>
     */
    public Builder createDisposition(CreateDisposition createDisposition) {
      this.createDisposition = createDisposition;
      return this;
    }

    /**
     * Sets the action that should occur if the destination table already exists.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.query.writeDisposition">
     *     Write Disposition</a>
     */
    public Builder writeDisposition(WriteDisposition writeDisposition) {
      this.writeDisposition = writeDisposition;
      return this;
    }

    /**
     * Sets the default dataset. This dataset is used for all unqualified table names used in the
     * query.
     */
    public Builder defaultDataset(DatasetId defaultDataset) {
      this.defaultDataset = defaultDataset;
      return this;
    }

    /**
     * Sets the default dataset. This dataset is used for all unqualified table names used in the
     * query.
     */
    public Builder defaultDataset(String defaultDataset) {
      return defaultDataset(DatasetId.of(defaultDataset));
    }

    /**
     * Sets a priority for the query. If not specified the priority is assumed to be
     * {@link Priority#INTERACTIVE}.
     */
    public Builder priority(Priority priority) {
      this.priority = priority;
      return this;
    }

    /**
     * Sets whether the job is enabled to create arbitrarily large results. If {@code true}
     * the query is allowed to create large results at a slight cost in performance. If {@code true}
     * {@link Builder#destinationTable(TableId)} must be provided.
     *
     * @see <a href="https://cloud.google.com/bigquery/querying-data#largequeryresults">
     *     Returning Large Query Results</a>
     */
    public Builder allowLargeResults(Boolean allowLargeResults) {
      this.allowLargeResults = allowLargeResults;
      return this;
    }

    /**
     * Sets whether to look for the result in the query cache. The query cache is a best-effort
     * cache that will be flushed whenever tables in the query are modified. Moreover, the query
     * cache is only available when {@link Builder#destinationTable(TableId)} is not set.
     *
     * @see <a href="https://cloud.google.com/bigquery/querying-data#querycaching">Query Caching</a>
     */
    public Builder useQueryCache(Boolean useQueryCache) {
      this.useQueryCache = useQueryCache;
      return this;
    }

    /**
     * Sets whether nested and repeated fields should be flattened. If set to {@code false}
     * {@link Builder#allowLargeResults(Boolean)} must be {@code true}. By default results are
     * flattened.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/data#flatten">Flatten</a>
     */
    public Builder flattenResults(Boolean flattenResults) {
      this.flattenResults = flattenResults;
      return this;
    }

    /**
     * Sets whether the job has to be dry run or not. If set, the job is not executed. A valid query
     * will return a mostly empty response with some processing statistics, while an invalid query
     * will return the same error it would if it wasn't a dry run.
     */
    public Builder dryRun(Boolean dryRun) {
      this.dryRun = dryRun;
      return this;
    }

    public QueryJobConfiguration build() {
      return new QueryJobConfiguration(this);
    }
  }

  private QueryJobConfiguration(Builder builder) {
    super(builder);
    this.query = checkNotNull(builder.query);
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
  }

  /**
   * Returns whether the job is enabled to create arbitrarily large results. If {@code true}
   * the query is allowed to create large results at a slight cost in performance.
   * the query is allowed to create large results at a slight cost in performance.
   *
   * @see <a href="https://cloud.google.com/bigquery/querying-data#largequeryresults">
   *     Returning Large Query Results</a>
   */
  public Boolean allowLargeResults() {
    return allowLargeResults;
  }

  /**
   * Returns whether the job is allowed to create new tables.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.query.createDisposition">
   *     Create Disposition</a>
   */
  public CreateDisposition createDisposition() {
    return createDisposition;
  }

  /**
   * Returns the default dataset. This dataset is used for all unqualified table names used in the
   * query.
   */
  public DatasetId defaultDataset() {
    return defaultDataset;
  }

  /**
   * Returns the table where to put query results. If not provided a new table is created. This
   * value is required if {@link #allowLargeResults()} is {@code true}.
   */
  public TableId destinationTable() {
    return destinationTable;
  }

  /**
   * Returns whether nested and repeated fields should be flattened. If set to {@code false}
   * {@link Builder#allowLargeResults(Boolean)} must be {@code true}.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/data#flatten">Flatten</a>
   */
  public Boolean flattenResults() {
    return flattenResults;
  }

  /**
   * Returns the query priority.
   */
  public Priority priority() {
    return priority;
  }

  /**
   * Returns the Google BigQuery SQL query.
   */
  public String query() {
    return query;
  }

  /**
   * Returns the external tables definitions. If querying external data sources outside of BigQuery,
   * this value describes the data format, location and other properties of the data
   * sources. By defining these properties, the data sources can be queried as if they were
   * standard BigQuery tables.
   */
  public Map<String, ExternalDataConfiguration> tableDefinitions() {
    return tableDefinitions;
  }

  /**
   * Returns whether to look for the result in the query cache. The query cache is a best-effort
   * cache that will be flushed whenever tables in the query are modified. Moreover, the query
   * cache is only available when {@link Builder#destinationTable(TableId)} is not set.
   *
   * @see <a href="https://cloud.google.com/bigquery/querying-data#querycaching">Query Caching</a>
   */
  public Boolean useQueryCache() {
    return useQueryCache;
  }

  /**
   * Returns user defined function resources that can be used by this query. Function resources
   * can either be defined inline ({@link UserDefinedFunction.Type#INLINE}) or loaded from
   * a Google Cloud Storage URI ({@link UserDefinedFunction.Type#FROM_URI}.
   */
  public List<UserDefinedFunction> userDefinedFunctions() {
    return userDefinedFunctions;
  }

  /**
   * Returns the action that should occur if the destination table already exists.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.query.writeDisposition">
   *     Write Disposition</a>
   */
  public WriteDisposition writeDisposition() {
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

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  protected ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("query", query)
        .add("destinationTable", destinationTable)
        .add("defaultDataset", defaultDataset)
        .add("allowLargeResults", allowLargeResults)
        .add("flattenResults", flattenResults)
        .add("priority", priority)
        .add("tableDefinitions", tableDefinitions)
        .add("userQueryCache", useQueryCache)
        .add("userDefinedFunctions", userDefinedFunctions)
        .add("createDisposition", createDisposition)
        .add("writeDisposition", writeDisposition)
        .add("dryRun", dryRun);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof QueryJobConfiguration && baseEquals((QueryJobConfiguration) obj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), allowLargeResults, createDisposition, destinationTable,
        defaultDataset, flattenResults, priority, query, tableDefinitions, useQueryCache,
        userDefinedFunctions, writeDisposition, dryRun);
  }

  @Override
  QueryJobConfiguration setProjectId(String projectId) {
    Builder builder = toBuilder();
    if (destinationTable() != null) {
      builder.destinationTable(destinationTable().setProjectId(projectId));
    }
    if (defaultDataset() != null) {
      builder.defaultDataset(defaultDataset().setProjectId(projectId));
    }
    return builder.build();
  }

  com.google.api.services.bigquery.model.JobConfiguration toPb() {
    com.google.api.services.bigquery.model.JobConfiguration configurationPb =
        new com.google.api.services.bigquery.model.JobConfiguration();
    JobConfigurationQuery queryConfigurationPb = new JobConfigurationQuery();
    queryConfigurationPb.setQuery(query);
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
          Maps.transformValues(tableDefinitions, ExternalDataConfiguration.TO_PB_FUNCTION));
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
    return configurationPb.setQuery(queryConfigurationPb);
  }

  /**
   * Creates a builder for a BigQuery Query Job given the query to be run.
   */
  public static Builder builder(String query) {
    return new Builder().query(query);
  }

  /**
   * Returns a BigQuery Copy Job for the given the query to be run. Job's id is chosen by the
   * service.
   */
  public static QueryJobConfiguration of(String query) {
    return builder(query).build();
  }

  @SuppressWarnings("unchecked")
  static QueryJobConfiguration fromPb(
      com.google.api.services.bigquery.model.JobConfiguration jobPb) {
    return new Builder(jobPb).build();
  }
}
