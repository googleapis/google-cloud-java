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
import com.google.common.collect.Sets;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    datastore = DatastoreOptions.defaultInstance().service();
  }

  @After
  public void afterTest() {
    datastore.delete(registeredKeys.toArray(new Key[registeredKeys.size()]));
  }

  @Test
  public void testGet() {
    Key key1 = datastore.newKeyFactory().setKind("MyKind").newKey("fetch_key_1");
    Entity entity1 = Entity.newBuilder(key1).set("description", "fetch1").build();
    datastore.put(entity1);
    registerKey("fetch_key_1");

    Transaction transaction = datastore.newTransaction();
    TransactionSnippets transactionSnippets = new TransactionSnippets(transaction);
    assertEquals(entity1, transactionSnippets.get("fetch_key_1"));
  }

  @Test
  public void testGetMultiple() {
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
        Sets.newHashSet(transactionSnippets.getMultiple("fetch_key_1", "fetch_key_2"));
    assertEquals(2, entities.size());
    assertTrue(entities.contains(entity1));
    assertTrue(entities.contains(entity2));
  }

  @Test
  public void testFetchEntitiesWithKeys() {
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
  }

  @Test
  public void testRun() {
    Key key1 = datastore.newKeyFactory().setKind("ParentKind").newKey("run_key_1");
    Entity entity1 = Entity.newBuilder(key1).set("description", "run1").build();
    datastore.put(entity1);
    Key key2 = datastore
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
