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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.HostProjectRegistrationServiceClient.ListHostProjectRegistrationsPagedResponse;
import static com.google.cloud.apihub.v1.HostProjectRegistrationServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.apihub.v1.CreateHostProjectRegistrationRequest;
import com.google.cloud.apihub.v1.GetHostProjectRegistrationRequest;
import com.google.cloud.apihub.v1.HostProjectRegistration;
import com.google.cloud.apihub.v1.ListHostProjectRegistrationsRequest;
import com.google.cloud.apihub.v1.ListHostProjectRegistrationsResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the HostProjectRegistrationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonHostProjectRegistrationServiceStub extends HostProjectRegistrationServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          CreateHostProjectRegistrationRequest, HostProjectRegistration>
      createHostProjectRegistrationMethodDescriptor =
          ApiMethodDescriptor
              .<CreateHostProjectRegistrationRequest, HostProjectRegistration>newBuilder()
              .setFullMethodName(
                  "google.cloud.apihub.v1.HostProjectRegistrationService/CreateHostProjectRegistration")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateHostProjectRegistrationRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/hostProjectRegistrations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHostProjectRegistrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHostProjectRegistrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "hostProjectRegistrationId",
                                request.getHostProjectRegistrationId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "hostProjectRegistration",
                                      request.getHostProjectRegistration(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HostProjectRegistration>newBuilder()
                      .setDefaultInstance(HostProjectRegistration.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetHostProjectRegistrationRequest, HostProjectRegistration>
      getHostProjectRegistrationMethodDescriptor =
          ApiMethodDescriptor
              .<GetHostProjectRegistrationRequest, HostProjectRegistration>newBuilder()
              .setFullMethodName(
                  "google.cloud.apihub.v1.HostProjectRegistrationService/GetHostProjectRegistration")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetHostProjectRegistrationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/hostProjectRegistrations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetHostProjectRegistrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetHostProjectRegistrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HostProjectRegistration>newBuilder()
                      .setDefaultInstance(HostProjectRegistration.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListHostProjectRegistrationsRequest, ListHostProjectRegistrationsResponse>
      listHostProjectRegistrationsMethodDescriptor =
          ApiMethodDescriptor
              .<ListHostProjectRegistrationsRequest, ListHostProjectRegistrationsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.apihub.v1.HostProjectRegistrationService/ListHostProjectRegistrations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListHostProjectRegistrationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/hostProjectRegistrations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListHostProjectRegistrationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListHostProjectRegistrationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListHostProjectRegistrationsResponse>newBuilder()
                      .setDefaultInstance(ListHostProjectRegistrationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateHostProjectRegistrationRequest, HostProjectRegistration>
      createHostProjectRegistrationCallable;
  private final UnaryCallable<GetHostProjectRegistrationRequest, HostProjectRegistration>
      getHostProjectRegistrationCallable;
  private final UnaryCallable<
          ListHostProjectRegistrationsRequest, ListHostProjectRegistrationsResponse>
      listHostProjectRegistrationsCallable;
  private final UnaryCallable<
          ListHostProjectRegistrationsRequest, ListHostProjectRegistrationsPagedResponse>
      listHostProjectRegistrationsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonHostProjectRegistrationServiceStub create(
      HostProjectRegistrationServiceStubSettings settings) throws IOException {
    return new HttpJsonHostProjectRegistrationServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonHostProjectRegistrationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonHostProjectRegistrationServiceStub(
        HostProjectRegistrationServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonHostProjectRegistrationServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonHostProjectRegistrationServiceStub(
        HostProjectRegistrationServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonHostProjectRegistrationServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonHostProjectRegistrationServiceStub(
      HostProjectRegistrationServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonHostProjectRegistrationServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonHostProjectRegistrationServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonHostProjectRegistrationServiceStub(
      HostProjectRegistrationServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateHostProjectRegistrationRequest, HostProjectRegistration>
        createHostProjectRegistrationTransportSettings =
            HttpJsonCallSettings
                .<CreateHostProjectRegistrationRequest, HostProjectRegistration>newBuilder()
                .setMethodDescriptor(createHostProjectRegistrationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetHostProjectRegistrationRequest, HostProjectRegistration>
        getHostProjectRegistrationTransportSettings =
            HttpJsonCallSettings
                .<GetHostProjectRegistrationRequest, HostProjectRegistration>newBuilder()
                .setMethodDescriptor(getHostProjectRegistrationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListHostProjectRegistrationsRequest, ListHostProjectRegistrationsResponse>
        listHostProjectRegistrationsTransportSettings =
            HttpJsonCallSettings
                .<ListHostProjectRegistrationsRequest, ListHostProjectRegistrationsResponse>
                    newBuilder()
                .setMethodDescriptor(listHostProjectRegistrationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createHostProjectRegistrationCallable =
        callableFactory.createUnaryCallable(
            createHostProjectRegistrationTransportSettings,
            settings.createHostProjectRegistrationSettings(),
            clientContext);
    this.getHostProjectRegistrationCallable =
        callableFactory.createUnaryCallable(
            getHostProjectRegistrationTransportSettings,
            settings.getHostProjectRegistrationSettings(),
            clientContext);
    this.listHostProjectRegistrationsCallable =
        callableFactory.createUnaryCallable(
            listHostProjectRegistrationsTransportSettings,
            settings.listHostProjectRegistrationsSettings(),
            clientContext);
    this.listHostProjectRegistrationsPagedCallable =
        callableFactory.createPagedCallable(
            listHostProjectRegistrationsTransportSettings,
            settings.listHostProjectRegistrationsSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createHostProjectRegistrationMethodDescriptor);
    methodDescriptors.add(getHostProjectRegistrationMethodDescriptor);
    methodDescriptors.add(listHostProjectRegistrationsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateHostProjectRegistrationRequest, HostProjectRegistration>
      createHostProjectRegistrationCallable() {
    return createHostProjectRegistrationCallable;
  }

  @Override
  public UnaryCallable<GetHostProjectRegistrationRequest, HostProjectRegistration>
      getHostProjectRegistrationCallable() {
    return getHostProjectRegistrationCallable;
  }

  @Override
  public UnaryCallable<ListHostProjectRegistrationsRequest, ListHostProjectRegistrationsResponse>
      listHostProjectRegistrationsCallable() {
    return listHostProjectRegistrationsCallable;
  }

  @Override
  public UnaryCallable<
          ListHostProjectRegistrationsRequest, ListHostProjectRegistrationsPagedResponse>
      listHostProjectRegistrationsPagedCallable() {
    return listHostProjectRegistrationsPagedCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
