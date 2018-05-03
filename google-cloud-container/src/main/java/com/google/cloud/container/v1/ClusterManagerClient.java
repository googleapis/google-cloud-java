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

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.container.v1.stub.ClusterManagerStub;
import com.google.cloud.container.v1.stub.ClusterManagerStubSettings;
import com.google.container.v1.AddonsConfig;
import com.google.container.v1.CancelOperationRequest;
import com.google.container.v1.Cluster;
import com.google.container.v1.ClusterUpdate;
import com.google.container.v1.CompleteIPRotationRequest;
import com.google.container.v1.CreateClusterRequest;
import com.google.container.v1.CreateNodePoolRequest;
import com.google.container.v1.DeleteClusterRequest;
import com.google.container.v1.DeleteNodePoolRequest;
import com.google.container.v1.GetClusterRequest;
import com.google.container.v1.GetNodePoolRequest;
import com.google.container.v1.GetOperationRequest;
import com.google.container.v1.GetServerConfigRequest;
import com.google.container.v1.ListClustersRequest;
import com.google.container.v1.ListClustersResponse;
import com.google.container.v1.ListNodePoolsRequest;
import com.google.container.v1.ListNodePoolsResponse;
import com.google.container.v1.ListOperationsRequest;
import com.google.container.v1.ListOperationsResponse;
import com.google.container.v1.MaintenancePolicy;
import com.google.container.v1.NetworkPolicy;
import com.google.container.v1.NodePool;
import com.google.container.v1.Operation;
import com.google.container.v1.RollbackNodePoolUpgradeRequest;
import com.google.container.v1.ServerConfig;
import com.google.container.v1.SetAddonsConfigRequest;
import com.google.container.v1.SetLabelsRequest;
import com.google.container.v1.SetLegacyAbacRequest;
import com.google.container.v1.SetLocationsRequest;
import com.google.container.v1.SetLoggingServiceRequest;
import com.google.container.v1.SetMaintenancePolicyRequest;
import com.google.container.v1.SetMasterAuthRequest;
import com.google.container.v1.SetMonitoringServiceRequest;
import com.google.container.v1.SetNetworkPolicyRequest;
import com.google.container.v1.SetNodePoolAutoscalingRequest;
import com.google.container.v1.SetNodePoolManagementRequest;
import com.google.container.v1.SetNodePoolSizeRequest;
import com.google.container.v1.StartIPRotationRequest;
import com.google.container.v1.UpdateClusterRequest;
import com.google.container.v1.UpdateMasterRequest;
import com.google.container.v1.UpdateNodePoolRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Google Container Engine Cluster Manager v1
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
 *   String projectId = "";
 *   String zone = "";
 *   ListClustersResponse response = clusterManagerClient.listClusters(projectId, zone);
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
   *   String projectId = "";
   *   String zone = "";
   *   ListClustersResponse response = clusterManagerClient.listClusters(projectId, zone);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides, or "-" for all zones.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersResponse listClusters(String projectId, String zone) {

    ListClustersRequest request =
        ListClustersRequest.newBuilder().setProjectId(projectId).setZone(zone).build();
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
   *   String projectId = "";
   *   String zone = "";
   *   ListClustersRequest request = ListClustersRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
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
   *   String projectId = "";
   *   String zone = "";
   *   ListClustersRequest request = ListClustersRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
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
   * Gets the details of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   Cluster response = clusterManagerClient.getCluster(projectId, zone, clusterId);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(String projectId, String zone, String clusterId) {

    GetClusterRequest request =
        GetClusterRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .build();
    return getCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the details of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   GetClusterRequest request = GetClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
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
   * Gets the details of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   GetClusterRequest request = GetClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
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
   *   String projectId = "";
   *   String zone = "";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   Operation response = clusterManagerClient.createCluster(projectId, zone, cluster);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param cluster A [cluster
   *     resource](/container-engine/reference/rest/v1/projects.zones.clusters)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createCluster(String projectId, String zone, Cluster cluster) {

    CreateClusterRequest request =
        CreateClusterRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setCluster(cluster)
            .build();
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
   *   String projectId = "";
   *   String zone = "";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   CreateClusterRequest request = CreateClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setCluster(cluster)
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
   *   String projectId = "";
   *   String zone = "";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   CreateClusterRequest request = CreateClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setCluster(cluster)
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
   * Updates the settings of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   ClusterUpdate update = ClusterUpdate.newBuilder().build();
   *   Operation response = clusterManagerClient.updateCluster(projectId, zone, clusterId, update);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster to upgrade.
   * @param update A description of the update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateCluster(
      String projectId, String zone, String clusterId, ClusterUpdate update) {

    UpdateClusterRequest request =
        UpdateClusterRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .setUpdate(update)
            .build();
    return updateCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the settings of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   ClusterUpdate update = ClusterUpdate.newBuilder().build();
   *   UpdateClusterRequest request = UpdateClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setUpdate(update)
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
   * Updates the settings of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   ClusterUpdate update = ClusterUpdate.newBuilder().build();
   *   UpdateClusterRequest request = UpdateClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setUpdate(update)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String nodePoolId = "";
   *   String nodeVersion = "";
   *   String imageType = "";
   *   UpdateNodePoolRequest request = UpdateNodePoolRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNodePoolId(nodePoolId)
   *     .setNodeVersion(nodeVersion)
   *     .setImageType(imageType)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String nodePoolId = "";
   *   String nodeVersion = "";
   *   String imageType = "";
   *   UpdateNodePoolRequest request = UpdateNodePoolRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNodePoolId(nodePoolId)
   *     .setNodeVersion(nodeVersion)
   *     .setImageType(imageType)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String nodePoolId = "";
   *   NodePoolAutoscaling autoscaling = NodePoolAutoscaling.newBuilder().build();
   *   SetNodePoolAutoscalingRequest request = SetNodePoolAutoscalingRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNodePoolId(nodePoolId)
   *     .setAutoscaling(autoscaling)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String nodePoolId = "";
   *   NodePoolAutoscaling autoscaling = NodePoolAutoscaling.newBuilder().build();
   *   SetNodePoolAutoscalingRequest request = SetNodePoolAutoscalingRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNodePoolId(nodePoolId)
   *     .setAutoscaling(autoscaling)
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
   * Sets the logging service of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String loggingService = "";
   *   Operation response = clusterManagerClient.setLoggingService(projectId, zone, clusterId, loggingService);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster to upgrade.
   * @param loggingService The logging service the cluster should use to write metrics. Currently
   *     available options:
   *     <p>&#42; "logging.googleapis.com" - the Google Cloud Logging service &#42; "none" - no
   *     metrics will be exported from the cluster
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLoggingService(
      String projectId, String zone, String clusterId, String loggingService) {

    SetLoggingServiceRequest request =
        SetLoggingServiceRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .setLoggingService(loggingService)
            .build();
    return setLoggingService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the logging service of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String loggingService = "";
   *   SetLoggingServiceRequest request = SetLoggingServiceRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setLoggingService(loggingService)
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
   * Sets the logging service of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String loggingService = "";
   *   SetLoggingServiceRequest request = SetLoggingServiceRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setLoggingService(loggingService)
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
   * Sets the monitoring service of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String monitoringService = "";
   *   Operation response = clusterManagerClient.setMonitoringService(projectId, zone, clusterId, monitoringService);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster to upgrade.
   * @param monitoringService The monitoring service the cluster should use to write metrics.
   *     Currently available options:
   *     <p>&#42; "monitoring.googleapis.com" - the Google Cloud Monitoring service &#42; "none" -
   *     no metrics will be exported from the cluster
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMonitoringService(
      String projectId, String zone, String clusterId, String monitoringService) {

    SetMonitoringServiceRequest request =
        SetMonitoringServiceRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .setMonitoringService(monitoringService)
            .build();
    return setMonitoringService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the monitoring service of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String monitoringService = "";
   *   SetMonitoringServiceRequest request = SetMonitoringServiceRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setMonitoringService(monitoringService)
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
   * Sets the monitoring service of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String monitoringService = "";
   *   SetMonitoringServiceRequest request = SetMonitoringServiceRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setMonitoringService(monitoringService)
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
   * Sets the addons of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   AddonsConfig addonsConfig = AddonsConfig.newBuilder().build();
   *   Operation response = clusterManagerClient.setAddonsConfig(projectId, zone, clusterId, addonsConfig);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster to upgrade.
   * @param addonsConfig The desired configurations for the various addons available to run in the
   *     cluster.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setAddonsConfig(
      String projectId, String zone, String clusterId, AddonsConfig addonsConfig) {

    SetAddonsConfigRequest request =
        SetAddonsConfigRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .setAddonsConfig(addonsConfig)
            .build();
    return setAddonsConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the addons of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   AddonsConfig addonsConfig = AddonsConfig.newBuilder().build();
   *   SetAddonsConfigRequest request = SetAddonsConfigRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setAddonsConfig(addonsConfig)
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
   * Sets the addons of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   AddonsConfig addonsConfig = AddonsConfig.newBuilder().build();
   *   SetAddonsConfigRequest request = SetAddonsConfigRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setAddonsConfig(addonsConfig)
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
   * Sets the locations of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   List&lt;String&gt; locations = new ArrayList&lt;&gt;();
   *   Operation response = clusterManagerClient.setLocations(projectId, zone, clusterId, locations);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster to upgrade.
   * @param locations The desired list of Google Compute Engine
   *     [locations](/compute/docs/zones#available) in which the cluster's nodes should be located.
   *     Changing the locations a cluster is in will result in nodes being either created or removed
   *     from the cluster, depending on whether locations are being added or removed.
   *     <p>This list must always include the cluster's primary zone.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLocations(
      String projectId, String zone, String clusterId, List<String> locations) {

    SetLocationsRequest request =
        SetLocationsRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .addAllLocations(locations)
            .build();
    return setLocations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the locations of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   List&lt;String&gt; locations = new ArrayList&lt;&gt;();
   *   SetLocationsRequest request = SetLocationsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .addAllLocations(locations)
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
   * Sets the locations of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   List&lt;String&gt; locations = new ArrayList&lt;&gt;();
   *   SetLocationsRequest request = SetLocationsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .addAllLocations(locations)
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
   * Updates the master of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String masterVersion = "";
   *   Operation response = clusterManagerClient.updateMaster(projectId, zone, clusterId, masterVersion);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster to upgrade.
   * @param masterVersion The Kubernetes version to change the master to. The only valid value is
   *     the latest supported version. Use "-" to have the server automatically select the latest
   *     version.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateMaster(
      String projectId, String zone, String clusterId, String masterVersion) {

    UpdateMasterRequest request =
        UpdateMasterRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .setMasterVersion(masterVersion)
            .build();
    return updateMaster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the master of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String masterVersion = "";
   *   UpdateMasterRequest request = UpdateMasterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setMasterVersion(masterVersion)
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
   * Updates the master of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String masterVersion = "";
   *   UpdateMasterRequest request = UpdateMasterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setMasterVersion(masterVersion)
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
   * Used to set master auth materials. Currently supports :- Changing the admin password of a
   * specific cluster. This can be either via password generation or explicitly set the password.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   SetMasterAuthRequest.Action action = SetMasterAuthRequest.Action.UNKNOWN;
   *   MasterAuth update = MasterAuth.newBuilder().build();
   *   SetMasterAuthRequest request = SetMasterAuthRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setAction(action)
   *     .setUpdate(update)
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
   * Used to set master auth materials. Currently supports :- Changing the admin password of a
   * specific cluster. This can be either via password generation or explicitly set the password.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   SetMasterAuthRequest.Action action = SetMasterAuthRequest.Action.UNKNOWN;
   *   MasterAuth update = MasterAuth.newBuilder().build();
   *   SetMasterAuthRequest request = SetMasterAuthRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setAction(action)
   *     .setUpdate(update)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   Operation response = clusterManagerClient.deleteCluster(projectId, zone, clusterId);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deleteCluster(String projectId, String zone, String clusterId) {

    DeleteClusterRequest request =
        DeleteClusterRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .build();
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   DeleteClusterRequest request = DeleteClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   DeleteClusterRequest request = DeleteClusterRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
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
   *   String projectId = "";
   *   String zone = "";
   *   ListOperationsResponse response = clusterManagerClient.listOperations(projectId, zone);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) to
   *     return operations for, or `-` for all zones.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOperationsResponse listOperations(String projectId, String zone) {

    ListOperationsRequest request =
        ListOperationsRequest.newBuilder().setProjectId(projectId).setZone(zone).build();
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
   *   String projectId = "";
   *   String zone = "";
   *   ListOperationsRequest request = ListOperationsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
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
   *   String projectId = "";
   *   String zone = "";
   *   ListOperationsRequest request = ListOperationsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
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
   *   String projectId = "";
   *   String zone = "";
   *   String operationId = "";
   *   Operation response = clusterManagerClient.getOperation(projectId, zone, operationId);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param operationId The server-assigned `name` of the operation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation getOperation(String projectId, String zone, String operationId) {

    GetOperationRequest request =
        GetOperationRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setOperationId(operationId)
            .build();
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
   *   String projectId = "";
   *   String zone = "";
   *   String operationId = "";
   *   GetOperationRequest request = GetOperationRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setOperationId(operationId)
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
   *   String projectId = "";
   *   String zone = "";
   *   String operationId = "";
   *   GetOperationRequest request = GetOperationRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setOperationId(operationId)
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
   *   String projectId = "";
   *   String zone = "";
   *   String operationId = "";
   *   clusterManagerClient.cancelOperation(projectId, zone, operationId);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the operation resides.
   * @param operationId The server-assigned `name` of the operation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelOperation(String projectId, String zone, String operationId) {

    CancelOperationRequest request =
        CancelOperationRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setOperationId(operationId)
            .build();
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
   *   String projectId = "";
   *   String zone = "";
   *   String operationId = "";
   *   CancelOperationRequest request = CancelOperationRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setOperationId(operationId)
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
   *   String projectId = "";
   *   String zone = "";
   *   String operationId = "";
   *   CancelOperationRequest request = CancelOperationRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setOperationId(operationId)
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
   * Returns configuration info about the Container Engine service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   ServerConfig response = clusterManagerClient.getServerConfig(projectId, zone);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) to
   *     return operations for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServerConfig getServerConfig(String projectId, String zone) {

    GetServerConfigRequest request =
        GetServerConfigRequest.newBuilder().setProjectId(projectId).setZone(zone).build();
    return getServerConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns configuration info about the Container Engine service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   GetServerConfigRequest request = GetServerConfigRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
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
   * Returns configuration info about the Container Engine service.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   GetServerConfigRequest request = GetServerConfigRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   ListNodePoolsResponse response = clusterManagerClient.listNodePools(projectId, zone, clusterId);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://developers.google.com/console/help/new/#projectnumber).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodePoolsResponse listNodePools(
      String projectId, String zone, String clusterId) {

    ListNodePoolsRequest request =
        ListNodePoolsRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .build();
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   ListNodePoolsRequest request = ListNodePoolsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   ListNodePoolsRequest request = ListNodePoolsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String nodePoolId = "";
   *   NodePool response = clusterManagerClient.getNodePool(projectId, zone, clusterId, nodePoolId);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://developers.google.com/console/help/new/#projectnumber).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster.
   * @param nodePoolId The name of the node pool.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodePool getNodePool(
      String projectId, String zone, String clusterId, String nodePoolId) {

    GetNodePoolRequest request =
        GetNodePoolRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .setNodePoolId(nodePoolId)
            .build();
    return getNodePool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the node pool requested.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String nodePoolId = "";
   *   GetNodePoolRequest request = GetNodePoolRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNodePoolId(nodePoolId)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String nodePoolId = "";
   *   GetNodePoolRequest request = GetNodePoolRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNodePoolId(nodePoolId)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   NodePool nodePool = NodePool.newBuilder().build();
   *   Operation response = clusterManagerClient.createNodePool(projectId, zone, clusterId, nodePool);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://developers.google.com/console/help/new/#projectnumber).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster.
   * @param nodePool The node pool to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createNodePool(
      String projectId, String zone, String clusterId, NodePool nodePool) {

    CreateNodePoolRequest request =
        CreateNodePoolRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .setNodePool(nodePool)
            .build();
    return createNodePool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a node pool for a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   NodePool nodePool = NodePool.newBuilder().build();
   *   CreateNodePoolRequest request = CreateNodePoolRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNodePool(nodePool)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   NodePool nodePool = NodePool.newBuilder().build();
   *   CreateNodePoolRequest request = CreateNodePoolRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNodePool(nodePool)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String nodePoolId = "";
   *   Operation response = clusterManagerClient.deleteNodePool(projectId, zone, clusterId, nodePoolId);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://developers.google.com/console/help/new/#projectnumber).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster.
   * @param nodePoolId The name of the node pool to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deleteNodePool(
      String projectId, String zone, String clusterId, String nodePoolId) {

    DeleteNodePoolRequest request =
        DeleteNodePoolRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .setNodePoolId(nodePoolId)
            .build();
    return deleteNodePool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a node pool from a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String nodePoolId = "";
   *   DeleteNodePoolRequest request = DeleteNodePoolRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNodePoolId(nodePoolId)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String nodePoolId = "";
   *   DeleteNodePoolRequest request = DeleteNodePoolRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNodePoolId(nodePoolId)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String nodePoolId = "";
   *   Operation response = clusterManagerClient.rollbackNodePoolUpgrade(projectId, zone, clusterId, nodePoolId);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster to rollback.
   * @param nodePoolId The name of the node pool to rollback.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation rollbackNodePoolUpgrade(
      String projectId, String zone, String clusterId, String nodePoolId) {

    RollbackNodePoolUpgradeRequest request =
        RollbackNodePoolUpgradeRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .setNodePoolId(nodePoolId)
            .build();
    return rollbackNodePoolUpgrade(request);
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String nodePoolId = "";
   *   RollbackNodePoolUpgradeRequest request = RollbackNodePoolUpgradeRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNodePoolId(nodePoolId)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String nodePoolId = "";
   *   RollbackNodePoolUpgradeRequest request = RollbackNodePoolUpgradeRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNodePoolId(nodePoolId)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String nodePoolId = "";
   *   NodeManagement management = NodeManagement.newBuilder().build();
   *   SetNodePoolManagementRequest request = SetNodePoolManagementRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNodePoolId(nodePoolId)
   *     .setManagement(management)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String nodePoolId = "";
   *   NodeManagement management = NodeManagement.newBuilder().build();
   *   SetNodePoolManagementRequest request = SetNodePoolManagementRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNodePoolId(nodePoolId)
   *     .setManagement(management)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   Map&lt;String, String&gt; resourceLabels = new HashMap&lt;&gt;();
   *   String labelFingerprint = "";
   *   SetLabelsRequest request = SetLabelsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .putAllResourceLabels(resourceLabels)
   *     .setLabelFingerprint(labelFingerprint)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   Map&lt;String, String&gt; resourceLabels = new HashMap&lt;&gt;();
   *   String labelFingerprint = "";
   *   SetLabelsRequest request = SetLabelsRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .putAllResourceLabels(resourceLabels)
   *     .setLabelFingerprint(labelFingerprint)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   boolean enabled = false;
   *   Operation response = clusterManagerClient.setLegacyAbac(projectId, zone, clusterId, enabled);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster to update.
   * @param enabled Whether ABAC authorization will be enabled in the cluster.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLegacyAbac(
      String projectId, String zone, String clusterId, boolean enabled) {

    SetLegacyAbacRequest request =
        SetLegacyAbacRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .setEnabled(enabled)
            .build();
    return setLegacyAbac(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enables or disables the ABAC authorization mechanism on a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   boolean enabled = false;
   *   SetLegacyAbacRequest request = SetLegacyAbacRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setEnabled(enabled)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   boolean enabled = false;
   *   SetLegacyAbacRequest request = SetLegacyAbacRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setEnabled(enabled)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   Operation response = clusterManagerClient.startIPRotation(projectId, zone, clusterId);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://developers.google.com/console/help/new/#projectnumber).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation startIPRotation(String projectId, String zone, String clusterId) {

    StartIPRotationRequest request =
        StartIPRotationRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .build();
    return startIPRotation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Start master IP rotation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   StartIPRotationRequest request = StartIPRotationRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   StartIPRotationRequest request = StartIPRotationRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   Operation response = clusterManagerClient.completeIPRotation(projectId, zone, clusterId);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://developers.google.com/console/help/new/#projectnumber).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation completeIPRotation(String projectId, String zone, String clusterId) {

    CompleteIPRotationRequest request =
        CompleteIPRotationRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .build();
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   CompleteIPRotationRequest request = CompleteIPRotationRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   CompleteIPRotationRequest request = CompleteIPRotationRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
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
   * Sets the size of a specific node pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String nodePoolId = "";
   *   int nodeCount = 0;
   *   SetNodePoolSizeRequest request = SetNodePoolSizeRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNodePoolId(nodePoolId)
   *     .setNodeCount(nodeCount)
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
   * Sets the size of a specific node pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   String nodePoolId = "";
   *   int nodeCount = 0;
   *   SetNodePoolSizeRequest request = SetNodePoolSizeRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNodePoolId(nodePoolId)
   *     .setNodeCount(nodeCount)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
   *   Operation response = clusterManagerClient.setNetworkPolicy(projectId, zone, clusterId, networkPolicy);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://developers.google.com/console/help/new/#projectnumber).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster.
   * @param networkPolicy Configuration options for the NetworkPolicy feature.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setNetworkPolicy(
      String projectId, String zone, String clusterId, NetworkPolicy networkPolicy) {

    SetNetworkPolicyRequest request =
        SetNetworkPolicyRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .setNetworkPolicy(networkPolicy)
            .build();
    return setNetworkPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Enables/Disables Network Policy for a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
   *   SetNetworkPolicyRequest request = SetNetworkPolicyRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNetworkPolicy(networkPolicy)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
   *   SetNetworkPolicyRequest request = SetNetworkPolicyRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setNetworkPolicy(networkPolicy)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   MaintenancePolicy maintenancePolicy = MaintenancePolicy.newBuilder().build();
   *   Operation response = clusterManagerClient.setMaintenancePolicy(projectId, zone, clusterId, maintenancePolicy);
   * }
   * </code></pre>
   *
   * @param projectId The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone The name of the Google Compute Engine [zone](/compute/docs/zones#available) in
   *     which the cluster resides.
   * @param clusterId The name of the cluster to update.
   * @param maintenancePolicy The maintenance policy to be set for the cluster. An empty field
   *     clears the existing maintenance policy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMaintenancePolicy(
      String projectId, String zone, String clusterId, MaintenancePolicy maintenancePolicy) {

    SetMaintenancePolicyRequest request =
        SetMaintenancePolicyRequest.newBuilder()
            .setProjectId(projectId)
            .setZone(zone)
            .setClusterId(clusterId)
            .setMaintenancePolicy(maintenancePolicy)
            .build();
    return setMaintenancePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the maintenance policy for a cluster.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   MaintenancePolicy maintenancePolicy = MaintenancePolicy.newBuilder().build();
   *   SetMaintenancePolicyRequest request = SetMaintenancePolicyRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setMaintenancePolicy(maintenancePolicy)
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
   *   String projectId = "";
   *   String zone = "";
   *   String clusterId = "";
   *   MaintenancePolicy maintenancePolicy = MaintenancePolicy.newBuilder().build();
   *   SetMaintenancePolicyRequest request = SetMaintenancePolicyRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setZone(zone)
   *     .setClusterId(clusterId)
   *     .setMaintenancePolicy(maintenancePolicy)
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
