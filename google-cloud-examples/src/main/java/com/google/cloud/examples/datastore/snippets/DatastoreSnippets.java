/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import com.google.cloud.datastore.Datastore;
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

/**
 * This class contains a number of snippets for the {@link Datastore} interface.
 */
public class DatastoreSnippets {

  private final Datastore datastore;

  public DatastoreSnippets(Datastore datastore) {
    this.datastore = datastore;
  }

  // ANTHONY STARTS HERE


  /**
   * Example of allocating an id
   */
  // [TARGET allocateId(IncompleteKey key)]
  public Key allocateIdSingle() {
    // [START allocateIdSingle]
    KeyFactory keyFactory = datastore.newKeyFactory().kind("MyClass");
    IncompleteKey incompleteKey = keyFactory.newKey();

    // let cloud datastore automatically assign an id
    Key key = datastore.allocateId(incompleteKey);
    // [END allocateIdSingle]
    return key;
  }

  /**
   * Example of allocating multiple ids
   */
  // [TARGET allocateId(IncompleteKey... keys)]
  public List<Key> allocateIdMultiple() {
    // [START allocateIdMultiple]
    KeyFactory keyFactory = datastore.newKeyFactory().kind("MyClass");
    IncompleteKey incompleteKey1 = keyFactory.newKey();
    IncompleteKey incompleteKey2 = keyFactory.newKey();

    // let cloud datastore automatically assign the ids
    List<Key> keys = datastore.allocateId(incompleteKey1, incompleteKey2);
    // [END allocateIdMultiple]
    return keys;
  }
  // ANTHONY ENDS HERE

  // GARRETT STARTS HERE

  // [TARGET update(Entity... entities)]
  // [VARIABLE "my_key_name"]
  public void batchUpdateEntities(String keyName1, String keyName2) {
    // [START batchUpdateEntities]
    Key key1 = datastore.newKeyFactory().kind("MyClass").newKey(keyName1);
    Entity.Builder entityBuilder1 = Entity.builder(key1);
    entityBuilder1.set("propertyName", "updatedValue1");
    Entity entity1 = entityBuilder1.build();

    Key key2 = datastore.newKeyFactory().kind("MyClass").newKey(keyName2);
    Entity.Builder entityBuilder2 = Entity.builder(key2);
    entityBuilder2.set("propertyName", "updatedValue2");
    Entity entity2 = entityBuilder2.build();

    datastore.update(entity1, entity2);
    // [END batchUpdateEntities]
  }

  // [TARGET put(FullEntity<?> entity)]
  // [VARIABLE "my_key_name"]
  public void putSingleEntity(String keyName) {
    // [START putSingleEntity]
    Key key = datastore.newKeyFactory().kind("MyClass").newKey(keyName);
    Entity.Builder entityBuilder = Entity.builder(key);
    entityBuilder.set("propertyName", "value");
    Entity entity = entityBuilder.build();
    datastore.put(entity);
    // [END putSingleEntity]
  }

  // [TARGET put(FullEntity<?>... entity)]
  // [VARIABLE "my_key_name1"]
  // [VARIABLE "my_key_name2"]
  public void batchPutEntities(String keyName1, String keyName2) {
    // [START batchPutEntities]
    Key key1 = datastore.newKeyFactory().kind("MyClass").newKey(keyName1);
    Entity.Builder entityBuilder1 = Entity.builder(key1);
    entityBuilder1.set("propertyName", "value1");
    Entity entity1 = entityBuilder1.build();

    Key key2 = datastore.newKeyFactory().kind("MyClass").newKey(keyName2);
    Entity.Builder entityBuilder2 = Entity.builder(key2);
    entityBuilder2.set("propertyName", "value2");
    Entity entity2 = entityBuilder2.build();

    datastore.put(entity1, entity2);
    // [END batchPutEntities]
  }

