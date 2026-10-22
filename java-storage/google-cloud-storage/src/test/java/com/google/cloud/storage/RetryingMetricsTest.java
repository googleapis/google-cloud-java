/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.storage;

import static com.google.cloud.storage.StorageClientMetrics.KEY_ERROR_TYPE;
import static com.google.cloud.storage.StorageClientMetrics.KEY_GCP_CLIENT_METHOD;
import static com.google.cloud.storage.StorageClientMetrics.KEY_GCP_CLIENT_SERVICE;
import static com.google.cloud.storage.StorageClientMetrics.KEY_GCP_STORAGE_OPERATION;
import static com.google.cloud.storage.StorageClientMetrics.KEY_RPC_METHOD;
import static com.google.cloud.storage.StorageClientMetrics.METRIC_GCP_CLIENT_REQUEST_DURATION;
import static com.google.cloud.storage.StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS;
import static com.google.cloud.storage.StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ERRORS;
import static com.google.cloud.storage.StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_DNS_FAILURE;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_NOT_FOUND;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_OK;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_TIMEOUT;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_UNAVAILABLE;
import static com.google.cloud.storage.StorageErrorTypeMapper.STATUS_UNKNOWN;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.NanoClock;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.Retrying.DefaultRetrier;
import com.google.cloud.storage.Retrying.Retrier;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.Retrying.RetryingDependencies;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Before;
import org.junit.Test;

public final class RetryingMetricsTest {

  private static final RetrySettings RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setMaxAttempts(3)
          .setInitialRetryDelayDuration(Duration.ofMillis(10))
          .setMaxRetryDelayDuration(Duration.ofMillis(50))
          .setRetryDelayMultiplier(1.0)
          .build();

  private InMemoryMetricReader reader;
  private SdkMeterProvider provider;
  private StorageClientMetrics metrics;
  private RetryingDependencies deps;
  private Retrier baseRetrier;
  private RetrierWithAlg alwaysRetrier;
  private RetrierWithAlg neverRetrier;
  @Nullable private Collection<MetricData> collected;

  @Before
  public void setUp() {
    reader = InMemoryMetricReader.create();
    provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    metrics = StorageClientMetrics.create(provider, true, false);
    deps = RetryingDependencies.simple(NanoClock.getDefaultClock(), RETRY_SETTINGS, metrics);
    baseRetrier = new DefaultRetrier(UnaryOperator.identity(), deps);
    alwaysRetrier = baseRetrier.withAlg(Retrying.alwaysRetry());
    neverRetrier = baseRetrier.withAlg(Retrying.neverRetry());
    collected = null;
  }

  @Test
  public void successfulCallOnFirstAttempt_recordsExpectedMetrics() {
    String result =
        alwaysRetrier.run(
            () -> "success", Decoder.identity(), StorageMetricsContext.create("GetObject"));
    assertThat(result).isEqualTo("success");
    assertOutcomeMetrics(STATUS_OK, 1L, 0L);
    assertThat(assertDuration(STATUS_OK).getAttributes().get(KEY_GCP_CLIENT_SERVICE))
        .isEqualTo("storage");
  }

  @Test
  public void retriedCallSuccessOnThirdAttempt_recordsRetriesAndErrors() {
    AtomicInteger attemptCounter = new AtomicInteger(0);
    String result =
        alwaysRetrier.run(
            () -> {
              int count = attemptCounter.incrementAndGet();
              if (count < 3) {
                throw new StorageException(503, "Service Unavailable attempt " + count);
              }
              return "recovered";
            },
            Decoder.identity(),
            StorageMetricsContext.create("GetObject"));

    assertThat(result).isEqualTo("recovered");
    assertThat(attemptCounter.get()).isEqualTo(3);
    assertOutcomeMetrics(STATUS_OK, 3L, 2L);
    assertAttr(METRIC_GCP_STORAGE_CLIENT_ERRORS, KEY_ERROR_TYPE, STATUS_UNAVAILABLE, 2L);
    assertDuration(STATUS_OK);
  }

  @Test
  public void terminalFailureAllAttemptsFail_recordsExhaustedRetries() {
    AtomicInteger attemptCounter = new AtomicInteger(0);
    StorageException se =
        assertThrows(
            StorageException.class,
            () ->
                alwaysRetrier.run(
                    () -> {
                      int count = attemptCounter.incrementAndGet();
                      throw new StorageException(503, "Permanent failure attempt " + count);
                    },
                    Decoder.identity(),
                    StorageMetricsContext.create("GetObject")));

    assertThat(attemptCounter.get()).isEqualTo(3);
    assertThat(se.getCode()).isEqualTo(503);
    assertOutcomeMetrics(STATUS_UNAVAILABLE, 3L, 3L);
    assertAttr(METRIC_GCP_STORAGE_CLIENT_ERRORS, KEY_ERROR_TYPE, STATUS_UNAVAILABLE, 3L);
    assertDuration(STATUS_UNAVAILABLE);
  }

