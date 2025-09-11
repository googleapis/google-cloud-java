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

package com.google.cloud.cloudsecuritycompliance.v1.stub;

import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListCloudControlDeploymentsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListFrameworkDeploymentsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudsecuritycompliance.v1.CloudControlDeployment;
import com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkDeploymentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkDeploymentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeployment;
import com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlDeploymentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkDeploymentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsResponse;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsResponse;
import com.google.cloud.cloudsecuritycompliance.v1.OperationMetadata;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Deployment service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDeploymentStub extends DeploymentStub {
  private static final MethodDescriptor<CreateFrameworkDeploymentRequest, Operation>
      createFrameworkDeploymentMethodDescriptor =
          MethodDescriptor.<CreateFrameworkDeploymentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Deployment/CreateFrameworkDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFrameworkDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteFrameworkDeploymentRequest, Operation>
      deleteFrameworkDeploymentMethodDescriptor =
          MethodDescriptor.<DeleteFrameworkDeploymentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Deployment/DeleteFrameworkDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFrameworkDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetFrameworkDeploymentRequest, FrameworkDeployment>
      getFrameworkDeploymentMethodDescriptor =
          MethodDescriptor.<GetFrameworkDeploymentRequest, FrameworkDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Deployment/GetFrameworkDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetFrameworkDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FrameworkDeployment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsResponse>
      listFrameworkDeploymentsMethodDescriptor =
          MethodDescriptor
              .<ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Deployment/ListFrameworkDeployments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFrameworkDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFrameworkDeploymentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetCloudControlDeploymentRequest, CloudControlDeployment>
      getCloudControlDeploymentMethodDescriptor =
          MethodDescriptor.<GetCloudControlDeploymentRequest, CloudControlDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Deployment/GetCloudControlDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCloudControlDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CloudControlDeployment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsResponse>
      listCloudControlDeploymentsMethodDescriptor =
          MethodDescriptor
              .<ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Deployment/ListCloudControlDeployments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCloudControlDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCloudControlDeploymentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<CreateFrameworkDeploymentRequest, Operation>
      createFrameworkDeploymentCallable;
  private final OperationCallable<
          CreateFrameworkDeploymentRequest, FrameworkDeployment, OperationMetadata>
      createFrameworkDeploymentOperationCallable;
  private final UnaryCallable<DeleteFrameworkDeploymentRequest, Operation>
      deleteFrameworkDeploymentCallable;
  private final OperationCallable<DeleteFrameworkDeploymentRequest, Empty, OperationMetadata>
      deleteFrameworkDeploymentOperationCallable;
  private final UnaryCallable<GetFrameworkDeploymentRequest, FrameworkDeployment>
      getFrameworkDeploymentCallable;
  private final UnaryCallable<ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsResponse>
      listFrameworkDeploymentsCallable;
  private final UnaryCallable<
          ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsPagedResponse>
      listFrameworkDeploymentsPagedCallable;
  private final UnaryCallable<GetCloudControlDeploymentRequest, CloudControlDeployment>
      getCloudControlDeploymentCallable;
  private final UnaryCallable<
          ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsResponse>
      listCloudControlDeploymentsCallable;
  private final UnaryCallable<
          ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsPagedResponse>
      listCloudControlDeploymentsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDeploymentStub create(DeploymentStubSettings settings)
      throws IOException {
    return new GrpcDeploymentStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDeploymentStub create(ClientContext clientContext) throws IOException {
    return new GrpcDeploymentStub(DeploymentStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDeploymentStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDeploymentStub(
        DeploymentStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDeploymentStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDeploymentStub(DeploymentStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDeploymentCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDeploymentStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDeploymentStub(
      DeploymentStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateFrameworkDeploymentRequest, Operation>
        createFrameworkDeploymentTransportSettings =
            GrpcCallSettings.<CreateFrameworkDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(createFrameworkDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteFrameworkDeploymentRequest, Operation>
        deleteFrameworkDeploymentTransportSettings =
            GrpcCallSettings.<DeleteFrameworkDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteFrameworkDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetFrameworkDeploymentRequest, FrameworkDeployment>
        getFrameworkDeploymentTransportSettings =
            GrpcCallSettings.<GetFrameworkDeploymentRequest, FrameworkDeployment>newBuilder()
                .setMethodDescriptor(getFrameworkDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsResponse>
        listFrameworkDeploymentsTransportSettings =
            GrpcCallSettings
                .<ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listFrameworkDeploymentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetCloudControlDeploymentRequest, CloudControlDeployment>
        getCloudControlDeploymentTransportSettings =
            GrpcCallSettings.<GetCloudControlDeploymentRequest, CloudControlDeployment>newBuilder()
                .setMethodDescriptor(getCloudControlDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsResponse>
        listCloudControlDeploymentsTransportSettings =
            GrpcCallSettings
                .<ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsResponse>
                    newBuilder()
                .setMethodDescriptor(listCloudControlDeploymentsMethodDescriptor)
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

    this.createFrameworkDeploymentCallable =
        callableFactory.createUnaryCallable(
            createFrameworkDeploymentTransportSettings,
            settings.createFrameworkDeploymentSettings(),
            clientContext);
    this.createFrameworkDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            createFrameworkDeploymentTransportSettings,
            settings.createFrameworkDeploymentOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteFrameworkDeploymentCallable =
        callableFactory.createUnaryCallable(
            deleteFrameworkDeploymentTransportSettings,
            settings.deleteFrameworkDeploymentSettings(),
            clientContext);
    this.deleteFrameworkDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            deleteFrameworkDeploymentTransportSettings,
            settings.deleteFrameworkDeploymentOperationSettings(),
            clientContext,
            operationsStub);
    this.getFrameworkDeploymentCallable =
        callableFactory.createUnaryCallable(
            getFrameworkDeploymentTransportSettings,
            settings.getFrameworkDeploymentSettings(),
            clientContext);
    this.listFrameworkDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listFrameworkDeploymentsTransportSettings,
            settings.listFrameworkDeploymentsSettings(),
            clientContext);
    this.listFrameworkDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listFrameworkDeploymentsTransportSettings,
            settings.listFrameworkDeploymentsSettings(),
            clientContext);
    this.getCloudControlDeploymentCallable =
        callableFactory.createUnaryCallable(
            getCloudControlDeploymentTransportSettings,
            settings.getCloudControlDeploymentSettings(),
            clientContext);
    this.listCloudControlDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listCloudControlDeploymentsTransportSettings,
            settings.listCloudControlDeploymentsSettings(),
            clientContext);
    this.listCloudControlDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listCloudControlDeploymentsTransportSettings,
            settings.listCloudControlDeploymentsSettings(),
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
  public UnaryCallable<CreateFrameworkDeploymentRequest, Operation>
      createFrameworkDeploymentCallable() {
    return createFrameworkDeploymentCallable;
  }

  @Override
  public OperationCallable<CreateFrameworkDeploymentRequest, FrameworkDeployment, OperationMetadata>
      createFrameworkDeploymentOperationCallable() {
    return createFrameworkDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFrameworkDeploymentRequest, Operation>
      deleteFrameworkDeploymentCallable() {
    return deleteFrameworkDeploymentCallable;
  }

  @Override
  public OperationCallable<DeleteFrameworkDeploymentRequest, Empty, OperationMetadata>
      deleteFrameworkDeploymentOperationCallable() {
    return deleteFrameworkDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<GetFrameworkDeploymentRequest, FrameworkDeployment>
      getFrameworkDeploymentCallable() {
    return getFrameworkDeploymentCallable;
  }

  @Override
  public UnaryCallable<ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsResponse>
      listFrameworkDeploymentsCallable() {
    return listFrameworkDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsPagedResponse>
      listFrameworkDeploymentsPagedCallable() {
    return listFrameworkDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCloudControlDeploymentRequest, CloudControlDeployment>
      getCloudControlDeploymentCallable() {
    return getCloudControlDeploymentCallable;
  }

  @Override
  public UnaryCallable<ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsResponse>
      listCloudControlDeploymentsCallable() {
    return listCloudControlDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsPagedResponse>
      listCloudControlDeploymentsPagedCallable() {
    return listCloudControlDeploymentsPagedCallable;
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
