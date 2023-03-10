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
import com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest;
import com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse;
import com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest;
import com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse;
import com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest;
import com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Controller2 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcController2Stub extends Controller2Stub {
  private static final MethodDescriptor<RegisterDebuggeeRequest, RegisterDebuggeeResponse>
      registerDebuggeeMethodDescriptor =
          MethodDescriptor.<RegisterDebuggeeRequest, RegisterDebuggeeResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.devtools.clouddebugger.v2.Controller2/RegisterDebuggee")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RegisterDebuggeeRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RegisterDebuggeeResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListActiveBreakpointsRequest, ListActiveBreakpointsResponse>
      listActiveBreakpointsMethodDescriptor =
          MethodDescriptor.<ListActiveBreakpointsRequest, ListActiveBreakpointsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.clouddebugger.v2.Controller2/ListActiveBreakpoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListActiveBreakpointsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListActiveBreakpointsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          UpdateActiveBreakpointRequest, UpdateActiveBreakpointResponse>
      updateActiveBreakpointMethodDescriptor =
          MethodDescriptor
              .<UpdateActiveBreakpointRequest, UpdateActiveBreakpointResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.clouddebugger.v2.Controller2/UpdateActiveBreakpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateActiveBreakpointRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UpdateActiveBreakpointResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<RegisterDebuggeeRequest, RegisterDebuggeeResponse>
      registerDebuggeeCallable;
  private final UnaryCallable<ListActiveBreakpointsRequest, ListActiveBreakpointsResponse>
      listActiveBreakpointsCallable;
  private final UnaryCallable<UpdateActiveBreakpointRequest, UpdateActiveBreakpointResponse>
      updateActiveBreakpointCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcController2Stub create(Controller2StubSettings settings)
      throws IOException {
    return new GrpcController2Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcController2Stub create(ClientContext clientContext) throws IOException {
    return new GrpcController2Stub(Controller2StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcController2Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcController2Stub(
        Controller2StubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcController2Stub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcController2Stub(Controller2StubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcController2CallableFactory());
  }

  /**
   * Constructs an instance of GrpcController2Stub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcController2Stub(
      Controller2StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<RegisterDebuggeeRequest, RegisterDebuggeeResponse>
        registerDebuggeeTransportSettings =
            GrpcCallSettings.<RegisterDebuggeeRequest, RegisterDebuggeeResponse>newBuilder()
                .setMethodDescriptor(registerDebuggeeMethodDescriptor)
                .build();
    GrpcCallSettings<ListActiveBreakpointsRequest, ListActiveBreakpointsResponse>
        listActiveBreakpointsTransportSettings =
            GrpcCallSettings
                .<ListActiveBreakpointsRequest, ListActiveBreakpointsResponse>newBuilder()
                .setMethodDescriptor(listActiveBreakpointsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("debuggee_id", String.valueOf(request.getDebuggeeId()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateActiveBreakpointRequest, UpdateActiveBreakpointResponse>
        updateActiveBreakpointTransportSettings =
            GrpcCallSettings
                .<UpdateActiveBreakpointRequest, UpdateActiveBreakpointResponse>newBuilder()
                .setMethodDescriptor(updateActiveBreakpointMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("breakpoint.id", String.valueOf(request.getBreakpoint().getId()));
                      params.put("debuggee_id", String.valueOf(request.getDebuggeeId()));
                      return params.build();
                    })
                .build();

    this.registerDebuggeeCallable =
        callableFactory.createUnaryCallable(
            registerDebuggeeTransportSettings, settings.registerDebuggeeSettings(), clientContext);
    this.listActiveBreakpointsCallable =
        callableFactory.createUnaryCallable(
            listActiveBreakpointsTransportSettings,
            settings.listActiveBreakpointsSettings(),
            clientContext);
    this.updateActiveBreakpointCallable =
        callableFactory.createUnaryCallable(
            updateActiveBreakpointTransportSettings,
            settings.updateActiveBreakpointSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<RegisterDebuggeeRequest, RegisterDebuggeeResponse>
      registerDebuggeeCallable() {
    return registerDebuggeeCallable;
  }

  @Override
  public UnaryCallable<ListActiveBreakpointsRequest, ListActiveBreakpointsResponse>
      listActiveBreakpointsCallable() {
    return listActiveBreakpointsCallable;
  }

  @Override
  public UnaryCallable<UpdateActiveBreakpointRequest, UpdateActiveBreakpointResponse>
      updateActiveBreakpointCallable() {
    return updateActiveBreakpointCallable;
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
