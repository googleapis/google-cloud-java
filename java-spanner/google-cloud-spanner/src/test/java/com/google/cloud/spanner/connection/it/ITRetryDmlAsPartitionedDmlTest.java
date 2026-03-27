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

package com.google.cloud.spanner.connection.it;

import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static com.google.cloud.spanner.testing.ExperimentalHostHelper.isExperimentalHost;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

import com.google.api.core.SettableApiFuture;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TransactionMutationLimitExceededException;
import com.google.cloud.spanner.connection.AutocommitDmlMode;
import com.google.cloud.spanner.connection.Connection;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest;
import com.google.cloud.spanner.connection.TransactionRetryListenerImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITRetryDmlAsPartitionedDmlTest extends ITAbstractSpannerTest {
  private static final int NUM_ROWS = 100000;

  @BeforeClass
  public static void setup() {
    // This shadows the setup() method in the super class and prevents it from being executed.
    // That allows us to have a custom setup method in this class.
    assumeFalse("Skipping the test due to a known bug b/422916293", isExperimentalHost());
  }

  @BeforeClass
  public static void setupTestData() {
    assumeFalse("The emulator does not enforce the mutation limit", isUsingEmulator());

    database =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE TEST (ID INT64 NOT NULL, NAME STRING(100) NOT NULL) PRIMARY KEY"
                    + " (ID)");
    DatabaseClient client = env.getTestHelper().getClient().getDatabaseClient(database.getId());
    int rowsCreated = 0;
    int batchSize = 5000;
    while (rowsCreated < NUM_ROWS) {
      List<Mutation> mutations = new ArrayList<>(batchSize);
      for (int row = rowsCreated; row < rowsCreated + batchSize; row++) {
        mutations.add(
            Mutation.newInsertOrUpdateBuilder("TEST")
                .set("id")
                .to(row)
                .set("name")
                .to("Row " + row)
                .build());
      }
      client.writeAtLeastOnce(mutations);
      rowsCreated += batchSize;
    }
  }

  @Test
  public void testDmlFailsIfMutationLimitExceeded() {
    // TODO(sakthivelmani) - Re-enable once b/422916293 is resolved
    assumeFalse(
        "Skipping the test due to a known bug b/422916293",
        env.getTestHelper().getOptions().isEnableDirectAccess());
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      assertThrows(
          TransactionMutationLimitExceededException.class,
          () ->
              connection.executeUpdate(
                  Statement.of("update test set name=name || ' - updated' where true")));
    }
  }

  @Test
  public void testRetryDmlAsPartitionedDml() throws Exception {
    // TODO(sakthivelmani) - Re-enable once b/422916293 is resolved
    assumeFalse(
        "Skipping the test due to a known bug b/422916293",
        env.getTestHelper().getOptions().isEnableDirectAccess());
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.setAutocommitDmlMode(
          AutocommitDmlMode.TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC);

      // Set up a listener that gets a callback when a DML statement is retried as Partitioned DML.
      SettableApiFuture<UUID> startExecutionIdFuture = SettableApiFuture.create();
      SettableApiFuture<UUID> finishedExecutionIdFuture = SettableApiFuture.create();
      SettableApiFuture<Long> lowerBoundUpdateCountFuture = SettableApiFuture.create();
      connection.addTransactionRetryListener(
          new TransactionRetryListenerImpl() {
            @Override
            public void retryDmlAsPartitionedDmlStarting(
                UUID executionId,
                Statement statement,
                TransactionMutationLimitExceededException exception) {
              startExecutionIdFuture.set(executionId);
            }

            @Override
            public void retryDmlAsPartitionedDmlFinished(
                UUID executionId, Statement statement, long updateCount) {
              finishedExecutionIdFuture.set(executionId);
              lowerBoundUpdateCountFuture.set(updateCount);
            }
          });

      long updateCount =
          connection.executeUpdate(
              Statement.of("update test set name=name || ' - updated' where true"));
      assertEquals(NUM_ROWS, updateCount);
      assertEquals(
          startExecutionIdFuture.get(1, TimeUnit.SECONDS),
          finishedExecutionIdFuture.get(1, TimeUnit.SECONDS));
      assertEquals(updateCount, lowerBoundUpdateCountFuture.get(1, TimeUnit.SECONDS).longValue());
    }
  }

  @Test
  public void testRetryDmlAsPartitionedDml_failsForLargeInserts() throws Exception {
    // TODO(sakthivelmani) - Re-enable once b/422916293 is resolved
    assumeFalse(
        "Skipping the test due to a known bug b/422916293",
        env.getTestHelper().getOptions().isEnableDirectAccess());
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.setAutocommitDmlMode(
          AutocommitDmlMode.TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC);

      // Set up a listener that gets a callback when a DML statement is retried as Partitioned DML.
      SettableApiFuture<UUID> startExecutionIdFuture = SettableApiFuture.create();
      SettableApiFuture<UUID> failedExecutionIdFuture = SettableApiFuture.create();
      SettableApiFuture<Throwable> executionExceptionFuture = SettableApiFuture.create();
      connection.addTransactionRetryListener(
          new TransactionRetryListenerImpl() {
            @Override
            public void retryDmlAsPartitionedDmlStarting(
                UUID executionId,
                Statement statement,
                TransactionMutationLimitExceededException exception) {
              startExecutionIdFuture.set(executionId);
            }

            @Override
            public void retryDmlAsPartitionedDmlFailed(
                UUID executionId, Statement statement, Throwable exception) {
              failedExecutionIdFuture.set(executionId);
              executionExceptionFuture.set(exception);
            }
          });

      // Note that the executeUpdate method throws the original
      // TransactionMutationLimitExceededException, and not the exception that is thrown when the
      // statement is retried as Partitioned DML.
      TransactionMutationLimitExceededException mutationLimitExceededException =
          assertThrows(
              TransactionMutationLimitExceededException.class,
              () ->
                  connection.executeUpdate(
                      Statement.of("insert into test (id, name) select -id, name from test")));
      assertEquals(
          startExecutionIdFuture.get(1, TimeUnit.SECONDS),
          failedExecutionIdFuture.get(1, TimeUnit.SECONDS));
      Throwable executionException = executionExceptionFuture.get(1L, TimeUnit.SECONDS);
      assertEquals(SpannerException.class, executionException.getClass());
      SpannerException spannerException = (SpannerException) executionException;
      // Verify that this exception indicates that the INSERT statement could not be executed as
      // Partitioned DML.
      assertEquals(ErrorCode.INVALID_ARGUMENT, spannerException.getErrorCode());
      assertTrue(
          spannerException.getMessage(),
          spannerException.getMessage().contains("INSERT is not supported for Partitioned DML."));
      assertEquals(1, mutationLimitExceededException.getSuppressed().length);
      assertSame(spannerException, mutationLimitExceededException.getSuppressed()[0]);
    }
  }
}
