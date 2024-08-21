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

import static com.google.cloud.apihub.v1.ApiHubDependenciesClient.ListDependenciesPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubDependenciesClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.CreateDependencyRequest;
import com.google.cloud.apihub.v1.DeleteDependencyRequest;
import com.google.cloud.apihub.v1.Dependency;
import com.google.cloud.apihub.v1.GetDependencyRequest;
import com.google.cloud.apihub.v1.ListDependenciesRequest;
import com.google.cloud.apihub.v1.ListDependenciesResponse;
import com.google.cloud.apihub.v1.UpdateDependencyRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ApiHubDependencies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcApiHubDependenciesStub extends ApiHubDependenciesStub {
  private static final MethodDescriptor<CreateDependencyRequest, Dependency>
      createDependencyMethodDescriptor =
          MethodDescriptor.<CreateDependencyRequest, Dependency>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHubDependencies/CreateDependency")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDependencyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Dependency.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDependencyRequest, Dependency>
      getDependencyMethodDescriptor =
          MethodDescriptor.<GetDependencyRequest, Dependency>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHubDependencies/GetDependency")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDependencyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Dependency.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDependencyRequest, Dependency>
      updateDependencyMethodDescriptor =
          MethodDescriptor.<UpdateDependencyRequest, Dependency>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHubDependencies/UpdateDependency")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDependencyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Dependency.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDependencyRequest, Empty>
      deleteDependencyMethodDescriptor =
          MethodDescriptor.<DeleteDependencyRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHubDependencies/DeleteDependency")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDependencyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDependenciesRequest, ListDependenciesResponse>
      listDependenciesMethodDescriptor =
          MethodDescriptor.<ListDependenciesRequest, ListDependenciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHubDependencies/ListDependencies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDependenciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDependenciesResponse.getDefaultInstance()))
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

  private final UnaryCallable<CreateDependencyRequest, Dependency> createDependencyCallable;
  private final UnaryCallable<GetDependencyRequest, Dependency> getDependencyCallable;
  private final UnaryCallable<UpdateDependencyRequest, Dependency> updateDependencyCallable;
  private final UnaryCallable<DeleteDependencyRequest, Empty> deleteDependencyCallable;
  private final UnaryCallable<ListDependenciesRequest, ListDependenciesResponse>
      listDependenciesCallable;
  private final UnaryCallable<ListDependenciesRequest, ListDependenciesPagedResponse>
      listDependenciesPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcApiHubDependenciesStub create(ApiHubDependenciesStubSettings settings)
      throws IOException {
    return new GrpcApiHubDependenciesStub(settings, ClientContext.create(settings));
  }

  public static final GrpcApiHubDependenciesStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcApiHubDependenciesStub(
        ApiHubDependenciesStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcApiHubDependenciesStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcApiHubDependenciesStub(
        ApiHubDependenciesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcApiHubDependenciesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcApiHubDependenciesStub(
      ApiHubDependenciesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcApiHubDependenciesCallableFactory());
  }

  /**
   * Constructs an instance of GrpcApiHubDependenciesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcApiHubDependenciesStub(
      ApiHubDependenciesStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDependencyRequest, Dependency> createDependencyTransportSettings =
        GrpcCallSettings.<CreateDependencyRequest, Dependency>newBuilder()
            .setMethodDescriptor(createDependencyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDependencyRequest, Dependency> getDependencyTransportSettings =
        GrpcCallSettings.<GetDependencyRequest, Dependency>newBuilder()
            .setMethodDescriptor(getDependencyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDependencyRequest, Dependency> updateDependencyTransportSettings =
        GrpcCallSettings.<UpdateDependencyRequest, Dependency>newBuilder()
            .setMethodDescriptor(updateDependencyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("dependency.name", String.valueOf(request.getDependency().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDependencyRequest, Empty> deleteDependencyTransportSettings =
        GrpcCallSettings.<DeleteDependencyRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDependencyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDependenciesRequest, ListDependenciesResponse>
        listDependenciesTransportSettings =
            GrpcCallSettings.<ListDependenciesRequest, ListDependenciesResponse>newBuilder()
                .setMethodDescriptor(listDependenciesMethodDescriptor)
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

    this.createDependencyCallable =
        callableFactory.createUnaryCallable(
            createDependencyTransportSettings, settings.createDependencySettings(), clientContext);
    this.getDependencyCallable =
        callableFactory.createUnaryCallable(
            getDependencyTransportSettings, settings.getDependencySettings(), clientContext);
    this.updateDependencyCallable =
        callableFactory.createUnaryCallable(
            updateDependencyTransportSettings, settings.updateDependencySettings(), clientContext);
    this.deleteDependencyCallable =
        callableFactory.createUnaryCallable(
            deleteDependencyTransportSettings, settings.deleteDependencySettings(), clientContext);
    this.listDependenciesCallable =
        callableFactory.createUnaryCallable(
            listDependenciesTransportSettings, settings.listDependenciesSettings(), clientContext);
    this.listDependenciesPagedCallable =
        callableFactory.createPagedCallable(
            listDependenciesTransportSettings, settings.listDependenciesSettings(), clientContext);
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
  public UnaryCallable<CreateDependencyRequest, Dependency> createDependencyCallable() {
    return createDependencyCallable;
  }

  @Override
  public UnaryCallable<GetDependencyRequest, Dependency> getDependencyCallable() {
    return getDependencyCallable;
  }

  @Override
  public UnaryCallable<UpdateDependencyRequest, Dependency> updateDependencyCallable() {
    return updateDependencyCallable;
  }

  @Override
  public UnaryCallable<DeleteDependencyRequest, Empty> deleteDependencyCallable() {
    return deleteDependencyCallable;
  }

  @Override
  public UnaryCallable<ListDependenciesRequest, ListDependenciesResponse>
      listDependenciesCallable() {
    return listDependenciesCallable;
  }

  @Override
  public UnaryCallable<ListDependenciesRequest, ListDependenciesPagedResponse>
      listDependenciesPagedCallable() {
    return listDependenciesPagedCallable;
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
