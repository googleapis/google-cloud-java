/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.trace.v1.stub;

import static com.google.cloud.trace.v1.TraceServiceClient.ListTracesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.devtools.cloudtrace.v1.GetTraceRequest;
import com.google.devtools.cloudtrace.v1.ListTracesRequest;
import com.google.devtools.cloudtrace.v1.ListTracesResponse;
import com.google.devtools.cloudtrace.v1.PatchTracesRequest;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the TraceService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcTraceServiceStub extends TraceServiceStub {
  private static final MethodDescriptor<ListTracesRequest, ListTracesResponse>
      listTracesMethodDescriptor =
          MethodDescriptor.<ListTracesRequest, ListTracesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.cloudtrace.v1.TraceService/ListTraces")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTracesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListTracesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTraceRequest, Trace> getTraceMethodDescriptor =
      MethodDescriptor.<GetTraceRequest, Trace>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.cloudtrace.v1.TraceService/GetTrace")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTraceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Trace.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<PatchTracesRequest, Empty> patchTracesMethodDescriptor =
      MethodDescriptor.<PatchTracesRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.cloudtrace.v1.TraceService/PatchTraces")
          .setRequestMarshaller(ProtoUtils.marshaller(PatchTracesRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private final UnaryCallable<ListTracesRequest, ListTracesResponse> listTracesCallable;
  private final UnaryCallable<ListTracesRequest, ListTracesPagedResponse> listTracesPagedCallable;
  private final UnaryCallable<GetTraceRequest, Trace> getTraceCallable;
  private final UnaryCallable<PatchTracesRequest, Empty> patchTracesCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTraceServiceStub create(TraceServiceStubSettings settings)
      throws IOException {
    return new GrpcTraceServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTraceServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcTraceServiceStub(TraceServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTraceServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTraceServiceStub(
        TraceServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTraceServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTraceServiceStub(TraceServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcTraceServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTraceServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTraceServiceStub(
      TraceServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListTracesRequest, ListTracesResponse> listTracesTransportSettings =
        GrpcCallSettings.<ListTracesRequest, ListTracesResponse>newBuilder()
            .setMethodDescriptor(listTracesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetTraceRequest, Trace> getTraceTransportSettings =
        GrpcCallSettings.<GetTraceRequest, Trace>newBuilder()
            .setMethodDescriptor(getTraceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("trace_id", String.valueOf(request.getTraceId()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<PatchTracesRequest, Empty> patchTracesTransportSettings =
        GrpcCallSettings.<PatchTracesRequest, Empty>newBuilder()
            .setMethodDescriptor(patchTracesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  return params.build();
                })
            .build();

    this.listTracesCallable =
        callableFactory.createUnaryCallable(
            listTracesTransportSettings, settings.listTracesSettings(), clientContext);
    this.listTracesPagedCallable =
        callableFactory.createPagedCallable(
            listTracesTransportSettings, settings.listTracesSettings(), clientContext);
    this.getTraceCallable =
        callableFactory.createUnaryCallable(
            getTraceTransportSettings, settings.getTraceSettings(), clientContext);
    this.patchTracesCallable =
        callableFactory.createUnaryCallable(
            patchTracesTransportSettings, settings.patchTracesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListTracesRequest, ListTracesResponse> listTracesCallable() {
    return listTracesCallable;
  }

  @Override
  public UnaryCallable<ListTracesRequest, ListTracesPagedResponse> listTracesPagedCallable() {
    return listTracesPagedCallable;
  }

  @Override
  public UnaryCallable<GetTraceRequest, Trace> getTraceCallable() {
    return getTraceCallable;
  }

  @Override
  public UnaryCallable<PatchTracesRequest, Empty> patchTracesCallable() {
    return patchTracesCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
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
