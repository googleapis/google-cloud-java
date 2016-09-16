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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Transaction;

import org.junit.BeforeClass;
import org.junit.Test;

public class ITTransactionSnippets {

  private static Datastore datastore;

  @BeforeClass
  public static void beforeClass() {
    datastore = DatastoreOptions.defaultInstance().service();
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
}
