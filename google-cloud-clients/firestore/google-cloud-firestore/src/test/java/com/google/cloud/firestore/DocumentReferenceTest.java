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

package com.google.cloud.firestore;

import static com.google.cloud.firestore.LocalFirestoreHelper.ALL_SUPPORTED_TYPES_MAP;
import static com.google.cloud.firestore.LocalFirestoreHelper.ALL_SUPPORTED_TYPES_OBJECT;
import static com.google.cloud.firestore.LocalFirestoreHelper.ALL_SUPPORTED_TYPES_PROTO;
import static com.google.cloud.firestore.LocalFirestoreHelper.BLOB;
import static com.google.cloud.firestore.LocalFirestoreHelper.CREATE_PRECONDITION;
import static com.google.cloud.firestore.LocalFirestoreHelper.DATE;
import static com.google.cloud.firestore.LocalFirestoreHelper.DOCUMENT_NAME;
import static com.google.cloud.firestore.LocalFirestoreHelper.DOCUMENT_PATH;
import static com.google.cloud.firestore.LocalFirestoreHelper.FIELD_TRANSFORM_COMMIT_RESPONSE;
import static com.google.cloud.firestore.LocalFirestoreHelper.GEO_POINT;
import static com.google.cloud.firestore.LocalFirestoreHelper.NESTED_CLASS_OBJECT;
import static com.google.cloud.firestore.LocalFirestoreHelper.SERVER_TIMESTAMP_PROTO;
import static com.google.cloud.firestore.LocalFirestoreHelper.SERVER_TIMESTAMP_TRANSFORM;
import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_DELETE_COMMIT_RESPONSE;
import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_FIELD_MAP;
import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_FIELD_OBJECT;
import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_FIELD_PROTO;
import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_WRITE_COMMIT_RESPONSE;
import static com.google.cloud.firestore.LocalFirestoreHelper.TIMESTAMP;
import static com.google.cloud.firestore.LocalFirestoreHelper.UPDATE_PRECONDITION;
import static com.google.cloud.firestore.LocalFirestoreHelper.arrayRemove;
import static com.google.cloud.firestore.LocalFirestoreHelper.arrayUnion;
import static com.google.cloud.firestore.LocalFirestoreHelper.assertCommitEquals;
import static com.google.cloud.firestore.LocalFirestoreHelper.commit;
import static com.google.cloud.firestore.LocalFirestoreHelper.create;
import static com.google.cloud.firestore.LocalFirestoreHelper.delete;
import static com.google.cloud.firestore.LocalFirestoreHelper.get;
import static com.google.cloud.firestore.LocalFirestoreHelper.getAllResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.increment;
import static com.google.cloud.firestore.LocalFirestoreHelper.map;
import static com.google.cloud.firestore.LocalFirestoreHelper.object;
import static com.google.cloud.firestore.LocalFirestoreHelper.serverTimestamp;
import static com.google.cloud.firestore.LocalFirestoreHelper.set;
import static com.google.cloud.firestore.LocalFirestoreHelper.streamingResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.string;
import static com.google.cloud.firestore.LocalFirestoreHelper.transform;
import static com.google.cloud.firestore.LocalFirestoreHelper.update;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;

