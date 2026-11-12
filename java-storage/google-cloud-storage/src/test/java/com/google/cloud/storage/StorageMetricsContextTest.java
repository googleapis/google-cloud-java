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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import com.google.api.core.ApiClock;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import io.grpc.CallOptions;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import org.jspecify.annotations.Nullable;
import org.junit.Before;
import org.junit.Test;

public final class StorageMetricsContextTest {

  private InMemoryMetricReader reader;
  private SdkMeterProvider provider;
  private StorageClientMetrics metrics;

  @Before
  public void setUp() {
    resetMetrics();
  }

  private void resetMetrics() {
    reader = InMemoryMetricReader.create();
    provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    metrics = StorageClientMetrics.create(provider, true, false);
  }

  @Test
  public void create_initializesDefaultState() {
    StorageMetricsContext context = StorageMetricsContext.create("GetObject");

    assertThat(context.getMetrics()).isNull();
    assertThat(context.getOperationName()).isEqualTo("GetObject");
    assertThat(context.getStartTimeNanos()).isGreaterThan(0L);
    assertThat(context.getElapsedSeconds()).isAtLeast(0.0);
    assertThat(context.getAttemptCount()).isEqualTo(0);
    assertThat(context.getRequestBytes()).isEqualTo(0L);
    assertThat(context.getResponseBytes()).isEqualTo(0L);
    assertThat(context.getBaseAttributes()).isEqualTo(Attributes.empty());
    assertThat(context.getOtelContext()).isSameInstanceAs(Context.current());
  }

  @Test
  public void create_withOtelContext() {
    Context customContext = Context.root();
    StorageMetricsContext context =
        StorageMetricsContext.create("GetObject", Attributes.empty(), customContext);
    assertThat(context.getOtelContext()).isSameInstanceAs(customContext);
  }

  @Test
  public void create_withApiClock_usesClockForStartAndElapsedTime() {
    AtomicLong fakeNanos = new AtomicLong(1_000_000_000L);
    ApiClock fakeClock =
        new ApiClock() {
          @Override
          public long nanoTime() {
            return fakeNanos.get();
          }

          @Override
          public long millisTime() {
            return fakeNanos.get() / 1_000_000L;
          }
        };

    StorageMetricsContext context =
        StorageMetricsContext.create(metrics, "GetObject", Attributes.empty(), fakeClock);
    assertThat(context.getMetrics()).isSameInstanceAs(metrics);
    assertThat(context.getStartTimeNanos()).isEqualTo(1_000_000_000L);

    fakeNanos.set(3_500_000_000L);
    assertThat(context.getElapsedSeconds()).isEqualTo(2.5);
  }

  @Test
  public void create_validatesNonNullArguments() {
    assertThrows(NullPointerException.class, () -> StorageMetricsContext.create(null));
    assertThrows(
        NullPointerException.class, () -> StorageMetricsContext.create(null, Attributes.empty()));
    assertThrows(NullPointerException.class, () -> StorageMetricsContext.create("op", null));
    assertThrows(
        NullPointerException.class,
        () -> StorageMetricsContext.create("op", Attributes.empty(), null));
    assertThrows(
        NullPointerException.class,
        () -> StorageMetricsContext.create("op", Attributes.empty(), Context.current(), null));
    assertThrows(
        NullPointerException.class,
        () -> StorageMetricsContext.create(metrics, "op", Attributes.empty(), null));
    assertThrows(NullPointerException.class, () -> StorageMetricsContext.createForMultiStep(null));
    assertThrows(
        NullPointerException.class,
        () -> StorageMetricsContext.createForMultiStep(null, Attributes.empty()));
    assertThrows(
        NullPointerException.class, () -> StorageMetricsContext.createForMultiStep("op", null));
    assertThrows(
        NullPointerException.class,
        () -> StorageMetricsContext.createForMultiStep("op", Attributes.empty(), null));
    assertThrows(
        NullPointerException.class,
        () ->
            StorageMetricsContext.createForMultiStep(
                "op", Attributes.empty(), Context.current(), null));
    assertThrows(
        NullPointerException.class,
        () -> StorageMetricsContext.createForMultiStep(metrics, "op", Attributes.empty(), null));
  }

