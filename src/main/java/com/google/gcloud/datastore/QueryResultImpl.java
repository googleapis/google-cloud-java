package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.api.services.datastore.DatastoreV1.EntityResult;
import com.google.common.collect.ImmutableMap;

import java.util.Iterator;

public class QueryResultImpl<V extends Object> implements QueryResult<V> {

  private static final ImmutableMap<DatastoreV1.EntityResult.ResultType, QueryResult.Type>
      RESULT_TYPE_CONVERTER;

  private final QueryResult.Type type;
  private Iterator<EntityResult> entityResultPbIter;
  private boolean moreResult;

  static {
    ImmutableMap.Builder<DatastoreV1.EntityResult.ResultType, QueryResult.Type> builder =
        ImmutableMap.builder();
    for (DatastoreV1.EntityResult.ResultType type : DatastoreV1.EntityResult.ResultType.values()) {
      builder.put(type, QueryResult.Type.valueOf(type.name()));
    }
    RESULT_TYPE_CONVERTER = builder.build();
  }

  QueryResultImpl(DatastoreV1.Query DatastoreV1.QueryResultBatch resultBatch) {
    type = RESULT_TYPE_CONVERTER.get(resultBatch.getEntityResultType());
    entityResultPbIter = resultBatch.getEntityResultList().iterator();
    moreResult =
        DatastoreV1.QueryResultBatch.MoreResultsType.NOT_FINISHED == resultBatch.getMoreResults();
  }

  @Override
  public boolean hasNext() {
    if (entityResultPbIter.hasNext()) {
      return true;
    } else if (moreResult) {
      // need to fetch more and update results (and more results)
    }
    return false;
  }

  @Override
  public V next() {
    return (V) type.convert(entityResultPbIter.next());
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
