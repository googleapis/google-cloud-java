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

package com.google.cloud.datacatalog.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datacatalog.v1.stub.PolicyTagManagerStub;
import com.google.cloud.datacatalog.v1.stub.PolicyTagManagerStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Policy Tag Manager API service allows you to manage your policy tags and
 * taxonomies.
 *
 * <p>Policy tags are used to tag BigQuery columns and apply additional access control policies. A
 * taxonomy is a hierarchical grouping of policy tags that classify data along a common axis.
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
 * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Taxonomy taxonomy = Taxonomy.newBuilder().build();
 *   Taxonomy response = policyTagManagerClient.createTaxonomy(parent, taxonomy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PolicyTagManagerClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of PolicyTagManagerSettings to
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
 * PolicyTagManagerSettings policyTagManagerSettings =
 *     PolicyTagManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PolicyTagManagerClient policyTagManagerClient =
 *     PolicyTagManagerClient.create(policyTagManagerSettings);
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
 * PolicyTagManagerSettings policyTagManagerSettings =
 *     PolicyTagManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PolicyTagManagerClient policyTagManagerClient =
 *     PolicyTagManagerClient.create(policyTagManagerSettings);
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
 * PolicyTagManagerSettings policyTagManagerSettings =
 *     PolicyTagManagerSettings.newHttpJsonBuilder().build();
 * PolicyTagManagerClient policyTagManagerClient =
 *     PolicyTagManagerClient.create(policyTagManagerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PolicyTagManagerClient implements BackgroundResource {
  private final PolicyTagManagerSettings settings;
  private final PolicyTagManagerStub stub;

  /** Constructs an instance of PolicyTagManagerClient with default settings. */
  public static final PolicyTagManagerClient create() throws IOException {
    return create(PolicyTagManagerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PolicyTagManagerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PolicyTagManagerClient create(PolicyTagManagerSettings settings)
      throws IOException {
    return new PolicyTagManagerClient(settings);
  }

  /**
   * Constructs an instance of PolicyTagManagerClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(PolicyTagManagerSettings).
   */
  public static final PolicyTagManagerClient create(PolicyTagManagerStub stub) {
    return new PolicyTagManagerClient(stub);
  }

  /**
   * Constructs an instance of PolicyTagManagerClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PolicyTagManagerClient(PolicyTagManagerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PolicyTagManagerStubSettings) settings.getStubSettings()).createStub();
  }

  protected PolicyTagManagerClient(PolicyTagManagerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PolicyTagManagerSettings getSettings() {
    return settings;
  }

  public PolicyTagManagerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a taxonomy in a specified project.
   *
   * <p>The taxonomy is initially empty, that is, it doesn't contain policy tags.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Taxonomy taxonomy = Taxonomy.newBuilder().build();
   *   Taxonomy response = policyTagManagerClient.createTaxonomy(parent, taxonomy);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the project that the taxonomy will belong to.
   * @param taxonomy The taxonomy to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Taxonomy createTaxonomy(LocationName parent, Taxonomy taxonomy) {
    CreateTaxonomyRequest request =
        CreateTaxonomyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTaxonomy(taxonomy)
            .build();
    return createTaxonomy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a taxonomy in a specified project.
   *
   * <p>The taxonomy is initially empty, that is, it doesn't contain policy tags.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Taxonomy taxonomy = Taxonomy.newBuilder().build();
   *   Taxonomy response = policyTagManagerClient.createTaxonomy(parent, taxonomy);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the project that the taxonomy will belong to.
   * @param taxonomy The taxonomy to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Taxonomy createTaxonomy(String parent, Taxonomy taxonomy) {
    CreateTaxonomyRequest request =
        CreateTaxonomyRequest.newBuilder().setParent(parent).setTaxonomy(taxonomy).build();
    return createTaxonomy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a taxonomy in a specified project.
   *
   * <p>The taxonomy is initially empty, that is, it doesn't contain policy tags.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   CreateTaxonomyRequest request =
   *       CreateTaxonomyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTaxonomy(Taxonomy.newBuilder().build())
   *           .build();
   *   Taxonomy response = policyTagManagerClient.createTaxonomy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Taxonomy createTaxonomy(CreateTaxonomyRequest request) {
    return createTaxonomyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a taxonomy in a specified project.
   *
   * <p>The taxonomy is initially empty, that is, it doesn't contain policy tags.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   CreateTaxonomyRequest request =
   *       CreateTaxonomyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTaxonomy(Taxonomy.newBuilder().build())
   *           .build();
   *   ApiFuture<Taxonomy> future =
   *       policyTagManagerClient.createTaxonomyCallable().futureCall(request);
   *   // Do something.
   *   Taxonomy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTaxonomyRequest, Taxonomy> createTaxonomyCallable() {
    return stub.createTaxonomyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a taxonomy, including all policy tags in this taxonomy, their associated policies, and
   * the policy tags references from BigQuery columns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   TaxonomyName name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
   *   policyTagManagerClient.deleteTaxonomy(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the taxonomy to delete.
   *     <p>Note: All policy tags in this taxonomy are also deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTaxonomy(TaxonomyName name) {
    DeleteTaxonomyRequest request =
        DeleteTaxonomyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteTaxonomy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a taxonomy, including all policy tags in this taxonomy, their associated policies, and
   * the policy tags references from BigQuery columns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   String name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString();
   *   policyTagManagerClient.deleteTaxonomy(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the taxonomy to delete.
   *     <p>Note: All policy tags in this taxonomy are also deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTaxonomy(String name) {
    DeleteTaxonomyRequest request = DeleteTaxonomyRequest.newBuilder().setName(name).build();
    deleteTaxonomy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a taxonomy, including all policy tags in this taxonomy, their associated policies, and
   * the policy tags references from BigQuery columns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   DeleteTaxonomyRequest request =
   *       DeleteTaxonomyRequest.newBuilder()
   *           .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
   *           .build();
   *   policyTagManagerClient.deleteTaxonomy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTaxonomy(DeleteTaxonomyRequest request) {
    deleteTaxonomyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a taxonomy, including all policy tags in this taxonomy, their associated policies, and
   * the policy tags references from BigQuery columns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   DeleteTaxonomyRequest request =
   *       DeleteTaxonomyRequest.newBuilder()
   *           .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
   *           .build();
   *   ApiFuture<Empty> future = policyTagManagerClient.deleteTaxonomyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTaxonomyRequest, Empty> deleteTaxonomyCallable() {
    return stub.deleteTaxonomyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a taxonomy, including its display name, description, and activated policy types.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   Taxonomy taxonomy = Taxonomy.newBuilder().build();
   *   Taxonomy response = policyTagManagerClient.updateTaxonomy(taxonomy);
   * }
   * }</pre>
   *
   * @param taxonomy The taxonomy to update. You can update only its description, display name, and
   *     activated policy types.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Taxonomy updateTaxonomy(Taxonomy taxonomy) {
    UpdateTaxonomyRequest request =
        UpdateTaxonomyRequest.newBuilder().setTaxonomy(taxonomy).build();
    return updateTaxonomy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a taxonomy, including its display name, description, and activated policy types.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   UpdateTaxonomyRequest request =
   *       UpdateTaxonomyRequest.newBuilder()
   *           .setTaxonomy(Taxonomy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Taxonomy response = policyTagManagerClient.updateTaxonomy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Taxonomy updateTaxonomy(UpdateTaxonomyRequest request) {
    return updateTaxonomyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a taxonomy, including its display name, description, and activated policy types.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   UpdateTaxonomyRequest request =
   *       UpdateTaxonomyRequest.newBuilder()
   *           .setTaxonomy(Taxonomy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Taxonomy> future =
   *       policyTagManagerClient.updateTaxonomyCallable().futureCall(request);
   *   // Do something.
   *   Taxonomy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTaxonomyRequest, Taxonomy> updateTaxonomyCallable() {
    return stub.updateTaxonomyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all taxonomies in a project in a particular location that you have a permission to view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Taxonomy element : policyTagManagerClient.listTaxonomies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the project to list the taxonomies of.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTaxonomiesPagedResponse listTaxonomies(LocationName parent) {
    ListTaxonomiesRequest request =
        ListTaxonomiesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTaxonomies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all taxonomies in a project in a particular location that you have a permission to view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Taxonomy element : policyTagManagerClient.listTaxonomies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the project to list the taxonomies of.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTaxonomiesPagedResponse listTaxonomies(String parent) {
    ListTaxonomiesRequest request = ListTaxonomiesRequest.newBuilder().setParent(parent).build();
    return listTaxonomies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all taxonomies in a project in a particular location that you have a permission to view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   ListTaxonomiesRequest request =
   *       ListTaxonomiesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Taxonomy element : policyTagManagerClient.listTaxonomies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTaxonomiesPagedResponse listTaxonomies(ListTaxonomiesRequest request) {
    return listTaxonomiesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all taxonomies in a project in a particular location that you have a permission to view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   ListTaxonomiesRequest request =
   *       ListTaxonomiesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Taxonomy> future =
   *       policyTagManagerClient.listTaxonomiesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Taxonomy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTaxonomiesRequest, ListTaxonomiesPagedResponse>
      listTaxonomiesPagedCallable() {
    return stub.listTaxonomiesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all taxonomies in a project in a particular location that you have a permission to view.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   ListTaxonomiesRequest request =
   *       ListTaxonomiesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTaxonomiesResponse response =
   *         policyTagManagerClient.listTaxonomiesCallable().call(request);
   *     for (Taxonomy element : response.getTaxonomiesList()) {
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
  public final UnaryCallable<ListTaxonomiesRequest, ListTaxonomiesResponse>
      listTaxonomiesCallable() {
    return stub.listTaxonomiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   TaxonomyName name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
   *   Taxonomy response = policyTagManagerClient.getTaxonomy(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the taxonomy to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Taxonomy getTaxonomy(TaxonomyName name) {
    GetTaxonomyRequest request =
        GetTaxonomyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTaxonomy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   String name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString();
   *   Taxonomy response = policyTagManagerClient.getTaxonomy(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the taxonomy to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Taxonomy getTaxonomy(String name) {
    GetTaxonomyRequest request = GetTaxonomyRequest.newBuilder().setName(name).build();
    return getTaxonomy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   GetTaxonomyRequest request =
   *       GetTaxonomyRequest.newBuilder()
   *           .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
   *           .build();
   *   Taxonomy response = policyTagManagerClient.getTaxonomy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Taxonomy getTaxonomy(GetTaxonomyRequest request) {
    return getTaxonomyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   GetTaxonomyRequest request =
   *       GetTaxonomyRequest.newBuilder()
   *           .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
   *           .build();
   *   ApiFuture<Taxonomy> future = policyTagManagerClient.getTaxonomyCallable().futureCall(request);
   *   // Do something.
   *   Taxonomy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTaxonomyRequest, Taxonomy> getTaxonomyCallable() {
    return stub.getTaxonomyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy tag in a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   TaxonomyName parent = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
   *   PolicyTag policyTag = PolicyTag.newBuilder().build();
   *   PolicyTag response = policyTagManagerClient.createPolicyTag(parent, policyTag);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the taxonomy that the policy tag will belong to.
   * @param policyTag The policy tag to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PolicyTag createPolicyTag(TaxonomyName parent, PolicyTag policyTag) {
    CreatePolicyTagRequest request =
        CreatePolicyTagRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPolicyTag(policyTag)
            .build();
    return createPolicyTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy tag in a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   String parent = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString();
   *   PolicyTag policyTag = PolicyTag.newBuilder().build();
   *   PolicyTag response = policyTagManagerClient.createPolicyTag(parent, policyTag);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the taxonomy that the policy tag will belong to.
   * @param policyTag The policy tag to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PolicyTag createPolicyTag(String parent, PolicyTag policyTag) {
    CreatePolicyTagRequest request =
        CreatePolicyTagRequest.newBuilder().setParent(parent).setPolicyTag(policyTag).build();
    return createPolicyTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy tag in a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   CreatePolicyTagRequest request =
   *       CreatePolicyTagRequest.newBuilder()
   *           .setParent(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
   *           .setPolicyTag(PolicyTag.newBuilder().build())
   *           .build();
   *   PolicyTag response = policyTagManagerClient.createPolicyTag(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PolicyTag createPolicyTag(CreatePolicyTagRequest request) {
    return createPolicyTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a policy tag in a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   CreatePolicyTagRequest request =
   *       CreatePolicyTagRequest.newBuilder()
   *           .setParent(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
   *           .setPolicyTag(PolicyTag.newBuilder().build())
   *           .build();
   *   ApiFuture<PolicyTag> future =
   *       policyTagManagerClient.createPolicyTagCallable().futureCall(request);
   *   // Do something.
   *   PolicyTag response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePolicyTagRequest, PolicyTag> createPolicyTagCallable() {
    return stub.createPolicyTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy tag together with the following:
   *
   * <ul>
   *   <li>All of its descendant policy tags, if any
   *   <li>Policies associated with the policy tag and its descendants
   *   <li>References from BigQuery table schema of the policy tag and its descendants
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   PolicyTagName name =
   *       PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]");
   *   policyTagManagerClient.deletePolicyTag(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the policy tag to delete.
   *     <p>Note: All of its descendant policy tags are also deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePolicyTag(PolicyTagName name) {
    DeletePolicyTagRequest request =
        DeletePolicyTagRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deletePolicyTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy tag together with the following:
   *
   * <ul>
   *   <li>All of its descendant policy tags, if any
   *   <li>Policies associated with the policy tag and its descendants
   *   <li>References from BigQuery table schema of the policy tag and its descendants
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   String name =
   *       PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]").toString();
   *   policyTagManagerClient.deletePolicyTag(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the policy tag to delete.
   *     <p>Note: All of its descendant policy tags are also deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePolicyTag(String name) {
    DeletePolicyTagRequest request = DeletePolicyTagRequest.newBuilder().setName(name).build();
    deletePolicyTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy tag together with the following:
   *
   * <ul>
   *   <li>All of its descendant policy tags, if any
   *   <li>Policies associated with the policy tag and its descendants
   *   <li>References from BigQuery table schema of the policy tag and its descendants
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   DeletePolicyTagRequest request =
   *       DeletePolicyTagRequest.newBuilder()
   *           .setName(
   *               PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
   *                   .toString())
   *           .build();
   *   policyTagManagerClient.deletePolicyTag(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePolicyTag(DeletePolicyTagRequest request) {
    deletePolicyTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a policy tag together with the following:
   *
   * <ul>
   *   <li>All of its descendant policy tags, if any
   *   <li>Policies associated with the policy tag and its descendants
   *   <li>References from BigQuery table schema of the policy tag and its descendants
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   DeletePolicyTagRequest request =
   *       DeletePolicyTagRequest.newBuilder()
   *           .setName(
   *               PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       policyTagManagerClient.deletePolicyTagCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePolicyTagRequest, Empty> deletePolicyTagCallable() {
    return stub.deletePolicyTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a policy tag, including its display name, description, and parent policy tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   PolicyTag policyTag = PolicyTag.newBuilder().build();
   *   PolicyTag response = policyTagManagerClient.updatePolicyTag(policyTag);
   * }
   * }</pre>
   *
   * @param policyTag The policy tag to update. You can update only its description, display name,
   *     and parent policy tag fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PolicyTag updatePolicyTag(PolicyTag policyTag) {
    UpdatePolicyTagRequest request =
        UpdatePolicyTagRequest.newBuilder().setPolicyTag(policyTag).build();
    return updatePolicyTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a policy tag, including its display name, description, and parent policy tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   UpdatePolicyTagRequest request =
   *       UpdatePolicyTagRequest.newBuilder()
   *           .setPolicyTag(PolicyTag.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   PolicyTag response = policyTagManagerClient.updatePolicyTag(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PolicyTag updatePolicyTag(UpdatePolicyTagRequest request) {
    return updatePolicyTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a policy tag, including its display name, description, and parent policy tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   UpdatePolicyTagRequest request =
   *       UpdatePolicyTagRequest.newBuilder()
   *           .setPolicyTag(PolicyTag.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<PolicyTag> future =
   *       policyTagManagerClient.updatePolicyTagCallable().futureCall(request);
   *   // Do something.
   *   PolicyTag response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePolicyTagRequest, PolicyTag> updatePolicyTagCallable() {
    return stub.updatePolicyTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all policy tags in a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   TaxonomyName parent = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
   *   for (PolicyTag element : policyTagManagerClient.listPolicyTags(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the taxonomy to list the policy tags of.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPolicyTagsPagedResponse listPolicyTags(TaxonomyName parent) {
    ListPolicyTagsRequest request =
        ListPolicyTagsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPolicyTags(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all policy tags in a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   String parent = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString();
   *   for (PolicyTag element : policyTagManagerClient.listPolicyTags(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the taxonomy to list the policy tags of.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPolicyTagsPagedResponse listPolicyTags(String parent) {
    ListPolicyTagsRequest request = ListPolicyTagsRequest.newBuilder().setParent(parent).build();
    return listPolicyTags(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all policy tags in a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   ListPolicyTagsRequest request =
   *       ListPolicyTagsRequest.newBuilder()
   *           .setParent(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PolicyTag element : policyTagManagerClient.listPolicyTags(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPolicyTagsPagedResponse listPolicyTags(ListPolicyTagsRequest request) {
    return listPolicyTagsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all policy tags in a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   ListPolicyTagsRequest request =
   *       ListPolicyTagsRequest.newBuilder()
   *           .setParent(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PolicyTag> future =
   *       policyTagManagerClient.listPolicyTagsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PolicyTag element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPolicyTagsRequest, ListPolicyTagsPagedResponse>
      listPolicyTagsPagedCallable() {
    return stub.listPolicyTagsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all policy tags in a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   ListPolicyTagsRequest request =
   *       ListPolicyTagsRequest.newBuilder()
   *           .setParent(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPolicyTagsResponse response =
   *         policyTagManagerClient.listPolicyTagsCallable().call(request);
   *     for (PolicyTag element : response.getPolicyTagsList()) {
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
  public final UnaryCallable<ListPolicyTagsRequest, ListPolicyTagsResponse>
      listPolicyTagsCallable() {
    return stub.listPolicyTagsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a policy tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   PolicyTagName name =
   *       PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]");
   *   PolicyTag response = policyTagManagerClient.getPolicyTag(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the policy tag.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PolicyTag getPolicyTag(PolicyTagName name) {
    GetPolicyTagRequest request =
        GetPolicyTagRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPolicyTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a policy tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   String name =
   *       PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]").toString();
   *   PolicyTag response = policyTagManagerClient.getPolicyTag(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the policy tag.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PolicyTag getPolicyTag(String name) {
    GetPolicyTagRequest request = GetPolicyTagRequest.newBuilder().setName(name).build();
    return getPolicyTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a policy tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   GetPolicyTagRequest request =
   *       GetPolicyTagRequest.newBuilder()
   *           .setName(
   *               PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
   *                   .toString())
   *           .build();
   *   PolicyTag response = policyTagManagerClient.getPolicyTag(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PolicyTag getPolicyTag(GetPolicyTagRequest request) {
    return getPolicyTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a policy tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   GetPolicyTagRequest request =
   *       GetPolicyTagRequest.newBuilder()
   *           .setName(
   *               PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PolicyTag> future =
   *       policyTagManagerClient.getPolicyTagCallable().futureCall(request);
   *   // Do something.
   *   PolicyTag response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPolicyTagRequest, PolicyTag> getPolicyTagCallable() {
    return stub.getPolicyTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy for a policy tag or a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = policyTagManagerClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy for a policy tag or a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = policyTagManagerClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM policy for a policy tag or a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = policyTagManagerClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM policy for a policy tag or a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = policyTagManagerClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns your permissions on a specified policy tag or taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = policyTagManagerClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns your permissions on a specified policy tag or taxonomy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       policyTagManagerClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
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

  public static class ListTaxonomiesPagedResponse
      extends AbstractPagedListResponse<
          ListTaxonomiesRequest,
          ListTaxonomiesResponse,
          Taxonomy,
          ListTaxonomiesPage,
          ListTaxonomiesFixedSizeCollection> {

    public static ApiFuture<ListTaxonomiesPagedResponse> createAsync(
        PageContext<ListTaxonomiesRequest, ListTaxonomiesResponse, Taxonomy> context,
        ApiFuture<ListTaxonomiesResponse> futureResponse) {
      ApiFuture<ListTaxonomiesPage> futurePage =
          ListTaxonomiesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTaxonomiesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTaxonomiesPagedResponse(ListTaxonomiesPage page) {
      super(page, ListTaxonomiesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTaxonomiesPage
      extends AbstractPage<
          ListTaxonomiesRequest, ListTaxonomiesResponse, Taxonomy, ListTaxonomiesPage> {

    private ListTaxonomiesPage(
        PageContext<ListTaxonomiesRequest, ListTaxonomiesResponse, Taxonomy> context,
        ListTaxonomiesResponse response) {
      super(context, response);
    }

    private static ListTaxonomiesPage createEmptyPage() {
      return new ListTaxonomiesPage(null, null);
    }

    @Override
    protected ListTaxonomiesPage createPage(
        PageContext<ListTaxonomiesRequest, ListTaxonomiesResponse, Taxonomy> context,
        ListTaxonomiesResponse response) {
      return new ListTaxonomiesPage(context, response);
    }

    @Override
    public ApiFuture<ListTaxonomiesPage> createPageAsync(
        PageContext<ListTaxonomiesRequest, ListTaxonomiesResponse, Taxonomy> context,
        ApiFuture<ListTaxonomiesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTaxonomiesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTaxonomiesRequest,
          ListTaxonomiesResponse,
          Taxonomy,
          ListTaxonomiesPage,
          ListTaxonomiesFixedSizeCollection> {

    private ListTaxonomiesFixedSizeCollection(List<ListTaxonomiesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTaxonomiesFixedSizeCollection createEmptyCollection() {
      return new ListTaxonomiesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTaxonomiesFixedSizeCollection createCollection(
        List<ListTaxonomiesPage> pages, int collectionSize) {
      return new ListTaxonomiesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPolicyTagsPagedResponse
      extends AbstractPagedListResponse<
          ListPolicyTagsRequest,
          ListPolicyTagsResponse,
          PolicyTag,
          ListPolicyTagsPage,
          ListPolicyTagsFixedSizeCollection> {

    public static ApiFuture<ListPolicyTagsPagedResponse> createAsync(
        PageContext<ListPolicyTagsRequest, ListPolicyTagsResponse, PolicyTag> context,
        ApiFuture<ListPolicyTagsResponse> futureResponse) {
      ApiFuture<ListPolicyTagsPage> futurePage =
          ListPolicyTagsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPolicyTagsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPolicyTagsPagedResponse(ListPolicyTagsPage page) {
      super(page, ListPolicyTagsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPolicyTagsPage
      extends AbstractPage<
          ListPolicyTagsRequest, ListPolicyTagsResponse, PolicyTag, ListPolicyTagsPage> {

    private ListPolicyTagsPage(
        PageContext<ListPolicyTagsRequest, ListPolicyTagsResponse, PolicyTag> context,
        ListPolicyTagsResponse response) {
      super(context, response);
    }

    private static ListPolicyTagsPage createEmptyPage() {
      return new ListPolicyTagsPage(null, null);
    }

    @Override
    protected ListPolicyTagsPage createPage(
        PageContext<ListPolicyTagsRequest, ListPolicyTagsResponse, PolicyTag> context,
        ListPolicyTagsResponse response) {
      return new ListPolicyTagsPage(context, response);
    }

    @Override
    public ApiFuture<ListPolicyTagsPage> createPageAsync(
        PageContext<ListPolicyTagsRequest, ListPolicyTagsResponse, PolicyTag> context,
        ApiFuture<ListPolicyTagsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPolicyTagsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPolicyTagsRequest,
          ListPolicyTagsResponse,
          PolicyTag,
          ListPolicyTagsPage,
          ListPolicyTagsFixedSizeCollection> {

    private ListPolicyTagsFixedSizeCollection(List<ListPolicyTagsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPolicyTagsFixedSizeCollection createEmptyCollection() {
      return new ListPolicyTagsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPolicyTagsFixedSizeCollection createCollection(
        List<ListPolicyTagsPage> pages, int collectionSize) {
      return new ListPolicyTagsFixedSizeCollection(pages, collectionSize);
    }
  }
}
