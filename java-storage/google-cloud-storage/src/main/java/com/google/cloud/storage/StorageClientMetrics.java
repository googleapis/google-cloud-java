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

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.api.metrics.LongUpDownCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterProvider;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.Nullable;

/** Package-private instrument registry for OpenTelemetry client metrics. */
final class StorageClientMetrics {
  static final String METER_NAME = "com.google.cloud.storage";

  // Standard client attribute keys and values
  static final AttributeKey<String> KEY_GCP_CLIENT_VERSION =
      AttributeKey.stringKey("gcp.client.version");
  static final AttributeKey<String> KEY_GCP_CLIENT_SERVICE =
      AttributeKey.stringKey("gcp.client.service");
  static final AttributeKey<String> KEY_GCP_CLIENT_ARTIFACT =
      AttributeKey.stringKey("gcp.client.artifact");
  static final AttributeKey<String> KEY_GCP_CLIENT_INSTANCE_ID =
      AttributeKey.stringKey("gcp.client.instance_id");

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
  static final AttributeKey<Long> KEY_SERVER_PORT = AttributeKey.longKey("server.port");
  static final AttributeKey<String> KEY_ERROR_TYPE = AttributeKey.stringKey("error.type");
  static final AttributeKey<String> KEY_NETWORK_PATH = AttributeKey.stringKey("network.path");
  static final AttributeKey<String> KEY_NETWORK_IO_DIRECTION =
      AttributeKey.stringKey("network.io.direction");

  static final String NETWORK_PATH_DIRECTPATH = "directpath";
  static final String NETWORK_PATH_CLOUDPATH = "cloudpath";
  static final String NETWORK_PATH_UNKNOWN = "unknown";

  static final String NETWORK_IO_DIRECTION_RECEIVE = "receive";
  static final String NETWORK_IO_DIRECTION_TRANSMIT = "transmit";

  static final String ATTRIBUTE_GCP_CLIENT_VERSION = "gcp.client.version";
  static final String ATTRIBUTE_GCP_CLIENT_SERVICE = "gcp.client.service";
  static final String ATTRIBUTE_GCP_CLIENT_ARTIFACT = "gcp.client.artifact";
  static final String ATTRIBUTE_GCP_CLIENT_INSTANCE_ID = "gcp.client.instance_id";

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

  // Debug metric names
  static final String METRIC_GCP_STORAGE_CLIENT_REQUEST_ACTIVE =
      "gcp.storage.client.request.active";
  static final String METRIC_GCP_STORAGE_CLIENT_SERVER_DURATION =
      "gcp.storage.client.server.duration";
  static final String METRIC_GCP_STORAGE_CLIENT_SERVER_UNREACHED =
      "gcp.storage.client.server.unreached";
  static final String METRIC_GCP_STORAGE_CLIENT_STALL_DURATION =
      "gcp.storage.client.stall.duration";
  static final String METRIC_GCP_STORAGE_CLIENT_NETWORK_IO = "gcp.storage.client.network.io";
  static final String METRIC_GCP_STORAGE_CLIENT_AUTH_CREDENTIAL_REFRESH_DURATION =
      "gcp.storage.client.auth.credential_refresh.duration";

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

  @Nullable private final LongUpDownCounter requestActive;
  @Nullable private final DoubleHistogram serverDuration;
  @Nullable private final LongCounter serverUnreached;
  @Nullable private final DoubleHistogram stallDuration;
  @Nullable private final LongCounter networkIo;
  @Nullable private final DoubleHistogram credentialRefreshDuration;

  private final Attributes clientAttributes;

  static StorageClientMetrics create(
      MeterProvider meterProvider, boolean enableOtelMetrics, boolean enableOtelDebugMetrics) {
    return create(
        meterProvider, UUID.randomUUID().toString(), enableOtelMetrics, enableOtelDebugMetrics);
  }

  static StorageClientMetrics create(
      MeterProvider meterProvider,
      String instanceId,
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
            .put(KEY_GCP_CLIENT_INSTANCE_ID, instanceId)
            .build();
    return new StorageClientMetrics(
        meter, clientAttributes, enableOtelMetrics, enableOtelDebugMetrics);
  }

  StorageClientMetrics(Meter meter, boolean enableOtelMetrics, boolean enableOtelDebugMetrics) {
    this(
        meter,
        Attributes.builder()
            .put(KEY_GCP_CLIENT_SERVICE, SERVICE_STORAGE)
            .put(KEY_GCP_CLIENT_VERSION, StorageOptions.version())
            .put(KEY_GCP_CLIENT_ARTIFACT, ARTIFACT_STORAGE)
            .put(KEY_GCP_CLIENT_INSTANCE_ID, UUID.randomUUID().toString())
            .build(),
        enableOtelMetrics,
        enableOtelDebugMetrics);
  }

  StorageClientMetrics(
      Meter meter,
      Attributes clientAttributes,
      boolean enableOtelMetrics,
      boolean enableOtelDebugMetrics) {
    this.clientAttributes = clientAttributes;

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
              .setUnit("1")
              .build();
      this.attempts =
          meter
              .counterBuilder(METRIC_GCP_STORAGE_CLIENT_ATTEMPTS)
              .setDescription(
                  "Number of GCS client attempts (individual HTTP requests or gRPC calls), including"
                      + " retries, resumable upload chunks and list pages.")
              .setUnit("1")
              .build();
      this.retries =
          meter
              .counterBuilder(METRIC_GCP_STORAGE_CLIENT_RETRIES)
              .setDescription("Number of GCS client retry attempts.")
              .setUnit("1")
              .build();
      this.errors =
          meter
              .counterBuilder(METRIC_GCP_STORAGE_CLIENT_ERRORS)
              .setDescription("Number of failed GCS client attempts, by error.type.")
              .setUnit("1")
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
    }

    if (enableOtelDebugMetrics) {
      this.requestActive =
          meter
              .upDownCounterBuilder(METRIC_GCP_STORAGE_CLIENT_REQUEST_ACTIVE)
              .setDescription("Number of active GCS client requests")
              .setUnit("1")
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
      this.serverUnreached =
          meter
              .counterBuilder(METRIC_GCP_STORAGE_CLIENT_SERVER_UNREACHED)
              .setDescription(
                  "Number of attempts that received no response from a GCS server (gRPC:"
                      + " grpc-server-stats-bin trailer absent; HTTP: X-GUploader-UploadID header"
                      + " absent).")
              .setUnit("1")
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
      this.serverUnreached = null;
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

  @Nullable LongUpDownCounter getRequestActive() {
    return requestActive;
  }

  @Nullable DoubleHistogram getServerDuration() {
    return serverDuration;
  }

  @Nullable LongCounter getServerUnreached() {
    return serverUnreached;
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
}
