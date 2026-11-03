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
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.ReadChannel;
import com.google.cloud.RestorableState;
import com.google.cloud.storage.BufferedReadableByteChannelSession.BufferedReadableByteChannel;
import com.google.cloud.storage.ZeroCopySupport.DisposableByteString;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.cloud.storage.spi.StorageRpcFactory;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.protobuf.ByteString;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.BidiReadObjectResponse;
import com.google.storage.v2.BucketName;
import com.google.storage.v2.ObjectRangeData;
import com.google.storage.v2.ReadObjectRequest;
import com.google.storage.v2.ReadObjectResponse;
import com.google.storage.v2.ReadRange;
import com.google.storage.v2.StorageGrpc.StorageImplBase;
import io.grpc.CallOptions;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;
import org.mockito.Mockito;

public final class StorageMetricsContextTest {

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

    context1.incrementAttempts();
    assertThat(context1.getAttemptCount()).isEqualTo(1);
  }

  @Test
  public void recordOperation_isIdempotent() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

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
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

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
        .isNull();
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isNull();
    // Errors counter must not be recorded on success
    assertThat(findMetric(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ERRORS))
        .isNull();
  }

  @Test
  public void recordAttemptSuccess_grpcSystemName_setsRpcStatusCodeOk() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    Attributes base = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc");
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get", base);
    context.recordAttemptSuccess(metrics);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData point =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("OK");
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isNull();
  }

  @Test
  public void recordAttemptSuccess_httpSystemName_setsHttpStatusCode200() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    Attributes base = Attributes.of(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http");
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get", base);
    context.recordAttemptSuccess(metrics);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData point =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(200L);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isNull();
  }

  @Test
  public void recordAttemptSuccess_overridesFromBaseAttributes() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    Attributes base =
        Attributes.builder()
            .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc")
            .put(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, "ALREADY_EXISTS")
            .put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, 204L)
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
        .isEqualTo(204L);
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
    SdkMeterProvider provider = SdkMeterProvider.builder().build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, false, false);
    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");
    context.recordAttemptFailure(metrics, new RuntimeException("err"));
  }

  @Test
  public void recordAttemptFailure_storageException() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");
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
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");
    StatusRuntimeException sre = Status.NOT_FOUND.asRuntimeException();
    context.recordAttemptFailure(metrics, sre);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData attemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo("NOT_FOUND");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("NOT_FOUND");

    LongPointData errorPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ERRORS);
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo("NOT_FOUND");
  }

  @Test
  public void recordAttemptFailure_statusException() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");
    StatusException se = Status.PERMISSION_DENIED.asException();
    context.recordAttemptFailure(metrics, se);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData attemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo("PERMISSION_DENIED");
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("PERMISSION_DENIED");
  }

  @Test
  public void recordAttemptFailure_apiException() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");
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
  }

  @Test
  public void recordAttemptFailure_httpResponseException() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");
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
  }

  @Test
  public void recordAttemptFailure_nestedCause() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    StorageMetricsContext context = StorageMetricsContext.create("storage.objects.get");
    Exception wrappedGrpc =
        new RuntimeException(new IllegalStateException(Status.UNAVAILABLE.asRuntimeException()));
    context.recordAttemptFailure(metrics, wrappedGrpc);

    Collection<MetricData> collected = reader.collectAllMetrics();
    LongPointData attemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE))
        .isEqualTo("UNAVAILABLE");

    reader = InMemoryMetricReader.create();
    provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    metrics = StorageClientMetrics.create(provider, true, false);
    Exception wrappedHttp = new RuntimeException(new StorageException(503, "Service Unavailable"));
    context.recordAttemptFailure(metrics, wrappedHttp);
    collected = reader.collectAllMetrics();
    attemptPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS);
    assertThat(attemptPoint.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
        .isEqualTo(503L);
  }

  @Test
  public void recordAttemptFailure_overridesFromBaseAttributes() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    Attributes base =
        Attributes.builder()
            .put(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, "OVERRIDDEN_RPC")
            .put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, 999L)
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
        .isEqualTo(999L);
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

  private static HistogramPointData getSingleHistogramPoint(
      Collection<MetricData> metrics, String metricName) {
    MetricData metric = findMetric(metrics, metricName);
    assertThat(metric).isNotNull();
    assertThat(metric.getHistogramData().getPoints()).hasSize(1);
    return metric.getHistogramData().getPoints().iterator().next();
  }

  @Test
  public void recordOperation_recordsRequestBodySize_whenWriteObjectAndBytesGreaterThanZero() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    Attributes baseAttributes =
        Attributes.builder()
            .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc")
            .put(StorageClientMetrics.KEY_SERVER_ADDRESS, "storage.googleapis.com")
            .put(StorageClientMetrics.KEY_SERVER_PORT, 443L)
            .put(
                StorageClientMetrics.KEY_NETWORK_PATH, StorageClientMetrics.NETWORK_PATH_DIRECTPATH)
            .put(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, "OK")
            .put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, 200L)
            .put(StorageClientMetrics.KEY_ERROR_TYPE, StorageErrorTypeMapper.STATUS_OK)
            .put(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION, "WriteObject")
            .put(StorageClientMetrics.KEY_GCP_CLIENT_METHOD, "Storage.writer")
            .build();
    StorageMetricsContext context = StorageMetricsContext.create("WriteObject", baseAttributes);
    context.setRequestBytes(2048L);
    context.recordOperation(metrics, null);

    Collection<MetricData> collected = reader.collectAllMetrics();
    HistogramPointData point =
        getSingleHistogramPoint(
            collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE);

    assertThat(point.getCount()).isEqualTo(1L);
    assertThat(point.getSum()).isEqualTo(2048.0);
    Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_METHOD)).isEqualTo("WriteObject");
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("grpc");
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_PORT)).isEqualTo(443L);
    assertThat(attrs.get(StorageClientMetrics.KEY_GCP_CLIENT_SERVICE)).isEqualTo("storage");
    assertThat(attrs.get(StorageClientMetrics.KEY_NETWORK_PATH)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_GCP_CLIENT_METHOD)).isNull();
  }

  @Test
  public void recordOperation_doesNotRecordRequestBodySize_whenBytesIsZero() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    StorageMetricsContext context = StorageMetricsContext.create("WriteObject");
    context.setRequestBytes(0L);
    context.recordOperation(metrics, null);

    Collection<MetricData> collected = reader.collectAllMetrics();
    MetricData bodySizeData =
        findMetric(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE);

    assertThat(bodySizeData).isNull();
  }

  @Test
  public void recordOperation_doesNotRecordRequestBodySize_whenNotWriteObject() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    StorageMetricsContext context = StorageMetricsContext.create("ReadObject");
    context.setRequestBytes(2048L);
    context.recordOperation(metrics, null);

    Collection<MetricData> collected = reader.collectAllMetrics();
    MetricData bodySizeData =
        findMetric(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE);

    assertThat(bodySizeData).isNull();
  }

  @Test
  public void recordOperation_recordsResponseBodySize_whenReadObjectAndBytesGreaterThanZero() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    Attributes baseAttributes =
        Attributes.builder()
            .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc")
            .put(StorageClientMetrics.KEY_SERVER_ADDRESS, "storage.googleapis.com")
            .put(StorageClientMetrics.KEY_SERVER_PORT, 443L)
            .put(
                StorageClientMetrics.KEY_NETWORK_PATH, StorageClientMetrics.NETWORK_PATH_DIRECTPATH)
            .put(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, "OK")
            .put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, 200L)
            .put(StorageClientMetrics.KEY_ERROR_TYPE, StorageErrorTypeMapper.STATUS_OK)
            .put(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION, "ReadObject")
            .put(StorageClientMetrics.KEY_GCP_CLIENT_METHOD, "Storage.reader")
            .build();
    StorageMetricsContext context = StorageMetricsContext.create("ReadObject", baseAttributes);
    context.setResponseBytes(4096L);
    context.recordOperation(metrics, null);

    Collection<MetricData> collected = reader.collectAllMetrics();
    HistogramPointData point =
        getSingleHistogramPoint(
            collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE);

    assertThat(point.getCount()).isEqualTo(1L);
    assertThat(point.getSum()).isEqualTo(4096.0);
    Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_METHOD)).isEqualTo("ReadObject");
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("grpc");
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_PORT)).isEqualTo(443L);
    assertThat(attrs.get(StorageClientMetrics.KEY_GCP_CLIENT_SERVICE)).isEqualTo("storage");
    assertThat(attrs.get(StorageClientMetrics.KEY_NETWORK_PATH)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_GCP_CLIENT_METHOD)).isNull();
  }

  @Test
  public void recordOperation_doesNotRecordResponseBodySize_whenBytesIsZero() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    StorageMetricsContext context = StorageMetricsContext.create("ReadObject");
    context.setResponseBytes(0L);
    context.recordOperation(metrics, null);

    Collection<MetricData> collected = reader.collectAllMetrics();
    MetricData bodySizeData =
        findMetric(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE);

    assertThat(bodySizeData).isNull();
  }

  @Test
  public void recordOperation_doesNotRecordResponseBodySize_whenNotReadObject() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    StorageMetricsContext context = StorageMetricsContext.create("WriteObject");
    context.setResponseBytes(4096L);
    context.recordOperation(metrics, null);

    Collection<MetricData> collected = reader.collectAllMetrics();
    MetricData bodySizeData =
        findMetric(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE);

    assertThat(bodySizeData).isNull();
  }

  @Test
  public void baseStorageReadChannel_recordsResponseBodySizeOnClose_fullRead() throws IOException {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);
    StorageMetricsContext context = StorageMetricsContext.createForMultiStep("ReadObject");

    byte[] payload = "0123456789abcdef0123456789abcdef".getBytes(StandardCharsets.UTF_8);
    try (StorageReadChannel channel = new FakeStorageReadChannel(payload, null, context, metrics)) {
      ByteBuffer buf = ByteBuffer.allocate(10);
      int total = 0;
      int r;
      while ((r = channel.read(buf)) != -1) {
        total += r;
        buf.clear();
      }
      assertThat(total).isEqualTo(payload.length);
    }

    Collection<MetricData> collected = reader.collectAllMetrics();
    HistogramPointData point =
        getSingleHistogramPoint(
            collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE);
    assertThat(point.getCount()).isEqualTo(1L);
    assertThat(point.getSum()).isEqualTo((double) payload.length);
    LongPointData opPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS);
    assertThat(opPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_OK);
  }

  @Test
  public void baseStorageReadChannel_recordsResponseBodySizeOnClose_partialReadEarlyClose()
      throws IOException {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);
    StorageMetricsContext context = StorageMetricsContext.createForMultiStep("ReadObject");

    byte[] payload = new byte[100];
    try (StorageReadChannel channel = new FakeStorageReadChannel(payload, null, context, metrics)) {
      ByteBuffer buf = ByteBuffer.allocate(12);
      int read = channel.read(buf);
      assertThat(read).isEqualTo(12);
    }

    Collection<MetricData> collected = reader.collectAllMetrics();
    HistogramPointData point =
        getSingleHistogramPoint(
            collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE);
    assertThat(point.getCount()).isEqualTo(1L);
    assertThat(point.getSum()).isEqualTo(12.0);
  }

  @Test
  public void baseStorageReadChannel_doesNotRecordResponseBodySize_whenClosedWithoutReading() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);
    StorageMetricsContext context = StorageMetricsContext.createForMultiStep("ReadObject");

    byte[] payload = new byte[100];
    try (StorageReadChannel ignored = new FakeStorageReadChannel(payload, null, context, metrics)) {
      // Close immediately without reading any bytes
    }

    Collection<MetricData> collected = reader.collectAllMetrics();
    assertThat(
            findMetric(
                collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE))
        .isNull();
    assertThat(findMetric(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS))
        .isNotNull();
  }

  @Test
  public void baseStorageReadChannel_recordsPartialBytesAndError_whenMidStreamErrorOccurs() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);
    StorageMetricsContext context = StorageMetricsContext.createForMultiStep("ReadObject");

    byte[] payload = new byte[64];
    StorageException midStreamError = new StorageException(503, "Service Unavailable");
    IOException thrown =
        assertThrows(
            IOException.class,
            () -> {
              try (StorageReadChannel channel =
                  new FakeStorageReadChannel(payload, midStreamError, context, metrics)) {
                ByteBuffer buf = ByteBuffer.allocate(16);
                assertThat(channel.read(buf)).isEqualTo(16);
                buf.clear();
                channel.read(buf);
              }
            });
    assertThat(thrown).hasCauseThat().isSameInstanceAs(midStreamError);

    Collection<MetricData> collected = reader.collectAllMetrics();
    HistogramPointData point =
        getSingleHistogramPoint(
            collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE);
    assertThat(point.getCount()).isEqualTo(1L);
    assertThat(point.getSum()).isEqualTo(16.0);

    LongPointData opPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS);
    assertThat(opPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_UNAVAILABLE);
  }

  @Test
  public void storageImpl_readAllBytes_recordsResponseBodySize() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageRpc storageRpc = Mockito.mock(StorageRpc.class);
    StorageRpcFactory rpcFactory = options -> storageRpc;

    byte[] payload = "response-body-bytes".getBytes(StandardCharsets.UTF_8);
    Mockito.when(storageRpc.load(Mockito.any(StorageObject.class), Mockito.anyMap()))
        .thenReturn(payload);

    HttpStorageOptions options =
        HttpStorageOptions.newBuilder()
            .setProjectId("test-proj")
            .setServiceRpcFactory(rpcFactory)
            .setMeterProvider(provider)
            .setEnableOtelMetrics(true)
            .build();
    Storage storage = options.getService();

    byte[] actual = storage.readAllBytes(BlobId.of("b", "o"));
    assertThat(actual).isEqualTo(payload);

    Collection<MetricData> collected = reader.collectAllMetrics();
    HistogramPointData point =
        getSingleHistogramPoint(
            collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE);
    assertThat(point.getCount()).isEqualTo(1L);
    assertThat(point.getSum()).isEqualTo((double) payload.length);
  }

  @Test
  public void storageImpl_downloadTo_recordsResponseBodySize_acrossRetriesWithoutDoubleCounting() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageRpc storageRpc = Mockito.mock(StorageRpc.class);
    StorageRpcFactory rpcFactory = options -> storageRpc;

    byte[] payload =
        "0123456789abcdefghij0123456789abcdefghij0123456789".getBytes(StandardCharsets.UTF_8);
    AtomicInteger callCount = new AtomicInteger(0);
    Mockito.doAnswer(
            invocation -> {
              long position = invocation.getArgument(2);
              OutputStream out = invocation.getArgument(3);
              int attempt = callCount.incrementAndGet();
              if (attempt == 1) {
                out.write(payload, 0, 20);
                throw new StorageException(503, "Transient failure after 20 bytes");
              }
              out.write(payload, (int) position, payload.length - (int) position);
              return (long) (payload.length - (int) position);
            })
        .when(storageRpc)
        .read(
            Mockito.any(StorageObject.class),
            Mockito.anyMap(),
            Mockito.anyLong(),
            Mockito.any(OutputStream.class));

    HttpStorageOptions options =
        HttpStorageOptions.newBuilder()
            .setProjectId("test-proj")
            .setServiceRpcFactory(rpcFactory)
            .setRetrySettings(
                RetrySettings.newBuilder()
                    .setMaxAttempts(3)
                    .setInitialRetryDelayDuration(Duration.ofMillis(1))
                    .setMaxRetryDelayDuration(Duration.ofMillis(5))
                    .setRetryDelayMultiplier(1.0)
                    .build())
            .setMeterProvider(provider)
            .setEnableOtelMetrics(true)
            .build();
    Storage storage = options.getService();

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    storage.downloadTo(BlobId.of("b", "o"), out);
    assertThat(out.toByteArray()).isEqualTo(payload);
    assertThat(callCount.get()).isEqualTo(2);

    Collection<MetricData> collected = reader.collectAllMetrics();
    HistogramPointData point =
        getSingleHistogramPoint(
            collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE);
    assertThat(point.getCount()).isEqualTo(1L);
    assertThat(point.getSum()).isEqualTo((double) payload.length);
  }

  @Test
  public void blobReadSessionAdapter_recordsResponseBodySizeOnClose_acrossProjections()
      throws Exception {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);
    StorageMetricsContext context = StorageMetricsContext.createForMultiStep("ReadObject");

    byte[] futureBytesPayload = new byte[25];
    ByteString byteStringPayload = ByteString.copyFrom(new byte[15]);
    byte[] channelPayload = new byte[40];
    byte[] seekablePayload = new byte[30];

    ObjectReadSession fakeSession =
        new ObjectReadSession() {
          @Override
          public com.google.storage.v2.Object getResource() {
            return com.google.storage.v2.Object.getDefaultInstance();
          }

          @SuppressWarnings("unchecked")
          @Override
          public <Projection> Projection readAs(ReadProjectionConfig<Projection> config) {
            if (config instanceof ReadAsFutureBytes) {
              return (Projection) ApiFutures.immediateFuture(futureBytesPayload);
            }
            if (config instanceof ReadAsFutureByteString) {
              DisposableByteString dbs =
                  new DisposableByteString() {
                    @Override
                    public ByteString byteString() {
                      return byteStringPayload;
                    }

                    @Override
                    public void close() {}
                  };
              return (Projection) ApiFutures.immediateFuture(dbs);
            }
            if (config instanceof ReadAsChannel) {
              return (Projection) new FakeScatteringByteChannel(channelPayload);
            }
            if (config instanceof ReadAsSeekableChannel) {
              return (Projection) new FakeSeekableByteChannel(seekablePayload);
            }
            throw new UnsupportedOperationException("Unexpected config: " + config);
          }

          @Override
          public void close() {}
        };

    ApiFuture<BlobReadSession> wrapped =
        BlobReadSessionAdapter.wrap(ApiFutures.immediateFuture(fakeSession), context, metrics);
    try (BlobReadSession session = wrapped.get()) {
      byte[] b1 = session.readAs(ReadProjectionConfigs.asFutureBytes()).get();
      assertThat(b1).hasLength(25);

      try (DisposableByteString dbs =
          session.readAs(ReadProjectionConfigs.asFutureByteString()).get()) {
        assertThat(dbs.byteString().size()).isEqualTo(15);
      }

      // Partial read from ScatteringByteChannel (read 10 of 40 bytes)
      try (ScatteringByteChannel ch = session.readAs(ReadProjectionConfigs.asChannel())) {
        ByteBuffer dst = ByteBuffer.allocate(10);
        assertThat(ch.read(dst)).isEqualTo(10);
      }

      // Read 12 bytes from SeekableByteChannel
      try (SeekableByteChannel seekable =
          session.readAs(ReadProjectionConfigs.asSeekableChannel())) {
        ByteBuffer dst = ByteBuffer.allocate(12);
        assertThat(seekable.read(dst)).isEqualTo(12);
      }
    }

    Collection<MetricData> collected = reader.collectAllMetrics();
    HistogramPointData point =
        getSingleHistogramPoint(
            collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE);
    assertThat(point.getCount()).isEqualTo(1L);
    assertThat(point.getSum()).isEqualTo(25.0 + 15.0 + 10.0 + 12.0);
  }

  @Test
  public void blobReadSessionAdapter_doesNotRecordResponseBodySize_whenOpenFails() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);
    StorageMetricsContext context = StorageMetricsContext.createForMultiStep("ReadObject");

    ApiFuture<ObjectReadSession> failedOpen =
        ApiFutures.immediateFailedFuture(new StorageException(404, "Not Found"));
    ApiFuture<BlobReadSession> wrapped = BlobReadSessionAdapter.wrap(failedOpen, context, metrics);

    assertThrows(ExecutionException.class, wrapped::get);

    Collection<MetricData> collected = reader.collectAllMetrics();
    assertThat(
            findMetric(
                collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE))
        .isNull();
    LongPointData opPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS);
    assertThat(opPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_NOT_FOUND);
  }

  @Test
  public void grpcStorageImpl_readAllBytes_recordsResponseBodySizeAndSuppressesOnMidStreamError()
      throws Exception {
    byte[] payload = "0123456789abcdefghij01234".getBytes(StandardCharsets.UTF_8);
    ChecksummedTestContent chunk1 = ChecksummedTestContent.of(payload, 0, 10);
    ChecksummedTestContent chunk2 = ChecksummedTestContent.of(payload, 10, 15);
    com.google.storage.v2.Object meta =
        com.google.storage.v2.Object.newBuilder()
            .setBucket(BucketName.format("_", "b"))
            .setName("ok")
            .setGeneration(1L)
            .setSize(payload.length)
            .build();

    StorageImplBase fakeService =
        new StorageImplBase() {
          @Override
          public void readObject(
              ReadObjectRequest request, StreamObserver<ReadObjectResponse> responseObserver) {
            if ("ok".equals(request.getObject())) {
              responseObserver.onNext(
                  ReadObjectResponse.newBuilder()
                      .setMetadata(meta)
                      .setChecksummedData(chunk1.asChecksummedData())
                      .build());
              responseObserver.onNext(
                  ReadObjectResponse.newBuilder()
                      .setChecksummedData(chunk2.asChecksummedData())
                      .build());
              responseObserver.onCompleted();
            } else {
              responseObserver.onNext(
                  ReadObjectResponse.newBuilder()
                      .setMetadata(meta.toBuilder().setName("fail").build())
                      .setChecksummedData(chunk1.asChecksummedData())
                      .build());
              responseObserver.onError(Status.PERMISSION_DENIED.asRuntimeException());
            }
          }
        };

    InMemoryMetricReader okReader = InMemoryMetricReader.create();
    SdkMeterProvider okProvider = SdkMeterProvider.builder().registerMetricReader(okReader).build();
    InMemoryMetricReader failReader = InMemoryMetricReader.create();
    SdkMeterProvider failProvider =
        SdkMeterProvider.builder().registerMetricReader(failReader).build();

    try (FakeServer fakeServer = FakeServer.of(fakeService);
        Storage okStorage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(1).build())
                .setMeterProvider(okProvider)
                .setEnableOtelMetrics(true)
                .build()
                .getService();
        Storage failStorage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(1).build())
                .setMeterProvider(failProvider)
                .setEnableOtelMetrics(true)
                .build()
                .getService()) {
      byte[] actual = okStorage.readAllBytes(BlobId.of("b", "ok"));
      assertThat(actual).isEqualTo(payload);

      HistogramPointData point =
          getSingleHistogramPoint(
              okReader.collectAllMetrics(),
              StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE);
      assertThat(point.getCount()).isEqualTo(1L);
      assertThat(point.getSum()).isEqualTo((double) payload.length);

      assertThrows(StorageException.class, () -> failStorage.readAllBytes(BlobId.of("b", "fail")));
      assertThat(
              findMetric(
                  failReader.collectAllMetrics(),
                  StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE))
          .isNull();
    }
  }

  @Test
  public void grpcStorageImpl_downloadToAndBlobReadSession_recordResponseBodySize()
      throws Exception {
    byte[] payload = "0123456789abcdefghij0123456789".getBytes(StandardCharsets.UTF_8);
    ChecksummedTestContent content = ChecksummedTestContent.of(payload);
    com.google.storage.v2.Object meta =
        com.google.storage.v2.Object.newBuilder()
            .setBucket(BucketName.format("_", "b"))
            .setName("o")
            .setGeneration(1L)
            .setSize(payload.length)
            .build();

    StorageImplBase fakeService =
        new StorageImplBase() {
          @Override
          public void readObject(
              ReadObjectRequest request, StreamObserver<ReadObjectResponse> responseObserver) {
            responseObserver.onNext(
                ReadObjectResponse.newBuilder()
                    .setMetadata(meta)
                    .setChecksummedData(content.asChecksummedData())
                    .build());
            responseObserver.onCompleted();
          }

          @Override
          public StreamObserver<BidiReadObjectRequest> bidiReadObject(
              StreamObserver<BidiReadObjectResponse> responseObserver) {
            return new StreamObserver<BidiReadObjectRequest>() {
              @Override
              public void onNext(BidiReadObjectRequest req) {
                if (req.getReadRangesList().isEmpty()) {
                  responseObserver.onNext(
                      BidiReadObjectResponse.newBuilder().setMetadata(meta).build());
                } else {
                  ReadRange rr = req.getReadRangesList().get(0);
                  responseObserver.onNext(
                      BidiReadObjectResponse.newBuilder()
                          .addObjectDataRanges(
                              ObjectRangeData.newBuilder()
                                  .setReadRange(
                                      ReadRange.newBuilder()
                                          .setReadId(rr.getReadId())
                                          .setReadOffset(0)
                                          .setReadLength(payload.length)
                                          .build())
                                  .setRangeEnd(true)
                                  .setChecksummedData(content.asChecksummedData())
                                  .build())
                          .build());
                }
              }

              @Override
              public void onError(Throwable t) {
                responseObserver.onError(t);
              }

              @Override
              public void onCompleted() {
                responseObserver.onCompleted();
              }
            };
          }
        };

    InMemoryMetricReader downloadReader = InMemoryMetricReader.create();
    SdkMeterProvider downloadProvider =
        SdkMeterProvider.builder().registerMetricReader(downloadReader).build();
    InMemoryMetricReader sessionReader = InMemoryMetricReader.create();
    SdkMeterProvider sessionProvider =
        SdkMeterProvider.builder().registerMetricReader(sessionReader).build();

    try (FakeServer fakeServer = FakeServer.of(fakeService);
        Storage downloadStorage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(1).build())
                .setMeterProvider(downloadProvider)
                .setEnableOtelMetrics(true)
                .build()
                .getService();
        Storage sessionStorage =
            fakeServer.getGrpcStorageOptions().toBuilder()
                .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(1).build())
                .setMeterProvider(sessionProvider)
                .setEnableOtelMetrics(true)
                .build()
                .getService()) {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      downloadStorage.downloadTo(BlobId.of("b", "o"), baos);
      assertThat(baos.toByteArray()).isEqualTo(payload);

      HistogramPointData downloadPoint =
          getSingleHistogramPoint(
              downloadReader.collectAllMetrics(),
              StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE);
      assertThat(downloadPoint.getCount()).isEqualTo(1L);
      assertThat(downloadPoint.getSum()).isEqualTo((double) payload.length);

      try (BlobReadSession session =
          sessionStorage.blobReadSession(BlobId.of("b", "o")).get(5, TimeUnit.SECONDS)) {
        byte[] sessionBytes =
            session.readAs(ReadProjectionConfigs.asFutureBytes()).get(5, TimeUnit.SECONDS);
        assertThat(sessionBytes).isEqualTo(payload);
      }

      HistogramPointData sessionPoint =
          getSingleHistogramPoint(
              sessionReader.collectAllMetrics(),
              StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE);
      assertThat(sessionPoint.getCount()).isEqualTo(1L);
      assertThat(sessionPoint.getSum()).isEqualTo((double) payload.length);
    }
  }

  private static final class FakeStorageReadChannel extends BaseStorageReadChannel<String> {
    private final byte[] data;
    @Nullable private final StorageException errorAfterFirstRead;

    FakeStorageReadChannel(
        byte[] data,
        @Nullable StorageException errorAfterFirstRead,
        @Nullable StorageMetricsContext metricsContext,
        @Nullable StorageClientMetrics storageClientMetrics) {
      super(s -> BlobInfo.newBuilder("b", "o").build(), metricsContext, storageClientMetrics);
      this.data = data;
      this.errorAfterFirstRead = errorAfterFirstRead;
    }

    @Override
    protected LazyReadChannel<?, String> newLazyReadChannel() {
      return new LazyReadChannel<>(
          () ->
              new BufferedReadableByteChannelSession<String>() {
                @Override
                public ApiFuture<BufferedReadableByteChannel> openAsync() {
                  return ApiFutures.immediateFuture(
                      new BufferedReadableByteChannel() {
                        private int offset = 0;
                        private boolean open = true;
                        private int reads = 0;

                        @Override
                        public int read(ByteBuffer dst) throws IOException {
                          reads++;
                          if (reads > 1 && errorAfterFirstRead != null) {
                            throw errorAfterFirstRead;
                          }
                          if (offset >= data.length) {
                            return -1;
                          }
                          int toCopy = Math.min(dst.remaining(), data.length - offset);
                          dst.put(data, offset, toCopy);
                          offset += toCopy;
                          return toCopy;
                        }

                        @Override
                        public boolean isOpen() {
                          return open;
                        }

                        @Override
                        public void close() {
                          open = false;
                        }
                      });
                }

                @Override
                public ApiFuture<String> getResult() {
                  return ApiFutures.immediateFuture("ok");
                }
              });
    }

    @Override
    public RestorableState<ReadChannel> capture() {
      throw new UnsupportedOperationException();
    }
  }

  private static final class FakeScatteringByteChannel implements ScatteringByteChannel {
    private final byte[] data;
    private int offset = 0;
    private boolean open = true;

    FakeScatteringByteChannel(byte[] data) {
      this.data = data;
    }

    @Override
    public int read(ByteBuffer dst) {
      if (offset >= data.length) {
        return -1;
      }
      int toCopy = Math.min(dst.remaining(), data.length - offset);
      dst.put(data, offset, toCopy);
      offset += toCopy;
      return toCopy;
    }

    @Override
    public long read(ByteBuffer[] dsts, int off, int length) {
      long total = 0;
      for (int i = off; i < off + length; i++) {
        int r = read(dsts[i]);
        if (r == -1) {
          return total == 0 ? -1 : total;
        }
        total += r;
      }
      return total;
    }

    @Override
    public long read(ByteBuffer[] dsts) {
      return read(dsts, 0, dsts.length);
    }

    @Override
    public boolean isOpen() {
      return open;
    }

    @Override
    public void close() {
      open = false;
    }
  }

  private static final class FakeSeekableByteChannel implements SeekableByteChannel {
    private final byte[] data;
    private int position = 0;
    private boolean open = true;

    FakeSeekableByteChannel(byte[] data) {
      this.data = data;
    }

    @Override
    public int read(ByteBuffer dst) {
      if (position >= data.length) {
        return -1;
      }
      int toCopy = Math.min(dst.remaining(), data.length - position);
      dst.put(data, position, toCopy);
      position += toCopy;
      return toCopy;
    }

    @Override
    public int write(ByteBuffer src) {
      throw new UnsupportedOperationException();
    }

    @Override
    public long position() {
      return position;
    }

    @Override
    public SeekableByteChannel position(long newPosition) {
      this.position = (int) newPosition;
      return this;
    }

    @Override
    public long size() {
      return data.length;
    }

    @Override
    public SeekableByteChannel truncate(long size) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean isOpen() {
      return open;
    }

    @Override
    public void close() {
      open = false;
    }
  }
}
