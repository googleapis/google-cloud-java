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

package com.google.cloud.networkconnectivity.v1.stub;

import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListGroupsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListHubSpokesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListHubsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListRouteTablesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListRoutesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.HubServiceClient.ListSpokesPagedResponse;

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
import com.google.cloud.networkconnectivity.v1.AcceptHubSpokeRequest;
import com.google.cloud.networkconnectivity.v1.AcceptHubSpokeResponse;
import com.google.cloud.networkconnectivity.v1.CreateHubRequest;
import com.google.cloud.networkconnectivity.v1.CreateSpokeRequest;
import com.google.cloud.networkconnectivity.v1.DeleteHubRequest;
import com.google.cloud.networkconnectivity.v1.DeleteSpokeRequest;
import com.google.cloud.networkconnectivity.v1.GetGroupRequest;
import com.google.cloud.networkconnectivity.v1.GetHubRequest;
import com.google.cloud.networkconnectivity.v1.GetRouteRequest;
import com.google.cloud.networkconnectivity.v1.GetRouteTableRequest;
import com.google.cloud.networkconnectivity.v1.GetSpokeRequest;
import com.google.cloud.networkconnectivity.v1.Group;
import com.google.cloud.networkconnectivity.v1.Hub;
import com.google.cloud.networkconnectivity.v1.ListGroupsRequest;
import com.google.cloud.networkconnectivity.v1.ListGroupsResponse;
import com.google.cloud.networkconnectivity.v1.ListHubSpokesRequest;
import com.google.cloud.networkconnectivity.v1.ListHubSpokesResponse;
import com.google.cloud.networkconnectivity.v1.ListHubsRequest;
import com.google.cloud.networkconnectivity.v1.ListHubsResponse;
import com.google.cloud.networkconnectivity.v1.ListRouteTablesRequest;
import com.google.cloud.networkconnectivity.v1.ListRouteTablesResponse;
import com.google.cloud.networkconnectivity.v1.ListRoutesRequest;
import com.google.cloud.networkconnectivity.v1.ListRoutesResponse;
import com.google.cloud.networkconnectivity.v1.ListSpokesRequest;
import com.google.cloud.networkconnectivity.v1.ListSpokesResponse;
import com.google.cloud.networkconnectivity.v1.OperationMetadata;
import com.google.cloud.networkconnectivity.v1.RejectHubSpokeRequest;
import com.google.cloud.networkconnectivity.v1.RejectHubSpokeResponse;
import com.google.cloud.networkconnectivity.v1.Route;
import com.google.cloud.networkconnectivity.v1.RouteTable;
import com.google.cloud.networkconnectivity.v1.Spoke;
import com.google.cloud.networkconnectivity.v1.UpdateHubRequest;
import com.google.cloud.networkconnectivity.v1.UpdateSpokeRequest;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the HubService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcHubServiceStub extends HubServiceStub {
  private static final MethodDescriptor<ListHubsRequest, ListHubsResponse>
      listHubsMethodDescriptor =
          MethodDescriptor.<ListHubsRequest, ListHubsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/ListHubs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListHubsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListHubsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetHubRequest, Hub> getHubMethodDescriptor =
      MethodDescriptor.<GetHubRequest, Hub>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/GetHub")
          .setRequestMarshaller(ProtoUtils.marshaller(GetHubRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Hub.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateHubRequest, Operation> createHubMethodDescriptor =
      MethodDescriptor.<CreateHubRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/CreateHub")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateHubRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateHubRequest, Operation> updateHubMethodDescriptor =
      MethodDescriptor.<UpdateHubRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/UpdateHub")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateHubRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteHubRequest, Operation> deleteHubMethodDescriptor =
      MethodDescriptor.<DeleteHubRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/DeleteHub")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteHubRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListHubSpokesRequest, ListHubSpokesResponse>
      listHubSpokesMethodDescriptor =
          MethodDescriptor.<ListHubSpokesRequest, ListHubSpokesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/ListHubSpokes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListHubSpokesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListHubSpokesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSpokesRequest, ListSpokesResponse>
      listSpokesMethodDescriptor =
          MethodDescriptor.<ListSpokesRequest, ListSpokesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/ListSpokes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSpokesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSpokesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSpokeRequest, Spoke> getSpokeMethodDescriptor =
      MethodDescriptor.<GetSpokeRequest, Spoke>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/GetSpoke")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSpokeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Spoke.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateSpokeRequest, Operation> createSpokeMethodDescriptor =
      MethodDescriptor.<CreateSpokeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/CreateSpoke")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSpokeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSpokeRequest, Operation> updateSpokeMethodDescriptor =
      MethodDescriptor.<UpdateSpokeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/UpdateSpoke")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSpokeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<RejectHubSpokeRequest, Operation>
      rejectHubSpokeMethodDescriptor =
          MethodDescriptor.<RejectHubSpokeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/RejectHubSpoke")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RejectHubSpokeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AcceptHubSpokeRequest, Operation>
      acceptHubSpokeMethodDescriptor =
          MethodDescriptor.<AcceptHubSpokeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/AcceptHubSpoke")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AcceptHubSpokeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSpokeRequest, Operation> deleteSpokeMethodDescriptor =
      MethodDescriptor.<DeleteSpokeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/DeleteSpoke")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSpokeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetRouteTableRequest, RouteTable>
      getRouteTableMethodDescriptor =
          MethodDescriptor.<GetRouteTableRequest, RouteTable>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/GetRouteTable")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRouteTableRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RouteTable.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRouteRequest, Route> getRouteMethodDescriptor =
      MethodDescriptor.<GetRouteRequest, Route>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/GetRoute")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRouteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Route.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListRoutesRequest, ListRoutesResponse>
      listRoutesMethodDescriptor =
          MethodDescriptor.<ListRoutesRequest, ListRoutesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/ListRoutes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRoutesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListRoutesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRouteTablesRequest, ListRouteTablesResponse>
      listRouteTablesMethodDescriptor =
          MethodDescriptor.<ListRouteTablesRequest, ListRouteTablesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/ListRouteTables")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRouteTablesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRouteTablesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGroupRequest, Group> getGroupMethodDescriptor =
      MethodDescriptor.<GetGroupRequest, Group>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/GetGroup")
          .setRequestMarshaller(ProtoUtils.marshaller(GetGroupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Group.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListGroupsRequest, ListGroupsResponse>
      listGroupsMethodDescriptor =
          MethodDescriptor.<ListGroupsRequest, ListGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkconnectivity.v1.HubService/ListGroups")
              .setRequestMarshaller(ProtoUtils.marshaller(ListGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListGroupsResponse.getDefaultInstance()))
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

  private final UnaryCallable<ListHubsRequest, ListHubsResponse> listHubsCallable;
  private final UnaryCallable<ListHubsRequest, ListHubsPagedResponse> listHubsPagedCallable;
  private final UnaryCallable<GetHubRequest, Hub> getHubCallable;
  private final UnaryCallable<CreateHubRequest, Operation> createHubCallable;
  private final OperationCallable<CreateHubRequest, Hub, OperationMetadata>
      createHubOperationCallable;
  private final UnaryCallable<UpdateHubRequest, Operation> updateHubCallable;
  private final OperationCallable<UpdateHubRequest, Hub, OperationMetadata>
      updateHubOperationCallable;
  private final UnaryCallable<DeleteHubRequest, Operation> deleteHubCallable;
  private final OperationCallable<DeleteHubRequest, Empty, OperationMetadata>
      deleteHubOperationCallable;
  private final UnaryCallable<ListHubSpokesRequest, ListHubSpokesResponse> listHubSpokesCallable;
  private final UnaryCallable<ListHubSpokesRequest, ListHubSpokesPagedResponse>
      listHubSpokesPagedCallable;
  private final UnaryCallable<ListSpokesRequest, ListSpokesResponse> listSpokesCallable;
  private final UnaryCallable<ListSpokesRequest, ListSpokesPagedResponse> listSpokesPagedCallable;
  private final UnaryCallable<GetSpokeRequest, Spoke> getSpokeCallable;
  private final UnaryCallable<CreateSpokeRequest, Operation> createSpokeCallable;
  private final OperationCallable<CreateSpokeRequest, Spoke, OperationMetadata>
      createSpokeOperationCallable;
  private final UnaryCallable<UpdateSpokeRequest, Operation> updateSpokeCallable;
  private final OperationCallable<UpdateSpokeRequest, Spoke, OperationMetadata>
      updateSpokeOperationCallable;
  private final UnaryCallable<RejectHubSpokeRequest, Operation> rejectHubSpokeCallable;
  private final OperationCallable<RejectHubSpokeRequest, RejectHubSpokeResponse, OperationMetadata>
      rejectHubSpokeOperationCallable;
  private final UnaryCallable<AcceptHubSpokeRequest, Operation> acceptHubSpokeCallable;
  private final OperationCallable<AcceptHubSpokeRequest, AcceptHubSpokeResponse, OperationMetadata>
      acceptHubSpokeOperationCallable;
  private final UnaryCallable<DeleteSpokeRequest, Operation> deleteSpokeCallable;
  private final OperationCallable<DeleteSpokeRequest, Empty, OperationMetadata>
      deleteSpokeOperationCallable;
  private final UnaryCallable<GetRouteTableRequest, RouteTable> getRouteTableCallable;
  private final UnaryCallable<GetRouteRequest, Route> getRouteCallable;
  private final UnaryCallable<ListRoutesRequest, ListRoutesResponse> listRoutesCallable;
  private final UnaryCallable<ListRoutesRequest, ListRoutesPagedResponse> listRoutesPagedCallable;
  private final UnaryCallable<ListRouteTablesRequest, ListRouteTablesResponse>
      listRouteTablesCallable;
  private final UnaryCallable<ListRouteTablesRequest, ListRouteTablesPagedResponse>
      listRouteTablesPagedCallable;
  private final UnaryCallable<GetGroupRequest, Group> getGroupCallable;
  private final UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable;
  private final UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable;
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

  public static final GrpcHubServiceStub create(HubServiceStubSettings settings)
      throws IOException {
    return new GrpcHubServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcHubServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcHubServiceStub(HubServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcHubServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcHubServiceStub(
        HubServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcHubServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcHubServiceStub(HubServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcHubServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcHubServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcHubServiceStub(
      HubServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListHubsRequest, ListHubsResponse> listHubsTransportSettings =
        GrpcCallSettings.<ListHubsRequest, ListHubsResponse>newBuilder()
            .setMethodDescriptor(listHubsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetHubRequest, Hub> getHubTransportSettings =
        GrpcCallSettings.<GetHubRequest, Hub>newBuilder()
            .setMethodDescriptor(getHubMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateHubRequest, Operation> createHubTransportSettings =
        GrpcCallSettings.<CreateHubRequest, Operation>newBuilder()
            .setMethodDescriptor(createHubMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateHubRequest, Operation> updateHubTransportSettings =
        GrpcCallSettings.<UpdateHubRequest, Operation>newBuilder()
            .setMethodDescriptor(updateHubMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("hub.name", String.valueOf(request.getHub().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteHubRequest, Operation> deleteHubTransportSettings =
        GrpcCallSettings.<DeleteHubRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteHubMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListHubSpokesRequest, ListHubSpokesResponse> listHubSpokesTransportSettings =
        GrpcCallSettings.<ListHubSpokesRequest, ListHubSpokesResponse>newBuilder()
            .setMethodDescriptor(listHubSpokesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSpokesRequest, ListSpokesResponse> listSpokesTransportSettings =
        GrpcCallSettings.<ListSpokesRequest, ListSpokesResponse>newBuilder()
            .setMethodDescriptor(listSpokesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSpokeRequest, Spoke> getSpokeTransportSettings =
        GrpcCallSettings.<GetSpokeRequest, Spoke>newBuilder()
            .setMethodDescriptor(getSpokeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateSpokeRequest, Operation> createSpokeTransportSettings =
        GrpcCallSettings.<CreateSpokeRequest, Operation>newBuilder()
            .setMethodDescriptor(createSpokeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSpokeRequest, Operation> updateSpokeTransportSettings =
        GrpcCallSettings.<UpdateSpokeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSpokeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("spoke.name", String.valueOf(request.getSpoke().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RejectHubSpokeRequest, Operation> rejectHubSpokeTransportSettings =
        GrpcCallSettings.<RejectHubSpokeRequest, Operation>newBuilder()
            .setMethodDescriptor(rejectHubSpokeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<AcceptHubSpokeRequest, Operation> acceptHubSpokeTransportSettings =
        GrpcCallSettings.<AcceptHubSpokeRequest, Operation>newBuilder()
            .setMethodDescriptor(acceptHubSpokeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSpokeRequest, Operation> deleteSpokeTransportSettings =
        GrpcCallSettings.<DeleteSpokeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSpokeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetRouteTableRequest, RouteTable> getRouteTableTransportSettings =
        GrpcCallSettings.<GetRouteTableRequest, RouteTable>newBuilder()
            .setMethodDescriptor(getRouteTableMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetRouteRequest, Route> getRouteTransportSettings =
        GrpcCallSettings.<GetRouteRequest, Route>newBuilder()
            .setMethodDescriptor(getRouteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRoutesRequest, ListRoutesResponse> listRoutesTransportSettings =
        GrpcCallSettings.<ListRoutesRequest, ListRoutesResponse>newBuilder()
            .setMethodDescriptor(listRoutesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRouteTablesRequest, ListRouteTablesResponse>
        listRouteTablesTransportSettings =
            GrpcCallSettings.<ListRouteTablesRequest, ListRouteTablesResponse>newBuilder()
                .setMethodDescriptor(listRouteTablesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetGroupRequest, Group> getGroupTransportSettings =
        GrpcCallSettings.<GetGroupRequest, Group>newBuilder()
            .setMethodDescriptor(getGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListGroupsRequest, ListGroupsResponse> listGroupsTransportSettings =
        GrpcCallSettings.<ListGroupsRequest, ListGroupsResponse>newBuilder()
            .setMethodDescriptor(listGroupsMethodDescriptor)
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

    this.listHubsCallable =
        callableFactory.createUnaryCallable(
            listHubsTransportSettings, settings.listHubsSettings(), clientContext);
    this.listHubsPagedCallable =
        callableFactory.createPagedCallable(
            listHubsTransportSettings, settings.listHubsSettings(), clientContext);
    this.getHubCallable =
        callableFactory.createUnaryCallable(
            getHubTransportSettings, settings.getHubSettings(), clientContext);
    this.createHubCallable =
        callableFactory.createUnaryCallable(
            createHubTransportSettings, settings.createHubSettings(), clientContext);
    this.createHubOperationCallable =
        callableFactory.createOperationCallable(
            createHubTransportSettings,
            settings.createHubOperationSettings(),
            clientContext,
            operationsStub);
    this.updateHubCallable =
        callableFactory.createUnaryCallable(
            updateHubTransportSettings, settings.updateHubSettings(), clientContext);
    this.updateHubOperationCallable =
        callableFactory.createOperationCallable(
            updateHubTransportSettings,
            settings.updateHubOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteHubCallable =
        callableFactory.createUnaryCallable(
            deleteHubTransportSettings, settings.deleteHubSettings(), clientContext);
    this.deleteHubOperationCallable =
        callableFactory.createOperationCallable(
            deleteHubTransportSettings,
            settings.deleteHubOperationSettings(),
            clientContext,
            operationsStub);
    this.listHubSpokesCallable =
        callableFactory.createUnaryCallable(
            listHubSpokesTransportSettings, settings.listHubSpokesSettings(), clientContext);
    this.listHubSpokesPagedCallable =
        callableFactory.createPagedCallable(
            listHubSpokesTransportSettings, settings.listHubSpokesSettings(), clientContext);
    this.listSpokesCallable =
        callableFactory.createUnaryCallable(
            listSpokesTransportSettings, settings.listSpokesSettings(), clientContext);
    this.listSpokesPagedCallable =
        callableFactory.createPagedCallable(
            listSpokesTransportSettings, settings.listSpokesSettings(), clientContext);
    this.getSpokeCallable =
        callableFactory.createUnaryCallable(
            getSpokeTransportSettings, settings.getSpokeSettings(), clientContext);
    this.createSpokeCallable =
        callableFactory.createUnaryCallable(
            createSpokeTransportSettings, settings.createSpokeSettings(), clientContext);
    this.createSpokeOperationCallable =
        callableFactory.createOperationCallable(
            createSpokeTransportSettings,
            settings.createSpokeOperationSettings(),
            clientContext,
            operationsStub);
    this.updateSpokeCallable =
        callableFactory.createUnaryCallable(
            updateSpokeTransportSettings, settings.updateSpokeSettings(), clientContext);
    this.updateSpokeOperationCallable =
        callableFactory.createOperationCallable(
            updateSpokeTransportSettings,
            settings.updateSpokeOperationSettings(),
            clientContext,
            operationsStub);
    this.rejectHubSpokeCallable =
        callableFactory.createUnaryCallable(
            rejectHubSpokeTransportSettings, settings.rejectHubSpokeSettings(), clientContext);
    this.rejectHubSpokeOperationCallable =
        callableFactory.createOperationCallable(
            rejectHubSpokeTransportSettings,
            settings.rejectHubSpokeOperationSettings(),
            clientContext,
            operationsStub);
    this.acceptHubSpokeCallable =
        callableFactory.createUnaryCallable(
            acceptHubSpokeTransportSettings, settings.acceptHubSpokeSettings(), clientContext);
    this.acceptHubSpokeOperationCallable =
        callableFactory.createOperationCallable(
            acceptHubSpokeTransportSettings,
            settings.acceptHubSpokeOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteSpokeCallable =
        callableFactory.createUnaryCallable(
            deleteSpokeTransportSettings, settings.deleteSpokeSettings(), clientContext);
    this.deleteSpokeOperationCallable =
        callableFactory.createOperationCallable(
            deleteSpokeTransportSettings,
            settings.deleteSpokeOperationSettings(),
            clientContext,
            operationsStub);
    this.getRouteTableCallable =
        callableFactory.createUnaryCallable(
            getRouteTableTransportSettings, settings.getRouteTableSettings(), clientContext);
    this.getRouteCallable =
        callableFactory.createUnaryCallable(
            getRouteTransportSettings, settings.getRouteSettings(), clientContext);
    this.listRoutesCallable =
        callableFactory.createUnaryCallable(
            listRoutesTransportSettings, settings.listRoutesSettings(), clientContext);
    this.listRoutesPagedCallable =
        callableFactory.createPagedCallable(
            listRoutesTransportSettings, settings.listRoutesSettings(), clientContext);
    this.listRouteTablesCallable =
        callableFactory.createUnaryCallable(
            listRouteTablesTransportSettings, settings.listRouteTablesSettings(), clientContext);
    this.listRouteTablesPagedCallable =
        callableFactory.createPagedCallable(
            listRouteTablesTransportSettings, settings.listRouteTablesSettings(), clientContext);
    this.getGroupCallable =
        callableFactory.createUnaryCallable(
            getGroupTransportSettings, settings.getGroupSettings(), clientContext);
    this.listGroupsCallable =
        callableFactory.createUnaryCallable(
            listGroupsTransportSettings, settings.listGroupsSettings(), clientContext);
    this.listGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listGroupsTransportSettings, settings.listGroupsSettings(), clientContext);
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
  public UnaryCallable<ListHubsRequest, ListHubsResponse> listHubsCallable() {
    return listHubsCallable;
  }

  @Override
  public UnaryCallable<ListHubsRequest, ListHubsPagedResponse> listHubsPagedCallable() {
    return listHubsPagedCallable;
  }

  @Override
  public UnaryCallable<GetHubRequest, Hub> getHubCallable() {
    return getHubCallable;
  }

  @Override
  public UnaryCallable<CreateHubRequest, Operation> createHubCallable() {
    return createHubCallable;
  }

  @Override
  public OperationCallable<CreateHubRequest, Hub, OperationMetadata> createHubOperationCallable() {
    return createHubOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateHubRequest, Operation> updateHubCallable() {
    return updateHubCallable;
  }

  @Override
  public OperationCallable<UpdateHubRequest, Hub, OperationMetadata> updateHubOperationCallable() {
    return updateHubOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteHubRequest, Operation> deleteHubCallable() {
    return deleteHubCallable;
  }

  @Override
  public OperationCallable<DeleteHubRequest, Empty, OperationMetadata>
      deleteHubOperationCallable() {
    return deleteHubOperationCallable;
  }

  @Override
  public UnaryCallable<ListHubSpokesRequest, ListHubSpokesResponse> listHubSpokesCallable() {
    return listHubSpokesCallable;
  }

  @Override
  public UnaryCallable<ListHubSpokesRequest, ListHubSpokesPagedResponse>
      listHubSpokesPagedCallable() {
    return listHubSpokesPagedCallable;
  }

  @Override
  public UnaryCallable<ListSpokesRequest, ListSpokesResponse> listSpokesCallable() {
    return listSpokesCallable;
  }

  @Override
  public UnaryCallable<ListSpokesRequest, ListSpokesPagedResponse> listSpokesPagedCallable() {
    return listSpokesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSpokeRequest, Spoke> getSpokeCallable() {
    return getSpokeCallable;
  }

  @Override
  public UnaryCallable<CreateSpokeRequest, Operation> createSpokeCallable() {
    return createSpokeCallable;
  }

  @Override
  public OperationCallable<CreateSpokeRequest, Spoke, OperationMetadata>
      createSpokeOperationCallable() {
    return createSpokeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateSpokeRequest, Operation> updateSpokeCallable() {
    return updateSpokeCallable;
  }

  @Override
  public OperationCallable<UpdateSpokeRequest, Spoke, OperationMetadata>
      updateSpokeOperationCallable() {
    return updateSpokeOperationCallable;
  }

  @Override
  public UnaryCallable<RejectHubSpokeRequest, Operation> rejectHubSpokeCallable() {
    return rejectHubSpokeCallable;
  }

  @Override
  public OperationCallable<RejectHubSpokeRequest, RejectHubSpokeResponse, OperationMetadata>
      rejectHubSpokeOperationCallable() {
    return rejectHubSpokeOperationCallable;
  }

  @Override
  public UnaryCallable<AcceptHubSpokeRequest, Operation> acceptHubSpokeCallable() {
    return acceptHubSpokeCallable;
  }

  @Override
  public OperationCallable<AcceptHubSpokeRequest, AcceptHubSpokeResponse, OperationMetadata>
      acceptHubSpokeOperationCallable() {
    return acceptHubSpokeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSpokeRequest, Operation> deleteSpokeCallable() {
    return deleteSpokeCallable;
  }

  @Override
  public OperationCallable<DeleteSpokeRequest, Empty, OperationMetadata>
      deleteSpokeOperationCallable() {
    return deleteSpokeOperationCallable;
  }

  @Override
  public UnaryCallable<GetRouteTableRequest, RouteTable> getRouteTableCallable() {
    return getRouteTableCallable;
  }

  @Override
  public UnaryCallable<GetRouteRequest, Route> getRouteCallable() {
    return getRouteCallable;
  }

  @Override
  public UnaryCallable<ListRoutesRequest, ListRoutesResponse> listRoutesCallable() {
    return listRoutesCallable;
  }

  @Override
  public UnaryCallable<ListRoutesRequest, ListRoutesPagedResponse> listRoutesPagedCallable() {
    return listRoutesPagedCallable;
  }

  @Override
  public UnaryCallable<ListRouteTablesRequest, ListRouteTablesResponse> listRouteTablesCallable() {
    return listRouteTablesCallable;
  }

  @Override
  public UnaryCallable<ListRouteTablesRequest, ListRouteTablesPagedResponse>
      listRouteTablesPagedCallable() {
    return listRouteTablesPagedCallable;
  }

  @Override
  public UnaryCallable<GetGroupRequest, Group> getGroupCallable() {
    return getGroupCallable;
  }

  @Override
  public UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable() {
    return listGroupsCallable;
  }

  @Override
  public UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable() {
    return listGroupsPagedCallable;
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
