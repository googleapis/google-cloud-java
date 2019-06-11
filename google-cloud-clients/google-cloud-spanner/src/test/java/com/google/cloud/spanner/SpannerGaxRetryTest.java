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

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallSettings.Builder;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import com.google.cloud.spanner.v1.SpannerClient;
import com.google.cloud.spanner.v1.SpannerSettings;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.ListValue;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessServerBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
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
import org.threeten.bp.Duration;

@RunWith(Parameterized.class)
public class SpannerGaxRetryTest {
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
  private static final SimulatedExecutionTime ONE_SECOND =
      SimulatedExecutionTime.ofMinimumAndRandomTime(1000, 0);
  private static final StatusRuntimeException UNAVAILABLE =
      io.grpc.Status.UNAVAILABLE.withDescription("Retryable test exception.").asRuntimeException();
  private static final StatusRuntimeException FAILED_PRECONDITION =
      io.grpc.Status.FAILED_PRECONDITION
          .withDescription("Non-retryable test exception.")
          .asRuntimeException();
  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static LocalChannelProvider channelProvider;
  private static SpannerClient spannerClient;
  private static Spanner spanner;
  private static DatabaseClient client;

  @Parameter(0)
  public boolean enableGaxRetries;

  @Parameters(name = "enable GAX retries = {0}")
  public static Collection<Object[]> data() {
    List<Object[]> params = new ArrayList<>();
    params.add(new Object[] {true});
    params.add(new Object[] {false});
    return params;
  }

