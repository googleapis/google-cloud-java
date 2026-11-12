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
import com.google.api.core.ApiClock;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.NoCredentials;
import com.google.cloud.RestorableState;
import com.google.cloud.ServiceOptions;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.BufferedWritableByteChannelSession.BufferedWritableByteChannel;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.cloud.storage.spi.StorageRpcFactory;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.io.ByteStreams;
import com.google.storage.v2.StartResumableWriteRequest;
import com.google.storage.v2.StartResumableWriteResponse;
import com.google.storage.v2.StorageGrpc;
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
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.jspecify.annotations.Nullable;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

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
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_CLIENT_ARTIFACT))
        .isEqualTo(StorageClientMetrics.ARTIFACT_STORAGE);

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

    StorageMetricsContext context = StorageMetricsContext.create("WriteObject");
    context.setRequestBytes(2048L);
    context.recordOperation(metrics, null);

    Collection<MetricData> collected = reader.collectAllMetrics();
    HistogramPointData point =
        getSingleHistogramPoint(
            collected, StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE);
    assertThat(point.getCount()).isEqualTo(1L);
    assertThat(point.getSum()).isEqualTo(2048.0);
    assertThat(point.getAttributes().get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION))
        .isEqualTo("WriteObject");
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
            .put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, 200L)
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
}
