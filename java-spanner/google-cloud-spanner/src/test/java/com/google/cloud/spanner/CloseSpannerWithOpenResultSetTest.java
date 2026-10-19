/*
 * Copyright 2024 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.cloud.spanner.spi.v1.GapicSpannerRpc;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CloseSpannerWithOpenResultSetTest extends AbstractMockServerTest {

  Spanner createSpanner() {
    return spannerOptionsBuilder().build().getService();
  }

  Spanner createSpanner(int prefetchChunks) {
    return spannerOptionsBuilder().setPrefetchChunks(prefetchChunks).build().getService();
  }

  private SpannerOptions.Builder spannerOptionsBuilder() {
    return SpannerOptions.newBuilder()
        .setProjectId("p")
        .setHost(String.format("http://localhost:%d", getPort()))
        .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
        .setCredentials(NoCredentials.getInstance())
        .setSessionPoolOption(
            SessionPoolOptions.newBuilder()
                .setWaitForMinSessionsDuration(Duration.ofSeconds(5L))
                .build());
  }

  @BeforeClass
  public static void setWatchdogTimeout() {
    System.setProperty("com.google.cloud.spanner.watchdogTimeoutSeconds", "5");
  }

  @AfterClass
  public static void clearWatchdogTimeout() {
    System.clearProperty("com.google.cloud.spanner.watchdogTimeoutSeconds");
  }

  @After
  public void cleanup() {
    mockSpanner.unfreeze();
    mockSpanner.clearRequests();
  }

  @Test
  public void testStreamsAreCleanedUp() throws Exception {
    String invalidSql = "select * from foo";
    Statement invalidStatement = Statement.of(invalidSql);
    mockSpanner.putStatementResult(
        StatementResult.exception(
            invalidStatement,
            Status.NOT_FOUND.withDescription("Table not found: foo").asRuntimeException()));
    int numThreads = 16;
    int numQueries = 32;
    try (Spanner spanner = createSpanner()) {
      BatchClient client = spanner.getBatchClient(DatabaseId.of("p", "i", "d"));
      ExecutorService service = Executors.newFixedThreadPool(numThreads);
      List<Future<?>> futures = new ArrayList<>(numQueries);
      for (int n = 0; n < numQueries; n++) {
        futures.add(
            service.submit(
                () -> {
                  try (BatchReadOnlyTransaction transaction =
                      client.batchReadOnlyTransaction(TimestampBound.strong())) {
                    if (ThreadLocalRandom.current().nextInt(10) < 2) {
                      try (ResultSet resultSet = transaction.executeQuery(invalidStatement)) {
                        SpannerException exception =
                            assertThrows(SpannerException.class, resultSet::next);
                        assertEquals(ErrorCode.NOT_FOUND, exception.getErrorCode());
                      }
                    } else {
                      try (ResultSet resultSet =
                          transaction.executeQuery(SELECT_RANDOM_STATEMENT)) {
                        while (resultSet.next()) {
                          assertNotNull(resultSet.getCurrentRowAsStruct());
                        }
                      }
                    }
                  }
                }));
      }
      service.shutdown();
      for (Future<?> fut : futures) {
        fut.get();
      }
      assertTrue(service.awaitTermination(1L, TimeUnit.MINUTES));
      // Verify that all response observers have been unregistered.
      assertEquals(
          0, ((GapicSpannerRpc) ((SpannerImpl) spanner).getRpc()).getNumActiveResponseObservers());
    }
  }

  @Test(timeout = 30000)
  public void testQueryWithPrefetchChunksOne() {
    try (Spanner spanner = createSpanner(1)) {
      DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
      for (int i = 0; i < 10; i++) {
        try (ResultSet resultSet = client.singleUse().executeQuery(SELECT_RANDOM_STATEMENT)) {
          int count = 0;
          while (resultSet.next()) {
            assertNotNull(resultSet.getCurrentRowAsStruct());
            count++;
          }
          assertTrue(count > 0);
        }
      }
      assertEquals(
          0, ((GapicSpannerRpc) ((SpannerImpl) spanner).getRpc()).getNumActiveResponseObservers());
    }
  }

  @Test(timeout = 30000)
  public void testQueryWithPrefetchChunksOneAndError() {
    String errorSql = "select * from will_fail";
    Statement errorStatement = Statement.of(errorSql);
    mockSpanner.putStatementResult(
        StatementResult.exception(
            errorStatement,
            Status.INVALID_ARGUMENT.withDescription("Invalid syntax").asRuntimeException()));
    try (Spanner spanner = createSpanner(1)) {
      DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
      try (ResultSet resultSet = client.singleUse().executeQuery(errorStatement)) {
        SpannerException exception = assertThrows(SpannerException.class, resultSet::next);
        assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
      }
      assertEquals(
          0, ((GapicSpannerRpc) ((SpannerImpl) spanner).getRpc()).getNumActiveResponseObservers());
    }
  }

  @Test(timeout = 30000)
  public void testCloseResultSetCleansUpResponseObservers() {
    try (Spanner spanner = createSpanner()) {
      DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
      // 1. Partial consumption then close:
      try (ResultSet resultSet = client.singleUse().executeQuery(SELECT_RANDOM_STATEMENT)) {
        assertTrue(resultSet.next());
        assertNotNull(resultSet.getCurrentRowAsStruct());
      }
      assertEquals(
          0, ((GapicSpannerRpc) ((SpannerImpl) spanner).getRpc()).getNumActiveResponseObservers());

      // 2. Full consumption then close:
      try (ResultSet resultSet = client.singleUse().executeQuery(SELECT_RANDOM_STATEMENT)) {
        while (resultSet.next()) {
          assertNotNull(resultSet.getCurrentRowAsStruct());
        }
      }
      assertEquals(
          0, ((GapicSpannerRpc) ((SpannerImpl) spanner).getRpc()).getNumActiveResponseObservers());
    }
  }
}
