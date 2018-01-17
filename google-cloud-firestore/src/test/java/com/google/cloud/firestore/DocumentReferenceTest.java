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
import static com.google.cloud.firestore.LocalFirestoreHelper.GEO_POINT;
import static com.google.cloud.firestore.LocalFirestoreHelper.NESTED_CLASS_OBJECT;
import static com.google.cloud.firestore.LocalFirestoreHelper.SERVER_TIMESTAMP_COMMIT_RESPONSE;
import static com.google.cloud.firestore.LocalFirestoreHelper.SERVER_TIMESTAMP_PROTO;
import static com.google.cloud.firestore.LocalFirestoreHelper.SERVER_TIMESTAMP_TRANSFORM;
import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_DELETE_COMMIT_RESPONSE;
import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_FIELD_MAP;
import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_FIELD_OBJECT;
import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_FIELD_PROTO;
import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_WRITE_COMMIT_RESPONSE;
import static com.google.cloud.firestore.LocalFirestoreHelper.UPDATE_PRECONDITION;
import static com.google.cloud.firestore.LocalFirestoreHelper.assertCommitEquals;
import static com.google.cloud.firestore.LocalFirestoreHelper.commit;
import static com.google.cloud.firestore.LocalFirestoreHelper.create;
import static com.google.cloud.firestore.LocalFirestoreHelper.delete;
import static com.google.cloud.firestore.LocalFirestoreHelper.get;
import static com.google.cloud.firestore.LocalFirestoreHelper.getAllResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.map;
import static com.google.cloud.firestore.LocalFirestoreHelper.object;
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
import com.google.cloud.firestore.spi.v1beta1.FirestoreRpc;
import com.google.common.collect.ImmutableList;
import com.google.firestore.v1beta1.BatchGetDocumentsRequest;
import com.google.firestore.v1beta1.BatchGetDocumentsResponse;
import com.google.firestore.v1beta1.CommitRequest;
import com.google.firestore.v1beta1.CommitResponse;
import com.google.firestore.v1beta1.Value;
import com.google.protobuf.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.threeten.bp.Instant;

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
  public void deserializeBasicTypes() throws Exception {
    doAnswer(getAllResponse(ALL_SUPPORTED_TYPES_PROTO))
        .when(firestoreMock)
        .streamRequest(
            getAllCapture.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

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

    assertEquals(Instant.ofEpochSecond(1, 2), snapshot.getCreateTime());
    assertEquals(Instant.ofEpochSecond(3, 4), snapshot.getUpdateTime());
    assertEquals(Instant.ofEpochSecond(5, 6), snapshot.getReadTime());

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
  public void notFound() throws Exception {
    final BatchGetDocumentsResponse.Builder getDocumentResponse =
        BatchGetDocumentsResponse.newBuilder();
    getDocumentResponse.setMissing(DOCUMENT_NAME);
    getDocumentResponse.setReadTime(Timestamp.newBuilder().setSeconds(5).setNanos(6));

    doAnswer(streamingResponse(getDocumentResponse.build()))
        .when(firestoreMock)
        .streamRequest(
            getAllCapture.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    DocumentSnapshot snapshot = documentReference.get().get();
    assertEquals(documentReference, snapshot.getReference());
    assertFalse(snapshot.exists());
    assertEquals(snapshot.getReadTime(), Instant.ofEpochSecond(5, 6));
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
        .delete(Precondition.updatedAt(Instant.ofEpochSecond(479978400, 123000000)))
        .get();

    List<CommitRequest> commitRequests = commitCapture.getAllValues();
    assertCommitEquals(commit(delete()), commitRequests.get(0));

    com.google.firestore.v1beta1.Precondition.Builder precondition =
        com.google.firestore.v1beta1.Precondition.newBuilder();
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

    CommitRequest create = commit(transform(CREATE_PRECONDITION, "foo", "inner.bar"));

    List<CommitRequest> commitRequests = commitCapture.getAllValues();
    assertCommitEquals(create, commitRequests.get(0));
    assertCommitEquals(create, commitRequests.get(1));
  }

  @Test
  public void setWithServerTimestamp() throws Exception {
    doReturn(SERVER_TIMESTAMP_COMMIT_RESPONSE)
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
    doReturn(SERVER_TIMESTAMP_COMMIT_RESPONSE)
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

    update = commit(transform(UPDATE_PRECONDITION, "foo", "inner.bar"));

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

    CommitRequest set = commit(transform("inner.bar"));

    List<CommitRequest> commitRequests = commitCapture.getAllValues();
    assertCommitEquals(set, commitRequests.get(0));
    assertCommitEquals(set, commitRequests.get(1));
  }

  @Test
  public void serverTimestampInArray() throws Exception {
    Map<String, Object> list = new HashMap<>();
    list.put("foo", ImmutableList.of(FieldValue.serverTimestamp()));

    try {
      documentReference.create(list);
      fail();
    } catch (FirestoreException e) {
      assertTrue(e.getMessage().endsWith("Server timestamps are not supported as Array values."));
    }

    list.clear();
    list.put("a", ImmutableList.of(ImmutableList.of("b", map("c", FieldValue.serverTimestamp()))));

    try {
      documentReference.create(list);
      fail();
    } catch (FirestoreException e) {
      assertTrue(e.getMessage().endsWith("Server timestamps are not supported as Array values."));
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

    Precondition options = Precondition.updatedAt(Instant.ofEpochSecond(479978400, 123000000));

    documentReference.update(SINGLE_FIELD_MAP, options).get();
    documentReference.update(options, "foo", "bar").get();

    com.google.firestore.v1beta1.Precondition.Builder precondition =
        com.google.firestore.v1beta1.Precondition.newBuilder();
    precondition.getUpdateTimeBuilder().setSeconds(479978400).setNanos(123000000);

    CommitRequest expectedCommit =
        commit(update(SINGLE_FIELD_PROTO, Collections.singletonList("foo"), precondition.build()));

    for (CommitRequest request : commitCapture.getAllValues()) {
      assertCommitEquals(expectedCommit, request);
    }
  }
}
