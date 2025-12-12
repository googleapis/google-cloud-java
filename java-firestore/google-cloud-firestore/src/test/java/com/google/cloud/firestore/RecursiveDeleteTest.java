/*
 * Copyright 2021 Google LLC
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

import static com.google.cloud.firestore.BulkWriterTest.failedResponse;
import static com.google.cloud.firestore.BulkWriterTest.mergeResponses;
import static com.google.cloud.firestore.BulkWriterTest.successResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.COLLECTION_ID;
import static com.google.cloud.firestore.LocalFirestoreHelper.DATABASE_NAME;
import static com.google.cloud.firestore.LocalFirestoreHelper.DOCUMENT_ROOT;
import static com.google.cloud.firestore.LocalFirestoreHelper.batchWrite;
import static com.google.cloud.firestore.LocalFirestoreHelper.delete;
import static com.google.cloud.firestore.LocalFirestoreHelper.emptyQueryResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.filter;
import static com.google.cloud.firestore.LocalFirestoreHelper.limit;
import static com.google.cloud.firestore.LocalFirestoreHelper.order;
import static com.google.cloud.firestore.LocalFirestoreHelper.query;
import static com.google.cloud.firestore.LocalFirestoreHelper.queryResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.reference;
import static com.google.cloud.firestore.LocalFirestoreHelper.select;
import static com.google.cloud.firestore.LocalFirestoreHelper.startAt;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.lenient;

import com.google.api.core.ApiAsyncFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.firestore.LocalFirestoreHelper.ResponseStubber;
import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.firestore.v1.BatchWriteRequest;
import com.google.firestore.v1.BatchWriteResponse;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.firestore.v1.StructuredQuery.Direction;
import com.google.firestore.v1.StructuredQuery.FieldFilter.Operator;
import com.google.firestore.v1.Value;
import com.google.firestore.v1.Write;
import com.google.protobuf.Message;
import com.google.rpc.Code;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class RecursiveDeleteTest {
  @Rule public Timeout timeout = new Timeout(10, TimeUnit.SECONDS);

  @Spy private final FirestoreRpc firestoreRpc = Mockito.mock(FirestoreRpc.class);

  /** Executor that executes delayed tasks without delay. */
  private final ScheduledExecutorService immediateExecutor =
      new ScheduledThreadPoolExecutor(1) {
        @Override
        @Nonnull
        public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
          return super.schedule(command, 0, TimeUnit.MILLISECONDS);
        }
      };

  @Spy
  private final FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder().setProjectId("test-project").build(), firestoreRpc);

  @Captor private ArgumentCaptor<BatchWriteRequest> batchWriteCapture;
  @Captor private ArgumentCaptor<RunQueryRequest> runQueryCapture;
  @Captor private ArgumentCaptor<ResponseObserver<Message>> streamObserverCapture;

  private BulkWriter bulkWriter;
  private ResponseStubber responseStubber;

  @Before
  public void before() {
    lenient().doReturn(immediateExecutor).when(firestoreRpc).getExecutor();

    final ScheduledExecutorService timeoutExecutor =
        new ScheduledThreadPoolExecutor(1) {
          @Override
          @Nonnull
          public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
            return super.schedule(command, 0, TimeUnit.MILLISECONDS);
          }
        };
  }

  private Value recursiveDeleteStartAt(String name) {
    return Value.newBuilder()
        .setReferenceValue(
            DATABASE_NAME + "/documents/" + name + "/" + RecursiveDelete.REFERENCE_NAME_MIN_ID)
        .build();
  }

  private Value recursiveDeleteEndAt(String name) {
    return Value.newBuilder()
        .setReferenceValue(
            DOCUMENT_ROOT + name + '\0' + "/" + RecursiveDelete.REFERENCE_NAME_MIN_ID)
        .build();
  }

  private String fullDocumentPath(String name) {
    return DOCUMENT_ROOT + COLLECTION_ID + "/" + name;
  }

  private void setupMocks(List<String> childrenDocuments) throws Exception {
    setupMocks(childrenDocuments, /* deleteDocRef= */ "");
  }

  private void setupMocks(List<String> childrenDocuments, String deleteDocRef) throws Exception {
    setupMocks(childrenDocuments, deleteDocRef, null);
  }

  private void setupMocks(
      List<String> childrenDocuments,
      final String deleteDocRef,
      @Nullable final ApiFuture<BatchWriteResponse> customResponse)
      throws Exception {

    List<String> fullDocumentPaths = new ArrayList<>();
    for (String documentName : childrenDocuments) {
      fullDocumentPaths.add(fullDocumentPath(documentName));
    }

    doAnswer(queryResponse(fullDocumentPaths.toArray(new String[0])))
        .when(firestoreMock)
        .streamRequest(
            runQueryCapture.capture(),
            streamObserverCapture.capture(),
            ArgumentMatchers.<ServerStreamingCallable>any());

    if (!deleteDocRef.equals("")) {
      childrenDocuments = new ArrayList<>(childrenDocuments);
      childrenDocuments.add(deleteDocRef);
    }

    final List<Write> expectedRequests = new ArrayList<>();
    final List<ApiFuture<BatchWriteResponse>> returnedResponse = new ArrayList<>();
    for (String documentPath : childrenDocuments) {
      expectedRequests.add(delete(COLLECTION_ID + "/" + documentPath));
      returnedResponse.add(successResponse(1));
    }

    final ApiFuture<BatchWriteResponse> finalResponse =
        customResponse != null
            ? customResponse
            : mergeResponses(returnedResponse.toArray(new ApiFuture[0]));

    responseStubber =
        new ResponseStubber() {
          {
            put(batchWrite(expectedRequests.toArray(new Write[0])), finalResponse);
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);
  }

  @Test
  public void getAllDescendantsRootLevelCollection() throws Exception {
    doAnswer(emptyQueryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQueryCapture.capture(),
            streamObserverCapture.capture(),
            ArgumentMatchers.<ServerStreamingCallable>any());

    RunQueryRequest expectedRequest =
        query(
            null,
            /* allDescendants= */ true,
            /* kindless= */ true,
            select(FieldPath.documentId()),
            filter(
                Operator.GREATER_THAN_OR_EQUAL,
                FieldPath.documentId().toString(),
                recursiveDeleteStartAt("root")),
            filter(
                Operator.LESS_THAN,
                FieldPath.documentId().toString(),
                recursiveDeleteEndAt("root")),
            limit(RecursiveDelete.MAX_PENDING_OPS));

    firestoreMock.recursiveDelete(firestoreMock.collection("root")).get();
    assertEquals(expectedRequest, runQueryCapture.getValue());
  }

  @Test
  public void getAllDescendantsNestedCollection() throws Exception {
    doAnswer(emptyQueryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQueryCapture.capture(),
            streamObserverCapture.capture(),
            ArgumentMatchers.<ServerStreamingCallable>any());

    RunQueryRequest expectedRequest =
        query(
            null,
            /* parent= */ "root/doc",
            /* allDescendants= */ true,
            /* kindless= */ true,
            select(FieldPath.documentId()),
            filter(
                Operator.GREATER_THAN_OR_EQUAL,
                FieldPath.documentId().toString(),
                recursiveDeleteStartAt("root/doc/nestedCol")),
            filter(
                Operator.LESS_THAN,
                FieldPath.documentId().toString(),
                recursiveDeleteEndAt("root/doc/nestedCol")),
            limit(RecursiveDelete.MAX_PENDING_OPS));

    firestoreMock.recursiveDelete(firestoreMock.collection("root/doc/nestedCol")).get();
    assertEquals(expectedRequest, runQueryCapture.getValue());
  }

  @Test
  public void getAllDescendantsDocument() throws Exception {
    doAnswer(emptyQueryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQueryCapture.capture(),
            streamObserverCapture.capture(),
            ArgumentMatchers.<ServerStreamingCallable>any());

    // Include dummy response for the deleted fullDocumentPath reference.
    doAnswer((Answer<ApiFuture<BatchWriteResponse>>) mock -> successResponse(1))
        .when(firestoreMock)
        .sendRequest(
            batchWriteCapture.capture(),
            ArgumentMatchers.<UnaryCallable<BatchWriteRequest, BatchWriteResponse>>any());

    RunQueryRequest expectedRequest =
        query(
            null,
            /* parent= */ "root/doc",
            /* allDescendants= */ true,
            /* kindless= */ true,
            select(FieldPath.documentId()),
            limit(RecursiveDelete.MAX_PENDING_OPS));

    firestoreMock.recursiveDelete(firestoreMock.document("root/doc")).get();
    assertEquals(expectedRequest, runQueryCapture.getValue());
  }

  @Test
  public void createsRetryQueryAfterStreamExceptionWithLastReceivedDoc() throws Exception {
    doAnswer(
            queryResponse(
                new FirestoreException("Mock runQuery() failed in test", Status.UNAVAILABLE),
                fullDocumentPath(("doc1"))))
        .doAnswer(emptyQueryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQueryCapture.capture(),
            streamObserverCapture.capture(),
            ArgumentMatchers.<ServerStreamingCallable>any());

    doAnswer(mock -> successResponse(1))
        .when(firestoreMock)
        .sendRequest(
            batchWriteCapture.capture(),
            ArgumentMatchers.<UnaryCallable<BatchWriteRequest, BatchWriteResponse>>any());

    RunQueryRequest expectedRequest =
        query(
            null,
            /* allDescendants= */ true,
            /* kindless= */ true,
            select(FieldPath.documentId()),
            order(FieldPath.documentId(), Direction.ASCENDING),
            startAt(reference(fullDocumentPath("doc1")), /* before= */ false),
            filter(
                Operator.GREATER_THAN_OR_EQUAL,
                FieldPath.documentId().toString(),
                recursiveDeleteStartAt("coll")),
            filter(
                Operator.LESS_THAN,
                FieldPath.documentId().toString(),
                recursiveDeleteEndAt("coll")),
            limit(RecursiveDelete.MAX_PENDING_OPS));

    firestoreMock.recursiveDelete(firestoreMock.collection("coll")).get();
    assertEquals(expectedRequest, runQueryCapture.getAllValues().get(1));
  }

  @Test
  @Ignore
  public void createsSecondQueryWithCorrectStartAfter() throws Exception {
    // This test checks that the second query is created with the correct startAfter() once the
    // RecursiveDelete instance is below the MIN_PENDING_OPS threshold to send the next batch.

    // Use lower limits than the actual RecursiveDelete class in order to make this test run fast.
    int maxPendingOps = 100;
    int minPendingOps = 11;
    int maxBatchSize = 10;

    final int cutoff = maxPendingOps - minPendingOps;
    final int[] numDeletesBuffered = {0};

    // This future is used to delay the BatchWriteResponses from returning in order to create the
    // situation where the number of pending operations is less than `minPendingOps`.
    final SettableApiFuture<Void> bufferFuture = SettableApiFuture.create();

    // This future completes when the second query is run.
    final SettableApiFuture<Void> secondQueryFuture = SettableApiFuture.create();

    List<String> firstStream = new ArrayList<>();
    final List<ApiFuture<BatchWriteResponse>> batchWriteResponse = new ArrayList<>();
    for (int i = 0; i < maxPendingOps; i++) {
      firstStream.add(fullDocumentPath("doc" + i));
    }

    for (int i = 0; i < maxBatchSize; i++) {
      batchWriteResponse.add(successResponse(1));
    }

    doAnswer(queryResponse(firstStream.toArray(new String[0])))
        .doAnswer(
            invocation -> {
              secondQueryFuture.set(null);
              Object[] args = invocation.getArguments();
              ResponseObserver<RunQueryResponse> observer =
                  (ResponseObserver<RunQueryResponse>) args[1];
              observer.onComplete();
              return null;
            })
        .when(firestoreMock)
        .streamRequest(
            runQueryCapture.capture(),
            streamObserverCapture.capture(),
            ArgumentMatchers.<ServerStreamingCallable>any());

    doAnswer(
            mock -> {
              if (numDeletesBuffered[0] < cutoff) {
                numDeletesBuffered[0] += batchWriteResponse.size();
                // By waiting for `bufferFuture` to complete, we can guarantee that the writes
                // complete after all documents are streamed. Without this future, the test can
                // race and complete the writes before the stream is finished, which is a
                // different scenario this test is not for.
                return ApiFutures.transformAsync(
                    bufferFuture,
                    (ApiAsyncFunction<Void, BatchWriteResponse>)
                        unused -> mergeResponses(batchWriteResponse.toArray(new ApiFuture[0])),
                    MoreExecutors.directExecutor());
              } else {
                // Once there are `cutoff` pending deletes, completing the future allows enough
                // responses to be returned such that the number of pending deletes should be
                // less than `minPendingOps`. This allows us to test that the second query is
                // made.
                bufferFuture.set(null);
                return ApiFutures.transformAsync(
                    secondQueryFuture,
                    (ApiAsyncFunction<Void, BatchWriteResponse>)
                        unused -> mergeResponses(batchWriteResponse.toArray(new ApiFuture[0])),
                    MoreExecutors.directExecutor());
              }
            })
        .when(firestoreMock)
        .sendRequest(
            batchWriteCapture.capture(),
            ArgumentMatchers.<UnaryCallable<BatchWriteRequest, BatchWriteResponse>>any());

    BulkWriter bulkWriter = firestoreMock.bulkWriter();
    bulkWriter.setMaxBatchSize(maxBatchSize);

    RunQueryRequest expectedRequest =
        query(
            null,
            /* allDescendants= */ true,
            /* kindless= */ true,
            select(FieldPath.documentId()),
            order(FieldPath.documentId(), Direction.ASCENDING),
            startAt(reference(fullDocumentPath("doc" + (maxPendingOps - 1))), /* before= */ false),
            filter(
                Operator.GREATER_THAN_OR_EQUAL,
                FieldPath.documentId().toString(),
                recursiveDeleteStartAt("coll")),
            filter(
                Operator.LESS_THAN,
                FieldPath.documentId().toString(),
                recursiveDeleteEndAt("coll")),
            limit(maxPendingOps));

    firestoreMock
        .recursiveDelete(
            firestoreMock.collection("coll").getResourcePath(),
            bulkWriter,
            maxPendingOps,
            minPendingOps)
        .get();
    assertEquals(2, runQueryCapture.getAllValues().size());
    assertEquals(expectedRequest, runQueryCapture.getAllValues().get(1));
  }

  @Test
  public void deletesCollection() throws Exception {
    List<String> documents =
        Arrays.asList("anna", "bob", "bob/children/charlie", "bob/children/daniel");
    setupMocks(documents);
    firestoreMock.recursiveDelete(firestoreMock.collection(COLLECTION_ID)).get();
    responseStubber.verifyAllRequestsSent();
  }

  @Test
  public void deletesDocumentAndReference() throws Exception {
    List<String> documents =
        Arrays.asList("bob/children/brian", "bob/children/charlie", "bob/children/daniel");
    setupMocks(documents, "bob");
    firestoreMock.recursiveDelete(firestoreMock.collection(COLLECTION_ID).document("bob")).get();
    responseStubber.verifyAllRequestsSent();
  }

  @Test
  public void exceptionContainsLastErrorCodeIfWritesFail() throws Exception {
    List<String> documents =
        Arrays.asList("bob/children/brian", "bob/children/charlie", "bob/children/daniel");
    ApiFuture<BatchWriteResponse> customResponse =
        mergeResponses(
            successResponse(1),
            failedResponse(Code.CANCELLED_VALUE),
            failedResponse(Code.PERMISSION_DENIED_VALUE),
            successResponse(1));
    setupMocks(documents, "bob", customResponse);
    try {
      ApiFuture<Void> future =
          firestoreMock.recursiveDelete(firestoreMock.collection(COLLECTION_ID).document("bob"));
      future.get();
      fail("Operation should have failed in test");
    } catch (Exception e) {
      assertEquals(Status.PERMISSION_DENIED, ((FirestoreException) e.getCause()).getStatus());
      assertTrue(e.getMessage().contains("2 deletes failed"));
    }
  }

  @Test
  public void exceptionThrownIfBulkWriterSuccessHandlerFails() throws Exception {
    List<String> documents = Arrays.asList("bob/children/brian");
    setupMocks(documents, "bob");
    bulkWriter = firestoreMock.bulkWriter();
    bulkWriter.addWriteResultListener(
        (documentReference, result) -> {
          throw new UnsupportedOperationException("Test code threw UnsupportedOperationException");
        });
    try {
      ApiFuture<Void> future =
          firestoreMock.recursiveDelete(
              firestoreMock.collection(COLLECTION_ID).document("bob"), bulkWriter);
      future.get();
      fail("Operation should have failed in test");
    } catch (Exception e) {
      assertTrue(e.getMessage().contains("2 deletes failed"));
    }
  }

  @Test
  public void successHandlerProvidesCorrectReferencesAndResults() throws Exception {
    List<String> documents = Arrays.asList("bob/children/brian", "bob/children/charlie");
    ApiFuture<BatchWriteResponse> customResponse =
        mergeResponses(successResponse(1), successResponse(2), successResponse(3));
    setupMocks(documents, "bob", customResponse);

    final List<Integer> results = new ArrayList<>();
    final List<String> references = new ArrayList<>();
    bulkWriter = firestoreMock.bulkWriter();
    bulkWriter.addWriteResultListener(
        (documentReference, result) -> {
          results.add((int) result.getUpdateTime().getSeconds());
          references.add(documentReference.getPath());
        });
    ApiFuture<Void> future =
        firestoreMock.recursiveDelete(
            firestoreMock.collection(COLLECTION_ID).document("bob"), bulkWriter);
    future.get();
    assertArrayEquals(new Integer[] {1, 2, 3}, results.toArray());
    assertArrayEquals(
        new String[] {
          "coll/bob/children/brian", "coll/bob/children/charlie", "coll/bob",
        },
        references.toArray());
  }

  @Test
  public void errorHandlerProvidesCorrectInformation() throws Exception {
    List<String> documents = Arrays.asList("bob/children/brian", "bob/children/charlie");
    ApiFuture<BatchWriteResponse> customResponse =
        mergeResponses(
            failedResponse(Code.PERMISSION_DENIED_VALUE),
            failedResponse(Code.UNAVAILABLE_VALUE),
            failedResponse(Code.INTERNAL_VALUE));
    setupMocks(documents, "bob", customResponse);

    final List<Status> codes = new ArrayList<>();
    final List<String> references = new ArrayList<>();
    bulkWriter = firestoreMock.bulkWriter();
    bulkWriter.addWriteErrorListener(
        error -> {
          codes.add(error.getStatus());
          references.add(error.getDocumentReference().getPath());
          return false;
        });
    ApiFuture<Void> future =
        firestoreMock.recursiveDelete(
            firestoreMock.collection(COLLECTION_ID).document("bob"), bulkWriter);
    try {
      future.get();
      fail("Operation should have failed");
    } catch (Exception e) {
      assertArrayEquals(
          new Status[] {Status.PERMISSION_DENIED, Status.UNAVAILABLE, Status.INTERNAL},
          codes.toArray());
      assertArrayEquals(
          new String[] {
            "coll/bob/children/brian", "coll/bob/children/charlie", "coll/bob",
          },
          references.toArray());
    }
  }

  @Test
  public void exceptionThrownIfProvidedReferenceWasNotDeleted() throws Exception {
    doAnswer(emptyQueryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQueryCapture.capture(),
            streamObserverCapture.capture(),
            ArgumentMatchers.<ServerStreamingCallable>any());
    doReturn(BulkWriterTest.FAILED_FUTURE)
        .when(firestoreMock)
        .sendRequest(
            batchWriteCapture.capture(),
            ArgumentMatchers.<UnaryCallable<BatchWriteRequest, BatchWriteResponse>>any());

    ApiFuture<Void> future = firestoreMock.recursiveDelete(firestoreMock.document("root/doc"));
    try {
      future.get();
      fail("Operation should have failed in test");
    } catch (Exception e) {
      assertTrue(e.getMessage().contains("Mock batchWrite failed in test"));
    }
  }

  @Test
  public void handlesSuccessfulStreamErrorRetries() throws Exception {
    FirestoreException mockException =
        new FirestoreException("runQuery() failed in test", Status.UNAVAILABLE);
    // Note that these mock responses differ from the Node implementation since Node retries
    // queries that fail without streaming any documents in the SDK, whereas Java handles these
    // retries at the GAX level. The Java SDK does not retry unless a document was streamed in the
    // query.
    final List<Answer<RunQueryResponse>> runQueryResponses =
        new ArrayList<>(
            Arrays.asList(
                queryResponse(mockException, fullDocumentPath("a"), fullDocumentPath("b")),
                queryResponse(mockException, fullDocumentPath("c")),
                queryResponse(mockException, fullDocumentPath("d")),
                queryResponse(fullDocumentPath("e"))));

    doAnswer(runQueryResponses.get(0))
        .doAnswer(runQueryResponses.get(1))
        .doAnswer(runQueryResponses.get(2))
        .doAnswer(runQueryResponses.get(3))
        .when(firestoreMock)
        .streamRequest(
            runQueryCapture.capture(),
            streamObserverCapture.capture(),
            ArgumentMatchers.<ServerStreamingCallable>any());

    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(
                    delete("coll/a"),
                    delete("coll/b"),
                    delete("coll/c"),
                    delete("coll/d"),
                    delete("coll/e")),
                mergeResponses(
                    successResponse(1),
                    successResponse(1),
                    successResponse(1),
                    successResponse(1),
                    successResponse(1)));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    firestoreMock.recursiveDelete(firestoreMock.collection(COLLECTION_ID)).get();
    responseStubber.verifyAllRequestsSent();
  }

  @Test
  public void handlesMultipleCallsToRecursiveDelete() throws Exception {
    final List<Answer<RunQueryResponse>> runQueryResponses =
        new ArrayList<>(
            Arrays.asList(
                queryResponse(fullDocumentPath("a")),
                queryResponse(fullDocumentPath("b")),
                queryResponse(fullDocumentPath("c"))));

    doAnswer(runQueryResponses.get(0))
        .doAnswer(runQueryResponses.get(1))
        .doAnswer(runQueryResponses.get(2))
        .when(firestoreMock)
        .streamRequest(
            runQueryCapture.capture(),
            streamObserverCapture.capture(),
            ArgumentMatchers.<ServerStreamingCallable>any());

    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(batchWrite(delete("coll/a")), successResponse(1));
            put(batchWrite(delete("coll/b")), successResponse(2));
            put(batchWrite(delete("coll/c")), successResponse(3));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    firestoreMock.recursiveDelete(firestoreMock.collection("a")).get();
    firestoreMock.recursiveDelete(firestoreMock.collection("b")).get();
    firestoreMock.recursiveDelete(firestoreMock.collection("c")).get();
    responseStubber.verifyAllRequestsSent();
  }

  @Test
  public void usesSameBulkWriterInstanceAcrossCalls() throws Exception {
    doAnswer(emptyQueryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQueryCapture.capture(),
            streamObserverCapture.capture(),
            ArgumentMatchers.<ServerStreamingCallable>any());

    final int[] callCount = {0};
    final BulkWriter bulkWriter = firestoreMock.bulkWriter();
    doAnswer(
            mock -> {
              callCount[0]++;
              return bulkWriter;
            })
        .when(firestoreMock)
        .bulkWriter();

    firestoreMock.recursiveDelete(firestoreMock.collection("foo")).get();
    firestoreMock.recursiveDelete(firestoreMock.collection("boo")).get();
    firestoreMock.recursiveDelete(firestoreMock.collection("moo")).get();

    // Only the first recursiveDelete() call should have called the constructor. Subsequent calls
    // should have used the same bulkWriter.
    assertEquals(1, callCount[0]);
  }

  @Test
  public void throwsErrorIfBulkWriterInstanceIsClosed() throws Exception {
    bulkWriter = firestoreMock.bulkWriter();
    bulkWriter.close();
    try {
      firestoreMock.recursiveDelete(firestoreMock.collection("foo"), bulkWriter);
      fail("Operation should have failed in test");
    } catch (Exception e) {
      assertTrue(e.getMessage().contains("BulkWriter has already been closed"));
    }
  }
}
