/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.vmwareengine.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vmwareengine.v1.stub.VmwareEngineStub;
import com.google.cloud.vmwareengine.v1.stub.VmwareEngineStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: VMwareEngine manages VMware's private clusters in the Cloud.
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
 * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
 *   PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
 *   PrivateCloud response = vmwareEngineClient.getPrivateCloud(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the VmwareEngineClient object to clean up resources such
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
 *      <td><p> ListPrivateClouds</td>
 *      <td><p> Lists `PrivateCloud` resources in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPrivateClouds(ListPrivateCloudsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPrivateClouds(LocationName parent)
 *           <li><p> listPrivateClouds(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPrivateCloudsPagedCallable()
 *           <li><p> listPrivateCloudsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPrivateCloud</td>
 *      <td><p> Retrieves a `PrivateCloud` resource by its resource name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPrivateCloud(GetPrivateCloudRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPrivateCloud(PrivateCloudName name)
 *           <li><p> getPrivateCloud(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPrivateCloudCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePrivateCloud</td>
 *      <td><p> Creates a new `PrivateCloud` resource in a given project and location. Private clouds of type `STANDARD` and `TIME_LIMITED` are zonal resources, `STRETCHED` private clouds are regional. Creating a private cloud also creates a [management cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components) for that private cloud.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPrivateCloudAsync(CreatePrivateCloudRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createPrivateCloudAsync(LocationName parent, PrivateCloud privateCloud, String privateCloudId)
 *           <li><p> createPrivateCloudAsync(String parent, PrivateCloud privateCloud, String privateCloudId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPrivateCloudOperationCallable()
 *           <li><p> createPrivateCloudCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePrivateCloud</td>
 *      <td><p> Modifies a `PrivateCloud` resource. Only the following fields can be updated: `description`. Only fields specified in `updateMask` are applied.
 * <p>  During operation processing, the resource is temporarily in the `ACTIVE` state before the operation fully completes. For that period of time, you can't update the resource. Use the operation status to determine when the processing fully completes.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePrivateCloudAsync(UpdatePrivateCloudRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updatePrivateCloudAsync(PrivateCloud privateCloud, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePrivateCloudOperationCallable()
 *           <li><p> updatePrivateCloudCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePrivateCloud</td>
 *      <td><p> Schedules a `PrivateCloud` resource for deletion.
 * <p>  A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED` and `expireTime` set to the time when deletion is final and can no longer be reversed. The delete operation is marked as done as soon as the `PrivateCloud` is successfully scheduled for deletion (this also applies when `delayHours` is set to zero), and the operation is not kept in pending state until `PrivateCloud` is purged. `PrivateCloud` can be restored using `UndeletePrivateCloud` method before the `expireTime` elapses. When `expireTime` is reached, deletion is final and all private cloud resources are irreversibly removed and billing stops. During the final removal process, `PrivateCloud.state` is set to `PURGING`. `PrivateCloud` can be polled using standard `GET` method for the whole period of deletion and purging. It will not be returned only when it is completely purged.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePrivateCloudAsync(DeletePrivateCloudRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deletePrivateCloudAsync(PrivateCloudName name)
 *           <li><p> deletePrivateCloudAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePrivateCloudOperationCallable()
 *           <li><p> deletePrivateCloudCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UndeletePrivateCloud</td>
 *      <td><p> Restores a private cloud that was previously scheduled for deletion by `DeletePrivateCloud`. A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED` and `PrivateCloud.expireTime` set to the time when deletion can no longer be reversed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> undeletePrivateCloudAsync(UndeletePrivateCloudRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> undeletePrivateCloudAsync(PrivateCloudName name)
 *           <li><p> undeletePrivateCloudAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> undeletePrivateCloudOperationCallable()
 *           <li><p> undeletePrivateCloudCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListClusters</td>
 *      <td><p> Lists `Cluster` resources in a given private cloud.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listClusters(ListClustersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listClusters(PrivateCloudName parent)
 *           <li><p> listClusters(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listClustersPagedCallable()
 *           <li><p> listClustersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCluster</td>
 *      <td><p> Retrieves a `Cluster` resource by its resource name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCluster(GetClusterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCluster(ClusterName name)
 *           <li><p> getCluster(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCluster</td>
 *      <td><p> Creates a new cluster in a given private cloud. Creating a new cluster provides additional nodes for use in the parent private cloud and requires sufficient [node quota](https://cloud.google.com/vmware-engine/quotas).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createClusterAsync(CreateClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createClusterAsync(PrivateCloudName parent, Cluster cluster, String clusterId)
 *           <li><p> createClusterAsync(String parent, Cluster cluster, String clusterId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createClusterOperationCallable()
 *           <li><p> createClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCluster</td>
 *      <td><p> Modifies a `Cluster` resource. Only fields specified in `updateMask` are applied.
 * <p>  During operation processing, the resource is temporarily in the `ACTIVE` state before the operation fully completes. For that period of time, you can't update the resource. Use the operation status to determine when the processing fully completes.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateClusterAsync(UpdateClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateClusterAsync(Cluster cluster, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateClusterOperationCallable()
 *           <li><p> updateClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCluster</td>
 *      <td><p> Deletes a `Cluster` resource. To avoid unintended data loss, migrate or gracefully shut down any workloads running on the cluster before deletion. You cannot delete the management cluster of a private cloud using this method.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteClusterAsync(DeleteClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteClusterAsync(ClusterName name)
 *           <li><p> deleteClusterAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteClusterOperationCallable()
 *           <li><p> deleteClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNodes</td>
 *      <td><p> Lists nodes in a given cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNodes(ListNodesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNodes(ClusterName parent)
 *           <li><p> listNodes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNodesPagedCallable()
 *           <li><p> listNodesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNode</td>
 *      <td><p> Gets details of a single node.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNode(GetNodeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNode(NodeName name)
 *           <li><p> getNode(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNodeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListExternalAddresses</td>
 *      <td><p> Lists external IP addresses assigned to VMware workload VMs in a given private cloud.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listExternalAddresses(ListExternalAddressesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listExternalAddresses(PrivateCloudName parent)
 *           <li><p> listExternalAddresses(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listExternalAddressesPagedCallable()
 *           <li><p> listExternalAddressesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchNetworkPolicyExternalAddresses</td>
 *      <td><p> Lists external IP addresses assigned to VMware workload VMs within the scope of the given network policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchNetworkPolicyExternalAddresses(FetchNetworkPolicyExternalAddressesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchNetworkPolicyExternalAddresses(NetworkPolicyName networkPolicy)
 *           <li><p> fetchNetworkPolicyExternalAddresses(String networkPolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchNetworkPolicyExternalAddressesPagedCallable()
 *           <li><p> fetchNetworkPolicyExternalAddressesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetExternalAddress</td>
 *      <td><p> Gets details of a single external IP address.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getExternalAddress(GetExternalAddressRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getExternalAddress(ExternalAddressName name)
 *           <li><p> getExternalAddress(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getExternalAddressCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateExternalAddress</td>
 *      <td><p> Creates a new `ExternalAddress` resource in a given private cloud. The network policy that corresponds to the private cloud must have the external IP address network service enabled (`NetworkPolicy.external_ip`).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createExternalAddressAsync(CreateExternalAddressRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createExternalAddressAsync(PrivateCloudName parent, ExternalAddress externalAddress, String externalAddressId)
 *           <li><p> createExternalAddressAsync(String parent, ExternalAddress externalAddress, String externalAddressId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createExternalAddressOperationCallable()
 *           <li><p> createExternalAddressCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateExternalAddress</td>
 *      <td><p> Updates the parameters of a single external IP address. Only fields specified in `update_mask` are applied.
 * <p>  During operation processing, the resource is temporarily in the `ACTIVE` state before the operation fully completes. For that period of time, you can't update the resource. Use the operation status to determine when the processing fully completes.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateExternalAddressAsync(UpdateExternalAddressRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateExternalAddressAsync(ExternalAddress externalAddress, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateExternalAddressOperationCallable()
 *           <li><p> updateExternalAddressCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteExternalAddress</td>
 *      <td><p> Deletes a single external IP address. When you delete an external IP address, connectivity between the external IP address and the corresponding internal IP address is lost.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteExternalAddressAsync(DeleteExternalAddressRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteExternalAddressAsync(ExternalAddressName name)
 *           <li><p> deleteExternalAddressAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteExternalAddressOperationCallable()
 *           <li><p> deleteExternalAddressCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSubnets</td>
 *      <td><p> Lists subnets in a given private cloud.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSubnets(ListSubnetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSubnets(PrivateCloudName parent)
 *           <li><p> listSubnets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSubnetsPagedCallable()
 *           <li><p> listSubnetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSubnet</td>
 *      <td><p> Gets details of a single subnet.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSubnet(GetSubnetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSubnet(SubnetName name)
 *           <li><p> getSubnet(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSubnetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSubnet</td>
 *      <td><p> Updates the parameters of a single subnet. Only fields specified in `update_mask` are applied.
 * <p>  &#42;Note&#42;: This API is synchronous and always returns a successful `google.longrunning.Operation` (LRO). The returned LRO will only have `done` and `response` fields.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSubnetAsync(UpdateSubnetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateSubnetAsync(Subnet subnet, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSubnetOperationCallable()
 *           <li><p> updateSubnetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListExternalAccessRules</td>
 *      <td><p> Lists `ExternalAccessRule` resources in the specified network policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listExternalAccessRules(ListExternalAccessRulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listExternalAccessRules(NetworkPolicyName parent)
 *           <li><p> listExternalAccessRules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listExternalAccessRulesPagedCallable()
 *           <li><p> listExternalAccessRulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetExternalAccessRule</td>
 *      <td><p> Gets details of a single external access rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getExternalAccessRule(GetExternalAccessRuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getExternalAccessRule(ExternalAccessRuleName name)
 *           <li><p> getExternalAccessRule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getExternalAccessRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateExternalAccessRule</td>
 *      <td><p> Creates a new external access rule in a given network policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createExternalAccessRuleAsync(CreateExternalAccessRuleRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createExternalAccessRuleAsync(NetworkPolicyName parent, ExternalAccessRule externalAccessRule, String externalAccessRuleId)
 *           <li><p> createExternalAccessRuleAsync(String parent, ExternalAccessRule externalAccessRule, String externalAccessRuleId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createExternalAccessRuleOperationCallable()
 *           <li><p> createExternalAccessRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateExternalAccessRule</td>
 *      <td><p> Updates the parameters of a single external access rule. Only fields specified in `update_mask` are applied.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateExternalAccessRuleAsync(UpdateExternalAccessRuleRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateExternalAccessRuleAsync(ExternalAccessRule externalAccessRule, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateExternalAccessRuleOperationCallable()
 *           <li><p> updateExternalAccessRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteExternalAccessRule</td>
 *      <td><p> Deletes a single external access rule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteExternalAccessRuleAsync(DeleteExternalAccessRuleRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteExternalAccessRuleAsync(ExternalAccessRuleName name)
 *           <li><p> deleteExternalAccessRuleAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteExternalAccessRuleOperationCallable()
 *           <li><p> deleteExternalAccessRuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLoggingServers</td>
 *      <td><p> Lists logging servers configured for a given private cloud.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLoggingServers(ListLoggingServersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLoggingServers(PrivateCloudName parent)
 *           <li><p> listLoggingServers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLoggingServersPagedCallable()
 *           <li><p> listLoggingServersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLoggingServer</td>
 *      <td><p> Gets details of a logging server.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLoggingServer(GetLoggingServerRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLoggingServer(LoggingServerName name)
 *           <li><p> getLoggingServer(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLoggingServerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateLoggingServer</td>
 *      <td><p> Create a new logging server for a given private cloud.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createLoggingServerAsync(CreateLoggingServerRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createLoggingServerAsync(PrivateCloudName parent, LoggingServer loggingServer, String loggingServerId)
 *           <li><p> createLoggingServerAsync(String parent, LoggingServer loggingServer, String loggingServerId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createLoggingServerOperationCallable()
 *           <li><p> createLoggingServerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateLoggingServer</td>
 *      <td><p> Updates the parameters of a single logging server. Only fields specified in `update_mask` are applied.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateLoggingServerAsync(UpdateLoggingServerRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateLoggingServerAsync(LoggingServer loggingServer, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateLoggingServerOperationCallable()
 *           <li><p> updateLoggingServerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteLoggingServer</td>
 *      <td><p> Deletes a single logging server.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteLoggingServerAsync(DeleteLoggingServerRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteLoggingServerAsync(LoggingServerName name)
 *           <li><p> deleteLoggingServerAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteLoggingServerOperationCallable()
 *           <li><p> deleteLoggingServerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNodeTypes</td>
 *      <td><p> Lists node types</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNodeTypes(ListNodeTypesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNodeTypes(LocationName parent)
 *           <li><p> listNodeTypes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNodeTypesPagedCallable()
 *           <li><p> listNodeTypesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNodeType</td>
 *      <td><p> Gets details of a single `NodeType`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNodeType(GetNodeTypeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNodeType(NodeTypeName name)
 *           <li><p> getNodeType(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNodeTypeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ShowNsxCredentials</td>
 *      <td><p> Gets details of credentials for NSX appliance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> showNsxCredentials(ShowNsxCredentialsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> showNsxCredentials(PrivateCloudName privateCloud)
 *           <li><p> showNsxCredentials(String privateCloud)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> showNsxCredentialsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ShowVcenterCredentials</td>
 *      <td><p> Gets details of credentials for Vcenter appliance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> showVcenterCredentials(ShowVcenterCredentialsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> showVcenterCredentials(PrivateCloudName privateCloud)
 *           <li><p> showVcenterCredentials(String privateCloud)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> showVcenterCredentialsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResetNsxCredentials</td>
 *      <td><p> Resets credentials of the NSX appliance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resetNsxCredentialsAsync(ResetNsxCredentialsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> resetNsxCredentialsAsync(PrivateCloudName privateCloud)
 *           <li><p> resetNsxCredentialsAsync(String privateCloud)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resetNsxCredentialsOperationCallable()
 *           <li><p> resetNsxCredentialsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResetVcenterCredentials</td>
 *      <td><p> Resets credentials of the Vcenter appliance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resetVcenterCredentialsAsync(ResetVcenterCredentialsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> resetVcenterCredentialsAsync(PrivateCloudName privateCloud)
 *           <li><p> resetVcenterCredentialsAsync(String privateCloud)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resetVcenterCredentialsOperationCallable()
 *           <li><p> resetVcenterCredentialsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDnsForwarding</td>
 *      <td><p> Gets details of the `DnsForwarding` config.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDnsForwarding(GetDnsForwardingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDnsForwarding(DnsForwardingName name)
 *           <li><p> getDnsForwarding(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDnsForwardingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDnsForwarding</td>
 *      <td><p> Updates the parameters of the `DnsForwarding` config, like associated domains. Only fields specified in `update_mask` are applied.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDnsForwardingAsync(UpdateDnsForwardingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateDnsForwardingAsync(DnsForwarding dnsForwarding, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDnsForwardingOperationCallable()
 *           <li><p> updateDnsForwardingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNetworkPeering</td>
 *      <td><p> Retrieves a `NetworkPeering` resource by its resource name. The resource contains details of the network peering, such as peered networks, import and export custom route configurations, and peering state. NetworkPeering is a global resource and location can only be global.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNetworkPeering(GetNetworkPeeringRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNetworkPeering(NetworkPeeringName name)
 *           <li><p> getNetworkPeering(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNetworkPeeringCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNetworkPeerings</td>
 *      <td><p> Lists `NetworkPeering` resources in a given project. NetworkPeering is a global resource and location can only be global.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNetworkPeerings(ListNetworkPeeringsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNetworkPeerings(LocationName parent)
 *           <li><p> listNetworkPeerings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNetworkPeeringsPagedCallable()
 *           <li><p> listNetworkPeeringsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateNetworkPeering</td>
 *      <td><p> Creates a new network peering between the peer network and VMware Engine network provided in a `NetworkPeering` resource. NetworkPeering is a global resource and location can only be global.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createNetworkPeeringAsync(CreateNetworkPeeringRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createNetworkPeeringAsync(LocationName parent, NetworkPeering networkPeering, String networkPeeringId)
 *           <li><p> createNetworkPeeringAsync(String parent, NetworkPeering networkPeering, String networkPeeringId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createNetworkPeeringOperationCallable()
 *           <li><p> createNetworkPeeringCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteNetworkPeering</td>
 *      <td><p> Deletes a `NetworkPeering` resource. When a network peering is deleted for a VMware Engine network, the peer network becomes inaccessible to that VMware Engine network. NetworkPeering is a global resource and location can only be global.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteNetworkPeeringAsync(DeleteNetworkPeeringRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteNetworkPeeringAsync(NetworkPeeringName name)
 *           <li><p> deleteNetworkPeeringAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteNetworkPeeringOperationCallable()
 *           <li><p> deleteNetworkPeeringCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateNetworkPeering</td>
 *      <td><p> Modifies a `NetworkPeering` resource. Only the `description` field can be updated. Only fields specified in `updateMask` are applied. NetworkPeering is a global resource and location can only be global.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateNetworkPeeringAsync(UpdateNetworkPeeringRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateNetworkPeeringAsync(NetworkPeering networkPeering, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateNetworkPeeringOperationCallable()
 *           <li><p> updateNetworkPeeringCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPeeringRoutes</td>
 *      <td><p> Lists the network peering routes exchanged over a peering connection. NetworkPeering is a global resource and location can only be global.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPeeringRoutes(ListPeeringRoutesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPeeringRoutes(NetworkPeeringName parent)
 *           <li><p> listPeeringRoutes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPeeringRoutesPagedCallable()
 *           <li><p> listPeeringRoutesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateHcxActivationKey</td>
 *      <td><p> Creates a new HCX activation key in a given private cloud.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createHcxActivationKeyAsync(CreateHcxActivationKeyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createHcxActivationKeyAsync(PrivateCloudName parent, HcxActivationKey hcxActivationKey, String hcxActivationKeyId)
 *           <li><p> createHcxActivationKeyAsync(String parent, HcxActivationKey hcxActivationKey, String hcxActivationKeyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createHcxActivationKeyOperationCallable()
 *           <li><p> createHcxActivationKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListHcxActivationKeys</td>
 *      <td><p> Lists `HcxActivationKey` resources in a given private cloud.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listHcxActivationKeys(ListHcxActivationKeysRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listHcxActivationKeys(PrivateCloudName parent)
 *           <li><p> listHcxActivationKeys(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listHcxActivationKeysPagedCallable()
 *           <li><p> listHcxActivationKeysCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetHcxActivationKey</td>
 *      <td><p> Retrieves a `HcxActivationKey` resource by its resource name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getHcxActivationKey(GetHcxActivationKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getHcxActivationKey(HcxActivationKeyName name)
 *           <li><p> getHcxActivationKey(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getHcxActivationKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNetworkPolicy</td>
 *      <td><p> Retrieves a `NetworkPolicy` resource by its resource name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNetworkPolicy(GetNetworkPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNetworkPolicy(NetworkPolicyName name)
 *           <li><p> getNetworkPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNetworkPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNetworkPolicies</td>
 *      <td><p> Lists `NetworkPolicy` resources in a specified project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNetworkPolicies(ListNetworkPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNetworkPolicies(LocationName parent)
 *           <li><p> listNetworkPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNetworkPoliciesPagedCallable()
 *           <li><p> listNetworkPoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateNetworkPolicy</td>
 *      <td><p> Creates a new network policy in a given VMware Engine network of a project and location (region). A new network policy cannot be created if another network policy already exists in the same scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createNetworkPolicyAsync(CreateNetworkPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createNetworkPolicyAsync(LocationName parent, NetworkPolicy networkPolicy, String networkPolicyId)
 *           <li><p> createNetworkPolicyAsync(String parent, NetworkPolicy networkPolicy, String networkPolicyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createNetworkPolicyOperationCallable()
 *           <li><p> createNetworkPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateNetworkPolicy</td>
 *      <td><p> Modifies a `NetworkPolicy` resource. Only the following fields can be updated: `internet_access`, `external_ip`, `edge_services_cidr`. Only fields specified in `updateMask` are applied. When updating a network policy, the external IP network service can only be disabled if there are no external IP addresses present in the scope of the policy. Also, a `NetworkService` cannot be updated when `NetworkService.state` is set to `RECONCILING`.
 * <p>  During operation processing, the resource is temporarily in the `ACTIVE` state before the operation fully completes. For that period of time, you can't update the resource. Use the operation status to determine when the processing fully completes.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateNetworkPolicyAsync(UpdateNetworkPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateNetworkPolicyAsync(NetworkPolicy networkPolicy, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateNetworkPolicyOperationCallable()
 *           <li><p> updateNetworkPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteNetworkPolicy</td>
 *      <td><p> Deletes a `NetworkPolicy` resource. A network policy cannot be deleted when `NetworkService.state` is set to `RECONCILING` for either its external IP or internet access service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteNetworkPolicyAsync(DeleteNetworkPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteNetworkPolicyAsync(NetworkPolicyName name)
 *           <li><p> deleteNetworkPolicyAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteNetworkPolicyOperationCallable()
 *           <li><p> deleteNetworkPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListManagementDnsZoneBindings</td>
 *      <td><p> Lists Consumer VPCs bound to Management DNS Zone of a given private cloud.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listManagementDnsZoneBindings(ListManagementDnsZoneBindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listManagementDnsZoneBindings(PrivateCloudName parent)
 *           <li><p> listManagementDnsZoneBindings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listManagementDnsZoneBindingsPagedCallable()
 *           <li><p> listManagementDnsZoneBindingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetManagementDnsZoneBinding</td>
 *      <td><p> Retrieves a 'ManagementDnsZoneBinding' resource by its resource name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getManagementDnsZoneBinding(GetManagementDnsZoneBindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getManagementDnsZoneBinding(ManagementDnsZoneBindingName name)
 *           <li><p> getManagementDnsZoneBinding(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getManagementDnsZoneBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateManagementDnsZoneBinding</td>
 *      <td><p> Creates a new `ManagementDnsZoneBinding` resource in a private cloud. This RPC creates the DNS binding and the resource that represents the DNS binding of the consumer VPC network to the management DNS zone. A management DNS zone is the Cloud DNS cross-project binding zone that VMware Engine creates for each private cloud. It contains FQDNs and corresponding IP addresses for the private cloud's ESXi hosts and management VM appliances like vCenter and NSX Manager.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createManagementDnsZoneBindingAsync(CreateManagementDnsZoneBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createManagementDnsZoneBindingAsync(PrivateCloudName parent, ManagementDnsZoneBinding managementDnsZoneBinding, String managementDnsZoneBindingId)
 *           <li><p> createManagementDnsZoneBindingAsync(String parent, ManagementDnsZoneBinding managementDnsZoneBinding, String managementDnsZoneBindingId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createManagementDnsZoneBindingOperationCallable()
 *           <li><p> createManagementDnsZoneBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateManagementDnsZoneBinding</td>
 *      <td><p> Updates a `ManagementDnsZoneBinding` resource. Only fields specified in `update_mask` are applied.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateManagementDnsZoneBindingAsync(UpdateManagementDnsZoneBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateManagementDnsZoneBindingAsync(ManagementDnsZoneBinding managementDnsZoneBinding, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateManagementDnsZoneBindingOperationCallable()
 *           <li><p> updateManagementDnsZoneBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteManagementDnsZoneBinding</td>
 *      <td><p> Deletes a `ManagementDnsZoneBinding` resource. When a management DNS zone binding is deleted, the corresponding consumer VPC network is no longer bound to the management DNS zone.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteManagementDnsZoneBindingAsync(DeleteManagementDnsZoneBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteManagementDnsZoneBindingAsync(ManagementDnsZoneBindingName name)
 *           <li><p> deleteManagementDnsZoneBindingAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteManagementDnsZoneBindingOperationCallable()
 *           <li><p> deleteManagementDnsZoneBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RepairManagementDnsZoneBinding</td>
 *      <td><p> Retries to create a `ManagementDnsZoneBinding` resource that is in failed state.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> repairManagementDnsZoneBindingAsync(RepairManagementDnsZoneBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> repairManagementDnsZoneBindingAsync(ManagementDnsZoneBindingName name)
 *           <li><p> repairManagementDnsZoneBindingAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> repairManagementDnsZoneBindingOperationCallable()
 *           <li><p> repairManagementDnsZoneBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateVmwareEngineNetwork</td>
 *      <td><p> Creates a new VMware Engine network that can be used by a private cloud.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createVmwareEngineNetworkAsync(CreateVmwareEngineNetworkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createVmwareEngineNetworkAsync(LocationName parent, VmwareEngineNetwork vmwareEngineNetwork, String vmwareEngineNetworkId)
 *           <li><p> createVmwareEngineNetworkAsync(String parent, VmwareEngineNetwork vmwareEngineNetwork, String vmwareEngineNetworkId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createVmwareEngineNetworkOperationCallable()
 *           <li><p> createVmwareEngineNetworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateVmwareEngineNetwork</td>
 *      <td><p> Modifies a VMware Engine network resource. Only the following fields can be updated: `description`. Only fields specified in `updateMask` are applied.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateVmwareEngineNetworkAsync(UpdateVmwareEngineNetworkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateVmwareEngineNetworkAsync(VmwareEngineNetwork vmwareEngineNetwork, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateVmwareEngineNetworkOperationCallable()
 *           <li><p> updateVmwareEngineNetworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteVmwareEngineNetwork</td>
 *      <td><p> Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware Engine network after all resources that refer to it are deleted. For example, a private cloud, a network peering, and a network policy can all refer to the same VMware Engine network.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteVmwareEngineNetworkAsync(DeleteVmwareEngineNetworkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteVmwareEngineNetworkAsync(VmwareEngineNetworkName name)
 *           <li><p> deleteVmwareEngineNetworkAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteVmwareEngineNetworkOperationCallable()
 *           <li><p> deleteVmwareEngineNetworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetVmwareEngineNetwork</td>
 *      <td><p> Retrieves a `VmwareEngineNetwork` resource by its resource name. The resource contains details of the VMware Engine network, such as its VMware Engine network type, peered networks in a service project, and state (for example, `CREATING`, `ACTIVE`, `DELETING`).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getVmwareEngineNetwork(GetVmwareEngineNetworkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getVmwareEngineNetwork(VmwareEngineNetworkName name)
 *           <li><p> getVmwareEngineNetwork(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getVmwareEngineNetworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListVmwareEngineNetworks</td>
 *      <td><p> Lists `VmwareEngineNetwork` resources in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listVmwareEngineNetworks(ListVmwareEngineNetworksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listVmwareEngineNetworks(LocationName parent)
 *           <li><p> listVmwareEngineNetworks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listVmwareEngineNetworksPagedCallable()
 *           <li><p> listVmwareEngineNetworksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePrivateConnection</td>
 *      <td><p> Creates a new private connection that can be used for accessing private Clouds.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPrivateConnectionAsync(CreatePrivateConnectionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createPrivateConnectionAsync(LocationName parent, PrivateConnection privateConnection, String privateConnectionId)
 *           <li><p> createPrivateConnectionAsync(String parent, PrivateConnection privateConnection, String privateConnectionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPrivateConnectionOperationCallable()
 *           <li><p> createPrivateConnectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPrivateConnection</td>
 *      <td><p> Retrieves a `PrivateConnection` resource by its resource name. The resource contains details of the private connection, such as connected network, routing mode and state.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPrivateConnection(GetPrivateConnectionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPrivateConnection(PrivateConnectionName name)
 *           <li><p> getPrivateConnection(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPrivateConnectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPrivateConnections</td>
 *      <td><p> Lists `PrivateConnection` resources in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPrivateConnections(ListPrivateConnectionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPrivateConnections(LocationName parent)
 *           <li><p> listPrivateConnections(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPrivateConnectionsPagedCallable()
 *           <li><p> listPrivateConnectionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePrivateConnection</td>
 *      <td><p> Modifies a `PrivateConnection` resource. Only `description` and `routing_mode` fields can be updated. Only fields specified in `updateMask` are applied.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePrivateConnectionAsync(UpdatePrivateConnectionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updatePrivateConnectionAsync(PrivateConnection privateConnection, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePrivateConnectionOperationCallable()
 *           <li><p> updatePrivateConnectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePrivateConnection</td>
 *      <td><p> Deletes a `PrivateConnection` resource. When a private connection is deleted for a VMware Engine network, the connected network becomes inaccessible to that VMware Engine network.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePrivateConnectionAsync(DeletePrivateConnectionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deletePrivateConnectionAsync(PrivateConnectionName name)
 *           <li><p> deletePrivateConnectionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePrivateConnectionOperationCallable()
 *           <li><p> deletePrivateConnectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPrivateConnectionPeeringRoutes</td>
 *      <td><p> Lists the private connection routes exchanged over a peering connection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPrivateConnectionPeeringRoutes(ListPrivateConnectionPeeringRoutesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPrivateConnectionPeeringRoutes(PrivateConnectionName parent)
 *           <li><p> listPrivateConnectionPeeringRoutes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPrivateConnectionPeeringRoutesPagedCallable()
 *           <li><p> listPrivateConnectionPeeringRoutesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GrantDnsBindPermission</td>
 *      <td><p> Grants the bind permission to the customer provided principal(user / service account) to bind their DNS zone with the intranet VPC associated with the project. DnsBindPermission is a global resource and location can only be global.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> grantDnsBindPermissionAsync(GrantDnsBindPermissionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> grantDnsBindPermissionAsync(DnsBindPermissionName name, Principal principal)
 *           <li><p> grantDnsBindPermissionAsync(String name, Principal principal)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> grantDnsBindPermissionOperationCallable()
 *           <li><p> grantDnsBindPermissionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDnsBindPermission</td>
 *      <td><p> Gets all the principals having bind permission on the intranet VPC associated with the consumer project granted by the Grant API. DnsBindPermission is a global resource and location can only be global.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDnsBindPermission(GetDnsBindPermissionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDnsBindPermission(DnsBindPermissionName name)
 *           <li><p> getDnsBindPermission(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDnsBindPermissionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RevokeDnsBindPermission</td>
 *      <td><p> Revokes the bind permission from the customer provided principal(user / service account) on the intranet VPC associated with the consumer project. DnsBindPermission is a global resource and location can only be global.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> revokeDnsBindPermissionAsync(RevokeDnsBindPermissionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> revokeDnsBindPermissionAsync(DnsBindPermissionName name, Principal principal)
 *           <li><p> revokeDnsBindPermissionAsync(String name, Principal principal)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> revokeDnsBindPermissionOperationCallable()
 *           <li><p> revokeDnsBindPermissionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of VmwareEngineSettings to
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
 * VmwareEngineSettings vmwareEngineSettings =
 *     VmwareEngineSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create(vmwareEngineSettings);
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
 * VmwareEngineSettings vmwareEngineSettings =
 *     VmwareEngineSettings.newBuilder().setEndpoint(myEndpoint).build();
 * VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create(vmwareEngineSettings);
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
 * VmwareEngineSettings vmwareEngineSettings = VmwareEngineSettings.newHttpJsonBuilder().build();
 * VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create(vmwareEngineSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class VmwareEngineClient implements BackgroundResource {
  private final VmwareEngineSettings settings;
  private final VmwareEngineStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of VmwareEngineClient with default settings. */
  public static final VmwareEngineClient create() throws IOException {
    return create(VmwareEngineSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of VmwareEngineClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final VmwareEngineClient create(VmwareEngineSettings settings) throws IOException {
    return new VmwareEngineClient(settings);
  }

  /**
   * Constructs an instance of VmwareEngineClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(VmwareEngineSettings).
   */
  public static final VmwareEngineClient create(VmwareEngineStub stub) {
    return new VmwareEngineClient(stub);
  }

  /**
   * Constructs an instance of VmwareEngineClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected VmwareEngineClient(VmwareEngineSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((VmwareEngineStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected VmwareEngineClient(VmwareEngineStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final VmwareEngineSettings getSettings() {
    return settings;
  }

  public VmwareEngineStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `PrivateCloud` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (PrivateCloud element : vmwareEngineClient.listPrivateClouds(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for clusters.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateCloudsPagedResponse listPrivateClouds(LocationName parent) {
    ListPrivateCloudsRequest request =
        ListPrivateCloudsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPrivateClouds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `PrivateCloud` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (PrivateCloud element : vmwareEngineClient.listPrivateClouds(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for clusters.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateCloudsPagedResponse listPrivateClouds(String parent) {
    ListPrivateCloudsRequest request =
        ListPrivateCloudsRequest.newBuilder().setParent(parent).build();
    return listPrivateClouds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `PrivateCloud` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListPrivateCloudsRequest request =
   *       ListPrivateCloudsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (PrivateCloud element : vmwareEngineClient.listPrivateClouds(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateCloudsPagedResponse listPrivateClouds(ListPrivateCloudsRequest request) {
    return listPrivateCloudsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `PrivateCloud` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListPrivateCloudsRequest request =
   *       ListPrivateCloudsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<PrivateCloud> future =
   *       vmwareEngineClient.listPrivateCloudsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PrivateCloud element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPrivateCloudsRequest, ListPrivateCloudsPagedResponse>
      listPrivateCloudsPagedCallable() {
    return stub.listPrivateCloudsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `PrivateCloud` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListPrivateCloudsRequest request =
   *       ListPrivateCloudsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListPrivateCloudsResponse response =
   *         vmwareEngineClient.listPrivateCloudsCallable().call(request);
   *     for (PrivateCloud element : response.getPrivateCloudsList()) {
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
  public final UnaryCallable<ListPrivateCloudsRequest, ListPrivateCloudsResponse>
      listPrivateCloudsCallable() {
    return stub.listPrivateCloudsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `PrivateCloud` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   PrivateCloud response = vmwareEngineClient.getPrivateCloud(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the private cloud to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateCloud getPrivateCloud(PrivateCloudName name) {
    GetPrivateCloudRequest request =
        GetPrivateCloudRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPrivateCloud(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `PrivateCloud` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   PrivateCloud response = vmwareEngineClient.getPrivateCloud(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the private cloud to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateCloud getPrivateCloud(String name) {
    GetPrivateCloudRequest request = GetPrivateCloudRequest.newBuilder().setName(name).build();
    return getPrivateCloud(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `PrivateCloud` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetPrivateCloudRequest request =
   *       GetPrivateCloudRequest.newBuilder()
   *           .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .build();
   *   PrivateCloud response = vmwareEngineClient.getPrivateCloud(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateCloud getPrivateCloud(GetPrivateCloudRequest request) {
    return getPrivateCloudCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `PrivateCloud` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetPrivateCloudRequest request =
   *       GetPrivateCloudRequest.newBuilder()
   *           .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .build();
   *   ApiFuture<PrivateCloud> future =
   *       vmwareEngineClient.getPrivateCloudCallable().futureCall(request);
   *   // Do something.
   *   PrivateCloud response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPrivateCloudRequest, PrivateCloud> getPrivateCloudCallable() {
    return stub.getPrivateCloudCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `PrivateCloud` resource in a given project and location. Private clouds of type
   * `STANDARD` and `TIME_LIMITED` are zonal resources, `STRETCHED` private clouds are regional.
   * Creating a private cloud also creates a [management
   * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components) for that
   * private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   PrivateCloud privateCloud = PrivateCloud.newBuilder().build();
   *   String privateCloudId = "privateCloudId573896493";
   *   PrivateCloud response =
   *       vmwareEngineClient.createPrivateCloudAsync(parent, privateCloud, privateCloudId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to create the new private cloud in.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a`
   * @param privateCloud Required. The initial description of the new private cloud.
   * @param privateCloudId Required. The user-provided identifier of the private cloud to be
   *     created. This identifier must be unique among each `PrivateCloud` within the parent and
   *     becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> createPrivateCloudAsync(
      LocationName parent, PrivateCloud privateCloud, String privateCloudId) {
    CreatePrivateCloudRequest request =
        CreatePrivateCloudRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPrivateCloud(privateCloud)
            .setPrivateCloudId(privateCloudId)
            .build();
    return createPrivateCloudAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `PrivateCloud` resource in a given project and location. Private clouds of type
   * `STANDARD` and `TIME_LIMITED` are zonal resources, `STRETCHED` private clouds are regional.
   * Creating a private cloud also creates a [management
   * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components) for that
   * private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   PrivateCloud privateCloud = PrivateCloud.newBuilder().build();
   *   String privateCloudId = "privateCloudId573896493";
   *   PrivateCloud response =
   *       vmwareEngineClient.createPrivateCloudAsync(parent, privateCloud, privateCloudId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to create the new private cloud in.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a`
   * @param privateCloud Required. The initial description of the new private cloud.
   * @param privateCloudId Required. The user-provided identifier of the private cloud to be
   *     created. This identifier must be unique among each `PrivateCloud` within the parent and
   *     becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> createPrivateCloudAsync(
      String parent, PrivateCloud privateCloud, String privateCloudId) {
    CreatePrivateCloudRequest request =
        CreatePrivateCloudRequest.newBuilder()
            .setParent(parent)
            .setPrivateCloud(privateCloud)
            .setPrivateCloudId(privateCloudId)
            .build();
    return createPrivateCloudAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `PrivateCloud` resource in a given project and location. Private clouds of type
   * `STANDARD` and `TIME_LIMITED` are zonal resources, `STRETCHED` private clouds are regional.
   * Creating a private cloud also creates a [management
   * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components) for that
   * private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreatePrivateCloudRequest request =
   *       CreatePrivateCloudRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrivateCloudId("privateCloudId573896493")
   *           .setPrivateCloud(PrivateCloud.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   PrivateCloud response = vmwareEngineClient.createPrivateCloudAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> createPrivateCloudAsync(
      CreatePrivateCloudRequest request) {
    return createPrivateCloudOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `PrivateCloud` resource in a given project and location. Private clouds of type
   * `STANDARD` and `TIME_LIMITED` are zonal resources, `STRETCHED` private clouds are regional.
   * Creating a private cloud also creates a [management
   * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components) for that
   * private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreatePrivateCloudRequest request =
   *       CreatePrivateCloudRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrivateCloudId("privateCloudId573896493")
   *           .setPrivateCloud(PrivateCloud.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<PrivateCloud, OperationMetadata> future =
   *       vmwareEngineClient.createPrivateCloudOperationCallable().futureCall(request);
   *   // Do something.
   *   PrivateCloud response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      createPrivateCloudOperationCallable() {
    return stub.createPrivateCloudOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `PrivateCloud` resource in a given project and location. Private clouds of type
   * `STANDARD` and `TIME_LIMITED` are zonal resources, `STRETCHED` private clouds are regional.
   * Creating a private cloud also creates a [management
   * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components) for that
   * private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreatePrivateCloudRequest request =
   *       CreatePrivateCloudRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrivateCloudId("privateCloudId573896493")
   *           .setPrivateCloud(PrivateCloud.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.createPrivateCloudCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePrivateCloudRequest, Operation> createPrivateCloudCallable() {
    return stub.createPrivateCloudCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `PrivateCloud` resource. Only the following fields can be updated: `description`.
   * Only fields specified in `updateMask` are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloud privateCloud = PrivateCloud.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PrivateCloud response =
   *       vmwareEngineClient.updatePrivateCloudAsync(privateCloud, updateMask).get();
   * }
   * }</pre>
   *
   * @param privateCloud Required. Private cloud description.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `PrivateCloud` resource by the update. The fields specified in `updateMask` are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> updatePrivateCloudAsync(
      PrivateCloud privateCloud, FieldMask updateMask) {
    UpdatePrivateCloudRequest request =
        UpdatePrivateCloudRequest.newBuilder()
            .setPrivateCloud(privateCloud)
            .setUpdateMask(updateMask)
            .build();
    return updatePrivateCloudAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `PrivateCloud` resource. Only the following fields can be updated: `description`.
   * Only fields specified in `updateMask` are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdatePrivateCloudRequest request =
   *       UpdatePrivateCloudRequest.newBuilder()
   *           .setPrivateCloud(PrivateCloud.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   PrivateCloud response = vmwareEngineClient.updatePrivateCloudAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> updatePrivateCloudAsync(
      UpdatePrivateCloudRequest request) {
    return updatePrivateCloudOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `PrivateCloud` resource. Only the following fields can be updated: `description`.
   * Only fields specified in `updateMask` are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdatePrivateCloudRequest request =
   *       UpdatePrivateCloudRequest.newBuilder()
   *           .setPrivateCloud(PrivateCloud.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<PrivateCloud, OperationMetadata> future =
   *       vmwareEngineClient.updatePrivateCloudOperationCallable().futureCall(request);
   *   // Do something.
   *   PrivateCloud response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      updatePrivateCloudOperationCallable() {
    return stub.updatePrivateCloudOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `PrivateCloud` resource. Only the following fields can be updated: `description`.
   * Only fields specified in `updateMask` are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdatePrivateCloudRequest request =
   *       UpdatePrivateCloudRequest.newBuilder()
   *           .setPrivateCloud(PrivateCloud.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.updatePrivateCloudCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePrivateCloudRequest, Operation> updatePrivateCloudCallable() {
    return stub.updatePrivateCloudCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedules a `PrivateCloud` resource for deletion.
   *
   * <p>A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED`
   * and `expireTime` set to the time when deletion is final and can no longer be reversed. The
   * delete operation is marked as done as soon as the `PrivateCloud` is successfully scheduled for
   * deletion (this also applies when `delayHours` is set to zero), and the operation is not kept in
   * pending state until `PrivateCloud` is purged. `PrivateCloud` can be restored using
   * `UndeletePrivateCloud` method before the `expireTime` elapses. When `expireTime` is reached,
   * deletion is final and all private cloud resources are irreversibly removed and billing stops.
   * During the final removal process, `PrivateCloud.state` is set to `PURGING`. `PrivateCloud` can
   * be polled using standard `GET` method for the whole period of deletion and purging. It will not
   * be returned only when it is completely purged.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   PrivateCloud response = vmwareEngineClient.deletePrivateCloudAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the private cloud to delete. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> deletePrivateCloudAsync(
      PrivateCloudName name) {
    DeletePrivateCloudRequest request =
        DeletePrivateCloudRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deletePrivateCloudAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedules a `PrivateCloud` resource for deletion.
   *
   * <p>A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED`
   * and `expireTime` set to the time when deletion is final and can no longer be reversed. The
   * delete operation is marked as done as soon as the `PrivateCloud` is successfully scheduled for
   * deletion (this also applies when `delayHours` is set to zero), and the operation is not kept in
   * pending state until `PrivateCloud` is purged. `PrivateCloud` can be restored using
   * `UndeletePrivateCloud` method before the `expireTime` elapses. When `expireTime` is reached,
   * deletion is final and all private cloud resources are irreversibly removed and billing stops.
   * During the final removal process, `PrivateCloud.state` is set to `PURGING`. `PrivateCloud` can
   * be polled using standard `GET` method for the whole period of deletion and purging. It will not
   * be returned only when it is completely purged.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   PrivateCloud response = vmwareEngineClient.deletePrivateCloudAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the private cloud to delete. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> deletePrivateCloudAsync(
      String name) {
    DeletePrivateCloudRequest request =
        DeletePrivateCloudRequest.newBuilder().setName(name).build();
    return deletePrivateCloudAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedules a `PrivateCloud` resource for deletion.
   *
   * <p>A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED`
   * and `expireTime` set to the time when deletion is final and can no longer be reversed. The
   * delete operation is marked as done as soon as the `PrivateCloud` is successfully scheduled for
   * deletion (this also applies when `delayHours` is set to zero), and the operation is not kept in
   * pending state until `PrivateCloud` is purged. `PrivateCloud` can be restored using
   * `UndeletePrivateCloud` method before the `expireTime` elapses. When `expireTime` is reached,
   * deletion is final and all private cloud resources are irreversibly removed and billing stops.
   * During the final removal process, `PrivateCloud.state` is set to `PURGING`. `PrivateCloud` can
   * be polled using standard `GET` method for the whole period of deletion and purging. It will not
   * be returned only when it is completely purged.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeletePrivateCloudRequest request =
   *       DeletePrivateCloudRequest.newBuilder()
   *           .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .setDelayHours(475821395)
   *           .build();
   *   PrivateCloud response = vmwareEngineClient.deletePrivateCloudAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> deletePrivateCloudAsync(
      DeletePrivateCloudRequest request) {
    return deletePrivateCloudOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedules a `PrivateCloud` resource for deletion.
   *
   * <p>A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED`
   * and `expireTime` set to the time when deletion is final and can no longer be reversed. The
   * delete operation is marked as done as soon as the `PrivateCloud` is successfully scheduled for
   * deletion (this also applies when `delayHours` is set to zero), and the operation is not kept in
   * pending state until `PrivateCloud` is purged. `PrivateCloud` can be restored using
   * `UndeletePrivateCloud` method before the `expireTime` elapses. When `expireTime` is reached,
   * deletion is final and all private cloud resources are irreversibly removed and billing stops.
   * During the final removal process, `PrivateCloud.state` is set to `PURGING`. `PrivateCloud` can
   * be polled using standard `GET` method for the whole period of deletion and purging. It will not
   * be returned only when it is completely purged.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeletePrivateCloudRequest request =
   *       DeletePrivateCloudRequest.newBuilder()
   *           .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .setDelayHours(475821395)
   *           .build();
   *   OperationFuture<PrivateCloud, OperationMetadata> future =
   *       vmwareEngineClient.deletePrivateCloudOperationCallable().futureCall(request);
   *   // Do something.
   *   PrivateCloud response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      deletePrivateCloudOperationCallable() {
    return stub.deletePrivateCloudOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedules a `PrivateCloud` resource for deletion.
   *
   * <p>A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED`
   * and `expireTime` set to the time when deletion is final and can no longer be reversed. The
   * delete operation is marked as done as soon as the `PrivateCloud` is successfully scheduled for
   * deletion (this also applies when `delayHours` is set to zero), and the operation is not kept in
   * pending state until `PrivateCloud` is purged. `PrivateCloud` can be restored using
   * `UndeletePrivateCloud` method before the `expireTime` elapses. When `expireTime` is reached,
   * deletion is final and all private cloud resources are irreversibly removed and billing stops.
   * During the final removal process, `PrivateCloud.state` is set to `PURGING`. `PrivateCloud` can
   * be polled using standard `GET` method for the whole period of deletion and purging. It will not
   * be returned only when it is completely purged.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeletePrivateCloudRequest request =
   *       DeletePrivateCloudRequest.newBuilder()
   *           .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .setDelayHours(475821395)
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.deletePrivateCloudCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePrivateCloudRequest, Operation> deletePrivateCloudCallable() {
    return stub.deletePrivateCloudCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a private cloud that was previously scheduled for deletion by `DeletePrivateCloud`. A
   * `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED` and
   * `PrivateCloud.expireTime` set to the time when deletion can no longer be reversed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   PrivateCloud response = vmwareEngineClient.undeletePrivateCloudAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the private cloud scheduled for deletion. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> undeletePrivateCloudAsync(
      PrivateCloudName name) {
    UndeletePrivateCloudRequest request =
        UndeletePrivateCloudRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return undeletePrivateCloudAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a private cloud that was previously scheduled for deletion by `DeletePrivateCloud`. A
   * `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED` and
   * `PrivateCloud.expireTime` set to the time when deletion can no longer be reversed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   PrivateCloud response = vmwareEngineClient.undeletePrivateCloudAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the private cloud scheduled for deletion. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> undeletePrivateCloudAsync(
      String name) {
    UndeletePrivateCloudRequest request =
        UndeletePrivateCloudRequest.newBuilder().setName(name).build();
    return undeletePrivateCloudAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a private cloud that was previously scheduled for deletion by `DeletePrivateCloud`. A
   * `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED` and
   * `PrivateCloud.expireTime` set to the time when deletion can no longer be reversed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UndeletePrivateCloudRequest request =
   *       UndeletePrivateCloudRequest.newBuilder()
   *           .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   PrivateCloud response = vmwareEngineClient.undeletePrivateCloudAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> undeletePrivateCloudAsync(
      UndeletePrivateCloudRequest request) {
    return undeletePrivateCloudOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a private cloud that was previously scheduled for deletion by `DeletePrivateCloud`. A
   * `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED` and
   * `PrivateCloud.expireTime` set to the time when deletion can no longer be reversed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UndeletePrivateCloudRequest request =
   *       UndeletePrivateCloudRequest.newBuilder()
   *           .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<PrivateCloud, OperationMetadata> future =
   *       vmwareEngineClient.undeletePrivateCloudOperationCallable().futureCall(request);
   *   // Do something.
   *   PrivateCloud response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      undeletePrivateCloudOperationCallable() {
    return stub.undeletePrivateCloudOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a private cloud that was previously scheduled for deletion by `DeletePrivateCloud`. A
   * `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED` and
   * `PrivateCloud.expireTime` set to the time when deletion can no longer be reversed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UndeletePrivateCloudRequest request =
   *       UndeletePrivateCloudRequest.newBuilder()
   *           .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.undeletePrivateCloudCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeletePrivateCloudRequest, Operation>
      undeletePrivateCloudCallable() {
    return stub.undeletePrivateCloudCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Cluster` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   for (Cluster element : vmwareEngineClient.listClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to query for clusters. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(PrivateCloudName parent) {
    ListClustersRequest request =
        ListClustersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Cluster` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   for (Cluster element : vmwareEngineClient.listClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to query for clusters. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(String parent) {
    ListClustersRequest request = ListClustersRequest.newBuilder().setParent(parent).build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Cluster` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Cluster element : vmwareEngineClient.listClusters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(ListClustersRequest request) {
    return listClustersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Cluster` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Cluster> future =
   *       vmwareEngineClient.listClustersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Cluster element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListClustersRequest, ListClustersPagedResponse>
      listClustersPagedCallable() {
    return stub.listClustersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Cluster` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListClustersResponse response = vmwareEngineClient.listClustersCallable().call(request);
   *     for (Cluster element : response.getClustersList()) {
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
  public final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return stub.listClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Cluster` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]");
   *   Cluster response = vmwareEngineClient.getCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The cluster resource name to retrieve. Resource names are schemeless URIs
   *     that follow the conventions in https://cloud.google.com/apis/design/resource_names. For
   *     example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/clusters/my-cluster`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(ClusterName name) {
    GetClusterRequest request =
        GetClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Cluster` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]").toString();
   *   Cluster response = vmwareEngineClient.getCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The cluster resource name to retrieve. Resource names are schemeless URIs
   *     that follow the conventions in https://cloud.google.com/apis/design/resource_names. For
   *     example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/clusters/my-cluster`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(String name) {
    GetClusterRequest request = GetClusterRequest.newBuilder().setName(name).build();
    return getCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Cluster` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetClusterRequest request =
   *       GetClusterRequest.newBuilder()
   *           .setName(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .build();
   *   Cluster response = vmwareEngineClient.getCluster(request);
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
   * Retrieves a `Cluster` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetClusterRequest request =
   *       GetClusterRequest.newBuilder()
   *           .setName(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Cluster> future = vmwareEngineClient.getClusterCallable().futureCall(request);
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
   * Creates a new cluster in a given private cloud. Creating a new cluster provides additional
   * nodes for use in the parent private cloud and requires sufficient [node
   * quota](https://cloud.google.com/vmware-engine/quotas).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   Cluster cluster = Cluster.newBuilder().build();
   *   String clusterId = "clusterId561939637";
   *   Cluster response = vmwareEngineClient.createClusterAsync(parent, cluster, clusterId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to create a new cluster in.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @param cluster Required. The initial description of the new cluster.
   * @param clusterId Required. The user-provided identifier of the new `Cluster`. This identifier
   *     must be unique among clusters within the parent and becomes the final token in the name
   *     URI. The identifier must meet the following requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, OperationMetadata> createClusterAsync(
      PrivateCloudName parent, Cluster cluster, String clusterId) {
    CreateClusterRequest request =
        CreateClusterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCluster(cluster)
            .setClusterId(clusterId)
            .build();
    return createClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new cluster in a given private cloud. Creating a new cluster provides additional
   * nodes for use in the parent private cloud and requires sufficient [node
   * quota](https://cloud.google.com/vmware-engine/quotas).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   Cluster cluster = Cluster.newBuilder().build();
   *   String clusterId = "clusterId561939637";
   *   Cluster response = vmwareEngineClient.createClusterAsync(parent, cluster, clusterId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to create a new cluster in.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @param cluster Required. The initial description of the new cluster.
   * @param clusterId Required. The user-provided identifier of the new `Cluster`. This identifier
   *     must be unique among clusters within the parent and becomes the final token in the name
   *     URI. The identifier must meet the following requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, OperationMetadata> createClusterAsync(
      String parent, Cluster cluster, String clusterId) {
    CreateClusterRequest request =
        CreateClusterRequest.newBuilder()
            .setParent(parent)
            .setCluster(cluster)
            .setClusterId(clusterId)
            .build();
    return createClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new cluster in a given private cloud. Creating a new cluster provides additional
   * nodes for use in the parent private cloud and requires sufficient [node
   * quota](https://cloud.google.com/vmware-engine/quotas).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   Cluster response = vmwareEngineClient.createClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, OperationMetadata> createClusterAsync(
      CreateClusterRequest request) {
    return createClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new cluster in a given private cloud. Creating a new cluster provides additional
   * nodes for use in the parent private cloud and requires sufficient [node
   * quota](https://cloud.google.com/vmware-engine/quotas).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Cluster, OperationMetadata> future =
   *       vmwareEngineClient.createClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationCallable() {
    return stub.createClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new cluster in a given private cloud. Creating a new cluster provides additional
   * nodes for use in the parent private cloud and requires sufficient [node
   * quota](https://cloud.google.com/vmware-engine/quotas).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = vmwareEngineClient.createClusterCallable().futureCall(request);
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
   * Modifies a `Cluster` resource. Only fields specified in `updateMask` are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   Cluster cluster = Cluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Cluster response = vmwareEngineClient.updateClusterAsync(cluster, updateMask).get();
   * }
   * }</pre>
   *
   * @param cluster Required. The description of the cluster.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `Cluster` resource by the update. The fields specified in the `updateMask` are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, OperationMetadata> updateClusterAsync(
      Cluster cluster, FieldMask updateMask) {
    UpdateClusterRequest request =
        UpdateClusterRequest.newBuilder().setCluster(cluster).setUpdateMask(updateMask).build();
    return updateClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `Cluster` resource. Only fields specified in `updateMask` are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   Cluster response = vmwareEngineClient.updateClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, OperationMetadata> updateClusterAsync(
      UpdateClusterRequest request) {
    return updateClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `Cluster` resource. Only fields specified in `updateMask` are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Cluster, OperationMetadata> future =
   *       vmwareEngineClient.updateClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationCallable() {
    return stub.updateClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `Cluster` resource. Only fields specified in `updateMask` are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = vmwareEngineClient.updateClusterCallable().futureCall(request);
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
   * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or gracefully shut down
   * any workloads running on the cluster before deletion. You cannot delete the management cluster
   * of a private cloud using this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]");
   *   vmwareEngineClient.deleteClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the cluster to delete. Resource names are schemeless
   *     URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names.
   *     For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/clusters/my-cluster`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteClusterAsync(ClusterName name) {
    DeleteClusterRequest request =
        DeleteClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or gracefully shut down
   * any workloads running on the cluster before deletion. You cannot delete the management cluster
   * of a private cloud using this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]").toString();
   *   vmwareEngineClient.deleteClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the cluster to delete. Resource names are schemeless
   *     URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names.
   *     For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/clusters/my-cluster`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteClusterAsync(String name) {
    DeleteClusterRequest request = DeleteClusterRequest.newBuilder().setName(name).build();
    return deleteClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or gracefully shut down
   * any workloads running on the cluster before deletion. You cannot delete the management cluster
   * of a private cloud using this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setName(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmwareEngineClient.deleteClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteClusterAsync(
      DeleteClusterRequest request) {
    return deleteClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or gracefully shut down
   * any workloads running on the cluster before deletion. You cannot delete the management cluster
   * of a private cloud using this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setName(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmwareEngineClient.deleteClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationCallable() {
    return stub.deleteClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or gracefully shut down
   * any workloads running on the cluster before deletion. You cannot delete the management cluster
   * of a private cloud using this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setName(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = vmwareEngineClient.deleteClusterCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return stub.deleteClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists nodes in a given cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ClusterName parent =
   *       ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]");
   *   for (Node element : vmwareEngineClient.listNodes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the cluster to be queried for nodes. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/clusters/my-cluster`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodesPagedResponse listNodes(ClusterName parent) {
    ListNodesRequest request =
        ListNodesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listNodes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists nodes in a given cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent =
   *       ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]").toString();
   *   for (Node element : vmwareEngineClient.listNodes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the cluster to be queried for nodes. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/clusters/my-cluster`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodesPagedResponse listNodes(String parent) {
    ListNodesRequest request = ListNodesRequest.newBuilder().setParent(parent).build();
    return listNodes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists nodes in a given cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNodesRequest request =
   *       ListNodesRequest.newBuilder()
   *           .setParent(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Node element : vmwareEngineClient.listNodes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodesPagedResponse listNodes(ListNodesRequest request) {
    return listNodesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists nodes in a given cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNodesRequest request =
   *       ListNodesRequest.newBuilder()
   *           .setParent(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Node> future = vmwareEngineClient.listNodesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Node element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNodesRequest, ListNodesPagedResponse> listNodesPagedCallable() {
    return stub.listNodesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists nodes in a given cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNodesRequest request =
   *       ListNodesRequest.newBuilder()
   *           .setParent(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListNodesResponse response = vmwareEngineClient.listNodesCallable().call(request);
   *     for (Node element : response.getNodesList()) {
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
  public final UnaryCallable<ListNodesRequest, ListNodesResponse> listNodesCallable() {
    return stub.listNodesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   NodeName name =
   *       NodeName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]", "[NODE]");
   *   Node response = vmwareEngineClient.getNode(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the node to retrieve. For example:
   *     `projects/{project}/locations/{location}/privateClouds/{private_cloud}/clusters/{cluster}/nodes/{node}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Node getNode(NodeName name) {
    GetNodeRequest request =
        GetNodeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getNode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       NodeName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]", "[NODE]")
   *           .toString();
   *   Node response = vmwareEngineClient.getNode(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the node to retrieve. For example:
   *     `projects/{project}/locations/{location}/privateClouds/{private_cloud}/clusters/{cluster}/nodes/{node}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Node getNode(String name) {
    GetNodeRequest request = GetNodeRequest.newBuilder().setName(name).build();
    return getNode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetNodeRequest request =
   *       GetNodeRequest.newBuilder()
   *           .setName(
   *               NodeName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]", "[NODE]")
   *                   .toString())
   *           .build();
   *   Node response = vmwareEngineClient.getNode(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Node getNode(GetNodeRequest request) {
    return getNodeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single node.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetNodeRequest request =
   *       GetNodeRequest.newBuilder()
   *           .setName(
   *               NodeName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]", "[NODE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Node> future = vmwareEngineClient.getNodeCallable().futureCall(request);
   *   // Do something.
   *   Node response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNodeRequest, Node> getNodeCallable() {
    return stub.getNodeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists external IP addresses assigned to VMware workload VMs in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   for (ExternalAddress element :
   *       vmwareEngineClient.listExternalAddresses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for external IP
   *     addresses. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExternalAddressesPagedResponse listExternalAddresses(PrivateCloudName parent) {
    ListExternalAddressesRequest request =
        ListExternalAddressesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExternalAddresses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists external IP addresses assigned to VMware workload VMs in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   for (ExternalAddress element :
   *       vmwareEngineClient.listExternalAddresses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for external IP
   *     addresses. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExternalAddressesPagedResponse listExternalAddresses(String parent) {
    ListExternalAddressesRequest request =
        ListExternalAddressesRequest.newBuilder().setParent(parent).build();
    return listExternalAddresses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists external IP addresses assigned to VMware workload VMs in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListExternalAddressesRequest request =
   *       ListExternalAddressesRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ExternalAddress element :
   *       vmwareEngineClient.listExternalAddresses(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExternalAddressesPagedResponse listExternalAddresses(
      ListExternalAddressesRequest request) {
    return listExternalAddressesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists external IP addresses assigned to VMware workload VMs in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListExternalAddressesRequest request =
   *       ListExternalAddressesRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ExternalAddress> future =
   *       vmwareEngineClient.listExternalAddressesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ExternalAddress element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListExternalAddressesRequest, ListExternalAddressesPagedResponse>
      listExternalAddressesPagedCallable() {
    return stub.listExternalAddressesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists external IP addresses assigned to VMware workload VMs in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListExternalAddressesRequest request =
   *       ListExternalAddressesRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListExternalAddressesResponse response =
   *         vmwareEngineClient.listExternalAddressesCallable().call(request);
   *     for (ExternalAddress element : response.getExternalAddressesList()) {
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
  public final UnaryCallable<ListExternalAddressesRequest, ListExternalAddressesResponse>
      listExternalAddressesCallable() {
    return stub.listExternalAddressesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists external IP addresses assigned to VMware workload VMs within the scope of the given
   * network policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   NetworkPolicyName networkPolicy =
   *       NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");
   *   for (ExternalAddress element :
   *       vmwareEngineClient.fetchNetworkPolicyExternalAddresses(networkPolicy).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param networkPolicy Required. The resource name of the network policy to query for assigned
   *     external IP addresses. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-policy`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchNetworkPolicyExternalAddressesPagedResponse fetchNetworkPolicyExternalAddresses(
      NetworkPolicyName networkPolicy) {
    FetchNetworkPolicyExternalAddressesRequest request =
        FetchNetworkPolicyExternalAddressesRequest.newBuilder()
            .setNetworkPolicy(networkPolicy == null ? null : networkPolicy.toString())
            .build();
    return fetchNetworkPolicyExternalAddresses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists external IP addresses assigned to VMware workload VMs within the scope of the given
   * network policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String networkPolicy =
   *       NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString();
   *   for (ExternalAddress element :
   *       vmwareEngineClient.fetchNetworkPolicyExternalAddresses(networkPolicy).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param networkPolicy Required. The resource name of the network policy to query for assigned
   *     external IP addresses. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-policy`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchNetworkPolicyExternalAddressesPagedResponse fetchNetworkPolicyExternalAddresses(
      String networkPolicy) {
    FetchNetworkPolicyExternalAddressesRequest request =
        FetchNetworkPolicyExternalAddressesRequest.newBuilder()
            .setNetworkPolicy(networkPolicy)
            .build();
    return fetchNetworkPolicyExternalAddresses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists external IP addresses assigned to VMware workload VMs within the scope of the given
   * network policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   FetchNetworkPolicyExternalAddressesRequest request =
   *       FetchNetworkPolicyExternalAddressesRequest.newBuilder()
   *           .setNetworkPolicy(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ExternalAddress element :
   *       vmwareEngineClient.fetchNetworkPolicyExternalAddresses(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchNetworkPolicyExternalAddressesPagedResponse fetchNetworkPolicyExternalAddresses(
      FetchNetworkPolicyExternalAddressesRequest request) {
    return fetchNetworkPolicyExternalAddressesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists external IP addresses assigned to VMware workload VMs within the scope of the given
   * network policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   FetchNetworkPolicyExternalAddressesRequest request =
   *       FetchNetworkPolicyExternalAddressesRequest.newBuilder()
   *           .setNetworkPolicy(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ExternalAddress> future =
   *       vmwareEngineClient.fetchNetworkPolicyExternalAddressesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ExternalAddress element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          FetchNetworkPolicyExternalAddressesRequest,
          FetchNetworkPolicyExternalAddressesPagedResponse>
      fetchNetworkPolicyExternalAddressesPagedCallable() {
    return stub.fetchNetworkPolicyExternalAddressesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists external IP addresses assigned to VMware workload VMs within the scope of the given
   * network policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   FetchNetworkPolicyExternalAddressesRequest request =
   *       FetchNetworkPolicyExternalAddressesRequest.newBuilder()
   *           .setNetworkPolicy(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     FetchNetworkPolicyExternalAddressesResponse response =
   *         vmwareEngineClient.fetchNetworkPolicyExternalAddressesCallable().call(request);
   *     for (ExternalAddress element : response.getExternalAddressesList()) {
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
  public final UnaryCallable<
          FetchNetworkPolicyExternalAddressesRequest, FetchNetworkPolicyExternalAddressesResponse>
      fetchNetworkPolicyExternalAddressesCallable() {
    return stub.fetchNetworkPolicyExternalAddressesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single external IP address.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ExternalAddressName name =
   *       ExternalAddressName.of(
   *           "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]");
   *   ExternalAddress response = vmwareEngineClient.getExternalAddress(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the external IP address to retrieve. Resource names
   *     are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/externalAddresses/my-ip`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalAddress getExternalAddress(ExternalAddressName name) {
    GetExternalAddressRequest request =
        GetExternalAddressRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getExternalAddress(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single external IP address.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       ExternalAddressName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]")
   *           .toString();
   *   ExternalAddress response = vmwareEngineClient.getExternalAddress(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the external IP address to retrieve. Resource names
   *     are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/externalAddresses/my-ip`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalAddress getExternalAddress(String name) {
    GetExternalAddressRequest request =
        GetExternalAddressRequest.newBuilder().setName(name).build();
    return getExternalAddress(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single external IP address.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetExternalAddressRequest request =
   *       GetExternalAddressRequest.newBuilder()
   *           .setName(
   *               ExternalAddressName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]")
   *                   .toString())
   *           .build();
   *   ExternalAddress response = vmwareEngineClient.getExternalAddress(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalAddress getExternalAddress(GetExternalAddressRequest request) {
    return getExternalAddressCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single external IP address.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetExternalAddressRequest request =
   *       GetExternalAddressRequest.newBuilder()
   *           .setName(
   *               ExternalAddressName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ExternalAddress> future =
   *       vmwareEngineClient.getExternalAddressCallable().futureCall(request);
   *   // Do something.
   *   ExternalAddress response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetExternalAddressRequest, ExternalAddress>
      getExternalAddressCallable() {
    return stub.getExternalAddressCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `ExternalAddress` resource in a given private cloud. The network policy that
   * corresponds to the private cloud must have the external IP address network service enabled
   * (`NetworkPolicy.external_ip`).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   ExternalAddress externalAddress = ExternalAddress.newBuilder().build();
   *   String externalAddressId = "externalAddressId221595812";
   *   ExternalAddress response =
   *       vmwareEngineClient
   *           .createExternalAddressAsync(parent, externalAddress, externalAddressId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to create a new external IP
   *     address in. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @param externalAddress Required. The initial description of a new external IP address.
   * @param externalAddressId Required. The user-provided identifier of the `ExternalAddress` to be
   *     created. This identifier must be unique among `ExternalAddress` resources within the parent
   *     and becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExternalAddress, OperationMetadata> createExternalAddressAsync(
      PrivateCloudName parent, ExternalAddress externalAddress, String externalAddressId) {
    CreateExternalAddressRequest request =
        CreateExternalAddressRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExternalAddress(externalAddress)
            .setExternalAddressId(externalAddressId)
            .build();
    return createExternalAddressAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `ExternalAddress` resource in a given private cloud. The network policy that
   * corresponds to the private cloud must have the external IP address network service enabled
   * (`NetworkPolicy.external_ip`).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   ExternalAddress externalAddress = ExternalAddress.newBuilder().build();
   *   String externalAddressId = "externalAddressId221595812";
   *   ExternalAddress response =
   *       vmwareEngineClient
   *           .createExternalAddressAsync(parent, externalAddress, externalAddressId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to create a new external IP
   *     address in. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @param externalAddress Required. The initial description of a new external IP address.
   * @param externalAddressId Required. The user-provided identifier of the `ExternalAddress` to be
   *     created. This identifier must be unique among `ExternalAddress` resources within the parent
   *     and becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExternalAddress, OperationMetadata> createExternalAddressAsync(
      String parent, ExternalAddress externalAddress, String externalAddressId) {
    CreateExternalAddressRequest request =
        CreateExternalAddressRequest.newBuilder()
            .setParent(parent)
            .setExternalAddress(externalAddress)
            .setExternalAddressId(externalAddressId)
            .build();
    return createExternalAddressAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `ExternalAddress` resource in a given private cloud. The network policy that
   * corresponds to the private cloud must have the external IP address network service enabled
   * (`NetworkPolicy.external_ip`).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateExternalAddressRequest request =
   *       CreateExternalAddressRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setExternalAddress(ExternalAddress.newBuilder().build())
   *           .setExternalAddressId("externalAddressId221595812")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ExternalAddress response = vmwareEngineClient.createExternalAddressAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExternalAddress, OperationMetadata> createExternalAddressAsync(
      CreateExternalAddressRequest request) {
    return createExternalAddressOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `ExternalAddress` resource in a given private cloud. The network policy that
   * corresponds to the private cloud must have the external IP address network service enabled
   * (`NetworkPolicy.external_ip`).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateExternalAddressRequest request =
   *       CreateExternalAddressRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setExternalAddress(ExternalAddress.newBuilder().build())
   *           .setExternalAddressId("externalAddressId221595812")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ExternalAddress, OperationMetadata> future =
   *       vmwareEngineClient.createExternalAddressOperationCallable().futureCall(request);
   *   // Do something.
   *   ExternalAddress response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateExternalAddressRequest, ExternalAddress, OperationMetadata>
      createExternalAddressOperationCallable() {
    return stub.createExternalAddressOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `ExternalAddress` resource in a given private cloud. The network policy that
   * corresponds to the private cloud must have the external IP address network service enabled
   * (`NetworkPolicy.external_ip`).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateExternalAddressRequest request =
   *       CreateExternalAddressRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setExternalAddress(ExternalAddress.newBuilder().build())
   *           .setExternalAddressId("externalAddressId221595812")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.createExternalAddressCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateExternalAddressRequest, Operation>
      createExternalAddressCallable() {
    return stub.createExternalAddressCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single external IP address. Only fields specified in `update_mask`
   * are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ExternalAddress externalAddress = ExternalAddress.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ExternalAddress response =
   *       vmwareEngineClient.updateExternalAddressAsync(externalAddress, updateMask).get();
   * }
   * }</pre>
   *
   * @param externalAddress Required. External IP address description.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `ExternalAddress` resource by the update. The fields specified in the `update_mask` are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExternalAddress, OperationMetadata> updateExternalAddressAsync(
      ExternalAddress externalAddress, FieldMask updateMask) {
    UpdateExternalAddressRequest request =
        UpdateExternalAddressRequest.newBuilder()
            .setExternalAddress(externalAddress)
            .setUpdateMask(updateMask)
            .build();
    return updateExternalAddressAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single external IP address. Only fields specified in `update_mask`
   * are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateExternalAddressRequest request =
   *       UpdateExternalAddressRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setExternalAddress(ExternalAddress.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ExternalAddress response = vmwareEngineClient.updateExternalAddressAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExternalAddress, OperationMetadata> updateExternalAddressAsync(
      UpdateExternalAddressRequest request) {
    return updateExternalAddressOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single external IP address. Only fields specified in `update_mask`
   * are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateExternalAddressRequest request =
   *       UpdateExternalAddressRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setExternalAddress(ExternalAddress.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ExternalAddress, OperationMetadata> future =
   *       vmwareEngineClient.updateExternalAddressOperationCallable().futureCall(request);
   *   // Do something.
   *   ExternalAddress response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateExternalAddressRequest, ExternalAddress, OperationMetadata>
      updateExternalAddressOperationCallable() {
    return stub.updateExternalAddressOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single external IP address. Only fields specified in `update_mask`
   * are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateExternalAddressRequest request =
   *       UpdateExternalAddressRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setExternalAddress(ExternalAddress.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.updateExternalAddressCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateExternalAddressRequest, Operation>
      updateExternalAddressCallable() {
    return stub.updateExternalAddressCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single external IP address. When you delete an external IP address, connectivity
   * between the external IP address and the corresponding internal IP address is lost.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ExternalAddressName name =
   *       ExternalAddressName.of(
   *           "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]");
   *   vmwareEngineClient.deleteExternalAddressAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the external IP address to delete. Resource names
   *     are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/externalAddresses/my-ip`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExternalAddressAsync(
      ExternalAddressName name) {
    DeleteExternalAddressRequest request =
        DeleteExternalAddressRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteExternalAddressAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single external IP address. When you delete an external IP address, connectivity
   * between the external IP address and the corresponding internal IP address is lost.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       ExternalAddressName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]")
   *           .toString();
   *   vmwareEngineClient.deleteExternalAddressAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the external IP address to delete. Resource names
   *     are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/externalAddresses/my-ip`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExternalAddressAsync(String name) {
    DeleteExternalAddressRequest request =
        DeleteExternalAddressRequest.newBuilder().setName(name).build();
    return deleteExternalAddressAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single external IP address. When you delete an external IP address, connectivity
   * between the external IP address and the corresponding internal IP address is lost.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteExternalAddressRequest request =
   *       DeleteExternalAddressRequest.newBuilder()
   *           .setName(
   *               ExternalAddressName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmwareEngineClient.deleteExternalAddressAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExternalAddressAsync(
      DeleteExternalAddressRequest request) {
    return deleteExternalAddressOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single external IP address. When you delete an external IP address, connectivity
   * between the external IP address and the corresponding internal IP address is lost.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteExternalAddressRequest request =
   *       DeleteExternalAddressRequest.newBuilder()
   *           .setName(
   *               ExternalAddressName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmwareEngineClient.deleteExternalAddressOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteExternalAddressRequest, Empty, OperationMetadata>
      deleteExternalAddressOperationCallable() {
    return stub.deleteExternalAddressOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single external IP address. When you delete an external IP address, connectivity
   * between the external IP address and the corresponding internal IP address is lost.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteExternalAddressRequest request =
   *       DeleteExternalAddressRequest.newBuilder()
   *           .setName(
   *               ExternalAddressName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[EXTERNAL_ADDRESS]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.deleteExternalAddressCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteExternalAddressRequest, Operation>
      deleteExternalAddressCallable() {
    return stub.deleteExternalAddressCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists subnets in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   for (Subnet element : vmwareEngineClient.listSubnets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for subnets.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubnetsPagedResponse listSubnets(PrivateCloudName parent) {
    ListSubnetsRequest request =
        ListSubnetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSubnets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists subnets in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   for (Subnet element : vmwareEngineClient.listSubnets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for subnets.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubnetsPagedResponse listSubnets(String parent) {
    ListSubnetsRequest request = ListSubnetsRequest.newBuilder().setParent(parent).build();
    return listSubnets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists subnets in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListSubnetsRequest request =
   *       ListSubnetsRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Subnet element : vmwareEngineClient.listSubnets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubnetsPagedResponse listSubnets(ListSubnetsRequest request) {
    return listSubnetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists subnets in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListSubnetsRequest request =
   *       ListSubnetsRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Subnet> future = vmwareEngineClient.listSubnetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Subnet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSubnetsRequest, ListSubnetsPagedResponse>
      listSubnetsPagedCallable() {
    return stub.listSubnetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists subnets in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListSubnetsRequest request =
   *       ListSubnetsRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSubnetsResponse response = vmwareEngineClient.listSubnetsCallable().call(request);
   *     for (Subnet element : response.getSubnetsList()) {
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
  public final UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> listSubnetsCallable() {
    return stub.listSubnetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   SubnetName name = SubnetName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[SUBNET]");
   *   Subnet response = vmwareEngineClient.getSubnet(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the subnet to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/subnets/my-subnet`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subnet getSubnet(SubnetName name) {
    GetSubnetRequest request =
        GetSubnetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSubnet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       SubnetName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[SUBNET]").toString();
   *   Subnet response = vmwareEngineClient.getSubnet(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the subnet to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/subnets/my-subnet`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subnet getSubnet(String name) {
    GetSubnetRequest request = GetSubnetRequest.newBuilder().setName(name).build();
    return getSubnet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetSubnetRequest request =
   *       GetSubnetRequest.newBuilder()
   *           .setName(
   *               SubnetName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[SUBNET]")
   *                   .toString())
   *           .build();
   *   Subnet response = vmwareEngineClient.getSubnet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subnet getSubnet(GetSubnetRequest request) {
    return getSubnetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetSubnetRequest request =
   *       GetSubnetRequest.newBuilder()
   *           .setName(
   *               SubnetName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[SUBNET]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Subnet> future = vmwareEngineClient.getSubnetCallable().futureCall(request);
   *   // Do something.
   *   Subnet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSubnetRequest, Subnet> getSubnetCallable() {
    return stub.getSubnetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single subnet. Only fields specified in `update_mask` are applied.
   *
   * <p>&#42;Note&#42;: This API is synchronous and always returns a successful
   * `google.longrunning.Operation` (LRO). The returned LRO will only have `done` and `response`
   * fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   Subnet subnet = Subnet.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Subnet response = vmwareEngineClient.updateSubnetAsync(subnet, updateMask).get();
   * }
   * }</pre>
   *
   * @param subnet Required. Subnet description.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `Subnet` resource by the update. The fields specified in the `update_mask` are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subnet, OperationMetadata> updateSubnetAsync(
      Subnet subnet, FieldMask updateMask) {
    UpdateSubnetRequest request =
        UpdateSubnetRequest.newBuilder().setSubnet(subnet).setUpdateMask(updateMask).build();
    return updateSubnetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single subnet. Only fields specified in `update_mask` are applied.
   *
   * <p>&#42;Note&#42;: This API is synchronous and always returns a successful
   * `google.longrunning.Operation` (LRO). The returned LRO will only have `done` and `response`
   * fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateSubnetRequest request =
   *       UpdateSubnetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSubnet(Subnet.newBuilder().build())
   *           .build();
   *   Subnet response = vmwareEngineClient.updateSubnetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subnet, OperationMetadata> updateSubnetAsync(
      UpdateSubnetRequest request) {
    return updateSubnetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single subnet. Only fields specified in `update_mask` are applied.
   *
   * <p>&#42;Note&#42;: This API is synchronous and always returns a successful
   * `google.longrunning.Operation` (LRO). The returned LRO will only have `done` and `response`
   * fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateSubnetRequest request =
   *       UpdateSubnetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSubnet(Subnet.newBuilder().build())
   *           .build();
   *   OperationFuture<Subnet, OperationMetadata> future =
   *       vmwareEngineClient.updateSubnetOperationCallable().futureCall(request);
   *   // Do something.
   *   Subnet response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationCallable() {
    return stub.updateSubnetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single subnet. Only fields specified in `update_mask` are applied.
   *
   * <p>&#42;Note&#42;: This API is synchronous and always returns a successful
   * `google.longrunning.Operation` (LRO). The returned LRO will only have `done` and `response`
   * fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateSubnetRequest request =
   *       UpdateSubnetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSubnet(Subnet.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = vmwareEngineClient.updateSubnetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSubnetRequest, Operation> updateSubnetCallable() {
    return stub.updateSubnetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ExternalAccessRule` resources in the specified network policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   NetworkPolicyName parent =
   *       NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");
   *   for (ExternalAccessRule element :
   *       vmwareEngineClient.listExternalAccessRules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the network policy to query for external access
   *     firewall rules. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-policy`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExternalAccessRulesPagedResponse listExternalAccessRules(
      NetworkPolicyName parent) {
    ListExternalAccessRulesRequest request =
        ListExternalAccessRulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExternalAccessRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ExternalAccessRule` resources in the specified network policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent =
   *       NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString();
   *   for (ExternalAccessRule element :
   *       vmwareEngineClient.listExternalAccessRules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the network policy to query for external access
   *     firewall rules. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-policy`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExternalAccessRulesPagedResponse listExternalAccessRules(String parent) {
    ListExternalAccessRulesRequest request =
        ListExternalAccessRulesRequest.newBuilder().setParent(parent).build();
    return listExternalAccessRules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ExternalAccessRule` resources in the specified network policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListExternalAccessRulesRequest request =
   *       ListExternalAccessRulesRequest.newBuilder()
   *           .setParent(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ExternalAccessRule element :
   *       vmwareEngineClient.listExternalAccessRules(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExternalAccessRulesPagedResponse listExternalAccessRules(
      ListExternalAccessRulesRequest request) {
    return listExternalAccessRulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ExternalAccessRule` resources in the specified network policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListExternalAccessRulesRequest request =
   *       ListExternalAccessRulesRequest.newBuilder()
   *           .setParent(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ExternalAccessRule> future =
   *       vmwareEngineClient.listExternalAccessRulesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ExternalAccessRule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListExternalAccessRulesRequest, ListExternalAccessRulesPagedResponse>
      listExternalAccessRulesPagedCallable() {
    return stub.listExternalAccessRulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ExternalAccessRule` resources in the specified network policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListExternalAccessRulesRequest request =
   *       ListExternalAccessRulesRequest.newBuilder()
   *           .setParent(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListExternalAccessRulesResponse response =
   *         vmwareEngineClient.listExternalAccessRulesCallable().call(request);
   *     for (ExternalAccessRule element : response.getExternalAccessRulesList()) {
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
  public final UnaryCallable<ListExternalAccessRulesRequest, ListExternalAccessRulesResponse>
      listExternalAccessRulesCallable() {
    return stub.listExternalAccessRulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single external access rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ExternalAccessRuleName name =
   *       ExternalAccessRuleName.of(
   *           "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]");
   *   ExternalAccessRule response = vmwareEngineClient.getExternalAccessRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the external access firewall rule to retrieve.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-policy/externalAccessRules/my-rule`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalAccessRule getExternalAccessRule(ExternalAccessRuleName name) {
    GetExternalAccessRuleRequest request =
        GetExternalAccessRuleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getExternalAccessRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single external access rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       ExternalAccessRuleName.of(
   *               "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]")
   *           .toString();
   *   ExternalAccessRule response = vmwareEngineClient.getExternalAccessRule(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the external access firewall rule to retrieve.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-policy/externalAccessRules/my-rule`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalAccessRule getExternalAccessRule(String name) {
    GetExternalAccessRuleRequest request =
        GetExternalAccessRuleRequest.newBuilder().setName(name).build();
    return getExternalAccessRule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single external access rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetExternalAccessRuleRequest request =
   *       GetExternalAccessRuleRequest.newBuilder()
   *           .setName(
   *               ExternalAccessRuleName.of(
   *                       "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]")
   *                   .toString())
   *           .build();
   *   ExternalAccessRule response = vmwareEngineClient.getExternalAccessRule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalAccessRule getExternalAccessRule(GetExternalAccessRuleRequest request) {
    return getExternalAccessRuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single external access rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetExternalAccessRuleRequest request =
   *       GetExternalAccessRuleRequest.newBuilder()
   *           .setName(
   *               ExternalAccessRuleName.of(
   *                       "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ExternalAccessRule> future =
   *       vmwareEngineClient.getExternalAccessRuleCallable().futureCall(request);
   *   // Do something.
   *   ExternalAccessRule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetExternalAccessRuleRequest, ExternalAccessRule>
      getExternalAccessRuleCallable() {
    return stub.getExternalAccessRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new external access rule in a given network policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   NetworkPolicyName parent =
   *       NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");
   *   ExternalAccessRule externalAccessRule = ExternalAccessRule.newBuilder().build();
   *   String externalAccessRuleId = "externalAccessRuleId1937389350";
   *   ExternalAccessRule response =
   *       vmwareEngineClient
   *           .createExternalAccessRuleAsync(parent, externalAccessRule, externalAccessRuleId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the network policy to create a new external access
   *     firewall rule in. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-policy`
   * @param externalAccessRule Required. The initial description of a new external access rule.
   * @param externalAccessRuleId Required. The user-provided identifier of the `ExternalAccessRule`
   *     to be created. This identifier must be unique among `ExternalAccessRule` resources within
   *     the parent and becomes the final token in the name URI. The identifier must meet the
   *     following requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExternalAccessRule, OperationMetadata> createExternalAccessRuleAsync(
      NetworkPolicyName parent,
      ExternalAccessRule externalAccessRule,
      String externalAccessRuleId) {
    CreateExternalAccessRuleRequest request =
        CreateExternalAccessRuleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExternalAccessRule(externalAccessRule)
            .setExternalAccessRuleId(externalAccessRuleId)
            .build();
    return createExternalAccessRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new external access rule in a given network policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent =
   *       NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString();
   *   ExternalAccessRule externalAccessRule = ExternalAccessRule.newBuilder().build();
   *   String externalAccessRuleId = "externalAccessRuleId1937389350";
   *   ExternalAccessRule response =
   *       vmwareEngineClient
   *           .createExternalAccessRuleAsync(parent, externalAccessRule, externalAccessRuleId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the network policy to create a new external access
   *     firewall rule in. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-policy`
   * @param externalAccessRule Required. The initial description of a new external access rule.
   * @param externalAccessRuleId Required. The user-provided identifier of the `ExternalAccessRule`
   *     to be created. This identifier must be unique among `ExternalAccessRule` resources within
   *     the parent and becomes the final token in the name URI. The identifier must meet the
   *     following requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExternalAccessRule, OperationMetadata> createExternalAccessRuleAsync(
      String parent, ExternalAccessRule externalAccessRule, String externalAccessRuleId) {
    CreateExternalAccessRuleRequest request =
        CreateExternalAccessRuleRequest.newBuilder()
            .setParent(parent)
            .setExternalAccessRule(externalAccessRule)
            .setExternalAccessRuleId(externalAccessRuleId)
            .build();
    return createExternalAccessRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new external access rule in a given network policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateExternalAccessRuleRequest request =
   *       CreateExternalAccessRuleRequest.newBuilder()
   *           .setParent(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .setExternalAccessRule(ExternalAccessRule.newBuilder().build())
   *           .setExternalAccessRuleId("externalAccessRuleId1937389350")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ExternalAccessRule response = vmwareEngineClient.createExternalAccessRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExternalAccessRule, OperationMetadata> createExternalAccessRuleAsync(
      CreateExternalAccessRuleRequest request) {
    return createExternalAccessRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new external access rule in a given network policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateExternalAccessRuleRequest request =
   *       CreateExternalAccessRuleRequest.newBuilder()
   *           .setParent(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .setExternalAccessRule(ExternalAccessRule.newBuilder().build())
   *           .setExternalAccessRuleId("externalAccessRuleId1937389350")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ExternalAccessRule, OperationMetadata> future =
   *       vmwareEngineClient.createExternalAccessRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   ExternalAccessRule response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      createExternalAccessRuleOperationCallable() {
    return stub.createExternalAccessRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new external access rule in a given network policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateExternalAccessRuleRequest request =
   *       CreateExternalAccessRuleRequest.newBuilder()
   *           .setParent(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .setExternalAccessRule(ExternalAccessRule.newBuilder().build())
   *           .setExternalAccessRuleId("externalAccessRuleId1937389350")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.createExternalAccessRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateExternalAccessRuleRequest, Operation>
      createExternalAccessRuleCallable() {
    return stub.createExternalAccessRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single external access rule. Only fields specified in `update_mask`
   * are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ExternalAccessRule externalAccessRule = ExternalAccessRule.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ExternalAccessRule response =
   *       vmwareEngineClient.updateExternalAccessRuleAsync(externalAccessRule, updateMask).get();
   * }
   * }</pre>
   *
   * @param externalAccessRule Required. Description of the external access rule.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `ExternalAccessRule` resource by the update. The fields specified in the `update_mask` are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExternalAccessRule, OperationMetadata> updateExternalAccessRuleAsync(
      ExternalAccessRule externalAccessRule, FieldMask updateMask) {
    UpdateExternalAccessRuleRequest request =
        UpdateExternalAccessRuleRequest.newBuilder()
            .setExternalAccessRule(externalAccessRule)
            .setUpdateMask(updateMask)
            .build();
    return updateExternalAccessRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single external access rule. Only fields specified in `update_mask`
   * are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateExternalAccessRuleRequest request =
   *       UpdateExternalAccessRuleRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setExternalAccessRule(ExternalAccessRule.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ExternalAccessRule response = vmwareEngineClient.updateExternalAccessRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExternalAccessRule, OperationMetadata> updateExternalAccessRuleAsync(
      UpdateExternalAccessRuleRequest request) {
    return updateExternalAccessRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single external access rule. Only fields specified in `update_mask`
   * are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateExternalAccessRuleRequest request =
   *       UpdateExternalAccessRuleRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setExternalAccessRule(ExternalAccessRule.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ExternalAccessRule, OperationMetadata> future =
   *       vmwareEngineClient.updateExternalAccessRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   ExternalAccessRule response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      updateExternalAccessRuleOperationCallable() {
    return stub.updateExternalAccessRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single external access rule. Only fields specified in `update_mask`
   * are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateExternalAccessRuleRequest request =
   *       UpdateExternalAccessRuleRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setExternalAccessRule(ExternalAccessRule.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.updateExternalAccessRuleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateExternalAccessRuleRequest, Operation>
      updateExternalAccessRuleCallable() {
    return stub.updateExternalAccessRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single external access rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ExternalAccessRuleName name =
   *       ExternalAccessRuleName.of(
   *           "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]");
   *   vmwareEngineClient.deleteExternalAccessRuleAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the external access firewall rule to delete.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-policy/externalAccessRules/my-rule`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExternalAccessRuleAsync(
      ExternalAccessRuleName name) {
    DeleteExternalAccessRuleRequest request =
        DeleteExternalAccessRuleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteExternalAccessRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single external access rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       ExternalAccessRuleName.of(
   *               "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]")
   *           .toString();
   *   vmwareEngineClient.deleteExternalAccessRuleAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the external access firewall rule to delete.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-policy/externalAccessRules/my-rule`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExternalAccessRuleAsync(
      String name) {
    DeleteExternalAccessRuleRequest request =
        DeleteExternalAccessRuleRequest.newBuilder().setName(name).build();
    return deleteExternalAccessRuleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single external access rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteExternalAccessRuleRequest request =
   *       DeleteExternalAccessRuleRequest.newBuilder()
   *           .setName(
   *               ExternalAccessRuleName.of(
   *                       "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmwareEngineClient.deleteExternalAccessRuleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExternalAccessRuleAsync(
      DeleteExternalAccessRuleRequest request) {
    return deleteExternalAccessRuleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single external access rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteExternalAccessRuleRequest request =
   *       DeleteExternalAccessRuleRequest.newBuilder()
   *           .setName(
   *               ExternalAccessRuleName.of(
   *                       "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmwareEngineClient.deleteExternalAccessRuleOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteExternalAccessRuleRequest, Empty, OperationMetadata>
      deleteExternalAccessRuleOperationCallable() {
    return stub.deleteExternalAccessRuleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single external access rule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteExternalAccessRuleRequest request =
   *       DeleteExternalAccessRuleRequest.newBuilder()
   *           .setName(
   *               ExternalAccessRuleName.of(
   *                       "[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]", "[EXTERNAL_ACCESS_RULE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.deleteExternalAccessRuleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteExternalAccessRuleRequest, Operation>
      deleteExternalAccessRuleCallable() {
    return stub.deleteExternalAccessRuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists logging servers configured for a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   for (LoggingServer element : vmwareEngineClient.listLoggingServers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for logging
   *     servers. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLoggingServersPagedResponse listLoggingServers(PrivateCloudName parent) {
    ListLoggingServersRequest request =
        ListLoggingServersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLoggingServers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists logging servers configured for a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   for (LoggingServer element : vmwareEngineClient.listLoggingServers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for logging
   *     servers. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLoggingServersPagedResponse listLoggingServers(String parent) {
    ListLoggingServersRequest request =
        ListLoggingServersRequest.newBuilder().setParent(parent).build();
    return listLoggingServers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists logging servers configured for a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListLoggingServersRequest request =
   *       ListLoggingServersRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (LoggingServer element : vmwareEngineClient.listLoggingServers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLoggingServersPagedResponse listLoggingServers(
      ListLoggingServersRequest request) {
    return listLoggingServersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists logging servers configured for a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListLoggingServersRequest request =
   *       ListLoggingServersRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<LoggingServer> future =
   *       vmwareEngineClient.listLoggingServersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LoggingServer element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLoggingServersRequest, ListLoggingServersPagedResponse>
      listLoggingServersPagedCallable() {
    return stub.listLoggingServersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists logging servers configured for a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListLoggingServersRequest request =
   *       ListLoggingServersRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListLoggingServersResponse response =
   *         vmwareEngineClient.listLoggingServersCallable().call(request);
   *     for (LoggingServer element : response.getLoggingServersList()) {
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
  public final UnaryCallable<ListLoggingServersRequest, ListLoggingServersResponse>
      listLoggingServersCallable() {
    return stub.listLoggingServersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a logging server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LoggingServerName name =
   *       LoggingServerName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]");
   *   LoggingServer response = vmwareEngineClient.getLoggingServer(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Logging Server to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/loggingServers/my-logging-server`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LoggingServer getLoggingServer(LoggingServerName name) {
    GetLoggingServerRequest request =
        GetLoggingServerRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLoggingServer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a logging server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       LoggingServerName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]")
   *           .toString();
   *   LoggingServer response = vmwareEngineClient.getLoggingServer(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Logging Server to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/loggingServers/my-logging-server`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LoggingServer getLoggingServer(String name) {
    GetLoggingServerRequest request = GetLoggingServerRequest.newBuilder().setName(name).build();
    return getLoggingServer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a logging server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetLoggingServerRequest request =
   *       GetLoggingServerRequest.newBuilder()
   *           .setName(
   *               LoggingServerName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]")
   *                   .toString())
   *           .build();
   *   LoggingServer response = vmwareEngineClient.getLoggingServer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LoggingServer getLoggingServer(GetLoggingServerRequest request) {
    return getLoggingServerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a logging server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetLoggingServerRequest request =
   *       GetLoggingServerRequest.newBuilder()
   *           .setName(
   *               LoggingServerName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<LoggingServer> future =
   *       vmwareEngineClient.getLoggingServerCallable().futureCall(request);
   *   // Do something.
   *   LoggingServer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLoggingServerRequest, LoggingServer> getLoggingServerCallable() {
    return stub.getLoggingServerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new logging server for a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   LoggingServer loggingServer = LoggingServer.newBuilder().build();
   *   String loggingServerId = "loggingServerId-304163779";
   *   LoggingServer response =
   *       vmwareEngineClient.createLoggingServerAsync(parent, loggingServer, loggingServerId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to create a new Logging Server
   *     in. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @param loggingServer Required. The initial description of a new logging server.
   * @param loggingServerId Required. The user-provided identifier of the `LoggingServer` to be
   *     created. This identifier must be unique among `LoggingServer` resources within the parent
   *     and becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LoggingServer, OperationMetadata> createLoggingServerAsync(
      PrivateCloudName parent, LoggingServer loggingServer, String loggingServerId) {
    CreateLoggingServerRequest request =
        CreateLoggingServerRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLoggingServer(loggingServer)
            .setLoggingServerId(loggingServerId)
            .build();
    return createLoggingServerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new logging server for a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   LoggingServer loggingServer = LoggingServer.newBuilder().build();
   *   String loggingServerId = "loggingServerId-304163779";
   *   LoggingServer response =
   *       vmwareEngineClient.createLoggingServerAsync(parent, loggingServer, loggingServerId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to create a new Logging Server
   *     in. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @param loggingServer Required. The initial description of a new logging server.
   * @param loggingServerId Required. The user-provided identifier of the `LoggingServer` to be
   *     created. This identifier must be unique among `LoggingServer` resources within the parent
   *     and becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LoggingServer, OperationMetadata> createLoggingServerAsync(
      String parent, LoggingServer loggingServer, String loggingServerId) {
    CreateLoggingServerRequest request =
        CreateLoggingServerRequest.newBuilder()
            .setParent(parent)
            .setLoggingServer(loggingServer)
            .setLoggingServerId(loggingServerId)
            .build();
    return createLoggingServerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new logging server for a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateLoggingServerRequest request =
   *       CreateLoggingServerRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setLoggingServer(LoggingServer.newBuilder().build())
   *           .setLoggingServerId("loggingServerId-304163779")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   LoggingServer response = vmwareEngineClient.createLoggingServerAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LoggingServer, OperationMetadata> createLoggingServerAsync(
      CreateLoggingServerRequest request) {
    return createLoggingServerOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new logging server for a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateLoggingServerRequest request =
   *       CreateLoggingServerRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setLoggingServer(LoggingServer.newBuilder().build())
   *           .setLoggingServerId("loggingServerId-304163779")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<LoggingServer, OperationMetadata> future =
   *       vmwareEngineClient.createLoggingServerOperationCallable().futureCall(request);
   *   // Do something.
   *   LoggingServer response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateLoggingServerRequest, LoggingServer, OperationMetadata>
      createLoggingServerOperationCallable() {
    return stub.createLoggingServerOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new logging server for a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateLoggingServerRequest request =
   *       CreateLoggingServerRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setLoggingServer(LoggingServer.newBuilder().build())
   *           .setLoggingServerId("loggingServerId-304163779")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.createLoggingServerCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateLoggingServerRequest, Operation> createLoggingServerCallable() {
    return stub.createLoggingServerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single logging server. Only fields specified in `update_mask` are
   * applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LoggingServer loggingServer = LoggingServer.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   LoggingServer response =
   *       vmwareEngineClient.updateLoggingServerAsync(loggingServer, updateMask).get();
   * }
   * }</pre>
   *
   * @param loggingServer Required. Logging server description.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `LoggingServer` resource by the update. The fields specified in the `update_mask` are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LoggingServer, OperationMetadata> updateLoggingServerAsync(
      LoggingServer loggingServer, FieldMask updateMask) {
    UpdateLoggingServerRequest request =
        UpdateLoggingServerRequest.newBuilder()
            .setLoggingServer(loggingServer)
            .setUpdateMask(updateMask)
            .build();
    return updateLoggingServerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single logging server. Only fields specified in `update_mask` are
   * applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateLoggingServerRequest request =
   *       UpdateLoggingServerRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setLoggingServer(LoggingServer.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   LoggingServer response = vmwareEngineClient.updateLoggingServerAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LoggingServer, OperationMetadata> updateLoggingServerAsync(
      UpdateLoggingServerRequest request) {
    return updateLoggingServerOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single logging server. Only fields specified in `update_mask` are
   * applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateLoggingServerRequest request =
   *       UpdateLoggingServerRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setLoggingServer(LoggingServer.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<LoggingServer, OperationMetadata> future =
   *       vmwareEngineClient.updateLoggingServerOperationCallable().futureCall(request);
   *   // Do something.
   *   LoggingServer response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateLoggingServerRequest, LoggingServer, OperationMetadata>
      updateLoggingServerOperationCallable() {
    return stub.updateLoggingServerOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single logging server. Only fields specified in `update_mask` are
   * applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateLoggingServerRequest request =
   *       UpdateLoggingServerRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setLoggingServer(LoggingServer.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.updateLoggingServerCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateLoggingServerRequest, Operation> updateLoggingServerCallable() {
    return stub.updateLoggingServerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single logging server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LoggingServerName name =
   *       LoggingServerName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]");
   *   vmwareEngineClient.deleteLoggingServerAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the logging server to delete. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/loggingServers/my-logging-server`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLoggingServerAsync(
      LoggingServerName name) {
    DeleteLoggingServerRequest request =
        DeleteLoggingServerRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteLoggingServerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single logging server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       LoggingServerName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]")
   *           .toString();
   *   vmwareEngineClient.deleteLoggingServerAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the logging server to delete. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/loggingServers/my-logging-server`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLoggingServerAsync(String name) {
    DeleteLoggingServerRequest request =
        DeleteLoggingServerRequest.newBuilder().setName(name).build();
    return deleteLoggingServerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single logging server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteLoggingServerRequest request =
   *       DeleteLoggingServerRequest.newBuilder()
   *           .setName(
   *               LoggingServerName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmwareEngineClient.deleteLoggingServerAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLoggingServerAsync(
      DeleteLoggingServerRequest request) {
    return deleteLoggingServerOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single logging server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteLoggingServerRequest request =
   *       DeleteLoggingServerRequest.newBuilder()
   *           .setName(
   *               LoggingServerName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmwareEngineClient.deleteLoggingServerOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteLoggingServerRequest, Empty, OperationMetadata>
      deleteLoggingServerOperationCallable() {
    return stub.deleteLoggingServerOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single logging server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteLoggingServerRequest request =
   *       DeleteLoggingServerRequest.newBuilder()
   *           .setName(
   *               LoggingServerName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[LOGGING_SERVER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.deleteLoggingServerCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteLoggingServerRequest, Operation> deleteLoggingServerCallable() {
    return stub.deleteLoggingServerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists node types
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (NodeType element : vmwareEngineClient.listNodeTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to be queried for node types.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodeTypesPagedResponse listNodeTypes(LocationName parent) {
    ListNodeTypesRequest request =
        ListNodeTypesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNodeTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists node types
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (NodeType element : vmwareEngineClient.listNodeTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to be queried for node types.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodeTypesPagedResponse listNodeTypes(String parent) {
    ListNodeTypesRequest request = ListNodeTypesRequest.newBuilder().setParent(parent).build();
    return listNodeTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists node types
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNodeTypesRequest request =
   *       ListNodeTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (NodeType element : vmwareEngineClient.listNodeTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodeTypesPagedResponse listNodeTypes(ListNodeTypesRequest request) {
    return listNodeTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists node types
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNodeTypesRequest request =
   *       ListNodeTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<NodeType> future =
   *       vmwareEngineClient.listNodeTypesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NodeType element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNodeTypesRequest, ListNodeTypesPagedResponse>
      listNodeTypesPagedCallable() {
    return stub.listNodeTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists node types
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNodeTypesRequest request =
   *       ListNodeTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListNodeTypesResponse response = vmwareEngineClient.listNodeTypesCallable().call(request);
   *     for (NodeType element : response.getNodeTypesList()) {
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
  public final UnaryCallable<ListNodeTypesRequest, ListNodeTypesResponse> listNodeTypesCallable() {
    return stub.listNodeTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single `NodeType`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   NodeTypeName name = NodeTypeName.of("[PROJECT]", "[LOCATION]", "[NODE_TYPE]");
   *   NodeType response = vmwareEngineClient.getNodeType(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the node type to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-proj/locations/us-central1-a/nodeTypes/standard-72`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodeType getNodeType(NodeTypeName name) {
    GetNodeTypeRequest request =
        GetNodeTypeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getNodeType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single `NodeType`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name = NodeTypeName.of("[PROJECT]", "[LOCATION]", "[NODE_TYPE]").toString();
   *   NodeType response = vmwareEngineClient.getNodeType(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the node type to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-proj/locations/us-central1-a/nodeTypes/standard-72`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodeType getNodeType(String name) {
    GetNodeTypeRequest request = GetNodeTypeRequest.newBuilder().setName(name).build();
    return getNodeType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single `NodeType`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetNodeTypeRequest request =
   *       GetNodeTypeRequest.newBuilder()
   *           .setName(NodeTypeName.of("[PROJECT]", "[LOCATION]", "[NODE_TYPE]").toString())
   *           .build();
   *   NodeType response = vmwareEngineClient.getNodeType(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodeType getNodeType(GetNodeTypeRequest request) {
    return getNodeTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single `NodeType`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetNodeTypeRequest request =
   *       GetNodeTypeRequest.newBuilder()
   *           .setName(NodeTypeName.of("[PROJECT]", "[LOCATION]", "[NODE_TYPE]").toString())
   *           .build();
   *   ApiFuture<NodeType> future = vmwareEngineClient.getNodeTypeCallable().futureCall(request);
   *   // Do something.
   *   NodeType response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNodeTypeRequest, NodeType> getNodeTypeCallable() {
    return stub.getNodeTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of credentials for NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName privateCloud =
   *       PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   Credentials response = vmwareEngineClient.showNsxCredentials(privateCloud);
   * }
   * }</pre>
   *
   * @param privateCloud Required. The resource name of the private cloud to be queried for
   *     credentials. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Credentials showNsxCredentials(PrivateCloudName privateCloud) {
    ShowNsxCredentialsRequest request =
        ShowNsxCredentialsRequest.newBuilder()
            .setPrivateCloud(privateCloud == null ? null : privateCloud.toString())
            .build();
    return showNsxCredentials(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of credentials for NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String privateCloud =
   *       PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   Credentials response = vmwareEngineClient.showNsxCredentials(privateCloud);
   * }
   * }</pre>
   *
   * @param privateCloud Required. The resource name of the private cloud to be queried for
   *     credentials. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Credentials showNsxCredentials(String privateCloud) {
    ShowNsxCredentialsRequest request =
        ShowNsxCredentialsRequest.newBuilder().setPrivateCloud(privateCloud).build();
    return showNsxCredentials(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of credentials for NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ShowNsxCredentialsRequest request =
   *       ShowNsxCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .build();
   *   Credentials response = vmwareEngineClient.showNsxCredentials(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Credentials showNsxCredentials(ShowNsxCredentialsRequest request) {
    return showNsxCredentialsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of credentials for NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ShowNsxCredentialsRequest request =
   *       ShowNsxCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .build();
   *   ApiFuture<Credentials> future =
   *       vmwareEngineClient.showNsxCredentialsCallable().futureCall(request);
   *   // Do something.
   *   Credentials response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ShowNsxCredentialsRequest, Credentials> showNsxCredentialsCallable() {
    return stub.showNsxCredentialsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of credentials for Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName privateCloud =
   *       PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   Credentials response = vmwareEngineClient.showVcenterCredentials(privateCloud);
   * }
   * }</pre>
   *
   * @param privateCloud Required. The resource name of the private cloud to be queried for
   *     credentials. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Credentials showVcenterCredentials(PrivateCloudName privateCloud) {
    ShowVcenterCredentialsRequest request =
        ShowVcenterCredentialsRequest.newBuilder()
            .setPrivateCloud(privateCloud == null ? null : privateCloud.toString())
            .build();
    return showVcenterCredentials(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of credentials for Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String privateCloud =
   *       PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   Credentials response = vmwareEngineClient.showVcenterCredentials(privateCloud);
   * }
   * }</pre>
   *
   * @param privateCloud Required. The resource name of the private cloud to be queried for
   *     credentials. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Credentials showVcenterCredentials(String privateCloud) {
    ShowVcenterCredentialsRequest request =
        ShowVcenterCredentialsRequest.newBuilder().setPrivateCloud(privateCloud).build();
    return showVcenterCredentials(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of credentials for Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ShowVcenterCredentialsRequest request =
   *       ShowVcenterCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setUsername("username-265713450")
   *           .build();
   *   Credentials response = vmwareEngineClient.showVcenterCredentials(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Credentials showVcenterCredentials(ShowVcenterCredentialsRequest request) {
    return showVcenterCredentialsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of credentials for Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ShowVcenterCredentialsRequest request =
   *       ShowVcenterCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setUsername("username-265713450")
   *           .build();
   *   ApiFuture<Credentials> future =
   *       vmwareEngineClient.showVcenterCredentialsCallable().futureCall(request);
   *   // Do something.
   *   Credentials response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ShowVcenterCredentialsRequest, Credentials>
      showVcenterCredentialsCallable() {
    return stub.showVcenterCredentialsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName privateCloud =
   *       PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   PrivateCloud response = vmwareEngineClient.resetNsxCredentialsAsync(privateCloud).get();
   * }
   * }</pre>
   *
   * @param privateCloud Required. The resource name of the private cloud to reset credentials for.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> resetNsxCredentialsAsync(
      PrivateCloudName privateCloud) {
    ResetNsxCredentialsRequest request =
        ResetNsxCredentialsRequest.newBuilder()
            .setPrivateCloud(privateCloud == null ? null : privateCloud.toString())
            .build();
    return resetNsxCredentialsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String privateCloud =
   *       PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   PrivateCloud response = vmwareEngineClient.resetNsxCredentialsAsync(privateCloud).get();
   * }
   * }</pre>
   *
   * @param privateCloud Required. The resource name of the private cloud to reset credentials for.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> resetNsxCredentialsAsync(
      String privateCloud) {
    ResetNsxCredentialsRequest request =
        ResetNsxCredentialsRequest.newBuilder().setPrivateCloud(privateCloud).build();
    return resetNsxCredentialsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ResetNsxCredentialsRequest request =
   *       ResetNsxCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   PrivateCloud response = vmwareEngineClient.resetNsxCredentialsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> resetNsxCredentialsAsync(
      ResetNsxCredentialsRequest request) {
    return resetNsxCredentialsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ResetNsxCredentialsRequest request =
   *       ResetNsxCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<PrivateCloud, OperationMetadata> future =
   *       vmwareEngineClient.resetNsxCredentialsOperationCallable().futureCall(request);
   *   // Do something.
   *   PrivateCloud response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
      resetNsxCredentialsOperationCallable() {
    return stub.resetNsxCredentialsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ResetNsxCredentialsRequest request =
   *       ResetNsxCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.resetNsxCredentialsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResetNsxCredentialsRequest, Operation> resetNsxCredentialsCallable() {
    return stub.resetNsxCredentialsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName privateCloud =
   *       PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   PrivateCloud response = vmwareEngineClient.resetVcenterCredentialsAsync(privateCloud).get();
   * }
   * }</pre>
   *
   * @param privateCloud Required. The resource name of the private cloud to reset credentials for.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> resetVcenterCredentialsAsync(
      PrivateCloudName privateCloud) {
    ResetVcenterCredentialsRequest request =
        ResetVcenterCredentialsRequest.newBuilder()
            .setPrivateCloud(privateCloud == null ? null : privateCloud.toString())
            .build();
    return resetVcenterCredentialsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String privateCloud =
   *       PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   PrivateCloud response = vmwareEngineClient.resetVcenterCredentialsAsync(privateCloud).get();
   * }
   * }</pre>
   *
   * @param privateCloud Required. The resource name of the private cloud to reset credentials for.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> resetVcenterCredentialsAsync(
      String privateCloud) {
    ResetVcenterCredentialsRequest request =
        ResetVcenterCredentialsRequest.newBuilder().setPrivateCloud(privateCloud).build();
    return resetVcenterCredentialsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ResetVcenterCredentialsRequest request =
   *       ResetVcenterCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .setUsername("username-265713450")
   *           .build();
   *   PrivateCloud response = vmwareEngineClient.resetVcenterCredentialsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> resetVcenterCredentialsAsync(
      ResetVcenterCredentialsRequest request) {
    return resetVcenterCredentialsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ResetVcenterCredentialsRequest request =
   *       ResetVcenterCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .setUsername("username-265713450")
   *           .build();
   *   OperationFuture<PrivateCloud, OperationMetadata> future =
   *       vmwareEngineClient.resetVcenterCredentialsOperationCallable().futureCall(request);
   *   // Do something.
   *   PrivateCloud response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
      resetVcenterCredentialsOperationCallable() {
    return stub.resetVcenterCredentialsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ResetVcenterCredentialsRequest request =
   *       ResetVcenterCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .setUsername("username-265713450")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.resetVcenterCredentialsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResetVcenterCredentialsRequest, Operation>
      resetVcenterCredentialsCallable() {
    return stub.resetVcenterCredentialsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the `DnsForwarding` config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DnsForwardingName name = DnsForwardingName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   DnsForwarding response = vmwareEngineClient.getDnsForwarding(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of a `DnsForwarding` to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/dnsForwarding`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DnsForwarding getDnsForwarding(DnsForwardingName name) {
    GetDnsForwardingRequest request =
        GetDnsForwardingRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDnsForwarding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the `DnsForwarding` config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name = DnsForwardingName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   DnsForwarding response = vmwareEngineClient.getDnsForwarding(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of a `DnsForwarding` to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/dnsForwarding`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DnsForwarding getDnsForwarding(String name) {
    GetDnsForwardingRequest request = GetDnsForwardingRequest.newBuilder().setName(name).build();
    return getDnsForwarding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the `DnsForwarding` config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetDnsForwardingRequest request =
   *       GetDnsForwardingRequest.newBuilder()
   *           .setName(
   *               DnsForwardingName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .build();
   *   DnsForwarding response = vmwareEngineClient.getDnsForwarding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DnsForwarding getDnsForwarding(GetDnsForwardingRequest request) {
    return getDnsForwardingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the `DnsForwarding` config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetDnsForwardingRequest request =
   *       GetDnsForwardingRequest.newBuilder()
   *           .setName(
   *               DnsForwardingName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .build();
   *   ApiFuture<DnsForwarding> future =
   *       vmwareEngineClient.getDnsForwardingCallable().futureCall(request);
   *   // Do something.
   *   DnsForwarding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDnsForwardingRequest, DnsForwarding> getDnsForwardingCallable() {
    return stub.getDnsForwardingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of the `DnsForwarding` config, like associated domains. Only fields
   * specified in `update_mask` are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DnsForwarding dnsForwarding = DnsForwarding.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DnsForwarding response =
   *       vmwareEngineClient.updateDnsForwardingAsync(dnsForwarding, updateMask).get();
   * }
   * }</pre>
   *
   * @param dnsForwarding Required. DnsForwarding config details.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `DnsForwarding` resource by the update. The fields specified in the `update_mask` are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DnsForwarding, OperationMetadata> updateDnsForwardingAsync(
      DnsForwarding dnsForwarding, FieldMask updateMask) {
    UpdateDnsForwardingRequest request =
        UpdateDnsForwardingRequest.newBuilder()
            .setDnsForwarding(dnsForwarding)
            .setUpdateMask(updateMask)
            .build();
    return updateDnsForwardingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of the `DnsForwarding` config, like associated domains. Only fields
   * specified in `update_mask` are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateDnsForwardingRequest request =
   *       UpdateDnsForwardingRequest.newBuilder()
   *           .setDnsForwarding(DnsForwarding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   DnsForwarding response = vmwareEngineClient.updateDnsForwardingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DnsForwarding, OperationMetadata> updateDnsForwardingAsync(
      UpdateDnsForwardingRequest request) {
    return updateDnsForwardingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of the `DnsForwarding` config, like associated domains. Only fields
   * specified in `update_mask` are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateDnsForwardingRequest request =
   *       UpdateDnsForwardingRequest.newBuilder()
   *           .setDnsForwarding(DnsForwarding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<DnsForwarding, OperationMetadata> future =
   *       vmwareEngineClient.updateDnsForwardingOperationCallable().futureCall(request);
   *   // Do something.
   *   DnsForwarding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDnsForwardingRequest, DnsForwarding, OperationMetadata>
      updateDnsForwardingOperationCallable() {
    return stub.updateDnsForwardingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of the `DnsForwarding` config, like associated domains. Only fields
   * specified in `update_mask` are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateDnsForwardingRequest request =
   *       UpdateDnsForwardingRequest.newBuilder()
   *           .setDnsForwarding(DnsForwarding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.updateDnsForwardingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDnsForwardingRequest, Operation> updateDnsForwardingCallable() {
    return stub.updateDnsForwardingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `NetworkPeering` resource by its resource name. The resource contains details of
   * the network peering, such as peered networks, import and export custom route configurations,
   * and peering state. NetworkPeering is a global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   NetworkPeeringName name =
   *       NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]");
   *   NetworkPeering response = vmwareEngineClient.getNetworkPeering(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the network peering to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/networkPeerings/my-peering`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkPeering getNetworkPeering(NetworkPeeringName name) {
    GetNetworkPeeringRequest request =
        GetNetworkPeeringRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getNetworkPeering(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `NetworkPeering` resource by its resource name. The resource contains details of
   * the network peering, such as peered networks, import and export custom route configurations,
   * and peering state. NetworkPeering is a global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]").toString();
   *   NetworkPeering response = vmwareEngineClient.getNetworkPeering(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the network peering to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/networkPeerings/my-peering`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkPeering getNetworkPeering(String name) {
    GetNetworkPeeringRequest request = GetNetworkPeeringRequest.newBuilder().setName(name).build();
    return getNetworkPeering(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `NetworkPeering` resource by its resource name. The resource contains details of
   * the network peering, such as peered networks, import and export custom route configurations,
   * and peering state. NetworkPeering is a global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetNetworkPeeringRequest request =
   *       GetNetworkPeeringRequest.newBuilder()
   *           .setName(
   *               NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]").toString())
   *           .build();
   *   NetworkPeering response = vmwareEngineClient.getNetworkPeering(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkPeering getNetworkPeering(GetNetworkPeeringRequest request) {
    return getNetworkPeeringCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `NetworkPeering` resource by its resource name. The resource contains details of
   * the network peering, such as peered networks, import and export custom route configurations,
   * and peering state. NetworkPeering is a global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetNetworkPeeringRequest request =
   *       GetNetworkPeeringRequest.newBuilder()
   *           .setName(
   *               NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]").toString())
   *           .build();
   *   ApiFuture<NetworkPeering> future =
   *       vmwareEngineClient.getNetworkPeeringCallable().futureCall(request);
   *   // Do something.
   *   NetworkPeering response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNetworkPeeringRequest, NetworkPeering> getNetworkPeeringCallable() {
    return stub.getNetworkPeeringCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NetworkPeering` resources in a given project. NetworkPeering is a global resource and
   * location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (NetworkPeering element : vmwareEngineClient.listNetworkPeerings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location (global) to query for network
   *     peerings. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkPeeringsPagedResponse listNetworkPeerings(LocationName parent) {
    ListNetworkPeeringsRequest request =
        ListNetworkPeeringsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNetworkPeerings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NetworkPeering` resources in a given project. NetworkPeering is a global resource and
   * location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (NetworkPeering element : vmwareEngineClient.listNetworkPeerings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location (global) to query for network
   *     peerings. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkPeeringsPagedResponse listNetworkPeerings(String parent) {
    ListNetworkPeeringsRequest request =
        ListNetworkPeeringsRequest.newBuilder().setParent(parent).build();
    return listNetworkPeerings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NetworkPeering` resources in a given project. NetworkPeering is a global resource and
   * location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNetworkPeeringsRequest request =
   *       ListNetworkPeeringsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (NetworkPeering element : vmwareEngineClient.listNetworkPeerings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkPeeringsPagedResponse listNetworkPeerings(
      ListNetworkPeeringsRequest request) {
    return listNetworkPeeringsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NetworkPeering` resources in a given project. NetworkPeering is a global resource and
   * location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNetworkPeeringsRequest request =
   *       ListNetworkPeeringsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<NetworkPeering> future =
   *       vmwareEngineClient.listNetworkPeeringsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NetworkPeering element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNetworkPeeringsRequest, ListNetworkPeeringsPagedResponse>
      listNetworkPeeringsPagedCallable() {
    return stub.listNetworkPeeringsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NetworkPeering` resources in a given project. NetworkPeering is a global resource and
   * location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNetworkPeeringsRequest request =
   *       ListNetworkPeeringsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListNetworkPeeringsResponse response =
   *         vmwareEngineClient.listNetworkPeeringsCallable().call(request);
   *     for (NetworkPeering element : response.getNetworkPeeringsList()) {
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
  public final UnaryCallable<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse>
      listNetworkPeeringsCallable() {
    return stub.listNetworkPeeringsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network peering between the peer network and VMware Engine network provided in a
   * `NetworkPeering` resource. NetworkPeering is a global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   NetworkPeering networkPeering = NetworkPeering.newBuilder().build();
   *   String networkPeeringId = "networkPeeringId1321772525";
   *   NetworkPeering response =
   *       vmwareEngineClient
   *           .createNetworkPeeringAsync(parent, networkPeering, networkPeeringId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to create the new network peering in.
   *     This value is always `global`, because `NetworkPeering` is a global resource. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global`
   * @param networkPeering Required. The initial description of the new network peering.
   * @param networkPeeringId Required. The user-provided identifier of the new `NetworkPeering`.
   *     This identifier must be unique among `NetworkPeering` resources within the parent and
   *     becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NetworkPeering, OperationMetadata> createNetworkPeeringAsync(
      LocationName parent, NetworkPeering networkPeering, String networkPeeringId) {
    CreateNetworkPeeringRequest request =
        CreateNetworkPeeringRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNetworkPeering(networkPeering)
            .setNetworkPeeringId(networkPeeringId)
            .build();
    return createNetworkPeeringAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network peering between the peer network and VMware Engine network provided in a
   * `NetworkPeering` resource. NetworkPeering is a global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   NetworkPeering networkPeering = NetworkPeering.newBuilder().build();
   *   String networkPeeringId = "networkPeeringId1321772525";
   *   NetworkPeering response =
   *       vmwareEngineClient
   *           .createNetworkPeeringAsync(parent, networkPeering, networkPeeringId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to create the new network peering in.
   *     This value is always `global`, because `NetworkPeering` is a global resource. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global`
   * @param networkPeering Required. The initial description of the new network peering.
   * @param networkPeeringId Required. The user-provided identifier of the new `NetworkPeering`.
   *     This identifier must be unique among `NetworkPeering` resources within the parent and
   *     becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NetworkPeering, OperationMetadata> createNetworkPeeringAsync(
      String parent, NetworkPeering networkPeering, String networkPeeringId) {
    CreateNetworkPeeringRequest request =
        CreateNetworkPeeringRequest.newBuilder()
            .setParent(parent)
            .setNetworkPeering(networkPeering)
            .setNetworkPeeringId(networkPeeringId)
            .build();
    return createNetworkPeeringAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network peering between the peer network and VMware Engine network provided in a
   * `NetworkPeering` resource. NetworkPeering is a global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateNetworkPeeringRequest request =
   *       CreateNetworkPeeringRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNetworkPeeringId("networkPeeringId1321772525")
   *           .setNetworkPeering(NetworkPeering.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   NetworkPeering response = vmwareEngineClient.createNetworkPeeringAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NetworkPeering, OperationMetadata> createNetworkPeeringAsync(
      CreateNetworkPeeringRequest request) {
    return createNetworkPeeringOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network peering between the peer network and VMware Engine network provided in a
   * `NetworkPeering` resource. NetworkPeering is a global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateNetworkPeeringRequest request =
   *       CreateNetworkPeeringRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNetworkPeeringId("networkPeeringId1321772525")
   *           .setNetworkPeering(NetworkPeering.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<NetworkPeering, OperationMetadata> future =
   *       vmwareEngineClient.createNetworkPeeringOperationCallable().futureCall(request);
   *   // Do something.
   *   NetworkPeering response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      createNetworkPeeringOperationCallable() {
    return stub.createNetworkPeeringOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network peering between the peer network and VMware Engine network provided in a
   * `NetworkPeering` resource. NetworkPeering is a global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateNetworkPeeringRequest request =
   *       CreateNetworkPeeringRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNetworkPeeringId("networkPeeringId1321772525")
   *           .setNetworkPeering(NetworkPeering.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.createNetworkPeeringCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateNetworkPeeringRequest, Operation>
      createNetworkPeeringCallable() {
    return stub.createNetworkPeeringCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `NetworkPeering` resource. When a network peering is deleted for a VMware Engine
   * network, the peer network becomes inaccessible to that VMware Engine network. NetworkPeering is
   * a global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   NetworkPeeringName name =
   *       NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]");
   *   vmwareEngineClient.deleteNetworkPeeringAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the network peering to be deleted. Resource names
   *     are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/networkPeerings/my-peering`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteNetworkPeeringAsync(
      NetworkPeeringName name) {
    DeleteNetworkPeeringRequest request =
        DeleteNetworkPeeringRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteNetworkPeeringAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `NetworkPeering` resource. When a network peering is deleted for a VMware Engine
   * network, the peer network becomes inaccessible to that VMware Engine network. NetworkPeering is
   * a global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]").toString();
   *   vmwareEngineClient.deleteNetworkPeeringAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the network peering to be deleted. Resource names
   *     are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/networkPeerings/my-peering`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteNetworkPeeringAsync(String name) {
    DeleteNetworkPeeringRequest request =
        DeleteNetworkPeeringRequest.newBuilder().setName(name).build();
    return deleteNetworkPeeringAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `NetworkPeering` resource. When a network peering is deleted for a VMware Engine
   * network, the peer network becomes inaccessible to that VMware Engine network. NetworkPeering is
   * a global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteNetworkPeeringRequest request =
   *       DeleteNetworkPeeringRequest.newBuilder()
   *           .setName(
   *               NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmwareEngineClient.deleteNetworkPeeringAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteNetworkPeeringAsync(
      DeleteNetworkPeeringRequest request) {
    return deleteNetworkPeeringOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `NetworkPeering` resource. When a network peering is deleted for a VMware Engine
   * network, the peer network becomes inaccessible to that VMware Engine network. NetworkPeering is
   * a global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteNetworkPeeringRequest request =
   *       DeleteNetworkPeeringRequest.newBuilder()
   *           .setName(
   *               NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmwareEngineClient.deleteNetworkPeeringOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteNetworkPeeringRequest, Empty, OperationMetadata>
      deleteNetworkPeeringOperationCallable() {
    return stub.deleteNetworkPeeringOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `NetworkPeering` resource. When a network peering is deleted for a VMware Engine
   * network, the peer network becomes inaccessible to that VMware Engine network. NetworkPeering is
   * a global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteNetworkPeeringRequest request =
   *       DeleteNetworkPeeringRequest.newBuilder()
   *           .setName(
   *               NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.deleteNetworkPeeringCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNetworkPeeringRequest, Operation>
      deleteNetworkPeeringCallable() {
    return stub.deleteNetworkPeeringCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `NetworkPeering` resource. Only the `description` field can be updated. Only fields
   * specified in `updateMask` are applied. NetworkPeering is a global resource and location can
   * only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   NetworkPeering networkPeering = NetworkPeering.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   NetworkPeering response =
   *       vmwareEngineClient.updateNetworkPeeringAsync(networkPeering, updateMask).get();
   * }
   * }</pre>
   *
   * @param networkPeering Required. Network peering description.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `NetworkPeering` resource by the update. The fields specified in the `update_mask` are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NetworkPeering, OperationMetadata> updateNetworkPeeringAsync(
      NetworkPeering networkPeering, FieldMask updateMask) {
    UpdateNetworkPeeringRequest request =
        UpdateNetworkPeeringRequest.newBuilder()
            .setNetworkPeering(networkPeering)
            .setUpdateMask(updateMask)
            .build();
    return updateNetworkPeeringAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `NetworkPeering` resource. Only the `description` field can be updated. Only fields
   * specified in `updateMask` are applied. NetworkPeering is a global resource and location can
   * only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateNetworkPeeringRequest request =
   *       UpdateNetworkPeeringRequest.newBuilder()
   *           .setNetworkPeering(NetworkPeering.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   NetworkPeering response = vmwareEngineClient.updateNetworkPeeringAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NetworkPeering, OperationMetadata> updateNetworkPeeringAsync(
      UpdateNetworkPeeringRequest request) {
    return updateNetworkPeeringOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `NetworkPeering` resource. Only the `description` field can be updated. Only fields
   * specified in `updateMask` are applied. NetworkPeering is a global resource and location can
   * only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateNetworkPeeringRequest request =
   *       UpdateNetworkPeeringRequest.newBuilder()
   *           .setNetworkPeering(NetworkPeering.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<NetworkPeering, OperationMetadata> future =
   *       vmwareEngineClient.updateNetworkPeeringOperationCallable().futureCall(request);
   *   // Do something.
   *   NetworkPeering response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      updateNetworkPeeringOperationCallable() {
    return stub.updateNetworkPeeringOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `NetworkPeering` resource. Only the `description` field can be updated. Only fields
   * specified in `updateMask` are applied. NetworkPeering is a global resource and location can
   * only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateNetworkPeeringRequest request =
   *       UpdateNetworkPeeringRequest.newBuilder()
   *           .setNetworkPeering(NetworkPeering.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.updateNetworkPeeringCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateNetworkPeeringRequest, Operation>
      updateNetworkPeeringCallable() {
    return stub.updateNetworkPeeringCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the network peering routes exchanged over a peering connection. NetworkPeering is a
   * global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   NetworkPeeringName parent =
   *       NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]");
   *   for (PeeringRoute element : vmwareEngineClient.listPeeringRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the network peering to retrieve peering routes
   *     from. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/networkPeerings/my-peering`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPeeringRoutesPagedResponse listPeeringRoutes(NetworkPeeringName parent) {
    ListPeeringRoutesRequest request =
        ListPeeringRoutesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPeeringRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the network peering routes exchanged over a peering connection. NetworkPeering is a
   * global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent =
   *       NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]").toString();
   *   for (PeeringRoute element : vmwareEngineClient.listPeeringRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the network peering to retrieve peering routes
   *     from. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/networkPeerings/my-peering`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPeeringRoutesPagedResponse listPeeringRoutes(String parent) {
    ListPeeringRoutesRequest request =
        ListPeeringRoutesRequest.newBuilder().setParent(parent).build();
    return listPeeringRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the network peering routes exchanged over a peering connection. NetworkPeering is a
   * global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListPeeringRoutesRequest request =
   *       ListPeeringRoutesRequest.newBuilder()
   *           .setParent(
   *               NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (PeeringRoute element : vmwareEngineClient.listPeeringRoutes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPeeringRoutesPagedResponse listPeeringRoutes(ListPeeringRoutesRequest request) {
    return listPeeringRoutesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the network peering routes exchanged over a peering connection. NetworkPeering is a
   * global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListPeeringRoutesRequest request =
   *       ListPeeringRoutesRequest.newBuilder()
   *           .setParent(
   *               NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<PeeringRoute> future =
   *       vmwareEngineClient.listPeeringRoutesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PeeringRoute element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPeeringRoutesRequest, ListPeeringRoutesPagedResponse>
      listPeeringRoutesPagedCallable() {
    return stub.listPeeringRoutesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the network peering routes exchanged over a peering connection. NetworkPeering is a
   * global resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListPeeringRoutesRequest request =
   *       ListPeeringRoutesRequest.newBuilder()
   *           .setParent(
   *               NetworkPeeringName.of("[PROJECT]", "[LOCATION]", "[NETWORK_PEERING]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListPeeringRoutesResponse response =
   *         vmwareEngineClient.listPeeringRoutesCallable().call(request);
   *     for (PeeringRoute element : response.getPeeringRoutesList()) {
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
  public final UnaryCallable<ListPeeringRoutesRequest, ListPeeringRoutesResponse>
      listPeeringRoutesCallable() {
    return stub.listPeeringRoutesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HCX activation key in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   HcxActivationKey hcxActivationKey = HcxActivationKey.newBuilder().build();
   *   String hcxActivationKeyId = "hcxActivationKeyId-645871673";
   *   HcxActivationKey response =
   *       vmwareEngineClient
   *           .createHcxActivationKeyAsync(parent, hcxActivationKey, hcxActivationKeyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to create the key for. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/privateClouds/my-cloud`
   * @param hcxActivationKey Required. The initial description of a new HCX activation key. When
   *     creating a new key, this field must be an empty object.
   * @param hcxActivationKeyId Required. The user-provided identifier of the `HcxActivationKey` to
   *     be created. This identifier must be unique among `HcxActivationKey` resources within the
   *     parent and becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<HcxActivationKey, OperationMetadata> createHcxActivationKeyAsync(
      PrivateCloudName parent, HcxActivationKey hcxActivationKey, String hcxActivationKeyId) {
    CreateHcxActivationKeyRequest request =
        CreateHcxActivationKeyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setHcxActivationKey(hcxActivationKey)
            .setHcxActivationKeyId(hcxActivationKeyId)
            .build();
    return createHcxActivationKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HCX activation key in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   HcxActivationKey hcxActivationKey = HcxActivationKey.newBuilder().build();
   *   String hcxActivationKeyId = "hcxActivationKeyId-645871673";
   *   HcxActivationKey response =
   *       vmwareEngineClient
   *           .createHcxActivationKeyAsync(parent, hcxActivationKey, hcxActivationKeyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to create the key for. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/privateClouds/my-cloud`
   * @param hcxActivationKey Required. The initial description of a new HCX activation key. When
   *     creating a new key, this field must be an empty object.
   * @param hcxActivationKeyId Required. The user-provided identifier of the `HcxActivationKey` to
   *     be created. This identifier must be unique among `HcxActivationKey` resources within the
   *     parent and becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<HcxActivationKey, OperationMetadata> createHcxActivationKeyAsync(
      String parent, HcxActivationKey hcxActivationKey, String hcxActivationKeyId) {
    CreateHcxActivationKeyRequest request =
        CreateHcxActivationKeyRequest.newBuilder()
            .setParent(parent)
            .setHcxActivationKey(hcxActivationKey)
            .setHcxActivationKeyId(hcxActivationKeyId)
            .build();
    return createHcxActivationKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HCX activation key in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateHcxActivationKeyRequest request =
   *       CreateHcxActivationKeyRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setHcxActivationKey(HcxActivationKey.newBuilder().build())
   *           .setHcxActivationKeyId("hcxActivationKeyId-645871673")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   HcxActivationKey response = vmwareEngineClient.createHcxActivationKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<HcxActivationKey, OperationMetadata> createHcxActivationKeyAsync(
      CreateHcxActivationKeyRequest request) {
    return createHcxActivationKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HCX activation key in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateHcxActivationKeyRequest request =
   *       CreateHcxActivationKeyRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setHcxActivationKey(HcxActivationKey.newBuilder().build())
   *           .setHcxActivationKeyId("hcxActivationKeyId-645871673")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<HcxActivationKey, OperationMetadata> future =
   *       vmwareEngineClient.createHcxActivationKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   HcxActivationKey response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
      createHcxActivationKeyOperationCallable() {
    return stub.createHcxActivationKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HCX activation key in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateHcxActivationKeyRequest request =
   *       CreateHcxActivationKeyRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setHcxActivationKey(HcxActivationKey.newBuilder().build())
   *           .setHcxActivationKeyId("hcxActivationKeyId-645871673")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.createHcxActivationKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateHcxActivationKeyRequest, Operation>
      createHcxActivationKeyCallable() {
    return stub.createHcxActivationKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `HcxActivationKey` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   for (HcxActivationKey element :
   *       vmwareEngineClient.listHcxActivationKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for HCX activation
   *     keys. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHcxActivationKeysPagedResponse listHcxActivationKeys(PrivateCloudName parent) {
    ListHcxActivationKeysRequest request =
        ListHcxActivationKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listHcxActivationKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `HcxActivationKey` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   for (HcxActivationKey element :
   *       vmwareEngineClient.listHcxActivationKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for HCX activation
   *     keys. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHcxActivationKeysPagedResponse listHcxActivationKeys(String parent) {
    ListHcxActivationKeysRequest request =
        ListHcxActivationKeysRequest.newBuilder().setParent(parent).build();
    return listHcxActivationKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `HcxActivationKey` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListHcxActivationKeysRequest request =
   *       ListHcxActivationKeysRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (HcxActivationKey element :
   *       vmwareEngineClient.listHcxActivationKeys(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHcxActivationKeysPagedResponse listHcxActivationKeys(
      ListHcxActivationKeysRequest request) {
    return listHcxActivationKeysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `HcxActivationKey` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListHcxActivationKeysRequest request =
   *       ListHcxActivationKeysRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<HcxActivationKey> future =
   *       vmwareEngineClient.listHcxActivationKeysPagedCallable().futureCall(request);
   *   // Do something.
   *   for (HcxActivationKey element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHcxActivationKeysRequest, ListHcxActivationKeysPagedResponse>
      listHcxActivationKeysPagedCallable() {
    return stub.listHcxActivationKeysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `HcxActivationKey` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListHcxActivationKeysRequest request =
   *       ListHcxActivationKeysRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListHcxActivationKeysResponse response =
   *         vmwareEngineClient.listHcxActivationKeysCallable().call(request);
   *     for (HcxActivationKey element : response.getHcxActivationKeysList()) {
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
  public final UnaryCallable<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>
      listHcxActivationKeysCallable() {
    return stub.listHcxActivationKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `HcxActivationKey` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   HcxActivationKeyName name =
   *       HcxActivationKeyName.of(
   *           "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]");
   *   HcxActivationKey response = vmwareEngineClient.getHcxActivationKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the HCX activation key to retrieve. Resource names
   *     are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/privateClouds/my-cloud/hcxActivationKeys/my-key`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HcxActivationKey getHcxActivationKey(HcxActivationKeyName name) {
    GetHcxActivationKeyRequest request =
        GetHcxActivationKeyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getHcxActivationKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `HcxActivationKey` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       HcxActivationKeyName.of(
   *               "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]")
   *           .toString();
   *   HcxActivationKey response = vmwareEngineClient.getHcxActivationKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the HCX activation key to retrieve. Resource names
   *     are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/privateClouds/my-cloud/hcxActivationKeys/my-key`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HcxActivationKey getHcxActivationKey(String name) {
    GetHcxActivationKeyRequest request =
        GetHcxActivationKeyRequest.newBuilder().setName(name).build();
    return getHcxActivationKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `HcxActivationKey` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetHcxActivationKeyRequest request =
   *       GetHcxActivationKeyRequest.newBuilder()
   *           .setName(
   *               HcxActivationKeyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]")
   *                   .toString())
   *           .build();
   *   HcxActivationKey response = vmwareEngineClient.getHcxActivationKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HcxActivationKey getHcxActivationKey(GetHcxActivationKeyRequest request) {
    return getHcxActivationKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `HcxActivationKey` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetHcxActivationKeyRequest request =
   *       GetHcxActivationKeyRequest.newBuilder()
   *           .setName(
   *               HcxActivationKeyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<HcxActivationKey> future =
   *       vmwareEngineClient.getHcxActivationKeyCallable().futureCall(request);
   *   // Do something.
   *   HcxActivationKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHcxActivationKeyRequest, HcxActivationKey>
      getHcxActivationKeyCallable() {
    return stub.getHcxActivationKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `NetworkPolicy` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   NetworkPolicyName name = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");
   *   NetworkPolicy response = vmwareEngineClient.getNetworkPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the network policy to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-network-policy`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkPolicy getNetworkPolicy(NetworkPolicyName name) {
    GetNetworkPolicyRequest request =
        GetNetworkPolicyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getNetworkPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `NetworkPolicy` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString();
   *   NetworkPolicy response = vmwareEngineClient.getNetworkPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the network policy to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-network-policy`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkPolicy getNetworkPolicy(String name) {
    GetNetworkPolicyRequest request = GetNetworkPolicyRequest.newBuilder().setName(name).build();
    return getNetworkPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `NetworkPolicy` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetNetworkPolicyRequest request =
   *       GetNetworkPolicyRequest.newBuilder()
   *           .setName(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .build();
   *   NetworkPolicy response = vmwareEngineClient.getNetworkPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkPolicy getNetworkPolicy(GetNetworkPolicyRequest request) {
    return getNetworkPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `NetworkPolicy` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetNetworkPolicyRequest request =
   *       GetNetworkPolicyRequest.newBuilder()
   *           .setName(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .build();
   *   ApiFuture<NetworkPolicy> future =
   *       vmwareEngineClient.getNetworkPolicyCallable().futureCall(request);
   *   // Do something.
   *   NetworkPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNetworkPolicyRequest, NetworkPolicy> getNetworkPolicyCallable() {
    return stub.getNetworkPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NetworkPolicy` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (NetworkPolicy element : vmwareEngineClient.listNetworkPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location (region) to query for network
   *     policies. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkPoliciesPagedResponse listNetworkPolicies(LocationName parent) {
    ListNetworkPoliciesRequest request =
        ListNetworkPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNetworkPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NetworkPolicy` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (NetworkPolicy element : vmwareEngineClient.listNetworkPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location (region) to query for network
   *     policies. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkPoliciesPagedResponse listNetworkPolicies(String parent) {
    ListNetworkPoliciesRequest request =
        ListNetworkPoliciesRequest.newBuilder().setParent(parent).build();
    return listNetworkPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NetworkPolicy` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNetworkPoliciesRequest request =
   *       ListNetworkPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (NetworkPolicy element : vmwareEngineClient.listNetworkPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkPoliciesPagedResponse listNetworkPolicies(
      ListNetworkPoliciesRequest request) {
    return listNetworkPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NetworkPolicy` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNetworkPoliciesRequest request =
   *       ListNetworkPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<NetworkPolicy> future =
   *       vmwareEngineClient.listNetworkPoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NetworkPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNetworkPoliciesRequest, ListNetworkPoliciesPagedResponse>
      listNetworkPoliciesPagedCallable() {
    return stub.listNetworkPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NetworkPolicy` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNetworkPoliciesRequest request =
   *       ListNetworkPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListNetworkPoliciesResponse response =
   *         vmwareEngineClient.listNetworkPoliciesCallable().call(request);
   *     for (NetworkPolicy element : response.getNetworkPoliciesList()) {
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
  public final UnaryCallable<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>
      listNetworkPoliciesCallable() {
    return stub.listNetworkPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network policy in a given VMware Engine network of a project and location
   * (region). A new network policy cannot be created if another network policy already exists in
   * the same scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
   *   String networkPolicyId = "networkPolicyId-727262661";
   *   NetworkPolicy response =
   *       vmwareEngineClient.createNetworkPolicyAsync(parent, networkPolicy, networkPolicyId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location (region) to create the new network
   *     policy in. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1`
   * @param networkPolicy Required. The network policy configuration to use in the request.
   * @param networkPolicyId Required. The user-provided identifier of the network policy to be
   *     created. This identifier must be unique within parent
   *     `projects/{my-project}/locations/{us-central1}/networkPolicies` and becomes the final token
   *     in the name URI. The identifier must meet the following requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NetworkPolicy, OperationMetadata> createNetworkPolicyAsync(
      LocationName parent, NetworkPolicy networkPolicy, String networkPolicyId) {
    CreateNetworkPolicyRequest request =
        CreateNetworkPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNetworkPolicy(networkPolicy)
            .setNetworkPolicyId(networkPolicyId)
            .build();
    return createNetworkPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network policy in a given VMware Engine network of a project and location
   * (region). A new network policy cannot be created if another network policy already exists in
   * the same scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
   *   String networkPolicyId = "networkPolicyId-727262661";
   *   NetworkPolicy response =
   *       vmwareEngineClient.createNetworkPolicyAsync(parent, networkPolicy, networkPolicyId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location (region) to create the new network
   *     policy in. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1`
   * @param networkPolicy Required. The network policy configuration to use in the request.
   * @param networkPolicyId Required. The user-provided identifier of the network policy to be
   *     created. This identifier must be unique within parent
   *     `projects/{my-project}/locations/{us-central1}/networkPolicies` and becomes the final token
   *     in the name URI. The identifier must meet the following requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NetworkPolicy, OperationMetadata> createNetworkPolicyAsync(
      String parent, NetworkPolicy networkPolicy, String networkPolicyId) {
    CreateNetworkPolicyRequest request =
        CreateNetworkPolicyRequest.newBuilder()
            .setParent(parent)
            .setNetworkPolicy(networkPolicy)
            .setNetworkPolicyId(networkPolicyId)
            .build();
    return createNetworkPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network policy in a given VMware Engine network of a project and location
   * (region). A new network policy cannot be created if another network policy already exists in
   * the same scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateNetworkPolicyRequest request =
   *       CreateNetworkPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNetworkPolicyId("networkPolicyId-727262661")
   *           .setNetworkPolicy(NetworkPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   NetworkPolicy response = vmwareEngineClient.createNetworkPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NetworkPolicy, OperationMetadata> createNetworkPolicyAsync(
      CreateNetworkPolicyRequest request) {
    return createNetworkPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network policy in a given VMware Engine network of a project and location
   * (region). A new network policy cannot be created if another network policy already exists in
   * the same scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateNetworkPolicyRequest request =
   *       CreateNetworkPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNetworkPolicyId("networkPolicyId-727262661")
   *           .setNetworkPolicy(NetworkPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<NetworkPolicy, OperationMetadata> future =
   *       vmwareEngineClient.createNetworkPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   NetworkPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      createNetworkPolicyOperationCallable() {
    return stub.createNetworkPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network policy in a given VMware Engine network of a project and location
   * (region). A new network policy cannot be created if another network policy already exists in
   * the same scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateNetworkPolicyRequest request =
   *       CreateNetworkPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNetworkPolicyId("networkPolicyId-727262661")
   *           .setNetworkPolicy(NetworkPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.createNetworkPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateNetworkPolicyRequest, Operation> createNetworkPolicyCallable() {
    return stub.createNetworkPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `NetworkPolicy` resource. Only the following fields can be updated:
   * `internet_access`, `external_ip`, `edge_services_cidr`. Only fields specified in `updateMask`
   * are applied. When updating a network policy, the external IP network service can only be
   * disabled if there are no external IP addresses present in the scope of the policy. Also, a
   * `NetworkService` cannot be updated when `NetworkService.state` is set to `RECONCILING`.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   NetworkPolicy response =
   *       vmwareEngineClient.updateNetworkPolicyAsync(networkPolicy, updateMask).get();
   * }
   * }</pre>
   *
   * @param networkPolicy Required. Network policy description.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `NetworkPolicy` resource by the update. The fields specified in the `update_mask` are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NetworkPolicy, OperationMetadata> updateNetworkPolicyAsync(
      NetworkPolicy networkPolicy, FieldMask updateMask) {
    UpdateNetworkPolicyRequest request =
        UpdateNetworkPolicyRequest.newBuilder()
            .setNetworkPolicy(networkPolicy)
            .setUpdateMask(updateMask)
            .build();
    return updateNetworkPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `NetworkPolicy` resource. Only the following fields can be updated:
   * `internet_access`, `external_ip`, `edge_services_cidr`. Only fields specified in `updateMask`
   * are applied. When updating a network policy, the external IP network service can only be
   * disabled if there are no external IP addresses present in the scope of the policy. Also, a
   * `NetworkService` cannot be updated when `NetworkService.state` is set to `RECONCILING`.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateNetworkPolicyRequest request =
   *       UpdateNetworkPolicyRequest.newBuilder()
   *           .setNetworkPolicy(NetworkPolicy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   NetworkPolicy response = vmwareEngineClient.updateNetworkPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NetworkPolicy, OperationMetadata> updateNetworkPolicyAsync(
      UpdateNetworkPolicyRequest request) {
    return updateNetworkPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `NetworkPolicy` resource. Only the following fields can be updated:
   * `internet_access`, `external_ip`, `edge_services_cidr`. Only fields specified in `updateMask`
   * are applied. When updating a network policy, the external IP network service can only be
   * disabled if there are no external IP addresses present in the scope of the policy. Also, a
   * `NetworkService` cannot be updated when `NetworkService.state` is set to `RECONCILING`.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateNetworkPolicyRequest request =
   *       UpdateNetworkPolicyRequest.newBuilder()
   *           .setNetworkPolicy(NetworkPolicy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<NetworkPolicy, OperationMetadata> future =
   *       vmwareEngineClient.updateNetworkPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   NetworkPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      updateNetworkPolicyOperationCallable() {
    return stub.updateNetworkPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `NetworkPolicy` resource. Only the following fields can be updated:
   * `internet_access`, `external_ip`, `edge_services_cidr`. Only fields specified in `updateMask`
   * are applied. When updating a network policy, the external IP network service can only be
   * disabled if there are no external IP addresses present in the scope of the policy. Also, a
   * `NetworkService` cannot be updated when `NetworkService.state` is set to `RECONCILING`.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateNetworkPolicyRequest request =
   *       UpdateNetworkPolicyRequest.newBuilder()
   *           .setNetworkPolicy(NetworkPolicy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.updateNetworkPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateNetworkPolicyRequest, Operation> updateNetworkPolicyCallable() {
    return stub.updateNetworkPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted when
   * `NetworkService.state` is set to `RECONCILING` for either its external IP or internet access
   * service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   NetworkPolicyName name = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");
   *   vmwareEngineClient.deleteNetworkPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the network policy to delete. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-network-policy`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteNetworkPolicyAsync(
      NetworkPolicyName name) {
    DeleteNetworkPolicyRequest request =
        DeleteNetworkPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteNetworkPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted when
   * `NetworkService.state` is set to `RECONCILING` for either its external IP or internet access
   * service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString();
   *   vmwareEngineClient.deleteNetworkPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the network policy to delete. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-network-policy`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteNetworkPolicyAsync(String name) {
    DeleteNetworkPolicyRequest request =
        DeleteNetworkPolicyRequest.newBuilder().setName(name).build();
    return deleteNetworkPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted when
   * `NetworkService.state` is set to `RECONCILING` for either its external IP or internet access
   * service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteNetworkPolicyRequest request =
   *       DeleteNetworkPolicyRequest.newBuilder()
   *           .setName(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmwareEngineClient.deleteNetworkPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteNetworkPolicyAsync(
      DeleteNetworkPolicyRequest request) {
    return deleteNetworkPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted when
   * `NetworkService.state` is set to `RECONCILING` for either its external IP or internet access
   * service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteNetworkPolicyRequest request =
   *       DeleteNetworkPolicyRequest.newBuilder()
   *           .setName(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmwareEngineClient.deleteNetworkPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteNetworkPolicyRequest, Empty, OperationMetadata>
      deleteNetworkPolicyOperationCallable() {
    return stub.deleteNetworkPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted when
   * `NetworkService.state` is set to `RECONCILING` for either its external IP or internet access
   * service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteNetworkPolicyRequest request =
   *       DeleteNetworkPolicyRequest.newBuilder()
   *           .setName(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.deleteNetworkPolicyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNetworkPolicyRequest, Operation> deleteNetworkPolicyCallable() {
    return stub.deleteNetworkPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Consumer VPCs bound to Management DNS Zone of a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   for (ManagementDnsZoneBinding element :
   *       vmwareEngineClient.listManagementDnsZoneBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for management DNS
   *     zone bindings. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListManagementDnsZoneBindingsPagedResponse listManagementDnsZoneBindings(
      PrivateCloudName parent) {
    ListManagementDnsZoneBindingsRequest request =
        ListManagementDnsZoneBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listManagementDnsZoneBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Consumer VPCs bound to Management DNS Zone of a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   for (ManagementDnsZoneBinding element :
   *       vmwareEngineClient.listManagementDnsZoneBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for management DNS
   *     zone bindings. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListManagementDnsZoneBindingsPagedResponse listManagementDnsZoneBindings(
      String parent) {
    ListManagementDnsZoneBindingsRequest request =
        ListManagementDnsZoneBindingsRequest.newBuilder().setParent(parent).build();
    return listManagementDnsZoneBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Consumer VPCs bound to Management DNS Zone of a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListManagementDnsZoneBindingsRequest request =
   *       ListManagementDnsZoneBindingsRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ManagementDnsZoneBinding element :
   *       vmwareEngineClient.listManagementDnsZoneBindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListManagementDnsZoneBindingsPagedResponse listManagementDnsZoneBindings(
      ListManagementDnsZoneBindingsRequest request) {
    return listManagementDnsZoneBindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Consumer VPCs bound to Management DNS Zone of a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListManagementDnsZoneBindingsRequest request =
   *       ListManagementDnsZoneBindingsRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ManagementDnsZoneBinding> future =
   *       vmwareEngineClient.listManagementDnsZoneBindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ManagementDnsZoneBinding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsPagedResponse>
      listManagementDnsZoneBindingsPagedCallable() {
    return stub.listManagementDnsZoneBindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Consumer VPCs bound to Management DNS Zone of a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListManagementDnsZoneBindingsRequest request =
   *       ListManagementDnsZoneBindingsRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListManagementDnsZoneBindingsResponse response =
   *         vmwareEngineClient.listManagementDnsZoneBindingsCallable().call(request);
   *     for (ManagementDnsZoneBinding element : response.getManagementDnsZoneBindingsList()) {
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
  public final UnaryCallable<
          ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsResponse>
      listManagementDnsZoneBindingsCallable() {
    return stub.listManagementDnsZoneBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a 'ManagementDnsZoneBinding' resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ManagementDnsZoneBindingName name =
   *       ManagementDnsZoneBindingName.of(
   *           "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[MANAGEMENT_DNS_ZONE_BINDING]");
   *   ManagementDnsZoneBinding response = vmwareEngineClient.getManagementDnsZoneBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the management DNS zone binding to retrieve.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/managementDnsZoneBindings/my-management-dns-zone-binding`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ManagementDnsZoneBinding getManagementDnsZoneBinding(
      ManagementDnsZoneBindingName name) {
    GetManagementDnsZoneBindingRequest request =
        GetManagementDnsZoneBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getManagementDnsZoneBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a 'ManagementDnsZoneBinding' resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       ManagementDnsZoneBindingName.of(
   *               "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[MANAGEMENT_DNS_ZONE_BINDING]")
   *           .toString();
   *   ManagementDnsZoneBinding response = vmwareEngineClient.getManagementDnsZoneBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the management DNS zone binding to retrieve.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/managementDnsZoneBindings/my-management-dns-zone-binding`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ManagementDnsZoneBinding getManagementDnsZoneBinding(String name) {
    GetManagementDnsZoneBindingRequest request =
        GetManagementDnsZoneBindingRequest.newBuilder().setName(name).build();
    return getManagementDnsZoneBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a 'ManagementDnsZoneBinding' resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetManagementDnsZoneBindingRequest request =
   *       GetManagementDnsZoneBindingRequest.newBuilder()
   *           .setName(
   *               ManagementDnsZoneBindingName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[PRIVATE_CLOUD]",
   *                       "[MANAGEMENT_DNS_ZONE_BINDING]")
   *                   .toString())
   *           .build();
   *   ManagementDnsZoneBinding response = vmwareEngineClient.getManagementDnsZoneBinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ManagementDnsZoneBinding getManagementDnsZoneBinding(
      GetManagementDnsZoneBindingRequest request) {
    return getManagementDnsZoneBindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a 'ManagementDnsZoneBinding' resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetManagementDnsZoneBindingRequest request =
   *       GetManagementDnsZoneBindingRequest.newBuilder()
   *           .setName(
   *               ManagementDnsZoneBindingName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[PRIVATE_CLOUD]",
   *                       "[MANAGEMENT_DNS_ZONE_BINDING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ManagementDnsZoneBinding> future =
   *       vmwareEngineClient.getManagementDnsZoneBindingCallable().futureCall(request);
   *   // Do something.
   *   ManagementDnsZoneBinding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>
      getManagementDnsZoneBindingCallable() {
    return stub.getManagementDnsZoneBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `ManagementDnsZoneBinding` resource in a private cloud. This RPC creates the DNS
   * binding and the resource that represents the DNS binding of the consumer VPC network to the
   * management DNS zone. A management DNS zone is the Cloud DNS cross-project binding zone that
   * VMware Engine creates for each private cloud. It contains FQDNs and corresponding IP addresses
   * for the private cloud's ESXi hosts and management VM appliances like vCenter and NSX Manager.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   ManagementDnsZoneBinding managementDnsZoneBinding =
   *       ManagementDnsZoneBinding.newBuilder().build();
   *   String managementDnsZoneBindingId = "managementDnsZoneBindingId-288984082";
   *   ManagementDnsZoneBinding response =
   *       vmwareEngineClient
   *           .createManagementDnsZoneBindingAsync(
   *               parent, managementDnsZoneBinding, managementDnsZoneBindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to create a new management DNS
   *     zone binding for. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @param managementDnsZoneBinding Required. The initial values for a new management DNS zone
   *     binding.
   * @param managementDnsZoneBindingId Required. The user-provided identifier of the
   *     `ManagementDnsZoneBinding` resource to be created. This identifier must be unique among
   *     `ManagementDnsZoneBinding` resources within the parent and becomes the final token in the
   *     name URI. The identifier must meet the following requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ManagementDnsZoneBinding, OperationMetadata>
      createManagementDnsZoneBindingAsync(
          PrivateCloudName parent,
          ManagementDnsZoneBinding managementDnsZoneBinding,
          String managementDnsZoneBindingId) {
    CreateManagementDnsZoneBindingRequest request =
        CreateManagementDnsZoneBindingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setManagementDnsZoneBinding(managementDnsZoneBinding)
            .setManagementDnsZoneBindingId(managementDnsZoneBindingId)
            .build();
    return createManagementDnsZoneBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `ManagementDnsZoneBinding` resource in a private cloud. This RPC creates the DNS
   * binding and the resource that represents the DNS binding of the consumer VPC network to the
   * management DNS zone. A management DNS zone is the Cloud DNS cross-project binding zone that
   * VMware Engine creates for each private cloud. It contains FQDNs and corresponding IP addresses
   * for the private cloud's ESXi hosts and management VM appliances like vCenter and NSX Manager.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   ManagementDnsZoneBinding managementDnsZoneBinding =
   *       ManagementDnsZoneBinding.newBuilder().build();
   *   String managementDnsZoneBindingId = "managementDnsZoneBindingId-288984082";
   *   ManagementDnsZoneBinding response =
   *       vmwareEngineClient
   *           .createManagementDnsZoneBindingAsync(
   *               parent, managementDnsZoneBinding, managementDnsZoneBindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to create a new management DNS
   *     zone binding for. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @param managementDnsZoneBinding Required. The initial values for a new management DNS zone
   *     binding.
   * @param managementDnsZoneBindingId Required. The user-provided identifier of the
   *     `ManagementDnsZoneBinding` resource to be created. This identifier must be unique among
   *     `ManagementDnsZoneBinding` resources within the parent and becomes the final token in the
   *     name URI. The identifier must meet the following requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ManagementDnsZoneBinding, OperationMetadata>
      createManagementDnsZoneBindingAsync(
          String parent,
          ManagementDnsZoneBinding managementDnsZoneBinding,
          String managementDnsZoneBindingId) {
    CreateManagementDnsZoneBindingRequest request =
        CreateManagementDnsZoneBindingRequest.newBuilder()
            .setParent(parent)
            .setManagementDnsZoneBinding(managementDnsZoneBinding)
            .setManagementDnsZoneBindingId(managementDnsZoneBindingId)
            .build();
    return createManagementDnsZoneBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `ManagementDnsZoneBinding` resource in a private cloud. This RPC creates the DNS
   * binding and the resource that represents the DNS binding of the consumer VPC network to the
   * management DNS zone. A management DNS zone is the Cloud DNS cross-project binding zone that
   * VMware Engine creates for each private cloud. It contains FQDNs and corresponding IP addresses
   * for the private cloud's ESXi hosts and management VM appliances like vCenter and NSX Manager.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateManagementDnsZoneBindingRequest request =
   *       CreateManagementDnsZoneBindingRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setManagementDnsZoneBinding(ManagementDnsZoneBinding.newBuilder().build())
   *           .setManagementDnsZoneBindingId("managementDnsZoneBindingId-288984082")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ManagementDnsZoneBinding response =
   *       vmwareEngineClient.createManagementDnsZoneBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ManagementDnsZoneBinding, OperationMetadata>
      createManagementDnsZoneBindingAsync(CreateManagementDnsZoneBindingRequest request) {
    return createManagementDnsZoneBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `ManagementDnsZoneBinding` resource in a private cloud. This RPC creates the DNS
   * binding and the resource that represents the DNS binding of the consumer VPC network to the
   * management DNS zone. A management DNS zone is the Cloud DNS cross-project binding zone that
   * VMware Engine creates for each private cloud. It contains FQDNs and corresponding IP addresses
   * for the private cloud's ESXi hosts and management VM appliances like vCenter and NSX Manager.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateManagementDnsZoneBindingRequest request =
   *       CreateManagementDnsZoneBindingRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setManagementDnsZoneBinding(ManagementDnsZoneBinding.newBuilder().build())
   *           .setManagementDnsZoneBindingId("managementDnsZoneBindingId-288984082")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ManagementDnsZoneBinding, OperationMetadata> future =
   *       vmwareEngineClient.createManagementDnsZoneBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   ManagementDnsZoneBinding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      createManagementDnsZoneBindingOperationCallable() {
    return stub.createManagementDnsZoneBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `ManagementDnsZoneBinding` resource in a private cloud. This RPC creates the DNS
   * binding and the resource that represents the DNS binding of the consumer VPC network to the
   * management DNS zone. A management DNS zone is the Cloud DNS cross-project binding zone that
   * VMware Engine creates for each private cloud. It contains FQDNs and corresponding IP addresses
   * for the private cloud's ESXi hosts and management VM appliances like vCenter and NSX Manager.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateManagementDnsZoneBindingRequest request =
   *       CreateManagementDnsZoneBindingRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setManagementDnsZoneBinding(ManagementDnsZoneBinding.newBuilder().build())
   *           .setManagementDnsZoneBindingId("managementDnsZoneBindingId-288984082")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.createManagementDnsZoneBindingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateManagementDnsZoneBindingRequest, Operation>
      createManagementDnsZoneBindingCallable() {
    return stub.createManagementDnsZoneBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `ManagementDnsZoneBinding` resource. Only fields specified in `update_mask` are
   * applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ManagementDnsZoneBinding managementDnsZoneBinding =
   *       ManagementDnsZoneBinding.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ManagementDnsZoneBinding response =
   *       vmwareEngineClient
   *           .updateManagementDnsZoneBindingAsync(managementDnsZoneBinding, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param managementDnsZoneBinding Required. New values to update the management DNS zone binding
   *     with.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `ManagementDnsZoneBinding` resource by the update. The fields specified in the
   *     `update_mask` are relative to the resource, not the full request. A field will be
   *     overwritten if it is in the mask. If the user does not provide a mask then all fields will
   *     be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ManagementDnsZoneBinding, OperationMetadata>
      updateManagementDnsZoneBindingAsync(
          ManagementDnsZoneBinding managementDnsZoneBinding, FieldMask updateMask) {
    UpdateManagementDnsZoneBindingRequest request =
        UpdateManagementDnsZoneBindingRequest.newBuilder()
            .setManagementDnsZoneBinding(managementDnsZoneBinding)
            .setUpdateMask(updateMask)
            .build();
    return updateManagementDnsZoneBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `ManagementDnsZoneBinding` resource. Only fields specified in `update_mask` are
   * applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateManagementDnsZoneBindingRequest request =
   *       UpdateManagementDnsZoneBindingRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setManagementDnsZoneBinding(ManagementDnsZoneBinding.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ManagementDnsZoneBinding response =
   *       vmwareEngineClient.updateManagementDnsZoneBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ManagementDnsZoneBinding, OperationMetadata>
      updateManagementDnsZoneBindingAsync(UpdateManagementDnsZoneBindingRequest request) {
    return updateManagementDnsZoneBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `ManagementDnsZoneBinding` resource. Only fields specified in `update_mask` are
   * applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateManagementDnsZoneBindingRequest request =
   *       UpdateManagementDnsZoneBindingRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setManagementDnsZoneBinding(ManagementDnsZoneBinding.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ManagementDnsZoneBinding, OperationMetadata> future =
   *       vmwareEngineClient.updateManagementDnsZoneBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   ManagementDnsZoneBinding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      updateManagementDnsZoneBindingOperationCallable() {
    return stub.updateManagementDnsZoneBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `ManagementDnsZoneBinding` resource. Only fields specified in `update_mask` are
   * applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateManagementDnsZoneBindingRequest request =
   *       UpdateManagementDnsZoneBindingRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setManagementDnsZoneBinding(ManagementDnsZoneBinding.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.updateManagementDnsZoneBindingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateManagementDnsZoneBindingRequest, Operation>
      updateManagementDnsZoneBindingCallable() {
    return stub.updateManagementDnsZoneBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `ManagementDnsZoneBinding` resource. When a management DNS zone binding is deleted,
   * the corresponding consumer VPC network is no longer bound to the management DNS zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ManagementDnsZoneBindingName name =
   *       ManagementDnsZoneBindingName.of(
   *           "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[MANAGEMENT_DNS_ZONE_BINDING]");
   *   vmwareEngineClient.deleteManagementDnsZoneBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the management DNS zone binding to delete. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/managementDnsZoneBindings/my-management-dns-zone-binding`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteManagementDnsZoneBindingAsync(
      ManagementDnsZoneBindingName name) {
    DeleteManagementDnsZoneBindingRequest request =
        DeleteManagementDnsZoneBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteManagementDnsZoneBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `ManagementDnsZoneBinding` resource. When a management DNS zone binding is deleted,
   * the corresponding consumer VPC network is no longer bound to the management DNS zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       ManagementDnsZoneBindingName.of(
   *               "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[MANAGEMENT_DNS_ZONE_BINDING]")
   *           .toString();
   *   vmwareEngineClient.deleteManagementDnsZoneBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the management DNS zone binding to delete. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/managementDnsZoneBindings/my-management-dns-zone-binding`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteManagementDnsZoneBindingAsync(
      String name) {
    DeleteManagementDnsZoneBindingRequest request =
        DeleteManagementDnsZoneBindingRequest.newBuilder().setName(name).build();
    return deleteManagementDnsZoneBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `ManagementDnsZoneBinding` resource. When a management DNS zone binding is deleted,
   * the corresponding consumer VPC network is no longer bound to the management DNS zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteManagementDnsZoneBindingRequest request =
   *       DeleteManagementDnsZoneBindingRequest.newBuilder()
   *           .setName(
   *               ManagementDnsZoneBindingName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[PRIVATE_CLOUD]",
   *                       "[MANAGEMENT_DNS_ZONE_BINDING]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmwareEngineClient.deleteManagementDnsZoneBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteManagementDnsZoneBindingAsync(
      DeleteManagementDnsZoneBindingRequest request) {
    return deleteManagementDnsZoneBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `ManagementDnsZoneBinding` resource. When a management DNS zone binding is deleted,
   * the corresponding consumer VPC network is no longer bound to the management DNS zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteManagementDnsZoneBindingRequest request =
   *       DeleteManagementDnsZoneBindingRequest.newBuilder()
   *           .setName(
   *               ManagementDnsZoneBindingName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[PRIVATE_CLOUD]",
   *                       "[MANAGEMENT_DNS_ZONE_BINDING]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmwareEngineClient.deleteManagementDnsZoneBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteManagementDnsZoneBindingRequest, Empty, OperationMetadata>
      deleteManagementDnsZoneBindingOperationCallable() {
    return stub.deleteManagementDnsZoneBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `ManagementDnsZoneBinding` resource. When a management DNS zone binding is deleted,
   * the corresponding consumer VPC network is no longer bound to the management DNS zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteManagementDnsZoneBindingRequest request =
   *       DeleteManagementDnsZoneBindingRequest.newBuilder()
   *           .setName(
   *               ManagementDnsZoneBindingName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[PRIVATE_CLOUD]",
   *                       "[MANAGEMENT_DNS_ZONE_BINDING]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.deleteManagementDnsZoneBindingCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteManagementDnsZoneBindingRequest, Operation>
      deleteManagementDnsZoneBindingCallable() {
    return stub.deleteManagementDnsZoneBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retries to create a `ManagementDnsZoneBinding` resource that is in failed state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ManagementDnsZoneBindingName name =
   *       ManagementDnsZoneBindingName.of(
   *           "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[MANAGEMENT_DNS_ZONE_BINDING]");
   *   ManagementDnsZoneBinding response =
   *       vmwareEngineClient.repairManagementDnsZoneBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the management DNS zone binding to repair. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/managementDnsZoneBindings/my-management-dns-zone-binding`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ManagementDnsZoneBinding, OperationMetadata>
      repairManagementDnsZoneBindingAsync(ManagementDnsZoneBindingName name) {
    RepairManagementDnsZoneBindingRequest request =
        RepairManagementDnsZoneBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return repairManagementDnsZoneBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retries to create a `ManagementDnsZoneBinding` resource that is in failed state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       ManagementDnsZoneBindingName.of(
   *               "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[MANAGEMENT_DNS_ZONE_BINDING]")
   *           .toString();
   *   ManagementDnsZoneBinding response =
   *       vmwareEngineClient.repairManagementDnsZoneBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the management DNS zone binding to repair. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/managementDnsZoneBindings/my-management-dns-zone-binding`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ManagementDnsZoneBinding, OperationMetadata>
      repairManagementDnsZoneBindingAsync(String name) {
    RepairManagementDnsZoneBindingRequest request =
        RepairManagementDnsZoneBindingRequest.newBuilder().setName(name).build();
    return repairManagementDnsZoneBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retries to create a `ManagementDnsZoneBinding` resource that is in failed state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   RepairManagementDnsZoneBindingRequest request =
   *       RepairManagementDnsZoneBindingRequest.newBuilder()
   *           .setName(
   *               ManagementDnsZoneBindingName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[PRIVATE_CLOUD]",
   *                       "[MANAGEMENT_DNS_ZONE_BINDING]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ManagementDnsZoneBinding response =
   *       vmwareEngineClient.repairManagementDnsZoneBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ManagementDnsZoneBinding, OperationMetadata>
      repairManagementDnsZoneBindingAsync(RepairManagementDnsZoneBindingRequest request) {
    return repairManagementDnsZoneBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retries to create a `ManagementDnsZoneBinding` resource that is in failed state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   RepairManagementDnsZoneBindingRequest request =
   *       RepairManagementDnsZoneBindingRequest.newBuilder()
   *           .setName(
   *               ManagementDnsZoneBindingName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[PRIVATE_CLOUD]",
   *                       "[MANAGEMENT_DNS_ZONE_BINDING]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ManagementDnsZoneBinding, OperationMetadata> future =
   *       vmwareEngineClient.repairManagementDnsZoneBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   ManagementDnsZoneBinding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RepairManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      repairManagementDnsZoneBindingOperationCallable() {
    return stub.repairManagementDnsZoneBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retries to create a `ManagementDnsZoneBinding` resource that is in failed state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   RepairManagementDnsZoneBindingRequest request =
   *       RepairManagementDnsZoneBindingRequest.newBuilder()
   *           .setName(
   *               ManagementDnsZoneBindingName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[PRIVATE_CLOUD]",
   *                       "[MANAGEMENT_DNS_ZONE_BINDING]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.repairManagementDnsZoneBindingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RepairManagementDnsZoneBindingRequest, Operation>
      repairManagementDnsZoneBindingCallable() {
    return stub.repairManagementDnsZoneBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new VMware Engine network that can be used by a private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   VmwareEngineNetwork vmwareEngineNetwork = VmwareEngineNetwork.newBuilder().build();
   *   String vmwareEngineNetworkId = "vmwareEngineNetworkId532532083";
   *   VmwareEngineNetwork response =
   *       vmwareEngineClient
   *           .createVmwareEngineNetworkAsync(parent, vmwareEngineNetwork, vmwareEngineNetworkId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to create the new VMware Engine
   *     network in. A VMware Engine network of type `LEGACY` is a regional resource, and a VMware
   *     Engine network of type `STANDARD` is a global resource. Resource names are schemeless URIs
   *     that follow the conventions in https://cloud.google.com/apis/design/resource_names. For
   *     example: `projects/my-project/locations/global`
   * @param vmwareEngineNetwork Required. The initial description of the new VMware Engine network.
   * @param vmwareEngineNetworkId Required. The user-provided identifier of the new VMware Engine
   *     network. This identifier must be unique among VMware Engine network resources within the
   *     parent and becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>For networks of type LEGACY, adheres to the format: `{region-id}-default`. Replace
   *           `{region-id}` with the region where you want to create the VMware Engine network. For
   *           example, "us-central1-default".
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkAsync(
          LocationName parent,
          VmwareEngineNetwork vmwareEngineNetwork,
          String vmwareEngineNetworkId) {
    CreateVmwareEngineNetworkRequest request =
        CreateVmwareEngineNetworkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setVmwareEngineNetwork(vmwareEngineNetwork)
            .setVmwareEngineNetworkId(vmwareEngineNetworkId)
            .build();
    return createVmwareEngineNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new VMware Engine network that can be used by a private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   VmwareEngineNetwork vmwareEngineNetwork = VmwareEngineNetwork.newBuilder().build();
   *   String vmwareEngineNetworkId = "vmwareEngineNetworkId532532083";
   *   VmwareEngineNetwork response =
   *       vmwareEngineClient
   *           .createVmwareEngineNetworkAsync(parent, vmwareEngineNetwork, vmwareEngineNetworkId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to create the new VMware Engine
   *     network in. A VMware Engine network of type `LEGACY` is a regional resource, and a VMware
   *     Engine network of type `STANDARD` is a global resource. Resource names are schemeless URIs
   *     that follow the conventions in https://cloud.google.com/apis/design/resource_names. For
   *     example: `projects/my-project/locations/global`
   * @param vmwareEngineNetwork Required. The initial description of the new VMware Engine network.
   * @param vmwareEngineNetworkId Required. The user-provided identifier of the new VMware Engine
   *     network. This identifier must be unique among VMware Engine network resources within the
   *     parent and becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>For networks of type LEGACY, adheres to the format: `{region-id}-default`. Replace
   *           `{region-id}` with the region where you want to create the VMware Engine network. For
   *           example, "us-central1-default".
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkAsync(
          String parent, VmwareEngineNetwork vmwareEngineNetwork, String vmwareEngineNetworkId) {
    CreateVmwareEngineNetworkRequest request =
        CreateVmwareEngineNetworkRequest.newBuilder()
            .setParent(parent)
            .setVmwareEngineNetwork(vmwareEngineNetwork)
            .setVmwareEngineNetworkId(vmwareEngineNetworkId)
            .build();
    return createVmwareEngineNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new VMware Engine network that can be used by a private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateVmwareEngineNetworkRequest request =
   *       CreateVmwareEngineNetworkRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVmwareEngineNetworkId("vmwareEngineNetworkId532532083")
   *           .setVmwareEngineNetwork(VmwareEngineNetwork.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   VmwareEngineNetwork response =
   *       vmwareEngineClient.createVmwareEngineNetworkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkAsync(CreateVmwareEngineNetworkRequest request) {
    return createVmwareEngineNetworkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new VMware Engine network that can be used by a private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateVmwareEngineNetworkRequest request =
   *       CreateVmwareEngineNetworkRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVmwareEngineNetworkId("vmwareEngineNetworkId532532083")
   *           .setVmwareEngineNetwork(VmwareEngineNetwork.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<VmwareEngineNetwork, OperationMetadata> future =
   *       vmwareEngineClient.createVmwareEngineNetworkOperationCallable().futureCall(request);
   *   // Do something.
   *   VmwareEngineNetwork response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkOperationCallable() {
    return stub.createVmwareEngineNetworkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new VMware Engine network that can be used by a private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateVmwareEngineNetworkRequest request =
   *       CreateVmwareEngineNetworkRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVmwareEngineNetworkId("vmwareEngineNetworkId532532083")
   *           .setVmwareEngineNetwork(VmwareEngineNetwork.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.createVmwareEngineNetworkCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateVmwareEngineNetworkRequest, Operation>
      createVmwareEngineNetworkCallable() {
    return stub.createVmwareEngineNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a VMware Engine network resource. Only the following fields can be updated:
   * `description`. Only fields specified in `updateMask` are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   VmwareEngineNetwork vmwareEngineNetwork = VmwareEngineNetwork.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   VmwareEngineNetwork response =
   *       vmwareEngineClient.updateVmwareEngineNetworkAsync(vmwareEngineNetwork, updateMask).get();
   * }
   * }</pre>
   *
   * @param vmwareEngineNetwork Required. VMware Engine network description.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     VMware Engine network resource by the update. The fields specified in the `update_mask` are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten. Only the
   *     following fields can be updated: `description`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VmwareEngineNetwork, OperationMetadata>
      updateVmwareEngineNetworkAsync(
          VmwareEngineNetwork vmwareEngineNetwork, FieldMask updateMask) {
    UpdateVmwareEngineNetworkRequest request =
        UpdateVmwareEngineNetworkRequest.newBuilder()
            .setVmwareEngineNetwork(vmwareEngineNetwork)
            .setUpdateMask(updateMask)
            .build();
    return updateVmwareEngineNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a VMware Engine network resource. Only the following fields can be updated:
   * `description`. Only fields specified in `updateMask` are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateVmwareEngineNetworkRequest request =
   *       UpdateVmwareEngineNetworkRequest.newBuilder()
   *           .setVmwareEngineNetwork(VmwareEngineNetwork.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   VmwareEngineNetwork response =
   *       vmwareEngineClient.updateVmwareEngineNetworkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VmwareEngineNetwork, OperationMetadata>
      updateVmwareEngineNetworkAsync(UpdateVmwareEngineNetworkRequest request) {
    return updateVmwareEngineNetworkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a VMware Engine network resource. Only the following fields can be updated:
   * `description`. Only fields specified in `updateMask` are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateVmwareEngineNetworkRequest request =
   *       UpdateVmwareEngineNetworkRequest.newBuilder()
   *           .setVmwareEngineNetwork(VmwareEngineNetwork.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<VmwareEngineNetwork, OperationMetadata> future =
   *       vmwareEngineClient.updateVmwareEngineNetworkOperationCallable().futureCall(request);
   *   // Do something.
   *   VmwareEngineNetwork response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      updateVmwareEngineNetworkOperationCallable() {
    return stub.updateVmwareEngineNetworkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a VMware Engine network resource. Only the following fields can be updated:
   * `description`. Only fields specified in `updateMask` are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateVmwareEngineNetworkRequest request =
   *       UpdateVmwareEngineNetworkRequest.newBuilder()
   *           .setVmwareEngineNetwork(VmwareEngineNetwork.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.updateVmwareEngineNetworkCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateVmwareEngineNetworkRequest, Operation>
      updateVmwareEngineNetworkCallable() {
    return stub.updateVmwareEngineNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware Engine network after all
   * resources that refer to it are deleted. For example, a private cloud, a network peering, and a
   * network policy can all refer to the same VMware Engine network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   VmwareEngineNetworkName name =
   *       VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]");
   *   vmwareEngineClient.deleteVmwareEngineNetworkAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the VMware Engine network to be deleted. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/vmwareEngineNetworks/my-network`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVmwareEngineNetworkAsync(
      VmwareEngineNetworkName name) {
    DeleteVmwareEngineNetworkRequest request =
        DeleteVmwareEngineNetworkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteVmwareEngineNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware Engine network after all
   * resources that refer to it are deleted. For example, a private cloud, a network peering, and a
   * network policy can all refer to the same VMware Engine network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
   *           .toString();
   *   vmwareEngineClient.deleteVmwareEngineNetworkAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the VMware Engine network to be deleted. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/vmwareEngineNetworks/my-network`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVmwareEngineNetworkAsync(
      String name) {
    DeleteVmwareEngineNetworkRequest request =
        DeleteVmwareEngineNetworkRequest.newBuilder().setName(name).build();
    return deleteVmwareEngineNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware Engine network after all
   * resources that refer to it are deleted. For example, a private cloud, a network peering, and a
   * network policy can all refer to the same VMware Engine network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteVmwareEngineNetworkRequest request =
   *       DeleteVmwareEngineNetworkRequest.newBuilder()
   *           .setName(
   *               VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   vmwareEngineClient.deleteVmwareEngineNetworkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVmwareEngineNetworkAsync(
      DeleteVmwareEngineNetworkRequest request) {
    return deleteVmwareEngineNetworkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware Engine network after all
   * resources that refer to it are deleted. For example, a private cloud, a network peering, and a
   * network policy can all refer to the same VMware Engine network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteVmwareEngineNetworkRequest request =
   *       DeleteVmwareEngineNetworkRequest.newBuilder()
   *           .setName(
   *               VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmwareEngineClient.deleteVmwareEngineNetworkOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
      deleteVmwareEngineNetworkOperationCallable() {
    return stub.deleteVmwareEngineNetworkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware Engine network after all
   * resources that refer to it are deleted. For example, a private cloud, a network peering, and a
   * network policy can all refer to the same VMware Engine network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteVmwareEngineNetworkRequest request =
   *       DeleteVmwareEngineNetworkRequest.newBuilder()
   *           .setName(
   *               VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.deleteVmwareEngineNetworkCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteVmwareEngineNetworkRequest, Operation>
      deleteVmwareEngineNetworkCallable() {
    return stub.deleteVmwareEngineNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `VmwareEngineNetwork` resource by its resource name. The resource contains details
   * of the VMware Engine network, such as its VMware Engine network type, peered networks in a
   * service project, and state (for example, `CREATING`, `ACTIVE`, `DELETING`).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   VmwareEngineNetworkName name =
   *       VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]");
   *   VmwareEngineNetwork response = vmwareEngineClient.getVmwareEngineNetwork(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the VMware Engine network to retrieve. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/vmwareEngineNetworks/my-network`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VmwareEngineNetwork getVmwareEngineNetwork(VmwareEngineNetworkName name) {
    GetVmwareEngineNetworkRequest request =
        GetVmwareEngineNetworkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getVmwareEngineNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `VmwareEngineNetwork` resource by its resource name. The resource contains details
   * of the VMware Engine network, such as its VMware Engine network type, peered networks in a
   * service project, and state (for example, `CREATING`, `ACTIVE`, `DELETING`).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
   *           .toString();
   *   VmwareEngineNetwork response = vmwareEngineClient.getVmwareEngineNetwork(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the VMware Engine network to retrieve. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/vmwareEngineNetworks/my-network`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VmwareEngineNetwork getVmwareEngineNetwork(String name) {
    GetVmwareEngineNetworkRequest request =
        GetVmwareEngineNetworkRequest.newBuilder().setName(name).build();
    return getVmwareEngineNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `VmwareEngineNetwork` resource by its resource name. The resource contains details
   * of the VMware Engine network, such as its VMware Engine network type, peered networks in a
   * service project, and state (for example, `CREATING`, `ACTIVE`, `DELETING`).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetVmwareEngineNetworkRequest request =
   *       GetVmwareEngineNetworkRequest.newBuilder()
   *           .setName(
   *               VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
   *                   .toString())
   *           .build();
   *   VmwareEngineNetwork response = vmwareEngineClient.getVmwareEngineNetwork(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VmwareEngineNetwork getVmwareEngineNetwork(GetVmwareEngineNetworkRequest request) {
    return getVmwareEngineNetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `VmwareEngineNetwork` resource by its resource name. The resource contains details
   * of the VMware Engine network, such as its VMware Engine network type, peered networks in a
   * service project, and state (for example, `CREATING`, `ACTIVE`, `DELETING`).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetVmwareEngineNetworkRequest request =
   *       GetVmwareEngineNetworkRequest.newBuilder()
   *           .setName(
   *               VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<VmwareEngineNetwork> future =
   *       vmwareEngineClient.getVmwareEngineNetworkCallable().futureCall(request);
   *   // Do something.
   *   VmwareEngineNetwork response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
      getVmwareEngineNetworkCallable() {
    return stub.getVmwareEngineNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `VmwareEngineNetwork` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (VmwareEngineNetwork element :
   *       vmwareEngineClient.listVmwareEngineNetworks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to query for VMware Engine networks.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVmwareEngineNetworksPagedResponse listVmwareEngineNetworks(LocationName parent) {
    ListVmwareEngineNetworksRequest request =
        ListVmwareEngineNetworksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVmwareEngineNetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `VmwareEngineNetwork` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (VmwareEngineNetwork element :
   *       vmwareEngineClient.listVmwareEngineNetworks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to query for VMware Engine networks.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVmwareEngineNetworksPagedResponse listVmwareEngineNetworks(String parent) {
    ListVmwareEngineNetworksRequest request =
        ListVmwareEngineNetworksRequest.newBuilder().setParent(parent).build();
    return listVmwareEngineNetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `VmwareEngineNetwork` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListVmwareEngineNetworksRequest request =
   *       ListVmwareEngineNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (VmwareEngineNetwork element :
   *       vmwareEngineClient.listVmwareEngineNetworks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVmwareEngineNetworksPagedResponse listVmwareEngineNetworks(
      ListVmwareEngineNetworksRequest request) {
    return listVmwareEngineNetworksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `VmwareEngineNetwork` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListVmwareEngineNetworksRequest request =
   *       ListVmwareEngineNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<VmwareEngineNetwork> future =
   *       vmwareEngineClient.listVmwareEngineNetworksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VmwareEngineNetwork element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksPagedResponse>
      listVmwareEngineNetworksPagedCallable() {
    return stub.listVmwareEngineNetworksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `VmwareEngineNetwork` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListVmwareEngineNetworksRequest request =
   *       ListVmwareEngineNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListVmwareEngineNetworksResponse response =
   *         vmwareEngineClient.listVmwareEngineNetworksCallable().call(request);
   *     for (VmwareEngineNetwork element : response.getVmwareEngineNetworksList()) {
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
  public final UnaryCallable<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>
      listVmwareEngineNetworksCallable() {
    return stub.listVmwareEngineNetworksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new private connection that can be used for accessing private Clouds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
   *   String privateConnectionId = "privateConnectionId-1926654532";
   *   PrivateConnection response =
   *       vmwareEngineClient
   *           .createPrivateConnectionAsync(parent, privateConnection, privateConnectionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to create the new private connection
   *     in. Private connection is a regional resource. Resource names are schemeless URIs that
   *     follow the conventions in https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1`
   * @param privateConnection Required. The initial description of the new private connection.
   * @param privateConnectionId Required. The user-provided identifier of the new private
   *     connection. This identifier must be unique among private connection resources within the
   *     parent and becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateConnection, OperationMetadata> createPrivateConnectionAsync(
      LocationName parent, PrivateConnection privateConnection, String privateConnectionId) {
    CreatePrivateConnectionRequest request =
        CreatePrivateConnectionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPrivateConnection(privateConnection)
            .setPrivateConnectionId(privateConnectionId)
            .build();
    return createPrivateConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new private connection that can be used for accessing private Clouds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
   *   String privateConnectionId = "privateConnectionId-1926654532";
   *   PrivateConnection response =
   *       vmwareEngineClient
   *           .createPrivateConnectionAsync(parent, privateConnection, privateConnectionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to create the new private connection
   *     in. Private connection is a regional resource. Resource names are schemeless URIs that
   *     follow the conventions in https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1`
   * @param privateConnection Required. The initial description of the new private connection.
   * @param privateConnectionId Required. The user-provided identifier of the new private
   *     connection. This identifier must be unique among private connection resources within the
   *     parent and becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateConnection, OperationMetadata> createPrivateConnectionAsync(
      String parent, PrivateConnection privateConnection, String privateConnectionId) {
    CreatePrivateConnectionRequest request =
        CreatePrivateConnectionRequest.newBuilder()
            .setParent(parent)
            .setPrivateConnection(privateConnection)
            .setPrivateConnectionId(privateConnectionId)
            .build();
    return createPrivateConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new private connection that can be used for accessing private Clouds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreatePrivateConnectionRequest request =
   *       CreatePrivateConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrivateConnectionId("privateConnectionId-1926654532")
   *           .setPrivateConnection(PrivateConnection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   PrivateConnection response = vmwareEngineClient.createPrivateConnectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateConnection, OperationMetadata> createPrivateConnectionAsync(
      CreatePrivateConnectionRequest request) {
    return createPrivateConnectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new private connection that can be used for accessing private Clouds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreatePrivateConnectionRequest request =
   *       CreatePrivateConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrivateConnectionId("privateConnectionId-1926654532")
   *           .setPrivateConnection(PrivateConnection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<PrivateConnection, OperationMetadata> future =
   *       vmwareEngineClient.createPrivateConnectionOperationCallable().futureCall(request);
   *   // Do something.
   *   PrivateConnection response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationCallable() {
    return stub.createPrivateConnectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new private connection that can be used for accessing private Clouds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreatePrivateConnectionRequest request =
   *       CreatePrivateConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrivateConnectionId("privateConnectionId-1926654532")
   *           .setPrivateConnection(PrivateConnection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.createPrivateConnectionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionCallable() {
    return stub.createPrivateConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `PrivateConnection` resource by its resource name. The resource contains details of
   * the private connection, such as connected network, routing mode and state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateConnectionName name =
   *       PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");
   *   PrivateConnection response = vmwareEngineClient.getPrivateConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the private connection to retrieve. Resource names
   *     are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/privateConnections/my-connection`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateConnection getPrivateConnection(PrivateConnectionName name) {
    GetPrivateConnectionRequest request =
        GetPrivateConnectionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPrivateConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `PrivateConnection` resource by its resource name. The resource contains details of
   * the private connection, such as connected network, routing mode and state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]").toString();
   *   PrivateConnection response = vmwareEngineClient.getPrivateConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the private connection to retrieve. Resource names
   *     are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/privateConnections/my-connection`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateConnection getPrivateConnection(String name) {
    GetPrivateConnectionRequest request =
        GetPrivateConnectionRequest.newBuilder().setName(name).build();
    return getPrivateConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `PrivateConnection` resource by its resource name. The resource contains details of
   * the private connection, such as connected network, routing mode and state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetPrivateConnectionRequest request =
   *       GetPrivateConnectionRequest.newBuilder()
   *           .setName(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .build();
   *   PrivateConnection response = vmwareEngineClient.getPrivateConnection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateConnection getPrivateConnection(GetPrivateConnectionRequest request) {
    return getPrivateConnectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `PrivateConnection` resource by its resource name. The resource contains details of
   * the private connection, such as connected network, routing mode and state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetPrivateConnectionRequest request =
   *       GetPrivateConnectionRequest.newBuilder()
   *           .setName(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PrivateConnection> future =
   *       vmwareEngineClient.getPrivateConnectionCallable().futureCall(request);
   *   // Do something.
   *   PrivateConnection response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionCallable() {
    return stub.getPrivateConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `PrivateConnection` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (PrivateConnection element :
   *       vmwareEngineClient.listPrivateConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to query for private connections.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateConnectionsPagedResponse listPrivateConnections(LocationName parent) {
    ListPrivateConnectionsRequest request =
        ListPrivateConnectionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPrivateConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `PrivateConnection` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (PrivateConnection element :
   *       vmwareEngineClient.listPrivateConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to query for private connections.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateConnectionsPagedResponse listPrivateConnections(String parent) {
    ListPrivateConnectionsRequest request =
        ListPrivateConnectionsRequest.newBuilder().setParent(parent).build();
    return listPrivateConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `PrivateConnection` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListPrivateConnectionsRequest request =
   *       ListPrivateConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (PrivateConnection element :
   *       vmwareEngineClient.listPrivateConnections(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateConnectionsPagedResponse listPrivateConnections(
      ListPrivateConnectionsRequest request) {
    return listPrivateConnectionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `PrivateConnection` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListPrivateConnectionsRequest request =
   *       ListPrivateConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<PrivateConnection> future =
   *       vmwareEngineClient.listPrivateConnectionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PrivateConnection element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsPagedCallable() {
    return stub.listPrivateConnectionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `PrivateConnection` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListPrivateConnectionsRequest request =
   *       ListPrivateConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListPrivateConnectionsResponse response =
   *         vmwareEngineClient.listPrivateConnectionsCallable().call(request);
   *     for (PrivateConnection element : response.getPrivateConnectionsList()) {
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
  public final UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsCallable() {
    return stub.listPrivateConnectionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `PrivateConnection` resource. Only `description` and `routing_mode` fields can be
   * updated. Only fields specified in `updateMask` are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PrivateConnection response =
   *       vmwareEngineClient.updatePrivateConnectionAsync(privateConnection, updateMask).get();
   * }
   * }</pre>
   *
   * @param privateConnection Required. Private connection description.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `PrivateConnection` resource by the update. The fields specified in the `update_mask` are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateConnection, OperationMetadata> updatePrivateConnectionAsync(
      PrivateConnection privateConnection, FieldMask updateMask) {
    UpdatePrivateConnectionRequest request =
        UpdatePrivateConnectionRequest.newBuilder()
            .setPrivateConnection(privateConnection)
            .setUpdateMask(updateMask)
            .build();
    return updatePrivateConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `PrivateConnection` resource. Only `description` and `routing_mode` fields can be
   * updated. Only fields specified in `updateMask` are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdatePrivateConnectionRequest request =
   *       UpdatePrivateConnectionRequest.newBuilder()
   *           .setPrivateConnection(PrivateConnection.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   PrivateConnection response = vmwareEngineClient.updatePrivateConnectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateConnection, OperationMetadata> updatePrivateConnectionAsync(
      UpdatePrivateConnectionRequest request) {
    return updatePrivateConnectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `PrivateConnection` resource. Only `description` and `routing_mode` fields can be
   * updated. Only fields specified in `updateMask` are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdatePrivateConnectionRequest request =
   *       UpdatePrivateConnectionRequest.newBuilder()
   *           .setPrivateConnection(PrivateConnection.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<PrivateConnection, OperationMetadata> future =
   *       vmwareEngineClient.updatePrivateConnectionOperationCallable().futureCall(request);
   *   // Do something.
   *   PrivateConnection response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      updatePrivateConnectionOperationCallable() {
    return stub.updatePrivateConnectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `PrivateConnection` resource. Only `description` and `routing_mode` fields can be
   * updated. Only fields specified in `updateMask` are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdatePrivateConnectionRequest request =
   *       UpdatePrivateConnectionRequest.newBuilder()
   *           .setPrivateConnection(PrivateConnection.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.updatePrivateConnectionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePrivateConnectionRequest, Operation>
      updatePrivateConnectionCallable() {
    return stub.updatePrivateConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `PrivateConnection` resource. When a private connection is deleted for a VMware
   * Engine network, the connected network becomes inaccessible to that VMware Engine network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateConnectionName name =
   *       PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");
   *   vmwareEngineClient.deletePrivateConnectionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the private connection to be deleted. Resource names
   *     are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/privateConnections/my-connection`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePrivateConnectionAsync(
      PrivateConnectionName name) {
    DeletePrivateConnectionRequest request =
        DeletePrivateConnectionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deletePrivateConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `PrivateConnection` resource. When a private connection is deleted for a VMware
   * Engine network, the connected network becomes inaccessible to that VMware Engine network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]").toString();
   *   vmwareEngineClient.deletePrivateConnectionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the private connection to be deleted. Resource names
   *     are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/privateConnections/my-connection`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePrivateConnectionAsync(String name) {
    DeletePrivateConnectionRequest request =
        DeletePrivateConnectionRequest.newBuilder().setName(name).build();
    return deletePrivateConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `PrivateConnection` resource. When a private connection is deleted for a VMware
   * Engine network, the connected network becomes inaccessible to that VMware Engine network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeletePrivateConnectionRequest request =
   *       DeletePrivateConnectionRequest.newBuilder()
   *           .setName(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmwareEngineClient.deletePrivateConnectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePrivateConnectionAsync(
      DeletePrivateConnectionRequest request) {
    return deletePrivateConnectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `PrivateConnection` resource. When a private connection is deleted for a VMware
   * Engine network, the connected network becomes inaccessible to that VMware Engine network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeletePrivateConnectionRequest request =
   *       DeletePrivateConnectionRequest.newBuilder()
   *           .setName(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmwareEngineClient.deletePrivateConnectionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationCallable() {
    return stub.deletePrivateConnectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `PrivateConnection` resource. When a private connection is deleted for a VMware
   * Engine network, the connected network becomes inaccessible to that VMware Engine network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeletePrivateConnectionRequest request =
   *       DeletePrivateConnectionRequest.newBuilder()
   *           .setName(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.deletePrivateConnectionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionCallable() {
    return stub.deletePrivateConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the private connection routes exchanged over a peering connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateConnectionName parent =
   *       PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");
   *   for (PeeringRoute element :
   *       vmwareEngineClient.listPrivateConnectionPeeringRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private connection to retrieve peering routes
   *     from. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-west1/privateConnections/my-connection`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateConnectionPeeringRoutesPagedResponse listPrivateConnectionPeeringRoutes(
      PrivateConnectionName parent) {
    ListPrivateConnectionPeeringRoutesRequest request =
        ListPrivateConnectionPeeringRoutesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPrivateConnectionPeeringRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the private connection routes exchanged over a peering connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent =
   *       PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]").toString();
   *   for (PeeringRoute element :
   *       vmwareEngineClient.listPrivateConnectionPeeringRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private connection to retrieve peering routes
   *     from. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-west1/privateConnections/my-connection`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateConnectionPeeringRoutesPagedResponse listPrivateConnectionPeeringRoutes(
      String parent) {
    ListPrivateConnectionPeeringRoutesRequest request =
        ListPrivateConnectionPeeringRoutesRequest.newBuilder().setParent(parent).build();
    return listPrivateConnectionPeeringRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the private connection routes exchanged over a peering connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListPrivateConnectionPeeringRoutesRequest request =
   *       ListPrivateConnectionPeeringRoutesRequest.newBuilder()
   *           .setParent(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PeeringRoute element :
   *       vmwareEngineClient.listPrivateConnectionPeeringRoutes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateConnectionPeeringRoutesPagedResponse listPrivateConnectionPeeringRoutes(
      ListPrivateConnectionPeeringRoutesRequest request) {
    return listPrivateConnectionPeeringRoutesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the private connection routes exchanged over a peering connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListPrivateConnectionPeeringRoutesRequest request =
   *       ListPrivateConnectionPeeringRoutesRequest.newBuilder()
   *           .setParent(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PeeringRoute> future =
   *       vmwareEngineClient.listPrivateConnectionPeeringRoutesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PeeringRoute element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListPrivateConnectionPeeringRoutesRequest,
          ListPrivateConnectionPeeringRoutesPagedResponse>
      listPrivateConnectionPeeringRoutesPagedCallable() {
    return stub.listPrivateConnectionPeeringRoutesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the private connection routes exchanged over a peering connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListPrivateConnectionPeeringRoutesRequest request =
   *       ListPrivateConnectionPeeringRoutesRequest.newBuilder()
   *           .setParent(
   *               PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPrivateConnectionPeeringRoutesResponse response =
   *         vmwareEngineClient.listPrivateConnectionPeeringRoutesCallable().call(request);
   *     for (PeeringRoute element : response.getPeeringRoutesList()) {
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
  public final UnaryCallable<
          ListPrivateConnectionPeeringRoutesRequest, ListPrivateConnectionPeeringRoutesResponse>
      listPrivateConnectionPeeringRoutesCallable() {
    return stub.listPrivateConnectionPeeringRoutesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Grants the bind permission to the customer provided principal(user / service account) to bind
   * their DNS zone with the intranet VPC associated with the project. DnsBindPermission is a global
   * resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DnsBindPermissionName name = DnsBindPermissionName.of("[PROJECT]", "[LOCATION]");
   *   Principal principal = Principal.newBuilder().build();
   *   DnsBindPermission response =
   *       vmwareEngineClient.grantDnsBindPermissionAsync(name, principal).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the resource which stores the users/service accounts having
   *     the permission to bind to the corresponding intranet VPC of the consumer project.
   *     DnsBindPermission is a global resource. Resource names are schemeless URIs that follow the
   *     conventions in https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/dnsBindPermission`
   * @param principal Required. The consumer provided user/service account which needs to be granted
   *     permission to bind with the intranet VPC corresponding to the consumer project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DnsBindPermission, OperationMetadata> grantDnsBindPermissionAsync(
      DnsBindPermissionName name, Principal principal) {
    GrantDnsBindPermissionRequest request =
        GrantDnsBindPermissionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setPrincipal(principal)
            .build();
    return grantDnsBindPermissionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Grants the bind permission to the customer provided principal(user / service account) to bind
   * their DNS zone with the intranet VPC associated with the project. DnsBindPermission is a global
   * resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name = DnsBindPermissionName.of("[PROJECT]", "[LOCATION]").toString();
   *   Principal principal = Principal.newBuilder().build();
   *   DnsBindPermission response =
   *       vmwareEngineClient.grantDnsBindPermissionAsync(name, principal).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the resource which stores the users/service accounts having
   *     the permission to bind to the corresponding intranet VPC of the consumer project.
   *     DnsBindPermission is a global resource. Resource names are schemeless URIs that follow the
   *     conventions in https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/dnsBindPermission`
   * @param principal Required. The consumer provided user/service account which needs to be granted
   *     permission to bind with the intranet VPC corresponding to the consumer project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DnsBindPermission, OperationMetadata> grantDnsBindPermissionAsync(
      String name, Principal principal) {
    GrantDnsBindPermissionRequest request =
        GrantDnsBindPermissionRequest.newBuilder().setName(name).setPrincipal(principal).build();
    return grantDnsBindPermissionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Grants the bind permission to the customer provided principal(user / service account) to bind
   * their DNS zone with the intranet VPC associated with the project. DnsBindPermission is a global
   * resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GrantDnsBindPermissionRequest request =
   *       GrantDnsBindPermissionRequest.newBuilder()
   *           .setName(DnsBindPermissionName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrincipal(Principal.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   DnsBindPermission response = vmwareEngineClient.grantDnsBindPermissionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DnsBindPermission, OperationMetadata> grantDnsBindPermissionAsync(
      GrantDnsBindPermissionRequest request) {
    return grantDnsBindPermissionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Grants the bind permission to the customer provided principal(user / service account) to bind
   * their DNS zone with the intranet VPC associated with the project. DnsBindPermission is a global
   * resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GrantDnsBindPermissionRequest request =
   *       GrantDnsBindPermissionRequest.newBuilder()
   *           .setName(DnsBindPermissionName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrincipal(Principal.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<DnsBindPermission, OperationMetadata> future =
   *       vmwareEngineClient.grantDnsBindPermissionOperationCallable().futureCall(request);
   *   // Do something.
   *   DnsBindPermission response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          GrantDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      grantDnsBindPermissionOperationCallable() {
    return stub.grantDnsBindPermissionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Grants the bind permission to the customer provided principal(user / service account) to bind
   * their DNS zone with the intranet VPC associated with the project. DnsBindPermission is a global
   * resource and location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GrantDnsBindPermissionRequest request =
   *       GrantDnsBindPermissionRequest.newBuilder()
   *           .setName(DnsBindPermissionName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrincipal(Principal.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.grantDnsBindPermissionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GrantDnsBindPermissionRequest, Operation>
      grantDnsBindPermissionCallable() {
    return stub.grantDnsBindPermissionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all the principals having bind permission on the intranet VPC associated with the consumer
   * project granted by the Grant API. DnsBindPermission is a global resource and location can only
   * be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DnsBindPermissionName name = DnsBindPermissionName.of("[PROJECT]", "[LOCATION]");
   *   DnsBindPermission response = vmwareEngineClient.getDnsBindPermission(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the resource which stores the users/service accounts having
   *     the permission to bind to the corresponding intranet VPC of the consumer project.
   *     DnsBindPermission is a global resource. Resource names are schemeless URIs that follow the
   *     conventions in https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/dnsBindPermission`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DnsBindPermission getDnsBindPermission(DnsBindPermissionName name) {
    GetDnsBindPermissionRequest request =
        GetDnsBindPermissionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDnsBindPermission(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all the principals having bind permission on the intranet VPC associated with the consumer
   * project granted by the Grant API. DnsBindPermission is a global resource and location can only
   * be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name = DnsBindPermissionName.of("[PROJECT]", "[LOCATION]").toString();
   *   DnsBindPermission response = vmwareEngineClient.getDnsBindPermission(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the resource which stores the users/service accounts having
   *     the permission to bind to the corresponding intranet VPC of the consumer project.
   *     DnsBindPermission is a global resource. Resource names are schemeless URIs that follow the
   *     conventions in https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/dnsBindPermission`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DnsBindPermission getDnsBindPermission(String name) {
    GetDnsBindPermissionRequest request =
        GetDnsBindPermissionRequest.newBuilder().setName(name).build();
    return getDnsBindPermission(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all the principals having bind permission on the intranet VPC associated with the consumer
   * project granted by the Grant API. DnsBindPermission is a global resource and location can only
   * be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetDnsBindPermissionRequest request =
   *       GetDnsBindPermissionRequest.newBuilder()
   *           .setName(DnsBindPermissionName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   DnsBindPermission response = vmwareEngineClient.getDnsBindPermission(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DnsBindPermission getDnsBindPermission(GetDnsBindPermissionRequest request) {
    return getDnsBindPermissionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets all the principals having bind permission on the intranet VPC associated with the consumer
   * project granted by the Grant API. DnsBindPermission is a global resource and location can only
   * be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetDnsBindPermissionRequest request =
   *       GetDnsBindPermissionRequest.newBuilder()
   *           .setName(DnsBindPermissionName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<DnsBindPermission> future =
   *       vmwareEngineClient.getDnsBindPermissionCallable().futureCall(request);
   *   // Do something.
   *   DnsBindPermission response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDnsBindPermissionRequest, DnsBindPermission>
      getDnsBindPermissionCallable() {
    return stub.getDnsBindPermissionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revokes the bind permission from the customer provided principal(user / service account) on the
   * intranet VPC associated with the consumer project. DnsBindPermission is a global resource and
   * location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DnsBindPermissionName name = DnsBindPermissionName.of("[PROJECT]", "[LOCATION]");
   *   Principal principal = Principal.newBuilder().build();
   *   DnsBindPermission response =
   *       vmwareEngineClient.revokeDnsBindPermissionAsync(name, principal).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the resource which stores the users/service accounts having
   *     the permission to bind to the corresponding intranet VPC of the consumer project.
   *     DnsBindPermission is a global resource. Resource names are schemeless URIs that follow the
   *     conventions in https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/dnsBindPermission`
   * @param principal Required. The consumer provided user/service account which needs to be granted
   *     permission to bind with the intranet VPC corresponding to the consumer project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DnsBindPermission, OperationMetadata> revokeDnsBindPermissionAsync(
      DnsBindPermissionName name, Principal principal) {
    RevokeDnsBindPermissionRequest request =
        RevokeDnsBindPermissionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setPrincipal(principal)
            .build();
    return revokeDnsBindPermissionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revokes the bind permission from the customer provided principal(user / service account) on the
   * intranet VPC associated with the consumer project. DnsBindPermission is a global resource and
   * location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name = DnsBindPermissionName.of("[PROJECT]", "[LOCATION]").toString();
   *   Principal principal = Principal.newBuilder().build();
   *   DnsBindPermission response =
   *       vmwareEngineClient.revokeDnsBindPermissionAsync(name, principal).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the resource which stores the users/service accounts having
   *     the permission to bind to the corresponding intranet VPC of the consumer project.
   *     DnsBindPermission is a global resource. Resource names are schemeless URIs that follow the
   *     conventions in https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/dnsBindPermission`
   * @param principal Required. The consumer provided user/service account which needs to be granted
   *     permission to bind with the intranet VPC corresponding to the consumer project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DnsBindPermission, OperationMetadata> revokeDnsBindPermissionAsync(
      String name, Principal principal) {
    RevokeDnsBindPermissionRequest request =
        RevokeDnsBindPermissionRequest.newBuilder().setName(name).setPrincipal(principal).build();
    return revokeDnsBindPermissionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revokes the bind permission from the customer provided principal(user / service account) on the
   * intranet VPC associated with the consumer project. DnsBindPermission is a global resource and
   * location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   RevokeDnsBindPermissionRequest request =
   *       RevokeDnsBindPermissionRequest.newBuilder()
   *           .setName(DnsBindPermissionName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrincipal(Principal.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   DnsBindPermission response = vmwareEngineClient.revokeDnsBindPermissionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DnsBindPermission, OperationMetadata> revokeDnsBindPermissionAsync(
      RevokeDnsBindPermissionRequest request) {
    return revokeDnsBindPermissionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revokes the bind permission from the customer provided principal(user / service account) on the
   * intranet VPC associated with the consumer project. DnsBindPermission is a global resource and
   * location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   RevokeDnsBindPermissionRequest request =
   *       RevokeDnsBindPermissionRequest.newBuilder()
   *           .setName(DnsBindPermissionName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrincipal(Principal.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<DnsBindPermission, OperationMetadata> future =
   *       vmwareEngineClient.revokeDnsBindPermissionOperationCallable().futureCall(request);
   *   // Do something.
   *   DnsBindPermission response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RevokeDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      revokeDnsBindPermissionOperationCallable() {
    return stub.revokeDnsBindPermissionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revokes the bind permission from the customer provided principal(user / service account) on the
   * intranet VPC associated with the consumer project. DnsBindPermission is a global resource and
   * location can only be global.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   RevokeDnsBindPermissionRequest request =
   *       RevokeDnsBindPermissionRequest.newBuilder()
   *           .setName(DnsBindPermissionName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrincipal(Principal.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.revokeDnsBindPermissionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RevokeDnsBindPermissionRequest, Operation>
      revokeDnsBindPermissionCallable() {
    return stub.revokeDnsBindPermissionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : vmwareEngineClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       vmwareEngineClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = vmwareEngineClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = vmwareEngineClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = vmwareEngineClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = vmwareEngineClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = vmwareEngineClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = vmwareEngineClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = vmwareEngineClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = vmwareEngineClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       vmwareEngineClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
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

  public static class ListPrivateCloudsPagedResponse
      extends AbstractPagedListResponse<
          ListPrivateCloudsRequest,
          ListPrivateCloudsResponse,
          PrivateCloud,
          ListPrivateCloudsPage,
          ListPrivateCloudsFixedSizeCollection> {

    public static ApiFuture<ListPrivateCloudsPagedResponse> createAsync(
        PageContext<ListPrivateCloudsRequest, ListPrivateCloudsResponse, PrivateCloud> context,
        ApiFuture<ListPrivateCloudsResponse> futureResponse) {
      ApiFuture<ListPrivateCloudsPage> futurePage =
          ListPrivateCloudsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPrivateCloudsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPrivateCloudsPagedResponse(ListPrivateCloudsPage page) {
      super(page, ListPrivateCloudsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPrivateCloudsPage
      extends AbstractPage<
          ListPrivateCloudsRequest,
          ListPrivateCloudsResponse,
          PrivateCloud,
          ListPrivateCloudsPage> {

    private ListPrivateCloudsPage(
        PageContext<ListPrivateCloudsRequest, ListPrivateCloudsResponse, PrivateCloud> context,
        ListPrivateCloudsResponse response) {
      super(context, response);
    }

    private static ListPrivateCloudsPage createEmptyPage() {
      return new ListPrivateCloudsPage(null, null);
    }

    @Override
    protected ListPrivateCloudsPage createPage(
        PageContext<ListPrivateCloudsRequest, ListPrivateCloudsResponse, PrivateCloud> context,
        ListPrivateCloudsResponse response) {
      return new ListPrivateCloudsPage(context, response);
    }

    @Override
    public ApiFuture<ListPrivateCloudsPage> createPageAsync(
        PageContext<ListPrivateCloudsRequest, ListPrivateCloudsResponse, PrivateCloud> context,
        ApiFuture<ListPrivateCloudsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPrivateCloudsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPrivateCloudsRequest,
          ListPrivateCloudsResponse,
          PrivateCloud,
          ListPrivateCloudsPage,
          ListPrivateCloudsFixedSizeCollection> {

    private ListPrivateCloudsFixedSizeCollection(
        List<ListPrivateCloudsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPrivateCloudsFixedSizeCollection createEmptyCollection() {
      return new ListPrivateCloudsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPrivateCloudsFixedSizeCollection createCollection(
        List<ListPrivateCloudsPage> pages, int collectionSize) {
      return new ListPrivateCloudsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListClustersPagedResponse
      extends AbstractPagedListResponse<
          ListClustersRequest,
          ListClustersResponse,
          Cluster,
          ListClustersPage,
          ListClustersFixedSizeCollection> {

    public static ApiFuture<ListClustersPagedResponse> createAsync(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ApiFuture<ListClustersResponse> futureResponse) {
      ApiFuture<ListClustersPage> futurePage =
          ListClustersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListClustersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListClustersPagedResponse(ListClustersPage page) {
      super(page, ListClustersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListClustersPage
      extends AbstractPage<ListClustersRequest, ListClustersResponse, Cluster, ListClustersPage> {

    private ListClustersPage(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ListClustersResponse response) {
      super(context, response);
    }

    private static ListClustersPage createEmptyPage() {
      return new ListClustersPage(null, null);
    }

    @Override
    protected ListClustersPage createPage(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ListClustersResponse response) {
      return new ListClustersPage(context, response);
    }

    @Override
    public ApiFuture<ListClustersPage> createPageAsync(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ApiFuture<ListClustersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListClustersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListClustersRequest,
          ListClustersResponse,
          Cluster,
          ListClustersPage,
          ListClustersFixedSizeCollection> {

    private ListClustersFixedSizeCollection(List<ListClustersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListClustersFixedSizeCollection createEmptyCollection() {
      return new ListClustersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListClustersFixedSizeCollection createCollection(
        List<ListClustersPage> pages, int collectionSize) {
      return new ListClustersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNodesPagedResponse
      extends AbstractPagedListResponse<
          ListNodesRequest, ListNodesResponse, Node, ListNodesPage, ListNodesFixedSizeCollection> {

    public static ApiFuture<ListNodesPagedResponse> createAsync(
        PageContext<ListNodesRequest, ListNodesResponse, Node> context,
        ApiFuture<ListNodesResponse> futureResponse) {
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
      extends AbstractPage<ListNodesRequest, ListNodesResponse, Node, ListNodesPage> {

    private ListNodesPage(
        PageContext<ListNodesRequest, ListNodesResponse, Node> context,
        ListNodesResponse response) {
      super(context, response);
    }

    private static ListNodesPage createEmptyPage() {
      return new ListNodesPage(null, null);
    }

    @Override
    protected ListNodesPage createPage(
        PageContext<ListNodesRequest, ListNodesResponse, Node> context,
        ListNodesResponse response) {
      return new ListNodesPage(context, response);
    }

    @Override
    public ApiFuture<ListNodesPage> createPageAsync(
        PageContext<ListNodesRequest, ListNodesResponse, Node> context,
        ApiFuture<ListNodesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNodesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNodesRequest, ListNodesResponse, Node, ListNodesPage, ListNodesFixedSizeCollection> {

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

  public static class ListExternalAddressesPagedResponse
      extends AbstractPagedListResponse<
          ListExternalAddressesRequest,
          ListExternalAddressesResponse,
          ExternalAddress,
          ListExternalAddressesPage,
          ListExternalAddressesFixedSizeCollection> {

    public static ApiFuture<ListExternalAddressesPagedResponse> createAsync(
        PageContext<ListExternalAddressesRequest, ListExternalAddressesResponse, ExternalAddress>
            context,
        ApiFuture<ListExternalAddressesResponse> futureResponse) {
      ApiFuture<ListExternalAddressesPage> futurePage =
          ListExternalAddressesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExternalAddressesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExternalAddressesPagedResponse(ListExternalAddressesPage page) {
      super(page, ListExternalAddressesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExternalAddressesPage
      extends AbstractPage<
          ListExternalAddressesRequest,
          ListExternalAddressesResponse,
          ExternalAddress,
          ListExternalAddressesPage> {

    private ListExternalAddressesPage(
        PageContext<ListExternalAddressesRequest, ListExternalAddressesResponse, ExternalAddress>
            context,
        ListExternalAddressesResponse response) {
      super(context, response);
    }

    private static ListExternalAddressesPage createEmptyPage() {
      return new ListExternalAddressesPage(null, null);
    }

    @Override
    protected ListExternalAddressesPage createPage(
        PageContext<ListExternalAddressesRequest, ListExternalAddressesResponse, ExternalAddress>
            context,
        ListExternalAddressesResponse response) {
      return new ListExternalAddressesPage(context, response);
    }

    @Override
    public ApiFuture<ListExternalAddressesPage> createPageAsync(
        PageContext<ListExternalAddressesRequest, ListExternalAddressesResponse, ExternalAddress>
            context,
        ApiFuture<ListExternalAddressesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExternalAddressesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExternalAddressesRequest,
          ListExternalAddressesResponse,
          ExternalAddress,
          ListExternalAddressesPage,
          ListExternalAddressesFixedSizeCollection> {

    private ListExternalAddressesFixedSizeCollection(
        List<ListExternalAddressesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExternalAddressesFixedSizeCollection createEmptyCollection() {
      return new ListExternalAddressesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExternalAddressesFixedSizeCollection createCollection(
        List<ListExternalAddressesPage> pages, int collectionSize) {
      return new ListExternalAddressesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchNetworkPolicyExternalAddressesPagedResponse
      extends AbstractPagedListResponse<
          FetchNetworkPolicyExternalAddressesRequest,
          FetchNetworkPolicyExternalAddressesResponse,
          ExternalAddress,
          FetchNetworkPolicyExternalAddressesPage,
          FetchNetworkPolicyExternalAddressesFixedSizeCollection> {

    public static ApiFuture<FetchNetworkPolicyExternalAddressesPagedResponse> createAsync(
        PageContext<
                FetchNetworkPolicyExternalAddressesRequest,
                FetchNetworkPolicyExternalAddressesResponse,
                ExternalAddress>
            context,
        ApiFuture<FetchNetworkPolicyExternalAddressesResponse> futureResponse) {
      ApiFuture<FetchNetworkPolicyExternalAddressesPage> futurePage =
          FetchNetworkPolicyExternalAddressesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchNetworkPolicyExternalAddressesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchNetworkPolicyExternalAddressesPagedResponse(
        FetchNetworkPolicyExternalAddressesPage page) {
      super(page, FetchNetworkPolicyExternalAddressesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchNetworkPolicyExternalAddressesPage
      extends AbstractPage<
          FetchNetworkPolicyExternalAddressesRequest,
          FetchNetworkPolicyExternalAddressesResponse,
          ExternalAddress,
          FetchNetworkPolicyExternalAddressesPage> {

    private FetchNetworkPolicyExternalAddressesPage(
        PageContext<
                FetchNetworkPolicyExternalAddressesRequest,
                FetchNetworkPolicyExternalAddressesResponse,
                ExternalAddress>
            context,
        FetchNetworkPolicyExternalAddressesResponse response) {
      super(context, response);
    }

    private static FetchNetworkPolicyExternalAddressesPage createEmptyPage() {
      return new FetchNetworkPolicyExternalAddressesPage(null, null);
    }

    @Override
    protected FetchNetworkPolicyExternalAddressesPage createPage(
        PageContext<
                FetchNetworkPolicyExternalAddressesRequest,
                FetchNetworkPolicyExternalAddressesResponse,
                ExternalAddress>
            context,
        FetchNetworkPolicyExternalAddressesResponse response) {
      return new FetchNetworkPolicyExternalAddressesPage(context, response);
    }

    @Override
    public ApiFuture<FetchNetworkPolicyExternalAddressesPage> createPageAsync(
        PageContext<
                FetchNetworkPolicyExternalAddressesRequest,
                FetchNetworkPolicyExternalAddressesResponse,
                ExternalAddress>
            context,
        ApiFuture<FetchNetworkPolicyExternalAddressesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchNetworkPolicyExternalAddressesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchNetworkPolicyExternalAddressesRequest,
          FetchNetworkPolicyExternalAddressesResponse,
          ExternalAddress,
          FetchNetworkPolicyExternalAddressesPage,
          FetchNetworkPolicyExternalAddressesFixedSizeCollection> {

    private FetchNetworkPolicyExternalAddressesFixedSizeCollection(
        List<FetchNetworkPolicyExternalAddressesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchNetworkPolicyExternalAddressesFixedSizeCollection createEmptyCollection() {
      return new FetchNetworkPolicyExternalAddressesFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchNetworkPolicyExternalAddressesFixedSizeCollection createCollection(
        List<FetchNetworkPolicyExternalAddressesPage> pages, int collectionSize) {
      return new FetchNetworkPolicyExternalAddressesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSubnetsPagedResponse
      extends AbstractPagedListResponse<
          ListSubnetsRequest,
          ListSubnetsResponse,
          Subnet,
          ListSubnetsPage,
          ListSubnetsFixedSizeCollection> {

    public static ApiFuture<ListSubnetsPagedResponse> createAsync(
        PageContext<ListSubnetsRequest, ListSubnetsResponse, Subnet> context,
        ApiFuture<ListSubnetsResponse> futureResponse) {
      ApiFuture<ListSubnetsPage> futurePage =
          ListSubnetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSubnetsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSubnetsPagedResponse(ListSubnetsPage page) {
      super(page, ListSubnetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSubnetsPage
      extends AbstractPage<ListSubnetsRequest, ListSubnetsResponse, Subnet, ListSubnetsPage> {

    private ListSubnetsPage(
        PageContext<ListSubnetsRequest, ListSubnetsResponse, Subnet> context,
        ListSubnetsResponse response) {
      super(context, response);
    }

    private static ListSubnetsPage createEmptyPage() {
      return new ListSubnetsPage(null, null);
    }

    @Override
    protected ListSubnetsPage createPage(
        PageContext<ListSubnetsRequest, ListSubnetsResponse, Subnet> context,
        ListSubnetsResponse response) {
      return new ListSubnetsPage(context, response);
    }

    @Override
    public ApiFuture<ListSubnetsPage> createPageAsync(
        PageContext<ListSubnetsRequest, ListSubnetsResponse, Subnet> context,
        ApiFuture<ListSubnetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSubnetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSubnetsRequest,
          ListSubnetsResponse,
          Subnet,
          ListSubnetsPage,
          ListSubnetsFixedSizeCollection> {

    private ListSubnetsFixedSizeCollection(List<ListSubnetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSubnetsFixedSizeCollection createEmptyCollection() {
      return new ListSubnetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSubnetsFixedSizeCollection createCollection(
        List<ListSubnetsPage> pages, int collectionSize) {
      return new ListSubnetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListExternalAccessRulesPagedResponse
      extends AbstractPagedListResponse<
          ListExternalAccessRulesRequest,
          ListExternalAccessRulesResponse,
          ExternalAccessRule,
          ListExternalAccessRulesPage,
          ListExternalAccessRulesFixedSizeCollection> {

    public static ApiFuture<ListExternalAccessRulesPagedResponse> createAsync(
        PageContext<
                ListExternalAccessRulesRequest, ListExternalAccessRulesResponse, ExternalAccessRule>
            context,
        ApiFuture<ListExternalAccessRulesResponse> futureResponse) {
      ApiFuture<ListExternalAccessRulesPage> futurePage =
          ListExternalAccessRulesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExternalAccessRulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExternalAccessRulesPagedResponse(ListExternalAccessRulesPage page) {
      super(page, ListExternalAccessRulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExternalAccessRulesPage
      extends AbstractPage<
          ListExternalAccessRulesRequest,
          ListExternalAccessRulesResponse,
          ExternalAccessRule,
          ListExternalAccessRulesPage> {

    private ListExternalAccessRulesPage(
        PageContext<
                ListExternalAccessRulesRequest, ListExternalAccessRulesResponse, ExternalAccessRule>
            context,
        ListExternalAccessRulesResponse response) {
      super(context, response);
    }

    private static ListExternalAccessRulesPage createEmptyPage() {
      return new ListExternalAccessRulesPage(null, null);
    }

    @Override
    protected ListExternalAccessRulesPage createPage(
        PageContext<
                ListExternalAccessRulesRequest, ListExternalAccessRulesResponse, ExternalAccessRule>
            context,
        ListExternalAccessRulesResponse response) {
      return new ListExternalAccessRulesPage(context, response);
    }

    @Override
    public ApiFuture<ListExternalAccessRulesPage> createPageAsync(
        PageContext<
                ListExternalAccessRulesRequest, ListExternalAccessRulesResponse, ExternalAccessRule>
            context,
        ApiFuture<ListExternalAccessRulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExternalAccessRulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExternalAccessRulesRequest,
          ListExternalAccessRulesResponse,
          ExternalAccessRule,
          ListExternalAccessRulesPage,
          ListExternalAccessRulesFixedSizeCollection> {

    private ListExternalAccessRulesFixedSizeCollection(
        List<ListExternalAccessRulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExternalAccessRulesFixedSizeCollection createEmptyCollection() {
      return new ListExternalAccessRulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExternalAccessRulesFixedSizeCollection createCollection(
        List<ListExternalAccessRulesPage> pages, int collectionSize) {
      return new ListExternalAccessRulesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLoggingServersPagedResponse
      extends AbstractPagedListResponse<
          ListLoggingServersRequest,
          ListLoggingServersResponse,
          LoggingServer,
          ListLoggingServersPage,
          ListLoggingServersFixedSizeCollection> {

    public static ApiFuture<ListLoggingServersPagedResponse> createAsync(
        PageContext<ListLoggingServersRequest, ListLoggingServersResponse, LoggingServer> context,
        ApiFuture<ListLoggingServersResponse> futureResponse) {
      ApiFuture<ListLoggingServersPage> futurePage =
          ListLoggingServersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLoggingServersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLoggingServersPagedResponse(ListLoggingServersPage page) {
      super(page, ListLoggingServersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLoggingServersPage
      extends AbstractPage<
          ListLoggingServersRequest,
          ListLoggingServersResponse,
          LoggingServer,
          ListLoggingServersPage> {

    private ListLoggingServersPage(
        PageContext<ListLoggingServersRequest, ListLoggingServersResponse, LoggingServer> context,
        ListLoggingServersResponse response) {
      super(context, response);
    }

    private static ListLoggingServersPage createEmptyPage() {
      return new ListLoggingServersPage(null, null);
    }

    @Override
    protected ListLoggingServersPage createPage(
        PageContext<ListLoggingServersRequest, ListLoggingServersResponse, LoggingServer> context,
        ListLoggingServersResponse response) {
      return new ListLoggingServersPage(context, response);
    }

    @Override
    public ApiFuture<ListLoggingServersPage> createPageAsync(
        PageContext<ListLoggingServersRequest, ListLoggingServersResponse, LoggingServer> context,
        ApiFuture<ListLoggingServersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLoggingServersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLoggingServersRequest,
          ListLoggingServersResponse,
          LoggingServer,
          ListLoggingServersPage,
          ListLoggingServersFixedSizeCollection> {

    private ListLoggingServersFixedSizeCollection(
        List<ListLoggingServersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLoggingServersFixedSizeCollection createEmptyCollection() {
      return new ListLoggingServersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLoggingServersFixedSizeCollection createCollection(
        List<ListLoggingServersPage> pages, int collectionSize) {
      return new ListLoggingServersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNodeTypesPagedResponse
      extends AbstractPagedListResponse<
          ListNodeTypesRequest,
          ListNodeTypesResponse,
          NodeType,
          ListNodeTypesPage,
          ListNodeTypesFixedSizeCollection> {

    public static ApiFuture<ListNodeTypesPagedResponse> createAsync(
        PageContext<ListNodeTypesRequest, ListNodeTypesResponse, NodeType> context,
        ApiFuture<ListNodeTypesResponse> futureResponse) {
      ApiFuture<ListNodeTypesPage> futurePage =
          ListNodeTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNodeTypesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNodeTypesPagedResponse(ListNodeTypesPage page) {
      super(page, ListNodeTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNodeTypesPage
      extends AbstractPage<
          ListNodeTypesRequest, ListNodeTypesResponse, NodeType, ListNodeTypesPage> {

    private ListNodeTypesPage(
        PageContext<ListNodeTypesRequest, ListNodeTypesResponse, NodeType> context,
        ListNodeTypesResponse response) {
      super(context, response);
    }

    private static ListNodeTypesPage createEmptyPage() {
      return new ListNodeTypesPage(null, null);
    }

    @Override
    protected ListNodeTypesPage createPage(
        PageContext<ListNodeTypesRequest, ListNodeTypesResponse, NodeType> context,
        ListNodeTypesResponse response) {
      return new ListNodeTypesPage(context, response);
    }

    @Override
    public ApiFuture<ListNodeTypesPage> createPageAsync(
        PageContext<ListNodeTypesRequest, ListNodeTypesResponse, NodeType> context,
        ApiFuture<ListNodeTypesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNodeTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNodeTypesRequest,
          ListNodeTypesResponse,
          NodeType,
          ListNodeTypesPage,
          ListNodeTypesFixedSizeCollection> {

    private ListNodeTypesFixedSizeCollection(List<ListNodeTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNodeTypesFixedSizeCollection createEmptyCollection() {
      return new ListNodeTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNodeTypesFixedSizeCollection createCollection(
        List<ListNodeTypesPage> pages, int collectionSize) {
      return new ListNodeTypesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNetworkPeeringsPagedResponse
      extends AbstractPagedListResponse<
          ListNetworkPeeringsRequest,
          ListNetworkPeeringsResponse,
          NetworkPeering,
          ListNetworkPeeringsPage,
          ListNetworkPeeringsFixedSizeCollection> {

    public static ApiFuture<ListNetworkPeeringsPagedResponse> createAsync(
        PageContext<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse, NetworkPeering>
            context,
        ApiFuture<ListNetworkPeeringsResponse> futureResponse) {
      ApiFuture<ListNetworkPeeringsPage> futurePage =
          ListNetworkPeeringsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNetworkPeeringsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNetworkPeeringsPagedResponse(ListNetworkPeeringsPage page) {
      super(page, ListNetworkPeeringsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNetworkPeeringsPage
      extends AbstractPage<
          ListNetworkPeeringsRequest,
          ListNetworkPeeringsResponse,
          NetworkPeering,
          ListNetworkPeeringsPage> {

    private ListNetworkPeeringsPage(
        PageContext<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse, NetworkPeering>
            context,
        ListNetworkPeeringsResponse response) {
      super(context, response);
    }

    private static ListNetworkPeeringsPage createEmptyPage() {
      return new ListNetworkPeeringsPage(null, null);
    }

    @Override
    protected ListNetworkPeeringsPage createPage(
        PageContext<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse, NetworkPeering>
            context,
        ListNetworkPeeringsResponse response) {
      return new ListNetworkPeeringsPage(context, response);
    }

    @Override
    public ApiFuture<ListNetworkPeeringsPage> createPageAsync(
        PageContext<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse, NetworkPeering>
            context,
        ApiFuture<ListNetworkPeeringsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNetworkPeeringsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNetworkPeeringsRequest,
          ListNetworkPeeringsResponse,
          NetworkPeering,
          ListNetworkPeeringsPage,
          ListNetworkPeeringsFixedSizeCollection> {

    private ListNetworkPeeringsFixedSizeCollection(
        List<ListNetworkPeeringsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNetworkPeeringsFixedSizeCollection createEmptyCollection() {
      return new ListNetworkPeeringsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNetworkPeeringsFixedSizeCollection createCollection(
        List<ListNetworkPeeringsPage> pages, int collectionSize) {
      return new ListNetworkPeeringsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPeeringRoutesPagedResponse
      extends AbstractPagedListResponse<
          ListPeeringRoutesRequest,
          ListPeeringRoutesResponse,
          PeeringRoute,
          ListPeeringRoutesPage,
          ListPeeringRoutesFixedSizeCollection> {

    public static ApiFuture<ListPeeringRoutesPagedResponse> createAsync(
        PageContext<ListPeeringRoutesRequest, ListPeeringRoutesResponse, PeeringRoute> context,
        ApiFuture<ListPeeringRoutesResponse> futureResponse) {
      ApiFuture<ListPeeringRoutesPage> futurePage =
          ListPeeringRoutesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPeeringRoutesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPeeringRoutesPagedResponse(ListPeeringRoutesPage page) {
      super(page, ListPeeringRoutesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPeeringRoutesPage
      extends AbstractPage<
          ListPeeringRoutesRequest,
          ListPeeringRoutesResponse,
          PeeringRoute,
          ListPeeringRoutesPage> {

    private ListPeeringRoutesPage(
        PageContext<ListPeeringRoutesRequest, ListPeeringRoutesResponse, PeeringRoute> context,
        ListPeeringRoutesResponse response) {
      super(context, response);
    }

    private static ListPeeringRoutesPage createEmptyPage() {
      return new ListPeeringRoutesPage(null, null);
    }

    @Override
    protected ListPeeringRoutesPage createPage(
        PageContext<ListPeeringRoutesRequest, ListPeeringRoutesResponse, PeeringRoute> context,
        ListPeeringRoutesResponse response) {
      return new ListPeeringRoutesPage(context, response);
    }

    @Override
    public ApiFuture<ListPeeringRoutesPage> createPageAsync(
        PageContext<ListPeeringRoutesRequest, ListPeeringRoutesResponse, PeeringRoute> context,
        ApiFuture<ListPeeringRoutesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPeeringRoutesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPeeringRoutesRequest,
          ListPeeringRoutesResponse,
          PeeringRoute,
          ListPeeringRoutesPage,
          ListPeeringRoutesFixedSizeCollection> {

    private ListPeeringRoutesFixedSizeCollection(
        List<ListPeeringRoutesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPeeringRoutesFixedSizeCollection createEmptyCollection() {
      return new ListPeeringRoutesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPeeringRoutesFixedSizeCollection createCollection(
        List<ListPeeringRoutesPage> pages, int collectionSize) {
      return new ListPeeringRoutesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListHcxActivationKeysPagedResponse
      extends AbstractPagedListResponse<
          ListHcxActivationKeysRequest,
          ListHcxActivationKeysResponse,
          HcxActivationKey,
          ListHcxActivationKeysPage,
          ListHcxActivationKeysFixedSizeCollection> {

    public static ApiFuture<ListHcxActivationKeysPagedResponse> createAsync(
        PageContext<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse, HcxActivationKey>
            context,
        ApiFuture<ListHcxActivationKeysResponse> futureResponse) {
      ApiFuture<ListHcxActivationKeysPage> futurePage =
          ListHcxActivationKeysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListHcxActivationKeysPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListHcxActivationKeysPagedResponse(ListHcxActivationKeysPage page) {
      super(page, ListHcxActivationKeysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHcxActivationKeysPage
      extends AbstractPage<
          ListHcxActivationKeysRequest,
          ListHcxActivationKeysResponse,
          HcxActivationKey,
          ListHcxActivationKeysPage> {

    private ListHcxActivationKeysPage(
        PageContext<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse, HcxActivationKey>
            context,
        ListHcxActivationKeysResponse response) {
      super(context, response);
    }

    private static ListHcxActivationKeysPage createEmptyPage() {
      return new ListHcxActivationKeysPage(null, null);
    }

    @Override
    protected ListHcxActivationKeysPage createPage(
        PageContext<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse, HcxActivationKey>
            context,
        ListHcxActivationKeysResponse response) {
      return new ListHcxActivationKeysPage(context, response);
    }

    @Override
    public ApiFuture<ListHcxActivationKeysPage> createPageAsync(
        PageContext<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse, HcxActivationKey>
            context,
        ApiFuture<ListHcxActivationKeysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHcxActivationKeysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHcxActivationKeysRequest,
          ListHcxActivationKeysResponse,
          HcxActivationKey,
          ListHcxActivationKeysPage,
          ListHcxActivationKeysFixedSizeCollection> {

    private ListHcxActivationKeysFixedSizeCollection(
        List<ListHcxActivationKeysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHcxActivationKeysFixedSizeCollection createEmptyCollection() {
      return new ListHcxActivationKeysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHcxActivationKeysFixedSizeCollection createCollection(
        List<ListHcxActivationKeysPage> pages, int collectionSize) {
      return new ListHcxActivationKeysFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNetworkPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListNetworkPoliciesRequest,
          ListNetworkPoliciesResponse,
          NetworkPolicy,
          ListNetworkPoliciesPage,
          ListNetworkPoliciesFixedSizeCollection> {

    public static ApiFuture<ListNetworkPoliciesPagedResponse> createAsync(
        PageContext<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, NetworkPolicy> context,
        ApiFuture<ListNetworkPoliciesResponse> futureResponse) {
      ApiFuture<ListNetworkPoliciesPage> futurePage =
          ListNetworkPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNetworkPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNetworkPoliciesPagedResponse(ListNetworkPoliciesPage page) {
      super(page, ListNetworkPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNetworkPoliciesPage
      extends AbstractPage<
          ListNetworkPoliciesRequest,
          ListNetworkPoliciesResponse,
          NetworkPolicy,
          ListNetworkPoliciesPage> {

    private ListNetworkPoliciesPage(
        PageContext<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, NetworkPolicy> context,
        ListNetworkPoliciesResponse response) {
      super(context, response);
    }

    private static ListNetworkPoliciesPage createEmptyPage() {
      return new ListNetworkPoliciesPage(null, null);
    }

    @Override
    protected ListNetworkPoliciesPage createPage(
        PageContext<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, NetworkPolicy> context,
        ListNetworkPoliciesResponse response) {
      return new ListNetworkPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListNetworkPoliciesPage> createPageAsync(
        PageContext<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, NetworkPolicy> context,
        ApiFuture<ListNetworkPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNetworkPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNetworkPoliciesRequest,
          ListNetworkPoliciesResponse,
          NetworkPolicy,
          ListNetworkPoliciesPage,
          ListNetworkPoliciesFixedSizeCollection> {

    private ListNetworkPoliciesFixedSizeCollection(
        List<ListNetworkPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNetworkPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListNetworkPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNetworkPoliciesFixedSizeCollection createCollection(
        List<ListNetworkPoliciesPage> pages, int collectionSize) {
      return new ListNetworkPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListManagementDnsZoneBindingsPagedResponse
      extends AbstractPagedListResponse<
          ListManagementDnsZoneBindingsRequest,
          ListManagementDnsZoneBindingsResponse,
          ManagementDnsZoneBinding,
          ListManagementDnsZoneBindingsPage,
          ListManagementDnsZoneBindingsFixedSizeCollection> {

    public static ApiFuture<ListManagementDnsZoneBindingsPagedResponse> createAsync(
        PageContext<
                ListManagementDnsZoneBindingsRequest,
                ListManagementDnsZoneBindingsResponse,
                ManagementDnsZoneBinding>
            context,
        ApiFuture<ListManagementDnsZoneBindingsResponse> futureResponse) {
      ApiFuture<ListManagementDnsZoneBindingsPage> futurePage =
          ListManagementDnsZoneBindingsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListManagementDnsZoneBindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListManagementDnsZoneBindingsPagedResponse(ListManagementDnsZoneBindingsPage page) {
      super(page, ListManagementDnsZoneBindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListManagementDnsZoneBindingsPage
      extends AbstractPage<
          ListManagementDnsZoneBindingsRequest,
          ListManagementDnsZoneBindingsResponse,
          ManagementDnsZoneBinding,
          ListManagementDnsZoneBindingsPage> {

    private ListManagementDnsZoneBindingsPage(
        PageContext<
                ListManagementDnsZoneBindingsRequest,
                ListManagementDnsZoneBindingsResponse,
                ManagementDnsZoneBinding>
            context,
        ListManagementDnsZoneBindingsResponse response) {
      super(context, response);
    }

    private static ListManagementDnsZoneBindingsPage createEmptyPage() {
      return new ListManagementDnsZoneBindingsPage(null, null);
    }

    @Override
    protected ListManagementDnsZoneBindingsPage createPage(
        PageContext<
                ListManagementDnsZoneBindingsRequest,
                ListManagementDnsZoneBindingsResponse,
                ManagementDnsZoneBinding>
            context,
        ListManagementDnsZoneBindingsResponse response) {
      return new ListManagementDnsZoneBindingsPage(context, response);
    }

    @Override
    public ApiFuture<ListManagementDnsZoneBindingsPage> createPageAsync(
        PageContext<
                ListManagementDnsZoneBindingsRequest,
                ListManagementDnsZoneBindingsResponse,
                ManagementDnsZoneBinding>
            context,
        ApiFuture<ListManagementDnsZoneBindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListManagementDnsZoneBindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListManagementDnsZoneBindingsRequest,
          ListManagementDnsZoneBindingsResponse,
          ManagementDnsZoneBinding,
          ListManagementDnsZoneBindingsPage,
          ListManagementDnsZoneBindingsFixedSizeCollection> {

    private ListManagementDnsZoneBindingsFixedSizeCollection(
        List<ListManagementDnsZoneBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListManagementDnsZoneBindingsFixedSizeCollection createEmptyCollection() {
      return new ListManagementDnsZoneBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListManagementDnsZoneBindingsFixedSizeCollection createCollection(
        List<ListManagementDnsZoneBindingsPage> pages, int collectionSize) {
      return new ListManagementDnsZoneBindingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVmwareEngineNetworksPagedResponse
      extends AbstractPagedListResponse<
          ListVmwareEngineNetworksRequest,
          ListVmwareEngineNetworksResponse,
          VmwareEngineNetwork,
          ListVmwareEngineNetworksPage,
          ListVmwareEngineNetworksFixedSizeCollection> {

    public static ApiFuture<ListVmwareEngineNetworksPagedResponse> createAsync(
        PageContext<
                ListVmwareEngineNetworksRequest,
                ListVmwareEngineNetworksResponse,
                VmwareEngineNetwork>
            context,
        ApiFuture<ListVmwareEngineNetworksResponse> futureResponse) {
      ApiFuture<ListVmwareEngineNetworksPage> futurePage =
          ListVmwareEngineNetworksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVmwareEngineNetworksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVmwareEngineNetworksPagedResponse(ListVmwareEngineNetworksPage page) {
      super(page, ListVmwareEngineNetworksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVmwareEngineNetworksPage
      extends AbstractPage<
          ListVmwareEngineNetworksRequest,
          ListVmwareEngineNetworksResponse,
          VmwareEngineNetwork,
          ListVmwareEngineNetworksPage> {

    private ListVmwareEngineNetworksPage(
        PageContext<
                ListVmwareEngineNetworksRequest,
                ListVmwareEngineNetworksResponse,
                VmwareEngineNetwork>
            context,
        ListVmwareEngineNetworksResponse response) {
      super(context, response);
    }

    private static ListVmwareEngineNetworksPage createEmptyPage() {
      return new ListVmwareEngineNetworksPage(null, null);
    }

    @Override
    protected ListVmwareEngineNetworksPage createPage(
        PageContext<
                ListVmwareEngineNetworksRequest,
                ListVmwareEngineNetworksResponse,
                VmwareEngineNetwork>
            context,
        ListVmwareEngineNetworksResponse response) {
      return new ListVmwareEngineNetworksPage(context, response);
    }

    @Override
    public ApiFuture<ListVmwareEngineNetworksPage> createPageAsync(
        PageContext<
                ListVmwareEngineNetworksRequest,
                ListVmwareEngineNetworksResponse,
                VmwareEngineNetwork>
            context,
        ApiFuture<ListVmwareEngineNetworksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVmwareEngineNetworksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVmwareEngineNetworksRequest,
          ListVmwareEngineNetworksResponse,
          VmwareEngineNetwork,
          ListVmwareEngineNetworksPage,
          ListVmwareEngineNetworksFixedSizeCollection> {

    private ListVmwareEngineNetworksFixedSizeCollection(
        List<ListVmwareEngineNetworksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVmwareEngineNetworksFixedSizeCollection createEmptyCollection() {
      return new ListVmwareEngineNetworksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVmwareEngineNetworksFixedSizeCollection createCollection(
        List<ListVmwareEngineNetworksPage> pages, int collectionSize) {
      return new ListVmwareEngineNetworksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPrivateConnectionsPagedResponse
      extends AbstractPagedListResponse<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          PrivateConnection,
          ListPrivateConnectionsPage,
          ListPrivateConnectionsFixedSizeCollection> {

    public static ApiFuture<ListPrivateConnectionsPagedResponse> createAsync(
        PageContext<
                ListPrivateConnectionsRequest, ListPrivateConnectionsResponse, PrivateConnection>
            context,
        ApiFuture<ListPrivateConnectionsResponse> futureResponse) {
      ApiFuture<ListPrivateConnectionsPage> futurePage =
          ListPrivateConnectionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPrivateConnectionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPrivateConnectionsPagedResponse(ListPrivateConnectionsPage page) {
      super(page, ListPrivateConnectionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPrivateConnectionsPage
      extends AbstractPage<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          PrivateConnection,
          ListPrivateConnectionsPage> {

    private ListPrivateConnectionsPage(
        PageContext<
                ListPrivateConnectionsRequest, ListPrivateConnectionsResponse, PrivateConnection>
            context,
        ListPrivateConnectionsResponse response) {
      super(context, response);
    }

    private static ListPrivateConnectionsPage createEmptyPage() {
      return new ListPrivateConnectionsPage(null, null);
    }

    @Override
    protected ListPrivateConnectionsPage createPage(
        PageContext<
                ListPrivateConnectionsRequest, ListPrivateConnectionsResponse, PrivateConnection>
            context,
        ListPrivateConnectionsResponse response) {
      return new ListPrivateConnectionsPage(context, response);
    }

    @Override
    public ApiFuture<ListPrivateConnectionsPage> createPageAsync(
        PageContext<
                ListPrivateConnectionsRequest, ListPrivateConnectionsResponse, PrivateConnection>
            context,
        ApiFuture<ListPrivateConnectionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPrivateConnectionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          PrivateConnection,
          ListPrivateConnectionsPage,
          ListPrivateConnectionsFixedSizeCollection> {

    private ListPrivateConnectionsFixedSizeCollection(
        List<ListPrivateConnectionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPrivateConnectionsFixedSizeCollection createEmptyCollection() {
      return new ListPrivateConnectionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPrivateConnectionsFixedSizeCollection createCollection(
        List<ListPrivateConnectionsPage> pages, int collectionSize) {
      return new ListPrivateConnectionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPrivateConnectionPeeringRoutesPagedResponse
      extends AbstractPagedListResponse<
          ListPrivateConnectionPeeringRoutesRequest,
          ListPrivateConnectionPeeringRoutesResponse,
          PeeringRoute,
          ListPrivateConnectionPeeringRoutesPage,
          ListPrivateConnectionPeeringRoutesFixedSizeCollection> {

    public static ApiFuture<ListPrivateConnectionPeeringRoutesPagedResponse> createAsync(
        PageContext<
                ListPrivateConnectionPeeringRoutesRequest,
                ListPrivateConnectionPeeringRoutesResponse,
                PeeringRoute>
            context,
        ApiFuture<ListPrivateConnectionPeeringRoutesResponse> futureResponse) {
      ApiFuture<ListPrivateConnectionPeeringRoutesPage> futurePage =
          ListPrivateConnectionPeeringRoutesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPrivateConnectionPeeringRoutesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPrivateConnectionPeeringRoutesPagedResponse(
        ListPrivateConnectionPeeringRoutesPage page) {
      super(page, ListPrivateConnectionPeeringRoutesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPrivateConnectionPeeringRoutesPage
      extends AbstractPage<
          ListPrivateConnectionPeeringRoutesRequest,
          ListPrivateConnectionPeeringRoutesResponse,
          PeeringRoute,
          ListPrivateConnectionPeeringRoutesPage> {

    private ListPrivateConnectionPeeringRoutesPage(
        PageContext<
                ListPrivateConnectionPeeringRoutesRequest,
                ListPrivateConnectionPeeringRoutesResponse,
                PeeringRoute>
            context,
        ListPrivateConnectionPeeringRoutesResponse response) {
      super(context, response);
    }

    private static ListPrivateConnectionPeeringRoutesPage createEmptyPage() {
      return new ListPrivateConnectionPeeringRoutesPage(null, null);
    }

    @Override
    protected ListPrivateConnectionPeeringRoutesPage createPage(
        PageContext<
                ListPrivateConnectionPeeringRoutesRequest,
                ListPrivateConnectionPeeringRoutesResponse,
                PeeringRoute>
            context,
        ListPrivateConnectionPeeringRoutesResponse response) {
      return new ListPrivateConnectionPeeringRoutesPage(context, response);
    }

    @Override
    public ApiFuture<ListPrivateConnectionPeeringRoutesPage> createPageAsync(
        PageContext<
                ListPrivateConnectionPeeringRoutesRequest,
                ListPrivateConnectionPeeringRoutesResponse,
                PeeringRoute>
            context,
        ApiFuture<ListPrivateConnectionPeeringRoutesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPrivateConnectionPeeringRoutesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPrivateConnectionPeeringRoutesRequest,
          ListPrivateConnectionPeeringRoutesResponse,
          PeeringRoute,
          ListPrivateConnectionPeeringRoutesPage,
          ListPrivateConnectionPeeringRoutesFixedSizeCollection> {

    private ListPrivateConnectionPeeringRoutesFixedSizeCollection(
        List<ListPrivateConnectionPeeringRoutesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPrivateConnectionPeeringRoutesFixedSizeCollection createEmptyCollection() {
      return new ListPrivateConnectionPeeringRoutesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPrivateConnectionPeeringRoutesFixedSizeCollection createCollection(
        List<ListPrivateConnectionPeeringRoutesPage> pages, int collectionSize) {
      return new ListPrivateConnectionPeeringRoutesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
