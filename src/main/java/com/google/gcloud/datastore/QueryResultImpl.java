package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.api.services.datastore.DatastoreV1.QueryResultBatch.MoreResultsType;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.gcloud.datastore.Query.Type;

import java.util.Iterator;
import java.util.Objects;

class QueryResultImpl<T> extends AbstractIterator<T> implements QueryResult<T> {

  private final DatastoreServiceImpl datastore;
  private final DatastoreV1.ReadOptions readOptionsPb;
  private final DatastoreV1.PartitionId partitionIdPb;
  private final Query.Type<T> queryType;
  private Query<T> query;
  private Query.Type<?> actualType;
  private DatastoreV1.QueryResultBatch queryResultBatchPb;
  private boolean lastBatch;
  private Iterator<DatastoreV1.EntityResult> entityResultPbIter;
  //private ByteString cursor; // only available in v1beta3


  QueryResultImpl(DatastoreServiceImpl datastore, DatastoreV1.ReadOptions readOptionsPb,
      Query<T> query) {
    this.datastore = datastore;
    this.readOptionsPb = readOptionsPb;
    this.query = query;
    queryType = query.type();
    DatastoreV1.PartitionId.Builder pbBuilder = DatastoreV1.PartitionId.newBuilder();
    pbBuilder.setDatasetId(datastore.options().dataset());
    if (query.namespace() != null) {
      pbBuilder.setNamespace(query.namespace());
    } else if (datastore.options().namespace() != null) {
      pbBuilder.setNamespace(datastore.options().namespace());
    }
    partitionIdPb = pbBuilder.build();
    sendRequest();
  }

  private void sendRequest() {
    DatastoreV1.RunQueryRequest.Builder requestPb = DatastoreV1.RunQueryRequest.newBuilder();
    if (readOptionsPb != null) {
      requestPb.setReadOptions(readOptionsPb);
    }
    requestPb.setPartitionId(partitionIdPb);
    query.populatePb(requestPb);
    queryResultBatchPb = datastore.runQuery(requestPb.build()).getBatch();
    lastBatch = queryResultBatchPb.getMoreResults() != MoreResultsType.NOT_FINISHED;
    entityResultPbIter = queryResultBatchPb.getEntityResultList().iterator();
    // cursor = resultPb.getSkippedCursor(); // only available in v1beta3
    actualType = Type.fromPb(queryResultBatchPb.getEntityResultType());
    if (Objects.equals(queryType, Type.PROJECTION)) {
      // projection entity can represent all type of results
      actualType = Type.PROJECTION;
    }
    Preconditions.checkState(queryType.isAssignableFrom(actualType),
        "Unexpected result type " + actualType + " vs " + queryType);
  }

  @SuppressWarnings("unchecked")
  @Override
  protected T computeNext() {
    while (!entityResultPbIter.hasNext() && !lastBatch) {
      query = query.nextQuery(queryResultBatchPb);
      sendRequest();
    }
    if (!entityResultPbIter.hasNext()) {
      return endOfData();
    }
    DatastoreV1.EntityResult entityResultPb = entityResultPbIter.next();
    //cursor = entityResultPb.getCursor(); // only available in v1beta3
    return (T) actualType.convert(entityResultPb.getEntity());
  }

  @Override
  public Class<?> resultClass() {
    return actualType.resultClass();
  }

  @Override
  public Cursor cursor() {
    //return new Cursor(cursor); // only available in v1beta3
    return null;
  }
}
