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
import com.google.cloud.networksecurity.v1.stub.NetworkSecurityStub;
import com.google.cloud.networksecurity.v1.stub.NetworkSecurityStubSettings;
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
 * Service Description: Network Security API provides resources to configure authentication and
 * authorization policies. Refer to per API resource documentation for more information.
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
 * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
 *   AuthorizationPolicyName name =
 *       AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]");
 *   AuthorizationPolicy response = networkSecurityClient.getAuthorizationPolicy(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the NetworkSecurityClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListAuthorizationPolicies</td>
 *      <td><p> Lists AuthorizationPolicies in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAuthorizationPolicies(ListAuthorizationPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAuthorizationPolicies(LocationName parent)
 *           <li><p> listAuthorizationPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAuthorizationPoliciesPagedCallable()
 *           <li><p> listAuthorizationPoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAuthorizationPolicy</td>
 *      <td><p> Gets details of a single AuthorizationPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAuthorizationPolicy(GetAuthorizationPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAuthorizationPolicy(AuthorizationPolicyName name)
 *           <li><p> getAuthorizationPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAuthorizationPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAuthorizationPolicy</td>
 *      <td><p> Creates a new AuthorizationPolicy in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAuthorizationPolicyAsync(CreateAuthorizationPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createAuthorizationPolicyAsync(LocationName parent, AuthorizationPolicy authorizationPolicy, String authorizationPolicyId)
 *           <li><p> createAuthorizationPolicyAsync(String parent, AuthorizationPolicy authorizationPolicy, String authorizationPolicyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAuthorizationPolicyOperationCallable()
 *           <li><p> createAuthorizationPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAuthorizationPolicy</td>
 *      <td><p> Updates the parameters of a single AuthorizationPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAuthorizationPolicyAsync(UpdateAuthorizationPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateAuthorizationPolicyAsync(AuthorizationPolicy authorizationPolicy, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAuthorizationPolicyOperationCallable()
 *           <li><p> updateAuthorizationPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAuthorizationPolicy</td>
 *      <td><p> Deletes a single AuthorizationPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAuthorizationPolicyAsync(DeleteAuthorizationPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAuthorizationPolicyAsync(AuthorizationPolicyName name)
 *           <li><p> deleteAuthorizationPolicyAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAuthorizationPolicyOperationCallable()
 *           <li><p> deleteAuthorizationPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBackendAuthenticationConfigs</td>
 *      <td><p> Lists BackendAuthenticationConfigs in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackendAuthenticationConfigs(ListBackendAuthenticationConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackendAuthenticationConfigs(LocationName parent)
 *           <li><p> listBackendAuthenticationConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBackendAuthenticationConfigsPagedCallable()
 *           <li><p> listBackendAuthenticationConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBackendAuthenticationConfig</td>
 *      <td><p> Gets details of a single BackendAuthenticationConfig to BackendAuthenticationConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBackendAuthenticationConfig(GetBackendAuthenticationConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBackendAuthenticationConfig(BackendAuthenticationConfigName name)
 *           <li><p> getBackendAuthenticationConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBackendAuthenticationConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBackendAuthenticationConfig</td>
 *      <td><p> Creates a new BackendAuthenticationConfig in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBackendAuthenticationConfigAsync(CreateBackendAuthenticationConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createBackendAuthenticationConfigAsync(LocationName parent, BackendAuthenticationConfig backendAuthenticationConfig, String backendAuthenticationConfigId)
 *           <li><p> createBackendAuthenticationConfigAsync(String parent, BackendAuthenticationConfig backendAuthenticationConfig, String backendAuthenticationConfigId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBackendAuthenticationConfigOperationCallable()
 *           <li><p> createBackendAuthenticationConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBackendAuthenticationConfig</td>
 *      <td><p> Updates the parameters of a single BackendAuthenticationConfig to BackendAuthenticationConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBackendAuthenticationConfigAsync(UpdateBackendAuthenticationConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateBackendAuthenticationConfigAsync(BackendAuthenticationConfig backendAuthenticationConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBackendAuthenticationConfigOperationCallable()
 *           <li><p> updateBackendAuthenticationConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBackendAuthenticationConfig</td>
 *      <td><p> Deletes a single BackendAuthenticationConfig to BackendAuthenticationConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBackendAuthenticationConfigAsync(DeleteBackendAuthenticationConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteBackendAuthenticationConfigAsync(BackendAuthenticationConfigName name)
 *           <li><p> deleteBackendAuthenticationConfigAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBackendAuthenticationConfigOperationCallable()
 *           <li><p> deleteBackendAuthenticationConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListServerTlsPolicies</td>
 *      <td><p> Lists ServerTlsPolicies in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listServerTlsPolicies(ListServerTlsPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listServerTlsPolicies(LocationName parent)
 *           <li><p> listServerTlsPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listServerTlsPoliciesPagedCallable()
 *           <li><p> listServerTlsPoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetServerTlsPolicy</td>
 *      <td><p> Gets details of a single ServerTlsPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getServerTlsPolicy(GetServerTlsPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getServerTlsPolicy(ServerTlsPolicyName name)
 *           <li><p> getServerTlsPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getServerTlsPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateServerTlsPolicy</td>
 *      <td><p> Creates a new ServerTlsPolicy in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createServerTlsPolicyAsync(CreateServerTlsPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createServerTlsPolicyAsync(LocationName parent, ServerTlsPolicy serverTlsPolicy, String serverTlsPolicyId)
 *           <li><p> createServerTlsPolicyAsync(String parent, ServerTlsPolicy serverTlsPolicy, String serverTlsPolicyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createServerTlsPolicyOperationCallable()
 *           <li><p> createServerTlsPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateServerTlsPolicy</td>
 *      <td><p> Updates the parameters of a single ServerTlsPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateServerTlsPolicyAsync(UpdateServerTlsPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateServerTlsPolicyAsync(ServerTlsPolicy serverTlsPolicy, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateServerTlsPolicyOperationCallable()
 *           <li><p> updateServerTlsPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteServerTlsPolicy</td>
 *      <td><p> Deletes a single ServerTlsPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteServerTlsPolicyAsync(DeleteServerTlsPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteServerTlsPolicyAsync(ServerTlsPolicyName name)
 *           <li><p> deleteServerTlsPolicyAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteServerTlsPolicyOperationCallable()
 *           <li><p> deleteServerTlsPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListClientTlsPolicies</td>
 *      <td><p> Lists ClientTlsPolicies in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listClientTlsPolicies(ListClientTlsPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listClientTlsPolicies(LocationName parent)
 *           <li><p> listClientTlsPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listClientTlsPoliciesPagedCallable()
 *           <li><p> listClientTlsPoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetClientTlsPolicy</td>
 *      <td><p> Gets details of a single ClientTlsPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getClientTlsPolicy(GetClientTlsPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getClientTlsPolicy(ClientTlsPolicyName name)
 *           <li><p> getClientTlsPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getClientTlsPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateClientTlsPolicy</td>
 *      <td><p> Creates a new ClientTlsPolicy in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createClientTlsPolicyAsync(CreateClientTlsPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createClientTlsPolicyAsync(LocationName parent, ClientTlsPolicy clientTlsPolicy, String clientTlsPolicyId)
 *           <li><p> createClientTlsPolicyAsync(String parent, ClientTlsPolicy clientTlsPolicy, String clientTlsPolicyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createClientTlsPolicyOperationCallable()
 *           <li><p> createClientTlsPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateClientTlsPolicy</td>
 *      <td><p> Updates the parameters of a single ClientTlsPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateClientTlsPolicyAsync(UpdateClientTlsPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateClientTlsPolicyAsync(ClientTlsPolicy clientTlsPolicy, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateClientTlsPolicyOperationCallable()
 *           <li><p> updateClientTlsPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteClientTlsPolicy</td>
 *      <td><p> Deletes a single ClientTlsPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteClientTlsPolicyAsync(DeleteClientTlsPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteClientTlsPolicyAsync(ClientTlsPolicyName name)
 *           <li><p> deleteClientTlsPolicyAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteClientTlsPolicyOperationCallable()
 *           <li><p> deleteClientTlsPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGatewaySecurityPolicies</td>
 *      <td><p> Lists GatewaySecurityPolicies in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGatewaySecurityPolicies(ListGatewaySecurityPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGatewaySecurityPolicies(LocationName parent)
 *           <li><p> listGatewaySecurityPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGatewaySecurityPoliciesPagedCallable()
 *           <li><p> listGatewaySecurityPoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGatewaySecurityPolicy</td>
 *      <td><p> Gets details of a single GatewaySecurityPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGatewaySecurityPolicy(GetGatewaySecurityPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGatewaySecurityPolicy(GatewaySecurityPolicyName name)
 *           <li><p> getGatewaySecurityPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGatewaySecurityPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateGatewaySecurityPolicy</td>
 *      <td><p> Creates a new GatewaySecurityPolicy in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createGatewaySecurityPolicyAsync(CreateGatewaySecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createGatewaySecurityPolicyAsync(LocationName parent, GatewaySecurityPolicy gatewaySecurityPolicy, String gatewaySecurityPolicyId)
 *           <li><p> createGatewaySecurityPolicyAsync(String parent, GatewaySecurityPolicy gatewaySecurityPolicy, String gatewaySecurityPolicyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createGatewaySecurityPolicyOperationCallable()
 *           <li><p> createGatewaySecurityPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateGatewaySecurityPolicy</td>
 *      <td><p> Updates the parameters of a single GatewaySecurityPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateGatewaySecurityPolicyAsync(UpdateGatewaySecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateGatewaySecurityPolicyAsync(GatewaySecurityPolicy gatewaySecurityPolicy, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateGatewaySecurityPolicyOperationCallable()
 *           <li><p> updateGatewaySecurityPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteGatewaySecurityPolicy</td>
 *      <td><p> Deletes a single GatewaySecurityPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteGatewaySecurityPolicyAsync(DeleteGatewaySecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteGatewaySecurityPolicyAsync(GatewaySecurityPolicyName name)
 *           <li><p> deleteGatewaySecurityPolicyAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteGatewaySecurityPolicyOperationCallable()
 *           <li><p> deleteGatewaySecurityPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGatewaySecurityPolicyRules</td>
 *      <td><p> Lists GatewaySecurityPolicyRules in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGatewaySecurityPolicyRules(ListGatewaySecurityPolicyRulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGatewaySecurityPolicyRules(GatewaySecurityPolicyName parent)
 *           <li><p> listGatewaySecurityPolicyRules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGatewaySecurityPolicyRulesPagedCallable()
 *           <li><p> listGatewaySecurityPolicyRulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGatewaySecurityPolicyRule</td>
 *      <td><p> Gets details of a single GatewaySecurityPolicyRule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGatewaySecurityPolicyRule(GetGatewaySecurityPolicyRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGatewaySecurityPolicyRule(GatewaySecurityPolicyRuleName name)
 *           <li><p> getGatewaySecurityPolicyRule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGatewaySecurityPolicyRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateGatewaySecurityPolicyRule</td>
 *      <td><p> Creates a new GatewaySecurityPolicy in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createGatewaySecurityPolicyRuleAsync(CreateGatewaySecurityPolicyRuleRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createGatewaySecurityPolicyRuleAsync(GatewaySecurityPolicyName parent, GatewaySecurityPolicyRule gatewaySecurityPolicyRule, String gatewaySecurityPolicyRuleId)
 *           <li><p> createGatewaySecurityPolicyRuleAsync(String parent, GatewaySecurityPolicyRule gatewaySecurityPolicyRule, String gatewaySecurityPolicyRuleId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createGatewaySecurityPolicyRuleOperationCallable()
 *           <li><p> createGatewaySecurityPolicyRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateGatewaySecurityPolicyRule</td>
 *      <td><p> Updates the parameters of a single GatewaySecurityPolicyRule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateGatewaySecurityPolicyRuleAsync(UpdateGatewaySecurityPolicyRuleRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateGatewaySecurityPolicyRuleAsync(GatewaySecurityPolicyRule gatewaySecurityPolicyRule, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateGatewaySecurityPolicyRuleOperationCallable()
 *           <li><p> updateGatewaySecurityPolicyRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteGatewaySecurityPolicyRule</td>
 *      <td><p> Deletes a single GatewaySecurityPolicyRule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteGatewaySecurityPolicyRuleAsync(DeleteGatewaySecurityPolicyRuleRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteGatewaySecurityPolicyRuleAsync(GatewaySecurityPolicyRuleName name)
 *           <li><p> deleteGatewaySecurityPolicyRuleAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteGatewaySecurityPolicyRuleOperationCallable()
 *           <li><p> deleteGatewaySecurityPolicyRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListUrlLists</td>
 *      <td><p> Lists UrlLists in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listUrlLists(ListUrlListsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listUrlLists(LocationName parent)
 *           <li><p> listUrlLists(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listUrlListsPagedCallable()
 *           <li><p> listUrlListsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetUrlList</td>
 *      <td><p> Gets details of a single UrlList.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getUrlList(GetUrlListRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getUrlList(UrlListName name)
 *           <li><p> getUrlList(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getUrlListCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateUrlList</td>
 *      <td><p> Creates a new UrlList in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createUrlListAsync(CreateUrlListRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createUrlListAsync(LocationName parent, UrlList urlList, String urlListId)
 *           <li><p> createUrlListAsync(String parent, UrlList urlList, String urlListId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createUrlListOperationCallable()
 *           <li><p> createUrlListCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateUrlList</td>
 *      <td><p> Updates the parameters of a single UrlList.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateUrlListAsync(UpdateUrlListRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateUrlListAsync(UrlList urlList, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateUrlListOperationCallable()
 *           <li><p> updateUrlListCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteUrlList</td>
 *      <td><p> Deletes a single UrlList.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteUrlListAsync(DeleteUrlListRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteUrlListAsync(UrlListName name)
 *           <li><p> deleteUrlListAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteUrlListOperationCallable()
 *           <li><p> deleteUrlListCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTlsInspectionPolicies</td>
 *      <td><p> Lists TlsInspectionPolicies in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTlsInspectionPolicies(ListTlsInspectionPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTlsInspectionPolicies(LocationName parent)
 *           <li><p> listTlsInspectionPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTlsInspectionPoliciesPagedCallable()
 *           <li><p> listTlsInspectionPoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTlsInspectionPolicy</td>
 *      <td><p> Gets details of a single TlsInspectionPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTlsInspectionPolicy(GetTlsInspectionPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTlsInspectionPolicy(TlsInspectionPolicyName name)
 *           <li><p> getTlsInspectionPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTlsInspectionPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTlsInspectionPolicy</td>
 *      <td><p> Creates a new TlsInspectionPolicy in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTlsInspectionPolicyAsync(CreateTlsInspectionPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createTlsInspectionPolicyAsync(LocationName parent, TlsInspectionPolicy tlsInspectionPolicy, String tlsInspectionPolicyId)
 *           <li><p> createTlsInspectionPolicyAsync(String parent, TlsInspectionPolicy tlsInspectionPolicy, String tlsInspectionPolicyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTlsInspectionPolicyOperationCallable()
 *           <li><p> createTlsInspectionPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTlsInspectionPolicy</td>
 *      <td><p> Updates the parameters of a single TlsInspectionPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTlsInspectionPolicyAsync(UpdateTlsInspectionPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateTlsInspectionPolicyAsync(TlsInspectionPolicy tlsInspectionPolicy, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTlsInspectionPolicyOperationCallable()
 *           <li><p> updateTlsInspectionPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTlsInspectionPolicy</td>
 *      <td><p> Deletes a single TlsInspectionPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTlsInspectionPolicyAsync(DeleteTlsInspectionPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteTlsInspectionPolicyAsync(TlsInspectionPolicyName name)
 *           <li><p> deleteTlsInspectionPolicyAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTlsInspectionPolicyOperationCallable()
 *           <li><p> deleteTlsInspectionPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAuthzPolicies</td>
 *      <td><p> Lists AuthzPolicies in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAuthzPolicies(ListAuthzPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAuthzPolicies(LocationName parent)
 *           <li><p> listAuthzPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAuthzPoliciesPagedCallable()
 *           <li><p> listAuthzPoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAuthzPolicy</td>
 *      <td><p> Gets details of a single AuthzPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAuthzPolicy(GetAuthzPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAuthzPolicy(AuthzPolicyName name)
 *           <li><p> getAuthzPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAuthzPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAuthzPolicy</td>
 *      <td><p> Creates a new AuthzPolicy in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAuthzPolicyAsync(CreateAuthzPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createAuthzPolicyAsync(LocationName parent, AuthzPolicy authzPolicy, String authzPolicyId)
 *           <li><p> createAuthzPolicyAsync(String parent, AuthzPolicy authzPolicy, String authzPolicyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAuthzPolicyOperationCallable()
 *           <li><p> createAuthzPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAuthzPolicy</td>
 *      <td><p> Updates the parameters of a single AuthzPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAuthzPolicyAsync(UpdateAuthzPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateAuthzPolicyAsync(AuthzPolicy authzPolicy, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAuthzPolicyOperationCallable()
 *           <li><p> updateAuthzPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAuthzPolicy</td>
 *      <td><p> Deletes a single AuthzPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAuthzPolicyAsync(DeleteAuthzPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAuthzPolicyAsync(AuthzPolicyName name)
 *           <li><p> deleteAuthzPolicyAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAuthzPolicyOperationCallable()
 *           <li><p> deleteAuthzPolicyCallable()
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
 * <p>This class can be customized by passing in a custom instance of NetworkSecuritySettings to
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
 * NetworkSecuritySettings networkSecuritySettings =
 *     NetworkSecuritySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NetworkSecurityClient networkSecurityClient =
 *     NetworkSecurityClient.create(networkSecuritySettings);
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
 * NetworkSecuritySettings networkSecuritySettings =
 *     NetworkSecuritySettings.newBuilder().setEndpoint(myEndpoint).build();
 * NetworkSecurityClient networkSecurityClient =
 *     NetworkSecurityClient.create(networkSecuritySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class NetworkSecurityClient implements BackgroundResource {
  private final NetworkSecuritySettings settings;
  private final NetworkSecurityStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of NetworkSecurityClient with default settings. */
  public static final NetworkSecurityClient create() throws IOException {
    return create(NetworkSecuritySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NetworkSecurityClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NetworkSecurityClient create(NetworkSecuritySettings settings)
      throws IOException {
    return new NetworkSecurityClient(settings);
  }

  /**
   * Constructs an instance of NetworkSecurityClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(NetworkSecuritySettings).
   */
  public static final NetworkSecurityClient create(NetworkSecurityStub stub) {
    return new NetworkSecurityClient(stub);
  }

  /**
   * Constructs an instance of NetworkSecurityClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected NetworkSecurityClient(NetworkSecuritySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NetworkSecurityStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected NetworkSecurityClient(NetworkSecurityStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final NetworkSecuritySettings getSettings() {
    return settings;
  }

  public NetworkSecurityStub getStub() {
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
   * Lists AuthorizationPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AuthorizationPolicy element :
   *       networkSecurityClient.listAuthorizationPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the AuthorizationPolicies should be
   *     listed, specified in the format `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthorizationPoliciesPagedResponse listAuthorizationPolicies(
      LocationName parent) {
    ListAuthorizationPoliciesRequest request =
        ListAuthorizationPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAuthorizationPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AuthorizationPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AuthorizationPolicy element :
   *       networkSecurityClient.listAuthorizationPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the AuthorizationPolicies should be
   *     listed, specified in the format `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthorizationPoliciesPagedResponse listAuthorizationPolicies(String parent) {
    ListAuthorizationPoliciesRequest request =
        ListAuthorizationPoliciesRequest.newBuilder().setParent(parent).build();
    return listAuthorizationPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AuthorizationPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListAuthorizationPoliciesRequest request =
   *       ListAuthorizationPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AuthorizationPolicy element :
   *       networkSecurityClient.listAuthorizationPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthorizationPoliciesPagedResponse listAuthorizationPolicies(
      ListAuthorizationPoliciesRequest request) {
    return listAuthorizationPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AuthorizationPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListAuthorizationPoliciesRequest request =
   *       ListAuthorizationPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AuthorizationPolicy> future =
   *       networkSecurityClient.listAuthorizationPoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AuthorizationPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesPagedResponse>
      listAuthorizationPoliciesPagedCallable() {
    return stub.listAuthorizationPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AuthorizationPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListAuthorizationPoliciesRequest request =
   *       ListAuthorizationPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAuthorizationPoliciesResponse response =
   *         networkSecurityClient.listAuthorizationPoliciesCallable().call(request);
   *     for (AuthorizationPolicy element : response.getAuthorizationPoliciesList()) {
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
  public final UnaryCallable<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>
      listAuthorizationPoliciesCallable() {
    return stub.listAuthorizationPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AuthorizationPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   AuthorizationPolicyName name =
   *       AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]");
   *   AuthorizationPolicy response = networkSecurityClient.getAuthorizationPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the AuthorizationPolicy to get. Must be in the format
   *     `projects/{project}/locations/{location}/authorizationPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthorizationPolicy getAuthorizationPolicy(AuthorizationPolicyName name) {
    GetAuthorizationPolicyRequest request =
        GetAuthorizationPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAuthorizationPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AuthorizationPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name =
   *       AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
   *           .toString();
   *   AuthorizationPolicy response = networkSecurityClient.getAuthorizationPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the AuthorizationPolicy to get. Must be in the format
   *     `projects/{project}/locations/{location}/authorizationPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthorizationPolicy getAuthorizationPolicy(String name) {
    GetAuthorizationPolicyRequest request =
        GetAuthorizationPolicyRequest.newBuilder().setName(name).build();
    return getAuthorizationPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AuthorizationPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetAuthorizationPolicyRequest request =
   *       GetAuthorizationPolicyRequest.newBuilder()
   *           .setName(
   *               AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
   *                   .toString())
   *           .build();
   *   AuthorizationPolicy response = networkSecurityClient.getAuthorizationPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthorizationPolicy getAuthorizationPolicy(GetAuthorizationPolicyRequest request) {
    return getAuthorizationPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AuthorizationPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetAuthorizationPolicyRequest request =
   *       GetAuthorizationPolicyRequest.newBuilder()
   *           .setName(
   *               AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AuthorizationPolicy> future =
   *       networkSecurityClient.getAuthorizationPolicyCallable().futureCall(request);
   *   // Do something.
   *   AuthorizationPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAuthorizationPolicyRequest, AuthorizationPolicy>
      getAuthorizationPolicyCallable() {
    return stub.getAuthorizationPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AuthorizationPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AuthorizationPolicy authorizationPolicy = AuthorizationPolicy.newBuilder().build();
   *   String authorizationPolicyId = "authorizationPolicyId1314252166";
   *   AuthorizationPolicy response =
   *       networkSecurityClient
   *           .createAuthorizationPolicyAsync(parent, authorizationPolicy, authorizationPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the AuthorizationPolicy. Must be in the format
   *     `projects/{project}/locations/{location}`.
   * @param authorizationPolicy Required. AuthorizationPolicy resource to be created.
   * @param authorizationPolicyId Required. Short name of the AuthorizationPolicy resource to be
   *     created. This value should be 1-63 characters long, containing only letters, numbers,
   *     hyphens, and underscores, and should not start with a number. E.g. "authz_policy".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AuthorizationPolicy, OperationMetadata>
      createAuthorizationPolicyAsync(
          LocationName parent,
          AuthorizationPolicy authorizationPolicy,
          String authorizationPolicyId) {
    CreateAuthorizationPolicyRequest request =
        CreateAuthorizationPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAuthorizationPolicy(authorizationPolicy)
            .setAuthorizationPolicyId(authorizationPolicyId)
            .build();
    return createAuthorizationPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AuthorizationPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AuthorizationPolicy authorizationPolicy = AuthorizationPolicy.newBuilder().build();
   *   String authorizationPolicyId = "authorizationPolicyId1314252166";
   *   AuthorizationPolicy response =
   *       networkSecurityClient
   *           .createAuthorizationPolicyAsync(parent, authorizationPolicy, authorizationPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the AuthorizationPolicy. Must be in the format
   *     `projects/{project}/locations/{location}`.
   * @param authorizationPolicy Required. AuthorizationPolicy resource to be created.
   * @param authorizationPolicyId Required. Short name of the AuthorizationPolicy resource to be
   *     created. This value should be 1-63 characters long, containing only letters, numbers,
   *     hyphens, and underscores, and should not start with a number. E.g. "authz_policy".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AuthorizationPolicy, OperationMetadata>
      createAuthorizationPolicyAsync(
          String parent, AuthorizationPolicy authorizationPolicy, String authorizationPolicyId) {
    CreateAuthorizationPolicyRequest request =
        CreateAuthorizationPolicyRequest.newBuilder()
            .setParent(parent)
            .setAuthorizationPolicy(authorizationPolicy)
            .setAuthorizationPolicyId(authorizationPolicyId)
            .build();
    return createAuthorizationPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AuthorizationPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateAuthorizationPolicyRequest request =
   *       CreateAuthorizationPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAuthorizationPolicyId("authorizationPolicyId1314252166")
   *           .setAuthorizationPolicy(AuthorizationPolicy.newBuilder().build())
   *           .build();
   *   AuthorizationPolicy response =
   *       networkSecurityClient.createAuthorizationPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AuthorizationPolicy, OperationMetadata>
      createAuthorizationPolicyAsync(CreateAuthorizationPolicyRequest request) {
    return createAuthorizationPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AuthorizationPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateAuthorizationPolicyRequest request =
   *       CreateAuthorizationPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAuthorizationPolicyId("authorizationPolicyId1314252166")
   *           .setAuthorizationPolicy(AuthorizationPolicy.newBuilder().build())
   *           .build();
   *   OperationFuture<AuthorizationPolicy, OperationMetadata> future =
   *       networkSecurityClient.createAuthorizationPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   AuthorizationPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      createAuthorizationPolicyOperationCallable() {
    return stub.createAuthorizationPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AuthorizationPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateAuthorizationPolicyRequest request =
   *       CreateAuthorizationPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAuthorizationPolicyId("authorizationPolicyId1314252166")
   *           .setAuthorizationPolicy(AuthorizationPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.createAuthorizationPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAuthorizationPolicyRequest, Operation>
      createAuthorizationPolicyCallable() {
    return stub.createAuthorizationPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AuthorizationPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   AuthorizationPolicy authorizationPolicy = AuthorizationPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AuthorizationPolicy response =
   *       networkSecurityClient
   *           .updateAuthorizationPolicyAsync(authorizationPolicy, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param authorizationPolicy Required. Updated AuthorizationPolicy resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     AuthorizationPolicy resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AuthorizationPolicy, OperationMetadata>
      updateAuthorizationPolicyAsync(
          AuthorizationPolicy authorizationPolicy, FieldMask updateMask) {
    UpdateAuthorizationPolicyRequest request =
        UpdateAuthorizationPolicyRequest.newBuilder()
            .setAuthorizationPolicy(authorizationPolicy)
            .setUpdateMask(updateMask)
            .build();
    return updateAuthorizationPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AuthorizationPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateAuthorizationPolicyRequest request =
   *       UpdateAuthorizationPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAuthorizationPolicy(AuthorizationPolicy.newBuilder().build())
   *           .build();
   *   AuthorizationPolicy response =
   *       networkSecurityClient.updateAuthorizationPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AuthorizationPolicy, OperationMetadata>
      updateAuthorizationPolicyAsync(UpdateAuthorizationPolicyRequest request) {
    return updateAuthorizationPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AuthorizationPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateAuthorizationPolicyRequest request =
   *       UpdateAuthorizationPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAuthorizationPolicy(AuthorizationPolicy.newBuilder().build())
   *           .build();
   *   OperationFuture<AuthorizationPolicy, OperationMetadata> future =
   *       networkSecurityClient.updateAuthorizationPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   AuthorizationPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      updateAuthorizationPolicyOperationCallable() {
    return stub.updateAuthorizationPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AuthorizationPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateAuthorizationPolicyRequest request =
   *       UpdateAuthorizationPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAuthorizationPolicy(AuthorizationPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.updateAuthorizationPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAuthorizationPolicyRequest, Operation>
      updateAuthorizationPolicyCallable() {
    return stub.updateAuthorizationPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AuthorizationPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   AuthorizationPolicyName name =
   *       AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]");
   *   networkSecurityClient.deleteAuthorizationPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the AuthorizationPolicy to delete. Must be in the format
   *     `projects/{project}/locations/{location}/authorizationPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAuthorizationPolicyAsync(
      AuthorizationPolicyName name) {
    DeleteAuthorizationPolicyRequest request =
        DeleteAuthorizationPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteAuthorizationPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AuthorizationPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name =
   *       AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
   *           .toString();
   *   networkSecurityClient.deleteAuthorizationPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the AuthorizationPolicy to delete. Must be in the format
   *     `projects/{project}/locations/{location}/authorizationPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAuthorizationPolicyAsync(
      String name) {
    DeleteAuthorizationPolicyRequest request =
        DeleteAuthorizationPolicyRequest.newBuilder().setName(name).build();
    return deleteAuthorizationPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AuthorizationPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteAuthorizationPolicyRequest request =
   *       DeleteAuthorizationPolicyRequest.newBuilder()
   *           .setName(
   *               AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
   *                   .toString())
   *           .build();
   *   networkSecurityClient.deleteAuthorizationPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAuthorizationPolicyAsync(
      DeleteAuthorizationPolicyRequest request) {
    return deleteAuthorizationPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AuthorizationPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteAuthorizationPolicyRequest request =
   *       DeleteAuthorizationPolicyRequest.newBuilder()
   *           .setName(
   *               AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkSecurityClient.deleteAuthorizationPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
      deleteAuthorizationPolicyOperationCallable() {
    return stub.deleteAuthorizationPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AuthorizationPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteAuthorizationPolicyRequest request =
   *       DeleteAuthorizationPolicyRequest.newBuilder()
   *           .setName(
   *               AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.deleteAuthorizationPolicyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAuthorizationPolicyRequest, Operation>
      deleteAuthorizationPolicyCallable() {
    return stub.deleteAuthorizationPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackendAuthenticationConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (BackendAuthenticationConfig element :
   *       networkSecurityClient.listBackendAuthenticationConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the BackendAuthenticationConfigs
   *     should be listed, specified in the format `projects/&#42;/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackendAuthenticationConfigsPagedResponse listBackendAuthenticationConfigs(
      LocationName parent) {
    ListBackendAuthenticationConfigsRequest request =
        ListBackendAuthenticationConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackendAuthenticationConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackendAuthenticationConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (BackendAuthenticationConfig element :
   *       networkSecurityClient.listBackendAuthenticationConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the BackendAuthenticationConfigs
   *     should be listed, specified in the format `projects/&#42;/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackendAuthenticationConfigsPagedResponse listBackendAuthenticationConfigs(
      String parent) {
    ListBackendAuthenticationConfigsRequest request =
        ListBackendAuthenticationConfigsRequest.newBuilder().setParent(parent).build();
    return listBackendAuthenticationConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackendAuthenticationConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListBackendAuthenticationConfigsRequest request =
   *       ListBackendAuthenticationConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (BackendAuthenticationConfig element :
   *       networkSecurityClient.listBackendAuthenticationConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackendAuthenticationConfigsPagedResponse listBackendAuthenticationConfigs(
      ListBackendAuthenticationConfigsRequest request) {
    return listBackendAuthenticationConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackendAuthenticationConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListBackendAuthenticationConfigsRequest request =
   *       ListBackendAuthenticationConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<BackendAuthenticationConfig> future =
   *       networkSecurityClient.listBackendAuthenticationConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BackendAuthenticationConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListBackendAuthenticationConfigsRequest, ListBackendAuthenticationConfigsPagedResponse>
      listBackendAuthenticationConfigsPagedCallable() {
    return stub.listBackendAuthenticationConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackendAuthenticationConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListBackendAuthenticationConfigsRequest request =
   *       ListBackendAuthenticationConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBackendAuthenticationConfigsResponse response =
   *         networkSecurityClient.listBackendAuthenticationConfigsCallable().call(request);
   *     for (BackendAuthenticationConfig element : response.getBackendAuthenticationConfigsList()) {
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
          ListBackendAuthenticationConfigsRequest, ListBackendAuthenticationConfigsResponse>
      listBackendAuthenticationConfigsCallable() {
    return stub.listBackendAuthenticationConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single BackendAuthenticationConfig to BackendAuthenticationConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   BackendAuthenticationConfigName name =
   *       BackendAuthenticationConfigName.of(
   *           "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]");
   *   BackendAuthenticationConfig response =
   *       networkSecurityClient.getBackendAuthenticationConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the BackendAuthenticationConfig to get. Must be in the format
   *     `projects/&#42;/locations/{location}/backendAuthenticationConfigs/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendAuthenticationConfig getBackendAuthenticationConfig(
      BackendAuthenticationConfigName name) {
    GetBackendAuthenticationConfigRequest request =
        GetBackendAuthenticationConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getBackendAuthenticationConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single BackendAuthenticationConfig to BackendAuthenticationConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name =
   *       BackendAuthenticationConfigName.of(
   *               "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]")
   *           .toString();
   *   BackendAuthenticationConfig response =
   *       networkSecurityClient.getBackendAuthenticationConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the BackendAuthenticationConfig to get. Must be in the format
   *     `projects/&#42;/locations/{location}/backendAuthenticationConfigs/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendAuthenticationConfig getBackendAuthenticationConfig(String name) {
    GetBackendAuthenticationConfigRequest request =
        GetBackendAuthenticationConfigRequest.newBuilder().setName(name).build();
    return getBackendAuthenticationConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single BackendAuthenticationConfig to BackendAuthenticationConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetBackendAuthenticationConfigRequest request =
   *       GetBackendAuthenticationConfigRequest.newBuilder()
   *           .setName(
   *               BackendAuthenticationConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]")
   *                   .toString())
   *           .build();
   *   BackendAuthenticationConfig response =
   *       networkSecurityClient.getBackendAuthenticationConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendAuthenticationConfig getBackendAuthenticationConfig(
      GetBackendAuthenticationConfigRequest request) {
    return getBackendAuthenticationConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single BackendAuthenticationConfig to BackendAuthenticationConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetBackendAuthenticationConfigRequest request =
   *       GetBackendAuthenticationConfigRequest.newBuilder()
   *           .setName(
   *               BackendAuthenticationConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<BackendAuthenticationConfig> future =
   *       networkSecurityClient.getBackendAuthenticationConfigCallable().futureCall(request);
   *   // Do something.
   *   BackendAuthenticationConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackendAuthenticationConfigRequest, BackendAuthenticationConfig>
      getBackendAuthenticationConfigCallable() {
    return stub.getBackendAuthenticationConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackendAuthenticationConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   BackendAuthenticationConfig backendAuthenticationConfig =
   *       BackendAuthenticationConfig.newBuilder().build();
   *   String backendAuthenticationConfigId = "backendAuthenticationConfigId-396698039";
   *   BackendAuthenticationConfig response =
   *       networkSecurityClient
   *           .createBackendAuthenticationConfigAsync(
   *               parent, backendAuthenticationConfig, backendAuthenticationConfigId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the BackendAuthenticationConfig. Must be in the
   *     format `projects/&#42;/locations/{location}`.
   * @param backendAuthenticationConfig Required. BackendAuthenticationConfig resource to be
   *     created.
   * @param backendAuthenticationConfigId Required. Short name of the BackendAuthenticationConfig
   *     resource to be created. This value should be 1-63 characters long, containing only letters,
   *     numbers, hyphens, and underscores, and should not start with a number. E.g.
   *     "backend-auth-config".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackendAuthenticationConfig, OperationMetadata>
      createBackendAuthenticationConfigAsync(
          LocationName parent,
          BackendAuthenticationConfig backendAuthenticationConfig,
          String backendAuthenticationConfigId) {
    CreateBackendAuthenticationConfigRequest request =
        CreateBackendAuthenticationConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBackendAuthenticationConfig(backendAuthenticationConfig)
            .setBackendAuthenticationConfigId(backendAuthenticationConfigId)
            .build();
    return createBackendAuthenticationConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackendAuthenticationConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   BackendAuthenticationConfig backendAuthenticationConfig =
   *       BackendAuthenticationConfig.newBuilder().build();
   *   String backendAuthenticationConfigId = "backendAuthenticationConfigId-396698039";
   *   BackendAuthenticationConfig response =
   *       networkSecurityClient
   *           .createBackendAuthenticationConfigAsync(
   *               parent, backendAuthenticationConfig, backendAuthenticationConfigId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the BackendAuthenticationConfig. Must be in the
   *     format `projects/&#42;/locations/{location}`.
   * @param backendAuthenticationConfig Required. BackendAuthenticationConfig resource to be
   *     created.
   * @param backendAuthenticationConfigId Required. Short name of the BackendAuthenticationConfig
   *     resource to be created. This value should be 1-63 characters long, containing only letters,
   *     numbers, hyphens, and underscores, and should not start with a number. E.g.
   *     "backend-auth-config".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackendAuthenticationConfig, OperationMetadata>
      createBackendAuthenticationConfigAsync(
          String parent,
          BackendAuthenticationConfig backendAuthenticationConfig,
          String backendAuthenticationConfigId) {
    CreateBackendAuthenticationConfigRequest request =
        CreateBackendAuthenticationConfigRequest.newBuilder()
            .setParent(parent)
            .setBackendAuthenticationConfig(backendAuthenticationConfig)
            .setBackendAuthenticationConfigId(backendAuthenticationConfigId)
            .build();
    return createBackendAuthenticationConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackendAuthenticationConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateBackendAuthenticationConfigRequest request =
   *       CreateBackendAuthenticationConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackendAuthenticationConfigId("backendAuthenticationConfigId-396698039")
   *           .setBackendAuthenticationConfig(BackendAuthenticationConfig.newBuilder().build())
   *           .build();
   *   BackendAuthenticationConfig response =
   *       networkSecurityClient.createBackendAuthenticationConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackendAuthenticationConfig, OperationMetadata>
      createBackendAuthenticationConfigAsync(CreateBackendAuthenticationConfigRequest request) {
    return createBackendAuthenticationConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackendAuthenticationConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateBackendAuthenticationConfigRequest request =
   *       CreateBackendAuthenticationConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackendAuthenticationConfigId("backendAuthenticationConfigId-396698039")
   *           .setBackendAuthenticationConfig(BackendAuthenticationConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<BackendAuthenticationConfig, OperationMetadata> future =
   *       networkSecurityClient
   *           .createBackendAuthenticationConfigOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BackendAuthenticationConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateBackendAuthenticationConfigRequest, BackendAuthenticationConfig, OperationMetadata>
      createBackendAuthenticationConfigOperationCallable() {
    return stub.createBackendAuthenticationConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackendAuthenticationConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateBackendAuthenticationConfigRequest request =
   *       CreateBackendAuthenticationConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackendAuthenticationConfigId("backendAuthenticationConfigId-396698039")
   *           .setBackendAuthenticationConfig(BackendAuthenticationConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.createBackendAuthenticationConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBackendAuthenticationConfigRequest, Operation>
      createBackendAuthenticationConfigCallable() {
    return stub.createBackendAuthenticationConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single BackendAuthenticationConfig to BackendAuthenticationConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   BackendAuthenticationConfig backendAuthenticationConfig =
   *       BackendAuthenticationConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BackendAuthenticationConfig response =
   *       networkSecurityClient
   *           .updateBackendAuthenticationConfigAsync(backendAuthenticationConfig, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param backendAuthenticationConfig Required. Updated BackendAuthenticationConfig resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     BackendAuthenticationConfig resource by the update. The fields specified in the update_mask
   *     are relative to the resource, not the full request. A field will be overwritten if it is in
   *     the mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackendAuthenticationConfig, OperationMetadata>
      updateBackendAuthenticationConfigAsync(
          BackendAuthenticationConfig backendAuthenticationConfig, FieldMask updateMask) {
    UpdateBackendAuthenticationConfigRequest request =
        UpdateBackendAuthenticationConfigRequest.newBuilder()
            .setBackendAuthenticationConfig(backendAuthenticationConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateBackendAuthenticationConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single BackendAuthenticationConfig to BackendAuthenticationConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateBackendAuthenticationConfigRequest request =
   *       UpdateBackendAuthenticationConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBackendAuthenticationConfig(BackendAuthenticationConfig.newBuilder().build())
   *           .build();
   *   BackendAuthenticationConfig response =
   *       networkSecurityClient.updateBackendAuthenticationConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackendAuthenticationConfig, OperationMetadata>
      updateBackendAuthenticationConfigAsync(UpdateBackendAuthenticationConfigRequest request) {
    return updateBackendAuthenticationConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single BackendAuthenticationConfig to BackendAuthenticationConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateBackendAuthenticationConfigRequest request =
   *       UpdateBackendAuthenticationConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBackendAuthenticationConfig(BackendAuthenticationConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<BackendAuthenticationConfig, OperationMetadata> future =
   *       networkSecurityClient
   *           .updateBackendAuthenticationConfigOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BackendAuthenticationConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateBackendAuthenticationConfigRequest, BackendAuthenticationConfig, OperationMetadata>
      updateBackendAuthenticationConfigOperationCallable() {
    return stub.updateBackendAuthenticationConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single BackendAuthenticationConfig to BackendAuthenticationConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateBackendAuthenticationConfigRequest request =
   *       UpdateBackendAuthenticationConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBackendAuthenticationConfig(BackendAuthenticationConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.updateBackendAuthenticationConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBackendAuthenticationConfigRequest, Operation>
      updateBackendAuthenticationConfigCallable() {
    return stub.updateBackendAuthenticationConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single BackendAuthenticationConfig to BackendAuthenticationConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   BackendAuthenticationConfigName name =
   *       BackendAuthenticationConfigName.of(
   *           "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]");
   *   networkSecurityClient.deleteBackendAuthenticationConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the BackendAuthenticationConfig to delete. Must be in the
   *     format `projects/&#42;/locations/{location}/backendAuthenticationConfigs/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackendAuthenticationConfigAsync(
      BackendAuthenticationConfigName name) {
    DeleteBackendAuthenticationConfigRequest request =
        DeleteBackendAuthenticationConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteBackendAuthenticationConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single BackendAuthenticationConfig to BackendAuthenticationConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name =
   *       BackendAuthenticationConfigName.of(
   *               "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]")
   *           .toString();
   *   networkSecurityClient.deleteBackendAuthenticationConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the BackendAuthenticationConfig to delete. Must be in the
   *     format `projects/&#42;/locations/{location}/backendAuthenticationConfigs/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackendAuthenticationConfigAsync(
      String name) {
    DeleteBackendAuthenticationConfigRequest request =
        DeleteBackendAuthenticationConfigRequest.newBuilder().setName(name).build();
    return deleteBackendAuthenticationConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single BackendAuthenticationConfig to BackendAuthenticationConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteBackendAuthenticationConfigRequest request =
   *       DeleteBackendAuthenticationConfigRequest.newBuilder()
   *           .setName(
   *               BackendAuthenticationConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   networkSecurityClient.deleteBackendAuthenticationConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackendAuthenticationConfigAsync(
      DeleteBackendAuthenticationConfigRequest request) {
    return deleteBackendAuthenticationConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single BackendAuthenticationConfig to BackendAuthenticationConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteBackendAuthenticationConfigRequest request =
   *       DeleteBackendAuthenticationConfigRequest.newBuilder()
   *           .setName(
   *               BackendAuthenticationConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkSecurityClient
   *           .deleteBackendAuthenticationConfigOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBackendAuthenticationConfigRequest, Empty, OperationMetadata>
      deleteBackendAuthenticationConfigOperationCallable() {
    return stub.deleteBackendAuthenticationConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single BackendAuthenticationConfig to BackendAuthenticationConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteBackendAuthenticationConfigRequest request =
   *       DeleteBackendAuthenticationConfigRequest.newBuilder()
   *           .setName(
   *               BackendAuthenticationConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKEND_AUTHENTICATION_CONFIG]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.deleteBackendAuthenticationConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBackendAuthenticationConfigRequest, Operation>
      deleteBackendAuthenticationConfigCallable() {
    return stub.deleteBackendAuthenticationConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServerTlsPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ServerTlsPolicy element :
   *       networkSecurityClient.listServerTlsPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the ServerTlsPolicies should be
   *     listed, specified in the format `projects/&#42;/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServerTlsPoliciesPagedResponse listServerTlsPolicies(LocationName parent) {
    ListServerTlsPoliciesRequest request =
        ListServerTlsPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listServerTlsPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServerTlsPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ServerTlsPolicy element :
   *       networkSecurityClient.listServerTlsPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the ServerTlsPolicies should be
   *     listed, specified in the format `projects/&#42;/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServerTlsPoliciesPagedResponse listServerTlsPolicies(String parent) {
    ListServerTlsPoliciesRequest request =
        ListServerTlsPoliciesRequest.newBuilder().setParent(parent).build();
    return listServerTlsPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServerTlsPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListServerTlsPoliciesRequest request =
   *       ListServerTlsPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (ServerTlsPolicy element :
   *       networkSecurityClient.listServerTlsPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServerTlsPoliciesPagedResponse listServerTlsPolicies(
      ListServerTlsPoliciesRequest request) {
    return listServerTlsPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServerTlsPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListServerTlsPoliciesRequest request =
   *       ListServerTlsPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<ServerTlsPolicy> future =
   *       networkSecurityClient.listServerTlsPoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ServerTlsPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesPagedResponse>
      listServerTlsPoliciesPagedCallable() {
    return stub.listServerTlsPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServerTlsPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListServerTlsPoliciesRequest request =
   *       ListServerTlsPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     ListServerTlsPoliciesResponse response =
   *         networkSecurityClient.listServerTlsPoliciesCallable().call(request);
   *     for (ServerTlsPolicy element : response.getServerTlsPoliciesList()) {
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
  public final UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>
      listServerTlsPoliciesCallable() {
    return stub.listServerTlsPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServerTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ServerTlsPolicyName name =
   *       ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]");
   *   ServerTlsPolicy response = networkSecurityClient.getServerTlsPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the ServerTlsPolicy to get. Must be in the format
   *     `projects/&#42;/locations/{location}/serverTlsPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServerTlsPolicy getServerTlsPolicy(ServerTlsPolicyName name) {
    GetServerTlsPolicyRequest request =
        GetServerTlsPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getServerTlsPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServerTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name =
   *       ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]").toString();
   *   ServerTlsPolicy response = networkSecurityClient.getServerTlsPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the ServerTlsPolicy to get. Must be in the format
   *     `projects/&#42;/locations/{location}/serverTlsPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServerTlsPolicy getServerTlsPolicy(String name) {
    GetServerTlsPolicyRequest request =
        GetServerTlsPolicyRequest.newBuilder().setName(name).build();
    return getServerTlsPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServerTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetServerTlsPolicyRequest request =
   *       GetServerTlsPolicyRequest.newBuilder()
   *           .setName(
   *               ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]")
   *                   .toString())
   *           .build();
   *   ServerTlsPolicy response = networkSecurityClient.getServerTlsPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServerTlsPolicy getServerTlsPolicy(GetServerTlsPolicyRequest request) {
    return getServerTlsPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServerTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetServerTlsPolicyRequest request =
   *       GetServerTlsPolicyRequest.newBuilder()
   *           .setName(
   *               ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ServerTlsPolicy> future =
   *       networkSecurityClient.getServerTlsPolicyCallable().futureCall(request);
   *   // Do something.
   *   ServerTlsPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServerTlsPolicyRequest, ServerTlsPolicy>
      getServerTlsPolicyCallable() {
    return stub.getServerTlsPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServerTlsPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ServerTlsPolicy serverTlsPolicy = ServerTlsPolicy.newBuilder().build();
   *   String serverTlsPolicyId = "serverTlsPolicyId-1966046011";
   *   ServerTlsPolicy response =
   *       networkSecurityClient
   *           .createServerTlsPolicyAsync(parent, serverTlsPolicy, serverTlsPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the ServerTlsPolicy. Must be in the format
   *     `projects/&#42;/locations/{location}`.
   * @param serverTlsPolicy Required. ServerTlsPolicy resource to be created.
   * @param serverTlsPolicyId Required. Short name of the ServerTlsPolicy resource to be created.
   *     This value should be 1-63 characters long, containing only letters, numbers, hyphens, and
   *     underscores, and should not start with a number. E.g. "server_mtls_policy".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServerTlsPolicy, OperationMetadata> createServerTlsPolicyAsync(
      LocationName parent, ServerTlsPolicy serverTlsPolicy, String serverTlsPolicyId) {
    CreateServerTlsPolicyRequest request =
        CreateServerTlsPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setServerTlsPolicy(serverTlsPolicy)
            .setServerTlsPolicyId(serverTlsPolicyId)
            .build();
    return createServerTlsPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServerTlsPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ServerTlsPolicy serverTlsPolicy = ServerTlsPolicy.newBuilder().build();
   *   String serverTlsPolicyId = "serverTlsPolicyId-1966046011";
   *   ServerTlsPolicy response =
   *       networkSecurityClient
   *           .createServerTlsPolicyAsync(parent, serverTlsPolicy, serverTlsPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the ServerTlsPolicy. Must be in the format
   *     `projects/&#42;/locations/{location}`.
   * @param serverTlsPolicy Required. ServerTlsPolicy resource to be created.
   * @param serverTlsPolicyId Required. Short name of the ServerTlsPolicy resource to be created.
   *     This value should be 1-63 characters long, containing only letters, numbers, hyphens, and
   *     underscores, and should not start with a number. E.g. "server_mtls_policy".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServerTlsPolicy, OperationMetadata> createServerTlsPolicyAsync(
      String parent, ServerTlsPolicy serverTlsPolicy, String serverTlsPolicyId) {
    CreateServerTlsPolicyRequest request =
        CreateServerTlsPolicyRequest.newBuilder()
            .setParent(parent)
            .setServerTlsPolicy(serverTlsPolicy)
            .setServerTlsPolicyId(serverTlsPolicyId)
            .build();
    return createServerTlsPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServerTlsPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateServerTlsPolicyRequest request =
   *       CreateServerTlsPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServerTlsPolicyId("serverTlsPolicyId-1966046011")
   *           .setServerTlsPolicy(ServerTlsPolicy.newBuilder().build())
   *           .build();
   *   ServerTlsPolicy response = networkSecurityClient.createServerTlsPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServerTlsPolicy, OperationMetadata> createServerTlsPolicyAsync(
      CreateServerTlsPolicyRequest request) {
    return createServerTlsPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServerTlsPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateServerTlsPolicyRequest request =
   *       CreateServerTlsPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServerTlsPolicyId("serverTlsPolicyId-1966046011")
   *           .setServerTlsPolicy(ServerTlsPolicy.newBuilder().build())
   *           .build();
   *   OperationFuture<ServerTlsPolicy, OperationMetadata> future =
   *       networkSecurityClient.createServerTlsPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   ServerTlsPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      createServerTlsPolicyOperationCallable() {
    return stub.createServerTlsPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServerTlsPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateServerTlsPolicyRequest request =
   *       CreateServerTlsPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServerTlsPolicyId("serverTlsPolicyId-1966046011")
   *           .setServerTlsPolicy(ServerTlsPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.createServerTlsPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateServerTlsPolicyRequest, Operation>
      createServerTlsPolicyCallable() {
    return stub.createServerTlsPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ServerTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ServerTlsPolicy serverTlsPolicy = ServerTlsPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ServerTlsPolicy response =
   *       networkSecurityClient.updateServerTlsPolicyAsync(serverTlsPolicy, updateMask).get();
   * }
   * }</pre>
   *
   * @param serverTlsPolicy Required. Updated ServerTlsPolicy resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     ServerTlsPolicy resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServerTlsPolicy, OperationMetadata> updateServerTlsPolicyAsync(
      ServerTlsPolicy serverTlsPolicy, FieldMask updateMask) {
    UpdateServerTlsPolicyRequest request =
        UpdateServerTlsPolicyRequest.newBuilder()
            .setServerTlsPolicy(serverTlsPolicy)
            .setUpdateMask(updateMask)
            .build();
    return updateServerTlsPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ServerTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateServerTlsPolicyRequest request =
   *       UpdateServerTlsPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setServerTlsPolicy(ServerTlsPolicy.newBuilder().build())
   *           .build();
   *   ServerTlsPolicy response = networkSecurityClient.updateServerTlsPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServerTlsPolicy, OperationMetadata> updateServerTlsPolicyAsync(
      UpdateServerTlsPolicyRequest request) {
    return updateServerTlsPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ServerTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateServerTlsPolicyRequest request =
   *       UpdateServerTlsPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setServerTlsPolicy(ServerTlsPolicy.newBuilder().build())
   *           .build();
   *   OperationFuture<ServerTlsPolicy, OperationMetadata> future =
   *       networkSecurityClient.updateServerTlsPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   ServerTlsPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      updateServerTlsPolicyOperationCallable() {
    return stub.updateServerTlsPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ServerTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateServerTlsPolicyRequest request =
   *       UpdateServerTlsPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setServerTlsPolicy(ServerTlsPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.updateServerTlsPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateServerTlsPolicyRequest, Operation>
      updateServerTlsPolicyCallable() {
    return stub.updateServerTlsPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServerTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ServerTlsPolicyName name =
   *       ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]");
   *   networkSecurityClient.deleteServerTlsPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the ServerTlsPolicy to delete. Must be in the format
   *     `projects/&#42;/locations/{location}/serverTlsPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServerTlsPolicyAsync(
      ServerTlsPolicyName name) {
    DeleteServerTlsPolicyRequest request =
        DeleteServerTlsPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteServerTlsPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServerTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name =
   *       ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]").toString();
   *   networkSecurityClient.deleteServerTlsPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the ServerTlsPolicy to delete. Must be in the format
   *     `projects/&#42;/locations/{location}/serverTlsPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServerTlsPolicyAsync(String name) {
    DeleteServerTlsPolicyRequest request =
        DeleteServerTlsPolicyRequest.newBuilder().setName(name).build();
    return deleteServerTlsPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServerTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteServerTlsPolicyRequest request =
   *       DeleteServerTlsPolicyRequest.newBuilder()
   *           .setName(
   *               ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]")
   *                   .toString())
   *           .build();
   *   networkSecurityClient.deleteServerTlsPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServerTlsPolicyAsync(
      DeleteServerTlsPolicyRequest request) {
    return deleteServerTlsPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServerTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteServerTlsPolicyRequest request =
   *       DeleteServerTlsPolicyRequest.newBuilder()
   *           .setName(
   *               ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkSecurityClient.deleteServerTlsPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteServerTlsPolicyRequest, Empty, OperationMetadata>
      deleteServerTlsPolicyOperationCallable() {
    return stub.deleteServerTlsPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServerTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteServerTlsPolicyRequest request =
   *       DeleteServerTlsPolicyRequest.newBuilder()
   *           .setName(
   *               ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.deleteServerTlsPolicyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteServerTlsPolicyRequest, Operation>
      deleteServerTlsPolicyCallable() {
    return stub.deleteServerTlsPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ClientTlsPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ClientTlsPolicy element :
   *       networkSecurityClient.listClientTlsPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the ClientTlsPolicies should be
   *     listed, specified in the format `projects/&#42;/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClientTlsPoliciesPagedResponse listClientTlsPolicies(LocationName parent) {
    ListClientTlsPoliciesRequest request =
        ListClientTlsPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listClientTlsPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ClientTlsPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ClientTlsPolicy element :
   *       networkSecurityClient.listClientTlsPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the ClientTlsPolicies should be
   *     listed, specified in the format `projects/&#42;/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClientTlsPoliciesPagedResponse listClientTlsPolicies(String parent) {
    ListClientTlsPoliciesRequest request =
        ListClientTlsPoliciesRequest.newBuilder().setParent(parent).build();
    return listClientTlsPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ClientTlsPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListClientTlsPoliciesRequest request =
   *       ListClientTlsPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ClientTlsPolicy element :
   *       networkSecurityClient.listClientTlsPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClientTlsPoliciesPagedResponse listClientTlsPolicies(
      ListClientTlsPoliciesRequest request) {
    return listClientTlsPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ClientTlsPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListClientTlsPoliciesRequest request =
   *       ListClientTlsPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ClientTlsPolicy> future =
   *       networkSecurityClient.listClientTlsPoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ClientTlsPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesPagedResponse>
      listClientTlsPoliciesPagedCallable() {
    return stub.listClientTlsPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ClientTlsPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListClientTlsPoliciesRequest request =
   *       ListClientTlsPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListClientTlsPoliciesResponse response =
   *         networkSecurityClient.listClientTlsPoliciesCallable().call(request);
   *     for (ClientTlsPolicy element : response.getClientTlsPoliciesList()) {
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
  public final UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>
      listClientTlsPoliciesCallable() {
    return stub.listClientTlsPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ClientTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ClientTlsPolicyName name =
   *       ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]");
   *   ClientTlsPolicy response = networkSecurityClient.getClientTlsPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the ClientTlsPolicy to get. Must be in the format
   *     `projects/&#42;/locations/{location}/clientTlsPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClientTlsPolicy getClientTlsPolicy(ClientTlsPolicyName name) {
    GetClientTlsPolicyRequest request =
        GetClientTlsPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getClientTlsPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ClientTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name =
   *       ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]").toString();
   *   ClientTlsPolicy response = networkSecurityClient.getClientTlsPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the ClientTlsPolicy to get. Must be in the format
   *     `projects/&#42;/locations/{location}/clientTlsPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClientTlsPolicy getClientTlsPolicy(String name) {
    GetClientTlsPolicyRequest request =
        GetClientTlsPolicyRequest.newBuilder().setName(name).build();
    return getClientTlsPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ClientTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetClientTlsPolicyRequest request =
   *       GetClientTlsPolicyRequest.newBuilder()
   *           .setName(
   *               ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]")
   *                   .toString())
   *           .build();
   *   ClientTlsPolicy response = networkSecurityClient.getClientTlsPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClientTlsPolicy getClientTlsPolicy(GetClientTlsPolicyRequest request) {
    return getClientTlsPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ClientTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetClientTlsPolicyRequest request =
   *       GetClientTlsPolicyRequest.newBuilder()
   *           .setName(
   *               ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ClientTlsPolicy> future =
   *       networkSecurityClient.getClientTlsPolicyCallable().futureCall(request);
   *   // Do something.
   *   ClientTlsPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetClientTlsPolicyRequest, ClientTlsPolicy>
      getClientTlsPolicyCallable() {
    return stub.getClientTlsPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ClientTlsPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ClientTlsPolicy clientTlsPolicy = ClientTlsPolicy.newBuilder().build();
   *   String clientTlsPolicyId = "clientTlsPolicyId-188933315";
   *   ClientTlsPolicy response =
   *       networkSecurityClient
   *           .createClientTlsPolicyAsync(parent, clientTlsPolicy, clientTlsPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the ClientTlsPolicy. Must be in the format
   *     `projects/&#42;/locations/{location}`.
   * @param clientTlsPolicy Required. ClientTlsPolicy resource to be created.
   * @param clientTlsPolicyId Required. Short name of the ClientTlsPolicy resource to be created.
   *     This value should be 1-63 characters long, containing only letters, numbers, hyphens, and
   *     underscores, and should not start with a number. E.g. "client_mtls_policy".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ClientTlsPolicy, OperationMetadata> createClientTlsPolicyAsync(
      LocationName parent, ClientTlsPolicy clientTlsPolicy, String clientTlsPolicyId) {
    CreateClientTlsPolicyRequest request =
        CreateClientTlsPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setClientTlsPolicy(clientTlsPolicy)
            .setClientTlsPolicyId(clientTlsPolicyId)
            .build();
    return createClientTlsPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ClientTlsPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ClientTlsPolicy clientTlsPolicy = ClientTlsPolicy.newBuilder().build();
   *   String clientTlsPolicyId = "clientTlsPolicyId-188933315";
   *   ClientTlsPolicy response =
   *       networkSecurityClient
   *           .createClientTlsPolicyAsync(parent, clientTlsPolicy, clientTlsPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the ClientTlsPolicy. Must be in the format
   *     `projects/&#42;/locations/{location}`.
   * @param clientTlsPolicy Required. ClientTlsPolicy resource to be created.
   * @param clientTlsPolicyId Required. Short name of the ClientTlsPolicy resource to be created.
   *     This value should be 1-63 characters long, containing only letters, numbers, hyphens, and
   *     underscores, and should not start with a number. E.g. "client_mtls_policy".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ClientTlsPolicy, OperationMetadata> createClientTlsPolicyAsync(
      String parent, ClientTlsPolicy clientTlsPolicy, String clientTlsPolicyId) {
    CreateClientTlsPolicyRequest request =
        CreateClientTlsPolicyRequest.newBuilder()
            .setParent(parent)
            .setClientTlsPolicy(clientTlsPolicy)
            .setClientTlsPolicyId(clientTlsPolicyId)
            .build();
    return createClientTlsPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ClientTlsPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateClientTlsPolicyRequest request =
   *       CreateClientTlsPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClientTlsPolicyId("clientTlsPolicyId-188933315")
   *           .setClientTlsPolicy(ClientTlsPolicy.newBuilder().build())
   *           .build();
   *   ClientTlsPolicy response = networkSecurityClient.createClientTlsPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ClientTlsPolicy, OperationMetadata> createClientTlsPolicyAsync(
      CreateClientTlsPolicyRequest request) {
    return createClientTlsPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ClientTlsPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateClientTlsPolicyRequest request =
   *       CreateClientTlsPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClientTlsPolicyId("clientTlsPolicyId-188933315")
   *           .setClientTlsPolicy(ClientTlsPolicy.newBuilder().build())
   *           .build();
   *   OperationFuture<ClientTlsPolicy, OperationMetadata> future =
   *       networkSecurityClient.createClientTlsPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   ClientTlsPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      createClientTlsPolicyOperationCallable() {
    return stub.createClientTlsPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ClientTlsPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateClientTlsPolicyRequest request =
   *       CreateClientTlsPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClientTlsPolicyId("clientTlsPolicyId-188933315")
   *           .setClientTlsPolicy(ClientTlsPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.createClientTlsPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateClientTlsPolicyRequest, Operation>
      createClientTlsPolicyCallable() {
    return stub.createClientTlsPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ClientTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ClientTlsPolicy clientTlsPolicy = ClientTlsPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ClientTlsPolicy response =
   *       networkSecurityClient.updateClientTlsPolicyAsync(clientTlsPolicy, updateMask).get();
   * }
   * }</pre>
   *
   * @param clientTlsPolicy Required. Updated ClientTlsPolicy resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     ClientTlsPolicy resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ClientTlsPolicy, OperationMetadata> updateClientTlsPolicyAsync(
      ClientTlsPolicy clientTlsPolicy, FieldMask updateMask) {
    UpdateClientTlsPolicyRequest request =
        UpdateClientTlsPolicyRequest.newBuilder()
            .setClientTlsPolicy(clientTlsPolicy)
            .setUpdateMask(updateMask)
            .build();
    return updateClientTlsPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ClientTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateClientTlsPolicyRequest request =
   *       UpdateClientTlsPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setClientTlsPolicy(ClientTlsPolicy.newBuilder().build())
   *           .build();
   *   ClientTlsPolicy response = networkSecurityClient.updateClientTlsPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ClientTlsPolicy, OperationMetadata> updateClientTlsPolicyAsync(
      UpdateClientTlsPolicyRequest request) {
    return updateClientTlsPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ClientTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateClientTlsPolicyRequest request =
   *       UpdateClientTlsPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setClientTlsPolicy(ClientTlsPolicy.newBuilder().build())
   *           .build();
   *   OperationFuture<ClientTlsPolicy, OperationMetadata> future =
   *       networkSecurityClient.updateClientTlsPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   ClientTlsPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      updateClientTlsPolicyOperationCallable() {
    return stub.updateClientTlsPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ClientTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateClientTlsPolicyRequest request =
   *       UpdateClientTlsPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setClientTlsPolicy(ClientTlsPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.updateClientTlsPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateClientTlsPolicyRequest, Operation>
      updateClientTlsPolicyCallable() {
    return stub.updateClientTlsPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ClientTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ClientTlsPolicyName name =
   *       ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]");
   *   networkSecurityClient.deleteClientTlsPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the ClientTlsPolicy to delete. Must be in the format
   *     `projects/&#42;/locations/{location}/clientTlsPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteClientTlsPolicyAsync(
      ClientTlsPolicyName name) {
    DeleteClientTlsPolicyRequest request =
        DeleteClientTlsPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteClientTlsPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ClientTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name =
   *       ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]").toString();
   *   networkSecurityClient.deleteClientTlsPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the ClientTlsPolicy to delete. Must be in the format
   *     `projects/&#42;/locations/{location}/clientTlsPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteClientTlsPolicyAsync(String name) {
    DeleteClientTlsPolicyRequest request =
        DeleteClientTlsPolicyRequest.newBuilder().setName(name).build();
    return deleteClientTlsPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ClientTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteClientTlsPolicyRequest request =
   *       DeleteClientTlsPolicyRequest.newBuilder()
   *           .setName(
   *               ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]")
   *                   .toString())
   *           .build();
   *   networkSecurityClient.deleteClientTlsPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteClientTlsPolicyAsync(
      DeleteClientTlsPolicyRequest request) {
    return deleteClientTlsPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ClientTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteClientTlsPolicyRequest request =
   *       DeleteClientTlsPolicyRequest.newBuilder()
   *           .setName(
   *               ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkSecurityClient.deleteClientTlsPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
      deleteClientTlsPolicyOperationCallable() {
    return stub.deleteClientTlsPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ClientTlsPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteClientTlsPolicyRequest request =
   *       DeleteClientTlsPolicyRequest.newBuilder()
   *           .setName(
   *               ClientTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[CLIENT_TLS_POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.deleteClientTlsPolicyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteClientTlsPolicyRequest, Operation>
      deleteClientTlsPolicyCallable() {
    return stub.deleteClientTlsPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GatewaySecurityPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (GatewaySecurityPolicy element :
   *       networkSecurityClient.listGatewaySecurityPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the GatewaySecurityPolicies should
   *     be listed, specified in the format `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGatewaySecurityPoliciesPagedResponse listGatewaySecurityPolicies(
      LocationName parent) {
    ListGatewaySecurityPoliciesRequest request =
        ListGatewaySecurityPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGatewaySecurityPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GatewaySecurityPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (GatewaySecurityPolicy element :
   *       networkSecurityClient.listGatewaySecurityPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the GatewaySecurityPolicies should
   *     be listed, specified in the format `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGatewaySecurityPoliciesPagedResponse listGatewaySecurityPolicies(String parent) {
    ListGatewaySecurityPoliciesRequest request =
        ListGatewaySecurityPoliciesRequest.newBuilder().setParent(parent).build();
    return listGatewaySecurityPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GatewaySecurityPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListGatewaySecurityPoliciesRequest request =
   *       ListGatewaySecurityPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (GatewaySecurityPolicy element :
   *       networkSecurityClient.listGatewaySecurityPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGatewaySecurityPoliciesPagedResponse listGatewaySecurityPolicies(
      ListGatewaySecurityPoliciesRequest request) {
    return listGatewaySecurityPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GatewaySecurityPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListGatewaySecurityPoliciesRequest request =
   *       ListGatewaySecurityPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<GatewaySecurityPolicy> future =
   *       networkSecurityClient.listGatewaySecurityPoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GatewaySecurityPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListGatewaySecurityPoliciesRequest, ListGatewaySecurityPoliciesPagedResponse>
      listGatewaySecurityPoliciesPagedCallable() {
    return stub.listGatewaySecurityPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GatewaySecurityPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListGatewaySecurityPoliciesRequest request =
   *       ListGatewaySecurityPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListGatewaySecurityPoliciesResponse response =
   *         networkSecurityClient.listGatewaySecurityPoliciesCallable().call(request);
   *     for (GatewaySecurityPolicy element : response.getGatewaySecurityPoliciesList()) {
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
          ListGatewaySecurityPoliciesRequest, ListGatewaySecurityPoliciesResponse>
      listGatewaySecurityPoliciesCallable() {
    return stub.listGatewaySecurityPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single GatewaySecurityPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GatewaySecurityPolicyName name =
   *       GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]");
   *   GatewaySecurityPolicy response = networkSecurityClient.getGatewaySecurityPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the GatewaySecurityPolicy to get. Must be in the format
   *     `projects/{project}/locations/{location}/gatewaySecurityPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GatewaySecurityPolicy getGatewaySecurityPolicy(GatewaySecurityPolicyName name) {
    GetGatewaySecurityPolicyRequest request =
        GetGatewaySecurityPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getGatewaySecurityPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single GatewaySecurityPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name =
   *       GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
   *           .toString();
   *   GatewaySecurityPolicy response = networkSecurityClient.getGatewaySecurityPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the GatewaySecurityPolicy to get. Must be in the format
   *     `projects/{project}/locations/{location}/gatewaySecurityPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GatewaySecurityPolicy getGatewaySecurityPolicy(String name) {
    GetGatewaySecurityPolicyRequest request =
        GetGatewaySecurityPolicyRequest.newBuilder().setName(name).build();
    return getGatewaySecurityPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single GatewaySecurityPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetGatewaySecurityPolicyRequest request =
   *       GetGatewaySecurityPolicyRequest.newBuilder()
   *           .setName(
   *               GatewaySecurityPolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
   *                   .toString())
   *           .build();
   *   GatewaySecurityPolicy response = networkSecurityClient.getGatewaySecurityPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GatewaySecurityPolicy getGatewaySecurityPolicy(
      GetGatewaySecurityPolicyRequest request) {
    return getGatewaySecurityPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single GatewaySecurityPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetGatewaySecurityPolicyRequest request =
   *       GetGatewaySecurityPolicyRequest.newBuilder()
   *           .setName(
   *               GatewaySecurityPolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<GatewaySecurityPolicy> future =
   *       networkSecurityClient.getGatewaySecurityPolicyCallable().futureCall(request);
   *   // Do something.
   *   GatewaySecurityPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGatewaySecurityPolicyRequest, GatewaySecurityPolicy>
      getGatewaySecurityPolicyCallable() {
    return stub.getGatewaySecurityPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GatewaySecurityPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   GatewaySecurityPolicy gatewaySecurityPolicy = GatewaySecurityPolicy.newBuilder().build();
   *   String gatewaySecurityPolicyId = "gatewaySecurityPolicyId2047625137";
   *   GatewaySecurityPolicy response =
   *       networkSecurityClient
   *           .createGatewaySecurityPolicyAsync(
   *               parent, gatewaySecurityPolicy, gatewaySecurityPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the GatewaySecurityPolicy. Must be in the format
   *     `projects/{project}/locations/{location}`.
   * @param gatewaySecurityPolicy Required. GatewaySecurityPolicy resource to be created.
   * @param gatewaySecurityPolicyId Required. Short name of the GatewaySecurityPolicy resource to be
   *     created. This value should be 1-63 characters long, containing only letters, numbers,
   *     hyphens, and underscores, and should not start with a number. E.g.
   *     "gateway_security_policy1".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GatewaySecurityPolicy, OperationMetadata>
      createGatewaySecurityPolicyAsync(
          LocationName parent,
          GatewaySecurityPolicy gatewaySecurityPolicy,
          String gatewaySecurityPolicyId) {
    CreateGatewaySecurityPolicyRequest request =
        CreateGatewaySecurityPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGatewaySecurityPolicy(gatewaySecurityPolicy)
            .setGatewaySecurityPolicyId(gatewaySecurityPolicyId)
            .build();
    return createGatewaySecurityPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GatewaySecurityPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   GatewaySecurityPolicy gatewaySecurityPolicy = GatewaySecurityPolicy.newBuilder().build();
   *   String gatewaySecurityPolicyId = "gatewaySecurityPolicyId2047625137";
   *   GatewaySecurityPolicy response =
   *       networkSecurityClient
   *           .createGatewaySecurityPolicyAsync(
   *               parent, gatewaySecurityPolicy, gatewaySecurityPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the GatewaySecurityPolicy. Must be in the format
   *     `projects/{project}/locations/{location}`.
   * @param gatewaySecurityPolicy Required. GatewaySecurityPolicy resource to be created.
   * @param gatewaySecurityPolicyId Required. Short name of the GatewaySecurityPolicy resource to be
   *     created. This value should be 1-63 characters long, containing only letters, numbers,
   *     hyphens, and underscores, and should not start with a number. E.g.
   *     "gateway_security_policy1".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GatewaySecurityPolicy, OperationMetadata>
      createGatewaySecurityPolicyAsync(
          String parent,
          GatewaySecurityPolicy gatewaySecurityPolicy,
          String gatewaySecurityPolicyId) {
    CreateGatewaySecurityPolicyRequest request =
        CreateGatewaySecurityPolicyRequest.newBuilder()
            .setParent(parent)
            .setGatewaySecurityPolicy(gatewaySecurityPolicy)
            .setGatewaySecurityPolicyId(gatewaySecurityPolicyId)
            .build();
    return createGatewaySecurityPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GatewaySecurityPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateGatewaySecurityPolicyRequest request =
   *       CreateGatewaySecurityPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGatewaySecurityPolicyId("gatewaySecurityPolicyId2047625137")
   *           .setGatewaySecurityPolicy(GatewaySecurityPolicy.newBuilder().build())
   *           .build();
   *   GatewaySecurityPolicy response =
   *       networkSecurityClient.createGatewaySecurityPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GatewaySecurityPolicy, OperationMetadata>
      createGatewaySecurityPolicyAsync(CreateGatewaySecurityPolicyRequest request) {
    return createGatewaySecurityPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GatewaySecurityPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateGatewaySecurityPolicyRequest request =
   *       CreateGatewaySecurityPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGatewaySecurityPolicyId("gatewaySecurityPolicyId2047625137")
   *           .setGatewaySecurityPolicy(GatewaySecurityPolicy.newBuilder().build())
   *           .build();
   *   OperationFuture<GatewaySecurityPolicy, OperationMetadata> future =
   *       networkSecurityClient.createGatewaySecurityPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   GatewaySecurityPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
      createGatewaySecurityPolicyOperationCallable() {
    return stub.createGatewaySecurityPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GatewaySecurityPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateGatewaySecurityPolicyRequest request =
   *       CreateGatewaySecurityPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGatewaySecurityPolicyId("gatewaySecurityPolicyId2047625137")
   *           .setGatewaySecurityPolicy(GatewaySecurityPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.createGatewaySecurityPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGatewaySecurityPolicyRequest, Operation>
      createGatewaySecurityPolicyCallable() {
    return stub.createGatewaySecurityPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single GatewaySecurityPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GatewaySecurityPolicy gatewaySecurityPolicy = GatewaySecurityPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   GatewaySecurityPolicy response =
   *       networkSecurityClient
   *           .updateGatewaySecurityPolicyAsync(gatewaySecurityPolicy, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param gatewaySecurityPolicy Required. Updated GatewaySecurityPolicy resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     GatewaySecurityPolicy resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GatewaySecurityPolicy, OperationMetadata>
      updateGatewaySecurityPolicyAsync(
          GatewaySecurityPolicy gatewaySecurityPolicy, FieldMask updateMask) {
    UpdateGatewaySecurityPolicyRequest request =
        UpdateGatewaySecurityPolicyRequest.newBuilder()
            .setGatewaySecurityPolicy(gatewaySecurityPolicy)
            .setUpdateMask(updateMask)
            .build();
    return updateGatewaySecurityPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single GatewaySecurityPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateGatewaySecurityPolicyRequest request =
   *       UpdateGatewaySecurityPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGatewaySecurityPolicy(GatewaySecurityPolicy.newBuilder().build())
   *           .build();
   *   GatewaySecurityPolicy response =
   *       networkSecurityClient.updateGatewaySecurityPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GatewaySecurityPolicy, OperationMetadata>
      updateGatewaySecurityPolicyAsync(UpdateGatewaySecurityPolicyRequest request) {
    return updateGatewaySecurityPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single GatewaySecurityPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateGatewaySecurityPolicyRequest request =
   *       UpdateGatewaySecurityPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGatewaySecurityPolicy(GatewaySecurityPolicy.newBuilder().build())
   *           .build();
   *   OperationFuture<GatewaySecurityPolicy, OperationMetadata> future =
   *       networkSecurityClient.updateGatewaySecurityPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   GatewaySecurityPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
      updateGatewaySecurityPolicyOperationCallable() {
    return stub.updateGatewaySecurityPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single GatewaySecurityPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateGatewaySecurityPolicyRequest request =
   *       UpdateGatewaySecurityPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGatewaySecurityPolicy(GatewaySecurityPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.updateGatewaySecurityPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGatewaySecurityPolicyRequest, Operation>
      updateGatewaySecurityPolicyCallable() {
    return stub.updateGatewaySecurityPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GatewaySecurityPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GatewaySecurityPolicyName name =
   *       GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]");
   *   networkSecurityClient.deleteGatewaySecurityPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the GatewaySecurityPolicy to delete. Must be in the format
   *     `projects/{project}/locations/{location}/gatewaySecurityPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGatewaySecurityPolicyAsync(
      GatewaySecurityPolicyName name) {
    DeleteGatewaySecurityPolicyRequest request =
        DeleteGatewaySecurityPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteGatewaySecurityPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GatewaySecurityPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name =
   *       GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
   *           .toString();
   *   networkSecurityClient.deleteGatewaySecurityPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the GatewaySecurityPolicy to delete. Must be in the format
   *     `projects/{project}/locations/{location}/gatewaySecurityPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGatewaySecurityPolicyAsync(
      String name) {
    DeleteGatewaySecurityPolicyRequest request =
        DeleteGatewaySecurityPolicyRequest.newBuilder().setName(name).build();
    return deleteGatewaySecurityPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GatewaySecurityPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteGatewaySecurityPolicyRequest request =
   *       DeleteGatewaySecurityPolicyRequest.newBuilder()
   *           .setName(
   *               GatewaySecurityPolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
   *                   .toString())
   *           .build();
   *   networkSecurityClient.deleteGatewaySecurityPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGatewaySecurityPolicyAsync(
      DeleteGatewaySecurityPolicyRequest request) {
    return deleteGatewaySecurityPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GatewaySecurityPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteGatewaySecurityPolicyRequest request =
   *       DeleteGatewaySecurityPolicyRequest.newBuilder()
   *           .setName(
   *               GatewaySecurityPolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkSecurityClient.deleteGatewaySecurityPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGatewaySecurityPolicyRequest, Empty, OperationMetadata>
      deleteGatewaySecurityPolicyOperationCallable() {
    return stub.deleteGatewaySecurityPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GatewaySecurityPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteGatewaySecurityPolicyRequest request =
   *       DeleteGatewaySecurityPolicyRequest.newBuilder()
   *           .setName(
   *               GatewaySecurityPolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.deleteGatewaySecurityPolicyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGatewaySecurityPolicyRequest, Operation>
      deleteGatewaySecurityPolicyCallable() {
    return stub.deleteGatewaySecurityPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GatewaySecurityPolicyRules in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GatewaySecurityPolicyName parent =
   *       GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]");
   *   for (GatewaySecurityPolicyRule element :
   *       networkSecurityClient.listGatewaySecurityPolicyRules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project, location and GatewaySecurityPolicy from which the
   *     GatewaySecurityPolicyRules should be listed, specified in the format
   *     `projects/{project}/locations/{location}/gatewaySecurityPolicies/{gatewaySecurityPolicy}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGatewaySecurityPolicyRulesPagedResponse listGatewaySecurityPolicyRules(
      GatewaySecurityPolicyName parent) {
    ListGatewaySecurityPolicyRulesRequest request =
        ListGatewaySecurityPolicyRulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGatewaySecurityPolicyRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GatewaySecurityPolicyRules in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent =
   *       GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
   *           .toString();
   *   for (GatewaySecurityPolicyRule element :
   *       networkSecurityClient.listGatewaySecurityPolicyRules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project, location and GatewaySecurityPolicy from which the
   *     GatewaySecurityPolicyRules should be listed, specified in the format
   *     `projects/{project}/locations/{location}/gatewaySecurityPolicies/{gatewaySecurityPolicy}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGatewaySecurityPolicyRulesPagedResponse listGatewaySecurityPolicyRules(
      String parent) {
    ListGatewaySecurityPolicyRulesRequest request =
        ListGatewaySecurityPolicyRulesRequest.newBuilder().setParent(parent).build();
    return listGatewaySecurityPolicyRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GatewaySecurityPolicyRules in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListGatewaySecurityPolicyRulesRequest request =
   *       ListGatewaySecurityPolicyRulesRequest.newBuilder()
   *           .setParent(
   *               GatewaySecurityPolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (GatewaySecurityPolicyRule element :
   *       networkSecurityClient.listGatewaySecurityPolicyRules(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGatewaySecurityPolicyRulesPagedResponse listGatewaySecurityPolicyRules(
      ListGatewaySecurityPolicyRulesRequest request) {
    return listGatewaySecurityPolicyRulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GatewaySecurityPolicyRules in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListGatewaySecurityPolicyRulesRequest request =
   *       ListGatewaySecurityPolicyRulesRequest.newBuilder()
   *           .setParent(
   *               GatewaySecurityPolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<GatewaySecurityPolicyRule> future =
   *       networkSecurityClient.listGatewaySecurityPolicyRulesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GatewaySecurityPolicyRule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListGatewaySecurityPolicyRulesRequest, ListGatewaySecurityPolicyRulesPagedResponse>
      listGatewaySecurityPolicyRulesPagedCallable() {
    return stub.listGatewaySecurityPolicyRulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GatewaySecurityPolicyRules in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListGatewaySecurityPolicyRulesRequest request =
   *       ListGatewaySecurityPolicyRulesRequest.newBuilder()
   *           .setParent(
   *               GatewaySecurityPolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListGatewaySecurityPolicyRulesResponse response =
   *         networkSecurityClient.listGatewaySecurityPolicyRulesCallable().call(request);
   *     for (GatewaySecurityPolicyRule element : response.getGatewaySecurityPolicyRulesList()) {
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
          ListGatewaySecurityPolicyRulesRequest, ListGatewaySecurityPolicyRulesResponse>
      listGatewaySecurityPolicyRulesCallable() {
    return stub.listGatewaySecurityPolicyRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single GatewaySecurityPolicyRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GatewaySecurityPolicyRuleName name =
   *       GatewaySecurityPolicyRuleName.of(
   *           "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]");
   *   GatewaySecurityPolicyRule response = networkSecurityClient.getGatewaySecurityPolicyRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the GatewaySecurityPolicyRule to retrieve. Format:
   *     projects/{project}/location/{location}/gatewaySecurityPolicies/&#42;/rules/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GatewaySecurityPolicyRule getGatewaySecurityPolicyRule(
      GatewaySecurityPolicyRuleName name) {
    GetGatewaySecurityPolicyRuleRequest request =
        GetGatewaySecurityPolicyRuleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getGatewaySecurityPolicyRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single GatewaySecurityPolicyRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name =
   *       GatewaySecurityPolicyRuleName.of(
   *               "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]")
   *           .toString();
   *   GatewaySecurityPolicyRule response = networkSecurityClient.getGatewaySecurityPolicyRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the GatewaySecurityPolicyRule to retrieve. Format:
   *     projects/{project}/location/{location}/gatewaySecurityPolicies/&#42;/rules/&#42;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GatewaySecurityPolicyRule getGatewaySecurityPolicyRule(String name) {
    GetGatewaySecurityPolicyRuleRequest request =
        GetGatewaySecurityPolicyRuleRequest.newBuilder().setName(name).build();
    return getGatewaySecurityPolicyRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single GatewaySecurityPolicyRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetGatewaySecurityPolicyRuleRequest request =
   *       GetGatewaySecurityPolicyRuleRequest.newBuilder()
   *           .setName(
   *               GatewaySecurityPolicyRuleName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]")
   *                   .toString())
   *           .build();
   *   GatewaySecurityPolicyRule response =
   *       networkSecurityClient.getGatewaySecurityPolicyRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GatewaySecurityPolicyRule getGatewaySecurityPolicyRule(
      GetGatewaySecurityPolicyRuleRequest request) {
    return getGatewaySecurityPolicyRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single GatewaySecurityPolicyRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetGatewaySecurityPolicyRuleRequest request =
   *       GetGatewaySecurityPolicyRuleRequest.newBuilder()
   *           .setName(
   *               GatewaySecurityPolicyRuleName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<GatewaySecurityPolicyRule> future =
   *       networkSecurityClient.getGatewaySecurityPolicyRuleCallable().futureCall(request);
   *   // Do something.
   *   GatewaySecurityPolicyRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule>
      getGatewaySecurityPolicyRuleCallable() {
    return stub.getGatewaySecurityPolicyRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GatewaySecurityPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GatewaySecurityPolicyName parent =
   *       GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]");
   *   GatewaySecurityPolicyRule gatewaySecurityPolicyRule =
   *       GatewaySecurityPolicyRule.newBuilder().build();
   *   String gatewaySecurityPolicyRuleId = "gatewaySecurityPolicyRuleId-1764962099";
   *   GatewaySecurityPolicyRule response =
   *       networkSecurityClient
   *           .createGatewaySecurityPolicyRuleAsync(
   *               parent, gatewaySecurityPolicyRule, gatewaySecurityPolicyRuleId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent where this rule will be created. Format :
   *     projects/{project}/location/{location}/gatewaySecurityPolicies/&#42;
   * @param gatewaySecurityPolicyRule Required. The rule to be created.
   * @param gatewaySecurityPolicyRuleId The ID to use for the rule, which will become the final
   *     component of the rule's resource name. This value should be 4-63 characters, and valid
   *     characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GatewaySecurityPolicyRule, OperationMetadata>
      createGatewaySecurityPolicyRuleAsync(
          GatewaySecurityPolicyName parent,
          GatewaySecurityPolicyRule gatewaySecurityPolicyRule,
          String gatewaySecurityPolicyRuleId) {
    CreateGatewaySecurityPolicyRuleRequest request =
        CreateGatewaySecurityPolicyRuleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGatewaySecurityPolicyRule(gatewaySecurityPolicyRule)
            .setGatewaySecurityPolicyRuleId(gatewaySecurityPolicyRuleId)
            .build();
    return createGatewaySecurityPolicyRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GatewaySecurityPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent =
   *       GatewaySecurityPolicyName.of("[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
   *           .toString();
   *   GatewaySecurityPolicyRule gatewaySecurityPolicyRule =
   *       GatewaySecurityPolicyRule.newBuilder().build();
   *   String gatewaySecurityPolicyRuleId = "gatewaySecurityPolicyRuleId-1764962099";
   *   GatewaySecurityPolicyRule response =
   *       networkSecurityClient
   *           .createGatewaySecurityPolicyRuleAsync(
   *               parent, gatewaySecurityPolicyRule, gatewaySecurityPolicyRuleId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent where this rule will be created. Format :
   *     projects/{project}/location/{location}/gatewaySecurityPolicies/&#42;
   * @param gatewaySecurityPolicyRule Required. The rule to be created.
   * @param gatewaySecurityPolicyRuleId The ID to use for the rule, which will become the final
   *     component of the rule's resource name. This value should be 4-63 characters, and valid
   *     characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GatewaySecurityPolicyRule, OperationMetadata>
      createGatewaySecurityPolicyRuleAsync(
          String parent,
          GatewaySecurityPolicyRule gatewaySecurityPolicyRule,
          String gatewaySecurityPolicyRuleId) {
    CreateGatewaySecurityPolicyRuleRequest request =
        CreateGatewaySecurityPolicyRuleRequest.newBuilder()
            .setParent(parent)
            .setGatewaySecurityPolicyRule(gatewaySecurityPolicyRule)
            .setGatewaySecurityPolicyRuleId(gatewaySecurityPolicyRuleId)
            .build();
    return createGatewaySecurityPolicyRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GatewaySecurityPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateGatewaySecurityPolicyRuleRequest request =
   *       CreateGatewaySecurityPolicyRuleRequest.newBuilder()
   *           .setParent(
   *               GatewaySecurityPolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
   *                   .toString())
   *           .setGatewaySecurityPolicyRule(GatewaySecurityPolicyRule.newBuilder().build())
   *           .setGatewaySecurityPolicyRuleId("gatewaySecurityPolicyRuleId-1764962099")
   *           .build();
   *   GatewaySecurityPolicyRule response =
   *       networkSecurityClient.createGatewaySecurityPolicyRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GatewaySecurityPolicyRule, OperationMetadata>
      createGatewaySecurityPolicyRuleAsync(CreateGatewaySecurityPolicyRuleRequest request) {
    return createGatewaySecurityPolicyRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GatewaySecurityPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateGatewaySecurityPolicyRuleRequest request =
   *       CreateGatewaySecurityPolicyRuleRequest.newBuilder()
   *           .setParent(
   *               GatewaySecurityPolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
   *                   .toString())
   *           .setGatewaySecurityPolicyRule(GatewaySecurityPolicyRule.newBuilder().build())
   *           .setGatewaySecurityPolicyRuleId("gatewaySecurityPolicyRuleId-1764962099")
   *           .build();
   *   OperationFuture<GatewaySecurityPolicyRule, OperationMetadata> future =
   *       networkSecurityClient
   *           .createGatewaySecurityPolicyRuleOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   GatewaySecurityPolicyRule response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
      createGatewaySecurityPolicyRuleOperationCallable() {
    return stub.createGatewaySecurityPolicyRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GatewaySecurityPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateGatewaySecurityPolicyRuleRequest request =
   *       CreateGatewaySecurityPolicyRuleRequest.newBuilder()
   *           .setParent(
   *               GatewaySecurityPolicyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]")
   *                   .toString())
   *           .setGatewaySecurityPolicyRule(GatewaySecurityPolicyRule.newBuilder().build())
   *           .setGatewaySecurityPolicyRuleId("gatewaySecurityPolicyRuleId-1764962099")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.createGatewaySecurityPolicyRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGatewaySecurityPolicyRuleRequest, Operation>
      createGatewaySecurityPolicyRuleCallable() {
    return stub.createGatewaySecurityPolicyRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single GatewaySecurityPolicyRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GatewaySecurityPolicyRule gatewaySecurityPolicyRule =
   *       GatewaySecurityPolicyRule.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   GatewaySecurityPolicyRule response =
   *       networkSecurityClient
   *           .updateGatewaySecurityPolicyRuleAsync(gatewaySecurityPolicyRule, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param gatewaySecurityPolicyRule Required. Updated GatewaySecurityPolicyRule resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     GatewaySecurityPolicy resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GatewaySecurityPolicyRule, OperationMetadata>
      updateGatewaySecurityPolicyRuleAsync(
          GatewaySecurityPolicyRule gatewaySecurityPolicyRule, FieldMask updateMask) {
    UpdateGatewaySecurityPolicyRuleRequest request =
        UpdateGatewaySecurityPolicyRuleRequest.newBuilder()
            .setGatewaySecurityPolicyRule(gatewaySecurityPolicyRule)
            .setUpdateMask(updateMask)
            .build();
    return updateGatewaySecurityPolicyRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single GatewaySecurityPolicyRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateGatewaySecurityPolicyRuleRequest request =
   *       UpdateGatewaySecurityPolicyRuleRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGatewaySecurityPolicyRule(GatewaySecurityPolicyRule.newBuilder().build())
   *           .build();
   *   GatewaySecurityPolicyRule response =
   *       networkSecurityClient.updateGatewaySecurityPolicyRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GatewaySecurityPolicyRule, OperationMetadata>
      updateGatewaySecurityPolicyRuleAsync(UpdateGatewaySecurityPolicyRuleRequest request) {
    return updateGatewaySecurityPolicyRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single GatewaySecurityPolicyRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateGatewaySecurityPolicyRuleRequest request =
   *       UpdateGatewaySecurityPolicyRuleRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGatewaySecurityPolicyRule(GatewaySecurityPolicyRule.newBuilder().build())
   *           .build();
   *   OperationFuture<GatewaySecurityPolicyRule, OperationMetadata> future =
   *       networkSecurityClient
   *           .updateGatewaySecurityPolicyRuleOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   GatewaySecurityPolicyRule response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
      updateGatewaySecurityPolicyRuleOperationCallable() {
    return stub.updateGatewaySecurityPolicyRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single GatewaySecurityPolicyRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateGatewaySecurityPolicyRuleRequest request =
   *       UpdateGatewaySecurityPolicyRuleRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGatewaySecurityPolicyRule(GatewaySecurityPolicyRule.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.updateGatewaySecurityPolicyRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGatewaySecurityPolicyRuleRequest, Operation>
      updateGatewaySecurityPolicyRuleCallable() {
    return stub.updateGatewaySecurityPolicyRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GatewaySecurityPolicyRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GatewaySecurityPolicyRuleName name =
   *       GatewaySecurityPolicyRuleName.of(
   *           "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]");
   *   networkSecurityClient.deleteGatewaySecurityPolicyRuleAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the GatewaySecurityPolicyRule to delete. Must be in the format
   *     `projects/{project}/locations/{location}/gatewaySecurityPolicies/{gatewaySecurityPolicy}/rules/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGatewaySecurityPolicyRuleAsync(
      GatewaySecurityPolicyRuleName name) {
    DeleteGatewaySecurityPolicyRuleRequest request =
        DeleteGatewaySecurityPolicyRuleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteGatewaySecurityPolicyRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GatewaySecurityPolicyRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name =
   *       GatewaySecurityPolicyRuleName.of(
   *               "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]")
   *           .toString();
   *   networkSecurityClient.deleteGatewaySecurityPolicyRuleAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the GatewaySecurityPolicyRule to delete. Must be in the format
   *     `projects/{project}/locations/{location}/gatewaySecurityPolicies/{gatewaySecurityPolicy}/rules/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGatewaySecurityPolicyRuleAsync(
      String name) {
    DeleteGatewaySecurityPolicyRuleRequest request =
        DeleteGatewaySecurityPolicyRuleRequest.newBuilder().setName(name).build();
    return deleteGatewaySecurityPolicyRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GatewaySecurityPolicyRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteGatewaySecurityPolicyRuleRequest request =
   *       DeleteGatewaySecurityPolicyRuleRequest.newBuilder()
   *           .setName(
   *               GatewaySecurityPolicyRuleName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]")
   *                   .toString())
   *           .build();
   *   networkSecurityClient.deleteGatewaySecurityPolicyRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGatewaySecurityPolicyRuleAsync(
      DeleteGatewaySecurityPolicyRuleRequest request) {
    return deleteGatewaySecurityPolicyRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GatewaySecurityPolicyRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteGatewaySecurityPolicyRuleRequest request =
   *       DeleteGatewaySecurityPolicyRuleRequest.newBuilder()
   *           .setName(
   *               GatewaySecurityPolicyRuleName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkSecurityClient
   *           .deleteGatewaySecurityPolicyRuleOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGatewaySecurityPolicyRuleRequest, Empty, OperationMetadata>
      deleteGatewaySecurityPolicyRuleOperationCallable() {
    return stub.deleteGatewaySecurityPolicyRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GatewaySecurityPolicyRule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteGatewaySecurityPolicyRuleRequest request =
   *       DeleteGatewaySecurityPolicyRuleRequest.newBuilder()
   *           .setName(
   *               GatewaySecurityPolicyRuleName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GATEWAY_SECURITY_POLICY]", "[RULE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.deleteGatewaySecurityPolicyRuleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGatewaySecurityPolicyRuleRequest, Operation>
      deleteGatewaySecurityPolicyRuleCallable() {
    return stub.deleteGatewaySecurityPolicyRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists UrlLists in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (UrlList element : networkSecurityClient.listUrlLists(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the UrlLists should be listed,
   *     specified in the format `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUrlListsPagedResponse listUrlLists(LocationName parent) {
    ListUrlListsRequest request =
        ListUrlListsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUrlLists(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists UrlLists in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (UrlList element : networkSecurityClient.listUrlLists(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the UrlLists should be listed,
   *     specified in the format `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUrlListsPagedResponse listUrlLists(String parent) {
    ListUrlListsRequest request = ListUrlListsRequest.newBuilder().setParent(parent).build();
    return listUrlLists(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists UrlLists in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListUrlListsRequest request =
   *       ListUrlListsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (UrlList element : networkSecurityClient.listUrlLists(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUrlListsPagedResponse listUrlLists(ListUrlListsRequest request) {
    return listUrlListsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists UrlLists in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListUrlListsRequest request =
   *       ListUrlListsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<UrlList> future =
   *       networkSecurityClient.listUrlListsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (UrlList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUrlListsRequest, ListUrlListsPagedResponse>
      listUrlListsPagedCallable() {
    return stub.listUrlListsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists UrlLists in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListUrlListsRequest request =
   *       ListUrlListsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListUrlListsResponse response = networkSecurityClient.listUrlListsCallable().call(request);
   *     for (UrlList element : response.getUrlListsList()) {
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
  public final UnaryCallable<ListUrlListsRequest, ListUrlListsResponse> listUrlListsCallable() {
    return stub.listUrlListsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single UrlList.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UrlListName name = UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]");
   *   UrlList response = networkSecurityClient.getUrlList(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the UrlList to get. Must be in the format
   *     `projects/&#42;/locations/{location}/urlLists/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UrlList getUrlList(UrlListName name) {
    GetUrlListRequest request =
        GetUrlListRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getUrlList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single UrlList.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name = UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]").toString();
   *   UrlList response = networkSecurityClient.getUrlList(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the UrlList to get. Must be in the format
   *     `projects/&#42;/locations/{location}/urlLists/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UrlList getUrlList(String name) {
    GetUrlListRequest request = GetUrlListRequest.newBuilder().setName(name).build();
    return getUrlList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single UrlList.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetUrlListRequest request =
   *       GetUrlListRequest.newBuilder()
   *           .setName(UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]").toString())
   *           .build();
   *   UrlList response = networkSecurityClient.getUrlList(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UrlList getUrlList(GetUrlListRequest request) {
    return getUrlListCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single UrlList.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetUrlListRequest request =
   *       GetUrlListRequest.newBuilder()
   *           .setName(UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]").toString())
   *           .build();
   *   ApiFuture<UrlList> future = networkSecurityClient.getUrlListCallable().futureCall(request);
   *   // Do something.
   *   UrlList response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetUrlListRequest, UrlList> getUrlListCallable() {
    return stub.getUrlListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new UrlList in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   UrlList urlList = UrlList.newBuilder().build();
   *   String urlListId = "urlListId-564417368";
   *   UrlList response = networkSecurityClient.createUrlListAsync(parent, urlList, urlListId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the UrlList. Must be in the format
   *     `projects/&#42;/locations/{location}`.
   * @param urlList Required. UrlList resource to be created.
   * @param urlListId Required. Short name of the UrlList resource to be created. This value should
   *     be 1-63 characters long, containing only letters, numbers, hyphens, and underscores, and
   *     should not start with a number. E.g. "url_list".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UrlList, OperationMetadata> createUrlListAsync(
      LocationName parent, UrlList urlList, String urlListId) {
    CreateUrlListRequest request =
        CreateUrlListRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUrlList(urlList)
            .setUrlListId(urlListId)
            .build();
    return createUrlListAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new UrlList in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   UrlList urlList = UrlList.newBuilder().build();
   *   String urlListId = "urlListId-564417368";
   *   UrlList response = networkSecurityClient.createUrlListAsync(parent, urlList, urlListId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the UrlList. Must be in the format
   *     `projects/&#42;/locations/{location}`.
   * @param urlList Required. UrlList resource to be created.
   * @param urlListId Required. Short name of the UrlList resource to be created. This value should
   *     be 1-63 characters long, containing only letters, numbers, hyphens, and underscores, and
   *     should not start with a number. E.g. "url_list".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UrlList, OperationMetadata> createUrlListAsync(
      String parent, UrlList urlList, String urlListId) {
    CreateUrlListRequest request =
        CreateUrlListRequest.newBuilder()
            .setParent(parent)
            .setUrlList(urlList)
            .setUrlListId(urlListId)
            .build();
    return createUrlListAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new UrlList in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateUrlListRequest request =
   *       CreateUrlListRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setUrlListId("urlListId-564417368")
   *           .setUrlList(UrlList.newBuilder().build())
   *           .build();
   *   UrlList response = networkSecurityClient.createUrlListAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UrlList, OperationMetadata> createUrlListAsync(
      CreateUrlListRequest request) {
    return createUrlListOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new UrlList in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateUrlListRequest request =
   *       CreateUrlListRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setUrlListId("urlListId-564417368")
   *           .setUrlList(UrlList.newBuilder().build())
   *           .build();
   *   OperationFuture<UrlList, OperationMetadata> future =
   *       networkSecurityClient.createUrlListOperationCallable().futureCall(request);
   *   // Do something.
   *   UrlList response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateUrlListRequest, UrlList, OperationMetadata>
      createUrlListOperationCallable() {
    return stub.createUrlListOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new UrlList in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateUrlListRequest request =
   *       CreateUrlListRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setUrlListId("urlListId-564417368")
   *           .setUrlList(UrlList.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.createUrlListCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateUrlListRequest, Operation> createUrlListCallable() {
    return stub.createUrlListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single UrlList.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UrlList urlList = UrlList.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UrlList response = networkSecurityClient.updateUrlListAsync(urlList, updateMask).get();
   * }
   * }</pre>
   *
   * @param urlList Required. Updated UrlList resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     UrlList resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UrlList, OperationMetadata> updateUrlListAsync(
      UrlList urlList, FieldMask updateMask) {
    UpdateUrlListRequest request =
        UpdateUrlListRequest.newBuilder().setUrlList(urlList).setUpdateMask(updateMask).build();
    return updateUrlListAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single UrlList.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateUrlListRequest request =
   *       UpdateUrlListRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setUrlList(UrlList.newBuilder().build())
   *           .build();
   *   UrlList response = networkSecurityClient.updateUrlListAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UrlList, OperationMetadata> updateUrlListAsync(
      UpdateUrlListRequest request) {
    return updateUrlListOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single UrlList.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateUrlListRequest request =
   *       UpdateUrlListRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setUrlList(UrlList.newBuilder().build())
   *           .build();
   *   OperationFuture<UrlList, OperationMetadata> future =
   *       networkSecurityClient.updateUrlListOperationCallable().futureCall(request);
   *   // Do something.
   *   UrlList response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateUrlListRequest, UrlList, OperationMetadata>
      updateUrlListOperationCallable() {
    return stub.updateUrlListOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single UrlList.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateUrlListRequest request =
   *       UpdateUrlListRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setUrlList(UrlList.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.updateUrlListCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateUrlListRequest, Operation> updateUrlListCallable() {
    return stub.updateUrlListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single UrlList.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UrlListName name = UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]");
   *   networkSecurityClient.deleteUrlListAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the UrlList to delete. Must be in the format
   *     `projects/&#42;/locations/{location}/urlLists/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteUrlListAsync(UrlListName name) {
    DeleteUrlListRequest request =
        DeleteUrlListRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteUrlListAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single UrlList.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name = UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]").toString();
   *   networkSecurityClient.deleteUrlListAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the UrlList to delete. Must be in the format
   *     `projects/&#42;/locations/{location}/urlLists/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteUrlListAsync(String name) {
    DeleteUrlListRequest request = DeleteUrlListRequest.newBuilder().setName(name).build();
    return deleteUrlListAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single UrlList.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteUrlListRequest request =
   *       DeleteUrlListRequest.newBuilder()
   *           .setName(UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]").toString())
   *           .build();
   *   networkSecurityClient.deleteUrlListAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteUrlListAsync(
      DeleteUrlListRequest request) {
    return deleteUrlListOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single UrlList.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteUrlListRequest request =
   *       DeleteUrlListRequest.newBuilder()
   *           .setName(UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkSecurityClient.deleteUrlListOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteUrlListRequest, Empty, OperationMetadata>
      deleteUrlListOperationCallable() {
    return stub.deleteUrlListOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single UrlList.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteUrlListRequest request =
   *       DeleteUrlListRequest.newBuilder()
   *           .setName(UrlListName.of("[PROJECT]", "[LOCATION]", "[URL_LIST]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.deleteUrlListCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteUrlListRequest, Operation> deleteUrlListCallable() {
    return stub.deleteUrlListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TlsInspectionPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (TlsInspectionPolicy element :
   *       networkSecurityClient.listTlsInspectionPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the TlsInspectionPolicies should be
   *     listed, specified in the format `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTlsInspectionPoliciesPagedResponse listTlsInspectionPolicies(
      LocationName parent) {
    ListTlsInspectionPoliciesRequest request =
        ListTlsInspectionPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTlsInspectionPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TlsInspectionPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (TlsInspectionPolicy element :
   *       networkSecurityClient.listTlsInspectionPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the TlsInspectionPolicies should be
   *     listed, specified in the format `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTlsInspectionPoliciesPagedResponse listTlsInspectionPolicies(String parent) {
    ListTlsInspectionPoliciesRequest request =
        ListTlsInspectionPoliciesRequest.newBuilder().setParent(parent).build();
    return listTlsInspectionPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TlsInspectionPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListTlsInspectionPoliciesRequest request =
   *       ListTlsInspectionPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TlsInspectionPolicy element :
   *       networkSecurityClient.listTlsInspectionPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTlsInspectionPoliciesPagedResponse listTlsInspectionPolicies(
      ListTlsInspectionPoliciesRequest request) {
    return listTlsInspectionPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TlsInspectionPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListTlsInspectionPoliciesRequest request =
   *       ListTlsInspectionPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TlsInspectionPolicy> future =
   *       networkSecurityClient.listTlsInspectionPoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TlsInspectionPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListTlsInspectionPoliciesRequest, ListTlsInspectionPoliciesPagedResponse>
      listTlsInspectionPoliciesPagedCallable() {
    return stub.listTlsInspectionPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TlsInspectionPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListTlsInspectionPoliciesRequest request =
   *       ListTlsInspectionPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTlsInspectionPoliciesResponse response =
   *         networkSecurityClient.listTlsInspectionPoliciesCallable().call(request);
   *     for (TlsInspectionPolicy element : response.getTlsInspectionPoliciesList()) {
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
  public final UnaryCallable<ListTlsInspectionPoliciesRequest, ListTlsInspectionPoliciesResponse>
      listTlsInspectionPoliciesCallable() {
    return stub.listTlsInspectionPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TlsInspectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   TlsInspectionPolicyName name =
   *       TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]");
   *   TlsInspectionPolicy response = networkSecurityClient.getTlsInspectionPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the TlsInspectionPolicy to get. Must be in the format
   *     `projects/{project}/locations/{location}/tlsInspectionPolicies/{tls_inspection_policy}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TlsInspectionPolicy getTlsInspectionPolicy(TlsInspectionPolicyName name) {
    GetTlsInspectionPolicyRequest request =
        GetTlsInspectionPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTlsInspectionPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TlsInspectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name =
   *       TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
   *           .toString();
   *   TlsInspectionPolicy response = networkSecurityClient.getTlsInspectionPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the TlsInspectionPolicy to get. Must be in the format
   *     `projects/{project}/locations/{location}/tlsInspectionPolicies/{tls_inspection_policy}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TlsInspectionPolicy getTlsInspectionPolicy(String name) {
    GetTlsInspectionPolicyRequest request =
        GetTlsInspectionPolicyRequest.newBuilder().setName(name).build();
    return getTlsInspectionPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TlsInspectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetTlsInspectionPolicyRequest request =
   *       GetTlsInspectionPolicyRequest.newBuilder()
   *           .setName(
   *               TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
   *                   .toString())
   *           .build();
   *   TlsInspectionPolicy response = networkSecurityClient.getTlsInspectionPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TlsInspectionPolicy getTlsInspectionPolicy(GetTlsInspectionPolicyRequest request) {
    return getTlsInspectionPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TlsInspectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetTlsInspectionPolicyRequest request =
   *       GetTlsInspectionPolicyRequest.newBuilder()
   *           .setName(
   *               TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<TlsInspectionPolicy> future =
   *       networkSecurityClient.getTlsInspectionPolicyCallable().futureCall(request);
   *   // Do something.
   *   TlsInspectionPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTlsInspectionPolicyRequest, TlsInspectionPolicy>
      getTlsInspectionPolicyCallable() {
    return stub.getTlsInspectionPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TlsInspectionPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   TlsInspectionPolicy tlsInspectionPolicy = TlsInspectionPolicy.newBuilder().build();
   *   String tlsInspectionPolicyId = "tlsInspectionPolicyId-647545892";
   *   TlsInspectionPolicy response =
   *       networkSecurityClient
   *           .createTlsInspectionPolicyAsync(parent, tlsInspectionPolicy, tlsInspectionPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the TlsInspectionPolicy. Must be in the format
   *     `projects/{project}/locations/{location}`.
   * @param tlsInspectionPolicy Required. TlsInspectionPolicy resource to be created.
   * @param tlsInspectionPolicyId Required. Short name of the TlsInspectionPolicy resource to be
   *     created. This value should be 1-63 characters long, containing only letters, numbers,
   *     hyphens, and underscores, and should not start with a number. E.g.
   *     "tls_inspection_policy1".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TlsInspectionPolicy, OperationMetadata>
      createTlsInspectionPolicyAsync(
          LocationName parent,
          TlsInspectionPolicy tlsInspectionPolicy,
          String tlsInspectionPolicyId) {
    CreateTlsInspectionPolicyRequest request =
        CreateTlsInspectionPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTlsInspectionPolicy(tlsInspectionPolicy)
            .setTlsInspectionPolicyId(tlsInspectionPolicyId)
            .build();
    return createTlsInspectionPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TlsInspectionPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   TlsInspectionPolicy tlsInspectionPolicy = TlsInspectionPolicy.newBuilder().build();
   *   String tlsInspectionPolicyId = "tlsInspectionPolicyId-647545892";
   *   TlsInspectionPolicy response =
   *       networkSecurityClient
   *           .createTlsInspectionPolicyAsync(parent, tlsInspectionPolicy, tlsInspectionPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the TlsInspectionPolicy. Must be in the format
   *     `projects/{project}/locations/{location}`.
   * @param tlsInspectionPolicy Required. TlsInspectionPolicy resource to be created.
   * @param tlsInspectionPolicyId Required. Short name of the TlsInspectionPolicy resource to be
   *     created. This value should be 1-63 characters long, containing only letters, numbers,
   *     hyphens, and underscores, and should not start with a number. E.g.
   *     "tls_inspection_policy1".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TlsInspectionPolicy, OperationMetadata>
      createTlsInspectionPolicyAsync(
          String parent, TlsInspectionPolicy tlsInspectionPolicy, String tlsInspectionPolicyId) {
    CreateTlsInspectionPolicyRequest request =
        CreateTlsInspectionPolicyRequest.newBuilder()
            .setParent(parent)
            .setTlsInspectionPolicy(tlsInspectionPolicy)
            .setTlsInspectionPolicyId(tlsInspectionPolicyId)
            .build();
    return createTlsInspectionPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TlsInspectionPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateTlsInspectionPolicyRequest request =
   *       CreateTlsInspectionPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTlsInspectionPolicyId("tlsInspectionPolicyId-647545892")
   *           .setTlsInspectionPolicy(TlsInspectionPolicy.newBuilder().build())
   *           .build();
   *   TlsInspectionPolicy response =
   *       networkSecurityClient.createTlsInspectionPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TlsInspectionPolicy, OperationMetadata>
      createTlsInspectionPolicyAsync(CreateTlsInspectionPolicyRequest request) {
    return createTlsInspectionPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TlsInspectionPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateTlsInspectionPolicyRequest request =
   *       CreateTlsInspectionPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTlsInspectionPolicyId("tlsInspectionPolicyId-647545892")
   *           .setTlsInspectionPolicy(TlsInspectionPolicy.newBuilder().build())
   *           .build();
   *   OperationFuture<TlsInspectionPolicy, OperationMetadata> future =
   *       networkSecurityClient.createTlsInspectionPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   TlsInspectionPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
      createTlsInspectionPolicyOperationCallable() {
    return stub.createTlsInspectionPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TlsInspectionPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateTlsInspectionPolicyRequest request =
   *       CreateTlsInspectionPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTlsInspectionPolicyId("tlsInspectionPolicyId-647545892")
   *           .setTlsInspectionPolicy(TlsInspectionPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.createTlsInspectionPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTlsInspectionPolicyRequest, Operation>
      createTlsInspectionPolicyCallable() {
    return stub.createTlsInspectionPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TlsInspectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   TlsInspectionPolicy tlsInspectionPolicy = TlsInspectionPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TlsInspectionPolicy response =
   *       networkSecurityClient
   *           .updateTlsInspectionPolicyAsync(tlsInspectionPolicy, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param tlsInspectionPolicy Required. Updated TlsInspectionPolicy resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     TlsInspectionPolicy resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TlsInspectionPolicy, OperationMetadata>
      updateTlsInspectionPolicyAsync(
          TlsInspectionPolicy tlsInspectionPolicy, FieldMask updateMask) {
    UpdateTlsInspectionPolicyRequest request =
        UpdateTlsInspectionPolicyRequest.newBuilder()
            .setTlsInspectionPolicy(tlsInspectionPolicy)
            .setUpdateMask(updateMask)
            .build();
    return updateTlsInspectionPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TlsInspectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateTlsInspectionPolicyRequest request =
   *       UpdateTlsInspectionPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTlsInspectionPolicy(TlsInspectionPolicy.newBuilder().build())
   *           .build();
   *   TlsInspectionPolicy response =
   *       networkSecurityClient.updateTlsInspectionPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TlsInspectionPolicy, OperationMetadata>
      updateTlsInspectionPolicyAsync(UpdateTlsInspectionPolicyRequest request) {
    return updateTlsInspectionPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TlsInspectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateTlsInspectionPolicyRequest request =
   *       UpdateTlsInspectionPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTlsInspectionPolicy(TlsInspectionPolicy.newBuilder().build())
   *           .build();
   *   OperationFuture<TlsInspectionPolicy, OperationMetadata> future =
   *       networkSecurityClient.updateTlsInspectionPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   TlsInspectionPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
      updateTlsInspectionPolicyOperationCallable() {
    return stub.updateTlsInspectionPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TlsInspectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateTlsInspectionPolicyRequest request =
   *       UpdateTlsInspectionPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTlsInspectionPolicy(TlsInspectionPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.updateTlsInspectionPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTlsInspectionPolicyRequest, Operation>
      updateTlsInspectionPolicyCallable() {
    return stub.updateTlsInspectionPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TlsInspectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   TlsInspectionPolicyName name =
   *       TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]");
   *   networkSecurityClient.deleteTlsInspectionPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the TlsInspectionPolicy to delete. Must be in the format
   *     `projects/{project}/locations/{location}/tlsInspectionPolicies/{tls_inspection_policy}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTlsInspectionPolicyAsync(
      TlsInspectionPolicyName name) {
    DeleteTlsInspectionPolicyRequest request =
        DeleteTlsInspectionPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteTlsInspectionPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TlsInspectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name =
   *       TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
   *           .toString();
   *   networkSecurityClient.deleteTlsInspectionPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the TlsInspectionPolicy to delete. Must be in the format
   *     `projects/{project}/locations/{location}/tlsInspectionPolicies/{tls_inspection_policy}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTlsInspectionPolicyAsync(
      String name) {
    DeleteTlsInspectionPolicyRequest request =
        DeleteTlsInspectionPolicyRequest.newBuilder().setName(name).build();
    return deleteTlsInspectionPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TlsInspectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteTlsInspectionPolicyRequest request =
   *       DeleteTlsInspectionPolicyRequest.newBuilder()
   *           .setName(
   *               TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   networkSecurityClient.deleteTlsInspectionPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTlsInspectionPolicyAsync(
      DeleteTlsInspectionPolicyRequest request) {
    return deleteTlsInspectionPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TlsInspectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteTlsInspectionPolicyRequest request =
   *       DeleteTlsInspectionPolicyRequest.newBuilder()
   *           .setName(
   *               TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkSecurityClient.deleteTlsInspectionPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTlsInspectionPolicyRequest, Empty, OperationMetadata>
      deleteTlsInspectionPolicyOperationCallable() {
    return stub.deleteTlsInspectionPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TlsInspectionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteTlsInspectionPolicyRequest request =
   *       DeleteTlsInspectionPolicyRequest.newBuilder()
   *           .setName(
   *               TlsInspectionPolicyName.of("[PROJECT]", "[LOCATION]", "[TLS_INSPECTION_POLICY]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.deleteTlsInspectionPolicyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTlsInspectionPolicyRequest, Operation>
      deleteTlsInspectionPolicyCallable() {
    return stub.deleteTlsInspectionPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AuthzPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AuthzPolicy element : networkSecurityClient.listAuthzPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the `AuthzPolicy` resources are
   *     listed, specified in the following format: `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthzPoliciesPagedResponse listAuthzPolicies(LocationName parent) {
    ListAuthzPoliciesRequest request =
        ListAuthzPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAuthzPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AuthzPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AuthzPolicy element : networkSecurityClient.listAuthzPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the `AuthzPolicy` resources are
   *     listed, specified in the following format: `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthzPoliciesPagedResponse listAuthzPolicies(String parent) {
    ListAuthzPoliciesRequest request =
        ListAuthzPoliciesRequest.newBuilder().setParent(parent).build();
    return listAuthzPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AuthzPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListAuthzPoliciesRequest request =
   *       ListAuthzPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (AuthzPolicy element : networkSecurityClient.listAuthzPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthzPoliciesPagedResponse listAuthzPolicies(ListAuthzPoliciesRequest request) {
    return listAuthzPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AuthzPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListAuthzPoliciesRequest request =
   *       ListAuthzPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<AuthzPolicy> future =
   *       networkSecurityClient.listAuthzPoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AuthzPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAuthzPoliciesRequest, ListAuthzPoliciesPagedResponse>
      listAuthzPoliciesPagedCallable() {
    return stub.listAuthzPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AuthzPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListAuthzPoliciesRequest request =
   *       ListAuthzPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAuthzPoliciesResponse response =
   *         networkSecurityClient.listAuthzPoliciesCallable().call(request);
   *     for (AuthzPolicy element : response.getAuthzPoliciesList()) {
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
  public final UnaryCallable<ListAuthzPoliciesRequest, ListAuthzPoliciesResponse>
      listAuthzPoliciesCallable() {
    return stub.listAuthzPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AuthzPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   AuthzPolicyName name = AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]");
   *   AuthzPolicy response = networkSecurityClient.getAuthzPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the `AuthzPolicy` resource to get. Must be in the format
   *     `projects/{project}/locations/{location}/authzPolicies/{authz_policy}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthzPolicy getAuthzPolicy(AuthzPolicyName name) {
    GetAuthzPolicyRequest request =
        GetAuthzPolicyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAuthzPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AuthzPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name = AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]").toString();
   *   AuthzPolicy response = networkSecurityClient.getAuthzPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the `AuthzPolicy` resource to get. Must be in the format
   *     `projects/{project}/locations/{location}/authzPolicies/{authz_policy}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthzPolicy getAuthzPolicy(String name) {
    GetAuthzPolicyRequest request = GetAuthzPolicyRequest.newBuilder().setName(name).build();
    return getAuthzPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AuthzPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetAuthzPolicyRequest request =
   *       GetAuthzPolicyRequest.newBuilder()
   *           .setName(AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]").toString())
   *           .build();
   *   AuthzPolicy response = networkSecurityClient.getAuthzPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthzPolicy getAuthzPolicy(GetAuthzPolicyRequest request) {
    return getAuthzPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AuthzPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetAuthzPolicyRequest request =
   *       GetAuthzPolicyRequest.newBuilder()
   *           .setName(AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]").toString())
   *           .build();
   *   ApiFuture<AuthzPolicy> future =
   *       networkSecurityClient.getAuthzPolicyCallable().futureCall(request);
   *   // Do something.
   *   AuthzPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAuthzPolicyRequest, AuthzPolicy> getAuthzPolicyCallable() {
    return stub.getAuthzPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AuthzPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AuthzPolicy authzPolicy = AuthzPolicy.newBuilder().build();
   *   String authzPolicyId = "authzPolicyId1717400543";
   *   AuthzPolicy response =
   *       networkSecurityClient.createAuthzPolicyAsync(parent, authzPolicy, authzPolicyId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the `AuthzPolicy` resource. Must be in the
   *     format `projects/{project}/locations/{location}`.
   * @param authzPolicy Required. `AuthzPolicy` resource to be created.
   * @param authzPolicyId Required. User-provided ID of the `AuthzPolicy` resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AuthzPolicy, OperationMetadata> createAuthzPolicyAsync(
      LocationName parent, AuthzPolicy authzPolicy, String authzPolicyId) {
    CreateAuthzPolicyRequest request =
        CreateAuthzPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAuthzPolicy(authzPolicy)
            .setAuthzPolicyId(authzPolicyId)
            .build();
    return createAuthzPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AuthzPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AuthzPolicy authzPolicy = AuthzPolicy.newBuilder().build();
   *   String authzPolicyId = "authzPolicyId1717400543";
   *   AuthzPolicy response =
   *       networkSecurityClient.createAuthzPolicyAsync(parent, authzPolicy, authzPolicyId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the `AuthzPolicy` resource. Must be in the
   *     format `projects/{project}/locations/{location}`.
   * @param authzPolicy Required. `AuthzPolicy` resource to be created.
   * @param authzPolicyId Required. User-provided ID of the `AuthzPolicy` resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AuthzPolicy, OperationMetadata> createAuthzPolicyAsync(
      String parent, AuthzPolicy authzPolicy, String authzPolicyId) {
    CreateAuthzPolicyRequest request =
        CreateAuthzPolicyRequest.newBuilder()
            .setParent(parent)
            .setAuthzPolicy(authzPolicy)
            .setAuthzPolicyId(authzPolicyId)
            .build();
    return createAuthzPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AuthzPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateAuthzPolicyRequest request =
   *       CreateAuthzPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAuthzPolicyId("authzPolicyId1717400543")
   *           .setAuthzPolicy(AuthzPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AuthzPolicy response = networkSecurityClient.createAuthzPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AuthzPolicy, OperationMetadata> createAuthzPolicyAsync(
      CreateAuthzPolicyRequest request) {
    return createAuthzPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AuthzPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateAuthzPolicyRequest request =
   *       CreateAuthzPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAuthzPolicyId("authzPolicyId1717400543")
   *           .setAuthzPolicy(AuthzPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<AuthzPolicy, OperationMetadata> future =
   *       networkSecurityClient.createAuthzPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   AuthzPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
      createAuthzPolicyOperationCallable() {
    return stub.createAuthzPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AuthzPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   CreateAuthzPolicyRequest request =
   *       CreateAuthzPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAuthzPolicyId("authzPolicyId1717400543")
   *           .setAuthzPolicy(AuthzPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.createAuthzPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAuthzPolicyRequest, Operation> createAuthzPolicyCallable() {
    return stub.createAuthzPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AuthzPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   AuthzPolicy authzPolicy = AuthzPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AuthzPolicy response =
   *       networkSecurityClient.updateAuthzPolicyAsync(authzPolicy, updateMask).get();
   * }
   * }</pre>
   *
   * @param authzPolicy Required. `AuthzPolicy` resource being updated.
   * @param updateMask Required. Used to specify the fields to be overwritten in the `AuthzPolicy`
   *     resource by the update. The fields specified in the `update_mask` are relative to the
   *     resource, not the full request. A field is overwritten if it is in the mask. If the user
   *     does not specify a mask, then all fields are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AuthzPolicy, OperationMetadata> updateAuthzPolicyAsync(
      AuthzPolicy authzPolicy, FieldMask updateMask) {
    UpdateAuthzPolicyRequest request =
        UpdateAuthzPolicyRequest.newBuilder()
            .setAuthzPolicy(authzPolicy)
            .setUpdateMask(updateMask)
            .build();
    return updateAuthzPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AuthzPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateAuthzPolicyRequest request =
   *       UpdateAuthzPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAuthzPolicy(AuthzPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AuthzPolicy response = networkSecurityClient.updateAuthzPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AuthzPolicy, OperationMetadata> updateAuthzPolicyAsync(
      UpdateAuthzPolicyRequest request) {
    return updateAuthzPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AuthzPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateAuthzPolicyRequest request =
   *       UpdateAuthzPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAuthzPolicy(AuthzPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<AuthzPolicy, OperationMetadata> future =
   *       networkSecurityClient.updateAuthzPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   AuthzPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
      updateAuthzPolicyOperationCallable() {
    return stub.updateAuthzPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AuthzPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   UpdateAuthzPolicyRequest request =
   *       UpdateAuthzPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAuthzPolicy(AuthzPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.updateAuthzPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAuthzPolicyRequest, Operation> updateAuthzPolicyCallable() {
    return stub.updateAuthzPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AuthzPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   AuthzPolicyName name = AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]");
   *   networkSecurityClient.deleteAuthzPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `AuthzPolicy` resource to delete. Must be in the format
   *     `projects/{project}/locations/{location}/authzPolicies/{authz_policy}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAuthzPolicyAsync(
      AuthzPolicyName name) {
    DeleteAuthzPolicyRequest request =
        DeleteAuthzPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteAuthzPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AuthzPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   String name = AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]").toString();
   *   networkSecurityClient.deleteAuthzPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `AuthzPolicy` resource to delete. Must be in the format
   *     `projects/{project}/locations/{location}/authzPolicies/{authz_policy}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAuthzPolicyAsync(String name) {
    DeleteAuthzPolicyRequest request = DeleteAuthzPolicyRequest.newBuilder().setName(name).build();
    return deleteAuthzPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AuthzPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteAuthzPolicyRequest request =
   *       DeleteAuthzPolicyRequest.newBuilder()
   *           .setName(AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   networkSecurityClient.deleteAuthzPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAuthzPolicyAsync(
      DeleteAuthzPolicyRequest request) {
    return deleteAuthzPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AuthzPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteAuthzPolicyRequest request =
   *       DeleteAuthzPolicyRequest.newBuilder()
   *           .setName(AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkSecurityClient.deleteAuthzPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAuthzPolicyRequest, Empty, OperationMetadata>
      deleteAuthzPolicyOperationCallable() {
    return stub.deleteAuthzPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AuthzPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   DeleteAuthzPolicyRequest request =
   *       DeleteAuthzPolicyRequest.newBuilder()
   *           .setName(AuthzPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHZ_POLICY]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkSecurityClient.deleteAuthzPolicyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAuthzPolicyRequest, Operation> deleteAuthzPolicyCallable() {
    return stub.deleteAuthzPolicyCallable();
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
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : networkSecurityClient.listLocations(request).iterateAll()) {
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
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       networkSecurityClient.listLocationsPagedCallable().futureCall(request);
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
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         networkSecurityClient.listLocationsCallable().call(request);
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
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = networkSecurityClient.getLocation(request);
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
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = networkSecurityClient.getLocationCallable().futureCall(request);
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
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = networkSecurityClient.setIamPolicy(request);
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
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = networkSecurityClient.setIamPolicyCallable().futureCall(request);
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
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = networkSecurityClient.getIamPolicy(request);
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
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = networkSecurityClient.getIamPolicyCallable().futureCall(request);
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
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = networkSecurityClient.testIamPermissions(request);
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
   * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AddressGroupName.ofProjectLocationAddressGroupName(
   *                       "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       networkSecurityClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListAuthorizationPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListAuthorizationPoliciesRequest,
          ListAuthorizationPoliciesResponse,
          AuthorizationPolicy,
          ListAuthorizationPoliciesPage,
          ListAuthorizationPoliciesFixedSizeCollection> {

    public static ApiFuture<ListAuthorizationPoliciesPagedResponse> createAsync(
        PageContext<
                ListAuthorizationPoliciesRequest,
                ListAuthorizationPoliciesResponse,
                AuthorizationPolicy>
            context,
        ApiFuture<ListAuthorizationPoliciesResponse> futureResponse) {
      ApiFuture<ListAuthorizationPoliciesPage> futurePage =
          ListAuthorizationPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAuthorizationPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAuthorizationPoliciesPagedResponse(ListAuthorizationPoliciesPage page) {
      super(page, ListAuthorizationPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAuthorizationPoliciesPage
      extends AbstractPage<
          ListAuthorizationPoliciesRequest,
          ListAuthorizationPoliciesResponse,
          AuthorizationPolicy,
          ListAuthorizationPoliciesPage> {

    private ListAuthorizationPoliciesPage(
        PageContext<
                ListAuthorizationPoliciesRequest,
                ListAuthorizationPoliciesResponse,
                AuthorizationPolicy>
            context,
        ListAuthorizationPoliciesResponse response) {
      super(context, response);
    }

    private static ListAuthorizationPoliciesPage createEmptyPage() {
      return new ListAuthorizationPoliciesPage(null, null);
    }

    @Override
    protected ListAuthorizationPoliciesPage createPage(
        PageContext<
                ListAuthorizationPoliciesRequest,
                ListAuthorizationPoliciesResponse,
                AuthorizationPolicy>
            context,
        ListAuthorizationPoliciesResponse response) {
      return new ListAuthorizationPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListAuthorizationPoliciesPage> createPageAsync(
        PageContext<
                ListAuthorizationPoliciesRequest,
                ListAuthorizationPoliciesResponse,
                AuthorizationPolicy>
            context,
        ApiFuture<ListAuthorizationPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAuthorizationPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAuthorizationPoliciesRequest,
          ListAuthorizationPoliciesResponse,
          AuthorizationPolicy,
          ListAuthorizationPoliciesPage,
          ListAuthorizationPoliciesFixedSizeCollection> {

    private ListAuthorizationPoliciesFixedSizeCollection(
        List<ListAuthorizationPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAuthorizationPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListAuthorizationPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAuthorizationPoliciesFixedSizeCollection createCollection(
        List<ListAuthorizationPoliciesPage> pages, int collectionSize) {
      return new ListAuthorizationPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBackendAuthenticationConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListBackendAuthenticationConfigsRequest,
          ListBackendAuthenticationConfigsResponse,
          BackendAuthenticationConfig,
          ListBackendAuthenticationConfigsPage,
          ListBackendAuthenticationConfigsFixedSizeCollection> {

    public static ApiFuture<ListBackendAuthenticationConfigsPagedResponse> createAsync(
        PageContext<
                ListBackendAuthenticationConfigsRequest,
                ListBackendAuthenticationConfigsResponse,
                BackendAuthenticationConfig>
            context,
        ApiFuture<ListBackendAuthenticationConfigsResponse> futureResponse) {
      ApiFuture<ListBackendAuthenticationConfigsPage> futurePage =
          ListBackendAuthenticationConfigsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBackendAuthenticationConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBackendAuthenticationConfigsPagedResponse(
        ListBackendAuthenticationConfigsPage page) {
      super(page, ListBackendAuthenticationConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackendAuthenticationConfigsPage
      extends AbstractPage<
          ListBackendAuthenticationConfigsRequest,
          ListBackendAuthenticationConfigsResponse,
          BackendAuthenticationConfig,
          ListBackendAuthenticationConfigsPage> {

    private ListBackendAuthenticationConfigsPage(
        PageContext<
                ListBackendAuthenticationConfigsRequest,
                ListBackendAuthenticationConfigsResponse,
                BackendAuthenticationConfig>
            context,
        ListBackendAuthenticationConfigsResponse response) {
      super(context, response);
    }

    private static ListBackendAuthenticationConfigsPage createEmptyPage() {
      return new ListBackendAuthenticationConfigsPage(null, null);
    }

    @Override
    protected ListBackendAuthenticationConfigsPage createPage(
        PageContext<
                ListBackendAuthenticationConfigsRequest,
                ListBackendAuthenticationConfigsResponse,
                BackendAuthenticationConfig>
            context,
        ListBackendAuthenticationConfigsResponse response) {
      return new ListBackendAuthenticationConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackendAuthenticationConfigsPage> createPageAsync(
        PageContext<
                ListBackendAuthenticationConfigsRequest,
                ListBackendAuthenticationConfigsResponse,
                BackendAuthenticationConfig>
            context,
        ApiFuture<ListBackendAuthenticationConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackendAuthenticationConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackendAuthenticationConfigsRequest,
          ListBackendAuthenticationConfigsResponse,
          BackendAuthenticationConfig,
          ListBackendAuthenticationConfigsPage,
          ListBackendAuthenticationConfigsFixedSizeCollection> {

    private ListBackendAuthenticationConfigsFixedSizeCollection(
        List<ListBackendAuthenticationConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackendAuthenticationConfigsFixedSizeCollection createEmptyCollection() {
      return new ListBackendAuthenticationConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackendAuthenticationConfigsFixedSizeCollection createCollection(
        List<ListBackendAuthenticationConfigsPage> pages, int collectionSize) {
      return new ListBackendAuthenticationConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListServerTlsPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListServerTlsPoliciesRequest,
          ListServerTlsPoliciesResponse,
          ServerTlsPolicy,
          ListServerTlsPoliciesPage,
          ListServerTlsPoliciesFixedSizeCollection> {

    public static ApiFuture<ListServerTlsPoliciesPagedResponse> createAsync(
        PageContext<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse, ServerTlsPolicy>
            context,
        ApiFuture<ListServerTlsPoliciesResponse> futureResponse) {
      ApiFuture<ListServerTlsPoliciesPage> futurePage =
          ListServerTlsPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListServerTlsPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListServerTlsPoliciesPagedResponse(ListServerTlsPoliciesPage page) {
      super(page, ListServerTlsPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListServerTlsPoliciesPage
      extends AbstractPage<
          ListServerTlsPoliciesRequest,
          ListServerTlsPoliciesResponse,
          ServerTlsPolicy,
          ListServerTlsPoliciesPage> {

    private ListServerTlsPoliciesPage(
        PageContext<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse, ServerTlsPolicy>
            context,
        ListServerTlsPoliciesResponse response) {
      super(context, response);
    }

    private static ListServerTlsPoliciesPage createEmptyPage() {
      return new ListServerTlsPoliciesPage(null, null);
    }

    @Override
    protected ListServerTlsPoliciesPage createPage(
        PageContext<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse, ServerTlsPolicy>
            context,
        ListServerTlsPoliciesResponse response) {
      return new ListServerTlsPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListServerTlsPoliciesPage> createPageAsync(
        PageContext<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse, ServerTlsPolicy>
            context,
        ApiFuture<ListServerTlsPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListServerTlsPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListServerTlsPoliciesRequest,
          ListServerTlsPoliciesResponse,
          ServerTlsPolicy,
          ListServerTlsPoliciesPage,
          ListServerTlsPoliciesFixedSizeCollection> {

    private ListServerTlsPoliciesFixedSizeCollection(
        List<ListServerTlsPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListServerTlsPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListServerTlsPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListServerTlsPoliciesFixedSizeCollection createCollection(
        List<ListServerTlsPoliciesPage> pages, int collectionSize) {
      return new ListServerTlsPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListClientTlsPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListClientTlsPoliciesRequest,
          ListClientTlsPoliciesResponse,
          ClientTlsPolicy,
          ListClientTlsPoliciesPage,
          ListClientTlsPoliciesFixedSizeCollection> {

    public static ApiFuture<ListClientTlsPoliciesPagedResponse> createAsync(
        PageContext<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse, ClientTlsPolicy>
            context,
        ApiFuture<ListClientTlsPoliciesResponse> futureResponse) {
      ApiFuture<ListClientTlsPoliciesPage> futurePage =
          ListClientTlsPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListClientTlsPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListClientTlsPoliciesPagedResponse(ListClientTlsPoliciesPage page) {
      super(page, ListClientTlsPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListClientTlsPoliciesPage
      extends AbstractPage<
          ListClientTlsPoliciesRequest,
          ListClientTlsPoliciesResponse,
          ClientTlsPolicy,
          ListClientTlsPoliciesPage> {

    private ListClientTlsPoliciesPage(
        PageContext<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse, ClientTlsPolicy>
            context,
        ListClientTlsPoliciesResponse response) {
      super(context, response);
    }

    private static ListClientTlsPoliciesPage createEmptyPage() {
      return new ListClientTlsPoliciesPage(null, null);
    }

    @Override
    protected ListClientTlsPoliciesPage createPage(
        PageContext<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse, ClientTlsPolicy>
            context,
        ListClientTlsPoliciesResponse response) {
      return new ListClientTlsPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListClientTlsPoliciesPage> createPageAsync(
        PageContext<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse, ClientTlsPolicy>
            context,
        ApiFuture<ListClientTlsPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListClientTlsPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListClientTlsPoliciesRequest,
          ListClientTlsPoliciesResponse,
          ClientTlsPolicy,
          ListClientTlsPoliciesPage,
          ListClientTlsPoliciesFixedSizeCollection> {

    private ListClientTlsPoliciesFixedSizeCollection(
        List<ListClientTlsPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListClientTlsPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListClientTlsPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListClientTlsPoliciesFixedSizeCollection createCollection(
        List<ListClientTlsPoliciesPage> pages, int collectionSize) {
      return new ListClientTlsPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGatewaySecurityPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListGatewaySecurityPoliciesRequest,
          ListGatewaySecurityPoliciesResponse,
          GatewaySecurityPolicy,
          ListGatewaySecurityPoliciesPage,
          ListGatewaySecurityPoliciesFixedSizeCollection> {

    public static ApiFuture<ListGatewaySecurityPoliciesPagedResponse> createAsync(
        PageContext<
                ListGatewaySecurityPoliciesRequest,
                ListGatewaySecurityPoliciesResponse,
                GatewaySecurityPolicy>
            context,
        ApiFuture<ListGatewaySecurityPoliciesResponse> futureResponse) {
      ApiFuture<ListGatewaySecurityPoliciesPage> futurePage =
          ListGatewaySecurityPoliciesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGatewaySecurityPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGatewaySecurityPoliciesPagedResponse(ListGatewaySecurityPoliciesPage page) {
      super(page, ListGatewaySecurityPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGatewaySecurityPoliciesPage
      extends AbstractPage<
          ListGatewaySecurityPoliciesRequest,
          ListGatewaySecurityPoliciesResponse,
          GatewaySecurityPolicy,
          ListGatewaySecurityPoliciesPage> {

    private ListGatewaySecurityPoliciesPage(
        PageContext<
                ListGatewaySecurityPoliciesRequest,
                ListGatewaySecurityPoliciesResponse,
                GatewaySecurityPolicy>
            context,
        ListGatewaySecurityPoliciesResponse response) {
      super(context, response);
    }

    private static ListGatewaySecurityPoliciesPage createEmptyPage() {
      return new ListGatewaySecurityPoliciesPage(null, null);
    }

    @Override
    protected ListGatewaySecurityPoliciesPage createPage(
        PageContext<
                ListGatewaySecurityPoliciesRequest,
                ListGatewaySecurityPoliciesResponse,
                GatewaySecurityPolicy>
            context,
        ListGatewaySecurityPoliciesResponse response) {
      return new ListGatewaySecurityPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListGatewaySecurityPoliciesPage> createPageAsync(
        PageContext<
                ListGatewaySecurityPoliciesRequest,
                ListGatewaySecurityPoliciesResponse,
                GatewaySecurityPolicy>
            context,
        ApiFuture<ListGatewaySecurityPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGatewaySecurityPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGatewaySecurityPoliciesRequest,
          ListGatewaySecurityPoliciesResponse,
          GatewaySecurityPolicy,
          ListGatewaySecurityPoliciesPage,
          ListGatewaySecurityPoliciesFixedSizeCollection> {

    private ListGatewaySecurityPoliciesFixedSizeCollection(
        List<ListGatewaySecurityPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGatewaySecurityPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListGatewaySecurityPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGatewaySecurityPoliciesFixedSizeCollection createCollection(
        List<ListGatewaySecurityPoliciesPage> pages, int collectionSize) {
      return new ListGatewaySecurityPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGatewaySecurityPolicyRulesPagedResponse
      extends AbstractPagedListResponse<
          ListGatewaySecurityPolicyRulesRequest,
          ListGatewaySecurityPolicyRulesResponse,
          GatewaySecurityPolicyRule,
          ListGatewaySecurityPolicyRulesPage,
          ListGatewaySecurityPolicyRulesFixedSizeCollection> {

    public static ApiFuture<ListGatewaySecurityPolicyRulesPagedResponse> createAsync(
        PageContext<
                ListGatewaySecurityPolicyRulesRequest,
                ListGatewaySecurityPolicyRulesResponse,
                GatewaySecurityPolicyRule>
            context,
        ApiFuture<ListGatewaySecurityPolicyRulesResponse> futureResponse) {
      ApiFuture<ListGatewaySecurityPolicyRulesPage> futurePage =
          ListGatewaySecurityPolicyRulesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGatewaySecurityPolicyRulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGatewaySecurityPolicyRulesPagedResponse(ListGatewaySecurityPolicyRulesPage page) {
      super(page, ListGatewaySecurityPolicyRulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGatewaySecurityPolicyRulesPage
      extends AbstractPage<
          ListGatewaySecurityPolicyRulesRequest,
          ListGatewaySecurityPolicyRulesResponse,
          GatewaySecurityPolicyRule,
          ListGatewaySecurityPolicyRulesPage> {

    private ListGatewaySecurityPolicyRulesPage(
        PageContext<
                ListGatewaySecurityPolicyRulesRequest,
                ListGatewaySecurityPolicyRulesResponse,
                GatewaySecurityPolicyRule>
            context,
        ListGatewaySecurityPolicyRulesResponse response) {
      super(context, response);
    }

    private static ListGatewaySecurityPolicyRulesPage createEmptyPage() {
      return new ListGatewaySecurityPolicyRulesPage(null, null);
    }

    @Override
    protected ListGatewaySecurityPolicyRulesPage createPage(
        PageContext<
                ListGatewaySecurityPolicyRulesRequest,
                ListGatewaySecurityPolicyRulesResponse,
                GatewaySecurityPolicyRule>
            context,
        ListGatewaySecurityPolicyRulesResponse response) {
      return new ListGatewaySecurityPolicyRulesPage(context, response);
    }

    @Override
    public ApiFuture<ListGatewaySecurityPolicyRulesPage> createPageAsync(
        PageContext<
                ListGatewaySecurityPolicyRulesRequest,
                ListGatewaySecurityPolicyRulesResponse,
                GatewaySecurityPolicyRule>
            context,
        ApiFuture<ListGatewaySecurityPolicyRulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGatewaySecurityPolicyRulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGatewaySecurityPolicyRulesRequest,
          ListGatewaySecurityPolicyRulesResponse,
          GatewaySecurityPolicyRule,
          ListGatewaySecurityPolicyRulesPage,
          ListGatewaySecurityPolicyRulesFixedSizeCollection> {

    private ListGatewaySecurityPolicyRulesFixedSizeCollection(
        List<ListGatewaySecurityPolicyRulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGatewaySecurityPolicyRulesFixedSizeCollection createEmptyCollection() {
      return new ListGatewaySecurityPolicyRulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGatewaySecurityPolicyRulesFixedSizeCollection createCollection(
        List<ListGatewaySecurityPolicyRulesPage> pages, int collectionSize) {
      return new ListGatewaySecurityPolicyRulesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListUrlListsPagedResponse
      extends AbstractPagedListResponse<
          ListUrlListsRequest,
          ListUrlListsResponse,
          UrlList,
          ListUrlListsPage,
          ListUrlListsFixedSizeCollection> {

    public static ApiFuture<ListUrlListsPagedResponse> createAsync(
        PageContext<ListUrlListsRequest, ListUrlListsResponse, UrlList> context,
        ApiFuture<ListUrlListsResponse> futureResponse) {
      ApiFuture<ListUrlListsPage> futurePage =
          ListUrlListsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListUrlListsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListUrlListsPagedResponse(ListUrlListsPage page) {
      super(page, ListUrlListsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUrlListsPage
      extends AbstractPage<ListUrlListsRequest, ListUrlListsResponse, UrlList, ListUrlListsPage> {

    private ListUrlListsPage(
        PageContext<ListUrlListsRequest, ListUrlListsResponse, UrlList> context,
        ListUrlListsResponse response) {
      super(context, response);
    }

    private static ListUrlListsPage createEmptyPage() {
      return new ListUrlListsPage(null, null);
    }

    @Override
    protected ListUrlListsPage createPage(
        PageContext<ListUrlListsRequest, ListUrlListsResponse, UrlList> context,
        ListUrlListsResponse response) {
      return new ListUrlListsPage(context, response);
    }

    @Override
    public ApiFuture<ListUrlListsPage> createPageAsync(
        PageContext<ListUrlListsRequest, ListUrlListsResponse, UrlList> context,
        ApiFuture<ListUrlListsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUrlListsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUrlListsRequest,
          ListUrlListsResponse,
          UrlList,
          ListUrlListsPage,
          ListUrlListsFixedSizeCollection> {

    private ListUrlListsFixedSizeCollection(List<ListUrlListsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUrlListsFixedSizeCollection createEmptyCollection() {
      return new ListUrlListsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUrlListsFixedSizeCollection createCollection(
        List<ListUrlListsPage> pages, int collectionSize) {
      return new ListUrlListsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTlsInspectionPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListTlsInspectionPoliciesRequest,
          ListTlsInspectionPoliciesResponse,
          TlsInspectionPolicy,
          ListTlsInspectionPoliciesPage,
          ListTlsInspectionPoliciesFixedSizeCollection> {

    public static ApiFuture<ListTlsInspectionPoliciesPagedResponse> createAsync(
        PageContext<
                ListTlsInspectionPoliciesRequest,
                ListTlsInspectionPoliciesResponse,
                TlsInspectionPolicy>
            context,
        ApiFuture<ListTlsInspectionPoliciesResponse> futureResponse) {
      ApiFuture<ListTlsInspectionPoliciesPage> futurePage =
          ListTlsInspectionPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTlsInspectionPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTlsInspectionPoliciesPagedResponse(ListTlsInspectionPoliciesPage page) {
      super(page, ListTlsInspectionPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTlsInspectionPoliciesPage
      extends AbstractPage<
          ListTlsInspectionPoliciesRequest,
          ListTlsInspectionPoliciesResponse,
          TlsInspectionPolicy,
          ListTlsInspectionPoliciesPage> {

    private ListTlsInspectionPoliciesPage(
        PageContext<
                ListTlsInspectionPoliciesRequest,
                ListTlsInspectionPoliciesResponse,
                TlsInspectionPolicy>
            context,
        ListTlsInspectionPoliciesResponse response) {
      super(context, response);
    }

    private static ListTlsInspectionPoliciesPage createEmptyPage() {
      return new ListTlsInspectionPoliciesPage(null, null);
    }

    @Override
    protected ListTlsInspectionPoliciesPage createPage(
        PageContext<
                ListTlsInspectionPoliciesRequest,
                ListTlsInspectionPoliciesResponse,
                TlsInspectionPolicy>
            context,
        ListTlsInspectionPoliciesResponse response) {
      return new ListTlsInspectionPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListTlsInspectionPoliciesPage> createPageAsync(
        PageContext<
                ListTlsInspectionPoliciesRequest,
                ListTlsInspectionPoliciesResponse,
                TlsInspectionPolicy>
            context,
        ApiFuture<ListTlsInspectionPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTlsInspectionPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTlsInspectionPoliciesRequest,
          ListTlsInspectionPoliciesResponse,
          TlsInspectionPolicy,
          ListTlsInspectionPoliciesPage,
          ListTlsInspectionPoliciesFixedSizeCollection> {

    private ListTlsInspectionPoliciesFixedSizeCollection(
        List<ListTlsInspectionPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTlsInspectionPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListTlsInspectionPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTlsInspectionPoliciesFixedSizeCollection createCollection(
        List<ListTlsInspectionPoliciesPage> pages, int collectionSize) {
      return new ListTlsInspectionPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAuthzPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListAuthzPoliciesRequest,
          ListAuthzPoliciesResponse,
          AuthzPolicy,
          ListAuthzPoliciesPage,
          ListAuthzPoliciesFixedSizeCollection> {

    public static ApiFuture<ListAuthzPoliciesPagedResponse> createAsync(
        PageContext<ListAuthzPoliciesRequest, ListAuthzPoliciesResponse, AuthzPolicy> context,
        ApiFuture<ListAuthzPoliciesResponse> futureResponse) {
      ApiFuture<ListAuthzPoliciesPage> futurePage =
          ListAuthzPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAuthzPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAuthzPoliciesPagedResponse(ListAuthzPoliciesPage page) {
      super(page, ListAuthzPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAuthzPoliciesPage
      extends AbstractPage<
          ListAuthzPoliciesRequest, ListAuthzPoliciesResponse, AuthzPolicy, ListAuthzPoliciesPage> {

    private ListAuthzPoliciesPage(
        PageContext<ListAuthzPoliciesRequest, ListAuthzPoliciesResponse, AuthzPolicy> context,
        ListAuthzPoliciesResponse response) {
      super(context, response);
    }

    private static ListAuthzPoliciesPage createEmptyPage() {
      return new ListAuthzPoliciesPage(null, null);
    }

    @Override
    protected ListAuthzPoliciesPage createPage(
        PageContext<ListAuthzPoliciesRequest, ListAuthzPoliciesResponse, AuthzPolicy> context,
        ListAuthzPoliciesResponse response) {
      return new ListAuthzPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListAuthzPoliciesPage> createPageAsync(
        PageContext<ListAuthzPoliciesRequest, ListAuthzPoliciesResponse, AuthzPolicy> context,
        ApiFuture<ListAuthzPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAuthzPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAuthzPoliciesRequest,
          ListAuthzPoliciesResponse,
          AuthzPolicy,
          ListAuthzPoliciesPage,
          ListAuthzPoliciesFixedSizeCollection> {

    private ListAuthzPoliciesFixedSizeCollection(
        List<ListAuthzPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAuthzPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListAuthzPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAuthzPoliciesFixedSizeCollection createCollection(
        List<ListAuthzPoliciesPage> pages, int collectionSize) {
      return new ListAuthzPoliciesFixedSizeCollection(pages, collectionSize);
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
