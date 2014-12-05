package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.api.services.datastore.DatastoreV1.BeginTransactionResponse;
import com.google.api.services.datastore.client.Datastore;
import com.google.api.services.datastore.client.DatastoreException;
import com.google.common.collect.AbstractIterator;
import com.google.protobuf.ByteString;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


final class DatastoreServiceImpl implements DatastoreService {

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
  public Transaction newTransaction(TransactionOption... transactionOption) {
    return new TransactionImpl(this, transactionOption);
  }

  ByteString requestTransactionId(DatastoreV1.BeginTransactionRequest.Builder requestPb) {
    try {
      BeginTransactionResponse responsePb = datastore.beginTransaction(requestPb.build());
      return responsePb.getTransaction();
    } catch (DatastoreException e) {
      throw DatastoreServiceException.translateAndPropagate(e);
    }
  }

  @Override
  public BatchWriter newBatchWriter(BatchWriteOption... batchWriteOption) {
    return new BatchWriterImpl(this, batchWriteOption);
  }

  @Override
  public Key allocateId(PartialKey key) {
    return allocateIds(key).next();
  }

  @Override
  public Iterator<Key> allocateIds(PartialKey... key) {
    DatastoreV1.AllocateIdsRequest.Builder requestPb = DatastoreV1.AllocateIdsRequest.newBuilder();
    for (PartialKey k : key) {
      if (k.getLeaf().nameOrId() != null) {
        // if key is full remove the id or name part
        k = new PartialKey.Builder(k.dataset(), k.kind())
            .namespace(k.namespace())
            .addAncestors(k.ancestors())
            .build();
      }
      requestPb.addKey(k.toPb());
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
      throw DatastoreServiceException.translateAndPropagate(e);
    }
  }

  @Override
  public Entity get(Key key) {
    return get(new Key[]{key}).next();
  }

  @Override
  public Iterator<Entity> get(final Key... key) {
    DatastoreV1.LookupRequest.Builder requestPb = DatastoreV1.LookupRequest.newBuilder();
    for (Key k : key) {
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
        int index;

        @Override
        protected Entity computeNext() {
          if (index < key.length) {
            return result.get(key[index++]);
          }
          return endOfData();
        }
      };
    } catch (DatastoreException e) {
      throw DatastoreServiceException.translateAndPropagate(e);
    }
  }

  @Override
  public void add(Entity... entity) {
    DatastoreV1.Mutation.Builder mutationPb = DatastoreV1.Mutation.newBuilder();
    for (Entity e : entity) {
      mutationPb.addInsert(e.toPb());
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
  }

  void comitMutation(DatastoreV1.CommitRequest.Builder requestPb) {
    try {
      datastore.commit(requestPb.build());
    } catch (DatastoreException e) {
      throw DatastoreServiceException.translateAndPropagate(e);
    }
  }

  @Override
  public void update(Entity... entity) {
    DatastoreV1.Mutation.Builder mutationPb = DatastoreV1.Mutation.newBuilder();
    for (Entity e : entity) {
      mutationPb.addUpdate(e.toPb());
    }
    comitMutation(mutationPb);
  }

  @Override
  public void put(Entity... entity) {
    DatastoreV1.Mutation.Builder mutationPb = DatastoreV1.Mutation.newBuilder();
    for (Entity e : entity) {
      mutationPb.addUpsert(e.toPb());
    }
    comitMutation(mutationPb);
  }

  @Override
  public void delete(Key... key) {
    DatastoreV1.Mutation.Builder mutationPb = DatastoreV1.Mutation.newBuilder();
    for (Key k : key) {
      mutationPb.addDelete(k.toPb());
    }
    comitMutation(mutationPb);
  }

  @Override
  public KeyBuilder newKeyBuilder(String kind) {
    return new KeyBuilder(this, kind);
  }

  @Override
  public QueryResult<PartialEntity> runQuery(Query query) {
    // TODO Auto-generated method stub
    return null;
  }

  Datastore datastore() {
    return datastore;
  }
}
