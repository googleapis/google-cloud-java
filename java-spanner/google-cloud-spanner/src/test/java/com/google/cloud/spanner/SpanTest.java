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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ListValue;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessServerBuilder;
import io.opencensus.trace.Tracing;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.lang.reflect.Modifier;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(TracerTest.class)
@RunWith(JUnit4.class)
public class SpanTest {

  private static final String TEST_PROJECT = "my-project";
  private static final String TEST_INSTANCE = "my-instance";
  private static final String TEST_DATABASE = "my-database";
  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static LocalChannelProvider channelProvider;
  private static final Statement UPDATE_STATEMENT =
      Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=2");
  private static final Statement INVALID_UPDATE_STATEMENT =
      Statement.of("UPDATE NON_EXISTENT_TABLE SET BAR=1 WHERE BAZ=2");
  private static final long UPDATE_COUNT = 1L;
  private static final Statement SELECT1 = Statement.of("SELECT 1 AS COL1");
  private static final ResultSetMetadata SELECT1_METADATA =
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
          .setMetadata(SELECT1_METADATA)
          .build();
  private Spanner spanner;
  private DatabaseClient client;
  private Spanner spannerWithTimeout;
  private DatabaseClient clientWithTimeout;

  private static InMemorySpanExporter openTelemetrySpanExporter;

  private static FailOnOverkillTraceComponentImpl failOnOverkillTraceComponent =
      new FailOnOverkillTraceComponentImpl();

  private static final SimulatedExecutionTime ONE_SECOND =
      SimulatedExecutionTime.ofMinimumAndRandomTime(1000, 0);
  private static final StatusRuntimeException FAILED_PRECONDITION =
      io.grpc.Status.FAILED_PRECONDITION
          .withDescription("Non-retryable test exception.")
          .asRuntimeException();

  @BeforeClass
  public static void startStaticServer() throws Exception {
    Assume.assumeTrue(
        "This test is only supported on JDK11 and lower",
        JavaVersionUtil.getJavaMajorVersion() < 12);

    // Use a little reflection to set the test tracer.
    // This is not possible in Java 12 and later.
    java.lang.reflect.Field field = Tracing.class.getDeclaredField("traceComponent");
    field.setAccessible(true);
    java.lang.reflect.Field modifiersField = null;
    try {
      modifiersField = java.lang.reflect.Field.class.getDeclaredField("modifiers");
    } catch (NoSuchFieldException e) {
      // Halt the test and ignore it.
      Assume.assumeTrue(
          "Skipping test as reflection is not allowed on reflection class in this JDK build",
          false);
    }
    modifiersField.setAccessible(true);
    // Remove the final modifier from the 'traceComponent' field.
    modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
    field.set(null, failOnOverkillTraceComponent);

    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockSpanner.putStatementResult(StatementResult.update(UPDATE_STATEMENT, UPDATE_COUNT));
    mockSpanner.putStatementResult(StatementResult.query(SELECT1, SELECT1_RESULTSET));
    mockSpanner.putStatementResult(
        StatementResult.exception(
            INVALID_UPDATE_STATEMENT,
            Status.INVALID_ARGUMENT.withDescription("invalid statement").asRuntimeException()));

    String uniqueName = InProcessServerBuilder.generateName();
    server =
        InProcessServerBuilder.forName(uniqueName)
            // We need to use a real executor for timeouts to occur.
            .scheduledExecutorService(new ScheduledThreadPoolExecutor(1))
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
  }

  @BeforeClass
  public static void setupOpenTelemetry() {
    SpannerOptions.resetActiveTracingFramework();
    SpannerOptions.enableOpenCensusTraces();
  }

  @Before
  public void setUp() throws Exception {
    failOnOverkillTraceComponent.clearSpans();
    failOnOverkillTraceComponent.clearAnnotations();
    // Incorporating OpenTelemetry configuration to ensure that OpenCensus traces are utilized by
    // default,
    // regardless of the presence of OpenTelemetry configuration.
    openTelemetrySpanExporter = InMemorySpanExporter.create();
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(openTelemetrySpanExporter))
            .build();

