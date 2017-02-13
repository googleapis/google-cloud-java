/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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
import static com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ReadContext;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Timestamp;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.TransactionRunner;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for read-write transactions. */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITTransactionTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static Database db;
  private static DatabaseClient client;
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
  }

  private static String uniqueKey() {
    return "k" + seq++;
  }

  private static interface ReadStrategy {
    Struct read(ReadContext ctx, String key);
  }

  private void doBasicsTest(final ReadStrategy strategy) throws InterruptedException {
    final String key = uniqueKey();

    // Initial value.
    client.write(
        Arrays.asList(Mutation.newInsertBuilder("T").set("K").to(key).set("V").to(0).build()));

    final int numThreads = 3;

    final CountDownLatch commitBarrier = new CountDownLatch(numThreads);
    final CountDownLatch complete = new CountDownLatch(numThreads);

    final TransactionCallable<Long> callable =
        new TransactionCallable<Long>() {
          @Override
          public Long run(TransactionContext transaction) throws SpannerException {
            Struct row = strategy.read(transaction, key);
            long newValue = row.getLong(0) + 1;
            transaction.buffer(
                Mutation.newUpdateBuilder("T").set("K").to(key).set("V").to(newValue).build());
            commitBarrier.countDown();
            // Synchronize so that all threads attempt to commit at the same time.
            Uninterruptibles.awaitUninterruptibly(commitBarrier);
            return newValue;
          }
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
    assertThat(results).containsAllIn(expectedResults);
    assertThat(Sets.newHashSet(commitTimestamps)).hasSize(numThreads);

    assertThat(
            client
                .singleUse(TimestampBound.strong())
                .readRow("T", Key.of(key), Arrays.asList("V"))
                .getLong(0))
        .isEqualTo(Long.valueOf(numThreads));
  }

  @Test
  public void basicsUsingRead() throws InterruptedException {
    doBasicsTest(
        new ReadStrategy() {
          @Override
          public Struct read(ReadContext ctx, String key) {
            return ctx.readRow("T", Key.of(key), Arrays.asList("V"));
          }
        });
  }

  @Test
  public void basicsUsingQuery() throws InterruptedException {
    doBasicsTest(
        new ReadStrategy() {
          @Override
          public Struct read(ReadContext ctx, String key) {
            ResultSet resultSet =
                ctx.executeQuery(
                    Statement.newBuilder("SELECT V FROM T WHERE K = @key")
                        .bind("key")
                        .to(key)
                        .build());
            assertThat(resultSet.next()).isTrue();
            Struct row = resultSet.getCurrentRowAsStruct();
            assertThat(resultSet.next()).isFalse();
            return row;
          }
        });
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
        new TransactionCallable<Void>() {
          @Override
          public Void run(TransactionContext transaction) throws UserException {
            transaction.buffer(Mutation.newInsertOrUpdateBuilder("T").set("K").to(key).build());
            throw new UserException("User failure");
          }
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
        client.singleUse(TimestampBound.strong()).readRow("T", Key.of(key), Arrays.asList("K"));
    assertThat(row).isNull();
  }

  @Test
  public void userExceptionIsSpannerException() {
    final String key = uniqueKey();

    TransactionCallable<Void> callable =
        new TransactionCallable<Void>() {
          @Override
          public Void run(TransactionContext transaction) {
            transaction.buffer(Mutation.newInsertOrUpdateBuilder("T").set("K").to(key).build());
            throw newSpannerException(ErrorCode.OUT_OF_RANGE, "User failure");
          }
        };

    try {
      client.readWriteTransaction().run(callable);
      fail("Expected user exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.OUT_OF_RANGE);
      assertThat(e.getMessage()).contains("User failure");
    }

    Struct row =
        client.singleUse(TimestampBound.strong()).readRow("T", Key.of(key), Arrays.asList("K"));
    assertThat(row).isNull();
  }

  @Test
  public void readAbort() throws InterruptedException {
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

    // Thread 1 performs a read before notifying that it has started and allowing
    // thread 2 to start.  This ensures that it establishes a senior lock priority relative to
    // thread 2.  It then waits for thread 2 to read, so that both threads have shared locks on
    // key1, before continuing to commit; the act of committing means that thread 1's lock is
    // upgraded and thread 2's transaction is aborted.  When thread 1 is done, thread 2 tries a
    // second read, which will abort.  Both threads will mask SpannerExceptions to ensure that
    // the implementation does not require TransactionCallable to propagate them.
    Thread t1 =
        new Thread() {
          @Override
          public void run() {
            client
                .readWriteTransaction()
                .run(
                    new TransactionCallable<Void>() {
                      @Override
                      public Void run(TransactionContext transaction) throws SpannerException {
                        try {
                          Struct row = transaction.readRow("T", Key.of(key1), Arrays.asList("V"));
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
                            assertThat(((AbortedException) e).getRetryDelayInMillis())
                                .isNotEqualTo(-1L);
                          }
                          throw new RuntimeException("Swallowed exception: " + e.getMessage());
                        }
                      }
                    });
            t1Done.countDown();
          }
        };
    Thread t2 =
        new Thread() {
          @Override
          public void run() {
            client
                .readWriteTransaction()
                .run(
                    new TransactionCallable<Void>() {
                      @Override
                      public Void run(TransactionContext transaction) throws SpannerException {
                        try {
                          Struct r1 = transaction.readRow("T", Key.of(key1), Arrays.asList("V"));
                          t2Running.countDown();
                          Uninterruptibles.awaitUninterruptibly(t1Done);
                          Struct r2 = transaction.readRow("T", Key.of(key2), Arrays.asList("V"));
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
                            assertThat(((AbortedException) e).getRetryDelayInMillis())
                                .isNotEqualTo(-1L);
                          }
                          throw new RuntimeException("Swallowed exception: " + e.getMessage());
                        }
                      }
                    });
            t2Done.countDown();
          }
        };

    t1.start();
    Uninterruptibles.awaitUninterruptibly(t1Started);
    // Thread 2 will abort on the first attempt and should retry; wait for completion to confirm.
    t2.start();
    assertThat(t2Done.await(1, TimeUnit.MINUTES)).isTrue();

    // Check that both transactions effects are visible.
    assertThat(
            client
                .singleUse(TimestampBound.strong())
                .readRow("T", Key.of(key1), Arrays.asList("V"))
                .getLong(0))
        .isEqualTo(1);
    assertThat(
            client
                .singleUse(TimestampBound.strong())
                .readRow("T", Key.of(key2), Arrays.asList("V"))
                .getLong(0))
        .isEqualTo(2);
  }
}
