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

package com.google.cloud.compute.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.OrganizationSecurityPoliciesStub;
import com.google.cloud.compute.v1.stub.OrganizationSecurityPoliciesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The OrganizationSecurityPolicies API.
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
 * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
 *     OrganizationSecurityPoliciesClient.create()) {
 *   String securityPolicy = "securityPolicy-788621166";
 *   SecurityPolicy response = organizationSecurityPoliciesClient.get(securityPolicy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the OrganizationSecurityPoliciesClient object to clean up
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
 *      <td><p> AddAssociation</td>
 *      <td><p> Inserts an association for the specified security policy.
 * <p>  This has billing implications.  Projects in the hierarchy with effective hierarchical security policies will be automatically enrolled into Cloud Armor Enterprise if not already enrolled.
 * <p>  Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API were used to modify firewall policies. This usage is now disabled for most organizations. Use firewallPolicies.addAssociation instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> addAssociationAsync(AddAssociationOrganizationSecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> addAssociationAsync(String securityPolicy, SecurityPolicyAssociation securityPolicyAssociationResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> addAssociationOperationCallable()
 *           <li><p> addAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AddRule</td>
 *      <td><p> Inserts a rule into a security policy.
 * <p>  Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API were used to modify firewall policies. This usage is now disabled for most organizations. Use firewallPolicies.addRule instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> addRuleAsync(AddRuleOrganizationSecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> addRuleAsync(String securityPolicy, SecurityPolicyRule securityPolicyRuleResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> addRuleOperationCallable()
 *           <li><p> addRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CopyRules</td>
 *      <td><p> Copies rules to the specified security policy.
 * <p>  Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API were used to modify firewall policies. This usage is now disabled for most organizations. Use firewallPolicies.cloneRules instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> copyRulesAsync(CopyRulesOrganizationSecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> copyRulesAsync(String securityPolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> copyRulesOperationCallable()
 *           <li><p> copyRulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Delete</td>
 *      <td><p> Deletes the specified policy.
 * <p>  Use this API to remove Cloud Armor policies. Previously, alpha and beta versions of this API were used to remove firewall policies. This usage is now disabled for most organizations. Use firewallPolicies.delete instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAsync(DeleteOrganizationSecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAsync(String securityPolicy)
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
 *      <td><p> List all of the ordered rules present in a single specified policy.
 * <p>  Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API were used to read firewall policies. This usage is now disabled for most organizations. Use firewallPolicies.get instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetOrganizationSecurityPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String securityPolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAssociation</td>
 *      <td><p> Gets an association with the specified name.
 * <p>  Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API were used to read firewall policies. This usage is now disabled for most organizations. Use firewallPolicies.getAssociation instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAssociation(GetAssociationOrganizationSecurityPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAssociation(String securityPolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRule</td>
 *      <td><p> Gets a rule at the specified priority.
 * <p>  Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API were used to read firewall policies. This usage is now disabled for most organizations. Use firewallPolicies.getRule instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRule(GetRuleOrganizationSecurityPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRule(String securityPolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Creates a new policy in the specified organization using the data included in the request.
 * <p>  Use this API to add Cloud Armor policies. Previously, alpha and beta versions of this API were used to add firewall policies. This usage is now disabled for most organizations. Use firewallPolicies.insert instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertAsync(InsertOrganizationSecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> insertAsync(SecurityPolicy securityPolicyResource)
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
 *      <td><p> List all the policies that have been configured for the specified organization.
 * <p>  Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API were used to read firewall policies. This usage is now disabled for most organizations. Use firewallPolicies.list instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListOrganizationSecurityPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> list()
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPagedCallable()
 *           <li><p> listCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAssociations</td>
 *      <td><p> Lists associations of a specified target, i.e., organization or folder.
 * <p>  Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API were used to read firewall policies. This usage is now disabled for most organizations. Use firewallPolicies.listAssociations instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAssociations(ListAssociationsOrganizationSecurityPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAssociations()
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAssociationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPreconfiguredExpressionSets</td>
 *      <td><p> Gets the current list of preconfigured Web Application Firewall (WAF) expressions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPreconfiguredExpressionSets(ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPreconfiguredExpressionSets()
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPreconfiguredExpressionSetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Move</td>
 *      <td><p> Moves the specified security policy.
 * <p>  Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API were used to modify firewall policies. This usage is now disabled for most organizations. Use firewallPolicies.move instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> moveAsync(MoveOrganizationSecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> moveAsync(String securityPolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> moveOperationCallable()
 *           <li><p> moveCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Patch</td>
 *      <td><p> Patches the specified policy with the data included in the request.
 * <p>  Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API were used to modify firewall policies. This usage is now disabled for most organizations. Use firewallPolicies.patch instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> patchAsync(PatchOrganizationSecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> patchAsync(String securityPolicy, SecurityPolicy securityPolicyResource)
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
 *      <td><p> Patches a rule at the specified priority.
 * <p>  Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API were used to modify firewall policies. This usage is now disabled for most organizations. Use firewallPolicies.patchRule instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> patchRuleAsync(PatchRuleOrganizationSecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> patchRuleAsync(String securityPolicy, SecurityPolicyRule securityPolicyRuleResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> patchRuleOperationCallable()
 *           <li><p> patchRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RemoveAssociation</td>
 *      <td><p> Removes an association for the specified security policy.
 * <p>  Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API were used to modify firewall policies. This usage is now disabled for most organizations. Use firewallPolicies.removeAssociation instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> removeAssociationAsync(RemoveAssociationOrganizationSecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> removeAssociationAsync(String securityPolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> removeAssociationOperationCallable()
 *           <li><p> removeAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RemoveRule</td>
 *      <td><p> Deletes a rule at the specified priority.
 * <p>  Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API were used to modify firewall policies. This usage is now disabled for most organizations. Use firewallPolicies.removeRule instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> removeRuleAsync(RemoveRuleOrganizationSecurityPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> removeRuleAsync(String securityPolicy)
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
 * <p>This class can be customized by passing in a custom instance of
 * OrganizationSecurityPoliciesSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrganizationSecurityPoliciesSettings organizationSecurityPoliciesSettings =
 *     OrganizationSecurityPoliciesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
 *     OrganizationSecurityPoliciesClient.create(organizationSecurityPoliciesSettings);
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
 * OrganizationSecurityPoliciesSettings organizationSecurityPoliciesSettings =
 *     OrganizationSecurityPoliciesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
 *     OrganizationSecurityPoliciesClient.create(organizationSecurityPoliciesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class OrganizationSecurityPoliciesClient implements BackgroundResource {
  private final OrganizationSecurityPoliciesSettings settings;
  private final OrganizationSecurityPoliciesStub stub;

  /** Constructs an instance of OrganizationSecurityPoliciesClient with default settings. */
  public static final OrganizationSecurityPoliciesClient create() throws IOException {
    return create(OrganizationSecurityPoliciesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OrganizationSecurityPoliciesClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final OrganizationSecurityPoliciesClient create(
      OrganizationSecurityPoliciesSettings settings) throws IOException {
    return new OrganizationSecurityPoliciesClient(settings);
  }

  /**
   * Constructs an instance of OrganizationSecurityPoliciesClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(OrganizationSecurityPoliciesSettings).
   */
  public static final OrganizationSecurityPoliciesClient create(
      OrganizationSecurityPoliciesStub stub) {
    return new OrganizationSecurityPoliciesClient(stub);
  }

  /**
   * Constructs an instance of OrganizationSecurityPoliciesClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected OrganizationSecurityPoliciesClient(OrganizationSecurityPoliciesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((OrganizationSecurityPoliciesStubSettings) settings.getStubSettings()).createStub();
  }

  protected OrganizationSecurityPoliciesClient(OrganizationSecurityPoliciesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final OrganizationSecurityPoliciesSettings getSettings() {
    return settings;
  }

  public OrganizationSecurityPoliciesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts an association for the specified security policy.
   *
   * <p>This has billing implications. Projects in the hierarchy with effective hierarchical
   * security policies will be automatically enrolled into Cloud Armor Enterprise if not already
   * enrolled.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.addAssociation instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   String securityPolicy = "securityPolicy-788621166";
   *   SecurityPolicyAssociation securityPolicyAssociationResource =
   *       SecurityPolicyAssociation.newBuilder().build();
   *   Operation response =
   *       organizationSecurityPoliciesClient
   *           .addAssociationAsync(securityPolicy, securityPolicyAssociationResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param securityPolicy Name of the security policy to update.
   * @param securityPolicyAssociationResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> addAssociationAsync(
      String securityPolicy, SecurityPolicyAssociation securityPolicyAssociationResource) {
    AddAssociationOrganizationSecurityPolicyRequest request =
        AddAssociationOrganizationSecurityPolicyRequest.newBuilder()
            .setSecurityPolicy(securityPolicy)
            .setSecurityPolicyAssociationResource(securityPolicyAssociationResource)
            .build();
    return addAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts an association for the specified security policy.
   *
   * <p>This has billing implications. Projects in the hierarchy with effective hierarchical
   * security policies will be automatically enrolled into Cloud Armor Enterprise if not already
   * enrolled.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.addAssociation instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   AddAssociationOrganizationSecurityPolicyRequest request =
   *       AddAssociationOrganizationSecurityPolicyRequest.newBuilder()
   *           .setReplaceExistingAssociation(true)
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyAssociationResource(SecurityPolicyAssociation.newBuilder().build())
   *           .build();
   *   Operation response = organizationSecurityPoliciesClient.addAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> addAssociationAsync(
      AddAssociationOrganizationSecurityPolicyRequest request) {
    return addAssociationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts an association for the specified security policy.
   *
   * <p>This has billing implications. Projects in the hierarchy with effective hierarchical
   * security policies will be automatically enrolled into Cloud Armor Enterprise if not already
   * enrolled.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.addAssociation instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   AddAssociationOrganizationSecurityPolicyRequest request =
   *       AddAssociationOrganizationSecurityPolicyRequest.newBuilder()
   *           .setReplaceExistingAssociation(true)
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyAssociationResource(SecurityPolicyAssociation.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       organizationSecurityPoliciesClient.addAssociationOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          AddAssociationOrganizationSecurityPolicyRequest, Operation, Operation>
      addAssociationOperationCallable() {
    return stub.addAssociationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts an association for the specified security policy.
   *
   * <p>This has billing implications. Projects in the hierarchy with effective hierarchical
   * security policies will be automatically enrolled into Cloud Armor Enterprise if not already
   * enrolled.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.addAssociation instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   AddAssociationOrganizationSecurityPolicyRequest request =
   *       AddAssociationOrganizationSecurityPolicyRequest.newBuilder()
   *           .setReplaceExistingAssociation(true)
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyAssociationResource(SecurityPolicyAssociation.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       organizationSecurityPoliciesClient.addAssociationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddAssociationOrganizationSecurityPolicyRequest, Operation>
      addAssociationCallable() {
    return stub.addAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a security policy.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.addRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   String securityPolicy = "securityPolicy-788621166";
   *   SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();
   *   Operation response =
   *       organizationSecurityPoliciesClient
   *           .addRuleAsync(securityPolicy, securityPolicyRuleResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param securityPolicy Name of the security policy to update.
   * @param securityPolicyRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> addRuleAsync(
      String securityPolicy, SecurityPolicyRule securityPolicyRuleResource) {
    AddRuleOrganizationSecurityPolicyRequest request =
        AddRuleOrganizationSecurityPolicyRequest.newBuilder()
            .setSecurityPolicy(securityPolicy)
            .setSecurityPolicyRuleResource(securityPolicyRuleResource)
            .build();
    return addRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a security policy.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.addRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   AddRuleOrganizationSecurityPolicyRequest request =
   *       AddRuleOrganizationSecurityPolicyRequest.newBuilder()
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .build();
   *   Operation response = organizationSecurityPoliciesClient.addRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> addRuleAsync(
      AddRuleOrganizationSecurityPolicyRequest request) {
    return addRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a security policy.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.addRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   AddRuleOrganizationSecurityPolicyRequest request =
   *       AddRuleOrganizationSecurityPolicyRequest.newBuilder()
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       organizationSecurityPoliciesClient.addRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AddRuleOrganizationSecurityPolicyRequest, Operation, Operation>
      addRuleOperationCallable() {
    return stub.addRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a rule into a security policy.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.addRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   AddRuleOrganizationSecurityPolicyRequest request =
   *       AddRuleOrganizationSecurityPolicyRequest.newBuilder()
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       organizationSecurityPoliciesClient.addRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddRuleOrganizationSecurityPolicyRequest, Operation>
      addRuleCallable() {
    return stub.addRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies rules to the specified security policy.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.cloneRules instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   String securityPolicy = "securityPolicy-788621166";
   *   Operation response = organizationSecurityPoliciesClient.copyRulesAsync(securityPolicy).get();
   * }
   * }</pre>
   *
   * @param securityPolicy Name of the security policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> copyRulesAsync(String securityPolicy) {
    CopyRulesOrganizationSecurityPolicyRequest request =
        CopyRulesOrganizationSecurityPolicyRequest.newBuilder()
            .setSecurityPolicy(securityPolicy)
            .build();
    return copyRulesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies rules to the specified security policy.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.cloneRules instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   CopyRulesOrganizationSecurityPolicyRequest request =
   *       CopyRulesOrganizationSecurityPolicyRequest.newBuilder()
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSourceSecurityPolicy("sourceSecurityPolicy1092878733")
   *           .build();
   *   Operation response = organizationSecurityPoliciesClient.copyRulesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> copyRulesAsync(
      CopyRulesOrganizationSecurityPolicyRequest request) {
    return copyRulesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies rules to the specified security policy.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.cloneRules instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   CopyRulesOrganizationSecurityPolicyRequest request =
   *       CopyRulesOrganizationSecurityPolicyRequest.newBuilder()
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSourceSecurityPolicy("sourceSecurityPolicy1092878733")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       organizationSecurityPoliciesClient.copyRulesOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CopyRulesOrganizationSecurityPolicyRequest, Operation, Operation>
      copyRulesOperationCallable() {
    return stub.copyRulesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Copies rules to the specified security policy.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.cloneRules instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   CopyRulesOrganizationSecurityPolicyRequest request =
   *       CopyRulesOrganizationSecurityPolicyRequest.newBuilder()
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSourceSecurityPolicy("sourceSecurityPolicy1092878733")
   *           .build();
   *   ApiFuture<Operation> future =
   *       organizationSecurityPoliciesClient.copyRulesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CopyRulesOrganizationSecurityPolicyRequest, Operation>
      copyRulesCallable() {
    return stub.copyRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified policy.
   *
   * <p>Use this API to remove Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to remove firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.delete instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   String securityPolicy = "securityPolicy-788621166";
   *   Operation response = organizationSecurityPoliciesClient.deleteAsync(securityPolicy).get();
   * }
   * }</pre>
   *
   * @param securityPolicy Name of the security policy to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(String securityPolicy) {
    DeleteOrganizationSecurityPolicyRequest request =
        DeleteOrganizationSecurityPolicyRequest.newBuilder()
            .setSecurityPolicy(securityPolicy)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified policy.
   *
   * <p>Use this API to remove Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to remove firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.delete instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   DeleteOrganizationSecurityPolicyRequest request =
   *       DeleteOrganizationSecurityPolicyRequest.newBuilder()
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   Operation response = organizationSecurityPoliciesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteOrganizationSecurityPolicyRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified policy.
   *
   * <p>Use this API to remove Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to remove firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.delete instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   DeleteOrganizationSecurityPolicyRequest request =
   *       DeleteOrganizationSecurityPolicyRequest.newBuilder()
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       organizationSecurityPoliciesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteOrganizationSecurityPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified policy.
   *
   * <p>Use this API to remove Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to remove firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.delete instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   DeleteOrganizationSecurityPolicyRequest request =
   *       DeleteOrganizationSecurityPolicyRequest.newBuilder()
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   ApiFuture<Operation> future =
   *       organizationSecurityPoliciesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteOrganizationSecurityPolicyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all of the ordered rules present in a single specified policy.
   *
   * <p>Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to read firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.get instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   String securityPolicy = "securityPolicy-788621166";
   *   SecurityPolicy response = organizationSecurityPoliciesClient.get(securityPolicy);
   * }
   * }</pre>
   *
   * @param securityPolicy Name of the security policy to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPolicy get(String securityPolicy) {
    GetOrganizationSecurityPolicyRequest request =
        GetOrganizationSecurityPolicyRequest.newBuilder().setSecurityPolicy(securityPolicy).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all of the ordered rules present in a single specified policy.
   *
   * <p>Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to read firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.get instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   GetOrganizationSecurityPolicyRequest request =
   *       GetOrganizationSecurityPolicyRequest.newBuilder()
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   SecurityPolicy response = organizationSecurityPoliciesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPolicy get(GetOrganizationSecurityPolicyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all of the ordered rules present in a single specified policy.
   *
   * <p>Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to read firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.get instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   GetOrganizationSecurityPolicyRequest request =
   *       GetOrganizationSecurityPolicyRequest.newBuilder()
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   ApiFuture<SecurityPolicy> future =
   *       organizationSecurityPoliciesClient.getCallable().futureCall(request);
   *   // Do something.
   *   SecurityPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOrganizationSecurityPolicyRequest, SecurityPolicy> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an association with the specified name.
   *
   * <p>Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to read firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.getAssociation instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   String securityPolicy = "securityPolicy-788621166";
   *   SecurityPolicyAssociation response =
   *       organizationSecurityPoliciesClient.getAssociation(securityPolicy);
   * }
   * }</pre>
   *
   * @param securityPolicy Name of the security policy to which the queried rule belongs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPolicyAssociation getAssociation(String securityPolicy) {
    GetAssociationOrganizationSecurityPolicyRequest request =
        GetAssociationOrganizationSecurityPolicyRequest.newBuilder()
            .setSecurityPolicy(securityPolicy)
            .build();
    return getAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an association with the specified name.
   *
   * <p>Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to read firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.getAssociation instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   GetAssociationOrganizationSecurityPolicyRequest request =
   *       GetAssociationOrganizationSecurityPolicyRequest.newBuilder()
   *           .setName("name3373707")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   SecurityPolicyAssociation response =
   *       organizationSecurityPoliciesClient.getAssociation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPolicyAssociation getAssociation(
      GetAssociationOrganizationSecurityPolicyRequest request) {
    return getAssociationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an association with the specified name.
   *
   * <p>Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to read firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.getAssociation instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   GetAssociationOrganizationSecurityPolicyRequest request =
   *       GetAssociationOrganizationSecurityPolicyRequest.newBuilder()
   *           .setName("name3373707")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   ApiFuture<SecurityPolicyAssociation> future =
   *       organizationSecurityPoliciesClient.getAssociationCallable().futureCall(request);
   *   // Do something.
   *   SecurityPolicyAssociation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetAssociationOrganizationSecurityPolicyRequest, SecurityPolicyAssociation>
      getAssociationCallable() {
    return stub.getAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a rule at the specified priority.
   *
   * <p>Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to read firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.getRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   String securityPolicy = "securityPolicy-788621166";
   *   SecurityPolicyRule response = organizationSecurityPoliciesClient.getRule(securityPolicy);
   * }
   * }</pre>
   *
   * @param securityPolicy Name of the security policy to which the queried rule belongs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPolicyRule getRule(String securityPolicy) {
    GetRuleOrganizationSecurityPolicyRequest request =
        GetRuleOrganizationSecurityPolicyRequest.newBuilder()
            .setSecurityPolicy(securityPolicy)
            .build();
    return getRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a rule at the specified priority.
   *
   * <p>Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to read firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.getRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   GetRuleOrganizationSecurityPolicyRequest request =
   *       GetRuleOrganizationSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   SecurityPolicyRule response = organizationSecurityPoliciesClient.getRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPolicyRule getRule(GetRuleOrganizationSecurityPolicyRequest request) {
    return getRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a rule at the specified priority.
   *
   * <p>Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to read firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.getRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   GetRuleOrganizationSecurityPolicyRequest request =
   *       GetRuleOrganizationSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   ApiFuture<SecurityPolicyRule> future =
   *       organizationSecurityPoliciesClient.getRuleCallable().futureCall(request);
   *   // Do something.
   *   SecurityPolicyRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRuleOrganizationSecurityPolicyRequest, SecurityPolicyRule>
      getRuleCallable() {
    return stub.getRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new policy in the specified organization using the data included in the request.
   *
   * <p>Use this API to add Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to add firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.insert instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   SecurityPolicy securityPolicyResource = SecurityPolicy.newBuilder().build();
   *   Operation response =
   *       organizationSecurityPoliciesClient.insertAsync(securityPolicyResource).get();
   * }
   * }</pre>
   *
   * @param securityPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      SecurityPolicy securityPolicyResource) {
    InsertOrganizationSecurityPolicyRequest request =
        InsertOrganizationSecurityPolicyRequest.newBuilder()
            .setSecurityPolicyResource(securityPolicyResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new policy in the specified organization using the data included in the request.
   *
   * <p>Use this API to add Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to add firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.insert instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   InsertOrganizationSecurityPolicyRequest request =
   *       InsertOrganizationSecurityPolicyRequest.newBuilder()
   *           .setParentId("parentId1175162725")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .build();
   *   Operation response = organizationSecurityPoliciesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertOrganizationSecurityPolicyRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new policy in the specified organization using the data included in the request.
   *
   * <p>Use this API to add Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to add firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.insert instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   InsertOrganizationSecurityPolicyRequest request =
   *       InsertOrganizationSecurityPolicyRequest.newBuilder()
   *           .setParentId("parentId1175162725")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       organizationSecurityPoliciesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertOrganizationSecurityPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new policy in the specified organization using the data included in the request.
   *
   * <p>Use this API to add Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to add firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.insert instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   InsertOrganizationSecurityPolicyRequest request =
   *       InsertOrganizationSecurityPolicyRequest.newBuilder()
   *           .setParentId("parentId1175162725")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       organizationSecurityPoliciesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertOrganizationSecurityPolicyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the policies that have been configured for the specified organization.
   *
   * <p>Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to read firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.list instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   for (SecurityPolicy element : organizationSecurityPoliciesClient.list().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list() {
    ListOrganizationSecurityPoliciesRequest request =
        ListOrganizationSecurityPoliciesRequest.newBuilder().build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the policies that have been configured for the specified organization.
   *
   * <p>Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to read firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.list instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   ListOrganizationSecurityPoliciesRequest request =
   *       ListOrganizationSecurityPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setParentId("parentId1175162725")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (SecurityPolicy element : organizationSecurityPoliciesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListOrganizationSecurityPoliciesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the policies that have been configured for the specified organization.
   *
   * <p>Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to read firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.list instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   ListOrganizationSecurityPoliciesRequest request =
   *       ListOrganizationSecurityPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setParentId("parentId1175162725")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<SecurityPolicy> future =
   *       organizationSecurityPoliciesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SecurityPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOrganizationSecurityPoliciesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the policies that have been configured for the specified organization.
   *
   * <p>Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to read firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.list instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   ListOrganizationSecurityPoliciesRequest request =
   *       ListOrganizationSecurityPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setParentId("parentId1175162725")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     SecurityPolicyList response =
   *         organizationSecurityPoliciesClient.listCallable().call(request);
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
  public final UnaryCallable<ListOrganizationSecurityPoliciesRequest, SecurityPolicyList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists associations of a specified target, i.e., organization or folder.
   *
   * <p>Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to read firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.listAssociations instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   OrganizationSecurityPoliciesListAssociationsResponse response =
   *       organizationSecurityPoliciesClient.listAssociations();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrganizationSecurityPoliciesListAssociationsResponse listAssociations() {
    ListAssociationsOrganizationSecurityPolicyRequest request =
        ListAssociationsOrganizationSecurityPolicyRequest.newBuilder().build();
    return listAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists associations of a specified target, i.e., organization or folder.
   *
   * <p>Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to read firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.listAssociations instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   ListAssociationsOrganizationSecurityPolicyRequest request =
   *       ListAssociationsOrganizationSecurityPolicyRequest.newBuilder()
   *           .setTargetResource("targetResource-1933150017")
   *           .build();
   *   OrganizationSecurityPoliciesListAssociationsResponse response =
   *       organizationSecurityPoliciesClient.listAssociations(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrganizationSecurityPoliciesListAssociationsResponse listAssociations(
      ListAssociationsOrganizationSecurityPolicyRequest request) {
    return listAssociationsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists associations of a specified target, i.e., organization or folder.
   *
   * <p>Use this API to read Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to read firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.listAssociations instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   ListAssociationsOrganizationSecurityPolicyRequest request =
   *       ListAssociationsOrganizationSecurityPolicyRequest.newBuilder()
   *           .setTargetResource("targetResource-1933150017")
   *           .build();
   *   ApiFuture<OrganizationSecurityPoliciesListAssociationsResponse> future =
   *       organizationSecurityPoliciesClient.listAssociationsCallable().futureCall(request);
   *   // Do something.
   *   OrganizationSecurityPoliciesListAssociationsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListAssociationsOrganizationSecurityPolicyRequest,
          OrganizationSecurityPoliciesListAssociationsResponse>
      listAssociationsCallable() {
    return stub.listAssociationsCallable();
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
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   SecurityPoliciesListPreconfiguredExpressionSetsResponse response =
   *       organizationSecurityPoliciesClient.listPreconfiguredExpressionSets();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPoliciesListPreconfiguredExpressionSetsResponse
      listPreconfiguredExpressionSets() {
    ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest request =
        ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest.newBuilder().build();
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
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest request =
   *       ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setParentId("parentId1175162725")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   SecurityPoliciesListPreconfiguredExpressionSetsResponse response =
   *       organizationSecurityPoliciesClient.listPreconfiguredExpressionSets(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityPoliciesListPreconfiguredExpressionSetsResponse
      listPreconfiguredExpressionSets(
          ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest request) {
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
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest request =
   *       ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setParentId("parentId1175162725")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<SecurityPoliciesListPreconfiguredExpressionSetsResponse> future =
   *       organizationSecurityPoliciesClient
   *           .listPreconfiguredExpressionSetsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SecurityPoliciesListPreconfiguredExpressionSetsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest,
          SecurityPoliciesListPreconfiguredExpressionSetsResponse>
      listPreconfiguredExpressionSetsCallable() {
    return stub.listPreconfiguredExpressionSetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves the specified security policy.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.move instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   String securityPolicy = "securityPolicy-788621166";
   *   Operation response = organizationSecurityPoliciesClient.moveAsync(securityPolicy).get();
   * }
   * }</pre>
   *
   * @param securityPolicy Name of the security policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> moveAsync(String securityPolicy) {
    MoveOrganizationSecurityPolicyRequest request =
        MoveOrganizationSecurityPolicyRequest.newBuilder()
            .setSecurityPolicy(securityPolicy)
            .build();
    return moveAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves the specified security policy.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.move instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   MoveOrganizationSecurityPolicyRequest request =
   *       MoveOrganizationSecurityPolicyRequest.newBuilder()
   *           .setParentId("parentId1175162725")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   Operation response = organizationSecurityPoliciesClient.moveAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> moveAsync(
      MoveOrganizationSecurityPolicyRequest request) {
    return moveOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves the specified security policy.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.move instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   MoveOrganizationSecurityPolicyRequest request =
   *       MoveOrganizationSecurityPolicyRequest.newBuilder()
   *           .setParentId("parentId1175162725")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       organizationSecurityPoliciesClient.moveOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<MoveOrganizationSecurityPolicyRequest, Operation, Operation>
      moveOperationCallable() {
    return stub.moveOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves the specified security policy.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.move instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   MoveOrganizationSecurityPolicyRequest request =
   *       MoveOrganizationSecurityPolicyRequest.newBuilder()
   *           .setParentId("parentId1175162725")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   ApiFuture<Operation> future =
   *       organizationSecurityPoliciesClient.moveCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MoveOrganizationSecurityPolicyRequest, Operation> moveCallable() {
    return stub.moveCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.patch instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   String securityPolicy = "securityPolicy-788621166";
   *   SecurityPolicy securityPolicyResource = SecurityPolicy.newBuilder().build();
   *   Operation response =
   *       organizationSecurityPoliciesClient
   *           .patchAsync(securityPolicy, securityPolicyResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param securityPolicy Name of the security policy to update.
   * @param securityPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String securityPolicy, SecurityPolicy securityPolicyResource) {
    PatchOrganizationSecurityPolicyRequest request =
        PatchOrganizationSecurityPolicyRequest.newBuilder()
            .setSecurityPolicy(securityPolicy)
            .setSecurityPolicyResource(securityPolicyResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.patch instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   PatchOrganizationSecurityPolicyRequest request =
   *       PatchOrganizationSecurityPolicyRequest.newBuilder()
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .build();
   *   Operation response = organizationSecurityPoliciesClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      PatchOrganizationSecurityPolicyRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.patch instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   PatchOrganizationSecurityPolicyRequest request =
   *       PatchOrganizationSecurityPolicyRequest.newBuilder()
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       organizationSecurityPoliciesClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchOrganizationSecurityPolicyRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified policy with the data included in the request.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.patch instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   PatchOrganizationSecurityPolicyRequest request =
   *       PatchOrganizationSecurityPolicyRequest.newBuilder()
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyResource(SecurityPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       organizationSecurityPoliciesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchOrganizationSecurityPolicyRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule at the specified priority.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.patchRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   String securityPolicy = "securityPolicy-788621166";
   *   SecurityPolicyRule securityPolicyRuleResource = SecurityPolicyRule.newBuilder().build();
   *   Operation response =
   *       organizationSecurityPoliciesClient
   *           .patchRuleAsync(securityPolicy, securityPolicyRuleResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param securityPolicy Name of the security policy to update.
   * @param securityPolicyRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchRuleAsync(
      String securityPolicy, SecurityPolicyRule securityPolicyRuleResource) {
    PatchRuleOrganizationSecurityPolicyRequest request =
        PatchRuleOrganizationSecurityPolicyRequest.newBuilder()
            .setSecurityPolicy(securityPolicy)
            .setSecurityPolicyRuleResource(securityPolicyRuleResource)
            .build();
    return patchRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule at the specified priority.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.patchRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   PatchRuleOrganizationSecurityPolicyRequest request =
   *       PatchRuleOrganizationSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .build();
   *   Operation response = organizationSecurityPoliciesClient.patchRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchRuleAsync(
      PatchRuleOrganizationSecurityPolicyRequest request) {
    return patchRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule at the specified priority.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.patchRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   PatchRuleOrganizationSecurityPolicyRequest request =
   *       PatchRuleOrganizationSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       organizationSecurityPoliciesClient.patchRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchRuleOrganizationSecurityPolicyRequest, Operation, Operation>
      patchRuleOperationCallable() {
    return stub.patchRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches a rule at the specified priority.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.patchRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   PatchRuleOrganizationSecurityPolicyRequest request =
   *       PatchRuleOrganizationSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .setSecurityPolicyRuleResource(SecurityPolicyRule.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       organizationSecurityPoliciesClient.patchRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchRuleOrganizationSecurityPolicyRequest, Operation>
      patchRuleCallable() {
    return stub.patchRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an association for the specified security policy.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.removeAssociation instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   String securityPolicy = "securityPolicy-788621166";
   *   Operation response =
   *       organizationSecurityPoliciesClient.removeAssociationAsync(securityPolicy).get();
   * }
   * }</pre>
   *
   * @param securityPolicy Name of the security policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> removeAssociationAsync(String securityPolicy) {
    RemoveAssociationOrganizationSecurityPolicyRequest request =
        RemoveAssociationOrganizationSecurityPolicyRequest.newBuilder()
            .setSecurityPolicy(securityPolicy)
            .build();
    return removeAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an association for the specified security policy.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.removeAssociation instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   RemoveAssociationOrganizationSecurityPolicyRequest request =
   *       RemoveAssociationOrganizationSecurityPolicyRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   Operation response = organizationSecurityPoliciesClient.removeAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> removeAssociationAsync(
      RemoveAssociationOrganizationSecurityPolicyRequest request) {
    return removeAssociationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an association for the specified security policy.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.removeAssociation instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   RemoveAssociationOrganizationSecurityPolicyRequest request =
   *       RemoveAssociationOrganizationSecurityPolicyRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       organizationSecurityPoliciesClient
   *           .removeAssociationOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RemoveAssociationOrganizationSecurityPolicyRequest, Operation, Operation>
      removeAssociationOperationCallable() {
    return stub.removeAssociationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an association for the specified security policy.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.removeAssociation instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   RemoveAssociationOrganizationSecurityPolicyRequest request =
   *       RemoveAssociationOrganizationSecurityPolicyRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   ApiFuture<Operation> future =
   *       organizationSecurityPoliciesClient.removeAssociationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveAssociationOrganizationSecurityPolicyRequest, Operation>
      removeAssociationCallable() {
    return stub.removeAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule at the specified priority.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.removeRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   String securityPolicy = "securityPolicy-788621166";
   *   Operation response = organizationSecurityPoliciesClient.removeRuleAsync(securityPolicy).get();
   * }
   * }</pre>
   *
   * @param securityPolicy Name of the security policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> removeRuleAsync(String securityPolicy) {
    RemoveRuleOrganizationSecurityPolicyRequest request =
        RemoveRuleOrganizationSecurityPolicyRequest.newBuilder()
            .setSecurityPolicy(securityPolicy)
            .build();
    return removeRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule at the specified priority.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.removeRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   RemoveRuleOrganizationSecurityPolicyRequest request =
   *       RemoveRuleOrganizationSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   Operation response = organizationSecurityPoliciesClient.removeRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> removeRuleAsync(
      RemoveRuleOrganizationSecurityPolicyRequest request) {
    return removeRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule at the specified priority.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.removeRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   RemoveRuleOrganizationSecurityPolicyRequest request =
   *       RemoveRuleOrganizationSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       organizationSecurityPoliciesClient.removeRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RemoveRuleOrganizationSecurityPolicyRequest, Operation, Operation>
      removeRuleOperationCallable() {
    return stub.removeRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a rule at the specified priority.
   *
   * <p>Use this API to modify Cloud Armor policies. Previously, alpha and beta versions of this API
   * were used to modify firewall policies. This usage is now disabled for most organizations. Use
   * firewallPolicies.removeRule instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationSecurityPoliciesClient organizationSecurityPoliciesClient =
   *     OrganizationSecurityPoliciesClient.create()) {
   *   RemoveRuleOrganizationSecurityPolicyRequest request =
   *       RemoveRuleOrganizationSecurityPolicyRequest.newBuilder()
   *           .setPriority(-1165461084)
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicy("securityPolicy-788621166")
   *           .build();
   *   ApiFuture<Operation> future =
   *       organizationSecurityPoliciesClient.removeRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveRuleOrganizationSecurityPolicyRequest, Operation>
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
          ListOrganizationSecurityPoliciesRequest,
          SecurityPolicyList,
          SecurityPolicy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListOrganizationSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy>
            context,
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
          ListOrganizationSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy, ListPage> {

    private ListPage(
        PageContext<ListOrganizationSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy>
            context,
        SecurityPolicyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListOrganizationSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy>
            context,
        SecurityPolicyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListOrganizationSecurityPoliciesRequest, SecurityPolicyList, SecurityPolicy>
            context,
        ApiFuture<SecurityPolicyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOrganizationSecurityPoliciesRequest,
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
