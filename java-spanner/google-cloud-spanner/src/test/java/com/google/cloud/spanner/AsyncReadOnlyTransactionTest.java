/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner;

import static com.google.cloud.spanner.MockSpannerServiceImpl.NO_EXECUTION_TIME;
import static com.google.cloud.spanner.MockSpannerTestUtil.INVALID_UPDATE_STATEMENT;
import static com.google.cloud.spanner.MockSpannerTestUtil.READ_COLUMN_NAMES;
import static com.google.cloud.spanner.MockSpannerTestUtil.READ_MULTIPLE_KEY_VALUE_STATEMENT;
import static com.google.cloud.spanner.MockSpannerTestUtil.READ_ONE_KEY_VALUE_STATEMENT;
import static com.google.cloud.spanner.MockSpannerTestUtil.READ_TABLE_NAME;
import static com.google.cloud.spanner.MockSpannerTestUtil.TEST_DATABASE;
import static com.google.cloud.spanner.MockSpannerTestUtil.TEST_INSTANCE;
import static com.google.cloud.spanner.MockSpannerTestUtil.TEST_PROJECT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.spi.v1.GapicSpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ReadRequest;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.AdditionalAnswers;

@RunWith(JUnit4.class)
public class AsyncReadOnlyTransactionTest extends AbstractAsyncTransactionTest {

