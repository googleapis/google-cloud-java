/*
 * Copyright 2021 Google LLC
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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.FirewallPoliciesStub;
import com.google.cloud.compute.v1.stub.FirewallPoliciesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The FirewallPolicies API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
 *   String firewallPolicy = "firewallPolicy1819692626";
 *   FirewallPolicyAssociation firewallPolicyAssociationResource =
 *       FirewallPolicyAssociation.newBuilder().build();
 *   Operation response =
 *       firewallPoliciesClient.addAssociation(firewallPolicy, firewallPolicyAssociationResource);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the FirewallPoliciesClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of FirewallPoliciesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * FirewallPoliciesSettings firewallPoliciesSettings =
 *     FirewallPoliciesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FirewallPoliciesClient firewallPoliciesClient =
 *     FirewallPoliciesClient.create(firewallPoliciesSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * FirewallPoliciesSettings firewallPoliciesSettings =
 *     FirewallPoliciesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FirewallPoliciesClient firewallPoliciesClient =
 *     FirewallPoliciesClient.create(firewallPoliciesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class FirewallPoliciesClient implements BackgroundResource {
  private final FirewallPoliciesSettings settings;
  private final FirewallPoliciesStub stub;

  /** Constructs an instance of FirewallPoliciesClient with default settings. */
  public static final FirewallPoliciesClient create() throws IOException {
    return create(FirewallPoliciesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FirewallPoliciesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final FirewallPoliciesClient create(FirewallPoliciesSettings settings)
      throws IOException {
    return new FirewallPoliciesClient(settings);
  }

  /**
   * Constructs an instance of FirewallPoliciesClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(FirewallPoliciesSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final FirewallPoliciesClient create(FirewallPoliciesStub stub) {
    return new FirewallPoliciesClient(stub);
  }

  /**
   * Constructs an instance of FirewallPoliciesClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected FirewallPoliciesClient(FirewallPoliciesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((FirewallPoliciesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected FirewallPoliciesClient(FirewallPoliciesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final FirewallPoliciesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public FirewallPoliciesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts an association for the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicyAssociation firewallPolicyAssociationResource =
   *       FirewallPolicyAssociation.newBuilder().build();
   *   Operation response =
   *       firewallPoliciesClient.addAssociation(firewallPolicy, firewallPolicyAssociationResource);
   * }
   * }</pre>
   *
   * @param firewallPolicy Name of the firewall policy to update.
   * @param firewallPolicyAssociationResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addAssociation(
      String firewallPolicy, FirewallPolicyAssociation firewallPolicyAssociationResource) {
    AddAssociationFirewallPolicyRequest request =
        AddAssociationFirewallPolicyRequest.newBuilder()
            .setFirewallPolicy(firewallPolicy)
            .setFirewallPolicyAssociationResource(firewallPolicyAssociationResource)
            .build();
    return addAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts an association for the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   AddAssociationFirewallPolicyRequest request =
   *       AddAssociationFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyAssociationResource(FirewallPolicyAssociation.newBuilder().build())
   *           .setReplaceExistingAssociation(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = firewallPoliciesClient.addAssociation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addAssociation(AddAssociationFirewallPolicyRequest request) {
    return addAssociationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts an association for the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   AddAssociationFirewallPolicyRequest request =
   *       AddAssociationFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyAssociationResource(FirewallPolicyAssociation.newBuilder().build())
   *           .setReplaceExistingAssociation(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       firewallPoliciesClient.addAssociationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddAssociationFirewallPolicyRequest, Operation>
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
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicyRule firewallPolicyRuleResource = FirewallPolicyRule.newBuilder().build();
   *   Operation response =
   *       firewallPoliciesClient.addRule(firewallPolicy, firewallPolicyRuleResource);
   * }
   * }</pre>
   *
   * @param firewallPolicy Name of the firewall policy to update.
   * @param firewallPolicyRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addRule(
      String firewallPolicy, FirewallPolicyRule firewallPolicyRuleResource) {
    AddRuleFirewallPolicyRequest request =
        AddRuleFirewallPolicyRequest.newBuilder()
            .setFirewallPolicy(firewallPolicy)
            .setFirewallPolicyRuleResource(firewallPolicyRuleResource)
            .build();
    return addRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   AddRuleFirewallPolicyRequest request =
   *       AddRuleFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyRuleResource(FirewallPolicyRule.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = firewallPoliciesClient.addRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addRule(AddRuleFirewallPolicyRequest request) {
    return addRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   AddRuleFirewallPolicyRequest request =
   *       AddRuleFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyRuleResource(FirewallPolicyRule.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = firewallPoliciesClient.addRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddRuleFirewallPolicyRequest, Operation> addRuleCallable() {
    return stub.addRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies rules to the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   Operation response = firewallPoliciesClient.cloneRules(firewallPolicy);
   * }
   * }</pre>
   *
   * @param firewallPolicy Name of the firewall policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation cloneRules(String firewallPolicy) {
    CloneRulesFirewallPolicyRequest request =
        CloneRulesFirewallPolicyRequest.newBuilder().setFirewallPolicy(firewallPolicy).build();
    return cloneRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies rules to the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   CloneRulesFirewallPolicyRequest request =
   *       CloneRulesFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setRequestId("requestId693933066")
   *           .setSourceFirewallPolicy("sourceFirewallPolicy-593774771")
   *           .build();
   *   Operation response = firewallPoliciesClient.cloneRules(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation cloneRules(CloneRulesFirewallPolicyRequest request) {
    return cloneRulesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies rules to the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   CloneRulesFirewallPolicyRequest request =
   *       CloneRulesFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setRequestId("requestId693933066")
   *           .setSourceFirewallPolicy("sourceFirewallPolicy-593774771")
   *           .build();
   *   ApiFuture<Operation> future = firewallPoliciesClient.cloneRulesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CloneRulesFirewallPolicyRequest, Operation> cloneRulesCallable() {
    return stub.cloneRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   Operation response = firewallPoliciesClient.delete(firewallPolicy);
   * }
   * }</pre>
   *
   * @param firewallPolicy Name of the firewall policy to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String firewallPolicy) {
    DeleteFirewallPolicyRequest request =
        DeleteFirewallPolicyRequest.newBuilder().setFirewallPolicy(firewallPolicy).build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   DeleteFirewallPolicyRequest request =
   *       DeleteFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = firewallPoliciesClient.delete(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteFirewallPolicyRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   DeleteFirewallPolicyRequest request =
   *       DeleteFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = firewallPoliciesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFirewallPolicyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicy response = firewallPoliciesClient.get(firewallPolicy);
   * }
   * }</pre>
   *
   * @param firewallPolicy Name of the firewall policy to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicy get(String firewallPolicy) {
    GetFirewallPolicyRequest request =
        GetFirewallPolicyRequest.newBuilder().setFirewallPolicy(firewallPolicy).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   GetFirewallPolicyRequest request =
   *       GetFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .build();
   *   FirewallPolicy response = firewallPoliciesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicy get(GetFirewallPolicyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   GetFirewallPolicyRequest request =
   *       GetFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .build();
   *   ApiFuture<FirewallPolicy> future = firewallPoliciesClient.getCallable().futureCall(request);
   *   // Do something.
   *   FirewallPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFirewallPolicyRequest, FirewallPolicy> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an association with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicyAssociation response = firewallPoliciesClient.getAssociation(firewallPolicy);
   * }
   * }</pre>
   *
   * @param firewallPolicy Name of the firewall policy to which the queried rule belongs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicyAssociation getAssociation(String firewallPolicy) {
    GetAssociationFirewallPolicyRequest request =
        GetAssociationFirewallPolicyRequest.newBuilder().setFirewallPolicy(firewallPolicy).build();
    return getAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an association with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   GetAssociationFirewallPolicyRequest request =
   *       GetAssociationFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setName("name3373707")
   *           .build();
   *   FirewallPolicyAssociation response = firewallPoliciesClient.getAssociation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicyAssociation getAssociation(
      GetAssociationFirewallPolicyRequest request) {
    return getAssociationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an association with the specified name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   GetAssociationFirewallPolicyRequest request =
   *       GetAssociationFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<FirewallPolicyAssociation> future =
   *       firewallPoliciesClient.getAssociationCallable().futureCall(request);
   *   // Do something.
   *   FirewallPolicyAssociation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAssociationFirewallPolicyRequest, FirewallPolicyAssociation>
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
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   String resource = "resource-341064690";
   *   Policy response = firewallPoliciesClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyFirewallPolicyRequest request =
        GetIamPolicyFirewallPolicyRequest.newBuilder().setResource(resource).build();
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
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   GetIamPolicyFirewallPolicyRequest request =
   *       GetIamPolicyFirewallPolicyRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = firewallPoliciesClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyFirewallPolicyRequest request) {
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
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   GetIamPolicyFirewallPolicyRequest request =
   *       GetIamPolicyFirewallPolicyRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future = firewallPoliciesClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyFirewallPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicyRule response = firewallPoliciesClient.getRule(firewallPolicy);
   * }
   * }</pre>
   *
   * @param firewallPolicy Name of the firewall policy to which the queried rule belongs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicyRule getRule(String firewallPolicy) {
    GetRuleFirewallPolicyRequest request =
        GetRuleFirewallPolicyRequest.newBuilder().setFirewallPolicy(firewallPolicy).build();
    return getRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   GetRuleFirewallPolicyRequest request =
   *       GetRuleFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setPriority(-1165461084)
   *           .build();
   *   FirewallPolicyRule response = firewallPoliciesClient.getRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPolicyRule getRule(GetRuleFirewallPolicyRequest request) {
    return getRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   GetRuleFirewallPolicyRequest request =
   *       GetRuleFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setPriority(-1165461084)
   *           .build();
   *   ApiFuture<FirewallPolicyRule> future =
   *       firewallPoliciesClient.getRuleCallable().futureCall(request);
   *   // Do something.
   *   FirewallPolicyRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRuleFirewallPolicyRequest, FirewallPolicyRule> getRuleCallable() {
    return stub.getRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new policy in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   FirewallPolicy firewallPolicyResource = FirewallPolicy.newBuilder().build();
   *   Operation response = firewallPoliciesClient.insert(firewallPolicyResource);
   * }
   * }</pre>
   *
   * @param firewallPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(FirewallPolicy firewallPolicyResource) {
    InsertFirewallPolicyRequest request =
        InsertFirewallPolicyRequest.newBuilder()
            .setFirewallPolicyResource(firewallPolicyResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new policy in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   InsertFirewallPolicyRequest request =
   *       InsertFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicyResource(FirewallPolicy.newBuilder().build())
   *           .setParentId("parentId1175162725")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = firewallPoliciesClient.insert(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertFirewallPolicyRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new policy in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   InsertFirewallPolicyRequest request =
   *       InsertFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicyResource(FirewallPolicy.newBuilder().build())
   *           .setParentId("parentId1175162725")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = firewallPoliciesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertFirewallPolicyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   for (FirewallPolicy element : firewallPoliciesClient.list().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list() {
    ListFirewallPoliciesRequest request = ListFirewallPoliciesRequest.newBuilder().build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   ListFirewallPoliciesRequest request =
   *       ListFirewallPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setParentId("parentId1175162725")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (FirewallPolicy element : firewallPoliciesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListFirewallPoliciesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   ListFirewallPoliciesRequest request =
   *       ListFirewallPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setParentId("parentId1175162725")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<FirewallPolicy> future =
   *       firewallPoliciesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FirewallPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFirewallPoliciesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   ListFirewallPoliciesRequest request =
   *       ListFirewallPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setParentId("parentId1175162725")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     FirewallPolicyList response = firewallPoliciesClient.listCallable().call(request);
   *     for (FirewallPolicy element : response.getResponsesList()) {
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
  public final UnaryCallable<ListFirewallPoliciesRequest, FirewallPolicyList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists associations of a specified target, i.e., organization or folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   FirewallPoliciesListAssociationsResponse response = firewallPoliciesClient.listAssociations();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPoliciesListAssociationsResponse listAssociations() {
    ListAssociationsFirewallPolicyRequest request =
        ListAssociationsFirewallPolicyRequest.newBuilder().build();
    return listAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists associations of a specified target, i.e., organization or folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   ListAssociationsFirewallPolicyRequest request =
   *       ListAssociationsFirewallPolicyRequest.newBuilder()
   *           .setTargetResource("targetResource-1933150017")
   *           .build();
   *   FirewallPoliciesListAssociationsResponse response =
   *       firewallPoliciesClient.listAssociations(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FirewallPoliciesListAssociationsResponse listAssociations(
      ListAssociationsFirewallPolicyRequest request) {
    return listAssociationsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists associations of a specified target, i.e., organization or folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   ListAssociationsFirewallPolicyRequest request =
   *       ListAssociationsFirewallPolicyRequest.newBuilder()
   *           .setTargetResource("targetResource-1933150017")
   *           .build();
   *   ApiFuture<FirewallPoliciesListAssociationsResponse> future =
   *       firewallPoliciesClient.listAssociationsCallable().futureCall(request);
   *   // Do something.
   *   FirewallPoliciesListAssociationsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListAssociationsFirewallPolicyRequest, FirewallPoliciesListAssociationsResponse>
      listAssociationsCallable() {
    return stub.listAssociationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   Operation response = firewallPoliciesClient.move(firewallPolicy);
   * }
   * }</pre>
   *
   * @param firewallPolicy Name of the firewall policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation move(String firewallPolicy) {
    MoveFirewallPolicyRequest request =
        MoveFirewallPolicyRequest.newBuilder().setFirewallPolicy(firewallPolicy).build();
    return move(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   MoveFirewallPolicyRequest request =
   *       MoveFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setParentId("parentId1175162725")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = firewallPoliciesClient.move(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation move(MoveFirewallPolicyRequest request) {
    return moveCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   MoveFirewallPolicyRequest request =
   *       MoveFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setParentId("parentId1175162725")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = firewallPoliciesClient.moveCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MoveFirewallPolicyRequest, Operation> moveCallable() {
    return stub.moveCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicy firewallPolicyResource = FirewallPolicy.newBuilder().build();
   *   Operation response = firewallPoliciesClient.patch(firewallPolicy, firewallPolicyResource);
   * }
   * }</pre>
   *
   * @param firewallPolicy Name of the firewall policy to update.
   * @param firewallPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(String firewallPolicy, FirewallPolicy firewallPolicyResource) {
    PatchFirewallPolicyRequest request =
        PatchFirewallPolicyRequest.newBuilder()
            .setFirewallPolicy(firewallPolicy)
            .setFirewallPolicyResource(firewallPolicyResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   PatchFirewallPolicyRequest request =
   *       PatchFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyResource(FirewallPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = firewallPoliciesClient.patch(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchFirewallPolicyRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   PatchFirewallPolicyRequest request =
   *       PatchFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyResource(FirewallPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = firewallPoliciesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchFirewallPolicyRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   FirewallPolicyRule firewallPolicyRuleResource = FirewallPolicyRule.newBuilder().build();
   *   Operation response =
   *       firewallPoliciesClient.patchRule(firewallPolicy, firewallPolicyRuleResource);
   * }
   * }</pre>
   *
   * @param firewallPolicy Name of the firewall policy to update.
   * @param firewallPolicyRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patchRule(
      String firewallPolicy, FirewallPolicyRule firewallPolicyRuleResource) {
    PatchRuleFirewallPolicyRequest request =
        PatchRuleFirewallPolicyRequest.newBuilder()
            .setFirewallPolicy(firewallPolicy)
            .setFirewallPolicyRuleResource(firewallPolicyRuleResource)
            .build();
    return patchRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   PatchRuleFirewallPolicyRequest request =
   *       PatchRuleFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyRuleResource(FirewallPolicyRule.newBuilder().build())
   *           .setPriority(-1165461084)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = firewallPoliciesClient.patchRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patchRule(PatchRuleFirewallPolicyRequest request) {
    return patchRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   PatchRuleFirewallPolicyRequest request =
   *       PatchRuleFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setFirewallPolicyRuleResource(FirewallPolicyRule.newBuilder().build())
   *           .setPriority(-1165461084)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = firewallPoliciesClient.patchRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRuleFirewallPolicyRequest, Operation> patchRuleCallable() {
    return stub.patchRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an association for the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   Operation response = firewallPoliciesClient.removeAssociation(firewallPolicy);
   * }
   * }</pre>
   *
   * @param firewallPolicy Name of the firewall policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeAssociation(String firewallPolicy) {
    RemoveAssociationFirewallPolicyRequest request =
        RemoveAssociationFirewallPolicyRequest.newBuilder()
            .setFirewallPolicy(firewallPolicy)
            .build();
    return removeAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an association for the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   RemoveAssociationFirewallPolicyRequest request =
   *       RemoveAssociationFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = firewallPoliciesClient.removeAssociation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeAssociation(RemoveAssociationFirewallPolicyRequest request) {
    return removeAssociationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an association for the specified firewall policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   RemoveAssociationFirewallPolicyRequest request =
   *       RemoveAssociationFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       firewallPoliciesClient.removeAssociationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveAssociationFirewallPolicyRequest, Operation>
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
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   String firewallPolicy = "firewallPolicy1819692626";
   *   Operation response = firewallPoliciesClient.removeRule(firewallPolicy);
   * }
   * }</pre>
   *
   * @param firewallPolicy Name of the firewall policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeRule(String firewallPolicy) {
    RemoveRuleFirewallPolicyRequest request =
        RemoveRuleFirewallPolicyRequest.newBuilder().setFirewallPolicy(firewallPolicy).build();
    return removeRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   RemoveRuleFirewallPolicyRequest request =
   *       RemoveRuleFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setPriority(-1165461084)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = firewallPoliciesClient.removeRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeRule(RemoveRuleFirewallPolicyRequest request) {
    return removeRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule of the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   RemoveRuleFirewallPolicyRequest request =
   *       RemoveRuleFirewallPolicyRequest.newBuilder()
   *           .setFirewallPolicy("firewallPolicy1819692626")
   *           .setPriority(-1165461084)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = firewallPoliciesClient.removeRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveRuleFirewallPolicyRequest, Operation> removeRuleCallable() {
    return stub.removeRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   String resource = "resource-341064690";
   *   GlobalOrganizationSetPolicyRequest globalOrganizationSetPolicyRequestResource =
   *       GlobalOrganizationSetPolicyRequest.newBuilder().build();
   *   Policy response =
   *       firewallPoliciesClient.setIamPolicy(resource, globalOrganizationSetPolicyRequestResource);
   * }
   * }</pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param globalOrganizationSetPolicyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(
      String resource,
      GlobalOrganizationSetPolicyRequest globalOrganizationSetPolicyRequestResource) {
    SetIamPolicyFirewallPolicyRequest request =
        SetIamPolicyFirewallPolicyRequest.newBuilder()
            .setResource(resource)
            .setGlobalOrganizationSetPolicyRequestResource(
                globalOrganizationSetPolicyRequestResource)
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
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   SetIamPolicyFirewallPolicyRequest request =
   *       SetIamPolicyFirewallPolicyRequest.newBuilder()
   *           .setGlobalOrganizationSetPolicyRequestResource(
   *               GlobalOrganizationSetPolicyRequest.newBuilder().build())
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = firewallPoliciesClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyFirewallPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   SetIamPolicyFirewallPolicyRequest request =
   *       SetIamPolicyFirewallPolicyRequest.newBuilder()
   *           .setGlobalOrganizationSetPolicyRequestResource(
   *               GlobalOrganizationSetPolicyRequest.newBuilder().build())
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future = firewallPoliciesClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyFirewallPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   String resource = "resource-341064690";
   *   TestPermissionsRequest testPermissionsRequestResource =
   *       TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response =
   *       firewallPoliciesClient.testIamPermissions(resource, testPermissionsRequestResource);
   * }
   * }</pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String resource, TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsFirewallPolicyRequest request =
        TestIamPermissionsFirewallPolicyRequest.newBuilder()
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
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   TestIamPermissionsFirewallPolicyRequest request =
   *       TestIamPermissionsFirewallPolicyRequest.newBuilder()
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   TestPermissionsResponse response = firewallPoliciesClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsFirewallPolicyRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FirewallPoliciesClient firewallPoliciesClient = FirewallPoliciesClient.create()) {
   *   TestIamPermissionsFirewallPolicyRequest request =
   *       TestIamPermissionsFirewallPolicyRequest.newBuilder()
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<TestPermissionsResponse> future =
   *       firewallPoliciesClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsFirewallPolicyRequest, TestPermissionsResponse>
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
          ListFirewallPoliciesRequest,
          FirewallPolicyList,
          FirewallPolicy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy> context,
        ApiFuture<FirewallPolicyList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListPage, ListPagedResponse>() {
            @Override
            public ListPagedResponse apply(ListPage input) {
              return new ListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<
          ListFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy, ListPage> {

    private ListPage(
        PageContext<ListFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy> context,
        FirewallPolicyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy> context,
        FirewallPolicyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListFirewallPoliciesRequest, FirewallPolicyList, FirewallPolicy> context,
        ApiFuture<FirewallPolicyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFirewallPoliciesRequest,
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
