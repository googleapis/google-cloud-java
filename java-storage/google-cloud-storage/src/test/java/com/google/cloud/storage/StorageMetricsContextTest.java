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

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiCallContext;
import io.grpc.CallOptions;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

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
    StorageMetricsContext parent = StorageMetricsContext.createForMultiStep("WriteObject");
    assertThat(parent.shouldRecordOperationOnRetrierExit()).isFalse();

    StorageMetricsContext subAttempt = parent.asSubAttemptContext();
    assertThat(subAttempt.shouldRecordOperationOnRetrierExit()).isFalse();
    assertThat(subAttempt.getOperationName()).isEqualTo("WriteObject");

    subAttempt.incrementAttempts();
    assertThat(parent.getAttemptCount()).isEqualTo(1);
    assertThat(subAttempt.getAttemptCount()).isEqualTo(1);
  }

  @Test
  public void recordOperation_isIdempotent() {
    io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader reader =
        io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader.create();
    io.opentelemetry.sdk.metrics.SdkMeterProvider provider =
        io.opentelemetry.sdk.metrics.SdkMeterProvider.builder()
            .registerMetricReader(reader)
            .build();
    StorageClientMetrics metrics = StorageClientMetrics.create(provider, true, false);

    StorageMetricsContext context = StorageMetricsContext.createForMultiStep("WriteObject");
    context.recordOperation(metrics, null);
    context.recordOperation(metrics, null);

    java.util.Collection<io.opentelemetry.sdk.metrics.data.MetricData> collected =
        reader.collectAllMetrics();
    long opCount =
        collected.stream()
            .filter(
                m -> m.getName().equals(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS))
            .flatMap(m -> m.getLongSumData().getPoints().stream())
            .mapToLong(p -> p.getValue())
            .sum();
    assertThat(opCount).isEqualTo(1L);
  }
}
