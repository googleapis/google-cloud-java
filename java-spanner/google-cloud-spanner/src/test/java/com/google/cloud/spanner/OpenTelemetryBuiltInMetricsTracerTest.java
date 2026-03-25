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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;

import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.connection.RandomResultSetGenerator;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Range;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.opencensus.trace.Tracing;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OpenTelemetryBuiltInMetricsTracerTest extends AbstractNettyMockServerTest {
  private static final Statement SELECT_RANDOM = Statement.of("SELECT * FROM random");
  private static final Statement UPDATE_RANDOM = Statement.of("UPDATE random SET foo=1 WHERE id=1");
  private static InMemoryMetricReader metricReader;
  private static final Map<String, String> attributes =
      BuiltInMetricsProvider.INSTANCE.createClientAttributes();
  private static final Attributes expectedCommonBaseAttributes =
      Attributes.builder()
          .put(BuiltInMetricsConstant.CLIENT_NAME_KEY, "spanner-java/")
          .put(BuiltInMetricsConstant.CLIENT_UID_KEY, attributes.get("client_uid"))
          .put(BuiltInMetricsConstant.INSTANCE_ID_KEY, "i")
          .put(BuiltInMetricsConstant.DATABASE_KEY, "d")
          .put(BuiltInMetricsConstant.DIRECT_PATH_ENABLED_KEY, "false")
          .put(BuiltInMetricsConstant.DIRECT_PATH_USED_KEY, "false")
          .build();
  private static final double MIN_LATENCY = 0;

  private DatabaseClient client;

  public ApiTracerFactory createMetricsTracerFactory() {
    metricReader = InMemoryMetricReader.create();

    SdkMeterProviderBuilder meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader);
    BuiltInMetricsConstant.getAllViews().forEach(meterProvider::registerView);
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProvider.build()).build();

    return new BuiltInMetricsTracerFactory(
        new BuiltInMetricsRecorder(openTelemetry, BuiltInMetricsConstant.METER_NAME),
        attributes,
        new TraceWrapper(
            Tracing.getTracer(),
            openTelemetry.getTracer(
                MetricRegistryConstants.INSTRUMENTATION_SCOPE,
                GaxProperties.getLibraryVersion(getClass())),
            true));
  }

  @BeforeClass
  public static void setupResults() {
    RandomResultSetGenerator generator = new RandomResultSetGenerator(1);
    mockSpanner.putStatementResult(StatementResult.query(SELECT_RANDOM, generator.generate()));
    mockSpanner.putStatementResults(StatementResult.update(UPDATE_RANDOM, 1L));
  }

  @After
  public void clearRequests() throws IOException {
    mockSpanner.clearRequests();
    metricReader.close();
  }

  @Override
  public void createSpannerInstance() {
    SpannerOptions.Builder builder = SpannerOptions.newBuilder();

    ApiTracerFactory metricsTracerFactory =
        new BuiltInMetricsTracerFactory(
            new BuiltInMetricsRecorder(OpenTelemetry.noop(), BuiltInMetricsConstant.METER_NAME),
            attributes,
            new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), true));
    // Set a quick polling algorithm to prevent this from slowing down the test unnecessarily.
    builder
        .getDatabaseAdminStubSettingsBuilder()
        .updateDatabaseDdlOperationSettings()
        .setPollingAlgorithm(
            OperationTimedPollAlgorithm.create(
                RetrySettings.newBuilder()
                    .setInitialRetryDelayDuration(Duration.ofNanos(1L))
                    .setMaxRetryDelayDuration(Duration.ofNanos(1L))
                    .setRetryDelayMultiplier(1.0)
                    .setTotalTimeoutDuration(Duration.ofMinutes(10L))
                    .build()));
    String endpoint = address.getHostString() + ":" + server.getPort();
    spanner =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setHost("http://" + endpoint)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setWaitForMinSessionsDuration(Duration.ofSeconds(5L))
                    .setFailOnSessionLeak()
                    .setSkipVerifyingBeginTransactionForMuxRW(true)
                    .build())
            // Setting this to false so that Spanner Options does not register Metrics Tracer
            // factory again.
            .setBuiltInMetricsEnabled(false)
            .setApiTracerFactory(createMetricsTracerFactory())
            .build()
            .getService();
    client = spanner.getDatabaseClient(DatabaseId.of("test-project", "i", "d"));
  }

  @Test
  public void testMetricsSingleUseQuery() {
    Stopwatch stopwatch = Stopwatch.createStarted();
    try (ResultSet resultSet = client.singleUse().executeQuery(SELECT_RANDOM)) {
      assertTrue(resultSet.next());
      assertFalse(resultSet.next());
    }

    double elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
    Attributes expectedAttributes =
        expectedCommonBaseAttributes.toBuilder()
            .put(BuiltInMetricsConstant.STATUS_KEY, "OK")
            .put(BuiltInMetricsConstant.METHOD_KEY, "Spanner.ExecuteStreamingSql")
            .build();

    MetricData operationLatencyMetricData =
        getMetricData(metricReader, BuiltInMetricsConstant.OPERATION_LATENCIES_NAME);
    assertNotNull(operationLatencyMetricData);
    double operationLatencyValue =
        getAggregatedValue(operationLatencyMetricData, expectedAttributes);
    assertThat(operationLatencyValue).isIn(Range.closed(MIN_LATENCY, elapsed));

    MetricData attemptLatencyMetricData =
        getMetricData(metricReader, BuiltInMetricsConstant.ATTEMPT_LATENCIES_NAME);
    assertNotNull(attemptLatencyMetricData);
    double attemptLatencyValue = getAggregatedValue(attemptLatencyMetricData, expectedAttributes);
    assertThat(attemptLatencyValue).isIn(Range.closed(MIN_LATENCY, elapsed));

    MetricData operationCountMetricData =
        getMetricData(metricReader, BuiltInMetricsConstant.OPERATION_COUNT_NAME);
    assertNotNull(operationCountMetricData);
    assertThat(getAggregatedValue(operationCountMetricData, expectedAttributes)).isEqualTo(1);

    MetricData attemptCountMetricData =
        getMetricData(metricReader, BuiltInMetricsConstant.ATTEMPT_COUNT_NAME);
    assertNotNull(attemptCountMetricData);
    assertThat(getAggregatedValue(attemptCountMetricData, expectedAttributes)).isEqualTo(1);

    assertFalse(
        checkIfMetricExists(metricReader, BuiltInMetricsConstant.GFE_CONNECTIVITY_ERROR_NAME));
    assertFalse(
        checkIfMetricExists(metricReader, BuiltInMetricsConstant.AFE_CONNECTIVITY_ERROR_NAME));
    // AFE metrics are enabled for DirectPath.
    MetricData afeLatencyMetricData =
        getMetricData(metricReader, BuiltInMetricsConstant.AFE_LATENCIES_NAME);
    double afeLatencyValue = getAggregatedValue(afeLatencyMetricData, expectedAttributes);
    assertEquals(fakeAFEServerTiming.get(), afeLatencyValue, 1e-6);
  }

  private boolean isJava8() {
    return JavaVersionUtil.getJavaMajorVersion() == 8;
  }

  private boolean isWindows() {
    return System.getProperty("os.name").toLowerCase().contains("windows");
  }

  @Test
  public void testMetricsWithGaxRetryUnaryRpc() {
    Stopwatch stopwatch = Stopwatch.createStarted();
    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofException(Status.UNAVAILABLE.asRuntimeException()));

    // Execute a simple read/write transaction using only mutations. This will use the
    // BeginTransaction RPC to start the transaction. That RPC will first return UNAVAILABLE, then
    // be retried by Gax, and succeed. The retry should show up in the tracing.
    client.write(ImmutableList.of(Mutation.newInsertBuilder("foo").set("bar").to(1L).build()));

    stopwatch.elapsed(TimeUnit.MILLISECONDS);

    Attributes expectedAttributesBeginTransactionOK =
        expectedCommonBaseAttributes.toBuilder()
            .put(BuiltInMetricsConstant.STATUS_KEY, "OK")
            .put(BuiltInMetricsConstant.METHOD_KEY, "Spanner.BeginTransaction")
            .build();

    Attributes expectedAttributesBeginTransactionFailed =
        expectedCommonBaseAttributes.toBuilder()
            .put(BuiltInMetricsConstant.STATUS_KEY, "UNAVAILABLE")
            .put(BuiltInMetricsConstant.METHOD_KEY, "Spanner.BeginTransaction")
            .build();

    MetricData attemptCountMetricData =
        getMetricData(metricReader, BuiltInMetricsConstant.ATTEMPT_COUNT_NAME);
    assertNotNull(attemptCountMetricData);
    assertThat(getAggregatedValue(attemptCountMetricData, expectedAttributesBeginTransactionOK))
        .isEqualTo(1);
    // Attempt count should have a failed metric point for Begin Transaction.
    assertThat(getAggregatedValue(attemptCountMetricData, expectedAttributesBeginTransactionFailed))
        .isEqualTo(1);

    MetricData operationCountMetricData =
        getMetricData(metricReader, BuiltInMetricsConstant.OPERATION_COUNT_NAME);
    assertNotNull(operationCountMetricData);
    assertThat(getAggregatedValue(operationCountMetricData, expectedAttributesBeginTransactionOK))
        .isEqualTo(1);
    // Operation count should not have a failed metric point for Begin Transaction as overall
    // operation is success..
    assertThat(
            getAggregatedValue(operationCountMetricData, expectedAttributesBeginTransactionFailed))
        .isEqualTo(0);
  }

  @Test
  public void testNoNetworkConnection() {
    assumeFalse(TestHelper.isMultiplexSessionDisabled());
    // Create a Spanner instance that tries to connect to a server that does not exist.
    // This simulates a bad network connection.
    SpannerOptions.Builder builder = SpannerOptions.newBuilder();

    // Set up the client to fail fast.
    builder
        .getSpannerStubSettingsBuilder()
        .applyToAllUnaryMethods(
            input -> {
              // This tells the Spanner client to fail directly if it gets an UNAVAILABLE exception.
              // The 10-second deadline is chosen to ensure that:
              // 1. The test fails within a reasonable amount of time if retries for whatever reason
              // has been re-enabled.
              // 2. The timeout is long enough to never be triggered during normal tests.
              input.setSimpleTimeoutNoRetriesDuration(Duration.ofSeconds(10L));
              return null;
            });

    Spanner spanner =
        builder
            .setProjectId("test-project")
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setHost("http://localhost:0")
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setMinSessions(0)
                    .setUseMultiplexedSession(true)
                    .setUseMultiplexedSessionForRW(true)
                    .setSkipVerifyingBeginTransactionForMuxRW(true)
                    .setFailOnSessionLeak()
                    .build())
            // Setting this to false so that Spanner Options does not register Metrics Tracer
            // factory again.
            .setBuiltInMetricsEnabled(false)
            .setApiTracerFactory(createMetricsTracerFactory())
            .build()
            .getService();
    String instance = "i";
    DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of("test-project", instance, "d"));

    // Using this client will return UNAVAILABLE, as the server is not reachable and we have
    // disabled retries.
    SpannerException exception =
        assertThrows(
            SpannerException.class, () -> client.singleUse().executeQuery(SELECT_RANDOM).next());
    assertEquals(ErrorCode.UNAVAILABLE, exception.getErrorCode());

    Attributes expectedAttributesCreateSessionOK =
        expectedCommonBaseAttributes.toBuilder()
            .put(BuiltInMetricsConstant.STATUS_KEY, "OK")
            .put(BuiltInMetricsConstant.METHOD_KEY, "Spanner.CreateSession")
            // Include the additional attributes that are added by the HeaderInterceptor in the
            // filter. Note that the DIRECT_PATH_USED attribute is not added, as the request never
            // leaves the client.
            .build();

    Attributes expectedAttributesCreateSessionFailed =
        expectedCommonBaseAttributes.toBuilder()
            .put(BuiltInMetricsConstant.STATUS_KEY, "UNAVAILABLE")
            .put(BuiltInMetricsConstant.METHOD_KEY, "Spanner.CreateSession")
            // Include the additional attributes that are added by the HeaderInterceptor in the
            // filter. Note that the DIRECT_PATH_USED attribute is not added, as the request never
            // leaves the client.
            .build();

    MetricData attemptCountMetricData =
        getMetricData(metricReader, BuiltInMetricsConstant.ATTEMPT_COUNT_NAME);
    assertNotNull(attemptCountMetricData);

    // Attempt count should have a failed metric point for CreateSession.
    assertEquals(
        1, getAggregatedValue(attemptCountMetricData, expectedAttributesCreateSessionFailed), 0);
    assertTrue(
        checkIfMetricExists(metricReader, BuiltInMetricsConstant.GFE_CONNECTIVITY_ERROR_NAME));
    assertTrue(
        checkIfMetricExists(metricReader, BuiltInMetricsConstant.AFE_CONNECTIVITY_ERROR_NAME));
  }

  @Test
  public void testNoServerTimingHeader() throws IOException, InterruptedException {
    // Create Spanner Object without headers
    InetSocketAddress addressNoHeader = new InetSocketAddress("localhost", 0);
    Server serverNoHeader =
        NettyServerBuilder.forAddress(addressNoHeader).addService(mockSpanner).build().start();
    String endpoint = address.getHostString() + ":" + serverNoHeader.getPort();
    Spanner spannerNoHeader =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setHost("http://" + endpoint)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    .setWaitForMinSessionsDuration(Duration.ofSeconds(5L))
                    .setFailOnSessionLeak()
                    .setSkipVerifyingBeginTransactionForMuxRW(true)
                    .build())
            // Setting this to false so that Spanner Options does not register Metrics Tracer
            // factory again.
            .setBuiltInMetricsEnabled(false)
            .setApiTracerFactory(createMetricsTracerFactory())
            .build()
            .getService();
    DatabaseClient databaseClientNoHeader =
        spannerNoHeader.getDatabaseClient(DatabaseId.of("test-project", "i", "d"));

    databaseClientNoHeader
        .readWriteTransaction()
        .run(transaction -> transaction.executeUpdate(UPDATE_RANDOM));

    Attributes expectedAttributes =
        expectedCommonBaseAttributes.toBuilder()
            .put(BuiltInMetricsConstant.STATUS_KEY, "OK")
            .put(BuiltInMetricsConstant.METHOD_KEY, "Spanner.ExecuteSql")
            .build();

    assertFalse(checkIfMetricExists(metricReader, BuiltInMetricsConstant.AFE_LATENCIES_NAME));
    assertFalse(checkIfMetricExists(metricReader, BuiltInMetricsConstant.GFE_LATENCIES_NAME));
    assertTrue(
        checkIfMetricExists(metricReader, BuiltInMetricsConstant.GFE_CONNECTIVITY_ERROR_NAME));
    assertTrue(
        checkIfMetricExists(metricReader, BuiltInMetricsConstant.AFE_CONNECTIVITY_ERROR_NAME));

    spannerNoHeader.close();
    serverNoHeader.shutdown();
    serverNoHeader.awaitTermination();
  }

  private MetricData getMetricData(InMemoryMetricReader reader, String metricName) {
    String fullMetricName = BuiltInMetricsConstant.METER_NAME + "/" + metricName;
    Collection<MetricData> allMetricData;

    // Fetch the MetricData with retries
    for (int attemptsLeft = 1000; attemptsLeft > 0; attemptsLeft--) {
      allMetricData = reader.collectAllMetrics();
      List<MetricData> matchingMetadata =
          allMetricData.stream()
              .filter(md -> md.getName().equals(fullMetricName))
              .collect(Collectors.toList());
      assertWithMessage(
              "Found multiple MetricData with the same name: %s, in: %s",
              fullMetricName, matchingMetadata)
          .that(matchingMetadata.size())
          .isAtMost(1);

      if (!matchingMetadata.isEmpty()) {
        return matchingMetadata.get(0);
      }

      try {
        Thread.sleep(1);
      } catch (InterruptedException interruptedException) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(interruptedException);
      }
    }

    fail(String.format("MetricData is missing for metric %s", fullMetricName));
    return null;
  }

  private boolean checkIfMetricExists(InMemoryMetricReader reader, String metricName) {
    String fullMetricName = BuiltInMetricsConstant.METER_NAME + "/" + metricName;

    for (int attemptsLeft = 1000; attemptsLeft > 0; attemptsLeft--) {
      boolean exists =
          reader.collectAllMetrics().stream().anyMatch(md -> md.getName().equals(fullMetricName));
      if (exists) {
        return true;
      }
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
      }
    }

    return false;
  }

  private float getAggregatedValue(MetricData metricData, Attributes attributes) {
    switch (metricData.getType()) {
      case HISTOGRAM:
        return metricData.getHistogramData().getPoints().stream()
            .filter(pd -> pd.getAttributes().equals(attributes))
            .map(data -> (float) data.getSum() / data.getCount())
            .findFirst()
            .orElse(0F);
      case LONG_SUM:
        return metricData.getLongSumData().getPoints().stream()
            .filter(pd -> pd.getAttributes().equals(attributes))
            .map(LongPointData::getValue)
            .findFirst()
            .orElse(0L);
      default:
        return 0;
    }
  }
}
