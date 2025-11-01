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

import static com.google.ads.admanager.v1.DeviceCapabilityServiceClient.ListDeviceCapabilitiesPagedResponse;

import com.google.ads.admanager.v1.DeviceCapability;
import com.google.ads.admanager.v1.GetDeviceCapabilityRequest;
import com.google.ads.admanager.v1.ListDeviceCapabilitiesRequest;
import com.google.ads.admanager.v1.ListDeviceCapabilitiesResponse;
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
 * REST stub implementation for the DeviceCapabilityService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonDeviceCapabilityServiceStub extends DeviceCapabilityServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetDeviceCapabilityRequest, DeviceCapability>
      getDeviceCapabilityMethodDescriptor =
          ApiMethodDescriptor.<GetDeviceCapabilityRequest, DeviceCapability>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DeviceCapabilityService/GetDeviceCapability")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDeviceCapabilityRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/deviceCapabilities/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeviceCapabilityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeviceCapabilityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeviceCapability>newBuilder()
                      .setDefaultInstance(DeviceCapability.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDeviceCapabilitiesRequest, ListDeviceCapabilitiesResponse>
      listDeviceCapabilitiesMethodDescriptor =
          ApiMethodDescriptor
              .<ListDeviceCapabilitiesRequest, ListDeviceCapabilitiesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DeviceCapabilityService/ListDeviceCapabilities")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDeviceCapabilitiesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/deviceCapabilities",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeviceCapabilitiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeviceCapabilitiesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDeviceCapabilitiesResponse>newBuilder()
                      .setDefaultInstance(ListDeviceCapabilitiesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetDeviceCapabilityRequest, DeviceCapability>
      getDeviceCapabilityCallable;
  private final UnaryCallable<ListDeviceCapabilitiesRequest, ListDeviceCapabilitiesResponse>
      listDeviceCapabilitiesCallable;
  private final UnaryCallable<ListDeviceCapabilitiesRequest, ListDeviceCapabilitiesPagedResponse>
      listDeviceCapabilitiesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDeviceCapabilityServiceStub create(
      DeviceCapabilityServiceStubSettings settings) throws IOException {
    return new HttpJsonDeviceCapabilityServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDeviceCapabilityServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDeviceCapabilityServiceStub(
        DeviceCapabilityServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonDeviceCapabilityServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDeviceCapabilityServiceStub(
        DeviceCapabilityServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDeviceCapabilityServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDeviceCapabilityServiceStub(
      DeviceCapabilityServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDeviceCapabilityServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDeviceCapabilityServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDeviceCapabilityServiceStub(
      DeviceCapabilityServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetDeviceCapabilityRequest, DeviceCapability>
        getDeviceCapabilityTransportSettings =
            HttpJsonCallSettings.<GetDeviceCapabilityRequest, DeviceCapability>newBuilder()
                .setMethodDescriptor(getDeviceCapabilityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDeviceCapabilitiesRequest, ListDeviceCapabilitiesResponse>
        listDeviceCapabilitiesTransportSettings =
            HttpJsonCallSettings
                .<ListDeviceCapabilitiesRequest, ListDeviceCapabilitiesResponse>newBuilder()
                .setMethodDescriptor(listDeviceCapabilitiesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getDeviceCapabilityCallable =
        callableFactory.createUnaryCallable(
            getDeviceCapabilityTransportSettings,
            settings.getDeviceCapabilitySettings(),
            clientContext);
    this.listDeviceCapabilitiesCallable =
        callableFactory.createUnaryCallable(
            listDeviceCapabilitiesTransportSettings,
            settings.listDeviceCapabilitiesSettings(),
            clientContext);
    this.listDeviceCapabilitiesPagedCallable =
        callableFactory.createPagedCallable(
            listDeviceCapabilitiesTransportSettings,
            settings.listDeviceCapabilitiesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getDeviceCapabilityMethodDescriptor);
    methodDescriptors.add(listDeviceCapabilitiesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetDeviceCapabilityRequest, DeviceCapability> getDeviceCapabilityCallable() {
    return getDeviceCapabilityCallable;
  }

  @Override
  public UnaryCallable<ListDeviceCapabilitiesRequest, ListDeviceCapabilitiesResponse>
      listDeviceCapabilitiesCallable() {
    return listDeviceCapabilitiesCallable;
  }

  @Override
  public UnaryCallable<ListDeviceCapabilitiesRequest, ListDeviceCapabilitiesPagedResponse>
      listDeviceCapabilitiesPagedCallable() {
    return listDeviceCapabilitiesPagedCallable;
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
