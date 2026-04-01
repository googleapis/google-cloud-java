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

package com.google.cloud.networkconnectivity.v1beta.stub;

import static com.google.cloud.networkconnectivity.v1beta.HubServiceClient.ListGatewayAdvertisedRoutesPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.HubServiceClient.ListGroupsPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.HubServiceClient.ListHubSpokesPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.HubServiceClient.ListHubsPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.HubServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.HubServiceClient.ListRouteTablesPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.HubServiceClient.ListRoutesPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.HubServiceClient.ListSpokesPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.HubServiceClient.QueryHubStatusPagedResponse;

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
import com.google.cloud.networkconnectivity.v1beta.AcceptHubSpokeRequest;
import com.google.cloud.networkconnectivity.v1beta.AcceptHubSpokeResponse;
import com.google.cloud.networkconnectivity.v1beta.AcceptSpokeUpdateRequest;
import com.google.cloud.networkconnectivity.v1beta.AcceptSpokeUpdateResponse;
import com.google.cloud.networkconnectivity.v1beta.CreateGatewayAdvertisedRouteRequest;
import com.google.cloud.networkconnectivity.v1beta.CreateHubRequest;
import com.google.cloud.networkconnectivity.v1beta.CreateSpokeRequest;
import com.google.cloud.networkconnectivity.v1beta.DeleteGatewayAdvertisedRouteRequest;
import com.google.cloud.networkconnectivity.v1beta.DeleteHubRequest;
import com.google.cloud.networkconnectivity.v1beta.DeleteSpokeRequest;
import com.google.cloud.networkconnectivity.v1beta.GatewayAdvertisedRoute;
import com.google.cloud.networkconnectivity.v1beta.GetGatewayAdvertisedRouteRequest;
import com.google.cloud.networkconnectivity.v1beta.GetGroupRequest;
import com.google.cloud.networkconnectivity.v1beta.GetHubRequest;
import com.google.cloud.networkconnectivity.v1beta.GetRouteRequest;
import com.google.cloud.networkconnectivity.v1beta.GetRouteTableRequest;
import com.google.cloud.networkconnectivity.v1beta.GetSpokeRequest;
import com.google.cloud.networkconnectivity.v1beta.Group;
import com.google.cloud.networkconnectivity.v1beta.Hub;
import com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesRequest;
import com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesResponse;
import com.google.cloud.networkconnectivity.v1beta.ListGroupsRequest;
import com.google.cloud.networkconnectivity.v1beta.ListGroupsResponse;
import com.google.cloud.networkconnectivity.v1beta.ListHubSpokesRequest;
import com.google.cloud.networkconnectivity.v1beta.ListHubSpokesResponse;
import com.google.cloud.networkconnectivity.v1beta.ListHubsRequest;
import com.google.cloud.networkconnectivity.v1beta.ListHubsResponse;
import com.google.cloud.networkconnectivity.v1beta.ListRouteTablesRequest;
import com.google.cloud.networkconnectivity.v1beta.ListRouteTablesResponse;
import com.google.cloud.networkconnectivity.v1beta.ListRoutesRequest;
import com.google.cloud.networkconnectivity.v1beta.ListRoutesResponse;
import com.google.cloud.networkconnectivity.v1beta.ListSpokesRequest;
import com.google.cloud.networkconnectivity.v1beta.ListSpokesResponse;
import com.google.cloud.networkconnectivity.v1beta.OperationMetadata;
import com.google.cloud.networkconnectivity.v1beta.QueryHubStatusRequest;
import com.google.cloud.networkconnectivity.v1beta.QueryHubStatusResponse;
import com.google.cloud.networkconnectivity.v1beta.RejectHubSpokeRequest;
import com.google.cloud.networkconnectivity.v1beta.RejectHubSpokeResponse;
import com.google.cloud.networkconnectivity.v1beta.RejectSpokeUpdateRequest;
import com.google.cloud.networkconnectivity.v1beta.RejectSpokeUpdateResponse;
import com.google.cloud.networkconnectivity.v1beta.Route;
import com.google.cloud.networkconnectivity.v1beta.RouteTable;
import com.google.cloud.networkconnectivity.v1beta.Spoke;
import com.google.cloud.networkconnectivity.v1beta.UpdateGatewayAdvertisedRouteRequest;
import com.google.cloud.networkconnectivity.v1beta.UpdateGroupRequest;
import com.google.cloud.networkconnectivity.v1beta.UpdateHubRequest;
import com.google.cloud.networkconnectivity.v1beta.UpdateSpokeRequest;
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
 * gRPC stub implementation for the HubService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcHubServiceStub extends HubServiceStub {
  private static final MethodDescriptor<ListHubsRequest, ListHubsResponse>
      listHubsMethodDescriptor =
          MethodDescriptor.<ListHubsRequest, ListHubsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkconnectivity.v1beta.HubService/ListHubs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListHubsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListHubsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetHubRequest, Hub> getHubMethodDescriptor =
      MethodDescriptor.<GetHubRequest, Hub>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1beta.HubService/GetHub")
          .setRequestMarshaller(ProtoUtils.marshaller(GetHubRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Hub.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateHubRequest, Operation> createHubMethodDescriptor =
      MethodDescriptor.<CreateHubRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1beta.HubService/CreateHub")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateHubRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateHubRequest, Operation> updateHubMethodDescriptor =
      MethodDescriptor.<UpdateHubRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1beta.HubService/UpdateHub")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateHubRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteHubRequest, Operation> deleteHubMethodDescriptor =
      MethodDescriptor.<DeleteHubRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1beta.HubService/DeleteHub")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteHubRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListHubSpokesRequest, ListHubSpokesResponse>
      listHubSpokesMethodDescriptor =
          MethodDescriptor.<ListHubSpokesRequest, ListHubSpokesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkconnectivity.v1beta.HubService/ListHubSpokes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListHubSpokesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListHubSpokesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<QueryHubStatusRequest, QueryHubStatusResponse>
      queryHubStatusMethodDescriptor =
          MethodDescriptor.<QueryHubStatusRequest, QueryHubStatusResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.HubService/QueryHubStatus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryHubStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryHubStatusResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListSpokesRequest, ListSpokesResponse>
      listSpokesMethodDescriptor =
          MethodDescriptor.<ListSpokesRequest, ListSpokesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkconnectivity.v1beta.HubService/ListSpokes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSpokesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSpokesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSpokeRequest, Spoke> getSpokeMethodDescriptor =
      MethodDescriptor.<GetSpokeRequest, Spoke>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1beta.HubService/GetSpoke")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSpokeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Spoke.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateSpokeRequest, Operation> createSpokeMethodDescriptor =
      MethodDescriptor.<CreateSpokeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1beta.HubService/CreateSpoke")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSpokeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateSpokeRequest, Operation> updateSpokeMethodDescriptor =
      MethodDescriptor.<UpdateSpokeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1beta.HubService/UpdateSpoke")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSpokeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<RejectHubSpokeRequest, Operation>
      rejectHubSpokeMethodDescriptor =
          MethodDescriptor.<RejectHubSpokeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.HubService/RejectHubSpoke")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RejectHubSpokeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<AcceptHubSpokeRequest, Operation>
      acceptHubSpokeMethodDescriptor =
          MethodDescriptor.<AcceptHubSpokeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.HubService/AcceptHubSpoke")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AcceptHubSpokeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<AcceptSpokeUpdateRequest, Operation>
      acceptSpokeUpdateMethodDescriptor =
          MethodDescriptor.<AcceptSpokeUpdateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.HubService/AcceptSpokeUpdate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AcceptSpokeUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RejectSpokeUpdateRequest, Operation>
      rejectSpokeUpdateMethodDescriptor =
          MethodDescriptor.<RejectSpokeUpdateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.HubService/RejectSpokeUpdate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RejectSpokeUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteSpokeRequest, Operation> deleteSpokeMethodDescriptor =
      MethodDescriptor.<DeleteSpokeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1beta.HubService/DeleteSpoke")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSpokeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetRouteTableRequest, RouteTable>
      getRouteTableMethodDescriptor =
          MethodDescriptor.<GetRouteTableRequest, RouteTable>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkconnectivity.v1beta.HubService/GetRouteTable")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRouteTableRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RouteTable.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetRouteRequest, Route> getRouteMethodDescriptor =
      MethodDescriptor.<GetRouteRequest, Route>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1beta.HubService/GetRoute")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRouteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Route.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListRoutesRequest, ListRoutesResponse>
      listRoutesMethodDescriptor =
          MethodDescriptor.<ListRoutesRequest, ListRoutesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkconnectivity.v1beta.HubService/ListRoutes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRoutesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListRoutesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListRouteTablesRequest, ListRouteTablesResponse>
      listRouteTablesMethodDescriptor =
          MethodDescriptor.<ListRouteTablesRequest, ListRouteTablesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.HubService/ListRouteTables")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRouteTablesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRouteTablesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetGroupRequest, Group> getGroupMethodDescriptor =
      MethodDescriptor.<GetGroupRequest, Group>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1beta.HubService/GetGroup")
          .setRequestMarshaller(ProtoUtils.marshaller(GetGroupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Group.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListGroupsRequest, ListGroupsResponse>
      listGroupsMethodDescriptor =
          MethodDescriptor.<ListGroupsRequest, ListGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkconnectivity.v1beta.HubService/ListGroups")
              .setRequestMarshaller(ProtoUtils.marshaller(ListGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListGroupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateGroupRequest, Operation> updateGroupMethodDescriptor =
      MethodDescriptor.<UpdateGroupRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networkconnectivity.v1beta.HubService/UpdateGroup")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateGroupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateGatewayAdvertisedRouteRequest, Operation>
      createGatewayAdvertisedRouteMethodDescriptor =
          MethodDescriptor.<CreateGatewayAdvertisedRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.HubService/CreateGatewayAdvertisedRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGatewayAdvertisedRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetGatewayAdvertisedRouteRequest, GatewayAdvertisedRoute>
      getGatewayAdvertisedRouteMethodDescriptor =
          MethodDescriptor.<GetGatewayAdvertisedRouteRequest, GatewayAdvertisedRoute>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.HubService/GetGatewayAdvertisedRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGatewayAdvertisedRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GatewayAdvertisedRoute.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListGatewayAdvertisedRoutesRequest, ListGatewayAdvertisedRoutesResponse>
      listGatewayAdvertisedRoutesMethodDescriptor =
          MethodDescriptor
              .<ListGatewayAdvertisedRoutesRequest, ListGatewayAdvertisedRoutesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.HubService/ListGatewayAdvertisedRoutes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGatewayAdvertisedRoutesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGatewayAdvertisedRoutesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateGatewayAdvertisedRouteRequest, Operation>
      updateGatewayAdvertisedRouteMethodDescriptor =
          MethodDescriptor.<UpdateGatewayAdvertisedRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.HubService/UpdateGatewayAdvertisedRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGatewayAdvertisedRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteGatewayAdvertisedRouteRequest, Operation>
      deleteGatewayAdvertisedRouteMethodDescriptor =
          MethodDescriptor.<DeleteGatewayAdvertisedRouteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1beta.HubService/DeleteGatewayAdvertisedRoute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGatewayAdvertisedRouteRequest.getDefaultInstance()))
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
  private final UnaryCallable<QueryHubStatusRequest, QueryHubStatusResponse> queryHubStatusCallable;
  private final UnaryCallable<QueryHubStatusRequest, QueryHubStatusPagedResponse>
      queryHubStatusPagedCallable;
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
  private final UnaryCallable<AcceptSpokeUpdateRequest, Operation> acceptSpokeUpdateCallable;
  private final OperationCallable<
          AcceptSpokeUpdateRequest, AcceptSpokeUpdateResponse, OperationMetadata>
      acceptSpokeUpdateOperationCallable;
  private final UnaryCallable<RejectSpokeUpdateRequest, Operation> rejectSpokeUpdateCallable;
  private final OperationCallable<
          RejectSpokeUpdateRequest, RejectSpokeUpdateResponse, OperationMetadata>
      rejectSpokeUpdateOperationCallable;
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
  private final UnaryCallable<UpdateGroupRequest, Operation> updateGroupCallable;
  private final OperationCallable<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationCallable;
  private final UnaryCallable<CreateGatewayAdvertisedRouteRequest, Operation>
      createGatewayAdvertisedRouteCallable;
  private final OperationCallable<
          CreateGatewayAdvertisedRouteRequest, GatewayAdvertisedRoute, OperationMetadata>
      createGatewayAdvertisedRouteOperationCallable;
  private final UnaryCallable<GetGatewayAdvertisedRouteRequest, GatewayAdvertisedRoute>
      getGatewayAdvertisedRouteCallable;
  private final UnaryCallable<
          ListGatewayAdvertisedRoutesRequest, ListGatewayAdvertisedRoutesResponse>
      listGatewayAdvertisedRoutesCallable;
  private final UnaryCallable<
          ListGatewayAdvertisedRoutesRequest, ListGatewayAdvertisedRoutesPagedResponse>
      listGatewayAdvertisedRoutesPagedCallable;
  private final UnaryCallable<UpdateGatewayAdvertisedRouteRequest, Operation>
      updateGatewayAdvertisedRouteCallable;
  private final OperationCallable<
          UpdateGatewayAdvertisedRouteRequest, GatewayAdvertisedRoute, OperationMetadata>
      updateGatewayAdvertisedRouteOperationCallable;
  private final UnaryCallable<DeleteGatewayAdvertisedRouteRequest, Operation>
      deleteGatewayAdvertisedRouteCallable;
  private final OperationCallable<DeleteGatewayAdvertisedRouteRequest, Empty, OperationMetadata>
      deleteGatewayAdvertisedRouteOperationCallable;
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
            .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<QueryHubStatusRequest, QueryHubStatusResponse>
        queryHubStatusTransportSettings =
            GrpcCallSettings.<QueryHubStatusRequest, QueryHubStatusResponse>newBuilder()
                .setMethodDescriptor(queryHubStatusMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<AcceptSpokeUpdateRequest, Operation> acceptSpokeUpdateTransportSettings =
        GrpcCallSettings.<AcceptSpokeUpdateRequest, Operation>newBuilder()
            .setMethodDescriptor(acceptSpokeUpdateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<RejectSpokeUpdateRequest, Operation> rejectSpokeUpdateTransportSettings =
        GrpcCallSettings.<RejectSpokeUpdateRequest, Operation>newBuilder()
            .setMethodDescriptor(rejectSpokeUpdateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getParent())
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
                .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateGroupRequest, Operation> updateGroupTransportSettings =
        GrpcCallSettings.<UpdateGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(updateGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("group.name", String.valueOf(request.getGroup().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateGatewayAdvertisedRouteRequest, Operation>
        createGatewayAdvertisedRouteTransportSettings =
            GrpcCallSettings.<CreateGatewayAdvertisedRouteRequest, Operation>newBuilder()
                .setMethodDescriptor(createGatewayAdvertisedRouteMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetGatewayAdvertisedRouteRequest, GatewayAdvertisedRoute>
        getGatewayAdvertisedRouteTransportSettings =
            GrpcCallSettings.<GetGatewayAdvertisedRouteRequest, GatewayAdvertisedRoute>newBuilder()
                .setMethodDescriptor(getGatewayAdvertisedRouteMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListGatewayAdvertisedRoutesRequest, ListGatewayAdvertisedRoutesResponse>
        listGatewayAdvertisedRoutesTransportSettings =
            GrpcCallSettings
                .<ListGatewayAdvertisedRoutesRequest, ListGatewayAdvertisedRoutesResponse>
                    newBuilder()
                .setMethodDescriptor(listGatewayAdvertisedRoutesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateGatewayAdvertisedRouteRequest, Operation>
        updateGatewayAdvertisedRouteTransportSettings =
            GrpcCallSettings.<UpdateGatewayAdvertisedRouteRequest, Operation>newBuilder()
                .setMethodDescriptor(updateGatewayAdvertisedRouteMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "gateway_advertised_route.name",
                          String.valueOf(request.getGatewayAdvertisedRoute().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteGatewayAdvertisedRouteRequest, Operation>
        deleteGatewayAdvertisedRouteTransportSettings =
            GrpcCallSettings.<DeleteGatewayAdvertisedRouteRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteGatewayAdvertisedRouteMethodDescriptor)
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
    this.queryHubStatusCallable =
        callableFactory.createUnaryCallable(
            queryHubStatusTransportSettings, settings.queryHubStatusSettings(), clientContext);
    this.queryHubStatusPagedCallable =
        callableFactory.createPagedCallable(
            queryHubStatusTransportSettings, settings.queryHubStatusSettings(), clientContext);
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
    this.acceptSpokeUpdateCallable =
        callableFactory.createUnaryCallable(
            acceptSpokeUpdateTransportSettings,
            settings.acceptSpokeUpdateSettings(),
            clientContext);
    this.acceptSpokeUpdateOperationCallable =
        callableFactory.createOperationCallable(
            acceptSpokeUpdateTransportSettings,
            settings.acceptSpokeUpdateOperationSettings(),
            clientContext,
            operationsStub);
    this.rejectSpokeUpdateCallable =
        callableFactory.createUnaryCallable(
            rejectSpokeUpdateTransportSettings,
            settings.rejectSpokeUpdateSettings(),
            clientContext);
    this.rejectSpokeUpdateOperationCallable =
        callableFactory.createOperationCallable(
            rejectSpokeUpdateTransportSettings,
            settings.rejectSpokeUpdateOperationSettings(),
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
    this.updateGroupCallable =
        callableFactory.createUnaryCallable(
            updateGroupTransportSettings, settings.updateGroupSettings(), clientContext);
    this.updateGroupOperationCallable =
        callableFactory.createOperationCallable(
            updateGroupTransportSettings,
            settings.updateGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.createGatewayAdvertisedRouteCallable =
        callableFactory.createUnaryCallable(
            createGatewayAdvertisedRouteTransportSettings,
            settings.createGatewayAdvertisedRouteSettings(),
            clientContext);
    this.createGatewayAdvertisedRouteOperationCallable =
        callableFactory.createOperationCallable(
            createGatewayAdvertisedRouteTransportSettings,
            settings.createGatewayAdvertisedRouteOperationSettings(),
            clientContext,
            operationsStub);
    this.getGatewayAdvertisedRouteCallable =
        callableFactory.createUnaryCallable(
            getGatewayAdvertisedRouteTransportSettings,
            settings.getGatewayAdvertisedRouteSettings(),
            clientContext);
    this.listGatewayAdvertisedRoutesCallable =
        callableFactory.createUnaryCallable(
            listGatewayAdvertisedRoutesTransportSettings,
            settings.listGatewayAdvertisedRoutesSettings(),
            clientContext);
    this.listGatewayAdvertisedRoutesPagedCallable =
        callableFactory.createPagedCallable(
            listGatewayAdvertisedRoutesTransportSettings,
            settings.listGatewayAdvertisedRoutesSettings(),
            clientContext);
    this.updateGatewayAdvertisedRouteCallable =
        callableFactory.createUnaryCallable(
            updateGatewayAdvertisedRouteTransportSettings,
            settings.updateGatewayAdvertisedRouteSettings(),
            clientContext);
    this.updateGatewayAdvertisedRouteOperationCallable =
        callableFactory.createOperationCallable(
            updateGatewayAdvertisedRouteTransportSettings,
            settings.updateGatewayAdvertisedRouteOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteGatewayAdvertisedRouteCallable =
        callableFactory.createUnaryCallable(
            deleteGatewayAdvertisedRouteTransportSettings,
            settings.deleteGatewayAdvertisedRouteSettings(),
            clientContext);
    this.deleteGatewayAdvertisedRouteOperationCallable =
        callableFactory.createOperationCallable(
            deleteGatewayAdvertisedRouteTransportSettings,
            settings.deleteGatewayAdvertisedRouteOperationSettings(),
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
  public UnaryCallable<QueryHubStatusRequest, QueryHubStatusResponse> queryHubStatusCallable() {
    return queryHubStatusCallable;
  }

  @Override
  public UnaryCallable<QueryHubStatusRequest, QueryHubStatusPagedResponse>
      queryHubStatusPagedCallable() {
    return queryHubStatusPagedCallable;
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
  public UnaryCallable<AcceptSpokeUpdateRequest, Operation> acceptSpokeUpdateCallable() {
    return acceptSpokeUpdateCallable;
  }

  @Override
  public OperationCallable<AcceptSpokeUpdateRequest, AcceptSpokeUpdateResponse, OperationMetadata>
      acceptSpokeUpdateOperationCallable() {
    return acceptSpokeUpdateOperationCallable;
  }

  @Override
  public UnaryCallable<RejectSpokeUpdateRequest, Operation> rejectSpokeUpdateCallable() {
    return rejectSpokeUpdateCallable;
  }

  @Override
  public OperationCallable<RejectSpokeUpdateRequest, RejectSpokeUpdateResponse, OperationMetadata>
      rejectSpokeUpdateOperationCallable() {
    return rejectSpokeUpdateOperationCallable;
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
  public UnaryCallable<UpdateGroupRequest, Operation> updateGroupCallable() {
    return updateGroupCallable;
  }

  @Override
  public OperationCallable<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationCallable() {
    return updateGroupOperationCallable;
  }

  @Override
  public UnaryCallable<CreateGatewayAdvertisedRouteRequest, Operation>
      createGatewayAdvertisedRouteCallable() {
    return createGatewayAdvertisedRouteCallable;
  }

  @Override
  public OperationCallable<
          CreateGatewayAdvertisedRouteRequest, GatewayAdvertisedRoute, OperationMetadata>
      createGatewayAdvertisedRouteOperationCallable() {
    return createGatewayAdvertisedRouteOperationCallable;
  }

  @Override
  public UnaryCallable<GetGatewayAdvertisedRouteRequest, GatewayAdvertisedRoute>
      getGatewayAdvertisedRouteCallable() {
    return getGatewayAdvertisedRouteCallable;
  }

  @Override
  public UnaryCallable<ListGatewayAdvertisedRoutesRequest, ListGatewayAdvertisedRoutesResponse>
      listGatewayAdvertisedRoutesCallable() {
    return listGatewayAdvertisedRoutesCallable;
  }

  @Override
  public UnaryCallable<ListGatewayAdvertisedRoutesRequest, ListGatewayAdvertisedRoutesPagedResponse>
      listGatewayAdvertisedRoutesPagedCallable() {
    return listGatewayAdvertisedRoutesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateGatewayAdvertisedRouteRequest, Operation>
      updateGatewayAdvertisedRouteCallable() {
    return updateGatewayAdvertisedRouteCallable;
  }

  @Override
  public OperationCallable<
          UpdateGatewayAdvertisedRouteRequest, GatewayAdvertisedRoute, OperationMetadata>
      updateGatewayAdvertisedRouteOperationCallable() {
    return updateGatewayAdvertisedRouteOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGatewayAdvertisedRouteRequest, Operation>
      deleteGatewayAdvertisedRouteCallable() {
    return deleteGatewayAdvertisedRouteCallable;
  }

  @Override
  public OperationCallable<DeleteGatewayAdvertisedRouteRequest, Empty, OperationMetadata>
      deleteGatewayAdvertisedRouteOperationCallable() {
    return deleteGatewayAdvertisedRouteOperationCallable;
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
