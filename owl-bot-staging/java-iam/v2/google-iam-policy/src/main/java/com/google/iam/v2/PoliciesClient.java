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

package com.google.iam.v2;

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
import com.google.iam.v2.stub.PoliciesStub;
import com.google.iam.v2.stub.PoliciesStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: An interface for managing Identity and Access Management (IAM) policies.
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
 * try (PoliciesClient policiesClient = PoliciesClient.create()) {
 *   String name = "name3373707";
 *   Policy response = policiesClient.getPolicy(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PoliciesClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of PoliciesSettings to create().
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
 * PoliciesSettings policiesSettings =
 *     PoliciesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PoliciesClient policiesClient = PoliciesClient.create(policiesSettings);
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
 * PoliciesSettings policiesSettings =
 *     PoliciesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PoliciesClient policiesClient = PoliciesClient.create(policiesSettings);
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
 * PoliciesSettings policiesSettings = PoliciesSettings.newHttpJsonBuilder().build();
 * PoliciesClient policiesClient = PoliciesClient.create(policiesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PoliciesClient implements BackgroundResource {
  private final PoliciesSettings settings;
  private final PoliciesStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of PoliciesClient with default settings. */
  public static final PoliciesClient create() throws IOException {
    return create(PoliciesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PoliciesClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PoliciesClient create(PoliciesSettings settings) throws IOException {
    return new PoliciesClient(settings);
  }

  /**
   * Constructs an instance of PoliciesClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(PoliciesSettings).
   */
  public static final PoliciesClient create(PoliciesStub stub) {
    return new PoliciesClient(stub);
  }

  /**
   * Constructs an instance of PoliciesClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected PoliciesClient(PoliciesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PoliciesStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected PoliciesClient(PoliciesStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final PoliciesSettings getSettings() {
    return settings;
  }

  public PoliciesStub getStub() {
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
   * Retrieves the policies of the specified kind that are attached to a resource.
   *
   * <p>The response lists only policy metadata. In particular, policy rules are omitted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   String parent = "parent-995424086";
   *   for (Policy element : policiesClient.listPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource that the policy is attached to, along with the kind of
   *     policy to list. Format: `policies/{attachment_point}/denypolicies`
   *     <p>The attachment point is identified by its URL-encoded full resource name, which means
   *     that the forward-slash character, `/`, must be written as `%2F`. For example,
   *     `policies/cloudresourcemanager.googleapis.com%2Fprojects%2Fmy-project/denypolicies`.
   *     <p>For organizations and folders, use the numeric ID in the full resource name. For
   *     projects, you can use the alphanumeric or the numeric ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPoliciesPagedResponse listPolicies(String parent) {
    ListPoliciesRequest request = ListPoliciesRequest.newBuilder().setParent(parent).build();
    return listPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the policies of the specified kind that are attached to a resource.
   *
   * <p>The response lists only policy metadata. In particular, policy rules are omitted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   ListPoliciesRequest request =
   *       ListPoliciesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Policy element : policiesClient.listPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPoliciesPagedResponse listPolicies(ListPoliciesRequest request) {
    return listPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the policies of the specified kind that are attached to a resource.
   *
   * <p>The response lists only policy metadata. In particular, policy rules are omitted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   ListPoliciesRequest request =
   *       ListPoliciesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Policy> future = policiesClient.listPoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Policy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPoliciesRequest, ListPoliciesPagedResponse>
      listPoliciesPagedCallable() {
    return stub.listPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the policies of the specified kind that are attached to a resource.
   *
   * <p>The response lists only policy metadata. In particular, policy rules are omitted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   ListPoliciesRequest request =
   *       ListPoliciesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPoliciesResponse response = policiesClient.listPoliciesCallable().call(request);
   *     for (Policy element : response.getPoliciesList()) {
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
  public final UnaryCallable<ListPoliciesRequest, ListPoliciesResponse> listPoliciesCallable() {
    return stub.listPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   String name = "name3373707";
   *   Policy response = policiesClient.getPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the policy to retrieve. Format:
   *     `policies/{attachment_point}/denypolicies/{policy_id}`
   *     <p>Use the URL-encoded full resource name, which means that the forward-slash character,
   *     `/`, must be written as `%2F`. For example,
   *     `policies/cloudresourcemanager.googleapis.com%2Fprojects%2Fmy-project/denypolicies/my-policy`.
   *     <p>For organizations and folders, use the numeric ID in the full resource name. For
   *     projects, you can use the alphanumeric or the numeric ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getPolicy(String name) {
    GetPolicyRequest request = GetPolicyRequest.newBuilder().setName(name).build();
    return getPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   GetPolicyRequest request = GetPolicyRequest.newBuilder().setName("name3373707").build();
   *   Policy response = policiesClient.getPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getPolicy(GetPolicyRequest request) {
    return getPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   GetPolicyRequest request = GetPolicyRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Policy> future = policiesClient.getPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPolicyRequest, Policy> getPolicyCallable() {
    return stub.getPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   String parent = "parent-995424086";
   *   Policy policy = Policy.newBuilder().build();
   *   String policyId = "policyId546908653";
   *   Policy response = policiesClient.createPolicyAsync(parent, policy, policyId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource that the policy is attached to, along with the kind of
   *     policy to create. Format: `policies/{attachment_point}/denypolicies`
   *     <p>The attachment point is identified by its URL-encoded full resource name, which means
   *     that the forward-slash character, `/`, must be written as `%2F`. For example,
   *     `policies/cloudresourcemanager.googleapis.com%2Fprojects%2Fmy-project/denypolicies`.
   *     <p>For organizations and folders, use the numeric ID in the full resource name. For
   *     projects, you can use the alphanumeric or the numeric ID.
   * @param policy Required. The policy to create.
   * @param policyId The ID to use for this policy, which will become the final component of the
   *     policy's resource name. The ID must contain 3 to 63 characters. It can contain lowercase
   *     letters and numbers, as well as dashes (`-`) and periods (`.`). The first character must be
   *     a lowercase letter.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Policy, PolicyOperationMetadata> createPolicyAsync(
      String parent, Policy policy, String policyId) {
    CreatePolicyRequest request =
        CreatePolicyRequest.newBuilder()
            .setParent(parent)
            .setPolicy(policy)
            .setPolicyId(policyId)
            .build();
    return createPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   CreatePolicyRequest request =
   *       CreatePolicyRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPolicy(Policy.newBuilder().build())
   *           .setPolicyId("policyId546908653")
   *           .build();
   *   Policy response = policiesClient.createPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Policy, PolicyOperationMetadata> createPolicyAsync(
      CreatePolicyRequest request) {
    return createPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   CreatePolicyRequest request =
   *       CreatePolicyRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPolicy(Policy.newBuilder().build())
   *           .setPolicyId("policyId546908653")
   *           .build();
   *   OperationFuture<Policy, PolicyOperationMetadata> future =
   *       policiesClient.createPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreatePolicyRequest, Policy, PolicyOperationMetadata>
      createPolicyOperationCallable() {
    return stub.createPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   CreatePolicyRequest request =
   *       CreatePolicyRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPolicy(Policy.newBuilder().build())
   *           .setPolicyId("policyId546908653")
   *           .build();
   *   ApiFuture<Operation> future = policiesClient.createPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePolicyRequest, Operation> createPolicyCallable() {
    return stub.createPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified policy.
   *
   * <p>You can update only the rules and the display name for the policy.
   *
   * <p>To update a policy, you should use a read-modify-write loop:
   *
   * <p>1. Use [GetPolicy][google.iam.v2.Policies.GetPolicy] to read the current version of the
   * policy. 2. Modify the policy as needed. 3. Use `UpdatePolicy` to write the updated policy.
   *
   * <p>This pattern helps prevent conflicts between concurrent updates.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   UpdatePolicyRequest request =
   *       UpdatePolicyRequest.newBuilder().setPolicy(Policy.newBuilder().build()).build();
   *   Policy response = policiesClient.updatePolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Policy, PolicyOperationMetadata> updatePolicyAsync(
      UpdatePolicyRequest request) {
    return updatePolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified policy.
   *
   * <p>You can update only the rules and the display name for the policy.
   *
   * <p>To update a policy, you should use a read-modify-write loop:
   *
   * <p>1. Use [GetPolicy][google.iam.v2.Policies.GetPolicy] to read the current version of the
   * policy. 2. Modify the policy as needed. 3. Use `UpdatePolicy` to write the updated policy.
   *
   * <p>This pattern helps prevent conflicts between concurrent updates.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   UpdatePolicyRequest request =
   *       UpdatePolicyRequest.newBuilder().setPolicy(Policy.newBuilder().build()).build();
   *   OperationFuture<Policy, PolicyOperationMetadata> future =
   *       policiesClient.updatePolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdatePolicyRequest, Policy, PolicyOperationMetadata>
      updatePolicyOperationCallable() {
    return stub.updatePolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified policy.
   *
   * <p>You can update only the rules and the display name for the policy.
   *
   * <p>To update a policy, you should use a read-modify-write loop:
   *
   * <p>1. Use [GetPolicy][google.iam.v2.Policies.GetPolicy] to read the current version of the
   * policy. 2. Modify the policy as needed. 3. Use `UpdatePolicy` to write the updated policy.
   *
   * <p>This pattern helps prevent conflicts between concurrent updates.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   UpdatePolicyRequest request =
   *       UpdatePolicyRequest.newBuilder().setPolicy(Policy.newBuilder().build()).build();
   *   ApiFuture<Operation> future = policiesClient.updatePolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePolicyRequest, Operation> updatePolicyCallable() {
    return stub.updatePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy. This action is permanent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   String name = "name3373707";
   *   Policy response = policiesClient.deletePolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the policy to delete. Format:
   *     `policies/{attachment_point}/denypolicies/{policy_id}`
   *     <p>Use the URL-encoded full resource name, which means that the forward-slash character,
   *     `/`, must be written as `%2F`. For example,
   *     `policies/cloudresourcemanager.googleapis.com%2Fprojects%2Fmy-project/denypolicies/my-policy`.
   *     <p>For organizations and folders, use the numeric ID in the full resource name. For
   *     projects, you can use the alphanumeric or the numeric ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Policy, PolicyOperationMetadata> deletePolicyAsync(String name) {
    DeletePolicyRequest request = DeletePolicyRequest.newBuilder().setName(name).build();
    return deletePolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy. This action is permanent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   DeletePolicyRequest request =
   *       DeletePolicyRequest.newBuilder().setName("name3373707").setEtag("etag3123477").build();
   *   Policy response = policiesClient.deletePolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Policy, PolicyOperationMetadata> deletePolicyAsync(
      DeletePolicyRequest request) {
    return deletePolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy. This action is permanent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   DeletePolicyRequest request =
   *       DeletePolicyRequest.newBuilder().setName("name3373707").setEtag("etag3123477").build();
   *   OperationFuture<Policy, PolicyOperationMetadata> future =
   *       policiesClient.deletePolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePolicyRequest, Policy, PolicyOperationMetadata>
      deletePolicyOperationCallable() {
    return stub.deletePolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy. This action is permanent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PoliciesClient policiesClient = PoliciesClient.create()) {
   *   DeletePolicyRequest request =
   *       DeletePolicyRequest.newBuilder().setName("name3373707").setEtag("etag3123477").build();
   *   ApiFuture<Operation> future = policiesClient.deletePolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePolicyRequest, Operation> deletePolicyCallable() {
    return stub.deletePolicyCallable();
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

  public static class ListPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListPoliciesRequest,
          ListPoliciesResponse,
          Policy,
          ListPoliciesPage,
          ListPoliciesFixedSizeCollection> {

    public static ApiFuture<ListPoliciesPagedResponse> createAsync(
        PageContext<ListPoliciesRequest, ListPoliciesResponse, Policy> context,
        ApiFuture<ListPoliciesResponse> futureResponse) {
      ApiFuture<ListPoliciesPage> futurePage =
          ListPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPoliciesPagedResponse(ListPoliciesPage page) {
      super(page, ListPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPoliciesPage
      extends AbstractPage<ListPoliciesRequest, ListPoliciesResponse, Policy, ListPoliciesPage> {

    private ListPoliciesPage(
        PageContext<ListPoliciesRequest, ListPoliciesResponse, Policy> context,
        ListPoliciesResponse response) {
      super(context, response);
    }

    private static ListPoliciesPage createEmptyPage() {
      return new ListPoliciesPage(null, null);
    }

    @Override
    protected ListPoliciesPage createPage(
        PageContext<ListPoliciesRequest, ListPoliciesResponse, Policy> context,
        ListPoliciesResponse response) {
      return new ListPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListPoliciesPage> createPageAsync(
        PageContext<ListPoliciesRequest, ListPoliciesResponse, Policy> context,
        ApiFuture<ListPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPoliciesRequest,
          ListPoliciesResponse,
          Policy,
          ListPoliciesPage,
          ListPoliciesFixedSizeCollection> {

    private ListPoliciesFixedSizeCollection(List<ListPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPoliciesFixedSizeCollection createCollection(
        List<ListPoliciesPage> pages, int collectionSize) {
      return new ListPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }
}
