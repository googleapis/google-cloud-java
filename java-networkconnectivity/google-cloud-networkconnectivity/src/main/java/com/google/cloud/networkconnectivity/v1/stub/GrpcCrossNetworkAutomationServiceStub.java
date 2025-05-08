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

package com.google.cloud.networkconnectivity.v1.stub;

import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceClassesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceConnectionMapsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceConnectionPoliciesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceConnectionTokensPagedResponse;

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
import com.google.cloud.networkconnectivity.v1.CreateServiceConnectionMapRequest;
import com.google.cloud.networkconnectivity.v1.CreateServiceConnectionPolicyRequest;
import com.google.cloud.networkconnectivity.v1.CreateServiceConnectionTokenRequest;
import com.google.cloud.networkconnectivity.v1.DeleteServiceClassRequest;
import com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionMapRequest;
import com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionPolicyRequest;
import com.google.cloud.networkconnectivity.v1.DeleteServiceConnectionTokenRequest;
import com.google.cloud.networkconnectivity.v1.GetServiceClassRequest;
import com.google.cloud.networkconnectivity.v1.GetServiceConnectionMapRequest;
import com.google.cloud.networkconnectivity.v1.GetServiceConnectionPolicyRequest;
import com.google.cloud.networkconnectivity.v1.GetServiceConnectionTokenRequest;
import com.google.cloud.networkconnectivity.v1.ListServiceClassesRequest;
import com.google.cloud.networkconnectivity.v1.ListServiceClassesResponse;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsRequest;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionMapsResponse;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesRequest;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionPoliciesResponse;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensRequest;
import com.google.cloud.networkconnectivity.v1.ListServiceConnectionTokensResponse;
import com.google.cloud.networkconnectivity.v1.OperationMetadata;
import com.google.cloud.networkconnectivity.v1.ServiceClass;
import com.google.cloud.networkconnectivity.v1.ServiceConnectionMap;
import com.google.cloud.networkconnectivity.v1.ServiceConnectionPolicy;
import com.google.cloud.networkconnectivity.v1.ServiceConnectionToken;
import com.google.cloud.networkconnectivity.v1.UpdateServiceClassRequest;
import com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionMapRequest;
import com.google.cloud.networkconnectivity.v1.UpdateServiceConnectionPolicyRequest;
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
 * gRPC stub implementation for the CrossNetworkAutomationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCrossNetworkAutomationServiceStub extends CrossNetworkAutomationServiceStub {
  private static final MethodDescriptor<
          ListServiceConnectionMapsRequest, ListServiceConnectionMapsResponse>
      listServiceConnectionMapsMethodDescriptor =
          MethodDescriptor
              .<ListServiceConnectionMapsRequest, ListServiceConnectionMapsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/ListServiceConnectionMaps")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListServiceConnectionMapsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServiceConnectionMapsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServiceConnectionMapRequest, ServiceConnectionMap>
      getServiceConnectionMapMethodDescriptor =
          MethodDescriptor.<GetServiceConnectionMapRequest, ServiceConnectionMap>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/GetServiceConnectionMap")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServiceConnectionMapRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ServiceConnectionMap.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateServiceConnectionMapRequest, Operation>
      createServiceConnectionMapMethodDescriptor =
          MethodDescriptor.<CreateServiceConnectionMapRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/CreateServiceConnectionMap")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceConnectionMapRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateServiceConnectionMapRequest, Operation>
      updateServiceConnectionMapMethodDescriptor =
          MethodDescriptor.<UpdateServiceConnectionMapRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/UpdateServiceConnectionMap")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateServiceConnectionMapRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteServiceConnectionMapRequest, Operation>
      deleteServiceConnectionMapMethodDescriptor =
          MethodDescriptor.<DeleteServiceConnectionMapRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/DeleteServiceConnectionMap")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServiceConnectionMapRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListServiceConnectionPoliciesRequest, ListServiceConnectionPoliciesResponse>
      listServiceConnectionPoliciesMethodDescriptor =
          MethodDescriptor
              .<ListServiceConnectionPoliciesRequest, ListServiceConnectionPoliciesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/ListServiceConnectionPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListServiceConnectionPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServiceConnectionPoliciesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServiceConnectionPolicyRequest, ServiceConnectionPolicy>
      getServiceConnectionPolicyMethodDescriptor =
          MethodDescriptor.<GetServiceConnectionPolicyRequest, ServiceConnectionPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/GetServiceConnectionPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServiceConnectionPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ServiceConnectionPolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateServiceConnectionPolicyRequest, Operation>
      createServiceConnectionPolicyMethodDescriptor =
          MethodDescriptor.<CreateServiceConnectionPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/CreateServiceConnectionPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceConnectionPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateServiceConnectionPolicyRequest, Operation>
      updateServiceConnectionPolicyMethodDescriptor =
          MethodDescriptor.<UpdateServiceConnectionPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/UpdateServiceConnectionPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateServiceConnectionPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteServiceConnectionPolicyRequest, Operation>
      deleteServiceConnectionPolicyMethodDescriptor =
          MethodDescriptor.<DeleteServiceConnectionPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/DeleteServiceConnectionPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServiceConnectionPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListServiceClassesRequest, ListServiceClassesResponse>
      listServiceClassesMethodDescriptor =
          MethodDescriptor.<ListServiceClassesRequest, ListServiceClassesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/ListServiceClasses")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListServiceClassesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServiceClassesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServiceClassRequest, ServiceClass>
      getServiceClassMethodDescriptor =
          MethodDescriptor.<GetServiceClassRequest, ServiceClass>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/GetServiceClass")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServiceClassRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServiceClass.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateServiceClassRequest, Operation>
      updateServiceClassMethodDescriptor =
          MethodDescriptor.<UpdateServiceClassRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/UpdateServiceClass")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateServiceClassRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteServiceClassRequest, Operation>
      deleteServiceClassMethodDescriptor =
          MethodDescriptor.<DeleteServiceClassRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/DeleteServiceClass")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServiceClassRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServiceConnectionTokenRequest, ServiceConnectionToken>
      getServiceConnectionTokenMethodDescriptor =
          MethodDescriptor.<GetServiceConnectionTokenRequest, ServiceConnectionToken>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/GetServiceConnectionToken")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServiceConnectionTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ServiceConnectionToken.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListServiceConnectionTokensRequest, ListServiceConnectionTokensResponse>
      listServiceConnectionTokensMethodDescriptor =
          MethodDescriptor
              .<ListServiceConnectionTokensRequest, ListServiceConnectionTokensResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/ListServiceConnectionTokens")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListServiceConnectionTokensRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServiceConnectionTokensResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateServiceConnectionTokenRequest, Operation>
      createServiceConnectionTokenMethodDescriptor =
          MethodDescriptor.<CreateServiceConnectionTokenRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/CreateServiceConnectionToken")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceConnectionTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteServiceConnectionTokenRequest, Operation>
      deleteServiceConnectionTokenMethodDescriptor =
          MethodDescriptor.<DeleteServiceConnectionTokenRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.CrossNetworkAutomationService/DeleteServiceConnectionToken")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServiceConnectionTokenRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListServiceConnectionMapsRequest, ListServiceConnectionMapsResponse>
      listServiceConnectionMapsCallable;
  private final UnaryCallable<
          ListServiceConnectionMapsRequest, ListServiceConnectionMapsPagedResponse>
      listServiceConnectionMapsPagedCallable;
  private final UnaryCallable<GetServiceConnectionMapRequest, ServiceConnectionMap>
      getServiceConnectionMapCallable;
  private final UnaryCallable<CreateServiceConnectionMapRequest, Operation>
      createServiceConnectionMapCallable;
  private final OperationCallable<
          CreateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
      createServiceConnectionMapOperationCallable;
  private final UnaryCallable<UpdateServiceConnectionMapRequest, Operation>
      updateServiceConnectionMapCallable;
  private final OperationCallable<
          UpdateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
      updateServiceConnectionMapOperationCallable;
  private final UnaryCallable<DeleteServiceConnectionMapRequest, Operation>
      deleteServiceConnectionMapCallable;
  private final OperationCallable<DeleteServiceConnectionMapRequest, Empty, OperationMetadata>
      deleteServiceConnectionMapOperationCallable;
  private final UnaryCallable<
          ListServiceConnectionPoliciesRequest, ListServiceConnectionPoliciesResponse>
      listServiceConnectionPoliciesCallable;
  private final UnaryCallable<
          ListServiceConnectionPoliciesRequest, ListServiceConnectionPoliciesPagedResponse>
      listServiceConnectionPoliciesPagedCallable;
  private final UnaryCallable<GetServiceConnectionPolicyRequest, ServiceConnectionPolicy>
      getServiceConnectionPolicyCallable;
  private final UnaryCallable<CreateServiceConnectionPolicyRequest, Operation>
      createServiceConnectionPolicyCallable;
  private final OperationCallable<
          CreateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
      createServiceConnectionPolicyOperationCallable;
  private final UnaryCallable<UpdateServiceConnectionPolicyRequest, Operation>
      updateServiceConnectionPolicyCallable;
  private final OperationCallable<
          UpdateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
      updateServiceConnectionPolicyOperationCallable;
  private final UnaryCallable<DeleteServiceConnectionPolicyRequest, Operation>
      deleteServiceConnectionPolicyCallable;
  private final OperationCallable<DeleteServiceConnectionPolicyRequest, Empty, OperationMetadata>
      deleteServiceConnectionPolicyOperationCallable;
  private final UnaryCallable<ListServiceClassesRequest, ListServiceClassesResponse>
      listServiceClassesCallable;
  private final UnaryCallable<ListServiceClassesRequest, ListServiceClassesPagedResponse>
      listServiceClassesPagedCallable;
  private final UnaryCallable<GetServiceClassRequest, ServiceClass> getServiceClassCallable;
  private final UnaryCallable<UpdateServiceClassRequest, Operation> updateServiceClassCallable;
  private final OperationCallable<UpdateServiceClassRequest, ServiceClass, OperationMetadata>
      updateServiceClassOperationCallable;
  private final UnaryCallable<DeleteServiceClassRequest, Operation> deleteServiceClassCallable;
  private final OperationCallable<DeleteServiceClassRequest, Empty, OperationMetadata>
      deleteServiceClassOperationCallable;
  private final UnaryCallable<GetServiceConnectionTokenRequest, ServiceConnectionToken>
      getServiceConnectionTokenCallable;
  private final UnaryCallable<
          ListServiceConnectionTokensRequest, ListServiceConnectionTokensResponse>
      listServiceConnectionTokensCallable;
  private final UnaryCallable<
          ListServiceConnectionTokensRequest, ListServiceConnectionTokensPagedResponse>
      listServiceConnectionTokensPagedCallable;
  private final UnaryCallable<CreateServiceConnectionTokenRequest, Operation>
      createServiceConnectionTokenCallable;
  private final OperationCallable<
          CreateServiceConnectionTokenRequest, ServiceConnectionToken, OperationMetadata>
      createServiceConnectionTokenOperationCallable;
  private final UnaryCallable<DeleteServiceConnectionTokenRequest, Operation>
      deleteServiceConnectionTokenCallable;
  private final OperationCallable<DeleteServiceConnectionTokenRequest, Empty, OperationMetadata>
      deleteServiceConnectionTokenOperationCallable;
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

  public static final GrpcCrossNetworkAutomationServiceStub create(
      CrossNetworkAutomationServiceStubSettings settings) throws IOException {
    return new GrpcCrossNetworkAutomationServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCrossNetworkAutomationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCrossNetworkAutomationServiceStub(
        CrossNetworkAutomationServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCrossNetworkAutomationServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCrossNetworkAutomationServiceStub(
        CrossNetworkAutomationServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcCrossNetworkAutomationServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCrossNetworkAutomationServiceStub(
      CrossNetworkAutomationServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCrossNetworkAutomationServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCrossNetworkAutomationServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCrossNetworkAutomationServiceStub(
      CrossNetworkAutomationServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListServiceConnectionMapsRequest, ListServiceConnectionMapsResponse>
        listServiceConnectionMapsTransportSettings =
            GrpcCallSettings
                .<ListServiceConnectionMapsRequest, ListServiceConnectionMapsResponse>newBuilder()
                .setMethodDescriptor(listServiceConnectionMapsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetServiceConnectionMapRequest, ServiceConnectionMap>
        getServiceConnectionMapTransportSettings =
            GrpcCallSettings.<GetServiceConnectionMapRequest, ServiceConnectionMap>newBuilder()
                .setMethodDescriptor(getServiceConnectionMapMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateServiceConnectionMapRequest, Operation>
        createServiceConnectionMapTransportSettings =
            GrpcCallSettings.<CreateServiceConnectionMapRequest, Operation>newBuilder()
                .setMethodDescriptor(createServiceConnectionMapMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateServiceConnectionMapRequest, Operation>
        updateServiceConnectionMapTransportSettings =
            GrpcCallSettings.<UpdateServiceConnectionMapRequest, Operation>newBuilder()
                .setMethodDescriptor(updateServiceConnectionMapMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "service_connection_map.name",
                          String.valueOf(request.getServiceConnectionMap().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteServiceConnectionMapRequest, Operation>
        deleteServiceConnectionMapTransportSettings =
            GrpcCallSettings.<DeleteServiceConnectionMapRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteServiceConnectionMapMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListServiceConnectionPoliciesRequest, ListServiceConnectionPoliciesResponse>
        listServiceConnectionPoliciesTransportSettings =
            GrpcCallSettings
                .<ListServiceConnectionPoliciesRequest, ListServiceConnectionPoliciesResponse>
                    newBuilder()
                .setMethodDescriptor(listServiceConnectionPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetServiceConnectionPolicyRequest, ServiceConnectionPolicy>
        getServiceConnectionPolicyTransportSettings =
            GrpcCallSettings
                .<GetServiceConnectionPolicyRequest, ServiceConnectionPolicy>newBuilder()
                .setMethodDescriptor(getServiceConnectionPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateServiceConnectionPolicyRequest, Operation>
        createServiceConnectionPolicyTransportSettings =
            GrpcCallSettings.<CreateServiceConnectionPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createServiceConnectionPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateServiceConnectionPolicyRequest, Operation>
        updateServiceConnectionPolicyTransportSettings =
            GrpcCallSettings.<UpdateServiceConnectionPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateServiceConnectionPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "service_connection_policy.name",
                          String.valueOf(request.getServiceConnectionPolicy().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteServiceConnectionPolicyRequest, Operation>
        deleteServiceConnectionPolicyTransportSettings =
            GrpcCallSettings.<DeleteServiceConnectionPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteServiceConnectionPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListServiceClassesRequest, ListServiceClassesResponse>
        listServiceClassesTransportSettings =
            GrpcCallSettings.<ListServiceClassesRequest, ListServiceClassesResponse>newBuilder()
                .setMethodDescriptor(listServiceClassesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetServiceClassRequest, ServiceClass> getServiceClassTransportSettings =
        GrpcCallSettings.<GetServiceClassRequest, ServiceClass>newBuilder()
            .setMethodDescriptor(getServiceClassMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateServiceClassRequest, Operation> updateServiceClassTransportSettings =
        GrpcCallSettings.<UpdateServiceClassRequest, Operation>newBuilder()
            .setMethodDescriptor(updateServiceClassMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "service_class.name", String.valueOf(request.getServiceClass().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteServiceClassRequest, Operation> deleteServiceClassTransportSettings =
        GrpcCallSettings.<DeleteServiceClassRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteServiceClassMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetServiceConnectionTokenRequest, ServiceConnectionToken>
        getServiceConnectionTokenTransportSettings =
            GrpcCallSettings.<GetServiceConnectionTokenRequest, ServiceConnectionToken>newBuilder()
                .setMethodDescriptor(getServiceConnectionTokenMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListServiceConnectionTokensRequest, ListServiceConnectionTokensResponse>
        listServiceConnectionTokensTransportSettings =
            GrpcCallSettings
                .<ListServiceConnectionTokensRequest, ListServiceConnectionTokensResponse>
                    newBuilder()
                .setMethodDescriptor(listServiceConnectionTokensMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateServiceConnectionTokenRequest, Operation>
        createServiceConnectionTokenTransportSettings =
            GrpcCallSettings.<CreateServiceConnectionTokenRequest, Operation>newBuilder()
                .setMethodDescriptor(createServiceConnectionTokenMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteServiceConnectionTokenRequest, Operation>
        deleteServiceConnectionTokenTransportSettings =
            GrpcCallSettings.<DeleteServiceConnectionTokenRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteServiceConnectionTokenMethodDescriptor)
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

    this.listServiceConnectionMapsCallable =
        callableFactory.createUnaryCallable(
            listServiceConnectionMapsTransportSettings,
            settings.listServiceConnectionMapsSettings(),
            clientContext);
    this.listServiceConnectionMapsPagedCallable =
        callableFactory.createPagedCallable(
            listServiceConnectionMapsTransportSettings,
            settings.listServiceConnectionMapsSettings(),
            clientContext);
    this.getServiceConnectionMapCallable =
        callableFactory.createUnaryCallable(
            getServiceConnectionMapTransportSettings,
            settings.getServiceConnectionMapSettings(),
            clientContext);
    this.createServiceConnectionMapCallable =
        callableFactory.createUnaryCallable(
            createServiceConnectionMapTransportSettings,
            settings.createServiceConnectionMapSettings(),
            clientContext);
    this.createServiceConnectionMapOperationCallable =
        callableFactory.createOperationCallable(
            createServiceConnectionMapTransportSettings,
            settings.createServiceConnectionMapOperationSettings(),
            clientContext,
            operationsStub);
    this.updateServiceConnectionMapCallable =
        callableFactory.createUnaryCallable(
            updateServiceConnectionMapTransportSettings,
            settings.updateServiceConnectionMapSettings(),
            clientContext);
    this.updateServiceConnectionMapOperationCallable =
        callableFactory.createOperationCallable(
            updateServiceConnectionMapTransportSettings,
            settings.updateServiceConnectionMapOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteServiceConnectionMapCallable =
        callableFactory.createUnaryCallable(
            deleteServiceConnectionMapTransportSettings,
            settings.deleteServiceConnectionMapSettings(),
            clientContext);
    this.deleteServiceConnectionMapOperationCallable =
        callableFactory.createOperationCallable(
            deleteServiceConnectionMapTransportSettings,
            settings.deleteServiceConnectionMapOperationSettings(),
            clientContext,
            operationsStub);
    this.listServiceConnectionPoliciesCallable =
        callableFactory.createUnaryCallable(
            listServiceConnectionPoliciesTransportSettings,
            settings.listServiceConnectionPoliciesSettings(),
            clientContext);
    this.listServiceConnectionPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listServiceConnectionPoliciesTransportSettings,
            settings.listServiceConnectionPoliciesSettings(),
            clientContext);
    this.getServiceConnectionPolicyCallable =
        callableFactory.createUnaryCallable(
            getServiceConnectionPolicyTransportSettings,
            settings.getServiceConnectionPolicySettings(),
            clientContext);
    this.createServiceConnectionPolicyCallable =
        callableFactory.createUnaryCallable(
            createServiceConnectionPolicyTransportSettings,
            settings.createServiceConnectionPolicySettings(),
            clientContext);
    this.createServiceConnectionPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createServiceConnectionPolicyTransportSettings,
            settings.createServiceConnectionPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.updateServiceConnectionPolicyCallable =
        callableFactory.createUnaryCallable(
            updateServiceConnectionPolicyTransportSettings,
            settings.updateServiceConnectionPolicySettings(),
            clientContext);
    this.updateServiceConnectionPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateServiceConnectionPolicyTransportSettings,
            settings.updateServiceConnectionPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteServiceConnectionPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteServiceConnectionPolicyTransportSettings,
            settings.deleteServiceConnectionPolicySettings(),
            clientContext);
    this.deleteServiceConnectionPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteServiceConnectionPolicyTransportSettings,
            settings.deleteServiceConnectionPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.listServiceClassesCallable =
        callableFactory.createUnaryCallable(
            listServiceClassesTransportSettings,
            settings.listServiceClassesSettings(),
            clientContext);
    this.listServiceClassesPagedCallable =
        callableFactory.createPagedCallable(
            listServiceClassesTransportSettings,
            settings.listServiceClassesSettings(),
            clientContext);
    this.getServiceClassCallable =
        callableFactory.createUnaryCallable(
            getServiceClassTransportSettings, settings.getServiceClassSettings(), clientContext);
    this.updateServiceClassCallable =
        callableFactory.createUnaryCallable(
            updateServiceClassTransportSettings,
            settings.updateServiceClassSettings(),
            clientContext);
    this.updateServiceClassOperationCallable =
        callableFactory.createOperationCallable(
            updateServiceClassTransportSettings,
            settings.updateServiceClassOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteServiceClassCallable =
        callableFactory.createUnaryCallable(
            deleteServiceClassTransportSettings,
            settings.deleteServiceClassSettings(),
            clientContext);
    this.deleteServiceClassOperationCallable =
        callableFactory.createOperationCallable(
            deleteServiceClassTransportSettings,
            settings.deleteServiceClassOperationSettings(),
            clientContext,
            operationsStub);
    this.getServiceConnectionTokenCallable =
        callableFactory.createUnaryCallable(
            getServiceConnectionTokenTransportSettings,
            settings.getServiceConnectionTokenSettings(),
            clientContext);
    this.listServiceConnectionTokensCallable =
        callableFactory.createUnaryCallable(
            listServiceConnectionTokensTransportSettings,
            settings.listServiceConnectionTokensSettings(),
            clientContext);
    this.listServiceConnectionTokensPagedCallable =
        callableFactory.createPagedCallable(
            listServiceConnectionTokensTransportSettings,
            settings.listServiceConnectionTokensSettings(),
            clientContext);
    this.createServiceConnectionTokenCallable =
        callableFactory.createUnaryCallable(
            createServiceConnectionTokenTransportSettings,
            settings.createServiceConnectionTokenSettings(),
            clientContext);
    this.createServiceConnectionTokenOperationCallable =
        callableFactory.createOperationCallable(
            createServiceConnectionTokenTransportSettings,
            settings.createServiceConnectionTokenOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteServiceConnectionTokenCallable =
        callableFactory.createUnaryCallable(
            deleteServiceConnectionTokenTransportSettings,
            settings.deleteServiceConnectionTokenSettings(),
            clientContext);
    this.deleteServiceConnectionTokenOperationCallable =
        callableFactory.createOperationCallable(
            deleteServiceConnectionTokenTransportSettings,
            settings.deleteServiceConnectionTokenOperationSettings(),
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
  public UnaryCallable<ListServiceConnectionMapsRequest, ListServiceConnectionMapsResponse>
      listServiceConnectionMapsCallable() {
    return listServiceConnectionMapsCallable;
  }

  @Override
  public UnaryCallable<ListServiceConnectionMapsRequest, ListServiceConnectionMapsPagedResponse>
      listServiceConnectionMapsPagedCallable() {
    return listServiceConnectionMapsPagedCallable;
  }

  @Override
  public UnaryCallable<GetServiceConnectionMapRequest, ServiceConnectionMap>
      getServiceConnectionMapCallable() {
    return getServiceConnectionMapCallable;
  }

  @Override
  public UnaryCallable<CreateServiceConnectionMapRequest, Operation>
      createServiceConnectionMapCallable() {
    return createServiceConnectionMapCallable;
  }

  @Override
  public OperationCallable<
          CreateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
      createServiceConnectionMapOperationCallable() {
    return createServiceConnectionMapOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateServiceConnectionMapRequest, Operation>
      updateServiceConnectionMapCallable() {
    return updateServiceConnectionMapCallable;
  }

  @Override
  public OperationCallable<
          UpdateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
      updateServiceConnectionMapOperationCallable() {
    return updateServiceConnectionMapOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceConnectionMapRequest, Operation>
      deleteServiceConnectionMapCallable() {
    return deleteServiceConnectionMapCallable;
  }

  @Override
  public OperationCallable<DeleteServiceConnectionMapRequest, Empty, OperationMetadata>
      deleteServiceConnectionMapOperationCallable() {
    return deleteServiceConnectionMapOperationCallable;
  }

  @Override
  public UnaryCallable<ListServiceConnectionPoliciesRequest, ListServiceConnectionPoliciesResponse>
      listServiceConnectionPoliciesCallable() {
    return listServiceConnectionPoliciesCallable;
  }

  @Override
  public UnaryCallable<
          ListServiceConnectionPoliciesRequest, ListServiceConnectionPoliciesPagedResponse>
      listServiceConnectionPoliciesPagedCallable() {
    return listServiceConnectionPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetServiceConnectionPolicyRequest, ServiceConnectionPolicy>
      getServiceConnectionPolicyCallable() {
    return getServiceConnectionPolicyCallable;
  }

  @Override
  public UnaryCallable<CreateServiceConnectionPolicyRequest, Operation>
      createServiceConnectionPolicyCallable() {
    return createServiceConnectionPolicyCallable;
  }

  @Override
  public OperationCallable<
          CreateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
      createServiceConnectionPolicyOperationCallable() {
    return createServiceConnectionPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateServiceConnectionPolicyRequest, Operation>
      updateServiceConnectionPolicyCallable() {
    return updateServiceConnectionPolicyCallable;
  }

  @Override
  public OperationCallable<
          UpdateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
      updateServiceConnectionPolicyOperationCallable() {
    return updateServiceConnectionPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceConnectionPolicyRequest, Operation>
      deleteServiceConnectionPolicyCallable() {
    return deleteServiceConnectionPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteServiceConnectionPolicyRequest, Empty, OperationMetadata>
      deleteServiceConnectionPolicyOperationCallable() {
    return deleteServiceConnectionPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<ListServiceClassesRequest, ListServiceClassesResponse>
      listServiceClassesCallable() {
    return listServiceClassesCallable;
  }

  @Override
  public UnaryCallable<ListServiceClassesRequest, ListServiceClassesPagedResponse>
      listServiceClassesPagedCallable() {
    return listServiceClassesPagedCallable;
  }

  @Override
  public UnaryCallable<GetServiceClassRequest, ServiceClass> getServiceClassCallable() {
    return getServiceClassCallable;
  }

  @Override
  public UnaryCallable<UpdateServiceClassRequest, Operation> updateServiceClassCallable() {
    return updateServiceClassCallable;
  }

  @Override
  public OperationCallable<UpdateServiceClassRequest, ServiceClass, OperationMetadata>
      updateServiceClassOperationCallable() {
    return updateServiceClassOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceClassRequest, Operation> deleteServiceClassCallable() {
    return deleteServiceClassCallable;
  }

  @Override
  public OperationCallable<DeleteServiceClassRequest, Empty, OperationMetadata>
      deleteServiceClassOperationCallable() {
    return deleteServiceClassOperationCallable;
  }

  @Override
  public UnaryCallable<GetServiceConnectionTokenRequest, ServiceConnectionToken>
      getServiceConnectionTokenCallable() {
    return getServiceConnectionTokenCallable;
  }

  @Override
  public UnaryCallable<ListServiceConnectionTokensRequest, ListServiceConnectionTokensResponse>
      listServiceConnectionTokensCallable() {
    return listServiceConnectionTokensCallable;
  }

  @Override
  public UnaryCallable<ListServiceConnectionTokensRequest, ListServiceConnectionTokensPagedResponse>
      listServiceConnectionTokensPagedCallable() {
    return listServiceConnectionTokensPagedCallable;
  }

  @Override
  public UnaryCallable<CreateServiceConnectionTokenRequest, Operation>
      createServiceConnectionTokenCallable() {
    return createServiceConnectionTokenCallable;
  }

  @Override
  public OperationCallable<
          CreateServiceConnectionTokenRequest, ServiceConnectionToken, OperationMetadata>
      createServiceConnectionTokenOperationCallable() {
    return createServiceConnectionTokenOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceConnectionTokenRequest, Operation>
      deleteServiceConnectionTokenCallable() {
    return deleteServiceConnectionTokenCallable;
  }

  @Override
  public OperationCallable<DeleteServiceConnectionTokenRequest, Empty, OperationMetadata>
      deleteServiceConnectionTokenOperationCallable() {
    return deleteServiceConnectionTokenOperationCallable;
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
