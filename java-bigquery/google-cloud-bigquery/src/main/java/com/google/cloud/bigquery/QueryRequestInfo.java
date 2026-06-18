/*
 * Copyright 2020 Google LLC
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

import com.google.api.services.bigquery.model.DataFormatOptions;
import com.google.api.services.bigquery.model.QueryParameter;
import com.google.api.services.bigquery.model.QueryRequest;
import com.google.cloud.bigquery.QueryJobConfiguration.JobCreationMode;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

final class QueryRequestInfo {

  private QueryJobConfiguration config;
  private final List<ConnectionProperty> connectionProperties;
  private final DatasetId defaultDataset;
  private final Boolean dryRun;
  private final Map<String, String> labels;
  private final Long maximumBytesBilled;
  private final Long maxResults;
  private final String query;
  private final List<QueryParameter> queryParameters;
  private final String requestId;
  private final Boolean createSession;
  private final Boolean useQueryCache;
  private final Boolean useLegacySql;
  private final JobCreationMode jobCreationMode;
  private final DataFormatOptions formatOptions;
  private final String reservation;
  private final Long jobTimeoutMs;

  QueryRequestInfo(
      QueryJobConfiguration config, com.google.cloud.bigquery.DataFormatOptions dataFormatOptions) {
    this.config = config;
    this.connectionProperties = config.getConnectionProperties();
    this.defaultDataset = config.getDefaultDataset();
    this.dryRun = config.dryRun();
    this.labels = config.getLabels();
    this.maximumBytesBilled = config.getMaximumBytesBilled();
    this.maxResults = config.getMaxResults();
    this.query = config.getQuery();
    this.queryParameters = config.toPb().getQuery().getQueryParameters();
    this.requestId = UUID.randomUUID().toString();
    this.createSession = config.createSession();
    this.useLegacySql = config.useLegacySql();
    this.useQueryCache = config.useQueryCache();
    this.jobCreationMode = config.getJobCreationMode();
    this.formatOptions = dataFormatOptions.toPb();
    this.reservation = config.getReservation();
    this.jobTimeoutMs = config.getJobTimeoutMs();
  }

  /**
   * Determines if the query can be executed via the "fast query" path (jobs.query API) instead of
   * the "slow path" (jobs.insert API followed by jobs.getQueryResults).
   *
   * <p>The fast query path is preferred because it completes in a single RPC, significantly
   * reducing end-to-end latency for small queries.
   *
   * <p>However, the jobs.query API does not support all configuration options available in
   * jobs.insert (e.g., destination table, clustering, time partitioning). This method checks the
   * QueryJobConfiguration for any unsupported options. If any are present, we must fall back to the
   * jobs.insert path.
   */
  boolean isFastQuerySupported() {
    return config.getClustering() == null
        && config.getCreateDisposition() == null
        && config.getDestinationEncryptionConfiguration() == null
        && config.getDestinationTable() == null
        && config.getMaximumBillingTier() == null
        && config.getPriority() == null
        && config.getRangePartitioning() == null
        && config.getSchemaUpdateOptions() == null
        && config.getTableDefinitions() == null
        && config.getTimePartitioning() == null
        && config.getUserDefinedFunctions() == null
        && config.getWriteDisposition() == null;
  }

  QueryRequest toPb() {
    QueryRequest request = new QueryRequest();
    if (connectionProperties != null) {
      request.setConnectionProperties(
          Lists.transform(connectionProperties, ConnectionProperty.TO_PB_FUNCTION));
    }
    if (defaultDataset != null) {
      request.setDefaultDataset(defaultDataset.toPb());
    }
    if (dryRun != null) {
      request.setDryRun(dryRun);
    }
    if (labels != null) {
      request.setLabels(labels);
    }
    if (maximumBytesBilled != null) {
      request.setMaximumBytesBilled(maximumBytesBilled);
    }
    if (maxResults != null) {
      request.setMaxResults(maxResults);
    }
    request.setQuery(query);
    request.setRequestId(requestId);
    if (queryParameters != null) {
      request.setQueryParameters(queryParameters);
    }
    if (createSession != null) {
      request.setCreateSession(createSession);
    }
    if (useLegacySql != null) {
      request.setUseLegacySql(useLegacySql);
    }
    if (useQueryCache != null) {
      request.setUseQueryCache(useQueryCache);
    }
    if (jobCreationMode != null) {
      request.setJobCreationMode(jobCreationMode.toString());
    }
    if (formatOptions != null) {
      request.setFormatOptions(formatOptions);
    }
    if (reservation != null) {
      request.setReservation(reservation);
    }
    if (jobTimeoutMs != null) {
      request.setJobTimeoutMs(jobTimeoutMs);
    }
    return request;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("connectionProperties", connectionProperties)
        .add("defaultDataset", defaultDataset)
        .add("dryRun", dryRun)
        .add("labels", labels)
        .add("maximumBytesBilled", maximumBytesBilled)
        .add("maxResults", maxResults)
        .add("query", query)
        .add("requestId", requestId)
        .add("queryParameters", queryParameters)
        .add("createSession", createSession)
        .add("useQueryCache", useQueryCache)
        .add("useLegacySql", useLegacySql)
        .add("jobCreationMode", jobCreationMode)
        .add("formatOptions", formatOptions.getUseInt64Timestamp())
        .add("reservation", reservation)
        .add("jobTimeoutMs", jobTimeoutMs)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        connectionProperties,
        defaultDataset,
        dryRun,
        labels,
        maximumBytesBilled,
        maxResults,
        query,
        queryParameters,
        requestId,
        createSession,
        useQueryCache,
        useLegacySql,
        jobCreationMode,
        formatOptions,
        reservation,
        jobTimeoutMs);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(QueryRequestInfo.class)) {
      return false;
    }
    QueryRequestInfo other = (QueryRequestInfo) obj;
    return Objects.equals(connectionProperties, other.connectionProperties)
        && Objects.equals(defaultDataset, other.defaultDataset)
        && Objects.equals(dryRun, other.dryRun)
        && Objects.equals(labels, other.labels)
        && Objects.equals(maximumBytesBilled, other.maximumBytesBilled)
        && Objects.equals(maxResults, other.maxResults)
        && Objects.equals(query, other.query)
        && Objects.equals(queryParameters, other.queryParameters)
        && Objects.equals(requestId, other.requestId)
        && Objects.equals(createSession, other.createSession)
        && Objects.equals(useQueryCache, other.useQueryCache)
        && Objects.equals(useLegacySql, other.useLegacySql)
        && Objects.equals(jobCreationMode, other.jobCreationMode)
        && Objects.equals(formatOptions, other.formatOptions)
        && Objects.equals(reservation, other.reservation)
        && Objects.equals(jobTimeoutMs, other.jobTimeoutMs);
  }
}
