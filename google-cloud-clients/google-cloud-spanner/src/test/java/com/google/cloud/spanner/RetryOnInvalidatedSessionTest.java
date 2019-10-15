/*
 * Copyright 2019 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import com.google.cloud.spanner.v1.SpannerClient;
import com.google.cloud.spanner.v1.SpannerClient.ListSessionsPagedResponse;
import com.google.cloud.spanner.v1.SpannerSettings;
import com.google.common.base.Stopwatch;
import com.google.protobuf.ListValue;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.inprocess.InProcessServerBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RetryOnInvalidatedSessionTest {
  @Rule public ExpectedException expected = ExpectedException.none();

  @Parameter(0)
  public boolean failOnInvalidatedSession;

  @Parameters(name = "fail on invalidated session = {0}")
  public static Collection<Object[]> data() {
    List<Object[]> params = new ArrayList<>();
    params.add(new Object[] {false});
    params.add(new Object[] {true});
    return params;
  }

  private static final ResultSetMetadata READ_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName("BAR")
                          .setType(
                              com.google.spanner.v1.Type.newBuilder()
                                  .setCode(TypeCode.INT64)
                                  .build())
                          .build())
                  .build())
          .build();
  private static final com.google.spanner.v1.ResultSet READ_RESULTSET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("1").build())
                  .build())
          .addRows(
              ListValue.newBuilder()
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("2").build())
                  .build())
          .setMetadata(READ_METADATA)
          .build();
  private static final com.google.spanner.v1.ResultSet READ_ROW_RESULTSET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("1").build())
                  .build())
          .setMetadata(READ_METADATA)
          .build();
  private static final Statement SELECT1AND2 =
      Statement.of("SELECT 1 AS COL1 UNION ALL SELECT 2 AS COL1");
  private static final ResultSetMetadata SELECT1AND2_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName("COL1")
                          .setType(
                              com.google.spanner.v1.Type.newBuilder()
                                  .setCode(TypeCode.INT64)
                                  .build())
                          .build())
                  .build())
          .build();
  private static final com.google.spanner.v1.ResultSet SELECT1_RESULTSET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("1").build())
                  .build())
          .addRows(
              ListValue.newBuilder()
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("2").build())
                  .build())
          .setMetadata(SELECT1AND2_METADATA)
          .build();
  private static final Statement UPDATE_STATEMENT =
      Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=2");
  private static final long UPDATE_COUNT = 1L;
  private static final float WRITE_SESSIONS_FRACTION = 0.5f;
  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static LocalChannelProvider channelProvider;
  private static SpannerClient spannerClient;
  private static Spanner spanner;
  private static DatabaseClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockSpanner.putStatementResult(
        StatementResult.read("FOO", KeySet.all(), Arrays.asList("BAR"), READ_RESULTSET));
    mockSpanner.putStatementResult(
        StatementResult.read(
            "FOO", KeySet.singleKey(Key.of()), Arrays.asList("BAR"), READ_ROW_RESULTSET));
    mockSpanner.putStatementResult(StatementResult.query(SELECT1AND2, SELECT1_RESULTSET));
    mockSpanner.putStatementResult(StatementResult.update(UPDATE_STATEMENT, UPDATE_COUNT));

    String uniqueName = InProcessServerBuilder.generateName();
    server =
        InProcessServerBuilder.forName(uniqueName)
            .directExecutor()
            .addService(mockSpanner)
            .build()
            .start();
    channelProvider = LocalChannelProvider.create(uniqueName);

    SpannerSettings settings =
        SpannerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    spannerClient = SpannerClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    spannerClient.close();
    server.shutdown();
  }

  @Before
  public void setUp() throws IOException {
    mockSpanner.reset();
    SessionPoolOptions.Builder builder =
        SessionPoolOptions.newBuilder().setWriteSessionsFraction(WRITE_SESSIONS_FRACTION);
    if (failOnInvalidatedSession) {
      builder.setFailIfSessionNotFound();
    }
    spanner =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setChannelProvider(channelProvider)
            .setSessionPoolOption(builder.build())
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getService();
    client = spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
  }

  @After
  public void tearDown() throws Exception {
    spanner.close();
  }

  private static void initReadWriteSessionPool() throws InterruptedException {
    // Wait for at least one read/write session to be ready.
    Stopwatch watch = Stopwatch.createStarted();
    while (((DatabaseClientImpl) client).pool.getNumberOfAvailableWritePreparedSessions() == 0) {
      if (watch.elapsed(TimeUnit.MILLISECONDS) > 1000L) {
        fail("No read/write sessions prepared");
      }
      Thread.sleep(5L);
    }
  }

  private static void invalidateSessionPool() throws InterruptedException {
    invalidateSessionPool(client, spanner.getOptions().getSessionPoolOptions().getMinSessions());
  }

  private static void invalidateSessionPool(DatabaseClient client, int minSessions)
      throws InterruptedException {
    // Wait for all sessions to have been created, and then delete them.
    Stopwatch watch = Stopwatch.createStarted();
    while (((DatabaseClientImpl) client).pool.totalSessions() < minSessions) {
      if (watch.elapsed(TimeUnit.MILLISECONDS) > 1000L) {
        fail("MinSessions not created");
      }
      Thread.sleep(5L);
    }

    ListSessionsPagedResponse response =
        spannerClient.listSessions("projects/[PROJECT]/instances/[INSTANCE]/databases/[DATABASE]");
    for (com.google.spanner.v1.Session session : response.iterateAll()) {
      spannerClient.deleteSession(session.getName());
    }
  }

  @Test
  public void singleUseSelect() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    invalidateSessionPool();
    // This call will receive an invalidated session that will be replaced on the first call to
    // rs.next().
    int count = 0;
    try (ReadContext context = client.singleUse()) {
      try (ResultSet rs = context.executeQuery(SELECT1AND2)) {
        while (rs.next()) {
          count++;
        }
      }
    }
    assertThat(count).isEqualTo(2);
  }

  @Test
  public void singleUseRead() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    invalidateSessionPool();
    int count = 0;
    try (ReadContext context = client.singleUse()) {
      try (ResultSet rs = context.read("FOO", KeySet.all(), Arrays.asList("BAR"))) {
        while (rs.next()) {
          count++;
        }
      }
      assertThat(count).isEqualTo(2);
    }
  }

  @Test
  public void singleUseReadUsingIndex() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    invalidateSessionPool();
    int count = 0;
    try (ReadContext context = client.singleUse()) {
      try (ResultSet rs =
          context.readUsingIndex("FOO", "IDX", KeySet.all(), Arrays.asList("BAR"))) {
        while (rs.next()) {
          count++;
        }
      }
      assertThat(count).isEqualTo(2);
    }
  }

  @Test
  public void singleUseReadRow() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    invalidateSessionPool();
    try (ReadContext context = client.singleUse()) {
      Struct row = context.readRow("FOO", Key.of(), Arrays.asList("BAR"));
      assertThat(row.getLong(0)).isEqualTo(1L);
    }
  }

  @Test
  public void singleUseReadRowUsingIndex() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    invalidateSessionPool();
    try (ReadContext context = client.singleUse()) {
      Struct row = context.readRowUsingIndex("FOO", "IDX", Key.of(), Arrays.asList("BAR"));
      assertThat(row.getLong(0)).isEqualTo(1L);
    }
  }

  @Test
  public void singleUseReadOnlyTransactionSelect() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    invalidateSessionPool();
    int count = 0;
    try (ReadContext context = client.singleUseReadOnlyTransaction()) {
      try (ResultSet rs = context.executeQuery(SELECT1AND2)) {
        while (rs.next()) {
          count++;
        }
      }
    }
    assertThat(count).isEqualTo(2);
  }

  @Test
  public void singleUseReadOnlyTransactionRead() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    invalidateSessionPool();
    int count = 0;
    try (ReadContext context = client.singleUseReadOnlyTransaction()) {
      try (ResultSet rs = context.read("FOO", KeySet.all(), Arrays.asList("BAR"))) {
        while (rs.next()) {
          count++;
        }
      }
      assertThat(count).isEqualTo(2);
    }
  }

  @Test
  public void singlUseReadOnlyTransactionReadUsingIndex() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    invalidateSessionPool();
    int count = 0;
    try (ReadContext context = client.singleUseReadOnlyTransaction()) {
      try (ResultSet rs =
          context.readUsingIndex("FOO", "IDX", KeySet.all(), Arrays.asList("BAR"))) {
        while (rs.next()) {
          count++;
        }
      }
      assertThat(count).isEqualTo(2);
    }
  }

  @Test
  public void singleUseReadOnlyTransactionReadRow() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    invalidateSessionPool();
    try (ReadContext context = client.singleUseReadOnlyTransaction()) {
      Struct row = context.readRow("FOO", Key.of(), Arrays.asList("BAR"));
      assertThat(row.getLong(0)).isEqualTo(1L);
    }
  }

  @Test
  public void singleUseReadOnlyTransactionReadRowUsingIndex() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    invalidateSessionPool();
    try (ReadContext context = client.singleUseReadOnlyTransaction()) {
      Struct row = context.readRowUsingIndex("FOO", "IDX", Key.of(), Arrays.asList("BAR"));
      assertThat(row.getLong(0)).isEqualTo(1L);
    }
  }

  @Test
  public void readOnlyTransactionSelect() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    invalidateSessionPool();
    int count = 0;
    try (ReadContext context = client.readOnlyTransaction()) {
      try (ResultSet rs = context.executeQuery(SELECT1AND2)) {
        while (rs.next()) {
          count++;
        }
      }
      assertThat(count).isEqualTo(2);
    }
  }

  @Test
  public void readOnlyTransactionRead() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    invalidateSessionPool();
    int count = 0;
    try (ReadContext context = client.readOnlyTransaction()) {
      try (ResultSet rs = context.read("FOO", KeySet.all(), Arrays.asList("BAR"))) {
        while (rs.next()) {
          count++;
        }
      }
      assertThat(count).isEqualTo(2);
    }
  }

  @Test
  public void readOnlyTransactionReadUsingIndex() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    invalidateSessionPool();
    int count = 0;
    try (ReadContext context = client.readOnlyTransaction()) {
      try (ResultSet rs =
          context.readUsingIndex("FOO", "IDX", KeySet.all(), Arrays.asList("BAR"))) {
        while (rs.next()) {
          count++;
        }
      }
      assertThat(count).isEqualTo(2);
    }
  }

  @Test
  public void readOnlyTransactionReadRow() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    invalidateSessionPool();
    try (ReadContext context = client.readOnlyTransaction()) {
      Struct row = context.readRow("FOO", Key.of(), Arrays.asList("BAR"));
      assertThat(row.getLong(0)).isEqualTo(1L);
    }
  }

  @Test
  public void readOnlyTransactionReadRowUsingIndex() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    invalidateSessionPool();
    try (ReadContext context = client.readOnlyTransaction()) {
      Struct row = context.readRowUsingIndex("FOO", "IDX", Key.of(), Arrays.asList("BAR"));
      assertThat(row.getLong(0)).isEqualTo(1L);
    }
  }

  @Test(expected = SessionNotFoundException.class)
  public void readOnlyTransactionSelectNonRecoverable() throws InterruptedException {
    int count = 0;
    try (ReadContext context = client.readOnlyTransaction()) {
      try (ResultSet rs = context.executeQuery(SELECT1AND2)) {
        while (rs.next()) {
          count++;
        }
      }
      assertThat(count).isEqualTo(2);
      // Invalidate the session pool while in a transaction. This is not recoverable.
      invalidateSessionPool();
      try (ResultSet rs = context.executeQuery(SELECT1AND2)) {
        while (rs.next()) {
          count++;
        }
      }
    }
  }

  @Test(expected = SessionNotFoundException.class)
  public void readOnlyTransactionReadNonRecoverable() throws InterruptedException {
    int count = 0;
    try (ReadContext context = client.readOnlyTransaction()) {
      try (ResultSet rs = context.read("FOO", KeySet.all(), Arrays.asList("BAR"))) {
        while (rs.next()) {
          count++;
        }
      }
      assertThat(count).isEqualTo(2);
      invalidateSessionPool();
      try (ResultSet rs = context.read("FOO", KeySet.all(), Arrays.asList("BAR"))) {
        while (rs.next()) {
          count++;
        }
      }
    }
  }

  @Test(expected = SessionNotFoundException.class)
  public void readOnlyTransactionReadUsingIndexNonRecoverable() throws InterruptedException {
    int count = 0;
    try (ReadContext context = client.readOnlyTransaction()) {
      try (ResultSet rs =
          context.readUsingIndex("FOO", "IDX", KeySet.all(), Arrays.asList("BAR"))) {
        while (rs.next()) {
          count++;
        }
      }
      assertThat(count).isEqualTo(2);
      invalidateSessionPool();
      try (ResultSet rs =
          context.readUsingIndex("FOO", "IDX", KeySet.all(), Arrays.asList("BAR"))) {
        while (rs.next()) {
          count++;
        }
      }
    }
  }

  @Test(expected = SessionNotFoundException.class)
  public void readOnlyTransactionReadRowNonRecoverable() throws InterruptedException {
    try (ReadContext context = client.readOnlyTransaction()) {
      Struct row = context.readRow("FOO", Key.of(), Arrays.asList("BAR"));
      assertThat(row.getLong(0)).isEqualTo(1L);
      invalidateSessionPool();
      row = context.readRow("FOO", Key.of(), Arrays.asList("BAR"));
    }
  }

  @Test(expected = SessionNotFoundException.class)
  public void readOnlyTransactionReadRowUsingIndexNonRecoverable() throws InterruptedException {
    try (ReadContext context = client.readOnlyTransaction()) {
      Struct row = context.readRowUsingIndex("FOO", "IDX", Key.of(), Arrays.asList("BAR"));
      assertThat(row.getLong(0)).isEqualTo(1L);
      invalidateSessionPool();
      row = context.readRowUsingIndex("FOO", "IDX", Key.of(), Arrays.asList("BAR"));
    }
  }

  /**
   * Test with one read-only session in the pool that is invalidated. The session pool will try to
   * prepare this session for read/write, which will fail with a {@link SessionNotFoundException}.
   * That again will trigger the creation of a new session. This will always succeed.
   */
  @Test
  public void readWriteTransactionReadOnlySessionInPool() throws InterruptedException {
    // Create a session pool with only read sessions.
    SessionPoolOptions.Builder builder =
        SessionPoolOptions.newBuilder().setWriteSessionsFraction(0.0f);
    if (failOnInvalidatedSession) {
      builder.setFailIfSessionNotFound();
    }
    Spanner spanner =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setChannelProvider(channelProvider)
            .setSessionPoolOption(builder.build())
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getService();
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    invalidateSessionPool(client, spanner.getOptions().getSessionPoolOptions().getMinSessions());
    TransactionRunner runner = client.readWriteTransaction();
    int count =
        runner.run(
            new TransactionCallable<Integer>() {
              @Override
              public Integer run(TransactionContext transaction) throws Exception {
                int count = 0;
                try (ResultSet rs = transaction.executeQuery(SELECT1AND2)) {
                  while (rs.next()) {
                    count++;
                  }
                }
                return count;
              }
            });
    assertThat(count).isEqualTo(2);
  }

  @Test
  public void readWriteTransactionSelect() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    TransactionRunner runner = client.readWriteTransaction();
    int count =
        runner.run(
            new TransactionCallable<Integer>() {
              @Override
              public Integer run(TransactionContext transaction) throws Exception {
                int count = 0;
                try (ResultSet rs = transaction.executeQuery(SELECT1AND2)) {
                  while (rs.next()) {
                    count++;
                  }
                }
                return count;
              }
            });
    assertThat(count).isEqualTo(2);
  }

  @Test
  public void readWriteTransactionRead() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    TransactionRunner runner = client.readWriteTransaction();
    int count =
        runner.run(
            new TransactionCallable<Integer>() {
              @Override
              public Integer run(TransactionContext transaction) throws Exception {
                int count = 0;
                try (ResultSet rs = transaction.read("FOO", KeySet.all(), Arrays.asList("BAR"))) {
                  while (rs.next()) {
                    count++;
                  }
                }
                return count;
              }
            });
    assertThat(count).isEqualTo(2);
  }

  @Test
  public void readWriteTransactionReadUsingIndex() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    TransactionRunner runner = client.readWriteTransaction();
    int count =
        runner.run(
            new TransactionCallable<Integer>() {
              @Override
              public Integer run(TransactionContext transaction) throws Exception {
                int count = 0;
                try (ResultSet rs =
                    transaction.readUsingIndex("FOO", "IDX", KeySet.all(), Arrays.asList("BAR"))) {
                  while (rs.next()) {
                    count++;
                  }
                }
                return count;
              }
            });
    assertThat(count).isEqualTo(2);
  }

  @Test
  public void readWriteTransactionReadRow() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    TransactionRunner runner = client.readWriteTransaction();
    Struct row =
        runner.run(
            new TransactionCallable<Struct>() {
              @Override
              public Struct run(TransactionContext transaction) throws Exception {
                return transaction.readRow("FOO", Key.of(), Arrays.asList("BAR"));
              }
            });
    assertThat(row.getLong(0)).isEqualTo(1L);
  }

  @Test
  public void readWriteTransactionReadRowUsingIndex() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    TransactionRunner runner = client.readWriteTransaction();
    Struct row =
        runner.run(
            new TransactionCallable<Struct>() {
              @Override
              public Struct run(TransactionContext transaction) throws Exception {
                return transaction.readRowUsingIndex("FOO", "IDX", Key.of(), Arrays.asList("BAR"));
              }
            });
    assertThat(row.getLong(0)).isEqualTo(1L);
  }

  @Test
  public void readWriteTransactionUpdate() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    TransactionRunner runner = client.readWriteTransaction();
    long count =
        runner.run(
            new TransactionCallable<Long>() {
              @Override
              public Long run(TransactionContext transaction) throws Exception {
                return transaction.executeUpdate(UPDATE_STATEMENT);
              }
            });
    assertThat(count).isEqualTo(UPDATE_COUNT);
  }

  @Test
  public void readWriteTransactionBatchUpdate() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    TransactionRunner runner = client.readWriteTransaction();
    long[] count =
        runner.run(
            new TransactionCallable<long[]>() {
              @Override
              public long[] run(TransactionContext transaction) throws Exception {
                return transaction.batchUpdate(Arrays.asList(UPDATE_STATEMENT));
              }
            });
    assertThat(count.length).isEqualTo(1);
    assertThat(count[0]).isEqualTo(UPDATE_COUNT);
  }

  @Test
  public void readWriteTransactionBuffer() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    TransactionRunner runner = client.readWriteTransaction();
    runner.run(
        new TransactionCallable<Void>() {
          @Override
          public Void run(TransactionContext transaction) throws Exception {
            transaction.buffer(Mutation.newInsertBuilder("FOO").set("BAR").to(1L).build());
            return null;
          }
        });
    assertThat(runner.getCommitTimestamp()).isNotNull();
  }

  @Test
  public void readWriteTransactionSelectInvalidatedDuringTransaction() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    TransactionRunner runner = client.readWriteTransaction();
    int attempts =
        runner.run(
            new TransactionCallable<Integer>() {
              private int attempt = 0;

              @Override
              public Integer run(TransactionContext transaction) throws Exception {
                attempt++;
                int count = 0;
                try (ResultSet rs = transaction.executeQuery(SELECT1AND2)) {
                  while (rs.next()) {
                    count++;
                  }
                }
                assertThat(count).isEqualTo(2);
                if (attempt == 1) {
                  invalidateSessionPool();
                }
                try (ResultSet rs = transaction.executeQuery(SELECT1AND2)) {
                  while (rs.next()) {
                    count++;
                  }
                }
                return attempt;
              }
            });
    assertThat(attempts).isGreaterThan(1);
  }

  @Test
  public void readWriteTransactionReadInvalidatedDuringTransaction() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    TransactionRunner runner = client.readWriteTransaction();
    int attempts =
        runner.run(
            new TransactionCallable<Integer>() {
              private int attempt = 0;

              @Override
              public Integer run(TransactionContext transaction) throws Exception {
                attempt++;
                int count = 0;
                try (ResultSet rs = transaction.read("FOO", KeySet.all(), Arrays.asList("BAR"))) {
                  while (rs.next()) {
                    count++;
                  }
                }
                assertThat(count).isEqualTo(2);
                if (attempt == 1) {
                  invalidateSessionPool();
                }
                try (ResultSet rs = transaction.read("FOO", KeySet.all(), Arrays.asList("BAR"))) {
                  while (rs.next()) {
                    count++;
                  }
                }
                return attempt;
              }
            });
    assertThat(attempts).isGreaterThan(1);
  }

  @Test
  public void readWriteTransactionReadUsingIndexInvalidatedDuringTransaction()
      throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    TransactionRunner runner = client.readWriteTransaction();
    int attempts =
        runner.run(
            new TransactionCallable<Integer>() {
              private int attempt = 0;

              @Override
              public Integer run(TransactionContext transaction) throws Exception {
                attempt++;
                int count = 0;
                try (ResultSet rs =
                    transaction.readUsingIndex("FOO", "IDX", KeySet.all(), Arrays.asList("BAR"))) {
                  while (rs.next()) {
                    count++;
                  }
                }
                assertThat(count).isEqualTo(2);
                if (attempt == 1) {
                  invalidateSessionPool();
                }
                try (ResultSet rs =
                    transaction.readUsingIndex("FOO", "IDX", KeySet.all(), Arrays.asList("BAR"))) {
                  while (rs.next()) {
                    count++;
                  }
                }
                return attempt;
              }
            });
    assertThat(attempts).isGreaterThan(1);
  }

  @Test
  public void readWriteTransactionReadRowInvalidatedDuringTransaction()
      throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    TransactionRunner runner = client.readWriteTransaction();
    int attempts =
        runner.run(
            new TransactionCallable<Integer>() {
              private int attempt = 0;

              @Override
              public Integer run(TransactionContext transaction) throws Exception {
                attempt++;
                Struct row = transaction.readRow("FOO", Key.of(), Arrays.asList("BAR"));
                assertThat(row.getLong(0)).isEqualTo(1L);
                if (attempt == 1) {
                  invalidateSessionPool();
                }
                row = transaction.readRow("FOO", Key.of(), Arrays.asList("BAR"));
                return attempt;
              }
            });
    assertThat(attempts).isGreaterThan(1);
  }

  @Test
  public void readWriteTransactionReadRowUsingIndexInvalidatedDuringTransaction()
      throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    TransactionRunner runner = client.readWriteTransaction();
    int attempts =
        runner.run(
            new TransactionCallable<Integer>() {
              private int attempt = 0;

              @Override
              public Integer run(TransactionContext transaction) throws Exception {
                attempt++;
                Struct row =
                    transaction.readRowUsingIndex("FOO", "IDX", Key.of(), Arrays.asList("BAR"));
                assertThat(row.getLong(0)).isEqualTo(1L);
                if (attempt == 1) {
                  invalidateSessionPool();
                }
                row = transaction.readRowUsingIndex("FOO", "IDX", Key.of(), Arrays.asList("BAR"));
                return attempt;
              }
            });
    assertThat(attempts).isGreaterThan(1);
  }

  /**
   * Test with one read-only session in the pool that is invalidated. The session pool will try to
   * prepare this session for read/write, which will fail with a {@link SessionNotFoundException}.
   * That again will trigger the creation of a new session. This will always succeed.
   */
  @SuppressWarnings("resource")
  @Test
  public void transactionManagerReadOnlySessionInPool() throws InterruptedException {
    // Create a session pool with only read sessions.
    SessionPoolOptions.Builder builder =
        SessionPoolOptions.newBuilder().setWriteSessionsFraction(0.0f);
    if (failOnInvalidatedSession) {
      builder.setFailIfSessionNotFound();
    }
    Spanner spanner =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setChannelProvider(channelProvider)
            .setSessionPoolOption(builder.build())
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getService();
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    invalidateSessionPool(client, spanner.getOptions().getSessionPoolOptions().getMinSessions());
    int count = 0;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        try {
          try (ResultSet rs = transaction.executeQuery(SELECT1AND2)) {
            while (rs.next()) {
              count++;
            }
          }
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          transaction = manager.resetForRetry();
        }
      }
    }
    assertThat(count).isEqualTo(2);
  }

  @SuppressWarnings("resource")
  @Test
  public void transactionManagerSelect() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    int count = 0;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        try {
          try (ResultSet rs = transaction.executeQuery(SELECT1AND2)) {
            while (rs.next()) {
              count++;
            }
          }
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          transaction = manager.resetForRetry();
        }
      }
    }
    assertThat(count).isEqualTo(2);
  }

  @SuppressWarnings("resource")
  @Test
  public void transactionManagerRead() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    int count = 0;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        try {
          try (ResultSet rs = transaction.read("FOO", KeySet.all(), Arrays.asList("BAR"))) {
            while (rs.next()) {
              count++;
            }
          }
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          transaction = manager.resetForRetry();
        }
      }
    }
    assertThat(count).isEqualTo(2);
  }

  @SuppressWarnings("resource")
  @Test
  public void transactionManagerReadUsingIndex() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    int count = 0;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        try {
          try (ResultSet rs =
              transaction.readUsingIndex("FOO", "IDX", KeySet.all(), Arrays.asList("BAR"))) {
            while (rs.next()) {
              count++;
            }
          }
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          transaction = manager.resetForRetry();
        }
      }
    }
    assertThat(count).isEqualTo(2);
  }

  @SuppressWarnings("resource")
  @Test
  public void transactionManagerReadRow() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    Struct row;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        try {
          row = transaction.readRow("FOO", Key.of(), Arrays.asList("BAR"));
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          transaction = manager.resetForRetry();
        }
      }
    }
    assertThat(row.getLong(0)).isEqualTo(1L);
  }

  @SuppressWarnings("resource")
  @Test
  public void transactionManagerReadRowUsingIndex() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    Struct row;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        try {
          row = transaction.readRowUsingIndex("FOO", "IDX", Key.of(), Arrays.asList("BAR"));
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          transaction = manager.resetForRetry();
        }
      }
    }
    assertThat(row.getLong(0)).isEqualTo(1L);
  }

  @SuppressWarnings("resource")
  @Test
  public void transactionManagerUpdate() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    long count;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        try {
          count = transaction.executeUpdate(UPDATE_STATEMENT);
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          transaction = manager.resetForRetry();
        }
      }
    }
    assertThat(count).isEqualTo(UPDATE_COUNT);
  }

  @SuppressWarnings("resource")
  @Test
  public void transactionManagerBatchUpdate() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    long[] count;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        try {
          count = transaction.batchUpdate(Arrays.asList(UPDATE_STATEMENT));
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          transaction = manager.resetForRetry();
        }
      }
    }
    assertThat(count.length).isEqualTo(1);
    assertThat(count[0]).isEqualTo(UPDATE_COUNT);
  }

  @SuppressWarnings("resource")
  @Test
  public void transactionManagerBuffer() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        transaction.buffer(Mutation.newInsertBuilder("FOO").set("BAR").to(1L).build());
        try {
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          transaction = manager.resetForRetry();
        }
      }
      assertThat(manager.getCommitTimestamp()).isNotNull();
    }
  }

  @SuppressWarnings("resource")
  @Test
  public void transactionManagerSelectInvalidatedDuringTransaction() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    int attempts = 0;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        attempts++;
        int count = 0;
        try {
          try (ResultSet rs = transaction.executeQuery(SELECT1AND2)) {
            while (rs.next()) {
              count++;
            }
          }
          assertThat(count).isEqualTo(2);
          if (attempts == 1) {
            invalidateSessionPool();
          }
          try (ResultSet rs = transaction.executeQuery(SELECT1AND2)) {
            while (rs.next()) {
              count++;
            }
          }
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          transaction = manager.resetForRetry();
        }
      }
    }
    assertThat(attempts).isGreaterThan(1);
  }

  @SuppressWarnings("resource")
  @Test
  public void transactionManagerReadInvalidatedDuringTransaction() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    int attempts = 0;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        attempts++;
        int count = 0;
        try {
          try (ResultSet rs = transaction.read("FOO", KeySet.all(), Arrays.asList("BAR"))) {
            while (rs.next()) {
              count++;
            }
          }
          assertThat(count).isEqualTo(2);
          if (attempts == 1) {
            invalidateSessionPool();
          }
          try (ResultSet rs = transaction.read("FOO", KeySet.all(), Arrays.asList("BAR"))) {
            while (rs.next()) {
              count++;
            }
          }
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          transaction = manager.resetForRetry();
        }
      }
    }
    assertThat(attempts).isGreaterThan(1);
  }

  @SuppressWarnings("resource")
  @Test
  public void transactionManagerReadUsingIndexInvalidatedDuringTransaction()
      throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    int attempts = 0;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        attempts++;
        int count = 0;
        try {
          try (ResultSet rs =
              transaction.readUsingIndex("FOO", "IDX", KeySet.all(), Arrays.asList("BAR"))) {
            while (rs.next()) {
              count++;
            }
          }
          assertThat(count).isEqualTo(2);
          if (attempts == 1) {
            invalidateSessionPool();
          }
          try (ResultSet rs =
              transaction.readUsingIndex("FOO", "IDX", KeySet.all(), Arrays.asList("BAR"))) {
            while (rs.next()) {
              count++;
            }
          }
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          transaction = manager.resetForRetry();
        }
      }
    }
    assertThat(attempts).isGreaterThan(1);
  }

  @SuppressWarnings("resource")
  @Test
  public void transactionManagerReadRowInvalidatedDuringTransaction() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    int attempts = 0;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        attempts++;
        try {
          Struct row = transaction.readRow("FOO", Key.of(), Arrays.asList("BAR"));
          assertThat(row.getLong(0)).isEqualTo(1L);
          if (attempts == 1) {
            invalidateSessionPool();
          }
          row = transaction.readRow("FOO", Key.of(), Arrays.asList("BAR"));
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          transaction = manager.resetForRetry();
        }
      }
    }
    assertThat(attempts).isGreaterThan(1);
  }

  @SuppressWarnings("resource")
  @Test
  public void transactionManagerReadRowUsingIndexInvalidatedDuringTransaction()
      throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    int attempts = 0;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        attempts++;
        try {
          Struct row = transaction.readRowUsingIndex("FOO", "IDX", Key.of(), Arrays.asList("BAR"));
          assertThat(row.getLong(0)).isEqualTo(1L);
          if (attempts == 1) {
            invalidateSessionPool();
          }
          row = transaction.readRowUsingIndex("FOO", "IDX", Key.of(), Arrays.asList("BAR"));
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          transaction = manager.resetForRetry();
        }
      }
    }
    assertThat(attempts).isGreaterThan(1);
  }

  @Test
  public void partitionedDml() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    assertThat(client.executePartitionedUpdate(UPDATE_STATEMENT)).isEqualTo(UPDATE_COUNT);
  }

  @Test
  public void write() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    Timestamp timestamp = client.write(Arrays.asList(Mutation.delete("FOO", KeySet.all())));
    assertThat(timestamp).isNotNull();
  }

  @Test
  public void writeAtLeastOnce() throws InterruptedException {
    if (failOnInvalidatedSession) {
      expected.expect(SessionNotFoundException.class);
    }
    initReadWriteSessionPool();
    invalidateSessionPool();
    Timestamp timestamp =
        client.writeAtLeastOnce(Arrays.asList(Mutation.delete("FOO", KeySet.all())));
    assertThat(timestamp).isNotNull();
  }
}
