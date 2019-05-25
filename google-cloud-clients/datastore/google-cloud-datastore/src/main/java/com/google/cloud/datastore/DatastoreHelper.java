/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore;

import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Provide functionality that should be added to the appropriate interfaces via Java 8 default
 * methods.
 */
class DatastoreHelper {

  private DatastoreHelper() {}

  static Key allocateId(Datastore service, IncompleteKey key) {
    return service.allocateId(new IncompleteKey[] {key}).get(0);
  }

  static Entity get(Transaction reader, Key key) {
    return Iterators.getNext(reader.get(new Key[] {key}), null);
  }

  static Entity get(Datastore reader, Key key, ReadOption... options) {
    return Iterators.getNext(reader.get(Collections.singletonList(key), options), null);
  }

  static Entity add(DatastoreWriter writer, FullEntity<?> entity) {
    return writer.add(new FullEntity<?>[] {entity}).get(0);
  }

  static Entity put(DatastoreWriter writer, FullEntity<?> entity) {
    return writer.put(new FullEntity<?>[] {entity}).get(0);
  }

  static KeyFactory newKeyFactory(DatastoreOptions options) {
    return new KeyFactory(options.getProjectId(), options.getNamespace());
  }

  /**
   * Returns a list with a value for each given key (ordered by input). {@code null} values are
   * returned for nonexistent keys.
   */
  static List<Entity> fetch(Transaction reader, Key... keys) {
    return compileEntities(keys, reader.get(keys));
  }

  /**
   * Returns a list with a value for each given key (ordered by input). {@code null} values are
   * returned for nonexistent keys.
   */
  static List<Entity> fetch(Datastore reader, Key[] keys, ReadOption... options) {
    return compileEntities(keys, reader.get(Arrays.asList(keys), options));
  }

  private static List<Entity> compileEntities(Key[] keys, Iterator<Entity> entities) {
    Map<Key, Entity> map = Maps.newHashMapWithExpectedSize(keys.length);
    while (entities.hasNext()) {
      Entity entity = entities.next();
      map.put(entity.getKey(), entity);
    }
    List<Entity> list = new ArrayList<>(keys.length);
    for (Key key : keys) {
      // this will include nulls for nonexistent keys
      list.add(map.get(key));
    }
    return list;
  }
}
