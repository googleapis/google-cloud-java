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
import com.google.api.gax.rpc.OperationCallable;
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
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the HubService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class HubServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListHubsRequest, ListHubsPagedResponse> listHubsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listHubsPagedCallable()");
  }

  public UnaryCallable<ListHubsRequest, ListHubsResponse> listHubsCallable() {
    throw new UnsupportedOperationException("Not implemented: listHubsCallable()");
  }

  public UnaryCallable<GetHubRequest, Hub> getHubCallable() {
    throw new UnsupportedOperationException("Not implemented: getHubCallable()");
  }

  public OperationCallable<CreateHubRequest, Hub, OperationMetadata> createHubOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createHubOperationCallable()");
  }

  public UnaryCallable<CreateHubRequest, Operation> createHubCallable() {
    throw new UnsupportedOperationException("Not implemented: createHubCallable()");
  }

  public OperationCallable<UpdateHubRequest, Hub, OperationMetadata> updateHubOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateHubOperationCallable()");
  }

  public UnaryCallable<UpdateHubRequest, Operation> updateHubCallable() {
    throw new UnsupportedOperationException("Not implemented: updateHubCallable()");
  }

  public OperationCallable<DeleteHubRequest, Empty, OperationMetadata>
      deleteHubOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteHubOperationCallable()");
  }

  public UnaryCallable<DeleteHubRequest, Operation> deleteHubCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteHubCallable()");
  }

  public UnaryCallable<ListHubSpokesRequest, ListHubSpokesPagedResponse>
      listHubSpokesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listHubSpokesPagedCallable()");
  }

  public UnaryCallable<ListHubSpokesRequest, ListHubSpokesResponse> listHubSpokesCallable() {
    throw new UnsupportedOperationException("Not implemented: listHubSpokesCallable()");
  }

  public UnaryCallable<QueryHubStatusRequest, QueryHubStatusPagedResponse>
      queryHubStatusPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: queryHubStatusPagedCallable()");
  }

  public UnaryCallable<QueryHubStatusRequest, QueryHubStatusResponse> queryHubStatusCallable() {
    throw new UnsupportedOperationException("Not implemented: queryHubStatusCallable()");
  }

  public UnaryCallable<ListSpokesRequest, ListSpokesPagedResponse> listSpokesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSpokesPagedCallable()");
  }

  public UnaryCallable<ListSpokesRequest, ListSpokesResponse> listSpokesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSpokesCallable()");
  }

  public UnaryCallable<GetSpokeRequest, Spoke> getSpokeCallable() {
    throw new UnsupportedOperationException("Not implemented: getSpokeCallable()");
  }

  public OperationCallable<CreateSpokeRequest, Spoke, OperationMetadata>
      createSpokeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createSpokeOperationCallable()");
  }

  public UnaryCallable<CreateSpokeRequest, Operation> createSpokeCallable() {
    throw new UnsupportedOperationException("Not implemented: createSpokeCallable()");
  }

  public OperationCallable<UpdateSpokeRequest, Spoke, OperationMetadata>
      updateSpokeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSpokeOperationCallable()");
  }

  public UnaryCallable<UpdateSpokeRequest, Operation> updateSpokeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSpokeCallable()");
  }

  public OperationCallable<RejectHubSpokeRequest, RejectHubSpokeResponse, OperationMetadata>
      rejectHubSpokeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: rejectHubSpokeOperationCallable()");
  }

  public UnaryCallable<RejectHubSpokeRequest, Operation> rejectHubSpokeCallable() {
    throw new UnsupportedOperationException("Not implemented: rejectHubSpokeCallable()");
  }

  public OperationCallable<AcceptHubSpokeRequest, AcceptHubSpokeResponse, OperationMetadata>
      acceptHubSpokeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: acceptHubSpokeOperationCallable()");
  }

  public UnaryCallable<AcceptHubSpokeRequest, Operation> acceptHubSpokeCallable() {
    throw new UnsupportedOperationException("Not implemented: acceptHubSpokeCallable()");
  }

  public OperationCallable<AcceptSpokeUpdateRequest, AcceptSpokeUpdateResponse, OperationMetadata>
      acceptSpokeUpdateOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: acceptSpokeUpdateOperationCallable()");
  }

  public UnaryCallable<AcceptSpokeUpdateRequest, Operation> acceptSpokeUpdateCallable() {
    throw new UnsupportedOperationException("Not implemented: acceptSpokeUpdateCallable()");
  }

  public OperationCallable<RejectSpokeUpdateRequest, RejectSpokeUpdateResponse, OperationMetadata>
      rejectSpokeUpdateOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: rejectSpokeUpdateOperationCallable()");
  }

  public UnaryCallable<RejectSpokeUpdateRequest, Operation> rejectSpokeUpdateCallable() {
    throw new UnsupportedOperationException("Not implemented: rejectSpokeUpdateCallable()");
  }

  public OperationCallable<DeleteSpokeRequest, Empty, OperationMetadata>
      deleteSpokeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSpokeOperationCallable()");
  }

  public UnaryCallable<DeleteSpokeRequest, Operation> deleteSpokeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSpokeCallable()");
  }

  public UnaryCallable<GetRouteTableRequest, RouteTable> getRouteTableCallable() {
    throw new UnsupportedOperationException("Not implemented: getRouteTableCallable()");
  }

  public UnaryCallable<GetRouteRequest, Route> getRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: getRouteCallable()");
  }

  public UnaryCallable<ListRoutesRequest, ListRoutesPagedResponse> listRoutesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRoutesPagedCallable()");
  }

  public UnaryCallable<ListRoutesRequest, ListRoutesResponse> listRoutesCallable() {
    throw new UnsupportedOperationException("Not implemented: listRoutesCallable()");
  }

  public UnaryCallable<ListRouteTablesRequest, ListRouteTablesPagedResponse>
      listRouteTablesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRouteTablesPagedCallable()");
  }

  public UnaryCallable<ListRouteTablesRequest, ListRouteTablesResponse> listRouteTablesCallable() {
    throw new UnsupportedOperationException("Not implemented: listRouteTablesCallable()");
  }

  public UnaryCallable<GetGroupRequest, Group> getGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getGroupCallable()");
  }

  public UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGroupsPagedCallable()");
  }

  public UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listGroupsCallable()");
  }

  public OperationCallable<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGroupOperationCallable()");
  }

  public UnaryCallable<UpdateGroupRequest, Operation> updateGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGroupCallable()");
  }

  public OperationCallable<
          CreateGatewayAdvertisedRouteRequest, GatewayAdvertisedRoute, OperationMetadata>
      createGatewayAdvertisedRouteOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createGatewayAdvertisedRouteOperationCallable()");
  }

  public UnaryCallable<CreateGatewayAdvertisedRouteRequest, Operation>
      createGatewayAdvertisedRouteCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createGatewayAdvertisedRouteCallable()");
  }

  public UnaryCallable<GetGatewayAdvertisedRouteRequest, GatewayAdvertisedRoute>
      getGatewayAdvertisedRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: getGatewayAdvertisedRouteCallable()");
  }

  public UnaryCallable<ListGatewayAdvertisedRoutesRequest, ListGatewayAdvertisedRoutesPagedResponse>
      listGatewayAdvertisedRoutesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listGatewayAdvertisedRoutesPagedCallable()");
  }

  public UnaryCallable<ListGatewayAdvertisedRoutesRequest, ListGatewayAdvertisedRoutesResponse>
      listGatewayAdvertisedRoutesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listGatewayAdvertisedRoutesCallable()");
  }

  public OperationCallable<
          UpdateGatewayAdvertisedRouteRequest, GatewayAdvertisedRoute, OperationMetadata>
      updateGatewayAdvertisedRouteOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGatewayAdvertisedRouteOperationCallable()");
  }

  public UnaryCallable<UpdateGatewayAdvertisedRouteRequest, Operation>
      updateGatewayAdvertisedRouteCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGatewayAdvertisedRouteCallable()");
  }

  public OperationCallable<DeleteGatewayAdvertisedRouteRequest, Empty, OperationMetadata>
      deleteGatewayAdvertisedRouteOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGatewayAdvertisedRouteOperationCallable()");
  }

  public UnaryCallable<DeleteGatewayAdvertisedRouteRequest, Operation>
      deleteGatewayAdvertisedRouteCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGatewayAdvertisedRouteCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