  @Test
  public void metricsDisabled_recordsNoMetrics() {
    StorageClientMetrics disabledMetrics = StorageClientMetrics.create(provider, false, false);
    RetryingDependencies disabledDeps =
        RetryingDependencies.simple(NanoClock.getDefaultClock(), RETRY_SETTINGS, disabledMetrics);
    RetrierWithAlg retrier =
        new DefaultRetrier(UnaryOperator.identity(), disabledDeps).withAlg(Retrying.alwaysRetry());

    assertThat(retrier.run(() -> "no-op metrics", Decoder.identity())).isEqualTo("no-op metrics");
    assertThat(collect()).isEmpty();
  }

  @Test
  public void nullMetrics_executesWithoutRecording() {
    RetryingDependencies nullDeps =
        RetryingDependencies.simple(NanoClock.getDefaultClock(), RETRY_SETTINGS, null);
    RetrierWithAlg retrier =
        new DefaultRetrier(UnaryOperator.identity(), nullDeps).withAlg(Retrying.alwaysRetry());

    assertThat(retrier.run(() -> "null-metrics", Decoder.identity())).isEqualTo("null-metrics");
  }

  @Test
  public void callingRunWithoutMetricsContext_whenMetricsEnabled_recordsNoMetrics() {
    assertThat(alwaysRetrier.run(() -> "no-context", Decoder.identity())).isEqualTo("no-context");
    assertThat(collect()).isEmpty();
  }

  @Test
  public void httpStorageOptions_createRetrier_wiresMetricsWhenEnabled() {
    HttpStorageOptions options =
        HttpStorageOptions.newBuilder()
            .setMeterProvider(provider)
            .setEnableOtelMetrics(true)
            .build();

    assertThat(options.getStorageClientMetrics()).isNotNull();
    Retrier retrier = options.createRetrier();
    assertThat(retrier).isNotNull();

    StorageMetricsContext ctx = options.createMetricsContext("GetObject");
    assertThat(retrier.run(Retrying.neverRetry(), () -> "options-success", Decoder.identity(), ctx))
        .isEqualTo("options-success");
    assertAttr(METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_ERROR_TYPE, STATUS_OK, 1L);
  }

  @Test
  public void httpStorageOptions_createRetrier_noMetricsWhenDisabled() {
    HttpStorageOptions options =
        HttpStorageOptions.newBuilder()
            .setMeterProvider(provider)
            .setEnableOtelMetrics(false)
            .build();

    assertThat(options.getStorageClientMetrics()).isNull();
    Retrier retrier = options.createRetrier();
    assertThat(retrier.run(Retrying.neverRetry(), () -> "options-disabled", Decoder.identity()))
        .isEqualTo("options-disabled");
    assertThat(collect()).isEmpty();
  }

  @Test
  public void grpcStorageOptions_createRetrier_wiresMetricsWhenEnabled() {
    GrpcStorageOptions options =
        GrpcStorageOptions.newBuilder()
            .setMeterProvider(provider)
            .setEnableOtelMetrics(true)
            .build();

    assertThat(options.getStorageClientMetrics()).isNotNull();
    Retrier retrier = options.createRetrier();
    assertThat(retrier).isNotNull();

    StorageMetricsContext ctx = options.createMetricsContext("GetObject");
    String res =
        retrier.run(Retrying.neverRetry(), () -> "grpc-options-success", Decoder.identity(), ctx);
    assertThat(res).isEqualTo("grpc-options-success");
    assertAttr(METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_ERROR_TYPE, STATUS_OK, 1L);
  }

  @Test
  public void grpcStorageOptions_createRetrier_noMetricsWhenDisabled() {
    GrpcStorageOptions options =
        GrpcStorageOptions.newBuilder()
            .setMeterProvider(provider)
            .setEnableOtelMetrics(false)
            .build();

    assertThat(options.getStorageClientMetrics()).isNull();
    Retrier retrier = options.createRetrier();
    String res =
        retrier.run(Retrying.neverRetry(), () -> "grpc-options-disabled", Decoder.identity());
    assertThat(res).isEqualTo("grpc-options-disabled");
    assertThat(collect()).isEmpty();
  }

