package com.google.gcloud.datastore;

import java.util.Iterator;


final class DatastoreServiceImpl implements DatastoreService {

  private final DatastoreServiceOptions options;

  DatastoreServiceImpl(DatastoreServiceOptions options) {
    this.options = options;
  }

  @Override
  public DatastoreServiceOptions getOptions() {
    return options;
  }

  @Override
  public Transaction newTransaction(TransactionOption... transactionOption) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BatchWriter newBatchWriter(BatchWriteOption... batchWriteOption) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Key allocateId(PartialKey key) {
    return allocateIds(key).next();
  }

  @Override
  public Iterator<Key> allocateIds(PartialKey... key) {
    // TODO Auto-generated method stub
    // Will need to populate "force" after b/18594027 is fixed.
    return null;
  }

  @Override
  public Entity get(Key key) {
    return get(new Key[]{key}).next();
  }

  @Override
  public Iterator<Entity> get(Key... key) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void add(Entity... entity) {
    // TODO Auto-generated method stub
  }

  @Override
  public void update(Entity... entity) {
    // TODO Auto-generated method stub
  }

  @Override
  public void put(Entity... entity) {
    // TODO Auto-generated method stub
  }

  @Override
  public void delete(Key... key) {
    // TODO Auto-generated method stub
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
}
