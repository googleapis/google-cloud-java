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

package com.google.cloud.networksecurity.v1;

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
import com.google.cloud.networksecurity.v1.stub.InterceptStub;
import com.google.cloud.networksecurity.v1.stub.InterceptStubSettings;
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
 * Service Description: Service for Third-Party Packet Intercept (TPPI). TPPI is the "in-band"
 * flavor of the Network Security Integrations product.
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
 * try (InterceptClient interceptClient = InterceptClient.create()) {
 *   InterceptEndpointGroupName name =
 *       InterceptEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]");
 *   InterceptEndpointGroup response = interceptClient.getInterceptEndpointGroup(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the InterceptClient object to clean up resources such as
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
 *      <td><p> ListInterceptEndpointGroups</td>
 *      <td><p> Lists endpoint groups in a given project and location. See https://google.aip.dev/132.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listInterceptEndpointGroups(ListInterceptEndpointGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listInterceptEndpointGroups(LocationName parent)
 *           <li><p> listInterceptEndpointGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listInterceptEndpointGroupsPagedCallable()
 *           <li><p> listInterceptEndpointGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetInterceptEndpointGroup</td>
 *      <td><p> Gets a specific endpoint group. See https://google.aip.dev/131.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getInterceptEndpointGroup(GetInterceptEndpointGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getInterceptEndpointGroup(InterceptEndpointGroupName name)
 *           <li><p> getInterceptEndpointGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getInterceptEndpointGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateInterceptEndpointGroup</td>
 *      <td><p> Creates an endpoint group in a given project and location. See https://google.aip.dev/133.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createInterceptEndpointGroupAsync(CreateInterceptEndpointGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createInterceptEndpointGroupAsync(LocationName parent, InterceptEndpointGroup interceptEndpointGroup, String interceptEndpointGroupId)
 *           <li><p> createInterceptEndpointGroupAsync(String parent, InterceptEndpointGroup interceptEndpointGroup, String interceptEndpointGroupId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createInterceptEndpointGroupOperationCallable()
 *           <li><p> createInterceptEndpointGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateInterceptEndpointGroup</td>
 *      <td><p> Updates an endpoint group. See https://google.aip.dev/134.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateInterceptEndpointGroupAsync(UpdateInterceptEndpointGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateInterceptEndpointGroupAsync(InterceptEndpointGroup interceptEndpointGroup, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateInterceptEndpointGroupOperationCallable()
 *           <li><p> updateInterceptEndpointGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteInterceptEndpointGroup</td>
 *      <td><p> Deletes an endpoint group. See https://google.aip.dev/135.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteInterceptEndpointGroupAsync(DeleteInterceptEndpointGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteInterceptEndpointGroupAsync(InterceptEndpointGroupName name)
 *           <li><p> deleteInterceptEndpointGroupAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteInterceptEndpointGroupOperationCallable()
 *           <li><p> deleteInterceptEndpointGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListInterceptEndpointGroupAssociations</td>
 *      <td><p> Lists associations in a given project and location. See https://google.aip.dev/132.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listInterceptEndpointGroupAssociations(ListInterceptEndpointGroupAssociationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listInterceptEndpointGroupAssociations(LocationName parent)
 *           <li><p> listInterceptEndpointGroupAssociations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listInterceptEndpointGroupAssociationsPagedCallable()
 *           <li><p> listInterceptEndpointGroupAssociationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetInterceptEndpointGroupAssociation</td>
 *      <td><p> Gets a specific association. See https://google.aip.dev/131.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getInterceptEndpointGroupAssociation(GetInterceptEndpointGroupAssociationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getInterceptEndpointGroupAssociation(InterceptEndpointGroupAssociationName name)
 *           <li><p> getInterceptEndpointGroupAssociation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getInterceptEndpointGroupAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateInterceptEndpointGroupAssociation</td>
 *      <td><p> Creates an association in a given project and location. See https://google.aip.dev/133.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createInterceptEndpointGroupAssociationAsync(CreateInterceptEndpointGroupAssociationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createInterceptEndpointGroupAssociationAsync(LocationName parent, InterceptEndpointGroupAssociation interceptEndpointGroupAssociation, String interceptEndpointGroupAssociationId)
 *           <li><p> createInterceptEndpointGroupAssociationAsync(String parent, InterceptEndpointGroupAssociation interceptEndpointGroupAssociation, String interceptEndpointGroupAssociationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createInterceptEndpointGroupAssociationOperationCallable()
 *           <li><p> createInterceptEndpointGroupAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateInterceptEndpointGroupAssociation</td>
 *      <td><p> Updates an association. See https://google.aip.dev/134.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateInterceptEndpointGroupAssociationAsync(UpdateInterceptEndpointGroupAssociationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateInterceptEndpointGroupAssociationAsync(InterceptEndpointGroupAssociation interceptEndpointGroupAssociation, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateInterceptEndpointGroupAssociationOperationCallable()
 *           <li><p> updateInterceptEndpointGroupAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteInterceptEndpointGroupAssociation</td>
 *      <td><p> Deletes an association. See https://google.aip.dev/135.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteInterceptEndpointGroupAssociationAsync(DeleteInterceptEndpointGroupAssociationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteInterceptEndpointGroupAssociationAsync(InterceptEndpointGroupAssociationName name)
 *           <li><p> deleteInterceptEndpointGroupAssociationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteInterceptEndpointGroupAssociationOperationCallable()
 *           <li><p> deleteInterceptEndpointGroupAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListInterceptDeploymentGroups</td>
 *      <td><p> Lists deployment groups in a given project and location. See https://google.aip.dev/132.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listInterceptDeploymentGroups(ListInterceptDeploymentGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listInterceptDeploymentGroups(LocationName parent)
 *           <li><p> listInterceptDeploymentGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listInterceptDeploymentGroupsPagedCallable()
 *           <li><p> listInterceptDeploymentGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetInterceptDeploymentGroup</td>
 *      <td><p> Gets a specific deployment group. See https://google.aip.dev/131.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getInterceptDeploymentGroup(GetInterceptDeploymentGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getInterceptDeploymentGroup(InterceptDeploymentGroupName name)
 *           <li><p> getInterceptDeploymentGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getInterceptDeploymentGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateInterceptDeploymentGroup</td>
 *      <td><p> Creates a deployment group in a given project and location. See https://google.aip.dev/133.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createInterceptDeploymentGroupAsync(CreateInterceptDeploymentGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createInterceptDeploymentGroupAsync(LocationName parent, InterceptDeploymentGroup interceptDeploymentGroup, String interceptDeploymentGroupId)
 *           <li><p> createInterceptDeploymentGroupAsync(String parent, InterceptDeploymentGroup interceptDeploymentGroup, String interceptDeploymentGroupId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createInterceptDeploymentGroupOperationCallable()
 *           <li><p> createInterceptDeploymentGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateInterceptDeploymentGroup</td>
 *      <td><p> Updates a deployment group. See https://google.aip.dev/134.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateInterceptDeploymentGroupAsync(UpdateInterceptDeploymentGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateInterceptDeploymentGroupAsync(InterceptDeploymentGroup interceptDeploymentGroup, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateInterceptDeploymentGroupOperationCallable()
 *           <li><p> updateInterceptDeploymentGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteInterceptDeploymentGroup</td>
 *      <td><p> Deletes a deployment group. See https://google.aip.dev/135.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteInterceptDeploymentGroupAsync(DeleteInterceptDeploymentGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteInterceptDeploymentGroupAsync(InterceptDeploymentGroupName name)
 *           <li><p> deleteInterceptDeploymentGroupAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteInterceptDeploymentGroupOperationCallable()
 *           <li><p> deleteInterceptDeploymentGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListInterceptDeployments</td>
 *      <td><p> Lists deployments in a given project and location. See https://google.aip.dev/132.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listInterceptDeployments(ListInterceptDeploymentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listInterceptDeployments(LocationName parent)
 *           <li><p> listInterceptDeployments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listInterceptDeploymentsPagedCallable()
 *           <li><p> listInterceptDeploymentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetInterceptDeployment</td>
 *      <td><p> Gets a specific deployment. See https://google.aip.dev/131.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getInterceptDeployment(GetInterceptDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getInterceptDeployment(InterceptDeploymentName name)
 *           <li><p> getInterceptDeployment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getInterceptDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateInterceptDeployment</td>
 *      <td><p> Creates a deployment in a given project and location. See https://google.aip.dev/133.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createInterceptDeploymentAsync(CreateInterceptDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createInterceptDeploymentAsync(LocationName parent, InterceptDeployment interceptDeployment, String interceptDeploymentId)
 *           <li><p> createInterceptDeploymentAsync(String parent, InterceptDeployment interceptDeployment, String interceptDeploymentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createInterceptDeploymentOperationCallable()
 *           <li><p> createInterceptDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateInterceptDeployment</td>
 *      <td><p> Updates a deployment. See https://google.aip.dev/134.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateInterceptDeploymentAsync(UpdateInterceptDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateInterceptDeploymentAsync(InterceptDeployment interceptDeployment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateInterceptDeploymentOperationCallable()
 *           <li><p> updateInterceptDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteInterceptDeployment</td>
 *      <td><p> Deletes a deployment. See https://google.aip.dev/135.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteInterceptDeploymentAsync(DeleteInterceptDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteInterceptDeploymentAsync(InterceptDeploymentName name)
 *           <li><p> deleteInterceptDeploymentAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteInterceptDeploymentOperationCallable()
 *           <li><p> deleteInterceptDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.
 * <p> This method lists locations based on the resource scope provided inthe [ListLocationsRequest.name] field:
 * <p> &#42; &#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If `name` follows the format`projects/{project}`, the method lists locations visible to thatspecific project. This includes public, private, or otherproject-specific locations enabled for the project.
 * <p> For gRPC and client library implementations, the resource name ispassed as the `name` field. For direct service calls, the resourcename isincorporated into the request path based on the specific serviceimplementation and version.</td>
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
 * <p>This class can be customized by passing in a custom instance of InterceptSettings to create().
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
 * InterceptSettings interceptSettings =
 *     InterceptSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InterceptClient interceptClient = InterceptClient.create(interceptSettings);
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
 * InterceptSettings interceptSettings =
 *     InterceptSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InterceptClient interceptClient = InterceptClient.create(interceptSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class InterceptClient implements BackgroundResource {
  private final InterceptSettings settings;
  private final InterceptStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of InterceptClient with default settings. */
  public static final InterceptClient create() throws IOException {
    return create(InterceptSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InterceptClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InterceptClient create(InterceptSettings settings) throws IOException {
    return new InterceptClient(settings);
  }

  /**
   * Constructs an instance of InterceptClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(InterceptSettings).
   */
  public static final InterceptClient create(InterceptStub stub) {
    return new InterceptClient(stub);
  }

  /**
   * Constructs an instance of InterceptClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected InterceptClient(InterceptSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((InterceptStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected InterceptClient(InterceptStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final InterceptSettings getSettings() {
    return settings;
  }

  public InterceptStub getStub() {
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
   * Lists endpoint groups in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (InterceptEndpointGroup element :
   *       interceptClient.listInterceptEndpointGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of endpoint groups. Example:
   *     `projects/123456789/locations/global`. See https://google.aip.dev/132 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterceptEndpointGroupsPagedResponse listInterceptEndpointGroups(
      LocationName parent) {
    ListInterceptEndpointGroupsRequest request =
        ListInterceptEndpointGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInterceptEndpointGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists endpoint groups in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (InterceptEndpointGroup element :
   *       interceptClient.listInterceptEndpointGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of endpoint groups. Example:
   *     `projects/123456789/locations/global`. See https://google.aip.dev/132 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterceptEndpointGroupsPagedResponse listInterceptEndpointGroups(String parent) {
    ListInterceptEndpointGroupsRequest request =
        ListInterceptEndpointGroupsRequest.newBuilder().setParent(parent).build();
    return listInterceptEndpointGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists endpoint groups in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   ListInterceptEndpointGroupsRequest request =
   *       ListInterceptEndpointGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (InterceptEndpointGroup element :
   *       interceptClient.listInterceptEndpointGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterceptEndpointGroupsPagedResponse listInterceptEndpointGroups(
      ListInterceptEndpointGroupsRequest request) {
    return listInterceptEndpointGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists endpoint groups in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   ListInterceptEndpointGroupsRequest request =
   *       ListInterceptEndpointGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<InterceptEndpointGroup> future =
   *       interceptClient.listInterceptEndpointGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InterceptEndpointGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListInterceptEndpointGroupsRequest, ListInterceptEndpointGroupsPagedResponse>
      listInterceptEndpointGroupsPagedCallable() {
    return stub.listInterceptEndpointGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists endpoint groups in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   ListInterceptEndpointGroupsRequest request =
   *       ListInterceptEndpointGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListInterceptEndpointGroupsResponse response =
   *         interceptClient.listInterceptEndpointGroupsCallable().call(request);
   *     for (InterceptEndpointGroup element : response.getInterceptEndpointGroupsList()) {
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
          ListInterceptEndpointGroupsRequest, ListInterceptEndpointGroupsResponse>
      listInterceptEndpointGroupsCallable() {
    return stub.listInterceptEndpointGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific endpoint group. See https://google.aip.dev/131.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   InterceptEndpointGroupName name =
   *       InterceptEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]");
   *   InterceptEndpointGroup response = interceptClient.getInterceptEndpointGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the endpoint group to retrieve. Format:
   *     projects/{project}/locations/{location}/interceptEndpointGroups/{intercept_endpoint_group}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterceptEndpointGroup getInterceptEndpointGroup(InterceptEndpointGroupName name) {
    GetInterceptEndpointGroupRequest request =
        GetInterceptEndpointGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getInterceptEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific endpoint group. See https://google.aip.dev/131.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   String name =
   *       InterceptEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]")
   *           .toString();
   *   InterceptEndpointGroup response = interceptClient.getInterceptEndpointGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the endpoint group to retrieve. Format:
   *     projects/{project}/locations/{location}/interceptEndpointGroups/{intercept_endpoint_group}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterceptEndpointGroup getInterceptEndpointGroup(String name) {
    GetInterceptEndpointGroupRequest request =
        GetInterceptEndpointGroupRequest.newBuilder().setName(name).build();
    return getInterceptEndpointGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific endpoint group. See https://google.aip.dev/131.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   GetInterceptEndpointGroupRequest request =
   *       GetInterceptEndpointGroupRequest.newBuilder()
   *           .setName(
   *               InterceptEndpointGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]")
   *                   .toString())
   *           .build();
   *   InterceptEndpointGroup response = interceptClient.getInterceptEndpointGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterceptEndpointGroup getInterceptEndpointGroup(
      GetInterceptEndpointGroupRequest request) {
    return getInterceptEndpointGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific endpoint group. See https://google.aip.dev/131.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   GetInterceptEndpointGroupRequest request =
   *       GetInterceptEndpointGroupRequest.newBuilder()
   *           .setName(
   *               InterceptEndpointGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<InterceptEndpointGroup> future =
   *       interceptClient.getInterceptEndpointGroupCallable().futureCall(request);
   *   // Do something.
   *   InterceptEndpointGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInterceptEndpointGroupRequest, InterceptEndpointGroup>
      getInterceptEndpointGroupCallable() {
    return stub.getInterceptEndpointGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an endpoint group in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   InterceptEndpointGroup interceptEndpointGroup = InterceptEndpointGroup.newBuilder().build();
   *   String interceptEndpointGroupId = "interceptEndpointGroupId-1281880189";
   *   InterceptEndpointGroup response =
   *       interceptClient
   *           .createInterceptEndpointGroupAsync(
   *               parent, interceptEndpointGroup, interceptEndpointGroupId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this endpoint group will be created. Format:
   *     projects/{project}/locations/{location}
   * @param interceptEndpointGroup Required. The endpoint group to create.
   * @param interceptEndpointGroupId Required. The ID to use for the endpoint group, which will
   *     become the final component of the endpoint group's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptEndpointGroup, OperationMetadata>
      createInterceptEndpointGroupAsync(
          LocationName parent,
          InterceptEndpointGroup interceptEndpointGroup,
          String interceptEndpointGroupId) {
    CreateInterceptEndpointGroupRequest request =
        CreateInterceptEndpointGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInterceptEndpointGroup(interceptEndpointGroup)
            .setInterceptEndpointGroupId(interceptEndpointGroupId)
            .build();
    return createInterceptEndpointGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an endpoint group in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   InterceptEndpointGroup interceptEndpointGroup = InterceptEndpointGroup.newBuilder().build();
   *   String interceptEndpointGroupId = "interceptEndpointGroupId-1281880189";
   *   InterceptEndpointGroup response =
   *       interceptClient
   *           .createInterceptEndpointGroupAsync(
   *               parent, interceptEndpointGroup, interceptEndpointGroupId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this endpoint group will be created. Format:
   *     projects/{project}/locations/{location}
   * @param interceptEndpointGroup Required. The endpoint group to create.
   * @param interceptEndpointGroupId Required. The ID to use for the endpoint group, which will
   *     become the final component of the endpoint group's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptEndpointGroup, OperationMetadata>
      createInterceptEndpointGroupAsync(
          String parent,
          InterceptEndpointGroup interceptEndpointGroup,
          String interceptEndpointGroupId) {
    CreateInterceptEndpointGroupRequest request =
        CreateInterceptEndpointGroupRequest.newBuilder()
            .setParent(parent)
            .setInterceptEndpointGroup(interceptEndpointGroup)
            .setInterceptEndpointGroupId(interceptEndpointGroupId)
            .build();
    return createInterceptEndpointGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an endpoint group in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   CreateInterceptEndpointGroupRequest request =
   *       CreateInterceptEndpointGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInterceptEndpointGroupId("interceptEndpointGroupId-1281880189")
   *           .setInterceptEndpointGroup(InterceptEndpointGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   InterceptEndpointGroup response =
   *       interceptClient.createInterceptEndpointGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptEndpointGroup, OperationMetadata>
      createInterceptEndpointGroupAsync(CreateInterceptEndpointGroupRequest request) {
    return createInterceptEndpointGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an endpoint group in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   CreateInterceptEndpointGroupRequest request =
   *       CreateInterceptEndpointGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInterceptEndpointGroupId("interceptEndpointGroupId-1281880189")
   *           .setInterceptEndpointGroup(InterceptEndpointGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<InterceptEndpointGroup, OperationMetadata> future =
   *       interceptClient.createInterceptEndpointGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   InterceptEndpointGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
      createInterceptEndpointGroupOperationCallable() {
    return stub.createInterceptEndpointGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an endpoint group in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   CreateInterceptEndpointGroupRequest request =
   *       CreateInterceptEndpointGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInterceptEndpointGroupId("interceptEndpointGroupId-1281880189")
   *           .setInterceptEndpointGroup(InterceptEndpointGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       interceptClient.createInterceptEndpointGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInterceptEndpointGroupRequest, Operation>
      createInterceptEndpointGroupCallable() {
    return stub.createInterceptEndpointGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an endpoint group. See https://google.aip.dev/134.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   InterceptEndpointGroup interceptEndpointGroup = InterceptEndpointGroup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   InterceptEndpointGroup response =
   *       interceptClient
   *           .updateInterceptEndpointGroupAsync(interceptEndpointGroup, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param interceptEndpointGroup Required. The endpoint group to update.
   * @param updateMask Optional. The list of fields to update. Fields are specified relative to the
   *     endpoint group (e.g. `description`; &#42;not&#42; `intercept_endpoint_group.description`).
   *     See https://google.aip.dev/161 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptEndpointGroup, OperationMetadata>
      updateInterceptEndpointGroupAsync(
          InterceptEndpointGroup interceptEndpointGroup, FieldMask updateMask) {
    UpdateInterceptEndpointGroupRequest request =
        UpdateInterceptEndpointGroupRequest.newBuilder()
            .setInterceptEndpointGroup(interceptEndpointGroup)
            .setUpdateMask(updateMask)
            .build();
    return updateInterceptEndpointGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an endpoint group. See https://google.aip.dev/134.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   UpdateInterceptEndpointGroupRequest request =
   *       UpdateInterceptEndpointGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInterceptEndpointGroup(InterceptEndpointGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   InterceptEndpointGroup response =
   *       interceptClient.updateInterceptEndpointGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptEndpointGroup, OperationMetadata>
      updateInterceptEndpointGroupAsync(UpdateInterceptEndpointGroupRequest request) {
    return updateInterceptEndpointGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an endpoint group. See https://google.aip.dev/134.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   UpdateInterceptEndpointGroupRequest request =
   *       UpdateInterceptEndpointGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInterceptEndpointGroup(InterceptEndpointGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<InterceptEndpointGroup, OperationMetadata> future =
   *       interceptClient.updateInterceptEndpointGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   InterceptEndpointGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
      updateInterceptEndpointGroupOperationCallable() {
    return stub.updateInterceptEndpointGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an endpoint group. See https://google.aip.dev/134.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   UpdateInterceptEndpointGroupRequest request =
   *       UpdateInterceptEndpointGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInterceptEndpointGroup(InterceptEndpointGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       interceptClient.updateInterceptEndpointGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateInterceptEndpointGroupRequest, Operation>
      updateInterceptEndpointGroupCallable() {
    return stub.updateInterceptEndpointGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an endpoint group. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   InterceptEndpointGroupName name =
   *       InterceptEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]");
   *   interceptClient.deleteInterceptEndpointGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The endpoint group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInterceptEndpointGroupAsync(
      InterceptEndpointGroupName name) {
    DeleteInterceptEndpointGroupRequest request =
        DeleteInterceptEndpointGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteInterceptEndpointGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an endpoint group. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   String name =
   *       InterceptEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]")
   *           .toString();
   *   interceptClient.deleteInterceptEndpointGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The endpoint group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInterceptEndpointGroupAsync(
      String name) {
    DeleteInterceptEndpointGroupRequest request =
        DeleteInterceptEndpointGroupRequest.newBuilder().setName(name).build();
    return deleteInterceptEndpointGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an endpoint group. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   DeleteInterceptEndpointGroupRequest request =
   *       DeleteInterceptEndpointGroupRequest.newBuilder()
   *           .setName(
   *               InterceptEndpointGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   interceptClient.deleteInterceptEndpointGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInterceptEndpointGroupAsync(
      DeleteInterceptEndpointGroupRequest request) {
    return deleteInterceptEndpointGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an endpoint group. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   DeleteInterceptEndpointGroupRequest request =
   *       DeleteInterceptEndpointGroupRequest.newBuilder()
   *           .setName(
   *               InterceptEndpointGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       interceptClient.deleteInterceptEndpointGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInterceptEndpointGroupRequest, Empty, OperationMetadata>
      deleteInterceptEndpointGroupOperationCallable() {
    return stub.deleteInterceptEndpointGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an endpoint group. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   DeleteInterceptEndpointGroupRequest request =
   *       DeleteInterceptEndpointGroupRequest.newBuilder()
   *           .setName(
   *               InterceptEndpointGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       interceptClient.deleteInterceptEndpointGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInterceptEndpointGroupRequest, Operation>
      deleteInterceptEndpointGroupCallable() {
    return stub.deleteInterceptEndpointGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists associations in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (InterceptEndpointGroupAssociation element :
   *       interceptClient.listInterceptEndpointGroupAssociations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of associations. Example:
   *     `projects/123456789/locations/global`. See https://google.aip.dev/132 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterceptEndpointGroupAssociationsPagedResponse
      listInterceptEndpointGroupAssociations(LocationName parent) {
    ListInterceptEndpointGroupAssociationsRequest request =
        ListInterceptEndpointGroupAssociationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInterceptEndpointGroupAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists associations in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (InterceptEndpointGroupAssociation element :
   *       interceptClient.listInterceptEndpointGroupAssociations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of associations. Example:
   *     `projects/123456789/locations/global`. See https://google.aip.dev/132 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterceptEndpointGroupAssociationsPagedResponse
      listInterceptEndpointGroupAssociations(String parent) {
    ListInterceptEndpointGroupAssociationsRequest request =
        ListInterceptEndpointGroupAssociationsRequest.newBuilder().setParent(parent).build();
    return listInterceptEndpointGroupAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists associations in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   ListInterceptEndpointGroupAssociationsRequest request =
   *       ListInterceptEndpointGroupAssociationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (InterceptEndpointGroupAssociation element :
   *       interceptClient.listInterceptEndpointGroupAssociations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterceptEndpointGroupAssociationsPagedResponse
      listInterceptEndpointGroupAssociations(
          ListInterceptEndpointGroupAssociationsRequest request) {
    return listInterceptEndpointGroupAssociationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists associations in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   ListInterceptEndpointGroupAssociationsRequest request =
   *       ListInterceptEndpointGroupAssociationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<InterceptEndpointGroupAssociation> future =
   *       interceptClient.listInterceptEndpointGroupAssociationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InterceptEndpointGroupAssociation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListInterceptEndpointGroupAssociationsRequest,
          ListInterceptEndpointGroupAssociationsPagedResponse>
      listInterceptEndpointGroupAssociationsPagedCallable() {
    return stub.listInterceptEndpointGroupAssociationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists associations in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   ListInterceptEndpointGroupAssociationsRequest request =
   *       ListInterceptEndpointGroupAssociationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListInterceptEndpointGroupAssociationsResponse response =
   *         interceptClient.listInterceptEndpointGroupAssociationsCallable().call(request);
   *     for (InterceptEndpointGroupAssociation element :
   *         response.getInterceptEndpointGroupAssociationsList()) {
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
          ListInterceptEndpointGroupAssociationsRequest,
          ListInterceptEndpointGroupAssociationsResponse>
      listInterceptEndpointGroupAssociationsCallable() {
    return stub.listInterceptEndpointGroupAssociationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific association. See https://google.aip.dev/131.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   InterceptEndpointGroupAssociationName name =
   *       InterceptEndpointGroupAssociationName.of(
   *           "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]");
   *   InterceptEndpointGroupAssociation response =
   *       interceptClient.getInterceptEndpointGroupAssociation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the association to retrieve. Format:
   *     projects/{project}/locations/{location}/interceptEndpointGroupAssociations/{intercept_endpoint_group_association}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterceptEndpointGroupAssociation getInterceptEndpointGroupAssociation(
      InterceptEndpointGroupAssociationName name) {
    GetInterceptEndpointGroupAssociationRequest request =
        GetInterceptEndpointGroupAssociationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getInterceptEndpointGroupAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific association. See https://google.aip.dev/131.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   String name =
   *       InterceptEndpointGroupAssociationName.of(
   *               "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]")
   *           .toString();
   *   InterceptEndpointGroupAssociation response =
   *       interceptClient.getInterceptEndpointGroupAssociation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the association to retrieve. Format:
   *     projects/{project}/locations/{location}/interceptEndpointGroupAssociations/{intercept_endpoint_group_association}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterceptEndpointGroupAssociation getInterceptEndpointGroupAssociation(String name) {
    GetInterceptEndpointGroupAssociationRequest request =
        GetInterceptEndpointGroupAssociationRequest.newBuilder().setName(name).build();
    return getInterceptEndpointGroupAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific association. See https://google.aip.dev/131.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   GetInterceptEndpointGroupAssociationRequest request =
   *       GetInterceptEndpointGroupAssociationRequest.newBuilder()
   *           .setName(
   *               InterceptEndpointGroupAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]")
   *                   .toString())
   *           .build();
   *   InterceptEndpointGroupAssociation response =
   *       interceptClient.getInterceptEndpointGroupAssociation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterceptEndpointGroupAssociation getInterceptEndpointGroupAssociation(
      GetInterceptEndpointGroupAssociationRequest request) {
    return getInterceptEndpointGroupAssociationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific association. See https://google.aip.dev/131.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   GetInterceptEndpointGroupAssociationRequest request =
   *       GetInterceptEndpointGroupAssociationRequest.newBuilder()
   *           .setName(
   *               InterceptEndpointGroupAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<InterceptEndpointGroupAssociation> future =
   *       interceptClient.getInterceptEndpointGroupAssociationCallable().futureCall(request);
   *   // Do something.
   *   InterceptEndpointGroupAssociation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetInterceptEndpointGroupAssociationRequest, InterceptEndpointGroupAssociation>
      getInterceptEndpointGroupAssociationCallable() {
    return stub.getInterceptEndpointGroupAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an association in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   InterceptEndpointGroupAssociation interceptEndpointGroupAssociation =
   *       InterceptEndpointGroupAssociation.newBuilder().build();
   *   String interceptEndpointGroupAssociationId = "interceptEndpointGroupAssociationId-1931364844";
   *   InterceptEndpointGroupAssociation response =
   *       interceptClient
   *           .createInterceptEndpointGroupAssociationAsync(
   *               parent, interceptEndpointGroupAssociation, interceptEndpointGroupAssociationId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this association will be created. Format:
   *     projects/{project}/locations/{location}
   * @param interceptEndpointGroupAssociation Required. The association to create.
   * @param interceptEndpointGroupAssociationId Optional. The ID to use for the new association,
   *     which will become the final component of the endpoint group's resource name. If not
   *     provided, the server will generate a unique ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptEndpointGroupAssociation, OperationMetadata>
      createInterceptEndpointGroupAssociationAsync(
          LocationName parent,
          InterceptEndpointGroupAssociation interceptEndpointGroupAssociation,
          String interceptEndpointGroupAssociationId) {
    CreateInterceptEndpointGroupAssociationRequest request =
        CreateInterceptEndpointGroupAssociationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInterceptEndpointGroupAssociation(interceptEndpointGroupAssociation)
            .setInterceptEndpointGroupAssociationId(interceptEndpointGroupAssociationId)
            .build();
    return createInterceptEndpointGroupAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an association in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   InterceptEndpointGroupAssociation interceptEndpointGroupAssociation =
   *       InterceptEndpointGroupAssociation.newBuilder().build();
   *   String interceptEndpointGroupAssociationId = "interceptEndpointGroupAssociationId-1931364844";
   *   InterceptEndpointGroupAssociation response =
   *       interceptClient
   *           .createInterceptEndpointGroupAssociationAsync(
   *               parent, interceptEndpointGroupAssociation, interceptEndpointGroupAssociationId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this association will be created. Format:
   *     projects/{project}/locations/{location}
   * @param interceptEndpointGroupAssociation Required. The association to create.
   * @param interceptEndpointGroupAssociationId Optional. The ID to use for the new association,
   *     which will become the final component of the endpoint group's resource name. If not
   *     provided, the server will generate a unique ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptEndpointGroupAssociation, OperationMetadata>
      createInterceptEndpointGroupAssociationAsync(
          String parent,
          InterceptEndpointGroupAssociation interceptEndpointGroupAssociation,
          String interceptEndpointGroupAssociationId) {
    CreateInterceptEndpointGroupAssociationRequest request =
        CreateInterceptEndpointGroupAssociationRequest.newBuilder()
            .setParent(parent)
            .setInterceptEndpointGroupAssociation(interceptEndpointGroupAssociation)
            .setInterceptEndpointGroupAssociationId(interceptEndpointGroupAssociationId)
            .build();
    return createInterceptEndpointGroupAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an association in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   CreateInterceptEndpointGroupAssociationRequest request =
   *       CreateInterceptEndpointGroupAssociationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInterceptEndpointGroupAssociationId(
   *               "interceptEndpointGroupAssociationId-1931364844")
   *           .setInterceptEndpointGroupAssociation(
   *               InterceptEndpointGroupAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   InterceptEndpointGroupAssociation response =
   *       interceptClient.createInterceptEndpointGroupAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptEndpointGroupAssociation, OperationMetadata>
      createInterceptEndpointGroupAssociationAsync(
          CreateInterceptEndpointGroupAssociationRequest request) {
    return createInterceptEndpointGroupAssociationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an association in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   CreateInterceptEndpointGroupAssociationRequest request =
   *       CreateInterceptEndpointGroupAssociationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInterceptEndpointGroupAssociationId(
   *               "interceptEndpointGroupAssociationId-1931364844")
   *           .setInterceptEndpointGroupAssociation(
   *               InterceptEndpointGroupAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<InterceptEndpointGroupAssociation, OperationMetadata> future =
   *       interceptClient
   *           .createInterceptEndpointGroupAssociationOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   InterceptEndpointGroupAssociation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateInterceptEndpointGroupAssociationRequest,
          InterceptEndpointGroupAssociation,
          OperationMetadata>
      createInterceptEndpointGroupAssociationOperationCallable() {
    return stub.createInterceptEndpointGroupAssociationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an association in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   CreateInterceptEndpointGroupAssociationRequest request =
   *       CreateInterceptEndpointGroupAssociationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInterceptEndpointGroupAssociationId(
   *               "interceptEndpointGroupAssociationId-1931364844")
   *           .setInterceptEndpointGroupAssociation(
   *               InterceptEndpointGroupAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       interceptClient.createInterceptEndpointGroupAssociationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInterceptEndpointGroupAssociationRequest, Operation>
      createInterceptEndpointGroupAssociationCallable() {
    return stub.createInterceptEndpointGroupAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an association. See https://google.aip.dev/134.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   InterceptEndpointGroupAssociation interceptEndpointGroupAssociation =
   *       InterceptEndpointGroupAssociation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   InterceptEndpointGroupAssociation response =
   *       interceptClient
   *           .updateInterceptEndpointGroupAssociationAsync(
   *               interceptEndpointGroupAssociation, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param interceptEndpointGroupAssociation Required. The association to update.
   * @param updateMask Optional. The list of fields to update. Fields are specified relative to the
   *     association (e.g. `description`; &#42;not&#42;
   *     `intercept_endpoint_group_association.description`). See https://google.aip.dev/161 for
   *     more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptEndpointGroupAssociation, OperationMetadata>
      updateInterceptEndpointGroupAssociationAsync(
          InterceptEndpointGroupAssociation interceptEndpointGroupAssociation,
          FieldMask updateMask) {
    UpdateInterceptEndpointGroupAssociationRequest request =
        UpdateInterceptEndpointGroupAssociationRequest.newBuilder()
            .setInterceptEndpointGroupAssociation(interceptEndpointGroupAssociation)
            .setUpdateMask(updateMask)
            .build();
    return updateInterceptEndpointGroupAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an association. See https://google.aip.dev/134.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   UpdateInterceptEndpointGroupAssociationRequest request =
   *       UpdateInterceptEndpointGroupAssociationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInterceptEndpointGroupAssociation(
   *               InterceptEndpointGroupAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   InterceptEndpointGroupAssociation response =
   *       interceptClient.updateInterceptEndpointGroupAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptEndpointGroupAssociation, OperationMetadata>
      updateInterceptEndpointGroupAssociationAsync(
          UpdateInterceptEndpointGroupAssociationRequest request) {
    return updateInterceptEndpointGroupAssociationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an association. See https://google.aip.dev/134.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   UpdateInterceptEndpointGroupAssociationRequest request =
   *       UpdateInterceptEndpointGroupAssociationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInterceptEndpointGroupAssociation(
   *               InterceptEndpointGroupAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<InterceptEndpointGroupAssociation, OperationMetadata> future =
   *       interceptClient
   *           .updateInterceptEndpointGroupAssociationOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   InterceptEndpointGroupAssociation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateInterceptEndpointGroupAssociationRequest,
          InterceptEndpointGroupAssociation,
          OperationMetadata>
      updateInterceptEndpointGroupAssociationOperationCallable() {
    return stub.updateInterceptEndpointGroupAssociationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an association. See https://google.aip.dev/134.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   UpdateInterceptEndpointGroupAssociationRequest request =
   *       UpdateInterceptEndpointGroupAssociationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInterceptEndpointGroupAssociation(
   *               InterceptEndpointGroupAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       interceptClient.updateInterceptEndpointGroupAssociationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateInterceptEndpointGroupAssociationRequest, Operation>
      updateInterceptEndpointGroupAssociationCallable() {
    return stub.updateInterceptEndpointGroupAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an association. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   InterceptEndpointGroupAssociationName name =
   *       InterceptEndpointGroupAssociationName.of(
   *           "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]");
   *   interceptClient.deleteInterceptEndpointGroupAssociationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The association to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata>
      deleteInterceptEndpointGroupAssociationAsync(InterceptEndpointGroupAssociationName name) {
    DeleteInterceptEndpointGroupAssociationRequest request =
        DeleteInterceptEndpointGroupAssociationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteInterceptEndpointGroupAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an association. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   String name =
   *       InterceptEndpointGroupAssociationName.of(
   *               "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]")
   *           .toString();
   *   interceptClient.deleteInterceptEndpointGroupAssociationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The association to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata>
      deleteInterceptEndpointGroupAssociationAsync(String name) {
    DeleteInterceptEndpointGroupAssociationRequest request =
        DeleteInterceptEndpointGroupAssociationRequest.newBuilder().setName(name).build();
    return deleteInterceptEndpointGroupAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an association. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   DeleteInterceptEndpointGroupAssociationRequest request =
   *       DeleteInterceptEndpointGroupAssociationRequest.newBuilder()
   *           .setName(
   *               InterceptEndpointGroupAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   interceptClient.deleteInterceptEndpointGroupAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata>
      deleteInterceptEndpointGroupAssociationAsync(
          DeleteInterceptEndpointGroupAssociationRequest request) {
    return deleteInterceptEndpointGroupAssociationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an association. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   DeleteInterceptEndpointGroupAssociationRequest request =
   *       DeleteInterceptEndpointGroupAssociationRequest.newBuilder()
   *           .setName(
   *               InterceptEndpointGroupAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       interceptClient
   *           .deleteInterceptEndpointGroupAssociationOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteInterceptEndpointGroupAssociationRequest, Empty, OperationMetadata>
      deleteInterceptEndpointGroupAssociationOperationCallable() {
    return stub.deleteInterceptEndpointGroupAssociationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an association. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   DeleteInterceptEndpointGroupAssociationRequest request =
   *       DeleteInterceptEndpointGroupAssociationRequest.newBuilder()
   *           .setName(
   *               InterceptEndpointGroupAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP_ASSOCIATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       interceptClient.deleteInterceptEndpointGroupAssociationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInterceptEndpointGroupAssociationRequest, Operation>
      deleteInterceptEndpointGroupAssociationCallable() {
    return stub.deleteInterceptEndpointGroupAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists deployment groups in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (InterceptDeploymentGroup element :
   *       interceptClient.listInterceptDeploymentGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of deployment groups. Example:
   *     `projects/123456789/locations/global`. See https://google.aip.dev/132 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterceptDeploymentGroupsPagedResponse listInterceptDeploymentGroups(
      LocationName parent) {
    ListInterceptDeploymentGroupsRequest request =
        ListInterceptDeploymentGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInterceptDeploymentGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists deployment groups in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (InterceptDeploymentGroup element :
   *       interceptClient.listInterceptDeploymentGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of deployment groups. Example:
   *     `projects/123456789/locations/global`. See https://google.aip.dev/132 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterceptDeploymentGroupsPagedResponse listInterceptDeploymentGroups(
      String parent) {
    ListInterceptDeploymentGroupsRequest request =
        ListInterceptDeploymentGroupsRequest.newBuilder().setParent(parent).build();
    return listInterceptDeploymentGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists deployment groups in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   ListInterceptDeploymentGroupsRequest request =
   *       ListInterceptDeploymentGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (InterceptDeploymentGroup element :
   *       interceptClient.listInterceptDeploymentGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterceptDeploymentGroupsPagedResponse listInterceptDeploymentGroups(
      ListInterceptDeploymentGroupsRequest request) {
    return listInterceptDeploymentGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists deployment groups in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   ListInterceptDeploymentGroupsRequest request =
   *       ListInterceptDeploymentGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<InterceptDeploymentGroup> future =
   *       interceptClient.listInterceptDeploymentGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InterceptDeploymentGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListInterceptDeploymentGroupsRequest, ListInterceptDeploymentGroupsPagedResponse>
      listInterceptDeploymentGroupsPagedCallable() {
    return stub.listInterceptDeploymentGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists deployment groups in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   ListInterceptDeploymentGroupsRequest request =
   *       ListInterceptDeploymentGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListInterceptDeploymentGroupsResponse response =
   *         interceptClient.listInterceptDeploymentGroupsCallable().call(request);
   *     for (InterceptDeploymentGroup element : response.getInterceptDeploymentGroupsList()) {
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
          ListInterceptDeploymentGroupsRequest, ListInterceptDeploymentGroupsResponse>
      listInterceptDeploymentGroupsCallable() {
    return stub.listInterceptDeploymentGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific deployment group. See https://google.aip.dev/131.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   InterceptDeploymentGroupName name =
   *       InterceptDeploymentGroupName.of(
   *           "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]");
   *   InterceptDeploymentGroup response = interceptClient.getInterceptDeploymentGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment group to retrieve. Format:
   *     projects/{project}/locations/{location}/interceptDeploymentGroups/{intercept_deployment_group}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterceptDeploymentGroup getInterceptDeploymentGroup(
      InterceptDeploymentGroupName name) {
    GetInterceptDeploymentGroupRequest request =
        GetInterceptDeploymentGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getInterceptDeploymentGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific deployment group. See https://google.aip.dev/131.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   String name =
   *       InterceptDeploymentGroupName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
   *           .toString();
   *   InterceptDeploymentGroup response = interceptClient.getInterceptDeploymentGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment group to retrieve. Format:
   *     projects/{project}/locations/{location}/interceptDeploymentGroups/{intercept_deployment_group}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterceptDeploymentGroup getInterceptDeploymentGroup(String name) {
    GetInterceptDeploymentGroupRequest request =
        GetInterceptDeploymentGroupRequest.newBuilder().setName(name).build();
    return getInterceptDeploymentGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific deployment group. See https://google.aip.dev/131.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   GetInterceptDeploymentGroupRequest request =
   *       GetInterceptDeploymentGroupRequest.newBuilder()
   *           .setName(
   *               InterceptDeploymentGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
   *                   .toString())
   *           .build();
   *   InterceptDeploymentGroup response = interceptClient.getInterceptDeploymentGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterceptDeploymentGroup getInterceptDeploymentGroup(
      GetInterceptDeploymentGroupRequest request) {
    return getInterceptDeploymentGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific deployment group. See https://google.aip.dev/131.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   GetInterceptDeploymentGroupRequest request =
   *       GetInterceptDeploymentGroupRequest.newBuilder()
   *           .setName(
   *               InterceptDeploymentGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<InterceptDeploymentGroup> future =
   *       interceptClient.getInterceptDeploymentGroupCallable().futureCall(request);
   *   // Do something.
   *   InterceptDeploymentGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInterceptDeploymentGroupRequest, InterceptDeploymentGroup>
      getInterceptDeploymentGroupCallable() {
    return stub.getInterceptDeploymentGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment group in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   InterceptDeploymentGroup interceptDeploymentGroup =
   *       InterceptDeploymentGroup.newBuilder().build();
   *   String interceptDeploymentGroupId = "interceptDeploymentGroupId1356790995";
   *   InterceptDeploymentGroup response =
   *       interceptClient
   *           .createInterceptDeploymentGroupAsync(
   *               parent, interceptDeploymentGroup, interceptDeploymentGroupId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this deployment group will be created.
   *     Format: projects/{project}/locations/{location}
   * @param interceptDeploymentGroup Required. The deployment group to create.
   * @param interceptDeploymentGroupId Required. The ID to use for the new deployment group, which
   *     will become the final component of the deployment group's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptDeploymentGroup, OperationMetadata>
      createInterceptDeploymentGroupAsync(
          LocationName parent,
          InterceptDeploymentGroup interceptDeploymentGroup,
          String interceptDeploymentGroupId) {
    CreateInterceptDeploymentGroupRequest request =
        CreateInterceptDeploymentGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInterceptDeploymentGroup(interceptDeploymentGroup)
            .setInterceptDeploymentGroupId(interceptDeploymentGroupId)
            .build();
    return createInterceptDeploymentGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment group in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   InterceptDeploymentGroup interceptDeploymentGroup =
   *       InterceptDeploymentGroup.newBuilder().build();
   *   String interceptDeploymentGroupId = "interceptDeploymentGroupId1356790995";
   *   InterceptDeploymentGroup response =
   *       interceptClient
   *           .createInterceptDeploymentGroupAsync(
   *               parent, interceptDeploymentGroup, interceptDeploymentGroupId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this deployment group will be created.
   *     Format: projects/{project}/locations/{location}
   * @param interceptDeploymentGroup Required. The deployment group to create.
   * @param interceptDeploymentGroupId Required. The ID to use for the new deployment group, which
   *     will become the final component of the deployment group's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptDeploymentGroup, OperationMetadata>
      createInterceptDeploymentGroupAsync(
          String parent,
          InterceptDeploymentGroup interceptDeploymentGroup,
          String interceptDeploymentGroupId) {
    CreateInterceptDeploymentGroupRequest request =
        CreateInterceptDeploymentGroupRequest.newBuilder()
            .setParent(parent)
            .setInterceptDeploymentGroup(interceptDeploymentGroup)
            .setInterceptDeploymentGroupId(interceptDeploymentGroupId)
            .build();
    return createInterceptDeploymentGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment group in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   CreateInterceptDeploymentGroupRequest request =
   *       CreateInterceptDeploymentGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInterceptDeploymentGroupId("interceptDeploymentGroupId1356790995")
   *           .setInterceptDeploymentGroup(InterceptDeploymentGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   InterceptDeploymentGroup response =
   *       interceptClient.createInterceptDeploymentGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptDeploymentGroup, OperationMetadata>
      createInterceptDeploymentGroupAsync(CreateInterceptDeploymentGroupRequest request) {
    return createInterceptDeploymentGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment group in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   CreateInterceptDeploymentGroupRequest request =
   *       CreateInterceptDeploymentGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInterceptDeploymentGroupId("interceptDeploymentGroupId1356790995")
   *           .setInterceptDeploymentGroup(InterceptDeploymentGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<InterceptDeploymentGroup, OperationMetadata> future =
   *       interceptClient.createInterceptDeploymentGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   InterceptDeploymentGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
      createInterceptDeploymentGroupOperationCallable() {
    return stub.createInterceptDeploymentGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment group in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   CreateInterceptDeploymentGroupRequest request =
   *       CreateInterceptDeploymentGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInterceptDeploymentGroupId("interceptDeploymentGroupId1356790995")
   *           .setInterceptDeploymentGroup(InterceptDeploymentGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       interceptClient.createInterceptDeploymentGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInterceptDeploymentGroupRequest, Operation>
      createInterceptDeploymentGroupCallable() {
    return stub.createInterceptDeploymentGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a deployment group. See https://google.aip.dev/134.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   InterceptDeploymentGroup interceptDeploymentGroup =
   *       InterceptDeploymentGroup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   InterceptDeploymentGroup response =
   *       interceptClient
   *           .updateInterceptDeploymentGroupAsync(interceptDeploymentGroup, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param interceptDeploymentGroup Required. The deployment group to update.
   * @param updateMask Optional. The list of fields to update. Fields are specified relative to the
   *     deployment group (e.g. `description`; &#42;not&#42;
   *     `intercept_deployment_group.description`). See https://google.aip.dev/161 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptDeploymentGroup, OperationMetadata>
      updateInterceptDeploymentGroupAsync(
          InterceptDeploymentGroup interceptDeploymentGroup, FieldMask updateMask) {
    UpdateInterceptDeploymentGroupRequest request =
        UpdateInterceptDeploymentGroupRequest.newBuilder()
            .setInterceptDeploymentGroup(interceptDeploymentGroup)
            .setUpdateMask(updateMask)
            .build();
    return updateInterceptDeploymentGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a deployment group. See https://google.aip.dev/134.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   UpdateInterceptDeploymentGroupRequest request =
   *       UpdateInterceptDeploymentGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInterceptDeploymentGroup(InterceptDeploymentGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   InterceptDeploymentGroup response =
   *       interceptClient.updateInterceptDeploymentGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptDeploymentGroup, OperationMetadata>
      updateInterceptDeploymentGroupAsync(UpdateInterceptDeploymentGroupRequest request) {
    return updateInterceptDeploymentGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a deployment group. See https://google.aip.dev/134.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   UpdateInterceptDeploymentGroupRequest request =
   *       UpdateInterceptDeploymentGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInterceptDeploymentGroup(InterceptDeploymentGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<InterceptDeploymentGroup, OperationMetadata> future =
   *       interceptClient.updateInterceptDeploymentGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   InterceptDeploymentGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
      updateInterceptDeploymentGroupOperationCallable() {
    return stub.updateInterceptDeploymentGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a deployment group. See https://google.aip.dev/134.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   UpdateInterceptDeploymentGroupRequest request =
   *       UpdateInterceptDeploymentGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInterceptDeploymentGroup(InterceptDeploymentGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       interceptClient.updateInterceptDeploymentGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateInterceptDeploymentGroupRequest, Operation>
      updateInterceptDeploymentGroupCallable() {
    return stub.updateInterceptDeploymentGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a deployment group. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   InterceptDeploymentGroupName name =
   *       InterceptDeploymentGroupName.of(
   *           "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]");
   *   interceptClient.deleteInterceptDeploymentGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The deployment group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInterceptDeploymentGroupAsync(
      InterceptDeploymentGroupName name) {
    DeleteInterceptDeploymentGroupRequest request =
        DeleteInterceptDeploymentGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteInterceptDeploymentGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a deployment group. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   String name =
   *       InterceptDeploymentGroupName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
   *           .toString();
   *   interceptClient.deleteInterceptDeploymentGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The deployment group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInterceptDeploymentGroupAsync(
      String name) {
    DeleteInterceptDeploymentGroupRequest request =
        DeleteInterceptDeploymentGroupRequest.newBuilder().setName(name).build();
    return deleteInterceptDeploymentGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a deployment group. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   DeleteInterceptDeploymentGroupRequest request =
   *       DeleteInterceptDeploymentGroupRequest.newBuilder()
   *           .setName(
   *               InterceptDeploymentGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   interceptClient.deleteInterceptDeploymentGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInterceptDeploymentGroupAsync(
      DeleteInterceptDeploymentGroupRequest request) {
    return deleteInterceptDeploymentGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a deployment group. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   DeleteInterceptDeploymentGroupRequest request =
   *       DeleteInterceptDeploymentGroupRequest.newBuilder()
   *           .setName(
   *               InterceptDeploymentGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       interceptClient.deleteInterceptDeploymentGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInterceptDeploymentGroupRequest, Empty, OperationMetadata>
      deleteInterceptDeploymentGroupOperationCallable() {
    return stub.deleteInterceptDeploymentGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a deployment group. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   DeleteInterceptDeploymentGroupRequest request =
   *       DeleteInterceptDeploymentGroupRequest.newBuilder()
   *           .setName(
   *               InterceptDeploymentGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       interceptClient.deleteInterceptDeploymentGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInterceptDeploymentGroupRequest, Operation>
      deleteInterceptDeploymentGroupCallable() {
    return stub.deleteInterceptDeploymentGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists deployments in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (InterceptDeployment element :
   *       interceptClient.listInterceptDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of deployments. Example:
   *     `projects/123456789/locations/us-central1-a`. See https://google.aip.dev/132 for more
   *     details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterceptDeploymentsPagedResponse listInterceptDeployments(LocationName parent) {
    ListInterceptDeploymentsRequest request =
        ListInterceptDeploymentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInterceptDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists deployments in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (InterceptDeployment element :
   *       interceptClient.listInterceptDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of deployments. Example:
   *     `projects/123456789/locations/us-central1-a`. See https://google.aip.dev/132 for more
   *     details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterceptDeploymentsPagedResponse listInterceptDeployments(String parent) {
    ListInterceptDeploymentsRequest request =
        ListInterceptDeploymentsRequest.newBuilder().setParent(parent).build();
    return listInterceptDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists deployments in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   ListInterceptDeploymentsRequest request =
   *       ListInterceptDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (InterceptDeployment element :
   *       interceptClient.listInterceptDeployments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterceptDeploymentsPagedResponse listInterceptDeployments(
      ListInterceptDeploymentsRequest request) {
    return listInterceptDeploymentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists deployments in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   ListInterceptDeploymentsRequest request =
   *       ListInterceptDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<InterceptDeployment> future =
   *       interceptClient.listInterceptDeploymentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InterceptDeployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInterceptDeploymentsRequest, ListInterceptDeploymentsPagedResponse>
      listInterceptDeploymentsPagedCallable() {
    return stub.listInterceptDeploymentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists deployments in a given project and location. See https://google.aip.dev/132.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   ListInterceptDeploymentsRequest request =
   *       ListInterceptDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListInterceptDeploymentsResponse response =
   *         interceptClient.listInterceptDeploymentsCallable().call(request);
   *     for (InterceptDeployment element : response.getInterceptDeploymentsList()) {
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
  public final UnaryCallable<ListInterceptDeploymentsRequest, ListInterceptDeploymentsResponse>
      listInterceptDeploymentsCallable() {
    return stub.listInterceptDeploymentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific deployment. See https://google.aip.dev/131.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   InterceptDeploymentName name =
   *       InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]");
   *   InterceptDeployment response = interceptClient.getInterceptDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment to retrieve. Format:
   *     projects/{project}/locations/{location}/interceptDeployments/{intercept_deployment}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterceptDeployment getInterceptDeployment(InterceptDeploymentName name) {
    GetInterceptDeploymentRequest request =
        GetInterceptDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getInterceptDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific deployment. See https://google.aip.dev/131.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   String name =
   *       InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]")
   *           .toString();
   *   InterceptDeployment response = interceptClient.getInterceptDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment to retrieve. Format:
   *     projects/{project}/locations/{location}/interceptDeployments/{intercept_deployment}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterceptDeployment getInterceptDeployment(String name) {
    GetInterceptDeploymentRequest request =
        GetInterceptDeploymentRequest.newBuilder().setName(name).build();
    return getInterceptDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific deployment. See https://google.aip.dev/131.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   GetInterceptDeploymentRequest request =
   *       GetInterceptDeploymentRequest.newBuilder()
   *           .setName(
   *               InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   InterceptDeployment response = interceptClient.getInterceptDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterceptDeployment getInterceptDeployment(GetInterceptDeploymentRequest request) {
    return getInterceptDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific deployment. See https://google.aip.dev/131.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   GetInterceptDeploymentRequest request =
   *       GetInterceptDeploymentRequest.newBuilder()
   *           .setName(
   *               InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<InterceptDeployment> future =
   *       interceptClient.getInterceptDeploymentCallable().futureCall(request);
   *   // Do something.
   *   InterceptDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInterceptDeploymentRequest, InterceptDeployment>
      getInterceptDeploymentCallable() {
    return stub.getInterceptDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   InterceptDeployment interceptDeployment = InterceptDeployment.newBuilder().build();
   *   String interceptDeploymentId = "interceptDeploymentId-240023390";
   *   InterceptDeployment response =
   *       interceptClient
   *           .createInterceptDeploymentAsync(parent, interceptDeployment, interceptDeploymentId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this deployment will be created. Format:
   *     projects/{project}/locations/{location}
   * @param interceptDeployment Required. The deployment to create.
   * @param interceptDeploymentId Required. The ID to use for the new deployment, which will become
   *     the final component of the deployment's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptDeployment, OperationMetadata>
      createInterceptDeploymentAsync(
          LocationName parent,
          InterceptDeployment interceptDeployment,
          String interceptDeploymentId) {
    CreateInterceptDeploymentRequest request =
        CreateInterceptDeploymentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInterceptDeployment(interceptDeployment)
            .setInterceptDeploymentId(interceptDeploymentId)
            .build();
    return createInterceptDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   InterceptDeployment interceptDeployment = InterceptDeployment.newBuilder().build();
   *   String interceptDeploymentId = "interceptDeploymentId-240023390";
   *   InterceptDeployment response =
   *       interceptClient
   *           .createInterceptDeploymentAsync(parent, interceptDeployment, interceptDeploymentId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this deployment will be created. Format:
   *     projects/{project}/locations/{location}
   * @param interceptDeployment Required. The deployment to create.
   * @param interceptDeploymentId Required. The ID to use for the new deployment, which will become
   *     the final component of the deployment's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptDeployment, OperationMetadata>
      createInterceptDeploymentAsync(
          String parent, InterceptDeployment interceptDeployment, String interceptDeploymentId) {
    CreateInterceptDeploymentRequest request =
        CreateInterceptDeploymentRequest.newBuilder()
            .setParent(parent)
            .setInterceptDeployment(interceptDeployment)
            .setInterceptDeploymentId(interceptDeploymentId)
            .build();
    return createInterceptDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   CreateInterceptDeploymentRequest request =
   *       CreateInterceptDeploymentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInterceptDeploymentId("interceptDeploymentId-240023390")
   *           .setInterceptDeployment(InterceptDeployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   InterceptDeployment response = interceptClient.createInterceptDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptDeployment, OperationMetadata>
      createInterceptDeploymentAsync(CreateInterceptDeploymentRequest request) {
    return createInterceptDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   CreateInterceptDeploymentRequest request =
   *       CreateInterceptDeploymentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInterceptDeploymentId("interceptDeploymentId-240023390")
   *           .setInterceptDeployment(InterceptDeployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<InterceptDeployment, OperationMetadata> future =
   *       interceptClient.createInterceptDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   InterceptDeployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
      createInterceptDeploymentOperationCallable() {
    return stub.createInterceptDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a deployment in a given project and location. See https://google.aip.dev/133.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   CreateInterceptDeploymentRequest request =
   *       CreateInterceptDeploymentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInterceptDeploymentId("interceptDeploymentId-240023390")
   *           .setInterceptDeployment(InterceptDeployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       interceptClient.createInterceptDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInterceptDeploymentRequest, Operation>
      createInterceptDeploymentCallable() {
    return stub.createInterceptDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a deployment. See https://google.aip.dev/134.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   InterceptDeployment interceptDeployment = InterceptDeployment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   InterceptDeployment response =
   *       interceptClient.updateInterceptDeploymentAsync(interceptDeployment, updateMask).get();
   * }
   * }</pre>
   *
   * @param interceptDeployment Required. The deployment to update.
   * @param updateMask Optional. The list of fields to update. Fields are specified relative to the
   *     deployment (e.g. `description`; &#42;not&#42; `intercept_deployment.description`). See
   *     https://google.aip.dev/161 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptDeployment, OperationMetadata>
      updateInterceptDeploymentAsync(
          InterceptDeployment interceptDeployment, FieldMask updateMask) {
    UpdateInterceptDeploymentRequest request =
        UpdateInterceptDeploymentRequest.newBuilder()
            .setInterceptDeployment(interceptDeployment)
            .setUpdateMask(updateMask)
            .build();
    return updateInterceptDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a deployment. See https://google.aip.dev/134.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   UpdateInterceptDeploymentRequest request =
   *       UpdateInterceptDeploymentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInterceptDeployment(InterceptDeployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   InterceptDeployment response = interceptClient.updateInterceptDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterceptDeployment, OperationMetadata>
      updateInterceptDeploymentAsync(UpdateInterceptDeploymentRequest request) {
    return updateInterceptDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a deployment. See https://google.aip.dev/134.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   UpdateInterceptDeploymentRequest request =
   *       UpdateInterceptDeploymentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInterceptDeployment(InterceptDeployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<InterceptDeployment, OperationMetadata> future =
   *       interceptClient.updateInterceptDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   InterceptDeployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
      updateInterceptDeploymentOperationCallable() {
    return stub.updateInterceptDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a deployment. See https://google.aip.dev/134.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   UpdateInterceptDeploymentRequest request =
   *       UpdateInterceptDeploymentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInterceptDeployment(InterceptDeployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       interceptClient.updateInterceptDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateInterceptDeploymentRequest, Operation>
      updateInterceptDeploymentCallable() {
    return stub.updateInterceptDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a deployment. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   InterceptDeploymentName name =
   *       InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]");
   *   interceptClient.deleteInterceptDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInterceptDeploymentAsync(
      InterceptDeploymentName name) {
    DeleteInterceptDeploymentRequest request =
        DeleteInterceptDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteInterceptDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a deployment. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   String name =
   *       InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]")
   *           .toString();
   *   interceptClient.deleteInterceptDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInterceptDeploymentAsync(
      String name) {
    DeleteInterceptDeploymentRequest request =
        DeleteInterceptDeploymentRequest.newBuilder().setName(name).build();
    return deleteInterceptDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a deployment. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   DeleteInterceptDeploymentRequest request =
   *       DeleteInterceptDeploymentRequest.newBuilder()
   *           .setName(
   *               InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   interceptClient.deleteInterceptDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInterceptDeploymentAsync(
      DeleteInterceptDeploymentRequest request) {
    return deleteInterceptDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a deployment. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   DeleteInterceptDeploymentRequest request =
   *       DeleteInterceptDeploymentRequest.newBuilder()
   *           .setName(
   *               InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       interceptClient.deleteInterceptDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInterceptDeploymentRequest, Empty, OperationMetadata>
      deleteInterceptDeploymentOperationCallable() {
    return stub.deleteInterceptDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a deployment. See https://google.aip.dev/135.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   DeleteInterceptDeploymentRequest request =
   *       DeleteInterceptDeploymentRequest.newBuilder()
   *           .setName(
   *               InterceptDeploymentName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_DEPLOYMENT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       interceptClient.deleteInterceptDeploymentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInterceptDeploymentRequest, Operation>
      deleteInterceptDeploymentCallable() {
    return stub.deleteInterceptDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name] field:
   *
   * <p>&#42; &#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : interceptClient.listLocations(request).iterateAll()) {
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name] field:
   *
   * <p>&#42; &#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = interceptClient.listLocationsPagedCallable().futureCall(request);
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name] field:
   *
   * <p>&#42; &#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = interceptClient.listLocationsCallable().call(request);
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
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = interceptClient.getLocation(request);
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
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = interceptClient.getLocationCallable().futureCall(request);
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
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = interceptClient.setIamPolicy(request);
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
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = interceptClient.setIamPolicyCallable().futureCall(request);
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
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = interceptClient.getIamPolicy(request);
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
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = interceptClient.getIamPolicyCallable().futureCall(request);
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
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = interceptClient.testIamPermissions(request);
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
   * try (InterceptClient interceptClient = InterceptClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       interceptClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListInterceptEndpointGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListInterceptEndpointGroupsRequest,
          ListInterceptEndpointGroupsResponse,
          InterceptEndpointGroup,
          ListInterceptEndpointGroupsPage,
          ListInterceptEndpointGroupsFixedSizeCollection> {

    public static ApiFuture<ListInterceptEndpointGroupsPagedResponse> createAsync(
        PageContext<
                ListInterceptEndpointGroupsRequest,
                ListInterceptEndpointGroupsResponse,
                InterceptEndpointGroup>
            context,
        ApiFuture<ListInterceptEndpointGroupsResponse> futureResponse) {
      ApiFuture<ListInterceptEndpointGroupsPage> futurePage =
          ListInterceptEndpointGroupsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInterceptEndpointGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInterceptEndpointGroupsPagedResponse(ListInterceptEndpointGroupsPage page) {
      super(page, ListInterceptEndpointGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInterceptEndpointGroupsPage
      extends AbstractPage<
          ListInterceptEndpointGroupsRequest,
          ListInterceptEndpointGroupsResponse,
          InterceptEndpointGroup,
          ListInterceptEndpointGroupsPage> {

    private ListInterceptEndpointGroupsPage(
        PageContext<
                ListInterceptEndpointGroupsRequest,
                ListInterceptEndpointGroupsResponse,
                InterceptEndpointGroup>
            context,
        ListInterceptEndpointGroupsResponse response) {
      super(context, response);
    }

    private static ListInterceptEndpointGroupsPage createEmptyPage() {
      return new ListInterceptEndpointGroupsPage(null, null);
    }

    @Override
    protected ListInterceptEndpointGroupsPage createPage(
        PageContext<
                ListInterceptEndpointGroupsRequest,
                ListInterceptEndpointGroupsResponse,
                InterceptEndpointGroup>
            context,
        ListInterceptEndpointGroupsResponse response) {
      return new ListInterceptEndpointGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListInterceptEndpointGroupsPage> createPageAsync(
        PageContext<
                ListInterceptEndpointGroupsRequest,
                ListInterceptEndpointGroupsResponse,
                InterceptEndpointGroup>
            context,
        ApiFuture<ListInterceptEndpointGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInterceptEndpointGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInterceptEndpointGroupsRequest,
          ListInterceptEndpointGroupsResponse,
          InterceptEndpointGroup,
          ListInterceptEndpointGroupsPage,
          ListInterceptEndpointGroupsFixedSizeCollection> {

    private ListInterceptEndpointGroupsFixedSizeCollection(
        List<ListInterceptEndpointGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInterceptEndpointGroupsFixedSizeCollection createEmptyCollection() {
      return new ListInterceptEndpointGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInterceptEndpointGroupsFixedSizeCollection createCollection(
        List<ListInterceptEndpointGroupsPage> pages, int collectionSize) {
      return new ListInterceptEndpointGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInterceptEndpointGroupAssociationsPagedResponse
      extends AbstractPagedListResponse<
          ListInterceptEndpointGroupAssociationsRequest,
          ListInterceptEndpointGroupAssociationsResponse,
          InterceptEndpointGroupAssociation,
          ListInterceptEndpointGroupAssociationsPage,
          ListInterceptEndpointGroupAssociationsFixedSizeCollection> {

    public static ApiFuture<ListInterceptEndpointGroupAssociationsPagedResponse> createAsync(
        PageContext<
                ListInterceptEndpointGroupAssociationsRequest,
                ListInterceptEndpointGroupAssociationsResponse,
                InterceptEndpointGroupAssociation>
            context,
        ApiFuture<ListInterceptEndpointGroupAssociationsResponse> futureResponse) {
      ApiFuture<ListInterceptEndpointGroupAssociationsPage> futurePage =
          ListInterceptEndpointGroupAssociationsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInterceptEndpointGroupAssociationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInterceptEndpointGroupAssociationsPagedResponse(
        ListInterceptEndpointGroupAssociationsPage page) {
      super(
          page, ListInterceptEndpointGroupAssociationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInterceptEndpointGroupAssociationsPage
      extends AbstractPage<
          ListInterceptEndpointGroupAssociationsRequest,
          ListInterceptEndpointGroupAssociationsResponse,
          InterceptEndpointGroupAssociation,
          ListInterceptEndpointGroupAssociationsPage> {

    private ListInterceptEndpointGroupAssociationsPage(
        PageContext<
                ListInterceptEndpointGroupAssociationsRequest,
                ListInterceptEndpointGroupAssociationsResponse,
                InterceptEndpointGroupAssociation>
            context,
        ListInterceptEndpointGroupAssociationsResponse response) {
      super(context, response);
    }

    private static ListInterceptEndpointGroupAssociationsPage createEmptyPage() {
      return new ListInterceptEndpointGroupAssociationsPage(null, null);
    }

    @Override
    protected ListInterceptEndpointGroupAssociationsPage createPage(
        PageContext<
                ListInterceptEndpointGroupAssociationsRequest,
                ListInterceptEndpointGroupAssociationsResponse,
                InterceptEndpointGroupAssociation>
            context,
        ListInterceptEndpointGroupAssociationsResponse response) {
      return new ListInterceptEndpointGroupAssociationsPage(context, response);
    }

    @Override
    public ApiFuture<ListInterceptEndpointGroupAssociationsPage> createPageAsync(
        PageContext<
                ListInterceptEndpointGroupAssociationsRequest,
                ListInterceptEndpointGroupAssociationsResponse,
                InterceptEndpointGroupAssociation>
            context,
        ApiFuture<ListInterceptEndpointGroupAssociationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInterceptEndpointGroupAssociationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInterceptEndpointGroupAssociationsRequest,
          ListInterceptEndpointGroupAssociationsResponse,
          InterceptEndpointGroupAssociation,
          ListInterceptEndpointGroupAssociationsPage,
          ListInterceptEndpointGroupAssociationsFixedSizeCollection> {

    private ListInterceptEndpointGroupAssociationsFixedSizeCollection(
        List<ListInterceptEndpointGroupAssociationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInterceptEndpointGroupAssociationsFixedSizeCollection
        createEmptyCollection() {
      return new ListInterceptEndpointGroupAssociationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInterceptEndpointGroupAssociationsFixedSizeCollection createCollection(
        List<ListInterceptEndpointGroupAssociationsPage> pages, int collectionSize) {
      return new ListInterceptEndpointGroupAssociationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInterceptDeploymentGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListInterceptDeploymentGroupsRequest,
          ListInterceptDeploymentGroupsResponse,
          InterceptDeploymentGroup,
          ListInterceptDeploymentGroupsPage,
          ListInterceptDeploymentGroupsFixedSizeCollection> {

    public static ApiFuture<ListInterceptDeploymentGroupsPagedResponse> createAsync(
        PageContext<
                ListInterceptDeploymentGroupsRequest,
                ListInterceptDeploymentGroupsResponse,
                InterceptDeploymentGroup>
            context,
        ApiFuture<ListInterceptDeploymentGroupsResponse> futureResponse) {
      ApiFuture<ListInterceptDeploymentGroupsPage> futurePage =
          ListInterceptDeploymentGroupsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInterceptDeploymentGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInterceptDeploymentGroupsPagedResponse(ListInterceptDeploymentGroupsPage page) {
      super(page, ListInterceptDeploymentGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInterceptDeploymentGroupsPage
      extends AbstractPage<
          ListInterceptDeploymentGroupsRequest,
          ListInterceptDeploymentGroupsResponse,
          InterceptDeploymentGroup,
          ListInterceptDeploymentGroupsPage> {

    private ListInterceptDeploymentGroupsPage(
        PageContext<
                ListInterceptDeploymentGroupsRequest,
                ListInterceptDeploymentGroupsResponse,
                InterceptDeploymentGroup>
            context,
        ListInterceptDeploymentGroupsResponse response) {
      super(context, response);
    }

    private static ListInterceptDeploymentGroupsPage createEmptyPage() {
      return new ListInterceptDeploymentGroupsPage(null, null);
    }

    @Override
    protected ListInterceptDeploymentGroupsPage createPage(
        PageContext<
                ListInterceptDeploymentGroupsRequest,
                ListInterceptDeploymentGroupsResponse,
                InterceptDeploymentGroup>
            context,
        ListInterceptDeploymentGroupsResponse response) {
      return new ListInterceptDeploymentGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListInterceptDeploymentGroupsPage> createPageAsync(
        PageContext<
                ListInterceptDeploymentGroupsRequest,
                ListInterceptDeploymentGroupsResponse,
                InterceptDeploymentGroup>
            context,
        ApiFuture<ListInterceptDeploymentGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInterceptDeploymentGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInterceptDeploymentGroupsRequest,
          ListInterceptDeploymentGroupsResponse,
          InterceptDeploymentGroup,
          ListInterceptDeploymentGroupsPage,
          ListInterceptDeploymentGroupsFixedSizeCollection> {

    private ListInterceptDeploymentGroupsFixedSizeCollection(
        List<ListInterceptDeploymentGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInterceptDeploymentGroupsFixedSizeCollection createEmptyCollection() {
      return new ListInterceptDeploymentGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInterceptDeploymentGroupsFixedSizeCollection createCollection(
        List<ListInterceptDeploymentGroupsPage> pages, int collectionSize) {
      return new ListInterceptDeploymentGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInterceptDeploymentsPagedResponse
      extends AbstractPagedListResponse<
          ListInterceptDeploymentsRequest,
          ListInterceptDeploymentsResponse,
          InterceptDeployment,
          ListInterceptDeploymentsPage,
          ListInterceptDeploymentsFixedSizeCollection> {

    public static ApiFuture<ListInterceptDeploymentsPagedResponse> createAsync(
        PageContext<
                ListInterceptDeploymentsRequest,
                ListInterceptDeploymentsResponse,
                InterceptDeployment>
            context,
        ApiFuture<ListInterceptDeploymentsResponse> futureResponse) {
      ApiFuture<ListInterceptDeploymentsPage> futurePage =
          ListInterceptDeploymentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInterceptDeploymentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInterceptDeploymentsPagedResponse(ListInterceptDeploymentsPage page) {
      super(page, ListInterceptDeploymentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInterceptDeploymentsPage
      extends AbstractPage<
          ListInterceptDeploymentsRequest,
          ListInterceptDeploymentsResponse,
          InterceptDeployment,
          ListInterceptDeploymentsPage> {

    private ListInterceptDeploymentsPage(
        PageContext<
                ListInterceptDeploymentsRequest,
                ListInterceptDeploymentsResponse,
                InterceptDeployment>
            context,
        ListInterceptDeploymentsResponse response) {
      super(context, response);
    }

    private static ListInterceptDeploymentsPage createEmptyPage() {
      return new ListInterceptDeploymentsPage(null, null);
    }

    @Override
    protected ListInterceptDeploymentsPage createPage(
        PageContext<
                ListInterceptDeploymentsRequest,
                ListInterceptDeploymentsResponse,
                InterceptDeployment>
            context,
        ListInterceptDeploymentsResponse response) {
      return new ListInterceptDeploymentsPage(context, response);
    }

    @Override
    public ApiFuture<ListInterceptDeploymentsPage> createPageAsync(
        PageContext<
                ListInterceptDeploymentsRequest,
                ListInterceptDeploymentsResponse,
                InterceptDeployment>
            context,
        ApiFuture<ListInterceptDeploymentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInterceptDeploymentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInterceptDeploymentsRequest,
          ListInterceptDeploymentsResponse,
          InterceptDeployment,
          ListInterceptDeploymentsPage,
          ListInterceptDeploymentsFixedSizeCollection> {

    private ListInterceptDeploymentsFixedSizeCollection(
        List<ListInterceptDeploymentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInterceptDeploymentsFixedSizeCollection createEmptyCollection() {
      return new ListInterceptDeploymentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInterceptDeploymentsFixedSizeCollection createCollection(
        List<ListInterceptDeploymentsPage> pages, int collectionSize) {
      return new ListInterceptDeploymentsFixedSizeCollection(pages, collectionSize);
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
