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
import com.google.cloud.compute.v1.stub.ResourcePoliciesStub;
import com.google.cloud.compute.v1.stub.ResourcePoliciesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The ResourcePolicies API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String resourcePolicy = "";
 *   Operation response = resourcePoliciesClient.delete(project, region, resourcePolicy);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the resourcePoliciesClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of ResourcePoliciesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ResourcePoliciesSettings resourcePoliciesSettings =
 *     ResourcePoliciesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ResourcePoliciesClient resourcePoliciesClient =
 *     ResourcePoliciesClient.create(resourcePoliciesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ResourcePoliciesSettings resourcePoliciesSettings =
 *     ResourcePoliciesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ResourcePoliciesClient resourcePoliciesClient =
 *     ResourcePoliciesClient.create(resourcePoliciesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ResourcePoliciesClient implements BackgroundResource {
  private final ResourcePoliciesSettings settings;
  private final ResourcePoliciesStub stub;

  /** Constructs an instance of ResourcePoliciesClient with default settings. */
  public static final ResourcePoliciesClient create() throws IOException {
    return create(ResourcePoliciesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ResourcePoliciesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ResourcePoliciesClient create(ResourcePoliciesSettings settings)
      throws IOException {
    return new ResourcePoliciesClient(settings);
  }

  /**
   * Constructs an instance of ResourcePoliciesClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use ResourcePoliciesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ResourcePoliciesClient create(ResourcePoliciesStub stub) {
    return new ResourcePoliciesClient(stub);
  }

  /**
   * Constructs an instance of ResourcePoliciesClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ResourcePoliciesClient(ResourcePoliciesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ResourcePoliciesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ResourcePoliciesClient(ResourcePoliciesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ResourcePoliciesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ResourcePoliciesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of resource policies.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, ResourcePoliciesScopedList&gt; element : resourcePoliciesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListResourcePoliciesRequest request =
        AggregatedListResourcePoliciesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of resource policies.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   AggregatedListResourcePoliciesRequest request = AggregatedListResourcePoliciesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, ResourcePoliciesScopedList&gt; element : resourcePoliciesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListResourcePoliciesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of resource policies.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   AggregatedListResourcePoliciesRequest request = AggregatedListResourcePoliciesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = resourcePoliciesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, ResourcePoliciesScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListResourcePoliciesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of resource policies.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   AggregatedListResourcePoliciesRequest request = AggregatedListResourcePoliciesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     ResourcePolicyAggregatedList response = resourcePoliciesClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, ResourcePoliciesScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListResourcePoliciesRequest, ResourcePolicyAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resourcePolicy = "";
   *   Operation response = resourcePoliciesClient.delete(project, region, resourcePolicy);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param resourcePolicy Name of the resource policy to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String resourcePolicy) {
    DeleteResourcePolicyRequest request =
        DeleteResourcePolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResourcePolicy(resourcePolicy)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resourcePolicy = "";
   *   DeleteResourcePolicyRequest request = DeleteResourcePolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResourcePolicy(resourcePolicy)
   *     .build();
   *   Operation response = resourcePoliciesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteResourcePolicyRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resourcePolicy = "";
   *   DeleteResourcePolicyRequest request = DeleteResourcePolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResourcePolicy(resourcePolicy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = resourcePoliciesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteResourcePolicyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves all information of the specified resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resourcePolicy = "";
   *   ResourcePolicy response = resourcePoliciesClient.get(project, region, resourcePolicy);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param resourcePolicy Name of the resource policy to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourcePolicy get(String project, String region, String resourcePolicy) {
    GetResourcePolicyRequest request =
        GetResourcePolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResourcePolicy(resourcePolicy)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves all information of the specified resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resourcePolicy = "";
   *   GetResourcePolicyRequest request = GetResourcePolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResourcePolicy(resourcePolicy)
   *     .build();
   *   ResourcePolicy response = resourcePoliciesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourcePolicy get(GetResourcePolicyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves all information of the specified resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resourcePolicy = "";
   *   GetResourcePolicyRequest request = GetResourcePolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResourcePolicy(resourcePolicy)
   *     .build();
   *   ApiFuture&lt;ResourcePolicy&gt; future = resourcePoliciesClient.getCallable().futureCall(request);
   *   // Do something
   *   ResourcePolicy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetResourcePolicyRequest, ResourcePolicy> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   Policy response = resourcePoliciesClient.getIamPolicy(project, region, resource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String project, String region, String resource) {
    GetIamPolicyResourcePolicyRequest request =
        GetIamPolicyResourcePolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   GetIamPolicyResourcePolicyRequest request = GetIamPolicyResourcePolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .build();
   *   Policy response = resourcePoliciesClient.getIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyResourcePolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   GetIamPolicyResourcePolicyRequest request = GetIamPolicyResourcePolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = resourcePoliciesClient.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIamPolicyResourcePolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ResourcePolicy resourcePolicyResource = ResourcePolicy.newBuilder().build();
   *   Operation response = resourcePoliciesClient.insert(project, region, resourcePolicyResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param resourcePolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(
      String project, String region, ResourcePolicy resourcePolicyResource) {
    InsertResourcePolicyRequest request =
        InsertResourcePolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResourcePolicyResource(resourcePolicyResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ResourcePolicy resourcePolicyResource = ResourcePolicy.newBuilder().build();
   *   InsertResourcePolicyRequest request = InsertResourcePolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResourcePolicyResource(resourcePolicyResource)
   *     .build();
   *   Operation response = resourcePoliciesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertResourcePolicyRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new resource policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ResourcePolicy resourcePolicyResource = ResourcePolicy.newBuilder().build();
   *   InsertResourcePolicyRequest request = InsertResourcePolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResourcePolicyResource(resourcePolicyResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = resourcePoliciesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertResourcePolicyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * A list all the resource policies that have been configured for the specified project in
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (ResourcePolicy element : resourcePoliciesClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListResourcePoliciesRequest request =
        ListResourcePoliciesRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * A list all the resource policies that have been configured for the specified project in
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListResourcePoliciesRequest request = ListResourcePoliciesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (ResourcePolicy element : resourcePoliciesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListResourcePoliciesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * A list all the resource policies that have been configured for the specified project in
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListResourcePoliciesRequest request = ListResourcePoliciesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = resourcePoliciesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (ResourcePolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListResourcePoliciesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * A list all the resource policies that have been configured for the specified project in
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListResourcePoliciesRequest request = ListResourcePoliciesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     ResourcePolicyList response = resourcePoliciesClient.listCallable().call(request);
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
  public final UnaryCallable<ListResourcePoliciesRequest, ResourcePolicyList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   Policy response = resourcePoliciesClient.setIamPolicy(project, region, resource, regionSetPolicyRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @param regionSetPolicyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(
      String project,
      String region,
      String resource,
      RegionSetPolicyRequest regionSetPolicyRequestResource) {
    SetIamPolicyResourcePolicyRequest request =
        SetIamPolicyResourcePolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   String resource = "";
   *   SetIamPolicyResourcePolicyRequest request = SetIamPolicyResourcePolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
   *     .setResource(resource)
   *     .build();
   *   Policy response = resourcePoliciesClient.setIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyResourcePolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   String resource = "";
   *   SetIamPolicyResourcePolicyRequest request = SetIamPolicyResourcePolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = resourcePoliciesClient.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetIamPolicyResourcePolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = resourcePoliciesClient.testIamPermissions(project, region, resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project,
      String region,
      String resource,
      TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsResourcePolicyRequest request =
        TestIamPermissionsResourcePolicyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsResourcePolicyRequest request = TestIamPermissionsResourcePolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = resourcePoliciesClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsResourcePolicyRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ResourcePoliciesClient resourcePoliciesClient = ResourcePoliciesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsResourcePolicyRequest request = TestIamPermissionsResourcePolicyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = resourcePoliciesClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TestIamPermissionsResourcePolicyRequest, TestPermissionsResponse>
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

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListResourcePoliciesRequest,
          ResourcePolicyAggregatedList,
          Entry<String, ResourcePoliciesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListResourcePoliciesRequest,
                ResourcePolicyAggregatedList,
                Entry<String, ResourcePoliciesScopedList>>
            context,
        ApiFuture<ResourcePolicyAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListPage, AggregatedListPagedResponse>() {
            @Override
            public AggregatedListPagedResponse apply(AggregatedListPage input) {
              return new AggregatedListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListPagedResponse(AggregatedListPage page) {
      super(page, AggregatedListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPage
      extends AbstractPage<
          AggregatedListResourcePoliciesRequest,
          ResourcePolicyAggregatedList,
          Entry<String, ResourcePoliciesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListResourcePoliciesRequest,
                ResourcePolicyAggregatedList,
                Entry<String, ResourcePoliciesScopedList>>
            context,
        ResourcePolicyAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListResourcePoliciesRequest,
                ResourcePolicyAggregatedList,
                Entry<String, ResourcePoliciesScopedList>>
            context,
        ResourcePolicyAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListResourcePoliciesRequest,
                ResourcePolicyAggregatedList,
                Entry<String, ResourcePoliciesScopedList>>
            context,
        ApiFuture<ResourcePolicyAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListResourcePoliciesRequest,
          ResourcePolicyAggregatedList,
          Entry<String, ResourcePoliciesScopedList>,
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
          ListResourcePoliciesRequest,
          ResourcePolicyList,
          ResourcePolicy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListResourcePoliciesRequest, ResourcePolicyList, ResourcePolicy> context,
        ApiFuture<ResourcePolicyList> futureResponse) {
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
          ListResourcePoliciesRequest, ResourcePolicyList, ResourcePolicy, ListPage> {

    private ListPage(
        PageContext<ListResourcePoliciesRequest, ResourcePolicyList, ResourcePolicy> context,
        ResourcePolicyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListResourcePoliciesRequest, ResourcePolicyList, ResourcePolicy> context,
        ResourcePolicyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListResourcePoliciesRequest, ResourcePolicyList, ResourcePolicy> context,
        ApiFuture<ResourcePolicyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListResourcePoliciesRequest,
          ResourcePolicyList,
          ResourcePolicy,
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
