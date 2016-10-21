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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * Google Cloud BigQuery Query Request. This class can be used to run a BigQuery SQL query and
 * return results if the query completes within a specified timeout. The query results are saved to
 * a temporary table that is deleted approximately 24 hours after the query is run. The query is run
 * through a BigQuery Job whose identity can be accessed via {@link QueryResponse#getJobId()}. If
 * the query does not complete within the provided {@link Builder#setMaxWaitTime(Long)}, the
 * response returned by {@link BigQuery#query(QueryRequest)} will have
 * {@link QueryResponse#jobCompleted()} set to {@code false} and {@link QueryResponse#getResult()}
 * set to {@code null}. To obtain query results you can use
 * {@link BigQuery#getQueryResults(JobId, BigQuery.QueryResultsOption...)} until
 * {@link QueryResponse#jobCompleted()} returns {@code true}.
 *
 * <p>Example usage of a query request:
 * <pre> {@code
 * // Substitute "field", "table" and "dataset" with real field, table and dataset identifiers
 * QueryRequest request = QueryRequest.newBuilder("SELECT field FROM table")
 *     .setDefaultDataset(DatasetId.of("dataset"))
 *     .setMaxWaitTime(60000L)
 *     .setPageSize(1000L)
 *     .build();
 * QueryResponse response = bigquery.query(request);
 * while (!response.jobCompleted()) {
 *   Thread.sleep(1000);
 *   response = bigquery.getQueryResults(response.getJobId());
 * }
 * List<BigQueryError> executionErrors = response.getExecutionErrors();
 * // look for errors in executionErrors
 * QueryResult result = response.getResult();
 * Iterator<List<FieldValue>> rowIterator = result.iterateAll();
 * while(rowIterator.hasNext()) {
 *   List<FieldValue> row = rowIterator.next();
 *   // do something with row
 * }
 * }</pre>
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs/query">Query</a>
 * @see <a href="https://cloud.google.com/bigquery/query-reference">Query Reference</a>
 */
public final class QueryRequest implements Serializable {

  private static final long serialVersionUID = -8727328332415880852L;

  private final String query;
  private final Long pageSize;
  private final DatasetId defaultDataset;
  private final Long maxWaitTime;
  private final Boolean dryRun;
  private final Boolean useQueryCache;
  private final Boolean useLegacySql;

  public static final class Builder {

    private String query;
    private Long pageSize;
    private DatasetId defaultDataset;
    private Long maxWaitTime;
    private Boolean dryRun;
    private Boolean useQueryCache;
    private Boolean useLegacySql;

    private Builder() {}

    /**
     * Sets the BigQuery query to be executed.
     */
    @Deprecated
    public Builder query(String query) {
      return setQuery(query);
    }

    /**
     * Sets the BigQuery query to be executed.
     */
    public Builder setQuery(String query) {
      this.query = checkNotNull(query);
      return this;
    }

    /**
     * Sets the maximum number of rows of data to return per page of results. Setting this flag to a
     * small value such as 1000 and then paging through results might improve reliability when the
     * query result set is large. In addition to this limit, responses are also limited to 10 MB.
     * By default, there is no maximum row count, and only the byte limit applies.
     */
    @Deprecated
    public Builder pageSize(Long pageSize) {
      return setPageSize(pageSize);
    }

    /**
     * Sets the maximum number of rows of data to return per page of results. Setting this flag to a
     * small value such as 1000 and then paging through results might improve reliability when the
     * query result set is large. In addition to this limit, responses are also limited to 10 MB.
     * By default, there is no maximum row count, and only the byte limit applies.
     */
    public Builder setPageSize(Long pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    /**
     * Sets the default dataset to assume for any unqualified table names in the query.
     */
    @Deprecated
    public Builder defaultDataset(DatasetId defaultDataset) {
      return setDefaultDataset(defaultDataset);
    }

    /**
     * Sets the default dataset to assume for any unqualified table names in the query.
     */
    public Builder setDefaultDataset(DatasetId defaultDataset) {
      this.defaultDataset = defaultDataset;
      return this;
    }

    /**
     * Sets the default dataset to assume for any unqualified table names in the query.
     */
    @Deprecated
    public Builder defaultDataset(String defaultDataset) {
      return setDefaultDataset(DatasetId.of(defaultDataset));
    }

    /**
     * Sets the default dataset to assume for any unqualified table names in the query.
     */
    public Builder setDefaultDataset(String defaultDataset) {
      return setDefaultDataset(DatasetId.of(defaultDataset));
    }

    /**
     * Sets how long to wait for the query to complete, in milliseconds, before the request times
     * out and returns. Note that this is only a timeout for the request, not the query. If the
     * query takes longer to run than the timeout value, the call returns without any results and
     * with the {@link QueryResponse#jobCompleted()} set to {@code false}. If not set, a wait time
     * of 10000 milliseconds (10 seconds) is used.
     */
    @Deprecated
    public Builder maxWaitTime(Long maxWaitTime) {
      return setMaxWaitTime(maxWaitTime);
    }

    /**
     * Sets how long to wait for the query to complete, in milliseconds, before the request times
     * out and returns. Note that this is only a timeout for the request, not the query. If the
     * query takes longer to run than the timeout value, the call returns without any results and
     * with the {@link QueryResponse#jobCompleted()} set to {@code false}. If not set, a wait time
     * of 10000 milliseconds (10 seconds) is used.
     */
    public Builder setMaxWaitTime(Long maxWaitTime) {
      this.maxWaitTime = maxWaitTime;
      return this;
    }

    /**
     * Sets whether the query has to be dry run or not. If set, the query is not executed. If the
     * query is valid statistics are returned on how many bytes would be processed. If the query is
     * invalid an error is returned. If not set the query is executed.
     */
    @Deprecated
    public Builder dryRun(Boolean dryRun) {
      return setDryRun(dryRun);
    }

    /**
     * Sets whether the query has to be dry run or not. If set, the query is not executed. If the
     * query is valid statistics are returned on how many bytes would be processed. If the query is
     * invalid an error is returned. If not set the query is executed.
     */
    public Builder setDryRun(Boolean dryRun) {
      this.dryRun = dryRun;
      return this;
    }

    /**
     * Sets whether to look for the result in the query cache. The query cache is a best-effort
     * cache that will be flushed whenever tables in the query are modified. If not specified the
     * query cache is used.
     *
     * @see <a href="https://cloud.google.com/bigquery/querying-data#querycaching">Query Caching</a>
     */
    @Deprecated
    public Builder useQueryCache(Boolean useQueryCache) {
      return setUseQueryCache(useQueryCache);
    }

    /**
     * Sets whether to look for the result in the query cache. The query cache is a best-effort
     * cache that will be flushed whenever tables in the query are modified. If not specified the
     * query cache is used.
     *
     * @see <a href="https://cloud.google.com/bigquery/querying-data#querycaching">Query Caching</a>
     */
    public Builder setUseQueryCache(Boolean useQueryCache) {
      this.useQueryCache = useQueryCache;
      return this;
    }

    /**
     * Sets whether to use BigQuery's legacy SQL dialect for this query. If set to {@code false},
     * the query will use BigQuery's <a href="https://cloud.google.com/bigquery/sql-reference/">
     * Standard SQL</a>. If not set, legacy SQL dialect is used. This property is experimental and
     * might be subject to change.
     */
    @Deprecated
    public Builder useLegacySql(Boolean useLegacySql) {
      return setUseLegacySql(useLegacySql);
    }

    /**
     * Sets whether to use BigQuery's legacy SQL dialect for this query. If set to {@code false},
     * the query will use BigQuery's <a href="https://cloud.google.com/bigquery/sql-reference/">
     * Standard SQL</a>. If not set, legacy SQL dialect is used. This property is experimental and
     * might be subject to change.
     */
    public Builder setUseLegacySql(Boolean useLegacySql) {
      this.useLegacySql = useLegacySql;
      return this;
    }

    public QueryRequest build() {
      return new QueryRequest(this);
    }
  }

  private QueryRequest(Builder builder) {
    query = builder.query;
    pageSize = builder.pageSize;
    defaultDataset = builder.defaultDataset;
    maxWaitTime = builder.maxWaitTime;
    dryRun = builder.dryRun;
    useQueryCache = builder.useQueryCache;
    useLegacySql = builder.useLegacySql;
  }

  /**
   * Sets the BigQuery query to be executed.
   */
  @Deprecated
  public String query() {
    return getQuery();
  }

  /**
   * Sets the BigQuery query to be executed.
   */
  public String getQuery() {
    return query;
  }

  /**
   * Returns the maximum number of rows of data to return per page of results.
   */
  @Deprecated
  public Long pageSize() {
    return getPageSize();
  }

  /**
   * Returns the maximum number of rows of data to return per page of results.
   */
  public Long getPageSize() {
    return pageSize;
  }

  /**
   * Returns the default dataset to assume for any unqualified table names in the query.
   */
  @Deprecated
  public DatasetId defaultDataset() {
    return getDefaultDataset();
  }

  /**
   * Returns the default dataset to assume for any unqualified table names in the query.
   */
  public DatasetId getDefaultDataset() {
    return defaultDataset;
  }

  /**
   * Returns how long to wait for the query to complete, in milliseconds, before the request times
   * out and returns. Note that this is only a timeout for the request, not the query. If the
   * query takes longer to run than the timeout value, the call returns without any results and
   * with the {@link QueryResponse#jobCompleted()} set to {@code false}. You can call
   * {@link BigQuery#getQueryResults(JobId, BigQuery.QueryResultsOption...)} to wait for the query
   * to complete and read the results. If not set, a wait time of 10000 milliseconds (10 seconds)
   * is used.
   */
  @Deprecated
  public Long maxWaitTime() {
    return getMaxWaitTime();
  }

  /**
   * Returns how long to wait for the query to complete, in milliseconds, before the request times
   * out and returns. Note that this is only a timeout for the request, not the query. If the
   * query takes longer to run than the timeout value, the call returns without any results and
   * with the {@link QueryResponse#jobCompleted()} set to {@code false}. You can call
   * {@link BigQuery#getQueryResults(JobId, BigQuery.QueryResultsOption...)} to wait for the query
   * to complete and read the results. If not set, a wait time of 10000 milliseconds (10 seconds)
   * is used.
   */
  public Long getMaxWaitTime() {
    return maxWaitTime;
  }

  /**
   * Returns whether the query has to be dry run or not. If set, the query is not executed. If the
   * query is valid statistics are returned on how many bytes would be processed. If the query is
   * invalid an error is returned. If not set the query is executed.
   */
  public Boolean dryRun() {
    return dryRun;
  }

  /**
   * Returns whether to look for the result in the query cache. The query cache is a best-effort
   * cache that will be flushed whenever tables in the query are modified. If not specified the
   * query cache is used.
   *
   * @see <a href="https://cloud.google.com/bigquery/querying-data#querycaching">Query Caching</a>
   */
  public Boolean useQueryCache() {
    return useQueryCache;
  }

  /**
   * Returns whether to use BigQuery's legacy SQL dialect for this query. If set to {@code false},
   * the query will use BigQuery's <a href="https://cloud.google.com/bigquery/sql-reference/">
   * Standard SQL</a>. If not set, legacy SQL dialect is used. This property is experimental and
   * might be subject to change.
   */
  public Boolean useLegacySql() {
    return useLegacySql;
  }

  /**
   * Returns a builder for the {@code QueryRequest} object.
   */
  public Builder toBuilder() {
    return new Builder()
        .setQuery(query)
        .setPageSize(pageSize)
        .setDefaultDataset(defaultDataset)
        .setMaxWaitTime(maxWaitTime)
        .setDryRun(dryRun)
        .setUseQueryCache(useQueryCache)
        .setUseLegacySql(useLegacySql);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("query", query)
        .add("pageSize", pageSize)
        .add("defaultDataset", defaultDataset)
        .add("maxWaitTime", maxWaitTime)
        .add("dryRun", dryRun)
        .add("useQueryCache", useQueryCache)
        .add("useLegacySql", useLegacySql)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(query, pageSize, defaultDataset, maxWaitTime, dryRun, useQueryCache,
        useLegacySql);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof QueryRequest
        && Objects.equals(toPb(), ((QueryRequest) obj).toPb());
  }

  QueryRequest setProjectId(String projectId) {
    Builder builder = toBuilder();
    if (getDefaultDataset() != null) {
      builder.setDefaultDataset(getDefaultDataset().setProjectId(projectId));
    }
    return builder.build();
  }

  com.google.api.services.bigquery.model.QueryRequest toPb() {
    com.google.api.services.bigquery.model.QueryRequest queryRequestPb =
        new com.google.api.services.bigquery.model.QueryRequest().setQuery(query);
    if (pageSize != null) {
      queryRequestPb.setMaxResults(pageSize);
    }
    if (defaultDataset != null) {
      queryRequestPb.setDefaultDataset(defaultDataset.toPb());
    }
    if (maxWaitTime != null) {
      queryRequestPb.setTimeoutMs(maxWaitTime);
    }
    if (dryRun != null) {
      queryRequestPb.setDryRun(dryRun);
    }
    if (useQueryCache != null) {
      queryRequestPb.setUseQueryCache(useQueryCache);
    }
    if (useLegacySql != null) {
      queryRequestPb.setUseLegacySql(useLegacySql);
    }
    return queryRequestPb;
  }

  /**
   * Creates a builder for a {@code QueryRequest} given the BigQuery SQL query to be executed.
   */
  @Deprecated
  public static Builder builder(String query) {
    return newBuilder(query);
  }

  /**
   * Creates a builder for a {@code QueryRequest} given the BigQuery SQL query to be executed.
   */
  public static Builder newBuilder(String query) {
    return new Builder().setQuery(query);
  }

  /**
   * Creates a {@code QueryRequest} object given the BigQuery SQL query to be executed.
   */
  public static QueryRequest of(String query) {
    return new Builder().setQuery(query).build();
  }

  static QueryRequest fromPb(com.google.api.services.bigquery.model.QueryRequest queryRequestPb) {
    Builder builder = newBuilder(queryRequestPb.getQuery());
    if (queryRequestPb.getMaxResults() != null) {
      builder.setPageSize(queryRequestPb.getMaxResults());
    }
    if (queryRequestPb.getDefaultDataset() != null) {
      builder.setDefaultDataset(DatasetId.fromPb(queryRequestPb.getDefaultDataset()));
    }
    if (queryRequestPb.getTimeoutMs() != null) {
      builder.setMaxWaitTime(queryRequestPb.getTimeoutMs());
    }
    if (queryRequestPb.getDryRun() != null) {
      builder.setDryRun(queryRequestPb.getDryRun());
    }
    if (queryRequestPb.getUseQueryCache() != null) {
      builder.setUseQueryCache(queryRequestPb.getUseQueryCache());
    }
    if (queryRequestPb.getUseLegacySql() != null) {
      builder.setUseLegacySql(queryRequestPb.getUseLegacySql());
    }
    return builder.build();
  }
}
