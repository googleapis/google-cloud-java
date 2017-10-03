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

import static com.google.cloud.firestore.LocalFirestoreHelper.commit;
import static com.google.cloud.firestore.LocalFirestoreHelper.commitResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.create;
import static com.google.cloud.firestore.LocalFirestoreHelper.delete;
import static com.google.cloud.firestore.LocalFirestoreHelper.set;
import static com.google.cloud.firestore.LocalFirestoreHelper.update;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.firestore.spi.v1beta1.FirestoreRpc;
import com.google.firestore.v1beta1.CommitRequest;
import com.google.firestore.v1beta1.CommitResponse;
import com.google.firestore.v1beta1.Write;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
public class WriteBatchTest {

  @Spy
  private FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder().setProjectId("test-project").build(),
          Mockito.mock(FirestoreRpc.class));

  @Captor private ArgumentCaptor<CommitRequest> commitCapture;

  private WriteBatch batch;
  private DocumentReference documentReference;

  @Before
  public void before() {
    batch = firestoreMock.batch();
    documentReference = firestoreMock.document("coll/doc");
  }

  @Test
  public void updateDocument() throws Exception {
    doReturn(commitResponse(4))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    batch.update(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    batch.update(
        documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP, Precondition.exists(true));
    batch.update(documentReference, "foo", "bar");
    batch.update(documentReference, Precondition.exists(true), "foo", "bar");

    List<WriteResult> writeResults = batch.commit().get();
    List<Write> writes = new ArrayList<>();

    for (int i = 0; i < writeResults.size(); ++i) {
      assertEquals(Instant.ofEpochSecond(i, i), writeResults.get(i).getUpdateTime());
      writes.add(update(LocalFirestoreHelper.SINGLE_FIELD_PROTO, Collections.singletonList("foo")));
    }

    CommitRequest commitRequest = commitCapture.getValue();
    assertEquals(commit(writes.toArray(new Write[] {})), commitRequest);
  }

  @Test
  public void setDocument() throws Exception {
    doReturn(commitResponse(2))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    batch
        .set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP)
        .set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_OBJECT)
        .set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP, SetOptions.merge())
        .set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_OBJECT, SetOptions.merge());

    List<Write> writes = new ArrayList<>();
    writes.add(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO));
    writes.add(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO));
    writes.add(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, Arrays.asList("foo")));
    writes.add(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, Arrays.asList("foo")));

    List<WriteResult> writeResults = batch.commit().get();
    for (int i = 0; i < writeResults.size(); ++i) {
      assertEquals(Instant.ofEpochSecond(i, i), writeResults.get(i).getUpdateTime());
    }

    CommitRequest commitRequest = commitCapture.getValue();
    assertEquals(commit(writes.toArray(new Write[] {})), commitRequest);
  }

  @Test
  public void createDocument() throws Exception {
    doReturn(commitResponse(2))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    batch
        .create(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP)
        .create(documentReference, LocalFirestoreHelper.SINGLE_FIELD_OBJECT);

    List<WriteResult> writeResults = batch.commit().get();
    List<Write> writes = new ArrayList<>();

    for (int i = 0; i < writeResults.size(); ++i) {
      assertEquals(Instant.ofEpochSecond(i, i), writeResults.get(i).getUpdateTime());
      writes.add(create(LocalFirestoreHelper.SINGLE_FIELD_PROTO));
    }

    CommitRequest commitRequest = commitCapture.getValue();
    assertEquals(commit(writes.toArray(new Write[] {})), commitRequest);
  }

  @Test
  public void deleteDocument() throws Exception {
    doReturn(commitResponse(2))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(), Matchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    List<Write> writes = new ArrayList<>();
    batch.delete(documentReference);
    writes.add(delete());

    batch.delete(documentReference, Precondition.updatedAt(Instant.ofEpochSecond(1, 2)));
    com.google.firestore.v1beta1.Precondition.Builder precondition =
        com.google.firestore.v1beta1.Precondition.newBuilder();
    precondition.getUpdateTimeBuilder().setSeconds(1).setNanos(2);
    writes.add(delete(precondition.build()));

    List<WriteResult> writeResults = batch.commit().get();

    for (int i = 0; i < writeResults.size(); ++i) {
      assertEquals(Instant.ofEpochSecond(i, i), writeResults.get(i).getUpdateTime());
    }

    CommitRequest commitRequest = commitCapture.getValue();
    assertEquals(commit(writes.toArray(new Write[] {})), commitRequest);
  }
}
