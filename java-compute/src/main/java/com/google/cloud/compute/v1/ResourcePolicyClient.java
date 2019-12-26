/*
 * Copyright 2019 Google LLC
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
import com.google.cloud.compute.v1.stub.ResourcePolicyStub;
import com.google.cloud.compute.v1.stub.ResourcePolicyStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
 *   ProjectRegionResourcePolicyName resourcePolicy = ProjectRegionResourcePolicyName.of("[PROJECT]", "[REGION]", "[RESOURCE_POLICY]");
 *   Operation response = resourcePolicyClient.deleteResourcePolicy(resourcePolicy);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the resourcePolicyClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of ResourcePolicySettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ResourcePolicySettings resourcePolicySettings =
 *     ResourcePolicySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ResourcePolicyClient resourcePolicyClient =
 *     ResourcePolicyClient.create(resourcePolicySettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ResourcePolicySettings resourcePolicySettings =
 *     ResourcePolicySettings.newBuilder().setEndpoint(myEndpoint).build();
 * ResourcePolicyClient resourcePolicyClient =
 *     ResourcePolicyClient.create(resourcePolicySettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ResourcePolicyClient implements BackgroundResource {
  private final ResourcePolicySettings settings;
  private final ResourcePolicyStub stub;

  /** Constructs an instance of ResourcePolicyClient with default settings. */
  public static final ResourcePolicyClient create() throws IOException {
    return create(ResourcePolicySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ResourcePolicyClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ResourcePolicyClient create(ResourcePolicySettings settings)
      throws IOException {
    return new ResourcePolicyClient(settings);
  }

  /**
   * Constructs an instance of ResourcePolicyClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use ResourcePolicySettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ResourcePolicyClient create(ResourcePolicyStub stub) {
    return new ResourcePolicyClient(stub);
  }

  /**
   * Constructs an instance of ResourcePolicyClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ResourcePolicyClient(ResourcePolicySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ResourcePolicyStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ResourcePolicyClient(ResourcePolicyStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ResourcePolicySettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ResourcePolicyStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of resource policies.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (ResourcePoliciesScopedList element : resourcePolicyClient.aggregatedListResourcePolicies(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListResourcePoliciesPagedResponse aggregatedListResourcePolicies(
      ProjectName project) {
    AggregatedListResourcePoliciesHttpRequest request =
        AggregatedListResourcePoliciesHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListResourcePolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of resource policies.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (ResourcePoliciesScopedList element : resourcePolicyClient.aggregatedListResourcePolicies(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListResourcePoliciesPagedResponse aggregatedListResourcePolicies(
      String project) {
    AggregatedListResourcePoliciesHttpRequest request =
        AggregatedListResourcePoliciesHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListResourcePolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of resource policies.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListResourcePoliciesHttpRequest request = AggregatedListResourcePoliciesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   for (ResourcePoliciesScopedList element : resourcePolicyClient.aggregatedListResourcePolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListResourcePoliciesPagedResponse aggregatedListResourcePolicies(
      AggregatedListResourcePoliciesHttpRequest request) {
    return aggregatedListResourcePoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of resource policies.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListResourcePoliciesHttpRequest request = AggregatedListResourcePoliciesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   ApiFuture&lt;AggregatedListResourcePoliciesPagedResponse&gt; future = resourcePolicyClient.aggregatedListResourcePoliciesPagedCallable().futureCall(request);
   *   // Do something
   *   for (ResourcePoliciesScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListResourcePoliciesHttpRequest, AggregatedListResourcePoliciesPagedResponse>
      aggregatedListResourcePoliciesPagedCallable() {
    return stub.aggregatedListResourcePoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of resource policies.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListResourcePoliciesHttpRequest request = AggregatedListResourcePoliciesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   while (true) {
   *     ResourcePolicyAggregatedList response = resourcePolicyClient.aggregatedListResourcePoliciesCallable().call(request);
   *     for (ResourcePoliciesScopedList element : response.getItemsMap()) {
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
  @BetaApi
  public final UnaryCallable<
          AggregatedListResourcePoliciesHttpRequest, ResourcePolicyAggregatedList>
      aggregatedListResourcePoliciesCallable() {
    return stub.aggregatedListResourcePoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   ProjectRegionResourcePolicyName resourcePolicy = ProjectRegionResourcePolicyName.of("[PROJECT]", "[REGION]", "[RESOURCE_POLICY]");
   *   Operation response = resourcePolicyClient.deleteResourcePolicy(resourcePolicy);
   * }
   * </code></pre>
   *
   * @param resourcePolicy Name of the resource policy to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteResourcePolicy(ProjectRegionResourcePolicyName resourcePolicy) {

    DeleteResourcePolicyHttpRequest request =
        DeleteResourcePolicyHttpRequest.newBuilder()
            .setResourcePolicy(resourcePolicy == null ? null : resourcePolicy.toString())
            .build();
    return deleteResourcePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   ProjectRegionResourcePolicyName resourcePolicy = ProjectRegionResourcePolicyName.of("[PROJECT]", "[REGION]", "[RESOURCE_POLICY]");
   *   Operation response = resourcePolicyClient.deleteResourcePolicy(resourcePolicy.toString());
   * }
   * </code></pre>
   *
   * @param resourcePolicy Name of the resource policy to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteResourcePolicy(String resourcePolicy) {

    DeleteResourcePolicyHttpRequest request =
        DeleteResourcePolicyHttpRequest.newBuilder().setResourcePolicy(resourcePolicy).build();
    return deleteResourcePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedResourcePolicy = ProjectRegionResourcePolicyName.format("[PROJECT]", "[REGION]", "[RESOURCE_POLICY]");
   *   DeleteResourcePolicyHttpRequest request = DeleteResourcePolicyHttpRequest.newBuilder()
   *     .setResourcePolicy(formattedResourcePolicy)
   *     .build();
   *   Operation response = resourcePolicyClient.deleteResourcePolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteResourcePolicy(DeleteResourcePolicyHttpRequest request) {
    return deleteResourcePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedResourcePolicy = ProjectRegionResourcePolicyName.format("[PROJECT]", "[REGION]", "[RESOURCE_POLICY]");
   *   DeleteResourcePolicyHttpRequest request = DeleteResourcePolicyHttpRequest.newBuilder()
   *     .setResourcePolicy(formattedResourcePolicy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = resourcePolicyClient.deleteResourcePolicyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteResourcePolicyHttpRequest, Operation>
      deleteResourcePolicyCallable() {
    return stub.deleteResourcePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves all information of the specified resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   ProjectRegionResourcePolicyName resourcePolicy = ProjectRegionResourcePolicyName.of("[PROJECT]", "[REGION]", "[RESOURCE_POLICY]");
   *   ResourcePolicy response = resourcePolicyClient.getResourcePolicy(resourcePolicy);
   * }
   * </code></pre>
   *
   * @param resourcePolicy Name of the resource policy to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ResourcePolicy getResourcePolicy(ProjectRegionResourcePolicyName resourcePolicy) {

    GetResourcePolicyHttpRequest request =
        GetResourcePolicyHttpRequest.newBuilder()
            .setResourcePolicy(resourcePolicy == null ? null : resourcePolicy.toString())
            .build();
    return getResourcePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves all information of the specified resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   ProjectRegionResourcePolicyName resourcePolicy = ProjectRegionResourcePolicyName.of("[PROJECT]", "[REGION]", "[RESOURCE_POLICY]");
   *   ResourcePolicy response = resourcePolicyClient.getResourcePolicy(resourcePolicy.toString());
   * }
   * </code></pre>
   *
   * @param resourcePolicy Name of the resource policy to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ResourcePolicy getResourcePolicy(String resourcePolicy) {

    GetResourcePolicyHttpRequest request =
        GetResourcePolicyHttpRequest.newBuilder().setResourcePolicy(resourcePolicy).build();
    return getResourcePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves all information of the specified resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedResourcePolicy = ProjectRegionResourcePolicyName.format("[PROJECT]", "[REGION]", "[RESOURCE_POLICY]");
   *   GetResourcePolicyHttpRequest request = GetResourcePolicyHttpRequest.newBuilder()
   *     .setResourcePolicy(formattedResourcePolicy)
   *     .build();
   *   ResourcePolicy response = resourcePolicyClient.getResourcePolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ResourcePolicy getResourcePolicy(GetResourcePolicyHttpRequest request) {
    return getResourcePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves all information of the specified resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedResourcePolicy = ProjectRegionResourcePolicyName.format("[PROJECT]", "[REGION]", "[RESOURCE_POLICY]");
   *   GetResourcePolicyHttpRequest request = GetResourcePolicyHttpRequest.newBuilder()
   *     .setResourcePolicy(formattedResourcePolicy)
   *     .build();
   *   ApiFuture&lt;ResourcePolicy&gt; future = resourcePolicyClient.getResourcePolicyCallable().futureCall(request);
   *   // Do something
   *   ResourcePolicy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetResourcePolicyHttpRequest, ResourcePolicy>
      getResourcePolicyCallable() {
    return stub.getResourcePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   ProjectRegionResourcePolicyResourceName resource = ProjectRegionResourcePolicyResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   Policy response = resourcePolicyClient.getIamPolicyResourcePolicy(resource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicyResourcePolicy(ProjectRegionResourcePolicyResourceName resource) {

    GetIamPolicyResourcePolicyHttpRequest request =
        GetIamPolicyResourcePolicyHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicyResourcePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   ProjectRegionResourcePolicyResourceName resource = ProjectRegionResourcePolicyResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   Policy response = resourcePolicyClient.getIamPolicyResourcePolicy(resource.toString());
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicyResourcePolicy(String resource) {

    GetIamPolicyResourcePolicyHttpRequest request =
        GetIamPolicyResourcePolicyHttpRequest.newBuilder().setResource(resource).build();
    return getIamPolicyResourcePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedResource = ProjectRegionResourcePolicyResourceName.format("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   GetIamPolicyResourcePolicyHttpRequest request = GetIamPolicyResourcePolicyHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   Policy response = resourcePolicyClient.getIamPolicyResourcePolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicyResourcePolicy(GetIamPolicyResourcePolicyHttpRequest request) {
    return getIamPolicyResourcePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedResource = ProjectRegionResourcePolicyResourceName.format("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   GetIamPolicyResourcePolicyHttpRequest request = GetIamPolicyResourcePolicyHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = resourcePolicyClient.getIamPolicyResourcePolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetIamPolicyResourcePolicyHttpRequest, Policy>
      getIamPolicyResourcePolicyCallable() {
    return stub.getIamPolicyResourcePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ResourcePolicy resourcePolicyResource = ResourcePolicy.newBuilder().build();
   *   Operation response = resourcePolicyClient.insertResourcePolicy(region, resourcePolicyResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @param resourcePolicyResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertResourcePolicy(
      ProjectRegionName region, ResourcePolicy resourcePolicyResource) {

    InsertResourcePolicyHttpRequest request =
        InsertResourcePolicyHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setResourcePolicyResource(resourcePolicyResource)
            .build();
    return insertResourcePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ResourcePolicy resourcePolicyResource = ResourcePolicy.newBuilder().build();
   *   Operation response = resourcePolicyClient.insertResourcePolicy(region.toString(), resourcePolicyResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @param resourcePolicyResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertResourcePolicy(
      String region, ResourcePolicy resourcePolicyResource) {

    InsertResourcePolicyHttpRequest request =
        InsertResourcePolicyHttpRequest.newBuilder()
            .setRegion(region)
            .setResourcePolicyResource(resourcePolicyResource)
            .build();
    return insertResourcePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ResourcePolicy resourcePolicyResource = ResourcePolicy.newBuilder().build();
   *   InsertResourcePolicyHttpRequest request = InsertResourcePolicyHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setResourcePolicyResource(resourcePolicyResource)
   *     .build();
   *   Operation response = resourcePolicyClient.insertResourcePolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertResourcePolicy(InsertResourcePolicyHttpRequest request) {
    return insertResourcePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ResourcePolicy resourcePolicyResource = ResourcePolicy.newBuilder().build();
   *   InsertResourcePolicyHttpRequest request = InsertResourcePolicyHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setResourcePolicyResource(resourcePolicyResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = resourcePolicyClient.insertResourcePolicyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertResourcePolicyHttpRequest, Operation>
      insertResourcePolicyCallable() {
    return stub.insertResourcePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * A list all the resource policies that have been configured for the specified project in
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (ResourcePolicy element : resourcePolicyClient.listResourcePolicies(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListResourcePoliciesPagedResponse listResourcePolicies(ProjectRegionName region) {
    ListResourcePoliciesHttpRequest request =
        ListResourcePoliciesHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listResourcePolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * A list all the resource policies that have been configured for the specified project in
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (ResourcePolicy element : resourcePolicyClient.listResourcePolicies(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListResourcePoliciesPagedResponse listResourcePolicies(String region) {
    ListResourcePoliciesHttpRequest request =
        ListResourcePoliciesHttpRequest.newBuilder().setRegion(region).build();
    return listResourcePolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * A list all the resource policies that have been configured for the specified project in
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListResourcePoliciesHttpRequest request = ListResourcePoliciesHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   for (ResourcePolicy element : resourcePolicyClient.listResourcePolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListResourcePoliciesPagedResponse listResourcePolicies(
      ListResourcePoliciesHttpRequest request) {
    return listResourcePoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * A list all the resource policies that have been configured for the specified project in
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListResourcePoliciesHttpRequest request = ListResourcePoliciesHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   ApiFuture&lt;ListResourcePoliciesPagedResponse&gt; future = resourcePolicyClient.listResourcePoliciesPagedCallable().futureCall(request);
   *   // Do something
   *   for (ResourcePolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListResourcePoliciesHttpRequest, ListResourcePoliciesPagedResponse>
      listResourcePoliciesPagedCallable() {
    return stub.listResourcePoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * A list all the resource policies that have been configured for the specified project in
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListResourcePoliciesHttpRequest request = ListResourcePoliciesHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   while (true) {
   *     ResourcePolicyList response = resourcePolicyClient.listResourcePoliciesCallable().call(request);
   *     for (ResourcePolicy element : response.getItemsList()) {
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
  @BetaApi
  public final UnaryCallable<ListResourcePoliciesHttpRequest, ResourcePolicyList>
      listResourcePoliciesCallable() {
    return stub.listResourcePoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   ProjectRegionResourcePolicyResourceName resource = ProjectRegionResourcePolicyResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   Policy response = resourcePolicyClient.setIamPolicyResourcePolicy(resource, regionSetPolicyRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param regionSetPolicyRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicyResourcePolicy(
      ProjectRegionResourcePolicyResourceName resource,
      RegionSetPolicyRequest regionSetPolicyRequestResource) {

    SetIamPolicyResourcePolicyHttpRequest request =
        SetIamPolicyResourcePolicyHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
            .build();
    return setIamPolicyResourcePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   ProjectRegionResourcePolicyResourceName resource = ProjectRegionResourcePolicyResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   Policy response = resourcePolicyClient.setIamPolicyResourcePolicy(resource.toString(), regionSetPolicyRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param regionSetPolicyRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicyResourcePolicy(
      String resource, RegionSetPolicyRequest regionSetPolicyRequestResource) {

    SetIamPolicyResourcePolicyHttpRequest request =
        SetIamPolicyResourcePolicyHttpRequest.newBuilder()
            .setResource(resource)
            .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
            .build();
    return setIamPolicyResourcePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedResource = ProjectRegionResourcePolicyResourceName.format("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   SetIamPolicyResourcePolicyHttpRequest request = SetIamPolicyResourcePolicyHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
   *     .build();
   *   Policy response = resourcePolicyClient.setIamPolicyResourcePolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicyResourcePolicy(SetIamPolicyResourcePolicyHttpRequest request) {
    return setIamPolicyResourcePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedResource = ProjectRegionResourcePolicyResourceName.format("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   SetIamPolicyResourcePolicyHttpRequest request = SetIamPolicyResourcePolicyHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = resourcePolicyClient.setIamPolicyResourcePolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetIamPolicyResourcePolicyHttpRequest, Policy>
      setIamPolicyResourcePolicyCallable() {
    return stub.setIamPolicyResourcePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   ProjectRegionResourcePolicyResourceName resource = ProjectRegionResourcePolicyResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = resourcePolicyClient.testIamPermissionsResourcePolicy(resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsResourcePolicy(
      ProjectRegionResourcePolicyResourceName resource,
      TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsResourcePolicyHttpRequest request =
        TestIamPermissionsResourcePolicyHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsResourcePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   ProjectRegionResourcePolicyResourceName resource = ProjectRegionResourcePolicyResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = resourcePolicyClient.testIamPermissionsResourcePolicy(resource.toString(), testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsResourcePolicy(
      String resource, TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsResourcePolicyHttpRequest request =
        TestIamPermissionsResourcePolicyHttpRequest.newBuilder()
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsResourcePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedResource = ProjectRegionResourcePolicyResourceName.format("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsResourcePolicyHttpRequest request = TestIamPermissionsResourcePolicyHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = resourcePolicyClient.testIamPermissionsResourcePolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsResourcePolicy(
      TestIamPermissionsResourcePolicyHttpRequest request) {
    return testIamPermissionsResourcePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePolicyClient resourcePolicyClient = ResourcePolicyClient.create()) {
   *   String formattedResource = ProjectRegionResourcePolicyResourceName.format("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsResourcePolicyHttpRequest request = TestIamPermissionsResourcePolicyHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = resourcePolicyClient.testIamPermissionsResourcePolicyCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<TestIamPermissionsResourcePolicyHttpRequest, TestPermissionsResponse>
      testIamPermissionsResourcePolicyCallable() {
    return stub.testIamPermissionsResourcePolicyCallable();
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

  public static class AggregatedListResourcePoliciesPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListResourcePoliciesHttpRequest,
          ResourcePolicyAggregatedList,
          ResourcePoliciesScopedList,
          AggregatedListResourcePoliciesPage,
          AggregatedListResourcePoliciesFixedSizeCollection> {

    public static ApiFuture<AggregatedListResourcePoliciesPagedResponse> createAsync(
        PageContext<
                AggregatedListResourcePoliciesHttpRequest,
                ResourcePolicyAggregatedList,
                ResourcePoliciesScopedList>
            context,
        ApiFuture<ResourcePolicyAggregatedList> futureResponse) {
      ApiFuture<AggregatedListResourcePoliciesPage> futurePage =
          AggregatedListResourcePoliciesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              AggregatedListResourcePoliciesPage, AggregatedListResourcePoliciesPagedResponse>() {
            @Override
            public AggregatedListResourcePoliciesPagedResponse apply(
                AggregatedListResourcePoliciesPage input) {
              return new AggregatedListResourcePoliciesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListResourcePoliciesPagedResponse(AggregatedListResourcePoliciesPage page) {
      super(page, AggregatedListResourcePoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListResourcePoliciesPage
      extends AbstractPage<
          AggregatedListResourcePoliciesHttpRequest,
          ResourcePolicyAggregatedList,
          ResourcePoliciesScopedList,
          AggregatedListResourcePoliciesPage> {

    private AggregatedListResourcePoliciesPage(
        PageContext<
                AggregatedListResourcePoliciesHttpRequest,
                ResourcePolicyAggregatedList,
                ResourcePoliciesScopedList>
            context,
        ResourcePolicyAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListResourcePoliciesPage createEmptyPage() {
      return new AggregatedListResourcePoliciesPage(null, null);
    }

    @Override
    protected AggregatedListResourcePoliciesPage createPage(
        PageContext<
                AggregatedListResourcePoliciesHttpRequest,
                ResourcePolicyAggregatedList,
                ResourcePoliciesScopedList>
            context,
        ResourcePolicyAggregatedList response) {
      return new AggregatedListResourcePoliciesPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListResourcePoliciesPage> createPageAsync(
        PageContext<
                AggregatedListResourcePoliciesHttpRequest,
                ResourcePolicyAggregatedList,
                ResourcePoliciesScopedList>
            context,
        ApiFuture<ResourcePolicyAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListResourcePoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListResourcePoliciesHttpRequest,
          ResourcePolicyAggregatedList,
          ResourcePoliciesScopedList,
          AggregatedListResourcePoliciesPage,
          AggregatedListResourcePoliciesFixedSizeCollection> {

    private AggregatedListResourcePoliciesFixedSizeCollection(
        List<AggregatedListResourcePoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListResourcePoliciesFixedSizeCollection createEmptyCollection() {
      return new AggregatedListResourcePoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListResourcePoliciesFixedSizeCollection createCollection(
        List<AggregatedListResourcePoliciesPage> pages, int collectionSize) {
      return new AggregatedListResourcePoliciesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListResourcePoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListResourcePoliciesHttpRequest,
          ResourcePolicyList,
          ResourcePolicy,
          ListResourcePoliciesPage,
          ListResourcePoliciesFixedSizeCollection> {

    public static ApiFuture<ListResourcePoliciesPagedResponse> createAsync(
        PageContext<ListResourcePoliciesHttpRequest, ResourcePolicyList, ResourcePolicy> context,
        ApiFuture<ResourcePolicyList> futureResponse) {
      ApiFuture<ListResourcePoliciesPage> futurePage =
          ListResourcePoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListResourcePoliciesPage, ListResourcePoliciesPagedResponse>() {
            @Override
            public ListResourcePoliciesPagedResponse apply(ListResourcePoliciesPage input) {
              return new ListResourcePoliciesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListResourcePoliciesPagedResponse(ListResourcePoliciesPage page) {
      super(page, ListResourcePoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListResourcePoliciesPage
      extends AbstractPage<
          ListResourcePoliciesHttpRequest,
          ResourcePolicyList,
          ResourcePolicy,
          ListResourcePoliciesPage> {

    private ListResourcePoliciesPage(
        PageContext<ListResourcePoliciesHttpRequest, ResourcePolicyList, ResourcePolicy> context,
        ResourcePolicyList response) {
      super(context, response);
    }

    private static ListResourcePoliciesPage createEmptyPage() {
      return new ListResourcePoliciesPage(null, null);
    }

    @Override
    protected ListResourcePoliciesPage createPage(
        PageContext<ListResourcePoliciesHttpRequest, ResourcePolicyList, ResourcePolicy> context,
        ResourcePolicyList response) {
      return new ListResourcePoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListResourcePoliciesPage> createPageAsync(
        PageContext<ListResourcePoliciesHttpRequest, ResourcePolicyList, ResourcePolicy> context,
        ApiFuture<ResourcePolicyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListResourcePoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListResourcePoliciesHttpRequest,
          ResourcePolicyList,
          ResourcePolicy,
          ListResourcePoliciesPage,
          ListResourcePoliciesFixedSizeCollection> {

    private ListResourcePoliciesFixedSizeCollection(
        List<ListResourcePoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListResourcePoliciesFixedSizeCollection createEmptyCollection() {
      return new ListResourcePoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListResourcePoliciesFixedSizeCollection createCollection(
        List<ListResourcePoliciesPage> pages, int collectionSize) {
      return new ListResourcePoliciesFixedSizeCollection(pages, collectionSize);
    }
  }
}
