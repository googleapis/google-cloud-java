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

import static java.util.Objects.requireNonNull;

import com.google.api.core.ApiClock;
import com.google.api.core.NanoClock;
import com.google.api.gax.grpc.GrpcCallContext;
import io.grpc.CallOptions;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Package-private holder for operation metric state across asynchronous and thread-hopping
 * boundaries.
 */
@NullMarked
final class StorageMetricsContext {

  static final CallOptions.Key<StorageMetricsContext> GRPC_CALL_OPTIONS_KEY =
      CallOptions.Key.create("storage-metrics-context");

  private static final long HTTP_STATUS_OK = 200L;
  private static final long HTTP_STATUS_UNSET = 0L;

  @Nullable private final StorageClientMetrics metrics;
  private final String operationName;
  private final ApiClock clock;
  private final long startTimeNanos;
  private final Context otelContext;
  private final Attributes baseAttributes;
  private final boolean recordOperationOnRetrierExit;
  private final AtomicBoolean operationRecorded = new AtomicBoolean(false);
  private final AtomicInteger attemptCount = new AtomicInteger(0);
  private final AtomicLong requestBytes = new AtomicLong(0L);
  private final AtomicLong responseBytes = new AtomicLong(0L);

  private StorageMetricsContext(
      @Nullable StorageClientMetrics metrics,
      String operationName,
      Attributes baseAttributes,
      ApiClock clock,
      long startTimeNanos,
      Context otelContext,
      boolean recordOperationOnRetrierExit) {
    this.metrics = metrics;
    this.operationName = requireNonNull(operationName, "operationName cannot be null");
    this.baseAttributes = requireNonNull(baseAttributes, "baseAttributes cannot be null");
    this.clock = requireNonNull(clock, "clock cannot be null");
    this.startTimeNanos = startTimeNanos;
    this.otelContext = requireNonNull(otelContext, "otelContext cannot be null");
    this.recordOperationOnRetrierExit = recordOperationOnRetrierExit;
  }

  static StorageMetricsContext create(
      String operationName, Attributes baseAttributes, long startTimeNanos) {
    return new StorageMetricsContext(
        null,
        operationName,
        baseAttributes,
        NanoClock.getDefaultClock(),
        startTimeNanos,
        Context.current(),
        true);
  }

  static StorageMetricsContext create(String operationName) {
    return create(operationName, Attributes.empty());
  }

  static StorageMetricsContext create(String operationName, Attributes baseAttributes) {
    return create(operationName, baseAttributes, Context.current());
  }

  static StorageMetricsContext create(
      String operationName, Attributes baseAttributes, Context otelContext) {
    return create(null, operationName, baseAttributes, otelContext, NanoClock.getDefaultClock());
  }

  static StorageMetricsContext create(
      String operationName, Attributes baseAttributes, Context otelContext, ApiClock clock) {
    return create(null, operationName, baseAttributes, otelContext, clock);
  }

  static StorageMetricsContext create(
      @Nullable StorageClientMetrics metrics, String operationName, Attributes baseAttributes) {
    return create(
        metrics, operationName, baseAttributes, Context.current(), NanoClock.getDefaultClock());
  }

  static StorageMetricsContext create(
      @Nullable StorageClientMetrics metrics,
      String operationName,
      Attributes baseAttributes,
      ApiClock clock) {
    return create(metrics, operationName, baseAttributes, Context.current(), clock);
  }

  static StorageMetricsContext create(
      @Nullable StorageClientMetrics metrics,
      String operationName,
      Attributes baseAttributes,
      Context otelContext,
      ApiClock clock) {
    requireNonNull(clock, "clock cannot be null");
    return new StorageMetricsContext(
        metrics, operationName, baseAttributes, clock, clock.nanoTime(), otelContext, true);
  }

  static StorageMetricsContext createForMultiStep(String operationName) {
    return createForMultiStep(operationName, Attributes.empty());
  }

  static StorageMetricsContext createForMultiStep(String operationName, Attributes baseAttributes) {
    return createForMultiStep(operationName, baseAttributes, Context.current());
  }

  static StorageMetricsContext createForMultiStep(
      String operationName, Attributes baseAttributes, Context otelContext) {
    return createForMultiStep(
        null, operationName, baseAttributes, otelContext, NanoClock.getDefaultClock());
  }

  static StorageMetricsContext createForMultiStep(
      String operationName, Attributes baseAttributes, Context otelContext, ApiClock clock) {
    return createForMultiStep(null, operationName, baseAttributes, otelContext, clock);
  }

  static StorageMetricsContext createForMultiStep(
      @Nullable StorageClientMetrics metrics, String operationName, Attributes baseAttributes) {
    return createForMultiStep(
        metrics, operationName, baseAttributes, Context.current(), NanoClock.getDefaultClock());
  }

