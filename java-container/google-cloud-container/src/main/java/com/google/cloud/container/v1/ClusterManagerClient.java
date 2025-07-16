/*
 * Copyright 2025 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
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
import com.google.container.v1.CheckAutopilotCompatibilityRequest;
import com.google.container.v1.CheckAutopilotCompatibilityResponse;
import com.google.container.v1.Cluster;
import com.google.container.v1.ClusterUpdate;
import com.google.container.v1.ClusterUpgradeInfo;
import com.google.container.v1.CompleteIPRotationRequest;
import com.google.container.v1.CompleteNodePoolUpgradeRequest;
import com.google.container.v1.CreateClusterRequest;
import com.google.container.v1.CreateNodePoolRequest;
import com.google.container.v1.DeleteClusterRequest;
import com.google.container.v1.DeleteNodePoolRequest;
import com.google.container.v1.FetchClusterUpgradeInfoRequest;
import com.google.container.v1.FetchNodePoolUpgradeInfoRequest;
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
import com.google.container.v1.NodePoolUpgradeInfo;
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
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
 *   String parent = "parent-995424086";
 *   ListClustersResponse response = clusterManagerClient.listClusters(parent);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ClusterManagerClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListClusters</td>
 *      <td><p> Lists all clusters owned by a project in either the specified zone or all zones.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listClusters(ListClustersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listClusters(String parent)
 *           <li><p> listClusters(String projectId, String zone)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listClustersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCluster</td>
 *      <td><p> Gets the details of a specific cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCluster(GetClusterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCluster(String name)
 *           <li><p> getCluster(String projectId, String zone, String clusterId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCluster</td>
 *      <td><p> Creates a cluster, consisting of the specified number and type of Google Compute Engine instances.
 * <p>  By default, the cluster is created in the project's [default network](https://cloud.google.com/compute/docs/networks-and-firewalls#networks).
 * <p>  One firewall is added for the cluster. After cluster creation, the Kubelet creates routes for each node to allow the containers on that node to communicate with all other instances in the cluster.
 * <p>  Finally, an entry is added to the project's global metadata indicating which CIDR range the cluster is using.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCluster(CreateClusterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createCluster(String parent, Cluster cluster)
 *           <li><p> createCluster(String projectId, String zone, Cluster cluster)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCluster</td>
 *      <td><p> Updates the settings of a specific cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCluster(UpdateClusterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCluster(String name, ClusterUpdate update)
 *           <li><p> updateCluster(String projectId, String zone, String clusterId, ClusterUpdate update)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateNodePool</td>
 *      <td><p> Updates the version and/or image type for the specified node pool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateNodePool(UpdateNodePoolRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateNodePoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetNodePoolAutoscaling</td>
 *      <td><p> Sets the autoscaling settings for the specified node pool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setNodePoolAutoscaling(SetNodePoolAutoscalingRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setNodePoolAutoscalingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetLoggingService</td>
 *      <td><p> Sets the logging service for a specific cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setLoggingService(SetLoggingServiceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setLoggingService(String name, String loggingService)
 *           <li><p> setLoggingService(String projectId, String zone, String clusterId, String loggingService)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setLoggingServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetMonitoringService</td>
 *      <td><p> Sets the monitoring service for a specific cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setMonitoringService(SetMonitoringServiceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setMonitoringService(String name, String monitoringService)
 *           <li><p> setMonitoringService(String projectId, String zone, String clusterId, String monitoringService)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setMonitoringServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetAddonsConfig</td>
 *      <td><p> Sets the addons for a specific cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setAddonsConfig(SetAddonsConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setAddonsConfig(String name, AddonsConfig addonsConfig)
 *           <li><p> setAddonsConfig(String projectId, String zone, String clusterId, AddonsConfig addonsConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setAddonsConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetLocations</td>
 *      <td><p> Sets the locations for a specific cluster. Deprecated. Use [projects.locations.clusters.update](https://cloud.google.com/kubernetes-engine/docs/reference/rest/v1/projects.locations.clusters/update) instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setLocations(SetLocationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setLocations(String name, List&lt;String&gt; locations)
 *           <li><p> setLocations(String projectId, String zone, String clusterId, List&lt;String&gt; locations)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMaster</td>
 *      <td><p> Updates the master for a specific cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMaster(UpdateMasterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateMaster(String name, String masterVersion)
 *           <li><p> updateMaster(String projectId, String zone, String clusterId, String masterVersion)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMasterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetMasterAuth</td>
 *      <td><p> Sets master auth materials. Currently supports changing the admin password or a specific cluster, either via password generation or explicitly setting the password.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setMasterAuth(SetMasterAuthRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setMasterAuthCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCluster</td>
 *      <td><p> Deletes the cluster, including the Kubernetes endpoint and all worker nodes.
 * <p>  Firewalls and routes that were configured during cluster creation are also deleted.
 * <p>  Other Google Compute Engine resources that might be in use by the cluster, such as load balancer resources, are not deleted if they weren't present when the cluster was initially created.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCluster(DeleteClusterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteCluster(String name)
 *           <li><p> deleteCluster(String projectId, String zone, String clusterId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListOperations</td>
 *      <td><p> Lists all operations in a project in a specific zone or all zones.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listOperations(ListOperationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listOperations(String parent)
 *           <li><p> listOperations(String projectId, String zone)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listOperationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetOperation</td>
 *      <td><p> Gets the specified operation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOperation(GetOperationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOperation(String name)
 *           <li><p> getOperation(String projectId, String zone, String operationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOperationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CancelOperation</td>
 *      <td><p> Cancels the specified operation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> cancelOperation(CancelOperationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> cancelOperation(String name)
 *           <li><p> cancelOperation(String projectId, String zone, String operationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> cancelOperationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetServerConfig</td>
 *      <td><p> Returns configuration info about the Google Kubernetes Engine service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getServerConfig(GetServerConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getServerConfig(String name)
 *           <li><p> getServerConfig(String projectId, String zone)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getServerConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetJSONWebKeys</td>
 *      <td><p> Gets the public component of the cluster signing keys in JSON Web Key format.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getJSONWebKeys(GetJSONWebKeysRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getJSONWebKeysCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNodePools</td>
 *      <td><p> Lists the node pools for a cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNodePools(ListNodePoolsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNodePools(String parent)
 *           <li><p> listNodePools(String projectId, String zone, String clusterId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNodePoolsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNodePool</td>
 *      <td><p> Retrieves the requested node pool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNodePool(GetNodePoolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNodePool(String name)
 *           <li><p> getNodePool(String projectId, String zone, String clusterId, String nodePoolId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNodePoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateNodePool</td>
 *      <td><p> Creates a node pool for a cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createNodePool(CreateNodePoolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createNodePool(String parent, NodePool nodePool)
 *           <li><p> createNodePool(String projectId, String zone, String clusterId, NodePool nodePool)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createNodePoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteNodePool</td>
 *      <td><p> Deletes a node pool from a cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteNodePool(DeleteNodePoolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteNodePool(String name)
 *           <li><p> deleteNodePool(String projectId, String zone, String clusterId, String nodePoolId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteNodePoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CompleteNodePoolUpgrade</td>
 *      <td><p> CompleteNodePoolUpgrade will signal an on-going node pool upgrade to complete.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> completeNodePoolUpgrade(CompleteNodePoolUpgradeRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> completeNodePoolUpgradeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RollbackNodePoolUpgrade</td>
 *      <td><p> Rolls back a previously Aborted or Failed NodePool upgrade. This makes no changes if the last upgrade successfully completed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rollbackNodePoolUpgrade(RollbackNodePoolUpgradeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> rollbackNodePoolUpgrade(String name)
 *           <li><p> rollbackNodePoolUpgrade(String projectId, String zone, String clusterId, String nodePoolId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rollbackNodePoolUpgradeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetNodePoolManagement</td>
 *      <td><p> Sets the NodeManagement options for a node pool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setNodePoolManagement(SetNodePoolManagementRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setNodePoolManagementCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetLabels</td>
 *      <td><p> Sets labels on a cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setLabels(SetLabelsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setLabelsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetLegacyAbac</td>
 *      <td><p> Enables or disables the ABAC authorization mechanism on a cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setLegacyAbac(SetLegacyAbacRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setLegacyAbac(String name, boolean enabled)
 *           <li><p> setLegacyAbac(String projectId, String zone, String clusterId, boolean enabled)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setLegacyAbacCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StartIPRotation</td>
 *      <td><p> Starts master IP rotation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> startIPRotation(StartIPRotationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> startIPRotation(String name)
 *           <li><p> startIPRotation(String projectId, String zone, String clusterId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> startIPRotationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CompleteIPRotation</td>
 *      <td><p> Completes master IP rotation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> completeIPRotation(CompleteIPRotationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> completeIPRotation(String name)
 *           <li><p> completeIPRotation(String projectId, String zone, String clusterId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> completeIPRotationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetNodePoolSize</td>
 *      <td><p> Sets the size for a specific node pool. The new size will be used for all replicas, including future replicas created by modifying [NodePool.locations][google.container.v1.NodePool.locations].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setNodePoolSize(SetNodePoolSizeRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setNodePoolSizeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetNetworkPolicy</td>
 *      <td><p> Enables or disables Network Policy for a cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setNetworkPolicy(SetNetworkPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setNetworkPolicy(String name, NetworkPolicy networkPolicy)
 *           <li><p> setNetworkPolicy(String projectId, String zone, String clusterId, NetworkPolicy networkPolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setNetworkPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetMaintenancePolicy</td>
 *      <td><p> Sets the maintenance policy for a cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setMaintenancePolicy(SetMaintenancePolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setMaintenancePolicy(String name, MaintenancePolicy maintenancePolicy)
 *           <li><p> setMaintenancePolicy(String projectId, String zone, String clusterId, MaintenancePolicy maintenancePolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setMaintenancePolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListUsableSubnetworks</td>
 *      <td><p> Lists subnetworks that are usable for creating clusters in a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listUsableSubnetworks(ListUsableSubnetworksRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listUsableSubnetworksPagedCallable()
 *           <li><p> listUsableSubnetworksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CheckAutopilotCompatibility</td>
 *      <td><p> Checks the cluster compatibility with Autopilot mode, and returns a list of compatibility issues.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> checkAutopilotCompatibility(CheckAutopilotCompatibilityRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> checkAutopilotCompatibilityCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchClusterUpgradeInfo</td>
 *      <td><p> Fetch upgrade information of a specific cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchClusterUpgradeInfo(FetchClusterUpgradeInfoRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchClusterUpgradeInfo(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchClusterUpgradeInfoCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchNodePoolUpgradeInfo</td>
 *      <td><p> Fetch upgrade information of a specific nodepool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchNodePoolUpgradeInfo(FetchNodePoolUpgradeInfoRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchNodePoolUpgradeInfo(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchNodePoolUpgradeInfoCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ClusterManagerSettings clusterManagerSettings =
 *     ClusterManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ClusterManagerClient clusterManagerClient = ClusterManagerClient.create(clusterManagerSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ClusterManagerSettings clusterManagerSettings =
 *     ClusterManagerSettings.newHttpJsonBuilder().build();
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

  protected ClusterManagerClient(ClusterManagerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ClusterManagerSettings getSettings() {
    return settings;
  }

  public ClusterManagerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all clusters owned by a project in either the specified zone or all zones.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String parent = "parent-995424086";
   *   ListClustersResponse response = clusterManagerClient.listClusters(parent);
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   ListClustersResponse response = clusterManagerClient.listClusters(projectId, zone);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the parent field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setParent("parent-995424086")
   *           .build();
   *   ListClustersResponse response = clusterManagerClient.listClusters(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setParent("parent-995424086")
   *           .build();
   *   ApiFuture<ListClustersResponse> future =
   *       clusterManagerClient.listClustersCallable().futureCall(request);
   *   // Do something.
   *   ListClustersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return stub.listClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   Cluster response = clusterManagerClient.getCluster(name);
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   Cluster response = clusterManagerClient.getCluster(projectId, zone, clusterId);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   GetClusterRequest request =
   *       GetClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setName("name3373707")
   *           .build();
   *   Cluster response = clusterManagerClient.getCluster(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   GetClusterRequest request =
   *       GetClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Cluster> future = clusterManagerClient.getClusterCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String parent = "parent-995424086";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   Operation response = clusterManagerClient.createCluster(parent, cluster);
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   Cluster cluster = Cluster.newBuilder().build();
   *   Operation response = clusterManagerClient.createCluster(projectId, zone, cluster);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the parent field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .build();
   *   Operation response = clusterManagerClient.createCluster(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.createClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return stub.createClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   ClusterUpdate update = ClusterUpdate.newBuilder().build();
   *   Operation response = clusterManagerClient.updateCluster(name, update);
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   ClusterUpdate update = ClusterUpdate.newBuilder().build();
   *   Operation response = clusterManagerClient.updateCluster(projectId, zone, clusterId, update);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setUpdate(ClusterUpdate.newBuilder().build())
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.updateCluster(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setUpdate(ClusterUpdate.newBuilder().build())
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.updateClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return stub.updateClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the version and/or image type for the specified node pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   UpdateNodePoolRequest request =
   *       UpdateNodePoolRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNodePoolId("nodePoolId1121557241")
   *           .setNodeVersion("nodeVersion1155309686")
   *           .setImageType("imageType-878147787")
   *           .setName("name3373707")
   *           .addAllLocations(new ArrayList<String>())
   *           .setWorkloadMetadataConfig(WorkloadMetadataConfig.newBuilder().build())
   *           .setUpgradeSettings(NodePool.UpgradeSettings.newBuilder().build())
   *           .setTags(NetworkTags.newBuilder().build())
   *           .setTaints(NodeTaints.newBuilder().build())
   *           .setLabels(NodeLabels.newBuilder().build())
   *           .setLinuxNodeConfig(LinuxNodeConfig.newBuilder().build())
   *           .setKubeletConfig(NodeKubeletConfig.newBuilder().build())
   *           .setNodeNetworkConfig(NodeNetworkConfig.newBuilder().build())
   *           .setGcfsConfig(GcfsConfig.newBuilder().build())
   *           .setConfidentialNodes(ConfidentialNodes.newBuilder().build())
   *           .setGvnic(VirtualNIC.newBuilder().build())
   *           .setEtag("etag3123477")
   *           .setFastSocket(FastSocket.newBuilder().build())
   *           .setLoggingConfig(NodePoolLoggingConfig.newBuilder().build())
   *           .setResourceLabels(ResourceLabels.newBuilder().build())
   *           .setWindowsNodeConfig(WindowsNodeConfig.newBuilder().build())
   *           .addAllAccelerators(new ArrayList<AcceleratorConfig>())
   *           .setMachineType("machineType-218117087")
   *           .setDiskType("diskType279771767")
   *           .setDiskSizeGb(-757478089)
   *           .setResourceManagerTags(ResourceManagerTags.newBuilder().build())
   *           .setContainerdConfig(ContainerdConfig.newBuilder().build())
   *           .setQueuedProvisioning(NodePool.QueuedProvisioning.newBuilder().build())
   *           .addAllStoragePools(new ArrayList<String>())
   *           .setMaxRunDuration(Duration.newBuilder().build())
   *           .setFlexStart(true)
   *           .setBootDisk(BootDisk.newBuilder().build())
   *           .build();
   *   Operation response = clusterManagerClient.updateNodePool(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   UpdateNodePoolRequest request =
   *       UpdateNodePoolRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNodePoolId("nodePoolId1121557241")
   *           .setNodeVersion("nodeVersion1155309686")
   *           .setImageType("imageType-878147787")
   *           .setName("name3373707")
   *           .addAllLocations(new ArrayList<String>())
   *           .setWorkloadMetadataConfig(WorkloadMetadataConfig.newBuilder().build())
   *           .setUpgradeSettings(NodePool.UpgradeSettings.newBuilder().build())
   *           .setTags(NetworkTags.newBuilder().build())
   *           .setTaints(NodeTaints.newBuilder().build())
   *           .setLabels(NodeLabels.newBuilder().build())
   *           .setLinuxNodeConfig(LinuxNodeConfig.newBuilder().build())
   *           .setKubeletConfig(NodeKubeletConfig.newBuilder().build())
   *           .setNodeNetworkConfig(NodeNetworkConfig.newBuilder().build())
   *           .setGcfsConfig(GcfsConfig.newBuilder().build())
   *           .setConfidentialNodes(ConfidentialNodes.newBuilder().build())
   *           .setGvnic(VirtualNIC.newBuilder().build())
   *           .setEtag("etag3123477")
   *           .setFastSocket(FastSocket.newBuilder().build())
   *           .setLoggingConfig(NodePoolLoggingConfig.newBuilder().build())
   *           .setResourceLabels(ResourceLabels.newBuilder().build())
   *           .setWindowsNodeConfig(WindowsNodeConfig.newBuilder().build())
   *           .addAllAccelerators(new ArrayList<AcceleratorConfig>())
   *           .setMachineType("machineType-218117087")
   *           .setDiskType("diskType279771767")
   *           .setDiskSizeGb(-757478089)
   *           .setResourceManagerTags(ResourceManagerTags.newBuilder().build())
   *           .setContainerdConfig(ContainerdConfig.newBuilder().build())
   *           .setQueuedProvisioning(NodePool.QueuedProvisioning.newBuilder().build())
   *           .addAllStoragePools(new ArrayList<String>())
   *           .setMaxRunDuration(Duration.newBuilder().build())
   *           .setFlexStart(true)
   *           .setBootDisk(BootDisk.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.updateNodePoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateNodePoolRequest, Operation> updateNodePoolCallable() {
    return stub.updateNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the autoscaling settings for the specified node pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetNodePoolAutoscalingRequest request =
   *       SetNodePoolAutoscalingRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNodePoolId("nodePoolId1121557241")
   *           .setAutoscaling(NodePoolAutoscaling.newBuilder().build())
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.setNodePoolAutoscaling(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetNodePoolAutoscalingRequest request =
   *       SetNodePoolAutoscalingRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNodePoolId("nodePoolId1121557241")
   *           .setAutoscaling(NodePoolAutoscaling.newBuilder().build())
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.setNodePoolAutoscalingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetNodePoolAutoscalingRequest, Operation>
      setNodePoolAutoscalingCallable() {
    return stub.setNodePoolAutoscalingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the logging service for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   String loggingService = "loggingService1098570326";
   *   Operation response = clusterManagerClient.setLoggingService(name, loggingService);
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   String loggingService = "loggingService1098570326";
   *   Operation response =
   *       clusterManagerClient.setLoggingService(projectId, zone, clusterId, loggingService);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetLoggingServiceRequest request =
   *       SetLoggingServiceRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setLoggingService("loggingService1098570326")
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.setLoggingService(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetLoggingServiceRequest request =
   *       SetLoggingServiceRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setLoggingService("loggingService1098570326")
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.setLoggingServiceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetLoggingServiceRequest, Operation> setLoggingServiceCallable() {
    return stub.setLoggingServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the monitoring service for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   String monitoringService = "monitoringService-1431578291";
   *   Operation response = clusterManagerClient.setMonitoringService(name, monitoringService);
   * }
   * }</pre>
   *
   * @param name The name (project, location, cluster) of the cluster to set monitoring. Specified
   *     in the format `projects/&#42;/locations/&#42;/clusters/&#42;`.
   * @param monitoringService Required. The monitoring service the cluster should use to write
   *     metrics. Currently available options:
   *     <ul>
   *       <li>`monitoring.googleapis.com/kubernetes` - The Cloud Monitoring service with a
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   String monitoringService = "monitoringService-1431578291";
   *   Operation response =
   *       clusterManagerClient.setMonitoringService(projectId, zone, clusterId, monitoringService);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
   * @param zone Deprecated. The name of the Google Compute Engine
   *     [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
   *     This field has been deprecated and replaced by the name field.
   * @param clusterId Deprecated. The name of the cluster to upgrade. This field has been deprecated
   *     and replaced by the name field.
   * @param monitoringService Required. The monitoring service the cluster should use to write
   *     metrics. Currently available options:
   *     <ul>
   *       <li>`monitoring.googleapis.com/kubernetes` - The Cloud Monitoring service with a
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetMonitoringServiceRequest request =
   *       SetMonitoringServiceRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setMonitoringService("monitoringService-1431578291")
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.setMonitoringService(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetMonitoringServiceRequest request =
   *       SetMonitoringServiceRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setMonitoringService("monitoringService-1431578291")
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.setMonitoringServiceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetMonitoringServiceRequest, Operation>
      setMonitoringServiceCallable() {
    return stub.setMonitoringServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the addons for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   AddonsConfig addonsConfig = AddonsConfig.newBuilder().build();
   *   Operation response = clusterManagerClient.setAddonsConfig(name, addonsConfig);
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   AddonsConfig addonsConfig = AddonsConfig.newBuilder().build();
   *   Operation response =
   *       clusterManagerClient.setAddonsConfig(projectId, zone, clusterId, addonsConfig);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetAddonsConfigRequest request =
   *       SetAddonsConfigRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setAddonsConfig(AddonsConfig.newBuilder().build())
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.setAddonsConfig(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetAddonsConfigRequest request =
   *       SetAddonsConfigRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setAddonsConfig(AddonsConfig.newBuilder().build())
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.setAddonsConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   List<String> locations = new ArrayList<>();
   *   Operation response = clusterManagerClient.setLocations(name, locations);
   * }
   * }</pre>
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
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   List<String> locations = new ArrayList<>();
   *   Operation response = clusterManagerClient.setLocations(projectId, zone, clusterId, locations);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
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
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetLocationsRequest request =
   *       SetLocationsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .addAllLocations(new ArrayList<String>())
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.setLocations(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetLocationsRequest request =
   *       SetLocationsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .addAllLocations(new ArrayList<String>())
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future = clusterManagerClient.setLocationsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<SetLocationsRequest, Operation> setLocationsCallable() {
    return stub.setLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the master for a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   String masterVersion = "masterVersion1167095830";
   *   Operation response = clusterManagerClient.updateMaster(name, masterVersion);
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   String masterVersion = "masterVersion1167095830";
   *   Operation response =
   *       clusterManagerClient.updateMaster(projectId, zone, clusterId, masterVersion);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   UpdateMasterRequest request =
   *       UpdateMasterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setMasterVersion("masterVersion1167095830")
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.updateMaster(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   UpdateMasterRequest request =
   *       UpdateMasterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setMasterVersion("masterVersion1167095830")
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future = clusterManagerClient.updateMasterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMasterRequest, Operation> updateMasterCallable() {
    return stub.updateMasterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets master auth materials. Currently supports changing the admin password or a specific
   * cluster, either via password generation or explicitly setting the password.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetMasterAuthRequest request =
   *       SetMasterAuthRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setUpdate(MasterAuth.newBuilder().build())
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.setMasterAuth(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetMasterAuthRequest request =
   *       SetMasterAuthRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setUpdate(MasterAuth.newBuilder().build())
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.setMasterAuthCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   Operation response = clusterManagerClient.deleteCluster(name);
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   Operation response = clusterManagerClient.deleteCluster(projectId, zone, clusterId);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.deleteCluster(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.deleteClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return stub.deleteClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all operations in a project in a specific zone or all zones.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String parent = "parent-995424086";
   *   ListOperationsResponse response = clusterManagerClient.listOperations(parent);
   * }
   * }</pre>
   *
   * @param parent The parent (project and location) where the operations will be listed. Specified
   *     in the format `projects/&#42;/locations/&#42;`. Location "-" matches all zones and all
   *     regions.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOperationsResponse listOperations(String parent) {
    ListOperationsRequest request = ListOperationsRequest.newBuilder().setParent(parent).build();
    return listOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all operations in a project in a specific zone or all zones.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   ListOperationsResponse response = clusterManagerClient.listOperations(projectId, zone);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the parent field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   ListOperationsRequest request =
   *       ListOperationsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setParent("parent-995424086")
   *           .build();
   *   ListOperationsResponse response = clusterManagerClient.listOperations(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   ListOperationsRequest request =
   *       ListOperationsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setParent("parent-995424086")
   *           .build();
   *   ApiFuture<ListOperationsResponse> future =
   *       clusterManagerClient.listOperationsCallable().futureCall(request);
   *   // Do something.
   *   ListOperationsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOperationsRequest, ListOperationsResponse>
      listOperationsCallable() {
    return stub.listOperationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   Operation response = clusterManagerClient.getOperation(name);
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String operationId = "operationId129704162";
   *   Operation response = clusterManagerClient.getOperation(projectId, zone, operationId);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   GetOperationRequest request =
   *       GetOperationRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setOperationId("operationId129704162")
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.getOperation(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   GetOperationRequest request =
   *       GetOperationRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setOperationId("operationId129704162")
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future = clusterManagerClient.getOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOperationRequest, Operation> getOperationCallable() {
    return stub.getOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the specified operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   clusterManagerClient.cancelOperation(name);
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String operationId = "operationId129704162";
   *   clusterManagerClient.cancelOperation(projectId, zone, operationId);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   CancelOperationRequest request =
   *       CancelOperationRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setOperationId("operationId129704162")
   *           .setName("name3373707")
   *           .build();
   *   clusterManagerClient.cancelOperation(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   CancelOperationRequest request =
   *       CancelOperationRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setOperationId("operationId129704162")
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Empty> future = clusterManagerClient.cancelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelOperationRequest, Empty> cancelOperationCallable() {
    return stub.cancelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns configuration info about the Google Kubernetes Engine service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   ServerConfig response = clusterManagerClient.getServerConfig(name);
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   ServerConfig response = clusterManagerClient.getServerConfig(projectId, zone);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   GetServerConfigRequest request =
   *       GetServerConfigRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setName("name3373707")
   *           .build();
   *   ServerConfig response = clusterManagerClient.getServerConfig(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   GetServerConfigRequest request =
   *       GetServerConfigRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<ServerConfig> future =
   *       clusterManagerClient.getServerConfigCallable().futureCall(request);
   *   // Do something.
   *   ServerConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServerConfigRequest, ServerConfig> getServerConfigCallable() {
    return stub.getServerConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the public component of the cluster signing keys in JSON Web Key format.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   GetJSONWebKeysRequest request =
   *       GetJSONWebKeysRequest.newBuilder().setParent("parent-995424086").build();
   *   GetJSONWebKeysResponse response = clusterManagerClient.getJSONWebKeys(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetJSONWebKeysResponse getJSONWebKeys(GetJSONWebKeysRequest request) {
    return getJSONWebKeysCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the public component of the cluster signing keys in JSON Web Key format.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   GetJSONWebKeysRequest request =
   *       GetJSONWebKeysRequest.newBuilder().setParent("parent-995424086").build();
   *   ApiFuture<GetJSONWebKeysResponse> future =
   *       clusterManagerClient.getJSONWebKeysCallable().futureCall(request);
   *   // Do something.
   *   GetJSONWebKeysResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetJSONWebKeysRequest, GetJSONWebKeysResponse>
      getJSONWebKeysCallable() {
    return stub.getJSONWebKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the node pools for a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String parent = "parent-995424086";
   *   ListNodePoolsResponse response = clusterManagerClient.listNodePools(parent);
   * }
   * }</pre>
   *
   * @param parent The parent (project, location, cluster name) where the node pools will be listed.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   ListNodePoolsResponse response =
   *       clusterManagerClient.listNodePools(projectId, zone, clusterId);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the parent field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   ListNodePoolsRequest request =
   *       ListNodePoolsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setParent("parent-995424086")
   *           .build();
   *   ListNodePoolsResponse response = clusterManagerClient.listNodePools(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   ListNodePoolsRequest request =
   *       ListNodePoolsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setParent("parent-995424086")
   *           .build();
   *   ApiFuture<ListNodePoolsResponse> future =
   *       clusterManagerClient.listNodePoolsCallable().futureCall(request);
   *   // Do something.
   *   ListNodePoolsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsCallable() {
    return stub.listNodePoolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the requested node pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   NodePool response = clusterManagerClient.getNodePool(name);
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   String nodePoolId = "nodePoolId1121557241";
   *   NodePool response = clusterManagerClient.getNodePool(projectId, zone, clusterId, nodePoolId);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   GetNodePoolRequest request =
   *       GetNodePoolRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNodePoolId("nodePoolId1121557241")
   *           .setName("name3373707")
   *           .build();
   *   NodePool response = clusterManagerClient.getNodePool(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   GetNodePoolRequest request =
   *       GetNodePoolRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNodePoolId("nodePoolId1121557241")
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<NodePool> future = clusterManagerClient.getNodePoolCallable().futureCall(request);
   *   // Do something.
   *   NodePool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNodePoolRequest, NodePool> getNodePoolCallable() {
    return stub.getNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a node pool for a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String parent = "parent-995424086";
   *   NodePool nodePool = NodePool.newBuilder().build();
   *   Operation response = clusterManagerClient.createNodePool(parent, nodePool);
   * }
   * }</pre>
   *
   * @param parent The parent (project, location, cluster name) where the node pool will be created.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   NodePool nodePool = NodePool.newBuilder().build();
   *   Operation response =
   *       clusterManagerClient.createNodePool(projectId, zone, clusterId, nodePool);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the parent field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   CreateNodePoolRequest request =
   *       CreateNodePoolRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNodePool(NodePool.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .build();
   *   Operation response = clusterManagerClient.createNodePool(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   CreateNodePoolRequest request =
   *       CreateNodePoolRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNodePool(NodePool.newBuilder().build())
   *           .setParent("parent-995424086")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.createNodePoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateNodePoolRequest, Operation> createNodePoolCallable() {
    return stub.createNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a node pool from a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   Operation response = clusterManagerClient.deleteNodePool(name);
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   String nodePoolId = "nodePoolId1121557241";
   *   Operation response =
   *       clusterManagerClient.deleteNodePool(projectId, zone, clusterId, nodePoolId);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   DeleteNodePoolRequest request =
   *       DeleteNodePoolRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNodePoolId("nodePoolId1121557241")
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.deleteNodePool(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   DeleteNodePoolRequest request =
   *       DeleteNodePoolRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNodePoolId("nodePoolId1121557241")
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.deleteNodePoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNodePoolRequest, Operation> deleteNodePoolCallable() {
    return stub.deleteNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CompleteNodePoolUpgrade will signal an on-going node pool upgrade to complete.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   CompleteNodePoolUpgradeRequest request =
   *       CompleteNodePoolUpgradeRequest.newBuilder().setName("name3373707").build();
   *   clusterManagerClient.completeNodePoolUpgrade(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void completeNodePoolUpgrade(CompleteNodePoolUpgradeRequest request) {
    completeNodePoolUpgradeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CompleteNodePoolUpgrade will signal an on-going node pool upgrade to complete.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   CompleteNodePoolUpgradeRequest request =
   *       CompleteNodePoolUpgradeRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Empty> future =
   *       clusterManagerClient.completeNodePoolUpgradeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CompleteNodePoolUpgradeRequest, Empty>
      completeNodePoolUpgradeCallable() {
    return stub.completeNodePoolUpgradeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rolls back a previously Aborted or Failed NodePool upgrade. This makes no changes if the last
   * upgrade successfully completed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   Operation response = clusterManagerClient.rollbackNodePoolUpgrade(name);
   * }
   * }</pre>
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   String nodePoolId = "nodePoolId1121557241";
   *   Operation response =
   *       clusterManagerClient.rollbackNodePoolUpgrade(projectId, zone, clusterId, nodePoolId);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   RollbackNodePoolUpgradeRequest request =
   *       RollbackNodePoolUpgradeRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNodePoolId("nodePoolId1121557241")
   *           .setName("name3373707")
   *           .setRespectPdb(true)
   *           .build();
   *   Operation response = clusterManagerClient.rollbackNodePoolUpgrade(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   RollbackNodePoolUpgradeRequest request =
   *       RollbackNodePoolUpgradeRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNodePoolId("nodePoolId1121557241")
   *           .setName("name3373707")
   *           .setRespectPdb(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.rollbackNodePoolUpgradeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RollbackNodePoolUpgradeRequest, Operation>
      rollbackNodePoolUpgradeCallable() {
    return stub.rollbackNodePoolUpgradeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the NodeManagement options for a node pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetNodePoolManagementRequest request =
   *       SetNodePoolManagementRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNodePoolId("nodePoolId1121557241")
   *           .setManagement(NodeManagement.newBuilder().build())
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.setNodePoolManagement(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetNodePoolManagementRequest request =
   *       SetNodePoolManagementRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNodePoolId("nodePoolId1121557241")
   *           .setManagement(NodeManagement.newBuilder().build())
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.setNodePoolManagementCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetNodePoolManagementRequest, Operation>
      setNodePoolManagementCallable() {
    return stub.setNodePoolManagementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets labels on a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetLabelsRequest request =
   *       SetLabelsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .putAllResourceLabels(new HashMap<String, String>())
   *           .setLabelFingerprint("labelFingerprint379449680")
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.setLabels(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetLabelsRequest request =
   *       SetLabelsRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .putAllResourceLabels(new HashMap<String, String>())
   *           .setLabelFingerprint("labelFingerprint379449680")
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future = clusterManagerClient.setLabelsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetLabelsRequest, Operation> setLabelsCallable() {
    return stub.setLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables or disables the ABAC authorization mechanism on a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   boolean enabled = true;
   *   Operation response = clusterManagerClient.setLegacyAbac(name, enabled);
   * }
   * }</pre>
   *
   * @param name The name (project, location, cluster name) of the cluster to set legacy abac.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   boolean enabled = true;
   *   Operation response = clusterManagerClient.setLegacyAbac(projectId, zone, clusterId, enabled);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetLegacyAbacRequest request =
   *       SetLegacyAbacRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setEnabled(true)
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.setLegacyAbac(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetLegacyAbacRequest request =
   *       SetLegacyAbacRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setEnabled(true)
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.setLegacyAbacCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetLegacyAbacRequest, Operation> setLegacyAbacCallable() {
    return stub.setLegacyAbacCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts master IP rotation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   Operation response = clusterManagerClient.startIPRotation(name);
   * }
   * }</pre>
   *
   * @param name The name (project, location, cluster name) of the cluster to start IP rotation.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   Operation response = clusterManagerClient.startIPRotation(projectId, zone, clusterId);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   StartIPRotationRequest request =
   *       StartIPRotationRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setName("name3373707")
   *           .setRotateCredentials(true)
   *           .build();
   *   Operation response = clusterManagerClient.startIPRotation(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   StartIPRotationRequest request =
   *       StartIPRotationRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setName("name3373707")
   *           .setRotateCredentials(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.startIPRotationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartIPRotationRequest, Operation> startIPRotationCallable() {
    return stub.startIPRotationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Completes master IP rotation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   Operation response = clusterManagerClient.completeIPRotation(name);
   * }
   * }</pre>
   *
   * @param name The name (project, location, cluster name) of the cluster to complete IP rotation.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   Operation response = clusterManagerClient.completeIPRotation(projectId, zone, clusterId);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   CompleteIPRotationRequest request =
   *       CompleteIPRotationRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.completeIPRotation(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   CompleteIPRotationRequest request =
   *       CompleteIPRotationRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.completeIPRotationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CompleteIPRotationRequest, Operation> completeIPRotationCallable() {
    return stub.completeIPRotationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the size for a specific node pool. The new size will be used for all replicas, including
   * future replicas created by modifying
   * [NodePool.locations][google.container.v1.NodePool.locations].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetNodePoolSizeRequest request =
   *       SetNodePoolSizeRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNodePoolId("nodePoolId1121557241")
   *           .setNodeCount(1539922066)
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.setNodePoolSize(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setNodePoolSize(SetNodePoolSizeRequest request) {
    return setNodePoolSizeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the size for a specific node pool. The new size will be used for all replicas, including
   * future replicas created by modifying
   * [NodePool.locations][google.container.v1.NodePool.locations].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetNodePoolSizeRequest request =
   *       SetNodePoolSizeRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNodePoolId("nodePoolId1121557241")
   *           .setNodeCount(1539922066)
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.setNodePoolSizeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetNodePoolSizeRequest, Operation> setNodePoolSizeCallable() {
    return stub.setNodePoolSizeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables or disables Network Policy for a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
   *   Operation response = clusterManagerClient.setNetworkPolicy(name, networkPolicy);
   * }
   * }</pre>
   *
   * @param name The name (project, location, cluster name) of the cluster to set networking policy.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
   *   Operation response =
   *       clusterManagerClient.setNetworkPolicy(projectId, zone, clusterId, networkPolicy);
   * }
   * }</pre>
   *
   * @param projectId Deprecated. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This
   *     field has been deprecated and replaced by the name field.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetNetworkPolicyRequest request =
   *       SetNetworkPolicyRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNetworkPolicy(NetworkPolicy.newBuilder().build())
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.setNetworkPolicy(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetNetworkPolicyRequest request =
   *       SetNetworkPolicyRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setNetworkPolicy(NetworkPolicy.newBuilder().build())
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.setNetworkPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetNetworkPolicyRequest, Operation> setNetworkPolicyCallable() {
    return stub.setNetworkPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the maintenance policy for a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   MaintenancePolicy maintenancePolicy = MaintenancePolicy.newBuilder().build();
   *   Operation response = clusterManagerClient.setMaintenancePolicy(name, maintenancePolicy);
   * }
   * }</pre>
   *
   * @param name The name (project, location, cluster name) of the cluster to set maintenance
   *     policy. Specified in the format `projects/&#42;/locations/&#42;/clusters/&#42;`.
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String zone = "zone3744684";
   *   String clusterId = "clusterId561939637";
   *   MaintenancePolicy maintenancePolicy = MaintenancePolicy.newBuilder().build();
   *   Operation response =
   *       clusterManagerClient.setMaintenancePolicy(projectId, zone, clusterId, maintenancePolicy);
   * }
   * }</pre>
   *
   * @param projectId Required. The Google Developers Console [project ID or project
   *     number](https://cloud.google.com/resource-manager/docs/creating-managing-projects).
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
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetMaintenancePolicyRequest request =
   *       SetMaintenancePolicyRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
   *           .setName("name3373707")
   *           .build();
   *   Operation response = clusterManagerClient.setMaintenancePolicy(request);
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   SetMaintenancePolicyRequest request =
   *       SetMaintenancePolicyRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setZone("zone3744684")
   *           .setClusterId("clusterId561939637")
   *           .setMaintenancePolicy(MaintenancePolicy.newBuilder().build())
   *           .setName("name3373707")
   *           .build();
   *   ApiFuture<Operation> future =
   *       clusterManagerClient.setMaintenancePolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetMaintenancePolicyRequest, Operation>
      setMaintenancePolicyCallable() {
    return stub.setMaintenancePolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists subnetworks that are usable for creating clusters in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   ListUsableSubnetworksRequest request =
   *       ListUsableSubnetworksRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (UsableSubnetwork element :
   *       clusterManagerClient.listUsableSubnetworks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   ListUsableSubnetworksRequest request =
   *       ListUsableSubnetworksRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<UsableSubnetwork> future =
   *       clusterManagerClient.listUsableSubnetworksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (UsableSubnetwork element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
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
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   ListUsableSubnetworksRequest request =
   *       ListUsableSubnetworksRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListUsableSubnetworksResponse response =
   *         clusterManagerClient.listUsableSubnetworksCallable().call(request);
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
   * }</pre>
   */
  public final UnaryCallable<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>
      listUsableSubnetworksCallable() {
    return stub.listUsableSubnetworksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Checks the cluster compatibility with Autopilot mode, and returns a list of compatibility
   * issues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   CheckAutopilotCompatibilityRequest request =
   *       CheckAutopilotCompatibilityRequest.newBuilder().setName("name3373707").build();
   *   CheckAutopilotCompatibilityResponse response =
   *       clusterManagerClient.checkAutopilotCompatibility(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckAutopilotCompatibilityResponse checkAutopilotCompatibility(
      CheckAutopilotCompatibilityRequest request) {
    return checkAutopilotCompatibilityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Checks the cluster compatibility with Autopilot mode, and returns a list of compatibility
   * issues.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   CheckAutopilotCompatibilityRequest request =
   *       CheckAutopilotCompatibilityRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<CheckAutopilotCompatibilityResponse> future =
   *       clusterManagerClient.checkAutopilotCompatibilityCallable().futureCall(request);
   *   // Do something.
   *   CheckAutopilotCompatibilityResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          CheckAutopilotCompatibilityRequest, CheckAutopilotCompatibilityResponse>
      checkAutopilotCompatibilityCallable() {
    return stub.checkAutopilotCompatibilityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch upgrade information of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   ClusterUpgradeInfo response = clusterManagerClient.fetchClusterUpgradeInfo(name);
   * }
   * }</pre>
   *
   * @param name Required. The name (project, location, cluster) of the cluster to get. Specified in
   *     the format `projects/&#42;/locations/&#42;/clusters/&#42;` or
   *     `projects/&#42;/zones/&#42;/clusters/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClusterUpgradeInfo fetchClusterUpgradeInfo(String name) {
    FetchClusterUpgradeInfoRequest request =
        FetchClusterUpgradeInfoRequest.newBuilder().setName(name).build();
    return fetchClusterUpgradeInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch upgrade information of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   FetchClusterUpgradeInfoRequest request =
   *       FetchClusterUpgradeInfoRequest.newBuilder()
   *           .setName("name3373707")
   *           .setVersion("version351608024")
   *           .build();
   *   ClusterUpgradeInfo response = clusterManagerClient.fetchClusterUpgradeInfo(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClusterUpgradeInfo fetchClusterUpgradeInfo(FetchClusterUpgradeInfoRequest request) {
    return fetchClusterUpgradeInfoCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch upgrade information of a specific cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   FetchClusterUpgradeInfoRequest request =
   *       FetchClusterUpgradeInfoRequest.newBuilder()
   *           .setName("name3373707")
   *           .setVersion("version351608024")
   *           .build();
   *   ApiFuture<ClusterUpgradeInfo> future =
   *       clusterManagerClient.fetchClusterUpgradeInfoCallable().futureCall(request);
   *   // Do something.
   *   ClusterUpgradeInfo response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchClusterUpgradeInfoRequest, ClusterUpgradeInfo>
      fetchClusterUpgradeInfoCallable() {
    return stub.fetchClusterUpgradeInfoCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch upgrade information of a specific nodepool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   String name = "name3373707";
   *   NodePoolUpgradeInfo response = clusterManagerClient.fetchNodePoolUpgradeInfo(name);
   * }
   * }</pre>
   *
   * @param name Required. The name (project, location, cluster, nodepool) of the nodepool to get.
   *     Specified in the format `projects/&#42;/locations/&#42;/clusters/&#42;/nodePools/&#42;` or
   *     `projects/&#42;/zones/&#42;/clusters/&#42;/nodePools/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodePoolUpgradeInfo fetchNodePoolUpgradeInfo(String name) {
    FetchNodePoolUpgradeInfoRequest request =
        FetchNodePoolUpgradeInfoRequest.newBuilder().setName(name).build();
    return fetchNodePoolUpgradeInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch upgrade information of a specific nodepool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   FetchNodePoolUpgradeInfoRequest request =
   *       FetchNodePoolUpgradeInfoRequest.newBuilder()
   *           .setName("name3373707")
   *           .setVersion("version351608024")
   *           .build();
   *   NodePoolUpgradeInfo response = clusterManagerClient.fetchNodePoolUpgradeInfo(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodePoolUpgradeInfo fetchNodePoolUpgradeInfo(
      FetchNodePoolUpgradeInfoRequest request) {
    return fetchNodePoolUpgradeInfoCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch upgrade information of a specific nodepool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ClusterManagerClient clusterManagerClient = ClusterManagerClient.create()) {
   *   FetchNodePoolUpgradeInfoRequest request =
   *       FetchNodePoolUpgradeInfoRequest.newBuilder()
   *           .setName("name3373707")
   *           .setVersion("version351608024")
   *           .build();
   *   ApiFuture<NodePoolUpgradeInfo> future =
   *       clusterManagerClient.fetchNodePoolUpgradeInfoCallable().futureCall(request);
   *   // Do something.
   *   NodePoolUpgradeInfo response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchNodePoolUpgradeInfoRequest, NodePoolUpgradeInfo>
      fetchNodePoolUpgradeInfoCallable() {
    return stub.fetchNodePoolUpgradeInfoCallable();
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
          input -> new ListUsableSubnetworksPagedResponse(input),
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
