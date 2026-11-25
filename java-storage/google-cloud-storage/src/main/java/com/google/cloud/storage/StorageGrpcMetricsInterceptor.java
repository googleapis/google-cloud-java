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
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.WriteObjectRequest;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientStreamTracer;
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
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * {@link ClientInterceptor} that instruments outgoing gRPC calls to record OpenTelemetry client
 * metrics.
 */
@NullMarked
final class StorageGrpcMetricsInterceptor implements ClientInterceptor {

  static final Metadata.Key<byte[]> GRPC_SERVER_STATS_BIN_KEY =
      Metadata.Key.of("grpc-server-stats-bin", Metadata.BINARY_BYTE_MARSHALLER);
  static final Metadata.Key<String> UPLOADER_UPLOAD_ID_KEY =
      Metadata.Key.of("x-guploader-uploadid", Metadata.ASCII_STRING_MARSHALLER);

  private final StorageClientMetrics metrics;
  private final ApiClock clock;

  StorageGrpcMetricsInterceptor(StorageClientMetrics metrics, ApiClock clock) {
    this.metrics = requireNonNull(metrics, "metrics cannot be null");
    this.clock = requireNonNull(clock, "clock cannot be null");
  }

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
    String rpcMethod = method.getFullMethodName();
    StorageMetricsContext metricsCtx = StorageMetricsContext.from(callOptions);
    Context otelContext = metricsCtx != null ? metricsCtx.getOtelContext() : Context.current();
    String operationName =
        metricsCtx != null
            ? metricsCtx.getOperationName()
            : defaultOperationName(method.getBareMethodName());

    NetworkIoTracerFactory networkIoTracerFactory =
        metrics.getNetworkIo() != null ? new NetworkIoTracerFactory() : null;
    CallOptions effectiveCallOptions =
        networkIoTracerFactory != null
            ? callOptions.withStreamTracerFactory(networkIoTracerFactory)
            : callOptions;