  static StorageMetricsContext createForMultiStep(
      @Nullable StorageClientMetrics metrics,
      String operationName,
      Attributes baseAttributes,
      ApiClock clock) {
    return createForMultiStep(metrics, operationName, baseAttributes, Context.current(), clock);
  }

  static StorageMetricsContext createForMultiStep(
      @Nullable StorageClientMetrics metrics,
      String operationName,
      Attributes baseAttributes,
      Context otelContext,
      ApiClock clock) {
    requireNonNull(clock, "clock cannot be null");
    return new StorageMetricsContext(
        metrics, operationName, baseAttributes, clock, clock.nanoTime(), otelContext, false);
  }

  boolean shouldRecordOperationOnRetrierExit() {
    return recordOperationOnRetrierExit;
  }

  void recordOperation(@Nullable Throwable terminalThrowable) {
    recordOperation(this.metrics, terminalThrowable);
  }

  void recordOperation(
      @Nullable StorageClientMetrics metrics, @Nullable Throwable terminalThrowable) {
    if (metrics == null || !operationRecorded.compareAndSet(false, true)) {
      return;
    }
    try (Scope ignore = otelContext.makeCurrent()) {
      String terminalErrorType = StorageErrorTypeMapper.mapThrowable(terminalThrowable);
      String clientMethod = baseAttributes.get(StorageClientMetrics.KEY_GCP_CLIENT_METHOD);
      if (clientMethod == null || clientMethod.isEmpty()) {
        clientMethod = operationName;
      }

      Attributes operationAttributes =
          buildAttemptBaseAttributes(metrics).toBuilder()
              .put(StorageClientMetrics.KEY_GCP_CLIENT_METHOD, clientMethod)
              .put(StorageClientMetrics.KEY_ERROR_TYPE, terminalErrorType)
              .build();

      if (metrics.getOperations() != null) {
        metrics.getOperations().add(1, operationAttributes);
      }

      if (metrics.getGcpClientRequestDuration() != null) {
        String rpcMethod = baseAttributes.get(StorageClientMetrics.KEY_RPC_METHOD);
        if (rpcMethod == null || !rpcMethod.contains("/")) {
          rpcMethod = "google.storage.v2.Storage/" + operationName;
        }
        Attributes durationAttributes =
            operationAttributes.toBuilder()
                .put(StorageClientMetrics.KEY_RPC_METHOD, rpcMethod)
                .build();
        metrics.getGcpClientRequestDuration().record(getElapsedSeconds(), durationAttributes);
      }
    }
  }

  void recordAttemptSuccess() {
    recordAttemptSuccess(this.metrics);
  }

  void recordAttemptSuccess(@Nullable StorageClientMetrics metrics) {
    if (metrics == null || metrics.getAttempts() == null) {
      return;
    }
    try (Scope ignore = otelContext.makeCurrent()) {
      Attributes attemptBase = buildAttemptBaseAttributes(metrics);
      AttributesBuilder builder =
          attemptBase.toBuilder()
              .put(StorageClientMetrics.KEY_ERROR_TYPE, StorageErrorTypeMapper.STATUS_OK)
              .put(StorageClientMetrics.KEY_NETWORK_PATH, resolveNetworkPath());
      putAttemptStatusCodes(builder, null, StorageErrorTypeMapper.STATUS_OK, HTTP_STATUS_OK);
      metrics.getAttempts().add(1, builder.build());
    }
  }

  void recordAttemptFailure(Throwable e) {
    recordAttemptFailure(this.metrics, e);
  }

  void recordAttemptFailure(@Nullable StorageClientMetrics metrics, Throwable e) {
    if (metrics == null) {
      return;
    }
    try (Scope ignore = otelContext.makeCurrent()) {
      String errorType = StorageErrorTypeMapper.mapThrowable(e);
      String networkPath = resolveNetworkPath();
      Attributes attemptBase = buildAttemptBaseAttributes(metrics);
      if (metrics.getErrors() != null) {
        Attributes errorAttributes =
            attemptBase.toBuilder()
                .put(StorageClientMetrics.KEY_ERROR_TYPE, errorType)
                .put(StorageClientMetrics.KEY_NETWORK_PATH, networkPath)
                .build();
        metrics.getErrors().add(1, errorAttributes);
      }
      if (metrics.getAttempts() != null) {
        AttributesBuilder builder =
            attemptBase.toBuilder()
                .put(StorageClientMetrics.KEY_ERROR_TYPE, errorType)
                .put(StorageClientMetrics.KEY_NETWORK_PATH, networkPath);
        putAttemptStatusCodes(builder, e, StorageErrorTypeMapper.STATUS_UNKNOWN, HTTP_STATUS_UNSET);
        metrics.getAttempts().add(1, builder.build());
      }
    }
  }

