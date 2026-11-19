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

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.api.metrics.LongUpDownCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.qual.Nullable;

/** Package-private instrument registry for OpenTelemetry client metrics. */
final class StorageClientMetrics implements AutoCloseable {
  private static final Logger LOGGER = Logger.getLogger(StorageClientMetrics.class.getName());
  static final String METER_NAME = "com.google.cloud.storage";

  // Standard client attribute keys and values
  static final AttributeKey<String> KEY_GCP_CLIENT_VERSION =
      AttributeKey.stringKey("gcp.client.version");
  static final AttributeKey<String> KEY_GCP_CLIENT_SERVICE =
      AttributeKey.stringKey("gcp.client.service");
  static final AttributeKey<String> KEY_GCP_CLIENT_ARTIFACT =
      AttributeKey.stringKey("gcp.client.artifact");

  static final AttributeKey<String> KEY_GCP_STORAGE_OPERATION =
      AttributeKey.stringKey("gcp.storage.operation");
  static final AttributeKey<String> KEY_GCP_CLIENT_METHOD =
      AttributeKey.stringKey("gcp.client.method");
  static final AttributeKey<String> KEY_RPC_METHOD = AttributeKey.stringKey("rpc.method");
  static final AttributeKey<String> KEY_RPC_SYSTEM_NAME = AttributeKey.stringKey("rpc.system.name");
  static final AttributeKey<String> KEY_RPC_RESPONSE_STATUS_CODE =
      AttributeKey.stringKey("rpc.response.status_code");
  static final AttributeKey<String> KEY_HTTP_REQUEST_METHOD =
      AttributeKey.stringKey("http.request.method");
  static final AttributeKey<Long> KEY_HTTP_RESPONSE_STATUS_CODE =
      AttributeKey.longKey("http.response.status_code");
  static final AttributeKey<String> KEY_URL_TEMPLATE = AttributeKey.stringKey("url.template");
  static final AttributeKey<String> KEY_SERVER_ADDRESS = AttributeKey.stringKey("server.address");
  static final AttributeKey<String> KEY_ERROR_TYPE = AttributeKey.stringKey("error.type");
  static final AttributeKey<String> KEY_NETWORK_PATH = AttributeKey.stringKey("network.path");
  static final AttributeKey<String> KEY_NETWORK_IO_DIRECTION =
      AttributeKey.stringKey("network.io.direction");

  static final String NETWORK_PATH_DIRECTPATH = "directpath";
  static final String NETWORK_PATH_CLOUDPATH = "cloudpath";
  static final String NETWORK_PATH_UNKNOWN = "unknown";

  static final String NETWORK_IO_DIRECTION_RECEIVE = "receive";
  static final String NETWORK_IO_DIRECTION_TRANSMIT = "transmit";

  static final String SERVICE_STORAGE = "storage";
  static final String ARTIFACT_STORAGE = "com.google.cloud:google-cloud-storage";

  // Standard metric names
  static final String METRIC_RPC_CLIENT_CALL_DURATION = "rpc.client.call.duration";
  static final String METRIC_HTTP_CLIENT_REQUEST_DURATION = "http.client.request.duration";
  static final String METRIC_GCP_CLIENT_REQUEST_DURATION = "gcp.client.request.duration";
  static final String METRIC_GCP_STORAGE_CLIENT_OPERATIONS = "gcp.storage.client.operations";
  static final String METRIC_GCP_STORAGE_CLIENT_ATTEMPTS = "gcp.storage.client.attempts";
  static final String METRIC_GCP_STORAGE_CLIENT_RETRIES = "gcp.storage.client.retries";
  static final String METRIC_GCP_STORAGE_CLIENT_ERRORS = "gcp.storage.client.errors";
  static final String METRIC_GCP_STORAGE_CLIENT_TTFB = "gcp.storage.client.ttfb";
  static final String METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE =
      "gcp.storage.client.request.body.size";
  static final String METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE =
      "gcp.storage.client.response.body.size";
  static final String METRIC_GCP_STORAGE_CLIENT_SERVER_UNREACHED =
      "gcp.storage.client.server.unreached";

  // Debug metric names
  static final String METRIC_GCP_STORAGE_CLIENT_REQUEST_ACTIVE =
      "gcp.storage.client.request.active";
  static final String METRIC_GCP_STORAGE_CLIENT_SERVER_DURATION =
      "gcp.storage.client.server.duration";
  static final String METRIC_GCP_STORAGE_CLIENT_STALL_DURATION =
      "gcp.storage.client.stall.duration";
  static final String METRIC_GCP_STORAGE_CLIENT_NETWORK_IO = "gcp.storage.client.network.io";
  static final String METRIC_GCP_STORAGE_CLIENT_AUTH_CREDENTIAL_REFRESH_DURATION =
      "gcp.storage.client.auth.credential_refresh.duration";

