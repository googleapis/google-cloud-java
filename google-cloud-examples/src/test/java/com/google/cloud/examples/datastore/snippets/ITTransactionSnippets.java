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

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Transaction;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

public class ITTransactionSnippets {

  private static Datastore datastore;
  private static Transaction transaction;
  private static TransactionSnippets transactionSnippets;

  @BeforeClass
  public static void beforeClass() {
    datastore = DatastoreOptions.defaultInstance().service();
    transaction = datastore.newTransaction();
    transactionSnippets = new TransactionSnippets(transaction);
  }

  @Test
  public void testCommitTransaction() {
    Key key = transactionSnippets.commitTransaction();
    Entity result = datastore.get(key);
    assertNotNull(result);
    datastore.delete(key);
  }

  @Test
  public void testRollbackTransaction() {
    Key key = transactionSnippets.rollbackTransaction();
    Entity result = datastore.get(key);
    assertNull(result);
    if (result != null) {
      datastore.delete(key);
    }
  }

  @Test
  public void testActiveTransaction() {
    Key key = transactionSnippets.activeTransaction();
    Entity result = datastore.get(key);
    assertNotNull(result);
    datastore.delete(key);
  }
}