  @Test
  public void create_withBaseAttributes() {
    Attributes attrs =
        Attributes.of(
            AttributeKey.stringKey("gcp.client.service"),
            "storage",
            AttributeKey.stringKey("gcp.client.version"),
            "2.74.0");
    StorageMetricsContext context = StorageMetricsContext.create("WriteObject", attrs);

    assertThat(context.getOperationName()).isEqualTo("WriteObject");
    assertThat(context.getBaseAttributes()).isEqualTo(attrs);
  }

  @Test
  public void stateMutations_accumulateValues() {
    StorageMetricsContext context = StorageMetricsContext.create("WriteObject");

    assertThat(context.incrementAttempts()).isEqualTo(1);
    assertThat(context.incrementAttempts()).isEqualTo(2);
    assertThat(context.getAttemptCount()).isEqualTo(2);

    assertThat(context.addRequestBytes(1024L)).isEqualTo(1024L);
    assertThat(context.addRequestBytes(2048L)).isEqualTo(3072L);
    assertThat(context.getRequestBytes()).isEqualTo(3072L);

    assertThat(context.addResponseBytes(512L)).isEqualTo(512L);
    assertThat(context.addResponseBytes(512L)).isEqualTo(1024L);
    assertThat(context.getResponseBytes()).isEqualTo(1024L);
  }

  @Test
  public void elapsedSeconds_computesCorrectly() {
    long startTime = 1_000_000_000L;
    StorageMetricsContext context =
        StorageMetricsContext.create("GetObject", Attributes.empty(), startTime);

    long endTime = 2_500_000_000L;
    double elapsed = context.getElapsedSeconds(endTime);
    assertThat(elapsed).isEqualTo(1.5);
    assertThat(context.getElapsedSeconds()).isAtLeast(0.0);
  }

  @Test
  public void transportAttachment_grpcCallOptions() {
    StorageMetricsContext context = StorageMetricsContext.create("GetObject");
    CallOptions options = CallOptions.DEFAULT;

    CallOptions attachedOptions = context.attach(options);
    assertThat(attachedOptions).isNotNull();

    StorageMetricsContext extracted = StorageMetricsContext.from(attachedOptions);
    assertThat(extracted).isSameInstanceAs(context);

    assertThat(StorageMetricsContext.from((CallOptions) null)).isNull();
    assertThat(StorageMetricsContext.from(CallOptions.DEFAULT)).isNull();
  }

  @Test
  public void transportAttachment_grpcCallContext() {
    StorageMetricsContext context = StorageMetricsContext.create("GetObject");
    GrpcCallContext callContext = GrpcCallContext.createDefault();

    GrpcCallContext attachedContext = context.attach(callContext);
    assertThat(attachedContext).isNotNull();
    assertThat(
            attachedContext.getCallOptions().getOption(StorageMetricsContext.GRPC_CALL_OPTIONS_KEY))
        .isSameInstanceAs(context);

    StorageMetricsContext extracted = StorageMetricsContext.from(attachedContext);
    assertThat(extracted).isSameInstanceAs(context);

    assertThat(StorageMetricsContext.from((GrpcCallContext) null)).isNull();
    assertThat(StorageMetricsContext.from(GrpcCallContext.createDefault())).isNull();
  }

