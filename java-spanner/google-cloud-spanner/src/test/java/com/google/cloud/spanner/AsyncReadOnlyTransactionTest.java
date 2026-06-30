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

import static com.google.cloud.spanner.MockSpannerTestUtil.READ_ONE_KEY_VALUE_STATEMENT;
import static com.google.cloud.spanner.MockSpannerTestUtil.TEST_DATABASE;
import static com.google.cloud.spanner.MockSpannerTestUtil.TEST_INSTANCE;
import static com.google.cloud.spanner.MockSpannerTestUtil.TEST_PROJECT;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.NoCredentials;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import io.grpc.ManagedChannelBuilder;
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
      AsyncResultSet rs = transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT);

      // Verify that no requests have been sent yet.
      assertTrue(mockSpanner.getRequestTypes().isEmpty());

      // Now register a callback to start the stream.
      final CountDownLatch latch = new CountDownLatch(1);
      rs.setCallback(
          executor,
          resultSet -> {
            try {
              AsyncResultSet.CursorState state;
              while ((state = resultSet.tryNext()) == AsyncResultSet.CursorState.OK) {
                // consume
              }
              if (state == AsyncResultSet.CursorState.DONE) {
                latch.countDown();
              }
              return AsyncResultSet.CallbackResponse.CONTINUE;
            } catch (Throwable t) {
              latch.countDown();
              return AsyncResultSet.CallbackResponse.DONE;
            }
          });

      // Unfreeze the mock server so the background thread can proceed.
      mockSpanner.unfreeze();

      // Wait for the callback to complete.
      assertTrue("Timeout waiting for callback", latch.await(10, TimeUnit.SECONDS));

      // Verify that requests were sent on the background thread.
      // It should contain one BeginTransaction and one ExecuteSql.
      assertThat(mockSpanner.getRequestTypes())
          .containsExactly(BeginTransactionRequest.class, ExecuteSqlRequest.class);
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
      AsyncResultSet rs1 = transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT);
      AsyncResultSet rs2 = transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT);

      // Verify that no requests have been sent yet.
      assertTrue(mockSpanner.getRequestTypes().isEmpty());

      // Unfreeze the mock server.
      mockSpanner.unfreeze();

      // Now register callbacks to start the streams.
      final CountDownLatch latch1 = new CountDownLatch(1);
      final CountDownLatch latch2 = new CountDownLatch(1);

      rs1.setCallback(
          executor,
          resultSet -> {
            try {
              AsyncResultSet.CursorState state;
              while ((state = resultSet.tryNext()) == AsyncResultSet.CursorState.OK) {}
              if (state == AsyncResultSet.CursorState.DONE) {
                latch1.countDown();
              }
              return AsyncResultSet.CallbackResponse.CONTINUE;
            } catch (Throwable t) {
              latch1.countDown();
              return AsyncResultSet.CallbackResponse.DONE;
            }
          });

      rs2.setCallback(
          executor,
          resultSet -> {
            try {
              AsyncResultSet.CursorState state;
              while ((state = resultSet.tryNext()) == AsyncResultSet.CursorState.OK) {}
              if (state == AsyncResultSet.CursorState.DONE) {
                latch2.countDown();
              }
              return AsyncResultSet.CallbackResponse.CONTINUE;
            } catch (Throwable t) {
              latch2.countDown();
              return AsyncResultSet.CallbackResponse.DONE;
            }
          });

      // Wait for both callbacks to complete.
      assertTrue("Timeout waiting for callback 1", latch1.await(10, TimeUnit.SECONDS));
      assertTrue("Timeout waiting for callback 2", latch2.await(10, TimeUnit.SECONDS));

      // Verify that requests were sent.
      // It should contain one BeginTransaction and two ExecuteSql.
      assertThat(mockSpanner.getRequestTypes())
          .containsExactly(
              BeginTransactionRequest.class, ExecuteSqlRequest.class, ExecuteSqlRequest.class);
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
        RuntimeException e =
            assertThrows(
                RuntimeException.class,
                () -> transaction.executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT));
        assertEquals("Failed to get executor", e.getMessage());
      }
    }
  }
}
