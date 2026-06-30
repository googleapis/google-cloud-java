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

import static com.google.cloud.spanner.SpannerApiFutures.get;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.SpannerOptions.CallContextConfigurator;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.cloud.spanner.connection.RandomResultSetGenerator;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.SpannerGrpc;
import io.grpc.Context;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LocationAwareTest extends AbstractMockServerTest {
  private static final Statement SELECT_RANDOM_STATEMENT = Statement.of("select * from random");
  private static final int RANDOM_RESULT_ROW_COUNT = 20;
  private static Spanner spanner;
  private static DatabaseClient client;

  private static final class TimeoutHolder {
    private Duration timeout;
  }

  @BeforeClass
  public static void enableLocationApiAndSetupClient() {
    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public boolean isEnableLocationApi() {
            return true;
          }
        });
    spanner =
        SpannerOptions.newBuilder()
            .setProjectId("my-project")
            .setHost(String.format("http://localhost:%d", getPort()))
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getService();
    client = spanner.getDatabaseClient(DatabaseId.of("my-project", "my-instance", "my-database"));

    RandomResultSetGenerator generator = new RandomResultSetGenerator(RANDOM_RESULT_ROW_COUNT);
    mockSpanner.putStatementResult(
        StatementResult.query(SELECT_RANDOM_STATEMENT, generator.generate()));
  }

  @AfterClass
  public static void cleanup() {
    SpannerOptions.useDefaultEnvironment();
    if (spanner != null) {
      spanner.close();
    }
  }

  @Test
  public void testSingleQuery() {
    int rowCount = 0;
    try (ResultSet resultSet = client.singleUse().executeQuery(SELECT_RANDOM_STATEMENT)) {
      while (resultSet.next()) {
        rowCount++;
      }
    }
    assertEquals(RANDOM_RESULT_ROW_COUNT, rowCount);
  }

  @Test
  public void testParallelQueries() throws Exception {
    int numThreads = 10;
    ListeningExecutorService executor =
        MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(numThreads));
    List<ListenableFuture<Void>> results = new ArrayList<>();
    for (int i = 0; i < numThreads; i++) {
      results.add(
          executor.submit(
              () -> {
                try (ResultSet resultSet =
                    client.singleUse().executeQuery(SELECT_RANDOM_STATEMENT)) {
                  while (resultSet.next()) {
                    // Randomly stop consuming results somewhere halfway the results (sometimes).
                    if (ThreadLocalRandom.current().nextInt(RANDOM_RESULT_ROW_COUNT * 2) == 5) {
                      break;
                    }
                  }
                }
                return null;
              }));
    }
    executor.shutdown();
    Futures.allAsList(results).get();
  }

  @Test
  public void testSingleReadWriteTransaction() {
    client.readWriteTransaction().run(transaction -> transaction.executeUpdate(INSERT_STATEMENT));
  }

  @Test
  public void testParallelReadWriteTransactions() throws Exception {
    int numThreads = 10;
    ListeningExecutorService executor =
        MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(numThreads));
    List<ListenableFuture<Void>> results = new ArrayList<>();
    for (int i = 0; i < numThreads; i++) {
      results.add(
          executor.submit(
              () -> {
                client
                    .readWriteTransaction()
                    .run(transaction -> transaction.executeUpdate(INSERT_STATEMENT));
                return null;
              }));
    }
    executor.shutdown();
    Futures.allAsList(results).get();
  }

  @Test
  public void testExecuteStreamingSqlCallContextTimeout_locationAware() {
    final TimeoutHolder timeoutHolder = new TimeoutHolder();
    CallContextConfigurator configurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            if (request instanceof ExecuteSqlRequest
                && method.equals(SpannerGrpc.getExecuteStreamingSqlMethod())) {
              return context.withTimeoutDuration(timeoutHolder.timeout);
            }
            return null;
          }
        };

    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofMinimumAndRandomTime(10, 0));
    Context context =
        Context.current().withValue(SpannerOptions.CALL_CONTEXT_CONFIGURATOR_KEY, configurator);
    try {
      context.run(
          () -> {
            timeoutHolder.timeout = Duration.ofNanos(1L);
            SpannerException e =
                assertThrows(
                    SpannerException.class,
                    () -> {
                      try (ResultSet rs =
                          client.singleUse().executeQuery(SELECT_RANDOM_STATEMENT)) {
                        rs.next();
                      }
                    });
            assertEquals(ErrorCode.DEADLINE_EXCEEDED, e.getErrorCode());

            timeoutHolder.timeout = Duration.ofMinutes(1L);
            try (ResultSet rs = client.singleUse().executeQuery(SELECT_RANDOM_STATEMENT)) {
              assertTrue(rs.next());
            }
          });
    } finally {
      mockSpanner.removeAllExecutionTimes();
    }
  }

  @Test
  public void testExecuteStreamingSqlInvalidArgumentPropagates_locationAware() {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofException(
            Status.INVALID_ARGUMENT.withDescription("invalid request").asRuntimeException()));
    try {
      SpannerException e =
          assertThrows(
              SpannerException.class,
              () -> {
                try (ResultSet rs = client.singleUse().executeQuery(SELECT_RANDOM_STATEMENT)) {
                  rs.next();
                }
              });
      assertEquals(ErrorCode.INVALID_ARGUMENT, e.getErrorCode());
    } finally {
      mockSpanner.removeAllExecutionTimes();
    }
  }

  @Test
  public void testExecuteQueryAsyncCancelReturnsCancelled_locationAware() throws Exception {
    final List<Integer> values = new LinkedList<>();
    final CountDownLatch receivedFirstRow = new CountDownLatch(1);
    final CountDownLatch cancelled = new CountDownLatch(1);
    final ApiFuture<Void> callbackResult;

    ExecutorService executor = Executors.newSingleThreadExecutor();
    try (AsyncResultSet rs = client.singleUse().executeQueryAsync(SELECT_RANDOM_STATEMENT)) {
      callbackResult =
          rs.setCallback(
              executor,
              resultSet -> {
                try {
                  while (true) {
                    switch (resultSet.tryNext()) {
                      case DONE:
                        return CallbackResponse.DONE;
                      case NOT_READY:
                        return CallbackResponse.CONTINUE;
                      case OK:
                        values.add(1);
                        receivedFirstRow.countDown();
                        cancelled.await();
                        break;
                    }
                  }
                } catch (Throwable t) {
                  return CallbackResponse.DONE;
                }
              });

      assertTrue(receivedFirstRow.await(30L, TimeUnit.SECONDS));
      rs.cancel();
      cancelled.countDown();
      SpannerException e = assertThrows(SpannerException.class, () -> get(callbackResult));
      assertEquals(ErrorCode.CANCELLED, e.getErrorCode());
      assertEquals(1, values.size());
    } finally {
      executor.shutdownNow();
    }
  }
}
