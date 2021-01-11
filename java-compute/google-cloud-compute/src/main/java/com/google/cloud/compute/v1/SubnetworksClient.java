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
import com.google.cloud.compute.v1.stub.SubnetworksStub;
import com.google.cloud.compute.v1.stub.SubnetworksStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The Subnetworks API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String subnetwork = "";
 *   Operation response = subnetworksClient.delete(project, region, subnetwork);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the subnetworksClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of SubnetworksSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * SubnetworksSettings subnetworksSettings =
 *     SubnetworksSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SubnetworksClient subnetworksClient =
 *     SubnetworksClient.create(subnetworksSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * SubnetworksSettings subnetworksSettings =
 *     SubnetworksSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SubnetworksClient subnetworksClient =
 *     SubnetworksClient.create(subnetworksSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class SubnetworksClient implements BackgroundResource {
  private final SubnetworksSettings settings;
  private final SubnetworksStub stub;

  /** Constructs an instance of SubnetworksClient with default settings. */
  public static final SubnetworksClient create() throws IOException {
    return create(SubnetworksSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SubnetworksClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SubnetworksClient create(SubnetworksSettings settings) throws IOException {
    return new SubnetworksClient(settings);
  }

  /**
   * Constructs an instance of SubnetworksClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use SubnetworksSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final SubnetworksClient create(SubnetworksStub stub) {
    return new SubnetworksClient(stub);
  }

  /**
   * Constructs an instance of SubnetworksClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SubnetworksClient(SubnetworksSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SubnetworksStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected SubnetworksClient(SubnetworksStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SubnetworksSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SubnetworksStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of subnetworks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, SubnetworksScopedList&gt; element : subnetworksClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListSubnetworksRequest request =
        AggregatedListSubnetworksRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of subnetworks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   AggregatedListSubnetworksRequest request = AggregatedListSubnetworksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, SubnetworksScopedList&gt; element : subnetworksClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListSubnetworksRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of subnetworks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   AggregatedListSubnetworksRequest request = AggregatedListSubnetworksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = subnetworksClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, SubnetworksScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListSubnetworksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of subnetworks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   AggregatedListSubnetworksRequest request = AggregatedListSubnetworksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     SubnetworkAggregatedList response = subnetworksClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, SubnetworksScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListSubnetworksRequest, SubnetworkAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified subnetwork.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String subnetwork = "";
   *   Operation response = subnetworksClient.delete(project, region, subnetwork);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param subnetwork Name of the Subnetwork resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String subnetwork) {
    DeleteSubnetworkRequest request =
        DeleteSubnetworkRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setSubnetwork(subnetwork)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified subnetwork.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String subnetwork = "";
   *   DeleteSubnetworkRequest request = DeleteSubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setSubnetwork(subnetwork)
   *     .build();
   *   Operation response = subnetworksClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteSubnetworkRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified subnetwork.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String subnetwork = "";
   *   DeleteSubnetworkRequest request = DeleteSubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setSubnetwork(subnetwork)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = subnetworksClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteSubnetworkRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Expands the IP CIDR range of the subnetwork to a specified value.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String subnetwork = "";
   *   SubnetworksExpandIpCidrRangeRequest subnetworksExpandIpCidrRangeRequestResource = SubnetworksExpandIpCidrRangeRequest.newBuilder().build();
   *   Operation response = subnetworksClient.expandIpCidrRange(project, region, subnetwork, subnetworksExpandIpCidrRangeRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param subnetwork Name of the Subnetwork resource to update.
   * @param subnetworksExpandIpCidrRangeRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation expandIpCidrRange(
      String project,
      String region,
      String subnetwork,
      SubnetworksExpandIpCidrRangeRequest subnetworksExpandIpCidrRangeRequestResource) {
    ExpandIpCidrRangeSubnetworkRequest request =
        ExpandIpCidrRangeSubnetworkRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setSubnetwork(subnetwork)
            .setSubnetworksExpandIpCidrRangeRequestResource(
                subnetworksExpandIpCidrRangeRequestResource)
            .build();
    return expandIpCidrRange(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Expands the IP CIDR range of the subnetwork to a specified value.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String subnetwork = "";
   *   SubnetworksExpandIpCidrRangeRequest subnetworksExpandIpCidrRangeRequestResource = SubnetworksExpandIpCidrRangeRequest.newBuilder().build();
   *   ExpandIpCidrRangeSubnetworkRequest request = ExpandIpCidrRangeSubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setSubnetwork(subnetwork)
   *     .setSubnetworksExpandIpCidrRangeRequestResource(subnetworksExpandIpCidrRangeRequestResource)
   *     .build();
   *   Operation response = subnetworksClient.expandIpCidrRange(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation expandIpCidrRange(ExpandIpCidrRangeSubnetworkRequest request) {
    return expandIpCidrRangeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Expands the IP CIDR range of the subnetwork to a specified value.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String subnetwork = "";
   *   SubnetworksExpandIpCidrRangeRequest subnetworksExpandIpCidrRangeRequestResource = SubnetworksExpandIpCidrRangeRequest.newBuilder().build();
   *   ExpandIpCidrRangeSubnetworkRequest request = ExpandIpCidrRangeSubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setSubnetwork(subnetwork)
   *     .setSubnetworksExpandIpCidrRangeRequestResource(subnetworksExpandIpCidrRangeRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = subnetworksClient.expandIpCidrRangeCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ExpandIpCidrRangeSubnetworkRequest, Operation>
      expandIpCidrRangeCallable() {
    return stub.expandIpCidrRangeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified subnetwork. Gets a list of available subnetworks list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String subnetwork = "";
   *   Subnetwork response = subnetworksClient.get(project, region, subnetwork);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param subnetwork Name of the Subnetwork resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subnetwork get(String project, String region, String subnetwork) {
    GetSubnetworkRequest request =
        GetSubnetworkRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setSubnetwork(subnetwork)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified subnetwork. Gets a list of available subnetworks list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String subnetwork = "";
   *   GetSubnetworkRequest request = GetSubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setSubnetwork(subnetwork)
   *     .build();
   *   Subnetwork response = subnetworksClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subnetwork get(GetSubnetworkRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified subnetwork. Gets a list of available subnetworks list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String subnetwork = "";
   *   GetSubnetworkRequest request = GetSubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setSubnetwork(subnetwork)
   *     .build();
   *   ApiFuture&lt;Subnetwork&gt; future = subnetworksClient.getCallable().futureCall(request);
   *   // Do something
   *   Subnetwork response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetSubnetworkRequest, Subnetwork> getCallable() {
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
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   Policy response = subnetworksClient.getIamPolicy(project, region, resource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String project, String region, String resource) {
    GetIamPolicySubnetworkRequest request =
        GetIamPolicySubnetworkRequest.newBuilder()
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
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   GetIamPolicySubnetworkRequest request = GetIamPolicySubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .build();
   *   Policy response = subnetworksClient.getIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicySubnetworkRequest request) {
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
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   GetIamPolicySubnetworkRequest request = GetIamPolicySubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = subnetworksClient.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIamPolicySubnetworkRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a subnetwork in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   Subnetwork subnetworkResource = Subnetwork.newBuilder().build();
   *   Operation response = subnetworksClient.insert(project, region, subnetworkResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param subnetworkResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, String region, Subnetwork subnetworkResource) {
    InsertSubnetworkRequest request =
        InsertSubnetworkRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setSubnetworkResource(subnetworkResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a subnetwork in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   Subnetwork subnetworkResource = Subnetwork.newBuilder().build();
   *   InsertSubnetworkRequest request = InsertSubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setSubnetworkResource(subnetworkResource)
   *     .build();
   *   Operation response = subnetworksClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertSubnetworkRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a subnetwork in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   Subnetwork subnetworkResource = Subnetwork.newBuilder().build();
   *   InsertSubnetworkRequest request = InsertSubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setSubnetworkResource(subnetworkResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = subnetworksClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertSubnetworkRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of subnetworks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (Subnetwork element : subnetworksClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListSubnetworksRequest request =
        ListSubnetworksRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of subnetworks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListSubnetworksRequest request = ListSubnetworksRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (Subnetwork element : subnetworksClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListSubnetworksRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of subnetworks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListSubnetworksRequest request = ListSubnetworksRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = subnetworksClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (Subnetwork element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListSubnetworksRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of subnetworks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListSubnetworksRequest request = ListSubnetworksRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     SubnetworkList response = subnetworksClient.listCallable().call(request);
   *     for (Subnetwork element : response.getItemsList()) {
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
  public final UnaryCallable<ListSubnetworksRequest, SubnetworkList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of all usable subnetworks in the project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   for (UsableSubnetwork element : subnetworksClient.listUsable(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUsablePagedResponse listUsable(String project) {
    ListUsableSubnetworksRequest request =
        ListUsableSubnetworksRequest.newBuilder().setProject(project).build();
    return listUsable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of all usable subnetworks in the project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   ListUsableSubnetworksRequest request = ListUsableSubnetworksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (UsableSubnetwork element : subnetworksClient.listUsable(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUsablePagedResponse listUsable(ListUsableSubnetworksRequest request) {
    return listUsablePagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of all usable subnetworks in the project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   ListUsableSubnetworksRequest request = ListUsableSubnetworksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListUsablePagedResponse&gt; future = subnetworksClient.listUsablePagedCallable().futureCall(request);
   *   // Do something
   *   for (UsableSubnetwork element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListUsableSubnetworksRequest, ListUsablePagedResponse>
      listUsablePagedCallable() {
    return stub.listUsablePagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of all usable subnetworks in the project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   ListUsableSubnetworksRequest request = ListUsableSubnetworksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     UsableSubnetworksAggregatedList response = subnetworksClient.listUsableCallable().call(request);
   *     for (UsableSubnetwork element : response.getItemsList()) {
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
  public final UnaryCallable<ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList>
      listUsableCallable() {
    return stub.listUsableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified subnetwork with the data included in the request. Only certain fields can
   * be updated with a patch request as indicated in the field descriptions. You must specify the
   * current fingerprint of the subnetwork resource being patched.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String subnetwork = "";
   *   Subnetwork subnetworkResource = Subnetwork.newBuilder().build();
   *   Operation response = subnetworksClient.patch(project, region, subnetwork, subnetworkResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param subnetwork Name of the Subnetwork resource to patch.
   * @param subnetworkResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
      String project, String region, String subnetwork, Subnetwork subnetworkResource) {
    PatchSubnetworkRequest request =
        PatchSubnetworkRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setSubnetwork(subnetwork)
            .setSubnetworkResource(subnetworkResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified subnetwork with the data included in the request. Only certain fields can
   * be updated with a patch request as indicated in the field descriptions. You must specify the
   * current fingerprint of the subnetwork resource being patched.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String subnetwork = "";
   *   Subnetwork subnetworkResource = Subnetwork.newBuilder().build();
   *   PatchSubnetworkRequest request = PatchSubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setSubnetwork(subnetwork)
   *     .setSubnetworkResource(subnetworkResource)
   *     .build();
   *   Operation response = subnetworksClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchSubnetworkRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified subnetwork with the data included in the request. Only certain fields can
   * be updated with a patch request as indicated in the field descriptions. You must specify the
   * current fingerprint of the subnetwork resource being patched.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String subnetwork = "";
   *   Subnetwork subnetworkResource = Subnetwork.newBuilder().build();
   *   PatchSubnetworkRequest request = PatchSubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setSubnetwork(subnetwork)
   *     .setSubnetworkResource(subnetworkResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = subnetworksClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchSubnetworkRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   Policy response = subnetworksClient.setIamPolicy(project, region, resource, regionSetPolicyRequestResource);
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
    SetIamPolicySubnetworkRequest request =
        SetIamPolicySubnetworkRequest.newBuilder()
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
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   String resource = "";
   *   SetIamPolicySubnetworkRequest request = SetIamPolicySubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
   *     .setResource(resource)
   *     .build();
   *   Policy response = subnetworksClient.setIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicySubnetworkRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   String resource = "";
   *   SetIamPolicySubnetworkRequest request = SetIamPolicySubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = subnetworksClient.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetIamPolicySubnetworkRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Set whether VMs in this subnet can access Google services without assigning external IP
   * addresses through Private Google Access.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String subnetwork = "";
   *   SubnetworksSetPrivateIpGoogleAccessRequest subnetworksSetPrivateIpGoogleAccessRequestResource = SubnetworksSetPrivateIpGoogleAccessRequest.newBuilder().build();
   *   Operation response = subnetworksClient.setPrivateIpGoogleAccess(project, region, subnetwork, subnetworksSetPrivateIpGoogleAccessRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param subnetwork Name of the Subnetwork resource.
   * @param subnetworksSetPrivateIpGoogleAccessRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setPrivateIpGoogleAccess(
      String project,
      String region,
      String subnetwork,
      SubnetworksSetPrivateIpGoogleAccessRequest
          subnetworksSetPrivateIpGoogleAccessRequestResource) {
    SetPrivateIpGoogleAccessSubnetworkRequest request =
        SetPrivateIpGoogleAccessSubnetworkRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setSubnetwork(subnetwork)
            .setSubnetworksSetPrivateIpGoogleAccessRequestResource(
                subnetworksSetPrivateIpGoogleAccessRequestResource)
            .build();
    return setPrivateIpGoogleAccess(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Set whether VMs in this subnet can access Google services without assigning external IP
   * addresses through Private Google Access.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String subnetwork = "";
   *   SubnetworksSetPrivateIpGoogleAccessRequest subnetworksSetPrivateIpGoogleAccessRequestResource = SubnetworksSetPrivateIpGoogleAccessRequest.newBuilder().build();
   *   SetPrivateIpGoogleAccessSubnetworkRequest request = SetPrivateIpGoogleAccessSubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setSubnetwork(subnetwork)
   *     .setSubnetworksSetPrivateIpGoogleAccessRequestResource(subnetworksSetPrivateIpGoogleAccessRequestResource)
   *     .build();
   *   Operation response = subnetworksClient.setPrivateIpGoogleAccess(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setPrivateIpGoogleAccess(
      SetPrivateIpGoogleAccessSubnetworkRequest request) {
    return setPrivateIpGoogleAccessCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Set whether VMs in this subnet can access Google services without assigning external IP
   * addresses through Private Google Access.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String subnetwork = "";
   *   SubnetworksSetPrivateIpGoogleAccessRequest subnetworksSetPrivateIpGoogleAccessRequestResource = SubnetworksSetPrivateIpGoogleAccessRequest.newBuilder().build();
   *   SetPrivateIpGoogleAccessSubnetworkRequest request = SetPrivateIpGoogleAccessSubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setSubnetwork(subnetwork)
   *     .setSubnetworksSetPrivateIpGoogleAccessRequestResource(subnetworksSetPrivateIpGoogleAccessRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = subnetworksClient.setPrivateIpGoogleAccessCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>
      setPrivateIpGoogleAccessCallable() {
    return stub.setPrivateIpGoogleAccessCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = subnetworksClient.testIamPermissions(project, region, resource, testPermissionsRequestResource);
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
    TestIamPermissionsSubnetworkRequest request =
        TestIamPermissionsSubnetworkRequest.newBuilder()
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
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsSubnetworkRequest request = TestIamPermissionsSubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = subnetworksClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsSubnetworkRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworksClient subnetworksClient = SubnetworksClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsSubnetworkRequest request = TestIamPermissionsSubnetworkRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = subnetworksClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>
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
          AggregatedListSubnetworksRequest,
          SubnetworkAggregatedList,
          Entry<String, SubnetworksScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListSubnetworksRequest,
                SubnetworkAggregatedList,
                Entry<String, SubnetworksScopedList>>
            context,
        ApiFuture<SubnetworkAggregatedList> futureResponse) {
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
          AggregatedListSubnetworksRequest,
          SubnetworkAggregatedList,
          Entry<String, SubnetworksScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListSubnetworksRequest,
                SubnetworkAggregatedList,
                Entry<String, SubnetworksScopedList>>
            context,
        SubnetworkAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListSubnetworksRequest,
                SubnetworkAggregatedList,
                Entry<String, SubnetworksScopedList>>
            context,
        SubnetworkAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListSubnetworksRequest,
                SubnetworkAggregatedList,
                Entry<String, SubnetworksScopedList>>
            context,
        ApiFuture<SubnetworkAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListSubnetworksRequest,
          SubnetworkAggregatedList,
          Entry<String, SubnetworksScopedList>,
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
          ListSubnetworksRequest, SubnetworkList, Subnetwork, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListSubnetworksRequest, SubnetworkList, Subnetwork> context,
        ApiFuture<SubnetworkList> futureResponse) {
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
      extends AbstractPage<ListSubnetworksRequest, SubnetworkList, Subnetwork, ListPage> {

    private ListPage(
        PageContext<ListSubnetworksRequest, SubnetworkList, Subnetwork> context,
        SubnetworkList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListSubnetworksRequest, SubnetworkList, Subnetwork> context,
        SubnetworkList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListSubnetworksRequest, SubnetworkList, Subnetwork> context,
        ApiFuture<SubnetworkList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSubnetworksRequest, SubnetworkList, Subnetwork, ListPage, ListFixedSizeCollection> {

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

  public static class ListUsablePagedResponse
      extends AbstractPagedListResponse<
          ListUsableSubnetworksRequest,
          UsableSubnetworksAggregatedList,
          UsableSubnetwork,
          ListUsablePage,
          ListUsableFixedSizeCollection> {

    public static ApiFuture<ListUsablePagedResponse> createAsync(
        PageContext<ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList, UsableSubnetwork>
            context,
        ApiFuture<UsableSubnetworksAggregatedList> futureResponse) {
      ApiFuture<ListUsablePage> futurePage =
          ListUsablePage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListUsablePage, ListUsablePagedResponse>() {
            @Override
            public ListUsablePagedResponse apply(ListUsablePage input) {
              return new ListUsablePagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListUsablePagedResponse(ListUsablePage page) {
      super(page, ListUsableFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUsablePage
      extends AbstractPage<
          ListUsableSubnetworksRequest,
          UsableSubnetworksAggregatedList,
          UsableSubnetwork,
          ListUsablePage> {

    private ListUsablePage(
        PageContext<ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList, UsableSubnetwork>
            context,
        UsableSubnetworksAggregatedList response) {
      super(context, response);
    }

    private static ListUsablePage createEmptyPage() {
      return new ListUsablePage(null, null);
    }

    @Override
    protected ListUsablePage createPage(
        PageContext<ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList, UsableSubnetwork>
            context,
        UsableSubnetworksAggregatedList response) {
      return new ListUsablePage(context, response);
    }

    @Override
    public ApiFuture<ListUsablePage> createPageAsync(
        PageContext<ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList, UsableSubnetwork>
            context,
        ApiFuture<UsableSubnetworksAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUsableFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUsableSubnetworksRequest,
          UsableSubnetworksAggregatedList,
          UsableSubnetwork,
          ListUsablePage,
          ListUsableFixedSizeCollection> {

    private ListUsableFixedSizeCollection(List<ListUsablePage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUsableFixedSizeCollection createEmptyCollection() {
      return new ListUsableFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUsableFixedSizeCollection createCollection(
        List<ListUsablePage> pages, int collectionSize) {
      return new ListUsableFixedSizeCollection(pages, collectionSize);
    }
  }
}
