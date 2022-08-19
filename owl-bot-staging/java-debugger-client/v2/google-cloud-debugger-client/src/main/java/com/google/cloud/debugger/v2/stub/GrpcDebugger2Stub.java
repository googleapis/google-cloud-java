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

package com.google.cloud.debugger.v2.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest;
import com.google.devtools.clouddebugger.v2.GetBreakpointRequest;
import com.google.devtools.clouddebugger.v2.GetBreakpointResponse;
import com.google.devtools.clouddebugger.v2.ListBreakpointsRequest;
import com.google.devtools.clouddebugger.v2.ListBreakpointsResponse;
import com.google.devtools.clouddebugger.v2.ListDebuggeesRequest;
import com.google.devtools.clouddebugger.v2.ListDebuggeesResponse;
import com.google.devtools.clouddebugger.v2.SetBreakpointRequest;
import com.google.devtools.clouddebugger.v2.SetBreakpointResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Debugger2 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDebugger2Stub extends Debugger2Stub {
  private static final MethodDescriptor<SetBreakpointRequest, SetBreakpointResponse>
      setBreakpointMethodDescriptor =
          MethodDescriptor.<SetBreakpointRequest, SetBreakpointResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.clouddebugger.v2.Debugger2/SetBreakpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetBreakpointRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SetBreakpointResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBreakpointRequest, GetBreakpointResponse>
      getBreakpointMethodDescriptor =
          MethodDescriptor.<GetBreakpointRequest, GetBreakpointResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.clouddebugger.v2.Debugger2/GetBreakpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBreakpointRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GetBreakpointResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteBreakpointRequest, Empty>
      deleteBreakpointMethodDescriptor =
          MethodDescriptor.<DeleteBreakpointRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.clouddebugger.v2.Debugger2/DeleteBreakpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBreakpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListBreakpointsRequest, ListBreakpointsResponse>
      listBreakpointsMethodDescriptor =
          MethodDescriptor.<ListBreakpointsRequest, ListBreakpointsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.clouddebugger.v2.Debugger2/ListBreakpoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBreakpointsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBreakpointsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDebuggeesRequest, ListDebuggeesResponse>
      listDebuggeesMethodDescriptor =
          MethodDescriptor.<ListDebuggeesRequest, ListDebuggeesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.clouddebugger.v2.Debugger2/ListDebuggees")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDebuggeesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDebuggeesResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<SetBreakpointRequest, SetBreakpointResponse> setBreakpointCallable;
  private final UnaryCallable<GetBreakpointRequest, GetBreakpointResponse> getBreakpointCallable;
  private final UnaryCallable<DeleteBreakpointRequest, Empty> deleteBreakpointCallable;
  private final UnaryCallable<ListBreakpointsRequest, ListBreakpointsResponse>
      listBreakpointsCallable;
  private final UnaryCallable<ListDebuggeesRequest, ListDebuggeesResponse> listDebuggeesCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDebugger2Stub create(Debugger2StubSettings settings) throws IOException {
    return new GrpcDebugger2Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcDebugger2Stub create(ClientContext clientContext) throws IOException {
    return new GrpcDebugger2Stub(Debugger2StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDebugger2Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDebugger2Stub(
        Debugger2StubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDebugger2Stub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDebugger2Stub(Debugger2StubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDebugger2CallableFactory());
  }

  /**
   * Constructs an instance of GrpcDebugger2Stub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDebugger2Stub(
      Debugger2StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SetBreakpointRequest, SetBreakpointResponse> setBreakpointTransportSettings =
        GrpcCallSettings.<SetBreakpointRequest, SetBreakpointResponse>newBuilder()
            .setMethodDescriptor(setBreakpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("debuggee_id", String.valueOf(request.getDebuggeeId()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetBreakpointRequest, GetBreakpointResponse> getBreakpointTransportSettings =
        GrpcCallSettings.<GetBreakpointRequest, GetBreakpointResponse>newBuilder()
            .setMethodDescriptor(getBreakpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("breakpoint_id", String.valueOf(request.getBreakpointId()));
                  params.put("debuggee_id", String.valueOf(request.getDebuggeeId()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteBreakpointRequest, Empty> deleteBreakpointTransportSettings =
        GrpcCallSettings.<DeleteBreakpointRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBreakpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("breakpoint_id", String.valueOf(request.getBreakpointId()));
                  params.put("debuggee_id", String.valueOf(request.getDebuggeeId()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListBreakpointsRequest, ListBreakpointsResponse>
        listBreakpointsTransportSettings =
            GrpcCallSettings.<ListBreakpointsRequest, ListBreakpointsResponse>newBuilder()
                .setMethodDescriptor(listBreakpointsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("debuggee_id", String.valueOf(request.getDebuggeeId()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListDebuggeesRequest, ListDebuggeesResponse> listDebuggeesTransportSettings =
        GrpcCallSettings.<ListDebuggeesRequest, ListDebuggeesResponse>newBuilder()
            .setMethodDescriptor(listDebuggeesMethodDescriptor)
            .build();

    this.setBreakpointCallable =
        callableFactory.createUnaryCallable(
            setBreakpointTransportSettings, settings.setBreakpointSettings(), clientContext);
    this.getBreakpointCallable =
        callableFactory.createUnaryCallable(
            getBreakpointTransportSettings, settings.getBreakpointSettings(), clientContext);
    this.deleteBreakpointCallable =
        callableFactory.createUnaryCallable(
            deleteBreakpointTransportSettings, settings.deleteBreakpointSettings(), clientContext);
    this.listBreakpointsCallable =
        callableFactory.createUnaryCallable(
            listBreakpointsTransportSettings, settings.listBreakpointsSettings(), clientContext);
    this.listDebuggeesCallable =
        callableFactory.createUnaryCallable(
            listDebuggeesTransportSettings, settings.listDebuggeesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<SetBreakpointRequest, SetBreakpointResponse> setBreakpointCallable() {
    return setBreakpointCallable;
  }

  @Override
  public UnaryCallable<GetBreakpointRequest, GetBreakpointResponse> getBreakpointCallable() {
    return getBreakpointCallable;
  }

  @Override
  public UnaryCallable<DeleteBreakpointRequest, Empty> deleteBreakpointCallable() {
    return deleteBreakpointCallable;
  }

  @Override
  public UnaryCallable<ListBreakpointsRequest, ListBreakpointsResponse> listBreakpointsCallable() {
    return listBreakpointsCallable;
  }

  @Override
  public UnaryCallable<ListDebuggeesRequest, ListDebuggeesResponse> listDebuggeesCallable() {
    return listDebuggeesCallable;
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
