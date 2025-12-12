/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.firestore.LocalFirestoreHelper.batchWrite;
import static com.google.cloud.firestore.LocalFirestoreHelper.create;
import static com.google.cloud.firestore.LocalFirestoreHelper.delete;
import static com.google.cloud.firestore.LocalFirestoreHelper.map;
import static com.google.cloud.firestore.LocalFirestoreHelper.set;
import static com.google.cloud.firestore.LocalFirestoreHelper.update;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.LocalFirestoreHelper.ResponseStubber;
import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.firestore.v1.BatchWriteRequest;
import com.google.firestore.v1.BatchWriteResponse;
import com.google.firestore.v1.Value;
import com.google.firestore.v1.Write;
import com.google.protobuf.Message;
import com.google.rpc.Code;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import org.junit.After;
import org.junit.Assert;
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

@RunWith(MockitoJUnitRunner.class)
public class BulkWriterTest {

  public static final ApiFuture<Message> FAILED_FUTURE =
      ApiFutures.immediateFailedFuture(
          new ApiException(
              new IllegalStateException("Mock batchWrite failed in test"),
              GrpcStatusCode.of(Status.Code.UNKNOWN),
              false));

  private static final ApiFuture<Message> RETRYABLE_FAILED_FUTURE =
      ApiFutures.immediateFailedFuture(
          new ApiException(
              new IllegalStateException("Mock batchWrite failed in test"),
              GrpcStatusCode.of(Status.Code.ABORTED),
              true));

  private static final ApiFuture<Message> RESOURCE_EXHAUSTED_FAILED_FUTURE =
      ApiFutures.immediateFailedFuture(
          new ApiException(
              new IllegalStateException("Mock batchWrite failed in test"),
              GrpcStatusCode.of(Status.Code.RESOURCE_EXHAUSTED),
              true));

  @Rule public Timeout timeout = new Timeout(2, TimeUnit.SECONDS);

  private ScheduledExecutorService testExecutor;

