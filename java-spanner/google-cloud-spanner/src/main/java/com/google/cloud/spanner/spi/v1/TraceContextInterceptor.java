/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.spanner.spi.v1;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.TextMapPropagator;
import io.opentelemetry.context.propagation.TextMapSetter;

/**
 * Intercepts all gRPC calls and injects trace context related headers to propagate trace context to
 * Spanner. This class takes reference from OpenTelemetry's JAVA instrumentation library for gRPC.
 * https://github.com/open-telemetry/opentelemetry-java-instrumentation/blob/9ecf7965aa455d41ea8cc0761b6c6b6eeb106324/instrumentation/grpc-1.6/library/src/main/java/io/opentelemetry/instrumentation/grpc/v1_6/TracingClientInterceptor.java#L27
 */
public class TraceContextInterceptor implements ClientInterceptor {

  private final TextMapPropagator textMapPropagator;

  public TraceContextInterceptor(OpenTelemetry openTelemetry) {
    this.textMapPropagator = openTelemetry.getPropagators().getTextMapPropagator();
  }

  enum MetadataSetter implements TextMapSetter<Metadata> {
    INSTANCE;

    @SuppressWarnings("null")
    @Override
    public void set(Metadata carrier, String key, String value) {
      carrier.put(Metadata.Key.of(key, Metadata.ASCII_STRING_MARSHALLER), value);
    }
  }

  private static final class NoopSimpleForwardingClientCallListener<RespT>
      extends SimpleForwardingClientCallListener<RespT> {
    public NoopSimpleForwardingClientCallListener(ClientCall.Listener<RespT> responseListener) {
      super(responseListener);
    }
  }

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
    return new SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
      @Override
      public void start(Listener<RespT> responseListener, Metadata headers) {
        Context parentContext = Context.current();
        textMapPropagator.inject(parentContext, headers, MetadataSetter.INSTANCE);
        super.start(new NoopSimpleForwardingClientCallListener<RespT>(responseListener), headers);
      }
    };
  }
}
