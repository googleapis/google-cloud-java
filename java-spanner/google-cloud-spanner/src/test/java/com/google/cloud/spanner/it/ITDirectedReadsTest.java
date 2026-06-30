/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.spanner.it;

import static com.google.cloud.spanner.MockSpannerTestUtil.SELECT1;
import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.TransactionManager;
import com.google.cloud.spanner.TransactionRunner;
import com.google.common.collect.Lists;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.DirectedReadOptions.IncludeReplicas;
import com.google.spanner.v1.DirectedReadOptions.ReplicaSelection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITDirectedReadsTest {

  private static final DirectedReadOptions DIRECTED_READ_OPTIONS =
      DirectedReadOptions.newBuilder()
          .setIncludeReplicas(
              IncludeReplicas.newBuilder()
                  .addReplicaSelections(
                      ReplicaSelection.newBuilder().setLocation("us-west1").build()))
          .build();

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static Database db;

  @BeforeClass
  public static void setUp() {
    db =
        env.getTestHelper()
            .createTestDatabase("CREATE TABLE TEST (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)");
  }

  @AfterClass
  public static void tearDown() {
    db.drop();
  }

  @Test
  public void testReadWriteTransactionRunner_queryWithDirectedReadOptionsViaRequest_throwsError() {
    // Directed Read Options set at an RPC level is not acceptable for RW transaction

    assumeFalse("Emulator does not support directed reads", isUsingEmulator());
    SpannerOptions options = env.getTestHelper().getOptions().toBuilder().build();
    try (Spanner spanner = options.getService()) {
      DatabaseClient client = spanner.getDatabaseClient(db.getId());
      TransactionRunner runner = client.readWriteTransaction();
      SpannerException e =
          assertThrows(
              SpannerException.class,
              () ->
                  runner.run(
                      transaction -> {
                        try (ResultSet resultSet =
                            transaction.executeQuery(
                                SELECT1, Options.directedRead(DIRECTED_READ_OPTIONS))) {
                          while (resultSet.next()) {}
                        }
                        return null;
                      }));

      assertEquals(ErrorCode.INVALID_ARGUMENT, e.getErrorCode());
      assertTrue(
          e.getMessage()
              .contains("Directed reads can only be performed in a read-only transaction."));
    }
  }

  @Test
  public void testReadWriteTransactionRunner_readWithDirectedReadOptionsViaRequest_throwsError() {
    // Directed Read Options set at an RPC level is not acceptable for RW transaction

    assumeFalse("Emulator does not support directed reads", isUsingEmulator());
    SpannerOptions options = env.getTestHelper().getOptions().toBuilder().build();
    try (Spanner spanner = options.getService()) {
      DatabaseClient client = spanner.getDatabaseClient(db.getId());
      TransactionRunner runner = client.readWriteTransaction();
      SpannerException e =
          assertThrows(
              SpannerException.class,
              () ->
                  runner.run(
                      transaction -> {
                        try (ResultSet resultSet =
                            transaction.read(
                                "TEST",
                                KeySet.singleKey(Key.of(1L)),
                                Lists.newArrayList("NAME"),
                                Options.directedRead(DIRECTED_READ_OPTIONS))) {
                          while (resultSet.next()) {}
                        }
                        return null;
                      }));

      assertEquals(ErrorCode.INVALID_ARGUMENT, e.getErrorCode());
      assertTrue(
          e.getMessage()
              .contains("Directed reads can only be performed in a read-only transaction."));
    }
  }

  @Test
  public void testReadWriteTransactionManager_readWithDirectedReadOptionsViaRequest_throwsError() {
    // Directed Read Options set at an RPC level is not acceptable for RW transaction

    assumeFalse("Emulator does not support directed reads", isUsingEmulator());
    SpannerOptions options = env.getTestHelper().getOptions().toBuilder().build();
    try (Spanner spanner = options.getService()) {
      DatabaseClient client = spanner.getDatabaseClient(db.getId());
      try (TransactionManager manager = client.transactionManager()) {
        SpannerException e =
            assertThrows(
                SpannerException.class,
                () -> {
                  TransactionContext transaction = manager.begin();
                  try {
                    while (true) {

                      ResultSet resultSet =
                          transaction.read(
                              "TEST",
                              KeySet.singleKey(Key.of(1L)),
                              Lists.newArrayList("NAME"),
                              Options.directedRead(DIRECTED_READ_OPTIONS));
                      while (resultSet.next()) {}

                      manager.commit();
                      assertNotNull(manager.getCommitTimestamp());
                      break;
                    }
                  } catch (AbortedException ex) {
                    transaction = manager.resetForRetry();
                  }
                });
        assertEquals(ErrorCode.INVALID_ARGUMENT, e.getErrorCode());
        assertTrue(
            e.getMessage()
                .contains("Directed reads can only be performed in a read-only transaction."));
      }
    }
  }
}
