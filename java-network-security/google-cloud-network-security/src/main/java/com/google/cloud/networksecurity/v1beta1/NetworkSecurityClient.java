/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.networksecurity.v1beta1;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1beta1.stub.NetworkSecurityStub;
import com.google.cloud.networksecurity.v1beta1.stub.NetworkSecurityStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
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
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
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
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetworkSecuritySettings networkSecuritySettings =
 *     NetworkSecuritySettings.newHttpJsonBuilder().build();
 * NetworkSecurityClient networkSecurityClient =
 *     NetworkSecurityClient.create(networkSecuritySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class NetworkSecurityClient implements BackgroundResource {
  private final NetworkSecuritySettings settings;
  private final NetworkSecurityStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

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
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected NetworkSecurityClient(NetworkSecurityStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
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
   *               AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
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
   *               AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
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
   *               AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
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
   *               AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
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
   *               AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
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
   *               AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
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