  @Test
  public void asyncReadOnlyTransactionIsNonBlocking() throws Exception {
    // Warm up session pool to avoid CreateSession blocking when server is frozen.
    try (ResultSet resultSet = client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (resultSet.next()) {}
    }
    mockSpanner.reset();

    try (ReadOnlyTransaction transaction = client().readOnlyTransaction()) {
      mockSpanner.freeze();
      // Call executeQueryAsync. It should not block even though mock server is
      // frozen!
      AsyncResultSet resultSet = transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT);

      // Verify that no requests have been sent yet.
      assertTrue(mockSpanner.getRequestTypes().isEmpty());

      // Now register a callback to start the stream.
      final CountDownLatch callbackLatch = new CountDownLatch(1);
      resultSet.setCallback(
          executor,
          ignored -> {
            try {
              AsyncResultSet.CursorState state;
              while ((state = resultSet.tryNext()) == AsyncResultSet.CursorState.OK) {
                // consume
              }
              if (state == AsyncResultSet.CursorState.DONE) {
                callbackLatch.countDown();
              }
              return AsyncResultSet.CallbackResponse.CONTINUE;
            } catch (Throwable throwable) {
              callbackLatch.countDown();
              return AsyncResultSet.CallbackResponse.DONE;
            }
          });

      // Unfreeze the mock server so the background thread can proceed.
      mockSpanner.unfreeze();

      // Wait for the callback to complete.
      assertTrue("Timeout waiting for callback", callbackLatch.await(10, TimeUnit.SECONDS));

      // Verify that requests were sent on the background thread.
      // It should contain one BeginTransaction and one ExecuteSql.
      assertEquals(
          Arrays.asList(BeginTransactionRequest.class, ExecuteSqlRequest.class),
          mockSpanner.getRequestTypes());
    }
  }

  @Test
  public void testMultipleQueriesOnlyCallsBeginTransactionOnce() throws Exception {
    // Warm up session pool to avoid CreateSession blocking when server is frozen.
    try (ResultSet resultSet = client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (resultSet.next()) {}
    }
    mockSpanner.reset();

    try (ReadOnlyTransaction transaction = client().readOnlyTransaction()) {
      mockSpanner.freeze();
      // Call executeQueryAsync twice.
      AsyncResultSet resultSet1 = transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT);
      AsyncResultSet resultSet2 = transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT);

      // Verify that no requests have been sent yet.
      assertTrue(mockSpanner.getRequestTypes().isEmpty());

      // Unfreeze the mock server.
      mockSpanner.unfreeze();

      // Now register callbacks to start the streams.
      final CountDownLatch callbackLatch1 = new CountDownLatch(1);
      final CountDownLatch callbackLatch2 = new CountDownLatch(1);

      resultSet1.setCallback(
          executor,
          ignored -> {
            try {
              AsyncResultSet.CursorState state;
              while ((state = resultSet1.tryNext()) == AsyncResultSet.CursorState.OK) {}
              if (state == AsyncResultSet.CursorState.DONE) {
                callbackLatch1.countDown();
              }
              return AsyncResultSet.CallbackResponse.CONTINUE;
            } catch (Throwable throwable) {
              callbackLatch1.countDown();
              return AsyncResultSet.CallbackResponse.DONE;
            }
          });

      resultSet2.setCallback(
          executor,
          ignored -> {
            try {
              AsyncResultSet.CursorState state;
              while ((state = resultSet2.tryNext()) == AsyncResultSet.CursorState.OK) {}
              if (state == AsyncResultSet.CursorState.DONE) {
                callbackLatch2.countDown();
              }
              return AsyncResultSet.CallbackResponse.CONTINUE;
            } catch (Throwable throwable) {
              callbackLatch2.countDown();
              return AsyncResultSet.CallbackResponse.DONE;
            }
          });

      // Wait for both callbacks to complete.
      assertTrue("Timeout waiting for callback 1", callbackLatch1.await(10, TimeUnit.SECONDS));
      assertTrue("Timeout waiting for callback 2", callbackLatch2.await(10, TimeUnit.SECONDS));

      // Verify that requests were sent.
      // It should contain one BeginTransaction and two ExecuteSql.
      assertEquals(
          Arrays.asList(
              BeginTransactionRequest.class, ExecuteSqlRequest.class, ExecuteSqlRequest.class),
          mockSpanner.getRequestTypes());
    }
  }

  @Test(timeout = 5000)
  public void createAsyncResultSet_handlesExceptionCorrectly() throws Exception {
    SpannerOptions.CloseableExecutorProvider mockExecutorProvider =
        mock(SpannerOptions.CloseableExecutorProvider.class);
    when(mockExecutorProvider.getExecutor())
        .thenThrow(new RuntimeException("Failed to get executor"));

    String endpoint = address.getHostString() + ":" + server.getPort();
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId(TEST_PROJECT)
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setHost("http://" + endpoint)
            .setCredentials(NoCredentials.getInstance())
            .setAsyncExecutorProvider(mockExecutorProvider)
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setFailOnSessionLeak()
                    .setWaitForMinSessions(org.threeten.bp.Duration.ofSeconds(2))
                    .build())
            .build();

    try (Spanner testSpanner = options.getService()) {
      DatabaseClient client =
          testSpanner.getDatabaseClient(DatabaseId.of(TEST_PROJECT, TEST_INSTANCE, TEST_DATABASE));
      try (ReadOnlyTransaction transaction = client.readOnlyTransaction()) {
        RuntimeException exception =
            assertThrows(
                RuntimeException.class,
                () -> transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT));
        assertEquals("Failed to get executor", exception.getMessage());
      }
    }
  }

  @Test
  public void closeAsyncIsNonBlockingWhenServerIsFrozen() throws Exception {
    // Warm up session pool to avoid CreateSession blocking when server is frozen.
    try (ResultSet resultSet = client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (resultSet.next()) {}
    }
    mockSpanner.clearRequests();

    ReadOnlyTransaction transaction = client().readOnlyTransaction();
    mockSpanner.freeze();

    // Call executeQueryAsync and register callback.
    // This starts InitiateStreamingRunnable in the background executor, which calls
    // BeginTransaction.
    AsyncResultSet resultSet = transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT);
    final CountDownLatch callbackLatch = new CountDownLatch(1);
    resultSet.setCallback(
        executor,
        ignored -> {
          try {
            AsyncResultSet.CursorState state;
            while ((state = resultSet.tryNext()) == AsyncResultSet.CursorState.OK) {}
            if (state == AsyncResultSet.CursorState.DONE) {
              callbackLatch.countDown();
            }
            return AsyncResultSet.CallbackResponse.CONTINUE;
          } catch (Throwable throwable) {
            callbackLatch.countDown();
            return AsyncResultSet.CallbackResponse.DONE;
          }
        });

    // Calling closeAsync() must return an ApiFuture immediately without blocking the calling
    // thread,
    // even though the mock server is frozen and BeginTransaction is in flight.
    ApiFuture<Void> closeFuture = transaction.closeAsync();

    // Deterministic assertion: closeFuture is NOT done yet because BeginTransaction is still
    // blocked in mockSpanner.
    assertFalse(closeFuture.isDone());

    // Unfreeze mock server so BeginTransaction and query execution can proceed.
    mockSpanner.unfreeze();

    // Wait for callback and closeFuture.
    assertTrue("Timeout waiting for callback", callbackLatch.await(10, TimeUnit.SECONDS));
    closeFuture.get(10, TimeUnit.SECONDS);
    assertTrue(closeFuture.isDone());

    // Verify that requests were sent.
    assertEquals(
        Arrays.asList(BeginTransactionRequest.class, ExecuteSqlRequest.class),
        mockSpanner.getRequestTypes());
  }

  @Test
  public void closeAsyncWithoutQueriesCompletesImmediately() throws Exception {
    try (ResultSet resultSet = client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (resultSet.next()) {}
    }
    try (ReadOnlyTransaction transaction = client().readOnlyTransaction()) {
      ApiFuture<Void> closeFuture = transaction.closeAsync();
      assertTrue(closeFuture.isDone());
    }
  }

  @Test
  public void closeAsyncIsIdempotent() throws Exception {
    try (ResultSet resultSet = client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (resultSet.next()) {}
    }
    ReadOnlyTransaction transaction = client().readOnlyTransaction();
    ApiFuture<Void> closeFuture1 = transaction.closeAsync();
    ApiFuture<Void> closeFuture2 = transaction.closeAsync();
    assertSame(closeFuture1, closeFuture2);
    assertTrue(closeFuture1.isDone());
    assertTrue(closeFuture2.isDone());
    closeFuture1.get(10, TimeUnit.SECONDS);
    closeFuture2.get(10, TimeUnit.SECONDS);
  }

  @Test
  public void queryAfterCloseAsyncThrowsException() throws Exception {
    try (ResultSet resultSet = client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (resultSet.next()) {}
    }
    ReadOnlyTransaction transaction = client().readOnlyTransaction();
    ApiFuture<Void> closeFuture = transaction.closeAsync();
    closeFuture.get(10, TimeUnit.SECONDS);

    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () -> transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT));
    assertEquals("Context has been closed", exception.getMessage());
  }

  @Test
  public void closeAsyncWithUnusedResultSetClosedCompletesWithoutHang() throws Exception {
    try (ResultSet resultSet = client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (resultSet.next()) {}
    }
    ReadOnlyTransaction transaction = client().readOnlyTransaction();
    AsyncResultSet resultSet = transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT);
    // User closes resultSet without attaching callback or starting stream
    resultSet.close();
    ApiFuture<Void> closeFuture = transaction.closeAsync();
    closeFuture.get(10, TimeUnit.SECONDS);
    assertTrue(closeFuture.isDone());
  }

  @Test
  public void syncCloseDelegatesToCloseAsyncAndWaitsForPendingStarts() throws Exception {
    try (ResultSet resultSet = client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (resultSet.next()) {}
    }
    mockSpanner.clearRequests();

    ReadOnlyTransaction transaction = client().readOnlyTransaction();
    AsyncResultSet resultSet = transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT);
    final CountDownLatch callbackLatch = new CountDownLatch(1);
    resultSet.setCallback(
        executor,
        ignored -> {
          try {
            AsyncResultSet.CursorState state;
            while ((state = resultSet.tryNext()) == AsyncResultSet.CursorState.OK) {}
            if (state == AsyncResultSet.CursorState.DONE) {
              callbackLatch.countDown();
            }
            return AsyncResultSet.CallbackResponse.CONTINUE;
          } catch (Throwable throwable) {
            callbackLatch.countDown();
            return AsyncResultSet.CallbackResponse.DONE;
          }
        });

    // Synchronous close() should complete successfully once background query finishes.
    transaction.close();
    assertTrue("Timeout waiting for callback", callbackLatch.await(10, TimeUnit.SECONDS));
    assertEquals(
        Arrays.asList(BeginTransactionRequest.class, ExecuteSqlRequest.class),
        mockSpanner.getRequestTypes());
  }

  @Test
  public void multipleConcurrentInFlightQueriesCloseAsyncWaitsForAll() throws Exception {
    try (ResultSet resultSet = client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (resultSet.next()) {}
    }
    mockSpanner.clearRequests();

    ReadOnlyTransaction transaction = client().readOnlyTransaction();
    mockSpanner.freeze();

    AsyncResultSet resultSet1 = transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT);
    AsyncResultSet resultSet2 = transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT);
    AsyncResultSet resultSet3 = transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT);

    final CountDownLatch callbackLatch1 = new CountDownLatch(1);
    final CountDownLatch callbackLatch2 = new CountDownLatch(1);
    final CountDownLatch callbackLatch3 = new CountDownLatch(1);

    resultSet1.setCallback(
        executor,
        ignored -> {
          try {
            AsyncResultSet.CursorState state;
            while ((state = resultSet1.tryNext()) == AsyncResultSet.CursorState.OK) {}
            if (state == AsyncResultSet.CursorState.DONE) {
              callbackLatch1.countDown();
            }
            return AsyncResultSet.CallbackResponse.CONTINUE;
          } catch (Throwable throwable) {
            callbackLatch1.countDown();
            return AsyncResultSet.CallbackResponse.DONE;
          }
        });

    resultSet2.setCallback(
        executor,
        ignored -> {
          try {
            AsyncResultSet.CursorState state;
            while ((state = resultSet2.tryNext()) == AsyncResultSet.CursorState.OK) {}
            if (state == AsyncResultSet.CursorState.DONE) {
              callbackLatch2.countDown();
            }
            return AsyncResultSet.CallbackResponse.CONTINUE;
          } catch (Throwable throwable) {
            callbackLatch2.countDown();
            return AsyncResultSet.CallbackResponse.DONE;
          }
        });

    resultSet3.setCallback(
        executor,
        ignored -> {
          try {
            AsyncResultSet.CursorState state;
            while ((state = resultSet3.tryNext()) == AsyncResultSet.CursorState.OK) {}
            if (state == AsyncResultSet.CursorState.DONE) {
              callbackLatch3.countDown();
            }
            return AsyncResultSet.CallbackResponse.CONTINUE;
          } catch (Throwable throwable) {
            callbackLatch3.countDown();
            return AsyncResultSet.CallbackResponse.DONE;
          }
        });

    ApiFuture<Void> closeFuture = transaction.closeAsync();
    assertFalse(closeFuture.isDone());

    mockSpanner.unfreeze();

    assertTrue("Timeout waiting for callback 1", callbackLatch1.await(10, TimeUnit.SECONDS));
    assertTrue("Timeout waiting for callback 2", callbackLatch2.await(10, TimeUnit.SECONDS));
    assertTrue("Timeout waiting for callback 3", callbackLatch3.await(10, TimeUnit.SECONDS));

    closeFuture.get(10, TimeUnit.SECONDS);
    assertTrue(closeFuture.isDone());

    assertEquals(
        Arrays.asList(
            BeginTransactionRequest.class,
            ExecuteSqlRequest.class,
            ExecuteSqlRequest.class,
            ExecuteSqlRequest.class),
        mockSpanner.getRequestTypes());
  }

  @Test
  public void syncQueriesAfterCloseAsyncThrowException() throws Exception {
    try (ResultSet resultSet = client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (resultSet.next()) {}
    }
    ReadOnlyTransaction transaction = client().readOnlyTransaction();
    ApiFuture<Void> closeFuture = transaction.closeAsync();
    closeFuture.get(10, TimeUnit.SECONDS);

    IllegalStateException executeQueryException =
        assertThrows(
            IllegalStateException.class,
            () -> transaction.executeQuery(READ_ONE_KEY_VALUE_STATEMENT));
    assertEquals("Context has been closed", executeQueryException.getMessage());

    IllegalStateException readException =
        assertThrows(
            IllegalStateException.class,
            () ->
                transaction.read(
                    "TestTable",
                    KeySet.singleKey(Key.of("k1")),
                    Collections.singletonList("Value")));
    assertEquals("Context has been closed", readException.getMessage());

    IllegalStateException readRowException =
        assertThrows(
            IllegalStateException.class,
            () ->
                transaction.readRow("TestTable", Key.of("k1"), Collections.singletonList("Value")));
    assertEquals("Context has been closed", readRowException.getMessage());

    IllegalStateException analyzeQueryException =
        assertThrows(
            IllegalStateException.class,
            () ->
                transaction.analyzeQuery(
                    READ_ONE_KEY_VALUE_STATEMENT, ReadContext.QueryAnalyzeMode.PLAN));
    assertEquals("Context has been closed", analyzeQueryException.getMessage());
  }

  @Test
  public void closeAsyncIsIdempotentDuringInFlightQuery() throws Exception {
    try (ResultSet resultSet = client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (resultSet.next()) {}
    }
    mockSpanner.clearRequests();

    ReadOnlyTransaction transaction = client().readOnlyTransaction();
    mockSpanner.freeze();

    AsyncResultSet resultSet = transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT);
    final CountDownLatch callbackLatch = new CountDownLatch(1);
    resultSet.setCallback(
        executor,
        ignored -> {
          try {
            AsyncResultSet.CursorState state;
            while ((state = resultSet.tryNext()) == AsyncResultSet.CursorState.OK) {}
            if (state == AsyncResultSet.CursorState.DONE) {
              callbackLatch.countDown();
            }
            return AsyncResultSet.CallbackResponse.CONTINUE;
          } catch (Throwable throwable) {
            callbackLatch.countDown();
            return AsyncResultSet.CallbackResponse.DONE;
          }
        });

    ApiFuture<Void> closeFuture1 = transaction.closeAsync();
    ApiFuture<Void> closeFuture2 = transaction.closeAsync();

    assertSame(closeFuture1, closeFuture2);
    assertFalse(closeFuture1.isDone());

    mockSpanner.unfreeze();

    assertTrue("Timeout waiting for callback", callbackLatch.await(10, TimeUnit.SECONDS));
    closeFuture1.get(10, TimeUnit.SECONDS);
    closeFuture2.get(10, TimeUnit.SECONDS);

    assertTrue(closeFuture1.isDone());
    assertTrue(closeFuture2.isDone());
  }

  @Test
  public void closeAsyncCompletesWhenBeginTransactionFails() throws Exception {
    try (ResultSet resultSet = client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (resultSet.next()) {}
    }
    mockSpanner.clearRequests();

    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofException(
            Status.UNAVAILABLE.withDescription("Service unavailable").asRuntimeException()));

    try {
      ReadOnlyTransaction transaction = client().readOnlyTransaction();
      AsyncResultSet resultSet = transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT);
      final CountDownLatch callbackLatch = new CountDownLatch(1);
      resultSet.setCallback(
          executor,
          ignored -> {
            try {
              AsyncResultSet.CursorState state;
              while ((state = resultSet.tryNext()) == AsyncResultSet.CursorState.OK) {}
              if (state == AsyncResultSet.CursorState.DONE) {
                callbackLatch.countDown();
              }
              return AsyncResultSet.CallbackResponse.CONTINUE;
            } catch (Throwable throwable) {
              callbackLatch.countDown();
              return AsyncResultSet.CallbackResponse.DONE;
            }
          });

      ApiFuture<Void> closeFuture = transaction.closeAsync();

      assertTrue("Timeout waiting for callback", callbackLatch.await(10, TimeUnit.SECONDS));
      closeFuture.get(10, TimeUnit.SECONDS);
      assertTrue(closeFuture.isDone());
    } finally {
      mockSpanner.setBeginTransactionExecutionTime(NO_EXECUTION_TIME);
    }
  }

  @Test
  public void closeAsyncWhileBeginTransactionIsInFlightWaitsForBeginTransactionToFinish()
      throws Exception {
    try (ResultSet resultSet = client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (resultSet.next()) {}
    }
    mockSpanner.clearRequests();

    ReadOnlyTransaction transaction = client().readOnlyTransaction();
    mockSpanner.freeze();

    final CountDownLatch initStartedLatch = new CountDownLatch(1);
    final CountDownLatch initFinishedLatch = new CountDownLatch(1);
    executor.execute(
        () -> {
          initStartedLatch.countDown();
          try {
            ((MultiUseReadOnlyTransaction) transaction).initTransaction();
          } finally {
            initFinishedLatch.countDown();
          }
        });

    assertTrue(
        "Timeout waiting for init thread to start", initStartedLatch.await(10, TimeUnit.SECONDS));

    mockSpanner.waitForRequestsToContain(BeginTransactionRequest.class, 10_000);

    ApiFuture<Void> closeFuture = transaction.closeAsync();

    assertFalse(closeFuture.isDone());

    mockSpanner.unfreeze();

    assertTrue("Timeout waiting for init to finish", initFinishedLatch.await(10, TimeUnit.SECONDS));
    closeFuture.get(10, TimeUnit.SECONDS);
    assertTrue(closeFuture.isDone());

    assertEquals(
        Collections.singletonList(BeginTransactionRequest.class), mockSpanner.getRequestTypes());
  }

  @Test
  public void readAsyncWithCloseAsyncWaitsForQueryToFinish() throws Exception {
    try (ResultSet resultSet = client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (resultSet.next()) {}
    }
    mockSpanner.clearRequests();

    ReadOnlyTransaction transaction = client().readOnlyTransaction();
    mockSpanner.freeze();

    AsyncResultSet resultSet =
        transaction.readAsync("TestTable", KeySet.all(), Collections.singletonList("Value"));
    final CountDownLatch callbackLatch = new CountDownLatch(1);
    resultSet.setCallback(
        executor,
        ignored -> {
          try {
            AsyncResultSet.CursorState state;
            while ((state = resultSet.tryNext()) == AsyncResultSet.CursorState.OK) {}
            if (state == AsyncResultSet.CursorState.DONE) {
              callbackLatch.countDown();
            }
            return AsyncResultSet.CallbackResponse.CONTINUE;
          } catch (Throwable throwable) {
            callbackLatch.countDown();
            return AsyncResultSet.CallbackResponse.DONE;
          }
        });

    ApiFuture<Void> closeFuture = transaction.closeAsync();
    assertFalse(closeFuture.isDone());

    mockSpanner.unfreeze();

    assertTrue("Timeout waiting for callback", callbackLatch.await(10, TimeUnit.SECONDS));
    closeFuture.get(10, TimeUnit.SECONDS);
    assertTrue(closeFuture.isDone());
  }

  @Test
  public void readUsingIndexAsyncWithCloseAsyncWaitsForQueryToFinish() throws Exception {
    try (ResultSet resultSet = client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (resultSet.next()) {}
    }
    mockSpanner.clearRequests();

    ReadOnlyTransaction transaction = client().readOnlyTransaction();
    mockSpanner.freeze();

    AsyncResultSet resultSet =
        transaction.readUsingIndexAsync(
            "TestTable", "TestIndex", KeySet.all(), Collections.singletonList("Value"));
    final CountDownLatch callbackLatch = new CountDownLatch(1);
    resultSet.setCallback(
        executor,
        ignored -> {
          try {
            AsyncResultSet.CursorState state;
            while ((state = resultSet.tryNext()) == AsyncResultSet.CursorState.OK) {}
            if (state == AsyncResultSet.CursorState.DONE) {
              callbackLatch.countDown();
            }
            return AsyncResultSet.CallbackResponse.CONTINUE;
          } catch (Throwable throwable) {
            callbackLatch.countDown();
            return AsyncResultSet.CallbackResponse.DONE;
          }
        });

    ApiFuture<Void> closeFuture = transaction.closeAsync();
    assertFalse(closeFuture.isDone());

    mockSpanner.unfreeze();

    assertTrue("Timeout waiting for callback", callbackLatch.await(10, TimeUnit.SECONDS));
    closeFuture.get(10, TimeUnit.SECONDS);
    assertTrue(closeFuture.isDone());
  }

  @Test
  public void closeAsyncThenCloseUnusedAsyncResultSetCompletesCleanly() throws Exception {
    try (ResultSet resultSet = client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (resultSet.next()) {}
    }
    ReadOnlyTransaction transaction = client().readOnlyTransaction();
    AsyncResultSet resultSet = transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT);
    ApiFuture<Void> closeFuture = transaction.closeAsync();
    assertFalse(closeFuture.isDone());
    resultSet.close();
    closeFuture.get(10, TimeUnit.SECONDS);
    assertTrue(closeFuture.isDone());
  }

  @Test
  public void closeAsyncWithInlinedBeginTransaction() throws Exception {
    try (ResultSet resultSet = client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (resultSet.next()) {}
    }
    mockSpanner.clearRequests();

    ReadOnlyTransaction transaction =
        client()
            .readOnlyTransaction(
                TimestampBound.strong(),
                Options.beginTransactionOption(Options.BeginTransactionOption.INLINE));
    mockSpanner.freeze();

    AsyncResultSet resultSet = transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT);
    final CountDownLatch callbackLatch = new CountDownLatch(1);
    final AtomicReference<Throwable> callbackError = new AtomicReference<>();
    resultSet.setCallback(
        executor,
        ignored -> {
          try {
            AsyncResultSet.CursorState state;
            while ((state = resultSet.tryNext()) == AsyncResultSet.CursorState.OK) {}
            if (state == AsyncResultSet.CursorState.DONE) {
              callbackLatch.countDown();
            }
            return AsyncResultSet.CallbackResponse.CONTINUE;
          } catch (Throwable throwable) {
            callbackError.set(throwable);
            callbackLatch.countDown();
            return AsyncResultSet.CallbackResponse.DONE;
          }
        });

    ApiFuture<Void> closeFuture = transaction.closeAsync();
    assertFalse(closeFuture.isDone());

    mockSpanner.unfreeze();

    assertTrue("Timeout waiting for callback", callbackLatch.await(10, TimeUnit.SECONDS));
    assertNull(callbackError.get());
    assertNotNull(transaction.getReadTimestamp());
    closeFuture.get(10, TimeUnit.SECONDS);
    assertTrue(closeFuture.isDone());
  }

  private SpannerOptions createSpannerOptionsWithFailingStart(
      AtomicBoolean failNextStreamingQuery,
      AtomicBoolean failNextStreamingRead,
      Runnable beforeReadFailure) {
    String endpoint = address.getHostString() + ":" + server.getPort();
    return SpannerOptions.newBuilder()
        .setProjectId(TEST_PROJECT)
        .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
        .setHost("http://" + endpoint)
        .setCredentials(NoCredentials.getInstance())
        .setServiceRpcFactory(
            spannerOptions -> {
              SpannerRpc delegate = new GapicSpannerRpc(spannerOptions);
              SpannerRpc spannerRpc =
                  mock(SpannerRpc.class, AdditionalAnswers.delegatesTo(delegate));
              doAnswer(
                      invocation -> {
                        if (failNextStreamingQuery.compareAndSet(true, false)) {
                          throw new IllegalStateException("unexpected runtime start failure");
                        }
                        Map<SpannerRpc.Option, ?> rpcOptions = invocation.getArgument(2);
                        return delegate.executeQuery(
                            invocation.getArgument(0),
                            invocation.getArgument(1),
                            rpcOptions,
                            invocation.getArgument(3),
                            invocation.getArgument(4));
                      })
                  .when(spannerRpc)
                  .executeQuery(
                      any(ExecuteSqlRequest.class),
                      any(SpannerRpc.ResultStreamConsumer.class),
                      any(),
                      any(XGoogSpannerRequestId.class),
                      anyBoolean());
              doAnswer(
                      invocation -> {
                        if (failNextStreamingRead.compareAndSet(true, false)) {
                          beforeReadFailure.run();
                          throw new IllegalStateException("unexpected runtime read start failure");
                        }
                        Map<SpannerRpc.Option, ?> rpcOptions = invocation.getArgument(2);
                        return delegate.read(
                            invocation.getArgument(0),
                            invocation.getArgument(1),
                            rpcOptions,
                            invocation.getArgument(3),
                            invocation.getArgument(4));
                      })
                  .when(spannerRpc)
                  .read(
                      any(ReadRequest.class),
                      any(SpannerRpc.ResultStreamConsumer.class),
                      any(),
                      any(XGoogSpannerRequestId.class),
                      anyBoolean());
              return spannerRpc;
            })
        .build();
  }

  @Test(timeout = 10000)
  public void inlinedBeginStreamStartFailureCompletesTransactionIdFutureWithError()
      throws Exception {
    AtomicBoolean failNextStreamingQuery = new AtomicBoolean(false);
    AtomicBoolean failNextStreamingRead = new AtomicBoolean(false);
    CountDownLatch readStartEnteredLatch = new CountDownLatch(1);
    CountDownLatch followerStartedLatch = new CountDownLatch(1);
    AtomicReference<Thread> followerThread = new AtomicReference<>();
    AtomicBoolean followerFinished = new AtomicBoolean(false);
    SpannerOptions options =
        createSpannerOptionsWithFailingStart(
            failNextStreamingQuery,
            failNextStreamingRead,
            () -> {
              readStartEnteredLatch.countDown();
              try {
                assertTrue(followerStartedLatch.await(5, TimeUnit.SECONDS));
              } catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(interruptedException);
              }
              while (followerThread.get().getState() != Thread.State.TIMED_WAITING
                  && !followerFinished.get()) {
                Thread.yield();
              }
            });

    try (Spanner customSpanner = options.getService()) {
      DatabaseClient customClient =
          customSpanner.getDatabaseClient(
              DatabaseId.of(TEST_PROJECT, TEST_INSTANCE, TEST_DATABASE));
      try (ResultSet warmupResultSet =
          customClient.singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
        while (warmupResultSet.next()) {}
      }
      failNextStreamingQuery.set(true);
      ReadOnlyTransaction transaction =
          customClient.readOnlyTransaction(
              TimestampBound.strong(),
              Options.beginTransactionOption(Options.BeginTransactionOption.INLINE));

      try (ResultSet resultSet = transaction.executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
        SpannerException firstException = assertThrows(SpannerException.class, resultSet::next);
        assertEquals(ErrorCode.UNKNOWN, firstException.getErrorCode());

        // Even before the first ResultSet is closed, a subsequent query on the same transaction
        // must fail immediately with a SpannerException wrapping the start error rather than
        // hanging waiting on transactionIdFuture.
        try (ResultSet secondResultSet = transaction.executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
          SpannerException exception = assertThrows(SpannerException.class, secondResultSet::next);
          assertEquals(ErrorCode.UNKNOWN, exception.getErrorCode());
          assertTrue(exception.getMessage().contains("unexpected runtime start failure"));
        }

        // Calling initFallbackTransaction() (used for multiplexed session partitionRead /
        // partitionQuery fallback, which is the other consumer of transactionIdFuture in
        // MultiUseReadOnlyTransaction) must also convert the raw Throwable in transactionIdFuture
        // to a SpannerException via asSpannerException.
        SpannerException initException =
            assertThrows(
                SpannerException.class,
                () -> ((MultiUseReadOnlyTransaction) transaction).initFallbackTransaction());
        assertEquals(ErrorCode.UNKNOWN, initException.getErrorCode());
        assertTrue(initException.getMessage().contains("unexpected runtime start failure"));
      }

      ApiFuture<Void> closeFuture = transaction.closeAsync();
      closeFuture.get(10, TimeUnit.SECONDS);
      assertTrue(closeFuture.isDone());

      // Also verify an inlined-begin Read failing synchronously while a concurrent follower query
      // is actively blocked waiting on transactionIdFuture.
      failNextStreamingRead.set(true);
      ReadOnlyTransaction readTransaction =
          customClient.readOnlyTransaction(
              TimestampBound.strong(),
              Options.beginTransactionOption(Options.BeginTransactionOption.INLINE));
      Future<SpannerException> followerFailureFuture =
          executor.submit(
              () -> {
                try {
                  assertTrue(readStartEnteredLatch.await(5, TimeUnit.SECONDS));
                  followerThread.set(Thread.currentThread());
                  try (ResultSet followerResultSet =
                      readTransaction.executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
                    followerStartedLatch.countDown();
                    return assertThrows(SpannerException.class, followerResultSet::next);
                  }
                } finally {
                  followerFinished.set(true);
                }
              });
      try (ResultSet readResultSet =
          readTransaction.read(READ_TABLE_NAME, KeySet.all(), READ_COLUMN_NAMES)) {
        SpannerException leaderException =
            assertThrows(SpannerException.class, readResultSet::next);
        assertEquals(ErrorCode.UNKNOWN, leaderException.getErrorCode());
        assertTrue(leaderException.getMessage().contains("unexpected runtime read start failure"));
      }

      SpannerException followerException = followerFailureFuture.get(5, TimeUnit.SECONDS);
      assertEquals(ErrorCode.UNKNOWN, followerException.getErrorCode());
      assertTrue(followerException.getMessage().contains("unexpected runtime read start failure"));
      readTransaction.closeAsync().get(10, TimeUnit.SECONDS);

      // When a MultiUseReadOnlyTransaction does not use inlined begin (withBeginTransaction ==
      // false), or when a subsequent statement fails synchronously after the inlined-begin
      // statement has already succeeded, the transaction remains usable for subsequent queries.
      try (ReadOnlyTransaction secondTransaction =
          customClient.readOnlyTransaction(
              TimestampBound.strong(),
              Options.beginTransactionOption(Options.BeginTransactionOption.INLINE))) {
        try (ResultSet firstResultSet =
            secondTransaction.executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
          while (firstResultSet.next()) {}
        }
        assertNotNull(secondTransaction.getReadTimestamp());

        failNextStreamingQuery.set(true);
        try (ResultSet failingResultSet =
            secondTransaction.executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
          SpannerException exception = assertThrows(SpannerException.class, failingResultSet::next);
          assertEquals(ErrorCode.UNKNOWN, exception.getErrorCode());
        }
        try (ResultSet subsequentResultSet =
            secondTransaction.executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
          while (subsequentResultSet.next()) {}
        }
      }
    }
  }

  @Test
  public void inlinedBeginReadOnlyTransactionStreamRetriesWithMockSpanner() {
    try (ResultSet warmupResultSet =
        client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (warmupResultSet.next()) {}
    }

    // 1. Stream retry before receiving a resume token (errorIndex == 0): both requests must carry
    // BeginTransaction(ReadOnly).
    mockSpanner.clearRequests();
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStreamException(Status.UNAVAILABLE.asRuntimeException(), 0));
    try (ReadOnlyTransaction transaction =
        client()
            .readOnlyTransaction(
                TimestampBound.strong(),
                Options.beginTransactionOption(Options.BeginTransactionOption.INLINE))) {
      int rowCount = 0;
      try (ResultSet resultSet = transaction.executeQuery(READ_MULTIPLE_KEY_VALUE_STATEMENT)) {
        while (resultSet.next()) {
          rowCount++;
        }
      }
      assertEquals(3, rowCount);
      assertNotNull(transaction.getReadTimestamp());

      try (ResultSet readResultSet =
          transaction.read(READ_TABLE_NAME, KeySet.all(), READ_COLUMN_NAMES)) {
        int readRowCount = 0;
        while (readResultSet.next()) {
          readRowCount++;
        }
        assertEquals(3, readRowCount);
      }
    }
    assertEquals(0, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    List<ExecuteSqlRequest> firstRunSqlRequests =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(2, firstRunSqlRequests.size());
    assertTrue(firstRunSqlRequests.get(0).getTransaction().getBegin().hasReadOnly());
    assertTrue(firstRunSqlRequests.get(0).getResumeToken().isEmpty());
    assertTrue(firstRunSqlRequests.get(1).getTransaction().getBegin().hasReadOnly());
    assertTrue(firstRunSqlRequests.get(1).getResumeToken().isEmpty());
    List<ReadRequest> firstRunReadRequests = mockSpanner.getRequestsOfType(ReadRequest.class);
    assertEquals(1, firstRunReadRequests.size());
    assertFalse(firstRunReadRequests.get(0).getTransaction().hasBegin());
    assertFalse(firstRunReadRequests.get(0).getTransaction().getId().isEmpty());

    // 2. Stream retry on executeQuery after receiving a resume token (errorIndex == 1): the first
    // ExecuteSqlRequest carries BeginTransaction(ReadOnly), while the resumed request switches to
    // the allocated transaction ID so it does not start a second read-only transaction.
    mockSpanner.clearRequests();
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStreamException(Status.UNAVAILABLE.asRuntimeException(), 1));
    try (ReadOnlyTransaction transaction =
        client()
            .readOnlyTransaction(
                TimestampBound.strong(),
                Options.beginTransactionOption(Options.BeginTransactionOption.INLINE))) {
      int rowCount = 0;
      try (ResultSet resultSet = transaction.executeQuery(READ_MULTIPLE_KEY_VALUE_STATEMENT)) {
        while (resultSet.next()) {
          rowCount++;
        }
      }
      assertEquals(3, rowCount);
      assertNotNull(transaction.getReadTimestamp());
    }
    assertEquals(0, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    List<ExecuteSqlRequest> secondRunSqlRequests =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(2, secondRunSqlRequests.size());
    assertTrue(secondRunSqlRequests.get(0).getTransaction().getBegin().hasReadOnly());
    assertTrue(secondRunSqlRequests.get(0).getResumeToken().isEmpty());
    assertFalse(secondRunSqlRequests.get(1).getTransaction().hasBegin());
    assertFalse(secondRunSqlRequests.get(1).getTransaction().getId().isEmpty());
    assertFalse(secondRunSqlRequests.get(1).getResumeToken().isEmpty());

    // 3. Stream retry on read after receiving a resume token (errorIndex == 1): the first
    // ReadRequest carries BeginTransaction(ReadOnly), while the resumed ReadRequest switches to
    // the allocated transaction ID.
    mockSpanner.clearRequests();
    mockSpanner.setStreamingReadExecutionTime(
        SimulatedExecutionTime.ofStreamException(Status.UNAVAILABLE.asRuntimeException(), 1));
    try (ReadOnlyTransaction transaction =
        client()
            .readOnlyTransaction(
                TimestampBound.strong(),
                Options.beginTransactionOption(Options.BeginTransactionOption.INLINE))) {
      int rowCount = 0;
      try (ResultSet resultSet =
          transaction.read(READ_TABLE_NAME, KeySet.all(), READ_COLUMN_NAMES)) {
        while (resultSet.next()) {
          rowCount++;
        }
      }
      assertEquals(3, rowCount);
      assertNotNull(transaction.getReadTimestamp());
    }
    assertEquals(0, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    List<ReadRequest> thirdRunReadRequests = mockSpanner.getRequestsOfType(ReadRequest.class);
    assertEquals(2, thirdRunReadRequests.size());
    assertTrue(thirdRunReadRequests.get(0).getTransaction().getBegin().hasReadOnly());
    assertTrue(thirdRunReadRequests.get(0).getResumeToken().isEmpty());
    assertFalse(thirdRunReadRequests.get(1).getTransaction().hasBegin());
    assertFalse(thirdRunReadRequests.get(1).getTransaction().getId().isEmpty());
    assertFalse(thirdRunReadRequests.get(1).getResumeToken().isEmpty());
  }

  @Test(timeout = 10000)
  public void inlinedBeginReadOnlyTransactionServerErrorCompletesTransactionIdFuture()
      throws Exception {
    try (ResultSet warmupResultSet =
        client().singleUse().executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
      while (warmupResultSet.next()) {}
    }
    mockSpanner.clearRequests();

    ReadOnlyTransaction transaction =
        client()
            .readOnlyTransaction(
                TimestampBound.strong(),
                Options.beginTransactionOption(Options.BeginTransactionOption.INLINE));
    try (ResultSet resultSet = transaction.executeQuery(INVALID_UPDATE_STATEMENT)) {
      SpannerException firstException = assertThrows(SpannerException.class, resultSet::next);
      assertEquals(ErrorCode.INVALID_ARGUMENT, firstException.getErrorCode());

      try (ResultSet secondResultSet = transaction.executeQuery(READ_ONE_KEY_VALUE_STATEMENT)) {
        SpannerException secondException =
            assertThrows(SpannerException.class, secondResultSet::next);
        assertEquals(ErrorCode.INVALID_ARGUMENT, secondException.getErrorCode());
      }
    }
    ApiFuture<Void> closeFuture = transaction.closeAsync();
    closeFuture.get(10, TimeUnit.SECONDS);
    assertTrue(closeFuture.isDone());
  }
}
