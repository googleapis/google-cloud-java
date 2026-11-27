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

import static com.google.cloud.firestore.LocalFirestoreHelper.UPDATED_SINGLE_FIELD_PROTO;
import static com.google.cloud.firestore.LocalFirestoreHelper.UPDATE_SINGLE_FIELD_OBJECT;
import static com.google.cloud.firestore.LocalFirestoreHelper.commit;
import static com.google.cloud.firestore.LocalFirestoreHelper.commitResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.create;
import static com.google.cloud.firestore.LocalFirestoreHelper.delete;
import static com.google.cloud.firestore.LocalFirestoreHelper.map;
import static com.google.cloud.firestore.LocalFirestoreHelper.set;
import static com.google.cloud.firestore.LocalFirestoreHelper.update;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doReturn;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import com.google.firestore.v1.BatchWriteRequest;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.FirestoreGrpc;
import com.google.firestore.v1.Write;
import com.google.protobuf.ByteString;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WriteBatchTest {

  @Spy
  private final FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder().setProjectId("test-project").build(),
          Mockito.mock(FirestoreRpc.class));

  @Captor private ArgumentCaptor<CommitRequest> commitCapture;
  @Captor private ArgumentCaptor<BatchWriteRequest> batchWriteCapture;

  private WriteBatch batch;
  private DocumentReference documentReference;

  @Before
  public void before() {
    batch = firestoreMock.batch();
    documentReference = firestoreMock.document("coll/doc");
  }

  @Test
  public void updateDocument() throws Exception {
    doReturn(commitResponse(4, 0))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(),
            ArgumentMatchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    List<com.google.firestore.v1.Precondition> preconditions =
        Arrays.asList(
            com.google.firestore.v1.Precondition.newBuilder().setExists(true).build(),
            com.google.firestore.v1.Precondition.newBuilder().setExists(true).build(),
            com.google.firestore.v1.Precondition.newBuilder()
                .setUpdateTime(com.google.protobuf.Timestamp.getDefaultInstance())
                .build(),
            com.google.firestore.v1.Precondition.newBuilder()
                .setUpdateTime(com.google.protobuf.Timestamp.getDefaultInstance())
                .build());

    Precondition updateTime = Precondition.updatedAt(Timestamp.ofTimeSecondsAndNanos(0, 0));

    batch.update(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    batch.update(documentReference, "foo", "bar");
    batch.update(documentReference, updateTime, "foo", "bar");
    batch.update(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP, updateTime);

    assertEquals(4, batch.getMutationsSize());

    List<WriteResult> writeResults = batch.commit().get();
    List<Write> writes = new ArrayList<>();

    for (int i = 0; i < writeResults.size(); ++i) {
      assertEquals(Timestamp.ofTimeSecondsAndNanos(i, i), writeResults.get(i).getUpdateTime());
      writes.add(
          update(
              LocalFirestoreHelper.SINGLE_FIELD_PROTO,
              Collections.singletonList("foo"),
              preconditions.get(i)));
    }

    CommitRequest commitRequest = commitCapture.getValue();
    assertEquals(commit(writes.toArray(new Write[] {})), commitRequest);
  }

  @Test
  public void updateDocumentWithPOJO() throws Exception {
    doReturn(commitResponse(1, 0))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(),
            ArgumentMatchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    batch.update(documentReference, "foo", UPDATE_SINGLE_FIELD_OBJECT);
    assertEquals(1, batch.getMutationsSize());

    List<WriteResult> writeResults = batch.commit().get();
    assertEquals(1, writeResults.size());

    CommitRequest actual = commitCapture.getValue();
    CommitRequest expected =
        commit(update(UPDATED_SINGLE_FIELD_PROTO, Collections.singletonList("foo")));
    assertEquals(expected, actual);
  }

  @Test
  public void setDocument() throws Exception {
    doReturn(commitResponse(4, 0))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(),
            ArgumentMatchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

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

    assertEquals(4, batch.getMutationsSize());

    List<WriteResult> writeResults = batch.commit().get();
    for (int i = 0; i < writeResults.size(); ++i) {
      assertEquals(Timestamp.ofTimeSecondsAndNanos(i, i), writeResults.get(i).getUpdateTime());
    }

    CommitRequest commitRequest = commitCapture.getValue();
    assertEquals(commit(writes.toArray(new Write[] {})), commitRequest);
  }

  @Test
  public void setDocumentWithValue() throws Exception {
    doReturn(commitResponse(4, 0))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(),
            ArgumentMatchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    batch
        .set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_PROTO)
        .set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_OBJECT)
        .set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_PROTO, SetOptions.merge())
        .set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_OBJECT, SetOptions.merge());

    List<Write> writes = new ArrayList<>();
    writes.add(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO));
    writes.add(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO));
    writes.add(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, Arrays.asList("foo")));
    writes.add(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, Arrays.asList("foo")));

    assertEquals(4, batch.getMutationsSize());

    List<WriteResult> writeResults = batch.commit().get();
    for (int i = 0; i < writeResults.size(); ++i) {
      assertEquals(Timestamp.ofTimeSecondsAndNanos(i, i), writeResults.get(i).getUpdateTime());
    }

    CommitRequest commitRequest = commitCapture.getValue();
    assertEquals(commit(writes.toArray(new Write[] {})), commitRequest);
  }

  @Test
  public void setDocumentWithFloat() throws Exception {
    doReturn(commitResponse(1, 0))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(),
            ArgumentMatchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    batch.set(documentReference, LocalFirestoreHelper.SINGLE_FLOAT_MAP);

    List<Write> writes = new ArrayList<>();
    writes.add(set(LocalFirestoreHelper.SINGLE_FLOAT_PROTO));

    assertEquals(1, batch.getMutationsSize());

    List<WriteResult> writeResults = batch.commit().get();
    for (int i = 0; i < writeResults.size(); ++i) {
      assertEquals(Timestamp.ofTimeSecondsAndNanos(i, i), writeResults.get(i).getUpdateTime());
    }

    CommitRequest commitRequest = commitCapture.getValue();
    assertEquals(commit(writes.toArray(new Write[] {})), commitRequest);
  }

  @Test
  public void omitWriteResultForDocumentTransforms() throws Exception {
    doReturn(commitResponse(1, 0))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(),
            ArgumentMatchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    batch.set(documentReference, map("time", FieldValue.serverTimestamp()));

    assertEquals(1, batch.getMutationsSize());

    List<WriteResult> writeResults = batch.commit().get();
    assertEquals(1, writeResults.size());
  }

  @Test
  public void createDocument() throws Exception {
    doReturn(commitResponse(2, 0))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(),
            ArgumentMatchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    batch
        .create(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP)
        .create(documentReference, LocalFirestoreHelper.SINGLE_FIELD_OBJECT);

    assertEquals(2, batch.getMutationsSize());

    List<WriteResult> writeResults = batch.commit().get();
    List<Write> writes = new ArrayList<>();

    for (int i = 0; i < writeResults.size(); ++i) {
      assertEquals(Timestamp.ofTimeSecondsAndNanos(i, i), writeResults.get(i).getUpdateTime());
      writes.add(create(LocalFirestoreHelper.SINGLE_FIELD_PROTO));
    }

    CommitRequest commitRequest = commitCapture.getValue();
    assertEquals(commit(writes.toArray(new Write[] {})), commitRequest);
  }

  @Test
  public void createDocumentWithValue() throws Exception {
    doReturn(commitResponse(2, 0))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(),
            ArgumentMatchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    batch
        .create(documentReference, LocalFirestoreHelper.SINGLE_FIELD_PROTO)
        .create(documentReference, LocalFirestoreHelper.SINGLE_FIELD_OBJECT);

    assertEquals(2, batch.getMutationsSize());

    List<WriteResult> writeResults = batch.commit().get();
    List<Write> writes = new ArrayList<>();

    for (int i = 0; i < writeResults.size(); ++i) {
      assertEquals(Timestamp.ofTimeSecondsAndNanos(i, i), writeResults.get(i).getUpdateTime());
      writes.add(create(LocalFirestoreHelper.SINGLE_FIELD_PROTO));
    }

    CommitRequest commitRequest = commitCapture.getValue();
    assertEquals(commit(writes.toArray(new Write[] {})), commitRequest);
  }

  @Test
  public void createDocumentWithFloat() throws Exception {
    doReturn(commitResponse(1, 0))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(),
            ArgumentMatchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    batch.create(documentReference, LocalFirestoreHelper.SINGLE_FLOAT_MAP);

    assertEquals(1, batch.getMutationsSize());

    List<WriteResult> writeResults = batch.commit().get();
    List<Write> writes = new ArrayList<>();

    for (int i = 0; i < writeResults.size(); ++i) {
      assertEquals(Timestamp.ofTimeSecondsAndNanos(i, i), writeResults.get(i).getUpdateTime());
      writes.add(create(LocalFirestoreHelper.SINGLE_FLOAT_PROTO));
    }

    CommitRequest commitRequest = commitCapture.getValue();
    assertEquals(commit(writes.toArray(new Write[] {})), commitRequest);
  }

  @Test
  public void deleteDocument() throws Exception {
    doReturn(commitResponse(2, 0))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(),
            ArgumentMatchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    List<Write> writes = new ArrayList<>();
    batch.delete(documentReference);
    writes.add(delete());

    batch.delete(documentReference, Precondition.updatedAt(Timestamp.ofTimeSecondsAndNanos(1, 2)));
    com.google.firestore.v1.Precondition.Builder precondition =
        com.google.firestore.v1.Precondition.newBuilder();
    precondition.getUpdateTimeBuilder().setSeconds(1).setNanos(2);
    writes.add(delete(precondition.build()));

    assertEquals(2, batch.getMutationsSize());

    List<WriteResult> writeResults = batch.commit().get();

    for (int i = 0; i < writeResults.size(); ++i) {
      assertEquals(Timestamp.ofTimeSecondsAndNanos(i, i), writeResults.get(i).getUpdateTime());
    }

    CommitRequest commitRequest = commitCapture.getValue();
    assertEquals(commit(writes.toArray(new Write[] {})), commitRequest);
  }

  @Test
  public void throwsWhenModifyingACommittedWriteBatch() throws Exception {
    doReturn(commitResponse(0, 0))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(),
            ArgumentMatchers.<UnaryCallable<CommitRequest, CommitResponse>>any());

    String expectedErrorMessage = "Cannot modify a WriteBatch that has already been committed.";

    DocumentReference docRef = firestoreMock.collection("foo").document("bar");

    // Commit a batch.
    WriteBatch batch = firestoreMock.batch();
    batch.commit().get();

    // Then run other operations in the same batch.
    LocalFirestoreHelper.assertException(
        () -> {
          batch.set(docRef, map("foo", "bar"));
        },
        expectedErrorMessage);
    LocalFirestoreHelper.assertException(
        () -> {
          batch.update(docRef, map("foo", "bar"));
        },
        expectedErrorMessage);
    LocalFirestoreHelper.assertException(
        () -> {
          batch.create(docRef, map("foo", "bar"));
        },
        expectedErrorMessage);
    LocalFirestoreHelper.assertException(
        () -> {
          batch.delete(docRef);
        },
        expectedErrorMessage);
  }

  private CommitRequest captureCommitRequest(Runnable commitAction) {
    doReturn(commitResponse(10, 0))
        .when(firestoreMock)
        .sendRequest(
            commitCapture.capture(),
            ArgumentMatchers.<UnaryCallable<CommitRequest, CommitResponse>>any());
    commitAction.run();
    return commitCapture.getValue();
  }

  @Test
  public void isIdempotentClassification() {
    // 0. Compile-time enforced FieldValue.isIdempotent() and DocumentTransform.isIdempotent()
    assertTrue(FieldValue.delete().isIdempotent());
    assertTrue(FieldValue.serverTimestamp().isIdempotent());
    assertTrue(FieldValue.arrayUnion("a").isIdempotent());
    assertTrue(FieldValue.arrayRemove("a").isIdempotent());
    assertTrue(FieldValue.minimum(1).isIdempotent());
    assertTrue(FieldValue.minimum(1.0).isIdempotent());
    assertTrue(FieldValue.maximum(1).isIdempotent());
    assertTrue(FieldValue.maximum(1.0).isIdempotent());
    assertFalse(FieldValue.increment(1).isIdempotent());
    assertFalse(FieldValue.increment(1.0).isIdempotent());

    assertTrue(
        DocumentTransform.fromFieldPathMap(
                map(
                    FieldPath.of("del"),
                    FieldValue.delete(),
                    FieldPath.of("ts"),
                    FieldValue.serverTimestamp(),
                    FieldPath.of("nested"),
                    map(
                        "union",
                        FieldValue.arrayUnion("a"),
                        "remove",
                        FieldValue.arrayRemove("b"),
                        "min",
                        FieldValue.minimum(1),
                        "max",
                        FieldValue.maximum(10))))
            .isIdempotent());
    assertFalse(
        DocumentTransform.fromFieldPathMap(map(FieldPath.of("inc"), FieldValue.increment(1)))
            .isIdempotent());
    assertFalse(
        DocumentTransform.fromFieldPathMap(
                map(FieldPath.of("nested"), map("inc", FieldValue.increment(1))))
            .isIdempotent());

    // Fail-closed FieldTransform check when TransformTypeCase is unset/unknown
    assertFalse(
        UpdateBuilder.isIdempotent(
            Write.newBuilder()
                .addUpdateTransforms(
                    com.google.firestore.v1.DocumentTransform.FieldTransform.getDefaultInstance())
                .build()));

    // 1. Idempotent single-document and batch writes -> true
    assertTrue(
        UpdateBuilder.isIdempotentCommit(
            captureCommitRequest(
                () -> documentReference.set(LocalFirestoreHelper.SINGLE_FIELD_MAP))));

    assertTrue(
        UpdateBuilder.isIdempotentCommit(
            captureCommitRequest(
                () ->
                    documentReference.set(
                        LocalFirestoreHelper.SINGLE_FIELD_MAP, SetOptions.merge()))));

    assertTrue(
        UpdateBuilder.isIdempotentCommit(
            captureCommitRequest(
                () ->
                    documentReference.update(
                        map(
                            "plain",
                            "value",
                            "deleted",
                            FieldValue.delete(),
                            "serverTime",
                            FieldValue.serverTimestamp(),
                            "union",
                            FieldValue.arrayUnion("a", "b"),
                            "remove",
                            FieldValue.arrayRemove("c"),
                            "min",
                            FieldValue.minimum(10),
                            "max",
                            FieldValue.maximum(20))))));

    assertTrue(
        UpdateBuilder.isIdempotentCommit(captureCommitRequest(() -> documentReference.delete())));

    assertTrue(
        UpdateBuilder.isIdempotentCommit(
            captureCommitRequest(
                () ->
                    firestoreMock
                        .batch()
                        .set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP)
                        .set(
                            firestoreMock.document("coll/doc2"),
                            LocalFirestoreHelper.SINGLE_FIELD_MAP,
                            SetOptions.merge())
                        .update(
                            firestoreMock.document("coll/doc3"),
                            map("foo", "bar", "arr", FieldValue.arrayUnion("x")))
                        .delete(firestoreMock.document("coll/doc4"))
                        .commit())));

    // 2. Non-idempotent writes -> false
    assertFalse(
        UpdateBuilder.isIdempotentCommit(
            captureCommitRequest(
                () -> documentReference.create(LocalFirestoreHelper.SINGLE_FIELD_MAP))));

    assertFalse(
        UpdateBuilder.isIdempotentCommit(
            captureCommitRequest(
                () -> documentReference.update(map("count", FieldValue.increment(1))))));

    assertFalse(
        UpdateBuilder.isIdempotentCommit(
            captureCommitRequest(
                () ->
                    documentReference.update(
                        map("nested", map("count", FieldValue.increment(1)))))));

    assertFalse(
        UpdateBuilder.isIdempotentCommit(
            captureCommitRequest(
                () -> documentReference.set(map("count", FieldValue.increment(1))))));

    Precondition updatedAt = Precondition.updatedAt(Timestamp.ofTimeSecondsAndNanos(1, 2));
    assertFalse(
        UpdateBuilder.isIdempotentCommit(
            captureCommitRequest(
                () -> documentReference.update(LocalFirestoreHelper.SINGLE_FIELD_MAP, updatedAt))));

    assertFalse(
        UpdateBuilder.isIdempotentCommit(
            captureCommitRequest(() -> documentReference.delete(Precondition.exists(true)))));

    assertFalse(
        UpdateBuilder.isIdempotentCommit(
            captureCommitRequest(() -> documentReference.delete(updatedAt))));

    assertFalse(
        UpdateBuilder.isIdempotentCommit(
            captureCommitRequest(
                () ->
                    firestoreMock
                        .batch()
                        .set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP)
                        .create(
                            firestoreMock.document("coll/doc2"),
                            LocalFirestoreHelper.SINGLE_FIELD_MAP)
                        .commit())));

    assertFalse(
        UpdateBuilder.isIdempotentCommit(
            captureCommitRequest(
                () ->
                    firestoreMock
                        .batch()
                        .set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP)
                        .update(
                            firestoreMock.document("coll/doc2"),
                            map("count", FieldValue.increment(1)))
                        .commit())));

    CommitRequest transactionalCommit =
        captureCommitRequest(() -> documentReference.set(LocalFirestoreHelper.SINGLE_FIELD_MAP))
            .toBuilder()
            .setTransaction(ByteString.copyFromUtf8("txn-1"))
            .build();
    assertFalse(UpdateBuilder.isIdempotentCommit(transactionalCommit));

    // 3. UpdateBuilder.isIdempotentBatch() tracks WriteOperation idempotency via DocumentTransform
    WriteBatch idempotentBatch =
        firestoreMock
            .batch()
            .set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP)
            .update(
                firestoreMock.document("coll/doc2"),
                map(
                    "ts",
                    FieldValue.serverTimestamp(),
                    "union",
                    FieldValue.arrayUnion("a"),
                    "remove",
                    FieldValue.arrayRemove("b"),
                    "min",
                    FieldValue.minimum(1),
                    "max",
                    FieldValue.maximum(2)));
    assertTrue(idempotentBatch.isIdempotentBatch());

    WriteBatch nonIdempotentBatch =
        firestoreMock
            .batch()
            .set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP)
            .update(firestoreMock.document("coll/doc2"), map("inc", FieldValue.increment(1)));
    assertFalse(nonIdempotentBatch.isIdempotentBatch());
  }

  @Test
  public void retriesIdempotentAndDoesNotRetryNonIdempotentCommitsOnDeadlineExceeded()
      throws Exception {
    AtomicInteger commitAttempts = new AtomicInteger();
    FirestoreGrpc.FirestoreImplBase service =
        new FirestoreGrpc.FirestoreImplBase() {
          @Override
          public void commit(
              CommitRequest request, StreamObserver<CommitResponse> responseObserver) {
            int attempt = commitAttempts.incrementAndGet();
            if (attempt == 1) {
              responseObserver.onError(
                  Status.DEADLINE_EXCEEDED
                      .withDescription("Simulated channel blackhole timeout")
                      .asRuntimeException());
              return;
            }
            CommitResponse.Builder responseBuilder =
                CommitResponse.newBuilder()
                    .setCommitTime(
                        com.google.protobuf.Timestamp.newBuilder().setSeconds(100).build());
            for (int i = 0; i < request.getWritesCount(); i++) {
              responseBuilder.addWriteResults(
                  com.google.firestore.v1.WriteResult.newBuilder()
                      .setUpdateTime(
                          com.google.protobuf.Timestamp.newBuilder().setSeconds(100 + i).build())
                      .build());
            }
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
          }
        };

    Server server = ServerBuilder.forPort(0).addService(service).build().start();
    Firestore firestore =
        FirestoreOptions.newBuilder()
            .setProjectId("test-project")
            .setEmulatorHost("localhost:" + server.getPort())
            .setRetrySettings(
                RetrySettings.newBuilder()
                    .setInitialRetryDelayDuration(Duration.ofMillis(1))
                    .setRetryDelayMultiplier(1.0)
                    .setMaxRetryDelayDuration(Duration.ofMillis(5))
                    .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
                    .setMaxRpcTimeoutDuration(Duration.ofSeconds(5))
                    .setTotalTimeoutDuration(Duration.ofSeconds(10))
                    .setMaxAttempts(5)
                    .build())
            .build()
            .getService();

    try {
      DocumentReference docRef = firestore.document("coll/doc");

      // 1. Idempotent writes retry on DEADLINE_EXCEEDED and succeed on Attempt #2
      commitAttempts.set(0);
      docRef.set(LocalFirestoreHelper.SINGLE_FIELD_MAP).get();
      assertEquals(2, commitAttempts.get());

      commitAttempts.set(0);
      docRef.set(LocalFirestoreHelper.SINGLE_FIELD_MAP, SetOptions.merge()).get();
      assertEquals(2, commitAttempts.get());

      commitAttempts.set(0);
      docRef
          .update(
              map(
                  "foo",
                  "bar",
                  "arr",
                  FieldValue.arrayUnion("a"),
                  "min",
                  FieldValue.minimum(1),
                  "max",
                  FieldValue.maximum(10)))
          .get();
      assertEquals(2, commitAttempts.get());

      commitAttempts.set(0);
      docRef.delete().get();
      assertEquals(2, commitAttempts.get());

      commitAttempts.set(0);
      firestore
          .batch()
          .set(docRef, LocalFirestoreHelper.SINGLE_FIELD_MAP)
          .update(firestore.document("coll/doc2"), map("foo", "bar"))
          .delete(firestore.document("coll/doc3"))
          .commit()
          .get();
      assertEquals(2, commitAttempts.get());

      // 2. Non-idempotent writes do NOT retry on DEADLINE_EXCEEDED and fail after Attempt #1
      assertFailsOnFirstDeadlineExceeded(
          commitAttempts, () -> docRef.create(LocalFirestoreHelper.SINGLE_FIELD_MAP).get());

      assertFailsOnFirstDeadlineExceeded(
          commitAttempts, () -> docRef.update(map("count", FieldValue.increment(1))).get());

      assertFailsOnFirstDeadlineExceeded(
          commitAttempts,
          () ->
              docRef
                  .update(
                      LocalFirestoreHelper.SINGLE_FIELD_MAP,
                      Precondition.updatedAt(Timestamp.ofTimeSecondsAndNanos(1, 0)))
                  .get());

      assertFailsOnFirstDeadlineExceeded(
          commitAttempts, () -> docRef.delete(Precondition.exists(true)).get());

      assertFailsOnFirstDeadlineExceeded(
          commitAttempts,
          () ->
              firestore
                  .batch()
                  .set(docRef, LocalFirestoreHelper.SINGLE_FIELD_MAP)
                  .update(firestore.document("coll/doc2"), map("count", FieldValue.increment(1)))
                  .commit()
                  .get());
    } finally {
      firestore.close();
      server.shutdownNow();
    }
  }

  private interface ThrowingRunnable {
    void run() throws Exception;
  }

  private static void assertFailsOnFirstDeadlineExceeded(
      AtomicInteger commitAttempts, ThrowingRunnable action) throws Exception {
    commitAttempts.set(0);
    try {
      action.run();
      fail("Expected ExecutionException caused by DeadlineExceededException");
    } catch (ExecutionException expected) {
      assertTrue(
          "Expected DeadlineExceededException cause, got: " + expected.getCause(),
          expected.getCause() instanceof DeadlineExceededException
              || (expected.getCause() != null
                  && expected.getCause().getCause() instanceof DeadlineExceededException));
      assertEquals(1, commitAttempts.get());
    }
  }
}
