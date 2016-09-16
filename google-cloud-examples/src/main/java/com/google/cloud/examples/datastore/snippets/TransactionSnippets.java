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

  private final Transaction transaction;

  public TransactionSnippets(Transaction transaction) {
    this.transaction = transaction;
  }

  /**
   * Example of committing a transaction.
   */
  // [TARGET commit()]
  public Key commit() {
    Datastore datastore = transaction.datastore();
    // [START commit]
    // create an entity
    KeyFactory keyFactory = datastore.newKeyFactory().kind("someKind");
    Key key = datastore.allocateId(keyFactory.newKey());
    Entity entity = Entity.builder(key).set("description", "commit()").build();
    // add the entity and commit
    try {
      transaction.put(entity);
      transaction.commit();
    } catch (DatastoreException ex) {
      // handle exception
    }
    // [END commit]
    return key;
  }

  /**
   * Example of rolling back a transaction.
   */
  // [TARGET rollback()]
  public Key rollback() {
    Datastore datastore = transaction.datastore();
    // [START rollback]
    // create an entity
    KeyFactory keyFactory = datastore.newKeyFactory().kind("someKind");
    Key key = datastore.allocateId(keyFactory.newKey());
    Entity entity = Entity.builder(key).set("description", "rollback()").build();

    // add the entity and rollback
    transaction.put(entity);
    transaction.rollback();
    // calling transaction.commit() now would fail
    // [END rollback]
    return key;
  }

  /**
   * Example of verifying if a transaction is active.
   */
  // [TARGET active()]
  public Key active() {
    Datastore datastore = transaction.datastore();
    // [START active]
    // create an entity
    KeyFactory keyFactory = datastore.newKeyFactory().kind("someKind");
    Key key = datastore.allocateId(keyFactory.newKey());
    Entity entity = Entity.builder(key).set("description", "active()").build();
    // calling transaction.active() now would return true
    try {
      // add the entity and commit
      transaction.put(entity);
      transaction.commit();
    } finally {
      // if committing succeeded
      // then transaction.active() will be false
      if (transaction.active()) {
        // otherwise it's true and we need to rollback
        transaction.rollback();
      }
    }
    // [END active]
    return key;
  }
}
