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

package com.google.cloud.firestore;

import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_FIELD_PROTO;
import static com.google.cloud.firestore.LocalFirestoreHelper.getAllResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.listCollectionIdsResponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;

import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.firestore.spi.v1beta1.FirestoreRpc;
import com.google.firestore.v1beta1.BatchGetDocumentsRequest;
import com.google.firestore.v1beta1.ListCollectionIdsRequest;
import com.google.protobuf.Message;
import java.util.List;
import java.util.concurrent.ExecutionException;
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
  public void getCollections() throws ExecutionException, InterruptedException {
    doReturn(listCollectionIdsResponse("first", "second"))
        .when(firestoreMock)
        .sendRequest(
            listCollectionIdsCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    List<CollectionReference> collections = firestoreMock.getCollections().get();
    assertEquals("first", collections.get(0).getId());
    assertEquals("second", collections.get(1).getId());
  }
}
