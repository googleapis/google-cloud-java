package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.api.services.datastore.client.Datastore;
import com.google.api.services.datastore.client.DatastoreException;
import com.google.common.collect.AbstractIterator;
import com.google.protobuf.ByteString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;


final class DatastoreServiceImpl implements DatastoreService {

  static final Key[] EMPTY_KEY_ARRAY = {};
  static final PartialKey[] EMPTY_PARTIAL_KEY_ARRAY = {};

  private final DatastoreServiceOptions options;
  private final Datastore datastore;

  DatastoreServiceImpl(DatastoreServiceOptions options, Datastore datastore) {
    this.options = options;
    this.datastore = datastore;
  }

  @Override
  public DatastoreServiceOptions getOptions() {
    return options;
  }

  @Override
  public KeyBuilder newKeyBuilder(String kind) {
    return new KeyBuilder(this, kind);
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
  public <T> QueryResult<T> runQuery(Query<T> query) {
    return runQuery(null, query);
  }

  <T> QueryResult<T> runQuery(DatastoreV1.ReadOptions readOptionsPb, Query<T> query) {
    DatastoreV1.RunQueryRequest.Builder requestPbBuilder = DatastoreV1.RunQueryRequest.newBuilder();
    if (readOptionsPb != null) {
      requestPbBuilder.setReadOptions(readOptionsPb);
    }
    DatastoreV1.PartitionId.Builder partitionIdPb = DatastoreV1.PartitionId.newBuilder();
    partitionIdPb.setDatasetId(options.dataset());
    String namespace = query.namespace() != null ? query.namespace() : options.namespace();
    if (namespace != null) {
      partitionIdPb.setNamespace(namespace);
    }
    requestPbBuilder.setPartitionId(partitionIdPb.build());
    query.populatePb(requestPbBuilder, 0, null);
    DatastoreV1.RunQueryRequest requestPb = requestPbBuilder.build();
    return new QueryResultImpl<>(this, query, requestPb, runQuery(requestPb).getBatch());
  }

  DatastoreV1.RunQueryResponse runQuery(DatastoreV1.RunQueryRequest requestPb) {
    try {
      return datastore.runQuery(requestPb);
    } catch (DatastoreException e) {
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
    try {
      DatastoreV1.AllocateIdsResponse responsePb = datastore.allocateIds(requestPb.build());
      final Iterator<DatastoreV1.Key> keys = responsePb.getKeyList().iterator();
      return new AbstractIterator<Key>() {

        @Override
        protected Key computeNext() {
          if (keys.hasNext()) {
            return Key.fromPb(keys.next());
          }
          return endOfData();
        }
      };
    } catch (DatastoreException e) {
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
    return get(key, EMPTY_KEY_ARRAY).next();
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
    try {
      DatastoreV1.LookupResponse responsePb = datastore.lookup(requestPb.build());
      final Map<Key, Entity> result = new HashMap<>();
      for (DatastoreV1.EntityResult entityResultPb : responsePb.getFoundList()) {
        Entity entity = Entity.fromPb(entityResultPb.getEntity());
        result.put(entity.key(), entity);
      }
      return new AbstractIterator<Entity>() {
        int index = -2;

        @Override
        protected Entity computeNext() {
          ++index;
          if (index < 0) {
            return result.get(key);
          }
          if (index < others.length) {
            return result.get(others[index]);
          }
          return endOfData();
        }
      };
    } catch (DatastoreException e) {
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
    comitMutation(mutationPb);
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
    comitMutation(mutationPb);
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
    comitMutation(mutationPb);
  }

  @Override
  public void delete(Key... keys) {
    DatastoreV1.Mutation.Builder mutationPb = DatastoreV1.Mutation.newBuilder();
    LinkedHashSet<Key> dedupKeys = new LinkedHashSet<>(Arrays.asList(keys));
    for (Key key : dedupKeys) {
      mutationPb.addDelete(key.toPb());
    }
    comitMutation(mutationPb);
  }

  private void comitMutation(DatastoreV1.Mutation.Builder mutationPb) {
    if (options.force()) {
      mutationPb.setForce(true);
    }
    DatastoreV1.CommitRequest.Builder requestPb = DatastoreV1.CommitRequest.newBuilder();
    requestPb.setMode(DatastoreV1.CommitRequest.Mode.NON_TRANSACTIONAL);
    requestPb.setMutation(mutationPb);
    comitMutation(requestPb);
  }

  void comitMutation(DatastoreV1.CommitRequest.Builder requestPb) {
    try {
      datastore.commit(requestPb.build());
    } catch (DatastoreException e) {
      throw DatastoreServiceException.translateAndThrow(e);
    }
  }

  ByteString requestTransactionId(DatastoreV1.BeginTransactionRequest.Builder requestPb) {
    try {
      DatastoreV1.BeginTransactionResponse responsePb =
          datastore.beginTransaction(requestPb.build());
      return responsePb.getTransaction();
    } catch (DatastoreException e) {
      throw DatastoreServiceException.translateAndThrow(e);
    }
  }

  void rollbackTransaction(ByteString transaction) {
    DatastoreV1.RollbackRequest.Builder requestPb = DatastoreV1.RollbackRequest.newBuilder();
    requestPb.setTransaction(transaction);
    try {
      datastore.rollback(requestPb.build());
    } catch (DatastoreException e) {
      throw DatastoreServiceException.translateAndThrow(e);
    }
  }
}
