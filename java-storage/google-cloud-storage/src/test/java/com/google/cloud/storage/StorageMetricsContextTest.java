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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.NoCredentials;
import com.google.cloud.ReadChannel;
import com.google.cloud.RestorableState;
import com.google.cloud.ServiceOptions;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.BufferedReadableByteChannelSession.BufferedReadableByteChannel;
import com.google.cloud.storage.BufferedWritableByteChannelSession.BufferedWritableByteChannel;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.cloud.storage.ZeroCopySupport.DisposableByteString;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.cloud.storage.spi.StorageRpcFactory;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.io.ByteStreams;
import com.google.protobuf.ByteString;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.BidiReadObjectResponse;
import com.google.storage.v2.BucketName;
import com.google.storage.v2.ObjectRangeData;
import com.google.storage.v2.ReadObjectRequest;
import com.google.storage.v2.ReadObjectResponse;
import com.google.storage.v2.ReadRange;
import com.google.storage.v2.StartResumableWriteRequest;
import com.google.storage.v2.StartResumableWriteResponse;
import com.google.storage.v2.StorageGrpc;
import com.google.storage.v2.StorageGrpc.StorageImplBase;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import io.grpc.CallOptions;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.Mockito;

public final class StorageMetricsContextTest {

  @Rule public final TemporaryFolder tempFolder = new TemporaryFolder();

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
            .put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, "200")
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
    assertThat(attrs.get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION)).isEqualTo("WriteObject");
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("grpc");
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_PORT)).isEqualTo(443L);
    assertThat(attrs.get(StorageClientMetrics.KEY_GCP_CLIENT_SERVICE)).isEqualTo("storage");
    assertThat(attrs.get(StorageClientMetrics.KEY_NETWORK_PATH)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_METHOD)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_GCP_CLIENT_METHOD)).isNull();
  }

  @Test
  public void recordOperation_requestBodySize_excludesAttemptAndHttpOnlyAttributes() {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    Attributes base =
        Attributes.builder()
            .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http")
            .put(StorageClientMetrics.KEY_SERVER_ADDRESS, "storage.googleapis.com")
            .put(StorageClientMetrics.KEY_SERVER_PORT, 443L)
            .put(StorageClientMetrics.KEY_HTTP_REQUEST_METHOD, "POST")
            .put(StorageClientMetrics.KEY_URL_TEMPLATE, "/upload/storage/v1/b/{bucket}/o")
            .put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, "200")
            .put(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, "OK")
            .put(StorageClientMetrics.KEY_NETWORK_PATH, StorageClientMetrics.NETWORK_PATH_CLOUDPATH)
            .put(StorageClientMetrics.KEY_ERROR_TYPE, "OK")
            .put(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION, "WriteObject")
            .put(StorageClientMetrics.KEY_GCP_CLIENT_METHOD, "Storage.create")
            .put(StorageClientMetrics.KEY_RPC_METHOD, "google.storage.v2.Storage/WriteObject")
            .build();
    StorageMetricsContext context = StorageMetricsContext.create("WriteObject", base);
    context.setRequestBytes(512L);
    context.recordOperation(metrics, null);

    Collection<MetricData> collected = reader.collectAllMetrics();
    HistogramPointData point =
        getSingleHistogramPoint(
            collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE);
    Attributes recordedAttrs = point.getAttributes();
    assertThat(recordedAttrs.get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION))
        .isEqualTo("WriteObject");
    assertThat(recordedAttrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("http");
    assertThat(recordedAttrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
    assertThat(recordedAttrs.get(StorageClientMetrics.KEY_SERVER_PORT)).isEqualTo(443L);
    assertThat(recordedAttrs.get(StorageClientMetrics.KEY_HTTP_REQUEST_METHOD)).isNull();
    assertThat(recordedAttrs.get(StorageClientMetrics.KEY_URL_TEMPLATE)).isNull();
    assertThat(recordedAttrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isNull();
    assertThat(recordedAttrs.get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE)).isNull();
    assertThat(recordedAttrs.get(StorageClientMetrics.KEY_NETWORK_PATH)).isNull();
    assertThat(recordedAttrs.get(StorageClientMetrics.KEY_ERROR_TYPE)).isNull();
    assertThat(recordedAttrs.get(StorageClientMetrics.KEY_RPC_METHOD)).isNull();
    assertThat(recordedAttrs.get(StorageClientMetrics.KEY_GCP_CLIENT_METHOD)).isNull();
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
    assertThat(
            findMetric(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE))
        .isNull();
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
    assertThat(
            findMetric(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE))
        .isNull();
  }

  @Test
  public void baseStorageWriteChannel_recordsRequestBodySizeOnClose_afterMultipleWrites()
      throws IOException {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);
    StorageMetricsContext context = StorageMetricsContext.createForMultiStep("WriteObject");

    BaseStorageWriteChannel<BlobInfo> channel = createTestWriteChannel(context, metrics, false);
    channel.write(ByteBuffer.wrap(new byte[128]));
    channel.write(ByteBuffer.wrap(new byte[384]));
    channel.close();

    Collection<MetricData> collected = reader.collectAllMetrics();
    HistogramPointData point =
        getSingleHistogramPoint(
            collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE);
    assertThat(point.getCount()).isEqualTo(1L);
    assertThat(point.getSum()).isEqualTo(512.0);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION))
        .isEqualTo("WriteObject");
  }

  @Test
  public void baseStorageWriteChannel_doesNotRecordRequestBodySize_whenZeroBytesWritten()
      throws IOException {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);
    StorageMetricsContext context = StorageMetricsContext.createForMultiStep("WriteObject");

    BaseStorageWriteChannel<BlobInfo> channel = createTestWriteChannel(context, metrics, false);
    channel.close();

    Collection<MetricData> collected = reader.collectAllMetrics();
    assertThat(
            findMetric(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE))
        .isNull();
    LongPointData opPoint =
        getSinglePoint(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS);
    assertThat(opPoint.getValue()).isEqualTo(1L);
  }

  @Test
  public void baseStorageWriteChannel_recordsRequestBodySizeEvenWhenCloseFails()
      throws IOException {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);
    StorageMetricsContext context = StorageMetricsContext.createForMultiStep("WriteObject");

    BaseStorageWriteChannel<BlobInfo> channel = createTestWriteChannel(context, metrics, true);
    channel.write(ByteBuffer.wrap(new byte[256]));
    assertThrows(StorageException.class, channel::close);

    Collection<MetricData> collected = reader.collectAllMetrics();
    HistogramPointData point =
        getSingleHistogramPoint(
            collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE);
    assertThat(point.getSum()).isEqualTo(256.0);
  }

  @Test
  @SuppressWarnings("deprecation")
  public void storageImpl_writeMethods_recordRequestBodySize_andPcuHookSuppresses()
      throws Exception {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();

    StorageRpcFactory rpcFactoryMock = mock(StorageRpcFactory.class);
    StorageRpc storageRpcMock = mock(StorageRpc.class);
    when(rpcFactoryMock.create(any(StorageOptions.class))).thenReturn(storageRpcMock);
    when(storageRpcMock.create(any(StorageObject.class), any(InputStream.class), any()))
        .thenAnswer(
            inv -> {
              InputStream in = inv.getArgument(1);
              ByteStreams.exhaust(in);
              return new StorageObject().setBucket("b").setName("n");
            });
    when(storageRpcMock.open(any(StorageObject.class), any()))
        .thenReturn("http://localhost/upload-session-1");

    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() {
                long uploadedLen = getContentLength();
                String json =
                    String.format(
                        Locale.US,
                        "{\"bucket\":\"b\",\"name\":\"n\",\"size\":\"%d\"}",
                        uploadedLen);
                return new MockLowLevelHttpResponse()
                    .setStatusCode(200)
                    .setContentType("application/json; charset=UTF-8")
                    .addHeader("content-type", "application/json; charset=UTF-8")
                    .setContent(json);
              }
            };
          }
        };
    com.google.api.services.storage.Storage apiary =
        new com.google.api.services.storage.Storage(
            mockTransport, GsonFactory.getDefaultInstance(), null);
    when(storageRpcMock.getStorage()).thenReturn(apiary);

    HttpStorageOptions options =
        HttpStorageOptions.newBuilder()
            .setProjectId("test-proj")
            .setCredentials(NoCredentials.getInstance())
            .setServiceRpcFactory(rpcFactoryMock)
            .setRetrySettings(ServiceOptions.getNoRetrySettings())
            .setEnableOtelMetrics(true)
            .setMeterProvider(provider)
            .build();
    StorageImpl storage = (StorageImpl) options.getService();
    BlobInfo blobInfo = BlobInfo.newBuilder("b", "n").build();

    // 1. create(BlobInfo, byte[]) -> 100 bytes
    storage.create(blobInfo, new byte[100]);
    // 2. create(BlobInfo, InputStream) -> 200 bytes
    storage.create(blobInfo, new ByteArrayInputStream(new byte[200]));
    // 3. createFrom(BlobInfo, Path) -> 300 bytes
    Path file1 = tempFolder.newFile("f1.bin").toPath();
    Files.write(file1, new byte[300]);
    storage.createFrom(blobInfo, file1);
    // 4. internalCreateFrom(Path, BlobInfo, Opts) -> 400 bytes
    Path file2 = tempFolder.newFile("f2.bin").toPath();
    Files.write(file2, new byte[400]);
    storage.internalCreateFrom(file2, blobInfo, Opts.empty());
    // 5. 3-arg internalDirectUpload (PCU part upload hook) -> must NOT record request.body.size
    storage.internalDirectUpload(blobInfo, Opts.empty(), ByteBuffer.wrap(new byte[999]));

    Collection<MetricData> collected = reader.collectAllMetrics();
    HistogramPointData point =
        getSingleHistogramPoint(
            collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE);
    assertThat(point.getCount()).isEqualTo(4L);
    assertThat(point.getSum()).isEqualTo(1000.0);
  }

  @Test
  public void grpcStorageImpl_writeMethods_recordRequestBodySize_andPcuHookSuppresses()
      throws Exception {
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    SdkMeterProvider provider = SdkMeterProvider.builder().registerMetricReader(reader).build();

    StorageGrpc.StorageImplBase service =
        new StorageGrpc.StorageImplBase() {
          @Override
          public void startResumableWrite(
              StartResumableWriteRequest request,
              StreamObserver<StartResumableWriteResponse> responseObserver) {
            responseObserver.onNext(
                StartResumableWriteResponse.newBuilder().setUploadId("upload-1").build());
            responseObserver.onCompleted();
          }

          @Override
          public StreamObserver<WriteObjectRequest> writeObject(
              StreamObserver<WriteObjectResponse> responseObserver) {
            return new StreamObserver<WriteObjectRequest>() {
              long totalSize = 0;

              @Override
              public void onNext(WriteObjectRequest value) {
                totalSize += value.getChecksummedData().getContent().size();
              }

              @Override
              public void onError(Throwable t) {}

              @Override
              public void onCompleted() {
                responseObserver.onNext(
                    WriteObjectResponse.newBuilder()
                        .setResource(
                            com.google.storage.v2.Object.newBuilder()
                                .setBucket("projects/_/buckets/b")
                                .setName("n")
                                .setSize(totalSize)
                                .build())
                        .build());
                responseObserver.onCompleted();
              }
            };
          }
        };

    Server server =
        NettyServerBuilder.forAddress(new InetSocketAddress("127.0.0.1", 0))
            .addService(service)
            .build()
            .start();
    try {
      String endpoint = String.format(Locale.US, "http://127.0.0.1:%d", server.getPort());
      GrpcStorageOptions options =
          StorageOptions.grpc()
              .setHost(endpoint)
              .setProjectId("test-proj")
              .setCredentials(NoCredentials.getInstance())
              .setEnableGrpcClientMetrics(false)
              .setAttemptDirectPath(false)
              .setRetrySettings(ServiceOptions.getNoRetrySettings())
              .setEnableOtelMetrics(true)
              .setMeterProvider(provider)
              .build();
      try (GrpcStorageImpl storage = (GrpcStorageImpl) options.getService()) {
        BlobInfo blobInfo = BlobInfo.newBuilder("b", "n").build();

        // 1. create(BlobInfo, byte[]) -> 120 bytes
        storage.create(blobInfo, new byte[120]);
        // 2. create(BlobInfo, InputStream) -> 230 bytes
        storage.create(blobInfo, new ByteArrayInputStream(new byte[230]));
        // 3. createFrom(BlobInfo, InputStream) -> 340 bytes
        storage.createFrom(blobInfo, new ByteArrayInputStream(new byte[340]));
        // 4. createFrom(BlobInfo, Path) / internalCreateFrom -> 410 bytes
        Path file = tempFolder.newFile("grpc.bin").toPath();
        Files.write(file, new byte[410]);
        storage.createFrom(blobInfo, file);
        // 5. writer(BlobInfo) -> 500 bytes
        try (WriteChannel writer = storage.writer(blobInfo)) {
          writer.write(ByteBuffer.wrap(new byte[500]));
        }
        // 6. 3-arg internalDirectUpload (PCU hook) -> must NOT record request.body.size
        storage.internalDirectUpload(blobInfo, Opts.empty(), ByteBuffer.wrap(new byte[777]));

        // 7. internalCreateFrom with nonexistent Path -> throws NoSuchFileException inside try
        // block and still records the failed WriteObject operation metric
        Path missingPath = tempFolder.getRoot().toPath().resolve("does-not-exist.bin");
        assertThrows(
            NoSuchFileException.class,
            () -> storage.internalCreateFrom(missingPath, blobInfo, Opts.empty()));

        Collection<MetricData> collected = reader.collectAllMetrics();
        HistogramPointData bodyPoint =
            getSingleHistogramPoint(
                collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE);
        assertThat(bodyPoint.getCount()).isEqualTo(5L);
        assertThat(bodyPoint.getSum()).isEqualTo(1600.0);

        MetricData opsMetric =
            findMetric(collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS);
        assertThat(opsMetric).isNotNull();
        long totalOps =
            opsMetric.getLongSumData().getPoints().stream()
                .mapToLong(LongPointData::getValue)
                .sum();
        // 5 successful WriteObject ops + 1 failed internalCreateFrom(missingPath) op = 6 ops
        assertThat(totalOps).isEqualTo(6L);
      }
    } finally {
      server.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
  }

  private static BaseStorageWriteChannel<BlobInfo> createTestWriteChannel(
      StorageMetricsContext context, StorageClientMetrics metrics, boolean failOnClose) {
    BlobInfo resultBlob = BlobInfo.newBuilder("b", "n").build();
    BufferedWritableByteChannel bufferedChannel =
        new BufferedWritableByteChannel() {
          private boolean open = true;

          @Override
          public void flush() {}

          @Override
          public int write(ByteBuffer src) {
            int remaining = src.remaining();
            src.position(src.limit());
            return remaining;
          }

          @Override
          public boolean isOpen() {
            return open;
          }

          @Override
          public void close() throws IOException {
            open = false;
            if (failOnClose) {
              throw new IOException("simulated close failure");
            }
          }
        };
    BufferedWritableByteChannelSession<BlobInfo> session =
        new BufferedWritableByteChannelSession<BlobInfo>() {
          @Override
          public ApiFuture<BufferedWritableByteChannel> openAsync() {
            return ApiFutures.immediateFuture(bufferedChannel);
          }

          @Override
          public BufferedWritableByteChannel open() {
            return bufferedChannel;
          }

          @Override
          public ApiFuture<BlobInfo> getResult() {
            return ApiFutures.immediateFuture(resultBlob);
          }
        };
    return new BaseStorageWriteChannel<BlobInfo>(Decoder.identity(), context, metrics) {
      @Override
      public RestorableState<WriteChannel> capture() {
        return null;
      }

      @Override
      protected LazyWriteChannel<BlobInfo> newLazyWriteChannel() {
        return new LazyWriteChannel<>(() -> session);
      }
    };
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
            .put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, "200")
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
    assertThat(attrs.get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION)).isEqualTo("ReadObject");
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("grpc");
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_PORT)).isEqualTo(443L);
    assertThat(attrs.get(StorageClientMetrics.KEY_GCP_CLIENT_SERVICE)).isEqualTo("storage");
    assertThat(attrs.get(StorageClientMetrics.KEY_NETWORK_PATH)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE)).isNull();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_METHOD)).isNull();
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
