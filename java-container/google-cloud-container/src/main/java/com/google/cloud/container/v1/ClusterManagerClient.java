/*
 * Copyright 2020 Google LLC
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
import com.google.cloud.container.v1.stub.ClusterManagerStub;
import com.google.cloud.container.v1.stub.ClusterManagerStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
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
import com.google.container.v1.GetJSONWebKeysRequest;
import com.google.container.v1.GetJSONWebKeysResponse;
import com.google.container.v1.GetNodePoolRequest;
import com.google.container.v1.GetOperationRequest;
import com.google.container.v1.GetServerConfigRequest;
import com.google.container.v1.ListClustersRequest;
import com.google.container.v1.ListClustersResponse;
import com.google.container.v1.ListNodePoolsRequest;
import com.google.container.v1.ListNodePoolsResponse;
import com.google.container.v1.ListOperationsRequest;
import com.google.container.v1.ListOperationsResponse;
import com.google.container.v1.ListUsableSubnetworksRequest;
import com.google.container.v1.ListUsableSubnetworksResponse;
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
import com.google.container.v1.UsableSubnetwork;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Google Kubernetes Engine Cluster Manager v1
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the ClusterManagerClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of ClusterManagerSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * ClusterManagerSettings clusterManagerSettings =
 *     ClusterManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ClusterManagerClient clusterManagerClient = ClusterManagerClient.create(clusterManagerSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * ClusterManagerSettings clusterManagerSettings =
 *     ClusterManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ClusterManagerClient clusterManagerClient = ClusterManagerClient.create(clusterManagerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
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
   * for advanced usage - prefer using create(ClusterManagerSettings).
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all clusters owned by a project in either the specified zone or all zones.
   *
   * @param parent The parent (project and location) where the clusters will be listed. Specified in
   *     the format `projects/&#42;/locations/&#42;`. Location "-" matches all zones and all
   *     regions.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersResponse listClusters(String parent) {
    ListClustersRequest request = ListClustersRequest.newBuilder().setParent(parent).build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all clusters owned by a project in either the specified zone or all zones.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840). This field has been deprecated
   *     and replaced by the parent field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides,
   *     or "-" for all zones. This field has been deprecated and replaced by the parent field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersResponse listClusters(String projectId, String zone) {
    ListClustersRequest request =
        ListClustersRequest.newBuilder().setProjectId(projectId).setZone(zone).build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all clusters owned by a project in either the specified zone or all zones.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersResponse listClusters(ListClustersRequest request) {
    return listClustersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all clusters owned by a project in either the specified zone or all zones.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return stub.listClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific cluster.
   *
   * @param name The name (project, location, cluster) of the cluster to retrieve. Specified in the
   *     format `projects/&#42;/locations/&#42;/clusters/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(String name) {
    GetClusterRequest request = GetClusterRequest.newBuilder().setName(name).build();
    return getCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific cluster.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840). This field has been deprecated
   *     and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the name field.
   * @param clusterId Deprecated. The name of the cluster to retrieve. This field has been
   *     deprecated and replaced by the name field.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific cluster.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(GetClusterRequest request) {
    return getClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific cluster.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return stub.getClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a cluster, consisting of the specified number and type of Google Compute Engine
   * instances.
   *
   * <p>By default, the cluster is created in the project's [default
   * network](https://cloud.google.com/compute/docs/networks-and-firewalls#networks).
   *
   * <p>One firewall is added for the cluster. After cluster creation, the Kubelet creates routes
   * for each node to allow the containers on that node to communicate with all other instances in
   * the cluster.
   *
   * <p>Finally, an entry is added to the project's global metadata indicating which CIDR range the
   * cluster is using.
   *
   * @param parent The parent (project and location) where the cluster will be created. Specified in
   *     the format `projects/&#42;/locations/&#42;`.
   * @param cluster Required. A [cluster
   *     resource](https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createCluster(String parent, Cluster cluster) {
    CreateClusterRequest request =
        CreateClusterRequest.newBuilder().setParent(parent).setCluster(cluster).build();
    return createCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a cluster, consisting of the specified number and type of Google Compute Engine
   * instances.
   *
   * <p>By default, the cluster is created in the project's [default
   * network](https://cloud.google.com/compute/docs/networks-and-firewalls#networks).
   *
   * <p>One firewall is added for the cluster. After cluster creation, the Kubelet creates routes
   * for each node to allow the containers on that node to communicate with all other instances in
   * the cluster.
   *
   * <p>Finally, an entry is added to the project's global metadata indicating which CIDR range the
   * cluster is using.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840). This field has been deprecated
   *     and replaced by the parent field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the parent field.
   * @param cluster Required. A [cluster
   *     resource](https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters)
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a cluster, consisting of the specified number and type of Google Compute Engine
   * instances.
   *
   * <p>By default, the cluster is created in the project's [default
   * network](https://cloud.google.com/compute/docs/networks-and-firewalls#networks).
   *
   * <p>One firewall is added for the cluster. After cluster creation, the Kubelet creates routes
   * for each node to allow the containers on that node to communicate with all other instances in
   * the cluster.
   *
   * <p>Finally, an entry is added to the project's global metadata indicating which CIDR range the
   * cluster is using.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createCluster(CreateClusterRequest request) {
    return createClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a cluster, consisting of the specified number and type of Google Compute Engine
   * instances.
   *
   * <p>By default, the cluster is created in the project's [default
   * network](https://cloud.google.com/compute/docs/networks-and-firewalls#networks).
   *
   * <p>One firewall is added for the cluster. After cluster creation, the Kubelet creates routes
   * for each node to allow the containers on that node to communicate with all other instances in
   * the cluster.
   *
   * <p>Finally, an entry is added to the project's global metadata indicating which CIDR range the
   * cluster is using.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return stub.createClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a specific cluster.
   *
   * @param name The name (project, location, cluster) of the cluster to update. Specified in the
   *     format `projects/&#42;/locations/&#42;/clusters/&#42;`.
   * @param update Required. A description of the update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateCluster(String name, ClusterUpdate update) {
    UpdateClusterRequest request =
        UpdateClusterRequest.newBuilder().setName(name).setUpdate(update).build();
    return updateCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a specific cluster.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840). This field has been deprecated
   *     and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the name field.
   * @param clusterId Deprecated. The name of the cluster to upgrade. This field has been deprecated
   *     and replaced by the name field.
   * @param update Required. A description of the update.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a specific cluster.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateCluster(UpdateClusterRequest request) {
    return updateClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a specific cluster.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return stub.updateClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the version and/or image type for the specified node pool.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateNodePool(UpdateNodePoolRequest request) {
    return updateNodePoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the version and/or image type for the specified node pool.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateNodePoolRequest, Operation> updateNodePoolCallable() {
    return stub.updateNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the autoscaling settings for the specified node pool.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setNodePoolAutoscaling(SetNodePoolAutoscalingRequest request) {
    return setNodePoolAutoscalingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the autoscaling settings for the specified node pool.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetNodePoolAutoscalingRequest, Operation>
      setNodePoolAutoscalingCallable() {
    return stub.setNodePoolAutoscalingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the logging service for a specific cluster.
   *
   * @param name The name (project, location, cluster) of the cluster to set logging. Specified in
   *     the format `projects/&#42;/locations/&#42;/clusters/&#42;`.
   * @param loggingService Required. The logging service the cluster should use to write logs.
   *     Currently available options:
   *     <ul>
   *       <li>`logging.googleapis.com/kubernetes` - The Cloud Logging service with a
   *           Kubernetes-native resource model
   *       <li>`logging.googleapis.com` - The legacy Cloud Logging service (no longer available as
   *           of GKE 1.15).
   *       <li>`none` - no logs will be exported from the cluster.
   *     </ul>
   *     <p>If left as an empty string,`logging.googleapis.com/kubernetes` will be used for GKE
   *     1.14+ or `logging.googleapis.com` for earlier versions.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLoggingService(String name, String loggingService) {
    SetLoggingServiceRequest request =
        SetLoggingServiceRequest.newBuilder()
            .setName(name)
            .setLoggingService(loggingService)
            .build();
    return setLoggingService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the logging service for a specific cluster.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840). This field has been deprecated
   *     and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the name field.
   * @param clusterId Deprecated. The name of the cluster to upgrade. This field has been deprecated
   *     and replaced by the name field.
   * @param loggingService Required. The logging service the cluster should use to write logs.
   *     Currently available options:
   *     <ul>
   *       <li>`logging.googleapis.com/kubernetes` - The Cloud Logging service with a
   *           Kubernetes-native resource model
   *       <li>`logging.googleapis.com` - The legacy Cloud Logging service (no longer available as
   *           of GKE 1.15).
   *       <li>`none` - no logs will be exported from the cluster.
   *     </ul>
   *     <p>If left as an empty string,`logging.googleapis.com/kubernetes` will be used for GKE
   *     1.14+ or `logging.googleapis.com` for earlier versions.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the logging service for a specific cluster.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLoggingService(SetLoggingServiceRequest request) {
    return setLoggingServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the logging service for a specific cluster.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetLoggingServiceRequest, Operation> setLoggingServiceCallable() {
    return stub.setLoggingServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the monitoring service for a specific cluster.
   *
   * @param name The name (project, location, cluster) of the cluster to set monitoring. Specified
   *     in the format `projects/&#42;/locations/&#42;/clusters/&#42;`.
   * @param monitoringService Required. The monitoring service the cluster should use to write
   *     metrics. Currently available options:
   *     <ul>
   *       <li>"monitoring.googleapis.com/kubernetes" - The Cloud Monitoring service with a
   *           Kubernetes-native resource model
   *       <li>`monitoring.googleapis.com` - The legacy Cloud Monitoring service (no longer
   *           available as of GKE 1.15).
   *       <li>`none` - No metrics will be exported from the cluster.
   *     </ul>
   *     <p>If left as an empty string,`monitoring.googleapis.com/kubernetes` will be used for GKE
   *     1.14+ or `monitoring.googleapis.com` for earlier versions.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMonitoringService(String name, String monitoringService) {
    SetMonitoringServiceRequest request =
        SetMonitoringServiceRequest.newBuilder()
            .setName(name)
            .setMonitoringService(monitoringService)
            .build();
    return setMonitoringService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the monitoring service for a specific cluster.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840). This field has been deprecated
   *     and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the name field.
   * @param clusterId Deprecated. The name of the cluster to upgrade. This field has been deprecated
   *     and replaced by the name field.
   * @param monitoringService Required. The monitoring service the cluster should use to write
   *     metrics. Currently available options:
   *     <ul>
   *       <li>"monitoring.googleapis.com/kubernetes" - The Cloud Monitoring service with a
   *           Kubernetes-native resource model
   *       <li>`monitoring.googleapis.com` - The legacy Cloud Monitoring service (no longer
   *           available as of GKE 1.15).
   *       <li>`none` - No metrics will be exported from the cluster.
   *     </ul>
   *     <p>If left as an empty string,`monitoring.googleapis.com/kubernetes` will be used for GKE
   *     1.14+ or `monitoring.googleapis.com` for earlier versions.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the monitoring service for a specific cluster.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMonitoringService(SetMonitoringServiceRequest request) {
    return setMonitoringServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the monitoring service for a specific cluster.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetMonitoringServiceRequest, Operation>
      setMonitoringServiceCallable() {
    return stub.setMonitoringServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the addons for a specific cluster.
   *
   * @param name The name (project, location, cluster) of the cluster to set addons. Specified in
   *     the format `projects/&#42;/locations/&#42;/clusters/&#42;`.
   * @param addonsConfig Required. The desired configurations for the various addons available to
   *     run in the cluster.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setAddonsConfig(String name, AddonsConfig addonsConfig) {
    SetAddonsConfigRequest request =
        SetAddonsConfigRequest.newBuilder().setName(name).setAddonsConfig(addonsConfig).build();
    return setAddonsConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the addons for a specific cluster.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840). This field has been deprecated
   *     and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the name field.
   * @param clusterId Deprecated. The name of the cluster to upgrade. This field has been deprecated
   *     and replaced by the name field.
   * @param addonsConfig Required. The desired configurations for the various addons available to
   *     run in the cluster.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the addons for a specific cluster.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setAddonsConfig(SetAddonsConfigRequest request) {
    return setAddonsConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the addons for a specific cluster.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetAddonsConfigRequest, Operation> setAddonsConfigCallable() {
    return stub.setAddonsConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the locations for a specific cluster. Deprecated. Use
   * [projects.locations.clusters.update](https://cloud.google.com/kubernetes-engine/docs/reference/rest/v1/projects.locations.clusters/update)
   * instead.
   *
   * @param name The name (project, location, cluster) of the cluster to set locations. Specified in
   *     the format `projects/&#42;/locations/&#42;/clusters/&#42;`.
   * @param locations Required. The desired list of Google Compute Engine
   *     [zones](https://cloud.google.com/compute/docs/zones#available) in which the cluster's nodes
   *     should be located. Changing the locations a cluster is in will result in nodes being either
   *     created or removed from the cluster, depending on whether locations are being added or
   *     removed.
   *     <p>This list must always include the cluster's primary zone.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLocations(String name, List<String> locations) {
    SetLocationsRequest request =
        SetLocationsRequest.newBuilder().setName(name).addAllLocations(locations).build();
    return setLocations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the locations for a specific cluster. Deprecated. Use
   * [projects.locations.clusters.update](https://cloud.google.com/kubernetes-engine/docs/reference/rest/v1/projects.locations.clusters/update)
   * instead.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840). This field has been deprecated
   *     and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the name field.
   * @param clusterId Deprecated. The name of the cluster to upgrade. This field has been deprecated
   *     and replaced by the name field.
   * @param locations Required. The desired list of Google Compute Engine
   *     [zones](https://cloud.google.com/compute/docs/zones#available) in which the cluster's nodes
   *     should be located. Changing the locations a cluster is in will result in nodes being either
   *     created or removed from the cluster, depending on whether locations are being added or
   *     removed.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the locations for a specific cluster. Deprecated. Use
   * [projects.locations.clusters.update](https://cloud.google.com/kubernetes-engine/docs/reference/rest/v1/projects.locations.clusters/update)
   * instead.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLocations(SetLocationsRequest request) {
    return setLocationsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the locations for a specific cluster. Deprecated. Use
   * [projects.locations.clusters.update](https://cloud.google.com/kubernetes-engine/docs/reference/rest/v1/projects.locations.clusters/update)
   * instead.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetLocationsRequest, Operation> setLocationsCallable() {
    return stub.setLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the master for a specific cluster.
   *
   * @param name The name (project, location, cluster) of the cluster to update. Specified in the
   *     format `projects/&#42;/locations/&#42;/clusters/&#42;`.
   * @param masterVersion Required. The Kubernetes version to change the master to.
   *     <p>Users may specify either explicit versions offered by Kubernetes Engine or version
   *     aliases, which have the following behavior:
   *     <p>- "latest": picks the highest valid Kubernetes version - "1.X": picks the highest valid
   *     patch+gke.N patch in the 1.X version - "1.X.Y": picks the highest valid gke.N patch in the
   *     1.X.Y version - "1.X.Y-gke.N": picks an explicit Kubernetes version - "-": picks the
   *     default Kubernetes version
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateMaster(String name, String masterVersion) {
    UpdateMasterRequest request =
        UpdateMasterRequest.newBuilder().setName(name).setMasterVersion(masterVersion).build();
    return updateMaster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the master for a specific cluster.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840). This field has been deprecated
   *     and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the name field.
   * @param clusterId Deprecated. The name of the cluster to upgrade. This field has been deprecated
   *     and replaced by the name field.
   * @param masterVersion Required. The Kubernetes version to change the master to.
   *     <p>Users may specify either explicit versions offered by Kubernetes Engine or version
   *     aliases, which have the following behavior:
   *     <p>- "latest": picks the highest valid Kubernetes version - "1.X": picks the highest valid
   *     patch+gke.N patch in the 1.X version - "1.X.Y": picks the highest valid gke.N patch in the
   *     1.X.Y version - "1.X.Y-gke.N": picks an explicit Kubernetes version - "-": picks the
   *     default Kubernetes version
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the master for a specific cluster.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateMaster(UpdateMasterRequest request) {
    return updateMasterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the master for a specific cluster.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateMasterRequest, Operation> updateMasterCallable() {
    return stub.updateMasterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets master auth materials. Currently supports changing the admin password or a specific
   * cluster, either via password generation or explicitly setting the password.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMasterAuth(SetMasterAuthRequest request) {
    return setMasterAuthCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets master auth materials. Currently supports changing the admin password or a specific
   * cluster, either via password generation or explicitly setting the password.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetMasterAuthRequest, Operation> setMasterAuthCallable() {
    return stub.setMasterAuthCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the cluster, including the Kubernetes endpoint and all worker nodes.
   *
   * <p>Firewalls and routes that were configured during cluster creation are also deleted.
   *
   * <p>Other Google Compute Engine resources that might be in use by the cluster, such as load
   * balancer resources, are not deleted if they weren't present when the cluster was initially
   * created.
   *
   * @param name The name (project, location, cluster) of the cluster to delete. Specified in the
   *     format `projects/&#42;/locations/&#42;/clusters/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deleteCluster(String name) {
    DeleteClusterRequest request = DeleteClusterRequest.newBuilder().setName(name).build();
    return deleteCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the cluster, including the Kubernetes endpoint and all worker nodes.
   *
   * <p>Firewalls and routes that were configured during cluster creation are also deleted.
   *
   * <p>Other Google Compute Engine resources that might be in use by the cluster, such as load
   * balancer resources, are not deleted if they weren't present when the cluster was initially
   * created.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840). This field has been deprecated
   *     and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the name field.
   * @param clusterId Deprecated. The name of the cluster to delete. This field has been deprecated
   *     and replaced by the name field.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the cluster, including the Kubernetes endpoint and all worker nodes.
   *
   * <p>Firewalls and routes that were configured during cluster creation are also deleted.
   *
   * <p>Other Google Compute Engine resources that might be in use by the cluster, such as load
   * balancer resources, are not deleted if they weren't present when the cluster was initially
   * created.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deleteCluster(DeleteClusterRequest request) {
    return deleteClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the cluster, including the Kubernetes endpoint and all worker nodes.
   *
   * <p>Firewalls and routes that were configured during cluster creation are also deleted.
   *
   * <p>Other Google Compute Engine resources that might be in use by the cluster, such as load
   * balancer resources, are not deleted if they weren't present when the cluster was initially
   * created.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return stub.deleteClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all operations in a project in a specific zone or all zones.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840). This field has been deprecated
   *     and replaced by the parent field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) to return operations for, or
   *     `-` for all zones. This field has been deprecated and replaced by the parent field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOperationsResponse listOperations(String projectId, String zone) {
    ListOperationsRequest request =
        ListOperationsRequest.newBuilder().setProjectId(projectId).setZone(zone).build();
    return listOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all operations in a project in a specific zone or all zones.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOperationsResponse listOperations(ListOperationsRequest request) {
    return listOperationsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all operations in a project in a specific zone or all zones.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListOperationsRequest, ListOperationsResponse>
      listOperationsCallable() {
    return stub.listOperationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified operation.
   *
   * @param name The name (project, location, operation id) of the operation to get. Specified in
   *     the format `projects/&#42;/locations/&#42;/operations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation getOperation(String name) {
    GetOperationRequest request = GetOperationRequest.newBuilder().setName(name).build();
    return getOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified operation.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840). This field has been deprecated
   *     and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the name field.
   * @param operationId Deprecated. The server-assigned `name` of the operation. This field has been
   *     deprecated and replaced by the name field.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified operation.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation getOperation(GetOperationRequest request) {
    return getOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified operation.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetOperationRequest, Operation> getOperationCallable() {
    return stub.getOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the specified operation.
   *
   * @param name The name (project, location, operation id) of the operation to cancel. Specified in
   *     the format `projects/&#42;/locations/&#42;/operations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelOperation(String name) {
    CancelOperationRequest request = CancelOperationRequest.newBuilder().setName(name).build();
    cancelOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the specified operation.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840). This field has been deprecated
   *     and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the operation
   *     resides. This field has been deprecated and replaced by the name field.
   * @param operationId Deprecated. The server-assigned `name` of the operation. This field has been
   *     deprecated and replaced by the name field.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the specified operation.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelOperation(CancelOperationRequest request) {
    cancelOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the specified operation.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CancelOperationRequest, Empty> cancelOperationCallable() {
    return stub.cancelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns configuration info about the Google Kubernetes Engine service.
   *
   * @param name The name (project and location) of the server config to get, specified in the
   *     format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServerConfig getServerConfig(String name) {
    GetServerConfigRequest request = GetServerConfigRequest.newBuilder().setName(name).build();
    return getServerConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns configuration info about the Google Kubernetes Engine service.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840). This field has been deprecated
   *     and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) to return operations for.
   *     This field has been deprecated and replaced by the name field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServerConfig getServerConfig(String projectId, String zone) {
    GetServerConfigRequest request =
        GetServerConfigRequest.newBuilder().setProjectId(projectId).setZone(zone).build();
    return getServerConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns configuration info about the Google Kubernetes Engine service.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServerConfig getServerConfig(GetServerConfigRequest request) {
    return getServerConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns configuration info about the Google Kubernetes Engine service.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetServerConfigRequest, ServerConfig> getServerConfigCallable() {
    return stub.getServerConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the public component of the cluster signing keys in JSON Web Key format. This API is not
   * yet intended for general use, and is not available for all clusters.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetJSONWebKeysResponse getJSONWebKeys(GetJSONWebKeysRequest request) {
    return getJSONWebKeysCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the public component of the cluster signing keys in JSON Web Key format. This API is not
   * yet intended for general use, and is not available for all clusters.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetJSONWebKeysRequest, GetJSONWebKeysResponse>
      getJSONWebKeysCallable() {
    return stub.getJSONWebKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the node pools for a cluster.
   *
   * @param parent The parent (project, location, cluster id) where the node pools will be listed.
   *     Specified in the format `projects/&#42;/locations/&#42;/clusters/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodePoolsResponse listNodePools(String parent) {
    ListNodePoolsRequest request = ListNodePoolsRequest.newBuilder().setParent(parent).build();
    return listNodePools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the node pools for a cluster.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://developers.google.com/console/help/new/#projectnumber). This field has been
   *     deprecated and replaced by the parent field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the parent field.
   * @param clusterId Deprecated. The name of the cluster. This field has been deprecated and
   *     replaced by the parent field.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the node pools for a cluster.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodePoolsResponse listNodePools(ListNodePoolsRequest request) {
    return listNodePoolsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the node pools for a cluster.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsCallable() {
    return stub.listNodePoolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the requested node pool.
   *
   * @param name The name (project, location, cluster, node pool id) of the node pool to get.
   *     Specified in the format `projects/&#42;/locations/&#42;/clusters/&#42;/nodePools/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodePool getNodePool(String name) {
    GetNodePoolRequest request = GetNodePoolRequest.newBuilder().setName(name).build();
    return getNodePool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the requested node pool.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://developers.google.com/console/help/new/#projectnumber). This field has been
   *     deprecated and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the name field.
   * @param clusterId Deprecated. The name of the cluster. This field has been deprecated and
   *     replaced by the name field.
   * @param nodePoolId Deprecated. The name of the node pool. This field has been deprecated and
   *     replaced by the name field.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the requested node pool.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodePool getNodePool(GetNodePoolRequest request) {
    return getNodePoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the requested node pool.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetNodePoolRequest, NodePool> getNodePoolCallable() {
    return stub.getNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a node pool for a cluster.
   *
   * @param parent The parent (project, location, cluster id) where the node pool will be created.
   *     Specified in the format `projects/&#42;/locations/&#42;/clusters/&#42;`.
   * @param nodePool Required. The node pool to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createNodePool(String parent, NodePool nodePool) {
    CreateNodePoolRequest request =
        CreateNodePoolRequest.newBuilder().setParent(parent).setNodePool(nodePool).build();
    return createNodePool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a node pool for a cluster.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://developers.google.com/console/help/new/#projectnumber). This field has been
   *     deprecated and replaced by the parent field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the parent field.
   * @param clusterId Deprecated. The name of the cluster. This field has been deprecated and
   *     replaced by the parent field.
   * @param nodePool Required. The node pool to create.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a node pool for a cluster.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createNodePool(CreateNodePoolRequest request) {
    return createNodePoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a node pool for a cluster.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateNodePoolRequest, Operation> createNodePoolCallable() {
    return stub.createNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a node pool from a cluster.
   *
   * @param name The name (project, location, cluster, node pool id) of the node pool to delete.
   *     Specified in the format `projects/&#42;/locations/&#42;/clusters/&#42;/nodePools/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deleteNodePool(String name) {
    DeleteNodePoolRequest request = DeleteNodePoolRequest.newBuilder().setName(name).build();
    return deleteNodePool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a node pool from a cluster.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://developers.google.com/console/help/new/#projectnumber). This field has been
   *     deprecated and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the name field.
   * @param clusterId Deprecated. The name of the cluster. This field has been deprecated and
   *     replaced by the name field.
   * @param nodePoolId Deprecated. The name of the node pool to delete. This field has been
   *     deprecated and replaced by the name field.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a node pool from a cluster.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation deleteNodePool(DeleteNodePoolRequest request) {
    return deleteNodePoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a node pool from a cluster.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteNodePoolRequest, Operation> deleteNodePoolCallable() {
    return stub.deleteNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rolls back a previously Aborted or Failed NodePool upgrade. This makes no changes if the last
   * upgrade successfully completed.
   *
   * @param name The name (project, location, cluster, node pool id) of the node poll to rollback
   *     upgrade. Specified in the format
   *     `projects/&#42;/locations/&#42;/clusters/&#42;/nodePools/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation rollbackNodePoolUpgrade(String name) {
    RollbackNodePoolUpgradeRequest request =
        RollbackNodePoolUpgradeRequest.newBuilder().setName(name).build();
    return rollbackNodePoolUpgrade(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rolls back a previously Aborted or Failed NodePool upgrade. This makes no changes if the last
   * upgrade successfully completed.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840). This field has been deprecated
   *     and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the name field.
   * @param clusterId Deprecated. The name of the cluster to rollback. This field has been
   *     deprecated and replaced by the name field.
   * @param nodePoolId Deprecated. The name of the node pool to rollback. This field has been
   *     deprecated and replaced by the name field.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rolls back a previously Aborted or Failed NodePool upgrade. This makes no changes if the last
   * upgrade successfully completed.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation rollbackNodePoolUpgrade(RollbackNodePoolUpgradeRequest request) {
    return rollbackNodePoolUpgradeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rolls back a previously Aborted or Failed NodePool upgrade. This makes no changes if the last
   * upgrade successfully completed.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<RollbackNodePoolUpgradeRequest, Operation>
      rollbackNodePoolUpgradeCallable() {
    return stub.rollbackNodePoolUpgradeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the NodeManagement options for a node pool.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setNodePoolManagement(SetNodePoolManagementRequest request) {
    return setNodePoolManagementCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the NodeManagement options for a node pool.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetNodePoolManagementRequest, Operation>
      setNodePoolManagementCallable() {
    return stub.setNodePoolManagementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets labels on a cluster.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLabels(SetLabelsRequest request) {
    return setLabelsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets labels on a cluster.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetLabelsRequest, Operation> setLabelsCallable() {
    return stub.setLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables or disables the ABAC authorization mechanism on a cluster.
   *
   * @param name The name (project, location, cluster id) of the cluster to set legacy abac.
   *     Specified in the format `projects/&#42;/locations/&#42;/clusters/&#42;`.
   * @param enabled Required. Whether ABAC authorization will be enabled in the cluster.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLegacyAbac(String name, boolean enabled) {
    SetLegacyAbacRequest request =
        SetLegacyAbacRequest.newBuilder().setName(name).setEnabled(enabled).build();
    return setLegacyAbac(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables or disables the ABAC authorization mechanism on a cluster.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840). This field has been deprecated
   *     and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the name field.
   * @param clusterId Deprecated. The name of the cluster to update. This field has been deprecated
   *     and replaced by the name field.
   * @param enabled Required. Whether ABAC authorization will be enabled in the cluster.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables or disables the ABAC authorization mechanism on a cluster.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setLegacyAbac(SetLegacyAbacRequest request) {
    return setLegacyAbacCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables or disables the ABAC authorization mechanism on a cluster.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetLegacyAbacRequest, Operation> setLegacyAbacCallable() {
    return stub.setLegacyAbacCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts master IP rotation.
   *
   * @param name The name (project, location, cluster id) of the cluster to start IP rotation.
   *     Specified in the format `projects/&#42;/locations/&#42;/clusters/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation startIPRotation(String name) {
    StartIPRotationRequest request = StartIPRotationRequest.newBuilder().setName(name).build();
    return startIPRotation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts master IP rotation.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://developers.google.com/console/help/new/#projectnumber). This field has been
   *     deprecated and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the name field.
   * @param clusterId Deprecated. The name of the cluster. This field has been deprecated and
   *     replaced by the name field.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts master IP rotation.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation startIPRotation(StartIPRotationRequest request) {
    return startIPRotationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts master IP rotation.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<StartIPRotationRequest, Operation> startIPRotationCallable() {
    return stub.startIPRotationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Completes master IP rotation.
   *
   * @param name The name (project, location, cluster id) of the cluster to complete IP rotation.
   *     Specified in the format `projects/&#42;/locations/&#42;/clusters/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation completeIPRotation(String name) {
    CompleteIPRotationRequest request =
        CompleteIPRotationRequest.newBuilder().setName(name).build();
    return completeIPRotation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Completes master IP rotation.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://developers.google.com/console/help/new/#projectnumber). This field has been
   *     deprecated and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the name field.
   * @param clusterId Deprecated. The name of the cluster. This field has been deprecated and
   *     replaced by the name field.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Completes master IP rotation.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation completeIPRotation(CompleteIPRotationRequest request) {
    return completeIPRotationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Completes master IP rotation.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CompleteIPRotationRequest, Operation> completeIPRotationCallable() {
    return stub.completeIPRotationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the size for a specific node pool.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setNodePoolSize(SetNodePoolSizeRequest request) {
    return setNodePoolSizeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the size for a specific node pool.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetNodePoolSizeRequest, Operation> setNodePoolSizeCallable() {
    return stub.setNodePoolSizeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables or disables Network Policy for a cluster.
   *
   * @param name The name (project, location, cluster id) of the cluster to set networking policy.
   *     Specified in the format `projects/&#42;/locations/&#42;/clusters/&#42;`.
   * @param networkPolicy Required. Configuration options for the NetworkPolicy feature.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setNetworkPolicy(String name, NetworkPolicy networkPolicy) {
    SetNetworkPolicyRequest request =
        SetNetworkPolicyRequest.newBuilder().setName(name).setNetworkPolicy(networkPolicy).build();
    return setNetworkPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables or disables Network Policy for a cluster.
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://developers.google.com/console/help/new/#projectnumber). This field has been
   *     deprecated and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the name field.
   * @param clusterId Deprecated. The name of the cluster. This field has been deprecated and
   *     replaced by the name field.
   * @param networkPolicy Required. Configuration options for the NetworkPolicy feature.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables or disables Network Policy for a cluster.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setNetworkPolicy(SetNetworkPolicyRequest request) {
    return setNetworkPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables or disables Network Policy for a cluster.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetNetworkPolicyRequest, Operation> setNetworkPolicyCallable() {
    return stub.setNetworkPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the maintenance policy for a cluster.
   *
   * @param name The name (project, location, cluster id) of the cluster to set maintenance policy.
   *     Specified in the format `projects/&#42;/locations/&#42;/clusters/&#42;`.
   * @param maintenancePolicy Required. The maintenance policy to be set for the cluster. An empty
   *     field clears the existing maintenance policy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMaintenancePolicy(String name, MaintenancePolicy maintenancePolicy) {
    SetMaintenancePolicyRequest request =
        SetMaintenancePolicyRequest.newBuilder()
            .setName(name)
            .setMaintenancePolicy(maintenancePolicy)
            .build();
    return setMaintenancePolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the maintenance policy for a cluster.
   *
   * @param projectId Required. The Google Developers Console [project ID or project
   *     number](https://support.google.com/cloud/answer/6158840).
   * @param zone Required. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   * @param clusterId Required. The name of the cluster to update.
   * @param maintenancePolicy Required. The maintenance policy to be set for the cluster. An empty
   *     field clears the existing maintenance policy.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the maintenance policy for a cluster.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setMaintenancePolicy(SetMaintenancePolicyRequest request) {
    return setMaintenancePolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the maintenance policy for a cluster.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetMaintenancePolicyRequest, Operation>
      setMaintenancePolicyCallable() {
    return stub.setMaintenancePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists subnetworks that are usable for creating clusters in a project.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUsableSubnetworksPagedResponse listUsableSubnetworks(
      ListUsableSubnetworksRequest request) {
    return listUsableSubnetworksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists subnetworks that are usable for creating clusters in a project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListUsableSubnetworksRequest, ListUsableSubnetworksPagedResponse>
      listUsableSubnetworksPagedCallable() {
    return stub.listUsableSubnetworksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists subnetworks that are usable for creating clusters in a project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>
      listUsableSubnetworksCallable() {
    return stub.listUsableSubnetworksCallable();
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
          ListUsableSubnetworksRequest,
          ListUsableSubnetworksResponse,
          UsableSubnetwork,
          ListUsableSubnetworksPage,
          ListUsableSubnetworksFixedSizeCollection> {

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
          },
          MoreExecutors.directExecutor());
    }

    private ListUsableSubnetworksPagedResponse(ListUsableSubnetworksPage page) {
      super(page, ListUsableSubnetworksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUsableSubnetworksPage
      extends AbstractPage<
          ListUsableSubnetworksRequest,
          ListUsableSubnetworksResponse,
          UsableSubnetwork,
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
          ListUsableSubnetworksRequest,
          ListUsableSubnetworksResponse,
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
