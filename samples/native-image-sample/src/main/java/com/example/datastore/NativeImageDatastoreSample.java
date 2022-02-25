/*
 * Copyright 2020-2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.datastore;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery;
import com.google.cloud.datastore.Transaction;
import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

/**
 * Sample Datastore Application.
 */
public class NativeImageDatastoreSample {

  /* Datastore namespace where entities will be created. */
  private static final String TEST_NAMESPACE = "nativeimage-test-namespace";

  /* Datastore kind used. */
  private static final String TEST_KIND = "test-kind";

  /**
   * Entrypoint to the Datastore sample application.
   */
  public static void main(String[] args) {
    Instant startTime = Instant.now();
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    String testId = UUID.randomUUID().toString();

    addEntity(datastore, testId);
    getEntity(datastore, testId);
    deleteEntity(datastore, testId);

    runTransaction(datastore);

    String id = UUID.randomUUID().toString();
    Key key = createKey(datastore, id);
    runTransactionCallable(datastore, key);
    Instant endTime = Instant.now();
    Duration duration = Duration.between(startTime, endTime);
    System.out.println("Duration: " + duration.toString());
  }

  static void addEntity(Datastore datastore, String id) {
    Key key = createKey(datastore, id);
    Entity entity = Entity.newBuilder(key)
        .set("description", "hello world")
        .build();
    datastore.add(entity);
    System.out.println("Successfully added entity.");
  }

  static void getEntity(Datastore datastore, String id) {
    Key key = createKey(datastore, id);
    Entity entity = datastore.get(key);
    System.out.println("Reading entity: " + entity.getKey().getName());
  }

  static void deleteEntity(Datastore datastore, String id) {
    Key key = createKey(datastore, id);
    datastore.delete(key);

    Entity entity = datastore.get(key);
    if (entity == null) {
      System.out.println("Successfully deleted entity: " + id);
    } else {
      throw new RuntimeException("Failed to delete entity: " + id);
    }
  }

  static void runTransactionCallable(Datastore datastore, Key entityKey) {
    datastore.runInTransaction(client -> {
      Entity entity = Entity.newBuilder(entityKey)
          .set("description", "hello world")
          .build();
      datastore.add(entity);

      StructuredQuery query =
          Query.newEntityQueryBuilder()
              .setNamespace(TEST_NAMESPACE)
              .setKind(TEST_KIND)
              .build();

      QueryResults<Entity> results = datastore.run(query);
      while (results.hasNext()) {
        Entity result = results.next();
        String name = result.getKey().getName();
        String kind = result.getKey().getKind();
        String namespace = result.getKey().getNamespace();
        System.out.println(
            "Found entity:" + "\n\t\tname=" + name + "\n\t\tkind=" + kind + "\n\t\tnamespace="
                + namespace + "\n\t\tproperties=" + result.getProperties().toString());
      }

      datastore.delete(entityKey);
      return null;
    });

    System.out.println("Ran transaction callable.");
  }

  private static void runTransaction(Datastore datastore) {
    Transaction transaction = datastore.newTransaction();
    transaction.commit();
    transaction = datastore.newTransaction();
    transaction.rollback();
    System.out.println("Run fake transaction code.");
  }

  static Key createKey(Datastore datastore, String id) {
    return datastore.newKeyFactory()
        .setNamespace(TEST_NAMESPACE)
        .setKind(TEST_KIND)
        .newKey(id);
  }
}