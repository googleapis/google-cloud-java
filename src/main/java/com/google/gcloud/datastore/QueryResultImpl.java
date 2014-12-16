package com.google.gcloud.datastore;

import com.google.api.client.repackaged.com.google.common.base.Preconditions;
import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableMap;

import java.util.Iterator;

class QueryResultImpl<T> extends AbstractIterator<T> implements QueryResult<T> {

  private static final ImmutableMap<DatastoreV1.EntityResult.ResultType, Query.Type>
      RESULT_TYPE_CONVERTER;

  private final DatastoreServiceImpl datastore;
  private final DatastoreV1.ReadOptions readOptionsPb;
  private final DatastoreV1.PartitionId partitionIdPb;
  private final Query.ResultClass<T> resultClass;
  private Query<T> query;
  private Query.Type type;
  private DatastoreV1.QueryResultBatch resultPb;
  private Iterator<DatastoreV1.EntityResult> entityResultPbIter;
  //private ByteString cursor; // only available in v1beta3

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
    resultClass = query.resultClass();
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

  private DatastoreV1.QueryResultBatch sendRequest() {
    DatastoreV1.RunQueryRequest.Builder requestPb = DatastoreV1.RunQueryRequest.newBuilder();
    if (readOptionsPb != null) {
      requestPb.setReadOptions(readOptionsPb);
    }
    requestPb.setPartitionId(partitionIdPb);
    query.populatePb(requestPb);
    resultPb = datastore.runQuery(requestPb.build()).getBatch();
    entityResultPbIter = resultPb.getEntityResultList().iterator();
    // cursor = resultPb.getSkippedCursor(); // only available in v1beta3
    type = RESULT_TYPE_CONVERTER.get(resultPb.getEntityResultType());
    Preconditions.checkState(resultClass.isAssignableFrom(type.resultClass()),
        "Unexpected result type");
    return resultPb;
  }

  @Override
  protected T computeNext() {
    while (!entityResultPbIter.hasNext()
        && resultPb.getMoreResults() == DatastoreV1.QueryResultBatch.MoreResultsType.NOT_FINISHED) {
      query = query.nextQuery(resultPb);
      sendRequest();
    }
    if (!entityResultPbIter.hasNext()) {
      return endOfData();
    }
    DatastoreV1.EntityResult entityResultPb = entityResultPbIter.next();
    //cursor = entityResultPb.getCursor(); // only available in v1beta3
    return type.convert(entityResultPb.getEntity());
  }

  @Override
  public Class<?> resultClass() {
    return type.resultClass().value();
  }

  @Override
  public Cursor cursor() {
    //return new Cursor(cursor); // only available in v1beta3
    return null;
  }
}
