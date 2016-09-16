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
* This file is referenced in MyClass’s javadoc. Any change to this file should be reflected in MyClass’s
* javadoc.
*/

package com.google.cloud.examples.datastore.snippets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.common.collect.Lists;
import java.util.Iterator;

public class DatastoreSnippets {

  private final Datastore datastore;

  public DatastoreSnippets(Datastore datastore) {
    this.datastore = datastore;
  }

  // ANTHONY STARTS HERE



  // ANTHONY ENDS HERE

  // GARRETT STARTS HERE

  // [TARGET update(Entity... entities)]
  // [VARIABLE "my_key_name"]
  public void updateEntity(String keyName) {
    // [START updateEntity]
    Key key = datastore.newKeyFactory().newKey(keyName);
    Entity.Builder entityBuilder = Entity.builder(key);
    entityBuilder.set("propertyName", "value");
    Entity entity = entityBuilder.build();
    datastore.update(entity);
    // [END updateEntity]
  }

  // [TARGET put(FullEntity<?> entity)]
  // [VARIABLE "my_key_name"]
  public void putSingleEntity(String keyName) {
    // [START putSingleEntity]
    Key key = datastore.newKeyFactory().newKey(keyName);
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
    Key key1 = datastore.newKeyFactory().newKey(keyName1);
    Entity.Builder entityBuilder1 = Entity.builder(key1);
    entityBuilder1.set("propertyName", "value");
    Entity entity1 = entityBuilder1.build();

    Key key2 = datastore.newKeyFactory().newKey(keyName2);
    Entity.Builder entityBuilder2 = Entity.builder(key2);
    entityBuilder2.set("propertyName", "value");
    Entity entity2 = entityBuilder2.build();

    datastore.put(entity1, entity2);
    // [END batchPutEntities]
  }

  // [TARGET update(Entity... entities)]
  // [VARIABLE "my_key_name1"]
  // [VARIABLE "my_key_name2"]
  public void deleteEntities(String keyName1, String keyName2) {
    // [START deleteEntities]
    Key key1 = datastore.newKeyFactory().newKey(keyName1);
    Key key2 = datastore.newKeyFactory().newKey(keyName2);
    datastore.delete(key1, key2);
    // [END deleteEntities]
  }

  // GARRETT ENDS HERE

  // MIKE STARTS HERE

  /**
   * Example of creating a KeyFactory.
   */
  // [TARGET newKeyFactory()]
  public KeyFactory newKeyFactory() {
    // [START newKeyFactory]
    KeyFactory keyFactory = datastore.newKeyFactory();
    // [END newKeyFactory]
    return keyFactory;
  }

  /**
   * Example of getting an Entity.
   */
  // [TARGET get(Key key, ReadOption... options)]
  // [VARIABLE "my_key_name"]
  public Entity get(String keyName) {
    // [START get]
    Key key = datastore.newKeyFactory().newKey(keyName);
    Entity entity = datastore.get(key);
    // [END get]
    return entity;
  }

  /**
   * Example of getting multiple entities
   */
  // [TARGET get(Key key, ReadOption... options)]
  // [VARIABLE "my_first_key_name"]
  //[VARIABLE "my_second_key_name"]
  public Iterator<Entity> get(String firstKeyName, String secondKeyName) {
    // [START get]
    Key firstKey = datastore.newKeyFactory().newKey(firstKeyName);
    Key secondKey = datastore.newKeyFactory().newKey(secondKeyName);
    Iterator<Entity> entities = datastore.get(Lists.newArrayList(firstKey, secondKey));
    // [END get]
    return entities;
  }

  //fetch(Iterable<Key> keys, ReadOption... options)
  //run(Query<T> query, ReadOption... options)

  // MIKE ENDS HERE
}
