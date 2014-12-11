package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;

import java.util.Iterator;

class QueryResultImpl<T> implements QueryResult<T> {

  private static final ImmutableMap<DatastoreV1.EntityResult.ResultType, QueryResult.Type>
      RESULT_TYPE_CONVERTER;

  private final DatastoreServiceImpl datastore;
  private final Query<T> query;
  private final QueryResult.Type type;
  private DatastoreV1.RunQueryRequest requestPb;
  private Iterator<DatastoreV1.EntityResult> entityResultPbIter;
  private ByteString endCursor;
  private int count;

  static {
    ImmutableMap.Builder<DatastoreV1.EntityResult.ResultType, QueryResult.Type> builder =
        ImmutableMap.builder();
    for (DatastoreV1.EntityResult.ResultType type : DatastoreV1.EntityResult.ResultType.values()) {
      builder.put(type, QueryResult.Type.valueOf(type.name()));
    }
    RESULT_TYPE_CONVERTER = builder.build();
  }

  QueryResultImpl(DatastoreServiceImpl datastore, Query<T> query,
      DatastoreV1.RunQueryRequest requestPb, DatastoreV1.QueryResultBatch resultPb) {
    this.datastore = datastore;
    this.query = query;
    this.requestPb = requestPb;
    type = RESULT_TYPE_CONVERTER.get(resultPb.getEntityResultType());
  }

  void setQueryResultBatch(DatastoreV1.QueryResultBatch resultPb) {
    entityResultPbIter = resultPb.getEntityResultList().iterator();
    if (DatastoreV1.QueryResultBatch.MoreResultsType.NOT_FINISHED == resultPb.getMoreResults()) {
      endCursor = resultPb.getEndCursor();
    }
  }

  @Override
  public boolean hasNext() {
    return entityResultPbIter.hasNext()  || endCursor != null;
  }

  @Override
  public T next() {
    if (!hasNext() && endCursor != null) {
      DatastoreV1.RunQueryRequest.Builder requestPbBuilder = requestPb.toBuilder();
      query.populatePb(requestPbBuilder, count, endCursor);
      DatastoreV1.RunQueryRequest newRequestPb = requestPbBuilder.build();
      DatastoreV1.RunQueryResponse responsePb = datastore.runQuery(newRequestPb);
      requestPb = newRequestPb;
      setQueryResultBatch(responsePb.getBatch());
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
  public QueryResult.Type getType() {
    return type;
  }

  @Override
  public Cursor getCursor() {
    // TODO(ozarov): implement when v1beta3 is available
    return null;
  }
}
