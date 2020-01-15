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
package com.google.cloud.datacatalog.v1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datacatalog.v1beta1.stub.PolicyTagManagerStub;
import com.google.cloud.datacatalog.v1beta1.stub.PolicyTagManagerStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The policy tag manager API service allows clients to manage their taxonomies
 * and policy tags.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
 *   CreateTaxonomyRequest request = CreateTaxonomyRequest.newBuilder().build();
 *   Taxonomy response = policyTagManagerClient.createTaxonomy(request);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the policyTagManagerClient object to clean up resources
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
 * <pre>
 * <code>
 * PolicyTagManagerSettings policyTagManagerSettings =
 *     PolicyTagManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PolicyTagManagerClient policyTagManagerClient =
 *     PolicyTagManagerClient.create(policyTagManagerSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * PolicyTagManagerSettings policyTagManagerSettings =
 *     PolicyTagManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PolicyTagManagerClient policyTagManagerClient =
 *     PolicyTagManagerClient.create(policyTagManagerSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
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
   * is for advanced usage - prefer to use PolicyTagManagerSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected PolicyTagManagerClient(PolicyTagManagerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PolicyTagManagerSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PolicyTagManagerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a taxonomy in the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   CreateTaxonomyRequest request = CreateTaxonomyRequest.newBuilder().build();
   *   Taxonomy response = policyTagManagerClient.createTaxonomy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Taxonomy createTaxonomy(CreateTaxonomyRequest request) {
    return createTaxonomyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a taxonomy in the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   CreateTaxonomyRequest request = CreateTaxonomyRequest.newBuilder().build();
   *   ApiFuture&lt;Taxonomy&gt; future = policyTagManagerClient.createTaxonomyCallable().futureCall(request);
   *   // Do something
   *   Taxonomy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateTaxonomyRequest, Taxonomy> createTaxonomyCallable() {
    return stub.createTaxonomyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a taxonomy. This operation will also delete all policy tags in this taxonomy along with
   * their associated policies.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   DeleteTaxonomyRequest request = DeleteTaxonomyRequest.newBuilder().build();
   *   policyTagManagerClient.deleteTaxonomy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTaxonomy(DeleteTaxonomyRequest request) {
    deleteTaxonomyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a taxonomy. This operation will also delete all policy tags in this taxonomy along with
   * their associated policies.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   DeleteTaxonomyRequest request = DeleteTaxonomyRequest.newBuilder().build();
   *   ApiFuture&lt;Void&gt; future = policyTagManagerClient.deleteTaxonomyCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteTaxonomyRequest, Empty> deleteTaxonomyCallable() {
    return stub.deleteTaxonomyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   UpdateTaxonomyRequest request = UpdateTaxonomyRequest.newBuilder().build();
   *   Taxonomy response = policyTagManagerClient.updateTaxonomy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Taxonomy updateTaxonomy(UpdateTaxonomyRequest request) {
    return updateTaxonomyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   UpdateTaxonomyRequest request = UpdateTaxonomyRequest.newBuilder().build();
   *   ApiFuture&lt;Taxonomy&gt; future = policyTagManagerClient.updateTaxonomyCallable().futureCall(request);
   *   // Do something
   *   Taxonomy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateTaxonomyRequest, Taxonomy> updateTaxonomyCallable() {
    return stub.updateTaxonomyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all taxonomies in a project in a particular location that the caller has permission to
   * view.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   ListTaxonomiesRequest request = ListTaxonomiesRequest.newBuilder().build();
   *   ListTaxonomiesResponse response = policyTagManagerClient.listTaxonomies(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTaxonomiesResponse listTaxonomies(ListTaxonomiesRequest request) {
    return listTaxonomiesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all taxonomies in a project in a particular location that the caller has permission to
   * view.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   ListTaxonomiesRequest request = ListTaxonomiesRequest.newBuilder().build();
   *   ApiFuture&lt;ListTaxonomiesResponse&gt; future = policyTagManagerClient.listTaxonomiesCallable().futureCall(request);
   *   // Do something
   *   ListTaxonomiesResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTaxonomiesRequest, ListTaxonomiesResponse>
      listTaxonomiesCallable() {
    return stub.listTaxonomiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   GetTaxonomyRequest request = GetTaxonomyRequest.newBuilder().build();
   *   Taxonomy response = policyTagManagerClient.getTaxonomy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Taxonomy getTaxonomy(GetTaxonomyRequest request) {
    return getTaxonomyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   GetTaxonomyRequest request = GetTaxonomyRequest.newBuilder().build();
   *   ApiFuture&lt;Taxonomy&gt; future = policyTagManagerClient.getTaxonomyCallable().futureCall(request);
   *   // Do something
   *   Taxonomy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetTaxonomyRequest, Taxonomy> getTaxonomyCallable() {
    return stub.getTaxonomyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a policy tag in the specified taxonomy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   CreatePolicyTagRequest request = CreatePolicyTagRequest.newBuilder().build();
   *   PolicyTag response = policyTagManagerClient.createPolicyTag(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PolicyTag createPolicyTag(CreatePolicyTagRequest request) {
    return createPolicyTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a policy tag in the specified taxonomy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   CreatePolicyTagRequest request = CreatePolicyTagRequest.newBuilder().build();
   *   ApiFuture&lt;PolicyTag&gt; future = policyTagManagerClient.createPolicyTagCallable().futureCall(request);
   *   // Do something
   *   PolicyTag response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreatePolicyTagRequest, PolicyTag> createPolicyTagCallable() {
    return stub.createPolicyTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a policy tag. Also deletes all of its descendant policy tags.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   DeletePolicyTagRequest request = DeletePolicyTagRequest.newBuilder().build();
   *   policyTagManagerClient.deletePolicyTag(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePolicyTag(DeletePolicyTagRequest request) {
    deletePolicyTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a policy tag. Also deletes all of its descendant policy tags.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   DeletePolicyTagRequest request = DeletePolicyTagRequest.newBuilder().build();
   *   ApiFuture&lt;Void&gt; future = policyTagManagerClient.deletePolicyTagCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeletePolicyTagRequest, Empty> deletePolicyTagCallable() {
    return stub.deletePolicyTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a policy tag.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   UpdatePolicyTagRequest request = UpdatePolicyTagRequest.newBuilder().build();
   *   PolicyTag response = policyTagManagerClient.updatePolicyTag(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PolicyTag updatePolicyTag(UpdatePolicyTagRequest request) {
    return updatePolicyTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a policy tag.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   UpdatePolicyTagRequest request = UpdatePolicyTagRequest.newBuilder().build();
   *   ApiFuture&lt;PolicyTag&gt; future = policyTagManagerClient.updatePolicyTagCallable().futureCall(request);
   *   // Do something
   *   PolicyTag response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdatePolicyTagRequest, PolicyTag> updatePolicyTagCallable() {
    return stub.updatePolicyTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all policy tags in a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   ListPolicyTagsRequest request = ListPolicyTagsRequest.newBuilder().build();
   *   ListPolicyTagsResponse response = policyTagManagerClient.listPolicyTags(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPolicyTagsResponse listPolicyTags(ListPolicyTagsRequest request) {
    return listPolicyTagsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all policy tags in a taxonomy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   ListPolicyTagsRequest request = ListPolicyTagsRequest.newBuilder().build();
   *   ApiFuture&lt;ListPolicyTagsResponse&gt; future = policyTagManagerClient.listPolicyTagsCallable().futureCall(request);
   *   // Do something
   *   ListPolicyTagsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListPolicyTagsRequest, ListPolicyTagsResponse>
      listPolicyTagsCallable() {
    return stub.listPolicyTagsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a policy tag.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   GetPolicyTagRequest request = GetPolicyTagRequest.newBuilder().build();
   *   PolicyTag response = policyTagManagerClient.getPolicyTag(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PolicyTag getPolicyTag(GetPolicyTagRequest request) {
    return getPolicyTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a policy tag.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   GetPolicyTagRequest request = GetPolicyTagRequest.newBuilder().build();
   *   ApiFuture&lt;PolicyTag&gt; future = policyTagManagerClient.getPolicyTagCallable().futureCall(request);
   *   // Do something
   *   PolicyTag response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetPolicyTagRequest, PolicyTag> getPolicyTagCallable() {
    return stub.getPolicyTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the IAM policy for a taxonomy or a policy tag.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().build();
   *   Policy response = policyTagManagerClient.getIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the IAM policy for a taxonomy or a policy tag.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().build();
   *   ApiFuture&lt;Policy&gt; future = policyTagManagerClient.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the IAM policy for a taxonomy or a policy tag.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder().build();
   *   Policy response = policyTagManagerClient.setIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the IAM policy for a taxonomy or a policy tag.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder().build();
   *   ApiFuture&lt;Policy&gt; future = policyTagManagerClient.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the permissions that a caller has on the specified taxonomy or policy tag.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsResponse response = policyTagManagerClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the permissions that a caller has on the specified taxonomy or policy tag.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder().build();
   *   ApiFuture&lt;TestIamPermissionsResponse&gt; future = policyTagManagerClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestIamPermissionsResponse response = future.get();
   * }
   * </code></pre>
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
}
