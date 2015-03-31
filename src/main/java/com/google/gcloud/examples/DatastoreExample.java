/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.examples;

import com.google.gcloud.datastore.DatastoreService;
import com.google.gcloud.datastore.DatastoreServiceFactory;
import com.google.gcloud.datastore.DatastoreServiceOptions;
import com.google.gcloud.datastore.Entity;
import com.google.gcloud.datastore.Key;
import com.google.gcloud.datastore.KeyFactory;

/**
 * An example of using the Google Cloud Datastore.
 * <p>
 * Steps needed for running the example:<ol>
 * <li>login using gcloud SDK - {@code gcloud auth login}.</li>
 * <li>compile using maven - {@code mvn compile}</li>
 * <li>run using maven - {@code mvn exec:java
 * -Dexec.mainClass="com.google.gcloud.examples.DatastoreExample" -Dexec.arguments="dataset"}</li>
 * </ol>
 */
public class DatastoreExample {

  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("DatastoreExample requires one argument for dataset");
      return;
    }
    String dataset = args[0];
    // If you want to access a local Datastore running via the gcd sdk, do
    //  DatastoreServiceOptions options = DatastoreServiceOptions.builder()
    //    .dataset(DATASET)
    //    .host("http://localhost:" + LocalGcdHelper.PORT)
    //    .build();
    DatastoreServiceOptions options = DatastoreServiceOptions.builder().dataset(dataset).build();
    DatastoreService datastore = DatastoreServiceFactory.getDefault(options);
    KeyFactory keyFactory = datastore.newKeyFactory().kind("Person");
    Key key = keyFactory.newKey("Jimmy");

    System.out.println("Trying to get the entity by its key!");
    Entity entity = datastore.get(key);

    if (entity == null) {
      System.out.println("Entity not found! Creating it!");
      entity = Entity.builder(key)
          .set("age", 30L)
          .build();
      datastore.add(entity);
    }

    System.out.println("Going to modify entity: " + entity);
    Entity.Builder builder = Entity.builder(entity);
    builder.set("f", 30);
    datastore.put(entity);

    System.out.println("Trying again to get the entity by its key!");
    key = Key.builder(dataset, "Person", "Jimmy").build();
    System.out.println("Got entity: " + entity);
  }
}
