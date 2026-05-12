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

package com.example.firestore;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
// [START firestore_deps]
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
// [END firestore_deps]
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple Quick start application demonstrating how to connect to Firestore
 * and add and query documents.
 */
public class Quickstart {

  private Firestore db;

  public Quickstart(String projectId) throws Exception {
    // [START firestore_setup_client_create]
    // Option 1: Initialize a Firestore client with a specific `projectId` and
    //           authorization credential.
    // [START firestore_setup_client_create_with_project_id]
    FirestoreOptions firestoreOptions =
        FirestoreOptions.getDefaultInstance().toBuilder()
            .setProjectId(projectId)
            .setCredentials(GoogleCredentials.getApplicationDefault())
            .build();
    Firestore db = firestoreOptions.getService();
    // [END firestore_setup_client_create_with_project_id]
    // [END firestore_setup_client_create]
    this.db = db;
  }

  /**
   * Initialize Firestore using default project ID.
   */
  public Quickstart() {
    // [START firestore_setup_client_create]

    // Option 2: Initialize a Firestore client with default values inferred from
    //           your environment.
    Firestore db = FirestoreOptions.getDefaultInstance().getService();
    // [END firestore_setup_client_create]
    this.db = db;
  }

  Firestore getDb() {
    return db;
  }

  /**
   * Add named test documents with fields first, last, middle (optional), born.
   *
   * @param docName document name
   */
  void addDocument(String docName) throws Exception {
    switch (docName) {
      case "alovelace": {
        // [START firestore_setup_dataset_pt1]
        DocumentReference docRef = db.collection("users").document("alovelace");
        // Add document data  with id "alovelace" using a hashmap
        Map<String, Object> data = new HashMap<>();
        data.put("first", "Ada");
        data.put("last", "Lovelace");
        data.put("born", 1815);
        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(data);
        // ...
        // result.get() blocks on response
        System.out.println("Update time : " + result.get().getUpdateTime());
        // [END firestore_setup_dataset_pt1]
        break;
      }
      case "aturing": {
        // [START firestore_setup_dataset_pt2]
        DocumentReference docRef = db.collection("users").document("aturing");
        // Add document data with an additional field ("middle")
        Map<String, Object> data = new HashMap<>();
        data.put("first", "Alan");
        data.put("middle", "Mathison");
        data.put("last", "Turing");
        data.put("born", 1912);

        ApiFuture<WriteResult> result = docRef.set(data);
        System.out.println("Update time : " + result.get().getUpdateTime());
        // [END firestore_setup_dataset_pt2]
        break;
      }
      case "cbabbage": {
        DocumentReference docRef = db.collection("users").document("cbabbage");
        Map<String, Object> data =
            new ImmutableMap.Builder<String, Object>()
                .put("first", "Charles")
                .put("last", "Babbage")
                .put("born", 1791)
                .build();
        ApiFuture<WriteResult> result = docRef.set(data);
        System.out.println("Update time : " + result.get().getUpdateTime());
        break;
      }
      default:
    }
  }

  void runQuery() throws Exception {
    // [START firestore_setup_add_query]
    // asynchronously query for all users born before 1900
    ApiFuture<QuerySnapshot> query =
        db.collection("users").whereLessThan("born", 1900).get();
    // ...
    // query.get() blocks on response
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    for (QueryDocumentSnapshot document : documents) {
      System.out.println("User: " + document.getId());
      System.out.println("First: " + document.getString("first"));
      if (document.contains("middle")) {
        System.out.println("Middle: " + document.getString("middle"));
      }
      System.out.println("Last: " + document.getString("last"));
      System.out.println("Born: " + document.getLong("born"));
    }
    // [END firestore_setup_add_query]
  }

  void retrieveAllDocuments() throws Exception {
    // [START firestore_setup_dataset_read]
    // asynchronously retrieve all users
    ApiFuture<QuerySnapshot> query = db.collection("users").get();
    // ...
    // query.get() blocks on response
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    for (QueryDocumentSnapshot document : documents) {
      System.out.println("User: " + document.getId());
      System.out.println("First: " + document.getString("first"));
      if (document.contains("middle")) {
        System.out.println("Middle: " + document.getString("middle"));
      }
      System.out.println("Last: " + document.getString("last"));
      System.out.println("Born: " + document.getLong("born"));
    }
    // [END firestore_setup_dataset_read]
  }

  void run() throws Exception {
    String[] docNames = {"alovelace", "aturing", "cbabbage"};

    // Adding document 1
    System.out.println("########## Adding document 1 ##########");
    addDocument(docNames[0]);

    // Adding document 2
    System.out.println("########## Adding document 2 ##########");
    addDocument(docNames[1]);

    // Adding document 3
    System.out.println("########## Adding document 3 ##########");
    addDocument(docNames[2]);

    // retrieve all users born before 1900
    System.out.println("########## users born before 1900 ##########");
    runQuery();

    // retrieve all users
    System.out.println("########## All users ##########");
    retrieveAllDocuments();
    System.out.println("###################################");
  }

  /**
   * A quick start application to get started with Firestore.
   *
   * @param args firestore-project-id (optional)
   */
  public static void main(String[] args) throws Exception {
    // default project is will be used if project-id argument is not available
    String projectId = (args.length == 0) ? null : args[0];
    Quickstart quickStart = (projectId != null) ? new Quickstart(projectId) : new Quickstart();
    quickStart.run();
    quickStart.close();
  }

  /** Closes the gRPC channels associated with this instance and frees up their resources. */
  void close() throws Exception {
    db.close();
  }
}
