/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.datastore;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Adds some functionality to DatastoreService that should
 * be provided statically to the interface (Java 8).
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
  public Iterator<Entity> get(Key... key) {
    return delegate.get(key);
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
  public Batch newBatch(BatchOption... options) {
    return delegate.newBatch(options);
  }

  @Override
  public Key allocateId(PartialKey key) {
    return delegate.allocateId(key);
  }

  @Override
  public List<Key> allocateId(PartialKey... key) {
    return delegate.allocateId(key);
  }

  @Override
  public Entity add(PartialEntity entity) {
    return delegate.add(entity);
  }

  @Override
  public List<Entity> add(PartialEntity... entity) {
    return delegate.add(entity);
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
    return new KeyFactory(delegate);
  }

  /**
   * Returns a list with a value for each given key (ordered by input).
   * A {@code null} would be returned for non-existing keys.
   */
  public List<Entity> fetch(Key... keys) {
    Iterator<Entity> entities = delegate.get(keys);
    Map<Key, Entity> map = Maps.newHashMapWithExpectedSize(keys.length);
    while (entities.hasNext()) {
      Entity entity = entities.next();
      map.put(entity.key(), entity);
    }
    List<Entity> list = new ArrayList<>(keys.length);
    for (Key key : keys) {
      // this will include nulls for non-existing keys
      list.add(map.get(key));
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
