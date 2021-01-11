/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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
import com.google.cloud.compute.v1.stub.SecurityPoliciesStub;
import com.google.cloud.compute.v1.stub.SecurityPoliciesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The SecurityPolicies API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
 *   String project = "";
 *   String securityPolicy = "";
 *   SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();
 *   Operation response = securityPoliciesClient.addRule(project, securityPolicy, securityPolicyRuleResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the securityPoliciesClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of SecurityPoliciesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * SecurityPoliciesSettings securityPoliciesSettings =
 *     SecurityPoliciesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SecurityPoliciesClient securityPoliciesClient =
 *     SecurityPoliciesClient.create(securityPoliciesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * SecurityPoliciesSettings securityPoliciesSettings =
 *     SecurityPoliciesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SecurityPoliciesClient securityPoliciesClient =
 *     SecurityPoliciesClient.create(securityPoliciesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class SecurityPoliciesClient implements BackgroundResource {
  private final SecurityPoliciesSettings settings;
  private final SecurityPoliciesStub stub;

  /** Constructs an instance of SecurityPoliciesClient with default settings. */
  public static final SecurityPoliciesClient create() throws IOException {
    return create(SecurityPoliciesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SecurityPoliciesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SecurityPoliciesClient create(SecurityPoliciesSettings settings)
      throws IOException {
    return new SecurityPoliciesClient(settings);
  }

  /**
   * Constructs an instance of SecurityPoliciesClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use SecurityPoliciesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final SecurityPoliciesClient create(SecurityPoliciesStub stub) {
    return new SecurityPoliciesClient(stub);
  }

  /**
   * Constructs an instance of SecurityPoliciesClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SecurityPoliciesClient(SecurityPoliciesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SecurityPoliciesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected SecurityPoliciesClient(SecurityPoliciesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SecurityPoliciesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SecurityPoliciesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Inserts a rule into a security policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();
   *   Operation response = securityPoliciesClient.addRule(project, securityPolicy, securityPolicyRuleResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param securityPolicy Name of the security policy to update.
   * @param securityPolicyRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addRule(
      String project, String securityPolicy, SecurityPolicyRule securityPolicyRuleResource) {
    AddRuleSecurityPolicyRequest request =
        AddRuleSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setSecurityPolicy(securityPolicy)
            .setSecurityPolicyRuleResource(securityPolicyRuleResource)
            .build();
    return addRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Inserts a rule into a security policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();
   *   AddRuleSecurityPolicyRequest request = AddRuleSecurityPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSecurityPolicy(securityPolicy)
   *     .setSecurityPolicyRuleResource(securityPolicyRuleResource)
   *     .build();
   *   Operation response = securityPoliciesClient.addRule(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addRule(AddRuleSecurityPolicyRequest request) {
    return addRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Inserts a rule into a security policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();
   *   AddRuleSecurityPolicyRequest request = AddRuleSecurityPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSecurityPolicy(securityPolicy)
   *     .setSecurityPolicyRuleResource(securityPolicyRuleResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = securityPoliciesClient.addRuleCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AddRuleSecurityPolicyRequest, Operation> addRuleCallable() {
    return stub.addRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   Operation response = securityPoliciesClient.delete(project, securityPolicy);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param securityPolicy Name of the security policy to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String securityPolicy) {
    DeleteSecurityPolicyRequest request =
        DeleteSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setSecurityPolicy(securityPolicy)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   DeleteSecurityPolicyRequest request = DeleteSecurityPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSecurityPolicy(securityPolicy)
   *     .build();
   *   Operation response = securityPoliciesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteSecurityPolicyRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   DeleteSecurityPolicyRequest request = DeleteSecurityPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSecurityPolicy(securityPolicy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = securityPoliciesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteSecurityPolicyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List all of the ordered rules present in a single specified policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   SecurityPolicy response = securityPoliciesClient.get(project, securityPolicy);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param securityPolicy Name of the security policy to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPolicy get(String project, String securityPolicy) {
    GetSecurityPolicyRequest request =
        GetSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setSecurityPolicy(securityPolicy)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List all of the ordered rules present in a single specified policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   GetSecurityPolicyRequest request = GetSecurityPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSecurityPolicy(securityPolicy)
   *     .build();
   *   SecurityPolicy response = securityPoliciesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPolicy get(GetSecurityPolicyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List all of the ordered rules present in a single specified policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   GetSecurityPolicyRequest request = GetSecurityPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSecurityPolicy(securityPolicy)
   *     .build();
   *   ApiFuture&lt;SecurityPolicy&gt; future = securityPoliciesClient.getCallable().futureCall(request);
   *   // Do something
   *   SecurityPolicy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetSecurityPolicyRequest, SecurityPolicy> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   SecurityPolicyRule response = securityPoliciesClient.getRule(project, securityPolicy);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param securityPolicy Name of the security policy to which the queried rule belongs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPolicyRule getRule(String project, String securityPolicy) {
    GetRuleSecurityPolicyRequest request =
        GetRuleSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setSecurityPolicy(securityPolicy)
            .build();
    return getRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   GetRuleSecurityPolicyRequest request = GetRuleSecurityPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSecurityPolicy(securityPolicy)
   *     .build();
   *   SecurityPolicyRule response = securityPoliciesClient.getRule(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPolicyRule getRule(GetRuleSecurityPolicyRequest request) {
    return getRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   GetRuleSecurityPolicyRequest request = GetRuleSecurityPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSecurityPolicy(securityPolicy)
   *     .build();
   *   ApiFuture&lt;SecurityPolicyRule&gt; future = securityPoliciesClient.getRuleCallable().futureCall(request);
   *   // Do something
   *   SecurityPolicyRule response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetRuleSecurityPolicyRequest, SecurityPolicyRule> getRuleCallable() {
    return stub.getRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new policy in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   SecurityPolicy securityPolicyResource = SecurityPolicy.newBuilder().build();
   *   Operation response = securityPoliciesClient.insert(project, securityPolicyResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param securityPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, SecurityPolicy securityPolicyResource) {
    InsertSecurityPolicyRequest request =
        InsertSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setSecurityPolicyResource(securityPolicyResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new policy in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   SecurityPolicy securityPolicyResource = SecurityPolicy.newBuilder().build();
   *   InsertSecurityPolicyRequest request = InsertSecurityPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSecurityPolicyResource(securityPolicyResource)
   *     .build();
   *   Operation response = securityPoliciesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertSecurityPolicyRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new policy in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   SecurityPolicy securityPolicyResource = SecurityPolicy.newBuilder().build();
   *   InsertSecurityPolicyRequest request = InsertSecurityPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSecurityPolicyResource(securityPolicyResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = securityPoliciesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertSecurityPolicyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List all the policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   for (SecurityPolicy element : securityPoliciesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListSecurityPoliciesRequest request =
        ListSecurityPoliciesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List all the policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   ListSecurityPoliciesRequest request = ListSecurityPoliciesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (SecurityPolicy element : securityPoliciesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListSecurityPoliciesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List all the policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   ListSecurityPoliciesRequest request = ListSecurityPoliciesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = securityPoliciesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (SecurityPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListSecurityPoliciesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List all the policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   ListSecurityPoliciesRequest request = ListSecurityPoliciesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     SecurityPolicyList response = securityPoliciesClient.listCallable().call(request);
   *     for (SecurityPolicy element : response.getItemsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListSecurityPoliciesRequest, SecurityPolicyList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the current list of preconfigured Web Application Firewall (WAF) expressions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   SecurityPoliciesListPreconfiguredExpressionSetsResponse response = securityPoliciesClient.listPreconfiguredExpressionSets(project);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPoliciesListPreconfiguredExpressionSetsResponse
      listPreconfiguredExpressionSets(String project) {
    ListPreconfiguredExpressionSetsSecurityPoliciesRequest request =
        ListPreconfiguredExpressionSetsSecurityPoliciesRequest.newBuilder()
            .setProject(project)
            .build();
    return listPreconfiguredExpressionSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the current list of preconfigured Web Application Firewall (WAF) expressions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   ListPreconfiguredExpressionSetsSecurityPoliciesRequest request = ListPreconfiguredExpressionSetsSecurityPoliciesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   SecurityPoliciesListPreconfiguredExpressionSetsResponse response = securityPoliciesClient.listPreconfiguredExpressionSets(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPoliciesListPreconfiguredExpressionSetsResponse
      listPreconfiguredExpressionSets(
          ListPreconfiguredExpressionSetsSecurityPoliciesRequest request) {
    return listPreconfiguredExpressionSetsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the current list of preconfigured Web Application Firewall (WAF) expressions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   ListPreconfiguredExpressionSetsSecurityPoliciesRequest request = ListPreconfiguredExpressionSetsSecurityPoliciesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;SecurityPoliciesListPreconfiguredExpressionSetsResponse&gt; future = securityPoliciesClient.listPreconfiguredExpressionSetsCallable().futureCall(request);
   *   // Do something
   *   SecurityPoliciesListPreconfiguredExpressionSetsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
          SecurityPoliciesListPreconfiguredExpressionSetsResponse>
      listPreconfiguredExpressionSetsCallable() {
    return stub.listPreconfiguredExpressionSetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified policy with the data included in the request. This cannot be used to be
   * update the rules in the policy. Please use the per rule methods like addRule, patchRule, and
   * removeRule instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   SecurityPolicy securityPolicyResource = SecurityPolicy.newBuilder().build();
   *   Operation response = securityPoliciesClient.patch(project, securityPolicy, securityPolicyResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param securityPolicy Name of the security policy to update.
   * @param securityPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
      String project, String securityPolicy, SecurityPolicy securityPolicyResource) {
    PatchSecurityPolicyRequest request =
        PatchSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setSecurityPolicy(securityPolicy)
            .setSecurityPolicyResource(securityPolicyResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified policy with the data included in the request. This cannot be used to be
   * update the rules in the policy. Please use the per rule methods like addRule, patchRule, and
   * removeRule instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   SecurityPolicy securityPolicyResource = SecurityPolicy.newBuilder().build();
   *   PatchSecurityPolicyRequest request = PatchSecurityPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSecurityPolicy(securityPolicy)
   *     .setSecurityPolicyResource(securityPolicyResource)
   *     .build();
   *   Operation response = securityPoliciesClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchSecurityPolicyRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified policy with the data included in the request. This cannot be used to be
   * update the rules in the policy. Please use the per rule methods like addRule, patchRule, and
   * removeRule instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   SecurityPolicy securityPolicyResource = SecurityPolicy.newBuilder().build();
   *   PatchSecurityPolicyRequest request = PatchSecurityPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSecurityPolicy(securityPolicy)
   *     .setSecurityPolicyResource(securityPolicyResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = securityPoliciesClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchSecurityPolicyRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();
   *   Operation response = securityPoliciesClient.patchRule(project, securityPolicy, securityPolicyRuleResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param securityPolicy Name of the security policy to update.
   * @param securityPolicyRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patchRule(
      String project, String securityPolicy, SecurityPolicyRule securityPolicyRuleResource) {
    PatchRuleSecurityPolicyRequest request =
        PatchRuleSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setSecurityPolicy(securityPolicy)
            .setSecurityPolicyRuleResource(securityPolicyRuleResource)
            .build();
    return patchRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();
   *   PatchRuleSecurityPolicyRequest request = PatchRuleSecurityPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSecurityPolicy(securityPolicy)
   *     .setSecurityPolicyRuleResource(securityPolicyRuleResource)
   *     .build();
   *   Operation response = securityPoliciesClient.patchRule(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patchRule(PatchRuleSecurityPolicyRequest request) {
    return patchRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();
   *   PatchRuleSecurityPolicyRequest request = PatchRuleSecurityPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSecurityPolicy(securityPolicy)
   *     .setSecurityPolicyRuleResource(securityPolicyRuleResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = securityPoliciesClient.patchRuleCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchRuleSecurityPolicyRequest, Operation> patchRuleCallable() {
    return stub.patchRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   Operation response = securityPoliciesClient.removeRule(project, securityPolicy);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param securityPolicy Name of the security policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeRule(String project, String securityPolicy) {
    RemoveRuleSecurityPolicyRequest request =
        RemoveRuleSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setSecurityPolicy(securityPolicy)
            .build();
    return removeRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   RemoveRuleSecurityPolicyRequest request = RemoveRuleSecurityPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSecurityPolicy(securityPolicy)
   *     .build();
   *   Operation response = securityPoliciesClient.removeRule(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeRule(RemoveRuleSecurityPolicyRequest request) {
    return removeRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "";
   *   String securityPolicy = "";
   *   RemoveRuleSecurityPolicyRequest request = RemoveRuleSecurityPolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setSecurityPolicy(securityPolicy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = securityPoliciesClient.removeRuleCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RemoveRuleSecurityPolicyRequest, Operation> removeRuleCallable() {
    return stub.removeRuleCallable();
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
          ListSecurityPoliciesRequest,
          SecurityPolicyList,
          SecurityPolicy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy> context,
        ApiFuture<SecurityPolicyList> futureResponse) {
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
          ListSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy, ListPage> {

    private ListPage(
        PageContext<ListSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy> context,
        SecurityPolicyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy> context,
        SecurityPolicyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy> context,
        ApiFuture<SecurityPolicyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSecurityPoliciesRequest,
          SecurityPolicyList,
          SecurityPolicy,
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
