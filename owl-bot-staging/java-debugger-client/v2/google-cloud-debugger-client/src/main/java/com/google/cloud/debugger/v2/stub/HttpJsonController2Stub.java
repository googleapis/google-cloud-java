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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest;
import com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse;
import com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest;
import com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse;
import com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest;
import com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Controller2 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonController2Stub extends Controller2Stub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<RegisterDebuggeeRequest, RegisterDebuggeeResponse>
      registerDebuggeeMethodDescriptor =
          ApiMethodDescriptor.<RegisterDebuggeeRequest, RegisterDebuggeeResponse>newBuilder()
              .setFullMethodName("google.devtools.clouddebugger.v2.Controller2/RegisterDebuggee")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RegisterDebuggeeRequest>newBuilder()
                      .setPath(
                          "/v2/controller/debuggees/register",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RegisterDebuggeeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RegisterDebuggeeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RegisterDebuggeeResponse>newBuilder()
                      .setDefaultInstance(RegisterDebuggeeResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListActiveBreakpointsRequest, ListActiveBreakpointsResponse>
      listActiveBreakpointsMethodDescriptor =
          ApiMethodDescriptor
              .<ListActiveBreakpointsRequest, ListActiveBreakpointsResponse>newBuilder()
              .setFullMethodName(
                  "google.devtools.clouddebugger.v2.Controller2/ListActiveBreakpoints")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListActiveBreakpointsRequest>newBuilder()
                      .setPath(
                          "/v2/controller/debuggees/{debuggeeId}/breakpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListActiveBreakpointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "debuggeeId", request.getDebuggeeId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListActiveBreakpointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "successOnTimeout", request.getSuccessOnTimeout());
                            serializer.putQueryParam(fields, "waitToken", request.getWaitToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListActiveBreakpointsResponse>newBuilder()
                      .setDefaultInstance(ListActiveBreakpointsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateActiveBreakpointRequest, UpdateActiveBreakpointResponse>
      updateActiveBreakpointMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateActiveBreakpointRequest, UpdateActiveBreakpointResponse>newBuilder()
              .setFullMethodName(
                  "google.devtools.clouddebugger.v2.Controller2/UpdateActiveBreakpoint")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateActiveBreakpointRequest>newBuilder()
                      .setPath(
                          "/v2/controller/debuggees/{debuggeeId}/breakpoints/{breakpoint.id}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateActiveBreakpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "breakpoint.id", request.getBreakpoint().getId());
                            serializer.putPathParam(fields, "debuggeeId", request.getDebuggeeId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateActiveBreakpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearDebuggeeId().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UpdateActiveBreakpointResponse>newBuilder()
                      .setDefaultInstance(UpdateActiveBreakpointResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<RegisterDebuggeeRequest, RegisterDebuggeeResponse>
      registerDebuggeeCallable;
  private final UnaryCallable<ListActiveBreakpointsRequest, ListActiveBreakpointsResponse>
      listActiveBreakpointsCallable;
  private final UnaryCallable<UpdateActiveBreakpointRequest, UpdateActiveBreakpointResponse>
      updateActiveBreakpointCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonController2Stub create(Controller2StubSettings settings)
      throws IOException {
    return new HttpJsonController2Stub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonController2Stub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonController2Stub(
        Controller2StubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonController2Stub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonController2Stub(
        Controller2StubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonController2Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonController2Stub(Controller2StubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonController2CallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonController2Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonController2Stub(
      Controller2StubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<RegisterDebuggeeRequest, RegisterDebuggeeResponse>
        registerDebuggeeTransportSettings =
            HttpJsonCallSettings.<RegisterDebuggeeRequest, RegisterDebuggeeResponse>newBuilder()
                .setMethodDescriptor(registerDebuggeeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListActiveBreakpointsRequest, ListActiveBreakpointsResponse>
        listActiveBreakpointsTransportSettings =
            HttpJsonCallSettings
                .<ListActiveBreakpointsRequest, ListActiveBreakpointsResponse>newBuilder()
                .setMethodDescriptor(listActiveBreakpointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateActiveBreakpointRequest, UpdateActiveBreakpointResponse>
        updateActiveBreakpointTransportSettings =
            HttpJsonCallSettings
                .<UpdateActiveBreakpointRequest, UpdateActiveBreakpointResponse>newBuilder()
                .setMethodDescriptor(updateActiveBreakpointMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(registerDebuggeeMethodDescriptor);
    methodDescriptors.add(listActiveBreakpointsMethodDescriptor);
    methodDescriptors.add(updateActiveBreakpointMethodDescriptor);
    return methodDescriptors;
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