  @Test
  public void nonRetryableError_singleAttemptTerminalFailure_recordsErrorAndTerminalOperation() {
    StorageException se =
        assertThrows(
            StorageException.class,
            () ->
                neverRetrier.run(
                    () -> {
                      throw new StorageException(404, "Not Found");
                    },
                    Decoder.identity(),
                    StorageMetricsContext.create("GetObject")));

    assertThat(se.getCode()).isEqualTo(404);
    assertOutcomeMetrics(STATUS_NOT_FOUND, 1L, 1L);
    assertAttr(METRIC_GCP_STORAGE_CLIENT_ERRORS, KEY_ERROR_TYPE, STATUS_NOT_FOUND, 1L);
    assertDuration(STATUS_NOT_FOUND);
  }

  @Test
  public void recordAttemptError_specificExceptions_mappedToCanonicalTypes() {
    AtomicInteger attemptCounter = new AtomicInteger(0);
    StorageException se =
        assertThrows(
            StorageException.class,
            () ->
                alwaysRetrier.run(
                    () -> {
                      int count = attemptCounter.incrementAndGet();
                      if (count == 1) {
                        throw new StatusRuntimeException(Status.DEADLINE_EXCEEDED);
                      } else if (count == 2) {
                        throw new SocketTimeoutException("Read timed out");
                      } else {
                        throw new UnknownHostException("storage.googleapis.com");
                      }
                    },
                    Decoder.identity(),
                    StorageMetricsContext.create("GetObject")));

    assertThat(attemptCounter.get()).isEqualTo(3);
    assertThat(se).isNotNull();
    assertOutcomeMetrics(STATUS_DNS_FAILURE, 3L, 3L);
    assertAttr(METRIC_GCP_STORAGE_CLIENT_ERRORS, KEY_ERROR_TYPE, STATUS_TIMEOUT, 2L);
    assertAttr(METRIC_GCP_STORAGE_CLIENT_ERRORS, KEY_ERROR_TYPE, STATUS_DNS_FAILURE, 1L);
  }

  @Test
  public void illegalArgumentException_parsingFailure_recordedAndRethrown() {
    StorageException se =
        assertThrows(
            StorageException.class,
            () ->
                neverRetrier.run(
                    () -> {
                      throw new IllegalArgumentException("malformed json response");
                    },
                    Decoder.identity(),
                    StorageMetricsContext.create("GetObject")));

    assertThat(se.getCause()).isInstanceOf(IllegalArgumentException.class);
    assertThat(se.getCause()).hasMessageThat().contains("malformed json response");
    assertOutcomeMetrics(STATUS_UNKNOWN, 1L, 1L);
    assertAttr(METRIC_GCP_STORAGE_CLIENT_ERRORS, KEY_ERROR_TYPE, STATUS_UNKNOWN, 1L);
  }

  @Test
  public void run_withCustomMetricsContext_recordsSpecificOperationAttribute() {
    StorageMetricsContext customContext = StorageMetricsContext.create("GetObject");
    String result =
        baseRetrier.run(
            Retrying.neverRetry(), () -> "custom-op-result", Decoder.identity(), customContext);
    assertThat(result).isEqualTo("custom-op-result");

    assertAttr(METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_GCP_STORAGE_OPERATION, "GetObject", 1L);
    assertAttr(METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_GCP_CLIENT_METHOD, "GetObject", 1L);
    assertAttr(METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_RPC_METHOD, "GetObject", 0L);

    HistogramPointData durationPoint = assertDuration(STATUS_OK);
    assertThat(durationPoint.getAttributes().get(KEY_GCP_STORAGE_OPERATION)).isEqualTo("GetObject");
    assertThat(durationPoint.getAttributes().get(KEY_GCP_CLIENT_METHOD)).isEqualTo("GetObject");
    assertThat(durationPoint.getAttributes().get(KEY_RPC_METHOD))
        .isEqualTo("google.storage.v2.Storage/GetObject");

    assertAttr(METRIC_GCP_STORAGE_CLIENT_ATTEMPTS, KEY_GCP_STORAGE_OPERATION, "GetObject", 1L);
    assertAttr(METRIC_GCP_STORAGE_CLIENT_ATTEMPTS, KEY_RPC_METHOD, "GetObject", 0L);
  }

  @Test
  public void withAlg_withCustomMetricsContext_propagatesContext() {
    StorageMetricsContext customContext = StorageMetricsContext.create("GetObject");
    String result = neverRetrier.run(() -> "custom-op-result", Decoder.identity(), customContext);
    assertThat(result).isEqualTo("custom-op-result");

    assertAttr(METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_GCP_STORAGE_OPERATION, "GetObject", 1L);
    assertAttr(METRIC_GCP_STORAGE_CLIENT_ATTEMPTS, KEY_GCP_STORAGE_OPERATION, "GetObject", 1L);
  }

