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
 * This file is referenced in Transaction's javadoc. Any change to this file should be reflected in
 * Transaction's javadoc.
 */

package com.google.cloud.examples.datastore.snippets;

import com.google.api.client.util.Lists;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreException;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.cloud.datastore.Transaction;
import com.google.cloud.datastore.Transaction.Response;
import java.util.Iterator;
import java.util.List;

/** This class contains a number of snippets for the {@link Transaction} interface. */
public class TransactionSnippets {

  private final Transaction transaction;

  public TransactionSnippets(Transaction transaction) {
    this.transaction = transaction;
  }

  /** Example of getting an entity for a given key. */
  // [TARGET get(Key)]
  // [VARIABLE "my_key_name"]
  public Entity get(String keyName) {
    Datastore datastore = transaction.getDatastore();
    // [START get]
    Key key = datastore.newKeyFactory().setKind("MyKind").newKey(keyName);
    Entity entity = transaction.get(key);
    transaction.commit();
    // Do something with the entity
    // [END get]
    return entity;
  }

  /** Example of getting entities for several keys. */
  // [TARGET get(Key...)]
  // [VARIABLE "my_first_key_name"]
  // [VARIABLE "my_second_key_name"]
  public List<Entity> getMultiple(String firstKeyName, String secondKeyName) {
    Datastore datastore = transaction.getDatastore();
    // TODO change so that it's not necessary to hold the entities in a list for integration testing
    // [START getMultiple]
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
    Key firstKey = keyFactory.newKey(firstKeyName);
    Key secondKey = keyFactory.newKey(secondKeyName);
    Iterator<Entity> entitiesIterator = transaction.get(firstKey, secondKey);
    List<Entity> entities = Lists.newArrayList();
    while (entitiesIterator.hasNext()) {
      Entity entity = entitiesIterator.next();
      // do something with the entity
      entities.add(entity);
    }
    transaction.commit();
    // [END getMultiple]
    return entities;
  }

  /** Example of fetching a list of entities for several keys. */
  // [TARGET fetch(Key...)]
  // [VARIABLE "my_first_key_name"]
  // [VARIABLE "my_second_key_name"]
  public List<Entity> fetchEntitiesWithKeys(String firstKeyName, String secondKeyName) {
    Datastore datastore = transaction.getDatastore();
    // [START fetchEntitiesWithKeys]
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
    Key firstKey = keyFactory.newKey(firstKeyName);
    Key secondKey = keyFactory.newKey(secondKeyName);
    List<Entity> entities = transaction.fetch(firstKey, secondKey);
    for (Entity entity : entities) {
      // do something with the entity
    }
    transaction.commit();
    // [END fetchEntitiesWithKeys]
    return entities;
  }

  /** Example of running a query to find all entities with an ancestor. */
  // [TARGET run(Query)]
  // [VARIABLE "my_parent_key_name"]
  public List<Entity> run(String parentKeyName) {
    Datastore datastore = transaction.getDatastore();
    // [START run]
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("ParentKind");
    Key parentKey = keyFactory.newKey(parentKeyName);
    // Build a query
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind("MyKind")
            .setFilter(PropertyFilter.hasAncestor(parentKey))
            .build();
    QueryResults<Entity> results = transaction.run(query);
    List<Entity> entities = Lists.newArrayList();
    while (results.hasNext()) {
      Entity result = results.next();
      // do something with result
      entities.add(result);
    }
    transaction.commit();
    // [END run]
    return entities;
  }

  /** Example of adding a single entity. */
  // [TARGET add(FullEntity)]
  // [VARIABLE "my_key_name"]
  public void addSingleEntity(String keyName) {
    Datastore datastore = transaction.getDatastore();
    // [START addSingleEntity]
    Key key = datastore.newKeyFactory().setKind("MyKind").newKey(keyName);
    Entity.Builder entityBuilder = Entity.newBuilder(key);
    entityBuilder.set("propertyName", "value");
    Entity entity = entityBuilder.build();
    transaction.add(entity);
    transaction.commit();
    // [END addSingleEntity]
  }

