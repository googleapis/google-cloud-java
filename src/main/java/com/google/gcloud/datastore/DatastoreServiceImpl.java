package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.api.services.datastore.client.Datastore;
import com.google.api.services.datastore.client.DatastoreException;
import com.google.common.base.MoreObjects;
import com.google.common.collect.AbstractIterator;
import com.google.gcloud.ExceptionHandler;
import com.google.gcloud.RetryHelper;
import com.google.gcloud.RetryHelper.RetryHelperException;
import com.google.gcloud.RetryParams;
import com.google.protobuf.ByteString;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.Callable;


final class DatastoreServiceImpl implements DatastoreService {

  static final Key[] EMPTY_KEY_ARRAY = {};
  static final PartialKey[] EMPTY_PARTIAL_KEY_ARRAY = {};
  private static final ExceptionHandler.Interceptor EXCEPTION_HANDLER_INTERCEPTOR =
      new ExceptionHandler.Interceptor() {

        private static final long serialVersionUID = 6911242958397733203L;

        @Override
        public boolean shouldRetry(Exception exception, boolean shouldRetry) {
          return shouldRetry;
        }

        @Override
        public Boolean shouldRetry(Exception exception) {
          if (exception instanceof DatastoreServiceException) {
            return ((DatastoreServiceException) exception).code().isTransient();
          }
          return null;
        }
      };
  private static final ExceptionHandler EXCEPTION_HANDLER = ExceptionHandler.builder()
      .abortOn(RuntimeException.class, DatastoreException.class)
      .interceptor(EXCEPTION_HANDLER_INTERCEPTOR).build();

  private final DatastoreServiceOptions options;
  private final Datastore datastore;
  private final RetryParams retryParams;

  DatastoreServiceImpl(DatastoreServiceOptions options, Datastore datastore) {
    this.options = options;
    this.datastore = datastore;
    retryParams = MoreObjects.firstNonNull(options.retryParams(), RetryParams.noRetries());
  }

  @Override
  public DatastoreServiceOptions options() {
    return options;
  }

  @Override
  public BatchWriter newBatchWriter(BatchWriteOption... batchWriteOption) {
    return new BatchWriterImpl(this, batchWriteOption);
  }

  @Override
  public Transaction newTransaction(TransactionOption... transactionOption) {
    return new TransactionImpl(this, transactionOption);
  }

  @Override
  public <T> QueryResult<T> run(Query<T> query) {
    return run(null, query);
  }

  <T> QueryResult<T> run(DatastoreV1.ReadOptions readOptionsPb, Query<T> query) {
    return new QueryResultImpl<>(this, readOptionsPb, query);
  }

  DatastoreV1.RunQueryResponse runQuery(final DatastoreV1.RunQueryRequest requestPb) {
    try {
      return RetryHelper.runWithRetries(new Callable<DatastoreV1.RunQueryResponse>() {
        @Override public DatastoreV1.RunQueryResponse call() throws DatastoreException {
          return datastore.runQuery(requestPb);
        }
      }, retryParams, EXCEPTION_HANDLER);
    } catch (RetryHelperException e) {
      throw DatastoreServiceException.translateAndThrow(e);
    }
  }

  @Override
  public Key allocateId(PartialKey key) {
    return allocateId(key, EMPTY_PARTIAL_KEY_ARRAY).next();
  }

  @Override
  public Iterator<Key> allocateId(PartialKey key, PartialKey... others) {
    DatastoreV1.AllocateIdsRequest.Builder requestPb = DatastoreV1.AllocateIdsRequest.newBuilder();
    requestPb.addKey(trimNameOrId(key).toPb());
    for (PartialKey other : others) {
      requestPb.addKey(trimNameOrId(other).toPb());
    }
    // TODO(ozarov): will need to populate "force" after b/18594027 is fixed.
    DatastoreV1.AllocateIdsResponse responsePb = allocateIds(requestPb.build());
    final Iterator<DatastoreV1.Key> keys = responsePb.getKeyList().iterator();
    return new AbstractIterator<Key>() {
      @Override protected Key computeNext() {
        if (keys.hasNext()) {
          return Key.fromPb(keys.next());
        }
        return endOfData();
      }
    };
  }