  @Nullable
  static StorageClientMetrics fromOptions(StorageOptions options) {
    if (!options.isEnableOtelMetrics()) {
      return null;
    }
    MeterProvider mp = options.getMeterProvider();
    if (mp == null && options.isCustomOpenTelemetryConfigured()) {
      OpenTelemetry otel = options.getOpenTelemetry();
      if (otel != null) {
        mp = otel.getMeterProvider();
      }
    }
    SdkMeterProvider ownedMeterProvider = null;
    if (mp == null) {
      ownedMeterProvider =
          OpenTelemetryBootstrappingUtils.createDefaultClientMeterProvider(
              options.getHost(),
              options.getProjectId(),
              options.getUniverseDomain(),
              options.getMetricInterval(),
              options instanceof GrpcStorageOptions ? "grpc" : "json");
      mp = ownedMeterProvider;
    }
    if (mp == null) {
      return null;
    }
    Meter meter =
        mp.meterBuilder(METER_NAME).setInstrumentationVersion(StorageOptions.version()).build();
    Attributes clientAttributes =
        Attributes.builder()
            .put(KEY_GCP_CLIENT_SERVICE, SERVICE_STORAGE)
            .put(KEY_GCP_CLIENT_VERSION, StorageOptions.version())
            .put(KEY_GCP_CLIENT_ARTIFACT, ARTIFACT_STORAGE)
            .build();
    AttributesBuilder baseBuilder =
        clientAttributes.toBuilder()
            .put(KEY_RPC_SYSTEM_NAME, options instanceof GrpcStorageOptions ? "grpc" : "http");
    String serverAddress = OpenTelemetryBootstrappingUtils.extractServerAddress(options.getHost());
    if (serverAddress != null && !serverAddress.isEmpty()) {
      baseBuilder.put(KEY_SERVER_ADDRESS, serverAddress);
    }
    return new StorageClientMetrics(
        meter,
        clientAttributes,
        baseBuilder.build(),
        ownedMeterProvider,
        /* enableOtelMetrics= */ true,
        options.isEnableOtelDebugMetrics());
  }

  static StorageClientMetrics create(
      MeterProvider meterProvider, boolean enableOtelMetrics, boolean enableOtelDebugMetrics) {
    return create(
        meterProvider, (SdkMeterProvider) null, enableOtelMetrics, enableOtelDebugMetrics);
  }

  static StorageClientMetrics create(
      MeterProvider meterProvider,
      @Nullable SdkMeterProvider ownedMeterProvider,
      boolean enableOtelMetrics,
      boolean enableOtelDebugMetrics) {
    Meter meter =
        meterProvider
            .meterBuilder(METER_NAME)
            .setInstrumentationVersion(StorageOptions.version())
            .build();
    Attributes clientAttributes =
        Attributes.builder()
            .put(KEY_GCP_CLIENT_SERVICE, SERVICE_STORAGE)
            .put(KEY_GCP_CLIENT_VERSION, StorageOptions.version())
            .put(KEY_GCP_CLIENT_ARTIFACT, ARTIFACT_STORAGE)
            .build();
    return new StorageClientMetrics(
        meter,
        clientAttributes,
        clientAttributes,
        ownedMeterProvider,
        enableOtelMetrics,
        enableOtelDebugMetrics);
  }

  @Nullable private final DoubleHistogram rpcClientCallDuration;
  @Nullable private final DoubleHistogram httpClientRequestDuration;
  @Nullable private final DoubleHistogram gcpClientRequestDuration;
  @Nullable private final LongCounter operations;
  @Nullable private final LongCounter attempts;
  @Nullable private final LongCounter retries;
  @Nullable private final LongCounter errors;
  @Nullable private final DoubleHistogram ttfb;
  @Nullable private final LongHistogram requestBodySize;
  @Nullable private final LongHistogram responseBodySize;
  @Nullable private final LongCounter serverUnreached;

  @Nullable private final LongUpDownCounter requestActive;
  @Nullable private final DoubleHistogram serverDuration;
  @Nullable private final DoubleHistogram stallDuration;
  @Nullable private final LongCounter networkIo;
  @Nullable private final DoubleHistogram credentialRefreshDuration;

  private final Attributes clientAttributes;
  private final Attributes baseAttributes;
  @Nullable private final SdkMeterProvider ownedMeterProvider;