  /** Example of adding multiple entities. */
  // [TARGET add(FullEntity...)]
  // [VARIABLE "my_key_name1"]
  // [VARIABLE "my_key_name2"]
  public void multipleAddEntities(String keyName1, String keyName2) {
    Datastore datastore = transaction.getDatastore();
    // [START multipleAddEntities]
    Key key1 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName1);
    Entity.Builder entityBuilder1 = Entity.newBuilder(key1);
    entityBuilder1.set("propertyName", "value1");
    Entity entity1 = entityBuilder1.build();

    Key key2 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName2);
    Entity.Builder entityBuilder2 = Entity.newBuilder(key2);
    entityBuilder2.set("propertyName", "value2");
    Entity entity2 = entityBuilder2.build();

    transaction.add(entity1, entity2);
    transaction.commit();
    // [END multipleAddEntities]
  }

  /** Example of updating multiple entities. */
  // [TARGET update(Entity...)]
  // [VARIABLE "my_key_name1"]
  // [VARIABLE "my_key_name2"]
  public void multipleUpdateEntities(String keyName1, String keyName2) {
    Datastore datastore = transaction.getDatastore();
    // [START multipleUpdateEntities]
    Key key1 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName1);
    Entity.Builder entityBuilder1 = Entity.newBuilder(key1);
    entityBuilder1.set("propertyName", "value3");
    Entity entity1 = entityBuilder1.build();

    Key key2 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName2);
    Entity.Builder entityBuilder2 = Entity.newBuilder(key2);
    entityBuilder2.set("propertyName", "value4");
    Entity entity2 = entityBuilder2.build();

    transaction.update(entity1, entity2);
    transaction.commit();
    // [END multipleUpdateEntities]
  }

  /** Example of adding multiple entities with deferred id allocation. */
  // [TARGET addWithDeferredIdAllocation(FullEntity...)]
  public List<Key> multipleAddEntitiesDeferredId() {
    Datastore datastore = transaction.getDatastore();
    // [START multipleAddEntitiesDeferredId]
    IncompleteKey key1 = datastore.newKeyFactory().setKind("MyKind").newKey();
    FullEntity.Builder entityBuilder1 = FullEntity.newBuilder(key1);
    entityBuilder1.set("propertyName", "value1");
    FullEntity entity1 = entityBuilder1.build();

    IncompleteKey key2 = datastore.newKeyFactory().setKind("MyKind").newKey();
    FullEntity.Builder entityBuilder2 = FullEntity.newBuilder(key2);
    entityBuilder2.set("propertyName", "value2");
    FullEntity entity2 = entityBuilder2.build();

    transaction.addWithDeferredIdAllocation(entity1, entity2);
    Response response = transaction.commit();
    // [END multipleAddEntitiesDeferredId]
    return response.getGeneratedKeys();
  }

  /** Example of putting multiple entities with deferred id allocation. */
  // [TARGET putWithDeferredIdAllocation(FullEntity...)]
  public List<Key> multiplePutEntitiesDeferredId() {
    Datastore datastore = transaction.getDatastore();
    // [START multiplePutEntitiesDeferredId]
    IncompleteKey key1 = datastore.newKeyFactory().setKind("MyKind").newKey();
    FullEntity.Builder entityBuilder1 = FullEntity.newBuilder(key1);
    entityBuilder1.set("propertyName", "value1");
    FullEntity entity1 = entityBuilder1.build();

    IncompleteKey key2 = datastore.newKeyFactory().setKind("MyKind").newKey();
    FullEntity.Builder entityBuilder2 = FullEntity.newBuilder(key2);
    entityBuilder2.set("propertyName", "value2");
    FullEntity entity2 = entityBuilder2.build();

    transaction.putWithDeferredIdAllocation(entity1, entity2);
    Response response = transaction.commit();
    // [END multiplePutEntitiesDeferredId]
    return response.getGeneratedKeys();
  }

  /** Example of deleting multiple entities. */
  // [TARGET delete(Key...)]
  // [VARIABLE "my_key_name1"]
  // [VARIABLE "my_key_name2"]
  public void multipleDeleteEntities(String keyName1, String keyName2) {
    Datastore datastore = transaction.getDatastore();
    // [START multipleDeleteEntities]
    Key key1 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName1);
    Key key2 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName2);
    transaction.delete(key1, key2);
    transaction.commit();
    // [END multipleDeleteEntities]
  }

  /** Example of putting a single entity. */
  // [TARGET put(FullEntity)]
  // [VARIABLE "my_key_name"]
  public void putSingleEntity(String keyName) {
    Datastore datastore = transaction.getDatastore();
    // [START putSingleEntity]
    Key key = datastore.newKeyFactory().setKind("MyKind").newKey(keyName);
    Entity.Builder entityBuilder = Entity.newBuilder(key);
    entityBuilder.set("propertyName", "value");
    Entity entity = entityBuilder.build();
    transaction.put(entity);
    transaction.commit();
    // [END putSingleEntity]
  }

  /** Example of putting multiple entities. */
  // [TARGET put(FullEntity...)]
  // [VARIABLE "my_key_name1"]
  // [VARIABLE "my_key_name2"]
  public void multiplePutEntities(String keyName1, String keyName2) {
    Datastore datastore = transaction.getDatastore();
    // [START multiplePutEntities]
    Key key1 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName1);
    Entity.Builder entityBuilder1 = Entity.newBuilder(key1);
    entityBuilder1.set("propertyName", "value1");
    Entity entity1 = entityBuilder1.build();

    Key key2 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName2);
    Entity.Builder entityBuilder2 = Entity.newBuilder(key2);
    entityBuilder2.set("propertyName", "value2");
    Entity entity2 = entityBuilder2.build();

    transaction.put(entity1, entity2);
    transaction.commit();
    // [END multiplePutEntities]
  }

  /** Example of committing a transaction. */
  // [TARGET commit()]
  public Key commit() {
    Datastore datastore = transaction.getDatastore();
    // [START commit]
    // create an entity
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
    Key key = datastore.allocateId(keyFactory.newKey());
    Entity entity = Entity.newBuilder(key).set("description", "commit()").build();

    // add the entity and commit
    try {
      transaction.put(entity);
      transaction.commit();
    } catch (DatastoreException ex) {
      // handle exception
    }
    // [END commit]

    return key;
  }

  /** Example of rolling back a transaction. */
  // [TARGET rollback()]
  public Key rollback() {
    Datastore datastore = transaction.getDatastore();
    // [START rollback]
    // create an entity
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
    Key key = datastore.allocateId(keyFactory.newKey());
    Entity entity = Entity.newBuilder(key).set("description", "rollback()").build();

    // add the entity and rollback
    transaction.put(entity);
    transaction.rollback();
    // calling transaction.commit() now would fail
    // [END rollback]
    return key;
  }

  /** Example of verifying if a transaction is active. */
  // [TARGET active()]
  public Key active() {
    Datastore datastore = transaction.getDatastore();
    // [START active]
    // create an entity
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
    Key key = datastore.allocateId(keyFactory.newKey());
    Entity entity = Entity.newBuilder(key).set("description", "active()").build();
    // calling transaction.active() now would return true
    try {
      // add the entity and commit
      transaction.put(entity);
      transaction.commit();
    } finally {
      // if committing succeeded
      // then transaction.isActive() will be false
      if (transaction.isActive()) {
        // otherwise it's true and we need to rollback
        transaction.rollback();
      }
    }
    // [END active]
    return key;
  }

  /** Example of verifying if a transaction is active. */
  // [TARGET isActive()]
  public Key isActive() {
    Datastore datastore = transaction.getDatastore();
    // [START isActive]
    // create an entity
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
    Key key = datastore.allocateId(keyFactory.newKey());
    Entity entity = Entity.newBuilder(key).set("description", "active()").build();
    // calling transaction.active() now would return true
    try {
      // add the entity and commit
      transaction.put(entity);
      transaction.commit();
    } finally {
      // if committing succeeded
      // then transaction.active() will be false
      if (transaction.isActive()) {
        // otherwise it's true and we need to rollback
        transaction.rollback();
      }
    }
    // [END isActive]
    return key;
  }
}
