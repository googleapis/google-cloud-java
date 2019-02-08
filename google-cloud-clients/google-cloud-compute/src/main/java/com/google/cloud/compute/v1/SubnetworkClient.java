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
import com.google.cloud.compute.v1.stub.SubnetworkStub;
import com.google.cloud.compute.v1.stub.SubnetworkStubSettings;
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
 * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
 *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
 *   Operation response = subnetworkClient.deleteSubnetwork(subnetwork);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the subnetworkClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of SubnetworkSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * SubnetworkSettings subnetworkSettings =
 *     SubnetworkSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SubnetworkClient subnetworkClient =
 *     SubnetworkClient.create(subnetworkSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * SubnetworkSettings subnetworkSettings =
 *     SubnetworkSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SubnetworkClient subnetworkClient =
 *     SubnetworkClient.create(subnetworkSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class SubnetworkClient implements BackgroundResource {
  private final SubnetworkSettings settings;
  private final SubnetworkStub stub;

  /** Constructs an instance of SubnetworkClient with default settings. */
  public static final SubnetworkClient create() throws IOException {
    return create(SubnetworkSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SubnetworkClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SubnetworkClient create(SubnetworkSettings settings) throws IOException {
    return new SubnetworkClient(settings);
  }

  /**
   * Constructs an instance of SubnetworkClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use SubnetworkSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final SubnetworkClient create(SubnetworkStub stub) {
    return new SubnetworkClient(stub);
  }

  /**
   * Constructs an instance of SubnetworkClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected SubnetworkClient(SubnetworkSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SubnetworkStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected SubnetworkClient(SubnetworkStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SubnetworkSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SubnetworkStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of subnetworks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (SubnetworksScopedList element : subnetworkClient.aggregatedListSubnetworks(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListSubnetworksPagedResponse aggregatedListSubnetworks(
      ProjectName project) {
    AggregatedListSubnetworksHttpRequest request =
        AggregatedListSubnetworksHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListSubnetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of subnetworks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (SubnetworksScopedList element : subnetworkClient.aggregatedListSubnetworks(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListSubnetworksPagedResponse aggregatedListSubnetworks(String project) {
    AggregatedListSubnetworksHttpRequest request =
        AggregatedListSubnetworksHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListSubnetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of subnetworks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListSubnetworksHttpRequest request = AggregatedListSubnetworksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (SubnetworksScopedList element : subnetworkClient.aggregatedListSubnetworks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListSubnetworksPagedResponse aggregatedListSubnetworks(
      AggregatedListSubnetworksHttpRequest request) {
    return aggregatedListSubnetworksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of subnetworks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListSubnetworksHttpRequest request = AggregatedListSubnetworksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;AggregatedListSubnetworksPagedResponse&gt; future = subnetworkClient.aggregatedListSubnetworksPagedCallable().futureCall(request);
   *   // Do something
   *   for (SubnetworksScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListSubnetworksHttpRequest, AggregatedListSubnetworksPagedResponse>
      aggregatedListSubnetworksPagedCallable() {
    return stub.aggregatedListSubnetworksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of subnetworks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListSubnetworksHttpRequest request = AggregatedListSubnetworksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     SubnetworkAggregatedList response = subnetworkClient.aggregatedListSubnetworksCallable().call(request);
   *     for (SubnetworksScopedList element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListSubnetworksHttpRequest, SubnetworkAggregatedList>
      aggregatedListSubnetworksCallable() {
    return stub.aggregatedListSubnetworksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified subnetwork.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   Operation response = subnetworkClient.deleteSubnetwork(subnetwork);
   * }
   * </code></pre>
   *
   * @param subnetwork Name of the Subnetwork resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteSubnetwork(ProjectRegionSubnetworkName subnetwork) {

    DeleteSubnetworkHttpRequest request =
        DeleteSubnetworkHttpRequest.newBuilder()
            .setSubnetwork(subnetwork == null ? null : subnetwork.toString())
            .build();
    return deleteSubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified subnetwork.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   Operation response = subnetworkClient.deleteSubnetwork(subnetwork.toString());
   * }
   * </code></pre>
   *
   * @param subnetwork Name of the Subnetwork resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteSubnetwork(String subnetwork) {

    DeleteSubnetworkHttpRequest request =
        DeleteSubnetworkHttpRequest.newBuilder().setSubnetwork(subnetwork).build();
    return deleteSubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified subnetwork.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   DeleteSubnetworkHttpRequest request = DeleteSubnetworkHttpRequest.newBuilder()
   *     .setSubnetwork(subnetwork.toString())
   *     .build();
   *   Operation response = subnetworkClient.deleteSubnetwork(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteSubnetwork(DeleteSubnetworkHttpRequest request) {
    return deleteSubnetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified subnetwork.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   DeleteSubnetworkHttpRequest request = DeleteSubnetworkHttpRequest.newBuilder()
   *     .setSubnetwork(subnetwork.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = subnetworkClient.deleteSubnetworkCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteSubnetworkHttpRequest, Operation> deleteSubnetworkCallable() {
    return stub.deleteSubnetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Expands the IP CIDR range of the subnetwork to a specified value.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   SubnetworksExpandIpCidrRangeRequest subnetworksExpandIpCidrRangeRequestResource = SubnetworksExpandIpCidrRangeRequest.newBuilder().build();
   *   Operation response = subnetworkClient.expandIpCidrRangeSubnetwork(subnetwork, subnetworksExpandIpCidrRangeRequestResource);
   * }
   * </code></pre>
   *
   * @param subnetwork Name of the Subnetwork resource to update.
   * @param subnetworksExpandIpCidrRangeRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation expandIpCidrRangeSubnetwork(
      ProjectRegionSubnetworkName subnetwork,
      SubnetworksExpandIpCidrRangeRequest subnetworksExpandIpCidrRangeRequestResource) {

    ExpandIpCidrRangeSubnetworkHttpRequest request =
        ExpandIpCidrRangeSubnetworkHttpRequest.newBuilder()
            .setSubnetwork(subnetwork == null ? null : subnetwork.toString())
            .setSubnetworksExpandIpCidrRangeRequestResource(
                subnetworksExpandIpCidrRangeRequestResource)
            .build();
    return expandIpCidrRangeSubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Expands the IP CIDR range of the subnetwork to a specified value.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   SubnetworksExpandIpCidrRangeRequest subnetworksExpandIpCidrRangeRequestResource = SubnetworksExpandIpCidrRangeRequest.newBuilder().build();
   *   Operation response = subnetworkClient.expandIpCidrRangeSubnetwork(subnetwork.toString(), subnetworksExpandIpCidrRangeRequestResource);
   * }
   * </code></pre>
   *
   * @param subnetwork Name of the Subnetwork resource to update.
   * @param subnetworksExpandIpCidrRangeRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation expandIpCidrRangeSubnetwork(
      String subnetwork,
      SubnetworksExpandIpCidrRangeRequest subnetworksExpandIpCidrRangeRequestResource) {

    ExpandIpCidrRangeSubnetworkHttpRequest request =
        ExpandIpCidrRangeSubnetworkHttpRequest.newBuilder()
            .setSubnetwork(subnetwork)
            .setSubnetworksExpandIpCidrRangeRequestResource(
                subnetworksExpandIpCidrRangeRequestResource)
            .build();
    return expandIpCidrRangeSubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Expands the IP CIDR range of the subnetwork to a specified value.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   SubnetworksExpandIpCidrRangeRequest subnetworksExpandIpCidrRangeRequestResource = SubnetworksExpandIpCidrRangeRequest.newBuilder().build();
   *   ExpandIpCidrRangeSubnetworkHttpRequest request = ExpandIpCidrRangeSubnetworkHttpRequest.newBuilder()
   *     .setSubnetwork(subnetwork.toString())
   *     .setSubnetworksExpandIpCidrRangeRequestResource(subnetworksExpandIpCidrRangeRequestResource)
   *     .build();
   *   Operation response = subnetworkClient.expandIpCidrRangeSubnetwork(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation expandIpCidrRangeSubnetwork(
      ExpandIpCidrRangeSubnetworkHttpRequest request) {
    return expandIpCidrRangeSubnetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Expands the IP CIDR range of the subnetwork to a specified value.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   SubnetworksExpandIpCidrRangeRequest subnetworksExpandIpCidrRangeRequestResource = SubnetworksExpandIpCidrRangeRequest.newBuilder().build();
   *   ExpandIpCidrRangeSubnetworkHttpRequest request = ExpandIpCidrRangeSubnetworkHttpRequest.newBuilder()
   *     .setSubnetwork(subnetwork.toString())
   *     .setSubnetworksExpandIpCidrRangeRequestResource(subnetworksExpandIpCidrRangeRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = subnetworkClient.expandIpCidrRangeSubnetworkCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ExpandIpCidrRangeSubnetworkHttpRequest, Operation>
      expandIpCidrRangeSubnetworkCallable() {
    return stub.expandIpCidrRangeSubnetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified subnetwork. Gets a list of available subnetworks list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   Subnetwork response = subnetworkClient.getSubnetwork(subnetwork);
   * }
   * </code></pre>
   *
   * @param subnetwork Name of the Subnetwork resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Subnetwork getSubnetwork(ProjectRegionSubnetworkName subnetwork) {

    GetSubnetworkHttpRequest request =
        GetSubnetworkHttpRequest.newBuilder()
            .setSubnetwork(subnetwork == null ? null : subnetwork.toString())
            .build();
    return getSubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified subnetwork. Gets a list of available subnetworks list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   Subnetwork response = subnetworkClient.getSubnetwork(subnetwork.toString());
   * }
   * </code></pre>
   *
   * @param subnetwork Name of the Subnetwork resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Subnetwork getSubnetwork(String subnetwork) {

    GetSubnetworkHttpRequest request =
        GetSubnetworkHttpRequest.newBuilder().setSubnetwork(subnetwork).build();
    return getSubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified subnetwork. Gets a list of available subnetworks list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   GetSubnetworkHttpRequest request = GetSubnetworkHttpRequest.newBuilder()
   *     .setSubnetwork(subnetwork.toString())
   *     .build();
   *   Subnetwork response = subnetworkClient.getSubnetwork(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Subnetwork getSubnetwork(GetSubnetworkHttpRequest request) {
    return getSubnetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified subnetwork. Gets a list of available subnetworks list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   GetSubnetworkHttpRequest request = GetSubnetworkHttpRequest.newBuilder()
   *     .setSubnetwork(subnetwork.toString())
   *     .build();
   *   ApiFuture&lt;Subnetwork&gt; future = subnetworkClient.getSubnetworkCallable().futureCall(request);
   *   // Do something
   *   Subnetwork response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetSubnetworkHttpRequest, Subnetwork> getSubnetworkCallable() {
    return stub.getSubnetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkResourceName resource = ProjectRegionSubnetworkResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   Policy response = subnetworkClient.getIamPolicySubnetwork(resource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicySubnetwork(ProjectRegionSubnetworkResourceName resource) {

    GetIamPolicySubnetworkHttpRequest request =
        GetIamPolicySubnetworkHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicySubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkResourceName resource = ProjectRegionSubnetworkResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   Policy response = subnetworkClient.getIamPolicySubnetwork(resource.toString());
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicySubnetwork(String resource) {

    GetIamPolicySubnetworkHttpRequest request =
        GetIamPolicySubnetworkHttpRequest.newBuilder().setResource(resource).build();
    return getIamPolicySubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkResourceName resource = ProjectRegionSubnetworkResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   GetIamPolicySubnetworkHttpRequest request = GetIamPolicySubnetworkHttpRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .build();
   *   Policy response = subnetworkClient.getIamPolicySubnetwork(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicySubnetwork(GetIamPolicySubnetworkHttpRequest request) {
    return getIamPolicySubnetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkResourceName resource = ProjectRegionSubnetworkResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   GetIamPolicySubnetworkHttpRequest request = GetIamPolicySubnetworkHttpRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = subnetworkClient.getIamPolicySubnetworkCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetIamPolicySubnetworkHttpRequest, Policy>
      getIamPolicySubnetworkCallable() {
    return stub.getIamPolicySubnetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a subnetwork in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Subnetwork subnetworkResource = Subnetwork.newBuilder().build();
   *   Operation response = subnetworkClient.insertSubnetwork(region, subnetworkResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param subnetworkResource A Subnetwork resource. (== resource_for beta.subnetworks ==) (==
   *     resource_for v1.subnetworks ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertSubnetwork(ProjectRegionName region, Subnetwork subnetworkResource) {

    InsertSubnetworkHttpRequest request =
        InsertSubnetworkHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setSubnetworkResource(subnetworkResource)
            .build();
    return insertSubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a subnetwork in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Subnetwork subnetworkResource = Subnetwork.newBuilder().build();
   *   Operation response = subnetworkClient.insertSubnetwork(region.toString(), subnetworkResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param subnetworkResource A Subnetwork resource. (== resource_for beta.subnetworks ==) (==
   *     resource_for v1.subnetworks ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertSubnetwork(String region, Subnetwork subnetworkResource) {

    InsertSubnetworkHttpRequest request =
        InsertSubnetworkHttpRequest.newBuilder()
            .setRegion(region)
            .setSubnetworkResource(subnetworkResource)
            .build();
    return insertSubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a subnetwork in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Subnetwork subnetworkResource = Subnetwork.newBuilder().build();
   *   InsertSubnetworkHttpRequest request = InsertSubnetworkHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setSubnetworkResource(subnetworkResource)
   *     .build();
   *   Operation response = subnetworkClient.insertSubnetwork(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertSubnetwork(InsertSubnetworkHttpRequest request) {
    return insertSubnetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a subnetwork in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   Subnetwork subnetworkResource = Subnetwork.newBuilder().build();
   *   InsertSubnetworkHttpRequest request = InsertSubnetworkHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setSubnetworkResource(subnetworkResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = subnetworkClient.insertSubnetworkCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertSubnetworkHttpRequest, Operation> insertSubnetworkCallable() {
    return stub.insertSubnetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of subnetworks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (Subnetwork element : subnetworkClient.listSubnetworks(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListSubnetworksPagedResponse listSubnetworks(ProjectRegionName region) {
    ListSubnetworksHttpRequest request =
        ListSubnetworksHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listSubnetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of subnetworks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (Subnetwork element : subnetworkClient.listSubnetworks(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListSubnetworksPagedResponse listSubnetworks(String region) {
    ListSubnetworksHttpRequest request =
        ListSubnetworksHttpRequest.newBuilder().setRegion(region).build();
    return listSubnetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of subnetworks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListSubnetworksHttpRequest request = ListSubnetworksHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   for (Subnetwork element : subnetworkClient.listSubnetworks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListSubnetworksPagedResponse listSubnetworks(ListSubnetworksHttpRequest request) {
    return listSubnetworksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of subnetworks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListSubnetworksHttpRequest request = ListSubnetworksHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   ApiFuture&lt;ListSubnetworksPagedResponse&gt; future = subnetworkClient.listSubnetworksPagedCallable().futureCall(request);
   *   // Do something
   *   for (Subnetwork element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListSubnetworksHttpRequest, ListSubnetworksPagedResponse>
      listSubnetworksPagedCallable() {
    return stub.listSubnetworksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of subnetworks available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListSubnetworksHttpRequest request = ListSubnetworksHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   while (true) {
   *     SubnetworkList response = subnetworkClient.listSubnetworksCallable().call(request);
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
  @BetaApi
  public final UnaryCallable<ListSubnetworksHttpRequest, SubnetworkList> listSubnetworksCallable() {
    return stub.listSubnetworksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of usable subnetworks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (UsableSubnetwork element : subnetworkClient.listUsableSubnetworks(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListUsableSubnetworksPagedResponse listUsableSubnetworks(ProjectName project) {
    ListUsableSubnetworksHttpRequest request =
        ListUsableSubnetworksHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listUsableSubnetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of usable subnetworks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (UsableSubnetwork element : subnetworkClient.listUsableSubnetworks(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListUsableSubnetworksPagedResponse listUsableSubnetworks(String project) {
    ListUsableSubnetworksHttpRequest request =
        ListUsableSubnetworksHttpRequest.newBuilder().setProject(project).build();
    return listUsableSubnetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of usable subnetworks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListUsableSubnetworksHttpRequest request = ListUsableSubnetworksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (UsableSubnetwork element : subnetworkClient.listUsableSubnetworks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListUsableSubnetworksPagedResponse listUsableSubnetworks(
      ListUsableSubnetworksHttpRequest request) {
    return listUsableSubnetworksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of usable subnetworks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListUsableSubnetworksHttpRequest request = ListUsableSubnetworksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;ListUsableSubnetworksPagedResponse&gt; future = subnetworkClient.listUsableSubnetworksPagedCallable().futureCall(request);
   *   // Do something
   *   for (UsableSubnetwork element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListUsableSubnetworksHttpRequest, ListUsableSubnetworksPagedResponse>
      listUsableSubnetworksPagedCallable() {
    return stub.listUsableSubnetworksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of usable subnetworks.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListUsableSubnetworksHttpRequest request = ListUsableSubnetworksHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     UsableSubnetworksAggregatedList response = subnetworkClient.listUsableSubnetworksCallable().call(request);
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
  @BetaApi
  public final UnaryCallable<ListUsableSubnetworksHttpRequest, UsableSubnetworksAggregatedList>
      listUsableSubnetworksCallable() {
    return stub.listUsableSubnetworksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified subnetwork with the data included in the request. Only certain fields can
   * up updated with a patch request as indicated in the field descriptions. You must specify the
   * current fingeprint of the subnetwork resource being patched.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   Subnetwork subnetworkResource = Subnetwork.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = subnetworkClient.patchSubnetwork(subnetwork, subnetworkResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param subnetwork Name of the Subnetwork resource to patch.
   * @param subnetworkResource A Subnetwork resource. (== resource_for beta.subnetworks ==) (==
   *     resource_for v1.subnetworks ==)
   * @param fieldMask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchSubnetwork(
      ProjectRegionSubnetworkName subnetwork,
      Subnetwork subnetworkResource,
      List<String> fieldMask) {

    PatchSubnetworkHttpRequest request =
        PatchSubnetworkHttpRequest.newBuilder()
            .setSubnetwork(subnetwork == null ? null : subnetwork.toString())
            .setSubnetworkResource(subnetworkResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchSubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified subnetwork with the data included in the request. Only certain fields can
   * up updated with a patch request as indicated in the field descriptions. You must specify the
   * current fingeprint of the subnetwork resource being patched.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   Subnetwork subnetworkResource = Subnetwork.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = subnetworkClient.patchSubnetwork(subnetwork.toString(), subnetworkResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param subnetwork Name of the Subnetwork resource to patch.
   * @param subnetworkResource A Subnetwork resource. (== resource_for beta.subnetworks ==) (==
   *     resource_for v1.subnetworks ==)
   * @param fieldMask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchSubnetwork(
      String subnetwork, Subnetwork subnetworkResource, List<String> fieldMask) {

    PatchSubnetworkHttpRequest request =
        PatchSubnetworkHttpRequest.newBuilder()
            .setSubnetwork(subnetwork)
            .setSubnetworkResource(subnetworkResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchSubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified subnetwork with the data included in the request. Only certain fields can
   * up updated with a patch request as indicated in the field descriptions. You must specify the
   * current fingeprint of the subnetwork resource being patched.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   Subnetwork subnetworkResource = Subnetwork.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchSubnetworkHttpRequest request = PatchSubnetworkHttpRequest.newBuilder()
   *     .setSubnetwork(subnetwork.toString())
   *     .setSubnetworkResource(subnetworkResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = subnetworkClient.patchSubnetwork(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchSubnetwork(PatchSubnetworkHttpRequest request) {
    return patchSubnetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified subnetwork with the data included in the request. Only certain fields can
   * up updated with a patch request as indicated in the field descriptions. You must specify the
   * current fingeprint of the subnetwork resource being patched.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   Subnetwork subnetworkResource = Subnetwork.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchSubnetworkHttpRequest request = PatchSubnetworkHttpRequest.newBuilder()
   *     .setSubnetwork(subnetwork.toString())
   *     .setSubnetworkResource(subnetworkResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = subnetworkClient.patchSubnetworkCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchSubnetworkHttpRequest, Operation> patchSubnetworkCallable() {
    return stub.patchSubnetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkResourceName resource = ProjectRegionSubnetworkResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   Policy response = subnetworkClient.setIamPolicySubnetwork(resource, regionSetPolicyRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param regionSetPolicyRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicySubnetwork(
      ProjectRegionSubnetworkResourceName resource,
      RegionSetPolicyRequest regionSetPolicyRequestResource) {

    SetIamPolicySubnetworkHttpRequest request =
        SetIamPolicySubnetworkHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
            .build();
    return setIamPolicySubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkResourceName resource = ProjectRegionSubnetworkResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   Policy response = subnetworkClient.setIamPolicySubnetwork(resource.toString(), regionSetPolicyRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param regionSetPolicyRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicySubnetwork(
      String resource, RegionSetPolicyRequest regionSetPolicyRequestResource) {

    SetIamPolicySubnetworkHttpRequest request =
        SetIamPolicySubnetworkHttpRequest.newBuilder()
            .setResource(resource)
            .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
            .build();
    return setIamPolicySubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkResourceName resource = ProjectRegionSubnetworkResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   SetIamPolicySubnetworkHttpRequest request = SetIamPolicySubnetworkHttpRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
   *     .build();
   *   Policy response = subnetworkClient.setIamPolicySubnetwork(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicySubnetwork(SetIamPolicySubnetworkHttpRequest request) {
    return setIamPolicySubnetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkResourceName resource = ProjectRegionSubnetworkResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   SetIamPolicySubnetworkHttpRequest request = SetIamPolicySubnetworkHttpRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = subnetworkClient.setIamPolicySubnetworkCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetIamPolicySubnetworkHttpRequest, Policy>
      setIamPolicySubnetworkCallable() {
    return stub.setIamPolicySubnetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Set whether VMs in this subnet can access Google services without assigning external IP
   * addresses through Private Google Access.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   SubnetworksSetPrivateIpGoogleAccessRequest subnetworksSetPrivateIpGoogleAccessRequestResource = SubnetworksSetPrivateIpGoogleAccessRequest.newBuilder().build();
   *   Operation response = subnetworkClient.setPrivateIpGoogleAccessSubnetwork(subnetwork, subnetworksSetPrivateIpGoogleAccessRequestResource);
   * }
   * </code></pre>
   *
   * @param subnetwork Name of the Subnetwork resource.
   * @param subnetworksSetPrivateIpGoogleAccessRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setPrivateIpGoogleAccessSubnetwork(
      ProjectRegionSubnetworkName subnetwork,
      SubnetworksSetPrivateIpGoogleAccessRequest
          subnetworksSetPrivateIpGoogleAccessRequestResource) {

    SetPrivateIpGoogleAccessSubnetworkHttpRequest request =
        SetPrivateIpGoogleAccessSubnetworkHttpRequest.newBuilder()
            .setSubnetwork(subnetwork == null ? null : subnetwork.toString())
            .setSubnetworksSetPrivateIpGoogleAccessRequestResource(
                subnetworksSetPrivateIpGoogleAccessRequestResource)
            .build();
    return setPrivateIpGoogleAccessSubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Set whether VMs in this subnet can access Google services without assigning external IP
   * addresses through Private Google Access.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   SubnetworksSetPrivateIpGoogleAccessRequest subnetworksSetPrivateIpGoogleAccessRequestResource = SubnetworksSetPrivateIpGoogleAccessRequest.newBuilder().build();
   *   Operation response = subnetworkClient.setPrivateIpGoogleAccessSubnetwork(subnetwork.toString(), subnetworksSetPrivateIpGoogleAccessRequestResource);
   * }
   * </code></pre>
   *
   * @param subnetwork Name of the Subnetwork resource.
   * @param subnetworksSetPrivateIpGoogleAccessRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setPrivateIpGoogleAccessSubnetwork(
      String subnetwork,
      SubnetworksSetPrivateIpGoogleAccessRequest
          subnetworksSetPrivateIpGoogleAccessRequestResource) {

    SetPrivateIpGoogleAccessSubnetworkHttpRequest request =
        SetPrivateIpGoogleAccessSubnetworkHttpRequest.newBuilder()
            .setSubnetwork(subnetwork)
            .setSubnetworksSetPrivateIpGoogleAccessRequestResource(
                subnetworksSetPrivateIpGoogleAccessRequestResource)
            .build();
    return setPrivateIpGoogleAccessSubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Set whether VMs in this subnet can access Google services without assigning external IP
   * addresses through Private Google Access.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   SubnetworksSetPrivateIpGoogleAccessRequest subnetworksSetPrivateIpGoogleAccessRequestResource = SubnetworksSetPrivateIpGoogleAccessRequest.newBuilder().build();
   *   SetPrivateIpGoogleAccessSubnetworkHttpRequest request = SetPrivateIpGoogleAccessSubnetworkHttpRequest.newBuilder()
   *     .setSubnetwork(subnetwork.toString())
   *     .setSubnetworksSetPrivateIpGoogleAccessRequestResource(subnetworksSetPrivateIpGoogleAccessRequestResource)
   *     .build();
   *   Operation response = subnetworkClient.setPrivateIpGoogleAccessSubnetwork(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setPrivateIpGoogleAccessSubnetwork(
      SetPrivateIpGoogleAccessSubnetworkHttpRequest request) {
    return setPrivateIpGoogleAccessSubnetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Set whether VMs in this subnet can access Google services without assigning external IP
   * addresses through Private Google Access.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkName subnetwork = ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
   *   SubnetworksSetPrivateIpGoogleAccessRequest subnetworksSetPrivateIpGoogleAccessRequestResource = SubnetworksSetPrivateIpGoogleAccessRequest.newBuilder().build();
   *   SetPrivateIpGoogleAccessSubnetworkHttpRequest request = SetPrivateIpGoogleAccessSubnetworkHttpRequest.newBuilder()
   *     .setSubnetwork(subnetwork.toString())
   *     .setSubnetworksSetPrivateIpGoogleAccessRequestResource(subnetworksSetPrivateIpGoogleAccessRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = subnetworkClient.setPrivateIpGoogleAccessSubnetworkCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetPrivateIpGoogleAccessSubnetworkHttpRequest, Operation>
      setPrivateIpGoogleAccessSubnetworkCallable() {
    return stub.setPrivateIpGoogleAccessSubnetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkResourceName resource = ProjectRegionSubnetworkResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = subnetworkClient.testIamPermissionsSubnetwork(resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsSubnetwork(
      ProjectRegionSubnetworkResourceName resource,
      TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsSubnetworkHttpRequest request =
        TestIamPermissionsSubnetworkHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsSubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkResourceName resource = ProjectRegionSubnetworkResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = subnetworkClient.testIamPermissionsSubnetwork(resource.toString(), testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsSubnetwork(
      String resource, TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsSubnetworkHttpRequest request =
        TestIamPermissionsSubnetworkHttpRequest.newBuilder()
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsSubnetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkResourceName resource = ProjectRegionSubnetworkResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsSubnetworkHttpRequest request = TestIamPermissionsSubnetworkHttpRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = subnetworkClient.testIamPermissionsSubnetwork(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsSubnetwork(
      TestIamPermissionsSubnetworkHttpRequest request) {
    return testIamPermissionsSubnetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubnetworkClient subnetworkClient = SubnetworkClient.create()) {
   *   ProjectRegionSubnetworkResourceName resource = ProjectRegionSubnetworkResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsSubnetworkHttpRequest request = TestIamPermissionsSubnetworkHttpRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = subnetworkClient.testIamPermissionsSubnetworkCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<TestIamPermissionsSubnetworkHttpRequest, TestPermissionsResponse>
      testIamPermissionsSubnetworkCallable() {
    return stub.testIamPermissionsSubnetworkCallable();
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

  public static class AggregatedListSubnetworksPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListSubnetworksHttpRequest,
          SubnetworkAggregatedList,
          SubnetworksScopedList,
          AggregatedListSubnetworksPage,
          AggregatedListSubnetworksFixedSizeCollection> {

    public static ApiFuture<AggregatedListSubnetworksPagedResponse> createAsync(
        PageContext<
                AggregatedListSubnetworksHttpRequest,
                SubnetworkAggregatedList,
                SubnetworksScopedList>
            context,
        ApiFuture<SubnetworkAggregatedList> futureResponse) {
      ApiFuture<AggregatedListSubnetworksPage> futurePage =
          AggregatedListSubnetworksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListSubnetworksPage, AggregatedListSubnetworksPagedResponse>() {
            @Override
            public AggregatedListSubnetworksPagedResponse apply(
                AggregatedListSubnetworksPage input) {
              return new AggregatedListSubnetworksPagedResponse(input);
            }
          });
    }

    private AggregatedListSubnetworksPagedResponse(AggregatedListSubnetworksPage page) {
      super(page, AggregatedListSubnetworksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListSubnetworksPage
      extends AbstractPage<
          AggregatedListSubnetworksHttpRequest,
          SubnetworkAggregatedList,
          SubnetworksScopedList,
          AggregatedListSubnetworksPage> {

    private AggregatedListSubnetworksPage(
        PageContext<
                AggregatedListSubnetworksHttpRequest,
                SubnetworkAggregatedList,
                SubnetworksScopedList>
            context,
        SubnetworkAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListSubnetworksPage createEmptyPage() {
      return new AggregatedListSubnetworksPage(null, null);
    }

    @Override
    protected AggregatedListSubnetworksPage createPage(
        PageContext<
                AggregatedListSubnetworksHttpRequest,
                SubnetworkAggregatedList,
                SubnetworksScopedList>
            context,
        SubnetworkAggregatedList response) {
      return new AggregatedListSubnetworksPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListSubnetworksPage> createPageAsync(
        PageContext<
                AggregatedListSubnetworksHttpRequest,
                SubnetworkAggregatedList,
                SubnetworksScopedList>
            context,
        ApiFuture<SubnetworkAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListSubnetworksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListSubnetworksHttpRequest,
          SubnetworkAggregatedList,
          SubnetworksScopedList,
          AggregatedListSubnetworksPage,
          AggregatedListSubnetworksFixedSizeCollection> {

    private AggregatedListSubnetworksFixedSizeCollection(
        List<AggregatedListSubnetworksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListSubnetworksFixedSizeCollection createEmptyCollection() {
      return new AggregatedListSubnetworksFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListSubnetworksFixedSizeCollection createCollection(
        List<AggregatedListSubnetworksPage> pages, int collectionSize) {
      return new AggregatedListSubnetworksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSubnetworksPagedResponse
      extends AbstractPagedListResponse<
          ListSubnetworksHttpRequest,
          SubnetworkList,
          Subnetwork,
          ListSubnetworksPage,
          ListSubnetworksFixedSizeCollection> {

    public static ApiFuture<ListSubnetworksPagedResponse> createAsync(
        PageContext<ListSubnetworksHttpRequest, SubnetworkList, Subnetwork> context,
        ApiFuture<SubnetworkList> futureResponse) {
      ApiFuture<ListSubnetworksPage> futurePage =
          ListSubnetworksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListSubnetworksPage, ListSubnetworksPagedResponse>() {
            @Override
            public ListSubnetworksPagedResponse apply(ListSubnetworksPage input) {
              return new ListSubnetworksPagedResponse(input);
            }
          });
    }

    private ListSubnetworksPagedResponse(ListSubnetworksPage page) {
      super(page, ListSubnetworksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSubnetworksPage
      extends AbstractPage<
          ListSubnetworksHttpRequest, SubnetworkList, Subnetwork, ListSubnetworksPage> {

    private ListSubnetworksPage(
        PageContext<ListSubnetworksHttpRequest, SubnetworkList, Subnetwork> context,
        SubnetworkList response) {
      super(context, response);
    }

    private static ListSubnetworksPage createEmptyPage() {
      return new ListSubnetworksPage(null, null);
    }

    @Override
    protected ListSubnetworksPage createPage(
        PageContext<ListSubnetworksHttpRequest, SubnetworkList, Subnetwork> context,
        SubnetworkList response) {
      return new ListSubnetworksPage(context, response);
    }

    @Override
    public ApiFuture<ListSubnetworksPage> createPageAsync(
        PageContext<ListSubnetworksHttpRequest, SubnetworkList, Subnetwork> context,
        ApiFuture<SubnetworkList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSubnetworksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSubnetworksHttpRequest,
          SubnetworkList,
          Subnetwork,
          ListSubnetworksPage,
          ListSubnetworksFixedSizeCollection> {

    private ListSubnetworksFixedSizeCollection(
        List<ListSubnetworksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSubnetworksFixedSizeCollection createEmptyCollection() {
      return new ListSubnetworksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSubnetworksFixedSizeCollection createCollection(
        List<ListSubnetworksPage> pages, int collectionSize) {
      return new ListSubnetworksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListUsableSubnetworksPagedResponse
      extends AbstractPagedListResponse<
          ListUsableSubnetworksHttpRequest,
          UsableSubnetworksAggregatedList,
          UsableSubnetwork,
          ListUsableSubnetworksPage,
          ListUsableSubnetworksFixedSizeCollection> {

    public static ApiFuture<ListUsableSubnetworksPagedResponse> createAsync(
        PageContext<
                ListUsableSubnetworksHttpRequest, UsableSubnetworksAggregatedList, UsableSubnetwork>
            context,
        ApiFuture<UsableSubnetworksAggregatedList> futureResponse) {
      ApiFuture<ListUsableSubnetworksPage> futurePage =
          ListUsableSubnetworksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListUsableSubnetworksPage, ListUsableSubnetworksPagedResponse>() {
            @Override
            public ListUsableSubnetworksPagedResponse apply(ListUsableSubnetworksPage input) {
              return new ListUsableSubnetworksPagedResponse(input);
            }
          });
    }

    private ListUsableSubnetworksPagedResponse(ListUsableSubnetworksPage page) {
      super(page, ListUsableSubnetworksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUsableSubnetworksPage
      extends AbstractPage<
          ListUsableSubnetworksHttpRequest,
          UsableSubnetworksAggregatedList,
          UsableSubnetwork,
          ListUsableSubnetworksPage> {

    private ListUsableSubnetworksPage(
        PageContext<
                ListUsableSubnetworksHttpRequest, UsableSubnetworksAggregatedList, UsableSubnetwork>
            context,
        UsableSubnetworksAggregatedList response) {
      super(context, response);
    }

    private static ListUsableSubnetworksPage createEmptyPage() {
      return new ListUsableSubnetworksPage(null, null);
    }

    @Override
    protected ListUsableSubnetworksPage createPage(
        PageContext<
                ListUsableSubnetworksHttpRequest, UsableSubnetworksAggregatedList, UsableSubnetwork>
            context,
        UsableSubnetworksAggregatedList response) {
      return new ListUsableSubnetworksPage(context, response);
    }

    @Override
    public ApiFuture<ListUsableSubnetworksPage> createPageAsync(
        PageContext<
                ListUsableSubnetworksHttpRequest, UsableSubnetworksAggregatedList, UsableSubnetwork>
            context,
        ApiFuture<UsableSubnetworksAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUsableSubnetworksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUsableSubnetworksHttpRequest,
          UsableSubnetworksAggregatedList,
          UsableSubnetwork,
          ListUsableSubnetworksPage,
          ListUsableSubnetworksFixedSizeCollection> {

    private ListUsableSubnetworksFixedSizeCollection(
        List<ListUsableSubnetworksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUsableSubnetworksFixedSizeCollection createEmptyCollection() {
      return new ListUsableSubnetworksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUsableSubnetworksFixedSizeCollection createCollection(
        List<ListUsableSubnetworksPage> pages, int collectionSize) {
      return new ListUsableSubnetworksFixedSizeCollection(pages, collectionSize);
    }
  }
}
