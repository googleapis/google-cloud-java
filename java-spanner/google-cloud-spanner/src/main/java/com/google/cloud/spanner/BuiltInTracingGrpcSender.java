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

package com.google.cloud.spanner;

import com.google.common.io.ByteStreams;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.CallOptions;
import io.grpc.ClientInterceptors;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.MetadataUtils;
import io.opentelemetry.common.ComponentLoader;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.common.export.GrpcResponse;
import io.opentelemetry.sdk.common.export.GrpcSender;
import io.opentelemetry.sdk.common.export.GrpcSenderConfig;
import io.opentelemetry.sdk.common.export.GrpcSenderProvider;
import io.opentelemetry.sdk.common.export.GrpcStatusCode;
import io.opentelemetry.sdk.common.export.MessageWriter;
import io.opentelemetry.sdk.common.export.RetryPolicy;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.net.URI;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.jspecify.annotations.Nullable;

/**
 * Sends the spans of built-in tracing with grpc-java. It is only given to the exporter of built-in
 * tracing through {@link #componentLoader()}, and is not registered as a service, so that it is
 * never picked by other OpenTelemetry exporters of the application.
 */
final class BuiltInTracingGrpcSender implements GrpcSender {

  private static final List<String> RETRYABLE_STATUS_CODES =
      Arrays.asList(
          "CANCELLED",
          "DEADLINE_EXCEEDED",
          "RESOURCE_EXHAUSTED",
          "ABORTED",
          "OUT_OF_RANGE",
          "UNAVAILABLE",
          "DATA_LOSS");

  private static final MethodDescriptor.Marshaller<byte[]> BYTES_MARSHALLER =
      new MethodDescriptor.Marshaller<byte[]>() {
        @Override
        public InputStream stream(byte[] value) {
          return new ByteArrayInputStream(value);
        }

        @Override
        public byte[] parse(InputStream stream) {
          try {
            return ByteStreams.toByteArray(stream);
          } catch (IOException exception) {
            throw new UncheckedIOException(exception);
          }
        }
      };

  private final ManagedChannel channel;
  private final MethodDescriptor<byte[], byte[]> method;
  private final GrpcSenderConfig config;
  private final Executor executor;

  private BuiltInTracingGrpcSender(GrpcSenderConfig config) {
    URI endpoint = config.getEndpoint();
    ManagedChannelBuilder<?> channelBuilder =
        ManagedChannelBuilder.forAddress(endpoint.getHost(), endpoint.getPort());
    if (!"https".equals(endpoint.getScheme())) {
      channelBuilder.usePlaintext();
    }
    RetryPolicy retryPolicy = config.getRetryPolicy();
    if (retryPolicy != null) {
      channelBuilder
          .defaultServiceConfig(createServiceConfig(config.getFullMethodName(), retryPolicy))
          .enableRetry();
    }
    this.channel = channelBuilder.build();
    this.method =
        MethodDescriptor.<byte[], byte[]>newBuilder()
            .setType(MethodDescriptor.MethodType.UNARY)
            .setFullMethodName(config.getFullMethodName())
            .setRequestMarshaller(BYTES_MARSHALLER)
            .setResponseMarshaller(BYTES_MARSHALLER)
            .build();
    this.config = config;
    this.executor =
        config.getExecutorService() == null
            ? MoreExecutors.directExecutor()
            : config.getExecutorService();
  }

  static ComponentLoader componentLoader() {
    return new SenderComponentLoader();
  }

  private static Map<String, ?> createServiceConfig(
      String fullMethodName, RetryPolicy retryPolicy) {
    Map<String, Object> retry = new HashMap<>();
    retry.put("maxAttempts", (double) retryPolicy.getMaxAttempts());
    retry.put("initialBackoff", toServiceConfigDuration(retryPolicy.getInitialBackoff()));
    retry.put("maxBackoff", toServiceConfigDuration(retryPolicy.getMaxBackoff()));
    retry.put("backoffMultiplier", retryPolicy.getBackoffMultiplier());
    retry.put("retryableStatusCodes", RETRYABLE_STATUS_CODES);
    Map<String, Object> methodConfig = new HashMap<>();
    methodConfig.put(
        "name",
        Collections.singletonList(
            Collections.singletonMap(
                "service", MethodDescriptor.extractFullServiceName(fullMethodName))));
    methodConfig.put("retryPolicy", retry);
    return Collections.singletonMap("methodConfig", Collections.singletonList(methodConfig));
  }

