/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.trace.v1.stub;

import static com.google.cloud.trace.v1.PagedResponseWrappers.ListTracesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.trace.v1.TraceServiceSettings;
import com.google.devtools.cloudtrace.v1.GetTraceRequest;
import com.google.devtools.cloudtrace.v1.ListTracesRequest;
import com.google.devtools.cloudtrace.v1.ListTracesResponse;
import com.google.devtools.cloudtrace.v1.PatchTracesRequest;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.protobuf.Empty;
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
@BetaApi
public class GrpcTraceServiceStub extends TraceServiceStub {
  private static final UnaryCallable<PatchTracesRequest, Empty> directPatchTracesCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.devtools.cloudtrace.v1.TraceService/PatchTraces",
              io.grpc.protobuf.ProtoUtils.marshaller(PatchTracesRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));
  private static final UnaryCallable<GetTraceRequest, Trace> directGetTraceCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.devtools.cloudtrace.v1.TraceService/GetTrace",
              io.grpc.protobuf.ProtoUtils.marshaller(GetTraceRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Trace.getDefaultInstance())));
  private static final UnaryCallable<ListTracesRequest, ListTracesResponse>
      directListTracesCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.devtools.cloudtrace.v1.TraceService/ListTraces",
                  io.grpc.protobuf.ProtoUtils.marshaller(ListTracesRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(ListTracesResponse.getDefaultInstance())));

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<PatchTracesRequest, Empty> patchTracesCallable;
  private final UnaryCallable<GetTraceRequest, Trace> getTraceCallable;
  private final UnaryCallable<ListTracesRequest, ListTracesResponse> listTracesCallable;
  private final UnaryCallable<ListTracesRequest, ListTracesPagedResponse> listTracesPagedCallable;

  public static final GrpcTraceServiceStub create(TraceServiceSettings settings)
      throws IOException {
    return new GrpcTraceServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTraceServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcTraceServiceStub(TraceServiceSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcTraceServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTraceServiceStub(TraceServiceSettings settings, ClientContext clientContext)
      throws IOException {

    this.patchTracesCallable =
        GrpcCallableFactory.create(
            directPatchTracesCallable, settings.patchTracesSettings(), clientContext);
    this.getTraceCallable =
        GrpcCallableFactory.create(
            directGetTraceCallable, settings.getTraceSettings(), clientContext);
    this.listTracesCallable =
        GrpcCallableFactory.create(
            directListTracesCallable, settings.listTracesSettings(), clientContext);
    this.listTracesPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListTracesCallable, settings.listTracesSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<PatchTracesRequest, Empty> patchTracesCallable() {
    return patchTracesCallable;
  }

  public UnaryCallable<GetTraceRequest, Trace> getTraceCallable() {
    return getTraceCallable;
  }

  public UnaryCallable<ListTracesRequest, ListTracesPagedResponse> listTracesPagedCallable() {
    return listTracesPagedCallable;
  }

  public UnaryCallable<ListTracesRequest, ListTracesResponse> listTracesCallable() {
    return listTracesCallable;
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
