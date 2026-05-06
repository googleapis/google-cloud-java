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

import static org.junit.Assert.assertNull;

import com.google.api.core.ApiFuture;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.AsyncTransactionManager.TransactionContextFuture;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.cloud.spanner.connection.RandomResultSetGenerator;
import com.google.common.base.Function;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.RollbackRequest;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class OrphanedTransactionTest extends AbstractMockServerTest {
  private static final Statement STATEMENT = Statement.of("SELECT * FROM random");

  @BeforeClass
  public static void setupReadResult() {
    com.google.cloud.spanner.connection.RandomResultSetGenerator generator =
        new RandomResultSetGenerator(10);
    mockSpanner.putStatementResult(StatementResult.query(STATEMENT, generator.generate()));
  }

  private Spanner createSpanner() {
    return SpannerOptions.newBuilder()
        .setProjectId("fake-project")
        .setHost("http://localhost:" + getPort())
        .setCredentials(NoCredentials.getInstance())
        .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
        .setSessionPoolOption(
            SessionPoolOptions.newBuilder().setWaitForMinSessions(Duration.ofSeconds(5L)).build())
        .build()
        .getService();
  }

  @Test
  public void testOrphanedTransaction() throws Exception {
    ExecutorService executor = Executors.newCachedThreadPool();
    try (Spanner spanner = createSpanner()) {
      DatabaseClient client =
          spanner.getDatabaseClient(
              DatabaseId.of("fake-project", "fake-instance", "fake-database"));
      // Freeze the mock server to ensure that the request lands on the mock server before we
      // proceed.
      mockSpanner.freeze();
      AsyncTransactionManager manager = client.transactionManagerAsync();
      TransactionContextFuture context = manager.beginAsync();
      context.then(
          (txn, input) -> {
            try (AsyncResultSet resultSet = txn.executeQueryAsync(STATEMENT)) {
              resultSet.toListAsync(
                  (Function<StructReader, Object>)
                      row -> Objects.requireNonNull(row).getValue(0).getAsString(),
                  executor);
            }
            return null;
          },
          executor);
      // Wait for the ExecuteSqlRequest to land on the mock server.
      mockSpanner.waitForRequestsToContain(
          input ->
              input instanceof ExecuteSqlRequest
                  && ((ExecuteSqlRequest) input).getSql().equals(STATEMENT.getSql()),
          5000L);
      // Now close the transaction. This should (eventually) trigger a rollback, even though the
      // client has not yet received a transaction ID.
      manager.closeAsync();
      // Unfreeze the mock server and wait for the Rollback request to be received.
      mockSpanner.unfreeze();
      mockSpanner.waitForLastRequestToBe(RollbackRequest.class, 5000L);
    } finally {
      executor.shutdown();
    }
  }

  @Test
  public void testOrphanedTransactionWithFailedFirstQuery() throws Exception {
    ExecutorService executor = Executors.newCachedThreadPool();
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofException(
            Status.INVALID_ARGUMENT.withDescription("table not found").asRuntimeException()));
    try (Spanner spanner = createSpanner()) {
      DatabaseClient client =
          spanner.getDatabaseClient(
              DatabaseId.of("fake-project", "fake-instance", "fake-database"));
      // Freeze the mock server to ensure that the request lands on the mock server before we
      // proceed.
      mockSpanner.freeze();
      AsyncTransactionManager manager = client.transactionManagerAsync();
      TransactionContextFuture context = manager.beginAsync();
      context.then(
          (txn, input) -> {
            try (AsyncResultSet resultSet = txn.executeQueryAsync(STATEMENT)) {
              resultSet.toListAsync(
                  (Function<StructReader, Object>)
                      row -> Objects.requireNonNull(row).getValue(0).getAsString(),
                  executor);
            }
            return null;
          },
          executor);
      // Wait for the ExecuteSqlRequest to land on the mock server.
      mockSpanner.waitForRequestsToContain(
          input ->
              input instanceof ExecuteSqlRequest
                  && ((ExecuteSqlRequest) input).getSql().equals(STATEMENT.getSql()),
          5000L);
      // Now close the transaction. This will not trigger a Rollback, as the statement failed.
      // The closeResult will be done when the error for the failed statement is returned to the
      // client.
      ApiFuture<Void> closeResult = manager.closeAsync();
      mockSpanner.unfreeze();
      assertNull(closeResult.get());
    } finally {
      executor.shutdown();
    }
  }
}
