package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.gcloud.datastore.TransactionOption.IsolationLevel;
import com.google.protobuf.ByteString;

import java.util.Iterator;

public final class TransactionImpl extends BatchWriterImpl implements Transaction {

  private final ByteString transaction;
  private IsolationLevel isolationLevel;

  TransactionImpl(DatastoreServiceImpl datastore, TransactionOption... options) {
    super(datastore, options);
    DatastoreV1.BeginTransactionRequest.Builder requestPb =
        DatastoreV1.BeginTransactionRequest.newBuilder();
    if (isolationLevel != null) {
      requestPb.setIsolationLevel(isolationLevel.level().toPb());
    }
    transaction = datastore.requestTransactionId(requestPb);
  }

  void apply(IsolationLevel isolationLevel) {
    // TODO(ozarov): validate that this concept actually works!!!
    this.isolationLevel = isolationLevel;
  }

  @Override
  public Entity get(Key key) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Iterator<Entity> get(Key... key) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public QueryResult<PartialEntity> runQuery(Query query) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void commit() {
    submit();
  }

  @Override
  public void rollback() {
    isValid = false;
  }

  @Override
  protected DatastoreV1.CommitRequest.Builder newCommitRequest() {
    DatastoreV1.CommitRequest.Builder requestPb = DatastoreV1.CommitRequest.newBuilder();
    requestPb.setMode(DatastoreV1.CommitRequest.Mode.TRANSACTIONAL);
    requestPb.setTransaction(transaction);
    return requestPb;
  }
}
