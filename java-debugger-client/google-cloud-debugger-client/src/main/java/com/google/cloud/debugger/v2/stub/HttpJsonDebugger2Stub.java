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
import com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest;
import com.google.devtools.clouddebugger.v2.GetBreakpointRequest;
import com.google.devtools.clouddebugger.v2.GetBreakpointResponse;
import com.google.devtools.clouddebugger.v2.ListBreakpointsRequest;
import com.google.devtools.clouddebugger.v2.ListBreakpointsResponse;
import com.google.devtools.clouddebugger.v2.ListDebuggeesRequest;
import com.google.devtools.clouddebugger.v2.ListDebuggeesResponse;
import com.google.devtools.clouddebugger.v2.SetBreakpointRequest;
import com.google.devtools.clouddebugger.v2.SetBreakpointResponse;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the Debugger2 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonDebugger2Stub extends Debugger2Stub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<SetBreakpointRequest, SetBreakpointResponse>
      setBreakpointMethodDescriptor =
          ApiMethodDescriptor.<SetBreakpointRequest, SetBreakpointResponse>newBuilder()
              .setFullMethodName("google.devtools.clouddebugger.v2.Debugger2/SetBreakpoint")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetBreakpointRequest>newBuilder()
                      .setPath(
                          "/v2/debugger/debuggees/{debuggeeId}/breakpoints/set",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetBreakpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "debuggeeId", request.getDebuggeeId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetBreakpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "clientVersion", request.getClientVersion());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("breakpoint", request.getBreakpoint(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SetBreakpointResponse>newBuilder()
                      .setDefaultInstance(SetBreakpointResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetBreakpointRequest, GetBreakpointResponse>
      getBreakpointMethodDescriptor =
          ApiMethodDescriptor.<GetBreakpointRequest, GetBreakpointResponse>newBuilder()
              .setFullMethodName("google.devtools.clouddebugger.v2.Debugger2/GetBreakpoint")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBreakpointRequest>newBuilder()
                      .setPath(
                          "/v2/debugger/debuggees/{debuggeeId}/breakpoints/{breakpointId}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBreakpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "breakpointId", request.getBreakpointId());
                            serializer.putPathParam(fields, "debuggeeId", request.getDebuggeeId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBreakpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "clientVersion", request.getClientVersion());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GetBreakpointResponse>newBuilder()
                      .setDefaultInstance(GetBreakpointResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteBreakpointRequest, Empty>
      deleteBreakpointMethodDescriptor =
          ApiMethodDescriptor.<DeleteBreakpointRequest, Empty>newBuilder()
              .setFullMethodName("google.devtools.clouddebugger.v2.Debugger2/DeleteBreakpoint")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBreakpointRequest>newBuilder()
                      .setPath(
                          "/v2/debugger/debuggees/{debuggeeId}/breakpoints/{breakpointId}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBreakpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "breakpointId", request.getBreakpointId());
                            serializer.putPathParam(fields, "debuggeeId", request.getDebuggeeId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBreakpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "clientVersion", request.getClientVersion());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListBreakpointsRequest, ListBreakpointsResponse>
      listBreakpointsMethodDescriptor =
          ApiMethodDescriptor.<ListBreakpointsRequest, ListBreakpointsResponse>newBuilder()
              .setFullMethodName("google.devtools.clouddebugger.v2.Debugger2/ListBreakpoints")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBreakpointsRequest>newBuilder()
                      .setPath(
                          "/v2/debugger/debuggees/{debuggeeId}/breakpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBreakpointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "debuggeeId", request.getDebuggeeId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBreakpointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "action", request.getAction());
                            serializer.putQueryParam(
                                fields, "clientVersion", request.getClientVersion());
                            serializer.putQueryParam(
                                fields, "includeAllUsers", request.getIncludeAllUsers());
                            serializer.putQueryParam(
                                fields, "includeInactive", request.getIncludeInactive());
                            serializer.putQueryParam(
                                fields, "stripResults", request.getStripResults());
                            serializer.putQueryParam(fields, "waitToken", request.getWaitToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBreakpointsResponse>newBuilder()
                      .setDefaultInstance(ListBreakpointsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDebuggeesRequest, ListDebuggeesResponse>
      listDebuggeesMethodDescriptor =
          ApiMethodDescriptor.<ListDebuggeesRequest, ListDebuggeesResponse>newBuilder()
              .setFullMethodName("google.devtools.clouddebugger.v2.Debugger2/ListDebuggees")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDebuggeesRequest>newBuilder()
                      .setPath(
                          "/v2/debugger/debuggees",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDebuggeesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDebuggeesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "clientVersion", request.getClientVersion());
                            serializer.putQueryParam(
                                fields, "includeInactive", request.getIncludeInactive());
                            serializer.putQueryParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDebuggeesResponse>newBuilder()
                      .setDefaultInstance(ListDebuggeesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<SetBreakpointRequest, SetBreakpointResponse> setBreakpointCallable;
  private final UnaryCallable<GetBreakpointRequest, GetBreakpointResponse> getBreakpointCallable;
  private final UnaryCallable<DeleteBreakpointRequest, Empty> deleteBreakpointCallable;
  private final UnaryCallable<ListBreakpointsRequest, ListBreakpointsResponse>
      listBreakpointsCallable;
  private final UnaryCallable<ListDebuggeesRequest, ListDebuggeesResponse> listDebuggeesCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDebugger2Stub create(Debugger2StubSettings settings)
      throws IOException {
    return new HttpJsonDebugger2Stub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDebugger2Stub create(ClientContext clientContext) throws IOException {
    return new HttpJsonDebugger2Stub(
        Debugger2StubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDebugger2Stub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDebugger2Stub(
        Debugger2StubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDebugger2Stub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDebugger2Stub(Debugger2StubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDebugger2CallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDebugger2Stub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDebugger2Stub(
      Debugger2StubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<SetBreakpointRequest, SetBreakpointResponse>
        setBreakpointTransportSettings =
            HttpJsonCallSettings.<SetBreakpointRequest, SetBreakpointResponse>newBuilder()
                .setMethodDescriptor(setBreakpointMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetBreakpointRequest, GetBreakpointResponse>
        getBreakpointTransportSettings =
            HttpJsonCallSettings.<GetBreakpointRequest, GetBreakpointResponse>newBuilder()
                .setMethodDescriptor(getBreakpointMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteBreakpointRequest, Empty> deleteBreakpointTransportSettings =
        HttpJsonCallSettings.<DeleteBreakpointRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBreakpointMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListBreakpointsRequest, ListBreakpointsResponse>
        listBreakpointsTransportSettings =
            HttpJsonCallSettings.<ListBreakpointsRequest, ListBreakpointsResponse>newBuilder()
                .setMethodDescriptor(listBreakpointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListDebuggeesRequest, ListDebuggeesResponse>
        listDebuggeesTransportSettings =
            HttpJsonCallSettings.<ListDebuggeesRequest, ListDebuggeesResponse>newBuilder()
                .setMethodDescriptor(listDebuggeesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(setBreakpointMethodDescriptor);
    methodDescriptors.add(getBreakpointMethodDescriptor);
    methodDescriptors.add(deleteBreakpointMethodDescriptor);
    methodDescriptors.add(listBreakpointsMethodDescriptor);
    methodDescriptors.add(listDebuggeesMethodDescriptor);
    return methodDescriptors;
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