    return new SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, effectiveCallOptions)) {
      private final AtomicBoolean ttfbRecorded = new AtomicBoolean(false);
      private final AtomicLong ttfbStartNanos = new AtomicLong();

      @Override
      public void start(Listener<RespT> responseListener, Metadata headers) {
        long startTimeNanos = clock.nanoTime();
        ttfbStartNanos.set(startTimeNanos);
        metrics.recordRequestActive(otelContext, operationName, 1L);

        try {
          startWithMetrics(responseListener, headers, startTimeNanos);
        } catch (RuntimeException | Error e) {
          // Per the ClientCall contract, onClose is not delivered when start throws, so balance
          // the +1 here.
          metrics.recordRequestActive(otelContext, operationName, -1L);
          throw e;
        }
      }

      private void startWithMetrics(
          Listener<RespT> responseListener, Metadata headers, long startTimeNanos) {
        super.start(
            new SimpleForwardingClientCallListener<RespT>(responseListener) {
              private boolean receivedServerHeaders;
              private boolean headerHasUploadId;

              @Override
              public void onHeaders(Metadata headers) {
                receivedServerHeaders = true;
                if (hasNonEmptyMetadata(headers, UPLOADER_UPLOAD_ID_KEY)) {
                  headerHasUploadId = true;
                }
                if (metricsCtx != null) {
                  metricsCtx.setNetworkPath(detectNetworkPath(getAttributes()));
                }
                super.onHeaders(headers);
              }

              @Override
              public void onMessage(@Nullable RespT message) {
                // The first response message from the server (including metadata-only
                // responses for 0-byte objects) marks Time To First Byte (TTFB).
                if (ttfbRecorded.compareAndSet(false, true)) {
                  double ttfbSeconds = (clock.nanoTime() - ttfbStartNanos.get()) / 1_000_000_000.0;
                  String networkPath = detectNetworkPath(getAttributes());
                  metrics.recordTtfb(otelContext, operationName, ttfbSeconds, networkPath);
                }
                super.onMessage(message);
              }

              @Override
              public void onClose(Status status, Metadata trailers) {
                try {
                  double durationSeconds = (clock.nanoTime() - startTimeNanos) / 1_000_000_000.0;
                  String networkPath = detectNetworkPath(getAttributes());
                  if (metricsCtx != null) {
                    metricsCtx.setNetworkPath(networkPath);
                  }
                  String statusCode = status.getCode().name();
                  String errorType = StorageErrorTypeMapper.mapGrpcStatus(status);

                  metrics.recordRpcCallDuration(
                      otelContext, durationSeconds, rpcMethod, statusCode, networkPath, errorType);
                  double serverDurationSeconds = decodeServerDurationSeconds(trailers);
                  if (serverDurationSeconds >= 0.0) {
                    metrics.recordServerDuration(
                        otelContext, serverDurationSeconds, operationName, networkPath);
                  }
                  if (isServerUnreached(
                      networkPath,
                      status,
                      errorType,
                      serverDurationSeconds >= 0.0,
                      receivedServerHeaders,
                      headerHasUploadId,
                      trailers)) {
                    metrics.recordServerUnreached(
                        otelContext, operationName, networkPath, errorType);
                  }
                  if (networkIoTracerFactory != null) {
                    metrics.recordNetworkIo(
                        otelContext,
                        networkPath,
                        networkIoTracerFactory.getOutboundBytes(),
                        networkIoTracerFactory.getInboundBytes());
                  }
                } finally {
                  metrics.recordRequestActive(otelContext, operationName, -1L);
                  super.onClose(status, trailers);
                }
              }
            },
            headers);
      }

      @Override
      public void sendMessage(ReqT message) {
        if (!ttfbRecorded.get() && isWriteFlush(message)) {
          ttfbStartNanos.set(clock.nanoTime());
        }
        super.sendMessage(message);
      }
    };
  }

  static double decodeServerDurationSeconds(Metadata trailers) {
    byte[] bytes = trailers.get(GRPC_SERVER_STATS_BIN_KEY);
    // Census ServerStats binary encoding: version (0x00), field ID (0x00), 8-byte LE uint64 nanos.
    if (bytes == null || bytes.length != 10 || bytes[0] != 0 || bytes[1] != 0) {
      return -1.0;
    }
    long nanos = ByteBuffer.wrap(bytes, 2, 8).order(ByteOrder.LITTLE_ENDIAN).getLong();
    return nanos >= 0 ? nanos / 1_000_000_000.0 : -1.0;
  }

  static String defaultOperationName(@Nullable String bareMethod) {
    if (bareMethod == null || bareMethod.isEmpty()) {
      return "UNKNOWN";
    }
    switch (bareMethod) {
      case "BidiReadObject":
        return "ReadObject";
      case "BidiWriteObject":
      case "StartResumableWrite":
      case "QueryWriteStatus":
        return "WriteObject";
      default:
        return bareMethod;
    }
  }

  static boolean isWriteFlush(@Nullable Object message) {
    if (message instanceof BidiWriteObjectRequest) {
      BidiWriteObjectRequest req = (BidiWriteObjectRequest) message;
      return req.getFlush() || req.getFinishWrite();
    }
    if (message instanceof WriteObjectRequest) {
      return ((WriteObjectRequest) message).getFinishWrite();
    }
    return false;
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

  private static boolean isServerUnreached(
      String networkPath,
      Status status,
      String errorType,
      boolean hasServerDuration,
      boolean receivedServerHeaders,
      boolean headerHasUploadId,
      Metadata trailers) {
    if (StorageClientMetrics.NETWORK_PATH_DIRECTPATH.equals(networkPath)) {
      boolean reached =
          hasServerDuration || receivedServerHeaders || !trailers.keys().isEmpty() || status.isOk();
      return !reached && isPreServerErrorType(errorType);
    }
    boolean hasUploadId =
        headerHasUploadId || hasNonEmptyMetadata(trailers, UPLOADER_UPLOAD_ID_KEY);
    boolean reached = hasServerDuration || hasUploadId;
    return !reached && !isAmbiguousClientAbort(errorType);
  }

  private static boolean isAmbiguousClientAbort(String errorType) {
    return StorageErrorTypeMapper.STATUS_CANCELLED.equals(errorType)
        || StorageErrorTypeMapper.STATUS_TIMEOUT.equals(errorType)
        || StorageErrorTypeMapper.STATUS_DEADLINE_EXCEEDED.equals(errorType);
  }

  private static boolean isPreServerErrorType(String errorType) {
    return StorageErrorTypeMapper.STATUS_AUTHENTICATION_ERROR.equals(errorType)
        || StorageErrorTypeMapper.STATUS_TLS_FAILURE.equals(errorType)
        || StorageErrorTypeMapper.STATUS_DNS_FAILURE.equals(errorType)
        || StorageErrorTypeMapper.STATUS_CONNECTION_ERROR.equals(errorType);
  }

  private static boolean hasNonEmptyMetadata(Metadata metadata, Metadata.Key<String> key) {
    String value = metadata.get(key);
    return value != null && !value.isEmpty();
  }

  private static final class NetworkIoTracerFactory extends ClientStreamTracer.Factory {
    private final AtomicLong outboundBytes = new AtomicLong();
    private final AtomicLong inboundBytes = new AtomicLong();

    @Override
    public ClientStreamTracer newClientStreamTracer(
        ClientStreamTracer.StreamInfo info, Metadata headers) {
      return new ClientStreamTracer() {
        @Override
        public void outboundWireSize(long bytes) {
          if (bytes > 0) {
            outboundBytes.addAndGet(bytes);
          }
        }

        @Override
        public void inboundWireSize(long bytes) {
          if (bytes > 0) {
            inboundBytes.addAndGet(bytes);
          }
        }
      };
    }

    long getOutboundBytes() {
      return outboundBytes.get();
    }

    long getInboundBytes() {
      return inboundBytes.get();
    }
  }
}
