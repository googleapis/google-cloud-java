/*
 * Copyright 2017 Google LLC
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

import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerException;
import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.BatchClient;
import com.google.cloud.spanner.BatchReadOnlyTransaction;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.PartitionOptions;
import com.google.cloud.spanner.ReadContext;
import com.google.cloud.spanner.ReadOnlyTransaction;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.SpannerOptions.Builder.DefaultReadWriteTransactionOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.TransactionRunner;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import com.google.cloud.spanner.testing.EmulatorSpannerHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import com.google.spanner.v1.TransactionOptions.ReadWrite.ReadLockMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for read-write transactions. */
@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITTransactionTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static Database db;
  private static DatabaseClient client;
  private static Database largeMessageDb;
  private static DatabaseClient largeMessageClient;

  /** Sequence for assigning unique keys to test cases. */
  private static int seq;

  @BeforeClass
  public static void setUpDatabase() {
    db =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE T ("
                    + "  K    STRING(MAX) NOT NULL,"
                    + "  V    INT64,"
                    + ") PRIMARY KEY (K)");
    client = env.getTestHelper().getDatabaseClient(db);

    largeMessageDb =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE T ("
                    + "  K    STRING(MAX) NOT NULL,"
                    + "  col0    BYTES(MAX),"
                    + "  col1    BYTES(MAX),"
                    + "  col2    BYTES(MAX),"
                    + "  col3    BYTES(MAX),"
                    + "  col4    BYTES(MAX),"
                    + "  col5    BYTES(MAX),"
                    + "  col6    BYTES(MAX),"
                    + "  col7    BYTES(MAX),"
                    + "  col8    BYTES(MAX),"
                    + "  col9    BYTES(MAX),"
                    + ") PRIMARY KEY (K)");
    largeMessageClient = env.getTestHelper().getDatabaseClient(largeMessageDb);
  }

  @Before
  public void removeTestData() {
    client.writeAtLeastOnce(Collections.singletonList(Mutation.delete("T", KeySet.all())));
    largeMessageClient.writeAtLeastOnce(
        Collections.singletonList(Mutation.delete("T", KeySet.all())));
  }

  private static String uniqueKey() {
    return "k" + seq++;
  }

  private interface ReadStrategy {
    Struct read(ReadContext ctx, String key);
  }

  private void doBasicsTest(final ReadStrategy strategy) throws InterruptedException {
    final String key = uniqueKey();

    // Initial value.
    client.write(
        Collections.singletonList(
            Mutation.newInsertBuilder("T").set("K").to(key).set("V").to(0).build()));

    final int numThreads = 3;

    final CountDownLatch commitBarrier = new CountDownLatch(numThreads);
    final CountDownLatch complete = new CountDownLatch(numThreads);

    final TransactionCallable<Long> callable =
        transaction -> {
          Struct row = strategy.read(transaction, key);
          long newValue = row.getLong(0) + 1;
          transaction.buffer(
              Mutation.newUpdateBuilder("T").set("K").to(key).set("V").to(newValue).build());
          commitBarrier.countDown();
          // Synchronize so that all threads attempt to commit at the same time.
          Uninterruptibles.awaitUninterruptibly(commitBarrier);
          return newValue;
        };

    // We start multiple threads all attempting to update the same value concurrently.  We expect
    // to see at least some of the corresponding transactions abort.
    final Vector<Long> results = new Vector<>();
    final Vector<Timestamp> commitTimestamps = new Vector<>();
    class TxnThread extends Thread {
      @Override
      public void run() {
        TransactionRunner runner = client.readWriteTransaction();
        Long result = runner.run(callable);
        results.add(result);
        commitTimestamps.add(runner.getCommitTimestamp());
        complete.countDown();
      }
    }
    for (int i = 0; i < numThreads; ++i) {
      new TxnThread().start();
    }
    complete.await();

    assertThat(results).hasSize(numThreads);
    List<Long> expectedResults = new ArrayList<>();
    for (int i = 0; i < numThreads; ++i) {
      expectedResults.add(i + 1L);
    }
    assertThat(results).containsAtLeastElementsIn(expectedResults);
    assertThat(Sets.newHashSet(commitTimestamps)).hasSize(numThreads);

    assertThat(
            client
                .singleUse(TimestampBound.strong())
                .readRow("T", Key.of(key), Collections.singletonList("V"))
                .getLong(0))
        .isEqualTo((long) numThreads);
  }

  @Test
  public void basicsUsingRead() throws InterruptedException {
    assumeFalse("Emulator does not support multiple parallel transactions", isUsingEmulator());

    doBasicsTest(
        (context, key) -> context.readRow("T", Key.of(key), Collections.singletonList("V")));
  }

  @Test
  public void basicsUsingQuery() throws InterruptedException {
    assumeFalse("Emulator does not support multiple parallel transactions", isUsingEmulator());

    doBasicsTest(
        (context, key) -> {
          ResultSet resultSet =
              context.executeQuery(
                  Statement.newBuilder("SELECT V FROM T WHERE K = @key")
                      .bind("key")
                      .to(key)
                      .build());
          assertThat(resultSet.next()).isTrue();
          Struct row = resultSet.getCurrentRowAsStruct();
          assertThat(resultSet.next()).isFalse();
          return row;
        });
  }

  @Test
  public void isolationLevelAndReadLockModeSetAtClientLevelTest() {
    SpannerOptions options =
        env.getTestHelper().getOptions().toBuilder()
            .setDefaultTransactionOptions(
                DefaultReadWriteTransactionOptions.newBuilder()
                    .setIsolationLevel(IsolationLevel.REPEATABLE_READ)
                    .setReadLockMode(ReadLockMode.OPTIMISTIC)
                    .build())
            .build();
    try (Spanner spanner = options.getService()) {
      DatabaseClient client = spanner.getDatabaseClient(db.getId());
      Long updatedRows =
          client
              .readWriteTransaction()
              .run(
                  transaction ->
                      transaction.executeUpdate(
                          Statement.of("INSERT INTO T (K, V) VALUES ('test1', 2)")));
      assertThat(updatedRows).isEqualTo(1L);
    }
  }

  @Test
  public void isolationLevelAndReadLockModeSetAtClientAndTxnLevelTest() {
    SpannerOptions options =
        env.getTestHelper().getOptions().toBuilder()
            .setDefaultTransactionOptions(
                DefaultReadWriteTransactionOptions.newBuilder()
                    .setIsolationLevel(IsolationLevel.REPEATABLE_READ)
                    .setReadLockMode(ReadLockMode.OPTIMISTIC)
                    .build())
            .build();
    try (Spanner spanner = options.getService()) {
      DatabaseClient client = spanner.getDatabaseClient(db.getId());
      Long updatedRows =
          client
              .readWriteTransaction(
                  Options.isolationLevel(IsolationLevel.SERIALIZABLE),
                  Options.readLockMode(ReadLockMode.PESSIMISTIC))
              .run(
                  transaction ->
                      transaction.executeUpdate(
                          Statement.of("INSERT INTO T (K, V) VALUES ('test1', 2)")));
      assertThat(updatedRows).isEqualTo(1L);
    }
  }

  @Test
  public void userExceptionPreventsCommit() {
    class UserException extends Exception {
      UserException(String message) {
        super(message);
      }
    }

    final String key = uniqueKey();

    TransactionCallable<Void> callable =
        transaction -> {
          transaction.buffer(Mutation.newInsertOrUpdateBuilder("T").set("K").to(key).build());
          throw new UserException("User failure");
        };

    try {
      client.readWriteTransaction().run(callable);
      fail("Expected user exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.UNKNOWN);
      assertThat(e.getMessage()).contains("User failure");
      assertThat(e.getCause()).isInstanceOf(UserException.class);
    }

    Struct row =
        client
            .singleUse(TimestampBound.strong())
            .readRow("T", Key.of(key), Collections.singletonList("K"));
    assertThat(row).isNull();
  }

  @Test
  public void userExceptionIsSpannerException() {
    final String key = uniqueKey();

    TransactionCallable<Void> callable =
        transaction -> {
          transaction.buffer(Mutation.newInsertOrUpdateBuilder("T").set("K").to(key).build());
          throw newSpannerException(ErrorCode.OUT_OF_RANGE, "User failure");
        };

    try {
      client.readWriteTransaction().run(callable);
      fail("Expected user exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.OUT_OF_RANGE);
      assertThat(e.getMessage()).contains("User failure");
    }

    Struct row =
        client
            .singleUse(TimestampBound.strong())
            .readRow("T", Key.of(key), Collections.singletonList("K"));
    assertThat(row).isNull();
  }

  @Test
  public void readAbort() throws Exception {
    assumeFalse("Emulator does not support multiple parallel transactions", isUsingEmulator());

    final String key1 = uniqueKey();
    final String key2 = uniqueKey();

    client.write(
        Arrays.asList(
            Mutation.newInsertBuilder("T").set("K").to(key1).set("V").to(0).build(),
            Mutation.newInsertBuilder("T").set("K").to(key2).set("V").to(1).build()));

    final CountDownLatch t1Started = new CountDownLatch(1);
    final CountDownLatch t1Done = new CountDownLatch(1);
    final CountDownLatch t2Running = new CountDownLatch(1);
    final CountDownLatch t2Done = new CountDownLatch(1);

    final SettableFuture<Void> t1Result = SettableFuture.create();
    final SettableFuture<Void> t2Result = SettableFuture.create();

    // Thread 1 performs a read before notifying that it has started and allowing
    // thread 2 to start.  This ensures that it establishes a senior lock priority relative to
    // thread 2.  It then waits for thread 2 to read, so that both threads have shared locks on
    // key1, before continuing to commit; the act of committing means that thread 1's lock is
    // upgraded and thread 2's transaction is aborted.  When thread 1 is done, thread 2 tries a
    // second read, which will abort.  Both threads will mask SpannerExceptions to ensure that
    // the implementation does not require TransactionCallable to propagate them.
    Thread t1 =
        new Thread(
            () -> {
              try {
                client
                    .readWriteTransaction()
                    .run(
                        transaction -> {
                          try {
                            Struct row =
                                transaction.readRow(
                                    "T", Key.of(key1), Collections.singletonList("V"));
                            t1Started.countDown();
                            Uninterruptibles.awaitUninterruptibly(t2Running);
                            transaction.buffer(
                                Mutation.newUpdateBuilder("T")
                                    .set("K")
                                    .to(key1)
                                    .set("V")
                                    .to(row.getLong(0) + 1)
                                    .build());
                            return null;
                          } catch (SpannerException e) {
                            if (e.getErrorCode() == ErrorCode.ABORTED) {
                              assertThat(e).isInstanceOf(AbortedException.class);
                            }
                            throw new RuntimeException("Swallowed exception: " + e.getMessage());
                          }
                        });
                t1Result.set(null);
              } catch (Throwable t) {
                t1Result.setException(t);
              } finally {
                t1Done.countDown();
              }
            });
    Thread t2 =
        new Thread(
            () -> {
              try {
                client
                    .readWriteTransaction()
                    .run(
                        transaction -> {
                          try {
                            Struct r1 =
                                transaction.readRow(
                                    "T", Key.of(key1), Collections.singletonList("V"));
                            t2Running.countDown();
                            Uninterruptibles.awaitUninterruptibly(t1Done);
                            Struct r2 =
                                transaction.readRow(
                                    "T", Key.of(key2), Collections.singletonList("V"));
                            transaction.buffer(
                                Mutation.newUpdateBuilder("T")
                                    .set("K")
                                    .to(key2)
                                    .set("V")
                                    .to(r1.getLong(0) + r2.getLong(0))
                                    .build());
                            return null;
                          } catch (SpannerException e) {
                            if (e.getErrorCode() == ErrorCode.ABORTED) {
                              assertThat(e).isInstanceOf(AbortedException.class);
                            }
                            throw new RuntimeException("Swallowed exception: " + e.getMessage());
                          }
                        });
                t2Result.set(null);
              } catch (Throwable t) {
                t2Result.setException(t);
              } finally {
                t2Done.countDown();
              }
            });

    t1.start();
    Uninterruptibles.awaitUninterruptibly(t1Started);
    // Thread 2 will abort on the first attempt and should retry; wait for completion to confirm.
    t2.start();
    assertThat(t2Done.await(1, TimeUnit.MINUTES)).isTrue();

    // Check that both transactions effects are visible.
    assertThat(t1Result.get()).isNull();
    assertThat(t2Result.get()).isNull();
    assertThat(
            client
                .singleUse(TimestampBound.strong())
                .readRow("T", Key.of(key1), Collections.singletonList("V"))
                .getLong(0))
        .isEqualTo(1);
    assertThat(
            client
                .singleUse(TimestampBound.strong())
                .readRow("T", Key.of(key2), Collections.singletonList("V"))
                .getLong(0))
        .isEqualTo(2);
  }

  private void doNestedRwTransaction() {
    client
        .readWriteTransaction()
        .run(
            transaction -> {
              client.readWriteTransaction().run(transaction1 -> null);

              return null;
            });
  }

  @Test
  public void nestedReadWriteTxnThrows() {
    try {
      doNestedRwTransaction();
      fail("Expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INTERNAL);
      assertThat(e.getMessage()).contains("not supported");
    }
  }

  @Test
  public void nestedReadOnlyTxnThrows() {
    try {
      client
          .readWriteTransaction()
          .run(
              transaction -> {
                try (ReadOnlyTransaction tx = client.readOnlyTransaction()) {
                  tx.getReadTimestamp();
                }

                return null;
              });
      fail("Expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INTERNAL);
      assertThat(e.getMessage()).contains("not supported");
    }
  }

  @Test
  public void nestedBatchTxnThrows() {
    try {
      client
          .readWriteTransaction()
          .run(
              transaction -> {
                BatchClient batchClient = env.getTestHelper().getBatchClient(db);
                BatchReadOnlyTransaction batchTxn =
                    batchClient.batchReadOnlyTransaction(TimestampBound.strong());
                batchTxn.partitionReadUsingIndex(
                    PartitionOptions.getDefaultInstance(),
                    "Test",
                    "Index",
                    KeySet.all(),
                    Collections.singletonList("Fingerprint"));

                return null;
              });
      fail("Expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INTERNAL);
      assertThat(e.getMessage()).contains("not supported");
    }
  }

  @Test
  public void nestedSingleUseReadTxnThrows() {
    try {
      client
          .readWriteTransaction()
          .run(
              transaction -> {
                try (ResultSet rs =
                    client.singleUseReadOnlyTransaction().executeQuery(Statement.of("SELECT 1"))) {
                  rs.next();
                }

                return null;
              });
      fail("Expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INTERNAL);
      assertThat(e.getMessage()).contains("not supported");
    }
  }

  @Test
  public void nestedTxnSucceedsWhenAllowed() {
    assumeFalse("Emulator does not support multiple parallel transactions", isUsingEmulator());
    // TODO(sriharshach): Remove this skip once backend support empty transactions to commit.
    assumeFalse(
        "Skipping for multiplexed sessions since it does not allow empty transactions to commit",
        isUsingMultiplexedSessionsForRW());
    client
        .readWriteTransaction()
        .allowNestedTransaction()
        .run(
            transaction -> {
              client.singleUseReadOnlyTransaction();

              return null;
            });
  }

  @Test
  public void testTxWithCaughtError() {
    assumeFalse(
        "Emulator does not recover from an error within a transaction",
        EmulatorSpannerHelper.isUsingEmulator());

    long updateCount =
        client
            .readWriteTransaction()
            .run(
                transaction -> {
                  try {
                    transaction.executeUpdate(Statement.of("UPDATE T SET V=2 WHERE"));
                    fail("missing expected exception");
                  } catch (SpannerException e) {
                    if (e.getErrorCode() == ErrorCode.ABORTED) {
                      // Aborted -> Let the transaction be retried
                      throw e;
                    }
                    assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
                  }
                  return transaction.executeUpdate(
                      Statement.of("INSERT INTO T (K, V) VALUES ('One', 1)"));
                });
    assertThat(updateCount).isEqualTo(1L);
  }

  @Test
  public void testTxWithConstraintError() {
    assumeFalse(
        "Emulator does not recover from an error within a transaction",
        EmulatorSpannerHelper.isUsingEmulator());

    // First insert a single row.
    client.writeAtLeastOnce(
        ImmutableList.of(
            Mutation.newInsertOrUpdateBuilder("T").set("K").to("One").set("V").to(1L).build()));

    try {
      client
          .readWriteTransaction()
          .run(
              transaction -> {
                try {
                  // Try to insert a duplicate row. This statement will fail. When the statement
                  // is executed against an already existing transaction (i.e.
                  // inlineBegin=false), the entire transaction will remain invalid and cannot
                  // be committed. When it is executed as the first statement of a transaction
                  // that also tries to start a transaction, then no transaction will be started
                  // and the next statement will start the transaction. This will cause the
                  // transaction to succeed.
                  transaction.executeUpdate(Statement.of("INSERT INTO T (K, V) VALUES ('One', 1)"));
                  fail("missing expected exception");
                } catch (SpannerException e) {
                  if (e.getErrorCode() == ErrorCode.ABORTED) {
                    // Aborted -> Let the transaction be retried
                    throw e;
                  }
                  assertThat(e.getErrorCode()).isEqualTo(ErrorCode.ALREADY_EXISTS);
                }
                return transaction.executeUpdate(
                    Statement.of("INSERT INTO T (K, V) VALUES ('Two', 2)"));
              });
      fail("missing expected ALREADY_EXISTS error");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.ALREADY_EXISTS);
    }
  }

  @Test
  public void testTxWithUncaughtError() {
    try {
      client
          .readWriteTransaction()
          .run(transaction -> transaction.executeUpdate(Statement.of("UPDATE T SET V=2 WHERE")));
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
    }
  }

  @Test
  public void testTxWithLargeMessageSize() {
    int bytesPerColumn = 10000000; // 10MB
    String key = uniqueKey();
    Random random = new Random();
    List<Mutation> mutations = new ArrayList();
    Mutation.WriteBuilder builder = Mutation.newInsertOrUpdateBuilder("T").set("K").to(key);
    for (int j = 0; j < 7; j++) {
      byte[] data = new byte[bytesPerColumn];
      random.nextBytes(data);
      builder
          .set("col" + j)
          .to(com.google.cloud.spanner.Value.bytes(com.google.cloud.ByteArray.copyFrom(data)));
    }
    mutations.add(builder.build());
    // This large message is under the 100MB limit.
    largeMessageClient.write(mutations);
  }

  @Test
  public void testTxWithUncaughtErrorAfterSuccessfulBegin() {
    try {
      client
          .readWriteTransaction()
          .run(
              transaction -> {
                transaction.executeUpdate(Statement.of("INSERT INTO T (K, V) VALUES ('One', 1)"));
                return transaction.executeUpdate(Statement.of("UPDATE T SET V=2 WHERE"));
              });
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
    }
  }

  @Test
  public void testTransactionRunnerReturnsCommitStats() {
    assumeFalse("Emulator does not return commit statistics", isUsingEmulator());
    final String key = uniqueKey();
    TransactionRunner runner = client.readWriteTransaction(Options.commitStats());
    runner.run(
        transaction -> {
          transaction.buffer(
              Mutation.newInsertBuilder("T").set("K").to(key).set("V").to(0).build());
          return null;
        });
    assertNotNull(runner.getCommitResponse().getCommitStats());
    // MutationCount = 2 (2 columns).
    assertEquals(2L, runner.getCommitResponse().getCommitStats().getMutationCount());
  }

  boolean isUsingMultiplexedSessionsForRW() {
    return env.getTestHelper().getOptions().getSessionPoolOptions().getUseMultiplexedSessionForRW();
  }
}
