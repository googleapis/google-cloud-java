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

import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.api.metrics.LongUpDownCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterProvider;
import org.checkerframework.checker.nullness.qual.Nullable;

/** Package-private instrument registry for OpenTelemetry client metrics. */
final class StorageClientMetrics {
  static final String METER_NAME = "com.google.cloud.storage";

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
  static final String METRIC_GCP_STORAGE_CLIENT_GFE_DURATION = "gcp.storage.client.gfe.duration";
  static final String METRIC_GCP_STORAGE_CLIENT_GFE_HEADER_MISSING =
      "gcp.storage.client.gfe.header_missing";
  static final String METRIC_GCP_STORAGE_CLIENT_STALL_DURATION =
      "gcp.storage.client.stall.duration";
  static final String METRIC_GCP_STORAGE_CLIENT_NETWORK_BYTES_SENT =
      "gcp.storage.client.network.bytes.sent";
  static final String METRIC_GCP_STORAGE_CLIENT_NETWORK_BYTES_RECEIVED =
      "gcp.storage.client.network.bytes.received";
  static final String METRIC_GCP_STORAGE_CLIENT_AUTH_CREDENTIAL_REFRESH_DURATION =
      "gcp.storage.client.auth.credential_refresh.duration";

  // Deferred metrics (Phase 2 placeholders - not currently measurable on Java HTTP/gRPC transports)
  static final String METRIC_GCP_STORAGE_CLIENT_NETWORK_DNS_LOOKUP_DURATION =
      "gcp.storage.client.network.dns.lookup.duration";
  static final String METRIC_GCP_STORAGE_CLIENT_NETWORK_TCP_CONNECT_DURATION =
      "gcp.storage.client.network.tcp.connect.duration";
  static final String METRIC_GCP_STORAGE_CLIENT_NETWORK_TLS_HANDSHAKE_DURATION =
      "gcp.storage.client.network.tls.handshake.duration";

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
  @Nullable private final DoubleHistogram gfeDuration;
  @Nullable private final LongCounter gfeHeaderMissing;
  @Nullable private final DoubleHistogram stallDuration;
  @Nullable private final LongHistogram networkBytesSent;
  @Nullable private final LongHistogram networkBytesReceived;
  @Nullable private final DoubleHistogram dnsLookupDuration;
  @Nullable private final DoubleHistogram tcpConnectDuration;
  @Nullable private final DoubleHistogram tlsHandshakeDuration;
  @Nullable private final DoubleHistogram credentialRefreshDuration;

  static StorageClientMetrics create(MeterProvider meterProvider, boolean enableOtelDebugMetrics) {
    Meter meter =
        meterProvider
            .meterBuilder(METER_NAME)
            .setInstrumentationVersion(StorageOptions.version())
            .build();
    return new StorageClientMetrics(meter, enableOtelDebugMetrics);
  }

