/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.v1.SpannerClient;
import com.google.cloud.spanner.v1.SpannerSettings;
import com.google.protobuf.ListValue;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.inprocess.InProcessServerBuilder;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Test aborted transaction behavior of {@link TransactionManager}. */
@RunWith(JUnit4.class)
public class TransactionManagerAbortedTest {
  private static final String PROJECT_ID = "PROJECT";
  private static final String INSTANCE_ID = "INSTANCE";
  private static final String DATABASE_ID = "DATABASE";
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
  private static final com.google.spanner.v1.ResultSet SELECT1AND2_RESULTSET =
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
  private static final Statement UPDATE_ABORTED_STATEMENT =
      Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=2 AND THIS_WILL_ABORT=TRUE");
  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static LocalChannelProvider channelProvider;
  private static SpannerClient spannerClient;
  private static Spanner spanner;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockSpanner.putStatementResult(
        StatementResult.read("FOO", KeySet.all(), Arrays.asList("BAR"), READ_RESULTSET));
    mockSpanner.putStatementResult(
        StatementResult.read(
            "FOO", KeySet.singleKey(Key.of()), Arrays.asList("BAR"), READ_ROW_RESULTSET));
    mockSpanner.putStatementResult(StatementResult.query(SELECT1AND2, SELECT1AND2_RESULTSET));
    mockSpanner.putStatementResult(StatementResult.update(UPDATE_STATEMENT, UPDATE_COUNT));
    mockSpanner.putStatementResult(
        StatementResult.exception(
            UPDATE_ABORTED_STATEMENT,
            Status.ABORTED.withDescription("Transaction was aborted").asRuntimeException()));

