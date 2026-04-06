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

import static com.google.cloud.networksecurity.v1.MirroringClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringDeploymentGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringDeploymentsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringEndpointGroupAssociationsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringEndpointGroupsPagedResponse;

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
import com.google.cloud.networksecurity.v1.CreateMirroringDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.CreateMirroringDeploymentRequest;
import com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.CreateMirroringEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteMirroringDeploymentRequest;
import com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.GetMirroringDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.GetMirroringDeploymentRequest;
import com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.GetMirroringEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsRequest;
import com.google.cloud.networksecurity.v1.ListMirroringDeploymentGroupsResponse;
import com.google.cloud.networksecurity.v1.ListMirroringDeploymentsRequest;
import com.google.cloud.networksecurity.v1.ListMirroringDeploymentsResponse;
import com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsRequest;
import com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupAssociationsResponse;
import com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsRequest;
import com.google.cloud.networksecurity.v1.ListMirroringEndpointGroupsResponse;
import com.google.cloud.networksecurity.v1.MirroringDeployment;
import com.google.cloud.networksecurity.v1.MirroringDeploymentGroup;
import com.google.cloud.networksecurity.v1.MirroringEndpointGroup;
import com.google.cloud.networksecurity.v1.MirroringEndpointGroupAssociation;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentGroupRequest;
import com.google.cloud.networksecurity.v1.UpdateMirroringDeploymentRequest;
import com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupAssociationRequest;
import com.google.cloud.networksecurity.v1.UpdateMirroringEndpointGroupRequest;
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
 * gRPC stub implementation for the Mirroring service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcMirroringStub extends MirroringStub {
  private static final MethodDescriptor<
          ListMirroringEndpointGroupsRequest, ListMirroringEndpointGroupsResponse>
      listMirroringEndpointGroupsMethodDescriptor =
          MethodDescriptor
              .<ListMirroringEndpointGroupsRequest, ListMirroringEndpointGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/ListMirroringEndpointGroups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMirroringEndpointGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMirroringEndpointGroupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetMirroringEndpointGroupRequest, MirroringEndpointGroup>
      getMirroringEndpointGroupMethodDescriptor =
          MethodDescriptor.<GetMirroringEndpointGroupRequest, MirroringEndpointGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/GetMirroringEndpointGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMirroringEndpointGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(MirroringEndpointGroup.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateMirroringEndpointGroupRequest, Operation>
      createMirroringEndpointGroupMethodDescriptor =
          MethodDescriptor.<CreateMirroringEndpointGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/CreateMirroringEndpointGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMirroringEndpointGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateMirroringEndpointGroupRequest, Operation>
      updateMirroringEndpointGroupMethodDescriptor =
          MethodDescriptor.<UpdateMirroringEndpointGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/UpdateMirroringEndpointGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMirroringEndpointGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteMirroringEndpointGroupRequest, Operation>
      deleteMirroringEndpointGroupMethodDescriptor =
          MethodDescriptor.<DeleteMirroringEndpointGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/DeleteMirroringEndpointGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMirroringEndpointGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListMirroringEndpointGroupAssociationsRequest,
          ListMirroringEndpointGroupAssociationsResponse>
      listMirroringEndpointGroupAssociationsMethodDescriptor =
          MethodDescriptor
              .<ListMirroringEndpointGroupAssociationsRequest,
                  ListMirroringEndpointGroupAssociationsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/ListMirroringEndpointGroupAssociations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListMirroringEndpointGroupAssociationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListMirroringEndpointGroupAssociationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetMirroringEndpointGroupAssociationRequest, MirroringEndpointGroupAssociation>
      getMirroringEndpointGroupAssociationMethodDescriptor =
          MethodDescriptor
              .<GetMirroringEndpointGroupAssociationRequest, MirroringEndpointGroupAssociation>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/GetMirroringEndpointGroupAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetMirroringEndpointGroupAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(MirroringEndpointGroupAssociation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateMirroringEndpointGroupAssociationRequest, Operation>
      createMirroringEndpointGroupAssociationMethodDescriptor =
          MethodDescriptor.<CreateMirroringEndpointGroupAssociationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/CreateMirroringEndpointGroupAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateMirroringEndpointGroupAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateMirroringEndpointGroupAssociationRequest, Operation>
      updateMirroringEndpointGroupAssociationMethodDescriptor =
          MethodDescriptor.<UpdateMirroringEndpointGroupAssociationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/UpdateMirroringEndpointGroupAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateMirroringEndpointGroupAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteMirroringEndpointGroupAssociationRequest, Operation>
      deleteMirroringEndpointGroupAssociationMethodDescriptor =
          MethodDescriptor.<DeleteMirroringEndpointGroupAssociationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/DeleteMirroringEndpointGroupAssociation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteMirroringEndpointGroupAssociationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListMirroringDeploymentGroupsRequest, ListMirroringDeploymentGroupsResponse>
      listMirroringDeploymentGroupsMethodDescriptor =
          MethodDescriptor
              .<ListMirroringDeploymentGroupsRequest, ListMirroringDeploymentGroupsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/ListMirroringDeploymentGroups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMirroringDeploymentGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMirroringDeploymentGroupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetMirroringDeploymentGroupRequest, MirroringDeploymentGroup>
      getMirroringDeploymentGroupMethodDescriptor =
          MethodDescriptor
              .<GetMirroringDeploymentGroupRequest, MirroringDeploymentGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/GetMirroringDeploymentGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMirroringDeploymentGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(MirroringDeploymentGroup.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateMirroringDeploymentGroupRequest, Operation>
      createMirroringDeploymentGroupMethodDescriptor =
          MethodDescriptor.<CreateMirroringDeploymentGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/CreateMirroringDeploymentGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMirroringDeploymentGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateMirroringDeploymentGroupRequest, Operation>
      updateMirroringDeploymentGroupMethodDescriptor =
          MethodDescriptor.<UpdateMirroringDeploymentGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/UpdateMirroringDeploymentGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMirroringDeploymentGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteMirroringDeploymentGroupRequest, Operation>
      deleteMirroringDeploymentGroupMethodDescriptor =
          MethodDescriptor.<DeleteMirroringDeploymentGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/DeleteMirroringDeploymentGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMirroringDeploymentGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListMirroringDeploymentsRequest, ListMirroringDeploymentsResponse>
      listMirroringDeploymentsMethodDescriptor =
          MethodDescriptor
              .<ListMirroringDeploymentsRequest, ListMirroringDeploymentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/ListMirroringDeployments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMirroringDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMirroringDeploymentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetMirroringDeploymentRequest, MirroringDeployment>
      getMirroringDeploymentMethodDescriptor =
          MethodDescriptor.<GetMirroringDeploymentRequest, MirroringDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networksecurity.v1.Mirroring/GetMirroringDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMirroringDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(MirroringDeployment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateMirroringDeploymentRequest, Operation>
      createMirroringDeploymentMethodDescriptor =
          MethodDescriptor.<CreateMirroringDeploymentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/CreateMirroringDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMirroringDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateMirroringDeploymentRequest, Operation>
      updateMirroringDeploymentMethodDescriptor =
          MethodDescriptor.<UpdateMirroringDeploymentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/UpdateMirroringDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMirroringDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteMirroringDeploymentRequest, Operation>
      deleteMirroringDeploymentMethodDescriptor =
          MethodDescriptor.<DeleteMirroringDeploymentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.Mirroring/DeleteMirroringDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMirroringDeploymentRequest.getDefaultInstance()))
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
          ListMirroringEndpointGroupsRequest, ListMirroringEndpointGroupsResponse>
      listMirroringEndpointGroupsCallable;
  private final UnaryCallable<
          ListMirroringEndpointGroupsRequest, ListMirroringEndpointGroupsPagedResponse>
      listMirroringEndpointGroupsPagedCallable;
  private final UnaryCallable<GetMirroringEndpointGroupRequest, MirroringEndpointGroup>
      getMirroringEndpointGroupCallable;
  private final UnaryCallable<CreateMirroringEndpointGroupRequest, Operation>
      createMirroringEndpointGroupCallable;
  private final OperationCallable<
          CreateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
      createMirroringEndpointGroupOperationCallable;
  private final UnaryCallable<UpdateMirroringEndpointGroupRequest, Operation>
      updateMirroringEndpointGroupCallable;
  private final OperationCallable<
          UpdateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
      updateMirroringEndpointGroupOperationCallable;
  private final UnaryCallable<DeleteMirroringEndpointGroupRequest, Operation>
      deleteMirroringEndpointGroupCallable;
  private final OperationCallable<DeleteMirroringEndpointGroupRequest, Empty, OperationMetadata>
      deleteMirroringEndpointGroupOperationCallable;
  private final UnaryCallable<
          ListMirroringEndpointGroupAssociationsRequest,
          ListMirroringEndpointGroupAssociationsResponse>
      listMirroringEndpointGroupAssociationsCallable;
  private final UnaryCallable<
          ListMirroringEndpointGroupAssociationsRequest,
          ListMirroringEndpointGroupAssociationsPagedResponse>
      listMirroringEndpointGroupAssociationsPagedCallable;
  private final UnaryCallable<
          GetMirroringEndpointGroupAssociationRequest, MirroringEndpointGroupAssociation>
      getMirroringEndpointGroupAssociationCallable;
  private final UnaryCallable<CreateMirroringEndpointGroupAssociationRequest, Operation>
      createMirroringEndpointGroupAssociationCallable;
  private final OperationCallable<
          CreateMirroringEndpointGroupAssociationRequest,
          MirroringEndpointGroupAssociation,
          OperationMetadata>
      createMirroringEndpointGroupAssociationOperationCallable;
  private final UnaryCallable<UpdateMirroringEndpointGroupAssociationRequest, Operation>
      updateMirroringEndpointGroupAssociationCallable;
  private final OperationCallable<
          UpdateMirroringEndpointGroupAssociationRequest,
          MirroringEndpointGroupAssociation,
          OperationMetadata>
      updateMirroringEndpointGroupAssociationOperationCallable;
  private final UnaryCallable<DeleteMirroringEndpointGroupAssociationRequest, Operation>
      deleteMirroringEndpointGroupAssociationCallable;
  private final OperationCallable<
          DeleteMirroringEndpointGroupAssociationRequest, Empty, OperationMetadata>
      deleteMirroringEndpointGroupAssociationOperationCallable;
  private final UnaryCallable<
          ListMirroringDeploymentGroupsRequest, ListMirroringDeploymentGroupsResponse>
      listMirroringDeploymentGroupsCallable;
  private final UnaryCallable<
          ListMirroringDeploymentGroupsRequest, ListMirroringDeploymentGroupsPagedResponse>
      listMirroringDeploymentGroupsPagedCallable;
  private final UnaryCallable<GetMirroringDeploymentGroupRequest, MirroringDeploymentGroup>
      getMirroringDeploymentGroupCallable;
  private final UnaryCallable<CreateMirroringDeploymentGroupRequest, Operation>
      createMirroringDeploymentGroupCallable;
  private final OperationCallable<
          CreateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
      createMirroringDeploymentGroupOperationCallable;
  private final UnaryCallable<UpdateMirroringDeploymentGroupRequest, Operation>
      updateMirroringDeploymentGroupCallable;
  private final OperationCallable<
          UpdateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
      updateMirroringDeploymentGroupOperationCallable;
  private final UnaryCallable<DeleteMirroringDeploymentGroupRequest, Operation>
      deleteMirroringDeploymentGroupCallable;
  private final OperationCallable<DeleteMirroringDeploymentGroupRequest, Empty, OperationMetadata>
      deleteMirroringDeploymentGroupOperationCallable;
  private final UnaryCallable<ListMirroringDeploymentsRequest, ListMirroringDeploymentsResponse>
      listMirroringDeploymentsCallable;
  private final UnaryCallable<
          ListMirroringDeploymentsRequest, ListMirroringDeploymentsPagedResponse>
      listMirroringDeploymentsPagedCallable;
  private final UnaryCallable<GetMirroringDeploymentRequest, MirroringDeployment>
      getMirroringDeploymentCallable;
  private final UnaryCallable<CreateMirroringDeploymentRequest, Operation>
      createMirroringDeploymentCallable;
  private final OperationCallable<
          CreateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
      createMirroringDeploymentOperationCallable;
  private final UnaryCallable<UpdateMirroringDeploymentRequest, Operation>
      updateMirroringDeploymentCallable;
  private final OperationCallable<
          UpdateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
      updateMirroringDeploymentOperationCallable;
  private final UnaryCallable<DeleteMirroringDeploymentRequest, Operation>
      deleteMirroringDeploymentCallable;
  private final OperationCallable<DeleteMirroringDeploymentRequest, Empty, OperationMetadata>
      deleteMirroringDeploymentOperationCallable;
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

  public static final GrpcMirroringStub create(MirroringStubSettings settings) throws IOException {
    return new GrpcMirroringStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMirroringStub create(ClientContext clientContext) throws IOException {
    return new GrpcMirroringStub(MirroringStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMirroringStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMirroringStub(
        MirroringStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMirroringStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMirroringStub(MirroringStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcMirroringCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMirroringStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMirroringStub(
      MirroringStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListMirroringEndpointGroupsRequest, ListMirroringEndpointGroupsResponse>
        listMirroringEndpointGroupsTransportSettings =
            GrpcCallSettings
                .<ListMirroringEndpointGroupsRequest, ListMirroringEndpointGroupsResponse>
                    newBuilder()
                .setMethodDescriptor(listMirroringEndpointGroupsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetMirroringEndpointGroupRequest, MirroringEndpointGroup>
        getMirroringEndpointGroupTransportSettings =
            GrpcCallSettings.<GetMirroringEndpointGroupRequest, MirroringEndpointGroup>newBuilder()
                .setMethodDescriptor(getMirroringEndpointGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateMirroringEndpointGroupRequest, Operation>
        createMirroringEndpointGroupTransportSettings =
            GrpcCallSettings.<CreateMirroringEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(createMirroringEndpointGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateMirroringEndpointGroupRequest, Operation>
        updateMirroringEndpointGroupTransportSettings =
            GrpcCallSettings.<UpdateMirroringEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(updateMirroringEndpointGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "mirroring_endpoint_group.name",
                          String.valueOf(request.getMirroringEndpointGroup().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteMirroringEndpointGroupRequest, Operation>
        deleteMirroringEndpointGroupTransportSettings =
            GrpcCallSettings.<DeleteMirroringEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMirroringEndpointGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<
            ListMirroringEndpointGroupAssociationsRequest,
            ListMirroringEndpointGroupAssociationsResponse>
        listMirroringEndpointGroupAssociationsTransportSettings =
            GrpcCallSettings
                .<ListMirroringEndpointGroupAssociationsRequest,
                    ListMirroringEndpointGroupAssociationsResponse>
                    newBuilder()
                .setMethodDescriptor(listMirroringEndpointGroupAssociationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetMirroringEndpointGroupAssociationRequest, MirroringEndpointGroupAssociation>
        getMirroringEndpointGroupAssociationTransportSettings =
            GrpcCallSettings
                .<GetMirroringEndpointGroupAssociationRequest, MirroringEndpointGroupAssociation>
                    newBuilder()
                .setMethodDescriptor(getMirroringEndpointGroupAssociationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateMirroringEndpointGroupAssociationRequest, Operation>
        createMirroringEndpointGroupAssociationTransportSettings =
            GrpcCallSettings.<CreateMirroringEndpointGroupAssociationRequest, Operation>newBuilder()
                .setMethodDescriptor(createMirroringEndpointGroupAssociationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateMirroringEndpointGroupAssociationRequest, Operation>
        updateMirroringEndpointGroupAssociationTransportSettings =
            GrpcCallSettings.<UpdateMirroringEndpointGroupAssociationRequest, Operation>newBuilder()
                .setMethodDescriptor(updateMirroringEndpointGroupAssociationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "mirroring_endpoint_group_association.name",
                          String.valueOf(request.getMirroringEndpointGroupAssociation().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteMirroringEndpointGroupAssociationRequest, Operation>
        deleteMirroringEndpointGroupAssociationTransportSettings =
            GrpcCallSettings.<DeleteMirroringEndpointGroupAssociationRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMirroringEndpointGroupAssociationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListMirroringDeploymentGroupsRequest, ListMirroringDeploymentGroupsResponse>
        listMirroringDeploymentGroupsTransportSettings =
            GrpcCallSettings
                .<ListMirroringDeploymentGroupsRequest, ListMirroringDeploymentGroupsResponse>
                    newBuilder()
                .setMethodDescriptor(listMirroringDeploymentGroupsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetMirroringDeploymentGroupRequest, MirroringDeploymentGroup>
        getMirroringDeploymentGroupTransportSettings =
            GrpcCallSettings
                .<GetMirroringDeploymentGroupRequest, MirroringDeploymentGroup>newBuilder()
                .setMethodDescriptor(getMirroringDeploymentGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateMirroringDeploymentGroupRequest, Operation>
        createMirroringDeploymentGroupTransportSettings =
            GrpcCallSettings.<CreateMirroringDeploymentGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(createMirroringDeploymentGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateMirroringDeploymentGroupRequest, Operation>
        updateMirroringDeploymentGroupTransportSettings =
            GrpcCallSettings.<UpdateMirroringDeploymentGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(updateMirroringDeploymentGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "mirroring_deployment_group.name",
                          String.valueOf(request.getMirroringDeploymentGroup().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteMirroringDeploymentGroupRequest, Operation>
        deleteMirroringDeploymentGroupTransportSettings =
            GrpcCallSettings.<DeleteMirroringDeploymentGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMirroringDeploymentGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListMirroringDeploymentsRequest, ListMirroringDeploymentsResponse>
        listMirroringDeploymentsTransportSettings =
            GrpcCallSettings
                .<ListMirroringDeploymentsRequest, ListMirroringDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listMirroringDeploymentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetMirroringDeploymentRequest, MirroringDeployment>
        getMirroringDeploymentTransportSettings =
            GrpcCallSettings.<GetMirroringDeploymentRequest, MirroringDeployment>newBuilder()
                .setMethodDescriptor(getMirroringDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateMirroringDeploymentRequest, Operation>
        createMirroringDeploymentTransportSettings =
            GrpcCallSettings.<CreateMirroringDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(createMirroringDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateMirroringDeploymentRequest, Operation>
        updateMirroringDeploymentTransportSettings =
            GrpcCallSettings.<UpdateMirroringDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(updateMirroringDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "mirroring_deployment.name",
                          String.valueOf(request.getMirroringDeployment().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteMirroringDeploymentRequest, Operation>
        deleteMirroringDeploymentTransportSettings =
            GrpcCallSettings.<DeleteMirroringDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMirroringDeploymentMethodDescriptor)
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

    this.listMirroringEndpointGroupsCallable =
        callableFactory.createUnaryCallable(
            listMirroringEndpointGroupsTransportSettings,
            settings.listMirroringEndpointGroupsSettings(),
            clientContext);
    this.listMirroringEndpointGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listMirroringEndpointGroupsTransportSettings,
            settings.listMirroringEndpointGroupsSettings(),
            clientContext);
    this.getMirroringEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            getMirroringEndpointGroupTransportSettings,
            settings.getMirroringEndpointGroupSettings(),
            clientContext);
    this.createMirroringEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            createMirroringEndpointGroupTransportSettings,
            settings.createMirroringEndpointGroupSettings(),
            clientContext);
    this.createMirroringEndpointGroupOperationCallable =
        callableFactory.createOperationCallable(
            createMirroringEndpointGroupTransportSettings,
            settings.createMirroringEndpointGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.updateMirroringEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            updateMirroringEndpointGroupTransportSettings,
            settings.updateMirroringEndpointGroupSettings(),
            clientContext);
    this.updateMirroringEndpointGroupOperationCallable =
        callableFactory.createOperationCallable(
            updateMirroringEndpointGroupTransportSettings,
            settings.updateMirroringEndpointGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteMirroringEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            deleteMirroringEndpointGroupTransportSettings,
            settings.deleteMirroringEndpointGroupSettings(),
            clientContext);
    this.deleteMirroringEndpointGroupOperationCallable =
        callableFactory.createOperationCallable(
            deleteMirroringEndpointGroupTransportSettings,
            settings.deleteMirroringEndpointGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.listMirroringEndpointGroupAssociationsCallable =
        callableFactory.createUnaryCallable(
            listMirroringEndpointGroupAssociationsTransportSettings,
            settings.listMirroringEndpointGroupAssociationsSettings(),
            clientContext);
    this.listMirroringEndpointGroupAssociationsPagedCallable =
        callableFactory.createPagedCallable(
            listMirroringEndpointGroupAssociationsTransportSettings,
            settings.listMirroringEndpointGroupAssociationsSettings(),
            clientContext);
    this.getMirroringEndpointGroupAssociationCallable =
        callableFactory.createUnaryCallable(
            getMirroringEndpointGroupAssociationTransportSettings,
            settings.getMirroringEndpointGroupAssociationSettings(),
            clientContext);
    this.createMirroringEndpointGroupAssociationCallable =
        callableFactory.createUnaryCallable(
            createMirroringEndpointGroupAssociationTransportSettings,
            settings.createMirroringEndpointGroupAssociationSettings(),
            clientContext);
    this.createMirroringEndpointGroupAssociationOperationCallable =
        callableFactory.createOperationCallable(
            createMirroringEndpointGroupAssociationTransportSettings,
            settings.createMirroringEndpointGroupAssociationOperationSettings(),
            clientContext,
            operationsStub);
    this.updateMirroringEndpointGroupAssociationCallable =
        callableFactory.createUnaryCallable(
            updateMirroringEndpointGroupAssociationTransportSettings,
            settings.updateMirroringEndpointGroupAssociationSettings(),
            clientContext);
    this.updateMirroringEndpointGroupAssociationOperationCallable =
        callableFactory.createOperationCallable(
            updateMirroringEndpointGroupAssociationTransportSettings,
            settings.updateMirroringEndpointGroupAssociationOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteMirroringEndpointGroupAssociationCallable =
        callableFactory.createUnaryCallable(
            deleteMirroringEndpointGroupAssociationTransportSettings,
            settings.deleteMirroringEndpointGroupAssociationSettings(),
            clientContext);
    this.deleteMirroringEndpointGroupAssociationOperationCallable =
        callableFactory.createOperationCallable(
            deleteMirroringEndpointGroupAssociationTransportSettings,
            settings.deleteMirroringEndpointGroupAssociationOperationSettings(),
            clientContext,
            operationsStub);
    this.listMirroringDeploymentGroupsCallable =
        callableFactory.createUnaryCallable(
            listMirroringDeploymentGroupsTransportSettings,
            settings.listMirroringDeploymentGroupsSettings(),
            clientContext);
    this.listMirroringDeploymentGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listMirroringDeploymentGroupsTransportSettings,
            settings.listMirroringDeploymentGroupsSettings(),
            clientContext);
    this.getMirroringDeploymentGroupCallable =
        callableFactory.createUnaryCallable(
            getMirroringDeploymentGroupTransportSettings,
            settings.getMirroringDeploymentGroupSettings(),
            clientContext);
    this.createMirroringDeploymentGroupCallable =
        callableFactory.createUnaryCallable(
            createMirroringDeploymentGroupTransportSettings,
            settings.createMirroringDeploymentGroupSettings(),
            clientContext);
    this.createMirroringDeploymentGroupOperationCallable =
        callableFactory.createOperationCallable(
            createMirroringDeploymentGroupTransportSettings,
            settings.createMirroringDeploymentGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.updateMirroringDeploymentGroupCallable =
        callableFactory.createUnaryCallable(
            updateMirroringDeploymentGroupTransportSettings,
            settings.updateMirroringDeploymentGroupSettings(),
            clientContext);
    this.updateMirroringDeploymentGroupOperationCallable =
        callableFactory.createOperationCallable(
            updateMirroringDeploymentGroupTransportSettings,
            settings.updateMirroringDeploymentGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteMirroringDeploymentGroupCallable =
        callableFactory.createUnaryCallable(
            deleteMirroringDeploymentGroupTransportSettings,
            settings.deleteMirroringDeploymentGroupSettings(),
            clientContext);
    this.deleteMirroringDeploymentGroupOperationCallable =
        callableFactory.createOperationCallable(
            deleteMirroringDeploymentGroupTransportSettings,
            settings.deleteMirroringDeploymentGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.listMirroringDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listMirroringDeploymentsTransportSettings,
            settings.listMirroringDeploymentsSettings(),
            clientContext);
    this.listMirroringDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listMirroringDeploymentsTransportSettings,
            settings.listMirroringDeploymentsSettings(),
            clientContext);
    this.getMirroringDeploymentCallable =
        callableFactory.createUnaryCallable(
            getMirroringDeploymentTransportSettings,
            settings.getMirroringDeploymentSettings(),
            clientContext);
    this.createMirroringDeploymentCallable =
        callableFactory.createUnaryCallable(
            createMirroringDeploymentTransportSettings,
            settings.createMirroringDeploymentSettings(),
            clientContext);
    this.createMirroringDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            createMirroringDeploymentTransportSettings,
            settings.createMirroringDeploymentOperationSettings(),
            clientContext,
            operationsStub);
    this.updateMirroringDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateMirroringDeploymentTransportSettings,
            settings.updateMirroringDeploymentSettings(),
            clientContext);
    this.updateMirroringDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            updateMirroringDeploymentTransportSettings,
            settings.updateMirroringDeploymentOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteMirroringDeploymentCallable =
        callableFactory.createUnaryCallable(
            deleteMirroringDeploymentTransportSettings,
            settings.deleteMirroringDeploymentSettings(),
            clientContext);
    this.deleteMirroringDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            deleteMirroringDeploymentTransportSettings,
            settings.deleteMirroringDeploymentOperationSettings(),
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
  public UnaryCallable<ListMirroringEndpointGroupsRequest, ListMirroringEndpointGroupsResponse>
      listMirroringEndpointGroupsCallable() {
    return listMirroringEndpointGroupsCallable;
  }

  @Override
  public UnaryCallable<ListMirroringEndpointGroupsRequest, ListMirroringEndpointGroupsPagedResponse>
      listMirroringEndpointGroupsPagedCallable() {
    return listMirroringEndpointGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetMirroringEndpointGroupRequest, MirroringEndpointGroup>
      getMirroringEndpointGroupCallable() {
    return getMirroringEndpointGroupCallable;
  }

  @Override
  public UnaryCallable<CreateMirroringEndpointGroupRequest, Operation>
      createMirroringEndpointGroupCallable() {
    return createMirroringEndpointGroupCallable;
  }

  @Override
  public OperationCallable<
          CreateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
      createMirroringEndpointGroupOperationCallable() {
    return createMirroringEndpointGroupOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMirroringEndpointGroupRequest, Operation>
      updateMirroringEndpointGroupCallable() {
    return updateMirroringEndpointGroupCallable;
  }

  @Override
  public OperationCallable<
          UpdateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
      updateMirroringEndpointGroupOperationCallable() {
    return updateMirroringEndpointGroupOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMirroringEndpointGroupRequest, Operation>
      deleteMirroringEndpointGroupCallable() {
    return deleteMirroringEndpointGroupCallable;
  }

  @Override
  public OperationCallable<DeleteMirroringEndpointGroupRequest, Empty, OperationMetadata>
      deleteMirroringEndpointGroupOperationCallable() {
    return deleteMirroringEndpointGroupOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListMirroringEndpointGroupAssociationsRequest,
          ListMirroringEndpointGroupAssociationsResponse>
      listMirroringEndpointGroupAssociationsCallable() {
    return listMirroringEndpointGroupAssociationsCallable;
  }

  @Override
  public UnaryCallable<
          ListMirroringEndpointGroupAssociationsRequest,
          ListMirroringEndpointGroupAssociationsPagedResponse>
      listMirroringEndpointGroupAssociationsPagedCallable() {
    return listMirroringEndpointGroupAssociationsPagedCallable;
  }

  @Override
  public UnaryCallable<
          GetMirroringEndpointGroupAssociationRequest, MirroringEndpointGroupAssociation>
      getMirroringEndpointGroupAssociationCallable() {
    return getMirroringEndpointGroupAssociationCallable;
  }

  @Override
  public UnaryCallable<CreateMirroringEndpointGroupAssociationRequest, Operation>
      createMirroringEndpointGroupAssociationCallable() {
    return createMirroringEndpointGroupAssociationCallable;
  }

  @Override
  public OperationCallable<
          CreateMirroringEndpointGroupAssociationRequest,
          MirroringEndpointGroupAssociation,
          OperationMetadata>
      createMirroringEndpointGroupAssociationOperationCallable() {
    return createMirroringEndpointGroupAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMirroringEndpointGroupAssociationRequest, Operation>
      updateMirroringEndpointGroupAssociationCallable() {
    return updateMirroringEndpointGroupAssociationCallable;
  }

  @Override
  public OperationCallable<
          UpdateMirroringEndpointGroupAssociationRequest,
          MirroringEndpointGroupAssociation,
          OperationMetadata>
      updateMirroringEndpointGroupAssociationOperationCallable() {
    return updateMirroringEndpointGroupAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMirroringEndpointGroupAssociationRequest, Operation>
      deleteMirroringEndpointGroupAssociationCallable() {
    return deleteMirroringEndpointGroupAssociationCallable;
  }

  @Override
  public OperationCallable<DeleteMirroringEndpointGroupAssociationRequest, Empty, OperationMetadata>
      deleteMirroringEndpointGroupAssociationOperationCallable() {
    return deleteMirroringEndpointGroupAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<ListMirroringDeploymentGroupsRequest, ListMirroringDeploymentGroupsResponse>
      listMirroringDeploymentGroupsCallable() {
    return listMirroringDeploymentGroupsCallable;
  }

  @Override
  public UnaryCallable<
          ListMirroringDeploymentGroupsRequest, ListMirroringDeploymentGroupsPagedResponse>
      listMirroringDeploymentGroupsPagedCallable() {
    return listMirroringDeploymentGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetMirroringDeploymentGroupRequest, MirroringDeploymentGroup>
      getMirroringDeploymentGroupCallable() {
    return getMirroringDeploymentGroupCallable;
  }

  @Override
  public UnaryCallable<CreateMirroringDeploymentGroupRequest, Operation>
      createMirroringDeploymentGroupCallable() {
    return createMirroringDeploymentGroupCallable;
  }

  @Override
  public OperationCallable<
          CreateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
      createMirroringDeploymentGroupOperationCallable() {
    return createMirroringDeploymentGroupOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMirroringDeploymentGroupRequest, Operation>
      updateMirroringDeploymentGroupCallable() {
    return updateMirroringDeploymentGroupCallable;
  }

  @Override
  public OperationCallable<
          UpdateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
      updateMirroringDeploymentGroupOperationCallable() {
    return updateMirroringDeploymentGroupOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMirroringDeploymentGroupRequest, Operation>
      deleteMirroringDeploymentGroupCallable() {
    return deleteMirroringDeploymentGroupCallable;
  }

  @Override
  public OperationCallable<DeleteMirroringDeploymentGroupRequest, Empty, OperationMetadata>
      deleteMirroringDeploymentGroupOperationCallable() {
    return deleteMirroringDeploymentGroupOperationCallable;
  }

  @Override
  public UnaryCallable<ListMirroringDeploymentsRequest, ListMirroringDeploymentsResponse>
      listMirroringDeploymentsCallable() {
    return listMirroringDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListMirroringDeploymentsRequest, ListMirroringDeploymentsPagedResponse>
      listMirroringDeploymentsPagedCallable() {
    return listMirroringDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetMirroringDeploymentRequest, MirroringDeployment>
      getMirroringDeploymentCallable() {
    return getMirroringDeploymentCallable;
  }

  @Override
  public UnaryCallable<CreateMirroringDeploymentRequest, Operation>
      createMirroringDeploymentCallable() {
    return createMirroringDeploymentCallable;
  }

  @Override
  public OperationCallable<CreateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
      createMirroringDeploymentOperationCallable() {
    return createMirroringDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMirroringDeploymentRequest, Operation>
      updateMirroringDeploymentCallable() {
    return updateMirroringDeploymentCallable;
  }

  @Override
  public OperationCallable<UpdateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
      updateMirroringDeploymentOperationCallable() {
    return updateMirroringDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMirroringDeploymentRequest, Operation>
      deleteMirroringDeploymentCallable() {
    return deleteMirroringDeploymentCallable;
  }

  @Override
  public OperationCallable<DeleteMirroringDeploymentRequest, Empty, OperationMetadata>
      deleteMirroringDeploymentOperationCallable() {
    return deleteMirroringDeploymentOperationCallable;
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
