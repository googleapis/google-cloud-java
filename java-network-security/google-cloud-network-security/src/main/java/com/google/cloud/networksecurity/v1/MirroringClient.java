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
import com.google.cloud.networksecurity.v1.stub.MirroringStub;
import com.google.cloud.networksecurity.v1.stub.MirroringStubSettings;
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
 * Service Description: PM2 is the "out-of-band" flavor of the Network Security Integrations
 * product.
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
 * try (MirroringClient mirroringClient = MirroringClient.create()) {
 *   MirroringEndpointGroupName name =
 *       MirroringEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]");
 *   MirroringEndpointGroup response = mirroringClient.getMirroringEndpointGroup(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MirroringClient object to clean up resources such as
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
 *      <td><p> ListMirroringEndpointGroups</td>
 *      <td><p> Lists endpoint groups in a given project and location. See https://google.aip.dev/132.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMirroringEndpointGroups(ListMirroringEndpointGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMirroringEndpointGroups(LocationName parent)
 *           <li><p> listMirroringEndpointGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMirroringEndpointGroupsPagedCallable()
 *           <li><p> listMirroringEndpointGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMirroringEndpointGroup</td>
 *      <td><p> Gets a specific endpoint group. See https://google.aip.dev/131.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMirroringEndpointGroup(GetMirroringEndpointGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMirroringEndpointGroup(MirroringEndpointGroupName name)
 *           <li><p> getMirroringEndpointGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMirroringEndpointGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateMirroringEndpointGroup</td>
 *      <td><p> Creates an endpoint group in a given project and location. See https://google.aip.dev/133.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMirroringEndpointGroupAsync(CreateMirroringEndpointGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createMirroringEndpointGroupAsync(LocationName parent, MirroringEndpointGroup mirroringEndpointGroup, String mirroringEndpointGroupId)
 *           <li><p> createMirroringEndpointGroupAsync(String parent, MirroringEndpointGroup mirroringEndpointGroup, String mirroringEndpointGroupId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMirroringEndpointGroupOperationCallable()
 *           <li><p> createMirroringEndpointGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMirroringEndpointGroup</td>
 *      <td><p> Updates an endpoint group. See https://google.aip.dev/134.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMirroringEndpointGroupAsync(UpdateMirroringEndpointGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateMirroringEndpointGroupAsync(MirroringEndpointGroup mirroringEndpointGroup, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMirroringEndpointGroupOperationCallable()
 *           <li><p> updateMirroringEndpointGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMirroringEndpointGroup</td>
 *      <td><p> Deletes an endpoint group. See https://google.aip.dev/135.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMirroringEndpointGroupAsync(DeleteMirroringEndpointGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteMirroringEndpointGroupAsync(MirroringEndpointGroupName name)
 *           <li><p> deleteMirroringEndpointGroupAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMirroringEndpointGroupOperationCallable()
 *           <li><p> deleteMirroringEndpointGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMirroringEndpointGroupAssociations</td>
 *      <td><p> Lists associations in a given project and location. See https://google.aip.dev/132.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMirroringEndpointGroupAssociations(ListMirroringEndpointGroupAssociationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMirroringEndpointGroupAssociations(LocationName parent)
 *           <li><p> listMirroringEndpointGroupAssociations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMirroringEndpointGroupAssociationsPagedCallable()
 *           <li><p> listMirroringEndpointGroupAssociationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMirroringEndpointGroupAssociation</td>
 *      <td><p> Gets a specific association. See https://google.aip.dev/131.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMirroringEndpointGroupAssociation(GetMirroringEndpointGroupAssociationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMirroringEndpointGroupAssociation(MirroringEndpointGroupAssociationName name)
 *           <li><p> getMirroringEndpointGroupAssociation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMirroringEndpointGroupAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateMirroringEndpointGroupAssociation</td>
 *      <td><p> Creates an association in a given project and location. See https://google.aip.dev/133.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMirroringEndpointGroupAssociationAsync(CreateMirroringEndpointGroupAssociationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createMirroringEndpointGroupAssociationAsync(LocationName parent, MirroringEndpointGroupAssociation mirroringEndpointGroupAssociation, String mirroringEndpointGroupAssociationId)
 *           <li><p> createMirroringEndpointGroupAssociationAsync(String parent, MirroringEndpointGroupAssociation mirroringEndpointGroupAssociation, String mirroringEndpointGroupAssociationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMirroringEndpointGroupAssociationOperationCallable()
 *           <li><p> createMirroringEndpointGroupAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMirroringEndpointGroupAssociation</td>
 *      <td><p> Updates an association. See https://google.aip.dev/134.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMirroringEndpointGroupAssociationAsync(UpdateMirroringEndpointGroupAssociationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateMirroringEndpointGroupAssociationAsync(MirroringEndpointGroupAssociation mirroringEndpointGroupAssociation, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMirroringEndpointGroupAssociationOperationCallable()
 *           <li><p> updateMirroringEndpointGroupAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMirroringEndpointGroupAssociation</td>
 *      <td><p> Deletes an association. See https://google.aip.dev/135.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMirroringEndpointGroupAssociationAsync(DeleteMirroringEndpointGroupAssociationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteMirroringEndpointGroupAssociationAsync(MirroringEndpointGroupAssociationName name)
 *           <li><p> deleteMirroringEndpointGroupAssociationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMirroringEndpointGroupAssociationOperationCallable()
 *           <li><p> deleteMirroringEndpointGroupAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMirroringDeploymentGroups</td>
 *      <td><p> Lists deployment groups in a given project and location. See https://google.aip.dev/132.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMirroringDeploymentGroups(ListMirroringDeploymentGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMirroringDeploymentGroups(LocationName parent)
 *           <li><p> listMirroringDeploymentGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMirroringDeploymentGroupsPagedCallable()
 *           <li><p> listMirroringDeploymentGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMirroringDeploymentGroup</td>
 *      <td><p> Gets a specific deployment group. See https://google.aip.dev/131.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMirroringDeploymentGroup(GetMirroringDeploymentGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMirroringDeploymentGroup(MirroringDeploymentGroupName name)
 *           <li><p> getMirroringDeploymentGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMirroringDeploymentGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateMirroringDeploymentGroup</td>
 *      <td><p> Creates a deployment group in a given project and location. See https://google.aip.dev/133.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMirroringDeploymentGroupAsync(CreateMirroringDeploymentGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createMirroringDeploymentGroupAsync(LocationName parent, MirroringDeploymentGroup mirroringDeploymentGroup, String mirroringDeploymentGroupId)
 *           <li><p> createMirroringDeploymentGroupAsync(String parent, MirroringDeploymentGroup mirroringDeploymentGroup, String mirroringDeploymentGroupId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMirroringDeploymentGroupOperationCallable()
 *           <li><p> createMirroringDeploymentGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMirroringDeploymentGroup</td>
 *      <td><p> Updates a deployment group. See https://google.aip.dev/134.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMirroringDeploymentGroupAsync(UpdateMirroringDeploymentGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateMirroringDeploymentGroupAsync(MirroringDeploymentGroup mirroringDeploymentGroup, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMirroringDeploymentGroupOperationCallable()
 *           <li><p> updateMirroringDeploymentGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMirroringDeploymentGroup</td>
 *      <td><p> Deletes a deployment group. See https://google.aip.dev/135.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMirroringDeploymentGroupAsync(DeleteMirroringDeploymentGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteMirroringDeploymentGroupAsync(MirroringDeploymentGroupName name)
 *           <li><p> deleteMirroringDeploymentGroupAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMirroringDeploymentGroupOperationCallable()
 *           <li><p> deleteMirroringDeploymentGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMirroringDeployments</td>
 *      <td><p> Lists deployments in a given project and location. See https://google.aip.dev/132.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMirroringDeployments(ListMirroringDeploymentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMirroringDeployments(LocationName parent)
 *           <li><p> listMirroringDeployments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMirroringDeploymentsPagedCallable()
 *           <li><p> listMirroringDeploymentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMirroringDeployment</td>
 *      <td><p> Gets a specific deployment. See https://google.aip.dev/131.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMirroringDeployment(GetMirroringDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMirroringDeployment(MirroringDeploymentName name)
 *           <li><p> getMirroringDeployment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMirroringDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateMirroringDeployment</td>
 *      <td><p> Creates a deployment in a given project and location. See https://google.aip.dev/133.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMirroringDeploymentAsync(CreateMirroringDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createMirroringDeploymentAsync(LocationName parent, MirroringDeployment mirroringDeployment, String mirroringDeploymentId)
 *           <li><p> createMirroringDeploymentAsync(String parent, MirroringDeployment mirroringDeployment, String mirroringDeploymentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMirroringDeploymentOperationCallable()
 *           <li><p> createMirroringDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMirroringDeployment</td>
 *      <td><p> Updates a deployment. See https://google.aip.dev/134.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMirroringDeploymentAsync(UpdateMirroringDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateMirroringDeploymentAsync(MirroringDeployment mirroringDeployment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMirroringDeploymentOperationCallable()
 *           <li><p> updateMirroringDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMirroringDeployment</td>
 *      <td><p> Deletes a deployment. See https://google.aip.dev/135.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMirroringDeploymentAsync(DeleteMirroringDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteMirroringDeploymentAsync(MirroringDeploymentName name)
 *           <li><p> deleteMirroringDeploymentAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMirroringDeploymentOperationCallable()
 *           <li><p> deleteMirroringDeploymentCallable()
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
 * <p>This class can be customized by passing in a custom instance of MirroringSettings to create().
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
 * MirroringSettings mirroringSettings =
 *     MirroringSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MirroringClient mirroringClient = MirroringClient.create(mirroringSettings);
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
 * MirroringSettings mirroringSettings =
 *     MirroringSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MirroringClient mirroringClient = MirroringClient.create(mirroringSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class MirroringClient implements BackgroundResource {
  private final MirroringSettings settings;
  private final MirroringStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of MirroringClient with default settings. */
  public static final MirroringClient create() throws IOException {
    return create(MirroringSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MirroringClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MirroringClient create(MirroringSettings settings) throws IOException {
    return new MirroringClient(settings);
  }

  /**
   * Constructs an instance of MirroringClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(MirroringSettings).
   */
  public static final MirroringClient create(MirroringStub stub) {
    return new MirroringClient(stub);
  }

  /**
   * Constructs an instance of MirroringClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected MirroringClient(MirroringSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MirroringStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected MirroringClient(MirroringStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final MirroringSettings getSettings() {
    return settings;
  }

  public MirroringStub getStub() {
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (MirroringEndpointGroup element :
   *       mirroringClient.listMirroringEndpointGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of endpoint groups. Example:
   *     `projects/123456789/locations/global`. See https://google.aip.dev/132 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMirroringEndpointGroupsPagedResponse listMirroringEndpointGroups(
      LocationName parent) {
    ListMirroringEndpointGroupsRequest request =
        ListMirroringEndpointGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMirroringEndpointGroups(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (MirroringEndpointGroup element :
   *       mirroringClient.listMirroringEndpointGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of endpoint groups. Example:
   *     `projects/123456789/locations/global`. See https://google.aip.dev/132 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMirroringEndpointGroupsPagedResponse listMirroringEndpointGroups(String parent) {
    ListMirroringEndpointGroupsRequest request =
        ListMirroringEndpointGroupsRequest.newBuilder().setParent(parent).build();
    return listMirroringEndpointGroups(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   ListMirroringEndpointGroupsRequest request =
   *       ListMirroringEndpointGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (MirroringEndpointGroup element :
   *       mirroringClient.listMirroringEndpointGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMirroringEndpointGroupsPagedResponse listMirroringEndpointGroups(
      ListMirroringEndpointGroupsRequest request) {
    return listMirroringEndpointGroupsPagedCallable().call(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   ListMirroringEndpointGroupsRequest request =
   *       ListMirroringEndpointGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<MirroringEndpointGroup> future =
   *       mirroringClient.listMirroringEndpointGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MirroringEndpointGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListMirroringEndpointGroupsRequest, ListMirroringEndpointGroupsPagedResponse>
      listMirroringEndpointGroupsPagedCallable() {
    return stub.listMirroringEndpointGroupsPagedCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   ListMirroringEndpointGroupsRequest request =
   *       ListMirroringEndpointGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListMirroringEndpointGroupsResponse response =
   *         mirroringClient.listMirroringEndpointGroupsCallable().call(request);
   *     for (MirroringEndpointGroup element : response.getMirroringEndpointGroupsList()) {
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
          ListMirroringEndpointGroupsRequest, ListMirroringEndpointGroupsResponse>
      listMirroringEndpointGroupsCallable() {
    return stub.listMirroringEndpointGroupsCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   MirroringEndpointGroupName name =
   *       MirroringEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]");
   *   MirroringEndpointGroup response = mirroringClient.getMirroringEndpointGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the endpoint group to retrieve. Format:
   *     projects/{project}/locations/{location}/mirroringEndpointGroups/{mirroring_endpoint_group}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MirroringEndpointGroup getMirroringEndpointGroup(MirroringEndpointGroupName name) {
    GetMirroringEndpointGroupRequest request =
        GetMirroringEndpointGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMirroringEndpointGroup(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   String name =
   *       MirroringEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
   *           .toString();
   *   MirroringEndpointGroup response = mirroringClient.getMirroringEndpointGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the endpoint group to retrieve. Format:
   *     projects/{project}/locations/{location}/mirroringEndpointGroups/{mirroring_endpoint_group}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MirroringEndpointGroup getMirroringEndpointGroup(String name) {
    GetMirroringEndpointGroupRequest request =
        GetMirroringEndpointGroupRequest.newBuilder().setName(name).build();
    return getMirroringEndpointGroup(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   GetMirroringEndpointGroupRequest request =
   *       GetMirroringEndpointGroupRequest.newBuilder()
   *           .setName(
   *               MirroringEndpointGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
   *                   .toString())
   *           .build();
   *   MirroringEndpointGroup response = mirroringClient.getMirroringEndpointGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MirroringEndpointGroup getMirroringEndpointGroup(
      GetMirroringEndpointGroupRequest request) {
    return getMirroringEndpointGroupCallable().call(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   GetMirroringEndpointGroupRequest request =
   *       GetMirroringEndpointGroupRequest.newBuilder()
   *           .setName(
   *               MirroringEndpointGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<MirroringEndpointGroup> future =
   *       mirroringClient.getMirroringEndpointGroupCallable().futureCall(request);
   *   // Do something.
   *   MirroringEndpointGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMirroringEndpointGroupRequest, MirroringEndpointGroup>
      getMirroringEndpointGroupCallable() {
    return stub.getMirroringEndpointGroupCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   MirroringEndpointGroup mirroringEndpointGroup = MirroringEndpointGroup.newBuilder().build();
   *   String mirroringEndpointGroupId = "mirroringEndpointGroupId436276834";
   *   MirroringEndpointGroup response =
   *       mirroringClient
   *           .createMirroringEndpointGroupAsync(
   *               parent, mirroringEndpointGroup, mirroringEndpointGroupId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this endpoint group will be created. Format:
   *     projects/{project}/locations/{location}
   * @param mirroringEndpointGroup Required. The endpoint group to create.
   * @param mirroringEndpointGroupId Required. The ID to use for the endpoint group, which will
   *     become the final component of the endpoint group's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringEndpointGroup, OperationMetadata>
      createMirroringEndpointGroupAsync(
          LocationName parent,
          MirroringEndpointGroup mirroringEndpointGroup,
          String mirroringEndpointGroupId) {
    CreateMirroringEndpointGroupRequest request =
        CreateMirroringEndpointGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMirroringEndpointGroup(mirroringEndpointGroup)
            .setMirroringEndpointGroupId(mirroringEndpointGroupId)
            .build();
    return createMirroringEndpointGroupAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   MirroringEndpointGroup mirroringEndpointGroup = MirroringEndpointGroup.newBuilder().build();
   *   String mirroringEndpointGroupId = "mirroringEndpointGroupId436276834";
   *   MirroringEndpointGroup response =
   *       mirroringClient
   *           .createMirroringEndpointGroupAsync(
   *               parent, mirroringEndpointGroup, mirroringEndpointGroupId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this endpoint group will be created. Format:
   *     projects/{project}/locations/{location}
   * @param mirroringEndpointGroup Required. The endpoint group to create.
   * @param mirroringEndpointGroupId Required. The ID to use for the endpoint group, which will
   *     become the final component of the endpoint group's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringEndpointGroup, OperationMetadata>
      createMirroringEndpointGroupAsync(
          String parent,
          MirroringEndpointGroup mirroringEndpointGroup,
          String mirroringEndpointGroupId) {
    CreateMirroringEndpointGroupRequest request =
        CreateMirroringEndpointGroupRequest.newBuilder()
            .setParent(parent)
            .setMirroringEndpointGroup(mirroringEndpointGroup)
            .setMirroringEndpointGroupId(mirroringEndpointGroupId)
            .build();
    return createMirroringEndpointGroupAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   CreateMirroringEndpointGroupRequest request =
   *       CreateMirroringEndpointGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMirroringEndpointGroupId("mirroringEndpointGroupId436276834")
   *           .setMirroringEndpointGroup(MirroringEndpointGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MirroringEndpointGroup response =
   *       mirroringClient.createMirroringEndpointGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringEndpointGroup, OperationMetadata>
      createMirroringEndpointGroupAsync(CreateMirroringEndpointGroupRequest request) {
    return createMirroringEndpointGroupOperationCallable().futureCall(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   CreateMirroringEndpointGroupRequest request =
   *       CreateMirroringEndpointGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMirroringEndpointGroupId("mirroringEndpointGroupId436276834")
   *           .setMirroringEndpointGroup(MirroringEndpointGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MirroringEndpointGroup, OperationMetadata> future =
   *       mirroringClient.createMirroringEndpointGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   MirroringEndpointGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
      createMirroringEndpointGroupOperationCallable() {
    return stub.createMirroringEndpointGroupOperationCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   CreateMirroringEndpointGroupRequest request =
   *       CreateMirroringEndpointGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMirroringEndpointGroupId("mirroringEndpointGroupId436276834")
   *           .setMirroringEndpointGroup(MirroringEndpointGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       mirroringClient.createMirroringEndpointGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMirroringEndpointGroupRequest, Operation>
      createMirroringEndpointGroupCallable() {
    return stub.createMirroringEndpointGroupCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   MirroringEndpointGroup mirroringEndpointGroup = MirroringEndpointGroup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MirroringEndpointGroup response =
   *       mirroringClient
   *           .updateMirroringEndpointGroupAsync(mirroringEndpointGroup, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param mirroringEndpointGroup Required. The endpoint group to update.
   * @param updateMask Optional. The list of fields to update. Fields are specified relative to the
   *     endpoint group (e.g. `description`; &#42;not&#42; `mirroring_endpoint_group.description`).
   *     See https://google.aip.dev/161 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringEndpointGroup, OperationMetadata>
      updateMirroringEndpointGroupAsync(
          MirroringEndpointGroup mirroringEndpointGroup, FieldMask updateMask) {
    UpdateMirroringEndpointGroupRequest request =
        UpdateMirroringEndpointGroupRequest.newBuilder()
            .setMirroringEndpointGroup(mirroringEndpointGroup)
            .setUpdateMask(updateMask)
            .build();
    return updateMirroringEndpointGroupAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   UpdateMirroringEndpointGroupRequest request =
   *       UpdateMirroringEndpointGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMirroringEndpointGroup(MirroringEndpointGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MirroringEndpointGroup response =
   *       mirroringClient.updateMirroringEndpointGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringEndpointGroup, OperationMetadata>
      updateMirroringEndpointGroupAsync(UpdateMirroringEndpointGroupRequest request) {
    return updateMirroringEndpointGroupOperationCallable().futureCall(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   UpdateMirroringEndpointGroupRequest request =
   *       UpdateMirroringEndpointGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMirroringEndpointGroup(MirroringEndpointGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MirroringEndpointGroup, OperationMetadata> future =
   *       mirroringClient.updateMirroringEndpointGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   MirroringEndpointGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
      updateMirroringEndpointGroupOperationCallable() {
    return stub.updateMirroringEndpointGroupOperationCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   UpdateMirroringEndpointGroupRequest request =
   *       UpdateMirroringEndpointGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMirroringEndpointGroup(MirroringEndpointGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       mirroringClient.updateMirroringEndpointGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMirroringEndpointGroupRequest, Operation>
      updateMirroringEndpointGroupCallable() {
    return stub.updateMirroringEndpointGroupCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   MirroringEndpointGroupName name =
   *       MirroringEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]");
   *   mirroringClient.deleteMirroringEndpointGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The endpoint group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMirroringEndpointGroupAsync(
      MirroringEndpointGroupName name) {
    DeleteMirroringEndpointGroupRequest request =
        DeleteMirroringEndpointGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteMirroringEndpointGroupAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   String name =
   *       MirroringEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
   *           .toString();
   *   mirroringClient.deleteMirroringEndpointGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The endpoint group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMirroringEndpointGroupAsync(
      String name) {
    DeleteMirroringEndpointGroupRequest request =
        DeleteMirroringEndpointGroupRequest.newBuilder().setName(name).build();
    return deleteMirroringEndpointGroupAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   DeleteMirroringEndpointGroupRequest request =
   *       DeleteMirroringEndpointGroupRequest.newBuilder()
   *           .setName(
   *               MirroringEndpointGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   mirroringClient.deleteMirroringEndpointGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMirroringEndpointGroupAsync(
      DeleteMirroringEndpointGroupRequest request) {
    return deleteMirroringEndpointGroupOperationCallable().futureCall(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   DeleteMirroringEndpointGroupRequest request =
   *       DeleteMirroringEndpointGroupRequest.newBuilder()
   *           .setName(
   *               MirroringEndpointGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       mirroringClient.deleteMirroringEndpointGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteMirroringEndpointGroupRequest, Empty, OperationMetadata>
      deleteMirroringEndpointGroupOperationCallable() {
    return stub.deleteMirroringEndpointGroupOperationCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   DeleteMirroringEndpointGroupRequest request =
   *       DeleteMirroringEndpointGroupRequest.newBuilder()
   *           .setName(
   *               MirroringEndpointGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       mirroringClient.deleteMirroringEndpointGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMirroringEndpointGroupRequest, Operation>
      deleteMirroringEndpointGroupCallable() {
    return stub.deleteMirroringEndpointGroupCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (MirroringEndpointGroupAssociation element :
   *       mirroringClient.listMirroringEndpointGroupAssociations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of associations. Example:
   *     `projects/123456789/locations/global`. See https://google.aip.dev/132 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMirroringEndpointGroupAssociationsPagedResponse
      listMirroringEndpointGroupAssociations(LocationName parent) {
    ListMirroringEndpointGroupAssociationsRequest request =
        ListMirroringEndpointGroupAssociationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMirroringEndpointGroupAssociations(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (MirroringEndpointGroupAssociation element :
   *       mirroringClient.listMirroringEndpointGroupAssociations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of associations. Example:
   *     `projects/123456789/locations/global`. See https://google.aip.dev/132 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMirroringEndpointGroupAssociationsPagedResponse
      listMirroringEndpointGroupAssociations(String parent) {
    ListMirroringEndpointGroupAssociationsRequest request =
        ListMirroringEndpointGroupAssociationsRequest.newBuilder().setParent(parent).build();
    return listMirroringEndpointGroupAssociations(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   ListMirroringEndpointGroupAssociationsRequest request =
   *       ListMirroringEndpointGroupAssociationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (MirroringEndpointGroupAssociation element :
   *       mirroringClient.listMirroringEndpointGroupAssociations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMirroringEndpointGroupAssociationsPagedResponse
      listMirroringEndpointGroupAssociations(
          ListMirroringEndpointGroupAssociationsRequest request) {
    return listMirroringEndpointGroupAssociationsPagedCallable().call(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   ListMirroringEndpointGroupAssociationsRequest request =
   *       ListMirroringEndpointGroupAssociationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<MirroringEndpointGroupAssociation> future =
   *       mirroringClient.listMirroringEndpointGroupAssociationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MirroringEndpointGroupAssociation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListMirroringEndpointGroupAssociationsRequest,
          ListMirroringEndpointGroupAssociationsPagedResponse>
      listMirroringEndpointGroupAssociationsPagedCallable() {
    return stub.listMirroringEndpointGroupAssociationsPagedCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   ListMirroringEndpointGroupAssociationsRequest request =
   *       ListMirroringEndpointGroupAssociationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListMirroringEndpointGroupAssociationsResponse response =
   *         mirroringClient.listMirroringEndpointGroupAssociationsCallable().call(request);
   *     for (MirroringEndpointGroupAssociation element :
   *         response.getMirroringEndpointGroupAssociationsList()) {
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
          ListMirroringEndpointGroupAssociationsRequest,
          ListMirroringEndpointGroupAssociationsResponse>
      listMirroringEndpointGroupAssociationsCallable() {
    return stub.listMirroringEndpointGroupAssociationsCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   MirroringEndpointGroupAssociationName name =
   *       MirroringEndpointGroupAssociationName.of(
   *           "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]");
   *   MirroringEndpointGroupAssociation response =
   *       mirroringClient.getMirroringEndpointGroupAssociation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the association to retrieve. Format:
   *     projects/{project}/locations/{location}/mirroringEndpointGroupAssociations/{mirroring_endpoint_group_association}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MirroringEndpointGroupAssociation getMirroringEndpointGroupAssociation(
      MirroringEndpointGroupAssociationName name) {
    GetMirroringEndpointGroupAssociationRequest request =
        GetMirroringEndpointGroupAssociationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMirroringEndpointGroupAssociation(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   String name =
   *       MirroringEndpointGroupAssociationName.of(
   *               "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]")
   *           .toString();
   *   MirroringEndpointGroupAssociation response =
   *       mirroringClient.getMirroringEndpointGroupAssociation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the association to retrieve. Format:
   *     projects/{project}/locations/{location}/mirroringEndpointGroupAssociations/{mirroring_endpoint_group_association}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MirroringEndpointGroupAssociation getMirroringEndpointGroupAssociation(String name) {
    GetMirroringEndpointGroupAssociationRequest request =
        GetMirroringEndpointGroupAssociationRequest.newBuilder().setName(name).build();
    return getMirroringEndpointGroupAssociation(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   GetMirroringEndpointGroupAssociationRequest request =
   *       GetMirroringEndpointGroupAssociationRequest.newBuilder()
   *           .setName(
   *               MirroringEndpointGroupAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]")
   *                   .toString())
   *           .build();
   *   MirroringEndpointGroupAssociation response =
   *       mirroringClient.getMirroringEndpointGroupAssociation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MirroringEndpointGroupAssociation getMirroringEndpointGroupAssociation(
      GetMirroringEndpointGroupAssociationRequest request) {
    return getMirroringEndpointGroupAssociationCallable().call(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   GetMirroringEndpointGroupAssociationRequest request =
   *       GetMirroringEndpointGroupAssociationRequest.newBuilder()
   *           .setName(
   *               MirroringEndpointGroupAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<MirroringEndpointGroupAssociation> future =
   *       mirroringClient.getMirroringEndpointGroupAssociationCallable().futureCall(request);
   *   // Do something.
   *   MirroringEndpointGroupAssociation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetMirroringEndpointGroupAssociationRequest, MirroringEndpointGroupAssociation>
      getMirroringEndpointGroupAssociationCallable() {
    return stub.getMirroringEndpointGroupAssociationCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   MirroringEndpointGroupAssociation mirroringEndpointGroupAssociation =
   *       MirroringEndpointGroupAssociation.newBuilder().build();
   *   String mirroringEndpointGroupAssociationId = "mirroringEndpointGroupAssociationId-1957886507";
   *   MirroringEndpointGroupAssociation response =
   *       mirroringClient
   *           .createMirroringEndpointGroupAssociationAsync(
   *               parent, mirroringEndpointGroupAssociation, mirroringEndpointGroupAssociationId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this association will be created. Format:
   *     projects/{project}/locations/{location}
   * @param mirroringEndpointGroupAssociation Required. The association to create.
   * @param mirroringEndpointGroupAssociationId Optional. The ID to use for the new association,
   *     which will become the final component of the endpoint group's resource name. If not
   *     provided, the server will generate a unique ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringEndpointGroupAssociation, OperationMetadata>
      createMirroringEndpointGroupAssociationAsync(
          LocationName parent,
          MirroringEndpointGroupAssociation mirroringEndpointGroupAssociation,
          String mirroringEndpointGroupAssociationId) {
    CreateMirroringEndpointGroupAssociationRequest request =
        CreateMirroringEndpointGroupAssociationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMirroringEndpointGroupAssociation(mirroringEndpointGroupAssociation)
            .setMirroringEndpointGroupAssociationId(mirroringEndpointGroupAssociationId)
            .build();
    return createMirroringEndpointGroupAssociationAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   MirroringEndpointGroupAssociation mirroringEndpointGroupAssociation =
   *       MirroringEndpointGroupAssociation.newBuilder().build();
   *   String mirroringEndpointGroupAssociationId = "mirroringEndpointGroupAssociationId-1957886507";
   *   MirroringEndpointGroupAssociation response =
   *       mirroringClient
   *           .createMirroringEndpointGroupAssociationAsync(
   *               parent, mirroringEndpointGroupAssociation, mirroringEndpointGroupAssociationId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this association will be created. Format:
   *     projects/{project}/locations/{location}
   * @param mirroringEndpointGroupAssociation Required. The association to create.
   * @param mirroringEndpointGroupAssociationId Optional. The ID to use for the new association,
   *     which will become the final component of the endpoint group's resource name. If not
   *     provided, the server will generate a unique ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringEndpointGroupAssociation, OperationMetadata>
      createMirroringEndpointGroupAssociationAsync(
          String parent,
          MirroringEndpointGroupAssociation mirroringEndpointGroupAssociation,
          String mirroringEndpointGroupAssociationId) {
    CreateMirroringEndpointGroupAssociationRequest request =
        CreateMirroringEndpointGroupAssociationRequest.newBuilder()
            .setParent(parent)
            .setMirroringEndpointGroupAssociation(mirroringEndpointGroupAssociation)
            .setMirroringEndpointGroupAssociationId(mirroringEndpointGroupAssociationId)
            .build();
    return createMirroringEndpointGroupAssociationAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   CreateMirroringEndpointGroupAssociationRequest request =
   *       CreateMirroringEndpointGroupAssociationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMirroringEndpointGroupAssociationId(
   *               "mirroringEndpointGroupAssociationId-1957886507")
   *           .setMirroringEndpointGroupAssociation(
   *               MirroringEndpointGroupAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MirroringEndpointGroupAssociation response =
   *       mirroringClient.createMirroringEndpointGroupAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringEndpointGroupAssociation, OperationMetadata>
      createMirroringEndpointGroupAssociationAsync(
          CreateMirroringEndpointGroupAssociationRequest request) {
    return createMirroringEndpointGroupAssociationOperationCallable().futureCall(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   CreateMirroringEndpointGroupAssociationRequest request =
   *       CreateMirroringEndpointGroupAssociationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMirroringEndpointGroupAssociationId(
   *               "mirroringEndpointGroupAssociationId-1957886507")
   *           .setMirroringEndpointGroupAssociation(
   *               MirroringEndpointGroupAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MirroringEndpointGroupAssociation, OperationMetadata> future =
   *       mirroringClient
   *           .createMirroringEndpointGroupAssociationOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   MirroringEndpointGroupAssociation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateMirroringEndpointGroupAssociationRequest,
          MirroringEndpointGroupAssociation,
          OperationMetadata>
      createMirroringEndpointGroupAssociationOperationCallable() {
    return stub.createMirroringEndpointGroupAssociationOperationCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   CreateMirroringEndpointGroupAssociationRequest request =
   *       CreateMirroringEndpointGroupAssociationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMirroringEndpointGroupAssociationId(
   *               "mirroringEndpointGroupAssociationId-1957886507")
   *           .setMirroringEndpointGroupAssociation(
   *               MirroringEndpointGroupAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       mirroringClient.createMirroringEndpointGroupAssociationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMirroringEndpointGroupAssociationRequest, Operation>
      createMirroringEndpointGroupAssociationCallable() {
    return stub.createMirroringEndpointGroupAssociationCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   MirroringEndpointGroupAssociation mirroringEndpointGroupAssociation =
   *       MirroringEndpointGroupAssociation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MirroringEndpointGroupAssociation response =
   *       mirroringClient
   *           .updateMirroringEndpointGroupAssociationAsync(
   *               mirroringEndpointGroupAssociation, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param mirroringEndpointGroupAssociation Required. The association to update.
   * @param updateMask Optional. The list of fields to update. Fields are specified relative to the
   *     association (e.g. `description`; &#42;not&#42;
   *     `mirroring_endpoint_group_association.description`). See https://google.aip.dev/161 for
   *     more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringEndpointGroupAssociation, OperationMetadata>
      updateMirroringEndpointGroupAssociationAsync(
          MirroringEndpointGroupAssociation mirroringEndpointGroupAssociation,
          FieldMask updateMask) {
    UpdateMirroringEndpointGroupAssociationRequest request =
        UpdateMirroringEndpointGroupAssociationRequest.newBuilder()
            .setMirroringEndpointGroupAssociation(mirroringEndpointGroupAssociation)
            .setUpdateMask(updateMask)
            .build();
    return updateMirroringEndpointGroupAssociationAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   UpdateMirroringEndpointGroupAssociationRequest request =
   *       UpdateMirroringEndpointGroupAssociationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMirroringEndpointGroupAssociation(
   *               MirroringEndpointGroupAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MirroringEndpointGroupAssociation response =
   *       mirroringClient.updateMirroringEndpointGroupAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringEndpointGroupAssociation, OperationMetadata>
      updateMirroringEndpointGroupAssociationAsync(
          UpdateMirroringEndpointGroupAssociationRequest request) {
    return updateMirroringEndpointGroupAssociationOperationCallable().futureCall(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   UpdateMirroringEndpointGroupAssociationRequest request =
   *       UpdateMirroringEndpointGroupAssociationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMirroringEndpointGroupAssociation(
   *               MirroringEndpointGroupAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MirroringEndpointGroupAssociation, OperationMetadata> future =
   *       mirroringClient
   *           .updateMirroringEndpointGroupAssociationOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   MirroringEndpointGroupAssociation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateMirroringEndpointGroupAssociationRequest,
          MirroringEndpointGroupAssociation,
          OperationMetadata>
      updateMirroringEndpointGroupAssociationOperationCallable() {
    return stub.updateMirroringEndpointGroupAssociationOperationCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   UpdateMirroringEndpointGroupAssociationRequest request =
   *       UpdateMirroringEndpointGroupAssociationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMirroringEndpointGroupAssociation(
   *               MirroringEndpointGroupAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       mirroringClient.updateMirroringEndpointGroupAssociationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMirroringEndpointGroupAssociationRequest, Operation>
      updateMirroringEndpointGroupAssociationCallable() {
    return stub.updateMirroringEndpointGroupAssociationCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   MirroringEndpointGroupAssociationName name =
   *       MirroringEndpointGroupAssociationName.of(
   *           "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]");
   *   mirroringClient.deleteMirroringEndpointGroupAssociationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The association to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata>
      deleteMirroringEndpointGroupAssociationAsync(MirroringEndpointGroupAssociationName name) {
    DeleteMirroringEndpointGroupAssociationRequest request =
        DeleteMirroringEndpointGroupAssociationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteMirroringEndpointGroupAssociationAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   String name =
   *       MirroringEndpointGroupAssociationName.of(
   *               "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]")
   *           .toString();
   *   mirroringClient.deleteMirroringEndpointGroupAssociationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The association to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata>
      deleteMirroringEndpointGroupAssociationAsync(String name) {
    DeleteMirroringEndpointGroupAssociationRequest request =
        DeleteMirroringEndpointGroupAssociationRequest.newBuilder().setName(name).build();
    return deleteMirroringEndpointGroupAssociationAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   DeleteMirroringEndpointGroupAssociationRequest request =
   *       DeleteMirroringEndpointGroupAssociationRequest.newBuilder()
   *           .setName(
   *               MirroringEndpointGroupAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   mirroringClient.deleteMirroringEndpointGroupAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata>
      deleteMirroringEndpointGroupAssociationAsync(
          DeleteMirroringEndpointGroupAssociationRequest request) {
    return deleteMirroringEndpointGroupAssociationOperationCallable().futureCall(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   DeleteMirroringEndpointGroupAssociationRequest request =
   *       DeleteMirroringEndpointGroupAssociationRequest.newBuilder()
   *           .setName(
   *               MirroringEndpointGroupAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       mirroringClient
   *           .deleteMirroringEndpointGroupAssociationOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteMirroringEndpointGroupAssociationRequest, Empty, OperationMetadata>
      deleteMirroringEndpointGroupAssociationOperationCallable() {
    return stub.deleteMirroringEndpointGroupAssociationOperationCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   DeleteMirroringEndpointGroupAssociationRequest request =
   *       DeleteMirroringEndpointGroupAssociationRequest.newBuilder()
   *           .setName(
   *               MirroringEndpointGroupAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP_ASSOCIATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       mirroringClient.deleteMirroringEndpointGroupAssociationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMirroringEndpointGroupAssociationRequest, Operation>
      deleteMirroringEndpointGroupAssociationCallable() {
    return stub.deleteMirroringEndpointGroupAssociationCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (MirroringDeploymentGroup element :
   *       mirroringClient.listMirroringDeploymentGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of deployment groups. Example:
   *     `projects/123456789/locations/global`. See https://google.aip.dev/132 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMirroringDeploymentGroupsPagedResponse listMirroringDeploymentGroups(
      LocationName parent) {
    ListMirroringDeploymentGroupsRequest request =
        ListMirroringDeploymentGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMirroringDeploymentGroups(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (MirroringDeploymentGroup element :
   *       mirroringClient.listMirroringDeploymentGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of deployment groups. Example:
   *     `projects/123456789/locations/global`. See https://google.aip.dev/132 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMirroringDeploymentGroupsPagedResponse listMirroringDeploymentGroups(
      String parent) {
    ListMirroringDeploymentGroupsRequest request =
        ListMirroringDeploymentGroupsRequest.newBuilder().setParent(parent).build();
    return listMirroringDeploymentGroups(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   ListMirroringDeploymentGroupsRequest request =
   *       ListMirroringDeploymentGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (MirroringDeploymentGroup element :
   *       mirroringClient.listMirroringDeploymentGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMirroringDeploymentGroupsPagedResponse listMirroringDeploymentGroups(
      ListMirroringDeploymentGroupsRequest request) {
    return listMirroringDeploymentGroupsPagedCallable().call(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   ListMirroringDeploymentGroupsRequest request =
   *       ListMirroringDeploymentGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<MirroringDeploymentGroup> future =
   *       mirroringClient.listMirroringDeploymentGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MirroringDeploymentGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListMirroringDeploymentGroupsRequest, ListMirroringDeploymentGroupsPagedResponse>
      listMirroringDeploymentGroupsPagedCallable() {
    return stub.listMirroringDeploymentGroupsPagedCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   ListMirroringDeploymentGroupsRequest request =
   *       ListMirroringDeploymentGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListMirroringDeploymentGroupsResponse response =
   *         mirroringClient.listMirroringDeploymentGroupsCallable().call(request);
   *     for (MirroringDeploymentGroup element : response.getMirroringDeploymentGroupsList()) {
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
          ListMirroringDeploymentGroupsRequest, ListMirroringDeploymentGroupsResponse>
      listMirroringDeploymentGroupsCallable() {
    return stub.listMirroringDeploymentGroupsCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   MirroringDeploymentGroupName name =
   *       MirroringDeploymentGroupName.of(
   *           "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]");
   *   MirroringDeploymentGroup response = mirroringClient.getMirroringDeploymentGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment group to retrieve. Format:
   *     projects/{project}/locations/{location}/mirroringDeploymentGroups/{mirroring_deployment_group}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MirroringDeploymentGroup getMirroringDeploymentGroup(
      MirroringDeploymentGroupName name) {
    GetMirroringDeploymentGroupRequest request =
        GetMirroringDeploymentGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMirroringDeploymentGroup(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   String name =
   *       MirroringDeploymentGroupName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
   *           .toString();
   *   MirroringDeploymentGroup response = mirroringClient.getMirroringDeploymentGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment group to retrieve. Format:
   *     projects/{project}/locations/{location}/mirroringDeploymentGroups/{mirroring_deployment_group}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MirroringDeploymentGroup getMirroringDeploymentGroup(String name) {
    GetMirroringDeploymentGroupRequest request =
        GetMirroringDeploymentGroupRequest.newBuilder().setName(name).build();
    return getMirroringDeploymentGroup(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   GetMirroringDeploymentGroupRequest request =
   *       GetMirroringDeploymentGroupRequest.newBuilder()
   *           .setName(
   *               MirroringDeploymentGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
   *                   .toString())
   *           .build();
   *   MirroringDeploymentGroup response = mirroringClient.getMirroringDeploymentGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MirroringDeploymentGroup getMirroringDeploymentGroup(
      GetMirroringDeploymentGroupRequest request) {
    return getMirroringDeploymentGroupCallable().call(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   GetMirroringDeploymentGroupRequest request =
   *       GetMirroringDeploymentGroupRequest.newBuilder()
   *           .setName(
   *               MirroringDeploymentGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<MirroringDeploymentGroup> future =
   *       mirroringClient.getMirroringDeploymentGroupCallable().futureCall(request);
   *   // Do something.
   *   MirroringDeploymentGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMirroringDeploymentGroupRequest, MirroringDeploymentGroup>
      getMirroringDeploymentGroupCallable() {
    return stub.getMirroringDeploymentGroupCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   MirroringDeploymentGroup mirroringDeploymentGroup =
   *       MirroringDeploymentGroup.newBuilder().build();
   *   String mirroringDeploymentGroupId = "mirroringDeploymentGroupId-1056718862";
   *   MirroringDeploymentGroup response =
   *       mirroringClient
   *           .createMirroringDeploymentGroupAsync(
   *               parent, mirroringDeploymentGroup, mirroringDeploymentGroupId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this deployment group will be created.
   *     Format: projects/{project}/locations/{location}
   * @param mirroringDeploymentGroup Required. The deployment group to create.
   * @param mirroringDeploymentGroupId Required. The ID to use for the new deployment group, which
   *     will become the final component of the deployment group's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringDeploymentGroup, OperationMetadata>
      createMirroringDeploymentGroupAsync(
          LocationName parent,
          MirroringDeploymentGroup mirroringDeploymentGroup,
          String mirroringDeploymentGroupId) {
    CreateMirroringDeploymentGroupRequest request =
        CreateMirroringDeploymentGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMirroringDeploymentGroup(mirroringDeploymentGroup)
            .setMirroringDeploymentGroupId(mirroringDeploymentGroupId)
            .build();
    return createMirroringDeploymentGroupAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   MirroringDeploymentGroup mirroringDeploymentGroup =
   *       MirroringDeploymentGroup.newBuilder().build();
   *   String mirroringDeploymentGroupId = "mirroringDeploymentGroupId-1056718862";
   *   MirroringDeploymentGroup response =
   *       mirroringClient
   *           .createMirroringDeploymentGroupAsync(
   *               parent, mirroringDeploymentGroup, mirroringDeploymentGroupId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this deployment group will be created.
   *     Format: projects/{project}/locations/{location}
   * @param mirroringDeploymentGroup Required. The deployment group to create.
   * @param mirroringDeploymentGroupId Required. The ID to use for the new deployment group, which
   *     will become the final component of the deployment group's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringDeploymentGroup, OperationMetadata>
      createMirroringDeploymentGroupAsync(
          String parent,
          MirroringDeploymentGroup mirroringDeploymentGroup,
          String mirroringDeploymentGroupId) {
    CreateMirroringDeploymentGroupRequest request =
        CreateMirroringDeploymentGroupRequest.newBuilder()
            .setParent(parent)
            .setMirroringDeploymentGroup(mirroringDeploymentGroup)
            .setMirroringDeploymentGroupId(mirroringDeploymentGroupId)
            .build();
    return createMirroringDeploymentGroupAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   CreateMirroringDeploymentGroupRequest request =
   *       CreateMirroringDeploymentGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMirroringDeploymentGroupId("mirroringDeploymentGroupId-1056718862")
   *           .setMirroringDeploymentGroup(MirroringDeploymentGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MirroringDeploymentGroup response =
   *       mirroringClient.createMirroringDeploymentGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringDeploymentGroup, OperationMetadata>
      createMirroringDeploymentGroupAsync(CreateMirroringDeploymentGroupRequest request) {
    return createMirroringDeploymentGroupOperationCallable().futureCall(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   CreateMirroringDeploymentGroupRequest request =
   *       CreateMirroringDeploymentGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMirroringDeploymentGroupId("mirroringDeploymentGroupId-1056718862")
   *           .setMirroringDeploymentGroup(MirroringDeploymentGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MirroringDeploymentGroup, OperationMetadata> future =
   *       mirroringClient.createMirroringDeploymentGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   MirroringDeploymentGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
      createMirroringDeploymentGroupOperationCallable() {
    return stub.createMirroringDeploymentGroupOperationCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   CreateMirroringDeploymentGroupRequest request =
   *       CreateMirroringDeploymentGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMirroringDeploymentGroupId("mirroringDeploymentGroupId-1056718862")
   *           .setMirroringDeploymentGroup(MirroringDeploymentGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       mirroringClient.createMirroringDeploymentGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMirroringDeploymentGroupRequest, Operation>
      createMirroringDeploymentGroupCallable() {
    return stub.createMirroringDeploymentGroupCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   MirroringDeploymentGroup mirroringDeploymentGroup =
   *       MirroringDeploymentGroup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MirroringDeploymentGroup response =
   *       mirroringClient
   *           .updateMirroringDeploymentGroupAsync(mirroringDeploymentGroup, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param mirroringDeploymentGroup Required. The deployment group to update.
   * @param updateMask Optional. The list of fields to update. Fields are specified relative to the
   *     deployment group (e.g. `description`; &#42;not&#42;
   *     `mirroring_deployment_group.description`). See https://google.aip.dev/161 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringDeploymentGroup, OperationMetadata>
      updateMirroringDeploymentGroupAsync(
          MirroringDeploymentGroup mirroringDeploymentGroup, FieldMask updateMask) {
    UpdateMirroringDeploymentGroupRequest request =
        UpdateMirroringDeploymentGroupRequest.newBuilder()
            .setMirroringDeploymentGroup(mirroringDeploymentGroup)
            .setUpdateMask(updateMask)
            .build();
    return updateMirroringDeploymentGroupAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   UpdateMirroringDeploymentGroupRequest request =
   *       UpdateMirroringDeploymentGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMirroringDeploymentGroup(MirroringDeploymentGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MirroringDeploymentGroup response =
   *       mirroringClient.updateMirroringDeploymentGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringDeploymentGroup, OperationMetadata>
      updateMirroringDeploymentGroupAsync(UpdateMirroringDeploymentGroupRequest request) {
    return updateMirroringDeploymentGroupOperationCallable().futureCall(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   UpdateMirroringDeploymentGroupRequest request =
   *       UpdateMirroringDeploymentGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMirroringDeploymentGroup(MirroringDeploymentGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MirroringDeploymentGroup, OperationMetadata> future =
   *       mirroringClient.updateMirroringDeploymentGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   MirroringDeploymentGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
      updateMirroringDeploymentGroupOperationCallable() {
    return stub.updateMirroringDeploymentGroupOperationCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   UpdateMirroringDeploymentGroupRequest request =
   *       UpdateMirroringDeploymentGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMirroringDeploymentGroup(MirroringDeploymentGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       mirroringClient.updateMirroringDeploymentGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMirroringDeploymentGroupRequest, Operation>
      updateMirroringDeploymentGroupCallable() {
    return stub.updateMirroringDeploymentGroupCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   MirroringDeploymentGroupName name =
   *       MirroringDeploymentGroupName.of(
   *           "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]");
   *   mirroringClient.deleteMirroringDeploymentGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The deployment group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMirroringDeploymentGroupAsync(
      MirroringDeploymentGroupName name) {
    DeleteMirroringDeploymentGroupRequest request =
        DeleteMirroringDeploymentGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteMirroringDeploymentGroupAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   String name =
   *       MirroringDeploymentGroupName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
   *           .toString();
   *   mirroringClient.deleteMirroringDeploymentGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The deployment group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMirroringDeploymentGroupAsync(
      String name) {
    DeleteMirroringDeploymentGroupRequest request =
        DeleteMirroringDeploymentGroupRequest.newBuilder().setName(name).build();
    return deleteMirroringDeploymentGroupAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   DeleteMirroringDeploymentGroupRequest request =
   *       DeleteMirroringDeploymentGroupRequest.newBuilder()
   *           .setName(
   *               MirroringDeploymentGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   mirroringClient.deleteMirroringDeploymentGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMirroringDeploymentGroupAsync(
      DeleteMirroringDeploymentGroupRequest request) {
    return deleteMirroringDeploymentGroupOperationCallable().futureCall(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   DeleteMirroringDeploymentGroupRequest request =
   *       DeleteMirroringDeploymentGroupRequest.newBuilder()
   *           .setName(
   *               MirroringDeploymentGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       mirroringClient.deleteMirroringDeploymentGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteMirroringDeploymentGroupRequest, Empty, OperationMetadata>
      deleteMirroringDeploymentGroupOperationCallable() {
    return stub.deleteMirroringDeploymentGroupOperationCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   DeleteMirroringDeploymentGroupRequest request =
   *       DeleteMirroringDeploymentGroupRequest.newBuilder()
   *           .setName(
   *               MirroringDeploymentGroupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       mirroringClient.deleteMirroringDeploymentGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMirroringDeploymentGroupRequest, Operation>
      deleteMirroringDeploymentGroupCallable() {
    return stub.deleteMirroringDeploymentGroupCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (MirroringDeployment element :
   *       mirroringClient.listMirroringDeployments(parent).iterateAll()) {
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
  public final ListMirroringDeploymentsPagedResponse listMirroringDeployments(LocationName parent) {
    ListMirroringDeploymentsRequest request =
        ListMirroringDeploymentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMirroringDeployments(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (MirroringDeployment element :
   *       mirroringClient.listMirroringDeployments(parent).iterateAll()) {
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
  public final ListMirroringDeploymentsPagedResponse listMirroringDeployments(String parent) {
    ListMirroringDeploymentsRequest request =
        ListMirroringDeploymentsRequest.newBuilder().setParent(parent).build();
    return listMirroringDeployments(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   ListMirroringDeploymentsRequest request =
   *       ListMirroringDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (MirroringDeployment element :
   *       mirroringClient.listMirroringDeployments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMirroringDeploymentsPagedResponse listMirroringDeployments(
      ListMirroringDeploymentsRequest request) {
    return listMirroringDeploymentsPagedCallable().call(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   ListMirroringDeploymentsRequest request =
   *       ListMirroringDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<MirroringDeployment> future =
   *       mirroringClient.listMirroringDeploymentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MirroringDeployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMirroringDeploymentsRequest, ListMirroringDeploymentsPagedResponse>
      listMirroringDeploymentsPagedCallable() {
    return stub.listMirroringDeploymentsPagedCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   ListMirroringDeploymentsRequest request =
   *       ListMirroringDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListMirroringDeploymentsResponse response =
   *         mirroringClient.listMirroringDeploymentsCallable().call(request);
   *     for (MirroringDeployment element : response.getMirroringDeploymentsList()) {
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
  public final UnaryCallable<ListMirroringDeploymentsRequest, ListMirroringDeploymentsResponse>
      listMirroringDeploymentsCallable() {
    return stub.listMirroringDeploymentsCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   MirroringDeploymentName name =
   *       MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]");
   *   MirroringDeployment response = mirroringClient.getMirroringDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment to retrieve. Format:
   *     projects/{project}/locations/{location}/mirroringDeployments/{mirroring_deployment}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MirroringDeployment getMirroringDeployment(MirroringDeploymentName name) {
    GetMirroringDeploymentRequest request =
        GetMirroringDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMirroringDeployment(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   String name =
   *       MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]")
   *           .toString();
   *   MirroringDeployment response = mirroringClient.getMirroringDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment to retrieve. Format:
   *     projects/{project}/locations/{location}/mirroringDeployments/{mirroring_deployment}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MirroringDeployment getMirroringDeployment(String name) {
    GetMirroringDeploymentRequest request =
        GetMirroringDeploymentRequest.newBuilder().setName(name).build();
    return getMirroringDeployment(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   GetMirroringDeploymentRequest request =
   *       GetMirroringDeploymentRequest.newBuilder()
   *           .setName(
   *               MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   MirroringDeployment response = mirroringClient.getMirroringDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MirroringDeployment getMirroringDeployment(GetMirroringDeploymentRequest request) {
    return getMirroringDeploymentCallable().call(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   GetMirroringDeploymentRequest request =
   *       GetMirroringDeploymentRequest.newBuilder()
   *           .setName(
   *               MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<MirroringDeployment> future =
   *       mirroringClient.getMirroringDeploymentCallable().futureCall(request);
   *   // Do something.
   *   MirroringDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMirroringDeploymentRequest, MirroringDeployment>
      getMirroringDeploymentCallable() {
    return stub.getMirroringDeploymentCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   MirroringDeployment mirroringDeployment = MirroringDeployment.newBuilder().build();
   *   String mirroringDeploymentId = "mirroringDeploymentId-895939037";
   *   MirroringDeployment response =
   *       mirroringClient
   *           .createMirroringDeploymentAsync(parent, mirroringDeployment, mirroringDeploymentId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this deployment will be created. Format:
   *     projects/{project}/locations/{location}
   * @param mirroringDeployment Required. The deployment to create.
   * @param mirroringDeploymentId Required. The ID to use for the new deployment, which will become
   *     the final component of the deployment's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringDeployment, OperationMetadata>
      createMirroringDeploymentAsync(
          LocationName parent,
          MirroringDeployment mirroringDeployment,
          String mirroringDeploymentId) {
    CreateMirroringDeploymentRequest request =
        CreateMirroringDeploymentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMirroringDeployment(mirroringDeployment)
            .setMirroringDeploymentId(mirroringDeploymentId)
            .build();
    return createMirroringDeploymentAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   MirroringDeployment mirroringDeployment = MirroringDeployment.newBuilder().build();
   *   String mirroringDeploymentId = "mirroringDeploymentId-895939037";
   *   MirroringDeployment response =
   *       mirroringClient
   *           .createMirroringDeploymentAsync(parent, mirroringDeployment, mirroringDeploymentId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this deployment will be created. Format:
   *     projects/{project}/locations/{location}
   * @param mirroringDeployment Required. The deployment to create.
   * @param mirroringDeploymentId Required. The ID to use for the new deployment, which will become
   *     the final component of the deployment's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringDeployment, OperationMetadata>
      createMirroringDeploymentAsync(
          String parent, MirroringDeployment mirroringDeployment, String mirroringDeploymentId) {
    CreateMirroringDeploymentRequest request =
        CreateMirroringDeploymentRequest.newBuilder()
            .setParent(parent)
            .setMirroringDeployment(mirroringDeployment)
            .setMirroringDeploymentId(mirroringDeploymentId)
            .build();
    return createMirroringDeploymentAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   CreateMirroringDeploymentRequest request =
   *       CreateMirroringDeploymentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMirroringDeploymentId("mirroringDeploymentId-895939037")
   *           .setMirroringDeployment(MirroringDeployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MirroringDeployment response = mirroringClient.createMirroringDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringDeployment, OperationMetadata>
      createMirroringDeploymentAsync(CreateMirroringDeploymentRequest request) {
    return createMirroringDeploymentOperationCallable().futureCall(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   CreateMirroringDeploymentRequest request =
   *       CreateMirroringDeploymentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMirroringDeploymentId("mirroringDeploymentId-895939037")
   *           .setMirroringDeployment(MirroringDeployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MirroringDeployment, OperationMetadata> future =
   *       mirroringClient.createMirroringDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   MirroringDeployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
      createMirroringDeploymentOperationCallable() {
    return stub.createMirroringDeploymentOperationCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   CreateMirroringDeploymentRequest request =
   *       CreateMirroringDeploymentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMirroringDeploymentId("mirroringDeploymentId-895939037")
   *           .setMirroringDeployment(MirroringDeployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       mirroringClient.createMirroringDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMirroringDeploymentRequest, Operation>
      createMirroringDeploymentCallable() {
    return stub.createMirroringDeploymentCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   MirroringDeployment mirroringDeployment = MirroringDeployment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MirroringDeployment response =
   *       mirroringClient.updateMirroringDeploymentAsync(mirroringDeployment, updateMask).get();
   * }
   * }</pre>
   *
   * @param mirroringDeployment Required. The deployment to update.
   * @param updateMask Optional. The list of fields to update. Fields are specified relative to the
   *     deployment (e.g. `description`; &#42;not&#42; `mirroring_deployment.description`). See
   *     https://google.aip.dev/161 for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringDeployment, OperationMetadata>
      updateMirroringDeploymentAsync(
          MirroringDeployment mirroringDeployment, FieldMask updateMask) {
    UpdateMirroringDeploymentRequest request =
        UpdateMirroringDeploymentRequest.newBuilder()
            .setMirroringDeployment(mirroringDeployment)
            .setUpdateMask(updateMask)
            .build();
    return updateMirroringDeploymentAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   UpdateMirroringDeploymentRequest request =
   *       UpdateMirroringDeploymentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMirroringDeployment(MirroringDeployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MirroringDeployment response = mirroringClient.updateMirroringDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MirroringDeployment, OperationMetadata>
      updateMirroringDeploymentAsync(UpdateMirroringDeploymentRequest request) {
    return updateMirroringDeploymentOperationCallable().futureCall(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   UpdateMirroringDeploymentRequest request =
   *       UpdateMirroringDeploymentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMirroringDeployment(MirroringDeployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MirroringDeployment, OperationMetadata> future =
   *       mirroringClient.updateMirroringDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   MirroringDeployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
      updateMirroringDeploymentOperationCallable() {
    return stub.updateMirroringDeploymentOperationCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   UpdateMirroringDeploymentRequest request =
   *       UpdateMirroringDeploymentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMirroringDeployment(MirroringDeployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       mirroringClient.updateMirroringDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMirroringDeploymentRequest, Operation>
      updateMirroringDeploymentCallable() {
    return stub.updateMirroringDeploymentCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   MirroringDeploymentName name =
   *       MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]");
   *   mirroringClient.deleteMirroringDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMirroringDeploymentAsync(
      MirroringDeploymentName name) {
    DeleteMirroringDeploymentRequest request =
        DeleteMirroringDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteMirroringDeploymentAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   String name =
   *       MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]")
   *           .toString();
   *   mirroringClient.deleteMirroringDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMirroringDeploymentAsync(
      String name) {
    DeleteMirroringDeploymentRequest request =
        DeleteMirroringDeploymentRequest.newBuilder().setName(name).build();
    return deleteMirroringDeploymentAsync(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   DeleteMirroringDeploymentRequest request =
   *       DeleteMirroringDeploymentRequest.newBuilder()
   *           .setName(
   *               MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   mirroringClient.deleteMirroringDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMirroringDeploymentAsync(
      DeleteMirroringDeploymentRequest request) {
    return deleteMirroringDeploymentOperationCallable().futureCall(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   DeleteMirroringDeploymentRequest request =
   *       DeleteMirroringDeploymentRequest.newBuilder()
   *           .setName(
   *               MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       mirroringClient.deleteMirroringDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteMirroringDeploymentRequest, Empty, OperationMetadata>
      deleteMirroringDeploymentOperationCallable() {
    return stub.deleteMirroringDeploymentOperationCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   DeleteMirroringDeploymentRequest request =
   *       DeleteMirroringDeploymentRequest.newBuilder()
   *           .setName(
   *               MirroringDeploymentName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_DEPLOYMENT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       mirroringClient.deleteMirroringDeploymentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMirroringDeploymentRequest, Operation>
      deleteMirroringDeploymentCallable() {
    return stub.deleteMirroringDeploymentCallable();
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : mirroringClient.listLocations(request).iterateAll()) {
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = mirroringClient.listLocationsPagedCallable().futureCall(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = mirroringClient.listLocationsCallable().call(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = mirroringClient.getLocation(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = mirroringClient.getLocationCallable().futureCall(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = mirroringClient.setIamPolicy(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = mirroringClient.setIamPolicyCallable().futureCall(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = mirroringClient.getIamPolicy(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = mirroringClient.getIamPolicyCallable().futureCall(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = mirroringClient.testIamPermissions(request);
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
   * try (MirroringClient mirroringClient = MirroringClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       mirroringClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListMirroringEndpointGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListMirroringEndpointGroupsRequest,
          ListMirroringEndpointGroupsResponse,
          MirroringEndpointGroup,
          ListMirroringEndpointGroupsPage,
          ListMirroringEndpointGroupsFixedSizeCollection> {

    public static ApiFuture<ListMirroringEndpointGroupsPagedResponse> createAsync(
        PageContext<
                ListMirroringEndpointGroupsRequest,
                ListMirroringEndpointGroupsResponse,
                MirroringEndpointGroup>
            context,
        ApiFuture<ListMirroringEndpointGroupsResponse> futureResponse) {
      ApiFuture<ListMirroringEndpointGroupsPage> futurePage =
          ListMirroringEndpointGroupsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMirroringEndpointGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMirroringEndpointGroupsPagedResponse(ListMirroringEndpointGroupsPage page) {
      super(page, ListMirroringEndpointGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMirroringEndpointGroupsPage
      extends AbstractPage<
          ListMirroringEndpointGroupsRequest,
          ListMirroringEndpointGroupsResponse,
          MirroringEndpointGroup,
          ListMirroringEndpointGroupsPage> {

    private ListMirroringEndpointGroupsPage(
        PageContext<
                ListMirroringEndpointGroupsRequest,
                ListMirroringEndpointGroupsResponse,
                MirroringEndpointGroup>
            context,
        ListMirroringEndpointGroupsResponse response) {
      super(context, response);
    }

    private static ListMirroringEndpointGroupsPage createEmptyPage() {
      return new ListMirroringEndpointGroupsPage(null, null);
    }

    @Override
    protected ListMirroringEndpointGroupsPage createPage(
        PageContext<
                ListMirroringEndpointGroupsRequest,
                ListMirroringEndpointGroupsResponse,
                MirroringEndpointGroup>
            context,
        ListMirroringEndpointGroupsResponse response) {
      return new ListMirroringEndpointGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListMirroringEndpointGroupsPage> createPageAsync(
        PageContext<
                ListMirroringEndpointGroupsRequest,
                ListMirroringEndpointGroupsResponse,
                MirroringEndpointGroup>
            context,
        ApiFuture<ListMirroringEndpointGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMirroringEndpointGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMirroringEndpointGroupsRequest,
          ListMirroringEndpointGroupsResponse,
          MirroringEndpointGroup,
          ListMirroringEndpointGroupsPage,
          ListMirroringEndpointGroupsFixedSizeCollection> {

    private ListMirroringEndpointGroupsFixedSizeCollection(
        List<ListMirroringEndpointGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMirroringEndpointGroupsFixedSizeCollection createEmptyCollection() {
      return new ListMirroringEndpointGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMirroringEndpointGroupsFixedSizeCollection createCollection(
        List<ListMirroringEndpointGroupsPage> pages, int collectionSize) {
      return new ListMirroringEndpointGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMirroringEndpointGroupAssociationsPagedResponse
      extends AbstractPagedListResponse<
          ListMirroringEndpointGroupAssociationsRequest,
          ListMirroringEndpointGroupAssociationsResponse,
          MirroringEndpointGroupAssociation,
          ListMirroringEndpointGroupAssociationsPage,
          ListMirroringEndpointGroupAssociationsFixedSizeCollection> {

    public static ApiFuture<ListMirroringEndpointGroupAssociationsPagedResponse> createAsync(
        PageContext<
                ListMirroringEndpointGroupAssociationsRequest,
                ListMirroringEndpointGroupAssociationsResponse,
                MirroringEndpointGroupAssociation>
            context,
        ApiFuture<ListMirroringEndpointGroupAssociationsResponse> futureResponse) {
      ApiFuture<ListMirroringEndpointGroupAssociationsPage> futurePage =
          ListMirroringEndpointGroupAssociationsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMirroringEndpointGroupAssociationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMirroringEndpointGroupAssociationsPagedResponse(
        ListMirroringEndpointGroupAssociationsPage page) {
      super(
          page, ListMirroringEndpointGroupAssociationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMirroringEndpointGroupAssociationsPage
      extends AbstractPage<
          ListMirroringEndpointGroupAssociationsRequest,
          ListMirroringEndpointGroupAssociationsResponse,
          MirroringEndpointGroupAssociation,
          ListMirroringEndpointGroupAssociationsPage> {

    private ListMirroringEndpointGroupAssociationsPage(
        PageContext<
                ListMirroringEndpointGroupAssociationsRequest,
                ListMirroringEndpointGroupAssociationsResponse,
                MirroringEndpointGroupAssociation>
            context,
        ListMirroringEndpointGroupAssociationsResponse response) {
      super(context, response);
    }

    private static ListMirroringEndpointGroupAssociationsPage createEmptyPage() {
      return new ListMirroringEndpointGroupAssociationsPage(null, null);
    }

    @Override
    protected ListMirroringEndpointGroupAssociationsPage createPage(
        PageContext<
                ListMirroringEndpointGroupAssociationsRequest,
                ListMirroringEndpointGroupAssociationsResponse,
                MirroringEndpointGroupAssociation>
            context,
        ListMirroringEndpointGroupAssociationsResponse response) {
      return new ListMirroringEndpointGroupAssociationsPage(context, response);
    }

    @Override
    public ApiFuture<ListMirroringEndpointGroupAssociationsPage> createPageAsync(
        PageContext<
                ListMirroringEndpointGroupAssociationsRequest,
                ListMirroringEndpointGroupAssociationsResponse,
                MirroringEndpointGroupAssociation>
            context,
        ApiFuture<ListMirroringEndpointGroupAssociationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMirroringEndpointGroupAssociationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMirroringEndpointGroupAssociationsRequest,
          ListMirroringEndpointGroupAssociationsResponse,
          MirroringEndpointGroupAssociation,
          ListMirroringEndpointGroupAssociationsPage,
          ListMirroringEndpointGroupAssociationsFixedSizeCollection> {

    private ListMirroringEndpointGroupAssociationsFixedSizeCollection(
        List<ListMirroringEndpointGroupAssociationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMirroringEndpointGroupAssociationsFixedSizeCollection
        createEmptyCollection() {
      return new ListMirroringEndpointGroupAssociationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMirroringEndpointGroupAssociationsFixedSizeCollection createCollection(
        List<ListMirroringEndpointGroupAssociationsPage> pages, int collectionSize) {
      return new ListMirroringEndpointGroupAssociationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMirroringDeploymentGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListMirroringDeploymentGroupsRequest,
          ListMirroringDeploymentGroupsResponse,
          MirroringDeploymentGroup,
          ListMirroringDeploymentGroupsPage,
          ListMirroringDeploymentGroupsFixedSizeCollection> {

    public static ApiFuture<ListMirroringDeploymentGroupsPagedResponse> createAsync(
        PageContext<
                ListMirroringDeploymentGroupsRequest,
                ListMirroringDeploymentGroupsResponse,
                MirroringDeploymentGroup>
            context,
        ApiFuture<ListMirroringDeploymentGroupsResponse> futureResponse) {
      ApiFuture<ListMirroringDeploymentGroupsPage> futurePage =
          ListMirroringDeploymentGroupsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMirroringDeploymentGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMirroringDeploymentGroupsPagedResponse(ListMirroringDeploymentGroupsPage page) {
      super(page, ListMirroringDeploymentGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMirroringDeploymentGroupsPage
      extends AbstractPage<
          ListMirroringDeploymentGroupsRequest,
          ListMirroringDeploymentGroupsResponse,
          MirroringDeploymentGroup,
          ListMirroringDeploymentGroupsPage> {

    private ListMirroringDeploymentGroupsPage(
        PageContext<
                ListMirroringDeploymentGroupsRequest,
                ListMirroringDeploymentGroupsResponse,
                MirroringDeploymentGroup>
            context,
        ListMirroringDeploymentGroupsResponse response) {
      super(context, response);
    }

    private static ListMirroringDeploymentGroupsPage createEmptyPage() {
      return new ListMirroringDeploymentGroupsPage(null, null);
    }

    @Override
    protected ListMirroringDeploymentGroupsPage createPage(
        PageContext<
                ListMirroringDeploymentGroupsRequest,
                ListMirroringDeploymentGroupsResponse,
                MirroringDeploymentGroup>
            context,
        ListMirroringDeploymentGroupsResponse response) {
      return new ListMirroringDeploymentGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListMirroringDeploymentGroupsPage> createPageAsync(
        PageContext<
                ListMirroringDeploymentGroupsRequest,
                ListMirroringDeploymentGroupsResponse,
                MirroringDeploymentGroup>
            context,
        ApiFuture<ListMirroringDeploymentGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMirroringDeploymentGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMirroringDeploymentGroupsRequest,
          ListMirroringDeploymentGroupsResponse,
          MirroringDeploymentGroup,
          ListMirroringDeploymentGroupsPage,
          ListMirroringDeploymentGroupsFixedSizeCollection> {

    private ListMirroringDeploymentGroupsFixedSizeCollection(
        List<ListMirroringDeploymentGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMirroringDeploymentGroupsFixedSizeCollection createEmptyCollection() {
      return new ListMirroringDeploymentGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMirroringDeploymentGroupsFixedSizeCollection createCollection(
        List<ListMirroringDeploymentGroupsPage> pages, int collectionSize) {
      return new ListMirroringDeploymentGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMirroringDeploymentsPagedResponse
      extends AbstractPagedListResponse<
          ListMirroringDeploymentsRequest,
          ListMirroringDeploymentsResponse,
          MirroringDeployment,
          ListMirroringDeploymentsPage,
          ListMirroringDeploymentsFixedSizeCollection> {

    public static ApiFuture<ListMirroringDeploymentsPagedResponse> createAsync(
        PageContext<
                ListMirroringDeploymentsRequest,
                ListMirroringDeploymentsResponse,
                MirroringDeployment>
            context,
        ApiFuture<ListMirroringDeploymentsResponse> futureResponse) {
      ApiFuture<ListMirroringDeploymentsPage> futurePage =
          ListMirroringDeploymentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMirroringDeploymentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMirroringDeploymentsPagedResponse(ListMirroringDeploymentsPage page) {
      super(page, ListMirroringDeploymentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMirroringDeploymentsPage
      extends AbstractPage<
          ListMirroringDeploymentsRequest,
          ListMirroringDeploymentsResponse,
          MirroringDeployment,
          ListMirroringDeploymentsPage> {

    private ListMirroringDeploymentsPage(
        PageContext<
                ListMirroringDeploymentsRequest,
                ListMirroringDeploymentsResponse,
                MirroringDeployment>
            context,
        ListMirroringDeploymentsResponse response) {
      super(context, response);
    }

    private static ListMirroringDeploymentsPage createEmptyPage() {
      return new ListMirroringDeploymentsPage(null, null);
    }

    @Override
    protected ListMirroringDeploymentsPage createPage(
        PageContext<
                ListMirroringDeploymentsRequest,
                ListMirroringDeploymentsResponse,
                MirroringDeployment>
            context,
        ListMirroringDeploymentsResponse response) {
      return new ListMirroringDeploymentsPage(context, response);
    }

    @Override
    public ApiFuture<ListMirroringDeploymentsPage> createPageAsync(
        PageContext<
                ListMirroringDeploymentsRequest,
                ListMirroringDeploymentsResponse,
                MirroringDeployment>
            context,
        ApiFuture<ListMirroringDeploymentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMirroringDeploymentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMirroringDeploymentsRequest,
          ListMirroringDeploymentsResponse,
          MirroringDeployment,
          ListMirroringDeploymentsPage,
          ListMirroringDeploymentsFixedSizeCollection> {

    private ListMirroringDeploymentsFixedSizeCollection(
        List<ListMirroringDeploymentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMirroringDeploymentsFixedSizeCollection createEmptyCollection() {
      return new ListMirroringDeploymentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMirroringDeploymentsFixedSizeCollection createCollection(
        List<ListMirroringDeploymentsPage> pages, int collectionSize) {
      return new ListMirroringDeploymentsFixedSizeCollection(pages, collectionSize);
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
