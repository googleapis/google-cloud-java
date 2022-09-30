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
import com.google.cloud.compute.v1.stub.RegionNetworkEndpointGroupsStub;
import com.google.cloud.compute.v1.stub.RegionNetworkEndpointGroupsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionNetworkEndpointGroups API.
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
 * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
 *     RegionNetworkEndpointGroupsClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
 *   NetworkEndpointGroup response =
 *       regionNetworkEndpointGroupsClient.get(project, region, networkEndpointGroup);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionNetworkEndpointGroupsClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of
 * RegionNetworkEndpointGroupsSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionNetworkEndpointGroupsSettings regionNetworkEndpointGroupsSettings =
 *     RegionNetworkEndpointGroupsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
 *     RegionNetworkEndpointGroupsClient.create(regionNetworkEndpointGroupsSettings);
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
 * RegionNetworkEndpointGroupsSettings regionNetworkEndpointGroupsSettings =
 *     RegionNetworkEndpointGroupsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
 *     RegionNetworkEndpointGroupsClient.create(regionNetworkEndpointGroupsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionNetworkEndpointGroupsClient implements BackgroundResource {
  private final RegionNetworkEndpointGroupsSettings settings;
  private final RegionNetworkEndpointGroupsStub stub;

  /** Constructs an instance of RegionNetworkEndpointGroupsClient with default settings. */
  public static final RegionNetworkEndpointGroupsClient create() throws IOException {
    return create(RegionNetworkEndpointGroupsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionNetworkEndpointGroupsClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RegionNetworkEndpointGroupsClient create(
      RegionNetworkEndpointGroupsSettings settings) throws IOException {
    return new RegionNetworkEndpointGroupsClient(settings);
  }

  /**
   * Constructs an instance of RegionNetworkEndpointGroupsClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(RegionNetworkEndpointGroupsSettings).
   */
  public static final RegionNetworkEndpointGroupsClient create(
      RegionNetworkEndpointGroupsStub stub) {
    return new RegionNetworkEndpointGroupsClient(stub);
  }

  /**
   * Constructs an instance of RegionNetworkEndpointGroupsClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionNetworkEndpointGroupsClient(RegionNetworkEndpointGroupsSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionNetworkEndpointGroupsStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionNetworkEndpointGroupsClient(RegionNetworkEndpointGroupsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionNetworkEndpointGroupsSettings getSettings() {
    return settings;
  }

  public RegionNetworkEndpointGroupsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network endpoint group. Note that the NEG cannot be deleted if it is
   * configured as a backend of a backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
   *   Operation response =
   *       regionNetworkEndpointGroupsClient
   *           .deleteAsync(project, region, networkEndpointGroup)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region where the network endpoint group is located. It should
   *     comply with RFC1035.
   * @param networkEndpointGroup The name of the network endpoint group to delete. It should comply
   *     with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String networkEndpointGroup) {
    DeleteRegionNetworkEndpointGroupRequest request =
        DeleteRegionNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network endpoint group. Note that the NEG cannot be deleted if it is
   * configured as a backend of a backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   DeleteRegionNetworkEndpointGroupRequest request =
   *       DeleteRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionNetworkEndpointGroupsClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteRegionNetworkEndpointGroupRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network endpoint group. Note that the NEG cannot be deleted if it is
   * configured as a backend of a backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   DeleteRegionNetworkEndpointGroupRequest request =
   *       DeleteRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionNetworkEndpointGroupsClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRegionNetworkEndpointGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified network endpoint group. Note that the NEG cannot be deleted if it is
   * configured as a backend of a backend service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   DeleteRegionNetworkEndpointGroupRequest request =
   *       DeleteRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionNetworkEndpointGroupsClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionNetworkEndpointGroupRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String networkEndpointGroup = "networkEndpointGroup-2120389028";
   *   NetworkEndpointGroup response =
   *       regionNetworkEndpointGroupsClient.get(project, region, networkEndpointGroup);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region where the network endpoint group is located. It should
   *     comply with RFC1035.
   * @param networkEndpointGroup The name of the network endpoint group. It should comply with
   *     RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkEndpointGroup get(
      String project, String region, String networkEndpointGroup) {
    GetRegionNetworkEndpointGroupRequest request =
        GetRegionNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNetworkEndpointGroup(networkEndpointGroup)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   GetRegionNetworkEndpointGroupRequest request =
   *       GetRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   NetworkEndpointGroup response = regionNetworkEndpointGroupsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkEndpointGroup get(GetRegionNetworkEndpointGroupRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified network endpoint group. Gets a list of available network endpoint groups
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   GetRegionNetworkEndpointGroupRequest request =
   *       GetRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroup("networkEndpointGroup-2120389028")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<NetworkEndpointGroup> future =
   *       regionNetworkEndpointGroupsClient.getCallable().futureCall(request);
   *   // Do something.
   *   NetworkEndpointGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionNetworkEndpointGroupRequest, NetworkEndpointGroup>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();
   *   Operation response =
   *       regionNetworkEndpointGroupsClient
   *           .insertAsync(project, region, networkEndpointGroupResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region where you want to create the network endpoint group. It
   *     should comply with RFC1035.
   * @param networkEndpointGroupResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, NetworkEndpointGroup networkEndpointGroupResource) {
    InsertRegionNetworkEndpointGroupRequest request =
        InsertRegionNetworkEndpointGroupRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNetworkEndpointGroupResource(networkEndpointGroupResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   InsertRegionNetworkEndpointGroupRequest request =
   *       InsertRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroupResource(NetworkEndpointGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionNetworkEndpointGroupsClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertRegionNetworkEndpointGroupRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   InsertRegionNetworkEndpointGroupRequest request =
   *       InsertRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroupResource(NetworkEndpointGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionNetworkEndpointGroupsClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertRegionNetworkEndpointGroupRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a network endpoint group in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   InsertRegionNetworkEndpointGroupRequest request =
   *       InsertRegionNetworkEndpointGroupRequest.newBuilder()
   *           .setNetworkEndpointGroupResource(NetworkEndpointGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionNetworkEndpointGroupsClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionNetworkEndpointGroupRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of regional network endpoint groups available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (NetworkEndpointGroup element :
   *       regionNetworkEndpointGroupsClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region where the network endpoint group is located. It should
   *     comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListRegionNetworkEndpointGroupsRequest request =
        ListRegionNetworkEndpointGroupsRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of regional network endpoint groups available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   ListRegionNetworkEndpointGroupsRequest request =
   *       ListRegionNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (NetworkEndpointGroup element :
   *       regionNetworkEndpointGroupsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionNetworkEndpointGroupsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of regional network endpoint groups available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   ListRegionNetworkEndpointGroupsRequest request =
   *       ListRegionNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<NetworkEndpointGroup> future =
   *       regionNetworkEndpointGroupsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NetworkEndpointGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionNetworkEndpointGroupsRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of regional network endpoint groups available to the specified project in
   * the given region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionNetworkEndpointGroupsClient regionNetworkEndpointGroupsClient =
   *     RegionNetworkEndpointGroupsClient.create()) {
   *   ListRegionNetworkEndpointGroupsRequest request =
   *       ListRegionNetworkEndpointGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     NetworkEndpointGroupList response =
   *         regionNetworkEndpointGroupsClient.listCallable().call(request);
   *     for (NetworkEndpointGroup element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
      listCallable() {
    return stub.listCallable();
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
          ListRegionNetworkEndpointGroupsRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListRegionNetworkEndpointGroupsRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        ApiFuture<NetworkEndpointGroupList> futureResponse) {
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
          ListRegionNetworkEndpointGroupsRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
          ListPage> {

    private ListPage(
        PageContext<
                ListRegionNetworkEndpointGroupsRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        NetworkEndpointGroupList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListRegionNetworkEndpointGroupsRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        NetworkEndpointGroupList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListRegionNetworkEndpointGroupsRequest,
                NetworkEndpointGroupList,
                NetworkEndpointGroup>
            context,
        ApiFuture<NetworkEndpointGroupList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionNetworkEndpointGroupsRequest,
          NetworkEndpointGroupList,
          NetworkEndpointGroup,
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