    GlobalOpenTelemetry.resetForTest();
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder()
            .setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
            .setTracerProvider(tracerProvider)
            .build();

    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId(TEST_PROJECT)
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setOpenTelemetry(openTelemetry)
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setMinSessions(2)
                    .setWaitForMinSessionsDuration(Duration.ofSeconds(10))
                    .build());

    spanner = builder.build().getService();

    client = spanner.getDatabaseClient(DatabaseId.of(TEST_PROJECT, TEST_INSTANCE, TEST_DATABASE));

    final RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(1L))
            .setMaxRetryDelayDuration(Duration.ofMillis(1L))
            .setInitialRpcTimeoutDuration(Duration.ofMillis(75L))
            .setMaxRpcTimeoutDuration(Duration.ofMillis(75L))
            .setMaxAttempts(3)
            .setTotalTimeoutDuration(Duration.ofMillis(200L))
            .build();
    RetrySettings commitRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(1L))
            .setMaxRetryDelayDuration(Duration.ofMillis(1L))
            .setInitialRpcTimeoutDuration(Duration.ofMillis(5000L))
            .setMaxRpcTimeoutDuration(Duration.ofMillis(10000L))
            .setMaxAttempts(1)
            .setTotalTimeoutDuration(Duration.ofMillis(20000L))
            .build();
    builder
        .getSpannerStubSettingsBuilder()
        .applyToAllUnaryMethods(
            input -> {
              input.setRetrySettings(retrySettings);
              return null;
            });
    builder
        .getSpannerStubSettingsBuilder()
        .executeStreamingSqlSettings()
        .setRetrySettings(retrySettings);
    builder.getSpannerStubSettingsBuilder().commitSettings().setRetrySettings(commitRetrySettings);
    builder
        .getSpannerStubSettingsBuilder()
        .executeStreamingSqlSettings()
        .setRetrySettings(retrySettings);
    builder.getSpannerStubSettingsBuilder().streamingReadSettings().setRetrySettings(retrySettings);
    spannerWithTimeout = builder.build().getService();
    clientWithTimeout =
        spannerWithTimeout.getDatabaseClient(
            DatabaseId.of(TEST_PROJECT, TEST_INSTANCE, TEST_DATABASE));
  }

  @After
  public void tearDown() {
    spanner.close();
    mockSpanner.reset();
    mockSpanner.removeAllExecutionTimes();
  }

  @Test
  public void singleUseNonRetryableErrorOnNext() {
    try (ResultSet rs = client.singleUse().executeQuery(SELECT1)) {
      mockSpanner.addException(FAILED_PRECONDITION);
      SpannerException e = assertThrows(SpannerException.class, () -> rs.next());
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
  }

  @Test
  public void singleUseExecuteStreamingSqlTimeout() {
    try (ResultSet rs = clientWithTimeout.singleUse().executeQuery(SELECT1)) {
      mockSpanner.setExecuteStreamingSqlExecutionTime(ONE_SECOND);
      SpannerException e = assertThrows(SpannerException.class, () -> rs.next());
      assertEquals(ErrorCode.DEADLINE_EXCEEDED, e.getErrorCode());
    }
  }

  @Test
  public void singleUse() {
    try (ResultSet rs = client.singleUse().executeQuery(SELECT1)) {
      while (rs.next()) {
        // Just consume the result set.
      }
    }
    verifySingleUseSpans();
  }

  @Test
  public void singleUseWithoutTryWithResources() {
    // NOTE: This is bad practice. Always use try-with-resources. This test is only here to verify
    // that our safeguards work.
    ResultSet rs = client.singleUse().executeQuery(SELECT1);
    while (rs.next()) {
      // Just consume the result set.
    }
    verifySingleUseSpans();
  }

  private void verifySingleUseSpans() {

    // OpenTelemetry spans should be 0 as OpenCensus is default enabled.
    assertEquals(openTelemetrySpanExporter.getFinishedSpanItems().size(), 0);

    // OpenCensus spans and events verification
    Map<String, Boolean> spans = failOnOverkillTraceComponent.getSpans();
    assertThat(spans).containsEntry("CloudSpanner.ReadOnlyTransaction", true);
    assertThat(spans).containsEntry("CloudSpannerOperation.ExecuteStreamingQuery", true);

    List<String> expectedAnnotationsForMultiplexedSession =
        ImmutableList.of(
            "Request for 1 multiplexed session returned 1 session", "Starting/Resuming stream");
    verifyAnnotations(
        failOnOverkillTraceComponent.getAnnotations().stream()
            .distinct()
            .collect(Collectors.toList()),
        expectedAnnotationsForMultiplexedSession);
  }

  @Test
  public void singleUseWithError() {
    Statement invalidStatement = Statement.of("select * from foo");
    mockSpanner.putStatementResults(
        StatementResult.exception(invalidStatement, Status.INVALID_ARGUMENT.asRuntimeException()));

    SpannerException spannerException =
        assertThrows(
            SpannerException.class,
            () -> client.singleUse().executeQuery(INVALID_UPDATE_STATEMENT).next());
    assertEquals(ErrorCode.INVALID_ARGUMENT, spannerException.getErrorCode());

    // OpenTelemetry spans should be 0 as OpenCensus is default enabled.
    assertEquals(openTelemetrySpanExporter.getFinishedSpanItems().size(), 0);

    // OpenCensus spans and events verification
    Map<String, Boolean> spans = failOnOverkillTraceComponent.getSpans();
    assertThat(spans).containsEntry("CloudSpanner.ReadOnlyTransaction", true);
    assertThat(spans).containsEntry("CloudSpannerOperation.ExecuteStreamingQuery", true);

    List<String> expectedAnnotationsForMultiplexedSession =
        ImmutableList.of(
            "Request for 1 multiplexed session returned 1 session",
            "Starting/Resuming stream",
            "Stream broken. Not safe to retry");
    verifyAnnotations(
        failOnOverkillTraceComponent.getAnnotations().stream()
            .distinct()
            .collect(Collectors.toList()),
        expectedAnnotationsForMultiplexedSession);
  }

  @Test
  public void multiUse() {
    try (ReadOnlyTransaction tx = client.readOnlyTransaction()) {
      try (ResultSet rs = tx.executeQuery(SELECT1)) {
        while (rs.next()) {
          // Just consume the result set.
        }
      }
    }

    Map<String, Boolean> spans = failOnOverkillTraceComponent.getSpans();
    assertThat(spans).containsEntry("CloudSpanner.ReadOnlyTransaction", true);
    assertThat(spans).containsEntry("CloudSpannerOperation.ExecuteStreamingQuery", true);

    List<String> expectedAnnotationsForMultiplexedSession =
        ImmutableList.of(
            "Request for 1 multiplexed session returned 1 session",
            "Starting/Resuming stream",
            "Creating Transaction",
            "Transaction Creation Done");
    verifyAnnotations(
        failOnOverkillTraceComponent.getAnnotations().stream()
            .distinct()
            .collect(Collectors.toList()),
        expectedAnnotationsForMultiplexedSession);
  }

  @Test
  public void transactionRunner() {
    TransactionRunner runner = client.readWriteTransaction();
    runner.run(transaction -> transaction.executeUpdate(UPDATE_STATEMENT));
    Map<String, Boolean> spans = failOnOverkillTraceComponent.getSpans();
    assertThat(spans).containsEntry("CloudSpanner.ReadWriteTransaction", true);
    assertThat(spans).containsEntry("CloudSpannerOperation.Commit", true);

    List<String> expectedAnnotationsForMultiplexedSessionsRW =
        ImmutableList.of(
            "Starting Transaction Attempt",
            "Starting Commit",
            "Commit Done",
            "Transaction Attempt Succeeded",
            "Request for 1 multiplexed session returned 1 session");
    verifyAnnotations(
        failOnOverkillTraceComponent.getAnnotations().stream()
            .distinct()
            .collect(Collectors.toList()),
        expectedAnnotationsForMultiplexedSessionsRW);
  }

  @Test
  public void transactionRunnerWithError() {
    TransactionRunner runner = client.readWriteTransaction();
    SpannerException e =
        assertThrows(
            SpannerException.class,
            () -> runner.run(transaction -> transaction.executeUpdate(INVALID_UPDATE_STATEMENT)));
    assertEquals(ErrorCode.INVALID_ARGUMENT, e.getErrorCode());

    Map<String, Boolean> spans = failOnOverkillTraceComponent.getSpans();

    assertEquals(spans.toString(), 3, spans.size());
    assertThat(spans).containsEntry("CloudSpannerOperation.CreateMultiplexedSession", true);
    assertThat(spans).containsEntry("CloudSpanner.ReadWriteTransaction", true);
    assertThat(spans).containsEntry("CloudSpannerOperation.ExecuteUpdate", true);

    List<String> expectedAnnotationsForMultiplexedSessionsRW =
        ImmutableList.of(
            "Starting Transaction Attempt",
            "Transaction Attempt Failed in user operation",
            "Request for 1 multiplexed session returned 1 session");
    verifyAnnotations(
        failOnOverkillTraceComponent.getAnnotations().stream()
            .distinct()
            .collect(Collectors.toList()),
        expectedAnnotationsForMultiplexedSessionsRW);
  }

  private void verifyAnnotations(List<String> actualAnnotations, List<String> expectedAnnotations) {
    assertEquals(
        expectedAnnotations.stream().sorted().collect(Collectors.toList()),
        actualAnnotations.stream().distinct().sorted().collect(Collectors.toList()));
  }

  private boolean isMultiplexedSessionsEnabled() {
    if (spanner.getOptions() == null || spanner.getOptions().getSessionPoolOptions() == null) {
      return false;
    }
    return spanner.getOptions().getSessionPoolOptions().getUseMultiplexedSession();
  }

  private boolean isMultiplexedSessionsEnabledForRW() {
    if (spanner.getOptions() == null || spanner.getOptions().getSessionPoolOptions() == null) {
      return false;
    }
    return spanner.getOptions().getSessionPoolOptions().getUseMultiplexedSessionForRW();
  }
}
