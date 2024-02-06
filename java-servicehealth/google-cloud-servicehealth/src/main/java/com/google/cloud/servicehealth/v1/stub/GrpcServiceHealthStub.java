/*
 * Copyright 2023 Google LLC
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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ServiceHealth service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcServiceHealthStub extends ServiceHealthStub {
  private static final MethodDescriptor<ListEventsRequest, ListEventsResponse>
      listEventsMethodDescriptor =
          MethodDescriptor.<ListEventsRequest, ListEventsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.servicehealth.v1.ServiceHealth/ListEvents")
              .setRequestMarshaller(ProtoUtils.marshaller(ListEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListEventsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEventRequest, Event> getEventMethodDescriptor =
      MethodDescriptor.<GetEventRequest, Event>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.servicehealth.v1.ServiceHealth/GetEvent")
          .setRequestMarshaller(ProtoUtils.marshaller(GetEventRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Event.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<
          ListOrganizationEventsRequest, ListOrganizationEventsResponse>
      listOrganizationEventsMethodDescriptor =
          MethodDescriptor
              .<ListOrganizationEventsRequest, ListOrganizationEventsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.servicehealth.v1.ServiceHealth/ListOrganizationEvents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOrganizationEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOrganizationEventsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetOrganizationEventRequest, OrganizationEvent>
      getOrganizationEventMethodDescriptor =
          MethodDescriptor.<GetOrganizationEventRequest, OrganizationEvent>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.servicehealth.v1.ServiceHealth/GetOrganizationEvent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOrganizationEventRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(OrganizationEvent.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListOrganizationImpactsRequest, ListOrganizationImpactsResponse>
      listOrganizationImpactsMethodDescriptor =
          MethodDescriptor
              .<ListOrganizationImpactsRequest, ListOrganizationImpactsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.servicehealth.v1.ServiceHealth/ListOrganizationImpacts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOrganizationImpactsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOrganizationImpactsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetOrganizationImpactRequest, OrganizationImpact>
      getOrganizationImpactMethodDescriptor =
          MethodDescriptor.<GetOrganizationImpactRequest, OrganizationImpact>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.servicehealth.v1.ServiceHealth/GetOrganizationImpact")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOrganizationImpactRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(OrganizationImpact.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcServiceHealthStub create(ServiceHealthStubSettings settings)
      throws IOException {
    return new GrpcServiceHealthStub(settings, ClientContext.create(settings));
  }

  public static final GrpcServiceHealthStub create(ClientContext clientContext) throws IOException {
    return new GrpcServiceHealthStub(ServiceHealthStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcServiceHealthStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcServiceHealthStub(
        ServiceHealthStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcServiceHealthStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcServiceHealthStub(ServiceHealthStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcServiceHealthCallableFactory());
  }

  /**
   * Constructs an instance of GrpcServiceHealthStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcServiceHealthStub(
      ServiceHealthStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListEventsRequest, ListEventsResponse> listEventsTransportSettings =
        GrpcCallSettings.<ListEventsRequest, ListEventsResponse>newBuilder()
            .setMethodDescriptor(listEventsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetEventRequest, Event> getEventTransportSettings =
        GrpcCallSettings.<GetEventRequest, Event>newBuilder()
            .setMethodDescriptor(getEventMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListOrganizationEventsRequest, ListOrganizationEventsResponse>
        listOrganizationEventsTransportSettings =
            GrpcCallSettings
                .<ListOrganizationEventsRequest, ListOrganizationEventsResponse>newBuilder()
                .setMethodDescriptor(listOrganizationEventsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetOrganizationEventRequest, OrganizationEvent>
        getOrganizationEventTransportSettings =
            GrpcCallSettings.<GetOrganizationEventRequest, OrganizationEvent>newBuilder()
                .setMethodDescriptor(getOrganizationEventMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListOrganizationImpactsRequest, ListOrganizationImpactsResponse>
        listOrganizationImpactsTransportSettings =
            GrpcCallSettings
                .<ListOrganizationImpactsRequest, ListOrganizationImpactsResponse>newBuilder()
                .setMethodDescriptor(listOrganizationImpactsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetOrganizationImpactRequest, OrganizationImpact>
        getOrganizationImpactTransportSettings =
            GrpcCallSettings.<GetOrganizationImpactRequest, OrganizationImpact>newBuilder()
                .setMethodDescriptor(getOrganizationImpactMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
