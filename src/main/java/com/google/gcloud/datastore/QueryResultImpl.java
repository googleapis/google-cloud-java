package com.google.gcloud.datastore;

import com.google.api.client.repackaged.com.google.common.base.Preconditions;
import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;

import java.util.Iterator;

class QueryResultImpl<T> implements QueryResult<T> {

  private static final ImmutableMap<DatastoreV1.EntityResult.ResultType, Query.Type>
      RESULT_TYPE_CONVERTER;

  private final DatastoreServiceImpl datastore;
  private final DatastoreV1.ReadOptions readOptionsPb;
  private final Query.ResultClass<T> resultClass;
  private Query<T> query;
  private Query.Type type;
  private DatastoreV1.QueryResultBatch resultPb;
  private Iterator<DatastoreV1.EntityResult> entityResultPbIter;
  private ByteString endCursor;
  private int count;

  static {
    ImmutableMap.Builder<DatastoreV1.EntityResult.ResultType, Query.Type> builder =
        ImmutableMap.builder();
    for (DatastoreV1.EntityResult.ResultType type : DatastoreV1.EntityResult.ResultType.values()) {
      builder.put(type, Query.Type.valueOf(type.name()));
    }
    RESULT_TYPE_CONVERTER = builder.build();
  }

  QueryResultImpl(DatastoreServiceImpl datastore, DatastoreV1.ReadOptions readOptionsPb,
      Query<T> query) {
    this.datastore = datastore;
    this.readOptionsPb = readOptionsPb;
    this.query = query;
    this.resultClass = query.getResultClass();
    sendRequest();
  }

  private DatastoreV1.QueryResultBatch sendRequest() {
    DatastoreV1.RunQueryRequest.Builder requestPb = DatastoreV1.RunQueryRequest.newBuilder();
    if (readOptionsPb != null) {
      requestPb.setReadOptions(readOptionsPb);
    }
    DatastoreV1.PartitionId.Builder partitionIdPb = DatastoreV1.PartitionId.newBuilder();
    partitionIdPb.setDatasetId(datastore.options().dataset());
    String namespace = query.namespace() != null
        ? query.namespace()
        : datastore.options().namespace();
    if (namespace != null) {
      partitionIdPb.setNamespace(namespace);
    }
    requestPb.setPartitionId(partitionIdPb.build());
    query.populatePb(requestPb);
    resultPb = datastore.runQuery(requestPb.build()).getBatch();
    entityResultPbIter = resultPb.getEntityResultList().iterator();
    if (DatastoreV1.QueryResultBatch.MoreResultsType.NOT_FINISHED == resultPb.getMoreResults()) {
      endCursor = resultPb.getEndCursor();
    } else {
      endCursor = null;
    }
    type = RESULT_TYPE_CONVERTER.get(resultPb.getEntityResultType());
    Preconditions.checkState(resultClass.isAssignableFrom(type.resultClass()),
        "Unexpected result type");
    return resultPb;
  }

  @Override
  public boolean hasNext() {
    return entityResultPbIter.hasNext() || endCursor != null;
  }

  @Override
  public T next() {
    if (!hasNext() && endCursor != null) {
      query = query.nextQuery(resultPb);
      sendRequest();
    }
    DatastoreV1.Entity entity = entityResultPbIter.next().getEntity();
    count++;
    return type.convert(entity);
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("QueryResult is read-only");
  }

  @Override
  public Query.Type getType() {
    return type;
  }

  @Override
  public Cursor getCursor() {
    // TODO(ozarov): implement when v1beta3 is available
    return null;
  }
}
