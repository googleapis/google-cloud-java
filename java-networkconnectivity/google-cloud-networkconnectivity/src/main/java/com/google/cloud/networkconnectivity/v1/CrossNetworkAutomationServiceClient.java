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
import com.google.cloud.networkconnectivity.v1.stub.CrossNetworkAutomationServiceStub;
import com.google.cloud.networkconnectivity.v1.stub.CrossNetworkAutomationServiceStubSettings;
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
 * Service Description: The service for CrossNetworkAutomation resources.
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
 * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
 *     CrossNetworkAutomationServiceClient.create()) {
 *   ServiceConnectionMapName name =
 *       ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]");
 *   ServiceConnectionMap response =
 *       crossNetworkAutomationServiceClient.getServiceConnectionMap(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CrossNetworkAutomationServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListServiceConnectionMaps</td>
 *      <td><p> Lists ServiceConnectionMaps in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listServiceConnectionMaps(ListServiceConnectionMapsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listServiceConnectionMaps(LocationName parent)
 *           <li><p> listServiceConnectionMaps(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listServiceConnectionMapsPagedCallable()
 *           <li><p> listServiceConnectionMapsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetServiceConnectionMap</td>
 *      <td><p> Gets details of a single ServiceConnectionMap.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getServiceConnectionMap(GetServiceConnectionMapRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getServiceConnectionMap(ServiceConnectionMapName name)
 *           <li><p> getServiceConnectionMap(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getServiceConnectionMapCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateServiceConnectionMap</td>
 *      <td><p> Creates a new ServiceConnectionMap in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createServiceConnectionMapAsync(CreateServiceConnectionMapRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createServiceConnectionMapAsync(LocationName parent, ServiceConnectionMap serviceConnectionMap, String serviceConnectionMapId)
 *           <li><p> createServiceConnectionMapAsync(String parent, ServiceConnectionMap serviceConnectionMap, String serviceConnectionMapId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createServiceConnectionMapOperationCallable()
 *           <li><p> createServiceConnectionMapCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateServiceConnectionMap</td>
 *      <td><p> Updates the parameters of a single ServiceConnectionMap.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateServiceConnectionMapAsync(UpdateServiceConnectionMapRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateServiceConnectionMapAsync(ServiceConnectionMap serviceConnectionMap, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateServiceConnectionMapOperationCallable()
 *           <li><p> updateServiceConnectionMapCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteServiceConnectionMap</td>
 *      <td><p> Deletes a single ServiceConnectionMap.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteServiceConnectionMapAsync(DeleteServiceConnectionMapRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteServiceConnectionMapAsync(ServiceConnectionMapName name)
 *           <li><p> deleteServiceConnectionMapAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteServiceConnectionMapOperationCallable()
 *           <li><p> deleteServiceConnectionMapCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListServiceConnectionPolicies</td>
 *      <td><p> Lists ServiceConnectionPolicies in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listServiceConnectionPolicies(ListServiceConnectionPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listServiceConnectionPolicies(LocationName parent)
 *           <li><p> listServiceConnectionPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listServiceConnectionPoliciesPagedCallable()
 *           <li><p> listServiceConnectionPoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetServiceConnectionPolicy</td>
 *      <td><p> Gets details of a single ServiceConnectionPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getServiceConnectionPolicy(GetServiceConnectionPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getServiceConnectionPolicy(ServiceConnectionPolicyName name)
 *           <li><p> getServiceConnectionPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getServiceConnectionPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateServiceConnectionPolicy</td>
 *      <td><p> Creates a new ServiceConnectionPolicy in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createServiceConnectionPolicyAsync(CreateServiceConnectionPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createServiceConnectionPolicyAsync(LocationName parent, ServiceConnectionPolicy serviceConnectionPolicy, String serviceConnectionPolicyId)
 *           <li><p> createServiceConnectionPolicyAsync(String parent, ServiceConnectionPolicy serviceConnectionPolicy, String serviceConnectionPolicyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createServiceConnectionPolicyOperationCallable()
 *           <li><p> createServiceConnectionPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateServiceConnectionPolicy</td>
 *      <td><p> Updates the parameters of a single ServiceConnectionPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateServiceConnectionPolicyAsync(UpdateServiceConnectionPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateServiceConnectionPolicyAsync(ServiceConnectionPolicy serviceConnectionPolicy, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateServiceConnectionPolicyOperationCallable()
 *           <li><p> updateServiceConnectionPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteServiceConnectionPolicy</td>
 *      <td><p> Deletes a single ServiceConnectionPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteServiceConnectionPolicyAsync(DeleteServiceConnectionPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteServiceConnectionPolicyAsync(ServiceConnectionPolicyName name)
 *           <li><p> deleteServiceConnectionPolicyAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteServiceConnectionPolicyOperationCallable()
 *           <li><p> deleteServiceConnectionPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListServiceClasses</td>
 *      <td><p> Lists ServiceClasses in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listServiceClasses(ListServiceClassesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listServiceClasses(LocationName parent)
 *           <li><p> listServiceClasses(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listServiceClassesPagedCallable()
 *           <li><p> listServiceClassesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetServiceClass</td>
 *      <td><p> Gets details of a single ServiceClass.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getServiceClass(GetServiceClassRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getServiceClass(ServiceClassName name)
 *           <li><p> getServiceClass(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getServiceClassCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateServiceClass</td>
 *      <td><p> Updates the parameters of a single ServiceClass.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateServiceClassAsync(UpdateServiceClassRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateServiceClassAsync(ServiceClass serviceClass, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateServiceClassOperationCallable()
 *           <li><p> updateServiceClassCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteServiceClass</td>
 *      <td><p> Deletes a single ServiceClass.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteServiceClassAsync(DeleteServiceClassRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteServiceClassAsync(ServiceClassName name)
 *           <li><p> deleteServiceClassAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteServiceClassOperationCallable()
 *           <li><p> deleteServiceClassCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetServiceConnectionToken</td>
 *      <td><p> Gets details of a single ServiceConnectionToken.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getServiceConnectionToken(GetServiceConnectionTokenRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getServiceConnectionToken(ServiceConnectionTokenName name)
 *           <li><p> getServiceConnectionToken(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getServiceConnectionTokenCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListServiceConnectionTokens</td>
 *      <td><p> Lists ServiceConnectionTokens in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listServiceConnectionTokens(ListServiceConnectionTokensRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listServiceConnectionTokens(LocationName parent)
 *           <li><p> listServiceConnectionTokens(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listServiceConnectionTokensPagedCallable()
 *           <li><p> listServiceConnectionTokensCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateServiceConnectionToken</td>
 *      <td><p> Creates a new ServiceConnectionToken in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createServiceConnectionTokenAsync(CreateServiceConnectionTokenRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createServiceConnectionTokenAsync(LocationName parent, ServiceConnectionToken serviceConnectionToken, String serviceConnectionTokenId)
 *           <li><p> createServiceConnectionTokenAsync(String parent, ServiceConnectionToken serviceConnectionToken, String serviceConnectionTokenId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createServiceConnectionTokenOperationCallable()
 *           <li><p> createServiceConnectionTokenCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteServiceConnectionToken</td>
 *      <td><p> Deletes a single ServiceConnectionToken.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteServiceConnectionTokenAsync(DeleteServiceConnectionTokenRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteServiceConnectionTokenAsync(ServiceConnectionTokenName name)
 *           <li><p> deleteServiceConnectionTokenAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteServiceConnectionTokenOperationCallable()
 *           <li><p> deleteServiceConnectionTokenCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * CrossNetworkAutomationServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CrossNetworkAutomationServiceSettings crossNetworkAutomationServiceSettings =
 *     CrossNetworkAutomationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
 *     CrossNetworkAutomationServiceClient.create(crossNetworkAutomationServiceSettings);
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
 * CrossNetworkAutomationServiceSettings crossNetworkAutomationServiceSettings =
 *     CrossNetworkAutomationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
 *     CrossNetworkAutomationServiceClient.create(crossNetworkAutomationServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CrossNetworkAutomationServiceClient implements BackgroundResource {
  private final CrossNetworkAutomationServiceSettings settings;
  private final CrossNetworkAutomationServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of CrossNetworkAutomationServiceClient with default settings. */
  public static final CrossNetworkAutomationServiceClient create() throws IOException {
    return create(CrossNetworkAutomationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CrossNetworkAutomationServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final CrossNetworkAutomationServiceClient create(
      CrossNetworkAutomationServiceSettings settings) throws IOException {
    return new CrossNetworkAutomationServiceClient(settings);
  }

  /**
   * Constructs an instance of CrossNetworkAutomationServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(CrossNetworkAutomationServiceSettings).
   */
  public static final CrossNetworkAutomationServiceClient create(
      CrossNetworkAutomationServiceStub stub) {
    return new CrossNetworkAutomationServiceClient(stub);
  }

  /**
   * Constructs an instance of CrossNetworkAutomationServiceClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CrossNetworkAutomationServiceClient(CrossNetworkAutomationServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((CrossNetworkAutomationServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected CrossNetworkAutomationServiceClient(CrossNetworkAutomationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final CrossNetworkAutomationServiceSettings getSettings() {
    return settings;
  }

  public CrossNetworkAutomationServiceStub getStub() {
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
   * Lists ServiceConnectionMaps in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ServiceConnectionMap element :
   *       crossNetworkAutomationServiceClient.listServiceConnectionMaps(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name. ex. projects/123/locations/us-east1
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceConnectionMapsPagedResponse listServiceConnectionMaps(
      LocationName parent) {
    ListServiceConnectionMapsRequest request =
        ListServiceConnectionMapsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listServiceConnectionMaps(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceConnectionMaps in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ServiceConnectionMap element :
   *       crossNetworkAutomationServiceClient.listServiceConnectionMaps(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name. ex. projects/123/locations/us-east1
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceConnectionMapsPagedResponse listServiceConnectionMaps(String parent) {
    ListServiceConnectionMapsRequest request =
        ListServiceConnectionMapsRequest.newBuilder().setParent(parent).build();
    return listServiceConnectionMaps(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceConnectionMaps in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ListServiceConnectionMapsRequest request =
   *       ListServiceConnectionMapsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ServiceConnectionMap element :
   *       crossNetworkAutomationServiceClient.listServiceConnectionMaps(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceConnectionMapsPagedResponse listServiceConnectionMaps(
      ListServiceConnectionMapsRequest request) {
    return listServiceConnectionMapsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceConnectionMaps in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ListServiceConnectionMapsRequest request =
   *       ListServiceConnectionMapsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ServiceConnectionMap> future =
   *       crossNetworkAutomationServiceClient
   *           .listServiceConnectionMapsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (ServiceConnectionMap element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListServiceConnectionMapsRequest, ListServiceConnectionMapsPagedResponse>
      listServiceConnectionMapsPagedCallable() {
    return stub.listServiceConnectionMapsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceConnectionMaps in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ListServiceConnectionMapsRequest request =
   *       ListServiceConnectionMapsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListServiceConnectionMapsResponse response =
   *         crossNetworkAutomationServiceClient.listServiceConnectionMapsCallable().call(request);
   *     for (ServiceConnectionMap element : response.getServiceConnectionMapsList()) {
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
  public final UnaryCallable<ListServiceConnectionMapsRequest, ListServiceConnectionMapsResponse>
      listServiceConnectionMapsCallable() {
    return stub.listServiceConnectionMapsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceConnectionMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ServiceConnectionMapName name =
   *       ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]");
   *   ServiceConnectionMap response =
   *       crossNetworkAutomationServiceClient.getServiceConnectionMap(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the ServiceConnectionMap to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceConnectionMap getServiceConnectionMap(ServiceConnectionMapName name) {
    GetServiceConnectionMapRequest request =
        GetServiceConnectionMapRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getServiceConnectionMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceConnectionMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   String name =
   *       ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]")
   *           .toString();
   *   ServiceConnectionMap response =
   *       crossNetworkAutomationServiceClient.getServiceConnectionMap(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the ServiceConnectionMap to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceConnectionMap getServiceConnectionMap(String name) {
    GetServiceConnectionMapRequest request =
        GetServiceConnectionMapRequest.newBuilder().setName(name).build();
    return getServiceConnectionMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceConnectionMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   GetServiceConnectionMapRequest request =
   *       GetServiceConnectionMapRequest.newBuilder()
   *           .setName(
   *               ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]")
   *                   .toString())
   *           .build();
   *   ServiceConnectionMap response =
   *       crossNetworkAutomationServiceClient.getServiceConnectionMap(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceConnectionMap getServiceConnectionMap(
      GetServiceConnectionMapRequest request) {
    return getServiceConnectionMapCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceConnectionMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   GetServiceConnectionMapRequest request =
   *       GetServiceConnectionMapRequest.newBuilder()
   *           .setName(
   *               ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ServiceConnectionMap> future =
   *       crossNetworkAutomationServiceClient.getServiceConnectionMapCallable().futureCall(request);
   *   // Do something.
   *   ServiceConnectionMap response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServiceConnectionMapRequest, ServiceConnectionMap>
      getServiceConnectionMapCallable() {
    return stub.getServiceConnectionMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceConnectionMap in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ServiceConnectionMap serviceConnectionMap = ServiceConnectionMap.newBuilder().build();
   *   String serviceConnectionMapId = "serviceConnectionMapId407176164";
   *   ServiceConnectionMap response =
   *       crossNetworkAutomationServiceClient
   *           .createServiceConnectionMapAsync(parent, serviceConnectionMap, serviceConnectionMapId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name of the ServiceConnectionMap. ex.
   *     projects/123/locations/us-east1
   * @param serviceConnectionMap Required. Initial values for a new ServiceConnectionMaps
   * @param serviceConnectionMapId Optional. Resource ID (i.e. 'foo' in
   *     '[...]/projects/p/locations/l/serviceConnectionMaps/foo') See
   *     https://google.aip.dev/122#resource-id-segments Unique per location. If one is not
   *     provided, one will be generated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceConnectionMap, OperationMetadata>
      createServiceConnectionMapAsync(
          LocationName parent,
          ServiceConnectionMap serviceConnectionMap,
          String serviceConnectionMapId) {
    CreateServiceConnectionMapRequest request =
        CreateServiceConnectionMapRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setServiceConnectionMap(serviceConnectionMap)
            .setServiceConnectionMapId(serviceConnectionMapId)
            .build();
    return createServiceConnectionMapAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceConnectionMap in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ServiceConnectionMap serviceConnectionMap = ServiceConnectionMap.newBuilder().build();
   *   String serviceConnectionMapId = "serviceConnectionMapId407176164";
   *   ServiceConnectionMap response =
   *       crossNetworkAutomationServiceClient
   *           .createServiceConnectionMapAsync(parent, serviceConnectionMap, serviceConnectionMapId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name of the ServiceConnectionMap. ex.
   *     projects/123/locations/us-east1
   * @param serviceConnectionMap Required. Initial values for a new ServiceConnectionMaps
   * @param serviceConnectionMapId Optional. Resource ID (i.e. 'foo' in
   *     '[...]/projects/p/locations/l/serviceConnectionMaps/foo') See
   *     https://google.aip.dev/122#resource-id-segments Unique per location. If one is not
   *     provided, one will be generated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceConnectionMap, OperationMetadata>
      createServiceConnectionMapAsync(
          String parent, ServiceConnectionMap serviceConnectionMap, String serviceConnectionMapId) {
    CreateServiceConnectionMapRequest request =
        CreateServiceConnectionMapRequest.newBuilder()
            .setParent(parent)
            .setServiceConnectionMap(serviceConnectionMap)
            .setServiceConnectionMapId(serviceConnectionMapId)
            .build();
    return createServiceConnectionMapAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceConnectionMap in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   CreateServiceConnectionMapRequest request =
   *       CreateServiceConnectionMapRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceConnectionMapId("serviceConnectionMapId407176164")
   *           .setServiceConnectionMap(ServiceConnectionMap.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ServiceConnectionMap response =
   *       crossNetworkAutomationServiceClient.createServiceConnectionMapAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceConnectionMap, OperationMetadata>
      createServiceConnectionMapAsync(CreateServiceConnectionMapRequest request) {
    return createServiceConnectionMapOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceConnectionMap in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   CreateServiceConnectionMapRequest request =
   *       CreateServiceConnectionMapRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceConnectionMapId("serviceConnectionMapId407176164")
   *           .setServiceConnectionMap(ServiceConnectionMap.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ServiceConnectionMap, OperationMetadata> future =
   *       crossNetworkAutomationServiceClient
   *           .createServiceConnectionMapOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ServiceConnectionMap response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
      createServiceConnectionMapOperationCallable() {
    return stub.createServiceConnectionMapOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceConnectionMap in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   CreateServiceConnectionMapRequest request =
   *       CreateServiceConnectionMapRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceConnectionMapId("serviceConnectionMapId407176164")
   *           .setServiceConnectionMap(ServiceConnectionMap.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       crossNetworkAutomationServiceClient
   *           .createServiceConnectionMapCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateServiceConnectionMapRequest, Operation>
      createServiceConnectionMapCallable() {
    return stub.createServiceConnectionMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ServiceConnectionMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ServiceConnectionMap serviceConnectionMap = ServiceConnectionMap.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ServiceConnectionMap response =
   *       crossNetworkAutomationServiceClient
   *           .updateServiceConnectionMapAsync(serviceConnectionMap, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param serviceConnectionMap Required. New values to be patched into the resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     ServiceConnectionMap resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceConnectionMap, OperationMetadata>
      updateServiceConnectionMapAsync(
          ServiceConnectionMap serviceConnectionMap, FieldMask updateMask) {
    UpdateServiceConnectionMapRequest request =
        UpdateServiceConnectionMapRequest.newBuilder()
            .setServiceConnectionMap(serviceConnectionMap)
            .setUpdateMask(updateMask)
            .build();
    return updateServiceConnectionMapAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ServiceConnectionMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   UpdateServiceConnectionMapRequest request =
   *       UpdateServiceConnectionMapRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setServiceConnectionMap(ServiceConnectionMap.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ServiceConnectionMap response =
   *       crossNetworkAutomationServiceClient.updateServiceConnectionMapAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceConnectionMap, OperationMetadata>
      updateServiceConnectionMapAsync(UpdateServiceConnectionMapRequest request) {
    return updateServiceConnectionMapOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ServiceConnectionMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   UpdateServiceConnectionMapRequest request =
   *       UpdateServiceConnectionMapRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setServiceConnectionMap(ServiceConnectionMap.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ServiceConnectionMap, OperationMetadata> future =
   *       crossNetworkAutomationServiceClient
   *           .updateServiceConnectionMapOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ServiceConnectionMap response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
      updateServiceConnectionMapOperationCallable() {
    return stub.updateServiceConnectionMapOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ServiceConnectionMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   UpdateServiceConnectionMapRequest request =
   *       UpdateServiceConnectionMapRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setServiceConnectionMap(ServiceConnectionMap.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       crossNetworkAutomationServiceClient
   *           .updateServiceConnectionMapCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateServiceConnectionMapRequest, Operation>
      updateServiceConnectionMapCallable() {
    return stub.updateServiceConnectionMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceConnectionMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ServiceConnectionMapName name =
   *       ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]");
   *   crossNetworkAutomationServiceClient.deleteServiceConnectionMapAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ServiceConnectionMap to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceConnectionMapAsync(
      ServiceConnectionMapName name) {
    DeleteServiceConnectionMapRequest request =
        DeleteServiceConnectionMapRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteServiceConnectionMapAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceConnectionMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   String name =
   *       ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]")
   *           .toString();
   *   crossNetworkAutomationServiceClient.deleteServiceConnectionMapAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ServiceConnectionMap to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceConnectionMapAsync(
      String name) {
    DeleteServiceConnectionMapRequest request =
        DeleteServiceConnectionMapRequest.newBuilder().setName(name).build();
    return deleteServiceConnectionMapAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceConnectionMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   DeleteServiceConnectionMapRequest request =
   *       DeleteServiceConnectionMapRequest.newBuilder()
   *           .setName(
   *               ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   crossNetworkAutomationServiceClient.deleteServiceConnectionMapAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceConnectionMapAsync(
      DeleteServiceConnectionMapRequest request) {
    return deleteServiceConnectionMapOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceConnectionMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   DeleteServiceConnectionMapRequest request =
   *       DeleteServiceConnectionMapRequest.newBuilder()
   *           .setName(
   *               ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       crossNetworkAutomationServiceClient
   *           .deleteServiceConnectionMapOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteServiceConnectionMapRequest, Empty, OperationMetadata>
      deleteServiceConnectionMapOperationCallable() {
    return stub.deleteServiceConnectionMapOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceConnectionMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   DeleteServiceConnectionMapRequest request =
   *       DeleteServiceConnectionMapRequest.newBuilder()
   *           .setName(
   *               ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       crossNetworkAutomationServiceClient
   *           .deleteServiceConnectionMapCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteServiceConnectionMapRequest, Operation>
      deleteServiceConnectionMapCallable() {
    return stub.deleteServiceConnectionMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceConnectionPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ServiceConnectionPolicy element :
   *       crossNetworkAutomationServiceClient.listServiceConnectionPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name. ex. projects/123/locations/us-east1
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceConnectionPoliciesPagedResponse listServiceConnectionPolicies(
      LocationName parent) {
    ListServiceConnectionPoliciesRequest request =
        ListServiceConnectionPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listServiceConnectionPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceConnectionPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ServiceConnectionPolicy element :
   *       crossNetworkAutomationServiceClient.listServiceConnectionPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name. ex. projects/123/locations/us-east1
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceConnectionPoliciesPagedResponse listServiceConnectionPolicies(
      String parent) {
    ListServiceConnectionPoliciesRequest request =
        ListServiceConnectionPoliciesRequest.newBuilder().setParent(parent).build();
    return listServiceConnectionPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceConnectionPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ListServiceConnectionPoliciesRequest request =
   *       ListServiceConnectionPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ServiceConnectionPolicy element :
   *       crossNetworkAutomationServiceClient.listServiceConnectionPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceConnectionPoliciesPagedResponse listServiceConnectionPolicies(
      ListServiceConnectionPoliciesRequest request) {
    return listServiceConnectionPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceConnectionPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ListServiceConnectionPoliciesRequest request =
   *       ListServiceConnectionPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ServiceConnectionPolicy> future =
   *       crossNetworkAutomationServiceClient
   *           .listServiceConnectionPoliciesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (ServiceConnectionPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListServiceConnectionPoliciesRequest, ListServiceConnectionPoliciesPagedResponse>
      listServiceConnectionPoliciesPagedCallable() {
    return stub.listServiceConnectionPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceConnectionPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ListServiceConnectionPoliciesRequest request =
   *       ListServiceConnectionPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListServiceConnectionPoliciesResponse response =
   *         crossNetworkAutomationServiceClient
   *             .listServiceConnectionPoliciesCallable()
   *             .call(request);
   *     for (ServiceConnectionPolicy element : response.getServiceConnectionPoliciesList()) {
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
          ListServiceConnectionPoliciesRequest, ListServiceConnectionPoliciesResponse>
      listServiceConnectionPoliciesCallable() {
    return stub.listServiceConnectionPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceConnectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ServiceConnectionPolicyName name =
   *       ServiceConnectionPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]");
   *   ServiceConnectionPolicy response =
   *       crossNetworkAutomationServiceClient.getServiceConnectionPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the ServiceConnectionPolicy to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceConnectionPolicy getServiceConnectionPolicy(
      ServiceConnectionPolicyName name) {
    GetServiceConnectionPolicyRequest request =
        GetServiceConnectionPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getServiceConnectionPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceConnectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   String name =
   *       ServiceConnectionPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]")
   *           .toString();
   *   ServiceConnectionPolicy response =
   *       crossNetworkAutomationServiceClient.getServiceConnectionPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the ServiceConnectionPolicy to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceConnectionPolicy getServiceConnectionPolicy(String name) {
    GetServiceConnectionPolicyRequest request =
        GetServiceConnectionPolicyRequest.newBuilder().setName(name).build();
    return getServiceConnectionPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceConnectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   GetServiceConnectionPolicyRequest request =
   *       GetServiceConnectionPolicyRequest.newBuilder()
   *           .setName(
   *               ServiceConnectionPolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]")
   *                   .toString())
   *           .build();
   *   ServiceConnectionPolicy response =
   *       crossNetworkAutomationServiceClient.getServiceConnectionPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceConnectionPolicy getServiceConnectionPolicy(
      GetServiceConnectionPolicyRequest request) {
    return getServiceConnectionPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceConnectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   GetServiceConnectionPolicyRequest request =
   *       GetServiceConnectionPolicyRequest.newBuilder()
   *           .setName(
   *               ServiceConnectionPolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ServiceConnectionPolicy> future =
   *       crossNetworkAutomationServiceClient
   *           .getServiceConnectionPolicyCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ServiceConnectionPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServiceConnectionPolicyRequest, ServiceConnectionPolicy>
      getServiceConnectionPolicyCallable() {
    return stub.getServiceConnectionPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceConnectionPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ServiceConnectionPolicy serviceConnectionPolicy =
   *       ServiceConnectionPolicy.newBuilder().build();
   *   String serviceConnectionPolicyId = "serviceConnectionPolicyId1586196096";
   *   ServiceConnectionPolicy response =
   *       crossNetworkAutomationServiceClient
   *           .createServiceConnectionPolicyAsync(
   *               parent, serviceConnectionPolicy, serviceConnectionPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name of the ServiceConnectionPolicy. ex.
   *     projects/123/locations/us-east1
   * @param serviceConnectionPolicy Required. Initial values for a new ServiceConnectionPolicies
   * @param serviceConnectionPolicyId Optional. Resource ID (i.e. 'foo' in
   *     '[...]/projects/p/locations/l/serviceConnectionPolicies/foo') See
   *     https://google.aip.dev/122#resource-id-segments Unique per location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceConnectionPolicy, OperationMetadata>
      createServiceConnectionPolicyAsync(
          LocationName parent,
          ServiceConnectionPolicy serviceConnectionPolicy,
          String serviceConnectionPolicyId) {
    CreateServiceConnectionPolicyRequest request =
        CreateServiceConnectionPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setServiceConnectionPolicy(serviceConnectionPolicy)
            .setServiceConnectionPolicyId(serviceConnectionPolicyId)
            .build();
    return createServiceConnectionPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceConnectionPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ServiceConnectionPolicy serviceConnectionPolicy =
   *       ServiceConnectionPolicy.newBuilder().build();
   *   String serviceConnectionPolicyId = "serviceConnectionPolicyId1586196096";
   *   ServiceConnectionPolicy response =
   *       crossNetworkAutomationServiceClient
   *           .createServiceConnectionPolicyAsync(
   *               parent, serviceConnectionPolicy, serviceConnectionPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name of the ServiceConnectionPolicy. ex.
   *     projects/123/locations/us-east1
   * @param serviceConnectionPolicy Required. Initial values for a new ServiceConnectionPolicies
   * @param serviceConnectionPolicyId Optional. Resource ID (i.e. 'foo' in
   *     '[...]/projects/p/locations/l/serviceConnectionPolicies/foo') See
   *     https://google.aip.dev/122#resource-id-segments Unique per location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceConnectionPolicy, OperationMetadata>
      createServiceConnectionPolicyAsync(
          String parent,
          ServiceConnectionPolicy serviceConnectionPolicy,
          String serviceConnectionPolicyId) {
    CreateServiceConnectionPolicyRequest request =
        CreateServiceConnectionPolicyRequest.newBuilder()
            .setParent(parent)
            .setServiceConnectionPolicy(serviceConnectionPolicy)
            .setServiceConnectionPolicyId(serviceConnectionPolicyId)
            .build();
    return createServiceConnectionPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceConnectionPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   CreateServiceConnectionPolicyRequest request =
   *       CreateServiceConnectionPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceConnectionPolicyId("serviceConnectionPolicyId1586196096")
   *           .setServiceConnectionPolicy(ServiceConnectionPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ServiceConnectionPolicy response =
   *       crossNetworkAutomationServiceClient.createServiceConnectionPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceConnectionPolicy, OperationMetadata>
      createServiceConnectionPolicyAsync(CreateServiceConnectionPolicyRequest request) {
    return createServiceConnectionPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceConnectionPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   CreateServiceConnectionPolicyRequest request =
   *       CreateServiceConnectionPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceConnectionPolicyId("serviceConnectionPolicyId1586196096")
   *           .setServiceConnectionPolicy(ServiceConnectionPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ServiceConnectionPolicy, OperationMetadata> future =
   *       crossNetworkAutomationServiceClient
   *           .createServiceConnectionPolicyOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ServiceConnectionPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
      createServiceConnectionPolicyOperationCallable() {
    return stub.createServiceConnectionPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceConnectionPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   CreateServiceConnectionPolicyRequest request =
   *       CreateServiceConnectionPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceConnectionPolicyId("serviceConnectionPolicyId1586196096")
   *           .setServiceConnectionPolicy(ServiceConnectionPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       crossNetworkAutomationServiceClient
   *           .createServiceConnectionPolicyCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateServiceConnectionPolicyRequest, Operation>
      createServiceConnectionPolicyCallable() {
    return stub.createServiceConnectionPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ServiceConnectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ServiceConnectionPolicy serviceConnectionPolicy =
   *       ServiceConnectionPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ServiceConnectionPolicy response =
   *       crossNetworkAutomationServiceClient
   *           .updateServiceConnectionPolicyAsync(serviceConnectionPolicy, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param serviceConnectionPolicy Required. New values to be patched into the resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     ServiceConnectionPolicy resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceConnectionPolicy, OperationMetadata>
      updateServiceConnectionPolicyAsync(
          ServiceConnectionPolicy serviceConnectionPolicy, FieldMask updateMask) {
    UpdateServiceConnectionPolicyRequest request =
        UpdateServiceConnectionPolicyRequest.newBuilder()
            .setServiceConnectionPolicy(serviceConnectionPolicy)
            .setUpdateMask(updateMask)
            .build();
    return updateServiceConnectionPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ServiceConnectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   UpdateServiceConnectionPolicyRequest request =
   *       UpdateServiceConnectionPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setServiceConnectionPolicy(ServiceConnectionPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ServiceConnectionPolicy response =
   *       crossNetworkAutomationServiceClient.updateServiceConnectionPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceConnectionPolicy, OperationMetadata>
      updateServiceConnectionPolicyAsync(UpdateServiceConnectionPolicyRequest request) {
    return updateServiceConnectionPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ServiceConnectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   UpdateServiceConnectionPolicyRequest request =
   *       UpdateServiceConnectionPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setServiceConnectionPolicy(ServiceConnectionPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ServiceConnectionPolicy, OperationMetadata> future =
   *       crossNetworkAutomationServiceClient
   *           .updateServiceConnectionPolicyOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ServiceConnectionPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
      updateServiceConnectionPolicyOperationCallable() {
    return stub.updateServiceConnectionPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ServiceConnectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   UpdateServiceConnectionPolicyRequest request =
   *       UpdateServiceConnectionPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setServiceConnectionPolicy(ServiceConnectionPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       crossNetworkAutomationServiceClient
   *           .updateServiceConnectionPolicyCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateServiceConnectionPolicyRequest, Operation>
      updateServiceConnectionPolicyCallable() {
    return stub.updateServiceConnectionPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceConnectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ServiceConnectionPolicyName name =
   *       ServiceConnectionPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]");
   *   crossNetworkAutomationServiceClient.deleteServiceConnectionPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ServiceConnectionPolicy to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceConnectionPolicyAsync(
      ServiceConnectionPolicyName name) {
    DeleteServiceConnectionPolicyRequest request =
        DeleteServiceConnectionPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteServiceConnectionPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceConnectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   String name =
   *       ServiceConnectionPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]")
   *           .toString();
   *   crossNetworkAutomationServiceClient.deleteServiceConnectionPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ServiceConnectionPolicy to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceConnectionPolicyAsync(
      String name) {
    DeleteServiceConnectionPolicyRequest request =
        DeleteServiceConnectionPolicyRequest.newBuilder().setName(name).build();
    return deleteServiceConnectionPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceConnectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   DeleteServiceConnectionPolicyRequest request =
   *       DeleteServiceConnectionPolicyRequest.newBuilder()
   *           .setName(
   *               ServiceConnectionPolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   crossNetworkAutomationServiceClient.deleteServiceConnectionPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceConnectionPolicyAsync(
      DeleteServiceConnectionPolicyRequest request) {
    return deleteServiceConnectionPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceConnectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   DeleteServiceConnectionPolicyRequest request =
   *       DeleteServiceConnectionPolicyRequest.newBuilder()
   *           .setName(
   *               ServiceConnectionPolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       crossNetworkAutomationServiceClient
   *           .deleteServiceConnectionPolicyOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteServiceConnectionPolicyRequest, Empty, OperationMetadata>
      deleteServiceConnectionPolicyOperationCallable() {
    return stub.deleteServiceConnectionPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceConnectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   DeleteServiceConnectionPolicyRequest request =
   *       DeleteServiceConnectionPolicyRequest.newBuilder()
   *           .setName(
   *               ServiceConnectionPolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_POLICY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       crossNetworkAutomationServiceClient
   *           .deleteServiceConnectionPolicyCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteServiceConnectionPolicyRequest, Operation>
      deleteServiceConnectionPolicyCallable() {
    return stub.deleteServiceConnectionPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceClasses in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ServiceClass element :
   *       crossNetworkAutomationServiceClient.listServiceClasses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name. ex. projects/123/locations/us-east1
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceClassesPagedResponse listServiceClasses(LocationName parent) {
    ListServiceClassesRequest request =
        ListServiceClassesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listServiceClasses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceClasses in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ServiceClass element :
   *       crossNetworkAutomationServiceClient.listServiceClasses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name. ex. projects/123/locations/us-east1
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceClassesPagedResponse listServiceClasses(String parent) {
    ListServiceClassesRequest request =
        ListServiceClassesRequest.newBuilder().setParent(parent).build();
    return listServiceClasses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceClasses in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ListServiceClassesRequest request =
   *       ListServiceClassesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ServiceClass element :
   *       crossNetworkAutomationServiceClient.listServiceClasses(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceClassesPagedResponse listServiceClasses(
      ListServiceClassesRequest request) {
    return listServiceClassesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceClasses in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ListServiceClassesRequest request =
   *       ListServiceClassesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ServiceClass> future =
   *       crossNetworkAutomationServiceClient.listServiceClassesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ServiceClass element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListServiceClassesRequest, ListServiceClassesPagedResponse>
      listServiceClassesPagedCallable() {
    return stub.listServiceClassesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceClasses in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ListServiceClassesRequest request =
   *       ListServiceClassesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListServiceClassesResponse response =
   *         crossNetworkAutomationServiceClient.listServiceClassesCallable().call(request);
   *     for (ServiceClass element : response.getServiceClassesList()) {
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
  public final UnaryCallable<ListServiceClassesRequest, ListServiceClassesResponse>
      listServiceClassesCallable() {
    return stub.listServiceClassesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceClass.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ServiceClassName name = ServiceClassName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CLASS]");
   *   ServiceClass response = crossNetworkAutomationServiceClient.getServiceClass(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the ServiceClass to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceClass getServiceClass(ServiceClassName name) {
    GetServiceClassRequest request =
        GetServiceClassRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getServiceClass(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceClass.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   String name = ServiceClassName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CLASS]").toString();
   *   ServiceClass response = crossNetworkAutomationServiceClient.getServiceClass(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the ServiceClass to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceClass getServiceClass(String name) {
    GetServiceClassRequest request = GetServiceClassRequest.newBuilder().setName(name).build();
    return getServiceClass(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceClass.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   GetServiceClassRequest request =
   *       GetServiceClassRequest.newBuilder()
   *           .setName(ServiceClassName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CLASS]").toString())
   *           .build();
   *   ServiceClass response = crossNetworkAutomationServiceClient.getServiceClass(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceClass getServiceClass(GetServiceClassRequest request) {
    return getServiceClassCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceClass.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   GetServiceClassRequest request =
   *       GetServiceClassRequest.newBuilder()
   *           .setName(ServiceClassName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CLASS]").toString())
   *           .build();
   *   ApiFuture<ServiceClass> future =
   *       crossNetworkAutomationServiceClient.getServiceClassCallable().futureCall(request);
   *   // Do something.
   *   ServiceClass response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServiceClassRequest, ServiceClass> getServiceClassCallable() {
    return stub.getServiceClassCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ServiceClass.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ServiceClass serviceClass = ServiceClass.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ServiceClass response =
   *       crossNetworkAutomationServiceClient
   *           .updateServiceClassAsync(serviceClass, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param serviceClass Required. New values to be patched into the resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     ServiceClass resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceClass, OperationMetadata> updateServiceClassAsync(
      ServiceClass serviceClass, FieldMask updateMask) {
    UpdateServiceClassRequest request =
        UpdateServiceClassRequest.newBuilder()
            .setServiceClass(serviceClass)
            .setUpdateMask(updateMask)
            .build();
    return updateServiceClassAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ServiceClass.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   UpdateServiceClassRequest request =
   *       UpdateServiceClassRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setServiceClass(ServiceClass.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ServiceClass response =
   *       crossNetworkAutomationServiceClient.updateServiceClassAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceClass, OperationMetadata> updateServiceClassAsync(
      UpdateServiceClassRequest request) {
    return updateServiceClassOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ServiceClass.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   UpdateServiceClassRequest request =
   *       UpdateServiceClassRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setServiceClass(ServiceClass.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ServiceClass, OperationMetadata> future =
   *       crossNetworkAutomationServiceClient
   *           .updateServiceClassOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ServiceClass response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateServiceClassRequest, ServiceClass, OperationMetadata>
      updateServiceClassOperationCallable() {
    return stub.updateServiceClassOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ServiceClass.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   UpdateServiceClassRequest request =
   *       UpdateServiceClassRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setServiceClass(ServiceClass.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       crossNetworkAutomationServiceClient.updateServiceClassCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateServiceClassRequest, Operation> updateServiceClassCallable() {
    return stub.updateServiceClassCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceClass.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ServiceClassName name = ServiceClassName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CLASS]");
   *   crossNetworkAutomationServiceClient.deleteServiceClassAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ServiceClass to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceClassAsync(
      ServiceClassName name) {
    DeleteServiceClassRequest request =
        DeleteServiceClassRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteServiceClassAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceClass.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   String name = ServiceClassName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CLASS]").toString();
   *   crossNetworkAutomationServiceClient.deleteServiceClassAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ServiceClass to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceClassAsync(String name) {
    DeleteServiceClassRequest request =
        DeleteServiceClassRequest.newBuilder().setName(name).build();
    return deleteServiceClassAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceClass.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   DeleteServiceClassRequest request =
   *       DeleteServiceClassRequest.newBuilder()
   *           .setName(ServiceClassName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CLASS]").toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   crossNetworkAutomationServiceClient.deleteServiceClassAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceClassAsync(
      DeleteServiceClassRequest request) {
    return deleteServiceClassOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceClass.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   DeleteServiceClassRequest request =
   *       DeleteServiceClassRequest.newBuilder()
   *           .setName(ServiceClassName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CLASS]").toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       crossNetworkAutomationServiceClient
   *           .deleteServiceClassOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteServiceClassRequest, Empty, OperationMetadata>
      deleteServiceClassOperationCallable() {
    return stub.deleteServiceClassOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceClass.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   DeleteServiceClassRequest request =
   *       DeleteServiceClassRequest.newBuilder()
   *           .setName(ServiceClassName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CLASS]").toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       crossNetworkAutomationServiceClient.deleteServiceClassCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteServiceClassRequest, Operation> deleteServiceClassCallable() {
    return stub.deleteServiceClassCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceConnectionToken.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ServiceConnectionTokenName name =
   *       ServiceConnectionTokenName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_TOKEN]");
   *   ServiceConnectionToken response =
   *       crossNetworkAutomationServiceClient.getServiceConnectionToken(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the ServiceConnectionToken to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceConnectionToken getServiceConnectionToken(ServiceConnectionTokenName name) {
    GetServiceConnectionTokenRequest request =
        GetServiceConnectionTokenRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getServiceConnectionToken(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceConnectionToken.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   String name =
   *       ServiceConnectionTokenName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_TOKEN]")
   *           .toString();
   *   ServiceConnectionToken response =
   *       crossNetworkAutomationServiceClient.getServiceConnectionToken(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the ServiceConnectionToken to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceConnectionToken getServiceConnectionToken(String name) {
    GetServiceConnectionTokenRequest request =
        GetServiceConnectionTokenRequest.newBuilder().setName(name).build();
    return getServiceConnectionToken(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceConnectionToken.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   GetServiceConnectionTokenRequest request =
   *       GetServiceConnectionTokenRequest.newBuilder()
   *           .setName(
   *               ServiceConnectionTokenName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_TOKEN]")
   *                   .toString())
   *           .build();
   *   ServiceConnectionToken response =
   *       crossNetworkAutomationServiceClient.getServiceConnectionToken(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceConnectionToken getServiceConnectionToken(
      GetServiceConnectionTokenRequest request) {
    return getServiceConnectionTokenCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceConnectionToken.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   GetServiceConnectionTokenRequest request =
   *       GetServiceConnectionTokenRequest.newBuilder()
   *           .setName(
   *               ServiceConnectionTokenName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_TOKEN]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ServiceConnectionToken> future =
   *       crossNetworkAutomationServiceClient
   *           .getServiceConnectionTokenCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ServiceConnectionToken response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServiceConnectionTokenRequest, ServiceConnectionToken>
      getServiceConnectionTokenCallable() {
    return stub.getServiceConnectionTokenCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceConnectionTokens in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ServiceConnectionToken element :
   *       crossNetworkAutomationServiceClient.listServiceConnectionTokens(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name. ex. projects/123/locations/us-east1
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceConnectionTokensPagedResponse listServiceConnectionTokens(
      LocationName parent) {
    ListServiceConnectionTokensRequest request =
        ListServiceConnectionTokensRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listServiceConnectionTokens(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceConnectionTokens in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ServiceConnectionToken element :
   *       crossNetworkAutomationServiceClient.listServiceConnectionTokens(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name. ex. projects/123/locations/us-east1
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceConnectionTokensPagedResponse listServiceConnectionTokens(String parent) {
    ListServiceConnectionTokensRequest request =
        ListServiceConnectionTokensRequest.newBuilder().setParent(parent).build();
    return listServiceConnectionTokens(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceConnectionTokens in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ListServiceConnectionTokensRequest request =
   *       ListServiceConnectionTokensRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ServiceConnectionToken element :
   *       crossNetworkAutomationServiceClient.listServiceConnectionTokens(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceConnectionTokensPagedResponse listServiceConnectionTokens(
      ListServiceConnectionTokensRequest request) {
    return listServiceConnectionTokensPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceConnectionTokens in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ListServiceConnectionTokensRequest request =
   *       ListServiceConnectionTokensRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ServiceConnectionToken> future =
   *       crossNetworkAutomationServiceClient
   *           .listServiceConnectionTokensPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (ServiceConnectionToken element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListServiceConnectionTokensRequest, ListServiceConnectionTokensPagedResponse>
      listServiceConnectionTokensPagedCallable() {
    return stub.listServiceConnectionTokensPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceConnectionTokens in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ListServiceConnectionTokensRequest request =
   *       ListServiceConnectionTokensRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListServiceConnectionTokensResponse response =
   *         crossNetworkAutomationServiceClient.listServiceConnectionTokensCallable().call(request);
   *     for (ServiceConnectionToken element : response.getServiceConnectionTokensList()) {
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
          ListServiceConnectionTokensRequest, ListServiceConnectionTokensResponse>
      listServiceConnectionTokensCallable() {
    return stub.listServiceConnectionTokensCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceConnectionToken in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ServiceConnectionToken serviceConnectionToken = ServiceConnectionToken.newBuilder().build();
   *   String serviceConnectionTokenId = "serviceConnectionTokenId-1526102527";
   *   ServiceConnectionToken response =
   *       crossNetworkAutomationServiceClient
   *           .createServiceConnectionTokenAsync(
   *               parent, serviceConnectionToken, serviceConnectionTokenId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name of the ServiceConnectionToken. ex.
   *     projects/123/locations/us-east1
   * @param serviceConnectionToken Required. Initial values for a new ServiceConnectionTokens
   * @param serviceConnectionTokenId Optional. Resource ID (i.e. 'foo' in
   *     '[...]/projects/p/locations/l/ServiceConnectionTokens/foo') See
   *     https://google.aip.dev/122#resource-id-segments Unique per location. If one is not
   *     provided, one will be generated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceConnectionToken, OperationMetadata>
      createServiceConnectionTokenAsync(
          LocationName parent,
          ServiceConnectionToken serviceConnectionToken,
          String serviceConnectionTokenId) {
    CreateServiceConnectionTokenRequest request =
        CreateServiceConnectionTokenRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setServiceConnectionToken(serviceConnectionToken)
            .setServiceConnectionTokenId(serviceConnectionTokenId)
            .build();
    return createServiceConnectionTokenAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceConnectionToken in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ServiceConnectionToken serviceConnectionToken = ServiceConnectionToken.newBuilder().build();
   *   String serviceConnectionTokenId = "serviceConnectionTokenId-1526102527";
   *   ServiceConnectionToken response =
   *       crossNetworkAutomationServiceClient
   *           .createServiceConnectionTokenAsync(
   *               parent, serviceConnectionToken, serviceConnectionTokenId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource's name of the ServiceConnectionToken. ex.
   *     projects/123/locations/us-east1
   * @param serviceConnectionToken Required. Initial values for a new ServiceConnectionTokens
   * @param serviceConnectionTokenId Optional. Resource ID (i.e. 'foo' in
   *     '[...]/projects/p/locations/l/ServiceConnectionTokens/foo') See
   *     https://google.aip.dev/122#resource-id-segments Unique per location. If one is not
   *     provided, one will be generated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceConnectionToken, OperationMetadata>
      createServiceConnectionTokenAsync(
          String parent,
          ServiceConnectionToken serviceConnectionToken,
          String serviceConnectionTokenId) {
    CreateServiceConnectionTokenRequest request =
        CreateServiceConnectionTokenRequest.newBuilder()
            .setParent(parent)
            .setServiceConnectionToken(serviceConnectionToken)
            .setServiceConnectionTokenId(serviceConnectionTokenId)
            .build();
    return createServiceConnectionTokenAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceConnectionToken in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   CreateServiceConnectionTokenRequest request =
   *       CreateServiceConnectionTokenRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceConnectionTokenId("serviceConnectionTokenId-1526102527")
   *           .setServiceConnectionToken(ServiceConnectionToken.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ServiceConnectionToken response =
   *       crossNetworkAutomationServiceClient.createServiceConnectionTokenAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceConnectionToken, OperationMetadata>
      createServiceConnectionTokenAsync(CreateServiceConnectionTokenRequest request) {
    return createServiceConnectionTokenOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceConnectionToken in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   CreateServiceConnectionTokenRequest request =
   *       CreateServiceConnectionTokenRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceConnectionTokenId("serviceConnectionTokenId-1526102527")
   *           .setServiceConnectionToken(ServiceConnectionToken.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ServiceConnectionToken, OperationMetadata> future =
   *       crossNetworkAutomationServiceClient
   *           .createServiceConnectionTokenOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ServiceConnectionToken response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateServiceConnectionTokenRequest, ServiceConnectionToken, OperationMetadata>
      createServiceConnectionTokenOperationCallable() {
    return stub.createServiceConnectionTokenOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceConnectionToken in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   CreateServiceConnectionTokenRequest request =
   *       CreateServiceConnectionTokenRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceConnectionTokenId("serviceConnectionTokenId-1526102527")
   *           .setServiceConnectionToken(ServiceConnectionToken.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       crossNetworkAutomationServiceClient
   *           .createServiceConnectionTokenCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateServiceConnectionTokenRequest, Operation>
      createServiceConnectionTokenCallable() {
    return stub.createServiceConnectionTokenCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceConnectionToken.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ServiceConnectionTokenName name =
   *       ServiceConnectionTokenName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_TOKEN]");
   *   crossNetworkAutomationServiceClient.deleteServiceConnectionTokenAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ServiceConnectionToken to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceConnectionTokenAsync(
      ServiceConnectionTokenName name) {
    DeleteServiceConnectionTokenRequest request =
        DeleteServiceConnectionTokenRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteServiceConnectionTokenAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceConnectionToken.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   String name =
   *       ServiceConnectionTokenName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_TOKEN]")
   *           .toString();
   *   crossNetworkAutomationServiceClient.deleteServiceConnectionTokenAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ServiceConnectionToken to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceConnectionTokenAsync(
      String name) {
    DeleteServiceConnectionTokenRequest request =
        DeleteServiceConnectionTokenRequest.newBuilder().setName(name).build();
    return deleteServiceConnectionTokenAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceConnectionToken.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   DeleteServiceConnectionTokenRequest request =
   *       DeleteServiceConnectionTokenRequest.newBuilder()
   *           .setName(
   *               ServiceConnectionTokenName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_TOKEN]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   crossNetworkAutomationServiceClient.deleteServiceConnectionTokenAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceConnectionTokenAsync(
      DeleteServiceConnectionTokenRequest request) {
    return deleteServiceConnectionTokenOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceConnectionToken.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   DeleteServiceConnectionTokenRequest request =
   *       DeleteServiceConnectionTokenRequest.newBuilder()
   *           .setName(
   *               ServiceConnectionTokenName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_TOKEN]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       crossNetworkAutomationServiceClient
   *           .deleteServiceConnectionTokenOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteServiceConnectionTokenRequest, Empty, OperationMetadata>
      deleteServiceConnectionTokenOperationCallable() {
    return stub.deleteServiceConnectionTokenOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceConnectionToken.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   DeleteServiceConnectionTokenRequest request =
   *       DeleteServiceConnectionTokenRequest.newBuilder()
   *           .setName(
   *               ServiceConnectionTokenName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_TOKEN]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       crossNetworkAutomationServiceClient
   *           .deleteServiceConnectionTokenCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteServiceConnectionTokenRequest, Operation>
      deleteServiceConnectionTokenCallable() {
    return stub.deleteServiceConnectionTokenCallable();
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
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element :
   *       crossNetworkAutomationServiceClient.listLocations(request).iterateAll()) {
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
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       crossNetworkAutomationServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         crossNetworkAutomationServiceClient.listLocationsCallable().call(request);
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
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = crossNetworkAutomationServiceClient.getLocation(request);
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
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       crossNetworkAutomationServiceClient.getLocationCallable().futureCall(request);
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
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = crossNetworkAutomationServiceClient.setIamPolicy(request);
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
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       crossNetworkAutomationServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = crossNetworkAutomationServiceClient.getIamPolicy(request);
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
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       crossNetworkAutomationServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       crossNetworkAutomationServiceClient.testIamPermissions(request);
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
   * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
   *     CrossNetworkAutomationServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(GroupName.of("[PROJECT]", "[HUB]", "[GROUP]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       crossNetworkAutomationServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListServiceConnectionMapsPagedResponse
      extends AbstractPagedListResponse<
          ListServiceConnectionMapsRequest,
          ListServiceConnectionMapsResponse,
          ServiceConnectionMap,
          ListServiceConnectionMapsPage,
          ListServiceConnectionMapsFixedSizeCollection> {

    public static ApiFuture<ListServiceConnectionMapsPagedResponse> createAsync(
        PageContext<
                ListServiceConnectionMapsRequest,
                ListServiceConnectionMapsResponse,
                ServiceConnectionMap>
            context,
        ApiFuture<ListServiceConnectionMapsResponse> futureResponse) {
      ApiFuture<ListServiceConnectionMapsPage> futurePage =
          ListServiceConnectionMapsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListServiceConnectionMapsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListServiceConnectionMapsPagedResponse(ListServiceConnectionMapsPage page) {
      super(page, ListServiceConnectionMapsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListServiceConnectionMapsPage
      extends AbstractPage<
          ListServiceConnectionMapsRequest,
          ListServiceConnectionMapsResponse,
          ServiceConnectionMap,
          ListServiceConnectionMapsPage> {

    private ListServiceConnectionMapsPage(
        PageContext<
                ListServiceConnectionMapsRequest,
                ListServiceConnectionMapsResponse,
                ServiceConnectionMap>
            context,
        ListServiceConnectionMapsResponse response) {
      super(context, response);
    }

    private static ListServiceConnectionMapsPage createEmptyPage() {
      return new ListServiceConnectionMapsPage(null, null);
    }

    @Override
    protected ListServiceConnectionMapsPage createPage(
        PageContext<
                ListServiceConnectionMapsRequest,
                ListServiceConnectionMapsResponse,
                ServiceConnectionMap>
            context,
        ListServiceConnectionMapsResponse response) {
      return new ListServiceConnectionMapsPage(context, response);
    }

    @Override
    public ApiFuture<ListServiceConnectionMapsPage> createPageAsync(
        PageContext<
                ListServiceConnectionMapsRequest,
                ListServiceConnectionMapsResponse,
                ServiceConnectionMap>
            context,
        ApiFuture<ListServiceConnectionMapsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListServiceConnectionMapsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListServiceConnectionMapsRequest,
          ListServiceConnectionMapsResponse,
          ServiceConnectionMap,
          ListServiceConnectionMapsPage,
          ListServiceConnectionMapsFixedSizeCollection> {

    private ListServiceConnectionMapsFixedSizeCollection(
        List<ListServiceConnectionMapsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListServiceConnectionMapsFixedSizeCollection createEmptyCollection() {
      return new ListServiceConnectionMapsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListServiceConnectionMapsFixedSizeCollection createCollection(
        List<ListServiceConnectionMapsPage> pages, int collectionSize) {
      return new ListServiceConnectionMapsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListServiceConnectionPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListServiceConnectionPoliciesRequest,
          ListServiceConnectionPoliciesResponse,
          ServiceConnectionPolicy,
          ListServiceConnectionPoliciesPage,
          ListServiceConnectionPoliciesFixedSizeCollection> {

    public static ApiFuture<ListServiceConnectionPoliciesPagedResponse> createAsync(
        PageContext<
                ListServiceConnectionPoliciesRequest,
                ListServiceConnectionPoliciesResponse,
                ServiceConnectionPolicy>
            context,
        ApiFuture<ListServiceConnectionPoliciesResponse> futureResponse) {
      ApiFuture<ListServiceConnectionPoliciesPage> futurePage =
          ListServiceConnectionPoliciesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListServiceConnectionPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListServiceConnectionPoliciesPagedResponse(ListServiceConnectionPoliciesPage page) {
      super(page, ListServiceConnectionPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListServiceConnectionPoliciesPage
      extends AbstractPage<
          ListServiceConnectionPoliciesRequest,
          ListServiceConnectionPoliciesResponse,
          ServiceConnectionPolicy,
          ListServiceConnectionPoliciesPage> {

    private ListServiceConnectionPoliciesPage(
        PageContext<
                ListServiceConnectionPoliciesRequest,
                ListServiceConnectionPoliciesResponse,
                ServiceConnectionPolicy>
            context,
        ListServiceConnectionPoliciesResponse response) {
      super(context, response);
    }

    private static ListServiceConnectionPoliciesPage createEmptyPage() {
      return new ListServiceConnectionPoliciesPage(null, null);
    }

    @Override
    protected ListServiceConnectionPoliciesPage createPage(
        PageContext<
                ListServiceConnectionPoliciesRequest,
                ListServiceConnectionPoliciesResponse,
                ServiceConnectionPolicy>
            context,
        ListServiceConnectionPoliciesResponse response) {
      return new ListServiceConnectionPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListServiceConnectionPoliciesPage> createPageAsync(
        PageContext<
                ListServiceConnectionPoliciesRequest,
                ListServiceConnectionPoliciesResponse,
                ServiceConnectionPolicy>
            context,
        ApiFuture<ListServiceConnectionPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListServiceConnectionPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListServiceConnectionPoliciesRequest,
          ListServiceConnectionPoliciesResponse,
          ServiceConnectionPolicy,
          ListServiceConnectionPoliciesPage,
          ListServiceConnectionPoliciesFixedSizeCollection> {

    private ListServiceConnectionPoliciesFixedSizeCollection(
        List<ListServiceConnectionPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListServiceConnectionPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListServiceConnectionPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListServiceConnectionPoliciesFixedSizeCollection createCollection(
        List<ListServiceConnectionPoliciesPage> pages, int collectionSize) {
      return new ListServiceConnectionPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListServiceClassesPagedResponse
      extends AbstractPagedListResponse<
          ListServiceClassesRequest,
          ListServiceClassesResponse,
          ServiceClass,
          ListServiceClassesPage,
          ListServiceClassesFixedSizeCollection> {

    public static ApiFuture<ListServiceClassesPagedResponse> createAsync(
        PageContext<ListServiceClassesRequest, ListServiceClassesResponse, ServiceClass> context,
        ApiFuture<ListServiceClassesResponse> futureResponse) {
      ApiFuture<ListServiceClassesPage> futurePage =
          ListServiceClassesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListServiceClassesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListServiceClassesPagedResponse(ListServiceClassesPage page) {
      super(page, ListServiceClassesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListServiceClassesPage
      extends AbstractPage<
          ListServiceClassesRequest,
          ListServiceClassesResponse,
          ServiceClass,
          ListServiceClassesPage> {

    private ListServiceClassesPage(
        PageContext<ListServiceClassesRequest, ListServiceClassesResponse, ServiceClass> context,
        ListServiceClassesResponse response) {
      super(context, response);
    }

    private static ListServiceClassesPage createEmptyPage() {
      return new ListServiceClassesPage(null, null);
    }

    @Override
    protected ListServiceClassesPage createPage(
        PageContext<ListServiceClassesRequest, ListServiceClassesResponse, ServiceClass> context,
        ListServiceClassesResponse response) {
      return new ListServiceClassesPage(context, response);
    }

    @Override
    public ApiFuture<ListServiceClassesPage> createPageAsync(
        PageContext<ListServiceClassesRequest, ListServiceClassesResponse, ServiceClass> context,
        ApiFuture<ListServiceClassesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListServiceClassesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListServiceClassesRequest,
          ListServiceClassesResponse,
          ServiceClass,
          ListServiceClassesPage,
          ListServiceClassesFixedSizeCollection> {

    private ListServiceClassesFixedSizeCollection(
        List<ListServiceClassesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListServiceClassesFixedSizeCollection createEmptyCollection() {
      return new ListServiceClassesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListServiceClassesFixedSizeCollection createCollection(
        List<ListServiceClassesPage> pages, int collectionSize) {
      return new ListServiceClassesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListServiceConnectionTokensPagedResponse
      extends AbstractPagedListResponse<
          ListServiceConnectionTokensRequest,
          ListServiceConnectionTokensResponse,
          ServiceConnectionToken,
          ListServiceConnectionTokensPage,
          ListServiceConnectionTokensFixedSizeCollection> {

    public static ApiFuture<ListServiceConnectionTokensPagedResponse> createAsync(
        PageContext<
                ListServiceConnectionTokensRequest,
                ListServiceConnectionTokensResponse,
                ServiceConnectionToken>
            context,
        ApiFuture<ListServiceConnectionTokensResponse> futureResponse) {
      ApiFuture<ListServiceConnectionTokensPage> futurePage =
          ListServiceConnectionTokensPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListServiceConnectionTokensPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListServiceConnectionTokensPagedResponse(ListServiceConnectionTokensPage page) {
      super(page, ListServiceConnectionTokensFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListServiceConnectionTokensPage
      extends AbstractPage<
          ListServiceConnectionTokensRequest,
          ListServiceConnectionTokensResponse,
          ServiceConnectionToken,
          ListServiceConnectionTokensPage> {

    private ListServiceConnectionTokensPage(
        PageContext<
                ListServiceConnectionTokensRequest,
                ListServiceConnectionTokensResponse,
                ServiceConnectionToken>
            context,
        ListServiceConnectionTokensResponse response) {
      super(context, response);
    }

    private static ListServiceConnectionTokensPage createEmptyPage() {
      return new ListServiceConnectionTokensPage(null, null);
    }

    @Override
    protected ListServiceConnectionTokensPage createPage(
        PageContext<
                ListServiceConnectionTokensRequest,
                ListServiceConnectionTokensResponse,
                ServiceConnectionToken>
            context,
        ListServiceConnectionTokensResponse response) {
      return new ListServiceConnectionTokensPage(context, response);
    }

    @Override
    public ApiFuture<ListServiceConnectionTokensPage> createPageAsync(
        PageContext<
                ListServiceConnectionTokensRequest,
                ListServiceConnectionTokensResponse,
                ServiceConnectionToken>
            context,
        ApiFuture<ListServiceConnectionTokensResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListServiceConnectionTokensFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListServiceConnectionTokensRequest,
          ListServiceConnectionTokensResponse,
          ServiceConnectionToken,
          ListServiceConnectionTokensPage,
          ListServiceConnectionTokensFixedSizeCollection> {

    private ListServiceConnectionTokensFixedSizeCollection(
        List<ListServiceConnectionTokensPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListServiceConnectionTokensFixedSizeCollection createEmptyCollection() {
      return new ListServiceConnectionTokensFixedSizeCollection(null, 0);
    }

    @Override
    protected ListServiceConnectionTokensFixedSizeCollection createCollection(
        List<ListServiceConnectionTokensPage> pages, int collectionSize) {
      return new ListServiceConnectionTokensFixedSizeCollection(pages, collectionSize);
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
