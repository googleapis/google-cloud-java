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
 * <p>The Cloud Org Policy service provides a simple mechanism for organizations to restrict the
 * allowed configurations across their entire Cloud Resource hierarchy.
 *
 * <p>You can use a `policy` to configure restrictions in Cloud resources. For example, you can
 * enforce a `policy` that restricts which Google Cloud Platform APIs can be activated in a certain
 * part of your resource hierarchy, or prevents serial port access to VM instances in a particular
 * folder.
 *
 * <p>`Policies` are inherited down through the resource hierarchy. A `policy` applied to a parent
 * resource automatically applies to all its child resources unless overridden with a `policy` lower
 * in the hierarchy.
 *
 * <p>A `constraint` defines an aspect of a resource's configuration that can be controlled by an
 * organization's policy administrator. `Policies` are a collection of `constraints` that defines
 * their allowable configuration on a particular resource and its child resources.
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
 * OrgPolicySettings orgPolicySettings =
 *     OrgPolicySettings.newBuilder()
 *         .setTransportChannelProvider(
 *             OrgPolicySettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
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
   * Lists `Constraints` that could be applied on the specified resource.
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
   * @param parent Required. The Cloud resource that parents the constraint. Must be in one of the
   *     following forms:
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
   * Lists `Constraints` that could be applied on the specified resource.
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
   * @param parent Required. The Cloud resource that parents the constraint. Must be in one of the
   *     following forms:
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
   * Lists `Constraints` that could be applied on the specified resource.
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
   * @param parent Required. The Cloud resource that parents the constraint. Must be in one of the
   *     following forms:
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
   * Lists `Constraints` that could be applied on the specified resource.
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
   * @param parent Required. The Cloud resource that parents the constraint. Must be in one of the
   *     following forms:
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
   * Lists `Constraints` that could be applied on the specified resource.
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
   * Lists `Constraints` that could be applied on the specified resource.
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
   * Lists `Constraints` that could be applied on the specified resource.
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
   * Retrieves all of the `Policies` that exist on a particular resource.
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
   * @param parent Required. The target Cloud resource that parents the set of constraints and
   *     policies that will be returned from this call. Must be in one of the following forms:
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
   * Retrieves all of the `Policies` that exist on a particular resource.
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
   * @param parent Required. The target Cloud resource that parents the set of constraints and
   *     policies that will be returned from this call. Must be in one of the following forms:
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
   * Retrieves all of the `Policies` that exist on a particular resource.
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
   * @param parent Required. The target Cloud resource that parents the set of constraints and
   *     policies that will be returned from this call. Must be in one of the following forms:
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
   * Retrieves all of the `Policies` that exist on a particular resource.
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
   * @param parent Required. The target Cloud resource that parents the set of constraints and
   *     policies that will be returned from this call. Must be in one of the following forms:
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
   * Retrieves all of the `Policies` that exist on a particular resource.
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
   * Retrieves all of the `Policies` that exist on a particular resource.
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
   * Retrieves all of the `Policies` that exist on a particular resource.
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
   * Gets a `Policy` on a resource.
   *
   * <p>If no `Policy` is set on the resource, NOT_FOUND is returned. The `etag` value can be used
   * with `UpdatePolicy()` to update a `Policy` during read-modify-write.
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
   * @param name Required. Resource name of the policy. See `Policy` for naming requirements.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getPolicy(PolicyName name) {
    GetPolicyRequest request =
        GetPolicyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a `Policy` on a resource.
   *
   * <p>If no `Policy` is set on the resource, NOT_FOUND is returned. The `etag` value can be used
   * with `UpdatePolicy()` to update a `Policy` during read-modify-write.
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
   * @param name Required. Resource name of the policy. See `Policy` for naming requirements.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getPolicy(String name) {
    GetPolicyRequest request = GetPolicyRequest.newBuilder().setName(name).build();
    return getPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a `Policy` on a resource.
   *
   * <p>If no `Policy` is set on the resource, NOT_FOUND is returned. The `etag` value can be used
   * with `UpdatePolicy()` to update a `Policy` during read-modify-write.
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
   * Gets a `Policy` on a resource.
   *
   * <p>If no `Policy` is set on the resource, NOT_FOUND is returned. The `etag` value can be used
   * with `UpdatePolicy()` to update a `Policy` during read-modify-write.
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
   * Gets the effective `Policy` on a resource. This is the result of merging `Policies` in the
   * resource hierarchy and evaluating conditions. The returned `Policy` will not have an `etag` or
   * `condition` set because it is a computed `Policy` across multiple resources. Subtrees of
   * Resource Manager resource hierarchy with 'under:' prefix will not be expanded.
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
   * @param name Required. The effective policy to compute. See `Policy` for naming rules.
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
   * Gets the effective `Policy` on a resource. This is the result of merging `Policies` in the
   * resource hierarchy and evaluating conditions. The returned `Policy` will not have an `etag` or
   * `condition` set because it is a computed `Policy` across multiple resources. Subtrees of
   * Resource Manager resource hierarchy with 'under:' prefix will not be expanded.
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
   * @param name Required. The effective policy to compute. See `Policy` for naming rules.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getEffectivePolicy(String name) {
    GetEffectivePolicyRequest request =
        GetEffectivePolicyRequest.newBuilder().setName(name).build();
    return getEffectivePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the effective `Policy` on a resource. This is the result of merging `Policies` in the
   * resource hierarchy and evaluating conditions. The returned `Policy` will not have an `etag` or
   * `condition` set because it is a computed `Policy` across multiple resources. Subtrees of
   * Resource Manager resource hierarchy with 'under:' prefix will not be expanded.
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
   * Gets the effective `Policy` on a resource. This is the result of merging `Policies` in the
   * resource hierarchy and evaluating conditions. The returned `Policy` will not have an `etag` or
   * `condition` set because it is a computed `Policy` across multiple resources. Subtrees of
   * Resource Manager resource hierarchy with 'under:' prefix will not be expanded.
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
   * Creates a Policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy
   * already exists on the given Cloud resource.
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
   * @param parent Required. The Cloud resource that will parent the new Policy. Must be in one of
   *     the following forms:
   *     <ul>
   *       <li>`projects/{project_number}`
   *       <li>`projects/{project_id}`
   *       <li>`folders/{folder_id}`
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @param policy Required. `Policy` to create.
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
   * Creates a Policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy
   * already exists on the given Cloud resource.
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
   * @param parent Required. The Cloud resource that will parent the new Policy. Must be in one of
   *     the following forms:
   *     <ul>
   *       <li>`projects/{project_number}`
   *       <li>`projects/{project_id}`
   *       <li>`folders/{folder_id}`
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @param policy Required. `Policy` to create.
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
   * Creates a Policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy
   * already exists on the given Cloud resource.
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
   * @param parent Required. The Cloud resource that will parent the new Policy. Must be in one of
   *     the following forms:
   *     <ul>
   *       <li>`projects/{project_number}`
   *       <li>`projects/{project_id}`
   *       <li>`folders/{folder_id}`
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @param policy Required. `Policy` to create.
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
   * Creates a Policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy
   * already exists on the given Cloud resource.
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
   * @param parent Required. The Cloud resource that will parent the new Policy. Must be in one of
   *     the following forms:
   *     <ul>
   *       <li>`projects/{project_number}`
   *       <li>`projects/{project_id}`
   *       <li>`folders/{folder_id}`
   *       <li>`organizations/{organization_id}`
   *     </ul>
   *
   * @param policy Required. `Policy` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy createPolicy(String parent, Policy policy) {
    CreatePolicyRequest request =
        CreatePolicyRequest.newBuilder().setParent(parent).setPolicy(policy).build();
    return createPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy
   * already exists on the given Cloud resource.
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
   * Creates a Policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not
   * exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy
   * already exists on the given Cloud resource.
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
   * Updates a Policy.
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
   * @param policy Required. `Policy` to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy updatePolicy(Policy policy) {
    UpdatePolicyRequest request = UpdatePolicyRequest.newBuilder().setPolicy(policy).build();
    return updatePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Policy.
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
   *       UpdatePolicyRequest.newBuilder().setPolicy(Policy.newBuilder().build()).build();
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
   * Updates a Policy.
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
   *       UpdatePolicyRequest.newBuilder().setPolicy(Policy.newBuilder().build()).build();
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
   * Deletes a Policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or Org
   * Policy does not exist.
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
   * @param name Required. Name of the policy to delete. See `Policy` for naming rules.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePolicy(PolicyName name) {
    DeletePolicyRequest request =
        DeletePolicyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deletePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or Org
   * Policy does not exist.
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
   * @param name Required. Name of the policy to delete. See `Policy` for naming rules.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePolicy(String name) {
    DeletePolicyRequest request = DeletePolicyRequest.newBuilder().setName(name).build();
    deletePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or Org
   * Policy does not exist.
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
   * Deletes a Policy.
   *
   * <p>Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or Org
   * Policy does not exist.
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
}
