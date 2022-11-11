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

import com.google.api.services.bigquery.model.QueryParameter;
import com.google.api.services.bigquery.model.QueryRequest;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
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

  QueryRequestInfo(QueryJobConfiguration config) {
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
  }

  boolean isFastQuerySupported(JobId jobId) {
    // Fast query path is not possible if job is specified in the JobID object
    // Respect Job field value in JobId specified by user.
    // Specifying it will force the query to take the slower path.
    if (jobId != null) {
      if (jobId.getJob() != null) {
        return false;
      }
    }
    return config.getClustering() == null
        && config.getCreateDisposition() == null
        && config.getDestinationEncryptionConfiguration() == null
        && config.getDestinationTable() == null
        && config.getJobTimeoutMs() == null
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
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
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
        useLegacySql);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(QueryRequestInfo.class)
            && java.util.Objects.equals(toPb(), ((QueryRequestInfo) obj).toPb());
  }
}
