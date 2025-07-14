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

package com.google.iam.v3;

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
import com.google.iam.v3.stub.PrincipalAccessBoundaryPoliciesStub;
import com.google.iam.v3.stub.PrincipalAccessBoundaryPoliciesStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages Identity and Access Management (IAM) principal access boundary
 * policies.
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
 * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
 *     PrincipalAccessBoundaryPoliciesClient.create()) {
 *   PrincipalAccessBoundaryPolicyName name =
 *       PrincipalAccessBoundaryPolicyName.of(
 *           "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]");
 *   PrincipalAccessBoundaryPolicy response =
 *       principalAccessBoundaryPoliciesClient.getPrincipalAccessBoundaryPolicy(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PrincipalAccessBoundaryPoliciesClient object to clean
 * up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePrincipalAccessBoundaryPolicy</td>
 *      <td><p> Creates a principal access boundary policy, and returns a long running operation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPrincipalAccessBoundaryPolicyAsync(CreatePrincipalAccessBoundaryPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createPrincipalAccessBoundaryPolicyAsync(OrganizationLocationName parent, PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy, String principalAccessBoundaryPolicyId)
 *           <li><p> createPrincipalAccessBoundaryPolicyAsync(String parent, PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy, String principalAccessBoundaryPolicyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPrincipalAccessBoundaryPolicyOperationCallable()
 *           <li><p> createPrincipalAccessBoundaryPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPrincipalAccessBoundaryPolicy</td>
 *      <td><p> Gets a principal access boundary policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPrincipalAccessBoundaryPolicy(GetPrincipalAccessBoundaryPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPrincipalAccessBoundaryPolicy(PrincipalAccessBoundaryPolicyName name)
 *           <li><p> getPrincipalAccessBoundaryPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPrincipalAccessBoundaryPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePrincipalAccessBoundaryPolicy</td>
 *      <td><p> Updates a principal access boundary policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePrincipalAccessBoundaryPolicyAsync(UpdatePrincipalAccessBoundaryPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updatePrincipalAccessBoundaryPolicyAsync(PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePrincipalAccessBoundaryPolicyOperationCallable()
 *           <li><p> updatePrincipalAccessBoundaryPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePrincipalAccessBoundaryPolicy</td>
 *      <td><p> Deletes a principal access boundary policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePrincipalAccessBoundaryPolicyAsync(DeletePrincipalAccessBoundaryPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deletePrincipalAccessBoundaryPolicyAsync(PrincipalAccessBoundaryPolicyName name)
 *           <li><p> deletePrincipalAccessBoundaryPolicyAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePrincipalAccessBoundaryPolicyOperationCallable()
 *           <li><p> deletePrincipalAccessBoundaryPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPrincipalAccessBoundaryPolicies</td>
 *      <td><p> Lists principal access boundary policies.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPrincipalAccessBoundaryPolicies(ListPrincipalAccessBoundaryPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPrincipalAccessBoundaryPolicies(OrganizationLocationName parent)
 *           <li><p> listPrincipalAccessBoundaryPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPrincipalAccessBoundaryPoliciesPagedCallable()
 *           <li><p> listPrincipalAccessBoundaryPoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchPrincipalAccessBoundaryPolicyBindings</td>
 *      <td><p> Returns all policy bindings that bind a specific policy if a user has searchPolicyBindings permission on that policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchPrincipalAccessBoundaryPolicyBindings(SearchPrincipalAccessBoundaryPolicyBindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchPrincipalAccessBoundaryPolicyBindings(PrincipalAccessBoundaryPolicyName name)
 *           <li><p> searchPrincipalAccessBoundaryPolicyBindings(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchPrincipalAccessBoundaryPolicyBindingsPagedCallable()
 *           <li><p> searchPrincipalAccessBoundaryPolicyBindingsCallable()
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
 * PrincipalAccessBoundaryPoliciesSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PrincipalAccessBoundaryPoliciesSettings principalAccessBoundaryPoliciesSettings =
 *     PrincipalAccessBoundaryPoliciesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
 *     PrincipalAccessBoundaryPoliciesClient.create(principalAccessBoundaryPoliciesSettings);
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
 * PrincipalAccessBoundaryPoliciesSettings principalAccessBoundaryPoliciesSettings =
 *     PrincipalAccessBoundaryPoliciesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
 *     PrincipalAccessBoundaryPoliciesClient.create(principalAccessBoundaryPoliciesSettings);
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
 * PrincipalAccessBoundaryPoliciesSettings principalAccessBoundaryPoliciesSettings =
 *     PrincipalAccessBoundaryPoliciesSettings.newHttpJsonBuilder().build();
 * PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
 *     PrincipalAccessBoundaryPoliciesClient.create(principalAccessBoundaryPoliciesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PrincipalAccessBoundaryPoliciesClient implements BackgroundResource {
  private final PrincipalAccessBoundaryPoliciesSettings settings;
  private final PrincipalAccessBoundaryPoliciesStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of PrincipalAccessBoundaryPoliciesClient with default settings. */
  public static final PrincipalAccessBoundaryPoliciesClient create() throws IOException {
    return create(PrincipalAccessBoundaryPoliciesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PrincipalAccessBoundaryPoliciesClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final PrincipalAccessBoundaryPoliciesClient create(
      PrincipalAccessBoundaryPoliciesSettings settings) throws IOException {
    return new PrincipalAccessBoundaryPoliciesClient(settings);
  }

  /**
   * Constructs an instance of PrincipalAccessBoundaryPoliciesClient, using the given stub for
   * making calls. This is for advanced usage - prefer using
   * create(PrincipalAccessBoundaryPoliciesSettings).
   */
  public static final PrincipalAccessBoundaryPoliciesClient create(
      PrincipalAccessBoundaryPoliciesStub stub) {
    return new PrincipalAccessBoundaryPoliciesClient(stub);
  }

  /**
   * Constructs an instance of PrincipalAccessBoundaryPoliciesClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected PrincipalAccessBoundaryPoliciesClient(PrincipalAccessBoundaryPoliciesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((PrincipalAccessBoundaryPoliciesStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected PrincipalAccessBoundaryPoliciesClient(PrincipalAccessBoundaryPoliciesStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final PrincipalAccessBoundaryPoliciesSettings getSettings() {
    return settings;
  }

  public PrincipalAccessBoundaryPoliciesStub getStub() {
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
   * Creates a principal access boundary policy, and returns a long running operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy =
   *       PrincipalAccessBoundaryPolicy.newBuilder().build();
   *   String principalAccessBoundaryPolicyId = "principalAccessBoundaryPolicyId-198573175";
   *   PrincipalAccessBoundaryPolicy response =
   *       principalAccessBoundaryPoliciesClient
   *           .createPrincipalAccessBoundaryPolicyAsync(
   *               parent, principalAccessBoundaryPolicy, principalAccessBoundaryPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this principal access boundary policy will be
   *     created. Only organizations are supported.
   *     <p>Format: `organizations/{organization_id}/locations/{location}`
   * @param principalAccessBoundaryPolicy Required. The principal access boundary policy to create.
   * @param principalAccessBoundaryPolicyId Required. The ID to use for the principal access
   *     boundary policy, which will become the final component of the principal access boundary
   *     policy's resource name.
   *     <p>This value must start with a lowercase letter followed by up to 62 lowercase letters,
   *     numbers, hyphens, or dots. Pattern, /[a-z][a-z0-9-\\.]{2,62}/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrincipalAccessBoundaryPolicy, OperationMetadata>
      createPrincipalAccessBoundaryPolicyAsync(
          OrganizationLocationName parent,
          PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy,
          String principalAccessBoundaryPolicyId) {
    CreatePrincipalAccessBoundaryPolicyRequest request =
        CreatePrincipalAccessBoundaryPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPrincipalAccessBoundaryPolicy(principalAccessBoundaryPolicy)
            .setPrincipalAccessBoundaryPolicyId(principalAccessBoundaryPolicyId)
            .build();
    return createPrincipalAccessBoundaryPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a principal access boundary policy, and returns a long running operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy =
   *       PrincipalAccessBoundaryPolicy.newBuilder().build();
   *   String principalAccessBoundaryPolicyId = "principalAccessBoundaryPolicyId-198573175";
   *   PrincipalAccessBoundaryPolicy response =
   *       principalAccessBoundaryPoliciesClient
   *           .createPrincipalAccessBoundaryPolicyAsync(
   *               parent, principalAccessBoundaryPolicy, principalAccessBoundaryPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this principal access boundary policy will be
   *     created. Only organizations are supported.
   *     <p>Format: `organizations/{organization_id}/locations/{location}`
   * @param principalAccessBoundaryPolicy Required. The principal access boundary policy to create.
   * @param principalAccessBoundaryPolicyId Required. The ID to use for the principal access
   *     boundary policy, which will become the final component of the principal access boundary
   *     policy's resource name.
   *     <p>This value must start with a lowercase letter followed by up to 62 lowercase letters,
   *     numbers, hyphens, or dots. Pattern, /[a-z][a-z0-9-\\.]{2,62}/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrincipalAccessBoundaryPolicy, OperationMetadata>
      createPrincipalAccessBoundaryPolicyAsync(
          String parent,
          PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy,
          String principalAccessBoundaryPolicyId) {
    CreatePrincipalAccessBoundaryPolicyRequest request =
        CreatePrincipalAccessBoundaryPolicyRequest.newBuilder()
            .setParent(parent)
            .setPrincipalAccessBoundaryPolicy(principalAccessBoundaryPolicy)
            .setPrincipalAccessBoundaryPolicyId(principalAccessBoundaryPolicyId)
            .build();
    return createPrincipalAccessBoundaryPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a principal access boundary policy, and returns a long running operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   CreatePrincipalAccessBoundaryPolicyRequest request =
   *       CreatePrincipalAccessBoundaryPolicyRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPrincipalAccessBoundaryPolicyId("principalAccessBoundaryPolicyId-198573175")
   *           .setPrincipalAccessBoundaryPolicy(PrincipalAccessBoundaryPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   PrincipalAccessBoundaryPolicy response =
   *       principalAccessBoundaryPoliciesClient
   *           .createPrincipalAccessBoundaryPolicyAsync(request)
   *           .get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrincipalAccessBoundaryPolicy, OperationMetadata>
      createPrincipalAccessBoundaryPolicyAsync(CreatePrincipalAccessBoundaryPolicyRequest request) {
    return createPrincipalAccessBoundaryPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a principal access boundary policy, and returns a long running operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   CreatePrincipalAccessBoundaryPolicyRequest request =
   *       CreatePrincipalAccessBoundaryPolicyRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPrincipalAccessBoundaryPolicyId("principalAccessBoundaryPolicyId-198573175")
   *           .setPrincipalAccessBoundaryPolicy(PrincipalAccessBoundaryPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<PrincipalAccessBoundaryPolicy, OperationMetadata> future =
   *       principalAccessBoundaryPoliciesClient
   *           .createPrincipalAccessBoundaryPolicyOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   PrincipalAccessBoundaryPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      createPrincipalAccessBoundaryPolicyOperationCallable() {
    return stub.createPrincipalAccessBoundaryPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a principal access boundary policy, and returns a long running operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   CreatePrincipalAccessBoundaryPolicyRequest request =
   *       CreatePrincipalAccessBoundaryPolicyRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPrincipalAccessBoundaryPolicyId("principalAccessBoundaryPolicyId-198573175")
   *           .setPrincipalAccessBoundaryPolicy(PrincipalAccessBoundaryPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       principalAccessBoundaryPoliciesClient
   *           .createPrincipalAccessBoundaryPolicyCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePrincipalAccessBoundaryPolicyRequest, Operation>
      createPrincipalAccessBoundaryPolicyCallable() {
    return stub.createPrincipalAccessBoundaryPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a principal access boundary policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   PrincipalAccessBoundaryPolicyName name =
   *       PrincipalAccessBoundaryPolicyName.of(
   *           "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]");
   *   PrincipalAccessBoundaryPolicy response =
   *       principalAccessBoundaryPoliciesClient.getPrincipalAccessBoundaryPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the principal access boundary policy to retrieve.
   *     <p>Format:
   *     `organizations/{organization_id}/locations/{location}/principalAccessBoundaryPolicies/{principal_access_boundary_policy_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrincipalAccessBoundaryPolicy getPrincipalAccessBoundaryPolicy(
      PrincipalAccessBoundaryPolicyName name) {
    GetPrincipalAccessBoundaryPolicyRequest request =
        GetPrincipalAccessBoundaryPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPrincipalAccessBoundaryPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a principal access boundary policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   String name =
   *       PrincipalAccessBoundaryPolicyName.of(
   *               "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
   *           .toString();
   *   PrincipalAccessBoundaryPolicy response =
   *       principalAccessBoundaryPoliciesClient.getPrincipalAccessBoundaryPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the principal access boundary policy to retrieve.
   *     <p>Format:
   *     `organizations/{organization_id}/locations/{location}/principalAccessBoundaryPolicies/{principal_access_boundary_policy_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrincipalAccessBoundaryPolicy getPrincipalAccessBoundaryPolicy(String name) {
    GetPrincipalAccessBoundaryPolicyRequest request =
        GetPrincipalAccessBoundaryPolicyRequest.newBuilder().setName(name).build();
    return getPrincipalAccessBoundaryPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a principal access boundary policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   GetPrincipalAccessBoundaryPolicyRequest request =
   *       GetPrincipalAccessBoundaryPolicyRequest.newBuilder()
   *           .setName(
   *               PrincipalAccessBoundaryPolicyName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
   *                   .toString())
   *           .build();
   *   PrincipalAccessBoundaryPolicy response =
   *       principalAccessBoundaryPoliciesClient.getPrincipalAccessBoundaryPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrincipalAccessBoundaryPolicy getPrincipalAccessBoundaryPolicy(
      GetPrincipalAccessBoundaryPolicyRequest request) {
    return getPrincipalAccessBoundaryPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a principal access boundary policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   GetPrincipalAccessBoundaryPolicyRequest request =
   *       GetPrincipalAccessBoundaryPolicyRequest.newBuilder()
   *           .setName(
   *               PrincipalAccessBoundaryPolicyName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PrincipalAccessBoundaryPolicy> future =
   *       principalAccessBoundaryPoliciesClient
   *           .getPrincipalAccessBoundaryPolicyCallable()
   *           .futureCall(request);
   *   // Do something.
   *   PrincipalAccessBoundaryPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
      getPrincipalAccessBoundaryPolicyCallable() {
    return stub.getPrincipalAccessBoundaryPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a principal access boundary policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy =
   *       PrincipalAccessBoundaryPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PrincipalAccessBoundaryPolicy response =
   *       principalAccessBoundaryPoliciesClient
   *           .updatePrincipalAccessBoundaryPolicyAsync(principalAccessBoundaryPolicy, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param principalAccessBoundaryPolicy Required. The principal access boundary policy to update.
   *     <p>The principal access boundary policy's `name` field is used to identify the policy to
   *     update.
   * @param updateMask Optional. The list of fields to update
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrincipalAccessBoundaryPolicy, OperationMetadata>
      updatePrincipalAccessBoundaryPolicyAsync(
          PrincipalAccessBoundaryPolicy principalAccessBoundaryPolicy, FieldMask updateMask) {
    UpdatePrincipalAccessBoundaryPolicyRequest request =
        UpdatePrincipalAccessBoundaryPolicyRequest.newBuilder()
            .setPrincipalAccessBoundaryPolicy(principalAccessBoundaryPolicy)
            .setUpdateMask(updateMask)
            .build();
    return updatePrincipalAccessBoundaryPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a principal access boundary policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   UpdatePrincipalAccessBoundaryPolicyRequest request =
   *       UpdatePrincipalAccessBoundaryPolicyRequest.newBuilder()
   *           .setPrincipalAccessBoundaryPolicy(PrincipalAccessBoundaryPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   PrincipalAccessBoundaryPolicy response =
   *       principalAccessBoundaryPoliciesClient
   *           .updatePrincipalAccessBoundaryPolicyAsync(request)
   *           .get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrincipalAccessBoundaryPolicy, OperationMetadata>
      updatePrincipalAccessBoundaryPolicyAsync(UpdatePrincipalAccessBoundaryPolicyRequest request) {
    return updatePrincipalAccessBoundaryPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a principal access boundary policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   UpdatePrincipalAccessBoundaryPolicyRequest request =
   *       UpdatePrincipalAccessBoundaryPolicyRequest.newBuilder()
   *           .setPrincipalAccessBoundaryPolicy(PrincipalAccessBoundaryPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<PrincipalAccessBoundaryPolicy, OperationMetadata> future =
   *       principalAccessBoundaryPoliciesClient
   *           .updatePrincipalAccessBoundaryPolicyOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   PrincipalAccessBoundaryPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      updatePrincipalAccessBoundaryPolicyOperationCallable() {
    return stub.updatePrincipalAccessBoundaryPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a principal access boundary policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   UpdatePrincipalAccessBoundaryPolicyRequest request =
   *       UpdatePrincipalAccessBoundaryPolicyRequest.newBuilder()
   *           .setPrincipalAccessBoundaryPolicy(PrincipalAccessBoundaryPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       principalAccessBoundaryPoliciesClient
   *           .updatePrincipalAccessBoundaryPolicyCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>
      updatePrincipalAccessBoundaryPolicyCallable() {
    return stub.updatePrincipalAccessBoundaryPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a principal access boundary policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   PrincipalAccessBoundaryPolicyName name =
   *       PrincipalAccessBoundaryPolicyName.of(
   *           "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]");
   *   principalAccessBoundaryPoliciesClient.deletePrincipalAccessBoundaryPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the principal access boundary policy to delete.
   *     <p>Format:
   *     `organizations/{organization_id}/locations/{location}/principalAccessBoundaryPolicies/{principal_access_boundary_policy_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePrincipalAccessBoundaryPolicyAsync(
      PrincipalAccessBoundaryPolicyName name) {
    DeletePrincipalAccessBoundaryPolicyRequest request =
        DeletePrincipalAccessBoundaryPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deletePrincipalAccessBoundaryPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a principal access boundary policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   String name =
   *       PrincipalAccessBoundaryPolicyName.of(
   *               "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
   *           .toString();
   *   principalAccessBoundaryPoliciesClient.deletePrincipalAccessBoundaryPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the principal access boundary policy to delete.
   *     <p>Format:
   *     `organizations/{organization_id}/locations/{location}/principalAccessBoundaryPolicies/{principal_access_boundary_policy_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePrincipalAccessBoundaryPolicyAsync(
      String name) {
    DeletePrincipalAccessBoundaryPolicyRequest request =
        DeletePrincipalAccessBoundaryPolicyRequest.newBuilder().setName(name).build();
    return deletePrincipalAccessBoundaryPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a principal access boundary policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   DeletePrincipalAccessBoundaryPolicyRequest request =
   *       DeletePrincipalAccessBoundaryPolicyRequest.newBuilder()
   *           .setName(
   *               PrincipalAccessBoundaryPolicyName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   principalAccessBoundaryPoliciesClient.deletePrincipalAccessBoundaryPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePrincipalAccessBoundaryPolicyAsync(
      DeletePrincipalAccessBoundaryPolicyRequest request) {
    return deletePrincipalAccessBoundaryPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a principal access boundary policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   DeletePrincipalAccessBoundaryPolicyRequest request =
   *       DeletePrincipalAccessBoundaryPolicyRequest.newBuilder()
   *           .setName(
   *               PrincipalAccessBoundaryPolicyName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       principalAccessBoundaryPoliciesClient
   *           .deletePrincipalAccessBoundaryPolicyOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeletePrincipalAccessBoundaryPolicyRequest, Empty, OperationMetadata>
      deletePrincipalAccessBoundaryPolicyOperationCallable() {
    return stub.deletePrincipalAccessBoundaryPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a principal access boundary policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   DeletePrincipalAccessBoundaryPolicyRequest request =
   *       DeletePrincipalAccessBoundaryPolicyRequest.newBuilder()
   *           .setName(
   *               PrincipalAccessBoundaryPolicyName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       principalAccessBoundaryPoliciesClient
   *           .deletePrincipalAccessBoundaryPolicyCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePrincipalAccessBoundaryPolicyRequest, Operation>
      deletePrincipalAccessBoundaryPolicyCallable() {
    return stub.deletePrincipalAccessBoundaryPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists principal access boundary policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (PrincipalAccessBoundaryPolicy element :
   *       principalAccessBoundaryPoliciesClient
   *           .listPrincipalAccessBoundaryPolicies(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource, which owns the collection of principal access
   *     boundary policies.
   *     <p>Format: `organizations/{organization_id}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrincipalAccessBoundaryPoliciesPagedResponse listPrincipalAccessBoundaryPolicies(
      OrganizationLocationName parent) {
    ListPrincipalAccessBoundaryPoliciesRequest request =
        ListPrincipalAccessBoundaryPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPrincipalAccessBoundaryPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists principal access boundary policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (PrincipalAccessBoundaryPolicy element :
   *       principalAccessBoundaryPoliciesClient
   *           .listPrincipalAccessBoundaryPolicies(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource, which owns the collection of principal access
   *     boundary policies.
   *     <p>Format: `organizations/{organization_id}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrincipalAccessBoundaryPoliciesPagedResponse listPrincipalAccessBoundaryPolicies(
      String parent) {
    ListPrincipalAccessBoundaryPoliciesRequest request =
        ListPrincipalAccessBoundaryPoliciesRequest.newBuilder().setParent(parent).build();
    return listPrincipalAccessBoundaryPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists principal access boundary policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   ListPrincipalAccessBoundaryPoliciesRequest request =
   *       ListPrincipalAccessBoundaryPoliciesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PrincipalAccessBoundaryPolicy element :
   *       principalAccessBoundaryPoliciesClient
   *           .listPrincipalAccessBoundaryPolicies(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrincipalAccessBoundaryPoliciesPagedResponse listPrincipalAccessBoundaryPolicies(
      ListPrincipalAccessBoundaryPoliciesRequest request) {
    return listPrincipalAccessBoundaryPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists principal access boundary policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   ListPrincipalAccessBoundaryPoliciesRequest request =
   *       ListPrincipalAccessBoundaryPoliciesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PrincipalAccessBoundaryPolicy> future =
   *       principalAccessBoundaryPoliciesClient
   *           .listPrincipalAccessBoundaryPoliciesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (PrincipalAccessBoundaryPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListPrincipalAccessBoundaryPoliciesRequest,
          ListPrincipalAccessBoundaryPoliciesPagedResponse>
      listPrincipalAccessBoundaryPoliciesPagedCallable() {
    return stub.listPrincipalAccessBoundaryPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists principal access boundary policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   ListPrincipalAccessBoundaryPoliciesRequest request =
   *       ListPrincipalAccessBoundaryPoliciesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPrincipalAccessBoundaryPoliciesResponse response =
   *         principalAccessBoundaryPoliciesClient
   *             .listPrincipalAccessBoundaryPoliciesCallable()
   *             .call(request);
   *     for (PrincipalAccessBoundaryPolicy element :
   *         response.getPrincipalAccessBoundaryPoliciesList()) {
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
          ListPrincipalAccessBoundaryPoliciesRequest, ListPrincipalAccessBoundaryPoliciesResponse>
      listPrincipalAccessBoundaryPoliciesCallable() {
    return stub.listPrincipalAccessBoundaryPoliciesCallable();
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
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   PrincipalAccessBoundaryPolicyName name =
   *       PrincipalAccessBoundaryPolicyName.of(
   *           "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]");
   *   for (PolicyBinding element :
   *       principalAccessBoundaryPoliciesClient
   *           .searchPrincipalAccessBoundaryPolicyBindings(name)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the principal access boundary policy. Format:
   *     `organizations/{organization_id}/locations/{location}/principalAccessBoundaryPolicies/{principal_access_boundary_policy_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse
      searchPrincipalAccessBoundaryPolicyBindings(PrincipalAccessBoundaryPolicyName name) {
    SearchPrincipalAccessBoundaryPolicyBindingsRequest request =
        SearchPrincipalAccessBoundaryPolicyBindingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return searchPrincipalAccessBoundaryPolicyBindings(request);
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
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   String name =
   *       PrincipalAccessBoundaryPolicyName.of(
   *               "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
   *           .toString();
   *   for (PolicyBinding element :
   *       principalAccessBoundaryPoliciesClient
   *           .searchPrincipalAccessBoundaryPolicyBindings(name)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the principal access boundary policy. Format:
   *     `organizations/{organization_id}/locations/{location}/principalAccessBoundaryPolicies/{principal_access_boundary_policy_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse
      searchPrincipalAccessBoundaryPolicyBindings(String name) {
    SearchPrincipalAccessBoundaryPolicyBindingsRequest request =
        SearchPrincipalAccessBoundaryPolicyBindingsRequest.newBuilder().setName(name).build();
    return searchPrincipalAccessBoundaryPolicyBindings(request);
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
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   SearchPrincipalAccessBoundaryPolicyBindingsRequest request =
   *       SearchPrincipalAccessBoundaryPolicyBindingsRequest.newBuilder()
   *           .setName(
   *               PrincipalAccessBoundaryPolicyName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PolicyBinding element :
   *       principalAccessBoundaryPoliciesClient
   *           .searchPrincipalAccessBoundaryPolicyBindings(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse
      searchPrincipalAccessBoundaryPolicyBindings(
          SearchPrincipalAccessBoundaryPolicyBindingsRequest request) {
    return searchPrincipalAccessBoundaryPolicyBindingsPagedCallable().call(request);
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
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   SearchPrincipalAccessBoundaryPolicyBindingsRequest request =
   *       SearchPrincipalAccessBoundaryPolicyBindingsRequest.newBuilder()
   *           .setName(
   *               PrincipalAccessBoundaryPolicyName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PolicyBinding> future =
   *       principalAccessBoundaryPoliciesClient
   *           .searchPrincipalAccessBoundaryPolicyBindingsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (PolicyBinding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse>
      searchPrincipalAccessBoundaryPolicyBindingsPagedCallable() {
    return stub.searchPrincipalAccessBoundaryPolicyBindingsPagedCallable();
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
   * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
   *     PrincipalAccessBoundaryPoliciesClient.create()) {
   *   SearchPrincipalAccessBoundaryPolicyBindingsRequest request =
   *       SearchPrincipalAccessBoundaryPolicyBindingsRequest.newBuilder()
   *           .setName(
   *               PrincipalAccessBoundaryPolicyName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchPrincipalAccessBoundaryPolicyBindingsResponse response =
   *         principalAccessBoundaryPoliciesClient
   *             .searchPrincipalAccessBoundaryPolicyBindingsCallable()
   *             .call(request);
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
  public final UnaryCallable<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsResponse>
      searchPrincipalAccessBoundaryPolicyBindingsCallable() {
    return stub.searchPrincipalAccessBoundaryPolicyBindingsCallable();
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

  public static class ListPrincipalAccessBoundaryPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListPrincipalAccessBoundaryPoliciesRequest,
          ListPrincipalAccessBoundaryPoliciesResponse,
          PrincipalAccessBoundaryPolicy,
          ListPrincipalAccessBoundaryPoliciesPage,
          ListPrincipalAccessBoundaryPoliciesFixedSizeCollection> {

    public static ApiFuture<ListPrincipalAccessBoundaryPoliciesPagedResponse> createAsync(
        PageContext<
                ListPrincipalAccessBoundaryPoliciesRequest,
                ListPrincipalAccessBoundaryPoliciesResponse,
                PrincipalAccessBoundaryPolicy>
            context,
        ApiFuture<ListPrincipalAccessBoundaryPoliciesResponse> futureResponse) {
      ApiFuture<ListPrincipalAccessBoundaryPoliciesPage> futurePage =
          ListPrincipalAccessBoundaryPoliciesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPrincipalAccessBoundaryPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPrincipalAccessBoundaryPoliciesPagedResponse(
        ListPrincipalAccessBoundaryPoliciesPage page) {
      super(page, ListPrincipalAccessBoundaryPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPrincipalAccessBoundaryPoliciesPage
      extends AbstractPage<
          ListPrincipalAccessBoundaryPoliciesRequest,
          ListPrincipalAccessBoundaryPoliciesResponse,
          PrincipalAccessBoundaryPolicy,
          ListPrincipalAccessBoundaryPoliciesPage> {

    private ListPrincipalAccessBoundaryPoliciesPage(
        PageContext<
                ListPrincipalAccessBoundaryPoliciesRequest,
                ListPrincipalAccessBoundaryPoliciesResponse,
                PrincipalAccessBoundaryPolicy>
            context,
        ListPrincipalAccessBoundaryPoliciesResponse response) {
      super(context, response);
    }

    private static ListPrincipalAccessBoundaryPoliciesPage createEmptyPage() {
      return new ListPrincipalAccessBoundaryPoliciesPage(null, null);
    }

    @Override
    protected ListPrincipalAccessBoundaryPoliciesPage createPage(
        PageContext<
                ListPrincipalAccessBoundaryPoliciesRequest,
                ListPrincipalAccessBoundaryPoliciesResponse,
                PrincipalAccessBoundaryPolicy>
            context,
        ListPrincipalAccessBoundaryPoliciesResponse response) {
      return new ListPrincipalAccessBoundaryPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListPrincipalAccessBoundaryPoliciesPage> createPageAsync(
        PageContext<
                ListPrincipalAccessBoundaryPoliciesRequest,
                ListPrincipalAccessBoundaryPoliciesResponse,
                PrincipalAccessBoundaryPolicy>
            context,
        ApiFuture<ListPrincipalAccessBoundaryPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPrincipalAccessBoundaryPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPrincipalAccessBoundaryPoliciesRequest,
          ListPrincipalAccessBoundaryPoliciesResponse,
          PrincipalAccessBoundaryPolicy,
          ListPrincipalAccessBoundaryPoliciesPage,
          ListPrincipalAccessBoundaryPoliciesFixedSizeCollection> {

    private ListPrincipalAccessBoundaryPoliciesFixedSizeCollection(
        List<ListPrincipalAccessBoundaryPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPrincipalAccessBoundaryPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListPrincipalAccessBoundaryPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPrincipalAccessBoundaryPoliciesFixedSizeCollection createCollection(
        List<ListPrincipalAccessBoundaryPoliciesPage> pages, int collectionSize) {
      return new ListPrincipalAccessBoundaryPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse
      extends AbstractPagedListResponse<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsResponse,
          PolicyBinding,
          SearchPrincipalAccessBoundaryPolicyBindingsPage,
          SearchPrincipalAccessBoundaryPolicyBindingsFixedSizeCollection> {

    public static ApiFuture<SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse> createAsync(
        PageContext<
                SearchPrincipalAccessBoundaryPolicyBindingsRequest,
                SearchPrincipalAccessBoundaryPolicyBindingsResponse,
                PolicyBinding>
            context,
        ApiFuture<SearchPrincipalAccessBoundaryPolicyBindingsResponse> futureResponse) {
      ApiFuture<SearchPrincipalAccessBoundaryPolicyBindingsPage> futurePage =
          SearchPrincipalAccessBoundaryPolicyBindingsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse(
        SearchPrincipalAccessBoundaryPolicyBindingsPage page) {
      super(
          page,
          SearchPrincipalAccessBoundaryPolicyBindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchPrincipalAccessBoundaryPolicyBindingsPage
      extends AbstractPage<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsResponse,
          PolicyBinding,
          SearchPrincipalAccessBoundaryPolicyBindingsPage> {

    private SearchPrincipalAccessBoundaryPolicyBindingsPage(
        PageContext<
                SearchPrincipalAccessBoundaryPolicyBindingsRequest,
                SearchPrincipalAccessBoundaryPolicyBindingsResponse,
                PolicyBinding>
            context,
        SearchPrincipalAccessBoundaryPolicyBindingsResponse response) {
      super(context, response);
    }

    private static SearchPrincipalAccessBoundaryPolicyBindingsPage createEmptyPage() {
      return new SearchPrincipalAccessBoundaryPolicyBindingsPage(null, null);
    }

    @Override
    protected SearchPrincipalAccessBoundaryPolicyBindingsPage createPage(
        PageContext<
                SearchPrincipalAccessBoundaryPolicyBindingsRequest,
                SearchPrincipalAccessBoundaryPolicyBindingsResponse,
                PolicyBinding>
            context,
        SearchPrincipalAccessBoundaryPolicyBindingsResponse response) {
      return new SearchPrincipalAccessBoundaryPolicyBindingsPage(context, response);
    }

    @Override
    public ApiFuture<SearchPrincipalAccessBoundaryPolicyBindingsPage> createPageAsync(
        PageContext<
                SearchPrincipalAccessBoundaryPolicyBindingsRequest,
                SearchPrincipalAccessBoundaryPolicyBindingsResponse,
                PolicyBinding>
            context,
        ApiFuture<SearchPrincipalAccessBoundaryPolicyBindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchPrincipalAccessBoundaryPolicyBindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsResponse,
          PolicyBinding,
          SearchPrincipalAccessBoundaryPolicyBindingsPage,
          SearchPrincipalAccessBoundaryPolicyBindingsFixedSizeCollection> {

    private SearchPrincipalAccessBoundaryPolicyBindingsFixedSizeCollection(
        List<SearchPrincipalAccessBoundaryPolicyBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchPrincipalAccessBoundaryPolicyBindingsFixedSizeCollection
        createEmptyCollection() {
      return new SearchPrincipalAccessBoundaryPolicyBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchPrincipalAccessBoundaryPolicyBindingsFixedSizeCollection createCollection(
        List<SearchPrincipalAccessBoundaryPolicyBindingsPage> pages, int collectionSize) {
      return new SearchPrincipalAccessBoundaryPolicyBindingsFixedSizeCollection(
          pages, collectionSize);
    }
  }
}
