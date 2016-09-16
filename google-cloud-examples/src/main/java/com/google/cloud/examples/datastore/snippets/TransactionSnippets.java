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
 * This file is referenced in Transaction's javadoc. Any change to this file should be reflected in
 * Transaction's javadoc.
 */

package com.google.cloud.examples.datastore.snippets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreException;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Transaction;

/**
 * This class contains a number of snippets for the {@link Transaction} interface.
 */
public class TransactionSnippets {

  private final Datastore datastore;

  public TransactionSnippets(Datastore datastore) {
    this.datastore = datastore;
  }

  /**
   * Example of committing a transaction
   */
  // [TARGET commit()]
  public Key commitTransaction() {
    // [START commitTransaction]
    // create an entity
    KeyFactory keyFactory = datastore.newKeyFactory().kind("someKind");
    Key key = datastore.allocateId(keyFactory.newKey());
    Entity entity = Entity.builder(key).set("description", "calling commit()").build();

    // add the entity and commit
    Transaction txn = datastore.newTransaction();
    try {
      txn.put(entity);
      txn.commit();
    } catch (DatastoreException ex) {
      // handle exception
    }
    // [END commitTransaction]
    return key;
  }

  /**
   * Example of rolling back a Transaction
   */
  // [TARGET rollback()]
  public Key rollbackTransaction() {
    // [START rollbackTransaction]
    // create an entity
    KeyFactory keyFactory = datastore.newKeyFactory().kind("someKind");
    Key key = datastore.allocateId(keyFactory.newKey());
    Entity entity = Entity.builder(key).set("description", "calling active()").build();

    // add the entity and rollback
    Transaction txn = datastore.newTransaction();
    txn.put(entity);
    txn.rollback();
    // calling txn.commit() now would fail
    // [END rollbackTransaction]
    return key;
  }

  /**
   * Example of verifying if a Transaction is active
   */
  // [TARGET active()]
  public Key activeTransaction() {
    // [START activeTransaction]
    // create an entity
    KeyFactory keyFactory = datastore.newKeyFactory().kind("someKind");
    Key key = datastore.allocateId(keyFactory.newKey());
    Entity entity = Entity.builder(key).set("description", "calling active()").build();

    // create a transaction
    Transaction txn = datastore.newTransaction();
    // calling txn.active() now would return true
    try {
      // add the entity and commit
      txn.put(entity);
      txn.commit();
    } finally {
      // if committing succeeded
      // then txn.active() will be false
      if (txn.active()) {
        // otherwise it's true and we need to rollback
        txn.rollback();
      }
    }
    // [END activeTransaction]
    return key;
  }
}