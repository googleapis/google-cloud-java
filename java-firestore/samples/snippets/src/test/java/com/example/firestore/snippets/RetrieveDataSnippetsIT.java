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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.firestore.BaseIntegrationTest;
import com.example.firestore.snippets.model.City;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class RetrieveDataSnippetsIT extends BaseIntegrationTest {

  private static RetrieveDataSnippets retrieveDataSnippets;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    retrieveDataSnippets = new RetrieveDataSnippets(db);
    retrieveDataSnippets.prepareExamples();
  }

  @Test
  public void testRetrievalAsMap() throws Exception {
    Map<String, Object> data = retrieveDataSnippets.getDocumentAsMap();
    assertEquals(data.get("name"), "San Francisco");
    assertEquals(data.get("country"), "USA");
    assertEquals(data.get("capital"), false);
    assertEquals(data.get("population"), 860000L);
  }

  @Test
  public void testRetrieveAsEntity() throws Exception {
    City city = retrieveDataSnippets.getDocumentAsEntity();
    assertEquals(city.getName(), "Beijing");
    assertEquals(city.getCountry(), "China");
    assertEquals(city.getCapital(), true);
    assertEquals((long) city.getPopulation(), 21500000L);
  }

  @Test
  public void testRetrieveQueryResults() throws Exception {
    List<QueryDocumentSnapshot> docs = retrieveDataSnippets.getQueryResults();
    assertEquals(docs.size(), 3);
    Set<String> docIds = new HashSet<>();
    for (DocumentSnapshot doc : docs) {
      docIds.add(doc.getId());
    }
    assertTrue(docIds.contains("BJ") && docIds.contains("TOK") && docIds.contains("DC"));
  }

  @Test
  public void testRetrieveAllDocuments() throws Exception {
    List<QueryDocumentSnapshot> docs = retrieveDataSnippets.getAllDocuments();
    assertEquals(docs.size(), 5);
    Set<String> docIds = new HashSet<>();
    for (DocumentSnapshot doc : docs) {
      docIds.add(doc.getId());
    }
    assertTrue(
        docIds.contains("SF")
            && docIds.contains("LA")
            && docIds.contains("DC")
            && docIds.contains("TOK")
            && docIds.contains("BJ"));
  }

  @Test
  public void testGetSubcollections() throws Exception {
    // Add a landmark subcollection
    Map<String, String> data = new HashMap<>();
    data.put("foo", "bar");
    db.document("cities/SF/landmarks/example").set(data).get();

    Iterable<CollectionReference> collections = retrieveDataSnippets.listCollections();

    List<CollectionReference> collectionList = new ArrayList<>();
    for (CollectionReference collRef : collections) {
      collectionList.add(collRef);
    }

    assertEquals(collectionList.size(), 1);
    assertEquals(collectionList.get(0).getId(), "landmarks");
  }

  private static void deleteAllDocuments() throws Exception {
    ApiFuture<QuerySnapshot> future = db.collection("cities").get();
    QuerySnapshot querySnapshot = future.get();
    for (DocumentSnapshot doc : querySnapshot.getDocuments()) {
      // block on delete operation
      db.collection("cities").document(doc.getId()).delete().get();
    }
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    deleteAllDocuments();
    retrieveDataSnippets.close();
  }
}