import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.LocalFirestoreHelper.InvalidPOJO;
import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import com.google.common.collect.ImmutableList;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.Value;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DocumentReferenceTest {

  @Spy
  private FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder().setProjectId("test-project").build(),
          Mockito.mock(FirestoreRpc.class));

  @Captor private ArgumentCaptor<CommitRequest> commitCapture;

  @Captor private ArgumentCaptor<BatchGetDocumentsRequest> getAllCapture;

  @Captor private ArgumentCaptor<ApiStreamObserver> streamObserverCapture;

  private DocumentReference documentReference;

  @Before
  public void before() {
    documentReference = firestoreMock.document("coll/doc");
  }

  @Test
  public void equals() {
    DocumentReference doc1 = documentReference.collection("subcoll").document("doc");
    DocumentReference doc2 = documentReference.collection("subcoll").document("doc");
    assertEquals(doc1, doc2);
  }

  @Test
  public void getCollection() {
    CollectionReference collectionReference = documentReference.collection("subcoll");
    assertEquals("subcoll", collectionReference.getId());
  }

  @Test
  public void getPath() {
    assertEquals(DOCUMENT_PATH, documentReference.getPath());
  }

  @Test
  public void getParent() {
    CollectionReference collectionReference = documentReference.getParent();
    assertEquals("coll", collectionReference.getId());
  }

  @Test
  public void serializeBasicTypes() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.set(ALL_SUPPORTED_TYPES_MAP).get();
    documentReference.set(ALL_SUPPORTED_TYPES_OBJECT).get();

    CommitRequest expectedCommit = commit(set(ALL_SUPPORTED_TYPES_PROTO));
    assertCommitEquals(expectedCommit, commitCapture.getAllValues().get(0));
    assertCommitEquals(expectedCommit, commitCapture.getAllValues().get(1));
  }

  @Test
  public void serializeDocumentReference() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.set(map("docRef", (Object) documentReference)).get();

    Map<String, Value> documentReferenceFields = new HashMap<>();
    documentReferenceFields.put(
        "docRef", Value.newBuilder().setReferenceValue(DOCUMENT_NAME).build());

    assertCommitEquals(commit(set(documentReferenceFields)), commitCapture.getValue());
  }

  @Test
  public void doesNotSerializeAdvancedNumberTypes() {
    Map<InvalidPOJO, String> expectedErrorMessages = new HashMap<>();

    InvalidPOJO pojo = new InvalidPOJO();
    pojo.bigIntegerValue = new BigInteger("0");
    expectedErrorMessages.put(
        pojo,
        "Could not serialize object. Numbers of type BigInteger are not supported, please use an int, long, float or double (found in field 'bigIntegerValue')");

    pojo = new InvalidPOJO();
    pojo.byteValue = 0;
    expectedErrorMessages.put(
        pojo,
        "Could not serialize object. Numbers of type Byte are not supported, please use an int, long, float or double (found in field 'byteValue')");

    pojo = new InvalidPOJO();
    pojo.shortValue = 0;
    expectedErrorMessages.put(
        pojo,
        "Could not serialize object. Numbers of type Short are not supported, please use an int, long, float or double (found in field 'shortValue')");

    for (Map.Entry<InvalidPOJO, String> testCase : expectedErrorMessages.entrySet()) {
      try {
        documentReference.set(testCase.getKey());
        fail();
      } catch (IllegalArgumentException e) {
        assertEquals(testCase.getValue(), e.getMessage());
      }
    }
  }

  @Test
  public void deserializeBasicTypes() throws Exception {
    doAnswer(getAllResponse(ALL_SUPPORTED_TYPES_PROTO))
        .when(firestoreMock)
        .streamRequest(
            getAllCapture.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    doReturn(true).when(firestoreMock).areTimestampsInSnapshotsEnabled();

    DocumentSnapshot snapshot = documentReference.get().get();
    assertEquals(snapshot.getData(), ALL_SUPPORTED_TYPES_MAP);

    LocalFirestoreHelper.AllSupportedTypes pojo =
        snapshot.toObject(LocalFirestoreHelper.AllSupportedTypes.class);
    assertEquals(new LocalFirestoreHelper.AllSupportedTypes(), pojo);

    assertEquals("bar", snapshot.get("foo"));
    assertEquals("bar", snapshot.get(FieldPath.of("foo")));
    assertTrue(snapshot.contains("foo"));
    assertTrue(snapshot.contains(FieldPath.of("foo")));
    assertEquals("bar", snapshot.getString("foo"));
    assertEquals("bar", snapshot.getString("objectValue.foo"));
    assertEquals("bar", snapshot.get(FieldPath.of("objectValue", "foo")));
    assertTrue(snapshot.contains("objectValue.foo"));
    assertTrue(snapshot.contains(FieldPath.of("objectValue", "foo")));
    assertEquals((Double) 0.0, snapshot.getDouble("doubleValue"));
    assertEquals((Long) 0L, snapshot.getLong("longValue"));
    assertEquals(true, snapshot.getBoolean("trueValue"));
    assertEquals(DATE, snapshot.getDate("dateValue"));
    assertEquals(TIMESTAMP, snapshot.getTimestamp("timestampValue"));

    assertEquals(BLOB, snapshot.getBlob("bytesValue"));
    assertEquals(BLOB.hashCode(), snapshot.getBlob("bytesValue").hashCode());
    assertArrayEquals(new byte[] {1, 2, 3}, snapshot.getBlob("bytesValue").toBytes());

    assertEquals(GEO_POINT, snapshot.getGeoPoint("geoPointValue"));
    assertEquals(GEO_POINT.hashCode(), snapshot.getGeoPoint("geoPointValue").hashCode());
    assertEquals(GEO_POINT.getLatitude(), snapshot.getGeoPoint("geoPointValue").getLatitude(), 0);
    assertEquals(GEO_POINT.getLongitude(), snapshot.getGeoPoint("geoPointValue").getLongitude(), 0);

    assertNull(snapshot.get("nullValue"));
    assertTrue(snapshot.contains("nullValue"));

    assertTrue(snapshot.contains("objectValue.foo"));
    assertFalse(snapshot.contains("objectValue.bar"));
    assertTrue(snapshot.exists());

    assertEquals(Timestamp.ofTimeSecondsAndNanos(1, 2), snapshot.getCreateTime());
    assertEquals(Timestamp.ofTimeSecondsAndNanos(3, 4), snapshot.getUpdateTime());
    assertEquals(Timestamp.ofTimeSecondsAndNanos(5, 6), snapshot.getReadTime());

    assertEquals(get(), getAllCapture.getValue());
  }

  @Test
  public void deserializeDocumentReference() throws Exception {
    doAnswer(
            getAllResponse(
                map("docRef", Value.newBuilder().setReferenceValue(DOCUMENT_NAME).build())))
        .when(firestoreMock)
        .streamRequest(
            getAllCapture.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    DocumentSnapshot snapshot = documentReference.get().get();
    assertEquals(documentReference, snapshot.getData().get("docRef"));
    assertEquals(documentReference, snapshot.getReference());
  }

  @Test
  public void deserializesDates() throws Exception {
    doAnswer(getAllResponse(ALL_SUPPORTED_TYPES_PROTO))
        .when(firestoreMock)
        .streamRequest(
            getAllCapture.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    DocumentSnapshot snapshot = documentReference.get().get();

    doReturn(false).when(firestoreMock).areTimestampsInSnapshotsEnabled();

    assertEquals(DATE, snapshot.get("dateValue"));
    assertEquals(TIMESTAMP.toDate(), snapshot.get("timestampValue"));
    assertEquals(DATE, snapshot.getData().get("dateValue"));
    assertEquals(TIMESTAMP.toDate(), snapshot.getData().get("timestampValue"));

    doReturn(true).when(firestoreMock).areTimestampsInSnapshotsEnabled();

    assertEquals(Timestamp.of(DATE), snapshot.get("dateValue"));
    assertEquals(TIMESTAMP, snapshot.get("timestampValue"));
    assertEquals(Timestamp.of(DATE), snapshot.getData().get("dateValue"));
    assertEquals(TIMESTAMP, snapshot.getData().get("timestampValue"));
  }

  @Test
  public void doesNotDeserializeAdvancedNumberTypes() throws Exception {
    Map<String, String> fieldNamesToTypeNames =
        map("bigIntegerValue", "BigInteger", "shortValue", "Short", "byteValue", "Byte");

    for (Entry<String, String> testCase : fieldNamesToTypeNames.entrySet()) {
      String fieldName = testCase.getKey();
      String typeName = testCase.getValue();
      Map<String, Value> response = map(fieldName, Value.newBuilder().setIntegerValue(0).build());

      doAnswer(getAllResponse(response))
          .when(firestoreMock)
          .streamRequest(
              getAllCapture.capture(),
              streamObserverCapture.capture(),
              Matchers.<ServerStreamingCallable>any());

      DocumentSnapshot snapshot = documentReference.get().get();
      try {
        snapshot.toObject(InvalidPOJO.class);
        fail();
      } catch (RuntimeException e) {
        assertEquals(
            String.format(
                "Could not deserialize object. Deserializing values to %s is not supported (found in field '%s')",
                typeName, fieldName),
            e.getMessage());
      }
    }
  }

  @Test
  public void notFound() throws Exception {
    final BatchGetDocumentsResponse.Builder getDocumentResponse =
        BatchGetDocumentsResponse.newBuilder();
    getDocumentResponse.setMissing(DOCUMENT_NAME);
    getDocumentResponse.setReadTime(
        com.google.protobuf.Timestamp.newBuilder().setSeconds(5).setNanos(6));

    doAnswer(streamingResponse(getDocumentResponse.build()))
        .when(firestoreMock)
        .streamRequest(
            getAllCapture.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    DocumentSnapshot snapshot = documentReference.get().get();
    assertEquals(documentReference, snapshot.getReference());
    assertFalse(snapshot.exists());
    assertEquals(snapshot.getReadTime(), Timestamp.ofTimeSecondsAndNanos(5, 6));
    assertNull(snapshot.getData());
  }

  @Test
  public void deleteDocument() throws Exception {
    doReturn(SINGLE_DELETE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.delete().get();
    documentReference
        .delete(Precondition.updatedAt(Timestamp.ofTimeSecondsAndNanos(479978400, 123000000)))
        .get();

    List<CommitRequest> commitRequests = commitCapture.getAllValues();
    assertCommitEquals(commit(delete()), commitRequests.get(0));

    com.google.firestore.v1.Precondition.Builder precondition =
        com.google.firestore.v1.Precondition.newBuilder();
    precondition.getUpdateTimeBuilder().setSeconds(479978400).setNanos(123000000);
    assertCommitEquals(commit(delete(precondition.build())), commitRequests.get(1));
  }

  @Test
  public void createDocument() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.create(SINGLE_FIELD_MAP).get();
    documentReference.create(SINGLE_FIELD_OBJECT).get();

    CommitRequest expectedCommit = commit(create(SINGLE_FIELD_PROTO));

    List<CommitRequest> commitRequests = commitCapture.getAllValues();
    assertCommitEquals(expectedCommit, commitRequests.get(0));
    assertCommitEquals(expectedCommit, commitRequests.get(1));
  }

  @Test
  public void createWithServerTimestamp() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.create(LocalFirestoreHelper.SERVER_TIMESTAMP_MAP).get();
    documentReference.create(LocalFirestoreHelper.SERVER_TIMESTAMP_OBJECT).get();

    CommitRequest create =
        commit(
            transform(
                CREATE_PRECONDITION, "foo", serverTimestamp(), "inner.bar", serverTimestamp()));

    List<CommitRequest> commitRequests = commitCapture.getAllValues();
    assertCommitEquals(create, commitRequests.get(0));
    assertCommitEquals(create, commitRequests.get(1));
  }

  @Test
  public void setWithServerTimestamp() throws Exception {
    doReturn(FIELD_TRANSFORM_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.set(LocalFirestoreHelper.SERVER_TIMESTAMP_MAP).get();
    documentReference.set(LocalFirestoreHelper.SERVER_TIMESTAMP_OBJECT).get();

    CommitRequest set = commit(set(SERVER_TIMESTAMP_PROTO), SERVER_TIMESTAMP_TRANSFORM);

    List<CommitRequest> commitRequests = commitCapture.getAllValues();
    assertCommitEquals(set, commitRequests.get(0));
    assertCommitEquals(set, commitRequests.get(1));
  }

  @Test
  public void updateWithServerTimestamp() throws Exception {
    doReturn(FIELD_TRANSFORM_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.update(LocalFirestoreHelper.SERVER_TIMESTAMP_MAP).get();

    CommitRequest update =
        commit(
            update(Collections.<String, Value>emptyMap(), Collections.singletonList("inner")),
            SERVER_TIMESTAMP_TRANSFORM);

    assertCommitEquals(update, commitCapture.getValue());

    documentReference.update(
        "foo", FieldValue.serverTimestamp(), "inner.bar", FieldValue.serverTimestamp());

    update =
        commit(
            transform(
                UPDATE_PRECONDITION, "foo", serverTimestamp(), "inner.bar", serverTimestamp()));

    assertCommitEquals(update, commitCapture.getValue());
  }

  @Test
  public void mergeWithServerTimestamps() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference
        .set(LocalFirestoreHelper.SERVER_TIMESTAMP_MAP, SetOptions.mergeFields("inner.bar"))
        .get();
    documentReference
        .set(LocalFirestoreHelper.SERVER_TIMESTAMP_OBJECT, SetOptions.mergeFields("inner.bar"))
        .get();

    CommitRequest set = commit(transform("inner.bar", serverTimestamp()));

    List<CommitRequest> commitRequests = commitCapture.getAllValues();
    assertCommitEquals(set, commitRequests.get(0));
    assertCommitEquals(set, commitRequests.get(1));
  }

  @Test
  public void setWithIncrement() throws Exception {
    doReturn(FIELD_TRANSFORM_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference
        .set(map("integer", FieldValue.increment(1), "double", FieldValue.increment(1.1)))
        .get();

    CommitRequest set =
        commit(
            set(Collections.<String, Value>emptyMap()),
            transform(
                "integer",
                increment(Value.newBuilder().setIntegerValue(1).build()),
                "double",
                increment(Value.newBuilder().setDoubleValue(1.1).build())));

    CommitRequest commitRequest = commitCapture.getValue();
    assertCommitEquals(set, commitRequest);
  }

  @Test
  public void setWithArrayUnion() throws Exception {
    doReturn(FIELD_TRANSFORM_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.set(map("foo", FieldValue.arrayUnion("bar", map("foo", "baz")))).get();

    CommitRequest set =
        commit(
            set(Collections.<String, Value>emptyMap()),
            transform("foo", arrayUnion(string("bar"), object("foo", string("baz")))));

    CommitRequest commitRequest = commitCapture.getValue();
    assertCommitEquals(set, commitRequest);
  }

  @Test
  public void setWithArrayRemove() throws Exception {
    doReturn(FIELD_TRANSFORM_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.set(map("foo", FieldValue.arrayRemove("bar", map("foo", "baz")))).get();

    CommitRequest set =
        commit(
            set(Collections.<String, Value>emptyMap()),
            transform("foo", arrayRemove(string("bar"), object("foo", string("baz")))));

    CommitRequest commitRequest = commitCapture.getValue();
    assertCommitEquals(set, commitRequest);
  }

  @Test
  public void serverTimestampInArray() {
    Map<String, Object> list = new HashMap<>();
    list.put("foo", ImmutableList.of(FieldValue.serverTimestamp()));

    try {
      documentReference.create(list);
      fail();
    } catch (FirestoreException e) {
      assertTrue(
          e.getMessage()
              .endsWith("FieldValue.serverTimestamp() is not supported inside of an array."));
    }

    list.clear();
    list.put("a", ImmutableList.of(ImmutableList.of("b", map("c", FieldValue.serverTimestamp()))));

    try {
      documentReference.create(list);
      fail();
    } catch (FirestoreException e) {
      assertTrue(
          e.getMessage()
              .endsWith("FieldValue.serverTimestamp() is not supported inside of an array."));
    }
  }

  @Test
  public void deleteInArray() {
    Map<String, Object> list = new HashMap<>();
    list.put("foo", ImmutableList.of(FieldValue.delete()));

    try {
      documentReference.create(list);
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(
          e.getMessage().endsWith("FieldValue.delete() is not supported at field 'foo.`0`'."));
    }

    list.clear();
    list.put("a", ImmutableList.of(ImmutableList.of("b", map("c", FieldValue.delete()))));

    try {
      documentReference.create(list);
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(
          e.getMessage().endsWith("FieldValue.delete() is not supported at field 'a.`0`.`1`.c'."));
    }
  }

  @Test
  public void arrayUnionInArray() {
    Map<String, Object> list = new HashMap<>();
    list.put("foo", ImmutableList.of(FieldValue.arrayUnion("foo")));

    try {
      documentReference.create(list);
      fail();
    } catch (FirestoreException e) {
      assertTrue(
          e.getMessage().endsWith("FieldValue.arrayUnion() is not supported inside of an array."));
    }

    list.clear();
    list.put("a", ImmutableList.of(ImmutableList.of("b", map("c", FieldValue.arrayUnion("foo")))));

    try {
      documentReference.create(list);
      fail();
    } catch (FirestoreException e) {
      assertTrue(
          e.getMessage().endsWith("FieldValue.arrayUnion() is not supported inside of an array."));
    }
  }

  @Test
  public void arrayUnionInArrayUnion() {
    Map<String, Object> data = new HashMap<>();
    data.put("foo", FieldValue.arrayUnion(FieldValue.arrayUnion("foo")));

    try {
      documentReference.create(data);
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(
          e.getMessage()
              .endsWith("Cannot use FieldValue.arrayUnion() as an argument at field 'foo'."));
    }
  }

  @Test
  public void deleteInArrayUnion() {
    Map<String, Object> data = new HashMap<>();
    data.put("foo", FieldValue.arrayUnion(FieldValue.delete()));

    try {
      documentReference.set(data, SetOptions.merge());
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(e.getMessage().endsWith("FieldValue.delete() is not supported at field 'foo'."));
    }
  }

  @Test
  public void arrayRemoveInArray() {
    Map<String, Object> list = new HashMap<>();
    list.put("foo", ImmutableList.of(FieldValue.arrayRemove("foo")));

    try {
      documentReference.create(list);
      fail();
    } catch (FirestoreException e) {
      assertTrue(
          e.getMessage().endsWith("FieldValue.arrayRemove() is not supported inside of an array."));
    }

    list.clear();
    list.put("a", ImmutableList.of(ImmutableList.of("b", map("c", FieldValue.arrayRemove("foo")))));

    try {
      documentReference.create(list);
      fail();
    } catch (FirestoreException e) {
      assertTrue(
          e.getMessage().endsWith("FieldValue.arrayRemove() is not supported inside of an array."));
    }
  }

  @Test
  public void setDocumentWithMerge() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.set(SINGLE_FIELD_MAP, SetOptions.merge()).get();
    documentReference.set(SINGLE_FIELD_OBJECT, SetOptions.merge()).get();
    documentReference.set(ALL_SUPPORTED_TYPES_OBJECT, SetOptions.mergeFields("foo")).get();
    documentReference
        .set(ALL_SUPPORTED_TYPES_OBJECT, SetOptions.mergeFields(Arrays.asList("foo")))
        .get();
    documentReference
        .set(
            ALL_SUPPORTED_TYPES_OBJECT,
            SetOptions.mergeFieldPaths(Arrays.asList(FieldPath.of("foo"))))
        .get();

    CommitRequest expectedCommit = commit(set(SINGLE_FIELD_PROTO, Arrays.asList("foo")));

    for (int i = 0; i < 5; ++i) {
      assertCommitEquals(expectedCommit, commitCapture.getAllValues().get(i));
    }
  }

  @Test
  public void setDocumentWithEmptyMerge() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.set(map(), SetOptions.merge()).get();

    assertCommitEquals(
        commit(set(Collections.<String, Value>emptyMap(), Collections.<String>emptyList())),
        commitCapture.getValue());
  }

  @Test
  public void setDocumentWithNestedMerge() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.set(NESTED_CLASS_OBJECT, SetOptions.mergeFields("first.foo")).get();
    documentReference
        .set(NESTED_CLASS_OBJECT, SetOptions.mergeFields(Arrays.asList("first.foo")))
        .get();
    documentReference
        .set(
            NESTED_CLASS_OBJECT,
            SetOptions.mergeFieldPaths(Arrays.asList(FieldPath.of("first", "foo"))))
        .get();

    Map<String, Value> nestedUpdate = new HashMap<>();
    Value.Builder nestedProto = Value.newBuilder();
    nestedProto.getMapValueBuilder().putAllFields(SINGLE_FIELD_PROTO);
    nestedUpdate.put("first", nestedProto.build());

    CommitRequest expectedCommit = commit(set(nestedUpdate, Arrays.asList("first.foo")));

    for (int i = 0; i < 3; ++i) {
      assertCommitEquals(expectedCommit, commitCapture.getAllValues().get(i));
    }
  }

  @Test
  public void setMultipleFieldsWithMerge() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference
        .set(
            NESTED_CLASS_OBJECT,
            SetOptions.mergeFields("first.foo", "second.foo", "second.trueValue"))
        .get();

    Map<String, Value> nestedUpdate = new HashMap<>();
    Value.Builder nestedProto = Value.newBuilder();
    nestedProto.getMapValueBuilder().putAllFields(SINGLE_FIELD_PROTO);
    nestedUpdate.put("first", nestedProto.build());
    nestedProto
        .getMapValueBuilder()
        .putFields("trueValue", Value.newBuilder().setBooleanValue(true).build());
    nestedUpdate.put("second", nestedProto.build());

    CommitRequest expectedCommit =
        commit(set(nestedUpdate, Arrays.asList("first.foo", "second.foo", "second.trueValue")));

    assertCommitEquals(expectedCommit, commitCapture.getValue());
  }

  @Test
  public void setNestedMapWithMerge() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.set(NESTED_CLASS_OBJECT, SetOptions.mergeFields("first", "second")).get();

    Map<String, Value> nestedUpdate = new HashMap<>();
    Value.Builder nestedProto = Value.newBuilder();
    nestedProto.getMapValueBuilder().putAllFields(SINGLE_FIELD_PROTO);
    nestedUpdate.put("first", nestedProto.build());
    nestedProto.getMapValueBuilder().putAllFields(ALL_SUPPORTED_TYPES_PROTO);
    nestedUpdate.put("second", nestedProto.build());

    CommitRequest expectedCommit = commit(set(nestedUpdate, Arrays.asList("first", "second")));
    assertCommitEquals(expectedCommit, commitCapture.getValue());
  }

  @Test
  public void mergeWithDotsInFieldName() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference
        .set(
            map("a.b.c", map("d.e", "foo", "f.g", "bar")),
            SetOptions.mergeFieldPaths(Arrays.asList(FieldPath.of("a.b.c", "d.e"))))
        .get();

    Map<String, Value> nestedUpdate = new HashMap<>();
    Value.Builder nestedProto = Value.newBuilder();
    nestedProto
        .getMapValueBuilder()
        .putFields("d.e", Value.newBuilder().setStringValue("foo").build());
    nestedUpdate.put("a.b.c", nestedProto.build());

    CommitRequest expectedCommit = commit(set(nestedUpdate, Arrays.asList("`a.b.c`.`d.e`")));
    assertCommitEquals(expectedCommit, commitCapture.getValue());
  }

  @Test
  public void extractFieldMaskFromMerge() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.set(NESTED_CLASS_OBJECT, SetOptions.merge()).get();

    Map<String, Value> nestedUpdate = new HashMap<>();
    Value.Builder nestedProto = Value.newBuilder();
    nestedProto.getMapValueBuilder().putAllFields(SINGLE_FIELD_PROTO);
    nestedUpdate.put("first", nestedProto.build());
    nestedProto.getMapValueBuilder().putAllFields(ALL_SUPPORTED_TYPES_PROTO);
    nestedUpdate.put("second", nestedProto.build());

    List<String> updateMask =
        Arrays.asList(
            "first.foo",
            "second.arrayValue",
            "second.bytesValue",
            "second.dateValue",
            "second.doubleValue",
            "second.falseValue",
            "second.foo",
            "second.geoPointValue",
            "second.infValue",
            "second.longValue",
            "second.nanValue",
            "second.negInfValue",
            "second.nullValue",
            "second.objectValue.foo",
            "second.timestampValue",
            "second.trueValue");

    CommitRequest expectedCommit = commit(set(nestedUpdate, updateMask));
    assertCommitEquals(expectedCommit, commitCapture.getValue());
  }

  @Test
  public void updateDocument() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.update(SINGLE_FIELD_MAP);
    documentReference.update("foo", "bar").get();

    CommitRequest expectedCommit =
        commit(update(SINGLE_FIELD_PROTO, Collections.singletonList("foo")));

    for (CommitRequest request : commitCapture.getAllValues()) {
      assertCommitEquals(expectedCommit, request);
    }
  }

  @Test
  public void updateWithDotsInFieldName() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.update(map("a.b.c", (Object) map("d.e", "foo"))).get();

    Map<String, Value> nestedUpdate = new HashMap<>();
    Value.Builder valueProto = Value.newBuilder();
    valueProto
        .getMapValueBuilder()
        .putFields("d.e", Value.newBuilder().setStringValue("foo").build());
    Value.Builder cProto = Value.newBuilder();
    cProto.getMapValueBuilder().putFields("c", valueProto.build());
    Value.Builder bProto = Value.newBuilder();
    bProto.getMapValueBuilder().putFields("b", cProto.build());
    nestedUpdate.put("a", bProto.build());

    CommitRequest expectedCommit = commit(update(nestedUpdate, Arrays.asList("a.b.c")));
    assertCommitEquals(expectedCommit, commitCapture.getValue());
  }

  @Test
  public void updateNestedMap() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.update("a.b", "foo", "a.c", FieldValue.delete()).get();

    Map<String, Value> nestedUpdate = new HashMap<>();
    Value.Builder valueProto = Value.newBuilder();
    valueProto
        .getMapValueBuilder()
        .putFields("b", Value.newBuilder().setStringValue("foo").build());
    nestedUpdate.put("a", valueProto.build());

    CommitRequest expectedCommit = commit(update(nestedUpdate, Arrays.asList("a.b", "a.c")));
    assertCommitEquals(expectedCommit, commitCapture.getValue());
  }

  @Test
  public void updateConflictingFields() throws Exception {
    try {
      documentReference.update("a.b", "foo", "a", "foo").get();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Detected ambiguous definition for field 'a'.");
    }

    try {
      documentReference.update("a.b", "foo", "a.b.c", "foo").get();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Detected ambiguous definition for field 'a.b'.");
    }

    try {
      documentReference.update("a.b", SINGLE_FIELD_MAP, "a", SINGLE_FIELD_MAP).get();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Detected ambiguous definition for field 'a'.");
    }

    try {
      documentReference.update("a.b", SINGLE_FIELD_MAP, "a.b.c", SINGLE_FIELD_MAP).get();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Detected ambiguous definition for field 'a.b'.");
    }
  }

  @Test
  public void deleteField() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.update("foo", "bar", "bar.foo", FieldValue.delete()).get();

    Value.Builder emptyMap = Value.newBuilder();
    emptyMap.getMapValueBuilder();

    Map<String, Value> fieldMap = new HashMap<>();
    fieldMap.put("foo", string("bar"));

    CommitRequest expectedCommit = commit(update(fieldMap, Arrays.asList("foo", "bar.foo")));

    assertCommitEquals(expectedCommit, commitCapture.getValue());
  }

  @Test
  public void updateNestedDocument() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    Map<String, Object> nestedObject = new HashMap<>();
    nestedObject.put("a", "b");
    nestedObject.put("c.d", "e");
    nestedObject.put("f.g.h", "i");

    Map<String, Value> expandedObject = new HashMap<>();
    expandedObject.put("a", string("b"));
    expandedObject.put("c", object("d", string("e")));
    expandedObject.put("f", object("g", object("h", string("i"))));

    documentReference.update(nestedObject).get();

    CommitRequest expectedCommit =
        commit(update(expandedObject, new ArrayList<>(nestedObject.keySet())));
    assertCommitEquals(expectedCommit, commitCapture.getValue());
  }

  @Test
  public void updateDocumentWithTwoFields() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    documentReference.update("a", "b", "c", "d").get();

    CommitRequest expectedCommit =
        commit(
            update(
                map(
                    "a",
                    Value.newBuilder().setStringValue("b").build(),
                    "c",
                    Value.newBuilder().setStringValue("d").build()),
                Arrays.asList("a", "c")));

    assertCommitEquals(expectedCommit, commitCapture.getValue());
  }

  @Test
  public void updateDocumentWithPreconditions() throws Exception {
    doReturn(SINGLE_WRITE_COMMIT_RESPONSE)
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    Precondition options =
        Precondition.updatedAt(Timestamp.ofTimeSecondsAndNanos(479978400, 123000000));

    documentReference.update(SINGLE_FIELD_MAP, options).get();
    documentReference.update(options, "foo", "bar").get();

    com.google.firestore.v1.Precondition.Builder precondition =
        com.google.firestore.v1.Precondition.newBuilder();
    precondition.getUpdateTimeBuilder().setSeconds(479978400).setNanos(123000000);

    CommitRequest expectedCommit =
        commit(update(SINGLE_FIELD_PROTO, Collections.singletonList("foo"), precondition.build()));

    for (CommitRequest request : commitCapture.getAllValues()) {
      assertCommitEquals(expectedCommit, request);
    }
  }
}
