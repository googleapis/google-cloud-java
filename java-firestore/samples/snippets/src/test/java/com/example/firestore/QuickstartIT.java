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

import static org.junit.Assert.assertTrue;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class QuickstartIT extends BaseIntegrationTest {

  private Quickstart quickstart;
  private ByteArrayOutputStream bout;
  private PrintStream out;

  @Before
  public void setUp() throws Exception {
    quickstart = new Quickstart(projectId);
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
    deleteAllDocuments();
  }

  @Test
  public void testQuickstart() throws Exception {
    addData();

    bout.reset();
    quickstart.runQuery();
    String output = bout.toString();
    // confirm that results do not contain aturing
    assertTrue(output.contains("alovelace"));
    assertTrue(output.contains("cbabbage"));
    assertTrue(!output.contains("aturing"));

    bout.reset();
    quickstart.retrieveAllDocuments();
    output = bout.toString();
    // confirm that all documents are retrieved
    assertTrue(output.contains("alovelace"));
    assertTrue(output.contains("aturing"));
    assertTrue(output.contains("cbabbage"));
  }

  private void validate(DocumentReference docRef, Map<String, Object> data) throws Exception {
    DocumentSnapshot documentSnapshot = docRef.get().get();
    assertTrue(Objects.equals(documentSnapshot.getData(), data));
  }

  private void addData() throws Exception {
    Map<String, Object> expectedData = new HashMap<>();

    quickstart.addDocument("alovelace");
    expectedData.put("first", "Ada");
    expectedData.put("last", "Lovelace");
    expectedData.put("born", 1815L);
    validate(db.document("users/alovelace"), expectedData);

    expectedData.clear();
    expectedData.put("first", "Alan");
    expectedData.put("middle", "Mathison");
    expectedData.put("last", "Turing");
    expectedData.put("born", 1912L);
    quickstart.addDocument("aturing");
    validate(db.document("users/aturing"), expectedData);

    expectedData.clear();
    expectedData.put("first", "Charles");
    expectedData.put("last", "Babbage");
    expectedData.put("born", 1791L);
    quickstart.addDocument("cbabbage");
    validate(db.document("users/cbabbage"), expectedData);
  }

  private void deleteAllDocuments() throws Exception {
    ApiFuture<QuerySnapshot> future = db.collection("users").get();
    QuerySnapshot querySnapshot = future.get();
    for (DocumentSnapshot doc : querySnapshot.getDocuments()) {
      // block on delete operation
      db.document("users/" + doc.getId()).delete().get();
    }
  }

  @After
  public void tearDown() throws Exception {
    deleteAllDocuments();
    quickstart.close();
  }
}
