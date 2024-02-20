/*
 * Copyright 2024 Google LLC
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
import com.google.cloud.compute.v1.stub.RegionSecurityPoliciesStub;
import com.google.cloud.compute.v1.stub.RegionSecurityPoliciesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionSecurityPolicies API.
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
 * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
 *     RegionSecurityPoliciesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String securityPolicy = "securityPolicy-788621166";
 *   SecurityPolicy response = regionSecurityPoliciesClient.get(project, region, securityPolicy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionSecurityPoliciesClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> AddRule</td>
 *      <td><p> Inserts a rule into a security policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> addRuleAsync(AddRuleRegionSecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> addRuleAsync(String project, String region, String securityPolicy, SecurityPolicyRule securityPolicyRuleResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> addRuleOperationCallable()
 *           <li><p> addRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Delete</td>
 *      <td><p> Deletes the specified policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAsync(DeleteRegionSecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAsync(String project, String region, String securityPolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteOperationCallable()
 *           <li><p> deleteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Get</td>
 *      <td><p> List all of the ordered rules present in a single specified policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetRegionSecurityPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String region, String securityPolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRule</td>
 *      <td><p> Gets a rule at the specified priority.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRule(GetRuleRegionSecurityPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRule(String project, String region, String securityPolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Creates a new policy in the specified project using the data included in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertAsync(InsertRegionSecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> insertAsync(String project, String region, SecurityPolicy securityPolicyResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertOperationCallable()
 *           <li><p> insertCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> List all the policies that have been configured for the specified project and region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListRegionSecurityPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> list(String project, String region)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPagedCallable()
 *           <li><p> listCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Patch</td>
 *      <td><p> Patches the specified policy with the data included in the request. To clear fields in the policy, leave the fields empty and specify them in the updateMask. This cannot be used to be update the rules in the policy. Please use the per rule methods like addRule, patchRule, and removeRule instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> patchAsync(PatchRegionSecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> patchAsync(String project, String region, String securityPolicy, SecurityPolicy securityPolicyResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> patchOperationCallable()
 *           <li><p> patchCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PatchRule</td>
 *      <td><p> Patches a rule at the specified priority. To clear fields in the rule, leave the fields empty and specify them in the updateMask.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> patchRuleAsync(PatchRuleRegionSecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> patchRuleAsync(String project, String region, String securityPolicy, SecurityPolicyRule securityPolicyRuleResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> patchRuleOperationCallable()
 *           <li><p> patchRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RemoveRule</td>
 *      <td><p> Deletes a rule at the specified priority.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> removeRuleAsync(RemoveRuleRegionSecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> removeRuleAsync(String project, String region, String securityPolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> removeRuleOperationCallable()
 *           <li><p> removeRuleCallable()
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
 * <p>This class can be customized by passing in a custom instance of RegionSecurityPoliciesSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionSecurityPoliciesSettings regionSecurityPoliciesSettings =
 *     RegionSecurityPoliciesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionSecurityPoliciesClient regionSecurityPoliciesClient =
 *     RegionSecurityPoliciesClient.create(regionSecurityPoliciesSettings);
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
 * RegionSecurityPoliciesSettings regionSecurityPoliciesSettings =
 *     RegionSecurityPoliciesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionSecurityPoliciesClient regionSecurityPoliciesClient =
 *     RegionSecurityPoliciesClient.create(regionSecurityPoliciesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionSecurityPoliciesClient implements BackgroundResource {
  private final RegionSecurityPoliciesSettings settings;
  private final RegionSecurityPoliciesStub stub;

  /** Constructs an instance of RegionSecurityPoliciesClient with default settings. */
  public static final RegionSecurityPoliciesClient create() throws IOException {
    return create(RegionSecurityPoliciesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionSecurityPoliciesClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionSecurityPoliciesClient create(RegionSecurityPoliciesSettings settings)
      throws IOException {
    return new RegionSecurityPoliciesClient(settings);
  }

  /**
   * Constructs an instance of RegionSecurityPoliciesClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(RegionSecurityPoliciesSettings).
   */
  public static final RegionSecurityPoliciesClient create(RegionSecurityPoliciesStub stub) {
    return new RegionSecurityPoliciesClient(stub);
  }

  /**
   * Constructs an instance of RegionSecurityPoliciesClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionSecurityPoliciesClient(RegionSecurityPoliciesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionSecurityPoliciesStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionSecurityPoliciesClient(RegionSecurityPoliciesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionSecurityPoliciesSettings getSettings() {
    return settings;
  }

  public RegionSecurityPoliciesStub getStub() {
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String securityPolicy = "securityPolicy-788621166";
   *   SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();
   *   Operation response =
   *       regionSecurityPoliciesClient
   *           .addRuleAsync(project, region, securityPolicy, securityPolicyRuleResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param securityPolicy Name of the security policy to update.
   * @param securityPolicyRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> addRuleAsync(
      String project,
      String region,
      String securityPolicy,
      SecurityPolicyRule securityPolicyRuleResource) {
    AddRuleRegionSecurityPolicyRequest request =
        AddRuleRegionSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   AddRuleRegionSecurityPolicyRequest request =
   *       AddRuleRegionSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Operation response = regionSecurityPoliciesClient.addRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> addRuleAsync(
      AddRuleRegionSecurityPolicyRequest request) {
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   AddRuleRegionSecurityPolicyRequest request =
   *       AddRuleRegionSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionSecurityPoliciesClient.addRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AddRuleRegionSecurityPolicyRequest, Operation, Operation>
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   AddRuleRegionSecurityPolicyRequest request =
   *       AddRuleRegionSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionSecurityPoliciesClient.addRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddRuleRegionSecurityPolicyRequest, Operation> addRuleCallable() {
    return stub.addRuleCallable();
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String securityPolicy = "securityPolicy-788621166";
   *   Operation response =
   *       regionSecurityPoliciesClient.deleteAsync(project, region, securityPolicy).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param securityPolicy Name of the security policy to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String securityPolicy) {
    DeleteRegionSecurityPolicyRequest request =
        DeleteRegionSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   DeleteRegionSecurityPolicyRequest request =
   *       DeleteRegionSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   Operation response = regionSecurityPoliciesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteRegionSecurityPolicyRequest request) {
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   DeleteRegionSecurityPolicyRequest request =
   *       DeleteRegionSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionSecurityPoliciesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRegionSecurityPolicyRequest, Operation, Operation>
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   DeleteRegionSecurityPolicyRequest request =
   *       DeleteRegionSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionSecurityPoliciesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionSecurityPolicyRequest, Operation> deleteCallable() {
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String securityPolicy = "securityPolicy-788621166";
   *   SecurityPolicy response = regionSecurityPoliciesClient.get(project, region, securityPolicy);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param securityPolicy Name of the security policy to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPolicy get(String project, String region, String securityPolicy) {
    GetRegionSecurityPolicyRequest request =
        GetRegionSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   GetRegionSecurityPolicyRequest request =
   *       GetRegionSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   SecurityPolicy response = regionSecurityPoliciesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPolicy get(GetRegionSecurityPolicyRequest request) {
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   GetRegionSecurityPolicyRequest request =
   *       GetRegionSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   ApiFuture<SecurityPolicy> future =
   *       regionSecurityPoliciesClient.getCallable().futureCall(request);
   *   // Do something.
   *   SecurityPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionSecurityPolicyRequest, SecurityPolicy> getCallable() {
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String securityPolicy = "securityPolicy-788621166";
   *   SecurityPolicyRule response =
   *       regionSecurityPoliciesClient.getRule(project, region, securityPolicy);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param securityPolicy Name of the security policy to which the queried rule belongs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPolicyRule getRule(String project, String region, String securityPolicy) {
    GetRuleRegionSecurityPolicyRequest request =
        GetRuleRegionSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   GetRuleRegionSecurityPolicyRequest request =
   *       GetRuleRegionSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   SecurityPolicyRule response = regionSecurityPoliciesClient.getRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPolicyRule getRule(GetRuleRegionSecurityPolicyRequest request) {
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   GetRuleRegionSecurityPolicyRequest request =
   *       GetRuleRegionSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   ApiFuture<SecurityPolicyRule> future =
   *       regionSecurityPoliciesClient.getRuleCallable().futureCall(request);
   *   // Do something.
   *   SecurityPolicyRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRuleRegionSecurityPolicyRequest, SecurityPolicyRule>
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   SecurityPolicy securityPolicyResource = SecurityPolicy.newBuilder().build();
   *   Operation response =
   *       regionSecurityPoliciesClient.insertAsync(project, region, securityPolicyResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param securityPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, SecurityPolicy securityPolicyResource) {
    InsertRegionSecurityPolicyRequest request =
        InsertRegionSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   InsertRegionSecurityPolicyRequest request =
   *       InsertRegionSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Operation response = regionSecurityPoliciesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertRegionSecurityPolicyRequest request) {
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   InsertRegionSecurityPolicyRequest request =
   *       InsertRegionSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionSecurityPoliciesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertRegionSecurityPolicyRequest, Operation, Operation>
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   InsertRegionSecurityPolicyRequest request =
   *       InsertRegionSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionSecurityPoliciesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionSecurityPolicyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the policies that have been configured for the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (SecurityPolicy element :
   *       regionSecurityPoliciesClient.list(project, region).iterateAll()) {
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
    ListRegionSecurityPoliciesRequest request =
        ListRegionSecurityPoliciesRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the policies that have been configured for the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   ListRegionSecurityPoliciesRequest request =
   *       ListRegionSecurityPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (SecurityPolicy element : regionSecurityPoliciesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionSecurityPoliciesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the policies that have been configured for the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   ListRegionSecurityPoliciesRequest request =
   *       ListRegionSecurityPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<SecurityPolicy> future =
   *       regionSecurityPoliciesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SecurityPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionSecurityPoliciesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the policies that have been configured for the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   ListRegionSecurityPoliciesRequest request =
   *       ListRegionSecurityPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     SecurityPolicyList response = regionSecurityPoliciesClient.listCallable().call(request);
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
  public final UnaryCallable<ListRegionSecurityPoliciesRequest, SecurityPolicyList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request. To clear fields in the
   * policy, leave the fields empty and specify them in the updateMask. This cannot be used to be
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String securityPolicy = "securityPolicy-788621166";
   *   SecurityPolicy securityPolicyResource = SecurityPolicy.newBuilder().build();
   *   Operation response =
   *       regionSecurityPoliciesClient
   *           .patchAsync(project, region, securityPolicy, securityPolicyResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param securityPolicy Name of the security policy to update.
   * @param securityPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String region, String securityPolicy, SecurityPolicy securityPolicyResource) {
    PatchRegionSecurityPolicyRequest request =
        PatchRegionSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setSecurityPolicy(securityPolicy)
            .setSecurityPolicyResource(securityPolicyResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request. To clear fields in the
   * policy, leave the fields empty and specify them in the updateMask. This cannot be used to be
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   PatchRegionSecurityPolicyRequest request =
   *       PatchRegionSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .build();
   *   Operation response = regionSecurityPoliciesClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchRegionSecurityPolicyRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request. To clear fields in the
   * policy, leave the fields empty and specify them in the updateMask. This cannot be used to be
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   PatchRegionSecurityPolicyRequest request =
   *       PatchRegionSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionSecurityPoliciesClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRegionSecurityPolicyRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request. To clear fields in the
   * policy, leave the fields empty and specify them in the updateMask. This cannot be used to be
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   PatchRegionSecurityPolicyRequest request =
   *       PatchRegionSecurityPolicyRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionSecurityPoliciesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRegionSecurityPolicyRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule at the specified priority. To clear fields in the rule, leave the fields empty
   * and specify them in the updateMask.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String securityPolicy = "securityPolicy-788621166";
   *   SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();
   *   Operation response =
   *       regionSecurityPoliciesClient
   *           .patchRuleAsync(project, region, securityPolicy, securityPolicyRuleResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param securityPolicy Name of the security policy to update.
   * @param securityPolicyRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchRuleAsync(
      String project,
      String region,
      String securityPolicy,
      SecurityPolicyRule securityPolicyRuleResource) {
    PatchRuleRegionSecurityPolicyRequest request =
        PatchRuleRegionSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setSecurityPolicy(securityPolicy)
            .setSecurityPolicyRuleResource(securityPolicyRuleResource)
            .build();
    return patchRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule at the specified priority. To clear fields in the rule, leave the fields empty
   * and specify them in the updateMask.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   PatchRuleRegionSecurityPolicyRequest request =
   *       PatchRuleRegionSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .setValidateOnly(true)
   *           .build();
   *   Operation response = regionSecurityPoliciesClient.patchRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchRuleAsync(
      PatchRuleRegionSecurityPolicyRequest request) {
    return patchRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule at the specified priority. To clear fields in the rule, leave the fields empty
   * and specify them in the updateMask.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   PatchRuleRegionSecurityPolicyRequest request =
   *       PatchRuleRegionSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionSecurityPoliciesClient.patchRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRuleRegionSecurityPolicyRequest, Operation, Operation>
      patchRuleOperationCallable() {
    return stub.patchRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule at the specified priority. To clear fields in the rule, leave the fields empty
   * and specify them in the updateMask.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   PatchRuleRegionSecurityPolicyRequest request =
   *       PatchRuleRegionSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .setUpdateMask("updateMask-296147115")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionSecurityPoliciesClient.patchRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRuleRegionSecurityPolicyRequest, Operation> patchRuleCallable() {
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String securityPolicy = "securityPolicy-788621166";
   *   Operation response =
   *       regionSecurityPoliciesClient.removeRuleAsync(project, region, securityPolicy).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param securityPolicy Name of the security policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> removeRuleAsync(
      String project, String region, String securityPolicy) {
    RemoveRuleRegionSecurityPolicyRequest request =
        RemoveRuleRegionSecurityPolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   RemoveRuleRegionSecurityPolicyRequest request =
   *       RemoveRuleRegionSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   Operation response = regionSecurityPoliciesClient.removeRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> removeRuleAsync(
      RemoveRuleRegionSecurityPolicyRequest request) {
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   RemoveRuleRegionSecurityPolicyRequest request =
   *       RemoveRuleRegionSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionSecurityPoliciesClient.removeRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RemoveRuleRegionSecurityPolicyRequest, Operation, Operation>
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
   * try (RegionSecurityPoliciesClient regionSecurityPoliciesClient =
   *     RegionSecurityPoliciesClient.create()) {
   *   RemoveRuleRegionSecurityPolicyRequest request =
   *       RemoveRuleRegionSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionSecurityPoliciesClient.removeRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveRuleRegionSecurityPolicyRequest, Operation>
      removeRuleCallable() {
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
          ListRegionSecurityPoliciesRequest,
          SecurityPolicyList,
          SecurityPolicy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRegionSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy> context,
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
          ListRegionSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy, ListPage> {

    private ListPage(
        PageContext<ListRegionSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy> context,
        SecurityPolicyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRegionSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy> context,
        SecurityPolicyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRegionSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy> context,
        ApiFuture<SecurityPolicyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionSecurityPoliciesRequest,
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
