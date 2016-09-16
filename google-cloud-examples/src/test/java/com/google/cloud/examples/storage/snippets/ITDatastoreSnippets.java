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

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.Page;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.testing.LocalDatastoreHelper;
import com.google.cloud.examples.datastore.snippets.DatastoreSnippets;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    LocalDatastoreHelper helper = LocalDatastoreHelper.create();
    datastore = helper.options().service();
    datastoreSnippets = new DatastoreSnippets(datastore);
  }

  @AfterClass
  public static void afterClass() throws ExecutionException, InterruptedException {
    if (datastore != null) {
      //LocalDatastoreHelper.sendQuitRequest(port)
    }
  }

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
}
