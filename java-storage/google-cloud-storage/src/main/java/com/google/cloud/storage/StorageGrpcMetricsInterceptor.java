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
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;
import org.checkerframework.checker.nullness.qual.Nullable;

/** gRPC client interceptor that records call metrics such as rpc.client.call.duration. */
final class StorageGrpcMetricsInterceptor implements ClientInterceptor {

  private final StorageClientMetrics metrics;
  private final ApiClock clock;
  @Nullable private final String defaultEndpoint;

  StorageGrpcMetricsInterceptor(
      StorageClientMetrics metrics, ApiClock clock, @Nullable String defaultEndpoint) {
    this.metrics = metrics;
    this.clock = clock;
    this.defaultEndpoint = defaultEndpoint;
  }

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
    if (metrics == null
        || (metrics.getRpcClientCallDuration() == null && metrics.getTtfb() == null)) {
      return next.newCall(method, callOptions);
    }

    String shortMethod = extractShortMethodName(method.getFullMethodName());
    boolean isReadMethod = "ReadObject".equals(shortMethod) || "BidiReadObject".equals(shortMethod);
    String initialServerAddress =
        StorageOptions.extractServerAddress(
            defaultEndpoint != null ? defaultEndpoint : next.authority());
    final String serverAddress =
        initialServerAddress != null
            ? initialServerAddress
            : StorageOptions.extractServerAddress(next.authority());

    StorageMetricsContext metricsCtx = StorageMetricsContext.from(callOptions);
    Context otelContext = metricsCtx != null ? metricsCtx.getOtelContext() : Context.current();

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
                if (isReadMethod
                    && metrics.getTtfb() != null
                    && ttfbRecorded.compareAndSet(false, true)) {
                  double ttfbSeconds =
                      Math.max(0.0, (clock.nanoTime() - startTimeNanos) / 1_000_000_000.0);
                  String networkPath = detectNetworkPath(getAttributes(), defaultEndpoint);
                  AttributesBuilder ttfbAttrs =
                      metrics
                          .clientAttributesBuilder()
                          .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc")
                          .put(StorageClientMetrics.KEY_RPC_METHOD, shortMethod)
                          .put(StorageClientMetrics.KEY_NETWORK_PATH, networkPath)
                          .put(
                              StorageClientMetrics.KEY_SERVER_ADDRESS,
                              serverAddress != null ? serverAddress : "");
                  metrics.getTtfb().record(ttfbSeconds, ttfbAttrs.build(), otelContext);
                }
                super.onMessage(message);
              }

              @Override
              public void onClose(Status status, Metadata trailers) {
                try {
                  if (callRecorded.compareAndSet(false, true)
                      && metrics.getRpcClientCallDuration() != null) {
                    double durationSeconds =
                        Math.max(0.0, (clock.nanoTime() - startTimeNanos) / 1_000_000_000.0);
                    String networkPath = detectNetworkPath(getAttributes(), defaultEndpoint);

                    AttributesBuilder attrBuilder =
                        metrics
                            .clientAttributesBuilder()
                            .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "grpc")
                            .put(StorageClientMetrics.KEY_RPC_METHOD, shortMethod)
                            .put(
                                StorageClientMetrics.KEY_RPC_RESPONSE_STATUS_CODE,
                                status.getCode().name())
                            .put(StorageClientMetrics.KEY_NETWORK_PATH, networkPath)
                            .put(
                                StorageClientMetrics.KEY_SERVER_ADDRESS,
                                serverAddress != null ? serverAddress : "")
                            .put(
                                StorageClientMetrics.KEY_ERROR_TYPE,
                                StorageErrorTypeMapper.mapGrpcStatus(status));

                    metrics
                        .getRpcClientCallDuration()
                        .record(durationSeconds, attrBuilder.build(), otelContext);
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
      @Nullable Attributes callAttributes, @Nullable String defaultEndpoint) {
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
    if (defaultEndpoint != null && defaultEndpoint.trim().startsWith("google-c2p:///")) {
      return StorageClientMetrics.NETWORK_PATH_DIRECTPATH;
    }
    return StorageClientMetrics.NETWORK_PATH_UNKNOWN;
  }

  static boolean isDirectPathIp(InetAddress addr) {
    byte[] b = addr.getAddress();
    if (b.length == 4) {
      return (b[0] & 0xFF) == 34 && (b[1] & 0xFF) == 126 && ((b[2] & 0xFF) & 0xC0) == 0;
    }
    if (b.length == 16) {
      return (b[0] & 0xFF) == 0x20
          && (b[1] & 0xFF) == 0x01
          && (b[2] & 0xFF) == 0x48
          && (b[3] & 0xFF) == 0x60
          && (b[4] & 0xFF) == 0x80
          && ((b[5] & 0xFF) & 0xC0) == 0x40;
    }
    return false;
  }
}
