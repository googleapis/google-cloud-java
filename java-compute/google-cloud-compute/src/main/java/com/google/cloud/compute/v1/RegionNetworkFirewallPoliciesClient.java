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
import com.google.cloud.compute.v1.stub.RegionNetworkFirewallPoliciesStub;
import com.google.cloud.compute.v1.stub.RegionNetworkFirewallPoliciesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionNetworkFirewallPolicies API.
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
 * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
 *     RegionNetworkFirewallPoliciesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String firewallPolicy = "firewallPolicy1819692626";
 *   FirewallPolicy response =
 *       regionNetworkFirewallPoliciesClient.get(project, region, firewallPolicy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionNetworkFirewallPoliciesClient object to clean up
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
 * RegionNetworkFirewallPoliciesSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionNetworkFirewallPoliciesSettings regionNetworkFirewallPoliciesSettings =
 *     RegionNetworkFirewallPoliciesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
 *     RegionNetworkFirewallPoliciesClient.create(regionNetworkFirewallPoliciesSettings);
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
 * RegionNetworkFirewallPoliciesSettings regionNetworkFirewallPoliciesSettings =
 *     RegionNetworkFirewallPoliciesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
 *     RegionNetworkFirewallPoliciesClient.create(regionNetworkFirewallPoliciesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionNetworkFirewallPoliciesClient implements BackgroundResource {
  private final RegionNetworkFirewallPoliciesSettings settings;
  private final RegionNetworkFirewallPoliciesStub stub;

  /** Constructs an instance of RegionNetworkFirewallPoliciesClient with default settings. */
  public static final RegionNetworkFirewallPoliciesClient create() throws IOException {
    return create(RegionNetworkFirewallPoliciesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionNetworkFirewallPoliciesClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RegionNetworkFirewallPoliciesClient create(
      RegionNetworkFirewallPoliciesSettings settings) throws IOException {
    return new RegionNetworkFirewallPoliciesClient(settings);
  }

  /**
   * Constructs an instance of RegionNetworkFirewallPoliciesClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(RegionNetworkFirewallPoliciesSettings).
   */
  public static final RegionNetworkFirewallPoliciesClient create(
      RegionNetworkFirewallPoliciesStub stub) {
    return new RegionNetworkFirewallPoliciesClient(stub);
  }

  /**
   * Constructs an instance of RegionNetworkFirewallPoliciesClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionNetworkFirewallPoliciesClient(RegionNetworkFirewallPoliciesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((RegionNetworkFirewallPoliciesStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionNetworkFirewallPoliciesClient(RegionNetworkFirewallPoliciesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionNetworkFirewallPoliciesSettings getSettings() {
    return settings;
  }

  public RegionNetworkFirewallPoliciesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts an association for the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicyAssociation firewallPolicyAssociationResource =
   *       FirewallPolicyAssociation.newBuilder().build();
   *   Operation response =
   *       regionNetworkFirewallPoliciesClient
   *           .addAssociationAsync(
   *               project, region, firewallPolicy, firewallPolicyAssociationResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param firewallPolicy Name of the firewall policy to update.
   * @param firewallPolicyAssociationResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> addAssociationAsync(
      String project,
      String region,
      String firewallPolicy,
      FirewallPolicyAssociation firewallPolicyAssociationResource) {
    AddAssociationRegionNetworkFirewallPolicyRequest request =
        AddAssociationRegionNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setFirewallPolicy(firewallPolicy)
            .setFirewallPolicyAssociationResource(firewallPolicyAssociationResource)
            .build();
    return addAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts an association for the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   AddAssociationRegionNetworkFirewallPolicyRequest request =
   *       AddAssociationRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyAssociationResource(FirewallPolicyAssociation.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReplaceExistingAssociation(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionNetworkFirewallPoliciesClient.addAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> addAssociationAsync(
      AddAssociationRegionNetworkFirewallPolicyRequest request) {
    return addAssociationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts an association for the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   AddAssociationRegionNetworkFirewallPolicyRequest request =
   *       AddAssociationRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyAssociationResource(FirewallPolicyAssociation.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReplaceExistingAssociation(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionNetworkFirewallPoliciesClient.addAssociationOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          AddAssociationRegionNetworkFirewallPolicyRequest, Operation, Operation>
      addAssociationOperationCallable() {
    return stub.addAssociationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts an association for the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   AddAssociationRegionNetworkFirewallPolicyRequest request =
   *       AddAssociationRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyAssociationResource(FirewallPolicyAssociation.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReplaceExistingAssociation(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionNetworkFirewallPoliciesClient.addAssociationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddAssociationRegionNetworkFirewallPolicyRequest, Operation>
      addAssociationCallable() {
    return stub.addAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicyRule firewallPolicyRuleResource = FirewallPolicyRule.newBuilder().build();
   *   Operation response =
   *       regionNetworkFirewallPoliciesClient
   *           .addRuleAsync(project, region, firewallPolicy, firewallPolicyRuleResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param firewallPolicy Name of the firewall policy to update.
   * @param firewallPolicyRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> addRuleAsync(
      String project,
      String region,
      String firewallPolicy,
      FirewallPolicyRule firewallPolicyRuleResource) {
    AddRuleRegionNetworkFirewallPolicyRequest request =
        AddRuleRegionNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setFirewallPolicy(firewallPolicy)
            .setFirewallPolicyRuleResource(firewallPolicyRuleResource)
            .build();
    return addRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   AddRuleRegionNetworkFirewallPolicyRequest request =
   *       AddRuleRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyRuleResource(FirewallPolicyRule.newBuilder().build())
   *           .setMaxPriority(-207235553)
   *           .setMinPriority(267190513)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionNetworkFirewallPoliciesClient.addRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> addRuleAsync(
      AddRuleRegionNetworkFirewallPolicyRequest request) {
    return addRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   AddRuleRegionNetworkFirewallPolicyRequest request =
   *       AddRuleRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyRuleResource(FirewallPolicyRule.newBuilder().build())
   *           .setMaxPriority(-207235553)
   *           .setMinPriority(267190513)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionNetworkFirewallPoliciesClient.addRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AddRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
      addRuleOperationCallable() {
    return stub.addRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   AddRuleRegionNetworkFirewallPolicyRequest request =
   *       AddRuleRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyRuleResource(FirewallPolicyRule.newBuilder().build())
   *           .setMaxPriority(-207235553)
   *           .setMinPriority(267190513)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionNetworkFirewallPoliciesClient.addRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddRuleRegionNetworkFirewallPolicyRequest, Operation>
      addRuleCallable() {
    return stub.addRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies rules to the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   Operation response =
   *       regionNetworkFirewallPoliciesClient
   *           .cloneRulesAsync(project, region, firewallPolicy)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param firewallPolicy Name of the firewall policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> cloneRulesAsync(
      String project, String region, String firewallPolicy) {
    CloneRulesRegionNetworkFirewallPolicyRequest request =
        CloneRulesRegionNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setFirewallPolicy(firewallPolicy)
            .build();
    return cloneRulesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies rules to the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   CloneRulesRegionNetworkFirewallPolicyRequest request =
   *       CloneRulesRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSourceFirewallPolicy("sourceFirewallPolicy-593774771")
   *           .build();
   *   Operation response = regionNetworkFirewallPoliciesClient.cloneRulesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> cloneRulesAsync(
      CloneRulesRegionNetworkFirewallPolicyRequest request) {
    return cloneRulesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies rules to the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   CloneRulesRegionNetworkFirewallPolicyRequest request =
   *       CloneRulesRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSourceFirewallPolicy("sourceFirewallPolicy-593774771")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionNetworkFirewallPoliciesClient.cloneRulesOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CloneRulesRegionNetworkFirewallPolicyRequest, Operation, Operation>
      cloneRulesOperationCallable() {
    return stub.cloneRulesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies rules to the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   CloneRulesRegionNetworkFirewallPolicyRequest request =
   *       CloneRulesRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSourceFirewallPolicy("sourceFirewallPolicy-593774771")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionNetworkFirewallPoliciesClient.cloneRulesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CloneRulesRegionNetworkFirewallPolicyRequest, Operation>
      cloneRulesCallable() {
    return stub.cloneRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   Operation response =
   *       regionNetworkFirewallPoliciesClient.deleteAsync(project, region, firewallPolicy).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param firewallPolicy Name of the firewall policy to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String firewallPolicy) {
    DeleteRegionNetworkFirewallPolicyRequest request =
        DeleteRegionNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setFirewallPolicy(firewallPolicy)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   DeleteRegionNetworkFirewallPolicyRequest request =
   *       DeleteRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionNetworkFirewallPoliciesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteRegionNetworkFirewallPolicyRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   DeleteRegionNetworkFirewallPolicyRequest request =
   *       DeleteRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionNetworkFirewallPoliciesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRegionNetworkFirewallPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   DeleteRegionNetworkFirewallPolicyRequest request =
   *       DeleteRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionNetworkFirewallPoliciesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionNetworkFirewallPolicyRequest, Operation> deleteCallable() {
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicy response =
   *       regionNetworkFirewallPoliciesClient.get(project, region, firewallPolicy);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param firewallPolicy Name of the firewall policy to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicy get(String project, String region, String firewallPolicy) {
    GetRegionNetworkFirewallPolicyRequest request =
        GetRegionNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   GetRegionNetworkFirewallPolicyRequest request =
   *       GetRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   FirewallPolicy response = regionNetworkFirewallPoliciesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicy get(GetRegionNetworkFirewallPolicyRequest request) {
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   GetRegionNetworkFirewallPolicyRequest request =
   *       GetRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<FirewallPolicy> future =
   *       regionNetworkFirewallPoliciesClient.getCallable().futureCall(request);
   *   // Do something.
   *   FirewallPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionNetworkFirewallPolicyRequest, FirewallPolicy> getCallable() {
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicyAssociation response =
   *       regionNetworkFirewallPoliciesClient.getAssociation(project, region, firewallPolicy);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param firewallPolicy Name of the firewall policy to which the queried association belongs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicyAssociation getAssociation(
      String project, String region, String firewallPolicy) {
    GetAssociationRegionNetworkFirewallPolicyRequest request =
        GetAssociationRegionNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   GetAssociationRegionNetworkFirewallPolicyRequest request =
   *       GetAssociationRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setName("name3373707")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   FirewallPolicyAssociation response =
   *       regionNetworkFirewallPoliciesClient.getAssociation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicyAssociation getAssociation(
      GetAssociationRegionNetworkFirewallPolicyRequest request) {
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   GetAssociationRegionNetworkFirewallPolicyRequest request =
   *       GetAssociationRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setName("name3373707")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<FirewallPolicyAssociation> future =
   *       regionNetworkFirewallPoliciesClient.getAssociationCallable().futureCall(request);
   *   // Do something.
   *   FirewallPolicyAssociation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetAssociationRegionNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationCallable() {
    return stub.getAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the effective firewalls on a given network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String network = "network1843485230";
   *   RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse response =
   *       regionNetworkFirewallPoliciesClient.getEffectiveFirewalls(project, region, network);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param network Network reference
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse getEffectiveFirewalls(
      String project, String region, String network) {
    GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest request =
        GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNetwork(network)
            .build();
    return getEffectiveFirewalls(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the effective firewalls on a given network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest request =
   *       GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setNetwork("network1843485230")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse response =
   *       regionNetworkFirewallPoliciesClient.getEffectiveFirewalls(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse getEffectiveFirewalls(
      GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest request) {
    return getEffectiveFirewallsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the effective firewalls on a given network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest request =
   *       GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setNetwork("network1843485230")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse> future =
   *       regionNetworkFirewallPoliciesClient.getEffectiveFirewallsCallable().futureCall(request);
   *   // Do something.
   *   RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest,
          RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse>
      getEffectiveFirewallsCallable() {
    return stub.getEffectiveFirewallsCallable();
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String resource = "resource-341064690";
   *   Policy response = regionNetworkFirewallPoliciesClient.getIamPolicy(project, region, resource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String project, String region, String resource) {
    GetIamPolicyRegionNetworkFirewallPolicyRequest request =
        GetIamPolicyRegionNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   GetIamPolicyRegionNetworkFirewallPolicyRequest request =
   *       GetIamPolicyRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = regionNetworkFirewallPoliciesClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRegionNetworkFirewallPolicyRequest request) {
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   GetIamPolicyRegionNetworkFirewallPolicyRequest request =
   *       GetIamPolicyRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future =
   *       regionNetworkFirewallPoliciesClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicyRule response =
   *       regionNetworkFirewallPoliciesClient.getRule(project, region, firewallPolicy);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param firewallPolicy Name of the firewall policy to which the queried rule belongs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicyRule getRule(String project, String region, String firewallPolicy) {
    GetRuleRegionNetworkFirewallPolicyRequest request =
        GetRuleRegionNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   GetRuleRegionNetworkFirewallPolicyRequest request =
   *       GetRuleRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   FirewallPolicyRule response = regionNetworkFirewallPoliciesClient.getRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicyRule getRule(GetRuleRegionNetworkFirewallPolicyRequest request) {
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   GetRuleRegionNetworkFirewallPolicyRequest request =
   *       GetRuleRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<FirewallPolicyRule> future =
   *       regionNetworkFirewallPoliciesClient.getRuleCallable().futureCall(request);
   *   // Do something.
   *   FirewallPolicyRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRuleRegionNetworkFirewallPolicyRequest, FirewallPolicyRule>
      getRuleCallable() {
    return stub.getRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network firewall policy in the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   FirewallPolicy firewallPolicyResource = FirewallPolicy.newBuilder().build();
   *   Operation response =
   *       regionNetworkFirewallPoliciesClient
   *           .insertAsync(project, region, firewallPolicyResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param firewallPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, FirewallPolicy firewallPolicyResource) {
    InsertRegionNetworkFirewallPolicyRequest request =
        InsertRegionNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setFirewallPolicyResource(firewallPolicyResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network firewall policy in the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   InsertRegionNetworkFirewallPolicyRequest request =
   *       InsertRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicyResource(FirewallPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionNetworkFirewallPoliciesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertRegionNetworkFirewallPolicyRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network firewall policy in the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   InsertRegionNetworkFirewallPolicyRequest request =
   *       InsertRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicyResource(FirewallPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionNetworkFirewallPoliciesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertRegionNetworkFirewallPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network firewall policy in the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   InsertRegionNetworkFirewallPolicyRequest request =
   *       InsertRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicyResource(FirewallPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionNetworkFirewallPoliciesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionNetworkFirewallPolicyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the network firewall policies that have been configured for the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (FirewallPolicy element :
   *       regionNetworkFirewallPoliciesClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListRegionNetworkFirewallPoliciesRequest request =
        ListRegionNetworkFirewallPoliciesRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the network firewall policies that have been configured for the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   ListRegionNetworkFirewallPoliciesRequest request =
   *       ListRegionNetworkFirewallPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (FirewallPolicy element :
   *       regionNetworkFirewallPoliciesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionNetworkFirewallPoliciesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the network firewall policies that have been configured for the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   ListRegionNetworkFirewallPoliciesRequest request =
   *       ListRegionNetworkFirewallPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<FirewallPolicy> future =
   *       regionNetworkFirewallPoliciesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FirewallPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionNetworkFirewallPoliciesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the network firewall policies that have been configured for the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   ListRegionNetworkFirewallPoliciesRequest request =
   *       ListRegionNetworkFirewallPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     FirewallPolicyList response =
   *         regionNetworkFirewallPoliciesClient.listCallable().call(request);
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
  public final UnaryCallable<ListRegionNetworkFirewallPoliciesRequest, FirewallPolicyList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicy firewallPolicyResource = FirewallPolicy.newBuilder().build();
   *   Operation response =
   *       regionNetworkFirewallPoliciesClient
   *           .patchAsync(project, region, firewallPolicy, firewallPolicyResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param firewallPolicy Name of the firewall policy to update.
   * @param firewallPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String region, String firewallPolicy, FirewallPolicy firewallPolicyResource) {
    PatchRegionNetworkFirewallPolicyRequest request =
        PatchRegionNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setFirewallPolicy(firewallPolicy)
            .setFirewallPolicyResource(firewallPolicyResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   PatchRegionNetworkFirewallPolicyRequest request =
   *       PatchRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyResource(FirewallPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionNetworkFirewallPoliciesClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchRegionNetworkFirewallPolicyRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   PatchRegionNetworkFirewallPolicyRequest request =
   *       PatchRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyResource(FirewallPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionNetworkFirewallPoliciesClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRegionNetworkFirewallPolicyRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   PatchRegionNetworkFirewallPolicyRequest request =
   *       PatchRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyResource(FirewallPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionNetworkFirewallPoliciesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRegionNetworkFirewallPolicyRequest, Operation> patchCallable() {
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicyRule firewallPolicyRuleResource = FirewallPolicyRule.newBuilder().build();
   *   Operation response =
   *       regionNetworkFirewallPoliciesClient
   *           .patchRuleAsync(project, region, firewallPolicy, firewallPolicyRuleResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param firewallPolicy Name of the firewall policy to update.
   * @param firewallPolicyRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchRuleAsync(
      String project,
      String region,
      String firewallPolicy,
      FirewallPolicyRule firewallPolicyRuleResource) {
    PatchRuleRegionNetworkFirewallPolicyRequest request =
        PatchRuleRegionNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   PatchRuleRegionNetworkFirewallPolicyRequest request =
   *       PatchRuleRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyRuleResource(FirewallPolicyRule.newBuilder().build())
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionNetworkFirewallPoliciesClient.patchRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchRuleAsync(
      PatchRuleRegionNetworkFirewallPolicyRequest request) {
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   PatchRuleRegionNetworkFirewallPolicyRequest request =
   *       PatchRuleRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyRuleResource(FirewallPolicyRule.newBuilder().build())
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionNetworkFirewallPoliciesClient.patchRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   PatchRuleRegionNetworkFirewallPolicyRequest request =
   *       PatchRuleRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyRuleResource(FirewallPolicyRule.newBuilder().build())
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionNetworkFirewallPoliciesClient.patchRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRuleRegionNetworkFirewallPolicyRequest, Operation>
      patchRuleCallable() {
    return stub.patchRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an association for the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   Operation response =
   *       regionNetworkFirewallPoliciesClient
   *           .removeAssociationAsync(project, region, firewallPolicy)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param firewallPolicy Name of the firewall policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> removeAssociationAsync(
      String project, String region, String firewallPolicy) {
    RemoveAssociationRegionNetworkFirewallPolicyRequest request =
        RemoveAssociationRegionNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setFirewallPolicy(firewallPolicy)
            .build();
    return removeAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an association for the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   RemoveAssociationRegionNetworkFirewallPolicyRequest request =
   *       RemoveAssociationRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setName("name3373707")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response =
   *       regionNetworkFirewallPoliciesClient.removeAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> removeAssociationAsync(
      RemoveAssociationRegionNetworkFirewallPolicyRequest request) {
    return removeAssociationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an association for the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   RemoveAssociationRegionNetworkFirewallPolicyRequest request =
   *       RemoveAssociationRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setName("name3373707")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionNetworkFirewallPoliciesClient
   *           .removeAssociationOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RemoveAssociationRegionNetworkFirewallPolicyRequest, Operation, Operation>
      removeAssociationOperationCallable() {
    return stub.removeAssociationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an association for the specified network firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   RemoveAssociationRegionNetworkFirewallPolicyRequest request =
   *       RemoveAssociationRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setName("name3373707")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionNetworkFirewallPoliciesClient.removeAssociationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveAssociationRegionNetworkFirewallPolicyRequest, Operation>
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   Operation response =
   *       regionNetworkFirewallPoliciesClient
   *           .removeRuleAsync(project, region, firewallPolicy)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param firewallPolicy Name of the firewall policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> removeRuleAsync(
      String project, String region, String firewallPolicy) {
    RemoveRuleRegionNetworkFirewallPolicyRequest request =
        RemoveRuleRegionNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   RemoveRuleRegionNetworkFirewallPolicyRequest request =
   *       RemoveRuleRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionNetworkFirewallPoliciesClient.removeRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> removeRuleAsync(
      RemoveRuleRegionNetworkFirewallPolicyRequest request) {
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   RemoveRuleRegionNetworkFirewallPolicyRequest request =
   *       RemoveRuleRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionNetworkFirewallPoliciesClient.removeRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RemoveRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   RemoveRuleRegionNetworkFirewallPolicyRequest request =
   *       RemoveRuleRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionNetworkFirewallPoliciesClient.removeRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveRuleRegionNetworkFirewallPolicyRequest, Operation>
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String resource = "resource-341064690";
   *   RegionSetPolicyRequest regionSetPolicyRequestResource =
   *       RegionSetPolicyRequest.newBuilder().build();
   *   Policy response =
   *       regionNetworkFirewallPoliciesClient.setIamPolicy(
   *           project, region, resource, regionSetPolicyRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @param regionSetPolicyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(
      String project,
      String region,
      String resource,
      RegionSetPolicyRequest regionSetPolicyRequestResource) {
    SetIamPolicyRegionNetworkFirewallPolicyRequest request =
        SetIamPolicyRegionNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   SetIamPolicyRegionNetworkFirewallPolicyRequest request =
   *       SetIamPolicyRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionSetPolicyRequestResource(RegionSetPolicyRequest.newBuilder().build())
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = regionNetworkFirewallPoliciesClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRegionNetworkFirewallPolicyRequest request) {
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   SetIamPolicyRegionNetworkFirewallPolicyRequest request =
   *       SetIamPolicyRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRegionSetPolicyRequestResource(RegionSetPolicyRequest.newBuilder().build())
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future =
   *       regionNetworkFirewallPoliciesClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String resource = "resource-341064690";
   *   TestPermissionsRequest testPermissionsRequestResource =
   *       TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response =
   *       regionNetworkFirewallPoliciesClient.testIamPermissions(
   *           project, region, resource, testPermissionsRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project,
      String region,
      String resource,
      TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsRegionNetworkFirewallPolicyRequest request =
        TestIamPermissionsRegionNetworkFirewallPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   TestIamPermissionsRegionNetworkFirewallPolicyRequest request =
   *       TestIamPermissionsRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   TestPermissionsResponse response =
   *       regionNetworkFirewallPoliciesClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsRegionNetworkFirewallPolicyRequest request) {
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
   * try (RegionNetworkFirewallPoliciesClient regionNetworkFirewallPoliciesClient =
   *     RegionNetworkFirewallPoliciesClient.create()) {
   *   TestIamPermissionsRegionNetworkFirewallPolicyRequest request =
   *       TestIamPermissionsRegionNetworkFirewallPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<TestPermissionsResponse> future =
   *       regionNetworkFirewallPoliciesClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          TestIamPermissionsRegionNetworkFirewallPolicyRequest, TestPermissionsResponse>
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
          ListRegionNetworkFirewallPoliciesRequest,
          FirewallPolicyList,
          FirewallPolicy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRegionNetworkFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy>
            context,
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
          ListRegionNetworkFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy, ListPage> {

    private ListPage(
        PageContext<ListRegionNetworkFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy>
            context,
        FirewallPolicyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRegionNetworkFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy>
            context,
        FirewallPolicyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRegionNetworkFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy>
            context,
        ApiFuture<FirewallPolicyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionNetworkFirewallPoliciesRequest,
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
