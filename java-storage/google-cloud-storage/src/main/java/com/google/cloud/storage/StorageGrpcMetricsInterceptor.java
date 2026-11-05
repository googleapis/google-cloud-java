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

import com.google.api.core.ApiClock;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.Grpc;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jspecify.annotations.Nullable;

/**
 * {@link ClientInterceptor} that instruments outgoing gRPC calls to record OpenTelemetry client
 * metrics.
 */
final class StorageGrpcMetricsInterceptor implements ClientInterceptor {

  private static final String DP_IPV6_PREFIX = "2001:4860:8040";
  private static final String DP_IPV4_PREFIX = "34.126";

  private final StorageClientMetrics metrics;
  private final ApiClock clock;
  @Nullable private final String defaultServerAddress;
  private final boolean isDirectPathEndpoint;

  StorageGrpcMetricsInterceptor(
      StorageClientMetrics metrics, ApiClock clock, @Nullable String defaultEndpoint) {
    this.metrics = metrics;
    this.clock = clock;
    this.defaultServerAddress =
        OpenTelemetryBootstrappingUtils.extractServerAddress(defaultEndpoint);
    this.isDirectPathEndpoint =
        defaultEndpoint != null && defaultEndpoint.trim().startsWith("google-c2p:///");
  }

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
    if (metrics == null) {
      return next.newCall(method, callOptions);
    }

    String shortMethod = extractShortMethodName(method.getFullMethodName());
    boolean isReadMethod = "ReadObject".equals(shortMethod) || "BidiReadObject".equals(shortMethod);
    boolean recordDuration = metrics.getRpcClientCallDuration() != null;
    boolean recordTtfb = isReadMethod && metrics.getTtfb() != null;
    if (!recordDuration && !recordTtfb) {
      return next.newCall(method, callOptions);
    }

    String resolvedServerAddress =
        defaultServerAddress != null
            ? defaultServerAddress
            : OpenTelemetryBootstrappingUtils.extractServerAddress(next.authority());
    final String serverAddress = resolvedServerAddress != null ? resolvedServerAddress : "";

    StorageMetricsContext metricsCtx = StorageMetricsContext.from(callOptions);

    return new SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
      @Override
      public void start(Listener<RespT> responseListener, Metadata headers) {
        long startTimeNanos = clock.nanoTime();
        AtomicBoolean callRecorded = new AtomicBoolean(false);
        AtomicBoolean ttfbRecorded = new AtomicBoolean(false);

        super.start(
            new SimpleForwardingClientCallListener<RespT>(responseListener) {
              @Override
              public void onMessage(RespT message) {
                // The first response message from the server (including metadata-only
                // responses for 0-byte objects) marks Time To First Byte (TTFB).
                if (recordTtfb && ttfbRecorded.compareAndSet(false, true)) {
                  double ttfbSeconds =
                      Math.max(0.0, (clock.nanoTime() - startTimeNanos) / 1_000_000_000.0);
                  String networkPath = detectNetworkPath(getAttributes(), isDirectPathEndpoint);
                  StorageMetricsContext.recordTtfb(
                      metrics, metricsCtx, ttfbSeconds, "grpc", networkPath, serverAddress);
                }
                super.onMessage(message);
              }

              @Override
              public void onClose(Status status, Metadata trailers) {
                try {
                  if (recordDuration && callRecorded.compareAndSet(false, true)) {
                    double durationSeconds =
                        Math.max(0.0, (clock.nanoTime() - startTimeNanos) / 1_000_000_000.0);
                    String networkPath = detectNetworkPath(getAttributes(), isDirectPathEndpoint);
                    String statusCode =
                        status != null && status.getCode() != null
                            ? status.getCode().name()
                            : StorageErrorTypeMapper.STATUS_UNKNOWN;
                    String errorType =
                        status != null && !status.isOk() && status.getCause() != null
                            ? StorageErrorTypeMapper.mapThrowable(status.asRuntimeException())
                            : StorageErrorTypeMapper.mapGrpcStatus(status);

                    StorageMetricsContext.recordRpcCallDuration(
                        metrics,
                        metricsCtx,
                        durationSeconds,
                        shortMethod,
                        statusCode,
                        networkPath,
                        serverAddress,
                        errorType);
                  }
                } finally {
                  super.onClose(status, trailers);
                }
              }
            },
            headers);
      }
    };
  }

  static String extractShortMethodName(@Nullable String fullMethodName) {
    if (fullMethodName == null || fullMethodName.isEmpty()) {
      return "UNKNOWN";
    }
    int idx = fullMethodName.lastIndexOf('/');
    if (idx >= 0 && idx < fullMethodName.length() - 1) {
      return fullMethodName.substring(idx + 1);
    }
    return fullMethodName;
  }

  static String detectNetworkPath(
      @Nullable Attributes callAttributes, boolean isDirectPathEndpoint) {
    SocketAddress remoteAddr =
        callAttributes != null ? callAttributes.get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR) : null;
    if (remoteAddr instanceof InetSocketAddress) {
      InetAddress inetAddr = ((InetSocketAddress) remoteAddr).getAddress();
      if (inetAddr != null) {
        return isDirectPathIp(inetAddr)
            ? StorageClientMetrics.NETWORK_PATH_DIRECTPATH
            : StorageClientMetrics.NETWORK_PATH_CLOUDPATH;
      }
    }
    if (isDirectPathEndpoint) {
      return StorageClientMetrics.NETWORK_PATH_DIRECTPATH;
    }
    return StorageClientMetrics.NETWORK_PATH_UNKNOWN;
  }

  static boolean isDirectPathIp(InetAddress addr) {
    String hostAddr = addr.getHostAddress();
    return hostAddr != null
        && (hostAddr.startsWith(DP_IPV4_PREFIX) || hostAddr.startsWith(DP_IPV6_PREFIX));
  }
}
