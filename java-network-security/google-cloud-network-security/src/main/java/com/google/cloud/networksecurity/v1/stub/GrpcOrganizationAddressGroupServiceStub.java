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

package com.google.cloud.networksecurity.v1.stub;

import static com.google.cloud.networksecurity.v1.OrganizationAddressGroupServiceClient.ListAddressGroupReferencesPagedResponse;
import static com.google.cloud.networksecurity.v1.OrganizationAddressGroupServiceClient.ListAddressGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.OrganizationAddressGroupServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.networksecurity.v1.AddAddressGroupItemsRequest;
import com.google.cloud.networksecurity.v1.AddressGroup;
import com.google.cloud.networksecurity.v1.CloneAddressGroupItemsRequest;
import com.google.cloud.networksecurity.v1.CreateAddressGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteAddressGroupRequest;
import com.google.cloud.networksecurity.v1.GetAddressGroupRequest;
import com.google.cloud.networksecurity.v1.ListAddressGroupReferencesRequest;
import com.google.cloud.networksecurity.v1.ListAddressGroupReferencesResponse;
import com.google.cloud.networksecurity.v1.ListAddressGroupsRequest;
import com.google.cloud.networksecurity.v1.ListAddressGroupsResponse;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.RemoveAddressGroupItemsRequest;
import com.google.cloud.networksecurity.v1.UpdateAddressGroupRequest;
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
 * gRPC stub implementation for the OrganizationAddressGroupService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcOrganizationAddressGroupServiceStub extends OrganizationAddressGroupServiceStub {
  private static final MethodDescriptor<ListAddressGroupsRequest, ListAddressGroupsResponse>
      listAddressGroupsMethodDescriptor =
          MethodDescriptor.<ListAddressGroupsRequest, ListAddressGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationAddressGroupService/ListAddressGroups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAddressGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAddressGroupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAddressGroupRequest, AddressGroup>
      getAddressGroupMethodDescriptor =
          MethodDescriptor.<GetAddressGroupRequest, AddressGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationAddressGroupService/GetAddressGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAddressGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AddressGroup.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAddressGroupRequest, Operation>
      createAddressGroupMethodDescriptor =
          MethodDescriptor.<CreateAddressGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationAddressGroupService/CreateAddressGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAddressGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateAddressGroupRequest, Operation>
      updateAddressGroupMethodDescriptor =
          MethodDescriptor.<UpdateAddressGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationAddressGroupService/UpdateAddressGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAddressGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<AddAddressGroupItemsRequest, Operation>
      addAddressGroupItemsMethodDescriptor =
          MethodDescriptor.<AddAddressGroupItemsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationAddressGroupService/AddAddressGroupItems")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddAddressGroupItemsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RemoveAddressGroupItemsRequest, Operation>
      removeAddressGroupItemsMethodDescriptor =
          MethodDescriptor.<RemoveAddressGroupItemsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationAddressGroupService/RemoveAddressGroupItems")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveAddressGroupItemsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CloneAddressGroupItemsRequest, Operation>
      cloneAddressGroupItemsMethodDescriptor =
          MethodDescriptor.<CloneAddressGroupItemsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationAddressGroupService/CloneAddressGroupItems")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CloneAddressGroupItemsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAddressGroupRequest, Operation>
      deleteAddressGroupMethodDescriptor =
          MethodDescriptor.<DeleteAddressGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationAddressGroupService/DeleteAddressGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAddressGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAddressGroupReferencesRequest, ListAddressGroupReferencesResponse>
      listAddressGroupReferencesMethodDescriptor =
          MethodDescriptor
              .<ListAddressGroupReferencesRequest, ListAddressGroupReferencesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.OrganizationAddressGroupService/ListAddressGroupReferences")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAddressGroupReferencesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAddressGroupReferencesResponse.getDefaultInstance()))
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

  private final UnaryCallable<ListAddressGroupsRequest, ListAddressGroupsResponse>
      listAddressGroupsCallable;
  private final UnaryCallable<ListAddressGroupsRequest, ListAddressGroupsPagedResponse>
      listAddressGroupsPagedCallable;
  private final UnaryCallable<GetAddressGroupRequest, AddressGroup> getAddressGroupCallable;
  private final UnaryCallable<CreateAddressGroupRequest, Operation> createAddressGroupCallable;
  private final OperationCallable<CreateAddressGroupRequest, AddressGroup, OperationMetadata>
      createAddressGroupOperationCallable;
  private final UnaryCallable<UpdateAddressGroupRequest, Operation> updateAddressGroupCallable;
  private final OperationCallable<UpdateAddressGroupRequest, AddressGroup, OperationMetadata>
      updateAddressGroupOperationCallable;
  private final UnaryCallable<AddAddressGroupItemsRequest, Operation> addAddressGroupItemsCallable;
  private final OperationCallable<AddAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      addAddressGroupItemsOperationCallable;
  private final UnaryCallable<RemoveAddressGroupItemsRequest, Operation>
      removeAddressGroupItemsCallable;
  private final OperationCallable<RemoveAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      removeAddressGroupItemsOperationCallable;
  private final UnaryCallable<CloneAddressGroupItemsRequest, Operation>
      cloneAddressGroupItemsCallable;
  private final OperationCallable<CloneAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      cloneAddressGroupItemsOperationCallable;
  private final UnaryCallable<DeleteAddressGroupRequest, Operation> deleteAddressGroupCallable;
  private final OperationCallable<DeleteAddressGroupRequest, Empty, OperationMetadata>
      deleteAddressGroupOperationCallable;
  private final UnaryCallable<ListAddressGroupReferencesRequest, ListAddressGroupReferencesResponse>
      listAddressGroupReferencesCallable;
  private final UnaryCallable<
          ListAddressGroupReferencesRequest, ListAddressGroupReferencesPagedResponse>
      listAddressGroupReferencesPagedCallable;
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

  public static final GrpcOrganizationAddressGroupServiceStub create(
      OrganizationAddressGroupServiceStubSettings settings) throws IOException {
    return new GrpcOrganizationAddressGroupServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcOrganizationAddressGroupServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcOrganizationAddressGroupServiceStub(
        OrganizationAddressGroupServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcOrganizationAddressGroupServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcOrganizationAddressGroupServiceStub(
        OrganizationAddressGroupServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcOrganizationAddressGroupServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcOrganizationAddressGroupServiceStub(
      OrganizationAddressGroupServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcOrganizationAddressGroupServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcOrganizationAddressGroupServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcOrganizationAddressGroupServiceStub(
      OrganizationAddressGroupServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAddressGroupsRequest, ListAddressGroupsResponse>
        listAddressGroupsTransportSettings =
            GrpcCallSettings.<ListAddressGroupsRequest, ListAddressGroupsResponse>newBuilder()
                .setMethodDescriptor(listAddressGroupsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetAddressGroupRequest, AddressGroup> getAddressGroupTransportSettings =
        GrpcCallSettings.<GetAddressGroupRequest, AddressGroup>newBuilder()
            .setMethodDescriptor(getAddressGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateAddressGroupRequest, Operation> createAddressGroupTransportSettings =
        GrpcCallSettings.<CreateAddressGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(createAddressGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAddressGroupRequest, Operation> updateAddressGroupTransportSettings =
        GrpcCallSettings.<UpdateAddressGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAddressGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "address_group.name", String.valueOf(request.getAddressGroup().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<AddAddressGroupItemsRequest, Operation> addAddressGroupItemsTransportSettings =
        GrpcCallSettings.<AddAddressGroupItemsRequest, Operation>newBuilder()
            .setMethodDescriptor(addAddressGroupItemsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("address_group", String.valueOf(request.getAddressGroup()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RemoveAddressGroupItemsRequest, Operation>
        removeAddressGroupItemsTransportSettings =
            GrpcCallSettings.<RemoveAddressGroupItemsRequest, Operation>newBuilder()
                .setMethodDescriptor(removeAddressGroupItemsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("address_group", String.valueOf(request.getAddressGroup()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CloneAddressGroupItemsRequest, Operation>
        cloneAddressGroupItemsTransportSettings =
            GrpcCallSettings.<CloneAddressGroupItemsRequest, Operation>newBuilder()
                .setMethodDescriptor(cloneAddressGroupItemsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("address_group", String.valueOf(request.getAddressGroup()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteAddressGroupRequest, Operation> deleteAddressGroupTransportSettings =
        GrpcCallSettings.<DeleteAddressGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAddressGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAddressGroupReferencesRequest, ListAddressGroupReferencesResponse>
        listAddressGroupReferencesTransportSettings =
            GrpcCallSettings
                .<ListAddressGroupReferencesRequest, ListAddressGroupReferencesResponse>newBuilder()
                .setMethodDescriptor(listAddressGroupReferencesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("address_group", String.valueOf(request.getAddressGroup()));
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

    this.listAddressGroupsCallable =
        callableFactory.createUnaryCallable(
            listAddressGroupsTransportSettings,
            settings.listAddressGroupsSettings(),
            clientContext);
    this.listAddressGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listAddressGroupsTransportSettings,
            settings.listAddressGroupsSettings(),
            clientContext);
    this.getAddressGroupCallable =
        callableFactory.createUnaryCallable(
            getAddressGroupTransportSettings, settings.getAddressGroupSettings(), clientContext);
    this.createAddressGroupCallable =
        callableFactory.createUnaryCallable(
            createAddressGroupTransportSettings,
            settings.createAddressGroupSettings(),
            clientContext);
    this.createAddressGroupOperationCallable =
        callableFactory.createOperationCallable(
            createAddressGroupTransportSettings,
            settings.createAddressGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAddressGroupCallable =
        callableFactory.createUnaryCallable(
            updateAddressGroupTransportSettings,
            settings.updateAddressGroupSettings(),
            clientContext);
    this.updateAddressGroupOperationCallable =
        callableFactory.createOperationCallable(
            updateAddressGroupTransportSettings,
            settings.updateAddressGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.addAddressGroupItemsCallable =
        callableFactory.createUnaryCallable(
            addAddressGroupItemsTransportSettings,
            settings.addAddressGroupItemsSettings(),
            clientContext);
    this.addAddressGroupItemsOperationCallable =
        callableFactory.createOperationCallable(
            addAddressGroupItemsTransportSettings,
            settings.addAddressGroupItemsOperationSettings(),
            clientContext,
            operationsStub);
    this.removeAddressGroupItemsCallable =
        callableFactory.createUnaryCallable(
            removeAddressGroupItemsTransportSettings,
            settings.removeAddressGroupItemsSettings(),
            clientContext);
    this.removeAddressGroupItemsOperationCallable =
        callableFactory.createOperationCallable(
            removeAddressGroupItemsTransportSettings,
            settings.removeAddressGroupItemsOperationSettings(),
            clientContext,
            operationsStub);
    this.cloneAddressGroupItemsCallable =
        callableFactory.createUnaryCallable(
            cloneAddressGroupItemsTransportSettings,
            settings.cloneAddressGroupItemsSettings(),
            clientContext);
    this.cloneAddressGroupItemsOperationCallable =
        callableFactory.createOperationCallable(
            cloneAddressGroupItemsTransportSettings,
            settings.cloneAddressGroupItemsOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAddressGroupCallable =
        callableFactory.createUnaryCallable(
            deleteAddressGroupTransportSettings,
            settings.deleteAddressGroupSettings(),
            clientContext);
    this.deleteAddressGroupOperationCallable =
        callableFactory.createOperationCallable(
            deleteAddressGroupTransportSettings,
            settings.deleteAddressGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.listAddressGroupReferencesCallable =
        callableFactory.createUnaryCallable(
            listAddressGroupReferencesTransportSettings,
            settings.listAddressGroupReferencesSettings(),
            clientContext);
    this.listAddressGroupReferencesPagedCallable =
        callableFactory.createPagedCallable(
            listAddressGroupReferencesTransportSettings,
            settings.listAddressGroupReferencesSettings(),
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
  public UnaryCallable<ListAddressGroupsRequest, ListAddressGroupsResponse>
      listAddressGroupsCallable() {
    return listAddressGroupsCallable;
  }

  @Override
  public UnaryCallable<ListAddressGroupsRequest, ListAddressGroupsPagedResponse>
      listAddressGroupsPagedCallable() {
    return listAddressGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAddressGroupRequest, AddressGroup> getAddressGroupCallable() {
    return getAddressGroupCallable;
  }

  @Override
  public UnaryCallable<CreateAddressGroupRequest, Operation> createAddressGroupCallable() {
    return createAddressGroupCallable;
  }

  @Override
  public OperationCallable<CreateAddressGroupRequest, AddressGroup, OperationMetadata>
      createAddressGroupOperationCallable() {
    return createAddressGroupOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAddressGroupRequest, Operation> updateAddressGroupCallable() {
    return updateAddressGroupCallable;
  }

  @Override
  public OperationCallable<UpdateAddressGroupRequest, AddressGroup, OperationMetadata>
      updateAddressGroupOperationCallable() {
    return updateAddressGroupOperationCallable;
  }

  @Override
  public UnaryCallable<AddAddressGroupItemsRequest, Operation> addAddressGroupItemsCallable() {
    return addAddressGroupItemsCallable;
  }

  @Override
  public OperationCallable<AddAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      addAddressGroupItemsOperationCallable() {
    return addAddressGroupItemsOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveAddressGroupItemsRequest, Operation>
      removeAddressGroupItemsCallable() {
    return removeAddressGroupItemsCallable;
  }

  @Override
  public OperationCallable<RemoveAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      removeAddressGroupItemsOperationCallable() {
    return removeAddressGroupItemsOperationCallable;
  }

  @Override
  public UnaryCallable<CloneAddressGroupItemsRequest, Operation> cloneAddressGroupItemsCallable() {
    return cloneAddressGroupItemsCallable;
  }

  @Override
  public OperationCallable<CloneAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      cloneAddressGroupItemsOperationCallable() {
    return cloneAddressGroupItemsOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAddressGroupRequest, Operation> deleteAddressGroupCallable() {
    return deleteAddressGroupCallable;
  }

  @Override
  public OperationCallable<DeleteAddressGroupRequest, Empty, OperationMetadata>
      deleteAddressGroupOperationCallable() {
    return deleteAddressGroupOperationCallable;
  }

  @Override
  public UnaryCallable<ListAddressGroupReferencesRequest, ListAddressGroupReferencesResponse>
      listAddressGroupReferencesCallable() {
    return listAddressGroupReferencesCallable;
  }

  @Override
  public UnaryCallable<ListAddressGroupReferencesRequest, ListAddressGroupReferencesPagedResponse>
      listAddressGroupReferencesPagedCallable() {
    return listAddressGroupReferencesPagedCallable;
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
