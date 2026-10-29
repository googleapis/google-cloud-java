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

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.httpjson.HttpJsonStatusCode;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import io.grpc.CallOptions;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import java.util.Map;
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
  static final ApiCallContext.Key<StorageMetricsContext> API_CALL_CONTEXT_KEY =
      ApiCallContext.Key.create("storage-metrics-context");
  static final String HTTP_REQUEST_PROPERTY_KEY = "com.google.cloud.storage.StorageMetricsContext";

  private final String operationName;
  private final long startTimeNanos;
  private final Context otelContext;
  private final AtomicInteger attemptCount;
  private final AtomicLong requestBytes;
  private final AtomicLong responseBytes;
  private final Attributes baseAttributes;
  private final boolean recordOperationOnRetrierExit;
  private final AtomicBoolean operationRecorded;

  private StorageMetricsContext(
      String operationName,
      Attributes baseAttributes,
      long startTimeNanos,
      Context otelContext,
      boolean recordOperationOnRetrierExit,
      AtomicBoolean operationRecorded,
      AtomicInteger attemptCount,
      AtomicLong requestBytes,
      AtomicLong responseBytes) {
    this.operationName = requireNonNull(operationName, "operationName cannot be null");
    this.baseAttributes = requireNonNull(baseAttributes, "baseAttributes cannot be null");
    this.otelContext = requireNonNull(otelContext, "otelContext cannot be null");
    this.startTimeNanos = startTimeNanos;
    this.recordOperationOnRetrierExit = recordOperationOnRetrierExit;
    this.operationRecorded = requireNonNull(operationRecorded, "operationRecorded cannot be null");
    this.attemptCount = requireNonNull(attemptCount, "attemptCount cannot be null");
    this.requestBytes = requireNonNull(requestBytes, "requestBytes cannot be null");
    this.responseBytes = requireNonNull(responseBytes, "responseBytes cannot be null");
  }

  static StorageMetricsContext create(
      String operationName, Attributes baseAttributes, long startTimeNanos) {
    return new StorageMetricsContext(
        operationName,
        baseAttributes,
        startTimeNanos,
        Context.current(),
        true,
        new AtomicBoolean(false),
        new AtomicInteger(0),
        new AtomicLong(0L),
        new AtomicLong(0L));
  }

  static StorageMetricsContext create(String operationName) {
    return create(operationName, Attributes.empty());
  }

  static StorageMetricsContext create(String operationName, Attributes baseAttributes) {
    return create(operationName, baseAttributes, Context.current());
  }

  static StorageMetricsContext create(
      String operationName, Attributes baseAttributes, Context otelContext) {
    return new StorageMetricsContext(
        operationName,
        baseAttributes,
        System.nanoTime(),
        otelContext,
        true,
        new AtomicBoolean(false),
        new AtomicInteger(0),
        new AtomicLong(0L),
        new AtomicLong(0L));
  }

  static StorageMetricsContext createForMultiStep(String operationName) {
    return createForMultiStep(operationName, Attributes.empty());
  }

  static StorageMetricsContext createForMultiStep(String operationName, Attributes baseAttributes) {
    return createForMultiStep(operationName, baseAttributes, Context.current());
  }

  static StorageMetricsContext createForMultiStep(
      String operationName, Attributes baseAttributes, Context otelContext) {
    return new StorageMetricsContext(
        operationName,
        baseAttributes,
        System.nanoTime(),
        otelContext,
        false,
        new AtomicBoolean(false),
        new AtomicInteger(0),
        new AtomicLong(0L),
        new AtomicLong(0L));
  }

  boolean shouldRecordOperationOnRetrierExit() {
    return recordOperationOnRetrierExit;
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

      AttributesBuilder opAttrBuilder = Attributes.builder();
      opAttrBuilder.putAll(metrics.getClientAttributes());
      baseAttributes.forEach(
          (key, val) -> {
            if (!key.equals(StorageClientMetrics.KEY_RPC_METHOD)
                && !key.equals(StorageClientMetrics.KEY_NETWORK_PATH)
                && !key.equals(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE)
                && !key.equals(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)) {
              @SuppressWarnings("unchecked")
              AttributeKey<Object> objKey = (AttributeKey<Object>) key;
              opAttrBuilder.put(objKey, val);
            }
          });
      opAttrBuilder.put(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION, operationName);
      opAttrBuilder.put(StorageClientMetrics.KEY_GCP_CLIENT_METHOD, clientMethod);
      opAttrBuilder.put(StorageClientMetrics.KEY_ERROR_TYPE, terminalErrorType);
      Attributes operationAttributes = opAttrBuilder.build();

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
      String rpcSystemName = baseAttributes.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME);
      if ("grpc".equals(rpcSystemName)) {
        String rpcCode = baseAttributes.get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE);
        builder.put(
            StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, rpcCode != null ? rpcCode : "OK");
        builder.put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, "");
      } else if ("http".equals(rpcSystemName)) {
        String httpCode = baseAttributes.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE);
        builder.put(
            StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE,
            httpCode != null ? httpCode : "200");
        builder.put(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, "");
      } else {
        String rpcCode = baseAttributes.get(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE);
        String httpCode = baseAttributes.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE);
        builder.put(
            StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, rpcCode != null ? rpcCode : "");
        builder.put(
            StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, httpCode != null ? httpCode : "");
      }
      metrics.getAttempts().add(1, builder.build());
    }
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
        String rpcSystemName = baseAttributes.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME);
        if ("grpc".equals(rpcSystemName)) {
          String rpcStatus = extractRpcStatusCode(e);
          builder.put(
              StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE,
              rpcStatus != null ? rpcStatus : "");
          builder.put(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE, "");
        } else if ("http".equals(rpcSystemName)) {
          String httpStatus = extractHttpStatusCode(e);
          builder.put(
              StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE,
              httpStatus != null ? httpStatus : "");
          builder.put(StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE, "");
        } else {
          String rpcStatus = extractRpcStatusCode(e);
          String httpStatus = extractHttpStatusCode(e);
          builder.put(
              StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE,
              rpcStatus != null ? rpcStatus : "");
          builder.put(
              StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE,
              httpStatus != null ? httpStatus : "");
        }
        metrics.getAttempts().add(1, builder.build());
      }
    }
  }

  private Attributes buildAttemptBaseAttributes(StorageClientMetrics metrics) {
    AttributesBuilder baseBuilder = Attributes.builder();
    baseBuilder.putAll(metrics.getClientAttributes());
    baseAttributes.forEach(
        (key, val) -> {
          if (!key.equals(StorageClientMetrics.KEY_RPC_METHOD)
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
    if (fromContext != null) {
      return fromContext;
    }
    Throwable curr = e;
    while (curr != null && curr.getCause() != curr) {
      if (curr instanceof io.grpc.StatusRuntimeException) {
        return ((io.grpc.StatusRuntimeException) curr).getStatus().getCode().name();
      }
      if (curr instanceof io.grpc.StatusException) {
        return ((io.grpc.StatusException) curr).getStatus().getCode().name();
      }
      if (curr instanceof ApiException) {
        return ((ApiException) curr).getStatusCode().getCode().name();
      }
      curr = curr.getCause();
    }
    return null;
  }

  private @Nullable String extractHttpStatusCode(@Nullable Throwable e) {
    String fromContext = baseAttributes.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE);
    if (fromContext != null) {
      return fromContext;
    }
    Throwable curr = e;
    while (curr != null && curr.getCause() != curr) {
      if (curr instanceof StorageException) {
        int code = ((StorageException) curr).getCode();
        if (code > 0) {
          return Integer.toString(code);
        }
      }
      if (curr instanceof com.google.api.client.http.HttpResponseException) {
        int code = ((com.google.api.client.http.HttpResponseException) curr).getStatusCode();
        if (code > 0) {
          return Integer.toString(code);
        }
      }
      if (curr instanceof ApiException) {
        ApiException apiException = (ApiException) curr;
        if (apiException.getStatusCode() instanceof HttpJsonStatusCode) {
          int code =
              ((HttpJsonStatusCode) apiException.getStatusCode()).getCode().getHttpStatusCode();
          if (code > 0) {
            return Integer.toString(code);
          }
        }
      }
      curr = curr.getCause();
    }
    return null;
  }

  static @Nullable StorageMetricsContext from(@Nullable CallOptions callOptions) {
    return callOptions != null ? callOptions.getOption(GRPC_CALL_OPTIONS_KEY) : null;
  }

  static @Nullable StorageMetricsContext from(@Nullable GrpcCallContext context) {
    if (context == null) {
      return null;
    }
    StorageMetricsContext result = context.getOption(API_CALL_CONTEXT_KEY);
    if (result != null) {
      return result;
    }
    return from(context.getCallOptions());
  }

  static @Nullable StorageMetricsContext from(@Nullable ApiCallContext context) {
    if (context == null) {
      return null;
    }
    if (context instanceof GrpcCallContext) {
      return from((GrpcCallContext) context);
    }
    return context.getOption(API_CALL_CONTEXT_KEY);
  }

  static @Nullable StorageMetricsContext from(@Nullable Map<String, Object> properties) {
    if (properties == null) {
      return null;
    }
    Object obj = properties.get(HTTP_REQUEST_PROPERTY_KEY);
    return (obj instanceof StorageMetricsContext) ? (StorageMetricsContext) obj : null;
  }

  CallOptions attach(@Nullable CallOptions callOptions) {
    CallOptions options = callOptions != null ? callOptions : CallOptions.DEFAULT;
    return options.withOption(GRPC_CALL_OPTIONS_KEY, this);
  }

  GrpcCallContext attach(@Nullable GrpcCallContext context) {
    GrpcCallContext callContext = context != null ? context : GrpcCallContext.createDefault();
    return callContext
        .withCallOptions(attach(callContext.getCallOptions()))
        .withOption(API_CALL_CONTEXT_KEY, this);
  }

  @Nullable ApiCallContext attach(@Nullable ApiCallContext context) {
    if (context == null) {
      return null;
    }
    if (context instanceof GrpcCallContext) {
      return attach((GrpcCallContext) context);
    }
    return context.withOption(API_CALL_CONTEXT_KEY, this);
  }

  @Nullable Map<String, Object> attach(@Nullable Map<String, Object> properties) {
    if (properties != null) {
      properties.put(HTTP_REQUEST_PROPERTY_KEY, this);
    }
    return properties;
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
    return getElapsedSeconds(System.nanoTime());
  }

  double getElapsedSeconds(long currentTimeNanos) {
    return (currentTimeNanos - startTimeNanos) / 1_000_000_000.0;
  }

  Attributes getBaseAttributes() {
    return baseAttributes;
  }

  AttributesBuilder attributesBuilder() {
    return baseAttributes.toBuilder();
  }
}
