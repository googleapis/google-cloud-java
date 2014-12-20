package com.google.gcloud.datastore;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Adds some functionality to DatastoreService that should
 * be provided statically to the interface (Java 8).
 *
 */
public class DatastoreHelper implements DatastoreService {

  private final DatastoreService delegate;

  private DatastoreHelper(DatastoreService delegate) {
    this.delegate = delegate;
  }

  @Override
  public Entity get(Key key) {
    return delegate.get(key);
  }

  @Override
  public Iterator<Entity> get(Key key, Key... others) {
    return delegate.get(key, others);
  }

  @Override
  public <T> QueryResult<T> run(Query<T> query) {
    return delegate.run(query);
  }

  @Override
  public DatastoreServiceOptions options() {
    return delegate.options();
  }

  @Override
  public Transaction newTransaction(TransactionOption... options) {
    return delegate.newTransaction(options);
  }

  @Override
  public BatchWriter newBatchWriter(BatchWriteOption... options) {
    return delegate.newBatchWriter(options);
  }

  @Override
  public Key allocateId(PartialKey key) {
    return delegate.allocateId(key);
  }

  @Override
  public Iterator<Key> allocateId(PartialKey key, PartialKey... others) {
    return delegate.allocateId(key, others);
  }

  @Override
  public void add(Entity... entity) {
    delegate.add(entity);
  }

  @Override
  public void update(Entity... entity) {
    delegate.update(entity);
  }

  @Override
  public void put(Entity... entity) {
    delegate.put(entity);
  }

  @Override
  public void delete(Key... key) {
    delegate.delete(key);
  }

  /**
   * Returns a new KeyFactory for this service
   */
  public KeyFactory newKeyFactory() {
    return new KeyFactory(this);
  }

  /**
   * Returns a list with a value for each given key (ordered by input).
   * A {@code null} would be returned for non-existing keys.
   */
  public List<Entity> fetch(Key key, Key... others) {
    Iterator<Entity> entities = delegate.get(key, others);
    Map<Key, Entity> map = Maps.newHashMapWithExpectedSize(1 + others.length);
    while (entities.hasNext()) {
      Entity entity = entities.next();
      map.put(entity.key(), entity);
    }
    List<Entity> list = new ArrayList<>(1 + others.length);
    list.add(map.get(key));
    for (Key other : others) {
      list.add(map.get(other));
    }
    return list;
  }

  public interface RunInTransaction {
    void run(DatastoreReaderWriter readerWriter);
  }

  public void runInTransaction(RunInTransaction runFor, TransactionOption... options) {
    Transaction transaction = newTransaction(options);
    try {
      runFor.run(transaction);
      transaction.commit();
    } finally {
      if (transaction.active()) {
        transaction.rollback();
      }
    }
  }

  public static DatastoreHelper createFor(DatastoreService datastoreService) {
    if (datastoreService instanceof DatastoreHelper) {
      return (DatastoreHelper) datastoreService;
    }
    return new DatastoreHelper(datastoreService);
  }
}
