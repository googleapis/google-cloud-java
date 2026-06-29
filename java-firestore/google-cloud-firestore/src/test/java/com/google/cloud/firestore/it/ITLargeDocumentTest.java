/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.firestore.it;

import static com.google.cloud.firestore.LocalFirestoreHelper.autoId;
import static com.google.cloud.firestore.it.ITQueryTest.map;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.FieldPath;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.FirestoreException;
import com.google.cloud.firestore.ListenerRegistration;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import io.grpc.Status;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ITLargeDocumentTest extends ITBaseTest {

  private String collectionName;
  private String unicodePayload;
  private String asciiPayload;

  private DocumentReference docRef;
  private DocumentReference docA;
  private DocumentReference docB;

  static boolean runLargeDocTests() {
    String propertyName = "FIRESTORE_RUN_LARGE_DOC_TESTS";
    String runLargeTests = System.getProperty(propertyName);
    if (runLargeTests == null) {
      runLargeTests = System.getenv(propertyName);
    }
    return "YES".equalsIgnoreCase(runLargeTests) || "true".equalsIgnoreCase(runLargeTests);
  }

  private static String generateUnicodeString(int targetUtf8Bytes) {
    StringBuilder sb = new StringBuilder();
    String emoji = "🚀"; // 4 bytes in UTF-8
    int bytes = 0;
    while (bytes < targetUtf8Bytes) {
      if (bytes % 2 == 0 && bytes + 4 <= targetUtf8Bytes) {
        sb.append(emoji);
        bytes += 4;
      } else {
        sb.append('a');
        bytes += 1;
      }
    }
    return sb.toString();
  }

  private static String generateAsciiString(int sizeInBytes) {
    char[] chars = new char[sizeInBytes];
    Arrays.fill(chars, 'a');
    return new String(chars);
  }

  @Before
  @Override
  public void before() throws Exception {
    // Check preconditions before setting up
    assumeTrue(runLargeDocTests());
    assumeTrue("NIGHTLY".equalsIgnoreCase(getTargetBackend()));
    assumeTrue(getFirestoreEdition() == FirestoreEdition.ENTERPRISE);

    // Call base class before() to initialize firestore
    super.before();

    collectionName = "large_doc_tests_" + autoId();
    CollectionReference colRef = firestore.collection(collectionName);
    docRef = colRef.document("doc_15_9MB_unicode");
    docA = colRef.document("doc_a");
    docB = colRef.document("doc_b");

    int targetBytes = (int) Math.floor(15.9 * 1024 * 1024);
    unicodePayload = generateUnicodeString(targetBytes);
    asciiPayload = generateAsciiString(targetBytes);

    // Write documents in parallel
    ApiFuture<WriteResult> f1 = docRef.set(map("chunk", unicodePayload));
    ApiFuture<WriteResult> f2 = docA.set(map("chunk", asciiPayload));
    ApiFuture<WriteResult> f3 = docB.set(map("chunk", asciiPayload));

    ApiFutures.allAsList(Arrays.asList(f1, f2, f3)).get(90, TimeUnit.SECONDS);
  }

  @After
  @Override
  public void after() throws Exception {
    if (firestore != null && collectionName != null) {
      try {
        // Delete documents in parallel
        ApiFuture<WriteResult> d1 = docRef.delete();
        ApiFuture<WriteResult> d2 = docA.delete();
        ApiFuture<WriteResult> d3 = docB.delete();
        ApiFutures.allAsList(Arrays.asList(d1, d2, d3)).get(30, TimeUnit.SECONDS);
      } catch (Exception e) {
        // Suppress errors during cleanup to not mask test failures
      }
    }
    super.after();
  }

  @Test
  public void testReadLargeUnicodeDocument() throws Exception {
    DocumentSnapshot snapshot = docRef.get().get();
    assertTrue(snapshot.exists());
    String chunk = snapshot.getString("chunk");
    assertNotNull(chunk);
    assertEquals(unicodePayload.length(), chunk.length());
    assertEquals(unicodePayload, chunk);
  }

  @Test
  public void testQueryMultipleLargeDocuments() throws Exception {
    CollectionReference colRef = firestore.collection(collectionName);
    QuerySnapshot querySnapshot =
        colRef.whereIn(FieldPath.documentId(), Arrays.asList("doc_a", "doc_b")).get().get();
    assertEquals(2, querySnapshot.size());

    DocumentSnapshot snapshotA = querySnapshot.getDocuments().get(0);
    DocumentSnapshot snapshotB = querySnapshot.getDocuments().get(1);
    assertEquals(asciiPayload, snapshotA.getString("chunk"));
    assertEquals(asciiPayload, snapshotB.getString("chunk"));
  }

  @Test
  public void testWatchStreamInitialization() throws Exception {
    CompletableFuture<DocumentSnapshot> snapshotFuture = new CompletableFuture<>();
    ListenerRegistration registration =
        docRef.addSnapshotListener(
            (snapshot, error) -> {
              if (error != null) {
                snapshotFuture.completeExceptionally(error);
              } else if (snapshot != null && snapshot.exists()) {
                snapshotFuture.complete(snapshot);
              }
            });

    try {
      DocumentSnapshot snapshot = snapshotFuture.get(60, TimeUnit.SECONDS);
      assertTrue(snapshot.exists());
      assertEquals(unicodePayload, snapshot.getString("chunk"));
    } finally {
      registration.remove();
    }
  }

  @Test
  public void testTransactionReadModifyWrite() throws Exception {
    firestore
        .runTransaction(
            transaction -> {
              DocumentSnapshot snapshot = transaction.get(docRef).get();
              assertTrue(snapshot.exists());
              transaction.update(docRef, map("transaction_timestamp", FieldValue.serverTimestamp()));
              return null;
            })
        .get(60, TimeUnit.SECONDS);
  }

  @Test
  public void testPaginateLargeDocuments() throws Exception {
    CollectionReference colRef = firestore.collection(collectionName);
    com.google.cloud.firestore.Query q =
        colRef.whereIn(FieldPath.documentId(), Arrays.asList("doc_a", "doc_b")).orderBy(FieldPath.documentId());

    QuerySnapshot firstPage = q.limit(1).get().get();
    assertEquals(1, firstPage.size());
    DocumentSnapshot doc1 = firstPage.getDocuments().get(0);
    assertEquals(asciiPayload, doc1.getString("chunk"));

    QuerySnapshot secondPage = q.startAfter(doc1).limit(1).get().get();
    assertEquals(1, secondPage.size());
    DocumentSnapshot doc2 = secondPage.getDocuments().get(0);
    assertEquals(asciiPayload, doc2.getString("chunk"));
  }

  @Test
  public void testOversizedPayloadRejection() {
    DocumentReference oversizedDoc = firestore.collection(collectionName).document("temp_oversized_doc");
    int targetBytes = 16 * 1024 * 1024 + 102400;
    char[] chars = new char[targetBytes];
    Arrays.fill(chars, 'a');
    String largePayload = new String(chars);

    try {
      oversizedDoc.set(data).get(60, TimeUnit.SECONDS);
      fail("Setting a document exceeding the 16MB limit should fail.");
    } catch (Exception e) {
      Throwable cause = e.getCause();
      assertTrue(cause instanceof com.google.api.gax.rpc.InvalidArgumentException);
    }
  }
}
