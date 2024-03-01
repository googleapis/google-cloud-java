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

package com.google.cloud.workstations.v1;

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
import com.google.cloud.workstations.v1.stub.WorkstationsStub;
import com.google.cloud.workstations.v1.stub.WorkstationsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for interacting with Cloud Workstations.
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
 * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
 *   WorkstationClusterName name =
 *       WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");
 *   WorkstationCluster response = workstationsClient.getWorkstationCluster(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the WorkstationsClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetWorkstationCluster</td>
 *      <td><p> Returns the requested workstation cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getWorkstationCluster(GetWorkstationClusterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getWorkstationCluster(WorkstationClusterName name)
 *           <li><p> getWorkstationCluster(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getWorkstationClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListWorkstationClusters</td>
 *      <td><p> Returns all workstation clusters in the specified location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listWorkstationClusters(ListWorkstationClustersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listWorkstationClusters(LocationName parent)
 *           <li><p> listWorkstationClusters(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listWorkstationClustersPagedCallable()
 *           <li><p> listWorkstationClustersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateWorkstationCluster</td>
 *      <td><p> Creates a new workstation cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createWorkstationClusterAsync(CreateWorkstationClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createWorkstationClusterAsync(LocationName parent, WorkstationCluster workstationCluster, String workstationClusterId)
 *           <li><p> createWorkstationClusterAsync(String parent, WorkstationCluster workstationCluster, String workstationClusterId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createWorkstationClusterOperationCallable()
 *           <li><p> createWorkstationClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateWorkstationCluster</td>
 *      <td><p> Updates an existing workstation cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateWorkstationClusterAsync(UpdateWorkstationClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateWorkstationClusterAsync(WorkstationCluster workstationCluster, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateWorkstationClusterOperationCallable()
 *           <li><p> updateWorkstationClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteWorkstationCluster</td>
 *      <td><p> Deletes the specified workstation cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteWorkstationClusterAsync(DeleteWorkstationClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteWorkstationClusterAsync(WorkstationClusterName name)
 *           <li><p> deleteWorkstationClusterAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteWorkstationClusterOperationCallable()
 *           <li><p> deleteWorkstationClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetWorkstationConfig</td>
 *      <td><p> Returns the requested workstation configuration.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getWorkstationConfig(GetWorkstationConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getWorkstationConfig(WorkstationConfigName name)
 *           <li><p> getWorkstationConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getWorkstationConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListWorkstationConfigs</td>
 *      <td><p> Returns all workstation configurations in the specified cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listWorkstationConfigs(ListWorkstationConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listWorkstationConfigs(WorkstationClusterName parent)
 *           <li><p> listWorkstationConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listWorkstationConfigsPagedCallable()
 *           <li><p> listWorkstationConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListUsableWorkstationConfigs</td>
 *      <td><p> Returns all workstation configurations in the specified cluster on which the caller has the "workstations.workstation.create" permission.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listUsableWorkstationConfigs(ListUsableWorkstationConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listUsableWorkstationConfigs(WorkstationClusterName parent)
 *           <li><p> listUsableWorkstationConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listUsableWorkstationConfigsPagedCallable()
 *           <li><p> listUsableWorkstationConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateWorkstationConfig</td>
 *      <td><p> Creates a new workstation configuration.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createWorkstationConfigAsync(CreateWorkstationConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createWorkstationConfigAsync(WorkstationClusterName parent, WorkstationConfig workstationConfig, String workstationConfigId)
 *           <li><p> createWorkstationConfigAsync(String parent, WorkstationConfig workstationConfig, String workstationConfigId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createWorkstationConfigOperationCallable()
 *           <li><p> createWorkstationConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateWorkstationConfig</td>
 *      <td><p> Updates an existing workstation configuration.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateWorkstationConfigAsync(UpdateWorkstationConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateWorkstationConfigAsync(WorkstationConfig workstationConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateWorkstationConfigOperationCallable()
 *           <li><p> updateWorkstationConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteWorkstationConfig</td>
 *      <td><p> Deletes the specified workstation configuration.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteWorkstationConfigAsync(DeleteWorkstationConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteWorkstationConfigAsync(WorkstationConfigName name)
 *           <li><p> deleteWorkstationConfigAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteWorkstationConfigOperationCallable()
 *           <li><p> deleteWorkstationConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetWorkstation</td>
 *      <td><p> Returns the requested workstation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getWorkstation(GetWorkstationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getWorkstation(WorkstationName name)
 *           <li><p> getWorkstation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getWorkstationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListWorkstations</td>
 *      <td><p> Returns all Workstations using the specified workstation configuration.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listWorkstations(ListWorkstationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listWorkstations(WorkstationConfigName parent)
 *           <li><p> listWorkstations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listWorkstationsPagedCallable()
 *           <li><p> listWorkstationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListUsableWorkstations</td>
 *      <td><p> Returns all workstations using the specified workstation configuration on which the caller has the "workstations.workstations.use" permission.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listUsableWorkstations(ListUsableWorkstationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listUsableWorkstations(WorkstationConfigName parent)
 *           <li><p> listUsableWorkstations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listUsableWorkstationsPagedCallable()
 *           <li><p> listUsableWorkstationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateWorkstation</td>
 *      <td><p> Creates a new workstation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createWorkstationAsync(CreateWorkstationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createWorkstationAsync(WorkstationConfigName parent, Workstation workstation, String workstationId)
 *           <li><p> createWorkstationAsync(String parent, Workstation workstation, String workstationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createWorkstationOperationCallable()
 *           <li><p> createWorkstationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateWorkstation</td>
 *      <td><p> Updates an existing workstation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateWorkstationAsync(UpdateWorkstationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateWorkstationAsync(Workstation workstation, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateWorkstationOperationCallable()
 *           <li><p> updateWorkstationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteWorkstation</td>
 *      <td><p> Deletes the specified workstation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteWorkstationAsync(DeleteWorkstationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteWorkstationAsync(WorkstationName name)
 *           <li><p> deleteWorkstationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteWorkstationOperationCallable()
 *           <li><p> deleteWorkstationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StartWorkstation</td>
 *      <td><p> Starts running a workstation so that users can connect to it.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> startWorkstationAsync(StartWorkstationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> startWorkstationAsync(WorkstationName name)
 *           <li><p> startWorkstationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> startWorkstationOperationCallable()
 *           <li><p> startWorkstationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StopWorkstation</td>
 *      <td><p> Stops running a workstation, reducing costs.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> stopWorkstationAsync(StopWorkstationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> stopWorkstationAsync(WorkstationName name)
 *           <li><p> stopWorkstationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> stopWorkstationOperationCallable()
 *           <li><p> stopWorkstationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateAccessToken</td>
 *      <td><p> Returns a short-lived credential that can be used to send authenticated and authorized traffic to a workstation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateAccessToken(GenerateAccessTokenRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> generateAccessToken(WorkstationName workstation)
 *           <li><p> generateAccessToken(String workstation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateAccessTokenCallable()
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
 * <p>This class can be customized by passing in a custom instance of WorkstationsSettings to
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
 * WorkstationsSettings workstationsSettings =
 *     WorkstationsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * WorkstationsClient workstationsClient = WorkstationsClient.create(workstationsSettings);
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
 * WorkstationsSettings workstationsSettings =
 *     WorkstationsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * WorkstationsClient workstationsClient = WorkstationsClient.create(workstationsSettings);
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
 * WorkstationsSettings workstationsSettings = WorkstationsSettings.newHttpJsonBuilder().build();
 * WorkstationsClient workstationsClient = WorkstationsClient.create(workstationsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class WorkstationsClient implements BackgroundResource {
  private final WorkstationsSettings settings;
  private final WorkstationsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of WorkstationsClient with default settings. */
  public static final WorkstationsClient create() throws IOException {
    return create(WorkstationsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of WorkstationsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final WorkstationsClient create(WorkstationsSettings settings) throws IOException {
    return new WorkstationsClient(settings);
  }

  /**
   * Constructs an instance of WorkstationsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(WorkstationsSettings).
   */
  public static final WorkstationsClient create(WorkstationsStub stub) {
    return new WorkstationsClient(stub);
  }

  /**
   * Constructs an instance of WorkstationsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected WorkstationsClient(WorkstationsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((WorkstationsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected WorkstationsClient(WorkstationsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final WorkstationsSettings getSettings() {
    return settings;
  }

  public WorkstationsStub getStub() {
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
   * Returns the requested workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   WorkstationClusterName name =
   *       WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");
   *   WorkstationCluster response = workstationsClient.getWorkstationCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the requested resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkstationCluster getWorkstationCluster(WorkstationClusterName name) {
    GetWorkstationClusterRequest request =
        GetWorkstationClusterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getWorkstationCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   String name =
   *       WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]").toString();
   *   WorkstationCluster response = workstationsClient.getWorkstationCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the requested resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkstationCluster getWorkstationCluster(String name) {
    GetWorkstationClusterRequest request =
        GetWorkstationClusterRequest.newBuilder().setName(name).build();
    return getWorkstationCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   GetWorkstationClusterRequest request =
   *       GetWorkstationClusterRequest.newBuilder()
   *           .setName(
   *               WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
   *                   .toString())
   *           .build();
   *   WorkstationCluster response = workstationsClient.getWorkstationCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkstationCluster getWorkstationCluster(GetWorkstationClusterRequest request) {
    return getWorkstationClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   GetWorkstationClusterRequest request =
   *       GetWorkstationClusterRequest.newBuilder()
   *           .setName(
   *               WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<WorkstationCluster> future =
   *       workstationsClient.getWorkstationClusterCallable().futureCall(request);
   *   // Do something.
   *   WorkstationCluster response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWorkstationClusterRequest, WorkstationCluster>
      getWorkstationClusterCallable() {
    return stub.getWorkstationClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstation clusters in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (WorkstationCluster element :
   *       workstationsClient.listWorkstationClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkstationClustersPagedResponse listWorkstationClusters(LocationName parent) {
    ListWorkstationClustersRequest request =
        ListWorkstationClustersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listWorkstationClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstation clusters in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (WorkstationCluster element :
   *       workstationsClient.listWorkstationClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkstationClustersPagedResponse listWorkstationClusters(String parent) {
    ListWorkstationClustersRequest request =
        ListWorkstationClustersRequest.newBuilder().setParent(parent).build();
    return listWorkstationClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstation clusters in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   ListWorkstationClustersRequest request =
   *       ListWorkstationClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (WorkstationCluster element :
   *       workstationsClient.listWorkstationClusters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkstationClustersPagedResponse listWorkstationClusters(
      ListWorkstationClustersRequest request) {
    return listWorkstationClustersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstation clusters in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   ListWorkstationClustersRequest request =
   *       ListWorkstationClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<WorkstationCluster> future =
   *       workstationsClient.listWorkstationClustersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (WorkstationCluster element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWorkstationClustersRequest, ListWorkstationClustersPagedResponse>
      listWorkstationClustersPagedCallable() {
    return stub.listWorkstationClustersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstation clusters in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   ListWorkstationClustersRequest request =
   *       ListWorkstationClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListWorkstationClustersResponse response =
   *         workstationsClient.listWorkstationClustersCallable().call(request);
   *     for (WorkstationCluster element : response.getWorkstationClustersList()) {
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
  public final UnaryCallable<ListWorkstationClustersRequest, ListWorkstationClustersResponse>
      listWorkstationClustersCallable() {
    return stub.listWorkstationClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   WorkstationCluster workstationCluster = WorkstationCluster.newBuilder().build();
   *   String workstationClusterId = "workstationClusterId351421170";
   *   WorkstationCluster response =
   *       workstationsClient
   *           .createWorkstationClusterAsync(parent, workstationCluster, workstationClusterId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   * @param workstationCluster Required. Workstation cluster to create.
   * @param workstationClusterId Required. ID to use for the workstation cluster.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkstationCluster, OperationMetadata> createWorkstationClusterAsync(
      LocationName parent, WorkstationCluster workstationCluster, String workstationClusterId) {
    CreateWorkstationClusterRequest request =
        CreateWorkstationClusterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setWorkstationCluster(workstationCluster)
            .setWorkstationClusterId(workstationClusterId)
            .build();
    return createWorkstationClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   WorkstationCluster workstationCluster = WorkstationCluster.newBuilder().build();
   *   String workstationClusterId = "workstationClusterId351421170";
   *   WorkstationCluster response =
   *       workstationsClient
   *           .createWorkstationClusterAsync(parent, workstationCluster, workstationClusterId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   * @param workstationCluster Required. Workstation cluster to create.
   * @param workstationClusterId Required. ID to use for the workstation cluster.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkstationCluster, OperationMetadata> createWorkstationClusterAsync(
      String parent, WorkstationCluster workstationCluster, String workstationClusterId) {
    CreateWorkstationClusterRequest request =
        CreateWorkstationClusterRequest.newBuilder()
            .setParent(parent)
            .setWorkstationCluster(workstationCluster)
            .setWorkstationClusterId(workstationClusterId)
            .build();
    return createWorkstationClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   CreateWorkstationClusterRequest request =
   *       CreateWorkstationClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setWorkstationClusterId("workstationClusterId351421170")
   *           .setWorkstationCluster(WorkstationCluster.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   WorkstationCluster response = workstationsClient.createWorkstationClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkstationCluster, OperationMetadata> createWorkstationClusterAsync(
      CreateWorkstationClusterRequest request) {
    return createWorkstationClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   CreateWorkstationClusterRequest request =
   *       CreateWorkstationClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setWorkstationClusterId("workstationClusterId351421170")
   *           .setWorkstationCluster(WorkstationCluster.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<WorkstationCluster, OperationMetadata> future =
   *       workstationsClient.createWorkstationClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   WorkstationCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      createWorkstationClusterOperationCallable() {
    return stub.createWorkstationClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   CreateWorkstationClusterRequest request =
   *       CreateWorkstationClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setWorkstationClusterId("workstationClusterId351421170")
   *           .setWorkstationCluster(WorkstationCluster.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       workstationsClient.createWorkstationClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateWorkstationClusterRequest, Operation>
      createWorkstationClusterCallable() {
    return stub.createWorkstationClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   WorkstationCluster workstationCluster = WorkstationCluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   WorkstationCluster response =
   *       workstationsClient.updateWorkstationClusterAsync(workstationCluster, updateMask).get();
   * }
   * }</pre>
   *
   * @param workstationCluster Required. Workstation cluster to update.
   * @param updateMask Required. Mask that specifies which fields in the workstation cluster should
   *     be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkstationCluster, OperationMetadata> updateWorkstationClusterAsync(
      WorkstationCluster workstationCluster, FieldMask updateMask) {
    UpdateWorkstationClusterRequest request =
        UpdateWorkstationClusterRequest.newBuilder()
            .setWorkstationCluster(workstationCluster)
            .setUpdateMask(updateMask)
            .build();
    return updateWorkstationClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   UpdateWorkstationClusterRequest request =
   *       UpdateWorkstationClusterRequest.newBuilder()
   *           .setWorkstationCluster(WorkstationCluster.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   WorkstationCluster response = workstationsClient.updateWorkstationClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkstationCluster, OperationMetadata> updateWorkstationClusterAsync(
      UpdateWorkstationClusterRequest request) {
    return updateWorkstationClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   UpdateWorkstationClusterRequest request =
   *       UpdateWorkstationClusterRequest.newBuilder()
   *           .setWorkstationCluster(WorkstationCluster.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<WorkstationCluster, OperationMetadata> future =
   *       workstationsClient.updateWorkstationClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   WorkstationCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      updateWorkstationClusterOperationCallable() {
    return stub.updateWorkstationClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   UpdateWorkstationClusterRequest request =
   *       UpdateWorkstationClusterRequest.newBuilder()
   *           .setWorkstationCluster(WorkstationCluster.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       workstationsClient.updateWorkstationClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateWorkstationClusterRequest, Operation>
      updateWorkstationClusterCallable() {
    return stub.updateWorkstationClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   WorkstationClusterName name =
   *       WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");
   *   WorkstationCluster response = workstationsClient.deleteWorkstationClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the workstation cluster to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkstationCluster, OperationMetadata> deleteWorkstationClusterAsync(
      WorkstationClusterName name) {
    DeleteWorkstationClusterRequest request =
        DeleteWorkstationClusterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteWorkstationClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   String name =
   *       WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]").toString();
   *   WorkstationCluster response = workstationsClient.deleteWorkstationClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the workstation cluster to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkstationCluster, OperationMetadata> deleteWorkstationClusterAsync(
      String name) {
    DeleteWorkstationClusterRequest request =
        DeleteWorkstationClusterRequest.newBuilder().setName(name).build();
    return deleteWorkstationClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   DeleteWorkstationClusterRequest request =
   *       DeleteWorkstationClusterRequest.newBuilder()
   *           .setName(
   *               WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   WorkstationCluster response = workstationsClient.deleteWorkstationClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkstationCluster, OperationMetadata> deleteWorkstationClusterAsync(
      DeleteWorkstationClusterRequest request) {
    return deleteWorkstationClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   DeleteWorkstationClusterRequest request =
   *       DeleteWorkstationClusterRequest.newBuilder()
   *           .setName(
   *               WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<WorkstationCluster, OperationMetadata> future =
   *       workstationsClient.deleteWorkstationClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   WorkstationCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      deleteWorkstationClusterOperationCallable() {
    return stub.deleteWorkstationClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified workstation cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   DeleteWorkstationClusterRequest request =
   *       DeleteWorkstationClusterRequest.newBuilder()
   *           .setName(
   *               WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       workstationsClient.deleteWorkstationClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteWorkstationClusterRequest, Operation>
      deleteWorkstationClusterCallable() {
    return stub.deleteWorkstationClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   WorkstationConfigName name =
   *       WorkstationConfigName.of(
   *           "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");
   *   WorkstationConfig response = workstationsClient.getWorkstationConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the requested resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkstationConfig getWorkstationConfig(WorkstationConfigName name) {
    GetWorkstationConfigRequest request =
        GetWorkstationConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getWorkstationConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   String name =
   *       WorkstationConfigName.of(
   *               "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]")
   *           .toString();
   *   WorkstationConfig response = workstationsClient.getWorkstationConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the requested resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkstationConfig getWorkstationConfig(String name) {
    GetWorkstationConfigRequest request =
        GetWorkstationConfigRequest.newBuilder().setName(name).build();
    return getWorkstationConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   GetWorkstationConfigRequest request =
   *       GetWorkstationConfigRequest.newBuilder()
   *           .setName(
   *               WorkstationConfigName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]")
   *                   .toString())
   *           .build();
   *   WorkstationConfig response = workstationsClient.getWorkstationConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkstationConfig getWorkstationConfig(GetWorkstationConfigRequest request) {
    return getWorkstationConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   GetWorkstationConfigRequest request =
   *       GetWorkstationConfigRequest.newBuilder()
   *           .setName(
   *               WorkstationConfigName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<WorkstationConfig> future =
   *       workstationsClient.getWorkstationConfigCallable().futureCall(request);
   *   // Do something.
   *   WorkstationConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWorkstationConfigRequest, WorkstationConfig>
      getWorkstationConfigCallable() {
    return stub.getWorkstationConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstation configurations in the specified cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   WorkstationClusterName parent =
   *       WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");
   *   for (WorkstationConfig element :
   *       workstationsClient.listWorkstationConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkstationConfigsPagedResponse listWorkstationConfigs(
      WorkstationClusterName parent) {
    ListWorkstationConfigsRequest request =
        ListWorkstationConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listWorkstationConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstation configurations in the specified cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   String parent =
   *       WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]").toString();
   *   for (WorkstationConfig element :
   *       workstationsClient.listWorkstationConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkstationConfigsPagedResponse listWorkstationConfigs(String parent) {
    ListWorkstationConfigsRequest request =
        ListWorkstationConfigsRequest.newBuilder().setParent(parent).build();
    return listWorkstationConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstation configurations in the specified cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   ListWorkstationConfigsRequest request =
   *       ListWorkstationConfigsRequest.newBuilder()
   *           .setParent(
   *               WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (WorkstationConfig element :
   *       workstationsClient.listWorkstationConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkstationConfigsPagedResponse listWorkstationConfigs(
      ListWorkstationConfigsRequest request) {
    return listWorkstationConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstation configurations in the specified cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   ListWorkstationConfigsRequest request =
   *       ListWorkstationConfigsRequest.newBuilder()
   *           .setParent(
   *               WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<WorkstationConfig> future =
   *       workstationsClient.listWorkstationConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (WorkstationConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWorkstationConfigsRequest, ListWorkstationConfigsPagedResponse>
      listWorkstationConfigsPagedCallable() {
    return stub.listWorkstationConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstation configurations in the specified cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   ListWorkstationConfigsRequest request =
   *       ListWorkstationConfigsRequest.newBuilder()
   *           .setParent(
   *               WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListWorkstationConfigsResponse response =
   *         workstationsClient.listWorkstationConfigsCallable().call(request);
   *     for (WorkstationConfig element : response.getWorkstationConfigsList()) {
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
  public final UnaryCallable<ListWorkstationConfigsRequest, ListWorkstationConfigsResponse>
      listWorkstationConfigsCallable() {
    return stub.listWorkstationConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstation configurations in the specified cluster on which the caller has the
   * "workstations.workstation.create" permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   WorkstationClusterName parent =
   *       WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");
   *   for (WorkstationConfig element :
   *       workstationsClient.listUsableWorkstationConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUsableWorkstationConfigsPagedResponse listUsableWorkstationConfigs(
      WorkstationClusterName parent) {
    ListUsableWorkstationConfigsRequest request =
        ListUsableWorkstationConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUsableWorkstationConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstation configurations in the specified cluster on which the caller has the
   * "workstations.workstation.create" permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   String parent =
   *       WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]").toString();
   *   for (WorkstationConfig element :
   *       workstationsClient.listUsableWorkstationConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUsableWorkstationConfigsPagedResponse listUsableWorkstationConfigs(
      String parent) {
    ListUsableWorkstationConfigsRequest request =
        ListUsableWorkstationConfigsRequest.newBuilder().setParent(parent).build();
    return listUsableWorkstationConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstation configurations in the specified cluster on which the caller has the
   * "workstations.workstation.create" permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   ListUsableWorkstationConfigsRequest request =
   *       ListUsableWorkstationConfigsRequest.newBuilder()
   *           .setParent(
   *               WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (WorkstationConfig element :
   *       workstationsClient.listUsableWorkstationConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUsableWorkstationConfigsPagedResponse listUsableWorkstationConfigs(
      ListUsableWorkstationConfigsRequest request) {
    return listUsableWorkstationConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstation configurations in the specified cluster on which the caller has the
   * "workstations.workstation.create" permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   ListUsableWorkstationConfigsRequest request =
   *       ListUsableWorkstationConfigsRequest.newBuilder()
   *           .setParent(
   *               WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<WorkstationConfig> future =
   *       workstationsClient.listUsableWorkstationConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (WorkstationConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsPagedResponse>
      listUsableWorkstationConfigsPagedCallable() {
    return stub.listUsableWorkstationConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstation configurations in the specified cluster on which the caller has the
   * "workstations.workstation.create" permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   ListUsableWorkstationConfigsRequest request =
   *       ListUsableWorkstationConfigsRequest.newBuilder()
   *           .setParent(
   *               WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListUsableWorkstationConfigsResponse response =
   *         workstationsClient.listUsableWorkstationConfigsCallable().call(request);
   *     for (WorkstationConfig element : response.getWorkstationConfigsList()) {
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
          ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsResponse>
      listUsableWorkstationConfigsCallable() {
    return stub.listUsableWorkstationConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   WorkstationClusterName parent =
   *       WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]");
   *   WorkstationConfig workstationConfig = WorkstationConfig.newBuilder().build();
   *   String workstationConfigId = "workstationConfigId798542368";
   *   WorkstationConfig response =
   *       workstationsClient
   *           .createWorkstationConfigAsync(parent, workstationConfig, workstationConfigId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   * @param workstationConfig Required. Config to create.
   * @param workstationConfigId Required. ID to use for the workstation configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkstationConfig, OperationMetadata> createWorkstationConfigAsync(
      WorkstationClusterName parent,
      WorkstationConfig workstationConfig,
      String workstationConfigId) {
    CreateWorkstationConfigRequest request =
        CreateWorkstationConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setWorkstationConfig(workstationConfig)
            .setWorkstationConfigId(workstationConfigId)
            .build();
    return createWorkstationConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   String parent =
   *       WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]").toString();
   *   WorkstationConfig workstationConfig = WorkstationConfig.newBuilder().build();
   *   String workstationConfigId = "workstationConfigId798542368";
   *   WorkstationConfig response =
   *       workstationsClient
   *           .createWorkstationConfigAsync(parent, workstationConfig, workstationConfigId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   * @param workstationConfig Required. Config to create.
   * @param workstationConfigId Required. ID to use for the workstation configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkstationConfig, OperationMetadata> createWorkstationConfigAsync(
      String parent, WorkstationConfig workstationConfig, String workstationConfigId) {
    CreateWorkstationConfigRequest request =
        CreateWorkstationConfigRequest.newBuilder()
            .setParent(parent)
            .setWorkstationConfig(workstationConfig)
            .setWorkstationConfigId(workstationConfigId)
            .build();
    return createWorkstationConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   CreateWorkstationConfigRequest request =
   *       CreateWorkstationConfigRequest.newBuilder()
   *           .setParent(
   *               WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
   *                   .toString())
   *           .setWorkstationConfigId("workstationConfigId798542368")
   *           .setWorkstationConfig(WorkstationConfig.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   WorkstationConfig response = workstationsClient.createWorkstationConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkstationConfig, OperationMetadata> createWorkstationConfigAsync(
      CreateWorkstationConfigRequest request) {
    return createWorkstationConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   CreateWorkstationConfigRequest request =
   *       CreateWorkstationConfigRequest.newBuilder()
   *           .setParent(
   *               WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
   *                   .toString())
   *           .setWorkstationConfigId("workstationConfigId798542368")
   *           .setWorkstationConfig(WorkstationConfig.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<WorkstationConfig, OperationMetadata> future =
   *       workstationsClient.createWorkstationConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   WorkstationConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      createWorkstationConfigOperationCallable() {
    return stub.createWorkstationConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   CreateWorkstationConfigRequest request =
   *       CreateWorkstationConfigRequest.newBuilder()
   *           .setParent(
   *               WorkstationClusterName.of("[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]")
   *                   .toString())
   *           .setWorkstationConfigId("workstationConfigId798542368")
   *           .setWorkstationConfig(WorkstationConfig.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       workstationsClient.createWorkstationConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateWorkstationConfigRequest, Operation>
      createWorkstationConfigCallable() {
    return stub.createWorkstationConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   WorkstationConfig workstationConfig = WorkstationConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   WorkstationConfig response =
   *       workstationsClient.updateWorkstationConfigAsync(workstationConfig, updateMask).get();
   * }
   * }</pre>
   *
   * @param workstationConfig Required. Config to update.
   * @param updateMask Required. Mask specifying which fields in the workstation configuration
   *     should be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkstationConfig, OperationMetadata> updateWorkstationConfigAsync(
      WorkstationConfig workstationConfig, FieldMask updateMask) {
    UpdateWorkstationConfigRequest request =
        UpdateWorkstationConfigRequest.newBuilder()
            .setWorkstationConfig(workstationConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateWorkstationConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   UpdateWorkstationConfigRequest request =
   *       UpdateWorkstationConfigRequest.newBuilder()
   *           .setWorkstationConfig(WorkstationConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   WorkstationConfig response = workstationsClient.updateWorkstationConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkstationConfig, OperationMetadata> updateWorkstationConfigAsync(
      UpdateWorkstationConfigRequest request) {
    return updateWorkstationConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   UpdateWorkstationConfigRequest request =
   *       UpdateWorkstationConfigRequest.newBuilder()
   *           .setWorkstationConfig(WorkstationConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<WorkstationConfig, OperationMetadata> future =
   *       workstationsClient.updateWorkstationConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   WorkstationConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      updateWorkstationConfigOperationCallable() {
    return stub.updateWorkstationConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   UpdateWorkstationConfigRequest request =
   *       UpdateWorkstationConfigRequest.newBuilder()
   *           .setWorkstationConfig(WorkstationConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       workstationsClient.updateWorkstationConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateWorkstationConfigRequest, Operation>
      updateWorkstationConfigCallable() {
    return stub.updateWorkstationConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   WorkstationConfigName name =
   *       WorkstationConfigName.of(
   *           "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");
   *   WorkstationConfig response = workstationsClient.deleteWorkstationConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the workstation configuration to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkstationConfig, OperationMetadata> deleteWorkstationConfigAsync(
      WorkstationConfigName name) {
    DeleteWorkstationConfigRequest request =
        DeleteWorkstationConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteWorkstationConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   String name =
   *       WorkstationConfigName.of(
   *               "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]")
   *           .toString();
   *   WorkstationConfig response = workstationsClient.deleteWorkstationConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the workstation configuration to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkstationConfig, OperationMetadata> deleteWorkstationConfigAsync(
      String name) {
    DeleteWorkstationConfigRequest request =
        DeleteWorkstationConfigRequest.newBuilder().setName(name).build();
    return deleteWorkstationConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   DeleteWorkstationConfigRequest request =
   *       DeleteWorkstationConfigRequest.newBuilder()
   *           .setName(
   *               WorkstationConfigName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   WorkstationConfig response = workstationsClient.deleteWorkstationConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkstationConfig, OperationMetadata> deleteWorkstationConfigAsync(
      DeleteWorkstationConfigRequest request) {
    return deleteWorkstationConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   DeleteWorkstationConfigRequest request =
   *       DeleteWorkstationConfigRequest.newBuilder()
   *           .setName(
   *               WorkstationConfigName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<WorkstationConfig, OperationMetadata> future =
   *       workstationsClient.deleteWorkstationConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   WorkstationConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      deleteWorkstationConfigOperationCallable() {
    return stub.deleteWorkstationConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   DeleteWorkstationConfigRequest request =
   *       DeleteWorkstationConfigRequest.newBuilder()
   *           .setName(
   *               WorkstationConfigName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       workstationsClient.deleteWorkstationConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteWorkstationConfigRequest, Operation>
      deleteWorkstationConfigCallable() {
    return stub.deleteWorkstationConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   WorkstationName name =
   *       WorkstationName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[WORKSTATION_CLUSTER]",
   *           "[WORKSTATION_CONFIG]",
   *           "[WORKSTATION]");
   *   Workstation response = workstationsClient.getWorkstation(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the requested resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workstation getWorkstation(WorkstationName name) {
    GetWorkstationRequest request =
        GetWorkstationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getWorkstation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   String name =
   *       WorkstationName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[WORKSTATION_CLUSTER]",
   *               "[WORKSTATION_CONFIG]",
   *               "[WORKSTATION]")
   *           .toString();
   *   Workstation response = workstationsClient.getWorkstation(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the requested resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workstation getWorkstation(String name) {
    GetWorkstationRequest request = GetWorkstationRequest.newBuilder().setName(name).build();
    return getWorkstation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   GetWorkstationRequest request =
   *       GetWorkstationRequest.newBuilder()
   *           .setName(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .build();
   *   Workstation response = workstationsClient.getWorkstation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Workstation getWorkstation(GetWorkstationRequest request) {
    return getWorkstationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   GetWorkstationRequest request =
   *       GetWorkstationRequest.newBuilder()
   *           .setName(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Workstation> future =
   *       workstationsClient.getWorkstationCallable().futureCall(request);
   *   // Do something.
   *   Workstation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWorkstationRequest, Workstation> getWorkstationCallable() {
    return stub.getWorkstationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all Workstations using the specified workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   WorkstationConfigName parent =
   *       WorkstationConfigName.of(
   *           "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");
   *   for (Workstation element : workstationsClient.listWorkstations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkstationsPagedResponse listWorkstations(WorkstationConfigName parent) {
    ListWorkstationsRequest request =
        ListWorkstationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listWorkstations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all Workstations using the specified workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   String parent =
   *       WorkstationConfigName.of(
   *               "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]")
   *           .toString();
   *   for (Workstation element : workstationsClient.listWorkstations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkstationsPagedResponse listWorkstations(String parent) {
    ListWorkstationsRequest request =
        ListWorkstationsRequest.newBuilder().setParent(parent).build();
    return listWorkstations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all Workstations using the specified workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   ListWorkstationsRequest request =
   *       ListWorkstationsRequest.newBuilder()
   *           .setParent(
   *               WorkstationConfigName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Workstation element : workstationsClient.listWorkstations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkstationsPagedResponse listWorkstations(ListWorkstationsRequest request) {
    return listWorkstationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all Workstations using the specified workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   ListWorkstationsRequest request =
   *       ListWorkstationsRequest.newBuilder()
   *           .setParent(
   *               WorkstationConfigName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Workstation> future =
   *       workstationsClient.listWorkstationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Workstation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWorkstationsRequest, ListWorkstationsPagedResponse>
      listWorkstationsPagedCallable() {
    return stub.listWorkstationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all Workstations using the specified workstation configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   ListWorkstationsRequest request =
   *       ListWorkstationsRequest.newBuilder()
   *           .setParent(
   *               WorkstationConfigName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListWorkstationsResponse response =
   *         workstationsClient.listWorkstationsCallable().call(request);
   *     for (Workstation element : response.getWorkstationsList()) {
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
  public final UnaryCallable<ListWorkstationsRequest, ListWorkstationsResponse>
      listWorkstationsCallable() {
    return stub.listWorkstationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstations using the specified workstation configuration on which the caller has
   * the "workstations.workstations.use" permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   WorkstationConfigName parent =
   *       WorkstationConfigName.of(
   *           "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");
   *   for (Workstation element : workstationsClient.listUsableWorkstations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUsableWorkstationsPagedResponse listUsableWorkstations(
      WorkstationConfigName parent) {
    ListUsableWorkstationsRequest request =
        ListUsableWorkstationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUsableWorkstations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstations using the specified workstation configuration on which the caller has
   * the "workstations.workstations.use" permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   String parent =
   *       WorkstationConfigName.of(
   *               "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]")
   *           .toString();
   *   for (Workstation element : workstationsClient.listUsableWorkstations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUsableWorkstationsPagedResponse listUsableWorkstations(String parent) {
    ListUsableWorkstationsRequest request =
        ListUsableWorkstationsRequest.newBuilder().setParent(parent).build();
    return listUsableWorkstations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstations using the specified workstation configuration on which the caller has
   * the "workstations.workstations.use" permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   ListUsableWorkstationsRequest request =
   *       ListUsableWorkstationsRequest.newBuilder()
   *           .setParent(
   *               WorkstationConfigName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Workstation element : workstationsClient.listUsableWorkstations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUsableWorkstationsPagedResponse listUsableWorkstations(
      ListUsableWorkstationsRequest request) {
    return listUsableWorkstationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstations using the specified workstation configuration on which the caller has
   * the "workstations.workstations.use" permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   ListUsableWorkstationsRequest request =
   *       ListUsableWorkstationsRequest.newBuilder()
   *           .setParent(
   *               WorkstationConfigName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Workstation> future =
   *       workstationsClient.listUsableWorkstationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Workstation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUsableWorkstationsRequest, ListUsableWorkstationsPagedResponse>
      listUsableWorkstationsPagedCallable() {
    return stub.listUsableWorkstationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all workstations using the specified workstation configuration on which the caller has
   * the "workstations.workstations.use" permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   ListUsableWorkstationsRequest request =
   *       ListUsableWorkstationsRequest.newBuilder()
   *           .setParent(
   *               WorkstationConfigName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListUsableWorkstationsResponse response =
   *         workstationsClient.listUsableWorkstationsCallable().call(request);
   *     for (Workstation element : response.getWorkstationsList()) {
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
  public final UnaryCallable<ListUsableWorkstationsRequest, ListUsableWorkstationsResponse>
      listUsableWorkstationsCallable() {
    return stub.listUsableWorkstationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   WorkstationConfigName parent =
   *       WorkstationConfigName.of(
   *           "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]");
   *   Workstation workstation = Workstation.newBuilder().build();
   *   String workstationId = "workstationId560540030";
   *   Workstation response =
   *       workstationsClient.createWorkstationAsync(parent, workstation, workstationId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   * @param workstation Required. Workstation to create.
   * @param workstationId Required. ID to use for the workstation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workstation, OperationMetadata> createWorkstationAsync(
      WorkstationConfigName parent, Workstation workstation, String workstationId) {
    CreateWorkstationRequest request =
        CreateWorkstationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setWorkstation(workstation)
            .setWorkstationId(workstationId)
            .build();
    return createWorkstationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   String parent =
   *       WorkstationConfigName.of(
   *               "[PROJECT]", "[LOCATION]", "[WORKSTATION_CLUSTER]", "[WORKSTATION_CONFIG]")
   *           .toString();
   *   Workstation workstation = Workstation.newBuilder().build();
   *   String workstationId = "workstationId560540030";
   *   Workstation response =
   *       workstationsClient.createWorkstationAsync(parent, workstation, workstationId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Parent resource name.
   * @param workstation Required. Workstation to create.
   * @param workstationId Required. ID to use for the workstation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workstation, OperationMetadata> createWorkstationAsync(
      String parent, Workstation workstation, String workstationId) {
    CreateWorkstationRequest request =
        CreateWorkstationRequest.newBuilder()
            .setParent(parent)
            .setWorkstation(workstation)
            .setWorkstationId(workstationId)
            .build();
    return createWorkstationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   CreateWorkstationRequest request =
   *       CreateWorkstationRequest.newBuilder()
   *           .setParent(
   *               WorkstationConfigName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]")
   *                   .toString())
   *           .setWorkstationId("workstationId560540030")
   *           .setWorkstation(Workstation.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Workstation response = workstationsClient.createWorkstationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workstation, OperationMetadata> createWorkstationAsync(
      CreateWorkstationRequest request) {
    return createWorkstationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   CreateWorkstationRequest request =
   *       CreateWorkstationRequest.newBuilder()
   *           .setParent(
   *               WorkstationConfigName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]")
   *                   .toString())
   *           .setWorkstationId("workstationId560540030")
   *           .setWorkstation(Workstation.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Workstation, OperationMetadata> future =
   *       workstationsClient.createWorkstationOperationCallable().futureCall(request);
   *   // Do something.
   *   Workstation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateWorkstationRequest, Workstation, OperationMetadata>
      createWorkstationOperationCallable() {
    return stub.createWorkstationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   CreateWorkstationRequest request =
   *       CreateWorkstationRequest.newBuilder()
   *           .setParent(
   *               WorkstationConfigName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]")
   *                   .toString())
   *           .setWorkstationId("workstationId560540030")
   *           .setWorkstation(Workstation.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       workstationsClient.createWorkstationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateWorkstationRequest, Operation> createWorkstationCallable() {
    return stub.createWorkstationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   Workstation workstation = Workstation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Workstation response =
   *       workstationsClient.updateWorkstationAsync(workstation, updateMask).get();
   * }
   * }</pre>
   *
   * @param workstation Required. Workstation to update.
   * @param updateMask Required. Mask specifying which fields in the workstation configuration
   *     should be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workstation, OperationMetadata> updateWorkstationAsync(
      Workstation workstation, FieldMask updateMask) {
    UpdateWorkstationRequest request =
        UpdateWorkstationRequest.newBuilder()
            .setWorkstation(workstation)
            .setUpdateMask(updateMask)
            .build();
    return updateWorkstationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   UpdateWorkstationRequest request =
   *       UpdateWorkstationRequest.newBuilder()
   *           .setWorkstation(Workstation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   Workstation response = workstationsClient.updateWorkstationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workstation, OperationMetadata> updateWorkstationAsync(
      UpdateWorkstationRequest request) {
    return updateWorkstationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   UpdateWorkstationRequest request =
   *       UpdateWorkstationRequest.newBuilder()
   *           .setWorkstation(Workstation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<Workstation, OperationMetadata> future =
   *       workstationsClient.updateWorkstationOperationCallable().futureCall(request);
   *   // Do something.
   *   Workstation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateWorkstationRequest, Workstation, OperationMetadata>
      updateWorkstationOperationCallable() {
    return stub.updateWorkstationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   UpdateWorkstationRequest request =
   *       UpdateWorkstationRequest.newBuilder()
   *           .setWorkstation(Workstation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       workstationsClient.updateWorkstationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateWorkstationRequest, Operation> updateWorkstationCallable() {
    return stub.updateWorkstationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   WorkstationName name =
   *       WorkstationName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[WORKSTATION_CLUSTER]",
   *           "[WORKSTATION_CONFIG]",
   *           "[WORKSTATION]");
   *   Workstation response = workstationsClient.deleteWorkstationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the workstation to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workstation, OperationMetadata> deleteWorkstationAsync(
      WorkstationName name) {
    DeleteWorkstationRequest request =
        DeleteWorkstationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteWorkstationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   String name =
   *       WorkstationName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[WORKSTATION_CLUSTER]",
   *               "[WORKSTATION_CONFIG]",
   *               "[WORKSTATION]")
   *           .toString();
   *   Workstation response = workstationsClient.deleteWorkstationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the workstation to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workstation, OperationMetadata> deleteWorkstationAsync(String name) {
    DeleteWorkstationRequest request = DeleteWorkstationRequest.newBuilder().setName(name).build();
    return deleteWorkstationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   DeleteWorkstationRequest request =
   *       DeleteWorkstationRequest.newBuilder()
   *           .setName(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   Workstation response = workstationsClient.deleteWorkstationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workstation, OperationMetadata> deleteWorkstationAsync(
      DeleteWorkstationRequest request) {
    return deleteWorkstationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   DeleteWorkstationRequest request =
   *       DeleteWorkstationRequest.newBuilder()
   *           .setName(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Workstation, OperationMetadata> future =
   *       workstationsClient.deleteWorkstationOperationCallable().futureCall(request);
   *   // Do something.
   *   Workstation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteWorkstationRequest, Workstation, OperationMetadata>
      deleteWorkstationOperationCallable() {
    return stub.deleteWorkstationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   DeleteWorkstationRequest request =
   *       DeleteWorkstationRequest.newBuilder()
   *           .setName(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       workstationsClient.deleteWorkstationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteWorkstationRequest, Operation> deleteWorkstationCallable() {
    return stub.deleteWorkstationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts running a workstation so that users can connect to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   WorkstationName name =
   *       WorkstationName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[WORKSTATION_CLUSTER]",
   *           "[WORKSTATION_CONFIG]",
   *           "[WORKSTATION]");
   *   Workstation response = workstationsClient.startWorkstationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the workstation to start.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workstation, OperationMetadata> startWorkstationAsync(
      WorkstationName name) {
    StartWorkstationRequest request =
        StartWorkstationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return startWorkstationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts running a workstation so that users can connect to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   String name =
   *       WorkstationName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[WORKSTATION_CLUSTER]",
   *               "[WORKSTATION_CONFIG]",
   *               "[WORKSTATION]")
   *           .toString();
   *   Workstation response = workstationsClient.startWorkstationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the workstation to start.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workstation, OperationMetadata> startWorkstationAsync(String name) {
    StartWorkstationRequest request = StartWorkstationRequest.newBuilder().setName(name).build();
    return startWorkstationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts running a workstation so that users can connect to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   StartWorkstationRequest request =
   *       StartWorkstationRequest.newBuilder()
   *           .setName(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   Workstation response = workstationsClient.startWorkstationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workstation, OperationMetadata> startWorkstationAsync(
      StartWorkstationRequest request) {
    return startWorkstationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts running a workstation so that users can connect to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   StartWorkstationRequest request =
   *       StartWorkstationRequest.newBuilder()
   *           .setName(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Workstation, OperationMetadata> future =
   *       workstationsClient.startWorkstationOperationCallable().futureCall(request);
   *   // Do something.
   *   Workstation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StartWorkstationRequest, Workstation, OperationMetadata>
      startWorkstationOperationCallable() {
    return stub.startWorkstationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts running a workstation so that users can connect to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   StartWorkstationRequest request =
   *       StartWorkstationRequest.newBuilder()
   *           .setName(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       workstationsClient.startWorkstationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartWorkstationRequest, Operation> startWorkstationCallable() {
    return stub.startWorkstationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops running a workstation, reducing costs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   WorkstationName name =
   *       WorkstationName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[WORKSTATION_CLUSTER]",
   *           "[WORKSTATION_CONFIG]",
   *           "[WORKSTATION]");
   *   Workstation response = workstationsClient.stopWorkstationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the workstation to stop.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workstation, OperationMetadata> stopWorkstationAsync(
      WorkstationName name) {
    StopWorkstationRequest request =
        StopWorkstationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return stopWorkstationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops running a workstation, reducing costs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   String name =
   *       WorkstationName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[WORKSTATION_CLUSTER]",
   *               "[WORKSTATION_CONFIG]",
   *               "[WORKSTATION]")
   *           .toString();
   *   Workstation response = workstationsClient.stopWorkstationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the workstation to stop.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workstation, OperationMetadata> stopWorkstationAsync(String name) {
    StopWorkstationRequest request = StopWorkstationRequest.newBuilder().setName(name).build();
    return stopWorkstationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops running a workstation, reducing costs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   StopWorkstationRequest request =
   *       StopWorkstationRequest.newBuilder()
   *           .setName(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   Workstation response = workstationsClient.stopWorkstationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Workstation, OperationMetadata> stopWorkstationAsync(
      StopWorkstationRequest request) {
    return stopWorkstationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops running a workstation, reducing costs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   StopWorkstationRequest request =
   *       StopWorkstationRequest.newBuilder()
   *           .setName(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Workstation, OperationMetadata> future =
   *       workstationsClient.stopWorkstationOperationCallable().futureCall(request);
   *   // Do something.
   *   Workstation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StopWorkstationRequest, Workstation, OperationMetadata>
      stopWorkstationOperationCallable() {
    return stub.stopWorkstationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops running a workstation, reducing costs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   StopWorkstationRequest request =
   *       StopWorkstationRequest.newBuilder()
   *           .setName(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       workstationsClient.stopWorkstationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StopWorkstationRequest, Operation> stopWorkstationCallable() {
    return stub.stopWorkstationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a short-lived credential that can be used to send authenticated and authorized traffic
   * to a workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   WorkstationName workstation =
   *       WorkstationName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[WORKSTATION_CLUSTER]",
   *           "[WORKSTATION_CONFIG]",
   *           "[WORKSTATION]");
   *   GenerateAccessTokenResponse response = workstationsClient.generateAccessToken(workstation);
   * }
   * }</pre>
   *
   * @param workstation Required. Name of the workstation for which the access token should be
   *     generated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateAccessTokenResponse generateAccessToken(WorkstationName workstation) {
    GenerateAccessTokenRequest request =
        GenerateAccessTokenRequest.newBuilder()
            .setWorkstation(workstation == null ? null : workstation.toString())
            .build();
    return generateAccessToken(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a short-lived credential that can be used to send authenticated and authorized traffic
   * to a workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   String workstation =
   *       WorkstationName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[WORKSTATION_CLUSTER]",
   *               "[WORKSTATION_CONFIG]",
   *               "[WORKSTATION]")
   *           .toString();
   *   GenerateAccessTokenResponse response = workstationsClient.generateAccessToken(workstation);
   * }
   * }</pre>
   *
   * @param workstation Required. Name of the workstation for which the access token should be
   *     generated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateAccessTokenResponse generateAccessToken(String workstation) {
    GenerateAccessTokenRequest request =
        GenerateAccessTokenRequest.newBuilder().setWorkstation(workstation).build();
    return generateAccessToken(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a short-lived credential that can be used to send authenticated and authorized traffic
   * to a workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   GenerateAccessTokenRequest request =
   *       GenerateAccessTokenRequest.newBuilder()
   *           .setWorkstation(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .build();
   *   GenerateAccessTokenResponse response = workstationsClient.generateAccessToken(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateAccessTokenResponse generateAccessToken(GenerateAccessTokenRequest request) {
    return generateAccessTokenCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a short-lived credential that can be used to send authenticated and authorized traffic
   * to a workstation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   GenerateAccessTokenRequest request =
   *       GenerateAccessTokenRequest.newBuilder()
   *           .setWorkstation(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<GenerateAccessTokenResponse> future =
   *       workstationsClient.generateAccessTokenCallable().futureCall(request);
   *   // Do something.
   *   GenerateAccessTokenResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenCallable() {
    return stub.generateAccessTokenCallable();
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
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = workstationsClient.setIamPolicy(request);
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
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = workstationsClient.setIamPolicyCallable().futureCall(request);
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
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = workstationsClient.getIamPolicy(request);
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
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = workstationsClient.getIamPolicyCallable().futureCall(request);
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
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = workstationsClient.testIamPermissions(request);
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
   * try (WorkstationsClient workstationsClient = WorkstationsClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               WorkstationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[WORKSTATION_CLUSTER]",
   *                       "[WORKSTATION_CONFIG]",
   *                       "[WORKSTATION]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       workstationsClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListWorkstationClustersPagedResponse
      extends AbstractPagedListResponse<
          ListWorkstationClustersRequest,
          ListWorkstationClustersResponse,
          WorkstationCluster,
          ListWorkstationClustersPage,
          ListWorkstationClustersFixedSizeCollection> {

    public static ApiFuture<ListWorkstationClustersPagedResponse> createAsync(
        PageContext<
                ListWorkstationClustersRequest, ListWorkstationClustersResponse, WorkstationCluster>
            context,
        ApiFuture<ListWorkstationClustersResponse> futureResponse) {
      ApiFuture<ListWorkstationClustersPage> futurePage =
          ListWorkstationClustersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListWorkstationClustersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListWorkstationClustersPagedResponse(ListWorkstationClustersPage page) {
      super(page, ListWorkstationClustersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListWorkstationClustersPage
      extends AbstractPage<
          ListWorkstationClustersRequest,
          ListWorkstationClustersResponse,
          WorkstationCluster,
          ListWorkstationClustersPage> {

    private ListWorkstationClustersPage(
        PageContext<
                ListWorkstationClustersRequest, ListWorkstationClustersResponse, WorkstationCluster>
            context,
        ListWorkstationClustersResponse response) {
      super(context, response);
    }

    private static ListWorkstationClustersPage createEmptyPage() {
      return new ListWorkstationClustersPage(null, null);
    }

    @Override
    protected ListWorkstationClustersPage createPage(
        PageContext<
                ListWorkstationClustersRequest, ListWorkstationClustersResponse, WorkstationCluster>
            context,
        ListWorkstationClustersResponse response) {
      return new ListWorkstationClustersPage(context, response);
    }

    @Override
    public ApiFuture<ListWorkstationClustersPage> createPageAsync(
        PageContext<
                ListWorkstationClustersRequest, ListWorkstationClustersResponse, WorkstationCluster>
            context,
        ApiFuture<ListWorkstationClustersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListWorkstationClustersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWorkstationClustersRequest,
          ListWorkstationClustersResponse,
          WorkstationCluster,
          ListWorkstationClustersPage,
          ListWorkstationClustersFixedSizeCollection> {

    private ListWorkstationClustersFixedSizeCollection(
        List<ListWorkstationClustersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListWorkstationClustersFixedSizeCollection createEmptyCollection() {
      return new ListWorkstationClustersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListWorkstationClustersFixedSizeCollection createCollection(
        List<ListWorkstationClustersPage> pages, int collectionSize) {
      return new ListWorkstationClustersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListWorkstationConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListWorkstationConfigsRequest,
          ListWorkstationConfigsResponse,
          WorkstationConfig,
          ListWorkstationConfigsPage,
          ListWorkstationConfigsFixedSizeCollection> {

    public static ApiFuture<ListWorkstationConfigsPagedResponse> createAsync(
        PageContext<
                ListWorkstationConfigsRequest, ListWorkstationConfigsResponse, WorkstationConfig>
            context,
        ApiFuture<ListWorkstationConfigsResponse> futureResponse) {
      ApiFuture<ListWorkstationConfigsPage> futurePage =
          ListWorkstationConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListWorkstationConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListWorkstationConfigsPagedResponse(ListWorkstationConfigsPage page) {
      super(page, ListWorkstationConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListWorkstationConfigsPage
      extends AbstractPage<
          ListWorkstationConfigsRequest,
          ListWorkstationConfigsResponse,
          WorkstationConfig,
          ListWorkstationConfigsPage> {

    private ListWorkstationConfigsPage(
        PageContext<
                ListWorkstationConfigsRequest, ListWorkstationConfigsResponse, WorkstationConfig>
            context,
        ListWorkstationConfigsResponse response) {
      super(context, response);
    }

    private static ListWorkstationConfigsPage createEmptyPage() {
      return new ListWorkstationConfigsPage(null, null);
    }

    @Override
    protected ListWorkstationConfigsPage createPage(
        PageContext<
                ListWorkstationConfigsRequest, ListWorkstationConfigsResponse, WorkstationConfig>
            context,
        ListWorkstationConfigsResponse response) {
      return new ListWorkstationConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListWorkstationConfigsPage> createPageAsync(
        PageContext<
                ListWorkstationConfigsRequest, ListWorkstationConfigsResponse, WorkstationConfig>
            context,
        ApiFuture<ListWorkstationConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListWorkstationConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWorkstationConfigsRequest,
          ListWorkstationConfigsResponse,
          WorkstationConfig,
          ListWorkstationConfigsPage,
          ListWorkstationConfigsFixedSizeCollection> {

    private ListWorkstationConfigsFixedSizeCollection(
        List<ListWorkstationConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListWorkstationConfigsFixedSizeCollection createEmptyCollection() {
      return new ListWorkstationConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListWorkstationConfigsFixedSizeCollection createCollection(
        List<ListWorkstationConfigsPage> pages, int collectionSize) {
      return new ListWorkstationConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListUsableWorkstationConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListUsableWorkstationConfigsRequest,
          ListUsableWorkstationConfigsResponse,
          WorkstationConfig,
          ListUsableWorkstationConfigsPage,
          ListUsableWorkstationConfigsFixedSizeCollection> {

    public static ApiFuture<ListUsableWorkstationConfigsPagedResponse> createAsync(
        PageContext<
                ListUsableWorkstationConfigsRequest,
                ListUsableWorkstationConfigsResponse,
                WorkstationConfig>
            context,
        ApiFuture<ListUsableWorkstationConfigsResponse> futureResponse) {
      ApiFuture<ListUsableWorkstationConfigsPage> futurePage =
          ListUsableWorkstationConfigsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListUsableWorkstationConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListUsableWorkstationConfigsPagedResponse(ListUsableWorkstationConfigsPage page) {
      super(page, ListUsableWorkstationConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUsableWorkstationConfigsPage
      extends AbstractPage<
          ListUsableWorkstationConfigsRequest,
          ListUsableWorkstationConfigsResponse,
          WorkstationConfig,
          ListUsableWorkstationConfigsPage> {

    private ListUsableWorkstationConfigsPage(
        PageContext<
                ListUsableWorkstationConfigsRequest,
                ListUsableWorkstationConfigsResponse,
                WorkstationConfig>
            context,
        ListUsableWorkstationConfigsResponse response) {
      super(context, response);
    }

    private static ListUsableWorkstationConfigsPage createEmptyPage() {
      return new ListUsableWorkstationConfigsPage(null, null);
    }

    @Override
    protected ListUsableWorkstationConfigsPage createPage(
        PageContext<
                ListUsableWorkstationConfigsRequest,
                ListUsableWorkstationConfigsResponse,
                WorkstationConfig>
            context,
        ListUsableWorkstationConfigsResponse response) {
      return new ListUsableWorkstationConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListUsableWorkstationConfigsPage> createPageAsync(
        PageContext<
                ListUsableWorkstationConfigsRequest,
                ListUsableWorkstationConfigsResponse,
                WorkstationConfig>
            context,
        ApiFuture<ListUsableWorkstationConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUsableWorkstationConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUsableWorkstationConfigsRequest,
          ListUsableWorkstationConfigsResponse,
          WorkstationConfig,
          ListUsableWorkstationConfigsPage,
          ListUsableWorkstationConfigsFixedSizeCollection> {

    private ListUsableWorkstationConfigsFixedSizeCollection(
        List<ListUsableWorkstationConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUsableWorkstationConfigsFixedSizeCollection createEmptyCollection() {
      return new ListUsableWorkstationConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUsableWorkstationConfigsFixedSizeCollection createCollection(
        List<ListUsableWorkstationConfigsPage> pages, int collectionSize) {
      return new ListUsableWorkstationConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListWorkstationsPagedResponse
      extends AbstractPagedListResponse<
          ListWorkstationsRequest,
          ListWorkstationsResponse,
          Workstation,
          ListWorkstationsPage,
          ListWorkstationsFixedSizeCollection> {

    public static ApiFuture<ListWorkstationsPagedResponse> createAsync(
        PageContext<ListWorkstationsRequest, ListWorkstationsResponse, Workstation> context,
        ApiFuture<ListWorkstationsResponse> futureResponse) {
      ApiFuture<ListWorkstationsPage> futurePage =
          ListWorkstationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListWorkstationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListWorkstationsPagedResponse(ListWorkstationsPage page) {
      super(page, ListWorkstationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListWorkstationsPage
      extends AbstractPage<
          ListWorkstationsRequest, ListWorkstationsResponse, Workstation, ListWorkstationsPage> {

    private ListWorkstationsPage(
        PageContext<ListWorkstationsRequest, ListWorkstationsResponse, Workstation> context,
        ListWorkstationsResponse response) {
      super(context, response);
    }

    private static ListWorkstationsPage createEmptyPage() {
      return new ListWorkstationsPage(null, null);
    }

    @Override
    protected ListWorkstationsPage createPage(
        PageContext<ListWorkstationsRequest, ListWorkstationsResponse, Workstation> context,
        ListWorkstationsResponse response) {
      return new ListWorkstationsPage(context, response);
    }

    @Override
    public ApiFuture<ListWorkstationsPage> createPageAsync(
        PageContext<ListWorkstationsRequest, ListWorkstationsResponse, Workstation> context,
        ApiFuture<ListWorkstationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListWorkstationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWorkstationsRequest,
          ListWorkstationsResponse,
          Workstation,
          ListWorkstationsPage,
          ListWorkstationsFixedSizeCollection> {

    private ListWorkstationsFixedSizeCollection(
        List<ListWorkstationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListWorkstationsFixedSizeCollection createEmptyCollection() {
      return new ListWorkstationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListWorkstationsFixedSizeCollection createCollection(
        List<ListWorkstationsPage> pages, int collectionSize) {
      return new ListWorkstationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListUsableWorkstationsPagedResponse
      extends AbstractPagedListResponse<
          ListUsableWorkstationsRequest,
          ListUsableWorkstationsResponse,
          Workstation,
          ListUsableWorkstationsPage,
          ListUsableWorkstationsFixedSizeCollection> {

    public static ApiFuture<ListUsableWorkstationsPagedResponse> createAsync(
        PageContext<ListUsableWorkstationsRequest, ListUsableWorkstationsResponse, Workstation>
            context,
        ApiFuture<ListUsableWorkstationsResponse> futureResponse) {
      ApiFuture<ListUsableWorkstationsPage> futurePage =
          ListUsableWorkstationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListUsableWorkstationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListUsableWorkstationsPagedResponse(ListUsableWorkstationsPage page) {
      super(page, ListUsableWorkstationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUsableWorkstationsPage
      extends AbstractPage<
          ListUsableWorkstationsRequest,
          ListUsableWorkstationsResponse,
          Workstation,
          ListUsableWorkstationsPage> {

    private ListUsableWorkstationsPage(
        PageContext<ListUsableWorkstationsRequest, ListUsableWorkstationsResponse, Workstation>
            context,
        ListUsableWorkstationsResponse response) {
      super(context, response);
    }

    private static ListUsableWorkstationsPage createEmptyPage() {
      return new ListUsableWorkstationsPage(null, null);
    }

    @Override
    protected ListUsableWorkstationsPage createPage(
        PageContext<ListUsableWorkstationsRequest, ListUsableWorkstationsResponse, Workstation>
            context,
        ListUsableWorkstationsResponse response) {
      return new ListUsableWorkstationsPage(context, response);
    }

    @Override
    public ApiFuture<ListUsableWorkstationsPage> createPageAsync(
        PageContext<ListUsableWorkstationsRequest, ListUsableWorkstationsResponse, Workstation>
            context,
        ApiFuture<ListUsableWorkstationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUsableWorkstationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUsableWorkstationsRequest,
          ListUsableWorkstationsResponse,
          Workstation,
          ListUsableWorkstationsPage,
          ListUsableWorkstationsFixedSizeCollection> {

    private ListUsableWorkstationsFixedSizeCollection(
        List<ListUsableWorkstationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUsableWorkstationsFixedSizeCollection createEmptyCollection() {
      return new ListUsableWorkstationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUsableWorkstationsFixedSizeCollection createCollection(
        List<ListUsableWorkstationsPage> pages, int collectionSize) {
      return new ListUsableWorkstationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