  private static String toServiceConfigDuration(Duration duration) {
    return BigDecimal.valueOf(duration.toNanos(), 9).toPlainString() + "s";
  }

  @Override
  public void send(
      MessageWriter messageWriter, Consumer<GrpcResponse> onResponse, Consumer<Throwable> onError) {
    byte[] request;
    try {
      ByteArrayOutputStream output = new ByteArrayOutputStream(messageWriter.getContentLength());
      messageWriter.writeMessage(output);
      request = output.toByteArray();
    } catch (IOException exception) {
      onError.accept(exception);
      return;
    }
    Metadata metadata = new Metadata();
    Map<String, List<String>> headers = config.getHeadersSupplier().get();
    if (headers != null) {
      for (Map.Entry<String, List<String>> header : headers.entrySet()) {
        metadata.put(
            Metadata.Key.of(header.getKey(), Metadata.ASCII_STRING_MARSHALLER),
            String.join(",", header.getValue()));
      }
    }
    CallOptions callOptions = CallOptions.DEFAULT;
    Duration timeout = config.getTimeout();
    if (timeout.toNanos() > 0) {
      callOptions = callOptions.withDeadlineAfter(timeout.toNanos(), TimeUnit.NANOSECONDS);
    }
    Futures.addCallback(
        ClientCalls.futureUnaryCall(
            ClientInterceptors.intercept(
                    channel, MetadataUtils.newAttachHeadersInterceptor(metadata))
                .newCall(method, callOptions),
            request),
        new FutureCallback<byte[]>() {
          @Override
          public void onSuccess(byte @Nullable [] response) {
            onResponse.accept(
                new Response(GrpcStatusCode.OK, null, response == null ? new byte[0] : response));
          }

          @Override
          public void onFailure(Throwable throwable) {
            Status status = findStatus(throwable);
            if (status == null) {
              onError.accept(throwable);
            } else {
              onResponse.accept(
                  new Response(
                      GrpcStatusCode.fromValue(status.getCode().value()),
                      status.getDescription(),
                      new byte[0]));
            }
          }
        },
        executor);
  }

  @Nullable
  private static Status findStatus(@Nullable Throwable throwable) {
    while (throwable != null) {
      if (throwable instanceof StatusException) {
        return ((StatusException) throwable).getStatus();
      }
      if (throwable instanceof StatusRuntimeException) {
        return ((StatusRuntimeException) throwable).getStatus();
      }
      throwable = throwable.getCause();
    }
    return null;
  }

  @Override
  public CompletableResultCode shutdown() {
    channel.shutdownNow();
    return CompletableResultCode.ofSuccess();
  }

  private static final class Response implements GrpcResponse {
    private final GrpcStatusCode statusCode;
    private final @Nullable String statusDescription;
    private final byte[] responseMessage;

    private Response(
        GrpcStatusCode statusCode, @Nullable String statusDescription, byte[] responseMessage) {
      this.statusCode = statusCode;
      this.statusDescription = statusDescription;
      this.responseMessage = responseMessage;
    }

    @Override
    public GrpcStatusCode getStatusCode() {
      return statusCode;
    }

    @Override
    public @Nullable String getStatusDescription() {
      return statusDescription;
    }

    @Override
    public byte[] getResponseMessage() {
      return responseMessage;
    }
  }

  private static final class SenderComponentLoader implements ComponentLoader {
    private final ComponentLoader defaultLoader =
        ComponentLoader.forClassLoader(BuiltInTracingGrpcSender.class.getClassLoader());

    @Override
    public <T> Iterable<T> load(Class<T> type) {
      if (type == GrpcSenderProvider.class) {
        GrpcSenderProvider provider = BuiltInTracingGrpcSender::new;
        return Collections.singletonList(type.cast(provider));
      }
      return defaultLoader.load(type);
    }
  }
}