  @Rule public ExpectedException expectedException = ExpectedException.none();

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
    final RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(Duration.ofMillis(500L))
            .setMaxRpcTimeout(Duration.ofMillis(500L))
            .setMaxAttempts(3)
            .setTotalTimeout(Duration.ofMillis(1500L))
            .build();
    RetrySettings commitRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(Duration.ofMillis(5000L))
            .setMaxRpcTimeout(Duration.ofMillis(10000L))
            .setMaxAttempts(1)
            .setTotalTimeout(Duration.ofMillis(20000L))
            .build();
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance());
    builder
        .getSpannerStubSettingsBuilder()
        .applyToAllUnaryMethods(
            new ApiFunction<UnaryCallSettings.Builder<?, ?>, Void>() {
              @Override
              public Void apply(Builder<?, ?> input) {
                input.setRetrySettings(retrySettings);
                return null;
              }
            });
    builder.getSpannerStubSettingsBuilder().commitSettings().setRetrySettings(commitRetrySettings);
    builder
        .getSpannerStubSettingsBuilder()
        .executeStreamingSqlSettings()
        .setRetrySettings(retrySettings);
    builder.getSpannerStubSettingsBuilder().streamingReadSettings().setRetrySettings(retrySettings);
    if (!enableGaxRetries) {
      // Disable retries by removing all retryable codes.
      builder
          .getSpannerStubSettingsBuilder()
          .applyToAllUnaryMethods(
              new ApiFunction<UnaryCallSettings.Builder<?, ?>, Void>() {
                @Override
                public Void apply(Builder<?, ?> input) {
                  input.setRetryableCodes(ImmutableSet.<StatusCode.Code>of());
                  return null;
                }
              });
      builder
          .getSpannerStubSettingsBuilder()
          .executeStreamingSqlSettings()
          .setRetryableCodes(ImmutableSet.<StatusCode.Code>of());
      builder
          .getSpannerStubSettingsBuilder()
          .streamingReadSettings()
          .setRetryableCodes(ImmutableSet.<StatusCode.Code>of());
    }
    spanner = builder.build().getService();
    client = spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
  }

  @After
  public void tearDown() throws Exception {
    spanner.close();
  }

  private void warmUpSessionPool() {
    for (int i = 0; i < 10; i++) {
      int retryCount = 0;
      while (true) {
        try {
          TransactionRunner runner = client.readWriteTransaction();
          long updateCount =
              runner.run(
                  new TransactionCallable<Long>() {
                    @Override
                    public Long run(TransactionContext transaction) throws Exception {
                      return transaction.executeUpdate(UPDATE_STATEMENT);
                    }
                  });
          assertThat(updateCount, is(equalTo(UPDATE_COUNT)));
          break;
        } catch (SpannerException e) {
          // On slow systems there is a chance of DEADLINE_EXCEEDED errors.
          // These should be retried.
          retryCount++;
          if (e.getErrorCode() != ErrorCode.DEADLINE_EXCEEDED || retryCount > 10) {
            throw e;
          }
        }
      }
    }
    // Wait a little to allow the session pool to prepare read/write sessions.
    try {
      Thread.sleep(500L);
    } catch (InterruptedException e) {
    }
  }

  @Test
  public void singleUseTimeout() {
    if (enableGaxRetries) {
      expectedException.expect(SpannerMatchers.isSpannerException(ErrorCode.DEADLINE_EXCEEDED));
    }
    mockSpanner.setCreateSessionExecutionTime(ONE_SECOND);
    try (ResultSet rs = client.singleUse().executeQuery(SELECT1AND2)) {
      while (rs.next()) {}
    }
  }

  @Test
  public void singleUseUnavailable() {
    if (!enableGaxRetries) {
      expectedException.expect(SpannerMatchers.isSpannerException(ErrorCode.UNAVAILABLE));
    }
    mockSpanner.addException(UNAVAILABLE);
    try (ResultSet rs = client.singleUse().executeQuery(SELECT1AND2)) {
      while (rs.next()) {}
    }
  }

  @Test
  public void singleUseNonRetryableError() {
    expectedException.expect(SpannerMatchers.isSpannerException(ErrorCode.FAILED_PRECONDITION));
    mockSpanner.addException(FAILED_PRECONDITION);
    try (ResultSet rs = client.singleUse().executeQuery(SELECT1AND2)) {
      while (rs.next()) {}
    }
  }

  @Test
  public void singleUseNonRetryableErrorOnNext() {
    expectedException.expect(SpannerMatchers.isSpannerException(ErrorCode.FAILED_PRECONDITION));
    try (ResultSet rs = client.singleUse().executeQuery(SELECT1AND2)) {
      mockSpanner.addException(FAILED_PRECONDITION);
      while (rs.next()) {}
    }
  }

  @Test
  public void singleUseInternal() {
    expectedException.expect(SpannerMatchers.isSpannerException(ErrorCode.INTERNAL));
    mockSpanner.addException(new IllegalArgumentException());
    try (ResultSet rs = client.singleUse().executeQuery(SELECT1AND2)) {
      while (rs.next()) {}
    }
  }

  @Test
  public void singleUseReadOnlyTransactionTimeout() {
    if (enableGaxRetries) {
      expectedException.expect(SpannerMatchers.isSpannerException(ErrorCode.DEADLINE_EXCEEDED));
    }
    mockSpanner.setCreateSessionExecutionTime(ONE_SECOND);
    try (ResultSet rs = client.singleUseReadOnlyTransaction().executeQuery(SELECT1AND2)) {
      while (rs.next()) {}
    }
  }

  @Test
  public void singleUseReadOnlyTransactionUnavailable() {
    if (!enableGaxRetries) {
      expectedException.expect(SpannerMatchers.isSpannerException(ErrorCode.UNAVAILABLE));
    }
    mockSpanner.addException(UNAVAILABLE);
    try (ResultSet rs = client.singleUseReadOnlyTransaction().executeQuery(SELECT1AND2)) {
      while (rs.next()) {}
    }
  }

  @Test
  public void singleUseExecuteStreamingSqlTimeout() {
    // Streaming calls do not timeout.
    mockSpanner.setExecuteStreamingSqlExecutionTime(ONE_SECOND);
    try (ResultSet rs = client.singleUse().executeQuery(SELECT1AND2)) {
      while (rs.next()) {}
    }
  }

  @Test
  public void singleUseExecuteStreamingSqlUnavailable() {
    // executeStreamingSql is always retried by the Spanner library, even if gax retries have been
    // disabled.
    try (ResultSet rs = client.singleUse().executeQuery(SELECT1AND2)) {
      mockSpanner.addException(UNAVAILABLE);
      while (rs.next()) {}
    }
  }

  @Test
  public void readWriteTransactionTimeout() {
    warmUpSessionPool();
    if (enableGaxRetries) {
      expectedException.expect(SpannerMatchers.isSpannerException(ErrorCode.DEADLINE_EXCEEDED));
    }
    mockSpanner.setBeginTransactionExecutionTime(ONE_SECOND);
    TransactionRunner runner = client.readWriteTransaction();
    long updateCount =
        runner.run(
            new TransactionCallable<Long>() {
              @Override
              public Long run(TransactionContext transaction) throws Exception {
                return transaction.executeUpdate(UPDATE_STATEMENT);
              }
            });
    assertThat(updateCount, is(equalTo(UPDATE_COUNT)));
  }

  @Test
  public void readWriteTransactionUnavailable() {
    warmUpSessionPool();
    if (!enableGaxRetries) {
      expectedException.expect(SpannerMatchers.isSpannerException(ErrorCode.UNAVAILABLE));
    }
    mockSpanner.addException(UNAVAILABLE);
    TransactionRunner runner = client.readWriteTransaction();
    long updateCount =
        runner.run(
            new TransactionCallable<Long>() {
              @Override
              public Long run(TransactionContext transaction) throws Exception {
                return transaction.executeUpdate(UPDATE_STATEMENT);
              }
            });
    assertThat(updateCount, is(equalTo(UPDATE_COUNT)));
  }

  @SuppressWarnings("resource")
  @Test
  public void transactionManagerTimeout() {
    warmUpSessionPool();
    if (enableGaxRetries) {
      expectedException.expect(SpannerMatchers.isSpannerException(ErrorCode.DEADLINE_EXCEEDED));
    }
    mockSpanner.setBeginTransactionExecutionTime(ONE_SECOND);
    try (TransactionManager txManager = client.transactionManager()) {
      TransactionContext tx = txManager.begin();
      while (true) {
        try {
          assertThat(tx.executeUpdate(UPDATE_STATEMENT), is(equalTo(UPDATE_COUNT)));
          txManager.commit();
          break;
        } catch (AbortedException e) {
          tx = txManager.resetForRetry();
        }
      }
    }
  }

  @SuppressWarnings("resource")
  @Test
  public void transactionManagerUnavailable() {
    warmUpSessionPool();
    if (!enableGaxRetries) {
      expectedException.expect(SpannerMatchers.isSpannerException(ErrorCode.UNAVAILABLE));
    }
    mockSpanner.addException(UNAVAILABLE);
    try (TransactionManager txManager = client.transactionManager()) {
      TransactionContext tx = txManager.begin();
      while (true) {
        try {
          assertThat(tx.executeUpdate(UPDATE_STATEMENT), is(equalTo(UPDATE_COUNT)));
          txManager.commit();
          break;
        } catch (AbortedException e) {
          tx = txManager.resetForRetry();
        }
      }
    }
  }
}