  @Test
  public void newCallContext_attachesMetricsContext() {
    StorageMetricsContext customContext = StorageMetricsContext.create("GetObject");
    GrpcCallContext callContext = Retrying.newCallContext(customContext);
    assertThat(StorageMetricsContext.from(callContext)).isSameInstanceAs(customContext);
    assertThat(StorageMetricsContext.from(Retrying.newCallContext(null))).isNull();
  }

  @Test
  public void run_withCustomMetricsContext_recordsOperationOnRetriesAndErrors() {
    StorageMetricsContext customContext = StorageMetricsContext.create("GetObject");
    AtomicInteger attempts = new AtomicInteger(0);
    String result =
        baseRetrier.run(
            Retrying.alwaysRetry(),
            () -> {
              if (attempts.incrementAndGet() < 2) {
                throw new StorageException(503, "Unavailable");
              }
              return "recovered";
            },
            Decoder.identity(),
            customContext);
    assertThat(result).isEqualTo("recovered");

    assertAttr(METRIC_GCP_STORAGE_CLIENT_ATTEMPTS, KEY_GCP_STORAGE_OPERATION, "GetObject", 2L);
    assertAttr(METRIC_GCP_STORAGE_CLIENT_ATTEMPTS, KEY_RPC_METHOD, "GetObject", 0L);
    assertAttr(METRIC_GCP_STORAGE_CLIENT_ERRORS, KEY_GCP_STORAGE_OPERATION, "GetObject", 1L);
    assertAttr(METRIC_GCP_STORAGE_CLIENT_ERRORS, KEY_RPC_METHOD, "GetObject", 0L);
  }

  @Test
  public void run_withCustomMetricsContext_propagatesOtelContextScope() {
    StorageMetricsContext customContext = StorageMetricsContext.create("GetObject");
    Context[] observedContext = new Context[1];

    baseRetrier.run(
        Retrying.neverRetry(),
        () -> {
          observedContext[0] = Context.current();
          return "ok";
        },
        Decoder.identity(),
        customContext);

    assertThat(observedContext[0]).isEqualTo(customContext.getOtelContext());
  }

  private Collection<MetricData> collect() {
    if (collected == null) {
      collected = reader.collectAllMetrics();
    }
    return collected;
  }

  private void assertOutcomeMetrics(
      String terminalStatus, long expectedAttempts, long expectedErrors) {
    assertAttr(METRIC_GCP_STORAGE_CLIENT_OPERATIONS, KEY_ERROR_TYPE, terminalStatus, 1L);
    assertThat(getCounterValue(collect(), METRIC_GCP_STORAGE_CLIENT_ATTEMPTS))
        .isEqualTo(expectedAttempts);
    assertThat(getCounterValue(collect(), METRIC_GCP_STORAGE_CLIENT_ERRORS))
        .isEqualTo(expectedErrors);
  }

  private void assertAttr(
      String metricName, AttributeKey<String> key, String expectedValue, long expectedCount) {
    assertThat(getCounterValueWithAttribute(collect(), metricName, key, expectedValue))
        .isEqualTo(expectedCount);
  }

  private HistogramPointData assertDuration(String expectedTerminalStatus) {
    HistogramPointData point = getHistogramPoint(collect(), METRIC_GCP_CLIENT_REQUEST_DURATION);
    assertThat(point).isNotNull();
    assertThat(point.getCount()).isEqualTo(1L);
    assertThat(point.getAttributes().get(KEY_ERROR_TYPE)).isEqualTo(expectedTerminalStatus);
    return point;
  }

  private static @Nullable MetricData findMetric(
      Collection<MetricData> metrics, String metricName) {
    for (MetricData md : metrics) {
      if (md.getName().equals(metricName) || md.getName().equals(metricName.replace(".", "/"))) {
        return md;
      }
    }
    return null;
  }

  private static long getCounterValue(Collection<MetricData> metrics, String metricName) {
    MetricData md = findMetric(metrics, metricName);
    return md == null
        ? 0L
        : md.getLongSumData().getPoints().stream().mapToLong(LongPointData::getValue).sum();
  }

  private static long getCounterValueWithAttribute(
      Collection<MetricData> metrics,
      String metricName,
      AttributeKey<String> key,
      String expectedValue) {
    MetricData md = findMetric(metrics, metricName);
    if (md == null) {
      return 0L;
    }
    return md.getLongSumData().getPoints().stream()
        .filter(p -> expectedValue.equals(p.getAttributes().get(key)))
        .mapToLong(LongPointData::getValue)
        .sum();
  }

  private static @Nullable HistogramPointData getHistogramPoint(
      Collection<MetricData> metrics, String metricName) {
    MetricData md = findMetric(metrics, metricName);
    if (md == null || !md.getHistogramData().getPoints().iterator().hasNext()) {
      return null;
    }
    return md.getHistogramData().getPoints().iterator().next();
  }
}
