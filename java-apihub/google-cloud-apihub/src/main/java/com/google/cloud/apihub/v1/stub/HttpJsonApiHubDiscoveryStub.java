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

import static com.google.cloud.apihub.v1.ApiHubDiscoveryClient.ListDiscoveredApiObservationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubDiscoveryClient.ListDiscoveredApiOperationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubDiscoveryClient.ListLocationsPagedResponse;

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
import com.google.cloud.apihub.v1.DiscoveredApiObservation;
import com.google.cloud.apihub.v1.DiscoveredApiOperation;
import com.google.cloud.apihub.v1.GetDiscoveredApiObservationRequest;
import com.google.cloud.apihub.v1.GetDiscoveredApiOperationRequest;
import com.google.cloud.apihub.v1.ListDiscoveredApiObservationsRequest;
import com.google.cloud.apihub.v1.ListDiscoveredApiObservationsResponse;
import com.google.cloud.apihub.v1.ListDiscoveredApiOperationsRequest;
import com.google.cloud.apihub.v1.ListDiscoveredApiOperationsResponse;
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
 * REST stub implementation for the ApiHubDiscovery service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonApiHubDiscoveryStub extends ApiHubDiscoveryStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          ListDiscoveredApiObservationsRequest, ListDiscoveredApiObservationsResponse>
      listDiscoveredApiObservationsMethodDescriptor =
          ApiMethodDescriptor
              .<ListDiscoveredApiObservationsRequest, ListDiscoveredApiObservationsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.apihub.v1.ApiHubDiscovery/ListDiscoveredApiObservations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDiscoveredApiObservationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/discoveredApiObservations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDiscoveredApiObservationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDiscoveredApiObservationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDiscoveredApiObservationsResponse>newBuilder()
                      .setDefaultInstance(
                          ListDiscoveredApiObservationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetDiscoveredApiObservationRequest, DiscoveredApiObservation>
      getDiscoveredApiObservationMethodDescriptor =
          ApiMethodDescriptor
              .<GetDiscoveredApiObservationRequest, DiscoveredApiObservation>newBuilder()
              .setFullMethodName(
                  "google.cloud.apihub.v1.ApiHubDiscovery/GetDiscoveredApiObservation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDiscoveredApiObservationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/discoveredApiObservations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDiscoveredApiObservationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDiscoveredApiObservationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DiscoveredApiObservation>newBuilder()
                      .setDefaultInstance(DiscoveredApiObservation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDiscoveredApiOperationsRequest, ListDiscoveredApiOperationsResponse>
      listDiscoveredApiOperationsMethodDescriptor =
          ApiMethodDescriptor
              .<ListDiscoveredApiOperationsRequest, ListDiscoveredApiOperationsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.apihub.v1.ApiHubDiscovery/ListDiscoveredApiOperations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDiscoveredApiOperationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/discoveredApiObservations/*}/discoveredApiOperations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDiscoveredApiOperationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDiscoveredApiOperationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDiscoveredApiOperationsResponse>newBuilder()
                      .setDefaultInstance(ListDiscoveredApiOperationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDiscoveredApiOperationRequest, DiscoveredApiOperation>
      getDiscoveredApiOperationMethodDescriptor =
          ApiMethodDescriptor.<GetDiscoveredApiOperationRequest, DiscoveredApiOperation>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHubDiscovery/GetDiscoveredApiOperation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDiscoveredApiOperationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/discoveredApiObservations/*/discoveredApiOperations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDiscoveredApiOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDiscoveredApiOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DiscoveredApiOperation>newBuilder()
                      .setDefaultInstance(DiscoveredApiOperation.getDefaultInstance())
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

  private final UnaryCallable<
          ListDiscoveredApiObservationsRequest, ListDiscoveredApiObservationsResponse>
      listDiscoveredApiObservationsCallable;
  private final UnaryCallable<
          ListDiscoveredApiObservationsRequest, ListDiscoveredApiObservationsPagedResponse>
      listDiscoveredApiObservationsPagedCallable;
  private final UnaryCallable<GetDiscoveredApiObservationRequest, DiscoveredApiObservation>
      getDiscoveredApiObservationCallable;
  private final UnaryCallable<
          ListDiscoveredApiOperationsRequest, ListDiscoveredApiOperationsResponse>
      listDiscoveredApiOperationsCallable;
  private final UnaryCallable<
          ListDiscoveredApiOperationsRequest, ListDiscoveredApiOperationsPagedResponse>
      listDiscoveredApiOperationsPagedCallable;
  private final UnaryCallable<GetDiscoveredApiOperationRequest, DiscoveredApiOperation>
      getDiscoveredApiOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonApiHubDiscoveryStub create(ApiHubDiscoveryStubSettings settings)
      throws IOException {
    return new HttpJsonApiHubDiscoveryStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonApiHubDiscoveryStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonApiHubDiscoveryStub(
        ApiHubDiscoveryStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonApiHubDiscoveryStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonApiHubDiscoveryStub(
        ApiHubDiscoveryStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonApiHubDiscoveryStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonApiHubDiscoveryStub(
      ApiHubDiscoveryStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonApiHubDiscoveryCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonApiHubDiscoveryStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonApiHubDiscoveryStub(
      ApiHubDiscoveryStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<
            ListDiscoveredApiObservationsRequest, ListDiscoveredApiObservationsResponse>
        listDiscoveredApiObservationsTransportSettings =
            HttpJsonCallSettings
                .<ListDiscoveredApiObservationsRequest, ListDiscoveredApiObservationsResponse>
                    newBuilder()
                .setMethodDescriptor(listDiscoveredApiObservationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDiscoveredApiObservationRequest, DiscoveredApiObservation>
        getDiscoveredApiObservationTransportSettings =
            HttpJsonCallSettings
                .<GetDiscoveredApiObservationRequest, DiscoveredApiObservation>newBuilder()
                .setMethodDescriptor(getDiscoveredApiObservationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDiscoveredApiOperationsRequest, ListDiscoveredApiOperationsResponse>
        listDiscoveredApiOperationsTransportSettings =
            HttpJsonCallSettings
                .<ListDiscoveredApiOperationsRequest, ListDiscoveredApiOperationsResponse>
                    newBuilder()
                .setMethodDescriptor(listDiscoveredApiOperationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDiscoveredApiOperationRequest, DiscoveredApiOperation>
        getDiscoveredApiOperationTransportSettings =
            HttpJsonCallSettings
                .<GetDiscoveredApiOperationRequest, DiscoveredApiOperation>newBuilder()
                .setMethodDescriptor(getDiscoveredApiOperationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
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

    this.listDiscoveredApiObservationsCallable =
        callableFactory.createUnaryCallable(
            listDiscoveredApiObservationsTransportSettings,
            settings.listDiscoveredApiObservationsSettings(),
            clientContext);
    this.listDiscoveredApiObservationsPagedCallable =
        callableFactory.createPagedCallable(
            listDiscoveredApiObservationsTransportSettings,
            settings.listDiscoveredApiObservationsSettings(),
            clientContext);
    this.getDiscoveredApiObservationCallable =
        callableFactory.createUnaryCallable(
            getDiscoveredApiObservationTransportSettings,
            settings.getDiscoveredApiObservationSettings(),
            clientContext);
    this.listDiscoveredApiOperationsCallable =
        callableFactory.createUnaryCallable(
            listDiscoveredApiOperationsTransportSettings,
            settings.listDiscoveredApiOperationsSettings(),
            clientContext);
    this.listDiscoveredApiOperationsPagedCallable =
        callableFactory.createPagedCallable(
            listDiscoveredApiOperationsTransportSettings,
            settings.listDiscoveredApiOperationsSettings(),
            clientContext);
    this.getDiscoveredApiOperationCallable =
        callableFactory.createUnaryCallable(
            getDiscoveredApiOperationTransportSettings,
            settings.getDiscoveredApiOperationSettings(),
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
    methodDescriptors.add(listDiscoveredApiObservationsMethodDescriptor);
    methodDescriptors.add(getDiscoveredApiObservationMethodDescriptor);
    methodDescriptors.add(listDiscoveredApiOperationsMethodDescriptor);
    methodDescriptors.add(getDiscoveredApiOperationMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListDiscoveredApiObservationsRequest, ListDiscoveredApiObservationsResponse>
      listDiscoveredApiObservationsCallable() {
    return listDiscoveredApiObservationsCallable;
  }

  @Override
  public UnaryCallable<
          ListDiscoveredApiObservationsRequest, ListDiscoveredApiObservationsPagedResponse>
      listDiscoveredApiObservationsPagedCallable() {
    return listDiscoveredApiObservationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDiscoveredApiObservationRequest, DiscoveredApiObservation>
      getDiscoveredApiObservationCallable() {
    return getDiscoveredApiObservationCallable;
  }

  @Override
  public UnaryCallable<ListDiscoveredApiOperationsRequest, ListDiscoveredApiOperationsResponse>
      listDiscoveredApiOperationsCallable() {
    return listDiscoveredApiOperationsCallable;
  }

  @Override
  public UnaryCallable<ListDiscoveredApiOperationsRequest, ListDiscoveredApiOperationsPagedResponse>
      listDiscoveredApiOperationsPagedCallable() {
    return listDiscoveredApiOperationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDiscoveredApiOperationRequest, DiscoveredApiOperation>
      getDiscoveredApiOperationCallable() {
    return getDiscoveredApiOperationCallable;
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
