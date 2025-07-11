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

package com.google.cloud.networkmanagement.v1beta1.stub;

import static com.google.cloud.networkmanagement.v1beta1.OrganizationVpcFlowLogsServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkmanagement.v1beta1.OrganizationVpcFlowLogsServiceClient.ListVpcFlowLogsConfigsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkmanagement.v1beta1.CreateVpcFlowLogsConfigRequest;
import com.google.cloud.networkmanagement.v1beta1.DeleteVpcFlowLogsConfigRequest;
import com.google.cloud.networkmanagement.v1beta1.GetVpcFlowLogsConfigRequest;
import com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsRequest;
import com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsResponse;
import com.google.cloud.networkmanagement.v1beta1.OperationMetadata;
import com.google.cloud.networkmanagement.v1beta1.UpdateVpcFlowLogsConfigRequest;
import com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfig;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * gRPC stub implementation for the OrganizationVpcFlowLogsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcOrganizationVpcFlowLogsServiceStub extends OrganizationVpcFlowLogsServiceStub {
  private static final MethodDescriptor<
          ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsResponse>
      listVpcFlowLogsConfigsMethodDescriptor =
          MethodDescriptor
              .<ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1beta1.OrganizationVpcFlowLogsService/ListVpcFlowLogsConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListVpcFlowLogsConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListVpcFlowLogsConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVpcFlowLogsConfigRequest, VpcFlowLogsConfig>
      getVpcFlowLogsConfigMethodDescriptor =
          MethodDescriptor.<GetVpcFlowLogsConfigRequest, VpcFlowLogsConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1beta1.OrganizationVpcFlowLogsService/GetVpcFlowLogsConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetVpcFlowLogsConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(VpcFlowLogsConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateVpcFlowLogsConfigRequest, Operation>
      createVpcFlowLogsConfigMethodDescriptor =
          MethodDescriptor.<CreateVpcFlowLogsConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1beta1.OrganizationVpcFlowLogsService/CreateVpcFlowLogsConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateVpcFlowLogsConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateVpcFlowLogsConfigRequest, Operation>
      updateVpcFlowLogsConfigMethodDescriptor =
          MethodDescriptor.<UpdateVpcFlowLogsConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1beta1.OrganizationVpcFlowLogsService/UpdateVpcFlowLogsConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateVpcFlowLogsConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteVpcFlowLogsConfigRequest, Operation>
      deleteVpcFlowLogsConfigMethodDescriptor =
          MethodDescriptor.<DeleteVpcFlowLogsConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1beta1.OrganizationVpcFlowLogsService/DeleteVpcFlowLogsConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteVpcFlowLogsConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsResponse>
      listVpcFlowLogsConfigsCallable;
  private final UnaryCallable<ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsPagedResponse>
      listVpcFlowLogsConfigsPagedCallable;
  private final UnaryCallable<GetVpcFlowLogsConfigRequest, VpcFlowLogsConfig>
      getVpcFlowLogsConfigCallable;
  private final UnaryCallable<CreateVpcFlowLogsConfigRequest, Operation>
      createVpcFlowLogsConfigCallable;
  private final OperationCallable<
          CreateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
      createVpcFlowLogsConfigOperationCallable;
  private final UnaryCallable<UpdateVpcFlowLogsConfigRequest, Operation>
      updateVpcFlowLogsConfigCallable;
  private final OperationCallable<
          UpdateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
      updateVpcFlowLogsConfigOperationCallable;
  private final UnaryCallable<DeleteVpcFlowLogsConfigRequest, Operation>
      deleteVpcFlowLogsConfigCallable;
  private final OperationCallable<DeleteVpcFlowLogsConfigRequest, Empty, OperationMetadata>
      deleteVpcFlowLogsConfigOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcOrganizationVpcFlowLogsServiceStub create(
      OrganizationVpcFlowLogsServiceStubSettings settings) throws IOException {
    return new GrpcOrganizationVpcFlowLogsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcOrganizationVpcFlowLogsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcOrganizationVpcFlowLogsServiceStub(
        OrganizationVpcFlowLogsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcOrganizationVpcFlowLogsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcOrganizationVpcFlowLogsServiceStub(
        OrganizationVpcFlowLogsServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcOrganizationVpcFlowLogsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcOrganizationVpcFlowLogsServiceStub(
      OrganizationVpcFlowLogsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcOrganizationVpcFlowLogsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcOrganizationVpcFlowLogsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcOrganizationVpcFlowLogsServiceStub(
      OrganizationVpcFlowLogsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsResponse>
        listVpcFlowLogsConfigsTransportSettings =
            GrpcCallSettings
                .<ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsResponse>newBuilder()
                .setMethodDescriptor(listVpcFlowLogsConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetVpcFlowLogsConfigRequest, VpcFlowLogsConfig>
        getVpcFlowLogsConfigTransportSettings =
            GrpcCallSettings.<GetVpcFlowLogsConfigRequest, VpcFlowLogsConfig>newBuilder()
                .setMethodDescriptor(getVpcFlowLogsConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateVpcFlowLogsConfigRequest, Operation>
        createVpcFlowLogsConfigTransportSettings =
            GrpcCallSettings.<CreateVpcFlowLogsConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(createVpcFlowLogsConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateVpcFlowLogsConfigRequest, Operation>
        updateVpcFlowLogsConfigTransportSettings =
            GrpcCallSettings.<UpdateVpcFlowLogsConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(updateVpcFlowLogsConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "vpc_flow_logs_config.name",
                          String.valueOf(request.getVpcFlowLogsConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteVpcFlowLogsConfigRequest, Operation>
        deleteVpcFlowLogsConfigTransportSettings =
            GrpcCallSettings.<DeleteVpcFlowLogsConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteVpcFlowLogsConfigMethodDescriptor)
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
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.listVpcFlowLogsConfigsCallable =
        callableFactory.createUnaryCallable(
            listVpcFlowLogsConfigsTransportSettings,
            settings.listVpcFlowLogsConfigsSettings(),
            clientContext);
    this.listVpcFlowLogsConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listVpcFlowLogsConfigsTransportSettings,
            settings.listVpcFlowLogsConfigsSettings(),
            clientContext);
    this.getVpcFlowLogsConfigCallable =
        callableFactory.createUnaryCallable(
            getVpcFlowLogsConfigTransportSettings,
            settings.getVpcFlowLogsConfigSettings(),
            clientContext);
    this.createVpcFlowLogsConfigCallable =
        callableFactory.createUnaryCallable(
            createVpcFlowLogsConfigTransportSettings,
            settings.createVpcFlowLogsConfigSettings(),
            clientContext);
    this.createVpcFlowLogsConfigOperationCallable =
        callableFactory.createOperationCallable(
            createVpcFlowLogsConfigTransportSettings,
            settings.createVpcFlowLogsConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.updateVpcFlowLogsConfigCallable =
        callableFactory.createUnaryCallable(
            updateVpcFlowLogsConfigTransportSettings,
            settings.updateVpcFlowLogsConfigSettings(),
            clientContext);
    this.updateVpcFlowLogsConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateVpcFlowLogsConfigTransportSettings,
            settings.updateVpcFlowLogsConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteVpcFlowLogsConfigCallable =
        callableFactory.createUnaryCallable(
            deleteVpcFlowLogsConfigTransportSettings,
            settings.deleteVpcFlowLogsConfigSettings(),
            clientContext);
    this.deleteVpcFlowLogsConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteVpcFlowLogsConfigTransportSettings,
            settings.deleteVpcFlowLogsConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsResponse>
      listVpcFlowLogsConfigsCallable() {
    return listVpcFlowLogsConfigsCallable;
  }

  @Override
  public UnaryCallable<ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsPagedResponse>
      listVpcFlowLogsConfigsPagedCallable() {
    return listVpcFlowLogsConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetVpcFlowLogsConfigRequest, VpcFlowLogsConfig>
      getVpcFlowLogsConfigCallable() {
    return getVpcFlowLogsConfigCallable;
  }

  @Override
  public UnaryCallable<CreateVpcFlowLogsConfigRequest, Operation>
      createVpcFlowLogsConfigCallable() {
    return createVpcFlowLogsConfigCallable;
  }

  @Override
  public OperationCallable<CreateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
      createVpcFlowLogsConfigOperationCallable() {
    return createVpcFlowLogsConfigOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateVpcFlowLogsConfigRequest, Operation>
      updateVpcFlowLogsConfigCallable() {
    return updateVpcFlowLogsConfigCallable;
  }

  @Override
  public OperationCallable<UpdateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
      updateVpcFlowLogsConfigOperationCallable() {
    return updateVpcFlowLogsConfigOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteVpcFlowLogsConfigRequest, Operation>
      deleteVpcFlowLogsConfigCallable() {
    return deleteVpcFlowLogsConfigCallable;
  }

  @Override
  public OperationCallable<DeleteVpcFlowLogsConfigRequest, Empty, OperationMetadata>
      deleteVpcFlowLogsConfigOperationCallable() {
    return deleteVpcFlowLogsConfigOperationCallable;
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
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
