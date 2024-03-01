/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.servicehealth.v1.stub;

import static com.google.cloud.servicehealth.v1.ServiceHealthClient.ListEventsPagedResponse;
import static com.google.cloud.servicehealth.v1.ServiceHealthClient.ListLocationsPagedResponse;
import static com.google.cloud.servicehealth.v1.ServiceHealthClient.ListOrganizationEventsPagedResponse;
import static com.google.cloud.servicehealth.v1.ServiceHealthClient.ListOrganizationImpactsPagedResponse;

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
import com.google.cloud.servicehealth.v1.Event;
import com.google.cloud.servicehealth.v1.GetEventRequest;
import com.google.cloud.servicehealth.v1.GetOrganizationEventRequest;
import com.google.cloud.servicehealth.v1.GetOrganizationImpactRequest;
import com.google.cloud.servicehealth.v1.ListEventsRequest;
import com.google.cloud.servicehealth.v1.ListEventsResponse;
import com.google.cloud.servicehealth.v1.ListOrganizationEventsRequest;
import com.google.cloud.servicehealth.v1.ListOrganizationEventsResponse;
import com.google.cloud.servicehealth.v1.ListOrganizationImpactsRequest;
import com.google.cloud.servicehealth.v1.ListOrganizationImpactsResponse;
import com.google.cloud.servicehealth.v1.OrganizationEvent;
import com.google.cloud.servicehealth.v1.OrganizationImpact;
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
 * REST stub implementation for the ServiceHealth service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonServiceHealthStub extends ServiceHealthStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListEventsRequest, ListEventsResponse>
      listEventsMethodDescriptor =
          ApiMethodDescriptor.<ListEventsRequest, ListEventsResponse>newBuilder()
              .setFullMethodName("google.cloud.servicehealth.v1.ServiceHealth/ListEvents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEventsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/events",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEventsResponse>newBuilder()
                      .setDefaultInstance(ListEventsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEventRequest, Event> getEventMethodDescriptor =
      ApiMethodDescriptor.<GetEventRequest, Event>newBuilder()
          .setFullMethodName("google.cloud.servicehealth.v1.ServiceHealth/GetEvent")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetEventRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/events/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetEventRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetEventRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Event>newBuilder()
                  .setDefaultInstance(Event.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<
          ListOrganizationEventsRequest, ListOrganizationEventsResponse>
      listOrganizationEventsMethodDescriptor =
          ApiMethodDescriptor
              .<ListOrganizationEventsRequest, ListOrganizationEventsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicehealth.v1.ServiceHealth/ListOrganizationEvents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOrganizationEventsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/organizationEvents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrganizationEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrganizationEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListOrganizationEventsResponse>newBuilder()
                      .setDefaultInstance(ListOrganizationEventsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetOrganizationEventRequest, OrganizationEvent>
      getOrganizationEventMethodDescriptor =
          ApiMethodDescriptor.<GetOrganizationEventRequest, OrganizationEvent>newBuilder()
              .setFullMethodName("google.cloud.servicehealth.v1.ServiceHealth/GetOrganizationEvent")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOrganizationEventRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/organizationEvents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrganizationEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrganizationEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OrganizationEvent>newBuilder()
                      .setDefaultInstance(OrganizationEvent.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListOrganizationImpactsRequest, ListOrganizationImpactsResponse>
      listOrganizationImpactsMethodDescriptor =
          ApiMethodDescriptor
              .<ListOrganizationImpactsRequest, ListOrganizationImpactsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicehealth.v1.ServiceHealth/ListOrganizationImpacts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOrganizationImpactsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/organizationImpacts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrganizationImpactsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrganizationImpactsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListOrganizationImpactsResponse>newBuilder()
                      .setDefaultInstance(ListOrganizationImpactsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetOrganizationImpactRequest, OrganizationImpact>
      getOrganizationImpactMethodDescriptor =
          ApiMethodDescriptor.<GetOrganizationImpactRequest, OrganizationImpact>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicehealth.v1.ServiceHealth/GetOrganizationImpact")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOrganizationImpactRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/organizationImpacts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrganizationImpactRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrganizationImpactRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OrganizationImpact>newBuilder()
                      .setDefaultInstance(OrganizationImpact.getDefaultInstance())
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

  private final UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable;
  private final UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable;
  private final UnaryCallable<GetEventRequest, Event> getEventCallable;
  private final UnaryCallable<ListOrganizationEventsRequest, ListOrganizationEventsResponse>
      listOrganizationEventsCallable;
  private final UnaryCallable<ListOrganizationEventsRequest, ListOrganizationEventsPagedResponse>
      listOrganizationEventsPagedCallable;
  private final UnaryCallable<GetOrganizationEventRequest, OrganizationEvent>
      getOrganizationEventCallable;
  private final UnaryCallable<ListOrganizationImpactsRequest, ListOrganizationImpactsResponse>
      listOrganizationImpactsCallable;
  private final UnaryCallable<ListOrganizationImpactsRequest, ListOrganizationImpactsPagedResponse>
      listOrganizationImpactsPagedCallable;
  private final UnaryCallable<GetOrganizationImpactRequest, OrganizationImpact>
      getOrganizationImpactCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonServiceHealthStub create(ServiceHealthStubSettings settings)
      throws IOException {
    return new HttpJsonServiceHealthStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonServiceHealthStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonServiceHealthStub(
        ServiceHealthStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonServiceHealthStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonServiceHealthStub(
        ServiceHealthStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonServiceHealthStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonServiceHealthStub(
      ServiceHealthStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonServiceHealthCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonServiceHealthStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonServiceHealthStub(
      ServiceHealthStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListEventsRequest, ListEventsResponse> listEventsTransportSettings =
        HttpJsonCallSettings.<ListEventsRequest, ListEventsResponse>newBuilder()
            .setMethodDescriptor(listEventsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetEventRequest, Event> getEventTransportSettings =
        HttpJsonCallSettings.<GetEventRequest, Event>newBuilder()
            .setMethodDescriptor(getEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListOrganizationEventsRequest, ListOrganizationEventsResponse>
        listOrganizationEventsTransportSettings =
            HttpJsonCallSettings
                .<ListOrganizationEventsRequest, ListOrganizationEventsResponse>newBuilder()
                .setMethodDescriptor(listOrganizationEventsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetOrganizationEventRequest, OrganizationEvent>
        getOrganizationEventTransportSettings =
            HttpJsonCallSettings.<GetOrganizationEventRequest, OrganizationEvent>newBuilder()
                .setMethodDescriptor(getOrganizationEventMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListOrganizationImpactsRequest, ListOrganizationImpactsResponse>
        listOrganizationImpactsTransportSettings =
            HttpJsonCallSettings
                .<ListOrganizationImpactsRequest, ListOrganizationImpactsResponse>newBuilder()
                .setMethodDescriptor(listOrganizationImpactsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetOrganizationImpactRequest, OrganizationImpact>
        getOrganizationImpactTransportSettings =
            HttpJsonCallSettings.<GetOrganizationImpactRequest, OrganizationImpact>newBuilder()
                .setMethodDescriptor(getOrganizationImpactMethodDescriptor)
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

    this.listEventsCallable =
        callableFactory.createUnaryCallable(
            listEventsTransportSettings, settings.listEventsSettings(), clientContext);
    this.listEventsPagedCallable =
        callableFactory.createPagedCallable(
            listEventsTransportSettings, settings.listEventsSettings(), clientContext);
    this.getEventCallable =
        callableFactory.createUnaryCallable(
            getEventTransportSettings, settings.getEventSettings(), clientContext);
    this.listOrganizationEventsCallable =
        callableFactory.createUnaryCallable(
            listOrganizationEventsTransportSettings,
            settings.listOrganizationEventsSettings(),
            clientContext);
    this.listOrganizationEventsPagedCallable =
        callableFactory.createPagedCallable(
            listOrganizationEventsTransportSettings,
            settings.listOrganizationEventsSettings(),
            clientContext);
    this.getOrganizationEventCallable =
        callableFactory.createUnaryCallable(
            getOrganizationEventTransportSettings,
            settings.getOrganizationEventSettings(),
            clientContext);
    this.listOrganizationImpactsCallable =
        callableFactory.createUnaryCallable(
            listOrganizationImpactsTransportSettings,
            settings.listOrganizationImpactsSettings(),
            clientContext);
    this.listOrganizationImpactsPagedCallable =
        callableFactory.createPagedCallable(
            listOrganizationImpactsTransportSettings,
            settings.listOrganizationImpactsSettings(),
            clientContext);
    this.getOrganizationImpactCallable =
        callableFactory.createUnaryCallable(
            getOrganizationImpactTransportSettings,
            settings.getOrganizationImpactSettings(),
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
    methodDescriptors.add(listEventsMethodDescriptor);
    methodDescriptors.add(getEventMethodDescriptor);
    methodDescriptors.add(listOrganizationEventsMethodDescriptor);
    methodDescriptors.add(getOrganizationEventMethodDescriptor);
    methodDescriptors.add(listOrganizationImpactsMethodDescriptor);
    methodDescriptors.add(getOrganizationImpactMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable() {
    return listEventsCallable;
  }

  @Override
  public UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable() {
    return listEventsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEventRequest, Event> getEventCallable() {
    return getEventCallable;
  }

  @Override
  public UnaryCallable<ListOrganizationEventsRequest, ListOrganizationEventsResponse>
      listOrganizationEventsCallable() {
    return listOrganizationEventsCallable;
  }

  @Override
  public UnaryCallable<ListOrganizationEventsRequest, ListOrganizationEventsPagedResponse>
      listOrganizationEventsPagedCallable() {
    return listOrganizationEventsPagedCallable;
  }

  @Override
  public UnaryCallable<GetOrganizationEventRequest, OrganizationEvent>
      getOrganizationEventCallable() {
    return getOrganizationEventCallable;
  }

  @Override
  public UnaryCallable<ListOrganizationImpactsRequest, ListOrganizationImpactsResponse>
      listOrganizationImpactsCallable() {
    return listOrganizationImpactsCallable;
  }

  @Override
  public UnaryCallable<ListOrganizationImpactsRequest, ListOrganizationImpactsPagedResponse>
      listOrganizationImpactsPagedCallable() {
    return listOrganizationImpactsPagedCallable;
  }

  @Override
  public UnaryCallable<GetOrganizationImpactRequest, OrganizationImpact>
      getOrganizationImpactCallable() {
    return getOrganizationImpactCallable;
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
