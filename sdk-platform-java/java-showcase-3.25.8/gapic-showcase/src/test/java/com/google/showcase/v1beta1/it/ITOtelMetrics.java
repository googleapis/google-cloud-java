/*
 * Copyright 2024 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.showcase.v1beta1.it;

import static org.junit.Assert.assertThrows;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.rpc.UnavailableException;
import com.google.api.gax.tracing.MetricsTracer;
import com.google.api.gax.tracing.MetricsTracerFactory;
import com.google.api.gax.tracing.OpenTelemetryMetricsRecorder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.truth.Truth;
import com.google.protobuf.Duration;
import com.google.rpc.Status;
import com.google.showcase.v1beta1.BlockRequest;
import com.google.showcase.v1beta1.BlockResponse;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoSettings;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import com.google.showcase.v1beta1.stub.EchoStub;
import com.google.showcase.v1beta1.stub.EchoStubSettings;
import io.grpc.ManagedChannelBuilder;
import io.grpc.opentelemetry.GrpcOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.Data;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.data.PointData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Showcase Test to confirm that metrics are being collected and that the correct metrics are being
 * recorded. Utilizes an in-memory metric reader to collect the data.
 *
 * <p>Every test flows through the same way and runs through the same assertions. First, all th
 * metrics are pulled in via {@link #getMetricDataList()} which are polled until all the metrics are
 * collected. Then the test will attempt check that reader collected the correct number of data
 * points in {@link #verifyPointDataSum(List, int)}. Then, check that the attributes to be collected
 * via {@link #verifyStatusAttribute(List, List)}. Finally, check that the status for each attempt
 * is correct.
 */
class ITOtelMetrics {
  private static final int DEFAULT_OPERATION_COUNT = 1;
  private static final String SERVICE_NAME = "ShowcaseTest";
  private static final String ATTEMPT_COUNT = SERVICE_NAME + "/attempt_count";
  private static final String OPERATION_COUNT = SERVICE_NAME + "/operation_count";
  private static final String ATTEMPT_LATENCY = SERVICE_NAME + "/attempt_latency";
  private static final String OPERATION_LATENCY = SERVICE_NAME + "/operation_latency";
  private static final Set<String> GAX_METRICS =
      ImmutableSet.of(ATTEMPT_COUNT, OPERATION_COUNT, ATTEMPT_LATENCY, OPERATION_LATENCY);

  // Gax provides four metrics by default. This number may change as new metrics are added.
  private static final int NUM_GAX_OTEL_METRICS = 4;
  private static final int NUM_DEFAULT_FLUSH_ATTEMPTS = 10;

  private InMemoryMetricReader inMemoryMetricReader;
  private EchoClient grpcClient;
  private EchoClient httpClient;

  /**
   * Internal class in the Otel Showcases test used to assert that number of status codes recorded.
   */
  private static class StatusCount {
    private final Code statusCode;
    private final int count;

    public StatusCount(Code statusCode) {
      this(statusCode, 1);
    }

    public StatusCount(Code statusCode, int count) {
      this.statusCode = statusCode;
      this.count = count;
    }

    public Code getStatusCode() {
      return statusCode;
    }

    public int getCount() {
      return count;
    }
  }

  private OpenTelemetryMetricsRecorder createOtelMetricsRecorder(
      InMemoryMetricReader inMemoryMetricReader) {
    SdkMeterProvider sdkMeterProvider =
        SdkMeterProvider.builder().registerMetricReader(inMemoryMetricReader).build();

    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(sdkMeterProvider).build();
    return new OpenTelemetryMetricsRecorder(openTelemetry, SERVICE_NAME);
  }

  @BeforeEach
  void setup() throws Exception {
    inMemoryMetricReader = InMemoryMetricReader.create();
    OpenTelemetryMetricsRecorder otelMetricsRecorder =
        createOtelMetricsRecorder(inMemoryMetricReader);
    grpcClient =
        TestClientInitializer.createGrpcEchoClientOpentelemetry(
            new MetricsTracerFactory(otelMetricsRecorder));
    httpClient =
        TestClientInitializer.createHttpJsonEchoClientOpentelemetry(
            new MetricsTracerFactory(otelMetricsRecorder));
  }

