package com.google.gcloud.datastore;

import static com.google.gcloud.datastore.DatastoreServiceException.throwInvalidRequest;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.Iterators;
import com.google.gcloud.datastore.TransactionOption.IsolationLevel;
import com.google.protobuf.ByteString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class TransactionImpl extends BatchImpl implements Transaction {

  private final ByteString transaction;
  private boolean rolledback;

  static class ResponseImpl extends BatchImpl.ResponseImpl implements Transaction.Response {

    public ResponseImpl(DatastoreV1.CommitResponse response) {
      super(response);
    }
  }

  TransactionImpl(DatastoreServiceImpl datastore, TransactionOption... options) {
    super(datastore, getBatchOptions(options));
    DatastoreV1.BeginTransactionRequest.Builder requestPb =
        DatastoreV1.BeginTransactionRequest.newBuilder();
    Map<Class<? extends TransactionOption>, TransactionOption> optionsMap =
        TransactionOption.asImmutableMap(options);
    IsolationLevel isolationLevel = (IsolationLevel) optionsMap.get(IsolationLevel.class);
    if (isolationLevel != null) {
      requestPb.setIsolationLevel(isolationLevel.level().toPb());
    }
    transaction = datastore.requestTransactionId(requestPb);
  }

  private static BatchOption[] getBatchOptions(TransactionOption... options) {
    List<BatchOption> batchOptions = new ArrayList<>(options.length);
    for (TransactionOption option : options) {
      BatchOption batchOption = option.toBatchWriteOption();
      if (batchOption != null) {
        batchOptions.add(batchOption);
      }
    }
    return batchOptions.toArray(new BatchOption[batchOptions.size()]);
  }

  @Override
  public Entity get(Key key) {
    return Iterators.getNext(get(new Key[] {key}), null);
  }

  @Override
  public Iterator<Entity> get(Key... keys) {
    validateActive();
    DatastoreV1.ReadOptions.Builder readOptionsPb = DatastoreV1.ReadOptions.newBuilder();
    readOptionsPb.setTransaction(transaction);
    return datastore.get(readOptionsPb.build(), keys);
  }

  @Override
  public <T> QueryResult<T> run(Query<T> query) {
    validateActive();
    DatastoreV1.ReadOptions.Builder readOptionsPb = DatastoreV1.ReadOptions.newBuilder();
    readOptionsPb.setTransaction(transaction);
    return datastore.run(readOptionsPb.build(), query);
  }

  @Override
  public Transaction.Response commit() {
    return new ResponseImpl(commitRequest());
  }

  @Override
  public void rollback() {
    super.validateActive();
    if (!rolledback) {
      datastore.rollbackTransaction(transaction);
    }
    rolledback = true;
  }

  @Override
  public boolean active() {
    return super.active() && !rolledback;
  }

  @Override
  protected String getName() {
    return "transaction";
  }

  @Override
  protected void validateActive() {
    super.validateActive();
    if (rolledback) {
      throw throwInvalidRequest(getName() + " is not active (was rolledback)");
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
