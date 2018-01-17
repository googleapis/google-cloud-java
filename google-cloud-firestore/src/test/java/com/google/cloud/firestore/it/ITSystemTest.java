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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentChange.Type;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.EventListener;
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
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.threeten.bp.Instant;

public class ITSystemTest {

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
    firestore = FirestoreOptions.getDefaultInstance().getService();
    randomColl =
        firestore.collection(
            String.format("java-%s-%s", testName.getMethodName(), LocalFirestoreHelper.autoId()));
    randomDoc = randomColl.document();
  }

  private DocumentReference addDocument(String key, Object value, Object... fields)
      throws Exception {
    DocumentReference documentReference = randomColl.document();
    documentReference.update(Precondition.NONE, key, value, fields).get();
    return documentReference;
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
    Map<String, Object> updateMap = map("c", FieldValue.serverTimestamp());
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
      randomDoc.delete(Precondition.updatedAt(Instant.ofEpochSecond(1))).get();
      fail();
    } catch (ExecutionException e) {
      assertTrue(e.getMessage().contains("FAILED_PRECONDITION"));
    }
    writeResult = randomDoc.delete(Precondition.updatedAt(writeResult.getUpdateTime())).get();
    DocumentSnapshot documentSnapshot = randomDoc.get().get();
    assertFalse(documentSnapshot.exists());
    assertTrue(writeResult.getUpdateTime().getEpochSecond() > 0);
  }

  @Test
  public void emptyQuery() throws Exception {
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
                DocumentSnapshot documentSnapshot = transaction.get(documentReference).get();
                latch.countDown();
                latch.await();
                transaction.update(
                    documentReference, "counter", documentSnapshot.getLong("counter") + 1);
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
  public void getCollections() throws Exception {
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

    Iterable<CollectionReference> collectionRefs = randomDoc.getCollections();

    int count = 0;
    for (CollectionReference collectionRef : collectionRefs) {
      assertEquals(collections[count++], collectionRef.getId());
    }
    assertEquals(collections.length, count);
  }

  @Test
  public void addAndRemoveFields() throws ExecutionException, InterruptedException {
    Map<String, Object> expected = new HashMap<>();

    randomDoc.create(Collections.<String, Object>emptyMap()).get();
    assertEquals(expected, getData());

    randomDoc.delete();
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
    Date time = (Date) getData().get("time");
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

  private Date updateTime(Map<String, Object> dataWithTime)
      throws ExecutionException, InterruptedException {
    Date time = (Date) getData().get("time");
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
    final Semaphore semaphore = new Semaphore(0);
    ListenerRegistration registration = null;

    try {
      registration =
          randomColl
              .whereEqualTo("foo", "bar")
              .addSnapshotListener(
                  new EventListener<QuerySnapshot>() {
                    DocumentReference ref1;
                    DocumentReference ref2;

                    @Override
                    public void onEvent(
                        @Nullable QuerySnapshot value, @Nullable FirestoreException error) {
                      try {
                        switch (semaphore.availablePermits()) {
                          case 0:
                            assertTrue(value.isEmpty());
                            ref1 = randomColl.add(map("foo", "foo")).get();
                            ref2 = randomColl.add(map("foo", "bar")).get();
                            break;
                          case 1:
                            assertEquals(1, value.size());
                            assertEquals(1, value.getDocumentChanges().size());
                            assertEquals(Type.ADDED, value.getDocumentChanges().get(0).getType());
                            ref1.set(map("foo", "bar"));
                            break;
                          case 2:
                            assertEquals(2, value.size());
                            assertEquals(1, value.getDocumentChanges().size());
                            assertEquals(Type.ADDED, value.getDocumentChanges().get(0).getType());
                            ref1.set(map("foo", "bar", "bar", " foo"));
                            break;
                          case 3:
                            assertEquals(2, value.size());
                            assertEquals(1, value.getDocumentChanges().size());
                            assertEquals(
                                Type.MODIFIED, value.getDocumentChanges().get(0).getType());
                            ref2.set(map("foo", "foo"));
                            break;
                          case 4:
                            assertEquals(1, value.size());
                            assertEquals(1, value.getDocumentChanges().size());
                            assertEquals(Type.REMOVED, value.getDocumentChanges().get(0).getType());
                            ref1.delete();
                            break;
                          case 5:
                            assertTrue(value.isEmpty());
                            assertEquals(1, value.getDocumentChanges().size());
                            assertEquals(Type.REMOVED, value.getDocumentChanges().get(0).getType());
                            break;
                        }
                      } catch (Exception e) {
                        fail(e.getMessage());
                      }
                      semaphore.release();
                    }
                  });

      semaphore.acquire(6);
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
}
