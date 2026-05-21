/*
 * Copyright 2018 Google Inc.
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

import com.google.api.core.SettableApiFuture;
import com.google.cloud.firestore.DocumentChange;
import com.google.cloud.firestore.DocumentChange.Type;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.EventListener;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreException;
import com.google.cloud.firestore.ListenerRegistration;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/** Snippets to demonstrate Firestore 'listen' operations. */
@SuppressWarnings("Convert2Lambda")
public class ListenDataSnippets {

  private static final long TIMEOUT_SECONDS = 5;

  private final Firestore db;

  ListenDataSnippets(Firestore db) {
    this.db = db;
  }

  /** Listen to a single document, returning data after the first snapshot. */
  Map<String, Object> listenToDocument() throws Exception {
    final SettableApiFuture<Map<String, Object>> future = SettableApiFuture.create();

    // [START firestore_listen_document]
    DocumentReference docRef = db.collection("cities").document("SF");
    docRef.addSnapshotListener(
        new EventListener<DocumentSnapshot>() {
          @Override
          public void onEvent(@Nullable DocumentSnapshot snapshot, @Nullable FirestoreException e) {
            if (e != null) {
              System.err.println("Listen failed: " + e);
              return;
            }

            if (snapshot != null && snapshot.exists()) {
              System.out.println("Current data: " + snapshot.getData());
            } else {
              System.out.print("Current data: null");
            }
            // [START_EXCLUDE silent]
            if (!future.isDone()) {
              future.set(snapshot.getData());
            }
            // [END_EXCLUDE]
          }
        });
    // [END firestore_listen_document]

    return future.get(TIMEOUT_SECONDS, TimeUnit.SECONDS);
  }

  /** Listen to a query, returning the names of all cities in the first snapshot. */
  List<String> listenForMultiple() throws Exception {
    final SettableApiFuture<List<String>> future = SettableApiFuture.create();

    // [START firestore_listen_query_snapshots]
    db.collection("cities")
        .whereEqualTo("state", "CA")
        .addSnapshotListener(
            new EventListener<QuerySnapshot>() {
              @Override
              public void onEvent(
                  @Nullable QuerySnapshot snapshots, @Nullable FirestoreException e) {
                if (e != null) {
                  System.err.println("Listen failed:" + e);
                  return;
                }

                List<String> cities = new ArrayList<>();
                for (DocumentSnapshot doc : snapshots) {
                  if (doc.get("name") != null) {
                    cities.add(doc.getString("name"));
                  }
                }
                System.out.println("Current cites in CA: " + cities);
                // [START_EXCLUDE silent]
                if (!future.isDone()) {
                  future.set(cities);
                }
                // [END_EXCLUDE]
              }
            });
    // [END firestore_listen_query_snapshots]

    return future.get(TIMEOUT_SECONDS, TimeUnit.SECONDS);
  }

  /** Listen to a query, returning the list of DocumentChange events in the first snapshot. */
  List<DocumentChange> listenForChanges() throws Exception {
    SettableApiFuture<List<DocumentChange>> future = SettableApiFuture.create();

    // [START firestore_listen_query_changes]
    db.collection("cities")
        .whereEqualTo("state", "CA")
        .addSnapshotListener(
            new EventListener<QuerySnapshot>() {
              @Override
              public void onEvent(
                  @Nullable QuerySnapshot snapshots, @Nullable FirestoreException e) {
                if (e != null) {
                  System.err.println("Listen failed: " + e);
                  return;
                }

                for (DocumentChange dc : snapshots.getDocumentChanges()) {
                  switch (dc.getType()) {
                    case ADDED:
                      System.out.println("New city: " + dc.getDocument().getData());
                      break;
                    case MODIFIED:
                      System.out.println("Modified city: " + dc.getDocument().getData());
                      break;
                    case REMOVED:
                      System.out.println("Removed city: " + dc.getDocument().getData());
                      break;
                    default:
                      break;
                  }
                }
                // [START_EXCLUDE silent]
                if (!future.isDone()) {
                  future.set(snapshots.getDocumentChanges());
                }
                // [END_EXCLUDE]
              }
            });
    // [END firestore_listen_query_changes]

    return future.get(TIMEOUT_SECONDS, TimeUnit.SECONDS);
  }

  /** Demonstrate how to detach an event listener. */
  void detachListener() {
    // [START firestore_listen_detach]
    Query query = db.collection("cities");
    ListenerRegistration registration =
        query.addSnapshotListener(
            new EventListener<QuerySnapshot>() {
              // [START_EXCLUDE]
              @Override
              public void onEvent(
                  @Nullable QuerySnapshot snapshots, @Nullable FirestoreException e) {}

              // [END_EXCLUDE]
            });

    // ...

    // Stop listening to changes
    registration.remove();
    // [END firestore_listen_detach]
  }

  /** Demonstrate how to handle listening errors. */
  void listenErrors() {
    // [START firestore_listen_handle_error]
    db.collection("cities")
        .addSnapshotListener(
            new EventListener<QuerySnapshot>() {
              @Override
              public void onEvent(
                  @Nullable QuerySnapshot snapshots, @Nullable FirestoreException e) {
                if (e != null) {
                  System.err.println("Listen failed: " + e);
                  return;
                }

                for (DocumentChange dc : snapshots.getDocumentChanges()) {
                  if (dc.getType() == Type.ADDED) {
                    System.out.println("New city: " + dc.getDocument().getData());
                  }
                }
              }
            });
    // [END firestore_listen_handle_error]
  }

  /** Closes the gRPC channels associated with this instance and frees up their resources. */
  void close() throws Exception {
    db.close();
  }
}