  @AfterEach
  void cleanup() throws InterruptedException, IOException {
    inMemoryMetricReader.close();
    inMemoryMetricReader.shutdown();

    grpcClient.close();
    httpClient.close();

    grpcClient.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    httpClient.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  /**
   * Iterate through all MetricData elements and check that the number of PointData values matches
   * the expected value. A PointData element may have multiple values/ counts inside, so this
   * extracts the value/ count from the PointData before summing.
   *
   * <p>The expected sum for an operation is `1`. Expected sum for an attempt may be 1+.
   */
  private void verifyPointDataSum(List<MetricData> metricDataList, int attemptCount) {
    for (MetricData metricData : metricDataList) {
      Data<?> data = metricData.getData();
      List<PointData> points = new ArrayList<>(data.getPoints());
      switch (metricData.getName()) {
        case OPERATION_COUNT:
          long operationCountSum =
              points.stream().map(x -> ((LongPointData) x).getValue()).reduce(0L, Long::sum);
          Truth.assertThat(operationCountSum).isEqualTo(DEFAULT_OPERATION_COUNT);
          break;
        case ATTEMPT_COUNT:
          long attemptCountSum =
              points.stream().map(x -> ((LongPointData) x).getValue()).reduce(0L, Long::sum);
          Truth.assertThat(attemptCountSum).isEqualTo(attemptCount);
          break;
        case OPERATION_LATENCY:
          long operationLatencyCountSum =
              points.stream().map(x -> ((HistogramPointData) x).getCount()).reduce(0L, Long::sum);
          // It is difficult to verify the actual latency values (operation or attempt)
          // without flaky behavior. Test that the number of data points recorded matches.
          Truth.assertThat(operationLatencyCountSum).isEqualTo(DEFAULT_OPERATION_COUNT);
          break;
        case ATTEMPT_LATENCY:
          long attemptLatencyCountSum =
              points.stream().map(x -> ((HistogramPointData) x).getCount()).reduce(0L, Long::sum);
          // It is difficult to verify the actual latency values (operation or attempt)
          // without flaky behavior. Test that the number of data points recorded matches.
          Truth.assertThat(attemptLatencyCountSum).isEqualTo(attemptCount);
          break;
        default:
          break;
      }
    }
  }

  /**
   * Extract the attributes from MetricData and ensures that default attributes are recorded. Uses
   * the `OPERATION_COUNT` MetricData to test the attributes. The `OPERATION_COUNT` is only recorded
   * once and should only have one element of PointData.
   *
   * <p>Although the Status attribute is recorded by default on every operation, this helper method
   * does not verify it. This is because every individual attempt (retry) may have a different
   * status. {@link #verifyStatusAttribute(List, List)} is used to verify the statuses for every
   * attempt.
   */
  private void verifyDefaultMetricsAttributes(
      List<MetricData> metricDataList, Map<String, String> defaultAttributeMapping) {
    Optional<MetricData> metricDataOptional =
        metricDataList.stream().filter(x -> x.getName().equals(OPERATION_COUNT)).findAny();
    Truth.assertThat(metricDataOptional.isPresent()).isTrue();
    MetricData operationCountMetricData = metricDataOptional.get();

    List<PointData> pointDataList = new ArrayList<>(operationCountMetricData.getData().getPoints());
    // Operation Metrics should only have a 1 data point
    Truth.assertThat(pointDataList.size()).isEqualTo(1);
    Attributes recordedAttributes = pointDataList.get(0).getAttributes();
    Map<AttributeKey<?>, Object> recordedAttributesMap = recordedAttributes.asMap();
    for (Map.Entry<String, String> entrySet : defaultAttributeMapping.entrySet()) {
      String key = entrySet.getKey();
      String value = entrySet.getValue();
      AttributeKey<String> stringAttributeKey = AttributeKey.stringKey(key);
      Truth.assertThat(recordedAttributesMap.containsKey(stringAttributeKey)).isTrue();
      Truth.assertThat(recordedAttributesMap.get(stringAttributeKey)).isEqualTo(value);
    }
  }

  /**
   * Extract the attributes from MetricData and ensures that default attributes are recorded. Uses
   * the `ATTEMPT_COUNT` MetricData to test the attributes. The `ATTEMPT_COUNT` is recorded for
   * every retry attempt and should record the status received that each attempt made.
   */
  private void verifyStatusAttribute(
      List<MetricData> metricDataList, List<StatusCount> statusCountList) {
    Optional<MetricData> metricDataOptional =
        metricDataList.stream().filter(x -> x.getName().equals(ATTEMPT_COUNT)).findAny();
    Truth.assertThat(metricDataOptional.isPresent()).isTrue();
    MetricData attemptCountMetricData = metricDataOptional.get();

    List<PointData> pointDataList = new ArrayList<>(attemptCountMetricData.getData().getPoints());
    Truth.assertThat(pointDataList.size()).isEqualTo(statusCountList.size());

    // The data for attempt count may not be ordered (i.e. the last data point recorded may be the
    // first element in the PointData list). Search for the expected StatusCode from the
    // statusCountList
    // and match with the data inside the pointDataList
    for (StatusCount statusCount : statusCountList) {
      Code statusCode = statusCount.getStatusCode();
      Predicate<PointData> pointDataPredicate =
          x ->
              x.getAttributes()
                  .get(AttributeKey.stringKey(MetricsTracer.STATUS_ATTRIBUTE))
                  .equals(statusCode.toString());
      Optional<PointData> pointDataOptional =
          pointDataList.stream().filter(pointDataPredicate).findFirst();
      Truth.assertThat(pointDataOptional.isPresent()).isTrue();
      LongPointData longPointData = (LongPointData) pointDataOptional.get();
      Truth.assertThat(longPointData.getValue()).isEqualTo(statusCount.getCount());
    }
  }

  /** Uses the default InMemoryMetricReader configured for showcase tests. */
  private List<MetricData> getMetricDataList() throws InterruptedException {
    return getMetricDataList(inMemoryMetricReader);
  }

  /**
   * Attempts to retrieve the metrics from a custom InMemoryMetricsReader. Sleep every second for at
   * most 10s to try and retrieve all the metrics available. If it is unable to retrieve all the
   * metrics, fail the test.
   */
  private List<MetricData> getMetricDataList(InMemoryMetricReader metricReader)
      throws InterruptedException {
    for (int i = 0; i < NUM_DEFAULT_FLUSH_ATTEMPTS; i++) {
      Thread.sleep(1000L);
      List<MetricData> metricData = new ArrayList<>(metricReader.collectAllMetrics());
      // Depending on the OpenTelemetry instance (i.e. OpenTelemetry, GrpcOpenTelemetry, etc.)
      // there may be additional metrics recorded. Only check to ensure the Gax Metrics
      // are recorded properly. Any additional metrics are fine to be passed.
      if (metricData.size() >= NUM_GAX_OTEL_METRICS && areAllGaxMetricsRecorded(metricData)) {
        return metricData;
      }
    }
    Assertions.fail("Unable to collect all the GAX metrics required for the test");
    return new ArrayList<>();
  }

  private boolean areAllGaxMetricsRecorded(List<MetricData> metricData) {
    return metricData.stream().filter(data -> GAX_METRICS.contains(data.getName())).count()
        == NUM_GAX_OTEL_METRICS;
  }

  @Test
  void testGrpc_operationSucceeded_recordsMetrics() throws InterruptedException {
    int attemptCount = 1;
    EchoRequest echoRequest =
        EchoRequest.newBuilder().setContent("test_grpc_operation_succeeded").build();
    grpcClient.echo(echoRequest);

    List<MetricData> actualMetricDataList = getMetricDataList();
    verifyPointDataSum(actualMetricDataList, attemptCount);

    Map<String, String> expectedAttributes =
        ImmutableMap.of(
            MetricsTracer.METHOD_ATTRIBUTE,
            "Echo.Echo",
            MetricsTracer.LANGUAGE_ATTRIBUTE,
            MetricsTracer.DEFAULT_LANGUAGE);
    verifyDefaultMetricsAttributes(actualMetricDataList, expectedAttributes);

    List<StatusCount> statusCountList = ImmutableList.of(new StatusCount(Code.OK));
    verifyStatusAttribute(actualMetricDataList, statusCountList);
  }

  @Test
  void testHttpJson_operationSucceeded_recordsMetrics() throws InterruptedException {
    int attemptCount = 1;
    EchoRequest echoRequest = EchoRequest.newBuilder().setContent("content").build();
    httpClient.echo(echoRequest);

    List<MetricData> actualMetricDataList = getMetricDataList();
    verifyPointDataSum(actualMetricDataList, attemptCount);

    Map<String, String> expectedAttributes =
        ImmutableMap.of(
            MetricsTracer.METHOD_ATTRIBUTE,
            "google.showcase.v1beta1.Echo/Echo",
            MetricsTracer.LANGUAGE_ATTRIBUTE,
            MetricsTracer.DEFAULT_LANGUAGE);
    verifyDefaultMetricsAttributes(actualMetricDataList, expectedAttributes);

    List<StatusCount> statusCountList = ImmutableList.of(new StatusCount(Code.OK));
    verifyStatusAttribute(actualMetricDataList, statusCountList);
  }

  @Test
  void testGrpc_operationCancelled_recordsMetrics() throws Exception {
    int attemptCount = 1;
    BlockRequest blockRequest =
        BlockRequest.newBuilder()
            .setResponseDelay(Duration.newBuilder().setSeconds(5))
            .setSuccess(BlockResponse.newBuilder().setContent("grpc_operationCancelled"))
            .build();

    UnaryCallable<BlockRequest, BlockResponse> blockCallable = grpcClient.blockCallable();
    ApiFuture<BlockResponse> blockResponseApiFuture = blockCallable.futureCall(blockRequest);
    // Sleep 1s before cancelling to let the request go through
    Thread.sleep(1000);
    blockResponseApiFuture.cancel(true);

    List<MetricData> actualMetricDataList = getMetricDataList();
    verifyPointDataSum(actualMetricDataList, attemptCount);

    Map<String, String> expectedAttributes =
        ImmutableMap.of(
            MetricsTracer.METHOD_ATTRIBUTE,
            "Echo.Block",
            MetricsTracer.LANGUAGE_ATTRIBUTE,
            MetricsTracer.DEFAULT_LANGUAGE);
    verifyDefaultMetricsAttributes(actualMetricDataList, expectedAttributes);

    List<StatusCount> statusCountList = ImmutableList.of(new StatusCount(Code.CANCELLED));
    verifyStatusAttribute(actualMetricDataList, statusCountList);
  }

  @Test
  void testHttpJson_operationCancelled_recordsMetrics() throws Exception {
    int attemptCount = 1;
    BlockRequest blockRequest =
        BlockRequest.newBuilder().setResponseDelay(Duration.newBuilder().setSeconds(5)).build();

    UnaryCallable<BlockRequest, BlockResponse> blockCallable = httpClient.blockCallable();
    ApiFuture<BlockResponse> blockResponseApiFuture = blockCallable.futureCall(blockRequest);
    // Sleep 1s before cancelling to let the request go through
    Thread.sleep(1000);
    blockResponseApiFuture.cancel(true);

    List<MetricData> actualMetricDataList = getMetricDataList();
    verifyPointDataSum(actualMetricDataList, attemptCount);

    Map<String, String> expectedAttributes =
        ImmutableMap.of(
            MetricsTracer.METHOD_ATTRIBUTE,
            "google.showcase.v1beta1.Echo/Block",
            MetricsTracer.LANGUAGE_ATTRIBUTE,
            MetricsTracer.DEFAULT_LANGUAGE);
    verifyDefaultMetricsAttributes(actualMetricDataList, expectedAttributes);

    List<StatusCount> statusCountList = ImmutableList.of(new StatusCount(Code.CANCELLED));
    verifyStatusAttribute(actualMetricDataList, statusCountList);
  }

  @Test
  void testGrpc_operationFailed_recordsMetrics() throws InterruptedException {
    int attemptCount = 1;
    Code statusCode = Code.INVALID_ARGUMENT;
    BlockRequest blockRequest =
        BlockRequest.newBuilder()
            .setResponseDelay(Duration.newBuilder().setSeconds(2))
            .setError(Status.newBuilder().setCode(statusCode.ordinal()))
            .build();

    UnaryCallable<BlockRequest, BlockResponse> blockCallable = grpcClient.blockCallable();
    ApiFuture<BlockResponse> blockResponseApiFuture = blockCallable.futureCall(blockRequest);
    assertThrows(ExecutionException.class, blockResponseApiFuture::get);

    List<MetricData> actualMetricDataList = getMetricDataList();
    verifyPointDataSum(actualMetricDataList, attemptCount);

    Map<String, String> expectedAttributes =
        ImmutableMap.of(
            MetricsTracer.METHOD_ATTRIBUTE,
            "Echo.Block",
            MetricsTracer.LANGUAGE_ATTRIBUTE,
            MetricsTracer.DEFAULT_LANGUAGE);
    verifyDefaultMetricsAttributes(actualMetricDataList, expectedAttributes);

    List<StatusCount> statusCountList = ImmutableList.of(new StatusCount(statusCode));
    verifyStatusAttribute(actualMetricDataList, statusCountList);
  }

  @Test
  void testHttpJson_operationFailed_recordsMetrics() throws InterruptedException {
    int attemptCount = 1;
    Code statusCode = Code.INVALID_ARGUMENT;
    BlockRequest blockRequest =
        BlockRequest.newBuilder()
            .setResponseDelay(Duration.newBuilder().setSeconds(2))
            .setError(Status.newBuilder().setCode(statusCode.ordinal()))
            .build();

    UnaryCallable<BlockRequest, BlockResponse> blockCallable = httpClient.blockCallable();
    ApiFuture<BlockResponse> blockResponseApiFuture = blockCallable.futureCall(blockRequest);
    assertThrows(ExecutionException.class, blockResponseApiFuture::get);

    List<MetricData> actualMetricDataList = getMetricDataList();
    verifyPointDataSum(actualMetricDataList, attemptCount);

    Map<String, String> expectedAttributes =
        ImmutableMap.of(
            MetricsTracer.METHOD_ATTRIBUTE,
            "google.showcase.v1beta1.Echo/Block",
            MetricsTracer.LANGUAGE_ATTRIBUTE,
            MetricsTracer.DEFAULT_LANGUAGE);
    verifyDefaultMetricsAttributes(actualMetricDataList, expectedAttributes);

    List<StatusCount> statusCountList = ImmutableList.of(new StatusCount(statusCode));
    verifyStatusAttribute(actualMetricDataList, statusCountList);
  }

  @Test
  void testGrpc_attemptFailedRetriesExhausted_recordsMetrics() throws Exception {
    int attemptCount = 3;
    Code statusCode = Code.UNAVAILABLE;
    // A custom EchoClient is used in this test because retries have jitter, and we cannot
    // predict the number of attempts that are scheduled for an RPC invocation otherwise.
    // The custom retrySettings limit to a set number of attempts before the call gives up.
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setTotalTimeout(org.threeten.bp.Duration.ofMillis(5000L))
            .setMaxAttempts(3)
            .build();

    EchoStubSettings.Builder grpcEchoSettingsBuilder = EchoStubSettings.newBuilder();
    grpcEchoSettingsBuilder
        .echoSettings()
        .setRetrySettings(retrySettings)
        .setRetryableCodes(ImmutableSet.of(statusCode));
    EchoSettings grpcEchoSettings = EchoSettings.create(grpcEchoSettingsBuilder.build());
    grpcEchoSettings =
        grpcEchoSettings.toBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            .setEndpoint("localhost:7469")
            .build();

    EchoStubSettings echoStubSettings =
        (EchoStubSettings)
            grpcEchoSettings.getStubSettings().toBuilder()
                .setTracerFactory(
                    new MetricsTracerFactory(createOtelMetricsRecorder(inMemoryMetricReader)))
                .build();
    EchoStub stub = echoStubSettings.createStub();
    EchoClient grpcClient = EchoClient.create(stub);

    EchoRequest echoRequest =
        EchoRequest.newBuilder()
            .setError(Status.newBuilder().setCode(statusCode.ordinal()).build())
            .build();

    assertThrows(UnavailableException.class, () -> grpcClient.echo(echoRequest));

    List<MetricData> actualMetricDataList = getMetricDataList();
    verifyPointDataSum(actualMetricDataList, attemptCount);

    Map<String, String> expectedAttributes =
        ImmutableMap.of(
            MetricsTracer.METHOD_ATTRIBUTE,
            "Echo.Echo",
            MetricsTracer.LANGUAGE_ATTRIBUTE,
            MetricsTracer.DEFAULT_LANGUAGE);
    verifyDefaultMetricsAttributes(actualMetricDataList, expectedAttributes);

    List<StatusCount> statusCountList = ImmutableList.of(new StatusCount(statusCode, 3));
    verifyStatusAttribute(actualMetricDataList, statusCountList);

    grpcClient.close();
    grpcClient.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  @Test
  void testHttpJson_attemptFailedRetriesExhausted_recordsMetrics() throws Exception {
    int attemptCount = 3;
    Code statusCode = Code.UNAVAILABLE;
    // A custom EchoClient is used in this test because retries have jitter, and we cannot
    // predict the number of attempts that are scheduled for an RPC invocation otherwise.
    // The custom retrySettings limit to a set number of attempts before the call gives up.
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setTotalTimeout(org.threeten.bp.Duration.ofMillis(5000L))
            .setMaxAttempts(3)
            .build();

    EchoStubSettings.Builder httpJsonEchoSettingsBuilder = EchoStubSettings.newHttpJsonBuilder();
    httpJsonEchoSettingsBuilder
        .echoSettings()
        .setRetrySettings(retrySettings)
        .setRetryableCodes(ImmutableSet.of(statusCode));
    EchoSettings httpJsonEchoSettings = EchoSettings.create(httpJsonEchoSettingsBuilder.build());
    httpJsonEchoSettings =
        httpJsonEchoSettings.toBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(
                        new NetHttpTransport.Builder().doNotValidateCertificate().build())
                    .setEndpoint("http://localhost:7469")
                    .build())
            .build();

    EchoStubSettings echoStubSettings =
        (EchoStubSettings)
            httpJsonEchoSettings.getStubSettings().toBuilder()
                .setTracerFactory(
                    new MetricsTracerFactory(createOtelMetricsRecorder(inMemoryMetricReader)))
                .build();
    EchoStub stub = echoStubSettings.createStub();
    EchoClient httpClient = EchoClient.create(stub);

    EchoRequest echoRequest =
        EchoRequest.newBuilder()
            .setError(Status.newBuilder().setCode(statusCode.ordinal()).build())
            .build();

    assertThrows(UnavailableException.class, () -> httpClient.echo(echoRequest));

    List<MetricData> actualMetricDataList = getMetricDataList();
    verifyPointDataSum(actualMetricDataList, attemptCount);

    Map<String, String> expectedAttributes =
        ImmutableMap.of(
            MetricsTracer.METHOD_ATTRIBUTE,
            "google.showcase.v1beta1.Echo/Echo",
            MetricsTracer.LANGUAGE_ATTRIBUTE,
            MetricsTracer.DEFAULT_LANGUAGE);
    verifyDefaultMetricsAttributes(actualMetricDataList, expectedAttributes);

    List<StatusCount> statusCountList = ImmutableList.of(new StatusCount(statusCode, 3));
    verifyStatusAttribute(actualMetricDataList, statusCountList);

    httpClient.close();
    httpClient.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  @Test
  void testGrpc_attemptPermanentFailure_recordsMetrics() throws InterruptedException {
    int attemptCount = 1;
    Code statusCode = Code.INVALID_ARGUMENT;
    BlockRequest blockRequest =
        BlockRequest.newBuilder()
            .setResponseDelay(Duration.newBuilder().setSeconds(2).build())
            .setError(Status.newBuilder().setCode(statusCode.ordinal()).build())
            .build();

    assertThrows(InvalidArgumentException.class, () -> grpcClient.block(blockRequest));

    List<MetricData> actualMetricDataList = getMetricDataList();
    verifyPointDataSum(actualMetricDataList, attemptCount);

    Map<String, String> expectedAttributes =
        ImmutableMap.of(
            MetricsTracer.METHOD_ATTRIBUTE,
            "Echo.Block",
            MetricsTracer.LANGUAGE_ATTRIBUTE,
            MetricsTracer.DEFAULT_LANGUAGE);
    verifyDefaultMetricsAttributes(actualMetricDataList, expectedAttributes);

    List<StatusCount> statusCountList = ImmutableList.of(new StatusCount(statusCode));
    verifyStatusAttribute(actualMetricDataList, statusCountList);
  }

  @Test
  void testHttpJson_attemptPermanentFailure_recordsMetrics() throws InterruptedException {
    int attemptCount = 1;
    Code statusCode = Code.INVALID_ARGUMENT;
    BlockRequest blockRequest =
        BlockRequest.newBuilder()
            .setResponseDelay(Duration.newBuilder().setSeconds(2).build())
            .setError(Status.newBuilder().setCode(statusCode.ordinal()).build())
            .build();

    assertThrows(InvalidArgumentException.class, () -> httpClient.block(blockRequest));

    List<MetricData> actualMetricDataList = getMetricDataList();
    verifyPointDataSum(actualMetricDataList, attemptCount);

    Map<String, String> expectedAttributes =
        ImmutableMap.of(
            MetricsTracer.METHOD_ATTRIBUTE,
            "google.showcase.v1beta1.Echo/Block",
            MetricsTracer.LANGUAGE_ATTRIBUTE,
            MetricsTracer.DEFAULT_LANGUAGE);
    verifyDefaultMetricsAttributes(actualMetricDataList, expectedAttributes);

    List<StatusCount> statusCountList = ImmutableList.of(new StatusCount(statusCode));
    verifyStatusAttribute(actualMetricDataList, statusCountList);
  }

  @Test
  void testGrpc_multipleFailedAttempts_successfulOperation() throws Exception {
    int attemptCount = 3;
    // Disable Jitter on this test to try and ensure that the there are 3 attempts made
    // for test. The first two calls should result in a DEADLINE_EXCEEDED exception as
    // 0.5s and 1s are too short for the 1s blocking call (1s still requires time for
    // the showcase server to respond back to the client). The 3rd and final call (2s)
    // should result in an OK Status Code.
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(org.threeten.bp.Duration.ofMillis(500L))
            .setRpcTimeoutMultiplier(2.0)
            .setMaxRpcTimeout(org.threeten.bp.Duration.ofMillis(2000L))
            .setTotalTimeout(org.threeten.bp.Duration.ofMillis(6000L))
            .setJittered(false)
            .build();

    EchoStubSettings.Builder grpcEchoSettingsBuilder = EchoStubSettings.newBuilder();
    grpcEchoSettingsBuilder
        .blockSettings()
        .setRetrySettings(retrySettings)
        .setRetryableCodes(ImmutableSet.of(Code.DEADLINE_EXCEEDED));
    EchoSettings grpcEchoSettings = EchoSettings.create(grpcEchoSettingsBuilder.build());
    grpcEchoSettings =
        grpcEchoSettings.toBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            .setEndpoint("localhost:7469")
            .build();

    EchoStubSettings echoStubSettings =
        (EchoStubSettings)
            grpcEchoSettings.getStubSettings().toBuilder()
                .setTracerFactory(
                    new MetricsTracerFactory(createOtelMetricsRecorder(inMemoryMetricReader)))
                .build();
    EchoStub stub = echoStubSettings.createStub();

    EchoClient grpcClient = EchoClient.create(stub);

    BlockRequest blockRequest =
        BlockRequest.newBuilder()
            .setResponseDelay(Duration.newBuilder().setSeconds(1))
            .setSuccess(BlockResponse.newBuilder().setContent("grpcBlockResponse"))
            .build();

    grpcClient.block(blockRequest);

    List<MetricData> actualMetricDataList = getMetricDataList();
    verifyPointDataSum(actualMetricDataList, attemptCount);

    Map<String, String> expectedAttributes =
        ImmutableMap.of(
            MetricsTracer.METHOD_ATTRIBUTE,
            "Echo.Block",
            MetricsTracer.LANGUAGE_ATTRIBUTE,
            MetricsTracer.DEFAULT_LANGUAGE);
    verifyDefaultMetricsAttributes(actualMetricDataList, expectedAttributes);

    List<StatusCount> statusCountList =
        ImmutableList.of(new StatusCount(Code.DEADLINE_EXCEEDED, 2), new StatusCount(Code.OK));
    verifyStatusAttribute(actualMetricDataList, statusCountList);

    grpcClient.close();
    grpcClient.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  @Test
  void testHttpJson_multipleFailedAttempts_successfulOperation() throws Exception {
    int attemptCount = 3;
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(org.threeten.bp.Duration.ofMillis(500L))
            .setRpcTimeoutMultiplier(2.0)
            .setMaxRpcTimeout(org.threeten.bp.Duration.ofMillis(2000L))
            .setTotalTimeout(org.threeten.bp.Duration.ofMillis(6000L))
            .setJittered(false)
            .build();

    EchoStubSettings.Builder httpJsonEchoSettingsBuilder = EchoStubSettings.newHttpJsonBuilder();
    httpJsonEchoSettingsBuilder
        .blockSettings()
        .setRetrySettings(retrySettings)
        .setRetryableCodes(ImmutableSet.of(Code.DEADLINE_EXCEEDED));
    EchoSettings httpJsonEchoSettings = EchoSettings.create(httpJsonEchoSettingsBuilder.build());
    httpJsonEchoSettings =
        httpJsonEchoSettings.toBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(
                        new NetHttpTransport.Builder().doNotValidateCertificate().build())
                    .setEndpoint("http://localhost:7469")
                    .build())
            .build();

    EchoStubSettings echoStubSettings =
        (EchoStubSettings)
            httpJsonEchoSettings.getStubSettings().toBuilder()
                .setTracerFactory(
                    new MetricsTracerFactory(createOtelMetricsRecorder(inMemoryMetricReader)))
                .build();
    EchoStub stub = echoStubSettings.createStub();

    EchoClient httpClient = EchoClient.create(stub);

    BlockRequest blockRequest =
        BlockRequest.newBuilder()
            .setResponseDelay(Duration.newBuilder().setSeconds(1))
            .setSuccess(BlockResponse.newBuilder().setContent("httpjsonBlockResponse"))
            .build();

    httpClient.block(blockRequest);

    List<MetricData> actualMetricDataList = getMetricDataList();
    verifyPointDataSum(actualMetricDataList, attemptCount);

    Map<String, String> expectedAttributes =
        ImmutableMap.of(
            MetricsTracer.METHOD_ATTRIBUTE,
            "google.showcase.v1beta1.Echo/Block",
            MetricsTracer.LANGUAGE_ATTRIBUTE,
            MetricsTracer.DEFAULT_LANGUAGE);
    verifyDefaultMetricsAttributes(actualMetricDataList, expectedAttributes);

    httpClient.close();
    httpClient.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  @Test
  void recordsCustomAttributes() throws InterruptedException, IOException {
    InstantiatingGrpcChannelProvider channelProvider =
        EchoSettings.defaultGrpcTransportProviderBuilder()
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setAttemptDirectPathXds()
            .build();

    // Add custom attributes to be added as client level attributes
    Map<String, String> customAttributes = new HashMap<>();
    String directpathEnabled = "directpath_enabled";
    customAttributes.put(directpathEnabled, String.valueOf(channelProvider.canUseDirectPath()));
    String directpathXdsEnabled = "directpathxds_enabled";
    customAttributes.put(
        directpathXdsEnabled, String.valueOf(channelProvider.isDirectPathXdsEnabled()));
    String randomAttributeKey1 = "testing";
    String randomAttributeValue1 = "showcase";
    String randomAttributeKey2 = "hello";
    String randomAttributeValue2 = "world";
    customAttributes.put(randomAttributeKey1, randomAttributeValue1);
    customAttributes.put(randomAttributeKey2, randomAttributeValue2);

    InMemoryMetricReader inMemoryMetricReader = InMemoryMetricReader.create();
    OpenTelemetryMetricsRecorder otelMetricsRecorder =
        createOtelMetricsRecorder(inMemoryMetricReader);
    MetricsTracerFactory metricsTracerFactory =
        new MetricsTracerFactory(otelMetricsRecorder, customAttributes);

    EchoSettings grpcEchoSettings =
        EchoSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(channelProvider)
            .setEndpoint(TestClientInitializer.DEFAULT_GRPC_ENDPOINT)
            .build();

    EchoStubSettings echoStubSettings =
        (EchoStubSettings)
            grpcEchoSettings.getStubSettings().toBuilder()
                .setTracerFactory(metricsTracerFactory)
                .build();
    EchoStub stub = echoStubSettings.createStub();
    EchoClient grpcClient = EchoClient.create(stub);

    EchoRequest echoRequest = EchoRequest.newBuilder().setContent("content").build();
    grpcClient.echo(echoRequest);

    List<MetricData> actualMetricDataList = getMetricDataList(inMemoryMetricReader);
    Map<String, String> expectedAttributes =
        ImmutableMap.of(
            MetricsTracer.METHOD_ATTRIBUTE,
            "Echo.Echo",
            MetricsTracer.LANGUAGE_ATTRIBUTE,
            MetricsTracer.DEFAULT_LANGUAGE,
            directpathEnabled,
            "false",
            directpathXdsEnabled,
            "true",
            randomAttributeKey1,
            randomAttributeValue1,
            randomAttributeKey2,
            randomAttributeValue2);
    verifyDefaultMetricsAttributes(actualMetricDataList, expectedAttributes);
  }

  // This test case uses GrpcOpenTelemetry from grpc-java and includes additional grpc-java specific
  // metrics. This test case ensures that the `setSampledToLocalTracing` set to true will ensure
  // that
  // the gRPC full method name in the stub is recorded (not recorded as `other`).
  @Test
  void grpcOpenTelemetryImplementation_setSampledToLocalTracing_methodFullNameIsRecorded()
      throws Exception {
    SdkMeterProvider sdkMeterProvider =
        SdkMeterProvider.builder().registerMetricReader(inMemoryMetricReader).build();

    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(sdkMeterProvider).build();

    GrpcOpenTelemetry grpcOpenTelemetry = GrpcOpenTelemetry.newBuilder().sdk(openTelemetry).build();

    // Java-Spanner configures the InstantiatingGrpcChannelProvider with gRPCOpenTelemetry
    // This setup below is copied from their implementation
    InstantiatingGrpcChannelProvider.Builder builder =
        EchoSettings.defaultGrpcTransportProviderBuilder();
    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> channelConfigurator =
        builder.getChannelConfigurator();
    builder.setChannelConfigurator(
        b -> {
          b.usePlaintext();
          grpcOpenTelemetry.configureChannelBuilder(b);
          if (channelConfigurator != null) {
            return channelConfigurator.apply(b);
          }
          return b;
        });

    OpenTelemetryMetricsRecorder otelMetricsRecorder =
        new OpenTelemetryMetricsRecorder(openTelemetry, SERVICE_NAME);

    // Create a custom EchoClient that is different from what is created by default in setup()
    EchoClient echoClient =
        TestClientInitializer.createGrpcEchoClientOpentelemetry(
            new MetricsTracerFactory(otelMetricsRecorder), builder.build());

    EchoRequest echoRequest =
        EchoRequest.newBuilder().setContent("test_grpc_request_succeeded").build();
    echoClient.echo(echoRequest);

    List<MetricData> metricDataList = getMetricDataList();

    String gRPCMetricNamePrefix = "grpc.";
    String gRPCMethodNameAttributeKey = "grpc.method";

    List<MetricData> grpcMetricDataList =
        metricDataList.stream()
            .filter(x -> x.getName().startsWith(gRPCMetricNamePrefix))
            .collect(Collectors.toList());
    Truth.assertThat(grpcMetricDataList).isNotEmpty();
    for (MetricData grpcMetricData : grpcMetricDataList) {
      List<PointData> pointDataList = new ArrayList<>(grpcMetricData.getData().getPoints());

      for (PointData pointData : pointDataList) {
        String methodName =
            pointData.getAttributes().get(AttributeKey.stringKey(gRPCMethodNameAttributeKey));

        // All the attributes in the gRPC metrics should have the full method name
        Truth.assertThat(methodName).doesNotMatch("other");
        Truth.assertThat(methodName).matches("^google.showcase.v1beta1.Echo/.*$");
      }
    }

    echoClient.close();
    echoClient.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }
}
