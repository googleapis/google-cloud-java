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

package com.google.cloud.compute.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.NetworkFirewallPoliciesStub;
import com.google.cloud.compute.v1.stub.NetworkFirewallPoliciesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The NetworkFirewallPolicies API.
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
 * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
 *     NetworkFirewallPoliciesClient.create()) {
 *   String project = "project-309310695";
 *   String firewallPolicy = "firewallPolicy1819692626";
 *   FirewallPolicy response = networkFirewallPoliciesClient.get(project, firewallPolicy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the NetworkFirewallPoliciesClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of
 * NetworkFirewallPoliciesSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetworkFirewallPoliciesSettings networkFirewallPoliciesSettings =
 *     NetworkFirewallPoliciesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
 *     NetworkFirewallPoliciesClient.create(networkFirewallPoliciesSettings);
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
 * NetworkFirewallPoliciesSettings networkFirewallPoliciesSettings =
 *     NetworkFirewallPoliciesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
 *     NetworkFirewallPoliciesClient.create(networkFirewallPoliciesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class NetworkFirewallPoliciesClient implements BackgroundResource {
  private final NetworkFirewallPoliciesSettings settings;
  private final NetworkFirewallPoliciesStub stub;

  /** Constructs an instance of NetworkFirewallPoliciesClient with default settings. */
  public static final NetworkFirewallPoliciesClient create() throws IOException {
    return create(NetworkFirewallPoliciesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NetworkFirewallPoliciesClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NetworkFirewallPoliciesClient create(NetworkFirewallPoliciesSettings settings)
      throws IOException {
    return new NetworkFirewallPoliciesClient(settings);
  }

  /**
   * Constructs an instance of NetworkFirewallPoliciesClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(NetworkFirewallPoliciesSettings).
   */
  public static final NetworkFirewallPoliciesClient create(NetworkFirewallPoliciesStub stub) {
    return new NetworkFirewallPoliciesClient(stub);
  }

  /**
   * Constructs an instance of NetworkFirewallPoliciesClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected NetworkFirewallPoliciesClient(NetworkFirewallPoliciesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((NetworkFirewallPoliciesStubSettings) settings.getStubSettings()).createStub();
  }

  protected NetworkFirewallPoliciesClient(NetworkFirewallPoliciesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NetworkFirewallPoliciesSettings getSettings() {
    return settings;
  }

  public NetworkFirewallPoliciesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts an association for the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicyAssociation firewallPolicyAssociationResource =
   *       FirewallPolicyAssociation.newBuilder().build();
   *   Operation response =
   *       networkFirewallPoliciesClient
   *           .addAssociationAsync(project, firewallPolicy, firewallPolicyAssociationResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param firewallPolicy Name of the firewall policy to update.
   * @param firewallPolicyAssociationResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> addAssociationAsync(
      String project,
      String firewallPolicy,
      FirewallPolicyAssociation firewallPolicyAssociationResource) {
    AddAssociationNetworkFirewallPolicyRequest request =
        AddAssociationNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setFirewallPolicy(firewallPolicy)
            .setFirewallPolicyAssociationResource(firewallPolicyAssociationResource)
            .build();
    return addAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts an association for the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   AddAssociationNetworkFirewallPolicyRequest request =
   *       AddAssociationNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyAssociationResource(FirewallPolicyAssociation.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setReplaceExistingAssociation(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = networkFirewallPoliciesClient.addAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> addAssociationAsync(
      AddAssociationNetworkFirewallPolicyRequest request) {
    return addAssociationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts an association for the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   AddAssociationNetworkFirewallPolicyRequest request =
   *       AddAssociationNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyAssociationResource(FirewallPolicyAssociation.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setReplaceExistingAssociation(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       networkFirewallPoliciesClient.addAssociationOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AddAssociationNetworkFirewallPolicyRequest, Operation, Operation>
      addAssociationOperationCallable() {
    return stub.addAssociationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts an association for the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   AddAssociationNetworkFirewallPolicyRequest request =
   *       AddAssociationNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyAssociationResource(FirewallPolicyAssociation.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setReplaceExistingAssociation(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkFirewallPoliciesClient.addAssociationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddAssociationNetworkFirewallPolicyRequest, Operation>
      addAssociationCallable() {
    return stub.addAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicyRule firewallPolicyRuleResource = FirewallPolicyRule.newBuilder().build();
   *   Operation response =
   *       networkFirewallPoliciesClient
   *           .addRuleAsync(project, firewallPolicy, firewallPolicyRuleResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param firewallPolicy Name of the firewall policy to update.
   * @param firewallPolicyRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> addRuleAsync(
      String project, String firewallPolicy, FirewallPolicyRule firewallPolicyRuleResource) {
    AddRuleNetworkFirewallPolicyRequest request =
        AddRuleNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setFirewallPolicy(firewallPolicy)
            .setFirewallPolicyRuleResource(firewallPolicyRuleResource)
            .build();
    return addRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   AddRuleNetworkFirewallPolicyRequest request =
   *       AddRuleNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyRuleResource(FirewallPolicyRule.newBuilder().build())
   *           .setMaxPriority(-207235553)
   *           .setMinPriority(267190513)
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = networkFirewallPoliciesClient.addRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> addRuleAsync(
      AddRuleNetworkFirewallPolicyRequest request) {
    return addRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   AddRuleNetworkFirewallPolicyRequest request =
   *       AddRuleNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyRuleResource(FirewallPolicyRule.newBuilder().build())
   *           .setMaxPriority(-207235553)
   *           .setMinPriority(267190513)
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       networkFirewallPoliciesClient.addRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AddRuleNetworkFirewallPolicyRequest, Operation, Operation>
      addRuleOperationCallable() {
    return stub.addRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   AddRuleNetworkFirewallPolicyRequest request =
   *       AddRuleNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyRuleResource(FirewallPolicyRule.newBuilder().build())
   *           .setMaxPriority(-207235553)
   *           .setMinPriority(267190513)
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkFirewallPoliciesClient.addRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddRuleNetworkFirewallPolicyRequest, Operation> addRuleCallable() {
    return stub.addRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies rules to the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   Operation response =
   *       networkFirewallPoliciesClient.cloneRulesAsync(project, firewallPolicy).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param firewallPolicy Name of the firewall policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> cloneRulesAsync(
      String project, String firewallPolicy) {
    CloneRulesNetworkFirewallPolicyRequest request =
        CloneRulesNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setFirewallPolicy(firewallPolicy)
            .build();
    return cloneRulesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies rules to the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   CloneRulesNetworkFirewallPolicyRequest request =
   *       CloneRulesNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSourceFirewallPolicy("sourceFirewallPolicy-593774771")
   *           .build();
   *   Operation response = networkFirewallPoliciesClient.cloneRulesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> cloneRulesAsync(
      CloneRulesNetworkFirewallPolicyRequest request) {
    return cloneRulesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies rules to the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   CloneRulesNetworkFirewallPolicyRequest request =
   *       CloneRulesNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSourceFirewallPolicy("sourceFirewallPolicy-593774771")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       networkFirewallPoliciesClient.cloneRulesOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CloneRulesNetworkFirewallPolicyRequest, Operation, Operation>
      cloneRulesOperationCallable() {
    return stub.cloneRulesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies rules to the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   CloneRulesNetworkFirewallPolicyRequest request =
   *       CloneRulesNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSourceFirewallPolicy("sourceFirewallPolicy-593774771")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkFirewallPoliciesClient.cloneRulesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CloneRulesNetworkFirewallPolicyRequest, Operation>
      cloneRulesCallable() {
    return stub.cloneRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   Operation response = networkFirewallPoliciesClient.deleteAsync(project, firewallPolicy).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param firewallPolicy Name of the firewall policy to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String firewallPolicy) {
    DeleteNetworkFirewallPolicyRequest request =
        DeleteNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setFirewallPolicy(firewallPolicy)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   DeleteNetworkFirewallPolicyRequest request =
   *       DeleteNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = networkFirewallPoliciesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteNetworkFirewallPolicyRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   DeleteNetworkFirewallPolicyRequest request =
   *       DeleteNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       networkFirewallPoliciesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteNetworkFirewallPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   DeleteNetworkFirewallPolicyRequest request =
   *       DeleteNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkFirewallPoliciesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNetworkFirewallPolicyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicy response = networkFirewallPoliciesClient.get(project, firewallPolicy);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param firewallPolicy Name of the firewall policy to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicy get(String project, String firewallPolicy) {
    GetNetworkFirewallPolicyRequest request =
        GetNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setFirewallPolicy(firewallPolicy)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   GetNetworkFirewallPolicyRequest request =
   *       GetNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setProject("project-309310695")
   *           .build();
   *   FirewallPolicy response = networkFirewallPoliciesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicy get(GetNetworkFirewallPolicyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   GetNetworkFirewallPolicyRequest request =
   *       GetNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<FirewallPolicy> future =
   *       networkFirewallPoliciesClient.getCallable().futureCall(request);
   *   // Do something.
   *   FirewallPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNetworkFirewallPolicyRequest, FirewallPolicy> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an association with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicyAssociation response =
   *       networkFirewallPoliciesClient.getAssociation(project, firewallPolicy);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param firewallPolicy Name of the firewall policy to which the queried association belongs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicyAssociation getAssociation(String project, String firewallPolicy) {
    GetAssociationNetworkFirewallPolicyRequest request =
        GetAssociationNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setFirewallPolicy(firewallPolicy)
            .build();
    return getAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an association with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   GetAssociationNetworkFirewallPolicyRequest request =
   *       GetAssociationNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setName("name3373707")
   *           .setProject("project-309310695")
   *           .build();
   *   FirewallPolicyAssociation response = networkFirewallPoliciesClient.getAssociation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicyAssociation getAssociation(
      GetAssociationNetworkFirewallPolicyRequest request) {
    return getAssociationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an association with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   GetAssociationNetworkFirewallPolicyRequest request =
   *       GetAssociationNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setName("name3373707")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<FirewallPolicyAssociation> future =
   *       networkFirewallPoliciesClient.getAssociationCallable().futureCall(request);
   *   // Do something.
   *   FirewallPolicyAssociation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAssociationNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationCallable() {
    return stub.getAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   Policy response = networkFirewallPoliciesClient.getIamPolicy(project, resource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String project, String resource) {
    GetIamPolicyNetworkFirewallPolicyRequest request =
        GetIamPolicyNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   GetIamPolicyNetworkFirewallPolicyRequest request =
   *       GetIamPolicyNetworkFirewallPolicyRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = networkFirewallPoliciesClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyNetworkFirewallPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   GetIamPolicyNetworkFirewallPolicyRequest request =
   *       GetIamPolicyNetworkFirewallPolicyRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future =
   *       networkFirewallPoliciesClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyNetworkFirewallPolicyRequest, Policy>
      getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicyRule response = networkFirewallPoliciesClient.getRule(project, firewallPolicy);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param firewallPolicy Name of the firewall policy to which the queried rule belongs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicyRule getRule(String project, String firewallPolicy) {
    GetRuleNetworkFirewallPolicyRequest request =
        GetRuleNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setFirewallPolicy(firewallPolicy)
            .build();
    return getRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   GetRuleNetworkFirewallPolicyRequest request =
   *       GetRuleNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .build();
   *   FirewallPolicyRule response = networkFirewallPoliciesClient.getRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicyRule getRule(GetRuleNetworkFirewallPolicyRequest request) {
    return getRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   GetRuleNetworkFirewallPolicyRequest request =
   *       GetRuleNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<FirewallPolicyRule> future =
   *       networkFirewallPoliciesClient.getRuleCallable().futureCall(request);
   *   // Do something.
   *   FirewallPolicyRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
      getRuleCallable() {
    return stub.getRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new policy in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   FirewallPolicy firewallPolicyResource = FirewallPolicy.newBuilder().build();
   *   Operation response =
   *       networkFirewallPoliciesClient.insertAsync(project, firewallPolicyResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param firewallPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, FirewallPolicy firewallPolicyResource) {
    InsertNetworkFirewallPolicyRequest request =
        InsertNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setFirewallPolicyResource(firewallPolicyResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new policy in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   InsertNetworkFirewallPolicyRequest request =
   *       InsertNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicyResource(FirewallPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = networkFirewallPoliciesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertNetworkFirewallPolicyRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new policy in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   InsertNetworkFirewallPolicyRequest request =
   *       InsertNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicyResource(FirewallPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       networkFirewallPoliciesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertNetworkFirewallPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new policy in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   InsertNetworkFirewallPolicyRequest request =
   *       InsertNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicyResource(FirewallPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkFirewallPoliciesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertNetworkFirewallPolicyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   for (FirewallPolicy element : networkFirewallPoliciesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListNetworkFirewallPoliciesRequest request =
        ListNetworkFirewallPoliciesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   ListNetworkFirewallPoliciesRequest request =
   *       ListNetworkFirewallPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (FirewallPolicy element : networkFirewallPoliciesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListNetworkFirewallPoliciesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   ListNetworkFirewallPoliciesRequest request =
   *       ListNetworkFirewallPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<FirewallPolicy> future =
   *       networkFirewallPoliciesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FirewallPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNetworkFirewallPoliciesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   ListNetworkFirewallPoliciesRequest request =
   *       ListNetworkFirewallPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     FirewallPolicyList response = networkFirewallPoliciesClient.listCallable().call(request);
   *     for (FirewallPolicy element : response.getItemsList()) {
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
  public final UnaryCallable<ListNetworkFirewallPoliciesRequest, FirewallPolicyList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicy firewallPolicyResource = FirewallPolicy.newBuilder().build();
   *   Operation response =
   *       networkFirewallPoliciesClient
   *           .patchAsync(project, firewallPolicy, firewallPolicyResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param firewallPolicy Name of the firewall policy to update.
   * @param firewallPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String firewallPolicy, FirewallPolicy firewallPolicyResource) {
    PatchNetworkFirewallPolicyRequest request =
        PatchNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setFirewallPolicy(firewallPolicy)
            .setFirewallPolicyResource(firewallPolicyResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   PatchNetworkFirewallPolicyRequest request =
   *       PatchNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyResource(FirewallPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = networkFirewallPoliciesClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchNetworkFirewallPolicyRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   PatchNetworkFirewallPolicyRequest request =
   *       PatchNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyResource(FirewallPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       networkFirewallPoliciesClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchNetworkFirewallPolicyRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   PatchNetworkFirewallPolicyRequest request =
   *       PatchNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyResource(FirewallPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkFirewallPoliciesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchNetworkFirewallPolicyRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicyRule firewallPolicyRuleResource = FirewallPolicyRule.newBuilder().build();
   *   Operation response =
   *       networkFirewallPoliciesClient
   *           .patchRuleAsync(project, firewallPolicy, firewallPolicyRuleResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param firewallPolicy Name of the firewall policy to update.
   * @param firewallPolicyRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchRuleAsync(
      String project, String firewallPolicy, FirewallPolicyRule firewallPolicyRuleResource) {
    PatchRuleNetworkFirewallPolicyRequest request =
        PatchRuleNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setFirewallPolicy(firewallPolicy)
            .setFirewallPolicyRuleResource(firewallPolicyRuleResource)
            .build();
    return patchRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   PatchRuleNetworkFirewallPolicyRequest request =
   *       PatchRuleNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyRuleResource(FirewallPolicyRule.newBuilder().build())
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = networkFirewallPoliciesClient.patchRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchRuleAsync(
      PatchRuleNetworkFirewallPolicyRequest request) {
    return patchRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   PatchRuleNetworkFirewallPolicyRequest request =
   *       PatchRuleNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyRuleResource(FirewallPolicyRule.newBuilder().build())
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       networkFirewallPoliciesClient.patchRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRuleNetworkFirewallPolicyRequest, Operation, Operation>
      patchRuleOperationCallable() {
    return stub.patchRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   PatchRuleNetworkFirewallPolicyRequest request =
   *       PatchRuleNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyRuleResource(FirewallPolicyRule.newBuilder().build())
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkFirewallPoliciesClient.patchRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRuleNetworkFirewallPolicyRequest, Operation> patchRuleCallable() {
    return stub.patchRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an association for the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   Operation response =
   *       networkFirewallPoliciesClient.removeAssociationAsync(project, firewallPolicy).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param firewallPolicy Name of the firewall policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> removeAssociationAsync(
      String project, String firewallPolicy) {
    RemoveAssociationNetworkFirewallPolicyRequest request =
        RemoveAssociationNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setFirewallPolicy(firewallPolicy)
            .build();
    return removeAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an association for the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   RemoveAssociationNetworkFirewallPolicyRequest request =
   *       RemoveAssociationNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setName("name3373707")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = networkFirewallPoliciesClient.removeAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> removeAssociationAsync(
      RemoveAssociationNetworkFirewallPolicyRequest request) {
    return removeAssociationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an association for the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   RemoveAssociationNetworkFirewallPolicyRequest request =
   *       RemoveAssociationNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setName("name3373707")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       networkFirewallPoliciesClient.removeAssociationOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RemoveAssociationNetworkFirewallPolicyRequest, Operation, Operation>
      removeAssociationOperationCallable() {
    return stub.removeAssociationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an association for the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   RemoveAssociationNetworkFirewallPolicyRequest request =
   *       RemoveAssociationNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setName("name3373707")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkFirewallPoliciesClient.removeAssociationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveAssociationNetworkFirewallPolicyRequest, Operation>
      removeAssociationCallable() {
    return stub.removeAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   Operation response =
   *       networkFirewallPoliciesClient.removeRuleAsync(project, firewallPolicy).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param firewallPolicy Name of the firewall policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> removeRuleAsync(
      String project, String firewallPolicy) {
    RemoveRuleNetworkFirewallPolicyRequest request =
        RemoveRuleNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setFirewallPolicy(firewallPolicy)
            .build();
    return removeRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   RemoveRuleNetworkFirewallPolicyRequest request =
   *       RemoveRuleNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = networkFirewallPoliciesClient.removeRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> removeRuleAsync(
      RemoveRuleNetworkFirewallPolicyRequest request) {
    return removeRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   RemoveRuleNetworkFirewallPolicyRequest request =
   *       RemoveRuleNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       networkFirewallPoliciesClient.removeRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RemoveRuleNetworkFirewallPolicyRequest, Operation, Operation>
      removeRuleOperationCallable() {
    return stub.removeRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   RemoveRuleNetworkFirewallPolicyRequest request =
   *       RemoveRuleNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkFirewallPoliciesClient.removeRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveRuleNetworkFirewallPolicyRequest, Operation>
      removeRuleCallable() {
    return stub.removeRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource =
   *       GlobalSetPolicyRequest.newBuilder().build();
   *   Policy response =
   *       networkFirewallPoliciesClient.setIamPolicy(
   *           project, resource, globalSetPolicyRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param globalSetPolicyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(
      String project, String resource, GlobalSetPolicyRequest globalSetPolicyRequestResource) {
    SetIamPolicyNetworkFirewallPolicyRequest request =
        SetIamPolicyNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   SetIamPolicyNetworkFirewallPolicyRequest request =
   *       SetIamPolicyNetworkFirewallPolicyRequest.newBuilder()
   *           .setGlobalSetPolicyRequestResource(GlobalSetPolicyRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = networkFirewallPoliciesClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyNetworkFirewallPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   SetIamPolicyNetworkFirewallPolicyRequest request =
   *       SetIamPolicyNetworkFirewallPolicyRequest.newBuilder()
   *           .setGlobalSetPolicyRequestResource(GlobalSetPolicyRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future =
   *       networkFirewallPoliciesClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyNetworkFirewallPolicyRequest, Policy>
      setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   TestPermissionsRequest testPermissionsRequestResource =
   *       TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response =
   *       networkFirewallPoliciesClient.testIamPermissions(
   *           project, resource, testPermissionsRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project, String resource, TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsNetworkFirewallPolicyRequest request =
        TestIamPermissionsNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   TestIamPermissionsNetworkFirewallPolicyRequest request =
   *       TestIamPermissionsNetworkFirewallPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   TestPermissionsResponse response = networkFirewallPoliciesClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsNetworkFirewallPolicyRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkFirewallPoliciesClient networkFirewallPoliciesClient =
   *     NetworkFirewallPoliciesClient.create()) {
   *   TestIamPermissionsNetworkFirewallPolicyRequest request =
   *       TestIamPermissionsNetworkFirewallPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<TestPermissionsResponse> future =
   *       networkFirewallPoliciesClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          TestIamPermissionsNetworkFirewallPolicyRequest, TestPermissionsResponse>
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListNetworkFirewallPoliciesRequest,
          FirewallPolicyList,
          FirewallPolicy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListNetworkFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy> context,
        ApiFuture<FirewallPolicyList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<
          ListNetworkFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy, ListPage> {

    private ListPage(
        PageContext<ListNetworkFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy> context,
        FirewallPolicyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListNetworkFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy> context,
        FirewallPolicyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListNetworkFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy> context,
        ApiFuture<FirewallPolicyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNetworkFirewallPoliciesRequest,
          FirewallPolicyList,
          FirewallPolicy,
          ListPage,
          ListFixedSizeCollection> {

    private ListFixedSizeCollection(List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}
