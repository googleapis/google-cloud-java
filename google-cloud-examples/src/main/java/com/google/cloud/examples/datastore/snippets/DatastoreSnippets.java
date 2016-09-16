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
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.cloud.storage.Blob;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class DatastoreSnippets {
  
  private final Datastore datastore;

  public DatastoreSnippets(Datastore datastore) {
    this.datastore = datastore;
  }
  
  // ANTHONY STARTS HERE
  
  
  
  // ANTHONY ENDS HERE
  
  // GARRETT STARTS HERE
  
  
  
  // GARRETT ENDS HERE
  
  // MIKE STARTS HERE
  
  /**
   * Example of creating a KeyFactory.
   */
  // [TARGET newKeyFactory()]
  public KeyFactory createKeyFactory() {
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
  public Entity getEntityWithKey(String keyName) {
    // [START get]
    Key key = datastore.newKeyFactory().newKey(keyName);
    Entity entity = datastore.get(key);
    // Do something with the entity
    // [END get]
    return entity;
  }
  
  /**
   * Example of getting multiple Entity objects.
   */
  // [TARGET get(Iterable<Key> key, ReadOption... options)]
  // [VARIABLE "my_first_key_name"]
  // [VARIABLE "my_second_key_name"]
  public Iterator<Entity> getEntitiesWithKeys(String firstKeyName, String secondKeyName) {
    // [START get]
    KeyFactory keyFactory = datastore.newKeyFactory();
    Key firstKey = keyFactory.newKey(firstKeyName);
    Key secondKey = keyFactory.newKey(secondKeyName);
    Iterator<Entity> entitiesIterator = datastore.get(Lists.newArrayList(firstKey, secondKey));
    while (entitiesIterator.hasNext()) {
      Entity entity = entitiesIterator.next();
      // do something with the entity
    }
    // [END get]
    return entitiesIterator;
  }
  
  /**
   * Example of fetching a list of Entity objects.
   */
  // [TARGET fetch(Iterable<Key> key, ReadOption... options)]
  // [VARIABLE "my_first_key_name"]
  // [VARIABLE "my_second_key_name"]
  public List<Entity> fetchEntitiesWithKeys(String firstKeyName, String secondKeyName) {
    // [START get]
    KeyFactory keyFactory = datastore.newKeyFactory();
    Key firstKey = keyFactory.newKey(firstKeyName);
    Key secondKey = keyFactory.newKey(secondKeyName);
    List<Entity> entities = datastore.fetch(Lists.newArrayList(firstKey, secondKey));
    for (Entity entity : entities) {
      // do something with the entity
    }
    // [END get]
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
    // [START get]
    Key key = datastore.newKeyFactory().newKey(keyName);
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
    // [END get]
    return results;
  }
  
  // MIKE ENDS HERE
}
