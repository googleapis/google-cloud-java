/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.core.ApiFutures;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.LocalFirestoreHelper;
import com.google.cloud.firestore.LocalFirestoreHelper.AllSupportedTypes;
import com.google.cloud.firestore.LocalFirestoreHelper.SingleField;
import com.google.cloud.firestore.Precondition;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.Transaction;
import com.google.cloud.firestore.Transaction.Function;
import com.google.cloud.firestore.WriteBatch;
import com.google.cloud.firestore.WriteResult;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
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

  @Before
  public void before() {
    firestore = FirestoreOptions.getDefaultInstance().getService();
    randomColl =
        firestore.collection(
            String.format("java-%s-%s", testName.getMethodName(), LocalFirestoreHelper.autoId()));
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
    DocumentReference documentReference = randomColl.document();
    assertEquals(20, documentReference.getId().length());
    documentReference.create(SINGLE_FIELD_MAP).get();
    DocumentSnapshot documentSnapshot = documentReference.get().get();
    assertEquals(SINGLE_FIELD_OBJECT, documentSnapshot.toObject(SingleField.class));
  }

  @Test
  public void setDocument() throws Exception {
    Map<String, Object> nanNullMap = new HashMap<>();
    nanNullMap.put("nan", Double.NaN);
    nanNullMap.put("null", null);
    DocumentReference documentReference = randomColl.document("doc");
    documentReference.set(nanNullMap).get();
    DocumentSnapshot documentSnapshot = documentReference.get().get();
    assertEquals((Double) Double.NaN, documentSnapshot.getDouble("nan"));
    assertEquals(null, documentSnapshot.get("null"));
  }

  @Test
  public void setDocumentWithMerge() throws Exception {
    ImmutableMap<String, Object> originalMap =
        ImmutableMap.<String, Object>of("a.b", "c", "nested", ImmutableMap.of("d", "e"));
    ImmutableMap<String, Object> updateMap =
        ImmutableMap.<String, Object>of("f.g", "h", "nested", ImmutableMap.of("i", "j"));
    ImmutableMap<String, Object> resultMap =
        ImmutableMap.<String, Object>of(
            "a.b", "c", "f.g", "h", "nested", ImmutableMap.of("d", "e", "i", "j"));
    DocumentReference documentReference = randomColl.document("doc");
    documentReference.set(originalMap).get();
    documentReference.set(updateMap, SetOptions.merge()).get();
    DocumentSnapshot documentSnapshot = documentReference.get().get();
    assertEquals(resultMap, documentSnapshot.getData());
  }

  @Test
  public void mergeDocumentWithServerTimestamp() throws Exception {
    ImmutableMap<String, Object> originalMap = ImmutableMap.<String, Object>of("a", "b");
    ImmutableMap<String, Object> updateMap =
        ImmutableMap.<String, Object>of("c", FieldValue.serverTimestamp());
    DocumentReference documentReference = randomColl.document("doc");
    documentReference.set(originalMap).get();
    documentReference.set(updateMap, SetOptions.merge()).get();
    DocumentSnapshot documentSnapshot = documentReference.get().get();
    assertEquals("b", documentSnapshot.getString("a"));
    assertNotNull(documentSnapshot.getDate("c"));
  }

  @Test
  public void updateDocument() throws Exception {
    AllSupportedTypes expectedResult = new AllSupportedTypes();
    DocumentReference documentReference = randomColl.document("doc");
    WriteResult writeResult = documentReference.set(ALL_SUPPORTED_TYPES_MAP).get();
    DocumentSnapshot documentSnapshot = documentReference.get().get();
    assertEquals(expectedResult, documentSnapshot.toObject(AllSupportedTypes.class));
    documentReference
        .update(Precondition.updatedAt(writeResult.getUpdateTime()), "foo", "updated")
        .get();
    documentSnapshot = documentReference.get().get();
    expectedResult.foo = "updated";
    assertEquals(expectedResult, documentSnapshot.toObject(AllSupportedTypes.class));
  }

  @Test(expected = ExecutionException.class)
  public void updateDocumentExists() throws Exception {
    DocumentReference documentReference = randomColl.document("doc");
    documentReference.update(SINGLE_FIELD_MAP).get();
  }

  @Test
  public void serverTimestamp() throws Exception {
    DocumentReference documentReference = randomColl.document("doc");
    documentReference.set(ImmutableMap.of("time", FieldValue.serverTimestamp())).get();
    DocumentSnapshot documentSnapshot = documentReference.get().get();
    assertTrue(documentSnapshot.getDate("time").getTime() > 0);
  }

  @Test
  public void fieldDelete() throws Exception {
    Map<String, Object> fields = new HashMap<>();
    fields.put("foo1", "bar1");
    fields.put("foo2", "bar2");
    DocumentReference documentReference = randomColl.document("doc");
    documentReference.set(fields).get();
    DocumentSnapshot documentSnapshot = documentReference.get().get();
    assertEquals("bar1", documentSnapshot.getString("foo1"));
    assertEquals("bar2", documentSnapshot.getString("foo2"));
    documentReference.update("foo1", "bar3", "foo2", FieldValue.delete()).get();
    documentSnapshot = documentReference.get().get();
    assertEquals("bar3", documentSnapshot.getString("foo1"));
    assertNull(documentSnapshot.getString("foo2"));
  }

  @Test
  public void deleteDocument() throws Exception {
    DocumentReference documentReference = randomColl.document("doc");
    documentReference.delete().get();
    WriteResult writeResult = documentReference.set(ALL_SUPPORTED_TYPES_MAP).get();
    try {
      documentReference.delete(Precondition.updatedAt(Instant.ofEpochSecond(1))).get();
      fail();
    } catch (ExecutionException e) {
      assertTrue(e.getMessage().contains("FAILED_PRECONDITION"));
    }
    documentReference.delete(Precondition.updatedAt(writeResult.getUpdateTime())).get();
    DocumentSnapshot documentSnapshot = documentReference.get().get();
    assertFalse(documentSnapshot.exists());
  }

  @Test
  public void emptyQuery() throws Exception {
    addDocument("foo", "bar");
    addDocument("foo", "bar");

    QuerySnapshot querySnapshot = randomColl.get().get();
    assertEquals(2, querySnapshot.size());

    Iterator<DocumentSnapshot> documents = querySnapshot.iterator();
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
    Iterator<DocumentSnapshot> documents = querySnapshot.iterator();
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
    Iterator<DocumentSnapshot> documents = querySnapshot.iterator();
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
    Iterator<DocumentSnapshot> documents = querySnapshot.iterator();
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
    } catch (Exception e) {
      assertTrue(e.getMessage().endsWith("User exception"));
    }
  }

  @Test
  public void successfulTransaction() throws Exception {
    final DocumentReference documentReference = addDocument("foo", 1);

    String result =
        firestore
            .runTransaction(
                new Transaction.Function<String>() {
                  @Override
                  public String updateCallback(Transaction transaction)
                      throws ExecutionException, InterruptedException {
                    DocumentSnapshot documentSnapshot = documentReference.get().get();
                    documentReference.update("foo", documentSnapshot.getLong("foo") + 1);
                    return "bar";
                  }
                })
            .get();

    assertEquals("bar", result);
    assertEquals(2L, documentReference.get().get().get("foo"));
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
  public void getCollections() throws Exception {
    String[] collections = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    DocumentReference documentReference = randomColl.document("doc");

    WriteBatch batch = firestore.batch();

    for (String collection : collections) {
      batch.create(documentReference.collection(collection).document("doc"), SINGLE_FIELD_OBJECT);
    }

    batch.commit().get();

    List<CollectionReference> collectionRefs = documentReference.getCollections().get();

    assertEquals(collections.length, collectionRefs.size());

    for (int i = 0; i < collections.length; ++i) {
      assertEquals(collections[i], collectionRefs.get(i).getId());
    }
  }
}
