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

package com.google.cloud.agentidentity.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.agentidentity.v1.stub.AuthProviderServiceStub;
import com.google.cloud.agentidentity.v1.stub.AuthProviderServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources
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
 * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
 *   AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
 *   AuthProvider response = authProviderServiceClient.getAuthProvider(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AuthProviderServiceClient object to clean up resources
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
 *      <td><p> ListAuthProviders</td>
 *      <td><p> Lists AuthProviders in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAuthProviders(ListAuthProvidersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAuthProviders(LocationName parent)
 *           <li><p> listAuthProviders(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAuthProvidersPagedCallable()
 *           <li><p> listAuthProvidersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAuthProvider</td>
 *      <td><p> Gets details of a single AuthProvider.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAuthProvider(GetAuthProviderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAuthProvider(AuthProviderName name)
 *           <li><p> getAuthProvider(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAuthProviderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAuthProvider</td>
 *      <td><p> Creates a new AuthProvider in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAuthProvider(CreateAuthProviderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAuthProvider(LocationName parent, AuthProvider authProvider, String authProviderId)
 *           <li><p> createAuthProvider(String parent, AuthProvider authProvider, String authProviderId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAuthProviderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAuthProvider</td>
 *      <td><p> Updates the parameters of a single AuthProvider.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAuthProvider(UpdateAuthProviderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAuthProvider(AuthProvider authProvider, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAuthProviderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAuthProvider</td>
 *      <td><p> Deletes a single AuthProvider.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAuthProvider(DeleteAuthProviderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAuthProvider(AuthProviderName name)
 *           <li><p> deleteAuthProvider(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAuthProviderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UndeleteAuthProvider</td>
 *      <td><p> Undeletes a single AuthProvider.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> undeleteAuthProvider(UndeleteAuthProviderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> undeleteAuthProvider(AuthProviderName name)
 *           <li><p> undeleteAuthProvider(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> undeleteAuthProviderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> QueryAuthProviders</td>
 *      <td><p> Queries what all auth_providers are used by a given workload_id.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryAuthProviders(QueryAuthProvidersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> queryAuthProviders(LocationName parent, String workloadId)
 *           <li><p> queryAuthProviders(String parent, String workloadId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryAuthProvidersPagedCallable()
 *           <li><p> queryAuthProvidersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> QueryWorkloads</td>
 *      <td><p> Queries what all workloads are using a given auth_provider.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryWorkloads(QueryWorkloadsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> queryWorkloads(AuthProviderName name)
 *           <li><p> queryWorkloads(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryWorkloadsPagedCallable()
 *           <li><p> queryWorkloadsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAuthorizations</td>
 *      <td><p> Lists Authorizations in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAuthorizations(ListAuthorizationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAuthorizations(AuthProviderName parent)
 *           <li><p> listAuthorizations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAuthorizationsPagedCallable()
 *           <li><p> listAuthorizationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAuthorization</td>
 *      <td><p> Gets details of a single Authorization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAuthorization(GetAuthorizationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAuthorization(AuthorizationName name)
 *           <li><p> getAuthorization(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAuthorizationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAuthorization</td>
 *      <td><p> Deletes a single Authorization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAuthorization(DeleteAuthorizationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAuthorization(AuthorizationName name)
 *           <li><p> deleteAuthorization(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAuthorizationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAccessSummaries</td>
 *      <td><p> Lists AccessSummaries in a given project and location. Supported Filters: - `workload_id`: Filter by the SPIFFE ID of the agent.   Example: `workload_id="spiffe://example.com/ns/default/sa/my-agent"`</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAccessSummaries(ListAccessSummariesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAccessSummaries(LocationName parent)
 *           <li><p> listAccessSummaries(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAccessSummariesPagedCallable()
 *           <li><p> listAccessSummariesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAccessSummary</td>
 *      <td><p> Gets details of a single AccessSummary.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAccessSummary(GetAccessSummaryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAccessSummary(AccessSummaryName name)
 *           <li><p> getAccessSummary(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAccessSummaryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RevokeAuthorization</td>
 *      <td><p> Revokes all authorizations for a specific user on an AuthProvider. This deletes all authorization records associated with the user and AuthProvider, effectively revoking access across all agents.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> revokeAuthorization(RevokeAuthorizationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> revokeAuthorization(AuthProviderName name, String userId)
 *           <li><p> revokeAuthorization(String name, String userId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> revokeAuthorizationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EnableAuthProvider</td>
 *      <td><p> Enables a single AuthProvider.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> enableAuthProvider(EnableAuthProviderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> enableAuthProvider(AuthProviderName name)
 *           <li><p> enableAuthProvider(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> enableAuthProviderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DisableAuthProvider</td>
 *      <td><p> Disables a single AuthProvider.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> disableAuthProvider(DisableAuthProviderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> disableAuthProvider(AuthProviderName name)
 *           <li><p> disableAuthProvider(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> disableAuthProviderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.
 * <p> This method lists locations based on the resource scope provided inthe [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field: &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If `name` follows the format`projects/{project}`, the method lists locations visible to thatspecific project. This includes public, private, or otherproject-specific locations enabled for the project.
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
 * <p>This class can be customized by passing in a custom instance of AuthProviderServiceSettings to
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
 * AuthProviderServiceSettings authProviderServiceSettings =
 *     AuthProviderServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AuthProviderServiceClient authProviderServiceClient =
 *     AuthProviderServiceClient.create(authProviderServiceSettings);
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
 * AuthProviderServiceSettings authProviderServiceSettings =
 *     AuthProviderServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AuthProviderServiceClient authProviderServiceClient =
 *     AuthProviderServiceClient.create(authProviderServiceSettings);
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
 * AuthProviderServiceSettings authProviderServiceSettings =
 *     AuthProviderServiceSettings.newHttpJsonBuilder().build();
 * AuthProviderServiceClient authProviderServiceClient =
 *     AuthProviderServiceClient.create(authProviderServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class AuthProviderServiceClient implements BackgroundResource {
  private final @Nullable AuthProviderServiceSettings settings;
  private final AuthProviderServiceStub stub;

  /** Constructs an instance of AuthProviderServiceClient with default settings. */
  public static final AuthProviderServiceClient create() throws IOException {
    return create(AuthProviderServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AuthProviderServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AuthProviderServiceClient create(AuthProviderServiceSettings settings)
      throws IOException {
    return new AuthProviderServiceClient(settings);
  }

  /**
   * Constructs an instance of AuthProviderServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(AuthProviderServiceSettings).
   */
  public static final AuthProviderServiceClient create(AuthProviderServiceStub stub) {
    return new AuthProviderServiceClient(stub);
  }

  /**
   * Constructs an instance of AuthProviderServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AuthProviderServiceClient(AuthProviderServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AuthProviderServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AuthProviderServiceClient(AuthProviderServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable AuthProviderServiceSettings getSettings() {
    return settings;
  }

  public AuthProviderServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AuthProviders in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AuthProvider element :
   *       authProviderServiceClient.listAuthProviders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the search is performed. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthProvidersPagedResponse listAuthProviders(@Nullable LocationName parent) {
    ListAuthProvidersRequest request =
        ListAuthProvidersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAuthProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AuthProviders in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AuthProvider element :
   *       authProviderServiceClient.listAuthProviders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the search is performed. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthProvidersPagedResponse listAuthProviders(String parent) {
    ListAuthProvidersRequest request =
        ListAuthProvidersRequest.newBuilder().setParent(parent).build();
    return listAuthProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AuthProviders in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   ListAuthProvidersRequest request =
   *       ListAuthProvidersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   for (AuthProvider element :
   *       authProviderServiceClient.listAuthProviders(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthProvidersPagedResponse listAuthProviders(ListAuthProvidersRequest request) {
    return listAuthProvidersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AuthProviders in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   ListAuthProvidersRequest request =
   *       ListAuthProvidersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<AuthProvider> future =
   *       authProviderServiceClient.listAuthProvidersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AuthProvider element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAuthProvidersRequest, ListAuthProvidersPagedResponse>
      listAuthProvidersPagedCallable() {
    return stub.listAuthProvidersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AuthProviders in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   ListAuthProvidersRequest request =
   *       ListAuthProvidersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListAuthProvidersResponse response =
   *         authProviderServiceClient.listAuthProvidersCallable().call(request);
   *     for (AuthProvider element : response.getAuthProvidersList()) {
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
  public final UnaryCallable<ListAuthProvidersRequest, ListAuthProvidersResponse>
      listAuthProvidersCallable() {
    return stub.listAuthProvidersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
   *   AuthProvider response = authProviderServiceClient.getAuthProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthProvider getAuthProvider(@Nullable AuthProviderName name) {
    GetAuthProviderRequest request =
        GetAuthProviderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAuthProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   String name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString();
   *   AuthProvider response = authProviderServiceClient.getAuthProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthProvider getAuthProvider(String name) {
    GetAuthProviderRequest request = GetAuthProviderRequest.newBuilder().setName(name).build();
    return getAuthProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   GetAuthProviderRequest request =
   *       GetAuthProviderRequest.newBuilder()
   *           .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .build();
   *   AuthProvider response = authProviderServiceClient.getAuthProvider(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthProvider getAuthProvider(GetAuthProviderRequest request) {
    return getAuthProviderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   GetAuthProviderRequest request =
   *       GetAuthProviderRequest.newBuilder()
   *           .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .build();
   *   ApiFuture<AuthProvider> future =
   *       authProviderServiceClient.getAuthProviderCallable().futureCall(request);
   *   // Do something.
   *   AuthProvider response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAuthProviderRequest, AuthProvider> getAuthProviderCallable() {
    return stub.getAuthProviderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AuthProvider in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AuthProvider authProvider = AuthProvider.newBuilder().build();
   *   String authProviderId = "authProviderId325000884";
   *   AuthProvider response =
   *       authProviderServiceClient.createAuthProvider(parent, authProvider, authProviderId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the AuthProvider is created. Format:
   *     projects/{project}/locations/{location}
   * @param authProvider Required. The AuthProvider to create.
   * @param authProviderId Required. The ID to use for the AuthProvider, which will become the final
   *     segment of the AuthProvider's resource name. This value should be 1-63 characters, and
   *     valid characters are /[a-z][0-9]-/. The first character must be a lowercase letter, and the
   *     last character must be a lowercase letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthProvider createAuthProvider(
      @Nullable LocationName parent, AuthProvider authProvider, String authProviderId) {
    CreateAuthProviderRequest request =
        CreateAuthProviderRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAuthProvider(authProvider)
            .setAuthProviderId(authProviderId)
            .build();
    return createAuthProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AuthProvider in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AuthProvider authProvider = AuthProvider.newBuilder().build();
   *   String authProviderId = "authProviderId325000884";
   *   AuthProvider response =
   *       authProviderServiceClient.createAuthProvider(parent, authProvider, authProviderId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the AuthProvider is created. Format:
   *     projects/{project}/locations/{location}
   * @param authProvider Required. The AuthProvider to create.
   * @param authProviderId Required. The ID to use for the AuthProvider, which will become the final
   *     segment of the AuthProvider's resource name. This value should be 1-63 characters, and
   *     valid characters are /[a-z][0-9]-/. The first character must be a lowercase letter, and the
   *     last character must be a lowercase letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthProvider createAuthProvider(
      String parent, AuthProvider authProvider, String authProviderId) {
    CreateAuthProviderRequest request =
        CreateAuthProviderRequest.newBuilder()
            .setParent(parent)
            .setAuthProvider(authProvider)
            .setAuthProviderId(authProviderId)
            .build();
    return createAuthProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AuthProvider in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   CreateAuthProviderRequest request =
   *       CreateAuthProviderRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAuthProviderId("authProviderId325000884")
   *           .setAuthProvider(AuthProvider.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AuthProvider response = authProviderServiceClient.createAuthProvider(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthProvider createAuthProvider(CreateAuthProviderRequest request) {
    return createAuthProviderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AuthProvider in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   CreateAuthProviderRequest request =
   *       CreateAuthProviderRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAuthProviderId("authProviderId325000884")
   *           .setAuthProvider(AuthProvider.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<AuthProvider> future =
   *       authProviderServiceClient.createAuthProviderCallable().futureCall(request);
   *   // Do something.
   *   AuthProvider response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAuthProviderRequest, AuthProvider> createAuthProviderCallable() {
    return stub.createAuthProviderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   AuthProvider authProvider = AuthProvider.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AuthProvider response =
   *       authProviderServiceClient.updateAuthProvider(authProvider, updateMask);
   * }
   * }</pre>
   *
   * @param authProvider Required. The AuthProvider resource which replaces the resource on the
   *     server.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     AuthProvider resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields present in the request will be
   *     overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthProvider updateAuthProvider(AuthProvider authProvider, FieldMask updateMask) {
    UpdateAuthProviderRequest request =
        UpdateAuthProviderRequest.newBuilder()
            .setAuthProvider(authProvider)
            .setUpdateMask(updateMask)
            .build();
    return updateAuthProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   UpdateAuthProviderRequest request =
   *       UpdateAuthProviderRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAuthProvider(AuthProvider.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AuthProvider response = authProviderServiceClient.updateAuthProvider(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthProvider updateAuthProvider(UpdateAuthProviderRequest request) {
    return updateAuthProviderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   UpdateAuthProviderRequest request =
   *       UpdateAuthProviderRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAuthProvider(AuthProvider.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<AuthProvider> future =
   *       authProviderServiceClient.updateAuthProviderCallable().futureCall(request);
   *   // Do something.
   *   AuthProvider response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAuthProviderRequest, AuthProvider> updateAuthProviderCallable() {
    return stub.updateAuthProviderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
   *   authProviderServiceClient.deleteAuthProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAuthProvider(@Nullable AuthProviderName name) {
    DeleteAuthProviderRequest request =
        DeleteAuthProviderRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteAuthProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   String name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString();
   *   authProviderServiceClient.deleteAuthProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAuthProvider(String name) {
    DeleteAuthProviderRequest request =
        DeleteAuthProviderRequest.newBuilder().setName(name).build();
    deleteAuthProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   DeleteAuthProviderRequest request =
   *       DeleteAuthProviderRequest.newBuilder()
   *           .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   authProviderServiceClient.deleteAuthProvider(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAuthProvider(DeleteAuthProviderRequest request) {
    deleteAuthProviderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   DeleteAuthProviderRequest request =
   *       DeleteAuthProviderRequest.newBuilder()
   *           .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future =
   *       authProviderServiceClient.deleteAuthProviderCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAuthProviderRequest, Empty> deleteAuthProviderCallable() {
    return stub.deleteAuthProviderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
   *   AuthProvider response = authProviderServiceClient.undeleteAuthProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource Format:
   *     projects/{project}/locations/{location}/authProviders/{auth_provider}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthProvider undeleteAuthProvider(@Nullable AuthProviderName name) {
    UndeleteAuthProviderRequest request =
        UndeleteAuthProviderRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return undeleteAuthProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   String name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString();
   *   AuthProvider response = authProviderServiceClient.undeleteAuthProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource Format:
   *     projects/{project}/locations/{location}/authProviders/{auth_provider}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthProvider undeleteAuthProvider(String name) {
    UndeleteAuthProviderRequest request =
        UndeleteAuthProviderRequest.newBuilder().setName(name).build();
    return undeleteAuthProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   UndeleteAuthProviderRequest request =
   *       UndeleteAuthProviderRequest.newBuilder()
   *           .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AuthProvider response = authProviderServiceClient.undeleteAuthProvider(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthProvider undeleteAuthProvider(UndeleteAuthProviderRequest request) {
    return undeleteAuthProviderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeletes a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   UndeleteAuthProviderRequest request =
   *       UndeleteAuthProviderRequest.newBuilder()
   *           .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<AuthProvider> future =
   *       authProviderServiceClient.undeleteAuthProviderCallable().futureCall(request);
   *   // Do something.
   *   AuthProvider response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeleteAuthProviderRequest, AuthProvider>
      undeleteAuthProviderCallable() {
    return stub.undeleteAuthProviderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries what all auth_providers are used by a given workload_id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String workloadId = "workloadId-186277134";
   *   for (String element :
   *       authProviderServiceClient.queryAuthProviders(parent, workloadId).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the search is performed. Format:
   *     projects/{project}/locations/{location}
   * @param workloadId Required. The workload identifier to filter by.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryAuthProvidersPagedResponse queryAuthProviders(
      @Nullable LocationName parent, String workloadId) {
    QueryAuthProvidersRequest request =
        QueryAuthProvidersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setWorkloadId(workloadId)
            .build();
    return queryAuthProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries what all auth_providers are used by a given workload_id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String workloadId = "workloadId-186277134";
   *   for (String element :
   *       authProviderServiceClient.queryAuthProviders(parent, workloadId).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the search is performed. Format:
   *     projects/{project}/locations/{location}
   * @param workloadId Required. The workload identifier to filter by.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryAuthProvidersPagedResponse queryAuthProviders(
      String parent, String workloadId) {
    QueryAuthProvidersRequest request =
        QueryAuthProvidersRequest.newBuilder().setParent(parent).setWorkloadId(workloadId).build();
    return queryAuthProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries what all auth_providers are used by a given workload_id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   QueryAuthProvidersRequest request =
   *       QueryAuthProvidersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setWorkloadId("workloadId-186277134")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (String element : authProviderServiceClient.queryAuthProviders(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryAuthProvidersPagedResponse queryAuthProviders(
      QueryAuthProvidersRequest request) {
    return queryAuthProvidersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries what all auth_providers are used by a given workload_id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   QueryAuthProvidersRequest request =
   *       QueryAuthProvidersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setWorkloadId("workloadId-186277134")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<String> future =
   *       authProviderServiceClient.queryAuthProvidersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (String element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryAuthProvidersRequest, QueryAuthProvidersPagedResponse>
      queryAuthProvidersPagedCallable() {
    return stub.queryAuthProvidersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries what all auth_providers are used by a given workload_id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   QueryAuthProvidersRequest request =
   *       QueryAuthProvidersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setWorkloadId("workloadId-186277134")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     QueryAuthProvidersResponse response =
   *         authProviderServiceClient.queryAuthProvidersCallable().call(request);
   *     for (String element : response.getAuthProviderNamesList()) {
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
  public final UnaryCallable<QueryAuthProvidersRequest, QueryAuthProvidersResponse>
      queryAuthProvidersCallable() {
    return stub.queryAuthProvidersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries what all workloads are using a given auth_provider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
   *   for (String element : authProviderServiceClient.queryWorkloads(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the auth_provider to query. Format:
   *     projects/{project}/locations/{location}/authProviders/{auth_provider}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryWorkloadsPagedResponse queryWorkloads(@Nullable AuthProviderName name) {
    QueryWorkloadsRequest request =
        QueryWorkloadsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return queryWorkloads(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries what all workloads are using a given auth_provider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   String name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString();
   *   for (String element : authProviderServiceClient.queryWorkloads(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the auth_provider to query. Format:
   *     projects/{project}/locations/{location}/authProviders/{auth_provider}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryWorkloadsPagedResponse queryWorkloads(String name) {
    QueryWorkloadsRequest request = QueryWorkloadsRequest.newBuilder().setName(name).build();
    return queryWorkloads(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries what all workloads are using a given auth_provider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   QueryWorkloadsRequest request =
   *       QueryWorkloadsRequest.newBuilder()
   *           .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (String element : authProviderServiceClient.queryWorkloads(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryWorkloadsPagedResponse queryWorkloads(QueryWorkloadsRequest request) {
    return queryWorkloadsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries what all workloads are using a given auth_provider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   QueryWorkloadsRequest request =
   *       QueryWorkloadsRequest.newBuilder()
   *           .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<String> future =
   *       authProviderServiceClient.queryWorkloadsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (String element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryWorkloadsRequest, QueryWorkloadsPagedResponse>
      queryWorkloadsPagedCallable() {
    return stub.queryWorkloadsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Queries what all workloads are using a given auth_provider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   QueryWorkloadsRequest request =
   *       QueryWorkloadsRequest.newBuilder()
   *           .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     QueryWorkloadsResponse response =
   *         authProviderServiceClient.queryWorkloadsCallable().call(request);
   *     for (String element : response.getWorkloadIdsList()) {
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
  public final UnaryCallable<QueryWorkloadsRequest, QueryWorkloadsResponse>
      queryWorkloadsCallable() {
    return stub.queryWorkloadsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Authorizations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   AuthProviderName parent = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
   *   for (Authorization element :
   *       authProviderServiceClient.listAuthorizations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the search is performed. Format:
   *     projects/{project}/locations/{location}/authProviders/{auth_provider}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthorizationsPagedResponse listAuthorizations(
      @Nullable AuthProviderName parent) {
    ListAuthorizationsRequest request =
        ListAuthorizationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAuthorizations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Authorizations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   String parent = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString();
   *   for (Authorization element :
   *       authProviderServiceClient.listAuthorizations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the search is performed. Format:
   *     projects/{project}/locations/{location}/authProviders/{auth_provider}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthorizationsPagedResponse listAuthorizations(String parent) {
    ListAuthorizationsRequest request =
        ListAuthorizationsRequest.newBuilder().setParent(parent).build();
    return listAuthorizations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Authorizations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   ListAuthorizationsRequest request =
   *       ListAuthorizationsRequest.newBuilder()
   *           .setParent(
   *               AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Authorization element :
   *       authProviderServiceClient.listAuthorizations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthorizationsPagedResponse listAuthorizations(
      ListAuthorizationsRequest request) {
    return listAuthorizationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Authorizations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   ListAuthorizationsRequest request =
   *       ListAuthorizationsRequest.newBuilder()
   *           .setParent(
   *               AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Authorization> future =
   *       authProviderServiceClient.listAuthorizationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Authorization element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAuthorizationsRequest, ListAuthorizationsPagedResponse>
      listAuthorizationsPagedCallable() {
    return stub.listAuthorizationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Authorizations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   ListAuthorizationsRequest request =
   *       ListAuthorizationsRequest.newBuilder()
   *           .setParent(
   *               AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAuthorizationsResponse response =
   *         authProviderServiceClient.listAuthorizationsCallable().call(request);
   *     for (Authorization element : response.getAuthorizationsList()) {
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
  public final UnaryCallable<ListAuthorizationsRequest, ListAuthorizationsResponse>
      listAuthorizationsCallable() {
    return stub.listAuthorizationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Authorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   AuthorizationName name =
   *       AuthorizationName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]", "[AUTHORIZATION]");
   *   Authorization response = authProviderServiceClient.getAuthorization(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Authorization getAuthorization(@Nullable AuthorizationName name) {
    GetAuthorizationRequest request =
        GetAuthorizationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAuthorization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Authorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   String name =
   *       AuthorizationName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]", "[AUTHORIZATION]")
   *           .toString();
   *   Authorization response = authProviderServiceClient.getAuthorization(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Authorization getAuthorization(String name) {
    GetAuthorizationRequest request = GetAuthorizationRequest.newBuilder().setName(name).build();
    return getAuthorization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Authorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   GetAuthorizationRequest request =
   *       GetAuthorizationRequest.newBuilder()
   *           .setName(
   *               AuthorizationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]", "[AUTHORIZATION]")
   *                   .toString())
   *           .build();
   *   Authorization response = authProviderServiceClient.getAuthorization(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Authorization getAuthorization(GetAuthorizationRequest request) {
    return getAuthorizationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Authorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   GetAuthorizationRequest request =
   *       GetAuthorizationRequest.newBuilder()
   *           .setName(
   *               AuthorizationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]", "[AUTHORIZATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Authorization> future =
   *       authProviderServiceClient.getAuthorizationCallable().futureCall(request);
   *   // Do something.
   *   Authorization response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAuthorizationRequest, Authorization> getAuthorizationCallable() {
    return stub.getAuthorizationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Authorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   AuthorizationName name =
   *       AuthorizationName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]", "[AUTHORIZATION]");
   *   authProviderServiceClient.deleteAuthorization(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Authorization to delete. Format:
   *     projects/{project}/locations/{location}/authProviders/{auth_provider}/authorizations/{authorization}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAuthorization(@Nullable AuthorizationName name) {
    DeleteAuthorizationRequest request =
        DeleteAuthorizationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteAuthorization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Authorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   String name =
   *       AuthorizationName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]", "[AUTHORIZATION]")
   *           .toString();
   *   authProviderServiceClient.deleteAuthorization(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Authorization to delete. Format:
   *     projects/{project}/locations/{location}/authProviders/{auth_provider}/authorizations/{authorization}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAuthorization(String name) {
    DeleteAuthorizationRequest request =
        DeleteAuthorizationRequest.newBuilder().setName(name).build();
    deleteAuthorization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Authorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   DeleteAuthorizationRequest request =
   *       DeleteAuthorizationRequest.newBuilder()
   *           .setName(
   *               AuthorizationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]", "[AUTHORIZATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   authProviderServiceClient.deleteAuthorization(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAuthorization(DeleteAuthorizationRequest request) {
    deleteAuthorizationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Authorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   DeleteAuthorizationRequest request =
   *       DeleteAuthorizationRequest.newBuilder()
   *           .setName(
   *               AuthorizationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]", "[AUTHORIZATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future =
   *       authProviderServiceClient.deleteAuthorizationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAuthorizationRequest, Empty> deleteAuthorizationCallable() {
    return stub.deleteAuthorizationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AccessSummaries in a given project and location. Supported Filters: - `workload_id`:
   * Filter by the SPIFFE ID of the agent. Example:
   * `workload_id="spiffe://example.com/ns/default/sa/my-agent"`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AccessSummary element :
   *       authProviderServiceClient.listAccessSummaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the search is performed. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessSummariesPagedResponse listAccessSummaries(@Nullable LocationName parent) {
    ListAccessSummariesRequest request =
        ListAccessSummariesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAccessSummaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AccessSummaries in a given project and location. Supported Filters: - `workload_id`:
   * Filter by the SPIFFE ID of the agent. Example:
   * `workload_id="spiffe://example.com/ns/default/sa/my-agent"`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AccessSummary element :
   *       authProviderServiceClient.listAccessSummaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the search is performed. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessSummariesPagedResponse listAccessSummaries(String parent) {
    ListAccessSummariesRequest request =
        ListAccessSummariesRequest.newBuilder().setParent(parent).build();
    return listAccessSummaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AccessSummaries in a given project and location. Supported Filters: - `workload_id`:
   * Filter by the SPIFFE ID of the agent. Example:
   * `workload_id="spiffe://example.com/ns/default/sa/my-agent"`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   ListAccessSummariesRequest request =
   *       ListAccessSummariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (AccessSummary element :
   *       authProviderServiceClient.listAccessSummaries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessSummariesPagedResponse listAccessSummaries(
      ListAccessSummariesRequest request) {
    return listAccessSummariesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AccessSummaries in a given project and location. Supported Filters: - `workload_id`:
   * Filter by the SPIFFE ID of the agent. Example:
   * `workload_id="spiffe://example.com/ns/default/sa/my-agent"`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   ListAccessSummariesRequest request =
   *       ListAccessSummariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<AccessSummary> future =
   *       authProviderServiceClient.listAccessSummariesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AccessSummary element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAccessSummariesRequest, ListAccessSummariesPagedResponse>
      listAccessSummariesPagedCallable() {
    return stub.listAccessSummariesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AccessSummaries in a given project and location. Supported Filters: - `workload_id`:
   * Filter by the SPIFFE ID of the agent. Example:
   * `workload_id="spiffe://example.com/ns/default/sa/my-agent"`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   ListAccessSummariesRequest request =
   *       ListAccessSummariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAccessSummariesResponse response =
   *         authProviderServiceClient.listAccessSummariesCallable().call(request);
   *     for (AccessSummary element : response.getAccessSummariesList()) {
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
  public final UnaryCallable<ListAccessSummariesRequest, ListAccessSummariesResponse>
      listAccessSummariesCallable() {
    return stub.listAccessSummariesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AccessSummary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   AccessSummaryName name = AccessSummaryName.of("[PROJECT]", "[LOCATION]", "[ACCESS_SUMMARY]");
   *   AccessSummary response = authProviderServiceClient.getAccessSummary(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessSummary getAccessSummary(@Nullable AccessSummaryName name) {
    GetAccessSummaryRequest request =
        GetAccessSummaryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAccessSummary(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AccessSummary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   String name = AccessSummaryName.of("[PROJECT]", "[LOCATION]", "[ACCESS_SUMMARY]").toString();
   *   AccessSummary response = authProviderServiceClient.getAccessSummary(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessSummary getAccessSummary(String name) {
    GetAccessSummaryRequest request = GetAccessSummaryRequest.newBuilder().setName(name).build();
    return getAccessSummary(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AccessSummary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   GetAccessSummaryRequest request =
   *       GetAccessSummaryRequest.newBuilder()
   *           .setName(
   *               AccessSummaryName.of("[PROJECT]", "[LOCATION]", "[ACCESS_SUMMARY]").toString())
   *           .build();
   *   AccessSummary response = authProviderServiceClient.getAccessSummary(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessSummary getAccessSummary(GetAccessSummaryRequest request) {
    return getAccessSummaryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AccessSummary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   GetAccessSummaryRequest request =
   *       GetAccessSummaryRequest.newBuilder()
   *           .setName(
   *               AccessSummaryName.of("[PROJECT]", "[LOCATION]", "[ACCESS_SUMMARY]").toString())
   *           .build();
   *   ApiFuture<AccessSummary> future =
   *       authProviderServiceClient.getAccessSummaryCallable().futureCall(request);
   *   // Do something.
   *   AccessSummary response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAccessSummaryRequest, AccessSummary> getAccessSummaryCallable() {
    return stub.getAccessSummaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revokes all authorizations for a specific user on an AuthProvider. This deletes all
   * authorization records associated with the user and AuthProvider, effectively revoking access
   * across all agents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
   *   String userId = "userId-836030906";
   *   RevokeAuthorizationResponse response =
   *       authProviderServiceClient.revokeAuthorization(name, userId);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AuthProvider. Format:
   *     projects/{project}/locations/{location}/authProviders/{auth_provider}
   * @param userId Required. The identity of the user to revoke authorization for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RevokeAuthorizationResponse revokeAuthorization(
      @Nullable AuthProviderName name, String userId) {
    RevokeAuthorizationRequest request =
        RevokeAuthorizationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setUserId(userId)
            .build();
    return revokeAuthorization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revokes all authorizations for a specific user on an AuthProvider. This deletes all
   * authorization records associated with the user and AuthProvider, effectively revoking access
   * across all agents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   String name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString();
   *   String userId = "userId-836030906";
   *   RevokeAuthorizationResponse response =
   *       authProviderServiceClient.revokeAuthorization(name, userId);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AuthProvider. Format:
   *     projects/{project}/locations/{location}/authProviders/{auth_provider}
   * @param userId Required. The identity of the user to revoke authorization for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RevokeAuthorizationResponse revokeAuthorization(String name, String userId) {
    RevokeAuthorizationRequest request =
        RevokeAuthorizationRequest.newBuilder().setName(name).setUserId(userId).build();
    return revokeAuthorization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revokes all authorizations for a specific user on an AuthProvider. This deletes all
   * authorization records associated with the user and AuthProvider, effectively revoking access
   * across all agents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   RevokeAuthorizationRequest request =
   *       RevokeAuthorizationRequest.newBuilder()
   *           .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setUserId("userId-836030906")
   *           .build();
   *   RevokeAuthorizationResponse response = authProviderServiceClient.revokeAuthorization(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RevokeAuthorizationResponse revokeAuthorization(RevokeAuthorizationRequest request) {
    return revokeAuthorizationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revokes all authorizations for a specific user on an AuthProvider. This deletes all
   * authorization records associated with the user and AuthProvider, effectively revoking access
   * across all agents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   RevokeAuthorizationRequest request =
   *       RevokeAuthorizationRequest.newBuilder()
   *           .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setUserId("userId-836030906")
   *           .build();
   *   ApiFuture<RevokeAuthorizationResponse> future =
   *       authProviderServiceClient.revokeAuthorizationCallable().futureCall(request);
   *   // Do something.
   *   RevokeAuthorizationResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RevokeAuthorizationRequest, RevokeAuthorizationResponse>
      revokeAuthorizationCallable() {
    return stub.revokeAuthorizationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
   *   AuthProvider response = authProviderServiceClient.enableAuthProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource Format:
   *     projects/{project}/locations/{location}/authProviders/{auth_provider}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthProvider enableAuthProvider(@Nullable AuthProviderName name) {
    EnableAuthProviderRequest request =
        EnableAuthProviderRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return enableAuthProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   String name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString();
   *   AuthProvider response = authProviderServiceClient.enableAuthProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource Format:
   *     projects/{project}/locations/{location}/authProviders/{auth_provider}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthProvider enableAuthProvider(String name) {
    EnableAuthProviderRequest request =
        EnableAuthProviderRequest.newBuilder().setName(name).build();
    return enableAuthProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   EnableAuthProviderRequest request =
   *       EnableAuthProviderRequest.newBuilder()
   *           .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AuthProvider response = authProviderServiceClient.enableAuthProvider(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthProvider enableAuthProvider(EnableAuthProviderRequest request) {
    return enableAuthProviderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   EnableAuthProviderRequest request =
   *       EnableAuthProviderRequest.newBuilder()
   *           .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<AuthProvider> future =
   *       authProviderServiceClient.enableAuthProviderCallable().futureCall(request);
   *   // Do something.
   *   AuthProvider response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EnableAuthProviderRequest, AuthProvider> enableAuthProviderCallable() {
    return stub.enableAuthProviderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   AuthProviderName name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]");
   *   AuthProvider response = authProviderServiceClient.disableAuthProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource Format:
   *     projects/{project}/locations/{location}/authProviders/{auth_provider}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthProvider disableAuthProvider(@Nullable AuthProviderName name) {
    DisableAuthProviderRequest request =
        DisableAuthProviderRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return disableAuthProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   String name = AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString();
   *   AuthProvider response = authProviderServiceClient.disableAuthProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource Format:
   *     projects/{project}/locations/{location}/authProviders/{auth_provider}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthProvider disableAuthProvider(String name) {
    DisableAuthProviderRequest request =
        DisableAuthProviderRequest.newBuilder().setName(name).build();
    return disableAuthProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   DisableAuthProviderRequest request =
   *       DisableAuthProviderRequest.newBuilder()
   *           .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AuthProvider response = authProviderServiceClient.disableAuthProvider(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthProvider disableAuthProvider(DisableAuthProviderRequest request) {
    return disableAuthProviderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a single AuthProvider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   DisableAuthProviderRequest request =
   *       DisableAuthProviderRequest.newBuilder()
   *           .setName(AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<AuthProvider> future =
   *       authProviderServiceClient.disableAuthProviderCallable().futureCall(request);
   *   // Do something.
   *   AuthProvider response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DisableAuthProviderRequest, AuthProvider>
      disableAuthProviderCallable() {
    return stub.disableAuthProviderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
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
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : authProviderServiceClient.listLocations(request).iterateAll()) {
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
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
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
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       authProviderServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
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
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         authProviderServiceClient.listLocationsCallable().call(request);
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
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = authProviderServiceClient.getLocation(request);
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
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       authProviderServiceClient.getLocationCallable().futureCall(request);
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
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = authProviderServiceClient.setIamPolicy(request);
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
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       authProviderServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = authProviderServiceClient.getIamPolicy(request);
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
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       authProviderServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = authProviderServiceClient.testIamPermissions(request);
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
   * try (AuthProviderServiceClient authProviderServiceClient = AuthProviderServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AuthProviderName.of("[PROJECT]", "[LOCATION]", "[AUTH_PROVIDER]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       authProviderServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListAuthProvidersPagedResponse
      extends AbstractPagedListResponse<
          ListAuthProvidersRequest,
          ListAuthProvidersResponse,
          AuthProvider,
          ListAuthProvidersPage,
          ListAuthProvidersFixedSizeCollection> {

    public static ApiFuture<ListAuthProvidersPagedResponse> createAsync(
        PageContext<ListAuthProvidersRequest, ListAuthProvidersResponse, AuthProvider> context,
        ApiFuture<ListAuthProvidersResponse> futureResponse) {
      ApiFuture<ListAuthProvidersPage> futurePage =
          ListAuthProvidersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAuthProvidersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAuthProvidersPagedResponse(ListAuthProvidersPage page) {
      super(page, ListAuthProvidersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAuthProvidersPage
      extends AbstractPage<
          ListAuthProvidersRequest,
          ListAuthProvidersResponse,
          AuthProvider,
          ListAuthProvidersPage> {

    private ListAuthProvidersPage(
        @Nullable PageContext<ListAuthProvidersRequest, ListAuthProvidersResponse, AuthProvider>
            context,
        @Nullable ListAuthProvidersResponse response) {
      super(context, response);
    }

    private static ListAuthProvidersPage createEmptyPage() {
      return new ListAuthProvidersPage(null, null);
    }

    @Override
    protected ListAuthProvidersPage createPage(
        @Nullable PageContext<ListAuthProvidersRequest, ListAuthProvidersResponse, AuthProvider>
            context,
        @Nullable ListAuthProvidersResponse response) {
      return new ListAuthProvidersPage(context, response);
    }

    @Override
    public ApiFuture<ListAuthProvidersPage> createPageAsync(
        @Nullable PageContext<ListAuthProvidersRequest, ListAuthProvidersResponse, AuthProvider>
            context,
        ApiFuture<ListAuthProvidersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAuthProvidersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAuthProvidersRequest,
          ListAuthProvidersResponse,
          AuthProvider,
          ListAuthProvidersPage,
          ListAuthProvidersFixedSizeCollection> {

    private ListAuthProvidersFixedSizeCollection(
        @Nullable List<ListAuthProvidersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAuthProvidersFixedSizeCollection createEmptyCollection() {
      return new ListAuthProvidersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAuthProvidersFixedSizeCollection createCollection(
        @Nullable List<ListAuthProvidersPage> pages, int collectionSize) {
      return new ListAuthProvidersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class QueryAuthProvidersPagedResponse
      extends AbstractPagedListResponse<
          QueryAuthProvidersRequest,
          QueryAuthProvidersResponse,
          String,
          QueryAuthProvidersPage,
          QueryAuthProvidersFixedSizeCollection> {

    public static ApiFuture<QueryAuthProvidersPagedResponse> createAsync(
        PageContext<QueryAuthProvidersRequest, QueryAuthProvidersResponse, String> context,
        ApiFuture<QueryAuthProvidersResponse> futureResponse) {
      ApiFuture<QueryAuthProvidersPage> futurePage =
          QueryAuthProvidersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new QueryAuthProvidersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private QueryAuthProvidersPagedResponse(QueryAuthProvidersPage page) {
      super(page, QueryAuthProvidersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class QueryAuthProvidersPage
      extends AbstractPage<
          QueryAuthProvidersRequest, QueryAuthProvidersResponse, String, QueryAuthProvidersPage> {

    private QueryAuthProvidersPage(
        @Nullable PageContext<QueryAuthProvidersRequest, QueryAuthProvidersResponse, String>
            context,
        @Nullable QueryAuthProvidersResponse response) {
      super(context, response);
    }

    private static QueryAuthProvidersPage createEmptyPage() {
      return new QueryAuthProvidersPage(null, null);
    }

    @Override
    protected QueryAuthProvidersPage createPage(
        @Nullable PageContext<QueryAuthProvidersRequest, QueryAuthProvidersResponse, String>
            context,
        @Nullable QueryAuthProvidersResponse response) {
      return new QueryAuthProvidersPage(context, response);
    }

    @Override
    public ApiFuture<QueryAuthProvidersPage> createPageAsync(
        @Nullable PageContext<QueryAuthProvidersRequest, QueryAuthProvidersResponse, String>
            context,
        ApiFuture<QueryAuthProvidersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class QueryAuthProvidersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          QueryAuthProvidersRequest,
          QueryAuthProvidersResponse,
          String,
          QueryAuthProvidersPage,
          QueryAuthProvidersFixedSizeCollection> {

    private QueryAuthProvidersFixedSizeCollection(
        @Nullable List<QueryAuthProvidersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static QueryAuthProvidersFixedSizeCollection createEmptyCollection() {
      return new QueryAuthProvidersFixedSizeCollection(null, 0);
    }

    @Override
    protected QueryAuthProvidersFixedSizeCollection createCollection(
        @Nullable List<QueryAuthProvidersPage> pages, int collectionSize) {
      return new QueryAuthProvidersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class QueryWorkloadsPagedResponse
      extends AbstractPagedListResponse<
          QueryWorkloadsRequest,
          QueryWorkloadsResponse,
          String,
          QueryWorkloadsPage,
          QueryWorkloadsFixedSizeCollection> {

    public static ApiFuture<QueryWorkloadsPagedResponse> createAsync(
        PageContext<QueryWorkloadsRequest, QueryWorkloadsResponse, String> context,
        ApiFuture<QueryWorkloadsResponse> futureResponse) {
      ApiFuture<QueryWorkloadsPage> futurePage =
          QueryWorkloadsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new QueryWorkloadsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private QueryWorkloadsPagedResponse(QueryWorkloadsPage page) {
      super(page, QueryWorkloadsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class QueryWorkloadsPage
      extends AbstractPage<
          QueryWorkloadsRequest, QueryWorkloadsResponse, String, QueryWorkloadsPage> {

    private QueryWorkloadsPage(
        @Nullable PageContext<QueryWorkloadsRequest, QueryWorkloadsResponse, String> context,
        @Nullable QueryWorkloadsResponse response) {
      super(context, response);
    }

    private static QueryWorkloadsPage createEmptyPage() {
      return new QueryWorkloadsPage(null, null);
    }

    @Override
    protected QueryWorkloadsPage createPage(
        @Nullable PageContext<QueryWorkloadsRequest, QueryWorkloadsResponse, String> context,
        @Nullable QueryWorkloadsResponse response) {
      return new QueryWorkloadsPage(context, response);
    }

    @Override
    public ApiFuture<QueryWorkloadsPage> createPageAsync(
        @Nullable PageContext<QueryWorkloadsRequest, QueryWorkloadsResponse, String> context,
        ApiFuture<QueryWorkloadsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class QueryWorkloadsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          QueryWorkloadsRequest,
          QueryWorkloadsResponse,
          String,
          QueryWorkloadsPage,
          QueryWorkloadsFixedSizeCollection> {

    private QueryWorkloadsFixedSizeCollection(
        @Nullable List<QueryWorkloadsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static QueryWorkloadsFixedSizeCollection createEmptyCollection() {
      return new QueryWorkloadsFixedSizeCollection(null, 0);
    }

    @Override
    protected QueryWorkloadsFixedSizeCollection createCollection(
        @Nullable List<QueryWorkloadsPage> pages, int collectionSize) {
      return new QueryWorkloadsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAuthorizationsPagedResponse
      extends AbstractPagedListResponse<
          ListAuthorizationsRequest,
          ListAuthorizationsResponse,
          Authorization,
          ListAuthorizationsPage,
          ListAuthorizationsFixedSizeCollection> {

    public static ApiFuture<ListAuthorizationsPagedResponse> createAsync(
        PageContext<ListAuthorizationsRequest, ListAuthorizationsResponse, Authorization> context,
        ApiFuture<ListAuthorizationsResponse> futureResponse) {
      ApiFuture<ListAuthorizationsPage> futurePage =
          ListAuthorizationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAuthorizationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAuthorizationsPagedResponse(ListAuthorizationsPage page) {
      super(page, ListAuthorizationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAuthorizationsPage
      extends AbstractPage<
          ListAuthorizationsRequest,
          ListAuthorizationsResponse,
          Authorization,
          ListAuthorizationsPage> {

    private ListAuthorizationsPage(
        @Nullable PageContext<ListAuthorizationsRequest, ListAuthorizationsResponse, Authorization>
            context,
        @Nullable ListAuthorizationsResponse response) {
      super(context, response);
    }

    private static ListAuthorizationsPage createEmptyPage() {
      return new ListAuthorizationsPage(null, null);
    }

    @Override
    protected ListAuthorizationsPage createPage(
        @Nullable PageContext<ListAuthorizationsRequest, ListAuthorizationsResponse, Authorization>
            context,
        @Nullable ListAuthorizationsResponse response) {
      return new ListAuthorizationsPage(context, response);
    }

    @Override
    public ApiFuture<ListAuthorizationsPage> createPageAsync(
        @Nullable PageContext<ListAuthorizationsRequest, ListAuthorizationsResponse, Authorization>
            context,
        ApiFuture<ListAuthorizationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAuthorizationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAuthorizationsRequest,
          ListAuthorizationsResponse,
          Authorization,
          ListAuthorizationsPage,
          ListAuthorizationsFixedSizeCollection> {

    private ListAuthorizationsFixedSizeCollection(
        @Nullable List<ListAuthorizationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAuthorizationsFixedSizeCollection createEmptyCollection() {
      return new ListAuthorizationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAuthorizationsFixedSizeCollection createCollection(
        @Nullable List<ListAuthorizationsPage> pages, int collectionSize) {
      return new ListAuthorizationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAccessSummariesPagedResponse
      extends AbstractPagedListResponse<
          ListAccessSummariesRequest,
          ListAccessSummariesResponse,
          AccessSummary,
          ListAccessSummariesPage,
          ListAccessSummariesFixedSizeCollection> {

    public static ApiFuture<ListAccessSummariesPagedResponse> createAsync(
        PageContext<ListAccessSummariesRequest, ListAccessSummariesResponse, AccessSummary> context,
        ApiFuture<ListAccessSummariesResponse> futureResponse) {
      ApiFuture<ListAccessSummariesPage> futurePage =
          ListAccessSummariesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAccessSummariesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAccessSummariesPagedResponse(ListAccessSummariesPage page) {
      super(page, ListAccessSummariesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAccessSummariesPage
      extends AbstractPage<
          ListAccessSummariesRequest,
          ListAccessSummariesResponse,
          AccessSummary,
          ListAccessSummariesPage> {

    private ListAccessSummariesPage(
        @Nullable
            PageContext<ListAccessSummariesRequest, ListAccessSummariesResponse, AccessSummary>
            context,
        @Nullable ListAccessSummariesResponse response) {
      super(context, response);
    }

    private static ListAccessSummariesPage createEmptyPage() {
      return new ListAccessSummariesPage(null, null);
    }

    @Override
    protected ListAccessSummariesPage createPage(
        @Nullable
            PageContext<ListAccessSummariesRequest, ListAccessSummariesResponse, AccessSummary>
            context,
        @Nullable ListAccessSummariesResponse response) {
      return new ListAccessSummariesPage(context, response);
    }

    @Override
    public ApiFuture<ListAccessSummariesPage> createPageAsync(
        @Nullable
            PageContext<ListAccessSummariesRequest, ListAccessSummariesResponse, AccessSummary>
            context,
        ApiFuture<ListAccessSummariesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAccessSummariesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAccessSummariesRequest,
          ListAccessSummariesResponse,
          AccessSummary,
          ListAccessSummariesPage,
          ListAccessSummariesFixedSizeCollection> {

    private ListAccessSummariesFixedSizeCollection(
        @Nullable List<ListAccessSummariesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAccessSummariesFixedSizeCollection createEmptyCollection() {
      return new ListAccessSummariesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAccessSummariesFixedSizeCollection createCollection(
        @Nullable List<ListAccessSummariesPage> pages, int collectionSize) {
      return new ListAccessSummariesFixedSizeCollection(pages, collectionSize);
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
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
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

    private ListLocationsFixedSizeCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
