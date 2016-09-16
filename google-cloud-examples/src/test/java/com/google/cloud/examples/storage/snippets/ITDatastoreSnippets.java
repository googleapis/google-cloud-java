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

package com.google.cloud.examples.storage.snippets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.examples.datastore.snippets.DatastoreSnippets;
import com.google.cloud.storage.testing.RemoteStorageHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import autovalue.shaded.com.google.common.common.collect.Lists;

public class ITDatastoreSnippets {

  private static final String KEY = "my_key_name";
  private static final String FIRST_KEY = "first_key_name";
  private static final String SECOND_KEY = "second_key_name";
  private static final String QUERY_KIND = "kind";
  private static final String NAMESPACE = "";

  private static Datastore datastore;
  private static DatastoreSnippets datastoreSnippets;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void beforeClass() {
    datastore = DatastoreOptions.defaultInstance().service();
    datastoreSnippets = new DatastoreSnippets(datastore);
  }

  @AfterClass
  public static void afterClass() throws ExecutionException, InterruptedException {
    // TODO: do the right work for Datastore, similar to the Storage code below
//    if (storage != null) {
//      boolean wasDeleted = RemoteStorageHelper.forceDelete(storage, BUCKET, 5, TimeUnit.SECONDS);
//      if (!wasDeleted && log.isLoggable(Level.WARNING)) {
//        log.log(Level.WARNING, "Deletion of bucket {0} timed out, bucket is not empty", BUCKET);
//      }
//    }
  }

  // ANTHONY STARTS HERE

  @Test
  public void testAllocateIdSingle() {
    Key key = datastoreSnippets.allocateIdSingle();
    assertNotNull(key);
  }

  @Test
  public void testAllocateIdMultiple() {
    List<Key> keys = datastoreSnippets.allocateIdMultiple();
    assertEquals(2, keys.size());
  }
  // ANTHONY ENDS HERE

  // GARRETT STARTS HERE

  @Test
  public void testPutUpdateGet() {
    String KEY = "my_key_name";
    datastoreSnippets.putSingleEntity(KEY);
    Entity entity = datastoreSnippets.getEntityWithKey(KEY);
    assertEquals("value", entity.getString("propertyName"));

    datastoreSnippets.updateEntity(KEY);
    Entity entityV2 = datastoreSnippets.getEntityWithKey(KEY);
    assertEquals("updatedValue", entityV2.getString("propertyName"));
  }

  @Test
  public void testBatchPutUpdateGet() {
    String KEY1 = "my_key_name";
    String KEY2 = "my_key_name2";
    datastoreSnippets.batchPutEntities(KEY1, KEY2);
    List<Entity> entities = Lists.newArrayList(datastoreSnippets.getEntitiesWithKeys(KEY1, KEY2));
    assertEquals(2, entities.size());
    Map<String, Entity> entityMap = new HashMap<>();
    for (Entity entity : entities) {
      entityMap.put(entity.key().name(), entity);
    }
    assertEquals("value1", entityMap.get(KEY1).getString("propertyName"));
    assertEquals("value2", entityMap.get(KEY2).getString("propertyName"));
  }

  // GARRETT ENDS HERE

  // MIKE STARTS HERE

  @Test
  public void test() throws InterruptedException {

    KeyFactory keyFactory = datastoreSnippets.createKeyFactory();
    assertNotNull(keyFactory);

    Entity entity = datastoreSnippets.getEntityWithKey(KEY);
    assertNotNull(entity);

    List<Entity> entityList1 = datastoreSnippets.getEntitiesWithKeys(FIRST_KEY, SECOND_KEY);
    assertNotNull(entityList1);

    List<Entity> entityList = datastoreSnippets.fetchEntitiesWithKeys(FIRST_KEY, SECOND_KEY);
    assertNotNull(entityList);

    QueryResults<Entity> queryResults = datastoreSnippets.runQuery(KEY, QUERY_KIND, NAMESPACE);
    assertNotNull(queryResults);
  }

  // MIKE ENDS HERE
}
