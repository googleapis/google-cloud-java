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

package com.google.cloud.gkehub.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkehub.v1.stub.GkeHubStub;
import com.google.cloud.gkehub.v1.stub.GkeHubStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The GKE Hub service handles the registration of many Kubernetes clusters to
 * Google Cloud, and the management of multi-cluster features over those clusters.
 *
 * <p>The GKE Hub service operates on the following resources:
 *
 * <ul>
 *   <li>[Membership][google.cloud.gkehub.v1.Membership]
 *   <li>[Feature][google.cloud.gkehub.v1.Feature]
 * </ul>
 *
 * <p>GKE Hub is currently available in the global region and all regions in
 * https://cloud.google.com/compute/docs/regions-zones. Feature is only available in global region
 * while membership is global region and all the regions.
 *
 * <p>&#42;&#42;Membership management may be non-trivial:&#42;&#42; it is recommended to use one of
 * the Google-provided client libraries or tools where possible when working with Membership
 * resources.
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
 * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
 *   MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
 *   Membership response = gkeHubClient.getMembership(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GkeHubClient object to clean up resources such as
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
 *      <td><p> ListMemberships</td>
 *      <td><p> Lists Memberships in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMemberships(ListMembershipsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMemberships(LocationName parent)
 *           <li><p> listMemberships(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMembershipsPagedCallable()
 *           <li><p> listMembershipsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBoundMemberships</td>
 *      <td><p> Lists Memberships bound to a Scope. The response includes relevant Memberships from all regions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBoundMemberships(ListBoundMembershipsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBoundMemberships(ScopeName scopeName)
 *           <li><p> listBoundMemberships(String scopeName)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBoundMembershipsPagedCallable()
 *           <li><p> listBoundMembershipsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFeatures</td>
 *      <td><p> Lists Features in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFeatures(ListFeaturesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFeatures(LocationName parent)
 *           <li><p> listFeatures(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFeaturesPagedCallable()
 *           <li><p> listFeaturesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMembership</td>
 *      <td><p> Gets the details of a Membership.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMembership(GetMembershipRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMembership(MembershipName name)
 *           <li><p> getMembership(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMembershipCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetFeature</td>
 *      <td><p> Gets details of a single Feature.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFeature(GetFeatureRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFeature(FeatureName name)
 *           <li><p> getFeature(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFeatureCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateMembership</td>
 *      <td><p> Creates a new Membership.
 * <p>  &#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To register other clusters, follow the instructions at https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMembershipAsync(CreateMembershipRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createMembershipAsync(LocationName parent, Membership resource, String membershipId)
 *           <li><p> createMembershipAsync(String parent, Membership resource, String membershipId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMembershipOperationCallable()
 *           <li><p> createMembershipCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateFeature</td>
 *      <td><p> Adds a new Feature.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createFeatureAsync(CreateFeatureRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createFeatureAsync(LocationName parent, Feature resource, String featureId)
 *           <li><p> createFeatureAsync(String parent, Feature resource, String featureId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createFeatureOperationCallable()
 *           <li><p> createFeatureCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMembership</td>
 *      <td><p> Removes a Membership.
 * <p>  &#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To unregister other clusters, follow the instructions at https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMembershipAsync(DeleteMembershipRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteMembershipAsync(MembershipName name)
 *           <li><p> deleteMembershipAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMembershipOperationCallable()
 *           <li><p> deleteMembershipCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteFeature</td>
 *      <td><p> Removes a Feature.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteFeatureAsync(DeleteFeatureRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteFeatureAsync(FeatureName name)
 *           <li><p> deleteFeatureAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteFeatureOperationCallable()
 *           <li><p> deleteFeatureCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMembership</td>
 *      <td><p> Updates an existing Membership.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMembershipAsync(UpdateMembershipRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateMembershipAsync(MembershipName name, Membership resource, FieldMask updateMask)
 *           <li><p> updateMembershipAsync(String name, Membership resource, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMembershipOperationCallable()
 *           <li><p> updateMembershipCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateFeature</td>
 *      <td><p> Updates an existing Feature.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateFeatureAsync(UpdateFeatureRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateFeatureAsync(FeatureName name, Feature resource, FieldMask updateMask)
 *           <li><p> updateFeatureAsync(String name, Feature resource, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateFeatureOperationCallable()
 *           <li><p> updateFeatureCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateConnectManifest</td>
 *      <td><p> Generates the manifest for deployment of the GKE connect agent.
 * <p>  &#42;&#42;This method is used internally by Google-provided libraries.&#42;&#42; Most clients should not need to call this method directly.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateConnectManifest(GenerateConnectManifestRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateConnectManifestCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateFleet</td>
 *      <td><p> Creates a fleet.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createFleetAsync(CreateFleetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createFleetAsync(LocationName parent, Fleet fleet)
 *           <li><p> createFleetAsync(String parent, Fleet fleet)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createFleetOperationCallable()
 *           <li><p> createFleetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetFleet</td>
 *      <td><p> Returns the details of a fleet.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFleet(GetFleetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFleet(FleetName name)
 *           <li><p> getFleet(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFleetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateFleet</td>
 *      <td><p> Updates a fleet.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateFleetAsync(UpdateFleetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateFleetAsync(Fleet fleet, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateFleetOperationCallable()
 *           <li><p> updateFleetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteFleet</td>
 *      <td><p> Removes a Fleet. There must be no memberships remaining in the Fleet.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteFleetAsync(DeleteFleetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteFleetAsync(FleetName name)
 *           <li><p> deleteFleetAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteFleetOperationCallable()
 *           <li><p> deleteFleetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFleets</td>
 *      <td><p> Returns all fleets within an organization or a project that the caller has access to.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFleets(ListFleetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFleets(LocationName parent)
 *           <li><p> listFleets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFleetsPagedCallable()
 *           <li><p> listFleetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetScopeNamespace</td>
 *      <td><p> Returns the details of a fleet namespace.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getScopeNamespace(GetScopeNamespaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getScopeNamespace(NamespaceName name)
 *           <li><p> getScopeNamespace(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getScopeNamespaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateScopeNamespace</td>
 *      <td><p> Creates a fleet namespace.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createScopeNamespaceAsync(CreateScopeNamespaceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createScopeNamespaceAsync(ScopeName parent, Namespace scopeNamespace, String scopeNamespaceId)
 *           <li><p> createScopeNamespaceAsync(String parent, Namespace scopeNamespace, String scopeNamespaceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createScopeNamespaceOperationCallable()
 *           <li><p> createScopeNamespaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateScopeNamespace</td>
 *      <td><p> Updates a fleet namespace.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateScopeNamespaceAsync(UpdateScopeNamespaceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateScopeNamespaceAsync(Namespace scopeNamespace, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateScopeNamespaceOperationCallable()
 *           <li><p> updateScopeNamespaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteScopeNamespace</td>
 *      <td><p> Deletes a fleet namespace.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteScopeNamespaceAsync(DeleteScopeNamespaceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteScopeNamespaceAsync(NamespaceName name)
 *           <li><p> deleteScopeNamespaceAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteScopeNamespaceOperationCallable()
 *           <li><p> deleteScopeNamespaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListScopeNamespaces</td>
 *      <td><p> Lists fleet namespaces.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listScopeNamespaces(ListScopeNamespacesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listScopeNamespaces(ScopeName parent)
 *           <li><p> listScopeNamespaces(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listScopeNamespacesPagedCallable()
 *           <li><p> listScopeNamespacesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetScopeRBACRoleBinding</td>
 *      <td><p> Returns the details of a Scope RBACRoleBinding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getScopeRBACRoleBinding(GetScopeRBACRoleBindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getScopeRBACRoleBinding(RBACRoleBindingName name)
 *           <li><p> getScopeRBACRoleBinding(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getScopeRBACRoleBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateScopeRBACRoleBinding</td>
 *      <td><p> Creates a Scope RBACRoleBinding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createScopeRBACRoleBindingAsync(CreateScopeRBACRoleBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createScopeRBACRoleBindingAsync(MembershipName parent, RBACRoleBinding rbacrolebinding, String rbacrolebindingId)
 *           <li><p> createScopeRBACRoleBindingAsync(ScopeName parent, RBACRoleBinding rbacrolebinding, String rbacrolebindingId)
 *           <li><p> createScopeRBACRoleBindingAsync(String parent, RBACRoleBinding rbacrolebinding, String rbacrolebindingId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createScopeRBACRoleBindingOperationCallable()
 *           <li><p> createScopeRBACRoleBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateScopeRBACRoleBinding</td>
 *      <td><p> Updates a Scope RBACRoleBinding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateScopeRBACRoleBindingAsync(UpdateScopeRBACRoleBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateScopeRBACRoleBindingAsync(RBACRoleBinding rbacrolebinding, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateScopeRBACRoleBindingOperationCallable()
 *           <li><p> updateScopeRBACRoleBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteScopeRBACRoleBinding</td>
 *      <td><p> Deletes a Scope RBACRoleBinding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteScopeRBACRoleBindingAsync(DeleteScopeRBACRoleBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteScopeRBACRoleBindingAsync(RBACRoleBindingName name)
 *           <li><p> deleteScopeRBACRoleBindingAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteScopeRBACRoleBindingOperationCallable()
 *           <li><p> deleteScopeRBACRoleBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListScopeRBACRoleBindings</td>
 *      <td><p> Lists all Scope RBACRoleBindings.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listScopeRBACRoleBindings(ListScopeRBACRoleBindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listScopeRBACRoleBindings(MembershipName parent)
 *           <li><p> listScopeRBACRoleBindings(ScopeName parent)
 *           <li><p> listScopeRBACRoleBindings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listScopeRBACRoleBindingsPagedCallable()
 *           <li><p> listScopeRBACRoleBindingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetScope</td>
 *      <td><p> Returns the details of a Scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getScope(GetScopeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getScope(ScopeName name)
 *           <li><p> getScope(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateScope</td>
 *      <td><p> Creates a Scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createScopeAsync(CreateScopeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createScopeAsync(LocationName parent, Scope scope, String scopeId)
 *           <li><p> createScopeAsync(String parent, Scope scope, String scopeId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createScopeOperationCallable()
 *           <li><p> createScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateScope</td>
 *      <td><p> Updates a scopes.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateScopeAsync(UpdateScopeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateScopeAsync(Scope scope, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateScopeOperationCallable()
 *           <li><p> updateScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteScope</td>
 *      <td><p> Deletes a Scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteScopeAsync(DeleteScopeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteScopeAsync(ScopeName name)
 *           <li><p> deleteScopeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteScopeOperationCallable()
 *           <li><p> deleteScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListScopes</td>
 *      <td><p> Lists Scopes.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listScopes(ListScopesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listScopes(LocationName parent)
 *           <li><p> listScopes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listScopesPagedCallable()
 *           <li><p> listScopesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPermittedScopes</td>
 *      <td><p> Lists permitted Scopes.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPermittedScopes(ListPermittedScopesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPermittedScopes(LocationName parent)
 *           <li><p> listPermittedScopes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPermittedScopesPagedCallable()
 *           <li><p> listPermittedScopesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMembershipBinding</td>
 *      <td><p> Returns the details of a MembershipBinding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMembershipBinding(GetMembershipBindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMembershipBinding(MembershipBindingName name)
 *           <li><p> getMembershipBinding(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMembershipBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateMembershipBinding</td>
 *      <td><p> Creates a MembershipBinding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMembershipBindingAsync(CreateMembershipBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createMembershipBindingAsync(MembershipName parent, MembershipBinding membershipBinding, String membershipBindingId)
 *           <li><p> createMembershipBindingAsync(String parent, MembershipBinding membershipBinding, String membershipBindingId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMembershipBindingOperationCallable()
 *           <li><p> createMembershipBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMembershipBinding</td>
 *      <td><p> Updates a MembershipBinding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMembershipBindingAsync(UpdateMembershipBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateMembershipBindingAsync(MembershipBinding membershipBinding, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMembershipBindingOperationCallable()
 *           <li><p> updateMembershipBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMembershipBinding</td>
 *      <td><p> Deletes a MembershipBinding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMembershipBindingAsync(DeleteMembershipBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteMembershipBindingAsync(MembershipBindingName name)
 *           <li><p> deleteMembershipBindingAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMembershipBindingOperationCallable()
 *           <li><p> deleteMembershipBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMembershipBindings</td>
 *      <td><p> Lists MembershipBindings.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMembershipBindings(ListMembershipBindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMembershipBindings(MembershipName parent)
 *           <li><p> listMembershipBindings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMembershipBindingsPagedCallable()
 *           <li><p> listMembershipBindingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMembershipRBACRoleBinding</td>
 *      <td><p> Returns the details of a Membership RBACRoleBinding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMembershipRBACRoleBinding(GetMembershipRBACRoleBindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMembershipRBACRoleBinding(RBACRoleBindingName name)
 *           <li><p> getMembershipRBACRoleBinding(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMembershipRBACRoleBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateMembershipRBACRoleBinding</td>
 *      <td><p> Creates a Membership RBACRoleBinding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMembershipRBACRoleBindingAsync(CreateMembershipRBACRoleBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createMembershipRBACRoleBindingAsync(MembershipName parent, RBACRoleBinding rbacrolebinding, String rbacrolebindingId)
 *           <li><p> createMembershipRBACRoleBindingAsync(ScopeName parent, RBACRoleBinding rbacrolebinding, String rbacrolebindingId)
 *           <li><p> createMembershipRBACRoleBindingAsync(String parent, RBACRoleBinding rbacrolebinding, String rbacrolebindingId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMembershipRBACRoleBindingOperationCallable()
 *           <li><p> createMembershipRBACRoleBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMembershipRBACRoleBinding</td>
 *      <td><p> Updates a Membership RBACRoleBinding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMembershipRBACRoleBindingAsync(UpdateMembershipRBACRoleBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateMembershipRBACRoleBindingAsync(RBACRoleBinding rbacrolebinding, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMembershipRBACRoleBindingOperationCallable()
 *           <li><p> updateMembershipRBACRoleBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMembershipRBACRoleBinding</td>
 *      <td><p> Deletes a Membership RBACRoleBinding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMembershipRBACRoleBindingAsync(DeleteMembershipRBACRoleBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteMembershipRBACRoleBindingAsync(RBACRoleBindingName name)
 *           <li><p> deleteMembershipRBACRoleBindingAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMembershipRBACRoleBindingOperationCallable()
 *           <li><p> deleteMembershipRBACRoleBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMembershipRBACRoleBindings</td>
 *      <td><p> Lists all Membership RBACRoleBindings.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMembershipRBACRoleBindings(ListMembershipRBACRoleBindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMembershipRBACRoleBindings(MembershipName parent)
 *           <li><p> listMembershipRBACRoleBindings(ScopeName parent)
 *           <li><p> listMembershipRBACRoleBindings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMembershipRBACRoleBindingsPagedCallable()
 *           <li><p> listMembershipRBACRoleBindingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateMembershipRBACRoleBindingYAML</td>
 *      <td><p> Generates a YAML of the  RBAC policies for the specified RoleBinding and its associated impersonation resources.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateMembershipRBACRoleBindingYAML(GenerateMembershipRBACRoleBindingYAMLRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateMembershipRBACRoleBindingYAMLCallable()
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
 * <p>This class can be customized by passing in a custom instance of GkeHubSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GkeHubSettings gkeHubSettings =
 *     GkeHubSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GkeHubClient gkeHubClient = GkeHubClient.create(gkeHubSettings);
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
 * GkeHubSettings gkeHubSettings = GkeHubSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GkeHubClient gkeHubClient = GkeHubClient.create(gkeHubSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GkeHubSettings gkeHubSettings = GkeHubSettings.newHttpJsonBuilder().build();
 * GkeHubClient gkeHubClient = GkeHubClient.create(gkeHubSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class GkeHubClient implements BackgroundResource {
  private final GkeHubSettings settings;
  private final GkeHubStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of GkeHubClient with default settings. */
  public static final GkeHubClient create() throws IOException {
    return create(GkeHubSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GkeHubClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GkeHubClient create(GkeHubSettings settings) throws IOException {
    return new GkeHubClient(settings);
  }

  /**
   * Constructs an instance of GkeHubClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(GkeHubSettings).
   */
  public static final GkeHubClient create(GkeHubStub stub) {
    return new GkeHubClient(stub);
  }

  /**
   * Constructs an instance of GkeHubClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GkeHubClient(GkeHubSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GkeHubStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected GkeHubClient(GkeHubStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final GkeHubSettings getSettings() {
    return settings;
  }

  public GkeHubStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Memberships in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Membership element : gkeHubClient.listMemberships(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Memberships will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;`. `projects/&#42;/locations/-` list
   *     memberships in all the regions.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembershipsPagedResponse listMemberships(LocationName parent) {
    ListMembershipsRequest request =
        ListMembershipsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMemberships(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Memberships in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Membership element : gkeHubClient.listMemberships(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Memberships will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;`. `projects/&#42;/locations/-` list
   *     memberships in all the regions.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembershipsPagedResponse listMemberships(String parent) {
    ListMembershipsRequest request = ListMembershipsRequest.newBuilder().setParent(parent).build();
    return listMemberships(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Memberships in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListMembershipsRequest request =
   *       ListMembershipsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Membership element : gkeHubClient.listMemberships(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembershipsPagedResponse listMemberships(ListMembershipsRequest request) {
    return listMembershipsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Memberships in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListMembershipsRequest request =
   *       ListMembershipsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Membership> future =
   *       gkeHubClient.listMembershipsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Membership element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable() {
    return stub.listMembershipsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Memberships in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListMembershipsRequest request =
   *       ListMembershipsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListMembershipsResponse response = gkeHubClient.listMembershipsCallable().call(request);
   *     for (Membership element : response.getResourcesList()) {
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
  public final UnaryCallable<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsCallable() {
    return stub.listMembershipsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Memberships bound to a Scope. The response includes relevant Memberships from all
   * regions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ScopeName scopeName = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
   *   for (Membership element : gkeHubClient.listBoundMemberships(scopeName).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param scopeName Required. Name of the Scope, in the format
   *     `projects/&#42;/locations/global/scopes/&#42;`, to which the Memberships are bound.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBoundMembershipsPagedResponse listBoundMemberships(ScopeName scopeName) {
    ListBoundMembershipsRequest request =
        ListBoundMembershipsRequest.newBuilder()
            .setScopeName(scopeName == null ? null : scopeName.toString())
            .build();
    return listBoundMemberships(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Memberships bound to a Scope. The response includes relevant Memberships from all
   * regions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String scopeName = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString();
   *   for (Membership element : gkeHubClient.listBoundMemberships(scopeName).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param scopeName Required. Name of the Scope, in the format
   *     `projects/&#42;/locations/global/scopes/&#42;`, to which the Memberships are bound.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBoundMembershipsPagedResponse listBoundMemberships(String scopeName) {
    ListBoundMembershipsRequest request =
        ListBoundMembershipsRequest.newBuilder().setScopeName(scopeName).build();
    return listBoundMemberships(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Memberships bound to a Scope. The response includes relevant Memberships from all
   * regions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListBoundMembershipsRequest request =
   *       ListBoundMembershipsRequest.newBuilder()
   *           .setScopeName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Membership element : gkeHubClient.listBoundMemberships(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBoundMembershipsPagedResponse listBoundMemberships(
      ListBoundMembershipsRequest request) {
    return listBoundMembershipsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Memberships bound to a Scope. The response includes relevant Memberships from all
   * regions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListBoundMembershipsRequest request =
   *       ListBoundMembershipsRequest.newBuilder()
   *           .setScopeName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Membership> future =
   *       gkeHubClient.listBoundMembershipsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Membership element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBoundMembershipsRequest, ListBoundMembershipsPagedResponse>
      listBoundMembershipsPagedCallable() {
    return stub.listBoundMembershipsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Memberships bound to a Scope. The response includes relevant Memberships from all
   * regions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListBoundMembershipsRequest request =
   *       ListBoundMembershipsRequest.newBuilder()
   *           .setScopeName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBoundMembershipsResponse response =
   *         gkeHubClient.listBoundMembershipsCallable().call(request);
   *     for (Membership element : response.getMembershipsList()) {
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
  public final UnaryCallable<ListBoundMembershipsRequest, ListBoundMembershipsResponse>
      listBoundMembershipsCallable() {
    return stub.listBoundMembershipsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Features in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Feature element : gkeHubClient.listFeatures(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Features will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeaturesPagedResponse listFeatures(LocationName parent) {
    ListFeaturesRequest request =
        ListFeaturesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFeatures(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Features in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Feature element : gkeHubClient.listFeatures(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Features will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeaturesPagedResponse listFeatures(String parent) {
    ListFeaturesRequest request = ListFeaturesRequest.newBuilder().setParent(parent).build();
    return listFeatures(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Features in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListFeaturesRequest request =
   *       ListFeaturesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Feature element : gkeHubClient.listFeatures(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeaturesPagedResponse listFeatures(ListFeaturesRequest request) {
    return listFeaturesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Features in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListFeaturesRequest request =
   *       ListFeaturesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Feature> future = gkeHubClient.listFeaturesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Feature element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFeaturesRequest, ListFeaturesPagedResponse>
      listFeaturesPagedCallable() {
    return stub.listFeaturesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Features in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListFeaturesRequest request =
   *       ListFeaturesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     ListFeaturesResponse response = gkeHubClient.listFeaturesCallable().call(request);
   *     for (Feature element : response.getResourcesList()) {
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
  public final UnaryCallable<ListFeaturesRequest, ListFeaturesResponse> listFeaturesCallable() {
    return stub.listFeaturesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
   *   Membership response = gkeHubClient.getMembership(name);
   * }
   * }</pre>
   *
   * @param name Required. The Membership resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Membership getMembership(MembershipName name) {
    GetMembershipRequest request =
        GetMembershipRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMembership(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString();
   *   Membership response = gkeHubClient.getMembership(name);
   * }
   * }</pre>
   *
   * @param name Required. The Membership resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Membership getMembership(String name) {
    GetMembershipRequest request = GetMembershipRequest.newBuilder().setName(name).build();
    return getMembership(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetMembershipRequest request =
   *       GetMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .build();
   *   Membership response = gkeHubClient.getMembership(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Membership getMembership(GetMembershipRequest request) {
    return getMembershipCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetMembershipRequest request =
   *       GetMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .build();
   *   ApiFuture<Membership> future = gkeHubClient.getMembershipCallable().futureCall(request);
   *   // Do something.
   *   Membership response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable() {
    return stub.getMembershipCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   FeatureName name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]");
   *   Feature response = gkeHubClient.getFeature(name);
   * }
   * }</pre>
   *
   * @param name Required. The Feature resource name in the format
   *     `projects/&#42;/locations/&#42;/features/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feature getFeature(FeatureName name) {
    GetFeatureRequest request =
        GetFeatureRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFeature(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString();
   *   Feature response = gkeHubClient.getFeature(name);
   * }
   * }</pre>
   *
   * @param name Required. The Feature resource name in the format
   *     `projects/&#42;/locations/&#42;/features/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feature getFeature(String name) {
    GetFeatureRequest request = GetFeatureRequest.newBuilder().setName(name).build();
    return getFeature(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetFeatureRequest request =
   *       GetFeatureRequest.newBuilder()
   *           .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   Feature response = gkeHubClient.getFeature(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feature getFeature(GetFeatureRequest request) {
    return getFeatureCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetFeatureRequest request =
   *       GetFeatureRequest.newBuilder()
   *           .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Feature> future = gkeHubClient.getFeatureCallable().futureCall(request);
   *   // Do something.
   *   Feature response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFeatureRequest, Feature> getFeatureCallable() {
    return stub.getFeatureCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * register other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Membership resource = Membership.newBuilder().build();
   *   String membershipId = "membershipId517665681";
   *   Membership response =
   *       gkeHubClient.createMembershipAsync(parent, resource, membershipId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Memberships will be
   *     created. Specified in the format `projects/&#42;/locations/&#42;`.
   * @param resource Required. The membership to create.
   * @param membershipId Required. Client chosen ID for the membership. `membership_id` must be a
   *     valid RFC 1123 compliant DNS label:
   *     <p>1. At most 63 characters in length 2. It must consist of lower case alphanumeric
   *     characters or `-` 3. It must start and end with an alphanumeric character
   *     <p>Which can be expressed as the regex: `[a-z0-9]([-a-z0-9]&#42;[a-z0-9])?`, with a maximum
   *     length of 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Membership, OperationMetadata> createMembershipAsync(
      LocationName parent, Membership resource, String membershipId) {
    CreateMembershipRequest request =
        CreateMembershipRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setResource(resource)
            .setMembershipId(membershipId)
            .build();
    return createMembershipAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * register other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Membership resource = Membership.newBuilder().build();
   *   String membershipId = "membershipId517665681";
   *   Membership response =
   *       gkeHubClient.createMembershipAsync(parent, resource, membershipId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Memberships will be
   *     created. Specified in the format `projects/&#42;/locations/&#42;`.
   * @param resource Required. The membership to create.
   * @param membershipId Required. Client chosen ID for the membership. `membership_id` must be a
   *     valid RFC 1123 compliant DNS label:
   *     <p>1. At most 63 characters in length 2. It must consist of lower case alphanumeric
   *     characters or `-` 3. It must start and end with an alphanumeric character
   *     <p>Which can be expressed as the regex: `[a-z0-9]([-a-z0-9]&#42;[a-z0-9])?`, with a maximum
   *     length of 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Membership, OperationMetadata> createMembershipAsync(
      String parent, Membership resource, String membershipId) {
    CreateMembershipRequest request =
        CreateMembershipRequest.newBuilder()
            .setParent(parent)
            .setResource(resource)
            .setMembershipId(membershipId)
            .build();
    return createMembershipAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * register other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateMembershipRequest request =
   *       CreateMembershipRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMembershipId("membershipId517665681")
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Membership response = gkeHubClient.createMembershipAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Membership, OperationMetadata> createMembershipAsync(
      CreateMembershipRequest request) {
    return createMembershipOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * register other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateMembershipRequest request =
   *       CreateMembershipRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMembershipId("membershipId517665681")
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Membership, OperationMetadata> future =
   *       gkeHubClient.createMembershipOperationCallable().futureCall(request);
   *   // Do something.
   *   Membership response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationCallable() {
    return stub.createMembershipOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * register other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateMembershipRequest request =
   *       CreateMembershipRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMembershipId("membershipId517665681")
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.createMembershipCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMembershipRequest, Operation> createMembershipCallable() {
    return stub.createMembershipCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Feature resource = Feature.newBuilder().build();
   *   String featureId = "featureId-420503887";
   *   Feature response = gkeHubClient.createFeatureAsync(parent, resource, featureId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Feature will be created.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @param resource The Feature resource to create.
   * @param featureId The ID of the feature to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Feature, OperationMetadata> createFeatureAsync(
      LocationName parent, Feature resource, String featureId) {
    CreateFeatureRequest request =
        CreateFeatureRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setResource(resource)
            .setFeatureId(featureId)
            .build();
    return createFeatureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Feature resource = Feature.newBuilder().build();
   *   String featureId = "featureId-420503887";
   *   Feature response = gkeHubClient.createFeatureAsync(parent, resource, featureId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Feature will be created.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @param resource The Feature resource to create.
   * @param featureId The ID of the feature to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Feature, OperationMetadata> createFeatureAsync(
      String parent, Feature resource, String featureId) {
    CreateFeatureRequest request =
        CreateFeatureRequest.newBuilder()
            .setParent(parent)
            .setResource(resource)
            .setFeatureId(featureId)
            .build();
    return createFeatureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateFeatureRequest request =
   *       CreateFeatureRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFeatureId("featureId-420503887")
   *           .setResource(Feature.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Feature response = gkeHubClient.createFeatureAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Feature, OperationMetadata> createFeatureAsync(
      CreateFeatureRequest request) {
    return createFeatureOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateFeatureRequest request =
   *       CreateFeatureRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFeatureId("featureId-420503887")
   *           .setResource(Feature.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Feature, OperationMetadata> future =
   *       gkeHubClient.createFeatureOperationCallable().futureCall(request);
   *   // Do something.
   *   Feature response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateFeatureRequest, Feature, OperationMetadata>
      createFeatureOperationCallable() {
    return stub.createFeatureOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateFeatureRequest request =
   *       CreateFeatureRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFeatureId("featureId-420503887")
   *           .setResource(Feature.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.createFeatureCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFeatureRequest, Operation> createFeatureCallable() {
    return stub.createFeatureCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * unregister other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
   *   gkeHubClient.deleteMembershipAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Membership resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMembershipAsync(
      MembershipName name) {
    DeleteMembershipRequest request =
        DeleteMembershipRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteMembershipAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * unregister other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString();
   *   gkeHubClient.deleteMembershipAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Membership resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMembershipAsync(String name) {
    DeleteMembershipRequest request = DeleteMembershipRequest.newBuilder().setName(name).build();
    return deleteMembershipAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * unregister other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteMembershipRequest request =
   *       DeleteMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   gkeHubClient.deleteMembershipAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMembershipAsync(
      DeleteMembershipRequest request) {
    return deleteMembershipOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * unregister other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteMembershipRequest request =
   *       DeleteMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gkeHubClient.deleteMembershipOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationCallable() {
    return stub.deleteMembershipOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Membership.
   *
   * <p>&#42;&#42;This is currently only supported for GKE clusters on Google Cloud&#42;&#42;. To
   * unregister other clusters, follow the instructions at
   * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteMembershipRequest request =
   *       DeleteMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.deleteMembershipCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMembershipRequest, Operation> deleteMembershipCallable() {
    return stub.deleteMembershipCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   FeatureName name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]");
   *   gkeHubClient.deleteFeatureAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Feature resource name in the format
   *     `projects/&#42;/locations/&#42;/features/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFeatureAsync(FeatureName name) {
    DeleteFeatureRequest request =
        DeleteFeatureRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteFeatureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString();
   *   gkeHubClient.deleteFeatureAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Feature resource name in the format
   *     `projects/&#42;/locations/&#42;/features/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFeatureAsync(String name) {
    DeleteFeatureRequest request = DeleteFeatureRequest.newBuilder().setName(name).build();
    return deleteFeatureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteFeatureRequest request =
   *       DeleteFeatureRequest.newBuilder()
   *           .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
   *           .setForce(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   gkeHubClient.deleteFeatureAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFeatureAsync(
      DeleteFeatureRequest request) {
    return deleteFeatureOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteFeatureRequest request =
   *       DeleteFeatureRequest.newBuilder()
   *           .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
   *           .setForce(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gkeHubClient.deleteFeatureOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteFeatureRequest, Empty, OperationMetadata>
      deleteFeatureOperationCallable() {
    return stub.deleteFeatureOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteFeatureRequest request =
   *       DeleteFeatureRequest.newBuilder()
   *           .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
   *           .setForce(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.deleteFeatureCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFeatureRequest, Operation> deleteFeatureCallable() {
    return stub.deleteFeatureCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   MembershipName name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
   *   Membership resource = Membership.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Membership response = gkeHubClient.updateMembershipAsync(name, resource, updateMask).get();
   * }
   * }</pre>
   *
   * @param name Required. The Membership resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @param resource Required. Only fields specified in update_mask are updated. If you specify a
   *     field in the update_mask but don't specify its value here that field will be deleted. If
   *     you are updating a map field, set the value of a key to null or empty string to delete the
   *     key from the map. It's not possible to update a key's value to the empty string. If you
   *     specify the update_mask to be a special path "&#42;", fully replaces all user-modifiable
   *     fields to match `resource`.
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Membership, OperationMetadata> updateMembershipAsync(
      MembershipName name, Membership resource, FieldMask updateMask) {
    UpdateMembershipRequest request =
        UpdateMembershipRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setResource(resource)
            .setUpdateMask(updateMask)
            .build();
    return updateMembershipAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString();
   *   Membership resource = Membership.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Membership response = gkeHubClient.updateMembershipAsync(name, resource, updateMask).get();
   * }
   * }</pre>
   *
   * @param name Required. The Membership resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @param resource Required. Only fields specified in update_mask are updated. If you specify a
   *     field in the update_mask but don't specify its value here that field will be deleted. If
   *     you are updating a map field, set the value of a key to null or empty string to delete the
   *     key from the map. It's not possible to update a key's value to the empty string. If you
   *     specify the update_mask to be a special path "&#42;", fully replaces all user-modifiable
   *     fields to match `resource`.
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Membership, OperationMetadata> updateMembershipAsync(
      String name, Membership resource, FieldMask updateMask) {
    UpdateMembershipRequest request =
        UpdateMembershipRequest.newBuilder()
            .setName(name)
            .setResource(resource)
            .setUpdateMask(updateMask)
            .build();
    return updateMembershipAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateMembershipRequest request =
   *       UpdateMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Membership response = gkeHubClient.updateMembershipAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Membership, OperationMetadata> updateMembershipAsync(
      UpdateMembershipRequest request) {
    return updateMembershipOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateMembershipRequest request =
   *       UpdateMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Membership, OperationMetadata> future =
   *       gkeHubClient.updateMembershipOperationCallable().futureCall(request);
   *   // Do something.
   *   Membership response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationCallable() {
    return stub.updateMembershipOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Membership.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateMembershipRequest request =
   *       UpdateMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(Membership.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.updateMembershipCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMembershipRequest, Operation> updateMembershipCallable() {
    return stub.updateMembershipCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   FeatureName name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]");
   *   Feature resource = Feature.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Feature response = gkeHubClient.updateFeatureAsync(name, resource, updateMask).get();
   * }
   * }</pre>
   *
   * @param name Required. The Feature resource name in the format
   *     `projects/&#42;/locations/&#42;/features/&#42;`.
   * @param resource Only fields specified in update_mask are updated. If you specify a field in the
   *     update_mask but don't specify its value here that field will be deleted. If you are
   *     updating a map field, set the value of a key to null or empty string to delete the key from
   *     the map. It's not possible to update a key's value to the empty string. If you specify the
   *     update_mask to be a special path "&#42;", fully replaces all user-modifiable fields to
   *     match `resource`.
   * @param updateMask Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Feature, OperationMetadata> updateFeatureAsync(
      FeatureName name, Feature resource, FieldMask updateMask) {
    UpdateFeatureRequest request =
        UpdateFeatureRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setResource(resource)
            .setUpdateMask(updateMask)
            .build();
    return updateFeatureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name = FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString();
   *   Feature resource = Feature.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Feature response = gkeHubClient.updateFeatureAsync(name, resource, updateMask).get();
   * }
   * }</pre>
   *
   * @param name Required. The Feature resource name in the format
   *     `projects/&#42;/locations/&#42;/features/&#42;`.
   * @param resource Only fields specified in update_mask are updated. If you specify a field in the
   *     update_mask but don't specify its value here that field will be deleted. If you are
   *     updating a map field, set the value of a key to null or empty string to delete the key from
   *     the map. It's not possible to update a key's value to the empty string. If you specify the
   *     update_mask to be a special path "&#42;", fully replaces all user-modifiable fields to
   *     match `resource`.
   * @param updateMask Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Feature, OperationMetadata> updateFeatureAsync(
      String name, Feature resource, FieldMask updateMask) {
    UpdateFeatureRequest request =
        UpdateFeatureRequest.newBuilder()
            .setName(name)
            .setResource(resource)
            .setUpdateMask(updateMask)
            .build();
    return updateFeatureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateFeatureRequest request =
   *       UpdateFeatureRequest.newBuilder()
   *           .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(Feature.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Feature response = gkeHubClient.updateFeatureAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Feature, OperationMetadata> updateFeatureAsync(
      UpdateFeatureRequest request) {
    return updateFeatureOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateFeatureRequest request =
   *       UpdateFeatureRequest.newBuilder()
   *           .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(Feature.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Feature, OperationMetadata> future =
   *       gkeHubClient.updateFeatureOperationCallable().futureCall(request);
   *   // Do something.
   *   Feature response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateFeatureRequest, Feature, OperationMetadata>
      updateFeatureOperationCallable() {
    return stub.updateFeatureOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateFeatureRequest request =
   *       UpdateFeatureRequest.newBuilder()
   *           .setName(FeatureName.of("[PROJECT]", "[LOCATION]", "[FEATURE]").toString())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResource(Feature.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.updateFeatureCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFeatureRequest, Operation> updateFeatureCallable() {
    return stub.updateFeatureCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates the manifest for deployment of the GKE connect agent.
   *
   * <p>&#42;&#42;This method is used internally by Google-provided libraries.&#42;&#42; Most
   * clients should not need to call this method directly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GenerateConnectManifestRequest request =
   *       GenerateConnectManifestRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setNamespace("namespace1252218203")
   *           .setProxy(ByteString.EMPTY)
   *           .setVersion("version351608024")
   *           .setIsUpgrade(true)
   *           .setRegistry("registry-690212803")
   *           .setImagePullSecretContent(ByteString.EMPTY)
   *           .build();
   *   GenerateConnectManifestResponse response = gkeHubClient.generateConnectManifest(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateConnectManifestResponse generateConnectManifest(
      GenerateConnectManifestRequest request) {
    return generateConnectManifestCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates the manifest for deployment of the GKE connect agent.
   *
   * <p>&#42;&#42;This method is used internally by Google-provided libraries.&#42;&#42; Most
   * clients should not need to call this method directly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GenerateConnectManifestRequest request =
   *       GenerateConnectManifestRequest.newBuilder()
   *           .setName(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setNamespace("namespace1252218203")
   *           .setProxy(ByteString.EMPTY)
   *           .setVersion("version351608024")
   *           .setIsUpgrade(true)
   *           .setRegistry("registry-690212803")
   *           .setImagePullSecretContent(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<GenerateConnectManifestResponse> future =
   *       gkeHubClient.generateConnectManifestCallable().futureCall(request);
   *   // Do something.
   *   GenerateConnectManifestResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestCallable() {
    return stub.generateConnectManifestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Fleet fleet = Fleet.newBuilder().build();
   *   Fleet response = gkeHubClient.createFleetAsync(parent, fleet).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Fleet will be created.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @param fleet Required. The fleet to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Fleet, OperationMetadata> createFleetAsync(
      LocationName parent, Fleet fleet) {
    CreateFleetRequest request =
        CreateFleetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFleet(fleet)
            .build();
    return createFleetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Fleet fleet = Fleet.newBuilder().build();
   *   Fleet response = gkeHubClient.createFleetAsync(parent, fleet).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Fleet will be created.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @param fleet Required. The fleet to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Fleet, OperationMetadata> createFleetAsync(
      String parent, Fleet fleet) {
    CreateFleetRequest request =
        CreateFleetRequest.newBuilder().setParent(parent).setFleet(fleet).build();
    return createFleetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateFleetRequest request =
   *       CreateFleetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFleet(Fleet.newBuilder().build())
   *           .build();
   *   Fleet response = gkeHubClient.createFleetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Fleet, OperationMetadata> createFleetAsync(
      CreateFleetRequest request) {
    return createFleetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateFleetRequest request =
   *       CreateFleetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFleet(Fleet.newBuilder().build())
   *           .build();
   *   OperationFuture<Fleet, OperationMetadata> future =
   *       gkeHubClient.createFleetOperationCallable().futureCall(request);
   *   // Do something.
   *   Fleet response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateFleetRequest, Fleet, OperationMetadata>
      createFleetOperationCallable() {
    return stub.createFleetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateFleetRequest request =
   *       CreateFleetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFleet(Fleet.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.createFleetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFleetRequest, Operation> createFleetCallable() {
    return stub.createFleetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   FleetName name = FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]");
   *   Fleet response = gkeHubClient.getFleet(name);
   * }
   * }</pre>
   *
   * @param name Required. The Fleet resource name in the format
   *     `projects/&#42;/locations/&#42;/fleets/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Fleet getFleet(FleetName name) {
    GetFleetRequest request =
        GetFleetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFleet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name =
   *       FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]").toString();
   *   Fleet response = gkeHubClient.getFleet(name);
   * }
   * }</pre>
   *
   * @param name Required. The Fleet resource name in the format
   *     `projects/&#42;/locations/&#42;/fleets/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Fleet getFleet(String name) {
    GetFleetRequest request = GetFleetRequest.newBuilder().setName(name).build();
    return getFleet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetFleetRequest request =
   *       GetFleetRequest.newBuilder()
   *           .setName(
   *               FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]")
   *                   .toString())
   *           .build();
   *   Fleet response = gkeHubClient.getFleet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Fleet getFleet(GetFleetRequest request) {
    return getFleetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetFleetRequest request =
   *       GetFleetRequest.newBuilder()
   *           .setName(
   *               FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Fleet> future = gkeHubClient.getFleetCallable().futureCall(request);
   *   // Do something.
   *   Fleet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFleetRequest, Fleet> getFleetCallable() {
    return stub.getFleetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   Fleet fleet = Fleet.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Fleet response = gkeHubClient.updateFleetAsync(fleet, updateMask).get();
   * }
   * }</pre>
   *
   * @param fleet Required. The Fleet to update.
   *     <p>The `name` field of the Fleet object identifies which fleet will be updated.
   * @param updateMask Required. The fields to be updated;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Fleet, OperationMetadata> updateFleetAsync(
      Fleet fleet, FieldMask updateMask) {
    UpdateFleetRequest request =
        UpdateFleetRequest.newBuilder().setFleet(fleet).setUpdateMask(updateMask).build();
    return updateFleetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateFleetRequest request =
   *       UpdateFleetRequest.newBuilder()
   *           .setFleet(Fleet.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Fleet response = gkeHubClient.updateFleetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Fleet, OperationMetadata> updateFleetAsync(
      UpdateFleetRequest request) {
    return updateFleetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateFleetRequest request =
   *       UpdateFleetRequest.newBuilder()
   *           .setFleet(Fleet.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Fleet, OperationMetadata> future =
   *       gkeHubClient.updateFleetOperationCallable().futureCall(request);
   *   // Do something.
   *   Fleet response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateFleetRequest, Fleet, OperationMetadata>
      updateFleetOperationCallable() {
    return stub.updateFleetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateFleetRequest request =
   *       UpdateFleetRequest.newBuilder()
   *           .setFleet(Fleet.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.updateFleetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFleetRequest, Operation> updateFleetCallable() {
    return stub.updateFleetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Fleet. There must be no memberships remaining in the Fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   FleetName name = FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]");
   *   gkeHubClient.deleteFleetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Fleet resource name in the format
   *     `projects/&#42;/locations/&#42;/fleets/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFleetAsync(FleetName name) {
    DeleteFleetRequest request =
        DeleteFleetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteFleetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Fleet. There must be no memberships remaining in the Fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name =
   *       FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]").toString();
   *   gkeHubClient.deleteFleetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Fleet resource name in the format
   *     `projects/&#42;/locations/&#42;/fleets/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFleetAsync(String name) {
    DeleteFleetRequest request = DeleteFleetRequest.newBuilder().setName(name).build();
    return deleteFleetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Fleet. There must be no memberships remaining in the Fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteFleetRequest request =
   *       DeleteFleetRequest.newBuilder()
   *           .setName(
   *               FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]")
   *                   .toString())
   *           .build();
   *   gkeHubClient.deleteFleetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFleetAsync(
      DeleteFleetRequest request) {
    return deleteFleetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Fleet. There must be no memberships remaining in the Fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteFleetRequest request =
   *       DeleteFleetRequest.newBuilder()
   *           .setName(
   *               FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gkeHubClient.deleteFleetOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteFleetRequest, Empty, OperationMetadata>
      deleteFleetOperationCallable() {
    return stub.deleteFleetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Fleet. There must be no memberships remaining in the Fleet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteFleetRequest request =
   *       DeleteFleetRequest.newBuilder()
   *           .setName(
   *               FleetName.ofProjectLocationFleetName("[PROJECT]", "[LOCATION]", "[FLEET]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.deleteFleetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFleetRequest, Operation> deleteFleetCallable() {
    return stub.deleteFleetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all fleets within an organization or a project that the caller has access to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Fleet element : gkeHubClient.listFleets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The organization or project to list for Fleets under, in the format
   *     `organizations/&#42;/locations/&#42;` or `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFleetsPagedResponse listFleets(LocationName parent) {
    ListFleetsRequest request =
        ListFleetsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listFleets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all fleets within an organization or a project that the caller has access to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Fleet element : gkeHubClient.listFleets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The organization or project to list for Fleets under, in the format
   *     `organizations/&#42;/locations/&#42;` or `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFleetsPagedResponse listFleets(String parent) {
    ListFleetsRequest request = ListFleetsRequest.newBuilder().setParent(parent).build();
    return listFleets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all fleets within an organization or a project that the caller has access to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListFleetsRequest request =
   *       ListFleetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (Fleet element : gkeHubClient.listFleets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFleetsPagedResponse listFleets(ListFleetsRequest request) {
    return listFleetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all fleets within an organization or a project that the caller has access to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListFleetsRequest request =
   *       ListFleetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<Fleet> future = gkeHubClient.listFleetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Fleet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFleetsRequest, ListFleetsPagedResponse> listFleetsPagedCallable() {
    return stub.listFleetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all fleets within an organization or a project that the caller has access to.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListFleetsRequest request =
   *       ListFleetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     ListFleetsResponse response = gkeHubClient.listFleetsCallable().call(request);
   *     for (Fleet element : response.getFleetsList()) {
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
  public final UnaryCallable<ListFleetsRequest, ListFleetsResponse> listFleetsCallable() {
    return stub.listFleetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   NamespaceName name = NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]");
   *   Namespace response = gkeHubClient.getScopeNamespace(name);
   * }
   * }</pre>
   *
   * @param name Required. The Namespace resource name in the format
   *     `projects/&#42;/locations/&#42;/scopes/&#42;/namespaces/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Namespace getScopeNamespace(NamespaceName name) {
    GetScopeNamespaceRequest request =
        GetScopeNamespaceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getScopeNamespace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name =
   *       NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]").toString();
   *   Namespace response = gkeHubClient.getScopeNamespace(name);
   * }
   * }</pre>
   *
   * @param name Required. The Namespace resource name in the format
   *     `projects/&#42;/locations/&#42;/scopes/&#42;/namespaces/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Namespace getScopeNamespace(String name) {
    GetScopeNamespaceRequest request = GetScopeNamespaceRequest.newBuilder().setName(name).build();
    return getScopeNamespace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetScopeNamespaceRequest request =
   *       GetScopeNamespaceRequest.newBuilder()
   *           .setName(
   *               NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]").toString())
   *           .build();
   *   Namespace response = gkeHubClient.getScopeNamespace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Namespace getScopeNamespace(GetScopeNamespaceRequest request) {
    return getScopeNamespaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetScopeNamespaceRequest request =
   *       GetScopeNamespaceRequest.newBuilder()
   *           .setName(
   *               NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]").toString())
   *           .build();
   *   ApiFuture<Namespace> future = gkeHubClient.getScopeNamespaceCallable().futureCall(request);
   *   // Do something.
   *   Namespace response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetScopeNamespaceRequest, Namespace> getScopeNamespaceCallable() {
    return stub.getScopeNamespaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
   *   Namespace scopeNamespace = Namespace.newBuilder().build();
   *   String scopeNamespaceId = "scopeNamespaceId-125738782";
   *   Namespace response =
   *       gkeHubClient.createScopeNamespaceAsync(parent, scopeNamespace, scopeNamespaceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Namespace will be created.
   *     Specified in the format `projects/&#42;/locations/&#42;/scopes/&#42;`.
   * @param scopeNamespace Required. The fleet namespace to create.
   * @param scopeNamespaceId Required. Client chosen ID for the Namespace. `namespace_id` must be a
   *     valid RFC 1123 compliant DNS label:
   *     <p>1. At most 63 characters in length 2. It must consist of lower case alphanumeric
   *     characters or `-` 3. It must start and end with an alphanumeric character
   *     <p>Which can be expressed as the regex: `[a-z0-9]([-a-z0-9]&#42;[a-z0-9])?`, with a maximum
   *     length of 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Namespace, OperationMetadata> createScopeNamespaceAsync(
      ScopeName parent, Namespace scopeNamespace, String scopeNamespaceId) {
    CreateScopeNamespaceRequest request =
        CreateScopeNamespaceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setScopeNamespace(scopeNamespace)
            .setScopeNamespaceId(scopeNamespaceId)
            .build();
    return createScopeNamespaceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString();
   *   Namespace scopeNamespace = Namespace.newBuilder().build();
   *   String scopeNamespaceId = "scopeNamespaceId-125738782";
   *   Namespace response =
   *       gkeHubClient.createScopeNamespaceAsync(parent, scopeNamespace, scopeNamespaceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Namespace will be created.
   *     Specified in the format `projects/&#42;/locations/&#42;/scopes/&#42;`.
   * @param scopeNamespace Required. The fleet namespace to create.
   * @param scopeNamespaceId Required. Client chosen ID for the Namespace. `namespace_id` must be a
   *     valid RFC 1123 compliant DNS label:
   *     <p>1. At most 63 characters in length 2. It must consist of lower case alphanumeric
   *     characters or `-` 3. It must start and end with an alphanumeric character
   *     <p>Which can be expressed as the regex: `[a-z0-9]([-a-z0-9]&#42;[a-z0-9])?`, with a maximum
   *     length of 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Namespace, OperationMetadata> createScopeNamespaceAsync(
      String parent, Namespace scopeNamespace, String scopeNamespaceId) {
    CreateScopeNamespaceRequest request =
        CreateScopeNamespaceRequest.newBuilder()
            .setParent(parent)
            .setScopeNamespace(scopeNamespace)
            .setScopeNamespaceId(scopeNamespaceId)
            .build();
    return createScopeNamespaceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateScopeNamespaceRequest request =
   *       CreateScopeNamespaceRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setScopeNamespaceId("scopeNamespaceId-125738782")
   *           .setScopeNamespace(Namespace.newBuilder().build())
   *           .build();
   *   Namespace response = gkeHubClient.createScopeNamespaceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Namespace, OperationMetadata> createScopeNamespaceAsync(
      CreateScopeNamespaceRequest request) {
    return createScopeNamespaceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateScopeNamespaceRequest request =
   *       CreateScopeNamespaceRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setScopeNamespaceId("scopeNamespaceId-125738782")
   *           .setScopeNamespace(Namespace.newBuilder().build())
   *           .build();
   *   OperationFuture<Namespace, OperationMetadata> future =
   *       gkeHubClient.createScopeNamespaceOperationCallable().futureCall(request);
   *   // Do something.
   *   Namespace response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateScopeNamespaceRequest, Namespace, OperationMetadata>
      createScopeNamespaceOperationCallable() {
    return stub.createScopeNamespaceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateScopeNamespaceRequest request =
   *       CreateScopeNamespaceRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setScopeNamespaceId("scopeNamespaceId-125738782")
   *           .setScopeNamespace(Namespace.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.createScopeNamespaceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateScopeNamespaceRequest, Operation>
      createScopeNamespaceCallable() {
    return stub.createScopeNamespaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   Namespace scopeNamespace = Namespace.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Namespace response = gkeHubClient.updateScopeNamespaceAsync(scopeNamespace, updateMask).get();
   * }
   * }</pre>
   *
   * @param scopeNamespace Required. A namespace with fields updated. The 'name' field in this
   *     namespace is used to identify the resource to update. Given 'updated' prefix to follow
   *     go/proto-best-practices-checkers#keyword_conflict
   * @param updateMask Required. The fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Namespace, OperationMetadata> updateScopeNamespaceAsync(
      Namespace scopeNamespace, FieldMask updateMask) {
    UpdateScopeNamespaceRequest request =
        UpdateScopeNamespaceRequest.newBuilder()
            .setScopeNamespace(scopeNamespace)
            .setUpdateMask(updateMask)
            .build();
    return updateScopeNamespaceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateScopeNamespaceRequest request =
   *       UpdateScopeNamespaceRequest.newBuilder()
   *           .setScopeNamespace(Namespace.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Namespace response = gkeHubClient.updateScopeNamespaceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Namespace, OperationMetadata> updateScopeNamespaceAsync(
      UpdateScopeNamespaceRequest request) {
    return updateScopeNamespaceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateScopeNamespaceRequest request =
   *       UpdateScopeNamespaceRequest.newBuilder()
   *           .setScopeNamespace(Namespace.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Namespace, OperationMetadata> future =
   *       gkeHubClient.updateScopeNamespaceOperationCallable().futureCall(request);
   *   // Do something.
   *   Namespace response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateScopeNamespaceRequest, Namespace, OperationMetadata>
      updateScopeNamespaceOperationCallable() {
    return stub.updateScopeNamespaceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateScopeNamespaceRequest request =
   *       UpdateScopeNamespaceRequest.newBuilder()
   *           .setScopeNamespace(Namespace.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.updateScopeNamespaceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateScopeNamespaceRequest, Operation>
      updateScopeNamespaceCallable() {
    return stub.updateScopeNamespaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   NamespaceName name = NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]");
   *   gkeHubClient.deleteScopeNamespaceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Namespace resource name in the format
   *     `projects/&#42;/locations/&#42;/scopes/&#42;/namespaces/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteScopeNamespaceAsync(
      NamespaceName name) {
    DeleteScopeNamespaceRequest request =
        DeleteScopeNamespaceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteScopeNamespaceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name =
   *       NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]").toString();
   *   gkeHubClient.deleteScopeNamespaceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Namespace resource name in the format
   *     `projects/&#42;/locations/&#42;/scopes/&#42;/namespaces/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteScopeNamespaceAsync(String name) {
    DeleteScopeNamespaceRequest request =
        DeleteScopeNamespaceRequest.newBuilder().setName(name).build();
    return deleteScopeNamespaceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteScopeNamespaceRequest request =
   *       DeleteScopeNamespaceRequest.newBuilder()
   *           .setName(
   *               NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]").toString())
   *           .build();
   *   gkeHubClient.deleteScopeNamespaceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteScopeNamespaceAsync(
      DeleteScopeNamespaceRequest request) {
    return deleteScopeNamespaceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteScopeNamespaceRequest request =
   *       DeleteScopeNamespaceRequest.newBuilder()
   *           .setName(
   *               NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gkeHubClient.deleteScopeNamespaceOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteScopeNamespaceRequest, Empty, OperationMetadata>
      deleteScopeNamespaceOperationCallable() {
    return stub.deleteScopeNamespaceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a fleet namespace.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteScopeNamespaceRequest request =
   *       DeleteScopeNamespaceRequest.newBuilder()
   *           .setName(
   *               NamespaceName.of("[PROJECT]", "[LOCATION]", "[SCOPE]", "[NAMESPACE]").toString())
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.deleteScopeNamespaceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteScopeNamespaceRequest, Operation>
      deleteScopeNamespaceCallable() {
    return stub.deleteScopeNamespaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists fleet namespaces.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
   *   for (Namespace element : gkeHubClient.listScopeNamespaces(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Features will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;/scopes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScopeNamespacesPagedResponse listScopeNamespaces(ScopeName parent) {
    ListScopeNamespacesRequest request =
        ListScopeNamespacesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listScopeNamespaces(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists fleet namespaces.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString();
   *   for (Namespace element : gkeHubClient.listScopeNamespaces(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Features will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;/scopes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScopeNamespacesPagedResponse listScopeNamespaces(String parent) {
    ListScopeNamespacesRequest request =
        ListScopeNamespacesRequest.newBuilder().setParent(parent).build();
    return listScopeNamespaces(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists fleet namespaces.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListScopeNamespacesRequest request =
   *       ListScopeNamespacesRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Namespace element : gkeHubClient.listScopeNamespaces(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScopeNamespacesPagedResponse listScopeNamespaces(
      ListScopeNamespacesRequest request) {
    return listScopeNamespacesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists fleet namespaces.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListScopeNamespacesRequest request =
   *       ListScopeNamespacesRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Namespace> future =
   *       gkeHubClient.listScopeNamespacesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Namespace element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListScopeNamespacesRequest, ListScopeNamespacesPagedResponse>
      listScopeNamespacesPagedCallable() {
    return stub.listScopeNamespacesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists fleet namespaces.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListScopeNamespacesRequest request =
   *       ListScopeNamespacesRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListScopeNamespacesResponse response =
   *         gkeHubClient.listScopeNamespacesCallable().call(request);
   *     for (Namespace element : response.getScopeNamespacesList()) {
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
  public final UnaryCallable<ListScopeNamespacesRequest, ListScopeNamespacesResponse>
      listScopeNamespacesCallable() {
    return stub.listScopeNamespacesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   RBACRoleBindingName name =
   *       RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
   *           "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]");
   *   RBACRoleBinding response = gkeHubClient.getScopeRBACRoleBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The RBACRoleBinding resource name in the format
   *     `projects/&#42;/locations/&#42;/scopes/&#42;/rbacrolebindings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RBACRoleBinding getScopeRBACRoleBinding(RBACRoleBindingName name) {
    GetScopeRBACRoleBindingRequest request =
        GetScopeRBACRoleBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getScopeRBACRoleBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name =
   *       RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
   *               "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
   *           .toString();
   *   RBACRoleBinding response = gkeHubClient.getScopeRBACRoleBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The RBACRoleBinding resource name in the format
   *     `projects/&#42;/locations/&#42;/scopes/&#42;/rbacrolebindings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RBACRoleBinding getScopeRBACRoleBinding(String name) {
    GetScopeRBACRoleBindingRequest request =
        GetScopeRBACRoleBindingRequest.newBuilder().setName(name).build();
    return getScopeRBACRoleBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetScopeRBACRoleBindingRequest request =
   *       GetScopeRBACRoleBindingRequest.newBuilder()
   *           .setName(
   *               RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
   *                       "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
   *                   .toString())
   *           .build();
   *   RBACRoleBinding response = gkeHubClient.getScopeRBACRoleBinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RBACRoleBinding getScopeRBACRoleBinding(GetScopeRBACRoleBindingRequest request) {
    return getScopeRBACRoleBindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetScopeRBACRoleBindingRequest request =
   *       GetScopeRBACRoleBindingRequest.newBuilder()
   *           .setName(
   *               RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
   *                       "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<RBACRoleBinding> future =
   *       gkeHubClient.getScopeRBACRoleBindingCallable().futureCall(request);
   *   // Do something.
   *   RBACRoleBinding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetScopeRBACRoleBindingRequest, RBACRoleBinding>
      getScopeRBACRoleBindingCallable() {
    return stub.getScopeRBACRoleBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
   *   RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
   *   String rbacrolebindingId = "rbacrolebindingId827577784";
   *   RBACRoleBinding response =
   *       gkeHubClient
   *           .createScopeRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the RBACRoleBinding will be
   *     created. Specified in the format `projects/&#42;/locations/&#42;/scopes/&#42;`.
   * @param rbacrolebinding Required. The rbacrolebindings to create.
   * @param rbacrolebindingId Required. Client chosen ID for the RBACRoleBinding.
   *     `rbacrolebinding_id` must be a valid RFC 1123 compliant DNS label:
   *     <p>1. At most 63 characters in length 2. It must consist of lower case alphanumeric
   *     characters or `-` 3. It must start and end with an alphanumeric character
   *     <p>Which can be expressed as the regex: `[a-z0-9]([-a-z0-9]&#42;[a-z0-9])?`, with a maximum
   *     length of 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RBACRoleBinding, OperationMetadata> createScopeRBACRoleBindingAsync(
      MembershipName parent, RBACRoleBinding rbacrolebinding, String rbacrolebindingId) {
    CreateScopeRBACRoleBindingRequest request =
        CreateScopeRBACRoleBindingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRbacrolebinding(rbacrolebinding)
            .setRbacrolebindingId(rbacrolebindingId)
            .build();
    return createScopeRBACRoleBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
   *   RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
   *   String rbacrolebindingId = "rbacrolebindingId827577784";
   *   RBACRoleBinding response =
   *       gkeHubClient
   *           .createScopeRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the RBACRoleBinding will be
   *     created. Specified in the format `projects/&#42;/locations/&#42;/scopes/&#42;`.
   * @param rbacrolebinding Required. The rbacrolebindings to create.
   * @param rbacrolebindingId Required. Client chosen ID for the RBACRoleBinding.
   *     `rbacrolebinding_id` must be a valid RFC 1123 compliant DNS label:
   *     <p>1. At most 63 characters in length 2. It must consist of lower case alphanumeric
   *     characters or `-` 3. It must start and end with an alphanumeric character
   *     <p>Which can be expressed as the regex: `[a-z0-9]([-a-z0-9]&#42;[a-z0-9])?`, with a maximum
   *     length of 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RBACRoleBinding, OperationMetadata> createScopeRBACRoleBindingAsync(
      ScopeName parent, RBACRoleBinding rbacrolebinding, String rbacrolebindingId) {
    CreateScopeRBACRoleBindingRequest request =
        CreateScopeRBACRoleBindingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRbacrolebinding(rbacrolebinding)
            .setRbacrolebindingId(rbacrolebindingId)
            .build();
    return createScopeRBACRoleBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString();
   *   RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
   *   String rbacrolebindingId = "rbacrolebindingId827577784";
   *   RBACRoleBinding response =
   *       gkeHubClient
   *           .createScopeRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the RBACRoleBinding will be
   *     created. Specified in the format `projects/&#42;/locations/&#42;/scopes/&#42;`.
   * @param rbacrolebinding Required. The rbacrolebindings to create.
   * @param rbacrolebindingId Required. Client chosen ID for the RBACRoleBinding.
   *     `rbacrolebinding_id` must be a valid RFC 1123 compliant DNS label:
   *     <p>1. At most 63 characters in length 2. It must consist of lower case alphanumeric
   *     characters or `-` 3. It must start and end with an alphanumeric character
   *     <p>Which can be expressed as the regex: `[a-z0-9]([-a-z0-9]&#42;[a-z0-9])?`, with a maximum
   *     length of 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RBACRoleBinding, OperationMetadata> createScopeRBACRoleBindingAsync(
      String parent, RBACRoleBinding rbacrolebinding, String rbacrolebindingId) {
    CreateScopeRBACRoleBindingRequest request =
        CreateScopeRBACRoleBindingRequest.newBuilder()
            .setParent(parent)
            .setRbacrolebinding(rbacrolebinding)
            .setRbacrolebindingId(rbacrolebindingId)
            .build();
    return createScopeRBACRoleBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateScopeRBACRoleBindingRequest request =
   *       CreateScopeRBACRoleBindingRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setRbacrolebindingId("rbacrolebindingId827577784")
   *           .setRbacrolebinding(RBACRoleBinding.newBuilder().build())
   *           .build();
   *   RBACRoleBinding response = gkeHubClient.createScopeRBACRoleBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RBACRoleBinding, OperationMetadata> createScopeRBACRoleBindingAsync(
      CreateScopeRBACRoleBindingRequest request) {
    return createScopeRBACRoleBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateScopeRBACRoleBindingRequest request =
   *       CreateScopeRBACRoleBindingRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setRbacrolebindingId("rbacrolebindingId827577784")
   *           .setRbacrolebinding(RBACRoleBinding.newBuilder().build())
   *           .build();
   *   OperationFuture<RBACRoleBinding, OperationMetadata> future =
   *       gkeHubClient.createScopeRBACRoleBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   RBACRoleBinding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      createScopeRBACRoleBindingOperationCallable() {
    return stub.createScopeRBACRoleBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateScopeRBACRoleBindingRequest request =
   *       CreateScopeRBACRoleBindingRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setRbacrolebindingId("rbacrolebindingId827577784")
   *           .setRbacrolebinding(RBACRoleBinding.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gkeHubClient.createScopeRBACRoleBindingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateScopeRBACRoleBindingRequest, Operation>
      createScopeRBACRoleBindingCallable() {
    return stub.createScopeRBACRoleBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   RBACRoleBinding response =
   *       gkeHubClient.updateScopeRBACRoleBindingAsync(rbacrolebinding, updateMask).get();
   * }
   * }</pre>
   *
   * @param rbacrolebinding Required. A rbacrolebinding with fields updated. The 'name' field in
   *     this rbacrolebinding is used to identify the resource to update.
   * @param updateMask Required. The fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RBACRoleBinding, OperationMetadata> updateScopeRBACRoleBindingAsync(
      RBACRoleBinding rbacrolebinding, FieldMask updateMask) {
    UpdateScopeRBACRoleBindingRequest request =
        UpdateScopeRBACRoleBindingRequest.newBuilder()
            .setRbacrolebinding(rbacrolebinding)
            .setUpdateMask(updateMask)
            .build();
    return updateScopeRBACRoleBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateScopeRBACRoleBindingRequest request =
   *       UpdateScopeRBACRoleBindingRequest.newBuilder()
   *           .setRbacrolebinding(RBACRoleBinding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   RBACRoleBinding response = gkeHubClient.updateScopeRBACRoleBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RBACRoleBinding, OperationMetadata> updateScopeRBACRoleBindingAsync(
      UpdateScopeRBACRoleBindingRequest request) {
    return updateScopeRBACRoleBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateScopeRBACRoleBindingRequest request =
   *       UpdateScopeRBACRoleBindingRequest.newBuilder()
   *           .setRbacrolebinding(RBACRoleBinding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<RBACRoleBinding, OperationMetadata> future =
   *       gkeHubClient.updateScopeRBACRoleBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   RBACRoleBinding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateScopeRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      updateScopeRBACRoleBindingOperationCallable() {
    return stub.updateScopeRBACRoleBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateScopeRBACRoleBindingRequest request =
   *       UpdateScopeRBACRoleBindingRequest.newBuilder()
   *           .setRbacrolebinding(RBACRoleBinding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gkeHubClient.updateScopeRBACRoleBindingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateScopeRBACRoleBindingRequest, Operation>
      updateScopeRBACRoleBindingCallable() {
    return stub.updateScopeRBACRoleBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   RBACRoleBindingName name =
   *       RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
   *           "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]");
   *   gkeHubClient.deleteScopeRBACRoleBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The RBACRoleBinding resource name in the format
   *     `projects/&#42;/locations/&#42;/scopes/&#42;/rbacrolebindings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteScopeRBACRoleBindingAsync(
      RBACRoleBindingName name) {
    DeleteScopeRBACRoleBindingRequest request =
        DeleteScopeRBACRoleBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteScopeRBACRoleBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name =
   *       RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
   *               "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
   *           .toString();
   *   gkeHubClient.deleteScopeRBACRoleBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The RBACRoleBinding resource name in the format
   *     `projects/&#42;/locations/&#42;/scopes/&#42;/rbacrolebindings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteScopeRBACRoleBindingAsync(
      String name) {
    DeleteScopeRBACRoleBindingRequest request =
        DeleteScopeRBACRoleBindingRequest.newBuilder().setName(name).build();
    return deleteScopeRBACRoleBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteScopeRBACRoleBindingRequest request =
   *       DeleteScopeRBACRoleBindingRequest.newBuilder()
   *           .setName(
   *               RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
   *                       "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
   *                   .toString())
   *           .build();
   *   gkeHubClient.deleteScopeRBACRoleBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteScopeRBACRoleBindingAsync(
      DeleteScopeRBACRoleBindingRequest request) {
    return deleteScopeRBACRoleBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteScopeRBACRoleBindingRequest request =
   *       DeleteScopeRBACRoleBindingRequest.newBuilder()
   *           .setName(
   *               RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
   *                       "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gkeHubClient.deleteScopeRBACRoleBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteScopeRBACRoleBindingRequest, Empty, OperationMetadata>
      deleteScopeRBACRoleBindingOperationCallable() {
    return stub.deleteScopeRBACRoleBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Scope RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteScopeRBACRoleBindingRequest request =
   *       DeleteScopeRBACRoleBindingRequest.newBuilder()
   *           .setName(
   *               RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
   *                       "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gkeHubClient.deleteScopeRBACRoleBindingCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteScopeRBACRoleBindingRequest, Operation>
      deleteScopeRBACRoleBindingCallable() {
    return stub.deleteScopeRBACRoleBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Scope RBACRoleBindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
   *   for (RBACRoleBinding element : gkeHubClient.listScopeRBACRoleBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Features will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;/scopes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScopeRBACRoleBindingsPagedResponse listScopeRBACRoleBindings(
      MembershipName parent) {
    ListScopeRBACRoleBindingsRequest request =
        ListScopeRBACRoleBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listScopeRBACRoleBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Scope RBACRoleBindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
   *   for (RBACRoleBinding element : gkeHubClient.listScopeRBACRoleBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Features will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;/scopes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScopeRBACRoleBindingsPagedResponse listScopeRBACRoleBindings(ScopeName parent) {
    ListScopeRBACRoleBindingsRequest request =
        ListScopeRBACRoleBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listScopeRBACRoleBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Scope RBACRoleBindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString();
   *   for (RBACRoleBinding element : gkeHubClient.listScopeRBACRoleBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Features will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;/scopes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScopeRBACRoleBindingsPagedResponse listScopeRBACRoleBindings(String parent) {
    ListScopeRBACRoleBindingsRequest request =
        ListScopeRBACRoleBindingsRequest.newBuilder().setParent(parent).build();
    return listScopeRBACRoleBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Scope RBACRoleBindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListScopeRBACRoleBindingsRequest request =
   *       ListScopeRBACRoleBindingsRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (RBACRoleBinding element : gkeHubClient.listScopeRBACRoleBindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScopeRBACRoleBindingsPagedResponse listScopeRBACRoleBindings(
      ListScopeRBACRoleBindingsRequest request) {
    return listScopeRBACRoleBindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Scope RBACRoleBindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListScopeRBACRoleBindingsRequest request =
   *       ListScopeRBACRoleBindingsRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<RBACRoleBinding> future =
   *       gkeHubClient.listScopeRBACRoleBindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RBACRoleBinding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsPagedResponse>
      listScopeRBACRoleBindingsPagedCallable() {
    return stub.listScopeRBACRoleBindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Scope RBACRoleBindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListScopeRBACRoleBindingsRequest request =
   *       ListScopeRBACRoleBindingsRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListScopeRBACRoleBindingsResponse response =
   *         gkeHubClient.listScopeRBACRoleBindingsCallable().call(request);
   *     for (RBACRoleBinding element : response.getRbacrolebindingsList()) {
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
  public final UnaryCallable<ListScopeRBACRoleBindingsRequest, ListScopeRBACRoleBindingsResponse>
      listScopeRBACRoleBindingsCallable() {
    return stub.listScopeRBACRoleBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ScopeName name = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
   *   Scope response = gkeHubClient.getScope(name);
   * }
   * }</pre>
   *
   * @param name Required. The Scope resource name in the format
   *     `projects/&#42;/locations/&#42;/scopes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Scope getScope(ScopeName name) {
    GetScopeRequest request =
        GetScopeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString();
   *   Scope response = gkeHubClient.getScope(name);
   * }
   * }</pre>
   *
   * @param name Required. The Scope resource name in the format
   *     `projects/&#42;/locations/&#42;/scopes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Scope getScope(String name) {
    GetScopeRequest request = GetScopeRequest.newBuilder().setName(name).build();
    return getScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetScopeRequest request =
   *       GetScopeRequest.newBuilder()
   *           .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .build();
   *   Scope response = gkeHubClient.getScope(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Scope getScope(GetScopeRequest request) {
    return getScopeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetScopeRequest request =
   *       GetScopeRequest.newBuilder()
   *           .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .build();
   *   ApiFuture<Scope> future = gkeHubClient.getScopeCallable().futureCall(request);
   *   // Do something.
   *   Scope response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetScopeRequest, Scope> getScopeCallable() {
    return stub.getScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Scope scope = Scope.newBuilder().build();
   *   String scopeId = "scopeId1923941007";
   *   Scope response = gkeHubClient.createScopeAsync(parent, scope, scopeId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Scope will be created.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @param scope Required. The Scope to create.
   * @param scopeId Required. Client chosen ID for the Scope. `scope_id` must be a ????
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Scope, OperationMetadata> createScopeAsync(
      LocationName parent, Scope scope, String scopeId) {
    CreateScopeRequest request =
        CreateScopeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setScope(scope)
            .setScopeId(scopeId)
            .build();
    return createScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Scope scope = Scope.newBuilder().build();
   *   String scopeId = "scopeId1923941007";
   *   Scope response = gkeHubClient.createScopeAsync(parent, scope, scopeId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Scope will be created.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @param scope Required. The Scope to create.
   * @param scopeId Required. Client chosen ID for the Scope. `scope_id` must be a ????
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Scope, OperationMetadata> createScopeAsync(
      String parent, Scope scope, String scopeId) {
    CreateScopeRequest request =
        CreateScopeRequest.newBuilder()
            .setParent(parent)
            .setScope(scope)
            .setScopeId(scopeId)
            .build();
    return createScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateScopeRequest request =
   *       CreateScopeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setScopeId("scopeId1923941007")
   *           .setScope(Scope.newBuilder().build())
   *           .build();
   *   Scope response = gkeHubClient.createScopeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Scope, OperationMetadata> createScopeAsync(
      CreateScopeRequest request) {
    return createScopeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateScopeRequest request =
   *       CreateScopeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setScopeId("scopeId1923941007")
   *           .setScope(Scope.newBuilder().build())
   *           .build();
   *   OperationFuture<Scope, OperationMetadata> future =
   *       gkeHubClient.createScopeOperationCallable().futureCall(request);
   *   // Do something.
   *   Scope response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateScopeRequest, Scope, OperationMetadata>
      createScopeOperationCallable() {
    return stub.createScopeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateScopeRequest request =
   *       CreateScopeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setScopeId("scopeId1923941007")
   *           .setScope(Scope.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.createScopeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateScopeRequest, Operation> createScopeCallable() {
    return stub.createScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a scopes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   Scope scope = Scope.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Scope response = gkeHubClient.updateScopeAsync(scope, updateMask).get();
   * }
   * }</pre>
   *
   * @param scope Required. A Scope with fields updated. The 'name' field in this namespace is used
   *     to identify the resource to update.
   * @param updateMask Required. The fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Scope, OperationMetadata> updateScopeAsync(
      Scope scope, FieldMask updateMask) {
    UpdateScopeRequest request =
        UpdateScopeRequest.newBuilder().setScope(scope).setUpdateMask(updateMask).build();
    return updateScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a scopes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateScopeRequest request =
   *       UpdateScopeRequest.newBuilder()
   *           .setScope(Scope.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Scope response = gkeHubClient.updateScopeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Scope, OperationMetadata> updateScopeAsync(
      UpdateScopeRequest request) {
    return updateScopeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a scopes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateScopeRequest request =
   *       UpdateScopeRequest.newBuilder()
   *           .setScope(Scope.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Scope, OperationMetadata> future =
   *       gkeHubClient.updateScopeOperationCallable().futureCall(request);
   *   // Do something.
   *   Scope response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateScopeRequest, Scope, OperationMetadata>
      updateScopeOperationCallable() {
    return stub.updateScopeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a scopes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateScopeRequest request =
   *       UpdateScopeRequest.newBuilder()
   *           .setScope(Scope.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.updateScopeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateScopeRequest, Operation> updateScopeCallable() {
    return stub.updateScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ScopeName name = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
   *   gkeHubClient.deleteScopeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Scope resource name in the format
   *     `projects/&#42;/locations/&#42;/scopes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteScopeAsync(ScopeName name) {
    DeleteScopeRequest request =
        DeleteScopeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString();
   *   gkeHubClient.deleteScopeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Scope resource name in the format
   *     `projects/&#42;/locations/&#42;/scopes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteScopeAsync(String name) {
    DeleteScopeRequest request = DeleteScopeRequest.newBuilder().setName(name).build();
    return deleteScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteScopeRequest request =
   *       DeleteScopeRequest.newBuilder()
   *           .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .build();
   *   gkeHubClient.deleteScopeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteScopeAsync(
      DeleteScopeRequest request) {
    return deleteScopeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteScopeRequest request =
   *       DeleteScopeRequest.newBuilder()
   *           .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gkeHubClient.deleteScopeOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteScopeRequest, Empty, OperationMetadata>
      deleteScopeOperationCallable() {
    return stub.deleteScopeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteScopeRequest request =
   *       DeleteScopeRequest.newBuilder()
   *           .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .build();
   *   ApiFuture<Operation> future = gkeHubClient.deleteScopeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteScopeRequest, Operation> deleteScopeCallable() {
    return stub.deleteScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Scopes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Scope element : gkeHubClient.listScopes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Scope will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScopesPagedResponse listScopes(LocationName parent) {
    ListScopesRequest request =
        ListScopesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listScopes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Scopes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Scope element : gkeHubClient.listScopes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Scope will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScopesPagedResponse listScopes(String parent) {
    ListScopesRequest request = ListScopesRequest.newBuilder().setParent(parent).build();
    return listScopes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Scopes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListScopesRequest request =
   *       ListScopesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Scope element : gkeHubClient.listScopes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScopesPagedResponse listScopes(ListScopesRequest request) {
    return listScopesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Scopes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListScopesRequest request =
   *       ListScopesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Scope> future = gkeHubClient.listScopesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Scope element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListScopesRequest, ListScopesPagedResponse> listScopesPagedCallable() {
    return stub.listScopesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Scopes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListScopesRequest request =
   *       ListScopesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListScopesResponse response = gkeHubClient.listScopesCallable().call(request);
   *     for (Scope element : response.getScopesList()) {
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
  public final UnaryCallable<ListScopesRequest, ListScopesResponse> listScopesCallable() {
    return stub.listScopesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists permitted Scopes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Scope element : gkeHubClient.listPermittedScopes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Scope will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPermittedScopesPagedResponse listPermittedScopes(LocationName parent) {
    ListPermittedScopesRequest request =
        ListPermittedScopesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPermittedScopes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists permitted Scopes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Scope element : gkeHubClient.listPermittedScopes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Scope will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPermittedScopesPagedResponse listPermittedScopes(String parent) {
    ListPermittedScopesRequest request =
        ListPermittedScopesRequest.newBuilder().setParent(parent).build();
    return listPermittedScopes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists permitted Scopes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListPermittedScopesRequest request =
   *       ListPermittedScopesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Scope element : gkeHubClient.listPermittedScopes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPermittedScopesPagedResponse listPermittedScopes(
      ListPermittedScopesRequest request) {
    return listPermittedScopesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists permitted Scopes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListPermittedScopesRequest request =
   *       ListPermittedScopesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Scope> future = gkeHubClient.listPermittedScopesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Scope element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPermittedScopesRequest, ListPermittedScopesPagedResponse>
      listPermittedScopesPagedCallable() {
    return stub.listPermittedScopesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists permitted Scopes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListPermittedScopesRequest request =
   *       ListPermittedScopesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPermittedScopesResponse response =
   *         gkeHubClient.listPermittedScopesCallable().call(request);
   *     for (Scope element : response.getScopesList()) {
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
  public final UnaryCallable<ListPermittedScopesRequest, ListPermittedScopesResponse>
      listPermittedScopesCallable() {
    return stub.listPermittedScopesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   MembershipBindingName name =
   *       MembershipBindingName.of(
   *           "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]");
   *   MembershipBinding response = gkeHubClient.getMembershipBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The MembershipBinding resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;/bindings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MembershipBinding getMembershipBinding(MembershipBindingName name) {
    GetMembershipBindingRequest request =
        GetMembershipBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMembershipBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name =
   *       MembershipBindingName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]")
   *           .toString();
   *   MembershipBinding response = gkeHubClient.getMembershipBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The MembershipBinding resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;/bindings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MembershipBinding getMembershipBinding(String name) {
    GetMembershipBindingRequest request =
        GetMembershipBindingRequest.newBuilder().setName(name).build();
    return getMembershipBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetMembershipBindingRequest request =
   *       GetMembershipBindingRequest.newBuilder()
   *           .setName(
   *               MembershipBindingName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]")
   *                   .toString())
   *           .build();
   *   MembershipBinding response = gkeHubClient.getMembershipBinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MembershipBinding getMembershipBinding(GetMembershipBindingRequest request) {
    return getMembershipBindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetMembershipBindingRequest request =
   *       GetMembershipBindingRequest.newBuilder()
   *           .setName(
   *               MembershipBindingName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<MembershipBinding> future =
   *       gkeHubClient.getMembershipBindingCallable().futureCall(request);
   *   // Do something.
   *   MembershipBinding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMembershipBindingRequest, MembershipBinding>
      getMembershipBindingCallable() {
    return stub.getMembershipBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
   *   MembershipBinding membershipBinding = MembershipBinding.newBuilder().build();
   *   String membershipBindingId = "membershipBindingId1360802634";
   *   MembershipBinding response =
   *       gkeHubClient
   *           .createMembershipBindingAsync(parent, membershipBinding, membershipBindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the MembershipBinding will be
   *     created. Specified in the format `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @param membershipBinding Required. The MembershipBinding to create.
   * @param membershipBindingId Required. The ID to use for the MembershipBinding.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MembershipBinding, OperationMetadata> createMembershipBindingAsync(
      MembershipName parent, MembershipBinding membershipBinding, String membershipBindingId) {
    CreateMembershipBindingRequest request =
        CreateMembershipBindingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMembershipBinding(membershipBinding)
            .setMembershipBindingId(membershipBindingId)
            .build();
    return createMembershipBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString();
   *   MembershipBinding membershipBinding = MembershipBinding.newBuilder().build();
   *   String membershipBindingId = "membershipBindingId1360802634";
   *   MembershipBinding response =
   *       gkeHubClient
   *           .createMembershipBindingAsync(parent, membershipBinding, membershipBindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the MembershipBinding will be
   *     created. Specified in the format `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @param membershipBinding Required. The MembershipBinding to create.
   * @param membershipBindingId Required. The ID to use for the MembershipBinding.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MembershipBinding, OperationMetadata> createMembershipBindingAsync(
      String parent, MembershipBinding membershipBinding, String membershipBindingId) {
    CreateMembershipBindingRequest request =
        CreateMembershipBindingRequest.newBuilder()
            .setParent(parent)
            .setMembershipBinding(membershipBinding)
            .setMembershipBindingId(membershipBindingId)
            .build();
    return createMembershipBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateMembershipBindingRequest request =
   *       CreateMembershipBindingRequest.newBuilder()
   *           .setParent(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setMembershipBinding(MembershipBinding.newBuilder().build())
   *           .setMembershipBindingId("membershipBindingId1360802634")
   *           .build();
   *   MembershipBinding response = gkeHubClient.createMembershipBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MembershipBinding, OperationMetadata> createMembershipBindingAsync(
      CreateMembershipBindingRequest request) {
    return createMembershipBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateMembershipBindingRequest request =
   *       CreateMembershipBindingRequest.newBuilder()
   *           .setParent(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setMembershipBinding(MembershipBinding.newBuilder().build())
   *           .setMembershipBindingId("membershipBindingId1360802634")
   *           .build();
   *   OperationFuture<MembershipBinding, OperationMetadata> future =
   *       gkeHubClient.createMembershipBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   MembershipBinding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateMembershipBindingRequest, MembershipBinding, OperationMetadata>
      createMembershipBindingOperationCallable() {
    return stub.createMembershipBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateMembershipBindingRequest request =
   *       CreateMembershipBindingRequest.newBuilder()
   *           .setParent(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setMembershipBinding(MembershipBinding.newBuilder().build())
   *           .setMembershipBindingId("membershipBindingId1360802634")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gkeHubClient.createMembershipBindingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMembershipBindingRequest, Operation>
      createMembershipBindingCallable() {
    return stub.createMembershipBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   MembershipBinding membershipBinding = MembershipBinding.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MembershipBinding response =
   *       gkeHubClient.updateMembershipBindingAsync(membershipBinding, updateMask).get();
   * }
   * }</pre>
   *
   * @param membershipBinding Required. The MembershipBinding object with fields updated.
   * @param updateMask Required. The fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MembershipBinding, OperationMetadata> updateMembershipBindingAsync(
      MembershipBinding membershipBinding, FieldMask updateMask) {
    UpdateMembershipBindingRequest request =
        UpdateMembershipBindingRequest.newBuilder()
            .setMembershipBinding(membershipBinding)
            .setUpdateMask(updateMask)
            .build();
    return updateMembershipBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateMembershipBindingRequest request =
   *       UpdateMembershipBindingRequest.newBuilder()
   *           .setMembershipBinding(MembershipBinding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   MembershipBinding response = gkeHubClient.updateMembershipBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MembershipBinding, OperationMetadata> updateMembershipBindingAsync(
      UpdateMembershipBindingRequest request) {
    return updateMembershipBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateMembershipBindingRequest request =
   *       UpdateMembershipBindingRequest.newBuilder()
   *           .setMembershipBinding(MembershipBinding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<MembershipBinding, OperationMetadata> future =
   *       gkeHubClient.updateMembershipBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   MembershipBinding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateMembershipBindingRequest, MembershipBinding, OperationMetadata>
      updateMembershipBindingOperationCallable() {
    return stub.updateMembershipBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateMembershipBindingRequest request =
   *       UpdateMembershipBindingRequest.newBuilder()
   *           .setMembershipBinding(MembershipBinding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gkeHubClient.updateMembershipBindingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMembershipBindingRequest, Operation>
      updateMembershipBindingCallable() {
    return stub.updateMembershipBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   MembershipBindingName name =
   *       MembershipBindingName.of(
   *           "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]");
   *   gkeHubClient.deleteMembershipBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The MembershipBinding resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;/bindings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMembershipBindingAsync(
      MembershipBindingName name) {
    DeleteMembershipBindingRequest request =
        DeleteMembershipBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteMembershipBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name =
   *       MembershipBindingName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]")
   *           .toString();
   *   gkeHubClient.deleteMembershipBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The MembershipBinding resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;/bindings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMembershipBindingAsync(String name) {
    DeleteMembershipBindingRequest request =
        DeleteMembershipBindingRequest.newBuilder().setName(name).build();
    return deleteMembershipBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteMembershipBindingRequest request =
   *       DeleteMembershipBindingRequest.newBuilder()
   *           .setName(
   *               MembershipBindingName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]")
   *                   .toString())
   *           .build();
   *   gkeHubClient.deleteMembershipBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMembershipBindingAsync(
      DeleteMembershipBindingRequest request) {
    return deleteMembershipBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteMembershipBindingRequest request =
   *       DeleteMembershipBindingRequest.newBuilder()
   *           .setName(
   *               MembershipBindingName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gkeHubClient.deleteMembershipBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteMembershipBindingRequest, Empty, OperationMetadata>
      deleteMembershipBindingOperationCallable() {
    return stub.deleteMembershipBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a MembershipBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteMembershipBindingRequest request =
   *       DeleteMembershipBindingRequest.newBuilder()
   *           .setName(
   *               MembershipBindingName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[MEMBERSHIPBINDING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gkeHubClient.deleteMembershipBindingCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMembershipBindingRequest, Operation>
      deleteMembershipBindingCallable() {
    return stub.deleteMembershipBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MembershipBindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
   *   for (MembershipBinding element : gkeHubClient.listMembershipBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent Membership for which the MembershipBindings will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembershipBindingsPagedResponse listMembershipBindings(MembershipName parent) {
    ListMembershipBindingsRequest request =
        ListMembershipBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMembershipBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MembershipBindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString();
   *   for (MembershipBinding element : gkeHubClient.listMembershipBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent Membership for which the MembershipBindings will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembershipBindingsPagedResponse listMembershipBindings(String parent) {
    ListMembershipBindingsRequest request =
        ListMembershipBindingsRequest.newBuilder().setParent(parent).build();
    return listMembershipBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MembershipBindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListMembershipBindingsRequest request =
   *       ListMembershipBindingsRequest.newBuilder()
   *           .setParent(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (MembershipBinding element : gkeHubClient.listMembershipBindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembershipBindingsPagedResponse listMembershipBindings(
      ListMembershipBindingsRequest request) {
    return listMembershipBindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MembershipBindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListMembershipBindingsRequest request =
   *       ListMembershipBindingsRequest.newBuilder()
   *           .setParent(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<MembershipBinding> future =
   *       gkeHubClient.listMembershipBindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MembershipBinding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMembershipBindingsRequest, ListMembershipBindingsPagedResponse>
      listMembershipBindingsPagedCallable() {
    return stub.listMembershipBindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MembershipBindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListMembershipBindingsRequest request =
   *       ListMembershipBindingsRequest.newBuilder()
   *           .setParent(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListMembershipBindingsResponse response =
   *         gkeHubClient.listMembershipBindingsCallable().call(request);
   *     for (MembershipBinding element : response.getMembershipBindingsList()) {
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
  public final UnaryCallable<ListMembershipBindingsRequest, ListMembershipBindingsResponse>
      listMembershipBindingsCallable() {
    return stub.listMembershipBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   RBACRoleBindingName name =
   *       RBACRoleBindingName.ofProjectLocationMembershipRbacrolebindingName(
   *           "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[RBACROLEBINDING]");
   *   RBACRoleBinding response = gkeHubClient.getMembershipRBACRoleBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The RBACRoleBinding resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;/rbacrolebindings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RBACRoleBinding getMembershipRBACRoleBinding(RBACRoleBindingName name) {
    GetMembershipRBACRoleBindingRequest request =
        GetMembershipRBACRoleBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMembershipRBACRoleBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name =
   *       RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
   *               "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
   *           .toString();
   *   RBACRoleBinding response = gkeHubClient.getMembershipRBACRoleBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The RBACRoleBinding resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;/rbacrolebindings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RBACRoleBinding getMembershipRBACRoleBinding(String name) {
    GetMembershipRBACRoleBindingRequest request =
        GetMembershipRBACRoleBindingRequest.newBuilder().setName(name).build();
    return getMembershipRBACRoleBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetMembershipRBACRoleBindingRequest request =
   *       GetMembershipRBACRoleBindingRequest.newBuilder()
   *           .setName(
   *               RBACRoleBindingName.ofProjectLocationMembershipRbacrolebindingName(
   *                       "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[RBACROLEBINDING]")
   *                   .toString())
   *           .build();
   *   RBACRoleBinding response = gkeHubClient.getMembershipRBACRoleBinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RBACRoleBinding getMembershipRBACRoleBinding(
      GetMembershipRBACRoleBindingRequest request) {
    return getMembershipRBACRoleBindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GetMembershipRBACRoleBindingRequest request =
   *       GetMembershipRBACRoleBindingRequest.newBuilder()
   *           .setName(
   *               RBACRoleBindingName.ofProjectLocationMembershipRbacrolebindingName(
   *                       "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[RBACROLEBINDING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<RBACRoleBinding> future =
   *       gkeHubClient.getMembershipRBACRoleBindingCallable().futureCall(request);
   *   // Do something.
   *   RBACRoleBinding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMembershipRBACRoleBindingRequest, RBACRoleBinding>
      getMembershipRBACRoleBindingCallable() {
    return stub.getMembershipRBACRoleBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
   *   RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
   *   String rbacrolebindingId = "rbacrolebindingId827577784";
   *   RBACRoleBinding response =
   *       gkeHubClient
   *           .createMembershipRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the RBACRoleBinding will be
   *     created. Specified in the format `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @param rbacrolebinding Required. The rbacrolebindings to create.
   * @param rbacrolebindingId Required. Client chosen ID for the RBACRoleBinding.
   *     `rbacrolebinding_id` must be a valid RFC 1123 compliant DNS label:
   *     <p>1. At most 63 characters in length 2. It must consist of lower case alphanumeric
   *     characters or `-` 3. It must start and end with an alphanumeric character
   *     <p>Which can be expressed as the regex: `[a-z0-9]([-a-z0-9]&#42;[a-z0-9])?`, with a maximum
   *     length of 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RBACRoleBinding, OperationMetadata>
      createMembershipRBACRoleBindingAsync(
          MembershipName parent, RBACRoleBinding rbacrolebinding, String rbacrolebindingId) {
    CreateMembershipRBACRoleBindingRequest request =
        CreateMembershipRBACRoleBindingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRbacrolebinding(rbacrolebinding)
            .setRbacrolebindingId(rbacrolebindingId)
            .build();
    return createMembershipRBACRoleBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
   *   RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
   *   String rbacrolebindingId = "rbacrolebindingId827577784";
   *   RBACRoleBinding response =
   *       gkeHubClient
   *           .createMembershipRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the RBACRoleBinding will be
   *     created. Specified in the format `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @param rbacrolebinding Required. The rbacrolebindings to create.
   * @param rbacrolebindingId Required. Client chosen ID for the RBACRoleBinding.
   *     `rbacrolebinding_id` must be a valid RFC 1123 compliant DNS label:
   *     <p>1. At most 63 characters in length 2. It must consist of lower case alphanumeric
   *     characters or `-` 3. It must start and end with an alphanumeric character
   *     <p>Which can be expressed as the regex: `[a-z0-9]([-a-z0-9]&#42;[a-z0-9])?`, with a maximum
   *     length of 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RBACRoleBinding, OperationMetadata>
      createMembershipRBACRoleBindingAsync(
          ScopeName parent, RBACRoleBinding rbacrolebinding, String rbacrolebindingId) {
    CreateMembershipRBACRoleBindingRequest request =
        CreateMembershipRBACRoleBindingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRbacrolebinding(rbacrolebinding)
            .setRbacrolebindingId(rbacrolebindingId)
            .build();
    return createMembershipRBACRoleBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString();
   *   RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
   *   String rbacrolebindingId = "rbacrolebindingId827577784";
   *   RBACRoleBinding response =
   *       gkeHubClient
   *           .createMembershipRBACRoleBindingAsync(parent, rbacrolebinding, rbacrolebindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the RBACRoleBinding will be
   *     created. Specified in the format `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @param rbacrolebinding Required. The rbacrolebindings to create.
   * @param rbacrolebindingId Required. Client chosen ID for the RBACRoleBinding.
   *     `rbacrolebinding_id` must be a valid RFC 1123 compliant DNS label:
   *     <p>1. At most 63 characters in length 2. It must consist of lower case alphanumeric
   *     characters or `-` 3. It must start and end with an alphanumeric character
   *     <p>Which can be expressed as the regex: `[a-z0-9]([-a-z0-9]&#42;[a-z0-9])?`, with a maximum
   *     length of 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RBACRoleBinding, OperationMetadata>
      createMembershipRBACRoleBindingAsync(
          String parent, RBACRoleBinding rbacrolebinding, String rbacrolebindingId) {
    CreateMembershipRBACRoleBindingRequest request =
        CreateMembershipRBACRoleBindingRequest.newBuilder()
            .setParent(parent)
            .setRbacrolebinding(rbacrolebinding)
            .setRbacrolebindingId(rbacrolebindingId)
            .build();
    return createMembershipRBACRoleBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateMembershipRBACRoleBindingRequest request =
   *       CreateMembershipRBACRoleBindingRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setRbacrolebindingId("rbacrolebindingId827577784")
   *           .setRbacrolebinding(RBACRoleBinding.newBuilder().build())
   *           .build();
   *   RBACRoleBinding response = gkeHubClient.createMembershipRBACRoleBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RBACRoleBinding, OperationMetadata>
      createMembershipRBACRoleBindingAsync(CreateMembershipRBACRoleBindingRequest request) {
    return createMembershipRBACRoleBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateMembershipRBACRoleBindingRequest request =
   *       CreateMembershipRBACRoleBindingRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setRbacrolebindingId("rbacrolebindingId827577784")
   *           .setRbacrolebinding(RBACRoleBinding.newBuilder().build())
   *           .build();
   *   OperationFuture<RBACRoleBinding, OperationMetadata> future =
   *       gkeHubClient.createMembershipRBACRoleBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   RBACRoleBinding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      createMembershipRBACRoleBindingOperationCallable() {
    return stub.createMembershipRBACRoleBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   CreateMembershipRBACRoleBindingRequest request =
   *       CreateMembershipRBACRoleBindingRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setRbacrolebindingId("rbacrolebindingId827577784")
   *           .setRbacrolebinding(RBACRoleBinding.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gkeHubClient.createMembershipRBACRoleBindingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMembershipRBACRoleBindingRequest, Operation>
      createMembershipRBACRoleBindingCallable() {
    return stub.createMembershipRBACRoleBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   RBACRoleBinding rbacrolebinding = RBACRoleBinding.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   RBACRoleBinding response =
   *       gkeHubClient.updateMembershipRBACRoleBindingAsync(rbacrolebinding, updateMask).get();
   * }
   * }</pre>
   *
   * @param rbacrolebinding Required. A rbacrolebinding with fields updated. The 'name' field in
   *     this rbacrolebinding is used to identify the resource to update.
   * @param updateMask Required. The fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RBACRoleBinding, OperationMetadata>
      updateMembershipRBACRoleBindingAsync(RBACRoleBinding rbacrolebinding, FieldMask updateMask) {
    UpdateMembershipRBACRoleBindingRequest request =
        UpdateMembershipRBACRoleBindingRequest.newBuilder()
            .setRbacrolebinding(rbacrolebinding)
            .setUpdateMask(updateMask)
            .build();
    return updateMembershipRBACRoleBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateMembershipRBACRoleBindingRequest request =
   *       UpdateMembershipRBACRoleBindingRequest.newBuilder()
   *           .setRbacrolebinding(RBACRoleBinding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   RBACRoleBinding response = gkeHubClient.updateMembershipRBACRoleBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RBACRoleBinding, OperationMetadata>
      updateMembershipRBACRoleBindingAsync(UpdateMembershipRBACRoleBindingRequest request) {
    return updateMembershipRBACRoleBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateMembershipRBACRoleBindingRequest request =
   *       UpdateMembershipRBACRoleBindingRequest.newBuilder()
   *           .setRbacrolebinding(RBACRoleBinding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<RBACRoleBinding, OperationMetadata> future =
   *       gkeHubClient.updateMembershipRBACRoleBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   RBACRoleBinding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateMembershipRBACRoleBindingRequest, RBACRoleBinding, OperationMetadata>
      updateMembershipRBACRoleBindingOperationCallable() {
    return stub.updateMembershipRBACRoleBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   UpdateMembershipRBACRoleBindingRequest request =
   *       UpdateMembershipRBACRoleBindingRequest.newBuilder()
   *           .setRbacrolebinding(RBACRoleBinding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gkeHubClient.updateMembershipRBACRoleBindingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMembershipRBACRoleBindingRequest, Operation>
      updateMembershipRBACRoleBindingCallable() {
    return stub.updateMembershipRBACRoleBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   RBACRoleBindingName name =
   *       RBACRoleBindingName.ofProjectLocationMembershipRbacrolebindingName(
   *           "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[RBACROLEBINDING]");
   *   gkeHubClient.deleteMembershipRBACRoleBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The RBACRoleBinding resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;/rbacrolebindings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMembershipRBACRoleBindingAsync(
      RBACRoleBindingName name) {
    DeleteMembershipRBACRoleBindingRequest request =
        DeleteMembershipRBACRoleBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteMembershipRBACRoleBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String name =
   *       RBACRoleBindingName.ofProjectLocationScopeRbacrolebindingName(
   *               "[PROJECT]", "[LOCATION]", "[SCOPE]", "[RBACROLEBINDING]")
   *           .toString();
   *   gkeHubClient.deleteMembershipRBACRoleBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The RBACRoleBinding resource name in the format
   *     `projects/&#42;/locations/&#42;/memberships/&#42;/rbacrolebindings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMembershipRBACRoleBindingAsync(
      String name) {
    DeleteMembershipRBACRoleBindingRequest request =
        DeleteMembershipRBACRoleBindingRequest.newBuilder().setName(name).build();
    return deleteMembershipRBACRoleBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteMembershipRBACRoleBindingRequest request =
   *       DeleteMembershipRBACRoleBindingRequest.newBuilder()
   *           .setName(
   *               RBACRoleBindingName.ofProjectLocationMembershipRbacrolebindingName(
   *                       "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[RBACROLEBINDING]")
   *                   .toString())
   *           .build();
   *   gkeHubClient.deleteMembershipRBACRoleBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMembershipRBACRoleBindingAsync(
      DeleteMembershipRBACRoleBindingRequest request) {
    return deleteMembershipRBACRoleBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteMembershipRBACRoleBindingRequest request =
   *       DeleteMembershipRBACRoleBindingRequest.newBuilder()
   *           .setName(
   *               RBACRoleBindingName.ofProjectLocationMembershipRbacrolebindingName(
   *                       "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[RBACROLEBINDING]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gkeHubClient.deleteMembershipRBACRoleBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteMembershipRBACRoleBindingRequest, Empty, OperationMetadata>
      deleteMembershipRBACRoleBindingOperationCallable() {
    return stub.deleteMembershipRBACRoleBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Membership RBACRoleBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   DeleteMembershipRBACRoleBindingRequest request =
   *       DeleteMembershipRBACRoleBindingRequest.newBuilder()
   *           .setName(
   *               RBACRoleBindingName.ofProjectLocationMembershipRbacrolebindingName(
   *                       "[PROJECT]", "[LOCATION]", "[MEMBERSHIP]", "[RBACROLEBINDING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gkeHubClient.deleteMembershipRBACRoleBindingCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMembershipRBACRoleBindingRequest, Operation>
      deleteMembershipRBACRoleBindingCallable() {
    return stub.deleteMembershipRBACRoleBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Membership RBACRoleBindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   MembershipName parent = MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]");
   *   for (RBACRoleBinding element :
   *       gkeHubClient.listMembershipRBACRoleBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Features will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembershipRBACRoleBindingsPagedResponse listMembershipRBACRoleBindings(
      MembershipName parent) {
    ListMembershipRBACRoleBindingsRequest request =
        ListMembershipRBACRoleBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMembershipRBACRoleBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Membership RBACRoleBindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ScopeName parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
   *   for (RBACRoleBinding element :
   *       gkeHubClient.listMembershipRBACRoleBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Features will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembershipRBACRoleBindingsPagedResponse listMembershipRBACRoleBindings(
      ScopeName parent) {
    ListMembershipRBACRoleBindingsRequest request =
        ListMembershipRBACRoleBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMembershipRBACRoleBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Membership RBACRoleBindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   String parent = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString();
   *   for (RBACRoleBinding element :
   *       gkeHubClient.listMembershipRBACRoleBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) where the Features will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;/memberships/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembershipRBACRoleBindingsPagedResponse listMembershipRBACRoleBindings(
      String parent) {
    ListMembershipRBACRoleBindingsRequest request =
        ListMembershipRBACRoleBindingsRequest.newBuilder().setParent(parent).build();
    return listMembershipRBACRoleBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Membership RBACRoleBindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListMembershipRBACRoleBindingsRequest request =
   *       ListMembershipRBACRoleBindingsRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (RBACRoleBinding element :
   *       gkeHubClient.listMembershipRBACRoleBindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembershipRBACRoleBindingsPagedResponse listMembershipRBACRoleBindings(
      ListMembershipRBACRoleBindingsRequest request) {
    return listMembershipRBACRoleBindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Membership RBACRoleBindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListMembershipRBACRoleBindingsRequest request =
   *       ListMembershipRBACRoleBindingsRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<RBACRoleBinding> future =
   *       gkeHubClient.listMembershipRBACRoleBindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RBACRoleBinding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListMembershipRBACRoleBindingsRequest, ListMembershipRBACRoleBindingsPagedResponse>
      listMembershipRBACRoleBindingsPagedCallable() {
    return stub.listMembershipRBACRoleBindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Membership RBACRoleBindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   ListMembershipRBACRoleBindingsRequest request =
   *       ListMembershipRBACRoleBindingsRequest.newBuilder()
   *           .setParent(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMembershipRBACRoleBindingsResponse response =
   *         gkeHubClient.listMembershipRBACRoleBindingsCallable().call(request);
   *     for (RBACRoleBinding element : response.getRbacrolebindingsList()) {
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
  public final UnaryCallable<
          ListMembershipRBACRoleBindingsRequest, ListMembershipRBACRoleBindingsResponse>
      listMembershipRBACRoleBindingsCallable() {
    return stub.listMembershipRBACRoleBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a YAML of the RBAC policies for the specified RoleBinding and its associated
   * impersonation resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GenerateMembershipRBACRoleBindingYAMLRequest request =
   *       GenerateMembershipRBACRoleBindingYAMLRequest.newBuilder()
   *           .setParent(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setRbacrolebindingId("rbacrolebindingId827577784")
   *           .setRbacrolebinding(RBACRoleBinding.newBuilder().build())
   *           .build();
   *   GenerateMembershipRBACRoleBindingYAMLResponse response =
   *       gkeHubClient.generateMembershipRBACRoleBindingYAML(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateMembershipRBACRoleBindingYAMLResponse generateMembershipRBACRoleBindingYAML(
      GenerateMembershipRBACRoleBindingYAMLRequest request) {
    return generateMembershipRBACRoleBindingYAMLCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a YAML of the RBAC policies for the specified RoleBinding and its associated
   * impersonation resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
   *   GenerateMembershipRBACRoleBindingYAMLRequest request =
   *       GenerateMembershipRBACRoleBindingYAMLRequest.newBuilder()
   *           .setParent(MembershipName.of("[PROJECT]", "[LOCATION]", "[MEMBERSHIP]").toString())
   *           .setRbacrolebindingId("rbacrolebindingId827577784")
   *           .setRbacrolebinding(RBACRoleBinding.newBuilder().build())
   *           .build();
   *   ApiFuture<GenerateMembershipRBACRoleBindingYAMLResponse> future =
   *       gkeHubClient.generateMembershipRBACRoleBindingYAMLCallable().futureCall(request);
   *   // Do something.
   *   GenerateMembershipRBACRoleBindingYAMLResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GenerateMembershipRBACRoleBindingYAMLRequest,
          GenerateMembershipRBACRoleBindingYAMLResponse>
      generateMembershipRBACRoleBindingYAMLCallable() {
    return stub.generateMembershipRBACRoleBindingYAMLCallable();
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

  public static class ListMembershipsPagedResponse
      extends AbstractPagedListResponse<
          ListMembershipsRequest,
          ListMembershipsResponse,
          Membership,
          ListMembershipsPage,
          ListMembershipsFixedSizeCollection> {

    public static ApiFuture<ListMembershipsPagedResponse> createAsync(
        PageContext<ListMembershipsRequest, ListMembershipsResponse, Membership> context,
        ApiFuture<ListMembershipsResponse> futureResponse) {
      ApiFuture<ListMembershipsPage> futurePage =
          ListMembershipsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMembershipsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMembershipsPagedResponse(ListMembershipsPage page) {
      super(page, ListMembershipsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMembershipsPage
      extends AbstractPage<
          ListMembershipsRequest, ListMembershipsResponse, Membership, ListMembershipsPage> {

    private ListMembershipsPage(
        PageContext<ListMembershipsRequest, ListMembershipsResponse, Membership> context,
        ListMembershipsResponse response) {
      super(context, response);
    }

    private static ListMembershipsPage createEmptyPage() {
      return new ListMembershipsPage(null, null);
    }

    @Override
    protected ListMembershipsPage createPage(
        PageContext<ListMembershipsRequest, ListMembershipsResponse, Membership> context,
        ListMembershipsResponse response) {
      return new ListMembershipsPage(context, response);
    }

    @Override
    public ApiFuture<ListMembershipsPage> createPageAsync(
        PageContext<ListMembershipsRequest, ListMembershipsResponse, Membership> context,
        ApiFuture<ListMembershipsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMembershipsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMembershipsRequest,
          ListMembershipsResponse,
          Membership,
          ListMembershipsPage,
          ListMembershipsFixedSizeCollection> {

    private ListMembershipsFixedSizeCollection(
        List<ListMembershipsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMembershipsFixedSizeCollection createEmptyCollection() {
      return new ListMembershipsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMembershipsFixedSizeCollection createCollection(
        List<ListMembershipsPage> pages, int collectionSize) {
      return new ListMembershipsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBoundMembershipsPagedResponse
      extends AbstractPagedListResponse<
          ListBoundMembershipsRequest,
          ListBoundMembershipsResponse,
          Membership,
          ListBoundMembershipsPage,
          ListBoundMembershipsFixedSizeCollection> {

    public static ApiFuture<ListBoundMembershipsPagedResponse> createAsync(
        PageContext<ListBoundMembershipsRequest, ListBoundMembershipsResponse, Membership> context,
        ApiFuture<ListBoundMembershipsResponse> futureResponse) {
      ApiFuture<ListBoundMembershipsPage> futurePage =
          ListBoundMembershipsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBoundMembershipsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBoundMembershipsPagedResponse(ListBoundMembershipsPage page) {
      super(page, ListBoundMembershipsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBoundMembershipsPage
      extends AbstractPage<
          ListBoundMembershipsRequest,
          ListBoundMembershipsResponse,
          Membership,
          ListBoundMembershipsPage> {

    private ListBoundMembershipsPage(
        PageContext<ListBoundMembershipsRequest, ListBoundMembershipsResponse, Membership> context,
        ListBoundMembershipsResponse response) {
      super(context, response);
    }

    private static ListBoundMembershipsPage createEmptyPage() {
      return new ListBoundMembershipsPage(null, null);
    }

    @Override
    protected ListBoundMembershipsPage createPage(
        PageContext<ListBoundMembershipsRequest, ListBoundMembershipsResponse, Membership> context,
        ListBoundMembershipsResponse response) {
      return new ListBoundMembershipsPage(context, response);
    }

    @Override
    public ApiFuture<ListBoundMembershipsPage> createPageAsync(
        PageContext<ListBoundMembershipsRequest, ListBoundMembershipsResponse, Membership> context,
        ApiFuture<ListBoundMembershipsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBoundMembershipsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBoundMembershipsRequest,
          ListBoundMembershipsResponse,
          Membership,
          ListBoundMembershipsPage,
          ListBoundMembershipsFixedSizeCollection> {

    private ListBoundMembershipsFixedSizeCollection(
        List<ListBoundMembershipsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBoundMembershipsFixedSizeCollection createEmptyCollection() {
      return new ListBoundMembershipsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBoundMembershipsFixedSizeCollection createCollection(
        List<ListBoundMembershipsPage> pages, int collectionSize) {
      return new ListBoundMembershipsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFeaturesPagedResponse
      extends AbstractPagedListResponse<
          ListFeaturesRequest,
          ListFeaturesResponse,
          Feature,
          ListFeaturesPage,
          ListFeaturesFixedSizeCollection> {

    public static ApiFuture<ListFeaturesPagedResponse> createAsync(
        PageContext<ListFeaturesRequest, ListFeaturesResponse, Feature> context,
        ApiFuture<ListFeaturesResponse> futureResponse) {
      ApiFuture<ListFeaturesPage> futurePage =
          ListFeaturesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFeaturesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFeaturesPagedResponse(ListFeaturesPage page) {
      super(page, ListFeaturesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFeaturesPage
      extends AbstractPage<ListFeaturesRequest, ListFeaturesResponse, Feature, ListFeaturesPage> {

    private ListFeaturesPage(
        PageContext<ListFeaturesRequest, ListFeaturesResponse, Feature> context,
        ListFeaturesResponse response) {
      super(context, response);
    }

    private static ListFeaturesPage createEmptyPage() {
      return new ListFeaturesPage(null, null);
    }

    @Override
    protected ListFeaturesPage createPage(
        PageContext<ListFeaturesRequest, ListFeaturesResponse, Feature> context,
        ListFeaturesResponse response) {
      return new ListFeaturesPage(context, response);
    }

    @Override
    public ApiFuture<ListFeaturesPage> createPageAsync(
        PageContext<ListFeaturesRequest, ListFeaturesResponse, Feature> context,
        ApiFuture<ListFeaturesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFeaturesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFeaturesRequest,
          ListFeaturesResponse,
          Feature,
          ListFeaturesPage,
          ListFeaturesFixedSizeCollection> {

    private ListFeaturesFixedSizeCollection(List<ListFeaturesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFeaturesFixedSizeCollection createEmptyCollection() {
      return new ListFeaturesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFeaturesFixedSizeCollection createCollection(
        List<ListFeaturesPage> pages, int collectionSize) {
      return new ListFeaturesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFleetsPagedResponse
      extends AbstractPagedListResponse<
          ListFleetsRequest,
          ListFleetsResponse,
          Fleet,
          ListFleetsPage,
          ListFleetsFixedSizeCollection> {

    public static ApiFuture<ListFleetsPagedResponse> createAsync(
        PageContext<ListFleetsRequest, ListFleetsResponse, Fleet> context,
        ApiFuture<ListFleetsResponse> futureResponse) {
      ApiFuture<ListFleetsPage> futurePage =
          ListFleetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListFleetsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListFleetsPagedResponse(ListFleetsPage page) {
      super(page, ListFleetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFleetsPage
      extends AbstractPage<ListFleetsRequest, ListFleetsResponse, Fleet, ListFleetsPage> {

    private ListFleetsPage(
        PageContext<ListFleetsRequest, ListFleetsResponse, Fleet> context,
        ListFleetsResponse response) {
      super(context, response);
    }

    private static ListFleetsPage createEmptyPage() {
      return new ListFleetsPage(null, null);
    }

    @Override
    protected ListFleetsPage createPage(
        PageContext<ListFleetsRequest, ListFleetsResponse, Fleet> context,
        ListFleetsResponse response) {
      return new ListFleetsPage(context, response);
    }

    @Override
    public ApiFuture<ListFleetsPage> createPageAsync(
        PageContext<ListFleetsRequest, ListFleetsResponse, Fleet> context,
        ApiFuture<ListFleetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFleetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFleetsRequest,
          ListFleetsResponse,
          Fleet,
          ListFleetsPage,
          ListFleetsFixedSizeCollection> {

    private ListFleetsFixedSizeCollection(List<ListFleetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFleetsFixedSizeCollection createEmptyCollection() {
      return new ListFleetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFleetsFixedSizeCollection createCollection(
        List<ListFleetsPage> pages, int collectionSize) {
      return new ListFleetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListScopeNamespacesPagedResponse
      extends AbstractPagedListResponse<
          ListScopeNamespacesRequest,
          ListScopeNamespacesResponse,
          Namespace,
          ListScopeNamespacesPage,
          ListScopeNamespacesFixedSizeCollection> {

    public static ApiFuture<ListScopeNamespacesPagedResponse> createAsync(
        PageContext<ListScopeNamespacesRequest, ListScopeNamespacesResponse, Namespace> context,
        ApiFuture<ListScopeNamespacesResponse> futureResponse) {
      ApiFuture<ListScopeNamespacesPage> futurePage =
          ListScopeNamespacesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListScopeNamespacesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListScopeNamespacesPagedResponse(ListScopeNamespacesPage page) {
      super(page, ListScopeNamespacesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListScopeNamespacesPage
      extends AbstractPage<
          ListScopeNamespacesRequest,
          ListScopeNamespacesResponse,
          Namespace,
          ListScopeNamespacesPage> {

    private ListScopeNamespacesPage(
        PageContext<ListScopeNamespacesRequest, ListScopeNamespacesResponse, Namespace> context,
        ListScopeNamespacesResponse response) {
      super(context, response);
    }

    private static ListScopeNamespacesPage createEmptyPage() {
      return new ListScopeNamespacesPage(null, null);
    }

    @Override
    protected ListScopeNamespacesPage createPage(
        PageContext<ListScopeNamespacesRequest, ListScopeNamespacesResponse, Namespace> context,
        ListScopeNamespacesResponse response) {
      return new ListScopeNamespacesPage(context, response);
    }

    @Override
    public ApiFuture<ListScopeNamespacesPage> createPageAsync(
        PageContext<ListScopeNamespacesRequest, ListScopeNamespacesResponse, Namespace> context,
        ApiFuture<ListScopeNamespacesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListScopeNamespacesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListScopeNamespacesRequest,
          ListScopeNamespacesResponse,
          Namespace,
          ListScopeNamespacesPage,
          ListScopeNamespacesFixedSizeCollection> {

    private ListScopeNamespacesFixedSizeCollection(
        List<ListScopeNamespacesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListScopeNamespacesFixedSizeCollection createEmptyCollection() {
      return new ListScopeNamespacesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListScopeNamespacesFixedSizeCollection createCollection(
        List<ListScopeNamespacesPage> pages, int collectionSize) {
      return new ListScopeNamespacesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListScopeRBACRoleBindingsPagedResponse
      extends AbstractPagedListResponse<
          ListScopeRBACRoleBindingsRequest,
          ListScopeRBACRoleBindingsResponse,
          RBACRoleBinding,
          ListScopeRBACRoleBindingsPage,
          ListScopeRBACRoleBindingsFixedSizeCollection> {

    public static ApiFuture<ListScopeRBACRoleBindingsPagedResponse> createAsync(
        PageContext<
                ListScopeRBACRoleBindingsRequest,
                ListScopeRBACRoleBindingsResponse,
                RBACRoleBinding>
            context,
        ApiFuture<ListScopeRBACRoleBindingsResponse> futureResponse) {
      ApiFuture<ListScopeRBACRoleBindingsPage> futurePage =
          ListScopeRBACRoleBindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListScopeRBACRoleBindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListScopeRBACRoleBindingsPagedResponse(ListScopeRBACRoleBindingsPage page) {
      super(page, ListScopeRBACRoleBindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListScopeRBACRoleBindingsPage
      extends AbstractPage<
          ListScopeRBACRoleBindingsRequest,
          ListScopeRBACRoleBindingsResponse,
          RBACRoleBinding,
          ListScopeRBACRoleBindingsPage> {

    private ListScopeRBACRoleBindingsPage(
        PageContext<
                ListScopeRBACRoleBindingsRequest,
                ListScopeRBACRoleBindingsResponse,
                RBACRoleBinding>
            context,
        ListScopeRBACRoleBindingsResponse response) {
      super(context, response);
    }

    private static ListScopeRBACRoleBindingsPage createEmptyPage() {
      return new ListScopeRBACRoleBindingsPage(null, null);
    }

    @Override
    protected ListScopeRBACRoleBindingsPage createPage(
        PageContext<
                ListScopeRBACRoleBindingsRequest,
                ListScopeRBACRoleBindingsResponse,
                RBACRoleBinding>
            context,
        ListScopeRBACRoleBindingsResponse response) {
      return new ListScopeRBACRoleBindingsPage(context, response);
    }

    @Override
    public ApiFuture<ListScopeRBACRoleBindingsPage> createPageAsync(
        PageContext<
                ListScopeRBACRoleBindingsRequest,
                ListScopeRBACRoleBindingsResponse,
                RBACRoleBinding>
            context,
        ApiFuture<ListScopeRBACRoleBindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListScopeRBACRoleBindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListScopeRBACRoleBindingsRequest,
          ListScopeRBACRoleBindingsResponse,
          RBACRoleBinding,
          ListScopeRBACRoleBindingsPage,
          ListScopeRBACRoleBindingsFixedSizeCollection> {

    private ListScopeRBACRoleBindingsFixedSizeCollection(
        List<ListScopeRBACRoleBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListScopeRBACRoleBindingsFixedSizeCollection createEmptyCollection() {
      return new ListScopeRBACRoleBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListScopeRBACRoleBindingsFixedSizeCollection createCollection(
        List<ListScopeRBACRoleBindingsPage> pages, int collectionSize) {
      return new ListScopeRBACRoleBindingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListScopesPagedResponse
      extends AbstractPagedListResponse<
          ListScopesRequest,
          ListScopesResponse,
          Scope,
          ListScopesPage,
          ListScopesFixedSizeCollection> {

    public static ApiFuture<ListScopesPagedResponse> createAsync(
        PageContext<ListScopesRequest, ListScopesResponse, Scope> context,
        ApiFuture<ListScopesResponse> futureResponse) {
      ApiFuture<ListScopesPage> futurePage =
          ListScopesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListScopesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListScopesPagedResponse(ListScopesPage page) {
      super(page, ListScopesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListScopesPage
      extends AbstractPage<ListScopesRequest, ListScopesResponse, Scope, ListScopesPage> {

    private ListScopesPage(
        PageContext<ListScopesRequest, ListScopesResponse, Scope> context,
        ListScopesResponse response) {
      super(context, response);
    }

    private static ListScopesPage createEmptyPage() {
      return new ListScopesPage(null, null);
    }

    @Override
    protected ListScopesPage createPage(
        PageContext<ListScopesRequest, ListScopesResponse, Scope> context,
        ListScopesResponse response) {
      return new ListScopesPage(context, response);
    }

    @Override
    public ApiFuture<ListScopesPage> createPageAsync(
        PageContext<ListScopesRequest, ListScopesResponse, Scope> context,
        ApiFuture<ListScopesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListScopesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListScopesRequest,
          ListScopesResponse,
          Scope,
          ListScopesPage,
          ListScopesFixedSizeCollection> {

    private ListScopesFixedSizeCollection(List<ListScopesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListScopesFixedSizeCollection createEmptyCollection() {
      return new ListScopesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListScopesFixedSizeCollection createCollection(
        List<ListScopesPage> pages, int collectionSize) {
      return new ListScopesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPermittedScopesPagedResponse
      extends AbstractPagedListResponse<
          ListPermittedScopesRequest,
          ListPermittedScopesResponse,
          Scope,
          ListPermittedScopesPage,
          ListPermittedScopesFixedSizeCollection> {

    public static ApiFuture<ListPermittedScopesPagedResponse> createAsync(
        PageContext<ListPermittedScopesRequest, ListPermittedScopesResponse, Scope> context,
        ApiFuture<ListPermittedScopesResponse> futureResponse) {
      ApiFuture<ListPermittedScopesPage> futurePage =
          ListPermittedScopesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPermittedScopesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPermittedScopesPagedResponse(ListPermittedScopesPage page) {
      super(page, ListPermittedScopesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPermittedScopesPage
      extends AbstractPage<
          ListPermittedScopesRequest, ListPermittedScopesResponse, Scope, ListPermittedScopesPage> {

    private ListPermittedScopesPage(
        PageContext<ListPermittedScopesRequest, ListPermittedScopesResponse, Scope> context,
        ListPermittedScopesResponse response) {
      super(context, response);
    }

    private static ListPermittedScopesPage createEmptyPage() {
      return new ListPermittedScopesPage(null, null);
    }

    @Override
    protected ListPermittedScopesPage createPage(
        PageContext<ListPermittedScopesRequest, ListPermittedScopesResponse, Scope> context,
        ListPermittedScopesResponse response) {
      return new ListPermittedScopesPage(context, response);
    }

    @Override
    public ApiFuture<ListPermittedScopesPage> createPageAsync(
        PageContext<ListPermittedScopesRequest, ListPermittedScopesResponse, Scope> context,
        ApiFuture<ListPermittedScopesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPermittedScopesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPermittedScopesRequest,
          ListPermittedScopesResponse,
          Scope,
          ListPermittedScopesPage,
          ListPermittedScopesFixedSizeCollection> {

    private ListPermittedScopesFixedSizeCollection(
        List<ListPermittedScopesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPermittedScopesFixedSizeCollection createEmptyCollection() {
      return new ListPermittedScopesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPermittedScopesFixedSizeCollection createCollection(
        List<ListPermittedScopesPage> pages, int collectionSize) {
      return new ListPermittedScopesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMembershipBindingsPagedResponse
      extends AbstractPagedListResponse<
          ListMembershipBindingsRequest,
          ListMembershipBindingsResponse,
          MembershipBinding,
          ListMembershipBindingsPage,
          ListMembershipBindingsFixedSizeCollection> {

    public static ApiFuture<ListMembershipBindingsPagedResponse> createAsync(
        PageContext<
                ListMembershipBindingsRequest, ListMembershipBindingsResponse, MembershipBinding>
            context,
        ApiFuture<ListMembershipBindingsResponse> futureResponse) {
      ApiFuture<ListMembershipBindingsPage> futurePage =
          ListMembershipBindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMembershipBindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMembershipBindingsPagedResponse(ListMembershipBindingsPage page) {
      super(page, ListMembershipBindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMembershipBindingsPage
      extends AbstractPage<
          ListMembershipBindingsRequest,
          ListMembershipBindingsResponse,
          MembershipBinding,
          ListMembershipBindingsPage> {

    private ListMembershipBindingsPage(
        PageContext<
                ListMembershipBindingsRequest, ListMembershipBindingsResponse, MembershipBinding>
            context,
        ListMembershipBindingsResponse response) {
      super(context, response);
    }

    private static ListMembershipBindingsPage createEmptyPage() {
      return new ListMembershipBindingsPage(null, null);
    }

    @Override
    protected ListMembershipBindingsPage createPage(
        PageContext<
                ListMembershipBindingsRequest, ListMembershipBindingsResponse, MembershipBinding>
            context,
        ListMembershipBindingsResponse response) {
      return new ListMembershipBindingsPage(context, response);
    }

    @Override
    public ApiFuture<ListMembershipBindingsPage> createPageAsync(
        PageContext<
                ListMembershipBindingsRequest, ListMembershipBindingsResponse, MembershipBinding>
            context,
        ApiFuture<ListMembershipBindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMembershipBindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMembershipBindingsRequest,
          ListMembershipBindingsResponse,
          MembershipBinding,
          ListMembershipBindingsPage,
          ListMembershipBindingsFixedSizeCollection> {

    private ListMembershipBindingsFixedSizeCollection(
        List<ListMembershipBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMembershipBindingsFixedSizeCollection createEmptyCollection() {
      return new ListMembershipBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMembershipBindingsFixedSizeCollection createCollection(
        List<ListMembershipBindingsPage> pages, int collectionSize) {
      return new ListMembershipBindingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMembershipRBACRoleBindingsPagedResponse
      extends AbstractPagedListResponse<
          ListMembershipRBACRoleBindingsRequest,
          ListMembershipRBACRoleBindingsResponse,
          RBACRoleBinding,
          ListMembershipRBACRoleBindingsPage,
          ListMembershipRBACRoleBindingsFixedSizeCollection> {

    public static ApiFuture<ListMembershipRBACRoleBindingsPagedResponse> createAsync(
        PageContext<
                ListMembershipRBACRoleBindingsRequest,
                ListMembershipRBACRoleBindingsResponse,
                RBACRoleBinding>
            context,
        ApiFuture<ListMembershipRBACRoleBindingsResponse> futureResponse) {
      ApiFuture<ListMembershipRBACRoleBindingsPage> futurePage =
          ListMembershipRBACRoleBindingsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMembershipRBACRoleBindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMembershipRBACRoleBindingsPagedResponse(ListMembershipRBACRoleBindingsPage page) {
      super(page, ListMembershipRBACRoleBindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMembershipRBACRoleBindingsPage
      extends AbstractPage<
          ListMembershipRBACRoleBindingsRequest,
          ListMembershipRBACRoleBindingsResponse,
          RBACRoleBinding,
          ListMembershipRBACRoleBindingsPage> {

    private ListMembershipRBACRoleBindingsPage(
        PageContext<
                ListMembershipRBACRoleBindingsRequest,
                ListMembershipRBACRoleBindingsResponse,
                RBACRoleBinding>
            context,
        ListMembershipRBACRoleBindingsResponse response) {
      super(context, response);
    }

    private static ListMembershipRBACRoleBindingsPage createEmptyPage() {
      return new ListMembershipRBACRoleBindingsPage(null, null);
    }

    @Override
    protected ListMembershipRBACRoleBindingsPage createPage(
        PageContext<
                ListMembershipRBACRoleBindingsRequest,
                ListMembershipRBACRoleBindingsResponse,
                RBACRoleBinding>
            context,
        ListMembershipRBACRoleBindingsResponse response) {
      return new ListMembershipRBACRoleBindingsPage(context, response);
    }

    @Override
    public ApiFuture<ListMembershipRBACRoleBindingsPage> createPageAsync(
        PageContext<
                ListMembershipRBACRoleBindingsRequest,
                ListMembershipRBACRoleBindingsResponse,
                RBACRoleBinding>
            context,
        ApiFuture<ListMembershipRBACRoleBindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMembershipRBACRoleBindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMembershipRBACRoleBindingsRequest,
          ListMembershipRBACRoleBindingsResponse,
          RBACRoleBinding,
          ListMembershipRBACRoleBindingsPage,
          ListMembershipRBACRoleBindingsFixedSizeCollection> {

    private ListMembershipRBACRoleBindingsFixedSizeCollection(
        List<ListMembershipRBACRoleBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMembershipRBACRoleBindingsFixedSizeCollection createEmptyCollection() {
      return new ListMembershipRBACRoleBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMembershipRBACRoleBindingsFixedSizeCollection createCollection(
        List<ListMembershipRBACRoleBindingsPage> pages, int collectionSize) {
      return new ListMembershipRBACRoleBindingsFixedSizeCollection(pages, collectionSize);
    }
  }
}