  @Test
  public void multiStepContext_behavior() {
    StorageMetricsContext context1 = StorageMetricsContext.createForMultiStep("WriteObject");
    assertThat(context1.shouldRecordOperationOnRetrierExit()).isFalse();
    assertThat(context1.getOperationName()).isEqualTo("WriteObject");
    assertThat(context1.getBaseAttributes()).isEqualTo(Attributes.empty());
    assertThat(context1.getOtelContext()).isSameInstanceAs(Context.current());

    Attributes customAttrs = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc");
    StorageMetricsContext context2 =
        StorageMetricsContext.createForMultiStep("ReadObject", customAttrs);
    assertThat(context2.shouldRecordOperationOnRetrierExit()).isFalse();
    assertThat(context2.getOperationName()).isEqualTo("ReadObject");
    assertThat(context2.getBaseAttributes()).isEqualTo(customAttrs);

    Context customContext = Context.root();
    StorageMetricsContext context3 =
        StorageMetricsContext.createForMultiStep("DeleteObject", customAttrs, customContext);
    assertThat(context3.shouldRecordOperationOnRetrierExit()).isFalse();
    assertThat(context3.getOperationName()).isEqualTo("DeleteObject");
    assertThat(context3.getBaseAttributes()).isEqualTo(customAttrs);
    assertThat(context3.getOtelContext()).isSameInstanceAs(customContext);

    StorageMetricsContext context4 =
        StorageMetricsContext.createForMultiStep(metrics, "WriteObject", customAttrs);
    assertThat(context4.shouldRecordOperationOnRetrierExit()).isFalse();
    assertThat(context4.getMetrics()).isSameInstanceAs(metrics);
  }

