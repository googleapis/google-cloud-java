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
package com.google.cloud.container.v1;

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
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.container.v1.stub.ClusterManagerStub;
import com.google.cloud.container.v1.stub.ClusterManagerStubSettings;
import com.google.container.v1beta1.CancelOperationRequest;
import com.google.container.v1beta1.Cluster;
import com.google.container.v1beta1.CompleteIPRotationRequest;
import com.google.container.v1beta1.CreateClusterRequest;
import com.google.container.v1beta1.CreateNodePoolRequest;
import com.google.container.v1beta1.DeleteClusterRequest;
import com.google.container.v1beta1.DeleteNodePoolRequest;
import com.google.container.v1beta1.GetClusterRequest;
import com.google.container.v1beta1.GetNodePoolRequest;
import com.google.container.v1beta1.GetOperationRequest;
import com.google.container.v1beta1.GetServerConfigRequest;
import com.google.container.v1beta1.ListClustersRequest;
import com.google.container.v1beta1.ListClustersResponse;
import com.google.container.v1beta1.ListLocationsRequest;
import com.google.container.v1beta1.ListLocationsResponse;
import com.google.container.v1beta1.ListNodePoolsRequest;
import com.google.container.v1beta1.ListNodePoolsResponse;
import com.google.container.v1beta1.ListOperationsRequest;
import com.google.container.v1beta1.ListOperationsResponse;
import com.google.container.v1beta1.ListUsableSubnetworksRequest;
import com.google.container.v1beta1.ListUsableSubnetworksResponse;
import com.google.container.v1beta1.NodePool;
import com.google.container.v1beta1.Operation;
import com.google.container.v1beta1.RollbackNodePoolUpgradeRequest;
import com.google.container.v1beta1.ServerConfig;
import com.google.container.v1beta1.SetAddonsConfigRequest;
import com.google.container.v1beta1.SetLabelsRequest;
import com.google.container.v1beta1.SetLegacyAbacRequest;
import com.google.container.v1beta1.SetLocationsRequest;
import com.google.container.v1beta1.SetLoggingServiceRequest;
import com.google.container.v1beta1.SetMaintenancePolicyRequest;
import com.google.container.v1beta1.SetMasterAuthRequest;
import com.google.container.v1beta1.SetMonitoringServiceRequest;
import com.google.container.v1beta1.SetNetworkPolicyRequest;
import com.google.container.v1beta1.SetNodePoolAutoscalingRequest;
import com.google.container.v1beta1.SetNodePoolManagementRequest;
import com.google.container.v1beta1.SetNodePoolSizeRequest;
import com.google.container.v1beta1.StartIPRotationRequest;
import com.google.container.v1beta1.UpdateClusterRequest;
import com.google.container.v1beta1.UpdateMasterRequest;
import com.google.container.v1beta1.UpdateNodePoolRequest;
import com.google.container.v1beta1.UsableSubnetwork;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Google Kubernetes Engine Cluster Manager v1beta1
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
 *   String formattedParent = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");
 *   ListClustersResponse response = clusterManagerClient.listClusters(formattedParent);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the clusterManagerClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of ClusterManagerSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ClusterManagerSettings clusterManagerSettings =
 *     ClusterManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ClusterManagerClient clusterManagerClient =
 *     ClusterManagerClient.create(clusterManagerSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ClusterManagerSettings clusterManagerSettings =
 *     ClusterManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ClusterManagerClient clusterManagerClient =
 *     ClusterManagerClient.create(clusterManagerSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ClusterManagerClient implements BackgroundResource {
  private final ClusterManagerSettings settings;
  private final ClusterManagerStub stub;

  private static final PathTemplate PROJECT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}");

  private static final PathTemplate LOCATION_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}");

  private static final PathTemplate CLUSTER_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/clusters/{cluster}");

  private static final PathTemplate NODE_POOL_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/clusters/{cluster}/nodePools/{node_pool}");

  private static final PathTemplate OPERATION_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/operations/{operation}");

  /** Formats a string containing the fully-qualified path to represent a project resource. */
  public static final String formatProjectName(String project) {
    return PROJECT_PATH_TEMPLATE.instantiate("project", project);
  }

  /** Formats a string containing the fully-qualified path to represent a location resource. */
  public static final String formatLocationName(String project, String location) {
    return LOCATION_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location);
  }

  /** Formats a string containing the fully-qualified path to represent a cluster resource. */
  public static final String formatClusterName(String project, String location, String cluster) {
    return CLUSTER_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "cluster", cluster);
  }

  /** Formats a string containing the fully-qualified path to represent a node_pool resource. */
  public static final String formatNodePoolName(
      String project, String location, String cluster, String nodePool) {
    return NODE_POOL_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "cluster", cluster,
        "node_pool", nodePool);
  }

  /** Formats a string containing the fully-qualified path to represent a operation resource. */
  public static final String formatOperationName(
      String project, String location, String operation) {
    return OPERATION_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "operation", operation);
  }

  /** Parses the project from the given fully-qualified path which represents a project resource. */
  public static final String parseProjectFromProjectName(String projectName) {
    return PROJECT_PATH_TEMPLATE.parse(projectName).get("project");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a location resource.
   */
  public static final String parseProjectFromLocationName(String locationName) {
    return LOCATION_PATH_TEMPLATE.parse(locationName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a location resource.
   */
  public static final String parseLocationFromLocationName(String locationName) {
    return LOCATION_PATH_TEMPLATE.parse(locationName).get("location");
  }

  /** Parses the project from the given fully-qualified path which represents a cluster resource. */
  public static final String parseProjectFromClusterName(String clusterName) {
    return CLUSTER_PATH_TEMPLATE.parse(clusterName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a cluster resource.
   */
  public static final String parseLocationFromClusterName(String clusterName) {
    return CLUSTER_PATH_TEMPLATE.parse(clusterName).get("location");
  }

  /** Parses the cluster from the given fully-qualified path which represents a cluster resource. */
  public static final String parseClusterFromClusterName(String clusterName) {
    return CLUSTER_PATH_TEMPLATE.parse(clusterName).get("cluster");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a node_pool resource.
   */
  public static final String parseProjectFromNodePoolName(String nodePoolName) {
    return NODE_POOL_PATH_TEMPLATE.parse(nodePoolName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a node_pool resource.
   */
  public static final String parseLocationFromNodePoolName(String nodePoolName) {
    return NODE_POOL_PATH_TEMPLATE.parse(nodePoolName).get("location");
  }

  /**
   * Parses the cluster from the given fully-qualified path which represents a node_pool resource.
   */
  public static final String parseClusterFromNodePoolName(String nodePoolName) {
    return NODE_POOL_PATH_TEMPLATE.parse(nodePoolName).get("cluster");
  }

  /**
   * Parses the node_pool from the given fully-qualified path which represents a node_pool resource.
   */
  public static final String parseNodePoolFromNodePoolName(String nodePoolName) {
    return NODE_POOL_PATH_TEMPLATE.parse(nodePoolName).get("node_pool");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a operation resource.
   */
  public static final String parseProjectFromOperationName(String operationName) {
    return OPERATION_PATH_TEMPLATE.parse(operationName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a operation resource.
   */
  public static final String parseLocationFromOperationName(String operationName) {
    return OPERATION_PATH_TEMPLATE.parse(operationName).get("location");
  }

  /**
   * Parses the operation from the given fully-qualified path which represents a operation resource.
   */
  public static final String parseOperationFromOperationName(String operationName) {
    return OPERATION_PATH_TEMPLATE.parse(operationName).get("operation");
  }

  /** Constructs an instance of ClusterManagerClient with default settings. */
  public static final ClusterManagerClient create() throws IOException {
    return create(ClusterManagerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ClusterManagerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ClusterManagerClient create(ClusterManagerSettings settings)
      throws IOException {
    return new ClusterManagerClient(settings);
  }

  /**
   * Constructs an instance of ClusterManagerClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use ClusterManagerSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ClusterManagerClient create(ClusterManagerStub stub) {
    return new ClusterManagerClient(stub);
  }

  /**
   * Constructs an instance of ClusterManagerClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ClusterManagerClient(ClusterManagerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ClusterManagerStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ClusterManagerClient(ClusterManagerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ClusterManagerSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ClusterManagerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all clusters owned by a project in either the specified zone or all zones.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedParent = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListClustersResponse response = clusterManagerClient.listClusters(formattedParent);
   * }
   * </code></pre>
   *
   * @param parent The parent (project and location) where the clusters will be listed. Specified in
   *     the format 'projects/&#42;/locations/&#42;'. Location "-" matches all zones and all
   *     regions.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersResponse listClusters(String parent) {
    LOCATION_PATH_TEMPLATE.validate(parent, "listClusters");
    ListClustersRequest request = ListClustersRequest.newBuilder().setParent(parent).build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all clusters owned by a project in either the specified zone or all zones.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedParent = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListClustersRequest request = ListClustersRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ListClustersResponse response = clusterManagerClient.listClusters(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersResponse listClusters(ListClustersRequest request) {
    return listClustersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all clusters owned by a project in either the specified zone or all zones.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedParent = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListClustersRequest request = ListClustersRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListClustersResponse&gt; future = clusterManagerClient.listClustersCallable().futureCall(request);
   *   // Do something
   *   ListClustersResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return stub.listClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the details for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   Cluster response = clusterManagerClient.getCluster(formattedName);
   * }
   * </code></pre>
   *
   * @param name The name (project, location, cluster) of the cluster to retrieve. Specified in the
   *     format 'projects/&#42;/locations/&#42;/clusters/&#42;'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(String name) {
    CLUSTER_PATH_TEMPLATE.validate(name, "getCluster");
    GetClusterRequest request = GetClusterRequest.newBuilder().setName(name).build();
    return getCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the details for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   GetClusterRequest request = GetClusterRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Cluster response = clusterManagerClient.getCluster(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(GetClusterRequest request) {
    return getClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the details for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   GetClusterRequest request = GetClusterRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Cluster&gt; future = clusterManagerClient.getClusterCallable().futureCall(request);
   *   // Do something
   *   Cluster response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return stub.getClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a cluster, consisting of the specified number and type of Google Compute Engine
   * instances.
   *
   * <p>By default, the cluster is created in the project's [default
   * network](/compute/docs/networks-and-firewalls#networks).
   *
   * <p>One firewall is added for the cluster. After cluster creation, the cluster creates routes
   * for each node to allow the containers on that node to communicate with all other instances in
   * the cluster.
   *
   * <p>Finally, an entry is added to the project's global metadata indicating which CIDR range is
   * being used by the cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   Cluster cluster = Cluster.newBuilder().build();
   *   String formattedParent = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   Operation response = clusterManagerClient.createCluster(cluster, formattedParent);
   * }
   * </code></pre>
   *
   * @param cluster A [cluster
   *     resource](/container-engine/reference/rest/v1beta1/projects.zones.clusters)
   * @param parent The parent (project and location) where the cluster will be created. Specified in
   *     the format 'projects/&#42;/locations/&#42;'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createCluster(Cluster cluster, String parent) {
    LOCATION_PATH_TEMPLATE.validate(parent, "createCluster");
    CreateClusterRequest request =
        CreateClusterRequest.newBuilder().setCluster(cluster).setParent(parent).build();
    return createCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a cluster, consisting of the specified number and type of Google Compute Engine
   * instances.
   *
   * <p>By default, the cluster is created in the project's [default
   * network](/compute/docs/networks-and-firewalls#networks).
   *
   * <p>One firewall is added for the cluster. After cluster creation, the cluster creates routes
   * for each node to allow the containers on that node to communicate with all other instances in
   * the cluster.
   *
   * <p>Finally, an entry is added to the project's global metadata indicating which CIDR range is
   * being used by the cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   Cluster cluster = Cluster.newBuilder().build();
   *   String formattedParent = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   CreateClusterRequest request = CreateClusterRequest.newBuilder()
   *     .setCluster(cluster)
   *     .setParent(formattedParent)
   *     .build();
   *   Operation response = clusterManagerClient.createCluster(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createCluster(CreateClusterRequest request) {
    return createClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a cluster, consisting of the specified number and type of Google Compute Engine
   * instances.
   *
   * <p>By default, the cluster is created in the project's [default
   * network](/compute/docs/networks-and-firewalls#networks).
   *
   * <p>One firewall is added for the cluster. After cluster creation, the cluster creates routes
   * for each node to allow the containers on that node to communicate with all other instances in
   * the cluster.
   *
   * <p>Finally, an entry is added to the project's global metadata indicating which CIDR range is
   * being used by the cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   Cluster cluster = Cluster.newBuilder().build();
   *   String formattedParent = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   CreateClusterRequest request = CreateClusterRequest.newBuilder()
   *     .setCluster(cluster)
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.createClusterCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return stub.createClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the settings for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   ClusterUpdate update = ClusterUpdate.newBuilder().build();
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   UpdateClusterRequest request = UpdateClusterRequest.newBuilder()
   *     .setUpdate(update)
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.updateCluster(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateCluster(UpdateClusterRequest request) {
    return updateClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the settings for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   ClusterUpdate update = ClusterUpdate.newBuilder().build();
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   UpdateClusterRequest request = UpdateClusterRequest.newBuilder()
   *     .setUpdate(update)
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.updateClusterCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return stub.updateClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the version and/or image type of a specific node pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String nodeVersion = "";
   *   String imageType = "";
   *   String formattedName = ClusterManagerClient.formatNodePoolName("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");
   *   UpdateNodePoolRequest request = UpdateNodePoolRequest.newBuilder()
   *     .setNodeVersion(nodeVersion)
   *     .setImageType(imageType)
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.updateNodePool(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateNodePool(UpdateNodePoolRequest request) {
    return updateNodePoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the version and/or image type of a specific node pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String nodeVersion = "";
   *   String imageType = "";
   *   String formattedName = ClusterManagerClient.formatNodePoolName("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");
   *   UpdateNodePoolRequest request = UpdateNodePoolRequest.newBuilder()
   *     .setNodeVersion(nodeVersion)
   *     .setImageType(imageType)
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.updateNodePoolCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateNodePoolRequest, Operation> updateNodePoolCallable() {
    return stub.updateNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the autoscaling settings of a specific node pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   NodePoolAutoscaling autoscaling = NodePoolAutoscaling.newBuilder().build();
   *   String formattedName = ClusterManagerClient.formatNodePoolName("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");
   *   SetNodePoolAutoscalingRequest request = SetNodePoolAutoscalingRequest.newBuilder()
   *     .setAutoscaling(autoscaling)
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.setNodePoolAutoscaling(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setNodePoolAutoscaling(SetNodePoolAutoscalingRequest request) {
    return setNodePoolAutoscalingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the autoscaling settings of a specific node pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   NodePoolAutoscaling autoscaling = NodePoolAutoscaling.newBuilder().build();
   *   String formattedName = ClusterManagerClient.formatNodePoolName("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");
   *   SetNodePoolAutoscalingRequest request = SetNodePoolAutoscalingRequest.newBuilder()
   *     .setAutoscaling(autoscaling)
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.setNodePoolAutoscalingCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetNodePoolAutoscalingRequest, Operation>
      setNodePoolAutoscalingCallable() {
    return stub.setNodePoolAutoscalingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the logging service for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String loggingService = "";
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetLoggingServiceRequest request = SetLoggingServiceRequest.newBuilder()
   *     .setLoggingService(loggingService)
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.setLoggingService(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLoggingService(SetLoggingServiceRequest request) {
    return setLoggingServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the logging service for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String loggingService = "";
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetLoggingServiceRequest request = SetLoggingServiceRequest.newBuilder()
   *     .setLoggingService(loggingService)
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.setLoggingServiceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetLoggingServiceRequest, Operation> setLoggingServiceCallable() {
    return stub.setLoggingServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the monitoring service for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String monitoringService = "";
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetMonitoringServiceRequest request = SetMonitoringServiceRequest.newBuilder()
   *     .setMonitoringService(monitoringService)
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.setMonitoringService(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMonitoringService(SetMonitoringServiceRequest request) {
    return setMonitoringServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the monitoring service for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String monitoringService = "";
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetMonitoringServiceRequest request = SetMonitoringServiceRequest.newBuilder()
   *     .setMonitoringService(monitoringService)
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.setMonitoringServiceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetMonitoringServiceRequest, Operation>
      setMonitoringServiceCallable() {
    return stub.setMonitoringServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the addons for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   AddonsConfig addonsConfig = AddonsConfig.newBuilder().build();
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetAddonsConfigRequest request = SetAddonsConfigRequest.newBuilder()
   *     .setAddonsConfig(addonsConfig)
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.setAddonsConfig(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setAddonsConfig(SetAddonsConfigRequest request) {
    return setAddonsConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the addons for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   AddonsConfig addonsConfig = AddonsConfig.newBuilder().build();
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetAddonsConfigRequest request = SetAddonsConfigRequest.newBuilder()
   *     .setAddonsConfig(addonsConfig)
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.setAddonsConfigCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetAddonsConfigRequest, Operation> setAddonsConfigCallable() {
    return stub.setAddonsConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the locations for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   List&lt;String&gt; locations = new ArrayList&lt;&gt;();
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetLocationsRequest request = SetLocationsRequest.newBuilder()
   *     .addAllLocations(locations)
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.setLocations(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLocations(SetLocationsRequest request) {
    return setLocationsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the locations for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   List&lt;String&gt; locations = new ArrayList&lt;&gt;();
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetLocationsRequest request = SetLocationsRequest.newBuilder()
   *     .addAllLocations(locations)
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.setLocationsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetLocationsRequest, Operation> setLocationsCallable() {
    return stub.setLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the master for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String masterVersion = "";
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   UpdateMasterRequest request = UpdateMasterRequest.newBuilder()
   *     .setMasterVersion(masterVersion)
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.updateMaster(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateMaster(UpdateMasterRequest request) {
    return updateMasterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the master for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String masterVersion = "";
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   UpdateMasterRequest request = UpdateMasterRequest.newBuilder()
   *     .setMasterVersion(masterVersion)
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.updateMasterCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateMasterRequest, Operation> updateMasterCallable() {
    return stub.updateMasterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Used to set master auth materials. Currently supports :- Changing the admin password for a
   * specific cluster. This can be either via password generation or explicitly set. Modify
   * basic_auth.csv and reset the K8S API server.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetMasterAuthRequest.Action action = SetMasterAuthRequest.Action.UNKNOWN;
   *   MasterAuth update = MasterAuth.newBuilder().build();
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetMasterAuthRequest request = SetMasterAuthRequest.newBuilder()
   *     .setAction(action)
   *     .setUpdate(update)
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.setMasterAuth(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMasterAuth(SetMasterAuthRequest request) {
    return setMasterAuthCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Used to set master auth materials. Currently supports :- Changing the admin password for a
   * specific cluster. This can be either via password generation or explicitly set. Modify
   * basic_auth.csv and reset the K8S API server.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetMasterAuthRequest.Action action = SetMasterAuthRequest.Action.UNKNOWN;
   *   MasterAuth update = MasterAuth.newBuilder().build();
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetMasterAuthRequest request = SetMasterAuthRequest.newBuilder()
   *     .setAction(action)
   *     .setUpdate(update)
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.setMasterAuthCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetMasterAuthRequest, Operation> setMasterAuthCallable() {
    return stub.setMasterAuthCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the cluster, including the Kubernetes endpoint and all worker nodes.
   *
   * <p>Firewalls and routes that were configured during cluster creation are also deleted.
   *
   * <p>Other Google Compute Engine resources that might be in use by the cluster (e.g. load
   * balancer resources) will not be deleted if they weren't present at the initial create time.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   Operation response = clusterManagerClient.deleteCluster(formattedName);
   * }
   * </code></pre>
   *
   * @param name The name (project, location, cluster) of the cluster to delete. Specified in the
   *     format 'projects/&#42;/locations/&#42;/clusters/&#42;'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deleteCluster(String name) {
    CLUSTER_PATH_TEMPLATE.validate(name, "deleteCluster");
    DeleteClusterRequest request = DeleteClusterRequest.newBuilder().setName(name).build();
    return deleteCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the cluster, including the Kubernetes endpoint and all worker nodes.
   *
   * <p>Firewalls and routes that were configured during cluster creation are also deleted.
   *
   * <p>Other Google Compute Engine resources that might be in use by the cluster (e.g. load
   * balancer resources) will not be deleted if they weren't present at the initial create time.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   DeleteClusterRequest request = DeleteClusterRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.deleteCluster(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deleteCluster(DeleteClusterRequest request) {
    return deleteClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the cluster, including the Kubernetes endpoint and all worker nodes.
   *
   * <p>Firewalls and routes that were configured during cluster creation are also deleted.
   *
   * <p>Other Google Compute Engine resources that might be in use by the cluster (e.g. load
   * balancer resources) will not be deleted if they weren't present at the initial create time.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   DeleteClusterRequest request = DeleteClusterRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.deleteClusterCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return stub.deleteClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all operations in a project in a specific zone or all zones.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedParent = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListOperationsResponse response = clusterManagerClient.listOperations(formattedParent);
   * }
   * </code></pre>
   *
   * @param parent The parent (project and location) where the operations will be listed. Specified
   *     in the format 'projects/&#42;/locations/&#42;'. Location "-" matches all zones and all
   *     regions.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOperationsResponse listOperations(String parent) {
    LOCATION_PATH_TEMPLATE.validate(parent, "listOperations");
    ListOperationsRequest request = ListOperationsRequest.newBuilder().setParent(parent).build();
    return listOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all operations in a project in a specific zone or all zones.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedParent = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListOperationsRequest request = ListOperationsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ListOperationsResponse response = clusterManagerClient.listOperations(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOperationsResponse listOperations(ListOperationsRequest request) {
    return listOperationsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all operations in a project in a specific zone or all zones.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedParent = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListOperationsRequest request = ListOperationsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListOperationsResponse&gt; future = clusterManagerClient.listOperationsCallable().futureCall(request);
   *   // Do something
   *   ListOperationsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListOperationsRequest, ListOperationsResponse>
      listOperationsCallable() {
    return stub.listOperationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the specified operation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatOperationName("[PROJECT]", "[LOCATION]", "[OPERATION]");
   *   Operation response = clusterManagerClient.getOperation(formattedName);
   * }
   * </code></pre>
   *
   * @param name The name (project, location, operation id) of the operation to get. Specified in
   *     the format 'projects/&#42;/locations/&#42;/operations/&#42;'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation getOperation(String name) {
    OPERATION_PATH_TEMPLATE.validate(name, "getOperation");
    GetOperationRequest request = GetOperationRequest.newBuilder().setName(name).build();
    return getOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the specified operation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatOperationName("[PROJECT]", "[LOCATION]", "[OPERATION]");
   *   GetOperationRequest request = GetOperationRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.getOperation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation getOperation(GetOperationRequest request) {
    return getOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the specified operation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatOperationName("[PROJECT]", "[LOCATION]", "[OPERATION]");
   *   GetOperationRequest request = GetOperationRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.getOperationCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetOperationRequest, Operation> getOperationCallable() {
    return stub.getOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Cancels the specified operation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatOperationName("[PROJECT]", "[LOCATION]", "[OPERATION]");
   *   clusterManagerClient.cancelOperation(formattedName);
   * }
   * </code></pre>
   *
   * @param name The name (project, location, operation id) of the operation to cancel. Specified in
   *     the format 'projects/&#42;/locations/&#42;/operations/&#42;'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelOperation(String name) {
    OPERATION_PATH_TEMPLATE.validate(name, "cancelOperation");
    CancelOperationRequest request = CancelOperationRequest.newBuilder().setName(name).build();
    cancelOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Cancels the specified operation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatOperationName("[PROJECT]", "[LOCATION]", "[OPERATION]");
   *   CancelOperationRequest request = CancelOperationRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   clusterManagerClient.cancelOperation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelOperation(CancelOperationRequest request) {
    cancelOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Cancels the specified operation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatOperationName("[PROJECT]", "[LOCATION]", "[OPERATION]");
   *   CancelOperationRequest request = CancelOperationRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = clusterManagerClient.cancelOperationCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CancelOperationRequest, Empty> cancelOperationCallable() {
    return stub.cancelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns configuration info about the Kubernetes Engine service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ServerConfig response = clusterManagerClient.getServerConfig(formattedName);
   * }
   * </code></pre>
   *
   * @param name The name (project and location) of the server config to get Specified in the format
   *     'projects/&#42;/locations/&#42;'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServerConfig getServerConfig(String name) {
    LOCATION_PATH_TEMPLATE.validate(name, "getServerConfig");
    GetServerConfigRequest request = GetServerConfigRequest.newBuilder().setName(name).build();
    return getServerConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns configuration info about the Kubernetes Engine service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   GetServerConfigRequest request = GetServerConfigRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ServerConfig response = clusterManagerClient.getServerConfig(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServerConfig getServerConfig(GetServerConfigRequest request) {
    return getServerConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns configuration info about the Kubernetes Engine service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   GetServerConfigRequest request = GetServerConfigRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;ServerConfig&gt; future = clusterManagerClient.getServerConfigCallable().futureCall(request);
   *   // Do something
   *   ServerConfig response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetServerConfigRequest, ServerConfig> getServerConfigCallable() {
    return stub.getServerConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the node pools for a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedParent = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   ListNodePoolsResponse response = clusterManagerClient.listNodePools(formattedParent);
   * }
   * </code></pre>
   *
   * @param parent The parent (project, location, cluster id) where the node pools will be listed.
   *     Specified in the format 'projects/&#42;/locations/&#42;/clusters/&#42;'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodePoolsResponse listNodePools(String parent) {
    CLUSTER_PATH_TEMPLATE.validate(parent, "listNodePools");
    ListNodePoolsRequest request = ListNodePoolsRequest.newBuilder().setParent(parent).build();
    return listNodePools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the node pools for a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedParent = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   ListNodePoolsRequest request = ListNodePoolsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ListNodePoolsResponse response = clusterManagerClient.listNodePools(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodePoolsResponse listNodePools(ListNodePoolsRequest request) {
    return listNodePoolsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the node pools for a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedParent = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   ListNodePoolsRequest request = ListNodePoolsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListNodePoolsResponse&gt; future = clusterManagerClient.listNodePoolsCallable().futureCall(request);
   *   // Do something
   *   ListNodePoolsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsCallable() {
    return stub.listNodePoolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the node pool requested.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatNodePoolName("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");
   *   GetNodePoolRequest request = GetNodePoolRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   NodePool response = clusterManagerClient.getNodePool(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodePool getNodePool(GetNodePoolRequest request) {
    return getNodePoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the node pool requested.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatNodePoolName("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");
   *   GetNodePoolRequest request = GetNodePoolRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;NodePool&gt; future = clusterManagerClient.getNodePoolCallable().futureCall(request);
   *   // Do something
   *   NodePool response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetNodePoolRequest, NodePool> getNodePoolCallable() {
    return stub.getNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a node pool for a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   NodePool nodePool = NodePool.newBuilder().build();
   *   String formattedParent = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   CreateNodePoolRequest request = CreateNodePoolRequest.newBuilder()
   *     .setNodePool(nodePool)
   *     .setParent(formattedParent)
   *     .build();
   *   Operation response = clusterManagerClient.createNodePool(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createNodePool(CreateNodePoolRequest request) {
    return createNodePoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a node pool for a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   NodePool nodePool = NodePool.newBuilder().build();
   *   String formattedParent = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   CreateNodePoolRequest request = CreateNodePoolRequest.newBuilder()
   *     .setNodePool(nodePool)
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.createNodePoolCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateNodePoolRequest, Operation> createNodePoolCallable() {
    return stub.createNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a node pool from a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatNodePoolName("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");
   *   DeleteNodePoolRequest request = DeleteNodePoolRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.deleteNodePool(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deleteNodePool(DeleteNodePoolRequest request) {
    return deleteNodePoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a node pool from a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatNodePoolName("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");
   *   DeleteNodePoolRequest request = DeleteNodePoolRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.deleteNodePoolCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteNodePoolRequest, Operation> deleteNodePoolCallable() {
    return stub.deleteNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Roll back the previously Aborted or Failed NodePool upgrade. This will be an no-op if the last
   * upgrade successfully completed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatNodePoolName("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");
   *   RollbackNodePoolUpgradeRequest request = RollbackNodePoolUpgradeRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.rollbackNodePoolUpgrade(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation rollbackNodePoolUpgrade(RollbackNodePoolUpgradeRequest request) {
    return rollbackNodePoolUpgradeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Roll back the previously Aborted or Failed NodePool upgrade. This will be an no-op if the last
   * upgrade successfully completed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatNodePoolName("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");
   *   RollbackNodePoolUpgradeRequest request = RollbackNodePoolUpgradeRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.rollbackNodePoolUpgradeCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RollbackNodePoolUpgradeRequest, Operation>
      rollbackNodePoolUpgradeCallable() {
    return stub.rollbackNodePoolUpgradeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the NodeManagement options for a node pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   NodeManagement management = NodeManagement.newBuilder().build();
   *   String formattedName = ClusterManagerClient.formatNodePoolName("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");
   *   SetNodePoolManagementRequest request = SetNodePoolManagementRequest.newBuilder()
   *     .setManagement(management)
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.setNodePoolManagement(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setNodePoolManagement(SetNodePoolManagementRequest request) {
    return setNodePoolManagementCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the NodeManagement options for a node pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   NodeManagement management = NodeManagement.newBuilder().build();
   *   String formattedName = ClusterManagerClient.formatNodePoolName("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");
   *   SetNodePoolManagementRequest request = SetNodePoolManagementRequest.newBuilder()
   *     .setManagement(management)
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.setNodePoolManagementCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetNodePoolManagementRequest, Operation>
      setNodePoolManagementCallable() {
    return stub.setNodePoolManagementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets labels on a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   Map&lt;String, String&gt; resourceLabels = new HashMap&lt;&gt;();
   *   String labelFingerprint = "";
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetLabelsRequest request = SetLabelsRequest.newBuilder()
   *     .putAllResourceLabels(resourceLabels)
   *     .setLabelFingerprint(labelFingerprint)
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.setLabels(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLabels(SetLabelsRequest request) {
    return setLabelsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets labels on a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   Map&lt;String, String&gt; resourceLabels = new HashMap&lt;&gt;();
   *   String labelFingerprint = "";
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetLabelsRequest request = SetLabelsRequest.newBuilder()
   *     .putAllResourceLabels(resourceLabels)
   *     .setLabelFingerprint(labelFingerprint)
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.setLabelsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetLabelsRequest, Operation> setLabelsCallable() {
    return stub.setLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enables or disables the ABAC authorization mechanism on a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   boolean enabled = false;
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetLegacyAbacRequest request = SetLegacyAbacRequest.newBuilder()
   *     .setEnabled(enabled)
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.setLegacyAbac(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLegacyAbac(SetLegacyAbacRequest request) {
    return setLegacyAbacCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enables or disables the ABAC authorization mechanism on a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   boolean enabled = false;
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetLegacyAbacRequest request = SetLegacyAbacRequest.newBuilder()
   *     .setEnabled(enabled)
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.setLegacyAbacCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetLegacyAbacRequest, Operation> setLegacyAbacCallable() {
    return stub.setLegacyAbacCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Start master IP rotation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   boolean rotateCredentials = false;
   *   StartIPRotationRequest request = StartIPRotationRequest.newBuilder()
   *     .setName(formattedName)
   *     .setRotateCredentials(rotateCredentials)
   *     .build();
   *   Operation response = clusterManagerClient.startIPRotation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation startIPRotation(StartIPRotationRequest request) {
    return startIPRotationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Start master IP rotation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   boolean rotateCredentials = false;
   *   StartIPRotationRequest request = StartIPRotationRequest.newBuilder()
   *     .setName(formattedName)
   *     .setRotateCredentials(rotateCredentials)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.startIPRotationCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<StartIPRotationRequest, Operation> startIPRotationCallable() {
    return stub.startIPRotationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Completes master IP rotation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   Operation response = clusterManagerClient.completeIPRotation(formattedName);
   * }
   * </code></pre>
   *
   * @param name The name (project, location, cluster id) of the cluster to complete IP rotation.
   *     Specified in the format 'projects/&#42;/locations/&#42;/clusters/&#42;'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation completeIPRotation(String name) {
    CLUSTER_PATH_TEMPLATE.validate(name, "completeIPRotation");
    CompleteIPRotationRequest request =
        CompleteIPRotationRequest.newBuilder().setName(name).build();
    return completeIPRotation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Completes master IP rotation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   CompleteIPRotationRequest request = CompleteIPRotationRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.completeIPRotation(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation completeIPRotation(CompleteIPRotationRequest request) {
    return completeIPRotationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Completes master IP rotation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   CompleteIPRotationRequest request = CompleteIPRotationRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.completeIPRotationCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CompleteIPRotationRequest, Operation> completeIPRotationCallable() {
    return stub.completeIPRotationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the size for a specific node pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   int nodeCount = 0;
   *   String formattedName = ClusterManagerClient.formatNodePoolName("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");
   *   SetNodePoolSizeRequest request = SetNodePoolSizeRequest.newBuilder()
   *     .setNodeCount(nodeCount)
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.setNodePoolSize(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setNodePoolSize(SetNodePoolSizeRequest request) {
    return setNodePoolSizeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the size for a specific node pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   int nodeCount = 0;
   *   String formattedName = ClusterManagerClient.formatNodePoolName("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[NODE_POOL]");
   *   SetNodePoolSizeRequest request = SetNodePoolSizeRequest.newBuilder()
   *     .setNodeCount(nodeCount)
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.setNodePoolSizeCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetNodePoolSizeRequest, Operation> setNodePoolSizeCallable() {
    return stub.setNodePoolSizeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enables/Disables Network Policy for a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetNetworkPolicyRequest request = SetNetworkPolicyRequest.newBuilder()
   *     .setNetworkPolicy(networkPolicy)
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.setNetworkPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setNetworkPolicy(SetNetworkPolicyRequest request) {
    return setNetworkPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enables/Disables Network Policy for a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetNetworkPolicyRequest request = SetNetworkPolicyRequest.newBuilder()
   *     .setNetworkPolicy(networkPolicy)
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.setNetworkPolicyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetNetworkPolicyRequest, Operation> setNetworkPolicyCallable() {
    return stub.setNetworkPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the maintenance policy for a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   MaintenancePolicy maintenancePolicy = MaintenancePolicy.newBuilder().build();
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetMaintenancePolicyRequest request = SetMaintenancePolicyRequest.newBuilder()
   *     .setMaintenancePolicy(maintenancePolicy)
   *     .setName(formattedName)
   *     .build();
   *   Operation response = clusterManagerClient.setMaintenancePolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMaintenancePolicy(SetMaintenancePolicyRequest request) {
    return setMaintenancePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the maintenance policy for a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   MaintenancePolicy maintenancePolicy = MaintenancePolicy.newBuilder().build();
   *   String formattedName = ClusterManagerClient.formatClusterName("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   SetMaintenancePolicyRequest request = SetMaintenancePolicyRequest.newBuilder()
   *     .setMaintenancePolicy(maintenancePolicy)
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = clusterManagerClient.setMaintenancePolicyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetMaintenancePolicyRequest, Operation>
      setMaintenancePolicyCallable() {
    return stub.setMaintenancePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists subnetworks that are usable for creating clusters in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedParent = ClusterManagerClient.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   for (UsableSubnetwork element : clusterManagerClient.listUsableSubnetworks(formattedParent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent The parent project where subnetworks are usable. Specified in the format
   *     'projects/&#42;'.
   * @param filter Filtering currently only supports equality on the networkProjectId and must be in
   *     the form: "networkProjectId=[PROJECTID]", where `networkProjectId` is the project which
   *     owns the listed subnetworks. This defaults to the parent project ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUsableSubnetworksPagedResponse listUsableSubnetworks(
      String parent, String filter) {
    PROJECT_PATH_TEMPLATE.validate(parent, "listUsableSubnetworks");
    ListUsableSubnetworksRequest request =
        ListUsableSubnetworksRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listUsableSubnetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists subnetworks that are usable for creating clusters in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedParent = ClusterManagerClient.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   ListUsableSubnetworksRequest request = ListUsableSubnetworksRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setFilter(filter)
   *     .build();
   *   for (UsableSubnetwork element : clusterManagerClient.listUsableSubnetworks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUsableSubnetworksPagedResponse listUsableSubnetworks(
      ListUsableSubnetworksRequest request) {
    return listUsableSubnetworksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists subnetworks that are usable for creating clusters in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedParent = ClusterManagerClient.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   ListUsableSubnetworksRequest request = ListUsableSubnetworksRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setFilter(filter)
   *     .build();
   *   ApiFuture&lt;ListUsableSubnetworksPagedResponse&gt; future = clusterManagerClient.listUsableSubnetworksPagedCallable().futureCall(request);
   *   // Do something
   *   for (UsableSubnetwork element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListUsableSubnetworksRequest, ListUsableSubnetworksPagedResponse>
      listUsableSubnetworksPagedCallable() {
    return stub.listUsableSubnetworksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists subnetworks that are usable for creating clusters in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedParent = ClusterManagerClient.formatProjectName("[PROJECT]");
   *   String filter = "";
   *   ListUsableSubnetworksRequest request = ListUsableSubnetworksRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setFilter(filter)
   *     .build();
   *   while (true) {
   *     ListUsableSubnetworksResponse response = clusterManagerClient.listUsableSubnetworksCallable().call(request);
   *     for (UsableSubnetwork element : response.getSubnetworksList()) {
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
  public final UnaryCallable<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>
      listUsableSubnetworksCallable() {
    return stub.listUsableSubnetworksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Used to fetch locations that offer GKE.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedParent = ClusterManagerClient.formatProjectName("[PROJECT]");
   *   ListLocationsResponse response = clusterManagerClient.listLocations(formattedParent);
   * }
   * </code></pre>
   *
   * @param parent Contains the name of the resource requested. Specified in the format
   *     'projects/&#42;'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsResponse listLocations(String parent) {
    PROJECT_PATH_TEMPLATE.validate(parent, "listLocations");
    ListLocationsRequest request = ListLocationsRequest.newBuilder().setParent(parent).build();
    return listLocations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Used to fetch locations that offer GKE.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedParent = ClusterManagerClient.formatProjectName("[PROJECT]");
   *   ListLocationsRequest request = ListLocationsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ListLocationsResponse response = clusterManagerClient.listLocations(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsResponse listLocations(ListLocationsRequest request) {
    return listLocationsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Used to fetch locations that offer GKE.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String formattedParent = ClusterManagerClient.formatProjectName("[PROJECT]");
   *   ListLocationsRequest request = ListLocationsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListLocationsResponse&gt; future = clusterManagerClient.listLocationsCallable().futureCall(request);
   *   // Do something
   *   ListLocationsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
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

  public static class ListUsableSubnetworksPagedResponse
      extends AbstractPagedListResponse<
          ListUsableSubnetworksRequest, ListUsableSubnetworksResponse, UsableSubnetwork,
          ListUsableSubnetworksPage, ListUsableSubnetworksFixedSizeCollection> {

    public static ApiFuture<ListUsableSubnetworksPagedResponse> createAsync(
        PageContext<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse, UsableSubnetwork>
            context,
        ApiFuture<ListUsableSubnetworksResponse> futureResponse) {
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
          ListUsableSubnetworksRequest, ListUsableSubnetworksResponse, UsableSubnetwork,
          ListUsableSubnetworksPage> {

    private ListUsableSubnetworksPage(
        PageContext<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse, UsableSubnetwork>
            context,
        ListUsableSubnetworksResponse response) {
      super(context, response);
    }

    private static ListUsableSubnetworksPage createEmptyPage() {
      return new ListUsableSubnetworksPage(null, null);
    }

    @Override
    protected ListUsableSubnetworksPage createPage(
        PageContext<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse, UsableSubnetwork>
            context,
        ListUsableSubnetworksResponse response) {
      return new ListUsableSubnetworksPage(context, response);
    }

    @Override
    public ApiFuture<ListUsableSubnetworksPage> createPageAsync(
        PageContext<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse, UsableSubnetwork>
            context,
        ApiFuture<ListUsableSubnetworksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUsableSubnetworksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUsableSubnetworksRequest, ListUsableSubnetworksResponse, UsableSubnetwork,
          ListUsableSubnetworksPage, ListUsableSubnetworksFixedSizeCollection> {

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
