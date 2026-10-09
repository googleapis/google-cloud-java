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
  static final String METRIC_GCP_STORAGE_CLIENT_ERRORS = "gcp.storage.client.errors";
  static final String METRIC_GCP_STORAGE_CLIENT_OPERATION_TTFB =
      "gcp.storage.client.operation.ttfb";
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
  static final String METRIC_GCP_STORAGE_CLIENT_NETWORK_BYTES_SENT =
      "gcp.storage.client.network.bytes.sent";
  static final String METRIC_GCP_STORAGE_CLIENT_NETWORK_BYTES_RECEIVED =
      "gcp.storage.client.network.bytes.received";
  static final String METRIC_GCP_STORAGE_CLIENT_AUTH_CREDENTIAL_REFRESH_DURATION =
      "gcp.storage.client.auth.credential_refresh.duration";

  private final DoubleHistogram rpcClientCallDuration;
  private final DoubleHistogram httpClientRequestDuration;
  private final DoubleHistogram gcpClientRequestDuration;
  private final LongCounter operations;
  private final LongCounter attempts;
  private final LongCounter errors;
  private final DoubleHistogram operationTtfb;
  private final LongHistogram requestBodySize;
  private final LongHistogram responseBodySize;

  @Nullable private final LongUpDownCounter requestActive;
  @Nullable private final DoubleHistogram serverDuration;
  @Nullable private final LongCounter serverUnreached;
  @Nullable private final DoubleHistogram stallDuration;
  @Nullable private final LongCounter networkBytesSent;
  @Nullable private final LongCounter networkBytesReceived;
  @Nullable private final DoubleHistogram credentialRefreshDuration;

  private final Attributes clientAttributes;

  static StorageClientMetrics create(MeterProvider meterProvider, boolean enableOtelDebugMetrics) {
    return create(meterProvider, UUID.randomUUID().toString(), enableOtelDebugMetrics);
  }

  static StorageClientMetrics create(
      MeterProvider meterProvider, String instanceId, boolean enableOtelDebugMetrics) {
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
    return new StorageClientMetrics(meter, clientAttributes, enableOtelDebugMetrics);
  }

  StorageClientMetrics(Meter meter, boolean enableOtelDebugMetrics) {
    this(
        meter,
        Attributes.builder()
            .put(KEY_GCP_CLIENT_SERVICE, SERVICE_STORAGE)
            .put(KEY_GCP_CLIENT_VERSION, StorageOptions.version())
            .put(KEY_GCP_CLIENT_ARTIFACT, ARTIFACT_STORAGE)
            .put(KEY_GCP_CLIENT_INSTANCE_ID, UUID.randomUUID().toString())
            .build(),
        enableOtelDebugMetrics);
  }

  StorageClientMetrics(Meter meter, Attributes clientAttributes, boolean enableOtelDebugMetrics) {
    this.clientAttributes = clientAttributes;
    this.rpcClientCallDuration =
        meter
            .histogramBuilder(METRIC_RPC_CLIENT_CALL_DURATION)
            .setDescription("Duration of one gRPC request. Retries not included (Otel)")
            .setUnit("s")
            .setExplicitBucketBoundariesAdvice(
                OpenTelemetryBootstrappingUtils.latencyHistogramBoundaries())
            .build();
    this.httpClientRequestDuration =
        meter
            .histogramBuilder(METRIC_HTTP_CLIENT_REQUEST_DURATION)
            .setDescription("Duration of one HTTP client request. Retries not included (Otel)")
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
    this.errors =
        meter
            .counterBuilder(METRIC_GCP_STORAGE_CLIENT_ERRORS)
            .setDescription("Number of failed GCS client attempts, by error.type.")
            .setUnit("1")
            .build();
    this.operationTtfb =
        meter
            .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_OPERATION_TTFB)
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
      this.networkBytesSent =
          meter
              .counterBuilder(METRIC_GCP_STORAGE_CLIENT_NETWORK_BYTES_SENT)
              .setDescription("Total bytes sent on the wire (gRPC only).")
              .setUnit("By")
              .build();
      this.networkBytesReceived =
          meter
              .counterBuilder(METRIC_GCP_STORAGE_CLIENT_NETWORK_BYTES_RECEIVED)
              .setDescription("Total bytes received on the wire (gRPC only).")
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
      this.networkBytesSent = null;
      this.networkBytesReceived = null;
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

  DoubleHistogram getRpcClientCallDuration() {
    return rpcClientCallDuration;
  }

  DoubleHistogram getHttpClientRequestDuration() {
    return httpClientRequestDuration;
  }

  DoubleHistogram getGcpClientRequestDuration() {
    return gcpClientRequestDuration;
  }

  LongCounter getOperations() {
    return operations;
  }

  LongCounter getAttempts() {
    return attempts;
  }

  LongCounter getErrors() {
    return errors;
  }

  DoubleHistogram getOperationTtfb() {
    return operationTtfb;
  }

  LongHistogram getRequestBodySize() {
    return requestBodySize;
  }

  LongHistogram getResponseBodySize() {
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

  @Nullable LongCounter getNetworkBytesSent() {
    return networkBytesSent;
  }

  @Nullable LongCounter getNetworkBytesReceived() {
    return networkBytesReceived;
  }

  @Nullable DoubleHistogram getCredentialRefreshDuration() {
    return credentialRefreshDuration;
  }
}
