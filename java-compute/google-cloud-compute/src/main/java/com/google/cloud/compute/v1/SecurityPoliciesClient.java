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
import com.google.cloud.compute.v1.stub.SecurityPoliciesStub;
import com.google.cloud.compute.v1.stub.SecurityPoliciesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The SecurityPolicies API.
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
 * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
 *   String project = "project-309310695";
 *   String securityPolicy = "securityPolicy-788621166";
 *   SecurityPolicy response = securityPoliciesClient.get(project, securityPolicy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SecurityPoliciesClient object to clean up resources
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
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecurityPoliciesSettings securityPoliciesSettings =
 *     SecurityPoliciesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SecurityPoliciesClient securityPoliciesClient =
 *     SecurityPoliciesClient.create(securityPoliciesSettings);
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
 * SecurityPoliciesSettings securityPoliciesSettings =
 *     SecurityPoliciesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SecurityPoliciesClient securityPoliciesClient =
 *     SecurityPoliciesClient.create(securityPoliciesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
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
   * is for advanced usage - prefer using create(SecurityPoliciesSettings).
   */
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

  protected SecurityPoliciesClient(SecurityPoliciesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SecurityPoliciesSettings getSettings() {
    return settings;
  }

  public SecurityPoliciesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a security policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String securityPolicy = "securityPolicy-788621166";
   *   SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();
   *   Operation response =
   *       securityPoliciesClient
   *           .addRuleAsync(project, securityPolicy, securityPolicyRuleResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param securityPolicy Name of the security policy to update.
   * @param securityPolicyRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> addRuleAsync(
      String project, String securityPolicy, SecurityPolicyRule securityPolicyRuleResource) {
    AddRuleSecurityPolicyRequest request =
        AddRuleSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setSecurityPolicy(securityPolicy)
            .setSecurityPolicyRuleResource(securityPolicyRuleResource)
            .build();
    return addRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a security policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   AddRuleSecurityPolicyRequest request =
   *       AddRuleSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Operation response = securityPoliciesClient.addRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> addRuleAsync(
      AddRuleSecurityPolicyRequest request) {
    return addRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a security policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   AddRuleSecurityPolicyRequest request =
   *       AddRuleSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       securityPoliciesClient.addRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AddRuleSecurityPolicyRequest, Operation, Operation>
      addRuleOperationCallable() {
    return stub.addRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a security policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   AddRuleSecurityPolicyRequest request =
   *       AddRuleSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = securityPoliciesClient.addRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddRuleSecurityPolicyRequest, Operation> addRuleCallable() {
    return stub.addRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all SecurityPolicy resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, SecurityPoliciesScopedList> element :
   *       securityPoliciesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Name of the project scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListSecurityPoliciesRequest request =
        AggregatedListSecurityPoliciesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all SecurityPolicy resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   AggregatedListSecurityPoliciesRequest request =
   *       AggregatedListSecurityPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Map.Entry<String, SecurityPoliciesScopedList> element :
   *       securityPoliciesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListSecurityPoliciesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all SecurityPolicy resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   AggregatedListSecurityPoliciesRequest request =
   *       AggregatedListSecurityPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Map.Entry<String, SecurityPoliciesScopedList>> future =
   *       securityPoliciesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, SecurityPoliciesScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregatedListSecurityPoliciesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all SecurityPolicy resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   AggregatedListSecurityPoliciesRequest request =
   *       AggregatedListSecurityPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     SecurityPoliciesAggregatedList response =
   *         securityPoliciesClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, SecurityPoliciesScopedList> element : response.getItemsList()) {
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
  public final UnaryCallable<AggregatedListSecurityPoliciesRequest, SecurityPoliciesAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
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
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String securityPolicy = "securityPolicy-788621166";
   *   Operation response = securityPoliciesClient.deleteAsync(project, securityPolicy).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param securityPolicy Name of the security policy to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String securityPolicy) {
    DeleteSecurityPolicyRequest request =
        DeleteSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setSecurityPolicy(securityPolicy)
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
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   DeleteSecurityPolicyRequest request =
   *       DeleteSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   Operation response = securityPoliciesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteSecurityPolicyRequest request) {
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
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   DeleteSecurityPolicyRequest request =
   *       DeleteSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       securityPoliciesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSecurityPolicyRequest, Operation, Operation>
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
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   DeleteSecurityPolicyRequest request =
   *       DeleteSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   ApiFuture<Operation> future = securityPoliciesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSecurityPolicyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all of the ordered rules present in a single specified policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String securityPolicy = "securityPolicy-788621166";
   *   SecurityPolicy response = securityPoliciesClient.get(project, securityPolicy);
   * }
   * }</pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all of the ordered rules present in a single specified policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   GetSecurityPolicyRequest request =
   *       GetSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   SecurityPolicy response = securityPoliciesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPolicy get(GetSecurityPolicyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all of the ordered rules present in a single specified policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   GetSecurityPolicyRequest request =
   *       GetSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   ApiFuture<SecurityPolicy> future = securityPoliciesClient.getCallable().futureCall(request);
   *   // Do something.
   *   SecurityPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSecurityPolicyRequest, SecurityPolicy> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String securityPolicy = "securityPolicy-788621166";
   *   SecurityPolicyRule response = securityPoliciesClient.getRule(project, securityPolicy);
   * }
   * }</pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   GetRuleSecurityPolicyRequest request =
   *       GetRuleSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   SecurityPolicyRule response = securityPoliciesClient.getRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPolicyRule getRule(GetRuleSecurityPolicyRequest request) {
    return getRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   GetRuleSecurityPolicyRequest request =
   *       GetRuleSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   ApiFuture<SecurityPolicyRule> future =
   *       securityPoliciesClient.getRuleCallable().futureCall(request);
   *   // Do something.
   *   SecurityPolicyRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRuleSecurityPolicyRequest, SecurityPolicyRule> getRuleCallable() {
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
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   SecurityPolicy securityPolicyResource = SecurityPolicy.newBuilder().build();
   *   Operation response =
   *       securityPoliciesClient.insertAsync(project, securityPolicyResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param securityPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, SecurityPolicy securityPolicyResource) {
    InsertSecurityPolicyRequest request =
        InsertSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setSecurityPolicyResource(securityPolicyResource)
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
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   InsertSecurityPolicyRequest request =
   *       InsertSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Operation response = securityPoliciesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertSecurityPolicyRequest request) {
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
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   InsertSecurityPolicyRequest request =
   *       InsertSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       securityPoliciesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertSecurityPolicyRequest, Operation, Operation>
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
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   InsertSecurityPolicyRequest request =
   *       InsertSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = securityPoliciesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertSecurityPolicyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   for (SecurityPolicy element : securityPoliciesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListSecurityPoliciesRequest request =
        ListSecurityPoliciesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   ListSecurityPoliciesRequest request =
   *       ListSecurityPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (SecurityPolicy element : securityPoliciesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListSecurityPoliciesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   ListSecurityPoliciesRequest request =
   *       ListSecurityPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<SecurityPolicy> future =
   *       securityPoliciesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SecurityPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSecurityPoliciesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   ListSecurityPoliciesRequest request =
   *       ListSecurityPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
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
   * }</pre>
   */
  public final UnaryCallable<ListSecurityPoliciesRequest, SecurityPolicyList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the current list of preconfigured Web Application Firewall (WAF) expressions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   SecurityPoliciesListPreconfiguredExpressionSetsResponse response =
   *       securityPoliciesClient.listPreconfiguredExpressionSets(project);
   * }
   * }</pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the current list of preconfigured Web Application Firewall (WAF) expressions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   ListPreconfiguredExpressionSetsSecurityPoliciesRequest request =
   *       ListPreconfiguredExpressionSetsSecurityPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   SecurityPoliciesListPreconfiguredExpressionSetsResponse response =
   *       securityPoliciesClient.listPreconfiguredExpressionSets(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPoliciesListPreconfiguredExpressionSetsResponse
      listPreconfiguredExpressionSets(
          ListPreconfiguredExpressionSetsSecurityPoliciesRequest request) {
    return listPreconfiguredExpressionSetsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the current list of preconfigured Web Application Firewall (WAF) expressions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   ListPreconfiguredExpressionSetsSecurityPoliciesRequest request =
   *       ListPreconfiguredExpressionSetsSecurityPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<SecurityPoliciesListPreconfiguredExpressionSetsResponse> future =
   *       securityPoliciesClient.listPreconfiguredExpressionSetsCallable().futureCall(request);
   *   // Do something.
   *   SecurityPoliciesListPreconfiguredExpressionSetsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
          SecurityPoliciesListPreconfiguredExpressionSetsResponse>
      listPreconfiguredExpressionSetsCallable() {
    return stub.listPreconfiguredExpressionSetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request. This cannot be used to be
   * update the rules in the policy. Please use the per rule methods like addRule, patchRule, and
   * removeRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String securityPolicy = "securityPolicy-788621166";
   *   SecurityPolicy securityPolicyResource = SecurityPolicy.newBuilder().build();
   *   Operation response =
   *       securityPoliciesClient.patchAsync(project, securityPolicy, securityPolicyResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param securityPolicy Name of the security policy to update.
   * @param securityPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String securityPolicy, SecurityPolicy securityPolicyResource) {
    PatchSecurityPolicyRequest request =
        PatchSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setSecurityPolicy(securityPolicy)
            .setSecurityPolicyResource(securityPolicyResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request. This cannot be used to be
   * update the rules in the policy. Please use the per rule methods like addRule, patchRule, and
   * removeRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   PatchSecurityPolicyRequest request =
   *       PatchSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .build();
   *   Operation response = securityPoliciesClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchSecurityPolicyRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request. This cannot be used to be
   * update the rules in the policy. Please use the per rule methods like addRule, patchRule, and
   * removeRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   PatchSecurityPolicyRequest request =
   *       PatchSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       securityPoliciesClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchSecurityPolicyRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request. This cannot be used to be
   * update the rules in the policy. Please use the per rule methods like addRule, patchRule, and
   * removeRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   PatchSecurityPolicyRequest request =
   *       PatchSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = securityPoliciesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchSecurityPolicyRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String securityPolicy = "securityPolicy-788621166";
   *   SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();
   *   Operation response =
   *       securityPoliciesClient
   *           .patchRuleAsync(project, securityPolicy, securityPolicyRuleResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param securityPolicy Name of the security policy to update.
   * @param securityPolicyRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchRuleAsync(
      String project, String securityPolicy, SecurityPolicyRule securityPolicyRuleResource) {
    PatchRuleSecurityPolicyRequest request =
        PatchRuleSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setSecurityPolicy(securityPolicy)
            .setSecurityPolicyRuleResource(securityPolicyRuleResource)
            .build();
    return patchRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   PatchRuleSecurityPolicyRequest request =
   *       PatchRuleSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Operation response = securityPoliciesClient.patchRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchRuleAsync(
      PatchRuleSecurityPolicyRequest request) {
    return patchRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   PatchRuleSecurityPolicyRequest request =
   *       PatchRuleSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       securityPoliciesClient.patchRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRuleSecurityPolicyRequest, Operation, Operation>
      patchRuleOperationCallable() {
    return stub.patchRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   PatchRuleSecurityPolicyRequest request =
   *       PatchRuleSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = securityPoliciesClient.patchRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRuleSecurityPolicyRequest, Operation> patchRuleCallable() {
    return stub.patchRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String securityPolicy = "securityPolicy-788621166";
   *   Operation response = securityPoliciesClient.removeRuleAsync(project, securityPolicy).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param securityPolicy Name of the security policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> removeRuleAsync(
      String project, String securityPolicy) {
    RemoveRuleSecurityPolicyRequest request =
        RemoveRuleSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setSecurityPolicy(securityPolicy)
            .build();
    return removeRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   RemoveRuleSecurityPolicyRequest request =
   *       RemoveRuleSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   Operation response = securityPoliciesClient.removeRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> removeRuleAsync(
      RemoveRuleSecurityPolicyRequest request) {
    return removeRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   RemoveRuleSecurityPolicyRequest request =
   *       RemoveRuleSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       securityPoliciesClient.removeRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RemoveRuleSecurityPolicyRequest, Operation, Operation>
      removeRuleOperationCallable() {
    return stub.removeRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule at the specified priority.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   RemoveRuleSecurityPolicyRequest request =
   *       RemoveRuleSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   ApiFuture<Operation> future = securityPoliciesClient.removeRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveRuleSecurityPolicyRequest, Operation> removeRuleCallable() {
    return stub.removeRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on a security policy. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   GlobalSetLabelsRequest globalSetLabelsRequestResource =
   *       GlobalSetLabelsRequest.newBuilder().build();
   *   Operation response =
   *       securityPoliciesClient
   *           .setLabelsAsync(project, resource, globalSetLabelsRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param globalSetLabelsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setLabelsAsync(
      String project, String resource, GlobalSetLabelsRequest globalSetLabelsRequestResource) {
    SetLabelsSecurityPolicyRequest request =
        SetLabelsSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setGlobalSetLabelsRequestResource(globalSetLabelsRequestResource)
            .build();
    return setLabelsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on a security policy. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   SetLabelsSecurityPolicyRequest request =
   *       SetLabelsSecurityPolicyRequest.newBuilder()
   *           .setGlobalSetLabelsRequestResource(GlobalSetLabelsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   Operation response = securityPoliciesClient.setLabelsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setLabelsAsync(
      SetLabelsSecurityPolicyRequest request) {
    return setLabelsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on a security policy. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   SetLabelsSecurityPolicyRequest request =
   *       SetLabelsSecurityPolicyRequest.newBuilder()
   *           .setGlobalSetLabelsRequestResource(GlobalSetLabelsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       securityPoliciesClient.setLabelsOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetLabelsSecurityPolicyRequest, Operation, Operation>
      setLabelsOperationCallable() {
    return stub.setLabelsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the labels on a security policy. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPoliciesClient securityPoliciesClient = SecurityPoliciesClient.create()) {
   *   SetLabelsSecurityPolicyRequest request =
   *       SetLabelsSecurityPolicyRequest.newBuilder()
   *           .setGlobalSetLabelsRequestResource(GlobalSetLabelsRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Operation> future = securityPoliciesClient.setLabelsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetLabelsSecurityPolicyRequest, Operation> setLabelsCallable() {
    return stub.setLabelsCallable();
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

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListSecurityPoliciesRequest,
          SecurityPoliciesAggregatedList,
          Map.Entry<String, SecurityPoliciesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListSecurityPoliciesRequest,
                SecurityPoliciesAggregatedList,
                Map.Entry<String, SecurityPoliciesScopedList>>
            context,
        ApiFuture<SecurityPoliciesAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new AggregatedListPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private AggregatedListPagedResponse(AggregatedListPage page) {
      super(page, AggregatedListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPage
      extends AbstractPage<
          AggregatedListSecurityPoliciesRequest,
          SecurityPoliciesAggregatedList,
          Map.Entry<String, SecurityPoliciesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListSecurityPoliciesRequest,
                SecurityPoliciesAggregatedList,
                Map.Entry<String, SecurityPoliciesScopedList>>
            context,
        SecurityPoliciesAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListSecurityPoliciesRequest,
                SecurityPoliciesAggregatedList,
                Map.Entry<String, SecurityPoliciesScopedList>>
            context,
        SecurityPoliciesAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListSecurityPoliciesRequest,
                SecurityPoliciesAggregatedList,
                Map.Entry<String, SecurityPoliciesScopedList>>
            context,
        ApiFuture<SecurityPoliciesAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListSecurityPoliciesRequest,
          SecurityPoliciesAggregatedList,
          Map.Entry<String, SecurityPoliciesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    private AggregatedListFixedSizeCollection(List<AggregatedListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListFixedSizeCollection createEmptyCollection() {
      return new AggregatedListFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListFixedSizeCollection createCollection(
        List<AggregatedListPage> pages, int collectionSize) {
      return new AggregatedListFixedSizeCollection(pages, collectionSize);
    }
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
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
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
