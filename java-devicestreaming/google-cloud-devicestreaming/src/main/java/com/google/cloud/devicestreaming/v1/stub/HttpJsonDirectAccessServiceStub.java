/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.devicestreaming.v1.stub;

import static com.google.cloud.devicestreaming.v1.DirectAccessServiceClient.ListDeviceSessionsPagedResponse;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.devicestreaming.v1.AdbMessage;
import com.google.cloud.devicestreaming.v1.CancelDeviceSessionRequest;
import com.google.cloud.devicestreaming.v1.CreateDeviceSessionRequest;
import com.google.cloud.devicestreaming.v1.DeviceMessage;
import com.google.cloud.devicestreaming.v1.DeviceSession;
import com.google.cloud.devicestreaming.v1.GetDeviceSessionRequest;
import com.google.cloud.devicestreaming.v1.ListDeviceSessionsRequest;
import com.google.cloud.devicestreaming.v1.ListDeviceSessionsResponse;
import com.google.cloud.devicestreaming.v1.UpdateDeviceSessionRequest;
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
 * REST stub implementation for the DirectAccessService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonDirectAccessServiceStub extends DirectAccessServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateDeviceSessionRequest, DeviceSession>
      createDeviceSessionMethodDescriptor =
          ApiMethodDescriptor.<CreateDeviceSessionRequest, DeviceSession>newBuilder()
              .setFullMethodName(
                  "google.cloud.devicestreaming.v1.DirectAccessService/CreateDeviceSession")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDeviceSessionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/deviceSessions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeviceSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeviceSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "deviceSessionId", request.getDeviceSessionId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deviceSession", request.getDeviceSession(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeviceSession>newBuilder()
                      .setDefaultInstance(DeviceSession.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDeviceSessionsRequest, ListDeviceSessionsResponse>
      listDeviceSessionsMethodDescriptor =
          ApiMethodDescriptor.<ListDeviceSessionsRequest, ListDeviceSessionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.devicestreaming.v1.DirectAccessService/ListDeviceSessions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDeviceSessionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/deviceSessions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeviceSessionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeviceSessionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDeviceSessionsResponse>newBuilder()
                      .setDefaultInstance(ListDeviceSessionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDeviceSessionRequest, DeviceSession>
      getDeviceSessionMethodDescriptor =
          ApiMethodDescriptor.<GetDeviceSessionRequest, DeviceSession>newBuilder()
              .setFullMethodName(
                  "google.cloud.devicestreaming.v1.DirectAccessService/GetDeviceSession")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDeviceSessionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/deviceSessions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeviceSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeviceSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeviceSession>newBuilder()
                      .setDefaultInstance(DeviceSession.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CancelDeviceSessionRequest, Empty>
      cancelDeviceSessionMethodDescriptor =
          ApiMethodDescriptor.<CancelDeviceSessionRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.devicestreaming.v1.DirectAccessService/CancelDeviceSession")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CancelDeviceSessionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/deviceSessions/*}:cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CancelDeviceSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CancelDeviceSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDeviceSessionRequest, DeviceSession>
      updateDeviceSessionMethodDescriptor =
          ApiMethodDescriptor.<UpdateDeviceSessionRequest, DeviceSession>newBuilder()
              .setFullMethodName(
                  "google.cloud.devicestreaming.v1.DirectAccessService/UpdateDeviceSession")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDeviceSessionRequest>newBuilder()
                      .setPath(
                          "/v1/{deviceSession.name=projects/*/deviceSessions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeviceSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "deviceSession.name", request.getDeviceSession().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeviceSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deviceSession", request.getDeviceSession(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeviceSession>newBuilder()
                      .setDefaultInstance(DeviceSession.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateDeviceSessionRequest, DeviceSession>
      createDeviceSessionCallable;
  private final UnaryCallable<ListDeviceSessionsRequest, ListDeviceSessionsResponse>
      listDeviceSessionsCallable;
  private final UnaryCallable<ListDeviceSessionsRequest, ListDeviceSessionsPagedResponse>
      listDeviceSessionsPagedCallable;
  private final UnaryCallable<GetDeviceSessionRequest, DeviceSession> getDeviceSessionCallable;
  private final UnaryCallable<CancelDeviceSessionRequest, Empty> cancelDeviceSessionCallable;
  private final UnaryCallable<UpdateDeviceSessionRequest, DeviceSession>
      updateDeviceSessionCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDirectAccessServiceStub create(
      DirectAccessServiceStubSettings settings) throws IOException {
    return new HttpJsonDirectAccessServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDirectAccessServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDirectAccessServiceStub(
        DirectAccessServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDirectAccessServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDirectAccessServiceStub(
        DirectAccessServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDirectAccessServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDirectAccessServiceStub(
      DirectAccessServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDirectAccessServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDirectAccessServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDirectAccessServiceStub(
      DirectAccessServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateDeviceSessionRequest, DeviceSession>
        createDeviceSessionTransportSettings =
            HttpJsonCallSettings.<CreateDeviceSessionRequest, DeviceSession>newBuilder()
                .setMethodDescriptor(createDeviceSessionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDeviceSessionsRequest, ListDeviceSessionsResponse>
        listDeviceSessionsTransportSettings =
            HttpJsonCallSettings.<ListDeviceSessionsRequest, ListDeviceSessionsResponse>newBuilder()
                .setMethodDescriptor(listDeviceSessionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDeviceSessionRequest, DeviceSession> getDeviceSessionTransportSettings =
        HttpJsonCallSettings.<GetDeviceSessionRequest, DeviceSession>newBuilder()
            .setMethodDescriptor(getDeviceSessionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CancelDeviceSessionRequest, Empty> cancelDeviceSessionTransportSettings =
        HttpJsonCallSettings.<CancelDeviceSessionRequest, Empty>newBuilder()
            .setMethodDescriptor(cancelDeviceSessionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateDeviceSessionRequest, DeviceSession>
        updateDeviceSessionTransportSettings =
            HttpJsonCallSettings.<UpdateDeviceSessionRequest, DeviceSession>newBuilder()
                .setMethodDescriptor(updateDeviceSessionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "device_session.name",
                          String.valueOf(request.getDeviceSession().getName()));
                      return builder.build();
                    })
                .build();

    this.createDeviceSessionCallable =
        callableFactory.createUnaryCallable(
            createDeviceSessionTransportSettings,
            settings.createDeviceSessionSettings(),
            clientContext);
    this.listDeviceSessionsCallable =
        callableFactory.createUnaryCallable(
            listDeviceSessionsTransportSettings,
            settings.listDeviceSessionsSettings(),
            clientContext);
    this.listDeviceSessionsPagedCallable =
        callableFactory.createPagedCallable(
            listDeviceSessionsTransportSettings,
            settings.listDeviceSessionsSettings(),
            clientContext);
    this.getDeviceSessionCallable =
        callableFactory.createUnaryCallable(
            getDeviceSessionTransportSettings, settings.getDeviceSessionSettings(), clientContext);
    this.cancelDeviceSessionCallable =
        callableFactory.createUnaryCallable(
            cancelDeviceSessionTransportSettings,
            settings.cancelDeviceSessionSettings(),
            clientContext);
    this.updateDeviceSessionCallable =
        callableFactory.createUnaryCallable(
            updateDeviceSessionTransportSettings,
            settings.updateDeviceSessionSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createDeviceSessionMethodDescriptor);
    methodDescriptors.add(listDeviceSessionsMethodDescriptor);
    methodDescriptors.add(getDeviceSessionMethodDescriptor);
    methodDescriptors.add(cancelDeviceSessionMethodDescriptor);
    methodDescriptors.add(updateDeviceSessionMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateDeviceSessionRequest, DeviceSession> createDeviceSessionCallable() {
    return createDeviceSessionCallable;
  }

  @Override
  public UnaryCallable<ListDeviceSessionsRequest, ListDeviceSessionsResponse>
      listDeviceSessionsCallable() {
    return listDeviceSessionsCallable;
  }

  @Override
  public UnaryCallable<ListDeviceSessionsRequest, ListDeviceSessionsPagedResponse>
      listDeviceSessionsPagedCallable() {
    return listDeviceSessionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDeviceSessionRequest, DeviceSession> getDeviceSessionCallable() {
    return getDeviceSessionCallable;
  }

  @Override
  public UnaryCallable<CancelDeviceSessionRequest, Empty> cancelDeviceSessionCallable() {
    return cancelDeviceSessionCallable;
  }

  @Override
  public UnaryCallable<UpdateDeviceSessionRequest, DeviceSession> updateDeviceSessionCallable() {
    return updateDeviceSessionCallable;
  }

  @Override
  public BidiStreamingCallable<AdbMessage, DeviceMessage> adbConnectCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: adbConnectCallable(). REST transport is not implemented for this method yet.");
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
