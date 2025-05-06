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
import com.google.iam.v3beta.stub.PolicyBindingsStub;
import com.google.iam.v3beta.stub.PolicyBindingsStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: An interface for managing Identity and Access Management (IAM) policy
 * bindings.
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
 * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
 *   PolicyBindingName name =
 *       PolicyBindingName.ofProjectLocationPolicyBindingName(
 *           "[PROJECT]", "[LOCATION]", "[POLICY_BINDING]");
 *   PolicyBinding response = policyBindingsClient.getPolicyBinding(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PolicyBindingsClient object to clean up resources such
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
 *      <td><p> CreatePolicyBinding</td>
 *      <td><p> Creates a policy binding and returns a long-running operation. Callers will need the IAM permissions on both the policy and target. Once the binding is created, the policy is applied to the target.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPolicyBindingAsync(CreatePolicyBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createPolicyBindingAsync(FolderLocationName parent, PolicyBinding policyBinding, String policyBindingId)
 *           <li><p> createPolicyBindingAsync(LocationName parent, PolicyBinding policyBinding, String policyBindingId)
 *           <li><p> createPolicyBindingAsync(OrganizationLocationName parent, PolicyBinding policyBinding, String policyBindingId)
 *           <li><p> createPolicyBindingAsync(String parent, PolicyBinding policyBinding, String policyBindingId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPolicyBindingOperationCallable()
 *           <li><p> createPolicyBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPolicyBinding</td>
 *      <td><p> Gets a policy binding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPolicyBinding(GetPolicyBindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPolicyBinding(PolicyBindingName name)
 *           <li><p> getPolicyBinding(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPolicyBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePolicyBinding</td>
 *      <td><p> Updates a policy binding and returns a long-running operation. Callers will need the IAM permissions on the policy and target in the binding to update, and the IAM permission to remove the existing policy from the binding. Target is immutable and cannot be updated. Once the binding is updated, the new policy is applied to the target.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePolicyBindingAsync(UpdatePolicyBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updatePolicyBindingAsync(PolicyBinding policyBinding, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePolicyBindingOperationCallable()
 *           <li><p> updatePolicyBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePolicyBinding</td>
 *      <td><p> Deletes a policy binding and returns a long-running operation. Callers will need the IAM permissions on both the policy and target. Once the binding is deleted, the policy no longer applies to the target.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePolicyBindingAsync(DeletePolicyBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deletePolicyBindingAsync(PolicyBindingName name)
 *           <li><p> deletePolicyBindingAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePolicyBindingOperationCallable()
 *           <li><p> deletePolicyBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPolicyBindings</td>
 *      <td><p> Lists policy bindings.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPolicyBindings(ListPolicyBindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPolicyBindings(FolderLocationName parent)
 *           <li><p> listPolicyBindings(LocationName parent)
 *           <li><p> listPolicyBindings(OrganizationLocationName parent)
 *           <li><p> listPolicyBindings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPolicyBindingsPagedCallable()
 *           <li><p> listPolicyBindingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchTargetPolicyBindings</td>
 *      <td><p> Search policy bindings by target. Returns all policy binding objects bound directly to target.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchTargetPolicyBindings(SearchTargetPolicyBindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchTargetPolicyBindings(FolderLocationName parent, String target)
 *           <li><p> searchTargetPolicyBindings(LocationName parent, String target)
 *           <li><p> searchTargetPolicyBindings(OrganizationLocationName parent, String target)
 *           <li><p> searchTargetPolicyBindings(String parent, String target)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchTargetPolicyBindingsPagedCallable()
 *           <li><p> searchTargetPolicyBindingsCallable()
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
 * <p>This class can be customized by passing in a custom instance of PolicyBindingsSettings to
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
 * PolicyBindingsSettings policyBindingsSettings =
 *     PolicyBindingsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create(policyBindingsSettings);
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
 * PolicyBindingsSettings policyBindingsSettings =
 *     PolicyBindingsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create(policyBindingsSettings);
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
 * PolicyBindingsSettings policyBindingsSettings =
 *     PolicyBindingsSettings.newHttpJsonBuilder().build();
 * PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create(policyBindingsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PolicyBindingsClient implements BackgroundResource {
  private final PolicyBindingsSettings settings;
  private final PolicyBindingsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of PolicyBindingsClient with default settings. */
  public static final PolicyBindingsClient create() throws IOException {
    return create(PolicyBindingsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PolicyBindingsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PolicyBindingsClient create(PolicyBindingsSettings settings)
      throws IOException {
    return new PolicyBindingsClient(settings);
  }

  /**
   * Constructs an instance of PolicyBindingsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(PolicyBindingsSettings).
   */
  public static final PolicyBindingsClient create(PolicyBindingsStub stub) {
    return new PolicyBindingsClient(stub);
  }

  /**
   * Constructs an instance of PolicyBindingsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PolicyBindingsClient(PolicyBindingsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PolicyBindingsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected PolicyBindingsClient(PolicyBindingsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final PolicyBindingsSettings getSettings() {
    return settings;
  }

  public PolicyBindingsStub getStub() {
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
   * Creates a policy binding and returns a long-running operation. Callers will need the IAM
   * permissions on both the policy and target. Once the binding is created, the policy is applied
   * to the target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   PolicyBinding policyBinding = PolicyBinding.newBuilder().build();
   *   String policyBindingId = "policyBindingId1375821166";
   *   PolicyBinding response =
   *       policyBindingsClient
   *           .createPolicyBindingAsync(parent, policyBinding, policyBindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this policy binding will be created. The
   *     binding parent is the closest Resource Manager resource (project, folder or organization)
   *     to the binding target.
   *     <p>Format:
   *     <ul>
   *       <li>`projects/{project_id}/locations/{location}`
   *       <li>`projects/{project_number}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`organizations/{organization_id}/locations/{location}`
   *     </ul>
   *
   * @param policyBinding Required. The policy binding to create.
   * @param policyBindingId Required. The ID to use for the policy binding, which will become the
   *     final component of the policy binding's resource name.
   *     <p>This value must start with a lowercase letter followed by up to 62 lowercase letters,
   *     numbers, hyphens, or dots. Pattern, /[a-z][a-z0-9-\\.]{2,62}/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PolicyBinding, OperationMetadata> createPolicyBindingAsync(
      FolderLocationName parent, PolicyBinding policyBinding, String policyBindingId) {
    CreatePolicyBindingRequest request =
        CreatePolicyBindingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPolicyBinding(policyBinding)
            .setPolicyBindingId(policyBindingId)
            .build();
    return createPolicyBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy binding and returns a long-running operation. Callers will need the IAM
   * permissions on both the policy and target. Once the binding is created, the policy is applied
   * to the target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   PolicyBinding policyBinding = PolicyBinding.newBuilder().build();
   *   String policyBindingId = "policyBindingId1375821166";
   *   PolicyBinding response =
   *       policyBindingsClient
   *           .createPolicyBindingAsync(parent, policyBinding, policyBindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this policy binding will be created. The
   *     binding parent is the closest Resource Manager resource (project, folder or organization)
   *     to the binding target.
   *     <p>Format:
   *     <ul>
   *       <li>`projects/{project_id}/locations/{location}`
   *       <li>`projects/{project_number}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`organizations/{organization_id}/locations/{location}`
   *     </ul>
   *
   * @param policyBinding Required. The policy binding to create.
   * @param policyBindingId Required. The ID to use for the policy binding, which will become the
   *     final component of the policy binding's resource name.
   *     <p>This value must start with a lowercase letter followed by up to 62 lowercase letters,
   *     numbers, hyphens, or dots. Pattern, /[a-z][a-z0-9-\\.]{2,62}/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PolicyBinding, OperationMetadata> createPolicyBindingAsync(
      LocationName parent, PolicyBinding policyBinding, String policyBindingId) {
    CreatePolicyBindingRequest request =
        CreatePolicyBindingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPolicyBinding(policyBinding)
            .setPolicyBindingId(policyBindingId)
            .build();
    return createPolicyBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy binding and returns a long-running operation. Callers will need the IAM
   * permissions on both the policy and target. Once the binding is created, the policy is applied
   * to the target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   PolicyBinding policyBinding = PolicyBinding.newBuilder().build();
   *   String policyBindingId = "policyBindingId1375821166";
   *   PolicyBinding response =
   *       policyBindingsClient
   *           .createPolicyBindingAsync(parent, policyBinding, policyBindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this policy binding will be created. The
   *     binding parent is the closest Resource Manager resource (project, folder or organization)
   *     to the binding target.
   *     <p>Format:
   *     <ul>
   *       <li>`projects/{project_id}/locations/{location}`
   *       <li>`projects/{project_number}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`organizations/{organization_id}/locations/{location}`
   *     </ul>
   *
   * @param policyBinding Required. The policy binding to create.
   * @param policyBindingId Required. The ID to use for the policy binding, which will become the
   *     final component of the policy binding's resource name.
   *     <p>This value must start with a lowercase letter followed by up to 62 lowercase letters,
   *     numbers, hyphens, or dots. Pattern, /[a-z][a-z0-9-\\.]{2,62}/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PolicyBinding, OperationMetadata> createPolicyBindingAsync(
      OrganizationLocationName parent, PolicyBinding policyBinding, String policyBindingId) {
    CreatePolicyBindingRequest request =
        CreatePolicyBindingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPolicyBinding(policyBinding)
            .setPolicyBindingId(policyBindingId)
            .build();
    return createPolicyBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy binding and returns a long-running operation. Callers will need the IAM
   * permissions on both the policy and target. Once the binding is created, the policy is applied
   * to the target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   PolicyBinding policyBinding = PolicyBinding.newBuilder().build();
   *   String policyBindingId = "policyBindingId1375821166";
   *   PolicyBinding response =
   *       policyBindingsClient
   *           .createPolicyBindingAsync(parent, policyBinding, policyBindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this policy binding will be created. The
   *     binding parent is the closest Resource Manager resource (project, folder or organization)
   *     to the binding target.
   *     <p>Format:
   *     <ul>
   *       <li>`projects/{project_id}/locations/{location}`
   *       <li>`projects/{project_number}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`organizations/{organization_id}/locations/{location}`
   *     </ul>
   *
   * @param policyBinding Required. The policy binding to create.
   * @param policyBindingId Required. The ID to use for the policy binding, which will become the
   *     final component of the policy binding's resource name.
   *     <p>This value must start with a lowercase letter followed by up to 62 lowercase letters,
   *     numbers, hyphens, or dots. Pattern, /[a-z][a-z0-9-\\.]{2,62}/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PolicyBinding, OperationMetadata> createPolicyBindingAsync(
      String parent, PolicyBinding policyBinding, String policyBindingId) {
    CreatePolicyBindingRequest request =
        CreatePolicyBindingRequest.newBuilder()
            .setParent(parent)
            .setPolicyBinding(policyBinding)
            .setPolicyBindingId(policyBindingId)
            .build();
    return createPolicyBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy binding and returns a long-running operation. Callers will need the IAM
   * permissions on both the policy and target. Once the binding is created, the policy is applied
   * to the target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   CreatePolicyBindingRequest request =
   *       CreatePolicyBindingRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPolicyBindingId("policyBindingId1375821166")
   *           .setPolicyBinding(PolicyBinding.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   PolicyBinding response = policyBindingsClient.createPolicyBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PolicyBinding, OperationMetadata> createPolicyBindingAsync(
      CreatePolicyBindingRequest request) {
    return createPolicyBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy binding and returns a long-running operation. Callers will need the IAM
   * permissions on both the policy and target. Once the binding is created, the policy is applied
   * to the target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   CreatePolicyBindingRequest request =
   *       CreatePolicyBindingRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPolicyBindingId("policyBindingId1375821166")
   *           .setPolicyBinding(PolicyBinding.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<PolicyBinding, OperationMetadata> future =
   *       policyBindingsClient.createPolicyBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   PolicyBinding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      createPolicyBindingOperationCallable() {
    return stub.createPolicyBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy binding and returns a long-running operation. Callers will need the IAM
   * permissions on both the policy and target. Once the binding is created, the policy is applied
   * to the target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   CreatePolicyBindingRequest request =
   *       CreatePolicyBindingRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPolicyBindingId("policyBindingId1375821166")
   *           .setPolicyBinding(PolicyBinding.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       policyBindingsClient.createPolicyBindingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePolicyBindingRequest, Operation> createPolicyBindingCallable() {
    return stub.createPolicyBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a policy binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   PolicyBindingName name =
   *       PolicyBindingName.ofProjectLocationPolicyBindingName(
   *           "[PROJECT]", "[LOCATION]", "[POLICY_BINDING]");
   *   PolicyBinding response = policyBindingsClient.getPolicyBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the policy binding to retrieve.
   *     <p>Format:
   *     <ul>
   *       <li>`projects/{project_id}/locations/{location}/policyBindings/{policy_binding_id}`
   *       <li>`projects/{project_number}/locations/{location}/policyBindings/{policy_binding_id}`
   *       <li>`folders/{folder_id}/locations/{location}/policyBindings/{policy_binding_id}`
   *       <li>`organizations/{organization_id}/locations/{location}/policyBindings/{policy_binding_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PolicyBinding getPolicyBinding(PolicyBindingName name) {
    GetPolicyBindingRequest request =
        GetPolicyBindingRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPolicyBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a policy binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   String name =
   *       PolicyBindingName.ofOrganizationLocationPolicyBindingName(
   *               "[ORGANIZATION]", "[LOCATION]", "[POLICY_BINDING]")
   *           .toString();
   *   PolicyBinding response = policyBindingsClient.getPolicyBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the policy binding to retrieve.
   *     <p>Format:
   *     <ul>
   *       <li>`projects/{project_id}/locations/{location}/policyBindings/{policy_binding_id}`
   *       <li>`projects/{project_number}/locations/{location}/policyBindings/{policy_binding_id}`
   *       <li>`folders/{folder_id}/locations/{location}/policyBindings/{policy_binding_id}`
   *       <li>`organizations/{organization_id}/locations/{location}/policyBindings/{policy_binding_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PolicyBinding getPolicyBinding(String name) {
    GetPolicyBindingRequest request = GetPolicyBindingRequest.newBuilder().setName(name).build();
    return getPolicyBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a policy binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   GetPolicyBindingRequest request =
   *       GetPolicyBindingRequest.newBuilder()
   *           .setName(
   *               PolicyBindingName.ofProjectLocationPolicyBindingName(
   *                       "[PROJECT]", "[LOCATION]", "[POLICY_BINDING]")
   *                   .toString())
   *           .build();
   *   PolicyBinding response = policyBindingsClient.getPolicyBinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PolicyBinding getPolicyBinding(GetPolicyBindingRequest request) {
    return getPolicyBindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a policy binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   GetPolicyBindingRequest request =
   *       GetPolicyBindingRequest.newBuilder()
   *           .setName(
   *               PolicyBindingName.ofProjectLocationPolicyBindingName(
   *                       "[PROJECT]", "[LOCATION]", "[POLICY_BINDING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PolicyBinding> future =
   *       policyBindingsClient.getPolicyBindingCallable().futureCall(request);
   *   // Do something.
   *   PolicyBinding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPolicyBindingRequest, PolicyBinding> getPolicyBindingCallable() {
    return stub.getPolicyBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a policy binding and returns a long-running operation. Callers will need the IAM
   * permissions on the policy and target in the binding to update, and the IAM permission to remove
   * the existing policy from the binding. Target is immutable and cannot be updated. Once the
   * binding is updated, the new policy is applied to the target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   PolicyBinding policyBinding = PolicyBinding.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PolicyBinding response =
   *       policyBindingsClient.updatePolicyBindingAsync(policyBinding, updateMask).get();
   * }
   * }</pre>
   *
   * @param policyBinding Required. The policy binding to update.
   *     <p>The policy binding's `name` field is used to identify the policy binding to update.
   * @param updateMask Optional. The list of fields to update
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PolicyBinding, OperationMetadata> updatePolicyBindingAsync(
      PolicyBinding policyBinding, FieldMask updateMask) {
    UpdatePolicyBindingRequest request =
        UpdatePolicyBindingRequest.newBuilder()
            .setPolicyBinding(policyBinding)
            .setUpdateMask(updateMask)
            .build();
    return updatePolicyBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a policy binding and returns a long-running operation. Callers will need the IAM
   * permissions on the policy and target in the binding to update, and the IAM permission to remove
   * the existing policy from the binding. Target is immutable and cannot be updated. Once the
   * binding is updated, the new policy is applied to the target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   UpdatePolicyBindingRequest request =
   *       UpdatePolicyBindingRequest.newBuilder()
   *           .setPolicyBinding(PolicyBinding.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   PolicyBinding response = policyBindingsClient.updatePolicyBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PolicyBinding, OperationMetadata> updatePolicyBindingAsync(
      UpdatePolicyBindingRequest request) {
    return updatePolicyBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a policy binding and returns a long-running operation. Callers will need the IAM
   * permissions on the policy and target in the binding to update, and the IAM permission to remove
   * the existing policy from the binding. Target is immutable and cannot be updated. Once the
   * binding is updated, the new policy is applied to the target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   UpdatePolicyBindingRequest request =
   *       UpdatePolicyBindingRequest.newBuilder()
   *           .setPolicyBinding(PolicyBinding.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<PolicyBinding, OperationMetadata> future =
   *       policyBindingsClient.updatePolicyBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   PolicyBinding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      updatePolicyBindingOperationCallable() {
    return stub.updatePolicyBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a policy binding and returns a long-running operation. Callers will need the IAM
   * permissions on the policy and target in the binding to update, and the IAM permission to remove
   * the existing policy from the binding. Target is immutable and cannot be updated. Once the
   * binding is updated, the new policy is applied to the target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   UpdatePolicyBindingRequest request =
   *       UpdatePolicyBindingRequest.newBuilder()
   *           .setPolicyBinding(PolicyBinding.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       policyBindingsClient.updatePolicyBindingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePolicyBindingRequest, Operation> updatePolicyBindingCallable() {
    return stub.updatePolicyBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy binding and returns a long-running operation. Callers will need the IAM
   * permissions on both the policy and target. Once the binding is deleted, the policy no longer
   * applies to the target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   PolicyBindingName name =
   *       PolicyBindingName.ofProjectLocationPolicyBindingName(
   *           "[PROJECT]", "[LOCATION]", "[POLICY_BINDING]");
   *   policyBindingsClient.deletePolicyBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the policy binding to delete.
   *     <p>Format:
   *     <ul>
   *       <li>`projects/{project_id}/locations/{location}/policyBindings/{policy_binding_id}`
   *       <li>`projects/{project_number}/locations/{location}/policyBindings/{policy_binding_id}`
   *       <li>`folders/{folder_id}/locations/{location}/policyBindings/{policy_binding_id}`
   *       <li>`organizations/{organization_id}/locations/{location}/policyBindings/{policy_binding_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePolicyBindingAsync(
      PolicyBindingName name) {
    DeletePolicyBindingRequest request =
        DeletePolicyBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deletePolicyBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy binding and returns a long-running operation. Callers will need the IAM
   * permissions on both the policy and target. Once the binding is deleted, the policy no longer
   * applies to the target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   String name =
   *       PolicyBindingName.ofOrganizationLocationPolicyBindingName(
   *               "[ORGANIZATION]", "[LOCATION]", "[POLICY_BINDING]")
   *           .toString();
   *   policyBindingsClient.deletePolicyBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the policy binding to delete.
   *     <p>Format:
   *     <ul>
   *       <li>`projects/{project_id}/locations/{location}/policyBindings/{policy_binding_id}`
   *       <li>`projects/{project_number}/locations/{location}/policyBindings/{policy_binding_id}`
   *       <li>`folders/{folder_id}/locations/{location}/policyBindings/{policy_binding_id}`
   *       <li>`organizations/{organization_id}/locations/{location}/policyBindings/{policy_binding_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePolicyBindingAsync(String name) {
    DeletePolicyBindingRequest request =
        DeletePolicyBindingRequest.newBuilder().setName(name).build();
    return deletePolicyBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy binding and returns a long-running operation. Callers will need the IAM
   * permissions on both the policy and target. Once the binding is deleted, the policy no longer
   * applies to the target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   DeletePolicyBindingRequest request =
   *       DeletePolicyBindingRequest.newBuilder()
   *           .setName(
   *               PolicyBindingName.ofProjectLocationPolicyBindingName(
   *                       "[PROJECT]", "[LOCATION]", "[POLICY_BINDING]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .build();
   *   policyBindingsClient.deletePolicyBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePolicyBindingAsync(
      DeletePolicyBindingRequest request) {
    return deletePolicyBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy binding and returns a long-running operation. Callers will need the IAM
   * permissions on both the policy and target. Once the binding is deleted, the policy no longer
   * applies to the target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   DeletePolicyBindingRequest request =
   *       DeletePolicyBindingRequest.newBuilder()
   *           .setName(
   *               PolicyBindingName.ofProjectLocationPolicyBindingName(
   *                       "[PROJECT]", "[LOCATION]", "[POLICY_BINDING]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       policyBindingsClient.deletePolicyBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePolicyBindingRequest, Empty, OperationMetadata>
      deletePolicyBindingOperationCallable() {
    return stub.deletePolicyBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy binding and returns a long-running operation. Callers will need the IAM
   * permissions on both the policy and target. Once the binding is deleted, the policy no longer
   * applies to the target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   DeletePolicyBindingRequest request =
   *       DeletePolicyBindingRequest.newBuilder()
   *           .setName(
   *               PolicyBindingName.ofProjectLocationPolicyBindingName(
   *                       "[PROJECT]", "[LOCATION]", "[POLICY_BINDING]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       policyBindingsClient.deletePolicyBindingCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePolicyBindingRequest, Operation> deletePolicyBindingCallable() {
    return stub.deletePolicyBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists policy bindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   for (PolicyBinding element : policyBindingsClient.listPolicyBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource, which owns the collection of policy bindings.
   *     <p>Format:
   *     <ul>
   *       <li>`projects/{project_id}/locations/{location}`
   *       <li>`projects/{project_number}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`organizations/{organization_id}/locations/{location}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPolicyBindingsPagedResponse listPolicyBindings(FolderLocationName parent) {
    ListPolicyBindingsRequest request =
        ListPolicyBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPolicyBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists policy bindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (PolicyBinding element : policyBindingsClient.listPolicyBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource, which owns the collection of policy bindings.
   *     <p>Format:
   *     <ul>
   *       <li>`projects/{project_id}/locations/{location}`
   *       <li>`projects/{project_number}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`organizations/{organization_id}/locations/{location}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPolicyBindingsPagedResponse listPolicyBindings(LocationName parent) {
    ListPolicyBindingsRequest request =
        ListPolicyBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPolicyBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists policy bindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (PolicyBinding element : policyBindingsClient.listPolicyBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource, which owns the collection of policy bindings.
   *     <p>Format:
   *     <ul>
   *       <li>`projects/{project_id}/locations/{location}`
   *       <li>`projects/{project_number}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`organizations/{organization_id}/locations/{location}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPolicyBindingsPagedResponse listPolicyBindings(OrganizationLocationName parent) {
    ListPolicyBindingsRequest request =
        ListPolicyBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPolicyBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists policy bindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (PolicyBinding element : policyBindingsClient.listPolicyBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource, which owns the collection of policy bindings.
   *     <p>Format:
   *     <ul>
   *       <li>`projects/{project_id}/locations/{location}`
   *       <li>`projects/{project_number}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`organizations/{organization_id}/locations/{location}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPolicyBindingsPagedResponse listPolicyBindings(String parent) {
    ListPolicyBindingsRequest request =
        ListPolicyBindingsRequest.newBuilder().setParent(parent).build();
    return listPolicyBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists policy bindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   ListPolicyBindingsRequest request =
   *       ListPolicyBindingsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (PolicyBinding element : policyBindingsClient.listPolicyBindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPolicyBindingsPagedResponse listPolicyBindings(
      ListPolicyBindingsRequest request) {
    return listPolicyBindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists policy bindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   ListPolicyBindingsRequest request =
   *       ListPolicyBindingsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<PolicyBinding> future =
   *       policyBindingsClient.listPolicyBindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PolicyBinding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPolicyBindingsRequest, ListPolicyBindingsPagedResponse>
      listPolicyBindingsPagedCallable() {
    return stub.listPolicyBindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists policy bindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   ListPolicyBindingsRequest request =
   *       ListPolicyBindingsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListPolicyBindingsResponse response =
   *         policyBindingsClient.listPolicyBindingsCallable().call(request);
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
  public final UnaryCallable<ListPolicyBindingsRequest, ListPolicyBindingsResponse>
      listPolicyBindingsCallable() {
    return stub.listPolicyBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search policy bindings by target. Returns all policy binding objects bound directly to target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   String target = "target-880905839";
   *   for (PolicyBinding element :
   *       policyBindingsClient.searchTargetPolicyBindings(parent, target).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this search will be performed. This should be
   *     the nearest Resource Manager resource (project, folder, or organization) to the target.
   *     <p>Format:
   *     <ul>
   *       <li>`projects/{project_id}/locations/{location}`
   *       <li>`projects/{project_number}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`organizations/{organization_id}/locations/{location}`
   *     </ul>
   *
   * @param target Required. The target resource, which is bound to the policy in the binding.
   *     <p>Format:
   *     <ul>
   *       <li>`//iam.googleapis.com/locations/global/workforcePools/POOL_ID`
   *       <li>`//iam.googleapis.com/projects/PROJECT_NUMBER/locations/global/workloadIdentityPools/POOL_ID`
   *       <li>`//iam.googleapis.com/locations/global/workspace/WORKSPACE_ID`
   *       <li>`//cloudresourcemanager.googleapis.com/projects/{project_number}`
   *       <li>`//cloudresourcemanager.googleapis.com/folders/{folder_id}`
   *       <li>`//cloudresourcemanager.googleapis.com/organizations/{organization_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchTargetPolicyBindingsPagedResponse searchTargetPolicyBindings(
      FolderLocationName parent, String target) {
    SearchTargetPolicyBindingsRequest request =
        SearchTargetPolicyBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTarget(target)
            .build();
    return searchTargetPolicyBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search policy bindings by target. Returns all policy binding objects bound directly to target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String target = "target-880905839";
   *   for (PolicyBinding element :
   *       policyBindingsClient.searchTargetPolicyBindings(parent, target).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this search will be performed. This should be
   *     the nearest Resource Manager resource (project, folder, or organization) to the target.
   *     <p>Format:
   *     <ul>
   *       <li>`projects/{project_id}/locations/{location}`
   *       <li>`projects/{project_number}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`organizations/{organization_id}/locations/{location}`
   *     </ul>
   *
   * @param target Required. The target resource, which is bound to the policy in the binding.
   *     <p>Format:
   *     <ul>
   *       <li>`//iam.googleapis.com/locations/global/workforcePools/POOL_ID`
   *       <li>`//iam.googleapis.com/projects/PROJECT_NUMBER/locations/global/workloadIdentityPools/POOL_ID`
   *       <li>`//iam.googleapis.com/locations/global/workspace/WORKSPACE_ID`
   *       <li>`//cloudresourcemanager.googleapis.com/projects/{project_number}`
   *       <li>`//cloudresourcemanager.googleapis.com/folders/{folder_id}`
   *       <li>`//cloudresourcemanager.googleapis.com/organizations/{organization_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchTargetPolicyBindingsPagedResponse searchTargetPolicyBindings(
      LocationName parent, String target) {
    SearchTargetPolicyBindingsRequest request =
        SearchTargetPolicyBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTarget(target)
            .build();
    return searchTargetPolicyBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search policy bindings by target. Returns all policy binding objects bound directly to target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   String target = "target-880905839";
   *   for (PolicyBinding element :
   *       policyBindingsClient.searchTargetPolicyBindings(parent, target).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this search will be performed. This should be
   *     the nearest Resource Manager resource (project, folder, or organization) to the target.
   *     <p>Format:
   *     <ul>
   *       <li>`projects/{project_id}/locations/{location}`
   *       <li>`projects/{project_number}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`organizations/{organization_id}/locations/{location}`
   *     </ul>
   *
   * @param target Required. The target resource, which is bound to the policy in the binding.
   *     <p>Format:
   *     <ul>
   *       <li>`//iam.googleapis.com/locations/global/workforcePools/POOL_ID`
   *       <li>`//iam.googleapis.com/projects/PROJECT_NUMBER/locations/global/workloadIdentityPools/POOL_ID`
   *       <li>`//iam.googleapis.com/locations/global/workspace/WORKSPACE_ID`
   *       <li>`//cloudresourcemanager.googleapis.com/projects/{project_number}`
   *       <li>`//cloudresourcemanager.googleapis.com/folders/{folder_id}`
   *       <li>`//cloudresourcemanager.googleapis.com/organizations/{organization_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchTargetPolicyBindingsPagedResponse searchTargetPolicyBindings(
      OrganizationLocationName parent, String target) {
    SearchTargetPolicyBindingsRequest request =
        SearchTargetPolicyBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTarget(target)
            .build();
    return searchTargetPolicyBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search policy bindings by target. Returns all policy binding objects bound directly to target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   String target = "target-880905839";
   *   for (PolicyBinding element :
   *       policyBindingsClient.searchTargetPolicyBindings(parent, target).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this search will be performed. This should be
   *     the nearest Resource Manager resource (project, folder, or organization) to the target.
   *     <p>Format:
   *     <ul>
   *       <li>`projects/{project_id}/locations/{location}`
   *       <li>`projects/{project_number}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`organizations/{organization_id}/locations/{location}`
   *     </ul>
   *
   * @param target Required. The target resource, which is bound to the policy in the binding.
   *     <p>Format:
   *     <ul>
   *       <li>`//iam.googleapis.com/locations/global/workforcePools/POOL_ID`
   *       <li>`//iam.googleapis.com/projects/PROJECT_NUMBER/locations/global/workloadIdentityPools/POOL_ID`
   *       <li>`//iam.googleapis.com/locations/global/workspace/WORKSPACE_ID`
   *       <li>`//cloudresourcemanager.googleapis.com/projects/{project_number}`
   *       <li>`//cloudresourcemanager.googleapis.com/folders/{folder_id}`
   *       <li>`//cloudresourcemanager.googleapis.com/organizations/{organization_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchTargetPolicyBindingsPagedResponse searchTargetPolicyBindings(
      String parent, String target) {
    SearchTargetPolicyBindingsRequest request =
        SearchTargetPolicyBindingsRequest.newBuilder().setParent(parent).setTarget(target).build();
    return searchTargetPolicyBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search policy bindings by target. Returns all policy binding objects bound directly to target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   SearchTargetPolicyBindingsRequest request =
   *       SearchTargetPolicyBindingsRequest.newBuilder()
   *           .setTarget("target-880905839")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .build();
   *   for (PolicyBinding element :
   *       policyBindingsClient.searchTargetPolicyBindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchTargetPolicyBindingsPagedResponse searchTargetPolicyBindings(
      SearchTargetPolicyBindingsRequest request) {
    return searchTargetPolicyBindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search policy bindings by target. Returns all policy binding objects bound directly to target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   SearchTargetPolicyBindingsRequest request =
   *       SearchTargetPolicyBindingsRequest.newBuilder()
   *           .setTarget("target-880905839")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<PolicyBinding> future =
   *       policyBindingsClient.searchTargetPolicyBindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PolicyBinding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsPagedResponse>
      searchTargetPolicyBindingsPagedCallable() {
    return stub.searchTargetPolicyBindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search policy bindings by target. Returns all policy binding objects bound directly to target.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
   *   SearchTargetPolicyBindingsRequest request =
   *       SearchTargetPolicyBindingsRequest.newBuilder()
   *           .setTarget("target-880905839")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .build();
   *   while (true) {
   *     SearchTargetPolicyBindingsResponse response =
   *         policyBindingsClient.searchTargetPolicyBindingsCallable().call(request);
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
  public final UnaryCallable<SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsResponse>
      searchTargetPolicyBindingsCallable() {
    return stub.searchTargetPolicyBindingsCallable();
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

  public static class ListPolicyBindingsPagedResponse
      extends AbstractPagedListResponse<
          ListPolicyBindingsRequest,
          ListPolicyBindingsResponse,
          PolicyBinding,
          ListPolicyBindingsPage,
          ListPolicyBindingsFixedSizeCollection> {

    public static ApiFuture<ListPolicyBindingsPagedResponse> createAsync(
        PageContext<ListPolicyBindingsRequest, ListPolicyBindingsResponse, PolicyBinding> context,
        ApiFuture<ListPolicyBindingsResponse> futureResponse) {
      ApiFuture<ListPolicyBindingsPage> futurePage =
          ListPolicyBindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPolicyBindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPolicyBindingsPagedResponse(ListPolicyBindingsPage page) {
      super(page, ListPolicyBindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPolicyBindingsPage
      extends AbstractPage<
          ListPolicyBindingsRequest,
          ListPolicyBindingsResponse,
          PolicyBinding,
          ListPolicyBindingsPage> {

    private ListPolicyBindingsPage(
        PageContext<ListPolicyBindingsRequest, ListPolicyBindingsResponse, PolicyBinding> context,
        ListPolicyBindingsResponse response) {
      super(context, response);
    }

    private static ListPolicyBindingsPage createEmptyPage() {
      return new ListPolicyBindingsPage(null, null);
    }

    @Override
    protected ListPolicyBindingsPage createPage(
        PageContext<ListPolicyBindingsRequest, ListPolicyBindingsResponse, PolicyBinding> context,
        ListPolicyBindingsResponse response) {
      return new ListPolicyBindingsPage(context, response);
    }

    @Override
    public ApiFuture<ListPolicyBindingsPage> createPageAsync(
        PageContext<ListPolicyBindingsRequest, ListPolicyBindingsResponse, PolicyBinding> context,
        ApiFuture<ListPolicyBindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPolicyBindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPolicyBindingsRequest,
          ListPolicyBindingsResponse,
          PolicyBinding,
          ListPolicyBindingsPage,
          ListPolicyBindingsFixedSizeCollection> {

    private ListPolicyBindingsFixedSizeCollection(
        List<ListPolicyBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPolicyBindingsFixedSizeCollection createEmptyCollection() {
      return new ListPolicyBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPolicyBindingsFixedSizeCollection createCollection(
        List<ListPolicyBindingsPage> pages, int collectionSize) {
      return new ListPolicyBindingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchTargetPolicyBindingsPagedResponse
      extends AbstractPagedListResponse<
          SearchTargetPolicyBindingsRequest,
          SearchTargetPolicyBindingsResponse,
          PolicyBinding,
          SearchTargetPolicyBindingsPage,
          SearchTargetPolicyBindingsFixedSizeCollection> {

    public static ApiFuture<SearchTargetPolicyBindingsPagedResponse> createAsync(
        PageContext<
                SearchTargetPolicyBindingsRequest,
                SearchTargetPolicyBindingsResponse,
                PolicyBinding>
            context,
        ApiFuture<SearchTargetPolicyBindingsResponse> futureResponse) {
      ApiFuture<SearchTargetPolicyBindingsPage> futurePage =
          SearchTargetPolicyBindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchTargetPolicyBindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchTargetPolicyBindingsPagedResponse(SearchTargetPolicyBindingsPage page) {
      super(page, SearchTargetPolicyBindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchTargetPolicyBindingsPage
      extends AbstractPage<
          SearchTargetPolicyBindingsRequest,
          SearchTargetPolicyBindingsResponse,
          PolicyBinding,
          SearchTargetPolicyBindingsPage> {

    private SearchTargetPolicyBindingsPage(
        PageContext<
                SearchTargetPolicyBindingsRequest,
                SearchTargetPolicyBindingsResponse,
                PolicyBinding>
            context,
        SearchTargetPolicyBindingsResponse response) {
      super(context, response);
    }

    private static SearchTargetPolicyBindingsPage createEmptyPage() {
      return new SearchTargetPolicyBindingsPage(null, null);
    }

    @Override
    protected SearchTargetPolicyBindingsPage createPage(
        PageContext<
                SearchTargetPolicyBindingsRequest,
                SearchTargetPolicyBindingsResponse,
                PolicyBinding>
            context,
        SearchTargetPolicyBindingsResponse response) {
      return new SearchTargetPolicyBindingsPage(context, response);
    }

    @Override
    public ApiFuture<SearchTargetPolicyBindingsPage> createPageAsync(
        PageContext<
                SearchTargetPolicyBindingsRequest,
                SearchTargetPolicyBindingsResponse,
                PolicyBinding>
            context,
        ApiFuture<SearchTargetPolicyBindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchTargetPolicyBindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchTargetPolicyBindingsRequest,
          SearchTargetPolicyBindingsResponse,
          PolicyBinding,
          SearchTargetPolicyBindingsPage,
          SearchTargetPolicyBindingsFixedSizeCollection> {

    private SearchTargetPolicyBindingsFixedSizeCollection(
        List<SearchTargetPolicyBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchTargetPolicyBindingsFixedSizeCollection createEmptyCollection() {
      return new SearchTargetPolicyBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchTargetPolicyBindingsFixedSizeCollection createCollection(
        List<SearchTargetPolicyBindingsPage> pages, int collectionSize) {
      return new SearchTargetPolicyBindingsFixedSizeCollection(pages, collectionSize);
    }
  }
}
