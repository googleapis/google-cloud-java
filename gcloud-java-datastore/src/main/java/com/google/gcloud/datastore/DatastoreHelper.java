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

import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Provide functionality that should be added to the appropriate interfaces
 * via Java 8 default methods.
 */
class DatastoreHelper {

  private DatastoreHelper() {
  }


  static Key allocateId(Datastore service, IncompleteKey key) {
    return service.allocateId(new IncompleteKey[]{key}).get(0);
  }

  static Entity get(DatastoreReader reader, Key key) {
    return Iterators.getNext(reader.get(new Key[]{key}), null);
  }

  static Entity add(DatastoreWriter writer, FullEntity<?> entity) {
    return writer.add(new FullEntity<?>[] {entity}).get(0);
  }

  static KeyFactory newKeyFactory(DatastoreOptions options) {
    return new KeyFactory(options.projectId(), options.namespace());
  }

  /**
   * Returns a list with a value for each given key (ordered by input).
   * A {@code null} would be returned for non-existing keys.
   */
  static List<Entity> fetch(DatastoreReader reader, Key... keys) {
    Iterator<Entity> entities = reader.get(keys);
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

  static <T> T runInTransaction(Datastore datastore,
      Datastore.TransactionCallable<T> callable, TransactionOption... options) {
    Transaction transaction = datastore.newTransaction(options);
    try {
      T value = callable.run(transaction);
      transaction.commit();
      return value;
    } catch (Exception ex) {
      transaction.rollback();
      throw DatastoreException.propagateUserException(ex);
    } finally {
      if (transaction.active()) {
        transaction.rollback();
      }
    }
  }
}
