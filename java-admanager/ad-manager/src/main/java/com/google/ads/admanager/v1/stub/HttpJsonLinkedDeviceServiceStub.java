/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.LinkedDeviceServiceClient.ListLinkedDevicesPagedResponse;

import com.google.ads.admanager.v1.GetLinkedDeviceRequest;
import com.google.ads.admanager.v1.LinkedDevice;
import com.google.ads.admanager.v1.ListLinkedDevicesRequest;
import com.google.ads.admanager.v1.ListLinkedDevicesResponse;
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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the LinkedDeviceService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonLinkedDeviceServiceStub extends LinkedDeviceServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetLinkedDeviceRequest, LinkedDevice>
      getLinkedDeviceMethodDescriptor =
          ApiMethodDescriptor.<GetLinkedDeviceRequest, LinkedDevice>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LinkedDeviceService/GetLinkedDevice")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLinkedDeviceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/linkedDevices/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLinkedDeviceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLinkedDeviceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LinkedDevice>newBuilder()
                      .setDefaultInstance(LinkedDevice.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLinkedDevicesRequest, ListLinkedDevicesResponse>
      listLinkedDevicesMethodDescriptor =
          ApiMethodDescriptor.<ListLinkedDevicesRequest, ListLinkedDevicesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LinkedDeviceService/ListLinkedDevices")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLinkedDevicesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/linkedDevices",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLinkedDevicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLinkedDevicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "skip", request.getSkip());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLinkedDevicesResponse>newBuilder()
                      .setDefaultInstance(ListLinkedDevicesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetLinkedDeviceRequest, LinkedDevice> getLinkedDeviceCallable;
  private final UnaryCallable<ListLinkedDevicesRequest, ListLinkedDevicesResponse>
      listLinkedDevicesCallable;
  private final UnaryCallable<ListLinkedDevicesRequest, ListLinkedDevicesPagedResponse>
      listLinkedDevicesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLinkedDeviceServiceStub create(
      LinkedDeviceServiceStubSettings settings) throws IOException {
    return new HttpJsonLinkedDeviceServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLinkedDeviceServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLinkedDeviceServiceStub(
        LinkedDeviceServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonLinkedDeviceServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLinkedDeviceServiceStub(
        LinkedDeviceServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLinkedDeviceServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLinkedDeviceServiceStub(
      LinkedDeviceServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonLinkedDeviceServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLinkedDeviceServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLinkedDeviceServiceStub(
      LinkedDeviceServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetLinkedDeviceRequest, LinkedDevice> getLinkedDeviceTransportSettings =
        HttpJsonCallSettings.<GetLinkedDeviceRequest, LinkedDevice>newBuilder()
            .setMethodDescriptor(getLinkedDeviceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListLinkedDevicesRequest, ListLinkedDevicesResponse>
        listLinkedDevicesTransportSettings =
            HttpJsonCallSettings.<ListLinkedDevicesRequest, ListLinkedDevicesResponse>newBuilder()
                .setMethodDescriptor(listLinkedDevicesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getLinkedDeviceCallable =
        callableFactory.createUnaryCallable(
            getLinkedDeviceTransportSettings, settings.getLinkedDeviceSettings(), clientContext);
    this.listLinkedDevicesCallable =
        callableFactory.createUnaryCallable(
            listLinkedDevicesTransportSettings,
            settings.listLinkedDevicesSettings(),
            clientContext);
    this.listLinkedDevicesPagedCallable =
        callableFactory.createPagedCallable(
            listLinkedDevicesTransportSettings,
            settings.listLinkedDevicesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getLinkedDeviceMethodDescriptor);
    methodDescriptors.add(listLinkedDevicesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetLinkedDeviceRequest, LinkedDevice> getLinkedDeviceCallable() {
    return getLinkedDeviceCallable;
  }

  @Override
  public UnaryCallable<ListLinkedDevicesRequest, ListLinkedDevicesResponse>
      listLinkedDevicesCallable() {
    return listLinkedDevicesCallable;
  }

  @Override
  public UnaryCallable<ListLinkedDevicesRequest, ListLinkedDevicesPagedResponse>
      listLinkedDevicesPagedCallable() {
    return listLinkedDevicesPagedCallable;
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