  /**
   * Populates both {@code rpc.response.status_code} and {@code http.response.status_code} on
   * attempt metrics so every {@code gcp.storage.client.attempts} data point emits a consistent set
   * of attribute keys for {@code GoogleCloudMetricExporter} ({@code SEND_ONCE}). Uses {@code 0L}
   * ({@link #HTTP_STATUS_UNSET}) when no HTTP response was received or for gRPC attempts, matching
   * the Go SDK's {@code attribute.Int64("http.response.status_code", 0)} convention.
   */
  private void putAttemptStatusCodes(
      AttributesBuilder builder,
      @Nullable Throwable error,
      String defaultGrpcStatus,
      long defaultHttpStatus) {
    String rpcSystemName = baseAttributes.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME);
    if ("grpc".equals(rpcSystemName)) {
      String rpcStatus = extractRpcStatusCode(error);
      builder.put(
          StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE,
          rpcStatus != null ? rpcStatus : defaultGrpcStatus);
      builder.put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, HTTP_STATUS_UNSET);
    } else if ("http".equals(rpcSystemName)) {
      Long httpStatus = extractHttpStatusCode(error);
      builder.put(
          StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE,
          httpStatus != null ? httpStatus : defaultHttpStatus);
      builder.put(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, "");
    } else {
      String rpcStatus = extractRpcStatusCode(error);
      Long httpStatus = extractHttpStatusCode(error);
      builder.put(
          StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, rpcStatus != null ? rpcStatus : "");
      builder.put(
          StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE,
          httpStatus != null ? httpStatus : HTTP_STATUS_UNSET);
    }
  }

  private Attributes buildAttemptBaseAttributes(StorageClientMetrics metrics) {
    AttributesBuilder baseBuilder = Attributes.builder();
    baseBuilder.putAll(metrics.getClientAttributes());
    baseAttributes.forEach(
        (key, val) -> {
          if (!key.equals(StorageClientMetrics.KEY_RPC_METHOD)
              && !key.equals(StorageClientMetrics.KEY_GCP_CLIENT_METHOD)
              && !key.equals(StorageClientMetrics.KEY_NETWORK_PATH)
              && !key.equals(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE)
              && !key.equals(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)) {
            @SuppressWarnings("unchecked")
            AttributeKey<Object> objKey = (AttributeKey<Object>) key;
            baseBuilder.put(objKey, val);
          }
        });
    baseBuilder.put(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION, operationName);
    return baseBuilder.build();
  }

  private String resolveNetworkPath() {
    String path = baseAttributes.get(StorageClientMetrics.KEY_NETWORK_PATH);
    if (path != null && !path.isEmpty()) {
      return path;
    }
    return StorageClientMetrics.NETWORK_PATH_CLOUDPATH;
  }

  private @Nullable String extractRpcStatusCode(@Nullable Throwable e) {
    String fromContext = baseAttributes.get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE);
    return fromContext != null ? fromContext : StorageErrorTypeMapper.extractRpcStatusCode(e);
  }

  private @Nullable Long extractHttpStatusCode(@Nullable Throwable e) {
    Long fromContext = baseAttributes.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE);
    return fromContext != null ? fromContext : StorageErrorTypeMapper.extractHttpStatusCode(e);
  }

  static @Nullable StorageMetricsContext from(@Nullable CallOptions callOptions) {
    return callOptions != null ? callOptions.getOption(GRPC_CALL_OPTIONS_KEY) : null;
  }

  static @Nullable StorageMetricsContext from(@Nullable GrpcCallContext context) {
    return context != null ? from(context.getCallOptions()) : null;
  }

  CallOptions attach(@Nullable CallOptions callOptions) {
    CallOptions options = callOptions != null ? callOptions : CallOptions.DEFAULT;
    return options.withOption(GRPC_CALL_OPTIONS_KEY, this);
  }

  GrpcCallContext attach(@Nullable GrpcCallContext context) {
    GrpcCallContext callContext = context != null ? context : GrpcCallContext.createDefault();
    return callContext.withCallOptions(attach(callContext.getCallOptions()));
  }

  int incrementAttempts() {
    return attemptCount.incrementAndGet();
  }

  int getAttemptCount() {
    return attemptCount.get();
  }

  long addRequestBytes(long bytes) {
    return requestBytes.addAndGet(bytes);
  }

  long getRequestBytes() {
    return requestBytes.get();
  }

  long addResponseBytes(long bytes) {
    return responseBytes.addAndGet(bytes);
  }

  long getResponseBytes() {
    return responseBytes.get();
  }

  @Nullable StorageClientMetrics getMetrics() {
    return metrics;
  }

  String getOperationName() {
    return operationName;
  }

  long getStartTimeNanos() {
    return startTimeNanos;
  }

  Context getOtelContext() {
    return otelContext;
  }

  double getElapsedSeconds() {
    return getElapsedSeconds(clock.nanoTime());
  }

  double getElapsedSeconds(long currentTimeNanos) {
    return (currentTimeNanos - startTimeNanos) / 1_000_000_000.0;
  }

  Attributes getBaseAttributes() {
    return baseAttributes;
  }
}
