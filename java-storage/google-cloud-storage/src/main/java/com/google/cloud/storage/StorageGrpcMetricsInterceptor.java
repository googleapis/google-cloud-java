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
import io.opentelemetry.context.Context;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * {@link ClientInterceptor} that instruments outgoing gRPC calls to record OpenTelemetry client
 * metrics.
 */
@NullMarked
final class StorageGrpcMetricsInterceptor implements ClientInterceptor {

  private final StorageClientMetrics metrics;
  private final ApiClock clock;

  StorageGrpcMetricsInterceptor(StorageClientMetrics metrics, ApiClock clock) {
    this.metrics = requireNonNull(metrics, "metrics cannot be null");
    this.clock = requireNonNull(clock, "clock cannot be null");
  }

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
    if (metrics.getRpcClientCallDuration() == null) {
      return next.newCall(method, callOptions);
    }

    String rpcMethod = method.getFullMethodName();
    StorageMetricsContext metricsCtx = StorageMetricsContext.from(callOptions);
    Context otelContext = metricsCtx != null ? metricsCtx.getOtelContext() : Context.current();

    return new SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
      @Override
      public void start(Listener<RespT> responseListener, Metadata headers) {
        long startTimeNanos = clock.nanoTime();
        AtomicBoolean callRecorded = new AtomicBoolean(false);

        super.start(
            new SimpleForwardingClientCallListener<RespT>(responseListener) {
              @Override
              public void onClose(@Nullable Status status, @Nullable Metadata trailers) {
                try {
                  if (callRecorded.compareAndSet(false, true)) {
                    double durationSeconds =
                        Math.max(0.0, (clock.nanoTime() - startTimeNanos) / 1_000_000_000.0);
                    String networkPath = detectNetworkPath(getAttributes());
                    if (metricsCtx != null) {
                      metricsCtx.setNetworkPath(networkPath);
                    }
                    String statusCode =
                        status != null && status.getCode() != null
                            ? status.getCode().name()
                            : StorageErrorTypeMapper.STATUS_UNKNOWN;
                    String errorType = StorageErrorTypeMapper.mapGrpcStatus(status);

                    metrics.recordRpcCallDuration(
                        otelContext,
                        durationSeconds,
                        rpcMethod,
                        statusCode,
                        networkPath,
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

  static String detectNetworkPath(@Nullable Attributes callAttributes) {
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
    return StorageClientMetrics.NETWORK_PATH_UNKNOWN;
  }

  static boolean isDirectPathIp(InetAddress addr) {
    byte[] b = addr.getAddress();
    if (b.length == 4) {
      // 34.126.0.0/18
      return b[0] == 34 && b[1] == 126 && (b[2] & 0xC0) == 0;
    }
    if (b.length == 16) {
      // 2001:4860:8040::/42
      return b[0] == 0x20
          && b[1] == 0x01
          && b[2] == 0x48
          && b[3] == 0x60
          && b[4] == (byte) 0x80
          && (b[5] & 0xC0) == 0x40;
    }
    return false;
  }
}
