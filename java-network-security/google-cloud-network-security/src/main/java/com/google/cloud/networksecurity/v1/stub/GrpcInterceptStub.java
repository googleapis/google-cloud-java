/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networksecurity.v1.stub;

import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptDeploymentGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptDeploymentsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptEndpointGroupAssociationsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptEndpointGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListLocationsPagedResponse;

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
import com.google.cloud.networksecurity.v1.CreateInterceptDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.CreateInterceptDeploymentRequest;
import com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.CreateInterceptEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteInterceptDeploymentRequest;
import com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.DeleteInterceptEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.GetInterceptDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.GetInterceptDeploymentRequest;
import com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.GetInterceptEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.InterceptDeployment;
import com.google.cloud.networksecurity.v1.InterceptDeploymentGroup;
import com.google.cloud.networksecurity.v1.InterceptEndpointGroup;
import com.google.cloud.networksecurity.v1.InterceptEndpointGroupAssociation;
import com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsRequest;
import com.google.cloud.networksecurity.v1.ListInterceptDeploymentGroupsResponse;
import com.google.cloud.networksecurity.v1.ListInterceptDeploymentsRequest;
import com.google.cloud.networksecurity.v1.ListInterceptDeploymentsResponse;
import com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsRequest;
import com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupAssociationsResponse;
import com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsRequest;
import com.google.cloud.networksecurity.v1.ListInterceptEndpointGroupsResponse;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.UpdateInterceptDeploymentRequest;
import com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.UpdateInterceptEndpointGroupRequest;
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
 * gRPC stub implementation for the Intercept service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcInterceptStub extends InterceptStub {
  private static final MethodDescriptor<
          ListInterceptEndpointGroupsRequest, ListInterceptEndpointGroupsResponse>
      listInterceptEndpointGroupsMethodDescriptor =
          MethodDescriptor
              .<ListInterceptEndpointGroupsRequest, ListInterceptEndpointGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/ListInterceptEndpointGroups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInterceptEndpointGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInterceptEndpointGroupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetInterceptEndpointGroupRequest, InterceptEndpointGroup>
      getInterceptEndpointGroupMethodDescriptor =
          MethodDescriptor.<GetInterceptEndpointGroupRequest, InterceptEndpointGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/GetInterceptEndpointGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetInterceptEndpointGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(InterceptEndpointGroup.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateInterceptEndpointGroupRequest, Operation>
      createInterceptEndpointGroupMethodDescriptor =
          MethodDescriptor.<CreateInterceptEndpointGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/CreateInterceptEndpointGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInterceptEndpointGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateInterceptEndpointGroupRequest, Operation>
      updateInterceptEndpointGroupMethodDescriptor =
          MethodDescriptor.<UpdateInterceptEndpointGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/UpdateInterceptEndpointGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInterceptEndpointGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteInterceptEndpointGroupRequest, Operation>
      deleteInterceptEndpointGroupMethodDescriptor =
          MethodDescriptor.<DeleteInterceptEndpointGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/DeleteInterceptEndpointGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInterceptEndpointGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListInterceptEndpointGroupAssociationsRequest,
          ListInterceptEndpointGroupAssociationsResponse>
      listInterceptEndpointGroupAssociationsMethodDescriptor =
          MethodDescriptor
              .<ListInterceptEndpointGroupAssociationsRequest,
                  ListInterceptEndpointGroupAssociationsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/ListInterceptEndpointGroupAssociations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListInterceptEndpointGroupAssociationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListInterceptEndpointGroupAssociationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetInterceptEndpointGroupAssociationRequest, InterceptEndpointGroupAssociation>
      getInterceptEndpointGroupAssociationMethodDescriptor =
          MethodDescriptor
              .<GetInterceptEndpointGroupAssociationRequest, InterceptEndpointGroupAssociation>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/GetInterceptEndpointGroupAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetInterceptEndpointGroupAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(InterceptEndpointGroupAssociation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateInterceptEndpointGroupAssociationRequest, Operation>
      createInterceptEndpointGroupAssociationMethodDescriptor =
          MethodDescriptor.<CreateInterceptEndpointGroupAssociationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/CreateInterceptEndpointGroupAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateInterceptEndpointGroupAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateInterceptEndpointGroupAssociationRequest, Operation>
      updateInterceptEndpointGroupAssociationMethodDescriptor =
          MethodDescriptor.<UpdateInterceptEndpointGroupAssociationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/UpdateInterceptEndpointGroupAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateInterceptEndpointGroupAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteInterceptEndpointGroupAssociationRequest, Operation>
      deleteInterceptEndpointGroupAssociationMethodDescriptor =
          MethodDescriptor.<DeleteInterceptEndpointGroupAssociationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/DeleteInterceptEndpointGroupAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteInterceptEndpointGroupAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListInterceptDeploymentGroupsRequest, ListInterceptDeploymentGroupsResponse>
      listInterceptDeploymentGroupsMethodDescriptor =
          MethodDescriptor
              .<ListInterceptDeploymentGroupsRequest, ListInterceptDeploymentGroupsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/ListInterceptDeploymentGroups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInterceptDeploymentGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInterceptDeploymentGroupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetInterceptDeploymentGroupRequest, InterceptDeploymentGroup>
      getInterceptDeploymentGroupMethodDescriptor =
          MethodDescriptor
              .<GetInterceptDeploymentGroupRequest, InterceptDeploymentGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/GetInterceptDeploymentGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetInterceptDeploymentGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(InterceptDeploymentGroup.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateInterceptDeploymentGroupRequest, Operation>
      createInterceptDeploymentGroupMethodDescriptor =
          MethodDescriptor.<CreateInterceptDeploymentGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/CreateInterceptDeploymentGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInterceptDeploymentGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateInterceptDeploymentGroupRequest, Operation>
      updateInterceptDeploymentGroupMethodDescriptor =
          MethodDescriptor.<UpdateInterceptDeploymentGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/UpdateInterceptDeploymentGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInterceptDeploymentGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteInterceptDeploymentGroupRequest, Operation>
      deleteInterceptDeploymentGroupMethodDescriptor =
          MethodDescriptor.<DeleteInterceptDeploymentGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/DeleteInterceptDeploymentGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInterceptDeploymentGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListInterceptDeploymentsRequest, ListInterceptDeploymentsResponse>
      listInterceptDeploymentsMethodDescriptor =
          MethodDescriptor
              .<ListInterceptDeploymentsRequest, ListInterceptDeploymentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/ListInterceptDeployments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInterceptDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInterceptDeploymentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetInterceptDeploymentRequest, InterceptDeployment>
      getInterceptDeploymentMethodDescriptor =
          MethodDescriptor.<GetInterceptDeploymentRequest, InterceptDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networksecurity.v1.Intercept/GetInterceptDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetInterceptDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(InterceptDeployment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateInterceptDeploymentRequest, Operation>
      createInterceptDeploymentMethodDescriptor =
          MethodDescriptor.<CreateInterceptDeploymentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/CreateInterceptDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInterceptDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateInterceptDeploymentRequest, Operation>
      updateInterceptDeploymentMethodDescriptor =
          MethodDescriptor.<UpdateInterceptDeploymentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/UpdateInterceptDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInterceptDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteInterceptDeploymentRequest, Operation>
      deleteInterceptDeploymentMethodDescriptor =
          MethodDescriptor.<DeleteInterceptDeploymentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Intercept/DeleteInterceptDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInterceptDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<
          ListInterceptEndpointGroupsRequest, ListInterceptEndpointGroupsResponse>
      listInterceptEndpointGroupsCallable;
  private final UnaryCallable<
          ListInterceptEndpointGroupsRequest, ListInterceptEndpointGroupsPagedResponse>
      listInterceptEndpointGroupsPagedCallable;
  private final UnaryCallable<GetInterceptEndpointGroupRequest, InterceptEndpointGroup>
      getInterceptEndpointGroupCallable;
  private final UnaryCallable<CreateInterceptEndpointGroupRequest, Operation>
      createInterceptEndpointGroupCallable;
  private final OperationCallable<
          CreateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
      createInterceptEndpointGroupOperationCallable;
  private final UnaryCallable<UpdateInterceptEndpointGroupRequest, Operation>
      updateInterceptEndpointGroupCallable;
  private final OperationCallable<
          UpdateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
      updateInterceptEndpointGroupOperationCallable;
  private final UnaryCallable<DeleteInterceptEndpointGroupRequest, Operation>
      deleteInterceptEndpointGroupCallable;
  private final OperationCallable<DeleteInterceptEndpointGroupRequest, Empty, OperationMetadata>
      deleteInterceptEndpointGroupOperationCallable;
  private final UnaryCallable<
          ListInterceptEndpointGroupAssociationsRequest,
          ListInterceptEndpointGroupAssociationsResponse>
      listInterceptEndpointGroupAssociationsCallable;
  private final UnaryCallable<
          ListInterceptEndpointGroupAssociationsRequest,
          ListInterceptEndpointGroupAssociationsPagedResponse>
      listInterceptEndpointGroupAssociationsPagedCallable;
  private final UnaryCallable<
          GetInterceptEndpointGroupAssociationRequest, InterceptEndpointGroupAssociation>
      getInterceptEndpointGroupAssociationCallable;
  private final UnaryCallable<CreateInterceptEndpointGroupAssociationRequest, Operation>
      createInterceptEndpointGroupAssociationCallable;
  private final OperationCallable<
          CreateInterceptEndpointGroupAssociationRequest,
          InterceptEndpointGroupAssociation,
          OperationMetadata>
      createInterceptEndpointGroupAssociationOperationCallable;
  private final UnaryCallable<UpdateInterceptEndpointGroupAssociationRequest, Operation>
      updateInterceptEndpointGroupAssociationCallable;
  private final OperationCallable<
          UpdateInterceptEndpointGroupAssociationRequest,
          InterceptEndpointGroupAssociation,
          OperationMetadata>
      updateInterceptEndpointGroupAssociationOperationCallable;
  private final UnaryCallable<DeleteInterceptEndpointGroupAssociationRequest, Operation>
      deleteInterceptEndpointGroupAssociationCallable;
  private final OperationCallable<
          DeleteInterceptEndpointGroupAssociationRequest, Empty, OperationMetadata>
      deleteInterceptEndpointGroupAssociationOperationCallable;
  private final UnaryCallable<
          ListInterceptDeploymentGroupsRequest, ListInterceptDeploymentGroupsResponse>
      listInterceptDeploymentGroupsCallable;
  private final UnaryCallable<
          ListInterceptDeploymentGroupsRequest, ListInterceptDeploymentGroupsPagedResponse>
      listInterceptDeploymentGroupsPagedCallable;
  private final UnaryCallable<GetInterceptDeploymentGroupRequest, InterceptDeploymentGroup>
      getInterceptDeploymentGroupCallable;
  private final UnaryCallable<CreateInterceptDeploymentGroupRequest, Operation>
      createInterceptDeploymentGroupCallable;
  private final OperationCallable<
          CreateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
      createInterceptDeploymentGroupOperationCallable;
  private final UnaryCallable<UpdateInterceptDeploymentGroupRequest, Operation>
      updateInterceptDeploymentGroupCallable;
  private final OperationCallable<
          UpdateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
      updateInterceptDeploymentGroupOperationCallable;
  private final UnaryCallable<DeleteInterceptDeploymentGroupRequest, Operation>
      deleteInterceptDeploymentGroupCallable;
  private final OperationCallable<DeleteInterceptDeploymentGroupRequest, Empty, OperationMetadata>
      deleteInterceptDeploymentGroupOperationCallable;
  private final UnaryCallable<ListInterceptDeploymentsRequest, ListInterceptDeploymentsResponse>
      listInterceptDeploymentsCallable;
  private final UnaryCallable<
          ListInterceptDeploymentsRequest, ListInterceptDeploymentsPagedResponse>
      listInterceptDeploymentsPagedCallable;
  private final UnaryCallable<GetInterceptDeploymentRequest, InterceptDeployment>
      getInterceptDeploymentCallable;
  private final UnaryCallable<CreateInterceptDeploymentRequest, Operation>
      createInterceptDeploymentCallable;
  private final OperationCallable<
          CreateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
      createInterceptDeploymentOperationCallable;
  private final UnaryCallable<UpdateInterceptDeploymentRequest, Operation>
      updateInterceptDeploymentCallable;
  private final OperationCallable<
          UpdateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
      updateInterceptDeploymentOperationCallable;
  private final UnaryCallable<DeleteInterceptDeploymentRequest, Operation>
      deleteInterceptDeploymentCallable;
  private final OperationCallable<DeleteInterceptDeploymentRequest, Empty, OperationMetadata>
      deleteInterceptDeploymentOperationCallable;
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

  public static final GrpcInterceptStub create(InterceptStubSettings settings) throws IOException {
    return new GrpcInterceptStub(settings, ClientContext.create(settings));
  }

  public static final GrpcInterceptStub create(ClientContext clientContext) throws IOException {
    return new GrpcInterceptStub(InterceptStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcInterceptStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcInterceptStub(
        InterceptStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcInterceptStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcInterceptStub(InterceptStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcInterceptCallableFactory());
  }

  /**
   * Constructs an instance of GrpcInterceptStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcInterceptStub(
      InterceptStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListInterceptEndpointGroupsRequest, ListInterceptEndpointGroupsResponse>
        listInterceptEndpointGroupsTransportSettings =
            GrpcCallSettings
                .<ListInterceptEndpointGroupsRequest, ListInterceptEndpointGroupsResponse>
                    newBuilder()
                .setMethodDescriptor(listInterceptEndpointGroupsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetInterceptEndpointGroupRequest, InterceptEndpointGroup>
        getInterceptEndpointGroupTransportSettings =
            GrpcCallSettings.<GetInterceptEndpointGroupRequest, InterceptEndpointGroup>newBuilder()
                .setMethodDescriptor(getInterceptEndpointGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateInterceptEndpointGroupRequest, Operation>
        createInterceptEndpointGroupTransportSettings =
            GrpcCallSettings.<CreateInterceptEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(createInterceptEndpointGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateInterceptEndpointGroupRequest, Operation>
        updateInterceptEndpointGroupTransportSettings =
            GrpcCallSettings.<UpdateInterceptEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(updateInterceptEndpointGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "intercept_endpoint_group.name",
                          String.valueOf(request.getInterceptEndpointGroup().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteInterceptEndpointGroupRequest, Operation>
        deleteInterceptEndpointGroupTransportSettings =
            GrpcCallSettings.<DeleteInterceptEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteInterceptEndpointGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<
            ListInterceptEndpointGroupAssociationsRequest,
            ListInterceptEndpointGroupAssociationsResponse>
        listInterceptEndpointGroupAssociationsTransportSettings =
            GrpcCallSettings
                .<ListInterceptEndpointGroupAssociationsRequest,
                    ListInterceptEndpointGroupAssociationsResponse>
                    newBuilder()
                .setMethodDescriptor(listInterceptEndpointGroupAssociationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetInterceptEndpointGroupAssociationRequest, InterceptEndpointGroupAssociation>
        getInterceptEndpointGroupAssociationTransportSettings =
            GrpcCallSettings
                .<GetInterceptEndpointGroupAssociationRequest, InterceptEndpointGroupAssociation>
                    newBuilder()
                .setMethodDescriptor(getInterceptEndpointGroupAssociationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateInterceptEndpointGroupAssociationRequest, Operation>
        createInterceptEndpointGroupAssociationTransportSettings =
            GrpcCallSettings.<CreateInterceptEndpointGroupAssociationRequest, Operation>newBuilder()
                .setMethodDescriptor(createInterceptEndpointGroupAssociationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateInterceptEndpointGroupAssociationRequest, Operation>
        updateInterceptEndpointGroupAssociationTransportSettings =
            GrpcCallSettings.<UpdateInterceptEndpointGroupAssociationRequest, Operation>newBuilder()
                .setMethodDescriptor(updateInterceptEndpointGroupAssociationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "intercept_endpoint_group_association.name",
                          String.valueOf(request.getInterceptEndpointGroupAssociation().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteInterceptEndpointGroupAssociationRequest, Operation>
        deleteInterceptEndpointGroupAssociationTransportSettings =
            GrpcCallSettings.<DeleteInterceptEndpointGroupAssociationRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteInterceptEndpointGroupAssociationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListInterceptDeploymentGroupsRequest, ListInterceptDeploymentGroupsResponse>
        listInterceptDeploymentGroupsTransportSettings =
            GrpcCallSettings
                .<ListInterceptDeploymentGroupsRequest, ListInterceptDeploymentGroupsResponse>
                    newBuilder()
                .setMethodDescriptor(listInterceptDeploymentGroupsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetInterceptDeploymentGroupRequest, InterceptDeploymentGroup>
        getInterceptDeploymentGroupTransportSettings =
            GrpcCallSettings
                .<GetInterceptDeploymentGroupRequest, InterceptDeploymentGroup>newBuilder()
                .setMethodDescriptor(getInterceptDeploymentGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateInterceptDeploymentGroupRequest, Operation>
        createInterceptDeploymentGroupTransportSettings =
            GrpcCallSettings.<CreateInterceptDeploymentGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(createInterceptDeploymentGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateInterceptDeploymentGroupRequest, Operation>
        updateInterceptDeploymentGroupTransportSettings =
            GrpcCallSettings.<UpdateInterceptDeploymentGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(updateInterceptDeploymentGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "intercept_deployment_group.name",
                          String.valueOf(request.getInterceptDeploymentGroup().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteInterceptDeploymentGroupRequest, Operation>
        deleteInterceptDeploymentGroupTransportSettings =
            GrpcCallSettings.<DeleteInterceptDeploymentGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteInterceptDeploymentGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListInterceptDeploymentsRequest, ListInterceptDeploymentsResponse>
        listInterceptDeploymentsTransportSettings =
            GrpcCallSettings
                .<ListInterceptDeploymentsRequest, ListInterceptDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listInterceptDeploymentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetInterceptDeploymentRequest, InterceptDeployment>
        getInterceptDeploymentTransportSettings =
            GrpcCallSettings.<GetInterceptDeploymentRequest, InterceptDeployment>newBuilder()
                .setMethodDescriptor(getInterceptDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateInterceptDeploymentRequest, Operation>
        createInterceptDeploymentTransportSettings =
            GrpcCallSettings.<CreateInterceptDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(createInterceptDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateInterceptDeploymentRequest, Operation>
        updateInterceptDeploymentTransportSettings =
            GrpcCallSettings.<UpdateInterceptDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(updateInterceptDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "intercept_deployment.name",
                          String.valueOf(request.getInterceptDeployment().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteInterceptDeploymentRequest, Operation>
        deleteInterceptDeploymentTransportSettings =
            GrpcCallSettings.<DeleteInterceptDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteInterceptDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getResource())
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
            .setResourceNameExtractor(request -> request.getResource())
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
                .setResourceNameExtractor(request -> request.getResource())
                .build();

    this.listInterceptEndpointGroupsCallable =
        callableFactory.createUnaryCallable(
            listInterceptEndpointGroupsTransportSettings,
            settings.listInterceptEndpointGroupsSettings(),
            clientContext);
    this.listInterceptEndpointGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listInterceptEndpointGroupsTransportSettings,
            settings.listInterceptEndpointGroupsSettings(),
            clientContext);
    this.getInterceptEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            getInterceptEndpointGroupTransportSettings,
            settings.getInterceptEndpointGroupSettings(),
            clientContext);
    this.createInterceptEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            createInterceptEndpointGroupTransportSettings,
            settings.createInterceptEndpointGroupSettings(),
            clientContext);
    this.createInterceptEndpointGroupOperationCallable =
        callableFactory.createOperationCallable(
            createInterceptEndpointGroupTransportSettings,
            settings.createInterceptEndpointGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.updateInterceptEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            updateInterceptEndpointGroupTransportSettings,
            settings.updateInterceptEndpointGroupSettings(),
            clientContext);
    this.updateInterceptEndpointGroupOperationCallable =
        callableFactory.createOperationCallable(
            updateInterceptEndpointGroupTransportSettings,
            settings.updateInterceptEndpointGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteInterceptEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            deleteInterceptEndpointGroupTransportSettings,
            settings.deleteInterceptEndpointGroupSettings(),
            clientContext);
    this.deleteInterceptEndpointGroupOperationCallable =
        callableFactory.createOperationCallable(
            deleteInterceptEndpointGroupTransportSettings,
            settings.deleteInterceptEndpointGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.listInterceptEndpointGroupAssociationsCallable =
        callableFactory.createUnaryCallable(
            listInterceptEndpointGroupAssociationsTransportSettings,
            settings.listInterceptEndpointGroupAssociationsSettings(),
            clientContext);
    this.listInterceptEndpointGroupAssociationsPagedCallable =
        callableFactory.createPagedCallable(
            listInterceptEndpointGroupAssociationsTransportSettings,
            settings.listInterceptEndpointGroupAssociationsSettings(),
            clientContext);
    this.getInterceptEndpointGroupAssociationCallable =
        callableFactory.createUnaryCallable(
            getInterceptEndpointGroupAssociationTransportSettings,
            settings.getInterceptEndpointGroupAssociationSettings(),
            clientContext);
    this.createInterceptEndpointGroupAssociationCallable =
        callableFactory.createUnaryCallable(
            createInterceptEndpointGroupAssociationTransportSettings,
            settings.createInterceptEndpointGroupAssociationSettings(),
            clientContext);
    this.createInterceptEndpointGroupAssociationOperationCallable =
        callableFactory.createOperationCallable(
            createInterceptEndpointGroupAssociationTransportSettings,
            settings.createInterceptEndpointGroupAssociationOperationSettings(),
            clientContext,
            operationsStub);
    this.updateInterceptEndpointGroupAssociationCallable =
        callableFactory.createUnaryCallable(
            updateInterceptEndpointGroupAssociationTransportSettings,
            settings.updateInterceptEndpointGroupAssociationSettings(),
            clientContext);
    this.updateInterceptEndpointGroupAssociationOperationCallable =
        callableFactory.createOperationCallable(
            updateInterceptEndpointGroupAssociationTransportSettings,
            settings.updateInterceptEndpointGroupAssociationOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteInterceptEndpointGroupAssociationCallable =
        callableFactory.createUnaryCallable(
            deleteInterceptEndpointGroupAssociationTransportSettings,
            settings.deleteInterceptEndpointGroupAssociationSettings(),
            clientContext);
    this.deleteInterceptEndpointGroupAssociationOperationCallable =
        callableFactory.createOperationCallable(
            deleteInterceptEndpointGroupAssociationTransportSettings,
            settings.deleteInterceptEndpointGroupAssociationOperationSettings(),
            clientContext,
            operationsStub);
    this.listInterceptDeploymentGroupsCallable =
        callableFactory.createUnaryCallable(
            listInterceptDeploymentGroupsTransportSettings,
            settings.listInterceptDeploymentGroupsSettings(),
            clientContext);
    this.listInterceptDeploymentGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listInterceptDeploymentGroupsTransportSettings,
            settings.listInterceptDeploymentGroupsSettings(),
            clientContext);
    this.getInterceptDeploymentGroupCallable =
        callableFactory.createUnaryCallable(
            getInterceptDeploymentGroupTransportSettings,
            settings.getInterceptDeploymentGroupSettings(),
            clientContext);
    this.createInterceptDeploymentGroupCallable =
        callableFactory.createUnaryCallable(
            createInterceptDeploymentGroupTransportSettings,
            settings.createInterceptDeploymentGroupSettings(),
            clientContext);
    this.createInterceptDeploymentGroupOperationCallable =
        callableFactory.createOperationCallable(
            createInterceptDeploymentGroupTransportSettings,
            settings.createInterceptDeploymentGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.updateInterceptDeploymentGroupCallable =
        callableFactory.createUnaryCallable(
            updateInterceptDeploymentGroupTransportSettings,
            settings.updateInterceptDeploymentGroupSettings(),
            clientContext);
    this.updateInterceptDeploymentGroupOperationCallable =
        callableFactory.createOperationCallable(
            updateInterceptDeploymentGroupTransportSettings,
            settings.updateInterceptDeploymentGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteInterceptDeploymentGroupCallable =
        callableFactory.createUnaryCallable(
            deleteInterceptDeploymentGroupTransportSettings,
            settings.deleteInterceptDeploymentGroupSettings(),
            clientContext);
    this.deleteInterceptDeploymentGroupOperationCallable =
        callableFactory.createOperationCallable(
            deleteInterceptDeploymentGroupTransportSettings,
            settings.deleteInterceptDeploymentGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.listInterceptDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listInterceptDeploymentsTransportSettings,
            settings.listInterceptDeploymentsSettings(),
            clientContext);
    this.listInterceptDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listInterceptDeploymentsTransportSettings,
            settings.listInterceptDeploymentsSettings(),
            clientContext);
    this.getInterceptDeploymentCallable =
        callableFactory.createUnaryCallable(
            getInterceptDeploymentTransportSettings,
            settings.getInterceptDeploymentSettings(),
            clientContext);
    this.createInterceptDeploymentCallable =
        callableFactory.createUnaryCallable(
            createInterceptDeploymentTransportSettings,
            settings.createInterceptDeploymentSettings(),
            clientContext);
    this.createInterceptDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            createInterceptDeploymentTransportSettings,
            settings.createInterceptDeploymentOperationSettings(),
            clientContext,
            operationsStub);
    this.updateInterceptDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateInterceptDeploymentTransportSettings,
            settings.updateInterceptDeploymentSettings(),
            clientContext);
    this.updateInterceptDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            updateInterceptDeploymentTransportSettings,
            settings.updateInterceptDeploymentOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteInterceptDeploymentCallable =
        callableFactory.createUnaryCallable(
            deleteInterceptDeploymentTransportSettings,
            settings.deleteInterceptDeploymentSettings(),
            clientContext);
    this.deleteInterceptDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            deleteInterceptDeploymentTransportSettings,
            settings.deleteInterceptDeploymentOperationSettings(),
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
  public UnaryCallable<ListInterceptEndpointGroupsRequest, ListInterceptEndpointGroupsResponse>
      listInterceptEndpointGroupsCallable() {
    return listInterceptEndpointGroupsCallable;
  }

  @Override
  public UnaryCallable<ListInterceptEndpointGroupsRequest, ListInterceptEndpointGroupsPagedResponse>
      listInterceptEndpointGroupsPagedCallable() {
    return listInterceptEndpointGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetInterceptEndpointGroupRequest, InterceptEndpointGroup>
      getInterceptEndpointGroupCallable() {
    return getInterceptEndpointGroupCallable;
  }

  @Override
  public UnaryCallable<CreateInterceptEndpointGroupRequest, Operation>
      createInterceptEndpointGroupCallable() {
    return createInterceptEndpointGroupCallable;
  }

  @Override
  public OperationCallable<
          CreateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
      createInterceptEndpointGroupOperationCallable() {
    return createInterceptEndpointGroupOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInterceptEndpointGroupRequest, Operation>
      updateInterceptEndpointGroupCallable() {
    return updateInterceptEndpointGroupCallable;
  }

  @Override
  public OperationCallable<
          UpdateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
      updateInterceptEndpointGroupOperationCallable() {
    return updateInterceptEndpointGroupOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInterceptEndpointGroupRequest, Operation>
      deleteInterceptEndpointGroupCallable() {
    return deleteInterceptEndpointGroupCallable;
  }

  @Override
  public OperationCallable<DeleteInterceptEndpointGroupRequest, Empty, OperationMetadata>
      deleteInterceptEndpointGroupOperationCallable() {
    return deleteInterceptEndpointGroupOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListInterceptEndpointGroupAssociationsRequest,
          ListInterceptEndpointGroupAssociationsResponse>
      listInterceptEndpointGroupAssociationsCallable() {
    return listInterceptEndpointGroupAssociationsCallable;
  }

  @Override
  public UnaryCallable<
          ListInterceptEndpointGroupAssociationsRequest,
          ListInterceptEndpointGroupAssociationsPagedResponse>
      listInterceptEndpointGroupAssociationsPagedCallable() {
    return listInterceptEndpointGroupAssociationsPagedCallable;
  }

  @Override
  public UnaryCallable<
          GetInterceptEndpointGroupAssociationRequest, InterceptEndpointGroupAssociation>
      getInterceptEndpointGroupAssociationCallable() {
    return getInterceptEndpointGroupAssociationCallable;
  }

  @Override
  public UnaryCallable<CreateInterceptEndpointGroupAssociationRequest, Operation>
      createInterceptEndpointGroupAssociationCallable() {
    return createInterceptEndpointGroupAssociationCallable;
  }

  @Override
  public OperationCallable<
          CreateInterceptEndpointGroupAssociationRequest,
          InterceptEndpointGroupAssociation,
          OperationMetadata>
      createInterceptEndpointGroupAssociationOperationCallable() {
    return createInterceptEndpointGroupAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInterceptEndpointGroupAssociationRequest, Operation>
      updateInterceptEndpointGroupAssociationCallable() {
    return updateInterceptEndpointGroupAssociationCallable;
  }

  @Override
  public OperationCallable<
          UpdateInterceptEndpointGroupAssociationRequest,
          InterceptEndpointGroupAssociation,
          OperationMetadata>
      updateInterceptEndpointGroupAssociationOperationCallable() {
    return updateInterceptEndpointGroupAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInterceptEndpointGroupAssociationRequest, Operation>
      deleteInterceptEndpointGroupAssociationCallable() {
    return deleteInterceptEndpointGroupAssociationCallable;
  }

  @Override
  public OperationCallable<DeleteInterceptEndpointGroupAssociationRequest, Empty, OperationMetadata>
      deleteInterceptEndpointGroupAssociationOperationCallable() {
    return deleteInterceptEndpointGroupAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<ListInterceptDeploymentGroupsRequest, ListInterceptDeploymentGroupsResponse>
      listInterceptDeploymentGroupsCallable() {
    return listInterceptDeploymentGroupsCallable;
  }

  @Override
  public UnaryCallable<
          ListInterceptDeploymentGroupsRequest, ListInterceptDeploymentGroupsPagedResponse>
      listInterceptDeploymentGroupsPagedCallable() {
    return listInterceptDeploymentGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetInterceptDeploymentGroupRequest, InterceptDeploymentGroup>
      getInterceptDeploymentGroupCallable() {
    return getInterceptDeploymentGroupCallable;
  }

  @Override
  public UnaryCallable<CreateInterceptDeploymentGroupRequest, Operation>
      createInterceptDeploymentGroupCallable() {
    return createInterceptDeploymentGroupCallable;
  }

  @Override
  public OperationCallable<
          CreateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
      createInterceptDeploymentGroupOperationCallable() {
    return createInterceptDeploymentGroupOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInterceptDeploymentGroupRequest, Operation>
      updateInterceptDeploymentGroupCallable() {
    return updateInterceptDeploymentGroupCallable;
  }

  @Override
  public OperationCallable<
          UpdateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
      updateInterceptDeploymentGroupOperationCallable() {
    return updateInterceptDeploymentGroupOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInterceptDeploymentGroupRequest, Operation>
      deleteInterceptDeploymentGroupCallable() {
    return deleteInterceptDeploymentGroupCallable;
  }

  @Override
  public OperationCallable<DeleteInterceptDeploymentGroupRequest, Empty, OperationMetadata>
      deleteInterceptDeploymentGroupOperationCallable() {
    return deleteInterceptDeploymentGroupOperationCallable;
  }

  @Override
  public UnaryCallable<ListInterceptDeploymentsRequest, ListInterceptDeploymentsResponse>
      listInterceptDeploymentsCallable() {
    return listInterceptDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListInterceptDeploymentsRequest, ListInterceptDeploymentsPagedResponse>
      listInterceptDeploymentsPagedCallable() {
    return listInterceptDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetInterceptDeploymentRequest, InterceptDeployment>
      getInterceptDeploymentCallable() {
    return getInterceptDeploymentCallable;
  }

  @Override
  public UnaryCallable<CreateInterceptDeploymentRequest, Operation>
      createInterceptDeploymentCallable() {
    return createInterceptDeploymentCallable;
  }

  @Override
  public OperationCallable<CreateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
      createInterceptDeploymentOperationCallable() {
    return createInterceptDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInterceptDeploymentRequest, Operation>
      updateInterceptDeploymentCallable() {
    return updateInterceptDeploymentCallable;
  }

  @Override
  public OperationCallable<UpdateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
      updateInterceptDeploymentOperationCallable() {
    return updateInterceptDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInterceptDeploymentRequest, Operation>
      deleteInterceptDeploymentCallable() {
    return deleteInterceptDeploymentCallable;
  }

  @Override
  public OperationCallable<DeleteInterceptDeploymentRequest, Empty, OperationMetadata>
      deleteInterceptDeploymentOperationCallable() {
    return deleteInterceptDeploymentOperationCallable;
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
