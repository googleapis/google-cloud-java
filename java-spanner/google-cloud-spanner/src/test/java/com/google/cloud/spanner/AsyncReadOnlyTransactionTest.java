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
import static com.google.cloud.spanner.MockSpannerTestUtil.READ_ONE_KEY_VALUE_STATEMENT;
import static com.google.cloud.spanner.MockSpannerTestUtil.TEST_DATABASE;
import static com.google.cloud.spanner.MockSpannerTestUtil.TEST_INSTANCE;
import static com.google.cloud.spanner.MockSpannerTestUtil.TEST_PROJECT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
            ((AbstractReadContext.MultiUseReadOnlyTransaction) transaction).initTransaction();
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
}