  @Test
  public void recordWithBoundMetrics_recordsWithoutPassingMetricsParameter() {
    Attributes base =
        metrics.attachClientAttributes(
            Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc"));
    StorageMetricsContext context = StorageMetricsContext.create(metrics, "GetObject", base);

    context.recordAttemptFailure(Status.UNAVAILABLE.asRuntimeException());
    context.recordAttemptSuccess();
    context.recordOperation(null);

    Collection<MetricData> collected = reader.collectAllMetrics();
    MetricData attemptsMetric =
        findMetric(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptsMetric).isNotNull();
    assertThat(attemptsMetric.getLongSumData().getPoints()).hasSize(2);

    LongPointData errorPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ERRORS);
    assertThat(errorPoint.getValue()).isEqualTo(1L);
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_CLIENT_INSTANCE_ID))
        .isEqualTo(
            metrics.getClientAttributes().get(StorageClientMetrics.KEY_GCP_CLIENT_INSTANCE_ID));

    LongPointData opPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS);
    assertThat(opPoint.getValue()).isEqualTo(1L);
    assertThat(opPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_CLIENT_SERVICE))
        .isEqualTo(StorageClientMetrics.SERVICE_STORAGE);
  }

  @Test
  public void recordOperation_isIdempotent() {
    StorageMetricsContext context = StorageMetricsContext.createForMultiStep("WriteObject");
    context.recordOperation(metrics, null);
    context.recordOperation(metrics, null);

    Collection<MetricData> collected = reader.collectAllMetrics();
    long opCount =
        collected.stream()
            .filter(
                m -> m.getName().equals(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS))
            .flatMap(m -> m.getLongSumData().getPoints().stream())
            .mapToLong(LongPointData::getValue)
            .sum();
    assertThat(opCount).isEqualTo(1L);
  }

  @Test
  public void recordAttemptSuccess_nullMetrics_noOp() {
    StorageMetricsContext context = StorageMetricsContext.create("GetObject");
    context.recordAttemptSuccess(null);
    context.recordAttemptSuccess();
    assertThat(reader.collectAllMetrics()).isEmpty();
  }

  @Test
  public void recordAttemptSuccess_whenAttemptsNull_noOp() {
    StorageClientMetrics disabledMetrics = StorageClientMetrics.create(provider, false, false);
    StorageMetricsContext context = StorageMetricsContext.create("GetObject");
    context.recordAttemptSuccess(disabledMetrics);
    assertThat(reader.collectAllMetrics()).isEmpty();
  }

  @Test
  public void recordAttemptSuccess_defaultAttributes() {
    StorageMetricsContext context = StorageMetricsContext.create("GetObject");
    context.recordAttemptSuccess(metrics);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData point =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(point.getValue()).isEqualTo(1L);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_OK);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_CLOUDPATH);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION))
        .isEqualTo("GetObject");
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("");
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(0L);
    // Errors counter must not be recorded on success
    assertThat(findMetric(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ERRORS))
        .isNull();
  }

  @Test
  public void recordAttemptSuccess_grpcSystemName_setsRpcStatusCodeOk() {
    Attributes base =
        Attributes.of(
            StorageClientMetrics.KEY_RPC_SYSTEM_NAME,
            "grpc",
            StorageClientMetrics.KEY_NETWORK_PATH,
            StorageClientMetrics.NETWORK_PATH_DIRECTPATH);
    StorageMetricsContext context = StorageMetricsContext.create("GetObject", base);
    context.recordAttemptSuccess(metrics);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData point =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("OK");
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(0L);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_DIRECTPATH);
  }

  @Test
  public void recordAttemptSuccess_httpSystemName_setsHttpStatusCode200() {
    Attributes base = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http");
    StorageMetricsContext context = StorageMetricsContext.create("GetObject", base);
    context.recordAttemptSuccess(metrics);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData point =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(200L);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("");
  }

  @Test
  public void recordAttemptSuccess_overridesFromBaseAttributes() {
    Attributes base =
        Attributes.builder()
            .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc")
            .put(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, "ALREADY_EXISTS")
            .put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, 204L)
            .put(
                StorageClientMetrics.KEY_NETWORK_PATH, StorageClientMetrics.NETWORK_PATH_DIRECTPATH)
            .build();
    StorageMetricsContext context = StorageMetricsContext.create("GetObject", base);
    context.recordAttemptSuccess(metrics);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData point =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("ALREADY_EXISTS");
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(0L);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_DIRECTPATH);

    resetMetrics();
    Attributes httpBase =
        Attributes.builder()
            .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http")
            .put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, 204L)
            .build();
    StorageMetricsContext httpContext = StorageMetricsContext.create("GetObject", httpBase);
    httpContext.recordAttemptSuccess(metrics);

    collected = reader.collectAllMetrics();
    LongPointData httpPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(httpPoint.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(204L);
    assertThat(httpPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("");
  }

  @Test
  public void recordAttemptFailure_nullMetrics_noOp() {
    StorageMetricsContext context = StorageMetricsContext.create("GetObject");
    context.recordAttemptFailure(null, new RuntimeException("boom"));
    context.recordAttemptFailure(new RuntimeException("boom"));
    assertThat(reader.collectAllMetrics()).isEmpty();
  }

  @Test
  public void recordAttemptFailure_whenInstrumentsNull_noOp() {
    StorageClientMetrics disabledMetrics = StorageClientMetrics.create(provider, false, false);
    StorageMetricsContext context = StorageMetricsContext.create("GetObject");
    context.recordAttemptFailure(disabledMetrics, new RuntimeException("err"));
    assertThat(reader.collectAllMetrics()).isEmpty();
  }

  @Test
  public void recordAttemptFailure_storageException() {
    Attributes base = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http");
    StorageMetricsContext context = StorageMetricsContext.create("GetObject", base);
    StorageException se = new StorageException(404, "Not Found");
    context.recordAttemptFailure(metrics, se);

    Collection<MetricData> collected = reader.collectAllMetrics();

    // Verify attempts counter
    LongPointData attemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptPoint.getValue()).isEqualTo(1L);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo("NOT_FOUND");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(404L);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_CLOUDPATH);

    // Verify errors counter
    LongPointData errorPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ERRORS);
    assertThat(errorPoint.getValue()).isEqualTo(1L);
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo("NOT_FOUND");
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_CLOUDPATH);
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION))
        .isEqualTo("GetObject");
  }

  @Test
  public void recordAttemptFailure_statusRuntimeException() {
    Attributes base = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc");
    StorageMetricsContext context = StorageMetricsContext.create("GetObject", base);
    StatusRuntimeException sre = Status.NOT_FOUND.asRuntimeException();
    context.recordAttemptFailure(metrics, sre);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData attemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo("NOT_FOUND");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("NOT_FOUND");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(0L);

    LongPointData errorPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ERRORS);
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo("NOT_FOUND");
  }

  @Test
  public void recordAttemptFailure_statusException() {
    Attributes base = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc");
    StorageMetricsContext context = StorageMetricsContext.create("GetObject", base);
    StatusException se = Status.PERMISSION_DENIED.asException();
    context.recordAttemptFailure(metrics, se);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData attemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo("PERMISSION_DENIED");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("PERMISSION_DENIED");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(0L);
  }

  @Test
  public void recordAttemptFailure_apiException() {
    Attributes base = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc");
    StorageMetricsContext context = StorageMetricsContext.create("GetObject", base);
    ApiException apiException =
        new ApiException(
            new StatusRuntimeException(Status.ALREADY_EXISTS),
            GrpcStatusCode.of(Status.Code.ALREADY_EXISTS),
            false);
    context.recordAttemptFailure(metrics, apiException);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData attemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo("ALREADY_EXISTS");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("ALREADY_EXISTS");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(0L);
  }

  @Test
  public void recordAttemptFailure_httpResponseException() {
    Attributes base = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http");
    StorageMetricsContext context = StorageMetricsContext.create("GetObject", base);
    HttpResponseException hre =
        new HttpResponseException.Builder(429, "Too Many Requests", new HttpHeaders()).build();
    context.recordAttemptFailure(metrics, hre);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData attemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo("RESOURCE_EXHAUSTED");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(429L);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("");
  }

  @Test
  public void recordAttemptFailure_nestedCause() {
    Attributes grpcBase = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc");
    StorageMetricsContext grpcContext = StorageMetricsContext.create("GetObject", grpcBase);
    Exception wrappedGrpc =
        new RuntimeException(new IllegalStateException(Status.UNAVAILABLE.asRuntimeException()));
    grpcContext.recordAttemptFailure(metrics, wrappedGrpc);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData attemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("UNAVAILABLE");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(0L);

    resetMetrics();
    Attributes httpBase = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http");
    StorageMetricsContext httpContext = StorageMetricsContext.create("GetObject", httpBase);
    Exception wrappedHttp = new RuntimeException(new StorageException(503, "Service Unavailable"));
    httpContext.recordAttemptFailure(metrics, wrappedHttp);
    collected = reader.collectAllMetrics();
    attemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(503L);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("");
  }

  @Test
  public void recordAttemptFailure_selfCausingException_doesNotInfiniteLoop() {
    Exception selfCausing =
        new Exception("self") {
          @Override
          public synchronized Throwable getCause() {
            return this;
          }
        };
    Attributes grpcBase = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc");
    StorageMetricsContext grpcContext = StorageMetricsContext.create("GetObject", grpcBase);
    grpcContext.recordAttemptFailure(metrics, selfCausing);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData grpcPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(grpcPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_UNKNOWN);

    resetMetrics();
    Attributes httpBase = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http");
    StorageMetricsContext httpContext = StorageMetricsContext.create("GetObject", httpBase);
    httpContext.recordAttemptFailure(metrics, selfCausing);

    collected = reader.collectAllMetrics();
    LongPointData httpPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(httpPoint.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(0L);
  }

  @Test
  public void recordOperation_formatsRpcMethodAndAttributes() {
    StorageMetricsContext context = StorageMetricsContext.create("GetObject");
    context.recordOperation(metrics, null);

    Collection<MetricData> collected = reader.collectAllMetrics();
    MetricData durationMetric =
        findMetric(collected, StorageClientMetrics.METRIC_GCP_CLIENT_REQUEST_DURATION);
    assertThat(durationMetric).isNotNull();
    assertThat(durationMetric.getHistogramData().getPoints()).hasSize(1);
    HistogramPointData durationPoint =
        durationMetric.getHistogramData().getPoints().iterator().next();
    assertThat(durationPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_METHOD))
        .isEqualTo("google.storage.v2.Storage/GetObject");
    assertThat(durationPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION))
        .isEqualTo("GetObject");
    assertThat(durationPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_OK);
  }

  @Test
  public void recordAttemptFailure_overridesFromBaseAttributes() {
    Attributes base =
        Attributes.builder()
            .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc")
            .put(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, "OVERRIDDEN_RPC")
            .put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, 999L)
            .put(
                StorageClientMetrics.KEY_NETWORK_PATH, StorageClientMetrics.NETWORK_PATH_DIRECTPATH)
            .build();
    StorageMetricsContext context = StorageMetricsContext.create("GetObject", base);
    context.recordAttemptFailure(metrics, new StorageException(404, "Not Found"));

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData attemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("OVERRIDDEN_RPC");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(0L);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_DIRECTPATH);

    LongPointData errorPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ERRORS);
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_DIRECTPATH);

    resetMetrics();
    Attributes httpBase =
        Attributes.builder()
            .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http")
            .put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, 999L)
            .build();
    StorageMetricsContext httpContext = StorageMetricsContext.create("GetObject", httpBase);
    httpContext.recordAttemptFailure(metrics, new StorageException(404, "Not Found"));

    collected = reader.collectAllMetrics();
    LongPointData httpAttemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(
            httpAttemptPoint
                .getAttributes()
                .get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(999L);
    assertThat(
            httpAttemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("");
  }

  @Test
  public void gcpClientMethod_excludedFromAttemptAndErrorMetrics_includedInOperationMetrics() {
    Attributes base =
        Attributes.of(
            StorageClientMetrics.KEY_RPC_SYSTEM_NAME,
            "grpc",
            StorageClientMetrics.KEY_GCP_CLIENT_METHOD,
            "Storage.get");
    StorageMetricsContext context = StorageMetricsContext.create("GetObject", base);
    context.recordAttemptFailure(metrics, Status.UNAVAILABLE.asRuntimeException());
    context.recordAttemptSuccess(metrics);
    context.recordOperation(metrics, null);

    Collection<MetricData> collected = reader.collectAllMetrics();

    MetricData attemptsMetric =
        findMetric(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptsMetric).isNotNull();
    for (LongPointData point : attemptsMetric.getLongSumData().getPoints()) {
      assertThat(point.getAttributes().get(StorageClientMetrics.KEY_GCP_CLIENT_METHOD)).isNull();
    }

    LongPointData errorPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ERRORS);
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_CLIENT_METHOD)).isNull();

    LongPointData opPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS);
    assertThat(opPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_CLIENT_METHOD))
        .isEqualTo("Storage.get");

    MetricData durationMetric =
        findMetric(collected, StorageClientMetrics.METRIC_GCP_CLIENT_REQUEST_DURATION);
    assertThat(durationMetric).isNotNull();
    HistogramPointData durationPoint =
        durationMetric.getHistogramData().getPoints().iterator().next();
    assertThat(durationPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_CLIENT_METHOD))
        .isEqualTo("Storage.get");
  }

  @Test
  public void recordAttemptFailure_withoutStatusCode_usesTransportDefaultFallbacks() {
    Attributes grpcBase = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc");
    StorageMetricsContext grpcContext = StorageMetricsContext.create("GetObject", grpcBase);
    grpcContext.recordAttemptFailure(metrics, new RuntimeException("connection reset"));

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData grpcAttemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(
            grpcAttemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_UNKNOWN);
    assertThat(
            grpcAttemptPoint
                .getAttributes()
                .get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(0L);

    resetMetrics();
    Attributes httpBase = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http");
    StorageMetricsContext httpContext = StorageMetricsContext.create("GetObject", httpBase);
    httpContext.recordAttemptFailure(metrics, new RuntimeException("connection reset"));

    collected = reader.collectAllMetrics();
    LongPointData httpAttemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(
            httpAttemptPoint
                .getAttributes()
                .get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(0L);
    assertThat(
            httpAttemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("");
  }

  @Test
  public void recordAttemptFailure_apiExceptionWithNullStatusCode_fallsBackToUnknown() {
    Attributes grpcBase = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc");
    StorageMetricsContext grpcContext = StorageMetricsContext.create("GetObject", grpcBase);
    StatusCode nullCodeStatus =
        new StatusCode() {
          @Override
          public @Nullable Code getCode() {
            return null;
          }

          @Override
          public @Nullable Object getTransportCode() {
            return null;
          }
        };
    ApiException nullStatusApiEx = new ApiException("null code", null, nullCodeStatus, false);
    grpcContext.recordAttemptFailure(metrics, nullStatusApiEx);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData attemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_UNKNOWN);
  }

  @Test
  public void recordAttemptFailure_topLevelSelfCausingException_extractsStatusCode() {
    StatusRuntimeException selfCausingGrpc =
        new StatusRuntimeException(Status.UNAVAILABLE) {
          @Override
          public synchronized Throwable getCause() {
            return this;
          }
        };
    Attributes grpcBase = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc");
    StorageMetricsContext grpcContext = StorageMetricsContext.create("GetObject", grpcBase);
    grpcContext.recordAttemptFailure(metrics, selfCausingGrpc);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData grpcAttemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(
            grpcAttemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("UNAVAILABLE");

    resetMetrics();
    HttpResponseException selfCausingHttp =
        new HttpResponseException(
            new HttpResponseException.Builder(503, "Service Unavailable", new HttpHeaders())) {
          @Override
          public synchronized Throwable getCause() {
            return this;
          }
        };
    Attributes httpBase = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http");
    StorageMetricsContext httpContext = StorageMetricsContext.create("GetObject", httpBase);
    httpContext.recordAttemptFailure(metrics, selfCausingHttp);

    collected = reader.collectAllMetrics();
    LongPointData httpAttemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(
            httpAttemptPoint
                .getAttributes()
                .get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(503L);
  }

  @Test
  public void recordAttemptFailure_grpcStatusExceptionsWithNullStatus_fallsBackToUnknown()
      throws Exception {
    Attributes grpcBase = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc");
    StorageMetricsContext grpcContext = StorageMetricsContext.create("GetObject", grpcBase);

    StatusRuntimeException nullStatusSre = new StatusRuntimeException(Status.UNKNOWN);
    Field sreStatusField = StatusRuntimeException.class.getDeclaredField("status");
    sreStatusField.setAccessible(true);
    sreStatusField.set(nullStatusSre, null);
    grpcContext.recordAttemptFailure(metrics, nullStatusSre);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData sreAttemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(
            sreAttemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_UNKNOWN);

    resetMetrics();
    StatusException nullStatusSe = new StatusException(Status.UNKNOWN);
    Field seStatusField = StatusException.class.getDeclaredField("status");
    seStatusField.setAccessible(true);
    seStatusField.set(nullStatusSe, null);
    grpcContext.recordAttemptFailure(metrics, nullStatusSe);

    collected = reader.collectAllMetrics();
    LongPointData seAttemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(
            seAttemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_UNKNOWN);
  }

  private static @Nullable MetricData findMetric(
      Collection<MetricData> metrics, String metricName) {
    return metrics.stream().filter(m -> m.getName().equals(metricName)).findFirst().orElse(null);
  }

  private static LongPointData getSinglePoint(Collection<MetricData> metrics, String metricName) {
    MetricData metric = findMetric(metrics, metricName);
    assertThat(metric).isNotNull();
    assertThat(metric.getLongSumData().getPoints()).hasSize(1);
    return metric.getLongSumData().getPoints().iterator().next();
  }
}
