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

package com.google.cloud.examples.datastore.snippets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.google.cloud.datastore.Batch;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class ITDatastoreSnippets {

  private static Datastore datastore;
  private static DatastoreSnippets datastoreSnippets;

  private final List<Key> registeredKeys = new ArrayList<>();

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Rule public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void beforeClass() {
    datastore = DatastoreOptions.getDefaultInstance().getService();
    datastoreSnippets = new DatastoreSnippets(datastore);
  }

  @After
  public void afterTest() {
    datastore.delete(registeredKeys.toArray(new Key[registeredKeys.size()]));
  }

  private String registerKey(String keyName) {
    return registerKey(keyName, "MyKind");
  }

  private String registerKey(String keyName, String kind) {
    Key key = datastore.newKeyFactory().setKind(kind).newKey(keyName);
    registeredKeys.add(key);
    return key.getName();
  }

  private Map<String, Entity> createEntityMap(List<Entity> entities) {
    Map<String, Entity> entityMap = new HashMap<>();
    for (Entity entity : entities) {
      entityMap.put(entity.getKey().getName(), entity);
    }
    return entityMap;
  }

  private void addEntity(String keyName, String keyClass, String property, String value) {
    Key key = datastore.newKeyFactory().setKind(keyClass).newKey(keyName);
    Entity.Builder entityBuilder = Entity.newBuilder(key);
    entityBuilder.set(property, value);
    Entity entity = entityBuilder.build();
    datastore.put(entity);
  }

  @Test
  public void testRunInTransaction() {
    String testString = "Test String";
    String result = datastoreSnippets.runInTransaction(testString);
    assertEquals(testString, result);
  }

  @Test
  public void testNewBatch() {
    String testKey1 = registerKey("new_batch_key1");
    String testKey2 = registerKey("new_batch_key2");
    Batch batch = datastoreSnippets.newBatch(testKey1, testKey2);
    assertNotNull(batch);
  }

  @Test
  public void testAllocateIdSingle() {
    Key key = datastoreSnippets.allocateIdSingle();
    assertNotNull(key);
  }

  @Test
  public void testAllocateIdMultiple() {
    List<Key> keys = datastoreSnippets.batchAllocateId();
    assertEquals(2, keys.size());
  }

  @Test
  public void testEntityAddGet() {
    String key = registerKey("my_single_key_add");
    datastoreSnippets.addSingleEntity(key);
    Entity entity = datastoreSnippets.getEntityWithKey(key);
    assertEquals("value", entity.getString("propertyName"));
  }

  @Test
  public void testEntityPutGet() {
    String key = registerKey("my_single_key_put");
    datastoreSnippets.putSingleEntity(key);
    Entity entity = datastoreSnippets.getEntityWithKey(key);
    assertEquals("value", entity.getString("propertyName"));
  }

  @Test
  public void testBatchEntityCrud() {
    String key1 = registerKey("batch_key1");
    String key2 = registerKey("batch_key2");

    datastoreSnippets.batchAddEntities(key1, key2);

    assertNotNull(datastoreSnippets.getEntityWithKey(key1));
    assertNotNull(datastoreSnippets.getEntityWithKey(key2));

    datastoreSnippets.batchDeleteEntities(key1, key2);

    assertNull(datastoreSnippets.getEntityWithKey(key1));
    assertNull(datastoreSnippets.getEntityWithKey(key2));

    datastoreSnippets.batchPutEntities(key1, key2);

    assertNotNull(datastoreSnippets.getEntityWithKey(key1));
    assertNotNull(datastoreSnippets.getEntityWithKey(key2));

    List<Entity> entities = Lists.newArrayList(datastoreSnippets.getEntitiesWithKeys(key1, key2));
    assertEquals(2, entities.size());
    Map<String, Entity> entityMap = createEntityMap(entities);
    assertEquals("value1", entityMap.get(key1).getString("propertyName"));
    assertEquals("value2", entityMap.get(key2).getString("propertyName"));

    datastoreSnippets.batchUpdateEntities(key1, key2);

    List<Entity> fetchedEntities = datastoreSnippets.fetchEntitiesWithKeys(key1, key2);
    assertEquals(2, fetchedEntities.size());
    Map<String, Entity> fetchedEntityMap = createEntityMap(fetchedEntities);
    assertEquals("updatedValue1", fetchedEntityMap.get(key1).getString("propertyName"));
    assertEquals("updatedValue2", fetchedEntityMap.get(key2).getString("propertyName"));

    datastoreSnippets.batchDeleteEntities(key1, key2);

    assertNull(datastoreSnippets.getEntityWithKey(key1));
    assertNull(datastoreSnippets.getEntityWithKey(key2));

    List<Entity> fetchedEntities2 = datastoreSnippets.fetchEntitiesWithKeys(key1, key2);
    assertEquals(2, fetchedEntities2.size());
    assertNull(fetchedEntities2.get(0));
    assertNull(fetchedEntities2.get(1));
  }

  @Test
  public void testCreateKeyFactory() {
    KeyFactory keyFactory = datastoreSnippets.createKeyFactory();
    assertNotNull(keyFactory);
  }

  @Test
  public void testRunQuery() {
    String kindToFind = "ClassToFind";
    String kindToMiss = "OtherClass";

    String keyNameToFind = registerKey("my_key_name_to_find", kindToFind);
    String otherKeyNameToFind = registerKey("other_key_name_to_find", kindToFind);
    String keyNameToMiss = registerKey("my_key_name_to_miss", kindToMiss);

    String property = "my_property_name";

    String valueToFind = "my_value_to_find";
    String valueToMiss = "my_value_to_miss";

    addEntity(keyNameToFind, kindToFind, property, valueToFind);
    addEntity(otherKeyNameToFind, kindToFind, property, valueToMiss);
    addEntity(keyNameToMiss, kindToMiss, property, valueToFind);

    List<Entity> queryResults = datastoreSnippets.runQuery(kindToFind);
    assertNotNull(queryResults);
    assertEquals(2, queryResults.size());

    queryResults = datastoreSnippets.runQueryOnProperty(kindToFind, property, valueToFind);
    assertNotNull(queryResults);
    assertEquals(1, queryResults.size());
  }
}