    String uniqueName = InProcessServerBuilder.generateName();
    server =
        InProcessServerBuilder.forName(uniqueName)
            // We need to use a real executor for timeouts to occur.
            .scheduledExecutorService(new ScheduledThreadPoolExecutor(1))
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
  public void setUp() throws Exception {
    mockSpanner.reset();
    mockSpanner.removeAllExecutionTimes();
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance());
    spanner = builder.build().getService();
  }

  @After
  public void tearDown() throws Exception {
    spanner.close();
  }

  @Test
  public void testTransactionManagerAbortOnCommit() throws InterruptedException {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DATABASE_ID));
    int attempts = 0;
    try (TransactionManager manager = client.transactionManager()) {
      manager.begin();
      while (true) {
        attempts++;
        try {
          if (attempts == 1) {
            mockSpanner.abortAllTransactions();
          }
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          manager.resetForRetry();
        }
      }
    }
    assertThat(attempts, is(equalTo(2)));
  }

  @SuppressWarnings("resource")
  @Test
  public void testTransactionManagerAbortOnUpdate() throws InterruptedException {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DATABASE_ID));
    int attempts = 0;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext txn = manager.begin();
      while (true) {
        attempts++;
        try {
          if (attempts == 1) {
            mockSpanner.abortAllTransactions();
          }
          long updateCount = txn.executeUpdate(UPDATE_STATEMENT);
          assertThat(updateCount, is(equalTo(UPDATE_COUNT)));
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          txn = manager.resetForRetry();
        }
      }
    }
    assertThat(attempts, is(equalTo(2)));
  }

  @SuppressWarnings("resource")
  @Test
  public void testTransactionManagerAbortOnBatchUpdate() throws InterruptedException {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DATABASE_ID));
    int attempts = 0;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext txn = manager.begin();
      while (true) {
        attempts++;
        try {
          if (attempts == 1) {
            mockSpanner.abortAllTransactions();
          }
          long[] updateCounts = txn.batchUpdate(Arrays.asList(UPDATE_STATEMENT, UPDATE_STATEMENT));
          assertThat(updateCounts, is(equalTo(new long[] {UPDATE_COUNT, UPDATE_COUNT})));
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          txn = manager.resetForRetry();
        }
      }
    }
    assertThat(attempts, is(equalTo(2)));
  }

  @SuppressWarnings("resource")
  @Test
  public void testTransactionManagerAbortOnBatchUpdateHalfway() throws InterruptedException {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DATABASE_ID));
    int attempts = 0;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext txn = manager.begin();
      while (true) {
        attempts++;
        try {
          if (attempts == 1) {
            txn.batchUpdate(Arrays.asList(UPDATE_STATEMENT, UPDATE_ABORTED_STATEMENT));
            fail("missing expected AbortedException");
          }
          long[] updateCounts = txn.batchUpdate(Arrays.asList(UPDATE_STATEMENT, UPDATE_STATEMENT));
          assertThat(updateCounts, is(equalTo(new long[] {UPDATE_COUNT, UPDATE_COUNT})));
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          txn = manager.resetForRetry();
        }
      }
    }
    assertThat(attempts, is(equalTo(2)));
  }

  @SuppressWarnings("resource")
  @Test
  public void testTransactionManagerAbortOnSelect() throws InterruptedException {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DATABASE_ID));
    int attempts = 0;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext txn = manager.begin();
      while (true) {
        attempts++;
        try {
          if (attempts == 1) {
            mockSpanner.abortAllTransactions();
          }
          try (ResultSet rs = txn.executeQuery(SELECT1AND2)) {
            int rows = 0;
            while (rs.next()) {
              rows++;
            }
            assertThat(rows, is(equalTo(2)));
          }
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          txn = manager.resetForRetry();
        }
      }
    }
    assertThat(attempts, is(equalTo(2)));
  }

  @SuppressWarnings("resource")
  @Test
  public void testTransactionManagerAbortOnRead() throws InterruptedException {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DATABASE_ID));
    int attempts = 0;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext txn = manager.begin();
      while (true) {
        attempts++;
        try {
          if (attempts == 1) {
            mockSpanner.abortAllTransactions();
          }
          try (ResultSet rs = txn.read("FOO", KeySet.all(), Arrays.asList("BAR"))) {
            int rows = 0;
            while (rs.next()) {
              rows++;
            }
            assertThat(rows, is(equalTo(2)));
          }
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          txn = manager.resetForRetry();
        }
      }
    }
    assertThat(attempts, is(equalTo(2)));
  }

  @SuppressWarnings("resource")
  @Test
  public void testTransactionManagerAbortOnReadUsingIndex() throws InterruptedException {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DATABASE_ID));
    int attempts = 0;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext txn = manager.begin();
      while (true) {
        attempts++;
        try {
          if (attempts == 1) {
            mockSpanner.abortAllTransactions();
          }
          try (ResultSet rs =
              txn.readUsingIndex("FOO", "INDEX", KeySet.all(), Arrays.asList("BAR"))) {
            int rows = 0;
            while (rs.next()) {
              rows++;
            }
            assertThat(rows, is(equalTo(2)));
          }
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          txn = manager.resetForRetry();
        }
      }
    }
    assertThat(attempts, is(equalTo(2)));
  }

  @SuppressWarnings("resource")
  @Test
  public void testTransactionManagerAbortOnReadRow() throws InterruptedException {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DATABASE_ID));
    int attempts = 0;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext txn = manager.begin();
      while (true) {
        attempts++;
        try {
          if (attempts == 1) {
            mockSpanner.abortAllTransactions();
          }
          Struct row = txn.readRow("FOO", Key.of(), Arrays.asList("BAR"));
          assertThat(row.getLong(0), is(equalTo(1L)));
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          txn = manager.resetForRetry();
        }
      }
    }
    assertThat(attempts, is(equalTo(2)));
  }

  @SuppressWarnings("resource")
  @Test
  public void testTransactionManagerAbortOnReadRowUsingIndex() throws InterruptedException {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of(PROJECT_ID, INSTANCE_ID, DATABASE_ID));
    int attempts = 0;
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext txn = manager.begin();
      while (true) {
        attempts++;
        try {
          if (attempts == 1) {
            mockSpanner.abortAllTransactions();
          }
          Struct row = txn.readRowUsingIndex("FOO", "INDEX", Key.of(), Arrays.asList("BAR"));
          assertThat(row.getLong(0), is(equalTo(1L)));
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          txn = manager.resetForRetry();
        }
      }
    }
    assertThat(attempts, is(equalTo(2)));
  }
}
