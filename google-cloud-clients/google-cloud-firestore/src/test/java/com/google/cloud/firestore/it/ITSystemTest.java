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

import static com.google.cloud.firestore.LocalFirestoreHelper.map;
import static com.google.common.collect.Sets.newHashSet;
import static com.google.common.truth.Truth.assertWithMessage;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentChange;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.EventListener;
import com.google.cloud.firestore.FieldMask;
import com.google.cloud.firestore.FieldPath;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreException;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.ListenerRegistration;
import com.google.cloud.firestore.LocalFirestoreHelper;
import com.google.cloud.firestore.LocalFirestoreHelper.AllSupportedTypes;
import com.google.cloud.firestore.LocalFirestoreHelper.SingleField;
import com.google.cloud.firestore.Precondition;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.Transaction;
import com.google.cloud.firestore.Transaction.Function;
import com.google.cloud.firestore.WriteBatch;
import com.google.cloud.firestore.WriteResult;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class ITSystemTest {

  private static final double DOUBLE_EPSILON = 0.000001;

  private final Map<String, Object> SINGLE_FIELD_MAP = LocalFirestoreHelper.SINGLE_FIELD_MAP;
  private final Map<String, Object> ALL_SUPPORTED_TYPES_MAP =
      LocalFirestoreHelper.ALL_SUPPORTED_TYPES_MAP;
  private final SingleField SINGLE_FIELD_OBJECT = LocalFirestoreHelper.SINGLE_FIELD_OBJECT;
  private final AllSupportedTypes ALL_SUPPORTED_TYPES_OBJECT =
      LocalFirestoreHelper.ALL_SUPPORTED_TYPES_OBJECT;

  @Rule public TestName testName = new TestName();

  private Firestore firestore;
  private CollectionReference randomColl;
  private DocumentReference randomDoc;

  @Before
  public void before() {
    FirestoreOptions firestoreOptions = FirestoreOptions.newBuilder().build();
    firestore = firestoreOptions.getService();
    randomColl =
        firestore.collection(
            String.format("java-%s-%s", testName.getMethodName(), LocalFirestoreHelper.autoId()));
    randomDoc = randomColl.document();
  }

  @After
  public void after() throws Exception {
    firestore.close();
  }

  private DocumentReference setDocument(String documentId, Map<String, Object> fields)
      throws Exception {
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
    Map<String, Object> originalMap =
        LocalFirestoreHelper.<String, Object>map("a.b", "c", "nested", map("d", "e"));
    Map<String, Object> updateMap =
        LocalFirestoreHelper.<String, Object>map("f.g", "h", "nested", map("i", "j"));
    Map<String, Object> resultMap =
        LocalFirestoreHelper.<String, Object>map(
            "a.b", "c", "f.g", "h", "nested", map("d", "e", "i", "j"));
    randomDoc.set(originalMap).get();
    randomDoc.set(updateMap, SetOptions.merge()).get();
    DocumentSnapshot documentSnapshot = randomDoc.get().get();
    assertEquals(resultMap, documentSnapshot.getData());
  }

  @Test
  public void mergeDocumentWithServerTimestamp() throws Exception {
    Map<String, Object> originalMap = LocalFirestoreHelper.<String, Object>map("a", "b");
    Map<String, Object> updateMap = map("c", (Object) FieldValue.serverTimestamp());
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
  public void noResults() throws Exception {
    QuerySnapshot querySnapshot = randomColl.get().get();
    assertTrue(querySnapshot.isEmpty());
    assertNotNull(querySnapshot.getReadTime());
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
    addDocument("foo", "bar");
    addDocument("foo", "bar");

    QuerySnapshot querySnapshot = randomColl.limit(1).get().get();
    assertEquals(1, querySnapshot.size());
    assertEquals("bar", querySnapshot.getDocuments().get(0).get("foo"));
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
  public void failedTransaction() {
    try {
      firestore
          .runTransaction(
              new Function<String>() {
                @Override
                public String updateCallback(Transaction transaction) {
                  throw new RuntimeException("User exception");
                }
              })
          .get();
      fail();
    } catch (Exception e) {
      assertTrue(e.getMessage().endsWith("User exception"));
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
            new Transaction.Function<String>() {
              @Override
              public String updateCallback(Transaction transaction)
                  throws ExecutionException, InterruptedException {
                attempts.incrementAndGet();
                DocumentSnapshot documentSnapshot = transaction.get(documentReference).get();
                latch.countDown();
                latch.await();
                transaction.update(
                    documentReference, "counter", documentSnapshot.getLong("counter") + 1);
                return "foo";
              }
            });

    ApiFuture<String> secondTransaction =
        firestore.runTransaction(
            new Function<String>() {
              @Override
              public String updateCallback(Transaction transaction)
                  throws ExecutionException, InterruptedException {
                attempts.incrementAndGet();
                List<DocumentSnapshot> documentSnapshots =
                    transaction.getAll(documentReference).get();
                latch.countDown();
                latch.await();
                transaction.update(
                    documentReference, "counter", documentSnapshots.get(0).getLong("counter") + 1);
                return "bar";
              }
            });

    assertEquals("foo", firstTransaction.get());
    assertEquals("bar", secondTransaction.get());
    assertEquals(3, attempts.intValue());
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
    randomColl.document("missing/foo/bar").set(SINGLE_FIELD_MAP).get();
    Iterable<DocumentReference> collectionRefs = randomColl.listDocuments();
    assertEquals(randomColl.document("missing"), collectionRefs.iterator().next());
  }

  @Test
  public void addAndRemoveFields() throws ExecutionException, InterruptedException {
    Map<String, Object> expected = new HashMap<>();

    randomDoc.create(Collections.<String, Object>emptyMap()).get();
    assertEquals(expected, getData());

    randomDoc.delete().get();
    assertFalse(randomDoc.get().get().exists());

    randomDoc.create(map("a", map("b", "c"))).get();
    expected.put("a", map("b", "c"));
    assertEquals(expected, getData());

    randomDoc.set(Collections.<String, Object>emptyMap()).get();
    expected = map();
    assertEquals(expected, getData());

    randomDoc.set(map("a", map("b", "c"))).get();
    expected.put("a", map("b", "c"));
    assertEquals(expected, getData());

    randomDoc.set(map("a", map("d", "e")), SetOptions.merge()).get();
    getNestedMap(expected, "a").put("d", "e");
    assertEquals(expected, getData());

    randomDoc
        .set(
            LocalFirestoreHelper.<String, Object>map("a", map("d", FieldValue.delete())),
            SetOptions.merge())
        .get();
    getNestedMap(expected, "a").remove("d");
    assertEquals(expected, getData());

    randomDoc
        .set(
            LocalFirestoreHelper.<String, Object>map("a", map("b", FieldValue.delete())),
            SetOptions.merge())
        .get();
    getNestedMap(expected, "a").remove("b");
    assertEquals(expected, getData());

    randomDoc
        .set(LocalFirestoreHelper.<String, Object>map("a", map("e", "foo")), SetOptions.merge())
        .get();
    getNestedMap(expected, "a").put("e", "foo");
    assertEquals(expected, getData());

    randomDoc.set(map("f", "foo"), SetOptions.merge()).get();
    expected.put("f", "foo");
    assertEquals(expected, getData());

    randomDoc
        .set(LocalFirestoreHelper.<String, Object>map("f", map("g", "foo")), SetOptions.merge())
        .get();
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
  public void documentWatch() throws Exception {
    final DocumentReference documentReference = randomColl.document();

    final Semaphore semaphore = new Semaphore(0);
    ListenerRegistration registration = null;

    try {
      registration =
          documentReference.addSnapshotListener(
              new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(
                    @Nullable DocumentSnapshot value, @Nullable FirestoreException error) {
                  try {
                    switch (semaphore.availablePermits()) {
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
                        break;
                    }
                  } catch (Exception e) {
                    fail(e.getMessage());
                  }
                  semaphore.release();
                }
              });

      semaphore.acquire(4);
    } finally {
      if (registration != null) {
        registration.remove();
      }
    }
  }

  @Test
  public void queryWatch() throws Exception {
    // This test has quite a bit of machinery to it, as there are several things going on.
    // The main scenario we are test is: 'Given a query, listen for snapshot updates made to that
    // query'
    //
    // To verify this behavior we have the following things happening:
    //   1. A defined query with an attached snapshot listener.
    //   2. Two different documents that we are making changes to throughout the duration of the
    //      test. These changes are expected to trigger a number of events that should be delivered
    //      to the snapshot listener from 1.
    //   3. Once all the document updates have been performed, and the expected number of events
    //      has been delivered to the snapshot listener, the events will be queried for the expected
    //      series of events and will then be asserted on.
    //
    // The mechanics of how the test is executed are as follows
    //   A. All events delivered to the listener in 1 are added to a list of events we receive.
    //   B. A separate ExecutorService is created and has tasks submitted to it to perform the
    //      series of document updates mentioned in 2. (Each document gets its own task).
    //      * Each of these update tasks will wait for the snapshot listener to be active before
    //        performing the updates.
    //   C. CountDownLatches are used to keep track of completion of work while the test is running.
    //      * Every time an event is received by the listener in 1 a CDL is decremented.
    //      * Each document update task has a CDL that is decremented when all actions have been
    //        performed
    //      * Each CDL has a timeout associated with its await (this is important so that in the
    //        case there is a hang during the test the whole suite isn't taken with it)
    //   D. After all updates have been performed and the expected number of events have been
    //      received, assertions on the events will be performed.
    //
    // Note: There is a potential that this test fails if the Firestore backend chooses not to send
    // us individual changes for every document update, but rather merges two or more changes into
    // a single event. We have, however, not seen any failures during thousands of test runs.
    ListenerRegistration registration = null;
    final ExecutorService updatesExecutor = Executors.newCachedThreadPool();

    final List<ListenerEvent> receivedEvents =
        Collections.synchronizedList(new ArrayList<ListenerEvent>());

    try {
      // create our CDLs that are used to track work completion
      final CountDownLatch doc1CDL = new CountDownLatch(1);
      final CountDownLatch doc2CDL = new CountDownLatch(1);
      final CountDownLatch eventsCDL = new CountDownLatch(6);

      // create a CDL that is used to signal the snapshot lister is active.
      // if we don't do this, there is a possible race with out document updates happening before
      // the listener has received the "empty" event that is expected in the case that the
      // result set of the query would be empty (i.e. in the case of an empty collection with new
      // documents being created)
      final CountDownLatch snapshotListerActive = new CountDownLatch(1);

      final Query query = randomColl.whereEqualTo("foo", "bar");
      // register the snapshot listener for the query
      registration =
          query.addSnapshotListener(
              new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(
                    @Nullable QuerySnapshot value, @Nullable FirestoreException error) {
                  snapshotListerActive.countDown();
                  receivedEvents.add(new ListenerEvent(value, error));
                  eventsCDL.countDown();
                }
              });

      // Perform a series of operations on some documents in a separate thread
      // While we listen for the changes
      updatesExecutor.submit(
          new Runnable() {
            DocumentReference doc1 = randomColl.document("doc1");

            @Override
            public void run() {
              try {
                snapshotListerActive.await(5, TimeUnit.SECONDS);
                // create the first document
                doc1.set(map("baz", "foo")).get();
                // update the document
                doc1.set(map("foo", "bar")).get();
                // add a field to the document
                doc1.set(map("foo", "bar", "bar", "foo")).get();
                // delete the document
                doc1.delete().get();
              } catch (InterruptedException | ExecutionException e) {
                fail(String.format("Error while processing doc1: %s", e.getMessage()));
              } finally {
                doc1CDL.countDown();
              }
            }
          });

      updatesExecutor.submit(
          new Runnable() {
            DocumentReference doc2 = randomColl.document("doc2");

            @Override
            public void run() {
              try {
                snapshotListerActive.await(5, TimeUnit.SECONDS);
                // create a second document
                doc2.set(map("foo", "bar")).get();
                // update the document
                doc2.set(map("foo", "foo")).get();
              } catch (InterruptedException | ExecutionException e) {
                fail(String.format("Error while processing doc2: %s", e.getMessage()));
              } finally {
                doc2CDL.countDown();
              }
            }
          });

      // Wait for the document update operations to be performed
      final boolean doc1CDLAwait = doc1CDL.await(10, TimeUnit.SECONDS);
      assertTrue("all operations for doc1 were not completed in time", doc1CDLAwait);
      final boolean doc2CDLAwait = doc2CDL.await(10, TimeUnit.SECONDS);
      assertTrue("all operations for doc2 were not completed in time", doc2CDLAwait);

      // Wait for the expected number of update events to be delivered to our listener
      eventsCDL.await(30, TimeUnit.SECONDS);
    } finally {
      // cleanup out listener
      if (registration != null) {
        registration.remove();
      }
      // Shutdown the thread pool used to perform the document updates
      updatesExecutor.shutdown();
    }

    // Extract certain events from the list of events we received in out listener

    final FluentIterable<ListenerEvent> events = FluentIterable.from(receivedEvents);

    final Optional<ListenerEvent> anyError =
        events.firstMatch(
            new Predicate<ListenerEvent>() {
              @Override
              public boolean apply(ListenerEvent input) {
                return input.error != null;
              }
            });
    assertWithMessage("snapshotListener received an error").that(anyError).isAbsent();

    final FluentIterable<QuerySnapshot> querySnapshots =
        events
            .filter(
                new Predicate<ListenerEvent>() {
                  @Override
                  public boolean apply(ListenerEvent input) {
                    return input.value != null;
                  }
                })
            .transform(
                new com.google.common.base.Function<ListenerEvent, QuerySnapshot>() {
                  @Override
                  public QuerySnapshot apply(ListenerEvent input) {
                    return input.value;
                  }
                });

    final Optional<QuerySnapshot> initialEmpty =
        querySnapshots.firstMatch(
            new Predicate<QuerySnapshot>() {
              @Override
              public boolean apply(QuerySnapshot input) {
                return input.isEmpty() && input.getDocumentChanges().size() == 0;
              }
            });
    final Set<String> addedDocumentIds = getIds(querySnapshots, DocumentChange.Type.ADDED);
    final Set<String> modifiedDocumentIds = getIds(querySnapshots, DocumentChange.Type.MODIFIED);
    final Set<String> removedDocumentIds = getIds(querySnapshots, DocumentChange.Type.REMOVED);
    final Optional<QuerySnapshot> finalRemove =
        querySnapshots.firstMatch(
            new Predicate<QuerySnapshot>() {
              @Override
              public boolean apply(QuerySnapshot input) {
                return input.isEmpty() && input.getDocumentChanges().size() == 1;
              }
            });

    assertWithMessage("snapshotListener did not receive expected initial empty event")
        .that(initialEmpty)
        .isPresent();
    assertWithMessage("snapshotListener did not receive expected added events")
        .that(addedDocumentIds)
        .isEqualTo(newHashSet("doc1", "doc2"));
    assertWithMessage("snapshotListener did not receive expected modified events")
        .that(modifiedDocumentIds)
        .isEqualTo(newHashSet("doc1"));
    assertWithMessage("snapshotListener did not receive expected removed events")
        .that(removedDocumentIds)
        .isEqualTo(newHashSet("doc1", "doc2"));
    assertWithMessage("snapshotListener did not receive expected final empty event")
        .that(finalRemove)
        .isPresent();
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
    doc1.set(Collections.singletonMap("foo", (Object) FieldValue.arrayUnion("bar"))).get();
    doc2.set(Collections.singletonMap("foo", (Object) FieldValue.arrayUnion("baz"))).get();

    assertEquals(1, containsQuery.get().get().size());

    doc1.set(Collections.singletonMap("foo", (Object) FieldValue.arrayRemove("bar"))).get();
    doc2.set(Collections.singletonMap("foo", (Object) FieldValue.arrayRemove("baz"))).get();

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
    assertEquals(
        asList("cg-doc1", "cg-doc2", "cg-doc3", "cg-doc4", "cg-doc5"),
        querySnapshotToIds(querySnapshot));
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
    assertEquals(asList("cg-doc2", "cg-doc3", "cg-doc4"), querySnapshotToIds(querySnapshot));

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
    setDocument("a", map("zip", (Object) 98101));
    setDocument("b", map("zip", (Object) 91102));
    setDocument("c", map("zip", (Object) 98103));
    setDocument("d", map("zip", (Object) asList(98101)));
    setDocument("e", map("zip", (Object) asList("98101", map("zip", 98101))));
    setDocument("f", map("zip", (Object) map("code", 500)));

    QuerySnapshot querySnapshot =
        randomColl.whereIn("zip", Arrays.<Object>asList(98101, 98103)).get().get();

    assertEquals(asList("a", "c"), querySnapshotToIds(querySnapshot));
  }

  @Test
  public void arrayContainsAnyQueries() throws Exception {
    setDocument("a", map("array", (Object) asList(42)));
    setDocument("b", map("array", (Object) asList("a", 42, "c")));
    setDocument("c", map("array", (Object) asList(41.999, "42", map("a", 42))));
    setDocument("d", map("array", (Object) asList(42), "array2", "sigh"));
    setDocument("e", map("array", (Object) asList(43)));
    setDocument("f", map("array", (Object) asList(map("a", 42))));
    setDocument("g", map("array", (Object) 42));

    QuerySnapshot querySnapshot =
        randomColl.whereArrayContainsAny("array", Arrays.<Object>asList(42, 43)).get().get();

    assertEquals(asList("a", "b", "d", "e"), querySnapshotToIds(querySnapshot));
  }

  @Test
  public void integerIncrement() throws ExecutionException, InterruptedException {
    DocumentReference docRef = randomColl.document();
    docRef.set(Collections.singletonMap("sum", (Object) 1L)).get();
    docRef.update("sum", FieldValue.increment(2)).get();
    DocumentSnapshot docSnap = docRef.get().get();
    assertEquals(3L, docSnap.get("sum"));
  }

  @Test
  public void floatIncrement() throws ExecutionException, InterruptedException {
    DocumentReference docRef = randomColl.document();
    docRef.set(Collections.singletonMap("sum", (Object) 1.1)).get();
    docRef.update("sum", FieldValue.increment(2.2)).get();
    DocumentSnapshot docSnap = docRef.get().get();
    assertEquals(3.3, (Double) docSnap.get("sum"), DOUBLE_EPSILON);
  }

  private static Set<String> getIds(
      FluentIterable<QuerySnapshot> querySnapshots, DocumentChange.Type type) {
    final Set<String> documentIds = new HashSet<>();
    for (QuerySnapshot querySnapshot : querySnapshots) {
      final List<DocumentChange> changes = querySnapshot.getDocumentChanges();
      for (DocumentChange change : changes) {
        if (change.getType() == type) {
          documentIds.add(change.getDocument().getId());
        }
      }
    }
    return documentIds;
  }

  /**
   * A tuple class used by {@code #queryWatch}. This class represents an event delivered to the
   * registered query listener.
   */
  private static final class ListenerEvent {

    @Nullable private final QuerySnapshot value;
    @Nullable private final FirestoreException error;

    ListenerEvent(@Nullable QuerySnapshot value, @Nullable FirestoreException error) {
      this.value = value;
      this.error = error;
    }
  }

  @Test
  public void getAllWithObserver() throws Exception {
    DocumentReference ref1 = randomColl.document("doc1");
    ref1.set(ALL_SUPPORTED_TYPES_MAP).get();

    DocumentReference ref2 = randomColl.document("doc2");
    ref2.set(ALL_SUPPORTED_TYPES_MAP).get();

    DocumentReference ref3 = randomColl.document("doc3");

    final List<DocumentSnapshot> documentSnapshots =
        Collections.synchronizedList(new ArrayList<DocumentSnapshot>());
    final DocumentReference[] documentReferences = {ref1, ref2, ref3};
    final SettableApiFuture<Void> future = SettableApiFuture.create();
    firestore.getAll(
        documentReferences,
        FieldMask.of("foo"),
        new ApiStreamObserver<DocumentSnapshot>() {

          @Override
          public void onNext(DocumentSnapshot documentSnapshot) {
            documentSnapshots.add(documentSnapshot);
          }

          @Override
          public void onError(Throwable throwable) {
            future.setException(throwable);
          }

          @Override
          public void onCompleted() {
            future.set(null);
          }
        });

    future.get();

    assertEquals(
        ALL_SUPPORTED_TYPES_OBJECT, documentSnapshots.get(0).toObject(AllSupportedTypes.class));
    assertEquals(
        ALL_SUPPORTED_TYPES_OBJECT, documentSnapshots.get(1).toObject(AllSupportedTypes.class));
    assertNotEquals(
        ALL_SUPPORTED_TYPES_OBJECT, documentSnapshots.get(2).toObject(AllSupportedTypes.class));
    assertEquals(ref1.getId(), documentSnapshots.get(0).getId());
    assertEquals(ref2.getId(), documentSnapshots.get(1).getId());
    assertEquals(ref3.getId(), documentSnapshots.get(2).getId());
    assertEquals(3, documentSnapshots.size());
  }
}
