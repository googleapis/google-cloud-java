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

package com.example.firestore;

import static org.junit.Assert.assertNotNull;

import com.example.firestore.snippets.ManageDataSnippetsIT;
import com.example.firestore.snippets.model.City;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QuerySnapshot;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/** Base class for tests like {@link ManageDataSnippetsIT}. */
public class BaseIntegrationTest {

  protected static String projectId;
  protected static Firestore db;

  private static String getEnvVar(String varName) {
    String value = System.getenv(varName);
    assertNotNull(
        String.format("Environment variable '%s' must be set to perform these tests.", varName),
        value);
    return value;
  }

  @BeforeClass
  public static void baseSetup() throws Exception {
    projectId = getEnvVar("FIRESTORE_PROJECT_ID");
    FirestoreOptions firestoreOptions =
        FirestoreOptions.getDefaultInstance().toBuilder()
            .setCredentials(GoogleCredentials.getApplicationDefault())
            .setProjectId(projectId)
            .build();
    db = firestoreOptions.getService();
    deleteAllDocuments(db);
  }

  protected DocumentSnapshot getDocumentData(DocumentReference docRef) throws Exception {
    return docRef.get().get();
  }

  protected Map<String, Object> getDocumentDataAsMap(DocumentReference docRef) throws Exception {
    DocumentSnapshot snapshot = docRef.get().get();
    if (!snapshot.exists()) {
      throw new RuntimeException("Document does not exist: " + docRef.getPath());
    }

    return snapshot.getData();
  }

  protected City getDocumentDataAsCity(DocumentReference docRef) throws Exception {
    return docRef.get().get().toObject(City.class);
  }

  protected static void deleteAllDocuments(Firestore db) throws Exception {
    ApiFuture<QuerySnapshot> future = db.collection("cities").get();
    QuerySnapshot querySnapshot = future.get();
    for (DocumentSnapshot doc : querySnapshot.getDocuments()) {
      // block on delete operation
      db.collection("cities").document(doc.getId()).delete().get();
    }
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    db.close();
  }
}
