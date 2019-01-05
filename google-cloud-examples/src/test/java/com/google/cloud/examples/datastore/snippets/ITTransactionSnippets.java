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
import static org.junit.Assert.assertTrue;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.PathElement;
import com.google.cloud.datastore.Transaction;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITTransactionSnippets {

  private static Datastore datastore;

  private final List<Key> registeredKeys = new ArrayList<>();

  private String registerKey(Key key) {
    registeredKeys.add(key);
    return key.getName();
  }

  private String registerKey(String keyName) {
    return registerKey(keyName, "MyKind");
  }

  private String registerKey(String keyName, String kind) {
    Key key = datastore.newKeyFactory().setKind(kind).newKey(keyName);
    registeredKeys.add(key);
    return key.getName();
  }

  @BeforeClass
  public static void beforeClass() {
    datastore = DatastoreOptions.getDefaultInstance().getService();
  }

  @After
  public void afterTest() {
    datastore.delete(registeredKeys.toArray(new Key[registeredKeys.size()]));
  }

  @Test
  public void testEntityAddGet() {
    Transaction transaction = datastore.newTransaction();
    TransactionSnippets transactionSnippets = new TransactionSnippets(transaction);
    transactionSnippets.addSingleEntity(registerKey("add_get_key"));

    transaction = datastore.newTransaction();
    transactionSnippets = new TransactionSnippets(transaction);
    Entity entity = transactionSnippets.get("add_get_key");
    assertEquals("value", entity.getString("propertyName"));
  }

  @Test
  public void testEntityPutGet() {
    Transaction transaction = datastore.newTransaction();
    TransactionSnippets transactionSnippets = new TransactionSnippets(transaction);
    transactionSnippets.putSingleEntity(registerKey("put_get_key"));

    transaction = datastore.newTransaction();
    transactionSnippets = new TransactionSnippets(transaction);
    Entity entity = transactionSnippets.get("put_get_key");
    assertEquals("value", entity.getString("propertyName"));
  }

  @Test
  public void testAddGetUpdateMultiple() {
    Transaction transaction = datastore.newTransaction();
    TransactionSnippets transactionSnippets = new TransactionSnippets(transaction);
    transactionSnippets.multipleAddEntities(
        registerKey("add_get_multiple_key_1"), registerKey("add_get_multiple_key_2"));

    transaction = datastore.newTransaction();
    transactionSnippets = new TransactionSnippets(transaction);
    List<Entity> entities =
        transactionSnippets.getMultiple("add_get_multiple_key_1", "add_get_multiple_key_2");
    assertEquals(2, entities.size());
    Set<String> values =
        ImmutableSet.of(
            entities.get(0).getString("propertyName"), entities.get(1).getString("propertyName"));
    assertTrue(values.contains("value1"));
    assertTrue(values.contains("value2"));

    transaction = datastore.newTransaction();
    transactionSnippets = new TransactionSnippets(transaction);
    transactionSnippets.multipleUpdateEntities(
        registerKey("add_get_multiple_key_1"), registerKey("add_get_multiple_key_2"));

    transaction = datastore.newTransaction();
    transactionSnippets = new TransactionSnippets(transaction);
    entities = transactionSnippets.getMultiple("add_get_multiple_key_1", "add_get_multiple_key_2");
    assertEquals(2, entities.size());
    values =
        ImmutableSet.of(
            entities.get(0).getString("propertyName"), entities.get(1).getString("propertyName"));
    assertTrue(values.contains("value3"));
    assertTrue(values.contains("value4"));
  }

  @Test
  public void testAddGetMultipleDeferredId() {
    Transaction transaction = datastore.newTransaction();
    TransactionSnippets transactionSnippets = new TransactionSnippets(transaction);
    List<Key> keys = transactionSnippets.multipleAddEntitiesDeferredId();
    assertEquals(2, keys.size());
    Key key1 = keys.get(0);
    registerKey(key1);
    Entity entity1 = datastore.get(key1);
    assertEquals("value1", entity1.getString("propertyName"));
    Key key2 = keys.get(1);
    registerKey(key2);
    Entity entity2 = datastore.get(key2);
    assertEquals("value2", entity2.getString("propertyName"));
  }

  @Test
  public void testPutGetMultiple() {
    Transaction transaction = datastore.newTransaction();
    TransactionSnippets transactionSnippets = new TransactionSnippets(transaction);
    transactionSnippets.multipleAddEntities(
        registerKey("add_get_multiple_key_1"), registerKey("put_get_multiple_key_2"));

    transaction = datastore.newTransaction();
    transactionSnippets = new TransactionSnippets(transaction);
    List<Entity> entities =
        transactionSnippets.getMultiple("add_get_multiple_key_1", "put_get_multiple_key_2");
    assertEquals(2, entities.size());
    Set<String> values =
        ImmutableSet.of(
            entities.get(0).getString("propertyName"), entities.get(1).getString("propertyName"));
    assertTrue(values.contains("value1"));
    assertTrue(values.contains("value2"));
  }

  @Test
  public void testPutGetMultipleDeferredId() {
    Transaction transaction = datastore.newTransaction();
    TransactionSnippets transactionSnippets = new TransactionSnippets(transaction);
    List<Key> keys = transactionSnippets.multiplePutEntitiesDeferredId();
    assertEquals(2, keys.size());
    Key key1 = keys.get(0);
    registerKey(key1);
    Entity entity1 = datastore.get(key1);
    assertEquals("value1", entity1.getString("propertyName"));
    Key key2 = keys.get(1);
    registerKey(key2);
    Entity entity2 = datastore.get(key2);
    assertEquals("value2", entity2.getString("propertyName"));
  }

  @Test
  public void testFetchDeleteEntitiesWithKeys() {
    Key key1 = datastore.newKeyFactory().setKind("MyKind").newKey("fetch_key_1");
    Key key2 = datastore.newKeyFactory().setKind("MyKind").newKey("fetch_key_2");
    Entity entity1 = Entity.newBuilder(key1).set("description", "fetch1").build();
    Entity entity2 = Entity.newBuilder(key2).set("description", "fetch2").build();
    datastore.put(entity1, entity2);
    registerKey("fetch_key_1");
    registerKey("fetch_key_2");

    Transaction transaction = datastore.newTransaction();
    TransactionSnippets transactionSnippets = new TransactionSnippets(transaction);
    Set<Entity> entities =
        Sets.newHashSet(transactionSnippets.fetchEntitiesWithKeys("fetch_key_1", "fetch_key_2"));
    assertEquals(2, entities.size());
    assertTrue(entities.contains(entity1));
    assertTrue(entities.contains(entity2));

    transaction = datastore.newTransaction();
    transactionSnippets = new TransactionSnippets(transaction);
    transactionSnippets.multipleDeleteEntities("fetch_key_1", "fetch_key_2");

    transaction = datastore.newTransaction();
    transactionSnippets = new TransactionSnippets(transaction);
    List<Entity> deletedEntities =
        transactionSnippets.fetchEntitiesWithKeys("fetch_key_1", "fetch_key_2");
    assertNull(deletedEntities.get(0));
    assertNull(deletedEntities.get(1));
  }

  @Test
  public void testRun() {
    Key key1 = datastore.newKeyFactory().setKind("ParentKind").newKey("run_key_1");
    Entity entity1 = Entity.newBuilder(key1).set("description", "run1").build();
    datastore.put(entity1);
    Key key2 =
        datastore
            .newKeyFactory()
            .setKind("MyKind")
            .addAncestor(PathElement.of("ParentKind", "run_key_1"))
            .newKey("run_key_2");
    registerKey(key1);
    registerKey(key2);
    Entity entity2 = Entity.newBuilder(key2).set("description", "run2").build();
    datastore.put(entity2);

    Transaction transaction = datastore.newTransaction();
    TransactionSnippets transactionSnippets = new TransactionSnippets(transaction);
    List<Entity> entities = transactionSnippets.run("run_key_1");
    assertEquals(1, entities.size());
    assertEquals(entity2, entities.get(0));
  }

  @Test
  public void testCommit() {
    Transaction transaction = datastore.newTransaction();
    TransactionSnippets transactionSnippets = new TransactionSnippets(transaction);
    Key key = transactionSnippets.commit();
    Entity result = datastore.get(key);
    assertNotNull(result);
    datastore.delete(key);
  }

  @Test
  public void testRollback() {
    Transaction transaction = datastore.newTransaction();
    TransactionSnippets transactionSnippets = new TransactionSnippets(transaction);
    Key key = transactionSnippets.rollback();
    Entity result = datastore.get(key);
    assertNull(result);
  }

  @Test
  public void testActive() {
    Transaction transaction = datastore.newTransaction();
    TransactionSnippets transactionSnippets = new TransactionSnippets(transaction);
    Key key = transactionSnippets.active();
    Entity result = datastore.get(key);
    assertNotNull(result);
    datastore.delete(key);
  }

  @Test
  public void testIsActive() {
    Transaction transaction = datastore.newTransaction();
    TransactionSnippets transactionSnippets = new TransactionSnippets(transaction);
    Key key = transactionSnippets.isActive();
    Entity result = datastore.get(key);
    assertNotNull(result);
    datastore.delete(key);
  }
}
