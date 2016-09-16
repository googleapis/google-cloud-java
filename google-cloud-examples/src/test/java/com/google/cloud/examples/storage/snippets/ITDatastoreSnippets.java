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
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.examples.datastore.snippets.DatastoreSnippets;
import com.google.cloud.storage.testing.RemoteStorageHelper;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class ITDatastoreSnippets {

  private static final Logger log = Logger.getLogger(ITDatastoreSnippets.class.getName());
  private static final String BUCKET = RemoteStorageHelper.generateBucketName();

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

  // ANTHONY ENDS HERE

  // GARRETT STARTS HERE

//  @Test
//  public void testUpdateEntity() {
//    String KEY = "my_key_name";
//    // WILL FAIL - need to ensure it is created first
//    datastoreSnippets.updateEntity(KEY);
//  }

  @Test
  public void testPutEntity() {
    String KEY = "my_key_name";
    datastoreSnippets.putSingleEntity(KEY);
    Entity entity = datastoreSnippets.getEntityWithKey(KEY);
    assertEquals("value", entity.getString("propertyName"));
  }

  // GARRETT ENDS HERE

  // MIKE STARTS HERE

  @Test
  public void test() throws InterruptedException {

    String KEY = "my_key_name";
    String FIRST_KEY = "first_key_name";
    String SECOND_KEY = "second_key_name";
    String QUERY_KIND = "kind";
    String NAMESPACE = "namespace";

    KeyFactory keyFactory = datastoreSnippets.createKeyFactory();
    assertNotNull(keyFactory);

    Entity entity = datastoreSnippets.getEntityWithKey(KEY);
    assertNotNull(entity);

    Iterator<Entity> entityIterator = datastoreSnippets.getEntitiesWithKeys(FIRST_KEY, SECOND_KEY);
    assertNotNull(entityIterator);

    List<Entity> entityList = datastoreSnippets.fetchEntitiesWithKeys(FIRST_KEY, SECOND_KEY);
    assertNotNull(entityList);

    QueryResults<Entity> queryResults = datastoreSnippets.runQuery(KEY, QUERY_KIND, NAMESPACE);
    assertNotNull(queryResults);
  }

  // MIKE ENDS HERE
}
