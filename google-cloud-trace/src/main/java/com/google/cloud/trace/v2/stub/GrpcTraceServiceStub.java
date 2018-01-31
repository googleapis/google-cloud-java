/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.trace.v2.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest;
import com.google.devtools.cloudtrace.v2.Span;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Stackdriver Trace API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcTraceServiceStub extends TraceServiceStub {

  private static final MethodDescriptor<BatchWriteSpansRequest, Empty>
      batchWriteSpansMethodDescriptor =
          MethodDescriptor.<BatchWriteSpansRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.cloudtrace.v2.TraceService/BatchWriteSpans")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchWriteSpansRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<Span, Span> createSpanMethodDescriptor =
      MethodDescriptor.<Span, Span>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.cloudtrace.v2.TraceService/CreateSpan")
          .setRequestMarshaller(ProtoUtils.marshaller(Span.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Span.getDefaultInstance()))
          .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<BatchWriteSpansRequest, Empty> batchWriteSpansCallable;
  private final UnaryCallable<Span, Span> createSpanCallable;

  public static final GrpcTraceServiceStub create(TraceServiceStubSettings settings)
      throws IOException {
    return new GrpcTraceServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTraceServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcTraceServiceStub(TraceServiceStubSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcTraceServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTraceServiceStub(TraceServiceStubSettings settings, ClientContext clientContext)
      throws IOException {

    GrpcCallSettings<BatchWriteSpansRequest, Empty> batchWriteSpansTransportSettings =
        GrpcCallSettings.<BatchWriteSpansRequest, Empty>newBuilder()
            .setMethodDescriptor(batchWriteSpansMethodDescriptor)
            .build();
    GrpcCallSettings<Span, Span> createSpanTransportSettings =
        GrpcCallSettings.<Span, Span>newBuilder()
            .setMethodDescriptor(createSpanMethodDescriptor)
            .build();

    this.batchWriteSpansCallable =
        GrpcCallableFactory.createUnaryCallable(
            batchWriteSpansTransportSettings, settings.batchWriteSpansSettings(), clientContext);
    this.createSpanCallable =
        GrpcCallableFactory.createUnaryCallable(
            createSpanTransportSettings, settings.createSpanSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<BatchWriteSpansRequest, Empty> batchWriteSpansCallable() {
    return batchWriteSpansCallable;
  }

  public UnaryCallable<Span, Span> createSpanCallable() {
    return createSpanCallable;
  }

  @Override
  public final void close() throws Exception {
    shutdown();
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
