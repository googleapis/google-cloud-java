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
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.Transaction;

import org.junit.BeforeClass;
import org.junit.Test;

public class ITQuerySnippets {

  private static Datastore datastore;

  @BeforeClass
  public static void beforeClass() {
    datastore = DatastoreOptions.defaultInstance().service();
  }

  @Test
  public void testNewQuery() {
    Transaction transaction = datastore.newTransaction();
    QuerySnippets transactionSnippets = new QuerySnippets(transaction);
    QueryResults<?> results = transactionSnippets.newQuery();
  }

  @Test
  public void testNewTypedQuery() {
    Transaction transaction = datastore.newTransaction();
    QuerySnippets transactionSnippets = new QuerySnippets(transaction);
    QueryResults<Entity> results = transactionSnippets.newTypedQuery();
  }

  @Test
  public void testNewEntityQuery() {
    Transaction transaction = datastore.newTransaction();
    QuerySnippets transactionSnippets = new QuerySnippets(transaction);
    QueryResults<Entity> results = transactionSnippets.newEntityQuery("*");
  }
}
