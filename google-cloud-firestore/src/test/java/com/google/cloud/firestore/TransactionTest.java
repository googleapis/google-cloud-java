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
import static com.google.cloud.firestore.LocalFirestoreHelper.TRANSACTION_ID;
import static com.google.cloud.firestore.LocalFirestoreHelper.begin;
import static com.google.cloud.firestore.LocalFirestoreHelper.beginResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.commit;
import static com.google.cloud.firestore.LocalFirestoreHelper.commitResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.create;
import static com.google.cloud.firestore.LocalFirestoreHelper.delete;
import static com.google.cloud.firestore.LocalFirestoreHelper.get;
import static com.google.cloud.firestore.LocalFirestoreHelper.getAllResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.query;
import static com.google.cloud.firestore.LocalFirestoreHelper.queryResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.rollback;
import static com.google.cloud.firestore.LocalFirestoreHelper.rollbackResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.set;
import static com.google.cloud.firestore.LocalFirestoreHelper.update;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.firestore.spi.v1beta1.FirestoreRpc;
import com.google.firestore.v1beta1.Write;
import com.google.protobuf.ByteString;
import com.google.protobuf.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Assert;
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
public class TransactionTest {

  @Spy private FirestoreRpc firestoreRpc = Mockito.mock(FirestoreRpc.class);

