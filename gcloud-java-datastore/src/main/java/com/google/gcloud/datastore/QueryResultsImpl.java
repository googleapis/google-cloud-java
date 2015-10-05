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

package com.google.gcloud.datastore;

import com.google.datastore.v1beta3.QueryResultBatch.MoreResultsType;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.gcloud.datastore.Query.ResultType;
import com.google.protobuf.ByteString;

import java.util.Iterator;
import java.util.Objects;

class QueryResultsImpl<T> extends AbstractIterator<T> implements QueryResults<T> {

  private final DatastoreImpl datastore;
  private final com.google.datastore.v1beta3.ReadOptions readOptionsPb;
  private final com.google.datastore.v1beta3.PartitionId partitionIdPb;
  private final ResultType<T> queryResultType;
  private Query<T> query;
  private ResultType<?> actualResultType;
  private com.google.datastore.v1beta3.QueryResultBatch queryResultBatchPb;
  private boolean lastBatch;
  private Iterator<com.google.datastore.v1beta3.EntityResult> entityResultPbIter;
  private ByteString cursor;


  QueryResultsImpl(DatastoreImpl datastore, com.google.datastore.v1beta3.ReadOptions readOptionsPb,
                   Query<T> query) {
    this.datastore = datastore;
    this.readOptionsPb = readOptionsPb;
    this.query = query;
    queryResultType = query.type();
    com.google.datastore.v1beta3.PartitionId.Builder pbBuilder =
        com.google.datastore.v1beta3.PartitionId.newBuilder();
    pbBuilder.setProjectId(datastore.options().projectId());
    if (query.namespace() != null) {
      pbBuilder.setNamespaceId(query.namespace());
    } else if (datastore.options().namespace() != null) {
      pbBuilder.setNamespaceId(datastore.options().namespace());
    }
    partitionIdPb = pbBuilder.build();
    sendRequest();
  }

  private void sendRequest() {
    com.google.datastore.v1beta3.RunQueryRequest.Builder requestPb =
        com.google.datastore.v1beta3.RunQueryRequest.newBuilder();
    if (readOptionsPb != null) {
      requestPb.setReadOptions(readOptionsPb);
    }
    requestPb.setPartitionId(partitionIdPb);
    query.populatePb(requestPb);
    queryResultBatchPb = datastore.runQuery(requestPb.build()).getBatch();
    lastBatch = queryResultBatchPb.getMoreResults() != MoreResultsType.NOT_FINISHED;
    entityResultPbIter = queryResultBatchPb.getEntityResultsList().iterator();
    if (queryResultBatchPb.getSkippedResults() > 0) {
      cursor = queryResultBatchPb.getSkippedCursor();
    }
    actualResultType = ResultType.fromPb(queryResultBatchPb.getEntityResultType());
    if (Objects.equals(queryResultType, ResultType.PROJECTION_ENTITY)) {
      // projection entity can represent all type of results
      actualResultType = ResultType.PROJECTION_ENTITY;
    }
    Preconditions.checkState(queryResultType.isAssignableFrom(actualResultType),
        "Unexpected result type " + actualResultType + " vs " + queryResultType);
  }

  @Override
  protected T computeNext() {
    while (!entityResultPbIter.hasNext() && !lastBatch) {
      query = query.nextQuery(queryResultBatchPb);
      sendRequest();
    }
    if (!entityResultPbIter.hasNext()) {
      return endOfData();
    }
    com.google.datastore.v1beta3.EntityResult entityResultPb = entityResultPbIter.next();
    cursor = entityResultPb.getCursor();
    @SuppressWarnings("unchecked")
    T result = (T) actualResultType.convert(entityResultPb.getEntity());
    return result;
  }

  @Override
  public Class<?> resultClass() {
    return actualResultType.resultClass();
  }

  @Override
  public Cursor cursorAfter() {
    return new Cursor(cursor);
  }
}
