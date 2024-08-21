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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.HostProjectRegistrationServiceClient.ListHostProjectRegistrationsPagedResponse;
import static com.google.cloud.apihub.v1.HostProjectRegistrationServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the HostProjectRegistrationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcHostProjectRegistrationServiceStub extends HostProjectRegistrationServiceStub {
  private static final MethodDescriptor<
          CreateHostProjectRegistrationRequest, HostProjectRegistration>
      createHostProjectRegistrationMethodDescriptor =
          MethodDescriptor
              .<CreateHostProjectRegistrationRequest, HostProjectRegistration>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.apihub.v1.HostProjectRegistrationService/CreateHostProjectRegistration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateHostProjectRegistrationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(HostProjectRegistration.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetHostProjectRegistrationRequest, HostProjectRegistration>
      getHostProjectRegistrationMethodDescriptor =
          MethodDescriptor.<GetHostProjectRegistrationRequest, HostProjectRegistration>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.apihub.v1.HostProjectRegistrationService/GetHostProjectRegistration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetHostProjectRegistrationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(HostProjectRegistration.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListHostProjectRegistrationsRequest, ListHostProjectRegistrationsResponse>
      listHostProjectRegistrationsMethodDescriptor =
          MethodDescriptor
              .<ListHostProjectRegistrationsRequest, ListHostProjectRegistrationsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.apihub.v1.HostProjectRegistrationService/ListHostProjectRegistrations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListHostProjectRegistrationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListHostProjectRegistrationsResponse.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcHostProjectRegistrationServiceStub create(
      HostProjectRegistrationServiceStubSettings settings) throws IOException {
    return new GrpcHostProjectRegistrationServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcHostProjectRegistrationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcHostProjectRegistrationServiceStub(
        HostProjectRegistrationServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcHostProjectRegistrationServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcHostProjectRegistrationServiceStub(
        HostProjectRegistrationServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcHostProjectRegistrationServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcHostProjectRegistrationServiceStub(
      HostProjectRegistrationServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcHostProjectRegistrationServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcHostProjectRegistrationServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcHostProjectRegistrationServiceStub(
      HostProjectRegistrationServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateHostProjectRegistrationRequest, HostProjectRegistration>
        createHostProjectRegistrationTransportSettings =
            GrpcCallSettings
                .<CreateHostProjectRegistrationRequest, HostProjectRegistration>newBuilder()
                .setMethodDescriptor(createHostProjectRegistrationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetHostProjectRegistrationRequest, HostProjectRegistration>
        getHostProjectRegistrationTransportSettings =
            GrpcCallSettings
                .<GetHostProjectRegistrationRequest, HostProjectRegistration>newBuilder()
                .setMethodDescriptor(getHostProjectRegistrationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListHostProjectRegistrationsRequest, ListHostProjectRegistrationsResponse>
        listHostProjectRegistrationsTransportSettings =
            GrpcCallSettings
                .<ListHostProjectRegistrationsRequest, ListHostProjectRegistrationsResponse>
                    newBuilder()
                .setMethodDescriptor(listHostProjectRegistrationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