  @Spy
  private final FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder().setProjectId("test-project").build(),
          Mockito.mock(FirestoreRpc.class));

  @Captor private ArgumentCaptor<BatchWriteRequest> batchWriteCapture;

  private BulkWriter bulkWriter;
  private DocumentReference doc1;
  private DocumentReference doc2;

  private ScheduledExecutorService timeoutExecutor;

  public static ApiFuture<BatchWriteResponse> successResponse(int updateTimeSeconds) {
    BatchWriteResponse.Builder response = BatchWriteResponse.newBuilder();
    response.addWriteResultsBuilder().getUpdateTimeBuilder().setSeconds(updateTimeSeconds).build();
    response.addStatusBuilder().build();
    return ApiFutures.immediateFuture(response.build());
  }

  public static ApiFuture<BatchWriteResponse> failedResponse(int code) {
    BatchWriteResponse.Builder response = BatchWriteResponse.newBuilder();
    response.addWriteResultsBuilder().build();
    response.addStatusBuilder().setCode(code).build();
    return ApiFutures.immediateFuture(response.build());
  }

  private ApiFuture<BatchWriteResponse> failedResponse() {
    return failedResponse(Code.DEADLINE_EXCEEDED_VALUE);
  }

  public static ApiFuture<BatchWriteResponse> mergeResponses(
      ApiFuture<BatchWriteResponse>... responses) throws Exception {
    BatchWriteResponse.Builder response = BatchWriteResponse.newBuilder();
    for (ApiFuture<BatchWriteResponse> future : responses) {
      BatchWriteResponse res = future.get();
      response.addStatus(res.getStatus(0));
      response.addWriteResults(res.getWriteResults(0));
    }
    return ApiFutures.immediateFuture(response.build());
  }

  @Before
  public void before() {
    testExecutor = Executors.newSingleThreadScheduledExecutor();

    timeoutExecutor =
        new ScheduledThreadPoolExecutor(1) {
          @Override
          @Nonnull
          public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
            return super.schedule(command, 0, TimeUnit.MILLISECONDS);
          }
        };

    bulkWriter =
        firestoreMock.bulkWriter(BulkWriterOptions.builder().setExecutor(timeoutExecutor).build());

    doc1 = firestoreMock.document("coll/doc1");
    doc2 = firestoreMock.document("coll/doc2");
  }

  @After
  public void after() throws InterruptedException {
    shutdownScheduledExecutorService(testExecutor);
    shutdownScheduledExecutorService(timeoutExecutor);
  }

  void shutdownScheduledExecutorService(ScheduledExecutorService executorService)
      throws InterruptedException {
    executorService.shutdown();
    // Wait for the executor to finish after each test.
    //
    // This ensures the executor service is shut down properly within the given timeout, and thereby
    // avoids potential hangs caused by lingering threads. Note that if a given thread is terminated
    // because of the timeout, the associated test will fail, which is what we want.
    executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
    assertTrue(executorService.isTerminated());
  }

  @Test
  public void hasSetMethod() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                successResponse(2));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    ApiFuture<WriteResult> result =
        bulkWriter.set(doc1, (Object) LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.close();

    responseStubber.verifyAllRequestsSent();
    assertEquals(Timestamp.ofTimeSecondsAndNanos(2, 0), result.get().getUpdateTime());
  }

  @Test
  public void hasUpdateMethod() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(
                    update(
                        LocalFirestoreHelper.SINGLE_FIELD_PROTO,
                        Collections.singletonList("foo"),
                        com.google.firestore.v1.Precondition.newBuilder()
                            .setUpdateTime(com.google.protobuf.Timestamp.newBuilder().build())
                            .build(),
                        "coll/doc1")),
                successResponse(2));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    ApiFuture<WriteResult> result =
        bulkWriter.update(
            doc1,
            LocalFirestoreHelper.SINGLE_FIELD_MAP,
            Precondition.updatedAt(Timestamp.ofTimeSecondsAndNanos(0, 0)));
    bulkWriter.flush().get();

    responseStubber.verifyAllRequestsSent();
    assertEquals(Timestamp.ofTimeSecondsAndNanos(2, 0), result.get().getUpdateTime());
  }

  @Test
  public void hasDeleteMethod() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(batchWrite(delete("coll/doc1")), successResponse(2));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    ApiFuture<WriteResult> result = bulkWriter.delete(doc1, Precondition.NONE);
    bulkWriter.close();

    responseStubber.verifyAllRequestsSent();
    assertEquals(Timestamp.ofTimeSecondsAndNanos(2, 0), result.get().getUpdateTime());
  }

  @Test
  public void hasCreateMethod() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(create(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                successResponse(2));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    ApiFuture<WriteResult> result =
        bulkWriter.create(doc1, (Object) LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.flush().get();

    responseStubber.verifyAllRequestsSent();
    assertEquals(Timestamp.ofTimeSecondsAndNanos(2, 0), result.get().getUpdateTime());
  }

  @Test
  public void surfacesErrors() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                failedResponse());
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    ApiFuture<WriteResult> result = bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.close();

    responseStubber.verifyAllRequestsSent();
    try {
      result.get();
      fail("set() should have failed");
    } catch (Exception e) {
      assertTrue(e.getCause() instanceof BulkWriterException);
      assertEquals(Status.DEADLINE_EXCEEDED, ((BulkWriterException) e.getCause()).getStatus());
    }
  }

  @Test
  public void flushResolvesImmediatelyIfNoWrites() throws Exception {
    bulkWriter.flush().get();
  }

  @Test
  public void addsWritesToNewBatchAfterFlush() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(create(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                successResponse(1));
            put(
                batchWrite(
                    set(
                        LocalFirestoreHelper.SINGLE_FIELD_PROTO,
                        Collections.singletonList("foo"),
                        "coll/doc2")),
                successResponse(2));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    ApiFuture<WriteResult> result1 = bulkWriter.create(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.flush();
    ApiFuture<WriteResult> result2 =
        bulkWriter.set(doc2, LocalFirestoreHelper.SINGLE_FIELD_MAP, SetOptions.merge());
    bulkWriter.close();

    responseStubber.verifyAllRequestsSent();
    assertEquals(Timestamp.ofTimeSecondsAndNanos(1, 0), result1.get().getUpdateTime());
    assertEquals(Timestamp.ofTimeSecondsAndNanos(2, 0), result2.get().getUpdateTime());
  }

  @Test
  public void cannotCallMethodsAfterClose() throws Exception {
    String expected = "BulkWriter has already been closed.";
    bulkWriter.close();
    try {
      bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
      fail("set() should have failed");
    } catch (Exception e) {
      assertEquals(expected, e.getMessage());
    }
    try {
      bulkWriter.create(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
      fail("create() should have failed");
    } catch (Exception e) {
      assertEquals(expected, e.getMessage());
    }
    try {
      bulkWriter.update(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
      fail("update() should have failed");
    } catch (Exception e) {
      assertEquals(expected, e.getMessage());
    }
    try {
      bulkWriter.delete(doc1);
      fail("delete() should have failed");
    } catch (Exception e) {
      assertEquals(expected, e.getMessage());
    }
    try {
      bulkWriter.flush();
      fail("flush() should have failed");
    } catch (Exception e) {
      assertEquals(expected, e.getMessage());
    }
    // Close is idempotent and can be called multiple time.
    bulkWriter.close();
  }

  @Test
  public void closeWillShutdownExecutor() throws Exception {
    // We ONLY shutdown executor when the executor was created within the BulkWriter.
    // To simulate this, we set the autoShutdownBulkWriterExecutor field to true.
    bulkWriter.autoShutdownBulkWriterExecutor = true;

    assertFalse(timeoutExecutor.isShutdown());
    bulkWriter.close();
    assertTrue(timeoutExecutor.isShutdown());
  }

  @Test
  public void sendsWritesToSameDocInDifferentBatches() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                successResponse(1));
            put(
                batchWrite(
                    update(
                        map(
                            "foo",
                            Value.newBuilder().setStringValue("bar").build(),
                            "boo",
                            Value.newBuilder().setStringValue("far").build()),
                        Arrays.asList("boo", "foo"),
                        com.google.firestore.v1.Precondition.newBuilder().setExists(true).build(),
                        "coll/doc1")),
                successResponse(2));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    // Create another document reference pointing to the same document.
    DocumentReference sameDoc = firestoreMock.document(doc1.getPath());
    ApiFuture<WriteResult> result1 = bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    ApiFuture<WriteResult> result2 = bulkWriter.update(sameDoc, "foo", "bar", "boo", "far");
    bulkWriter.close();

    assertEquals(Timestamp.ofTimeSecondsAndNanos(1, 0), result1.get().getUpdateTime());
    assertEquals(Timestamp.ofTimeSecondsAndNanos(2, 0), result2.get().getUpdateTime());

    responseStubber.verifyAllRequestsSent();
  }

  @Test
  public void sendWritesToDifferentDocsInSameBatch() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1"),
                    update(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc2")),
                mergeResponses(successResponse(1), successResponse(2)));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    ApiFuture<WriteResult> result1 = bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    ApiFuture<WriteResult> result2 = bulkWriter.update(doc2, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.close();

    responseStubber.verifyAllRequestsSent();
    assertEquals(Timestamp.ofTimeSecondsAndNanos(1, 0), result1.get().getUpdateTime());
    assertEquals(Timestamp.ofTimeSecondsAndNanos(2, 0), result2.get().getUpdateTime());
  }

  @Test
  public void buffersSubsequentOpsAfterReachingMaxPendingOpCount() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1"),
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc2"),
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc3")),
                mergeResponses(
                    successResponse(1),
                    successResponse(2),
                    failedResponse(Code.FAILED_PRECONDITION_VALUE)));
            put(
                batchWrite(
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc4"),
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc5")),
                mergeResponses(successResponse(4), successResponse(5)));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    bulkWriter.setMaxPendingOpCount(3);
    bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.set(doc2, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.set(firestoreMock.document("coll/doc3"), LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.set(firestoreMock.document("coll/doc4"), LocalFirestoreHelper.SINGLE_FIELD_MAP);
    assertEquals(1, bulkWriter.getBufferedOperationsCount());
    bulkWriter.set(firestoreMock.document("coll/doc5"), LocalFirestoreHelper.SINGLE_FIELD_MAP);
    assertEquals(2, bulkWriter.getBufferedOperationsCount());
    bulkWriter.close();
    responseStubber.verifyAllRequestsSent();
  }

  @Test
  public void runsSuccessHandler() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(
                    create(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1"),
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc2"),
                    update(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc3"),
                    delete("coll/doc4")),
                mergeResponses(
                    successResponse(1),
                    successResponse(2),
                    successResponse(3),
                    successResponse(4)));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    final List<Integer> writeResults = new ArrayList();
    DocumentReference doc3 = firestoreMock.document("coll/doc3");
    DocumentReference doc4 = firestoreMock.document("coll/doc4");
    bulkWriter.addWriteResultListener(
        (documentReference, result) -> writeResults.add((int) result.getUpdateTime().getSeconds()));
    bulkWriter.create(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.set(doc2, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.update(doc3, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.delete(doc4);
    bulkWriter.close();
    assertArrayEquals(new Integer[] {1, 2, 3, 4}, writeResults.toArray());
  }

  @Test
  public void retriesFailedOperationsWithGlobalErrorCallback() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(
                    create(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1"),
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc2"),
                    update(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc3"),
                    delete("coll/doc4")),
                mergeResponses(
                    successResponse(1),
                    failedResponse(Code.INTERNAL_VALUE),
                    failedResponse(Code.INTERNAL_VALUE),
                    failedResponse(Code.INTERNAL_VALUE)));
            put(
                batchWrite(
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc2"),
                    update(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc3"),
                    delete("coll/doc4")),
                mergeResponses(successResponse(2), successResponse(3), successResponse(4)));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    final List<Integer> writeResults = new ArrayList<>();
    final List<String> operations = new ArrayList<>();
    DocumentReference doc3 = firestoreMock.document("coll/doc3");
    DocumentReference doc4 = firestoreMock.document("coll/doc4");
    Executor userCallbackExecutor = Executors.newSingleThreadExecutor();
    bulkWriter.addWriteErrorListener(
        userCallbackExecutor,
        error -> {
          operations.add(error.getOperationType().name());
          return true;
        });
    bulkWriter.addWriteResultListener(
        (documentReference, result) -> {
          operations.add("SUCCESS");
          writeResults.add((int) result.getUpdateTime().getSeconds());
        });
    bulkWriter.create(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.set(doc2, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.update(doc3, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.delete(doc4);
    bulkWriter.close();
    assertArrayEquals(new Integer[] {1, 2, 3, 4}, writeResults.toArray());
    assertArrayEquals(
        new String[] {"SUCCESS", "SET", "UPDATE", "DELETE", "SUCCESS", "SUCCESS", "SUCCESS"},
        operations.toArray());
  }

  @Test
  public void errorSurfacedEvenWithRetryFunction() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(update(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                failedResponse(Code.INTERNAL_VALUE));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    final boolean[] errorListenerCalled = {false};
    bulkWriter.addWriteErrorListener(
        error -> {
          errorListenerCalled[0] = true;
          assertEquals(Status.INTERNAL, error.getStatus());
          return false;
        });

    ApiFuture<WriteResult> result = bulkWriter.update(doc1, FieldPath.of("foo"), "bar");
    bulkWriter.close();
    assertTrue(errorListenerCalled[0]);
    try {
      result.get();
      fail("Operation should have failed in test");
    } catch (Exception e) {
      assertEquals(Status.INTERNAL, ((BulkWriterException) e.getCause()).getStatus());
    }
  }

  @Test
  public void surfacesExceptionsThrownByUserProvidedErrorListener() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                failedResponse(Code.INTERNAL_VALUE));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    bulkWriter.addWriteErrorListener(
        error -> {
          throw new UnsupportedOperationException("Test code threw UnsupportedOperationException");
        });

    ApiFuture<WriteResult> result = bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.close();
    try {
      result.get();
      fail("Operation should have failed in test");
    } catch (Exception e) {
      assertTrue(e.getMessage().contains("Test code threw UnsupportedOperationException"));
    }
  }

  @Test
  public void writeFailsIfUserProvidedSuccessListenerFails() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(
                    update(
                        LocalFirestoreHelper.SINGLE_FIELD_PROTO,
                        Collections.singletonList("foo"),
                        com.google.firestore.v1.Precondition.newBuilder()
                            .setUpdateTime(com.google.protobuf.Timestamp.newBuilder().build())
                            .build(),
                        "coll/doc1")),
                successResponse(1));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    bulkWriter.addWriteResultListener(
        (documentReference, result) -> {
          throw new UnsupportedOperationException("Test code threw UnsupportedOperationException");
        });

    ApiFuture<WriteResult> result =
        bulkWriter.update(
            doc1, Precondition.updatedAt(Timestamp.ofTimeSecondsAndNanos(0, 0)), "foo", "bar");
    bulkWriter.close();
    try {
      result.get();
      fail("Operation should have failed in test");
    } catch (Exception e) {
      assertTrue(e.getMessage().contains("Test code threw UnsupportedOperationException"));
    }
  }

  @Test
  public void cannotChangeExecutorOnceWriteEnqueued() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                successResponse(2));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);
    bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    try {
      bulkWriter.addWriteResultListener(
          MoreExecutors.directExecutor(), (documentReference, result) -> {});
      fail("Operation should have failed in test");
    } catch (Exception e) {
      assertTrue(
          e.getMessage().contains("The executor cannot be changed once writes have been enqueued"));
    }

    try {
      bulkWriter.addWriteErrorListener(MoreExecutors.directExecutor(), error -> false);
      fail("Operation should have failed in test");
    } catch (Exception e) {
      assertTrue(
          e.getMessage().contains("The executor cannot be changed once writes have been enqueued"));
    }

    bulkWriter.close();
  }

  @Test
  public void retriesMultipleTimes() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                failedResponse(Code.INTERNAL_VALUE));
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                failedResponse(Code.INTERNAL_VALUE));
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                failedResponse(Code.INTERNAL_VALUE));
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                successResponse(1));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    bulkWriter.addWriteErrorListener(error -> true);

    ApiFuture<WriteResult> result1 = bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.close();
    assertEquals(Timestamp.ofTimeSecondsAndNanos(1, 0), result1.get().getUpdateTime());
  }

  @Test
  public void retriesWithSmallerBatchSize() throws Exception {

    final List<Write> writes = new ArrayList<>();
    final List<ApiFuture<BatchWriteResponse>> successResponses = new ArrayList<>();
    final List<ApiFuture<BatchWriteResponse>> failedResponses = new ArrayList<>();
    for (int i = 0; i < 15; i++) {
      writes.add(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc" + i));
      failedResponses.add(failedResponse(Code.ABORTED_VALUE));
      successResponses.add(successResponse(1));
    }

    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(writes.toArray(new Write[0])),
                mergeResponses(failedResponses.toArray(new ApiFuture[0])));
            put(
                batchWrite(
                    writes.subList(0, BulkWriter.RETRY_MAX_BATCH_SIZE).toArray(new Write[0])),
                mergeResponses(successResponses.subList(0, 10).toArray(new ApiFuture[0])));
            put(
                batchWrite(
                    writes.subList(BulkWriter.RETRY_MAX_BATCH_SIZE, 15).toArray(new Write[0])),
                mergeResponses(successResponses.subList(10, 15).toArray(new ApiFuture[0])));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    for (int i = 0; i < 15; i++) {
      bulkWriter.set(firestoreMock.document("coll/doc" + i), LocalFirestoreHelper.SINGLE_FIELD_MAP);
    }
    bulkWriter.close();
  }

  @Test
  public void retryResolvesBeforeFlush() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                failedResponse(Code.INTERNAL_VALUE));
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                successResponse(1));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    // Use separate futures to track listener completion since the callbacks are run on a different
    // thread than the BulkWriter operations.
    final SettableApiFuture<Void> flushComplete = SettableApiFuture.create();

    final List<String> operations = new ArrayList<>();
    bulkWriter.addWriteErrorListener(testExecutor, error -> true);
    bulkWriter.addWriteResultListener(testExecutor, (reference, result) -> operations.add("DOC"));

    bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter
        .flush()
        .addListener(
            () -> {
              operations.add("FLUSH");
              flushComplete.set(null);
            },
            testExecutor);
    flushComplete.get();

    assertArrayEquals(new String[] {"DOC", "FLUSH"}, operations.toArray());
  }

  @Test
  public void returnsTheErrorIfNoRetrySpecified() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                failedResponse(Code.INTERNAL_VALUE));
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                failedResponse(Code.INTERNAL_VALUE));
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                failedResponse(Code.INTERNAL_VALUE));
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                failedResponse(Code.INTERNAL_VALUE));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    bulkWriter.addWriteErrorListener(error -> error.getFailedAttempts() < 3);

    ApiFuture<WriteResult> result1 = bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.close();
    try {
      result1.get();
      fail("Operation should have failed");
    } catch (Exception e) {
      assertEquals(Status.INTERNAL, ((BulkWriterException) e.getCause()).getStatus());
    }
  }

  @Test
  public void sendBatchesWhenSizeLimitIsReached() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1"),
                    update(
                        LocalFirestoreHelper.SINGLE_FIELD_PROTO,
                        Collections.singletonList("foo"),
                        com.google.firestore.v1.Precondition.newBuilder()
                            .setUpdateTime(com.google.protobuf.Timestamp.newBuilder().build())
                            .build(),
                        "coll/doc2"),
                    create(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc3")),
                mergeResponses(successResponse(1), successResponse(2), successResponse(3)));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    bulkWriter.setMaxBatchSize(3);
    ApiFuture<WriteResult> result1 = bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    ApiFuture<WriteResult> result2 =
        bulkWriter.update(
            doc2,
            Precondition.updatedAt(Timestamp.ofTimeSecondsAndNanos(0, 0)),
            FieldPath.of("foo"),
            "bar");
    ApiFuture<WriteResult> result3 =
        bulkWriter.create(
            firestoreMock.document("coll/doc3"), LocalFirestoreHelper.SINGLE_FIELD_MAP);

    // The 4th write should not be sent because it should be in a new batch.
    bulkWriter.delete(firestoreMock.document("coll/doc4"));

    assertEquals(Timestamp.ofTimeSecondsAndNanos(1, 0), result1.get().getUpdateTime());
    assertEquals(Timestamp.ofTimeSecondsAndNanos(2, 0), result2.get().getUpdateTime());
    assertEquals(Timestamp.ofTimeSecondsAndNanos(3, 0), result3.get().getUpdateTime());
  }

  @Test
  public void retriesIndividualWritesThatFailWithAbortedOrUnavailable() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1"),
                    set(LocalFirestoreHelper.UPDATED_FIELD_PROTO, "coll/doc2"),
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc3")),
                mergeResponses(
                    failedResponse(),
                    failedResponse(Code.UNAVAILABLE_VALUE),
                    failedResponse(Code.ABORTED_VALUE)));
            put(
                batchWrite(
                    set(LocalFirestoreHelper.UPDATED_FIELD_PROTO, "coll/doc2"),
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc3")),
                mergeResponses(successResponse(2), failedResponse(Code.ABORTED_VALUE)));
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc3")),
                successResponse(3));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    // Test writes to the same document in order to verify that retry logic unaffected by document
    // key.
    ApiFuture<WriteResult> result1 = bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    ApiFuture<WriteResult> result2 = bulkWriter.set(doc2, LocalFirestoreHelper.UPDATED_FIELD_MAP);
    ApiFuture<WriteResult> result3 =
        bulkWriter.set(firestoreMock.document("coll/doc3"), LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.close();

    try {
      result1.get();
      fail("set() should have failed");
    } catch (Exception e) {
      assertTrue(e.getCause() instanceof BulkWriterException);
      assertEquals(Status.DEADLINE_EXCEEDED, ((BulkWriterException) e.getCause()).getStatus());
    }
    assertEquals(Timestamp.ofTimeSecondsAndNanos(2, 0), result2.get().getUpdateTime());
    assertEquals(Timestamp.ofTimeSecondsAndNanos(3, 0), result3.get().getUpdateTime());

    responseStubber.verifyAllRequestsSent();
  }

  @Test
  public void writesCompleteInCorrectOrderBeforeFlush() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(
                    set(
                        LocalFirestoreHelper.SINGLE_FIELD_PROTO,
                        Collections.singletonList("foo"),
                        "coll/doc1"),
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc2")),
                mergeResponses(successResponse(1), failedResponse(Code.ABORTED_VALUE)));
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc2")),
                successResponse(2));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);
    final List<String> completions = new ArrayList<>();
    final SettableApiFuture<Void> flushComplete = SettableApiFuture.create();

    bulkWriter
        .set(doc1, (Object) LocalFirestoreHelper.SINGLE_FIELD_MAP, SetOptions.merge())
        .addListener(() -> completions.add("doc1"), testExecutor);
    bulkWriter
        .set(doc2, LocalFirestoreHelper.SINGLE_FIELD_MAP)
        .addListener(() -> completions.add("doc2"), testExecutor);

    ApiFuture<Void> flush = bulkWriter.flush();
    flush.addListener(
        () -> {
          completions.add("flush");
          flushComplete.set(null);
        },
        testExecutor);

    flushComplete.get();
    assertEquals("doc1", completions.get(0));
    assertEquals("doc2", completions.get(1));
    assertEquals("flush", completions.get(2));
  }

  @Test
  public void flushCompletesWhenAllWritesComplete() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1"),
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc2"),
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc3")),
                mergeResponses(failedResponse(), successResponse(1), successResponse(1)));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    ApiFuture<WriteResult> result1 = bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    ApiFuture<WriteResult> result2 = bulkWriter.set(doc2, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    ApiFuture<WriteResult> result3 =
        bulkWriter.set(firestoreMock.document("coll/doc3"), LocalFirestoreHelper.SINGLE_FIELD_MAP);
    ApiFuture<Void> flush = bulkWriter.flush();
    try {
      result1.get();
    } catch (ExecutionException e) {
      // Ignore
    }
    result2.get();
    result3.get();
    // `flush()` should now be complete, but it might resolve a tick later since we wrap flush
    // in another future to suppress any errors.
    flush.get(100, TimeUnit.MILLISECONDS);
  }

  @Test
  public void doesNotSendBatchesIfDoingSoExceedsRateLimit() throws Exception {
    // This future is completed when the BulkWriter schedules a timeout. This test waits on the
    // future at the end of the test to ensure that the timeout was called.
    final SettableApiFuture<Void> timeoutCalledFuture = SettableApiFuture.create();

    final ScheduledExecutorService customExecutor =
        new ScheduledThreadPoolExecutor(1) {
          @Override
          @Nonnull
          public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
            if (delay > 0) {
              timeoutCalledFuture.set(null);
            }
            return super.schedule(command, 0, TimeUnit.MILLISECONDS);
          }
        };

    // Stub responses for the BulkWriter batches.
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc")),
                successResponse(5));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);
    BulkWriter bulkWriter =
        firestoreMock.bulkWriter(
            BulkWriterOptions.builder()
                .setInitialOpsPerSecond(5)
                .setExecutor(customExecutor)
                .build());

    for (int i = 0; i < 600; ++i) {
      bulkWriter.set(firestoreMock.document("coll/doc"), LocalFirestoreHelper.SINGLE_FIELD_MAP);
    }
    bulkWriter.flush();
    timeoutCalledFuture.get();
    shutdownScheduledExecutorService(customExecutor);
  }

  @Test
  public void flushSucceedsEvenIfBulkCommitFails() throws Exception {
    doReturn(FAILED_FUTURE)
        .when(firestoreMock)
        .sendRequest(
            batchWriteCapture.capture(),
            ArgumentMatchers.<UnaryCallable<BatchWriteRequest, BatchWriteResponse>>any());
    bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.set(doc2, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.flush().get();
  }

  @Test
  public void closeSucceedsEvenIfBulkCommitFails() throws Exception {
    doReturn(FAILED_FUTURE)
        .when(firestoreMock)
        .sendRequest(
            batchWriteCapture.capture(),
            ArgumentMatchers.<UnaryCallable<BatchWriteRequest, BatchWriteResponse>>any());
    bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.set(doc2, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.close();
  }

  @Test
  public void individualWritesErrorIfBulkCommitFails() throws Exception {
    doReturn(FAILED_FUTURE)
        .when(firestoreMock)
        .sendRequest(
            batchWriteCapture.capture(),
            ArgumentMatchers.<UnaryCallable<BatchWriteRequest, BatchWriteResponse>>any());
    int opCount = 0;
    ApiFuture<WriteResult> result1 = bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    ApiFuture<WriteResult> result2 = bulkWriter.set(doc2, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.close();

    for (ApiFuture<WriteResult> result : Arrays.asList(result1, result2)) {
      try {
        result.get();
      } catch (Exception e) {
        assertTrue(e.getMessage().contains("Mock batchWrite failed in test"));
        ++opCount;
      }
    }
    assertEquals(2, opCount);
  }

  @Test
  public void individualWritesErrorIfBulkCommitFailsWithNonFirestoreException() throws Exception {
    doReturn(FAILED_FUTURE)
        .when(firestoreMock)
        .sendRequest(
            batchWriteCapture.capture(),
            ArgumentMatchers.<UnaryCallable<BatchWriteRequest, BatchWriteResponse>>any());
    int opCount = 0;
    ApiFuture<WriteResult> result1 = bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    ApiFuture<WriteResult> result2 = bulkWriter.set(doc2, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.close();

    for (ApiFuture<WriteResult> result : Arrays.asList(result1, result2)) {
      try {
        result.get();
      } catch (Exception e) {
        assertTrue(
            e.getMessage()
                .contains("java.lang.IllegalStateException: Mock batchWrite failed in test"));
        ++opCount;
      }
    }
    assertEquals(2, opCount);
  }

  @Test
  public void retriesWritesWhenBatchWriteFailsWithRetryableError() throws Exception {
    doReturn(RETRYABLE_FAILED_FUTURE)
        .doReturn(RETRYABLE_FAILED_FUTURE)
        .doReturn(RETRYABLE_FAILED_FUTURE)
        .doReturn(successResponse(3))
        .when(firestoreMock)
        .sendRequest(
            batchWriteCapture.capture(),
            ArgumentMatchers.<UnaryCallable<BatchWriteRequest, BatchWriteResponse>>any());

    ApiFuture<WriteResult> result = bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.close();

    assertEquals(Timestamp.ofTimeSecondsAndNanos(3, 0), result.get().getUpdateTime());
  }

  @Test
  public void failsWritesAfterAllRetryAttemptsFail() throws Exception {
    final int[] retryAttempts = {0};
    final int[] scheduleWithDelayCount = {0};
    final ScheduledExecutorService customExecutor =
        new ScheduledThreadPoolExecutor(1) {
          @Override
          @Nonnull
          public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
            if (delay > 0) {
              int expected =
                  (int)
                      (BulkWriterOperation.DEFAULT_BACKOFF_INITIAL_DELAY_MS
                          * Math.pow(1.5, retryAttempts[0] - 1));

              assertTrue(delay >= (1 - BulkWriter.DEFAULT_JITTER_FACTOR) * expected);
              assertTrue(delay <= (1 + BulkWriter.DEFAULT_JITTER_FACTOR) * expected);
              scheduleWithDelayCount[0]++;
            }
            return super.schedule(command, 0, TimeUnit.MILLISECONDS);
          }
        };

    doAnswer(
            mock -> {
              retryAttempts[0]++;
              return RETRYABLE_FAILED_FUTURE;
            })
        .when(firestoreMock)
        .sendRequest(
            batchWriteCapture.capture(),
            ArgumentMatchers.<UnaryCallable<BatchWriteRequest, BatchWriteResponse>>any());

    bulkWriter =
        firestoreMock.bulkWriter(BulkWriterOptions.builder().setExecutor(customExecutor).build());
    ApiFuture<WriteResult> result = bulkWriter.set(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.flush().get();

    try {
      result.get();
      Assert.fail("Expected set() operation to fail");
    } catch (Exception e) {
      assertTrue(e.getMessage().contains("Mock batchWrite failed in test"));
      assertEquals(BulkWriter.MAX_RETRY_ATTEMPTS + 1, retryAttempts[0]);
      // The first attempt should not have a delay.
      assertEquals(BulkWriter.MAX_RETRY_ATTEMPTS, scheduleWithDelayCount[0]);
    } finally {
      shutdownScheduledExecutorService(customExecutor);
    }
  }

  @Test
  public void appliesMaxBackoffOnRetriesForResourceExhausted() throws Exception {
    final int[] retryAttempts = {0};
    final int[] scheduleWithDelayCount = {0};
    final ScheduledExecutorService customExecutor =
        new ScheduledThreadPoolExecutor(1) {
          @Override
          @Nonnull
          public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
            if (delay > 0) {
              assertTrue(
                  delay
                      >= (1 - BulkWriter.DEFAULT_JITTER_FACTOR)
                          * BulkWriterOperation.DEFAULT_BACKOFF_MAX_DELAY_MS);
              assertTrue(
                  delay
                      <= (1 + BulkWriter.DEFAULT_JITTER_FACTOR)
                          * BulkWriterOperation.DEFAULT_BACKOFF_MAX_DELAY_MS);
              scheduleWithDelayCount[0]++;
            }
            return super.schedule(command, 0, TimeUnit.MILLISECONDS);
          }
        };

    doAnswer(
            mock -> {
              retryAttempts[0]++;
              return RESOURCE_EXHAUSTED_FAILED_FUTURE;
            })
        .when(firestoreMock)
        .sendRequest(
            batchWriteCapture.capture(),
            ArgumentMatchers.<UnaryCallable<BatchWriteRequest, BatchWriteResponse>>any());

    bulkWriter =
        firestoreMock.bulkWriter(BulkWriterOptions.builder().setExecutor(customExecutor).build());
    bulkWriter.addWriteErrorListener(error -> error.getFailedAttempts() < 5);

    ApiFuture<WriteResult> result = bulkWriter.create(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.flush().get();

    try {
      result.get();
      Assert.fail("Expected create() operation to fail");
    } catch (Exception e) {
      assertTrue(e.getMessage().contains("Mock batchWrite failed in test"));
      assertEquals(5, retryAttempts[0]);
      // The first attempt should not have a delay.
      assertEquals(4, scheduleWithDelayCount[0]);
    } finally {
      shutdownScheduledExecutorService(customExecutor);
    }
  }

  @Test
  public void usesHighestBackoffFoundInBatch() throws Exception {
    final int[] expected = {
      BulkWriterOperation.DEFAULT_BACKOFF_MAX_DELAY_MS,
      (int)
          (BulkWriterOperation.DEFAULT_BACKOFF_INITIAL_DELAY_MS
              * BulkWriterOperation.DEFAULT_BACKOFF_FACTOR)
    };
    final int[] retryAttempts = {0};
    final ScheduledExecutorService customExecutor =
        new ScheduledThreadPoolExecutor(1) {
          @Override
          @Nonnull
          public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
            if (delay > 0) {
              // The 1st batch should have max backoff. 2nd batch should have 1 round of backoff
              // applied.
              assertTrue(
                  delay >= (1 - BulkWriter.DEFAULT_JITTER_FACTOR) * expected[retryAttempts[0]]);
              assertTrue(
                  delay <= (1 + BulkWriter.DEFAULT_JITTER_FACTOR) * expected[retryAttempts[0]]);
              retryAttempts[0]++;
            }
            return super.schedule(command, 0, TimeUnit.MILLISECONDS);
          }
        };

    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(
                    create(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1"),
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc2")),
                mergeResponses(
                    failedResponse(Code.RESOURCE_EXHAUSTED_VALUE),
                    failedResponse(Code.UNAVAILABLE_VALUE)));
            put(
                batchWrite(
                    create(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1"),
                    set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc2")),
                mergeResponses(successResponse(1), failedResponse(Code.UNAVAILABLE_VALUE)));
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc2")),
                successResponse(2));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    bulkWriter =
        firestoreMock.bulkWriter(BulkWriterOptions.builder().setExecutor(customExecutor).build());
    bulkWriter.addWriteErrorListener(error -> error.getFailedAttempts() < 5);

    bulkWriter.create(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.set(doc2, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.close();
    responseStubber.verifyAllRequestsSent();
    assertEquals(2, retryAttempts[0]);
    shutdownScheduledExecutorService(customExecutor);
  }

  @Test
  @Ignore
  public void sendsBackoffBatchAfterOtherEnqueuedBatches() throws Exception {
    ResponseStubber responseStubber =
        new ResponseStubber() {
          {
            put(
                batchWrite(create(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                failedResponse(Code.RESOURCE_EXHAUSTED_VALUE));
            put(
                batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc2")),
                successResponse(0));
            put(
                batchWrite(create(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc1")),
                successResponse(0));
          }
        };
    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    bulkWriter.addWriteErrorListener(error -> error.getFailedAttempts() < 5);
    bulkWriter.create(doc1, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.flush();
    bulkWriter.set(doc2, LocalFirestoreHelper.SINGLE_FIELD_MAP);
    bulkWriter.close();
    responseStubber.verifyAllRequestsSent();
  }

  @Test
  public void optionsRequiresPositiveInteger() throws Exception {
    try {
      firestoreMock.bulkWriter(BulkWriterOptions.builder().setInitialOpsPerSecond(-1).build());
      fail("bulkWriter() call should have failed");
    } catch (Exception e) {
      assertEquals(
          e.getMessage(),
          "Value for argument 'initialOpsPerSecond' must be greater than 1, but was: -1");
    }

    try {
      firestoreMock.bulkWriter(BulkWriterOptions.builder().setMaxOpsPerSecond(-1).build());
      fail("bulkWriter() call should have failed");
    } catch (Exception e) {
      assertEquals(
          e.getMessage(),
          "Value for argument 'maxOpsPerSecond' must be greater than 1, but was: -1");
    }
  }

  @Test
  public void optionsRequiresMaxGreaterThanInitial() throws Exception {
    try {
      firestoreMock.bulkWriter(
          BulkWriterOptions.builder().setInitialOpsPerSecond(550).setMaxOpsPerSecond(500).build());
      fail("bulkWriter() call should have failed");
    } catch (Exception e) {
      assertEquals(e.getMessage(), "'maxOpsPerSecond' cannot be less than 'initialOpsPerSecond'.");
    }
  }

  @Test
  public void cannotSetThrottlingOptionsWithThrottlingDisabled() throws Exception {
    try {
      firestoreMock.bulkWriter(
          BulkWriterOptions.builder()
              .setThrottlingEnabled(false)
              .setInitialOpsPerSecond(500)
              .build());
      fail("bulkWriter() call should have failed");
    } catch (Exception e) {
      assertEquals(
          e.getMessage(),
          "Cannot set 'initialOpsPerSecond' or 'maxOpsPerSecond' when 'throttlingEnabled' is set to"
              + " false.");
    }

    try {
      firestoreMock.bulkWriter(
          BulkWriterOptions.builder().setThrottlingEnabled(false).setMaxOpsPerSecond(500).build());
      fail("bulkWriter() call should have failed");
    } catch (Exception e) {
      assertEquals(
          e.getMessage(),
          "Cannot set 'initialOpsPerSecond' or 'maxOpsPerSecond' when 'throttlingEnabled' is set to"
              + " false.");
    }
  }

  @Test
  public void optionsInitialAndMaxRatesAreProperlySet() throws Exception {
    BulkWriter bulkWriter =
        firestoreMock.bulkWriter(
            BulkWriterOptions.builder()
                .setInitialOpsPerSecond(500)
                .setMaxOpsPerSecond(550)
                .build());
    assertEquals(bulkWriter.getRateLimiter().getInitialCapacity(), 500);
    assertEquals(bulkWriter.getRateLimiter().getMaximumRate(), 550);

    bulkWriter =
        firestoreMock.bulkWriter(BulkWriterOptions.builder().setMaxOpsPerSecond(1000).build());
    assertEquals(bulkWriter.getRateLimiter().getInitialCapacity(), 500);
    assertEquals(bulkWriter.getRateLimiter().getMaximumRate(), 1000);

    bulkWriter =
        firestoreMock.bulkWriter(BulkWriterOptions.builder().setInitialOpsPerSecond(100).build());
    assertEquals(bulkWriter.getRateLimiter().getInitialCapacity(), 100);
    assertEquals(bulkWriter.getRateLimiter().getMaximumRate(), Integer.MAX_VALUE);

    bulkWriter =
        firestoreMock.bulkWriter(BulkWriterOptions.builder().setMaxOpsPerSecond(100).build());
    assertEquals(bulkWriter.getRateLimiter().getInitialCapacity(), 100);
    assertEquals(bulkWriter.getRateLimiter().getMaximumRate(), 100);

    bulkWriter = firestoreMock.bulkWriter();
    assertEquals(
        bulkWriter.getRateLimiter().getInitialCapacity(),
        BulkWriter.DEFAULT_STARTING_MAXIMUM_OPS_PER_SECOND);
    assertEquals(bulkWriter.getRateLimiter().getMaximumRate(), Integer.MAX_VALUE);

    bulkWriter =
        firestoreMock.bulkWriter(BulkWriterOptions.builder().setThrottlingEnabled(false).build());
    assertEquals(bulkWriter.getRateLimiter().getInitialCapacity(), Integer.MAX_VALUE);
    assertEquals(bulkWriter.getRateLimiter().getMaximumRate(), Integer.MAX_VALUE);
  }

  @Test
  public void closeHandlesLargeNumberOfBufferedOps() throws Exception {
    final int numOps = 100;

    bulkWriter.setMaxPendingOpCount(5);
    bulkWriter.setMaxBatchSize(1);
    bulkWriter.autoShutdownBulkWriterExecutor = true;

    ResponseStubber responseStubber = new ResponseStubber();

    for (int i = 0; i < numOps; i += 1) {
      responseStubber.put(
          batchWrite(set(LocalFirestoreHelper.SINGLE_FIELD_PROTO, "coll/doc" + i)),
          successResponse(1));
    }

    responseStubber.initializeStub(batchWriteCapture, firestoreMock);

    for (int i = 0; i < numOps; ++i) {
      bulkWriter.set(firestoreMock.document("coll/doc" + i), LocalFirestoreHelper.SINGLE_FIELD_MAP);
    }
    bulkWriter.close();
    responseStubber.verifyAllRequestsSent();
    assertEquals(numOps, responseStubber.actualRequestList.size());
  }
}
