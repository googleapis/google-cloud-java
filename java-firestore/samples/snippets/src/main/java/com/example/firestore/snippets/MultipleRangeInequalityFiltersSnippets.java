/*
 * Copyright 2024 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.firestore.snippets;

import com.example.firestore.snippets.model.City;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.Query.Direction;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Snippets to support firestore querying data documentation.
 */
class MultipleRangeInequalityFiltersSnippets {

  private final Firestore db;

  MultipleRangeInequalityFiltersSnippets(Firestore db) {
    this.db = db;
  }

  /**
   * Creates cities collection and add sample documents to test queries.
   */
  void prepareExamples() throws Exception {
    // Data for each city
    Map<String, Object> sfData = new HashMap<>();
    sfData.put("name", "San Francisco");
    sfData.put("state", "CA");
    sfData.put("country", "USA");
    sfData.put("capital", false);
    sfData.put("population", 860000L);
    sfData.put("density", 18000L);
    sfData.put("regions", Arrays.asList("west_coast", "norcal"));

    Map<String, Object> laData = new HashMap<>();
    laData.put("name", "Los Angeles");
    laData.put("state", "CA");
    laData.put("country", "USA");
    laData.put("capital", false);
    laData.put("population", 3900000L);
    laData.put("density", 8300L);
    laData.put("regions", Arrays.asList("west_coast", "socal"));

    Map<String, Object> dcData = new HashMap<>();
    dcData.put("name", "Washington D.C.");
    dcData.put("state", null);
    dcData.put("country", "USA");
    dcData.put("capital", true);
    dcData.put("population", 680000L);
    dcData.put("density", 11300L);
    dcData.put("regions", Arrays.asList("east_coast"));

    Map<String, Object> tokData = new HashMap<>();
    tokData.put("name", "Tokyo");
    tokData.put("state", null);
    tokData.put("country", "Japan");
    tokData.put("capital", true);
    tokData.put("population", 9000000L);
    tokData.put("density", 16000L);
    tokData.put("regions", Arrays.asList("kanto", "honshu"));

    Map<String, Object> bjData = new HashMap<>();
    bjData.put("name", "Beijing");
    bjData.put("state", null);
    bjData.put("country", "China");
    bjData.put("capital", true);
    bjData.put("population", 21500000L);
    bjData.put("density", 3500L);
    bjData.put("regions", Arrays.asList("jingjinji", "hebei"));

    CollectionReference citiesCollection = db.collection("cities");

    // Add each city document
    addCityDocument(citiesCollection, "SF", sfData);
    addCityDocument(citiesCollection, "LA", laData);
    addCityDocument(citiesCollection, "DC", dcData);
    addCityDocument(citiesCollection, "TOK", tokData);
    addCityDocument(citiesCollection, "BJ", bjData);

    System.out.println("Data added successfully!");
  }

  private static void addCityDocument(CollectionReference citiesRef, String documentId,
      Map<String, Object> data) {
    ApiFuture<WriteResult> future = citiesRef.document(documentId).set(data);
    try {
      WriteResult result = future.get();
      System.out.println("Update time : " + result.getUpdateTime());
    } catch (Exception e) {
      System.err.println("Error adding document: " + e.getMessage());
    }
  }

  /* Example of Query with range and inequality filters. */
  Query compoundMultiInequalities() {
    // [START firestore_query_filter_compound_multi_ineq]
    Query query = db.collection("cities")
        .whereGreaterThan("population", 1000000)
        .whereLessThan("density", 10000);
    // [END firestore_query_filter_compound_multi_ineq]
    return query;
  }

  /* Example of filtering indexes considering performance reasons. */
  void indexingConsiderations() {
    // [START firestore_query_indexing_considerations]
    db.collection("employees")
        .whereGreaterThan("salary", 100000)
        .whereGreaterThan("experience", 0)
        .orderBy("salary")
        .orderBy("experience");
    // [END firestore_query_indexing_considerations]
  }

  /**
   * Closes the gRPC channels associated with this instance and frees up their resources.
   */
  void close() throws Exception {
    db.close();
  }
}