  private StorageClientMetrics(
      Meter meter,
      Attributes clientAttributes,
      Attributes baseAttributes,
      @Nullable SdkMeterProvider ownedMeterProvider,
      boolean enableOtelMetrics,
      boolean enableOtelDebugMetrics) {
    this.clientAttributes = clientAttributes;
    this.baseAttributes = baseAttributes;
    this.ownedMeterProvider = ownedMeterProvider;

    if (enableOtelMetrics) {
      this.rpcClientCallDuration =
          meter
              .histogramBuilder(METRIC_RPC_CLIENT_CALL_DURATION)
              .setDescription("Duration of a single gRPC client call attempt to Cloud Storage.")
              .setUnit("s")
              .setExplicitBucketBoundariesAdvice(
                  OpenTelemetryBootstrappingUtils.latencyHistogramBoundaries())
              .build();
      this.httpClientRequestDuration =
          meter
              .histogramBuilder(METRIC_HTTP_CLIENT_REQUEST_DURATION)
              .setDescription("Duration of a single HTTP request attempt to Cloud Storage.")
              .setUnit("s")
              .setExplicitBucketBoundariesAdvice(
                  OpenTelemetryBootstrappingUtils.latencyHistogramBoundaries())
              .build();
      this.gcpClientRequestDuration =
          meter
              .histogramBuilder(METRIC_GCP_CLIENT_REQUEST_DURATION)
              .setDescription("Latency of a client operation, including all retries.")
              .setUnit("s")
              .setExplicitBucketBoundariesAdvice(
                  OpenTelemetryBootstrappingUtils.latencyHistogramBoundaries())
              .build();
      this.operations =
          meter
              .counterBuilder(METRIC_GCP_STORAGE_CLIENT_OPERATIONS)
              .setDescription("Number of GCS client operations")
              .setUnit("{operation}")
              .build();
      this.attempts =
          meter
              .counterBuilder(METRIC_GCP_STORAGE_CLIENT_ATTEMPTS)
              .setDescription(
                  "Number of GCS client attempts (individual HTTP requests or gRPC calls),"
                      + " including retries, resumable upload chunks and list pages.")
              .setUnit("{attempt}")
              .build();
      this.retries =
          meter
              .counterBuilder(METRIC_GCP_STORAGE_CLIENT_RETRIES)
              .setDescription(
                  "Number of GCS client attempts that retried an earlier failed attempt of the same"
                      + " request.")
              .setUnit("{attempt}")
              .build();
      this.errors =
          meter
              .counterBuilder(METRIC_GCP_STORAGE_CLIENT_ERRORS)
              .setDescription("Number of failed GCS client attempts, by error.type.")
              .setUnit("{error}")
              .build();
      this.ttfb =
          meter
              .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_TTFB)
              .setDescription(
                  "Time from the start of an attempt until the first byte of the response was"
                      + " received. Not recorded for attempts that received no response.")
              .setUnit("s")
              .setExplicitBucketBoundariesAdvice(
                  OpenTelemetryBootstrappingUtils.latencyHistogramBoundaries())
              .build();
      this.requestBodySize =
          meter
              .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE)
              .ofLongs()
              .setDescription(
                  "Number of object bytes written by an upload operation (recorded once per"
                      + " operation, including empty objects).")
              .setUnit("By")
              .setExplicitBucketBoundariesAdvice(
                  OpenTelemetryBootstrappingUtils.sizeHistogramLongBoundaries())
              .build();
      this.responseBodySize =
          meter
              .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE)
              .ofLongs()
              .setDescription(
                  "Number of object bytes delivered to the application by a download operation"
                      + " (recorded once per operation).")
              .setUnit("By")
              .setExplicitBucketBoundariesAdvice(
                  OpenTelemetryBootstrappingUtils.sizeHistogramLongBoundaries())
              .build();
      this.serverUnreached =
          meter
              .counterBuilder(METRIC_GCP_STORAGE_CLIENT_SERVER_UNREACHED)
              .setDescription("Count of requests that failed before reaching the GCS server.")
              .setUnit("{request}")
              .build();
    } else {
      this.rpcClientCallDuration = null;
      this.httpClientRequestDuration = null;
      this.gcpClientRequestDuration = null;
      this.operations = null;
      this.attempts = null;
      this.retries = null;
      this.errors = null;
      this.ttfb = null;
      this.requestBodySize = null;
      this.responseBodySize = null;
      this.serverUnreached = null;
    }

    if (enableOtelDebugMetrics) {
      this.requestActive =
          meter
              .upDownCounterBuilder(METRIC_GCP_STORAGE_CLIENT_REQUEST_ACTIVE)
              .setDescription("Number of active GCS client requests")
              .setUnit("{request}")
              .build();
      this.serverDuration =
          meter
              .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_SERVER_DURATION)
              .setDescription(
                  "Server elapsed processing time for gRPC requests, decoded from"
                      + " grpc-server-stats-bin response trailer (gRPC only).")
              .setUnit("s")
              .setExplicitBucketBoundariesAdvice(
                  OpenTelemetryBootstrappingUtils.latencyHistogramBoundaries())
              .build();
      this.stallDuration =
          meter
              .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_STALL_DURATION)
              .setDescription(
                  "Stall timeout after which a read attempt was aborted while waiting for the"
                      + " initial response.")
              .setUnit("s")
              .setExplicitBucketBoundariesAdvice(
                  OpenTelemetryBootstrappingUtils.latencyHistogramBoundaries())
              .build();
      this.networkIo =
          meter
              .counterBuilder(METRIC_GCP_STORAGE_CLIENT_NETWORK_IO)
              .setDescription(
                  "Bytes read from and written to the TCP connections to Cloud Storage, by"
                      + " network.io.direction (receive, transmit). gRPC only.")
              .setUnit("By")
              .build();
      this.credentialRefreshDuration =
          meter
              .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_AUTH_CREDENTIAL_REFRESH_DURATION)
              .setDescription(
                  "Time a request was blocked obtaining an access token. Tokens served from the"
                      + " credential cache are not recorded.")
              .setUnit("s")
              .setExplicitBucketBoundariesAdvice(
                  OpenTelemetryBootstrappingUtils.latencyHistogramBoundaries())
              .build();
    } else {
      this.requestActive = null;
      this.serverDuration = null;
      this.stallDuration = null;
      this.networkIo = null;
      this.credentialRefreshDuration = null;
    }
  }

  Attributes getClientAttributes() {
    return clientAttributes;
  }

  AttributesBuilder clientAttributesBuilder() {
    return clientAttributes.toBuilder();
  }

  Attributes attachClientAttributes(@Nullable Attributes other) {
    if (other == null || other.isEmpty()) {
      return clientAttributes;
    }
    return clientAttributes.toBuilder().putAll(other).build();
  }

  @Nullable DoubleHistogram getRpcClientCallDuration() {
    return rpcClientCallDuration;
  }

  @Nullable DoubleHistogram getHttpClientRequestDuration() {
    return httpClientRequestDuration;
  }

  @Nullable DoubleHistogram getGcpClientRequestDuration() {
    return gcpClientRequestDuration;
  }

  @Nullable LongCounter getOperations() {
    return operations;
  }

  @Nullable LongCounter getAttempts() {
    return attempts;
  }

  @Nullable LongCounter getRetries() {
    return retries;
  }

  @Nullable LongCounter getErrors() {
    return errors;
  }

  @Nullable DoubleHistogram getTtfb() {
    return ttfb;
  }

  @Nullable LongHistogram getRequestBodySize() {
    return requestBodySize;
  }

  @Nullable LongHistogram getResponseBodySize() {
    return responseBodySize;
  }

  @Nullable LongCounter getServerUnreached() {
    return serverUnreached;
  }

  @Nullable LongUpDownCounter getRequestActive() {
    return requestActive;
  }

  @Nullable DoubleHistogram getServerDuration() {
    return serverDuration;
  }

  @Nullable DoubleHistogram getStallDuration() {
    return stallDuration;
  }

  @Nullable LongCounter getNetworkIo() {
    return networkIo;
  }

  @Nullable DoubleHistogram getCredentialRefreshDuration() {
    return credentialRefreshDuration;
  }

  StorageMetricsContext createContext(String operationName) {
    return StorageMetricsContext.create(this, operationName, baseAttributes);
  }

  StorageMetricsContext createMultiStepContext(String operationName) {
    return StorageMetricsContext.createForMultiStep(this, operationName, baseAttributes);
  }

  void recordRpcCallDuration(
      Context otelContext,
      double durationSeconds,
      String rpcMethod,
      String statusCode,
      String networkPath,
      String errorType) {
    if (rpcClientCallDuration == null) {
      return;
    }
    Attributes attributes =
        baseAttributes.toBuilder()
            .put(KEY_RPC_METHOD, rpcMethod)
            .put(KEY_RPC_RESPONSE_STATUS_CODE, statusCode)
            .put(KEY_NETWORK_PATH, networkPath)
            .put(KEY_ERROR_TYPE, errorType)
            .build();
    rpcClientCallDuration.record(durationSeconds, attributes, otelContext);
  }

  void recordHttpRequestDuration(
      double durationSeconds,
      String httpMethod,
      long statusCode,
      String urlTemplate,
      String errorType) {
    if (httpClientRequestDuration == null) {
      return;
    }
    Attributes attributes =
        baseAttributes.toBuilder()
            .put(KEY_HTTP_REQUEST_METHOD, httpMethod)
            .put(KEY_HTTP_RESPONSE_STATUS_CODE, statusCode)
            .put(KEY_NETWORK_PATH, NETWORK_PATH_CLOUDPATH)
            .put(KEY_URL_TEMPLATE, urlTemplate)
            .put(KEY_ERROR_TYPE, errorType)
            .build();
    httpClientRequestDuration.record(durationSeconds, attributes, Context.current());
  }

  void recordTtfb(
      Context otelContext, String operationName, double ttfbSeconds, String networkPath) {
    if (ttfb == null) {
      return;
    }
    Attributes attributes =
        baseAttributes.toBuilder()
            .put(KEY_GCP_STORAGE_OPERATION, operationName)
            .put(KEY_NETWORK_PATH, networkPath)
            .build();
    ttfb.record(ttfbSeconds, attributes, otelContext);
  }

  void recordRetry(
      Context otelContext, String operationName, String networkPath, String errorType) {
    if (retries == null) {
      return;
    }
    Attributes attributes =
        baseAttributes.toBuilder()
            .put(KEY_GCP_STORAGE_OPERATION, operationName)
            .put(KEY_NETWORK_PATH, networkPath)
            .put(KEY_ERROR_TYPE, errorType)
            .build();
    retries.add(1L, attributes, otelContext);
  }

  void recordRequestActive(Context otelContext, String operationName, long delta) {
    if (requestActive == null) {
      return;
    }
    Attributes attributes =
        baseAttributes.toBuilder().put(KEY_GCP_STORAGE_OPERATION, operationName).build();
    requestActive.add(delta, attributes, otelContext);
  }

  void recordServerDuration(
      Context otelContext, double durationSeconds, String operationName, String networkPath) {
    if (serverDuration == null) {
      return;
    }
    Attributes attributes =
        baseAttributes.toBuilder()
            .put(KEY_GCP_STORAGE_OPERATION, operationName)
            .put(KEY_NETWORK_PATH, networkPath)
            .build();
    serverDuration.record(durationSeconds, attributes, otelContext);
  }

  void recordServerUnreached(
      Context otelContext, String operationName, String networkPath, String errorType) {
    if (serverUnreached == null) {
      return;
    }
    Attributes attributes =
        baseAttributes.toBuilder()
            .put(KEY_GCP_STORAGE_OPERATION, operationName)
            .put(KEY_NETWORK_PATH, networkPath)
            .put(KEY_ERROR_TYPE, errorType)
            .build();
    serverUnreached.add(1L, attributes, otelContext);
  }

  void recordNetworkIo(
      Context otelContext, String networkPath, long transmitBytes, long receiveBytes) {
    if (networkIo == null) {
      return;
    }
    if (transmitBytes > 0) {
      Attributes transmitAttributes =
          baseAttributes.toBuilder()
              .put(KEY_NETWORK_PATH, networkPath)
              .put(KEY_NETWORK_IO_DIRECTION, NETWORK_IO_DIRECTION_TRANSMIT)
              .build();
      networkIo.add(transmitBytes, transmitAttributes, otelContext);
    }
    if (receiveBytes > 0) {
      Attributes receiveAttributes =
          baseAttributes.toBuilder()
              .put(KEY_NETWORK_PATH, networkPath)
              .put(KEY_NETWORK_IO_DIRECTION, NETWORK_IO_DIRECTION_RECEIVE)
              .build();
      networkIo.add(receiveBytes, receiveAttributes, otelContext);
    }
  }

  @Nullable
  static StorageMetricsContext createContext(
      @Nullable StorageClientMetrics metrics, String operationName) {
    return metrics != null ? metrics.createContext(operationName) : null;
  }

  @Nullable
  static StorageMetricsContext createMultiStepContext(
      @Nullable StorageClientMetrics metrics, String operationName) {
    return metrics != null ? metrics.createMultiStepContext(operationName) : null;
  }

  @Override
  public void close() {
    if (ownedMeterProvider != null) {
      try {
        ownedMeterProvider.close();
      } catch (Exception e) {
        LOGGER.warning("Failed to close storageClientMetrics: " + e.getMessage());
      }
    }
  }
}