  DatastoreV1.AllocateIdsResponse allocateIds(final DatastoreV1.AllocateIdsRequest requestPb) {
    try {
      return RetryHelper.runWithRetries(new Callable<DatastoreV1.AllocateIdsResponse>() {
        @Override public DatastoreV1.AllocateIdsResponse call() throws DatastoreException {
          return datastore.allocateIds(requestPb);
        }
      }, retryParams, EXCEPTION_HANDLER);
    } catch (RetryHelperException e) {
      throw DatastoreServiceException.translateAndThrow(e);
    }
  }

  private PartialKey trimNameOrId(PartialKey key) {
    if (key instanceof Key) {
      return PartialKey.builder(key).build();
    }
    return key;
  }

  @Override
  public Entity get(Key key) {
    Iterator<Entity> iter = get(key, EMPTY_KEY_ARRAY);
    return iter.hasNext() ? iter.next() : null;
  }

  @Override
  public Iterator<Entity> get(Key key, Key... others) {
    return get(null, key, others);
  }

  Iterator<Entity> get(DatastoreV1.ReadOptions readOptionsPb, final Key key, final Key... others) {
    DatastoreV1.LookupRequest.Builder requestPb = DatastoreV1.LookupRequest.newBuilder();
    if (readOptionsPb != null) {
      requestPb.setReadOptions(readOptionsPb);
    }
    LinkedHashSet<Key> dedupKeys = new LinkedHashSet<>();
    dedupKeys.add(key);
    dedupKeys.addAll(Arrays.asList(others));
    for (Key k : dedupKeys) {
      requestPb.addKey(k.toPb());
    }
    return new ResultsIterator(requestPb);
  }

  final class ResultsIterator extends AbstractIterator<Entity> {

    private final DatastoreV1.LookupRequest.Builder requestPb;
    Iterator<DatastoreV1.EntityResult> iter;

    ResultsIterator(DatastoreV1.LookupRequest.Builder requestPb) {
      this.requestPb = requestPb;
      loadResults();
    }

    private void loadResults() {
      DatastoreV1.LookupResponse responsePb = lookup(requestPb.build());
      iter = responsePb.getFoundList().iterator();
      requestPb.clearKey();
      if (responsePb.getDeferredCount() > 0) {
        requestPb.addAllKey(responsePb.getDeferredList());
      }
    }

    @Override
    protected Entity computeNext() {
      if (iter.hasNext()) {
        return Entity.fromPb(iter.next().getEntity());
      }
      while (!iter.hasNext()) {
        if (requestPb.getKeyCount() == 0) {
          return endOfData();
        }
        loadResults();
      }
      return Entity.fromPb(iter.next().getEntity());
    }
  }

  DatastoreV1.LookupResponse lookup(final DatastoreV1.LookupRequest requestPb) {
    try {
      return RetryHelper.runWithRetries(new Callable<DatastoreV1.LookupResponse>() {
        @Override public DatastoreV1.LookupResponse call() throws DatastoreException {
          return datastore.lookup(requestPb);
        }
      }, retryParams, EXCEPTION_HANDLER);
    } catch (RetryHelperException e) {
      throw DatastoreServiceException.translateAndThrow(e);
    }
  }

  @Override
  public void add(Entity... entities) {
    DatastoreV1.Mutation.Builder mutationPb = DatastoreV1.Mutation.newBuilder();
    LinkedHashSet<Key> keys = new LinkedHashSet<>();
    for (Entity entity : entities) {
      if (!keys.add(entity.key())) {
        throw DatastoreServiceException.throwInvalidRequest(
            "Duplicate entity with the key %s", entity.key());
      }
      mutationPb.addInsert(entity.toPb());
    }
    commitMutation(mutationPb);
  }

