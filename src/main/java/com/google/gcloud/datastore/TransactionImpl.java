package com.google.gcloud.datastore;

import static com.google.gcloud.datastore.DatastoreServiceException.throwInvalidRequest;

import com.google.api.services.datastore.DatastoreV1;
import com.google.gcloud.datastore.TransactionOption.IsolationLevel;
import com.google.protobuf.ByteString;

import java.util.Iterator;
import java.util.Map;

public final class TransactionImpl extends BatchWriterImpl implements Transaction {

  private final ByteString transaction;
  private boolean wasRolledback;

  TransactionImpl(DatastoreServiceImpl datastore, TransactionOption... options) {
    super(datastore, options);
    DatastoreV1.BeginTransactionRequest.Builder requestPb =
        DatastoreV1.BeginTransactionRequest.newBuilder();
    Map<Class<? extends BatchWriteOption>, BatchWriteOption> optionsMap =
        BatchWriteOption.asImmutableMap(options);
    IsolationLevel isolationLevel = (IsolationLevel) optionsMap.get(IsolationLevel.class);
    if (isolationLevel != null) {
      requestPb.setIsolationLevel(isolationLevel.level().toPb());
    }
    transaction = datastore.requestTransactionId(requestPb);
  }

  @Override
  public Entity get(Key key) {
    return get(key, DatastoreServiceImpl.EMPTY_KEY_ARRAY).next();
  }

  @Override
  public Iterator<Entity> get(Key key, Key... others) {
    checkActive();
    DatastoreV1.ReadOptions.Builder readOptionsPb = DatastoreV1.ReadOptions.newBuilder();
    readOptionsPb.setTransaction(transaction);
    return datastore.get(readOptionsPb.build(), key, others);
  }

  @Override
  public <T> QueryResult<T> runQuery(Query<T> query) {
    checkActive();
    DatastoreV1.ReadOptions.Builder readOptionsPb = DatastoreV1.ReadOptions.newBuilder();
    readOptionsPb.setTransaction(transaction);
    return datastore.runQuery(readOptionsPb.build(), query);
  }

  @Override
  public void commit() {
    submit();
  }

  @Override
  public void rollback() {
    super.checkActive();
    if (!wasRolledback) {
      datastore.rollbackTransaction(transaction);
    }
    wasRolledback = true;
  }

  @Override
  public boolean active() {
    return super.active() && !wasRolledback;
  }

  @Override
  protected String getName() {
    return "transaction";
  }

  @Override
  protected void checkActive() {
    super.checkActive();
    if (wasRolledback) {
      throwInvalidRequest(getName() + " is not active (was rolledback)");
    }
  }

  @Override
  protected DatastoreV1.CommitRequest.Builder newCommitRequest() {
    DatastoreV1.CommitRequest.Builder requestPb = DatastoreV1.CommitRequest.newBuilder();
    requestPb.setMode(DatastoreV1.CommitRequest.Mode.TRANSACTIONAL);
    requestPb.setTransaction(transaction);
    return requestPb;
  }
}
