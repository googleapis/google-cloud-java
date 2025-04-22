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

import static com.google.api.core.ApiFutures.immediateFailedFuture;
import static com.google.cloud.firestore.LocalFirestoreHelper.IMMEDIATE_RETRY_SETTINGS;
import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_FIELD_PROTO;
import static com.google.cloud.firestore.LocalFirestoreHelper.TRANSACTION_ID;
import static com.google.cloud.firestore.LocalFirestoreHelper.begin;
import static com.google.cloud.firestore.LocalFirestoreHelper.beginResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.commit;
import static com.google.cloud.firestore.LocalFirestoreHelper.commitResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.countQuery;
import static com.google.cloud.firestore.LocalFirestoreHelper.countQueryResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.create;
import static com.google.cloud.firestore.LocalFirestoreHelper.delete;
import static com.google.cloud.firestore.LocalFirestoreHelper.get;
import static com.google.cloud.firestore.LocalFirestoreHelper.getAll;
import static com.google.cloud.firestore.LocalFirestoreHelper.getAllResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.query;
import static com.google.cloud.firestore.LocalFirestoreHelper.queryResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.rollback;
import static com.google.cloud.firestore.LocalFirestoreHelper.rollbackResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.set;
import static com.google.cloud.firestore.LocalFirestoreHelper.update;
import static com.google.cloud.firestore.it.ITQueryTest.map;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.LocalFirestoreHelper.ResponseStubber;
import com.google.cloud.firestore.TransactionOptions.ReadOnlyOptionsBuilder;
import com.google.cloud.firestore.TransactionOptions.ReadWriteOptionsBuilder;
import com.google.cloud.firestore.TransactionOptions.TransactionOptionsType;
import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.Write;
import com.google.protobuf.Message;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class TransactionTest {

  private final ApiFuture<Message> RETRYABLE_API_EXCEPTION =
      immediateFailedFuture(
          new ApiException(
              new Exception("Test exception"), GrpcStatusCode.of(Status.Code.UNKNOWN), true));

  @Spy private final FirestoreRpc firestoreRpc = mock(FirestoreRpc.class);

  @Spy
  private final FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder()
              .setProjectId("test-project")
              .setRetrySettings(IMMEDIATE_RETRY_SETTINGS)
              .build(),
          firestoreRpc);

  @Captor private ArgumentCaptor<Message> requestCapture;
  @Captor private ArgumentCaptor<ResponseObserver<Message>> streamObserverCapture;

  private DocumentReference documentReference;
  private Query queryReference;
  private AggregateQuery aggregateQueryReference;
  private TransactionOptions options;

  @Before
  public void before() {
    doReturn(Executors.newSingleThreadScheduledExecutor()).when(firestoreRpc).getExecutor();

    documentReference = firestoreMock.document("coll/doc");
    queryReference = firestoreMock.collection("coll");
    aggregateQueryReference = queryReference.count();
    options =
        TransactionOptions.create(
            Executors.newSingleThreadExecutor(
                runnable -> {
                  Thread thread = new Thread(runnable);
                  thread.setName("user_provided");
                  return thread;
                }));
  }

  @Test
  public void returnsValue() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(0, 0))
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            t -> {
              assertEquals("user_provided", Thread.currentThread().getName());
              return "foo";
            },
            options);

    assertEquals("foo", transaction.get());

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(2, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(commit(TRANSACTION_ID), requests.get(1));
  }

  @Test
  public void returnsValueAsync() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(0, 0))
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runAsyncTransaction(
            t -> {
              assertEquals("user_provided", Thread.currentThread().getName());
              return ApiFutures.immediateFuture("foo");
            },
            options);

    assertEquals("foo", transaction.get());

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(2, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(commit(TRANSACTION_ID), requests.get(1));
  }

  @Test
  public void canReturnNull() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(0, 0))
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction = firestoreMock.runTransaction(transaction1 -> null, options);

    assertNull(transaction.get());
  }

  @Test
  public void canReturnNullAsync() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(0, 0))
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runAsyncTransaction(t -> ApiFutures.immediateFuture(null), options);

    assertNull(transaction.get());
  }

  @Test
  public void rollbackOnCallbackError() {
    doReturn(beginResponse())
        .doReturn(rollbackResponse())
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            t -> {
              throw new Exception("Expected exception");
            },
            options);

    try {
      transaction.get();
      fail();
    } catch (Exception e) {
      assertTrue(e.getMessage().endsWith("Expected exception"));
    }

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(2, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(rollback(), requests.get(1));
  }

  @Test
  public void rollbackOnCallbackApiFutureErrorAsync() {
    doReturn(beginResponse())
        .doReturn(rollbackResponse())
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runAsyncTransaction(
            t -> immediateFailedFuture(new Exception("Expected exception")), options);

    try {
      transaction.get();
      fail();
    } catch (Exception e) {
      assertTrue(e.getMessage().endsWith("Expected exception"));
    }

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(2, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(rollback(), requests.get(1));
  }

  @Test
  public void noRollbackOnBeginFailure() {
    doReturn(immediateFailedFuture(new Exception("Expected exception")))
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            t -> {
              fail();
              return null;
            },
            options);

    try {
      transaction.get();
      fail();
    } catch (Exception e) {
      assertTrue(e.getMessage().endsWith("Expected exception"));
    }

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(1, requests.size());
  }

  @Test
  public void noRollbackOnBeginFailureAsync() {
    doReturn(immediateFailedFuture(new Exception("Expected exception")))
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runAsyncTransaction(
            t -> {
              fail();
              return null;
            },
            options);

    try {
      transaction.get();
      fail();
    } catch (Exception e) {
      assertTrue(e.getMessage().endsWith("Expected exception"));
    }

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(1, requests.size());
  }

  @Test
  public void noRollbackOnThrownExceptionAsync() {
    doReturn(beginResponse())
        .doReturn(rollbackResponse())
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runAsyncTransaction(
            t -> {
              throw new RuntimeException("User exception");
            },
            options);

    try {
      transaction.get();
      fail();
    } catch (Exception e) {
      assertTrue(e.getMessage().endsWith("User exception"));
    }
  }

  @Test
  public void limitsRetriesWithFailure() {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(begin(), beginResponse("foo1"));
            put(commit("foo1"), RETRYABLE_API_EXCEPTION);
            put(rollback("foo1"), rollbackResponse());
            put(begin("foo1"), beginResponse("foo2"));
            put(commit("foo2"), RETRYABLE_API_EXCEPTION);
            put(rollback("foo2"), rollbackResponse());
            put(begin("foo2"), beginResponse("foo3"));
            put(commit("foo3"), RETRYABLE_API_EXCEPTION);
            put(rollback("foo3"), rollbackResponse());
            put(begin("foo3"), beginResponse("foo4"));
            put(commit("foo4"), RETRYABLE_API_EXCEPTION);
            put(rollback("foo4"), rollbackResponse());
            put(begin("foo4"), beginResponse("foo5"));
            put(commit("foo5"), RETRYABLE_API_EXCEPTION);
            put(rollback("foo5"), rollbackResponse());
          }
        };

    responseStubber.initializeStub(requestCapture, firestoreMock);

    final AtomicInteger retryCount = new AtomicInteger(1);

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            t -> "foo" + retryCount.getAndIncrement(),
            TransactionOptions.create(options.getExecutor(), 5));

    try {
      transaction.get();
      fail();
    } catch (Exception e) {
      assertTrue(e.getMessage().endsWith("Transaction was cancelled because of too many retries."));
    }

    responseStubber.verifyAllRequestsSent();
  }

  @Test
  public void limitsRetriesWithSuccess() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(begin(), beginResponse("foo1"));
            put(commit("foo1"), RETRYABLE_API_EXCEPTION);
            put(rollback("foo1"), rollbackResponse());
            put(begin("foo1"), beginResponse("foo2"));
            put(commit("foo2"), RETRYABLE_API_EXCEPTION);
            put(rollback("foo2"), rollbackResponse());
            put(begin("foo2"), beginResponse("foo3"));
            put(commit("foo3"), RETRYABLE_API_EXCEPTION);
            put(rollback("foo3"), rollbackResponse());
            put(begin("foo3"), beginResponse("foo4"));
            put(commit("foo4"), RETRYABLE_API_EXCEPTION);
            put(rollback("foo4"), rollbackResponse());
            put(begin("foo4"), beginResponse("foo5"));
            put(commit("foo5"), RETRYABLE_API_EXCEPTION);
            put(rollback("foo5"), rollbackResponse());
            put(begin("foo5"), beginResponse("foo6"));
            put(commit("foo6"), commitResponse(0, 0));
          }
        };

    responseStubber.initializeStub(requestCapture, firestoreMock);

    final AtomicInteger retryCount = new AtomicInteger(1);

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            t -> "foo" + retryCount.getAndIncrement(),
            TransactionOptions.create(options.getExecutor(), 6));

    assertEquals("foo6", transaction.get());

    responseStubber.verifyAllRequestsSent();
  }

  private void verifyRetries(
      Function<ApiException, ResponseStubber> expectedSequenceWithRetry,
      Function<ApiException, ResponseStubber> expectedSequenceWithoutRetry)
      throws ExecutionException, InterruptedException {
    ApiException[] exceptionWithRetryBehavior =
        new ApiException[] {
          (exception(Status.Code.CANCELLED, true)),
          (exception(Status.Code.UNKNOWN, true)),
          (exception(Status.Code.INVALID_ARGUMENT, false)),
          (exception(
              Status.Code.INVALID_ARGUMENT,
              "The referenced transaction has expired or is no longer valid.",
              true)),
          (exception(Status.Code.DEADLINE_EXCEEDED, true)),
          (exception(Status.Code.NOT_FOUND, false)),
          (exception(Status.Code.ALREADY_EXISTS, false)),
          (exception(Status.Code.RESOURCE_EXHAUSTED, true)),
          (exception(Status.Code.FAILED_PRECONDITION, false)),
          (exception(Status.Code.ABORTED, true)),
          (exception(Status.Code.OUT_OF_RANGE, false)),
          (exception(Status.Code.UNIMPLEMENTED, false)),
          (exception(Status.Code.INTERNAL, true)),
          (exception(Status.Code.UNAVAILABLE, true)),
          (exception(Status.Code.DATA_LOSS, false)),
          (exception(Status.Code.UNAUTHENTICATED, true))
        };

    for (ApiException apiException : exceptionWithRetryBehavior) {
      if (apiException.isRetryable()) {
        ResponseStubber stubber = expectedSequenceWithRetry.apply(apiException);
        stubber.initializeStub(requestCapture, firestoreMock);

        final int[] attempts = new int[] {0};

        ApiFuture<Void> transaction =
            firestoreMock.runTransaction(
                t -> {
                  ++attempts[0];
                  return null;
                });

        transaction.get();
        stubber.verifyAllRequestsSent();

        assertEquals(2, attempts[0]);
      } else {
        ResponseStubber stubber = expectedSequenceWithoutRetry.apply(apiException);
        stubber.initializeStub(requestCapture, firestoreMock);

        final int[] attempts = new int[] {0};

        ApiFuture<Void> transaction =
            firestoreMock.runTransaction(
                t -> {
                  ++attempts[0];
                  return null;
                });

        try {
          transaction.get();
          fail("Transaction should have failed");
        } catch (Exception ignored) {
        }

        stubber.verifyAllRequestsSent();
        assertEquals(1, attempts[0]);
      }
    }
  }

  @Test
  public void retriesCommitBasedOnErrorCode() throws Exception {
    verifyRetries(
        /* expectedSequenceWithRetry= */ e ->
            new ResponseStubber() {
              {
                put(begin(), beginResponse("foo1"));
                put(commit("foo1"), immediateFailedFuture(e));
                put(rollback("foo1"), rollbackResponse());
                put(begin("foo1"), beginResponse("foo2"));
                put(commit("foo2"), commitResponse(0, 0));
              }
            },
        /* expectedSequenceWithoutRetry= */ e ->
            new ResponseStubber() {
              {
                put(begin(), beginResponse("foo1"));
                put(commit("foo1"), immediateFailedFuture(e));
                put(rollback("foo1"), rollbackResponse());
              }
            });
  }

  @Test
  public void retriesRollbackBasedOnErrorCode() throws Exception {
    final ApiException retryable = exception(Status.Code.ABORTED, true);

    // Regardless of exception thrown by rollback, we should never retry
    // calling rollback. Rollback is best effort, and will sometimes return
    // ABORT error (which a transaction will retry) when transaction no longer
    // exists on Firestore server side. Attempting to retry will in some cases
    // simply exhaust retries with accumulated backoff delay, when a new
    // transaction could simply be started (since the old transaction no longer
    // exists server side).
    verifyRetries(
        /* expectedSequenceWithRetry= */ e -> {
          return new ResponseStubber() {
            {
              put(begin(), beginResponse("foo1"));
              put(commit("foo1"), immediateFailedFuture(e));
              put(rollback("foo1"), immediateFailedFuture(retryable));
              put(begin("foo1"), beginResponse("foo2"));
              put(commit("foo2"), commitResponse(0, 0));
            }
          };
        },
        /* expectedSequenceWithoutRetry= */ e -> {
          return new ResponseStubber() {
            {
              put(begin(), beginResponse("foo1"));
              put(commit("foo1"), immediateFailedFuture(e));
              put(rollback("foo1"), immediateFailedFuture(retryable));
            }
          };
        });
  }

  @Test
  public void getDocument() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(0, 0))
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    doAnswer(getAllResponse(SINGLE_FIELD_PROTO))
        .when(firestoreMock)
        .streamRequest(
            requestCapture.capture(), streamObserverCapture.capture(), ArgumentMatchers.any());

    ApiFuture<DocumentSnapshot> transaction =
        firestoreMock.runTransaction(t -> t.get(documentReference).get(), options);

    assertEquals("doc", transaction.get().getId());

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(3, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(get(TRANSACTION_ID), requests.get(1));
    assertEquals(commit(TRANSACTION_ID), requests.get(2));
  }

  @Test
  public void getDocumentAsync() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(0, 0))
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    doAnswer(getAllResponse(SINGLE_FIELD_PROTO))
        .when(firestoreMock)
        .streamRequest(
            requestCapture.capture(), streamObserverCapture.capture(), ArgumentMatchers.any());

    ApiFuture<DocumentSnapshot> transaction =
        firestoreMock.runAsyncTransaction(t -> t.get(documentReference), options);

    assertEquals("doc", transaction.get().getId());

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(3, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(get(TRANSACTION_ID), requests.get(1));
    assertEquals(commit(TRANSACTION_ID), requests.get(2));
  }

  @Test
  public void getMultipleDocuments() throws Exception {
    final DocumentReference doc1 = firestoreMock.document("coll/doc1");
    final DocumentReference doc2 = firestoreMock.document("coll/doc2");

    doReturn(beginResponse())
        .doReturn(commitResponse(0, 0))
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    doAnswer(getAllResponse(SINGLE_FIELD_PROTO))
        .when(firestoreMock)
        .streamRequest(
            requestCapture.capture(), streamObserverCapture.capture(), ArgumentMatchers.any());

    ApiFuture<List<DocumentSnapshot>> transaction =
        firestoreMock.runTransaction(t -> t.getAll(doc1, doc2).get(), options);

    assertEquals(2, transaction.get().size());

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(3, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(
        getAll(
            TRANSACTION_ID, doc1.getResourcePath().toString(), doc2.getResourcePath().toString()),
        requests.get(1));
    assertEquals(commit(TRANSACTION_ID), requests.get(2));
  }

  @Test
  public void getMultipleDocumentsWithFieldMask() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(0, 0))
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    doAnswer(getAllResponse(SINGLE_FIELD_PROTO))
        .when(firestoreMock)
        .streamRequest(
            requestCapture.capture(),
            streamObserverCapture.capture(),
            ArgumentMatchers.<ServerStreamingCallable>any());

    final DocumentReference doc1 = firestoreMock.document("coll/doc1");
    final FieldMask fieldMask = FieldMask.of(FieldPath.of("foo", "bar"));

    ApiFuture<List<DocumentSnapshot>> transaction =
        firestoreMock.runTransaction(
            t -> t.getAll(new DocumentReference[] {doc1}, fieldMask).get(), options);
    transaction.get();

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(3, requests.size());

    assertEquals(begin(), requests.get(0));
    BatchGetDocumentsRequest expectedGetAll =
        getAll(TRANSACTION_ID, doc1.getResourcePath().toString());
    expectedGetAll =
        expectedGetAll.toBuilder()
            .setMask(DocumentMask.newBuilder().addFieldPaths("foo.bar"))
            .build();
    assertEquals(expectedGetAll, requests.get(1));
    assertEquals(commit(TRANSACTION_ID), requests.get(2));
  }

  @Test
  public void getQuery() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(0, 0))
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            requestCapture.capture(), streamObserverCapture.capture(), ArgumentMatchers.any());

    ApiFuture<QuerySnapshot> transaction =
        firestoreMock.runTransaction(t -> t.get(queryReference).get(), options);

    assertEquals(1, transaction.get().size());

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(3, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(query(TRANSACTION_ID, /* allDescendants= */ false), requests.get(1));
    assertEquals(commit(TRANSACTION_ID), requests.get(2));
  }

  @Test
  public void getAggregateQuery() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(0, 0))
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    doAnswer(countQueryResponse(42))
        .when(firestoreMock)
        .streamRequest(
            requestCapture.capture(), streamObserverCapture.capture(), ArgumentMatchers.any());

    ApiFuture<AggregateQuerySnapshot> transaction =
        firestoreMock.runTransaction(t -> t.get(aggregateQueryReference).get(), options);

    assertEquals(42, transaction.get().getCount());

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(3, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(countQuery(TRANSACTION_ID), requests.get(1));
    assertEquals(commit(TRANSACTION_ID), requests.get(2));
  }

  @Test
  public void updateDocument() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(2, 0))
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            t -> {
              t.update(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP);
              t.update(documentReference, "foo", "bar");
              return "foo";
            },
            options);

    assertEquals("foo", transaction.get());

    List<Write> writes = new ArrayList<>();

    for (int i = 0; i < 2; ++i) {
      writes.add(update(SINGLE_FIELD_PROTO, Collections.singletonList("foo")));
    }

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(2, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(commit(TRANSACTION_ID, writes.toArray(new Write[] {})), requests.get(1));
  }

  @Test
  public void setDocument() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(2, 0))
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            t -> {
              t.set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP)
                  .set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_OBJECT);
              return "foo";
            },
            options);

    assertEquals("foo", transaction.get());

    List<Write> writes = new ArrayList<>();

    for (int i = 0; i < 2; ++i) {
      writes.add(set(SINGLE_FIELD_PROTO));
    }

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(2, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(commit(TRANSACTION_ID, writes.toArray(new Write[] {})), requests.get(1));
  }

  @Test
  public void createDocument() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(2, 0))
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            t -> {
              t.create(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP)
                  .create(documentReference, LocalFirestoreHelper.SINGLE_FIELD_OBJECT);
              return "foo";
            },
            options);

    assertEquals("foo", transaction.get());

    List<Write> writes = new ArrayList<>();

    for (int i = 0; i < 2; ++i) {
      writes.add(create(SINGLE_FIELD_PROTO));
    }

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(2, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(commit(TRANSACTION_ID, writes.toArray(new Write[] {})), requests.get(1));
  }

  @Test
  public void deleteDocument() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(2, 0))
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            t -> {
              t.delete(documentReference);
              t.delete(
                  documentReference, Precondition.updatedAt(Timestamp.ofTimeSecondsAndNanos(1, 2)));
              return "foo";
            },
            options);

    assertEquals("foo", transaction.get());

    List<Write> writes = new ArrayList<>();
    writes.add(delete());

    com.google.firestore.v1.Precondition.Builder precondition =
        com.google.firestore.v1.Precondition.newBuilder();
    precondition.getUpdateTimeBuilder().setSeconds(1).setNanos(2);
    writes.add(delete(precondition.build()));

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(2, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(commit(TRANSACTION_ID, writes.toArray(new Write[] {})), requests.get(1));
  }

  @Test
  public void readOnlyTransactionOptionsBuilder_setReadTime() {
    Executor executor = mock(Executor.class);
    final com.google.protobuf.Timestamp.Builder readTime =
        com.google.protobuf.Timestamp.getDefaultInstance().toBuilder().setSeconds(1).setNanos(0);
    final ReadOnlyOptionsBuilder builder =
        TransactionOptions.createReadOnlyOptionsBuilder()
            .setExecutor(executor)
            .setReadTime(readTime);

    final TransactionOptions transactionOptions = builder.build();

    assertThat(builder.getExecutor()).isSameInstanceAs(executor);
    assertThat(builder.getReadTime()).isSameInstanceAs(readTime);

    assertThat(transactionOptions.getExecutor()).isSameInstanceAs(executor);

    assertThat(transactionOptions.getType()).isEqualTo(TransactionOptionsType.READ_ONLY);
    assertThat(transactionOptions.getReadTime()).isEqualTo(readTime.build());
    assertThat(transactionOptions.getNumberOfAttempts()).isEqualTo(1);
  }

  @Test
  public void readOnlyTransactionOptionsBuilder_defaults() {
    final ReadOnlyOptionsBuilder builder = TransactionOptions.createReadOnlyOptionsBuilder();

    final TransactionOptions transactionOptions = builder.build();

    assertThat(builder.getExecutor()).isNull();
    assertThat(builder.getReadTime()).isNull();

    assertThat(transactionOptions.getReadTime()).isNull();
    assertThat(transactionOptions.getNumberOfAttempts()).isEqualTo(1);
  }

  @Test
  public void readWriteTransactionOptionsBuilder_setNumberOfAttempts() {
    Executor executor = mock(Executor.class);
    final ReadWriteOptionsBuilder builder =
        TransactionOptions.createReadWriteOptionsBuilder()
            .setExecutor(executor)
            .setNumberOfAttempts(2);

    final TransactionOptions transactionOptions = builder.build();

    assertThat(builder.getExecutor()).isSameInstanceAs(executor);
    assertThat(builder.getNumberOfAttempts()).isEqualTo(2);

    assertThat(transactionOptions.getExecutor()).isSameInstanceAs(executor);

    assertThat(transactionOptions.getType()).isEqualTo(TransactionOptionsType.READ_WRITE);
    assertThat(transactionOptions.getNumberOfAttempts()).isEqualTo(2);
    assertThat(transactionOptions.getReadTime()).isNull();
  }

  @Test
  public void readWriteTransactionOptionsBuilder_defaults() {
    final TransactionOptions transactionOptions =
        TransactionOptions.createReadWriteOptionsBuilder().build();

    assertThat(transactionOptions.getExecutor()).isNull();
    assertThat(transactionOptions.getNumberOfAttempts()).isEqualTo(5);
    assertThat(transactionOptions.getReadTime()).isNull();
  }

  @Test
  public void readWriteTransactionOptionsBuilder_errorAttemptingToSetNumAttemptsLessThanOne() {
    try {
      TransactionOptions.createReadWriteOptionsBuilder().setNumberOfAttempts(0);
      fail("Error expected");
    } catch (IllegalArgumentException ignore) {
      // expected
    }
  }

  @Test
  public void getShouldThrowWhenInvokedAfterAWriteWithAQuery() throws Exception {
    doReturn(beginResponse())
        .when(firestoreMock)
        .sendRequest(ArgumentMatchers.any(), ArgumentMatchers.any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            t -> {
              t.set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP);
              t.get(queryReference);
              return null;
            });

    ExecutionException executionException =
        assertThrows(ExecutionException.class, transaction::get);
    assertThat(executionException.getCause()).isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void getShouldThrowWhenInvokedAfterAWriteWithAnAggregateQuery() throws Exception {
    doReturn(beginResponse())
        .when(firestoreMock)
        .sendRequest(ArgumentMatchers.any(), ArgumentMatchers.any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            t -> {
              t.set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP);
              t.get(aggregateQueryReference);
              return null;
            });

    ExecutionException executionException =
        assertThrows(ExecutionException.class, transaction::get);
    assertThat(executionException.getCause()).isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void givesProperErrorMessageForCommittedTransaction() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(0, 0))
        .when(firestoreMock)
        .sendRequest(
            requestCapture.capture(), ArgumentMatchers.<UnaryCallable<Message, Message>>any());
    String expectedErrorMessage = "Cannot modify a Transaction that has already been committed.";

    DocumentReference docRef = firestoreMock.collection("foo").document("bar");

    // Commit a transaction.
    Transaction t = firestoreMock.runTransaction(transaction -> transaction).get();

    // Then run other operations in the same transaction.
    LocalFirestoreHelper.assertException(
        () -> {
          t.set(docRef, map("foo", "bar"));
        },
        expectedErrorMessage);
    LocalFirestoreHelper.assertException(
        () -> {
          t.update(docRef, map("foo", "bar"));
        },
        expectedErrorMessage);
    LocalFirestoreHelper.assertException(
        () -> {
          t.create(docRef, map("foo", "bar"));
        },
        expectedErrorMessage);
    LocalFirestoreHelper.assertException(
        () -> {
          t.delete(docRef);
        },
        expectedErrorMessage);
  }

  private ApiException exception(Status.Code code, boolean shouldRetry) {
    return exception(code, "Test exception", shouldRetry);
  }

  private ApiException exception(Status.Code code, String message, boolean shouldRetry) {
    return new ApiException(new Exception(message), GrpcStatusCode.of(code), shouldRetry);
  }
}
