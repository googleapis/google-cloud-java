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
import com.google.cloud.compute.v1.stub.NodeGroupsStub;
import com.google.cloud.compute.v1.stub.NodeGroupsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The NodeGroups API.
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
 * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
 *   String project = "project-309310695";
 *   String zone = "zone3744684";
 *   String nodeGroup = "nodeGroup443599261";
 *   NodeGroup response = nodeGroupsClient.get(project, zone, nodeGroup);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the NodeGroupsClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of NodeGroupsSettings to
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
 * NodeGroupsSettings nodeGroupsSettings =
 *     NodeGroupsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create(nodeGroupsSettings);
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
 * NodeGroupsSettings nodeGroupsSettings =
 *     NodeGroupsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create(nodeGroupsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class NodeGroupsClient implements BackgroundResource {
  private final NodeGroupsSettings settings;
  private final NodeGroupsStub stub;

  /** Constructs an instance of NodeGroupsClient with default settings. */
  public static final NodeGroupsClient create() throws IOException {
    return create(NodeGroupsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NodeGroupsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NodeGroupsClient create(NodeGroupsSettings settings) throws IOException {
    return new NodeGroupsClient(settings);
  }

  /**
   * Constructs an instance of NodeGroupsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(NodeGroupsSettings).
   */
  public static final NodeGroupsClient create(NodeGroupsStub stub) {
    return new NodeGroupsClient(stub);
  }

  /**
   * Constructs an instance of NodeGroupsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected NodeGroupsClient(NodeGroupsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NodeGroupsStubSettings) settings.getStubSettings()).createStub();
  }

  protected NodeGroupsClient(NodeGroupsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NodeGroupsSettings getSettings() {
    return settings;
  }

  public NodeGroupsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds specified number of nodes to the node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String nodeGroup = "nodeGroup443599261";
   *   NodeGroupsAddNodesRequest nodeGroupsAddNodesRequestResource =
   *       NodeGroupsAddNodesRequest.newBuilder().build();
   *   Operation response =
   *       nodeGroupsClient
   *           .addNodesAsync(project, zone, nodeGroup, nodeGroupsAddNodesRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param nodeGroup Name of the NodeGroup resource.
   * @param nodeGroupsAddNodesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> addNodesAsync(
      String project,
      String zone,
      String nodeGroup,
      NodeGroupsAddNodesRequest nodeGroupsAddNodesRequestResource) {
    AddNodesNodeGroupRequest request =
        AddNodesNodeGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setNodeGroup(nodeGroup)
            .setNodeGroupsAddNodesRequestResource(nodeGroupsAddNodesRequestResource)
            .build();
    return addNodesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds specified number of nodes to the node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   AddNodesNodeGroupRequest request =
   *       AddNodesNodeGroupRequest.newBuilder()
   *           .setNodeGroup("nodeGroup443599261")
   *           .setNodeGroupsAddNodesRequestResource(NodeGroupsAddNodesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = nodeGroupsClient.addNodesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> addNodesAsync(
      AddNodesNodeGroupRequest request) {
    return addNodesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds specified number of nodes to the node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   AddNodesNodeGroupRequest request =
   *       AddNodesNodeGroupRequest.newBuilder()
   *           .setNodeGroup("nodeGroup443599261")
   *           .setNodeGroupsAddNodesRequestResource(NodeGroupsAddNodesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       nodeGroupsClient.addNodesOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AddNodesNodeGroupRequest, Operation, Operation>
      addNodesOperationCallable() {
    return stub.addNodesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds specified number of nodes to the node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   AddNodesNodeGroupRequest request =
   *       AddNodesNodeGroupRequest.newBuilder()
   *           .setNodeGroup("nodeGroup443599261")
   *           .setNodeGroupsAddNodesRequestResource(NodeGroupsAddNodesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = nodeGroupsClient.addNodesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddNodesNodeGroupRequest, Operation> addNodesCallable() {
    return stub.addNodesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of node groups. Note: use nodeGroups.listNodes for more details
   * about each group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, NodeGroupsScopedList> element :
   *       nodeGroupsClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListNodeGroupsRequest request =
        AggregatedListNodeGroupsRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of node groups. Note: use nodeGroups.listNodes for more details
   * about each group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   AggregatedListNodeGroupsRequest request =
   *       AggregatedListNodeGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Map.Entry<String, NodeGroupsScopedList> element :
   *       nodeGroupsClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(AggregatedListNodeGroupsRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of node groups. Note: use nodeGroups.listNodes for more details
   * about each group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   AggregatedListNodeGroupsRequest request =
   *       AggregatedListNodeGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Map.Entry<String, NodeGroupsScopedList>> future =
   *       nodeGroupsClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, NodeGroupsScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregatedListNodeGroupsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an aggregated list of node groups. Note: use nodeGroups.listNodes for more details
   * about each group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   AggregatedListNodeGroupsRequest request =
   *       AggregatedListNodeGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     NodeGroupAggregatedList response = nodeGroupsClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, NodeGroupsScopedList> element : response.getItemsList()) {
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
  public final UnaryCallable<AggregatedListNodeGroupsRequest, NodeGroupAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified NodeGroup resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String nodeGroup = "nodeGroup443599261";
   *   Operation response = nodeGroupsClient.deleteAsync(project, zone, nodeGroup).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param nodeGroup Name of the NodeGroup resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String zone, String nodeGroup) {
    DeleteNodeGroupRequest request =
        DeleteNodeGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setNodeGroup(nodeGroup)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified NodeGroup resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   DeleteNodeGroupRequest request =
   *       DeleteNodeGroupRequest.newBuilder()
   *           .setNodeGroup("nodeGroup443599261")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = nodeGroupsClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(DeleteNodeGroupRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified NodeGroup resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   DeleteNodeGroupRequest request =
   *       DeleteNodeGroupRequest.newBuilder()
   *           .setNodeGroup("nodeGroup443599261")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       nodeGroupsClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteNodeGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified NodeGroup resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   DeleteNodeGroupRequest request =
   *       DeleteNodeGroupRequest.newBuilder()
   *           .setNodeGroup("nodeGroup443599261")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = nodeGroupsClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNodeGroupRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes specified nodes from the node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String nodeGroup = "nodeGroup443599261";
   *   NodeGroupsDeleteNodesRequest nodeGroupsDeleteNodesRequestResource =
   *       NodeGroupsDeleteNodesRequest.newBuilder().build();
   *   Operation response =
   *       nodeGroupsClient
   *           .deleteNodesAsync(project, zone, nodeGroup, nodeGroupsDeleteNodesRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param nodeGroup Name of the NodeGroup resource whose nodes will be deleted.
   * @param nodeGroupsDeleteNodesRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteNodesAsync(
      String project,
      String zone,
      String nodeGroup,
      NodeGroupsDeleteNodesRequest nodeGroupsDeleteNodesRequestResource) {
    DeleteNodesNodeGroupRequest request =
        DeleteNodesNodeGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setNodeGroup(nodeGroup)
            .setNodeGroupsDeleteNodesRequestResource(nodeGroupsDeleteNodesRequestResource)
            .build();
    return deleteNodesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes specified nodes from the node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   DeleteNodesNodeGroupRequest request =
   *       DeleteNodesNodeGroupRequest.newBuilder()
   *           .setNodeGroup("nodeGroup443599261")
   *           .setNodeGroupsDeleteNodesRequestResource(
   *               NodeGroupsDeleteNodesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = nodeGroupsClient.deleteNodesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteNodesAsync(
      DeleteNodesNodeGroupRequest request) {
    return deleteNodesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes specified nodes from the node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   DeleteNodesNodeGroupRequest request =
   *       DeleteNodesNodeGroupRequest.newBuilder()
   *           .setNodeGroup("nodeGroup443599261")
   *           .setNodeGroupsDeleteNodesRequestResource(
   *               NodeGroupsDeleteNodesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       nodeGroupsClient.deleteNodesOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteNodesNodeGroupRequest, Operation, Operation>
      deleteNodesOperationCallable() {
    return stub.deleteNodesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes specified nodes from the node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   DeleteNodesNodeGroupRequest request =
   *       DeleteNodesNodeGroupRequest.newBuilder()
   *           .setNodeGroup("nodeGroup443599261")
   *           .setNodeGroupsDeleteNodesRequestResource(
   *               NodeGroupsDeleteNodesRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = nodeGroupsClient.deleteNodesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNodesNodeGroupRequest, Operation> deleteNodesCallable() {
    return stub.deleteNodesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified NodeGroup. Get a list of available NodeGroups by making a list() request.
   * Note: the "nodes" field should not be used. Use nodeGroups.listNodes instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String nodeGroup = "nodeGroup443599261";
   *   NodeGroup response = nodeGroupsClient.get(project, zone, nodeGroup);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param nodeGroup Name of the node group to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodeGroup get(String project, String zone, String nodeGroup) {
    GetNodeGroupRequest request =
        GetNodeGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setNodeGroup(nodeGroup)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified NodeGroup. Get a list of available NodeGroups by making a list() request.
   * Note: the "nodes" field should not be used. Use nodeGroups.listNodes instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   GetNodeGroupRequest request =
   *       GetNodeGroupRequest.newBuilder()
   *           .setNodeGroup("nodeGroup443599261")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   NodeGroup response = nodeGroupsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodeGroup get(GetNodeGroupRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified NodeGroup. Get a list of available NodeGroups by making a list() request.
   * Note: the "nodes" field should not be used. Use nodeGroups.listNodes instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   GetNodeGroupRequest request =
   *       GetNodeGroupRequest.newBuilder()
   *           .setNodeGroup("nodeGroup443599261")
   *           .setProject("project-309310695")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<NodeGroup> future = nodeGroupsClient.getCallable().futureCall(request);
   *   // Do something.
   *   NodeGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNodeGroupRequest, NodeGroup> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String resource = "resource-341064690";
   *   Policy response = nodeGroupsClient.getIamPolicy(project, zone, resource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String project, String zone, String resource) {
    GetIamPolicyNodeGroupRequest request =
        GetIamPolicyNodeGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setResource(resource)
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   GetIamPolicyNodeGroupRequest request =
   *       GetIamPolicyNodeGroupRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .build();
   *   Policy response = nodeGroupsClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyNodeGroupRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   GetIamPolicyNodeGroupRequest request =
   *       GetIamPolicyNodeGroupRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Policy> future = nodeGroupsClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyNodeGroupRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a NodeGroup resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   int initialNodeCount = 1682564205;
   *   NodeGroup nodeGroupResource = NodeGroup.newBuilder().build();
   *   Operation response =
   *       nodeGroupsClient.insertAsync(project, zone, initialNodeCount, nodeGroupResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param initialNodeCount Initial count of nodes in the node group.
   * @param nodeGroupResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String zone, int initialNodeCount, NodeGroup nodeGroupResource) {
    InsertNodeGroupRequest request =
        InsertNodeGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setInitialNodeCount(initialNodeCount)
            .setNodeGroupResource(nodeGroupResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a NodeGroup resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   InsertNodeGroupRequest request =
   *       InsertNodeGroupRequest.newBuilder()
   *           .setInitialNodeCount(1682564205)
   *           .setNodeGroupResource(NodeGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = nodeGroupsClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(InsertNodeGroupRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a NodeGroup resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   InsertNodeGroupRequest request =
   *       InsertNodeGroupRequest.newBuilder()
   *           .setInitialNodeCount(1682564205)
   *           .setNodeGroupResource(NodeGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       nodeGroupsClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertNodeGroupRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a NodeGroup resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   InsertNodeGroupRequest request =
   *       InsertNodeGroupRequest.newBuilder()
   *           .setInitialNodeCount(1682564205)
   *           .setNodeGroupResource(NodeGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = nodeGroupsClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertNodeGroupRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of node groups available to the specified project. Note: use
   * nodeGroups.listNodes for more details about each group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   for (NodeGroup element : nodeGroupsClient.list(project, zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String zone) {
    ListNodeGroupsRequest request =
        ListNodeGroupsRequest.newBuilder().setProject(project).setZone(zone).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of node groups available to the specified project. Note: use
   * nodeGroups.listNodes for more details about each group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   ListNodeGroupsRequest request =
   *       ListNodeGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (NodeGroup element : nodeGroupsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListNodeGroupsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of node groups available to the specified project. Note: use
   * nodeGroups.listNodes for more details about each group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   ListNodeGroupsRequest request =
   *       ListNodeGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<NodeGroup> future = nodeGroupsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NodeGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNodeGroupsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of node groups available to the specified project. Note: use
   * nodeGroups.listNodes for more details about each group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   ListNodeGroupsRequest request =
   *       ListNodeGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   while (true) {
   *     NodeGroupList response = nodeGroupsClient.listCallable().call(request);
   *     for (NodeGroup element : response.getItemsList()) {
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
  public final UnaryCallable<ListNodeGroupsRequest, NodeGroupList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists nodes in the node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String nodeGroup = "nodeGroup443599261";
   *   for (NodeGroupNode element :
   *       nodeGroupsClient.listNodes(project, zone, nodeGroup).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param nodeGroup Name of the NodeGroup resource whose nodes you want to list.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodesPagedResponse listNodes(String project, String zone, String nodeGroup) {
    ListNodesNodeGroupsRequest request =
        ListNodesNodeGroupsRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setNodeGroup(nodeGroup)
            .build();
    return listNodes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists nodes in the node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   ListNodesNodeGroupsRequest request =
   *       ListNodesNodeGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setNodeGroup("nodeGroup443599261")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   for (NodeGroupNode element : nodeGroupsClient.listNodes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodesPagedResponse listNodes(ListNodesNodeGroupsRequest request) {
    return listNodesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists nodes in the node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   ListNodesNodeGroupsRequest request =
   *       ListNodesNodeGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setNodeGroup("nodeGroup443599261")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<NodeGroupNode> future =
   *       nodeGroupsClient.listNodesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NodeGroupNode element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNodesNodeGroupsRequest, ListNodesPagedResponse>
      listNodesPagedCallable() {
    return stub.listNodesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists nodes in the node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   ListNodesNodeGroupsRequest request =
   *       ListNodesNodeGroupsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setNodeGroup("nodeGroup443599261")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setZone("zone3744684")
   *           .build();
   *   while (true) {
   *     NodeGroupsListNodes response = nodeGroupsClient.listNodesCallable().call(request);
   *     for (NodeGroupNode element : response.getItemsList()) {
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
  public final UnaryCallable<ListNodesNodeGroupsRequest, NodeGroupsListNodes> listNodesCallable() {
    return stub.listNodesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String nodeGroup = "nodeGroup443599261";
   *   NodeGroup nodeGroupResource = NodeGroup.newBuilder().build();
   *   Operation response =
   *       nodeGroupsClient.patchAsync(project, zone, nodeGroup, nodeGroupResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param nodeGroup Name of the NodeGroup resource to update.
   * @param nodeGroupResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String zone, String nodeGroup, NodeGroup nodeGroupResource) {
    PatchNodeGroupRequest request =
        PatchNodeGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setNodeGroup(nodeGroup)
            .setNodeGroupResource(nodeGroupResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   PatchNodeGroupRequest request =
   *       PatchNodeGroupRequest.newBuilder()
   *           .setNodeGroup("nodeGroup443599261")
   *           .setNodeGroupResource(NodeGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = nodeGroupsClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(PatchNodeGroupRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   PatchNodeGroupRequest request =
   *       PatchNodeGroupRequest.newBuilder()
   *           .setNodeGroup("nodeGroup443599261")
   *           .setNodeGroupResource(NodeGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       nodeGroupsClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchNodeGroupRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   PatchNodeGroupRequest request =
   *       PatchNodeGroupRequest.newBuilder()
   *           .setNodeGroup("nodeGroup443599261")
   *           .setNodeGroupResource(NodeGroup.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = nodeGroupsClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchNodeGroupRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String resource = "resource-341064690";
   *   ZoneSetPolicyRequest zoneSetPolicyRequestResource = ZoneSetPolicyRequest.newBuilder().build();
   *   Policy response =
   *       nodeGroupsClient.setIamPolicy(project, zone, resource, zoneSetPolicyRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param resource Name or id of the resource for this request.
   * @param zoneSetPolicyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(
      String project,
      String zone,
      String resource,
      ZoneSetPolicyRequest zoneSetPolicyRequestResource) {
    SetIamPolicyNodeGroupRequest request =
        SetIamPolicyNodeGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setResource(resource)
            .setZoneSetPolicyRequestResource(zoneSetPolicyRequestResource)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   SetIamPolicyNodeGroupRequest request =
   *       SetIamPolicyNodeGroupRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .setZoneSetPolicyRequestResource(ZoneSetPolicyRequest.newBuilder().build())
   *           .build();
   *   Policy response = nodeGroupsClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyNodeGroupRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   SetIamPolicyNodeGroupRequest request =
   *       SetIamPolicyNodeGroupRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setZone("zone3744684")
   *           .setZoneSetPolicyRequestResource(ZoneSetPolicyRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = nodeGroupsClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyNodeGroupRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the node template of the node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String nodeGroup = "nodeGroup443599261";
   *   NodeGroupsSetNodeTemplateRequest nodeGroupsSetNodeTemplateRequestResource =
   *       NodeGroupsSetNodeTemplateRequest.newBuilder().build();
   *   Operation response =
   *       nodeGroupsClient
   *           .setNodeTemplateAsync(
   *               project, zone, nodeGroup, nodeGroupsSetNodeTemplateRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param nodeGroup Name of the NodeGroup resource to update.
   * @param nodeGroupsSetNodeTemplateRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setNodeTemplateAsync(
      String project,
      String zone,
      String nodeGroup,
      NodeGroupsSetNodeTemplateRequest nodeGroupsSetNodeTemplateRequestResource) {
    SetNodeTemplateNodeGroupRequest request =
        SetNodeTemplateNodeGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setNodeGroup(nodeGroup)
            .setNodeGroupsSetNodeTemplateRequestResource(nodeGroupsSetNodeTemplateRequestResource)
            .build();
    return setNodeTemplateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the node template of the node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   SetNodeTemplateNodeGroupRequest request =
   *       SetNodeTemplateNodeGroupRequest.newBuilder()
   *           .setNodeGroup("nodeGroup443599261")
   *           .setNodeGroupsSetNodeTemplateRequestResource(
   *               NodeGroupsSetNodeTemplateRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   Operation response = nodeGroupsClient.setNodeTemplateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setNodeTemplateAsync(
      SetNodeTemplateNodeGroupRequest request) {
    return setNodeTemplateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the node template of the node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   SetNodeTemplateNodeGroupRequest request =
   *       SetNodeTemplateNodeGroupRequest.newBuilder()
   *           .setNodeGroup("nodeGroup443599261")
   *           .setNodeGroupsSetNodeTemplateRequestResource(
   *               NodeGroupsSetNodeTemplateRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       nodeGroupsClient.setNodeTemplateOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetNodeTemplateNodeGroupRequest, Operation, Operation>
      setNodeTemplateOperationCallable() {
    return stub.setNodeTemplateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the node template of the node group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   SetNodeTemplateNodeGroupRequest request =
   *       SetNodeTemplateNodeGroupRequest.newBuilder()
   *           .setNodeGroup("nodeGroup443599261")
   *           .setNodeGroupsSetNodeTemplateRequestResource(
   *               NodeGroupsSetNodeTemplateRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<Operation> future = nodeGroupsClient.setNodeTemplateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetNodeTemplateNodeGroupRequest, Operation> setNodeTemplateCallable() {
    return stub.setNodeTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   String project = "project-309310695";
   *   String zone = "zone3744684";
   *   String resource = "resource-341064690";
   *   TestPermissionsRequest testPermissionsRequestResource =
   *       TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response =
   *       nodeGroupsClient.testIamPermissions(
   *           project, zone, resource, testPermissionsRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param zone The name of the zone for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project,
      String zone,
      String resource,
      TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsNodeGroupRequest request =
        TestIamPermissionsNodeGroupRequest.newBuilder()
            .setProject(project)
            .setZone(zone)
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   TestIamPermissionsNodeGroupRequest request =
   *       TestIamPermissionsNodeGroupRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   TestPermissionsResponse response = nodeGroupsClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsNodeGroupRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NodeGroupsClient nodeGroupsClient = NodeGroupsClient.create()) {
   *   TestIamPermissionsNodeGroupRequest request =
   *       TestIamPermissionsNodeGroupRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .setZone("zone3744684")
   *           .build();
   *   ApiFuture<TestPermissionsResponse> future =
   *       nodeGroupsClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>
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
          AggregatedListNodeGroupsRequest,
          NodeGroupAggregatedList,
          Map.Entry<String, NodeGroupsScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListNodeGroupsRequest,
                NodeGroupAggregatedList,
                Map.Entry<String, NodeGroupsScopedList>>
            context,
        ApiFuture<NodeGroupAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new AggregatedListPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private AggregatedListPagedResponse(AggregatedListPage page) {
      super(page, AggregatedListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPage
      extends AbstractPage<
          AggregatedListNodeGroupsRequest,
          NodeGroupAggregatedList,
          Map.Entry<String, NodeGroupsScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListNodeGroupsRequest,
                NodeGroupAggregatedList,
                Map.Entry<String, NodeGroupsScopedList>>
            context,
        NodeGroupAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListNodeGroupsRequest,
                NodeGroupAggregatedList,
                Map.Entry<String, NodeGroupsScopedList>>
            context,
        NodeGroupAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListNodeGroupsRequest,
                NodeGroupAggregatedList,
                Map.Entry<String, NodeGroupsScopedList>>
            context,
        ApiFuture<NodeGroupAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListNodeGroupsRequest,
          NodeGroupAggregatedList,
          Map.Entry<String, NodeGroupsScopedList>,
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
          ListNodeGroupsRequest, NodeGroupList, NodeGroup, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListNodeGroupsRequest, NodeGroupList, NodeGroup> context,
        ApiFuture<NodeGroupList> futureResponse) {
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
      extends AbstractPage<ListNodeGroupsRequest, NodeGroupList, NodeGroup, ListPage> {

    private ListPage(
        PageContext<ListNodeGroupsRequest, NodeGroupList, NodeGroup> context,
        NodeGroupList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListNodeGroupsRequest, NodeGroupList, NodeGroup> context,
        NodeGroupList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListNodeGroupsRequest, NodeGroupList, NodeGroup> context,
        ApiFuture<NodeGroupList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNodeGroupsRequest, NodeGroupList, NodeGroup, ListPage, ListFixedSizeCollection> {

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

  public static class ListNodesPagedResponse
      extends AbstractPagedListResponse<
          ListNodesNodeGroupsRequest,
          NodeGroupsListNodes,
          NodeGroupNode,
          ListNodesPage,
          ListNodesFixedSizeCollection> {

    public static ApiFuture<ListNodesPagedResponse> createAsync(
        PageContext<ListNodesNodeGroupsRequest, NodeGroupsListNodes, NodeGroupNode> context,
        ApiFuture<NodeGroupsListNodes> futureResponse) {
      ApiFuture<ListNodesPage> futurePage =
          ListNodesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListNodesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListNodesPagedResponse(ListNodesPage page) {
      super(page, ListNodesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNodesPage
      extends AbstractPage<
          ListNodesNodeGroupsRequest, NodeGroupsListNodes, NodeGroupNode, ListNodesPage> {

    private ListNodesPage(
        PageContext<ListNodesNodeGroupsRequest, NodeGroupsListNodes, NodeGroupNode> context,
        NodeGroupsListNodes response) {
      super(context, response);
    }

    private static ListNodesPage createEmptyPage() {
      return new ListNodesPage(null, null);
    }

    @Override
    protected ListNodesPage createPage(
        PageContext<ListNodesNodeGroupsRequest, NodeGroupsListNodes, NodeGroupNode> context,
        NodeGroupsListNodes response) {
      return new ListNodesPage(context, response);
    }

    @Override
    public ApiFuture<ListNodesPage> createPageAsync(
        PageContext<ListNodesNodeGroupsRequest, NodeGroupsListNodes, NodeGroupNode> context,
        ApiFuture<NodeGroupsListNodes> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNodesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNodesNodeGroupsRequest,
          NodeGroupsListNodes,
          NodeGroupNode,
          ListNodesPage,
          ListNodesFixedSizeCollection> {

    private ListNodesFixedSizeCollection(List<ListNodesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNodesFixedSizeCollection createEmptyCollection() {
      return new ListNodesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNodesFixedSizeCollection createCollection(
        List<ListNodesPage> pages, int collectionSize) {
      return new ListNodesFixedSizeCollection(pages, collectionSize);
    }
  }
}