  StorageClientMetrics(Meter meter, boolean enableOtelDebugMetrics) {
    this.rpcClientCallDuration =
        meter
            .histogramBuilder(METRIC_RPC_CLIENT_CALL_DURATION)
            .setDescription("Duration of one gRPC request. Retries not included (Otel)")
            .setUnit("s")
            .build();
    this.httpClientRequestDuration =
        meter
            .histogramBuilder(METRIC_HTTP_CLIENT_REQUEST_DURATION)
            .setDescription("Duration of one HTTP client request. Retries not included (Otel)")
            .setUnit("s")
            .build();
    this.gcpClientRequestDuration =
        meter
            .histogramBuilder(METRIC_GCP_CLIENT_REQUEST_DURATION)
            .setDescription("Latency of a client operation")
            .setUnit("s")
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
            .setDescription("Number of GCS client attempts")
            .setUnit("1")
            .build();
    this.errors =
        meter
            .counterBuilder(METRIC_GCP_STORAGE_CLIENT_ERRORS)
            .setDescription("Number of GCS client errors")
            .setUnit("1")
            .build();
    this.operationTtfb =
        meter
            .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_OPERATION_TTFB)
            .setDescription("Time to first byte of GCS client operations")
            .setUnit("s")
            .build();
    this.requestBodySize =
        meter
            .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE)
            .ofLongs()
            .setDescription("Size of GCS client request body")
            .setUnit("By")
            .build();
    this.responseBodySize =
        meter
            .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE)
            .ofLongs()
            .setDescription("Size of GCS client response body")
            .setUnit("By")
            .build();

    if (enableOtelDebugMetrics) {
      this.requestActive =
          meter
              .upDownCounterBuilder(METRIC_GCP_STORAGE_CLIENT_REQUEST_ACTIVE)
              .setDescription("Number of active GCS client requests")
              .setUnit("1")
              .build();
      this.gfeDuration =
          meter
              .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_GFE_DURATION)
              .setDescription("GFE proxy processing time")
              .setUnit("s")
              .build();
      this.gfeHeaderMissing =
          meter
              .counterBuilder(METRIC_GCP_STORAGE_CLIENT_GFE_HEADER_MISSING)
              .setDescription(
                  "Number of GCS requests where the X-Goog-Gfe-Service-Time header was missing")
              .setUnit("1")
              .build();
      this.stallDuration =
          meter
              .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_STALL_DURATION)
              .setDescription("Duration of client stall")
              .setUnit("s")
              .build();
      this.networkBytesSent =
          meter
              .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_NETWORK_BYTES_SENT)
              .ofLongs()
              .setDescription("Number of wire bytes sent on the network")
              .setUnit("By")
              .build();
      this.networkBytesReceived =
          meter
              .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_NETWORK_BYTES_RECEIVED)
              .ofLongs()
              .setDescription("Number of wire bytes received from the network")
              .setUnit("By")
              .build();
      this.dnsLookupDuration =
          meter
              .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_NETWORK_DNS_LOOKUP_DURATION)
              .setDescription("Time taken for DNS lookup")
              .setUnit("s")
              .build();
      this.tcpConnectDuration =
          meter
              .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_NETWORK_TCP_CONNECT_DURATION)
              .setDescription("Time taken for TCP connection")
              .setUnit("s")
              .build();
      this.tlsHandshakeDuration =
          meter
              .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_NETWORK_TLS_HANDSHAKE_DURATION)
              .setDescription("Time taken to perform a TLS handshake")
              .setUnit("s")
              .build();
      this.credentialRefreshDuration =
          meter
              .histogramBuilder(METRIC_GCP_STORAGE_CLIENT_AUTH_CREDENTIAL_REFRESH_DURATION)
              .setDescription(
                  "Duration of the background API/network calls made to refresh OAuth2/JWT access"
                      + " credentials.")
              .setUnit("s")
              .build();
    } else {
      this.requestActive = null;
      this.gfeDuration = null;
      this.gfeHeaderMissing = null;
      this.stallDuration = null;
      this.networkBytesSent = null;
      this.networkBytesReceived = null;
      this.dnsLookupDuration = null;
      this.tcpConnectDuration = null;
      this.tlsHandshakeDuration = null;
      this.credentialRefreshDuration = null;
    }
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

  @Nullable DoubleHistogram getGfeDuration() {
    return gfeDuration;
  }

  @Nullable LongCounter getGfeHeaderMissing() {
    return gfeHeaderMissing;
  }

  @Nullable DoubleHistogram getStallDuration() {
    return stallDuration;
  }

  @Nullable LongHistogram getNetworkBytesSent() {
    return networkBytesSent;
  }

  @Nullable LongHistogram getNetworkBytesReceived() {
    return networkBytesReceived;
  }

  @Nullable DoubleHistogram getDnsLookupDuration() {
    return dnsLookupDuration;
  }

  @Nullable DoubleHistogram getTcpConnectDuration() {
    return tcpConnectDuration;
  }

  @Nullable DoubleHistogram getTlsHandshakeDuration() {
    return tlsHandshakeDuration;
  }

  @Nullable DoubleHistogram getCredentialRefreshDuration() {
    return credentialRefreshDuration;
  }
}
