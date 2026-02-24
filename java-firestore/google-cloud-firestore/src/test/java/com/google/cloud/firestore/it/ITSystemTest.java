/*
 * Copyright 2017 Google LLC
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

import static com.google.cloud.firestore.FirestoreBundleTest.toBundleElements;
import static com.google.cloud.firestore.FirestoreBundleTest.verifyDocumentAndMeta;
import static com.google.cloud.firestore.FirestoreBundleTest.verifyMetadata;
import static com.google.cloud.firestore.FirestoreBundleTest.verifyNamedQuery;
import static com.google.cloud.firestore.LocalFirestoreHelper.FOO_LIST;
import static com.google.cloud.firestore.LocalFirestoreHelper.FOO_MAP;
import static com.google.cloud.firestore.LocalFirestoreHelper.UPDATE_SINGLE_FIELD_OBJECT;
import static com.google.cloud.firestore.LocalFirestoreHelper.fullPath;
import static com.google.cloud.firestore.LocalFirestoreHelper.map;
import static com.google.cloud.firestore.it.TestHelper.isRunningAgainstFirestoreEmulator;
import static com.google.common.truth.Truth.assertThat;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.BulkWriter;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.FieldMask;
import com.google.cloud.firestore.FieldPath;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreBundle;
import com.google.cloud.firestore.FirestoreException;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.ListenerRegistration;
import com.google.cloud.firestore.LocalFirestoreHelper;
import com.google.cloud.firestore.LocalFirestoreHelper.AllSupportedTypes;
import com.google.cloud.firestore.LocalFirestoreHelper.SingleField;
import com.google.cloud.firestore.Precondition;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.Query.Direction;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QueryPartition;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.Transaction;
import com.google.cloud.firestore.Transaction.Function;
import com.google.cloud.firestore.TransactionOptions;
import com.google.cloud.firestore.VectorValue;
import com.google.cloud.firestore.WriteBatch;
import com.google.cloud.firestore.WriteResult;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.firestore.bundle.BundleElement;
import com.google.firestore.bundle.BundledDocumentMetadata;
import com.google.firestore.bundle.BundledQuery.LimitType;
import com.google.firestore.bundle.NamedQuery;
import com.google.firestore.v1.RunQueryRequest;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ITSystemTest extends ITBaseTest {

  private static final double DOUBLE_EPSILON = 0.000001;

  private final Map<String, Object> SINGLE_FIELD_MAP = LocalFirestoreHelper.SINGLE_FIELD_MAP;
  private final Map<String, Object> ALL_SUPPORTED_TYPES_MAP =
      LocalFirestoreHelper.ALL_SUPPORTED_TYPES_MAP;
  private final SingleField SINGLE_FIELD_OBJECT = LocalFirestoreHelper.SINGLE_FIELD_OBJECT;
  private final AllSupportedTypes ALL_SUPPORTED_TYPES_OBJECT =
      LocalFirestoreHelper.ALL_SUPPORTED_TYPES_OBJECT;
  private final Map<String, Object> SINGLE_FILED_MAP_WITH_DOT =
      LocalFirestoreHelper.SINGLE_FILED_MAP_WITH_DOT;

  @Rule public TestName testName = new TestName();

  private CollectionReference randomColl;
  private DocumentReference randomDoc;

  @Before
  public void before() throws Exception {
    super.before();

    randomColl =
        firestore.collection(
            String.format("java-%s-%s", testName.getMethodName(), LocalFirestoreHelper.autoId()));
    randomDoc = randomColl.document();
  }

  private DocumentReference setDocument(String documentId, Map<String, ?> fields) throws Exception {
    DocumentReference documentReference = randomColl.document(documentId);
    documentReference.set(fields).get();
    return documentReference;
  }

  private DocumentReference addDocument(String key, Object value, Object... fields)
      throws Exception {
    DocumentReference documentReference = randomColl.document();
    documentReference.update(Precondition.NONE, key, value, fields).get();
    return documentReference;
  }

  private List<String> querySnapshotToIds(QuerySnapshot querySnapshot) {
    List<String> documentIds = new ArrayList<>();
    for (QueryDocumentSnapshot snapshot : querySnapshot.getDocuments()) {
      documentIds.add(snapshot.getId());
    }
    return documentIds;
  }

  @Test
  public void getAll() throws Exception {
    DocumentReference ref1 = randomColl.document("doc1");
    DocumentReference ref2 = randomColl.document("doc2");

    ApiFutures.allAsList(ImmutableList.of(ref1.set(SINGLE_FIELD_MAP), ref2.set(SINGLE_FIELD_MAP)))
        .get();

    List<DocumentSnapshot> documentSnapshots = firestore.getAll(ref1, ref2).get();
    assertEquals(2, documentSnapshots.size());
    assertEquals("doc1", documentSnapshots.get(0).getId());
    assertEquals(SINGLE_FIELD_OBJECT, documentSnapshots.get(0).toObject(SingleField.class));
    assertEquals("doc2", documentSnapshots.get(1).getId());
    assertEquals(SINGLE_FIELD_OBJECT, documentSnapshots.get(1).toObject(SingleField.class));
  }

  @Test
  public void getAllWithFieldMask() throws Exception {
    DocumentReference ref = randomColl.document("doc1");
    ref.set(ALL_SUPPORTED_TYPES_MAP).get();
    List<DocumentSnapshot> documentSnapshots =
        firestore.getAll(new DocumentReference[] {ref}, FieldMask.of("foo")).get();
    assertEquals(map("foo", "bar"), documentSnapshots.get(0).getData());
  }

  @Test
  public void getFieldMaskWithDocumentReference() throws Exception {
    DocumentReference ref = randomColl.document("doc1");
    ref.set(ALL_SUPPORTED_TYPES_MAP).get();
    DocumentSnapshot documentSnapshots = ref.get(FieldMask.of("foo", "foobar")).get();
    assertEquals("bar", documentSnapshots.get("foo"));
    assertNull(documentSnapshots.get("foobar"));
  }

  @Test
  public void addDocument() throws Exception {
    DocumentReference documentReference = randomColl.add(SINGLE_FIELD_MAP).get();
    assertEquals(20, documentReference.getId().length());
    DocumentSnapshot documentSnapshot = documentReference.get().get();
    assertEquals(SINGLE_FIELD_OBJECT, documentSnapshot.toObject(SingleField.class));
  }

  @Test
  public void createDocument() throws Exception {
    assertEquals(20, randomDoc.getId().length());
    randomDoc.create(SINGLE_FIELD_MAP).get();
    DocumentSnapshot documentSnapshot = randomDoc.get().get();
    assertEquals(SINGLE_FIELD_OBJECT, documentSnapshot.toObject(SingleField.class));
  }

  @Test
  public void createDocumentWithValue() throws Exception {
    assertEquals(20, randomDoc.getId().length());
    randomDoc.create(LocalFirestoreHelper.SINGLE_FIELD_PROTO).get();
    DocumentSnapshot documentSnapshot = randomDoc.get().get();
    assertEquals(SINGLE_FIELD_OBJECT, documentSnapshot.toObject(SingleField.class));
  }

  @Test
  public void createDocumentWithFloat() throws Exception {
    assertEquals(20, randomDoc.getId().length());
    randomDoc.create(LocalFirestoreHelper.SINGLE_FLOAT_PROTO).get();
    DocumentSnapshot documentSnapshot = randomDoc.get().get();
    assertEquals(SINGLE_FIELD_OBJECT, documentSnapshot.toObject(SingleField.class));
  }

  @Test
  public void setDocument() throws Exception {
    Map<String, Object> nanNullMap = new HashMap<>();
    nanNullMap.put("nan", Double.NaN);
    nanNullMap.put("null", null);
    randomDoc.set(nanNullMap).get();
    DocumentSnapshot documentSnapshot = randomDoc.get().get();
    assertEquals((Double) Double.NaN, documentSnapshot.getDouble("nan"));
    assertEquals(null, documentSnapshot.get("null"));
  }

  @Test
  public void setDocumentWithValue() throws Exception {
    assertEquals(20, randomDoc.getId().length());
    randomDoc.set(LocalFirestoreHelper.SINGLE_FIELD_PROTO).get();
    DocumentSnapshot documentSnapshot = randomDoc.get().get();
    assertEquals(SINGLE_FIELD_OBJECT, documentSnapshot.toObject(SingleField.class));
  }

  @Test
  public void setDocumentWithFloat() throws Exception {
    assertEquals(20, randomDoc.getId().length());
    randomDoc.set(LocalFirestoreHelper.SINGLE_FLOAT_PROTO).get();
    DocumentSnapshot documentSnapshot = randomDoc.get().get();
    assertEquals(SINGLE_FIELD_OBJECT, documentSnapshot.toObject(SingleField.class));
  }

  @Test
  public void setDocumentWithMerge() throws Exception {
    Map<String, Object> originalMap = LocalFirestoreHelper.map("a.b", "c", "nested", map("d", "e"));
    Map<String, Object> updateMap = LocalFirestoreHelper.map("f.g", "h", "nested", map("i", "j"));
    Map<String, Object> resultMap =
        LocalFirestoreHelper.map("a.b", "c", "f.g", "h", "nested", map("d", "e", "i", "j"));
    randomDoc.set(originalMap).get();
    randomDoc.set(updateMap, SetOptions.merge()).get();
    DocumentSnapshot documentSnapshot = randomDoc.get().get();
    assertEquals(resultMap, documentSnapshot.getData());
  }

  @Test
  public void setWithIncrementAndMerge() throws ExecutionException, InterruptedException {
    DocumentReference docRef = randomColl.document();
    docRef.set(Collections.singletonMap("sum", 1L)).get();
    docRef.set(Collections.singletonMap("sum", FieldValue.increment(2)), SetOptions.merge()).get();
    DocumentSnapshot docSnap = docRef.get().get();
    assertEquals(3L, docSnap.get("sum"));
  }

  @Test
  public void mergeDocumentWithServerTimestamp() throws Exception {
    Map<String, Object> originalMap = LocalFirestoreHelper.map("a", "b");
    Map<String, FieldValue> updateMap = map("c", FieldValue.serverTimestamp());
    randomDoc.set(originalMap).get();
    randomDoc.set(updateMap, SetOptions.merge()).get();
    DocumentSnapshot documentSnapshot = randomDoc.get().get();
    assertEquals("b", documentSnapshot.getString("a"));
    assertNotNull(documentSnapshot.getDate("c"));
  }

  @Test
  public void updateDocument() throws Exception {
    AllSupportedTypes expectedResult = new AllSupportedTypes();
    WriteResult writeResult = randomDoc.set(ALL_SUPPORTED_TYPES_MAP).get();
    DocumentSnapshot documentSnapshot = randomDoc.get().get();
    assertEquals(expectedResult, documentSnapshot.toObject(AllSupportedTypes.class));
    randomDoc.update(Precondition.updatedAt(writeResult.getUpdateTime()), "foo", "updated").get();
    documentSnapshot = randomDoc.get().get();
    expectedResult.foo = "updated";
    assertEquals(expectedResult, documentSnapshot.toObject(AllSupportedTypes.class));
    expectedResult.model = ImmutableMap.of("foo", UPDATE_SINGLE_FIELD_OBJECT.foo);
    randomDoc.update("model", UPDATE_SINGLE_FIELD_OBJECT).get();
    documentSnapshot = randomDoc.get().get();
    assertEquals(expectedResult, documentSnapshot.toObject(AllSupportedTypes.class));
  }

  @Test(expected = ExecutionException.class)
  public void updateDocumentExists() throws Exception {
    randomDoc.update(SINGLE_FIELD_MAP).get();
  }

  @Test
  public void serverTimestamp() throws Exception {
    randomDoc.set(map("time", FieldValue.serverTimestamp())).get();
    DocumentSnapshot documentSnapshot = randomDoc.get().get();
    assertTrue(documentSnapshot.getDate("time").getTime() > 0);
  }

  @Test
  public void timestampDoesntGetTruncatedDuringUpdate() throws Exception {
    DocumentReference documentReference =
        addDocument("time", Timestamp.ofTimeSecondsAndNanos(0, 123000));
    DocumentSnapshot documentSnapshot = documentReference.get().get();

    Timestamp timestamp = documentSnapshot.getTimestamp("time");
    documentReference.update("time", timestamp);

    documentSnapshot = documentReference.get().get();
    timestamp = documentSnapshot.getTimestamp("time");
    assertEquals(123000, timestamp.getNanos());
  }

  @Test
  public void fieldDelete() throws Exception {
    Map<String, Object> fields = new HashMap<>();
    fields.put("foo1", "bar1");
    fields.put("foo2", "bar2");
    randomDoc.set(fields).get();

    DocumentSnapshot documentSnapshot = randomDoc.get().get();
    assertEquals("bar1", documentSnapshot.getString("foo1"));
    assertEquals("bar2", documentSnapshot.getString("foo2"));
    randomDoc.update("foo1", "bar3", "foo2", FieldValue.delete()).get();
    documentSnapshot = randomDoc.get().get();
    assertEquals("bar3", documentSnapshot.getString("foo1"));
    assertNull(documentSnapshot.getString("foo2"));
  }

  @Test
  public void deleteDocument() throws Exception {
    randomDoc.delete().get();
    WriteResult writeResult = randomDoc.set(ALL_SUPPORTED_TYPES_MAP).get();
    try {
      randomDoc.delete(Precondition.updatedAt(Timestamp.ofTimeSecondsAndNanos(1, 0))).get();
      fail();
    } catch (ExecutionException e) {
      assertTrue(e.getMessage().contains("FAILED_PRECONDITION"));
    }
    writeResult = randomDoc.delete(Precondition.updatedAt(writeResult.getUpdateTime())).get();
    DocumentSnapshot documentSnapshot = randomDoc.get().get();
    assertFalse(documentSnapshot.exists());
    assertTrue(writeResult.getUpdateTime().getSeconds() > 0);
  }

  @Test
  public void defaultQuery() throws Exception {
    addDocument("foo", "bar");
    addDocument("foo", "bar");

    QuerySnapshot querySnapshot = randomColl.get().get();
    assertEquals(2, querySnapshot.size());

    Iterator<QueryDocumentSnapshot> documents = querySnapshot.iterator();
    assertEquals("bar", documents.next().get("foo"));
    assertEquals("bar", documents.next().get("foo"));
  }

  @Test
  public void defaultQueryStream() throws Exception {
    addDocument("foo", "bar");
    addDocument("foo", "bar");

    final Semaphore semaphore = new Semaphore(0);
    final Iterator<String> iterator = Arrays.asList("bar", "bar").iterator();
    randomColl.stream(
        new ApiStreamObserver<DocumentSnapshot>() {
          @Override
          public void onNext(DocumentSnapshot documentSnapshot) {
            assertEquals(iterator.next(), documentSnapshot.get("foo"));
          }

          @Override
          public void onError(Throwable throwable) {}

          @Override
          public void onCompleted() {
            semaphore.release();
          }
        });

    semaphore.acquire();
    // Verify the number of response
    assertFalse(iterator.hasNext());
  }

  @Test
  public void largeQuery() throws Exception {
    int count = 100;
    while (count-- > 0) {
      addDocument("foo", "bar");
    }

    QuerySnapshot querySnapshot = randomColl.get().get();
    assertEquals(100, querySnapshot.size());
  }

  @Test
  public void largeQueryStream() throws Exception {
    int count = 100;
    while (count-- > 0) {
      addDocument("foo", "bar");
    }

    final Semaphore semaphore = new Semaphore(0);
    final int[] docCount = {0};
    randomColl.stream(
        new ApiStreamObserver<DocumentSnapshot>() {
          @Override
          public void onNext(DocumentSnapshot documentSnapshot) {
            docCount[0]++;
          }

          @Override
          public void onError(Throwable throwable) {
            fail();
          }

          @Override
          public void onCompleted() {
            semaphore.release();
          }
        });

    semaphore.acquire();
    // Verify the number of response
    assertEquals(100, docCount[0]);
  }

  @Test
  public void noResults() throws Exception {
    QuerySnapshot querySnapshot = randomColl.get().get();
    assertTrue(querySnapshot.isEmpty());
    assertNotNull(querySnapshot.getReadTime());
  }

  @Test
  public void noResultsStream() throws Exception {
    final Semaphore semaphore = new Semaphore(0);
    final int[] docCount = {0};
    randomColl.stream(
        new ApiStreamObserver<DocumentSnapshot>() {
          @Override
          public void onNext(DocumentSnapshot documentSnapshot) {
            docCount[0]++;
          }

          @Override
          public void onError(Throwable throwable) {
            fail();
          }

          @Override
          public void onCompleted() {
            semaphore.release();
          }
        });

    semaphore.acquire();
    // Verify the number of response
    assertEquals(0, docCount[0]);
  }

  @Test
  public void queryWithMicrosecondPrecision() throws Exception {
    Timestamp microsecondTimestamp = Timestamp.ofTimeSecondsAndNanos(0, 123000);

    DocumentReference documentReference = addDocument("time", microsecondTimestamp);
    DocumentSnapshot documentSnapshot = documentReference.get().get();

    Query query = randomColl.whereEqualTo("time", microsecondTimestamp);
    QuerySnapshot querySnapshot = query.get().get();
    assertEquals(1, querySnapshot.size());

    // Using `.toDate()` truncates to millseconds, and hence the query doesn't match.
    query = randomColl.whereEqualTo("time", microsecondTimestamp.toDate());
    querySnapshot = query.get().get();
    assertEquals(0, querySnapshot.size());
  }

  @Test
  public void nestedQuery() throws Exception {
    randomColl = randomColl.document("foo").collection("bar");
    addDocument("foo", "bar");

    QuerySnapshot querySnapshot = randomColl.get().get();
    DocumentSnapshot documentSnapshot = querySnapshot.getDocuments().get(0);
    assertTrue(documentSnapshot.getReference().getPath().contains("/foo/bar"));
  }

  @Test
  public void limitQuery() throws Exception {
    setDocument("doc1", Collections.singletonMap("counter", 1));
    setDocument("doc2", Collections.singletonMap("counter", 2));
    setDocument("doc3", Collections.singletonMap("counter", 3));

    QuerySnapshot querySnapshot = randomColl.orderBy("counter").limit(2).get().get();
    assertEquals(asList("doc1", "doc2"), querySnapshotToIds(querySnapshot));
  }

  @Test
  public void limitQueryStream() throws Exception {
    setDocument("doc1", Collections.singletonMap("counter", 1));
    setDocument("doc2", Collections.singletonMap("counter", 2));
    setDocument("doc3", Collections.singletonMap("counter", 3));

    final Semaphore semaphore = new Semaphore(0);
    final Iterator<String> iterator = Arrays.asList("doc1", "doc2").iterator();
    randomColl.orderBy("counter").limit(2).stream(
        new ApiStreamObserver<DocumentSnapshot>() {
          @Override
          public void onNext(DocumentSnapshot documentSnapshot) {
            assertEquals(iterator.next(), documentSnapshot.getId());
          }

          @Override
          public void onError(Throwable throwable) {
            fail();
          }

          @Override
          public void onCompleted() {
            semaphore.release();
          }
        });

    semaphore.acquire();
    // Verify the number of response
    assertFalse(iterator.hasNext());
  }

  @Test
  public void limitToLastQuery() throws Exception {
    setDocument("doc1", Collections.singletonMap("counter", 1));
    setDocument("doc2", Collections.singletonMap("counter", 2));
    setDocument("doc3", Collections.singletonMap("counter", 3));

    QuerySnapshot querySnapshot = randomColl.orderBy("counter").limitToLast(2).get().get();
    assertEquals(asList("doc2", "doc3"), querySnapshotToIds(querySnapshot));
  }

  @Test
  public void largerLimitQuery() throws Exception {
    setDocument("doc1", Collections.singletonMap("counter", 1));
    setDocument("doc2", Collections.singletonMap("counter", 2));
    setDocument("doc3", Collections.singletonMap("counter", 3));

    QuerySnapshot querySnapshot = randomColl.orderBy("counter").limit(4).get().get();
    assertEquals(asList("doc1", "doc2", "doc3"), querySnapshotToIds(querySnapshot));
  }

  @Test
  public void largerLimitQueryStream() throws Exception {
    setDocument("doc1", Collections.singletonMap("counter", 1));
    setDocument("doc2", Collections.singletonMap("counter", 2));
    setDocument("doc3", Collections.singletonMap("counter", 3));

    final Semaphore semaphore = new Semaphore(0);
    final Iterator<String> iterator = Arrays.asList("doc1", "doc2", "doc3").iterator();
    randomColl.orderBy("counter").limit(4).stream(
        new ApiStreamObserver<DocumentSnapshot>() {
          @Override
          public void onNext(DocumentSnapshot documentSnapshot) {
            assertEquals(iterator.next(), documentSnapshot.getId());
          }

          @Override
          public void onError(Throwable throwable) {
            fail();
          }

          @Override
          public void onCompleted() {
            semaphore.release();
          }
        });

    semaphore.acquire();
    // Verify the number of response
    assertFalse(iterator.hasNext());
  }

  @Test
  public void offsetQuery() throws Exception {
    addDocument("foo", "bar");
    addDocument("foo", "bar");

    QuerySnapshot querySnapshot = randomColl.offset(1).get().get();
    assertEquals(1, querySnapshot.size());
    assertEquals("bar", querySnapshot.getDocuments().get(0).get("foo"));
  }

  @Test
  public void offsetQueryStream() throws Exception {
    addDocument("foo", "bar");
    addDocument("foo", "bar");

    final Semaphore semaphore = new Semaphore(0);
    final Iterator<String> iterator = Collections.singletonList("bar").iterator();
    randomColl.offset(1).stream(
        new ApiStreamObserver<DocumentSnapshot>() {
          @Override
          public void onNext(DocumentSnapshot documentSnapshot) {
            assertEquals(iterator.next(), documentSnapshot.get("foo"));
          }

          @Override
          public void onError(Throwable throwable) {
            fail();
          }

          @Override
          public void onCompleted() {
            semaphore.release();
          }
        });

    semaphore.acquire();
    // Verify the number of response
    assertFalse(iterator.hasNext());
  }

  @Test
  public void largerOffsetQuery() throws Exception {
    addDocument("foo", "bar");
    addDocument("foo", "bar");

    QuerySnapshot querySnapshot = randomColl.offset(3).get().get();
    assertEquals(0, querySnapshot.size());
  }

  @Test
  public void largerOffsetQueryStream() throws Exception {
    addDocument("foo", "bar");
    addDocument("foo", "bar");

    final Semaphore semaphore = new Semaphore(0);
    final int[] docCount = {0};
    randomColl.offset(3).stream(
        new ApiStreamObserver<DocumentSnapshot>() {
          @Override
          public void onNext(DocumentSnapshot documentSnapshot) {
            docCount[0]++;
          }

          @Override
          public void onError(Throwable throwable) {
            fail();
          }

          @Override
          public void onCompleted() {
            semaphore.release();
          }
        });

    semaphore.acquire();
    // Verify the number of response
    assertEquals(0, docCount[0]);
  }

  @Test
  public void orderByQuery() throws Exception {
    addDocument("foo", 1);
    addDocument("foo", 2);

    QuerySnapshot querySnapshot = randomColl.orderBy("foo").get().get();
    Iterator<QueryDocumentSnapshot> documents = querySnapshot.iterator();
    assertEquals(1L, documents.next().get("foo"));
    assertEquals(2L, documents.next().get("foo"));

    querySnapshot = randomColl.orderBy("foo", Query.Direction.DESCENDING).get().get();
    documents = querySnapshot.iterator();
    assertEquals(2L, documents.next().get("foo"));
    assertEquals(1L, documents.next().get("foo"));
  }

  @Test
  public void orderByQueryStream() throws Exception {
    addDocument("foo", 1);
    addDocument("foo", 2);

    final Semaphore semaphore = new Semaphore(0);
    final Iterator<Long> iteratorAscending = Arrays.asList(1L, 2L).iterator();
    randomColl.orderBy("foo").stream(
        new ApiStreamObserver<DocumentSnapshot>() {
          @Override
          public void onNext(DocumentSnapshot documentSnapshot) {
            assertEquals(iteratorAscending.next(), documentSnapshot.get("foo"));
          }

          @Override
          public void onError(Throwable throwable) {
            fail();
          }

          @Override
          public void onCompleted() {
            semaphore.release();
          }
        });

    semaphore.acquire();
    // Verify the number of response
    assertFalse(iteratorAscending.hasNext());

    final Iterator<Long> iteratorDescending = Arrays.asList(2L, 1L).iterator();
    randomColl.orderBy("foo", Query.Direction.DESCENDING).stream(
        new ApiStreamObserver<DocumentSnapshot>() {
          @Override
          public void onNext(DocumentSnapshot documentSnapshot) {
            assertEquals(iteratorDescending.next(), documentSnapshot.get("foo"));
          }

          @Override
          public void onError(Throwable throwable) {
            fail();
          }

          @Override
          public void onCompleted() {
            semaphore.release();
          }
        });

    semaphore.acquire();
    // Verify the number of response
    assertFalse(iteratorDescending.hasNext());
  }

  @Test
  public void selectQuery() throws Exception {
    addDocument("foo", 1, "bar", 2);

    QuerySnapshot querySnapshot = randomColl.select("foo").get().get();
    assertEquals(1, querySnapshot.size());
    DocumentSnapshot documentSnapshot = querySnapshot.getDocuments().get(0);
    assertEquals(1L, documentSnapshot.get("foo"));
    assertNull(documentSnapshot.get("bar"));
  }

  @Test
  public void equalsQuery() throws Exception {
    addDocument("foo", 1);
    addDocument("foo", 2);

    QuerySnapshot querySnapshot = randomColl.whereEqualTo("foo", 1).get().get();
    assertEquals(1, querySnapshot.size());
    assertEquals(1L, querySnapshot.getDocuments().get(0).get("foo"));
  }

  @Test
  public void greaterThanQuery() throws Exception {
    addDocument("foo", 1);
    addDocument("foo", 2);

    QuerySnapshot querySnapshot = randomColl.whereGreaterThan("foo", 1).get().get();
    assertEquals(1, querySnapshot.size());
    assertEquals(2L, querySnapshot.getDocuments().get(0).get("foo"));
  }

  @Test
  public void multipleInequalityQueryOnSamePropertiesShouldBeSupported() throws Exception {
    addDocument("foo", 1);

    QuerySnapshot querySnapshot =
        randomColl.whereGreaterThan("foo", 0).whereLessThanOrEqualTo("foo", 2).get().get();
    assertEquals(1, querySnapshot.size());
    assertEquals(1L, querySnapshot.getDocuments().get(0).get("foo"));
  }

  @Test
  public void multipleInequalityQueryOnDifferentPropertiesShouldBeSupported() throws Exception {
    // TODO(MIEQ): Enable this test against production when possible.
    assumeTrue(
        "Skip this test if running against production because multiple inequality is "
            + "not supported yet.",
        isRunningAgainstFirestoreEmulator(firestore));

    addDocument("foo", 1, "bar", 2);

    QuerySnapshot querySnapshot =
        randomColl.whereGreaterThan("foo", 0).whereLessThanOrEqualTo("bar", 2).get().get();
    assertEquals(1, querySnapshot.size());
    assertEquals(1L, querySnapshot.getDocuments().get(0).get("foo"));
  }

  @Test
  public void greaterThanOrEqualQuery() throws Exception {
    addDocument("foo", 1);
    addDocument("foo", 2);

    QuerySnapshot querySnapshot = randomColl.whereGreaterThanOrEqualTo("foo", 1).get().get();
    assertEquals(2, querySnapshot.size());
  }

  @Test
  public void lessThanQuery() throws Exception {
    addDocument("foo", 1);
    addDocument("foo", 2);

    QuerySnapshot querySnapshot = randomColl.whereLessThan("foo", 2).get().get();
    assertEquals(1, querySnapshot.size());
    assertEquals(1L, querySnapshot.getDocuments().get(0).get("foo"));
  }

  @Test
  public void lessThanOrEqualQuery() throws Exception {
    addDocument("foo", 1);
    addDocument("foo", 2);

    QuerySnapshot querySnapshot = randomColl.whereLessThanOrEqualTo("foo", 2).get().get();
    assertEquals(2, querySnapshot.size());
  }

  @Test
  public void unaryQuery() throws Exception {
    addDocument("foo", 1, "bar", Double.NaN);
    addDocument("foo", 2, "bar", null);

    QuerySnapshot querySnapshot = randomColl.whereEqualTo("bar", Double.NaN).get().get();
    assertEquals(1, querySnapshot.size());
    DocumentSnapshot documentSnapshot = querySnapshot.getDocuments().get(0);
    assertEquals(1L, documentSnapshot.get("foo"));
    assertEquals(Double.NaN, documentSnapshot.get("bar"));

    querySnapshot = randomColl.whereEqualTo("bar", null).get().get();
    assertEquals(1, querySnapshot.size());
    documentSnapshot = querySnapshot.getDocuments().get(0);
    assertEquals(2L, documentSnapshot.get("foo"));
    assertNull(documentSnapshot.get("bar"));
  }

  @Test
  public void startAt() throws Exception {
    addDocument("foo", 1);
    addDocument("foo", 2);

    QuerySnapshot querySnapshot = randomColl.orderBy("foo").startAt(1).get().get();
    assertEquals(2, querySnapshot.size());
    Iterator<QueryDocumentSnapshot> documents = querySnapshot.iterator();
    assertEquals(1L, documents.next().get("foo"));
    assertEquals(2L, documents.next().get("foo"));
  }

  @Test
  public void startAfter() throws Exception {
    addDocument("foo", 1);
    addDocument("foo", 2);

    QuerySnapshot querySnapshot = randomColl.orderBy("foo").startAfter(1).get().get();
    assertEquals(1, querySnapshot.size());
    assertEquals(2L, querySnapshot.getDocuments().get(0).get("foo"));
  }

  @Test
  public void startAfterAddsAnImplicitOrderByForDocumentReferences() throws Exception {
    DocumentReference doc1 = randomColl.document("doc1");
    DocumentReference doc2 = randomColl.document("doc2");

    doc1.set(map("foo", 1)).get();
    doc2.set(map("foo", 1)).get();

    QuerySnapshot querySnapshot = randomColl.startAfter(doc1).get().get();
    assertEquals(1, querySnapshot.size());
    Iterator<QueryDocumentSnapshot> documents = querySnapshot.iterator();
    assertEquals(doc2, documents.next().getReference());
  }

  @Test
  public void endAt() throws Exception {
    addDocument("foo", 1);
    addDocument("foo", 2);

    QuerySnapshot querySnapshot = randomColl.orderBy("foo").endAt(2).get().get();
    assertEquals(2, querySnapshot.size());
    Iterator<QueryDocumentSnapshot> documents = querySnapshot.iterator();
    assertEquals(1L, documents.next().get("foo"));
    assertEquals(2L, documents.next().get("foo"));
  }

  @Test
  public void endBefore() throws Exception {
    addDocument("foo", 1);
    addDocument("foo", 2);

    QuerySnapshot querySnapshot = randomColl.orderBy("foo").endBefore(2).get().get();
    assertEquals(1, querySnapshot.size());
    assertEquals(1L, querySnapshot.getDocuments().get(0).get("foo"));
  }

  @Test
  public void partitionedQuery() throws Exception {
    assumeFalse(
        "Partitioned query is not supported with enterprise yet",
        getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    // Partitioned queries are not supported in the emulator.
    assumeFalse(
        "Skip this test when running against the Firestore emulator because it does not support"
            + " partitioned queries.",
        isRunningAgainstFirestoreEmulator(firestore));

    int documentCount = 2 * 128 + 127; // Minimum partition size is 128.

    WriteBatch batch = firestore.batch();
    for (int i = 0; i < documentCount; ++i) {
      batch.create(randomColl.document(), map("foo", i));
    }
    batch.commit().get();

    StreamConsumer<QueryPartition> consumer = new StreamConsumer<>();
    firestore.collectionGroup(randomColl.getId()).getPartitions(3, consumer);
    final List<QueryPartition> partitions = consumer.consume().get();

    assertNull(partitions.get(0).getStartAt());
    for (int i = 0; i < partitions.size() - 1; ++i) {
      assertArrayEquals(partitions.get(i).getEndBefore(), partitions.get(i + 1).getStartAt());
    }
    assertNull(partitions.get(partitions.size() - 1).getEndBefore());

    // Validate that we can use the partitions to read the original documents.
    int resultCount = 0;
    for (QueryPartition partition : partitions) {
      resultCount += partition.createQuery().get().get().size();
    }
    assertEquals(documentCount, resultCount);
  }

  @Test
  public void partitionedQuery_future() throws Exception {
    assumeFalse(
        "Partitioned query is not supported with enterprise yet",
        getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    // Partitioned queries are not supported in the emulator.
    assumeFalse(
        "Skip this test when running against the Firestore emulator because it does not support"
            + " partitioned queries.",
        isRunningAgainstFirestoreEmulator(firestore));

    int documentCount = 2 * 128 + 127; // Minimum partition size is 128.

    WriteBatch batch = firestore.batch();
    for (int i = 0; i < documentCount; ++i) {
      batch.create(randomColl.document(), map("foo", i));
    }
    batch.commit().get();

    ApiFuture<List<QueryPartition>> future =
        firestore.collectionGroup(randomColl.getId()).getPartitions(3);
    final List<QueryPartition> partitions = future.get();

    assertNull(partitions.get(0).getStartAt());
    for (int i = 0; i < partitions.size() - 1; ++i) {
      assertArrayEquals(partitions.get(i).getEndBefore(), partitions.get(i + 1).getStartAt());
    }
    assertNull(partitions.get(partitions.size() - 1).getEndBefore());

    // Validate that we can use the partitions to read the original documents.
    int resultCount = 0;
    for (QueryPartition partition : partitions) {
      resultCount += partition.createQuery().get().get().size();
    }
    assertEquals(documentCount, resultCount);
  }

  @Test
  public void emptyPartitionedQuery() throws Exception {
    assumeFalse(
        "Partitioned query is not supported with enterprise yet",
        getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    // Partitioned queries are not supported in the emulator.
    assumeFalse(
        "Skip this test when running against the Firestore emulator because it does not support"
            + " partitioned queries.",
        isRunningAgainstFirestoreEmulator(firestore));

    StreamConsumer<QueryPartition> consumer = new StreamConsumer<>();
    firestore.collectionGroup(randomColl.getId()).getPartitions(3, consumer);
    final List<QueryPartition> partitions = consumer.consume().get();

    assertEquals(1, partitions.size());
    assertNull(partitions.get(0).getStartAt());
    assertNull(partitions.get(0).getEndBefore());
  }

  @Test
  public void validatesPartitionCount() {
    StreamConsumer<QueryPartition> consumer = new StreamConsumer<>();
    try {
      firestore.collectionGroup(randomColl.getId()).getPartitions(0, consumer);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Desired partition count must be one or greater", e.getMessage());
    }
  }

  @Test
  public void failedTransaction() {
    try {
      firestore
          .runTransaction(
              (Function<String>)
                  transaction -> {
                    throw new RuntimeException("User exception");
                  })
          .get();
      fail();
    } catch (Exception e) {
      assertTrue(e.getMessage().endsWith("User exception"));
    }
  }

  @Test
  public void asyncTxFailsWithUserError() throws Exception {
    try {
      firestore
          .runAsyncTransaction(
              (Transaction.AsyncFunction<String>)
                  transaction -> {
                    throw new RuntimeException("User exception");
                  })
          .get();
      fail();
    } catch (Exception e) {
      assertTrue(e.getMessage().endsWith("User exception"));
    }
  }

  @Test
  public void doesNotRetryTransactionsWithFailedPreconditions() {
    final DocumentReference documentReference = randomColl.document();

    final AtomicInteger attempts = new AtomicInteger();

    ApiFuture<Void> firstTransaction =
        firestore.runTransaction(
            transaction -> {
              attempts.incrementAndGet();
              transaction.update(documentReference, "foo", "bar");
              return null;
            });

    try {
      firstTransaction.get();
      fail("ApiFuture should fail with ExecutionException");
    } catch (InterruptedException e) {
      fail("ApiFuture should fail with ExecutionException");
    } catch (ExecutionException e) {
      assertEquals(1, attempts.intValue());
      assertEquals(404, ((FirestoreException) e.getCause()).getCode());
    }
  }

  @Test
  public void successfulTransactionWithContention() throws Exception {
    final DocumentReference documentReference = addDocument("counter", 1);

    final CountDownLatch latch = new CountDownLatch(2);
    final AtomicInteger attempts = new AtomicInteger();

    // One of these transaction fails and has to be retried since they both acquire locks on the
    // same document, which they then modify.
    ApiFuture<String> firstTransaction =
        firestore.runTransaction(
            transaction -> {
              attempts.incrementAndGet();
              DocumentSnapshot documentSnapshot = transaction.get(documentReference).get();
              latch.countDown();
              latch.await();
              transaction.update(
                  documentReference, "counter", documentSnapshot.getLong("counter") + 1);
              return "foo";
            });

    ApiFuture<String> secondTransaction =
        firestore.runTransaction(
            transaction -> {
              attempts.incrementAndGet();
              List<DocumentSnapshot> documentSnapshots =
                  transaction.getAll(documentReference).get();
              latch.countDown();
              latch.await();
              transaction.update(
                  documentReference, "counter", documentSnapshots.get(0).getLong("counter") + 1);
              return "bar";
            });

    assertEquals("foo", firstTransaction.get());
    assertEquals("bar", secondTransaction.get());
    assertThat(attempts.intValue()).isAtLeast(3);
    assertEquals(3, (long) documentReference.get().get().getLong("counter"));
  }

  @Test
  public void writeBatch() throws Exception {
    DocumentReference createDocument = randomColl.document();
    DocumentReference setDocument = randomColl.document();
    DocumentReference updateDocument = addDocument("foo", "bar");
    DocumentReference deleteDocument = addDocument("foo", "bar");

    WriteBatch batch = firestore.batch();

    batch.create(createDocument, SINGLE_FIELD_OBJECT);
    batch.set(setDocument, ALL_SUPPORTED_TYPES_OBJECT);
    batch.update(updateDocument, "foo", "foobar");
    batch.delete(deleteDocument);

    batch.commit().get();

    List<DocumentSnapshot> documentSnapshots =
        firestore.getAll(createDocument, setDocument, updateDocument, deleteDocument).get();

    Iterator<DocumentSnapshot> iterator = documentSnapshots.iterator();
    assertEquals(SINGLE_FIELD_OBJECT, iterator.next().toObject(SingleField.class));
    assertEquals(ALL_SUPPORTED_TYPES_OBJECT, iterator.next().toObject(AllSupportedTypes.class));
    assertEquals("foobar", iterator.next().get("foo"));
    assertFalse(iterator.next().exists());
  }

  @Test
  public void omitWriteResultForDocumentTransforms()
      throws ExecutionException, InterruptedException {
    WriteBatch batch = firestore.batch();
    batch.set(randomColl.document(), SINGLE_FIELD_MAP);
    batch.set(randomColl.document(), map("time", FieldValue.serverTimestamp()));
    List<WriteResult> writeResults = batch.commit().get();
    assertEquals(2, writeResults.size());
  }

  @Test
  public void listCollections() throws Exception {
    assumeTrue(
        "Skip this test when running against enterprise because it does not support"
            + " listCollections",
        getFirestoreEdition() != FirestoreEdition.ENTERPRISE);

    // We test with 21 collections since 20 collections are by default returned in a single paged
    // response.
    String[] collections =
        new String[] {
          "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
          "17", "18", "19", "20", "21"
        };
    Arrays.sort(collections); // Sort in alphabetical (non-numeric) order.

    WriteBatch batch = firestore.batch();
    for (String collection : collections) {
      batch.create(randomDoc.collection(collection).document("doc"), SINGLE_FIELD_OBJECT);
    }
    batch.commit().get();

    Iterable<CollectionReference> collectionRefs = randomDoc.listCollections();

    int count = 0;
    for (CollectionReference collectionRef : collectionRefs) {
      assertEquals(collections[count++], collectionRef.getId());
    }
    assertEquals(collections.length, count);
  }

  @Test
  public void listDocuments() throws Exception {
    assumeTrue(
        "Skip this test when running against enterprise because it does not support listDocuments",
        getFirestoreEdition() != FirestoreEdition.ENTERPRISE);
    // We test with 21 documents since 20 documents are by default returned in a single paged
    // response.
    String[] documents =
        new String[] {
          "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
          "17", "18", "19", "20", "21"
        };
    Arrays.sort(documents); // Sort in alphabetical (non-numeric) order.

    WriteBatch batch = firestore.batch();
    for (String document : documents) {
      batch.create(randomColl.document(document), SINGLE_FIELD_OBJECT);
    }
    batch.commit().get();

    Iterable<DocumentReference> collectionRefs = randomColl.listDocuments();

    int count = 0;
    for (DocumentReference documentRef : collectionRefs) {
      assertEquals(documents[count++], documentRef.getId());
    }
    assertEquals(documents.length, count);
  }

  @Test
  public void listDocumentsListsMissingDocument() throws Exception {
    assumeFalse(
        "Skip this test when running against enterprise because it does not support"
            + " missing documents.",
        getFirestoreEdition() == FirestoreEdition.ENTERPRISE);

    randomColl.document("missing/foo/bar").set(SINGLE_FIELD_MAP).get();
    Iterable<DocumentReference> collectionRefs = randomColl.listDocuments();
    assertEquals(randomColl.document("missing"), collectionRefs.iterator().next());
  }

  @Test
  public void addAndRemoveFields() throws ExecutionException, InterruptedException {
    Map<String, Object> expected = new HashMap<>();

    randomDoc.create(Collections.emptyMap()).get();
    assertEquals(expected, getData());

    randomDoc.delete().get();
    assertFalse(randomDoc.get().get().exists());

    randomDoc.create(map("a", map("b", "c"))).get();
    expected.put("a", map("b", "c"));
    assertEquals(expected, getData());

    randomDoc.set(Collections.emptyMap()).get();
    expected = map();
    assertEquals(expected, getData());

    randomDoc.set(map("a", map("b", "c"))).get();
    expected.put("a", map("b", "c"));
    assertEquals(expected, getData());

    randomDoc.set(map("a", map("d", "e")), SetOptions.merge()).get();
    getNestedMap(expected, "a").put("d", "e");
    assertEquals(expected, getData());

    randomDoc
        .set(LocalFirestoreHelper.map("a", map("d", FieldValue.delete())), SetOptions.merge())
        .get();
    getNestedMap(expected, "a").remove("d");
    assertEquals(expected, getData());

    randomDoc
        .set(LocalFirestoreHelper.map("a", map("b", FieldValue.delete())), SetOptions.merge())
        .get();
    getNestedMap(expected, "a").remove("b");
    assertEquals(expected, getData());

    randomDoc.set(LocalFirestoreHelper.map("a", map("e", "foo")), SetOptions.merge()).get();
    getNestedMap(expected, "a").put("e", "foo");
    assertEquals(expected, getData());

    randomDoc.set(map("f", "foo"), SetOptions.merge()).get();
    expected.put("f", "foo");
    assertEquals(expected, getData());

    randomDoc.set(LocalFirestoreHelper.map("f", map("g", "foo")), SetOptions.merge()).get();
    expected.put("f", map("g", "foo"));
    assertEquals(expected, getData());

    randomDoc.update("f.h", "foo").get();
    getNestedMap(expected, "f").put("h", "foo");
    assertEquals(expected, getData());

    randomDoc.update("f.g", FieldValue.delete()).get();
    getNestedMap(expected, "f").remove("g");
    assertEquals(expected, getData());

    randomDoc.update("f.h", FieldValue.delete()).get();
    getNestedMap(expected, "f").remove("h");
    assertEquals(expected, getData());

    randomDoc.update("f", FieldValue.delete()).get();
    expected.remove("f");
    assertEquals(expected, getData());

    randomDoc.update("i.j", map()).get();
    expected.put("i", map("j", map()));
    assertEquals(expected, getData());

    randomDoc.update("i.j", map("k", "foo")).get();
    getNestedMap(expected, "i").put("j", map("k", "foo"));
    assertEquals(expected, getData());

    randomDoc.update("i.j", LocalFirestoreHelper.<String, Object>map("l", map("k", "foo"))).get();
    getNestedMap(expected, "i").put("j", map("l", map("k", "foo")));
    assertEquals(expected, getData());

    randomDoc.update("i.j", LocalFirestoreHelper.<String, Object>map("l", map())).get();
    getNestedMap(expected, "i").put("j", map("l", map()));
    assertEquals(expected, getData());

    randomDoc.update("i", FieldValue.delete()).get();
    expected.remove("i");
    assertEquals(expected, getData());

    randomDoc.update("a", FieldValue.delete()).get();
    expected.remove("a");
    assertEquals(expected, getData());
  }

  @Test
  public void addAndRemoveServerTimestamps() throws ExecutionException, InterruptedException {
    Map<String, Object> expected = new HashMap<>();

    randomDoc
        .create(
            map("time", FieldValue.serverTimestamp(), "a", map("b", FieldValue.serverTimestamp())))
        .get();
    Timestamp time = (Timestamp) getData().get("time");
    expected.put("time", time);
    expected.put("a", map("b", time));
    assertEquals(expected, getData());

    randomDoc
        .set(map("time", FieldValue.serverTimestamp(), "a", map("c", FieldValue.serverTimestamp())))
        .get();
    time = updateTime(expected);
    expected.put("a", map("c", time));
    assertEquals(expected, getData());

    randomDoc
        .set(
            map("time", FieldValue.serverTimestamp(), "e", FieldValue.serverTimestamp()),
            SetOptions.merge())
        .get();
    time = updateTime(expected);
    expected.put("e", time);
    assertEquals(expected, getData());

    randomDoc
        .set(
            map("time", FieldValue.serverTimestamp(), "e", map("f", FieldValue.serverTimestamp())),
            SetOptions.merge())
        .get();
    time = updateTime(expected);
    expected.put("e", map("f", time));
    assertEquals(expected, getData());

    randomDoc
        .update("time", FieldValue.serverTimestamp(), "g.h", FieldValue.serverTimestamp())
        .get();
    time = updateTime(expected);
    expected.put("g", map("h", time));
    assertEquals(expected, getData());

    randomDoc
        .update("time", FieldValue.serverTimestamp(), "g.j", map("k", FieldValue.serverTimestamp()))
        .get();
    time = updateTime(expected);
    getNestedMap(expected, "g").put("j", map("k", time));
    assertEquals(expected, getData());
  }

  private Timestamp updateTime(Map<String, Object> dataWithTime)
      throws ExecutionException, InterruptedException {
    Timestamp time = (Timestamp) getData().get("time");
    dataWithTime.put("time", time);
    return time;
  }

  private Map<String, Object> getNestedMap(Map<String, Object> map, String key) {
    return (Map<String, Object>) map.get(key);
  }

  private Map<String, Object> getData() throws ExecutionException, InterruptedException {
    return randomDoc.get().get().getData();
  }

  @Test
  public void writeAndReadVectorEmbeddings() throws ExecutionException, InterruptedException {
    Map<String, VectorValue> expected = new HashMap<>();

    randomDoc
        .create(
            map(
                "vector0",
                FieldValue.vector(new double[] {0.0}),
                "vector1",
                FieldValue.vector(new double[] {1, 2, 3.99})))
        .get();
    randomDoc
        .set(
            map(
                "vector0",
                FieldValue.vector(new double[] {0.0}),
                "vector1",
                FieldValue.vector(new double[] {1, 2, 3.99}),
                "vector2",
                FieldValue.vector(new double[] {0, 0, 0})))
        .get();
    randomDoc.update(map("vector3", FieldValue.vector(new double[] {-1, -200, -9999}))).get();

    expected.put("vector0", FieldValue.vector(new double[] {0.0}));
    expected.put("vector1", FieldValue.vector(new double[] {1, 2, 3.99}));
    expected.put("vector2", FieldValue.vector(new double[] {0, 0, 0}));
    expected.put("vector3", FieldValue.vector(new double[] {-1, -200, -9999}));

    DocumentSnapshot actual = randomDoc.get().get();

    assertTrue(actual.get("vector0") instanceof VectorValue);
    assertTrue(actual.get("vector1") instanceof VectorValue);
    assertTrue(actual.get("vector2") instanceof VectorValue);
    assertTrue(actual.get("vector3") instanceof VectorValue);

    assertArrayEquals(
        expected.get("vector0").toArray(),
        actual.get("vector0", VectorValue.class).toArray(),
        DOUBLE_EPSILON);
    assertArrayEquals(
        expected.get("vector1").toArray(),
        actual.get("vector1", VectorValue.class).toArray(),
        DOUBLE_EPSILON);
    assertArrayEquals(
        expected.get("vector2").toArray(),
        actual.get("vector2", VectorValue.class).toArray(),
        DOUBLE_EPSILON);
    assertArrayEquals(
        expected.get("vector3").toArray(),
        actual.get("vector3", VectorValue.class).toArray(),
        DOUBLE_EPSILON);
  }

  @Test
  public void listenToDocumentsWithVectors() throws Throwable {
    CompletableFuture<Void> listen = new CompletableFuture<>();
    ListenerRegistration registration = null;
    DocumentReference ref = randomColl.document();
    AtomicInteger snapshotCount = new AtomicInteger();

    try {
      registration =
          randomColl
              .whereEqualTo("purpose", "vector tests")
              .addSnapshotListener(
                  (value, error) -> {
                    try {
                      DocumentSnapshot docSnap =
                          value.isEmpty() ? null : value.getDocuments().get(0);

                      switch (snapshotCount.getAndIncrement()) {
                        case 0:
                          assertNull(docSnap);
                          ref.create(
                                  map(
                                      "purpose", "vector tests",
                                      "vector0", FieldValue.vector(new double[] {0.0}),
                                      "vector1", FieldValue.vector(new double[] {1, 2, 3.99})))
                              .get();
                          break;
                        case 1:
                          assertNotNull(docSnap);

                          assertEquals(
                              docSnap.getVectorValue("vector0"),
                              FieldValue.vector(new double[] {0.0}));
                          assertEquals(
                              docSnap.getVectorValue("vector1"),
                              FieldValue.vector(new double[] {1, 2, 3.99}));

                          ref.set(
                                  map(
                                      "purpose",
                                      "vector tests",
                                      "vector0",
                                      FieldValue.vector(new double[] {0.0}),
                                      "vector1",
                                      FieldValue.vector(new double[] {1, 2, 3.99}),
                                      "vector2",
                                      FieldValue.vector(new double[] {0, 0, 0})))
                              .get();
                          break;
                        case 2:
                          assertNotNull(docSnap);

                          assertEquals(
                              docSnap.getVectorValue("vector0"),
                              FieldValue.vector(new double[] {0.0}));
                          assertEquals(
                              docSnap.getVectorValue("vector1"),
                              FieldValue.vector(new double[] {1, 2, 3.99}));
                          assertEquals(
                              docSnap.getVectorValue("vector2"),
                              FieldValue.vector(new double[] {0, 0, 0}));

                          ref.update(
                                  map("vector3", FieldValue.vector(new double[] {-1, -200, -999})))
                              .get();
                          break;
                        case 3:
                          assertNotNull(docSnap);

                          assertEquals(
                              docSnap.getVectorValue("vector0"),
                              FieldValue.vector(new double[] {0.0}));
                          assertEquals(
                              docSnap.getVectorValue("vector1"),
                              FieldValue.vector(new double[] {1, 2, 3.99}));
                          assertEquals(
                              docSnap.getVectorValue("vector2"),
                              FieldValue.vector(new double[] {0, 0, 0}));
                          assertEquals(
                              docSnap.getVectorValue("vector3"),
                              FieldValue.vector(new double[] {-1, -200, -999}));

                          ref.delete().get();
                          break;
                        case 4:
                          assertNull(docSnap);
                          listen.complete(null);
                          break;
                      }
                    } catch (Throwable t) {
                      listen.completeExceptionally(t);
                    }
                  });

      listen.get();
    } finally {
      if (registration != null) {
        registration.remove();
      }
    }
  }

  @Test
  public void documentWatch() throws Exception {
    CompletableFuture<Void> listen = new CompletableFuture<>();
    DocumentReference documentReference = randomColl.document();
    ListenerRegistration registration = null;
    AtomicInteger snapshotCount = new AtomicInteger();

    try {
      registration =
          documentReference.addSnapshotListener(
              (value, error) -> {
                try {
                  switch (snapshotCount.getAndIncrement()) {
                    case 0:
                      assertFalse(value.exists());
                      documentReference.set(map("foo", "foo"));
                      break;
                    case 1:
                      assertTrue(value.exists());
                      DocumentSnapshot documentSnapshot = documentReference.get().get();
                      assertEquals("foo", documentSnapshot.getString("foo"));
                      documentReference.set(map("foo", "bar"));
                      break;
                    case 2:
                      assertTrue(value.exists());
                      documentSnapshot = documentReference.get().get();
                      assertEquals("bar", documentSnapshot.getString("foo"));
                      documentReference.delete();
                      break;
                    case 3:
                      assertFalse(value.exists());
                      listen.complete(null);
                      break;
                  }
                } catch (Exception e) {
                  listen.completeExceptionally(e);
                }
              });
      listen.get();
    } finally {
      if (registration != null) {
        registration.remove();
      }
    }
  }

  private int paginateResults(Query query, List<DocumentSnapshot> results)
      throws ExecutionException, InterruptedException {
    if (!results.isEmpty()) {
      query = query.startAfter(results.get(results.size() - 1));
    }

    QuerySnapshot querySnapshot = query.get().get();

    if (querySnapshot.isEmpty()) {
      return 0;
    } else {
      results.addAll(querySnapshot.getDocuments());
      return 1 + paginateResults(query, results);
    }
  }

  @Test
  public void queryPaginationWithOrderByClause() throws ExecutionException, InterruptedException {
    WriteBatch batch = firestore.batch();

    for (int i = 0; i < 10; ++i) {
      batch.set(randomColl.document(), map("val", i));
    }

    batch.commit().get();

    Query query = randomColl.orderBy("val").limit(3);

    List<DocumentSnapshot> results = new ArrayList<>();
    int pageCount = paginateResults(query, results);
    assertEquals(4, pageCount);
    assertEquals(10, results.size());
  }

  @Test
  public void queryPaginationWithWhereClause() throws ExecutionException, InterruptedException {
    // TODO(pipeline): Enable this test against production when adding implicitOrderBy.
    assumeTrue(
        "Skip this test when running against enterprise because it does not work yet.",
        getFirestoreEdition() != FirestoreEdition.ENTERPRISE);
    WriteBatch batch = firestore.batch();

    for (int i = 0; i < 10; ++i) {
      batch.set(randomColl.document(), map("val", i));
    }

    batch.commit().get();

    Query query = randomColl.whereGreaterThanOrEqualTo("val", 1).limit(3);

    List<DocumentSnapshot> results = new ArrayList<>();
    int pageCount = paginateResults(query, results);
    assertEquals(3, pageCount);
    assertEquals(9, results.size());
  }

  @Test
  public void arrayOperators() throws ExecutionException, InterruptedException {
    Query containsQuery = randomColl.whereArrayContains("foo", "bar");

    assertTrue(containsQuery.get().get().isEmpty());

    DocumentReference doc1 = randomColl.document();
    DocumentReference doc2 = randomColl.document();
    doc1.set(Collections.singletonMap("foo", FieldValue.arrayUnion("bar"))).get();
    doc2.set(Collections.singletonMap("foo", FieldValue.arrayUnion("baz"))).get();

    assertEquals(1, containsQuery.get().get().size());

    doc1.set(Collections.singletonMap("foo", FieldValue.arrayRemove("bar"))).get();
    doc2.set(Collections.singletonMap("foo", FieldValue.arrayRemove("baz"))).get();

    assertTrue(containsQuery.get().get().isEmpty());
  }

  @Test
  public void testCollectionGroupQueries() throws ExecutionException, InterruptedException {
    // Use `randomColl` to get a random collection group name to use but ensure it starts with 'b'
    // for predictable ordering.
    String collectionGroup = "b" + randomColl.getId();

    String[] docPaths =
        new String[] {
          "abc/123/${collectionGroup}/cg-doc1",
          "abc/123/${collectionGroup}/cg-doc2",
          "${collectionGroup}/cg-doc3",
          "${collectionGroup}/cg-doc4",
          "def/456/${collectionGroup}/cg-doc5",
          "${collectionGroup}/virtual-doc/nested-coll/not-cg-doc",
          "x${collectionGroup}/not-cg-doc",
          "${collectionGroup}x/not-cg-doc",
          "abc/123/${collectionGroup}x/not-cg-doc",
          "abc/123/x${collectionGroup}/not-cg-doc",
          "abc/${collectionGroup}"
        };
    WriteBatch batch = firestore.batch();
    for (String path : docPaths) {
      batch.set(
          firestore.document(path.replace("${collectionGroup}", collectionGroup)), map("x", 1));
    }
    batch.commit().get();

    QuerySnapshot querySnapshot = firestore.collectionGroup(collectionGroup).get().get();
    if (getFirestoreEdition() == FirestoreEdition.STANDARD) {
      assertEquals(
          asList("cg-doc1", "cg-doc2", "cg-doc3", "cg-doc4", "cg-doc5"),
          querySnapshotToIds(querySnapshot));
    } else {
      assertThat(querySnapshotToIds(querySnapshot))
          .containsExactlyElementsIn(asList("cg-doc1", "cg-doc2", "cg-doc3", "cg-doc4", "cg-doc5"));
    }
  }

  @Test
  public void collectionGroupQueriesWithStartAtEndAtWithArbitraryDocumentIds()
      throws ExecutionException, InterruptedException {
    // Use `randomColl` to get a random collection group name to use but ensure it starts with 'b'
    // for predictable ordering.
    String collectionGroup = "b" + randomColl.getId();

    String[] docPaths =
        new String[] {
          "a/a/${collectionGroup}/cg-doc1",
          "a/b/a/b/${collectionGroup}/cg-doc2",
          "a/b/${collectionGroup}/cg-doc3",
          "a/b/c/d/${collectionGroup}/cg-doc4",
          "a/c/${collectionGroup}/cg-doc5",
          "${collectionGroup}/cg-doc6",
          "a/b/nope/nope"
        };
    WriteBatch batch = firestore.batch();
    for (String path : docPaths) {
      batch.set(
          firestore.document(path.replace("${collectionGroup}", collectionGroup)), map("x", 1));
    }
    batch.commit().get();

    QuerySnapshot querySnapshot =
        firestore
            .collectionGroup(collectionGroup)
            .orderBy(FieldPath.documentId())
            .startAt("a/b")
            .endAt("a/b0")
            .get()
            .get();
    assertEquals(asList("cg-doc2", "cg-doc3", "cg-doc4"), querySnapshotToIds(querySnapshot));

    querySnapshot =
        firestore
            .collectionGroup(collectionGroup)
            .orderBy(FieldPath.documentId())
            .startAfter("a/b")
            .endBefore("a/b/" + collectionGroup + "/cg-doc3")
            .get()
            .get();
    assertEquals(asList("cg-doc2"), querySnapshotToIds(querySnapshot));
  }

  @Test
  public void collectionGroupQueriesWithWhereFiltersOnArbitraryDocumentIds()
      throws ExecutionException, InterruptedException {
    // Use `randomColl` to get a random collection group name to use but ensure it starts with 'b'
    // for predictable ordering.
    String collectionGroup = "b" + randomColl.getId();

    String[] docPaths =
        new String[] {
          "a/a/${collectionGroup}/cg-doc1",
          "a/b/a/b/${collectionGroup}/cg-doc2",
          "a/b/${collectionGroup}/cg-doc3",
          "a/b/c/d/${collectionGroup}/cg-doc4",
          "a/c/${collectionGroup}/cg-doc5",
          "${collectionGroup}/cg-doc6",
          "a/b/nope/nope"
        };

    WriteBatch batch = firestore.batch();
    for (String path : docPaths) {
      batch.set(
          firestore.document(path.replace("${collectionGroup}", collectionGroup)), map("x", 1));
    }
    batch.commit().get();

    QuerySnapshot querySnapshot =
        firestore
            .collectionGroup(collectionGroup)
            .whereGreaterThanOrEqualTo(FieldPath.documentId(), "a/b")
            .whereLessThanOrEqualTo(FieldPath.documentId(), "a/b0")
            .get()
            .get();
    if (getFirestoreEdition() == FirestoreEdition.STANDARD) {
      assertEquals(asList("cg-doc2", "cg-doc3", "cg-doc4"), querySnapshotToIds(querySnapshot));
    } else {
      assertThat(querySnapshotToIds(querySnapshot))
          .containsExactlyElementsIn(asList("cg-doc2", "cg-doc3", "cg-doc4"));
    }

    querySnapshot =
        firestore
            .collectionGroup(collectionGroup)
            .whereGreaterThan(FieldPath.documentId(), "a/b")
            .whereLessThan(FieldPath.documentId(), "a/b/" + collectionGroup + "/cg-doc3")
            .get()
            .get();
    assertEquals(asList("cg-doc2"), querySnapshotToIds(querySnapshot));
  }

  @Test
  public void inQueries() throws Exception {
    setDocument("a", map("zip", 98101));
    setDocument("b", map("zip", 91102));
    setDocument("c", map("zip", 98103));
    setDocument("d", map("zip", asList(98101)));
    setDocument("e", map("zip", asList("98101", map("zip", 98101))));
    setDocument("f", map("zip", map("code", 500)));

    QuerySnapshot querySnapshot =
        randomColl.whereIn("zip", Arrays.<Object>asList(98101, 98103)).get().get();

    if (getFirestoreEdition() == FirestoreEdition.STANDARD) {
      assertEquals(asList("a", "c"), querySnapshotToIds(querySnapshot));
    } else {
      assertThat(querySnapshotToIds(querySnapshot)).containsExactlyElementsIn(asList("a", "c"));
    }
  }

  @Test
  public void notEqualQueries() throws Exception {
    setDocument("a", map("zip", Double.NaN));
    setDocument("b", map("zip", 91102));
    setDocument("c", map("zip", 98101));
    setDocument("d", map("zip", 98103));
    setDocument("e", map("zip", asList(98101)));
    setDocument("f", map("zip", asList("98101", map("zip", 98101))));
    setDocument("g", map("zip", map("zip", 98101)));
    setDocument("h", map("zip", null));

    QuerySnapshot querySnapshot = randomColl.whereNotEqualTo("zip", 98101).get().get();
    switch (getFirestoreEdition()) {
      case STANDARD:
        assertEquals(asList("a", "b", "d", "e", "f", "g"), querySnapshotToIds(querySnapshot));
        break;
      case ENTERPRISE:
        assertThat(querySnapshotToIds(querySnapshot))
            .containsExactlyElementsIn(asList("a", "b", "d", "e", "f", "g", "h"));
        break;
    }

    querySnapshot = randomColl.whereNotEqualTo("zip", Double.NaN).get().get();
    switch (getFirestoreEdition()) {
      case STANDARD:
        assertEquals(asList("b", "c", "d", "e", "f", "g"), querySnapshotToIds(querySnapshot));
        break;
      case ENTERPRISE:
        assertThat(querySnapshotToIds(querySnapshot))
            .containsExactlyElementsIn(asList("b", "c", "d", "e", "f", "g", "h"));
        break;
    }

    querySnapshot = randomColl.whereNotEqualTo("zip", null).get().get();
    switch (getFirestoreEdition()) {
      case STANDARD:
        assertEquals(asList("a", "b", "c", "d", "e", "f", "g"), querySnapshotToIds(querySnapshot));
        break;
      case ENTERPRISE:
        assertThat(querySnapshotToIds(querySnapshot))
            .containsExactlyElementsIn(asList("a", "b", "c", "d", "e", "f", "g"));
        break;
    }
  }

  @Test
  public void notEqualQueriesWithDocumentId() throws Exception {
    DocumentReference doc1 = setDocument("a", map("count", 1));
    DocumentReference doc2 = setDocument("b", map("count", 2));
    setDocument("c", map("count", 3));

    QuerySnapshot querySnapshot =
        randomColl.whereNotEqualTo(FieldPath.documentId(), doc1.getId()).get().get();

    if (getFirestoreEdition() == FirestoreEdition.STANDARD) {
      assertEquals(asList("b", "c"), querySnapshotToIds(querySnapshot));
    } else {
      assertThat(querySnapshotToIds(querySnapshot)).containsExactlyElementsIn(asList("b", "c"));
    }
  }

  @Test
  public void inQueriesWithDocumentId() throws Exception {
    DocumentReference doc1 = setDocument("a", map("count", 1));
    DocumentReference doc2 = setDocument("b", map("count", 2));
    setDocument("c", map("count", 3));

    QuerySnapshot querySnapshot =
        randomColl.whereIn(FieldPath.documentId(), Arrays.asList(doc1.getId(), doc2)).get().get();

    if (getFirestoreEdition() == FirestoreEdition.STANDARD) {
      assertEquals(asList("a", "b"), querySnapshotToIds(querySnapshot));
    } else {
      assertThat(querySnapshotToIds(querySnapshot)).containsExactlyElementsIn(asList("a", "b"));
    }
  }

  @Test
  public void notInQueries() throws Exception {
    setDocument("a", map("zip", 98101));
    setDocument("b", map("zip", 91102));
    setDocument("c", map("zip", 98103));
    setDocument("d", map("zip", asList(98101)));
    setDocument("e", map("zip", asList("98101", map("zip", 98101))));
    setDocument("f", map("zip", map("code", 500)));

    QuerySnapshot querySnapshot =
        randomColl.whereNotIn("zip", Arrays.<Object>asList(98101, 98103)).get().get();
    if (getFirestoreEdition() == FirestoreEdition.STANDARD) {
      assertEquals(asList("b", "d", "e", "f"), querySnapshotToIds(querySnapshot));
    } else {
      assertThat(querySnapshotToIds(querySnapshot))
          .containsExactlyElementsIn(asList("b", "d", "e", "f"));
    }

    querySnapshot = randomColl.whereNotIn("zip", Arrays.<Object>asList(Double.NaN)).get().get();
    if (getFirestoreEdition() == FirestoreEdition.STANDARD) {
      assertEquals(asList("b", "a", "c", "d", "e", "f"), querySnapshotToIds(querySnapshot));
    } else {
      assertThat(querySnapshotToIds(querySnapshot))
          .containsExactlyElementsIn(asList("b", "a", "c", "d", "e", "f"));
    }

    List<Object> nullArray = new ArrayList<>();
    nullArray.add(null);
    querySnapshot = randomColl.whereNotIn("zip", nullArray).get().get();

    if (getFirestoreEdition() == FirestoreEdition.STANDARD) {
      assertEquals(new ArrayList<>(), querySnapshotToIds(querySnapshot));
    } else {
      assertThat(querySnapshotToIds(querySnapshot))
          .containsExactlyElementsIn(asList("a", "b", "c", "d", "e", "f"));
    }
  }

  @Test
  public void notInQueriesWithDocumentId() throws Exception {
    DocumentReference doc1 = setDocument("a", map("count", 1));
    DocumentReference doc2 = setDocument("b", map("count", 2));
    setDocument("c", map("count", 3));

    QuerySnapshot querySnapshot =
        randomColl
            .whereNotIn(FieldPath.documentId(), Arrays.asList(doc1.getId(), doc2))
            .get()
            .get();

    assertEquals(asList("c"), querySnapshotToIds(querySnapshot));
  }

  @Test
  public void arrayContainsAnyQueries() throws Exception {
    setDocument("a", map("array", asList(42)));
    setDocument("b", map("array", asList("a", 42, "c")));
    setDocument("c", map("array", asList(41.999, "42", map("a", 42))));
    setDocument("d", map("array", asList(42), "array2", "sigh"));
    setDocument("e", map("array", asList(43)));
    setDocument("f", map("array", asList(map("a", 42))));
    setDocument("g", map("array", 42));

    Query query = randomColl.whereArrayContainsAny("array", Arrays.<Object>asList(42, 43));

    if (getFirestoreEdition() == FirestoreEdition.STANDARD) {
      assertEquals(asList("a", "b", "d", "e"), querySnapshotToIds(query.get().get()));
    } else {
      assertThat(querySnapshotToIds(query.get().get()))
          .containsExactlyElementsIn(asList("a", "b", "d", "e"));
    }
  }

  @Test
  public void integerIncrement() throws ExecutionException, InterruptedException {
    DocumentReference docRef = randomColl.document();
    docRef.set(Collections.singletonMap("sum", 1L)).get();
    docRef.update("sum", FieldValue.increment(2)).get();
    DocumentSnapshot docSnap = docRef.get().get();
    assertEquals(3L, docSnap.get("sum"));
  }

  @Test
  public void floatIncrement() throws ExecutionException, InterruptedException {
    DocumentReference docRef = randomColl.document();
    docRef.set(Collections.singletonMap("sum", 1.1)).get();
    docRef.update("sum", FieldValue.increment(2.2)).get();
    DocumentSnapshot docSnap = docRef.get().get();
    assertEquals(3.3, (Double) docSnap.get("sum"), DOUBLE_EPSILON);
  }

  @Test
  public void getAllWithObserver() throws Exception {
    DocumentReference ref1 = randomColl.document("doc1");
    ref1.set(ALL_SUPPORTED_TYPES_MAP).get();

    DocumentReference ref2 = randomColl.document("doc2");
    ref2.set(ALL_SUPPORTED_TYPES_MAP).get();

    DocumentReference ref3 = randomColl.document("doc3");

    final DocumentReference[] documentReferences = {ref1, ref2, ref3};

    StreamConsumer<DocumentSnapshot> consumer = new StreamConsumer<>();
    firestore.getAll(documentReferences, FieldMask.of("foo"), consumer);

    final List<DocumentSnapshot> documentSnapshots = consumer.consume().get();

    assertEquals(
        ALL_SUPPORTED_TYPES_OBJECT, documentSnapshots.get(0).toObject(AllSupportedTypes.class));
    assertEquals(
        ALL_SUPPORTED_TYPES_OBJECT, documentSnapshots.get(1).toObject(AllSupportedTypes.class));
    assertNotEquals(
        ALL_SUPPORTED_TYPES_OBJECT, documentSnapshots.get(2).toObject(AllSupportedTypes.class));

    assertEquals(3, documentSnapshots.size());
    // Only standard edition returns the documents in the order of the request.
    if (getFirestoreEdition() == FirestoreEdition.STANDARD) {
      assertEquals(ref1.getId(), documentSnapshots.get(0).getId());
      assertEquals(ref2.getId(), documentSnapshots.get(1).getId());
      assertEquals(ref3.getId(), documentSnapshots.get(2).getId());
    }
  }

  @Test
  public void testInstanceReturnedByGetServiceCanBeUsedToDeserializeAQuery() throws Exception {
    Firestore fs = FirestoreOptions.getDefaultInstance().getService();
    RunQueryRequest proto = fs.collection("coll").whereEqualTo("bob", "alice").toProto();
    fs.close();
    Query.fromProto(fs, proto);
  }

  @Test
  public void deleteNestedFieldUsingFieldPath() throws Exception {
    DocumentReference documentReference = randomColl.document("doc1");
    documentReference.set(map("a.b", SINGLE_FILED_MAP_WITH_DOT)).get();
    DocumentSnapshot documentSnapshots = documentReference.get().get();
    assertEquals(SINGLE_FILED_MAP_WITH_DOT, documentSnapshots.getData().get("a.b"));

    FieldPath path = FieldPath.of("a.b", "c.d");
    documentReference.update(path, FieldValue.delete()).get();
    documentSnapshots = documentReference.get().get();
    assertNull(documentSnapshots.getData().get("c.d"));
  }

  @Test
  public void readOnlyTransaction_successfulGet()
      throws ExecutionException, InterruptedException, TimeoutException {
    final DocumentReference documentReference = randomColl.add(SINGLE_FIELD_MAP).get();

    final AtomicReference<DocumentSnapshot> ref = new AtomicReference<>();

    final ApiFuture<Void> runTransaction =
        firestore.runTransaction(
            transaction -> {
              final DocumentSnapshot snapshot =
                  transaction.get(documentReference).get(5, TimeUnit.SECONDS);
              ref.compareAndSet(null, snapshot);
              return null;
            },
            TransactionOptions.createReadOnlyOptionsBuilder().build());

    runTransaction.get(10, TimeUnit.SECONDS);
    assertEquals("bar", ref.get().get("foo"));
  }

  @Test
  public void readOnlyTransaction_failureWhenAttemptingWrite()
      throws InterruptedException, TimeoutException {

    final DocumentReference documentReference = randomColl.document("tx/ro/writeShouldFail");
    final ApiFuture<Void> runTransaction =
        firestore.runTransaction(
            transaction -> {
              transaction.set(documentReference, SINGLE_FIELD_MAP);
              return null;
            },
            TransactionOptions.createReadOnlyOptionsBuilder().build());

    ExecutionException e =
        assertThrows(
            ExecutionException.class,
            () -> {
              runTransaction.get(10, TimeUnit.SECONDS);
            });
    final Throwable cause = e.getCause();
    assertThat(cause).isInstanceOf(FirestoreException.class);
    final Throwable rootCause = ExceptionUtils.getRootCause(cause);
    assertThat(rootCause).isInstanceOf(StatusRuntimeException.class);
    final StatusRuntimeException invalidArgument = (StatusRuntimeException) rootCause;
    final Status status = invalidArgument.getStatus();
    assertThat(status.getCode()).isEqualTo(Code.INVALID_ARGUMENT);
    assertThat(status.getDescription()).contains("read-only");
  }

  @Test
  public void readOnlyTransaction_successfulRead() throws Exception {
    DocumentReference documentReference = randomColl.add(SINGLE_FIELD_MAP).get();

    Timestamp firstWriteTime =
        documentReference.set(Collections.singletonMap("counter", 1)).get().getUpdateTime();
    documentReference.set(Collections.singletonMap("counter", 2)).get();

    final TransactionOptions options =
        TransactionOptions.createReadOnlyOptionsBuilder()
            .setReadTime(
                com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(firstWriteTime.getSeconds())
                    .setNanos(firstWriteTime.getNanos()))
            .build();

    final ApiFuture<Long> runTransaction =
        firestore.runTransaction(
            transaction -> {
              final DocumentSnapshot snapshot =
                  transaction.get(documentReference).get(5, TimeUnit.SECONDS);
              return snapshot.getLong("counter");
            },
            options);

    assertEquals(1, runTransaction.get(10, TimeUnit.SECONDS).longValue());

    DocumentSnapshot documentSnapshot = documentReference.get().get();
    assertEquals(2, (long) documentSnapshot.getData().get("counter"));
  }

  @Test
  public void readOnlyTransaction_failureWhenAttemptReadOlderThan60Seconds()
      throws ExecutionException, InterruptedException, TimeoutException {
    // Skip this test because emulator does not have this behavior.
    assumeFalse(
        "Skip this test when running against the emulator because it does not have this behavior.",
        TestHelper.isRunningAgainstFirestoreEmulator(firestore));

    final DocumentReference documentReference = randomColl.add(SINGLE_FIELD_MAP).get();

    // Exception isn't thrown until 60 minutes.
    // To ensure we exceed this, we use 120 minutes.
    // If this test fails, we should likely be update documentation to reflect new value. See all
    // usages of "Read Time" on proto, and within SDK.
    //
    // If Point-in-Time Recovery is enabled, can additionally be a whole minute timestamp within the
    // past 7 days. For that reason `twoHours` is calculated to whole minute to more accurately
    // catch this situation.
    final long twoHours = (System.currentTimeMillis() / 60_000 - 120) * 60;
    final TransactionOptions options =
        TransactionOptions.createReadOnlyOptionsBuilder()
            .setReadTime(
                com.google.protobuf.Timestamp.newBuilder().setSeconds(twoHours).setNanos(0))
            .build();

    final ApiFuture<Void> runTransaction =
        firestore.runTransaction(
            transaction -> {
              transaction.get(documentReference).get(5, TimeUnit.SECONDS);
              return null;
            },
            options);

    ExecutionException e =
        assertThrows(ExecutionException.class, () -> runTransaction.get(10, TimeUnit.SECONDS));
    final Throwable rootCause = ExceptionUtils.getRootCause(e);
    assertThat(rootCause).isInstanceOf(StatusRuntimeException.class);
    final StatusRuntimeException invalidArgument = (StatusRuntimeException) rootCause;
    final Status status = invalidArgument.getStatus();
    assertThat(status.getCode()).isEqualTo(Code.FAILED_PRECONDITION);
  }

  @Test
  public void deserializeCustomList() throws Exception {
    LocalFirestoreHelper.CustomList customList = new LocalFirestoreHelper.CustomList();
    customList.fooList = FOO_LIST;
    DocumentReference documentReference = randomColl.document("doc1");
    documentReference.set(customList).get();
    DocumentSnapshot documentSnapshots = documentReference.get().get();
    LocalFirestoreHelper.CustomList targetCustomList =
        documentSnapshots.toObject(LocalFirestoreHelper.CustomList.class);

    assertEquals(FOO_LIST, targetCustomList.fooList);
    assertEquals(SINGLE_FIELD_OBJECT, targetCustomList.fooList.get(0));
  }

  @Test
  public void deserializeCustomMap() throws Exception {
    LocalFirestoreHelper.CustomMap customMap = new LocalFirestoreHelper.CustomMap();
    customMap.fooMap = FOO_MAP;
    DocumentReference documentReference = randomColl.document("doc1");
    documentReference.set(customMap).get();
    DocumentSnapshot documentSnapshots = documentReference.get().get();
    LocalFirestoreHelper.CustomMap targetCustomMap =
        documentSnapshots.toObject(LocalFirestoreHelper.CustomMap.class);

    assertEquals(FOO_MAP, targetCustomMap.fooMap);
    assertEquals(SINGLE_FIELD_OBJECT, targetCustomMap.fooMap.get("customMap"));
  }

  /** Wrapper around ApiStreamObserver that returns the results in a list. */
  private static class StreamConsumer<T> implements ApiStreamObserver<T> {
    SettableApiFuture<List<T>> done = SettableApiFuture.create();
    List<T> results = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void onNext(T element) {
      results.add(element);
    }

    @Override
    public void onError(Throwable throwable) {
      done.setException(throwable);
    }

    @Override
    public void onCompleted() {
      done.set(results);
    }

    public ApiFuture<List<T>> consume() {
      return done;
    }
  }

  @Test
  public void testBuildingBundleWhenDocumentDoesNotExist() throws Exception {
    FirestoreBundle.Builder bundleBuilder = firestore.bundleBuilder("test-bundle");
    DocumentSnapshot snapshot = randomDoc.get().get();
    bundleBuilder.add(snapshot);

    // Expected bundle elements are [bundleMetadata, documentMetadata]
    List<BundleElement> elements = toBundleElements(bundleBuilder.build().toByteBuffer());
    assertEquals(2, elements.size());

    verifyMetadata(
        elements.get(0).getMetadata(),
        snapshot.getReadTime().toProto(),
        /*totalDocuments*/ 1,
        /*expectEmptyContent*/ false);
    assertEquals(
        BundledDocumentMetadata.newBuilder()
            .setExists(false)
            .setName(fullPath(randomDoc, firestore.getOptions()))
            .setReadTime(snapshot.getReadTime().toProto())
            .build(),
        elements.get(1).getDocumentMetadata());
  }

  @Test
  public void testBuildingBundleWithLimitQuery() throws Exception {
    setDocument("doc1", Collections.singletonMap("counter", 1));
    setDocument("doc2", Collections.singletonMap("counter", 2));

    Query limitQuery = randomColl.orderBy("counter", Direction.DESCENDING).limit(1);
    QuerySnapshot limitQuerySnap = limitQuery.get().get();
    FirestoreBundle.Builder bundleBuilder = firestore.bundleBuilder("test-bundle");
    bundleBuilder.add("limit", limitQuerySnap);

    // Expected bundle elements are [bundleMetadata, limitQuery,
    // documentMetadata, document]
    List<BundleElement> elements = toBundleElements(bundleBuilder.build().toByteBuffer());
    assertEquals(4, elements.size());

    verifyMetadata(elements.get(0).getMetadata(), limitQuerySnap.getReadTime().toProto(), 1, false);

    NamedQuery namedLimitQuery = elements.get(1).getNamedQuery();

    verifyNamedQuery(
        namedLimitQuery,
        "limit",
        limitQuerySnap.getReadTime().toProto(),
        limitQuery,
        LimitType.FIRST);

    verifyDocumentAndMeta(
        elements.get(2).getDocumentMetadata(),
        elements.get(3).getDocument(),
        fullPath(randomColl.document("doc2"), firestore.getOptions()),
        Lists.newArrayList("limit"),
        randomColl.document("doc2").get().get(),
        limitQuerySnap.getReadTime().toProto());
  }

  @Test
  public void testBuildingBundleWithLimitToLastQuery() throws Exception {
    setDocument("doc1", Collections.singletonMap("counter", 1));
    setDocument("doc2", Collections.singletonMap("counter", 2));

    Query limitToLastQuery = randomColl.orderBy("counter").limitToLast(1);
    QuerySnapshot limitToLastQuerySnap = limitToLastQuery.get().get();
    FirestoreBundle.Builder bundleBuilder = firestore.bundleBuilder("test-bundle");
    bundleBuilder.add("limitToLast", limitToLastQuerySnap);

    // Expected bundle elements are [bundleMetadata, limitToLastQuery,
    // documentMetadata, document]
    List<BundleElement> elements = toBundleElements(bundleBuilder.build().toByteBuffer());
    assertEquals(4, elements.size());

    verifyMetadata(
        elements.get(0).getMetadata(), limitToLastQuerySnap.getReadTime().toProto(), 1, false);

    NamedQuery namedLimitToLastQuery = elements.get(1).getNamedQuery();

    verifyNamedQuery(
        namedLimitToLastQuery,
        "limitToLast",
        limitToLastQuerySnap.getReadTime().toProto(),
        randomColl.orderBy("counter").limit(1),
        LimitType.LAST);

    verifyDocumentAndMeta(
        elements.get(2).getDocumentMetadata(),
        elements.get(3).getDocument(),
        fullPath(randomColl.document("doc2"), firestore.getOptions()),
        Lists.newArrayList("limitToLast"),
        randomColl.document("doc2").get().get(),
        limitToLastQuerySnap.getReadTime().toProto());
  }

  private int countDocumentChildren(DocumentReference reference) {
    int count = 0;
    Iterable<CollectionReference> collections = reference.listCollections();
    for (CollectionReference collectionReference : collections) {
      count += countCollectionChildren(collectionReference);
    }
    return count;
  }

  private int countCollectionChildren(CollectionReference reference) {
    int count = 0;
    Iterable<DocumentReference> documents = reference.listDocuments();
    for (DocumentReference documentReference : documents) {
      count += countDocumentChildren(documentReference) + 1;
    }
    return count;
  }

  private void setupRecursiveDeleteTest() throws Exception {
    // ROOT-DB
    // └── randomCol
    //     ├── anna
    //     └── bob
    //         └── parentsCol
    //             ├── charlie
    //             └── daniel
    //                 └── childCol
    //                     ├── ernie
    //                     └── francis
    WriteBatch batch = firestore.batch();
    batch.set(randomColl.document("anna"), map("name", "anna"));
    batch.set(randomColl.document("bob"), map("name", "bob"));
    batch.set(randomColl.document("bob/parentsCol/charlie"), map("name", "charlie"));
    batch.set(randomColl.document("bob/parentsCol/daniel"), map("name", "daniel"));
    batch.set(randomColl.document("bob/parentsCol/daniel/childCol/ernie"), map("name", "ernie"));
    batch.set(
        randomColl.document("bob/parentsCol/daniel/childCol/francis"), map("name", "francis"));
    batch.commit().get();
  }

  @Test
  public void testRecursiveDeleteTopLevelCollection() throws Exception {
    assumeFalse(
        "Skip this test when running against enterprise because it does not support showMissing",
        getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    setupRecursiveDeleteTest();
    firestore.recursiveDelete(randomColl).get();
    assertEquals(0, countCollectionChildren(randomColl));
  }

  @Test
  public void testRecursiveDeleteNestedCollection() throws Exception {
    assumeFalse(
        "Skip this test when running against enterprise because it does not support showMissing",
        getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    setupRecursiveDeleteTest();
    firestore.recursiveDelete(randomColl.document("bob").collection("parentsCol")).get();
    assertEquals(2, countCollectionChildren(randomColl));
  }

  @Test
  public void testRecursiveDeleteNestedDocument() throws Exception {
    assumeFalse(
        "Skip this test when running against enterprise because it does not support showMissing",
        getFirestoreEdition() == FirestoreEdition.ENTERPRISE);

    setupRecursiveDeleteTest();
    DocumentReference document = randomColl.document("bob/parentsCol/daniel");
    firestore.recursiveDelete(document).get();
    DocumentSnapshot snap = document.get().get();
    assertFalse(snap.exists());
    assertEquals(1, countDocumentChildren(randomColl.document("bob")));
    assertEquals(3, countCollectionChildren(randomColl));
  }

  @Test
  public void testRecursiveDeleteLeafDocument() throws Exception {
    assumeFalse(
        "Skip this test when running against enterprise because it does not support showMissing",
        getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    setupRecursiveDeleteTest();
    DocumentReference document = randomColl.document("bob/parentsCol/daniel/childCol/ernie");
    firestore.recursiveDelete(document).get();
    DocumentSnapshot snap = document.get().get();
    assertFalse(snap.exists());
    assertEquals(5, countCollectionChildren(randomColl));
  }

  @Ignore("Flaky with graalvm-native-a")
  @Test
  public void testRecursiveDeleteDoesNotAffectOtherCollections() throws Exception {
    assumeFalse(
        "Skip this test when running against enterprise because it does not support showMissing",
        getFirestoreEdition() == FirestoreEdition.ENTERPRISE);
    setupRecursiveDeleteTest();

    // Add another nested collection that shouldn't be deleted.
    CollectionReference collectionB = firestore.collection("doggos");
    collectionB.document("doggo").set(map("name", "goodboi")).get();

    firestore.recursiveDelete(collectionB).get();
    assertEquals(6, countCollectionChildren(randomColl));
    assertEquals(0, countCollectionChildren(collectionB));
  }

  @Test
  public void testRecursiveDeleteWithCustomBulkWriterInstance() throws Exception {
    assumeFalse(
        "Skip this test when running against enterprise because it does not support"
            + " bulk writer.",
        getFirestoreEdition() == FirestoreEdition.ENTERPRISE);

    setupRecursiveDeleteTest();

    BulkWriter bulkWriter = firestore.bulkWriter();
    final int[] callbackCount = {0};
    bulkWriter.addWriteResultListener((documentReference, result) -> callbackCount[0]++);

    firestore.recursiveDelete(randomColl, bulkWriter).get();
    assertEquals(0, countCollectionChildren(randomColl));
    assertEquals(6, callbackCount[0]);
  }

  @Test
  public void testEnforcesTimeouts() {
    FirestoreOptions firestoreOptions =
        FirestoreOptions.newBuilder()
            .setRetrySettings(
                RetrySettings.newBuilder()
                    .setMaxRpcTimeoutDuration(Duration.ofMillis(1))
                    .setTotalTimeoutDuration(Duration.ofMillis(1))
                    .setInitialRpcTimeoutDuration(Duration.ofMillis(1))
                    .build())
            .build();
    firestore = firestoreOptions.getService();
    CollectionReference collection = firestore.collection("timeout");

    // RunQuery
    assertThrows(ExecutionException.class, () -> collection.get().get());
    // CommitRequest
    assertThrows(ExecutionException.class, () -> collection.add(map()).get());
    // BulkCommit
    assertThrows(
        ExecutionException.class,
        () -> {
          BulkWriter bulkWriter = firestore.bulkWriter();
          ApiFuture<WriteResult> op = bulkWriter.set(collection.document(), map());
          bulkWriter.close();
          op.get();
        });
    // BatchGetDocuments
    assertThrows(ExecutionException.class, () -> collection.document().get().get());
    // ListDocuments
    assertThrows(FirestoreException.class, () -> collection.listDocuments().iterator().hasNext());
    // ListCollections
    assertThrows(
        FirestoreException.class,
        () -> collection.document().listCollections().iterator().hasNext());
  }
}
