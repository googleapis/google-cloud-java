/*
 * Copyright 2017 Google Inc.
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
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/** Snippets to demonstrate Firestore data retrieval operations. */
public class RetrieveDataSnippets {

  private final Firestore db;

  RetrieveDataSnippets(Firestore db) {
    this.db = db;
  }

  /** Create cities collection and add sample documents. */
  void prepareExamples() throws Exception {
    // [START firestore_data_get_dataset]
    CollectionReference cities = db.collection("cities");
    List<ApiFuture<WriteResult>> futures = new ArrayList<>();
    futures.add(
        cities
            .document("SF")
            .set(
                new City(
                    "San Francisco",
                    "CA",
                    "USA",
                    false,
                    860000L,
                    Arrays.asList("west_coast", "norcal"))));
    futures.add(
        cities
            .document("LA")
            .set(
                new City(
                    "Los Angeles",
                    "CA",
                    "USA",
                    false,
                    3900000L,
                    Arrays.asList("west_coast", "socal"))));
    futures.add(
        cities
            .document("DC")
            .set(
                new City(
                    "Washington D.C.", null, "USA", true, 680000L, Arrays.asList("east_coast"))));
    futures.add(
        cities
            .document("TOK")
            .set(
                new City(
                    "Tokyo", null, "Japan", true, 9000000L, Arrays.asList("kanto", "honshu"))));
    futures.add(
        cities
            .document("BJ")
            .set(
                new City(
                    "Beijing",
                    null,
                    "China",
                    true,
                    21500000L,
                    Arrays.asList("jingjinji", "hebei"))));
    // (optional) block on operation
    ApiFutures.allAsList(futures).get();
    // [END firestore_data_get_dataset]
  }

  /**
   * Retrieves document in collection as map.
   *
   * @return map (string => object)
   */
  public Map<String, Object> getDocumentAsMap() throws Exception {
    // [START firestore_data_get_as_map]
    DocumentReference docRef = db.collection("cities").document("SF");
    // asynchronously retrieve the document
    ApiFuture<DocumentSnapshot> future = docRef.get();
    // ...
    // future.get() blocks on response
    DocumentSnapshot document = future.get();
    if (document.exists()) {
      System.out.println("Document data: " + document.getData());
    } else {
      System.out.println("No such document!");
    }
    // [END firestore_data_get_as_map]
    return (document.exists()) ? document.getData() : null;
  }

  /**
   * Retrieves document in collection as a custom object.
   *
   * @return document data as City object
   */
  public City getDocumentAsEntity() throws Exception {
    // [START firestore_data_get_as_custom_type]
    DocumentReference docRef = db.collection("cities").document("BJ");
    // asynchronously retrieve the document
    ApiFuture<DocumentSnapshot> future = docRef.get();
    // block on response
    DocumentSnapshot document = future.get();
    City city = null;
    if (document.exists()) {
      // convert document to POJO
      city = document.toObject(City.class);
      System.out.println(city);
    } else {
      System.out.println("No such document!");
    }
    // [END firestore_data_get_as_custom_type]
    return city;
  }

  /**
   * Return multiple documents from a collection based on a query.
   *
   * @return list of documents of capital cities.
   */
  public List<QueryDocumentSnapshot> getQueryResults() throws Exception {
    // [START firestore_data_query]
    // asynchronously retrieve multiple documents
    ApiFuture<QuerySnapshot> future = db.collection("cities").whereEqualTo("capital", true).get();
    // future.get() blocks on response
    List<QueryDocumentSnapshot> documents = future.get().getDocuments();
    for (DocumentSnapshot document : documents) {
      System.out.println(document.getId() + " => " + document.toObject(City.class));
    }
    // [END firestore_data_query]
    return documents;
  }

  /**
   * Return all documents in the cities collection.
   *
   * @return list of documents
   */
  public List<QueryDocumentSnapshot> getAllDocuments() throws Exception {
    // [START firestore_data_get_all_documents]
    // asynchronously retrieve all documents
    ApiFuture<QuerySnapshot> future = db.collection("cities").get();
    // future.get() blocks on response
    List<QueryDocumentSnapshot> documents = future.get().getDocuments();
    for (QueryDocumentSnapshot document : documents) {
      System.out.println(document.getId() + " => " + document.toObject(City.class));
    }
    // [END firestore_data_get_all_documents]
    return documents;
  }

  /**
   * Return all subcollections of the cities/SF document.
   *
   * @return iterable of collection references.
   */
  public Iterable<CollectionReference> listCollections() throws Exception {
    // [START firestore_data_get_sub_collections]
    Iterable<CollectionReference> collections =
        db.collection("cities").document("SF").listCollections();

    for (CollectionReference collRef : collections) {
      System.out.println("Found subcollection with id: " + collRef.getId());
    }
    // [END firestore_data_get_sub_collections]
    return collections;
  }

  /** Closes the gRPC channels associated with this instance and frees up their resources. */
  void close() throws Exception {
    db.close();
  }
}
