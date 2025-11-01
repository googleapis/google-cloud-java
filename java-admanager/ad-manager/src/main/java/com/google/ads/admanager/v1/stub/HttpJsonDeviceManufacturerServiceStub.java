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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.DeviceManufacturerServiceClient.ListDeviceManufacturersPagedResponse;

import com.google.ads.admanager.v1.DeviceManufacturer;
import com.google.ads.admanager.v1.GetDeviceManufacturerRequest;
import com.google.ads.admanager.v1.ListDeviceManufacturersRequest;
import com.google.ads.admanager.v1.ListDeviceManufacturersResponse;
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
 * REST stub implementation for the DeviceManufacturerService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonDeviceManufacturerServiceStub extends DeviceManufacturerServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetDeviceManufacturerRequest, DeviceManufacturer>
      getDeviceManufacturerMethodDescriptor =
          ApiMethodDescriptor.<GetDeviceManufacturerRequest, DeviceManufacturer>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DeviceManufacturerService/GetDeviceManufacturer")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDeviceManufacturerRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/deviceManufacturers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeviceManufacturerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeviceManufacturerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeviceManufacturer>newBuilder()
                      .setDefaultInstance(DeviceManufacturer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDeviceManufacturersRequest, ListDeviceManufacturersResponse>
      listDeviceManufacturersMethodDescriptor =
          ApiMethodDescriptor
              .<ListDeviceManufacturersRequest, ListDeviceManufacturersResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DeviceManufacturerService/ListDeviceManufacturers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDeviceManufacturersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/deviceManufacturers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeviceManufacturersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeviceManufacturersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDeviceManufacturersResponse>newBuilder()
                      .setDefaultInstance(ListDeviceManufacturersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetDeviceManufacturerRequest, DeviceManufacturer>
      getDeviceManufacturerCallable;
  private final UnaryCallable<ListDeviceManufacturersRequest, ListDeviceManufacturersResponse>
      listDeviceManufacturersCallable;
  private final UnaryCallable<ListDeviceManufacturersRequest, ListDeviceManufacturersPagedResponse>
      listDeviceManufacturersPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDeviceManufacturerServiceStub create(
      DeviceManufacturerServiceStubSettings settings) throws IOException {
    return new HttpJsonDeviceManufacturerServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDeviceManufacturerServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDeviceManufacturerServiceStub(
        DeviceManufacturerServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonDeviceManufacturerServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDeviceManufacturerServiceStub(
        DeviceManufacturerServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDeviceManufacturerServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDeviceManufacturerServiceStub(
      DeviceManufacturerServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDeviceManufacturerServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDeviceManufacturerServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDeviceManufacturerServiceStub(
      DeviceManufacturerServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetDeviceManufacturerRequest, DeviceManufacturer>
        getDeviceManufacturerTransportSettings =
            HttpJsonCallSettings.<GetDeviceManufacturerRequest, DeviceManufacturer>newBuilder()
                .setMethodDescriptor(getDeviceManufacturerMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDeviceManufacturersRequest, ListDeviceManufacturersResponse>
        listDeviceManufacturersTransportSettings =
            HttpJsonCallSettings
                .<ListDeviceManufacturersRequest, ListDeviceManufacturersResponse>newBuilder()
                .setMethodDescriptor(listDeviceManufacturersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getDeviceManufacturerCallable =
        callableFactory.createUnaryCallable(
            getDeviceManufacturerTransportSettings,
            settings.getDeviceManufacturerSettings(),
            clientContext);
    this.listDeviceManufacturersCallable =
        callableFactory.createUnaryCallable(
            listDeviceManufacturersTransportSettings,
            settings.listDeviceManufacturersSettings(),
            clientContext);
    this.listDeviceManufacturersPagedCallable =
        callableFactory.createPagedCallable(
            listDeviceManufacturersTransportSettings,
            settings.listDeviceManufacturersSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getDeviceManufacturerMethodDescriptor);
    methodDescriptors.add(listDeviceManufacturersMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetDeviceManufacturerRequest, DeviceManufacturer>
      getDeviceManufacturerCallable() {
    return getDeviceManufacturerCallable;
  }

  @Override
  public UnaryCallable<ListDeviceManufacturersRequest, ListDeviceManufacturersResponse>
      listDeviceManufacturersCallable() {
    return listDeviceManufacturersCallable;
  }

  @Override
  public UnaryCallable<ListDeviceManufacturersRequest, ListDeviceManufacturersPagedResponse>
      listDeviceManufacturersPagedCallable() {
    return listDeviceManufacturersPagedCallable;
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