  @Spy
  private FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder().setProjectId("test-project").build(), firestoreRpc);

  @Captor private ArgumentCaptor<Message> requestCapture;
  @Captor private ArgumentCaptor<ApiStreamObserver<Message>> streamObserverCapture;

  private DocumentReference documentReference;
  private Query queryReference;
  private TransactionOptions options;

  @Before
  public void before() {
    doReturn(Executors.newSingleThreadScheduledExecutor()).when(firestoreRpc).getExecutor();

    documentReference = firestoreMock.document("coll/doc");
    queryReference = firestoreMock.collection("coll");
    options =
        TransactionOptions.create(
            Executors.newSingleThreadExecutor(
                new ThreadFactory() {
                  @Override
                  public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("user_provided");
                    return thread;
                  }
                }));
  }

  @Test
  public void returnsValue() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(0, 0))
        .when(firestoreMock)
        .sendRequest(requestCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            new Transaction.Function<String>() {
              @Override
              public String updateCallback(Transaction transaction) {
                Assert.assertEquals("user_provided", Thread.currentThread().getName());
                return "foo";
              }
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
        .doReturn(ApiFutures.immediateFailedFuture(new Exception()))
        .doReturn(beginResponse(ByteString.copyFromUtf8("foo2")))
        .doReturn(commitResponse(0, 0))
        .when(firestoreMock)
        .sendRequest(requestCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            new Transaction.Function<String>() {
              @Override
              public String updateCallback(Transaction transaction) {
                return null;
              }
            },
            options);

    assertEquals(null, transaction.get());
  }

  @Test
  public void rollbackOnCallbackError() throws Exception {
    doReturn(beginResponse())
        .doReturn(rollbackResponse())
        .when(firestoreMock)
        .sendRequest(requestCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            new Transaction.Function<String>() {
              @Override
              public String updateCallback(Transaction transaction) throws Exception {
                throw new Exception("Expected exception");
              }
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
  public void noRollbackOnBeginFailure() throws Exception {
    doReturn(ApiFutures.immediateFailedFuture(new Exception("Expected exception")))
        .when(firestoreMock)
        .sendRequest(requestCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            new Transaction.Function<String>() {
              @Override
              public String updateCallback(Transaction transaction) {
                fail();
                return null;
              }
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
  public void limitsRetriesWithFailure() throws Exception {
    doReturn(beginResponse(ByteString.copyFromUtf8("foo1")))
        .doReturn(ApiFutures.immediateFailedFuture(new Exception()))
        .doReturn(beginResponse(ByteString.copyFromUtf8("foo2")))
        .doReturn(ApiFutures.immediateFailedFuture(new Exception()))
        .doReturn(beginResponse(ByteString.copyFromUtf8("foo3")))
        .doReturn(ApiFutures.immediateFailedFuture(new Exception()))
        .doReturn(beginResponse(ByteString.copyFromUtf8("foo4")))
        .doReturn(ApiFutures.immediateFailedFuture(new Exception()))
        .doReturn(beginResponse(ByteString.copyFromUtf8("foo5")))
        .doReturn(ApiFutures.immediateFailedFuture(new Exception()))
        .when(firestoreMock)
        .sendRequest(requestCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            new Transaction.Function<String>() {
              @Override
              public String updateCallback(Transaction transaction) {
                return "foo";
              }
            },
            options);

    try {
      transaction.get();
      fail();
    } catch (Exception e) {
      assertTrue(e.getMessage().endsWith("Transaction was cancelled because of too many retries."));
    }

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(10, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(commit(ByteString.copyFromUtf8("foo1")), requests.get(1));
    assertEquals(begin(ByteString.copyFromUtf8("foo1")), requests.get(2));
    assertEquals(commit(ByteString.copyFromUtf8("foo2")), requests.get(3));
    assertEquals(begin(ByteString.copyFromUtf8("foo2")), requests.get(4));
    assertEquals(commit(ByteString.copyFromUtf8("foo3")), requests.get(5));
    assertEquals(begin(ByteString.copyFromUtf8("foo3")), requests.get(6));
    assertEquals(commit(ByteString.copyFromUtf8("foo4")), requests.get(7));
    assertEquals(begin(ByteString.copyFromUtf8("foo4")), requests.get(8));
    assertEquals(commit(ByteString.copyFromUtf8("foo5")), requests.get(9));
  }

  @Test
  public void limitsRetriesWithSuccess() throws Exception {
    doReturn(beginResponse(ByteString.copyFromUtf8("foo1")))
        .doReturn(ApiFutures.immediateFailedFuture(new Exception()))
        .doReturn(beginResponse(ByteString.copyFromUtf8("foo2")))
        .doReturn(ApiFutures.immediateFailedFuture(new Exception()))
        .doReturn(beginResponse(ByteString.copyFromUtf8("foo3")))
        .doReturn(ApiFutures.immediateFailedFuture(new Exception()))
        .doReturn(beginResponse(ByteString.copyFromUtf8("foo4")))
        .doReturn(ApiFutures.immediateFailedFuture(new Exception()))
        .doReturn(beginResponse(ByteString.copyFromUtf8("foo5")))
        .doReturn(ApiFutures.immediateFailedFuture(new Exception()))
        .doReturn(beginResponse(ByteString.copyFromUtf8("foo6")))
        .doReturn(commitResponse(0, 0))
        .when(firestoreMock)
        .sendRequest(requestCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    final AtomicInteger retryCount = new AtomicInteger(1);

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            new Transaction.Function<String>() {
              @Override
              public String updateCallback(Transaction transaction) {
                return "foo" + retryCount.getAndIncrement();
              }
            },
            TransactionOptions.create(options.getExecutor(), 6));

    assertEquals("foo6", transaction.get());

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(12, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(commit(ByteString.copyFromUtf8("foo1")), requests.get(1));
    assertEquals(begin(ByteString.copyFromUtf8("foo1")), requests.get(2));
    assertEquals(commit(ByteString.copyFromUtf8("foo2")), requests.get(3));
    assertEquals(begin(ByteString.copyFromUtf8("foo2")), requests.get(4));
    assertEquals(commit(ByteString.copyFromUtf8("foo3")), requests.get(5));
    assertEquals(begin(ByteString.copyFromUtf8("foo3")), requests.get(6));
    assertEquals(commit(ByteString.copyFromUtf8("foo4")), requests.get(7));
    assertEquals(begin(ByteString.copyFromUtf8("foo4")), requests.get(8));
    assertEquals(commit(ByteString.copyFromUtf8("foo5")), requests.get(9));
    assertEquals(begin(ByteString.copyFromUtf8("foo5")), requests.get(10));
    assertEquals(commit(ByteString.copyFromUtf8("foo6")), requests.get(11));
  }

  @Test
  public void getDocument() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(0, 0))
        .when(firestoreMock)
        .sendRequest(requestCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    doAnswer(getAllResponse(SINGLE_FIELD_PROTO))
        .when(firestoreMock)
        .streamRequest(
            requestCapture.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable<Message, Message>>any());

    ApiFuture<DocumentSnapshot> transaction =
        firestoreMock.runTransaction(
            new Transaction.Function<DocumentSnapshot>() {
              @Override
              public DocumentSnapshot updateCallback(Transaction transaction)
                  throws ExecutionException, InterruptedException {
                return transaction.get(documentReference).get();
              }
            },
            options);

    assertEquals("doc", transaction.get().getId());

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(3, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(get(TRANSACTION_ID), requests.get(1));
    assertEquals(commit(TRANSACTION_ID), requests.get(2));
  }

  @Test
  public void getQuery() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(0, 0))
        .when(firestoreMock)
        .sendRequest(requestCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            requestCapture.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable<Message, Message>>any());

    ApiFuture<QuerySnapshot> transaction =
        firestoreMock.runTransaction(
            new Transaction.Function<QuerySnapshot>() {
              @Override
              public QuerySnapshot updateCallback(Transaction transaction)
                  throws ExecutionException, InterruptedException {
                return transaction.get(queryReference).get();
              }
            },
            options);

    assertEquals(1, transaction.get().size());

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(3, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(query(TRANSACTION_ID), requests.get(1));
    assertEquals(commit(TRANSACTION_ID), requests.get(2));
  }

  @Test
  public void updateDocument() throws Exception {
    doReturn(beginResponse())
        .doReturn(commitResponse(2, 0))
        .when(firestoreMock)
        .sendRequest(requestCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            new Transaction.Function<String>() {
              @Override
              public String updateCallback(Transaction transaction) {
                transaction.update(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP);
                transaction.update(documentReference, "foo", "bar");
                return "foo";
              }
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
        .sendRequest(requestCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            new Transaction.Function<String>() {
              @Override
              public String updateCallback(Transaction transaction) {
                transaction
                    .set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP)
                    .set(documentReference, LocalFirestoreHelper.SINGLE_FIELD_OBJECT);
                return "foo";
              }
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
        .sendRequest(requestCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            new Transaction.Function<String>() {
              @Override
              public String updateCallback(Transaction transaction) {
                transaction
                    .create(documentReference, LocalFirestoreHelper.SINGLE_FIELD_MAP)
                    .create(documentReference, LocalFirestoreHelper.SINGLE_FIELD_OBJECT);
                return "foo";
              }
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
        .sendRequest(requestCapture.capture(), Matchers.<UnaryCallable<Message, Message>>any());

    ApiFuture<String> transaction =
        firestoreMock.runTransaction(
            new Transaction.Function<String>() {
              @Override
              public String updateCallback(Transaction transaction) {
                transaction.delete(documentReference);
                transaction.delete(
                    documentReference, Precondition.updatedAt(Instant.ofEpochSecond(1, 2)));
                return "foo";
              }
            },
            options);

    assertEquals("foo", transaction.get());

    List<Write> writes = new ArrayList<>();
    writes.add(delete());

    com.google.firestore.v1beta1.Precondition.Builder precondition =
        com.google.firestore.v1beta1.Precondition.newBuilder();
    precondition.getUpdateTimeBuilder().setSeconds(1).setNanos(2);
    writes.add(delete(precondition.build()));

    List<Message> requests = requestCapture.getAllValues();
    assertEquals(2, requests.size());

    assertEquals(begin(), requests.get(0));
    assertEquals(commit(TRANSACTION_ID, writes.toArray(new Write[] {})), requests.get(1));
  }
}