  @Override
  public void update(Entity... entities) {
    DatastoreV1.Mutation.Builder mutationPb = DatastoreV1.Mutation.newBuilder();
    LinkedHashMap<Key, Entity> dedupEntities = new LinkedHashMap<>();
    for (Entity entity : entities) {
      dedupEntities.put(entity.key(), entity);
    }
    for (Entity entity : dedupEntities.values()) {
      mutationPb.addUpdate(entity.toPb());
    }
    commitMutation(mutationPb);
  }

  @Override
  public void put(Entity... entities) {
    DatastoreV1.Mutation.Builder mutationPb = DatastoreV1.Mutation.newBuilder();
    LinkedHashMap<Key, Entity> dedupEntities = new LinkedHashMap<>();
    for (Entity entity : entities) {
      dedupEntities.put(entity.key(), entity);
    }
    for (Entity e : dedupEntities.values()) {
      mutationPb.addUpsert(e.toPb());
    }
    commitMutation(mutationPb);
  }

  @Override
  public void delete(Key... keys) {
    DatastoreV1.Mutation.Builder mutationPb = DatastoreV1.Mutation.newBuilder();
    LinkedHashSet<Key> dedupKeys = new LinkedHashSet<>(Arrays.asList(keys));
    for (Key key : dedupKeys) {
      mutationPb.addDelete(key.toPb());
    }
    commitMutation(mutationPb);
  }

  private void commitMutation(DatastoreV1.Mutation.Builder mutationPb) {
    if (options.force()) {
      mutationPb.setForce(true);
    }
    DatastoreV1.CommitRequest.Builder requestPb = DatastoreV1.CommitRequest.newBuilder();
    requestPb.setMode(DatastoreV1.CommitRequest.Mode.NON_TRANSACTIONAL);
    requestPb.setMutation(mutationPb);
    commit(requestPb.build());
  }

  DatastoreV1.CommitResponse commit(final DatastoreV1.CommitRequest requestPb) {
    try {
      return RetryHelper.runWithRetries(new Callable<DatastoreV1.CommitResponse>() {
        @Override public DatastoreV1.CommitResponse call() throws DatastoreException {
          return datastore.commit(requestPb);
        }
      }, retryParams, EXCEPTION_HANDLER);
    } catch (RetryHelperException e) {
      throw DatastoreServiceException.translateAndThrow(e);
    }
  }

  ByteString requestTransactionId(DatastoreV1.BeginTransactionRequest.Builder requestPb) {
    return beginTransaction(requestPb.build()).getTransaction();
  }

  DatastoreV1.BeginTransactionResponse beginTransaction(
      final DatastoreV1.BeginTransactionRequest requestPb) {
    try {
      return RetryHelper.runWithRetries(new Callable<DatastoreV1.BeginTransactionResponse>() {
        @Override public DatastoreV1.BeginTransactionResponse call() throws DatastoreException {
          return datastore.beginTransaction(requestPb);
        }
      }, retryParams, EXCEPTION_HANDLER);
    } catch (RetryHelperException e) {
      throw DatastoreServiceException.translateAndThrow(e);
    }
  }

  void rollbackTransaction(ByteString transaction) {
    DatastoreV1.RollbackRequest.Builder requestPb = DatastoreV1.RollbackRequest.newBuilder();
    requestPb.setTransaction(transaction);
    rollback(requestPb.build());
  }

  DatastoreV1.RollbackResponse rollback(final DatastoreV1.RollbackRequest requestPb) {
    try {
      return RetryHelper.runWithRetries(new Callable<DatastoreV1.RollbackResponse>() {
        @Override public DatastoreV1.RollbackResponse call() throws DatastoreException {
          return datastore.rollback(requestPb);
        }
      }, retryParams, EXCEPTION_HANDLER);
    } catch (RetryHelperException e) {
      throw DatastoreServiceException.translateAndThrow(e);
    }
  }
}
