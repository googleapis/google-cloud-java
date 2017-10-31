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
import com.google.api.gax.grpc.GrpcCallSettings;
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
@BetaApi
public class GrpcTraceServiceStub extends TraceServiceStub {

  private static final MethodDescriptor<PatchTracesRequest, Empty> patchTracesMethodDescriptor =
      MethodDescriptor.<PatchTracesRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.cloudtrace.v1.TraceService/PatchTraces")
          .setRequestMarshaller(ProtoUtils.marshaller(PatchTracesRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<GetTraceRequest, Trace> getTraceMethodDescriptor =
      MethodDescriptor.<GetTraceRequest, Trace>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.cloudtrace.v1.TraceService/GetTrace")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTraceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Trace.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListTracesRequest, ListTracesResponse>
      listTracesMethodDescriptor =
          MethodDescriptor.<ListTracesRequest, ListTracesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.cloudtrace.v1.TraceService/ListTraces")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTracesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListTracesResponse.getDefaultInstance()))
              .build();

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

    GrpcCallSettings<PatchTracesRequest, Empty> patchTracesTransportSettings =
        GrpcCallSettings.<PatchTracesRequest, Empty>newBuilder()
            .setMethodDescriptor(patchTracesMethodDescriptor)
            .build();
    GrpcCallSettings<GetTraceRequest, Trace> getTraceTransportSettings =
        GrpcCallSettings.<GetTraceRequest, Trace>newBuilder()
            .setMethodDescriptor(getTraceMethodDescriptor)
            .build();
    GrpcCallSettings<ListTracesRequest, ListTracesResponse> listTracesTransportSettings =
        GrpcCallSettings.<ListTracesRequest, ListTracesResponse>newBuilder()
            .setMethodDescriptor(listTracesMethodDescriptor)
            .build();

    this.patchTracesCallable =
        GrpcCallableFactory.createUnaryCallable(
            patchTracesTransportSettings, settings.patchTracesSettings(), clientContext);
    this.getTraceCallable =
        GrpcCallableFactory.createUnaryCallable(
            getTraceTransportSettings, settings.getTraceSettings(), clientContext);
    this.listTracesCallable =
        GrpcCallableFactory.createUnaryCallable(
            listTracesTransportSettings, settings.listTracesSettings(), clientContext);
    this.listTracesPagedCallable =
        GrpcCallableFactory.createPagedCallable(
            listTracesTransportSettings, settings.listTracesSettings(), clientContext);

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
