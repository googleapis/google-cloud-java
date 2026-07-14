/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore;

import com.google.api.core.BetaApi;
import com.google.cloud.datastore.Query.ResultType;
import com.google.cloud.datastore.models.ExplainMetrics;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.datastore.v1.EntityResult;
import com.google.datastore.v1.ExplainOptions;
import com.google.datastore.v1.PartitionId;
import com.google.datastore.v1.QueryResultBatch.MoreResultsType;
import com.google.datastore.v1.ReadOptions;
import com.google.datastore.v1.RequestOptions;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import com.google.protobuf.ByteString;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;

class QueryResultsImpl<T> extends AbstractIterator<T> implements QueryResults<T> {

  private final DatastoreImpl datastore;
  private final Optional<ReadOptions> readOptionsPb;
  private final PartitionId partitionIdPb;
  private final ResultType<T> queryResultType;
  private RecordQuery<T> query;
  private ResultType<?> actualResultType;
  private RunQueryResponse runQueryResponsePb;
  private com.google.datastore.v1.Query mostRecentQueryPb;
  private boolean lastBatch;
  private Iterator<EntityResult> entityResultPbIter;
  private ByteString cursor;
  private MoreResultsType moreResults;
  private final ExplainOptions explainOptions;
  private ExplainMetrics explainMetrics;
  private final RequestOptions requestOptions;

  private QueryResultsImpl(Builder<T> builder) {
    this.datastore = builder.datastore;
    this.readOptionsPb = builder.readOptionsPb;
    this.query = builder.query;
    queryResultType = builder.query.getType();
    this.explainOptions = builder.explainOptions;
    this.requestOptions = builder.requestOptions;
    PartitionId.Builder pbBuilder = PartitionId.newBuilder();
    pbBuilder.setProjectId(datastore.getOptions().getProjectId());
    pbBuilder.setDatabaseId(datastore.getOptions().getDatabaseId());
    if (builder.namespace != null) {
      pbBuilder.setNamespaceId(builder.namespace);
    } else if (datastore.getOptions().getNamespace() != null) {
      pbBuilder.setNamespaceId(datastore.getOptions().getNamespace());
    }
    partitionIdPb = pbBuilder.build();
    sendRequest();
    if (runQueryResponsePb.getBatch().getSkippedResults() > 0) {
      cursor = runQueryResponsePb.getBatch().getSkippedCursor();
    } else {
      cursor = mostRecentQueryPb.getStartCursor();
    }
  }

  static class Builder<T> {
    private DatastoreImpl datastore;
    private Optional<ReadOptions> readOptionsPb = Optional.empty();
    private RecordQuery<T> query;
    private String namespace;
    private ExplainOptions explainOptions;
    private RequestOptions requestOptions;

    Builder<T> setDatastore(DatastoreImpl datastore) {
      this.datastore = datastore;
      return this;
    }

    Builder<T> setReadOptionsPb(Optional<ReadOptions> readOptionsPb) {
      this.readOptionsPb = readOptionsPb;
      return this;
    }

    Builder<T> setQuery(RecordQuery<T> query) {
      this.query = query;
      return this;
    }

    Builder<T> setNamespace(String namespace) {
      this.namespace = namespace;
      return this;
    }

    Builder<T> setExplainOptions(ExplainOptions explainOptions) {
      this.explainOptions = explainOptions;
      return this;
    }

    Builder<T> setRequestOptions(RequestOptions requestOptions) {
      this.requestOptions = requestOptions;
      return this;
    }

    QueryResultsImpl<T> build() {
      Preconditions.checkNotNull(datastore, "datastore cannot be null");
      Preconditions.checkNotNull(query, "query cannot be null");
      return new QueryResultsImpl<>(this);
    }
  }

  private void sendRequest() {
    RunQueryRequest.Builder requestPb = RunQueryRequest.newBuilder();
    readOptionsPb.ifPresent(requestPb::setReadOptions);
    requestPb.setPartitionId(partitionIdPb);
    requestPb.setProjectId(datastore.getOptions().getProjectId());
    requestPb.setDatabaseId(datastore.getOptions().getDatabaseId());
    if (explainOptions != null) {
      requestPb.setExplainOptions(explainOptions);
    }
    if (requestOptions != null || !datastore.getOptions().getRequestTags().isEmpty()) {
      requestPb.setRequestOptions(
          RequestOptionsHelper.createRequestOptions(datastore.getOptions(), requestOptions));
    }
    query.populatePb(requestPb);
    runQueryResponsePb = datastore.runQuery(requestPb.build());
    mostRecentQueryPb = requestPb.getQuery();
    moreResults = runQueryResponsePb.getBatch().getMoreResults();
    lastBatch = moreResults != MoreResultsType.NOT_FINISHED;
    entityResultPbIter = runQueryResponsePb.getBatch().getEntityResultsList().iterator();
    actualResultType = ResultType.fromPb(runQueryResponsePb.getBatch().getEntityResultType());
    if (Objects.equals(queryResultType, ResultType.PROJECTION_ENTITY)) {
      // projection entity can represent all type of results
      actualResultType = ResultType.PROJECTION_ENTITY;
    }
    boolean isExplain =
        explainOptions != null
            && actualResultType.getQueryType() == null
            && !explainOptions.getAnalyze();
    Preconditions.checkState(
        queryResultType.isAssignableFrom(actualResultType) || isExplain,
        "Unexpected result type or explain options set %s vs %s, explain options = false",
        actualResultType,
        queryResultType);
    if (runQueryResponsePb.hasExplainMetrics()) {
      this.explainMetrics = new ExplainMetrics(runQueryResponsePb.getExplainMetrics());
    }
  }

  @Override
  protected T computeNext() {
    while (!entityResultPbIter.hasNext() && !lastBatch) {
      query = query.nextQuery(runQueryResponsePb);
      sendRequest();
    }
    if (!entityResultPbIter.hasNext()) {
      cursor = runQueryResponsePb.getBatch().getEndCursor();
      return endOfData();
    }
    EntityResult entityResultPb = entityResultPbIter.next();
    cursor = entityResultPb.getCursor();
    // Safe because we verify actualResultType compatibility in sendRequest().
    @SuppressWarnings("unchecked")
    T result = (T) actualResultType.convert(entityResultPb.getEntity());
    return result;
  }

  @Override
  public Class<?> getResultClass() {
    return actualResultType.resultClass();
  }

  @Override
  public Cursor getCursorAfter() {
    return new Cursor(cursor);
  }

  @Override
  public int getSkippedResults() {
    return runQueryResponsePb.getBatch().getSkippedResults();
  }

  @Override
  public MoreResultsType getMoreResults() {
    return moreResults;
  }

  @Override
  @BetaApi
  public Optional<ExplainMetrics> getExplainMetrics() {
    return Optional.ofNullable(this.explainMetrics);
  }
}
