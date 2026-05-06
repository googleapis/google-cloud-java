/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.spanner.SpannerApiFutures.get;
import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.AsyncResultSet;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.AsyncRunner;
import com.google.cloud.spanner.AsyncTransactionManager;
import com.google.cloud.spanner.AsyncTransactionManager.TransactionContextFuture;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeyRange;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for asynchronous APIs. */
@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITAsyncAPITest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static final String TABLE_NAME = "TestTable";
  private static final String INDEX_NAME = "TestTableByValue";
  private static final List<String> ALL_COLUMNS = Arrays.asList("Key", "StringValue");
  private static final Type TABLE_TYPE =
      Type.struct(
          StructField.of("Key", Type.string()), StructField.of("StringValue", Type.string()));

  private static Database db;
  private static DatabaseClient client;
  private static ExecutorService executor;

  @BeforeClass
  public static void setUpDatabase() {
    db =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE TestTable ("
                    + "  Key                STRING(MAX) NOT NULL,"
                    + "  StringValue        STRING(MAX),"
                    + ") PRIMARY KEY (Key)",
                "CREATE INDEX TestTableByValue ON TestTable(StringValue)",
                "CREATE INDEX TestTableByValueDesc ON TestTable(StringValue DESC)");
    client = env.getTestHelper().getDatabaseClient(db);
    executor = Executors.newSingleThreadExecutor();
  }

  @AfterClass
  public static void cleanup() {
    executor.shutdown();
  }

  @Before
  public void setupData() {
    client.write(Collections.singletonList(Mutation.delete(TABLE_NAME, KeySet.all())));
    // Includes k0..k14.  Note that strings k{10,14} sort between k1 and k2.
    List<Mutation> mutations = new ArrayList<>();
    for (int i = 0; i < 15; ++i) {
      mutations.add(
          Mutation.newInsertOrUpdateBuilder(TABLE_NAME)
              .set("Key")
              .to("k" + i)
              .set("StringValue")
              .to("v" + i)
              .build());
    }
    client.write(mutations);
  }

  @Test
  public void emptyReadAsync() throws Exception {
    final SettableFuture<Boolean> result = SettableFuture.create();
    AsyncResultSet resultSet =
        client
            .singleUse(TimestampBound.strong())
            .readAsync(
                TABLE_NAME,
                KeySet.range(KeyRange.closedOpen(Key.of("k99"), Key.of("z"))),
                ALL_COLUMNS);
    resultSet.setCallback(
        executor,
        rs -> {
          try {
            while (true) {
              switch (rs.tryNext()) {
                case OK:
                  fail("received unexpected data");
                case NOT_READY:
                  return CallbackResponse.CONTINUE;
                case DONE:
                  assertThat(rs.getType()).isEqualTo(TABLE_TYPE);
                  result.set(true);
                  return CallbackResponse.DONE;
              }
            }
          } catch (Throwable t) {
            result.setException(t);
            return CallbackResponse.DONE;
          }
        });
    assertThat(result.get()).isTrue();
  }

  @Test
  public void indexEmptyReadAsync() throws Exception {
    final SettableFuture<Boolean> result = SettableFuture.create();
    AsyncResultSet resultSet =
        client
            .singleUse(TimestampBound.strong())
            .readUsingIndexAsync(
                TABLE_NAME,
                INDEX_NAME,
                KeySet.range(KeyRange.closedOpen(Key.of("v99"), Key.of("z"))),
                ALL_COLUMNS);
    resultSet.setCallback(
        executor,
        rs -> {
          try {
            while (true) {
              switch (rs.tryNext()) {
                case OK:
                  fail("received unexpected data");
                case NOT_READY:
                  return CallbackResponse.CONTINUE;
                case DONE:
                  assertThat(rs.getType()).isEqualTo(TABLE_TYPE);
                  result.set(true);
                  return CallbackResponse.DONE;
              }
            }
          } catch (Throwable t) {
            result.setException(t);
            return CallbackResponse.DONE;
          }
        });
    assertThat(result.get()).isTrue();
  }

  @Test
  public void pointReadAsync() throws Exception {
    ApiFuture<Struct> row =
        client
            .singleUse(TimestampBound.strong())
            .readRowAsync(TABLE_NAME, Key.of("k1"), ALL_COLUMNS);
    assertThat(row.get()).isNotNull();
    assertThat(row.get().getString(0)).isEqualTo("k1");
    assertThat(row.get().getString(1)).isEqualTo("v1");
    // Ensure that the Struct implementation supports equality properly.
    assertThat(row.get())
        .isEqualTo(Struct.newBuilder().set("Key").to("k1").set("StringValue").to("v1").build());
  }

  @Test
  public void indexPointReadAsync() throws Exception {
    ApiFuture<Struct> row =
        client
            .singleUse(TimestampBound.strong())
            .readRowUsingIndexAsync(TABLE_NAME, INDEX_NAME, Key.of("v1"), ALL_COLUMNS);
    assertThat(row.get()).isNotNull();
    assertThat(row.get().getString(0)).isEqualTo("k1");
    assertThat(row.get().getString(1)).isEqualTo("v1");
  }

  @Test
  public void pointReadNotFound() throws Exception {
    ApiFuture<Struct> row =
        client
            .singleUse(TimestampBound.strong())
            .readRowAsync(TABLE_NAME, Key.of("k999"), ALL_COLUMNS);
    assertThat(row.get()).isNull();
  }

  @Test
  public void indexPointReadNotFound() throws Exception {
    ApiFuture<Struct> row =
        client
            .singleUse(TimestampBound.strong())
            .readRowUsingIndexAsync(TABLE_NAME, INDEX_NAME, Key.of("v999"), ALL_COLUMNS);
    assertThat(row.get()).isNull();
  }

  @Test
  public void invalidDatabase() throws Exception {
    RemoteSpannerHelper helper = env.getTestHelper();
    DatabaseClient invalidClient =
        helper.getClient().getDatabaseClient(DatabaseId.of(helper.getInstanceId(), "invalid"));
    Thread.sleep(ThreadLocalRandom.current().nextLong(100L));
    try {
      // The NOT_FOUND error can come from both the call to invalidClient.singleUse() as well as
      // from the call to row.get(), which is why both need to be inside the try block.
      ApiFuture<Struct> row =
          invalidClient
              .singleUse(TimestampBound.strong())
              .readRowAsync(TABLE_NAME, Key.of("k99"), ALL_COLUMNS);
      row.get();
      fail("missing expected exception");
    } catch (ExecutionException | SpannerException thrownException) {
      SpannerException spannerException;
      if (thrownException instanceof ExecutionException) {
        spannerException = (SpannerException) thrownException.getCause();
      } else {
        spannerException = (SpannerException) thrownException;
      }
      assertEquals(ErrorCode.NOT_FOUND, spannerException.getErrorCode());
    }
  }

  @Test
  public void tableNotFound() throws Exception {
    ApiFuture<Struct> row =
        client
            .singleUse(TimestampBound.strong())
            .readRowAsync("BadTableName", Key.of("k1"), ALL_COLUMNS);
    try {
      row.get();
    } catch (ExecutionException e) {
      assertThat(e.getCause()).isInstanceOf(SpannerException.class);
      SpannerException se = (SpannerException) e.getCause();
      assertThat(se.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND);
      assertThat(se.getMessage()).contains("BadTableName");
    }
  }

  @Test
  public void columnNotFound() throws Exception {
    ApiFuture<Struct> row =
        client
            .singleUse(TimestampBound.strong())
            .readRowAsync(TABLE_NAME, Key.of("k1"), Arrays.asList("Key", "BadColumnName"));
    try {
      row.get();
    } catch (ExecutionException e) {
      assertThat(e.getCause()).isInstanceOf(SpannerException.class);
      SpannerException se = (SpannerException) e.getCause();
      assertThat(se.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND);
      assertThat(se.getMessage()).contains("BadColumnName");
    }
  }

  @Test
  public void asyncRunnerFireAndForgetInvalidUpdate() throws Exception {
    try {
      assertThat(client.singleUse().readRow("TestTable", Key.of("k999"), ALL_COLUMNS)).isNull();
      AsyncRunner runner = client.runAsync();
      ApiFuture<Long> res =
          runner.runAsync(
              txn -> {
                // The error returned by this update statement will not bubble up and fail the
                // transaction.
                txn.executeUpdateAsync(Statement.of("UPDATE BadTableName SET FOO=1 WHERE ID=2"));
                return txn.executeUpdateAsync(
                    Statement.of(
                        "INSERT INTO TestTable (Key, StringValue) VALUES ('k999', 'v999')"));
              },
              executor);
      assertThat(res.get()).isEqualTo(1L);
      assertThat(client.singleUse().readRow("TestTable", Key.of("k999"), ALL_COLUMNS)).isNotNull();
    } finally {
      client.writeAtLeastOnce(
          Collections.singletonList(Mutation.delete("TestTable", Key.of("k999"))));
      assertThat(client.singleUse().readRow("TestTable", Key.of("k999"), ALL_COLUMNS)).isNull();
    }
  }

  @Test
  public void testAsyncRunnerReturnsCommitStats() {
    assumeFalse("Emulator does not return commit statistics", isUsingEmulator());
    AsyncRunner runner = client.runAsync(Options.commitStats());
    runner.runAsync(
        transaction -> {
          transaction.buffer(
              Mutation.newInsertOrUpdateBuilder(TABLE_NAME)
                  .set("Key")
                  .to("k_commit_stats")
                  .set("StringValue")
                  .to("Should return commit stats")
                  .build());
          return ApiFutures.immediateFuture(null);
        },
        executor);
    assertNotNull(get(runner.getCommitResponse()).getCommitStats());
    // MutationCount = 2 columns + 2 secondary indexes.
    assertEquals(4L, get(runner.getCommitResponse()).getCommitStats().getMutationCount());
  }

  @Test
  public void testAsyncTransactionManagerReturnsCommitStats() throws InterruptedException {
    assumeFalse("Emulator does not return commit statistics", isUsingEmulator());
    try (AsyncTransactionManager manager = client.transactionManagerAsync(Options.commitStats())) {
      TransactionContextFuture context = manager.beginAsync();
      while (true) {
        try {
          get(
              context
                  .then(
                      (transaction, ignored) -> {
                        transaction.buffer(
                            Mutation.newInsertOrUpdateBuilder(TABLE_NAME)
                                .set("Key")
                                .to("k_commit_stats")
                                .set("StringValue")
                                .to("Should return commit stats")
                                .build());
                        return ApiFutures.immediateFuture(null);
                      },
                      executor)
                  .commitAsync());
          assertNotNull(get(manager.getCommitResponse()).getCommitStats());
          assertEquals(4L, get(manager.getCommitResponse()).getCommitStats().getMutationCount());
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis());
          context = manager.resetForRetryAsync();
        }
      }
    }
  }
}
