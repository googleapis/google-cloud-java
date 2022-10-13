/*
 * Copyright 2016 Google LLC
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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in Datastore's javadoc. Any change to this file should be reflected in
 * Datastore's javadoc.
 */

package com.google.cloud.examples.datastore.snippets;

import com.google.cloud.datastore.Batch;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Datastore.TransactionCallable;
import com.google.cloud.datastore.DatastoreException;
import com.google.cloud.datastore.DatastoreReaderWriter;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

/** This class contains a number of snippets for the {@link Datastore} interface. */
public class DatastoreSnippets {

  private final Datastore datastore;

  public DatastoreSnippets(Datastore datastore) {
    this.datastore = datastore;
  }

  /** Example of running in a transaction. */
  // [TARGET runInTransaction(TransactionCallable)]
  // [VARIABLE "my_callable_result"]
  public String runInTransaction(final String callableResult) {
    // [START runInTransaction]
    TransactionCallable<String> callable =
        new TransactionCallable<String>() {
          public String run(DatastoreReaderWriter readerWriter) {
            // use readerWriter to run in transaction
            return callableResult;
          }
        };
    String result = datastore.runInTransaction(callable);
    // [END runInTransaction]
    return result;
  }

  /** Example of starting a new batch. */
  // [TARGET newBatch()]
  // [VARIABLE "my_key_name_1"]
  // [VARIABLE "my_key_name_2"]
  public Batch newBatch(String keyName1, String keyName2) {
    // [START newBatch]
    Key key1 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName1);
    Key key2 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName2);
    Batch batch = datastore.newBatch();
    Entity entity1 = Entity.newBuilder(key1).set("name", "John").build();
    Entity entity2 = Entity.newBuilder(key2).set("title", "title").build();
    batch.add(entity1);
    batch.add(entity2);
    batch.submit();
    // [END newBatch]
    return batch;
  }

  /** Example of allocating an id. */
  // [TARGET allocateId(IncompleteKey)]
  public Key allocateIdSingle() {
    // [START allocateIdSingle]
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
    IncompleteKey incompleteKey = keyFactory.newKey();

    // let cloud datastore automatically assign an id
    Key key = datastore.allocateId(incompleteKey);
    // [END allocateIdSingle]
    return key;
  }

  /** Example of allocating multiple ids in a single batch. */
  // [TARGET allocateId(IncompleteKey...)]
  public List<Key> batchAllocateId() {
    // [START batchAllocateId]
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
    IncompleteKey incompleteKey1 = keyFactory.newKey();
    IncompleteKey incompleteKey2 = keyFactory.newKey();

    // let cloud datastore automatically assign the ids
    List<Key> keys = datastore.allocateId(incompleteKey1, incompleteKey2);
    // [END batchAllocateId]
    return keys;
  }

  /** Example of updating multiple entities. */
  // [TARGET update(Entity...)]
  // [VARIABLE "my_key_name_1"]
  // [VARIABLE "my_key_name_2"]
  public void batchUpdateEntities(String keyName1, String keyName2) {
    // [START batchUpdateEntities]
    Key key1 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName1);
    Entity.Builder entityBuilder1 = Entity.newBuilder(key1);
    entityBuilder1.set("propertyName", "updatedValue1");
    Entity entity1 = entityBuilder1.build();

    Key key2 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName2);
    Entity.Builder entityBuilder2 = Entity.newBuilder(key2);
    entityBuilder2.set("propertyName", "updatedValue2");
    Entity entity2 = entityBuilder2.build();

    datastore.update(entity1, entity2);
    // [END batchUpdateEntities]
  }

  /** Example of adding a single entity. */
  // [TARGET add(FullEntity)]
  // [VARIABLE "my_key_name"]
  public void addSingleEntity(String keyName) {
    // [START addSingleEntity]
    Key key = datastore.newKeyFactory().setKind("MyKind").newKey(keyName);
    Entity.Builder entityBuilder = Entity.newBuilder(key);
    entityBuilder.set("propertyName", "value");
    Entity entity = entityBuilder.build();
    try {
      datastore.add(entity);
    } catch (DatastoreException ex) {
      if ("ALREADY_EXISTS".equals(ex.getReason())) {
        // entity.getKey() already exists
      }
    }
    // [END addSingleEntity]
  }

  /** Example of adding multiple entities. */
  // [TARGET add(FullEntity...)]
  // [VARIABLE "my_key_name1"]
  // [VARIABLE "my_key_name2"]
  public void batchAddEntities(String keyName1, String keyName2) {
    // [START batchAddEntities]
    Key key1 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName1);
    Entity.Builder entityBuilder1 = Entity.newBuilder(key1);
    entityBuilder1.set("propertyName", "value1");
    Entity entity1 = entityBuilder1.build();

    Key key2 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName2);
    Entity.Builder entityBuilder2 = Entity.newBuilder(key2);
    entityBuilder2.set("propertyName", "value2");
    Entity entity2 = entityBuilder2.build();

    try {
      datastore.add(entity1, entity2);
    } catch (DatastoreException ex) {
      if ("ALREADY_EXISTS".equals(ex.getReason())) {
        // at least one of entity1.getKey() and entity2.getKey() already exists
      }
    }
    // [END batchAddEntities]
  }

  /** Example of putting a single entity. */
  // [TARGET put(FullEntity)]
  // [VARIABLE "my_key_name"]
  public void putSingleEntity(String keyName) {
    // [START putSingleEntity]
    Key key = datastore.newKeyFactory().setKind("MyKind").newKey(keyName);
    Entity.Builder entityBuilder = Entity.newBuilder(key);
    entityBuilder.set("propertyName", "value");
    Entity entity = entityBuilder.build();
    datastore.put(entity);
    // [END putSingleEntity]
  }

  /** Example of putting multiple entities. */
  // [TARGET put(FullEntity...)]
  // [VARIABLE "my_key_name1"]
  // [VARIABLE "my_key_name2"]
  public void batchPutEntities(String keyName1, String keyName2) {
    // [START batchPutEntities]
    Key key1 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName1);
    Entity.Builder entityBuilder1 = Entity.newBuilder(key1);
    entityBuilder1.set("propertyName", "value1");
    Entity entity1 = entityBuilder1.build();

    Key key2 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName2);
    Entity.Builder entityBuilder2 = Entity.newBuilder(key2);
    entityBuilder2.set("propertyName", "value2");
    Entity entity2 = entityBuilder2.build();

    datastore.put(entity1, entity2);
    // [END batchPutEntities]
  }

  /** Example of deleting multiple entities. */
  // [TARGET delete(Key...)]
  // [VARIABLE "my_key_name1"]
  // [VARIABLE "my_key_name2"]
  public void batchDeleteEntities(String keyName1, String keyName2) {
    // [START batchDeleteEntities]
    Key key1 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName1);
    Key key2 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName2);
    datastore.delete(key1, key2);
    // [END batchDeleteEntities]
  }

  /** Example of creating a {@code KeyFactory}. */
  // [TARGET newKeyFactory()]
  public KeyFactory createKeyFactory() {
    // [START createKeyFactory]
    KeyFactory keyFactory = datastore.newKeyFactory();
    // [END createKeyFactory]
    return keyFactory;
  }

  /** Example of getting an entity. */
  // [TARGET get(Key, ReadOption...)]
  // [VARIABLE "my_key_name"]
  public Entity getEntityWithKey(String keyName) {
    // [START getEntityWithKey]
    Key key = datastore.newKeyFactory().setKind("MyKind").newKey(keyName);
    Entity entity = datastore.get(key);
    // Do something with the entity
    // [END getEntityWithKey]
    return entity;
  }

  /** Example of getting multiple entity objects. */
  // [TARGET get(Iterable, ReadOption...)]
  // [VARIABLE "my_first_key_name"]
  // [VARIABLE "my_second_key_name"]
  public List<Entity> getEntitiesWithKeys(String firstKeyName, String secondKeyName) {
    // TODO change so that it's not necessary to hold the entities in a list for integration testing
    // [START getEntitiesWithKeys]
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
    Key firstKey = keyFactory.newKey(firstKeyName);
    Key secondKey = keyFactory.newKey(secondKeyName);
    Iterator<Entity> entitiesIterator = datastore.get(Lists.newArrayList(firstKey, secondKey));
    List<Entity> entities = Lists.newArrayList();
    while (entitiesIterator.hasNext()) {
      Entity entity = entitiesIterator.next();
      // do something with the entity
      entities.add(entity);
    }
    // [END getEntitiesWithKeys]
    return entities;
  }

  /** Example of fetching a list of Entity objects. */
  // [TARGET fetch(Iterable, ReadOption...)]
  // [VARIABLE "my_first_key_name"]
  // [VARIABLE "my_second_key_name"]
  public List<Entity> fetchEntitiesWithKeys(String firstKeyName, String secondKeyName) {
    // [START fetchEntitiesWithKeys]
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
    Key firstKey = keyFactory.newKey(firstKeyName);
    Key secondKey = keyFactory.newKey(secondKeyName);
    List<Entity> entities = datastore.fetch(Lists.newArrayList(firstKey, secondKey));
    for (Entity entity : entities) {
      // do something with the entity
    }
    // [END fetchEntitiesWithKeys]
    return entities;
  }

  /** Example of running a query to find all entities of one kind. */
  // [TARGET run(Query, ReadOption...)]
  // [VARIABLE "my_kind"]
  public List<Entity> runQuery(String kind) {
    // TODO change so that it's not necessary to hold the entities in a list for integration testing
    // [START runQuery]
    StructuredQuery<Entity> query = Query.newEntityQueryBuilder().setKind(kind).build();
    QueryResults<Entity> results = datastore.run(query);
    List<Entity> entities = Lists.newArrayList();
    while (results.hasNext()) {
      Entity result = results.next();
      // do something with result
      entities.add(result);
    }
    // [END runQuery]
    return entities;
  }

  /** Example of running a query to find all entities with a matching property value. */
  // [TARGET run(Query, ReadOption...)]
  // [VARIABLE "my_kind"]
  // [VARIABLE "my_property"]
  // [VARIABLE "my_value"]
  public List<Entity> runQueryOnProperty(String kind, String property, String value) {
    // TODO change so that it's not necessary to hold the entities in a list for integration testing
    // [START runQueryOnProperty]
    StructuredQuery<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(kind)
            .setFilter(PropertyFilter.eq(property, value))
            .build();
    QueryResults<Entity> results = datastore.run(query);
    List<Entity> entities = Lists.newArrayList();
    while (results.hasNext()) {
      Entity result = results.next();
      // do something with result
      entities.add(result);
    }
    // [END runQueryOnProperty]
    return entities;
  }
}
