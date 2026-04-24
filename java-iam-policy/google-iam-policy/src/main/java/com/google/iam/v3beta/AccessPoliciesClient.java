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

package com.google.iam.v3beta;

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
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v3beta.stub.AccessPoliciesStub;
import com.google.iam.v3beta.stub.AccessPoliciesStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages Identity and Access Management (IAM) access policies.
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
 * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
 *   AccessPolicyName name =
 *       AccessPolicyName.ofProjectLocationAccessPolicyName(
 *           "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]");
 *   AccessPolicy response = accessPoliciesClient.getAccessPolicy(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AccessPoliciesClient object to clean up resources such
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
 *      <td><p> CreateAccessPolicy</td>
 *      <td><p> Creates an access policy, and returns a long running operation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAccessPolicyAsync(CreateAccessPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createAccessPolicyAsync(FolderLocationName parent, AccessPolicy accessPolicy, String accessPolicyId)
 *           <li><p> createAccessPolicyAsync(LocationName parent, AccessPolicy accessPolicy, String accessPolicyId)
 *           <li><p> createAccessPolicyAsync(OrganizationLocationName parent, AccessPolicy accessPolicy, String accessPolicyId)
 *           <li><p> createAccessPolicyAsync(String parent, AccessPolicy accessPolicy, String accessPolicyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAccessPolicyOperationCallable()
 *           <li><p> createAccessPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAccessPolicy</td>
 *      <td><p> Gets an access policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAccessPolicy(GetAccessPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAccessPolicy(AccessPolicyName name)
 *           <li><p> getAccessPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAccessPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAccessPolicy</td>
 *      <td><p> Updates an access policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAccessPolicyAsync(UpdateAccessPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAccessPolicyOperationCallable()
 *           <li><p> updateAccessPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAccessPolicy</td>
 *      <td><p> Deletes an access policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAccessPolicyAsync(DeleteAccessPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAccessPolicyAsync(AccessPolicyName name)
 *           <li><p> deleteAccessPolicyAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAccessPolicyOperationCallable()
 *           <li><p> deleteAccessPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAccessPolicies</td>
 *      <td><p> Lists access policies.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAccessPolicies(ListAccessPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAccessPolicies(FolderLocationName parent)
 *           <li><p> listAccessPolicies(LocationName parent)
 *           <li><p> listAccessPolicies(OrganizationLocationName parent)
 *           <li><p> listAccessPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAccessPoliciesPagedCallable()
 *           <li><p> listAccessPoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchAccessPolicyBindings</td>
 *      <td><p> Returns all policy bindings that bind a specific policy if a user has searchPolicyBindings permission on that policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchAccessPolicyBindings(SearchAccessPolicyBindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchAccessPolicyBindings(AccessPolicyName name)
 *           <li><p> searchAccessPolicyBindings(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchAccessPolicyBindingsPagedCallable()
 *           <li><p> searchAccessPolicyBindingsCallable()
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
 * <p>This class can be customized by passing in a custom instance of AccessPoliciesSettings to
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
 * AccessPoliciesSettings accessPoliciesSettings =
 *     AccessPoliciesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create(accessPoliciesSettings);
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
 * AccessPoliciesSettings accessPoliciesSettings =
 *     AccessPoliciesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create(accessPoliciesSettings);
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
 * AccessPoliciesSettings accessPoliciesSettings =
 *     AccessPoliciesSettings.newHttpJsonBuilder().build();
 * AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create(accessPoliciesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AccessPoliciesClient implements BackgroundResource {
  private final AccessPoliciesSettings settings;
  private final AccessPoliciesStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of AccessPoliciesClient with default settings. */
  public static final AccessPoliciesClient create() throws IOException {
    return create(AccessPoliciesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AccessPoliciesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AccessPoliciesClient create(AccessPoliciesSettings settings)
      throws IOException {
    return new AccessPoliciesClient(settings);
  }

  /**
   * Constructs an instance of AccessPoliciesClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(AccessPoliciesSettings).
   */
  public static final AccessPoliciesClient create(AccessPoliciesStub stub) {
    return new AccessPoliciesClient(stub);
  }

  /**
   * Constructs an instance of AccessPoliciesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AccessPoliciesClient(AccessPoliciesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AccessPoliciesStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected AccessPoliciesClient(AccessPoliciesStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final AccessPoliciesSettings getSettings() {
    return settings;
  }

  public AccessPoliciesStub getStub() {
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
   * Creates an access policy, and returns a long running operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
   *   String accessPolicyId = "accessPolicyId97623921";
   *   AccessPolicy response =
   *       accessPoliciesClient.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this access policy will be created.
   *     <p>Format: `projects/{project_id}/locations/{location}`
   *     `projects/{project_number}/locations/{location}` `folders/{folder_id}/locations/{location}`
   *     `organizations/{organization_id}/locations/{location}`
   * @param accessPolicy Required. The access policy to create.
   * @param accessPolicyId Required. The ID to use for the access policy, which will become the
   *     final component of the access policy's resource name.
   *     <p>This value must start with a lowercase letter followed by up to 62 lowercase letters,
   *     numbers, hyphens, or dots. Pattern, /[a-z][a-z0-9-\\.]{2,62}/.
   *     <p>This value must be unique among all access policies with the same parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AccessPolicy, OperationMetadata> createAccessPolicyAsync(
      FolderLocationName parent, AccessPolicy accessPolicy, String accessPolicyId) {
    CreateAccessPolicyRequest request =
        CreateAccessPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAccessPolicy(accessPolicy)
            .setAccessPolicyId(accessPolicyId)
            .build();
    return createAccessPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an access policy, and returns a long running operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
   *   String accessPolicyId = "accessPolicyId97623921";
   *   AccessPolicy response =
   *       accessPoliciesClient.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this access policy will be created.
   *     <p>Format: `projects/{project_id}/locations/{location}`
   *     `projects/{project_number}/locations/{location}` `folders/{folder_id}/locations/{location}`
   *     `organizations/{organization_id}/locations/{location}`
   * @param accessPolicy Required. The access policy to create.
   * @param accessPolicyId Required. The ID to use for the access policy, which will become the
   *     final component of the access policy's resource name.
   *     <p>This value must start with a lowercase letter followed by up to 62 lowercase letters,
   *     numbers, hyphens, or dots. Pattern, /[a-z][a-z0-9-\\.]{2,62}/.
   *     <p>This value must be unique among all access policies with the same parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AccessPolicy, OperationMetadata> createAccessPolicyAsync(
      LocationName parent, AccessPolicy accessPolicy, String accessPolicyId) {
    CreateAccessPolicyRequest request =
        CreateAccessPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAccessPolicy(accessPolicy)
            .setAccessPolicyId(accessPolicyId)
            .build();
    return createAccessPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an access policy, and returns a long running operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
   *   String accessPolicyId = "accessPolicyId97623921";
   *   AccessPolicy response =
   *       accessPoliciesClient.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this access policy will be created.
   *     <p>Format: `projects/{project_id}/locations/{location}`
   *     `projects/{project_number}/locations/{location}` `folders/{folder_id}/locations/{location}`
   *     `organizations/{organization_id}/locations/{location}`
   * @param accessPolicy Required. The access policy to create.
   * @param accessPolicyId Required. The ID to use for the access policy, which will become the
   *     final component of the access policy's resource name.
   *     <p>This value must start with a lowercase letter followed by up to 62 lowercase letters,
   *     numbers, hyphens, or dots. Pattern, /[a-z][a-z0-9-\\.]{2,62}/.
   *     <p>This value must be unique among all access policies with the same parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AccessPolicy, OperationMetadata> createAccessPolicyAsync(
      OrganizationLocationName parent, AccessPolicy accessPolicy, String accessPolicyId) {
    CreateAccessPolicyRequest request =
        CreateAccessPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAccessPolicy(accessPolicy)
            .setAccessPolicyId(accessPolicyId)
            .build();
    return createAccessPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an access policy, and returns a long running operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   AccessPolicy accessPolicy = AccessPolicy.newBuilder().build();
   *   String accessPolicyId = "accessPolicyId97623921";
   *   AccessPolicy response =
   *       accessPoliciesClient.createAccessPolicyAsync(parent, accessPolicy, accessPolicyId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this access policy will be created.
   *     <p>Format: `projects/{project_id}/locations/{location}`
   *     `projects/{project_number}/locations/{location}` `folders/{folder_id}/locations/{location}`
   *     `organizations/{organization_id}/locations/{location}`
   * @param accessPolicy Required. The access policy to create.
   * @param accessPolicyId Required. The ID to use for the access policy, which will become the
   *     final component of the access policy's resource name.
   *     <p>This value must start with a lowercase letter followed by up to 62 lowercase letters,
   *     numbers, hyphens, or dots. Pattern, /[a-z][a-z0-9-\\.]{2,62}/.
   *     <p>This value must be unique among all access policies with the same parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AccessPolicy, OperationMetadata> createAccessPolicyAsync(
      String parent, AccessPolicy accessPolicy, String accessPolicyId) {
    CreateAccessPolicyRequest request =
        CreateAccessPolicyRequest.newBuilder()
            .setParent(parent)
            .setAccessPolicy(accessPolicy)
            .setAccessPolicyId(accessPolicyId)
            .build();
    return createAccessPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an access policy, and returns a long running operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   CreateAccessPolicyRequest request =
   *       CreateAccessPolicyRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setAccessPolicyId("accessPolicyId97623921")
   *           .setAccessPolicy(AccessPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   AccessPolicy response = accessPoliciesClient.createAccessPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AccessPolicy, OperationMetadata> createAccessPolicyAsync(
      CreateAccessPolicyRequest request) {
    return createAccessPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an access policy, and returns a long running operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   CreateAccessPolicyRequest request =
   *       CreateAccessPolicyRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setAccessPolicyId("accessPolicyId97623921")
   *           .setAccessPolicy(AccessPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<AccessPolicy, OperationMetadata> future =
   *       accessPoliciesClient.createAccessPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   AccessPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      createAccessPolicyOperationCallable() {
    return stub.createAccessPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an access policy, and returns a long running operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   CreateAccessPolicyRequest request =
   *       CreateAccessPolicyRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setAccessPolicyId("accessPolicyId97623921")
   *           .setAccessPolicy(AccessPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       accessPoliciesClient.createAccessPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAccessPolicyRequest, Operation> createAccessPolicyCallable() {
    return stub.createAccessPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an access policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   AccessPolicyName name =
   *       AccessPolicyName.ofProjectLocationAccessPolicyName(
   *           "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]");
   *   AccessPolicy response = accessPoliciesClient.getAccessPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the access policy to retrieve.
   *     <p>Format: `projects/{project_id}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `projects/{project_number}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `folders/{folder_id}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `organizations/{organization_id}/locations/{location}/accessPolicies/{access_policy_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessPolicy getAccessPolicy(AccessPolicyName name) {
    GetAccessPolicyRequest request =
        GetAccessPolicyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAccessPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an access policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   String name =
   *       AccessPolicyName.ofOrganizationLocationAccessPolicyName(
   *               "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]")
   *           .toString();
   *   AccessPolicy response = accessPoliciesClient.getAccessPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the access policy to retrieve.
   *     <p>Format: `projects/{project_id}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `projects/{project_number}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `folders/{folder_id}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `organizations/{organization_id}/locations/{location}/accessPolicies/{access_policy_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessPolicy getAccessPolicy(String name) {
    GetAccessPolicyRequest request = GetAccessPolicyRequest.newBuilder().setName(name).build();
    return getAccessPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an access policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   GetAccessPolicyRequest request =
   *       GetAccessPolicyRequest.newBuilder()
   *           .setName(
   *               AccessPolicyName.ofProjectLocationAccessPolicyName(
   *                       "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]")
   *                   .toString())
   *           .build();
   *   AccessPolicy response = accessPoliciesClient.getAccessPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessPolicy getAccessPolicy(GetAccessPolicyRequest request) {
    return getAccessPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an access policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   GetAccessPolicyRequest request =
   *       GetAccessPolicyRequest.newBuilder()
   *           .setName(
   *               AccessPolicyName.ofProjectLocationAccessPolicyName(
   *                       "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AccessPolicy> future =
   *       accessPoliciesClient.getAccessPolicyCallable().futureCall(request);
   *   // Do something.
   *   AccessPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAccessPolicyRequest, AccessPolicy> getAccessPolicyCallable() {
    return stub.getAccessPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an access policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   UpdateAccessPolicyRequest request =
   *       UpdateAccessPolicyRequest.newBuilder()
   *           .setAccessPolicy(AccessPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   AccessPolicy response = accessPoliciesClient.updateAccessPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AccessPolicy, OperationMetadata> updateAccessPolicyAsync(
      UpdateAccessPolicyRequest request) {
    return updateAccessPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an access policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   UpdateAccessPolicyRequest request =
   *       UpdateAccessPolicyRequest.newBuilder()
   *           .setAccessPolicy(AccessPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<AccessPolicy, OperationMetadata> future =
   *       accessPoliciesClient.updateAccessPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   AccessPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      updateAccessPolicyOperationCallable() {
    return stub.updateAccessPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an access policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   UpdateAccessPolicyRequest request =
   *       UpdateAccessPolicyRequest.newBuilder()
   *           .setAccessPolicy(AccessPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       accessPoliciesClient.updateAccessPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAccessPolicyRequest, Operation> updateAccessPolicyCallable() {
    return stub.updateAccessPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an access policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   AccessPolicyName name =
   *       AccessPolicyName.ofProjectLocationAccessPolicyName(
   *           "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]");
   *   accessPoliciesClient.deleteAccessPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the access policy to delete.
   *     <p>Format: `projects/{project_id}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `projects/{project_number}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `folders/{folder_id}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `organizations/{organization_id}/locations/{location}/accessPolicies/{access_policy_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAccessPolicyAsync(
      AccessPolicyName name) {
    DeleteAccessPolicyRequest request =
        DeleteAccessPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteAccessPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an access policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   String name =
   *       AccessPolicyName.ofOrganizationLocationAccessPolicyName(
   *               "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]")
   *           .toString();
   *   accessPoliciesClient.deleteAccessPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the access policy to delete.
   *     <p>Format: `projects/{project_id}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `projects/{project_number}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `folders/{folder_id}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `organizations/{organization_id}/locations/{location}/accessPolicies/{access_policy_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAccessPolicyAsync(String name) {
    DeleteAccessPolicyRequest request =
        DeleteAccessPolicyRequest.newBuilder().setName(name).build();
    return deleteAccessPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an access policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   DeleteAccessPolicyRequest request =
   *       DeleteAccessPolicyRequest.newBuilder()
   *           .setName(
   *               AccessPolicyName.ofProjectLocationAccessPolicyName(
   *                       "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   accessPoliciesClient.deleteAccessPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAccessPolicyAsync(
      DeleteAccessPolicyRequest request) {
    return deleteAccessPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an access policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   DeleteAccessPolicyRequest request =
   *       DeleteAccessPolicyRequest.newBuilder()
   *           .setName(
   *               AccessPolicyName.ofProjectLocationAccessPolicyName(
   *                       "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       accessPoliciesClient.deleteAccessPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAccessPolicyRequest, Empty, OperationMetadata>
      deleteAccessPolicyOperationCallable() {
    return stub.deleteAccessPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an access policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   DeleteAccessPolicyRequest request =
   *       DeleteAccessPolicyRequest.newBuilder()
   *           .setName(
   *               AccessPolicyName.ofProjectLocationAccessPolicyName(
   *                       "[PROJECT]", "[LOCATION]", "[ACCESS_POLICY]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       accessPoliciesClient.deleteAccessPolicyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAccessPolicyRequest, Operation> deleteAccessPolicyCallable() {
    return stub.deleteAccessPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists access policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   for (AccessPolicy element : accessPoliciesClient.listAccessPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource, which owns the collection of access policy
   *     resources.
   *     <p>Format: `projects/{project_id}/locations/{location}`
   *     `projects/{project_number}/locations/{location}` `folders/{folder_id}/locations/{location}`
   *     `organizations/{organization_id}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessPoliciesPagedResponse listAccessPolicies(FolderLocationName parent) {
    ListAccessPoliciesRequest request =
        ListAccessPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAccessPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists access policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AccessPolicy element : accessPoliciesClient.listAccessPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource, which owns the collection of access policy
   *     resources.
   *     <p>Format: `projects/{project_id}/locations/{location}`
   *     `projects/{project_number}/locations/{location}` `folders/{folder_id}/locations/{location}`
   *     `organizations/{organization_id}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessPoliciesPagedResponse listAccessPolicies(LocationName parent) {
    ListAccessPoliciesRequest request =
        ListAccessPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAccessPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists access policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (AccessPolicy element : accessPoliciesClient.listAccessPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource, which owns the collection of access policy
   *     resources.
   *     <p>Format: `projects/{project_id}/locations/{location}`
   *     `projects/{project_number}/locations/{location}` `folders/{folder_id}/locations/{location}`
   *     `organizations/{organization_id}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessPoliciesPagedResponse listAccessPolicies(OrganizationLocationName parent) {
    ListAccessPoliciesRequest request =
        ListAccessPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAccessPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists access policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (AccessPolicy element : accessPoliciesClient.listAccessPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource, which owns the collection of access policy
   *     resources.
   *     <p>Format: `projects/{project_id}/locations/{location}`
   *     `projects/{project_number}/locations/{location}` `folders/{folder_id}/locations/{location}`
   *     `organizations/{organization_id}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessPoliciesPagedResponse listAccessPolicies(String parent) {
    ListAccessPoliciesRequest request =
        ListAccessPoliciesRequest.newBuilder().setParent(parent).build();
    return listAccessPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists access policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   ListAccessPoliciesRequest request =
   *       ListAccessPoliciesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AccessPolicy element : accessPoliciesClient.listAccessPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessPoliciesPagedResponse listAccessPolicies(
      ListAccessPoliciesRequest request) {
    return listAccessPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists access policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   ListAccessPoliciesRequest request =
   *       ListAccessPoliciesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AccessPolicy> future =
   *       accessPoliciesClient.listAccessPoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AccessPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesPagedResponse>
      listAccessPoliciesPagedCallable() {
    return stub.listAccessPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists access policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   ListAccessPoliciesRequest request =
   *       ListAccessPoliciesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAccessPoliciesResponse response =
   *         accessPoliciesClient.listAccessPoliciesCallable().call(request);
   *     for (AccessPolicy element : response.getAccessPoliciesList()) {
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
  public final UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
      listAccessPoliciesCallable() {
    return stub.listAccessPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all policy bindings that bind a specific policy if a user has searchPolicyBindings
   * permission on that policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   AccessPolicyName name =
   *       AccessPolicyName.ofOrganizationLocationAccessPolicyName(
   *           "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]");
   *   for (PolicyBinding element :
   *       accessPoliciesClient.searchAccessPolicyBindings(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the access policy. Format:
   *     `organizations/{organization_id}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `folders/{folder_id}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `projects/{project_id}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `projects/{project_number}/locations/{location}/accessPolicies/{access_policy_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAccessPolicyBindingsPagedResponse searchAccessPolicyBindings(
      AccessPolicyName name) {
    SearchAccessPolicyBindingsRequest request =
        SearchAccessPolicyBindingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return searchAccessPolicyBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all policy bindings that bind a specific policy if a user has searchPolicyBindings
   * permission on that policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   String name =
   *       AccessPolicyName.ofOrganizationLocationAccessPolicyName(
   *               "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]")
   *           .toString();
   *   for (PolicyBinding element :
   *       accessPoliciesClient.searchAccessPolicyBindings(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the access policy. Format:
   *     `organizations/{organization_id}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `folders/{folder_id}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `projects/{project_id}/locations/{location}/accessPolicies/{access_policy_id}`
   *     `projects/{project_number}/locations/{location}/accessPolicies/{access_policy_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAccessPolicyBindingsPagedResponse searchAccessPolicyBindings(String name) {
    SearchAccessPolicyBindingsRequest request =
        SearchAccessPolicyBindingsRequest.newBuilder().setName(name).build();
    return searchAccessPolicyBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all policy bindings that bind a specific policy if a user has searchPolicyBindings
   * permission on that policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   SearchAccessPolicyBindingsRequest request =
   *       SearchAccessPolicyBindingsRequest.newBuilder()
   *           .setName(
   *               AccessPolicyName.ofOrganizationLocationAccessPolicyName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PolicyBinding element :
   *       accessPoliciesClient.searchAccessPolicyBindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAccessPolicyBindingsPagedResponse searchAccessPolicyBindings(
      SearchAccessPolicyBindingsRequest request) {
    return searchAccessPolicyBindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all policy bindings that bind a specific policy if a user has searchPolicyBindings
   * permission on that policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   SearchAccessPolicyBindingsRequest request =
   *       SearchAccessPolicyBindingsRequest.newBuilder()
   *           .setName(
   *               AccessPolicyName.ofOrganizationLocationAccessPolicyName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PolicyBinding> future =
   *       accessPoliciesClient.searchAccessPolicyBindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PolicyBinding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsPagedResponse>
      searchAccessPolicyBindingsPagedCallable() {
    return stub.searchAccessPolicyBindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns all policy bindings that bind a specific policy if a user has searchPolicyBindings
   * permission on that policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccessPoliciesClient accessPoliciesClient = AccessPoliciesClient.create()) {
   *   SearchAccessPolicyBindingsRequest request =
   *       SearchAccessPolicyBindingsRequest.newBuilder()
   *           .setName(
   *               AccessPolicyName.ofOrganizationLocationAccessPolicyName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[ACCESS_POLICY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchAccessPolicyBindingsResponse response =
   *         accessPoliciesClient.searchAccessPolicyBindingsCallable().call(request);
   *     for (PolicyBinding element : response.getPolicyBindingsList()) {
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
  public final UnaryCallable<SearchAccessPolicyBindingsRequest, SearchAccessPolicyBindingsResponse>
      searchAccessPolicyBindingsCallable() {
    return stub.searchAccessPolicyBindingsCallable();
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

  public static class ListAccessPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListAccessPoliciesRequest,
          ListAccessPoliciesResponse,
          AccessPolicy,
          ListAccessPoliciesPage,
          ListAccessPoliciesFixedSizeCollection> {

    public static ApiFuture<ListAccessPoliciesPagedResponse> createAsync(
        PageContext<ListAccessPoliciesRequest, ListAccessPoliciesResponse, AccessPolicy> context,
        ApiFuture<ListAccessPoliciesResponse> futureResponse) {
      ApiFuture<ListAccessPoliciesPage> futurePage =
          ListAccessPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAccessPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAccessPoliciesPagedResponse(ListAccessPoliciesPage page) {
      super(page, ListAccessPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAccessPoliciesPage
      extends AbstractPage<
          ListAccessPoliciesRequest,
          ListAccessPoliciesResponse,
          AccessPolicy,
          ListAccessPoliciesPage> {

    private ListAccessPoliciesPage(
        PageContext<ListAccessPoliciesRequest, ListAccessPoliciesResponse, AccessPolicy> context,
        ListAccessPoliciesResponse response) {
      super(context, response);
    }

    private static ListAccessPoliciesPage createEmptyPage() {
      return new ListAccessPoliciesPage(null, null);
    }

    @Override
    protected ListAccessPoliciesPage createPage(
        PageContext<ListAccessPoliciesRequest, ListAccessPoliciesResponse, AccessPolicy> context,
        ListAccessPoliciesResponse response) {
      return new ListAccessPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListAccessPoliciesPage> createPageAsync(
        PageContext<ListAccessPoliciesRequest, ListAccessPoliciesResponse, AccessPolicy> context,
        ApiFuture<ListAccessPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAccessPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAccessPoliciesRequest,
          ListAccessPoliciesResponse,
          AccessPolicy,
          ListAccessPoliciesPage,
          ListAccessPoliciesFixedSizeCollection> {

    private ListAccessPoliciesFixedSizeCollection(
        List<ListAccessPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAccessPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListAccessPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAccessPoliciesFixedSizeCollection createCollection(
        List<ListAccessPoliciesPage> pages, int collectionSize) {
      return new ListAccessPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchAccessPolicyBindingsPagedResponse
      extends AbstractPagedListResponse<
          SearchAccessPolicyBindingsRequest,
          SearchAccessPolicyBindingsResponse,
          PolicyBinding,
          SearchAccessPolicyBindingsPage,
          SearchAccessPolicyBindingsFixedSizeCollection> {

    public static ApiFuture<SearchAccessPolicyBindingsPagedResponse> createAsync(
        PageContext<
                SearchAccessPolicyBindingsRequest,
                SearchAccessPolicyBindingsResponse,
                PolicyBinding>
            context,
        ApiFuture<SearchAccessPolicyBindingsResponse> futureResponse) {
      ApiFuture<SearchAccessPolicyBindingsPage> futurePage =
          SearchAccessPolicyBindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchAccessPolicyBindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchAccessPolicyBindingsPagedResponse(SearchAccessPolicyBindingsPage page) {
      super(page, SearchAccessPolicyBindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchAccessPolicyBindingsPage
      extends AbstractPage<
          SearchAccessPolicyBindingsRequest,
          SearchAccessPolicyBindingsResponse,
          PolicyBinding,
          SearchAccessPolicyBindingsPage> {

    private SearchAccessPolicyBindingsPage(
        PageContext<
                SearchAccessPolicyBindingsRequest,
                SearchAccessPolicyBindingsResponse,
                PolicyBinding>
            context,
        SearchAccessPolicyBindingsResponse response) {
      super(context, response);
    }

    private static SearchAccessPolicyBindingsPage createEmptyPage() {
      return new SearchAccessPolicyBindingsPage(null, null);
    }

    @Override
    protected SearchAccessPolicyBindingsPage createPage(
        PageContext<
                SearchAccessPolicyBindingsRequest,
                SearchAccessPolicyBindingsResponse,
                PolicyBinding>
            context,
        SearchAccessPolicyBindingsResponse response) {
      return new SearchAccessPolicyBindingsPage(context, response);
    }

    @Override
    public ApiFuture<SearchAccessPolicyBindingsPage> createPageAsync(
        PageContext<
                SearchAccessPolicyBindingsRequest,
                SearchAccessPolicyBindingsResponse,
                PolicyBinding>
            context,
        ApiFuture<SearchAccessPolicyBindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchAccessPolicyBindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchAccessPolicyBindingsRequest,
          SearchAccessPolicyBindingsResponse,
          PolicyBinding,
          SearchAccessPolicyBindingsPage,
          SearchAccessPolicyBindingsFixedSizeCollection> {

    private SearchAccessPolicyBindingsFixedSizeCollection(
        List<SearchAccessPolicyBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchAccessPolicyBindingsFixedSizeCollection createEmptyCollection() {
      return new SearchAccessPolicyBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchAccessPolicyBindingsFixedSizeCollection createCollection(
        List<SearchAccessPolicyBindingsPage> pages, int collectionSize) {
      return new SearchAccessPolicyBindingsFixedSizeCollection(pages, collectionSize);
    }
  }
}
