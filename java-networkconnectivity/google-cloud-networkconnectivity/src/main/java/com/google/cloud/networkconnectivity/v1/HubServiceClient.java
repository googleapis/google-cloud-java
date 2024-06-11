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

package com.google.cloud.networkconnectivity.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkconnectivity.v1.stub.HubServiceStub;
import com.google.cloud.networkconnectivity.v1.stub.HubServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Network Connectivity Center is a hub-and-spoke abstraction for network
 * connectivity management in Google Cloud. It reduces operational complexity through a simple,
 * centralized connectivity management model.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
 *   HubName name = HubName.of("[PROJECT]", "[HUB]");
 *   Hub response = hubServiceClient.getHub(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the HubServiceClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListHubs</td>
 *      <td><p> Lists the Network Connectivity Center hubs associated with a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listHubs(ListHubsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listHubs(LocationName parent)
 *           <li><p> listHubs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listHubsPagedCallable()
 *           <li><p> listHubsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetHub</td>
 *      <td><p> Gets details about a Network Connectivity Center hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getHub(GetHubRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getHub(HubName name)
 *           <li><p> getHub(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getHubCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateHub</td>
 *      <td><p> Creates a new Network Connectivity Center hub in the specified project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createHubAsync(CreateHubRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createHubAsync(LocationName parent, Hub hub, String hubId)
 *           <li><p> createHubAsync(String parent, Hub hub, String hubId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createHubOperationCallable()
 *           <li><p> createHubCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateHub</td>
 *      <td><p> Updates the description and/or labels of a Network Connectivity Center hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateHubAsync(UpdateHubRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateHubAsync(Hub hub, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateHubOperationCallable()
 *           <li><p> updateHubCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteHub</td>
 *      <td><p> Deletes a Network Connectivity Center hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteHubAsync(DeleteHubRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteHubAsync(HubName name)
 *           <li><p> deleteHubAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteHubOperationCallable()
 *           <li><p> deleteHubCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListHubSpokes</td>
 *      <td><p> Lists the Network Connectivity Center spokes associated with a specified hub and location. The list includes both spokes that are attached to the hub and spokes that have been proposed but not yet accepted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listHubSpokes(ListHubSpokesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listHubSpokes(HubName name)
 *           <li><p> listHubSpokes(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listHubSpokesPagedCallable()
 *           <li><p> listHubSpokesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSpokes</td>
 *      <td><p> Lists the Network Connectivity Center spokes in a specified project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSpokes(ListSpokesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSpokes(LocationName parent)
 *           <li><p> listSpokes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSpokesPagedCallable()
 *           <li><p> listSpokesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSpoke</td>
 *      <td><p> Gets details about a Network Connectivity Center spoke.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSpoke(GetSpokeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSpoke(SpokeName name)
 *           <li><p> getSpoke(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSpokeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSpoke</td>
 *      <td><p> Creates a Network Connectivity Center spoke.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSpokeAsync(CreateSpokeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createSpokeAsync(LocationName parent, Spoke spoke, String spokeId)
 *           <li><p> createSpokeAsync(String parent, Spoke spoke, String spokeId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSpokeOperationCallable()
 *           <li><p> createSpokeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSpoke</td>
 *      <td><p> Updates the parameters of a Network Connectivity Center spoke.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSpokeAsync(UpdateSpokeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateSpokeAsync(Spoke spoke, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSpokeOperationCallable()
 *           <li><p> updateSpokeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RejectHubSpoke</td>
 *      <td><p> Rejects a Network Connectivity Center spoke from being attached to a hub. If the spoke was previously in the `ACTIVE` state, it transitions to the `INACTIVE` state and is no longer able to connect to other spokes that are attached to the hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rejectHubSpokeAsync(RejectHubSpokeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> rejectHubSpokeAsync(HubName name, SpokeName spokeUri)
 *           <li><p> rejectHubSpokeAsync(HubName name, String spokeUri)
 *           <li><p> rejectHubSpokeAsync(String name, SpokeName spokeUri)
 *           <li><p> rejectHubSpokeAsync(String name, String spokeUri)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rejectHubSpokeOperationCallable()
 *           <li><p> rejectHubSpokeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AcceptHubSpoke</td>
 *      <td><p> Accepts a proposal to attach a Network Connectivity Center spoke to a hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> acceptHubSpokeAsync(AcceptHubSpokeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> acceptHubSpokeAsync(HubName name, SpokeName spokeUri)
 *           <li><p> acceptHubSpokeAsync(HubName name, String spokeUri)
 *           <li><p> acceptHubSpokeAsync(String name, SpokeName spokeUri)
 *           <li><p> acceptHubSpokeAsync(String name, String spokeUri)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> acceptHubSpokeOperationCallable()
 *           <li><p> acceptHubSpokeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSpoke</td>
 *      <td><p> Deletes a Network Connectivity Center spoke.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSpokeAsync(DeleteSpokeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteSpokeAsync(SpokeName name)
 *           <li><p> deleteSpokeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSpokeOperationCallable()
 *           <li><p> deleteSpokeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRouteTable</td>
 *      <td><p> Gets details about a Network Connectivity Center route table.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRouteTable(GetRouteTableRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRouteTable(RouteTableName name)
 *           <li><p> getRouteTable(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRouteTableCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRoute</td>
 *      <td><p> Gets details about the specified route.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRoute(GetRouteRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRoute(HubRouteName name)
 *           <li><p> getRoute(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRouteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRoutes</td>
 *      <td><p> Lists routes in a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRoutes(ListRoutesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRoutes(RouteTableName parent)
 *           <li><p> listRoutes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRoutesPagedCallable()
 *           <li><p> listRoutesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRouteTables</td>
 *      <td><p> Lists route tables in a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRouteTables(ListRouteTablesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRouteTables(HubName parent)
 *           <li><p> listRouteTables(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRouteTablesPagedCallable()
 *           <li><p> listRouteTablesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGroup</td>
 *      <td><p> Gets details about a Network Connectivity Center group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGroup(GetGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGroup(GroupName name)
 *           <li><p> getGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGroups</td>
 *      <td><p> Lists groups in a given hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGroups(ListGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGroups(HubName parent)
 *           <li><p> listGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGroupsPagedCallable()
 *           <li><p> listGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of HubServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * HubServiceSettings hubServiceSettings =
 *     HubServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * HubServiceClient hubServiceClient = HubServiceClient.create(hubServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * HubServiceSettings hubServiceSettings =
 *     HubServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * HubServiceClient hubServiceClient = HubServiceClient.create(hubServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class HubServiceClient implements BackgroundResource {
  private final HubServiceSettings settings;
  private final HubServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of HubServiceClient with default settings. */
  public static final HubServiceClient create() throws IOException {
    return create(HubServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of HubServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final HubServiceClient create(HubServiceSettings settings) throws IOException {
    return new HubServiceClient(settings);
  }

  /**
   * Constructs an instance of HubServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(HubServiceSettings).
   */
  public static final HubServiceClient create(HubServiceStub stub) {
    return new HubServiceClient(stub);
  }

  /**
   * Constructs an instance of HubServiceClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected HubServiceClient(HubServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((HubServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected HubServiceClient(HubServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final HubServiceSettings getSettings() {
    return settings;
  }

  public HubServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Network Connectivity Center hubs associated with a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Hub element : hubServiceClient.listHubs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHubsPagedResponse listHubs(LocationName parent) {
    ListHubsRequest request =
        ListHubsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listHubs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Network Connectivity Center hubs associated with a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Hub element : hubServiceClient.listHubs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHubsPagedResponse listHubs(String parent) {
    ListHubsRequest request = ListHubsRequest.newBuilder().setParent(parent).build();
    return listHubs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Network Connectivity Center hubs associated with a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListHubsRequest request =
   *       ListHubsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Hub element : hubServiceClient.listHubs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHubsPagedResponse listHubs(ListHubsRequest request) {
    return listHubsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Network Connectivity Center hubs associated with a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListHubsRequest request =
   *       ListHubsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Hub> future = hubServiceClient.listHubsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Hub element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHubsRequest, ListHubsPagedResponse> listHubsPagedCallable() {
    return stub.listHubsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Network Connectivity Center hubs associated with a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListHubsRequest request =
   *       ListHubsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListHubsResponse response = hubServiceClient.listHubsCallable().call(request);
   *     for (Hub element : response.getHubsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHubsRequest, ListHubsResponse> listHubsCallable() {
    return stub.listHubsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Network Connectivity Center hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   HubName name = HubName.of("[PROJECT]", "[HUB]");
   *   Hub response = hubServiceClient.getHub(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the hub resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Hub getHub(HubName name) {
    GetHubRequest request =
        GetHubRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getHub(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Network Connectivity Center hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String name = HubName.of("[PROJECT]", "[HUB]").toString();
   *   Hub response = hubServiceClient.getHub(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the hub resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Hub getHub(String name) {
    GetHubRequest request = GetHubRequest.newBuilder().setName(name).build();
    return getHub(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Network Connectivity Center hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   GetHubRequest request =
   *       GetHubRequest.newBuilder().setName(HubName.of("[PROJECT]", "[HUB]").toString()).build();
   *   Hub response = hubServiceClient.getHub(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Hub getHub(GetHubRequest request) {
    return getHubCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Network Connectivity Center hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   GetHubRequest request =
   *       GetHubRequest.newBuilder().setName(HubName.of("[PROJECT]", "[HUB]").toString()).build();
   *   ApiFuture<Hub> future = hubServiceClient.getHubCallable().futureCall(request);
   *   // Do something.
   *   Hub response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHubRequest, Hub> getHubCallable() {
    return stub.getHubCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Network Connectivity Center hub in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Hub hub = Hub.newBuilder().build();
   *   String hubId = "hubId99628272";
   *   Hub response = hubServiceClient.createHubAsync(parent, hub, hubId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource.
   * @param hub Required. The initial values for a new hub.
   * @param hubId Required. A unique identifier for the hub.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hub, OperationMetadata> createHubAsync(
      LocationName parent, Hub hub, String hubId) {
    CreateHubRequest request =
        CreateHubRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setHub(hub)
            .setHubId(hubId)
            .build();
    return createHubAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Network Connectivity Center hub in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Hub hub = Hub.newBuilder().build();
   *   String hubId = "hubId99628272";
   *   Hub response = hubServiceClient.createHubAsync(parent, hub, hubId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource.
   * @param hub Required. The initial values for a new hub.
   * @param hubId Required. A unique identifier for the hub.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hub, OperationMetadata> createHubAsync(
      String parent, Hub hub, String hubId) {
    CreateHubRequest request =
        CreateHubRequest.newBuilder().setParent(parent).setHub(hub).setHubId(hubId).build();
    return createHubAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Network Connectivity Center hub in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   CreateHubRequest request =
   *       CreateHubRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setHubId("hubId99628272")
   *           .setHub(Hub.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Hub response = hubServiceClient.createHubAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hub, OperationMetadata> createHubAsync(CreateHubRequest request) {
    return createHubOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Network Connectivity Center hub in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   CreateHubRequest request =
   *       CreateHubRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setHubId("hubId99628272")
   *           .setHub(Hub.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Hub, OperationMetadata> future =
   *       hubServiceClient.createHubOperationCallable().futureCall(request);
   *   // Do something.
   *   Hub response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateHubRequest, Hub, OperationMetadata>
      createHubOperationCallable() {
    return stub.createHubOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Network Connectivity Center hub in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   CreateHubRequest request =
   *       CreateHubRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setHubId("hubId99628272")
   *           .setHub(Hub.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = hubServiceClient.createHubCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateHubRequest, Operation> createHubCallable() {
    return stub.createHubCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the description and/or labels of a Network Connectivity Center hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   Hub hub = Hub.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Hub response = hubServiceClient.updateHubAsync(hub, updateMask).get();
   * }
   * }</pre>
   *
   * @param hub Required. The state that the hub should be in after the update.
   * @param updateMask Optional. In the case of an update to an existing hub, field mask is used to
   *     specify the fields to be overwritten. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field is overwritten if it is in the mask. If the
   *     user does not provide a mask, then all fields are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hub, OperationMetadata> updateHubAsync(
      Hub hub, FieldMask updateMask) {
    UpdateHubRequest request =
        UpdateHubRequest.newBuilder().setHub(hub).setUpdateMask(updateMask).build();
    return updateHubAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the description and/or labels of a Network Connectivity Center hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   UpdateHubRequest request =
   *       UpdateHubRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setHub(Hub.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Hub response = hubServiceClient.updateHubAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hub, OperationMetadata> updateHubAsync(UpdateHubRequest request) {
    return updateHubOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the description and/or labels of a Network Connectivity Center hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   UpdateHubRequest request =
   *       UpdateHubRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setHub(Hub.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Hub, OperationMetadata> future =
   *       hubServiceClient.updateHubOperationCallable().futureCall(request);
   *   // Do something.
   *   Hub response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateHubRequest, Hub, OperationMetadata>
      updateHubOperationCallable() {
    return stub.updateHubOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the description and/or labels of a Network Connectivity Center hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   UpdateHubRequest request =
   *       UpdateHubRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setHub(Hub.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = hubServiceClient.updateHubCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateHubRequest, Operation> updateHubCallable() {
    return stub.updateHubCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Network Connectivity Center hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   HubName name = HubName.of("[PROJECT]", "[HUB]");
   *   hubServiceClient.deleteHubAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the hub to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHubAsync(HubName name) {
    DeleteHubRequest request =
        DeleteHubRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteHubAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Network Connectivity Center hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String name = HubName.of("[PROJECT]", "[HUB]").toString();
   *   hubServiceClient.deleteHubAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the hub to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHubAsync(String name) {
    DeleteHubRequest request = DeleteHubRequest.newBuilder().setName(name).build();
    return deleteHubAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Network Connectivity Center hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   DeleteHubRequest request =
   *       DeleteHubRequest.newBuilder()
   *           .setName(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   hubServiceClient.deleteHubAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHubAsync(DeleteHubRequest request) {
    return deleteHubOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Network Connectivity Center hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   DeleteHubRequest request =
   *       DeleteHubRequest.newBuilder()
   *           .setName(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       hubServiceClient.deleteHubOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteHubRequest, Empty, OperationMetadata>
      deleteHubOperationCallable() {
    return stub.deleteHubOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Network Connectivity Center hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   DeleteHubRequest request =
   *       DeleteHubRequest.newBuilder()
   *           .setName(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = hubServiceClient.deleteHubCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteHubRequest, Operation> deleteHubCallable() {
    return stub.deleteHubCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Network Connectivity Center spokes associated with a specified hub and location. The
   * list includes both spokes that are attached to the hub and spokes that have been proposed but
   * not yet accepted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   HubName name = HubName.of("[PROJECT]", "[HUB]");
   *   for (Spoke element : hubServiceClient.listHubSpokes(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the hub.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHubSpokesPagedResponse listHubSpokes(HubName name) {
    ListHubSpokesRequest request =
        ListHubSpokesRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return listHubSpokes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Network Connectivity Center spokes associated with a specified hub and location. The
   * list includes both spokes that are attached to the hub and spokes that have been proposed but
   * not yet accepted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String name = HubName.of("[PROJECT]", "[HUB]").toString();
   *   for (Spoke element : hubServiceClient.listHubSpokes(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the hub.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHubSpokesPagedResponse listHubSpokes(String name) {
    ListHubSpokesRequest request = ListHubSpokesRequest.newBuilder().setName(name).build();
    return listHubSpokes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Network Connectivity Center spokes associated with a specified hub and location. The
   * list includes both spokes that are attached to the hub and spokes that have been proposed but
   * not yet accepted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListHubSpokesRequest request =
   *       ListHubSpokesRequest.newBuilder()
   *           .setName(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .addAllSpokeLocations(new ArrayList<String>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Spoke element : hubServiceClient.listHubSpokes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHubSpokesPagedResponse listHubSpokes(ListHubSpokesRequest request) {
    return listHubSpokesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Network Connectivity Center spokes associated with a specified hub and location. The
   * list includes both spokes that are attached to the hub and spokes that have been proposed but
   * not yet accepted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListHubSpokesRequest request =
   *       ListHubSpokesRequest.newBuilder()
   *           .setName(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .addAllSpokeLocations(new ArrayList<String>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Spoke> future = hubServiceClient.listHubSpokesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Spoke element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHubSpokesRequest, ListHubSpokesPagedResponse>
      listHubSpokesPagedCallable() {
    return stub.listHubSpokesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Network Connectivity Center spokes associated with a specified hub and location. The
   * list includes both spokes that are attached to the hub and spokes that have been proposed but
   * not yet accepted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListHubSpokesRequest request =
   *       ListHubSpokesRequest.newBuilder()
   *           .setName(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .addAllSpokeLocations(new ArrayList<String>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListHubSpokesResponse response = hubServiceClient.listHubSpokesCallable().call(request);
   *     for (Spoke element : response.getSpokesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHubSpokesRequest, ListHubSpokesResponse> listHubSpokesCallable() {
    return stub.listHubSpokesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Network Connectivity Center spokes in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Spoke element : hubServiceClient.listSpokes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpokesPagedResponse listSpokes(LocationName parent) {
    ListSpokesRequest request =
        ListSpokesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSpokes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Network Connectivity Center spokes in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Spoke element : hubServiceClient.listSpokes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpokesPagedResponse listSpokes(String parent) {
    ListSpokesRequest request = ListSpokesRequest.newBuilder().setParent(parent).build();
    return listSpokes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Network Connectivity Center spokes in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListSpokesRequest request =
   *       ListSpokesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Spoke element : hubServiceClient.listSpokes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpokesPagedResponse listSpokes(ListSpokesRequest request) {
    return listSpokesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Network Connectivity Center spokes in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListSpokesRequest request =
   *       ListSpokesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Spoke> future = hubServiceClient.listSpokesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Spoke element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSpokesRequest, ListSpokesPagedResponse> listSpokesPagedCallable() {
    return stub.listSpokesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Network Connectivity Center spokes in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListSpokesRequest request =
   *       ListSpokesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSpokesResponse response = hubServiceClient.listSpokesCallable().call(request);
   *     for (Spoke element : response.getSpokesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSpokesRequest, ListSpokesResponse> listSpokesCallable() {
    return stub.listSpokesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   SpokeName name = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");
   *   Spoke response = hubServiceClient.getSpoke(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spoke resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Spoke getSpoke(SpokeName name) {
    GetSpokeRequest request =
        GetSpokeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSpoke(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String name = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString();
   *   Spoke response = hubServiceClient.getSpoke(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spoke resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Spoke getSpoke(String name) {
    GetSpokeRequest request = GetSpokeRequest.newBuilder().setName(name).build();
    return getSpoke(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   GetSpokeRequest request =
   *       GetSpokeRequest.newBuilder()
   *           .setName(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
   *           .build();
   *   Spoke response = hubServiceClient.getSpoke(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Spoke getSpoke(GetSpokeRequest request) {
    return getSpokeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   GetSpokeRequest request =
   *       GetSpokeRequest.newBuilder()
   *           .setName(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
   *           .build();
   *   ApiFuture<Spoke> future = hubServiceClient.getSpokeCallable().futureCall(request);
   *   // Do something.
   *   Spoke response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSpokeRequest, Spoke> getSpokeCallable() {
    return stub.getSpokeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Spoke spoke = Spoke.newBuilder().build();
   *   String spokeId = "spokeId-1998996281";
   *   Spoke response = hubServiceClient.createSpokeAsync(parent, spoke, spokeId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource.
   * @param spoke Required. The initial values for a new spoke.
   * @param spokeId Required. Unique id for the spoke to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Spoke, OperationMetadata> createSpokeAsync(
      LocationName parent, Spoke spoke, String spokeId) {
    CreateSpokeRequest request =
        CreateSpokeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSpoke(spoke)
            .setSpokeId(spokeId)
            .build();
    return createSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Spoke spoke = Spoke.newBuilder().build();
   *   String spokeId = "spokeId-1998996281";
   *   Spoke response = hubServiceClient.createSpokeAsync(parent, spoke, spokeId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource.
   * @param spoke Required. The initial values for a new spoke.
   * @param spokeId Required. Unique id for the spoke to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Spoke, OperationMetadata> createSpokeAsync(
      String parent, Spoke spoke, String spokeId) {
    CreateSpokeRequest request =
        CreateSpokeRequest.newBuilder()
            .setParent(parent)
            .setSpoke(spoke)
            .setSpokeId(spokeId)
            .build();
    return createSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   CreateSpokeRequest request =
   *       CreateSpokeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSpokeId("spokeId-1998996281")
   *           .setSpoke(Spoke.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Spoke response = hubServiceClient.createSpokeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Spoke, OperationMetadata> createSpokeAsync(
      CreateSpokeRequest request) {
    return createSpokeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   CreateSpokeRequest request =
   *       CreateSpokeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSpokeId("spokeId-1998996281")
   *           .setSpoke(Spoke.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Spoke, OperationMetadata> future =
   *       hubServiceClient.createSpokeOperationCallable().futureCall(request);
   *   // Do something.
   *   Spoke response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateSpokeRequest, Spoke, OperationMetadata>
      createSpokeOperationCallable() {
    return stub.createSpokeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   CreateSpokeRequest request =
   *       CreateSpokeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSpokeId("spokeId-1998996281")
   *           .setSpoke(Spoke.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = hubServiceClient.createSpokeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSpokeRequest, Operation> createSpokeCallable() {
    return stub.createSpokeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   Spoke spoke = Spoke.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Spoke response = hubServiceClient.updateSpokeAsync(spoke, updateMask).get();
   * }
   * }</pre>
   *
   * @param spoke Required. The state that the spoke should be in after the update.
   * @param updateMask Optional. In the case of an update to an existing spoke, field mask is used
   *     to specify the fields to be overwritten. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field is overwritten if it is in the
   *     mask. If the user does not provide a mask, then all fields are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Spoke, OperationMetadata> updateSpokeAsync(
      Spoke spoke, FieldMask updateMask) {
    UpdateSpokeRequest request =
        UpdateSpokeRequest.newBuilder().setSpoke(spoke).setUpdateMask(updateMask).build();
    return updateSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   UpdateSpokeRequest request =
   *       UpdateSpokeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSpoke(Spoke.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Spoke response = hubServiceClient.updateSpokeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Spoke, OperationMetadata> updateSpokeAsync(
      UpdateSpokeRequest request) {
    return updateSpokeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   UpdateSpokeRequest request =
   *       UpdateSpokeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSpoke(Spoke.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Spoke, OperationMetadata> future =
   *       hubServiceClient.updateSpokeOperationCallable().futureCall(request);
   *   // Do something.
   *   Spoke response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateSpokeRequest, Spoke, OperationMetadata>
      updateSpokeOperationCallable() {
    return stub.updateSpokeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   UpdateSpokeRequest request =
   *       UpdateSpokeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSpoke(Spoke.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = hubServiceClient.updateSpokeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSpokeRequest, Operation> updateSpokeCallable() {
    return stub.updateSpokeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rejects a Network Connectivity Center spoke from being attached to a hub. If the spoke was
   * previously in the `ACTIVE` state, it transitions to the `INACTIVE` state and is no longer able
   * to connect to other spokes that are attached to the hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   HubName name = HubName.of("[PROJECT]", "[HUB]");
   *   SpokeName spokeUri = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");
   *   RejectHubSpokeResponse response = hubServiceClient.rejectHubSpokeAsync(name, spokeUri).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the hub from which to reject the spoke.
   * @param spokeUri Required. The URI of the spoke to reject from the hub.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RejectHubSpokeResponse, OperationMetadata> rejectHubSpokeAsync(
      HubName name, SpokeName spokeUri) {
    RejectHubSpokeRequest request =
        RejectHubSpokeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSpokeUri(spokeUri == null ? null : spokeUri.toString())
            .build();
    return rejectHubSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rejects a Network Connectivity Center spoke from being attached to a hub. If the spoke was
   * previously in the `ACTIVE` state, it transitions to the `INACTIVE` state and is no longer able
   * to connect to other spokes that are attached to the hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   HubName name = HubName.of("[PROJECT]", "[HUB]");
   *   String spokeUri = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString();
   *   RejectHubSpokeResponse response = hubServiceClient.rejectHubSpokeAsync(name, spokeUri).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the hub from which to reject the spoke.
   * @param spokeUri Required. The URI of the spoke to reject from the hub.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RejectHubSpokeResponse, OperationMetadata> rejectHubSpokeAsync(
      HubName name, String spokeUri) {
    RejectHubSpokeRequest request =
        RejectHubSpokeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSpokeUri(spokeUri)
            .build();
    return rejectHubSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rejects a Network Connectivity Center spoke from being attached to a hub. If the spoke was
   * previously in the `ACTIVE` state, it transitions to the `INACTIVE` state and is no longer able
   * to connect to other spokes that are attached to the hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String name = HubName.of("[PROJECT]", "[HUB]").toString();
   *   SpokeName spokeUri = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");
   *   RejectHubSpokeResponse response = hubServiceClient.rejectHubSpokeAsync(name, spokeUri).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the hub from which to reject the spoke.
   * @param spokeUri Required. The URI of the spoke to reject from the hub.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RejectHubSpokeResponse, OperationMetadata> rejectHubSpokeAsync(
      String name, SpokeName spokeUri) {
    RejectHubSpokeRequest request =
        RejectHubSpokeRequest.newBuilder()
            .setName(name)
            .setSpokeUri(spokeUri == null ? null : spokeUri.toString())
            .build();
    return rejectHubSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rejects a Network Connectivity Center spoke from being attached to a hub. If the spoke was
   * previously in the `ACTIVE` state, it transitions to the `INACTIVE` state and is no longer able
   * to connect to other spokes that are attached to the hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String name = HubName.of("[PROJECT]", "[HUB]").toString();
   *   String spokeUri = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString();
   *   RejectHubSpokeResponse response = hubServiceClient.rejectHubSpokeAsync(name, spokeUri).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the hub from which to reject the spoke.
   * @param spokeUri Required. The URI of the spoke to reject from the hub.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RejectHubSpokeResponse, OperationMetadata> rejectHubSpokeAsync(
      String name, String spokeUri) {
    RejectHubSpokeRequest request =
        RejectHubSpokeRequest.newBuilder().setName(name).setSpokeUri(spokeUri).build();
    return rejectHubSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rejects a Network Connectivity Center spoke from being attached to a hub. If the spoke was
   * previously in the `ACTIVE` state, it transitions to the `INACTIVE` state and is no longer able
   * to connect to other spokes that are attached to the hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   RejectHubSpokeRequest request =
   *       RejectHubSpokeRequest.newBuilder()
   *           .setName(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .setSpokeUri(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
   *           .setRequestId("requestId693933066")
   *           .setDetails("details1557721666")
   *           .build();
   *   RejectHubSpokeResponse response = hubServiceClient.rejectHubSpokeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RejectHubSpokeResponse, OperationMetadata> rejectHubSpokeAsync(
      RejectHubSpokeRequest request) {
    return rejectHubSpokeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rejects a Network Connectivity Center spoke from being attached to a hub. If the spoke was
   * previously in the `ACTIVE` state, it transitions to the `INACTIVE` state and is no longer able
   * to connect to other spokes that are attached to the hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   RejectHubSpokeRequest request =
   *       RejectHubSpokeRequest.newBuilder()
   *           .setName(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .setSpokeUri(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
   *           .setRequestId("requestId693933066")
   *           .setDetails("details1557721666")
   *           .build();
   *   OperationFuture<RejectHubSpokeResponse, OperationMetadata> future =
   *       hubServiceClient.rejectHubSpokeOperationCallable().futureCall(request);
   *   // Do something.
   *   RejectHubSpokeResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RejectHubSpokeRequest, RejectHubSpokeResponse, OperationMetadata>
      rejectHubSpokeOperationCallable() {
    return stub.rejectHubSpokeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rejects a Network Connectivity Center spoke from being attached to a hub. If the spoke was
   * previously in the `ACTIVE` state, it transitions to the `INACTIVE` state and is no longer able
   * to connect to other spokes that are attached to the hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   RejectHubSpokeRequest request =
   *       RejectHubSpokeRequest.newBuilder()
   *           .setName(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .setSpokeUri(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
   *           .setRequestId("requestId693933066")
   *           .setDetails("details1557721666")
   *           .build();
   *   ApiFuture<Operation> future = hubServiceClient.rejectHubSpokeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RejectHubSpokeRequest, Operation> rejectHubSpokeCallable() {
    return stub.rejectHubSpokeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accepts a proposal to attach a Network Connectivity Center spoke to a hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   HubName name = HubName.of("[PROJECT]", "[HUB]");
   *   SpokeName spokeUri = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");
   *   AcceptHubSpokeResponse response = hubServiceClient.acceptHubSpokeAsync(name, spokeUri).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the hub into which to accept the spoke.
   * @param spokeUri Required. The URI of the spoke to accept into the hub.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AcceptHubSpokeResponse, OperationMetadata> acceptHubSpokeAsync(
      HubName name, SpokeName spokeUri) {
    AcceptHubSpokeRequest request =
        AcceptHubSpokeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSpokeUri(spokeUri == null ? null : spokeUri.toString())
            .build();
    return acceptHubSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accepts a proposal to attach a Network Connectivity Center spoke to a hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   HubName name = HubName.of("[PROJECT]", "[HUB]");
   *   String spokeUri = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString();
   *   AcceptHubSpokeResponse response = hubServiceClient.acceptHubSpokeAsync(name, spokeUri).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the hub into which to accept the spoke.
   * @param spokeUri Required. The URI of the spoke to accept into the hub.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AcceptHubSpokeResponse, OperationMetadata> acceptHubSpokeAsync(
      HubName name, String spokeUri) {
    AcceptHubSpokeRequest request =
        AcceptHubSpokeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSpokeUri(spokeUri)
            .build();
    return acceptHubSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accepts a proposal to attach a Network Connectivity Center spoke to a hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String name = HubName.of("[PROJECT]", "[HUB]").toString();
   *   SpokeName spokeUri = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");
   *   AcceptHubSpokeResponse response = hubServiceClient.acceptHubSpokeAsync(name, spokeUri).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the hub into which to accept the spoke.
   * @param spokeUri Required. The URI of the spoke to accept into the hub.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AcceptHubSpokeResponse, OperationMetadata> acceptHubSpokeAsync(
      String name, SpokeName spokeUri) {
    AcceptHubSpokeRequest request =
        AcceptHubSpokeRequest.newBuilder()
            .setName(name)
            .setSpokeUri(spokeUri == null ? null : spokeUri.toString())
            .build();
    return acceptHubSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accepts a proposal to attach a Network Connectivity Center spoke to a hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String name = HubName.of("[PROJECT]", "[HUB]").toString();
   *   String spokeUri = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString();
   *   AcceptHubSpokeResponse response = hubServiceClient.acceptHubSpokeAsync(name, spokeUri).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the hub into which to accept the spoke.
   * @param spokeUri Required. The URI of the spoke to accept into the hub.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AcceptHubSpokeResponse, OperationMetadata> acceptHubSpokeAsync(
      String name, String spokeUri) {
    AcceptHubSpokeRequest request =
        AcceptHubSpokeRequest.newBuilder().setName(name).setSpokeUri(spokeUri).build();
    return acceptHubSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accepts a proposal to attach a Network Connectivity Center spoke to a hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   AcceptHubSpokeRequest request =
   *       AcceptHubSpokeRequest.newBuilder()
   *           .setName(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .setSpokeUri(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AcceptHubSpokeResponse response = hubServiceClient.acceptHubSpokeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AcceptHubSpokeResponse, OperationMetadata> acceptHubSpokeAsync(
      AcceptHubSpokeRequest request) {
    return acceptHubSpokeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accepts a proposal to attach a Network Connectivity Center spoke to a hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   AcceptHubSpokeRequest request =
   *       AcceptHubSpokeRequest.newBuilder()
   *           .setName(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .setSpokeUri(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<AcceptHubSpokeResponse, OperationMetadata> future =
   *       hubServiceClient.acceptHubSpokeOperationCallable().futureCall(request);
   *   // Do something.
   *   AcceptHubSpokeResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AcceptHubSpokeRequest, AcceptHubSpokeResponse, OperationMetadata>
      acceptHubSpokeOperationCallable() {
    return stub.acceptHubSpokeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accepts a proposal to attach a Network Connectivity Center spoke to a hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   AcceptHubSpokeRequest request =
   *       AcceptHubSpokeRequest.newBuilder()
   *           .setName(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .setSpokeUri(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = hubServiceClient.acceptHubSpokeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AcceptHubSpokeRequest, Operation> acceptHubSpokeCallable() {
    return stub.acceptHubSpokeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   SpokeName name = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]");
   *   hubServiceClient.deleteSpokeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the spoke to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSpokeAsync(SpokeName name) {
    DeleteSpokeRequest request =
        DeleteSpokeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String name = SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString();
   *   hubServiceClient.deleteSpokeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the spoke to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSpokeAsync(String name) {
    DeleteSpokeRequest request = DeleteSpokeRequest.newBuilder().setName(name).build();
    return deleteSpokeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   DeleteSpokeRequest request =
   *       DeleteSpokeRequest.newBuilder()
   *           .setName(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   hubServiceClient.deleteSpokeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSpokeAsync(
      DeleteSpokeRequest request) {
    return deleteSpokeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   DeleteSpokeRequest request =
   *       DeleteSpokeRequest.newBuilder()
   *           .setName(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       hubServiceClient.deleteSpokeOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSpokeRequest, Empty, OperationMetadata>
      deleteSpokeOperationCallable() {
    return stub.deleteSpokeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Network Connectivity Center spoke.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   DeleteSpokeRequest request =
   *       DeleteSpokeRequest.newBuilder()
   *           .setName(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = hubServiceClient.deleteSpokeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSpokeRequest, Operation> deleteSpokeCallable() {
    return stub.deleteSpokeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Network Connectivity Center route table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   RouteTableName name = RouteTableName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]");
   *   RouteTable response = hubServiceClient.getRouteTable(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the route table resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RouteTable getRouteTable(RouteTableName name) {
    GetRouteTableRequest request =
        GetRouteTableRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRouteTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Network Connectivity Center route table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String name = RouteTableName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]").toString();
   *   RouteTable response = hubServiceClient.getRouteTable(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the route table resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RouteTable getRouteTable(String name) {
    GetRouteTableRequest request = GetRouteTableRequest.newBuilder().setName(name).build();
    return getRouteTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Network Connectivity Center route table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   GetRouteTableRequest request =
   *       GetRouteTableRequest.newBuilder()
   *           .setName(RouteTableName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]").toString())
   *           .build();
   *   RouteTable response = hubServiceClient.getRouteTable(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RouteTable getRouteTable(GetRouteTableRequest request) {
    return getRouteTableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Network Connectivity Center route table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   GetRouteTableRequest request =
   *       GetRouteTableRequest.newBuilder()
   *           .setName(RouteTableName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]").toString())
   *           .build();
   *   ApiFuture<RouteTable> future = hubServiceClient.getRouteTableCallable().futureCall(request);
   *   // Do something.
   *   RouteTable response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRouteTableRequest, RouteTable> getRouteTableCallable() {
    return stub.getRouteTableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about the specified route.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   HubRouteName name = HubRouteName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]", "[ROUTE]");
   *   Route response = hubServiceClient.getRoute(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the route resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Route getRoute(HubRouteName name) {
    GetRouteRequest request =
        GetRouteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRoute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about the specified route.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String name = HubRouteName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]", "[ROUTE]").toString();
   *   Route response = hubServiceClient.getRoute(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the route resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Route getRoute(String name) {
    GetRouteRequest request = GetRouteRequest.newBuilder().setName(name).build();
    return getRoute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about the specified route.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   GetRouteRequest request =
   *       GetRouteRequest.newBuilder()
   *           .setName(HubRouteName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]", "[ROUTE]").toString())
   *           .build();
   *   Route response = hubServiceClient.getRoute(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Route getRoute(GetRouteRequest request) {
    return getRouteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about the specified route.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   GetRouteRequest request =
   *       GetRouteRequest.newBuilder()
   *           .setName(HubRouteName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]", "[ROUTE]").toString())
   *           .build();
   *   ApiFuture<Route> future = hubServiceClient.getRouteCallable().futureCall(request);
   *   // Do something.
   *   Route response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRouteRequest, Route> getRouteCallable() {
    return stub.getRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists routes in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   RouteTableName parent = RouteTableName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]");
   *   for (Route element : hubServiceClient.listRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRoutesPagedResponse listRoutes(RouteTableName parent) {
    ListRoutesRequest request =
        ListRoutesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists routes in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String parent = RouteTableName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]").toString();
   *   for (Route element : hubServiceClient.listRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRoutesPagedResponse listRoutes(String parent) {
    ListRoutesRequest request = ListRoutesRequest.newBuilder().setParent(parent).build();
    return listRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists routes in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListRoutesRequest request =
   *       ListRoutesRequest.newBuilder()
   *           .setParent(RouteTableName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Route element : hubServiceClient.listRoutes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRoutesPagedResponse listRoutes(ListRoutesRequest request) {
    return listRoutesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists routes in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListRoutesRequest request =
   *       ListRoutesRequest.newBuilder()
   *           .setParent(RouteTableName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Route> future = hubServiceClient.listRoutesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Route element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRoutesRequest, ListRoutesPagedResponse> listRoutesPagedCallable() {
    return stub.listRoutesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists routes in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListRoutesRequest request =
   *       ListRoutesRequest.newBuilder()
   *           .setParent(RouteTableName.of("[PROJECT]", "[HUB]", "[ROUTE_TABLE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRoutesResponse response = hubServiceClient.listRoutesCallable().call(request);
   *     for (Route element : response.getRoutesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRoutesRequest, ListRoutesResponse> listRoutesCallable() {
    return stub.listRoutesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists route tables in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   HubName parent = HubName.of("[PROJECT]", "[HUB]");
   *   for (RouteTable element : hubServiceClient.listRouteTables(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRouteTablesPagedResponse listRouteTables(HubName parent) {
    ListRouteTablesRequest request =
        ListRouteTablesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRouteTables(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists route tables in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String parent = HubName.of("[PROJECT]", "[HUB]").toString();
   *   for (RouteTable element : hubServiceClient.listRouteTables(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRouteTablesPagedResponse listRouteTables(String parent) {
    ListRouteTablesRequest request = ListRouteTablesRequest.newBuilder().setParent(parent).build();
    return listRouteTables(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists route tables in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListRouteTablesRequest request =
   *       ListRouteTablesRequest.newBuilder()
   *           .setParent(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (RouteTable element : hubServiceClient.listRouteTables(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRouteTablesPagedResponse listRouteTables(ListRouteTablesRequest request) {
    return listRouteTablesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists route tables in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListRouteTablesRequest request =
   *       ListRouteTablesRequest.newBuilder()
   *           .setParent(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<RouteTable> future =
   *       hubServiceClient.listRouteTablesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RouteTable element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRouteTablesRequest, ListRouteTablesPagedResponse>
      listRouteTablesPagedCallable() {
    return stub.listRouteTablesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists route tables in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListRouteTablesRequest request =
   *       ListRouteTablesRequest.newBuilder()
   *           .setParent(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRouteTablesResponse response = hubServiceClient.listRouteTablesCallable().call(request);
   *     for (RouteTable element : response.getRouteTablesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRouteTablesRequest, ListRouteTablesResponse>
      listRouteTablesCallable() {
    return stub.listRouteTablesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Network Connectivity Center group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   GroupName name = GroupName.of("[PROJECT]", "[HUB]", "[GROUP]");
   *   Group response = hubServiceClient.getGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the route table resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group getGroup(GroupName name) {
    GetGroupRequest request =
        GetGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Network Connectivity Center group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String name = GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString();
   *   Group response = hubServiceClient.getGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the route table resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group getGroup(String name) {
    GetGroupRequest request = GetGroupRequest.newBuilder().setName(name).build();
    return getGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Network Connectivity Center group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   GetGroupRequest request =
   *       GetGroupRequest.newBuilder()
   *           .setName(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .build();
   *   Group response = hubServiceClient.getGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group getGroup(GetGroupRequest request) {
    return getGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a Network Connectivity Center group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   GetGroupRequest request =
   *       GetGroupRequest.newBuilder()
   *           .setName(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .build();
   *   ApiFuture<Group> future = hubServiceClient.getGroupCallable().futureCall(request);
   *   // Do something.
   *   Group response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGroupRequest, Group> getGroupCallable() {
    return stub.getGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists groups in a given hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   HubName parent = HubName.of("[PROJECT]", "[HUB]");
   *   for (Group element : hubServiceClient.listGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(HubName parent) {
    ListGroupsRequest request =
        ListGroupsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists groups in a given hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   String parent = HubName.of("[PROJECT]", "[HUB]").toString();
   *   for (Group element : hubServiceClient.listGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(String parent) {
    ListGroupsRequest request = ListGroupsRequest.newBuilder().setParent(parent).build();
    return listGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists groups in a given hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListGroupsRequest request =
   *       ListGroupsRequest.newBuilder()
   *           .setParent(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Group element : hubServiceClient.listGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(ListGroupsRequest request) {
    return listGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists groups in a given hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListGroupsRequest request =
   *       ListGroupsRequest.newBuilder()
   *           .setParent(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Group> future = hubServiceClient.listGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Group element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable() {
    return stub.listGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists groups in a given hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListGroupsRequest request =
   *       ListGroupsRequest.newBuilder()
   *           .setParent(HubName.of("[PROJECT]", "[HUB]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListGroupsResponse response = hubServiceClient.listGroupsCallable().call(request);
   *     for (Group element : response.getGroupsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable() {
    return stub.listGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : hubServiceClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       hubServiceClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = hubServiceClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = hubServiceClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = hubServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = hubServiceClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = hubServiceClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = hubServiceClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = hubServiceClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = hubServiceClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       hubServiceClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListHubsPagedResponse
      extends AbstractPagedListResponse<
          ListHubsRequest, ListHubsResponse, Hub, ListHubsPage, ListHubsFixedSizeCollection> {

    public static ApiFuture<ListHubsPagedResponse> createAsync(
        PageContext<ListHubsRequest, ListHubsResponse, Hub> context,
        ApiFuture<ListHubsResponse> futureResponse) {
      ApiFuture<ListHubsPage> futurePage =
          ListHubsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListHubsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListHubsPagedResponse(ListHubsPage page) {
      super(page, ListHubsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHubsPage
      extends AbstractPage<ListHubsRequest, ListHubsResponse, Hub, ListHubsPage> {

    private ListHubsPage(
        PageContext<ListHubsRequest, ListHubsResponse, Hub> context, ListHubsResponse response) {
      super(context, response);
    }

    private static ListHubsPage createEmptyPage() {
      return new ListHubsPage(null, null);
    }

    @Override
    protected ListHubsPage createPage(
        PageContext<ListHubsRequest, ListHubsResponse, Hub> context, ListHubsResponse response) {
      return new ListHubsPage(context, response);
    }

    @Override
    public ApiFuture<ListHubsPage> createPageAsync(
        PageContext<ListHubsRequest, ListHubsResponse, Hub> context,
        ApiFuture<ListHubsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHubsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHubsRequest, ListHubsResponse, Hub, ListHubsPage, ListHubsFixedSizeCollection> {

    private ListHubsFixedSizeCollection(List<ListHubsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHubsFixedSizeCollection createEmptyCollection() {
      return new ListHubsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHubsFixedSizeCollection createCollection(
        List<ListHubsPage> pages, int collectionSize) {
      return new ListHubsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListHubSpokesPagedResponse
      extends AbstractPagedListResponse<
          ListHubSpokesRequest,
          ListHubSpokesResponse,
          Spoke,
          ListHubSpokesPage,
          ListHubSpokesFixedSizeCollection> {

    public static ApiFuture<ListHubSpokesPagedResponse> createAsync(
        PageContext<ListHubSpokesRequest, ListHubSpokesResponse, Spoke> context,
        ApiFuture<ListHubSpokesResponse> futureResponse) {
      ApiFuture<ListHubSpokesPage> futurePage =
          ListHubSpokesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListHubSpokesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListHubSpokesPagedResponse(ListHubSpokesPage page) {
      super(page, ListHubSpokesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHubSpokesPage
      extends AbstractPage<ListHubSpokesRequest, ListHubSpokesResponse, Spoke, ListHubSpokesPage> {

    private ListHubSpokesPage(
        PageContext<ListHubSpokesRequest, ListHubSpokesResponse, Spoke> context,
        ListHubSpokesResponse response) {
      super(context, response);
    }

    private static ListHubSpokesPage createEmptyPage() {
      return new ListHubSpokesPage(null, null);
    }

    @Override
    protected ListHubSpokesPage createPage(
        PageContext<ListHubSpokesRequest, ListHubSpokesResponse, Spoke> context,
        ListHubSpokesResponse response) {
      return new ListHubSpokesPage(context, response);
    }

    @Override
    public ApiFuture<ListHubSpokesPage> createPageAsync(
        PageContext<ListHubSpokesRequest, ListHubSpokesResponse, Spoke> context,
        ApiFuture<ListHubSpokesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHubSpokesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHubSpokesRequest,
          ListHubSpokesResponse,
          Spoke,
          ListHubSpokesPage,
          ListHubSpokesFixedSizeCollection> {

    private ListHubSpokesFixedSizeCollection(List<ListHubSpokesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHubSpokesFixedSizeCollection createEmptyCollection() {
      return new ListHubSpokesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHubSpokesFixedSizeCollection createCollection(
        List<ListHubSpokesPage> pages, int collectionSize) {
      return new ListHubSpokesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSpokesPagedResponse
      extends AbstractPagedListResponse<
          ListSpokesRequest,
          ListSpokesResponse,
          Spoke,
          ListSpokesPage,
          ListSpokesFixedSizeCollection> {

    public static ApiFuture<ListSpokesPagedResponse> createAsync(
        PageContext<ListSpokesRequest, ListSpokesResponse, Spoke> context,
        ApiFuture<ListSpokesResponse> futureResponse) {
      ApiFuture<ListSpokesPage> futurePage =
          ListSpokesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSpokesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSpokesPagedResponse(ListSpokesPage page) {
      super(page, ListSpokesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSpokesPage
      extends AbstractPage<ListSpokesRequest, ListSpokesResponse, Spoke, ListSpokesPage> {

    private ListSpokesPage(
        PageContext<ListSpokesRequest, ListSpokesResponse, Spoke> context,
        ListSpokesResponse response) {
      super(context, response);
    }

    private static ListSpokesPage createEmptyPage() {
      return new ListSpokesPage(null, null);
    }

    @Override
    protected ListSpokesPage createPage(
        PageContext<ListSpokesRequest, ListSpokesResponse, Spoke> context,
        ListSpokesResponse response) {
      return new ListSpokesPage(context, response);
    }

    @Override
    public ApiFuture<ListSpokesPage> createPageAsync(
        PageContext<ListSpokesRequest, ListSpokesResponse, Spoke> context,
        ApiFuture<ListSpokesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSpokesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSpokesRequest,
          ListSpokesResponse,
          Spoke,
          ListSpokesPage,
          ListSpokesFixedSizeCollection> {

    private ListSpokesFixedSizeCollection(List<ListSpokesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSpokesFixedSizeCollection createEmptyCollection() {
      return new ListSpokesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSpokesFixedSizeCollection createCollection(
        List<ListSpokesPage> pages, int collectionSize) {
      return new ListSpokesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRoutesPagedResponse
      extends AbstractPagedListResponse<
          ListRoutesRequest,
          ListRoutesResponse,
          Route,
          ListRoutesPage,
          ListRoutesFixedSizeCollection> {

    public static ApiFuture<ListRoutesPagedResponse> createAsync(
        PageContext<ListRoutesRequest, ListRoutesResponse, Route> context,
        ApiFuture<ListRoutesResponse> futureResponse) {
      ApiFuture<ListRoutesPage> futurePage =
          ListRoutesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListRoutesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListRoutesPagedResponse(ListRoutesPage page) {
      super(page, ListRoutesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRoutesPage
      extends AbstractPage<ListRoutesRequest, ListRoutesResponse, Route, ListRoutesPage> {

    private ListRoutesPage(
        PageContext<ListRoutesRequest, ListRoutesResponse, Route> context,
        ListRoutesResponse response) {
      super(context, response);
    }

    private static ListRoutesPage createEmptyPage() {
      return new ListRoutesPage(null, null);
    }

    @Override
    protected ListRoutesPage createPage(
        PageContext<ListRoutesRequest, ListRoutesResponse, Route> context,
        ListRoutesResponse response) {
      return new ListRoutesPage(context, response);
    }

    @Override
    public ApiFuture<ListRoutesPage> createPageAsync(
        PageContext<ListRoutesRequest, ListRoutesResponse, Route> context,
        ApiFuture<ListRoutesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRoutesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRoutesRequest,
          ListRoutesResponse,
          Route,
          ListRoutesPage,
          ListRoutesFixedSizeCollection> {

    private ListRoutesFixedSizeCollection(List<ListRoutesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRoutesFixedSizeCollection createEmptyCollection() {
      return new ListRoutesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRoutesFixedSizeCollection createCollection(
        List<ListRoutesPage> pages, int collectionSize) {
      return new ListRoutesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRouteTablesPagedResponse
      extends AbstractPagedListResponse<
          ListRouteTablesRequest,
          ListRouteTablesResponse,
          RouteTable,
          ListRouteTablesPage,
          ListRouteTablesFixedSizeCollection> {

    public static ApiFuture<ListRouteTablesPagedResponse> createAsync(
        PageContext<ListRouteTablesRequest, ListRouteTablesResponse, RouteTable> context,
        ApiFuture<ListRouteTablesResponse> futureResponse) {
      ApiFuture<ListRouteTablesPage> futurePage =
          ListRouteTablesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRouteTablesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRouteTablesPagedResponse(ListRouteTablesPage page) {
      super(page, ListRouteTablesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRouteTablesPage
      extends AbstractPage<
          ListRouteTablesRequest, ListRouteTablesResponse, RouteTable, ListRouteTablesPage> {

    private ListRouteTablesPage(
        PageContext<ListRouteTablesRequest, ListRouteTablesResponse, RouteTable> context,
        ListRouteTablesResponse response) {
      super(context, response);
    }

    private static ListRouteTablesPage createEmptyPage() {
      return new ListRouteTablesPage(null, null);
    }

    @Override
    protected ListRouteTablesPage createPage(
        PageContext<ListRouteTablesRequest, ListRouteTablesResponse, RouteTable> context,
        ListRouteTablesResponse response) {
      return new ListRouteTablesPage(context, response);
    }

    @Override
    public ApiFuture<ListRouteTablesPage> createPageAsync(
        PageContext<ListRouteTablesRequest, ListRouteTablesResponse, RouteTable> context,
        ApiFuture<ListRouteTablesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRouteTablesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRouteTablesRequest,
          ListRouteTablesResponse,
          RouteTable,
          ListRouteTablesPage,
          ListRouteTablesFixedSizeCollection> {

    private ListRouteTablesFixedSizeCollection(
        List<ListRouteTablesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRouteTablesFixedSizeCollection createEmptyCollection() {
      return new ListRouteTablesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRouteTablesFixedSizeCollection createCollection(
        List<ListRouteTablesPage> pages, int collectionSize) {
      return new ListRouteTablesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListGroupsRequest,
          ListGroupsResponse,
          Group,
          ListGroupsPage,
          ListGroupsFixedSizeCollection> {

    public static ApiFuture<ListGroupsPagedResponse> createAsync(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ApiFuture<ListGroupsResponse> futureResponse) {
      ApiFuture<ListGroupsPage> futurePage =
          ListGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListGroupsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListGroupsPagedResponse(ListGroupsPage page) {
      super(page, ListGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGroupsPage
      extends AbstractPage<ListGroupsRequest, ListGroupsResponse, Group, ListGroupsPage> {

    private ListGroupsPage(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ListGroupsResponse response) {
      super(context, response);
    }

    private static ListGroupsPage createEmptyPage() {
      return new ListGroupsPage(null, null);
    }

    @Override
    protected ListGroupsPage createPage(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ListGroupsResponse response) {
      return new ListGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListGroupsPage> createPageAsync(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ApiFuture<ListGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGroupsRequest,
          ListGroupsResponse,
          Group,
          ListGroupsPage,
          ListGroupsFixedSizeCollection> {

    private ListGroupsFixedSizeCollection(List<ListGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGroupsFixedSizeCollection createEmptyCollection() {
      return new ListGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGroupsFixedSizeCollection createCollection(
        List<ListGroupsPage> pages, int collectionSize) {
      return new ListGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
