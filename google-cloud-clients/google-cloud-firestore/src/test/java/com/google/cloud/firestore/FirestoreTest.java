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

import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_FIELD_PROTO;
import static com.google.cloud.firestore.LocalFirestoreHelper.getAllResponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doAnswer;

import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.cloud.firestore.spi.v1beta1.FirestoreRpc;
import com.google.firestore.v1beta1.BatchGetDocumentsRequest;
import com.google.firestore.v1beta1.ListCollectionIdsRequest;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FirestoreTest {

  @Spy
  private FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder().setProjectId("test-project").build(),
          Mockito.mock(FirestoreRpc.class));

  @Captor private ArgumentCaptor<BatchGetDocumentsRequest> getAllCapture;

  @Captor private ArgumentCaptor<ListCollectionIdsRequest> listCollectionIdsCapture;

  @Captor private ArgumentCaptor<ApiStreamObserver> streamObserverCapture;

  @Test
  public void encodeFieldPath() {
    assertEquals("foo", FieldPath.of("foo").getEncodedPath());
    assertEquals("foo.bar", FieldPath.of("foo", "bar").getEncodedPath());
    assertEquals("`.`", FieldPath.of(".").getEncodedPath());
    assertEquals("`\\``", FieldPath.of("`").getEncodedPath());
    assertEquals("foo.`.`.`\\\\`", FieldPath.of("foo", ".", "\\").getEncodedPath());
    assertEquals("`.\\\\.\\\\.`", FieldPath.of(".\\.\\.").getEncodedPath());
  }

  @Test
  public void illegalFieldPath() throws Exception {
    doAnswer(getAllResponse(SINGLE_FIELD_PROTO))
        .when(firestoreMock)
        .streamRequest(
            getAllCapture.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    DocumentReference doc = firestoreMock.document("coll/doc");
    DocumentSnapshot snapshot = doc.get().get();

    char[] prohibited = new char[] {'*', '~', '/', '[', ']'};

    for (char c : prohibited) {
      try {
        snapshot.contains("foo" + c + "bar");
        fail();
      } catch (IllegalArgumentException e) {
        assertEquals("Use FieldPath.of() for field names containing '˜*/[]'.", e.getMessage());
      }
    }
  }

  @Test
  public void exposesOptions() {
    assertEquals("test-project", firestoreMock.getOptions().getProjectId());
  }

  @Test
  public void getAll() throws Exception {
    doAnswer(
            getAllResponse(
                SINGLE_FIELD_PROTO, SINGLE_FIELD_PROTO, SINGLE_FIELD_PROTO, SINGLE_FIELD_PROTO))
        .when(firestoreMock)
        .streamRequest(
            getAllCapture.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    DocumentReference doc1 = firestoreMock.document("coll/doc1");
    DocumentReference doc2 = firestoreMock.document("coll/doc2");
    DocumentReference doc3 = firestoreMock.document("coll/doc3");
    DocumentReference doc4 = firestoreMock.document("coll/doc4");
    List<DocumentSnapshot> snapshot = firestoreMock.getAll(doc1, doc2, doc4, doc3).get();
    assertEquals("doc1", snapshot.get(0).getId());
    assertEquals("doc2", snapshot.get(1).getId());
    // Note that we sort based on the order in the getAll() call.
    assertEquals("doc4", snapshot.get(2).getId());
    assertEquals("doc3", snapshot.get(3).getId());
  }

  @Test
  public void getAllWithFieldMask() throws Exception {
    doAnswer(getAllResponse(SINGLE_FIELD_PROTO))
        .when(firestoreMock)
        .streamRequest(
            getAllCapture.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    DocumentReference doc1 = firestoreMock.document("coll/doc1");
    FieldMask fieldMask = FieldMask.of(FieldPath.of("foo", "bar"));

    firestoreMock.getAll(new DocumentReference[] {doc1}, fieldMask).get();

    BatchGetDocumentsRequest request = getAllCapture.getValue();
    assertEquals(1, request.getMask().getFieldPathsCount());
    assertEquals("foo.bar", request.getMask().getFieldPaths(0));
  }

  @Test
  public void arrayUnionEquals() {
    FieldValue arrayUnion1 = FieldValue.arrayUnion("foo", "bar");
    FieldValue arrayUnion2 = FieldValue.arrayUnion("foo", "bar");
    FieldValue arrayUnion3 = FieldValue.arrayUnion("foo", "baz");
    FieldValue arrayRemove = FieldValue.arrayRemove("foo", "bar");
    assertEquals(arrayUnion1, arrayUnion1);
    assertEquals(arrayUnion1, arrayUnion2);
    assertNotEquals(arrayUnion1, arrayUnion3);
    assertNotEquals(arrayUnion1, arrayRemove);
  }

  @Test
  public void arrayRemoveEquals() {
    FieldValue arrayRemove1 = FieldValue.arrayRemove("foo", "bar");
    FieldValue arrayRemove2 = FieldValue.arrayRemove("foo", "bar");
    FieldValue arrayRemove3 = FieldValue.arrayRemove("foo", "baz");
    FieldValue arrayUnion = FieldValue.arrayUnion("foo", "bar");
    assertEquals(arrayRemove1, arrayRemove1);
    assertEquals(arrayRemove1, arrayRemove2);
    assertNotEquals(arrayRemove1, arrayRemove3);
    assertNotEquals(arrayRemove1, arrayUnion);
  }
}
