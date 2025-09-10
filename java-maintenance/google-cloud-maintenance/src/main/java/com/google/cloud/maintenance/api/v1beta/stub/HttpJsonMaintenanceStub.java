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

package com.google.cloud.maintenance.api.v1beta.stub;

import static com.google.cloud.maintenance.api.v1beta.MaintenanceClient.ListLocationsPagedResponse;
import static com.google.cloud.maintenance.api.v1beta.MaintenanceClient.ListResourceMaintenancesPagedResponse;
import static com.google.cloud.maintenance.api.v1beta.MaintenanceClient.SummarizeMaintenancesPagedResponse;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.maintenance.api.v1beta.GetResourceMaintenanceRequest;
import com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesRequest;
import com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesResponse;
import com.google.cloud.maintenance.api.v1beta.ResourceMaintenance;
import com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesRequest;
import com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesResponse;
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
 * REST stub implementation for the Maintenance service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonMaintenanceStub extends MaintenanceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          SummarizeMaintenancesRequest, SummarizeMaintenancesResponse>
      summarizeMaintenancesMethodDescriptor =
          ApiMethodDescriptor
              .<SummarizeMaintenancesRequest, SummarizeMaintenancesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.maintenance.api.v1beta.Maintenance/SummarizeMaintenances")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SummarizeMaintenancesRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/resourceMaintenances:summarize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SummarizeMaintenancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SummarizeMaintenancesRequest> serializer =
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
                  ProtoMessageResponseParser.<SummarizeMaintenancesResponse>newBuilder()
                      .setDefaultInstance(SummarizeMaintenancesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListResourceMaintenancesRequest, ListResourceMaintenancesResponse>
      listResourceMaintenancesMethodDescriptor =
          ApiMethodDescriptor
              .<ListResourceMaintenancesRequest, ListResourceMaintenancesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.maintenance.api.v1beta.Maintenance/ListResourceMaintenances")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListResourceMaintenancesRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/resourceMaintenances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListResourceMaintenancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListResourceMaintenancesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListResourceMaintenancesResponse>newBuilder()
                      .setDefaultInstance(ListResourceMaintenancesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetResourceMaintenanceRequest, ResourceMaintenance>
      getResourceMaintenanceMethodDescriptor =
          ApiMethodDescriptor.<GetResourceMaintenanceRequest, ResourceMaintenance>newBuilder()
              .setFullMethodName(
                  "google.cloud.maintenance.api.v1beta.Maintenance/GetResourceMaintenance")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetResourceMaintenanceRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/resourceMaintenances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetResourceMaintenanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetResourceMaintenanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ResourceMaintenance>newBuilder()
                      .setDefaultInstance(ResourceMaintenance.getDefaultInstance())
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
                          "/v1beta/{name=projects/*}/locations",
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
                          "/v1beta/{name=projects/*/locations/*}",
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

  private final UnaryCallable<SummarizeMaintenancesRequest, SummarizeMaintenancesResponse>
      summarizeMaintenancesCallable;
  private final UnaryCallable<SummarizeMaintenancesRequest, SummarizeMaintenancesPagedResponse>
      summarizeMaintenancesPagedCallable;
  private final UnaryCallable<ListResourceMaintenancesRequest, ListResourceMaintenancesResponse>
      listResourceMaintenancesCallable;
  private final UnaryCallable<
          ListResourceMaintenancesRequest, ListResourceMaintenancesPagedResponse>
      listResourceMaintenancesPagedCallable;
  private final UnaryCallable<GetResourceMaintenanceRequest, ResourceMaintenance>
      getResourceMaintenanceCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonMaintenanceStub create(MaintenanceStubSettings settings)
      throws IOException {
    return new HttpJsonMaintenanceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonMaintenanceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonMaintenanceStub(
        MaintenanceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonMaintenanceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMaintenanceStub(
        MaintenanceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMaintenanceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonMaintenanceStub(MaintenanceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonMaintenanceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMaintenanceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonMaintenanceStub(
      MaintenanceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<SummarizeMaintenancesRequest, SummarizeMaintenancesResponse>
        summarizeMaintenancesTransportSettings =
            HttpJsonCallSettings
                .<SummarizeMaintenancesRequest, SummarizeMaintenancesResponse>newBuilder()
                .setMethodDescriptor(summarizeMaintenancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListResourceMaintenancesRequest, ListResourceMaintenancesResponse>
        listResourceMaintenancesTransportSettings =
            HttpJsonCallSettings
                .<ListResourceMaintenancesRequest, ListResourceMaintenancesResponse>newBuilder()
                .setMethodDescriptor(listResourceMaintenancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetResourceMaintenanceRequest, ResourceMaintenance>
        getResourceMaintenanceTransportSettings =
            HttpJsonCallSettings.<GetResourceMaintenanceRequest, ResourceMaintenance>newBuilder()
                .setMethodDescriptor(getResourceMaintenanceMethodDescriptor)
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

    this.summarizeMaintenancesCallable =
        callableFactory.createUnaryCallable(
            summarizeMaintenancesTransportSettings,
            settings.summarizeMaintenancesSettings(),
            clientContext);
    this.summarizeMaintenancesPagedCallable =
        callableFactory.createPagedCallable(
            summarizeMaintenancesTransportSettings,
            settings.summarizeMaintenancesSettings(),
            clientContext);
    this.listResourceMaintenancesCallable =
        callableFactory.createUnaryCallable(
            listResourceMaintenancesTransportSettings,
            settings.listResourceMaintenancesSettings(),
            clientContext);
    this.listResourceMaintenancesPagedCallable =
        callableFactory.createPagedCallable(
            listResourceMaintenancesTransportSettings,
            settings.listResourceMaintenancesSettings(),
            clientContext);
    this.getResourceMaintenanceCallable =
        callableFactory.createUnaryCallable(
            getResourceMaintenanceTransportSettings,
            settings.getResourceMaintenanceSettings(),
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
    methodDescriptors.add(summarizeMaintenancesMethodDescriptor);
    methodDescriptors.add(listResourceMaintenancesMethodDescriptor);
    methodDescriptors.add(getResourceMaintenanceMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<SummarizeMaintenancesRequest, SummarizeMaintenancesResponse>
      summarizeMaintenancesCallable() {
    return summarizeMaintenancesCallable;
  }

  @Override
  public UnaryCallable<SummarizeMaintenancesRequest, SummarizeMaintenancesPagedResponse>
      summarizeMaintenancesPagedCallable() {
    return summarizeMaintenancesPagedCallable;
  }

  @Override
  public UnaryCallable<ListResourceMaintenancesRequest, ListResourceMaintenancesResponse>
      listResourceMaintenancesCallable() {
    return listResourceMaintenancesCallable;
  }

  @Override
  public UnaryCallable<ListResourceMaintenancesRequest, ListResourceMaintenancesPagedResponse>
      listResourceMaintenancesPagedCallable() {
    return listResourceMaintenancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetResourceMaintenanceRequest, ResourceMaintenance>
      getResourceMaintenanceCallable() {
    return getResourceMaintenanceCallable;
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
