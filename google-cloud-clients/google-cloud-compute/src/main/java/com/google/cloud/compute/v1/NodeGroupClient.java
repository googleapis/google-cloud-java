/*
 * Copyright 2018 Google LLC
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
import com.google.cloud.compute.v1.stub.NodeGroupStub;
import com.google.cloud.compute.v1.stub.NodeGroupStubSettings;
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
 * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
 *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
 *   NodeGroupsAddNodesRequest nodeGroupsAddNodesRequestResource = NodeGroupsAddNodesRequest.newBuilder().build();
 *   Operation response = nodeGroupClient.addNodesNodeGroup(nodeGroup, nodeGroupsAddNodesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the nodeGroupClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of NodeGroupSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * NodeGroupSettings nodeGroupSettings =
 *     NodeGroupSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NodeGroupClient nodeGroupClient =
 *     NodeGroupClient.create(nodeGroupSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * NodeGroupSettings nodeGroupSettings =
 *     NodeGroupSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NodeGroupClient nodeGroupClient =
 *     NodeGroupClient.create(nodeGroupSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NodeGroupClient implements BackgroundResource {
  private final NodeGroupSettings settings;
  private final NodeGroupStub stub;

  /** Constructs an instance of NodeGroupClient with default settings. */
  public static final NodeGroupClient create() throws IOException {
    return create(NodeGroupSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NodeGroupClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NodeGroupClient create(NodeGroupSettings settings) throws IOException {
    return new NodeGroupClient(settings);
  }

  /**
   * Constructs an instance of NodeGroupClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use NodeGroupSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final NodeGroupClient create(NodeGroupStub stub) {
    return new NodeGroupClient(stub);
  }

  /**
   * Constructs an instance of NodeGroupClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected NodeGroupClient(NodeGroupSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NodeGroupStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected NodeGroupClient(NodeGroupStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NodeGroupSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NodeGroupStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds specified number of nodes to the node group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   NodeGroupsAddNodesRequest nodeGroupsAddNodesRequestResource = NodeGroupsAddNodesRequest.newBuilder().build();
   *   Operation response = nodeGroupClient.addNodesNodeGroup(nodeGroup, nodeGroupsAddNodesRequestResource);
   * }
   * </code></pre>
   *
   * @param nodeGroup Name of the NodeGroup resource to delete.
   * @param nodeGroupsAddNodesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addNodesNodeGroup(
      ProjectZoneNodeGroupName nodeGroup,
      NodeGroupsAddNodesRequest nodeGroupsAddNodesRequestResource) {

    AddNodesNodeGroupHttpRequest request =
        AddNodesNodeGroupHttpRequest.newBuilder()
            .setNodeGroup(nodeGroup == null ? null : nodeGroup.toString())
            .setNodeGroupsAddNodesRequestResource(nodeGroupsAddNodesRequestResource)
            .build();
    return addNodesNodeGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds specified number of nodes to the node group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   NodeGroupsAddNodesRequest nodeGroupsAddNodesRequestResource = NodeGroupsAddNodesRequest.newBuilder().build();
   *   Operation response = nodeGroupClient.addNodesNodeGroup(nodeGroup.toString(), nodeGroupsAddNodesRequestResource);
   * }
   * </code></pre>
   *
   * @param nodeGroup Name of the NodeGroup resource to delete.
   * @param nodeGroupsAddNodesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addNodesNodeGroup(
      String nodeGroup, NodeGroupsAddNodesRequest nodeGroupsAddNodesRequestResource) {

    AddNodesNodeGroupHttpRequest request =
        AddNodesNodeGroupHttpRequest.newBuilder()
            .setNodeGroup(nodeGroup)
            .setNodeGroupsAddNodesRequestResource(nodeGroupsAddNodesRequestResource)
            .build();
    return addNodesNodeGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds specified number of nodes to the node group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   NodeGroupsAddNodesRequest nodeGroupsAddNodesRequestResource = NodeGroupsAddNodesRequest.newBuilder().build();
   *   AddNodesNodeGroupHttpRequest request = AddNodesNodeGroupHttpRequest.newBuilder()
   *     .setNodeGroup(nodeGroup.toString())
   *     .setNodeGroupsAddNodesRequestResource(nodeGroupsAddNodesRequestResource)
   *     .build();
   *   Operation response = nodeGroupClient.addNodesNodeGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addNodesNodeGroup(AddNodesNodeGroupHttpRequest request) {
    return addNodesNodeGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds specified number of nodes to the node group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   NodeGroupsAddNodesRequest nodeGroupsAddNodesRequestResource = NodeGroupsAddNodesRequest.newBuilder().build();
   *   AddNodesNodeGroupHttpRequest request = AddNodesNodeGroupHttpRequest.newBuilder()
   *     .setNodeGroup(nodeGroup.toString())
   *     .setNodeGroupsAddNodesRequestResource(nodeGroupsAddNodesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = nodeGroupClient.addNodesNodeGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<AddNodesNodeGroupHttpRequest, Operation> addNodesNodeGroupCallable() {
    return stub.addNodesNodeGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node groups. Note: use nodeGroups.listNodes for more details
   * about each group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (NodeGroupsScopedList element : nodeGroupClient.aggregatedListNodeGroups(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListNodeGroupsPagedResponse aggregatedListNodeGroups(ProjectName project) {
    AggregatedListNodeGroupsHttpRequest request =
        AggregatedListNodeGroupsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListNodeGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node groups. Note: use nodeGroups.listNodes for more details
   * about each group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (NodeGroupsScopedList element : nodeGroupClient.aggregatedListNodeGroups(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListNodeGroupsPagedResponse aggregatedListNodeGroups(String project) {
    AggregatedListNodeGroupsHttpRequest request =
        AggregatedListNodeGroupsHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListNodeGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node groups. Note: use nodeGroups.listNodes for more details
   * about each group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListNodeGroupsHttpRequest request = AggregatedListNodeGroupsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (NodeGroupsScopedList element : nodeGroupClient.aggregatedListNodeGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListNodeGroupsPagedResponse aggregatedListNodeGroups(
      AggregatedListNodeGroupsHttpRequest request) {
    return aggregatedListNodeGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node groups. Note: use nodeGroups.listNodes for more details
   * about each group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListNodeGroupsHttpRequest request = AggregatedListNodeGroupsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;AggregatedListNodeGroupsPagedResponse&gt; future = nodeGroupClient.aggregatedListNodeGroupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (NodeGroupsScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListNodeGroupsHttpRequest, AggregatedListNodeGroupsPagedResponse>
      aggregatedListNodeGroupsPagedCallable() {
    return stub.aggregatedListNodeGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node groups. Note: use nodeGroups.listNodes for more details
   * about each group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListNodeGroupsHttpRequest request = AggregatedListNodeGroupsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     NodeGroupAggregatedList response = nodeGroupClient.aggregatedListNodeGroupsCallable().call(request);
   *     for (NodeGroupsScopedList element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList>
      aggregatedListNodeGroupsCallable() {
    return stub.aggregatedListNodeGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NodeGroup resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   Operation response = nodeGroupClient.deleteNodeGroup(nodeGroup);
   * }
   * </code></pre>
   *
   * @param nodeGroup Name of the NodeGroup resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteNodeGroup(ProjectZoneNodeGroupName nodeGroup) {

    DeleteNodeGroupHttpRequest request =
        DeleteNodeGroupHttpRequest.newBuilder()
            .setNodeGroup(nodeGroup == null ? null : nodeGroup.toString())
            .build();
    return deleteNodeGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NodeGroup resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   Operation response = nodeGroupClient.deleteNodeGroup(nodeGroup.toString());
   * }
   * </code></pre>
   *
   * @param nodeGroup Name of the NodeGroup resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteNodeGroup(String nodeGroup) {

    DeleteNodeGroupHttpRequest request =
        DeleteNodeGroupHttpRequest.newBuilder().setNodeGroup(nodeGroup).build();
    return deleteNodeGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NodeGroup resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   DeleteNodeGroupHttpRequest request = DeleteNodeGroupHttpRequest.newBuilder()
   *     .setNodeGroup(nodeGroup.toString())
   *     .build();
   *   Operation response = nodeGroupClient.deleteNodeGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteNodeGroup(DeleteNodeGroupHttpRequest request) {
    return deleteNodeGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NodeGroup resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   DeleteNodeGroupHttpRequest request = DeleteNodeGroupHttpRequest.newBuilder()
   *     .setNodeGroup(nodeGroup.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = nodeGroupClient.deleteNodeGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteNodeGroupHttpRequest, Operation> deleteNodeGroupCallable() {
    return stub.deleteNodeGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes specified nodes from the node group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   NodeGroupsDeleteNodesRequest nodeGroupsDeleteNodesRequestResource = NodeGroupsDeleteNodesRequest.newBuilder().build();
   *   Operation response = nodeGroupClient.deleteNodesNodeGroup(nodeGroup, nodeGroupsDeleteNodesRequestResource);
   * }
   * </code></pre>
   *
   * @param nodeGroup Name of the NodeGroup resource to delete.
   * @param nodeGroupsDeleteNodesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteNodesNodeGroup(
      ProjectZoneNodeGroupName nodeGroup,
      NodeGroupsDeleteNodesRequest nodeGroupsDeleteNodesRequestResource) {

    DeleteNodesNodeGroupHttpRequest request =
        DeleteNodesNodeGroupHttpRequest.newBuilder()
            .setNodeGroup(nodeGroup == null ? null : nodeGroup.toString())
            .setNodeGroupsDeleteNodesRequestResource(nodeGroupsDeleteNodesRequestResource)
            .build();
    return deleteNodesNodeGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes specified nodes from the node group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   NodeGroupsDeleteNodesRequest nodeGroupsDeleteNodesRequestResource = NodeGroupsDeleteNodesRequest.newBuilder().build();
   *   Operation response = nodeGroupClient.deleteNodesNodeGroup(nodeGroup.toString(), nodeGroupsDeleteNodesRequestResource);
   * }
   * </code></pre>
   *
   * @param nodeGroup Name of the NodeGroup resource to delete.
   * @param nodeGroupsDeleteNodesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteNodesNodeGroup(
      String nodeGroup, NodeGroupsDeleteNodesRequest nodeGroupsDeleteNodesRequestResource) {

    DeleteNodesNodeGroupHttpRequest request =
        DeleteNodesNodeGroupHttpRequest.newBuilder()
            .setNodeGroup(nodeGroup)
            .setNodeGroupsDeleteNodesRequestResource(nodeGroupsDeleteNodesRequestResource)
            .build();
    return deleteNodesNodeGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes specified nodes from the node group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   NodeGroupsDeleteNodesRequest nodeGroupsDeleteNodesRequestResource = NodeGroupsDeleteNodesRequest.newBuilder().build();
   *   DeleteNodesNodeGroupHttpRequest request = DeleteNodesNodeGroupHttpRequest.newBuilder()
   *     .setNodeGroup(nodeGroup.toString())
   *     .setNodeGroupsDeleteNodesRequestResource(nodeGroupsDeleteNodesRequestResource)
   *     .build();
   *   Operation response = nodeGroupClient.deleteNodesNodeGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteNodesNodeGroup(DeleteNodesNodeGroupHttpRequest request) {
    return deleteNodesNodeGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes specified nodes from the node group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   NodeGroupsDeleteNodesRequest nodeGroupsDeleteNodesRequestResource = NodeGroupsDeleteNodesRequest.newBuilder().build();
   *   DeleteNodesNodeGroupHttpRequest request = DeleteNodesNodeGroupHttpRequest.newBuilder()
   *     .setNodeGroup(nodeGroup.toString())
   *     .setNodeGroupsDeleteNodesRequestResource(nodeGroupsDeleteNodesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = nodeGroupClient.deleteNodesNodeGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteNodesNodeGroupHttpRequest, Operation>
      deleteNodesNodeGroupCallable() {
    return stub.deleteNodesNodeGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified NodeGroup. Get a list of available NodeGroups by making a list() request.
   * Note: the "nodes" field should not be used. Use nodeGroups.listNodes instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   NodeGroup response = nodeGroupClient.getNodeGroup(nodeGroup);
   * }
   * </code></pre>
   *
   * @param nodeGroup Name of the node group to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NodeGroup getNodeGroup(ProjectZoneNodeGroupName nodeGroup) {

    GetNodeGroupHttpRequest request =
        GetNodeGroupHttpRequest.newBuilder()
            .setNodeGroup(nodeGroup == null ? null : nodeGroup.toString())
            .build();
    return getNodeGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified NodeGroup. Get a list of available NodeGroups by making a list() request.
   * Note: the "nodes" field should not be used. Use nodeGroups.listNodes instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   NodeGroup response = nodeGroupClient.getNodeGroup(nodeGroup.toString());
   * }
   * </code></pre>
   *
   * @param nodeGroup Name of the node group to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NodeGroup getNodeGroup(String nodeGroup) {

    GetNodeGroupHttpRequest request =
        GetNodeGroupHttpRequest.newBuilder().setNodeGroup(nodeGroup).build();
    return getNodeGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified NodeGroup. Get a list of available NodeGroups by making a list() request.
   * Note: the "nodes" field should not be used. Use nodeGroups.listNodes instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   GetNodeGroupHttpRequest request = GetNodeGroupHttpRequest.newBuilder()
   *     .setNodeGroup(nodeGroup.toString())
   *     .build();
   *   NodeGroup response = nodeGroupClient.getNodeGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NodeGroup getNodeGroup(GetNodeGroupHttpRequest request) {
    return getNodeGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified NodeGroup. Get a list of available NodeGroups by making a list() request.
   * Note: the "nodes" field should not be used. Use nodeGroups.listNodes instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   GetNodeGroupHttpRequest request = GetNodeGroupHttpRequest.newBuilder()
   *     .setNodeGroup(nodeGroup.toString())
   *     .build();
   *   ApiFuture&lt;NodeGroup&gt; future = nodeGroupClient.getNodeGroupCallable().futureCall(request);
   *   // Do something
   *   NodeGroup response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetNodeGroupHttpRequest, NodeGroup> getNodeGroupCallable() {
    return stub.getNodeGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a NodeGroup resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   Integer initialNodeCount = 0;
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   NodeGroup nodeGroupResource = NodeGroup.newBuilder().build();
   *   Operation response = nodeGroupClient.insertNodeGroup(initialNodeCount, zone, nodeGroupResource);
   * }
   * </code></pre>
   *
   * @param initialNodeCount Initial count of nodes in the node group.
   * @param zone The name of the zone for this request.
   * @param nodeGroupResource A NodeGroup resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertNodeGroup(
      Integer initialNodeCount, ProjectZoneName zone, NodeGroup nodeGroupResource) {

    InsertNodeGroupHttpRequest request =
        InsertNodeGroupHttpRequest.newBuilder()
            .setInitialNodeCount(initialNodeCount)
            .setZone(zone == null ? null : zone.toString())
            .setNodeGroupResource(nodeGroupResource)
            .build();
    return insertNodeGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a NodeGroup resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   Integer initialNodeCount = 0;
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   NodeGroup nodeGroupResource = NodeGroup.newBuilder().build();
   *   Operation response = nodeGroupClient.insertNodeGroup(initialNodeCount, zone.toString(), nodeGroupResource);
   * }
   * </code></pre>
   *
   * @param initialNodeCount Initial count of nodes in the node group.
   * @param zone The name of the zone for this request.
   * @param nodeGroupResource A NodeGroup resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertNodeGroup(
      Integer initialNodeCount, String zone, NodeGroup nodeGroupResource) {

    InsertNodeGroupHttpRequest request =
        InsertNodeGroupHttpRequest.newBuilder()
            .setInitialNodeCount(initialNodeCount)
            .setZone(zone)
            .setNodeGroupResource(nodeGroupResource)
            .build();
    return insertNodeGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a NodeGroup resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   Integer initialNodeCount = 0;
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   NodeGroup nodeGroupResource = NodeGroup.newBuilder().build();
   *   InsertNodeGroupHttpRequest request = InsertNodeGroupHttpRequest.newBuilder()
   *     .setInitialNodeCount(initialNodeCount)
   *     .setZone(zone.toString())
   *     .setNodeGroupResource(nodeGroupResource)
   *     .build();
   *   Operation response = nodeGroupClient.insertNodeGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertNodeGroup(InsertNodeGroupHttpRequest request) {
    return insertNodeGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a NodeGroup resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   Integer initialNodeCount = 0;
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   NodeGroup nodeGroupResource = NodeGroup.newBuilder().build();
   *   InsertNodeGroupHttpRequest request = InsertNodeGroupHttpRequest.newBuilder()
   *     .setInitialNodeCount(initialNodeCount)
   *     .setZone(zone.toString())
   *     .setNodeGroupResource(nodeGroupResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = nodeGroupClient.insertNodeGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertNodeGroupHttpRequest, Operation> insertNodeGroupCallable() {
    return stub.insertNodeGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node groups available to the specified project. Note: use
   * nodeGroups.listNodes for more details about each group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (NodeGroup element : nodeGroupClient.listNodeGroups(zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNodeGroupsPagedResponse listNodeGroups(ProjectZoneName zone) {
    ListNodeGroupsHttpRequest request =
        ListNodeGroupsHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .build();
    return listNodeGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node groups available to the specified project. Note: use
   * nodeGroups.listNodes for more details about each group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (NodeGroup element : nodeGroupClient.listNodeGroups(zone.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNodeGroupsPagedResponse listNodeGroups(String zone) {
    ListNodeGroupsHttpRequest request =
        ListNodeGroupsHttpRequest.newBuilder().setZone(zone).build();
    return listNodeGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node groups available to the specified project. Note: use
   * nodeGroups.listNodes for more details about each group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListNodeGroupsHttpRequest request = ListNodeGroupsHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   for (NodeGroup element : nodeGroupClient.listNodeGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNodeGroupsPagedResponse listNodeGroups(ListNodeGroupsHttpRequest request) {
    return listNodeGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node groups available to the specified project. Note: use
   * nodeGroups.listNodes for more details about each group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListNodeGroupsHttpRequest request = ListNodeGroupsHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   ApiFuture&lt;ListNodeGroupsPagedResponse&gt; future = nodeGroupClient.listNodeGroupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (NodeGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListNodeGroupsHttpRequest, ListNodeGroupsPagedResponse>
      listNodeGroupsPagedCallable() {
    return stub.listNodeGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node groups available to the specified project. Note: use
   * nodeGroups.listNodes for more details about each group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListNodeGroupsHttpRequest request = ListNodeGroupsHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   while (true) {
   *     NodeGroupList response = nodeGroupClient.listNodeGroupsCallable().call(request);
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
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListNodeGroupsHttpRequest, NodeGroupList> listNodeGroupsCallable() {
    return stub.listNodeGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists nodes in the node group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   for (NodeGroupNode element : nodeGroupClient.listNodesNodeGroups(nodeGroup).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param nodeGroup Name of the NodeGroup resource whose nodes you want to list.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNodesNodeGroupsPagedResponse listNodesNodeGroups(
      ProjectZoneNodeGroupName nodeGroup) {
    ListNodesNodeGroupsHttpRequest request =
        ListNodesNodeGroupsHttpRequest.newBuilder()
            .setNodeGroup(nodeGroup == null ? null : nodeGroup.toString())
            .build();
    return listNodesNodeGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists nodes in the node group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   for (NodeGroupNode element : nodeGroupClient.listNodesNodeGroups(nodeGroup.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param nodeGroup Name of the NodeGroup resource whose nodes you want to list.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNodesNodeGroupsPagedResponse listNodesNodeGroups(String nodeGroup) {
    ListNodesNodeGroupsHttpRequest request =
        ListNodesNodeGroupsHttpRequest.newBuilder().setNodeGroup(nodeGroup).build();
    return listNodesNodeGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists nodes in the node group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   ListNodesNodeGroupsHttpRequest request = ListNodesNodeGroupsHttpRequest.newBuilder()
   *     .setNodeGroup(nodeGroup.toString())
   *     .build();
   *   for (NodeGroupNode element : nodeGroupClient.listNodesNodeGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNodesNodeGroupsPagedResponse listNodesNodeGroups(
      ListNodesNodeGroupsHttpRequest request) {
    return listNodesNodeGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists nodes in the node group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   ListNodesNodeGroupsHttpRequest request = ListNodesNodeGroupsHttpRequest.newBuilder()
   *     .setNodeGroup(nodeGroup.toString())
   *     .build();
   *   ApiFuture&lt;ListNodesNodeGroupsPagedResponse&gt; future = nodeGroupClient.listNodesNodeGroupsPagedCallable().futureCall(request);
   *   // Do something
   *   for (NodeGroupNode element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListNodesNodeGroupsHttpRequest, ListNodesNodeGroupsPagedResponse>
      listNodesNodeGroupsPagedCallable() {
    return stub.listNodesNodeGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists nodes in the node group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   ListNodesNodeGroupsHttpRequest request = ListNodesNodeGroupsHttpRequest.newBuilder()
   *     .setNodeGroup(nodeGroup.toString())
   *     .build();
   *   while (true) {
   *     NodeGroupsListNodes response = nodeGroupClient.listNodesNodeGroupsCallable().call(request);
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
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes>
      listNodesNodeGroupsCallable() {
    return stub.listNodesNodeGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the node template of the node group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   NodeGroupsSetNodeTemplateRequest nodeGroupsSetNodeTemplateRequestResource = NodeGroupsSetNodeTemplateRequest.newBuilder().build();
   *   Operation response = nodeGroupClient.setNodeTemplateNodeGroup(nodeGroup, nodeGroupsSetNodeTemplateRequestResource);
   * }
   * </code></pre>
   *
   * @param nodeGroup Name of the NodeGroup resource to delete.
   * @param nodeGroupsSetNodeTemplateRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setNodeTemplateNodeGroup(
      ProjectZoneNodeGroupName nodeGroup,
      NodeGroupsSetNodeTemplateRequest nodeGroupsSetNodeTemplateRequestResource) {

    SetNodeTemplateNodeGroupHttpRequest request =
        SetNodeTemplateNodeGroupHttpRequest.newBuilder()
            .setNodeGroup(nodeGroup == null ? null : nodeGroup.toString())
            .setNodeGroupsSetNodeTemplateRequestResource(nodeGroupsSetNodeTemplateRequestResource)
            .build();
    return setNodeTemplateNodeGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the node template of the node group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   NodeGroupsSetNodeTemplateRequest nodeGroupsSetNodeTemplateRequestResource = NodeGroupsSetNodeTemplateRequest.newBuilder().build();
   *   Operation response = nodeGroupClient.setNodeTemplateNodeGroup(nodeGroup.toString(), nodeGroupsSetNodeTemplateRequestResource);
   * }
   * </code></pre>
   *
   * @param nodeGroup Name of the NodeGroup resource to delete.
   * @param nodeGroupsSetNodeTemplateRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setNodeTemplateNodeGroup(
      String nodeGroup, NodeGroupsSetNodeTemplateRequest nodeGroupsSetNodeTemplateRequestResource) {

    SetNodeTemplateNodeGroupHttpRequest request =
        SetNodeTemplateNodeGroupHttpRequest.newBuilder()
            .setNodeGroup(nodeGroup)
            .setNodeGroupsSetNodeTemplateRequestResource(nodeGroupsSetNodeTemplateRequestResource)
            .build();
    return setNodeTemplateNodeGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the node template of the node group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   NodeGroupsSetNodeTemplateRequest nodeGroupsSetNodeTemplateRequestResource = NodeGroupsSetNodeTemplateRequest.newBuilder().build();
   *   SetNodeTemplateNodeGroupHttpRequest request = SetNodeTemplateNodeGroupHttpRequest.newBuilder()
   *     .setNodeGroup(nodeGroup.toString())
   *     .setNodeGroupsSetNodeTemplateRequestResource(nodeGroupsSetNodeTemplateRequestResource)
   *     .build();
   *   Operation response = nodeGroupClient.setNodeTemplateNodeGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setNodeTemplateNodeGroup(SetNodeTemplateNodeGroupHttpRequest request) {
    return setNodeTemplateNodeGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the node template of the node group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeGroupClient nodeGroupClient = NodeGroupClient.create()) {
   *   ProjectZoneNodeGroupName nodeGroup = ProjectZoneNodeGroupName.of("[PROJECT]", "[ZONE]", "[NODE_GROUP]");
   *   NodeGroupsSetNodeTemplateRequest nodeGroupsSetNodeTemplateRequestResource = NodeGroupsSetNodeTemplateRequest.newBuilder().build();
   *   SetNodeTemplateNodeGroupHttpRequest request = SetNodeTemplateNodeGroupHttpRequest.newBuilder()
   *     .setNodeGroup(nodeGroup.toString())
   *     .setNodeGroupsSetNodeTemplateRequestResource(nodeGroupsSetNodeTemplateRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = nodeGroupClient.setNodeTemplateNodeGroupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetNodeTemplateNodeGroupHttpRequest, Operation>
      setNodeTemplateNodeGroupCallable() {
    return stub.setNodeTemplateNodeGroupCallable();
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

  public static class AggregatedListNodeGroupsPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListNodeGroupsHttpRequest,
          NodeGroupAggregatedList,
          NodeGroupsScopedList,
          AggregatedListNodeGroupsPage,
          AggregatedListNodeGroupsFixedSizeCollection> {

    public static ApiFuture<AggregatedListNodeGroupsPagedResponse> createAsync(
        PageContext<
                AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList, NodeGroupsScopedList>
            context,
        ApiFuture<NodeGroupAggregatedList> futureResponse) {
      ApiFuture<AggregatedListNodeGroupsPage> futurePage =
          AggregatedListNodeGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListNodeGroupsPage, AggregatedListNodeGroupsPagedResponse>() {
            @Override
            public AggregatedListNodeGroupsPagedResponse apply(AggregatedListNodeGroupsPage input) {
              return new AggregatedListNodeGroupsPagedResponse(input);
            }
          });
    }

    private AggregatedListNodeGroupsPagedResponse(AggregatedListNodeGroupsPage page) {
      super(page, AggregatedListNodeGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListNodeGroupsPage
      extends AbstractPage<
          AggregatedListNodeGroupsHttpRequest,
          NodeGroupAggregatedList,
          NodeGroupsScopedList,
          AggregatedListNodeGroupsPage> {

    private AggregatedListNodeGroupsPage(
        PageContext<
                AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList, NodeGroupsScopedList>
            context,
        NodeGroupAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListNodeGroupsPage createEmptyPage() {
      return new AggregatedListNodeGroupsPage(null, null);
    }

    @Override
    protected AggregatedListNodeGroupsPage createPage(
        PageContext<
                AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList, NodeGroupsScopedList>
            context,
        NodeGroupAggregatedList response) {
      return new AggregatedListNodeGroupsPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListNodeGroupsPage> createPageAsync(
        PageContext<
                AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList, NodeGroupsScopedList>
            context,
        ApiFuture<NodeGroupAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListNodeGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListNodeGroupsHttpRequest,
          NodeGroupAggregatedList,
          NodeGroupsScopedList,
          AggregatedListNodeGroupsPage,
          AggregatedListNodeGroupsFixedSizeCollection> {

    private AggregatedListNodeGroupsFixedSizeCollection(
        List<AggregatedListNodeGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListNodeGroupsFixedSizeCollection createEmptyCollection() {
      return new AggregatedListNodeGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListNodeGroupsFixedSizeCollection createCollection(
        List<AggregatedListNodeGroupsPage> pages, int collectionSize) {
      return new AggregatedListNodeGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNodeGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListNodeGroupsHttpRequest,
          NodeGroupList,
          NodeGroup,
          ListNodeGroupsPage,
          ListNodeGroupsFixedSizeCollection> {

    public static ApiFuture<ListNodeGroupsPagedResponse> createAsync(
        PageContext<ListNodeGroupsHttpRequest, NodeGroupList, NodeGroup> context,
        ApiFuture<NodeGroupList> futureResponse) {
      ApiFuture<ListNodeGroupsPage> futurePage =
          ListNodeGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListNodeGroupsPage, ListNodeGroupsPagedResponse>() {
            @Override
            public ListNodeGroupsPagedResponse apply(ListNodeGroupsPage input) {
              return new ListNodeGroupsPagedResponse(input);
            }
          });
    }

    private ListNodeGroupsPagedResponse(ListNodeGroupsPage page) {
      super(page, ListNodeGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNodeGroupsPage
      extends AbstractPage<
          ListNodeGroupsHttpRequest, NodeGroupList, NodeGroup, ListNodeGroupsPage> {

    private ListNodeGroupsPage(
        PageContext<ListNodeGroupsHttpRequest, NodeGroupList, NodeGroup> context,
        NodeGroupList response) {
      super(context, response);
    }

    private static ListNodeGroupsPage createEmptyPage() {
      return new ListNodeGroupsPage(null, null);
    }

    @Override
    protected ListNodeGroupsPage createPage(
        PageContext<ListNodeGroupsHttpRequest, NodeGroupList, NodeGroup> context,
        NodeGroupList response) {
      return new ListNodeGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListNodeGroupsPage> createPageAsync(
        PageContext<ListNodeGroupsHttpRequest, NodeGroupList, NodeGroup> context,
        ApiFuture<NodeGroupList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNodeGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNodeGroupsHttpRequest,
          NodeGroupList,
          NodeGroup,
          ListNodeGroupsPage,
          ListNodeGroupsFixedSizeCollection> {

    private ListNodeGroupsFixedSizeCollection(List<ListNodeGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNodeGroupsFixedSizeCollection createEmptyCollection() {
      return new ListNodeGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNodeGroupsFixedSizeCollection createCollection(
        List<ListNodeGroupsPage> pages, int collectionSize) {
      return new ListNodeGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNodesNodeGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListNodesNodeGroupsHttpRequest,
          NodeGroupsListNodes,
          NodeGroupNode,
          ListNodesNodeGroupsPage,
          ListNodesNodeGroupsFixedSizeCollection> {

    public static ApiFuture<ListNodesNodeGroupsPagedResponse> createAsync(
        PageContext<ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes, NodeGroupNode> context,
        ApiFuture<NodeGroupsListNodes> futureResponse) {
      ApiFuture<ListNodesNodeGroupsPage> futurePage =
          ListNodesNodeGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListNodesNodeGroupsPage, ListNodesNodeGroupsPagedResponse>() {
            @Override
            public ListNodesNodeGroupsPagedResponse apply(ListNodesNodeGroupsPage input) {
              return new ListNodesNodeGroupsPagedResponse(input);
            }
          });
    }

    private ListNodesNodeGroupsPagedResponse(ListNodesNodeGroupsPage page) {
      super(page, ListNodesNodeGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNodesNodeGroupsPage
      extends AbstractPage<
          ListNodesNodeGroupsHttpRequest,
          NodeGroupsListNodes,
          NodeGroupNode,
          ListNodesNodeGroupsPage> {

    private ListNodesNodeGroupsPage(
        PageContext<ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes, NodeGroupNode> context,
        NodeGroupsListNodes response) {
      super(context, response);
    }

    private static ListNodesNodeGroupsPage createEmptyPage() {
      return new ListNodesNodeGroupsPage(null, null);
    }

    @Override
    protected ListNodesNodeGroupsPage createPage(
        PageContext<ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes, NodeGroupNode> context,
        NodeGroupsListNodes response) {
      return new ListNodesNodeGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListNodesNodeGroupsPage> createPageAsync(
        PageContext<ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes, NodeGroupNode> context,
        ApiFuture<NodeGroupsListNodes> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNodesNodeGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNodesNodeGroupsHttpRequest,
          NodeGroupsListNodes,
          NodeGroupNode,
          ListNodesNodeGroupsPage,
          ListNodesNodeGroupsFixedSizeCollection> {

    private ListNodesNodeGroupsFixedSizeCollection(
        List<ListNodesNodeGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNodesNodeGroupsFixedSizeCollection createEmptyCollection() {
      return new ListNodesNodeGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNodesNodeGroupsFixedSizeCollection createCollection(
        List<ListNodesNodeGroupsPage> pages, int collectionSize) {
      return new ListNodesNodeGroupsFixedSizeCollection(pages, collectionSize);
    }
  }
}
