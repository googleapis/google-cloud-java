/*
 * Copyright 2026 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.common.base.Stopwatch;
import com.google.protobuf.ListValue;
import com.google.rpc.RetryInfo;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TypeCode;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.protobuf.ProtoUtils;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests that the streaming resume loop in {@link ResumableStreamIterator} honors the {@link
 * RetrySettings#getMaxAttempts()} and {@link RetrySettings#getTotalTimeout()} that have been
 * configured for ExecuteStreamingSql and StreamingRead, instead of retrying indefinitely, while the
 * default settings (no maximum number of attempts) keep the existing unbounded resume behavior.
 *
 * <p>Setting {@code maxAttempts=1} is the supported way to disable streaming retries, as requested
 * in https://github.com/googleapis/google-cloud-java/issues/12255; an empty retryable-code set
 * alone does not disable retries for intrinsically retryable errors. The tests in this class drive
 * a real {@link Spanner} client against an in-process mock Spanner server, so the entire client
 * stack (client -> GAX -> resume loop) is exercised.
 */
@RunWith(JUnit4.class)
public class StreamingRetryBudgetMockServerTest {
  private static final Statement SELECT_QUERY = Statement.of("SELECT C FROM T");
  private static final int ROW_COUNT = 4;
  private static final ResultSetMetadata METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName("C")
                          .setType(
                              com.google.spanner.v1.Type.newBuilder()
                                  .setCode(TypeCode.INT64)
                                  .build())
                          .build())
                  .build())
          .build();
  private static final StatusRuntimeException UNAVAILABLE =
      Status.UNAVAILABLE.withDescription("Retryable test exception.").asRuntimeException();
  private static final StatusRuntimeException DEADLINE_EXCEEDED =
      Status.DEADLINE_EXCEEDED.withDescription("Test deadline exceeded.").asRuntimeException();
  private static final StatusRuntimeException RESOURCE_EXHAUSTED_WITH_RETRY_DELAY =
      Status.RESOURCE_EXHAUSTED
          .withDescription("Retryable test exception with retry delay.")
          .asRuntimeException(createRetryInfoTrailers());

  private static Metadata createRetryInfoTrailers() {
    Metadata trailers = new Metadata();
    RetryInfo retryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(
                com.google.protobuf.Duration.newBuilder()
                    .setNanos((int) TimeUnit.MILLISECONDS.toNanos(10L))
                    .setSeconds(0L)
                    .build())
            .build();
    trailers.put(ProtoUtils.keyForProto(RetryInfo.getDefaultInstance()), retryInfo);
    return trailers;
  }

  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static ScheduledThreadPoolExecutor scheduledExecutor;
  private static LocalChannelProvider channelProvider;

  private Spanner spanner;
  private DatabaseClient client;
  private Spanner spannerWithCustomRetrySettings;
  private DatabaseClient clientWithCustomRetrySettings;
  private Spanner spannerWithoutRetries;
  private DatabaseClient clientWithoutRetries;
  private Spanner spannerWithTotalTimeout;
  private DatabaseClient clientWithTotalTimeout;

  private static com.google.spanner.v1.ResultSet createResultSet(int rowCount) {
    com.google.spanner.v1.ResultSet.Builder builder =
        com.google.spanner.v1.ResultSet.newBuilder().setMetadata(METADATA);
    for (int row = 0; row < rowCount; row++) {
      builder.addRows(
          ListValue.newBuilder()
              .addValues(
                  com.google.protobuf.Value.newBuilder()
                      .setStringValue(String.valueOf(row))
                      .build())
              .build());
    }
    return builder.build();
  }

  @BeforeClass
  public static void startStaticServer() throws Exception {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockSpanner.putStatementResult(StatementResult.query(SELECT_QUERY, createResultSet(ROW_COUNT)));
    mockSpanner.putStatementResult(
        StatementResult.read(
            "T", KeySet.all(), Collections.singletonList("C"), createResultSet(ROW_COUNT)));

    scheduledExecutor = new ScheduledThreadPoolExecutor(1);
    String uniqueName = InProcessServerBuilder.generateName();
    server =
        InProcessServerBuilder.forName(uniqueName)
            // We need to use a real executor for timeouts to occur.
            .scheduledExecutorService(scheduledExecutor)
            .addService(mockSpanner)
            .build()
            .start();
    channelProvider = LocalChannelProvider.create(uniqueName);
  }

  @AfterClass
  public static void stopServer() throws InterruptedException {
    if (server != null) {
      server.shutdown();
      server.awaitTermination();
    }
    if (scheduledExecutor != null) {
      scheduledExecutor.shutdown();
      if (!scheduledExecutor.awaitTermination(10, TimeUnit.SECONDS)) {
        scheduledExecutor.shutdownNow();
      }
    }
  }

  @Before
  public void setUp() {
    mockSpanner.reset();
    mockSpanner.removeAllExecutionTimes();
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance());
    // Make sure the session pool is empty by default.
    SessionPoolOptions sessionPoolOptions =
        SessionPoolOptions.newBuilder().setMinSessions(0).build();
    // Add a wait time for sessions to be initialized. In this case, since minSessions = 0, the
    // wait time is for multiplexed sessions.
    if (sessionPoolOptions.getUseMultiplexedSession()) {
      sessionPoolOptions =
          sessionPoolOptions.toBuilder()
              .setWaitForMinSessionsDuration(Duration.ofSeconds(5))
              .build();
    }
    builder.setSessionPoolOption(sessionPoolOptions);

    // A client with the default retry settings for ExecuteStreamingSql. These settings do not set
    // a maximum number of attempts, meaning that the number of resume attempts is unlimited.
    spanner = builder.build().getService();
    client = spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));

    // A client with custom resiliency settings for ExecuteStreamingSql, similar to what a user
    // would configure: a small number of attempts, a per-attempt timeout, and DEADLINE_EXCEEDED
    // (and others) as retryable codes. The total timeout is deliberately kept large, so the tests
    // verify that maxAttempts is the limit that stops the retries.
    RetrySettings customRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(1L))
            .setMaxRetryDelayDuration(Duration.ofMillis(1L))
            .setRetryDelayMultiplier(1.0)
            .setInitialRpcTimeoutDuration(Duration.ofMillis(500L))
            .setMaxRpcTimeoutDuration(Duration.ofMillis(500L))
            .setMaxAttempts(2)
            .setTotalTimeoutDuration(Duration.ofSeconds(30L))
            .build();
    builder
        .getSpannerStubSettingsBuilder()
        .executeStreamingSqlSettings()
        .setRetryableCodes(Code.DEADLINE_EXCEEDED, Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED)
        .setRetrySettings(customRetrySettings);
    builder
        .getSpannerStubSettingsBuilder()
        .streamingReadSettings()
        .setRetryableCodes(Code.DEADLINE_EXCEEDED, Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED)
        .setRetrySettings(customRetrySettings);
    spannerWithCustomRetrySettings = builder.build().getService();
    clientWithCustomRetrySettings =
        spannerWithCustomRetrySettings.getDatabaseClient(
            DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));

    // A client that does not set a maximum number of attempts, but that does set a small total
    // timeout. The total timeout is the limit that stops the retries for this client.
    RetrySettings totalTimeoutRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(20L))
            .setMaxRetryDelayDuration(Duration.ofMillis(20L))
            .setRetryDelayMultiplier(1.0)
            .setInitialRpcTimeoutDuration(Duration.ofMillis(500L))
            .setMaxRpcTimeoutDuration(Duration.ofMillis(500L))
            .setTotalTimeoutDuration(Duration.ofMillis(200L))
            .build();
    builder
        .getSpannerStubSettingsBuilder()
        .executeStreamingSqlSettings()
        .setRetryableCodes(Code.DEADLINE_EXCEEDED, Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED)
        .setRetrySettings(totalTimeoutRetrySettings);
    builder
        .getSpannerStubSettingsBuilder()
        .streamingReadSettings()
        .setRetryableCodes(Code.DEADLINE_EXCEEDED, Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED)
        .setRetrySettings(totalTimeoutRetrySettings);
    spannerWithTotalTimeout = builder.build().getService();
    clientWithTotalTimeout =
        spannerWithTotalTimeout.getDatabaseClient(
            DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));

    // Leave retryable codes enabled in both layers: maxAttempts alone must disable retries.
    RetrySettings noRetries =
        customRetrySettings.toBuilder()
            .setMaxAttempts(1)
            .setTotalTimeoutDuration(Duration.ZERO)
            .build();
    builder
        .getSpannerStubSettingsBuilder()
        .executeStreamingSqlSettings()
        .setRetrySettings(noRetries);
    builder.getSpannerStubSettingsBuilder().streamingReadSettings().setRetrySettings(noRetries);
    spannerWithoutRetries = builder.build().getService();
    clientWithoutRetries =
        spannerWithoutRetries.getDatabaseClient(
            DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
  }

  @After
  public void tearDown() {
    spannerWithoutRetries.close();
    spannerWithTotalTimeout.close();
    spannerWithCustomRetrySettings.close();
    spanner.close();
  }

  @Test
  public void defaultStreamingRetrySettings_areNormalized() {
    RetrySettings expected =
        RetrySettings.newBuilder()
            .setTotalTimeoutDuration(Duration.ZERO)
            .setMaxAttempts(0)
            .setInitialRetryDelayDuration(Duration.ofMillis(10))
            .setMaxRetryDelayDuration(Duration.ofMillis(1000))
            .build();
    assertEquals(expected, spanner.getOptions().getSpannerRpcV1().getExecuteQueryRetrySettings());
    assertEquals(expected, spanner.getOptions().getSpannerRpcV1().getReadRetrySettings());
  }

  @Test(timeout = 60000L)
  public void maxAttemptsOne_disablesStreamingSqlRetries() {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStickyException(UNAVAILABLE));
    mockSpanner.clearRequests();
    try (ResultSet resultSet = clientWithoutRetries.singleUse().executeQuery(SELECT_QUERY)) {
      SpannerException exception = assertThrows(SpannerException.class, resultSet::next);
      assertEquals(ErrorCode.UNAVAILABLE, exception.getErrorCode());
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
  }

  @Test(timeout = 60000L)
  public void maxAttemptsOne_disablesStreamingReadRetries() {
    mockSpanner.setStreamingReadExecutionTime(
        SimulatedExecutionTime.ofStickyException(UNAVAILABLE));
    mockSpanner.clearRequests();
    try (ResultSet resultSet =
        clientWithoutRetries.singleUse().read("T", KeySet.all(), Collections.singletonList("C"))) {
      SpannerException exception = assertThrows(SpannerException.class, resultSet::next);
      assertEquals(ErrorCode.UNAVAILABLE, exception.getErrorCode());
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ReadRequest.class));
  }

  @Test(timeout = 60000L)
  public void maxAttemptsExhausted_stopsStreamingReadRetries() {
    mockSpanner.setStreamingReadExecutionTime(
        SimulatedExecutionTime.ofStickyException(DEADLINE_EXCEEDED));
    mockSpanner.clearRequests();
    try (ResultSet resultSet =
        clientWithCustomRetrySettings
            .singleUse()
            .read("T", KeySet.all(), Collections.singletonList("C"))) {
      SpannerException exception = assertThrows(SpannerException.class, resultSet::next);
      assertEquals(ErrorCode.DEADLINE_EXCEEDED, exception.getErrorCode());
    }
    // Both GAX and the resume loop allow two attempts, as with ExecuteStreamingSql.
    assertEquals(4, mockSpanner.countRequestsOfType(ReadRequest.class));
  }

  @Test(timeout = 60000L)
  public void totalTimeoutExhausted_stopsStreamingReadRetries() {
    mockSpanner.setStreamingReadExecutionTime(
        SimulatedExecutionTime.ofStickyException(UNAVAILABLE));
    mockSpanner.clearRequests();
    Stopwatch stopwatch = Stopwatch.createStarted();
    try (ResultSet resultSet =
        clientWithTotalTimeout
            .singleUse()
            .read("T", KeySet.all(), Collections.singletonList("C"))) {
      SpannerException exception = assertThrows(SpannerException.class, resultSet::next);
      // When GAX retries with a total timeout, it truncates the per-attempt RPC timeout
      // to the remaining time in totalTimeout. If that final attempt's deadline expires
      // before the server responds, gRPC fails with DEADLINE_EXCEEDED. Both UNAVAILABLE
      // and DEADLINE_EXCEEDED indicate that retries stopped because totalTimeout was exhausted.
      assertTrue(
          "Expected UNAVAILABLE or DEADLINE_EXCEEDED upon totalTimeout exhaustion, got: "
              + exception.getErrorCode(),
          exception.getErrorCode() == ErrorCode.UNAVAILABLE
              || exception.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED);
    }
    assertTrue(mockSpanner.countRequestsOfType(ReadRequest.class) > 1);
    assertTrue(stopwatch.elapsed(TimeUnit.MILLISECONDS) < 10000L);
  }

  /**
   * A query where every ExecuteStreamingSql attempt fails with DEADLINE_EXCEEDED must fail after
   * the configured maximum number of attempts. Without a bounded resume loop in {@link
   * ResumableStreamIterator} this test never finishes: every failed stream is resumed with a new
   * RPC, regardless of the configured maxAttempts and totalTimeout. The timeout on this test
   * ensures that such a regression fails the test instead of hanging the build.
   */
  @Test(timeout = 60000L)
  public void maxAttemptsExhausted_stopsStreamingRetries() {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStickyException(DEADLINE_EXCEEDED));
    mockSpanner.clearRequests();

    try (ResultSet resultSet =
        clientWithCustomRetrySettings.singleUse().executeQuery(SELECT_QUERY)) {
      SpannerException exception = assertThrows(SpannerException.class, resultSet::next);
      assertEquals(ErrorCode.DEADLINE_EXCEEDED, exception.getErrorCode());
    }
    // The retry settings are applied independently by two layers: the resume loop in
    // ResumableStreamIterator starts at most maxAttempts (2) streams, and each of those streams
    // is a GAX call that itself retries attempts that fail before the first response up to
    // maxAttempts (2) times. A configured maxAttempts of N therefore bounds the number of RPC
    // attempts without progress by N * N (here: 4), not by N. See the class documentation of
    // ResumableStreamIterator.
    assertEquals(4, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
  }

  /**
   * A query where every ExecuteStreamingSql attempt fails with a retryable error must fail once the
   * configured total timeout has been exhausted, also if no maximum number of attempts has been
   * set. Without a bounded resume loop this test never finishes.
   */
  @Test(timeout = 60000L)
  public void totalTimeoutExhausted_stopsStreamingRetries() {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStickyException(UNAVAILABLE));
    mockSpanner.clearRequests();

    Stopwatch stopwatch = Stopwatch.createStarted();
    try (ResultSet resultSet = clientWithTotalTimeout.singleUse().executeQuery(SELECT_QUERY)) {
      SpannerException exception = assertThrows(SpannerException.class, resultSet::next);
      // When GAX retries with a total timeout, it truncates the per-attempt RPC timeout
      // to the remaining time in totalTimeout. If that final attempt's deadline expires
      // before the server responds, gRPC fails with DEADLINE_EXCEEDED. Both UNAVAILABLE
      // and DEADLINE_EXCEEDED indicate that retries stopped because totalTimeout was exhausted.
      assertTrue(
          "Expected UNAVAILABLE or DEADLINE_EXCEEDED upon totalTimeout exhaustion, got: "
              + exception.getErrorCode(),
          exception.getErrorCode() == ErrorCode.UNAVAILABLE
              || exception.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED);
    }
    // The exact number of attempts depends on timing, but the query must have been retried at
    // least once, and must have failed shortly after the total timeout (200ms) elapsed. The
    // wall-clock bound is kept well above the total timeout to avoid flakiness on slow CI
    // machines, but far below the unbounded behavior that the fix prevents.
    assertTrue(mockSpanner.countRequestsOfType(ExecuteSqlRequest.class) > 1);
    assertTrue(stopwatch.elapsed(TimeUnit.MILLISECONDS) < 10000L);
  }

  /**
   * The total timeout must also be enforced when the retryable errors carry a server-supplied retry
   * delay (RetryInfo), as such errors bypass the exponential backoff. Without that, a client with
   * no maximum number of attempts and a total timeout would retry forever when the server keeps
   * returning, for example, RESOURCE_EXHAUSTED with a retry delay. Without a bounded resume loop
   * this test never finishes.
   */
  @Test(timeout = 60000L)
  public void totalTimeoutExhausted_withServerSuppliedRetryDelay_stopsStreamingRetries() {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStickyException(RESOURCE_EXHAUSTED_WITH_RETRY_DELAY));
    mockSpanner.clearRequests();

    Stopwatch stopwatch = Stopwatch.createStarted();
    try (ResultSet resultSet = clientWithTotalTimeout.singleUse().executeQuery(SELECT_QUERY)) {
      SpannerException exception = assertThrows(SpannerException.class, resultSet::next);
      // When GAX retries with a total timeout, it truncates the per-attempt RPC timeout
      // to the remaining time in totalTimeout. If that final attempt's deadline expires
      // before the server responds, gRPC fails with DEADLINE_EXCEEDED. Both RESOURCE_EXHAUSTED
      // and DEADLINE_EXCEEDED indicate that retries stopped because totalTimeout was exhausted.
      assertTrue(
          "Expected RESOURCE_EXHAUSTED or DEADLINE_EXCEEDED upon totalTimeout exhaustion, got: "
              + exception.getErrorCode(),
          exception.getErrorCode() == ErrorCode.RESOURCE_EXHAUSTED
              || exception.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED);
    }
    assertTrue(mockSpanner.countRequestsOfType(ExecuteSqlRequest.class) > 1);
    assertTrue(stopwatch.elapsed(TimeUnit.MILLISECONDS) < 10000L);
  }

  /**
   * The default retry settings do not set a maximum number of attempts. A client that uses the
   * default settings must keep today's behavior: the stream is resumed as often as needed, also
   * when the number of consecutive failures is higher than any small maximum.
   */
  @Test(timeout = 60000L)
  public void defaultRetrySettings_keepsUnboundedResumes() {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofExceptions(Collections.nCopies(5, UNAVAILABLE)));
    mockSpanner.clearRequests();

    int rows = 0;
    try (ResultSet resultSet = client.singleUse().executeQuery(SELECT_QUERY)) {
      while (resultSet.next()) {
        rows++;
      }
    }
    assertEquals(ROW_COUNT, rows);
    // 5 failed attempts + 1 successful attempt.
    assertEquals(6, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
  }

  @Test(timeout = 60000L)
  public void defaultRetrySettings_keepsUnboundedReadResumes() {
    mockSpanner.setStreamingReadExecutionTime(
        SimulatedExecutionTime.ofExceptions(Collections.nCopies(5, UNAVAILABLE)));
    mockSpanner.clearRequests();
    int rows = 0;
    try (ResultSet resultSet =
        client.singleUse().read("T", KeySet.all(), Collections.singletonList("C"))) {
      while (resultSet.next()) {
        rows++;
      }
    }
    assertEquals(ROW_COUNT, rows);
    assertEquals(6, mockSpanner.countRequestsOfType(ReadRequest.class));
  }

  /**
   * Only consecutive failures count against the maximum number of attempts: any progress on the
   * stream resets the budget. A stream that fails, resumes and makes progress, and then fails again
   * must succeed with maxAttempts=2, as the two failures are not consecutive.
   */
  @Test(timeout = 60000L)
  public void progressOnStream_resetsAttempts() {
    // Break the stream after the second PartialResultSet of the first call, and again after the
    // second PartialResultSet of the second (resumed) call. Every PartialResultSet returned by the
    // mock server contains a resume token, so the client sees progress between the two failures.
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStreamExceptions(
            Arrays.asList(UNAVAILABLE, UNAVAILABLE), Arrays.asList(1L, 1L)));
    mockSpanner.clearRequests();

    int rows = 0;
    try (ResultSet resultSet =
        clientWithCustomRetrySettings.singleUse().executeQuery(SELECT_QUERY)) {
      while (resultSet.next()) {
        rows++;
      }
    }
    assertEquals(ROW_COUNT, rows);
    // The initial attempt and two resumed attempts.
    assertEquals(3, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
  }
}