  // [TARGET delete(Key... keys)]
  // [VARIABLE "my_key_name1"]
  // [VARIABLE "my_key_name2"]
  public void batchDeleteEntities(String keyName1, String keyName2) {
    // [START batchDeleteEntities]
    Key key1 = datastore.newKeyFactory().kind("MyClass").newKey(keyName1);
    Key key2 = datastore.newKeyFactory().kind("MyClass").newKey(keyName2);
    datastore.delete(key1, key2);
    // [END batchDeleteEntities]
  }

  // GARRETT ENDS HERE

  // MIKE STARTS HERE

  /**
   * Example of creating a KeyFactory.
   */
  // [TARGET newKeyFactory()]
  public KeyFactory createKeyFactory() {
    // [START createKeyFactory]
    KeyFactory keyFactory = datastore.newKeyFactory();
    // [END createKeyFactory]
    return keyFactory;
  }

  /**
   * Example of getting an Entity.
   */
  // [TARGET get(Key key, ReadOption... options)]
  // [VARIABLE "my_key_name"]
  public Entity getEntityWithKey(String keyName) {
    // [START getEntityWithKey]
    Key key = datastore.newKeyFactory().kind("MyClass").newKey(keyName);
    Entity entity = datastore.get(key);
    // Do something with the entity
    // [END getEntityWithKey]
    return entity;
  }

  /**
   * Example of getting multiple Entity objects.
   */
  // [TARGET get(Iterable<Key> key, ReadOption... options)]
  // [VARIABLE "my_first_key_name"]
  // [VARIABLE "my_second_key_name"]
  public List<Entity> getEntitiesWithKeys(String firstKeyName, String secondKeyName) {
    // [START getEntitiesWithKeys]
    KeyFactory keyFactory = datastore.newKeyFactory().kind("MyClass");
    Key firstKey = keyFactory.newKey(firstKeyName);
    Key secondKey = keyFactory.newKey(secondKeyName);
    Iterator<Entity> entitiesIterator = datastore.get(Lists.newArrayList(firstKey, secondKey));
    // TODO make a change so that it's not necessary to hold the entities in a list for
    // integration testing
    List<Entity> entities = Lists.newArrayList();
    while (entitiesIterator.hasNext()) {
      Entity entity = entitiesIterator.next();
      // do something with the entity
      entities.add(entity);
    }
    // [END getEntitiesWithKeys]
    return entities;
  }

  /**
   * Example of fetching a list of Entity objects.
   */
  // [TARGET fetch(Iterable<Key> key, ReadOption... options)]
  // [VARIABLE "my_first_key_name"]
  // [VARIABLE "my_second_key_name"]
  public List<Entity> fetchEntitiesWithKeys(String firstKeyName, String secondKeyName) {
    // [START fetchEntitiesWithKeys]
    KeyFactory keyFactory = datastore.newKeyFactory().kind("MyClass");
    Key firstKey = keyFactory.newKey(firstKeyName);
    Key secondKey = keyFactory.newKey(secondKeyName);
    List<Entity> entities = datastore.fetch(Lists.newArrayList(firstKey, secondKey));
    for (Entity entity : entities) {
      // do something with the entity
    }
    // [END fetchEntitiesWithKeys]
    return entities;
  }

  /**
   * Example of running a query.
   */
  // [TARGET run(Query<T> query, ReadOption... options)]
  // [VARIABLE "my_key_name"]
  // [VARIABLE "my_query_kind"]
  // [VARIABLE "my_query_namespace"]
  public QueryResults<Entity> runQuery(String keyName, String queryKind, String queryNamespace) {
    // [START runQuery]
    Key key = datastore.newKeyFactory().kind("MyClass").newKey(keyName);
    StructuredQuery<Entity> query =
        Query.entityQueryBuilder()
            .namespace(queryNamespace)
            .kind(queryKind)
            .filter(PropertyFilter.hasAncestor(key))
            .build();
    QueryResults<Entity> results = datastore.run(query);
    while (results.hasNext()) {
      Entity result = results.next();
      // do something with result
    }
    // [END runQuery]
    return results;
  }

  // MIKE ENDS HERE
}
