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
import com.google.cloud.maintenance.api.v1beta.GetResourceMaintenanceRequest;
import com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesRequest;
import com.google.cloud.maintenance.api.v1beta.ListResourceMaintenancesResponse;
import com.google.cloud.maintenance.api.v1beta.ResourceMaintenance;
import com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesRequest;
import com.google.cloud.maintenance.api.v1beta.SummarizeMaintenancesResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Maintenance service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcMaintenanceStub extends MaintenanceStub {
  private static final MethodDescriptor<SummarizeMaintenancesRequest, SummarizeMaintenancesResponse>
      summarizeMaintenancesMethodDescriptor =
          MethodDescriptor.<SummarizeMaintenancesRequest, SummarizeMaintenancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.maintenance.api.v1beta.Maintenance/SummarizeMaintenances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SummarizeMaintenancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SummarizeMaintenancesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListResourceMaintenancesRequest, ListResourceMaintenancesResponse>
      listResourceMaintenancesMethodDescriptor =
          MethodDescriptor
              .<ListResourceMaintenancesRequest, ListResourceMaintenancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.maintenance.api.v1beta.Maintenance/ListResourceMaintenances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListResourceMaintenancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListResourceMaintenancesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetResourceMaintenanceRequest, ResourceMaintenance>
      getResourceMaintenanceMethodDescriptor =
          MethodDescriptor.<GetResourceMaintenanceRequest, ResourceMaintenance>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.maintenance.api.v1beta.Maintenance/GetResourceMaintenance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetResourceMaintenanceRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ResourceMaintenance.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMaintenanceStub create(MaintenanceStubSettings settings)
      throws IOException {
    return new GrpcMaintenanceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMaintenanceStub create(ClientContext clientContext) throws IOException {
    return new GrpcMaintenanceStub(MaintenanceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMaintenanceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMaintenanceStub(
        MaintenanceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMaintenanceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMaintenanceStub(MaintenanceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcMaintenanceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMaintenanceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMaintenanceStub(
      MaintenanceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SummarizeMaintenancesRequest, SummarizeMaintenancesResponse>
        summarizeMaintenancesTransportSettings =
            GrpcCallSettings
                .<SummarizeMaintenancesRequest, SummarizeMaintenancesResponse>newBuilder()
                .setMethodDescriptor(summarizeMaintenancesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListResourceMaintenancesRequest, ListResourceMaintenancesResponse>
        listResourceMaintenancesTransportSettings =
            GrpcCallSettings
                .<ListResourceMaintenancesRequest, ListResourceMaintenancesResponse>newBuilder()
                .setMethodDescriptor(listResourceMaintenancesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetResourceMaintenanceRequest, ResourceMaintenance>
        getResourceMaintenanceTransportSettings =
            GrpcCallSettings.<GetResourceMaintenanceRequest, ResourceMaintenance>newBuilder()
                .setMethodDescriptor(getResourceMaintenanceMethodDescriptor)
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
