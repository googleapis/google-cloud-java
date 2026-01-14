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

import static com.google.ads.admanager.v1.MobileDeviceServiceClient.ListMobileDevicesPagedResponse;

import com.google.ads.admanager.v1.GetMobileDeviceRequest;
import com.google.ads.admanager.v1.ListMobileDevicesRequest;
import com.google.ads.admanager.v1.ListMobileDevicesResponse;
import com.google.ads.admanager.v1.MobileDevice;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the MobileDeviceService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonMobileDeviceServiceStub extends MobileDeviceServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetMobileDeviceRequest, MobileDevice>
      getMobileDeviceMethodDescriptor =
          ApiMethodDescriptor.<GetMobileDeviceRequest, MobileDevice>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.MobileDeviceService/GetMobileDevice")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMobileDeviceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/mobileDevices/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMobileDeviceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMobileDeviceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MobileDevice>newBuilder()
                      .setDefaultInstance(MobileDevice.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListMobileDevicesRequest, ListMobileDevicesResponse>
      listMobileDevicesMethodDescriptor =
          ApiMethodDescriptor.<ListMobileDevicesRequest, ListMobileDevicesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.MobileDeviceService/ListMobileDevices")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMobileDevicesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/mobileDevices",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMobileDevicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMobileDevicesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListMobileDevicesResponse>newBuilder()
                      .setDefaultInstance(ListMobileDevicesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetMobileDeviceRequest, MobileDevice> getMobileDeviceCallable;
  private final UnaryCallable<ListMobileDevicesRequest, ListMobileDevicesResponse>
      listMobileDevicesCallable;
  private final UnaryCallable<ListMobileDevicesRequest, ListMobileDevicesPagedResponse>
      listMobileDevicesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonMobileDeviceServiceStub create(
      MobileDeviceServiceStubSettings settings) throws IOException {
    return new HttpJsonMobileDeviceServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonMobileDeviceServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonMobileDeviceServiceStub(
        MobileDeviceServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonMobileDeviceServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMobileDeviceServiceStub(
        MobileDeviceServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMobileDeviceServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMobileDeviceServiceStub(
      MobileDeviceServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonMobileDeviceServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMobileDeviceServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMobileDeviceServiceStub(
      MobileDeviceServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetMobileDeviceRequest, MobileDevice> getMobileDeviceTransportSettings =
        HttpJsonCallSettings.<GetMobileDeviceRequest, MobileDevice>newBuilder()
            .setMethodDescriptor(getMobileDeviceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListMobileDevicesRequest, ListMobileDevicesResponse>
        listMobileDevicesTransportSettings =
            HttpJsonCallSettings.<ListMobileDevicesRequest, ListMobileDevicesResponse>newBuilder()
                .setMethodDescriptor(listMobileDevicesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getMobileDeviceCallable =
        callableFactory.createUnaryCallable(
            getMobileDeviceTransportSettings, settings.getMobileDeviceSettings(), clientContext);
    this.listMobileDevicesCallable =
        callableFactory.createUnaryCallable(
            listMobileDevicesTransportSettings,
            settings.listMobileDevicesSettings(),
            clientContext);
    this.listMobileDevicesPagedCallable =
        callableFactory.createPagedCallable(
            listMobileDevicesTransportSettings,
            settings.listMobileDevicesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getMobileDeviceMethodDescriptor);
    methodDescriptors.add(listMobileDevicesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetMobileDeviceRequest, MobileDevice> getMobileDeviceCallable() {
    return getMobileDeviceCallable;
  }

  @Override
  public UnaryCallable<ListMobileDevicesRequest, ListMobileDevicesResponse>
      listMobileDevicesCallable() {
    return listMobileDevicesCallable;
  }

  @Override
  public UnaryCallable<ListMobileDevicesRequest, ListMobileDevicesPagedResponse>
      listMobileDevicesPagedCallable() {
    return listMobileDevicesPagedCallable;
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
