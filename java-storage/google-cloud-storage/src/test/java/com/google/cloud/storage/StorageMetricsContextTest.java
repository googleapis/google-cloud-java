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
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import io.grpc.CallOptions;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;
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
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");

    assertThat(context.getOperationName()).isEqualTo("storage.objects.get");
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
        StorageMetricsContext.create("storage.objects.get", Attributes.empty(), customContext);
    assertThat(context.getOtelContext()).isSameInstanceAs(customContext);
  }

  @Test
  public void create_validatesNonNullArguments() {
    assertThrows(
        NullPointerException.class, () -> StorageMetricsContext.create(null, Attributes.empty()));
    assertThrows(NullPointerException.class, () -> StorageMetricsContext.create("op", null));
    assertThrows(
        NullPointerException.class,
        () -> StorageMetricsContext.create("op", Attributes.empty(), null));
  }

  @Test
  public void create_withBaseAttributes() {
    Attributes attrs =
        Attributes.of(
            AttributeKey.stringKey("gcp.client.service"),
            "storage",
            AttributeKey.stringKey("gcp.client.version"),
            "2.74.0");
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.insert", attrs);

    assertThat(context.getOperationName()).isEqualTo("storage.objects.insert");
    assertThat(context.getBaseAttributes()).isEqualTo(attrs);
    assertThat(context.attributesBuilder().build()).isEqualTo(attrs);
  }

  @Test
  public void stateMutations_accumulateValues() {
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.write");

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
        StorageMetricsContext.create("storage.objects.get", Attributes.empty(), startTime);

    long endTime = 2_500_000_000L;
    double elapsed = context.getElapsedSeconds(endTime);
    assertThat(elapsed).isEqualTo(1.5);
    assertThat(context.getElapsedSeconds()).isAtLeast(0.0);
  }

  @Test
  public void transportAttachment_grpcCallOptions() {
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");
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
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");
    GrpcCallContext callContext = GrpcCallContext.createDefault();

    GrpcCallContext attachedContext = context.attach(callContext);
    assertThat(attachedContext).isNotNull();

    StorageMetricsContext extracted = StorageMetricsContext.from(attachedContext);
    assertThat(extracted).isSameInstanceAs(context);

    assertThat(StorageMetricsContext.from((GrpcCallContext) null)).isNull();
    assertThat(StorageMetricsContext.from(GrpcCallContext.createDefault())).isNull();
  }

  @Test
  public void transportAttachment_apiCallContext() {
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");
    ApiCallContext callContext = GrpcCallContext.createDefault();

    ApiCallContext attachedContext = context.attach(callContext);
    assertThat(attachedContext).isNotNull();

    StorageMetricsContext extracted = StorageMetricsContext.from(attachedContext);
    assertThat(extracted).isSameInstanceAs(context);

    assertThat(StorageMetricsContext.from((ApiCallContext) null)).isNull();
  }

  @Test
  public void transportAttachment_apiCallContext_whenGrpcCallContext_attachesCallOptions() {
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");
    ApiCallContext callContext = GrpcCallContext.createDefault();

    ApiCallContext attachedContext = context.attach(callContext);
    assertThat(attachedContext).isNotNull();
    assertThat(attachedContext).isInstanceOf(GrpcCallContext.class);

    GrpcCallContext grpcCallContext = (GrpcCallContext) attachedContext;
    assertThat(grpcCallContext.getOption(StorageMetricsContext.API_CALL_CONTEXT_KEY))
        .isSameInstanceAs(context);
    assertThat(
            grpcCallContext.getCallOptions().getOption(StorageMetricsContext.GRPC_CALL_OPTIONS_KEY))
        .isSameInstanceAs(context);

    StorageMetricsContext extracted = StorageMetricsContext.from(attachedContext);
    assertThat(extracted).isSameInstanceAs(context);

    GrpcCallContext callOptionsOnlyContext =
        GrpcCallContext.createDefault().withCallOptions(context.attach(CallOptions.DEFAULT));
    assertThat(StorageMetricsContext.from((ApiCallContext) callOptionsOnlyContext))
        .isSameInstanceAs(context);
  }

  @Test
  public void transportAttachment_propertiesMap() {
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");
    Map<String, Object> properties = new HashMap<>();

    Map<String, Object> attachedMap = context.attach(properties);
    assertThat(attachedMap).isSameInstanceAs(properties);

    StorageMetricsContext extracted = StorageMetricsContext.from(properties);
    assertThat(extracted).isSameInstanceAs(context);

    assertThat(StorageMetricsContext.from((Map<String, Object>) null)).isNull();
    Map<String, Object> unattached = new HashMap<>();
    assertThat(StorageMetricsContext.from(unattached)).isNull();
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
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");
    context.recordAttemptSuccess(null);
  }

  @Test
  public void recordAttemptSuccess_whenAttemptsNull_noOp() {
    SdkMeterProvider provider = SdkMeterProvider.builder().build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, false, false);
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");
    context.recordAttemptSuccess(metrics);
  }

  @Test
  public void recordAttemptSuccess_defaultAttributes() {
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");
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
        .isEqualTo("storage.objects.get");
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("");
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo("");
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
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get", base);
    context.recordAttemptSuccess(metrics);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData point =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("OK");
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo("");
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_DIRECTPATH);
  }

  @Test
  public void recordAttemptSuccess_httpSystemName_setsHttpStatusCode200() {
    Attributes base = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http");
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get", base);
    context.recordAttemptSuccess(metrics);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData point =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo("200");
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("");
  }

  @Test
  public void recordAttemptSuccess_overridesFromBaseAttributes() {
    Attributes base =
        Attributes.builder()
            .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc")
            .put(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, "ALREADY_EXISTS")
            .put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, "204")
            .put(
                StorageClientMetrics.KEY_NETWORK_PATH, StorageClientMetrics.NETWORK_PATH_DIRECTPATH)
            .build();
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get", base);
    context.recordAttemptSuccess(metrics);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData point =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("ALREADY_EXISTS");
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo("");
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_DIRECTPATH);
  }

  @Test
  public void recordAttemptFailure_nullMetrics_noOp() {
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");
    context.recordAttemptFailure(null, new RuntimeException("boom"));
  }

  @Test
  public void recordAttemptFailure_whenInstrumentsNull_noOp() {
    StorageClientMetrics disabledMetrics = StorageClientMetrics.create(provider, false, false);
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");
    context.recordAttemptFailure(disabledMetrics, new RuntimeException("err"));
  }

  @Test
  public void recordAttemptFailure_storageException() {
    Attributes base = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http");
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get", base);
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
        .isEqualTo("404");
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
        .isEqualTo("storage.objects.get");
  }

  @Test
  public void recordAttemptFailure_statusRuntimeException() {
    Attributes base = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc");
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get", base);
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
        .isEqualTo("");

    LongPointData errorPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ERRORS);
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo("NOT_FOUND");
  }

  @Test
  public void recordAttemptFailure_statusException() {
    Attributes base = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc");
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get", base);
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
        .isEqualTo("");
  }

  @Test
  public void recordAttemptFailure_apiException() {
    Attributes base = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc");
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get", base);
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
        .isEqualTo("");
  }

  @Test
  public void recordAttemptFailure_httpResponseException() {
    Attributes base = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http");
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get", base);
    HttpResponseException hre =
        new HttpResponseException.Builder(429, "Too Many Requests", new HttpHeaders()).build();
    context.recordAttemptFailure(metrics, hre);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData attemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo("RESOURCE_EXHAUSTED");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo("429");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("");
  }

  @Test
  public void recordAttemptFailure_nestedCause() {
    Attributes grpcBase = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc");
    StorageMetricsContext grpcContext =
        StorageMetricsContext.create("storage.objects.get", grpcBase);
    Exception wrappedGrpc =
        new RuntimeException(new IllegalStateException(Status.UNAVAILABLE.asRuntimeException()));
    grpcContext.recordAttemptFailure(metrics, wrappedGrpc);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData attemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("UNAVAILABLE");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo("");

    resetMetrics();
    Attributes httpBase = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http");
    StorageMetricsContext httpContext =
        StorageMetricsContext.create("storage.objects.get", httpBase);
    Exception wrappedHttp = new RuntimeException(new StorageException(503, "Service Unavailable"));
    httpContext.recordAttemptFailure(metrics, wrappedHttp);
    collected = reader.collectAllMetrics();
    attemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo("503");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("");
  }

  @Test
  public void recordAttemptFailure_overridesFromBaseAttributes() {
    Attributes base =
        Attributes.builder()
            .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc")
            .put(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, "OVERRIDDEN_RPC")
            .put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, "999")
            .put(
                StorageClientMetrics.KEY_NETWORK_PATH, StorageClientMetrics.NETWORK_PATH_DIRECTPATH)
            .build();
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get", base);
    context.recordAttemptFailure(metrics, new StorageException(404, "Not Found"));

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData attemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("OVERRIDDEN_RPC");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo("");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_DIRECTPATH);

    LongPointData errorPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ERRORS);
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_DIRECTPATH);
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
