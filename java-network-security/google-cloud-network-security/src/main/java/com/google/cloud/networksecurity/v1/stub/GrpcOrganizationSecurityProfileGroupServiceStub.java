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

import static com.google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupServiceClient.ListSecurityProfileGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupServiceClient.ListSecurityProfilesPagedResponse;

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
import com.google.cloud.networksecurity.v1.CreateSecurityProfileGroupRequest;
import com.google.cloud.networksecurity.v1.CreateSecurityProfileRequest;
import com.google.cloud.networksecurity.v1.DeleteSecurityProfileGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteSecurityProfileRequest;
import com.google.cloud.networksecurity.v1.GetSecurityProfileGroupRequest;
import com.google.cloud.networksecurity.v1.GetSecurityProfileRequest;
import com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsRequest;
import com.google.cloud.networksecurity.v1.ListSecurityProfileGroupsResponse;
import com.google.cloud.networksecurity.v1.ListSecurityProfilesRequest;
import com.google.cloud.networksecurity.v1.ListSecurityProfilesResponse;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.SecurityProfile;
import com.google.cloud.networksecurity.v1.SecurityProfileGroup;
import com.google.cloud.networksecurity.v1.UpdateSecurityProfileGroupRequest;
import com.google.cloud.networksecurity.v1.UpdateSecurityProfileRequest;
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
 * gRPC stub implementation for the OrganizationSecurityProfileGroupService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcOrganizationSecurityProfileGroupServiceStub
    extends OrganizationSecurityProfileGroupServiceStub {
  private static final MethodDescriptor<
          ListSecurityProfileGroupsRequest, ListSecurityProfileGroupsResponse>
      listSecurityProfileGroupsMethodDescriptor =
          MethodDescriptor
              .<ListSecurityProfileGroupsRequest, ListSecurityProfileGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupService/ListSecurityProfileGroups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSecurityProfileGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSecurityProfileGroupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSecurityProfileGroupRequest, SecurityProfileGroup>
      getSecurityProfileGroupMethodDescriptor =
          MethodDescriptor.<GetSecurityProfileGroupRequest, SecurityProfileGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupService/GetSecurityProfileGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSecurityProfileGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SecurityProfileGroup.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateSecurityProfileGroupRequest, Operation>
      createSecurityProfileGroupMethodDescriptor =
          MethodDescriptor.<CreateSecurityProfileGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupService/CreateSecurityProfileGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSecurityProfileGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateSecurityProfileGroupRequest, Operation>
      updateSecurityProfileGroupMethodDescriptor =
          MethodDescriptor.<UpdateSecurityProfileGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupService/UpdateSecurityProfileGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSecurityProfileGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteSecurityProfileGroupRequest, Operation>
      deleteSecurityProfileGroupMethodDescriptor =
          MethodDescriptor.<DeleteSecurityProfileGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupService/DeleteSecurityProfileGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSecurityProfileGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListSecurityProfilesRequest, ListSecurityProfilesResponse>
      listSecurityProfilesMethodDescriptor =
          MethodDescriptor.<ListSecurityProfilesRequest, ListSecurityProfilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupService/ListSecurityProfiles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSecurityProfilesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSecurityProfilesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSecurityProfileRequest, SecurityProfile>
      getSecurityProfileMethodDescriptor =
          MethodDescriptor.<GetSecurityProfileRequest, SecurityProfile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupService/GetSecurityProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSecurityProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SecurityProfile.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateSecurityProfileRequest, Operation>
      createSecurityProfileMethodDescriptor =
          MethodDescriptor.<CreateSecurityProfileRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupService/CreateSecurityProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSecurityProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateSecurityProfileRequest, Operation>
      updateSecurityProfileMethodDescriptor =
          MethodDescriptor.<UpdateSecurityProfileRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupService/UpdateSecurityProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSecurityProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteSecurityProfileRequest, Operation>
      deleteSecurityProfileMethodDescriptor =
          MethodDescriptor.<DeleteSecurityProfileRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupService/DeleteSecurityProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSecurityProfileRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListSecurityProfileGroupsRequest, ListSecurityProfileGroupsResponse>
      listSecurityProfileGroupsCallable;
  private final UnaryCallable<
          ListSecurityProfileGroupsRequest, ListSecurityProfileGroupsPagedResponse>
      listSecurityProfileGroupsPagedCallable;
  private final UnaryCallable<GetSecurityProfileGroupRequest, SecurityProfileGroup>
      getSecurityProfileGroupCallable;
  private final UnaryCallable<CreateSecurityProfileGroupRequest, Operation>
      createSecurityProfileGroupCallable;
  private final OperationCallable<
          CreateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
      createSecurityProfileGroupOperationCallable;
  private final UnaryCallable<UpdateSecurityProfileGroupRequest, Operation>
      updateSecurityProfileGroupCallable;
  private final OperationCallable<
          UpdateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
      updateSecurityProfileGroupOperationCallable;
  private final UnaryCallable<DeleteSecurityProfileGroupRequest, Operation>
      deleteSecurityProfileGroupCallable;
  private final OperationCallable<DeleteSecurityProfileGroupRequest, Empty, OperationMetadata>
      deleteSecurityProfileGroupOperationCallable;
  private final UnaryCallable<ListSecurityProfilesRequest, ListSecurityProfilesResponse>
      listSecurityProfilesCallable;
  private final UnaryCallable<ListSecurityProfilesRequest, ListSecurityProfilesPagedResponse>
      listSecurityProfilesPagedCallable;
  private final UnaryCallable<GetSecurityProfileRequest, SecurityProfile>
      getSecurityProfileCallable;
  private final UnaryCallable<CreateSecurityProfileRequest, Operation>
      createSecurityProfileCallable;
  private final OperationCallable<CreateSecurityProfileRequest, SecurityProfile, OperationMetadata>
      createSecurityProfileOperationCallable;
  private final UnaryCallable<UpdateSecurityProfileRequest, Operation>
      updateSecurityProfileCallable;
  private final OperationCallable<UpdateSecurityProfileRequest, SecurityProfile, OperationMetadata>
      updateSecurityProfileOperationCallable;
  private final UnaryCallable<DeleteSecurityProfileRequest, Operation>
      deleteSecurityProfileCallable;
  private final OperationCallable<DeleteSecurityProfileRequest, Empty, OperationMetadata>
      deleteSecurityProfileOperationCallable;
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

  public static final GrpcOrganizationSecurityProfileGroupServiceStub create(
      OrganizationSecurityProfileGroupServiceStubSettings settings) throws IOException {
    return new GrpcOrganizationSecurityProfileGroupServiceStub(
        settings, ClientContext.create(settings));
  }

  public static final GrpcOrganizationSecurityProfileGroupServiceStub create(
      ClientContext clientContext) throws IOException {
    return new GrpcOrganizationSecurityProfileGroupServiceStub(
        OrganizationSecurityProfileGroupServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcOrganizationSecurityProfileGroupServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcOrganizationSecurityProfileGroupServiceStub(
        OrganizationSecurityProfileGroupServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcOrganizationSecurityProfileGroupServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected GrpcOrganizationSecurityProfileGroupServiceStub(
      OrganizationSecurityProfileGroupServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcOrganizationSecurityProfileGroupServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcOrganizationSecurityProfileGroupServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected GrpcOrganizationSecurityProfileGroupServiceStub(
      OrganizationSecurityProfileGroupServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListSecurityProfileGroupsRequest, ListSecurityProfileGroupsResponse>
        listSecurityProfileGroupsTransportSettings =
            GrpcCallSettings
                .<ListSecurityProfileGroupsRequest, ListSecurityProfileGroupsResponse>newBuilder()
                .setMethodDescriptor(listSecurityProfileGroupsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetSecurityProfileGroupRequest, SecurityProfileGroup>
        getSecurityProfileGroupTransportSettings =
            GrpcCallSettings.<GetSecurityProfileGroupRequest, SecurityProfileGroup>newBuilder()
                .setMethodDescriptor(getSecurityProfileGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateSecurityProfileGroupRequest, Operation>
        createSecurityProfileGroupTransportSettings =
            GrpcCallSettings.<CreateSecurityProfileGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(createSecurityProfileGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateSecurityProfileGroupRequest, Operation>
        updateSecurityProfileGroupTransportSettings =
            GrpcCallSettings.<UpdateSecurityProfileGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(updateSecurityProfileGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "security_profile_group.name",
                          String.valueOf(request.getSecurityProfileGroup().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteSecurityProfileGroupRequest, Operation>
        deleteSecurityProfileGroupTransportSettings =
            GrpcCallSettings.<DeleteSecurityProfileGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteSecurityProfileGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListSecurityProfilesRequest, ListSecurityProfilesResponse>
        listSecurityProfilesTransportSettings =
            GrpcCallSettings.<ListSecurityProfilesRequest, ListSecurityProfilesResponse>newBuilder()
                .setMethodDescriptor(listSecurityProfilesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetSecurityProfileRequest, SecurityProfile>
        getSecurityProfileTransportSettings =
            GrpcCallSettings.<GetSecurityProfileRequest, SecurityProfile>newBuilder()
                .setMethodDescriptor(getSecurityProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateSecurityProfileRequest, Operation>
        createSecurityProfileTransportSettings =
            GrpcCallSettings.<CreateSecurityProfileRequest, Operation>newBuilder()
                .setMethodDescriptor(createSecurityProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateSecurityProfileRequest, Operation>
        updateSecurityProfileTransportSettings =
            GrpcCallSettings.<UpdateSecurityProfileRequest, Operation>newBuilder()
                .setMethodDescriptor(updateSecurityProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "security_profile.name",
                          String.valueOf(request.getSecurityProfile().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteSecurityProfileRequest, Operation>
        deleteSecurityProfileTransportSettings =
            GrpcCallSettings.<DeleteSecurityProfileRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteSecurityProfileMethodDescriptor)
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

    this.listSecurityProfileGroupsCallable =
        callableFactory.createUnaryCallable(
            listSecurityProfileGroupsTransportSettings,
            settings.listSecurityProfileGroupsSettings(),
            clientContext);
    this.listSecurityProfileGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listSecurityProfileGroupsTransportSettings,
            settings.listSecurityProfileGroupsSettings(),
            clientContext);
    this.getSecurityProfileGroupCallable =
        callableFactory.createUnaryCallable(
            getSecurityProfileGroupTransportSettings,
            settings.getSecurityProfileGroupSettings(),
            clientContext);
    this.createSecurityProfileGroupCallable =
        callableFactory.createUnaryCallable(
            createSecurityProfileGroupTransportSettings,
            settings.createSecurityProfileGroupSettings(),
            clientContext);
    this.createSecurityProfileGroupOperationCallable =
        callableFactory.createOperationCallable(
            createSecurityProfileGroupTransportSettings,
            settings.createSecurityProfileGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.updateSecurityProfileGroupCallable =
        callableFactory.createUnaryCallable(
            updateSecurityProfileGroupTransportSettings,
            settings.updateSecurityProfileGroupSettings(),
            clientContext);
    this.updateSecurityProfileGroupOperationCallable =
        callableFactory.createOperationCallable(
            updateSecurityProfileGroupTransportSettings,
            settings.updateSecurityProfileGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteSecurityProfileGroupCallable =
        callableFactory.createUnaryCallable(
            deleteSecurityProfileGroupTransportSettings,
            settings.deleteSecurityProfileGroupSettings(),
            clientContext);
    this.deleteSecurityProfileGroupOperationCallable =
        callableFactory.createOperationCallable(
            deleteSecurityProfileGroupTransportSettings,
            settings.deleteSecurityProfileGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.listSecurityProfilesCallable =
        callableFactory.createUnaryCallable(
            listSecurityProfilesTransportSettings,
            settings.listSecurityProfilesSettings(),
            clientContext);
    this.listSecurityProfilesPagedCallable =
        callableFactory.createPagedCallable(
            listSecurityProfilesTransportSettings,
            settings.listSecurityProfilesSettings(),
            clientContext);
    this.getSecurityProfileCallable =
        callableFactory.createUnaryCallable(
            getSecurityProfileTransportSettings,
            settings.getSecurityProfileSettings(),
            clientContext);
    this.createSecurityProfileCallable =
        callableFactory.createUnaryCallable(
            createSecurityProfileTransportSettings,
            settings.createSecurityProfileSettings(),
            clientContext);
    this.createSecurityProfileOperationCallable =
        callableFactory.createOperationCallable(
            createSecurityProfileTransportSettings,
            settings.createSecurityProfileOperationSettings(),
            clientContext,
            operationsStub);
    this.updateSecurityProfileCallable =
        callableFactory.createUnaryCallable(
            updateSecurityProfileTransportSettings,
            settings.updateSecurityProfileSettings(),
            clientContext);
    this.updateSecurityProfileOperationCallable =
        callableFactory.createOperationCallable(
            updateSecurityProfileTransportSettings,
            settings.updateSecurityProfileOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteSecurityProfileCallable =
        callableFactory.createUnaryCallable(
            deleteSecurityProfileTransportSettings,
            settings.deleteSecurityProfileSettings(),
            clientContext);
    this.deleteSecurityProfileOperationCallable =
        callableFactory.createOperationCallable(
            deleteSecurityProfileTransportSettings,
            settings.deleteSecurityProfileOperationSettings(),
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
  public UnaryCallable<ListSecurityProfileGroupsRequest, ListSecurityProfileGroupsResponse>
      listSecurityProfileGroupsCallable() {
    return listSecurityProfileGroupsCallable;
  }

  @Override
  public UnaryCallable<ListSecurityProfileGroupsRequest, ListSecurityProfileGroupsPagedResponse>
      listSecurityProfileGroupsPagedCallable() {
    return listSecurityProfileGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetSecurityProfileGroupRequest, SecurityProfileGroup>
      getSecurityProfileGroupCallable() {
    return getSecurityProfileGroupCallable;
  }

  @Override
  public UnaryCallable<CreateSecurityProfileGroupRequest, Operation>
      createSecurityProfileGroupCallable() {
    return createSecurityProfileGroupCallable;
  }

  @Override
  public OperationCallable<
          CreateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
      createSecurityProfileGroupOperationCallable() {
    return createSecurityProfileGroupOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateSecurityProfileGroupRequest, Operation>
      updateSecurityProfileGroupCallable() {
    return updateSecurityProfileGroupCallable;
  }

  @Override
  public OperationCallable<
          UpdateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
      updateSecurityProfileGroupOperationCallable() {
    return updateSecurityProfileGroupOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSecurityProfileGroupRequest, Operation>
      deleteSecurityProfileGroupCallable() {
    return deleteSecurityProfileGroupCallable;
  }

  @Override
  public OperationCallable<DeleteSecurityProfileGroupRequest, Empty, OperationMetadata>
      deleteSecurityProfileGroupOperationCallable() {
    return deleteSecurityProfileGroupOperationCallable;
  }

  @Override
  public UnaryCallable<ListSecurityProfilesRequest, ListSecurityProfilesResponse>
      listSecurityProfilesCallable() {
    return listSecurityProfilesCallable;
  }

  @Override
  public UnaryCallable<ListSecurityProfilesRequest, ListSecurityProfilesPagedResponse>
      listSecurityProfilesPagedCallable() {
    return listSecurityProfilesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSecurityProfileRequest, SecurityProfile> getSecurityProfileCallable() {
    return getSecurityProfileCallable;
  }

  @Override
  public UnaryCallable<CreateSecurityProfileRequest, Operation> createSecurityProfileCallable() {
    return createSecurityProfileCallable;
  }

  @Override
  public OperationCallable<CreateSecurityProfileRequest, SecurityProfile, OperationMetadata>
      createSecurityProfileOperationCallable() {
    return createSecurityProfileOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateSecurityProfileRequest, Operation> updateSecurityProfileCallable() {
    return updateSecurityProfileCallable;
  }

  @Override
  public OperationCallable<UpdateSecurityProfileRequest, SecurityProfile, OperationMetadata>
      updateSecurityProfileOperationCallable() {
    return updateSecurityProfileOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSecurityProfileRequest, Operation> deleteSecurityProfileCallable() {
    return deleteSecurityProfileCallable;
  }

  @Override
  public OperationCallable<DeleteSecurityProfileRequest, Empty, OperationMetadata>
      deleteSecurityProfileOperationCallable() {
    return deleteSecurityProfileOperationCallable;
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
