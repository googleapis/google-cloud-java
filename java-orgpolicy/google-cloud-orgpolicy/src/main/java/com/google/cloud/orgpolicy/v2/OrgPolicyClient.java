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

package com.google.cloud.orgpolicy.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.orgpolicy.v2.stub.OrgPolicyStub;
import com.google.cloud.orgpolicy.v2.stub.OrgPolicyStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: An interface for managing organization policies.
 *
 * <p>The Organization Policy Service provides a simple mechanism for organizations to restrict the
 * allowed configurations across their entire resource hierarchy.
 *
 * <p>You can use a policy to configure restrictions on resources. For example, you can enforce a
 * policy that restricts which Google Cloud APIs can be activated in a certain part of your resource
 * hierarchy, or prevents serial port access to VM instances in a particular folder.
 *
 * <p>Policies are inherited down through the resource hierarchy. A policy applied to a parent
 * resource automatically applies to all its child resources unless overridden with a policy lower
 * in the hierarchy.
 *
 * <p>A constraint defines an aspect of a resource's configuration that can be controlled by an
 * organization's policy administrator. Policies are a collection of constraints that defines their
 * allowable configuration on a particular resource and its child resources.
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
 * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
 *   PolicyName name = PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]");
 *   Policy response = orgPolicyClient.getPolicy(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the OrgPolicyClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListConstraints</td>
 *      <td><p> Lists constraints that could be applied on the specified resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listConstraints(ListConstraintsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listConstraints(FolderName parent)
 *           <li><p> listConstraints(OrganizationName parent)
 *           <li><p> listConstraints(ProjectName parent)
 *           <li><p> listConstraints(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listConstraintsPagedCallable()
 *           <li><p> listConstraintsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPolicies</td>
 *      <td><p> Retrieves all of the policies that exist on a particular resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPolicies(ListPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPolicies(FolderName parent)
 *           <li><p> listPolicies(OrganizationName parent)
 *           <li><p> listPolicies(ProjectName parent)
 *           <li><p> listPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPoliciesPagedCallable()
 *           <li><p> listPoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPolicy</td>
 *      <td><p> Gets a policy on a resource.
 * <p>  If no policy is set on the resource, `NOT_FOUND` is returned. The `etag` value can be used with `UpdatePolicy()` to update a policy during read-modify-write.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPolicy(GetPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPolicy(PolicyName name)
 *           <li><p> getPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEffectivePolicy</td>
 *      <td><p> Gets the effective policy on a resource. This is the result of merging policies in the resource hierarchy and evaluating conditions. The returned policy will not have an `etag` or `condition` set because it is an evaluated policy across multiple resources. Subtrees of Resource Manager resource hierarchy with 'under:' prefix will not be expanded.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEffectivePolicy(GetEffectivePolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEffectivePolicy(PolicyName name)
 *           <li><p> getEffectivePolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEffectivePolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePolicy</td>
 *      <td><p> Creates a policy.
 * <p>  Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy already exists on the given Google Cloud resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPolicy(CreatePolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createPolicy(FolderName parent, Policy policy)
 *           <li><p> createPolicy(OrganizationName parent, Policy policy)
 *           <li><p> createPolicy(ProjectName parent, Policy policy)
 *           <li><p> createPolicy(String parent, Policy policy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePolicy</td>
 *      <td><p> Updates a policy.
 * <p>  Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or the policy do not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag supplied in the request does not match the persisted etag of the policy
 * <p>  Note: the supplied policy will perform a full overwrite of all fields.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePolicy(UpdatePolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updatePolicy(Policy policy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePolicy</td>
 *      <td><p> Deletes a policy.
 * <p>  Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or organization policy does not exist.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePolicy(DeletePolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deletePolicy(PolicyName name)
 *           <li><p> deletePolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCustomConstraint</td>
 *      <td><p> Creates a custom constraint.
 * <p>  Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the organization does not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the constraint already exists on the given organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCustomConstraint(CreateCustomConstraintRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createCustomConstraint(OrganizationName parent, CustomConstraint customConstraint)
 *           <li><p> createCustomConstraint(String parent, CustomConstraint customConstraint)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCustomConstraintCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCustomConstraint</td>
 *      <td><p> Updates a custom constraint.
 * <p>  Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not exist.
 * <p>  Note: the supplied policy will perform a full overwrite of all fields.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCustomConstraint(UpdateCustomConstraintRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCustomConstraint(CustomConstraint customConstraint)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCustomConstraintCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCustomConstraint</td>
 *      <td><p> Gets a custom constraint.
 * <p>  Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the custom constraint does not exist.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCustomConstraint(GetCustomConstraintRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCustomConstraint(CustomConstraintName name)
 *           <li><p> getCustomConstraint(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCustomConstraintCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCustomConstraints</td>
 *      <td><p> Retrieves all of the custom constraints that exist on a particular organization resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCustomConstraints(ListCustomConstraintsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCustomConstraints(OrganizationName parent)
 *           <li><p> listCustomConstraints(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCustomConstraintsPagedCallable()
 *           <li><p> listCustomConstraintsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCustomConstraint</td>
 *      <td><p> Deletes a custom constraint.
 * <p>  Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not exist.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCustomConstraint(DeleteCustomConstraintRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteCustomConstraint(CustomConstraintName name)
 *           <li><p> deleteCustomConstraint(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCustomConstraintCallable()
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
 * <p>This class can be customized by passing in a custom instance of OrgPolicySettings to create().
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
 * OrgPolicySettings orgPolicySettings =
 *     OrgPolicySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OrgPolicyClient orgPolicyClient = OrgPolicyClient.create(orgPolicySettings);
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
 * OrgPolicySettings orgPolicySettings =
 *     OrgPolicySettings.newBuilder().setEndpoint(myEndpoint).build();
 * OrgPolicyClient orgPolicyClient = OrgPolicyClient.create(orgPolicySettings);
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
 * OrgPolicySettings orgPolicySettings = OrgPolicySettings.newHttpJsonBuilder().build();
 * OrgPolicyClient orgPolicyClient = OrgPolicyClient.create(orgPolicySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class OrgPolicyClient implements BackgroundResource {
  private final OrgPolicySettings settings;
  private final OrgPolicyStub stub;

  /** Constructs an instance of OrgPolicyClient with default settings. */
  public static final OrgPolicyClient create() throws IOException {
    return create(OrgPolicySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OrgPolicyClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final OrgPolicyClient create(OrgPolicySettings settings) throws IOException {
    return new OrgPolicyClient(settings);
  }

  /**
   * Constructs an instance of OrgPolicyClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(OrgPolicySettings).
   */
  public static final OrgPolicyClient create(OrgPolicyStub stub) {
    return new OrgPolicyClient(stub);
  }

  /**
   * Constructs an instance of OrgPolicyClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected OrgPolicyClient(OrgPolicySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((OrgPolicyStubSettings) settings.getStubSettings()).createStub();
  }

  protected OrgPolicyClient(OrgPolicyStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final OrgPolicySettings getSettings() {
    return settings;
  }

  public OrgPolicyStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists constraints that could be applied on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   for (Constraint element : orgPolicyClient.listConstraints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Google Cloud resource that parents the constraint. Must be in one
   *     of the following forms:
   *     <ul>
   *       <li>`projects/{project_number}`
   *       <li>`projects/{project_id}`
   *       <li>`folders/{folder_id}`
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConstraintsPagedResponse listConstraints(FolderName parent) {
    ListConstraintsRequest request =
        ListConstraintsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConstraints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists constraints that could be applied on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (Constraint element : orgPolicyClient.listConstraints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Google Cloud resource that parents the constraint. Must be in one
   *     of the following forms:
   *     <ul>
   *       <li>`projects/{project_number}`
   *       <li>`projects/{project_id}`
   *       <li>`folders/{folder_id}`
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConstraintsPagedResponse listConstraints(OrganizationName parent) {
    ListConstraintsRequest request =
        ListConstraintsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConstraints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists constraints that could be applied on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Constraint element : orgPolicyClient.listConstraints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Google Cloud resource that parents the constraint. Must be in one
   *     of the following forms:
   *     <ul>
   *       <li>`projects/{project_number}`
   *       <li>`projects/{project_id}`
   *       <li>`folders/{folder_id}`
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConstraintsPagedResponse listConstraints(ProjectName parent) {
    ListConstraintsRequest request =
        ListConstraintsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConstraints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists constraints that could be applied on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (Constraint element : orgPolicyClient.listConstraints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Google Cloud resource that parents the constraint. Must be in one
   *     of the following forms:
   *     <ul>
   *       <li>`projects/{project_number}`
   *       <li>`projects/{project_id}`
   *       <li>`folders/{folder_id}`
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConstraintsPagedResponse listConstraints(String parent) {
    ListConstraintsRequest request = ListConstraintsRequest.newBuilder().setParent(parent).build();
    return listConstraints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists constraints that could be applied on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   ListConstraintsRequest request =
   *       ListConstraintsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Constraint element : orgPolicyClient.listConstraints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConstraintsPagedResponse listConstraints(ListConstraintsRequest request) {
    return listConstraintsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists constraints that could be applied on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   ListConstraintsRequest request =
   *       ListConstraintsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Constraint> future =
   *       orgPolicyClient.listConstraintsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Constraint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConstraintsRequest, ListConstraintsPagedResponse>
      listConstraintsPagedCallable() {
    return stub.listConstraintsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists constraints that could be applied on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   ListConstraintsRequest request =
   *       ListConstraintsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListConstraintsResponse response = orgPolicyClient.listConstraintsCallable().call(request);
   *     for (Constraint element : response.getConstraintsList()) {
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
  public final UnaryCallable<ListConstraintsRequest, ListConstraintsResponse>
      listConstraintsCallable() {
    return stub.listConstraintsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves all of the policies that exist on a particular resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   for (Policy element : orgPolicyClient.listPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The target Google Cloud resource that parents the set of constraints
   *     and policies that will be returned from this call. Must be in one of the following forms:
   *     <ul>
   *       <li>`projects/{project_number}`
   *       <li>`projects/{project_id}`
   *       <li>`folders/{folder_id}`
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPoliciesPagedResponse listPolicies(FolderName parent) {
    ListPoliciesRequest request =
        ListPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves all of the policies that exist on a particular resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (Policy element : orgPolicyClient.listPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The target Google Cloud resource that parents the set of constraints
   *     and policies that will be returned from this call. Must be in one of the following forms:
   *     <ul>
   *       <li>`projects/{project_number}`
   *       <li>`projects/{project_id}`
   *       <li>`folders/{folder_id}`
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPoliciesPagedResponse listPolicies(OrganizationName parent) {
    ListPoliciesRequest request =
        ListPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves all of the policies that exist on a particular resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Policy element : orgPolicyClient.listPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The target Google Cloud resource that parents the set of constraints
   *     and policies that will be returned from this call. Must be in one of the following forms:
   *     <ul>
   *       <li>`projects/{project_number}`
   *       <li>`projects/{project_id}`
   *       <li>`folders/{folder_id}`
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPoliciesPagedResponse listPolicies(ProjectName parent) {
    ListPoliciesRequest request =
        ListPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves all of the policies that exist on a particular resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (Policy element : orgPolicyClient.listPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The target Google Cloud resource that parents the set of constraints
   *     and policies that will be returned from this call. Must be in one of the following forms:
   *     <ul>
   *       <li>`projects/{project_number}`
   *       <li>`projects/{project_id}`
   *       <li>`folders/{folder_id}`
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPoliciesPagedResponse listPolicies(String parent) {
    ListPoliciesRequest request = ListPoliciesRequest.newBuilder().setParent(parent).build();
    return listPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves all of the policies that exist on a particular resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   ListPoliciesRequest request =
   *       ListPoliciesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Policy element : orgPolicyClient.listPolicies(request).iterateAll()) {
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
   * Retrieves all of the policies that exist on a particular resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   ListPoliciesRequest request =
   *       ListPoliciesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Policy> future = orgPolicyClient.listPoliciesPagedCallable().futureCall(request);
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
   * Retrieves all of the policies that exist on a particular resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   ListPoliciesRequest request =
   *       ListPoliciesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPoliciesResponse response = orgPolicyClient.listPoliciesCallable().call(request);
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
   * Gets a policy on a resource.
   *
   * <p>If no policy is set on the resource, `NOT_FOUND` is returned. The `etag` value can be used
   * with `UpdatePolicy()` to update a policy during read-modify-write.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   PolicyName name = PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]");
   *   Policy response = orgPolicyClient.getPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the policy. See
   *     [Policy][google.cloud.orgpolicy.v2.Policy] for naming requirements.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getPolicy(PolicyName name) {
    GetPolicyRequest request =
        GetPolicyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a policy on a resource.
   *
   * <p>If no policy is set on the resource, `NOT_FOUND` is returned. The `etag` value can be used
   * with `UpdatePolicy()` to update a policy during read-modify-write.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   String name = PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString();
   *   Policy response = orgPolicyClient.getPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the policy. See
   *     [Policy][google.cloud.orgpolicy.v2.Policy] for naming requirements.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getPolicy(String name) {
    GetPolicyRequest request = GetPolicyRequest.newBuilder().setName(name).build();
    return getPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a policy on a resource.
   *
   * <p>If no policy is set on the resource, `NOT_FOUND` is returned. The `etag` value can be used
   * with `UpdatePolicy()` to update a policy during read-modify-write.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   GetPolicyRequest request =
   *       GetPolicyRequest.newBuilder()
   *           .setName(PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString())
   *           .build();
   *   Policy response = orgPolicyClient.getPolicy(request);
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
   * Gets a policy on a resource.
   *
   * <p>If no policy is set on the resource, `NOT_FOUND` is returned. The `etag` value can be used
   * with `UpdatePolicy()` to update a policy during read-modify-write.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   GetPolicyRequest request =
   *       GetPolicyRequest.newBuilder()
   *           .setName(PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString())
   *           .build();
   *   ApiFuture<Policy> future = orgPolicyClient.getPolicyCallable().futureCall(request);
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
   * Gets the effective policy on a resource. This is the result of merging policies in the resource
   * hierarchy and evaluating conditions. The returned policy will not have an `etag` or `condition`
   * set because it is an evaluated policy across multiple resources. Subtrees of Resource Manager
   * resource hierarchy with 'under:' prefix will not be expanded.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   PolicyName name = PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]");
   *   Policy response = orgPolicyClient.getEffectivePolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The effective policy to compute. See
   *     [Policy][google.cloud.orgpolicy.v2.Policy] for naming requirements.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getEffectivePolicy(PolicyName name) {
    GetEffectivePolicyRequest request =
        GetEffectivePolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEffectivePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the effective policy on a resource. This is the result of merging policies in the resource
   * hierarchy and evaluating conditions. The returned policy will not have an `etag` or `condition`
   * set because it is an evaluated policy across multiple resources. Subtrees of Resource Manager
   * resource hierarchy with 'under:' prefix will not be expanded.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   String name = PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString();
   *   Policy response = orgPolicyClient.getEffectivePolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The effective policy to compute. See
   *     [Policy][google.cloud.orgpolicy.v2.Policy] for naming requirements.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getEffectivePolicy(String name) {
    GetEffectivePolicyRequest request =
        GetEffectivePolicyRequest.newBuilder().setName(name).build();
    return getEffectivePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the effective policy on a resource. This is the result of merging policies in the resource
   * hierarchy and evaluating conditions. The returned policy will not have an `etag` or `condition`
   * set because it is an evaluated policy across multiple resources. Subtrees of Resource Manager
   * resource hierarchy with 'under:' prefix will not be expanded.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   GetEffectivePolicyRequest request =
   *       GetEffectivePolicyRequest.newBuilder()
   *           .setName(PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString())
   *           .build();
   *   Policy response = orgPolicyClient.getEffectivePolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getEffectivePolicy(GetEffectivePolicyRequest request) {
    return getEffectivePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the effective policy on a resource. This is the result of merging policies in the resource
   * hierarchy and evaluating conditions. The returned policy will not have an `etag` or `condition`
   * set because it is an evaluated policy across multiple resources. Subtrees of Resource Manager
   * resource hierarchy with 'under:' prefix will not be expanded.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   GetEffectivePolicyRequest request =
   *       GetEffectivePolicyRequest.newBuilder()
   *           .setName(PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString())
   *           .build();
   *   ApiFuture<Policy> future = orgPolicyClient.getEffectivePolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEffectivePolicyRequest, Policy> getEffectivePolicyCallable() {
    return stub.getEffectivePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy
   * already exists on the given Google Cloud resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = orgPolicyClient.createPolicy(parent, policy);
   * }
   * }</pre>
   *
   * @param parent Required. The Google Cloud resource that will parent the new policy. Must be in
   *     one of the following forms:
   *     <ul>
   *       <li>`projects/{project_number}`
   *       <li>`projects/{project_id}`
   *       <li>`folders/{folder_id}`
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @param policy Required. Policy to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy createPolicy(FolderName parent, Policy policy) {
    CreatePolicyRequest request =
        CreatePolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPolicy(policy)
            .build();
    return createPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy
   * already exists on the given Google Cloud resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = orgPolicyClient.createPolicy(parent, policy);
   * }
   * }</pre>
   *
   * @param parent Required. The Google Cloud resource that will parent the new policy. Must be in
   *     one of the following forms:
   *     <ul>
   *       <li>`projects/{project_number}`
   *       <li>`projects/{project_id}`
   *       <li>`folders/{folder_id}`
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @param policy Required. Policy to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy createPolicy(OrganizationName parent, Policy policy) {
    CreatePolicyRequest request =
        CreatePolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPolicy(policy)
            .build();
    return createPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy
   * already exists on the given Google Cloud resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = orgPolicyClient.createPolicy(parent, policy);
   * }
   * }</pre>
   *
   * @param parent Required. The Google Cloud resource that will parent the new policy. Must be in
   *     one of the following forms:
   *     <ul>
   *       <li>`projects/{project_number}`
   *       <li>`projects/{project_id}`
   *       <li>`folders/{folder_id}`
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @param policy Required. Policy to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy createPolicy(ProjectName parent, Policy policy) {
    CreatePolicyRequest request =
        CreatePolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPolicy(policy)
            .build();
    return createPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy
   * already exists on the given Google Cloud resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = orgPolicyClient.createPolicy(parent, policy);
   * }
   * }</pre>
   *
   * @param parent Required. The Google Cloud resource that will parent the new policy. Must be in
   *     one of the following forms:
   *     <ul>
   *       <li>`projects/{project_number}`
   *       <li>`projects/{project_id}`
   *       <li>`folders/{folder_id}`
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @param policy Required. Policy to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy createPolicy(String parent, Policy policy) {
    CreatePolicyRequest request =
        CreatePolicyRequest.newBuilder().setParent(parent).setPolicy(policy).build();
    return createPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy
   * already exists on the given Google Cloud resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   CreatePolicyRequest request =
   *       CreatePolicyRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .build();
   *   Policy response = orgPolicyClient.createPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy createPolicy(CreatePolicyRequest request) {
    return createPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy
   * already exists on the given Google Cloud resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   CreatePolicyRequest request =
   *       CreatePolicyRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = orgPolicyClient.createPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePolicyRequest, Policy> createPolicyCallable() {
    return stub.createPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or the
   * policy do not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag
   * supplied in the request does not match the persisted etag of the policy
   *
   * <p>Note: the supplied policy will perform a full overwrite of all fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = orgPolicyClient.updatePolicy(policy);
   * }
   * }</pre>
   *
   * @param policy Required. Policy to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy updatePolicy(Policy policy) {
    UpdatePolicyRequest request = UpdatePolicyRequest.newBuilder().setPolicy(policy).build();
    return updatePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or the
   * policy do not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag
   * supplied in the request does not match the persisted etag of the policy
   *
   * <p>Note: the supplied policy will perform a full overwrite of all fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   UpdatePolicyRequest request =
   *       UpdatePolicyRequest.newBuilder()
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = orgPolicyClient.updatePolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy updatePolicy(UpdatePolicyRequest request) {
    return updatePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or the
   * policy do not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag
   * supplied in the request does not match the persisted etag of the policy
   *
   * <p>Note: the supplied policy will perform a full overwrite of all fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   UpdatePolicyRequest request =
   *       UpdatePolicyRequest.newBuilder()
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = orgPolicyClient.updatePolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePolicyRequest, Policy> updatePolicyCallable() {
    return stub.updatePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or
   * organization policy does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   PolicyName name = PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]");
   *   orgPolicyClient.deletePolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the policy to delete. See the policy entry for naming rules.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePolicy(PolicyName name) {
    DeletePolicyRequest request =
        DeletePolicyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deletePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or
   * organization policy does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   String name = PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString();
   *   orgPolicyClient.deletePolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the policy to delete. See the policy entry for naming rules.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePolicy(String name) {
    DeletePolicyRequest request = DeletePolicyRequest.newBuilder().setName(name).build();
    deletePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or
   * organization policy does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   DeletePolicyRequest request =
   *       DeletePolicyRequest.newBuilder()
   *           .setName(PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   orgPolicyClient.deletePolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePolicy(DeletePolicyRequest request) {
    deletePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or
   * organization policy does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   DeletePolicyRequest request =
   *       DeletePolicyRequest.newBuilder()
   *           .setName(PolicyName.ofProjectPolicyName("[PROJECT]", "[POLICY]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future = orgPolicyClient.deletePolicyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePolicyRequest, Empty> deletePolicyCallable() {
    return stub.deletePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a custom constraint.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the organization does not
   * exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the constraint
   * already exists on the given organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   CustomConstraint customConstraint = CustomConstraint.newBuilder().build();
   *   CustomConstraint response = orgPolicyClient.createCustomConstraint(parent, customConstraint);
   * }
   * }</pre>
   *
   * @param parent Required. Must be in the following form:
   *     <ul>
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @param customConstraint Required. Custom constraint to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomConstraint createCustomConstraint(
      OrganizationName parent, CustomConstraint customConstraint) {
    CreateCustomConstraintRequest request =
        CreateCustomConstraintRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCustomConstraint(customConstraint)
            .build();
    return createCustomConstraint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a custom constraint.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the organization does not
   * exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the constraint
   * already exists on the given organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   CustomConstraint customConstraint = CustomConstraint.newBuilder().build();
   *   CustomConstraint response = orgPolicyClient.createCustomConstraint(parent, customConstraint);
   * }
   * }</pre>
   *
   * @param parent Required. Must be in the following form:
   *     <ul>
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @param customConstraint Required. Custom constraint to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomConstraint createCustomConstraint(
      String parent, CustomConstraint customConstraint) {
    CreateCustomConstraintRequest request =
        CreateCustomConstraintRequest.newBuilder()
            .setParent(parent)
            .setCustomConstraint(customConstraint)
            .build();
    return createCustomConstraint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a custom constraint.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the organization does not
   * exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the constraint
   * already exists on the given organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   CreateCustomConstraintRequest request =
   *       CreateCustomConstraintRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setCustomConstraint(CustomConstraint.newBuilder().build())
   *           .build();
   *   CustomConstraint response = orgPolicyClient.createCustomConstraint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomConstraint createCustomConstraint(CreateCustomConstraintRequest request) {
    return createCustomConstraintCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a custom constraint.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the organization does not
   * exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the constraint
   * already exists on the given organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   CreateCustomConstraintRequest request =
   *       CreateCustomConstraintRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setCustomConstraint(CustomConstraint.newBuilder().build())
   *           .build();
   *   ApiFuture<CustomConstraint> future =
   *       orgPolicyClient.createCustomConstraintCallable().futureCall(request);
   *   // Do something.
   *   CustomConstraint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCustomConstraintRequest, CustomConstraint>
      createCustomConstraintCallable() {
    return stub.createCustomConstraintCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a custom constraint.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist.
   *
   * <p>Note: the supplied policy will perform a full overwrite of all fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   CustomConstraint customConstraint = CustomConstraint.newBuilder().build();
   *   CustomConstraint response = orgPolicyClient.updateCustomConstraint(customConstraint);
   * }
   * }</pre>
   *
   * @param customConstraint Required. `CustomConstraint` to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomConstraint updateCustomConstraint(CustomConstraint customConstraint) {
    UpdateCustomConstraintRequest request =
        UpdateCustomConstraintRequest.newBuilder().setCustomConstraint(customConstraint).build();
    return updateCustomConstraint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a custom constraint.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist.
   *
   * <p>Note: the supplied policy will perform a full overwrite of all fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   UpdateCustomConstraintRequest request =
   *       UpdateCustomConstraintRequest.newBuilder()
   *           .setCustomConstraint(CustomConstraint.newBuilder().build())
   *           .build();
   *   CustomConstraint response = orgPolicyClient.updateCustomConstraint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomConstraint updateCustomConstraint(UpdateCustomConstraintRequest request) {
    return updateCustomConstraintCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a custom constraint.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist.
   *
   * <p>Note: the supplied policy will perform a full overwrite of all fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   UpdateCustomConstraintRequest request =
   *       UpdateCustomConstraintRequest.newBuilder()
   *           .setCustomConstraint(CustomConstraint.newBuilder().build())
   *           .build();
   *   ApiFuture<CustomConstraint> future =
   *       orgPolicyClient.updateCustomConstraintCallable().futureCall(request);
   *   // Do something.
   *   CustomConstraint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCustomConstraintRequest, CustomConstraint>
      updateCustomConstraintCallable() {
    return stub.updateCustomConstraintCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a custom constraint.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the custom constraint does
   * not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   CustomConstraintName name = CustomConstraintName.of("[ORGANIZATION]", "[CUSTOM_CONSTRAINT]");
   *   CustomConstraint response = orgPolicyClient.getCustomConstraint(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the custom constraint. See the custom constraint entry
   *     for naming requirements.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomConstraint getCustomConstraint(CustomConstraintName name) {
    GetCustomConstraintRequest request =
        GetCustomConstraintRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCustomConstraint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a custom constraint.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the custom constraint does
   * not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   String name = CustomConstraintName.of("[ORGANIZATION]", "[CUSTOM_CONSTRAINT]").toString();
   *   CustomConstraint response = orgPolicyClient.getCustomConstraint(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the custom constraint. See the custom constraint entry
   *     for naming requirements.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomConstraint getCustomConstraint(String name) {
    GetCustomConstraintRequest request =
        GetCustomConstraintRequest.newBuilder().setName(name).build();
    return getCustomConstraint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a custom constraint.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the custom constraint does
   * not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   GetCustomConstraintRequest request =
   *       GetCustomConstraintRequest.newBuilder()
   *           .setName(CustomConstraintName.of("[ORGANIZATION]", "[CUSTOM_CONSTRAINT]").toString())
   *           .build();
   *   CustomConstraint response = orgPolicyClient.getCustomConstraint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomConstraint getCustomConstraint(GetCustomConstraintRequest request) {
    return getCustomConstraintCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a custom constraint.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the custom constraint does
   * not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   GetCustomConstraintRequest request =
   *       GetCustomConstraintRequest.newBuilder()
   *           .setName(CustomConstraintName.of("[ORGANIZATION]", "[CUSTOM_CONSTRAINT]").toString())
   *           .build();
   *   ApiFuture<CustomConstraint> future =
   *       orgPolicyClient.getCustomConstraintCallable().futureCall(request);
   *   // Do something.
   *   CustomConstraint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCustomConstraintRequest, CustomConstraint>
      getCustomConstraintCallable() {
    return stub.getCustomConstraintCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves all of the custom constraints that exist on a particular organization resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (CustomConstraint element : orgPolicyClient.listCustomConstraints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The target Google Cloud resource that parents the set of custom
   *     constraints that will be returned from this call. Must be in one of the following forms:
   *     <ul>
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomConstraintsPagedResponse listCustomConstraints(OrganizationName parent) {
    ListCustomConstraintsRequest request =
        ListCustomConstraintsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCustomConstraints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves all of the custom constraints that exist on a particular organization resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   for (CustomConstraint element : orgPolicyClient.listCustomConstraints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The target Google Cloud resource that parents the set of custom
   *     constraints that will be returned from this call. Must be in one of the following forms:
   *     <ul>
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomConstraintsPagedResponse listCustomConstraints(String parent) {
    ListCustomConstraintsRequest request =
        ListCustomConstraintsRequest.newBuilder().setParent(parent).build();
    return listCustomConstraints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves all of the custom constraints that exist on a particular organization resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   ListCustomConstraintsRequest request =
   *       ListCustomConstraintsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (CustomConstraint element : orgPolicyClient.listCustomConstraints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomConstraintsPagedResponse listCustomConstraints(
      ListCustomConstraintsRequest request) {
    return listCustomConstraintsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves all of the custom constraints that exist on a particular organization resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   ListCustomConstraintsRequest request =
   *       ListCustomConstraintsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<CustomConstraint> future =
   *       orgPolicyClient.listCustomConstraintsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CustomConstraint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCustomConstraintsRequest, ListCustomConstraintsPagedResponse>
      listCustomConstraintsPagedCallable() {
    return stub.listCustomConstraintsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves all of the custom constraints that exist on a particular organization resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   ListCustomConstraintsRequest request =
   *       ListCustomConstraintsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCustomConstraintsResponse response =
   *         orgPolicyClient.listCustomConstraintsCallable().call(request);
   *     for (CustomConstraint element : response.getCustomConstraintsList()) {
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
  public final UnaryCallable<ListCustomConstraintsRequest, ListCustomConstraintsResponse>
      listCustomConstraintsCallable() {
    return stub.listCustomConstraintsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a custom constraint.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   CustomConstraintName name = CustomConstraintName.of("[ORGANIZATION]", "[CUSTOM_CONSTRAINT]");
   *   orgPolicyClient.deleteCustomConstraint(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the custom constraint to delete. See the custom constraint entry
   *     for naming rules.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCustomConstraint(CustomConstraintName name) {
    DeleteCustomConstraintRequest request =
        DeleteCustomConstraintRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteCustomConstraint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a custom constraint.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   String name = CustomConstraintName.of("[ORGANIZATION]", "[CUSTOM_CONSTRAINT]").toString();
   *   orgPolicyClient.deleteCustomConstraint(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the custom constraint to delete. See the custom constraint entry
   *     for naming rules.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCustomConstraint(String name) {
    DeleteCustomConstraintRequest request =
        DeleteCustomConstraintRequest.newBuilder().setName(name).build();
    deleteCustomConstraint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a custom constraint.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   DeleteCustomConstraintRequest request =
   *       DeleteCustomConstraintRequest.newBuilder()
   *           .setName(CustomConstraintName.of("[ORGANIZATION]", "[CUSTOM_CONSTRAINT]").toString())
   *           .build();
   *   orgPolicyClient.deleteCustomConstraint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCustomConstraint(DeleteCustomConstraintRequest request) {
    deleteCustomConstraintCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a custom constraint.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyClient orgPolicyClient = OrgPolicyClient.create()) {
   *   DeleteCustomConstraintRequest request =
   *       DeleteCustomConstraintRequest.newBuilder()
   *           .setName(CustomConstraintName.of("[ORGANIZATION]", "[CUSTOM_CONSTRAINT]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       orgPolicyClient.deleteCustomConstraintCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCustomConstraintRequest, Empty>
      deleteCustomConstraintCallable() {
    return stub.deleteCustomConstraintCallable();
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

  public static class ListConstraintsPagedResponse
      extends AbstractPagedListResponse<
          ListConstraintsRequest,
          ListConstraintsResponse,
          Constraint,
          ListConstraintsPage,
          ListConstraintsFixedSizeCollection> {

    public static ApiFuture<ListConstraintsPagedResponse> createAsync(
        PageContext<ListConstraintsRequest, ListConstraintsResponse, Constraint> context,
        ApiFuture<ListConstraintsResponse> futureResponse) {
      ApiFuture<ListConstraintsPage> futurePage =
          ListConstraintsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConstraintsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConstraintsPagedResponse(ListConstraintsPage page) {
      super(page, ListConstraintsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConstraintsPage
      extends AbstractPage<
          ListConstraintsRequest, ListConstraintsResponse, Constraint, ListConstraintsPage> {

    private ListConstraintsPage(
        PageContext<ListConstraintsRequest, ListConstraintsResponse, Constraint> context,
        ListConstraintsResponse response) {
      super(context, response);
    }

    private static ListConstraintsPage createEmptyPage() {
      return new ListConstraintsPage(null, null);
    }

    @Override
    protected ListConstraintsPage createPage(
        PageContext<ListConstraintsRequest, ListConstraintsResponse, Constraint> context,
        ListConstraintsResponse response) {
      return new ListConstraintsPage(context, response);
    }

    @Override
    public ApiFuture<ListConstraintsPage> createPageAsync(
        PageContext<ListConstraintsRequest, ListConstraintsResponse, Constraint> context,
        ApiFuture<ListConstraintsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConstraintsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConstraintsRequest,
          ListConstraintsResponse,
          Constraint,
          ListConstraintsPage,
          ListConstraintsFixedSizeCollection> {

    private ListConstraintsFixedSizeCollection(
        List<ListConstraintsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConstraintsFixedSizeCollection createEmptyCollection() {
      return new ListConstraintsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConstraintsFixedSizeCollection createCollection(
        List<ListConstraintsPage> pages, int collectionSize) {
      return new ListConstraintsFixedSizeCollection(pages, collectionSize);
    }
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

  public static class ListCustomConstraintsPagedResponse
      extends AbstractPagedListResponse<
          ListCustomConstraintsRequest,
          ListCustomConstraintsResponse,
          CustomConstraint,
          ListCustomConstraintsPage,
          ListCustomConstraintsFixedSizeCollection> {

    public static ApiFuture<ListCustomConstraintsPagedResponse> createAsync(
        PageContext<ListCustomConstraintsRequest, ListCustomConstraintsResponse, CustomConstraint>
            context,
        ApiFuture<ListCustomConstraintsResponse> futureResponse) {
      ApiFuture<ListCustomConstraintsPage> futurePage =
          ListCustomConstraintsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCustomConstraintsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCustomConstraintsPagedResponse(ListCustomConstraintsPage page) {
      super(page, ListCustomConstraintsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCustomConstraintsPage
      extends AbstractPage<
          ListCustomConstraintsRequest,
          ListCustomConstraintsResponse,
          CustomConstraint,
          ListCustomConstraintsPage> {

    private ListCustomConstraintsPage(
        PageContext<ListCustomConstraintsRequest, ListCustomConstraintsResponse, CustomConstraint>
            context,
        ListCustomConstraintsResponse response) {
      super(context, response);
    }

    private static ListCustomConstraintsPage createEmptyPage() {
      return new ListCustomConstraintsPage(null, null);
    }

    @Override
    protected ListCustomConstraintsPage createPage(
        PageContext<ListCustomConstraintsRequest, ListCustomConstraintsResponse, CustomConstraint>
            context,
        ListCustomConstraintsResponse response) {
      return new ListCustomConstraintsPage(context, response);
    }

    @Override
    public ApiFuture<ListCustomConstraintsPage> createPageAsync(
        PageContext<ListCustomConstraintsRequest, ListCustomConstraintsResponse, CustomConstraint>
            context,
        ApiFuture<ListCustomConstraintsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCustomConstraintsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCustomConstraintsRequest,
          ListCustomConstraintsResponse,
          CustomConstraint,
          ListCustomConstraintsPage,
          ListCustomConstraintsFixedSizeCollection> {

    private ListCustomConstraintsFixedSizeCollection(
        List<ListCustomConstraintsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCustomConstraintsFixedSizeCollection createEmptyCollection() {
      return new ListCustomConstraintsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCustomConstraintsFixedSizeCollection createCollection(
        List<ListCustomConstraintsPage> pages, int collectionSize) {
      return new ListCustomConstraintsFixedSizeCollection(pages, collectionSize);
    }
  }
}
